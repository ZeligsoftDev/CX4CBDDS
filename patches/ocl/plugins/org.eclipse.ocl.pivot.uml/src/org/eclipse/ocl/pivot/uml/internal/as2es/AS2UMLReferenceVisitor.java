/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.as2es;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.uml2.uml.MultiplicityElement;

public class AS2UMLReferenceVisitor
	extends AbstractExtendingVisitor<EObject, AS2UML>
{
	private static final Logger logger = LogManager.getLogger(AS2UMLReferenceVisitor.class);

//	protected final AS2EcoreTypeRefVisitor typeRefVisitor;
	
	public AS2UMLReferenceVisitor(@NonNull AS2UML context) {
		super(context);
//		typeRefVisitor = new AS2EcoreTypeRefVisitor(context);
	}

	public <T extends org.eclipse.uml2.uml.Element> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	@Override
	public EObject visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for AS2UML Reference pass");
	}

/*	@Override
	public EObject visitAnnotation(Annotation pivotAnnotation) {
		EAnnotation eAnnotation = context.getCreated(EAnnotation.class, pivotAnnotation);
		eAnnotation.getReferences().clear();
		for (Element pivotReference : pivotAnnotation.getReference()) {
			EObject eReference = context.getCreated(EObject.class, pivotReference);
			eAnnotation.getReferences().add(eReference);
		}
		return eAnnotation;
	} */

	@Override
	public EObject visitClass(@NonNull Class pivotClass) {
		org.eclipse.uml2.uml.Class umlClass = context.getCreated(org.eclipse.uml2.uml.Class.class, pivotClass);
		if (umlClass == null) {
			return null;
		}
		safeVisitAll(umlClass.getSuperClasses(), pivotClass.getSuperClasses());
		return umlClass;
	}

	@Override
	public EObject visitDataType(@NonNull DataType pivotDataType) {
		org.eclipse.uml2.uml.DataType umlDataType = context.getCreated(org.eclipse.uml2.uml.DataType.class, pivotDataType);
		return umlDataType;
	}

	@Override
	public EObject visitOperation(@NonNull Operation pivotOperation) {
		org.eclipse.uml2.uml.Operation umlOperation = context.getCreated(org.eclipse.uml2.uml.Operation.class, pivotOperation);
		if (umlOperation == null) {
			return null;
		}
		safeVisitAll(umlOperation.getRaisedExceptions(), pivotOperation.getRaisedExceptions());
		Type pivotType = pivotOperation.getType();
		if (pivotType == null) {
			return null;				// Occurs for Operation return type
		}
		org.eclipse.uml2.uml.Type umlType = context.getCreated(org.eclipse.uml2.uml.Type.class, pivotType);
		umlOperation.setType(umlType);
		return null;
	}

	@Override
	public EObject visitPackage(@NonNull Package pivotPackage) {
//		org.eclipse.uml2.uml.Package umlPackage = context.getCreated(org.eclipse.uml2.uml.Package.class, pivotPackage);
/*		boolean needsDelegates = false;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = eClassifier.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				needsDelegates = true;
				break;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = eFeature.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = eOperation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
			}
		}
		if (needsDelegates) {
		    EAnnotation packageAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
		    if (packageAnnotation == null) {
		    	packageAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		    	packageAnnotation.setSource(EcorePackage.eNS_URI);
		    	ePackage.getEAnnotations().add(packageAnnotation);
		    }
		    EMap<String, String> details = packageAnnotation.getDetails();
			details.put(InvocationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		    details.put(SettingBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		    details.put(ValidationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		} */
		return null;
	}

	@Override
	public EObject visitProperty(@NonNull Property pivotProperty) {
		org.eclipse.uml2.uml.Property umlProperty = context.getCreated(org.eclipse.uml2.uml.Property.class, pivotProperty);
		if (umlProperty == null) {
			return null;
		}
		Property pivotOpposite = pivotProperty.getOpposite();
		if (pivotOpposite != null) {
			org.eclipse.uml2.uml.Property umlOpposite = context.getCreated(org.eclipse.uml2.uml.Property.class, pivotOpposite);
			if (umlOpposite != null) {
				umlProperty.setOpposite(umlOpposite);
			}
		}
//		for (Property pivotKey : pivotProperty.getKeys()) {
//			EAttribute eAttribute = context.getCreated(EAttribute.class, pivotKey);
//			if (eAttribute != null) {
//				eReference.getEKeys().add(eAttribute);
//			}
//		}
		return super.visitProperty(pivotProperty);
	}

	@Override
	public EObject visitTemplateParameter(@NonNull TemplateParameter pivotTemplateParameter) {
//		org.eclipse.uml2.uml.ClassifierTemplateParameter umlTypeParameter = context.getCreated(org.eclipse.uml2.uml.ClassifierTemplateParameter.class, pivotTemplateParameter);
//		for (Type constrainingType : pivotTemplateParameter.getConstrainingType()) {
//			EGenericType eGenericType = typeRefVisitor.resolveEGenericType(constrainingType);
//			umlTypeParameter.getEBounds().add(eGenericType);
//		}
		return null;
	}

	@Override
	public EObject visitTypedElement(@NonNull TypedElement pivotTypedElement) {
		org.eclipse.uml2.uml.TypedElement umlTypedElement = context.getCreated(org.eclipse.uml2.uml.TypedElement.class, pivotTypedElement);
		if (umlTypedElement == null) {
			return null;
		}
		Type pivotType = pivotTypedElement.getType();
		if ((pivotType == null) || (pivotType instanceof VoidType)) {				// Occurs for Operation return type
			if (umlTypedElement instanceof MultiplicityElement) {
				MultiplicityElement umlMultiplicityElement = (MultiplicityElement)umlTypedElement;
				umlMultiplicityElement.setLower(1);
				umlMultiplicityElement.setUpper(1);
				umlMultiplicityElement.setIsOrdered(true);
				umlMultiplicityElement.setIsUnique(true);
			}
			umlTypedElement.setType(null);
			return null;
		}
		else if (pivotType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)pivotType;
			Type elementType = collectionType.getElementType();
			org.eclipse.uml2.uml.Type umlElementType = elementType != null ? context.getCreated(org.eclipse.uml2.uml.Type.class, elementType) : null;
			umlTypedElement.setType(umlElementType);
			if (umlTypedElement instanceof MultiplicityElement) {
				MultiplicityElement umlMultiplicityElement = (MultiplicityElement)umlTypedElement;
				umlMultiplicityElement.setIsOrdered(collectionType.isOrdered());
				umlMultiplicityElement.setIsUnique(collectionType.isUnique());
				IntegerValue lower = collectionType.getLowerValue();
				UnlimitedNaturalValue upper = collectionType.getUpperValue();
				try {
					umlMultiplicityElement.setLower(lower.intValue());
				} catch (InvalidValueException e) {
					logger.error("Out of range lower bound", e);
				}
				try {
					umlMultiplicityElement.setUpper(upper.isUnlimited() ? -1 : upper.intValue());
				} catch (InvalidValueException e) {
					logger.error("Out of range upper bound", e);
				}
			}
			return null;
		}
		else {
			if (umlTypedElement instanceof MultiplicityElement) {
				MultiplicityElement umlMultiplicityElement = (MultiplicityElement)umlTypedElement;
				if (pivotTypedElement.isIsRequired()) {
					umlMultiplicityElement.setLower(1);
					umlMultiplicityElement.setUpper(1);
				}
				else {
					umlMultiplicityElement.setLower(0);
					umlMultiplicityElement.setUpper(1);
				}
				umlMultiplicityElement.setIsUnique(true);
				umlMultiplicityElement.setIsOrdered(false);		// UML default
			}
			org.eclipse.uml2.uml.Type umlType = context.getCreated(org.eclipse.uml2.uml.Type.class, pivotType);
			umlTypedElement.setType(umlType);
			return null;
		}
	}
	
/*	@Override
	public Object caseEAnnotation(EAnnotation eAnnotation) {
		AnnotationCS csAnnotation = (AnnotationCS) deferMap.get(eAnnotation);
		for (ModelElementCSRef csReference : csAnnotation.getReferences()) {
			EObject eObject = createMap.get(csReference.getRef());
			if (eObject != null) {
				eAnnotation.getReferences().add(eObject);
			}
		}
		return null;
	} */

/*	@Override
	public Object caseEGenericType(EGenericType eGenericType) {
		TypedTypeRefCS csTypeRef = (TypedTypeRefCS) deferMap.get(eGenericType);
		TypeCS typeRef = csTypeRef.getType();
		if (typeRef != null) {
			EModelElement eType = (EModelElement) createMap.get(typeRef);
			if (eType == null) {
				eGenericType.setEClassifier((EClassifier) ((ModelElementCS)typeRef).getOriginalObject());
			}
			else if (eType instanceof EClassifier) {
				eGenericType.setEClassifier((EClassifier) eType);
			}
			else if (eType instanceof ETypeParameter) {
				eGenericType.setETypeParameter((ETypeParameter) eType);
			}
		}
		return null;
	} */

/*	@Override
	public Object caseEReference(EReference eReference) {
		OCLinEcoreReferenceCS csReference = (OCLinEcoreReferenceCS) deferMap.get(eReference);
		ReferenceCSRef csOpposite = csReference.getOpposite();
		if (csOpposite != null) {
			EReference eOpposite = (EReference) createMap.get(csOpposite.getRef());
			if (eOpposite != null) {
				eReference.setEOpposite(eOpposite);
			}
		}
		for (AttributeCSRef csKey : csReference.getKeys()) {
			EAttribute eAttribute = (EAttribute) createMap.get(csKey.getRef());
			if (eAttribute != null) {
				eReference.getEKeys().add(eAttribute);
			}
		}
		return null;
	} */

//	@Override
//	public Object caseETypeParameter(ETypeParameter eTypeParameter) {
//		TypeParameterCS csTypeParameter = (TypeParameterCS) deferMap.get(eTypeParameter);
/*			ClassifierRef classifierRef = csTypedElement.getType();
		if (classifierRef != null) {
			EClassifier eClassifier = resolveClassifierRef(classifierRef);
			if (eClassifier != null) {
				eTypedElement.setEType(eClassifier);
			}
		} */
//		return null;
//	}
	
}