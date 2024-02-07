/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.as2cs;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StateExp;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.manager.PrecedenceManager;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.BaseDeclarationVisitor;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;

import com.google.common.collect.Iterables;

public class EssentialOCLDeclarationVisitor extends BaseDeclarationVisitor
{
	public static final @NonNull TuplePartId TUPLE_MESSAGE_STATUS_0 = IdManager.getTuplePartId(0, PivotConstants.MESSAGE_PART_NAME, TypeId.STRING);
	public static final @NonNull TuplePartId TUPLE_MESSAGE_STATUS_1 = IdManager.getTuplePartId(1, PivotConstants.STATUS_PART_NAME, TypeId.BOOLEAN);
	public static final @NonNull TupleTypeId TUPLE_MESSAGE_STATUS = IdManager.getTupleTypeId("Tuple", TUPLE_MESSAGE_STATUS_0, TUPLE_MESSAGE_STATUS_1);

	public EssentialOCLDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	protected ExpCS createExpCS(OCLExpression oclExpression) {
		return context.visitDeclaration(ExpCS.class, oclExpression);
	}

	protected @NonNull InfixExpCS createInfixExpCS(ExpCS csSource, String operationName, ExpCS csArgument) {
		InfixExpCS csNew = EssentialOCLCSFactory.eINSTANCE.createInfixExpCS();
		csNew.setName(operationName);
		csNew.setOwnedRight(csArgument);
		if (csSource instanceof InfixExpCS) {		// Must add additional InfixExpCS to transitive right.
			InfixExpCS csRoot = (InfixExpCS)csSource;
			InfixExpCS csParent = csRoot;
			ExpCS csRight;
			while ((csRight = csParent.getOwnedRight()) instanceof InfixExpCS) {
				csParent = (InfixExpCS)csRight;
			}
			csParent.setOwnedRight(null);				// Bypass child stealing detector
			csNew.setOwnedLeft(csRight);
			csParent.setOwnedRight(csNew);
			return csRoot;
		}
		else {
			csNew.setOwnedLeft(csSource);
			return csNew;
		}
	}

	protected @NonNull NameExpCS createNameExpCS(/*@NonNull*/NamedElement asNamedElement) {
		NameExpCS csNameExp = EssentialOCLCSFactory.eINSTANCE.createNameExpCS();
		PathNameCS csPathName = createPathNameCS(asNamedElement);
		csNameExp.setOwnedPathName(csPathName);
		return csNameExp;
	}

	protected @NonNull NameExpCS createNameExpCS(/*@NonNull*/ NamedElement asNamedElement, @Nullable Namespace scope) {
		assert asNamedElement != null;
		NameExpCS csNameExp = EssentialOCLCSFactory.eINSTANCE.createNameExpCS();
		PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
		csNameExp.setOwnedPathName(csPathName);
		context.refreshPathName(csPathName, asNamedElement, scope);
		return csNameExp;
	}

	protected @NonNull NavigatingArgCS createNavigatingArgCS(@Nullable String prefix, /*@NonNull*/ OCLExpression csExp) {
		NavigatingArgCS csNavigatingArg = EssentialOCLCSFactory.eINSTANCE.createNavigatingArgCS();
		csNavigatingArg.setPrefix(prefix);
		csNavigatingArg.setOwnedNameExpression(createExpCS(csExp));
		return csNavigatingArg;
	}

	protected NavigatingArgCS createNavigatingArgCS(@Nullable String prefix, /*@NonNull*/ NamedElement asNamedElement, @Nullable TypedElement asTypedElement, @Nullable OCLExpression csInit) {
		NavigatingArgCS csNavigatingArg = EssentialOCLCSFactory.eINSTANCE.createNavigatingArgCS();
		csNavigatingArg.setPrefix(prefix);
		csNavigatingArg.setOwnedNameExpression(createNameExpCS(asNamedElement));
		if (asTypedElement != null) {
			csNavigatingArg.setOwnedType(createTypeRefCS(asTypedElement.getType()));
		}
		if (csInit != null) {
			csNavigatingArg.setOwnedInitExpression(createExpCS(csInit));
		}
		return csNavigatingArg;
	}

	protected @NonNull ExpCS createNavigationOperatorCS(@NonNull CallExp asCallExp, @NonNull ExpCS csArgument, boolean isConverted) {
		OCLExpression asSource = asCallExp.getOwnedSource();
		if (asSource == null) {
			return csArgument;
		}
		if (asSource instanceof VariableExp) {
			VariableDeclaration asVariable = ((VariableExp)asSource).getReferredVariable();
			if ((asVariable instanceof Variable) && ((Variable)asVariable).isIsImplicit()) { // Skip implicit iterator variables
				return csArgument;
			}
		}
		Type asType = asSource.getType();
		boolean isAggregate = PivotUtil.isAggregate(asType) ^ isConverted;
		String operationName = PivotUtil.getNavigationOperator(asCallExp.isIsSafe(), isAggregate);
		ExpCS csSource = context.visitDeclaration(ExpCS.class, asSource);
		if (asSource instanceof OperationCallExp) {
			Precedence precedence = ((OperationCallExp)asSource).getReferredOperation().getPrecedence();
			if (precedence != null) {
				NestedExpCS csNestedExp = EssentialOCLCSFactory.eINSTANCE.createNestedExpCS();
				csNestedExp.setOwnedExpression(csSource);
				csSource = csNestedExp;
			}
		}
		return createInfixExpCS(csSource, operationName, csArgument);
	}

	protected @NonNull PathNameCS createPathNameCS(NamedElement asNamedElement) {
		PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
		PathElementCS csPathElement = BaseCSFactory.eINSTANCE.createPathElementCS();
		csPathElement.setReferredElement(asNamedElement);
		csPathName.getOwnedPathElements().add(csPathElement);
		return csPathName;
	}

	protected @NonNull SquareBracketedClauseCS createSquareBracketedClauseCS(@NonNull ExpCS @NonNull ... csExps) {
		SquareBracketedClauseCS csSquareBracketedClause = EssentialOCLCSFactory.eINSTANCE.createSquareBracketedClauseCS();
		for (@NonNull ExpCS csExp : csExps) {
			csSquareBracketedClause.getOwnedTerms().add(csExp);
		}
		return csSquareBracketedClause;
	}

	protected @Nullable TypedRefCS createTypeRefCS(@Nullable Type asType) {
		return asType != null ? context.visitReference(TypedRefCS.class, asType, null) : null;
	}

	protected @Nullable TypedRefCS createTypeRefCS(Type asType, @Nullable Namespace scope) {
		return asType != null ? context.visitReference(TypedRefCS.class, asType, scope) : null;
	}

	/**
	 * Return a non-null operation from asOPeration, replacing any null value by the oclInvalidOperation.
	 */
	protected @NonNull Operation getNonNullOperation(@Nullable Operation asOperation) {
		if (asOperation == null) {
			asOperation = context.getMetamodelManager().getStandardLibrary().getOclInvalidOperation();
		}
		return asOperation;
	}

	/**
	 * Return a non-null property from asProperty, replacing any null value by the oclInvalidProperty.
	 */
	protected @NonNull Property getNonNullProperty(@Nullable Property asProperty) {
		if (asProperty == null) {
			asProperty = context.getMetamodelManager().getStandardLibrary().getOclInvalidProperty();
		}
		return asProperty;
	}

	/**
	 * Return a non-null type from asType, replacing any null value by the OclInvalidType.
	 */
	protected @NonNull Type getNonNullType(@Nullable Type asType) {
		if (asType == null) {
			asType = context.getMetamodelManager().getStandardLibrary().getOclInvalidType();
		}
		return asType;
	}

	protected boolean isLowerPrecedence(@Nullable OCLExpression asExp, @NonNull Precedence asThatPrecedence) {
		if (!(asExp instanceof OperationCallExp)) {
			return false;
		}
		Operation asOperation = ((OperationCallExp)asExp).getReferredOperation();
		if (asOperation == null) {
			return false;
		}
		Precedence asThisPrecedence = asOperation.getPrecedence();
		if (asThisPrecedence == null) {
			return false;
		}
		PrecedenceManager precedenceManager = context.getPrecedenceManager();
		return precedenceManager.getOrder(asThisPrecedence) > precedenceManager.getOrder(asThatPrecedence);
	}

	protected ElementCS refreshConstraint(@NonNull ConstraintCS csElement, @NonNull Constraint object) {
		if (object.eContainmentFeature() == PivotPackage.Literals.OPERATION__OWNED_POSTCONDITIONS) {
			csElement.setStereotype(PivotConstants.POSTCONDITION_NAME);
		}
		else if (object.eContainmentFeature() == PivotPackage.Literals.OPERATION__OWNED_PRECONDITIONS) {
			csElement.setStereotype(PivotConstants.PRECONDITION_NAME);
		}
		else {
			csElement.setStereotype(PivotConstants.INVARIANT_NAME);
		}
		ExpSpecificationCS csStatus = null;
		LanguageExpression specification = object.getOwnedSpecification();
		String body = specification.getBody();
		if (body != null) {
			if (body.startsWith("Tuple")) {
				String[] lines = body.split("\n");
				int lastLineNumber = lines.length-1;
				if ((lastLineNumber >= 3)
						&& lines[0].replaceAll("\\s", "").equals("Tuple{")
						&& lines[1].replaceAll("\\s", "").startsWith("message:String=")
						&& lines[lastLineNumber].replaceAll("\\s", "").equals("}.status")) {
					StringBuilder message = new StringBuilder();
					message.append(lines[1].substring(lines[1].indexOf("=")+1, lines[1].length()).trim());
					for (int i = 2; i < lastLineNumber; i++) {
						if (!lines[i].replaceAll("\\s", "").startsWith("status:Boolean=")) {
							message.append("\n" + lines[i]);
						}
						else {
							ExpSpecificationCS csMessage = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
							String messageString = message.toString();
							int lastIndex = messageString.lastIndexOf(',');
							if (lastIndex > 0) {
								messageString = messageString.substring(0, lastIndex);
							}
							csMessage.setExprString(messageString);
							csElement.setOwnedMessageSpecification(csMessage);
							StringBuilder status = new StringBuilder();
							status.append(lines[i].substring(lines[i].indexOf("=")+1, lines[i].length()).trim());
							for (i++; i < lastLineNumber; i++) {
								status.append("\n" + lines[i]);
							}
							csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
							csStatus.setExprString(status.toString());
						}
					}
				}
			}
			if (csStatus == null) {
				csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csStatus.setExprString(body);
			}
		}
		if ((csStatus == null) && (specification instanceof ExpressionInOCL)) {
			OCLExpression bodyExpression = ((ExpressionInOCL)specification).getOwnedBody();
			if ((bodyExpression instanceof TupleLiteralExp) && (bodyExpression.getTypeId() == TUPLE_MESSAGE_STATUS)) {
				TupleLiteralPart messagePart = NameUtil.getNameable(((TupleLiteralExp)bodyExpression).getOwnedParts(), TUPLE_MESSAGE_STATUS_0.getName());
				TupleLiteralPart statusPart = NameUtil.getNameable(((TupleLiteralExp)bodyExpression).getOwnedParts(), TUPLE_MESSAGE_STATUS_1.getName());
				OCLExpression messageExpression = messagePart != null ? messagePart.getOwnedInit() : null;
				OCLExpression statusExpression = statusPart != null ? statusPart.getOwnedInit() : null;
				ExpSpecificationCS csMessage = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csMessage.setExprString(messageExpression != null ? PrettyPrinter.print(messageExpression) : "null");
				csElement.setOwnedMessageSpecification(csMessage);
				csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csStatus.setExprString(statusExpression != null ? PrettyPrinter.print(statusExpression) : "null");
			}
			else if (bodyExpression != null) {
				csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csStatus.setExprString(PrettyPrinter.print(bodyExpression));
			}
		}
	/*	if ((csStatus == null) && (specification != null)) {
			String body = specification.getBody();
			if (body != null) {
				if (body.startsWith("Tuple")) {
					String[] lines = body.split("\n");
					int lastLineNumber = lines.length-1;
					if ((lastLineNumber >= 3)
							&& lines[0].replaceAll("\\s", "").equals("Tuple{")
							&& lines[1].replaceAll("\\s", "").startsWith("message:String=")
							&& lines[lastLineNumber].replaceAll("\\s", "").equals("}.status")) {
						StringBuilder message = new StringBuilder();
						message.append(lines[1].substring(lines[1].indexOf("=")+1, lines[1].length()).trim());
						for (int i = 2; i < lastLineNumber; i++) {
							if (!lines[i].replaceAll("\\s", "").startsWith("status:Boolean=")) {
								message.append("\n" + lines[i]);
							}
							else {
								ExpSpecificationCS csMessage = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
								String messageString = message.toString();
								int lastIndex = messageString.lastIndexOf(',');
								if (lastIndex > 0) {
									messageString = messageString.substring(0, lastIndex);
								}
								csMessage.setExprString(messageString);
								csElement.setOwnedMessageSpecification(csMessage);
								StringBuilder status = new StringBuilder();
								status.append(lines[i].substring(lines[i].indexOf("=")+1, lines[i].length()).trim());
								for (i++; i < lastLineNumber; i++) {
									status.append("\n" + lines[i]);
								}
								csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
								csStatus.setExprString(status.toString());
							}
						}
					}
				}
				if (csStatus == null) {
					csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
					csStatus.setExprString(body);
				}
			}
		} */
		//		csElement.setSpecification(context.visitDeclaration(SpecificationCS.class, specification));
		csElement.setOwnedSpecification(csStatus);
		return csElement;
	}

	// FIXME Unify VariableCS and TypedElementCS
	public <@NonNull T extends VariableCS> T refreshVariable(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull TypedElement object) {
		CollectionType standardCollectionType = context.getStandardLibrary().getCollectionType();
		T csElement = context.refreshNamedElement(csClass, csEClass, object);
		final Type type = object.getType();
		final Type elementType;
		if ((type instanceof CollectionType) && (((CollectionType)type).getUnspecializedElement() != standardCollectionType)) {
			PivotUtil.debugWellContainedness(type);
			elementType = ((CollectionType)type).getElementType();
		}
		else if (type instanceof VoidType) {
			elementType = null;
		}
		else {
			elementType = type;
		}
		if (elementType != null) {
			PivotUtil.debugWellContainedness(elementType);
			TypedRefCS typeRef = context.visitReference(TypedRefCS.class, elementType, null);
			csElement.setOwnedType(typeRef);
		}
		else {
			csElement.setOwnedType(null);
		}
		TypedRefCS csTypeRef = csElement.getOwnedType();
		if (csTypeRef != null) {
			boolean isNullFree ;
			int lower;
			int upper;
			if ((type instanceof CollectionType) && (((CollectionType)type).getUnspecializedElement() != standardCollectionType)) {
				CollectionType collectionType = (CollectionType)type;
				isNullFree = collectionType.isIsNullFree();
				lower = collectionType.getLower().intValue();
				Number upper2 = collectionType.getUpper();
				upper = upper2 instanceof Unlimited ? -1 : upper2.intValue();
				//	List<@NonNull String> qualifiers = ClassUtil.nullFree(csElement.getQualifiers());
				//	context.refreshQualifiers(qualifiers, "ordered", "!ordered", collectionType.isOrdered() ? Boolean.TRUE : null);
				//	context.refreshQualifiers(qualifiers, "unique", "!unique", collectionType.isUnique() ? null : Boolean.FALSE);
			}
			else {
				isNullFree = false;
				lower = object.isIsRequired() ? 1 : 0;
				upper = 1;
			}
			MultiplicityCS csMultiplicity = context.createMultiplicityCS(lower, upper, isNullFree);
			csTypeRef.setOwnedMultiplicity(csMultiplicity);
		}
		return csElement;
	}

	@Override
	public @Nullable ElementCS visitBooleanLiteralExp(@NonNull BooleanLiteralExp asBooleanLiteralExp) {
		BooleanLiteralExpCS csBooleanLiteralExp = EssentialOCLCSFactory.eINSTANCE.createBooleanLiteralExpCS();
		csBooleanLiteralExp.setPivot(asBooleanLiteralExp);
		csBooleanLiteralExp.setSymbol(Boolean.toString(asBooleanLiteralExp.isBooleanSymbol()));
		return csBooleanLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitCallExp(@NonNull CallExp object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable ElementCS visitCollectionItem(@NonNull CollectionItem asCollectionItem) {
		CollectionLiteralPartCS csCollectionLiteralPart = EssentialOCLCSFactory.eINSTANCE.createCollectionLiteralPartCS();
		csCollectionLiteralPart.setPivot(asCollectionItem);
		csCollectionLiteralPart.setOwnedExpression(createExpCS(asCollectionItem.getOwnedItem()));
		return csCollectionLiteralPart;
	}

	@Override
	public @Nullable ElementCS visitCollectionLiteralExp(@NonNull CollectionLiteralExp asCollectionLiteralExp) {
		CollectionLiteralExpCS csCollectionLiteralExp = EssentialOCLCSFactory.eINSTANCE.createCollectionLiteralExpCS();
		csCollectionLiteralExp.setPivot(asCollectionLiteralExp);
		csCollectionLiteralExp.setOwnedType((CollectionTypeCS) createTypeRefCS(asCollectionLiteralExp.getType()));
		List<CollectionLiteralPartCS> csOwnedParts = csCollectionLiteralExp.getOwnedParts();
		for (CollectionLiteralPart asPart : asCollectionLiteralExp.getOwnedParts()) {
			csOwnedParts.add(context.visitDeclaration(CollectionLiteralPartCS.class, asPart));
		}
		return csCollectionLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitCollectionLiteralPart(@NonNull CollectionLiteralPart asCollectionLiteralPart) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable ElementCS visitCollectionRange(@NonNull CollectionRange asCollectionRange) {
		CollectionLiteralPartCS csCollectionLiteralPart = EssentialOCLCSFactory.eINSTANCE.createCollectionLiteralPartCS();
		csCollectionLiteralPart.setPivot(asCollectionRange);
		csCollectionLiteralPart.setOwnedExpression(createExpCS(asCollectionRange.getOwnedFirst()));
		csCollectionLiteralPart.setOwnedLastExpression(createExpCS(asCollectionRange.getOwnedLast()));
		return csCollectionLiteralPart;
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSPackage.Literals.CONSTRAINT_CS, object);
		refreshConstraint(csElement, object);
		return csElement;
	}

	@Override
	public @Nullable ElementCS visitEnumLiteralExp(@NonNull EnumLiteralExp asEnumLiteralExp) {
		EnumerationLiteral asEnumLiteral = asEnumLiteralExp.getReferredLiteral();
		if (asEnumLiteral != null) {
			NameExpCS csNameExp = EssentialOCLCSFactory.eINSTANCE.createNameExpCS();
			PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csNameExp.setOwnedPathName(csPathName);
			context.refreshPathName(csPathName, asEnumLiteral, null);
			//			NameExpCS csNameExp = createNameExpCS(asEnumLiteral.getOwningEnumeration());
			//			PathElementCS csPathElement = BaseCSFactory.eINSTANCE.createPathElementCS();
			//			csPathElement.setReferredElement(asEnumLiteralExp.getReferredLiteral());
			//			csNameExp.getOwnedPathName().getOwnedPathElements().add(csPathElement);
			return csNameExp;
		}
		else {
			InvalidLiteralExpCS csInvalidLiteralExp = EssentialOCLCSFactory.eINSTANCE.createInvalidLiteralExpCS();
			csInvalidLiteralExp.setPivot(asEnumLiteralExp);
			return csInvalidLiteralExp;
		}
	}
	//	NameExpCS csNameExp = EssentialOCLCSFactory.eINSTANCE.createNameExpCS();
	//	PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
	//	csNameExp.setOwnedPathName(csPathName);
	//	Type asType = getNonNullType(asTypeExp.getReferredType());
	//	context.refreshPathName(csPathName, asType, null);

	@Override
	public ElementCS visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		String body = object.getBody();
		if (body != null) {
			ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, object);
			csElement.setExprString(body);
			return csElement;
		}
		OCLExpression bodyExpression = object.getOwnedBody();
		if (bodyExpression != null) {
			ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, object);
			body = PrettyPrinter.print(bodyExpression);
			csElement.setExprString(body);
			return csElement;
		}
		return null;
	}

	@Override
	public @Nullable ElementCS visitIfExp(@NonNull IfExp asIfExp) {
		if (!asIfExp.isIsElseIf()) {
			IfExpCS csIfExp = EssentialOCLCSFactory.eINSTANCE.createIfExpCS();
			csIfExp.setPivot(asIfExp);
			csIfExp.setOwnedCondition(createExpCS(asIfExp.getOwnedCondition()));
			csIfExp.setOwnedThenExpression(createExpCS(asIfExp.getOwnedThen()));
			OCLExpression asElse = asIfExp.getOwnedElse();
			while ((asElse instanceof IfExp) && (((IfExp)asElse).isIsElseIf())) {
				ExpCS csElse = createExpCS(asElse);
				csIfExp.getOwnedIfThenExpressions().add((IfThenExpCS) csElse);
				asElse = ((IfExp)asElse).getOwnedElse();
			}
			ExpCS csElse = createExpCS(asElse);
			csIfExp.setOwnedElseExpression(csElse);
			return csIfExp;
		}
		else {
			IfThenExpCS csIfThenExp = EssentialOCLCSFactory.eINSTANCE.createIfThenExpCS();
			csIfThenExp.setPivot(asIfExp);
			csIfThenExp.setOwnedCondition(createExpCS(asIfExp.getOwnedCondition()));
			csIfThenExp.setOwnedThenExpression(createExpCS(asIfExp.getOwnedThen()));
			return csIfThenExp;
		}
	}

	@Override
	public @Nullable ElementCS visitIntegerLiteralExp(@NonNull IntegerLiteralExp asIntegerLiteralExp) {
		NumberLiteralExpCS csNumberLiteralExp = EssentialOCLCSFactory.eINSTANCE.createNumberLiteralExpCS();
		csNumberLiteralExp.setPivot(asIntegerLiteralExp);
		csNumberLiteralExp.setSymbol(asIntegerLiteralExp.getIntegerSymbol());
		return csNumberLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitInvalidLiteralExp(@NonNull InvalidLiteralExp asInvalidLiteralExp) {
		InvalidLiteralExpCS csInvalidLiteralExp = EssentialOCLCSFactory.eINSTANCE.createInvalidLiteralExpCS();
		csInvalidLiteralExp.setPivot(asInvalidLiteralExp);
		return csInvalidLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitIterateExp(@NonNull IterateExp asIterateExp) {
		Operation asIteration = getNonNullOperation(asIterateExp.getReferredIteration());
		NameExpCS csNameExp = createNameExpCS(asIteration);
		csNameExp.setPivot(asIterateExp);
		RoundBracketedClauseCS csRoundBracketedClause = EssentialOCLCSFactory.eINSTANCE.createRoundBracketedClauseCS();
		csNameExp.setOwnedRoundBracketedClause(csRoundBracketedClause);;
		String prefix = null;
		List<Variable> asIterators = asIterateExp.getOwnedIterators();
		List<IteratorVariable> asCoIterators = asIterateExp.getOwnedCoIterators();
		for (int i = 0; i < asIterators.size(); i++) {
			Variable asIterator = asIterators.get(i);
			if (!asIterator.isIsImplicit()) {
				NavigatingArgCS csNavigatingArg = createNavigatingArgCS(prefix, asIterator, asIterator, null);
				if (i < asCoIterators.size()) {
					Variable asCoIterator = asCoIterators.get(i);
					if (!asCoIterator.isIsImplicit()) {
						VariableCS csCoIterator = refreshVariable(VariableCS.class, EssentialOCLCSPackage.Literals.VARIABLE_CS, asCoIterator);
						csNavigatingArg.setOwnedCoIterator(csCoIterator);
					}
				}
				csRoundBracketedClause.getOwnedArguments().add(csNavigatingArg);
				prefix = ",";
			}
		}
		Variable asResult = asIterateExp.getOwnedResult();
		csRoundBracketedClause.getOwnedArguments().add(createNavigatingArgCS(";", asResult, asResult, asResult.getOwnedInit()));
		csRoundBracketedClause.getOwnedArguments().add(createNavigatingArgCS("|", asIterateExp.getOwnedBody()));
		return createNavigationOperatorCS(asIterateExp, csNameExp, false);
	}

	@Override
	public @Nullable ElementCS visitIteratorExp(@NonNull IteratorExp asIteratorExp) {
		OCLExpression body = asIteratorExp.getOwnedBody();
		if (asIteratorExp.isIsImplicit() && (body instanceof CallExp)) {	// Flatten implicit collect/oclAsSet
			CallExp asCallExp = (CallExp)body;
			OCLExpression asBodySource = asCallExp.getOwnedSource();
			if (asBodySource instanceof VariableExp) {
				VariableExp sourceVariableExp = (VariableExp)asBodySource;
				if (sourceVariableExp.getReferredVariable() == asIteratorExp.getOwnedIterators().get(0)) {
					if (body instanceof NavigationCallExp) {
						NavigationCallExp asNavigationCallExp = (NavigationCallExp)body;
						NameExpCS csNameExp = createNameExpCS(PivotUtil.getReferredProperty(asNavigationCallExp));
						return createNavigationOperatorCS(asIteratorExp, csNameExp, true);
					}
					else {
						ElementCS csExp = body.accept(this);
						if (csExp instanceof ExpCS) {
							return createNavigationOperatorCS(asIteratorExp, (ExpCS) csExp, true);
						}
					}
				}
			}
		}
		Operation asIteration = getNonNullOperation(asIteratorExp.getReferredIteration());
		NameExpCS csNameExp = createNameExpCS(asIteration);
		csNameExp.setPivot(asIteratorExp);
		RoundBracketedClauseCS csRoundBracketedClause = EssentialOCLCSFactory.eINSTANCE.createRoundBracketedClauseCS();
		csNameExp.setOwnedRoundBracketedClause(csRoundBracketedClause);;
		String prefix = null;
		List<Variable> asIterators = asIteratorExp.getOwnedIterators();
		List<IteratorVariable> asCoIterators = asIteratorExp.getOwnedCoIterators();
		for (int i = 0; i < asIterators.size(); i++) {
			Variable asIterator = asIterators.get(i);
			if (!asIterator.isIsImplicit()) {
				NavigatingArgCS csNavigatingArg = createNavigatingArgCS(prefix, asIterator, asIterator, null);
				if (i < asCoIterators.size()) {
					Variable asCoIterator = asCoIterators.get(i);
					if (!asCoIterator.isIsImplicit()) {
						VariableCS csCoIterator = refreshVariable(VariableCS.class, EssentialOCLCSPackage.Literals.VARIABLE_CS, asCoIterator);
						csNavigatingArg.setOwnedCoIterator(csCoIterator);
					}
				}
				csRoundBracketedClause.getOwnedArguments().add(csNavigatingArg);
				prefix = ",";
			}
		}

		if (prefix != null) {
			prefix = "|";
		}
		csRoundBracketedClause.getOwnedArguments().add(createNavigatingArgCS(prefix, body));
		return createNavigationOperatorCS(asIteratorExp, csNameExp, false);
	}

	@Override
	public @Nullable ElementCS visitLetExp(@NonNull LetExp asLetExp) {
		LetExpCS csLetExp = EssentialOCLCSFactory.eINSTANCE.createLetExpCS();
		csLetExp.setPivot(asLetExp);
		csLetExp.setOwnedInExpression(createExpCS(asLetExp.getOwnedIn()));
		Variable asVariable = asLetExp.getOwnedVariable();
		LetVariableCS csLetVariable = EssentialOCLCSFactory.eINSTANCE.createLetVariableCS();
		csLetVariable.setPivot(asVariable);
		csLetVariable.setName(asVariable.getName());
		csLetVariable.setOwnedInitExpression(createExpCS(asVariable.getOwnedInit()));
		csLetVariable.setOwnedType(createTypeRefCS(asVariable.getType()));
		csLetExp.getOwnedVariables().add(csLetVariable);
		return csLetExp;
	}

	@Override
	public @Nullable ElementCS visitMapLiteralExp(@NonNull MapLiteralExp asMapLiteralExp) {
		MapLiteralExpCS csMapLiteralExp = EssentialOCLCSFactory.eINSTANCE.createMapLiteralExpCS();
		csMapLiteralExp.setPivot(asMapLiteralExp);
		csMapLiteralExp.setOwnedType((MapTypeCS) createTypeRefCS(asMapLiteralExp.getType()));
		List<MapLiteralPartCS> csOwnedParts = csMapLiteralExp.getOwnedParts();
		for (MapLiteralPart asPart : asMapLiteralExp.getOwnedParts()) {
			csOwnedParts.add(context.visitDeclaration(MapLiteralPartCS.class, asPart));
		}
		return csMapLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitMapLiteralPart(@NonNull MapLiteralPart asMapLiteralPart) {
		MapLiteralPartCS csMapLiteralPart = EssentialOCLCSFactory.eINSTANCE.createMapLiteralPartCS();
		csMapLiteralPart.setPivot(asMapLiteralPart);
		csMapLiteralPart.setOwnedKey(createExpCS(asMapLiteralPart.getOwnedKey()));
		csMapLiteralPart.setOwnedValue(createExpCS(asMapLiteralPart.getOwnedValue()));
		return csMapLiteralPart;
	}

	@Override
	public @Nullable ElementCS visitMessageExp(@NonNull MessageExp object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable ElementCS visitNavigationCallExp(@NonNull NavigationCallExp asNavigationCallExp) {
		Property asProperty = PivotUtil.getReferredProperty(asNavigationCallExp);
		NameExpCS csNameExp = createNameExpCS(asProperty);
		Property asOpposite = asProperty.getOpposite();
		if (asOpposite != null) {
			String name = asProperty.getName();
			Type type = asNavigationCallExp.getOwnedSource().getType();
			if (type != null) {
				CompleteClassInternal completeClass = context.getMetamodelManager().getCompleteClass(type);
				Iterable<@NonNull Property> properties = completeClass.getProperties(name);
				if ((properties != null) && Iterables.size(properties) > 1) {
					NameExpCS csOppositeNameExp = createNameExpCS(asOpposite, null);
					SquareBracketedClauseCS csSquareBracketedClause = createSquareBracketedClauseCS(csOppositeNameExp);
					csNameExp.getOwnedSquareBracketedClauses().add(csSquareBracketedClause);
				}
			}
		}
		return createNavigationOperatorCS(asNavigationCallExp, csNameExp, false);
	}

	@Override
	public @Nullable ElementCS visitNullLiteralExp(@NonNull NullLiteralExp asNullLiteralExp) {
		NullLiteralExpCS csNullLiteralExp = EssentialOCLCSFactory.eINSTANCE.createNullLiteralExpCS();
		csNullLiteralExp.setPivot(asNullLiteralExp);
		return csNullLiteralExp;
	}

	@Override
	public ElementCS visitOCLExpression(@NonNull OCLExpression object) {
		return null;
	}

	@Override
	public ElementCS visitOperationCallExp(@NonNull OperationCallExp asOperationCallExp) {
		Operation asOperation = getNonNullOperation(asOperationCallExp.getReferredOperation());
		String operationName = asOperation.getName();
		Precedence asPrecedence = asOperation.getPrecedence();
		List<OCLExpression> asArguments = asOperationCallExp.getOwnedArguments();
		OCLExpression asSource = asOperationCallExp.getOwnedSource();
		if ((asPrecedence == null) || (asSource == null)) {
			if (asOperationCallExp.isIsImplicit()) {			// oclAsSet
				return createExpCS(asSource);
			}
			NameExpCS csNameExp = createNameExpCS(asOperationCallExp.getReferredOperation());
			csNameExp.setPivot(asOperationCallExp);
			RoundBracketedClauseCS csRoundBracketedClause = EssentialOCLCSFactory.eINSTANCE.createRoundBracketedClauseCS();
			csNameExp.setOwnedRoundBracketedClause(csRoundBracketedClause);
			String prefix = null;
			for (OCLExpression asArgument : asArguments) {
				csRoundBracketedClause.getOwnedArguments().add(createNavigatingArgCS(prefix, asArgument));
				prefix = ",";
			}
			return createNavigationOperatorCS(asOperationCallExp, csNameExp, false);
		}
		else if (asArguments.size() == 1) {
			ExpCS csSource;
			if (isLowerPrecedence(asSource, asPrecedence)) {
				ExpCS csExp = createExpCS(asSource);
				NestedExpCS csNested = EssentialOCLCSFactory.eINSTANCE.createNestedExpCS();
				csNested.setOwnedExpression(csExp);
				csSource = csNested;
			}
			else {
				csSource = context.visitDeclaration(ExpCS.class, asSource);
			}
			OCLExpression asArgument = asArguments.get(0);
			ExpCS csArgument;
			if (isLowerPrecedence(asArgument, asPrecedence)) {
				ExpCS csExp = createExpCS(asArgument);
				NestedExpCS csNested = EssentialOCLCSFactory.eINSTANCE.createNestedExpCS();
				csNested.setOwnedExpression(csExp);
				csArgument = csNested;
			}
			else {
				csArgument = context.visitDeclaration(ExpCS.class, asArgument);
			}
			return createInfixExpCS(csSource, operationName, csArgument);
		}
		else {
			ExpCS csSource;
			if (isLowerPrecedence(asSource, asPrecedence)) {
				ExpCS csExp = createExpCS(asSource);
				NestedExpCS csNested = EssentialOCLCSFactory.eINSTANCE.createNestedExpCS();
				csNested.setOwnedExpression(csExp);
				csSource = csNested;
			}
			else {
				csSource = context.visitDeclaration(ExpCS.class, asSource);
			}
			PrefixExpCS csPrefix = EssentialOCLCSFactory.eINSTANCE.createPrefixExpCS();
			csPrefix.setName(operationName);
			ExpCS csResult = csPrefix;
			InfixExpCS csParent = null;
			if (csSource instanceof InfixExpCS) {
				csResult = csSource;
				csParent = (InfixExpCS) csSource;
				csSource = csParent.getOwnedLeft();
				while (csSource instanceof InfixExpCS) {
					csParent = (InfixExpCS) csSource;
					csSource = csParent.getOwnedLeft();
				}
				csParent.setOwnedLeft(csPrefix);
			}
			csPrefix.setOwnedRight(csSource);
			return csResult;
		}
	}

	@Override
	public @Nullable ElementCS visitRealLiteralExp(@NonNull RealLiteralExp asRealLiteralExp) {
		NumberLiteralExpCS csNumberLiteralExp = EssentialOCLCSFactory.eINSTANCE.createNumberLiteralExpCS();
		csNumberLiteralExp.setPivot(asRealLiteralExp);
		csNumberLiteralExp.setSymbol(asRealLiteralExp.getRealSymbol());
		return csNumberLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitShadowExp(@NonNull ShadowExp asShadowExp) {
		NameExpCS csNameExp = createNameExpCS(asShadowExp.getType(), null);
		csNameExp.setPivot(asShadowExp);
		CurlyBracketedClauseCS csCurlyBracketedClause = EssentialOCLCSFactory.eINSTANCE.createCurlyBracketedClauseCS();
		csNameExp.setOwnedCurlyBracketedClause(csCurlyBracketedClause);;
		List<ShadowPartCS> csOwnedParts = csCurlyBracketedClause.getOwnedParts();
		for (ShadowPart asPart : asShadowExp.getOwnedParts()) {
			csOwnedParts.add(context.visitDeclaration(ShadowPartCS.class, asPart));
		}
		//		csCurlyBracketedClause.setValue(asShadowExp.getValue());
		//		if ((csOwnedParts.size() == 0) && (csCurlyBracketedClause.getValue() == null)) {
		//			csCurlyBracketedClause.setValue("bad-value");
		//		}
		return csNameExp;
	}

	@Override
	public @Nullable ElementCS visitShadowPart(@NonNull ShadowPart asShadowPart) {
		ShadowPartCS csShadowPart = EssentialOCLCSFactory.eINSTANCE.createShadowPartCS();
		csShadowPart.setPivot(asShadowPart);
		csShadowPart.setOwnedInitExpression(createExpCS(asShadowPart.getOwnedInit()));
		csShadowPart.setReferredProperty(asShadowPart.getReferredProperty());
		return csShadowPart;
	}

	@Override
	public @Nullable ElementCS visitStateExp(@NonNull StateExp asStateExp) {
		return createNameExpCS(asStateExp.getReferredState());
	}

	@Override
	public @Nullable ElementCS visitStringLiteralExp(@NonNull StringLiteralExp asStringLiteralExp) {
		StringLiteralExpCS csStringLiteralExp = EssentialOCLCSFactory.eINSTANCE.createStringLiteralExpCS();
		csStringLiteralExp.setPivot(asStringLiteralExp);
		csStringLiteralExp.getSegments().add(asStringLiteralExp.getStringSymbol());
		return csStringLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitTupleLiteralExp(@NonNull TupleLiteralExp asTupleLiteralExp) {
		TupleLiteralExpCS csTupleLiteralExp = EssentialOCLCSFactory.eINSTANCE.createTupleLiteralExpCS();
		csTupleLiteralExp.setPivot(asTupleLiteralExp);
		List<TupleLiteralPartCS> csOwnedParts = csTupleLiteralExp.getOwnedParts();
		for (TupleLiteralPart asPart : asTupleLiteralExp.getOwnedParts()) {
			csOwnedParts.add(context.visitDeclaration(TupleLiteralPartCS.class, asPart));
		}
		return csTupleLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitTupleLiteralPart(@NonNull TupleLiteralPart asTupleLiteralPart) {
		TupleLiteralPartCS csTupleLiteralPart = EssentialOCLCSFactory.eINSTANCE.createTupleLiteralPartCS();
		csTupleLiteralPart.setPivot(asTupleLiteralPart);
		csTupleLiteralPart.setName(asTupleLiteralPart.getName());
		csTupleLiteralPart.setOwnedType(createTypeRefCS(asTupleLiteralPart.getType()));
		csTupleLiteralPart.setOwnedInitExpression(createExpCS(asTupleLiteralPart.getOwnedInit()));
		return csTupleLiteralPart;
	}

	@Override
	public @Nullable ElementCS visitTypeExp(@NonNull TypeExp asTypeExp) {
		Type asType = getNonNullType(asTypeExp.getReferredType());
		if (asType instanceof TemplateParameter) {			// FIXME Never happens
			NameExpCS csNameExp = EssentialOCLCSFactory.eINSTANCE.createNameExpCS();
			PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csNameExp.setOwnedPathName(csPathName);
			context.refreshPathName(csPathName, asType, null);
			return csNameExp;
		}
		TypedRefCS csTypeRef = createTypeRefCS(asType);
		if (csTypeRef instanceof TypeNameExpCS) {
			NameExpCS csNameExp = EssentialOCLCSFactory.eINSTANCE.createNameExpCS();
			csNameExp.setOwnedPathName(((TypeNameExpCS)csTypeRef).getOwnedPathName());
			return csNameExp;
		}
		else {
			TypeLiteralExpCS csTypeLiteralExp = EssentialOCLCSFactory.eINSTANCE.createTypeLiteralExpCS();
			csTypeLiteralExp.setOwnedType(csTypeRef);
			return csTypeLiteralExp;
		}
	}

	@Override
	public @Nullable ElementCS visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp asUnlimitedNaturalLiteralExp) {
		NumberLiteralExpCS csNumberLiteralExp = EssentialOCLCSFactory.eINSTANCE.createNumberLiteralExpCS();
		csNumberLiteralExp.setPivot(asUnlimitedNaturalLiteralExp);
		csNumberLiteralExp.setSymbol(asUnlimitedNaturalLiteralExp.getUnlimitedNaturalSymbol());
		return csNumberLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitVariable(@NonNull Variable object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable ElementCS visitVariableExp(@NonNull VariableExp asVariableExp) {
		VariableDeclaration asVariable = asVariableExp.getReferredVariable();
		if (asVariable != null) {
			if (PivotConstants.SELF_NAME.equals(asVariable.getName())) {
				EObject eContainer = asVariable.eContainer();
				if (eContainer instanceof ExpressionInOCL) {
					ExpressionInOCL asExpressionInOCL = (ExpressionInOCL)eContainer;
					if (asVariable == asExpressionInOCL.getOwnedContext()) {
						SelfExpCS csSelfExp = EssentialOCLCSFactory.eINSTANCE.createSelfExpCS();
						csSelfExp.setPivot(asVariableExp);
						return csSelfExp;
					}
				}
			}
			return createNameExpCS(asVariable);
		}
		else {
			InvalidLiteralExpCS csInvalidLiteralExp = EssentialOCLCSFactory.eINSTANCE.createInvalidLiteralExpCS();
			csInvalidLiteralExp.setPivot(asVariableExp);
			return csInvalidLiteralExp;
		}
	}
}
