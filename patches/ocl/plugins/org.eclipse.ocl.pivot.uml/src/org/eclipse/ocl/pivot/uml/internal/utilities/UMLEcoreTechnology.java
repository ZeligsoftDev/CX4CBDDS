/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DynamicElement;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Profile;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ExtensionProperty;
import org.eclipse.ocl.pivot.internal.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.pivot.internal.utilities.AbstractTechnology;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.uml.internal.library.InstanceSlotNavigationProperty;
import org.eclipse.ocl.pivot.uml.internal.library.UMLBaseProperty;
import org.eclipse.ocl.pivot.uml.internal.library.UMLExtensionProperty;
import org.eclipse.ocl.pivot.uml.internal.library.UMLRedefinedNavigationProperty;
import org.eclipse.ocl.pivot.uml.internal.library.UMLStereotypeProperty;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLEcoreTechnology extends AbstractTechnology
{
	public static final @NonNull UMLEcoreTechnology INSTANCE = new UMLEcoreTechnology();

	protected UMLEcoreTechnology() {}

	@Override
	public  @NonNull UMLIdResolver createIdResolver(@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new UMLIdResolver(environmentFactory);
	}

	@Override
	public @NonNull LibraryProperty createBasePropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property) {
		return new UMLBaseProperty(property);
	}

	@Override
	public @NonNull LibraryProperty createExplicitNavigationPropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory,
			@Nullable Element asNavigationExp, @Nullable Object sourceValue, @NonNull Property property) {
		if (sourceValue instanceof org.eclipse.uml2.uml.InstanceSpecification) {
			org.eclipse.ocl.pivot.Package owningPackage = PivotUtil.getContainingPackage(asNavigationExp);
			if (!(owningPackage instanceof Profile)) {	// FIXME see Bug 458326/458394
				EObject eTarget = property.getESObject();
				if  (eTarget instanceof org.eclipse.uml2.uml.Property) {
					TypeId typeId = property.getTypeId();
					CollectionTypeId collectionTypeId;
					if (typeId instanceof CollectionTypeId) {
						collectionTypeId = (CollectionTypeId)typeId;
					}
					else {
						collectionTypeId = null;
					}
					return new InstanceSlotNavigationProperty((org.eclipse.uml2.uml.Property)eTarget, collectionTypeId);
				}
			}
		}
		List<Property> redefinedProperties = property.getRedefinedProperties();
		if (redefinedProperties.size() > 0) {
			return new UMLRedefinedNavigationProperty(environmentFactory.getCompleteModel(), property);
		}
		return super.createExplicitNavigationPropertyImplementation(environmentFactory, asNavigationExp, sourceValue, property);
	}

	@Override
	public @NonNull LibraryProperty createExtensionPropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property) {
		if (property.isIsImplicit()) {
			Type type = property.getType();
			assert type instanceof Stereotype;
			EObject eTarget = type.getESObject();
			if (eTarget instanceof EClass) {							// A static profile
				return new ImplicitNonCompositionProperty(property);
			}
			if (eTarget instanceof org.eclipse.uml2.uml.Stereotype) {	// A dynamic profile
				return new UMLExtensionProperty(property);
			}
		}
		return new ExtensionProperty(property);
	}

	@Override
	public @NonNull LibraryProperty createStereotypePropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property) {
		return new UMLStereotypeProperty(property);
	}

	@Override
	public String getExtensionName(@NonNull Element asStereotypedElement) {
		String name = "????";
		if (asStereotypedElement instanceof NamedElement) {
			name = ((NamedElement)asStereotypedElement).getName();
		}
		else if (asStereotypedElement instanceof DynamicElement) {
			EObject eObject = ((DynamicElement)asStereotypedElement).getESObject();
			if (eObject instanceof org.eclipse.uml2.uml.NamedElement) {
				name = ((org.eclipse.uml2.uml.NamedElement)eObject).getName();
			}
		}
		return name;
	}

	@Override
	public RootPackageId getMetamodelId(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EPackage eObject2) {
		RootPackageId metamodel = null;
		if (ClassUtil.basicGetMetamodelAnnotation(eObject2) != null) {
			metamodel = IdManager.METAMODEL;
		}
		else if (eObject2 instanceof UMLPackage) {
			@SuppressWarnings("null")@NonNull String nsUri = UMLPackage.eNS_URI;
			environmentFactory.getMetamodelManager().getCompleteModel().addPackageURI2completeURI(nsUri, PivotConstants.UML_METAMODEL_NAME);
			metamodel = IdManager.getRootPackageId(PivotConstants.UML_METAMODEL_NAME);
		}
		else if (eObject2 instanceof TypesPackage) {
			@SuppressWarnings("null")@NonNull String nsUri = TypesPackage.eNS_URI;
			environmentFactory.getMetamodelManager().getCompleteModel().addPackageURI2completeURI(nsUri, PivotConstants.TYPES_METAMODEL_NAME);
			metamodel = IdManager.getRootPackageId(PivotConstants.TYPES_METAMODEL_NAME);
		}
		else {
			String nsURI = eObject2.getNsURI();
			String sharedNsURI = environmentFactory.getMetamodelManager().getCompleteModel().getCompleteURI(nsURI);
			if ((sharedNsURI != null) && !sharedNsURI.equals(nsURI)) {
				metamodel = IdManager.getRootPackageId(sharedNsURI);
			}
		}
		return metamodel;
	}

	@Override
	public @NonNull PackageId getMetapackageId(@NonNull EnvironmentFactoryInternal environmentFactory, org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		if (asPackage instanceof PivotObjectImpl) {
			EObject eTarget = ((PivotObjectImpl)asPackage).getESObject();
			if (eTarget != null) {
				EClass eClass = eTarget.eClass();
				if (eClass != null) {
					EPackage ePackage = eClass.getEPackage();
					if (ePackage instanceof UMLPackage) {
						return IdManager.getRootPackageId(PivotConstants.UML_METAMODEL_NAME);
					}
					else if (ePackage instanceof TypesPackage) {
						return IdManager.getRootPackageId(PivotConstants.TYPES_METAMODEL_NAME);
					}
				}
			}
		}
		return IdManager.METAMODEL;
	}

	@Override
	public @Nullable String getOriginalName(@NonNull ENamedElement eNamedElement) {
		EAnnotation eAnnotation = eNamedElement.getEAnnotation(PivotConstantsInternal.REDEFINES_ANNOTATION_SOURCE);
		if (eAnnotation != null) {
			EObject eContainer = eNamedElement.eContainer();
			if (eContainer instanceof EAnnotation) {   // duplicates ... redefines
				List<EObject> eReferences = eAnnotation.getReferences();
				if ((eReferences != null) && (eReferences.size() > 0)) {
					EObject eObject = eReferences.get(0);
					if (eObject instanceof ENamedElement) {
						String originalName = getOriginalName((ENamedElement) eObject);
						return originalName;
					}
				}
			}
			else if (eContainer instanceof EClassifier) {
				String prefix = ((EClassifier)eContainer).getName() + "_";		// FIXME Bug 405061 workaround
				String originalName = NameUtil.getOriginalName(eNamedElement);
				if ((originalName != null) && originalName.startsWith(prefix)) {
					originalName = originalName.substring(prefix.length());
				}
				return originalName;
			}
		}
		String originalName = NameUtil.getOriginalName(eNamedElement);
		return originalName;
	}

	@Override
	public @Nullable Element getParseableElement(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EObject eObject) throws ParserException {
		Element pivotElement;
		if (eObject instanceof Element) {
			return (Element) eObject;
		}
		EnvironmentFactoryInternalExtension environmentFactoryInternalExtension = (EnvironmentFactoryInternalExtension)environmentFactory;
		pivotElement = environmentFactoryInternalExtension.getASOf(Element.class, eObject);
		if ((eObject instanceof org.eclipse.uml2.uml.Constraint) && (pivotElement instanceof Constraint) && (pivotElement.eContainer() == null)) {
			pivotElement = environmentFactoryInternalExtension.getASOf(Element.class, ((org.eclipse.uml2.uml.Constraint)eObject).getSpecification());
		}
		return pivotElement;
	}

	@Override
	public boolean isStereotype(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EClass eClass) {
		for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
			EClassifier eType = eFeature.getEType();
			if (eType != null) {
				EPackage ePackage = eType.getEPackage();
				if (ePackage == UMLPackage.eINSTANCE) {					// ?? is this too narrow ?? SysML ??
					String name = eFeature.getName();
					if ((name != null) && name.startsWith(DerivedConstants.STEREOTYPE_BASE_PREFIX)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean isValidatable(@NonNull EClass eClass) {
		EPackage ePackage = eClass.getEPackage();
		if (ePackage != null) {
			EObject eContainer = ePackage.eContainer();
			if (eContainer instanceof EAnnotation) {
				EObject eContainerContainer = eContainer.eContainer();
				if (eContainerContainer instanceof Profile) {
					return false;		// Stereotype applications are validated where they applied
				}
			}
		}
		return true;
	}
}
