/**
 */
package org.eclipse.papyrus.uml.alf.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.uml.alf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.alf.AlfPackage
 * @generated
 */
public class AlfValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final AlfValidator INSTANCE = new AlfValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.papyrus.uml.alf";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Expansion Expression Variable Source Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_VARIABLE_SOURCE_DERIVATION = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Expansion Expression Assignments Before Primary' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_BEFORE_PRIMARY = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Expansion Expression Assignments Before Argument' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_BEFORE_ARGUMENT = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Expansion Expression Variable Name' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_VARIABLE_NAME = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Expansion Expression Assignments After Argument' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_AFTER_ARGUMENT = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Select Or Reject Expression Type Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_TYPE_DERIVATION = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Select Or Reject Expression Lower Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_LOWER_DERIVATION = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Select Or Reject Expression Upper Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_UPPER_DERIVATION = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Select Or Reject Expression Argument' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_ARGUMENT = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Collect Or Iterate Expression Type Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_TYPE_DERIVATION = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Collect Or Iterate Expression Lower Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_LOWER_DERIVATION = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Collect Or Iterate Expression Upper Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_UPPER_DERIVATION = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Or Exists Or One Expression Type Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_TYPE_DERIVATION = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Or Exists Or One Expression Lower Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_LOWER_DERIVATION = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Or Exists Or One Expression Upper Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_UPPER_DERIVATION = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Or Exists Or One Expression Argument' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_ARGUMENT = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Unique Expression Type Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__IS_UNIQUE_EXPRESSION_TYPE_DERIVATION = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Unique Expression Lower Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__IS_UNIQUE_EXPRESSION_LOWER_DERIVATION = 18;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Unique Expression Upper Derivation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__IS_UNIQUE_EXPRESSION_UPPER_DERIVATION = 19;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Unique Expression Expression Argument' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__IS_UNIQUE_EXPRESSION_EXPRESSION_ARGUMENT = 20;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Expansion Expression Operation' of 'Sequence Expansion Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_OPERATION = 21;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Expression Assignment After Derivation' of 'Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXPRESSION__EXPRESSION_ASSIGNMENT_AFTER_DERIVATION = 22;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Expression Unique Assignments' of 'Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXPRESSION__EXPRESSION_UNIQUE_ASSIGNMENTS = 23;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Extent Or Expression Expression Derivation' of 'Extent Or Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTENT_OR_EXPRESSION__EXTENT_OR_EXPRESSION_EXPRESSION_DERIVATION = 24;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Extent Or Expression Extent Type' of 'Extent Or Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTENT_OR_EXPRESSION__EXTENT_OR_EXPRESSION_EXTENT_TYPE = 25;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Extent Or Expression Resolution' of 'Extent Or Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTENT_OR_EXPRESSION__EXTENT_OR_EXPRESSION_RESOLUTION = 26;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Unqualified Name Derivation' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_UNQUALIFIED_NAME_DERIVATION = 27;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Path Name Derivation' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_PATH_NAME_DERIVATION = 28;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Is Feature Reference Derivation' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_IS_FEATURE_REFERENCE_DERIVATION = 29;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Qualification Derivation' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_QUALIFICATION_DERIVATION = 30;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Disambiguation Derivation' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_DISAMBIGUATION_DERIVATION = 31;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Referent Derivation' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_REFERENT_DERIVATION = 32;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Local Name' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_LOCAL_NAME = 33;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Non Local Unqualified Name' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_NON_LOCAL_UNQUALIFIED_NAME = 34;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Qualified Resolution' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_QUALIFIED_RESOLUTION = 35;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Template Binding' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_TEMPLATE_BINDING = 36;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Qualified Name Template Name Derivation' of 'Qualified Name'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIED_NAME__QUALIFIED_NAME_TEMPLATE_NAME_DERIVATION = 37;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Reference Referent Derivation' of 'Feature Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_REFERENCE__FEATURE_REFERENCE_REFERENT_DERIVATION = 38;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Reference Target Type' of 'Feature Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_REFERENCE__FEATURE_REFERENCE_TARGET_TYPE = 39;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Numeric Unary Expression Type Derivation' of 'Numeric Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NUMERIC_UNARY_EXPRESSION__NUMERIC_UNARY_EXPRESSION_TYPE_DERIVATION = 40;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Numeric Unary Expression Lower Derivation' of 'Numeric Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NUMERIC_UNARY_EXPRESSION__NUMERIC_UNARY_EXPRESSION_LOWER_DERIVATION = 41;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Numeric Unary Expression Upper Derivation' of 'Numeric Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NUMERIC_UNARY_EXPRESSION__NUMERIC_UNARY_EXPRESSION_UPPER_DERIVATION = 42;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Numeric Unary Expression Operand' of 'Numeric Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NUMERIC_UNARY_EXPRESSION__NUMERIC_UNARY_EXPRESSION_OPERAND = 43;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Unary Expression Assignments Before' of 'Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNARY_EXPRESSION__UNARY_EXPRESSION_ASSIGNMENTS_BEFORE = 44;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Or Exists Or One Expression Type Derivation' of 'For All Or Exists Or One Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_TYPE_DERIVATION = 45;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Or Exists Or One Expression Lower Derivation' of 'For All Or Exists Or One Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_LOWER_DERIVATION = 46;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Or Exists Or One Expression Upper Derivation' of 'For All Or Exists Or One Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_UPPER_DERIVATION = 47;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For All Or Exists Or One Expression Argument' of 'For All Or Exists Or One Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_ARGUMENT = 48;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Isolation Expression Type Derivation' of 'Isolation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ISOLATION_EXPRESSION__ISOLATION_EXPRESSION_TYPE_DERIVATION = 49;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Isolation Expression Lower Derivation' of 'Isolation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ISOLATION_EXPRESSION__ISOLATION_EXPRESSION_LOWER_DERIVATION = 50;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Isolation Expression Upper Derivation' of 'Isolation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ISOLATION_EXPRESSION__ISOLATION_EXPRESSION_UPPER_DERIVATION = 51;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Binary Expression Operand Multiplicity' of 'Binary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BINARY_EXPRESSION__BINARY_EXPRESSION_OPERAND_MULTIPLICITY = 52;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Binary Expression Operand Assignments' of 'Binary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BINARY_EXPRESSION__BINARY_EXPRESSION_OPERAND_ASSIGNMENTS = 53;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Boolean Unary Expression Type Derivation' of 'Boolean Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BOOLEAN_UNARY_EXPRESSION__BOOLEAN_UNARY_EXPRESSION_TYPE_DERIVATION = 54;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Boolean Unary Expression Lower Derivation' of 'Boolean Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BOOLEAN_UNARY_EXPRESSION__BOOLEAN_UNARY_EXPRESSION_LOWER_DERIVATION = 55;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Boolean Unary Expression Upper Derivation' of 'Boolean Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BOOLEAN_UNARY_EXPRESSION__BOOLEAN_UNARY_EXPRESSION_UPPER_DERIVATION = 56;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Boolean Unary Expression Operand' of 'Boolean Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BOOLEAN_UNARY_EXPRESSION__BOOLEAN_UNARY_EXPRESSION_OPERAND = 57;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Cast Expression Type Derivation' of 'Cast Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CAST_EXPRESSION__CAST_EXPRESSION_TYPE_DERIVATION = 58;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Cast Expression Lower Derivation' of 'Cast Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CAST_EXPRESSION__CAST_EXPRESSION_LOWER_DERIVATION = 59;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Cast Expression Upper Derivation' of 'Cast Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CAST_EXPRESSION__CAST_EXPRESSION_UPPER_DERIVATION = 60;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Cast Expression Type Resolution' of 'Cast Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CAST_EXPRESSION__CAST_EXPRESSION_TYPE_RESOLUTION = 61;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Cast Expression Assignments Before' of 'Cast Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CAST_EXPRESSION__CAST_EXPRESSION_ASSIGNMENTS_BEFORE = 62;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Positional Tuple Arguments' of 'Positional Tuple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int POSITIONAL_TUPLE__POSITIONAL_TUPLE_ARGUMENTS = 63;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Tuple Input Derivation' of 'Tuple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TUPLE__TUPLE_INPUT_DERIVATION = 64;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Tuple Output Derivation' of 'Tuple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TUPLE__TUPLE_OUTPUT_DERIVATION = 65;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Tuple Null Inputs' of 'Tuple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TUPLE__TUPLE_NULL_INPUTS = 66;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Tuple Outputs' of 'Tuple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TUPLE__TUPLE_OUTPUTS = 67;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Tuple Assignments Before' of 'Tuple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TUPLE__TUPLE_ASSIGNMENTS_BEFORE = 68;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Tuple Assignments After' of 'Tuple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TUPLE__TUPLE_ASSIGNMENTS_AFTER = 69;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Named Expression Is Collection Conversion Derivation' of 'Input Named Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INPUT_NAMED_EXPRESSION__NAMED_EXPRESSION_IS_COLLECTION_CONVERSION_DERIVATION = 70;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Named Expression Is Bit String Conversion Derivation' of 'Input Named Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INPUT_NAMED_EXPRESSION__NAMED_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION = 71;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Is Behavior Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_BEHAVIOR_DERIVATION = 72;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Is Association End Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_ASSOCIATION_END_DERIVATION = 73;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Is Operation Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_OPERATION_DERIVATION = 74;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Is Destructor Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_DESTRUCTOR_DERIVATION = 75;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Is Implicit Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_IMPLICIT_DERIVATION = 76;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Is Signal Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_SIGNAL_DERIVATION = 77;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Parameter Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_PARAMETER_DERIVATION = 78;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Type Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_TYPE_DERIVATION = 79;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Upper Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_UPPER_DERIVATION = 80;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Lower Derivation' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_LOWER_DERIVATION = 81;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Assignments Before' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_ASSIGNMENTS_BEFORE = 82;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Invocation Expression Template Parameters' of 'Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_TEMPLATE_PARAMETERS = 83;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Output Named Expression Left Hand Side Derivation' of 'Output Named Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OUTPUT_NAMED_EXPRESSION__OUTPUT_NAMED_EXPRESSION_LEFT_HAND_SIDE_DERIVATION = 84;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Output Named Expression Form' of 'Output Named Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OUTPUT_NAMED_EXPRESSION__OUTPUT_NAMED_EXPRESSION_FORM = 85;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Left Hand Side Index Expression' of 'Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LEFT_HAND_SIDE__LEFT_HAND_SIDE_INDEX_EXPRESSION = 86;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Access Expression Type Derivation' of 'Sequence Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_TYPE_DERIVATION = 87;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Access Expression Lower Derivation' of 'Sequence Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_LOWER_DERIVATION = 88;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Access Expression Upper Derivation' of 'Sequence Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_UPPER_DERIVATION = 89;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Access Expression Index Type' of 'Sequence Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_INDEX_TYPE = 90;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Access Expression Index Multiplicity' of 'Sequence Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_INDEX_MULTIPLICITY = 91;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'String Literal Expression Type Derivation' of 'String Literal Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRING_LITERAL_EXPRESSION__STRING_LITERAL_EXPRESSION_TYPE_DERIVATION = 92;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Literal Expression Upper Derivation' of 'Literal Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LITERAL_EXPRESSION__LITERAL_EXPRESSION_UPPER_DERIVATION = 93;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Literal Expression Lower Derivation' of 'Literal Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LITERAL_EXPRESSION__LITERAL_EXPRESSION_LOWER_DERIVATION = 94;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Referent Derivation' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_REFERENT_DERIVATION = 95;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Feature Derivation' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_FEATURE_DERIVATION = 96;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Operation Referent' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_OPERATION_REFERENT = 97;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Target Compatibility' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_TARGET_COMPATIBILITY = 98;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Argument Compatibility' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY = 99;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Assignments Before' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_ASSIGNMENTS_BEFORE = 100;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Is Collection Conversion Derivation' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_IS_COLLECTION_CONVERSION_DERIVATION = 101;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Is Bit String Conversion Derivation' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION = 102;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Assignments After' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_ASSIGNMENTS_AFTER = 103;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Operation Expression Left Hand Side Derivation' of 'Sequence Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_LEFT_HAND_SIDE_DERIVATION = 104;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Select Or Reject Expression Type Derivation' of 'Select Or Reject Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SELECT_OR_REJECT_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_TYPE_DERIVATION = 105;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Select Or Reject Expression Lower Derivation' of 'Select Or Reject Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SELECT_OR_REJECT_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_LOWER_DERIVATION = 106;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Select Or Reject Expression Upper Derivation' of 'Select Or Reject Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SELECT_OR_REJECT_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_UPPER_DERIVATION = 107;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Select Or Reject Expression Argument' of 'Select Or Reject Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SELECT_OR_REJECT_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_ARGUMENT = 108;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Extent Expression Type Derivation' of 'Class Extent Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS_EXTENT_EXPRESSION__CLASS_EXTENT_EXPRESSION_TYPE_DERIVATION = 109;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Extent Expression Upper Derivation' of 'Class Extent Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS_EXTENT_EXPRESSION__CLASS_EXTENT_EXPRESSION_UPPER_DERIVATION = 110;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Extent Expression Lower Derivation' of 'Class Extent Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS_EXTENT_EXPRESSION__CLASS_EXTENT_EXPRESSION_LOWER_DERIVATION = 111;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Extent Expression Extent Type' of 'Class Extent Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS_EXTENT_EXPRESSION__CLASS_EXTENT_EXPRESSION_EXTENT_TYPE = 112;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Logical Expression Type Derivation' of 'Conditional Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_LOGICAL_EXPRESSION__CONDITIONAL_LOGICAL_EXPRESSION_TYPE_DERIVATION = 113;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Logical Expression Lower' of 'Conditional Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_LOGICAL_EXPRESSION__CONDITIONAL_LOGICAL_EXPRESSION_LOWER = 114;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Logical Expression Upper' of 'Conditional Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_LOGICAL_EXPRESSION__CONDITIONAL_LOGICAL_EXPRESSION_UPPER = 115;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Logical Expression Operands' of 'Conditional Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_LOGICAL_EXPRESSION__CONDITIONAL_LOGICAL_EXPRESSION_OPERANDS = 116;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Link Operation Expression Is Creation Derivation' of 'Link Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_IS_CREATION_DERIVATION = 117;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Link Operation Expression Is Clear Derivation' of 'Link Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_IS_CLEAR_DERIVATION = 118;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Link Operation Expression Referent Derivation' of 'Link Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_REFERENT_DERIVATION = 119;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Link Operation Expression Feature Derivation' of 'Link Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_FEATURE_DERIVATION = 120;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Link Operation Expression Association Reference' of 'Link Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_ASSOCIATION_REFERENCE = 121;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Link Operation Expression Argument Compatibility' of 'Link Operation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY = 122;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Equality Expression Is Negated Derivation' of 'Equality Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUALITY_EXPRESSION__EQUALITY_EXPRESSION_IS_NEGATED_DERIVATION = 123;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Equality Expression Type Derivation' of 'Equality Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUALITY_EXPRESSION__EQUALITY_EXPRESSION_TYPE_DERIVATION = 124;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Equality Expression Lower Derivation' of 'Equality Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUALITY_EXPRESSION__EQUALITY_EXPRESSION_LOWER_DERIVATION = 125;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Equality Expression Upper Derivation' of 'Equality Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUALITY_EXPRESSION__EQUALITY_EXPRESSION_UPPER_DERIVATION = 126;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Is Simple Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_SIMPLE_DERIVATION = 127;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Is Arithmetic Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_ARITHMETIC_DERIVATION = 128;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Is Definition Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_DEFINITION_DERIVATION = 129;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Is Feature Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_FEATURE_DERIVATION = 130;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Is Indexed Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_INDEXED_DERIVATION = 131;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Is Data Value Update Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_DATA_VALUE_UPDATE_DERIVATION = 132;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Assignment Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_ASSIGNMENT_DERIVATION = 133;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Feature Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_FEATURE_DERIVATION = 134;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Expression Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_EXPRESSION_DERIVATION = 135;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Type Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_TYPE_DERIVATION = 136;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Upper Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_UPPER_DERIVATION = 137;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Lower Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_LOWER_DERIVATION = 138;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Simple Assignment Type Conformance' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_TYPE_CONFORMANCE = 139;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Simple Assignment Multiplicity Conformance' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_MULTIPLICITY_CONFORMANCE = 140;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Compound Assignment Type Conformance' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_TYPE_CONFORMANCE = 141;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Compound Assignment Multiplicity Conformance' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_MULTIPLICITY_CONFORMANCE = 142;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Assignments Before' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_ASSIGNMENTS_BEFORE = 143;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Is Collection Conversion Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_COLLECTION_CONVERSION_DERIVATION = 144;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Is Bit String Conversion Derivation' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION = 145;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Assignment Expression Data Value Update Legality' of 'Assignment Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_DATA_VALUE_UPDATE_LEGALITY = 146;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Logical Expression Type Derivation' of 'Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOGICAL_EXPRESSION__LOGICAL_EXPRESSION_TYPE_DERIVATION = 147;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Logical Expression Lower Derivation' of 'Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOGICAL_EXPRESSION__LOGICAL_EXPRESSION_LOWER_DERIVATION = 148;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Logical Expression Upper Derivation' of 'Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOGICAL_EXPRESSION__LOGICAL_EXPRESSION_UPPER_DERIVATION = 149;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Logical Expression Operands' of 'Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOGICAL_EXPRESSION__LOGICAL_EXPRESSION_OPERANDS = 150;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Logical Expression Is Bit String Conversion1 Derivation' of 'Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOGICAL_EXPRESSION__LOGICAL_EXPRESSION_IS_BIT_STRING_CONVERSION1_DERIVATION = 151;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Logical Expression Is Bit String Conversion2 Derivation' of 'Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOGICAL_EXPRESSION__LOGICAL_EXPRESSION_IS_BIT_STRING_CONVERSION2_DERIVATION = 152;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Logical Expression Is Bit Wise Derivation' of 'Logical Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOGICAL_EXPRESSION__LOGICAL_EXPRESSION_IS_BIT_WISE_DERIVATION = 153;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Construction Expression Type Derivation' of 'Sequence Construction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_TYPE_DERIVATION = 154;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Construction Expression Upper Derivation' of 'Sequence Construction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_UPPER_DERIVATION = 155;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Construction Expression Lower Derivation' of 'Sequence Construction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_LOWER_DERIVATION = 156;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Construction Expression Type' of 'Sequence Construction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_TYPE = 157;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Construction Expression Element Type' of 'Sequence Construction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_ELEMENT_TYPE = 158;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Construction Expression Assignments Before' of 'Sequence Construction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_ASSIGNMENTS_BEFORE = 159;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Collect Or Iterate Expression Type Derivation' of 'Collect Or Iterate Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECT_OR_ITERATE_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_TYPE_DERIVATION = 160;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Collect Or Iterate Expression Lower Derivation' of 'Collect Or Iterate Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECT_OR_ITERATE_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_LOWER_DERIVATION = 161;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Collect Or Iterate Expression Upper Derivation' of 'Collect Or Iterate Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECT_OR_ITERATE_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_UPPER_DERIVATION = 162;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Unique Expression Type Derivation' of 'Is Unique Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IS_UNIQUE_EXPRESSION__IS_UNIQUE_EXPRESSION_TYPE_DERIVATION = 163;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Unique Expression Lower Derivation' of 'Is Unique Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IS_UNIQUE_EXPRESSION__IS_UNIQUE_EXPRESSION_LOWER_DERIVATION = 164;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Unique Expression Upper Derivation' of 'Is Unique Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IS_UNIQUE_EXPRESSION__IS_UNIQUE_EXPRESSION_UPPER_DERIVATION = 165;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Unique Expression Expression Argument' of 'Is Unique Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IS_UNIQUE_EXPRESSION__IS_UNIQUE_EXPRESSION_EXPRESSION_ARGUMENT = 166;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Arithmetic Expression Is Concatenation Derivation' of 'Arithmetic Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ARITHMETIC_EXPRESSION__ARITHMETIC_EXPRESSION_IS_CONCATENATION_DERIVATION = 167;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Arithmetic Expression Type Derivation' of 'Arithmetic Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ARITHMETIC_EXPRESSION__ARITHMETIC_EXPRESSION_TYPE_DERIVATION = 168;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Arithmetic Expression Lower Derivation' of 'Arithmetic Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ARITHMETIC_EXPRESSION__ARITHMETIC_EXPRESSION_LOWER_DERIVATION = 169;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Arithmetic Expression Upper Derivation' of 'Arithmetic Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ARITHMETIC_EXPRESSION__ARITHMETIC_EXPRESSION_UPPER_DERIVATION = 170;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Arithmetic Expression Operand Types' of 'Arithmetic Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ARITHMETIC_EXPRESSION__ARITHMETIC_EXPRESSION_OPERAND_TYPES = 171;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Assignment Before Derivation' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_ASSIGNMENT_BEFORE_DERIVATION = 172;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Assignment After Derivation' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_ASSIGNMENT_AFTER_DERIVATION = 173;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Feature Expression' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_FEATURE_EXPRESSION = 174;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Assignments Before' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_ASSIGNMENTS_BEFORE = 175;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Referent Derivation' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_REFERENT_DERIVATION = 176;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Type Derivation' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_TYPE_DERIVATION = 177;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Lower Derivation' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_LOWER_DERIVATION = 178;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Upper Derivation' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_UPPER_DERIVATION = 179;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Referent Constraint' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_REFERENT_CONSTRAINT = 180;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Left Hand Side Indexed Feature' of 'Feature Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_INDEXED_FEATURE = 181;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Test Expression Type Derivation' of 'Conditional Test Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_TEST_EXPRESSION__CONDITIONAL_TEST_EXPRESSION_TYPE_DERIVATION = 182;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Test Expression Lower Derivation' of 'Conditional Test Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_TEST_EXPRESSION__CONDITIONAL_TEST_EXPRESSION_LOWER_DERIVATION = 183;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Test Expression Upper Derivation' of 'Conditional Test Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_TEST_EXPRESSION__CONDITIONAL_TEST_EXPRESSION_UPPER_DERIVATION = 184;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Test Expression Condition' of 'Conditional Test Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_TEST_EXPRESSION__CONDITIONAL_TEST_EXPRESSION_CONDITION = 185;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Test Expression Assignments Before' of 'Conditional Test Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_TEST_EXPRESSION__CONDITIONAL_TEST_EXPRESSION_ASSIGNMENTS_BEFORE = 186;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Conditional Test Expression Assignments After' of 'Conditional Test Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_TEST_EXPRESSION__CONDITIONAL_TEST_EXPRESSION_ASSIGNMENTS_AFTER = 187;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Instance Creation Expression Is Object Creation Derivation' of 'Instance Creation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_IS_OBJECT_CREATION_DERIVATION = 188;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Instance Creation Expression Is Constructorless Derivation' of 'Instance Creation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_IS_CONSTRUCTORLESS_DERIVATION = 189;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Instance Creation Expression Referent Derivation' of 'Instance Creation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_REFERENT_DERIVATION = 190;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Instance Creation Expression Feature Derivation' of 'Instance Creation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_FEATURE_DERIVATION = 191;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Instance Creation Expression Constructor' of 'Instance Creation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_CONSTRUCTOR = 192;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Instance Creation Expression Constructorless Legality' of 'Instance Creation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_CONSTRUCTORLESS_LEGALITY = 193;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Instance Creation Expression Data Type Compatibility' of 'Instance Creation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_DATA_TYPE_COMPATIBILITY = 194;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Instance Creation Expression Referent' of 'Instance Creation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_REFERENT = 195;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Access Expression Feature Derivation' of 'Property Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_FEATURE_DERIVATION = 196;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Access Expression Type Derivation' of 'Property Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_TYPE_DERIVATION = 197;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Access Expression Upper Derivation' of 'Property Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_UPPER_DERIVATION = 198;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Access Expression Lower Derivation' of 'Property Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_LOWER_DERIVATION = 199;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Access Expression Feature Resolution' of 'Property Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_FEATURE_RESOLUTION = 200;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Access Expression Assignments Before' of 'Property Access Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_ASSIGNMENTS_BEFORE = 201;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Expression Assignment Derivation' of 'Name Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_EXPRESSION__NAME_EXPRESSION_ASSIGNMENT_DERIVATION = 202;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Expression Enumeration Literal Derivation' of 'Name Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_EXPRESSION__NAME_EXPRESSION_ENUMERATION_LITERAL_DERIVATION = 203;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Expression Property Access Derivation' of 'Name Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_EXPRESSION__NAME_EXPRESSION_PROPERTY_ACCESS_DERIVATION = 204;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Expression Type Derivation' of 'Name Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_EXPRESSION__NAME_EXPRESSION_TYPE_DERIVATION = 205;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Expression Upper Derivation' of 'Name Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_EXPRESSION__NAME_EXPRESSION_UPPER_DERIVATION = 206;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Expression Lower Derivation' of 'Name Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_EXPRESSION__NAME_EXPRESSION_LOWER_DERIVATION = 207;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Expression Resolution' of 'Name Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_EXPRESSION__NAME_EXPRESSION_RESOLUTION = 208;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Bit String Unary Expression Type Derivation' of 'Bit String Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BIT_STRING_UNARY_EXPRESSION__BIT_STRING_UNARY_EXPRESSION_TYPE_DERIVATION = 209;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Bit String Unary Expression Lower Derivation' of 'Bit String Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BIT_STRING_UNARY_EXPRESSION__BIT_STRING_UNARY_EXPRESSION_LOWER_DERIVATION = 210;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Bit String Unary Expression Upper Derivation' of 'Bit String Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BIT_STRING_UNARY_EXPRESSION__BIT_STRING_UNARY_EXPRESSION_UPPER_DERIVATION = 211;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Bit String Unary Expression Operand' of 'Bit String Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BIT_STRING_UNARY_EXPRESSION__BIT_STRING_UNARY_EXPRESSION_OPERAND = 212;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Bit String Unary Expression Is Bit String Conversion Derivation' of 'Bit String Unary Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BIT_STRING_UNARY_EXPRESSION__BIT_STRING_UNARY_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION = 213;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Invocation Expression Referent Derivation' of 'Feature Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_REFERENT_DERIVATION = 214;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Invocation Expression Feature Derivation' of 'Feature Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_FEATURE_DERIVATION = 215;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Invocation Expression Referent Exists' of 'Feature Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_REFERENT_EXISTS = 216;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Invocation Expression Alternative Constructor' of 'Feature Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR = 217;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Feature Invocation Expression Implicit Alternative Constructor' of 'Feature Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_IMPLICIT_ALTERNATIVE_CONSTRUCTOR = 218;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Behavior Invocation Expression Referent Derivation' of 'Behavior Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_REFERENT_DERIVATION = 219;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Behavior Invocation Expression Feature Derivation' of 'Behavior Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_FEATURE_DERIVATION = 220;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Behavior Invocation Expression Referent Constraint' of 'Behavior Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_REFERENT_CONSTRAINT = 221;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Behavior Invocation Expression Argument Compatibility' of 'Behavior Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_ARGUMENT_COMPATIBILITY = 222;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Behavior Invocation Expression Alternative Constructor' of 'Behavior Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR = 223;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Shift Expression Type Derivation' of 'Shift Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHIFT_EXPRESSION__SHIFT_EXPRESSION_TYPE_DERIVATION = 224;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Shift Expression Lower Derivation' of 'Shift Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHIFT_EXPRESSION__SHIFT_EXPRESSION_LOWER_DERIVATION = 225;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Shift Expression Upper Derivation' of 'Shift Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHIFT_EXPRESSION__SHIFT_EXPRESSION_UPPER_DERIVATION = 226;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Shift Expression Operands' of 'Shift Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHIFT_EXPRESSION__SHIFT_EXPRESSION_OPERANDS = 227;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Shift Expression Is Bit String Conversion Derivation' of 'Shift Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHIFT_EXPRESSION__SHIFT_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION = 228;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Unbounded Literal Expression Type Derivation' of 'Unbounded Literal Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNBOUNDED_LITERAL_EXPRESSION__UNBOUNDED_LITERAL_EXPRESSION_TYPE_DERIVATION = 229;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Expression Type Derivation' of 'This Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int THIS_EXPRESSION__THIS_EXPRESSION_TYPE_DERIVATION = 230;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Expression Upper Derivation' of 'This Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int THIS_EXPRESSION__THIS_EXPRESSION_UPPER_DERIVATION = 231;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Expression Lower Derivation' of 'This Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int THIS_EXPRESSION__THIS_EXPRESSION_LOWER_DERIVATION = 232;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classification Expression Is Direct Derivation' of 'Classification Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_IS_DIRECT_DERIVATION = 233;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classification Expression Referent Derivation' of 'Classification Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_REFERENT_DERIVATION = 234;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classification Expression Type Derivation' of 'Classification Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_TYPE_DERIVATION = 235;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classification Expression Lower Derivation' of 'Classification Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_LOWER_DERIVATION = 236;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classification Expression Upper Derivation' of 'Classification Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_UPPER_DERIVATION = 237;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classification Expression Type Name' of 'Classification Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_TYPE_NAME = 238;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classification Expression Operand' of 'Classification Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_OPERAND = 239;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Super Invocation Expression Referent Derivation' of 'Super Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_REFERENT_DERIVATION = 240;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Super Invocation Expression Feature Derivation' of 'Super Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_FEATURE_DERIVATION = 241;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Super Invocation Expression Qualification' of 'Super Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_QUALIFICATION = 242;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Super Invocation Expression Implicit Target' of 'Super Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_IMPLICIT_TARGET = 243;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Super Invocation Expression Constructor Call' of 'Super Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_CONSTRUCTOR_CALL = 244;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Super Invocation Expression Destructor Call' of 'Super Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_DESTRUCTOR_CALL = 245;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Super Invocation Expression Operation' of 'Super Invocation Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_OPERATION = 246;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Assignment Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_ASSIGNMENT_DERIVATION = 247;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Is Feature Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_IS_FEATURE_DERIVATION = 248;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Is Indexed Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_IS_INDEXED_DERIVATION = 249;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Is Data Value Update Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_IS_DATA_VALUE_UPDATE_DERIVATION = 250;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Feature Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_FEATURE_DERIVATION = 251;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Expression Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_EXPRESSION_DERIVATION = 252;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Type Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_TYPE_DERIVATION = 253;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Lower Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_LOWER_DERIVATION = 254;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Upper Derivation' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_UPPER_DERIVATION = 255;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Operand' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_OPERAND = 256;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Increment Or Decrement Expression Assignments Before' of 'Increment Or Decrement Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_ASSIGNMENTS_BEFORE = 257;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Boolean Literal Expression Type Derivation' of 'Boolean Literal Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BOOLEAN_LITERAL_EXPRESSION__BOOLEAN_LITERAL_EXPRESSION_TYPE_DERIVATION = 258;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Named Tuple Argument Names' of 'Named Tuple'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMED_TUPLE__NAMED_TUPLE_ARGUMENT_NAMES = 259;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Natural Literal Expression Type Derivation' of 'Natural Literal Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NATURAL_LITERAL_EXPRESSION__NATURAL_LITERAL_EXPRESSION_TYPE_DERIVATION = 260;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Range Lower Derivation' of 'Sequence Range'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_RANGE__SEQUENCE_RANGE_LOWER_DERIVATION = 261;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Range Upper Derivation' of 'Sequence Range'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_RANGE__SEQUENCE_RANGE_UPPER_DERIVATION = 262;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Range Expression Multiplicity' of 'Sequence Range'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_RANGE__SEQUENCE_RANGE_EXPRESSION_MULTIPLICITY = 263;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Range Assignments' of 'Sequence Range'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_RANGE__SEQUENCE_RANGE_ASSIGNMENTS = 264;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Assignment After Derivation' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_ASSIGNMENT_AFTER_DERIVATION = 265;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Target Assignment' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_TARGET_ASSIGNMENT = 266;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Assignments Before' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_ASSIGNMENTS_BEFORE = 267;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Referent Derivation' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_REFERENT_DERIVATION = 268;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Lower Derivation' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_LOWER_DERIVATION = 269;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Upper Derivation' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_UPPER_DERIVATION = 270;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Type Derivation' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_TYPE_DERIVATION = 271;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Target Resolution' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_TARGET_RESOLUTION = 272;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Indexed Feature' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_INDEXED_FEATURE = 273;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Left Hand Side Nontemplate Target' of 'Name Left Hand Side'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_NONTEMPLATE_TARGET = 274;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Reduction Expression Referent Derivation' of 'Sequence Reduction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_REDUCTION_EXPRESSION__SEQUENCE_REDUCTION_EXPRESSION_REFERENT_DERIVATION = 275;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Reduction Expression Type Derivation' of 'Sequence Reduction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_REDUCTION_EXPRESSION__SEQUENCE_REDUCTION_EXPRESSION_TYPE_DERIVATION = 276;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Reduction Expression Upper Derivation' of 'Sequence Reduction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_REDUCTION_EXPRESSION__SEQUENCE_REDUCTION_EXPRESSION_UPPER_DERIVATION = 277;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Reduction Expression Lower Derivation' of 'Sequence Reduction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_REDUCTION_EXPRESSION__SEQUENCE_REDUCTION_EXPRESSION_LOWER_DERIVATION = 278;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Reduction Expression Behavior' of 'Sequence Reduction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_REDUCTION_EXPRESSION__SEQUENCE_REDUCTION_EXPRESSION_BEHAVIOR = 279;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Reduction Expression Behavior Parameters' of 'Sequence Reduction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_REDUCTION_EXPRESSION__SEQUENCE_REDUCTION_EXPRESSION_BEHAVIOR_PARAMETERS = 280;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Reduction Expression Assignments Before' of 'Sequence Reduction Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_REDUCTION_EXPRESSION__SEQUENCE_REDUCTION_EXPRESSION_ASSIGNMENTS_BEFORE = 281;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Expression List Lower Derivation' of 'Sequence Expression List'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPRESSION_LIST__SEQUENCE_EXPRESSION_LIST_LOWER_DERIVATION = 282;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sequence Expression List Upper Derivation' of 'Sequence Expression List'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEQUENCE_EXPRESSION_LIST__SEQUENCE_EXPRESSION_LIST_UPPER_DERIVATION = 283;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Relational Expression Is Unlimited Natural Derivation' of 'Relational Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATIONAL_EXPRESSION__RELATIONAL_EXPRESSION_IS_UNLIMITED_NATURAL_DERIVATION = 284;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Relational Expression Type Derivation' of 'Relational Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATIONAL_EXPRESSION__RELATIONAL_EXPRESSION_TYPE_DERIVATION = 285;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Relational Expression Lower Derivation' of 'Relational Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATIONAL_EXPRESSION__RELATIONAL_EXPRESSION_LOWER_DERIVATION = 286;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Relational Expression Upper Derivation' of 'Relational Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATIONAL_EXPRESSION__RELATIONAL_EXPRESSION_UPPER_DERIVATION = 287;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Relational Expression Operand Types' of 'Relational Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATIONAL_EXPRESSION__RELATIONAL_EXPRESSION_OPERAND_TYPES = 288;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Local Name Declaration Statement Assignments Before' of 'Local Name Declaration Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_ASSIGNMENTS_BEFORE = 289;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Local Name Declaration Statement Type' of 'Local Name Declaration Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_TYPE = 290;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Local Name Declaration Statement Local Name' of 'Local Name Declaration Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_LOCAL_NAME = 291;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Local Name Declaration Statement Assignments After' of 'Local Name Declaration Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_ASSIGNMENTS_AFTER = 292;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Local Name Declaration Statement Expression Multiplicity' of 'Local Name Declaration Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_EXPRESSION_MULTIPLICITY = 293;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Local Name Declaration Statement Type Derivation' of 'Local Name Declaration Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_TYPE_DERIVATION = 294;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Statement Annotations Allowed' of 'Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATEMENT__STATEMENT_ANNOTATIONS_ALLOWED = 295;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Statement Unique Assignments' of 'Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATEMENT__STATEMENT_UNIQUE_ASSIGNMENTS = 296;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Statement Is Isolated Derivation' of 'Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATEMENT__STATEMENT_IS_ISOLATED_DERIVATION = 297;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Non Final Clause Assignments Before Body' of 'Non Final Clause'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NON_FINAL_CLAUSE__NON_FINAL_CLAUSE_ASSIGNMENTS_BEFORE_BODY = 298;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Non Final Clause Condition Local Names' of 'Non Final Clause'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NON_FINAL_CLAUSE__NON_FINAL_CLAUSE_CONDITION_LOCAL_NAMES = 299;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Non Final Clause Condition Type' of 'Non Final Clause'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NON_FINAL_CLAUSE__NON_FINAL_CLAUSE_CONDITION_TYPE = 300;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Block Assignments Before Statements' of 'Block'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BLOCK__BLOCK_ASSIGNMENTS_BEFORE_STATEMENTS = 301;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Block Assignments Before' of 'Block'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BLOCK__BLOCK_ASSIGNMENTS_BEFORE = 302;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Block Assignment After Derivation' of 'Block'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BLOCK__BLOCK_ASSIGNMENT_AFTER_DERIVATION = 303;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Block Statement Parallel Assignments' of 'Block Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BLOCK_STATEMENT__BLOCK_STATEMENT_PARALLEL_ASSIGNMENTS = 304;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Block Statement Assignments Before' of 'Block Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BLOCK_STATEMENT__BLOCK_STATEMENT_ASSIGNMENTS_BEFORE = 305;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Block Statement Assignments After' of 'Block Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BLOCK_STATEMENT__BLOCK_STATEMENT_ASSIGNMENTS_AFTER = 306;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Block Statement Enclosed Statements' of 'Block Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BLOCK_STATEMENT__BLOCK_STATEMENT_ENCLOSED_STATEMENTS = 307;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Block Statement Is Parallel Derivation' of 'Block Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BLOCK_STATEMENT__BLOCK_STATEMENT_IS_PARALLEL_DERIVATION = 308;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Do Statement Assignments Before' of 'Do Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DO_STATEMENT__DO_STATEMENT_ASSIGNMENTS_BEFORE = 309;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Do Statement Assignments After' of 'Do Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DO_STATEMENT__DO_STATEMENT_ASSIGNMENTS_AFTER = 310;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Do Statement Condition' of 'Do Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DO_STATEMENT__DO_STATEMENT_CONDITION = 311;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Do Statement Enclosed Statements' of 'Do Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DO_STATEMENT__DO_STATEMENT_ENCLOSED_STATEMENTS = 312;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Concurrent Clauses Assignments Before' of 'Concurrent Clauses'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONCURRENT_CLAUSES__CONCURRENT_CLAUSES_ASSIGNMENTS_BEFORE = 313;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Concurrent Clauses Condition Assignments' of 'Concurrent Clauses'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONCURRENT_CLAUSES__CONCURRENT_CLAUSES_CONDITION_ASSIGNMENTS = 314;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Break Statement Target Derivation' of 'Break Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BREAK_STATEMENT__BREAK_STATEMENT_TARGET_DERIVATION = 315;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Break Statement Nonparallel Target' of 'Break Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BREAK_STATEMENT__BREAK_STATEMENT_NONPARALLEL_TARGET = 316;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Expression Statement Assignments Before' of 'Expression Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXPRESSION_STATEMENT__EXPRESSION_STATEMENT_ASSIGNMENTS_BEFORE = 317;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Expression Statement Assignments After' of 'Expression Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXPRESSION_STATEMENT__EXPRESSION_STATEMENT_ASSIGNMENTS_AFTER = 318;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classify Statement Expression' of 'Classify Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_EXPRESSION = 319;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classify Statement Class Names' of 'Classify Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_CLASS_NAMES = 320;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classify Statement Classes' of 'Classify Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_CLASSES = 321;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classify Statement Assignments Before' of 'Classify Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_ASSIGNMENTS_BEFORE = 322;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classify Statement Assignments After' of 'Classify Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_ASSIGNMENTS_AFTER = 323;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classify Statement From Class Derivation' of 'Classify Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_FROM_CLASS_DERIVATION = 324;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classify Statement To Class Derivation' of 'Classify Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_TO_CLASS_DERIVATION = 325;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Statement Assignments Before' of 'For Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_STATEMENT__FOR_STATEMENT_ASSIGNMENTS_BEFORE = 326;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Statement Assignments After' of 'For Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_STATEMENT__FOR_STATEMENT_ASSIGNMENTS_AFTER = 327;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Statement Parallel Annotation Names' of 'For Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_STATEMENT__FOR_STATEMENT_PARALLEL_ANNOTATION_NAMES = 328;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Statement Parallel Assignments After' of 'For Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_STATEMENT__FOR_STATEMENT_PARALLEL_ASSIGNMENTS_AFTER = 329;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Statement Variable Definitions' of 'For Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_STATEMENT__FOR_STATEMENT_VARIABLE_DEFINITIONS = 330;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Statement Loop Variables' of 'For Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_STATEMENT__FOR_STATEMENT_LOOP_VARIABLES = 331;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Statement Is Parallel Derivation' of 'For Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_STATEMENT__FOR_STATEMENT_IS_PARALLEL_DERIVATION = 332;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'For Statement Enclosed Statements' of 'For Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOR_STATEMENT__FOR_STATEMENT_ENCLOSED_STATEMENTS = 333;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Loop Variable Definition Assignment After Derivation' of 'Loop Variable Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_ASSIGNMENT_AFTER_DERIVATION = 334;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Loop Variable Definition Assignments Before' of 'Loop Variable Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_ASSIGNMENTS_BEFORE = 335;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Loop Variable Definition Range Expressions' of 'Loop Variable Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_RANGE_EXPRESSIONS = 336;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Loop Variable Definition Type Name' of 'Loop Variable Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_TYPE_NAME = 337;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Loop Variable Definition Type Derivation' of 'Loop Variable Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_TYPE_DERIVATION = 338;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Loop Variable Definition Declared Type' of 'Loop Variable Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_DECLARED_TYPE = 339;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Loop Variable Definition Is Collection Conversion Derivation' of 'Loop Variable Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_IS_COLLECTION_CONVERSION_DERIVATION = 340;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Loop Variable Definition Variable' of 'Loop Variable Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_VARIABLE = 341;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'If Statement Assignments Before' of 'If Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IF_STATEMENT__IF_STATEMENT_ASSIGNMENTS_BEFORE = 342;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'If Statement Assignments After' of 'If Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IF_STATEMENT__IF_STATEMENT_ASSIGNMENTS_AFTER = 343;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'If Statement Enclosed Statements' of 'If Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IF_STATEMENT__IF_STATEMENT_ENCLOSED_STATEMENTS = 344;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'If Statement Is Assured Derivation' of 'If Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IF_STATEMENT__IF_STATEMENT_IS_ASSURED_DERIVATION = 345;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'If Statement Is Determinate Derivation' of 'If Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IF_STATEMENT__IF_STATEMENT_IS_DETERMINATE_DERIVATION = 346;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Statement Assignments Before' of 'Switch Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_STATEMENT__SWITCH_STATEMENT_ASSIGNMENTS_BEFORE = 347;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Statement Case Assignments' of 'Switch Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_STATEMENT__SWITCH_STATEMENT_CASE_ASSIGNMENTS = 348;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Statement Assignments After' of 'Switch Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_STATEMENT__SWITCH_STATEMENT_ASSIGNMENTS_AFTER = 349;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Statement Assignments' of 'Switch Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_STATEMENT__SWITCH_STATEMENT_ASSIGNMENTS = 350;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Statement Expression' of 'Switch Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_STATEMENT__SWITCH_STATEMENT_EXPRESSION = 351;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Statement Enclosed Statements' of 'Switch Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_STATEMENT__SWITCH_STATEMENT_ENCLOSED_STATEMENTS = 352;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Statement Is Determinate Derivation' of 'Switch Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_STATEMENT__SWITCH_STATEMENT_IS_DETERMINATE_DERIVATION = 353;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Statement Is Assured Derivation' of 'Switch Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_STATEMENT__SWITCH_STATEMENT_IS_ASSURED_DERIVATION = 354;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Clause Assignments Before' of 'Switch Clause'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_CLAUSE__SWITCH_CLAUSE_ASSIGNMENTS_BEFORE = 355;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Clause Case Local Names' of 'Switch Clause'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_CLAUSE__SWITCH_CLAUSE_CASE_LOCAL_NAMES = 356;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Switch Clause Cases' of 'Switch Clause'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SWITCH_CLAUSE__SWITCH_CLAUSE_CASES = 357;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'While Statement Assignments Before' of 'While Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WHILE_STATEMENT__WHILE_STATEMENT_ASSIGNMENTS_BEFORE = 358;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'While Statement Assignments After' of 'While Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WHILE_STATEMENT__WHILE_STATEMENT_ASSIGNMENTS_AFTER = 359;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'While Statement Condition' of 'While Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WHILE_STATEMENT__WHILE_STATEMENT_CONDITION = 360;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'While Statement Enclosed Statements' of 'While Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WHILE_STATEMENT__WHILE_STATEMENT_ENCLOSED_STATEMENTS = 361;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Return Statement Context' of 'Return Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RETURN_STATEMENT__RETURN_STATEMENT_CONTEXT = 362;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Return Statement Assignments Before' of 'Return Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RETURN_STATEMENT__RETURN_STATEMENT_ASSIGNMENTS_BEFORE = 363;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Return Statement Assignments After' of 'Return Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RETURN_STATEMENT__RETURN_STATEMENT_ASSIGNMENTS_AFTER = 364;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'In Line Statement Assignments After' of 'In Line Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IN_LINE_STATEMENT__IN_LINE_STATEMENT_ASSIGNMENTS_AFTER = 365;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Context' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_CONTEXT = 366;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Signals' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_SIGNALS = 367;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Names' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_NAMES = 368;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Simple Accept Local Name' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_SIMPLE_ACCEPT_LOCAL_NAME = 369;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Compound Accept Local Name' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_COMPOUND_ACCEPT_LOCAL_NAME = 370;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Assignments Before' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_ASSIGNMENTS_BEFORE = 371;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Assignments After' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_ASSIGNMENTS_AFTER = 372;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement New Assignments' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_NEW_ASSIGNMENTS = 373;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Is Simple Derivation' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_IS_SIMPLE_DERIVATION = 374;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Statement Enclosed Statements' of 'Accept Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_STATEMENT__ACCEPT_STATEMENT_ENCLOSED_STATEMENTS = 375;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Block Signal Derivation' of 'Accept Block'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_BLOCK__ACCEPT_BLOCK_SIGNAL_DERIVATION = 376;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Accept Block Signal Names' of 'Accept Block'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_BLOCK__ACCEPT_BLOCK_SIGNAL_NAMES = 377;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Empty Statement Assignments After' of 'Empty Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EMPTY_STATEMENT__EMPTY_STATEMENT_ASSIGNMENTS_AFTER = 378;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Namespace Definition Member Derivation' of 'Namespace Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMESPACE_DEFINITION__NAMESPACE_DEFINITION_MEMBER_DERIVATION = 379;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Namespace Definition Member Distinguishability' of 'Namespace Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMESPACE_DEFINITION__NAMESPACE_DEFINITION_MEMBER_DISTINGUISHABILITY = 380;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Member Annotations' of 'Member Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEMBER_DEFINITION__MEMBER_ANNOTATIONS = 381;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Member Is Primitive Derivation' of 'Member Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEMBER_DEFINITION__MEMBER_IS_PRIMITIVE_DERIVATION = 382;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Member Is External Derivation' of 'Member Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEMBER_DEFINITION__MEMBER_IS_EXTERNAL_DERIVATION = 383;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Member External' of 'Member Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEMBER_DEFINITION__MEMBER_EXTERNAL = 384;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Member Stub' of 'Member Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEMBER_DEFINITION__MEMBER_STUB = 385;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Member Subunit Derivation' of 'Member Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEMBER_DEFINITION__MEMBER_SUBUNIT_DERIVATION = 386;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Member Stub Stereotypes' of 'Member Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEMBER_DEFINITION__MEMBER_STUB_STEREOTYPES = 387;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Member Primitive' of 'Member Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MEMBER_DEFINITION__MEMBER_PRIMITIVE = 388;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stereotype Annotation Stereotype Derivation' of 'Stereotype Annotation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_STEREOTYPE_DERIVATION = 389;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stereotype Annotation Stereotype Name' of 'Stereotype Annotation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_STEREOTYPE_NAME = 390;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stereotype Annotation Apply' of 'Stereotype Annotation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_APPLY = 391;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stereotype Annotation Primitive' of 'Stereotype Annotation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_PRIMITIVE = 392;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stereotype Annotation External' of 'Stereotype Annotation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_EXTERNAL = 393;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stereotype Annotation Tagged Values' of 'Stereotype Annotation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_TAGGED_VALUES = 394;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stereotype Annotation Names' of 'Stereotype Annotation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_NAMES = 395;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Unit Definition Namespace Derivation' of 'Unit Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNIT_DEFINITION__UNIT_DEFINITION_NAMESPACE_DERIVATION = 396;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Unit Definition Namespace' of 'Unit Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNIT_DEFINITION__UNIT_DEFINITION_NAMESPACE = 397;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Unit Definition Is Model Library Derivation' of 'Unit Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNIT_DEFINITION__UNIT_DEFINITION_IS_MODEL_LIBRARY_DERIVATION = 398;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Unit Definition Implicit Imports' of 'Unit Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNIT_DEFINITION__UNIT_DEFINITION_IMPLICIT_IMPORTS = 399;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Unit Definition Applied Profile Derivation' of 'Unit Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNIT_DEFINITION__UNIT_DEFINITION_APPLIED_PROFILE_DERIVATION = 400;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Import Reference Referent Derivation' of 'Import Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPORT_REFERENCE__IMPORT_REFERENCE_REFERENT_DERIVATION = 401;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Import Reference Referent' of 'Import Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPORT_REFERENCE__IMPORT_REFERENCE_REFERENT = 402;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Imported Member Not Stub' of 'Imported Member'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPORTED_MEMBER__IMPORTED_MEMBER_NOT_STUB = 403;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Imported Member Is Feature Derivation' of 'Imported Member'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPORTED_MEMBER__IMPORTED_MEMBER_IS_FEATURE_DERIVATION = 404;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Namespace' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_NAMESPACE = 405;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Redefined Operation Derivation' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_REDEFINED_OPERATION_DERIVATION = 406;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Redefinition' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_REDEFINITION = 407;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Redefined Operations' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_REDEFINED_OPERATIONS = 408;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Is Feature Derivation' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_IS_FEATURE_DERIVATION = 409;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Is Constructor Derivation' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_IS_CONSTRUCTOR_DERIVATION = 410;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Is Destructor Derivation' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_IS_DESTRUCTOR_DERIVATION = 411;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Constructor Destructor' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_CONSTRUCTOR_DESTRUCTOR = 412;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Constructor' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_CONSTRUCTOR = 413;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Definition Destructor' of 'Operation Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_DEFINITION__OPERATION_DEFINITION_DESTRUCTOR = 414;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Association Definition Specialization Referent' of 'Association Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSOCIATION_DEFINITION__ASSOCIATION_DEFINITION_SPECIALIZATION_REFERENT = 415;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classifier Definition Specialization' of 'Classifier Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER_DEFINITION__CLASSIFIER_DEFINITION_SPECIALIZATION = 416;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classifier Definition Specialization Referent Derivation' of 'Classifier Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER_DEFINITION__CLASSIFIER_DEFINITION_SPECIALIZATION_REFERENT_DERIVATION = 417;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Classifier Definition Inherited Members' of 'Classifier Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER_DEFINITION__CLASSIFIER_DEFINITION_INHERITED_MEMBERS = 418;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Definition Specialization Referent' of 'Class Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS_DEFINITION__CLASS_DEFINITION_SPECIALIZATION_REFERENT = 419;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Definition Abstract Member' of 'Class Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS_DEFINITION__CLASS_DEFINITION_ABSTRACT_MEMBER = 420;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Typed Element Definition Lower Derivation' of 'Typed Element Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TYPED_ELEMENT_DEFINITION__TYPED_ELEMENT_DEFINITION_LOWER_DERIVATION = 421;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Typed Element Definition Upper Derivation' of 'Typed Element Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TYPED_ELEMENT_DEFINITION__TYPED_ELEMENT_DEFINITION_UPPER_DERIVATION = 422;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Typed Element Definition Type Derivation' of 'Typed Element Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TYPED_ELEMENT_DEFINITION__TYPED_ELEMENT_DEFINITION_TYPE_DERIVATION = 423;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Typed Element Definition Type Name' of 'Typed Element Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TYPED_ELEMENT_DEFINITION__TYPED_ELEMENT_DEFINITION_TYPE_NAME = 424;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Data Type Definition Primitive' of 'Data Type Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DATA_TYPE_DEFINITION__DATA_TYPE_DEFINITION_PRIMITIVE = 425;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Data Type Definition Specialization Referent' of 'Data Type Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DATA_TYPE_DEFINITION__DATA_TYPE_DEFINITION_SPECIALIZATION_REFERENT = 426;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Package Definition Applied Profile Derivation' of 'Package Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PACKAGE_DEFINITION__PACKAGE_DEFINITION_APPLIED_PROFILE_DERIVATION = 427;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Definition Initializer' of 'Property Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_DEFINITION__PROPERTY_DEFINITION_INITIALIZER = 428;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Definition Is Collection Conversion Derivation' of 'Property Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_DEFINITION__PROPERTY_DEFINITION_IS_COLLECTION_CONVERSION_DERIVATION = 429;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Definition Is Bit String Conversion Derivation' of 'Property Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_DEFINITION__PROPERTY_DEFINITION_IS_BIT_STRING_CONVERSION_DERIVATION = 430;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property Definition Is Feature Derivation' of 'Property Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_DEFINITION__PROPERTY_DEFINITION_IS_FEATURE_DERIVATION = 431;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signal Definition Specialization Referent' of 'Signal Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SIGNAL_DEFINITION__SIGNAL_DEFINITION_SPECIALIZATION_REFERENT = 432;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Active Class Definition Classifier Behavior' of 'Active Class Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVE_CLASS_DEFINITION__ACTIVE_CLASS_DEFINITION_CLASSIFIER_BEHAVIOR = 433;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Activity Definition Specialization' of 'Activity Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_DEFINITION__ACTIVITY_DEFINITION_SPECIALIZATION = 434;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Activity Definition Primitive' of 'Activity Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_DEFINITION__ACTIVITY_DEFINITION_PRIMITIVE = 435;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Element Import Reference Referent' of 'Element Import Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT_IMPORT_REFERENCE__ELEMENT_IMPORT_REFERENCE_REFERENT = 436;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signal Reception Definition Is Feature Derivation' of 'Signal Reception Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SIGNAL_RECEPTION_DEFINITION__SIGNAL_RECEPTION_DEFINITION_IS_FEATURE_DERIVATION = 437;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Enumeration Definition Specialization Referent' of 'Enumeration Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ENUMERATION_DEFINITION__ENUMERATION_DEFINITION_SPECIALIZATION_REFERENT = 438;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Package Import Reference Referent' of 'Package Import Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PACKAGE_IMPORT_REFERENCE__PACKAGE_IMPORT_REFERENCE_REFERENT = 439;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Reception Definition Signal Name' of 'Reception Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RECEPTION_DEFINITION__RECEPTION_DEFINITION_SIGNAL_NAME = 440;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Reception Definition Signal Derivation' of 'Reception Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RECEPTION_DEFINITION__RECEPTION_DEFINITION_SIGNAL_DERIVATION = 441;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Reception Definition Is Feature Derivation' of 'Reception Definition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RECEPTION_DEFINITION__RECEPTION_DEFINITION_IS_FEATURE_DERIVATION = 442;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 442;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Delegates evaluation of the given invariant expression against the object in the given context.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context, String validationDelegate, EOperation invariant, String expression, int severity, String source, int code) {
		return EObjectValidator.validate(eClass, eObject, diagnostics, context, validationDelegate, invariant, expression, severity, source, code);
	}

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlfValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return AlfPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case AlfPackage.ASSIGNED_SOURCE:
				return validateAssignedSource((AssignedSource)value, diagnostics, context);
			case AlfPackage.SYNTAX_ELEMENT:
				return validateSyntaxElement((SyntaxElement)value, diagnostics, context);
			case AlfPackage.ELEMENT_REFERENCE:
				return validateElementReference((ElementReference)value, diagnostics, context);
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE:
				return validateInternalElementReference((InternalElementReference)value, diagnostics, context);
			case AlfPackage.EXTERNAL_ELEMENT_REFERENCE:
				return validateExternalElementReference((ExternalElementReference)value, diagnostics, context);
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE:
				return validateExternalEnumerationLiteralReference((ExternalEnumerationLiteralReference)value, diagnostics, context);
			case AlfPackage.BOUND_ELEMENT_REFERENCE:
				return validateBoundElementReference((BoundElementReference)value, diagnostics, context);
			case AlfPackage.DOCUMENTED_ELEMENT:
				return validateDocumentedElement((DocumentedElement)value, diagnostics, context);
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION:
				return validateSequenceExpansionExpression((SequenceExpansionExpression)value, diagnostics, context);
			case AlfPackage.ASSIGNABLE_ELEMENT:
				return validateAssignableElement((AssignableElement)value, diagnostics, context);
			case AlfPackage.ASSIGNABLE_ELEMENT_REFERENCE:
				return validateAssignableElementReference((AssignableElementReference)value, diagnostics, context);
			case AlfPackage.EXPRESSION:
				return validateExpression((Expression)value, diagnostics, context);
			case AlfPackage.EXPRESSION_REFERENCE:
				return validateExpressionReference((ExpressionReference)value, diagnostics, context);
			case AlfPackage.EXTENT_OR_EXPRESSION:
				return validateExtentOrExpression((ExtentOrExpression)value, diagnostics, context);
			case AlfPackage.QUALIFIED_NAME:
				return validateQualifiedName((QualifiedName)value, diagnostics, context);
			case AlfPackage.FEATURE_REFERENCE:
				return validateFeatureReference((FeatureReference)value, diagnostics, context);
			case AlfPackage.NAME_BINDING:
				return validateNameBinding((NameBinding)value, diagnostics, context);
			case AlfPackage.TEMPLATE_BINDING:
				return validateTemplateBinding((TemplateBinding)value, diagnostics, context);
			case AlfPackage.NAMED_TEMPLATE_BINDING:
				return validateNamedTemplateBinding((NamedTemplateBinding)value, diagnostics, context);
			case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION:
				return validateTemplateParameterSubstitution((TemplateParameterSubstitution)value, diagnostics, context);
			case AlfPackage.NUMERIC_UNARY_EXPRESSION:
				return validateNumericUnaryExpression((NumericUnaryExpression)value, diagnostics, context);
			case AlfPackage.UNARY_EXPRESSION:
				return validateUnaryExpression((UnaryExpression)value, diagnostics, context);
			case AlfPackage.FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION:
				return validateForAllOrExistsOrOneExpression((ForAllOrExistsOrOneExpression)value, diagnostics, context);
			case AlfPackage.ISOLATION_EXPRESSION:
				return validateIsolationExpression((IsolationExpression)value, diagnostics, context);
			case AlfPackage.BINARY_EXPRESSION:
				return validateBinaryExpression((BinaryExpression)value, diagnostics, context);
			case AlfPackage.BOOLEAN_UNARY_EXPRESSION:
				return validateBooleanUnaryExpression((BooleanUnaryExpression)value, diagnostics, context);
			case AlfPackage.CAST_EXPRESSION:
				return validateCastExpression((CastExpression)value, diagnostics, context);
			case AlfPackage.POSITIONAL_TUPLE:
				return validatePositionalTuple((PositionalTuple)value, diagnostics, context);
			case AlfPackage.TUPLE:
				return validateTuple((Tuple)value, diagnostics, context);
			case AlfPackage.NAMED_EXPRESSION:
				return validateNamedExpression((NamedExpression)value, diagnostics, context);
			case AlfPackage.INPUT_NAMED_EXPRESSION:
				return validateInputNamedExpression((InputNamedExpression)value, diagnostics, context);
			case AlfPackage.INVOCATION_EXPRESSION:
				return validateInvocationExpression((InvocationExpression)value, diagnostics, context);
			case AlfPackage.OUTPUT_NAMED_EXPRESSION:
				return validateOutputNamedExpression((OutputNamedExpression)value, diagnostics, context);
			case AlfPackage.LEFT_HAND_SIDE:
				return validateLeftHandSide((LeftHandSide)value, diagnostics, context);
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION:
				return validateSequenceAccessExpression((SequenceAccessExpression)value, diagnostics, context);
			case AlfPackage.STRING_LITERAL_EXPRESSION:
				return validateStringLiteralExpression((StringLiteralExpression)value, diagnostics, context);
			case AlfPackage.LITERAL_EXPRESSION:
				return validateLiteralExpression((LiteralExpression)value, diagnostics, context);
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION:
				return validateSequenceOperationExpression((SequenceOperationExpression)value, diagnostics, context);
			case AlfPackage.SELECT_OR_REJECT_EXPRESSION:
				return validateSelectOrRejectExpression((SelectOrRejectExpression)value, diagnostics, context);
			case AlfPackage.CLASS_EXTENT_EXPRESSION:
				return validateClassExtentExpression((ClassExtentExpression)value, diagnostics, context);
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING:
				return validatePositionalTemplateBinding((PositionalTemplateBinding)value, diagnostics, context);
			case AlfPackage.CONDITIONAL_LOGICAL_EXPRESSION:
				return validateConditionalLogicalExpression((ConditionalLogicalExpression)value, diagnostics, context);
			case AlfPackage.LINK_OPERATION_EXPRESSION:
				return validateLinkOperationExpression((LinkOperationExpression)value, diagnostics, context);
			case AlfPackage.EQUALITY_EXPRESSION:
				return validateEqualityExpression((EqualityExpression)value, diagnostics, context);
			case AlfPackage.ASSIGNMENT_EXPRESSION:
				return validateAssignmentExpression((AssignmentExpression)value, diagnostics, context);
			case AlfPackage.LOGICAL_EXPRESSION:
				return validateLogicalExpression((LogicalExpression)value, diagnostics, context);
			case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION:
				return validateSequenceConstructionExpression((SequenceConstructionExpression)value, diagnostics, context);
			case AlfPackage.SEQUENCE_ELEMENTS:
				return validateSequenceElements((SequenceElements)value, diagnostics, context);
			case AlfPackage.COLLECT_OR_ITERATE_EXPRESSION:
				return validateCollectOrIterateExpression((CollectOrIterateExpression)value, diagnostics, context);
			case AlfPackage.IS_UNIQUE_EXPRESSION:
				return validateIsUniqueExpression((IsUniqueExpression)value, diagnostics, context);
			case AlfPackage.ARITHMETIC_EXPRESSION:
				return validateArithmeticExpression((ArithmeticExpression)value, diagnostics, context);
			case AlfPackage.FEATURE_LEFT_HAND_SIDE:
				return validateFeatureLeftHandSide((FeatureLeftHandSide)value, diagnostics, context);
			case AlfPackage.CONDITIONAL_TEST_EXPRESSION:
				return validateConditionalTestExpression((ConditionalTestExpression)value, diagnostics, context);
			case AlfPackage.INSTANCE_CREATION_EXPRESSION:
				return validateInstanceCreationExpression((InstanceCreationExpression)value, diagnostics, context);
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION:
				return validatePropertyAccessExpression((PropertyAccessExpression)value, diagnostics, context);
			case AlfPackage.NAME_EXPRESSION:
				return validateNameExpression((NameExpression)value, diagnostics, context);
			case AlfPackage.BIT_STRING_UNARY_EXPRESSION:
				return validateBitStringUnaryExpression((BitStringUnaryExpression)value, diagnostics, context);
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION:
				return validateFeatureInvocationExpression((FeatureInvocationExpression)value, diagnostics, context);
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION:
				return validateBehaviorInvocationExpression((BehaviorInvocationExpression)value, diagnostics, context);
			case AlfPackage.SHIFT_EXPRESSION:
				return validateShiftExpression((ShiftExpression)value, diagnostics, context);
			case AlfPackage.UNBOUNDED_LITERAL_EXPRESSION:
				return validateUnboundedLiteralExpression((UnboundedLiteralExpression)value, diagnostics, context);
			case AlfPackage.THIS_EXPRESSION:
				return validateThisExpression((ThisExpression)value, diagnostics, context);
			case AlfPackage.CLASSIFICATION_EXPRESSION:
				return validateClassificationExpression((ClassificationExpression)value, diagnostics, context);
			case AlfPackage.SUPER_INVOCATION_EXPRESSION:
				return validateSuperInvocationExpression((SuperInvocationExpression)value, diagnostics, context);
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION:
				return validateIncrementOrDecrementExpression((IncrementOrDecrementExpression)value, diagnostics, context);
			case AlfPackage.BOOLEAN_LITERAL_EXPRESSION:
				return validateBooleanLiteralExpression((BooleanLiteralExpression)value, diagnostics, context);
			case AlfPackage.NAMED_TUPLE:
				return validateNamedTuple((NamedTuple)value, diagnostics, context);
			case AlfPackage.NATURAL_LITERAL_EXPRESSION:
				return validateNaturalLiteralExpression((NaturalLiteralExpression)value, diagnostics, context);
			case AlfPackage.SEQUENCE_RANGE:
				return validateSequenceRange((SequenceRange)value, diagnostics, context);
			case AlfPackage.NAME_LEFT_HAND_SIDE:
				return validateNameLeftHandSide((NameLeftHandSide)value, diagnostics, context);
			case AlfPackage.EFFECTIVE_LEFT_HAND_SIDE:
				return validateEffectiveLeftHandSide((EffectiveLeftHandSide)value, diagnostics, context);
			case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION:
				return validateSequenceReductionExpression((SequenceReductionExpression)value, diagnostics, context);
			case AlfPackage.SEQUENCE_EXPRESSION_LIST:
				return validateSequenceExpressionList((SequenceExpressionList)value, diagnostics, context);
			case AlfPackage.RELATIONAL_EXPRESSION:
				return validateRelationalExpression((RelationalExpression)value, diagnostics, context);
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT:
				return validateLocalNameDeclarationStatement((LocalNameDeclarationStatement)value, diagnostics, context);
			case AlfPackage.ASSIGNABLE_LOCAL_NAME_DECLARATION:
				return validateAssignableLocalNameDeclaration((AssignableLocalNameDeclaration)value, diagnostics, context);
			case AlfPackage.STATEMENT:
				return validateStatement((Statement)value, diagnostics, context);
			case AlfPackage.ANNOTATION:
				return validateAnnotation((Annotation)value, diagnostics, context);
			case AlfPackage.QUALIFIED_NAME_LIST:
				return validateQualifiedNameList((QualifiedNameList)value, diagnostics, context);
			case AlfPackage.NON_FINAL_CLAUSE:
				return validateNonFinalClause((NonFinalClause)value, diagnostics, context);
			case AlfPackage.BLOCK:
				return validateBlock((Block)value, diagnostics, context);
			case AlfPackage.BLOCK_STATEMENT:
				return validateBlockStatement((BlockStatement)value, diagnostics, context);
			case AlfPackage.DO_STATEMENT:
				return validateDoStatement((DoStatement)value, diagnostics, context);
			case AlfPackage.CONCURRENT_CLAUSES:
				return validateConcurrentClauses((ConcurrentClauses)value, diagnostics, context);
			case AlfPackage.BREAK_STATEMENT:
				return validateBreakStatement((BreakStatement)value, diagnostics, context);
			case AlfPackage.EXPRESSION_STATEMENT:
				return validateExpressionStatement((ExpressionStatement)value, diagnostics, context);
			case AlfPackage.CLASSIFY_STATEMENT:
				return validateClassifyStatement((ClassifyStatement)value, diagnostics, context);
			case AlfPackage.FOR_STATEMENT:
				return validateForStatement((ForStatement)value, diagnostics, context);
			case AlfPackage.LOOP_VARIABLE_DEFINITION:
				return validateLoopVariableDefinition((LoopVariableDefinition)value, diagnostics, context);
			case AlfPackage.IF_STATEMENT:
				return validateIfStatement((IfStatement)value, diagnostics, context);
			case AlfPackage.SWITCH_STATEMENT:
				return validateSwitchStatement((SwitchStatement)value, diagnostics, context);
			case AlfPackage.SWITCH_CLAUSE:
				return validateSwitchClause((SwitchClause)value, diagnostics, context);
			case AlfPackage.WHILE_STATEMENT:
				return validateWhileStatement((WhileStatement)value, diagnostics, context);
			case AlfPackage.RETURN_STATEMENT:
				return validateReturnStatement((ReturnStatement)value, diagnostics, context);
			case AlfPackage.IN_LINE_STATEMENT:
				return validateInLineStatement((InLineStatement)value, diagnostics, context);
			case AlfPackage.ACCEPT_STATEMENT:
				return validateAcceptStatement((AcceptStatement)value, diagnostics, context);
			case AlfPackage.ACCEPT_BLOCK:
				return validateAcceptBlock((AcceptBlock)value, diagnostics, context);
			case AlfPackage.EMPTY_STATEMENT:
				return validateEmptyStatement((EmptyStatement)value, diagnostics, context);
			case AlfPackage.MODEL_NAMESPACE:
				return validateModelNamespace((ModelNamespace)value, diagnostics, context);
			case AlfPackage.NAMESPACE_DEFINITION:
				return validateNamespaceDefinition((NamespaceDefinition)value, diagnostics, context);
			case AlfPackage.MEMBER_DEFINITION:
				return validateMemberDefinition((MemberDefinition)value, diagnostics, context);
			case AlfPackage.STEREOTYPE_ANNOTATION:
				return validateStereotypeAnnotation((StereotypeAnnotation)value, diagnostics, context);
			case AlfPackage.TAGGED_VALUE_LIST:
				return validateTaggedValueList((TaggedValueList)value, diagnostics, context);
			case AlfPackage.TAGGED_VALUE:
				return validateTaggedValue((TaggedValue)value, diagnostics, context);
			case AlfPackage.UNIT_DEFINITION:
				return validateUnitDefinition((UnitDefinition)value, diagnostics, context);
			case AlfPackage.IMPORT_REFERENCE:
				return validateImportReference((ImportReference)value, diagnostics, context);
			case AlfPackage.IMPORTED_MEMBER:
				return validateImportedMember((ImportedMember)value, diagnostics, context);
			case AlfPackage.ENUMERATION_LITERAL_NAME:
				return validateEnumerationLiteralName((EnumerationLiteralName)value, diagnostics, context);
			case AlfPackage.OPERATION_DEFINITION:
				return validateOperationDefinition((OperationDefinition)value, diagnostics, context);
			case AlfPackage.ASSOCIATION_DEFINITION:
				return validateAssociationDefinition((AssociationDefinition)value, diagnostics, context);
			case AlfPackage.CLASSIFIER_DEFINITION:
				return validateClassifierDefinition((ClassifierDefinition)value, diagnostics, context);
			case AlfPackage.CLASS_DEFINITION:
				return validateClassDefinition((ClassDefinition)value, diagnostics, context);
			case AlfPackage.TYPED_ELEMENT_DEFINITION:
				return validateTypedElementDefinition((TypedElementDefinition)value, diagnostics, context);
			case AlfPackage.DATA_TYPE_DEFINITION:
				return validateDataTypeDefinition((DataTypeDefinition)value, diagnostics, context);
			case AlfPackage.PACKAGE_DEFINITION:
				return validatePackageDefinition((PackageDefinition)value, diagnostics, context);
			case AlfPackage.PROPERTY_DEFINITION:
				return validatePropertyDefinition((PropertyDefinition)value, diagnostics, context);
			case AlfPackage.SIGNAL_DEFINITION:
				return validateSignalDefinition((SignalDefinition)value, diagnostics, context);
			case AlfPackage.ACTIVE_CLASS_DEFINITION:
				return validateActiveClassDefinition((ActiveClassDefinition)value, diagnostics, context);
			case AlfPackage.ACTIVITY_DEFINITION:
				return validateActivityDefinition((ActivityDefinition)value, diagnostics, context);
			case AlfPackage.ELEMENT_IMPORT_REFERENCE:
				return validateElementImportReference((ElementImportReference)value, diagnostics, context);
			case AlfPackage.SIGNAL_RECEPTION_DEFINITION:
				return validateSignalReceptionDefinition((SignalReceptionDefinition)value, diagnostics, context);
			case AlfPackage.ENUMERATION_DEFINITION:
				return validateEnumerationDefinition((EnumerationDefinition)value, diagnostics, context);
			case AlfPackage.PACKAGE_IMPORT_REFERENCE:
				return validatePackageImportReference((PackageImportReference)value, diagnostics, context);
			case AlfPackage.CLASSIFIER_TEMPLATE_PARAMETER:
				return validateClassifierTemplateParameter((ClassifierTemplateParameter)value, diagnostics, context);
			case AlfPackage.FORMAL_PARAMETER:
				return validateFormalParameter((FormalParameter)value, diagnostics, context);
			case AlfPackage.RECEPTION_DEFINITION:
				return validateReceptionDefinition((ReceptionDefinition)value, diagnostics, context);
			case AlfPackage.MEMBER:
				return validateMember((Member)value, diagnostics, context);
			case AlfPackage.ANNOTATED_STATEMENT:
				return validateAnnotatedStatement((AnnotatedStatement)value, diagnostics, context);
			case AlfPackage.BOUND_CLASSIFIER:
				return validateBoundClassifier((BoundClassifier)value, diagnostics, context);
			case AlfPackage.RETURN_PARAMETER:
				return validateReturnParameter((ReturnParameter)value, diagnostics, context);
			case AlfPackage.NON_RETURN_PARAMETER:
				return validateNonReturnParameter((NonReturnParameter)value, diagnostics, context);
			case AlfPackage.ANY_TYPE:
				return validateAnyType((AnyType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignedSource(AssignedSource assignedSource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assignedSource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSyntaxElement(SyntaxElement syntaxElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(syntaxElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementReference(ElementReference elementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(elementReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalElementReference(InternalElementReference internalElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(internalElementReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalElementReference(ExternalElementReference externalElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(externalElementReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEnumerationLiteralReference(ExternalEnumerationLiteralReference externalEnumerationLiteralReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(externalEnumerationLiteralReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoundElementReference(BoundElementReference boundElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(boundElementReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocumentedElement(DocumentedElement documentedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(documentedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceExpansionExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableSourceDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforePrimary(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforeArgument(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableName(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsAfterArgument(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionTypeDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionLowerDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionUpperDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionArgument(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionTypeDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionLowerDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionUpperDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionTypeDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionLowerDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionUpperDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionArgument(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionTypeDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionLowerDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionUpperDerivation(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionExpressionArgument(sequenceExpansionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionOperation(sequenceExpansionExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sequenceExpansionExpressionVariableSourceDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_sequenceExpansionExpressionVariableSourceDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.sequenceExpansionExpressionVariableSourceDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceExpansionExpressionAssignmentsBeforePrimary constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforePrimary(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.sequenceExpansionExpressionAssignmentsBeforePrimary(diagnostics, context);
	}

	/**
	 * Validates the sequenceExpansionExpressionAssignmentsBeforeArgument constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforeArgument(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.sequenceExpansionExpressionAssignmentsBeforeArgument(diagnostics, context);
	}

	/**
	 * Validates the sequenceExpansionExpressionVariableName constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_sequenceExpansionExpressionVariableName(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.sequenceExpansionExpressionVariableName(diagnostics, context);
	}

	/**
	 * Validates the sequenceExpansionExpressionAssignmentsAfterArgument constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsAfterArgument(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.sequenceExpansionExpressionAssignmentsAfterArgument(diagnostics, context);
	}

	/**
	 * Validates the selectOrRejectExpressionTypeDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_selectOrRejectExpressionTypeDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.selectOrRejectExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the selectOrRejectExpressionLowerDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_selectOrRejectExpressionLowerDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.selectOrRejectExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the selectOrRejectExpressionUpperDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_selectOrRejectExpressionUpperDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.selectOrRejectExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the selectOrRejectExpressionArgument constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_selectOrRejectExpressionArgument(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.selectOrRejectExpressionArgument(diagnostics, context);
	}

	/**
	 * Validates the collectOrIterateExpressionTypeDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_collectOrIterateExpressionTypeDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.collectOrIterateExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the collectOrIterateExpressionLowerDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_collectOrIterateExpressionLowerDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.collectOrIterateExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the collectOrIterateExpressionUpperDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_collectOrIterateExpressionUpperDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.collectOrIterateExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the forAllOrExistsOrOneExpressionTypeDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionTypeDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.forAllOrExistsOrOneExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the forAllOrExistsOrOneExpressionLowerDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionLowerDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.forAllOrExistsOrOneExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the forAllOrExistsOrOneExpressionUpperDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionUpperDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.forAllOrExistsOrOneExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the forAllOrExistsOrOneExpressionArgument constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionArgument(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.forAllOrExistsOrOneExpressionArgument(diagnostics, context);
	}

	/**
	 * Validates the isUniqueExpressionTypeDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_isUniqueExpressionTypeDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.isUniqueExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the isUniqueExpressionLowerDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_isUniqueExpressionLowerDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.isUniqueExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the isUniqueExpressionUpperDerivation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_isUniqueExpressionUpperDerivation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.isUniqueExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the isUniqueExpressionExpressionArgument constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_isUniqueExpressionExpressionArgument(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.isUniqueExpressionExpressionArgument(diagnostics, context);
	}

	/**
	 * Validates the sequenceExpansionExpressionOperation constraint of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpansionExpression_sequenceExpansionExpressionOperation(SequenceExpansionExpression sequenceExpansionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpansionExpression.sequenceExpansionExpressionOperation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignableElement(AssignableElement assignableElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assignableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignableElementReference(AssignableElementReference assignableElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assignableElementReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpression(Expression expression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(expression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(expression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(expression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the expressionAssignmentAfterDerivation constraint of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpression_expressionAssignmentAfterDerivation(Expression expression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return expression.expressionAssignmentAfterDerivation(diagnostics, context);
	}

	/**
	 * Validates the expressionUniqueAssignments constraint of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpression_expressionUniqueAssignments(Expression expression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return expression.expressionUniqueAssignments(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionReference(ExpressionReference expressionReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(expressionReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(expressionReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(expressionReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtentOrExpression(ExtentOrExpression extentOrExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(extentOrExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtentOrExpression_extentOrExpressionExpressionDerivation(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtentOrExpression_extentOrExpressionExtentType(extentOrExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtentOrExpression_extentOrExpressionResolution(extentOrExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the extentOrExpressionExpressionDerivation constraint of '<em>Extent Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtentOrExpression_extentOrExpressionExpressionDerivation(ExtentOrExpression extentOrExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return extentOrExpression.extentOrExpressionExpressionDerivation(diagnostics, context);
	}

	/**
	 * Validates the extentOrExpressionExtentType constraint of '<em>Extent Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtentOrExpression_extentOrExpressionExtentType(ExtentOrExpression extentOrExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return extentOrExpression.extentOrExpressionExtentType(diagnostics, context);
	}

	/**
	 * Validates the extentOrExpressionResolution constraint of '<em>Extent Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtentOrExpression_extentOrExpressionResolution(ExtentOrExpression extentOrExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return extentOrExpression.extentOrExpressionResolution(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(qualifiedName, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameUnqualifiedNameDerivation(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNamePathNameDerivation(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameIsFeatureReferenceDerivation(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameQualificationDerivation(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameDisambiguationDerivation(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameReferentDerivation(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameLocalName(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameNonLocalUnqualifiedName(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameQualifiedResolution(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameTemplateBinding(qualifiedName, diagnostics, context);
		if (result || diagnostics != null) result &= validateQualifiedName_qualifiedNameTemplateNameDerivation(qualifiedName, diagnostics, context);
		return result;
	}

	/**
	 * Validates the qualifiedNameUnqualifiedNameDerivation constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameUnqualifiedNameDerivation(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameUnqualifiedNameDerivation(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNamePathNameDerivation constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNamePathNameDerivation(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNamePathNameDerivation(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameIsFeatureReferenceDerivation constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameIsFeatureReferenceDerivation(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameIsFeatureReferenceDerivation(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameQualificationDerivation constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameQualificationDerivation(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameQualificationDerivation(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameDisambiguationDerivation constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameDisambiguationDerivation(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameDisambiguationDerivation(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameReferentDerivation constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameReferentDerivation(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameLocalName constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameLocalName(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameLocalName(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameNonLocalUnqualifiedName constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameNonLocalUnqualifiedName(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameNonLocalUnqualifiedName(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameQualifiedResolution constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameQualifiedResolution(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameQualifiedResolution(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameTemplateBinding constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameTemplateBinding(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameTemplateBinding(diagnostics, context);
	}

	/**
	 * Validates the qualifiedNameTemplateNameDerivation constraint of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedName_qualifiedNameTemplateNameDerivation(QualifiedName qualifiedName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return qualifiedName.qualifiedNameTemplateNameDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureReference(FeatureReference featureReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureReference_featureReferenceReferentDerivation(featureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureReference_featureReferenceTargetType(featureReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the featureReferenceReferentDerivation constraint of '<em>Feature Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureReference_featureReferenceReferentDerivation(FeatureReference featureReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureReference.featureReferenceReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureReferenceTargetType constraint of '<em>Feature Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureReference_featureReferenceTargetType(FeatureReference featureReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureReference.featureReferenceTargetType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameBinding(NameBinding nameBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nameBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding(TemplateBinding templateBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedTemplateBinding(NamedTemplateBinding namedTemplateBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedTemplateBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitution(TemplateParameterSubstitution templateParameterSubstitution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateParameterSubstitution, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericUnaryExpression(NumericUnaryExpression numericUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(numericUnaryExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryExpression_unaryExpressionAssignmentsBefore(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNumericUnaryExpression_numericUnaryExpressionTypeDerivation(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNumericUnaryExpression_numericUnaryExpressionLowerDerivation(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNumericUnaryExpression_numericUnaryExpressionUpperDerivation(numericUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNumericUnaryExpression_numericUnaryExpressionOperand(numericUnaryExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the numericUnaryExpressionTypeDerivation constraint of '<em>Numeric Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericUnaryExpression_numericUnaryExpressionTypeDerivation(NumericUnaryExpression numericUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return numericUnaryExpression.numericUnaryExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the numericUnaryExpressionLowerDerivation constraint of '<em>Numeric Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericUnaryExpression_numericUnaryExpressionLowerDerivation(NumericUnaryExpression numericUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return numericUnaryExpression.numericUnaryExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the numericUnaryExpressionUpperDerivation constraint of '<em>Numeric Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericUnaryExpression_numericUnaryExpressionUpperDerivation(NumericUnaryExpression numericUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return numericUnaryExpression.numericUnaryExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the numericUnaryExpressionOperand constraint of '<em>Numeric Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericUnaryExpression_numericUnaryExpressionOperand(NumericUnaryExpression numericUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return numericUnaryExpression.numericUnaryExpressionOperand(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnaryExpression(UnaryExpression unaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unaryExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(unaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryExpression_unaryExpressionAssignmentsBefore(unaryExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the unaryExpressionAssignmentsBefore constraint of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnaryExpression_unaryExpressionAssignmentsBefore(UnaryExpression unaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return unaryExpression.unaryExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllOrExistsOrOneExpression(ForAllOrExistsOrOneExpression forAllOrExistsOrOneExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(forAllOrExistsOrOneExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableSourceDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforePrimary(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforeArgument(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableName(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsAfterArgument(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionTypeDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionLowerDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionUpperDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionArgument(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionTypeDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionLowerDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionUpperDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateForAllOrExistsOrOneExpression_forAllOrExistsOrOneExpressionTypeDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateForAllOrExistsOrOneExpression_forAllOrExistsOrOneExpressionLowerDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateForAllOrExistsOrOneExpression_forAllOrExistsOrOneExpressionUpperDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateForAllOrExistsOrOneExpression_forAllOrExistsOrOneExpressionArgument(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionTypeDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionLowerDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionUpperDerivation(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionExpressionArgument(forAllOrExistsOrOneExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionOperation(forAllOrExistsOrOneExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the forAllOrExistsOrOneExpressionTypeDerivation constraint of '<em>For All Or Exists Or One Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllOrExistsOrOneExpression_forAllOrExistsOrOneExpressionTypeDerivation(ForAllOrExistsOrOneExpression forAllOrExistsOrOneExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forAllOrExistsOrOneExpression.forAllOrExistsOrOneExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the forAllOrExistsOrOneExpressionLowerDerivation constraint of '<em>For All Or Exists Or One Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllOrExistsOrOneExpression_forAllOrExistsOrOneExpressionLowerDerivation(ForAllOrExistsOrOneExpression forAllOrExistsOrOneExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forAllOrExistsOrOneExpression.forAllOrExistsOrOneExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the forAllOrExistsOrOneExpressionUpperDerivation constraint of '<em>For All Or Exists Or One Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllOrExistsOrOneExpression_forAllOrExistsOrOneExpressionUpperDerivation(ForAllOrExistsOrOneExpression forAllOrExistsOrOneExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forAllOrExistsOrOneExpression.forAllOrExistsOrOneExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the forAllOrExistsOrOneExpressionArgument constraint of '<em>For All Or Exists Or One Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllOrExistsOrOneExpression_forAllOrExistsOrOneExpressionArgument(ForAllOrExistsOrOneExpression forAllOrExistsOrOneExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forAllOrExistsOrOneExpression.forAllOrExistsOrOneExpressionArgument(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsolationExpression(IsolationExpression isolationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(isolationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryExpression_unaryExpressionAssignmentsBefore(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIsolationExpression_isolationExpressionTypeDerivation(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIsolationExpression_isolationExpressionLowerDerivation(isolationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIsolationExpression_isolationExpressionUpperDerivation(isolationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isolationExpressionTypeDerivation constraint of '<em>Isolation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsolationExpression_isolationExpressionTypeDerivation(IsolationExpression isolationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return isolationExpression.isolationExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the isolationExpressionLowerDerivation constraint of '<em>Isolation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsolationExpression_isolationExpressionLowerDerivation(IsolationExpression isolationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return isolationExpression.isolationExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the isolationExpressionUpperDerivation constraint of '<em>Isolation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsolationExpression_isolationExpressionUpperDerivation(IsolationExpression isolationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return isolationExpression.isolationExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryExpression(BinaryExpression binaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(binaryExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandMultiplicity(binaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandAssignments(binaryExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the binaryExpressionOperandMultiplicity constraint of '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryExpression_binaryExpressionOperandMultiplicity(BinaryExpression binaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return binaryExpression.binaryExpressionOperandMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the binaryExpressionOperandAssignments constraint of '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryExpression_binaryExpressionOperandAssignments(BinaryExpression binaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return binaryExpression.binaryExpressionOperandAssignments(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanUnaryExpression(BooleanUnaryExpression booleanUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(booleanUnaryExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryExpression_unaryExpressionAssignmentsBefore(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBooleanUnaryExpression_booleanUnaryExpressionTypeDerivation(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBooleanUnaryExpression_booleanUnaryExpressionLowerDerivation(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBooleanUnaryExpression_booleanUnaryExpressionUpperDerivation(booleanUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBooleanUnaryExpression_booleanUnaryExpressionOperand(booleanUnaryExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the booleanUnaryExpressionTypeDerivation constraint of '<em>Boolean Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanUnaryExpression_booleanUnaryExpressionTypeDerivation(BooleanUnaryExpression booleanUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return booleanUnaryExpression.booleanUnaryExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the booleanUnaryExpressionLowerDerivation constraint of '<em>Boolean Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanUnaryExpression_booleanUnaryExpressionLowerDerivation(BooleanUnaryExpression booleanUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return booleanUnaryExpression.booleanUnaryExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the booleanUnaryExpressionUpperDerivation constraint of '<em>Boolean Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanUnaryExpression_booleanUnaryExpressionUpperDerivation(BooleanUnaryExpression booleanUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return booleanUnaryExpression.booleanUnaryExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the booleanUnaryExpressionOperand constraint of '<em>Boolean Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanUnaryExpression_booleanUnaryExpressionOperand(BooleanUnaryExpression booleanUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return booleanUnaryExpression.booleanUnaryExpressionOperand(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCastExpression(CastExpression castExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(castExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateCastExpression_castExpressionTypeDerivation(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateCastExpression_castExpressionLowerDerivation(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateCastExpression_castExpressionUpperDerivation(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateCastExpression_castExpressionTypeResolution(castExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateCastExpression_castExpressionAssignmentsBefore(castExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the castExpressionTypeDerivation constraint of '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCastExpression_castExpressionTypeDerivation(CastExpression castExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return castExpression.castExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the castExpressionLowerDerivation constraint of '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCastExpression_castExpressionLowerDerivation(CastExpression castExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return castExpression.castExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the castExpressionUpperDerivation constraint of '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCastExpression_castExpressionUpperDerivation(CastExpression castExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return castExpression.castExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the castExpressionTypeResolution constraint of '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCastExpression_castExpressionTypeResolution(CastExpression castExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return castExpression.castExpressionTypeResolution(diagnostics, context);
	}

	/**
	 * Validates the castExpressionAssignmentsBefore constraint of '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCastExpression_castExpressionAssignmentsBefore(CastExpression castExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return castExpression.castExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositionalTuple(PositionalTuple positionalTuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(positionalTuple, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleInputDerivation(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleOutputDerivation(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleNullInputs(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleOutputs(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleAssignmentsBefore(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleAssignmentsAfter(positionalTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validatePositionalTuple_positionalTupleArguments(positionalTuple, diagnostics, context);
		return result;
	}

	/**
	 * Validates the positionalTupleArguments constraint of '<em>Positional Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositionalTuple_positionalTupleArguments(PositionalTuple positionalTuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return positionalTuple.positionalTupleArguments(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuple(Tuple tuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(tuple, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleInputDerivation(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleOutputDerivation(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleNullInputs(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleOutputs(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleAssignmentsBefore(tuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleAssignmentsAfter(tuple, diagnostics, context);
		return result;
	}

	/**
	 * Validates the tupleInputDerivation constraint of '<em>Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuple_tupleInputDerivation(Tuple tuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return tuple.tupleInputDerivation(diagnostics, context);
	}

	/**
	 * Validates the tupleOutputDerivation constraint of '<em>Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuple_tupleOutputDerivation(Tuple tuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return tuple.tupleOutputDerivation(diagnostics, context);
	}

	/**
	 * Validates the tupleNullInputs constraint of '<em>Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuple_tupleNullInputs(Tuple tuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return tuple.tupleNullInputs(diagnostics, context);
	}

	/**
	 * Validates the tupleOutputs constraint of '<em>Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuple_tupleOutputs(Tuple tuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return tuple.tupleOutputs(diagnostics, context);
	}

	/**
	 * Validates the tupleAssignmentsBefore constraint of '<em>Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuple_tupleAssignmentsBefore(Tuple tuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return tuple.tupleAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the tupleAssignmentsAfter constraint of '<em>Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuple_tupleAssignmentsAfter(Tuple tuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return tuple.tupleAssignmentsAfter(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedExpression(NamedExpression namedExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputNamedExpression(InputNamedExpression inputNamedExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(inputNamedExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInputNamedExpression_namedExpressionIsCollectionConversionDerivation(inputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInputNamedExpression_namedExpressionIsBitStringConversionDerivation(inputNamedExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the namedExpressionIsCollectionConversionDerivation constraint of '<em>Input Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputNamedExpression_namedExpressionIsCollectionConversionDerivation(InputNamedExpression inputNamedExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return inputNamedExpression.namedExpressionIsCollectionConversionDerivation(diagnostics, context);
	}

	/**
	 * Validates the namedExpressionIsBitStringConversionDerivation constraint of '<em>Input Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputNamedExpression_namedExpressionIsBitStringConversionDerivation(InputNamedExpression inputNamedExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return inputNamedExpression.namedExpressionIsBitStringConversionDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(invocationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsBehaviorDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsAssociationEndDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsOperationDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsDestructorDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsImplicitDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsSignalDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionParameterDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTypeDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionUpperDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionLowerDerivation(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionAssignmentsBefore(invocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTemplateParameters(invocationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the invocationExpressionIsBehaviorDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionIsBehaviorDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionIsBehaviorDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionIsAssociationEndDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionIsAssociationEndDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionIsAssociationEndDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionIsOperationDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionIsOperationDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionIsOperationDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionIsDestructorDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionIsDestructorDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionIsDestructorDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionIsImplicitDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionIsImplicitDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionIsImplicitDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionIsSignalDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionIsSignalDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionIsSignalDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionParameterDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionParameterDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionParameterDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionTypeDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionTypeDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionUpperDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionUpperDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionLowerDerivation constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionLowerDerivation(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionAssignmentsBefore constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionAssignmentsBefore(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the invocationExpressionTemplateParameters constraint of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationExpression_invocationExpressionTemplateParameters(InvocationExpression invocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return invocationExpression.invocationExpressionTemplateParameters(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputNamedExpression(OutputNamedExpression outputNamedExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(outputNamedExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInputNamedExpression_namedExpressionIsCollectionConversionDerivation(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInputNamedExpression_namedExpressionIsBitStringConversionDerivation(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateOutputNamedExpression_outputNamedExpressionLeftHandSideDerivation(outputNamedExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateOutputNamedExpression_outputNamedExpressionForm(outputNamedExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the outputNamedExpressionLeftHandSideDerivation constraint of '<em>Output Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputNamedExpression_outputNamedExpressionLeftHandSideDerivation(OutputNamedExpression outputNamedExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return outputNamedExpression.outputNamedExpressionLeftHandSideDerivation(diagnostics, context);
	}

	/**
	 * Validates the outputNamedExpressionForm constraint of '<em>Output Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputNamedExpression_outputNamedExpressionForm(OutputNamedExpression outputNamedExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return outputNamedExpression.outputNamedExpressionForm(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLeftHandSide(LeftHandSide leftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(leftHandSide, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(leftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(leftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(leftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(leftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(leftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(leftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(leftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(leftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateLeftHandSide_leftHandSideIndexExpression(leftHandSide, diagnostics, context);
		return result;
	}

	/**
	 * Validates the leftHandSideIndexExpression constraint of '<em>Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLeftHandSide_leftHandSideIndexExpression(LeftHandSide leftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return leftHandSide.leftHandSideIndexExpression(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceAccessExpression(SequenceAccessExpression sequenceAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceAccessExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceAccessExpression_sequenceAccessExpressionTypeDerivation(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceAccessExpression_sequenceAccessExpressionLowerDerivation(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceAccessExpression_sequenceAccessExpressionUpperDerivation(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceAccessExpression_sequenceAccessExpressionIndexType(sequenceAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceAccessExpression_sequenceAccessExpressionIndexMultiplicity(sequenceAccessExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sequenceAccessExpressionTypeDerivation constraint of '<em>Sequence Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceAccessExpression_sequenceAccessExpressionTypeDerivation(SequenceAccessExpression sequenceAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceAccessExpression.sequenceAccessExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceAccessExpressionLowerDerivation constraint of '<em>Sequence Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceAccessExpression_sequenceAccessExpressionLowerDerivation(SequenceAccessExpression sequenceAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceAccessExpression.sequenceAccessExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceAccessExpressionUpperDerivation constraint of '<em>Sequence Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceAccessExpression_sequenceAccessExpressionUpperDerivation(SequenceAccessExpression sequenceAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceAccessExpression.sequenceAccessExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceAccessExpressionIndexType constraint of '<em>Sequence Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceAccessExpression_sequenceAccessExpressionIndexType(SequenceAccessExpression sequenceAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceAccessExpression.sequenceAccessExpressionIndexType(diagnostics, context);
	}

	/**
	 * Validates the sequenceAccessExpressionIndexMultiplicity constraint of '<em>Sequence Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceAccessExpression_sequenceAccessExpressionIndexMultiplicity(SequenceAccessExpression sequenceAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceAccessExpression.sequenceAccessExpressionIndexMultiplicity(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteralExpression(StringLiteralExpression stringLiteralExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(stringLiteralExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionUpperDerivation(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionLowerDerivation(stringLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateStringLiteralExpression_stringLiteralExpressionTypeDerivation(stringLiteralExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the stringLiteralExpressionTypeDerivation constraint of '<em>String Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteralExpression_stringLiteralExpressionTypeDerivation(StringLiteralExpression stringLiteralExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stringLiteralExpression.stringLiteralExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralExpression(LiteralExpression literalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(literalExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionUpperDerivation(literalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionLowerDerivation(literalExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the literalExpressionUpperDerivation constraint of '<em>Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralExpression_literalExpressionUpperDerivation(LiteralExpression literalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return literalExpression.literalExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the literalExpressionLowerDerivation constraint of '<em>Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralExpression_literalExpressionLowerDerivation(LiteralExpression literalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return literalExpression.literalExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceOperationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsBehaviorDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsAssociationEndDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsOperationDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsDestructorDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsImplicitDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsSignalDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionParameterDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTypeDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionUpperDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionLowerDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionAssignmentsBefore(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTemplateParameters(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionReferentDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionFeatureDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionOperationReferent(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionTargetCompatibility(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionArgumentCompatibility(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionAssignmentsBefore(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionIsCollectionConversionDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionIsBitStringConversionDerivation(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionAssignmentsAfter(sequenceOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceOperationExpression_sequenceOperationExpressionLeftHandSideDerivation(sequenceOperationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sequenceOperationExpressionReferentDerivation constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionReferentDerivation(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionFeatureDerivation constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionFeatureDerivation(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionOperationReferent constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionOperationReferent(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionOperationReferent(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionTargetCompatibility constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionTargetCompatibility(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionTargetCompatibility(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionArgumentCompatibility constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionArgumentCompatibility(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionArgumentCompatibility(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionAssignmentsBefore constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionAssignmentsBefore(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionIsCollectionConversionDerivation constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionIsCollectionConversionDerivation(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionIsCollectionConversionDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionIsBitStringConversionDerivation constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionIsBitStringConversionDerivation(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionIsBitStringConversionDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionAssignmentsAfter constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionAssignmentsAfter(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the sequenceOperationExpressionLeftHandSideDerivation constraint of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceOperationExpression_sequenceOperationExpressionLeftHandSideDerivation(SequenceOperationExpression sequenceOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceOperationExpression.sequenceOperationExpressionLeftHandSideDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelectOrRejectExpression(SelectOrRejectExpression selectOrRejectExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(selectOrRejectExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableSourceDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforePrimary(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforeArgument(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableName(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsAfterArgument(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSelectOrRejectExpression_selectOrRejectExpressionTypeDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSelectOrRejectExpression_selectOrRejectExpressionLowerDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSelectOrRejectExpression_selectOrRejectExpressionUpperDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSelectOrRejectExpression_selectOrRejectExpressionArgument(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionTypeDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionLowerDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionUpperDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionTypeDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionLowerDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionUpperDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionArgument(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionTypeDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionLowerDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionUpperDerivation(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionExpressionArgument(selectOrRejectExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionOperation(selectOrRejectExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the selectOrRejectExpressionTypeDerivation constraint of '<em>Select Or Reject Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelectOrRejectExpression_selectOrRejectExpressionTypeDerivation(SelectOrRejectExpression selectOrRejectExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return selectOrRejectExpression.selectOrRejectExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the selectOrRejectExpressionLowerDerivation constraint of '<em>Select Or Reject Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelectOrRejectExpression_selectOrRejectExpressionLowerDerivation(SelectOrRejectExpression selectOrRejectExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return selectOrRejectExpression.selectOrRejectExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the selectOrRejectExpressionUpperDerivation constraint of '<em>Select Or Reject Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelectOrRejectExpression_selectOrRejectExpressionUpperDerivation(SelectOrRejectExpression selectOrRejectExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return selectOrRejectExpression.selectOrRejectExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the selectOrRejectExpressionArgument constraint of '<em>Select Or Reject Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelectOrRejectExpression_selectOrRejectExpressionArgument(SelectOrRejectExpression selectOrRejectExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return selectOrRejectExpression.selectOrRejectExpressionArgument(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassExtentExpression(ClassExtentExpression classExtentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classExtentExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassExtentExpression_classExtentExpressionTypeDerivation(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassExtentExpression_classExtentExpressionUpperDerivation(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassExtentExpression_classExtentExpressionLowerDerivation(classExtentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassExtentExpression_classExtentExpressionExtentType(classExtentExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the classExtentExpressionTypeDerivation constraint of '<em>Class Extent Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassExtentExpression_classExtentExpressionTypeDerivation(ClassExtentExpression classExtentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classExtentExpression.classExtentExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the classExtentExpressionUpperDerivation constraint of '<em>Class Extent Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassExtentExpression_classExtentExpressionUpperDerivation(ClassExtentExpression classExtentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classExtentExpression.classExtentExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the classExtentExpressionLowerDerivation constraint of '<em>Class Extent Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassExtentExpression_classExtentExpressionLowerDerivation(ClassExtentExpression classExtentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classExtentExpression.classExtentExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the classExtentExpressionExtentType constraint of '<em>Class Extent Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassExtentExpression_classExtentExpressionExtentType(ClassExtentExpression classExtentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classExtentExpression.classExtentExpressionExtentType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositionalTemplateBinding(PositionalTemplateBinding positionalTemplateBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(positionalTemplateBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalLogicalExpression(ConditionalLogicalExpression conditionalLogicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(conditionalLogicalExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandMultiplicity(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandAssignments(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalLogicalExpression_conditionalLogicalExpressionTypeDerivation(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalLogicalExpression_conditionalLogicalExpressionLower(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalLogicalExpression_conditionalLogicalExpressionUpper(conditionalLogicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalLogicalExpression_conditionalLogicalExpressionOperands(conditionalLogicalExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the conditionalLogicalExpressionTypeDerivation constraint of '<em>Conditional Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalLogicalExpression_conditionalLogicalExpressionTypeDerivation(ConditionalLogicalExpression conditionalLogicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalLogicalExpression.conditionalLogicalExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the conditionalLogicalExpressionLower constraint of '<em>Conditional Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalLogicalExpression_conditionalLogicalExpressionLower(ConditionalLogicalExpression conditionalLogicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalLogicalExpression.conditionalLogicalExpressionLower(diagnostics, context);
	}

	/**
	 * Validates the conditionalLogicalExpressionUpper constraint of '<em>Conditional Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalLogicalExpression_conditionalLogicalExpressionUpper(ConditionalLogicalExpression conditionalLogicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalLogicalExpression.conditionalLogicalExpressionUpper(diagnostics, context);
	}

	/**
	 * Validates the conditionalLogicalExpressionOperands constraint of '<em>Conditional Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalLogicalExpression_conditionalLogicalExpressionOperands(ConditionalLogicalExpression conditionalLogicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalLogicalExpression.conditionalLogicalExpressionOperands(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkOperationExpression(LinkOperationExpression linkOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(linkOperationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsBehaviorDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsAssociationEndDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsOperationDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsDestructorDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsImplicitDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsSignalDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionParameterDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTypeDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionUpperDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionLowerDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionAssignmentsBefore(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTemplateParameters(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLinkOperationExpression_linkOperationExpressionIsCreationDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLinkOperationExpression_linkOperationExpressionIsClearDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLinkOperationExpression_linkOperationExpressionReferentDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLinkOperationExpression_linkOperationExpressionFeatureDerivation(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLinkOperationExpression_linkOperationExpressionAssociationReference(linkOperationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLinkOperationExpression_linkOperationExpressionArgumentCompatibility(linkOperationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the linkOperationExpressionIsCreationDerivation constraint of '<em>Link Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkOperationExpression_linkOperationExpressionIsCreationDerivation(LinkOperationExpression linkOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return linkOperationExpression.linkOperationExpressionIsCreationDerivation(diagnostics, context);
	}

	/**
	 * Validates the linkOperationExpressionIsClearDerivation constraint of '<em>Link Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkOperationExpression_linkOperationExpressionIsClearDerivation(LinkOperationExpression linkOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return linkOperationExpression.linkOperationExpressionIsClearDerivation(diagnostics, context);
	}

	/**
	 * Validates the linkOperationExpressionReferentDerivation constraint of '<em>Link Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkOperationExpression_linkOperationExpressionReferentDerivation(LinkOperationExpression linkOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return linkOperationExpression.linkOperationExpressionReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the linkOperationExpressionFeatureDerivation constraint of '<em>Link Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkOperationExpression_linkOperationExpressionFeatureDerivation(LinkOperationExpression linkOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return linkOperationExpression.linkOperationExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the linkOperationExpressionAssociationReference constraint of '<em>Link Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkOperationExpression_linkOperationExpressionAssociationReference(LinkOperationExpression linkOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return linkOperationExpression.linkOperationExpressionAssociationReference(diagnostics, context);
	}

	/**
	 * Validates the linkOperationExpressionArgumentCompatibility constraint of '<em>Link Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkOperationExpression_linkOperationExpressionArgumentCompatibility(LinkOperationExpression linkOperationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return linkOperationExpression.linkOperationExpressionArgumentCompatibility(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEqualityExpression(EqualityExpression equalityExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(equalityExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandMultiplicity(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandAssignments(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateEqualityExpression_equalityExpressionIsNegatedDerivation(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateEqualityExpression_equalityExpressionTypeDerivation(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateEqualityExpression_equalityExpressionLowerDerivation(equalityExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateEqualityExpression_equalityExpressionUpperDerivation(equalityExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the equalityExpressionIsNegatedDerivation constraint of '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEqualityExpression_equalityExpressionIsNegatedDerivation(EqualityExpression equalityExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equalityExpression.equalityExpressionIsNegatedDerivation(diagnostics, context);
	}

	/**
	 * Validates the equalityExpressionTypeDerivation constraint of '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEqualityExpression_equalityExpressionTypeDerivation(EqualityExpression equalityExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equalityExpression.equalityExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the equalityExpressionLowerDerivation constraint of '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEqualityExpression_equalityExpressionLowerDerivation(EqualityExpression equalityExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equalityExpression.equalityExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the equalityExpressionUpperDerivation constraint of '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEqualityExpression_equalityExpressionUpperDerivation(EqualityExpression equalityExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equalityExpression.equalityExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(assignmentExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionIsSimpleDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionIsArithmeticDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionIsDefinitionDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionIsFeatureDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionIsIndexedDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionIsDataValueUpdateDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionAssignmentDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionFeatureDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionExpressionDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionTypeDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionUpperDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionLowerDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionSimpleAssignmentTypeConformance(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionSimpleAssignmentMultiplicityConformance(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionCompoundAssignmentTypeConformance(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionCompoundAssignmentMultiplicityConformance(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionAssignmentsBefore(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionIsCollectionConversionDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionIsBitStringConversionDerivation(assignmentExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignmentExpression_assignmentExpressionDataValueUpdateLegality(assignmentExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the assignmentExpressionIsSimpleDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionIsSimpleDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionIsSimpleDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionIsArithmeticDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionIsArithmeticDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionIsArithmeticDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionIsDefinitionDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionIsDefinitionDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionIsDefinitionDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionIsFeatureDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionIsFeatureDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionIsFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionIsIndexedDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionIsIndexedDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionIsIndexedDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionIsDataValueUpdateDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionIsDataValueUpdateDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionIsDataValueUpdateDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionAssignmentDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionAssignmentDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionAssignmentDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionFeatureDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionFeatureDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionExpressionDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionExpressionDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionExpressionDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionTypeDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionTypeDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionUpperDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionUpperDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionLowerDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionLowerDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionSimpleAssignmentTypeConformance constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionSimpleAssignmentTypeConformance(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionSimpleAssignmentTypeConformance(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionSimpleAssignmentMultiplicityConformance constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionSimpleAssignmentMultiplicityConformance(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionSimpleAssignmentMultiplicityConformance(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionCompoundAssignmentTypeConformance constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionCompoundAssignmentTypeConformance(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionCompoundAssignmentTypeConformance(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionCompoundAssignmentMultiplicityConformance constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionCompoundAssignmentMultiplicityConformance(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionCompoundAssignmentMultiplicityConformance(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionAssignmentsBefore constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionAssignmentsBefore(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionIsCollectionConversionDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionIsCollectionConversionDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionIsCollectionConversionDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionIsBitStringConversionDerivation constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionIsBitStringConversionDerivation(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionIsBitStringConversionDerivation(diagnostics, context);
	}

	/**
	 * Validates the assignmentExpressionDataValueUpdateLegality constraint of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignmentExpression_assignmentExpressionDataValueUpdateLegality(AssignmentExpression assignmentExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return assignmentExpression.assignmentExpressionDataValueUpdateLegality(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(logicalExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandMultiplicity(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandAssignments(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLogicalExpression_logicalExpressionTypeDerivation(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLogicalExpression_logicalExpressionLowerDerivation(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLogicalExpression_logicalExpressionUpperDerivation(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLogicalExpression_logicalExpressionOperands(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLogicalExpression_logicalExpressionIsBitStringConversion1Derivation(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLogicalExpression_logicalExpressionIsBitStringConversion2Derivation(logicalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLogicalExpression_logicalExpressionIsBitWiseDerivation(logicalExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the logicalExpressionTypeDerivation constraint of '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression_logicalExpressionTypeDerivation(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return logicalExpression.logicalExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the logicalExpressionLowerDerivation constraint of '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression_logicalExpressionLowerDerivation(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return logicalExpression.logicalExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the logicalExpressionUpperDerivation constraint of '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression_logicalExpressionUpperDerivation(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return logicalExpression.logicalExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the logicalExpressionOperands constraint of '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression_logicalExpressionOperands(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return logicalExpression.logicalExpressionOperands(diagnostics, context);
	}

	/**
	 * Validates the logicalExpressionIsBitStringConversion1Derivation constraint of '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression_logicalExpressionIsBitStringConversion1Derivation(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return logicalExpression.logicalExpressionIsBitStringConversion1Derivation(diagnostics, context);
	}

	/**
	 * Validates the logicalExpressionIsBitStringConversion2Derivation constraint of '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression_logicalExpressionIsBitStringConversion2Derivation(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return logicalExpression.logicalExpressionIsBitStringConversion2Derivation(diagnostics, context);
	}

	/**
	 * Validates the logicalExpressionIsBitWiseDerivation constraint of '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicalExpression_logicalExpressionIsBitWiseDerivation(LogicalExpression logicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return logicalExpression.logicalExpressionIsBitWiseDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceConstructionExpression(SequenceConstructionExpression sequenceConstructionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceConstructionExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceConstructionExpression_sequenceConstructionExpressionTypeDerivation(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceConstructionExpression_sequenceConstructionExpressionUpperDerivation(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceConstructionExpression_sequenceConstructionExpressionLowerDerivation(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceConstructionExpression_sequenceConstructionExpressionType(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceConstructionExpression_sequenceConstructionExpressionElementType(sequenceConstructionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceConstructionExpression_sequenceConstructionExpressionAssignmentsBefore(sequenceConstructionExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sequenceConstructionExpressionTypeDerivation constraint of '<em>Sequence Construction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceConstructionExpression_sequenceConstructionExpressionTypeDerivation(SequenceConstructionExpression sequenceConstructionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceConstructionExpression.sequenceConstructionExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceConstructionExpressionUpperDerivation constraint of '<em>Sequence Construction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceConstructionExpression_sequenceConstructionExpressionUpperDerivation(SequenceConstructionExpression sequenceConstructionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceConstructionExpression.sequenceConstructionExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceConstructionExpressionLowerDerivation constraint of '<em>Sequence Construction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceConstructionExpression_sequenceConstructionExpressionLowerDerivation(SequenceConstructionExpression sequenceConstructionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceConstructionExpression.sequenceConstructionExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceConstructionExpressionType constraint of '<em>Sequence Construction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceConstructionExpression_sequenceConstructionExpressionType(SequenceConstructionExpression sequenceConstructionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceConstructionExpression.sequenceConstructionExpressionType(diagnostics, context);
	}

	/**
	 * Validates the sequenceConstructionExpressionElementType constraint of '<em>Sequence Construction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceConstructionExpression_sequenceConstructionExpressionElementType(SequenceConstructionExpression sequenceConstructionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceConstructionExpression.sequenceConstructionExpressionElementType(diagnostics, context);
	}

	/**
	 * Validates the sequenceConstructionExpressionAssignmentsBefore constraint of '<em>Sequence Construction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceConstructionExpression_sequenceConstructionExpressionAssignmentsBefore(SequenceConstructionExpression sequenceConstructionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceConstructionExpression.sequenceConstructionExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceElements(SequenceElements sequenceElements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sequenceElements, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectOrIterateExpression(CollectOrIterateExpression collectOrIterateExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectOrIterateExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableSourceDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforePrimary(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforeArgument(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableName(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsAfterArgument(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionTypeDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionLowerDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionUpperDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionArgument(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectOrIterateExpression_collectOrIterateExpressionTypeDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectOrIterateExpression_collectOrIterateExpressionLowerDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectOrIterateExpression_collectOrIterateExpressionUpperDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionTypeDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionLowerDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionUpperDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionArgument(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionTypeDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionLowerDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionUpperDerivation(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_isUniqueExpressionExpressionArgument(collectOrIterateExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionOperation(collectOrIterateExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the collectOrIterateExpressionTypeDerivation constraint of '<em>Collect Or Iterate Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectOrIterateExpression_collectOrIterateExpressionTypeDerivation(CollectOrIterateExpression collectOrIterateExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return collectOrIterateExpression.collectOrIterateExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the collectOrIterateExpressionLowerDerivation constraint of '<em>Collect Or Iterate Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectOrIterateExpression_collectOrIterateExpressionLowerDerivation(CollectOrIterateExpression collectOrIterateExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return collectOrIterateExpression.collectOrIterateExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the collectOrIterateExpressionUpperDerivation constraint of '<em>Collect Or Iterate Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectOrIterateExpression_collectOrIterateExpressionUpperDerivation(CollectOrIterateExpression collectOrIterateExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return collectOrIterateExpression.collectOrIterateExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueExpression(IsUniqueExpression isUniqueExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(isUniqueExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableSourceDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforePrimary(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsBeforeArgument(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionVariableName(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionAssignmentsAfterArgument(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionTypeDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionLowerDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionUpperDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_selectOrRejectExpressionArgument(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionTypeDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionLowerDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_collectOrIterateExpressionUpperDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionTypeDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionLowerDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionUpperDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_forAllOrExistsOrOneExpressionArgument(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIsUniqueExpression_isUniqueExpressionTypeDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIsUniqueExpression_isUniqueExpressionLowerDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIsUniqueExpression_isUniqueExpressionUpperDerivation(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIsUniqueExpression_isUniqueExpressionExpressionArgument(isUniqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpansionExpression_sequenceExpansionExpressionOperation(isUniqueExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isUniqueExpressionTypeDerivation constraint of '<em>Is Unique Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueExpression_isUniqueExpressionTypeDerivation(IsUniqueExpression isUniqueExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return isUniqueExpression.isUniqueExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the isUniqueExpressionLowerDerivation constraint of '<em>Is Unique Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueExpression_isUniqueExpressionLowerDerivation(IsUniqueExpression isUniqueExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return isUniqueExpression.isUniqueExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the isUniqueExpressionUpperDerivation constraint of '<em>Is Unique Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueExpression_isUniqueExpressionUpperDerivation(IsUniqueExpression isUniqueExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return isUniqueExpression.isUniqueExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the isUniqueExpressionExpressionArgument constraint of '<em>Is Unique Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueExpression_isUniqueExpressionExpressionArgument(IsUniqueExpression isUniqueExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return isUniqueExpression.isUniqueExpressionExpressionArgument(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArithmeticExpression(ArithmeticExpression arithmeticExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(arithmeticExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandMultiplicity(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandAssignments(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateArithmeticExpression_arithmeticExpressionIsConcatenationDerivation(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateArithmeticExpression_arithmeticExpressionTypeDerivation(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateArithmeticExpression_arithmeticExpressionLowerDerivation(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateArithmeticExpression_arithmeticExpressionUpperDerivation(arithmeticExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateArithmeticExpression_arithmeticExpressionOperandTypes(arithmeticExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the arithmeticExpressionIsConcatenationDerivation constraint of '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArithmeticExpression_arithmeticExpressionIsConcatenationDerivation(ArithmeticExpression arithmeticExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return arithmeticExpression.arithmeticExpressionIsConcatenationDerivation(diagnostics, context);
	}

	/**
	 * Validates the arithmeticExpressionTypeDerivation constraint of '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArithmeticExpression_arithmeticExpressionTypeDerivation(ArithmeticExpression arithmeticExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return arithmeticExpression.arithmeticExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the arithmeticExpressionLowerDerivation constraint of '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArithmeticExpression_arithmeticExpressionLowerDerivation(ArithmeticExpression arithmeticExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return arithmeticExpression.arithmeticExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the arithmeticExpressionUpperDerivation constraint of '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArithmeticExpression_arithmeticExpressionUpperDerivation(ArithmeticExpression arithmeticExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return arithmeticExpression.arithmeticExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the arithmeticExpressionOperandTypes constraint of '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArithmeticExpression_arithmeticExpressionOperandTypes(ArithmeticExpression arithmeticExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return arithmeticExpression.arithmeticExpressionOperandTypes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureLeftHandSide, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateLeftHandSide_leftHandSideIndexExpression(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideAssignmentBeforeDerivation(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideAssignmentAfterDerivation(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideFeatureExpression(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideAssignmentsBefore(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideReferentDerivation(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideTypeDerivation(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideLowerDerivation(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideUpperDerivation(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideReferentConstraint(featureLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureLeftHandSide_featureLeftHandSideIndexedFeature(featureLeftHandSide, diagnostics, context);
		return result;
	}

	/**
	 * Validates the featureLeftHandSideAssignmentBeforeDerivation constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideAssignmentBeforeDerivation(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideAssignmentBeforeDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideAssignmentAfterDerivation constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideAssignmentAfterDerivation(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideAssignmentAfterDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideFeatureExpression constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideFeatureExpression(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideFeatureExpression(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideAssignmentsBefore constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideAssignmentsBefore(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideReferentDerivation constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideReferentDerivation(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideTypeDerivation constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideTypeDerivation(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideLowerDerivation constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideLowerDerivation(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideUpperDerivation constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideUpperDerivation(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideReferentConstraint constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideReferentConstraint(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideReferentConstraint(diagnostics, context);
	}

	/**
	 * Validates the featureLeftHandSideIndexedFeature constraint of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureLeftHandSide_featureLeftHandSideIndexedFeature(FeatureLeftHandSide featureLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureLeftHandSide.featureLeftHandSideIndexedFeature(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalTestExpression(ConditionalTestExpression conditionalTestExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(conditionalTestExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalTestExpression_conditionalTestExpressionTypeDerivation(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalTestExpression_conditionalTestExpressionLowerDerivation(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalTestExpression_conditionalTestExpressionUpperDerivation(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalTestExpression_conditionalTestExpressionCondition(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalTestExpression_conditionalTestExpressionAssignmentsBefore(conditionalTestExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateConditionalTestExpression_conditionalTestExpressionAssignmentsAfter(conditionalTestExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the conditionalTestExpressionTypeDerivation constraint of '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalTestExpression_conditionalTestExpressionTypeDerivation(ConditionalTestExpression conditionalTestExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalTestExpression.conditionalTestExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the conditionalTestExpressionLowerDerivation constraint of '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalTestExpression_conditionalTestExpressionLowerDerivation(ConditionalTestExpression conditionalTestExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalTestExpression.conditionalTestExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the conditionalTestExpressionUpperDerivation constraint of '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalTestExpression_conditionalTestExpressionUpperDerivation(ConditionalTestExpression conditionalTestExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalTestExpression.conditionalTestExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the conditionalTestExpressionCondition constraint of '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalTestExpression_conditionalTestExpressionCondition(ConditionalTestExpression conditionalTestExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalTestExpression.conditionalTestExpressionCondition(diagnostics, context);
	}

	/**
	 * Validates the conditionalTestExpressionAssignmentsBefore constraint of '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalTestExpression_conditionalTestExpressionAssignmentsBefore(ConditionalTestExpression conditionalTestExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalTestExpression.conditionalTestExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the conditionalTestExpressionAssignmentsAfter constraint of '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalTestExpression_conditionalTestExpressionAssignmentsAfter(ConditionalTestExpression conditionalTestExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return conditionalTestExpression.conditionalTestExpressionAssignmentsAfter(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instanceCreationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsBehaviorDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsAssociationEndDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsOperationDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsDestructorDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsImplicitDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsSignalDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionParameterDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTypeDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionUpperDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionLowerDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionAssignmentsBefore(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTemplateParameters(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceCreationExpression_instanceCreationExpressionIsObjectCreationDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceCreationExpression_instanceCreationExpressionIsConstructorlessDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceCreationExpression_instanceCreationExpressionReferentDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceCreationExpression_instanceCreationExpressionFeatureDerivation(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceCreationExpression_instanceCreationExpressionConstructor(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceCreationExpression_instanceCreationExpressionConstructorlessLegality(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceCreationExpression_instanceCreationExpressionDataTypeCompatibility(instanceCreationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInstanceCreationExpression_instanceCreationExpressionReferent(instanceCreationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the instanceCreationExpressionIsObjectCreationDerivation constraint of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression_instanceCreationExpressionIsObjectCreationDerivation(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceCreationExpression.instanceCreationExpressionIsObjectCreationDerivation(diagnostics, context);
	}

	/**
	 * Validates the instanceCreationExpressionIsConstructorlessDerivation constraint of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression_instanceCreationExpressionIsConstructorlessDerivation(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceCreationExpression.instanceCreationExpressionIsConstructorlessDerivation(diagnostics, context);
	}

	/**
	 * Validates the instanceCreationExpressionReferentDerivation constraint of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression_instanceCreationExpressionReferentDerivation(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceCreationExpression.instanceCreationExpressionReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the instanceCreationExpressionFeatureDerivation constraint of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression_instanceCreationExpressionFeatureDerivation(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceCreationExpression.instanceCreationExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the instanceCreationExpressionConstructor constraint of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression_instanceCreationExpressionConstructor(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceCreationExpression.instanceCreationExpressionConstructor(diagnostics, context);
	}

	/**
	 * Validates the instanceCreationExpressionConstructorlessLegality constraint of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression_instanceCreationExpressionConstructorlessLegality(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceCreationExpression.instanceCreationExpressionConstructorlessLegality(diagnostics, context);
	}

	/**
	 * Validates the instanceCreationExpressionDataTypeCompatibility constraint of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression_instanceCreationExpressionDataTypeCompatibility(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceCreationExpression.instanceCreationExpressionDataTypeCompatibility(diagnostics, context);
	}

	/**
	 * Validates the instanceCreationExpressionReferent constraint of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceCreationExpression_instanceCreationExpressionReferent(InstanceCreationExpression instanceCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return instanceCreationExpression.instanceCreationExpressionReferent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAccessExpression(PropertyAccessExpression propertyAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyAccessExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAccessExpression_propertyAccessExpressionFeatureDerivation(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAccessExpression_propertyAccessExpressionTypeDerivation(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAccessExpression_propertyAccessExpressionUpperDerivation(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAccessExpression_propertyAccessExpressionLowerDerivation(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAccessExpression_propertyAccessExpressionFeatureResolution(propertyAccessExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAccessExpression_propertyAccessExpressionAssignmentsBefore(propertyAccessExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the propertyAccessExpressionFeatureDerivation constraint of '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAccessExpression_propertyAccessExpressionFeatureDerivation(PropertyAccessExpression propertyAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAccessExpression.propertyAccessExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the propertyAccessExpressionTypeDerivation constraint of '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAccessExpression_propertyAccessExpressionTypeDerivation(PropertyAccessExpression propertyAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAccessExpression.propertyAccessExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the propertyAccessExpressionUpperDerivation constraint of '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAccessExpression_propertyAccessExpressionUpperDerivation(PropertyAccessExpression propertyAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAccessExpression.propertyAccessExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the propertyAccessExpressionLowerDerivation constraint of '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAccessExpression_propertyAccessExpressionLowerDerivation(PropertyAccessExpression propertyAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAccessExpression.propertyAccessExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the propertyAccessExpressionFeatureResolution constraint of '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAccessExpression_propertyAccessExpressionFeatureResolution(PropertyAccessExpression propertyAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAccessExpression.propertyAccessExpressionFeatureResolution(diagnostics, context);
	}

	/**
	 * Validates the propertyAccessExpressionAssignmentsBefore constraint of '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAccessExpression_propertyAccessExpressionAssignmentsBefore(PropertyAccessExpression propertyAccessExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAccessExpression.propertyAccessExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameExpression(NameExpression nameExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nameExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameExpression_nameExpressionAssignmentDerivation(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameExpression_nameExpressionEnumerationLiteralDerivation(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameExpression_nameExpressionPropertyAccessDerivation(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameExpression_nameExpressionTypeDerivation(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameExpression_nameExpressionUpperDerivation(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameExpression_nameExpressionLowerDerivation(nameExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameExpression_nameExpressionResolution(nameExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the nameExpressionAssignmentDerivation constraint of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameExpression_nameExpressionAssignmentDerivation(NameExpression nameExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameExpression.nameExpressionAssignmentDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameExpressionEnumerationLiteralDerivation constraint of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameExpression_nameExpressionEnumerationLiteralDerivation(NameExpression nameExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameExpression.nameExpressionEnumerationLiteralDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameExpressionPropertyAccessDerivation constraint of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameExpression_nameExpressionPropertyAccessDerivation(NameExpression nameExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameExpression.nameExpressionPropertyAccessDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameExpressionTypeDerivation constraint of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameExpression_nameExpressionTypeDerivation(NameExpression nameExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameExpression.nameExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameExpressionUpperDerivation constraint of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameExpression_nameExpressionUpperDerivation(NameExpression nameExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameExpression.nameExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameExpressionLowerDerivation constraint of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameExpression_nameExpressionLowerDerivation(NameExpression nameExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameExpression.nameExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameExpressionResolution constraint of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameExpression_nameExpressionResolution(NameExpression nameExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameExpression.nameExpressionResolution(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitStringUnaryExpression(BitStringUnaryExpression bitStringUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(bitStringUnaryExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryExpression_unaryExpressionAssignmentsBefore(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBitStringUnaryExpression_bitStringUnaryExpressionTypeDerivation(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBitStringUnaryExpression_bitStringUnaryExpressionLowerDerivation(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBitStringUnaryExpression_bitStringUnaryExpressionUpperDerivation(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBitStringUnaryExpression_bitStringUnaryExpressionOperand(bitStringUnaryExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBitStringUnaryExpression_bitStringUnaryExpressionIsBitStringConversionDerivation(bitStringUnaryExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the bitStringUnaryExpressionTypeDerivation constraint of '<em>Bit String Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitStringUnaryExpression_bitStringUnaryExpressionTypeDerivation(BitStringUnaryExpression bitStringUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return bitStringUnaryExpression.bitStringUnaryExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the bitStringUnaryExpressionLowerDerivation constraint of '<em>Bit String Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitStringUnaryExpression_bitStringUnaryExpressionLowerDerivation(BitStringUnaryExpression bitStringUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return bitStringUnaryExpression.bitStringUnaryExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the bitStringUnaryExpressionUpperDerivation constraint of '<em>Bit String Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitStringUnaryExpression_bitStringUnaryExpressionUpperDerivation(BitStringUnaryExpression bitStringUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return bitStringUnaryExpression.bitStringUnaryExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the bitStringUnaryExpressionOperand constraint of '<em>Bit String Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitStringUnaryExpression_bitStringUnaryExpressionOperand(BitStringUnaryExpression bitStringUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return bitStringUnaryExpression.bitStringUnaryExpressionOperand(diagnostics, context);
	}

	/**
	 * Validates the bitStringUnaryExpressionIsBitStringConversionDerivation constraint of '<em>Bit String Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBitStringUnaryExpression_bitStringUnaryExpressionIsBitStringConversionDerivation(BitStringUnaryExpression bitStringUnaryExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return bitStringUnaryExpression.bitStringUnaryExpressionIsBitStringConversionDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureInvocationExpression(FeatureInvocationExpression featureInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureInvocationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsBehaviorDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsAssociationEndDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsOperationDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsDestructorDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsImplicitDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsSignalDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionParameterDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTypeDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionUpperDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionLowerDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionAssignmentsBefore(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTemplateParameters(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureInvocationExpression_featureInvocationExpressionReferentDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureInvocationExpression_featureInvocationExpressionFeatureDerivation(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureInvocationExpression_featureInvocationExpressionReferentExists(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureInvocationExpression_featureInvocationExpressionAlternativeConstructor(featureInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeatureInvocationExpression_featureInvocationExpressionImplicitAlternativeConstructor(featureInvocationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the featureInvocationExpressionReferentDerivation constraint of '<em>Feature Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureInvocationExpression_featureInvocationExpressionReferentDerivation(FeatureInvocationExpression featureInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureInvocationExpression.featureInvocationExpressionReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureInvocationExpressionFeatureDerivation constraint of '<em>Feature Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureInvocationExpression_featureInvocationExpressionFeatureDerivation(FeatureInvocationExpression featureInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureInvocationExpression.featureInvocationExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the featureInvocationExpressionReferentExists constraint of '<em>Feature Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureInvocationExpression_featureInvocationExpressionReferentExists(FeatureInvocationExpression featureInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureInvocationExpression.featureInvocationExpressionReferentExists(diagnostics, context);
	}

	/**
	 * Validates the featureInvocationExpressionAlternativeConstructor constraint of '<em>Feature Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureInvocationExpression_featureInvocationExpressionAlternativeConstructor(FeatureInvocationExpression featureInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureInvocationExpression.featureInvocationExpressionAlternativeConstructor(diagnostics, context);
	}

	/**
	 * Validates the featureInvocationExpressionImplicitAlternativeConstructor constraint of '<em>Feature Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureInvocationExpression_featureInvocationExpressionImplicitAlternativeConstructor(FeatureInvocationExpression featureInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return featureInvocationExpression.featureInvocationExpressionImplicitAlternativeConstructor(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorInvocationExpression(BehaviorInvocationExpression behaviorInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(behaviorInvocationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsBehaviorDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsAssociationEndDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsOperationDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsDestructorDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsImplicitDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsSignalDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionParameterDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTypeDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionUpperDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionLowerDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionAssignmentsBefore(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTemplateParameters(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBehaviorInvocationExpression_behaviorInvocationExpressionReferentDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBehaviorInvocationExpression_behaviorInvocationExpressionFeatureDerivation(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBehaviorInvocationExpression_behaviorInvocationExpressionReferentConstraint(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBehaviorInvocationExpression_behaviorInvocationExpressionArgumentCompatibility(behaviorInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBehaviorInvocationExpression_behaviorInvocationExpressionAlternativeConstructor(behaviorInvocationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the behaviorInvocationExpressionReferentDerivation constraint of '<em>Behavior Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorInvocationExpression_behaviorInvocationExpressionReferentDerivation(BehaviorInvocationExpression behaviorInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return behaviorInvocationExpression.behaviorInvocationExpressionReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the behaviorInvocationExpressionFeatureDerivation constraint of '<em>Behavior Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorInvocationExpression_behaviorInvocationExpressionFeatureDerivation(BehaviorInvocationExpression behaviorInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return behaviorInvocationExpression.behaviorInvocationExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the behaviorInvocationExpressionReferentConstraint constraint of '<em>Behavior Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorInvocationExpression_behaviorInvocationExpressionReferentConstraint(BehaviorInvocationExpression behaviorInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return behaviorInvocationExpression.behaviorInvocationExpressionReferentConstraint(diagnostics, context);
	}

	/**
	 * Validates the behaviorInvocationExpressionArgumentCompatibility constraint of '<em>Behavior Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorInvocationExpression_behaviorInvocationExpressionArgumentCompatibility(BehaviorInvocationExpression behaviorInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return behaviorInvocationExpression.behaviorInvocationExpressionArgumentCompatibility(diagnostics, context);
	}

	/**
	 * Validates the behaviorInvocationExpressionAlternativeConstructor constraint of '<em>Behavior Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorInvocationExpression_behaviorInvocationExpressionAlternativeConstructor(BehaviorInvocationExpression behaviorInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return behaviorInvocationExpression.behaviorInvocationExpressionAlternativeConstructor(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShiftExpression(ShiftExpression shiftExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shiftExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandMultiplicity(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandAssignments(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateShiftExpression_shiftExpressionTypeDerivation(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateShiftExpression_shiftExpressionLowerDerivation(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateShiftExpression_shiftExpressionUpperDerivation(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateShiftExpression_shiftExpressionOperands(shiftExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateShiftExpression_shiftExpressionIsBitStringConversionDerivation(shiftExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the shiftExpressionTypeDerivation constraint of '<em>Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShiftExpression_shiftExpressionTypeDerivation(ShiftExpression shiftExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shiftExpression.shiftExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the shiftExpressionLowerDerivation constraint of '<em>Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShiftExpression_shiftExpressionLowerDerivation(ShiftExpression shiftExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shiftExpression.shiftExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the shiftExpressionUpperDerivation constraint of '<em>Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShiftExpression_shiftExpressionUpperDerivation(ShiftExpression shiftExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shiftExpression.shiftExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the shiftExpressionOperands constraint of '<em>Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShiftExpression_shiftExpressionOperands(ShiftExpression shiftExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shiftExpression.shiftExpressionOperands(diagnostics, context);
	}

	/**
	 * Validates the shiftExpressionIsBitStringConversionDerivation constraint of '<em>Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShiftExpression_shiftExpressionIsBitStringConversionDerivation(ShiftExpression shiftExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shiftExpression.shiftExpressionIsBitStringConversionDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnboundedLiteralExpression(UnboundedLiteralExpression unboundedLiteralExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unboundedLiteralExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionUpperDerivation(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionLowerDerivation(unboundedLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnboundedLiteralExpression_unboundedLiteralExpressionTypeDerivation(unboundedLiteralExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the unboundedLiteralExpressionTypeDerivation constraint of '<em>Unbounded Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnboundedLiteralExpression_unboundedLiteralExpressionTypeDerivation(UnboundedLiteralExpression unboundedLiteralExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return unboundedLiteralExpression.unboundedLiteralExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThisExpression(ThisExpression thisExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(thisExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateThisExpression_thisExpressionTypeDerivation(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateThisExpression_thisExpressionUpperDerivation(thisExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateThisExpression_thisExpressionLowerDerivation(thisExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the thisExpressionTypeDerivation constraint of '<em>This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThisExpression_thisExpressionTypeDerivation(ThisExpression thisExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return thisExpression.thisExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the thisExpressionUpperDerivation constraint of '<em>This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThisExpression_thisExpressionUpperDerivation(ThisExpression thisExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return thisExpression.thisExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the thisExpressionLowerDerivation constraint of '<em>This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThisExpression_thisExpressionLowerDerivation(ThisExpression thisExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return thisExpression.thisExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassificationExpression(ClassificationExpression classificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classificationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnaryExpression_unaryExpressionAssignmentsBefore(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassificationExpression_classificationExpressionIsDirectDerivation(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassificationExpression_classificationExpressionReferentDerivation(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassificationExpression_classificationExpressionTypeDerivation(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassificationExpression_classificationExpressionLowerDerivation(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassificationExpression_classificationExpressionUpperDerivation(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassificationExpression_classificationExpressionTypeName(classificationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassificationExpression_classificationExpressionOperand(classificationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the classificationExpressionIsDirectDerivation constraint of '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassificationExpression_classificationExpressionIsDirectDerivation(ClassificationExpression classificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classificationExpression.classificationExpressionIsDirectDerivation(diagnostics, context);
	}

	/**
	 * Validates the classificationExpressionReferentDerivation constraint of '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassificationExpression_classificationExpressionReferentDerivation(ClassificationExpression classificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classificationExpression.classificationExpressionReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the classificationExpressionTypeDerivation constraint of '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassificationExpression_classificationExpressionTypeDerivation(ClassificationExpression classificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classificationExpression.classificationExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the classificationExpressionLowerDerivation constraint of '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassificationExpression_classificationExpressionLowerDerivation(ClassificationExpression classificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classificationExpression.classificationExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the classificationExpressionUpperDerivation constraint of '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassificationExpression_classificationExpressionUpperDerivation(ClassificationExpression classificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classificationExpression.classificationExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the classificationExpressionTypeName constraint of '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassificationExpression_classificationExpressionTypeName(ClassificationExpression classificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classificationExpression.classificationExpressionTypeName(diagnostics, context);
	}

	/**
	 * Validates the classificationExpressionOperand constraint of '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassificationExpression_classificationExpressionOperand(ClassificationExpression classificationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classificationExpression.classificationExpressionOperand(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuperInvocationExpression(SuperInvocationExpression superInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(superInvocationExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsBehaviorDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsAssociationEndDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsOperationDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsDestructorDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsImplicitDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionIsSignalDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionParameterDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTypeDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionUpperDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionLowerDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionAssignmentsBefore(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateInvocationExpression_invocationExpressionTemplateParameters(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSuperInvocationExpression_superInvocationExpressionReferentDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSuperInvocationExpression_superInvocationExpressionFeatureDerivation(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSuperInvocationExpression_superInvocationExpressionQualification(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSuperInvocationExpression_superInvocationExpressionImplicitTarget(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSuperInvocationExpression_superInvocationExpressionConstructorCall(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSuperInvocationExpression_superInvocationExpressionDestructorCall(superInvocationExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSuperInvocationExpression_superInvocationExpressionOperation(superInvocationExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the superInvocationExpressionReferentDerivation constraint of '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuperInvocationExpression_superInvocationExpressionReferentDerivation(SuperInvocationExpression superInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return superInvocationExpression.superInvocationExpressionReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the superInvocationExpressionFeatureDerivation constraint of '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuperInvocationExpression_superInvocationExpressionFeatureDerivation(SuperInvocationExpression superInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return superInvocationExpression.superInvocationExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the superInvocationExpressionQualification constraint of '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuperInvocationExpression_superInvocationExpressionQualification(SuperInvocationExpression superInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return superInvocationExpression.superInvocationExpressionQualification(diagnostics, context);
	}

	/**
	 * Validates the superInvocationExpressionImplicitTarget constraint of '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuperInvocationExpression_superInvocationExpressionImplicitTarget(SuperInvocationExpression superInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return superInvocationExpression.superInvocationExpressionImplicitTarget(diagnostics, context);
	}

	/**
	 * Validates the superInvocationExpressionConstructorCall constraint of '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuperInvocationExpression_superInvocationExpressionConstructorCall(SuperInvocationExpression superInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return superInvocationExpression.superInvocationExpressionConstructorCall(diagnostics, context);
	}

	/**
	 * Validates the superInvocationExpressionDestructorCall constraint of '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuperInvocationExpression_superInvocationExpressionDestructorCall(SuperInvocationExpression superInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return superInvocationExpression.superInvocationExpressionDestructorCall(diagnostics, context);
	}

	/**
	 * Validates the superInvocationExpressionOperation constraint of '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuperInvocationExpression_superInvocationExpressionOperation(SuperInvocationExpression superInvocationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return superInvocationExpression.superInvocationExpressionOperation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(incrementOrDecrementExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionAssignmentDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionIsFeatureDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionIsIndexedDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionIsDataValueUpdateDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionFeatureDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionExpressionDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionTypeDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionLowerDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionUpperDerivation(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionOperand(incrementOrDecrementExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateIncrementOrDecrementExpression_incrementOrDecrementExpressionAssignmentsBefore(incrementOrDecrementExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the incrementOrDecrementExpressionAssignmentDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionAssignmentDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionAssignmentDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionIsFeatureDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionIsFeatureDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionIsFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionIsIndexedDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionIsIndexedDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionIsIndexedDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionIsDataValueUpdateDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionIsDataValueUpdateDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionIsDataValueUpdateDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionFeatureDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionFeatureDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionExpressionDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionExpressionDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionExpressionDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionTypeDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionTypeDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionLowerDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionLowerDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionUpperDerivation constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionUpperDerivation(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionOperand constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionOperand(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionOperand(diagnostics, context);
	}

	/**
	 * Validates the incrementOrDecrementExpressionAssignmentsBefore constraint of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncrementOrDecrementExpression_incrementOrDecrementExpressionAssignmentsBefore(IncrementOrDecrementExpression incrementOrDecrementExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return incrementOrDecrementExpression.incrementOrDecrementExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteralExpression(BooleanLiteralExpression booleanLiteralExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(booleanLiteralExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionUpperDerivation(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionLowerDerivation(booleanLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBooleanLiteralExpression_booleanLiteralExpressionTypeDerivation(booleanLiteralExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the booleanLiteralExpressionTypeDerivation constraint of '<em>Boolean Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteralExpression_booleanLiteralExpressionTypeDerivation(BooleanLiteralExpression booleanLiteralExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return booleanLiteralExpression.booleanLiteralExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedTuple(NamedTuple namedTuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedTuple, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleInputDerivation(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleOutputDerivation(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleNullInputs(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleOutputs(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleAssignmentsBefore(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateTuple_tupleAssignmentsAfter(namedTuple, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedTuple_namedTupleArgumentNames(namedTuple, diagnostics, context);
		return result;
	}

	/**
	 * Validates the namedTupleArgumentNames constraint of '<em>Named Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedTuple_namedTupleArgumentNames(NamedTuple namedTuple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return namedTuple.namedTupleArgumentNames(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNaturalLiteralExpression(NaturalLiteralExpression naturalLiteralExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(naturalLiteralExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionUpperDerivation(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateLiteralExpression_literalExpressionLowerDerivation(naturalLiteralExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateNaturalLiteralExpression_naturalLiteralExpressionTypeDerivation(naturalLiteralExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the naturalLiteralExpressionTypeDerivation constraint of '<em>Natural Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNaturalLiteralExpression_naturalLiteralExpressionTypeDerivation(NaturalLiteralExpression naturalLiteralExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return naturalLiteralExpression.naturalLiteralExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceRange(SequenceRange sequenceRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceRange, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceRange_sequenceRangeLowerDerivation(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceRange_sequenceRangeUpperDerivation(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceRange_sequenceRangeExpressionMultiplicity(sequenceRange, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceRange_sequenceRangeAssignments(sequenceRange, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sequenceRangeLowerDerivation constraint of '<em>Sequence Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceRange_sequenceRangeLowerDerivation(SequenceRange sequenceRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceRange.sequenceRangeLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceRangeUpperDerivation constraint of '<em>Sequence Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceRange_sequenceRangeUpperDerivation(SequenceRange sequenceRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceRange.sequenceRangeUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceRangeExpressionMultiplicity constraint of '<em>Sequence Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceRange_sequenceRangeExpressionMultiplicity(SequenceRange sequenceRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceRange.sequenceRangeExpressionMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the sequenceRangeAssignments constraint of '<em>Sequence Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceRange_sequenceRangeAssignments(SequenceRange sequenceRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceRange.sequenceRangeAssignments(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nameLeftHandSide, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateLeftHandSide_leftHandSideIndexExpression(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideAssignmentAfterDerivation(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideTargetAssignment(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideAssignmentsBefore(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideReferentDerivation(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideLowerDerivation(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideUpperDerivation(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideTypeDerivation(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideTargetResolution(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideIndexedFeature(nameLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideNontemplateTarget(nameLeftHandSide, diagnostics, context);
		return result;
	}

	/**
	 * Validates the nameLeftHandSideAssignmentAfterDerivation constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideAssignmentAfterDerivation(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideAssignmentAfterDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideTargetAssignment constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideTargetAssignment(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideTargetAssignment(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideAssignmentsBefore constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideAssignmentsBefore(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideReferentDerivation constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideReferentDerivation(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideLowerDerivation constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideLowerDerivation(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideUpperDerivation constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideUpperDerivation(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideTypeDerivation constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideTypeDerivation(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideTargetResolution constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideTargetResolution(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideTargetResolution(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideIndexedFeature constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideIndexedFeature(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideIndexedFeature(diagnostics, context);
	}

	/**
	 * Validates the nameLeftHandSideNontemplateTarget constraint of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameLeftHandSide_nameLeftHandSideNontemplateTarget(NameLeftHandSide nameLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nameLeftHandSide.nameLeftHandSideNontemplateTarget(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEffectiveLeftHandSide(EffectiveLeftHandSide effectiveLeftHandSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(effectiveLeftHandSide, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateLeftHandSide_leftHandSideIndexExpression(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideAssignmentAfterDerivation(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideTargetAssignment(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideAssignmentsBefore(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideReferentDerivation(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideLowerDerivation(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideUpperDerivation(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideTypeDerivation(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideTargetResolution(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideIndexedFeature(effectiveLeftHandSide, diagnostics, context);
		if (result || diagnostics != null) result &= validateNameLeftHandSide_nameLeftHandSideNontemplateTarget(effectiveLeftHandSide, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceReductionExpression(SequenceReductionExpression sequenceReductionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceReductionExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceReductionExpression_sequenceReductionExpressionReferentDerivation(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceReductionExpression_sequenceReductionExpressionTypeDerivation(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceReductionExpression_sequenceReductionExpressionUpperDerivation(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceReductionExpression_sequenceReductionExpressionLowerDerivation(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceReductionExpression_sequenceReductionExpressionBehavior(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceReductionExpression_sequenceReductionExpressionBehaviorParameters(sequenceReductionExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceReductionExpression_sequenceReductionExpressionAssignmentsBefore(sequenceReductionExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sequenceReductionExpressionReferentDerivation constraint of '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceReductionExpression_sequenceReductionExpressionReferentDerivation(SequenceReductionExpression sequenceReductionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceReductionExpression.sequenceReductionExpressionReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceReductionExpressionTypeDerivation constraint of '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceReductionExpression_sequenceReductionExpressionTypeDerivation(SequenceReductionExpression sequenceReductionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceReductionExpression.sequenceReductionExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceReductionExpressionUpperDerivation constraint of '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceReductionExpression_sequenceReductionExpressionUpperDerivation(SequenceReductionExpression sequenceReductionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceReductionExpression.sequenceReductionExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceReductionExpressionLowerDerivation constraint of '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceReductionExpression_sequenceReductionExpressionLowerDerivation(SequenceReductionExpression sequenceReductionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceReductionExpression.sequenceReductionExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceReductionExpressionBehavior constraint of '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceReductionExpression_sequenceReductionExpressionBehavior(SequenceReductionExpression sequenceReductionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceReductionExpression.sequenceReductionExpressionBehavior(diagnostics, context);
	}

	/**
	 * Validates the sequenceReductionExpressionBehaviorParameters constraint of '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceReductionExpression_sequenceReductionExpressionBehaviorParameters(SequenceReductionExpression sequenceReductionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceReductionExpression.sequenceReductionExpressionBehaviorParameters(diagnostics, context);
	}

	/**
	 * Validates the sequenceReductionExpressionAssignmentsBefore constraint of '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceReductionExpression_sequenceReductionExpressionAssignmentsBefore(SequenceReductionExpression sequenceReductionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceReductionExpression.sequenceReductionExpressionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpressionList(SequenceExpressionList sequenceExpressionList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceExpressionList, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpressionList_sequenceExpressionListLowerDerivation(sequenceExpressionList, diagnostics, context);
		if (result || diagnostics != null) result &= validateSequenceExpressionList_sequenceExpressionListUpperDerivation(sequenceExpressionList, diagnostics, context);
		return result;
	}

	/**
	 * Validates the sequenceExpressionListLowerDerivation constraint of '<em>Sequence Expression List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpressionList_sequenceExpressionListLowerDerivation(SequenceExpressionList sequenceExpressionList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpressionList.sequenceExpressionListLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the sequenceExpressionListUpperDerivation constraint of '<em>Sequence Expression List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceExpressionList_sequenceExpressionListUpperDerivation(SequenceExpressionList sequenceExpressionList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return sequenceExpressionList.sequenceExpressionListUpperDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalExpression(RelationalExpression relationalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationalExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionAssignmentAfterDerivation(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpression_expressionUniqueAssignments(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandMultiplicity(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryExpression_binaryExpressionOperandAssignments(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalExpression_relationalExpressionIsUnlimitedNaturalDerivation(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalExpression_relationalExpressionTypeDerivation(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalExpression_relationalExpressionLowerDerivation(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalExpression_relationalExpressionUpperDerivation(relationalExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalExpression_relationalExpressionOperandTypes(relationalExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the relationalExpressionIsUnlimitedNaturalDerivation constraint of '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalExpression_relationalExpressionIsUnlimitedNaturalDerivation(RelationalExpression relationalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationalExpression.relationalExpressionIsUnlimitedNaturalDerivation(diagnostics, context);
	}

	/**
	 * Validates the relationalExpressionTypeDerivation constraint of '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalExpression_relationalExpressionTypeDerivation(RelationalExpression relationalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationalExpression.relationalExpressionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the relationalExpressionLowerDerivation constraint of '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalExpression_relationalExpressionLowerDerivation(RelationalExpression relationalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationalExpression.relationalExpressionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the relationalExpressionUpperDerivation constraint of '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalExpression_relationalExpressionUpperDerivation(RelationalExpression relationalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationalExpression.relationalExpressionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the relationalExpressionOperandTypes constraint of '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalExpression_relationalExpressionOperandTypes(RelationalExpression relationalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationalExpression.relationalExpressionOperandTypes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalNameDeclarationStatement(LocalNameDeclarationStatement localNameDeclarationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(localNameDeclarationStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalNameDeclarationStatement_localNameDeclarationStatementAssignmentsBefore(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalNameDeclarationStatement_localNameDeclarationStatementType(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalNameDeclarationStatement_localNameDeclarationStatementLocalName(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalNameDeclarationStatement_localNameDeclarationStatementAssignmentsAfter(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalNameDeclarationStatement_localNameDeclarationStatementExpressionMultiplicity(localNameDeclarationStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateLocalNameDeclarationStatement_localNameDeclarationStatementTypeDerivation(localNameDeclarationStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the localNameDeclarationStatementAssignmentsBefore constraint of '<em>Local Name Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalNameDeclarationStatement_localNameDeclarationStatementAssignmentsBefore(LocalNameDeclarationStatement localNameDeclarationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return localNameDeclarationStatement.localNameDeclarationStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the localNameDeclarationStatementType constraint of '<em>Local Name Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalNameDeclarationStatement_localNameDeclarationStatementType(LocalNameDeclarationStatement localNameDeclarationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return localNameDeclarationStatement.localNameDeclarationStatementType(diagnostics, context);
	}

	/**
	 * Validates the localNameDeclarationStatementLocalName constraint of '<em>Local Name Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalNameDeclarationStatement_localNameDeclarationStatementLocalName(LocalNameDeclarationStatement localNameDeclarationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return localNameDeclarationStatement.localNameDeclarationStatementLocalName(diagnostics, context);
	}

	/**
	 * Validates the localNameDeclarationStatementAssignmentsAfter constraint of '<em>Local Name Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalNameDeclarationStatement_localNameDeclarationStatementAssignmentsAfter(LocalNameDeclarationStatement localNameDeclarationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return localNameDeclarationStatement.localNameDeclarationStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the localNameDeclarationStatementExpressionMultiplicity constraint of '<em>Local Name Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalNameDeclarationStatement_localNameDeclarationStatementExpressionMultiplicity(LocalNameDeclarationStatement localNameDeclarationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return localNameDeclarationStatement.localNameDeclarationStatementExpressionMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the localNameDeclarationStatementTypeDerivation constraint of '<em>Local Name Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalNameDeclarationStatement_localNameDeclarationStatementTypeDerivation(LocalNameDeclarationStatement localNameDeclarationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return localNameDeclarationStatement.localNameDeclarationStatementTypeDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignableLocalNameDeclaration(AssignableLocalNameDeclaration assignableLocalNameDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assignableLocalNameDeclaration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatement(Statement statement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(statement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(statement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the statementAnnotationsAllowed constraint of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatement_statementAnnotationsAllowed(Statement statement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return statement.statementAnnotationsAllowed(diagnostics, context);
	}

	/**
	 * Validates the statementUniqueAssignments constraint of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatement_statementUniqueAssignments(Statement statement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return statement.statementUniqueAssignments(diagnostics, context);
	}

	/**
	 * Validates the statementIsIsolatedDerivation constraint of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatement_statementIsIsolatedDerivation(Statement statement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return statement.statementIsIsolatedDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotation(Annotation annotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(annotation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedNameList(QualifiedNameList qualifiedNameList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(qualifiedNameList, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonFinalClause(NonFinalClause nonFinalClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nonFinalClause, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validateNonFinalClause_nonFinalClauseAssignmentsBeforeBody(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validateNonFinalClause_nonFinalClauseConditionLocalNames(nonFinalClause, diagnostics, context);
		if (result || diagnostics != null) result &= validateNonFinalClause_nonFinalClauseConditionType(nonFinalClause, diagnostics, context);
		return result;
	}

	/**
	 * Validates the nonFinalClauseAssignmentsBeforeBody constraint of '<em>Non Final Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonFinalClause_nonFinalClauseAssignmentsBeforeBody(NonFinalClause nonFinalClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nonFinalClause.nonFinalClauseAssignmentsBeforeBody(diagnostics, context);
	}

	/**
	 * Validates the nonFinalClauseConditionLocalNames constraint of '<em>Non Final Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonFinalClause_nonFinalClauseConditionLocalNames(NonFinalClause nonFinalClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nonFinalClause.nonFinalClauseConditionLocalNames(diagnostics, context);
	}

	/**
	 * Validates the nonFinalClauseConditionType constraint of '<em>Non Final Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonFinalClause_nonFinalClauseConditionType(NonFinalClause nonFinalClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return nonFinalClause.nonFinalClauseConditionType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlock(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(block, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(block, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlock_blockAssignmentsBeforeStatements(block, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlock_blockAssignmentsBefore(block, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlock_blockAssignmentAfterDerivation(block, diagnostics, context);
		return result;
	}

	/**
	 * Validates the blockAssignmentsBeforeStatements constraint of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlock_blockAssignmentsBeforeStatements(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return block.blockAssignmentsBeforeStatements(diagnostics, context);
	}

	/**
	 * Validates the blockAssignmentsBefore constraint of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlock_blockAssignmentsBefore(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return block.blockAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the blockAssignmentAfterDerivation constraint of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlock_blockAssignmentAfterDerivation(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return block.blockAssignmentAfterDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockStatement(BlockStatement blockStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(blockStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlockStatement_blockStatementParallelAssignments(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlockStatement_blockStatementAssignmentsBefore(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlockStatement_blockStatementAssignmentsAfter(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlockStatement_blockStatementEnclosedStatements(blockStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlockStatement_blockStatementIsParallelDerivation(blockStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the blockStatementParallelAssignments constraint of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockStatement_blockStatementParallelAssignments(BlockStatement blockStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return blockStatement.blockStatementParallelAssignments(diagnostics, context);
	}

	/**
	 * Validates the blockStatementAssignmentsBefore constraint of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockStatement_blockStatementAssignmentsBefore(BlockStatement blockStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return blockStatement.blockStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the blockStatementAssignmentsAfter constraint of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockStatement_blockStatementAssignmentsAfter(BlockStatement blockStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return blockStatement.blockStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the blockStatementEnclosedStatements constraint of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockStatement_blockStatementEnclosedStatements(BlockStatement blockStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return blockStatement.blockStatementEnclosedStatements(diagnostics, context);
	}

	/**
	 * Validates the blockStatementIsParallelDerivation constraint of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockStatement_blockStatementIsParallelDerivation(BlockStatement blockStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return blockStatement.blockStatementIsParallelDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoStatement(DoStatement doStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(doStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateDoStatement_doStatementAssignmentsBefore(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateDoStatement_doStatementAssignmentsAfter(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateDoStatement_doStatementCondition(doStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateDoStatement_doStatementEnclosedStatements(doStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the doStatementAssignmentsBefore constraint of '<em>Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoStatement_doStatementAssignmentsBefore(DoStatement doStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return doStatement.doStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the doStatementAssignmentsAfter constraint of '<em>Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoStatement_doStatementAssignmentsAfter(DoStatement doStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return doStatement.doStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the doStatementCondition constraint of '<em>Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoStatement_doStatementCondition(DoStatement doStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return doStatement.doStatementCondition(diagnostics, context);
	}

	/**
	 * Validates the doStatementEnclosedStatements constraint of '<em>Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoStatement_doStatementEnclosedStatements(DoStatement doStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return doStatement.doStatementEnclosedStatements(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConcurrentClauses(ConcurrentClauses concurrentClauses, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(concurrentClauses, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validateConcurrentClauses_concurrentClausesAssignmentsBefore(concurrentClauses, diagnostics, context);
		if (result || diagnostics != null) result &= validateConcurrentClauses_concurrentClausesConditionAssignments(concurrentClauses, diagnostics, context);
		return result;
	}

	/**
	 * Validates the concurrentClausesAssignmentsBefore constraint of '<em>Concurrent Clauses</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConcurrentClauses_concurrentClausesAssignmentsBefore(ConcurrentClauses concurrentClauses, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return concurrentClauses.concurrentClausesAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the concurrentClausesConditionAssignments constraint of '<em>Concurrent Clauses</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConcurrentClauses_concurrentClausesConditionAssignments(ConcurrentClauses concurrentClauses, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return concurrentClauses.concurrentClausesConditionAssignments(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBreakStatement(BreakStatement breakStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(breakStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateBreakStatement_breakStatementTargetDerivation(breakStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateBreakStatement_breakStatementNonparallelTarget(breakStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the breakStatementTargetDerivation constraint of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBreakStatement_breakStatementTargetDerivation(BreakStatement breakStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return breakStatement.breakStatementTargetDerivation(diagnostics, context);
	}

	/**
	 * Validates the breakStatementNonparallelTarget constraint of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBreakStatement_breakStatementNonparallelTarget(BreakStatement breakStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return breakStatement.breakStatementNonparallelTarget(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionStatement(ExpressionStatement expressionStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(expressionStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpressionStatement_expressionStatementAssignmentsBefore(expressionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExpressionStatement_expressionStatementAssignmentsAfter(expressionStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the expressionStatementAssignmentsBefore constraint of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionStatement_expressionStatementAssignmentsBefore(ExpressionStatement expressionStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return expressionStatement.expressionStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the expressionStatementAssignmentsAfter constraint of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionStatement_expressionStatementAssignmentsAfter(ExpressionStatement expressionStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return expressionStatement.expressionStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifyStatement(ClassifyStatement classifyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifyStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifyStatement_classifyStatementExpression(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifyStatement_classifyStatementClassNames(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifyStatement_classifyStatementClasses(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifyStatement_classifyStatementAssignmentsBefore(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifyStatement_classifyStatementAssignmentsAfter(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifyStatement_classifyStatementFromClassDerivation(classifyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifyStatement_classifyStatementToClassDerivation(classifyStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the classifyStatementExpression constraint of '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifyStatement_classifyStatementExpression(ClassifyStatement classifyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifyStatement.classifyStatementExpression(diagnostics, context);
	}

	/**
	 * Validates the classifyStatementClassNames constraint of '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifyStatement_classifyStatementClassNames(ClassifyStatement classifyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifyStatement.classifyStatementClassNames(diagnostics, context);
	}

	/**
	 * Validates the classifyStatementClasses constraint of '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifyStatement_classifyStatementClasses(ClassifyStatement classifyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifyStatement.classifyStatementClasses(diagnostics, context);
	}

	/**
	 * Validates the classifyStatementAssignmentsBefore constraint of '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifyStatement_classifyStatementAssignmentsBefore(ClassifyStatement classifyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifyStatement.classifyStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the classifyStatementAssignmentsAfter constraint of '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifyStatement_classifyStatementAssignmentsAfter(ClassifyStatement classifyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifyStatement.classifyStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the classifyStatementFromClassDerivation constraint of '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifyStatement_classifyStatementFromClassDerivation(ClassifyStatement classifyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifyStatement.classifyStatementFromClassDerivation(diagnostics, context);
	}

	/**
	 * Validates the classifyStatementToClassDerivation constraint of '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifyStatement_classifyStatementToClassDerivation(ClassifyStatement classifyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifyStatement.classifyStatementToClassDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(forStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateForStatement_forStatementAssignmentsBefore(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateForStatement_forStatementAssignmentsAfter(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateForStatement_forStatementParallelAnnotationNames(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateForStatement_forStatementParallelAssignmentsAfter(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateForStatement_forStatementVariableDefinitions(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateForStatement_forStatementLoopVariables(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateForStatement_forStatementIsParallelDerivation(forStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateForStatement_forStatementEnclosedStatements(forStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the forStatementAssignmentsBefore constraint of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement_forStatementAssignmentsBefore(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forStatement.forStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the forStatementAssignmentsAfter constraint of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement_forStatementAssignmentsAfter(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forStatement.forStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the forStatementParallelAnnotationNames constraint of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement_forStatementParallelAnnotationNames(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forStatement.forStatementParallelAnnotationNames(diagnostics, context);
	}

	/**
	 * Validates the forStatementParallelAssignmentsAfter constraint of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement_forStatementParallelAssignmentsAfter(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forStatement.forStatementParallelAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the forStatementVariableDefinitions constraint of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement_forStatementVariableDefinitions(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forStatement.forStatementVariableDefinitions(diagnostics, context);
	}

	/**
	 * Validates the forStatementLoopVariables constraint of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement_forStatementLoopVariables(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forStatement.forStatementLoopVariables(diagnostics, context);
	}

	/**
	 * Validates the forStatementIsParallelDerivation constraint of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement_forStatementIsParallelDerivation(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forStatement.forStatementIsParallelDerivation(diagnostics, context);
	}

	/**
	 * Validates the forStatementEnclosedStatements constraint of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForStatement_forStatementEnclosedStatements(ForStatement forStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forStatement.forStatementEnclosedStatements(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(loopVariableDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopVariableDefinition_loopVariableDefinitionAssignmentAfterDerivation(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopVariableDefinition_loopVariableDefinitionAssignmentsBefore(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopVariableDefinition_loopVariableDefinitionRangeExpressions(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopVariableDefinition_loopVariableDefinitionTypeName(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopVariableDefinition_loopVariableDefinitionTypeDerivation(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopVariableDefinition_loopVariableDefinitionDeclaredType(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopVariableDefinition_loopVariableDefinitionIsCollectionConversionDerivation(loopVariableDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopVariableDefinition_loopVariableDefinitionVariable(loopVariableDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the loopVariableDefinitionAssignmentAfterDerivation constraint of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition_loopVariableDefinitionAssignmentAfterDerivation(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loopVariableDefinition.loopVariableDefinitionAssignmentAfterDerivation(diagnostics, context);
	}

	/**
	 * Validates the loopVariableDefinitionAssignmentsBefore constraint of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition_loopVariableDefinitionAssignmentsBefore(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loopVariableDefinition.loopVariableDefinitionAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the loopVariableDefinitionRangeExpressions constraint of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition_loopVariableDefinitionRangeExpressions(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loopVariableDefinition.loopVariableDefinitionRangeExpressions(diagnostics, context);
	}

	/**
	 * Validates the loopVariableDefinitionTypeName constraint of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition_loopVariableDefinitionTypeName(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loopVariableDefinition.loopVariableDefinitionTypeName(diagnostics, context);
	}

	/**
	 * Validates the loopVariableDefinitionTypeDerivation constraint of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition_loopVariableDefinitionTypeDerivation(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loopVariableDefinition.loopVariableDefinitionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the loopVariableDefinitionDeclaredType constraint of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition_loopVariableDefinitionDeclaredType(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loopVariableDefinition.loopVariableDefinitionDeclaredType(diagnostics, context);
	}

	/**
	 * Validates the loopVariableDefinitionIsCollectionConversionDerivation constraint of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition_loopVariableDefinitionIsCollectionConversionDerivation(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loopVariableDefinition.loopVariableDefinitionIsCollectionConversionDerivation(diagnostics, context);
	}

	/**
	 * Validates the loopVariableDefinitionVariable constraint of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariableDefinition_loopVariableDefinitionVariable(LoopVariableDefinition loopVariableDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loopVariableDefinition.loopVariableDefinitionVariable(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfStatement(IfStatement ifStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(ifStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateIfStatement_ifStatementAssignmentsBefore(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateIfStatement_ifStatementAssignmentsAfter(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateIfStatement_ifStatementEnclosedStatements(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateIfStatement_ifStatementIsAssuredDerivation(ifStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateIfStatement_ifStatementIsDeterminateDerivation(ifStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ifStatementAssignmentsBefore constraint of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfStatement_ifStatementAssignmentsBefore(IfStatement ifStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ifStatement.ifStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the ifStatementAssignmentsAfter constraint of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfStatement_ifStatementAssignmentsAfter(IfStatement ifStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ifStatement.ifStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the ifStatementEnclosedStatements constraint of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfStatement_ifStatementEnclosedStatements(IfStatement ifStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ifStatement.ifStatementEnclosedStatements(diagnostics, context);
	}

	/**
	 * Validates the ifStatementIsAssuredDerivation constraint of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfStatement_ifStatementIsAssuredDerivation(IfStatement ifStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ifStatement.ifStatementIsAssuredDerivation(diagnostics, context);
	}

	/**
	 * Validates the ifStatementIsDeterminateDerivation constraint of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfStatement_ifStatementIsDeterminateDerivation(IfStatement ifStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ifStatement.ifStatementIsDeterminateDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(switchStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchStatement_switchStatementAssignmentsBefore(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchStatement_switchStatementCaseAssignments(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchStatement_switchStatementAssignmentsAfter(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchStatement_switchStatementAssignments(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchStatement_switchStatementExpression(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchStatement_switchStatementEnclosedStatements(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchStatement_switchStatementIsDeterminateDerivation(switchStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchStatement_switchStatementIsAssuredDerivation(switchStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the switchStatementAssignmentsBefore constraint of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement_switchStatementAssignmentsBefore(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchStatement.switchStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the switchStatementCaseAssignments constraint of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement_switchStatementCaseAssignments(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchStatement.switchStatementCaseAssignments(diagnostics, context);
	}

	/**
	 * Validates the switchStatementAssignmentsAfter constraint of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement_switchStatementAssignmentsAfter(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchStatement.switchStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the switchStatementAssignments constraint of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement_switchStatementAssignments(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchStatement.switchStatementAssignments(diagnostics, context);
	}

	/**
	 * Validates the switchStatementExpression constraint of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement_switchStatementExpression(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchStatement.switchStatementExpression(diagnostics, context);
	}

	/**
	 * Validates the switchStatementEnclosedStatements constraint of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement_switchStatementEnclosedStatements(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchStatement.switchStatementEnclosedStatements(diagnostics, context);
	}

	/**
	 * Validates the switchStatementIsDeterminateDerivation constraint of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement_switchStatementIsDeterminateDerivation(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchStatement.switchStatementIsDeterminateDerivation(diagnostics, context);
	}

	/**
	 * Validates the switchStatementIsAssuredDerivation constraint of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchStatement_switchStatementIsAssuredDerivation(SwitchStatement switchStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchStatement.switchStatementIsAssuredDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchClause(SwitchClause switchClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(switchClause, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchClause_switchClauseAssignmentsBefore(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchClause_switchClauseCaseLocalNames(switchClause, diagnostics, context);
		if (result || diagnostics != null) result &= validateSwitchClause_switchClauseCases(switchClause, diagnostics, context);
		return result;
	}

	/**
	 * Validates the switchClauseAssignmentsBefore constraint of '<em>Switch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchClause_switchClauseAssignmentsBefore(SwitchClause switchClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchClause.switchClauseAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the switchClauseCaseLocalNames constraint of '<em>Switch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchClause_switchClauseCaseLocalNames(SwitchClause switchClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchClause.switchClauseCaseLocalNames(diagnostics, context);
	}

	/**
	 * Validates the switchClauseCases constraint of '<em>Switch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSwitchClause_switchClauseCases(SwitchClause switchClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return switchClause.switchClauseCases(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileStatement(WhileStatement whileStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(whileStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateWhileStatement_whileStatementAssignmentsBefore(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateWhileStatement_whileStatementAssignmentsAfter(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateWhileStatement_whileStatementCondition(whileStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateWhileStatement_whileStatementEnclosedStatements(whileStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the whileStatementAssignmentsBefore constraint of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileStatement_whileStatementAssignmentsBefore(WhileStatement whileStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return whileStatement.whileStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the whileStatementAssignmentsAfter constraint of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileStatement_whileStatementAssignmentsAfter(WhileStatement whileStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return whileStatement.whileStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the whileStatementCondition constraint of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileStatement_whileStatementCondition(WhileStatement whileStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return whileStatement.whileStatementCondition(diagnostics, context);
	}

	/**
	 * Validates the whileStatementEnclosedStatements constraint of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileStatement_whileStatementEnclosedStatements(WhileStatement whileStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return whileStatement.whileStatementEnclosedStatements(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReturnStatement(ReturnStatement returnStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(returnStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateReturnStatement_returnStatementContext(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateReturnStatement_returnStatementAssignmentsBefore(returnStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateReturnStatement_returnStatementAssignmentsAfter(returnStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the returnStatementContext constraint of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReturnStatement_returnStatementContext(ReturnStatement returnStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return returnStatement.returnStatementContext(diagnostics, context);
	}

	/**
	 * Validates the returnStatementAssignmentsBefore constraint of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReturnStatement_returnStatementAssignmentsBefore(ReturnStatement returnStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return returnStatement.returnStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the returnStatementAssignmentsAfter constraint of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReturnStatement_returnStatementAssignmentsAfter(ReturnStatement returnStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return returnStatement.returnStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInLineStatement(InLineStatement inLineStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(inLineStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(inLineStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateInLineStatement_inLineStatementAssignmentsAfter(inLineStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the inLineStatementAssignmentsAfter constraint of '<em>In Line Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInLineStatement_inLineStatementAssignmentsAfter(InLineStatement inLineStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return inLineStatement.inLineStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(acceptStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementContext(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementSignals(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementNames(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementSimpleAcceptLocalName(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementCompoundAcceptLocalName(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementAssignmentsBefore(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementAssignmentsAfter(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementNewAssignments(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementIsSimpleDerivation(acceptStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptStatement_acceptStatementEnclosedStatements(acceptStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the acceptStatementContext constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementContext(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementContext(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementSignals constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementSignals(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementSignals(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementNames constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementNames(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementNames(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementSimpleAcceptLocalName constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementSimpleAcceptLocalName(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementSimpleAcceptLocalName(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementCompoundAcceptLocalName constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementCompoundAcceptLocalName(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementCompoundAcceptLocalName(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementAssignmentsBefore constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementAssignmentsBefore(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementAssignmentsBefore(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementAssignmentsAfter constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementAssignmentsAfter(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementNewAssignments constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementNewAssignments(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementNewAssignments(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementIsSimpleDerivation constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementIsSimpleDerivation(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementIsSimpleDerivation(diagnostics, context);
	}

	/**
	 * Validates the acceptStatementEnclosedStatements constraint of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptStatement_acceptStatementEnclosedStatements(AcceptStatement acceptStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptStatement.acceptStatementEnclosedStatements(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptBlock(AcceptBlock acceptBlock, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(acceptBlock, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptBlock_acceptBlockSignalDerivation(acceptBlock, diagnostics, context);
		if (result || diagnostics != null) result &= validateAcceptBlock_acceptBlockSignalNames(acceptBlock, diagnostics, context);
		return result;
	}

	/**
	 * Validates the acceptBlockSignalDerivation constraint of '<em>Accept Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptBlock_acceptBlockSignalDerivation(AcceptBlock acceptBlock, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptBlock.acceptBlockSignalDerivation(diagnostics, context);
	}

	/**
	 * Validates the acceptBlockSignalNames constraint of '<em>Accept Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptBlock_acceptBlockSignalNames(AcceptBlock acceptBlock, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return acceptBlock.acceptBlockSignalNames(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmptyStatement(EmptyStatement emptyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(emptyStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementAnnotationsAllowed(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementUniqueAssignments(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateStatement_statementIsIsolatedDerivation(emptyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateEmptyStatement_emptyStatementAssignmentsAfter(emptyStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the emptyStatementAssignmentsAfter constraint of '<em>Empty Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmptyStatement_emptyStatementAssignmentsAfter(EmptyStatement emptyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return emptyStatement.emptyStatementAssignmentsAfter(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelNamespace(ModelNamespace modelNamespace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelNamespace, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(modelNamespace, diagnostics, context);
		if (result || diagnostics != null) result &= validatePackageDefinition_packageDefinitionAppliedProfileDerivation(modelNamespace, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespaceDefinition(NamespaceDefinition namespaceDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namespaceDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(namespaceDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(namespaceDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the namespaceDefinitionMemberDerivation constraint of '<em>Namespace Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespaceDefinition_namespaceDefinitionMemberDerivation(NamespaceDefinition namespaceDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return namespaceDefinition.namespaceDefinitionMemberDerivation(diagnostics, context);
	}

	/**
	 * Validates the namespaceDefinitionMemberDistinguishability constraint of '<em>Namespace Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(NamespaceDefinition namespaceDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return namespaceDefinition.namespaceDefinitionMemberDistinguishability(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memberDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(memberDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(memberDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the memberAnnotations constraint of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition_memberAnnotations(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return memberDefinition.memberAnnotations(diagnostics, context);
	}

	/**
	 * Validates the memberIsPrimitiveDerivation constraint of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition_memberIsPrimitiveDerivation(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return memberDefinition.memberIsPrimitiveDerivation(diagnostics, context);
	}

	/**
	 * Validates the memberIsExternalDerivation constraint of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition_memberIsExternalDerivation(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return memberDefinition.memberIsExternalDerivation(diagnostics, context);
	}

	/**
	 * Validates the memberExternal constraint of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition_memberExternal(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return memberDefinition.memberExternal(diagnostics, context);
	}

	/**
	 * Validates the memberStub constraint of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition_memberStub(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return memberDefinition.memberStub(diagnostics, context);
	}

	/**
	 * Validates the memberSubunitDerivation constraint of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition_memberSubunitDerivation(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return memberDefinition.memberSubunitDerivation(diagnostics, context);
	}

	/**
	 * Validates the memberStubStereotypes constraint of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition_memberStubStereotypes(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return memberDefinition.memberStubStereotypes(diagnostics, context);
	}

	/**
	 * Validates the memberPrimitive constraint of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemberDefinition_memberPrimitive(MemberDefinition memberDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return memberDefinition.memberPrimitive(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeAnnotation(StereotypeAnnotation stereotypeAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(stereotypeAnnotation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validateStereotypeAnnotation_stereotypeAnnotationStereotypeDerivation(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validateStereotypeAnnotation_stereotypeAnnotationStereotypeName(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validateStereotypeAnnotation_stereotypeAnnotationApply(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validateStereotypeAnnotation_stereotypeAnnotationPrimitive(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validateStereotypeAnnotation_stereotypeAnnotationExternal(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validateStereotypeAnnotation_stereotypeAnnotationTaggedValues(stereotypeAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validateStereotypeAnnotation_stereotypeAnnotationNames(stereotypeAnnotation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the stereotypeAnnotationStereotypeDerivation constraint of '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeAnnotation_stereotypeAnnotationStereotypeDerivation(StereotypeAnnotation stereotypeAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stereotypeAnnotation.stereotypeAnnotationStereotypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the stereotypeAnnotationStereotypeName constraint of '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeAnnotation_stereotypeAnnotationStereotypeName(StereotypeAnnotation stereotypeAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stereotypeAnnotation.stereotypeAnnotationStereotypeName(diagnostics, context);
	}

	/**
	 * Validates the stereotypeAnnotationApply constraint of '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeAnnotation_stereotypeAnnotationApply(StereotypeAnnotation stereotypeAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stereotypeAnnotation.stereotypeAnnotationApply(diagnostics, context);
	}

	/**
	 * Validates the stereotypeAnnotationPrimitive constraint of '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeAnnotation_stereotypeAnnotationPrimitive(StereotypeAnnotation stereotypeAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stereotypeAnnotation.stereotypeAnnotationPrimitive(diagnostics, context);
	}

	/**
	 * Validates the stereotypeAnnotationExternal constraint of '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeAnnotation_stereotypeAnnotationExternal(StereotypeAnnotation stereotypeAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stereotypeAnnotation.stereotypeAnnotationExternal(diagnostics, context);
	}

	/**
	 * Validates the stereotypeAnnotationTaggedValues constraint of '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeAnnotation_stereotypeAnnotationTaggedValues(StereotypeAnnotation stereotypeAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stereotypeAnnotation.stereotypeAnnotationTaggedValues(diagnostics, context);
	}

	/**
	 * Validates the stereotypeAnnotationNames constraint of '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeAnnotation_stereotypeAnnotationNames(StereotypeAnnotation stereotypeAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return stereotypeAnnotation.stereotypeAnnotationNames(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTaggedValueList(TaggedValueList taggedValueList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(taggedValueList, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTaggedValue(TaggedValue taggedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(taggedValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitDefinition(UnitDefinition unitDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unitDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnitDefinition_unitDefinitionNamespaceDerivation(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnitDefinition_unitDefinitionNamespace(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnitDefinition_unitDefinitionIsModelLibraryDerivation(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnitDefinition_unitDefinitionImplicitImports(unitDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnitDefinition_unitDefinitionAppliedProfileDerivation(unitDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the unitDefinitionNamespaceDerivation constraint of '<em>Unit Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitDefinition_unitDefinitionNamespaceDerivation(UnitDefinition unitDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return unitDefinition.unitDefinitionNamespaceDerivation(diagnostics, context);
	}

	/**
	 * Validates the unitDefinitionNamespace constraint of '<em>Unit Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitDefinition_unitDefinitionNamespace(UnitDefinition unitDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return unitDefinition.unitDefinitionNamespace(diagnostics, context);
	}

	/**
	 * Validates the unitDefinitionIsModelLibraryDerivation constraint of '<em>Unit Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitDefinition_unitDefinitionIsModelLibraryDerivation(UnitDefinition unitDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return unitDefinition.unitDefinitionIsModelLibraryDerivation(diagnostics, context);
	}

	/**
	 * Validates the unitDefinitionImplicitImports constraint of '<em>Unit Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitDefinition_unitDefinitionImplicitImports(UnitDefinition unitDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return unitDefinition.unitDefinitionImplicitImports(diagnostics, context);
	}

	/**
	 * Validates the unitDefinitionAppliedProfileDerivation constraint of '<em>Unit Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitDefinition_unitDefinitionAppliedProfileDerivation(UnitDefinition unitDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return unitDefinition.unitDefinitionAppliedProfileDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportReference(ImportReference importReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(importReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateImportReference_importReferenceReferentDerivation(importReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateImportReference_importReferenceReferent(importReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the importReferenceReferentDerivation constraint of '<em>Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportReference_importReferenceReferentDerivation(ImportReference importReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return importReference.importReferenceReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the importReferenceReferent constraint of '<em>Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportReference_importReferenceReferent(ImportReference importReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return importReference.importReferenceReferent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportedMember(ImportedMember importedMember, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(importedMember, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateImportedMember_importedMemberNotStub(importedMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateImportedMember_importedMemberIsFeatureDerivation(importedMember, diagnostics, context);
		return result;
	}

	/**
	 * Validates the importedMemberNotStub constraint of '<em>Imported Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportedMember_importedMemberNotStub(ImportedMember importedMember, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return importedMember.importedMemberNotStub(diagnostics, context);
	}

	/**
	 * Validates the importedMemberIsFeatureDerivation constraint of '<em>Imported Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportedMember_importedMemberIsFeatureDerivation(ImportedMember importedMember, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return importedMember.importedMemberIsFeatureDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteralName(EnumerationLiteralName enumerationLiteralName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumerationLiteralName, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(enumerationLiteralName, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(enumerationLiteralName, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionNamespace(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionRedefinedOperationDerivation(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionRedefinition(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionRedefinedOperations(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionIsFeatureDerivation(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionIsConstructorDerivation(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionIsDestructorDerivation(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionConstructorDestructor(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionConstructor(operationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationDefinition_operationDefinitionDestructor(operationDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the operationDefinitionNamespace constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionNamespace(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionNamespace(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionRedefinedOperationDerivation constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionRedefinedOperationDerivation(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionRedefinedOperationDerivation(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionRedefinition constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionRedefinition(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionRedefinition(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionRedefinedOperations constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionRedefinedOperations(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionRedefinedOperations(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionIsFeatureDerivation constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionIsFeatureDerivation(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionIsFeatureDerivation(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionIsConstructorDerivation constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionIsConstructorDerivation(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionIsConstructorDerivation(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionIsDestructorDerivation constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionIsDestructorDerivation(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionIsDestructorDerivation(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionConstructorDestructor constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionConstructorDestructor(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionConstructorDestructor(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionConstructor constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionConstructor(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionConstructor(diagnostics, context);
	}

	/**
	 * Validates the operationDefinitionDestructor constraint of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationDefinition_operationDefinitionDestructor(OperationDefinition operationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationDefinition.operationDefinitionDestructor(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationDefinition(AssociationDefinition associationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(associationDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(associationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssociationDefinition_associationDefinitionSpecializationReferent(associationDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the associationDefinitionSpecializationReferent constraint of '<em>Association Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationDefinition_associationDefinitionSpecializationReferent(AssociationDefinition associationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return associationDefinition.associationDefinitionSpecializationReferent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierDefinition(ClassifierDefinition classifierDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifierDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(classifierDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(classifierDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the classifierDefinitionSpecialization constraint of '<em>Classifier Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierDefinition_classifierDefinitionSpecialization(ClassifierDefinition classifierDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifierDefinition.classifierDefinitionSpecialization(diagnostics, context);
	}

	/**
	 * Validates the classifierDefinitionSpecializationReferentDerivation constraint of '<em>Classifier Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(ClassifierDefinition classifierDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifierDefinition.classifierDefinitionSpecializationReferentDerivation(diagnostics, context);
	}

	/**
	 * Validates the classifierDefinitionInheritedMembers constraint of '<em>Classifier Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierDefinition_classifierDefinitionInheritedMembers(ClassifierDefinition classifierDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classifierDefinition.classifierDefinitionInheritedMembers(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassDefinition(ClassDefinition classDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassDefinition_classDefinitionSpecializationReferent(classDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassDefinition_classDefinitionAbstractMember(classDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the classDefinitionSpecializationReferent constraint of '<em>Class Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassDefinition_classDefinitionSpecializationReferent(ClassDefinition classDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classDefinition.classDefinitionSpecializationReferent(diagnostics, context);
	}

	/**
	 * Validates the classDefinitionAbstractMember constraint of '<em>Class Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassDefinition_classDefinitionAbstractMember(ClassDefinition classDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return classDefinition.classDefinitionAbstractMember(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElementDefinition(TypedElementDefinition typedElementDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typedElementDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElementDefinition_typedElementDefinitionLowerDerivation(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElementDefinition_typedElementDefinitionUpperDerivation(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElementDefinition_typedElementDefinitionTypeDerivation(typedElementDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElementDefinition_typedElementDefinitionTypeName(typedElementDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the typedElementDefinitionLowerDerivation constraint of '<em>Typed Element Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElementDefinition_typedElementDefinitionLowerDerivation(TypedElementDefinition typedElementDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return typedElementDefinition.typedElementDefinitionLowerDerivation(diagnostics, context);
	}

	/**
	 * Validates the typedElementDefinitionUpperDerivation constraint of '<em>Typed Element Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElementDefinition_typedElementDefinitionUpperDerivation(TypedElementDefinition typedElementDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return typedElementDefinition.typedElementDefinitionUpperDerivation(diagnostics, context);
	}

	/**
	 * Validates the typedElementDefinitionTypeDerivation constraint of '<em>Typed Element Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElementDefinition_typedElementDefinitionTypeDerivation(TypedElementDefinition typedElementDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return typedElementDefinition.typedElementDefinitionTypeDerivation(diagnostics, context);
	}

	/**
	 * Validates the typedElementDefinitionTypeName constraint of '<em>Typed Element Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElementDefinition_typedElementDefinitionTypeName(TypedElementDefinition typedElementDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return typedElementDefinition.typedElementDefinitionTypeName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataTypeDefinition(DataTypeDefinition dataTypeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataTypeDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataTypeDefinition_dataTypeDefinitionPrimitive(dataTypeDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataTypeDefinition_dataTypeDefinitionSpecializationReferent(dataTypeDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the dataTypeDefinitionPrimitive constraint of '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataTypeDefinition_dataTypeDefinitionPrimitive(DataTypeDefinition dataTypeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return dataTypeDefinition.dataTypeDefinitionPrimitive(diagnostics, context);
	}

	/**
	 * Validates the dataTypeDefinitionSpecializationReferent constraint of '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataTypeDefinition_dataTypeDefinitionSpecializationReferent(DataTypeDefinition dataTypeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return dataTypeDefinition.dataTypeDefinitionSpecializationReferent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageDefinition(PackageDefinition packageDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(packageDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(packageDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validatePackageDefinition_packageDefinitionAppliedProfileDerivation(packageDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the packageDefinitionAppliedProfileDerivation constraint of '<em>Package Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageDefinition_packageDefinitionAppliedProfileDerivation(PackageDefinition packageDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return packageDefinition.packageDefinitionAppliedProfileDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyDefinition(PropertyDefinition propertyDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyDefinition_propertyDefinitionInitializer(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyDefinition_propertyDefinitionIsCollectionConversionDerivation(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyDefinition_propertyDefinitionIsBitStringConversionDerivation(propertyDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyDefinition_propertyDefinitionIsFeatureDerivation(propertyDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the propertyDefinitionInitializer constraint of '<em>Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyDefinition_propertyDefinitionInitializer(PropertyDefinition propertyDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyDefinition.propertyDefinitionInitializer(diagnostics, context);
	}

	/**
	 * Validates the propertyDefinitionIsCollectionConversionDerivation constraint of '<em>Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyDefinition_propertyDefinitionIsCollectionConversionDerivation(PropertyDefinition propertyDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyDefinition.propertyDefinitionIsCollectionConversionDerivation(diagnostics, context);
	}

	/**
	 * Validates the propertyDefinitionIsBitStringConversionDerivation constraint of '<em>Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyDefinition_propertyDefinitionIsBitStringConversionDerivation(PropertyDefinition propertyDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyDefinition.propertyDefinitionIsBitStringConversionDerivation(diagnostics, context);
	}

	/**
	 * Validates the propertyDefinitionIsFeatureDerivation constraint of '<em>Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyDefinition_propertyDefinitionIsFeatureDerivation(PropertyDefinition propertyDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyDefinition.propertyDefinitionIsFeatureDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignalDefinition(SignalDefinition signalDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(signalDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(signalDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateSignalDefinition_signalDefinitionSpecializationReferent(signalDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the signalDefinitionSpecializationReferent constraint of '<em>Signal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignalDefinition_signalDefinitionSpecializationReferent(SignalDefinition signalDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return signalDefinition.signalDefinitionSpecializationReferent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActiveClassDefinition(ActiveClassDefinition activeClassDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(activeClassDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassDefinition_classDefinitionSpecializationReferent(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassDefinition_classDefinitionAbstractMember(activeClassDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateActiveClassDefinition_activeClassDefinitionClassifierBehavior(activeClassDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the activeClassDefinitionClassifierBehavior constraint of '<em>Active Class Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActiveClassDefinition_activeClassDefinitionClassifierBehavior(ActiveClassDefinition activeClassDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return activeClassDefinition.activeClassDefinitionClassifierBehavior(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityDefinition(ActivityDefinition activityDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(activityDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateActivityDefinition_activityDefinitionSpecialization(activityDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateActivityDefinition_activityDefinitionPrimitive(activityDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the activityDefinitionSpecialization constraint of '<em>Activity Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityDefinition_activityDefinitionSpecialization(ActivityDefinition activityDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return activityDefinition.activityDefinitionSpecialization(diagnostics, context);
	}

	/**
	 * Validates the activityDefinitionPrimitive constraint of '<em>Activity Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityDefinition_activityDefinitionPrimitive(ActivityDefinition activityDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return activityDefinition.activityDefinitionPrimitive(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementImportReference(ElementImportReference elementImportReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(elementImportReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateImportReference_importReferenceReferentDerivation(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateImportReference_importReferenceReferent(elementImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElementImportReference_elementImportReferenceReferent(elementImportReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the elementImportReferenceReferent constraint of '<em>Element Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementImportReference_elementImportReferenceReferent(ElementImportReference elementImportReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return elementImportReference.elementImportReferenceReferent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignalReceptionDefinition(SignalReceptionDefinition signalReceptionDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(signalReceptionDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateSignalDefinition_signalDefinitionSpecializationReferent(signalReceptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateSignalReceptionDefinition_signalReceptionDefinitionIsFeatureDerivation(signalReceptionDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the signalReceptionDefinitionIsFeatureDerivation constraint of '<em>Signal Reception Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignalReceptionDefinition_signalReceptionDefinitionIsFeatureDerivation(SignalReceptionDefinition signalReceptionDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return signalReceptionDefinition.signalReceptionDefinitionIsFeatureDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationDefinition(EnumerationDefinition enumerationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumerationDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(enumerationDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateEnumerationDefinition_enumerationDefinitionSpecializationReferent(enumerationDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the enumerationDefinitionSpecializationReferent constraint of '<em>Enumeration Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationDefinition_enumerationDefinitionSpecializationReferent(EnumerationDefinition enumerationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return enumerationDefinition.enumerationDefinitionSpecializationReferent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageImportReference(PackageImportReference packageImportReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(packageImportReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateImportReference_importReferenceReferentDerivation(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateImportReference_importReferenceReferent(packageImportReference, diagnostics, context);
		if (result || diagnostics != null) result &= validatePackageImportReference_packageImportReferenceReferent(packageImportReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the packageImportReferenceReferent constraint of '<em>Package Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageImportReference_packageImportReferenceReferent(PackageImportReference packageImportReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return packageImportReference.packageImportReferenceReferent(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierTemplateParameter(ClassifierTemplateParameter classifierTemplateParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifierTemplateParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(classifierTemplateParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFormalParameter(FormalParameter formalParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(formalParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(formalParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(formalParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReceptionDefinition(ReceptionDefinition receptionDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(receptionDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateReceptionDefinition_receptionDefinitionSignalName(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateReceptionDefinition_receptionDefinitionSignalDerivation(receptionDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateReceptionDefinition_receptionDefinitionIsFeatureDerivation(receptionDefinition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the receptionDefinitionSignalName constraint of '<em>Reception Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReceptionDefinition_receptionDefinitionSignalName(ReceptionDefinition receptionDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return receptionDefinition.receptionDefinitionSignalName(diagnostics, context);
	}

	/**
	 * Validates the receptionDefinitionSignalDerivation constraint of '<em>Reception Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReceptionDefinition_receptionDefinitionSignalDerivation(ReceptionDefinition receptionDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return receptionDefinition.receptionDefinitionSignalDerivation(diagnostics, context);
	}

	/**
	 * Validates the receptionDefinitionIsFeatureDerivation constraint of '<em>Reception Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReceptionDefinition_receptionDefinitionIsFeatureDerivation(ReceptionDefinition receptionDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return receptionDefinition.receptionDefinitionIsFeatureDerivation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMember(Member member, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(member, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotatedStatement(AnnotatedStatement annotatedStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(annotatedStatement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoundClassifier(BoundClassifier boundClassifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(boundClassifier, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(boundClassifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(boundClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReturnParameter(ReturnParameter returnParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(returnParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(returnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(returnParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonReturnParameter(NonReturnParameter nonReturnParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nonReturnParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(nonReturnParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(nonReturnParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyType(AnyType anyType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(anyType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberAnnotations(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsPrimitiveDerivation(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberIsExternalDerivation(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberExternal(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStub(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberSubunitDerivation(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberStubStereotypes(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemberDefinition_memberPrimitive(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDerivation(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespaceDefinition_namespaceDefinitionMemberDistinguishability(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecialization(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionSpecializationReferentDerivation(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClassifierDefinition_classifierDefinitionInheritedMembers(anyType, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // AlfValidator
