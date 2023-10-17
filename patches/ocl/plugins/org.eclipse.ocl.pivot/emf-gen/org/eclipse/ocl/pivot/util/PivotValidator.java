/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.util;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.AssociationClassCallExp;
import org.eclipse.ocl.pivot.AssociativityKind;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.BooleanType;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CallOperationAction;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionKind;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.ConnectionPointReference;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.DynamicBehavior;
import org.eclipse.ocl.pivot.DynamicElement;
import org.eclipse.ocl.pivot.DynamicProperty;
import org.eclipse.ocl.pivot.DynamicType;
import org.eclipse.ocl.pivot.DynamicValueSpecification;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.ElementLiteralExp;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.FeatureCallExp;
import org.eclipse.ocl.pivot.FinalState;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.InstanceSpecification;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.IterableType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.MessageType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.NumericLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.OrphanCompletePackage;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Profile;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Pseudostate;
import org.eclipse.ocl.pivot.PseudostateKind;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.Region;
import org.eclipse.ocl.pivot.ResultVariable;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.SendSignalAction;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.Signal;
import org.eclipse.ocl.pivot.Slot;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.StateExp;
import org.eclipse.ocl.pivot.StateMachine;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Transition;
import org.eclipse.ocl.pivot.TransitionKind;
import org.eclipse.ocl.pivot.Trigger;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.Vertex;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.WildcardType;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotDiagnostician;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.utilities.MorePivotable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.Pivotable;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.PivotPackage
 * @generated
 */
public class PivotValidator
extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PivotValidator INSTANCE = new PivotValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.pivot"; //$NON-NLS-1$

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Boolean' of 'Boolean Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BOOLEAN_LITERAL_EXP__VALIDATE_TYPE_IS_BOOLEAN = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Source Can Be Null' of 'Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_EXP__VALIDATE_SAFE_SOURCE_CAN_BE_NULL = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Source Cannot Be Map' of 'Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_EXP__VALIDATE_SAFE_SOURCE_CANNOT_BE_MAP = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_EXP__VALIDATE_TYPE_IS_NOT_INVALID = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Not Null' of 'Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__VALIDATE_NAME_IS_NOT_NULL = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Invariant Name' of 'Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__VALIDATE_UNIQUE_INVARIANT_NAME = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Item Type' of 'Collection Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_ITEM__VALIDATE_TYPE_IS_ITEM_TYPE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Bag Kind Is Bag' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__VALIDATE_BAG_KIND_IS_BAG = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collection Kind Is Concrete' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__VALIDATE_COLLECTION_KIND_IS_CONCRETE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Ordered Set Kind Is Ordered Set' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__VALIDATE_ORDERED_SET_KIND_IS_ORDERED_SET = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sequence Kind Is Sequence' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__VALIDATE_SEQUENCE_KIND_IS_SEQUENCE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Set Kind Is Set' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__VALIDATE_SET_KIND_IS_SET = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Collection Literal Part'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_PART__VALIDATE_TYPE_IS_NOT_INVALID = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Boolean Valued' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__VALIDATE_BOOLEAN_VALUED = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Name' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__VALIDATE_UNIQUE_NAME = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Behavioral Class Has Distinct Name' of 'Data Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DATA_TYPE__VALIDATE_BEHAVIORAL_CLASS_HAS_DISTINCT_NAME = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Behavioral Class Is Primitive Type' of 'Data Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DATA_TYPE__VALIDATE_BEHAVIORAL_CLASS_IS_PRIMITIVE_TYPE = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Behavioral Class Is Super Class' of 'Data Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DATA_TYPE__VALIDATE_BEHAVIORAL_CLASS_IS_SUPER_CLASS = 18;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Enumeration Type' of 'Enum Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ENUM_LITERAL_EXP__VALIDATE_TYPE_IS_ENUMERATION_TYPE = 19;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Not Null' of 'Feature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE__VALIDATE_NAME_IS_NOT_NULL = 20;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Feature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE__VALIDATE_TYPE_IS_NOT_INVALID = 21;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Null' of 'Feature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FEATURE__VALIDATE_TYPE_IS_NOT_NULL = 22;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Condition Type Is Boolean' of 'If Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IF_EXP__VALIDATE_CONDITION_TYPE_IS_BOOLEAN = 23;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'If Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IF_EXP__VALIDATE_TYPE_IS_NOT_INVALID = 24;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Integer' of 'Integer Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTEGER_LITERAL_EXP__VALIDATE_TYPE_IS_INTEGER = 25;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Body Type Conforms To Result Type' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__VALIDATE_BODY_TYPE_CONFORMS_TO_RESULT_TYPE = 26;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Initializer' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__VALIDATE_ONE_INITIALIZER = 27;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Iterator Is Required' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__VALIDATE_SAFE_ITERATOR_IS_REQUIRED = 28;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Source Can Be Null' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__VALIDATE_SAFE_SOURCE_CAN_BE_NULL = 29;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Result Type' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__VALIDATE_TYPE_IS_RESULT_TYPE = 30;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unsafe Source Can Not Be Null' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL = 31;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Any Body Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_ANY_BODY_TYPE_IS_BOOLEAN = 32;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Any Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_ANY_HAS_ONE_ITERATOR = 33;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Any Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_ANY_TYPE_IS_SOURCE_ELEMENT_TYPE = 34;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Body Element Type Is Iterator Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_CLOSURE_BODY_ELEMENT_TYPE_IS_ITERATOR_TYPE = 35;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Body Type Is Conformantto Iterator Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_CLOSURE_BODY_TYPE_IS_CONFORMANTTO_ITERATOR_TYPE = 36;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Element Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE = 37;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_CLOSURE_HAS_ONE_ITERATOR = 38;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Result Element Type Is Iterator Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_CLOSURE_RESULT_ELEMENT_TYPE_IS_ITERATOR_TYPE = 39;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Source Element Type Is Body Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE = 40;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Type Is Unique Collection' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_CLOSURE_TYPE_IS_UNIQUE_COLLECTION = 41;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collect Element Type Is Flattened Body Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_COLLECT_ELEMENT_TYPE_IS_FLATTENED_BODY_TYPE = 42;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collect Type Is Unordered' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_COLLECT_TYPE_IS_UNORDERED = 43;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Iterator Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE = 44;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Iterator Type Is Source Key Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_ITERATOR_TYPE_IS_SOURCE_KEY_TYPE = 45;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Iterator Is Required' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_SAFE_ITERATOR_IS_REQUIRED = 46;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Source Can Be Null' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_SAFE_SOURCE_CAN_BE_NULL = 47;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sorted By Element Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE = 48;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sorted By Is Ordered If Source Is Ordered' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED = 49;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sorted By Iterator Type Is Comparable' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_SORTED_BY_ITERATOR_TYPE_IS_COMPARABLE = 50;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unsafe Source Can Not Be Null' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL = 51;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has No Initializer' of 'Iterator Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_VARIABLE__VALIDATE_HAS_NO_INITIALIZER = 52;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Nullity For In' of 'Let Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LET_EXP__VALIDATE_COMPATIBLE_NULLITY_FOR_IN = 53;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is In Type' of 'Let Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LET_EXP__VALIDATE_TYPE_IS_IN_TYPE = 54;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Let Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LET_EXP__VALIDATE_TYPE_IS_NOT_INVALID = 55;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Nullity For Initializer' of 'Let Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LET_VARIABLE__VALIDATE_COMPATIBLE_NULLITY_FOR_INITIALIZER = 56;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Initializer' of 'Let Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LET_VARIABLE__VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER = 57;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has Initializer' of 'Let Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LET_VARIABLE__VALIDATE_HAS_INITIALIZER = 58;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Matching Map Co Iterators' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__VALIDATE_MATCHING_MAP_CO_ITERATORS = 59;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Matching Ordered Collection Co Iterators' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__VALIDATE_MATCHING_ORDERED_COLLECTION_CO_ITERATORS = 60;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Co Initializers' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__VALIDATE_NO_CO_INITIALIZERS = 61;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Initializers' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__VALIDATE_NO_INITIALIZERS = 62;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Not Ordered Collection Co Iterators' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__VALIDATE_NO_NOT_ORDERED_COLLECTION_CO_ITERATORS = 63;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Is Collection' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__VALIDATE_SOURCE_IS_COLLECTION = 64;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Is Iterable' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__VALIDATE_SOURCE_IS_ITERABLE = 65;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Call Or One Send' of 'Message Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE_EXP__VALIDATE_ONE_CALL_OR_ONE_SEND = 66;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Is Not ACollection' of 'Message Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE_EXP__VALIDATE_TARGET_IS_NOT_ACOLLECTION = 67;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Null' of 'OCL Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OCL_EXPRESSION__VALIDATE_TYPE_IS_NOT_NULL = 68;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Return' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__VALIDATE_COMPATIBLE_RETURN = 69;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Loadable Implementation' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__VALIDATE_LOADABLE_IMPLEMENTATION = 70;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Postcondition Name' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__VALIDATE_UNIQUE_POSTCONDITION_NAME = 71;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Precondition Name' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__VALIDATE_UNIQUE_PRECONDITION_NAME = 72;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Argument Count' of 'Operation Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_CALL_EXP__VALIDATE_ARGUMENT_COUNT = 73;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Argument Type Is Conformant' of 'Operation Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_CALL_EXP__VALIDATE_ARGUMENT_TYPE_IS_CONFORMANT = 74;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Source Can Be Null' of 'Operation Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_CALL_EXP__VALIDATE_SAFE_SOURCE_CAN_BE_NULL = 75;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unsafe Source Can Not Be Null' of 'Operation Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_CALL_EXP__VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL = 76;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Source Can Be Null' of 'Opposite Property Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPPOSITE_PROPERTY_CALL_EXP__VALIDATE_SAFE_SOURCE_CAN_BE_NULL = 77;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unsafe Source Can Not Be Null' of 'Opposite Property Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPPOSITE_PROPERTY_CALL_EXP__VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL = 78;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has No Initializer' of 'Parameter Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER_VARIABLE__VALIDATE_HAS_NO_INITIALIZER = 79;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Default Expression' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__VALIDATE_COMPATIBLE_DEFAULT_EXPRESSION = 80;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Result Type' of 'Property Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_CALL_EXP__VALIDATE_COMPATIBLE_RESULT_TYPE = 81;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Non Static Source Type Is Conformant' of 'Property Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_CALL_EXP__VALIDATE_NON_STATIC_SOURCE_TYPE_IS_CONFORMANT = 82;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Safe Source Can Be Null' of 'Property Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_CALL_EXP__VALIDATE_SAFE_SOURCE_CAN_BE_NULL = 83;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unsafe Source Can Not Be Null' of 'Property Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_CALL_EXP__VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL = 84;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Nullity For Initializer' of 'Result Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESULT_VARIABLE__VALIDATE_COMPATIBLE_NULLITY_FOR_INITIALIZER = 85;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Initializer' of 'Result Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESULT_VARIABLE__VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER = 86;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has Initializer' of 'Result Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESULT_VARIABLE__VALIDATE_HAS_INITIALIZER = 87;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Class Has No String Value Initializer' of 'Shadow Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_EXP__VALIDATE_CLASS_HAS_NO_STRING_VALUE_INITIALIZER = 88;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Data Type Has No Part Initializers' of 'Shadow Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_EXP__VALIDATE_DATA_TYPE_HAS_NO_PART_INITIALIZERS = 89;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Data Type Has One Part Initializer' of 'Shadow Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_EXP__VALIDATE_DATA_TYPE_HAS_ONE_PART_INITIALIZER = 90;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Data Type Has String Value Initializer' of 'Shadow Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_EXP__VALIDATE_DATA_TYPE_HAS_STRING_VALUE_INITIALIZER = 91;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Initializes All Class Properties' of 'Shadow Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_EXP__VALIDATE_INITIALIZES_ALL_CLASS_PROPERTIES = 92;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Shadow Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_EXP__VALIDATE_TYPE_IS_NOT_INVALID = 93;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Initialiser Type' of 'Shadow Part'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_PART__VALIDATE_COMPATIBLE_INITIALISER_TYPE = 94;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Shadow Part'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_PART__VALIDATE_TYPE_IS_NOT_INVALID = 95;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Null' of 'Shadow Part'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHADOW_PART__VALIDATE_TYPE_IS_NOT_NULL = 96;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'State Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE_EXP__VALIDATE_TYPE_IS_NOT_INVALID = 97;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Initialiser Type' of 'Tuple Literal Part'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TUPLE_LITERAL_PART__VALIDATE_COMPATIBLE_INITIALISER_TYPE = 98;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Tuple Literal Part'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TUPLE_LITERAL_PART__VALIDATE_TYPE_IS_NOT_INVALID = 99;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Initialiser Type' of 'Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE__VALIDATE_COMPATIBLE_INITIALISER_TYPE = 100;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Not Null' of 'Variable Declaration'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE_DECLARATION__VALIDATE_NAME_IS_NOT_NULL = 101;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Variable Declaration'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE_DECLARATION__VALIDATE_TYPE_IS_NOT_INVALID = 102;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Null' of 'Variable Declaration'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE_DECLARATION__VALIDATE_TYPE_IS_NOT_NULL = 103;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Not Invalid' of 'Variable Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE_EXP__VALIDATE_TYPE_IS_NOT_INVALID = 104;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 104;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PivotValidator() {
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
	  return PivotPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID)
		{
			case 0:
				return validateAnnotation((Annotation)value, diagnostics, context);
			case 1:
				return validateAnyType((AnyType)value, diagnostics, context);
			case 2:
				return validateAssociationClass((AssociationClass)value, diagnostics, context);
			case 3:
				return validateAssociationClassCallExp((AssociationClassCallExp)value, diagnostics, context);
			case 4:
				return validateBagType((BagType)value, diagnostics, context);
			case 5:
				return validateBehavior((Behavior)value, diagnostics, context);
			case 6:
				return validateBooleanLiteralExp((BooleanLiteralExp)value, diagnostics, context);
			case 7:
				return validateBooleanType((BooleanType)value, diagnostics, context);
			case 8:
				return validateCallExp((CallExp)value, diagnostics, context);
			case 9:
				return validateCallOperationAction((CallOperationAction)value, diagnostics, context);
			case 10:
				return validateClass((org.eclipse.ocl.pivot.Class)value, diagnostics, context);
			case 11:
				return validateCollectionItem((CollectionItem)value, diagnostics, context);
			case 12:
				return validateCollectionLiteralExp((CollectionLiteralExp)value, diagnostics, context);
			case 13:
				return validateCollectionLiteralPart((CollectionLiteralPart)value, diagnostics, context);
			case 14:
				return validateCollectionRange((CollectionRange)value, diagnostics, context);
			case 15:
				return validateCollectionType((CollectionType)value, diagnostics, context);
			case 16:
				return validateComment((Comment)value, diagnostics, context);
			case 17:
				return validateCompleteClass((CompleteClass)value, diagnostics, context);
			case 18:
				return validateCompleteEnvironment((CompleteEnvironment)value, diagnostics, context);
			case 19:
				return validateCompleteModel((CompleteModel)value, diagnostics, context);
			case 20:
				return validateCompletePackage((CompletePackage)value, diagnostics, context);
			case 21:
				return validateConnectionPointReference((ConnectionPointReference)value, diagnostics, context);
			case 22:
				return validateConstraint((Constraint)value, diagnostics, context);
			case 23:
				return validateDataType((DataType)value, diagnostics, context);
			case 24:
				return validateDetail((Detail)value, diagnostics, context);
			case 25:
				return validateDynamicBehavior((DynamicBehavior)value, diagnostics, context);
			case 26:
				return validateDynamicElement((DynamicElement)value, diagnostics, context);
			case 27:
				return validateDynamicProperty((DynamicProperty)value, diagnostics, context);
			case 28:
				return validateDynamicType((DynamicType)value, diagnostics, context);
			case 29:
				return validateDynamicValueSpecification((DynamicValueSpecification)value, diagnostics, context);
			case 30:
				return validateElement((Element)value, diagnostics, context);
			case 31:
				return validateElementExtension((ElementExtension)value, diagnostics, context);
			case 32:
				return validateElementLiteralExp((ElementLiteralExp)value, diagnostics, context);
			case 33:
				return validateEnumLiteralExp((EnumLiteralExp)value, diagnostics, context);
			case 34:
				return validateEnumeration((Enumeration)value, diagnostics, context);
			case 35:
				return validateEnumerationLiteral((EnumerationLiteral)value, diagnostics, context);
			case 36:
				return validateExpressionInOCL((ExpressionInOCL)value, diagnostics, context);
			case 37:
				return validateFeature((Feature)value, diagnostics, context);
			case 38:
				return validateFeatureCallExp((FeatureCallExp)value, diagnostics, context);
			case 39:
				return validateFinalState((FinalState)value, diagnostics, context);
			case 40:
				return validateIfExp((IfExp)value, diagnostics, context);
			case 41:
				return validateImport((Import)value, diagnostics, context);
			case 42:
				return validateInstanceSpecification((InstanceSpecification)value, diagnostics, context);
			case 43:
				return validateIntegerLiteralExp((IntegerLiteralExp)value, diagnostics, context);
			case 44:
				return validateInvalidLiteralExp((InvalidLiteralExp)value, diagnostics, context);
			case 45:
				return validateInvalidType((InvalidType)value, diagnostics, context);
			case 46:
				return validateIterableType((IterableType)value, diagnostics, context);
			case 47:
				return validateIterateExp((IterateExp)value, diagnostics, context);
			case 48:
				return validateIteration((Iteration)value, diagnostics, context);
			case 49:
				return validateIteratorExp((IteratorExp)value, diagnostics, context);
			case 50:
				return validateIteratorVariable((IteratorVariable)value, diagnostics, context);
			case 51:
				return validateLambdaType((LambdaType)value, diagnostics, context);
			case 52:
				return validateLanguageExpression((LanguageExpression)value, diagnostics, context);
			case 53:
				return validateLetExp((LetExp)value, diagnostics, context);
			case 54:
				return validateLetVariable((LetVariable)value, diagnostics, context);
			case 55:
				return validateLibrary((Library)value, diagnostics, context);
			case 56:
				return validateLiteralExp((LiteralExp)value, diagnostics, context);
			case 57:
				return validateLoopExp((LoopExp)value, diagnostics, context);
			case 58:
				return validateMapLiteralExp((MapLiteralExp)value, diagnostics, context);
			case 59:
				return validateMapLiteralPart((MapLiteralPart)value, diagnostics, context);
			case 60:
				return validateMapType((MapType)value, diagnostics, context);
			case 61:
				return validateMessageExp((MessageExp)value, diagnostics, context);
			case 62:
				return validateMessageType((MessageType)value, diagnostics, context);
			case 63:
				return validateModel((Model)value, diagnostics, context);
			case 64:
				return validateMorePivotable((MorePivotable)value, diagnostics, context);
			case 65:
				return validateNameable((Nameable)value, diagnostics, context);
			case 66:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case 67:
				return validateNamespace((Namespace)value, diagnostics, context);
			case 68:
				return validateNavigationCallExp((NavigationCallExp)value, diagnostics, context);
			case 69:
				return validateNullLiteralExp((NullLiteralExp)value, diagnostics, context);
			case 70:
				return validateNumericLiteralExp((NumericLiteralExp)value, diagnostics, context);
			case 71:
				return validateOCLExpression((OCLExpression)value, diagnostics, context);
			case 72:
				return validateOperation((Operation)value, diagnostics, context);
			case 73:
				return validateOperationCallExp((OperationCallExp)value, diagnostics, context);
			case 74:
				return validateOppositePropertyCallExp((OppositePropertyCallExp)value, diagnostics, context);
			case 75:
				return validateOrderedSetType((OrderedSetType)value, diagnostics, context);
			case 76:
				return validateOrphanCompletePackage((OrphanCompletePackage)value, diagnostics, context);
			case 77:
				return validatePackage((org.eclipse.ocl.pivot.Package)value, diagnostics, context);
			case 78:
				return validateParameter((Parameter)value, diagnostics, context);
			case 79:
				return validateParameterVariable((ParameterVariable)value, diagnostics, context);
			case 80:
				return validatePivotable((Pivotable)value, diagnostics, context);
			case 81:
				return validatePrecedence((Precedence)value, diagnostics, context);
			case 82:
				return validatePrimitiveCompletePackage((PrimitiveCompletePackage)value, diagnostics, context);
			case 83:
				return validatePrimitiveLiteralExp((PrimitiveLiteralExp)value, diagnostics, context);
			case 84:
				return validatePrimitiveType((PrimitiveType)value, diagnostics, context);
			case 85:
				return validateProfile((Profile)value, diagnostics, context);
			case 86:
				return validateProfileApplication((ProfileApplication)value, diagnostics, context);
			case 87:
				return validateProperty((Property)value, diagnostics, context);
			case 88:
				return validatePropertyCallExp((PropertyCallExp)value, diagnostics, context);
			case 89:
				return validatePseudostate((Pseudostate)value, diagnostics, context);
			case 90:
				return validateRealLiteralExp((RealLiteralExp)value, diagnostics, context);
			case 91:
				return validateReferringElement((ReferringElement)value, diagnostics, context);
			case 92:
				return validateRegion((Region)value, diagnostics, context);
			case 93:
				return validateResultVariable((ResultVariable)value, diagnostics, context);
			case 94:
				return validateSelfType((SelfType)value, diagnostics, context);
			case 95:
				return validateSendSignalAction((SendSignalAction)value, diagnostics, context);
			case 96:
				return validateSequenceType((SequenceType)value, diagnostics, context);
			case 97:
				return validateSetType((SetType)value, diagnostics, context);
			case 98:
				return validateShadowExp((ShadowExp)value, diagnostics, context);
			case 99:
				return validateShadowPart((ShadowPart)value, diagnostics, context);
			case 100:
				return validateSignal((Signal)value, diagnostics, context);
			case 101:
				return validateSlot((Slot)value, diagnostics, context);
			case 102:
				return validateStandardLibrary((StandardLibrary)value, diagnostics, context);
			case 103:
				return validateState((State)value, diagnostics, context);
			case 104:
				return validateStateExp((StateExp)value, diagnostics, context);
			case 105:
				return validateStateMachine((StateMachine)value, diagnostics, context);
			case 106:
				return validateStereotype((Stereotype)value, diagnostics, context);
			case 107:
				return validateStereotypeExtender((StereotypeExtender)value, diagnostics, context);
			case 108:
				return validateStringLiteralExp((StringLiteralExp)value, diagnostics, context);
			case 109:
				return validateTemplateBinding((TemplateBinding)value, diagnostics, context);
			case 110:
				return validateTemplateParameter((TemplateParameter)value, diagnostics, context);
			case 111:
				return validateTemplateParameterSubstitution((TemplateParameterSubstitution)value, diagnostics, context);
			case 112:
				return validateTemplateSignature((TemplateSignature)value, diagnostics, context);
			case 113:
				return validateTemplateableElement((TemplateableElement)value, diagnostics, context);
			case 114:
				return validateTransition((Transition)value, diagnostics, context);
			case 115:
				return validateTrigger((Trigger)value, diagnostics, context);
			case 116:
				return validateTupleLiteralExp((TupleLiteralExp)value, diagnostics, context);
			case 117:
				return validateTupleLiteralPart((TupleLiteralPart)value, diagnostics, context);
			case 118:
				return validateTupleType((TupleType)value, diagnostics, context);
			case 119:
				return validateType((Type)value, diagnostics, context);
			case 120:
				return validateTypeExp((TypeExp)value, diagnostics, context);
			case 121:
				return validateTypedElement((TypedElement)value, diagnostics, context);
			case 122:
				return validateUnlimitedNaturalLiteralExp((UnlimitedNaturalLiteralExp)value, diagnostics, context);
			case 123:
				return validateUnspecifiedValueExp((UnspecifiedValueExp)value, diagnostics, context);
			case 124:
				return validateValueSpecification((ValueSpecification)value, diagnostics, context);
			case 125:
				return validateVariable((Variable)value, diagnostics, context);
			case 126:
				return validateVariableDeclaration((VariableDeclaration)value, diagnostics, context);
			case 127:
				return validateVariableExp((VariableExp)value, diagnostics, context);
			case 128:
				return validateVertex((Vertex)value, diagnostics, context);
			case 129:
				return validateVisitable((Visitable)value, diagnostics, context);
			case 130:
				return validateVoidType((VoidType)value, diagnostics, context);
			case 131:
				return validateWildcardType((WildcardType)value, diagnostics, context);
			case 132:
				return validateAssociativityKind((AssociativityKind)value, diagnostics, context);
			case 133:
				return validateCollectionKind((CollectionKind)value, diagnostics, context);
			case 134:
				return validatePseudostateKind((PseudostateKind)value, diagnostics, context);
			case 135:
				return validateTransitionKind((TransitionKind)value, diagnostics, context);
			case 136:
				return validateBoolean((Boolean)value, diagnostics, context);
			case 137:
				return validateEcoreObject((EObject)value, diagnostics, context);
			case 138:
				return validateInteger((Number)value, diagnostics, context);
			case 139:
				return validateLibraryFeature((LibraryFeature)value, diagnostics, context);
			case 140:
				return validateObject(value, diagnostics, context);
			case 141:
				return validateReal((Number)value, diagnostics, context);
			case 142:
				return validateString((String)value, diagnostics, context);
			case 143:
				return validateThrowable((Throwable)value, diagnostics, context);
			case 144:
				return validateUnlimitedNatural((Number)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotation(Annotation annotation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(annotation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyType(AnyType anyType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(anyType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(anyType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(type, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace(Namespace namespace,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namespace, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(element, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementExtension(ElementExtension elementExtension, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(elementExtension, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(elementExtension, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementLiteralExp(ElementLiteralExp elementLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(elementLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(elementLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(elementLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(elementLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(elementLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(elementLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(elementLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(elementLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(elementLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(elementLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass(org.eclipse.ocl.pivot.Class class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(class_, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(class_, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNameIsNotNull constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_validateNameIsNotNull(org.eclipse.ocl.pivot.Class class_, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return class_.validateNameIsNotNull(diagnostics, context);
	}

	/**
	 * Validates the validateUniqueInvariantName constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_validateUniqueInvariantName(org.eclipse.ocl.pivot.Class class_, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return class_.validateUniqueInvariantName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(property, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(property, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateNameIsNotNull(property, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateTypeIsNotInvalid(property, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateTypeIsNotNull(property, diagnostics, context);
		if (result || diagnostics != null) result &= validateProperty_validateCompatibleDefaultExpression(property, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleDefaultExpression constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateCompatibleDefaultExpression(Property property, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return property.validateCompatibleDefaultExpression(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnlimitedNaturalLiteralExp(
			UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unlimitedNaturalLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(unlimitedNaturalLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrecedence(Precedence precedence,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(precedence, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveCompletePackage(PrimitiveCompletePackage primitiveCompletePackage, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(primitiveCompletePackage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameter(
			TemplateParameter templateParameter, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateSignature(
			TemplateSignature templateSignature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateSignature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateableElement(
			TemplateableElement templateableElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(transition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTrigger(Trigger trigger, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(trigger, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding(TemplateBinding templateBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitution(
			TemplateParameterSubstitution templateParameterSubstitution,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateParameterSubstitution, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClass(AssociationClass associationClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(associationClass, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(associationClass, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateNameIsNotNull(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateTypeIsNotInvalid(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateTypeIsNotNull(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateCompatibleReturn(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateLoadableImplementation(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateUniquePostconditionName(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateUniquePreconditionName(operation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleReturn constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateCompatibleReturn(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operation.validateCompatibleReturn(diagnostics, context);
	}

	/**
	 * Validates the validateLoadableImplementation constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateLoadableImplementation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operation.validateLoadableImplementation(diagnostics, context);
	}

	/**
	 * Validates the validateUniquePreconditionName constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateUniquePreconditionName(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operation.validateUniquePreconditionName(diagnostics, context);
	}

	/**
	 * Validates the validateUniquePostconditionName constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateUniquePostconditionName(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operation.validateUniquePostconditionName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateNameIsNotNull(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotInvalid(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotNull(parameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterVariable(ParameterVariable parameterVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(parameterVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateNameIsNotNull(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotInvalid(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotNull(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariable_validateCompatibleInitialiserType(parameterVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameterVariable_validateHasNoInitializer(parameterVariable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateHasNoInitializer constraint of '<em>Parameter Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterVariable_validateHasNoInitializer(ParameterVariable parameterVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return parameterVariable.validateHasNoInitializer(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePivotable(Pivotable pivotable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)pivotable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyCallExp(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(oppositePropertyCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyCallExp_validateSafeSourceCanBeNull(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyCallExp_validateUnsafeSourceCanNotBeNull(oppositePropertyCallExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSafeSourceCanBeNull constraint of '<em>Opposite Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyCallExp_validateSafeSourceCanBeNull(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return oppositePropertyCallExp.validateSafeSourceCanBeNull(diagnostics, context);
	}

	/**
	 * Validates the validateUnsafeSourceCanNotBeNull constraint of '<em>Opposite Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyCallExp_validateUnsafeSourceCanNotBeNull(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return oppositePropertyCallExp.validateUnsafeSourceCanNotBeNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComment(Comment comment,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(comment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteClass(CompleteClass completeClass, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(completeClass, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteEnvironment(CompleteEnvironment completeEnvironment, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(completeEnvironment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteModel(CompleteModel completeModel, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(completeModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompletePackage(CompletePackage completePackage, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(completePackage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionPointReference(ConnectionPointReference connectionPointReference, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(connectionPointReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(constraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_validateBooleanValued(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_validateUniqueName(constraint, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateBooleanValued constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateBooleanValued(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return constraint.validateBooleanValued(diagnostics, context);
	}

	/**
	 * Validates the validateUniqueName constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateUniqueName(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return constraint.validateUniqueName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackage(
			org.eclipse.ocl.pivot.Package package_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(package_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClassCallExp(
			AssociationClassCallExp associationClassCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(associationClassCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCanBeNull(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(associationClassCallExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNavigationCallExp(
			NavigationCallExp navigationCallExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(navigationCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCanBeNull(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(navigationCallExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureCallExp(FeatureCallExp featureCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCanBeNull(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(featureCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(featureCallExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState(FinalState finalState, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(finalState, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallExp(CallExp callExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(callExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCanBeNull(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(callExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(callExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSafeSourceCanBeNull constraint of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallExp_validateSafeSourceCanBeNull(CallExp callExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return callExp.validateSafeSourceCanBeNull(diagnostics, context);
	}

	/**
	 * Validates the validateSafeSourceCannotBeMap constraint of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallExp_validateSafeSourceCannotBeMap(CallExp callExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return callExp.validateSafeSourceCannotBeMap(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallExp_validateTypeIsNotInvalid(CallExp callExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return callExp.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallOperationAction(
			CallOperationAction callOperationAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(callOperationAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBagType(BagType bagType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(bagType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(bagType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavior(Behavior behavior, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(behavior, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(behavior, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionType(CollectionType collectionType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(collectionType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(dataType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateBehavioralClassHasDistinctName constraint of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType_validateBehavioralClassHasDistinctName(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return dataType.validateBehavioralClassHasDistinctName(diagnostics, context);
	}

	/**
	 * Validates the validateBehavioralClassIsPrimitiveType constraint of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType_validateBehavioralClassIsPrimitiveType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return dataType.validateBehavioralClassIsPrimitiveType(diagnostics, context);
	}

	/**
	 * Validates the validateBehavioralClassIsSuperClass constraint of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType_validateBehavioralClassIsSuperClass(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return dataType.validateBehavioralClassIsSuperClass(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDetail(Detail detail, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(detail, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicBehavior(DynamicBehavior dynamicBehavior, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(dynamicBehavior, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(dynamicBehavior, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicElement(DynamicElement dynamicElement, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(dynamicElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicProperty(DynamicProperty dynamicProperty, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(dynamicProperty, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicType(DynamicType dynamicType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(dynamicType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(dynamicType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicValueSpecification(DynamicValueSpecification dynamicValueSpecification, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(dynamicValueSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteralExp(
			BooleanLiteralExp booleanLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(booleanLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateBooleanLiteralExp_validateTypeIsBoolean(booleanLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsBoolean constraint of '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteralExp_validateTypeIsBoolean(BooleanLiteralExp booleanLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return booleanLiteralExp.validateTypeIsBoolean(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanType(BooleanType booleanType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(booleanType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(booleanType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(booleanType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveLiteralExp(
			PrimitiveLiteralExp primitiveLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(primitiveLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(primitiveLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralExp(LiteralExp literalExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(literalExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(literalExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(literalExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(literalExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(literalExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(literalExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(literalExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(literalExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(literalExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(literalExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionItem(CollectionItem collectionItem,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionItem, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralPart_validateTypeIsNotInvalid(collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionItem_validateTypeIsItemType(collectionItem, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsItemType constraint of '<em>Collection Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionItem_validateTypeIsItemType(CollectionItem collectionItem, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionItem.validateTypeIsItemType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralPart(
			CollectionLiteralPart collectionLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionLiteralPart, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralPart_validateTypeIsNotInvalid(collectionLiteralPart, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Collection Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralPart_validateTypeIsNotInvalid(CollectionLiteralPart collectionLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralPart.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp(
			CollectionLiteralExp collectionLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateBagKindIsBag(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateCollectionKindIsConcrete(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateOrderedSetKindIsOrderedSet(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateSequenceKindIsSequence(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateSetKindIsSet(collectionLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateBagKindIsBag constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateBagKindIsBag(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateBagKindIsBag(diagnostics, context);
	}

	/**
	 * Validates the validateSequenceKindIsSequence constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateSequenceKindIsSequence(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateSequenceKindIsSequence(diagnostics, context);
	}

	/**
	 * Validates the validateOrderedSetKindIsOrderedSet constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateOrderedSetKindIsOrderedSet(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateOrderedSetKindIsOrderedSet(diagnostics, context);
	}

	/**
	 * Validates the validateSetKindIsSet constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateSetKindIsSet(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateSetKindIsSet(diagnostics, context);
	}

	/**
	 * Validates the validateCollectionKindIsConcrete constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateCollectionKindIsConcrete(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateCollectionKindIsConcrete(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionRange(CollectionRange collectionRange,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionRange, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collectionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collectionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralPart_validateTypeIsNotInvalid(collectionRange, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteralExp(EnumLiteralExp enumLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateEnumLiteralExp_validateTypeIsEnumerationType(enumLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsEnumerationType constraint of '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteralExp_validateTypeIsEnumerationType(EnumLiteralExp enumLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return enumLiteralExp.validateTypeIsEnumerationType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteral(
			EnumerationLiteral enumerationLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumerationLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean validateExpressionInOCLGen(ExpressionInOCL expressionInOCL, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(expressionInOCL, diagnostics, context);
	}
	public boolean validateExpressionInOCL(ExpressionInOCL expressionInOCL, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if ((expressionInOCL.getOwnedBody() == null) && (expressionInOCL.getBody() != null)) {
			assert context != null;
			OCL ocl = PivotDiagnostician.getOCL(context, expressionInOCL);
			try {
				((EnvironmentFactoryInternalExtension)ocl.getEnvironmentFactory()).parseSpecification(expressionInOCL);
			} catch (ParserException e) {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
						e.getLocalizedMessage(),
						new Object[] {expressionInOCL}));
				}
				return false;
			} finally {	// See Bug 577928 - must manually recurse if parsed lazily
				if ((diagnostics != null) && Boolean.FALSE.equals(context.get(DerivedConstants.VALIDATE_RECURSIVELY))) {
			        for (TreeIterator<? extends EObject> i = EcoreUtil.getAllContents(Collections.singleton(expressionInOCL.getOwnedBody())); i.hasNext();) {
			        	validate(i.next(), diagnostics, context);
			        }
				}
			}
		}
		return validateExpressionInOCLGen(expressionInOCL, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumeration(Enumeration enumeration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumeration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(enumeration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature(Feature feature,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(feature, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateNameIsNotNull(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateTypeIsNotInvalid(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateTypeIsNotNull(feature, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNameIsNotNull constraint of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature_validateNameIsNotNull(Feature feature, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return feature.validateNameIsNotNull(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature_validateTypeIsNotInvalid(Feature feature, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return feature.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotNull constraint of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature_validateTypeIsNotNull(Feature feature, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return feature.validateTypeIsNotNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateNameIsNotNull(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotInvalid(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotNull(variable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariable_validateCompatibleInitialiserType(variable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleInitialiserType constraint of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable_validateCompatibleInitialiserType(Variable variable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return variable.validateCompatibleInitialiserType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDeclaration(
			VariableDeclaration variableDeclaration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variableDeclaration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateNameIsNotNull(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotInvalid(variableDeclaration, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotNull(variableDeclaration, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNameIsNotNull constraint of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDeclaration_validateNameIsNotNull(VariableDeclaration variableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return variableDeclaration.validateNameIsNotNull(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDeclaration_validateTypeIsNotInvalid(VariableDeclaration variableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return variableDeclaration.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotNull constraint of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDeclaration_validateTypeIsNotNull(VariableDeclaration variableDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return variableDeclaration.validateTypeIsNotNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfExp(IfExp ifExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(ifExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIfExp_validateConditionTypeIsBoolean(ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIfExp_validateTypeIsNotInvalid(ifExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateConditionTypeIsBoolean constraint of '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfExp_validateConditionTypeIsBoolean(IfExp ifExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return ifExp.validateConditionTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfExp_validateTypeIsNotInvalid(IfExp ifExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return ifExp.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImport(Import import_, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(import_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSpecification(InstanceSpecification instanceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(instanceSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteralExp(
			IntegerLiteralExp integerLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(integerLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntegerLiteralExp_validateTypeIsInteger(integerLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsInteger constraint of '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteralExp_validateTypeIsInteger(IntegerLiteralExp integerLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return integerLiteralExp.validateTypeIsInteger(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericLiteralExp(
			NumericLiteralExp numericLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(numericLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(numericLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOCLExpression(OCLExpression oclExpression, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(oclExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(oclExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(oclExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(oclExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(oclExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(oclExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(oclExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(oclExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(oclExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(oclExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsNotNull constraint of '<em>OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOCLExpression_validateTypeIsNotNull(OCLExpression oclExpression, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return oclExpression.validateTypeIsNotNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvalidLiteralExp(
			InvalidLiteralExp invalidLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(invalidLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(invalidLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvalidType(InvalidType invalidType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(invalidType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(invalidType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterableType(IterableType iterableType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(iterableType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(iterableType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(iterableType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(iterateExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateSafeSourceCanBeNull(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateMatchingMapCoIterators(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateMatchingOrderedCollectionCoIterators(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoCoInitializers(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoInitializers(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoNotOrderedCollectionCoIterators(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsCollection(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsIterable(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateBodyTypeConformsToResultType(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateOneInitializer(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateSafeIteratorIsRequired(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateTypeIsResultType(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateUnsafeSourceCanNotBeNull(iterateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOneInitializer constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateOneInitializer(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateOneInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateSafeIteratorIsRequired constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateSafeIteratorIsRequired(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateSafeIteratorIsRequired(diagnostics, context);
	}

	/**
	 * Validates the validateSafeSourceCanBeNull constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateSafeSourceCanBeNull(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateSafeSourceCanBeNull(diagnostics, context);
	}

	/**
	 * Validates the validateBodyTypeConformsToResultType constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateBodyTypeConformsToResultType(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateBodyTypeConformsToResultType(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsResultType constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateTypeIsResultType(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateTypeIsResultType(diagnostics, context);
	}

	/**
	 * Validates the validateUnsafeSourceCanNotBeNull constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateUnsafeSourceCanNotBeNull(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateUnsafeSourceCanNotBeNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteration(Iteration iteration, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(iteration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateNameIsNotNull(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateTypeIsNotInvalid(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateFeature_validateTypeIsNotNull(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateCompatibleReturn(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateLoadableImplementation(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateUniquePostconditionName(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateUniquePreconditionName(iteration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(iteratorExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSafeSourceCanBeNull(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateMatchingMapCoIterators(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateMatchingOrderedCollectionCoIterators(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoCoInitializers(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoInitializers(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoNotOrderedCollectionCoIterators(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsCollection(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsIterable(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateAnyBodyTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateAnyHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateAnyTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureBodyElementTypeIsIteratorType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureBodyTypeIsConformanttoIteratorType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureElementTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureResultElementTypeIsIteratorType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureSourceElementTypeIsBodyElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureTypeIsUniqueCollection(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateCollectElementTypeIsFlattenedBodyType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateCollectTypeIsUnordered(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateIteratorTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateIteratorTypeIsSourceKeyType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSafeIteratorIsRequired(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSortedByElementTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSortedByIsOrderedIfSourceIsOrdered(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSortedByIteratorTypeIsComparable(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateUnsafeSourceCanNotBeNull(iteratorExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateClosureBodyTypeIsConformanttoIteratorType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureBodyTypeIsConformanttoIteratorType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureBodyTypeIsConformanttoIteratorType(diagnostics, context);
	}

	/**
	 * Validates the validateSortedByIteratorTypeIsComparable constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSortedByIteratorTypeIsComparable(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSortedByIteratorTypeIsComparable(diagnostics, context);
	}

	/**
	 * Validates the validateUnsafeSourceCanNotBeNull constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateUnsafeSourceCanNotBeNull(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateUnsafeSourceCanNotBeNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorVariable(IteratorVariable iteratorVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(iteratorVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateNameIsNotNull(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotInvalid(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotNull(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariable_validateCompatibleInitialiserType(iteratorVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorVariable_validateHasNoInitializer(iteratorVariable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateHasNoInitializer constraint of '<em>Iterator Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorVariable_validateHasNoInitializer(IteratorVariable iteratorVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorVariable.validateHasNoInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateIteratorTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateIteratorTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateIteratorTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateIteratorTypeIsSourceKeyType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateIteratorTypeIsSourceKeyType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateIteratorTypeIsSourceKeyType(diagnostics, context);
	}

	/**
	 * Validates the validateSafeIteratorIsRequired constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSafeIteratorIsRequired(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSafeIteratorIsRequired(diagnostics, context);
	}

	/**
	 * Validates the validateSafeSourceCanBeNull constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSafeSourceCanBeNull(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSafeSourceCanBeNull(diagnostics, context);
	}

	/**
	 * Validates the validateSortedByElementTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSortedByElementTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSortedByElementTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateSortedByIsOrderedIfSourceIsOrdered constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSortedByIsOrderedIfSourceIsOrdered(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSortedByIsOrderedIfSourceIsOrdered(diagnostics, context);
	}

	/**
	 * Validates the validateCollectTypeIsUnordered constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateCollectTypeIsUnordered(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateCollectTypeIsUnordered(diagnostics, context);
	}

	/**
	 * Validates the validateClosureElementTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureElementTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureElementTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateClosureSourceElementTypeIsBodyElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureSourceElementTypeIsBodyElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureSourceElementTypeIsBodyElementType(diagnostics, context);
	}

	/**
	 * Validates the validateClosureTypeIsUniqueCollection constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureTypeIsUniqueCollection(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureTypeIsUniqueCollection(diagnostics, context);
	}

	/**
	 * Validates the validateCollectElementTypeIsFlattenedBodyType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateCollectElementTypeIsFlattenedBodyType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateCollectElementTypeIsFlattenedBodyType(diagnostics, context);
	}

	/**
	 * Validates the validateClosureHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureHasOneIterator(diagnostics, context);
	}

	/**
	 * Validates the validateClosureResultElementTypeIsIteratorType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureResultElementTypeIsIteratorType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureResultElementTypeIsIteratorType(diagnostics, context);
	}

	/**
	 * Validates the validateAnyBodyTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateAnyBodyTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateAnyBodyTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateAnyTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateAnyTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateAnyTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateClosureBodyElementTypeIsIteratorType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureBodyElementTypeIsIteratorType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureBodyElementTypeIsIteratorType(diagnostics, context);
	}

	/**
	 * Validates the validateAnyHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateAnyHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateAnyHasOneIterator(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLambdaType(LambdaType lambdaType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(lambdaType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(lambdaType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLanguageExpression(LanguageExpression languageExpression, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(languageExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp(LoopExp loopExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(loopExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCanBeNull(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateMatchingMapCoIterators(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateMatchingOrderedCollectionCoIterators(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoCoInitializers(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoInitializers(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoNotOrderedCollectionCoIterators(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsCollection(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsIterable(loopExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMatchingMapCoIterators constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateMatchingMapCoIterators(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateMatchingMapCoIterators(diagnostics, context);
	}

	/**
	 * Validates the validateMatchingOrderedCollectionCoIterators constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateMatchingOrderedCollectionCoIterators(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateMatchingOrderedCollectionCoIterators(diagnostics, context);
	}

	/**
	 * Validates the validateNoCoInitializers constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateNoCoInitializers(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateNoCoInitializers(diagnostics, context);
	}

	/**
	 * Validates the validateNoInitializers constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateNoInitializers(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateNoInitializers(diagnostics, context);
	}

	/**
	 * Validates the validateNoNotOrderedCollectionCoIterators constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateNoNotOrderedCollectionCoIterators(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateNoNotOrderedCollectionCoIterators(diagnostics, context);
	}

	/**
	 * Validates the validateSourceIsCollection constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateSourceIsCollection(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateSourceIsCollection(diagnostics, context);
	}

	/**
	 * Validates the validateSourceIsIterable constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateSourceIsIterable(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateSourceIsIterable(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapLiteralExp(MapLiteralExp mapLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(mapLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mapLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mapLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mapLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mapLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mapLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mapLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mapLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mapLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(mapLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapLiteralPart(MapLiteralPart mapLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(mapLiteralPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapType(MapType mapType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(mapType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(mapType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(mapType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetExp(LetExp letExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(letExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLetExp_validateCompatibleNullityForIn(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLetExp_validateTypeIsInType(letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLetExp_validateTypeIsNotInvalid(letExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleNullityForIn constraint of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetExp_validateCompatibleNullityForIn(LetExp letExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return letExp.validateCompatibleNullityForIn(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsInType constraint of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetExp_validateTypeIsInType(LetExp letExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return letExp.validateTypeIsInType(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetExp_validateTypeIsNotInvalid(LetExp letExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return letExp.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetVariable(LetVariable letVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(letVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateNameIsNotNull(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotInvalid(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotNull(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariable_validateCompatibleInitialiserType(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateLetVariable_validateCompatibleNullityForInitializer(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateLetVariable_validateCompatibleTypeForInitializer(letVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateLetVariable_validateHasInitializer(letVariable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleNullityForInitializer constraint of '<em>Let Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetVariable_validateCompatibleNullityForInitializer(LetVariable letVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return letVariable.validateCompatibleNullityForInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForInitializer constraint of '<em>Let Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetVariable_validateCompatibleTypeForInitializer(LetVariable letVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return letVariable.validateCompatibleTypeForInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateHasInitializer constraint of '<em>Let Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetVariable_validateHasInitializer(LetVariable letVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return letVariable.validateHasInitializer(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibrary(Library library, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(library, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageExp(MessageExp messageExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(messageExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateMessageExp_validateOneCallOrOneSend(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateMessageExp_validateTargetIsNotACollection(messageExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTargetIsNotACollection constraint of '<em>Message Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageExp_validateTargetIsNotACollection(MessageExp messageExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return messageExp.validateTargetIsNotACollection(diagnostics, context);
	}

	/**
	 * Validates the validateOneCallOrOneSend constraint of '<em>Message Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageExp_validateOneCallOrOneSend(MessageExp messageExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return messageExp.validateOneCallOrOneSend(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageType(MessageType messageType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(messageType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(messageType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModel(Model model, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(model, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMorePivotable(MorePivotable morePivotable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)morePivotable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameable(Nameable nameable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)nameable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignal(Signal signal, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(signal, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(signal, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(signal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSlot(Slot slot, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(slot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStandardLibrary(StandardLibrary standardLibrary, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(standardLibrary, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNullLiteralExp(NullLiteralExp nullLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nullLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(nullLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp(OperationCallExp operationCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationCallExp_validateSafeSourceCanBeNull(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationCallExp_validateArgumentCount(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationCallExp_validateArgumentTypeIsConformant(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationCallExp_validateUnsafeSourceCanNotBeNull(operationCallExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateArgumentTypeIsConformant constraint of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp_validateArgumentTypeIsConformant(OperationCallExp operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operationCallExp.validateArgumentTypeIsConformant(diagnostics, context);
	}

	/**
	 * Validates the validateSafeSourceCanBeNull constraint of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp_validateSafeSourceCanBeNull(OperationCallExp operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operationCallExp.validateSafeSourceCanBeNull(diagnostics, context);
	}

	/**
	 * Validates the validateUnsafeSourceCanNotBeNull constraint of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp_validateUnsafeSourceCanNotBeNull(OperationCallExp operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operationCallExp.validateUnsafeSourceCanNotBeNull(diagnostics, context);
	}

	/**
	 * Validates the validateArgumentCount constraint of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp_validateArgumentCount(OperationCallExp operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operationCallExp.validateArgumentCount(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedSetType(OrderedSetType orderedSetType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(orderedSetType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(orderedSetType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrphanCompletePackage(OrphanCompletePackage orphanCompletePackage, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(orphanCompletePackage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveType(PrimitiveType primitiveType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(primitiveType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(primitiveType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfile(Profile profile, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(profile, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfileApplication(ProfileApplication profileApplication, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(profileApplication, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp(PropertyCallExp propertyCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyCallExp_validateSafeSourceCanBeNull(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateSafeSourceCannotBeMap(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallExp_validateTypeIsNotInvalid(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyCallExp_validateCompatibleResultType(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyCallExp_validateNonStaticSourceTypeIsConformant(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyCallExp_validateUnsafeSourceCanNotBeNull(propertyCallExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNonStaticSourceTypeIsConformant constraint of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp_validateNonStaticSourceTypeIsConformant(PropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return propertyCallExp.validateNonStaticSourceTypeIsConformant(diagnostics, context);
	}

	/**
	 * Validates the validateSafeSourceCanBeNull constraint of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp_validateSafeSourceCanBeNull(PropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return propertyCallExp.validateSafeSourceCanBeNull(diagnostics, context);
	}

	/**
	 * Validates the validateUnsafeSourceCanNotBeNull constraint of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp_validateUnsafeSourceCanNotBeNull(PropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return propertyCallExp.validateUnsafeSourceCanNotBeNull(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleResultType constraint of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp_validateCompatibleResultType(PropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return propertyCallExp.validateCompatibleResultType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate(Pseudostate pseudostate, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(pseudostate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealLiteralExp(RealLiteralExp realLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(realLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(realLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferringElement(ReferringElement referringElement, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(referringElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegion(Region region, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(region, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResultVariable(ResultVariable resultVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(resultVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateNameIsNotNull(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotInvalid(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotNull(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariable_validateCompatibleInitialiserType(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateResultVariable_validateCompatibleNullityForInitializer(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateResultVariable_validateCompatibleTypeForInitializer(resultVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateResultVariable_validateHasInitializer(resultVariable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleNullityForInitializer constraint of '<em>Result Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResultVariable_validateCompatibleNullityForInitializer(ResultVariable resultVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return resultVariable.validateCompatibleNullityForInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForInitializer constraint of '<em>Result Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResultVariable_validateCompatibleTypeForInitializer(ResultVariable resultVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return resultVariable.validateCompatibleTypeForInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateHasInitializer constraint of '<em>Result Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResultVariable_validateHasInitializer(ResultVariable resultVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return resultVariable.validateHasInitializer(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelfType(SelfType selfType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(selfType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(selfType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendSignalAction(SendSignalAction sendSignalAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sendSignalAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceType(SequenceType sequenceType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(sequenceType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetType(SetType setType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(setType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(setType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(setType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowExp(ShadowExp shadowExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(shadowExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowExp_validateClassHasNoStringValueInitializer(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowExp_validateDataTypeHasNoPartInitializers(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowExp_validateDataTypeHasOnePartInitializer(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowExp_validateDataTypeHasStringValueInitializer(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowExp_validateInitializesAllClassProperties(shadowExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowExp_validateTypeIsNotInvalid(shadowExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateClassHasNoStringValueInitializer constraint of '<em>Shadow Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowExp_validateClassHasNoStringValueInitializer(ShadowExp shadowExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowExp.validateClassHasNoStringValueInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateDataTypeHasNoPartInitializers constraint of '<em>Shadow Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowExp_validateDataTypeHasNoPartInitializers(ShadowExp shadowExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowExp.validateDataTypeHasNoPartInitializers(diagnostics, context);
	}

	/**
	 * Validates the validateDataTypeHasOnePartInitializer constraint of '<em>Shadow Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowExp_validateDataTypeHasOnePartInitializer(ShadowExp shadowExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowExp.validateDataTypeHasOnePartInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateDataTypeHasStringValueInitializer constraint of '<em>Shadow Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowExp_validateDataTypeHasStringValueInitializer(ShadowExp shadowExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowExp.validateDataTypeHasStringValueInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateInitializesAllClassProperties constraint of '<em>Shadow Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowExp_validateInitializesAllClassProperties(ShadowExp shadowExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowExp.validateInitializesAllClassProperties(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Shadow Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowExp_validateTypeIsNotInvalid(ShadowExp shadowExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowExp.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowPart(ShadowPart shadowPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(shadowPart, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowPart_validateCompatibleInitialiserType(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowPart_validateTypeIsNotInvalid(shadowPart, diagnostics, context);
		if (result || diagnostics != null) result &= validateShadowPart_validateTypeIsNotNull(shadowPart, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleInitialiserType constraint of '<em>Shadow Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowPart_validateCompatibleInitialiserType(ShadowPart shadowPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowPart.validateCompatibleInitialiserType(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Shadow Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowPart_validateTypeIsNotInvalid(ShadowPart shadowPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowPart.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotNull constraint of '<em>Shadow Part</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShadowPart_validateTypeIsNotNull(ShadowPart shadowPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return shadowPart.validateTypeIsNotNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState(State state, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(state, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateExp(StateExp stateExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(stateExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(stateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateStateExp_validateTypeIsNotInvalid(stateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>State Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateExp_validateTypeIsNotInvalid(StateExp stateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return stateExp.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateMachine(StateMachine stateMachine, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(stateMachine, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(stateMachine, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotype(Stereotype stereotype, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(stereotype, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(stereotype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypeExtender(StereotypeExtender stereotypeExtender, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(stereotypeExtender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteralExp(StringLiteralExp stringLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(stringLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(stringLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralExp(TupleLiteralExp tupleLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(tupleLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(tupleLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralPart(TupleLiteralPart tupleLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(tupleLiteralPart, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateNameIsNotNull(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validateTupleLiteralPart_validateTypeIsNotInvalid(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableDeclaration_validateTypeIsNotNull(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null) result &= validateTupleLiteralPart_validateCompatibleInitialiserType(tupleLiteralPart, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleInitialiserType constraint of '<em>Tuple Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralPart_validateCompatibleInitialiserType(TupleLiteralPart tupleLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return tupleLiteralPart.validateCompatibleInitialiserType(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Tuple Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralPart_validateTypeIsNotInvalid(TupleLiteralPart tupleLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return tupleLiteralPart.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleType(TupleType tupleType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(tupleType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassHasDistinctName(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsPrimitiveType(tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validateDataType_validateBehavioralClassIsSuperClass(tupleType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeExp(TypeExp typeExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typeExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(typeExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnspecifiedValueExp(
			UnspecifiedValueExp unspecifiedValueExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unspecifiedValueExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(unspecifiedValueExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueSpecification(
			ValueSpecification valueSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableExp(VariableExp variableExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variableExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOCLExpression_validateTypeIsNotNull(variableExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableExp_validateTypeIsNotInvalid(variableExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsNotInvalid constraint of '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableExp_validateTypeIsNotInvalid(VariableExp variableExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return variableExp.validateTypeIsNotInvalid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex(Vertex vertex, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(vertex, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisitable(Visitable visitable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)visitable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVoidType(VoidType voidType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(voidType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(voidType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWildcardType(WildcardType wildcardType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(wildcardType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateNameIsNotNull(wildcardType, diagnostics, context);
		if (result || diagnostics != null) result &= validateClass_validateUniqueInvariantName(wildcardType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociativityKind(
			AssociativityKind associativityKind, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionKind(CollectionKind collectionKind,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostateKind(PseudostateKind pseudostateKind, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransitionKind(TransitionKind transitionKind, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoolean(boolean boolean_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEcoreObject(EObject ecoreObject, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteger(Number integer, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibraryFeature(LibraryFeature libraryFeature, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObject(Object object, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReal(Number real, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateString(String string, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThrowable(Throwable throwable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnlimitedNatural(Number unlimitedNatural, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PivotPlugin.INSTANCE;
	}

} //PivotValidator
