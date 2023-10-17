/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.as2cs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.utilities.OppositePropertyDetails;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.EnumerationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.xtext.basecs.ImplicitOppositeCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementRefCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.ReferenceCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;

public class BaseDeclarationVisitor extends AbstractExtendingVisitor<ElementCS, @NonNull AS2CSConversion>
{
	public BaseDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	/**
	 * After the visit to all elements, perform any post-processing such as installing imports.
	 */
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<@NonNull Namespace, @NonNull List<@NonNull String>> importedNamespaces) {}

	@Override
	public ElementCS visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object) {
		AnnotationCS csElement = context.refreshNamedElement(AnnotationCS.class, BaseCSPackage.Literals.ANNOTATION_CS, object, null);
		context.refreshList(csElement.getOwnedContents(), context.visitDeclarations(ModelElementCS.class, object.getOwnedContents(), null));
		context.refreshList(csElement.getOwnedDetails(), context.visitDeclarations(DetailCS.class, object.getOwnedDetails(), null));
		List<Element> references = object.getReferences();
		if (references.size() > 0) {
			List<ModelElementRefCS> csReferences = new ArrayList<ModelElementRefCS>(references.size());
			for (Element reference : references) {
				if (reference != null) {
					ModelElementRefCS csRef = BaseCSFactory.eINSTANCE.createModelElementRefCS();
					PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
					csRef.setOwnedPathName(csPathName);
					context.refreshPathName(csPathName, reference, context.getScope());
					csReferences.add(csRef);
				}
			}
			context.refreshList(csElement.getOwnedReferences(), csReferences);
		}
		else {
			csElement.getOwnedReferences().clear();
		}
		return csElement;
	}

	@Override
	public ElementCS visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		org.eclipse.ocl.pivot.Class savedScope = context.setScope(object);
		StructuredClassCS csElement = context.refreshClassifier(StructuredClassCS.class, BaseCSPackage.Literals.STRUCTURED_CLASS_CS, object);
		context.refreshList(csElement.getOwnedProperties(), context.visitDeclarations(StructuralFeatureCS.class, object.getOwnedProperties(),
			new AS2CS.Predicate<Property>()
		{
			@Override
			public boolean filter(@NonNull Property element) {
				return !element.isIsImplicit();
			}
		}));
		context.refreshList(csElement.getOwnedOperations(), context.visitDeclarations(OperationCS.class, object.getOwnedOperations(), null));
		final Type oclElementType = context.getStandardLibrary().getOclElementType();
		context.refreshList(csElement.getOwnedSuperTypes(), context.visitReferences(TypedRefCS.class, object.getSuperClasses(),
			new AS2CS.Predicate<Type>()
		{
			@Override
			public boolean filter(@NonNull Type element) {
				return element != oclElementType;
			}
		}));
		csElement.setIsAbstract(object.isIsAbstract());
		csElement.setIsInterface(object.isIsInterface());
		context.setScope(savedScope);
		return csElement;
	}

	//	@Override
	//	public ElementCS visitComment(Comment object) {
	//		ParameterCS pivotElement = context.refreshNamedElement(ParameterCS.class, BaseCSPackage.Literals.COMMENT_CS, object);
	//		return null;
	//	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSPackage.Literals.CONSTRAINT_CS, object);
		LanguageExpression specification = object.getOwnedSpecification();
		csElement.setOwnedSpecification(specification != null ? context.visitDeclaration(SpecificationCS.class, specification) : null);
		return csElement;
	}

	@Override
	public ElementCS visitDataType(@NonNull DataType object) {
		DataTypeCS csElement = context.refreshClassifier(DataTypeCS.class, BaseCSPackage.Literals.DATA_TYPE_CS, object);
		csElement.setIsSerializable(object.isIsSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitDetail(@NonNull Detail object) {
		DetailCS csElement = context.refreshNamedElement(DetailCS.class, BaseCSPackage.Literals.DETAIL_CS, object);
		List<String> values = csElement.getValues();
		values.clear();
		values.addAll(object.getValues());
		return csElement;
	}

	@Override
	public ElementCS visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object) {
		EnumerationCS csElement = context.refreshClassifier(EnumerationCS.class, BaseCSPackage.Literals.ENUMERATION_CS, object);
		context.refreshList(csElement.getOwnedLiterals(), context.visitDeclarations(EnumerationLiteralCS.class, object.getOwnedLiterals(), null));
		csElement.setIsSerializable(object.isIsSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitEnumerationLiteral(@NonNull EnumerationLiteral object) {
		EnumerationLiteralCS csElement = context.refreshNamedElement(EnumerationLiteralCS.class,
			BaseCSPackage.Literals.ENUMERATION_LITERAL_CS, object);
		if (object.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__LITERAL)) {
			csElement.setLiteral(object.getLiteral());
		}
		else {
			csElement.eUnset(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__LITERAL);
		}
		if (object.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
			csElement.setValue(object.getValue().intValue());
		}
		else {
			csElement.eUnset(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE);
		}
		return csElement;
	}

	@Override
	public ElementCS visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		SpecificationCS csElement = context.refreshElement(SpecificationCS.class, BaseCSPackage.Literals.SPECIFICATION_CS, object);
		String body = object.getBody();
		csElement.setExprString(body);
		return csElement;
	}

	@Override
	public ElementCS visitImport(@NonNull Import object) {
		Namespace importedNamespace = object.getImportedNamespace();
		if (importedNamespace != null) {
			context.importNamespace(importedNamespace, object.getName());
		}
		return null;
	}

	@Override
	public ElementCS visitModel(@NonNull Model object) {
		RootPackageCS csElement = context.refreshElement(RootPackageCS.class, BaseCSPackage.Literals.ROOT_PACKAGE_CS, object);
		context.refreshList(csElement.getOwnedPackages(), context.visitDeclarations(PackageCS.class, object.getOwnedPackages(), null));
		context.visitDeclarations(ImportCS.class, object.getOwnedImports(), null);
		return csElement;
	}

	@Override // FIXME BUG 496148 this is biased to use of e.g. {ordered} for OCLinEcore
	public ElementCS visitOperation(@NonNull Operation object) {
		OperationCS csElement = context.refreshTypedElement(OperationCS.class, BaseCSPackage.Literals.OPERATION_CS, object);
		TemplateSignature ownedTemplateSignature = object.getOwnedSignature();
		csElement.setOwnedSignature(context.visitDeclaration(TemplateSignatureCS.class, ownedTemplateSignature));
		context.refreshList(csElement.getOwnedParameters(), context.visitDeclarations(ParameterCS.class, object.getOwnedParameters(), null));
		context.refreshList(csElement.getOwnedExceptions(), context.visitReferences(TypedRefCS.class, object.getRaisedExceptions(), null));
		//
		context.refreshList(csElement.getOwnedPreconditions(), context.visitDeclarations(ConstraintCS.class, object.getOwnedPreconditions(), null));
		List<LanguageExpression> bodyExpressions = object.getBodyExpression() != null ? Collections.singletonList(object.getBodyExpression()) : Collections.<LanguageExpression>emptyList();
		context.refreshList(csElement.getOwnedBodyExpressions(), context.visitDeclarations(SpecificationCS.class, bodyExpressions, null));
		context.refreshList(csElement.getOwnedPostconditions(), context.visitDeclarations(ConstraintCS.class, object.getOwnedPostconditions(), null));
		List<@NonNull String> qualifiers = ClassUtil.nullFree(csElement.getQualifiers());
		context.refreshQualifiers(qualifiers, "transient", "!transient", object.isIsTransient() ? Boolean.TRUE : null);
		return csElement;
	}

	@Override
	public ElementCS visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		PackageCS csPackage = context.refreshNamedElement(PackageCS.class, BaseCSPackage.Literals.PACKAGE_CS, object);
		context.refreshList(csPackage.getOwnedClasses(), context.visitDeclarations(ClassCS.class, object.getOwnedClasses(), null));
		csPackage.setNsPrefix(object.getNsPrefix());
		csPackage.setNsURI(object.getURI());
		context.refreshList(csPackage.getOwnedPackages(), context.visitDeclarations(PackageCS.class, object.getOwnedPackages(), null));
		return csPackage;
	}

	@Override
	public ElementCS visitParameter(@NonNull Parameter object) { // FIXME BUG 496148 this is biased to use of e.g. {ordered} for OCLinEcore
		ParameterCS csElement = context.refreshTypedElement(ParameterCS.class, BaseCSPackage.Literals.PARAMETER_CS, object);
		return csElement;
	}

	@Override
	public @Nullable ElementCS visitPrimitiveType(@NonNull PrimitiveType object) {
		DataTypeCS csElement = context.refreshClassifier(DataTypeCS.class, BaseCSPackage.Literals.DATA_TYPE_CS, object);
		csElement.setIsPrimitive(true);
		csElement.setIsSerializable(object.isIsSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitProperty(@NonNull Property object) {
		StructuralFeatureCS csElement;
		Type type = object.getType();
		if (type instanceof CollectionType) {
			type = ((CollectionType)type).getElementType();
		}
		if (type instanceof MapType) {
			ReferenceCS csReference = context.refreshStructuralFeature(ReferenceCS.class, BaseCSPackage.Literals.REFERENCE_CS, object);
			List<@NonNull String> qualifiers = ClassUtil.nullFree(csReference.getQualifiers());
			context.refreshQualifiers(qualifiers, "composes", object.isIsComposite());
			context.refreshQualifiers(qualifiers, "resolve", "!resolve", object.isIsResolveProxies() ? null : Boolean.FALSE);
			csElement = csReference;
		}
		else if (type instanceof DataType) {
			AttributeCS csAttribute = context.refreshStructuralFeature(AttributeCS.class, BaseCSPackage.Literals.ATTRIBUTE_CS, object);
			context.refreshQualifiers(csAttribute.getQualifiers(), "id", object.isIsID());
			csElement = csAttribute;
		}
		else {
			ReferenceCS csReference = context.refreshStructuralFeature(ReferenceCS.class, BaseCSPackage.Literals.REFERENCE_CS, object);
			List<@NonNull String> qualifiers = ClassUtil.nullFree(csReference.getQualifiers());
			context.refreshQualifiers(qualifiers, "composes", object.isIsComposite());
			context.refreshQualifiers(qualifiers, "resolve", "!resolve", object.isIsResolveProxies() ? null : Boolean.FALSE);
			Property opposite = object.getOpposite();
			if (opposite == null) {
				csReference.setReferredOpposite(null);
				csReference.getOwnedImplicitOpposites().clear();
			}
			else if (!opposite.isIsImplicit()) {
				csReference.setReferredOpposite(opposite);
				csReference.getOwnedImplicitOpposites().clear();
			}
			else {
				csReference.setReferredOpposite(null);
				OppositePropertyDetails oppositePropertyDetails = OppositePropertyDetails.createFromProperty(opposite);
				if (oppositePropertyDetails != null) {
					ImplicitOppositeCS csOpposite = context.refreshTypedElement(ImplicitOppositeCS.class, BaseCSPackage.Literals.IMPLICIT_OPPOSITE_CS, opposite);
					csReference.getOwnedImplicitOpposites().add(csOpposite);
				}
			}
			context.refreshList(csReference.getReferredKeys(), object.getKeys());
			csElement = csReference;
		}
		List<LanguageExpression> defaultExpressions = object.getOwnedExpression() != null ? Collections.singletonList(object.getOwnedExpression()) : Collections.<LanguageExpression>emptyList();
		context.refreshList(csElement.getOwnedDefaultExpressions(), context.visitDeclarations(SpecificationCS.class, defaultExpressions, null));
		return csElement;
	}

	@Override
	public ElementCS visitTemplateSignature(@NonNull TemplateSignature object) {
		TemplateSignatureCS csElement = context.refreshElement(TemplateSignatureCS.class, BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS, object);
		context.refreshList(csElement.getOwnedParameters(), context.visitDeclarations(TemplateParameterCS.class, object.getOwnedParameters(), null));
		return csElement;
	}

	@Override
	public ElementCS visitTemplateParameter(@NonNull TemplateParameter object) {
		TypeParameterCS csElement = context.refreshElement(TypeParameterCS.class, BaseCSPackage.Literals.TYPE_PARAMETER_CS, object);
		csElement.setName(object.getName());
		List<org.eclipse.ocl.pivot.Class> asConstrainingClasses = object.getConstrainingClasses();
		if (asConstrainingClasses.size() > 0) {
			List<TypedRefCS> csExtends = new ArrayList<TypedRefCS>();
			for (org.eclipse.ocl.pivot.Class asConstrainingClass : asConstrainingClasses) {
				if (asConstrainingClass != null) {
					TypedRefCS typeRef = context.visitReference(TypedRefCS.class, asConstrainingClass, null);
					csExtends.add(typeRef);
				}
			}
			PivotUtilInternal.refreshList(csElement.getOwnedExtends(), csExtends);
		}
		else {
			csElement.getOwnedExtends().clear();
		}
		return csElement;
	}

	@Override
	public ElementCS visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for AS2CS Declaration pass");
	}
}
