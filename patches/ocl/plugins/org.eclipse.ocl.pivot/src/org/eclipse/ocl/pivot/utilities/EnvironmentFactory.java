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

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.resource.ProjectManager;

/**
 * A factory for creating OCL parser and evaluation artefacts.  Clients of the OCL
 * parser that wish to use OCL with their metamodels can provide the parser
 * a factory that creates the suitable environments.  The environment provides
 * mappings from the client's metamodel to the UML concepts required by the
 * parser (corresponding to the generic type parameters, below).  Many of these
 * mappings are optional (e.g., state machines, signals, and association
 * classes aren't supported by all metamodels).
 * <p>
 * This interface is <b>not</b> intended to be implemented to be implemented
 * "directly" by providers of metamodel bindings.
 * It is highly recommended to extend the {@link AbstractEnvironmentFactory}
 * class, instead.
 * </p>
 */
public interface EnvironmentFactory extends Adaptable, Customizable
{
	/**
	 * @since 1.1
	 */
	public interface EnvironmentFactoryExtension extends EnvironmentFactory
	{
		/**
		 * Create an Executor for OCL evaluation. For derived languages, consumers are expected to create the appropriate
		 * Executor directly.
		 */
		@NonNull ExecutorInternal createExecutor(@NonNull ModelManager modelManager);

		boolean isEvaluationTracingEnabled();
	}

	/**
	 * @since 1.4
	 */
	public interface EnvironmentFactoryExtension2 extends EnvironmentFactoryExtension
	{
		/**
		 * Return a ParserContext suitable for parsing OCL expressions in the context of a pivot element,
		 * which may be the type defining the 'self' context, or an ExpressionInOCL whose ancestor defines
		 * the 'self' context.
		 *
		 * Returns null if parsing of OCL for an element is not supported.
		 *
		 * This method is primarily intended for internal use. The parseSpecification method
		 * provides the additional functionality of maintaining the ExpressionInOCL parsed
		 * expression cache.
		 *
		 * @since 1.4
		 */
		@Nullable ParserContext createParserContext(@NonNull Element element);

		/**
		 * Return the pivot model class for className with the Pivot Model.
		 */
		org.eclipse.ocl.pivot.@Nullable Class getASClass(@NonNull String className);

		@Nullable <T extends Element> T getASOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject) throws ParserException;

		/**
		 * Return the compiled query for a specification resolving a String body into a non-null bodyExpression.
		 * Throws a ParserException if conversion fails.
		 * @since 1.4
		 */
		@NonNull ExpressionInOCL parseSpecification(@NonNull LanguageExpression specification) throws ParserException;
	}

	@NonNull Adapter adapt(@NonNull Notifier notifier);

	/**
	 * Creates a new evaluation environment to track the values of variables in
	 * an OCL expression as it is evaluated.
	 *
	 * @return a new evaluation environment
	 */
	@NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull NamedElement executableObject, @NonNull ModelManager modelManager);

	/** @deprecated no longer used */
	@Deprecated
	@NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent, @NonNull NamedElement executableObject);

	/**
	 * Creates a new evaluation visitor, for the evaluation of an OCL expression on a context using an environment and a modelManager.
	 * If environment is null, a root environment is created and used.
	 * If context is null and the expression uses self subsequent evaluations will give invalid as the result.
	 * If modelManager is null, the context object's ResoutceSet is analyzed to create one.
	 */
	@NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Object context, @NonNull ExpressionInOCL expression, @Nullable ModelManager modelManager);

	/**
	 * Creates a new evaluation visitor, for the evaluation of OCL expressions.
	 *
	 * @param evalEnv the evaluation environment that the visitor is to use
	 *    for tracking variables, navigating properties, etc.
	 * @return the new evaluation visitor
	 */
	@NonNull EvaluationVisitor createEvaluationVisitor(@NonNull EvaluationEnvironment evalEnv);

	/**
	 * Return a Helper that provides a variety of useful API facilities.
	 *
	@NonNull PivotHelper createHelper(); */	// FIXME Bug 509309 wait for major version

	/**
	 * Creates an extent map for invocation of <tt>OclType.allInstances()</tt>
	 * using the specified <code>object</code> as a context from which to find
	 * the scope in which OCL classifier extents are defined.  This scope may
	 * be a resource, resource set, or some metamodel-specific scope.  Note that
	 * in the case that the <code>object</code> is not an
	 * {@link org.eclipse.emf.ecore.EObject} but is, instead, some primitive
	 * type, then this may be difficult to determine.
	 * <p>
	 * Clients are encouraged to do what they can to optimize this mapping, by
	 * lazy initialization of key-value pairs, workspace indices, or whatever
	 * means is available.  Note that the map will only ever be accessed by
	 * key ({@link Map#get(java.lang.Object)}); it will never be queried for
	 * all entries, all keys, all values, etc.  This knowledge could help
	 * optimization.
	 * </p>
	 *
	 * @param object a context object in the scope that covers the OCL
	 *     classifier extents
	 * @return the extent map
	 */
	@NonNull ModelManager createModelManager(@Nullable Object object);

	/**
	 * <p>Creates a new {@link OCL} instance attached to this {@link EnvironmentFactory}.</p>
	 *
	 * <p>Clients should call {@link OCL#dispose()} to detach once they have no further use for
	 * the OCL.</p>
	 *
	 * @return a new {@link OCL} instance attached to this {@link EnvironmentFactory}
	 */
	@NonNull OCL createOCL();

	/**
	 * Return the CompleteEnvironment that supervises the additional types need for collections specializations and tuples.
	 */
	@NonNull CompleteEnvironment getCompleteEnvironment();

	/**
	 * Return the CompleteModel that contains all the CompletePackages, which in turn contain all the CompleteClasses that
	 * define the merge of individual Packages and Classes.
	 */
	@NonNull CompleteModel getCompleteModel();

	/**
	 * Return the IdResolver that performs the resolution of the lightweight usage-independent Ids of types and packages
	 * into the full usage-specific equivalents.
	 */
	@NonNull IdResolver getIdResolver();

	/**
	 * Return the MetamodelManager used to supervise the normalized Abstract Syntax representations of the metamodels.
	 */
	@NonNull MetamodelManager getMetamodelManager();

	/**
	 * Return the ProjectManager used to supervise the mappings and regustrations for external resource names such as those for Eclipse
	 * projects that enable those resources to be accessed and exploited.
	 */
	@NonNull ProjectManager getProjectManager();

	/**
	 * Return the external ResourceSet used to hold External Syntax (e.g. Ecore or UML) and/or Concrete Syntax model representations.
	 * The internal ResoutrceSet used for Abstract Syntax resources is available by invoking getMetamodelmanager().getASResourceSet().
	 */
	@NonNull ResourceSet getResourceSet();

	/**
	 * Return the StatusCodes severity with which the validation identified by validationKey is reported.
	 * StatusCodes.OK severity suppresses the validation altogether.
	 * StatusCodes.Warning is returned for any null or unknown key.
	 */
	StatusCodes.@Nullable Severity getSeverity(@Nullable Object validationKey);

	/**
	 * Return the (OCL) Standard Library that provides the build-in language facilities such as the OclAny and Set types.
	 */
	@NonNull StandardLibrary getStandardLibrary();

	/**
	 * Return true if this EnvironmentFactory's life cycle has completed.
	 *
	 * @since 1.14
	 */
	default boolean isDisposed() { return false; }

	/**
	 * Give finalizers a chance to detach trivially so that a subsequent call to detach() can be the ultimate dispose().
	 *
	 * @since 1.17
	 */
	default void preDispose() {}

	/**
	 * Define the StatusCodes severity with which the validation identified by validationKey is reported.
	 * StatusCodes.OK severity suppresses the validation altogether.
	 *
	 * Returns any previous setting.
	 */
	StatusCodes.@Nullable Severity setSeverity(/*@NonNull*/ Object validationKey, StatusCodes.@Nullable Severity severity);
}