/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.cx.langc.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.cx.langc.AddressOfExpr;
import com.zeligsoft.cx.langc.BinaryOperation;
import com.zeligsoft.cx.langc.BindableValue;
import com.zeligsoft.cx.langc.BlockInitializer;
import com.zeligsoft.cx.langc.BreakStatement;
import com.zeligsoft.cx.langc.BuiltInType;
import com.zeligsoft.cx.langc.CastExpr;
import com.zeligsoft.cx.langc.CharacterLiteral;
import com.zeligsoft.cx.langc.CodeBlob;
import com.zeligsoft.cx.langc.CodeBlock;
import com.zeligsoft.cx.langc.ConditionalStatement;
import com.zeligsoft.cx.langc.Dependency;
import com.zeligsoft.cx.langc.DependencyBlob;
import com.zeligsoft.cx.langc.DependencyList;
import com.zeligsoft.cx.langc.DereferenceExpr;
import com.zeligsoft.cx.langc.Directive;
import com.zeligsoft.cx.langc.Element;
import com.zeligsoft.cx.langc.ElementAccess;
import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Enumerator;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.ExpressionBlob;
import com.zeligsoft.cx.langc.ExpressionStatement;
import com.zeligsoft.cx.langc.FileDependency;
import com.zeligsoft.cx.langc.FileName;
import com.zeligsoft.cx.langc.FloatingLiteral;
import com.zeligsoft.cx.langc.FolderName;
import com.zeligsoft.cx.langc.Function;
import com.zeligsoft.cx.langc.FunctionAddress;
import com.zeligsoft.cx.langc.FunctionCall;
import com.zeligsoft.cx.langc.FunctionImplementation;
import com.zeligsoft.cx.langc.FunctionPointer;
import com.zeligsoft.cx.langc.IndexExpr;
import com.zeligsoft.cx.langc.IntegralLiteral;
import com.zeligsoft.cx.langc.LabeledClause;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.LinkableArtifact;
import com.zeligsoft.cx.langc.Literal;
import com.zeligsoft.cx.langc.LogicalComparison;
import com.zeligsoft.cx.langc.Macro;
import com.zeligsoft.cx.langc.MemberAccess;
import com.zeligsoft.cx.langc.Name;
import com.zeligsoft.cx.langc.NamedElement;
import com.zeligsoft.cx.langc.NamedReference;
import com.zeligsoft.cx.langc.ReturnStatement;
import com.zeligsoft.cx.langc.Sizeof;
import com.zeligsoft.cx.langc.SizeofExpr;
import com.zeligsoft.cx.langc.SizeofType;
import com.zeligsoft.cx.langc.Statement;
import com.zeligsoft.cx.langc.StringLiteral;
import com.zeligsoft.cx.langc.Struct;
import com.zeligsoft.cx.langc.Structure;
import com.zeligsoft.cx.langc.SubSystem;
import com.zeligsoft.cx.langc.SwitchClause;
import com.zeligsoft.cx.langc.SwitchStatement;
import com.zeligsoft.cx.langc.SystemFileName;
import com.zeligsoft.cx.langc.SystemInclude;
import com.zeligsoft.cx.langc.Typedef;
import com.zeligsoft.cx.langc.Union;
import com.zeligsoft.cx.langc.UserElement;
import com.zeligsoft.cx.langc.UserInclude;
import com.zeligsoft.cx.langc.VariableDeclaration;
import com.zeligsoft.cx.langc.VariableDeclarationStatement;
import com.zeligsoft.cx.langc.WhileStatement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.cx.langc.LangCPackage
 * @generated
 */
public class LangCAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LangCPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LangCAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LangCPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LangCSwitch<Adapter> modelSwitch =
		new LangCSwitch<Adapter>() {
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseBuiltInType(BuiltInType object) {
				return createBuiltInTypeAdapter();
			}
			@Override
			public Adapter caseName(Name object) {
				return createNameAdapter();
			}
			@Override
			public Adapter caseStruct(Struct object) {
				return createStructAdapter();
			}
			@Override
			public Adapter caseUnion(Union object) {
				return createUnionAdapter();
			}
			@Override
			public Adapter caseFunction(Function object) {
				return createFunctionAdapter();
			}
			@Override
			public Adapter caseNamedReference(NamedReference object) {
				return createNamedReferenceAdapter();
			}
			@Override
			public Adapter caseElementReference(ElementReference object) {
				return createElementReferenceAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseFunctionCall(FunctionCall object) {
				return createFunctionCallAdapter();
			}
			@Override
			public Adapter caseElementAccess(ElementAccess object) {
				return createElementAccessAdapter();
			}
			@Override
			public Adapter caseElementList(ElementList object) {
				return createElementListAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseIntegralLiteral(IntegralLiteral object) {
				return createIntegralLiteralAdapter();
			}
			@Override
			public Adapter caseCharacterLiteral(CharacterLiteral object) {
				return createCharacterLiteralAdapter();
			}
			@Override
			public Adapter caseFloatingLiteral(FloatingLiteral object) {
				return createFloatingLiteralAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseExpressionStatement(ExpressionStatement object) {
				return createExpressionStatementAdapter();
			}
			@Override
			public Adapter caseReturnStatement(ReturnStatement object) {
				return createReturnStatementAdapter();
			}
			@Override
			public Adapter caseCodeBlock(CodeBlock object) {
				return createCodeBlockAdapter();
			}
			@Override
			public Adapter caseBinaryOperation(BinaryOperation object) {
				return createBinaryOperationAdapter();
			}
			@Override
			public Adapter caseStructure(Structure object) {
				return createStructureAdapter();
			}
			@Override
			public Adapter caseFunctionPointer(FunctionPointer object) {
				return createFunctionPointerAdapter();
			}
			@Override
			public Adapter caseFunctionAddress(FunctionAddress object) {
				return createFunctionAddressAdapter();
			}
			@Override
			public Adapter caseVariableDeclaration(VariableDeclaration object) {
				return createVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseTypedef(Typedef object) {
				return createTypedefAdapter();
			}
			@Override
			public Adapter caseMemberAccess(MemberAccess object) {
				return createMemberAccessAdapter();
			}
			@Override
			public Adapter caseExpressionBlob(ExpressionBlob object) {
				return createExpressionBlobAdapter();
			}
			@Override
			public Adapter caseSubSystem(SubSystem object) {
				return createSubSystemAdapter();
			}
			@Override
			public Adapter caseEnum(com.zeligsoft.cx.langc.Enum object) {
				return createEnumAdapter();
			}
			@Override
			public Adapter caseEnumerator(Enumerator object) {
				return createEnumeratorAdapter();
			}
			@Override
			public Adapter caseFileDependency(FileDependency object) {
				return createFileDependencyAdapter();
			}
			@Override
			public Adapter caseSystemInclude(SystemInclude object) {
				return createSystemIncludeAdapter();
			}
			@Override
			public Adapter caseUserInclude(UserInclude object) {
				return createUserIncludeAdapter();
			}
			@Override
			public Adapter caseFileName(FileName object) {
				return createFileNameAdapter();
			}
			@Override
			public Adapter caseFolderName(FolderName object) {
				return createFolderNameAdapter();
			}
			@Override
			public Adapter caseCastExpr(CastExpr object) {
				return createCastExprAdapter();
			}
			@Override
			public Adapter caseUserElement(UserElement object) {
				return createUserElementAdapter();
			}
			@Override
			public Adapter caseDependencyList(DependencyList object) {
				return createDependencyListAdapter();
			}
			@Override
			public Adapter caseSizeofType(SizeofType object) {
				return createSizeofTypeAdapter();
			}
			@Override
			public Adapter caseBindableValue(BindableValue object) {
				return createBindableValueAdapter();
			}
			@Override
			public Adapter caseSystemFileName(SystemFileName object) {
				return createSystemFileNameAdapter();
			}
			@Override
			public Adapter caseSwitchClause(SwitchClause object) {
				return createSwitchClauseAdapter();
			}
			@Override
			public Adapter caseLabeledClause(LabeledClause object) {
				return createLabeledClauseAdapter();
			}
			@Override
			public Adapter caseSwitchStatement(SwitchStatement object) {
				return createSwitchStatementAdapter();
			}
			@Override
			public Adapter caseBreakStatement(BreakStatement object) {
				return createBreakStatementAdapter();
			}
			@Override
			public Adapter caseAddressOfExpr(AddressOfExpr object) {
				return createAddressOfExprAdapter();
			}
			@Override
			public Adapter caseDereferenceExpr(DereferenceExpr object) {
				return createDereferenceExprAdapter();
			}
			@Override
			public Adapter caseWhileStatement(WhileStatement object) {
				return createWhileStatementAdapter();
			}
			@Override
			public Adapter caseMacro(Macro object) {
				return createMacroAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseDirective(Directive object) {
				return createDirectiveAdapter();
			}
			@Override
			public Adapter caseVariableDeclarationStatement(VariableDeclarationStatement object) {
				return createVariableDeclarationStatementAdapter();
			}
			@Override
			public Adapter caseBlockInitializer(BlockInitializer object) {
				return createBlockInitializerAdapter();
			}
			@Override
			public Adapter caseIndexExpr(IndexExpr object) {
				return createIndexExprAdapter();
			}
			@Override
			public Adapter caseLogicalComparison(LogicalComparison object) {
				return createLogicalComparisonAdapter();
			}
			@Override
			public Adapter caseSizeofExpr(SizeofExpr object) {
				return createSizeofExprAdapter();
			}
			@Override
			public Adapter caseSizeof(Sizeof object) {
				return createSizeofAdapter();
			}
			@Override
			public Adapter caseFunctionImplementation(FunctionImplementation object) {
				return createFunctionImplementationAdapter();
			}
			@Override
			public Adapter caseSystem(com.zeligsoft.cx.langc.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseCodeBlob(CodeBlob object) {
				return createCodeBlobAdapter();
			}
			@Override
			public Adapter caseDependency(Dependency object) {
				return createDependencyAdapter();
			}
			@Override
			public Adapter caseDependencyBlob(DependencyBlob object) {
				return createDependencyBlobAdapter();
			}
			@Override
			public Adapter caseLinkableArtifact(LinkableArtifact object) {
				return createLinkableArtifactAdapter();
			}
			@Override
			public Adapter caseConditionalStatement(ConditionalStatement object) {
				return createConditionalStatementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.BuiltInType <em>Built In Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.BuiltInType
	 * @generated
	 */
	public Adapter createBuiltInTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Name <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Name
	 * @generated
	 */
	public Adapter createNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Struct <em>Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Struct
	 * @generated
	 */
	public Adapter createStructAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Union
	 * @generated
	 */
	public Adapter createUnionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.NamedReference <em>Named Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.NamedReference
	 * @generated
	 */
	public Adapter createNamedReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.ElementReference <em>Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.ElementReference
	 * @generated
	 */
	public Adapter createElementReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.FunctionCall
	 * @generated
	 */
	public Adapter createFunctionCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.ElementAccess <em>Element Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.ElementAccess
	 * @generated
	 */
	public Adapter createElementAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.ElementList <em>Element List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.ElementList
	 * @generated
	 */
	public Adapter createElementListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.IntegralLiteral <em>Integral Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.IntegralLiteral
	 * @generated
	 */
	public Adapter createIntegralLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.CharacterLiteral <em>Character Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.CharacterLiteral
	 * @generated
	 */
	public Adapter createCharacterLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.FloatingLiteral <em>Floating Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.FloatingLiteral
	 * @generated
	 */
	public Adapter createFloatingLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.ExpressionStatement <em>Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.ExpressionStatement
	 * @generated
	 */
	public Adapter createExpressionStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.ReturnStatement
	 * @generated
	 */
	public Adapter createReturnStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.CodeBlock <em>Code Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.CodeBlock
	 * @generated
	 */
	public Adapter createCodeBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.BinaryOperation <em>Binary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.BinaryOperation
	 * @generated
	 */
	public Adapter createBinaryOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Structure
	 * @generated
	 */
	public Adapter createStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.FunctionPointer <em>Function Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.FunctionPointer
	 * @generated
	 */
	public Adapter createFunctionPointerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.FunctionAddress <em>Function Address</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.FunctionAddress
	 * @generated
	 */
	public Adapter createFunctionAddressAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Typedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Typedef
	 * @generated
	 */
	public Adapter createTypedefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.MemberAccess <em>Member Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.MemberAccess
	 * @generated
	 */
	public Adapter createMemberAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.ExpressionBlob <em>Expression Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.ExpressionBlob
	 * @generated
	 */
	public Adapter createExpressionBlobAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.SubSystem <em>Sub System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.SubSystem
	 * @generated
	 */
	public Adapter createSubSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Enum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Enum
	 * @generated
	 */
	public Adapter createEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Enumerator <em>Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Enumerator
	 * @generated
	 */
	public Adapter createEnumeratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.FileDependency <em>File Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.FileDependency
	 * @generated
	 */
	public Adapter createFileDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.SystemInclude <em>System Include</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.SystemInclude
	 * @generated
	 */
	public Adapter createSystemIncludeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.UserInclude <em>User Include</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.UserInclude
	 * @generated
	 */
	public Adapter createUserIncludeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.FileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.FileName
	 * @generated
	 */
	public Adapter createFileNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.FolderName <em>Folder Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.FolderName
	 * @generated
	 */
	public Adapter createFolderNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.CastExpr <em>Cast Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.CastExpr
	 * @generated
	 */
	public Adapter createCastExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.UserElement <em>User Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.UserElement
	 * @generated
	 */
	public Adapter createUserElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.DependencyList <em>Dependency List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.DependencyList
	 * @generated
	 */
	public Adapter createDependencyListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.SizeofType <em>Sizeof Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.SizeofType
	 * @generated
	 */
	public Adapter createSizeofTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.BindableValue <em>Bindable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.BindableValue
	 * @generated
	 */
	public Adapter createBindableValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.SystemFileName <em>System File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.SystemFileName
	 * @generated
	 */
	public Adapter createSystemFileNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.SwitchClause <em>Switch Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.SwitchClause
	 * @generated
	 */
	public Adapter createSwitchClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.LabeledClause <em>Labeled Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.LabeledClause
	 * @generated
	 */
	public Adapter createLabeledClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.SwitchStatement
	 * @generated
	 */
	public Adapter createSwitchStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.BreakStatement
	 * @generated
	 */
	public Adapter createBreakStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.AddressOfExpr <em>Address Of Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.AddressOfExpr
	 * @generated
	 */
	public Adapter createAddressOfExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.DereferenceExpr <em>Dereference Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.DereferenceExpr
	 * @generated
	 */
	public Adapter createDereferenceExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.WhileStatement
	 * @generated
	 */
	public Adapter createWhileStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Macro <em>Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Macro
	 * @generated
	 */
	public Adapter createMacroAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Directive <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Directive
	 * @generated
	 */
	public Adapter createDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.VariableDeclarationStatement <em>Variable Declaration Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.VariableDeclarationStatement
	 * @generated
	 */
	public Adapter createVariableDeclarationStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.BlockInitializer <em>Block Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.BlockInitializer
	 * @generated
	 */
	public Adapter createBlockInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.IndexExpr <em>Index Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.IndexExpr
	 * @generated
	 */
	public Adapter createIndexExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.LogicalComparison <em>Logical Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.LogicalComparison
	 * @generated
	 */
	public Adapter createLogicalComparisonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.SizeofExpr <em>Sizeof Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.SizeofExpr
	 * @generated
	 */
	public Adapter createSizeofExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Sizeof <em>Sizeof</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Sizeof
	 * @generated
	 */
	public Adapter createSizeofAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.FunctionImplementation <em>Function Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.FunctionImplementation
	 * @generated
	 */
	public Adapter createFunctionImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.CodeBlob <em>Code Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.CodeBlob
	 * @generated
	 */
	public Adapter createCodeBlobAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.Dependency
	 * @generated
	 */
	public Adapter createDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.DependencyBlob <em>Dependency Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.DependencyBlob
	 * @generated
	 */
	public Adapter createDependencyBlobAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.LinkableArtifact <em>Linkable Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.LinkableArtifact
	 * @generated
	 */
	public Adapter createLinkableArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.zeligsoft.cx.langc.ConditionalStatement <em>Conditional Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.zeligsoft.cx.langc.ConditionalStatement
	 * @generated
	 */
	public Adapter createConditionalStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LangCAdapterFactory
