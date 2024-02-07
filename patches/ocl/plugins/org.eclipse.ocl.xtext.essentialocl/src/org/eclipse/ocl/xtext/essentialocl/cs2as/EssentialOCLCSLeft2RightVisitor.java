/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388493
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Lookup Environment/Visitor
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.FeatureCallExp;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.NumericLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.StateExp;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.SingletonIterator;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.xtext.base.cs2as.AmbiguitiesAdapter;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialocl.attributes.AbstractOperationMatcher;
import org.eclipse.ocl.xtext.essentialocl.attributes.BinaryOperationMatcher;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigationUtil;
import org.eclipse.ocl.xtext.essentialocl.attributes.OperationMatcher;
import org.eclipse.ocl.xtext.essentialocl.attributes.UnaryOperationMatcher;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
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
import org.eclipse.ocl.xtext.essentialoclcs.NavigationRole;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.AbstractEssentialOCLCSLeft2RightVisitor;

public class EssentialOCLCSLeft2RightVisitor extends AbstractEssentialOCLCSLeft2RightVisitor
{
	/**
	 * Configure use of the new auto-generated lookup or the old manually coded lookup.
	 */
	public static boolean AUTOGENERATED_LOOKUP = false;

	public static interface Invocations extends Iterable<NamedElement>
	{
		@Nullable NamedElement getSingleResult();

		@NonNull Type getSourceType();
	}

	private static class PropertyScopeFilter implements ScopeFilter
	{
		//		protected final @NonNull List<SquareBracketedClauseCS> csSquareBracketedClauses;
		protected final @Nullable Property oppositeProperty;

		public PropertyScopeFilter(@NonNull List<SquareBracketedClauseCS> csSquareBracketedClauses) {
			//			this.csSquareBracketedClauses = csSquareBracketedClauses;
			Property oppositeProperty = null;
			if (csSquareBracketedClauses.size() == 1) {
				SquareBracketedClauseCS csSquareBracketedClause = csSquareBracketedClauses.get(0);
				List<ExpCS> csTerms = csSquareBracketedClause.getOwnedTerms();
				if (csTerms.size() == 1) {
					ExpCS csTerm = csTerms.get(0);
					NavigationCallExp navigationCallExp = PivotUtil.getPivot(NavigationCallExp.class, csTerm);
					if (navigationCallExp != null) {
						oppositeProperty = PivotUtil.getReferredProperty(navigationCallExp);
					}
				}
			}
			this.oppositeProperty = oppositeProperty;
		}

		@Override
		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return (object instanceof Property) && (((Property)object).getOpposite() == oppositeProperty);
		}
	}

	public static class ResolvedInvocation implements Invocations
	{
		protected final @NonNull Operation invocation;

		public ResolvedInvocation(@NonNull Operation invocation) {
			this.invocation = invocation;
		}

		@Override
		public @NonNull NamedElement getSingleResult() {
			return invocation;
		}

		@Override
		public @NonNull Type getSourceType() {
			return ClassUtil.nonNullState(invocation.getOwningClass());
		}

		@Override
		public @NonNull Iterator<NamedElement> iterator() {
			return new SingletonIterator<NamedElement>(invocation);
		}
	}

	public static class UnresolvedInvocations implements Invocations
	{
		protected final @NonNull Type asType;
		protected final @NonNull List<NamedElement> invocations;

		public UnresolvedInvocations(@NonNull Type asType, @NonNull List<NamedElement> invocations) {
			this.asType = asType;
			this.invocations = invocations;
		}

		@Override
		public @Nullable NamedElement getSingleResult() {
			return invocations.size() == 1 ? invocations.get(0) : null;
		}

		@Override
		public @NonNull Type getSourceType() {
			return asType;
		}

		@Override
		public @NonNull Iterator<NamedElement> iterator() {
			return invocations.iterator();
		}
	}

	protected final @NonNull EnvironmentFactoryInternalExtension environmentFactory;
	protected final @NonNull PivotMetamodelManager metamodelManager;
	protected final @NonNull StandardLibraryInternal standardLibrary;
	/*protected final @NonNull PivotNameResolver nameResolver;*/

	/**
	 * curretRoot identifies the current InfixExpCS/PrefixExpCS tree enabling the initial visit to the containment root to
	 * be distinguished from the subsequent visit within the logical hierarchy.
	 */
	private @Nullable OperatorExpCS currentRoot = null;

	public EssentialOCLCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
		this.environmentFactory = (EnvironmentFactoryInternalExtension) context.getEnvironmentFactory();
		this.metamodelManager = environmentFactory.getMetamodelManager();
		this.standardLibrary = environmentFactory.getStandardLibrary();
		/*this.nameResolver = new PivotNameResolver(environmentFactory); // FIXME factory method*/
	}

	protected void checkForInvalidImplicitSourceType(@NonNull ExpCS csInvocationExp) {
		for (ImplicitSourceTypeIterator it = new ImplicitSourceTypeIterator(csInvocationExp); it.hasNext(); ) {
			Type next = it.next();
			if (isInvalidType(next)) {
				csInvocationExp.setHasError(true);
				break;
			}
		}
	}

	protected ImplicitSourceTypeIterator createImplicitSourceTypeIterator(@NonNull ElementCS csElement) {
		return new ImplicitSourceTypeIterator(csElement);
	}

	protected @NonNull OCLExpression createImplicitSourceVariableExp(@NonNull AbstractNameExpCS csNameExp, Type owningType) {
		VariableDeclaration sourceVariable = owningType != null ? getImplicitSource(csNameExp, owningType) : null;
		if (sourceVariable == null) {
			@SuppressWarnings("unused") VariableDeclaration sourceVariable2 = owningType != null ? getImplicitSource(csNameExp, owningType) : null;
			return context.addBadExpressionError(csNameExp, "No implicit source");
		}
		else {
			return createImplicitVariableExp(sourceVariable);
		}
	}

	protected @NonNull ImplicitSourceVariableIterator createImplicitSourceVariableIterator(@NonNull ModelElementCS csExp) {
		return new ImplicitSourceVariableIterator(csExp);
	}

	protected @NonNull VariableExp createImplicitVariableExp(@NonNull VariableDeclaration variable) {
		VariableExp variableExp = context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, null); // FIXME reuse
		variableExp.setReferredVariable(variable);
		variableExp.setName(variable.getName());
		variableExp.setIsImplicit(true);
		helper.setType(variableExp, variable.getType(), variable.isIsRequired(), variable.getTypeValue());
		return variableExp;
	}

	/*
	 * let iterations = invocations->selectByKind(Iteration)->select(owningClass <> null) in
	 * let bestIteratorSize = iterations->collect(ownedIterators->size())->min() in
	 * let bestSizeIterations = iterations->select(ownedIterators->size() = bestIteratorSize) in
	 * let owningClasses = bestSizeIterations.owningClass.unspecializedClass->asSet() in
	 * let leafClasses = owningClasses->select(c | owningClasses->intersection(c->closure(superClasses)) = c) in
	 * let leafIterations = bestSizeIterations->select(leafClasses->includes(owningClass.unspecializedClass)) in
	 * leafIterations->any(true)
	 */
	protected @Nullable Iteration getBestIteration(@NonNull Invocations invocations, @Nullable RoundBracketedClauseCS csRoundBracketedClause) {
		int requiredIterators = 0;
		if (csRoundBracketedClause != null) {
			for (NavigatingArgCS csArgument : csRoundBracketedClause.getOwnedArguments()) {
				if (csArgument.getRole() == NavigationRole.ITERATOR) {
					requiredIterators++;
				}
			}
		}
		if (requiredIterators == 0) {
			requiredIterators = 1;				// Implicit is always one iterator.
		}
		Iteration bestIteration = null;
		org.eclipse.ocl.pivot.Class bestType = null;
		for (NamedElement operation : invocations) {
			if (operation instanceof Iteration) {
				Iteration iteration = (Iteration) operation;
				int iteratorsSize = iteration.getOwnedIterators().size();
				if (iteratorsSize == requiredIterators) {
					org.eclipse.ocl.pivot.Class specializedType = iteration.getOwningClass();
					if (specializedType != null) {
						org.eclipse.ocl.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement(specializedType);
						if ((bestType == null) || !metamodelManager.isSuperClassOf(unspecializedType, bestType)) {
							bestIteration = iteration;
							bestType = unspecializedType;
						}
					}
				}
			}
		}
		return bestIteration;
	}

	protected @Nullable Operation getExampleOperation(@NonNull Invocations invocations, @Nullable OCLExpression sourceExp, @NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		NamedElement namedElement = invocations.getSingleResult();
		if (namedElement != null) {
			return namedElement instanceof Operation ? (Operation)namedElement : null;
		}
		Operation bestOperation = null;
		int bestDepth = 0;
		for (NamedElement invocation : invocations) {
			if (invocation instanceof Operation) {
				Operation operation = (Operation)invocation;
				org.eclipse.ocl.pivot.Class owningClass = operation.getOwningClass();
				if (owningClass != null) {
					CompleteClass completeClass = metamodelManager.getCompleteClass(owningClass);
					int depth = completeClass.getCompleteInheritance().getDepth();
					if ((bestOperation == null) || (depth > bestDepth)) {
						bestOperation = operation;
						bestDepth = depth;
					}
				}
			}
		}
		return bestOperation;
	}

	protected @Nullable VariableDeclaration getImplicitSource(@NonNull ModelElementCS csExp, @NonNull Type requiredType) {
		@Nullable VariableDeclaration lastVariable = null;
		for (ImplicitSourceVariableIterator it = createImplicitSourceVariableIterator(csExp); it.hasNext(); )  {
			@NonNull VariableDeclaration variable = it.next();
			lastVariable = variable;
			Type type = variable.getType();
			if ((type != null) && type.conformsTo(standardLibrary, requiredType)) {
				return variable;
			}
		}
		return lastVariable;		// If no good variable found, the outermost variable is the least bad.
	}			// FIXME report all possible variables as bad to user

	protected @Nullable Invocations getInvocations(@Nullable Type asSourceType, @Nullable Type asSourceTypeValue, @NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		PathNameCS csPathName = csNameExp.getOwnedPathName();
		if (csPathName == null) {
			return null;
		}
		List<PathElementCS> csPathElements = csPathName.getOwnedPathElements();
		if (csPathElements == null) {
			return null;
		}
		int pathSize = csPathElements.size();
		if (pathSize <= 0) {
			return null;
		}
		PathElementCS csLastPathElement = csPathElements.get(pathSize-1);
		if (csLastPathElement == null) {
			return null;
		}
		assert csLastPathElement.getElementType() != null;
		Element asElement = csLastPathElement.basicGetReferredElement();
		if ((asElement instanceof Operation) && !asElement.eIsProxy()) {
			return new ResolvedInvocation((Operation)asElement);
		}
		String name = ElementUtil.getTextName(csLastPathElement);
		if (name == null) {
			return null;
		}
		int iteratorCount = 0;
		int expressionCount = 0;
		for (NavigatingArgCS csArg : csRoundBracketedClause.getOwnedArguments()) {
			if (csArg.getRole() == NavigationRole.ITERATOR) {
				iteratorCount++;
			}
			else if (csArg.getRole() == NavigationRole.EXPRESSION) {
				expressionCount++;
			}
		}
		if (pathSize > 1) {											// Search for B::b() or a.B::b() candidates in B
			Type asType = context.getConverter().lookupTypeQualifier(csPathName);
			if (asType == null) {
				return null;
			}
			Invocations invocations = getInvocations(asType, asType, name, iteratorCount, expressionCount);
			if ((invocations == null) && name.startsWith("_")) {
				@NonNull String unescapedName = name.substring(1);				// FIXME Compatibility
				invocations = getInvocations(asType, asType, unescapedName, iteratorCount, expressionCount);
			}
			return invocations;
		}
		else if (asSourceType != null) {								// Search for a.b() candidates in type of a
			TemplateParameter asTemplateParameter = asSourceType.isTemplateParameter();
			if (asTemplateParameter != null) {
				org.eclipse.ocl.pivot.Class lowerBound = PivotUtil.basicGetLowerBound(asTemplateParameter);
				if (lowerBound != null) {		// ?? OclAny for null
					asSourceType = lowerBound;
				}
			}
			Invocations invocations = getInvocations(asSourceType, asSourceTypeValue, name, iteratorCount, expressionCount);
			if ((invocations == null) && name.startsWith("_")) {
				String unescapedName = name.substring(1);				// FIXME Compatibility
				invocations = getInvocations(asSourceType, asSourceTypeValue, unescapedName, iteratorCount, expressionCount);
			}
			return invocations;
		}
		else {														// Search for a() candidates in implicit source variable types
			Invocations invocations = null;
			for (ImplicitSourceTypeIterator it = createImplicitSourceTypeIterator(csNameExp); (invocations == null) && it.hasNext(); ) {
				Type asType = it.next();
				invocations = getInvocations(asType, it.nextValue(), name, iteratorCount, expressionCount);
			}
			if ((invocations == null) && name.startsWith("_")) {
				String unescapedName = name.substring(1);				// FIXME Compatibility
				for (ImplicitSourceTypeIterator it = createImplicitSourceTypeIterator(csNameExp); (invocations == null) && it.hasNext(); ) {
					Type asType = it.next();
					invocations = getInvocations(asType, null, unescapedName, iteratorCount, expressionCount);
				}
			}
			return invocations;
		}
	}

	/**
	 * Return all operations/iterations in asType and its superclasses whose name is name. For iterations the number of iteration iterators must
	 * match iteratorCount unless iteratorCount is zero. For operations the number of parameters must be expressionCount. Returns null if
	 * nothing is found. If asTypeValue is non-null a fall-back attempt to look up a static operation in asTypeValue is made.
	 */
	protected @Nullable Invocations getInvocations(@NonNull Type asType, @Nullable Type asTypeValue, @NonNull String name, int iteratorCount, int expressionCount) {
		TemplateParameter asTemplateParameter = asType.isTemplateParameter();
		if (asTemplateParameter != null) {
			asType = PivotUtil.getLowerBound(asTemplateParameter, standardLibrary.getOclAnyType());
		}
		Iterable<@NonNull ? extends Operation> nonStaticOperations = metamodelManager.getAllOperations(asType, FeatureFilter.SELECT_NON_STATIC, name);
		List<@NonNull NamedElement> invocations = getInvocationsInternal(null, nonStaticOperations, iteratorCount, expressionCount);
		if (asType instanceof ElementExtension) {				// FIXME review me
			Type asStereotype = ((ElementExtension)asType).getStereotype();
			if (asStereotype != null) {
				Iterable<@NonNull ? extends Operation> stereotypeOperations = metamodelManager.getAllOperations(asStereotype, FeatureFilter.SELECT_NON_STATIC, name);
				invocations = getInvocationsInternal(invocations, stereotypeOperations, iteratorCount, expressionCount);
			}
		}
		if (asTypeValue != null) {
			Iterable<@NonNull ? extends Operation> staticOperations = metamodelManager.getAllOperations(asTypeValue, FeatureFilter.SELECT_STATIC, name);
			invocations = getInvocationsInternal(invocations, staticOperations, iteratorCount, expressionCount);
		}
		return invocations != null ? new UnresolvedInvocations(asType, invocations) : null;
	}
	protected @Nullable List<@NonNull NamedElement> getInvocationsInternal(@Nullable List<@NonNull NamedElement> invocations,
			@NonNull Iterable<@NonNull ? extends Operation> allOperations, int iteratorCount, int expressionCount) {
		for (@NonNull Operation operation : allOperations) {
			Operation asOperation = null;
			if (operation instanceof Iteration) {
				Iteration candidateIteration = (Iteration) operation;
				int iteratorsSize = candidateIteration.getOwnedIterators().size();
				if ((iteratorCount == 0) || (iteratorCount == iteratorsSize)) {
					asOperation = candidateIteration;
				}
			}
			else {
				Operation candidateOperation = operation;
				int operationsSize = candidateOperation.getOwnedParameters().size();
				if (expressionCount == operationsSize) {
					asOperation = candidateOperation;
				}
			}
			if (asOperation != null) {
				if (invocations == null) {
					invocations = new ArrayList<>();
				}
				invocations.add(asOperation);
			}
		}
		return invocations;
	}

	protected @NonNull OperatorExpCS getRoot(@NonNull OperatorExpCS csOperator) {
		OperatorExpCS csRoot = csOperator;
		for (OperatorExpCS csParent = csRoot.getLocalParent(); csParent != null; csParent = csParent.getLocalParent()) {
			csRoot = csParent;
		}
		return csRoot;
	}

	protected boolean isAssociationClassCallExp(@NonNull NameExpCS csNameExp) {		// See Bug 423905
		List<SquareBracketedClauseCS> csSquareBracketedClauses = csNameExp.getOwnedSquareBracketedClauses();
		if (csSquareBracketedClauses.size() == 0) {
			return false;
		}
		if (csSquareBracketedClauses.size() == 1) {
			List<ExpCS> csTerms = csSquareBracketedClauses.get(0).getOwnedTerms();
			if (csTerms.size() == 1) {
				ExpCS csTerm = csTerms.get(0);
				if (csTerm instanceof NumberLiteralExpCS) {	// only numerics ambiguous * / .. are MultiplicityCS
					return false;
				}
			}
		}
		return true;
	}

	protected boolean isInvalidType(@Nullable Type type) {
		return (type == null) || (type instanceof InvalidType)
				|| ((type instanceof CollectionType) && (((CollectionType)type).getElementType() instanceof InvalidType));
	}

	/** @deprecated use ElementUtil */
	@Deprecated
	protected boolean isRequired(@Nullable TypedRefCS csTypeRef) {
		return ElementUtil.isRequired(csTypeRef);
	}

	protected @NonNull OperationCallExp refreshOperationCallExp(@NonNull AbstractNameExpCS csNameExp, @Nullable OCLExpression sourceExp) {
		OperationCallExp callExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csNameExp);
		callExp.setOwnedSource(sourceExp);
		return callExp;
	}

	protected @NonNull OppositePropertyCallExp refreshOppositePropertyCallExp(@NonNull NameExpCS csNameExp, @NonNull OCLExpression sourceExp, @NonNull Property property) {
		OppositePropertyCallExp callExp = context.refreshModelElement(OppositePropertyCallExp.class, PivotPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP, csNameExp);
		callExp.setOwnedSource(sourceExp);
		callExp.setReferredProperty(property.getOpposite());
		callExp.setName(property.getName());
		return callExp;
	}

	protected @NonNull PropertyCallExp refreshPropertyCallExp(@NonNull NameExpCS csNameExp, @NonNull OCLExpression sourceExp, @NonNull Property property) {
		PropertyCallExp callExp = context.refreshModelElement(PropertyCallExp.class, PivotPackage.Literals.PROPERTY_CALL_EXP, csNameExp);
		callExp.setOwnedSource(sourceExp);
		callExp.setReferredProperty(property);
		callExp.setName(property.getName());
		return callExp;
	}

	protected Element resolveAssociationClassCallExp(@NonNull NameExpCS csNameExp) {			// See Bug 423905
		//		PathNameCS pathName = csNameExp.getPathName();
		RoundBracketedClauseCS csRoundBracketedClause = csNameExp.getOwnedRoundBracketedClause();
		List<SquareBracketedClauseCS> csSquareBracketedClauses = csNameExp.getOwnedSquareBracketedClauses();
		if (csSquareBracketedClauses.size() > 2) {
			return context.addBadExpressionError(csNameExp, "AssociationClassCallExp must have exactly only one or two square-brackets-clauses");
		}
		if (csRoundBracketedClause != null) {
			return context.addBadExpressionError(csNameExp, "AssociationClassCallExp must have no round-brackets-clause");
		}
		//		SquareBracketedClauseCS csSquareBracketedClause = csSquareBracketedClauses.get(0);
		//		CS2AS.setElementType(pathName, PivotPackage.Literals.ASSOCIATION_CLASS, csNameExp, null);
		//			Element element = pathName.getElement();
		//			return resolveShadowExp((Type)element, csNameExp);
		return null;
	}

	protected void resolveAtPre(@Nullable AbstractNameExpCS csNameExp, @NonNull FeatureCallExp featureCallExp) {
		if (csNameExp != null) {
			featureCallExp.setIsPre(csNameExp.isIsPre());
		}
	}

	/**
	 * Resolve an invocation such as name() or source.name(...)  or source-&gt;name(...) to the best candidate from invocations.
	 * <p>
	 * sourceExp is null for an implicit source invocation.
	 * <p>
	 * csInvocationExp.getNamedElement() must be invoked once, after the left-hand context has been established to enable the lokup to
	 * proceed in a simple (perhaps rivial) fashion.
	 */
	protected @Nullable OCLExpression resolveBestInvocation(@Nullable OCLExpression sourceExp, @NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull Invocations invocations) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		PathNameCS csPathName = csNameExp.getOwnedPathName();
		if (csPathName == null) {
			return null;
		}
		Iteration iteration = getBestIteration(invocations, csRoundBracketedClause);
		if (iteration != null) {
			if (sourceExp == null) {
				sourceExp = createImplicitSourceVariableExp(csNameExp, iteration.getOwningClass());
			}
			LoopExp iterationCallExp = resolveIterationCallExp(csNameExp, sourceExp, iteration);
			CS2AS.setPathElement(csPathName, iteration, null);
			resolveIterationContent(csRoundBracketedClause, iterationCallExp);
			return iterationCallExp;
		}
		Operation exampleOperation = getExampleOperation(invocations, sourceExp, csRoundBracketedClause);
		if (exampleOperation != null) {
			if (sourceExp == null) {
				sourceExp = createImplicitSourceVariableExp(csNameExp, exampleOperation.getOwningClass());
			}
			OperationCallExp operationCallExp = refreshOperationCallExp(csNameExp, sourceExp);
			if (invocations.getSingleResult() != null) {
				context.setReferredOperation(operationCallExp, exampleOperation);
			}
			//
			//	Need to resolve types for operation arguments in order to disambiguate operation names.
			//
			resolveOperationArgumentTypes(exampleOperation.getOwnedParameters(), csRoundBracketedClause);
			//
			//	Resolve the static operation/iteration by name and known operation argument types.
			//
			Type explicitSourceType = null;
			InfixExpCS csNavigationOperator = NavigationUtil.getNavigationInfixExp(csNameExp);
			if (csNavigationOperator != null) {										// For a->X(); X must be resolved in the navigation source type
				explicitSourceType = csNameExp.getSourceTypeValue() != null ? csNameExp.getSourceTypeValue() : csNameExp.getSourceType();
				if (explicitSourceType == null) {
					return null;
				}
			}
			if (explicitSourceType == null) {
				explicitSourceType = invocations.getSourceType();
			}
			Operation asOperation = null;
			OperationMatcher matcher = new OperationMatcher(environmentFactory, explicitSourceType, null);
			boolean isMatchable = matcher.init(csRoundBracketedClause);
			if (isMatchable) {
				asOperation = matcher.getBestOperation(invocations, false);
				//
				//	Try again with argument coercion.
				//
				if (asOperation == null) {
					asOperation = matcher.getBestOperation(invocations, true);
				}
			}
			//
			//	Search for invocations with a coerced source.
			//
			if (asOperation == null) {
				Operation asCoercion = null;
				CompleteClass completeClass = metamodelManager.getCompleteClass(explicitSourceType);
				for (org.eclipse.ocl.pivot.Class partialClass : completeClass.getPartialClasses()) {
					if (partialClass instanceof PrimitiveType) {
						for (Operation coercion : ((PrimitiveType)partialClass).getCoercions()) {
							Type corcedSourceType = coercion.getType();
							Invocations coercedInvocations = getInvocations(corcedSourceType, null, csRoundBracketedClause);
							if (coercedInvocations != null) {
								matcher = new OperationMatcher(environmentFactory, corcedSourceType, null);
								isMatchable = matcher.init(csRoundBracketedClause);
								if (isMatchable) {
									asOperation = matcher.getBestOperation(coercedInvocations, false);
									if (asOperation == null) {
										asOperation = matcher.getBestOperation(coercedInvocations, true);
									}
								}
							}
							if (asOperation != null) {
								asCoercion = coercion;
								break;
							}
						}
						if (asCoercion != null) {
							break;
						}
					}
				}
				if (asCoercion != null) {
					operationCallExp.setOwnedSource(null);
					OCLExpression asCoercionCallExp = new PivotHelper(environmentFactory).createCoercionCallExp(sourceExp, asCoercion);
					operationCallExp.setOwnedSource(asCoercionCallExp);
				}
			}
			CS2AS.setPathElement(csPathName, asOperation, matcher.getAmbiguities());
			if (asOperation != null) {
				return resolveOperationCallExp(csRoundBracketedClause, operationCallExp, asOperation);
			}
		}
		return null;
	}

	/**
	 * Return a non-null coercion Operation from argType to parameterType if one is available and needed.
	 */
	protected @Nullable Operation resolveCoercionFrom(@NonNull Type argType, @NonNull Type parameterType) {
		if (!metamodelManager.conformsTo(argType, TemplateParameterSubstitutions.EMPTY, parameterType, TemplateParameterSubstitutions.EMPTY)) {
			CompleteClass completeClass = metamodelManager.getCompleteClass(argType);
			for (org.eclipse.ocl.pivot.Class partialClass : completeClass.getPartialClasses()) {
				if (partialClass instanceof PrimitiveType) {
					for (Operation coercion : ((PrimitiveType)partialClass).getCoercions()) {
						Type corcedArgType = coercion.getType();
						if ((corcedArgType != null) && metamodelManager.conformsTo(corcedArgType, TemplateParameterSubstitutions.EMPTY, parameterType, TemplateParameterSubstitutions.EMPTY)) {
							return coercion;
						}
					}
				}
			}
		}
		return null;
	}

	protected @NonNull EnumLiteralExp resolveEnumLiteral(@NonNull ExpCS csExp, @NonNull EnumerationLiteral enumerationLiteral) {
		EnumLiteralExp expression = context.refreshModelElement(EnumLiteralExp.class, PivotPackage.Literals.ENUM_LITERAL_EXP, csExp);
		helper.setType(expression, enumerationLiteral.getOwningEnumeration(), true, null /* enumerationLiteral.getTypeId() */);
		expression.setReferredLiteral(enumerationLiteral);
		expression.setName(enumerationLiteral.getName());
		return expression;
	}

	/**
	 * Resolve an invocation such as source.name  or source-&gt;name
	 */
	protected @NonNull OCLExpression resolveExplicitSourceNavigation(@NonNull OCLExpression sourceExp, @NonNull NameExpCS csNameExp) {
		PathNameCS ownedPathName = ClassUtil.nonNullState(csNameExp.getOwnedPathName());
		ScopeFilter propertyScopeFilter = AbstractAttribution.NOT_STATIC_SCOPE_FILTER;
		List<SquareBracketedClauseCS> csSquareBracketedClauses = csNameExp.getOwnedSquareBracketedClauses();
		if (csSquareBracketedClauses.size() > 0) {
			for (SquareBracketedClauseCS csSquareBracketedClause : csSquareBracketedClauses) {
				for (ExpCS csExp : csSquareBracketedClause.getOwnedTerms()) {
					csExp.accept(this);
				}
			}
			propertyScopeFilter = new PropertyScopeFilter(csSquareBracketedClauses);	// FIXME nonStatic
		}
		// FIXME Qualified navigation See Bug 423905
		Property resolvedProperty = context.lookupProperty(csNameExp, ownedPathName, propertyScopeFilter);
		if ((resolvedProperty != null) && !resolvedProperty.eIsProxy()) {
			if (resolvedProperty.getType() instanceof Stereotype) {			// FIXME Bug 578010 - M2 properties need reification with correct types at M1
				return resolvePropertyCallExp(sourceExp, csNameExp, resolvedProperty);
			}
			Type resolvedSourceType = PivotUtil.getType(sourceExp);
			Type propertySourceType = PivotUtil.getOwningClass(resolvedProperty);
			if (resolvedSourceType.conformsTo(standardLibrary, propertySourceType)) {
				return resolvePropertyCallExp(sourceExp, csNameExp, resolvedProperty);
			}
			context.addError(csNameExp, EssentialOCLCS2ASMessages.PropertyCallExp_IncompatibleProperty, resolvedProperty);
		}
		Property oclInvalidProperty = standardLibrary.getOclInvalidProperty();
		PropertyCallExp expression = refreshPropertyCallExp(csNameExp, sourceExp, oclInvalidProperty);
		helper.setType(expression, standardLibrary.getOclInvalidType(), false, null);
		ElementUtil.setLastPathElement(ownedPathName, oclInvalidProperty);
		return expression;
	}

	protected @NonNull OCLExpression resolveImplicitAsSet(@NonNull OCLExpression sourceExp, @NonNull Type sourceType, @NonNull InfixExpCS csOperator) {
		OperationCallExp expression = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, null);
		expression.setIsImplicit(true);
		PivotUtilInternal.resetContainer(sourceExp);
		expression.setOwnedSource(sourceExp);
		expression.setName("oclAsSet");
		resolveOperationCall(expression, csOperator);
		return expression;
	}

	/**
	 * Return a non-null implicit collect() call if a sourceExp for a csElement requires an implicit collect.
	 * The return call has no body or return type since they cannot be synthesised until the body is synthesised.
	 */
	protected @Nullable IteratorExp resolveImplicitCollect(@NonNull OCLExpression sourceExp, @NonNull InfixExpCS csOperator) {
		Type elementType;
		Type actualSourceType = sourceExp.getType();
		boolean isNullFree;
		if (actualSourceType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)actualSourceType;
			elementType = collectionType.getElementType();
			isNullFree = collectionType.isIsNullFree();
		}
		else if (actualSourceType instanceof MapType) {
			MapType mapType = (MapType)actualSourceType;
			elementType = mapType.getKeyType();
			isNullFree = mapType.isKeysAreNullFree();
		}
		else {
			return null;
		}
		if (elementType == null) {
			return null;
		}
		Invocations invocations = getInvocations(actualSourceType, null, "collect", 1, 0);
		if (invocations == null) {
			return null;
		}
		Iteration asIteration = getBestIteration(invocations, null);
		if (asIteration == null) {
			return null;
		}
		boolean isSafe = PivotConstants.SAFE_OBJECT_NAVIGATION_OPERATOR.equals(csOperator.getName());
		IteratorExp implicitCollectExp = context.refreshModelElement(IteratorExp.class, PivotPackage.Literals.ITERATOR_EXP, null);
		implicitCollectExp.setIsImplicit(true);
		PivotUtilInternal.resetContainer(sourceExp);
		implicitCollectExp.setOwnedSource(sourceExp);
		implicitCollectExp.setName(asIteration.getName());
		implicitCollectExp.setIsSafe(isSafe);
		context.setReferredIteration(implicitCollectExp, asIteration);
		IteratorVariable iterator = context.refreshModelElement(IteratorVariable.class, PivotPackage.Literals.ITERATOR_VARIABLE, null); // FIXME reuse
		Parameter resolvedIterator = asIteration.getOwnedIterators().get(0);
		iterator.setRepresentedParameter(resolvedIterator);
		helper.refreshName(iterator, "1_");
		helper.setType(iterator, elementType, isSafe || isNullFree, null);
		iterator.setIsImplicit(true);
		implicitCollectExp.getOwnedIterators().add(iterator);
		return implicitCollectExp;
	}

	/**
	 * Resolve an invocation such as name() or source.name(...)  or source-&gt;name(...)
	 */
	protected @NonNull OCLExpression resolveInvocation(@Nullable OCLExpression sourceExp, @NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		PathNameCS csPathName = csNameExp.getOwnedPathName();
		if (csPathName != null) {			// QVTr overrides to select a wider search
			List<PathElementCS> csPath = csPathName.getOwnedPathElements();
			int pathSize = csPath.size();
			if (pathSize > 0) {
				PathElementCS csLastPathElement = csPath.get(pathSize-1);
				if (csLastPathElement.getElementType() == null) {
					csLastPathElement.setElementType(PivotPackage.Literals.OPERATION);
				}
			}
		}
		Invocations invocations = getInvocations(sourceExp != null ? sourceExp.getType() : null,
			sourceExp != null ? sourceExp.getTypeValue() : null, csRoundBracketedClause);
		if (invocations != null) {
			OCLExpression invocationExp = resolveBestInvocation(sourceExp, csRoundBracketedClause, invocations);
			if (invocationExp != null) {
				return invocationExp;
			}
			assert csPathName != null;
		}
		else {
			checkForInvalidImplicitSourceType(csNameExp);
			CS2AS.setPathElement(ClassUtil.nonNullState(csPathName), null, null);
		}
		if (sourceExp == null) {
			sourceExp = createImplicitSourceVariableExp(csNameExp, standardLibrary.getOclAnyType());
		}
		OperationCallExp operationCallExp = refreshOperationCallExp(csNameExp, sourceExp);
		Operation oclInvalidOperation = standardLibrary.getOclInvalidOperation();
		context.setReferredOperation(operationCallExp, oclInvalidOperation);
		if (csPathName != null) {
			ElementUtil.setLastPathElement(csPathName, oclInvalidOperation);
		}
		context.installPivotUsage(csNameExp, operationCallExp);
		helper.setType(operationCallExp, standardLibrary.getOclInvalidType(), false, null);
		return operationCallExp;
	}

	protected boolean resolveIterationAccumulators(@NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull LoopExp expression) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		Iteration iteration = expression.getReferredIteration();
		List<@NonNull Variable> pivotAccumulators = new ArrayList<>();
		//
		//	Explicit accumulator
		//
		for (NavigatingArgCS csArgument : csRoundBracketedClause.getOwnedArguments()) {
			if (csArgument.getRole() != NavigationRole.ACCUMULATOR) {
				continue;
			}
			ExpCS csName = csArgument.getOwnedNameExpression();
			ExpCS csInit;
			if (csName instanceof InfixExpCS) {
				InfixExpCS csInfixExp = (InfixExpCS)csName;
				assert "=".equals(csInfixExp.getName());		// assured by EssentialOCLCSContainmentVisitor.canBeAccumulator
				csInit = csInfixExp.getOwnedRight();
				csName = csInfixExp.getOwnedLeft();
			}
			else {
				csInit = csArgument.getOwnedInitExpression();
			}
			Variable acc = PivotUtil.getPivot(Variable.class, csName);
			if (acc != null) {
				context.installPivotUsage(csArgument, acc);
				if (csInit != null) {
					OCLExpression initExpression = context.visitLeft2Right(OCLExpression.class, csInit);
					acc.setOwnedInit(initExpression);
					TypedRefCS csAccType = csArgument.getOwnedType();
					Type accType = null;
					Boolean accIsRequired = null;
					if (csAccType != null) {
						accType = PivotUtil.getPivot(Type.class, csAccType);
						accIsRequired = context.getConverter().isRequired(csAccType);
					}
					if (initExpression != null) {
						if (accType == null) {
							accType = initExpression.getType();
						}
						if (accIsRequired == null) {
							accIsRequired = initExpression.isIsRequired();
						}
					}
					helper.setType(acc, accType, accIsRequired == Boolean.TRUE, null);
				}
				if (pivotAccumulators.size() >= iteration.getOwnedAccumulators().size()) {
					context.addError(csNameExp, EssentialOCLCS2ASMessages.IterateExp_TooManyAccumulators, ElementUtil.getTrimmedText(csNameExp.getOwnedPathName()));
					return false;
				}
				acc.setRepresentedParameter(iteration.getOwnedAccumulators().get(pivotAccumulators.size()));
				pivotAccumulators.add(acc);
			}
			String prefix = csArgument.getPrefix();
			if ((prefix != null) && !prefix.equals(";")) {
				context.addWarning(csArgument, EssentialOCLCS2ASMessages.IterateExp_BadAccumulatorSeparator, prefix);
			}
			if (csInit == null) {
				context.addError(csArgument, EssentialOCLCS2ASMessages.IterateExp_MissingInitializer);
				return false;
			}
			//			if (csArgument.getOwnedType() != null) {
			//				context.addError(csArgument, "Unexpected type for parameter");
			//			}
		}
		//
		//	Implicit Accumulator
		//
		int accumulatorCount = pivotAccumulators.size();
		if (expression instanceof IterateExp) {
			IterateExp iterateExp = (IterateExp)expression;
			if (accumulatorCount > 1) {
				context.addError(csNameExp, EssentialOCLCS2ASMessages.IterateExp_TooManyAccumulators, ElementUtil.getTrimmedText(csNameExp.getOwnedPathName()));
				return false;
			}
			else if (accumulatorCount < 1) {
				context.addError(csNameExp, EssentialOCLCS2ASMessages.IterateExp_TooFewAccumulators, ElementUtil.getTrimmedText(csNameExp.getOwnedPathName()));
				return false;
			}
			else {
				iterateExp.setOwnedResult(pivotAccumulators.get(0));
			}
		}
		else if (accumulatorCount > 0) {
			context.addError(csNameExp, EssentialOCLCS2ASMessages.IteratorExp_TooManyAccumulators, ElementUtil.getTrimmedText(csNameExp.getOwnedPathName()));
		}
		return true;
	}

	protected void resolveIterationBody(@NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull LoopExp expression) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		List<@NonNull OCLExpression> pivotBodies = new ArrayList<>();
		boolean hasIteratorOrAccumulator = false;
		for (NavigatingArgCS csArgument : csRoundBracketedClause.getOwnedArguments()) {
			if (csArgument.getRole() == NavigationRole.ITERATOR) {
				hasIteratorOrAccumulator = true;
			}
			else if (csArgument.getRole() == NavigationRole.ACCUMULATOR) {
				hasIteratorOrAccumulator = true;
			}
			else if (csArgument.getRole() == NavigationRole.EXPRESSION) {
				if (csArgument.getOwnedInitExpression() != null) {
					context.addError(csArgument, EssentialOCLCS2ASMessages.LoopExp_UnexpectedInitializer);
				}
				if (csArgument.getOwnedType() != null) {
					context.addError(csArgument, EssentialOCLCS2ASMessages.LoopExp_UnexpectedType);
				}
				ExpCS name = csArgument.getOwnedNameExpression();
				assert name != null;
				//				OCLExpression exp = context.visitLeft2Right(OCLExpression.class, name);
				OCLExpression exp = !hasIteratorOrAccumulator ? PivotUtil.getPivot(OCLExpression.class, csArgument) : context.visitLeft2Right(OCLExpression.class, name);
				//				context.installPivotElement(csArgument, exp);
				if (exp != null) {
					context.installPivotUsage(csArgument, exp);
					pivotBodies.add(exp);
				}
				else {
					pivotBodies.add(context.addBadExpressionError(csArgument, "Invalid ''{0}'' iteration body", csNameExp.getOwnedPathName()));
				}
			}
		}
		if (pivotBodies.size() != 1) {
			expression.setOwnedBody(context.addBadExpressionError(csNameExp, "Iteration ''{0}'' must have exactly one body", csNameExp.getOwnedPathName()));
		}
		else {
			expression.setOwnedBody(pivotBodies.get(0));
		}
	}

	protected @NonNull LoopExp resolveIterationCallExp(@NonNull AbstractNameExpCS csNameExp, @NonNull OCLExpression sourceExp, @NonNull Iteration iteration) {
		LoopExp expression;
		if (iteration.getOwnedAccumulators().size() > 0) {
			expression = context.refreshModelElement(IterateExp.class, PivotPackage.Literals.ITERATE_EXP, csNameExp);
		}
		else {
			expression = context.refreshModelElement(IteratorExp.class, PivotPackage.Literals.ITERATOR_EXP, csNameExp);
		}
		expression.setOwnedSource(sourceExp);
		context.setReferredIteration(expression, iteration);
		return expression;
	}

	protected void resolveIterationContent(@NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull LoopExp expression) {
		boolean allOk = true;
		OCLExpression source = ClassUtil.nonNullState(expression.getOwnedSource());
		if (allOk) {
			resolveIterationIterators(csRoundBracketedClause, source, expression);
		}
		if (allOk) {
			allOk = resolveIterationAccumulators(csRoundBracketedClause, expression);
		}
		if (allOk) {
			resolveOperationArgumentTypes(null, csRoundBracketedClause);
		}
		if (allOk) {
			resolveIterationBody(csRoundBracketedClause, expression);
		}
		if (allOk && (expression instanceof IterateExp)) {
			IterateExp iterateExp = (IterateExp)expression;
			OCLExpression ownedBody = iterateExp.getOwnedBody();
			if ((ownedBody != null) && ownedBody.isIsRequired()) {
				Variable ownedResult = iterateExp.getOwnedResult();
				if (ownedResult != null) {
					OCLExpression ownedInit = ownedResult.getOwnedInit();
					if ((ownedInit != null) && ownedInit.isIsRequired()) {
						ownedResult.setIsRequired(true);
					}
				}
			}
		}
		if (allOk) {
			resolveOperationReturnType(expression);
		}
	}

	protected void resolveIterationIterators(@NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull OCLExpression source, @NonNull LoopExp expression) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		OperatorExpCS csParent = csNameExp.getLocalParent();
		boolean isSafe = false;
		if (csParent instanceof InfixExpCS) {
			String operatorName = ((InfixExpCS)csParent).getName();
			isSafe = PivotConstants.SAFE_AGGREGATE_NAVIGATION_OPERATOR.equals(operatorName);
		}
		//		boolean isSafe = PivotUtil.isSafeNavigationOperator(navigationOperatorName);
		Iteration iteration = expression.getReferredIteration();
		//
		//	Explicit iterators
		//
		int iterationIteratorsSize = iteration.getOwnedIterators().size();
		int iteratorIndex = 0;
		boolean isCollection = false;
		MapType mapType = null;
		List</*@Nullable*/ IteratorVariable> pivotCoIterators = null;
		Type rawSourceElementType = null;
		Type sourceType = csNameExp.getSourceType();
		if (sourceType instanceof CollectionType) {
			isCollection = true;
			CollectionType sourceCollectionType = (CollectionType)sourceType;
			if (sourceCollectionType.isIsNullFree()) {
				isSafe = true;
			}
			rawSourceElementType = sourceCollectionType.getElementType();
			if (sourceCollectionType.isOrdered()) {
				pivotCoIterators = new ArrayList<>();
			}
		}
		else if (sourceType instanceof MapType) {
			mapType = (MapType)sourceType;
			if (mapType.isKeysAreNullFree()) {
				isSafe = true;
			}
			rawSourceElementType = mapType.getKeyType();
			pivotCoIterators = new ArrayList<>();
		}
		if (!isCollection && (mapType == null)) {
			throw new UnsupportedOperationException();
		}
		boolean hasCoIterator = false;
		List<@NonNull Variable> pivotIterators = new ArrayList<>();
		Type sourceElementType = rawSourceElementType != null ? metamodelManager.getPrimaryType(rawSourceElementType) : null;
		for (int argIndex = 0; argIndex < csRoundBracketedClause.getOwnedArguments().size(); argIndex++) {
			NavigatingArgCS csArgument = csRoundBracketedClause.getOwnedArguments().get(argIndex);
			if (csArgument.getRole() != NavigationRole.ITERATOR) {
				continue;
			}
			if (iterationIteratorsSize <= argIndex) {
				context.addWarning(csArgument, PivotMessagesInternal.RedundantIterator_WARNING_, iteration.getName());
				continue;
			}
			//	if (csArgument.getCoIteratorName() != null) {
			//		)
			//	}
			if (csArgument.getOwnedInitExpression() != null) {
				context.addError(csArgument, "Unexpected initializer for iterator");
			}
			//			if (csArgument.getOwnedType() == null) {
			//				context.addError(csArgument, "Missing type for iterator");
			//			}
			ExpCS csName = csArgument.getOwnedNameExpression();
			Variable iterator = PivotUtil.getPivot(Variable.class, csName);
			if (iterator != null) {
				context.installPivotUsage(csArgument, iterator);
				Parameter formalIterator = iteration.getOwnedIterators().get(iteratorIndex);
				iterator.setRepresentedParameter(formalIterator);
				Type varType = null;
				TypedRefCS csType = csArgument.getOwnedType();
				Boolean iteratorIsRequired = null;
				if (csType != null) {
					iteratorIsRequired = context.isRequired(csType);
					varType = PivotUtil.getPivot(Type.class, csType);
				}
				if (varType == null) {
					varType = sourceElementType;
				}
				boolean isRequired = iteratorIsRequired != null ? iteratorIsRequired.booleanValue() : isSafe || formalIterator.isIsRequired();
				helper.setType(iterator, varType, isRequired, null);
				pivotIterators.add(iterator);
				IteratorVariable coIterator = null;
				VariableCS csCoIterator = csArgument.getOwnedCoIterator();
				if (csCoIterator != null) {
					if ((pivotCoIterators != null)) {
						coIterator = PivotUtil.getPivot(IteratorVariable.class, csCoIterator);
						if (coIterator != null) {
							hasCoIterator = true;
							Type coIteratorType = null;
							TypedRefCS csCoIteratorType = csCoIterator.getOwnedType();
							Boolean coIteratorIsRequired = null;
							if (csCoIteratorType != null) {
								coIteratorIsRequired = context.isRequired(csCoIteratorType);
								coIteratorType = PivotUtil.getPivot(Type.class, csCoIteratorType);
							}
							if (coIteratorType == null) {
								if (mapType != null) {
									coIteratorType = mapType.getValueType();
									coIteratorIsRequired = mapType.isValuesAreNullFree();
								}
								else {
									coIteratorType = standardLibrary.getIntegerType();
									coIteratorIsRequired = true;
								}
							}
							boolean coIsRequired = coIteratorIsRequired != null ? coIteratorIsRequired.booleanValue() : isSafe || formalIterator.isIsRequired();
							helper.setType(coIterator, coIteratorType, coIsRequired, null);  // FIXME isRequired *2
						}
					}
					else {
						context.addError(csCoIterator, PivotMessages.IllegalCoIterator, sourceType);
					}
				}
				if (pivotCoIterators != null) {
					pivotCoIterators.add(coIterator);
				}
				iteratorIndex++;
			}
		}
		//
		//	Implicit Iterators
		//
		while (iteratorIndex < iterationIteratorsSize) {
			Parameter formalIterator = iteration.getOwnedIterators().get(iteratorIndex);
			String varName = Integer.toString(iteratorIndex+1) + "_";
			IteratorVariable iterator = context.refreshModelElement(IteratorVariable.class, PivotPackage.Literals.ITERATOR_VARIABLE, null);
			helper.refreshName(iterator, varName);
			helper.setType(iterator, sourceElementType, isSafe || formalIterator.isIsRequired(), null);
			iterator.setIsImplicit(true);
			iterator.setRepresentedParameter(formalIterator);
			pivotIterators.add(iterator);
			iteratorIndex++;
		}
		//
		//	Implicit CoIterators
		//
		if ((pivotCoIterators != null) && hasCoIterator) {
			for (int coiteratorIndex = 0; coiteratorIndex < pivotCoIterators.size(); coiteratorIndex++) {
				IteratorVariable coIterator = pivotCoIterators.get(coiteratorIndex);
				if (coIterator == null) {
					boolean coIteratorIsRequired ;
					if (mapType != null) {
						coIteratorIsRequired = isSafe || mapType.isValuesAreNullFree();
					}
					else {
						coIteratorIsRequired = true;
					}
					String varName = Integer.toString(iterationIteratorsSize + coiteratorIndex+1) + "_";
					coIterator = context.refreshModelElement(IteratorVariable.class, PivotPackage.Literals.ITERATOR_VARIABLE, null);
					helper.refreshName(coIterator, varName);
					helper.setType(coIterator, sourceElementType, coIteratorIsRequired, null);
					coIterator.setIsImplicit(true);
					pivotCoIterators.set(coiteratorIndex, coIterator);
				}
			}
		}
		helper.refreshList(expression.getOwnedIterators(), pivotIterators);
		if (hasCoIterator) {
			helper.refreshList(expression.getOwnedCoIterators(), pivotCoIterators);
		}
		else {
			expression.getOwnedCoIterators().clear();
		}
	}

	/**
	 * Determine the type of each operation argument so that the appropriate operation overload can be selected.
	 * Arguments aligned with type (MetaClass) parameters are set to be parsed as types avoiding ambiguities from
	 * implicit opposite properties. Iterator bodies are left unresolved.
	 */
	protected void resolveOperationArgumentTypes(@Nullable List<Parameter> parameters, @NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		int argIndex = 0;
		for (NavigatingArgCS csArgument : csRoundBracketedClause.getOwnedArguments()) {
			if (csArgument.getRole() == NavigationRole.ITERATOR) {
				break;
			}
			else if (csArgument.getRole() == NavigationRole.ACCUMULATOR) {
				break;
			}
			else if (csArgument.getRole() == NavigationRole.EXPRESSION) {
				ExpCS csName = csArgument.getOwnedNameExpression();
				if (csName != null) {
					OCLExpression arg = context.visitLeft2Right(OCLExpression.class, csName);
					if (arg != null) {
						context.installPivotUsage(csArgument, arg);
					}
				}
				argIndex++;
			}
		}
	}

	/**
	 * Complete the installation of each operation argument in its operation call.
	 */
	protected void resolveOperationArguments(@NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull Operation operation, @NonNull OperationCallExp expression) {
		@SuppressWarnings("null") @NonNull AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		List<@NonNull OCLExpression> pivotArguments = new ArrayList<>();
		List<NavigatingArgCS> csArguments = csRoundBracketedClause.getOwnedArguments();
		List<Parameter> ownedParameters = operation.getOwnedParameters();
		int parametersCount = ownedParameters.size();
		int csArgumentCount = csArguments.size();
		if (csArgumentCount > 0) {
			if (csArguments.get(0).getRole() != NavigationRole.EXPRESSION) {
				context.addError(csNameExp, "Operation calls can only specify expressions");
			}
			for (int argIndex = 0; argIndex < csArgumentCount; argIndex++) {
				NavigatingArgCS csArgument = csArguments.get(argIndex);
				if (csArgument.getOwnedInitExpression() != null) {
					context.addError(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addError(csArgument, "Unexpected type for expression");
				}
				OCLExpression arg = PivotUtil.getPivot(OCLExpression.class, csArgument);
				if (arg != null) {
					Type argType = arg.getType();
					if (argType != null) {
						Type parameterType = ownedParameters.get(argIndex).getType();
						if (parameterType instanceof SelfType) {
							parameterType = operation.getOwningClass();
						}
						if (parameterType != null) {
							Operation asCoercion = resolveCoercionFrom(argType, parameterType);
							if (asCoercion != null) {
								arg = new PivotHelper(environmentFactory).createCoercionCallExp(arg, asCoercion);
							}
						}
					}
					pivotArguments.add(arg);
				}
			}
		}
		if ((csArgumentCount != parametersCount) && (operation != standardLibrary.basicGetOclInvalidOperation())) {
			context.addError(csNameExp, PivotMessagesInternal.MismatchedArgumentCount_ERROR_, csArgumentCount, parametersCount);
		}
		helper.refreshList(expression.getOwnedArguments(), pivotArguments);
	}

	protected void resolveOperationCall(@NonNull OperationCallExp expression, @NonNull OperatorExpCS csOperator) {
		String name = expression.getName();
		Type sourceType = PivotUtil.getType(PivotUtil.getOwnedSource(expression));
		Operation asOperation = null;
		Invocations invocations = null;
		if (!AUTOGENERATED_LOOKUP) {
			if (name != null) {
				invocations = getInvocations(sourceType, null, name, 0, expression.getOwnedArguments().size());
				if ((invocations == null) && name.startsWith("_")) {
					String unescapedName = name.substring(1);				// FIXME Compatibility
					invocations = getInvocations(sourceType, null, unescapedName, 0, expression.getOwnedArguments().size());
				}
			}

		} /*else {
			// metamodelManager.getASMetamodel();				// Ensure metamodel has been loaded
			SingleResultEnvironment env = nameResolver.computeReferredOperationLookup(expression);
			if (env.getSize() == 1) {
				asOperation = (Operation) env.getSingleResult();
				context.setReferredOperation(expression, asOperation);
				resolveOperationReturnType(expression);
			} else if (sourceType != null && env.getSize() > 1) {
				invocations = new UnresolvedInvocations(sourceType, env.getAllResults());
			}
		}*/

		if (invocations != null) {
			AbstractOperationMatcher matcher = null;
			if ((csOperator instanceof InfixExpCS) && !NavigationUtil.isNavigationInfixExp(csOperator)) {	// explicit: X op Y
				matcher = new BinaryOperationMatcher(environmentFactory, sourceType, null, ((InfixExpCS) csOperator).getArgument());
			}
			else {																	// explicit: op X, or implicit: X.oclAsSet()->
				matcher = new UnaryOperationMatcher(environmentFactory, sourceType, null);
			}

			asOperation = matcher.getBestOperation(invocations, false);
			if (asOperation != null) {
				AmbiguitiesAdapter.setAmbiguities(csOperator, matcher.getAmbiguities());
			}
			else {
				asOperation = matcher.getBestOperation(invocations, true);
			}
			context.setReferredOperation(expression, asOperation);
			resolveOperationReturnType(expression);
		}

		if (asOperation == null) {
			StringBuilder s = new StringBuilder();
			for (OCLExpression argument : PivotUtil.getOwnedArguments(expression)) {
				Type argumentType = PivotUtilInternal.getType(argument);
				if (s.length() > 0) {
					s.append(",");
				}
				s.append(argumentType.toString());
			}
			if (s.length() > 0) {
				context.addError(csOperator, PivotMessagesInternal.UnresolvedOperationCall_ERROR_, sourceType, csOperator.getName(), s.toString());
			}
			else {
				context.addError(csOperator, PivotMessagesInternal.UnresolvedOperation_ERROR_, sourceType, csOperator.getName());
			}
			//			context.addBadExpressionError(csOperator, boundMessage);
			Operation oclInvalidOperation = standardLibrary.getOclInvalidOperation();
			context.setReferredOperation(expression, oclInvalidOperation);
			//			ElementUtil.setLastPathElement(csPathName, oclInvalidOperation);
			helper.setType(expression, standardLibrary.getOclInvalidType(), false, null);
		}
	}

	protected @NonNull OperationCallExp resolveOperationCallExp(@NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull OperationCallExp operationCallExp, @NonNull Operation operation) {
		@SuppressWarnings("null")@NonNull AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		context.setReferredOperation(operationCallExp, operation);
		resolveAtPre(csNameExp, operationCallExp);
		context.installPivotUsage(csNameExp, operationCallExp);
		resolveOperationArguments(csRoundBracketedClause, operation, operationCallExp);
		resolveOperationReturnType(operationCallExp);
		return operationCallExp;
	}

	protected void resolveOperationReturnType(@NonNull CallExp callExp) {
		Operation operation = null;
		if (callExp instanceof OperationCallExp) {
			operation = ((OperationCallExp)callExp).getReferredOperation();
		}
		else if (callExp instanceof LoopExp) {
			operation = ((LoopExp)callExp).getReferredIteration();
		}
		if (operation == null) {
			return;
		}
		Type sourceType = null;
		OCLExpression source = callExp.getOwnedSource();
		if (source != null) {
			sourceType = source.getType();
		}
		TemplateParameterSubstitutions templateSubstitutions = TemplateParameterSubstitutionVisitor.createBindings(environmentFactory, sourceType, null, operation);
		@SuppressWarnings("unused")		// Should never happen; just for debugging
		boolean isConformant = true;
		if (callExp instanceof OperationCallExp) {
			List<@NonNull Parameter> parameters = PivotUtilInternal.getOwnedParametersList(operation);
			List<@NonNull OCLExpression> arguments = PivotUtilInternal.getOwnedArgumentsList((OperationCallExp)callExp);
			int iMax = Math.min(parameters.size(), arguments.size());
			for (int i = 0; i < iMax; i++) {
				Parameter parameter = parameters.get(i);
				OCLExpression argument = arguments.get(i);
				Type parameterType = PivotUtilInternal.getType(parameter);
				Type argumentType = PivotUtilInternal.getType(argument);
				if (!metamodelManager.conformsTo(argumentType, TemplateParameterSubstitutions.EMPTY, parameterType, templateSubstitutions)) {
					isConformant = false;
				}
			}
		}
		else if (callExp instanceof LoopExp) {
			if (callExp instanceof IterateExp) {
				List<@NonNull Parameter> accumulators = PivotUtilInternal.getOwnedAccumulatorsList(((Iteration)operation));
				if (accumulators.size() >= 1) {
					Parameter accumulator = accumulators.get(0);
					Variable result = PivotUtil.getOwnedResult((IterateExp)callExp);
					Type accumulatorType = PivotUtilInternal.getType(accumulator);
					Type resultType = PivotUtilInternal.getType(result);
					if (!metamodelManager.conformsTo(resultType, TemplateParameterSubstitutions.EMPTY, accumulatorType, templateSubstitutions)) {
						isConformant = false;
					}
				}
			}
			List<@NonNull Parameter> parameters = PivotUtilInternal.getOwnedParametersList(operation);
			if (parameters.size() >= 1) {
				Parameter parameter = parameters.get(0);
				OCLExpression body = PivotUtil.getOwnedBody((LoopExp)callExp);
				Type parameterType = PivotUtilInternal.getType(parameter);
				Type bodyType = PivotUtilInternal.getType(body);
				if (!metamodelManager.conformsTo(bodyType, TemplateParameterSubstitutions.EMPTY, parameterType, templateSubstitutions)) {
					isConformant = false;
				}
			}
		}
		helper.setOperationReturnType(callExp, operation);
	}

	protected @NonNull CallExp resolvePropertyCallExp(@NonNull OCLExpression sourceExp, @NonNull NameExpCS csNameExp, @NonNull Property property) {
		NavigationCallExp callExp;
		if (property.isIsImplicit()) {
			callExp = refreshOppositePropertyCallExp(csNameExp, sourceExp, property);
		}
		else {
			callExp = refreshPropertyCallExp(csNameExp, sourceExp, property);
		}
		//		if (isInvalidType(property.getType())) {
		//			EssentialOCLUtils.setHasError(csNameExp);
		//		}
		resolveAtPre(csNameExp, callExp);
		Type returnType = resolvePropertyReturnType(callExp, csNameExp, property);
		helper.setType(callExp, returnType, property.isIsRequired() && !callExp.isIsSafe(), null);
		return callExp;
	}

	protected @Nullable Type resolvePropertyReturnType(@NonNull NavigationCallExp callExp, @NonNull NameExpCS csNameExp, @NonNull Property property) {
		Type formalType = property.getType();
		if (formalType == null) {
			return null;
		}
		OCLExpression source = callExp.getOwnedSource();
		Type actualType;
		Type sourceType = source != null ? source.getType() : null;
		if (sourceType != null) {
			actualType = metamodelManager.specializeType(formalType, callExp, sourceType, null);
		}
		else {
			actualType = formalType;
		}
		if (property.isIsStatic() && (actualType.isTemplateParameter() != null)) {
		//	actualType = metamodelManager.getMetaclass(actualType);
			actualType = standardLibrary.getClassType();   //getASClass("TemplateParameter");	// BUG 496810#c8 review once static functionality fixed
		}
		return actualType;
	}

	protected Element resolveRoundBracketedTerm(@NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		OperatorExpCS csParent = csNameExp.getLocalParent();
		if (NavigationUtil.isNavigationInfixExp(csParent) && (csParent != null) && (csNameExp != ((InfixExpCS)csParent).getSource())) {
			// source.name(), source->name() are resolved by the parent NavigationOperatorCS
			return PivotUtil.getPivot(OCLExpression.class, csNameExp);
		}
		return resolveInvocation(null, csRoundBracketedClause);
	}

	protected @Nullable OCLExpression resolveShadowExp(@NonNull NameExpCS csNameExp) {
		PathNameCS pathName = csNameExp.getOwnedPathName();
		if (pathName == null) {
			return null;
		}
		CurlyBracketedClauseCS csCurlyBracketedClause = csNameExp.getOwnedCurlyBracketedClause();
		RoundBracketedClauseCS csRoundBracketedClause = csNameExp.getOwnedRoundBracketedClause();
		if (csRoundBracketedClause != null) {
			// FIXME (TemplateTypeArgument)
			return context.addBadExpressionError(csNameExp, "ShadowExp must have no round-brackets-clause");
		}
		if (csNameExp.getOwnedSquareBracketedClauses().size() != 0) {
			return context.addBadExpressionError(csNameExp, "ShadowExp must have no square-brackets-clause");
		}
		Type asType = context.lookupType(csNameExp, pathName);
		@NonNull ShadowExp pivotElement = context.refreshModelElement(ShadowExp.class, PivotPackage.Literals.SHADOW_EXP, csNameExp);
		pivotElement.setType(asType);
		for (ShadowPartCS csPart : csCurlyBracketedClause.getOwnedParts()) {
			assert csPart != null;
			context.visitLeft2Right(ShadowPart.class, csPart);
		}
		context.refreshPivotList(ShadowPart.class, pivotElement.getOwnedParts(), csCurlyBracketedClause.getOwnedParts());
		return pivotElement;
	}

	protected Element resolveSimpleNameExp(@NonNull NameExpCS csNameExp, @NonNull Element element) {
		if (element instanceof VariableDeclaration) {
			return resolveVariableExp(csNameExp, (VariableDeclaration)element);
		}
		else if (element instanceof Property) {
			Property property = (Property) element;
			OCLExpression sourceExp = createImplicitSourceVariableExp(csNameExp, property.getOwningClass());
			return resolvePropertyCallExp(sourceExp, csNameExp, property);
		}
		else if (element instanceof Operation) {
			return context.addBadExpressionError(csNameExp, "No parameters for operation " + ((Operation)element).getName());
		}
		else if (element instanceof Type) {
			return resolveTypeExp(csNameExp, (Type) element);
		}
		else if (element instanceof EnumerationLiteral) {
			return resolveEnumLiteral(csNameExp, (EnumerationLiteral) element);
		}
		else if (element instanceof State) {
			return resolveStateExp(csNameExp, (State) element);
		}
		else {
			return context.addBadExpressionError(csNameExp, "Unsupported NameExpCS " + element.eClass().getName());		// FIXME
		}
	}

	protected StateExp resolveStateExp(@NonNull ExpCS csExp, @NonNull State state) {
		StateExp expression = context.refreshModelElement(StateExp.class, PivotPackage.Literals.STATE_EXP, csExp);
		helper.setType(expression, environmentFactory.getASClass("State"), true, null);		// FIXME What should this be
		expression.setReferredState(state);
		expression.setName(state.getName());
		return expression;
	}

	protected @NonNull TypeExp resolveTypeExp(@NonNull ExpCS csExp, @NonNull Type type) {		// FIXME Class
		assert type instanceof org.eclipse.ocl.pivot.Class;		// Not TemplateParameter
		TypeExp expression = context.refreshModelElement(TypeExp.class, PivotPackage.Literals.TYPE_EXP, csExp);
		Type asType = standardLibrary.getMetaclass(type);
		helper.setType(expression, asType, true, type);
		expression.setReferredType(type);
		expression.setName(type.getName());
		return expression;
	}

	protected @NonNull VariableExp resolveVariableExp(@NonNull NameExpCS csNameExp, @NonNull VariableDeclaration variableDeclaration) {
		VariableExp expression = context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csNameExp);
		expression.setReferredVariable(variableDeclaration);
		expression.setName(variableDeclaration.getName());
		helper.setType(expression, variableDeclaration.getType(), variableDeclaration.isIsRequired(), variableDeclaration.getTypeValue());
		return expression;
	}

	@Override
	public Element visitBooleanLiteralExpCS(@NonNull BooleanLiteralExpCS csBooleanLiteralExp) {
		BooleanLiteralExp expression = PivotUtil.getPivot(BooleanLiteralExp.class, csBooleanLiteralExp);
		if (expression != null) {
			expression.setBooleanSymbol(Boolean.valueOf(csBooleanLiteralExp.getSymbol()));
			helper.setType(expression, standardLibrary.getBooleanType(), true, null);
		}
		return expression;
	}

	@Override
	public Element visitCollectionLiteralExpCS(@NonNull CollectionLiteralExpCS csCollectionLiteralExp) {
		Type commonType = null;
		//		InvalidLiteralExp invalidValue = null;
		boolean isNullFree = true;
		for (CollectionLiteralPartCS csPart : csCollectionLiteralExp.getOwnedParts()) {
			assert csPart != null;
			CollectionLiteralPart pivotPart = context.visitLeft2Right(CollectionLiteralPart.class, csPart);
			Type asType = pivotPart != null ? pivotPart.getType() : null;
			Type type = asType;// != null ? PivotUtil.getBehavioralType(asType) : null;
			//			if (type instanceof InvalidType) {	// FIXME Use propagated reason via InvalidType
			//				if (invalidValue == null) {
			//					invalidValue = metamodelManager.createInvalidValue(csPart, null, "Invalid Collection content", null);
			//				}
			//			}
			//			else
			if (type != null) {
				if (commonType == null) {
					commonType = type;
				}
				else if (commonType != type) {
					commonType = metamodelManager.getCommonType(commonType, TemplateParameterSubstitutions.EMPTY, type, TemplateParameterSubstitutions.EMPTY);
				}
			}
			if (pivotPart instanceof CollectionItem) {
				if ((((CollectionItem)pivotPart).getOwnedItem() instanceof NullLiteralExp)) {
					isNullFree = false;
				}
			}
			else if (pivotPart instanceof CollectionRange) {
				;
			}
			else {
				isNullFree = false;
			}
		}
		//		if (invalidValue != null) {
		//			context.installPivotElement(csCollectionLiteralExp, invalidValue);
		//			return invalidValue;
		//		}
		CollectionLiteralExp expression = PivotUtil.getPivot(CollectionLiteralExp.class, csCollectionLiteralExp);
		if (expression != null) {
			CollectionTypeCS ownedCollectionType = csCollectionLiteralExp.getOwnedType();
			String collectionTypeName = ownedCollectionType.getName();
			assert collectionTypeName != null;
			TypedRefCS ownedElementType = ownedCollectionType.getOwnedType();
			if (ownedElementType != null) {
				commonType = (Type) ownedElementType.getPivot();
			}
			if (commonType == null) {
				commonType = standardLibrary.getOclVoidType();
			}
			Type type = metamodelManager.getCollectionType(collectionTypeName, commonType, isNullFree, null, null);
			helper.setType(expression, type, true, null);
			expression.setKind(TypeUtil.getCollectionKind((CollectionType) type));
		}
		return expression;
	}

	@Override
	public Element visitCollectionLiteralPartCS(@NonNull CollectionLiteralPartCS csCollectionLiteralPart) {
		ExpCS csFirst = csCollectionLiteralPart.getOwnedExpression();
		if (csFirst == null) {
			return null;
		}
		OCLExpression pivotFirst = context.visitLeft2Right(OCLExpression.class, csFirst);
		OCLExpression pivotLast = null;
		ExpCS csLast = csCollectionLiteralPart.getOwnedLastExpression();
		if (csLast == null) {
			CollectionItem expression = PivotUtil.getPivot(CollectionItem.class, csCollectionLiteralPart);
			if (expression != null) {
				expression.setOwnedItem(pivotFirst);
			}
		}
		else {
			CollectionRange expression = PivotUtil.getPivot(CollectionRange.class, csCollectionLiteralPart);
			if (expression != null) {
				expression.setOwnedFirst(pivotFirst);
				pivotLast = context.visitLeft2Right(OCLExpression.class, csLast);
				expression.setOwnedLast(pivotLast);
			}
		}
		if (pivotFirst == null) {
			return null;
		}
		Type type = pivotFirst.getType();
		if (type == null) {
			return null;
		}
		boolean isRequired = pivotFirst.isIsRequired();
		if (pivotLast != null) {
			Type secondType = pivotLast.getType();
			if (secondType != null) {
				type = metamodelManager.getCommonType(type, TemplateParameterSubstitutions.EMPTY, secondType, TemplateParameterSubstitutions.EMPTY);
			}
			isRequired &= pivotLast.isIsRequired();
		}
		CollectionLiteralPart expression = PivotUtil.getPivot(CollectionLiteralPart.class, csCollectionLiteralPart);
		if (expression != null) {
			helper.setType(expression, type, isRequired);
		}
		return expression;
	}

	@Override
	public Element visitCollectionTypeCS(@NonNull CollectionTypeCS object) {
		return null;
	}

	@Override
	public Element visitContextCS(@NonNull ContextCS csContext) {
		ExpressionInOCL pivotElement = PivotUtil.getPivot(ExpressionInOCL.class, csContext);
		if (pivotElement != null) {
			ExpCS csExpression = csContext.getOwnedExpression();
			if (csExpression != null) {
				String bodyText = ElementUtil.getRawText(csExpression);
				pivotElement.setBody(bodyText);
				OCLExpression expression = context.visitLeft2Right(OCLExpression.class, csExpression);
				if (expression != null) {
					PivotUtil.setBody(pivotElement, expression, bodyText);
					helper.setType(pivotElement, expression.getType(), expression.isIsRequired());
				}
			}
			else {
				pivotElement.setBody(null);
			}
		}
		return pivotElement;
	}

	@Override
	public Element visitExpCS(@NonNull ExpCS object) {
		return null;
	}

	@Override
	public Element visitIfExpCS(@NonNull IfExpCS csIfExp) {
		IfExp ifExpression = PivotUtil.getPivot(IfExp.class, csIfExp);
		ExpCS csElse = csIfExp.getOwnedElseExpression();
		if ((ifExpression != null) && (csElse != null)) {
			OCLExpression elseExpression = context.visitLeft2Right(OCLExpression.class, csElse);
			List<IfThenExpCS> csIfThens = csIfExp.getOwnedIfThenExpressions();
			for (int i = csIfThens.size(); --i >= 0; ) {
				IfThenExpCS csIfThen = csIfThens.get(i);
				IfExp elseIfExpression = PivotUtil.getPivot(IfExp.class, csIfThen);
				if (elseIfExpression != null) {
					elseExpression = doIfThenElse(elseIfExpression, csIfThen.getOwnedCondition(), csIfThen.getOwnedThenExpression(), elseExpression);
				}
			}
			doIfThenElse(ifExpression, csIfExp.getOwnedCondition(), csIfExp.getOwnedThenExpression(), elseExpression);
		}
		return ifExpression;
	}

	@Override
	public Element visitInfixExpCS(@NonNull InfixExpCS csInfixExp) {
		//
		//	If this is a new Operation tree start at its root.
		//
		OperatorExpCS csRoot = getRoot(csInfixExp);
		if (csRoot != currentRoot) {
			OperatorExpCS savedCurrentRoot = currentRoot;
			try {
				currentRoot = csRoot;
				OCLExpression pivot = context.visitLeft2Right(OCLExpression.class, csRoot);
				assert csRoot.getPivot() == pivot;
				return pivot;
			}
			finally {
				currentRoot = savedCurrentRoot;
			}
		}
		OCLExpression pivot;
		if (NavigationUtil.isNavigationInfixExp(csInfixExp)) {
			pivot = doVisitNavigationOperatorCS(csInfixExp);
		}
		else {
			pivot = doVisitBinaryOperatorCS(csInfixExp);
		}
		assert csInfixExp.getPivot() == pivot;
		//		if (pivot != null) {
		//			context.installPivotUsage(csInfixExp, pivot);
		//		}
		return pivot;
	}

	protected @NonNull OCLExpression doIfThenElse(@NonNull IfExp expression, @Nullable ExpCS csCondition, @Nullable ExpCS csThen, @Nullable OCLExpression elseExpression) {
		if ((csCondition != null) && (csThen != null)) {
			expression.setOwnedCondition(context.visitLeft2Right(OCLExpression.class, csCondition));
			OCLExpression thenExpression = context.visitLeft2Right(OCLExpression.class, csThen);
			Type thenType = thenExpression != null ? thenExpression.getType() : null;
			Type elseType = elseExpression != null ? elseExpression.getType() : null;
			Type commonType = null;
			if ((thenType != null) && (elseType != null)) {
				commonType = metamodelManager.getCommonType(thenType, TemplateParameterSubstitutions.EMPTY, elseType, TemplateParameterSubstitutions.EMPTY);
				if ((commonType != thenType) && (commonType != elseType)) {
					PrimitiveType integerType = standardLibrary.getIntegerType();
					Operation asCoercion = NameUtil.getNameable(integerType.getOwnedOperations(), "toUnlimitedNatural");
					if (asCoercion != null) {
						PrimitiveType unlimitedNaturalType = standardLibrary.getUnlimitedNaturalType();
						if (thenType.conformsTo(standardLibrary, unlimitedNaturalType)) {
							if (elseType.conformsTo(standardLibrary, integerType)) {
								assert elseExpression != null;
								elseExpression = new PivotHelper(environmentFactory).createCoercionCallExp(elseExpression, asCoercion);
								commonType = unlimitedNaturalType;
							}
						}
						else if (elseType.conformsTo(standardLibrary, unlimitedNaturalType)) {
							if (thenType.conformsTo(standardLibrary, integerType)) {
								assert thenExpression != null;
								thenExpression = new PivotHelper(environmentFactory).createCoercionCallExp(thenExpression, asCoercion);
								commonType = unlimitedNaturalType;
							}
						}
					}
				}
			}
			expression.setOwnedThen(thenExpression);
			expression.setOwnedElse(elseExpression);
			Type thenTypeValue = thenExpression != null ? thenExpression.getTypeValue() : null;
			Type elseTypeValue = elseExpression != null ? elseExpression.getTypeValue() : null;
			Type commonTypeValue = (thenTypeValue != null) && (elseTypeValue != null) ? metamodelManager.getCommonType(thenTypeValue, TemplateParameterSubstitutions.EMPTY, elseTypeValue, TemplateParameterSubstitutions.EMPTY) : null;
			boolean isRequired = ((thenExpression != null) && thenExpression.isIsRequired()) && ((elseExpression != null) && elseExpression.isIsRequired());
			helper.setType(expression, commonType, isRequired, commonTypeValue);
		}
		return expression;
	}

	protected @NonNull OCLExpression doVisitBinaryOperatorCS(@NonNull InfixExpCS csOperator) {
		OperationCallExp expression = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csOperator);
		String name = csOperator.getName();
		assert name != null;
		helper.refreshName(expression, name);
		ExpCS csSource = csOperator.getSource();
		if (csSource != null) {
			OCLExpression source = context.visitLeft2Right(OCLExpression.class, csSource);
			expression.setOwnedSource(source);
			ExpCS csArgument = csOperator.getArgument();
			if (csArgument != null) {
				OCLExpression argument = context.visitLeft2Right(OCLExpression.class, csArgument);
				List<? extends OCLExpression> newElements = argument != null ? Collections.singletonList(argument) : Collections.<OCLExpression>emptyList();
				helper.refreshList(expression.getOwnedArguments(), newElements);
				Type sourceType = source != null ? PivotUtilInternal.getType(source) : null;
				Type argumentType = argument != null ? PivotUtilInternal.getType(argument) : null;
				if ((sourceType != null) && (argumentType != null)) {
					resolveOperationCall(expression, csOperator);
				}
			}
		}
		return expression;
	}

	protected OCLExpression doVisitNavigationOperatorCS(@NonNull InfixExpCS csOperator) {
		OCLExpression navigatingExp = null;
		ExpCS csSource = csOperator.getSource();
		if (csSource != null) {
			OCLExpression sourceExp = context.visitLeft2Right(OCLExpression.class, csSource);
			if (sourceExp != null) {
				Type asType = sourceExp.getType();
				Type actualSourceType = asType;// != null ? PivotUtil.getBehavioralType(asType) : null;
				if (actualSourceType != null) {
					ExpCS argument = csOperator.getArgument();
					if (argument instanceof NameExpCS) {
						NameExpCS csNameExp = (NameExpCS) argument;
						LoopExp implicitCollectExp = null;
						OCLExpression collectedSourceExp = sourceExp;
						//
						//	Condition the source for implicit set or implicit collect
						//
						String navigationOperatorName = csOperator.getName();
						boolean isAggregate = PivotUtil.isAggregate(actualSourceType);
						if (isAggregate) {
							if (PivotUtil.isObjectNavigationOperator(navigationOperatorName)) {
								implicitCollectExp = resolveImplicitCollect(sourceExp, csOperator);
								if (implicitCollectExp != null) {
									@SuppressWarnings("null")@NonNull Variable iterator = implicitCollectExp.getOwnedIterators().get(0);
									collectedSourceExp = createImplicitVariableExp(iterator);
								}
							}
						}
						else {
							if (PivotUtil.isAggregateNavigationOperator(navigationOperatorName)) {
								collectedSourceExp = resolveImplicitAsSet(sourceExp, actualSourceType, csOperator);
							}
						}
						Type sourceType = collectedSourceExp.getType();
						csNameExp.setSourceType(sourceType);
						csNameExp.setSourceTypeValue(collectedSourceExp.getTypeValue());
						//
						//	Resolve the inner call expression
						//
						OCLExpression callExp;
						RoundBracketedClauseCS csRoundBracketedClause = csNameExp.getOwnedRoundBracketedClause();
						if (csRoundBracketedClause != null) {
							callExp = resolveInvocation(collectedSourceExp, csRoundBracketedClause);
						}
						else if (argument instanceof NameExpCS) {
							callExp = resolveExplicitSourceNavigation(collectedSourceExp, (NameExpCS) argument);
						}
						else {
							callExp = context.addBadExpressionError(argument, "bad navigation argument");
						}
						//
						//	Complete the wrapping of the inner call expression in an outer implicit collect expression
						//
						if (callExp instanceof CallExp) {
							boolean isSafe = PivotUtil.isSafeNavigationOperator(navigationOperatorName);
							//							((CallExp) callExp).setIsSafe(isSafe && (implicitCollectExp == null));
							//							if (isSafe) {
							//								callExp.setIsRequired(true);		// FIXME Why?
							//							}
							if (implicitCollectExp != null) {
								implicitCollectExp.setOwnedBody(callExp);
								resolveOperationReturnType(implicitCollectExp);
								navigatingExp = implicitCollectExp;
							}
							else {
								((CallExp) callExp).setIsSafe(isSafe);
								if (isSafe && !isAggregate) {
									callExp.setIsRequired(isAggregate);
								}
								navigatingExp = callExp;
							}
						}
						else {
							navigatingExp = callExp;		// Place holder for an error
						}
					}
					else if (argument != null) {
						navigatingExp = context.addBadExpressionError(argument, "bad navigation argument");
					}
				}
			}
			if (navigatingExp != null) {
				context.installPivotUsage(csOperator, navigatingExp);
			}
		}
		return navigatingExp;
	}

	@Override
	public Element visitInvalidLiteralExpCS(@NonNull InvalidLiteralExpCS csInvalidLiteralExp) {
		InvalidLiteralExp expression = PivotUtil.getPivot(InvalidLiteralExp.class, csInvalidLiteralExp);
		if (expression == null) {
			expression = metamodelManager.createInvalidExpression();
		}
		//		expression.setType(metamodelManager.getOclInvalidType());
		context.installPivotUsage(csInvalidLiteralExp, expression);
		return expression;
	}

	@Override
	public Element visitLetExpCS(@NonNull LetExpCS csLetExp) {
		// Each CS Let Variable becomes a Pivot LetExpression and Variable
		// The CS Let therefore just re-uses the Pivot of the first CS Let Variable
		LetExp firstLetExp = null;
		LetExp lastLetExp = null;
		for (LetVariableCS csLetVariable : csLetExp.getOwnedVariables()) {
			LetVariable variable = PivotUtil.getPivot(LetVariable.class, csLetVariable);
			if (variable != null) {
				LetExp letExp;
				EObject variableContainer = variable.eContainer();
				if (variableContainer instanceof LetExp) {
					letExp = (LetExp)variableContainer;
				}
				else {
					letExp = context.refreshModelElement(LetExp.class, PivotPackage.Literals.LET_EXP, null); // FIXME reuse
				}
				letExp.setOwnedVariable(variable);
				ExpCS csInitExpression = csLetVariable.getOwnedInitExpression();
				if (csInitExpression != null) {
					TypedRefCS csVariableType = csLetVariable.getOwnedType();
					Boolean variableIsRequired = null;
					Type variableType = null;
					if (csVariableType != null) {
						variableType = PivotUtil.getPivot(Type.class, csVariableType);
						variableIsRequired = context.isRequired(csVariableType);
					}
					boolean initIsRequired = false;
					OCLExpression initExpression = context.visitLeft2Right(OCLExpression.class, csInitExpression);
					Type initType = null;
					Type initTypeValue = null;
					if (initExpression != null) {
						initType = initExpression.getType();
						initTypeValue = initExpression.getTypeValue();
						initIsRequired = initExpression.isIsRequired();
						if ((initType != null) && (variableType != null)) {
							Operation asCoercion = resolveCoercionFrom(initType, variableType);
							if (asCoercion != null) {
								initExpression = new PivotHelper(environmentFactory).createCoercionCallExp(initExpression, asCoercion);
							}
						}
					}
					variable.setOwnedInit(initExpression);
					if (variableType == null) {
						variableType = initType;
					}
					boolean isRequired = variableIsRequired != null ? variableIsRequired.booleanValue() : initIsRequired;
					helper.setType(variable, variableType, isRequired, initTypeValue);
					if (lastLetExp != null) {
						lastLetExp.setOwnedIn(letExp);
						context.installPivotUsage(csLetExp, letExp);
					}
					else {
						firstLetExp = letExp;
						context.installPivotUsage(csLetExp, firstLetExp);
					}
					lastLetExp = letExp;
				}
			}
		}
		if (lastLetExp != null) {
			ExpCS csIn = csLetExp.getOwnedInExpression();
			if (csIn != null) {
				OCLExpression in = context.visitLeft2Right(OCLExpression.class, csIn);
				lastLetExp.setOwnedIn(in);
				if (in != null) {
					Type type = in.getType();
					for (OCLExpression letExp = firstLetExp; (letExp != in) && (letExp != null); letExp = ((LetExp)letExp).getOwnedIn()) {
						helper.setType(letExp, type, in.isIsRequired(), in.getTypeValue());
					}
				}
			}
		}
		return firstLetExp;
	}

	@Override
	public Element visitLetVariableCS(@NonNull LetVariableCS csLetVariable) {
		return null;	// Handled by parent
	}

	@Override
	public Element visitMapLiteralExpCS(@NonNull MapLiteralExpCS csMapLiteralExp) {
		Type keyType = null;
		Type valueType = null;
		Boolean keysAreNullFree = null;
		Boolean valuesAreNullFree = null;
		MapTypeCS csMapType = csMapLiteralExp.getOwnedType();
		if (csMapType != null) {
			TypedRefCS csKeyType = csMapType.getOwnedKeyType();
			if (csKeyType != null) {
				keyType = (Type) csKeyType.getPivot();
				keysAreNullFree = context.isRequired(csKeyType);
			}
			TypedRefCS csValueType = csMapType.getOwnedValueType();
			if (csValueType != null) {
				valueType = (Type) csValueType.getPivot();
				valuesAreNullFree = context.isRequired(csValueType);
			}
		}
		boolean inferKeyType = keyType == null;
		boolean inferValueType = valueType == null;
		for (MapLiteralPartCS csPart : csMapLiteralExp.getOwnedParts()) {
			assert csPart != null;
			MapLiteralPart pivotPart = context.visitLeft2Right(MapLiteralPart.class, csPart);
			if (pivotPart != null) {
				if (inferKeyType) {
					OCLExpression asKey = pivotPart.getOwnedKey();
					if (asKey != null) {
						if (asKey instanceof NullLiteralExp) {
							keysAreNullFree = false;
						}
						@SuppressWarnings("deprecation")
						FlowAnalysis flowAnalysis = FlowAnalysis.getFlowAnalysis(environmentFactory, asKey);
						if (!flowAnalysis.isNonNull(asKey)) {
							keysAreNullFree = false;
						}
						Type asKeyType = asKey.getType();
						if (asKeyType != null) {
							if (keyType == null) {
								keyType = asKeyType;
							}
							else if (keyType != asKeyType) {
								keyType = metamodelManager.getCommonType(keyType, TemplateParameterSubstitutions.EMPTY, asKeyType, TemplateParameterSubstitutions.EMPTY);
							}
						}
					}
				}
				if (inferValueType) {
					OCLExpression asValue = pivotPart.getOwnedValue();
					if (asValue != null) {
						if (asValue instanceof NullLiteralExp) {
							valuesAreNullFree = false;
						}
						@SuppressWarnings("deprecation")
						FlowAnalysis flowAnalysis = FlowAnalysis.getFlowAnalysis(environmentFactory, asValue);
						if (!flowAnalysis.isNonNull(asValue)) {
							valuesAreNullFree = false;
						}
						Type asValueType = asValue.getType();
						if (asValueType != null) {
							if (valueType == null) {
								valueType = asValueType;
							}
							else if (valueType != asValueType) {
								valueType = metamodelManager.getCommonType(valueType, TemplateParameterSubstitutions.EMPTY, asValueType, TemplateParameterSubstitutions.EMPTY);
							}
						}
					}
				}
			}
		}
		MapLiteralExp expression = PivotUtil.getPivot(MapLiteralExp.class, csMapLiteralExp);
		if (expression != null) {
			MapTypeCS ownedMapType = csMapLiteralExp.getOwnedType();
			String mapTypeName = ownedMapType.getName();
			assert mapTypeName != null;
			if (keyType == null) {
				keyType = standardLibrary.getOclVoidType();
				keysAreNullFree = true;
			}
			else if (inferKeyType && (keysAreNullFree == null)) {
				keysAreNullFree = true;
			}
			if (valueType == null) {
				valueType = standardLibrary.getOclVoidType();
				valuesAreNullFree = true;
			}
			else if (inferValueType && (valuesAreNullFree == null)) {
				valuesAreNullFree = true;
			}
			Type type = metamodelManager.getMapType(mapTypeName, keyType, keysAreNullFree != Boolean.FALSE, valueType, valuesAreNullFree != Boolean.FALSE);
			helper.setType(expression, type, true, null);
		}
		return expression;
	}

	@Override
	public Element visitMapLiteralPartCS(@NonNull MapLiteralPartCS csMapLiteralPart) {
		ExpCS csKey = csMapLiteralPart.getOwnedKey();
		ExpCS csValue = csMapLiteralPart.getOwnedValue();
		if ((csKey == null) || (csValue == null)) {
			return null;
		}
		OCLExpression asKey = context.visitLeft2Right(OCLExpression.class, csKey);
		OCLExpression asValue = context.visitLeft2Right(OCLExpression.class, csValue);
		MapLiteralPart expression = PivotUtil.getPivot(MapLiteralPart.class, csMapLiteralPart);
		if (expression != null) {
			expression.setOwnedKey(asKey);
			expression.setOwnedValue(asValue);
		}
		return expression;
	}

	@Override
	public Element visitMapTypeCS(@NonNull MapTypeCS object) {
		return null;
	}

	@Override
	public Element visitNameExpCS(@NonNull NameExpCS csNameExp) {
		PathNameCS csPathName = csNameExp.getOwnedPathName();
		if (csPathName == null) {
			return context.addBadExpressionError(csNameExp, "Missing path name");
		}
		RoundBracketedClauseCS csRoundBracketedClause = csNameExp.getOwnedRoundBracketedClause();
		if (csNameExp.getOwnedCurlyBracketedClause() != null) {
			return resolveShadowExp(csNameExp);
		}
		else if (isAssociationClassCallExp(csNameExp)) {
			return resolveAssociationClassCallExp(csNameExp);
		}
		else if (csRoundBracketedClause != null) {
			return resolveRoundBracketedTerm(csRoundBracketedClause);
		}
		checkForInvalidImplicitSourceType(csNameExp);
		//		csNameExp.getPathName().get
		Element element = context.lookupUndecoratedName(csNameExp, csPathName);
		if ((element == null) || element.eIsProxy()) {
			Element pivot = csNameExp.getPivot();
			if (pivot instanceof InvalidLiteralExp) {
				return pivot;
			}
			InvalidLiteralExp invalidLiteralExp = metamodelManager.createInvalidExpression();
			context.installPivotUsage(csNameExp, invalidLiteralExp);
			return invalidLiteralExp;
		}
		return resolveSimpleNameExp(csNameExp, element);
	}

	@Override
	public Element visitNavigatingArgCS(@NonNull NavigatingArgCS csNavigatingArg) {
		OCLExpression pivot = PivotUtil.getPivot(OCLExpression.class, csNavigatingArg);
		if (pivot != null) {
			context.installPivotUsage(csNavigatingArg, pivot);
		}
		return pivot;
	}

	@Override
	public Element visitNestedExpCS(@NonNull NestedExpCS csNestedExp) {
		ExpCS csSource = csNestedExp.getOwnedExpression();
		if (csSource == null) {
			return null;
		}
		OCLExpression pivot = context.visitLeft2Right(OCLExpression.class, csSource);
		if (pivot != null) {
			context.installPivotUsage(csNestedExp, pivot);
		}
		return pivot;
	}

	@Override
	public Element visitNullLiteralExpCS(@NonNull NullLiteralExpCS csNullLiteralExp) {
		NullLiteralExp expression = PivotUtil.getPivot(NullLiteralExp.class, csNullLiteralExp);
		if (expression != null) {
			helper.setType(expression, standardLibrary.getOclVoidType(), false, null);
		}
		return expression;
	}

	@Override
	public Element visitNumberLiteralExpCS(@NonNull NumberLiteralExpCS csNumberLiteralExp) {
		NumericLiteralExp expression = PivotUtil.getPivot(NumericLiteralExp.class, csNumberLiteralExp);
		if (expression instanceof UnlimitedNaturalLiteralExp) {
			helper.setType(expression, standardLibrary.getUnlimitedNaturalType(), true, null);
		}
		else if (expression instanceof IntegerLiteralExp) {
			helper.setType(expression, standardLibrary.getIntegerType(), true, null);
		}
		else if (expression != null){
			helper.setType(expression, standardLibrary.getRealType(), true, null);
		}
		return expression;
	}

	@Override
	public Element visitPrefixExpCS(@NonNull PrefixExpCS csPrefixExp) {
		//
		//	If this is a new Operation tree start at its root.
		//
		OperatorExpCS csRoot = getRoot(csPrefixExp);
		if (csRoot != currentRoot) {
			OperatorExpCS savedCurrentRoot = currentRoot;
			try {
				currentRoot = csRoot;
				OCLExpression pivot = context.visitLeft2Right(OCLExpression.class, csRoot);
				assert csRoot.getPivot() == pivot;
				return pivot;
			}
			finally {
				currentRoot = savedCurrentRoot;
			}
		}
		OperationCallExp asCallExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csPrefixExp);
		helper.refreshName(asCallExp, csPrefixExp.getName());
		ExpCS csSource = csPrefixExp.getSource();
		if (csSource != null) {
			OCLExpression source = context.visitLeft2Right(OCLExpression.class, csSource);
			if (source != null) {
				asCallExp.setOwnedSource(source);
				resolveOperationCall(asCallExp, csPrefixExp);
			}
		}
		assert csPrefixExp.getPivot() == asCallExp;
		return asCallExp;
	}

	@Override
	public Element visitSelfExpCS(@NonNull SelfExpCS csSelfExp) {	// FIXME Just use VariableExpCS
		VariableExp expression = PivotUtil.getPivot(VariableExp.class, csSelfExp);
		if (expression != null) {
			ElementCS parent = csSelfExp.getParent();
			if (parent != null) {
				VariableDeclaration variableDeclaration = context.getConverter().lookupSelf(parent);
				if (variableDeclaration == null) {
					return context.addBadExpressionError(csSelfExp, PivotMessages.UnspecifiedSelfContext);
				}
				expression.setReferredVariable(variableDeclaration);
				expression.setName(variableDeclaration.getName());
				helper.setType(expression, variableDeclaration.getType(), true, variableDeclaration.getTypeValue());
			}
		}
		return expression;
	}

	@Override
	public Element visitShadowPartCS(@NonNull ShadowPartCS csShadowPart) {
		ShadowPart pivotElement = PivotUtil.getPivot(ShadowPart.class, csShadowPart);
		if (pivotElement != null) {
			Property property = csShadowPart.getReferredProperty();
			if (property == null) {
				property = new PivotHelper(environmentFactory).getDataTypeValueProperty();
			}
			pivotElement.setReferredProperty(property);
			helper.refreshName(pivotElement, property.getName());
			helper.setType(pivotElement, property.getType(), property.isIsRequired());
			ExpCS csInitExpression = csShadowPart.getOwnedInitExpression();
			if (csInitExpression != null) {
				OCLExpression initExpression = context.visitLeft2Right(OCLExpression.class, csInitExpression);
				pivotElement.setOwnedInit(initExpression);
			}
		}
		return pivotElement;
	}

	@Override
	public Element visitStringLiteralExpCS(@NonNull StringLiteralExpCS csStringLiteralExp) {
		StringLiteralExp pivotElement = PivotUtil.getPivot(StringLiteralExp.class, csStringLiteralExp);
		if (pivotElement != null) {
			helper.setType(pivotElement, standardLibrary.getStringType(), true, null);
		}
		return pivotElement;
	}

	@Override
	public Element visitTupleLiteralExpCS(@NonNull TupleLiteralExpCS csTupleLiteralExp) {
		TupleLiteralExp expression = PivotUtil.getPivot(TupleLiteralExp.class, csTupleLiteralExp);
		if (expression != null) {
			for (TupleLiteralPartCS csPart : csTupleLiteralExp.getOwnedParts()) {
				assert csPart != null;
				context.visitLeft2Right(TupleLiteralPart.class, csPart);
			}
			String tupleTypeName = "Tuple"; //ownedCollectionType.getName();
			List<@NonNull TupleLiteralPart> parts = ClassUtil.nullFree(expression.getOwnedParts());
			assert parts != null;
			Type type = standardLibrary.getCompleteModel().getTupleType(tupleTypeName, parts, null);
			helper.setType(expression, type, true, null);
		}
		return expression;
	}

	@Override
	public Element visitTupleLiteralPartCS(@NonNull TupleLiteralPartCS csTupleLiteralPart) {
		TupleLiteralPart pivotElement = PivotUtil.getPivot(TupleLiteralPart.class, csTupleLiteralPart);
		if (pivotElement != null) {
			ExpCS csInitExpression = csTupleLiteralPart.getOwnedInitExpression();
			if (csInitExpression != null) {
				OCLExpression initExpression = context.visitLeft2Right(OCLExpression.class, csInitExpression);
				pivotElement.setOwnedInit(initExpression);
				TypedRefCS csType = csTupleLiteralPart.getOwnedType();
				Type type = csType != null ? PivotUtil.getPivot(Type.class, csType) : initExpression != null ? initExpression.getType() : null;
				helper.setType(pivotElement, type, (initExpression != null) && initExpression.isIsRequired(), null);
			}
		}
		return pivotElement;
	}

	@Override
	public Element visitTypeLiteralExpCS(@NonNull TypeLiteralExpCS csTypeLiteralExp) {
		TypedRefCS csType = csTypeLiteralExp.getOwnedType();
		//		context.visitInOrder(csType, null);
		Type type = PivotUtil.getPivot(Type.class, csType);
		return type != null ? resolveTypeExp(csTypeLiteralExp, type) : null;
	}

	@Override
	public Element visitUnlimitedNaturalLiteralExpCS(@NonNull UnlimitedNaturalLiteralExpCS csUnlimitedNaturalLiteralExp) {
		UnlimitedNaturalLiteralExp expression = PivotUtil.getPivot(UnlimitedNaturalLiteralExp.class, csUnlimitedNaturalLiteralExp);
		if (expression != null) {
			helper.setType(expression, standardLibrary.getUnlimitedNaturalType(), true, null);
		}
		return expression;
	}

	@Override
	public Element visitVariableCS(@NonNull VariableCS csVariable) {
		Variable variable = PivotUtil.getPivot(Variable.class, csVariable);
		if (variable != null) {
			OCLExpression initExpression = PivotUtil.getPivot(OCLExpression.class, csVariable.getOwnedInitExpression());
			if (initExpression != null) {
				Type initType = initExpression.getType();
				TypedRefCS csType = csVariable.getOwnedType();
				Type type;
				if (csType != null) {
					type = PivotUtil.getPivot(Type.class, csType);
				}
				else {
					type = initType;
					// FIXME deduction is more complex than this
				}
				helper.setType(variable, type, initExpression.isIsRequired(), initExpression.getTypeValue());
			}
			variable.setOwnedInit(initExpression);
		}
		return variable;
	}
}
