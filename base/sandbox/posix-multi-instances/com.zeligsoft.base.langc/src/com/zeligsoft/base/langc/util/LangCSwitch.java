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
package com.zeligsoft.base.langc.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.langc.AddressOfExpr;
import com.zeligsoft.base.langc.BinaryOperation;
import com.zeligsoft.base.langc.BindableValue;
import com.zeligsoft.base.langc.BlockInitializer;
import com.zeligsoft.base.langc.BreakStatement;
import com.zeligsoft.base.langc.BuiltInType;
import com.zeligsoft.base.langc.CastExpr;
import com.zeligsoft.base.langc.CharacterLiteral;
import com.zeligsoft.base.langc.CodeBlob;
import com.zeligsoft.base.langc.CodeBlock;
import com.zeligsoft.base.langc.ConditionalStatement;
import com.zeligsoft.base.langc.Dependency;
import com.zeligsoft.base.langc.DependencyBlob;
import com.zeligsoft.base.langc.DependencyList;
import com.zeligsoft.base.langc.DereferenceExpr;
import com.zeligsoft.base.langc.Directive;
import com.zeligsoft.base.langc.Element;
import com.zeligsoft.base.langc.ElementAccess;
import com.zeligsoft.base.langc.ElementList;
import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.Enumerator;
import com.zeligsoft.base.langc.Expression;
import com.zeligsoft.base.langc.ExpressionBlob;
import com.zeligsoft.base.langc.ExpressionStatement;
import com.zeligsoft.base.langc.FileDependency;
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
import com.zeligsoft.base.langc.LangCPackage;
import com.zeligsoft.base.langc.LinkableArtifact;
import com.zeligsoft.base.langc.Literal;
import com.zeligsoft.base.langc.LogicalComparison;
import com.zeligsoft.base.langc.Macro;
import com.zeligsoft.base.langc.MemberAccess;
import com.zeligsoft.base.langc.Name;
import com.zeligsoft.base.langc.NamedElement;
import com.zeligsoft.base.langc.NamedReference;
import com.zeligsoft.base.langc.ReturnStatement;
import com.zeligsoft.base.langc.Sizeof;
import com.zeligsoft.base.langc.SizeofExpr;
import com.zeligsoft.base.langc.SizeofType;
import com.zeligsoft.base.langc.Statement;
import com.zeligsoft.base.langc.StringLiteral;
import com.zeligsoft.base.langc.Struct;
import com.zeligsoft.base.langc.Structure;
import com.zeligsoft.base.langc.SubSystem;
import com.zeligsoft.base.langc.SwitchClause;
import com.zeligsoft.base.langc.SwitchStatement;
import com.zeligsoft.base.langc.SystemFileName;
import com.zeligsoft.base.langc.SystemInclude;
import com.zeligsoft.base.langc.Typedef;
import com.zeligsoft.base.langc.Union;
import com.zeligsoft.base.langc.UserElement;
import com.zeligsoft.base.langc.UserInclude;
import com.zeligsoft.base.langc.VariableDeclaration;
import com.zeligsoft.base.langc.VariableDeclarationStatement;
import com.zeligsoft.base.langc.WhileStatement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.base.langc.LangCPackage
 * @generated
 */
public class LangCSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LangCPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LangCSwitch() {
		if (modelPackage == null) {
			modelPackage = LangCPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case LangCPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseUserElement(namedElement);
				if (result == null) result = caseBindableValue(namedElement);
				if (result == null) result = caseElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.BUILT_IN_TYPE: {
				BuiltInType builtInType = (BuiltInType)theEObject;
				T result = caseBuiltInType(builtInType);
				if (result == null) result = caseElement(builtInType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.NAME: {
				Name name = (Name)theEObject;
				T result = caseName(name);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.STRUCT: {
				Struct struct = (Struct)theEObject;
				T result = caseStruct(struct);
				if (result == null) result = caseStructure(struct);
				if (result == null) result = caseNamedElement(struct);
				if (result == null) result = caseUserElement(struct);
				if (result == null) result = caseBindableValue(struct);
				if (result == null) result = caseElement(struct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.UNION: {
				Union union = (Union)theEObject;
				T result = caseUnion(union);
				if (result == null) result = caseStructure(union);
				if (result == null) result = caseNamedElement(union);
				if (result == null) result = caseUserElement(union);
				if (result == null) result = caseBindableValue(union);
				if (result == null) result = caseElement(union);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FUNCTION: {
				Function function = (Function)theEObject;
				T result = caseFunction(function);
				if (result == null) result = caseNamedElement(function);
				if (result == null) result = caseUserElement(function);
				if (result == null) result = caseBindableValue(function);
				if (result == null) result = caseElement(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.NAMED_REFERENCE: {
				NamedReference namedReference = (NamedReference)theEObject;
				T result = caseNamedReference(namedReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.ELEMENT_REFERENCE: {
				ElementReference elementReference = (ElementReference)theEObject;
				T result = caseElementReference(elementReference);
				if (result == null) result = caseBindableValue(elementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FUNCTION_CALL: {
				FunctionCall functionCall = (FunctionCall)theEObject;
				T result = caseFunctionCall(functionCall);
				if (result == null) result = caseExpression(functionCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.ELEMENT_ACCESS: {
				ElementAccess elementAccess = (ElementAccess)theEObject;
				T result = caseElementAccess(elementAccess);
				if (result == null) result = caseExpression(elementAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.ELEMENT_LIST: {
				ElementList elementList = (ElementList)theEObject;
				T result = caseElementList(elementList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = caseExpression(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.INTEGRAL_LITERAL: {
				IntegralLiteral integralLiteral = (IntegralLiteral)theEObject;
				T result = caseIntegralLiteral(integralLiteral);
				if (result == null) result = caseLiteral(integralLiteral);
				if (result == null) result = caseExpression(integralLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.CHARACTER_LITERAL: {
				CharacterLiteral characterLiteral = (CharacterLiteral)theEObject;
				T result = caseCharacterLiteral(characterLiteral);
				if (result == null) result = caseLiteral(characterLiteral);
				if (result == null) result = caseExpression(characterLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FLOATING_LITERAL: {
				FloatingLiteral floatingLiteral = (FloatingLiteral)theEObject;
				T result = caseFloatingLiteral(floatingLiteral);
				if (result == null) result = caseLiteral(floatingLiteral);
				if (result == null) result = caseExpression(floatingLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.EXPRESSION_STATEMENT: {
				ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
				T result = caseExpressionStatement(expressionStatement);
				if (result == null) result = caseStatement(expressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.RETURN_STATEMENT: {
				ReturnStatement returnStatement = (ReturnStatement)theEObject;
				T result = caseReturnStatement(returnStatement);
				if (result == null) result = caseExpressionStatement(returnStatement);
				if (result == null) result = caseStatement(returnStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.CODE_BLOCK: {
				CodeBlock codeBlock = (CodeBlock)theEObject;
				T result = caseCodeBlock(codeBlock);
				if (result == null) result = caseStatement(codeBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.BINARY_OPERATION: {
				BinaryOperation binaryOperation = (BinaryOperation)theEObject;
				T result = caseBinaryOperation(binaryOperation);
				if (result == null) result = caseExpression(binaryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.STRUCTURE: {
				Structure structure = (Structure)theEObject;
				T result = caseStructure(structure);
				if (result == null) result = caseNamedElement(structure);
				if (result == null) result = caseUserElement(structure);
				if (result == null) result = caseBindableValue(structure);
				if (result == null) result = caseElement(structure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FUNCTION_POINTER: {
				FunctionPointer functionPointer = (FunctionPointer)theEObject;
				T result = caseFunctionPointer(functionPointer);
				if (result == null) result = caseUserElement(functionPointer);
				if (result == null) result = caseElement(functionPointer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FUNCTION_ADDRESS: {
				FunctionAddress functionAddress = (FunctionAddress)theEObject;
				T result = caseFunctionAddress(functionAddress);
				if (result == null) result = caseExpression(functionAddress);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseNamedElement(variableDeclaration);
				if (result == null) result = caseUserElement(variableDeclaration);
				if (result == null) result = caseBindableValue(variableDeclaration);
				if (result == null) result = caseElement(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.ELEMENT: {
				Element element = (Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.TYPEDEF: {
				Typedef typedef = (Typedef)theEObject;
				T result = caseTypedef(typedef);
				if (result == null) result = caseNamedElement(typedef);
				if (result == null) result = caseUserElement(typedef);
				if (result == null) result = caseBindableValue(typedef);
				if (result == null) result = caseElement(typedef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.MEMBER_ACCESS: {
				MemberAccess memberAccess = (MemberAccess)theEObject;
				T result = caseMemberAccess(memberAccess);
				if (result == null) result = caseElementAccess(memberAccess);
				if (result == null) result = caseExpression(memberAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.EXPRESSION_BLOB: {
				ExpressionBlob expressionBlob = (ExpressionBlob)theEObject;
				T result = caseExpressionBlob(expressionBlob);
				if (result == null) result = caseExpression(expressionBlob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SUB_SYSTEM: {
				SubSystem subSystem = (SubSystem)theEObject;
				T result = caseSubSystem(subSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.ENUM: {
				com.zeligsoft.base.langc.Enum enum_ = (com.zeligsoft.base.langc.Enum)theEObject;
				T result = caseEnum(enum_);
				if (result == null) result = caseNamedElement(enum_);
				if (result == null) result = caseUserElement(enum_);
				if (result == null) result = caseBindableValue(enum_);
				if (result == null) result = caseElement(enum_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.ENUMERATOR: {
				Enumerator enumerator = (Enumerator)theEObject;
				T result = caseEnumerator(enumerator);
				if (result == null) result = caseBindableValue(enumerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FILE_DEPENDENCY: {
				FileDependency fileDependency = (FileDependency)theEObject;
				T result = caseFileDependency(fileDependency);
				if (result == null) result = caseDependency(fileDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SYSTEM_INCLUDE: {
				SystemInclude systemInclude = (SystemInclude)theEObject;
				T result = caseSystemInclude(systemInclude);
				if (result == null) result = caseFileDependency(systemInclude);
				if (result == null) result = caseDependency(systemInclude);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.USER_INCLUDE: {
				UserInclude userInclude = (UserInclude)theEObject;
				T result = caseUserInclude(userInclude);
				if (result == null) result = caseFileDependency(userInclude);
				if (result == null) result = caseDependency(userInclude);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FILE_NAME: {
				FileName fileName = (FileName)theEObject;
				T result = caseFileName(fileName);
				if (result == null) result = caseName(fileName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FOLDER_NAME: {
				FolderName folderName = (FolderName)theEObject;
				T result = caseFolderName(folderName);
				if (result == null) result = caseName(folderName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.CAST_EXPR: {
				CastExpr castExpr = (CastExpr)theEObject;
				T result = caseCastExpr(castExpr);
				if (result == null) result = caseExpression(castExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.USER_ELEMENT: {
				UserElement userElement = (UserElement)theEObject;
				T result = caseUserElement(userElement);
				if (result == null) result = caseElement(userElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.DEPENDENCY_LIST: {
				DependencyList dependencyList = (DependencyList)theEObject;
				T result = caseDependencyList(dependencyList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SIZEOF_TYPE: {
				SizeofType sizeofType = (SizeofType)theEObject;
				T result = caseSizeofType(sizeofType);
				if (result == null) result = caseSizeof(sizeofType);
				if (result == null) result = caseExpression(sizeofType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.BINDABLE_VALUE: {
				BindableValue bindableValue = (BindableValue)theEObject;
				T result = caseBindableValue(bindableValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SYSTEM_FILE_NAME: {
				SystemFileName systemFileName = (SystemFileName)theEObject;
				T result = caseSystemFileName(systemFileName);
				if (result == null) result = caseFileName(systemFileName);
				if (result == null) result = caseName(systemFileName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SWITCH_CLAUSE: {
				SwitchClause switchClause = (SwitchClause)theEObject;
				T result = caseSwitchClause(switchClause);
				if (result == null) result = caseCodeBlock(switchClause);
				if (result == null) result = caseStatement(switchClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.LABELED_CLAUSE: {
				LabeledClause labeledClause = (LabeledClause)theEObject;
				T result = caseLabeledClause(labeledClause);
				if (result == null) result = caseSwitchClause(labeledClause);
				if (result == null) result = caseCodeBlock(labeledClause);
				if (result == null) result = caseStatement(labeledClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SWITCH_STATEMENT: {
				SwitchStatement switchStatement = (SwitchStatement)theEObject;
				T result = caseSwitchStatement(switchStatement);
				if (result == null) result = caseStatement(switchStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.BREAK_STATEMENT: {
				BreakStatement breakStatement = (BreakStatement)theEObject;
				T result = caseBreakStatement(breakStatement);
				if (result == null) result = caseStatement(breakStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.ADDRESS_OF_EXPR: {
				AddressOfExpr addressOfExpr = (AddressOfExpr)theEObject;
				T result = caseAddressOfExpr(addressOfExpr);
				if (result == null) result = caseExpression(addressOfExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.DEREFERENCE_EXPR: {
				DereferenceExpr dereferenceExpr = (DereferenceExpr)theEObject;
				T result = caseDereferenceExpr(dereferenceExpr);
				if (result == null) result = caseExpression(dereferenceExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseCodeBlock(whileStatement);
				if (result == null) result = caseStatement(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.MACRO: {
				Macro macro = (Macro)theEObject;
				T result = caseMacro(macro);
				if (result == null) result = caseDirective(macro);
				if (result == null) result = caseBindableValue(macro);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.DIRECTIVE: {
				Directive directive = (Directive)theEObject;
				T result = caseDirective(directive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.VARIABLE_DECLARATION_STATEMENT: {
				VariableDeclarationStatement variableDeclarationStatement = (VariableDeclarationStatement)theEObject;
				T result = caseVariableDeclarationStatement(variableDeclarationStatement);
				if (result == null) result = caseStatement(variableDeclarationStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.BLOCK_INITIALIZER: {
				BlockInitializer blockInitializer = (BlockInitializer)theEObject;
				T result = caseBlockInitializer(blockInitializer);
				if (result == null) result = caseExpression(blockInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.INDEX_EXPR: {
				IndexExpr indexExpr = (IndexExpr)theEObject;
				T result = caseIndexExpr(indexExpr);
				if (result == null) result = caseExpression(indexExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.LOGICAL_COMPARISON: {
				LogicalComparison logicalComparison = (LogicalComparison)theEObject;
				T result = caseLogicalComparison(logicalComparison);
				if (result == null) result = caseExpression(logicalComparison);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SIZEOF_EXPR: {
				SizeofExpr sizeofExpr = (SizeofExpr)theEObject;
				T result = caseSizeofExpr(sizeofExpr);
				if (result == null) result = caseSizeof(sizeofExpr);
				if (result == null) result = caseExpression(sizeofExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SIZEOF: {
				Sizeof sizeof = (Sizeof)theEObject;
				T result = caseSizeof(sizeof);
				if (result == null) result = caseExpression(sizeof);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.FUNCTION_IMPLEMENTATION: {
				FunctionImplementation functionImplementation = (FunctionImplementation)theEObject;
				T result = caseFunctionImplementation(functionImplementation);
				if (result == null) result = caseUserElement(functionImplementation);
				if (result == null) result = caseElement(functionImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.SYSTEM: {
				com.zeligsoft.base.langc.System system = (com.zeligsoft.base.langc.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.CODE_BLOB: {
				CodeBlob codeBlob = (CodeBlob)theEObject;
				T result = caseCodeBlob(codeBlob);
				if (result == null) result = caseCodeBlock(codeBlob);
				if (result == null) result = caseStatement(codeBlob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.DEPENDENCY: {
				Dependency dependency = (Dependency)theEObject;
				T result = caseDependency(dependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.DEPENDENCY_BLOB: {
				DependencyBlob dependencyBlob = (DependencyBlob)theEObject;
				T result = caseDependencyBlob(dependencyBlob);
				if (result == null) result = caseDependency(dependencyBlob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.LINKABLE_ARTIFACT: {
				LinkableArtifact linkableArtifact = (LinkableArtifact)theEObject;
				T result = caseLinkableArtifact(linkableArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LangCPackage.CONDITIONAL_STATEMENT: {
				ConditionalStatement conditionalStatement = (ConditionalStatement)theEObject;
				T result = caseConditionalStatement(conditionalStatement);
				if (result == null) result = caseCodeBlock(conditionalStatement);
				if (result == null) result = caseStatement(conditionalStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Built In Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Built In Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltInType(BuiltInType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseName(Name object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStruct(Struct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Union</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Union</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnion(Union object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunction(Function object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedReference(NamedReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementReference(ElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionCall(FunctionCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementAccess(ElementAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementList(ElementList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integral Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integral Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegralLiteral(IntegralLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Character Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Character Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterLiteral(CharacterLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Floating Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Floating Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatingLiteral(FloatingLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatement(ExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnStatement(ReturnStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeBlock(CodeBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryOperation(BinaryOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructure(Structure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Pointer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionPointer(FunctionPointer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionAddress(FunctionAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typedef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typedef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedef(Typedef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemberAccess(MemberAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Blob</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Blob</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionBlob(ExpressionBlob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubSystem(SubSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnum(com.zeligsoft.base.langc.Enum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerator(Enumerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileDependency(FileDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Include</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Include</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemInclude(SystemInclude object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Include</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Include</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserInclude(UserInclude object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileName(FileName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolderName(FolderName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cast Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cast Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCastExpr(CastExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserElement(UserElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyList(DependencyList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sizeof Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sizeof Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSizeofType(SizeofType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bindable Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bindable Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindableValue(BindableValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System File Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System File Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemFileName(SystemFileName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchClause(SwitchClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Labeled Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Labeled Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabeledClause(LabeledClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchStatement(SwitchStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakStatement(BreakStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Of Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Of Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressOfExpr(AddressOfExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dereference Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dereference Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDereferenceExpr(DereferenceExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileStatement(WhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Macro</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Macro</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMacro(Macro object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirective(Directive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclarationStatement(VariableDeclarationStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockInitializer(BlockInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexExpr(IndexExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Comparison</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Comparison</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalComparison(LogicalComparison object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sizeof Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sizeof Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSizeofExpr(SizeofExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sizeof</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sizeof</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSizeof(Sizeof object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionImplementation(FunctionImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(com.zeligsoft.base.langc.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Blob</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Blob</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeBlob(CodeBlob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependency(Dependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Blob</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Blob</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyBlob(DependencyBlob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linkable Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linkable Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkableArtifact(LinkableArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalStatement(ConditionalStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //LangCSwitch
