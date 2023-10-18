/*******************************************************************************
 * Copyright (c) 2013, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.resource;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.Technology;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.uml.UMLStandaloneSetup;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.ocl.pivot.uml.internal.utilities.UMLEcoreTechnology;
import org.eclipse.ocl.pivot.uml.internal.validation.UMLOCLEValidator;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;

public final class UMLASResourceFactory extends AbstractASResourceFactory
{
	private static @Nullable UMLASResourceFactory INSTANCE;

	public static synchronized @NonNull UMLASResourceFactory getInstance() {
		if (INSTANCE == null) {
			//			ASResourceFactoryContribution asResourceRegistry = ASResourceFactoryRegistry.INSTANCE.get(ASResource.UML_CONTENT_TYPE);
			//			if (asResourceRegistry != null) {
			//				INSTANCE = (UMLASResourceFactory) asResourceRegistry.getASResourceFactory();	// Create the registered singleton
			//			}
			//			else {
			INSTANCE = new UMLASResourceFactory();											// Create our own singleton
			//			}
			assert INSTANCE != null;
			INSTANCE.install("uml", INSTANCE.getResourceClassName());
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	public UMLASResourceFactory() {
		super(ASResource.UML_CONTENT_TYPE, null);
	}

	@Override
	public void configureResourceSets(@Nullable ResourceSet asResourceSet, @NonNull ResourceSet csResourceSet) {
		super.configureResourceSets(asResourceSet, csResourceSet);
		if (asResourceSet != null) {
			UML2AS.initializeUML(asResourceSet);
		}
		UML2AS.initializeUML(csResourceSet);
	}

	@Override
	public @NonNull Resource createResource(URI uri) {
		assert uri != null;
		ASResource asResource = new UMLASResourceImpl(uri, this);
		configureResource(asResource);
		return asResource;
	}

	@Override
	public @Nullable <T extends Element> T getASElement(@NonNull EnvironmentFactoryInternal environmentFactory,
			@NonNull Class<T> pivotClass, @NonNull EObject eObject) throws ParserException {
		Resource metamodel = eObject.eResource();
		if (metamodel == null) {
			return null;
		}
		UML2AS uml2as = UML2AS.getAdapter(metamodel, environmentFactory);
		uml2as.getASModel();
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == EcorePackage.eINSTANCE) {
			if (eObject instanceof EOperation) {
				EOperation eOperation = (EOperation)eObject;
				org.eclipse.uml2.uml.Constraint umlConstraint = getConstraintForEOperation(environmentFactory, eOperation);
				if (umlConstraint != null) {
					eObject = umlConstraint;
				}
			}
			else if (eObject instanceof EClass) {
				EClass eStereotype = (EClass)eObject;
				org.eclipse.uml2.uml.Stereotype umlStereotype = getStereotypeForEClass(environmentFactory, eStereotype);
				if (umlStereotype != null) {
					eObject = umlStereotype;
				}
			}
		}
		return uml2as.getCreated(pivotClass, eObject);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}

	protected org.eclipse.uml2.uml.Constraint getConstraintForEOperation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EOperation eOperation) {
		if (EcoreUtil.isInvariant(eOperation)) {
			EClass eContainingClass = eOperation.getEContainingClass();
			EAnnotation eAnnotation = eContainingClass.getEAnnotation(DerivedConstants.UML2_UML_PACKAGE_2_0_NS_URI); // UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI
			if (eAnnotation != null) {
				List<EObject> eReferences = eAnnotation.getReferences();
				if ((eReferences != null) && (eReferences.size() > 0)) {
					EObject eReference = eReferences.get(0);
					if (eReference instanceof org.eclipse.uml2.uml.Type) {
						String operationName = environmentFactory.getTechnology().getOriginalName(eOperation);
						org.eclipse.uml2.uml.Constraint umlConstraint = ((org.eclipse.uml2.uml.Classifier)eReference).getOwnedRule(operationName);
						if (umlConstraint != null) {
							return umlConstraint;
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable EOperation getEOperation(@NonNull ASResource asResource, @NonNull EObject eObject) {
		UMLASResourceImpl umlResource = (UMLASResourceImpl) asResource;
		if (!(eObject instanceof org.eclipse.uml2.uml.Operation)) {
			return null;
		}
		org.eclipse.uml2.uml.Operation umlOperation = (org.eclipse.uml2.uml.Operation)eObject;
		org.eclipse.uml2.uml.Class umlClass = umlOperation.getClass_();
		if (umlClass == null) {
			return null;
		}
		EClassifier eClassifier = umlResource.getEClassifier(umlClass);
		if (eClassifier == null) {
			return null;
		}
		if (!(eClassifier instanceof EClass)) {
			return null;
		}
		String operationName = umlOperation.getName();
		if (operationName == null) {
			return null;
		}
		List<org.eclipse.uml2.uml.Parameter> umlParameters = umlOperation.getOwnedParameters();
		int umlParameterCount = umlParameters.size();
		for (EOperation eOperation : ((EClass)eClassifier).getEOperations()) {
			if (operationName.equals(eOperation.getName())) {
				List<EParameter> eParameters = eOperation.getEParameters();
				int eParameterCount = eParameters.size();
				if (umlParameterCount >= eParameterCount) {
					boolean parametersMatch = true;
					int umlIndex = 0;
					int eIndex = 0;
					while ((eIndex < eParameterCount) && (umlIndex < umlParameterCount)) {
						org.eclipse.uml2.uml.Parameter umlInParameter = null;
						while (umlIndex < umlParameterCount) {
							org.eclipse.uml2.uml.Parameter umlParameter = umlParameters.get(umlIndex++);
							if (umlParameter.getDirection() == org.eclipse.uml2.uml.ParameterDirectionKind.IN_LITERAL) {
								umlInParameter = umlParameter;
								break;
							}
						}
						if (umlInParameter == null) {
							parametersMatch = false;
							break;
						}
						EParameter eParameter = eParameters.get(eIndex++);
						Type umlParameterType = umlInParameter.getType();
						EClassifier umlEParameterType = umlParameterType != null ? umlResource.getEClassifier(umlParameterType) : null;
						EClassifier eParameterType = eParameter.getEType();
						if (umlEParameterType != eParameterType) {
							parametersMatch = false;
							break;
						}
					}
					while (umlIndex < umlParameterCount) {
						org.eclipse.uml2.uml.Parameter umlParameter = umlParameters.get(umlIndex++);
						if (umlParameter.getDirection() == org.eclipse.uml2.uml.ParameterDirectionKind.IN_LITERAL) {
							parametersMatch = false;
							break;
						}
					}
					if ((eIndex == eParameterCount) && (umlIndex == umlParameterCount) && parametersMatch) {
						return eOperation;
					}
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable EReference getEReference(@NonNull ASResource asResource, @NonNull EObject eObject) {
		UMLASResourceImpl umlResource = (UMLASResourceImpl) asResource;
		if (!(eObject instanceof org.eclipse.uml2.uml.Property)) {
			return null;
		}
		org.eclipse.uml2.uml.Property umlProperty = (org.eclipse.uml2.uml.Property)eObject;
		org.eclipse.uml2.uml.Class umlClass = umlProperty.getClass_();
		if (umlClass == null) {
			return null;
		}
		EClassifier eClassifier = umlResource.getEClassifier(umlClass);
		if (eClassifier == null) {
			return null;
		}
		if (!(eClassifier instanceof EClass)) {
			return null;
		}
		String propertyName = umlProperty.getName();
		if (propertyName == null) {
			return null;
		}
		for (EReference eReference : ((EClass)eClassifier).getEReferences()) {
			if (propertyName.equals(eReference.getName())) {
				return eReference;
			}
		}
		return null;
	}

	@Override
	public @NonNull Technology getTechnology() {
		UMLStandaloneSetup.assertInitialized();
		return UMLEcoreTechnology.INSTANCE;
	}

	@Override
	public @Nullable String getMetamodelNsURI(@NonNull EPackage ePackage) {
		if (ePackage instanceof UMLPackage) {
			return XMI2UMLResource.UML_METAMODEL_NS_URI;
		}
		if (ePackage.getClass().getName().startsWith(UMLPackage.class.getPackage().getName())) {	// StandardPackage/L2Package/L3Package
			return XMI2UMLResource.UML_METAMODEL_NS_URI;
		}
		return null;
	}

	@Override
	public @Nullable URI getPackageURI(@NonNull EObject eObject) {
		if (eObject instanceof org.eclipse.uml2.uml.Package) {
			String uri = ((org.eclipse.uml2.uml.Package)eObject).getURI();
			if (uri != null) {
				return URI.createURI(uri);
			}
		}
		return null;
	}

	@Override
	public @Nullable Integer getPriority() {
		return 200;
	}

	@Override
	public @Nullable String getResourceClassName() {
		return UMLResource.class.getName();
	}

	protected org.eclipse.uml2.uml.Stereotype getStereotypeForEClass(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EClass eClass) {
		EObject eAnnotationParent = null;
		for (EObject eObject = eClass; true; eObject = eObject.eContainer()) {
			if (eObject == null) {
				return null;
			}
			if (eObject instanceof EAnnotation) {
				eAnnotationParent = eObject.eContainer();
				break;
			}
		}
		if (!(eAnnotationParent instanceof org.eclipse.uml2.uml.Profile)) {
			return null;
		}
		org.eclipse.uml2.uml.Profile umlProfile = (org.eclipse.uml2.uml.Profile)eAnnotationParent;		// FIXME could there be hierarchy ?
		org.eclipse.uml2.uml.Stereotype umlStereotype = umlProfile.getOwnedStereotype(NameUtil.getOriginalName(eClass));
		return umlStereotype;
	}

	@Override
	public @Nullable Element importFromResource(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Resource umlResource, @Nullable URI uri) throws ParserException {
		UML2AS conversion = UML2AS.getAdapter(umlResource, environmentFactory);
		conversion.setUMLURI(uri != null ? uri.trimFragment() : null);
		Model pivotModel = conversion.getASModel();
		String uriFragment = uri != null ? uri.fragment() : null;
		if (uriFragment == null) {
			return pivotModel;
		}
		else {
			EObject eObject = umlResource.getEObject(uriFragment);
			if (eObject == null) {
				return null;
			}
			return conversion.getCreated(Element.class, eObject);
		}
	}

	@Override
	public void initializeEValidatorRegistry(org.eclipse.emf.ecore.EValidator.@NonNull Registry eValidatorRegistry) {
		eValidatorRegistry.put(UMLPackage.eINSTANCE, UMLOCLEValidator.NO_NEW_LINES);
	}
}
