/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.Technology;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;

/**
 * ASResourceFactory provides Resource-type-dependent functionality for an OCL Abstract Syntax (Pivot) Model
 * without requiring a corresponding Resource to exist. It is therefore typically used to
 * create ASResource-related artefacts.
 */
public interface ASResourceFactory extends Resource.Factory, ASResourceFactoryContribution
{
	/**
	 * @since 1.4
	 */
	interface ASResourceFactoryExtension extends ASResourceFactory
	{
		/**
		 * Create the LUSSID allocator for an asResource.
		 */
		@NonNull LUSSIDs createLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options);
	}

	/**
	 * @since 1.7
	 */
	interface ASResourceFactoryExtension2 extends ASResourceFactoryExtension
	{
		@NonNull EnvironmentFactoryInternal createEnvironmentFactory(@NonNull ProjectManager projectManager);
	}

	/**
	 * Configure the MetamodelManager's external ResourceSet. Implementations may install
	 * any required extension or content to factory mappings in the resource factory registry.
	 */
	@Deprecated /* @deprecated Use two argument version */
	void configure(@NonNull ResourceSet resourceSet);

	/**
	 * @since 1.10
	 */
	default void configureResourceFactoryRegistry(@NonNull ResourceSet resourceSet) {}

	/**
	 * Configure the MetamodelManager's internal asResourceSet and external csResourceSet.
	 * Implementations may install any required extension or content to factory mappings in the
	 * resource factory registry.
	 *
	 * @since 1.10
	 */
	default void configureResourceSets(@Nullable ResourceSet asResourceSet, @NonNull ResourceSet csResourceSet) {
		if (asResourceSet != null) {
			configure(asResourceSet);
		}
		configure(csResourceSet);
	}

	/**
	 * Create a visitor to compute a structural descriptor for an element.
	 */
	@NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker);

	/**
	 * Create a visitor to compute the xmi:id value of an element.
	 *
	 * @deprecated AS2XMIid replaced by as2IS
	 */
	@Deprecated
	org.eclipse.ocl.pivot.utilities.@NonNull AS2XMIidVisitor createAS2XMIidVisitor(org.eclipse.ocl.pivot.internal.utilities.@NonNull AS2XMIid as2id);

	/**
	 * Create a visitor to locate orphan specializations.
	 */
	@Deprecated /* @deprecated Replaced by safer EcoreUtil.Copier/CrossReferencer functionality */
	@NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver asSaver);

	/**
	 * Create a visitor to normalize content.
	 *
	 * @since 1.18
	 */
	@NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull AbstractASSaver asSaver);

	/**
	 * Create a visitor to normalize content.
	 */
	@NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver asSaver);

	/**
	 * Create a visitor to resolve orphan specializations.
	 */
	@Deprecated /* @deprecated Replaced by safer EcoreUtil.Copier/CrossReferencer functionality */
	@NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver asSaver);

	/**
	 * Create a visitor to provide a pretty printed representation of one or more elements in the resource.
	 */
	@NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter prettyPrinter);

	/**
	 * Create a visitor to resolve template substitutions.
	 */
	@NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(@NonNull EnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue);

	/**
	 * Create a visitor to provide a debug representation of one or more elements in the resource.
	 */
	@NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s);

	/**
	 * Return the OCL AS element corresponding to eObject using metamodelManager to supervise
	 * the correspondence and ensuring that the result is of asClass.
	 */
	@Nullable <T extends Element> T getASElement(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Class<T> asClass, @NonNull EObject eObject) throws ParserException;

	@NonNull String getContentType();

	/**
	 * Return an EOperation for a pivot Operation if one is available.
	 * <br>
	 * For UML this locates the corresponding operation in the Eclipse namespace for the OMG namespace.
	 * @param asResource
	 */
	@Nullable EOperation getEOperation(@NonNull ASResource asResource, @NonNull EObject eObject);

	@Nullable EReference getEReference(@NonNull ASResource asResource, @NonNull EObject eObject);

	@NonNull Technology getTechnology();

	/**
	 * Return a specific metamodel NsURI if ePackage has particular requirements as is the case for UML.
	 */
	@Nullable String getMetamodelNsURI(@NonNull EPackage ePackage);

	/**
	 * Return the URI of an eObject if it can be treated as a Package.
	 */
	@Nullable URI getPackageURI(@NonNull EObject eObject);

	@Nullable String getResourceClassName();

	/**
	 * Return the root element in the Pivot resource resulting from import of the available
	 * resource.
	 * @throws ParserException
	 */
	@Nullable Element importFromResource(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Resource resource, @Nullable URI uri) throws ParserException;

	void initializeEValidatorRegistry(EValidator.@NonNull Registry eValidatorRegistry);

	/**
	 * Return true if newResource can be ignored in favour of an already loaded oldResource.
	 * Return false if an error message is required
	 */
	boolean isCompatibleResource(@NonNull Resource newResource, @NonNull Resource oldResource);
}
