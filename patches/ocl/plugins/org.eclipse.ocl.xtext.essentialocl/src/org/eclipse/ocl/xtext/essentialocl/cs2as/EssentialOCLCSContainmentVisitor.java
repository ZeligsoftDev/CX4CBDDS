/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigationRole;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.AbstractEssentialOCLCSContainmentVisitor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class EssentialOCLCSContainmentVisitor extends AbstractEssentialOCLCSContainmentVisitor
{
	private static final Logger logger = LogManager.getLogger(EssentialOCLCSContainmentVisitor.class);

	public EssentialOCLCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	private boolean canBeAccumulator(@NonNull NavigatingArgCS csArgument) {
		if (csArgument.getOwnedInitExpression() != null) {
			return true;
		}
		ExpCS csNameExpression = csArgument.getOwnedNameExpression();
		if (!(csNameExpression instanceof InfixExpCS)) {
			return false;
		}
		InfixExpCS csInfixExp = (InfixExpCS)csNameExpression;
		ExpCS csLeftExpression = csInfixExp.getOwnedLeft();
		if (!(csLeftExpression instanceof NameExpCS)) {
			return false;
		}
		return "=".equals(csInfixExp.getName());
	}

	private void setParameterRole(@NonNull NavigatingArgCS csArgument, @NonNull NavigationRole aRole) {
		csArgument.setRole(aRole);
		/*		if ((csArgument.getOwnedType() == null) && (csArgument.getInit() == null)) {
			ExpCS csExp = csArgument.getName();
			if (csExp instanceof InfixExpCS) {
				InfixExpCS csInfixExp = (InfixExpCS)csExp;
				// If init without type is ever legal; Fixup a = b
			}
		} */
		ExpCS csName = csArgument.getOwnedNameExpression();
		if ((aRole == NavigationRole.ACCUMULATOR) && (csName instanceof InfixExpCS)) {
			InfixExpCS csInfixExp = (InfixExpCS)csName;
			ExpCS csLeftExpression = csInfixExp.getOwnedLeft();
			if ( "=".equals(csInfixExp.getName()) && (csLeftExpression instanceof NameExpCS)) {
				csName = csLeftExpression;
			}
		}
		if (csName instanceof NameExpCS) {
			PathNameCS csPathName = ((NameExpCS)csName).getOwnedPathName();
			Variable parameter;
			if (aRole == NavigationRole.ITERATOR) {
				parameter = context.refreshModelElement(Variable.class, PivotPackage.Literals.ITERATOR_VARIABLE, csName);
			}
			else if (aRole == NavigationRole.ACCUMULATOR) {
				parameter = context.refreshModelElement(Variable.class, PivotPackage.Literals.RESULT_VARIABLE, csName);
			}
			else {
				parameter = context.refreshModelElement(Variable.class, PivotPackage.Literals.VARIABLE, csName);
			}
			ICompositeNode node = NodeModelUtils.getNode(csName);
			if (node != null) {
				String varName = ElementUtil.getTextName(csName);
				assert varName != null;
				helper.refreshName(parameter, varName);
				List<PathElementCS> path = csPathName.getOwnedPathElements();
				PathElementCS csPathElement = path.get(path.size()-1);
				csPathElement.setReferredElement(parameter);	// Resolve the reference that is actually a definition
				csPathElement.setElementType(null);		// Indicate a definition to the syntax colouring
			}
		}
	}

	@Override
	public Continuation<?> visitBooleanLiteralExpCS(@NonNull BooleanLiteralExpCS csElement) {
		@NonNull BooleanLiteralExp pivotElement = context.refreshModelElement(BooleanLiteralExp.class, PivotPackage.Literals.BOOLEAN_LITERAL_EXP, csElement);
		pivotElement.setBooleanSymbol(Boolean.valueOf(csElement.getSymbol()));
		return null;
	}

	@Override
	public Continuation<?> visitCollectionLiteralExpCS(@NonNull CollectionLiteralExpCS csElement) {
		@NonNull CollectionLiteralExp pivotElement = context.refreshModelElement(CollectionLiteralExp.class, PivotPackage.Literals.COLLECTION_LITERAL_EXP, csElement);
		context.refreshPivotList(CollectionLiteralPart.class, pivotElement.getOwnedParts(), csElement.getOwnedParts());
		return null;
	}

	@Override
	public Continuation<?> visitCollectionLiteralPartCS(@NonNull CollectionLiteralPartCS csElement) {
		if (csElement.getOwnedLastExpression() == null) {
			context.refreshModelElement(CollectionItem.class, PivotPackage.Literals.COLLECTION_ITEM, csElement);
		}
		else {
			context.refreshModelElement(CollectionRange.class, PivotPackage.Literals.COLLECTION_RANGE, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csElement) {
		@NonNull Constraint asConstraint = refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csElement);
		ExpSpecificationCS csStatusSpecification = (ExpSpecificationCS)csElement.getOwnedSpecification();
		ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS)csElement.getOwnedMessageSpecification();
		if (csMessageSpecification == null) {
			ExpressionInOCL asSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csStatusSpecification);
			if (asSpecification == null) {
				asSpecification = PivotFactory.eINSTANCE.createExpressionInOCL();
			}
			asConstraint.setOwnedSpecification(asSpecification);
		}
		else {
			Map<@NonNull String, @NonNull Type> tupleParts = new HashMap<>();
			tupleParts.put(PivotConstants.MESSAGE_PART_NAME, standardLibrary.getStringType());
			tupleParts.put(PivotConstants.STATUS_PART_NAME, standardLibrary.getBooleanType());
			TupleType tupleType = metamodelManager.getCompleteModel().getTupleManager().getTupleType("Tuple", tupleParts);
			Property statusProperty = NameUtil.getNameable(tupleType.getOwnedProperties(), PivotConstants.STATUS_PART_NAME);
			LanguageExpression asSpecification = asConstraint.getOwnedSpecification();
			//
			ExpressionInOCL asExpressionInOCL;
			if (asSpecification instanceof ExpressionInOCL) {
				asExpressionInOCL = (ExpressionInOCL) asSpecification;
			}
			else {
				asExpressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
				asConstraint.setOwnedSpecification(asExpressionInOCL);
			}
			OCLExpression asExpression = asExpressionInOCL.getOwnedBody();
			//
			PropertyCallExp asTuplePartExp;
			if (asExpression instanceof PropertyCallExp) {
				asTuplePartExp = (PropertyCallExp) asExpression;
			}
			else {
				asTuplePartExp = PivotFactory.eINSTANCE.createPropertyCallExp();
				asExpressionInOCL.setOwnedBody(asTuplePartExp);
				helper.setType(asExpressionInOCL, asTuplePartExp.getType(), asTuplePartExp.isIsRequired());
			}
			asTuplePartExp.setReferredProperty(statusProperty);
			if (statusProperty != null) {
				asTuplePartExp.setType(statusProperty.getType());
			}
			asTuplePartExp.setIsRequired(true);
			asExpression = asTuplePartExp.getOwnedSource();
			//
			TupleLiteralExp asTupleLiteralExp;
			if (asExpression instanceof TupleLiteralExp) {
				asTupleLiteralExp = (TupleLiteralExp) asExpression;
			}
			else {
				asTupleLiteralExp = PivotFactory.eINSTANCE.createTupleLiteralExp();
				asTuplePartExp.setOwnedSource(asTupleLiteralExp);
			}
			asTupleLiteralExp.setType(tupleType);
			asTupleLiteralExp.setIsRequired(true);
			List<TupleLiteralPart> parts = new ArrayList<TupleLiteralPart>();
			TupleLiteralPart asStatusPart = PivotUtil.getPivot(TupleLiteralPart.class, csStatusSpecification);
			TupleLiteralPart asMessagePart = PivotUtil.getPivot(TupleLiteralPart.class, csMessageSpecification);
			if ((asMessagePart != null) && (asStatusPart != null)) {
				parts.add(asMessagePart);
				parts.add(asStatusPart);
			}
			helper.refreshList(asTupleLiteralExp.getOwnedParts(), parts);
		}
		return null;
	}

	@Override
	public Continuation<?> visitContextCS(@NonNull ContextCS csElement) {
		@NonNull ExpressionInOCL pivotElement = context.refreshModelElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, csElement);
		PivotUtil.setBody(pivotElement, null, ElementUtil.getRawText(csElement));
		ParserContext parserContext = ElementUtil.basicGetParserContext(csElement);
		if (parserContext != null) {
			parserContext.initialize(context, pivotElement);
		}
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitContextLessElementCS(@NonNull ContextLessElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitExpCS(@NonNull ExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitExpSpecificationCS(@NonNull ExpSpecificationCS csElement) {
		EObject eContainer = csElement.eContainer();
		if (eContainer instanceof ConstraintCS) {
			ConstraintCS csConstraint = (ConstraintCS) eContainer;
			SpecificationCS csStatusSpecification = csConstraint.getOwnedSpecification();
			SpecificationCS csMessageSpecification = csConstraint.getOwnedMessageSpecification();
			if ((csStatusSpecification != null) && (csMessageSpecification != null)) {
				@NonNull TupleLiteralPart csTupleLiteralPart = context.refreshModelElement(TupleLiteralPart.class, PivotPackage.Literals.TUPLE_LITERAL_PART, csElement);
				EStructuralFeature eContainingFeature = csElement.eContainingFeature();
				if (eContainingFeature == BaseCSPackage.Literals.CONSTRAINT_CS__OWNED_SPECIFICATION) {
					csTupleLiteralPart.setName(PivotConstants.STATUS_PART_NAME);
					csTupleLiteralPart.setType(standardLibrary.getBooleanType());
				}
				else if (eContainingFeature == BaseCSPackage.Literals.CONSTRAINT_CS__OWNED_MESSAGE_SPECIFICATION) {
					csTupleLiteralPart.setName(PivotConstants.MESSAGE_PART_NAME);
					csTupleLiteralPart.setType(standardLibrary.getStringType());
				}
				else {
					logger.error("unknown ExpSpecificationCS.eContainingFeature" + eContainingFeature);
				}
				return null;
			}
		}
		context.refreshModelElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitIfExpCS(@NonNull IfExpCS csElement) {
		IfExp asIfExp = context.refreshModelElement(IfExp.class, PivotPackage.Literals.IF_EXP, csElement);
		asIfExp.setIsElseIf(false);
		return null;
	}

	@Override
	public Continuation<?> visitIfThenExpCS(@NonNull IfThenExpCS csElement) {
		IfExp asIfExp = context.refreshModelElement(IfExp.class, PivotPackage.Literals.IF_EXP, csElement);
		asIfExp.setIsElseIf(true);
		return null;
	}

	@Override
	public Continuation<?> visitInfixExpCS(@NonNull InfixExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitInvalidLiteralExpCS(@NonNull InvalidLiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitLetVariableCS(@NonNull LetVariableCS csElement) {
		refreshNamedElement(LetVariable.class, PivotPackage.Literals.LET_VARIABLE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitLiteralExpCS(@NonNull LiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMapLiteralExpCS(@NonNull MapLiteralExpCS csElement) {
		@NonNull MapLiteralExp pivotElement = context.refreshModelElement(MapLiteralExp.class, PivotPackage.Literals.MAP_LITERAL_EXP, csElement);
		context.refreshPivotList(MapLiteralPart.class, pivotElement.getOwnedParts(), csElement.getOwnedParts());
		return null;
	}

	@Override
	public Continuation<?> visitMapLiteralPartCS(@NonNull MapLiteralPartCS csElement) {
		context.refreshModelElement(MapLiteralPart.class, PivotPackage.Literals.MAP_LITERAL_PART, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMapTypeCS(@NonNull MapTypeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNameExpCS(@NonNull NameExpCS csElement) {
		//		PathNameCS pathName = csElement.getPathName();
		//		assert pathName != null;
		//		CS2AS.setElementType(pathName, PivotPackage.Literals.ELEMENT, csElement, NotOperationNotPackageFilter.INSTANCE);
		return null;
	}

	@Override
	public Continuation<?> visitNavigatingArgCS(@NonNull NavigatingArgCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNestedExpCS(@NonNull NestedExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNullLiteralExpCS(@NonNull NullLiteralExpCS csElement) {
		context.refreshModelElement(NullLiteralExp.class, PivotPackage.Literals.NULL_LITERAL_EXP, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitNumberLiteralExpCS(@NonNull NumberLiteralExpCS csElement) {
		Number number = csElement.getSymbol();
		if ((number instanceof BigDecimal) || (number instanceof Double) || (number instanceof Float)) {
			@NonNull RealLiteralExp pivotElement = context.refreshModelElement(RealLiteralExp.class, PivotPackage.Literals.REAL_LITERAL_EXP, csElement);
			pivotElement.setRealSymbol(number);
		}
		else {
			boolean isNegative;
			if (number instanceof BigInteger) {
				BigInteger bigInteger = (BigInteger) number;
				isNegative = bigInteger.signum() < 0;
				if (isNegative) {
					if (bigInteger.compareTo(ValueUtil.INTEGER_MIN_VALUE) >= 0) {
						number = Integer.valueOf(bigInteger.intValue());
					}
					else if (bigInteger.compareTo(ValueUtil.LONG_MIN_VALUE) >= 0) {
						number = Long.valueOf(bigInteger.longValue());
					}
				}
				else {
					if (bigInteger.compareTo(ValueUtil.INTEGER_MAX_VALUE) <= 0) {
						number = Integer.valueOf(bigInteger.intValue());
					}
					else if (bigInteger.compareTo(ValueUtil.LONG_MAX_VALUE) <= 0) {
						number = Long.valueOf(bigInteger.longValue());
					}
				}
			}
			else {
				long longValue = number.longValue();
				isNegative = longValue < 0;
				if (isNegative) {
					if (longValue >= Integer.MIN_VALUE) {
						number = Integer.valueOf((int)longValue);
					}
					else {
						number = Long.valueOf(longValue);
					}
				}
				else {
					if (longValue <= Integer.MAX_VALUE) {
						number = Integer.valueOf((int)longValue);
					}
					else {
						number = Long.valueOf(longValue);
					}
				}
			}
			@NonNull IntegerLiteralExp pivotElement = context.refreshModelElement(IntegerLiteralExp.class, PivotPackage.Literals.INTEGER_LITERAL_EXP, csElement);
			pivotElement.setIntegerSymbol(number);
		}
		return null;
	}

	@Override
	public Continuation<?> visitPrefixExpCS(@NonNull PrefixExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveLiteralExpCS(@NonNull PrimitiveLiteralExpCS csElement) {
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitRoundBracketedClauseCS(@NonNull RoundBracketedClauseCS csElement) {
		List<NavigatingArgCS> csArguments = csElement.getOwnedArguments();
		if (csArguments.size() > 0) {
			// Last argument is always an expression
			//	then preceding initialized terms are accumulators
			//	 then preceding terms are iterators
			NavigationRole role = NavigationRole.EXPRESSION;
			for (int i = csArguments.size()-1; i >= 0; i--) {
				@SuppressWarnings("null")@NonNull NavigatingArgCS csArgument = csArguments.get(i);
				switch (role) {
					case EXPRESSION: {
						csArgument.setRole(NavigationRole.EXPRESSION);
						if ("|".equals(csArgument.getPrefix())) {
							role = NavigationRole.ACCUMULATOR;
						}
						break;
					}
					case ACCUMULATOR: {
						if (canBeAccumulator(csArgument)) {
							setParameterRole(csArgument, NavigationRole.ACCUMULATOR);
							if (";".equals(csArgument.getPrefix())) {
								role = NavigationRole.ITERATOR;
							}
						}
						else {
							role = NavigationRole.ITERATOR;
							setParameterRole(csArgument, NavigationRole.ITERATOR);
						}
						break;
					}
					case ITERATOR: {
						if (";".equals(csArgument.getPrefix())) {
							setParameterRole(csArgument, NavigationRole.ACCUMULATOR);
						}
						else {
							setParameterRole(csArgument, NavigationRole.ITERATOR);
						}
						break;
					}
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitSelfExpCS(@NonNull SelfExpCS csElement) {
		context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitShadowPartCS(@NonNull ShadowPartCS csElement) {
		context.refreshModelElement(ShadowPart.class, PivotPackage.Literals.SHADOW_PART, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitStringLiteralExpCS(@NonNull StringLiteralExpCS csElement) {
		@NonNull StringLiteralExp pivotElement = context.refreshModelElement(StringLiteralExp.class, PivotPackage.Literals.STRING_LITERAL_EXP, csElement);
		List<String> segments = csElement.getSegments();
		if (segments.size() == 0) {
			pivotElement.setStringSymbol("");
		}
		else if (segments.size() == 1) {
			pivotElement.setStringSymbol(segments.get(0));
		}
		else {
			StringBuilder s = new StringBuilder();
			for (String segment : segments) {
				s.append(segment);
			}
			pivotElement.setStringSymbol(s.toString());
		}
		return null;
	}

	@Override
	public Continuation<?> visitTupleLiteralExpCS(@NonNull TupleLiteralExpCS csElement) {
		@NonNull TupleLiteralExp pivotElement = context.refreshModelElement(TupleLiteralExp.class, PivotPackage.Literals.TUPLE_LITERAL_EXP, csElement);
		context.refreshPivotList(TupleLiteralPart.class, pivotElement.getOwnedParts(), csElement.getOwnedParts());
		return null;
	}

	@Override
	public Continuation<?> visitTupleLiteralPartCS(@NonNull TupleLiteralPartCS csElement) {
		refreshNamedElement(TupleLiteralPart.class, PivotPackage.Literals.TUPLE_LITERAL_PART, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitTypeLiteralExpCS(@NonNull TypeLiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		assert pathName != null;
		CS2AS.setElementType(pathName, PivotPackage.Literals.TYPE, csElement, null);
		return null;
	}

	@Override
	public Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull UnlimitedNaturalLiteralExpCS csElement) {
		@NonNull UnlimitedNaturalLiteralExp pivotElement = context.refreshModelElement(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csElement);
		pivotElement.setName("*");
		pivotElement.setUnlimitedNaturalSymbol(Unlimited.INSTANCE);
		return null;
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csElement) {
		refreshNamedElement(IteratorVariable.class, PivotPackage.Literals.ITERATOR_VARIABLE, csElement);
		return null;
	}
}
