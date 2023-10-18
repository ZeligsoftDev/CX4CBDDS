/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.es2as;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ecore.es2as.AbstractExternal2AS;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.AliasAdapter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.uml.UMLStandaloneSetup;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UML22UMLResource;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.util.UMLUtil;

public abstract class UML2AS extends AbstractExternal2AS
{
	public static final @NonNull TracingOption ADD_ELEMENT_EXTENSION = new TracingOption(PivotPlugin.PLUGIN_ID, "uml2as/addElementExtension");
	public static final @NonNull TracingOption ADD_IMPORTED_RESOURCE = new TracingOption(PivotPlugin.PLUGIN_ID, "uml2as/addImportedResource");
	public static final @NonNull TracingOption ADD_PROFILE_APPLICATION = new TracingOption(PivotPlugin.PLUGIN_ID, "uml2as/addProfileApplication");
	public static final @NonNull TracingOption ADD_STEREOTYPE_APPLICATION = new TracingOption(PivotPlugin.PLUGIN_ID, "uml2as/addStereotypeApplication");
	public static final @NonNull TracingOption ADD_TYPE_EXTENSION = new TracingOption(PivotPlugin.PLUGIN_ID, "uml2as/addTypeExtension");
	public static final @NonNull TracingOption APPLICABLE_STEREOTYPES = new TracingOption(PivotPlugin.PLUGIN_ID, "uml2as/applicableStereotypes");
	public static final @NonNull TracingOption CONVERT_RESOURCE = new TracingOption(PivotPlugin.PLUGIN_ID, "uml2as/convertResource");
	public static final @NonNull TracingOption TYPE_EXTENSIONS = new TracingOption(PivotPlugin.PLUGIN_ID, "uml2as/typeExtensions");

	protected static final @NonNull String OCLforUML = ClassUtil.nonNullModel(NameUtil.getOriginalName(ClassUtil.nonNullModel(OCLforUMLPackage.eINSTANCE)));
	protected static final @NonNull String OCLforUML_COLLECTION = "OCLforUML::" + OCLforUMLPackage.Literals.COLLECTION.getName();
	protected static final @SuppressWarnings("null")@NonNull String OCLforUML_COLLECTION_IS_NULL_FREE_NAME = OCLforUMLPackage.Literals.COLLECTION__IS_NULL_FREE.getName();
	protected static final @NonNull String OCLforUML_COLLECTIONS = "OCLforUML::" + OCLforUMLPackage.Literals.COLLECTIONS.getName();
	protected static final @SuppressWarnings("null")@NonNull String OCLforUML_COLLECTIONS_IS_NULL_FREE_NAME = OCLforUMLPackage.Literals.COLLECTIONS__IS_NULL_FREE.getName();

	public static final @NonNull String STEREOTYPE_BASE_PREFIX = org.eclipse.uml2.uml.Extension.METACLASS_ROLE_PREFIX; //"base_";
	public static final @NonNull String STEREOTYPE_EXTENSION_PREFIX = org.eclipse.uml2.uml.Extension.STEREOTYPE_ROLE_PREFIX; //"extension_";

	public static @NonNull UML2AS getAdapter(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
		UMLStandaloneSetup.assertInitialized();
		UML2AS adapter = (UML2AS) findAdapter(resource, environmentFactory);
		if (adapter == null) {
			adapter = new Outer(resource, environmentFactory);
		}
		return adapter;
	}

	public static @Nullable String getBody(@NonNull OpaqueExpression opaqueExpression) {
		List<String> bodies = opaqueExpression.getBodies();
		List<String> languages = opaqueExpression.getLanguages();
		int bodiesSize = bodies.size();
		int languagesSize = languages.size();
		int i = 0;
		for ( ; i < languagesSize; i++) {
			if (PivotConstants.OCL_LANGUAGE.equals(languages.get(i))) {
				break;
			}
		}
		if (i < bodiesSize) {
			return bodies.get(i);
		}
		else {
			return null;
		}
	}

	/**
	 * Convert a UML resource to a Pivot Model.
	 * @param alias
	 *
	 * @param umlResource the UML resource
	 *
	 * @return the Pivot root package
	 * @throws ParserException
	 */
	public static Model importFromUML(@NonNull EnvironmentFactoryInternal environmentFactory, String alias, Resource umlResource) throws ParserException {
		if (umlResource == null) {
			return null;
		}
		UML2AS conversion = getAdapter(umlResource, environmentFactory);
		return conversion.getASModel();
	}

	/**
	 * Convert a UML object to a pivot element.
	 *
	 * @param eObject the UML object
	 *
	 * @return the pivot element
	 * @throws ParserException
	 */
	public static Element importFromUML(@NonNull EnvironmentFactoryInternal environmentFactory, String alias, EObject eObject) throws ParserException {
		if (eObject == null) {
			return null;
		}
		Resource umlResource = eObject.eResource();
		if (umlResource == null) {
			return null;
		}
		UML2AS conversion = getAdapter(umlResource, environmentFactory);
		@SuppressWarnings("unused")
		Model pivotModel = conversion.getASModel();
		return conversion.getCreated(Element.class, eObject);
	}

	public static void initialize() {
		IdManager.addMetamodelEPackage(ClassUtil.nonNullEMF(UMLPackage.eNS_URI), PivotConstants.UML_METAMODEL_NAME);
		IdManager.addMetamodelEPackage(ClassUtil.nonNullEMF(TypesPackage.eNS_URI), PivotConstants.TYPES_METAMODEL_NAME);
	}

	/**
	 * Initialize registries to support OCL and UML usage. This method is
	 * intended for initialization of standalone behaviors for which plugin extension
	 * registrations have not been applied.
	 *<p>
	 * A null resourceSet may be provided to initialize the global package registry
	 * and global URI mapping registry.
	 *<p>
	 * A non-null resourceSet may be provided to identify specific package
	 * and global URI mapping registries.
	 * <p>
	 * This method is used to configure the ResourceSet used to load the OCL Standard Library.

	 * @param resourceSet to be initialized or null for global initialization
	 * @return a failure reason, null if successful
	 */
	public static String initialize(@NonNull ResourceSet resourceSet) {
		UMLStandaloneSetup.init();
		initializeUML(resourceSet);
		final String resourcesPluginId = "org.eclipse.uml2.uml.resources"; //$NON-NLS-1$
		String resourcesLocation = null;
		StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(resourceSet);
		URI locationURI = projectMap.getLocation(resourcesPluginId);
		if (locationURI != null) {
			resourcesLocation = locationURI.toString();
			while (resourcesLocation.endsWith("/")) {
				resourcesLocation = resourcesLocation.substring(0, resourcesLocation.length()-1);
			}
		}
		if (resourcesLocation == null) {
			return "'" + resourcesPluginId + "' not found on class-path"; //$NON-NLS-1$
		}
		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), URI.createURI(resourcesLocation + "/profiles/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), URI.createURI(resourcesLocation + "/metamodels/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), URI.createURI(resourcesLocation + "/libraries/")); //$NON-NLS-1$
		return null;
	}

	public static String initialize(@NonNull StandaloneProjectMap projectMap) {
		UMLStandaloneSetup.init();
		final String resourcesPluginId = "org.eclipse.uml2.uml.resources"; //$NON-NLS-1$
		String resourcesLocation = null;
		URI locationURI = projectMap.getLocation(resourcesPluginId);
		if (locationURI != null) {
			resourcesLocation = locationURI.toString();
			while (resourcesLocation.endsWith("/")) {
				resourcesLocation = resourcesLocation.substring(0, resourcesLocation.length()-1);
			}
		}
		if (resourcesLocation == null) {
			return "'" + resourcesPluginId + "' not found on class-path"; //$NON-NLS-1$
		}
		Map<URI, URI> uriMap = URIConverter.URI_MAP;
		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), URI.createURI(resourcesLocation + "/profiles/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), URI.createURI(resourcesLocation + "/metamodels/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), URI.createURI(resourcesLocation + "/libraries/")); //$NON-NLS-1$
		return null;
	}

	/**
	 * Initialize global registries with required UML registrations unless already initialized.
	 *
	 * @since 1.9
	 */
	public static void initializeUMLglobals() {
		if (!Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap().containsKey(UMLResource.UML_CONTENT_TYPE_IDENTIFIER)) {		// Avoid repeated global initialization
			UMLResourcesUtil.initGlobalRegistries();
		}
	}

	/**
	 * Initialize resourceSet with required UML registrations unless already initialized.
	 *
	 * @since 1.9
	 */
	public static void initializeUMLlocals(@NonNull ResourceSet resourceSet) {
		if (!resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().containsKey(UML22UMLResource.UML2_CONTENT_TYPE_IDENTIFIER)) {		// Avoid repeated local initialization
			UMLUtil.init(resourceSet);
		}
	}

	/**
	 * Initialize resourceSet with required UML registrations and if necessary initialize
	 * global registries as well.
	 *
	 * @since 1.9
	 */
	public static void initializeUML(@NonNull ResourceSet resourceSet) {
		initializeUMLglobals();
		initializeUMLlocals(resourceSet);
	}

	public static boolean isUML(@NonNull Resource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			if (content instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
		}
		return false;
	}

	public static UML2AS loadFromUML(@NonNull ASResource umlASResource, @NonNull URI umlURI) {
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(umlASResource);
		Resource umlResource = environmentFactory.getResourceSet().getResource(umlURI, true);
		if (umlResource == null) {
			return null;
		}
		UML2AS conversion = getAdapter(umlResource, environmentFactory);
		try {
			conversion.getASModel();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*		conversion.pivotModel = metamodelManager.createModel(umlURI.lastSegment(), umlResource.getURI().toString());
		conversion.update(umlASResource, umlResource.getContents());

		AliasAdapter ecoreAdapter = AliasAdapter.findAdapter(umlResource);
		if (ecoreAdapter != null) {
			Map<EObject, String> ecoreAliasMap = ecoreAdapter.getAliasMap();
			AliasAdapter pivotAdapter = AliasAdapter.getAdapter(umlASResource);
			Map<EObject, String> pivotAliasMap = pivotAdapter.getAliasMap();
			for (EObject eObject : ecoreAliasMap.keySet()) {
				String alias = ecoreAliasMap.get(eObject);
				Element element = conversion.newCreateMap.get(eObject);
				pivotAliasMap.put(element, alias);
			}
		}
		metamodelManager.installResource(umlASResource);
		conversion.installImports(); */
		return conversion;
	}

	/**
	 * A UML2AS$Inner adapts an unconverted UML resource that has been imported during
	 * the conversion of some other UML resource.
	 */
	public static class Inner extends UML2AS
	{
		protected final @NonNull Outer root;

		protected Inner(@NonNull Resource umlResource, @NonNull Outer root) {
			super(umlResource, root.getEnvironmentFactory());
			this.root = root;
		}

		@Override
		public void addCreated(@NonNull EObject umlElement, @NonNull Element pivotElement) {
			root.addCreated(umlElement, pivotElement);
		}

		@Override
		public void addGenericType(@NonNull EGenericType eObject) {
			root.addGenericType(eObject);
		}

		@Override
		public void addImportedResource(@NonNull Resource importedResource) {
			root.addImportedResource(importedResource);
		}

		@Override
		public void addMapping(@NonNull EObject eObject, @NonNull Element pivotElement) {
			root.addMapping(eObject, pivotElement);
		}

		@Override
		public void addProfileApplication(@NonNull ProfileApplication asProfileApplication) {
			root.addProfileApplication(asProfileApplication);
		}

		@Override
		public void addProperty(org.eclipse.ocl.pivot.@NonNull Class asType, @NonNull Property asProperty) {
			root.addProperty(asType, asProperty);
		}

		@Override
		public void addStereotype(@NonNull Stereotype asStereotype) {
			root.addStereotype(asStereotype);
		}

		@Override
		public void addStereotypeApplication(@NonNull EObject stereotypeApplication) {
			root.addStereotypeApplication(stereotypeApplication);
		}

		@Override
		public void addTypeExtension(@NonNull StereotypeExtender asTypeExtension) {
			root.addTypeExtension(asTypeExtension);
		}

		@Override
		public void error(@NonNull String message) {
			root.error(message);
		}

		@Override
		public @NonNull Model getASModel() throws ParserException {
			Model pivotModel2 = pivotModel;
			if (pivotModel2 == null) {
				pivotModel2 = root.getASModel();
				Resource asResource = pivotModel.eResource();
				if (asResource == null) {
					throw new IllegalStateException("Missing containing resource");
				}
				//				installAliases(asResource);
				metamodelManager.installResource(asResource);
			}
			return pivotModel2;
		}

		@Override
		public @Nullable Type getASType(@NonNull EObject eObject) {
			return root.getASType(eObject);
		}

		@Override
		public <T extends Element> @Nullable T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
			return root.getCreated(requiredClass, eObject);
		}

		@Override
		public @Nullable Map<@NonNull EObject, @NonNull Element> getCreatedMap() {
			return root.getCreatedMap();
		}

		@Override
		public @NonNull UML2ASDeclarationSwitch getDeclarationPass() {
			return root.getDeclarationPass();
		}

		@Override
		public @NonNull Outer getRoot() {
			return root;
		}

		@Override
		public void queueReference(@NonNull EObject umlElement) {
			root.queueReference(umlElement);
		}

		@Override
		public void queueUse(@NonNull EObject umlElement) {
			root.queueUse(umlElement);
		}

		@Override
		public void resolveMultiplicity(@NonNull TypedElement pivotElement, org.eclipse.uml2.uml.@NonNull TypedElement umlTypedElement) {
			root.resolveMultiplicity(pivotElement, umlTypedElement);
		}
	}

	/**
	 * A UML2AS$Outer adapts an unconverted UML resource and hosts the additional conversions
	 * necessary for imported UML resources.
	 */
	public static class Outer extends UML2AS
	{
		/**
		 * Mapping of source UML objects to their resulting pivot element.
		 */
		private @NonNull Map<@NonNull EObject, @NonNull Element> createMap = new HashMap<>();

		/**
		 * Set of all UML objects requiring further work during the reference pass.
		 */
		private @NonNull Set<@NonNull EObject> referencers = new HashSet<>();

		/**
		 * Set of all UML objects requiring further work after the reference pass.
		 */
		private @NonNull Set<@NonNull EObject> users = new HashSet<>();

		/**
		 * Set of all converters used during session.
		 */
		private @NonNull Set<@NonNull UML2AS> allConverters = new HashSet<>();

		private List<Resource.@NonNull Diagnostic> errors = null;

		protected final @NonNull ProfileAnalysis profileAnalysis = new ProfileAnalysis(this);
		protected final @NonNull ModelAnalysis modelAnalysis = new ModelAnalysis(this, profileAnalysis);
		protected final @NonNull UML2ASDeclarationSwitch declarationPass = new UML2ASDeclarationSwitch(this);
		protected final @NonNull UML2ASReferenceSwitch referencePass = new UML2ASReferenceSwitch(this);
		protected final @NonNull UML2ASUseSwitch usePass = new UML2ASUseSwitch(this);
		private @Nullable List<@NonNull Resource> importedResources = null;

		//		private @NonNull Set<org.eclipse.uml2.uml.Property> umlProperties = new HashSet<>();
		private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull List<@NonNull Property>> type2properties = new HashMap<>();
		//		private @NonNull Map<Type, List<Property>> stereotypeProperties = new HashMap<Type, List<>>();
		private final @NonNull Map<org.eclipse.uml2.uml.NamedElement, Boolean> namedElement2isNullFree = new HashMap<>();

		protected Outer(@NonNull Resource umlResource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			super(umlResource, environmentFactory);
		}

		@Override
		public void addCreated(@NonNull EObject eObject, @NonNull Element pivotElement) {
			//			if ((eObject instanceof ENamedElement) && "EnglishClass".equals(((ENamedElement)eObject).getName())) {
			//				System.out.println("Define " + NameUtil.debugSimpleName(eObject) + " => " + NameUtil.debugSimpleName(pivotElement) + " in " + NameUtil.debugSimpleName(createMap));
			//			}
			//			else if ((eObject instanceof org.eclipse.uml2.uml.NamedElement) && "EnglishClass".equals(((org.eclipse.uml2.uml.NamedElement)eObject).getName())) {
			//				System.out.println("Define " + ClassUtil.debugSimpleName(eObject) + " => " + ClassUtil.debugSimpleName(pivotElement));
			//			}
			@SuppressWarnings("unused")
			Element oldElement = createMap.put(eObject, pivotElement);
			/*			if ((oldElement != null) && (oldElement != pivotElement)) {
				System.out.println("Reassigned : " + eObject);
			}
			else if (eObject instanceof EAnnotation) {
//				System.out.println("Assigned : " + eObject);
			}
			else {
//				System.out.println("Assigned : " + eObject);
			} */
		}

		@Override
		public void addGenericType(@NonNull EGenericType eObject) {
			//			throw new UnsupportedOperationException();				// FIXME
		}

		@Override
		public void addImportedResource(@NonNull Resource importedResource) {
			if (importedResource != umlResource) {
				List<@NonNull Resource> importedResources2 = importedResources;
				if (importedResources2 == null) {
					importedResources = importedResources2 = new ArrayList<>();
				}
				if (!importedResources2.contains(importedResource)) {
					URI uri = importedResource.getURI();
					if (ADD_IMPORTED_RESOURCE.isActive()) {
						ADD_IMPORTED_RESOURCE.println(String.valueOf(uri));
					}
					//					if (UMLResource.UML_METAMODEL_URI.equals(uri.toString())) {
					//						repairMetamodel(importedResource);
					//					}
					importedResources2.add(importedResource);
				}
			}
		}

		/*		private void repairMetamodel(Resource resource) {
			for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof org.eclipse.uml2.uml.OpaqueExpression) {
					org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression) eObject;
					EObject eContainer1 = opaqueExpression.eContainer();
					EObject eContainer2 = eContainer1 != null ? eContainer1.eContainer() : null;
//					String body = opaqueExpression.getBodies().size() > 0 ? opaqueExpression.getBodies().get(0) : null;
					String name1 = eContainer1 instanceof org.eclipse.uml2.uml.NamedElement ? ((org.eclipse.uml2.uml.NamedElement)eContainer1).getName() : "<null>";
					String name2 = eContainer2 instanceof org.eclipse.uml2.uml.NamedElement ? ((org.eclipse.uml2.uml.NamedElement)eContainer2).getName() : "<null>";
					String key = name2 + "::" + name1;
					if (!(eContainer2 instanceof org.eclipse.uml2.uml.Type)) {
						EObject eContainer3 = eContainer2 != null ? eContainer2.eContainer() : null;
						String name3 = eContainer3 instanceof org.eclipse.uml2.uml.NamedElement ? ((org.eclipse.uml2.uml.NamedElement)eContainer3).getName() : "<null>";
						key = name3 + "::" + key;
					}
//					System.out.println(key + " " + body);
				}
			}
		} */

		@Override
		public void addMapping(@NonNull EObject eObject, @NonNull Element pivotElement) {
			if (pivotElement instanceof PivotObjectImpl) {
				((PivotObjectImpl)pivotElement).setESObject(eObject);
			}
			addCreated(eObject, pivotElement);
		}

		@Override
		public void addProfileApplication(@NonNull ProfileApplication asProfileApplication) {
			modelAnalysis.addProfileApplication(asProfileApplication);
		}

		@Override
		public void addProperty(org.eclipse.ocl.pivot.@NonNull Class asType, @NonNull Property asProperty) {
			List<@NonNull Property> asProperties = type2properties.get(asType);
			if (asProperties == null) {
				asProperties = new ArrayList<>();
				type2properties.put(asType, asProperties);
			}
			asProperties.add(asProperty);
		}

		@Override
		public void addStereotype(@NonNull Stereotype asStereotype) {
			profileAnalysis.addStereotype(asStereotype);
		}

		@Override
		public void addStereotypeApplication(@NonNull EObject stereotypeApplication) {
			modelAnalysis.addStereotypeApplication(stereotypeApplication);
		}

		@Override
		public void addTypeExtension(@NonNull StereotypeExtender asTypeExtension) {
			profileAnalysis.addTypeExtension(asTypeExtension);
		}

		@Override
		public void error(@NonNull String message) {
			if (errors == null) {
				errors = new ArrayList<>();
			}
			errors.add(new XMIException(message));
		}

		/*		protected org.eclipse.uml2.uml.Property getOtherEnd(org.eclipse.uml2.uml.@NonNull Property umlProperty) {
			org.eclipse.uml2.uml.Property otherEnd = umlProperty.getOtherEnd();
			if (otherEnd != null) {
				return otherEnd;
			}
			// Workaround problem whereby UML has three ends two of them duplicates with distinct Class/Association ownership.
			org.eclipse.uml2.uml.Association association = umlProperty.getAssociation();
			if (association != null) {
				List<org.eclipse.uml2.uml.Property> memberEnds = new ArrayList<>(association.getMemberEnds());
				memberEnds.remove(umlProperty);
				for (org.eclipse.uml2.uml.Property aProperty : memberEnds) {
					if (!aProperty.getName().equals(umlProperty)) {
						return aProperty;
					}
				}
			}
			return otherEnd;
		} */

		@Override
		public @NonNull Model getASModel() throws ParserException {
			Model pivotModel2 = pivotModel;
			if (pivotModel2 == null) {
				URI pivotURI = createPivotURI();
				ASResource asResource = metamodelManager.getResource(pivotURI, ASResource.UML_CONTENT_TYPE);
				try {
					pivotModel2 = installDeclarations(asResource);
					//					Map<String, Type> resolvedSpecializations = new HashMap<>();
					//					for (EGenericType eGenericType : genericTypes) {
					//						Type pivotType = resolveType(resolvedSpecializations, eGenericType);
					//						createMap.put(eGenericType, pivotType);
					//					}
					//					for (List<TemplateableElement> pivotElements : specializations.values()) {
					//						for (TemplateableElement pivotElement : pivotElements) {
					//							metamodelManager.addOrphanType((Type)pivotElement);
					//						}
					//					}
					List<@NonNull Diagnostic> errors2 = errors;
					if (errors2 != null) {
						if ((errors2.size() == 1) && (errors2.get(0) instanceof Exception)) {
							throw (Exception)errors2.get(0);
						}
						else {
							throw new XMIException(PivotUtil.formatResourceDiagnostics(errors2, "", "\n"));
						}
					}
					installImports();
					installAliases(asResource);
					metamodelManager.installResource(asResource);
					installReferencers();
					modelAnalysis.installStereotypes();
					installProperties();
					installUsers();
				}
				catch (Exception e) {
					//					if (errors == null) {
					//						errors = new ArrayList<>();
					//					}
					//					errors.add(new XMIException("Failed to load '" + pivotURI + "' : " + e.getMessage()));
					throw new ParserException(e, "Failed to load '" + pivotURI + "' : " + e.getMessage());
				}
				if (errors != null) {
					asResource.getErrors().addAll(errors);
				}
				ResourceSet resourceSet = umlResource.getResourceSet();
				if (resourceSet != null) {
					environmentFactory.addExternalResources(resourceSet);				// FIXME redundant ?? -- no updates URIResourceMap
				}
			}
			return pivotModel2;
		}

		@Override
		public Type getASType(@NonNull EObject eObject) {
			Element pivotElement = createMap.get(eObject);
			if (pivotElement == null) {
				Resource resource = eObject.eResource();
				if ((resource != umlResource) && (resource != null)) {
					UML2AS converter = getAdapter(resource, environmentFactory);
					if (allConverters.add(converter)) {
						try {
							converter.getASModel();
						} catch (ParserException e) {
							@SuppressWarnings("null") @NonNull String message = e.getMessage();
							error(message);
						}
						//						allEClassifiers.addAll(converter.allEClassifiers);
						//						allNames.addAll(converter.allNames);
						//						for (Map.Entry<EModelElement, Element> entry : converter.createMap.entrySet()) {
						//							createMap.put(entry.getKey(), entry.getValue());
						//						}
					}
				}
				pivotElement = createMap.get(eObject);
			}
			if (pivotElement == null) {
				error("Unresolved " + eObject);
			}
			else if (!(pivotElement instanceof Type)) {
				error("Incompatible " + eObject);
			}
			else {
				return (Type) pivotElement;
			}
			return null;
		}

		@Override
		public <T extends Element> @Nullable T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
			Element element = createMap.get(eObject);
			if ((element == null) && (eObject instanceof org.eclipse.uml2.uml.ParameterableElement)) {
				org.eclipse.uml2.uml.TemplateParameter umlTemplateParameter = ((org.eclipse.uml2.uml.ParameterableElement)eObject).getOwningTemplateParameter();
				if (umlTemplateParameter != null) {
					element = createMap.get(umlTemplateParameter);
				}
			}
			if (element == null) {
				Resource resource = eObject.eResource();
				if (resource == umlResource) {
					return null;
				}
				List<Resource> importedResources2 = importedResources;
				if ((importedResources2 != null) && importedResources2.contains(resource)) {
					return null;
				}
				try {
					return ((EnvironmentFactoryInternalExtension)environmentFactory).getASOf(requiredClass, eObject);
				} catch (ParserException e) {
					return null;		// Never happens since UML element will never be a parsed one such as an OCLExpression
				}
			}
			if (!requiredClass.isAssignableFrom(element.getClass())) {
				error("UML " + element.getClass().getName() + "' element is not a '" + requiredClass.getName() + "'"); //$NON-NLS-1$
				return null;
			}
			@SuppressWarnings("unchecked")
			T castElement = (T) element;
			return castElement;
		}

		@Override
		public @Nullable Map<@NonNull EObject, @NonNull Element> getCreatedMap() {
			return createMap;
		}

		@Override
		public final @NonNull UML2ASDeclarationSwitch getDeclarationPass() {
			return declarationPass;
		}

		public @Nullable List<@NonNull Resource> getImportedResources() {
			return importedResources;
		}

		/*		protected org.eclipse.uml2.uml.Property getOtherEnd(org.eclipse.uml2.uml.@NonNull Property umlProperty) {
			org.eclipse.uml2.uml.Property otherEnd = umlProperty.getOtherEnd();
			if (otherEnd != null) {
				return otherEnd;
			}
			// Workaround problem whereby UML has three ends two of them duplicates with distinct Class/Association ownership.
			org.eclipse.uml2.uml.Association association = umlProperty.getAssociation();
			if (association != null) {
				List<org.eclipse.uml2.uml.Property> memberEnds = new ArrayList<>(association.getMemberEnds());
				memberEnds.remove(umlProperty);
				for (org.eclipse.uml2.uml.Property aProperty : memberEnds) {
					if (!aProperty.getName().equals(umlProperty)) {
						return aProperty;
					}
				}
			}
			return otherEnd;
		} */

		@Override
		public @NonNull Outer getRoot() {
			return this;
		}

		protected void installAliases(@NonNull Resource asResource) {
			AliasAdapter umlAdapter = AliasAdapter.findAdapter(umlResource);
			if (umlAdapter != null) {
				Map<EObject, String> umlAliasMap = umlAdapter.getAliasMap();
				AliasAdapter pivotAdapter = AliasAdapter.getAdapter(asResource);
				Map<EObject, String> pivotAliasMap = pivotAdapter.getAliasMap();
				for (EObject eObject : umlAliasMap.keySet()) {
					String alias = umlAliasMap.get(eObject);
					Element element = createMap.get(eObject);
					pivotAliasMap.put(element, alias);
				}
			}
		}

		protected void installImports() throws ParserException {
			List<Resource> importedResources2 = importedResources;
			if (importedResources2 != null) {
				for (int i = 0; i < importedResources2.size(); i++) {			// List may grow re-entrantly
					Resource importedResource = importedResources2.get(i);
					if (importedResource instanceof UMLResource) {
						External2AS adapter = UML2AS.findAdapter(importedResource, environmentFactory);
						if (adapter == null) {
							Inner importedAdapter = new Inner(importedResource, this);
							URI pivotURI = importedAdapter.createPivotURI();
							ASResource asResource = metamodelManager.getResource(pivotURI, ASResource.UML_CONTENT_TYPE);
							importedAdapter.installDeclarations(asResource);
							adapter = importedAdapter;
							metamodelManager.installResource(asResource);
						}
						else {
							Map<@NonNull EObject, @NonNull Element> importedCreatedMap = adapter.getCreatedMap();
							if (importedCreatedMap != null) {
								createMap.putAll(importedCreatedMap);
								//								for (@NonNull EObject key : importedCreatedMap.keySet()) {
								//									Element value = importedCreatedMap.get(key);
								//									assert value != null;
								//									addCreated(key, value);
								//								}
							}
						}
					}
					else if (importedResource != null) {
						environmentFactory.loadResource(importedResource, null);
					}
				}
			}
		}

		protected void installProperties() {
			/*			Map<Type, List<org.eclipse.uml2.uml.Property>> typeProperties = new HashMap<>();
			List<org.eclipse.uml2.uml.Property> sortedList = new ArrayList<>(umlProperties);
			Collections.sort(sortedList, new Comparator<org.eclipse.uml2.uml.Property>() {

				public int compare(org.eclipse.uml2.uml.Property o1, org.eclipse.uml2.uml.Property o2) {
					String n1 = o1.getName();
					String n2 = o2.getName();
					return n1 == n2 ? 0 : (n1 != null) && (n2 != null) ? n1.compareTo(n2) : n2 == null ? 1 : -1;
				}

			});
			for (org.eclipse.uml2.uml.Property umlProperty : sortedList) {
				Property asProperty = getCreated(Property.class, umlProperty);
				Property asOppositeProperty = asProperty != null ? asProperty.getOpposite() : null;
//				if ("executionSpecification".equals(umlProperty.getName())) {
//					System.out.println("Install " + umlProperty);
//				}
				Type pivotType = null;
				EObject umlOwner = ClassUtil.nonNullEMF(umlProperty.eContainer());
				if (umlOwner instanceof org.eclipse.uml2.uml.Association) {
//					String name = ((org.eclipse.uml2.uml.NamedElement)umlProperty.eContainer()).getName();
//					if (name != null) {
//						System.out.println("Assoc Property " + name + "::" + umlProperty.getName());
//					}
//					else {
//						System.out.println("Anon Assoc Property " + name + "::" + umlProperty.getName());
//					}
					org.eclipse.uml2.uml.Property opposite = getOtherEnd(umlProperty);
					if (opposite != null) {
						pivotType = getCreated(Type.class, ClassUtil.nonNullModel(opposite.getType()));
					}
					else {
//						System.out.println("*****************Missing opposite");
					}
				}
				else {
					pivotType = getCreated(Type.class, umlOwner);
				}
				if (pivotType != null) {
					List<org.eclipse.uml2.uml.Property> someProperties = typeProperties.get(pivotType);
					if (someProperties == null) {
						someProperties = new ArrayList<>();
						typeProperties.put(pivotType, someProperties);
					}
					String name = umlProperty.getName();
					if (name == null) {
//						System.out.println("Unnamed " + pivotType.getName() + "::" + umlProperty.getName());
						name = umlProperty.getType().getName();
					}
					else {
/*						for (org.eclipse.uml2.uml.Property aProperty : someProperties) {
							String aName = aProperty.getName();
							if (name.equals(aName)) {
								System.out.println("Ambiguous " + pivotType.getName() + "::" + umlProperty.getName());
								org.eclipse.uml2.uml.Property opp1 = umlProperty.getOtherEnd();
								if (opp1 != null) {
									System.out.println("  opposite " + umlProperty.getType().getName() + "::" + opp1.getName() + " " + (umlProperty.getClass_() != null));
								}
								org.eclipse.uml2.uml.Property opp2 = aProperty.getOtherEnd();
								if (opp2 != null) {
									System.out.println("  opposite " + umlProperty.getType().getName() + "::" + opp2.getName() + " " + (aProperty.getClass_() != null));
								}
							}
						} * /
						someProperties.add(umlProperty);
					}
				}
				else {
					org.eclipse.uml2.uml.Property opposite = getOtherEnd(umlProperty);
					if (opposite != null) {
						org.eclipse.uml2.uml.Type oppositeType = ClassUtil.nonNullEMF(opposite.getType());
						pivotType = getCreated(Type.class, oppositeType);
					}
//					System.out.println("*****************Missing opposite type");
				}
			}
			Set<Type> allPropertiedTypes = new HashSet<>(typeProperties.keySet()); */
			//			allPropertiedTypes.addAll(stereotypeProperties.keySet());
			for (org.eclipse.ocl.pivot.@NonNull Class pivotType : type2properties.keySet()) {
				List<@NonNull Property> asProperties = type2properties.get(pivotType);
				Collections.sort(asProperties, NameUtil.NAMEABLE_COMPARATOR);
				refreshList(PivotUtilInternal.getOwnedPropertiesList(pivotType), asProperties);
			}
		}

		protected void installReferencers() {
			for (EObject eObject : referencers) {
				referencePass.doSwitch(eObject);
			}
		}

		protected void installUsers() {
			for (EObject eObject : users) {
				usePass.doSwitch(eObject);
			}
		}

		@Override
		public void queueReference(@NonNull EObject umlElement) {
			referencers.add(umlElement);
		}

		@Override
		public void queueUse(@NonNull EObject umlElement) {
			users.add(umlElement);
		}

		private @NonNull Boolean isNullFree(@Nullable EObject eObject) {
			if (eObject == null) {
				return ValueUtil.TRUE_VALUE;
			}
			else if ((eObject instanceof org.eclipse.uml2.uml.Class) || (eObject instanceof org.eclipse.uml2.uml.Package)) {
				org.eclipse.uml2.uml.NamedElement umlElement = (org.eclipse.uml2.uml.NamedElement)eObject;
				Boolean isNullFree = namedElement2isNullFree.get(umlElement);
				if (isNullFree == null) {
					org.eclipse.uml2.uml.Stereotype umlStereotype = umlElement.getAppliedStereotype(OCLforUML_COLLECTIONS);
					if (umlStereotype != null) {
						Object value = umlElement.getValue(umlStereotype, OCLforUML_COLLECTIONS_IS_NULL_FREE_NAME);
						if (value instanceof Boolean) {
							isNullFree = (Boolean)value;
						}
					}
					if (isNullFree == null) {
						isNullFree = isNullFree(umlElement.eContainer());
					}
					namedElement2isNullFree.put(umlElement, isNullFree);
				}
				return isNullFree;
			}
			else {
				return isNullFree(eObject.eContainer());
			}
		}

		@Override
		public void resolveMultiplicity(@NonNull TypedElement pivotElement, org.eclipse.uml2.uml.@NonNull TypedElement umlTypedElement) {
			boolean isRequired = false;
			org.eclipse.uml2.uml.Type umlType = umlTypedElement.getType();
			if (umlType != null) {
				Type pivotType = resolveType(umlType);
				if ((umlTypedElement instanceof org.eclipse.uml2.uml.MultiplicityElement) && (pivotType != null)) {
					org.eclipse.uml2.uml.MultiplicityElement umlMultiplicity = (org.eclipse.uml2.uml.MultiplicityElement)umlTypedElement;
					int lower = umlMultiplicity.getLower();
					int upper = umlMultiplicity.getUpper();
					if (upper == 1) {
						isRequired = lower == 1;
					}
					else {
						isRequired = true;
						boolean isOrdered = umlMultiplicity.isOrdered();
						boolean isUnique = umlMultiplicity.isUnique();
						Boolean isNullFree = null;
						org.eclipse.uml2.uml.Stereotype umlStereotype = umlMultiplicity.getAppliedStereotype(OCLforUML_COLLECTION);
						if (umlStereotype != null) {
							Object value = umlMultiplicity.getValue(umlStereotype, OCLforUML_COLLECTION_IS_NULL_FREE_NAME);
							if (value instanceof Boolean) {
								isNullFree = (Boolean)value;
							}
						}
						if (isNullFree == null) {
							isNullFree = isNullFree(umlMultiplicity.eContainer());
						}
						IntegerValue lowerValue = ValueUtil.integerValueOf(lower);
						UnlimitedNaturalValue upperValue = upper == -1 ? ValueUtil.UNLIMITED_VALUE : ValueUtil.unlimitedNaturalValueOf(upper);
						pivotType = environmentFactory.getMetamodelManager().getCollectionType(isOrdered, isUnique, pivotType, isNullFree == Boolean.TRUE, lowerValue, upperValue);
					}
				}
				pivotElement.setType(pivotType);
			}
			else {
				pivotElement.setType(standardLibrary.getOclVoidType());
			}
			pivotElement.setIsRequired(isRequired);
		}
	}

	protected final @NonNull Resource umlResource;
	protected Model pivotModel = null;	// Set by installDeclarations
	private URI umlURI = null;
	private final @NonNull Map<@NonNull AssociationClass, @NonNull AssociationClassProperties> association2properties = new HashMap<>();

	protected UML2AS(@NonNull Resource umlResource, @NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
		if (CONVERT_RESOURCE.isActive()) {
			CONVERT_RESOURCE.println(umlResource.getURI().toString());
		}
		this.umlResource = umlResource;
		//		umlResource.eAdapters().add(this);
		environmentFactory.addExternal2AS(this);
		//		metamodelManager.addListener(this);
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		completeModel.addPackageURI2completeURI(ClassUtil.nonNullEMF(UMLPackage.eNS_URI), PivotConstants.UML_METAMODEL_NAME);
		completeModel.addPackageURI2completeURI(ClassUtil.nonNullEMF(TypesPackage.eNS_URI), PivotConstants.TYPES_METAMODEL_NAME);		// FIXME All known synonyms
		// FIXME All known synonyms
	}

	/*public*/ void addAssociationClassProperties(@NonNull AssociationClass asAssociationClass, @NonNull AssociationClassProperties asProperties) {
		association2properties.put(asAssociationClass, asProperties);
	}

	public abstract void addCreated(@NonNull EObject umlElement, @NonNull Element pivotElement);

	public void addImportedPackage(org.eclipse.uml2.uml.@NonNull Package importedPackage) {
		if (importedPackage.eIsProxy()) {
			error("Unresolved proxy '" + EcoreUtil.getURI(importedPackage) + "'");
		}
		else {
			EObject rootContainer = EcoreUtil.getRootContainer(importedPackage);
			Resource importedResource = rootContainer.eResource();
			if (importedResource == null) {
				error("Uncontained package '" + EcoreUtil.getURI(importedPackage) + "'");
			}
			else {
				addImportedResource(importedResource);
			}
		}
	}

	public void addImportedPackages(@NonNull List<? extends org.eclipse.uml2.uml.Package> importedPackages) {
		for (org.eclipse.uml2.uml.Package importedPackage : importedPackages) {
			if (importedPackage != null) {
				addImportedPackage(importedPackage);
			}
		}
	}

	public abstract void addImportedResource(@NonNull Resource importedResource);

	public abstract void addProfileApplication(@NonNull ProfileApplication asProfileApplication) ;

	public abstract void addProperty(org.eclipse.ocl.pivot.@NonNull Class asType, @NonNull Property asProperty);

	public abstract void addStereotype(@NonNull Stereotype asStereotype);

	public abstract void addStereotypeApplication(@NonNull EObject stereotypeApplication);

	public abstract void addTypeExtension(@NonNull StereotypeExtender asTypeExtension);

	@Override
	protected Model basicGetPivotModel() {
		return pivotModel;
	}

	public void copyModelElement(@NonNull Element pivotElement, org.eclipse.uml2.uml.@NonNull Element umlElement) {
		setOriginalMapping(pivotElement, umlElement);
	}

	public void copyNamedElement(@NonNull NamedElement pivotElement, org.eclipse.uml2.uml.@NonNull NamedElement umlNamedElement) {
		copyModelElement(pivotElement, umlNamedElement);
		String name = umlNamedElement.getName();
		pivotElement.setName(name);
		//		copyAnnotatedElement(pivotElement, umlNamedElement, null);
		//		copyComments(pivotElement, umlNamedElement);
	}

	protected @NonNull URI createPivotURI() {
		URI uri = umlResource.getURI();
		if (uri == null) {
			throw new IllegalStateException("Missing resource URI");
		}
		return PivotUtilInternal.getASURI(uri);
	}

	@Override
	public abstract void error(@NonNull String message);

	public abstract @Nullable Type getASType(@NonNull EObject eObject);

	private Set<org.eclipse.uml2.uml.@NonNull Package> getAllAppliedProfilePackages(org.eclipse.uml2.uml.Package umlStereotypedPackage) {
		Set<org.eclipse.uml2.uml.@NonNull Package> allAppliedProfilePackages = new HashSet<>();
		for (org.eclipse.uml2.uml.Profile umlAppliedProfile : umlStereotypedPackage.getAllAppliedProfiles()) {
			getAllAppliedProfilePackages(allAppliedProfilePackages, umlAppliedProfile);
		}
		return allAppliedProfilePackages;
	}
	private void getAllAppliedProfilePackages(@NonNull Set<org.eclipse.uml2.uml.Package> allAppliedProfilePackages, org.eclipse.uml2.uml.Package umlPackage) {
		if (allAppliedProfilePackages.add(umlPackage)) {
			for (org.eclipse.uml2.uml.Package umlNestedPackage : umlPackage.getNestedPackages()) {
				getAllAppliedProfilePackages(allAppliedProfilePackages, umlNestedPackage);
			}
			for (org.eclipse.uml2.uml.Package umlImportedPackage : umlPackage.getImportedPackages()) {
				getAllAppliedProfilePackages(allAppliedProfilePackages, umlImportedPackage);
			}
		}
	}

	/**
	 * Return all the pivot properties with which asAssociationClass supports umlProperties in an order that
	 * is positionally consistent with the order of umlProperties.
	 */
	/*public*/ @Nullable AssociationClassProperties getAssociationClassProperties(@NonNull AssociationClass asAssociationClass) {
		return association2properties.get(asAssociationClass);
	}

	/**
	 * @since 1.18
	 */
	public @Nullable PrimitiveType getBehavioralClass(org.eclipse.uml2.uml.@NonNull DataType umlDataType) {
		if (umlDataType instanceof org.eclipse.uml2.uml.PrimitiveType) {
			PrimitiveType asPrimitiveType = getPrimitiveTypeByName((org.eclipse.uml2.uml.PrimitiveType)umlDataType);
			if (asPrimitiveType != null) {
				if (PivotUtil.getName(asPrimitiveType).equals(umlDataType.getName())) {
					return null;							// Same named PrimitiveType re-uses / is a synonym
				}
				else {
					return asPrimitiveType;					// Chnaged name conforms to the behavioral primitove
				}
			}
		}
		PrimitiveType asPrimitiveType = getPrimitiveTypeByOCLStereotype(umlDataType);
		if (asPrimitiveType != null) {
			return asPrimitiveType;
		}
		org.eclipse.uml2.uml.Stereotype ecoreStereotype = umlDataType.getAppliedStereotype("Ecore::EClass");	// Bug 453090 : UML2 does not support generalization
		if (ecoreStereotype == null) {
			ecoreStereotype = umlDataType.getAppliedStereotype("Ecore::EDataType");
		}
		if (ecoreStereotype == null) {
			ecoreStereotype = umlDataType.getAppliedStereotype("Ecore::EClassifier");
		}
		if (ecoreStereotype == null) {
			return null;
		}
		Object object = umlDataType.getValue(ecoreStereotype, "instanceClassName");
		if (!(object instanceof String)) {
			return null;
		}
		return getPrimitiveTypeByEcoreStereotype(ecoreStereotype, (String) object);
	}

	public abstract @NonNull UML2ASDeclarationSwitch getDeclarationPass();

	/**
	 * @since 1.18
	 */
	public @Nullable PrimitiveType getPrimitiveTypeByEcoreStereotype(org.eclipse.uml2.uml.@NonNull Stereotype ecoreStereotype, @NonNull String instanceClassName) {
		if ("boolean".equals(instanceClassName)) {
			return standardLibrary.getBooleanType();
		}
		if ("byte".equals(instanceClassName) || "char".equals(instanceClassName) || "int".equals(instanceClassName) || "long".equals(instanceClassName) || "short".equals(instanceClassName)) {
			return standardLibrary.getIntegerType();
		}
		if ("double".equals(instanceClassName) || "float".equals(instanceClassName)) {
			return standardLibrary.getRealType();
		}
		try {
			@SuppressWarnings("null")@NonNull ClassLoader classLoader = ecoreStereotype.getClass().getClassLoader();
			Class<?> instanceClass = classLoader.loadClass(instanceClassName);
			if (instanceClass != null) {
				PrimitiveType behavioralClass = standardLibrary.getBehavioralClass(instanceClass);
				if (behavioralClass != null) {
					return behavioralClass;
				}
				instanceClass.getDeclaredMethod("compareTo", instanceClass);
				//						converter.queueReference(eObject2);			// Defer synthesis till supertypes resolved
			}
		}
		catch (Exception e) {
			//			converter.error("Unknown '" + instanceClassName + "'");		// Ignores e.g. byte[]
		}
		return null;
	}

	/**
	 * @since 1.18
	 */
	public @Nullable PrimitiveType getPrimitiveTypeByName(org.eclipse.uml2.uml.@NonNull PrimitiveType umlPrimitiveType) {
		String name = umlPrimitiveType.getName();
		if (UMLUtil.isBoolean(umlPrimitiveType) || TypeId.BOOLEAN_NAME.equals(name)) {
			return standardLibrary.getBooleanType();
		}
		if (UMLUtil.isInteger(umlPrimitiveType) || TypeId.INTEGER_NAME.equals(name)) {
			return standardLibrary.getIntegerType();
		}
		if (UMLUtil.isReal(umlPrimitiveType) || TypeId.REAL_NAME.equals(name)) {
			return standardLibrary.getRealType();
		}
		if (UMLUtil.isString(umlPrimitiveType) || TypeId.STRING_NAME.equals(name)) {
			return standardLibrary.getStringType();
		}
		if (UMLUtil.isUnlimitedNatural(umlPrimitiveType) || TypeId.UNLIMITED_NATURAL_NAME.equals(name)) {
			return standardLibrary.getUnlimitedNaturalType();
		}
		org.eclipse.uml2.uml.Package umlPackage = umlPrimitiveType.getPackage();
		if ((umlPackage != null) && "EcorePrimitiveTypes".equals(umlPackage.getName())) {		// FIXME Bug 412918 for extra cases
			if ("EBigDecimal".equals(name)
					|| "EFloat".equals(name) || "EFloatObject".equals(name)) {
				return standardLibrary.getRealType();
			}
			else if ("EBigInteger".equals(name)
					|| "EByte".equals(name) || "EByteObject".equals(name)
					|| "EChar".equals(name) || "ECharacterObject".equals(name)
					|| "ELong".equals(name) || "ELongObject".equals(name)
					|| "EShortObject".equals(name) || "EShortObject".equals(name)) {
				return standardLibrary.getIntegerType();
			}
		}
		return null;
	}

	/**
	 * @since 1.18
	 */
	public @Nullable PrimitiveType getPrimitiveTypeByOCLStereotype(org.eclipse.uml2.uml.@NonNull DataType umlDataType) {
		if (umlDataType.getAppliedStereotype("OCLforUML::Integer") != null) {
			return standardLibrary.getIntegerType();
		}
		if (umlDataType.getAppliedStereotype("OCLforUML::Real") != null) {
			return standardLibrary.getRealType();
		}
		return null;
	}

	@Override
	public @NonNull Resource getResource() {
		return umlResource;
	}

	public abstract @NonNull Outer getRoot();

	/*public*/ @NonNull List<org.eclipse.uml2.uml.@NonNull Property> getSafeMemberEnds(org.eclipse.uml2.uml.@NonNull Association umlAssociation) { // FIXME workaround for BUG 491587
		List<org.eclipse.uml2.uml.@NonNull Property> safeMemberEnds = new ArrayList<>();
		for (org.eclipse.uml2.uml.Property umlProperty : umlAssociation.getMemberEnds()) {
			if (umlProperty != null) {
				String name = umlProperty.getName();
				boolean isSafe = true;
				for (org.eclipse.uml2.uml.@NonNull Property umlSafeProperty : safeMemberEnds) {
					if (ClassUtil.safeEquals(name, umlSafeProperty.getName())) {
						isSafe = false;
						break;
					}
				}
				if (isSafe) {
					safeMemberEnds.add(umlProperty);
				}
			}
		}
		return safeMemberEnds;
	}

	@Override
	public @NonNull URI getURI() {
		return ClassUtil.nonNullState(umlResource.getURI());
	}

	protected @NonNull Model installDeclarations(@NonNull Resource asResource) {
		URI pivotURI = asResource.getURI();
		Model pivotModel2 = pivotModel = PivotUtil.createModel(umlURI != null ? umlURI.toString() : pivotURI.toString());
		asResource.getContents().add(pivotModel2);
		UML2ASDeclarationSwitch declarationPass = getDeclarationPass();
		List<org.eclipse.ocl.pivot.Package> rootPackages = new ArrayList<>();
		for (EObject eObject : umlResource.getContents()) {
			Object pivotElement = declarationPass.doSwitch(eObject);
			if (pivotElement instanceof org.eclipse.ocl.pivot.Package) {
				rootPackages.add((org.eclipse.ocl.pivot.Package) pivotElement);
			}
			else if (pivotElement != null) {			// Ignore stereotypes
				error("Bad UML content : " + eObject.eClass().getName());
			}
		}
		PivotUtilInternal.refreshList(pivotModel2.getOwnedPackages(), rootPackages);
		return pivotModel2;
	}

	protected boolean isPivot(@NonNull Collection<EObject> umlContents) {
		if (umlContents.size() != 1) {
			return false;
		}
		EObject umlRoot = umlContents.iterator().next();
		if (!(umlRoot instanceof EPackage)) {
			return false;
		}
		EPackage umlPackage = (EPackage) umlRoot;
		if (umlPackage.getEClassifier(PivotPackage.Literals.ENUMERATION_LITERAL.getName()) == null) {
			return false;
		}
		if (umlPackage.getEClassifier(PivotPackage.Literals.EXPRESSION_IN_OCL.getName()) == null) {
			return false;
		}
		if (umlPackage.getEClassifier(PivotPackage.Literals.OPERATION_CALL_EXP.getName()) == null) {
			return false;
		}
		if (umlPackage.getEClassifier(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION.getName()) == null) {
			return false;
		}
		return true;
	}

	public abstract void queueUse(@NonNull EObject eObject);

	/*	protected void refreshAnnotation(NamedElement pivotElement, String key, String value) {
		String source = PIVOT_URI;
		Annotation pivotAnnotation = null;
		for (Annotation annotation : pivotElement.getOwnedAnnotation()) {
			if (annotation.getName().equals(source)) {
				pivotAnnotation = annotation;
				break;
			}
		}
		if (pivotAnnotation == null) {
			pivotAnnotation = PivotFactory.eINSTANCE.createAnnotation();
			pivotAnnotation.setName(source);
			pivotElement.getOwnedAnnotation().add(pivotAnnotation);
		}
		Detail pivotDetail = PivotFactory.eINSTANCE.createDetail();
		pivotDetail.setName(key);
		pivotDetail.getValue().add(value);
		pivotAnnotation.getOwnedDetail().add(pivotDetail);
	} */

	protected @NonNull <T extends Element> T refreshElement(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull EObject umlElement) {
		assert pivotEClass != null;
		EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
		EObject pivotElement = eFactoryInstance.create(pivotEClass);
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	protected @NonNull <T extends NamedElement> T refreshNamedElement(@NonNull Class<T> pivotClass,
			/*@NonNull*/ EClass pivotEClass, org.eclipse.uml2.uml.@NonNull NamedElement umlNamedElement) {
		assert pivotEClass != null;
		EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
		EObject pivotElement = eFactoryInstance.create(pivotEClass);
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		castElement.setName(umlNamedElement.getName());
		return castElement;
	}

	public ExpressionInOCL refreshOpaqueExpression(org.eclipse.uml2.uml.@NonNull OpaqueExpression umlExpression) {
		ExpressionInOCL pivotElement = refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlExpression);
		pivotElement.setBody(null);
		List<String> umlBodies = umlExpression.getBodies();
		List<String> umlLanguages = umlExpression.getLanguages();
		for (int i = 0; i < umlBodies.size(); i++) {
			String asLanguage = PivotConstants.OCL_LANGUAGE;
			if (i < umlLanguages.size()) {		// languages are optional, with defaults implementation defined ==> OCL
				String umlLanguage = umlLanguages.get(i);
				if ((umlLanguage != null) && (umlLanguage.length() > 0)) {
					asLanguage = umlLanguage;
				}
			}
			String umlBody = umlBodies.get(i);
			if ((umlBody != null) && asLanguage.equals(PivotConstants.OCL_LANGUAGE)) {
				EObject eContainer = umlExpression.eContainer();
				if (eContainer instanceof org.eclipse.uml2.uml.Constraint) {
					EObject eContainerContainer = eContainer.eContainer();
					if (eContainerContainer instanceof org.eclipse.uml2.uml.Operation) {
						org.eclipse.uml2.uml.Operation umlOperation = (org.eclipse.uml2.uml.Operation)eContainerContainer;
						if (umlOperation.getBodyCondition() == eContainer) {
							umlBody = PivotUtilInternal.getBodyExpression(umlBody);
						}
					}
				}
				pivotElement.setBody(umlBody);
				break;
			}
		}
		copyNamedElement(pivotElement, umlExpression);
		return pivotElement;
	}

	public abstract void resolveMultiplicity(@NonNull TypedElement pivotElement, org.eclipse.uml2.uml.@NonNull TypedElement umlTypedElement);

	/**
	 * Return the UML Stereotype referenced by the UML stereotype application to some UML Stereotyped Elements.
	 *<p>
	 * Note that the reference in the UML Stereotype application is to a particular Ecore version of the Profile, rather than
	 * to the UML profile, so we have to locate the UML profile by URI and name.
	 */
	public @Nullable Stereotype resolveStereotype(@NonNull EObject umlStereotypeApplication, @NonNull List<org.eclipse.uml2.uml.Element> umlStereotypedElements) {
		ClassUtil.nonNullState(pivotModel);
		EClass umlStereotypeEClass = umlStereotypeApplication.eClass();
		if (!(umlStereotypeApplication instanceof DynamicEObjectImpl)) {					// If stereotyped element has been genmodelled
			Stereotype asStereotype = metamodelManager.getASOfEcore(Stereotype.class, umlStereotypeEClass);
			return asStereotype;		// then it is already a Type rather than a Stereotype
		}
		//
		//	Get the umlStereotypedPackage common to all the base_xxx elements
		//
		org.eclipse.uml2.uml.Package umlStereotypedPackage = null;
		for (org.eclipse.uml2.uml.Element umlStereotypedElement : umlStereotypedElements) {
			for (EObject eObject = umlStereotypedElement; eObject != null; eObject = eObject.eContainer()) {
				if (eObject instanceof org.eclipse.uml2.uml.Package) {
					if (umlStereotypedPackage == null) {
						umlStereotypedPackage = (org.eclipse.uml2.uml.Package)eObject;
					}
					else if (umlStereotypedPackage != (org.eclipse.uml2.uml.Package)eObject) {
						error("Conflicting packages for stereotype application of " + umlStereotypeEClass.getName());
					}
					break;
				}
			}
		}
		//
		//	Get the pivot profile for which the profileNsURI is an application to the stereotypedPackage
		//
		EPackage umlProfileEPackage = umlStereotypeEClass.getEPackage();
		if (umlStereotypedPackage != null) {
			Set<org.eclipse.uml2.uml.@NonNull Package> allAppliedProfilePackages = getAllAppliedProfilePackages(umlStereotypedPackage);
			String profileNsURI = umlProfileEPackage.getNsURI();
			for (org.eclipse.uml2.uml.Package umlPackage : allAppliedProfilePackages) {
				if (profileNsURI.equals(umlPackage.getURI())) {
					org.eclipse.uml2.uml.Stereotype umlStereotype = umlPackage.getOwnedStereotype(umlStereotypeEClass.getName());
					return umlStereotype != null ? getCreated(Stereotype.class, umlStereotype) : null;
				}
			}
			String profileName = umlProfileEPackage.getName();		// This is really only needed for a bad legacy test case
			for (org.eclipse.uml2.uml.Package umlPackage : allAppliedProfilePackages) {
				if (profileName.equals(umlPackage.getName())) {
					org.eclipse.uml2.uml.Stereotype umlStereotype = umlPackage.getOwnedStereotype(umlStereotypeEClass.getName());
					return umlStereotype != null ? getCreated(Stereotype.class, umlStereotype) : null;
				}
			}
		}
		StringBuilder s = new StringBuilder();
		s.append("Failed to resolve package URI '");
		s.append(umlProfileEPackage.getNsURI());
		s.append("' for «");
		s.append(umlStereotypeEClass.getName());
		s.append("» for");
		Map<ILabelGenerator.Option<?>, Object> options = new HashMap<>();
		options.put(ILabelGenerator.Builder.SHOW_QUALIFIER, "::");
		for (org.eclipse.uml2.uml.Element umlStereotypedElement : umlStereotypedElements) {
			s.append(" ");
			s.append(ILabelGenerator.Registry.INSTANCE.labelFor(umlStereotypedElement, options));
		}
		error(s.toString());
		return null;
	}

	protected @Nullable Type resolveType(org.eclipse.uml2.uml.@NonNull Type umlType) {
		Type pivotType = getCreated(Type.class, umlType);
		if (pivotType != null) {
			return pivotType;
		}
		/*		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		if (eTypeParameter != null) {
			pivotType = resolveTypeParameter(eGenericType);
		}
		else if (eClassifier == null) {
			pivotType = resolveWildcardType(eGenericType);
		}
		else if (!eTypeArguments.isEmpty()) {
			String ecoreMoniker = UML2Moniker.toString(eGenericType);
			pivotType = resolvedSpecializations.get(ecoreMoniker);
			if (pivotType == null) {
				pivotType = resolveGenericType(resolvedSpecializations, eGenericType);
				resolvedSpecializations.put(ecoreMoniker, pivotType);
			}
		}
		else if (eClassifier instanceof EDataType) {
			pivotType = resolveDataType(eGenericType);
		}
		else {
			pivotType = resolveSimpleType(eGenericType);
		}
		createMap.put(eGenericType, pivotType); */
		if (umlType instanceof org.eclipse.uml2.uml.PrimitiveType) {
			if (UMLUtil.isBoolean(umlType)) {
				return standardLibrary.getBooleanType();
			}
			else if (UMLUtil.isInteger(umlType)) {
				return standardLibrary.getIntegerType();
			}
			else if (UMLUtil.isReal(umlType)) {
				return standardLibrary.getRealType();
			}
			else if (UMLUtil.isString(umlType)) {
				return standardLibrary.getStringType();
			}
			else if (UMLUtil.isUnlimitedNatural(umlType)) {
				return standardLibrary.getUnlimitedNaturalType();
			}
			//			org.eclipse.uml2.uml.Package umlPackage = umlType.getPackage();
			//			Resource umlResource = umlType.eResource();
			//			if ((umlPackage instanceof org.eclipse.uml2.uml.Model) && "EcorePrimitiveTypes".equals(umlPackage.getName())			// No nsURI available
			//					&& (umlResource != null) && UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI.equals(umlResource.getURI())) {
			//
			//			}
		}
		return pivotType;
	}

	protected @Nullable Type resolveTypeParameter(@NonNull EGenericType eGenericType) {
		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		if (eTypeParameter != null) {
			List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
			assert eClassifier == null;
			assert eTypeArguments.isEmpty();
			Type pivotType = getCreated(Type.class, eTypeParameter);
			return pivotType;
		}
		else {
			return null;
		}
	}

	protected @Nullable Type resolveWildcardType(@NonNull EGenericType eGenericType) {
		assert eGenericType.getETypeArguments().isEmpty();
		assert eGenericType.getEClassifier() == null;
		EClassifier eClassifier = eGenericType.getERawType();
		assert eClassifier == EcorePackage.Literals.EJAVA_OBJECT;
		/*			WildcardTypeRefCS csTypeRef = BaseCSFactory.eINSTANCE.createWildcardTypeRefCS();
			setOriginalMapping(csTypeRef, eObject);
//			csTypeRef.setExtends(doSwitchAll(eGenericType.getExtends()));
//			csTypeRef.setSuper(doSwitchAll(eGenericType.getSuper()));
			return csTypeRef; */
		org.eclipse.ocl.pivot.Class pivotElement = PivotFactory.eINSTANCE.createClass();
		String name = PivotConstantsInternal.WILDCARD_NAME;
		EStructuralFeature eFeature = eGenericType.eContainmentFeature();
		if ((eFeature != null) && eFeature.isMany()) {
			EObject eContainer = eGenericType.eContainer();
			List<?> list = (List<?>)eContainer.eGet(eGenericType.eContainingFeature());
			int index = list.indexOf(eGenericType);
			if (index != 0) {
				name += index;
			}
		}
		pivotElement.setName(name);
		return pivotElement;
	}

	protected void setOriginalMapping(@NonNull Element pivotElement, @NonNull EObject umlElement) {
		((PivotObjectImpl)pivotElement).setESObject(umlElement);
		addCreated(umlElement, pivotElement);
	}

	public void setUMLURI(URI umlURI) {
		this.umlURI  = umlURI;
	}

	@Override
	public String toString() {
		return String.valueOf(umlResource.getURI());
	}
}
