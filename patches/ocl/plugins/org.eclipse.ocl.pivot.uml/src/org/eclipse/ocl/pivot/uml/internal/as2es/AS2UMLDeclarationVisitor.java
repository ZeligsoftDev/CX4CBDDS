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

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.UMLFactory;

public class AS2UMLDeclarationVisitor
	extends AbstractExtendingVisitor<EModelElement, AS2UML>
{
	public AS2UMLDeclarationVisitor(@NonNull AS2UML context) {
		super(context);
	}

	protected void copyClassifier(org.eclipse.uml2.uml.@NonNull Classifier umlClassifier, org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		copyNamedElement(umlClassifier, pivotType);
		TemplateSignature pivotTemplateSignature = pivotType.getOwnedSignature();
		if (pivotTemplateSignature != null) {
			umlClassifier.setOwnedTemplateSignature((org.eclipse.uml2.uml.TemplateSignature)safeVisit(pivotTemplateSignature));
		}
		safeVisitAll(umlClassifier.getEAnnotations(), pivotType.getOwnedAnnotations());
//		if (pivotType.eIsSet(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME)) {
//			umlClassifier.setInstanceClassName(pivotType.getInstanceClassName());
//		}
//		else {
//			umlClassifier.eUnset(UMLPackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
//		}
//		visitAll(eClassifier.getETypeParameters(), pivotType.getTypeParameters());
		StringBuilder s = null;
		for (Constraint pivotConstraint : pivotType.getOwnedInvariants()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
			if (s == null) {
				s = new StringBuilder();
			}
			else {
				s.append(" ");
			}
			s.append(pivotConstraint.getName());
		}
/*		EAnnotation eAnnotation = umlClassifier.getEAnnotation(UMLPackage.eNS_URI);
		if (s != null) {
			if (eAnnotation == null) {
				eAnnotation = UMLFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(UMLPackage.eNS_URI);
				umlClassifier.getEAnnotations().add(0, eAnnotation);
			}
			eAnnotation.getDetails().put("constraints", s.toString());
		}
		else {
			umlClassifier.getEAnnotations().remove(eAnnotation);
		} */
	}

	protected void copyDataTypeOrEnum(org.eclipse.uml2.uml.@NonNull DataType umlDataType, @NonNull DataType pivotDataType) {
		copyClassifier(umlDataType, pivotDataType);
//		umlDataType.setSerializable(pivotDataType.isSerializable());
	}

	protected void copyDetails(@NonNull EAnnotation umlAnnotation, @NonNull Annotation pivotAnnotation) {
		copyEModelElement(umlAnnotation, pivotAnnotation);
		safeVisitAll(umlAnnotation.getEAnnotations(), pivotAnnotation.getOwnedAnnotations());
		for (Detail pivotDetail : pivotAnnotation.getOwnedDetails()) {
			String name = pivotDetail.getName();
			String value = StringUtil.splice(pivotDetail.getValues(), "");
			umlAnnotation.getDetails().put(name, value);
		}
	}

	protected void copyEModelElement(@NonNull EModelElement umlElement, @NonNull Element pivotModelElement) {
		context.putCreated(pivotModelElement, umlElement);
	}

	protected void copyModelElement(org.eclipse.uml2.uml.@NonNull Element umlElement, @NonNull Element pivotModelElement) {
		copyEModelElement(umlElement, pivotModelElement);
		safeVisitAll(umlElement.getOwnedComments(), pivotModelElement.getOwnedComments());
	}

	protected void copyNamedElement(org.eclipse.uml2.uml.@NonNull NamedElement umlNamedElement, @NonNull NamedElement pivotNamedElement) {
		copyModelElement(umlNamedElement, pivotNamedElement);
		umlNamedElement.setName(pivotNamedElement.getName());
		safeVisitAll(umlNamedElement.getOwnedComments(), pivotNamedElement.getOwnedComments());
	}

	protected void copyTypedElement(org.eclipse.uml2.uml.@NonNull TypedElement umlTypedElement, @NonNull TypedElement pivotTypedElement) {
		copyNamedElement(umlTypedElement, pivotTypedElement);
		context.defer(pivotTypedElement);		// Defer type/multiplicity setting
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
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
	public org.eclipse.uml2.uml.Element visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for AS2UML Declaration pass");
	}

	@Override
	public EAnnotation visitAnnotation(@NonNull Annotation pivotAnnotation) {
		@SuppressWarnings("null")
		@NonNull EAnnotation umlAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		copyDetails(umlAnnotation, pivotAnnotation);
		umlAnnotation.setSource(pivotAnnotation.getName());
		safeVisitAll(umlAnnotation.getContents(), pivotAnnotation.getOwnedContents());
		if (!pivotAnnotation.getReferences().isEmpty()) {
			context.defer(pivotAnnotation);
		}
		return umlAnnotation;
	}

	@Override
	public org.eclipse.uml2.uml.Classifier visitClass(org.eclipse.ocl.pivot.@NonNull Class pivotClass) {
		if (pivotClass.getOwnedBindings().size() > 0) {
			return null;
		}
		Classifier umlClassifier;
		if (pivotClass.isIsInterface()) {
			Interface umlInterface = UMLFactory.eINSTANCE.createInterface();
			safeVisitAll(umlInterface.getOwnedOperations(), pivotClass.getOwnedOperations());
			safeVisitAll(umlInterface.getOwnedAttributes(), pivotClass.getOwnedProperties());
			umlClassifier = umlInterface;
		}
		else {
			org.eclipse.uml2.uml.Class umlClass = UMLFactory.eINSTANCE.createClass();
			safeVisitAll(umlClass.getOwnedOperations(), pivotClass.getOwnedOperations());
			safeVisitAll(umlClass.getOwnedAttributes(), pivotClass.getOwnedProperties());
			umlClassifier = umlClass;
		}
		copyClassifier(umlClassifier, pivotClass);
		context.defer(pivotClass);		// Defer superclass resolution
		umlClassifier.setIsAbstract(pivotClass.isIsAbstract());
		return umlClassifier;
	}

 	@Override
	public EModelElement visitComment(@NonNull Comment pivotComment) {
		org.eclipse.uml2.uml.Comment umlComment = UMLFactory.eINSTANCE.createComment();
		umlComment.setBody(pivotComment.getBody());
		return umlComment;
	}

	@Override
	public org.eclipse.uml2.uml.Constraint visitConstraint(@NonNull Constraint pivotConstraint) {
		LanguageExpression specification = pivotConstraint.getOwnedSpecification();
		if (specification == null) {
			return null;
		}
		String exprString = specification.getBody();
		if (exprString == null) {
			return null;
		}
//		EModelElement eModelElement = context.getCreated(EModelElement.class, (Element)pivotConstraint.eContainer());
//		EAnnotation oclAnnotation = eModelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
//		if (oclAnnotation == null) {
//			oclAnnotation = UMLFactory.eINSTANCE.createEAnnotation();
//			oclAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
//			eModelElement.getEAnnotations().add(oclAnnotation);
//		}
//		String stereotype = pivotConstraint.getStereotype();
//		String name = pivotConstraint.getName();
/*		if (UMLReflection.INVARIANT.equals(stereotype)) {
			oclAnnotation.getDetails().put(name, exprString);
		}
		else if (UMLReflection.DERIVATION.equals(stereotype)) {
			oclAnnotation.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, exprString);
		}
		else if (UMLReflection.INITIAL.equals(stereotype)) {
			oclAnnotation.getDetails().put(SettingBehavior.INITIAL_CONSTRAINT_KEY, exprString);
		}
		else if (UMLReflection.BODY.equals(stereotype)) {
			String key = name != null ? "body_" + name : InvocationBehavior.BODY_CONSTRAINT_KEY;
			oclAnnotation.getDetails().put(key, exprString);
		}
		else if ("UMLReflection.PRECONDITION.equals(stereotype)) {
			oclAnnotation.getDetails().put("pre_" + name, exprString);
		}
		else if (UMLReflection.POSTCONDITION.equals(stereotype)) {
			oclAnnotation.getDetails().put("post_" + name, exprString);
		}
		else {
//			error("Unsupported " + pivotConstraint);
		} */
		return null;
	}

	@Override
	public org.eclipse.uml2.uml.DataType visitDataType(@NonNull DataType pivotDataType) {
		if (pivotDataType.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		org.eclipse.uml2.uml.@NonNull DataType umlDataType = UMLFactory.eINSTANCE.createDataType();
		copyDataTypeOrEnum(umlDataType, pivotDataType);
		return umlDataType;
	}

	@Override
	public org.eclipse.uml2.uml.Enumeration visitEnumeration(@NonNull Enumeration pivotEnumeration) {
		if (pivotEnumeration.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		org.eclipse.uml2.uml.@NonNull Enumeration umlEnumeration = UMLFactory.eINSTANCE.createEnumeration();
		copyDataTypeOrEnum(umlEnumeration, pivotEnumeration);
		safeVisitAll(umlEnumeration.getOwnedLiterals(), pivotEnumeration.getOwnedLiterals());
		return umlEnumeration;
	}

	@Override
	public org.eclipse.uml2.uml.EnumerationLiteral visitEnumerationLiteral(@NonNull EnumerationLiteral pivotEnumLiteral) {
		@SuppressWarnings("null")
		org.eclipse.uml2.uml.@NonNull EnumerationLiteral umlEnumLiteral = UMLFactory.eINSTANCE.createEnumerationLiteral();
		copyNamedElement(umlEnumLiteral, pivotEnumLiteral);
//		if (pivotEnumLiteral.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
//			umlEnumLiteral.setValue(pivotEnumLiteral.getValue().intValue());
//		}
//		else {
//			umlEnumLiteral.eUnset(UMLPackage.Literals.EENUM_LITERAL__VALUE);
//		}
		return umlEnumLiteral;
	}

	@Override
	public org.eclipse.uml2.uml.Operation visitOperation(@NonNull Operation pivotOperation) {
		if (pivotOperation.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		org.eclipse.uml2.uml.@NonNull Operation umlOperation = UMLFactory.eINSTANCE.createOperation();
		copyNamedElement(umlOperation, pivotOperation);
		umlOperation.setIsStatic(pivotOperation.isIsStatic());
//		safeVisitAll(umlOperation.getEAnnotations(), pivotOperation.getOwnedAnnotation());
		context.defer(pivotOperation);		// Defer type setting
		TemplateSignature pivotTemplateSignature = pivotOperation.getOwnedSignature();
		umlOperation.setOwnedTemplateSignature((org.eclipse.uml2.uml.TemplateSignature)safeVisit(pivotTemplateSignature));
//		copyTemplateSignature(pivotOperation.getETypeParameters(), pivotOperation);
		safeVisitAll(umlOperation.getOwnedParameters(), pivotOperation.getOwnedParameters());
		safeVisitAll(umlOperation.getRaisedExceptions(), pivotOperation.getRaisedExceptions());
		for (Constraint pivotConstraint : pivotOperation.getOwnedConstraints()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		return umlOperation;
	}

	@Override
	public org.eclipse.uml2.uml.Package visitPackage(@NonNull Package pivotPackage) {
		@SuppressWarnings("null")
		org.eclipse.uml2.uml.@NonNull Package umlPackage = UMLFactory.eINSTANCE.createPackage();
		copyNamedElement(umlPackage, pivotPackage);
//		safeVisitAll(ePackage.getEAnnotations(), pivotPackage.getOwnedAnnotation());
		context.defer(pivotPackage);		// Defer delegate annotation analysis
//		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_PREFIX)) {
//			umlPackage.setNsPrefix(pivotPackage.getNsPrefix());
//		}
//		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_URI)) {
//			umlPackage.setNsURI(pivotPackage.getNsURI());
//		}
		safeVisitAll(umlPackage.getNestedPackages(), pivotPackage.getOwnedPackages());
		safeVisitAll(umlPackage.getOwnedTypes(), pivotPackage.getOwnedClasses());
		return umlPackage;
	}

	@Override
	public org.eclipse.uml2.uml.Parameter visitParameter(@NonNull Parameter pivotParameter) {
		@SuppressWarnings("null")
		org.eclipse.uml2.uml.@NonNull Parameter umlParameter = UMLFactory.eINSTANCE.createParameter();
		copyTypedElement(umlParameter, pivotParameter);
		return umlParameter;
	}

	@Override
	public org.eclipse.uml2.uml.Element visitPrimitiveType(@NonNull PrimitiveType pivotPrimitiveType) {
		if (pivotPrimitiveType.getOwnedBindings().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		org.eclipse.uml2.uml.@NonNull PrimitiveType umlPrimitiveType = UMLFactory.eINSTANCE.createPrimitiveType();
		copyDataTypeOrEnum(umlPrimitiveType, pivotPrimitiveType);
		return umlPrimitiveType;
	}

	@Override
	public org.eclipse.uml2.uml.Property visitProperty(@NonNull Property pivotProperty) {
//		Type type = pivotProperty.getType();
		@SuppressWarnings("null")
		org.eclipse.uml2.uml.@NonNull Property umlProperty = UMLFactory.eINSTANCE.createProperty();
		copyTypedElement(umlProperty, pivotProperty);
//		umlProperty.setIsID(pivotProperty.isID());
		umlProperty.setIsComposite(pivotProperty.isIsComposite());
//		umlProperty.setIsResolveProxies(pivotProperty.isResolveProxies());
		umlProperty.setIsReadOnly(pivotProperty.isIsReadOnly());
		umlProperty.setIsDerived(pivotProperty.isIsDerived());
		umlProperty.setIsStatic(pivotProperty.isIsStatic());
//		umlProperty.setIsTransient(pivotProperty.isTransient());
//		umlProperty.setIsUnsettable(pivotProperty.isUnsettable());
//		umlProperty.setIsVolatile(pivotProperty.isVolatile());
		if ((pivotProperty.getOpposite() != null) || !pivotProperty.getKeys().isEmpty()) {
			context.defer(pivotProperty);
		}
//		if (pivotProperty.eIsSet(PivotPackage.Literals.PROPERTY__DEFAULT)) {
//			umlProperty.setDefaultValueLiteral(pivotProperty.getDefault());
//		}
//		else {
//			umlProperty.eUnset(UMLPackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
//		}
//FIXME		for (Constraint pivotConstraint : pivotProperty.getOwnedRule()) {
//			safeVisit(pivotConstraint);		// Results are inserted directly
//		}
		return umlProperty;
	}

	@Override
	public org.eclipse.uml2.uml.TemplateSignature visitTemplateSignature(@NonNull TemplateSignature pivotTemplateSignature) {
		org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature = UMLFactory.eINSTANCE.createRedefinableTemplateSignature();
		safeVisitAll(umlTemplateSignature.getOwnedParameters(), pivotTemplateSignature.getOwnedParameters());
//		safeVisitAll(umlTemplateSignature.getParameters(), pivotTemplateSignature.getParameter());
		return umlTemplateSignature;
	}


	@Override
	public org.eclipse.uml2.uml.ClassifierTemplateParameter visitTemplateParameter(@NonNull TemplateParameter pivotTemplateParameter) {
		org.eclipse.uml2.uml.ClassifierTemplateParameter umlTypeParameter = UMLFactory.eINSTANCE.createClassifierTemplateParameter();
		org.eclipse.uml2.uml.Class umlClass = UMLFactory.eINSTANCE.createClass();
		umlClass.setName(pivotTemplateParameter.getName());
		umlTypeParameter.setOwnedParameteredElement(umlClass);
		context.putCreated(pivotTemplateParameter, umlTypeParameter);
		if (!pivotTemplateParameter.getConstrainingClasses().isEmpty()) {
			context.defer(pivotTemplateParameter);
		}
		return umlTypeParameter;
	}
}