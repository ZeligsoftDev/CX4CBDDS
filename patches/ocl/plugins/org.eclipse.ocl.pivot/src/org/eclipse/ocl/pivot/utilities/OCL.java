/*******************************************************************************
 * Copyright (c) 2010, 2021 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.ocl.pivot.internal.helper.HelperUtil;
import org.eclipse.ocl.pivot.internal.helper.OCLHelperImpl;
import org.eclipse.ocl.pivot.internal.helper.QueryImpl;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.OCLDebugOptions;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that binds the
 * Ecore metamodel to the superclass's generic type parameters.  This frees
 * client code from the long list of parameter substitutions.  This subclass
 * also provides a shortcut to creating an <code>OCL</code> on the shared
 * {@link EnvironmentFactoryInternal} instance.
 *
 * @see EnvironmentFactoryInternal
 */
public class OCL
{
	/**
	 * A very lightweight ProjectManager that provodes no access to external projects.
	 */
	public static final @NonNull ProjectManager NO_PROJECTS = BasicProjectManager.NO_PROJECTS;
	/**
	 * A heavyweight shared read-only ProjectManager that provides access to all external projects.
	 * When running standalone, the available projects are determined by analysis of plugin.xml
	 * files on the classpath. When running within Eclipse, the Eclipse workspace and extension points
	 * are used.
	 */
	public static final @NonNull ProjectManager CLASS_PATH = BasicProjectManager.CLASS_PATH;

	/**
	 * Creates a new <code>OCL</code> with a new heavyweight ProjectManager and a new
	 * ResourceSet for loaded models.
	 *
	 * Beware: this makes OCL responsible for cleaning up the ResourceSet in dispose, which results
	 * in unloading of all Resources. EMF Resource unloading can be very costly and is often totally
	 * unnecessary. These costs can be avoided by passing a ResourceSet to OCL.
	 */
	public static @NonNull OCL newInstance() {
		return OCLInternal.newInstance();
	}

	/**
	 * Creates a new <code>OCL</code> using the specified ProjectManager and a new
	 * ResourceSet for loaded models.
	 *
	 * Beware: this makes OCL responsible for cleaning up the ResourceSet in dispose, which results
	 * in unloading of all Resources. EMF Resource unloading can be very costly and is often totally
	 * unnecessary. These costs can be avoided by passing a ResourceSet to OCL.
	 */
	public static @NonNull OCL newInstance(@NonNull ProjectManager projectManager) {
		return OCLInternal.newInstance(projectManager, null);
	}

	/**
	 * Creates a new <code>OCL</code> using the specified ProjectManager and exploiting the
	 * already loaded models and configuration of ResourceSet.
	 */
	public static @NonNull OCL newInstance(@NonNull ProjectManager projectManager, @NonNull ResourceSet resourceSet) {
		OCL ocl = OCLInternal.newInstance(projectManager, resourceSet);
		//		ocl.getEnvironmentFactory().adapt(resourceSet);
		return ocl;
	}

	/**
	 * Creates a new <code>OCL</code> with a new heavyweight ProjectManager and exploiting the
	 * already loaded models and configuration of ResourceSet.
	 */
	public static @NonNull OCL newInstance(@NonNull ResourceSet resourceSet) {
		OCL ocl = OCLInternal.newInstance(BasicProjectManager.createDefaultProjectManager(), resourceSet);
		//		ocl.getEnvironmentFactory().adapt(resourceSet);
		return ocl;
	}

	/**
	 * Creates a new <code>OCL</code> instance using the specified Ecore package registry.
	 *
	 * Note that the returned {@link OCL} instance will use their own clean {@link ResourceSet}
	 *
	 * @see OCL#getResourceSet()
	 */
	public static @NonNull OCL newInstance(EPackage.@NonNull Registry ePackageRegistry) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.setPackageRegistry(ePackageRegistry);
		return newInstance(NO_PROJECTS, resourceSet);
	}

	/**
	 * Creates a new <code>OCL</code> using the specified Ecore environment
	 * factory.
	 *
	 * @param environmentFactory an environment factory for Ecore
	 * @return the new <code>OCL</code>
	 *
	 * @deprecated use environmentFactory.createOCL()
	 */
	@Deprecated
	public static @NonNull OCL newInstance(@NonNull EnvironmentFactory environmentFactory) {
		return environmentFactory.createOCL();
	}

	/**
	 * The EnvironmentFactory that can create objects and which provides the MetamodelManager, CompleteEnvironment and StandardLibrary.
	 * This is non-null until the OCL is disposed. Any subsequent usage will provoke NPEs.
	 */
	protected /*@NonNull*/ EnvironmentFactoryInternal environmentFactory;			// Set null once disposed, so NPE is use after dispose

	private @Nullable ModelManager modelManager;

	private boolean traceEvaluation = HelperUtil.shouldTrace(OCLDebugOptions.EVALUATION);

	/**
	 * Initializes me with my environment factory and root environment.
	 *
	 * @param environmentFactory
	 *            my environment factory
	 */
	protected OCL(@NonNull EnvironmentFactoryInternal environmentFactory) {
		this.environmentFactory = environmentFactory;
		environmentFactory.attach(this);
		environmentFactory.setEvaluationTracingEnabled(traceEvaluation);
	}

	/**
	 * Configure this OCL as the provider of the Endeactivation provided by deactivate().vironmentFactory for the current thread. This may be used to
	 * reverse the deactivation provided by deactivate().
	 *
	 * @since 1.14
	 */
	public void activate() {
		ThreadLocalExecutor.reset();
		assert environmentFactory != null;
		ThreadLocalExecutor.attachEnvironmentFactory(environmentFactory);
	}

	/**
	 * Update the CS resource from a asResource.
	 *
	 * For a first update, the csResource may be created by something like
	 * <p><tt>
	 * (BaseResource) resourceSet.createResource(outputURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
	 * </tt>
	 */
	public void as2cs(@NonNull ASResource asResource, @NonNull CSResource csResource) {
		csResource.updateFrom(asResource, getEnvironmentFactory());
	}

	/**
	 * Return the Ecore resource counterpart of a asResource, specifying the uri of the resulting Ecore resource.
	 */
	public @NonNull Resource as2ecore(@NonNull Resource asResource, @NonNull URI uri) throws IOException {
		assert environmentFactory != null;
		Resource ecoreResource = AS2Ecore.createResource(environmentFactory, asResource, uri, null);
		return ecoreResource;
	}

	/**
	 * Checks whether a constraint is satisfied by an object. If the constraint
	 * is an invariant constraint, then no additional variable bindings are
	 * required. If it is an operation precondition or postcondition, however,
	 * then the appropriate parameter variables and (in the postcondition case)
	 * result variable should be bound in the evaluation environment.
	 *
	 * @param context
	 *            the <tt>self</tt> object of the constraint
	 * @param constraint
	 *            the constraint to check
	 *
	 * @return whether the context object satisfies the constraint
	 *
	 * @see #check(Object, ExpressionInOCL)
	 * @see #evaluate(Object, ExpressionInOCL)
	 */
	public boolean check(Object context, @NonNull Constraint constraint) {
		LanguageExpression specification =  constraint.getOwnedSpecification();
		if (specification == null) {
			return false;
		}
		ExpressionInOCL query;
		try {
			query = ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
		} catch (ParserException e) {
			//			e.printStackTrace();
			return false;
		}
		return check(context, query);
	}

	/**
	 * Checks whether a constraint, specified simply as an OCL expression, is
	 * satisfied by an object. If the constraint is an invariant constraint,
	 * then no additional variable bindings are required. If it is an operation
	 * precondition or postcondition, however, then the appropriate parameter
	 * variables and (in the postcondition case) result variable should be bound
	 * in the evaluation environment.
	 *
	 * @param context
	 *            the <tt>self</tt> object of the constraint
	 * @param specification
	 *            the constraint to check, which must be a boolean-valued
	 *            expression
	 *
	 * @return whether the context object satisfies the constraint
	 *
	 * @see #check(Object, ExpressionInOCL)
	 * @see #evaluate(Object, ExpressionInOCL)
	 *
	 * @throws IllegalArgumentException
	 *             if the constraint expression is not boolean-valued
	 */
	public boolean check(Object context, @NonNull ExpressionInOCL specification) {
		if (specification.getOwnedBody().getTypeId() != TypeId.BOOLEAN) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		try {
			Object result = evaluate(context, specification);
			return result == ValueUtil.TRUE_VALUE;
		} catch (InvalidValueException e) {
			return false;
		}
	}

	/**
	 * Creates a new evaluation visitor, for the evaluation of an OCL expression in a context.
	 * The evaluationVisitor reuses any previously established ModelManager.
	 */
	public @NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Object context, @NonNull ExpressionInOCL expression) {
		return environmentFactory.createEvaluationVisitor(context, expression, modelManager);
	}

	/**
	 * Parse oclExpression using selfType as the type of each run-time self object.
	 * @throws ParserException
	 */
	public @NonNull ExpressionInOCL createInvariant(@NonNull EObject contextElement, @NonNull String oclExpression) throws ParserException {
		return createOCLHelper(contextElement).createInvariant(oclExpression);
	}

	public ExpressionInOCL createPostcondition(@NonNull EOperation contextOperation, @NonNull String oclExpression) throws ParserException {
		return createOCLHelper(contextOperation).createPostcondition(oclExpression);
	}

	/**
	 * Creates a new {@link OCLHelper} instance for convenient parsing of
	 * embedded constraints and query expressions for the specified context
	 * which may be an Ecore EClassifier/EOperation/EStructuralFeature or
	 * or Pivot Class/Operation/Property.
	 *
	 * @return a new helper object
	 */
	public @NonNull OCLHelper createOCLHelper(@Nullable EObject contextElement) throws ParserException {
		return new OCLHelperImpl(this, contextElement);
	}

	public @NonNull ExpressionInOCL createQuery(@Nullable EObject contextElement, @NonNull String oclExpression) throws ParserException {
		return createOCLHelper(contextElement).createQuery(oclExpression);
	}

	/**
	 * Creates a new {@link Query} encapsulating a query expression with the
	 * current environment and extent map. This is convenient for repeated
	 * evaluation of expressions and for filtering/transforming objects using a
	 * query or constraint expression.
	 * <p>
	 * Every query maintains its own evaluation environment, which enables
	 * concurrent evaluation (where this may be safe in an EMF-based model) and
	 * different bindings for client-supplied "global" variables.
	 * </p>
	 *
	 * @param query
	 *            the OCL query expression, which may be interpreted as a
	 *            constraint if it is boolean-valued
	 *
	 * @return the new query object
	 */
	public @NonNull Query createQuery(@NonNull ExpressionInOCL query) {
		return new QueryImpl(this, query);
	}

	/**
	 * Creates a new {@link Query} encapsulating a constraint with the current
	 * environment and extent map. This is convenient for repeated evaluation of
	 * constraints and for filtering objects using the constraint expression.
	 * <p>
	 * Every query maintains its own evaluation environment, which enables
	 * concurrent evaluation (where this may be safe in an EMF-based model) and
	 * different bindings for client-supplied "global" variables.
	 * </p>
	 *
	 * @param constraint
	 *            the OCL constraint
	 *
	 * @return the new query object
	 * @throws ParserException
	 *
	 * @see #createQuery(ExpressionInOCL)
	 */
	public Query createQuery(@NonNull Constraint constraint) throws ParserException {
		LanguageExpression specification = ClassUtil.nonNullState(constraint.getOwnedSpecification());
		ExpressionInOCL query = ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
		return new QueryImpl(this, query);
	}

	/**
	 * Return the Pivot resource counterpart of an Xtext csResource.
	 */
	public @NonNull ASResource cs2as(@NonNull CSResource csResource) {
		ASResource asResource = csResource.getASResource();
		return asResource;
	}

	/**
	 * Remove the construction/activate() configuration of this OCL as the provider of the vironmentFactory for the current thread.
	 * This may be used to allow another OCL to be used for perhaps a nested validation, or to switch between concurrent OCLs that
	 * provide perhaps competing new/old functionality.
	 *
	 * @since 1.14
	 */
	public void deactivate() {
		if (environmentFactory != null) {
			ThreadLocalExecutor.detachEnvironmentFactory(environmentFactory);
		}
	}

	/**
	 * <p>Disposes any objects that I have created while I have been in use. This
	 * detaches the {@link OCL} instance from the corresponding environment
	 * factory which will release its resources once there are no further
	 * attached OCL clients.</p>
	 * <p>dispose() should be invoked to release resources promptly. If a call to dispose() is
	 * omitted, finalize() will detach() when garbage collection of the OCL instance occurs.</p>
	 */
	public synchronized void dispose() {
		EnvironmentFactoryInternal environmentFactory2 = environmentFactory;
		if (environmentFactory2 != null) {
			environmentFactory = null;
			environmentFactory2.detach(this);
			environmentFactory2.detachRedundantThreadLocal();
		}
	}

	/**
	 * Dsipose this OCL and if force, give other threads a chance to run simple finalizers before dispose() happens.
	 *
	 * @since 1.17
	 */
	public void dispose(boolean force) {
		EnvironmentFactoryInternal environmentFactory2 = environmentFactory;
		if (environmentFactory2 != null) {
			if (force) {
				environmentFactory2.preDispose();
			}
			dispose();
		}
	}

	/**
	 * Return the Pivot resource counterpart of an ecoreResource.
	 */
	public @NonNull ASResource ecore2as(@NonNull Resource ecoreResource) throws ParserException {
		assert environmentFactory != null;
		Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreResource, environmentFactory);
		Model pivotModel = ecore2as.getASModel();
		ASResource asResource = (ASResource) pivotModel.eResource();
		return ClassUtil.nonNullModel(asResource);
	}

	/**
	 * Evaluates a query expression on a context object (which is bound to the
	 * <tt>self</tt> variable).
	 *
	 * @param context
	 *            the context (self) object
	 * @param expression
	 *            the OCL expression to evaluate
	 *
	 * @return the value of the expression, or <tt>OclInvalid</tt> if the
	 *         evaluation fails for reasons other than a run-time exception
	 *
	 * @see #check(Object, ExpressionInOCL)
	 */
	public @Nullable Object evaluate(@Nullable Object context, @NonNull ExpressionInOCL expression) {
		assert ThreadLocalExecutor.basicGetExecutor() == null;
		EvaluationVisitor evaluationVisitor = createEvaluationVisitor(context, expression);
		assert ThreadLocalExecutor.basicGetExecutor() instanceof ExecutorInternal;
		try {
			return expression.accept(evaluationVisitor);
		}
		finally {
			ThreadLocalExecutor.setExecutor(null);
		}
	}

	/**
	 * If the user neglects to dispose(), then detach() the EnvironmentFactory to give it a chance to clean up.
	 */
	@Override
	public synchronized void finalize() {
		EnvironmentFactoryInternal environmentFactory2 = environmentFactory;
		if (environmentFactory2 != null) {
			environmentFactory = null;
			environmentFactory2.detach(this);
		}
	}

	public @NonNull CSResource getCSResource(@NonNull URI uri) throws IOException {
		Resource resource = getResourceSet().createResource(uri);
		if (!(resource instanceof CSResource)) {
			String doSetup = environmentFactory.getDoSetupName(uri);
			if (doSetup != null) {
				throw new IllegalStateException("Use of Xtext parsing of '" + uri + "' requires use of " + doSetup);
			}
			else {
				throw new IllegalStateException("No Xtext parsing support registered for '" + uri + "'");
			}
		}
		CSResource csResource = (CSResource) resource;
		getEnvironmentFactory().adapt(csResource);
		csResource.load(null);
		return csResource;
	}

	public @NonNull CSResource getCSResource(@NonNull URI uri, @NonNull InputStream inputStream) throws IOException {
		Resource resource = new ResourceSetImpl().createResource(uri);
		if (!(resource instanceof CSResource)) {
			String doSetup = environmentFactory.getDoSetupName(uri);
			if (doSetup != null) {
				throw new IllegalStateException("Use of Xtext parsing of '" + uri + "' requires use of " + doSetup);
			}
			else {
				throw new IllegalStateException("No Xtext parsing support registered for '" + uri + "'");
			}
		}
		CSResource csResource = (CSResource) resource;
		getEnvironmentFactory().adapt(csResource);
		csResource.load(inputStream, null);
		return csResource;
	}

	public @NonNull CSResource getCSResource(@NonNull URI uri, @NonNull String testDocument) throws IOException {
		InputStream inputStream = new URIConverter.ReadableInputStream(testDocument, "UTF-8");
		return getCSResource(uri, inputStream);
	}

	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return environmentFactory.getCompleteEnvironment();
	}

	public org.eclipse.ocl.pivot.@NonNull Class getContextType(@Nullable Object contextObject) {
		MetamodelManagerInternal metamodelManager = environmentFactory.getMetamodelManager();
		IdResolver idResolver = getIdResolver();
		org.eclipse.ocl.pivot.Class staticTypeOf = idResolver.getStaticTypeOfValue(null, contextObject);
		return metamodelManager.getPrimaryClass(staticTypeOf);
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		assert environmentFactory != null;
		return environmentFactory;
	}

	public @NonNull IdResolver getIdResolver() {
		return environmentFactory.getIdResolver();
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	/**
	 * Obtains the model manager, if any, provided by the client to customize the
	 * evaluation of constraints.
	 *
	 * @return the client-provided custom model manager, or <code>null</code> if
	 *         thie OCL is using the default dynamic extent map implementation
	 */
	public @Nullable ModelManager getModelManager() {
		return modelManager;
	}

	public EPackage.@NonNull Registry getPackageRegistry() {
		return ClassUtil.nonNullEMF(getResourceSet().getPackageRegistry());
	}

	public @NonNull ProjectManager getProjectManager() {
		return environmentFactory.getProjectManager();
	}

	public @NonNull ResourceSet getResourceSet() {
		return environmentFactory.getResourceSet();
	}

	/**
	 * Return the Constraint specification as an ExpressionInOCL, parsing any OpaqueExpression
	 * that may be encountered.
	 */
	public @Nullable ExpressionInOCL getSpecification(@NonNull Constraint constraint) throws ParserException {
		LanguageExpression specification = constraint.getOwnedSpecification();
		if (specification == null) {
			return null;
		}
		if (specification instanceof ExpressionInOCL) {
			ExpressionInOCL query = (ExpressionInOCL)specification;
			if ((query.getOwnedBody() != null) || (query.getBody() == null)) {
				return query;
			}
		}
		return ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	/**
	 * Queries whether tracing of evaluation is enabled. Tracing logs the
	 * progress of evaluation to the console, which may be of use in diagnosing
	 * problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 *
	 * @return whether evaluation tracing is enabled
	 *
	 * @see #setEvaluationTracingEnabled(boolean)
	 */
	@Deprecated // Has no functionality
	public boolean isEvaluationTracingEnabled() {
		return traceEvaluation;
	}

	/**
	 * Load the Complete OCL document specified by the URI into the external ResourceSet and
	 * return the concrete syntax resource.
	 */
	@Deprecated // Use getCSResource
	public @Nullable CSResource load(@NonNull URI uri) {
		ResourceSet externalResourceSet = getResourceSet();
		return (CSResource) externalResourceSet.getResource(uri, true);
	}

	/**
	 * Load the Complete OCL document specified by the URI into the external ResourceSet and
	 * parse the concrete syntax resource returning the resulting abstract syntax resource.
	 */
	public @Nullable ASResource parse(@NonNull URI uri) {
		CSResource csResource = load(uri);
		return csResource != null ? cs2as(csResource) : null;
	}

	/**
	 * Convert the specification of an OCL expression from textual CS form to parsed executable AS form. The textual form typically
	 * results from simple construction from source text or a UML OpaqueExpression.
	 * <p>
	 * The returned object may be the same object as the specification, but with the more derived type to signify successful conversion
	 * from textual to executable form. Redundant re-invocation of parseSpecification is harmless.
	 * <p>
	 * The specification's container, typically a Constraint or Operation is used as the contextElement to determine self within the expression.
	 *
	 * @throws ParserException if text parsing fails
	 */
	public @NonNull ExpressionInOCL parseSpecification(@NonNull LanguageExpression specification) throws ParserException {
		return ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
	}
	/**
	 * @throws ParserException
	 * @deprecated use parseSpecification(specification)
	 */
	@Deprecated
	public @NonNull ExpressionInOCL parseSpecification(@Nullable Object unusedObject, @NonNull LanguageExpression specification) throws ParserException {
		return ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
	}

	/**
	 * Sets whether tracing of evaluation is enabled. Tracing logs the progress
	 * of parsing to the console, which may be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 *
	 * @param b
	 *            whether evaluation tracing is enabled
	 *
	 * @see #isEvaluationTracingEnabled()
	 */
	@Deprecated // Has no functionality
	public void setEvaluationTracingEnabled(boolean b) {
		traceEvaluation = b;
		environmentFactory.setEvaluationTracingEnabled(traceEvaluation);
	}

	/**
	 * Assigns a custom extent map to define the extents of classes in
	 * evaluation of OCL constraints. This is only needed if the default dynamic
	 * extent-map implementation is not suitable.
	 *
	 * @param modelManager
	 *            a custom extent map, or <code>null</code> to use the default
	 *            dynamic extent map implementation
	 */
	public void setModelManager(@Nullable ModelManager modelManager) {
		this.modelManager = modelManager;
	}

	/**
	 * Validates an OCL expression, which may have been loaded from some
	 * resource or constructed via the API (perhaps by translation from some
	 * other language).
	 *
	 * @param expression
	 *            an expression to validate
	 *
	 * @throws SemanticException
	 *             on detection of any well-formedness problem in the expression
	 *
	 * @see #validate(Constraint)
	 */
	@Deprecated // Has no functionality
	public void validate(@NonNull OCLExpression expression) throws SemanticException {
		throw new UnsupportedOperationException(getClass().getName() + ".validate");
		// clear out old diagnostics
		/*		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment,
			ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}

		expression.accept(ValidationVisitor.getInstance(rootEnvironment));

		if (ph != null) {
			ph.endValidation();

			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		} */
	}

	/**
	 * Validates an OCL constraint, which may have been loaded from some
	 * resource or constructed via the API (perhaps by translation from some
	 * other language).
	 *
	 * @param constraint
	 *            a constraint to validate
	 *
	 * @throws SemanticException
	 *             on detection of any well-formedness problem in the constraint
	 */
	@Deprecated // Has no functionality
	public void validate(@NonNull Constraint constraint) throws SemanticException {
		throw new UnsupportedOperationException(getClass().getName() + ".validate");
		// clear out old diagnostics
		/*		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment,
			ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}

		ValidationVisitor.getInstance(rootEnvironment).visitConstraint(
			constraint);

		if (ph != null) {
			ph.endValidation();

			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		} */
	}
}
