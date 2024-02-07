/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Slot;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.context.ClassContext;
import org.eclipse.ocl.pivot.internal.context.ModelContext;
import org.eclipse.ocl.pivot.internal.context.OperationContext;
import org.eclipse.ocl.pivot.internal.context.PropertyContext;
import org.eclipse.ocl.pivot.internal.ecore.EcoreASResourceFactory;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractCustomizable;
import org.eclipse.ocl.pivot.internal.evaluation.BasicOCLExecutor;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.library.executor.LazyEcoreModelManager;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.ContentTypeFirstResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.resource.ICSI2ASMapping;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.GlobalEnvironmentFactory;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.internal.utilities.Technology;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.options.PivotValidationOptions;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.values.ObjectValue;

/**
 * Partial implementation of the {@link EnvironmentFactoryInternal} interface, useful
 * for subclassing to define the Pivot binding for a metamodel.
 */
public abstract class AbstractEnvironmentFactory extends AbstractCustomizable implements EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension
{
	/**
	 * @since 1.4
	 */
	public static final @NonNull TracingOption ENVIRONMENT_FACTORY_ATTACH = new TracingOption(PivotPlugin.PLUGIN_ID, "environmentFactory/attach");

	private boolean traceEvaluation;
	protected final @NonNull ProjectManager projectManager;
	protected final @NonNull ResourceSet externalResourceSet;
	private final @NonNull ResourceSet asResourceSet;
	protected final boolean externalResourceSetWasNull;
	private /*@LazyNonNull*/ PivotMetamodelManager metamodelManager = null;
	private final @NonNull CompleteEnvironmentInternal completeEnvironment;
	private final @NonNull StandardLibraryInternal standardLibrary;
	private @Nullable ICSI2ASMapping csi2asMapping;
	/**
	 * The known packages.
	 */
	private final @NonNull CompleteModelInternal completeModel;

	private /*@LazyNonNull*/ IdResolver idResolver;

	/**
	 * Count of the number of OCL instances that are using the EnvironmentFactory. auto-disposes on count down to zero.
	 * -ve once disposed.
	 */
	private int attachCount = 0;

	/**
	 * Debug lust of the System.identityHashCode of each active owners of an attach
	 *
	 * System.identityHashCode avoids problmes with finalized attachOwners.
	 */
	private List<@NonNull Integer> attachOwners = new ArrayList<>();

	private @NonNull Technology technology = ASResourceFactoryRegistry.INSTANCE.getTechnology();

	/**
	 * Configuration of validation preferences.
	 */
	private /*LazyNonNull*/ Map<Object, StatusCodes.Severity> validationKey2severity = null;

	/**
	 * Leak debugging aid. Set non-null to diagnose EnvironmentFactory construction and finalization.
	 *
	 * @since 1.14
	 */
	public static WeakHashMap<@NonNull AbstractEnvironmentFactory, @Nullable Object> liveEnvironmentFactories = null;

	/**
	 * @since 1.7
	 */
	public static int CONSTRUCTION_COUNT = 0;

	@Deprecated /* @deprecated supply null asResourceSet argument */
	protected AbstractEnvironmentFactory(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {
		this(projectManager, externalResourceSet, null);
	}

	/**
	 * @since 1.10
	 */
	protected AbstractEnvironmentFactory(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet, @Nullable ResourceSet asResourceSet) {
		CONSTRUCTION_COUNT++;
		if (liveEnvironmentFactories != null) {
			liveEnvironmentFactories.put(this, null);
			PivotUtilInternal.debugPrintln("Create " + NameUtil.debugSimpleName(this)
			+ " " + NameUtil.debugSimpleName(externalResourceSet) + " " + NameUtil.debugSimpleName(asResourceSet));
		}
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {			// This is the unique start point for OCL so
			PivotStandaloneSetup.doSetup();				//  do the non-UI initialization (guarded in doSetup())
		}
		this.projectManager = projectManager;
		if (asResourceSet == null) {
			asResourceSet = createASResourceSet();
		}
		this.asResourceSet = asResourceSet;
		if (externalResourceSet != null) {
			this.externalResourceSetWasNull = false;
			this.externalResourceSet = externalResourceSet;
			ASResourceFactoryRegistry.INSTANCE.configureResourceSets(null, asResourceSet);
		}
		else {
			this.externalResourceSetWasNull = true;
			this.externalResourceSet = externalResourceSet = new ResourceSetImpl();
			projectManager.initializeResourceSet(externalResourceSet);
			Map<String, Object> extensionToFactoryMap = externalResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$
			extensionToFactoryMap.put("emof", new EMOFResourceFactoryImpl()); //$NON-NLS-1$
			ASResourceFactoryRegistry.INSTANCE.configureResourceSets(asResourceSet, externalResourceSet);
		}
		if (ENVIRONMENT_FACTORY_ATTACH.isActive()) {
			ENVIRONMENT_FACTORY_ATTACH.println("[" + Thread.currentThread().getName() + "] Create(" + attachCount + ") " + NameUtil.debugSimpleName(this) + " => " + NameUtil.debugSimpleName(externalResourceSet));
		}
		adapt(externalResourceSet);
		this.completeEnvironment = createCompleteEnvironment();
		this.standardLibrary = completeEnvironment.getOwnedStandardLibrary();
		this.completeModel = completeEnvironment.getOwnedCompleteModel();
		PivotUtil.initializeLoadOptionsToSupportSelfReferences(getResourceSet());
		ThreadLocalExecutor.attachEnvironmentFactory(this);
	}

	@Override
	public @NonNull EnvironmentFactoryAdapter adapt(@NonNull Notifier notifier) {
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(notifier.eAdapters());
		EnvironmentFactoryAdapter adapter = ClassUtil.getAdapter(EnvironmentFactoryAdapter.class, eAdapters);
		if (adapter != null) {
			if (adapter.getEnvironmentFactory() != this) {
				adapter = null;
			}
		}
		if (adapter == null) {
			adapter = new EnvironmentFactoryAdapter(this, notifier);
			eAdapters.add(adapter);
		}
		return adapter;
	}

	@Override
	public void addExternal2AS(@NonNull External2AS external2as) {
		Resource resource = external2as.getResource();
		if ((resource != null) && ClassUtil.isRegistered(resource)) {
			ResourceSet externalResourceSet2 = getResourceSet();
			projectManager.useGeneratedResource(resource, externalResourceSet2);
		}
		getMetamodelManager().addExternal2AS(external2as);
	}

	/**
	 * Add all resources in ResourceSet to the externalResourceSet.
	 */
	@Override
	public void addExternalResources(@NonNull ResourceSet resourceSet) {
		ResourceSet externalResourceSet = getResourceSet();
		if (externalResourceSet instanceof ResourceSetImpl) {
			Map<URI, Resource> uriResourceMap = ((ResourceSetImpl)externalResourceSet).getURIResourceMap();
			if (uriResourceMap != null) {
				for (Resource eResource : resourceSet.getResources()) {
					URI uri = eResource.getURI();
					if (uri != null) {
						uriResourceMap.put(uri, eResource);
					}
				}
				if (resourceSet instanceof ResourceSetImpl) {
					Map<URI, Resource> contextResourceMap = ((ResourceSetImpl)resourceSet).getURIResourceMap();
					if ((contextResourceMap != null) && (contextResourceMap != uriResourceMap)) {
						for (URI uri : contextResourceMap.keySet()) {
							uriResourceMap.put(uri, contextResourceMap.get(uri));
						}
					}
				}
			}
		}
	}

	@Override
	public void analyzeExpressions(@NonNull EObject eRootObject,
			@NonNull Set<@NonNull CompleteClass> allInstancesCompleteClasses, @NonNull Set<@NonNull Property> implicitOppositeProperties) {
		Type oclElementType = standardLibrary.getOclElementType();
		Type classType = standardLibrary.getClassType();
		OperationId allInstancesOperationId = classType.getTypeId().getOperationId(0, "allInstances", IdManager.getParametersId());
		for (EObject eObject : new TreeIterable(eRootObject, true)) {
			if (eObject instanceof OppositePropertyCallExp) {
				OppositePropertyCallExp oppositePropertyCallExp = (OppositePropertyCallExp)eObject;
				Property navigableProperty = oppositePropertyCallExp.getReferredProperty();
				if ((navigableProperty != null) && !navigableProperty.isIsComposite()) {
					implicitOppositeProperties.add(navigableProperty);
				}
			}
			else if (eObject instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp)eObject;
				Operation referredOperation = operationCallExp.getReferredOperation();
				if (referredOperation != null) {
					OperationId operationId = referredOperation.getOperationId();
					if (operationId == allInstancesOperationId) {
						OCLExpression source = operationCallExp.getOwnedSource();
						if (source != null) {
							Type asType = source.getTypeValue();
							if (asType == null) {
								asType = source.getType();
							}
							if (asType instanceof org.eclipse.ocl.pivot.Class) {
								assert !(asType instanceof PrimitiveType);
								assert !(asType instanceof CollectionType);
								CompleteClass completeClass = completeModel.getCompleteClass(asType);
								allInstancesCompleteClasses.add(completeClass);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public synchronized void attach(@NonNull Object attachOwner) {
		EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
		assert (environmentFactory == null) || (environmentFactory == this) : "[" + Thread.currentThread().getName() + "] " + NameUtil.debugSimpleName(this) + " should be " + NameUtil.debugSimpleName(environmentFactory);
		if (isDisposed()) {
			if (ENVIRONMENT_FACTORY_ATTACH.isActive()) {
				ENVIRONMENT_FACTORY_ATTACH.println("[" + Thread.currentThread().getName() + "] Attach(" + attachCount + ") " + NameUtil.debugSimpleName(this) + " " + NameUtil.debugSimpleName(attachOwner));
			}
			throw new IllegalStateException(getClass().getName() + " disposed");
		}
		attachCount++;
		attachOwners.add(System.identityHashCode(attachOwner));
		if (ENVIRONMENT_FACTORY_ATTACH.isActive()) {
			ENVIRONMENT_FACTORY_ATTACH.println("[" + Thread.currentThread().getName() + "] Attach(" + (attachCount-1) + ":" + attachCount + ") " + NameUtil.debugSimpleName(this) + " " + NameUtil.debugSimpleName(attachOwner));
		}
	}

	protected @Nullable PivotMetamodelManager basicGetMetamodelManager() {
		return metamodelManager;
	}

	@Override
	public void configureLoadFirstStrategy() {
		configureLoadStrategy(StandaloneProjectMap.LoadFirstStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
	}

	@Override
	public void configureLoadStrategy(ProjectManager.@NonNull IResourceLoadStrategy packageLoadStrategy, ProjectManager.@Nullable IConflictHandler conflictHandler) {
		ResourceSet externalResourceSet = getResourceSet();
		projectManager.configure(externalResourceSet, packageLoadStrategy, conflictHandler);
	}

	@Override
	public @NonNull ResourceSetImpl createASResourceSet() {
		ResourceSetImpl asResourceSet = new ResourceSetImpl();
		asResourceSet.setResourceFactoryRegistry(new ContentTypeFirstResourceFactoryRegistry(asResourceSet));
	//	StandaloneProjectMap.initializeURIResourceMap(asResourceSet);
		EPackage.Registry packageRegistry = asResourceSet.getPackageRegistry();
	//	packageRegistry.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
		projectManager.initializeResourceSet(asResourceSet);
		packageRegistry.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
		return asResourceSet;
	}

	@Override
	public @NonNull CompleteEnvironmentInternal createCompleteEnvironment() {
		CompleteEnvironmentInternal completeEnvironment = (CompleteEnvironmentInternal)PivotFactory.eINSTANCE.createCompleteEnvironment();
		completeEnvironment.init(this);
		return completeEnvironment;
	}

	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull NamedElement executableObject, @NonNull ModelManager modelManager) {
		Executor executor = ThreadLocalExecutor.basicGetExecutor();
		assert executor == null;
		executor = createExecutor(modelManager);
//		Executor executor = ThreadLocalExecutor.basicGetExecutor();
		assert executor != null;
		ExecutorInternal interpretedExecutor = executor.basicGetInterpretedExecutor();
		assert interpretedExecutor != null;
		assert interpretedExecutor.getModelManager() == modelManager;
		return interpretedExecutor.initializeEvaluationEnvironment(executableObject);
	}

	/** @deprecated no longer used */
	@Deprecated
	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent, @NonNull NamedElement executableObject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Object context, @NonNull ExpressionInOCL expression, @Nullable ModelManager modelManager) {
		ThreadLocalExecutor.setExecutor(null);					// Eliminate obsolete dropping from previous EvaluationVisitor
		if (modelManager == null) {
			// let the evaluation environment create one
			modelManager = createModelManager(context);
		}
		// can determine a more appropriate context from the context
		// variable of the expression, to account for stereotype constraints
		//		context = HelperUtil.getConstraintContext(rootEnvironment, context, expression);
		ExecutorInternal executorInternal = createExecutor(modelManager);
		EvaluationEnvironment evaluationEnvironment = executorInternal.initializeEvaluationEnvironment(expression);
		Variable contextVariable = expression.getOwnedContext();
		if (contextVariable != null) {
			IdResolver idResolver = getIdResolver();
			Object value = idResolver.boxedValueOf(context);
			evaluationEnvironment.add(contextVariable, value);
		}
		for (Variable parameterVariable : expression.getOwnedParameters()) {
			if (parameterVariable != null) {
				evaluationEnvironment.add(parameterVariable, null);
			}
		}
		return executorInternal.getEvaluationVisitor();
	}

	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@NonNull EvaluationEnvironment evaluationEnvironment) {
		ExecutorInternal executor = ((EvaluationEnvironment.EvaluationEnvironmentExtension)evaluationEnvironment).getExecutor();
		return executor.getEvaluationVisitor();
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull ExecutorInternal createExecutor(@NonNull ModelManager modelManager) {
		Executor executor = ThreadLocalExecutor.basicGetExecutor();
		ExecutorInternal interpretedExecutor = executor != null ? executor.basicGetInterpretedExecutor() : null;
		if (executor == null) {
//			interpretedExecutor = new BasicOCLExecutor(this, modelManager);
//			executor.setInterpretedExecutor(interpretedExecutor);
		}
		else {
			assert executor.getModelManager() == modelManager;
			if (executor != interpretedExecutor) {
				executor.setInterpretedExecutor(interpretedExecutor);
			}
		}
		if (interpretedExecutor == null) {
			interpretedExecutor = new BasicOCLExecutor(this, modelManager);
			if (executor == null) {
				ThreadLocalExecutor.setExecutor(interpretedExecutor);
			}
			else {
				executor.setInterpretedExecutor(interpretedExecutor);
			}
		}


/*		if (executor != null) {
			ExecutorInternal interpretedExecutor = executor.basicGetInterpretedExecutor();
		//	assert interpretedExecutor == null;
		}
		BasicOCLExecutor interpretedExecutor = new BasicOCLExecutor(this, modelManager);
		if (executor == null) {
			ThreadLocalExecutor.setExecutor(interpretedExecutor);
		}
		else {
			executor.setInterpretedExecutor(interpretedExecutor);
		} */
		return interpretedExecutor;
	}

	/**
	 * @since 1.7
	 */
	@Override
	public @NonNull FlowAnalysis createFlowAnalysis(@NonNull OCLExpression contextExpression) {
		return new FlowAnalysis(this, contextExpression);
	}

	@Override
	public  @NonNull IdResolver createIdResolver() {
		return technology.createIdResolver(this);
	}

	@Override
	public @NonNull ImplementationManager createImplementationManager() {
		return new ImplementationManager(this);
	}

	@Override
	public @NonNull PivotMetamodelManager createMetamodelManager() {
		assert metamodelManager == null;
		metamodelManager = new PivotMetamodelManager(this, asResourceSet);
		assert metamodelManager != null;
		return metamodelManager;
	}

	protected @NonNull ModelManager createModelManager() {
		return ModelManager.NULL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NonNull ModelManager createModelManager(@Nullable Object object) {
		if (object instanceof ObjectValue) {
			object = ((ObjectValue) object).getObject();
		}
		if (object instanceof EObject) {
			return new LazyEcoreModelManager((EObject)object);
		}
		return ModelManager.NULL;
	}

	@Override
	public @NonNull OCLInternal createOCL() {
		return new OCLInternal(this);
	}

	@Deprecated /* @deprecated not used - use createParserContext(@NonNull Element) */
	@Override
	public @NonNull ParserContext createParserContext(@Nullable EObject context) throws ParserException {
		if (context instanceof Element) {
			ParserContext parserContext = createParserContext((Element)context);
			if (parserContext != null) {
				return parserContext;
			}
		}
		return new ModelContext(this, null);
	}

	/**
	 * Return a ParserContext suitable for parsing OCL expressions in the context of a pivot element.
	 *
	 * @since 1.4
	 */
	@Override
	public @Nullable ParserContext createParserContext(@NonNull Element element) {
		Element pivotElement = element;
		if (element instanceof ExpressionInOCL) {
			EObject pivotContainer = pivotElement.eContainer();
			if (pivotContainer instanceof Operation) {							// Operation.bodyExpression
				Operation pivotOperation = (Operation) pivotContainer;
				return new OperationContext(this, null, pivotOperation, null);
			}
			if (pivotContainer instanceof Property) {
				Property pivotProperty = (Property) pivotContainer;
				return new PropertyContext(this, null, pivotProperty);
			}
			if (pivotContainer instanceof Constraint) {							// Operation.pre/postCondition
				EObject pivotContainerContainer = pivotContainer.eContainer();
				if (pivotContainerContainer instanceof Operation) {
					Operation pivotOperation = (Operation) pivotContainerContainer;
					String resultName = null;
					if (pivotOperation.getOwnedPostconditions().contains(pivotContainer)) {
						Type resultType = pivotOperation.getType();
						if ((resultType != null) && !(resultType instanceof VoidType)) {
							resultName = PivotConstants.RESULT_NAME;
						}
					}
					return new OperationContext(this, null, pivotOperation, resultName);
				}
				if (pivotContainerContainer instanceof org.eclipse.ocl.pivot.Class) {
					org.eclipse.ocl.pivot.Class pivotType = (org.eclipse.ocl.pivot.Class) pivotContainerContainer;
					return new ClassContext(this, null, pivotType, null);
				}
			}
			if (pivotContainer instanceof Slot) {
				Property asDefiningFeature = ((Slot)pivotContainer).getDefiningProperty();
				if (asDefiningFeature != null) {
					org.eclipse.ocl.pivot.Class pivotType = asDefiningFeature.getOwningClass();
					if (pivotType != null) {
						return new ClassContext(this, null, pivotType, null);
					}
				}
			}
		}
		//
		//	The JUnit tests are satisfied by the new code above. The following provides legacy support, perhaps satisfying unusual invocations
		//
		if (pivotElement instanceof Constraint) {
			EObject pivotContainer = pivotElement.eContainer();
			if (pivotContainer instanceof Operation) {
				Operation pivotOperation = (Operation) pivotContainer;
				String resultName = null;
				if (pivotOperation.getOwnedPostconditions().contains(pivotElement)) {
					Type resultType = pivotOperation.getType();
					if ((resultType != null) && !(resultType instanceof VoidType)) {
						resultName = PivotConstants.RESULT_NAME;
					}
				}
				return new OperationContext(this, null, pivotOperation, resultName);
			}
		}

		if (pivotElement instanceof Property) {
			return new PropertyContext(this, null, (Property) pivotElement);
		}
		else if (pivotElement instanceof Operation) {
			return new OperationContext(this, null, (Operation) pivotElement, null);
		}
		else if (pivotElement instanceof OppositePropertyCallExp) {
			Property referredOppositeProperty = ((OppositePropertyCallExp) pivotElement).getReferredProperty();
			if (referredOppositeProperty != null) {
				Property referredProperty = referredOppositeProperty.getOpposite();
				if (referredProperty != null) {
					return new PropertyContext(this, null, referredProperty);
				}
			}
		}
		else if (pivotElement instanceof PropertyCallExp) {
			Property referredProperty = ((PropertyCallExp) pivotElement).getReferredProperty();
			if (referredProperty != null) {
				return new PropertyContext(this, null, referredProperty);
			}
		}
		else if (pivotElement instanceof OperationCallExp) {
			Operation referredOperation = ((OperationCallExp) pivotElement).getReferredOperation();
			if (referredOperation != null) {
				return new OperationContext(this, null, referredOperation, null);
			}
		}
		else if (pivotElement instanceof LoopExp) {
			Iteration referredIteration = ((LoopExp) pivotElement).getReferredIteration();
			if (referredIteration != null) {
				return new OperationContext(this, null, referredIteration, null);
			}
		}
		//		else if (pivotElement instanceof Stereotype) {
		//			Stereotype pivotStereotype = (Stereotype) pivotElement;
		//			return new ClassContext(this, null, pivotStereotype);
		//		}
		//		else if (pivotElement instanceof org.eclipse.ocl.pivot.Class) {
		//			org.eclipse.ocl.pivot.Class pivotClass = (org.eclipse.ocl.pivot.Class) pivotElement;
		////			Metaclass<?> metaClass = getMetaclass(pivotClass);
		//			return new ClassContext(this, null, pivotClass);
		//		}
		else {		// Class, Stereotype, State
			for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
				if ((eObject instanceof org.eclipse.ocl.pivot.Class) && (((org.eclipse.ocl.pivot.Class)eObject).getOwningPackage() != null)) {	// StateMachines etc do not have Packages
					return new ClassContext(this, null, (org.eclipse.ocl.pivot.Class)eObject, null);
				}
			}
		}
		return null;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@Nullable Type selfType, @Nullable Type selfTypeValue) {
		// assert selfTypeValue == null;			// Bug 580791 Enforcing redundant argument
		return new TemplateParameterSubstitutionVisitor(this, selfType, null);
	}

	protected @NonNull HashMap<Object, StatusCodes.Severity> createValidationKey2severityMap() {
		return PivotValidationOptions.createValidationKey2severityMap();
	}

	@Override
	public synchronized void detach(@NonNull Object attachOwner) {
		if (ENVIRONMENT_FACTORY_ATTACH.isActive()) {
			ENVIRONMENT_FACTORY_ATTACH.println("[" + Thread.currentThread().getName() + "] Detach(" + attachCount + ":" + (attachCount-1) + ") " + NameUtil.debugSimpleName(this) + " " + NameUtil.debugSimpleName(attachOwner));
		}
		if (isDisposed()) {
			return;					// Ignore detach after dispose
		}
		if (attachCount == 0) {
			throw new IllegalStateException(getClass().getName() + " not attached");
		}
		boolean wasRemoved = attachOwners.remove(Integer.valueOf(System.identityHashCode(attachOwner)));
		assert wasRemoved;
		if (--attachCount <= 0) {
			dispose();
		}
	}

	@Override
	public void detachRedundantThreadLocal() {
		if ((attachCount == 1) && (ThreadLocalExecutor.basicGetEnvironmentFactory() == this)) {
			ThreadLocalExecutor.detachEnvironmentFactory(this);
		}
	}

	@Override
	public void dispose() {
		if (ENVIRONMENT_FACTORY_ATTACH.isActive()) {
			ENVIRONMENT_FACTORY_ATTACH.println("[" + Thread.currentThread().getName() + "] Dispose(" + attachCount + ") " + NameUtil.debugSimpleName(this));
		}
		if (isDisposed()) {
			throw new IllegalStateException(getClass().getName() + " already disposed");
		}
		attachCount = -1;
		disposeInternal();
	}

	protected void disposeInternal() {
		assert isDisposed();
	//	ThreadLocalExecutor.removeEnvironmentFactory(this);  -- maybe wrong thread if GCed - wait for lazy isDisposwed() test
		boolean isGlobal = this == GlobalEnvironmentFactory.basicGetInstance();
		if (metamodelManager != null) {
			metamodelManager.dispose();
			metamodelManager = null;
		}
		EList<Adapter> externalResourceSetAdapters = externalResourceSet.eAdapters();
		if (externalResourceSetWasNull || isGlobal) {
			//			System.out.println("dispose CS " + ClassUtil.debugSimpleName(externalResourceSet));
			projectManager.unload(externalResourceSet);
			externalResourceSetAdapters.remove(projectManager);
			//			StandaloneProjectMap.dispose(externalResourceSet2);
			externalResourceSet.setPackageRegistry(null);
			externalResourceSet.setResourceFactoryRegistry(null);
			externalResourceSet.setURIConverter(null);
			if (externalResourceSet instanceof ResourceSetImpl) {
				((ResourceSetImpl)externalResourceSet).setURIResourceMap(null);
			}
			for (Resource resource : new ArrayList<Resource>(externalResourceSet.getResources())) {
				if (Thread.currentThread().getContextClassLoader() == null) {		// If finalizing, avoid NPE from EPackageRegistryImpl$Delegator.deegateRegistry()
					// This guard is needed to ensure that clear doesn't make the resource become loaded.
					//
					if (!resource.getContents().isEmpty())
					{
						resource.getContents().clear();
					}
					resource.getErrors().clear();
					resource.getWarnings().clear();
					/*				    if (idToEObjectMap != null)
				    {
				      idToEObjectMap.clear();
				    }

				    if (eObjectToIDMap != null)
				    {
				      eObjectToIDMap.clear();
				    }

				    if (eObjectToExtensionMap != null)
				    {
				      eObjectToExtensionMap.clear();
				    } */

				}
				else {
					resource.unload();
				}
				resource.eAdapters().clear();
			}
			externalResourceSetAdapters.clear();
			//			externalResourceSet = null;
		}
		else {
			for (Adapter adapter : externalResourceSetAdapters) {
				if ((adapter instanceof EnvironmentFactoryAdapter) && (((EnvironmentFactoryAdapter)adapter).getEnvironmentFactory() == this)) {
					externalResourceSetAdapters.remove(adapter);
					break;
				}
			}
		}
		if (idResolver != null) {
			idResolver.dispose();
			idResolver = null;
		}
		if (csi2asMapping != null) {
			csi2asMapping.dispose();
			csi2asMapping = null;
		}
	//	completeEnvironment = null;
	//	standardLibrary = null;
	//	completeModel = null;
		//		if (ENVIRONMENT_FACTORY_ATTACH.isActive()) {
		//			ENVIRONMENT_FACTORY_ATTACH.println("[" + Thread.currentThread().getName() + "] disposeInternal " + NameUtil.debugSimpleName(this) + " => " + NameUtil.debugSimpleName(PivotUtilInternal.findEnvironmentFactory(externalResourceSet)));
		//		}

		projectManager.unload(asResourceSet);
		projectManager.unload(externalResourceSet);

		ThreadLocalExecutor.detachEnvironmentFactory(this);
	//	System.gc();
	//	System.runFinalization();
	}

	@Override
	protected void finalize() throws Throwable {
//		PivotUtilInternal.debugPrintln("Finalize " + NameUtil.debugSimpleName(this));
		if (liveEnvironmentFactories != null) {
	PivotUtilInternal.debugPrintln("Finalize " + NameUtil.debugSimpleName(this));
			List<@NonNull EnvironmentFactory> keySet = new ArrayList<>(liveEnvironmentFactories.keySet());
			if (!keySet.isEmpty()) {
				StringBuilder s = new StringBuilder();
				s.append(" live");
				for (@NonNull EnvironmentFactory environmentFactory : keySet) {
					s.append(" @" + Integer.toHexString(environmentFactory.hashCode()));
				}
				System.out.println(s.toString());
			}
		}
	}

	/**
	 * Return the pivot model class for className with the Pivot Model.
	 */
	@Override
	public org.eclipse.ocl.pivot.@Nullable Class getASClass(@NonNull String className) {
		return getMetamodelManager().getASClass(className);
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable <T extends Element> T getASOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject) throws ParserException {
		if (eObject != null) {
			Resource eResource = eObject.eResource();
			ASResourceFactory bestHelper = eResource != null ? ASResourceFactoryRegistry.INSTANCE.getASResourceFactory(eResource) : EcoreASResourceFactory.getInstance();
			//			ASResourceFactory bestHelper = ASResourceFactoryRegistry.INSTANCE.getResourceFactory(eObject);
			if (bestHelper != null) {
				return bestHelper.getASElement(this, pivotClass, eObject);
			}
		}
		return null;
	}

	/**
	 * @since 1.10
	 */
	public @NonNull ResourceSet getASResourceSet() {
		return asResourceSet;
	}

	/**
	 * The abstract environment factory implementation is adaptable.  The
	 * default implementation adapts to and interface actually implemented by
	 * the receiver.
	 * <p>
	 * Subclasses may override or extend this implementation.
	 * </p>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> @Nullable T getAdapter(java.lang.Class<T> adapterType) {
		@Nullable T result;

		if (adapterType.isAssignableFrom(getClass())) {
			result = (T) this;
		} else {
			result = null;
		}

		return result;
	}

	/**
	 * Obtains client metamodel's classifier for the specified
	 * <code>context</code> object, which may be an instance of a classifier
	 * in the user model or may actually be a classifier in the user model.
	 *
	 * @param context a context object or classifier
	 * @return the user model's classifier for this context object, or the
	 *     context itself if it is a classifier
	 */
	protected org.eclipse.ocl.pivot.@NonNull Class getClassifier(@NonNull Object context) {
		PivotMetamodelManager metamodelManager = getMetamodelManager();
		org.eclipse.ocl.pivot.Class dClass = getIdResolver().getStaticTypeOfValue(null, context);
		return metamodelManager.getPrimaryClass(dClass);
	}

	@Override
	public @NonNull CompleteEnvironmentInternal getCompleteEnvironment() {
		return completeEnvironment; //completeModel.getCompleteEnvironment();
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return completeModel;
	}

	@Override
	public @Nullable ICSI2ASMapping getCSI2ASMapping() {
		return csi2asMapping;
	}

	@Override
	public @Nullable String getDoSetupName(@NonNull URI uri) {
		String fileExtension = uri.fileExtension();
		if (PivotConstants.ESSENTIAL_OCL_FILE_EXTENSION.equals(fileExtension)) {
			return "EssentialOCLStandaloneSetup.doSetup()";
		}
		else if (PivotConstants.OCL_FILE_EXTENSION.equals(fileExtension)) {
			return "CompleteOCLStandaloneSetup.doSetup()";
		}
		else if (PivotConstants.OCLINECORE_FILE_EXTENSION.equals(fileExtension)) {
			return "OCLinEcoreStandaloneSetup.doSetup()";
		}
		else if (PivotConstants.OCLSTDLIB_FILE_EXTENSION.equals(fileExtension)) {
			return "OCLstdlibStandaloneSetup.doSetup()";
		}
		return null;
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		IdResolver idResolver2 = idResolver;
		if (idResolver2 == null) {
			idResolver = idResolver2 = createIdResolver();
		}
		return idResolver2;
	}

	@Override
	public @NonNull PivotMetamodelManager getMetamodelManager() {
		PivotMetamodelManager metamodelManager2 = metamodelManager;
		if (metamodelManager2 == null) {
			metamodelManager = metamodelManager2 = createMetamodelManager();
		}
		return metamodelManager2;
	}

	@Override
	protected @Nullable EnvironmentFactoryInternal getParent() {
		return null;
	}

	/**
	 * Return the ProjectMap used to resolve EPackages.
	 */
	@Override
	public @NonNull ProjectManager getProjectManager() {
		return projectManager;
	}

	@Override
	public @NonNull ResourceSet getResourceSet() {
		return externalResourceSet;
	}

	@Override
	public StatusCodes.@Nullable Severity getSeverity(@Nullable Object validationKey) {
		Map<Object, StatusCodes.Severity> validationKey2severity2 = validationKey2severity;
		if (validationKey2severity2 == null) {
			validationKey2severity = validationKey2severity2 = createValidationKey2severityMap();
		}
		return validationKey2severity2.get(validationKey);
	}

	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return standardLibrary;
	}

	@Override
	public @NonNull Technology getTechnology() {
		return technology;
	}

	@Override
	public boolean isDisposed() {
		return attachCount < 0;
	}

	/**
	 * Queries whether tracing of evaluation is enabled.  Tracing
	 * logs the progress of evaluation to the console, which may
	 * be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 *
	 * @return whether evaluation tracing is enabled
	 *
	 * @see #setEvaluationTracingEnabled(boolean)
	 * @since 1.1
	 */
	@Override
	public boolean isEvaluationTracingEnabled() {
		return traceEvaluation;
	}

	@Override
	public EPackage loadEPackage(@NonNull EPackage ePackage) {
		return externalResourceSet.getPackageRegistry().getEPackage(ePackage.getNsURI());
	}

	@Override
	public @Nullable Element loadResource(@NonNull Resource resource, @Nullable URI uri) throws ParserException {
		ASResourceFactory bestFactory = ASResourceFactoryRegistry.INSTANCE.getASResourceFactory(resource);
		if (bestFactory != null) {
			ResourceSet resourceSet = resource.getResourceSet();
			if ((resourceSet != null) && (resourceSet != externalResourceSet)) {
				addExternalResources(resourceSet);
			}
			return bestFactory.importFromResource(this, resource, uri);
		}
		throw new ParserException("Cannot create pivot from '" + uri + "'");
		//		logger.warn("Cannot convert to pivot for package with URI '" + uri + "'");
	}

	/**
	 * Return the compiled query for a specification resolving a String body into a non-null bodyExpression.
	 * Throws a ParserException if conversion fails.
	 *
	 * @since 1.4
	 */
	@Override
	public @NonNull ExpressionInOCL parseSpecification(@NonNull LanguageExpression specification) throws ParserException {
		if ((specification instanceof ExpressionInOCL) && ((ExpressionInOCL)specification).getOwnedBody() != null) {
			return (ExpressionInOCL)specification;
		}
		EObject contextElement = ClassUtil.nonNullState(specification.eContainer());
		String expression = specification.getBody();
		if (expression == null) {
			throw new ParserException(PivotMessagesInternal.MissingSpecificationBody_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
		}
	//	expression = PivotUtilInternal.getBodyExpression(expression);
		ParserContext parserContext = createParserContext(specification);
		if (parserContext == null) {
			throw new ParserException(PivotMessagesInternal.UnknownContextType_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
		}
		parserContext.setRootElement(specification);
		return parserContext.parse(contextElement, expression);
	}

	/**
	 * @since 1.17
	 */
	@Override
	public void preDispose() {
		if (attachCount >= 2) {
			if (ThreadLocalExecutor.THREAD_LOCAL_ENVIRONMENT_FACTORY.isActive()) {
				ThreadLocalExecutor.THREAD_LOCAL_ENVIRONMENT_FACTORY.println("[" + Thread.currentThread().getName() + "] gc()-" + 0);
			}
			System.gc();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}

	public void resetSeverities() {
		validationKey2severity = null;
	}

	@Override
	public void setCSI2ASMapping(ICSI2ASMapping csi2asMapping) {
		this.csi2asMapping = csi2asMapping;
	}

	/**
	 * Sets whether tracing of evaluation is enabled.  Tracing logs
	 * the progress of parsing to the console, which may be of use in diagnosing
	 * problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 *
	 * param b whether evaluation tracing is enabled
	 *
	 * @see #isEvaluationTracingEnabled()
	 */
	@Override
	public void setEvaluationTracingEnabled(boolean b) {
		traceEvaluation = b;
	}

	@Override
	public void setProject(@Nullable IProject project) {}

	/**
	 * Configure safe navigation validation severities.
	 */
	@Override
	public void setSafeNavigationValidationSeverity(StatusCodes.@NonNull Severity severity) {
		for (EOperation key : PivotValidationOptions.safeValidationOperation2severityOption.keySet()) {
			if (key != null) {
				setSeverity(key, severity);
			}
		}
	}

	@Override
	public synchronized StatusCodes.@Nullable Severity setSeverity(/*@NonNull*/ Object validationKey, StatusCodes.@Nullable Severity severity) {
		Map<Object, StatusCodes.Severity> validationKey2severity2 = validationKey2severity;
		if (validationKey2severity2 == null) {
			validationKey2severity = validationKey2severity2 = createValidationKey2severityMap();
		}
		return validationKey2severity2.put(validationKey, severity);
	}
}
