/**
 */
package org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessageFactory;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlMessagePackageImpl extends EPackageImpl implements UmlMessagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceTermRuleEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private UmlMessagePackageImpl()
  {
    super(eNS_URI, UmlMessageFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link UmlMessagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static UmlMessagePackage init()
  {
    if (isInited) return (UmlMessagePackage)EPackage.Registry.INSTANCE.getEPackage(UmlMessagePackage.eNS_URI);

    // Obtain or create and register package
    Object registeredUmlMessagePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    UmlMessagePackageImpl theUmlMessagePackage = registeredUmlMessagePackage instanceof UmlMessagePackageImpl ? (UmlMessagePackageImpl)registeredUmlMessagePackage : new UmlMessagePackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theUmlMessagePackage.createPackageContents();

    // Initialize created meta-data
    theUmlMessagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theUmlMessagePackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(UmlMessagePackage.eNS_URI, theUmlMessagePackage);
    return theUmlMessagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessageRule()
  {
    return messageRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageRule_SequenceTerm()
  {
    return (EReference)messageRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMessageRule_Name()
  {
    return (EAttribute)messageRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceTermRule()
  {
    return sequenceTermRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceTermRule_SequencialOrder()
  {
    return (EAttribute)sequenceTermRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceTermRule_SequenceName()
  {
    return (EAttribute)sequenceTermRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceTermRule_Recurrence()
  {
    return (EAttribute)sequenceTermRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlMessageFactory getUmlMessageFactory()
  {
    return (UmlMessageFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    messageRuleEClass = createEClass(MESSAGE_RULE);
    createEReference(messageRuleEClass, MESSAGE_RULE__SEQUENCE_TERM);
    createEAttribute(messageRuleEClass, MESSAGE_RULE__NAME);

    sequenceTermRuleEClass = createEClass(SEQUENCE_TERM_RULE);
    createEAttribute(sequenceTermRuleEClass, SEQUENCE_TERM_RULE__SEQUENCIAL_ORDER);
    createEAttribute(sequenceTermRuleEClass, SEQUENCE_TERM_RULE__SEQUENCE_NAME);
    createEAttribute(sequenceTermRuleEClass, SEQUENCE_TERM_RULE__RECURRENCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(messageRuleEClass, MessageRule.class, "MessageRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMessageRule_SequenceTerm(), this.getSequenceTermRule(), null, "sequenceTerm", null, 0, -1, MessageRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMessageRule_Name(), theEcorePackage.getEString(), "name", null, 0, 1, MessageRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceTermRuleEClass, SequenceTermRule.class, "SequenceTermRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSequenceTermRule_SequencialOrder(), theEcorePackage.getEInt(), "sequencialOrder", null, 0, 1, SequenceTermRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSequenceTermRule_SequenceName(), theEcorePackage.getEString(), "sequenceName", null, 0, 1, SequenceTermRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSequenceTermRule_Recurrence(), theEcorePackage.getEString(), "recurrence", null, 0, 1, SequenceTermRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //UmlMessagePackageImpl
