/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA List) - Bug 424057 - UML 2.5 CG *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore.es2as;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ecore.Ecore2Moniker;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.AliasAdapter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.pivot.model.OCLmetamodel;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager.IPackageDescriptor;
import org.eclipse.ocl.pivot.resource.ProjectManager.IProjectDescriptor;
import org.eclipse.ocl.pivot.resource.ProjectManager.IProjectDescriptor.IProjectDescriptorExtension;
import org.eclipse.ocl.pivot.resource.ProjectManager.IResourceDescriptor;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.TreeIterable;

/**
 * Manage conversio  of a *.ecore model to a *.ecore.oclas.
 *
 * FIXME This class has evolved to partially support loading OCLstdlib.ecore for direct use by Model2TablesGenerator. However
 * Iterations are not modelled so for now Model2TablesGenerator must continue to rely on a previously load by GenerateOCLstdlibXtend
 */
public class Ecore2AS extends AbstractExternal2AS
{
	/**
	 * @since 1.3
	 */
	public static final @NonNull TracingOption NOT_OPTIONAL = new TracingOption(PivotPlugin.PLUGIN_ID, "ecore2as/notOptional");

	/**
	 * @since 1.14
	 */
	public static @Nullable Ecore2AS basicGetAdapter(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
		External2AS adapter = findAdapter(resource, environmentFactory);
		Ecore2AS castAdapter = (Ecore2AS) adapter;
		return castAdapter;
	}

	public static @NonNull Ecore2AS getAdapter(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
		Ecore2AS castAdapter = basicGetAdapter(resource, environmentFactory);
		if (castAdapter == null) {
			castAdapter = new Ecore2AS(resource, environmentFactory);
		}
		return castAdapter;
	}

	/**
	 * Convert an (annotated) Ecore resource to a Pivot Model.
	 * @param alias
	 *
	 * @param ecoreResource the annotated Ecore resource
	 *
	 * @return the Pivot root package
	 */
	public static @NonNull Model importFromEcore(@NonNull EnvironmentFactoryInternal environmentFactory, String alias, @NonNull Resource ecoreResource) {
		Ecore2AS conversion = getAdapter(ecoreResource, environmentFactory);
		return conversion.getASModel();
	}

	public static boolean isEcore(@NonNull Resource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			if (content instanceof EPackage) {
				return true;
			}
		}
		return false;
	}

	@Deprecated /* @deprecated for API compatibility */
	public static boolean isNullFree(@NonNull ETypedElement eObject) {
		return isNullFree((ENamedElement)eObject);
	}

	/**
	 * @since 1.18
	 */
	public static boolean isNullFree(@NonNull ENamedElement eObject) {
		boolean isNullFree;
		EAnnotation eAnnotation = eObject.getEAnnotation(PivotConstants.COLLECTION_ANNOTATION_SOURCE);
		if (eAnnotation != null) {
			isNullFree = Boolean.valueOf(eAnnotation.getDetails().get(PivotConstants.COLLECTION_IS_NULL_FREE));
		}
		else {
			EObject eContainer = eObject.eContainer();
			if (eContainer instanceof ENamedElement) {
				isNullFree = isNullFree((ENamedElement)eContainer);
			}
			else {
				isNullFree = true;		// UML collections are always null-free.Make it the undeclared default.
			}
		}
		return isNullFree;
	}

	public static @Nullable Ecore2AS loadFromEcore(@NonNull ASResource ecoreASResource, @NonNull URI ecoreURI) {
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(ecoreASResource);
		ResourceSet resourceSet = environmentFactory.getResourceSet();
		Resource ecoreResource = resourceSet.getResource(ecoreURI, true);
		if (ecoreResource == null) {
			return null;
		}
		Ecore2AS conversion = getAdapter(ecoreResource, environmentFactory);
		conversion.loadImports(ecoreResource);
		//		if (asMetamodels != null) {
		//
		//		}
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		conversion.pivotModel = PivotUtil.createModel(ecoreASResource.getURI().toString());
		//		conversion.installImports();
		conversion.update(ecoreASResource, ClassUtil.nonNullEMF(ecoreResource.getContents()));

		AliasAdapter ecoreAdapter = AliasAdapter.findAdapter(ecoreResource);
		if (ecoreAdapter != null) {
			Map<EObject, String> ecoreAliasMap = ecoreAdapter.getAliasMap();
			AliasAdapter pivotAdapter = AliasAdapter.getAdapter(ecoreASResource);
			Map<EObject, String> pivotAliasMap = pivotAdapter.getAliasMap();
			for (EObject eObject : ecoreAliasMap.keySet()) {
				String alias = ecoreAliasMap.get(eObject);
				Element element = conversion.newCreateMap.get(eObject);
				pivotAliasMap.put(element, alias);
			}
		}
		metamodelManager.installResource(ecoreASResource);
		conversion.installImports();
		return conversion;
	}

	/*	public static Ecore2AS createConverter(MetamodelManager metamodelManager, Resource ecoreResource) {
		EList<Adapter> eAdapters = ecoreResource.eAdapters();
		Ecore2AS conversion = (Ecore2AS) EcoreUtil.getAdapter(eAdapters, Ecore2AS.class);
		if (conversion == null) {
			conversion = new Ecore2AS(metamodelManager);
			eAdapters.add(conversion);
		}
		return conversion;
	} */

	/**
	 * Convert an (annotated) Ecore object to a pivot element.
	 *
	 * @param eObject the annotated Ecore object
	 *
	 * @return the pivot element
	 */
	public static Element importFromEcore(@NonNull EnvironmentFactoryInternal environmentFactory, String alias, @NonNull EObject eObject) {
		Resource ecoreResource = ClassUtil.nonNullEMF(eObject.eResource());
		Ecore2AS conversion = getAdapter(ecoreResource, environmentFactory);
		@SuppressWarnings("unused")
		Model pivotModel = conversion.getASModel();
		return conversion.newCreateMap.get(eObject);
	}

	/**
	 * Mapping of source Ecore objects to their resulting pivot element in a previous conversion.
	 */
	private Map<@NonNull String, @NonNull Element> oldIdMap = null;

	/**
	 * Mapping of source Ecore objects to their resulting pivot element in the current conversion.
	 */
	private Map<@NonNull EObject, @NonNull Element> newCreateMap = null;

	/**
	 * Set of all Ecore objects requiring further work during the reference pass.
	 */
	private Set<@NonNull EObject> referencers = null;

	/**
	 * Set of all converters used during session.
	 */
	private Set<@NonNull Ecore2AS> allConverters = new HashSet<>();

	/**
	 * List of all EDataTypes that might need special case mapping via the ecore2asMap. Non-null during declaration pass.
	 */
	private @Nullable List<@NonNull EDataType> eDataTypes = null;

	/**
	 * List of all generic types. Non-null during declaration pass.
	 */
	private @Nullable List<@NonNull EGenericType> genericTypes = null;

	private List<Resource.@NonNull Diagnostic> errors = null;

	protected final @NonNull Resource ecoreResource;

	protected Model pivotModel = null;						// Set by importResource
	@Deprecated /* Now a local variable */
	protected final Ecore2ASDeclarationSwitch declarationPass = null;
	@Deprecated /* Now a local variable */
	protected final Ecore2ASReferenceSwitch referencePass = null;
	private @NonNull Map</*@NonNull*/ EClassifier, @NonNull Type> ecore2asMap = new HashMap<>();

	/**
	 * The loadableURI of the ecoreResource, which may differ from ecoreResource.getURI() when
	 * ecoreResource is an installed package whose nsURI may not be globally registered. The accessible
	 * URI is used for the AS URI to ensure that the saved serialized XMI is loadable using the source
	 * *.ecore's rather than the missing nsURI regisyrations.
	 */
	private URI ecoreURI = null;

	/**
	 * All imported EPackages identified by AS_METAMODEL_ANNOTATION_SOURCE annotations.
	 */
	private Set<EPackage> asMetamodels = null;

	/**
	 * All imported EObjects identified as IMPORT_ANNOTATION_SOURCE annotations.
	 */
	private Set<EObject> importedEObjects = null;

	public Ecore2AS(@NonNull Resource ecoreResource, @NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
		this.ecoreResource = ecoreResource;
		this.environmentFactory.addExternal2AS(this);
	}

	protected void addCreated(@NonNull EObject eObject, @NonNull Element pivotElement) {
		@SuppressWarnings("unused")
		Element oldElement = newCreateMap.put(eObject, pivotElement);
	}

	@Override
	public void addGenericType(@NonNull EGenericType eObject) {
		assert genericTypes != null;
		genericTypes.add(eObject);
	}

	@Override
	public void addMapping(@NonNull EObject eObject, @NonNull Element pivotElement) {
		if (pivotElement instanceof PivotObjectImpl) {
			((PivotObjectImpl)pivotElement).setESObject(eObject);
		}
		Element pivotElement1 = pivotElement;
		if (eObject instanceof EDataType) {
			assert eDataTypes != null;
			eDataTypes.add((EDataType) eObject);
		}
		addCreated(eObject, pivotElement1);
	}

	@Override
	protected Model basicGetPivotModel() {
		return pivotModel;
	}

	protected @NonNull URI createPivotURI() {
		if (ecoreURI != null) {
			return PivotUtilInternal.getASURI(ecoreURI.trimFragment());
		}
		URI uri = ecoreResource.getURI();
		if (uri == null) {
			throw new IllegalStateException("Missing resource URI");
		}
		return PivotUtilInternal.getASURI(uri);
	}

	@Override
	public void error(@Nullable String message) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(new XMIException(message));
	}

	public <T extends Element> T getASElement(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		if (pivotModel == null) {
			getASModel();
		}
		Element element = newCreateMap.get(eObject);
		if (element == null) {
			Resource resource = eObject.eResource();
			if ((resource != ecoreResource) && (resource != null)) {
				Ecore2AS converter = getAdapter(resource, environmentFactory);
				if (allConverters.add(converter)) {
					converter.getASModel();
					for (Map.Entry<@NonNull EObject, @NonNull Element> entry : converter.newCreateMap.entrySet()) {
						addCreated(entry.getKey(), entry.getValue());
					}
				}
			}
			element = newCreateMap.get(eObject);
		}
		if (element == null) {
			error("Unresolved " + eObject);
		}
		else if (!requiredClass.isAssignableFrom(element.getClass())) {
			throw new ClassCastException(element.getClass().getName() + " is not assignable to " + requiredClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) element;
		return castElement;
	}

	@Override
	public @NonNull Model getASModel() {
		Model pivotModel2 = pivotModel;
		if (pivotModel2 == null) {
			loadImports(ecoreResource);
			pivotModel2 = pivotModel = importObjects(ClassUtil.nonNullEMF(ecoreResource.getContents()), createPivotURI());
			ASResource asResource = (ASResource) pivotModel.eResource();
			boolean wasUpdating = asResource.setUpdating(true);
			installImports();
			asResource.setUpdating(wasUpdating);
		}
		return pivotModel2;
	}

	public @Nullable <T extends Element> T getASOfEcore(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		if (pivotModel == null) {
			getASModel();
		}
		assert eDataTypes == null;
		Element element = newCreateMap.get(eObject);
		if (element == null) {
			return null;
		}
		if (!requiredClass.isAssignableFrom(element.getClass())) {
			throw new ClassCastException(element.getClass().getName() + " is not assignable to " + requiredClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) element;
		return castElement;
	}

	public Type getASType(@NonNull EObject eObject) {
		Element pivotElement = newCreateMap.get(eObject);
		if (pivotElement == null) {
			Resource resource = eObject.eResource();
			if ((resource != ecoreResource) && (resource != null)) {
				Ecore2AS converter = getAdapter(resource, environmentFactory);
				if (allConverters.add(converter)) {
					converter.getASModel();
					//					allEClassifiers.addAll(converter.allEClassifiers);
					//					allNames.addAll(converter.allNames);
					for (Map.Entry<@NonNull EObject, @NonNull Element> entry : converter.newCreateMap.entrySet()) {
						addCreated(entry.getKey(), entry.getValue());
					}
				}
			}
			pivotElement = newCreateMap.get(eObject);
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

	/**
	 * Return the baseURI of ecoreResource against which its imports should be resolved.
	 */
	protected @Nullable URI getBaseURI(@NonNull Resource ecoreResource) {
		URI ecoreURI = ecoreResource.getURI();
		if (ecoreURI == null) {
			return null;
		}
		if (ClassUtil.isRegistered(ecoreResource)) {
			ProjectManager projectManager = environmentFactory.getProjectManager();
			StandaloneProjectMap.IPackageDescriptor packageDescriptor = projectManager.getPackageDescriptor(ecoreURI);
			if (packageDescriptor == null) {
				return null;
			}
			return packageDescriptor.getResourceDescriptor().getPlatformPluginURI();
		}
		else {
			if (!ecoreURI.isHierarchical() || ecoreURI.isRelative()) {
				return null;
			}
			return ecoreURI;
		}
	}

	public @Nullable Element getCreated(@NonNull EObject eObject) {
		assert eDataTypes == null;
		return newCreateMap.get(eObject);
	}

	@Override
	public @Nullable <T extends Element> T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		assert eDataTypes == null;
		return getASOfEcore(requiredClass, eObject);
	}

	@Override
	public @Nullable Map<@NonNull EObject, @NonNull Element> getCreatedMap() {
		assert eDataTypes == null;
		return newCreateMap;
	}

	@Deprecated
	public @NonNull Map<EClassifier, Type> getEcore2ASMap() {
		return ecore2asMap;
	}

	public @Nullable Resource getEcoreResource() {
		return ecoreResource;
	}

	@Override
	public @Nullable Resource getResource() {
		return ecoreResource;
	}

	@Override
	public @NonNull URI getURI() {
		return ClassUtil.nonNullEMF(ecoreResource.getURI());
	}

	public @NonNull Model importObjects(@NonNull Collection<@NonNull EObject> ecoreContents, @NonNull URI pivotURI) {
		EPackage libraryEPackage = isLibrary(ecoreContents);
		if (libraryEPackage != null) {			 // when generating OCLstdlib
			newCreateMap = new HashMap<>();
			AnyType asAnyType = standardLibrary.basicGetOclAnyType();
			org.eclipse.ocl.pivot.Package asLibrary = asAnyType != null ? asAnyType.getOwningPackage() : null;
			if (asLibrary != null) {
				addCreated(libraryEPackage, asLibrary);
				List<org.eclipse.ocl.pivot.Class> ownedTypes = asLibrary.getOwnedClasses();
				//			int prefix = LibraryConstants.ECORE_STDLIB_PREFIX.length();
				for (@SuppressWarnings("null")@NonNull EClassifier eClassifier : libraryEPackage.getEClassifiers()) {
					String name = environmentFactory.getTechnology().getOriginalName(eClassifier); //.substring(prefix);
					Type asType = NameUtil.getNameable(ownedTypes, name);
					if (asType != null) {
						addCreated(eClassifier, asType);
					}
				}
				Model containingRoot = PivotUtil.getContainingModel(asLibrary);
				return ClassUtil.nonNullModel(containingRoot);
			}
		}
		@NonNull ASResource asResource = metamodelManager.getResource(pivotURI, ASResource.ECORE_CONTENT_TYPE);
		asResource.setSaveable(false);
		//		try {
		if (metamodelManager.getLibraryResource() == null) {
			if (libraryEPackage != null) {
				metamodelManager.installResource(asResource);
			}
			else if (isPivot(ecoreContents)) {
				String nsURI = ((EPackage)ecoreContents.iterator().next()).getNsURI();
				if (nsURI != null) {
					String stdlibASUri = LibraryConstants.STDLIB_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION;
					OCLstdlib library = OCLstdlib.create(stdlibASUri);
					metamodelManager.installResource(library);
				}
			}
		}
		URI uri = ecoreURI != null ? ecoreURI : ecoreResource.getURI();
		Model pivotModel2 = null;
		if (asResource.getContents().size() > 0) {
			EObject eObject = asResource.getContents().get(0);
			if (eObject instanceof Model) {
				pivotModel2 = (Model) eObject;
			}
		}
		if (pivotModel2 == null) {
			pivotModel2 = pivotModel = PivotUtil.createModel(uri.toString());
		}
		pivotModel = pivotModel2;
		//			installImports();
		newCreateMap = synthesizeCreateMap(asResource);
		if (newCreateMap == null) {
			update(asResource, ecoreContents);
		}
		List<Diagnostic> errors2 = errors;
		if (errors2 != null) {
			asResource.getErrors().addAll(ClassUtil.nullFree(errors2));
		}
		return pivotModel2;
	}

	private @Nullable Map<@NonNull EObject, @NonNull Element> synthesizeCreateMap(@NonNull ASResource asResource) {
		Model pivotModel2 = pivotModel;
		assert pivotModel2 != null;
		if (asResource instanceof OCLmetamodel) {					// FIXME polymorphize as a cached derived ASResourceImpl capability
			Map<@NonNull EObject, @NonNull Element> createMap = new HashMap<>();
			for (TreeIterator<EObject> tit = pivotModel2.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Element) {
					Element asElement = (Element)eObject;
					EObject esObject = asElement.getESObject();
					if (esObject != null) {
						createMap.put(esObject, asElement);
					}
				}
			}
			createMap.put(ClassUtil.nonNullEMF(PivotPackage.Literals.BOOLEAN), standardLibrary.getBooleanType());
			createMap.put(ClassUtil.nonNullEMF(PivotPackage.Literals.INTEGER), standardLibrary.getIntegerType());
			createMap.put(ClassUtil.nonNullEMF(PivotPackage.Literals.REAL), standardLibrary.getRealType());
			createMap.put(ClassUtil.nonNullEMF(PivotPackage.Literals.STRING), standardLibrary.getStringType());
			createMap.put(ClassUtil.nonNullEMF(PivotPackage.Literals.UNLIMITED_NATURAL), standardLibrary.getUnlimitedNaturalType());
			return createMap;
		}
		else if (asResource instanceof OCLstdlib) {					// FIXME polymorphize as a cached derived ASResourceImpl capability
			Map<@NonNull EObject, @NonNull Element> createMap = new HashMap<>();
			for (EObject eObject : new TreeIterable(pivotModel2, false)) {
				if (eObject instanceof Element) {
					Element asElement = (Element)eObject;
					EObject esObject = asElement.getESObject();
					if (esObject != null) {
						createMap.put(esObject, asElement);
					}
				}
			}
			return createMap;
		}
		else {
			return null;
		}
	}

	public void initializeEcore2ASMap() {
		org.eclipse.ocl.pivot.Class booleanType = standardLibrary.getBooleanType();
		org.eclipse.ocl.pivot.Class integerType = standardLibrary.getIntegerType();
		org.eclipse.ocl.pivot.Class realType = standardLibrary.getRealType();
		org.eclipse.ocl.pivot.Class stringType = standardLibrary.getStringType();
		ecore2asMap.put(EcorePackage.Literals.EBOOLEAN_OBJECT, booleanType);
		ecore2asMap.put(EcorePackage.Literals.EBOOLEAN, booleanType);
		ecore2asMap.put(EcorePackage.Literals.EBIG_INTEGER, integerType);
		ecore2asMap.put(EcorePackage.Literals.EBIG_DECIMAL, realType);
		ecore2asMap.put(EcorePackage.Literals.ESTRING, stringType);
	}

	/**
	 * @since 1.17
	 */
	public void initializeLibrary() {
		if (standardLibrary.basicGetOclAnyType() != null) {
			return;
		}
		List<org.eclipse.ocl.pivot.@NonNull Class> asClasses = null;
		boolean needsLibrary = true;
		for (EObject eRoot : ecoreResource.getContents()) {		// All one EPackage
			if (eRoot instanceof EPackage) {
				EPackage ePackage = (EPackage)eRoot;
				boolean hasOclAny = ePackage.getEClassifier(TypeId.OCL_ANY_NAME) != null;
				boolean hasBoolean = ePackage.getEClassifier(TypeId.BOOLEAN_NAME) instanceof EDataType;
				if (hasOclAny) {
					needsLibrary = false;
				}
				if (hasOclAny || hasBoolean) {
					for (EClassifier eClassifier : ePackage.getEClassifiers()) {
						Element asClass = newCreateMap.get(eClassifier);
						assert asClass != null;
						if (asClasses == null) {
							asClasses = new ArrayList<>();
						}
						asClasses.add((org.eclipse.ocl.pivot.Class)asClass);
					}
				}
			}
		}
		if (needsLibrary && (asClasses != null)) {
			Set<String> installName= new HashSet<>();
			for (org.eclipse.ocl.pivot.@NonNull Class asClass : asClasses) {
				installName.add(asClass.getName());
			}
			for (org.eclipse.ocl.pivot.Class asClass : OCLstdlib.getDefaultPackage().getOwnedClasses()) {		// FIXME use contribution
				assert asClass != null;
				if (!installName.contains(asClass.getName())) {
					asClasses.add(asClass);
				}
			}
			standardLibrary.defineLibraryTypes(asClasses);
		}
	}

	protected void installImports() {
		URI baseURI = getBaseURI(ecoreResource);
		List<Import> allImports = pivotModel.getOwnedImports();
		for (EObject eContent : ecoreResource.getContents()) {
			if (eContent instanceof EModelElement) {
				EAnnotation importAnnotation = ((EModelElement)eContent).getEAnnotation(PivotConstants.IMPORT_ANNOTATION_SOURCE);
				if (importAnnotation != null) {
					EMap<String, String> details = importAnnotation.getDetails();
					for (String key : details.keySet()) {
						String value = details.get(key);
						if (value == null) {
							value = key;
							key = "";
						}
						URI uri = URI.createURI(value);
						if (baseURI != null) {
							uri = uri.resolve(baseURI);
						}
						try {
							assert uri != null;
							Element importedObject = metamodelManager.loadResource(uri, null, ecoreResource.getResourceSet());
							if (importedObject instanceof Namespace) {
								Import anImport = PivotFactory.eINSTANCE.createImport();
								anImport.setName(key);
								anImport.setImportedNamespace((Namespace) importedObject);
								allImports.add(anImport);
							}
						} catch (ParserException e) {
							error(e.getMessage());
						}
					}
				}
			}
		}
	}

	/**
	 * Return the first EPackage element of ecoreContents that has an ASLibrary annotation.
	 */
	protected @Nullable EPackage isLibrary(@NonNull Collection<@NonNull EObject> ecoreContents) {
		if (ecoreContents.size() != 1) {
			return null;
		}
		EObject ecoreRoot = ecoreContents.iterator().next();
		if (!(ecoreRoot instanceof EPackage)) {
			return null;
		}
		EPackage ecorePackage = (EPackage)ecoreRoot;
		return isLibrary(ecorePackage) ? ecorePackage : null;
	}

	protected boolean isPivot(@NonNull Collection<@NonNull EObject> ecoreContents) {
		if (ecoreContents.size() != 1) {
			return false;
		}
		EObject ecoreRoot = ecoreContents.iterator().next();
		if (!(ecoreRoot instanceof EPackage)) {
			return false;
		}
		EPackage ecorePackage = (EPackage) ecoreRoot;
		if (ClassUtil.basicGetMetamodelAnnotation(ecorePackage) != null) {
			return true;
		}
		// FIXME Following code should be redundant
		if (ecorePackage.getEClassifier(PivotPackage.Literals.ENUMERATION_LITERAL.getName()) == null) {
			return false;
		}
		if (ecorePackage.getEClassifier(PivotPackage.Literals.EXPRESSION_IN_OCL.getName()) == null) {
			return false;
		}
		if (ecorePackage.getEClassifier(PivotPackage.Literals.OPERATION_CALL_EXP.getName()) == null) {
			return false;
		}
		if (ecorePackage.getEClassifier(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION.getName()) == null) {
			return false;
		}
		return true;
	}

	/**
	 * Load all transitively referenced *.ecore files and identify any EPackages identified
	 * as OCL AS Metamodels.
	 */
	protected void loadImports(@NonNull Resource ecoreResource) {
		URI baseURI = getBaseURI(ecoreResource);
		for (EObject eContent : ecoreResource.getContents()) {
			if (eContent instanceof EPackage) {
				loadImports((EPackage)eContent, baseURI);
			}
		}
		if ((asMetamodels != null) && (metamodelManager.getLibraryResource() == null)) {
			String nsURI = asMetamodels.iterator().next().getNsURI();
			if (nsURI != null) {
				OCLstdlib library = OCLstdlib.getDefault(); //create(stdlibASUri, "ocl", "ocl", nsURI);
				metamodelManager.installResource(library);
			}
		}
	}
	protected void loadImports(@NonNull EPackage ePackage, @Nullable URI baseURI) {
		if (ClassUtil.basicGetMetamodelAnnotation(ePackage) != null) {
			if (asMetamodels == null) {
				asMetamodels = new HashSet<>();
			}
			asMetamodels.add(ePackage);
		}
		EAnnotation importAnnotation = ePackage.getEAnnotation(PivotConstants.IMPORT_ANNOTATION_SOURCE);
		if (importAnnotation != null) {
			EMap<String, String> details = importAnnotation.getDetails();
			for (String key : details.keySet()) {
				String value = details.get(key);
				if (value == null) {
					value = key;
					key = "";
				}
				URI uri = URI.createURI(value);
				uri = resolveImportURI(uri, ePackage, baseURI);
				assert uri != null;
				ResourceSet resourceSet = environmentFactory.getResourceSet();
				EObject importedEObject = null;
				String fragment = uri.fragment();
				if (fragment == null) {
					importedEObject = resourceSet.getPackageRegistry().getEPackage(uri.toString());
				}
				else {
					importedEObject = resourceSet.getEObject(uri, true);
				}
				if (importedEObject != null) {
					if (importedEObjects == null) {
						importedEObjects = new HashSet<>();
					}
					if (importedEObjects.add(importedEObject) && (importedEObject instanceof EPackage)) {
						Resource importedResource = importedEObject.eResource();
						if (importedResource != null) {
							URI baseURI2 = getBaseURI(importedResource);
							loadImports((EPackage)importedEObject, baseURI2);
						}
					}
				}
			}
		}
		for (EPackage eSubPackage : ePackage.getESubpackages()) {
			if (eSubPackage != null) {
				loadImports(eSubPackage, baseURI);
			}
		}
	}

	private @NonNull URI resolveImportURI(@NonNull URI uri, @NonNull EPackage ePackage, @Nullable URI baseURI) {
		if (baseURI == null) {
			return uri;
		}
		ProjectManager projectManager = environmentFactory.getProjectManager();
		if (!(projectManager instanceof StandaloneProjectMap)) {
			return uri;
		}
		StandaloneProjectMap projectMap = (StandaloneProjectMap)projectManager;
		uri = uri.resolve(baseURI);
		if (uri.isPlatformPlugin() && ClassUtil.safeEquals(ePackage.getNsURI(), String.valueOf(ePackage.eResource().getURI())) && (uri.segmentCount() >= 1)) {
			@NonNull String projectName = uri.segment(1);
			IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(projectName);
			if (projectDescriptor instanceof IProjectDescriptorExtension) {
				Collection<IResourceDescriptor> resourceDescriptors = projectDescriptor.getResourceDescriptors();
				if (resourceDescriptors != null) {
					for (IResourceDescriptor resourceDescriptor : resourceDescriptors) {
						if (ClassUtil.safeEquals(uri.trimFragment(), resourceDescriptor.getPlatformPluginURI())) {
							Iterable<@NonNull IPackageDescriptor> packageDescriptors = ((IProjectDescriptorExtension)projectDescriptor).getPackageDescriptors();
							if (packageDescriptors != null) {
								for (IPackageDescriptor packageDescriptor : packageDescriptors) {
									uri = packageDescriptor.getNsURI();
									break;
								}
							}

							break;
						}
					}
				}
			}
		}
		return uri;
	}

	@Override
	public void queueReference(@NonNull EObject eObject) {
		referencers.add(eObject);
	}

	@Override
	public <@NonNull T extends NamedElement> T refreshElement(@NonNull Class<T> pivotClass, EClass pivotEClass, @NonNull EModelElement eModelElement) {
		EObject pivotElement = null;
		if (oldIdMap != null) {
			String id = ((XMLResource)eModelElement.eResource()).getID(eModelElement);
			if (id != null) {
				pivotElement = oldIdMap.get(id);
				if ((pivotElement != null) && (pivotElement.eClass() != pivotEClass)) {
					pivotElement = null;
				}
			}
		}
		if (pivotElement == null) {
			EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
			pivotElement = eFactoryInstance.create(pivotEClass);
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
	/*	Element oldElement = */ addCreated(eModelElement, castElement);
	//	assert oldElement == null;
		return castElement;
	}

	/**
	 * @since 1.17
	 */
	protected void resolveAliases(@NonNull Resource asResource) {
		AliasAdapter ecoreAdapter = AliasAdapter.findAdapter(ecoreResource);
		if (ecoreAdapter != null) {
			Map<EObject, String> ecoreAliasMap = ecoreAdapter.getAliasMap();
			AliasAdapter pivotAdapter = AliasAdapter.getAdapter(asResource);
			Map<EObject, String> pivotAliasMap = pivotAdapter.getAliasMap();
			for (EObject eObject : ecoreAliasMap.keySet()) {
				String alias = ecoreAliasMap.get(eObject);
				Element element = newCreateMap.get(eObject);
				pivotAliasMap.put(element, alias);
			}
		}
	}

	protected Type resolveDataType(@NonNull EDataType eClassifier) {
		Type pivotType = ecore2asMap.get(eClassifier);
		if (pivotType == null) {
			pivotType = getASType(eClassifier);
		}
		return pivotType;
	}

	/**
	 * @since 1.17
	 */
	protected void resolveDataTypeMappings() {
		ecore2asMap = new HashMap<>();
		initializeEcore2ASMap();
		assert eDataTypes != null;
		for (@NonNull EDataType eDataType : eDataTypes) {
			Type pivotType = ecore2asMap.get(eDataType);
			if (pivotType != null) {  		// If eObject is a known synonym such as EString
				addCreated(eDataType, pivotType);	// remap to the library type
			}
		}
		eDataTypes = null;
	}

	/**
	 * @since 1.17
	 */
	protected void resolveDeclarations(@NonNull Resource asResource, @NonNull Iterable<@NonNull EObject> ecoreContents) {
		Ecore2ASDeclarationSwitch declarationPass = new Ecore2ASDeclarationSwitch(this);
		PivotUtilInternal.refreshList(asResource.getContents(), Collections.singletonList(ClassUtil.nonNull(pivotModel)));
		List<org.eclipse.ocl.pivot.Package> newPackages = new ArrayList<>();
		for (EObject eObject : ecoreContents) {
			EClass eClass = eObject.eClass();
			if (eClass.getEPackage() != EcorePackage.eINSTANCE) {
				error("Non Ecore " + eClass.getName() + " for Ecore2AS.update");
			}
			else {
				Object pivotElement = declarationPass.doInPackageSwitch(eObject);
				if (pivotElement instanceof org.eclipse.ocl.pivot.Package) {
					newPackages.add((org.eclipse.ocl.pivot.Package) pivotElement);
				}
				else {
					error("Bad ecore content");
				}
			}
		}
		PivotUtilInternal.refreshList(pivotModel.getOwnedPackages(), newPackages);
	}

	/**
	 * @since 1.7
	 */
	protected Type resolveGenericType(@NonNull Map<String, Type> resolvedSpecializations, @NonNull EGenericType eGenericType) {
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		assert !eGenericType.getETypeArguments().isEmpty();
		EClassifier eClassifier = eGenericType.getEClassifier();
		List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
		assert eTypeParameters.size() == eTypeArguments.size();
		Type unspecializedPivotType = getASType(eClassifier);
		if (unspecializedPivotType == null) {
			return null;
		}
		List<@NonNull Type> templateArguments = new ArrayList<>();
		for (EGenericType eTypeArgument : eTypeArguments) {
			if (eTypeArgument != null) {
				Type typeArgument = resolveType(resolvedSpecializations, eTypeArgument);
				if (typeArgument != null) {
					templateArguments.add(typeArgument);
				}
			}
		}
		org.eclipse.ocl.pivot.Class unspecializedPivotClass = unspecializedPivotType.isClass();
		assert unspecializedPivotClass != null;			// FIXME
		return metamodelManager.getLibraryType(unspecializedPivotClass, templateArguments);
	}

	/**
	 * @since 1.17
	 */
	protected void resolveIds(@NonNull Iterable<@NonNull EObject> ecoreContents) {
		oldIdMap = new HashMap<>();
		for (@NonNull EObject ecoreContent : ecoreContents) {
			Resource resource = ecoreContent.eResource();
			if (resource instanceof XMLResource) {
				XMLResource xmlResource = (XMLResource) resource;
				String id = xmlResource.getID(ecoreContent);
				if (id != null) {
					Element element = newCreateMap.get(ecoreContent);
					if (element != null) {
						oldIdMap.put(id, element);
					}
				}
				for (TreeIterator<EObject> tit = ecoreContent.eAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					id = xmlResource.getID(eObject);
					if (id != null) {
						Element element = newCreateMap.get(eObject);
						if (element != null) {
							oldIdMap.put(id, element);
						}
					}
				}
			}
		}
	}

	/**
	 * @since 1.17
	 */
	protected void resolveReferences() {
		Ecore2ASReferenceSwitch referencePass = new Ecore2ASReferenceSwitch(this);
		Set<@NonNull EObject> theReferencers = referencers;
		while (theReferencers != null) {
			Set<@NonNull EObject> moreReferencers = null;
			for (EObject eObject : theReferencers) {
				Object asElement = referencePass.doInPackageSwitch(eObject);
				if (asElement == referencePass) {
					if (moreReferencers == null) {
						moreReferencers = new HashSet<>();
					}
					moreReferencers.add(eObject);
				}
			}
			if ((moreReferencers == null) || (moreReferencers.size() < theReferencers.size())) {		// Avoid infinite loop
				theReferencers = moreReferencers;
			}
		}
		for (EObject eObject : referencers) {
			if (eObject instanceof EReference) {
				Property pivotElement = getCreated(Property.class, eObject);
				if (pivotElement != null) {
					Property oppositeProperty = pivotElement.getOpposite();
					if ((oppositeProperty == null) && (eObject.eContainer() instanceof EClass)) {		// Skip annotation references
						metamodelManager.installPropertyDeclaration(pivotElement);
					}
				}
			}
		}
		referencers = null;
	}

	protected Type resolveSimpleType(@NonNull EClassifier eClassifier) {
		return getASType(eClassifier);
	}

	/**
	 * @since 1.17
	 */
	protected void resolveSpecializations() {
		Map<@NonNull String, @NonNull Type> resolvedSpecializations = new HashMap<>();
		assert genericTypes != null;
		for (@NonNull EGenericType eGenericType : genericTypes) {
			Type pivotType = resolveType(resolvedSpecializations, eGenericType);
			if (pivotType != null) {
				addCreated(eGenericType, pivotType);
			}
		}
		genericTypes = null;
	}

	/**
	 * Ensure that each loaded EDataType has an OclAny / OclEnumeration superclass.
	 *
	 * @since 1.17
	 */
	protected void resolveSuperDataTypes() {
		org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
		org.eclipse.ocl.pivot.Class oclEnumerationType = standardLibrary.getOclEnumerationType();
		assert eDataTypes != null;
		for (@NonNull EDataType eDataType : eDataTypes) {
			org.eclipse.ocl.pivot.Class pivotElement = (org.eclipse.ocl.pivot.Class)newCreateMap.get(eDataType);
			assert pivotElement != null;
			org.eclipse.ocl.pivot.Class behavioralClass = null;
			org.eclipse.ocl.pivot.Class superClass = null;
			if (pivotElement instanceof DataType) {
				Class<?> instanceClass = eDataType.getInstanceClass();
				if (instanceClass != null) {
					try {
						behavioralClass = standardLibrary.getBehavioralClass(instanceClass);
						if (behavioralClass != null) {
							if (PivotUtil.getName(behavioralClass).equals(pivotElement.getName())) {
								behavioralClass = null;
							}
							else {
								((DataType)pivotElement).setBehavioralClass(behavioralClass);
								superClass = behavioralClass;
							}
						}
					} catch (Exception e) {
					}
				}
			}
			if (superClass == null) {
				superClass = eDataType instanceof EEnum ? oclEnumerationType : oclAnyType;
			}
			refreshList(pivotElement.getSuperClasses(), Collections.singletonList(superClass));
		}
	}

	protected Type resolveType(@NonNull Map<String, Type> resolvedSpecializations, @NonNull EGenericType eGenericType) {
		Type pivotType = getCreated(Type.class, eGenericType);
		if (pivotType != null) {
			return pivotType;
		}
		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		if (eTypeParameter != null) {
			pivotType = resolveTypeParameter(eGenericType);
		}
		else if (eClassifier == null) {
			pivotType = resolveWildcardType(eGenericType);
		}
		else if (!eTypeArguments.isEmpty()) {
			String ecoreMoniker = Ecore2Moniker.toString(eGenericType);
			pivotType = resolvedSpecializations.get(ecoreMoniker);
			if (pivotType == null) {
				pivotType = resolveGenericType(resolvedSpecializations, eGenericType);
				resolvedSpecializations.put(ecoreMoniker, pivotType);
			}
		}
		else if (eClassifier instanceof EDataType) {
			assert eGenericType.getETypeArguments().isEmpty();
			pivotType = resolveDataType((EDataType) eClassifier);
		}
		else {
			assert eGenericType.getETypeArguments().isEmpty();
			pivotType = resolveSimpleType(eClassifier);
		}
		if (pivotType != null) {
			addCreated(eGenericType, pivotType);
		}
		return pivotType;
	}

	protected Type resolveTypeParameter(@NonNull EGenericType eGenericType) {
		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		assert eClassifier == null;
		assert eTypeArguments.isEmpty();
		Type pivotType = null;
		if (eTypeParameter != null) {
			pivotType = getCreated(Type.class, eTypeParameter);
		}
		return pivotType;
	}

	protected Type resolveWildcardType(@NonNull EGenericType eGenericType) {
		assert eGenericType.getETypeArguments().isEmpty();
		assert eGenericType.getEClassifier() == null;
		EClassifier eClassifier = eGenericType.getERawType();
		assert eClassifier == EcorePackage.Literals.EJAVA_OBJECT;
		/*			WildcardTypeRefCS csTypeRef = BaseCSFactory.eINSTANCE.createWildcardTypeRefCS();
			setOriginalMapping(csTypeRef, eObject);
//			csTypeRef.setExtends(doSwitchAll(eGenericType.getExtends()));
//			csTypeRef.setSuper(doSwitchAll(eGenericType.getSuper()));
			return csTypeRef; */
		return metamodelManager.createWildcardType(null, null);		// FIXME bounds
		/*		org.eclipse.ocl.pivot.Class pivotElement = PivotFactory.eINSTANCE.createClass();
		String name = PivotConstants.WILDCARD_NAME;
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
		return pivotElement; */
	}

	/**
	 * Define the loadableURI to be used to form the AS URI that is then used as part of the serialized XMI.
	 */
	public void setEcoreURI(URI ecoreURI) {
		this.ecoreURI = ecoreURI;
	}

	@Override
	public String toString() {
		return String.valueOf(ecoreResource.getURI());
	}

	public void update(@NonNull Resource resource, @NonNull Collection<@NonNull EObject> ecoreContents) {
		ASResource asResource = (ASResource)resource;		// FIXME change signature
		asResource.resetLUSSIDs();			// Hopefully reset already, not wanted till save. See Bug 579052.
		allConverters.clear();
		newCreateMap = new HashMap<>();
		referencers = new HashSet<>();
		genericTypes = new ArrayList<>();
		eDataTypes = new ArrayList<>();
		boolean wasUpdating = asResource.setUpdating(true);
		/*
		 * Establish the declarations.
		 */
		resolveDeclarations(asResource, ecoreContents);
		/*
		 * Register any local declarations that establish novel library content..
		 */
		initializeLibrary();
		/*
		 * Insert the OclAny/OclEnumeration superclasses after local overrides have been declared,
		 * but before Primitive synonyms are remapped.
		 */
		resolveSuperDataTypes();
		/*
		 * Add any aliases
		 */
		resolveAliases(asResource);
		metamodelManager.installResource(asResource);
		/*
		 * Remap known Ecore EDataTypes after custom pivot types have had a chance to be declared.
		 */
		resolveDataTypeMappings();
		/*
		 * Declare the specializations.
		 */
		resolveSpecializations();
		/*
		 * Resolve references.
		 */
		resolveReferences();
		resolveIds(ecoreContents);
		assert asResource.basicGetLUSSIDs() == null;			// Confirming Bug 579025
	}
}
