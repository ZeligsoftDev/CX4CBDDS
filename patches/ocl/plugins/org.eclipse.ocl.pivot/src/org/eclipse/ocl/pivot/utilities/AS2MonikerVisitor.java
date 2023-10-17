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
package org.eclipse.ocl.pivot.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.FinalState;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Pseudostate;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Transition;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.values.Unlimited;

public class AS2MonikerVisitor extends AbstractExtendingVisitor<Object, AS2Moniker> implements PivotConstantsInternal
{
	private static boolean initialized = false;

	@Deprecated			// The TPS policy pursued here is suspect
	private static @Nullable Map<TemplateParameter, Type> getAllTemplateParameterSubstitutions(@Nullable Map<TemplateParameter, Type> map,
			@Nullable TemplateableElement templateableElement) {
		for (EObject eObject = templateableElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				for (TemplateBinding templateBinding : ((TemplateableElement) eObject).getOwnedBindings()) {
					for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
						if (map == null) {
							map = new HashMap<TemplateParameter, Type>();
						}
						map.put(templateParameterSubstitution.getFormal(), templateParameterSubstitution.getActual());
					}
				}
			}
			if (eObject instanceof org.eclipse.ocl.pivot.Class) {
				for (org.eclipse.ocl.pivot.Class superType : ((org.eclipse.ocl.pivot.Class)eObject).getSuperClasses()) {
					map = getAllTemplateParameterSubstitutions(map, superType);
				}
			}
		}
		return map;
	}

	public static void initialize() {
		if (!initialized) {
			initialized = true;
			roleNames.put(PivotPackage.Literals.LOOP_EXP__OWNED_BODY, "argument");
			//			roleNames.put(PivotPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION, "ownedExpression");

			/*		roleNames.put(PivotPackage.Literals.CALL_EXP__SOURCE, "s");
			roleNames.put(PivotPackage.Literals.CONSTRAINT__SPECIFICATION, "z");
			roleNames.put(PivotPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION, "x");
			roleNames.put(PivotPackage.Literals.IF_EXP__CONDITION, "q");
			roleNames.put(PivotPackage.Literals.IF_EXP__THEN_EXPRESSION, "t");
			roleNames.put(PivotPackage.Literals.IF_EXP__ELSE_EXPRESSION, "f");
			roleNames.put(PivotPackage.Literals.LET_EXP__IN, "i");
			roleNames.put(PivotPackage.Literals.LET_EXP__VARIABLE, "v");
			roleNames.put(PivotPackage.Literals.LOOP_EXP__BODY, "b");
			roleNames.put(PivotPackage.Literals.LOOP_EXP__ITERATOR, "i");
			roleNames.put(PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT, "a");
			roleNames.put(PivotPackage.Literals.VARIABLE__INIT_EXPRESSION, "i");
			 */	}
	}

	protected final @Nullable Map<TemplateParameter, Type> templateBindings;

	public AS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
		templateBindings = null;
		if (!initialized) {
			initialize();
		}
	}

	public AS2MonikerVisitor(@NonNull AS2Moniker context, @Nullable Map<TemplateParameter, Type> templateBindings) {
		super(context);
		this.templateBindings = templateBindings;
	}

	public void appendExpPrefix(@NonNull NamedElement object) {
		EObject parent = object.eContainer();
		if (parent instanceof CallExp) {
			CallExp callExpParent = (CallExp)parent;
			if (callExpParent.isIsImplicit()) {
				if (callExpParent instanceof IteratorExp) {		// Bypass implicit collect
					if (callExpParent.getOwnedSource() == object) {
						context.appendElement(((IteratorExp)callExpParent).getOwnedBody());
						context.append(MONIKER_SCOPE_SEPARATOR);
						context.appendRole(object);
						context.append(MONIKER_OPERATOR_SEPARATOR);
						return;
					}
					else {
						context.appendParent(callExpParent, MONIKER_SCOPE_SEPARATOR);
						context.appendRole(callExpParent);
						context.append(MONIKER_OPERATOR_SEPARATOR);
						return;
					}
				}
				else if (callExpParent.getOwnedSource() == object) {
					object = callExpParent;
				}
			}
		}
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.appendRole(object);
		context.append(MONIKER_OPERATOR_SEPARATOR);
	}

	@Override
	public String toString() {
		return context.toString();
	}

	@Override
	public Object visitAnnotation(@NonNull Annotation object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.append(ANNOTATION_QUOTE);
		context.append(String.valueOf(object.getName()));
		context.append(ANNOTATION_QUOTE);
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			for (Object element : (List<?>)container) {
				if (element == object) {
					break;
				}
				if ((element instanceof Annotation) && (((Annotation)element).getName().equals(object.getName()))) {
					index++;
				}
			}
			if (index > 0) {
				context.append(index);
			}
		}
		return true;
	}

	@Override
	public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp object) {
		appendExpPrefix(object);
		context.append(Boolean.toString(object.isBooleanSymbol()));
		return true;
	}

	@Override
	public Object visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		if (!object.getOwnedBindings().isEmpty()) {
			Type templateableClass = PivotUtil.getUnspecializedTemplateableElement(object);
			context.appendParent(templateableClass, MONIKER_SCOPE_SEPARATOR);
			context.appendName(templateableClass);
			context.appendTemplateBindings(object, templateBindings);
		}
		else if (object.eContainer() instanceof TemplateParameterSubstitution) {
			TemplateParameter formal = ((TemplateParameterSubstitution)object.eContainer()).getFormal();
			int index = formal.getOwningSignature().getOwnedParameters().indexOf(formal);
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.append(WILDCARD_INDICATOR + index);
		}
		else {
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.appendName(object);
			context.appendTemplateParameters(object);
		}
		return true;
	}

	@Override
	public Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp object) {
		appendExpPrefix(object);
		context.appendName(object.getType());
		return true;
	}

	@Override
	public Object visitCollectionLiteralPart(@NonNull CollectionLiteralPart object) {
		context.appendParent(object, MONIKER_PART_SEPARATOR);
		context.appendIndex(object);
		return true;
	}

	@Override
	public Object visitCollectionType(@NonNull CollectionType object) {
		super.visitCollectionType(object);
		Number lower = object.getLower();
		Number upper = object.getUpper();
		if ((lower.longValue() != 0) || !(upper instanceof Unlimited)) {
			context.append("_" + lower);
			if (!(upper instanceof Unlimited)) {
				context.append("_" + upper);
			}
		}
		if (!object.isIsNullFree()) {
			context.append(COLLECTION_ELEMENT_SEPARATOR);
			context.append("1");
		}
		return true;
	}

	@Override
	public Object visitConstraint(@NonNull Constraint object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.append(PivotUtilInternal.getStereotype(object));
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			String name2 = object.getName();
			for (Object content : (List<?>)container) {
				if (content == object) {
					break;
				}
				if (content instanceof Constraint) {
					Constraint sibling = (Constraint) content;
					if (PivotUtilInternal.getStereotype(sibling).equals(PivotUtilInternal.getStereotype(object))) {
						String name1 = sibling.getName();
						if (name1 != name2) {
							if ((name1 == null) || !name1.equals(name2)) {
								break;
							}
						}
						index++;
					}
				}
			}
			context.append(MONIKER_OPERATOR_SEPARATOR);
			if (name2 != null) {
				context.append(name2);
			}
			if (index != 0) {
				context.append(MONIKER_OPERATOR_SEPARATOR);
				context.append(index);
			}
		}
		return true;
	}

	@Override
	public Object visitDetail(@NonNull Detail object) {
		context.appendParent(object, BINDINGS_PREFIX);
		context.append(object.getName());
		return true;
	}

	@Override
	public Object visitEnumLiteralExp(@NonNull EnumLiteralExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredLiteral());
		return true;
	}

	@Override
	public Object visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		if (object.eContainer() != null) {
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.appendRole(object);
		}
		else {
			context.append(MONIKER_ROOT_EXP);
		}
		return true;
	}

	@Override
	public Object visitFinalState(@NonNull FinalState object) {
		context.appendParent(object, MONIKER_PART_SEPARATOR);
		context.append("FS");
		context.append(MONIKER_SCOPE_SEPARATOR);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitIfExp(@NonNull IfExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_IF_EXP);
		return true;
	}

	@Override
	public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp object) {
		appendExpPrefix(object);
		context.append(object.getIntegerSymbol().toString());
		return true;
	}

	@Override
	public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_INVALID_LITERAL_EXP);
		return true;
	}

	@Override
	public Object visitLambdaType(@NonNull LambdaType object) {
		context.append(object.getName());
		//		context.appendTemplateParameters(object);
		Map<TemplateParameter, Type> bindings = getAllTemplateParameterSubstitutions(null, object);
		context.appendLambdaType(object.getContextType(), object.getParameterType(), object.getResultType(), bindings);
		return true;
	}

	@Override
	public Object visitLetExp(@NonNull LetExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_LET_EXP);
		return true;
	}

	@Override
	public Object visitLoopExp(@NonNull LoopExp object) {
		appendExpPrefix(object);
		if (object.isIsImplicit()) {
			OCLExpression body = object.getOwnedBody();
			if (body instanceof CallExp) {
				Feature referredFeature = PivotUtil.getReferredFeature((CallExp) body);
				context.appendName(referredFeature);
				return true;
			}
		}
		context.appendName(object.getReferredIteration());
		return true;
	}

	@Override
	public Object visitMapLiteralExp(@NonNull MapLiteralExp object) {
		appendExpPrefix(object);
		context.appendName(object.getType());
		return true;
	}

	@Override
	public Object visitMapLiteralPart(@NonNull MapLiteralPart object) {
		context.appendParent(object, MONIKER_PART_SEPARATOR);
		context.appendIndex(object);
		return true;
	}

	@Override
	public Object visitMapType(@NonNull MapType object) {
		super.visitMapType(object);
		context.append(COLLECTION_ELEMENT_SEPARATOR);
		if (object.isKeysAreNullFree()) {
			context.append("1");
		}
		context.append(COLLECTION_ELEMENT_SEPARATOR);
		if (object.isValuesAreNullFree()) {
			context.append("1");
		}
		return true;
	}

	@Override
	public Object visitModel(@NonNull Model object) {
		context.append(MONIKER_ROOT);
		return true;
	}

	@Override
	public Object visitNamedElement(@NonNull NamedElement object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitNullLiteralExp(@NonNull NullLiteralExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_NULL_LITERAL_EXP);
		return true;
	}

	@Override
	public Object visitOperation(@NonNull Operation object) {
		if (!object.getOwnedBindings().isEmpty()) {
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.appendName(object);
			Map<TemplateParameter, Type> bindings = getAllTemplateParameterSubstitutions(null, object);
			if (templateBindings != null) {
				if (bindings == null) {
					bindings = templateBindings;
				}
				else {
					// FIXME merge templateBindings
				}
			}
			context.appendTemplateBindings(object, bindings);
			context.appendParameters(object, bindings);
			return true;
		}
		else {
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.appendName(object);
			context.appendTemplateParameters(object);
			context.appendParameters(object, null);
		}
		return true;
	}

	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredOperation());
		return true;
	}

	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		appendExpPrefix(object);
		context.append("~");
		context.appendName(object.getReferredProperty());
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Object visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		//		if (!object.hasMoniker()) {
		//			throw new IllegalStateException("No moniker has been configured for " + object);
		//		}
		context.append(PivotUtilInternal.getNsURI(object));
		return true;
	}

	@Override
	public Object visitPrecedence(@NonNull Precedence object) {
		context.appendParent(object, PRECEDENCE_PREFIX);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitPrimitiveType(@NonNull PrimitiveType object) {
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitProfileApplication(@NonNull ProfileApplication object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.appendElement(object.getAppliedProfile());
		return true;
	}

	@Override
	public Object visitPropertyCallExp(@NonNull PropertyCallExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredProperty());
		return true;
	}

	@Override
	public Object visitPseudostate(@NonNull Pseudostate object) {
		context.appendParent(object, MONIKER_PART_SEPARATOR);
		context.append("PS");
		context.append(MONIKER_SCOPE_SEPARATOR);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitRealLiteralExp(@NonNull RealLiteralExp object) {
		appendExpPrefix(object);
		context.append(object.getRealSymbol().toString());
		return true;
	}

	@Override
	public String visitShadowExp(@NonNull ShadowExp shadowExp) {
		appendExpPrefix(shadowExp);
		context.append(MONIKER_TUPLE_LITERAL_EXP);
		//		appendQualifiedName(constructorExp.getReferredType());
		//		append("{");//$NON-NLS-1$
		//		String prefix = "";
		//		for (TupleLiteralPart part : constructorExp.getPart()) {
		//			append(prefix);
		//           safeVisit(part);
		//			prefix = ", ";//$NON-NLS-1$
		//		}
		//		append("}");
		return null;
	}

	@Override
	public Object visitState(@NonNull State object) {
		context.appendParent(object, MONIKER_PART_SEPARATOR);
		context.append("S");
		context.append(MONIKER_SCOPE_SEPARATOR);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitStereotypeExtender(@NonNull StereotypeExtender object) {
		context.appendElement(object.getClass_());
		context.append(MONIKER_SCOPE_SEPARATOR);
		context.append("X");
		context.append(MONIKER_PART_SEPARATOR);
		context.appendElement((Element) object.eContainer());
		return true;
	}

	@Override
	public Object visitStringLiteralExp(@NonNull StringLiteralExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_STRING_LITERAL_EXP);
		return true;
	}

	@Override
	public Object visitTemplateBinding(@NonNull TemplateBinding object) {
		TemplateSignature signature = object.getTemplateSignature();
		if (signature != null) {
			context.appendElement(signature.getOwningElement());
		}
		context.append(BINDINGS_PREFIX);
		return true;
	}

	@Override
	public Object visitTemplateParameter(@NonNull TemplateParameter object) {
		TemplateableElement owningTemplateElement = object.getOwningSignature().getOwningElement();
		context.appendElement(owningTemplateElement);
		context.append(TEMPLATE_PARAMETER_PREFIX);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitTemplateParameterSubstitution(@NonNull TemplateParameterSubstitution object) {
		context.appendElement(object.getOwningBinding());
		context.appendName(object.getFormal());
		return true;
	}

	@Override
	public Object visitTemplateSignature(@NonNull TemplateSignature object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		return true;
	}

	@Override
	public Object visitTransition(@NonNull Transition object) {
		context.appendParent(object, MONIKER_PART_SEPARATOR);
		context.append("T");
		context.append(MONIKER_SCOPE_SEPARATOR);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitTupleLiteralExp(@NonNull TupleLiteralExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_TUPLE_LITERAL_EXP);
		return true;
	}

	@Override
	public Object visitTupleType(@NonNull TupleType object) {
		List<Property> ownedAttributes = object.getOwnedProperties();
		if (ownedAttributes.isEmpty()) {
			super.visitTupleType(object);
		}
		else {
			context.appendName(object);
			context.appendTupleType(ownedAttributes);
		}
		return true;
	}

	@Override
	public Object visitTypeExp(@NonNull TypeExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredType());
		return true;
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp object) {
		appendExpPrefix(object);
		Number unlimitedNaturalSymbol = object.getUnlimitedNaturalSymbol();
		context.append(unlimitedNaturalSymbol.toString());
		return true;
	}

	@Override
	public Object visitVariable(@NonNull Variable object) {
		appendExpPrefix(object);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitVariableExp(@NonNull VariableExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredVariable());
		return true;
	}

	@Override
	public Object visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}
}
