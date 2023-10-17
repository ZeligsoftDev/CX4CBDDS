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

package org.eclipse.ocl.pivot.internal.utilities;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.resource.ICSI2ASMapping;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;

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
public interface EnvironmentFactoryInternal extends EnvironmentFactory
{
	/**
	 * @since 1.1
	 */
	public interface EnvironmentFactoryInternalExtension extends EnvironmentFactoryInternal, EnvironmentFactoryExtension2
	{
		/**
		 * Create a visitor to resolve TemplateParameter specializations. The visitor is normally created
		 * by the ASResourceFactory override of a relevant ASResource, but in the event that the ASResource is null,
		 * this alternative creation mechanism is available via an EnvironmentFactory override.
		 */
		@NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(@Nullable Type selfType, @Nullable Type selfTypeValue);
	}

	void addExternal2AS(@NonNull External2AS external2as);

	/**
	 * Add all resources in ResourceSet to the externalResourceSet.
	 */
	void addExternalResources(@NonNull ResourceSet externalResourceSet);

	/**
	 * Analyze all OCL functioality below eRootObject,typically a pivot Package, to populate the
	 * allInstancesCompleteClasses and implicitOppositeProperties with the identies of all
	 * Classes that source an allInstances() call and all unidirectional Properties that are
	 * opposite navigated.
	 *
	 * @since 1.14
	 */
	default void analyzeExpressions(@NonNull EObject eRootObject, @NonNull Set<@NonNull CompleteClass> allInstancesCompleteClasses, @NonNull Set<@NonNull Property> implicitOppositeProperties) {}

	void attach(@NonNull Object attachOwner);

	/**
	 * Configure the PackageRegistry associated with the (external) ResourceSet to use a load strategy that uses whichever of
	 * the namespace or platform URI is first encountered and which suppresses diagnostics about subsequent use of the
	 * other form of URI.
	 */
	void configureLoadFirstStrategy();

	/**
	 * Configure the PackageRegistry associated with the (external) ResourceSet to use a packageLoadStrategy and conflictHandler when
	 * resolving namespace and platform URIs.
	 */
	void configureLoadStrategy(ProjectManager.@NonNull IResourceLoadStrategy packageLoadStrategy, ProjectManager.@Nullable IConflictHandler conflictHandler);

	/**
	 * Create and initialize the AS ResourceSet used by metamodelManager to contain the AS forms of CS and Ecore/UML resources.
	 */
	@NonNull ResourceSetImpl createASResourceSet();

	/**
	 * @since 1.7
	 */
	@NonNull FlowAnalysis createFlowAnalysis(@NonNull OCLExpression contextExpression);

	@NonNull CompleteEnvironmentInternal createCompleteEnvironment();

	/**
	 * Create and initialize the IdResolver used by metamodelManager to convert Ids to Elements.
	 */
	@NonNull IdResolver createIdResolver();


	@NonNull ImplementationManager createImplementationManager();

	@NonNull PivotMetamodelManager createMetamodelManager();

	@Override
	@NonNull OCLInternal createOCL();

	/**
	 * Create a ParserContext that may be used to parse OCL expressions in the given context,
	 * which may be an EClassifier/EOperation/EStructuralFeature or Type/Operation/Property.
	 * Returns a ModelContext if no more specfic context can be determined if none can be created.
	 * @throws ParserException
	 */
	@Deprecated /* @deprecated not used - evolving towards createParserContext(@NonNull Element) */
	@NonNull ParserContext createParserContext(@Nullable EObject context) throws ParserException;

	void detach(@NonNull Object attachOwner);

	/**
	 * Detach the ThreadLocal reference to this EnvironmentFactory if that is the sole remaining attach.
	 *
	 * @since 1.14
	 */
	default void detachRedundantThreadLocal() {}

	void dispose();

	@Nullable ICSI2ASMapping getCSI2ASMapping();

	@Override
	@NonNull CompleteEnvironmentInternal getCompleteEnvironment();

	@Override
	@NonNull CompleteModelInternal getCompleteModel();

	@Nullable String getDoSetupName(@NonNull URI uri);

	@Override
	@NonNull PivotMetamodelManager getMetamodelManager();

	@Override
	@NonNull StandardLibraryInternal getStandardLibrary();

	@NonNull Technology getTechnology();

	/**
	 * Ensure that EPackage has been loaded in the externalResourceSet PackageRegistry.
	 */
	EPackage loadEPackage(@NonNull EPackage ePackage);

	@Nullable Element loadResource(@NonNull Resource resource, @Nullable URI uri) throws ParserException;

	void setCSI2ASMapping(ICSI2ASMapping csi2asMapping);

	void setEvaluationTracingEnabled(boolean b);

	/**
	 * Specify an Eclipse project with respect to which project-specific preferences are resolved.
	 */
	void setProject(@Nullable IProject project);

	void setSafeNavigationValidationSeverity(StatusCodes.@NonNull Severity severity);
}
