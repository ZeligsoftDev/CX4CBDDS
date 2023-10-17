/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.prettyprint;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.IterableType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.PrecedenceManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.pivot.values.Value;

/**
 * The PrettyPrintExprVisitor supports pretty printing of OCL expressions.
 * PrettyPrintOptions may be used to configure the printing.
 */
public class EssentialOCLPrettyPrintVisitor extends PrettyPrintVisitor
{
	public EssentialOCLPrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	protected void appendSourceNavigation(@NonNull CallExp object) {
		OCLExpression source = object.getOwnedSource();
		if (source != null) {
			if (!(source instanceof VariableExp) || !((VariableExp)source).isIsImplicit()) {
				if ((source instanceof OperationCallExp)
						&& (((OperationCallExp)source).getReferredOperation() != null)
						&& (((OperationCallExp)source).getReferredOperation().getPrecedence() != null)) {
					context.append("(");
					context.precedenceVisit(source, null);
					context.append(")");
				}
				else {
					safeVisit(source);
				}
				if (source.getType() instanceof IterableType) {
					context.append(PivotUtil.getNavigationOperator(object.isIsSafe(), !object.isIsImplicit()));				// "." for implicit collect
				}
				else {
					if (!object.isIsImplicit()) {
						context.append(PivotUtil.getNavigationOperator(object.isIsSafe(), false));
					}
				}
			}
		}
	}

	@Override
	public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp object) {
		context.append(Boolean.toString(object.isBooleanSymbol()));
		return null;
	}

	@Override
	public Object visitCollectionItem(@NonNull CollectionItem object) {
		safeVisit(object.getOwnedItem());
		return null;
	}

	@Override
	public Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp object) {
		Type collectionType = object.getType();
		context.appendName(collectionType, context.getReservedNames());
		List<CollectionLiteralPart> parts = object.getOwnedParts();
		if (parts.isEmpty()) {
			if (collectionType instanceof CollectionType) {
				Type elementType = ((CollectionType)collectionType).getElementType();
				if (!(elementType instanceof VoidType)) {
					context.append("(");
					context.appendElement(elementType);
					context.append(")");
				}
			}
			context.append("{}");
		}
		else {
			context.push("{", "");
			String prefix = ""; //$NON-NLS-1$
			for (CollectionLiteralPart part : parts) {
				context.append(prefix);
				safeVisit(part);
				prefix = ", ";
			}
			context.exdent("", "}", "");
			context.pop();
		}
		return null;
	}

	@Override
	public Object visitCollectionRange(@NonNull CollectionRange object) {
		safeVisit(object.getOwnedFirst());
		context.next("", "..", "");
		safeVisit(object.getOwnedLast());
		return null;
	}

	@Override
	public Object visitConstraint(@NonNull Constraint object) {
		String stereotype = PivotUtilInternal.getStereotype(object);
		if (PivotConstants.BODY_NAME.equals(stereotype)) {
			context.append("body");
		}
		else if (PivotConstants.DERIVATION_NAME.equals(stereotype)) {
			context.append("der");
		}
		else if (PivotConstants.INITIAL_NAME.equals(stereotype)) {
			context.append("init");
		}
		else if (PivotConstants.INVARIANT_NAME.equals(stereotype)) {
			context.append("inv");
		}
		else if (PivotConstants.POSTCONDITION_NAME.equals(stereotype)) {
			context.append("post");
		}
		else if (PivotConstants.PRECONDITION_NAME.equals(stereotype)) {
			context.append("pre");
		}
		else {
			context.append(stereotype);
		}
		if (object.getName() != null) {
			context.append(" ");
			context.appendName(object);
		}
		context.push(":", " ");
		safeVisit(object.getOwnedSpecification());
		context.pop();
		return null;
	}

	@Override
	public Object visitEnumLiteralExp(@NonNull EnumLiteralExp object) {
		safeVisit(object.getReferredLiteral());
		return null;
	}

	@Override
	public Object visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		OCLExpression bodyExpression = object.getOwnedBody();
		if (bodyExpression != null) {
			safeVisit(bodyExpression);
		}
		else {
			String body = object.getBody();
			if (body != null) {
				context.append(body);
			}
			else {
				context.append("null -- not specified");
			}
		}
		return null;
	}

	@Override
	public Object visitIfExp(@NonNull IfExp object) {
		boolean isElseIf = object.isIsElseIf();
		if (!isElseIf) {
			context.push("if", " ");
		}
		else {
			context.exdent(" ", "elseif", " ");
		}
		safeVisit(object.getOwnedCondition());
		context.exdent(" ", "then", " ");
		safeVisit(object.getOwnedThen());
		OCLExpression ownedElse = object.getOwnedElse();
		if (!(ownedElse instanceof IfExp) || !((IfExp)ownedElse).isIsElseIf()) {
			context.exdent(" ", "else", " ");
		}
		safeVisit(ownedElse);
		if (!isElseIf) {
			context.exdent(" ", "endif", "");
			context.pop();
		}
		return null;
	}

	@Override
	public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp object) {
		context.append(object.getIntegerSymbol());
		return null;
	}

	@Override
	public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp object) {
		context.append("invalid");
		return null;
	}

	@Override
	public Object visitIterateExp(@NonNull IterateExp object) {
		Iteration referredIteration = object.getReferredIteration();
		OCLExpression body = object.getOwnedBody();
		Variable result = object.getOwnedResult();
		if (context.showNames()) {
			List<Variable> iterators = object.getOwnedIterators();
			List<IteratorVariable> coIterators = object.getOwnedCoIterators();
			int iteratorsSize = iterators.size();
			int coIteratorsSize = coIterators.size();
			appendSourceNavigation(object);
			context.appendName(referredIteration);
			context.push("(", "");
			String prefix = null;
			if (iterators.size() > 0) {
				boolean hasExplicitIterator = false;
				for (int i = 0; i < iteratorsSize; i++) {
					Variable iterator = iterators.get(i);
					Variable coIterator = i < coIteratorsSize ? coIterators.get(i) : null;
					if (!iterator.isIsImplicit()) {
						if (prefix != null) {
							context.next(null, prefix, " ");
						}
						//						safeVisit(iterator);
						context.appendName(iterator);
						if (coIterator != null) {
							context.append(" with ");
							context.appendName(coIterator);
						}
						prefix = ",";
						hasExplicitIterator = true;
					}
				}
				if (hasExplicitIterator) {
					prefix = ";";
				}
				if (prefix != null) {
					context.next(null, prefix, " ");
				}
				safeVisit(result);
				context.next(null, " |", " ");
			}
			safeVisit(body);
			context.next("", ")", "");
			context.pop();
		}
		else {
			OCLExpression source = object.getOwnedSource();
			if (source != null) {
				Type sourceType = source.getType();
				if (sourceType != null) {
					context.appendQualifiedType(sourceType);
					context.append("::");
				}
			}
			context.appendName(referredIteration);
			context.push("(", "");
			String prefix = null;
			List<@NonNull Variable> iterators = PivotUtilInternal.getOwnedIteratorsList(object);
			List<IteratorVariable> coIterators = object.getOwnedCoIterators();
			int iteratorsSize = iterators.size();
			int coIteratorsSize = coIterators.size();
			for (int i = 0; i < iteratorsSize; i++) {
				Variable iterator = iterators.get(i);
				Variable coIterator = i < coIteratorsSize ? coIterators.get(i) : null;
				if (prefix != null) {
					context.next(null, prefix, " ");
				}
				context.appendName(iterator);
				context.append(" : ");
				context.appendTypedMultiplicity(iterator);
				if (coIterator != null) {
					context.append(" with ");
					context.appendName(coIterator);
				}
				prefix = ",";
			}
			context.next(null, ";", " ");
			context.appendName(result);
			context.append(" : ");
			if (result != null) {
				context.appendTypedMultiplicity(result);
			}
			context.next(null, " |", " ");
			if (body != null) {
				context.appendTypedMultiplicity(body);
			}
			context.next("", ")", "");
			context.pop();
			context.append(" : ");
			context.appendTypedMultiplicity(object);
		}
		return null;
	}

	@Override
	public Object visitIteratorExp(@NonNull IteratorExp object) {
		Iteration referredIteration = object.getReferredIteration();
		OCLExpression body = object.getOwnedBody();
		if (context.showNames()) {
			List<Variable> iterators = object.getOwnedIterators();
			List<IteratorVariable> coIterators = object.getOwnedCoIterators();
			int iteratorsSize = iterators.size();
			int coIteratorsSize = coIterators.size();
			appendSourceNavigation(object);
			if (object.isIsImplicit()) {
				assert referredIteration.getName().equals("collect");
				assert iterators.size() == 1;
				safeVisit(body);
			}
			else {
				context.appendName(referredIteration);
				context.push("(", "");
				if (iterators.size() > 0) {
					String prefix = null;
					boolean hasExplicitIterator = false;
					for (int i = 0; i < iteratorsSize; i++) {
						Variable iterator = iterators.get(i);
						Variable coIterator = i < coIteratorsSize ? coIterators.get(i) : null;
						if (!iterator.isIsImplicit()) {
							if (prefix != null) {
								context.next(null, prefix, " ");
							}
							//							safeVisit(iterator);
							context.appendName(iterator);
							if (coIterator != null) {
								context.append(" with ");
								context.appendName(coIterator);
							}
							prefix = ",";
							hasExplicitIterator = true;
						}
					}
					if (hasExplicitIterator) {
						context.next(null, " |", " ");
					}
					else if (prefix != null) {
						context.next(null, prefix, " ");
					}
				}
				safeVisit(body);
				context.next("", ")", "");
				context.pop();
			}
		}
		else {
			OCLExpression source = object.getOwnedSource();
			if (source != null) {
				Type sourceType = source.getType();
				if (sourceType != null) {
					context.appendQualifiedType(sourceType);
					context.append("::");
				}
			}
			context.appendName(referredIteration);
			context.push("(", "");
			String prefix = null;
			for (Variable iterator : PivotUtil.getOwnedIterators(object)) {
				if (prefix != null) {
					context.next(null, prefix, " ");
				}
				context.appendName(iterator);
				context.append(" : ");
				context.appendTypedMultiplicity(iterator);
				prefix = ",";
			}
			context.next(null, " |", " ");
			if (body != null) {
				context.appendTypedMultiplicity(body);
			}
			context.next("", ")", "");
			context.pop();
			context.append(" : ");
			context.appendTypedMultiplicity(object);
		}
		return null;
	}

	@Override
	public Object visitLetExp(@NonNull LetExp object) {
		context.push("let", " ");
		safeVisit(object.getOwnedVariable());
		context.exdent(" ", "in", " ");
		safeVisit(object.getOwnedIn());
		context.pop();
		return null;
	}

	@Override
	public Object visitMapLiteralExp(@NonNull MapLiteralExp object) {
		context.appendName(object.getType(), context.getReservedNames());
		List<MapLiteralPart> parts = object.getOwnedParts();
		if (parts.isEmpty()) {
			context.append("{}");
		}
		else {
			context.push("{", "");
			String prefix = ""; //$NON-NLS-1$
			for (MapLiteralPart part : parts) {
				context.append(prefix);
				safeVisit(part);
				prefix = ", ";
			}
			context.exdent("", "}", "");
			context.pop();
		}
		return null;
	}

	@Override
	public Object visitMapLiteralPart(@NonNull MapLiteralPart object) {
		safeVisit(object.getOwnedKey());
		context.next("", " with ", "");
		safeVisit(object.getOwnedValue());
		return null;
	}

	@Override
	public Object visitNullLiteralExp(@NonNull NullLiteralExp object) {
		context.append("null");
		return null;
	}

	@Override
	public Object visitOCLExpression(@NonNull OCLExpression object) {
		context.append("<");
		context.append(object.eClass().getName());
		context.append(">");
		return null;
	}

	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp object) {
		OCLExpression source = object.getOwnedSource();
		List<@NonNull OCLExpression> arguments = PivotUtilInternal.getOwnedArgumentsList(object);
		Operation referredOperation = object.getReferredOperation();
		if (context.showNames()) {
			Precedence precedence = referredOperation != null ? referredOperation.getPrecedence() : null;
			if (precedence == null) {
				appendSourceNavigation(object);
				if (!object.isIsImplicit()) {
					context.appendName(referredOperation);
					context.push("(", "");
					String prefix = null;
					for (OCLExpression argument : arguments) {
						if (prefix != null) {
							context.next(null, prefix, " ");
						}
						context.precedenceVisit(argument, null);
						prefix = ",";
					}
					context.next("", ")", "");
					context.pop();
				}
			}
			else {
				Precedence currentPrecedence = context.getCurrentPrecedence();
				boolean lowerPrecedence = currentPrecedence != null;
				if (currentPrecedence != null) {
					PrecedenceManager precedenceManager = context.getPrecedenceManager();
					if (precedenceManager != null) {
						int precedenceOrder = precedenceManager.getOrder(precedence);
						int currentPrecedenceOrder = precedenceManager.getOrder(currentPrecedence);
						lowerPrecedence = precedenceOrder > currentPrecedenceOrder;
					}
				}
				if (lowerPrecedence) {
					context.push("(", null);
				}
				if (arguments.size() == 0) {			// Prefix
					context.appendName(referredOperation, null);
					if ((referredOperation != null) && PivotUtilInternal.isValidIdentifier(referredOperation.getName())) {
						context.append(" ");			// No space for unary minus
					}
					context.precedenceVisit(source, precedence);
				}
				else {			// Infix
					context.precedenceVisit(source, precedence);
					String name = context.getName(referredOperation, null);
					assert name != null;
					context.next(" ", name, " ");
					context.precedenceVisit(arguments.get(0), precedence);
				}
				if (lowerPrecedence) {
					context.exdent("", ")", "");
					context.pop();
				}
			}
		}
		else {
			if (source != null) {
				Type sourceType = source.getType();
				if (sourceType != null) {
					context.appendQualifiedType(sourceType);
					context.append("::");
				}
			}
			context.appendName(referredOperation);
			context.push("(", "");
			String prefix = null;
			for (OCLExpression argument : arguments) {
				if (prefix != null) {
					context.next(null, prefix, " ");
				}
				context.appendTypedMultiplicity(argument);
				prefix = ",";
			}
			context.next("", ")", "");
			context.pop();
			context.append(" : ");
			context.appendTypedMultiplicity(object);
		}
		return null;
	}

	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		Property referredOppositeProperty = object.getReferredProperty();
		Property referredProperty = referredOppositeProperty != null ? referredOppositeProperty.getOpposite() : null;
		if (context.showNames()) {
			appendSourceNavigation(object);
			context.appendName(referredProperty);
		}
		else {
			OCLExpression source = object.getOwnedSource();
			if (source != null) {
				Type sourceType = source.getType();
				if (sourceType != null) {
					context.appendQualifiedType(sourceType);
					context.append("::");
				}
			}
			context.appendName(referredProperty);
			context.append(" : ");
			context.appendTypedMultiplicity(object);
		}
		return null;
	}

	@Override
	public Object visitParameter(@NonNull Parameter object) {
		context.appendName(object);
		Type type = object.getType();
		if (type != null) {
			context.append(" : ");
			context.appendQualifiedType(type);
			context.appendTypeMultiplicity(object);
		}
		return null;
	}

	@Override
	public Object visitPropertyCallExp(@NonNull PropertyCallExp object) {
		Property referredProperty = object.getReferredProperty();
		if (context.showNames()) {
			appendSourceNavigation(object);
			context.appendName(referredProperty);
		}
		else {
			OCLExpression source = object.getOwnedSource();
			if (source != null) {
				Type sourceType = source.getType();
				if (sourceType != null) {
					context.appendQualifiedType(sourceType);
					context.append("::");
				}
			}
			context.appendName(referredProperty);
			context.append(" : ");
			context.appendTypedMultiplicity(object);
		}
		return null;
	}

	@Override
	public Object visitRealLiteralExp(@NonNull RealLiteralExp object) {
		context.append(object.getRealSymbol());
		return null;
	}

	@Override
	public Value visitShadowExp(@NonNull ShadowExp object) {
		Type type = object.getType();
		if (type != null) {
			context.appendQualifiedType(type);
		}
		context.push("{", "");
		String prefix = ""; //$NON-NLS-1$
		for (ShadowPart part : object.getOwnedParts()) {
			context.append(prefix);
			safeVisit(part);
			prefix = ", ";
		}
		context.exdent("", "}", "");
		context.pop();
		return null;
	}

	@Override
	public String visitShadowPart(@NonNull ShadowPart part) {
		context.appendName(part.getReferredProperty());
		OCLExpression initExpression = part.getOwnedInit();
		if (initExpression != null) {
			context.append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	@Override
	public Object visitStringLiteralExp(@NonNull StringLiteralExp object) {
		context.append("'");
		context.append(StringUtil.convertToOCLString(object.getStringSymbol()));
		context.append("'");
		return null;
	}

	@Override
	public Object visitTupleLiteralExp(@NonNull TupleLiteralExp object) {
		context.append(TypeId.TUPLE_NAME);
		context.push("{", "");
		String prefix = ""; //$NON-NLS-1$
		for (TupleLiteralPart part : object.getOwnedParts()) {
			context.append(prefix);
			safeVisit(part);
			prefix = ", ";
		}
		context.exdent("", "}", "");
		context.pop();
		return null;
	}

	@Override
	public Object visitTupleLiteralPart(@NonNull TupleLiteralPart object) {
		context.appendName(object);
		context.append(" = ");
		safeVisit(object.getOwnedInit());
		return null;
	}

	@Override
	public Object visitTypeExp(@NonNull TypeExp object) {
		Type type = object.getReferredType();
		if (type != null) {
			context.appendQualifiedType(type);
		}
		return null;
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp object) {
		Number symbol = object.getUnlimitedNaturalSymbol();
		if (symbol == Unlimited.INSTANCE){
			context.append("*");
		}
		else {
			context.append(symbol.toString());
		}
		return null;
	}

	@Override
	public Object visitVariable(@NonNull Variable object) {
		context.appendName(object);
		Type type = object.getType();
		if (type != null) {
			context.append(" : ");
			context.appendQualifiedType(type);
			context.appendTypeMultiplicity(object);
		}
		OCLExpression initExpression = object.getOwnedInit();
		if (initExpression != null) {
			context.append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	@Override
	public Object visitVariableExp(@NonNull VariableExp object) {
		VariableDeclaration referredVariable = object.getReferredVariable();
		if ((referredVariable != null) && PivotConstants.SELF_NAME.equals(referredVariable.getName())) {
			context.appendName(referredVariable, null);
		}
		else {
			context.appendName(referredVariable);
		}
		return null;
	}
}
