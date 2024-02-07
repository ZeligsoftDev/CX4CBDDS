/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.EssentialOCLPrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.EcoreTechnology;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.internal.utilities.Technology;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.ocl.pivot.utilities.XMIUtil.IdResourceEntityHandler;

/**
 * AbstractASResourceFactory provides the abstract functionality for creating and maintaining
 * Pivot Abstract Syntax Resources via the standard EMF contentType/fileExtension Resource creation APIs.
 */
public abstract class AbstractASResourceFactory extends ResourceFactoryImpl implements ASResourceFactory.ASResourceFactoryExtension2
{
	/**
	 * @since 1.10
	 */
	@SuppressWarnings("unchecked")
	protected static <T extends AbstractASResourceFactory> @NonNull T getInstances(@NonNull String contentType, @NonNull String asFileExtension, @Nullable String csFileExtension, @NonNull Class<? extends T> resourceFactoryClass) {
		@Nullable T newInstance = null;
		T contentTypeInstance;
		Map<String, Object> contentTypeToFactoryMap = Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap();
		Object object1 = contentTypeToFactoryMap.get(contentType);
		if (object1 instanceof Resource.Factory.Descriptor) {
			contentTypeInstance = (T)((Resource.Factory.Descriptor)object1).createFactory();	// Create the registered singleton
		}
		else if (object1 != null) {
			contentTypeInstance = (T)object1;													// Reuse as our own singleton
		}
		else  {
			try {
				newInstance = contentTypeInstance = resourceFactoryClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}													// Create our own singleton
			contentTypeToFactoryMap.put(contentType, contentTypeInstance);
		}
		T extensionInstance;
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		Object object2 = extensionToFactoryMap.get(asFileExtension);
		if (object2 instanceof Resource.Factory.Descriptor) {
			extensionInstance = (T)((Resource.Factory.Descriptor)object2).createFactory();	// Create the registered singleton
		}
		else if (object2 != null) {
			extensionInstance = (T)object2;													// Reuse as our own singleton
		}
		else if (newInstance != null) {
			extensionInstance = newInstance;													// Reuse as our own singleton
		}
		else  {
			try {
				newInstance = extensionInstance = resourceFactoryClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}													// Create our own singleton
			extensionToFactoryMap.put(asFileExtension, extensionInstance);
		}
		assert contentTypeInstance != null;
		contentTypeInstance.install(csFileExtension, null);
//		ASResourceFactoryRegistry.INSTANCE.addASResourceFactory(contentType, csFileExtension, null, contentTypeInstance);
		assert contentTypeInstance != null;
		return contentTypeInstance;
	}

	public static void installContentHandler(int priority, @NonNull ContentHandler contentHandler) {
		List<ContentHandler> contentHandlers = ContentHandler.Registry.INSTANCE.get(priority);
		if (contentHandlers == null) {
			contentHandlers = new ArrayList<ContentHandler>();
			ContentHandler.Registry.INSTANCE.put(priority, contentHandlers);
		}
		if (!contentHandlers.contains(contentHandler)) {
			contentHandlers.add(contentHandler);
		}
	}

	/**
	 * The EMF ResourceFactoryRegistry ContentTypeToFactoryMap key at which this ASResourceFactory is stored.
	 */
	protected final @NonNull String contentType;		// FIXME refactor to asContentType

	/**
	 * The EMF ResourceFactoryRegistry ExtensionToFactoryMap key at which this ASResourceFactory is stored.
	 * A null key suppresses ExtensionToFactoryMap registrations for the many ASResourceFactory instances that
	 * share the *.oclas extension.
	 *
	 * FIXME can the many *.oclas ASRefesourceFatories be folded into one exploiting CSawareASResourceFactory ?
	 *
	 * @since 1.10
	 */
	private final @Nullable String asFileExtension;		// FIXME refactor to protected, @NonNull.

	@Deprecated /* @deprecated (no longer used) provide null asFileExtension argument */
	protected AbstractASResourceFactory(@NonNull String asContentType) {
		this(asContentType, null);
	}

	/**
	 * @since 1.10
	 */
	protected AbstractASResourceFactory(@NonNull String asContentType, @Nullable String asFileExtension) {
		this.contentType = asContentType;
		this.asFileExtension = asFileExtension;
	}

	@Override
	public @NonNull ASResourceFactory basicGetASResourceFactory() {
		return this;
	}

	@Override
	public void configure(@NonNull ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
		resourceFactoryRegistry.getContentTypeToFactoryMap().put(contentType, this);
	}

	/**
	 * @since 1.10
	 */
	protected void configureASResourceSet(@NonNull ResourceSet asResourceSet, @NonNull ResourceSet csResourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = asResourceSet.getResourceFactoryRegistry();
		resourceFactoryRegistry.getContentTypeToFactoryMap().put(contentType, this);
		if (asFileExtension != null) {
			ASResourceFactory extensionASResourceFactory = createResourceSetAwareASResourceFactory(csResourceSet);
			if (extensionASResourceFactory == null) {
				extensionASResourceFactory = this;
			}
			resourceFactoryRegistry.getExtensionToFactoryMap().put(asFileExtension, extensionASResourceFactory);
		}
	}

	/**
	 * @since 1.10
	 */
	protected void configureCSResourceSet(@NonNull ResourceSet csResourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = csResourceSet.getResourceFactoryRegistry();
		resourceFactoryRegistry.getContentTypeToFactoryMap().put(contentType, this);
	}

	protected void configureResource(@NonNull ASResource asResource) {
		asResource.setEncoding(ASResource.DEFAULT_ENCODING);
		Map<Object, Object> defaultSaveOptions = asResource.getDefaultSaveOptions();
		defaultSaveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		defaultSaveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		defaultSaveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		defaultSaveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		defaultSaveOptions.put(XMLResource.OPTION_RESOURCE_ENTITY_HANDLER, new IdResourceEntityHandler());
	}

	@Override
	public void configureResourceFactoryRegistry(@NonNull ResourceSet resourceSet) {}

	@Override
	public void configureResourceSets(@Nullable ResourceSet asResourceSet, @NonNull ResourceSet csResourceSet) {
		if (asResourceSet != null) {
			configureASResourceSet(asResourceSet, csResourceSet);
		}
		configureCSResourceSet(csResourceSet);
	}

	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker) {
		return new AS2MonikerVisitor(as2moniker);
	}

	@SuppressWarnings("deprecation")
	@Override
	public org.eclipse.ocl.pivot.utilities.@NonNull AS2XMIidVisitor createAS2XMIidVisitor(org.eclipse.ocl.pivot.internal.utilities.@NonNull AS2XMIid as2id) {
		return new org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver saver) {
		return new ASSaverLocateVisitor(saver);
	}

	@Override
	public @NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull AbstractASSaver asSaver) {
		return new ASSaverNormalizeVisitor(asSaver);
	}

	@Override
	public @NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver saver) {
		return new ASSaverNormalizeVisitor(saver);
	}

	@Override
	public @NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver saver) {
		return new ASSaverResolveVisitor(saver);
	}

	@Override
	public @NonNull EnvironmentFactoryInternal createEnvironmentFactory(@NonNull ProjectManager projectManager) {
		return new PivotEnvironmentFactory(projectManager, null, null);
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @NonNull LUSSIDs createLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		return new PivotLUSSIDs(asResource, options);
	}

	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter prettyPrinter) {
		return new EssentialOCLPrettyPrintVisitor(prettyPrinter);
	}

	/**
	 * @since 1.10
	 */
	protected @Nullable ASResourceFactory createResourceSetAwareASResourceFactory(@NonNull ResourceSet csResourceSet) {
		return this;
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(@NonNull EnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		// assert selfTypeValue == null;			// Bug 580791 Enforcing redundant argument
		return new TemplateParameterSubstitutionVisitor((EnvironmentFactoryInternal) environmentFactory, selfType, null);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new ToStringVisitor(s);
	}

	/**
	 * Creates an instance of the resource.
	 */
	@Override
	public Resource createResource(URI uri) {
		assert uri != null;
		ASResource result = new ASResourceImpl(uri, this);
		configureResource(result);
		return result;
	}

	@Override
	public @Nullable <T extends Element> T getASElement(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Class<T> requiredClass, @NonNull EObject eObject) throws ParserException {
		if (eObject instanceof Pivotable) {
			Element element = ((Pivotable)eObject).getPivot();
			if (element != null) {
				if (!requiredClass.isAssignableFrom(element.getClass())) {
					throw new ClassCastException(element.getClass().getName() + " is not assignable to " + requiredClass.getName());
				}
				@SuppressWarnings("unchecked")
				T castElement = (T) element;
				return castElement;
			}
		}
		return null;
	}

	/**
	 * @since 1.10
	 */
	protected @Nullable String getASfileExtension() {
		return asFileExtension;
	}

	@Override
	public @NonNull ASResourceFactory getContribution() {
		return this;
	}

	@Override
	public @NonNull String getContentType() {
		return contentType;
	}

	@Override
	public @Nullable EOperation getEOperation(@NonNull ASResource asResource, @NonNull EObject eObject) {
		return null;
	}

	@Override
	public @Nullable EReference getEReference(@NonNull ASResource asResource, @NonNull EObject eObject) {
		return null;
	}

	@Override
	public @Nullable String getMetamodelNsURI(@NonNull EPackage ePackage) {
		return null;
	}

	@Override
	public @Nullable URI getPackageURI(@NonNull EObject eObject) {
		return null;
	}

	@Override
	public @Nullable Integer getPriority() {
		return null;
	}

	@Override
	public @Nullable String getResourceClassName() {
		return null;
	}

	@Override
	public @NonNull Technology getTechnology() {
		return EcoreTechnology.INSTANCE;
	}

	@Override
	public @Nullable Element importFromResource(@NonNull EnvironmentFactoryInternal environmentFactory,
			@NonNull Resource resource, @Nullable URI uri) throws ParserException {
		Resource asResource = resource instanceof ASResource ? resource : ((CSResource)resource).getASResource();
		List<EObject> contents = asResource.getContents();
		if (contents.size() <= 0) {
			return null;
		}
		if (uri == null) {
			return (Element) contents.get(0);
		}
		String fragment = uri.fragment();
		if (fragment == null) {
			return (Element) contents.get(0);
		}
		else {
			EObject eObject = asResource.getEObject(fragment);
			if (eObject instanceof Element) {
				return (Element)eObject;
			}
			return null;
		}
	}

	@Override
	public void initializeEValidatorRegistry(EValidator.@NonNull Registry eValidatorRegistry) {}

	/**
	 * Install this ASResourceFactory within the ASResourceFactoryRegistry.INSTANCE wrt contentType,
	 * nonASextension and resourceClassName. The resourceClassName complexity is solely for the benefit
	 * of UML which may not be loaded so we cannot use UML classes. See Bug 526813.
	 */
	protected void install(@Nullable String nonASextension, @Nullable String resourceClassName) {
		ASResourceFactoryRegistry.INSTANCE.addASResourceFactory(contentType, nonASextension, resourceClassName, this);
	}

	@Override
	public boolean isCompatibleResource(@NonNull Resource newResource, @NonNull Resource oldResource) {
		return false;
	}

	@Override
	public @NonNull String toString() {
		return "«basic» " + contentType;
	}
}
