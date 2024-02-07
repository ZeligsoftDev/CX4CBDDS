/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ResultVariable;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryIterationOrOperation;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * PivotHelper provides helper routines to assist creation of Pivot model elements.
 * @since 1.3
 */
public class PivotHelper
{
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull StandardLibrary standardLibrary;
	private final @NonNull PivotMetamodelManager metamodelManager;

	public PivotHelper(@NonNull EnvironmentFactory environmentFactory) {
		this.environmentFactory = environmentFactory;
		this.standardLibrary = environmentFactory.getStandardLibrary();
		this.metamodelManager = (PivotMetamodelManager) environmentFactory.getMetamodelManager();			// FIXME avoid this cast;
	}

	public @NonNull BooleanLiteralExp createBooleanLiteralExp(boolean booleanSymbol) {
		BooleanLiteralExp asBoolean = PivotFactory.eINSTANCE.createBooleanLiteralExp();
		asBoolean.setBooleanSymbol(booleanSymbol);
		asBoolean.setType(standardLibrary.getBooleanType());
		asBoolean.setIsRequired(true);
		return asBoolean;
	}

	/**
	 * @since 1.4
	 */
	public @NonNull OCLExpression createCoercionCallExp(@NonNull OCLExpression asExpression, @NonNull Operation coercion) {
		if (asExpression instanceof IntegerLiteralExp) {
			IntegerLiteralExp asIntegerLiteralExp = (IntegerLiteralExp)asExpression;
			Number integerSymbol = asIntegerLiteralExp.getIntegerSymbol();
			if (integerSymbol.longValue() >= 0) {
				org.eclipse.ocl.pivot.Class integerType = standardLibrary.getIntegerType();
				Operation asCoercion = NameUtil.getNameable(integerType.getOwnedOperations(), "toUnlimitedNatural");
				if (coercion == asCoercion) {
					return createUnlimitedNaturalLiteralExp(integerSymbol);
				}
			}
		}
		OperationCallExp asCoercionCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		asCoercionCallExp.setOwnedSource(asExpression);
		asCoercionCallExp.setReferredOperation(coercion);
		asCoercionCallExp.setType(coercion.getType());
		asCoercionCallExp.setIsRequired(coercion.isIsRequired());
		return asCoercionCallExp;
	}

	public @NonNull CollectionItem createCollectionItem(@NonNull OCLExpression asItem) {
		CollectionItem collectionItem = PivotFactory.eINSTANCE.createCollectionItem();
		collectionItem.setOwnedItem(asItem);
		collectionItem.setType(asItem.getType());
		collectionItem.setIsRequired(asItem.isIsRequired());
		return collectionItem;
	}

	public @NonNull CollectionLiteralExp createCollectionLiteralExp(@NonNull CollectionType asType, @NonNull Iterable<CollectionLiteralPart> asParts) {
		CollectionLiteralExp collectionLiteralExp = PivotFactory.eINSTANCE.createCollectionLiteralExp();
		Iterables.addAll(collectionLiteralExp.getOwnedParts(), asParts);
		collectionLiteralExp.setType(asType);
		collectionLiteralExp.setKind(TypeUtil.getCollectionKind(asType));
		collectionLiteralExp.setIsRequired(true);
		return collectionLiteralExp;
	}

	public @NonNull CollectionRange createCollectionRange(@NonNull OCLExpression asFirst, @NonNull OCLExpression asLast) {
		CollectionRange collectionRange = PivotFactory.eINSTANCE.createCollectionRange();
		collectionRange.setOwnedFirst(asFirst);
		collectionRange.setOwnedLast(asLast);
		collectionRange.setType(standardLibrary.getIntegerType());
		collectionRange.setIsRequired(true);
		return collectionRange;
	}

	public @NonNull Comment createComment(@NonNull String comment) {
		Comment asComment = PivotFactory.eINSTANCE.createComment();
		asComment.setBody(comment);
		return asComment;
	}

	/**
	 * @since 1.10
	 */
	public @NonNull EnumLiteralExp createEnumLiteralExp(@NonNull EnumerationLiteral value) {
		EnumLiteralExp asEnumLiteralExp = PivotFactory.eINSTANCE.createEnumLiteralExp();
		asEnumLiteralExp.setReferredLiteral(value);
		asEnumLiteralExp.setType(value.getOwningEnumeration());
		asEnumLiteralExp.setIsRequired(true);
		return asEnumLiteralExp;
	}

	public @NonNull IfExp createIfExp(@NonNull OCLExpression asCondition, @NonNull OCLExpression asThen, @NonNull OCLExpression asElse) {
		Type commonType = metamodelManager.getCommonType(ClassUtil.nonNullState(asThen.getType()), TemplateParameterSubstitutions.EMPTY,
			ClassUtil.nonNullState(asElse.getType()), TemplateParameterSubstitutions.EMPTY);
		IfExp asIf = PivotFactory.eINSTANCE.createIfExp();
		asIf.setOwnedCondition(asCondition);
		asIf.setOwnedThen(asThen);
		asIf.setOwnedElse(asElse);
		asIf.setType(commonType);
		asIf.setIsRequired(asThen.isIsRequired() && asElse.isIsRequired());
		return asIf;
	}

	public  @NonNull Import createImport(@Nullable String name, @NonNull Namespace namespace) {
		Import asImport = PivotFactory.eINSTANCE.createImport();
		asImport.setName(name);
		asImport.setImportedNamespace(namespace);
		asImport.setXmiidVersion(PivotConstants.XMIIDS_CURRENT);
		return asImport;
	}

	public @NonNull IntegerLiteralExp createIntegerLiteralExp(@NonNull Number integerSymbol) {
		IntegerLiteralExp asInteger = PivotFactory.eINSTANCE.createIntegerLiteralExp();
		asInteger.setIntegerSymbol(integerSymbol);
		asInteger.setType(standardLibrary.getIntegerType());
		asInteger.setIsRequired(true);
		return asInteger;
	}

	public @NonNull InvalidLiteralExp createInvalidExpression(/*Object object, String boundMessage, Throwable e*/) {
		InvalidLiteralExp invalidLiteralExp = PivotFactory.eINSTANCE.createInvalidLiteralExp();
		invalidLiteralExp.setType(standardLibrary.getOclInvalidType());
		//		invalidLiteralExp.setObject(object);
		//		invalidLiteralExp.setReason(boundMessage);
		//		invalidLiteralExp.setThrowable(e);
		return invalidLiteralExp;
	}

	public @NonNull IterateExp createIterateExp(@NonNull OCLExpression asSource, @NonNull Iteration asIteration, @NonNull List<@NonNull ? extends Variable> asIterators, @NonNull Variable asResult, @NonNull OCLExpression asBody) {
		IterateExp asCallExp = PivotFactory.eINSTANCE.createIterateExp();
		asCallExp.setReferredIteration(asIteration);
		asCallExp.setName(asIteration.getName());
		asCallExp.setOwnedSource(asSource);
		asCallExp.getOwnedIterators().addAll(asIterators);
		asCallExp.setOwnedResult(asResult);
		asCallExp.setOwnedBody(asBody);
		setOperationReturnType(asCallExp, asIteration);
		return asCallExp;
	}

	public @NonNull IteratorExp createIteratorExp(@NonNull OCLExpression asSource, @NonNull Iteration asIteration, @NonNull List<@NonNull ? extends Variable> asIterators, @NonNull OCLExpression asBody) {
		IteratorExp asCallExp = PivotFactory.eINSTANCE.createIteratorExp();
		asCallExp.setReferredIteration(asIteration);
		asCallExp.setName(asIteration.getName());
		asCallExp.setOwnedSource(asSource);
		asCallExp.getOwnedIterators().addAll(asIterators);
		asCallExp.setOwnedBody(asBody);
		setOperationReturnType(asCallExp, asIteration);
		return asCallExp;
	}

	public @NonNull IteratorVariable createIteratorVariable(@NonNull String name, @NonNull Type asType, boolean isRequired) {
		IteratorVariable asVariable = PivotFactory.eINSTANCE.createIteratorVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		return asVariable;
	}

	public @NonNull LetExp createLetExp(@NonNull Variable asVariable, @NonNull OCLExpression asInExpression) {
		LetExp asLetExp = PivotFactory.eINSTANCE.createLetExp();
		asLetExp.setOwnedVariable(asVariable);
		asLetExp.setOwnedIn(asInExpression);;
		asLetExp.setType(asInExpression.getType());
		asLetExp.setIsRequired(asInExpression.isIsRequired());
		asLetExp.setOwnedVariable(asVariable);
		return asLetExp;
	}

	public @NonNull LetVariable createLetVariable(@NonNull String name, @NonNull OCLExpression asInitExpression) {
		LetVariable asVariable = PivotFactory.eINSTANCE.createLetVariable();
		asVariable.setName(name);
		asVariable.setType(asInitExpression.getType());
		asVariable.setIsRequired(asInitExpression.isIsRequired());
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	public @NonNull LetVariable createLetVariable(@NonNull String name, @NonNull Type asType, boolean isRequired) {
		LetVariable asVariable = PivotFactory.eINSTANCE.createLetVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		return asVariable;
	}

	public @NonNull LetVariable createLetVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @NonNull OCLExpression asInitExpression) {
		LetVariable asVariable = PivotFactory.eINSTANCE.createLetVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	public @NonNull OCLExpression createMapLiteralExp(@NonNull MapType asType, @NonNull Iterable<MapLiteralPart> asParts) {
		MapLiteralExp mapLiteralExp = PivotFactory.eINSTANCE.createMapLiteralExp();
		Iterables.addAll(mapLiteralExp.getOwnedParts(), asParts);
		mapLiteralExp.setType(asType);
		mapLiteralExp.setIsRequired(true);
		return mapLiteralExp;
	}

	public @NonNull MapLiteralPart createMapLiteralPart(@NonNull OCLExpression asKey, @NonNull OCLExpression asValue) {
		MapLiteralPart mapLiteralPart = PivotFactory.eINSTANCE.createMapLiteralPart();
		mapLiteralPart.setOwnedKey(asKey);
		mapLiteralPart.setOwnedValue(asValue);
		//		mapLiteralPart.setType(asItem.getType());
		//		mapLiteralPart.setIsRequired(true);
		return mapLiteralPart;
	}

	@SuppressWarnings("deprecation")
	public @NonNull NavigationCallExp createNavigationCallExp(@NonNull OCLExpression asSourceExpression, @NonNull Property asProperty) {
		return PivotUtil.createNavigationCallExp(asSourceExpression, asProperty);
	}

	public @NonNull NullLiteralExp createNullLiteralExp() {
		NullLiteralExp asNull = PivotFactory.eINSTANCE.createNullLiteralExp();
		asNull.setType(standardLibrary.getOclVoidType());
		asNull.setIsRequired(false);
		return asNull;
	}

	public @NonNull OperationCallExp createOperationCallExp(@NonNull OCLExpression asSourceExpression, @NonNull String opName, @NonNull OCLExpression... asArguments) {
		Type asType = ClassUtil.nonNullState(asSourceExpression.getType());
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(asType);
		int argumentCount = asArguments != null ? asArguments.length : 0;
		int bestMatches = -1;
		Operation bestOperation = null;
		for (@NonNull Operation asOperation : completeClass.getOperations(FeatureFilter.SELECT_NON_STATIC, opName)) {
			List<@NonNull ? extends TypedElement> asParameters = ClassUtil.nullFree(asOperation.getOwnedParameters());
			if ((asParameters.size() == argumentCount) && (asArguments != null)) {
				int exactMatches = 0;
				boolean gotOne = true;
				for (int i = 0; i < argumentCount; i++) {
					Type asParameterType = ClassUtil.nonNullState(asParameters.get(i).getType());
					OCLExpression asArgument = asArguments[i];
					Type asArgumentType = asArgument.getType();
					if (asParameterType instanceof SelfType) {
						if (asArgumentType.conformsTo(standardLibrary, asType) && asType.conformsTo(standardLibrary, asArgumentType)) {
							exactMatches++;
						}
					}
					else {
						if (!asArgumentType.conformsTo(standardLibrary, asParameterType)) {
							gotOne = false;
							break;
						}
						if (asParameterType.conformsTo(standardLibrary, asArgumentType)) {
							exactMatches++;
						}
					}
				}
				if (gotOne) {
					if (exactMatches > bestMatches) {
						bestMatches = exactMatches;
						bestOperation = asOperation;
					}
					else if (exactMatches > bestMatches) {
						bestOperation = null;
					}
				}
			}
		}
		if (bestMatches < 0) {
			throw new IllegalStateException("No match found for " + opName);
		}
		if (bestOperation == null) {
			throw new IllegalStateException("Ambiguous match found for " + opName);
		}
		return createOperationCallExp(asSourceExpression, bestOperation, asArguments != null ? Lists.newArrayList(asArguments) : null);
	}

	//	public @NonNull OperationCallExp createOperationCallExp(@Nullable OCLExpression asSourceExpression, @NonNull Operation asOperation, @NonNull OCLExpression... asArguments) {
	//		return createOperationCallExp(asSourceExpression, asOperation, asArguments != null ? Lists.newArrayList(asArguments) : null);
	//	}

	public @NonNull OperationCallExp createOperationCallExp(@Nullable OCLExpression asSourceExpression, @NonNull Operation asOperation, @Nullable List<@NonNull OCLExpression> asArguments) {
		OperationCallExp asOperationCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		asOperationCallExp.setOwnedSource(asSourceExpression);
		asOperationCallExp.setReferredOperation(asOperation);
		asOperationCallExp.setName(asOperation.getName());
		if (asArguments != null) {
			asOperationCallExp.getOwnedArguments().addAll(asArguments);
		}
		setOperationReturnType(asOperationCallExp, asOperation);
		return asOperationCallExp;
	}

	public org.eclipse.ocl.pivot.@NonNull Package createPackage(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI) {
		Package asPackage = PivotFactory.eINSTANCE.createPackage();
		asPackage.setName(name);
		if (nsPrefix != null) {
			asPackage.setNsPrefix(nsPrefix);
		}
		if (nsURI != null) {
			asPackage.setURI(nsURI);
		}
		return asPackage;
	}

	public @NonNull Parameter createParameter(@NonNull TypedElement typedElement) {
		String name = ClassUtil.nonNullState(typedElement.getName());
		Type type = ClassUtil.nonNullState(typedElement.getType());
		Parameter asParameter = PivotUtil.createParameter(name, type, typedElement.isIsRequired());
		return asParameter;
	}

	/**
	 * @since 1.11
	 */
	public @NonNull Parameter createParameter(@NonNull String name, @NonNull Type asType, boolean isRequired) {
		return PivotUtil.createParameter(name, asType, isRequired);
	}

	@Deprecated /* supply a representedParameter */
	public @NonNull ParameterVariable createParameterVariable(@NonNull String name, @NonNull Type asType, boolean isRequired) {
		ParameterVariable asVariable = PivotFactory.eINSTANCE.createParameterVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		return asVariable;
	}

	/**
	 * @since 1.10
	 */
	public @NonNull ParameterVariable createParameterVariable(@NonNull Parameter asParameter) {
		ParameterVariable asParameterVariable = PivotFactory.eINSTANCE.createParameterVariable();
		asParameterVariable.setName(asParameter.getName());
		asParameterVariable.setType(asParameter.getType());
		asParameterVariable.setIsRequired(asParameter.isIsRequired());
		asParameterVariable.setRepresentedParameter(asParameter);
		return asParameterVariable;
	}

	/**
	 * @since 1.11
	 */
	public @NonNull PropertyCallExp createPropertyCallExp(@NonNull OCLExpression asSource, @NonNull Property asProperty) {
		return PivotUtil.createPropertyCallExp(asSource, asProperty);
	}

	public @NonNull RealLiteralExp createRealLiteralExp(@NonNull Number realSymbol) {
		RealLiteralExp asReal = PivotFactory.eINSTANCE.createRealLiteralExp();
		asReal.setRealSymbol(realSymbol);
		asReal.setType(standardLibrary.getRealType());
		asReal.setIsRequired(true);
		return asReal;
	}

	public @NonNull ResultVariable createResultVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @NonNull OCLExpression asInitExpression) {
		ResultVariable asVariable = PivotFactory.eINSTANCE.createResultVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	public @NonNull OCLExpression createShadowExp(org.eclipse.ocl.pivot.@NonNull Class asClass, @NonNull Iterable<ShadowPart> asParts) {
		ShadowExp shadowExp = PivotFactory.eINSTANCE.createShadowExp();
		Iterables.addAll(shadowExp.getOwnedParts(), asParts);
		shadowExp.setType(asClass);
		shadowExp.setIsRequired(true);
		return shadowExp;
	}

	public @NonNull ShadowPart createShadowPart(@NonNull Property asProperty, @NonNull OCLExpression asValue) {
		ShadowPart shadowPart = PivotFactory.eINSTANCE.createShadowPart();
		shadowPart.setReferredProperty(asProperty);
		shadowPart.setType(asProperty.getType());
		shadowPart.setIsRequired(asProperty.isIsRequired());
		shadowPart.setOwnedInit(asValue);
		return shadowPart;
	}

	public @NonNull StringLiteralExp createStringLiteralExp(@NonNull String stringSymbol) {
		StringLiteralExp asString = PivotFactory.eINSTANCE.createStringLiteralExp();
		asString.setStringSymbol(stringSymbol);
		asString.setType(standardLibrary.getStringType());
		asString.setIsRequired(true);
		return asString;
	}

	public @NonNull TupleLiteralExp createTupleLiteralExp(@NonNull TupleType asType, @NonNull Iterable<TupleLiteralPart> asParts) {
		TupleLiteralExp tupleLiteralExp = PivotFactory.eINSTANCE.createTupleLiteralExp();
		Iterables.addAll(tupleLiteralExp.getOwnedParts(), asParts);
		tupleLiteralExp.setType(asType);
		tupleLiteralExp.setIsRequired(true);
		return tupleLiteralExp;
	}

	public @NonNull TupleLiteralPart createTupleLiteralPart(@NonNull String name, @NonNull Type asType, boolean isRequired, @NonNull OCLExpression asValue) {
		TupleLiteralPart tupleLiteralPart = PivotFactory.eINSTANCE.createTupleLiteralPart();
		tupleLiteralPart.setName(name);
		tupleLiteralPart.setType(asType);
		tupleLiteralPart.setIsRequired(isRequired);
		tupleLiteralPart.setOwnedInit(asValue);
		return tupleLiteralPart;
	}

	public @NonNull TypeExp createTypeExp(@NonNull Type type) {		// FIXME Class
		assert type instanceof org.eclipse.ocl.pivot.Class;		// Not TemplateParameter
		TypeExp asTypeExp = PivotFactory.eINSTANCE.createTypeExp();
		asTypeExp.setIsRequired(true);
		asTypeExp.setReferredType(type);
		asTypeExp.setName(type.getName());
		Type metaType = standardLibrary.getMetaclass(type);
		asTypeExp.setType(metaType);
		asTypeExp.setTypeValue(type);
		return asTypeExp;
	}

	public @NonNull UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp(@NonNull Number unlimitedNaturalSymbol) {
		UnlimitedNaturalLiteralExp asUnlimitedNatural = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
		asUnlimitedNatural.setUnlimitedNaturalSymbol(unlimitedNaturalSymbol);
		asUnlimitedNatural.setType(standardLibrary.getUnlimitedNaturalType());
		asUnlimitedNatural.setIsRequired(true);
		return asUnlimitedNatural;
	}

	/** @deprecated Use appropriate derived Variable */
	@Deprecated
	public @NonNull Variable createVariable(@NonNull String name, @NonNull OCLExpression asInitExpression) {
		Variable asVariable = PivotUtil.createVariable(name, asInitExpression);
		return asVariable;
	}

	/** @deprecated Use appropriate derived Variable */
	@Deprecated
	public @NonNull Variable createVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression asInitExpression) {
		Variable asVariable = PivotUtil.createVariable(name, asType, isRequired, asInitExpression);
		return asVariable;
	}

	/** @deprecated Use appropriate derived Variable */
	@Deprecated
	public @NonNull Variable createVariable(@NonNull TypedElement typedElement) {
		String name = ClassUtil.nonNullState(typedElement.getName());
		Type type = ClassUtil.nonNullState(typedElement.getType());
		Variable asVariable = PivotUtil.createVariable(name, type, typedElement.isIsRequired(), null);
		return asVariable;
	}

	public @NonNull VariableExp createVariableExp(@NonNull VariableDeclaration asVariable) {
		VariableExp asVariableExp = PivotUtil.createVariableExp(asVariable);
		return asVariableExp;
	}

	public org.eclipse.ocl.pivot.@NonNull Class getDataTypeClass() {
		return ClassUtil.nonNullState(metamodelManager.getASClass(TypeId.DATA_TYPE_NAME));
	}

	public @NonNull Property getDataTypeValueProperty() {
		return ClassUtil.nonNullState(NameUtil.getNameable(getDataTypeClass().getOwnedProperties(), PivotConstants.DATA_TYPE_VALUE_NAME));
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	protected @NonNull PivotMetamodelManager getMetamodelManager() {
		return metamodelManager;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	/**
	 * @since 1.4
	 */
	public <T extends EObject> void refreshList(@Nullable List<? super T> oldElements, @Nullable List<? extends T> newElements) {
		PivotUtilInternal.refreshList(oldElements, newElements);
	}

	/**
	 * @since 1.4
	 */
	public void refreshName(@NonNull NamedElement pivotNamedElement, @Nullable String newName) {
		String oldName = pivotNamedElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			pivotNamedElement.setName(newName);
		}
	}

	/**
	 * @since 1.4
	 */
	public void refreshNsURI(org.eclipse.ocl.pivot.@NonNull Package pivotPackage, String newNsURI) {
		String oldNsURI = pivotPackage.getURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			pivotPackage.setURI(newNsURI);
		}
	}

	/**
	 * Rewrite asTree and all its descendants to replace all "?." and "?->" navigations by their safe counterparts.
	 * @since 1.3
	 */
	public void rewriteSafeNavigations(@NonNull Element asTree) {
		//
		//	Locate all unsafe calls first to avoid CME from concurrent locate/rewrite.
		//
		List<@NonNull CallExp> unsafeCallExps = null;
		if (asTree instanceof CallExp) {
			unsafeCallExps = rewriteUnsafeCallExp_Gather(unsafeCallExps, (CallExp)asTree);
		}
		for (TreeIterator<EObject> tit = asTree.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof CallExp) {
				unsafeCallExps = rewriteUnsafeCallExp_Gather(unsafeCallExps, (CallExp)eObject);
			}
		}
		//
		//	Rewrite the unsafe calls
		//
		if (unsafeCallExps != null) {
			org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
			Operation oclEqualsOperation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "=");
			assert oclEqualsOperation != null;
			org.eclipse.ocl.pivot.Class collectionType = standardLibrary.getCollectionType();
			Operation excludingOperation = NameUtil.getNameable(collectionType.getOwnedOperations(), "excluding");
			assert excludingOperation != null;
			for (CallExp unsafeCallExp : unsafeCallExps) {
				OCLExpression source = unsafeCallExp.getOwnedSource();
				assert source != null;
				if (source.getType() instanceof CollectionType) {
					rewriteUnsafeCollectionCallExp(metamodelManager, excludingOperation, unsafeCallExp);
				}
				else {
					rewriteUnsafeObjectCallExp(metamodelManager, oclEqualsOperation, unsafeCallExp);
				}
			}
		}
	}

	private @Nullable List<@NonNull CallExp> rewriteUnsafeCallExp_Gather(@Nullable List<@NonNull CallExp> unsafeCallExps, @NonNull CallExp callExp) {
		OCLExpression source = callExp.getOwnedSource();
		if ((source != null) && callExp.isIsSafe()) {
			if (unsafeCallExps == null) {
				unsafeCallExps = new ArrayList<@NonNull CallExp>();
			}
			unsafeCallExps.add(callExp);
		}
		return unsafeCallExps;
	}

	private void rewriteUnsafeCollectionCallExp(@NonNull PivotMetamodelManager metamodelManager, @NonNull Operation excludingOperation, @NonNull CallExp unsafeCollectionCallExp) {
		unsafeCollectionCallExp.setIsSafe(false);
		EObject eContainer = unsafeCollectionCallExp.eContainer();
		EReference eContainmentFeature = unsafeCollectionCallExp.eContainmentFeature();
		PivotUtilInternal.resetContainer(unsafeCollectionCallExp);
		//
		OCLExpression nullExpression = metamodelManager.createNullLiteralExp();
		OCLExpression safeCollectionCallExp = createOperationCallExp(unsafeCollectionCallExp, excludingOperation, Collections.singletonList(nullExpression));
		//
		eContainer.eSet(eContainmentFeature, safeCollectionCallExp);
	}

	/**
	 * @since 1.4
	 */
	private  void rewriteUnsafeObjectCallExp(@NonNull PivotMetamodelManager metamodelManager, @NonNull Operation oclEqualsOperation, @NonNull CallExp unsafeObjectCallExp) {
		unsafeObjectCallExp.setIsSafe(false);
		EObject eContainer = unsafeObjectCallExp.eContainer();
		EReference eContainmentFeature = unsafeObjectCallExp.eContainmentFeature();
		PivotUtilInternal.resetContainer(unsafeObjectCallExp);
		OCLExpression oldSourceExpression = unsafeObjectCallExp.getOwnedSource();
		assert oldSourceExpression != null;
		//
		LetVariable unsafeSourceVariable = createLetVariable("unsafe", oldSourceExpression);
		OCLExpression unsafeSourceExpression1 = createVariableExp(unsafeSourceVariable);
		unsafeObjectCallExp.setOwnedSource(unsafeSourceExpression1);
		//
		OCLExpression unsafeSourceExpression2 = createVariableExp(unsafeSourceVariable);
		OCLExpression nullExpression = metamodelManager.createNullLiteralExp();
		OCLExpression isUnsafeExpression = createOperationCallExp(unsafeSourceExpression2, oclEqualsOperation, Collections.singletonList(nullExpression));
		//
		OCLExpression thenExpression = metamodelManager.createNullLiteralExp();
		OCLExpression safeObjectCallExp = metamodelManager.createIfExp(isUnsafeExpression, thenExpression, unsafeObjectCallExp);
		//
		LetExp safeExp = createLetExp(unsafeSourceVariable, safeObjectCallExp);
		//
		eContainer.eSet(eContainmentFeature, safeExp);
	}

	/**
	 * @since 1.4
	 */
	@Deprecated /* @deprecated not used -doesn't set behavioral type */
	public void setBehavioralType(@NonNull TypedElement targetElement, @NonNull TypedElement sourceElement) {
		if (!sourceElement.eIsProxy()) {
			Type type = PivotUtil.getType(sourceElement);
			if (type instanceof SelfType) {
				type = standardLibrary.getOclAnyType();
			}
			if (type.eIsProxy()) {
				type = null;
			}
			boolean isRequired = sourceElement.isIsRequired();
			setType(targetElement, type, isRequired);
		}
	}

	/**
	 * @since 1.4
	 */
	public void setContextVariable(@NonNull ExpressionInOCL pivotSpecification, @NonNull String selfVariableName, @Nullable Type contextType, @Nullable Type contextInstance) {
		Variable contextVariable = pivotSpecification.getOwnedContext();
		if (contextVariable == null) {
			@NonNull ParameterVariable nonNullContextVariable = PivotFactory.eINSTANCE.createParameterVariable();
			contextVariable = nonNullContextVariable;
			pivotSpecification.setOwnedContext(contextVariable);
			if (contextType == null) {
				contextType = standardLibrary.getOclVoidType();
			}
		}
		refreshName(contextVariable, selfVariableName);
		setType(contextVariable, contextType, contextVariable.isIsRequired(), contextInstance);
	}

	/**
	 * Set the operation/iteration return type and nullity in the asCallExp. This may involve creating a specialization
	 * of the operation/iteration return type and may require the use of a TemplateParameterSubstitutionHelper to
	 * compute inadequately modelled unique/ordered/size/nullity.
	 *
	 * @since 1.4
	 */
	public void setOperationReturnType(@NonNull CallExp asCallExp, @NonNull Operation asOperation) {
		OCLExpression asSourceExpression = asCallExp.getOwnedSource();
		Type sourceType;
		if (asSourceExpression != null) {
			sourceType = asSourceExpression.getType();
		}
		else {
			sourceType = null;
		}
		Type returnType = null;
		Type formalType = asOperation.getType();
		boolean returnIsRequired = asOperation.isIsRequired();
		Object returnValue = null;			// Currently always a Type - see Bug 577902
		if ((formalType != null) && (sourceType != null)) {
			returnType = TemplateParameterSubstitutionVisitor.specializeType(formalType, asCallExp, (EnvironmentFactoryInternal)environmentFactory, sourceType, null);
		}
		//
		//	The flattening of collect() and consequently implicit-collect is not modelled accurately.
		//	Other library operations have subtle non-null/size computations.
		//	Therefore allow an operation-specific overrides to adjust the regular functionality above.
		//
		LibraryIterationOrOperation implementation = (LibraryIterationOrOperation)asOperation.getImplementation();
		if (implementation != null) {		// Library classes have implementations, Complete OCL classes may be recursive
			returnType = implementation.resolveReturnType(environmentFactory, asCallExp, returnType);
			returnIsRequired = implementation.resolveReturnNullity(environmentFactory, asCallExp, returnIsRequired);
			returnValue = implementation.resolveReturnValue(environmentFactory, asCallExp);
		//	assert (returnValue == null) || ((returnType != null) && returnType.getName().equals(((EObject)returnValue).eClass().getName()));	// Not valid once AnyType/VoidType get involved
		}
		else {
			assert !asOperation.isIsTypeof();			// typeof return declaration must now be realized by an operation override
		}
		setType(asCallExp, returnType, returnIsRequired, (Type)returnValue);
	}

	public void setType(@NonNull OCLExpression asExpression, Type type, boolean isRequired, @Nullable Type typeValue) {
		setType(asExpression, type, isRequired);
		Type primaryTypeValue = typeValue != null ? metamodelManager.getPrimaryType(typeValue) : null;
		if (primaryTypeValue != asExpression.getTypeValue()) {
			asExpression.setTypeValue(primaryTypeValue);
		}
	}

	/**
	 * @since 1.4
	 */
	public void setType(@NonNull VariableDeclaration asVariable, Type type, boolean isRequired, @Nullable Type typeValue) {
		setType(asVariable, type, isRequired);
		Type primaryTypeValue = typeValue != null ? metamodelManager.getPrimaryType(typeValue) : null;
		if (primaryTypeValue != asVariable.getTypeValue()) {
			asVariable.setTypeValue(primaryTypeValue);
		}
	}

	public void setType(@NonNull TypedElement asTypedElement, Type type, boolean isRequired) {
		Type primaryType = type != null ? metamodelManager.getPrimaryType(type) : null;
		if (primaryType != asTypedElement.getType()) {
			asTypedElement.setType(primaryType);
		}
		boolean wasRequired = asTypedElement.isIsRequired();
		if (wasRequired != isRequired) {
			asTypedElement.setIsRequired(isRequired);
		}
		if (primaryType != null) {
			PivotUtil.debugWellContainedness(primaryType);
		}
	}
}