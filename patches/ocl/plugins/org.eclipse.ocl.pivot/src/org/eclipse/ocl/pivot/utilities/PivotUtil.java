/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 * 	 E.D.Willink (CEA LIST) - Bug 425799 - validity view
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.AssociativityKind;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.PackageImpl;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.pivot.internal.manager.PivotExecutorManager;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView.DiagnosticWrappedException;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.messages.StatusCodes.Severity;
import org.eclipse.ocl.pivot.options.PivotValidationOptions;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public class PivotUtil
{
	/**
	 * 'Highest' precedence first
	 *
	 * @deprecated (Not used) The Precedence.order is not a constant in a shared library. Use the PrecedenceManager.
	 */
	@Deprecated
	public static class PrecedenceComparator implements Comparator<Precedence>
	{
		public static final PrecedenceComparator INSTANCE = new PrecedenceComparator();

		@Override
		public int compare(Precedence p1, Precedence p2) {
			int o1 = p1 != null ? p1.getOrder().intValue() : -1;
			int o2 = p2 != null ? p2.getOrder().intValue() : -1;
			return o1 - o2; // NB least positive is highest precedence
		}
	}

	/**
	 * In TemplateSignature order.
	 */
	public static class TemplateParameterSubstitutionComparator
	implements Comparator<TemplateParameterSubstitution>
	{
		public static Comparator<? super TemplateParameterSubstitution> INSTANCE =
				new TemplateParameterSubstitutionComparator();

		@Override
		public int compare(TemplateParameterSubstitution o1, TemplateParameterSubstitution o2) {
			TemplateParameter f1 = o1.getFormal();
			TemplateParameter f2 = o2.getFormal();
			int i1 = f1.getOwningSignature().getOwnedParameters().indexOf(f1);
			int i2 = f2.getOwningSignature().getOwnedParameters().indexOf(f2);
			return i1 - i2;
		}
	}

	/**
	 * @since 1.3
	 */
	public static void addAllClasses(@NonNull EnvironmentView environmentView, org.eclipse.ocl.pivot.@NonNull Package pPackage) {
		String packageName = pPackage.getName();
		if ((packageName == null) || "".equals(packageName)) {
			environmentView.addNamedElements(pPackage.getOwnedClasses());
		}
		else {
			CompletePackage completePackage = environmentView.getEnvironmentFactory().getCompleteModel().getCompletePackage(pPackage);
			environmentView.addNamedElements(completePackage.getAllClasses());
		}
	}

	/**
	 * @since 1.3
	 */
	public static <T extends NamedElement> void addAllNamedElements(@NonNull EnvironmentView environmentView, @NonNull Iterable<T> namedElements) {
		String name = environmentView.getName();
		if (name != null) {
			for (T namedElement : namedElements) {
				if ((namedElement != null) && name.equals(namedElement.getName())) {
					environmentView.addElement(name, namedElement);
				}
			}
		}
		else {
			for (T namedElement : namedElements) {
				if (namedElement != null) {
					environmentView.addNamedElement(namedElement);
				}
			}
		}
	}

	/**
	 * Locate an OCL Executor from the Resource containing an eObject, else create a default one.
	 *
	 * @since 1.14
	 */
	public static @Nullable Executor basicGetExecutor() {
		return ThreadLocalExecutor.basicGetExecutor();
	}
	@Deprecated /* @deprecated omit obsolete argument */
	public static @Nullable Executor basicGetExecutor(@NonNull EObject eObject) {
		return ThreadLocalExecutor.basicGetExecutor();
	}

	/**
	 * Locate an OCL Executor from the Executor.class slot in validationContext, else
	 * from the Resource containing an eObject, else return null.
	 *
	 * The returned executor is cached at the Executor.class slot in validationContext for re-use.
	 *
	 * @since 1.7
	 */
	public static @Nullable Executor basicGetExecutor(@NonNull EObject eObject, @Nullable  Map<Object, Object> validationContext) {
		Executor executor = ThreadLocalExecutor.basicGetExecutor();
		if (executor != null) {
			return executor;
		}
		Resource asResource = eObject.eResource();
		if (asResource != null) {
			EnvironmentFactory environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
			if ((environmentFactory != null) && !environmentFactory.isDisposed()) {
				executor = PivotExecutorManager.createAdapter(environmentFactory, eObject);
				if (executor != null) {
					ThreadLocalExecutor.setExecutor(executor);
				}
				return executor;
			}
		}
		return null;
	}

	/**
	 * @since 1.7
	 */
	public static org.eclipse.ocl.pivot.@Nullable Class basicGetLowerBound(@NonNull TemplateParameter templateParameter) {
		for (int recursions = 0; recursions < 100; recursions++) {
			List<org.eclipse.ocl.pivot.Class> asConstrainingClasses = templateParameter.getConstrainingClasses();
			if (asConstrainingClasses.size() <= 0) {
				return null;
			}
			org.eclipse.ocl.pivot.Class pivotType = ClassUtil.nonNullModel(asConstrainingClasses.get(0));
			if (!(pivotType instanceof TemplateParameter)) {
				return pivotType;
			}
			templateParameter = (TemplateParameter) pivotType;
		}
		return null;
	}

	/**
	 * Check that expressionInOCL was successfully compiled. Throws an InvalidValueException explaining the problem
	 * if expressionInOCL has no contextVariable and has a StringLiteralExp bodyExpression.
	 */
	public static void checkExpression(@NonNull ExpressionInOCL expressionInOCL) {
		VariableDeclaration contextVariable = expressionInOCL.getOwnedContext();
		if (contextVariable == null) {
			OCLExpression bodyExpression = expressionInOCL.getOwnedBody();
			if (bodyExpression instanceof StringLiteralExp) {
				throw new InvalidValueException(((StringLiteralExp)bodyExpression).getStringSymbol());
			}
		}
	}

	public static void checkResourceErrors(@NonNull String message, @NonNull Resource resource) throws ParserException {
		List<Resource.Diagnostic> errors = ClassUtil.nonNullEMF(resource.getErrors());
		if (errors.size() > 0) {
			throw new SemanticException(formatResourceDiagnostics(errors, message, "\n"));
		}
	}

	/**
	 * @since 1.4
	 */
	public static void checkResourceWarnings(@NonNull String message, @NonNull Resource resource) throws ParserException {
		List<Resource.Diagnostic> warnings = ClassUtil.nonNullEMF(resource.getWarnings());
		if (warnings.size() > 0) {
			throw new SemanticException(PivotUtil.formatResourceDiagnostics(warnings, message, "\n"));
		}
	}

	public static boolean conformsTo(@Nullable EClassifier targetType, @NonNull EClassifier contentType) {
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return ((EClass) targetType).isSuperTypeOf((EClass) contentType);
	}

	public static boolean conformsTo(@Nullable EStructuralFeature eStructuralFeature, @NonNull EClassifier contentType) {
		if (eStructuralFeature == null) {			// Wildcard match all
			return true;
		}
		EClassifier targetType = eStructuralFeature.getEType();
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return conformsTo(targetType, contentType);
	}

	public static @NonNull AnyType createAnyType(@NonNull String name) {
		AnyType pivotType = PivotFactory.eINSTANCE.createAnyType();
		pivotType.setName(name);
		return pivotType;
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull AnyType createAnyType(/*@NonNull*/ EClass eClass) {
		AnyType pivotType = PivotFactory.eINSTANCE.createAnyType();
		pivotType.setName(eClass.getName());
		((PivotObjectImpl)pivotType).setESObject(eClass);
		return pivotType;
	}

	public static @NonNull BagType createBagType(@NonNull BagType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createBagType(), unspecializedType, elementType);
	}

	public static org.eclipse.ocl.pivot.@NonNull Class createClass(/*@NonNull*/ EClass eClass) {
		org.eclipse.ocl.pivot.Class pivotType = PivotFactory.eINSTANCE.createClass();
		pivotType.setName(eClass.getName());
		((PivotObjectImpl)pivotType).setESObject(eClass);
		return pivotType;
	}

	public static org.eclipse.ocl.pivot.@NonNull Class createClass(@NonNull String name) {
		org.eclipse.ocl.pivot.Class pivotType = PivotFactory.eINSTANCE.createClass();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull CollectionType createCollectionType(@NonNull CollectionType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createCollectionType(), unspecializedType, elementType);
	}

	protected static @NonNull <@NonNull T extends CollectionType> T createCollectionType(/*@NonNull*/ T specializedType, @NonNull T unspecializedType, @NonNull Type instanceType) {
		specializedType.setName(unspecializedType.getName());
		specializedType.setLower(unspecializedType.getLower());
		specializedType.setUpper(unspecializedType.getUpper());
		specializedType.setUnspecializedElement(unspecializedType);
		TemplateParameter templateParameter = unspecializedType.getOwnedSignature().getOwnedParameters().get(0);
		assert templateParameter != null;
		TemplateParameterSubstitution templateParameterSubstitution = createTemplateParameterSubstitution(templateParameter, instanceType);
		TemplateBinding templateBinding = createTemplateBinding(templateParameterSubstitution);
		specializedType.getOwnedBindings().add(templateBinding);
		assert specializedType.getElementType() == instanceType;
		return specializedType;
	}

	public static @NonNull DataType createDataType(/*@NonNull*/ EDataType eDataType) {
		DataType pivotType = PivotFactory.eINSTANCE.createDataType();
		pivotType.setName(eDataType.getName());
		((PivotObjectImpl)pivotType).setESObject(eDataType);
		return pivotType;
	}

	public static @NonNull DataType createDataType(@NonNull String name) {
		DataType pivotType = PivotFactory.eINSTANCE.createDataType();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull Enumeration createEnumeration(/*@NonNull*/ EEnum eEnum) {
		Enumeration pivotType = PivotFactory.eINSTANCE.createEnumeration();
		pivotType.setName(eEnum.getName());
		((PivotObjectImpl)pivotType).setESObject(eEnum);
		return pivotType;
	}

	public static @NonNull Enumeration createEnumeration(@NonNull String name) {
		Enumeration pivotType = PivotFactory.eINSTANCE.createEnumeration();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull EnumerationLiteral createEnumerationLiteral(/*@NonNull*/ EEnumLiteral eEnumLiteral) {
		EnumerationLiteral pivotEnumerationLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		pivotEnumerationLiteral.setName(eEnumLiteral.getName());
		((PivotObjectImpl)pivotEnumerationLiteral).setESObject(eEnumLiteral);
		return pivotEnumerationLiteral;
	}

	public static @NonNull EnumerationLiteral createEnumerationLiteral(@NonNull String name) {
		EnumerationLiteral pivotEnumerationLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		pivotEnumerationLiteral.setName(name);
		return pivotEnumerationLiteral;
	}

	public static @NonNull ExpressionInOCL createExpressionInOCL(@Nullable Variable asContextVariable, @NonNull OCLExpression asExpression, /*@NonNull*/ Variable... asParameterVariables) {
		ExpressionInOCL asExpressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
		asExpressionInOCL.setOwnedContext(asContextVariable);
		if (asParameterVariables != null) {
			for (Variable asParameterVariable : asParameterVariables) {
				asExpressionInOCL.getOwnedParameters().add(asParameterVariable);
			}
		}
		asExpressionInOCL.setOwnedBody(asExpression);
		asExpressionInOCL.setType(asExpression.getType());
		asExpressionInOCL.setIsRequired(asExpression.isIsRequired());
		return asExpressionInOCL;
	}

	public static @NonNull ExpressionInOCL createExpressionInOCLError(@NonNull String string) {
		ExpressionInOCL expressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
		StringLiteralExp stringLiteral = PivotFactory.eINSTANCE.createStringLiteralExp();
		stringLiteral.setStringSymbol(string); //createTupleValuedConstraint("false", null, string));
		expressionInOCL.setOwnedBody(stringLiteral);
		expressionInOCL.setType(stringLiteral.getType());
		return expressionInOCL;
	}

	public static @NonNull InvalidType createInvalidType(@NonNull String name) {
		InvalidType pivotType = PivotFactory.eINSTANCE.createInvalidType();
		pivotType.setName(name);
		return pivotType;
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull InvalidType createInvalidType(/*@NonNull*/ EClass eClass) {
		InvalidType pivotType = PivotFactory.eINSTANCE.createInvalidType();
		pivotType.setName(eClass.getName());
		((PivotObjectImpl)pivotType).setESObject(eClass);
		return pivotType;
	}

	public static @NonNull Iteration createIteration(@NonNull String name, @NonNull Type type, @Nullable String implementationClass, @NonNull LibraryFeature implementation) {
		Iteration pivotIteration = PivotFactory.eINSTANCE.createIteration();
		pivotIteration.setName(name);
		pivotIteration.setType(type);
		pivotIteration.setImplementationClass(implementationClass);
		pivotIteration.setImplementation(implementation);
		return pivotIteration;
	}

	public static @NonNull LambdaType createLambdaType(@NonNull String name) {
		LambdaType pivotType = PivotFactory.eINSTANCE.createLambdaType();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull LetExp createLetExp(@NonNull Variable asVariable, @NonNull OCLExpression asIn) {
		LetExp asLetExp = PivotFactory.eINSTANCE.createLetExp();
		asLetExp.setOwnedIn(asIn);
		asLetExp.setType(asIn.getType());
		asLetExp.setIsRequired(asIn.isIsRequired());
		asLetExp.setOwnedVariable(asVariable);
		return asLetExp;
	}

	//	public static @NonNull MapType createMapType(@NonNull String name) {
	//		MapType pivotType = PivotFactory.eINSTANCE.createMapType();
	//		pivotType.setName(name);
	//		((PivotObjectImpl)pivotType).setESObject(eDataType);
	//		return pivotType;
	//	}

	public static @NonNull Model createModel(String externalURI) {
		Model pivotModel = PivotFactory.eINSTANCE.createModel();
		pivotModel.setExternalURI(externalURI);
		return pivotModel;
	}

	public static @NonNull MapType createMapType(@NonNull MapType unspecializedType, @NonNull Type keyType, @NonNull Type valueType) {
		return createMapType(PivotFactory.eINSTANCE.createMapType(), unspecializedType, keyType, valueType);
	}

	protected static @NonNull <@NonNull T extends MapType> T createMapType(T specializedType, T unspecializedType, @NonNull Type keyType, @NonNull Type valueType) {
		specializedType.setName(unspecializedType.getName());
		specializedType.setUnspecializedElement(unspecializedType);
		TemplateParameter templateParameter1 = unspecializedType.getOwnedSignature().getOwnedParameters().get(0);
		TemplateParameter templateParameter2 = unspecializedType.getOwnedSignature().getOwnedParameters().get(1);
		assert templateParameter1 != null;
		assert templateParameter2 != null;
		TemplateParameterSubstitution templateParameterSubstitution1 = createTemplateParameterSubstitution(templateParameter1, keyType);
		TemplateParameterSubstitution templateParameterSubstitution2 = createTemplateParameterSubstitution(templateParameter2, valueType);
		TemplateBinding templateBinding = createTemplateBinding(templateParameterSubstitution1, templateParameterSubstitution2);
		specializedType.getOwnedBindings().add(templateBinding);
		assert specializedType.getKeyType() == keyType;
		assert specializedType.getValueType() == valueType;
		return specializedType;
	}

	public static @NonNull <T extends Model> T createModel(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, String externalURI) {
		assert pivotEClass != null;
		@SuppressWarnings("unchecked")
		T pivotModel = (T) pivotEClass.getEPackage().getEFactoryInstance().create(pivotEClass);
		pivotModel.setExternalURI(externalURI);
		return pivotModel;
	}

	/**
	 * @since 1.1
	 * @deprecated Use PivotHelper.createNavigationCallExp to specialize return types.
	 */
	@Deprecated
	public static @NonNull NavigationCallExp createNavigationCallExp(@NonNull OCLExpression asSource, @NonNull Property asProperty) {
		NavigationCallExp asNavigationCallExp;
		if (asProperty.isIsImplicit()) {
			OppositePropertyCallExp asCallExp = PivotFactory.eINSTANCE.createOppositePropertyCallExp();
			asCallExp.setReferredProperty(asProperty.getOpposite());
			asNavigationCallExp = asCallExp;
		}
		else {
			PropertyCallExp asCallExp = PivotFactory.eINSTANCE.createPropertyCallExp();
			asCallExp.setReferredProperty(asProperty);
			asNavigationCallExp = asCallExp;
		}
		asNavigationCallExp.setName(asProperty.getName());
		asNavigationCallExp.setOwnedSource(asSource);
		asNavigationCallExp.setType(asProperty.getType());
		asNavigationCallExp.setIsRequired(asProperty.isIsRequired());
		return asNavigationCallExp;
	}

	public static @NonNull Operation createOperation(@NonNull String name, @NonNull Type type, @Nullable String implementationClass, @Nullable LibraryFeature implementation) {
		Operation pivotOperation = PivotFactory.eINSTANCE.createOperation();
		pivotOperation.setName(name);
		pivotOperation.setType(type);
		pivotOperation.setImplementationClass(implementationClass);
		pivotOperation.setImplementation(implementation);
		return pivotOperation;
	}

	public static @NonNull Operation createOperation(/*@NonNull*/ EOperation eOperation, @NonNull Type type, @Nullable String implementationClass, @Nullable LibraryFeature implementation) {
		Operation pivotOperation = PivotFactory.eINSTANCE.createOperation();
		pivotOperation.setName(eOperation.getName());
		pivotOperation.setType(type);
		pivotOperation.setImplementationClass(implementationClass);
		pivotOperation.setImplementation(implementation);
		((PivotObjectImpl)pivotOperation).setESObject(eOperation);
		return pivotOperation;
	}

	public static @NonNull Operation createOperation(@NonNull String name, @NonNull ExpressionInOCL asExpressionInOCL) {
		Operation asOperation = PivotFactory.eINSTANCE.createOperation();
		asOperation.setName(name);
		initOperation(asOperation, asExpressionInOCL);
		return asOperation;
	}

	/**
	 * @deprecated Use PivotHelper.createOperationCallExp to specialize return types.
	 */
	@Deprecated
	public static @NonNull OperationCallExp createOperationCallExp(@NonNull OCLExpression asSource, @NonNull Operation asOperation, /*@NonNull*/ OCLExpression... asArguments) {
		OperationCallExp asCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		asCallExp.setReferredOperation(asOperation);
		asCallExp.setName(asOperation.getName());
		asCallExp.setOwnedSource(asSource);
		if (asArguments != null) {
			List<OCLExpression> asCallArguments = asCallExp.getOwnedArguments();
			for (OCLExpression asArgument : asArguments) {
				asCallArguments.add(ClassUtil.nonNullState(asArgument));
			}
		}
		asCallExp.setType(asOperation.getType());
		asCallExp.setIsRequired(asOperation.isIsRequired());
		return asCallExp;
	}

	public static @NonNull OrderedSetType createOrderedSetType(@NonNull OrderedSetType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createOrderedSetType(), unspecializedType, elementType);
	}

	public static org.eclipse.ocl.pivot.@NonNull Package createOwnedPackage(@NonNull Model parentRoot, @NonNull String name) {
		@SuppressWarnings("null")
		org.eclipse.ocl.pivot.Package aPackage = PivotUtil.createPackage(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, name, null, null);
		parentRoot.getOwnedPackages().add(aPackage);
		return aPackage;
	}

	public static org.eclipse.ocl.pivot.@NonNull Package createOwnedPackage(org.eclipse.ocl.pivot.@NonNull Package parentPackage, @NonNull String name) {
		@SuppressWarnings("null")
		org.eclipse.ocl.pivot.Package aPackage = PivotUtil.createPackage(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, name, null, null);
		parentPackage.getOwnedPackages().add(aPackage);
		return aPackage;
	}

	public static org.eclipse.ocl.pivot.@NonNull Package createPackage(/*@NonNull*/ EPackage ePackage, @Nullable String nsPrefix, @NonNull String nsURI) {
		org.eclipse.ocl.pivot.Package pivotPackage = PivotFactory.eINSTANCE.createPackage();
		pivotPackage.setName(ePackage.getName());
		pivotPackage.setNsPrefix(nsPrefix);
		pivotPackage.setURI(nsURI);
		((PivotObjectImpl)pivotPackage).setESObject(ePackage);
		return pivotPackage;
	}

	public static org.eclipse.ocl.pivot.@NonNull Package createPackage(@NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI, @Nullable PackageId packageId) {
		org.eclipse.ocl.pivot.Package pivotPackage = PivotFactory.eINSTANCE.createPackage();
		pivotPackage.setName(name);
		pivotPackage.setNsPrefix(nsPrefix);
		if (packageId != null) {
			((PackageImpl)pivotPackage).setPackageId(packageId);  // FIXME Add to API
		}
		pivotPackage.setURI(nsURI);
		return pivotPackage;
	}

	public static @NonNull <T extends org.eclipse.ocl.pivot.Package> T createPackage(@NonNull Class<T> pivotClass,
			@NonNull EClass pivotEClass, @NonNull String name, @Nullable String nsURI, @Nullable PackageId packageId) {
		return createPackage(pivotClass, pivotEClass, name, nsURI, null, packageId);
	}

	/**
	 * @since 1.14
	 */
	public static @NonNull <T extends org.eclipse.ocl.pivot.Package> T createPackage(@NonNull Class<T> pivotClass,
			@NonNull EClass pivotEClass, @NonNull String name, @Nullable String nsURI, @Nullable String nsPrefix, @Nullable PackageId packageId) {
		@SuppressWarnings("unchecked")
		T asPackage = (T) pivotEClass.getEPackage().getEFactoryInstance().create(pivotEClass);
		asPackage.setName(name);
		if (packageId != null) {
			((PackageImpl)asPackage).setPackageId(packageId);
		}
		asPackage.setNsPrefix(nsPrefix);		// Before setURI accesses it.
		asPackage.setURI(nsURI);
		return asPackage;
	}

	public static @NonNull Parameter createParameter(@NonNull String name, @NonNull Type asType, boolean isRequired) {
		Parameter asParameter = PivotFactory.eINSTANCE.createParameter();
		asParameter.setName(name);
		asParameter.setType(asType);
		asParameter.setIsRequired(isRequired);
		return asParameter;
	}

	public static @NonNull Precedence createPrecedence(@NonNull String name, /*@NonNull*/ AssociativityKind kind) {
		assert kind != null;
		Precedence pivotPrecedence = PivotFactory.eINSTANCE.createPrecedence();
		pivotPrecedence.setName(name);
		pivotPrecedence.setAssociativity(kind);
		return pivotPrecedence;
	}

	/**
	 * @since 1.16
	 */
	public static @NonNull PrimitiveType createPrimitiveType(/*@NonNull*/ EDataType eDataType) {
		boolean isBoolean = eDataType.getInstanceClass() == Boolean.class;
		PrimitiveType pivotType = isBoolean ? PivotFactory.eINSTANCE.createBooleanType() : PivotFactory.eINSTANCE.createPrimitiveType();
		pivotType.setName(eDataType.getName());
		((PivotObjectImpl)pivotType).setESObject(eDataType);
		return pivotType;
	}

	public static @NonNull PrimitiveType createPrimitiveType(@NonNull String name) {
		PrimitiveType pivotType = PivotFactory.eINSTANCE.createPrimitiveType();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull Property createProperty(/*@NonNull*/ EStructuralFeature eFeature, @NonNull Type type) {
		Property pivotProperty = PivotFactory.eINSTANCE.createProperty();
		pivotProperty.setName(eFeature.getName());
		pivotProperty.setType(type);
		((PivotObjectImpl)pivotProperty).setESObject(eFeature);
		return pivotProperty;
	}

	public static @NonNull Property createProperty(@NonNull String name, @NonNull Type type) {
		Property pivotProperty = PivotFactory.eINSTANCE.createProperty();
		pivotProperty.setName(name);
		pivotProperty.setType(type);
		return pivotProperty;
	}

	public static @NonNull PropertyCallExp createPropertyCallExp(@NonNull OCLExpression asSource, @NonNull Property asProperty) {
		PropertyCallExp asChild = PivotFactory.eINSTANCE.createPropertyCallExp();
		asChild.setOwnedSource(asSource);
		asChild.setReferredProperty(asProperty);
		asChild.setType(asProperty.getType());
		asChild.setIsRequired(asProperty.isIsRequired());
		return asChild;
	}

	public static @NonNull SelfType createSelfType(@NonNull String name) {
		SelfType pivotType = PivotFactory.eINSTANCE.createSelfType();
		pivotType.setName(name);
		return pivotType;
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull SelfType createSelfType(/*@NonNull*/ EClass eClass) {
		SelfType pivotType = PivotFactory.eINSTANCE.createSelfType();
		pivotType.setName(eClass.getName());
		((PivotObjectImpl)pivotType).setESObject(eClass);
		return pivotType;
	}

	public static @NonNull SequenceType createSequenceType(@NonNull SequenceType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createSequenceType(), unspecializedType, elementType);
	}

	public static @NonNull SetType createSetType(@NonNull SetType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createSetType(), unspecializedType, elementType);
	}

	public static @NonNull TemplateBinding createTemplateBinding(TemplateParameterSubstitution... templateParameterSubstitutions) {
		TemplateBinding pivotTemplateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		List<TemplateParameterSubstitution> parameterSubstitutions = pivotTemplateBinding.getOwnedSubstitutions();
		for (TemplateParameterSubstitution templateParameterSubstitution : templateParameterSubstitutions) {
			parameterSubstitutions.add(templateParameterSubstitution);
		}
		return pivotTemplateBinding;
	}

	public static @NonNull TemplateParameter createTemplateParameter(@NonNull String name, org.eclipse.ocl.pivot.Class... lowerBounds) {
		TemplateParameter pivotTemplateParameter = PivotFactory.eINSTANCE.createTemplateParameter();
		pivotTemplateParameter.setName(name);
		if (lowerBounds != null) {
			List<org.eclipse.ocl.pivot.Class> constrainingClasses = pivotTemplateParameter.getConstrainingClasses();
			for (org.eclipse.ocl.pivot.Class lowerBound : lowerBounds) {
				constrainingClasses.add(lowerBound);
			}
		}
		return pivotTemplateParameter;
	}

	public static @NonNull TemplateParameterSubstitution createTemplateParameterSubstitution(@NonNull TemplateParameter formal, @NonNull Type actual) {
		TemplateParameterSubstitution pivotTemplateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
		pivotTemplateParameterSubstitution.setFormal(formal);
		pivotTemplateParameterSubstitution.setActual(actual);
		return pivotTemplateParameterSubstitution;
	}

	public static @NonNull TemplateSignature createTemplateSignature(@NonNull TemplateableElement templateableElement, TemplateParameter... templateParameters) {
		TemplateSignature pivotTemplateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
		List<TemplateParameter> parameters = pivotTemplateSignature.getOwnedParameters();
		for (TemplateParameter templateParameter : templateParameters) {
			parameters.add(templateParameter);
		}
		pivotTemplateSignature.setOwningElement(templateableElement);
		return pivotTemplateSignature;
	}

	public static @NonNull TupleType createTupleType(@NonNull String name, Property... properties) {
		TupleType pivotType = PivotFactory.eINSTANCE.createTupleType();
		pivotType.setName(name);
		List<Property> ownedProperties = pivotType.getOwnedProperties();
		for (Property property : properties) {
			ownedProperties.add(property);
		}
		return pivotType;
	}

	public static @NonNull String createTupleValuedConstraint(@NonNull String statusText, @Nullable Integer severity, @Nullable String messageText) {
		if ((severity == null) && (messageText == null)) {
			return statusText;
		}
		StringBuilder s = new StringBuilder();
		s.append("Tuple {");
		if (messageText != null) {
			s.append("\n\t" + PivotConstants.MESSAGE_PART_NAME + " : String = " + messageText + ",");
		}
		if (severity != null) {
			s.append("\n\t" + PivotConstants.SEVERITY_PART_NAME + " : Integer = " + severity + ",");
		}
		s.append("\n\t" + PivotConstants.STATUS_PART_NAME + " : Boolean = " + statusText);		// NB parts in alphabetical order
		s.append("\n}."+ PivotConstants.STATUS_PART_NAME);
		return s.toString();
	}

	/** @deprecated Use appropriate derived Variable */
	@Deprecated
	public static @NonNull Variable createVariable(@NonNull String name, @NonNull OCLExpression asInitExpression) {
		Variable asVariable = PivotFactory.eINSTANCE.createVariable();
		asVariable.setName(name);
		asVariable.setType(asInitExpression.getType());
		asVariable.setIsRequired(asInitExpression.isIsRequired());
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	/** @deprecated Use appropriate derived Variable */
	@Deprecated
	public static @NonNull Variable createVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression asInitExpression) {
		Variable asVariable = PivotFactory.eINSTANCE.createVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull VariableExp createVariableExp(@NonNull VariableDeclaration asVariable) {
		VariableExp asVariableExp = PivotFactory.eINSTANCE.createVariableExp();
		asVariableExp.setReferredVariable(asVariable);
		asVariableExp.setName(asVariable.getName());
		asVariableExp.setType(asVariable.getType());
		asVariableExp.setIsRequired(asVariable.isIsRequired());
		return asVariableExp;
	}
	/** @deprecated API preserving redundancy */
	@Deprecated
	public static @NonNull VariableExp createVariableExp(@NonNull Variable asVariable) {
		return createVariableExp((VariableDeclaration)asVariable);
	}

	public static @NonNull VoidType createVoidType(@NonNull String name) {
		VoidType pivotType = PivotFactory.eINSTANCE.createVoidType();
		pivotType.setName(name);
		return pivotType;
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull VoidType createVoidType(/*@NonNull*/ EClass eClass) {
		VoidType pivotType = PivotFactory.eINSTANCE.createVoidType();
		pivotType.setName(eClass.getName());
		((PivotObjectImpl)pivotType).setESObject(eClass);
		return pivotType;
	}

	public static void debugObjectUsage(String prefix, EObject element) {
		StringBuilder s = new StringBuilder();
		s.append(prefix);
		if (element != null) {
			s.append(element.eClass().getName());
			s.append("@");
			s.append(Integer.toHexString(element.hashCode()));
			Resource eResource = element.eResource();
			if (eResource != null) {
				if (element instanceof Element) {
					s.append(" ");
					s.append(AS2Moniker.toString((Element) element));
				}
				s.append(" ");
				s.append(eResource.getURI());
			}
			else if (element instanceof NamedElement) {
				s.append(" ");
				s.append(String.valueOf(((NamedElement) element).getName()));
			}
		}
		else {
			s.append("null");
		}
		System.out.println(s.toString());
	}

	public static boolean debugWellContainedness(Type type) {
		if (type.eResource() == null) {
			debugObjectUsage("Badly contained ", type);
			return false;
		}
		if (type instanceof CollectionType) {
			Type elementType = ((CollectionType)type).getElementType();
			if ((elementType != null) && !debugWellContainedness(elementType)) {
				debugObjectUsage("Badly contained ", type);
				return false;
			}
		}
		return true;
	}

	public static String formatDiagnostics(@NonNull Diagnostic diagnostic, @NonNull String newLine) {
		StringBuilder s = new StringBuilder();
		formatDiagnostic(s, diagnostic, newLine);
		return s.toString();
	}

	public static void formatDiagnostic(@NonNull StringBuilder s, @NonNull Diagnostic diagnostic, @NonNull String newLine) {
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			s.append(newLine);
			s.append(diagnostic.getSeverity() + " - ");
			String location = diagnostic.getSource();
			if (location != null) {
				s.append(location);
				s.append(": ");
			}
			s.append(diagnostic.getMessage());
		/*	for (Object obj : diagnostic.getData()) {
				s.append(newLine);
				s.append("\t");
				//				if (obj instanceof Throwable) {
				//					s.append(((Throwable)obj).getMessage());
				//				}
				//				else {
				s.append(obj);
				//				}
			} */
			List<?> datas = diagnostic.getData();
			if (datas != null) {
				for (Object data : datas) {
					if (data instanceof Throwable)  {
						Throwable cause = ((Throwable)data).getCause();
					//	if ((cause != null) && (cause != data)) {
							s.append(newLine + "\t" + (cause != null ? cause : data).toString());
					//	}
					}
				}
			}
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				if (childDiagnostic != null) {
					String childNewLine = newLine + "\t";
					formatDiagnostic(s, childDiagnostic, childNewLine);
				}
			}
		}
	}

	public static String formatResourceDiagnostics(@NonNull List<Resource.Diagnostic> diagnostics, @NonNull String messagePrefix, @NonNull String newLine) {
		if (diagnostics.size() <= 0) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		s.append(messagePrefix);
		for (Resource.Diagnostic diagnostic : diagnostics) {
			if (diagnostic instanceof Diagnostic) {
				formatDiagnostic(s, (Diagnostic)diagnostic, newLine);
			}
			else {
				s.append(newLine);
				String location = diagnostic.getLocation();
				if (location != null) {
					s.append(location);
					s.append(":");
				}
				s.append(diagnostic.getLine());
				try {
					int column = diagnostic.getColumn();
					if (column > 0) {
						s.append(":");
						s.append(column);
					}
				} catch (Exception e) {}	// UnsupportedOperationException was normal for Bug 380232 fixed in Xtext 2.9
				s.append(": ");
				s.append(diagnostic.getMessage());
				if (diagnostic instanceof DiagnosticWrappedException)  {
					Throwable cause = ((DiagnosticWrappedException)diagnostic).getCause();
					if ((cause != null) && (cause != diagnostic)) {
						s.append(" - " + cause.toString());
					}
				}
			}
		}
		return s.toString();
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Element getActual(@NonNull TemplateParameterSubstitution templateParameterSubstitution) {
		return ClassUtil.nonNullState(templateParameterSubstitution.getActual());
	}

	/**
	 * @since 1.13
	 */
	public static org.eclipse.ocl.pivot.@Nullable Class getBehavioralClass(@NonNull StandardLibrary standardLibrary, @NonNull Class<?> instanceClass) {
		if (instanceClass == boolean.class) {
			return standardLibrary.getBooleanType();
		}
		if (instanceClass == byte.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == char.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == double.class) {
			return standardLibrary.getRealType();
		}
		if (instanceClass == float.class) {
			return standardLibrary.getRealType();
		}
		if (instanceClass == int.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == long.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == short.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == BigDecimal.class) {
			return standardLibrary.getRealType();
		}
		if (instanceClass == BigInteger.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == Boolean.class) {
			return standardLibrary.getBooleanType();
		}
		if (instanceClass == Byte.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == Character.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == Double.class) {
			return standardLibrary.getRealType();
		}
		if (instanceClass == Float.class) {
			return standardLibrary.getRealType();
		}
		if (instanceClass == Integer.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == Long.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == Short.class) {
			return standardLibrary.getIntegerType();
		}
		if (instanceClass == String.class) {
			return standardLibrary.getStringType();
		}
		return null;
	}

	/**
	 * @since 1.7
	 */
	@Deprecated /* @deprecated no longer used = behavioralType() now handled within Type::conformsTo */
	public static @NonNull Type getBehavioralReturnType(@NonNull Type type) {
		return getBehavioralType(getReturnType(type));
	}

	/**
	 * @since 1.7
	 */
	@Deprecated /* @deprecated no longer used = behavioralType() now handled within Type::conformsTo */
	public static @NonNull Type getBehavioralType(@NonNull Type type) {
		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			Type asElementType = collectionType.getElementType();
			if (asElementType != null) {
				Type behavioralElementType = getBehavioralType(asElementType);
				assert behavioralElementType != null;
				if (behavioralElementType != asElementType) {
					EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
					if (environmentFactory != null) {
						CollectionType unspecializedElement = (CollectionType)collectionType.getUnspecializedElement();
						assert unspecializedElement != null;
						boolean isNullFree = collectionType.isIsNullFree();
						IntegerValue lowerValue = collectionType.getLowerValue();
						UnlimitedNaturalValue upperValue = collectionType.getUpperValue();
						return environmentFactory.getCompleteEnvironment().getCollectionType(unspecializedElement, behavioralElementType, isNullFree, lowerValue, upperValue);
					}
				}
			}
		}
		else if (type instanceof DataType) {
			org.eclipse.ocl.pivot.Class behavioralClass = ((DataType)type).getBehavioralClass();
			return behavioralClass != null ? behavioralClass : type;
		}
		return type;
	}

	/**
	 * @since 1.7
	 */
	@Deprecated /* @deprecated no longer used = behavioralType() now handled within Type::conformsTo */
	public static @Nullable Type getBehavioralType(@Nullable TypedElement element) {
		Type type = element != null ? PivotUtilInternal.getType(element) : null;
		return type != null ? getBehavioralType(type) : null;
	}

	/**
	 * @since 1.7
	 */
	public static org.eclipse.ocl.pivot.@NonNull Class getClass(@NonNull Type type, @NonNull StandardLibrary standardLibrary) {
		if (type instanceof org.eclipse.ocl.pivot.Class) {
			return (org.eclipse.ocl.pivot.Class)type;
		}
		else if (type instanceof TemplateParameter) {
			return getLowerBound((TemplateParameter)type, standardLibrary.getOclAnyType());
		}
		return standardLibrary.getOclVoidType();			// Never happens
	}

	/**
	 * Return the type of a TypedElement, exploiting the known non-null and non-TypeParameter characteristics.
	 * @throws IllegalStateException for a null type
	 * @throws ClassCastException for a TypeParameter
	 *
	 * @since 1.3
	 */
	public static org.eclipse.ocl.pivot.@NonNull Class getClass(@NonNull TypedElement typedElement) {
		return ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)typedElement.getType());
	}

	public static @Nullable Constraint getContainingConstraint(@Nullable Element element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Constraint) {
				return (Constraint)eObject;
			}
		}
		return null;
	}

	public static @Nullable ExpressionInOCL getContainingExpressionInOCL(@Nullable Element element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ExpressionInOCL) {
				return (ExpressionInOCL)eObject;
			}
		}
		return null;
	}

	public static @Nullable Model getContainingModel(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Model) {
				return (Model)eObject;
			}
		}
		return null;
	}

	public static @Nullable Namespace getContainingNamespace(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Namespace) {
				return (Namespace)eObject;
			}
		}
		return null;
	}

	public static @Nullable Operation getContainingOperation(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Operation) {
				return (Operation)eObject;
			}
		}
		return null;
	}

	public static org.eclipse.ocl.pivot.@Nullable Package getContainingPackage(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				return (org.eclipse.ocl.pivot.Package)eObject;
			}
		}
		return null;
	}

	/**
	 * @deprecated use getContainingModel
	 */
	@Deprecated
	public static @Nullable Model getContainingRoot(@Nullable EObject element) {
		return getContainingModel(element);
	}

	public static @Nullable Type getContainingType(@Nullable EObject element) {
		if (element != null) {
			EObject eObject = element;
			while (true) {
				if (eObject instanceof Type) {
					return (Type)eObject;
				}
				EObject eContainer = eObject.eContainer();
				if (eContainer == null) {
					if (eObject instanceof ExpressionInOCL) {
						return ((ExpressionInOCL)eObject).getOwnedContext().getType();
					}
					break;
				}
				eObject = eContainer;
			}
		}
		return null;
	}

	/**
	 * Return the number of containers of eObject, 0 if eObject is a root.
	 */
	public static int getContainmentDepth(EObject eObject) {
		int depth = 0;
		for (EObject eContainer = eObject.eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			depth++;
			if (depth > 100000) {
				return depth;
			}
		}
		return depth;
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Type getContextType(@NonNull LambdaType lambdaType) {
		return ClassUtil.nonNullState(lambdaType.getContextType());
	}

	/**
	 * Return the Java Class used by Ecore for elements of asProperty, or null if not known.
	 */
	public static @Nullable Class<?> getEcoreInstanceClass(@Nullable Property asProperty) {
		Class<?> instanceClass = null;
		if (asProperty != null) {
			EObject eTarget = asProperty.getESObject();
			if (eTarget instanceof EStructuralFeature) {
				EClassifier eType = ((EStructuralFeature)eTarget).getEType();
				if (eType != null) {
					instanceClass = eType.getInstanceClass();
				}
			}
		}
		return instanceClass;
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Type getElementType(@NonNull CollectionType collectionType) {
		return ClassUtil.nonNullState(collectionType.getElementType());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Type getElementalType(@NonNull Type type) {
		Type elementType = type;
		while (elementType instanceof CollectionType) {
			elementType = ((CollectionType)elementType).getElementType();
			assert elementType != null;
		}
		return elementType;
	}

	/**
	 * Locate an OCL Executor from the Resource containing an eObject, else create a default one.
	 *
	 * @since 1.7
	 */
	public static @NonNull Executor getExecutor(@Nullable EObject eObject) {
		Executor executor = ThreadLocalExecutor.basicGetExecutor();
		if (executor != null) {
			return executor;
		}
		if (eObject != null) {
			EnvironmentFactory environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
			if (environmentFactory != null) {
				executor = new PivotExecutorManager(environmentFactory, eObject);
			}
		}
		if (executor == null) {
			executor = new EcoreExecutorManager(eObject, PivotTables.LIBRARY);
		}
		ThreadLocalExecutor.setExecutor(executor);
		return executor;
	}

	/**
	 * Locate an OCL Executor from the Executor.class slot in validationContext, else
	 * from the Resource containing an eObject, else create a default one.
	 *
	 * The returned executor is cached at the Executor.class slot in validationContext for re-use.
	 *
	 * @since 1.7
	 */
	@Deprecated /* @deprecated validationContext no longer used */
	public static @NonNull Executor getExecutor(@NonNull EObject eObject, @Nullable Map<Object, Object> validationContext) {
		return getExecutor(eObject);
	}

	/**
	 * @since 1.10
	 */
	public static @NonNull Set<org.eclipse.ocl.pivot.@NonNull Package> getImportedPackageClosure(@NonNull CompleteModel completeModel, org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		Set<org.eclipse.ocl.pivot.@NonNull Package> importedPackageClosure = new HashSet<>();
		getImportedPackageClosure(completeModel, importedPackageClosure, asPackage);
		return importedPackageClosure;
	}

	private static void getImportedPackageClosure(@NonNull CompleteModel completeModel, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Package> importedPackageClosure, org.eclipse.ocl.pivot.@NonNull Package targetPackage) {
		if (importedPackageClosure.add(targetPackage)) {
			CompletePackage completePackage = completeModel.getCompletePackage(targetPackage);
			for (org.eclipse.ocl.pivot.@NonNull Package partialPackage : PivotUtil.getPartialPackages(completePackage)) {
				for (org.eclipse.ocl.pivot.@NonNull Package importedPackage : PivotUtil.getImportedPackages(partialPackage)) {
					getImportedPackageClosure(completeModel, importedPackageClosure, importedPackage);
				}
			}
		}
	}

	/**
	 * @since 1.10
	 */
	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> getImportedPackages(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		return ClassUtil.nullFree(asPackage.getImportedPackages());
	}

	/**
	 * @since 1.7
	 */
	public static @NonNull Type getKeyType(@NonNull MapType mapType) {
		return ClassUtil.nonNullState(mapType.getKeyType());
	}

	/**
	 * @since 1.7
	 */
	public static org.eclipse.ocl.pivot.@NonNull Class getLowerBound(@NonNull TemplateParameter templateParameter, org.eclipse.ocl.pivot.@NonNull Class oclAnyType) {
		org.eclipse.ocl.pivot.Class lowerBound = basicGetLowerBound(templateParameter);
		return lowerBound != null ? lowerBound : oclAnyType;
	}

	/**
	 * Return the Model at the root of asResource.
	 *
	 * @throws IllegalStateException if none.
	 *
	 * @since 1.3
	 */
	public static @NonNull Model getModel(@NonNull Resource asResource) {
		for (EObject eObject : asResource.getContents()) {
			if (eObject instanceof Model) {
				return (Model)eObject;
			}
		}
		throw new IllegalStateException();
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull String getMultiplicity(@NonNull TypedElement typedElement) {
		StringBuilder s = new StringBuilder();
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			Number lower = collectionType.getLower();
			Number upper = collectionType.getUpper();
			StringUtil.appendMultiplicity(s, lower.intValue(), upper instanceof Unlimited ? -1 : upper.intValue(), collectionType.isIsNullFree());
		}
		else {
			s.append(typedElement.isIsRequired() ? "[1]" : "[?]");
		}
		return s.toString();
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull String getName(@NonNull NamedElement namedElement) {
		return ClassUtil.nonNullState(namedElement.getName());
	}

	public static @Nullable Namespace getNamespace(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Model) {
				return null;
			}
			if (eObject instanceof Type) {
				return (Namespace) eObject;
			}
			if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				return (Namespace) eObject;
			}
		}
		return null;
	}

	public static @NonNull String getNavigationOperator(boolean isSafe, boolean isAggregate) {
		if (isAggregate) {
			return isSafe ? PivotConstants.SAFE_AGGREGATE_NAVIGATION_OPERATOR : PivotConstants.AGGREGATE_NAVIGATION_OPERATOR;
		}
		else {
			return isSafe ? PivotConstants.SAFE_OBJECT_NAVIGATION_OPERATOR : PivotConstants.OBJECT_NAVIGATION_OPERATOR;
		}
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Property getOpposite(@NonNull Property asProperty) {
		return ClassUtil.nonNullState(asProperty.getOpposite());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull Parameter> getOwnedAccumulators(@NonNull Iteration iteration) {
		return ClassUtil.nullFree(iteration.getOwnedAccumulators());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedArgument(@NonNull OperationCallExp object, int index) {
		return ClassUtil.nonNullState(object.getOwnedArguments().get(index));
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull OCLExpression> getOwnedArguments(@NonNull OperationCallExp operationCallExp) {
		return ClassUtil.nullFree(operationCallExp.getOwnedArguments());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull TemplateBinding> getOwnedBindings(@NonNull TemplateableElement asElement) {
		return ClassUtil.nullFree(asElement.getOwnedBindings());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedBody(@NonNull ExpressionInOCL asExpression) {
		return ClassUtil.nonNullState(asExpression.getOwnedBody());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedBody(@NonNull LoopExp loopExp) {
		return ClassUtil.nonNullState(loopExp.getOwnedBody());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> getOwnedClasses(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		return ClassUtil.nullFree(asPackage.getOwnedClasses());
	}

	/**
	 * @since 1.3
	 */
	@Deprecated /* @deprecated this is a crazy typo */
	public static @NonNull Iterable<@NonNull Operation> getOwnedClasses(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		return ClassUtil.nullFree(asClass.getOwnedOperations());
	}

	/**
	 * @since 1.6
	 */
	public static @NonNull Iterable<@NonNull IteratorVariable> getOwnedCoIterators(@NonNull LoopExp loopExp) {
		return ClassUtil.nullFree(loopExp.getOwnedCoIterators());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull CompleteClass> getOwnedCompleteClasses(@NonNull CompletePackage completePackage) {
		return ClassUtil.nullFree(completePackage.getOwnedCompleteClasses());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull CompletePackage> getOwnedCompletePackages(@NonNull CompletePackage completePackage) {
		return ClassUtil.nullFree(completePackage.getOwnedCompletePackages());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull Comment> getOwnedComments(@NonNull Element asElement) {
		return ClassUtil.nullFree(asElement.getOwnedComments());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedCondition(@NonNull IfExp ifExp) {
		return ClassUtil.nonNullState(ifExp.getOwnedCondition());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull VariableDeclaration getOwnedContext(@NonNull ExpressionInOCL asExpression) {
		return ClassUtil.nonNullState(asExpression.getOwnedContext());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedElse(@NonNull IfExp ifExp) {
		return ClassUtil.nonNullState(ifExp.getOwnedElse());
	}

	/**
	 * @since 1.18
	 */
	public static @NonNull Iterable<@NonNull ElementExtension> getOwnedExtensions(Element asElement) {
		return ClassUtil.nullFree(asElement.getOwnedExtensions());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedFirst(@NonNull CollectionRange collectionRange) {
		return ClassUtil.nonNullState(collectionRange.getOwnedFirst());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull Import> getOwnedImports(@NonNull Model asModel) {
		return ClassUtil.nullFree(asModel.getOwnedImports());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedIn(@NonNull LetExp letExp) {
		return ClassUtil.nonNullState(letExp.getOwnedIn());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedInit(@NonNull ShadowPart shadowPart) {
		return ClassUtil.nonNullState(shadowPart.getOwnedInit());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedInit(@NonNull Variable variable) {
		return ClassUtil.nonNullState(variable.getOwnedInit());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull Constraint> getOwnedInvariants(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		return ClassUtil.nullFree(asClass.getOwnedInvariants());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedItem(@NonNull CollectionItem collectionItem) {
		return ClassUtil.nonNullState(collectionItem.getOwnedItem());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull Parameter> getOwnedIterators(@NonNull Iteration iteration) {
		return ClassUtil.nullFree(iteration.getOwnedIterators());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull Variable> getOwnedIterators(@NonNull LoopExp loopExp) {
		return ClassUtil.nullFree(loopExp.getOwnedIterators());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedKey(@NonNull MapLiteralPart mapLiteralPart) {
		return ClassUtil.nonNullState(mapLiteralPart.getOwnedKey());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedLast(@NonNull CollectionRange collectionRange) {
		return ClassUtil.nonNullState(collectionRange.getOwnedLast());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull Operation> getOwnedOperations(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		return ClassUtil.nullFree(asClass.getOwnedOperations());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> getOwnedPackages(@NonNull Model asModel) {
		return ClassUtil.nullFree(asModel.getOwnedPackages());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> getOwnedPackages(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		return ClassUtil.nullFree(asPackage.getOwnedPackages());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Parameter getOwnedParameter(@NonNull Operation operation, int index) {
		return ClassUtil.nonNullState(operation.getOwnedParameters().get(index));
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull Parameter> getOwnedParameters(@NonNull Operation operation) {
		return ClassUtil.nullFree(operation.getOwnedParameters());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull TemplateParameter> getOwnedParameters(@NonNull TemplateSignature templateSignature) {
		return ClassUtil.nullFree(templateSignature.getOwnedParameters());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull CollectionLiteralPart> getOwnedParts(@NonNull CollectionLiteralExp asCollectionLiteralExp) {
		return ClassUtil.nullFree(asCollectionLiteralExp.getOwnedParts());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull TupleLiteralPart> getOwnedParts(@NonNull TupleLiteralExp asTupleLiteralExp) {
		return ClassUtil.nullFree(asTupleLiteralExp.getOwnedParts());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull Constraint> getOwnedPostconditions(@NonNull Operation asOperation) {
		return ClassUtil.nullFree(asOperation.getOwnedPostconditions());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull Constraint> getOwnedPreconditions(@NonNull Operation asOperation) {
		return ClassUtil.nullFree(asOperation.getOwnedPreconditions());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull Property> getOwnedProperties(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		return ClassUtil.nullFree(asClass.getOwnedProperties());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Variable getOwnedResult(@NonNull IterateExp iterateExp) {
		return ClassUtil.nonNullState(iterateExp.getOwnedResult());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedSource(@NonNull CallExp object) {
		return ClassUtil.nonNullState(object.getOwnedSource());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull TemplateParameterSubstitution> getOwnedSubstitutions(@NonNull TemplateBinding asTemplateBinding) {
		return ClassUtil.nullFree(asTemplateBinding.getOwnedSubstitutions());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedThen(@NonNull IfExp ifExp) {
		return ClassUtil.nonNullState(ifExp.getOwnedThen());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLExpression getOwnedValue(@NonNull MapLiteralPart mapLiteralPart) {
		return ClassUtil.nonNullState(mapLiteralPart.getOwnedValue());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull /*Let*/Variable getOwnedVariable(@NonNull LetExp letExp) {
		return ClassUtil.nonNullState(letExp.getOwnedVariable());
	}

	/**
	 * @since 1.3
	 */
	public static org.eclipse.ocl.pivot.@NonNull Class getOwningClass(@NonNull Operation operation) {
		return ClassUtil.nonNullState(operation.getOwningClass());
	}

	/**
	 * @since 1.3
	 */
	public static org.eclipse.ocl.pivot.@NonNull Class getOwningClass(@NonNull Property property) {
		return ClassUtil.nonNullState(property.getOwningClass());
	}

	/**
	 * @since 1.9
	 */
	public static @NonNull TemplateableElement getOwningElement(@NonNull TemplateSignature templateSignature) {
		return ClassUtil.nonNullState(templateSignature.getOwningElement());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Enumeration getOwningEnumeration(@NonNull EnumerationLiteral enumerationLiteral) {
		return ClassUtil.nonNullState(enumerationLiteral.getOwningEnumeration());
	}

	/**
	 * @since 1.3
	 */
	public static org.eclipse.ocl.pivot.@NonNull Package getOwningPackage(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		return ClassUtil.nonNullState(asClass.getOwningPackage());
	}

	/**
	 * @since 1.9
	 */
	public static @NonNull TemplateSignature getOwningSignature(@NonNull TemplateParameter asTemplateParameter) {
		return ClassUtil.nonNullState(asTemplateParameter.getOwningSignature());
	}

	public static org.eclipse.ocl.pivot.@Nullable Package getPackage(@NonNull EObject object) {
		for (EObject eObject = object; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				return (org.eclipse.ocl.pivot.Package)eObject;
			}
		}
		return null;
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull List<@NonNull Type> getParameterType(@NonNull LambdaType lambdaType) {
		return ClassUtil.nullFree(lambdaType.getParameterType());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> getPartialClasses(@NonNull CompleteClass completeClass) {
		return ClassUtil.nullFree(completeClass.getPartialClasses());
	}

	/**
	 * @since 1.10
	 */
	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> getPartialPackages(@NonNull CompletePackage completePackage) {
		return ClassUtil.nullFree(completePackage.getPartialPackages());
	}

	public static @Nullable <T extends Element> T getPivot(@NonNull Class<T> pivotClass, @Nullable Pivotable pivotableElement) {
		if (pivotableElement == null) {
			return null;
		}
		Element pivotElement = pivotableElement.getPivot();
		if (pivotElement == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException(pivotElement.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iterable<@NonNull Operation> getRedefinedOperations(@NonNull Operation operation) {
		return ClassUtil.nullFree(operation.getRedefinedOperations());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<@NonNull Property> getRedefinedProperties(@NonNull Property property) {
		return ClassUtil.nullFree(property.getRedefinedProperties());
	}

	public static Feature getReferredFeature(CallExp callExp) {
		Feature feature = null;
		if (callExp instanceof LoopExp) {
			feature = ((LoopExp)callExp).getReferredIteration();
		}
		else if (callExp instanceof OperationCallExp) {
			feature = ((OperationCallExp)callExp).getReferredOperation();
		}
		else if (callExp instanceof OppositePropertyCallExp) {
			Property referredOppositeProperty = ((OppositePropertyCallExp)callExp).getReferredProperty();
			feature = referredOppositeProperty != null ? referredOppositeProperty.getOpposite() : null;
		}
		else if (callExp instanceof PropertyCallExp) {
			feature = ((PropertyCallExp)callExp).getReferredProperty();
		}
		return feature;
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Iteration getReferredIteration(@NonNull LoopExp loopExp) {
		return ClassUtil.nonNullState(loopExp.getReferredIteration());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull EnumerationLiteral getReferredLiteral(@NonNull EnumLiteralExp enumLiteralExp) {
		return ClassUtil.nonNullState(enumLiteralExp.getReferredLiteral());
	}

	public static @NonNull Operation getReferredOperation(@NonNull CallExp callExp) {
		if (callExp instanceof LoopExp) {
			return ClassUtil.nonNullState(((LoopExp)callExp).getReferredIteration());
		}
		else if (callExp instanceof OperationCallExp) {
			return ClassUtil.nonNullState(((OperationCallExp)callExp).getReferredOperation());
		}
		else {
			throw new IllegalStateException();
		}
	}

	/**
	 * @since 1.1
	 */
	public static @NonNull Property getReferredProperty(@NonNull NavigationCallExp navigationCallExp) {
		if (navigationCallExp instanceof PropertyCallExp) {
			return ClassUtil.nonNullState(((PropertyCallExp)navigationCallExp).getReferredProperty());
		}
		else if (navigationCallExp instanceof OppositePropertyCallExp) {
			Property referredProperty = ClassUtil.nonNullState(((OppositePropertyCallExp)navigationCallExp).getReferredProperty());
			if (referredProperty.eIsProxy() ) {
				throw new IllegalStateException("Unresolved referred property proxy '" + EcoreUtil.getURI(referredProperty) + "' at '" + EcoreUtil.getURI(navigationCallExp) + "'");
			}
			return ClassUtil.nonNullState(referredProperty.getOpposite());
		}
		else {
			throw new IllegalStateException();
		}
	}

	/**
	 * @since 1.10
	 */
	public static @NonNull Property getReferredProperty(@NonNull ShadowPart shadowPart) {
		return ClassUtil.nonNullState(shadowPart.getReferredProperty());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Type getReferredType(@NonNull TypeExp typeExp) {
		return ClassUtil.nonNullState(typeExp.getReferredType());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull VariableDeclaration getReferredVariable(@NonNull VariableExp variableExp) {
		return ClassUtil.nonNullState(variableExp.getReferredVariable());
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Resource getResource(@NonNull EObject eObject) {
		return ClassUtil.nonNullState(eObject.eResource());
	}

	/**
	 * @since 1.7
	 */
	@Deprecated /* @deprecated no longer used = behavioralType() now handled within Type::conformsTo */
	public static @NonNull Type getReturnType(@NonNull Type type) {
		return PivotUtilInternal.getNonLambdaType(type);
	}

	/**
	 * @since 1.4
	 */
	public static int getSeverity(@NonNull EnvironmentFactory environmentFactory) {
		Severity severity = environmentFactory.getValue(PivotValidationOptions.EcoreValidation);
		if (severity != null) {
			switch (severity) {
				case ERROR: return Diagnostic.ERROR;
				case IGNORE: return Diagnostic.OK;
				case INFO: return Diagnostic.INFO;
				case WARNING: return Diagnostic.WARNING;
			}
		}
		return Diagnostic.ERROR;
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> getSuperClasses(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		return ClassUtil.nullFree(asClass.getSuperClasses());
	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Type getResultType(@NonNull LambdaType lambdaType) {
		return ClassUtil.nonNullState(lambdaType.getResultType());
	}

	/**
	 * @since 1.18
	 */
	public static @Nullable List<@NonNull TemplateParameter> getTemplateParameters(@NonNull Element element) {
		List<@NonNull TemplateParameter> templateParameters = null;
		EObject eContainer = element.eContainer();
		if (eContainer instanceof Element) {
			templateParameters = getTemplateParameters((Element) eContainer);
		}
		if (element instanceof TemplateableElement) {
			TemplateSignature templateSignature = ((TemplateableElement)element).getOwnedSignature();
			if (templateSignature != null) {
				List<@NonNull TemplateParameter> ownedParameters = PivotUtilInternal.getOwnedParametersList(templateSignature);
				if (ownedParameters.size() > 0) {
					if (templateParameters == null) {
						templateParameters = new ArrayList<>();
					}
					templateParameters.addAll(ownedParameters);
				}
			}
		}
		return templateParameters;
	}

	/**
	 * Return the type of a TypedElement, exploiting the known non-null characteristics.
	 * @throws IllegalStateException for a null type
	 *
	 * @since 1.3
	 */
	public static @NonNull Type getType(@NonNull TypedElement typedElement) {
		return ClassUtil.nonNullState(typedElement.getType());
	}

	/**
	 * Return the type of a TupleLiteralExp, exploiting the known non-null characteristics.
	 * @throws IllegalStateException for a null type
	 *
	 * @since 1.3
	 */
	public static @NonNull TupleType getType(@NonNull TupleLiteralExp tupleLiteralExp) {
		return ClassUtil.nonNullState((TupleType)tupleLiteralExp.getType());
	}

	public static @NonNull <T extends TemplateableElement> T getUnspecializedTemplateableElement(@NonNull T templateableElement) {
		//		if (templateableElement == null) {
		//			return null;
		//		}
		TemplateableElement unspecializedElement = templateableElement.getUnspecializedElement();
		if (unspecializedElement == null) {
			return templateableElement;
		}
		@SuppressWarnings("unchecked")
		T castUnspecializedElement = (T) unspecializedElement;
		return castUnspecializedElement;
	}

	/**
	 * @since 1.7
	 */
	public static @NonNull Type getValueType(@NonNull MapType mapType) {
		return ClassUtil.nonNullState(mapType.getValueType());
	}

	public static @NonNull Operation initOperation(@NonNull Operation asOperation, @NonNull ExpressionInOCL asExpressionInOCL) {
		for (Variable asParameterVariable : asExpressionInOCL.getOwnedParameters()) {
			String parameterName = ClassUtil.nonNullState(asParameterVariable.getName());
			Type parameterType = ClassUtil.nonNullState(asParameterVariable.getType());
			Parameter asParameter = createParameter(parameterName, parameterType, asParameterVariable.isIsRequired());
			asParameterVariable.setRepresentedParameter(asParameter);
			asOperation.getOwnedParameters().add(asParameter);
		}
		asOperation.setBodyExpression(asExpressionInOCL);
		asOperation.setType(asExpressionInOCL.getType());
		asOperation.setIsRequired(asExpressionInOCL.isIsRequired());
		return asOperation;
	}

	/**
	 * The default ResourceSet.getLoadOptions() do not support loading models that reference themselves.
	 * Setting XMLResource.OPTION_DEFER_IDREF_RESOLUTION to true avoids this problem.
	 * See Bug 499442.
	 * @since 1.3
	 */
	public static void initializeLoadOptionsToSupportSelfReferences(@NonNull ResourceSet resourceSet) {
		resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
	}

	/**
	 * Return true if type uses an aggregate (-&gt;) rather than object (.) navigation operator.
	 */
	public static boolean isAggregate(Type type) {
		return (type instanceof CollectionType) || (type instanceof MapType);
	}

	public static boolean isAggregateNavigationOperator(/*@NonNull*/ String operatorName) {
		return PivotConstants.AGGREGATE_NAVIGATION_OPERATOR.equals(operatorName)
				|| PivotConstants.SAFE_AGGREGATE_NAVIGATION_OPERATOR.equals(operatorName);
	}

	/**
	 * @since 1.11
	 */
	public static boolean isDataType(@NonNull CompleteClass completeClass) {
		return completeClass.getPrimaryClass() instanceof DataType;
	}

	public static boolean isObjectNavigationOperator(/*@NonNull*/ String operatorName) {
		return PivotConstants.OBJECT_NAVIGATION_OPERATOR.equals(operatorName)
				|| PivotConstants.SAFE_OBJECT_NAVIGATION_OPERATOR.equals(operatorName);
	}

	public static boolean isSafeNavigationOperator(/*@NonNull*/ String operatorName) {
		return PivotConstants.SAFE_AGGREGATE_NAVIGATION_OPERATOR.equals(operatorName)
				|| PivotConstants.SAFE_OBJECT_NAVIGATION_OPERATOR.equals(operatorName);
	}

	/**
	 * @since 1.1
	 */
	public static boolean isSameOperation(@NonNull OperationId operationId1, @NonNull OperationId operationId2) {
		if (operationId1 == operationId2) {
			return true;
		}
		if (!operationId1.getName().equals(operationId2.getName())) {
			return false;
		}
		if (!operationId1.getParametersId().equals(operationId2.getParametersId())) {
			return false;
		}
		return true;
	}

	/**
	 * Replace oldChild at its eContainer.eContainmentFeature by newChild.
	 * @since 1.3
	 */
	public static void replaceChild(@NonNull EObject oldChild, @NonNull EObject newChild) {
		EObject eContainer = oldChild.eContainer();
		EReference eContainmentFeature = oldChild.eContainmentFeature();
		if (eContainmentFeature.isMany()) {
			@SuppressWarnings("unchecked") EList<EObject> list = (EList<EObject>)eContainer.eGet(eContainmentFeature);
			int index = list.indexOf(oldChild);
			assert index >= 0;
			PivotUtilInternal.resetContainer(oldChild);
			list.add(index, newChild);
		}
		else {
			PivotUtilInternal.resetContainer(oldChild);
			eContainer.eSet(eContainmentFeature, newChild);
		}
	}

	/**
	 * Remove any OCL Executor from the ResourceSet containing an eObject. This may be necessary to prevent
	 * re-use of the cached context of an earlier executor after a change to the models.
	 *
	 * @since 1.7
	 *
	 * @deprecated use resetExecutor
	 */
	@Deprecated
	public static void removeExecutor(@NonNull EObject eObject) {
		Resource eResource = eObject.eResource();
		if (eResource != null) {
			ResourceSet resourceSet = eResource.getResourceSet();
			if (resourceSet != null) {
				PivotExecutorManager.removeAdapter(resourceSet);
			}
		}
		resetExecutor();
	}

	/**
	 * Eliminate the executor for this thread in order to force a new Executor and ModelManager to be
	 * created. This is necessary to lose the caches created prior to a model change. It may also be
	 * invoked to avoid waiting for a stale Exector to be garbage collected.
	 *
	 * @since 1.14
	 */
	public static void resetExecutor() {
		ThreadLocalExecutor.reset();
	}

	/**
	 * Rewrite asTree and all its descendants to replace all "?." and "?->" navigations by their safe counterparts.
	 * @since 1.3
	 * @deprecated use PivotHelper
	 */
	@Deprecated	// All callers have been a local version for QVTd M3
	public static void rewriteSafeNavigations(@NonNull EnvironmentFactory environmentFactory, @NonNull Element asTree) {
		PivotHelper helper = new PivotHelper(environmentFactory);
		helper.rewriteSafeNavigations(asTree);
	}

	/**
	 * Define oclExpression as the bodyExpression of an expressionInOCL, and if non-null
	 * also define stringExpression as the OCL-languaged body.
	 */
	public static void setBody(@NonNull ExpressionInOCL expressionInOCL, @Nullable OCLExpression oclExpression, @Nullable String stringExpression) {
		expressionInOCL.setBody(stringExpression);
		expressionInOCL.setOwnedBody(oclExpression);
		expressionInOCL.setType(oclExpression != null ? oclExpression.getType() : null);
		expressionInOCL.setIsRequired((oclExpression != null) && oclExpression.isIsRequired());;
	}

	/**
	 * Configure resource to support parsing in the context of an eObject. Throws a ParserException
	 * if a pivot element cannot be identified for eObject.eClass(). Return false if a pivot element
	 * can be identified, but it is not one that supports constraint parsing.
	 *
	 * @throws ParserException if eObject cannot be converted to a Pivot element
	 */
	@Deprecated /* @deprecated not used - try CSResource.setParserContext */
	public static boolean setParserContext(@NonNull CSResource csResource, @NonNull EObject eObject, Object... unusedParameters) throws ParserException {
		EnvironmentFactoryAdapter adapter = OCLInternal.adapt(csResource);
		EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension) adapter.getEnvironmentFactory();
		Element pivotElement = environmentFactory.getTechnology().getParseableElement(environmentFactory, eObject);
		if (pivotElement == null) {
			return false;
		}
		ParserContext parserContext = environmentFactory.createParserContext(pivotElement);
		if (parserContext == null) {
			return false;
		}
		else {
			csResource.setParserContext(parserContext);
			return true;
		}
	}
}
