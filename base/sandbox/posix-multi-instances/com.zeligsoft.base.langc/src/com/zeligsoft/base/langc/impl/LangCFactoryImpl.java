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
package com.zeligsoft.base.langc.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.zeligsoft.base.langc.AddressOfExpr;
import com.zeligsoft.base.langc.BinaryOperation;
import com.zeligsoft.base.langc.BlockInitializer;
import com.zeligsoft.base.langc.BooleanOperator;
import com.zeligsoft.base.langc.BreakStatement;
import com.zeligsoft.base.langc.BuiltInType;
import com.zeligsoft.base.langc.CVQualifier;
import com.zeligsoft.base.langc.CastExpr;
import com.zeligsoft.base.langc.CharacterLiteral;
import com.zeligsoft.base.langc.CodeBlob;
import com.zeligsoft.base.langc.CodeBlock;
import com.zeligsoft.base.langc.ConditionalStatement;
import com.zeligsoft.base.langc.DependencyBlob;
import com.zeligsoft.base.langc.DependencyList;
import com.zeligsoft.base.langc.DereferenceExpr;
import com.zeligsoft.base.langc.ElementAccess;
import com.zeligsoft.base.langc.ElementKind;
import com.zeligsoft.base.langc.ElementList;
import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.Enumerator;
import com.zeligsoft.base.langc.Expression;
import com.zeligsoft.base.langc.ExpressionBlob;
import com.zeligsoft.base.langc.ExpressionStatement;
import com.zeligsoft.base.langc.FileName;
import com.zeligsoft.base.langc.FloatingLiteral;
import com.zeligsoft.base.langc.FolderName;
import com.zeligsoft.base.langc.Function;
import com.zeligsoft.base.langc.FunctionAddress;
import com.zeligsoft.base.langc.FunctionCall;
import com.zeligsoft.base.langc.FunctionImplementation;
import com.zeligsoft.base.langc.FunctionPointer;
import com.zeligsoft.base.langc.IndexExpr;
import com.zeligsoft.base.langc.IntegralLiteral;
import com.zeligsoft.base.langc.LabeledClause;
import com.zeligsoft.base.langc.LangCFactory;
import com.zeligsoft.base.langc.LangCPackage;
import com.zeligsoft.base.langc.LinkableArtifact;
import com.zeligsoft.base.langc.LinkageSpec;
import com.zeligsoft.base.langc.LogicalComparison;
import com.zeligsoft.base.langc.Macro;
import com.zeligsoft.base.langc.MemberAccess;
import com.zeligsoft.base.langc.Name;
import com.zeligsoft.base.langc.NamedReference;
import com.zeligsoft.base.langc.Operator;
import com.zeligsoft.base.langc.Pointer;
import com.zeligsoft.base.langc.PrimitiveType;
import com.zeligsoft.base.langc.ReturnStatement;
import com.zeligsoft.base.langc.SizeofExpr;
import com.zeligsoft.base.langc.SizeofType;
import com.zeligsoft.base.langc.StringLiteral;
import com.zeligsoft.base.langc.Struct;
import com.zeligsoft.base.langc.SubSystem;
import com.zeligsoft.base.langc.SwitchClause;
import com.zeligsoft.base.langc.SwitchStatement;
import com.zeligsoft.base.langc.SystemFileName;
import com.zeligsoft.base.langc.SystemInclude;
import com.zeligsoft.base.langc.Typedef;
import com.zeligsoft.base.langc.Union;
import com.zeligsoft.base.langc.UserInclude;
import com.zeligsoft.base.langc.VariableDeclaration;
import com.zeligsoft.base.langc.VariableDeclarationStatement;
import com.zeligsoft.base.langc.WhileStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("nls")
public class LangCFactoryImpl extends EFactoryImpl implements LangCFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LangCFactory init() {
		try {
			LangCFactory theLangCFactory = (LangCFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.zeligsoft.com/2008/LangC-02"); 
			if (theLangCFactory != null) {
				return theLangCFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LangCFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LangCFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LangCPackage.BUILT_IN_TYPE: return createBuiltInType();
			case LangCPackage.NAME: return createName();
			case LangCPackage.STRUCT: return createStruct();
			case LangCPackage.UNION: return createUnion();
			case LangCPackage.FUNCTION: return createFunction();
			case LangCPackage.NAMED_REFERENCE: return createNamedReference();
			case LangCPackage.ELEMENT_REFERENCE: return createElementReference();
			case LangCPackage.EXPRESSION: return createExpression();
			case LangCPackage.FUNCTION_CALL: return createFunctionCall();
			case LangCPackage.ELEMENT_ACCESS: return createElementAccess();
			case LangCPackage.ELEMENT_LIST: return createElementList();
			case LangCPackage.INTEGRAL_LITERAL: return createIntegralLiteral();
			case LangCPackage.CHARACTER_LITERAL: return createCharacterLiteral();
			case LangCPackage.FLOATING_LITERAL: return createFloatingLiteral();
			case LangCPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
			case LangCPackage.RETURN_STATEMENT: return createReturnStatement();
			case LangCPackage.CODE_BLOCK: return createCodeBlock();
			case LangCPackage.BINARY_OPERATION: return createBinaryOperation();
			case LangCPackage.FUNCTION_POINTER: return createFunctionPointer();
			case LangCPackage.FUNCTION_ADDRESS: return createFunctionAddress();
			case LangCPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case LangCPackage.TYPEDEF: return createTypedef();
			case LangCPackage.MEMBER_ACCESS: return createMemberAccess();
			case LangCPackage.EXPRESSION_BLOB: return createExpressionBlob();
			case LangCPackage.SUB_SYSTEM: return createSubSystem();
			case LangCPackage.ENUM: return createEnum();
			case LangCPackage.ENUMERATOR: return createEnumerator();
			case LangCPackage.SYSTEM_INCLUDE: return createSystemInclude();
			case LangCPackage.USER_INCLUDE: return createUserInclude();
			case LangCPackage.FILE_NAME: return createFileName();
			case LangCPackage.FOLDER_NAME: return createFolderName();
			case LangCPackage.CAST_EXPR: return createCastExpr();
			case LangCPackage.DEPENDENCY_LIST: return createDependencyList();
			case LangCPackage.SIZEOF_TYPE: return createSizeofType();
			case LangCPackage.SYSTEM_FILE_NAME: return createSystemFileName();
			case LangCPackage.SWITCH_CLAUSE: return createSwitchClause();
			case LangCPackage.LABELED_CLAUSE: return createLabeledClause();
			case LangCPackage.SWITCH_STATEMENT: return createSwitchStatement();
			case LangCPackage.BREAK_STATEMENT: return createBreakStatement();
			case LangCPackage.ADDRESS_OF_EXPR: return createAddressOfExpr();
			case LangCPackage.DEREFERENCE_EXPR: return createDereferenceExpr();
			case LangCPackage.WHILE_STATEMENT: return createWhileStatement();
			case LangCPackage.MACRO: return createMacro();
			case LangCPackage.STRING_LITERAL: return createStringLiteral();
			case LangCPackage.VARIABLE_DECLARATION_STATEMENT: return createVariableDeclarationStatement();
			case LangCPackage.BLOCK_INITIALIZER: return createBlockInitializer();
			case LangCPackage.INDEX_EXPR: return createIndexExpr();
			case LangCPackage.LOGICAL_COMPARISON: return createLogicalComparison();
			case LangCPackage.SIZEOF_EXPR: return createSizeofExpr();
			case LangCPackage.FUNCTION_IMPLEMENTATION: return createFunctionImplementation();
			case LangCPackage.SYSTEM: return createSystem();
			case LangCPackage.CODE_BLOB: return createCodeBlob();
			case LangCPackage.DEPENDENCY_BLOB: return createDependencyBlob();
			case LangCPackage.LINKABLE_ARTIFACT: return createLinkableArtifact();
			case LangCPackage.CONDITIONAL_STATEMENT: return createConditionalStatement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case LangCPackage.CV_QUALIFIER:
				return createCVQualifierFromString(eDataType, initialValue);
			case LangCPackage.PRIMITIVE_TYPE:
				return createPrimitiveTypeFromString(eDataType, initialValue);
			case LangCPackage.LINKAGE_SPEC:
				return createLinkageSpecFromString(eDataType, initialValue);
			case LangCPackage.OPERATOR:
				return createOperatorFromString(eDataType, initialValue);
			case LangCPackage.POINTER:
				return createPointerFromString(eDataType, initialValue);
			case LangCPackage.ELEMENT_KIND:
				return createElementKindFromString(eDataType, initialValue);
			case LangCPackage.BOOLEAN_OPERATOR:
				return createBooleanOperatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case LangCPackage.CV_QUALIFIER:
				return convertCVQualifierToString(eDataType, instanceValue);
			case LangCPackage.PRIMITIVE_TYPE:
				return convertPrimitiveTypeToString(eDataType, instanceValue);
			case LangCPackage.LINKAGE_SPEC:
				return convertLinkageSpecToString(eDataType, instanceValue);
			case LangCPackage.OPERATOR:
				return convertOperatorToString(eDataType, instanceValue);
			case LangCPackage.POINTER:
				return convertPointerToString(eDataType, instanceValue);
			case LangCPackage.ELEMENT_KIND:
				return convertElementKindToString(eDataType, instanceValue);
			case LangCPackage.BOOLEAN_OPERATOR:
				return convertBooleanOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltInType createBuiltInType() {
		BuiltInTypeImpl builtInType = new BuiltInTypeImpl();
		return builtInType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Name createName() {
		NameImpl name = new NameImpl();
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Struct createStruct() {
		StructImpl struct = new StructImpl();
		return struct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Union createUnion() {
		UnionImpl union = new UnionImpl();
		return union;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedReference createNamedReference() {
		NamedReferenceImpl namedReference = new NamedReferenceImpl();
		return namedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference createElementReference() {
		ElementReferenceImpl elementReference = new ElementReferenceImpl();
		return elementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCall createFunctionCall() {
		FunctionCallImpl functionCall = new FunctionCallImpl();
		return functionCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementAccess createElementAccess() {
		ElementAccessImpl elementAccess = new ElementAccessImpl();
		return elementAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementList createElementList() {
		ElementListImpl elementList = new ElementListImpl();
		return elementList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegralLiteral createIntegralLiteral() {
		IntegralLiteralImpl integralLiteral = new IntegralLiteralImpl();
		return integralLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterLiteral createCharacterLiteral() {
		CharacterLiteralImpl characterLiteral = new CharacterLiteralImpl();
		return characterLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatingLiteral createFloatingLiteral() {
		FloatingLiteralImpl floatingLiteral = new FloatingLiteralImpl();
		return floatingLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnStatement createReturnStatement() {
		ReturnStatementImpl returnStatement = new ReturnStatementImpl();
		return returnStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock createCodeBlock() {
		CodeBlockImpl codeBlock = new CodeBlockImpl();
		return codeBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOperation createBinaryOperation() {
		BinaryOperationImpl binaryOperation = new BinaryOperationImpl();
		return binaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionPointer createFunctionPointer() {
		FunctionPointerImpl functionPointer = new FunctionPointerImpl();
		return functionPointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionAddress createFunctionAddress() {
		FunctionAddressImpl functionAddress = new FunctionAddressImpl();
		return functionAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Typedef createTypedef() {
		TypedefImpl typedef = new TypedefImpl();
		return typedef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberAccess createMemberAccess() {
		MemberAccessImpl memberAccess = new MemberAccessImpl();
		return memberAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionBlob createExpressionBlob() {
		ExpressionBlobImpl expressionBlob = new ExpressionBlobImpl();
		return expressionBlob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubSystem createSubSystem() {
		SubSystemImpl subSystem = new SubSystemImpl();
		return subSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.zeligsoft.base.langc.Enum createEnum() {
		EnumImpl enum_ = new EnumImpl();
		return enum_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumerator createEnumerator() {
		EnumeratorImpl enumerator = new EnumeratorImpl();
		return enumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemInclude createSystemInclude() {
		SystemIncludeImpl systemInclude = new SystemIncludeImpl();
		return systemInclude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserInclude createUserInclude() {
		UserIncludeImpl userInclude = new UserIncludeImpl();
		return userInclude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileName createFileName() {
		FileNameImpl fileName = new FileNameImpl();
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FolderName createFolderName() {
		FolderNameImpl folderName = new FolderNameImpl();
		return folderName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CastExpr createCastExpr() {
		CastExprImpl castExpr = new CastExprImpl();
		return castExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyList createDependencyList() {
		DependencyListImpl dependencyList = new DependencyListImpl();
		return dependencyList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SizeofType createSizeofType() {
		SizeofTypeImpl sizeofType = new SizeofTypeImpl();
		return sizeofType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemFileName createSystemFileName() {
		SystemFileNameImpl systemFileName = new SystemFileNameImpl();
		return systemFileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchClause createSwitchClause() {
		SwitchClauseImpl switchClause = new SwitchClauseImpl();
		return switchClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabeledClause createLabeledClause() {
		LabeledClauseImpl labeledClause = new LabeledClauseImpl();
		return labeledClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchStatement createSwitchStatement() {
		SwitchStatementImpl switchStatement = new SwitchStatementImpl();
		return switchStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakStatement createBreakStatement() {
		BreakStatementImpl breakStatement = new BreakStatementImpl();
		return breakStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressOfExpr createAddressOfExpr() {
		AddressOfExprImpl addressOfExpr = new AddressOfExprImpl();
		return addressOfExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DereferenceExpr createDereferenceExpr() {
		DereferenceExprImpl dereferenceExpr = new DereferenceExprImpl();
		return dereferenceExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Macro createMacro() {
		MacroImpl macro = new MacroImpl();
		return macro;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationStatement createVariableDeclarationStatement() {
		VariableDeclarationStatementImpl variableDeclarationStatement = new VariableDeclarationStatementImpl();
		return variableDeclarationStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockInitializer createBlockInitializer() {
		BlockInitializerImpl blockInitializer = new BlockInitializerImpl();
		return blockInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexExpr createIndexExpr() {
		IndexExprImpl indexExpr = new IndexExprImpl();
		return indexExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalComparison createLogicalComparison() {
		LogicalComparisonImpl logicalComparison = new LogicalComparisonImpl();
		return logicalComparison;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SizeofExpr createSizeofExpr() {
		SizeofExprImpl sizeofExpr = new SizeofExprImpl();
		return sizeofExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionImplementation createFunctionImplementation() {
		FunctionImplementationImpl functionImplementation = new FunctionImplementationImpl();
		return functionImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.zeligsoft.base.langc.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlob createCodeBlob() {
		CodeBlobImpl codeBlob = new CodeBlobImpl();
		return codeBlob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyBlob createDependencyBlob() {
		DependencyBlobImpl dependencyBlob = new DependencyBlobImpl();
		return dependencyBlob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkableArtifact createLinkableArtifact() {
		LinkableArtifactImpl linkableArtifact = new LinkableArtifactImpl();
		return linkableArtifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalStatement createConditionalStatement() {
		ConditionalStatementImpl conditionalStatement = new ConditionalStatementImpl();
		return conditionalStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVQualifier createCVQualifierFromString(EDataType eDataType, String initialValue) {
		CVQualifier result = CVQualifier.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCVQualifierToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveTypeFromString(EDataType eDataType, String initialValue) {
		PrimitiveType result = PrimitiveType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkageSpec createLinkageSpecFromString(EDataType eDataType, String initialValue) {
		LinkageSpec result = LinkageSpec.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinkageSpecToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperatorFromString(EDataType eDataType, String initialValue) {
		Operator result = Operator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pointer createPointerFromString(EDataType eDataType, String initialValue) {
		Pointer result = Pointer.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPointerToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementKind createElementKindFromString(EDataType eDataType, String initialValue) {
		ElementKind result = ElementKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertElementKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanOperator createBooleanOperatorFromString(EDataType eDataType, String initialValue) {
		BooleanOperator result = BooleanOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LangCPackage getLangCPackage() {
		return (LangCPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LangCPackage getPackage() {
		return LangCPackage.eINSTANCE;
	}

} //LangCFactoryImpl
