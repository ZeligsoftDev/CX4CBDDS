/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.io.IOException;
import java.net.URL;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.papyrus.uml.alf.AlfFactory;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlfPackageImpl extends EPackageImpl implements AlfPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "alf.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignedSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syntaxElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalEnumerationLiteralReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceExpansionExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignableElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extentOrExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedTemplateBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterSubstitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forAllOrExistsOrOneExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isolationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass castExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionalTupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputNamedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invocationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputNamedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leftHandSideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceOperationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectOrRejectExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classExtentExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionalTemplateBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalLogicalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkOperationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalityExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceConstructionExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectOrIterateExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isUniqueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arithmeticExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureLeftHandSideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalTestExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceCreationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bitStringUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureInvocationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorInvocationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shiftExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unboundedLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thisExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classificationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass superInvocationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incrementOrDecrementExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedTupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass naturalLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameLeftHandSideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass effectiveLeftHandSideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceReductionExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceExpressionListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localNameDeclarationStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignableLocalNameDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedNameListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonFinalClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concurrentClausesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifyStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopVariableDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inLineStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acceptStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acceptBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelNamespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespaceDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedValueListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importedMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signalDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activeClassDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementImportReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signalReceptionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageImportReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierTemplateParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formalParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receptionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotatedStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonReturnParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anyTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AlfPackageImpl() {
		super(eNS_URI, AlfFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AlfPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static AlfPackage init() {
		if (isInited) return (AlfPackage)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI);

		// Obtain or create and register package
		AlfPackageImpl theAlfPackage = (AlfPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AlfPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AlfPackageImpl());

		isInited = true;

		// Load packages
		theAlfPackage.loadPackage();

		// Fix loaded packages
		theAlfPackage.fixPackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theAlfPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return AlfValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theAlfPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AlfPackage.eNS_URI, theAlfPackage);
		return theAlfPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignedSource() {
		if (assignedSourceEClass == null) {
			assignedSourceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(0);
		}
		return assignedSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignedSource_Name() {
        return (EAttribute)getAssignedSource().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignedSource_Source() {
        return (EReference)getAssignedSource().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignedSource_Upper() {
        return (EAttribute)getAssignedSource().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignedSource_Lower() {
        return (EAttribute)getAssignedSource().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignedSource_Type() {
        return (EReference)getAssignedSource().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignedSource_IsParallelLocalName() {
        return (EAttribute)getAssignedSource().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignedSource__IsNew__EList() {
        return getAssignedSource().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignedSource__Update__EList() {
        return getAssignedSource().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignedSource__Copy__SyntaxElement_boolean() {
        return getAssignedSource().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyntaxElement() {
		if (syntaxElementEClass == null) {
			syntaxElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(1);
		}
		return syntaxElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSyntaxElement_Owner() {
        return (EReference)getSyntaxElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__ToReference() {
        return getSyntaxElement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__Owner() {
        return getSyntaxElement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__SyntaxElement_owner() {
        return getSyntaxElement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__CurrentScope() {
        return getSyntaxElement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__SyntaxElement_currentScope() {
        return getSyntaxElement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__EnclosingStatement() {
        return getSyntaxElement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__EnclosingExpression() {
        return getSyntaxElement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__AssignmentsBefore() {
        return getSyntaxElement().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__SyntaxElement_assignmentsBefore() {
        return getSyntaxElement().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__SyntaxElement_assignmentsBefore_base() {
        return getSyntaxElement().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__AssignmentsBefore__SyntaxElement() {
        return getSyntaxElement().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__UpdateAll__EList_EList() {
        return getSyntaxElement().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__CommonAncestor__EList() {
        return getSyntaxElement().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__CommonAncestors__EList() {
        return getSyntaxElement().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__RemoveDuplicateElements__EList() {
        return getSyntaxElement().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__ResolveInLibrary__String() {
        return getSyntaxElement().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__PrimitiveType__String() {
        return getSyntaxElement().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__PrimitiveType___String() {
        return getSyntaxElement().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__BooleanType() {
        return getSyntaxElement().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsBooleanType__ElementReference() {
        return getSyntaxElement().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IntegerType() {
        return getSyntaxElement().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsIntegerType__ElementReference() {
        return getSyntaxElement().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__StringType() {
        return getSyntaxElement().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsStringType__ElementReference() {
        return getSyntaxElement().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__UnlimitedNaturalType() {
        return getSyntaxElement().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsUnlimitedNaturalType__ElementReference() {
        return getSyntaxElement().getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__BitStringType() {
        return getSyntaxElement().getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsBitStringType__ElementReference() {
        return getSyntaxElement().getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__NaturalType() {
        return getSyntaxElement().getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsNaturalType__ElementReference() {
        return getSyntaxElement().getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsNumericType__ElementReference() {
        return getSyntaxElement().getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__CollectionFunctionAdd() {
        return getSyntaxElement().getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsCollectionClass__ElementReference() {
        return getSyntaxElement().getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsIntegerCollectionClass__ElementReference() {
        return getSyntaxElement().getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSyntaxElement__IsBitStringCollectionClass__ElementReference() {
        return getSyntaxElement().getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementReference() {
		if (elementReferenceEClass == null) {
			elementReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(2);
		}
		return elementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsUml() {
        return getElementReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsAlf() {
        return getElementReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__AsUml() {
        return getElementReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__AsAlf() {
        return getElementReference().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__AsMember() {
        return getElementReference().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsSameKindAs__ElementReference() {
        return getElementReference().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsNamedElement() {
        return getElementReference().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsNamespace() {
        return getElementReference().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsNamespaceFor__UnitDefinition() {
        return getElementReference().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsModelNamespace() {
        return getElementReference().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsPackage() {
        return getElementReference().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsProfile() {
        return getElementReference().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsPackageableElement() {
        return getElementReference().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsClassifier() {
        return getElementReference().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsAbstractClassifier() {
        return getElementReference().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsAssociation() {
        return getElementReference().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsDataType() {
        return getElementReference().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsClass() {
        return getElementReference().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsActiveClass() {
        return getElementReference().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsSignal() {
        return getElementReference().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsEnumeration() {
        return getElementReference().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsBehavior() {
        return getElementReference().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsActivity() {
        return getElementReference().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsMethod() {
        return getElementReference().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsPrimitiveType() {
        return getElementReference().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsReception() {
        return getElementReference().getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsOperation() {
        return getElementReference().getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsConstructor() {
        return getElementReference().getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsDestructor() {
        return getElementReference().getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsFeature() {
        return getElementReference().getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsProperty() {
        return getElementReference().getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsAssociationEnd() {
        return getElementReference().getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsParameter() {
        return getElementReference().getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsTemplate() {
        return getElementReference().getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsTemplateParameter() {
        return getElementReference().getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsClassifierTemplateParameter() {
        return getElementReference().getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsParameteredElement() {
        return getElementReference().getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsTemplateBinding() {
        return getElementReference().getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsStereotype() {
        return getElementReference().getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsEnumerationLiteral() {
        return getElementReference().getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsLoopVariable() {
        return getElementReference().getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsAnnotation() {
        return getElementReference().getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsSequenceExpansionExpression() {
        return getElementReference().getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsAnyType() {
        return getElementReference().getEOperations().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsDistinguishableFrom__ElementReference() {
        return getElementReference().getEOperations().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsAssignableFrom__AssignableElement() {
        return getElementReference().getEOperations().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__CollectionArgument() {
        return getElementReference().getEOperations().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Name() {
        return getElementReference().getEOperations().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Visibility() {
        return getElementReference().getEOperations().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__OwnedMembers() {
        return getElementReference().getEOperations().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Members() {
        return getElementReference().getEOperations().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__VisibleMembers() {
        return getElementReference().getEOperations().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__NestedClassifiers() {
        return getElementReference().getEOperations().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Properties() {
        return getElementReference().getEOperations().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__AssociationEnds() {
        return getElementReference().getEOperations().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Opposite() {
        return getElementReference().getEOperations().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Receptions() {
        return getElementReference().getEOperations().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Signal() {
        return getElementReference().getEOperations().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Parameters() {
        return getElementReference().getEOperations().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ReturnParameter() {
        return getElementReference().getEOperations().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Specification() {
        return getElementReference().getEOperations().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__RedefinedOperations() {
        return getElementReference().getEOperations().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Namespace() {
        return getElementReference().getEOperations().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Template() {
        return getElementReference().getEOperations().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__TemplateParameters() {
        return getElementReference().getEOperations().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ParameteredElements() {
        return getElementReference().getEOperations().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__TemplateActuals() {
        return getElementReference().getEOperations().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Direction() {
        return getElementReference().getEOperations().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Association() {
        return getElementReference().getEOperations().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Type() {
        return getElementReference().getEOperations().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Lower() {
        return getElementReference().getEOperations().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Upper() {
        return getElementReference().getEOperations().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsOrdered() {
        return getElementReference().getEOperations().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsNonunique() {
        return getElementReference().getEOperations().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Parents() {
        return getElementReference().getEOperations().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__AllParents() {
        return getElementReference().getEOperations().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ClassifierBehavior() {
        return getElementReference().getEOperations().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Context() {
        return getElementReference().getEOperations().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__AppliedProfiles() {
        return getElementReference().getEOperations().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Base() {
        return getElementReference().getEOperations().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Reference() {
        return getElementReference().getEOperations().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__TemplateBinding() {
        return getElementReference().getEOperations().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Bind__EList() {
        return getElementReference().getEOperations().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__BoundElementName__EList() {
        return getElementReference().getEOperations().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__BoundPathName() {
        return getElementReference().getEOperations().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__QualifiedName() {
        return getElementReference().getEOperations().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ActiveClass() {
        return getElementReference().getEOperations().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__IsActiveBehavior() {
        return getElementReference().getEOperations().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ConformsTo__ElementReference() {
        return getElementReference().getEOperations().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Equals__ElementReference() {
        return getElementReference().getEOperations().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ContainedIn__EList() {
        return getElementReference().getEOperations().get(90);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__CountIn__EList() {
        return getElementReference().getEOperations().get(91);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__PositionIn__EList() {
        return getElementReference().getEOperations().get(92);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Copy() {
        return getElementReference().getEOperations().get(93);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ModelScope() {
        return getElementReference().getEOperations().get(94);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ResolvePathName__String() {
        return getElementReference().getEOperations().get(95);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Resolve__String() {
        return getElementReference().getEOperations().get(98);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ResolveInScope__String() {
        return getElementReference().getEOperations().get(96);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ResolveStereotype__String() {
        return getElementReference().getEOperations().get(97);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ResolveVisible__String_ElementReference() {
        return getElementReference().getEOperations().get(99);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ResolveAssociationEnd__ElementReference_String() {
        return getElementReference().getEOperations().get(100);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ContainsMember__ElementReference() {
        return getElementReference().getEOperations().get(101);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__AllowPackageOnly() {
        return getElementReference().getEOperations().get(102);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__Stub() {
        return getElementReference().getEOperations().get(103);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__StubFor__UnitDefinition() {
        return getElementReference().getEOperations().get(104);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementReference__ConstructorReference() {
        return getElementReference().getEOperations().get(105);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalElementReference() {
		if (internalElementReferenceEClass == null) {
			internalElementReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(3);
		}
		return internalElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalElementReference_Element() {
        return (EReference)getInternalElementReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsAlf() {
        return getInternalElementReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__AsAlf() {
        return getInternalElementReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__AsMember() {
        return getInternalElementReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsSameKindAs__ElementReference() {
        return getInternalElementReference().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsNamedElement() {
        return getInternalElementReference().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsNamespace() {
        return getInternalElementReference().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsNamespaceFor__UnitDefinition() {
        return getInternalElementReference().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsModelNamespace() {
        return getInternalElementReference().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsPackage() {
        return getInternalElementReference().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsProfile() {
        return getInternalElementReference().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsPackageableElement() {
        return getInternalElementReference().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsClassifier() {
        return getInternalElementReference().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsAbstractClassifier() {
        return getInternalElementReference().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsAssociation() {
        return getInternalElementReference().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsDataType() {
        return getInternalElementReference().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsClass() {
        return getInternalElementReference().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsActiveClass() {
        return getInternalElementReference().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsSignal() {
        return getInternalElementReference().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsEnumeration() {
        return getInternalElementReference().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsBehavior() {
        return getInternalElementReference().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsActivity() {
        return getInternalElementReference().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsMethod() {
        return getInternalElementReference().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsReception() {
        return getInternalElementReference().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsPrimitiveType() {
        return getInternalElementReference().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsOperation() {
        return getInternalElementReference().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsConstructor() {
        return getInternalElementReference().getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsDestructor() {
        return getInternalElementReference().getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsFeature() {
        return getInternalElementReference().getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsProperty() {
        return getInternalElementReference().getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsAssociationEnd() {
        return getInternalElementReference().getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsParameter() {
        return getInternalElementReference().getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsTemplate() {
        return getInternalElementReference().getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsTemplateParameter() {
        return getInternalElementReference().getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsClassifierTemplateParameter() {
        return getInternalElementReference().getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsParameteredElement() {
        return getInternalElementReference().getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsTemplateBinding() {
        return getInternalElementReference().getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsEnumerationLiteral() {
        return getInternalElementReference().getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsLoopVariable() {
        return getInternalElementReference().getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsAnnotation() {
        return getInternalElementReference().getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsSequenceExpansionExpression() {
        return getInternalElementReference().getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsAnyType() {
        return getInternalElementReference().getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsStereotype() {
        return getInternalElementReference().getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Name() {
        return getInternalElementReference().getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Visibility() {
        return getInternalElementReference().getEOperations().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__OwnedMembers() {
        return getInternalElementReference().getEOperations().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Members() {
        return getInternalElementReference().getEOperations().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__NestedClassifiers() {
        return getInternalElementReference().getEOperations().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Opposite() {
        return getInternalElementReference().getEOperations().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Signal() {
        return getInternalElementReference().getEOperations().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Parameters() {
        return getInternalElementReference().getEOperations().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ReturnParameter() {
        return getInternalElementReference().getEOperations().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Specification() {
        return getInternalElementReference().getEOperations().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__RedefinedOperaions() {
        return getInternalElementReference().getEOperations().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Namespace() {
        return getInternalElementReference().getEOperations().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Template() {
        return getInternalElementReference().getEOperations().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__TemplateParameters() {
        return getInternalElementReference().getEOperations().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ParameteredElements() {
        return getInternalElementReference().getEOperations().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__TemplateActuals() {
        return getInternalElementReference().getEOperations().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Direction() {
        return getInternalElementReference().getEOperations().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Association() {
        return getInternalElementReference().getEOperations().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Type() {
        return getInternalElementReference().getEOperations().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Lower() {
        return getInternalElementReference().getEOperations().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Upper() {
        return getInternalElementReference().getEOperations().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsOrdered() {
        return getInternalElementReference().getEOperations().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__IsNonunique() {
        return getInternalElementReference().getEOperations().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Parents() {
        return getInternalElementReference().getEOperations().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__AllParents() {
        return getInternalElementReference().getEOperations().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ClassifierBehavior() {
        return getInternalElementReference().getEOperations().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__AppliedProfiles() {
        return getInternalElementReference().getEOperations().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ActiveClass() {
        return getInternalElementReference().getEOperations().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Context() {
        return getInternalElementReference().getEOperations().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ConformsTo__ElementReference() {
        return getInternalElementReference().getEOperations().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Equals__ElementReference() {
        return getInternalElementReference().getEOperations().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Copy() {
        return getInternalElementReference().getEOperations().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ModelScope() {
        return getInternalElementReference().getEOperations().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ResolvePathName__String() {
        return getInternalElementReference().getEOperations().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ResolveInScope__String() {
        return getInternalElementReference().getEOperations().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__ResolveStereotypeName__String() {
        return getInternalElementReference().getEOperations().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__Stub() {
        return getInternalElementReference().getEOperations().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInternalElementReference__StubFor__UnitDefinition() {
        return getInternalElementReference().getEOperations().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalElementReference() {
		if (externalElementReferenceEClass == null) {
			externalElementReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(4);
		}
		return externalElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalElementReference_Element() {
        return (EReference)getExternalElementReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalElementReference_Alias() {
        return (EAttribute)getExternalElementReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsUml() {
        return getExternalElementReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__AsUml() {
        return getExternalElementReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__AsMember() {
        return getExternalElementReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsSameKindAs__ElementReference() {
        return getExternalElementReference().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsNamedElement() {
        return getExternalElementReference().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsNamespace() {
        return getExternalElementReference().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsNamespaceFor__UnitDefinition() {
        return getExternalElementReference().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsModelNamespace() {
        return getExternalElementReference().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsPackage() {
        return getExternalElementReference().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsProfile() {
        return getExternalElementReference().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsPackageableElement() {
        return getExternalElementReference().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsClassifier() {
        return getExternalElementReference().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsAbstractClassifier() {
        return getExternalElementReference().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsAssociation() {
        return getExternalElementReference().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsDataType() {
        return getExternalElementReference().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsClass() {
        return getExternalElementReference().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsActiveClass() {
        return getExternalElementReference().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsSignal() {
        return getExternalElementReference().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsEnumeration() {
        return getExternalElementReference().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsBehavior() {
        return getExternalElementReference().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsActivity() {
        return getExternalElementReference().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsMethod() {
        return getExternalElementReference().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsReception() {
        return getExternalElementReference().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsPrimitiveType() {
        return getExternalElementReference().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsOperation() {
        return getExternalElementReference().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsConstructor() {
        return getExternalElementReference().getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsDestructor() {
        return getExternalElementReference().getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsFeature() {
        return getExternalElementReference().getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsProperty() {
        return getExternalElementReference().getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsAssociationEnd() {
        return getExternalElementReference().getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsParameter() {
        return getExternalElementReference().getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsTemplate() {
        return getExternalElementReference().getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsTemplateParameter() {
        return getExternalElementReference().getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsClassifierTemplateParameter() {
        return getExternalElementReference().getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsParameteredElement() {
        return getExternalElementReference().getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsTemplateBinding() {
        return getExternalElementReference().getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsStereotype() {
        return getExternalElementReference().getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsEnumerationLiteral() {
        return getExternalElementReference().getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsLoopVariable() {
        return getExternalElementReference().getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsAnnotation() {
        return getExternalElementReference().getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsSequenceExpansionExpression() {
        return getExternalElementReference().getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Name() {
        return getExternalElementReference().getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Visibility() {
        return getExternalElementReference().getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__OwnedMembers() {
        return getExternalElementReference().getEOperations().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__EnumerationMembers() {
        return getExternalElementReference().getEOperations().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Members() {
        return getExternalElementReference().getEOperations().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__AdditionalMembers() {
        return getExternalElementReference().getEOperations().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Inherit__EList() {
        return getExternalElementReference().getEOperations().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__NestedClassifiers() {
        return getExternalElementReference().getEOperations().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Properties() {
        return getExternalElementReference().getEOperations().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__AssociationEnds() {
        return getExternalElementReference().getEOperations().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Opposite() {
        return getExternalElementReference().getEOperations().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Signal() {
        return getExternalElementReference().getEOperations().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Namespace() {
        return getExternalElementReference().getEOperations().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__OwnedParameters() {
        return getExternalElementReference().getEOperations().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Parameters() {
        return getExternalElementReference().getEOperations().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ReturnParameter() {
        return getExternalElementReference().getEOperations().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Specification() {
        return getExternalElementReference().getEOperations().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__RedefinedOperations() {
        return getExternalElementReference().getEOperations().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Template() {
        return getExternalElementReference().getEOperations().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__UmlTemplateBinding() {
        return getExternalElementReference().getEOperations().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__TemplateParameters() {
        return getExternalElementReference().getEOperations().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ParameteredElements() {
        return getExternalElementReference().getEOperations().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__TemplateActuals() {
        return getExternalElementReference().getEOperations().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Direction() {
        return getExternalElementReference().getEOperations().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Association() {
        return getExternalElementReference().getEOperations().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Type() {
        return getExternalElementReference().getEOperations().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Lower() {
        return getExternalElementReference().getEOperations().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Upper() {
        return getExternalElementReference().getEOperations().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsOrdered() {
        return getExternalElementReference().getEOperations().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__IsNonunique() {
        return getExternalElementReference().getEOperations().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Parents() {
        return getExternalElementReference().getEOperations().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__AllParents() {
        return getExternalElementReference().getEOperations().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ClassifierBehavior() {
        return getExternalElementReference().getEOperations().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__AppliedProfiles() {
        return getExternalElementReference().getEOperations().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ActiveClass() {
        return getExternalElementReference().getEOperations().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Context() {
        return getExternalElementReference().getEOperations().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ConformsTo__ElementReference() {
        return getExternalElementReference().getEOperations().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Equals__ElementReference() {
        return getExternalElementReference().getEOperations().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Copy() {
        return getExternalElementReference().getEOperations().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ModelScope() {
        return getExternalElementReference().getEOperations().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ResolvePathName__String() {
        return getExternalElementReference().getEOperations().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ExternalElementReference_resolvePathName__String() {
        return getExternalElementReference().getEOperations().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ResolveInScope__String() {
        return getExternalElementReference().getEOperations().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__ResolveStereotype__String() {
        return getExternalElementReference().getEOperations().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__Stub() {
        return getExternalElementReference().getEOperations().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalElementReference__StubFor__UnitDefinition() {
        return getExternalElementReference().getEOperations().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalEnumerationLiteralReference() {
		if (externalEnumerationLiteralReferenceEClass == null) {
			externalEnumerationLiteralReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(5);
		}
		return externalEnumerationLiteralReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalEnumerationLiteralReference__IsNamedEement() {
        return getExternalEnumerationLiteralReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalEnumerationLiteralReference__IsClassifier() {
        return getExternalEnumerationLiteralReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalEnumerationLiteralReference__IsParameter() {
        return getExternalEnumerationLiteralReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalEnumerationLiteralReference__IsEnumerationLiteral() {
        return getExternalEnumerationLiteralReference().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalEnumerationLiteralReference__ExternalEnumerationLiteralReference_visibility() {
        return getExternalEnumerationLiteralReference().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalEnumerationLiteralReference__Visibility() {
        return getExternalEnumerationLiteralReference().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalEnumerationLiteralReference__ExternalEnumerationLiteralReference_type() {
        return getExternalEnumerationLiteralReference().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalEnumerationLiteralReference__Type() {
        return getExternalEnumerationLiteralReference().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundElementReference() {
		if (boundElementReferenceEClass == null) {
			boundElementReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(6);
		}
		return boundElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundElementReference_Referent() {
        return (EReference)getBoundElementReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundElementReference_Namespace() {
        return (EReference)getBoundElementReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundElementReference_TemplateBinding() {
        return (EReference)getBoundElementReference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsUml() {
        return getBoundElementReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsAlf() {
        return getBoundElementReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__AsUml() {
        return getBoundElementReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__AsAlf() {
        return getBoundElementReference().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__AsMember() {
        return getBoundElementReference().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsSameKindAs__ElementReference() {
        return getBoundElementReference().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsNamedElement() {
        return getBoundElementReference().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsNamespace() {
        return getBoundElementReference().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsNamespaceFor__UnitDefinition() {
        return getBoundElementReference().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsModelNamespace() {
        return getBoundElementReference().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsPackage() {
        return getBoundElementReference().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsProfile() {
        return getBoundElementReference().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsPackageableElement() {
        return getBoundElementReference().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsClassifier() {
        return getBoundElementReference().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsAbstractClassifier() {
        return getBoundElementReference().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsAssociation() {
        return getBoundElementReference().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsDataType() {
        return getBoundElementReference().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsClass() {
        return getBoundElementReference().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsActiveClass() {
        return getBoundElementReference().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsSignal() {
        return getBoundElementReference().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsEnumeration() {
        return getBoundElementReference().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsBehavior() {
        return getBoundElementReference().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsActivity() {
        return getBoundElementReference().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsMethod() {
        return getBoundElementReference().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsPrimitiveType() {
        return getBoundElementReference().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsReception() {
        return getBoundElementReference().getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsOperation() {
        return getBoundElementReference().getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsConstructor() {
        return getBoundElementReference().getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsDestructor() {
        return getBoundElementReference().getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsFeature() {
        return getBoundElementReference().getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsProperty() {
        return getBoundElementReference().getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsAssociationEnd() {
        return getBoundElementReference().getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsParameter() {
        return getBoundElementReference().getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsTemplate() {
        return getBoundElementReference().getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsTemplateParameter() {
        return getBoundElementReference().getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsClassifierTemplateParameter() {
        return getBoundElementReference().getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsParameteredElement() {
        return getBoundElementReference().getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsStereotype() {
        return getBoundElementReference().getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsEnumerationLiteral() {
        return getBoundElementReference().getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsLoopVariable() {
        return getBoundElementReference().getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsAnnotation() {
        return getBoundElementReference().getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsSequenceExpansionExpression() {
        return getBoundElementReference().getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsDistinguishableFrom__ElementReference() {
        return getBoundElementReference().getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Name() {
        return getBoundElementReference().getEOperations().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Visibility() {
        return getBoundElementReference().getEOperations().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__OwnedMembers() {
        return getBoundElementReference().getEOperations().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Members() {
        return getBoundElementReference().getEOperations().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__NestedClassifiers() {
        return getBoundElementReference().getEOperations().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Properties() {
        return getBoundElementReference().getEOperations().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__AssociationEnds() {
        return getBoundElementReference().getEOperations().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Opposite() {
        return getBoundElementReference().getEOperations().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Signal() {
        return getBoundElementReference().getEOperations().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Parameters() {
        return getBoundElementReference().getEOperations().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ReturnParameter() {
        return getBoundElementReference().getEOperations().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Specification() {
        return getBoundElementReference().getEOperations().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__RedefinedOperations() {
        return getBoundElementReference().getEOperations().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Namespace() {
        return getBoundElementReference().getEOperations().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Template() {
        return getBoundElementReference().getEOperations().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__TemplateParameters() {
        return getBoundElementReference().getEOperations().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ParameteredElements() {
        return getBoundElementReference().getEOperations().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsTemplateBinding() {
        return getBoundElementReference().getEOperations().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__TemplateActuals() {
        return getBoundElementReference().getEOperations().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Direction() {
        return getBoundElementReference().getEOperations().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Association() {
        return getBoundElementReference().getEOperations().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Type() {
        return getBoundElementReference().getEOperations().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Lower() {
        return getBoundElementReference().getEOperations().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Upper() {
        return getBoundElementReference().getEOperations().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsOrdered() {
        return getBoundElementReference().getEOperations().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsNonunique() {
        return getBoundElementReference().getEOperations().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Parents() {
        return getBoundElementReference().getEOperations().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__AllParents() {
        return getBoundElementReference().getEOperations().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ClassifierBehavior() {
        return getBoundElementReference().getEOperations().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__AppliedProfiles() {
        return getBoundElementReference().getEOperations().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Reference() {
        return getBoundElementReference().getEOperations().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__TemplateBinding() {
        return getBoundElementReference().getEOperations().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ActiveClass() {
        return getBoundElementReference().getEOperations().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Context() {
        return getBoundElementReference().getEOperations().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__IsActiveBehavior() {
        return getBoundElementReference().getEOperations().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ConformsTo__ElementReference() {
        return getBoundElementReference().getEOperations().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Equals__ElementReference() {
        return getBoundElementReference().getEOperations().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Copy() {
        return getBoundElementReference().getEOperations().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ModelScope() {
        return getBoundElementReference().getEOperations().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ResolvePathName__String() {
        return getBoundElementReference().getEOperations().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ResolveInScope__String() {
        return getBoundElementReference().getEOperations().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__ResolveStereotype__String() {
        return getBoundElementReference().getEOperations().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__Stub() {
        return getBoundElementReference().getEOperations().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__StubFor__UnitDefinition() {
        return getBoundElementReference().getEOperations().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__BoundReferenceTo__ElementReference() {
        return getBoundElementReference().getEOperations().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__BoundReferenceTo1__ElementReference() {
        return getBoundElementReference().getEOperations().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundElementReference__BoundReferencesTo__EList() {
        return getBoundElementReference().getEOperations().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentedElement() {
		if (documentedElementEClass == null) {
			documentedElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(7);
		}
		return documentedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentedElement_Documentation() {
        return (EAttribute)getDocumentedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceExpansionExpression() {
		if (sequenceExpansionExpressionEClass == null) {
			sequenceExpansionExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(8);
		}
		return sequenceExpansionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceExpansionExpression_Operation() {
        return (EAttribute)getSequenceExpansionExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceExpansionExpression_Variable() {
        return (EAttribute)getSequenceExpansionExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceExpansionExpression_VariableSource() {
        return (EReference)getSequenceExpansionExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceExpansionExpression_Argument() {
        return (EReference)getSequenceExpansionExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceExpansionExpression_Primary() {
        return (EReference)getSequenceExpansionExpression().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceExpansionExpression_IsSelectOrReject() {
        return (EAttribute)getSequenceExpansionExpression().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceExpansionExpression_IsCollectOrIterate() {
        return (EAttribute)getSequenceExpansionExpression().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceExpansionExpression_IsForAllOrExistsOrOne() {
        return (EAttribute)getSequenceExpansionExpression().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceExpansionExpression_IsIsUnique() {
        return (EAttribute)getSequenceExpansionExpression().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__AssignmentsBefore__SyntaxElement() {
        return getSequenceExpansionExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__AssignmentsAfterPrimary() {
        return getSequenceExpansionExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__Type() {
        return getSequenceExpansionExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__Lower() {
        return getSequenceExpansionExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__Upper() {
        return getSequenceExpansionExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SequenceExpansionExpressionVariableSourceDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SequenceExpansionExpressionAssignmentsBeforePrimary__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SequenceExpansionExpressionAssignmentsBeforeArgument__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SequenceExpansionExpressionVariableName__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SequenceExpansionExpressionAssignmentsAfterArgument__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SelectOrRejectExpressionTypeDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SelectOrRejectExpressionLowerDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SelectOrRejectExpressionUpperDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SelectOrRejectExpressionArgument__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__CollectOrIterateExpressionTypeDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__CollectOrIterateExpressionLowerDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__CollectOrIterateExpressionUpperDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__ForAllOrExistsOrOneExpressionTypeDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__ForAllOrExistsOrOneExpressionLowerDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__ForAllOrExistsOrOneExpressionUpperDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__ForAllOrExistsOrOneExpressionArgument__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__IsUniqueExpressionTypeDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__IsUniqueExpressionLowerDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__IsUniqueExpressionUpperDerivation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__IsUniqueExpressionExpressionArgument__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__UpdateAssignments() {
        return getSequenceExpansionExpression().getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpansionExpression__SequenceExpansionExpressionOperation__DiagnosticChain_Map() {
        return getSequenceExpansionExpression().getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignableElement() {
		if (assignableElementEClass == null) {
			assignableElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(9);
		}
		return assignableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignableElement_Upper() {
        return (EAttribute)getAssignableElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignableElement_Lower() {
        return (EAttribute)getAssignableElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignableElement_Type() {
        return (EReference)getAssignableElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__TypeCached() {
        return getAssignableElement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__Type() {
        return getAssignableElement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__Lower() {
        return getAssignableElement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__Upper() {
        return getAssignableElement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__IsNull() {
        return getAssignableElement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__IsAssignableFromElement__ElementReference() {
        return getAssignableElement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__IsAssignableFrom__AssignableElement() {
        return getAssignableElement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__IsTypeConformantWith__AssignableElement() {
        return getAssignableElement().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__IsConformantWithType__ElementReference() {
        return getAssignableElement().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElement__IsMultiplicityConformantWith__AssignableElement() {
        return getAssignableElement().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignableElementReference() {
		if (assignableElementReferenceEClass == null) {
			assignableElementReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(10);
		}
		return assignableElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignableElementReference_Reference() {
        return (EReference)getAssignableElementReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElementReference__Type() {
        return getAssignableElementReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElementReference__Lower() {
        return getAssignableElementReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableElementReference__Upper() {
        return getAssignableElementReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		if (expressionEClass == null) {
			expressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(11);
		}
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_AssignmentBefore() {
        return (EReference)getExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_AssignmentAfter() {
        return (EReference)getExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__Reference() {
        return getExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__NewAssignments() {
        return getExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__ExpressionAssignmentAfterDerivation__DiagnosticChain_Map() {
        return getExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__ExpressionUniqueAssignments__DiagnosticChain_Map() {
        return getExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionReference() {
		if (expressionReferenceEClass == null) {
			expressionReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(12);
		}
		return expressionReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionReference_Expression() {
        return (EReference)getExpressionReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionReference__Type() {
        return getExpressionReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionReference__Lower() {
        return getExpressionReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionReference__Upper() {
        return getExpressionReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionReference__IsAddTarget__Expression() {
        return getExpressionReference().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionReference__AssignmentsBefore() {
        return getExpressionReference().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionReference__UpdateAssignments() {
        return getExpressionReference().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__UpdateAssignments() {
        return getExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__Expression_updateAssignments() {
        return getExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__UpdateAssignmentsCached() {
        return getExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__Resolve__String() {
        return getExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpression__IsAddTarget__Expression() {
        return getExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtentOrExpression() {
		if (extentOrExpressionEClass == null) {
			extentOrExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(13);
		}
		return extentOrExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtentOrExpression_Name() {
        return (EReference)getExtentOrExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtentOrExpression_Expression() {
        return (EReference)getExtentOrExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtentOrExpression_NonNameExpression() {
        return (EReference)getExtentOrExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtentOrExpression__IsAddTarget__Expression() {
        return getExtentOrExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtentOrExpression__ExtentOrExpressionExpressionDerivation__DiagnosticChain_Map() {
        return getExtentOrExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtentOrExpression__ExtentOrExpressionExtentType__DiagnosticChain_Map() {
        return getExtentOrExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtentOrExpression__ExtentOrExpressionResolution__DiagnosticChain_Map() {
        return getExtentOrExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedName() {
		if (qualifiedNameEClass == null) {
			qualifiedNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(14);
		}
		return qualifiedNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedName_IsAmbiguous() {
        return (EAttribute)getQualifiedName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedName_PathName() {
        return (EAttribute)getQualifiedName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedName_IsFeatureReference() {
        return (EAttribute)getQualifiedName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedName_Qualification() {
        return (EReference)getQualifiedName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedName_Disambiguation() {
        return (EReference)getQualifiedName().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedName_NameBinding() {
        return (EReference)getQualifiedName().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedName_Referent() {
        return (EReference)getQualifiedName().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedName_UnqualifiedName() {
        return (EReference)getQualifiedName().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedName_TemplateName() {
        return (EReference)getQualifiedName().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__Copy() {
        return getQualifiedName().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__AddName__String() {
        return getQualifiedName().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__AddNameBindings__EList() {
        return getQualifiedName().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__ModelReferents() {
        return getQualifiedName().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameUnqualifiedNameDerivation__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNamePathNameDerivation__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameIsFeatureReferenceDerivation__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameQualificationDerivation__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameDisambiguationDerivation__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameReferentDerivation__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameLocalName__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameNonLocalUnqualifiedName__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameQualifiedResolution__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameTemplateBinding__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__QualifiedNameTemplateNameDerivation__DiagnosticChain_Map() {
        return getQualifiedName().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__DisambiguationCached() {
        return getQualifiedName().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__Disambiguation() {
        return getQualifiedName().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__ReferentCached() {
        return getQualifiedName().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedName__Referent() {
        return getQualifiedName().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureReference() {
		if (featureReferenceEClass == null) {
			featureReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(15);
		}
		return featureReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureReference_Expression() {
        return (EReference)getFeatureReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureReference_Referent() {
        return (EReference)getFeatureReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureReference_NameBinding() {
        return (EReference)getFeatureReference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureReference__UpdateAssignments() {
        return getFeatureReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureReference__BehavioralFeatureReferent__InvocationExpression() {
        return getFeatureReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureReference__FeatureReferenceReferentDerivation__DiagnosticChain_Map() {
        return getFeatureReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureReference__FeatureReferenceTargetType__DiagnosticChain_Map() {
        return getFeatureReference().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureReference__ReferentCached() {
        return getFeatureReference().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureReference__Referent() {
        return getFeatureReference().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureReference__FeatureReference_referent() {
        return getFeatureReference().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameBinding() {
		if (nameBindingEClass == null) {
			nameBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(16);
		}
		return nameBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameBinding_Binding() {
        return (EReference)getNameBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameBinding_Name() {
        return (EAttribute)getNameBinding().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameBinding__ToString() {
        return getNameBinding().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameBinding__ToName() {
        return getNameBinding().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameBinding__Process__String() {
        return getNameBinding().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameBinding__Escape__String() {
        return getNameBinding().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameBinding__Copy() {
        return getNameBinding().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameBinding__ToQualifiedName__SyntaxElement() {
        return getNameBinding().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameBinding__ToQualifiedNameWith__NameBinding_SyntaxElement() {
        return getNameBinding().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateBinding() {
		if (templateBindingEClass == null) {
			templateBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(17);
		}
		return templateBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTemplateBinding__ToString() {
        return getTemplateBinding().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTemplateBinding__Matches__ElementReference() {
        return getTemplateBinding().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTemplateBinding__Copy() {
        return getTemplateBinding().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTemplateBinding__BindTo__ElementReference() {
        return getTemplateBinding().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedTemplateBinding() {
		if (namedTemplateBindingEClass == null) {
			namedTemplateBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(18);
		}
		return namedTemplateBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedTemplateBinding_Substitution() {
        return (EReference)getNamedTemplateBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTemplateBinding__ToString() {
        return getNamedTemplateBinding().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTemplateBinding__Matches__ElementReference() {
        return getNamedTemplateBinding().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTemplateBinding__MatchesParameter__ElementReference() {
        return getNamedTemplateBinding().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTemplateBinding__BindTo__ElementReference() {
        return getNamedTemplateBinding().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTemplateBinding__Copy() {
        return getNamedTemplateBinding().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameterSubstitution() {
		if (templateParameterSubstitutionEClass == null) {
			templateParameterSubstitutionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(19);
		}
		return templateParameterSubstitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateParameterSubstitution_ParameterName() {
        return (EAttribute)getTemplateParameterSubstitution().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterSubstitution_ArgumentName() {
        return (EReference)getTemplateParameterSubstitution().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterSubstitution_Referent() {
        return (EReference)getTemplateParameterSubstitution().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTemplateParameterSubstitution__ActualParameterName() {
        return getTemplateParameterSubstitution().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTemplateParameterSubstitution__ToString() {
        return getTemplateParameterSubstitution().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTemplateParameterSubstitution__Copy() {
        return getTemplateParameterSubstitution().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericUnaryExpression() {
		if (numericUnaryExpressionEClass == null) {
			numericUnaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(20);
		}
		return numericUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNumericUnaryExpression__Type() {
        return getNumericUnaryExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNumericUnaryExpression__Lower() {
        return getNumericUnaryExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNumericUnaryExpression__Upper() {
        return getNumericUnaryExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNumericUnaryExpression__NumericUnaryExpressionTypeDerivation__DiagnosticChain_Map() {
        return getNumericUnaryExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNumericUnaryExpression__NumericUnaryExpressionLowerDerivation__DiagnosticChain_Map() {
        return getNumericUnaryExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNumericUnaryExpression__NumericUnaryExpressionUpperDerivation__DiagnosticChain_Map() {
        return getNumericUnaryExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNumericUnaryExpression__NumericUnaryExpressionOperand__DiagnosticChain_Map() {
        return getNumericUnaryExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryExpression() {
		if (unaryExpressionEClass == null) {
			unaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(21);
		}
		return unaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnaryExpression_Operator() {
        return (EAttribute)getUnaryExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryExpression_Operand() {
        return (EReference)getUnaryExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnaryExpression__UnaryExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getUnaryExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnaryExpression__UpdateAssignments() {
        return getUnaryExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForAllOrExistsOrOneExpression() {
		if (forAllOrExistsOrOneExpressionEClass == null) {
			forAllOrExistsOrOneExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(22);
		}
		return forAllOrExistsOrOneExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForAllOrExistsOrOneExpression__ForAllOrExistsOrOneExpressionTypeDerivation__DiagnosticChain_Map() {
        return getForAllOrExistsOrOneExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForAllOrExistsOrOneExpression__ForAllOrExistsOrOneExpressionLowerDerivation__DiagnosticChain_Map() {
        return getForAllOrExistsOrOneExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForAllOrExistsOrOneExpression__ForAllOrExistsOrOneExpressionUpperDerivation__DiagnosticChain_Map() {
        return getForAllOrExistsOrOneExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForAllOrExistsOrOneExpression__ForAllOrExistsOrOneExpressionArgument__DiagnosticChain_Map() {
        return getForAllOrExistsOrOneExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsolationExpression() {
		if (isolationExpressionEClass == null) {
			isolationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(23);
		}
		return isolationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsolationExpression__Type() {
        return getIsolationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsolationExpression__Lower() {
        return getIsolationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsolationExpression__Upper() {
        return getIsolationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsolationExpression__IsolationExpressionTypeDerivation__DiagnosticChain_Map() {
        return getIsolationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsolationExpression__IsolationExpressionLowerDerivation__DiagnosticChain_Map() {
        return getIsolationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsolationExpression__IsolationExpressionUpperDerivation__DiagnosticChain_Map() {
        return getIsolationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryExpression() {
		if (binaryExpressionEClass == null) {
			binaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(24);
		}
		return binaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpression_Operand1() {
        return (EReference)getBinaryExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpression_Operand2() {
        return (EReference)getBinaryExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryExpression_Operator() {
        return (EAttribute)getBinaryExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryExpression__BinaryExpressionOperandMultiplicity__DiagnosticChain_Map() {
        return getBinaryExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryExpression__BinaryExpressionOperandAssignments__DiagnosticChain_Map() {
        return getBinaryExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryExpression__UpdateAssignments() {
        return getBinaryExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryExpression__ValidateAssignments() {
        return getBinaryExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryExpression__NoNullArguments() {
        return getBinaryExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanUnaryExpression() {
		if (booleanUnaryExpressionEClass == null) {
			booleanUnaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(25);
		}
		return booleanUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanUnaryExpression__Type() {
        return getBooleanUnaryExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanUnaryExpression__Lower() {
        return getBooleanUnaryExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanUnaryExpression__Upper() {
        return getBooleanUnaryExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanUnaryExpression__BooleanUnaryExpressionTypeDerivation__DiagnosticChain_Map() {
        return getBooleanUnaryExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanUnaryExpression__BooleanUnaryExpressionLowerDerivation__DiagnosticChain_Map() {
        return getBooleanUnaryExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanUnaryExpression__BooleanUnaryExpressionUpperDerivation__DiagnosticChain_Map() {
        return getBooleanUnaryExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanUnaryExpression__BooleanUnaryExpressionOperand__DiagnosticChain_Map() {
        return getBooleanUnaryExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCastExpression() {
		if (castExpressionEClass == null) {
			castExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(26);
		}
		return castExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCastExpression_Operand() {
        return (EReference)getCastExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCastExpression_TypeName() {
        return (EReference)getCastExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCastExpression_IsAny() {
        return (EAttribute)getCastExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__Type() {
        return getCastExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__Lower() {
        return getCastExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__Upper() {
        return getCastExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__CastExpressionTypeDerivation__DiagnosticChain_Map() {
        return getCastExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__CastExpressionLowerDerivation__DiagnosticChain_Map() {
        return getCastExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__CastExpressionUpperDerivation__DiagnosticChain_Map() {
        return getCastExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__CastExpressionTypeResolution__DiagnosticChain_Map() {
        return getCastExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__CastExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getCastExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCastExpression__UpdateAssignments() {
        return getCastExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPositionalTuple() {
		if (positionalTupleEClass == null) {
			positionalTupleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(27);
		}
		return positionalTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPositionalTuple_Expression() {
        return (EReference)getPositionalTuple().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTuple__Size() {
        return getPositionalTuple().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTuple__InputFor__EList() {
        return getPositionalTuple().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTuple__OutputFor__EList() {
        return getPositionalTuple().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTuple__OutputForExpression__Expression() {
        return getPositionalTuple().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTuple__PositionalTupleArguments__DiagnosticChain_Map() {
        return getPositionalTuple().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTuple() {
		if (tupleEClass == null) {
			tupleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(28);
		}
		return tupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTuple_Input() {
        return (EReference)getTuple().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTuple_Invocation() {
        return (EReference)getTuple().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTuple_Output() {
        return (EReference)getTuple().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__Size() {
        return getTuple().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__InputCached() {
        return getTuple().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__Input() {
        return getTuple().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__InputFor__EList() {
        return getTuple().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__OutputCached() {
        return getTuple().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__Output() {
        return getTuple().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__OutputFor__EList() {
        return getTuple().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__OutputForExpression__Expression() {
        return getTuple().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__AssignmentsBefore__SyntaxElement() {
        return getTuple().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__AssignmentsAfter() {
        return getTuple().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__NewAssignments() {
        return getTuple().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__UpdateFor__EList_OutputNamedExpression() {
        return getTuple().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__TupleInputDerivation__DiagnosticChain_Map() {
        return getTuple().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__TupleOutputDerivation__DiagnosticChain_Map() {
        return getTuple().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__TupleNullInputs__DiagnosticChain_Map() {
        return getTuple().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__TupleOutputs__DiagnosticChain_Map() {
        return getTuple().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__TupleAssignmentsBefore__DiagnosticChain_Map() {
        return getTuple().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTuple__TupleAssignmentsAfter__DiagnosticChain_Map() {
        return getTuple().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedExpression() {
		if (namedExpressionEClass == null) {
			namedExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(29);
		}
		return namedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedExpression_Name() {
        return (EAttribute)getNamedExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedExpression_Expression() {
        return (EReference)getNamedExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedExpression_Index() {
        return (EReference)getNamedExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedExpression__ActualName() {
        return getNamedExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputNamedExpression() {
		if (inputNamedExpressionEClass == null) {
			inputNamedExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(30);
		}
		return inputNamedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputNamedExpression_Name() {
        return (EAttribute)getInputNamedExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputNamedExpression_Expression() {
        return (EReference)getInputNamedExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputNamedExpression_Index() {
        return (EReference)getInputNamedExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputNamedExpression_IsCollectionConversion() {
        return (EAttribute)getInputNamedExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputNamedExpression_IsBitStringConversion() {
        return (EAttribute)getInputNamedExpression().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInputNamedExpression__Tuple() {
        return getInputNamedExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInputNamedExpression__NamedExpressionIsCollectionConversionDerivation__DiagnosticChain_Map() {
        return getInputNamedExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInputNamedExpression__NamedExpressionIsBitStringConversionDerivation__DiagnosticChain_Map() {
        return getInputNamedExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvocationExpression() {
		if (invocationExpressionEClass == null) {
			invocationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(31);
		}
		return invocationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvocationExpression_IsBehavior() {
        return (EAttribute)getInvocationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvocationExpression_IsAssociationEnd() {
        return (EAttribute)getInvocationExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocationExpression_Feature() {
        return (EReference)getInvocationExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvocationExpression_IsOperation() {
        return (EAttribute)getInvocationExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvocationExpression_IsDestructor() {
        return (EAttribute)getInvocationExpression().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvocationExpression_IsImplicit() {
        return (EAttribute)getInvocationExpression().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocationExpression_Referent() {
        return (EReference)getInvocationExpression().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocationExpression_Parameter() {
        return (EReference)getInvocationExpression().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvocationExpression_IsSignal() {
        return (EAttribute)getInvocationExpression().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocationExpression_Tuple() {
        return (EReference)getInvocationExpression().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__AssignmentsBefore__SyntaxElement() {
        return getInvocationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__Feature() {
        return getInvocationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__Type() {
        return getInvocationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpression_type() {
        return getInvocationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__Upper() {
        return getInvocationExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpression_upper() {
        return getInvocationExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__Lower() {
        return getInvocationExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpression_lower() {
        return getInvocationExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__ParameterNamed__String() {
        return getInvocationExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__ParameterCount() {
        return getInvocationExpression().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__ParameterIsAssignableFrom__InputNamedExpression() {
        return getInvocationExpression().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__ParameterIsAssignableTo__OutputNamedExpression() {
        return getInvocationExpression().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__AlternativeConstructorIsValid() {
        return getInvocationExpression().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__BindTemplateImplicitArguments__ElementReference_Expression() {
        return getInvocationExpression().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__BindTemplateImplicitArguments1__ElementReference_Expression() {
        return getInvocationExpression().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__EffectiveType__ElementReference_Expression() {
        return getInvocationExpression().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionIsBehaviorDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionIsAssociationEndDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionIsOperationDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionIsDestructorDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionIsImplicitDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionIsSignalDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionParameterDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionTypeDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionUpperDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionLowerDerivation__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__UpdateAssignments() {
        return getInvocationExpression().getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpressionTemplateParameters__DiagnosticChain_Map() {
        return getInvocationExpression().getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__ParameterElements() {
        return getInvocationExpression().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__InvocationExpression_parameterElements() {
        return getInvocationExpression().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__ParameterFromProperty__ElementReference() {
        return getInvocationExpression().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__ParameterFromPropertyWithMultiplicity__ElementReference_String_String() {
        return getInvocationExpression().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__Referent() {
        return getInvocationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocationExpression__ReferentCached() {
        return getInvocationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputNamedExpression() {
		if (outputNamedExpressionEClass == null) {
			outputNamedExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(32);
		}
		return outputNamedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputNamedExpression_LeftHandSide() {
        return (EReference)getOutputNamedExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOutputNamedExpression__OutputNamedExpressionLeftHandSideDerivation__DiagnosticChain_Map() {
        return getOutputNamedExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOutputNamedExpression__OutputNamedExpressionForm__DiagnosticChain_Map() {
        return getOutputNamedExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOutputNamedExpression__HasLegalExpression() {
        return getOutputNamedExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLeftHandSide() {
		if (leftHandSideEClass == null) {
			leftHandSideEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(33);
		}
		return leftHandSideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLeftHandSide_AssignmentBefore() {
        return (EReference)getLeftHandSide().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLeftHandSide_AssignmentAfter() {
        return (EReference)getLeftHandSide().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLeftHandSide_Referent() {
        return (EReference)getLeftHandSide().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__AssignmentsBefore__SyntaxElement() {
        return getLeftHandSide().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__AssignmentsAfter() {
        return getLeftHandSide().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__Type() {
        return getLeftHandSide().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__LeftHandSide_type() {
        return getLeftHandSide().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__Upper() {
        return getLeftHandSide().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__LeftHandSide_upper() {
        return getLeftHandSide().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__Lower() {
        return getLeftHandSide().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__LeftHandSide_lower() {
        return getLeftHandSide().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__Referent() {
        return getLeftHandSide().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__AssignedName() {
        return getLeftHandSide().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__LocalName() {
        return getLeftHandSide().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__Feature() {
        return getLeftHandSide().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__Expression() {
        return getLeftHandSide().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__IsDataValueUpdate() {
        return getLeftHandSide().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__LeftHandSideIndexExpression__DiagnosticChain_Map() {
        return getLeftHandSide().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLeftHandSide__Index() {
        return getLeftHandSide().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceAccessExpression() {
		if (sequenceAccessExpressionEClass == null) {
			sequenceAccessExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(34);
		}
		return sequenceAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceAccessExpression_Primary() {
        return (EReference)getSequenceAccessExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceAccessExpression_Index() {
        return (EReference)getSequenceAccessExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__Type() {
        return getSequenceAccessExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__Lower() {
        return getSequenceAccessExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__Upper() {
        return getSequenceAccessExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__UpdateAssignments() {
        return getSequenceAccessExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__SequenceAccessExpressionTypeDerivation__DiagnosticChain_Map() {
        return getSequenceAccessExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__SequenceAccessExpressionLowerDerivation__DiagnosticChain_Map() {
        return getSequenceAccessExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__SequenceAccessExpressionUpperDerivation__DiagnosticChain_Map() {
        return getSequenceAccessExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__SequenceAccessExpressionIndexType__DiagnosticChain_Map() {
        return getSequenceAccessExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceAccessExpression__SequenceAccessExpressionIndexMultiplicity__DiagnosticChain_Map() {
        return getSequenceAccessExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteralExpression() {
		if (stringLiteralExpressionEClass == null) {
			stringLiteralExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(35);
		}
		return stringLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteralExpression_Image() {
        return (EAttribute)getStringLiteralExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStringLiteralExpression__Type() {
        return getStringLiteralExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStringLiteralExpression__StringLiteralExpressionTypeDerivation__DiagnosticChain_Map() {
        return getStringLiteralExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteralExpression() {
		if (literalExpressionEClass == null) {
			literalExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(36);
		}
		return literalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLiteralExpression__Upper() {
        return getLiteralExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLiteralExpression__Lower() {
        return getLiteralExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLiteralExpression__LiteralExpressionUpperDerivation__DiagnosticChain_Map() {
        return getLiteralExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLiteralExpression__LiteralExpressionLowerDerivation__DiagnosticChain_Map() {
        return getLiteralExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceOperationExpression() {
		if (sequenceOperationExpressionEClass == null) {
			sequenceOperationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(37);
		}
		return sequenceOperationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceOperationExpression_Primary() {
        return (EReference)getSequenceOperationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceOperationExpression_Operation() {
        return (EReference)getSequenceOperationExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceOperationExpression_IsCollectionConversion() {
        return (EAttribute)getSequenceOperationExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceOperationExpression_IsBitStringConversion() {
        return (EAttribute)getSequenceOperationExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceOperationExpression_LeftHandSide() {
        return (EReference)getSequenceOperationExpression().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__Feature() {
        return getSequenceOperationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__Referent() {
        return getSequenceOperationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__IsAddTarget__Expression() {
        return getSequenceOperationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__FirstParameter() {
        return getSequenceOperationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__FirstArgument() {
        return getSequenceOperationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionReferentDerivation__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionOperationReferent__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionTargetCompatibility__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionArgumentCompatibility__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionIsCollectionConversionDerivation__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionIsBitStringConversionDerivation__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionAssignmentsAfter__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__SequenceOperationExpressionLeftHandSideDerivation__DiagnosticChain_Map() {
        return getSequenceOperationExpression().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__UpdateAssignments() {
        return getSequenceOperationExpression().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceOperationExpression__ParameterElements() {
        return getSequenceOperationExpression().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectOrRejectExpression() {
		if (selectOrRejectExpressionEClass == null) {
			selectOrRejectExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(38);
		}
		return selectOrRejectExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSelectOrRejectExpression__SelectOrRejectExpressionTypeDerivation__DiagnosticChain_Map() {
        return getSelectOrRejectExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSelectOrRejectExpression__SelectOrRejectExpressionLowerDerivation__DiagnosticChain_Map() {
        return getSelectOrRejectExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSelectOrRejectExpression__SelectOrRejectExpressionUpperDerivation__DiagnosticChain_Map() {
        return getSelectOrRejectExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSelectOrRejectExpression__SelectOrRejectExpressionArgument__DiagnosticChain_Map() {
        return getSelectOrRejectExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassExtentExpression() {
		if (classExtentExpressionEClass == null) {
			classExtentExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(39);
		}
		return classExtentExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassExtentExpression_ClassName() {
        return (EReference)getClassExtentExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassExtentExpression__Type() {
        return getClassExtentExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassExtentExpression__Upper() {
        return getClassExtentExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassExtentExpression__Lower() {
        return getClassExtentExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassExtentExpression__ClassExtentExpressionTypeDerivation__DiagnosticChain_Map() {
        return getClassExtentExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassExtentExpression__ClassExtentExpressionUpperDerivation__DiagnosticChain_Map() {
        return getClassExtentExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassExtentExpression__ClassExtentExpressionLowerDerivation__DiagnosticChain_Map() {
        return getClassExtentExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassExtentExpression__ClassExtentExpressionExtentType__DiagnosticChain_Map() {
        return getClassExtentExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassExtentExpression__ValidateClassExtentExpressionExtentType() {
        return getClassExtentExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPositionalTemplateBinding() {
		if (positionalTemplateBindingEClass == null) {
			positionalTemplateBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(40);
		}
		return positionalTemplateBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPositionalTemplateBinding_ArgumentName() {
        return (EReference)getPositionalTemplateBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTemplateBinding__ToString() {
        return getPositionalTemplateBinding().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTemplateBinding__Matches__ElementReference() {
        return getPositionalTemplateBinding().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTemplateBinding__Matches__ElementReference_QualifiedName() {
        return getPositionalTemplateBinding().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTemplateBinding__BindTo__ElementReference() {
        return getPositionalTemplateBinding().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPositionalTemplateBinding__Copy() {
        return getPositionalTemplateBinding().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalLogicalExpression() {
		if (conditionalLogicalExpressionEClass == null) {
			conditionalLogicalExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(41);
		}
		return conditionalLogicalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__Type() {
        return getConditionalLogicalExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__Lower() {
        return getConditionalLogicalExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__Upper() {
        return getConditionalLogicalExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__ConditionalLogicalExpressionTypeDerivation__DiagnosticChain_Map() {
        return getConditionalLogicalExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__ConditionalLogicalExpressionLower__DiagnosticChain_Map() {
        return getConditionalLogicalExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__ConditionalLogicalExpressionUpper__DiagnosticChain_Map() {
        return getConditionalLogicalExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__ConditionalLogicalExpressionOperands__DiagnosticChain_Map() {
        return getConditionalLogicalExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__ValidateAssignments() {
        return getConditionalLogicalExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__AssignmentsBefore__SyntaxElement() {
        return getConditionalLogicalExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalLogicalExpression__UpdateAssignments() {
        return getConditionalLogicalExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkOperationExpression() {
		if (linkOperationExpressionEClass == null) {
			linkOperationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(42);
		}
		return linkOperationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkOperationExpression_Operation() {
        return (EAttribute)getLinkOperationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkOperationExpression_IsCreation() {
        return (EAttribute)getLinkOperationExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkOperationExpression_IsClear() {
        return (EAttribute)getLinkOperationExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkOperationExpression_AssociationName() {
        return (EReference)getLinkOperationExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__Referent() {
        return getLinkOperationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__Feature() {
        return getLinkOperationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__LinkOperationExpressionIsCreationDerivation__DiagnosticChain_Map() {
        return getLinkOperationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__LinkOperationExpressionIsClearDerivation__DiagnosticChain_Map() {
        return getLinkOperationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__LinkOperationExpressionReferentDerivation__DiagnosticChain_Map() {
        return getLinkOperationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__LinkOperationExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getLinkOperationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__LinkOperationExpressionAssociationReference__DiagnosticChain_Map() {
        return getLinkOperationExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__LinkOperationExpressionArgumentCompatibility__DiagnosticChain_Map() {
        return getLinkOperationExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkOperationExpression__ParameterElements() {
        return getLinkOperationExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualityExpression() {
		if (equalityExpressionEClass == null) {
			equalityExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(43);
		}
		return equalityExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEqualityExpression_IsNegated() {
        return (EAttribute)getEqualityExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEqualityExpression__Type() {
        return getEqualityExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEqualityExpression__Lower() {
        return getEqualityExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEqualityExpression__Upper() {
        return getEqualityExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEqualityExpression__EqualityExpressionIsNegatedDerivation__DiagnosticChain_Map() {
        return getEqualityExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEqualityExpression__EqualityExpressionTypeDerivation__DiagnosticChain_Map() {
        return getEqualityExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEqualityExpression__EqualityExpressionLowerDerivation__DiagnosticChain_Map() {
        return getEqualityExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEqualityExpression__EqualityExpressionUpperDerivation__DiagnosticChain_Map() {
        return getEqualityExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEqualityExpression__NoNullArguments() {
        return getEqualityExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignmentExpression() {
		if (assignmentExpressionEClass == null) {
			assignmentExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(44);
		}
		return assignmentExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_Operator() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentExpression_LeftHandSide() {
        return (EReference)getAssignmentExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentExpression_RightHandSide() {
        return (EReference)getAssignmentExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentExpression_Assignment() {
        return (EReference)getAssignmentExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentExpression_Feature() {
        return (EReference)getAssignmentExpression().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsIndexed() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsArithmetic() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsLogical() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsShift() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsConcatenation() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsDefinition() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsSimple() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentExpression_Expression() {
        return (EReference)getAssignmentExpression().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsFeature() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsDataValueUpdate() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsCollectionConversion() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_IsBitStringConversion() {
        return (EAttribute)getAssignmentExpression().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__Type() {
        return getAssignmentExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__Upper() {
        return getAssignmentExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__Lower() {
        return getAssignmentExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentsBefore__SyntaxElement() {
        return getAssignmentExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionIsSimpleDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionIsArithmeticDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionIsDefinitionDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionIsFeatureDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionIsIndexedDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionIsDataValueUpdateDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionAssignmentDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionExpressionDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionTypeDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionUpperDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionLowerDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionSimpleAssignmentTypeConformance__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionSimpleAssignmentMultiplicityConformance__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionCompoundAssignmentTypeConformance__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionCompoundAssignmentMultiplicityConformance__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionIsCollectionConversionDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionIsBitStringConversionDerivation__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__AssignmentExpressionDataValueUpdateLegality__DiagnosticChain_Map() {
        return getAssignmentExpression().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignmentExpression__UpdateAssignments() {
        return getAssignmentExpression().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalExpression() {
		if (logicalExpressionEClass == null) {
			logicalExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(45);
		}
		return logicalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicalExpression_IsBitWise() {
        return (EAttribute)getLogicalExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicalExpression_IsBitStringConversion1() {
        return (EAttribute)getLogicalExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicalExpression_IsBitStringConversion2() {
        return (EAttribute)getLogicalExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__Type() {
        return getLogicalExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__Lower() {
        return getLogicalExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__Upper() {
        return getLogicalExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__LogicalExpressionTypeDerivation__DiagnosticChain_Map() {
        return getLogicalExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__LogicalExpressionLowerDerivation__DiagnosticChain_Map() {
        return getLogicalExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__LogicalExpressionUpperDerivation__DiagnosticChain_Map() {
        return getLogicalExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__LogicalExpressionOperands__DiagnosticChain_Map() {
        return getLogicalExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__LogicalExpressionIsBitStringConversion1Derivation__DiagnosticChain_Map() {
        return getLogicalExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__LogicalExpressionIsBitStringConversion2Derivation__DiagnosticChain_Map() {
        return getLogicalExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogicalExpression__LogicalExpressionIsBitWiseDerivation__DiagnosticChain_Map() {
        return getLogicalExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceConstructionExpression() {
		if (sequenceConstructionExpressionEClass == null) {
			sequenceConstructionExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(46);
		}
		return sequenceConstructionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceConstructionExpression_Elements() {
        return (EReference)getSequenceConstructionExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceConstructionExpression_HasMultiplicity() {
        return (EAttribute)getSequenceConstructionExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceConstructionExpression_TypeName() {
        return (EReference)getSequenceConstructionExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceConstructionExpression_IsAny() {
        return (EAttribute)getSequenceConstructionExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__CollectionType() {
        return getSequenceConstructionExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__Type() {
        return getSequenceConstructionExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__ConstructorReference() {
        return getSequenceConstructionExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__Upper() {
        return getSequenceConstructionExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__Lower() {
        return getSequenceConstructionExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__SequenceConstructionExpressionTypeDerivation__DiagnosticChain_Map() {
        return getSequenceConstructionExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__SequenceConstructionExpressionUpperDerivation__DiagnosticChain_Map() {
        return getSequenceConstructionExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__SequenceConstructionExpressionLowerDerivation__DiagnosticChain_Map() {
        return getSequenceConstructionExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__SequenceConstructionExpressionType__DiagnosticChain_Map() {
        return getSequenceConstructionExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__SequenceConstructionExpressionElementType__DiagnosticChain_Map() {
        return getSequenceConstructionExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__SequenceConstructionExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getSequenceConstructionExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceConstructionExpression__UpdateAssignments() {
        return getSequenceConstructionExpression().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceElements() {
		if (sequenceElementsEClass == null) {
			sequenceElementsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(47);
		}
		return sequenceElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceElements_Upper() {
        return (EAttribute)getSequenceElements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceElements_Lower() {
        return (EAttribute)getSequenceElements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceElements__ConformsTo__ElementReference() {
        return getSequenceElements().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceElements__AssignmentsAfter() {
        return getSequenceElements().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceElements__Upper() {
        return getSequenceElements().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceElements__Lower() {
        return getSequenceElements().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectOrIterateExpression() {
		if (collectOrIterateExpressionEClass == null) {
			collectOrIterateExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(48);
		}
		return collectOrIterateExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCollectOrIterateExpression__CollectOrIterateExpressionTypeDerivation__DiagnosticChain_Map() {
        return getCollectOrIterateExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCollectOrIterateExpression__CollectOrIterateExpressionLowerDerivation__DiagnosticChain_Map() {
        return getCollectOrIterateExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCollectOrIterateExpression__CollectOrIterateExpressionUpperDerivation__DiagnosticChain_Map() {
        return getCollectOrIterateExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsUniqueExpression() {
		if (isUniqueExpressionEClass == null) {
			isUniqueExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(49);
		}
		return isUniqueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsUniqueExpression__IsUniqueExpressionTypeDerivation__DiagnosticChain_Map() {
        return getIsUniqueExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsUniqueExpression__IsUniqueExpressionLowerDerivation__DiagnosticChain_Map() {
        return getIsUniqueExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsUniqueExpression__IsUniqueExpressionUpperDerivation__DiagnosticChain_Map() {
        return getIsUniqueExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIsUniqueExpression__IsUniqueExpressionExpressionArgument__DiagnosticChain_Map() {
        return getIsUniqueExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArithmeticExpression() {
		if (arithmeticExpressionEClass == null) {
			arithmeticExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(50);
		}
		return arithmeticExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArithmeticExpression_IsConcatenation() {
        return (EAttribute)getArithmeticExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArithmeticExpression__Type() {
        return getArithmeticExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArithmeticExpression__Lower() {
        return getArithmeticExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArithmeticExpression__Upper() {
        return getArithmeticExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArithmeticExpression__ArithmeticExpressionIsConcatenationDerivation__DiagnosticChain_Map() {
        return getArithmeticExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArithmeticExpression__ArithmeticExpressionTypeDerivation__DiagnosticChain_Map() {
        return getArithmeticExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArithmeticExpression__ArithmeticExpressionLowerDerivation__DiagnosticChain_Map() {
        return getArithmeticExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArithmeticExpression__ArithmeticExpressionUpperDerivation__DiagnosticChain_Map() {
        return getArithmeticExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArithmeticExpression__ArithmeticExpressionOperandTypes__DiagnosticChain_Map() {
        return getArithmeticExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureLeftHandSide() {
		if (featureLeftHandSideEClass == null) {
			featureLeftHandSideEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(51);
		}
		return featureLeftHandSideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureLeftHandSide_Expression() {
        return (EReference)getFeatureLeftHandSide().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__Referent() {
        return getFeatureLeftHandSide().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__Feature() {
        return getFeatureLeftHandSide().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__Expression() {
        return getFeatureLeftHandSide().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__Index() {
        return getFeatureLeftHandSide().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__LocalName() {
        return getFeatureLeftHandSide().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideAssignmentBeforeDerivation__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideAssignmentAfterDerivation__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideFeatureExpression__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideAssignmentsBefore__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideReferentDerivation__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideTypeDerivation__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideLowerDerivation__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideUpperDerivation__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideReferentConstraint__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureLeftHandSide__FeatureLeftHandSideIndexedFeature__DiagnosticChain_Map() {
        return getFeatureLeftHandSide().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalTestExpression() {
		if (conditionalTestExpressionEClass == null) {
			conditionalTestExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(52);
		}
		return conditionalTestExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalTestExpression_Operand1() {
        return (EReference)getConditionalTestExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalTestExpression_Operand2() {
        return (EReference)getConditionalTestExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalTestExpression_Operand3() {
        return (EReference)getConditionalTestExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__Type() {
        return getConditionalTestExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__Lower() {
        return getConditionalTestExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__Upper() {
        return getConditionalTestExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__AssignmentsBefore__SyntaxElement() {
        return getConditionalTestExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__ConditionalTestExpressionTypeDerivation__DiagnosticChain_Map() {
        return getConditionalTestExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__ConditionalTestExpressionLowerDerivation__DiagnosticChain_Map() {
        return getConditionalTestExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__ConditionalTestExpressionUpperDerivation__DiagnosticChain_Map() {
        return getConditionalTestExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__ConditionalTestExpressionCondition__DiagnosticChain_Map() {
        return getConditionalTestExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__ConditionalTestExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getConditionalTestExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__ConditionalTestExpressionAssignmentsAfter__DiagnosticChain_Map() {
        return getConditionalTestExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalTestExpression__UpdateAssignments() {
        return getConditionalTestExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceCreationExpression() {
		if (instanceCreationExpressionEClass == null) {
			instanceCreationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(53);
		}
		return instanceCreationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceCreationExpression_IsConstructorless() {
        return (EAttribute)getInstanceCreationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceCreationExpression_IsObjectCreation() {
        return (EAttribute)getInstanceCreationExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceCreationExpression_Constructor() {
        return (EReference)getInstanceCreationExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__Referent() {
        return getInstanceCreationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__Feature() {
        return getInstanceCreationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__Type() {
        return getInstanceCreationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__Lower() {
        return getInstanceCreationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__Upper() {
        return getInstanceCreationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__InstanceCreationExpressionIsObjectCreationDerivation__DiagnosticChain_Map() {
        return getInstanceCreationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__InstanceCreationExpressionIsConstructorlessDerivation__DiagnosticChain_Map() {
        return getInstanceCreationExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__InstanceCreationExpressionReferentDerivation__DiagnosticChain_Map() {
        return getInstanceCreationExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__InstanceCreationExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getInstanceCreationExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__InstanceCreationExpressionConstructor__DiagnosticChain_Map() {
        return getInstanceCreationExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__InstanceCreationExpressionConstructorlessLegality__DiagnosticChain_Map() {
        return getInstanceCreationExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__InstanceCreationExpressionDataTypeCompatibility__DiagnosticChain_Map() {
        return getInstanceCreationExpression().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__InstanceCreationExpressionReferent__DiagnosticChain_Map() {
        return getInstanceCreationExpression().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceCreationExpression__ParameterElements() {
        return getInstanceCreationExpression().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyAccessExpression() {
		if (propertyAccessExpressionEClass == null) {
			propertyAccessExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(54);
		}
		return propertyAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAccessExpression_FeatureReference() {
        return (EReference)getPropertyAccessExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAccessExpression_Feature() {
        return (EReference)getPropertyAccessExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__Type() {
        return getPropertyAccessExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__Upper() {
        return getPropertyAccessExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__Lower() {
        return getPropertyAccessExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__PropertyAccessExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getPropertyAccessExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__PropertyAccessExpressionTypeDerivation__DiagnosticChain_Map() {
        return getPropertyAccessExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__PropertyAccessExpressionUpperDerivation__DiagnosticChain_Map() {
        return getPropertyAccessExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__PropertyAccessExpressionLowerDerivation__DiagnosticChain_Map() {
        return getPropertyAccessExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__PropertyAccessExpressionFeatureResolution__DiagnosticChain_Map() {
        return getPropertyAccessExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__PropertyAccessExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getPropertyAccessExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyAccessExpression__UpdateAssignments() {
        return getPropertyAccessExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameExpression() {
		if (nameExpressionEClass == null) {
			nameExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(55);
		}
		return nameExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameExpression_EnumerationLiteral() {
        return (EReference)getNameExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameExpression_Assignment() {
        return (EReference)getNameExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameExpression_PropertyAccess() {
        return (EReference)getNameExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameExpression_Name() {
        return (EReference)getNameExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__Type() {
        return getNameExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__Upper() {
        return getNameExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__Lower() {
        return getNameExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__ParameterReferent() {
        return getNameExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__AssignmentFor__String() {
        return getNameExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__AssignmentFor___String() {
        return getNameExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__IsAddTargetName() {
        return getNameExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__NameExpressionAssignmentDerivation__DiagnosticChain_Map() {
        return getNameExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__NameExpressionEnumerationLiteralDerivation__DiagnosticChain_Map() {
        return getNameExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__NameExpressionPropertyAccessDerivation__DiagnosticChain_Map() {
        return getNameExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__NameExpressionTypeDerivation__DiagnosticChain_Map() {
        return getNameExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__NameExpressionUpperDerivation__DiagnosticChain_Map() {
        return getNameExpression().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__NameExpressionLowerDerivation__DiagnosticChain_Map() {
        return getNameExpression().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__NameExpressionResolution__DiagnosticChain_Map() {
        return getNameExpression().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__ValidateNameExpressionResolution() {
        return getNameExpression().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameExpression__UpdateAssignments() {
        return getNameExpression().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBitStringUnaryExpression() {
		if (bitStringUnaryExpressionEClass == null) {
			bitStringUnaryExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(56);
		}
		return bitStringUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBitStringUnaryExpression_IsBitStringConversion() {
        return (EAttribute)getBitStringUnaryExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBitStringUnaryExpression__Type() {
        return getBitStringUnaryExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBitStringUnaryExpression__Lower() {
        return getBitStringUnaryExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBitStringUnaryExpression__Upper() {
        return getBitStringUnaryExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBitStringUnaryExpression__BitStringUnaryExpressionTypeDerivation__DiagnosticChain_Map() {
        return getBitStringUnaryExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBitStringUnaryExpression__BitStringUnaryExpressionLowerDerivation__DiagnosticChain_Map() {
        return getBitStringUnaryExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBitStringUnaryExpression__BitStringUnaryExpressionUpperDerivation__DiagnosticChain_Map() {
        return getBitStringUnaryExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBitStringUnaryExpression__BitStringUnaryExpressionOperand__DiagnosticChain_Map() {
        return getBitStringUnaryExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBitStringUnaryExpression__BitStringUnaryExpressionIsBitStringConversionDerivation__DiagnosticChain_Map() {
        return getBitStringUnaryExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureInvocationExpression() {
		if (featureInvocationExpressionEClass == null) {
			featureInvocationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(57);
		}
		return featureInvocationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureInvocationExpression_Target() {
        return (EReference)getFeatureInvocationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureInvocationExpression__Feature() {
        return getFeatureInvocationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureInvocationExpression__Referent() {
        return getFeatureInvocationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureInvocationExpression__FeatureInvocationExpressionReferentDerivation__DiagnosticChain_Map() {
        return getFeatureInvocationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureInvocationExpression__FeatureInvocationExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getFeatureInvocationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureInvocationExpression__FeatureInvocationExpressionReferentExists__DiagnosticChain_Map() {
        return getFeatureInvocationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureInvocationExpression__FeatureInvocationExpressionAlternativeConstructor__DiagnosticChain_Map() {
        return getFeatureInvocationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeatureInvocationExpression__FeatureInvocationExpressionImplicitAlternativeConstructor__DiagnosticChain_Map() {
        return getFeatureInvocationExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorInvocationExpression() {
		if (behaviorInvocationExpressionEClass == null) {
			behaviorInvocationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(58);
		}
		return behaviorInvocationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorInvocationExpression_Target() {
        return (EReference)getBehaviorInvocationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__IsAddTarget__Expression() {
        return getBehaviorInvocationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__Referent() {
        return getBehaviorInvocationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__Referent1() {
        return getBehaviorInvocationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__BehaviorInvocation_referent() {
        return getBehaviorInvocationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__Feature() {
        return getBehaviorInvocationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__BehaviorInvocationExpressionReferentDerivation__DiagnosticChain_Map() {
        return getBehaviorInvocationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__BehaviorInvocationExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getBehaviorInvocationExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__BehaviorInvocationExpressionReferentConstraint__DiagnosticChain_Map() {
        return getBehaviorInvocationExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__BehaviorInvocationExpressionArgumentCompatibility__DiagnosticChain_Map() {
        return getBehaviorInvocationExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBehaviorInvocationExpression__BehaviorInvocationExpressionAlternativeConstructor__DiagnosticChain_Map() {
        return getBehaviorInvocationExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShiftExpression() {
		if (shiftExpressionEClass == null) {
			shiftExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(59);
		}
		return shiftExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShiftExpression_IsBitStringConversion() {
        return (EAttribute)getShiftExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShiftExpression__Type() {
        return getShiftExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShiftExpression__Lower() {
        return getShiftExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShiftExpression__Upper() {
        return getShiftExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShiftExpression__ShiftExpressionTypeDerivation__DiagnosticChain_Map() {
        return getShiftExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShiftExpression__ShiftExpressionLowerDerivation__DiagnosticChain_Map() {
        return getShiftExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShiftExpression__ShiftExpressionUpperDerivation__DiagnosticChain_Map() {
        return getShiftExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShiftExpression__ShiftExpressionOperands__DiagnosticChain_Map() {
        return getShiftExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShiftExpression__ShiftExpressionIsBitStringConversionDerivation__DiagnosticChain_Map() {
        return getShiftExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnboundedLiteralExpression() {
		if (unboundedLiteralExpressionEClass == null) {
			unboundedLiteralExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(60);
		}
		return unboundedLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnboundedLiteralExpression__Type() {
        return getUnboundedLiteralExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnboundedLiteralExpression__UnboundedLiteralExpressionTypeDerivation__DiagnosticChain_Map() {
        return getUnboundedLiteralExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThisExpression() {
		if (thisExpressionEClass == null) {
			thisExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(61);
		}
		return thisExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThisExpression__Type() {
        return getThisExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThisExpression__Upper() {
        return getThisExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThisExpression__Lower() {
        return getThisExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThisExpression__ThisExpressionTypeDerivation__DiagnosticChain_Map() {
        return getThisExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThisExpression__ThisExpressionUpperDerivation__DiagnosticChain_Map() {
        return getThisExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThisExpression__ThisExpressionLowerDerivation__DiagnosticChain_Map() {
        return getThisExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassificationExpression() {
		if (classificationExpressionEClass == null) {
			classificationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(62);
		}
		return classificationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassificationExpression_Referent() {
        return (EReference)getClassificationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassificationExpression_IsDirect() {
        return (EAttribute)getClassificationExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassificationExpression_TypeName() {
        return (EReference)getClassificationExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__Type() {
        return getClassificationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__Lower() {
        return getClassificationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__Upper() {
        return getClassificationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__ClassificationExpressionIsDirectDerivation__DiagnosticChain_Map() {
        return getClassificationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__ClassificationExpressionReferentDerivation__DiagnosticChain_Map() {
        return getClassificationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__ClassificationExpressionTypeDerivation__DiagnosticChain_Map() {
        return getClassificationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__ClassificationExpressionLowerDerivation__DiagnosticChain_Map() {
        return getClassificationExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__ClassificationExpressionUpperDerivation__DiagnosticChain_Map() {
        return getClassificationExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__ClassificationExpressionTypeName__DiagnosticChain_Map() {
        return getClassificationExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassificationExpression__ClassificationExpressionOperand__DiagnosticChain_Map() {
        return getClassificationExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSuperInvocationExpression() {
		if (superInvocationExpressionEClass == null) {
			superInvocationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(63);
		}
		return superInvocationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSuperInvocationExpression_Target() {
        return (EReference)getSuperInvocationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__Referent() {
        return getSuperInvocationExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__Feature() {
        return getSuperInvocationExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__Context() {
        return getSuperInvocationExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__SuperInvocationExpressionReferentDerivation__DiagnosticChain_Map() {
        return getSuperInvocationExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__SuperInvocationExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getSuperInvocationExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__SuperInvocationExpressionQualification__DiagnosticChain_Map() {
        return getSuperInvocationExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__SuperInvocationExpressionImplicitTarget__DiagnosticChain_Map() {
        return getSuperInvocationExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__SuperInvocationExpressionConstructorCall__DiagnosticChain_Map() {
        return getSuperInvocationExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__SuperInvocationExpressionDestructorCall__DiagnosticChain_Map() {
        return getSuperInvocationExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSuperInvocationExpression__SuperInvocationExpressionOperation__DiagnosticChain_Map() {
        return getSuperInvocationExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncrementOrDecrementExpression() {
		if (incrementOrDecrementExpressionEClass == null) {
			incrementOrDecrementExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(64);
		}
		return incrementOrDecrementExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncrementOrDecrementExpression_Assignment() {
        return (EReference)getIncrementOrDecrementExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncrementOrDecrementExpression_Operand() {
        return (EReference)getIncrementOrDecrementExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncrementOrDecrementExpression_Expression() {
        return (EReference)getIncrementOrDecrementExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncrementOrDecrementExpression_Feature() {
        return (EReference)getIncrementOrDecrementExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementOrDecrementExpression_IsPrefix() {
        return (EAttribute)getIncrementOrDecrementExpression().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementOrDecrementExpression_IsFeature() {
        return (EAttribute)getIncrementOrDecrementExpression().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementOrDecrementExpression_IsIndexed() {
        return (EAttribute)getIncrementOrDecrementExpression().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementOrDecrementExpression_IsDataValueUpdate() {
        return (EAttribute)getIncrementOrDecrementExpression().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementOrDecrementExpression_Operator() {
        return (EAttribute)getIncrementOrDecrementExpression().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__Type() {
        return getIncrementOrDecrementExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__Lower() {
        return getIncrementOrDecrementExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__Upper() {
        return getIncrementOrDecrementExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionAssignmentDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionIsFeatureDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionIsIndexedDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionIsDataValueUpdateDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionFeatureDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionExpressionDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionTypeDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionLowerDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionUpperDerivation__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionOperand__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__IncrementOrDecrementExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getIncrementOrDecrementExpression().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIncrementOrDecrementExpression__UpdateAssignments() {
        return getIncrementOrDecrementExpression().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteralExpression() {
		if (booleanLiteralExpressionEClass == null) {
			booleanLiteralExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(65);
		}
		return booleanLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteralExpression_Image() {
        return (EAttribute)getBooleanLiteralExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanLiteralExpression__Type() {
        return getBooleanLiteralExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBooleanLiteralExpression__BooleanLiteralExpressionTypeDerivation__DiagnosticChain_Map() {
        return getBooleanLiteralExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedTuple() {
		if (namedTupleEClass == null) {
			namedTupleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(66);
		}
		return namedTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedTuple_NamedExpression() {
        return (EReference)getNamedTuple().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTuple__Size() {
        return getNamedTuple().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTuple__InputFor__EList() {
        return getNamedTuple().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTuple__OutputFor__EList() {
        return getNamedTuple().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTuple__OutputForExpression__Expression() {
        return getNamedTuple().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedTuple__NamedTupleArgumentNames__DiagnosticChain_Map() {
        return getNamedTuple().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNaturalLiteralExpression() {
		if (naturalLiteralExpressionEClass == null) {
			naturalLiteralExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(67);
		}
		return naturalLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNaturalLiteralExpression_Image() {
        return (EAttribute)getNaturalLiteralExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNaturalLiteralExpression__Type() {
        return getNaturalLiteralExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNaturalLiteralExpression__NaturalLiteralExpressionTypeDerivation__DiagnosticChain_Map() {
        return getNaturalLiteralExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceRange() {
		if (sequenceRangeEClass == null) {
			sequenceRangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(68);
		}
		return sequenceRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceRange_RangeLower() {
        return (EReference)getSequenceRange().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceRange_RangeUpper() {
        return (EReference)getSequenceRange().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceRange__ConformsTo__ElementReference() {
        return getSequenceRange().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceRange__AssignmentsAfter() {
        return getSequenceRange().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceRange__Upper() {
        return getSequenceRange().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceRange__Lower() {
        return getSequenceRange().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceRange__SequenceRangeLowerDerivation__DiagnosticChain_Map() {
        return getSequenceRange().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceRange__SequenceRangeUpperDerivation__DiagnosticChain_Map() {
        return getSequenceRange().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceRange__SequenceRangeExpressionMultiplicity__DiagnosticChain_Map() {
        return getSequenceRange().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceRange__SequenceRangeAssignments__DiagnosticChain_Map() {
        return getSequenceRange().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameLeftHandSide() {
		if (nameLeftHandSideEClass == null) {
			nameLeftHandSideEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(69);
		}
		return nameLeftHandSideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameLeftHandSide_Target() {
        return (EReference)getNameLeftHandSide().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameLeftHandSide_Index() {
        return (EReference)getNameLeftHandSide().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Target() {
        return getNameLeftHandSide().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Index() {
        return getNameLeftHandSide().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Referent() {
        return getNameLeftHandSide().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__ParameterReferent() {
        return getNameLeftHandSide().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Type() {
        return getNameLeftHandSide().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Upper() {
        return getNameLeftHandSide().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Lower() {
        return getNameLeftHandSide().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__OldAssignment() {
        return getNameLeftHandSide().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Feature() {
        return getNameLeftHandSide().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Expression() {
        return getNameLeftHandSide().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__Primary() {
        return getNameLeftHandSide().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__LocalName() {
        return getNameLeftHandSide().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideAssignmentAfterDerivation__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideTargetAssignment__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideAssignmentsBefore__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideReferentDerivation__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideLowerDerivation__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideUpperDerivation__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideTypeDerivation__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideTargetResolution__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideIndexedFeature__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNameLeftHandSide__NameLeftHandSideNontemplateTarget__DiagnosticChain_Map() {
        return getNameLeftHandSide().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEffectiveLeftHandSide() {
		if (effectiveLeftHandSideEClass == null) {
			effectiveLeftHandSideEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(70);
		}
		return effectiveLeftHandSideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEffectiveLeftHandSide_Expression() {
        return (EReference)getEffectiveLeftHandSide().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEffectiveLeftHandSide__Target() {
        return getEffectiveLeftHandSide().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEffectiveLeftHandSide__Index() {
        return getEffectiveLeftHandSide().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEffectiveLeftHandSide__Feature() {
        return getEffectiveLeftHandSide().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEffectiveLeftHandSide__Primary() {
        return getEffectiveLeftHandSide().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEffectiveLeftHandSide__Expression() {
        return getEffectiveLeftHandSide().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceReductionExpression() {
		if (sequenceReductionExpressionEClass == null) {
			sequenceReductionExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(71);
		}
		return sequenceReductionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceReductionExpression_Referent() {
        return (EReference)getSequenceReductionExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceReductionExpression_IsOrdered() {
        return (EAttribute)getSequenceReductionExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceReductionExpression_Primary() {
        return (EReference)getSequenceReductionExpression().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceReductionExpression_BehaviorName() {
        return (EReference)getSequenceReductionExpression().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__Type() {
        return getSequenceReductionExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__Upper() {
        return getSequenceReductionExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__Lower() {
        return getSequenceReductionExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__SequenceReductionExpressionReferentDerivation__DiagnosticChain_Map() {
        return getSequenceReductionExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__SequenceReductionExpressionTypeDerivation__DiagnosticChain_Map() {
        return getSequenceReductionExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__SequenceReductionExpressionUpperDerivation__DiagnosticChain_Map() {
        return getSequenceReductionExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__SequenceReductionExpressionLowerDerivation__DiagnosticChain_Map() {
        return getSequenceReductionExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__SequenceReductionExpressionBehavior__DiagnosticChain_Map() {
        return getSequenceReductionExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__SequenceReductionExpressionBehaviorParameters__DiagnosticChain_Map() {
        return getSequenceReductionExpression().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__SequenceReductionExpressionAssignmentsBefore__DiagnosticChain_Map() {
        return getSequenceReductionExpression().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceReductionExpression__UpdateAssignments() {
        return getSequenceReductionExpression().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceExpressionList() {
		if (sequenceExpressionListEClass == null) {
			sequenceExpressionListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(72);
		}
		return sequenceExpressionListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceExpressionList_Element() {
        return (EReference)getSequenceExpressionList().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpressionList__ConformsTo__ElementReference() {
        return getSequenceExpressionList().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpressionList__AssignmentsBefore__SyntaxElement() {
        return getSequenceExpressionList().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpressionList__AssignmentsAfter() {
        return getSequenceExpressionList().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpressionList__Lower() {
        return getSequenceExpressionList().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpressionList__Upper() {
        return getSequenceExpressionList().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpressionList__SequenceExpressionListLowerDerivation__DiagnosticChain_Map() {
        return getSequenceExpressionList().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSequenceExpressionList__SequenceExpressionListUpperDerivation__DiagnosticChain_Map() {
        return getSequenceExpressionList().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalExpression() {
		if (relationalExpressionEClass == null) {
			relationalExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(73);
		}
		return relationalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationalExpression_IsUnlimitedNatural() {
        return (EAttribute)getRelationalExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationalExpression__Type() {
        return getRelationalExpression().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationalExpression__Lower() {
        return getRelationalExpression().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationalExpression__Upper() {
        return getRelationalExpression().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationalExpression__RelationalExpressionIsUnlimitedNaturalDerivation__DiagnosticChain_Map() {
        return getRelationalExpression().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationalExpression__RelationalExpressionTypeDerivation__DiagnosticChain_Map() {
        return getRelationalExpression().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationalExpression__RelationalExpressionLowerDerivation__DiagnosticChain_Map() {
        return getRelationalExpression().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationalExpression__RelationalExpressionUpperDerivation__DiagnosticChain_Map() {
        return getRelationalExpression().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationalExpression__RelationalExpressionOperandTypes__DiagnosticChain_Map() {
        return getRelationalExpression().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalNameDeclarationStatement() {
		if (localNameDeclarationStatementEClass == null) {
			localNameDeclarationStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(74);
		}
		return localNameDeclarationStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalNameDeclarationStatement_Name() {
        return (EAttribute)getLocalNameDeclarationStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalNameDeclarationStatement_Expression() {
        return (EReference)getLocalNameDeclarationStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalNameDeclarationStatement_HasMultiplicity() {
        return (EAttribute)getLocalNameDeclarationStatement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalNameDeclarationStatement_TypeName() {
        return (EReference)getLocalNameDeclarationStatement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalNameDeclarationStatement_Type() {
        return (EReference)getLocalNameDeclarationStatement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalNameDeclarationStatement_IsAny() {
        return (EAttribute)getLocalNameDeclarationStatement().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__ActualName() {
        return getLocalNameDeclarationStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__AssignmentsAfter() {
        return getLocalNameDeclarationStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__LocalNameDeclarationStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getLocalNameDeclarationStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__LocalNameDeclarationStatementType__DiagnosticChain_Map() {
        return getLocalNameDeclarationStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__LocalNameDeclarationStatementLocalName__DiagnosticChain_Map() {
        return getLocalNameDeclarationStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__LocalNameDeclarationStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getLocalNameDeclarationStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__LocalNameDeclarationStatementExpressionMultiplicity__DiagnosticChain_Map() {
        return getLocalNameDeclarationStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__LocalNameDeclarationStatementTypeDerivation__DiagnosticChain_Map() {
        return getLocalNameDeclarationStatement().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__TypeCached() {
        return getLocalNameDeclarationStatement().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalNameDeclarationStatement__Type() {
        return getLocalNameDeclarationStatement().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignableLocalNameDeclaration() {
		if (assignableLocalNameDeclarationEClass == null) {
			assignableLocalNameDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(75);
		}
		return assignableLocalNameDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignableLocalNameDeclaration_LocalNameDeclaration() {
        return (EReference)getAssignableLocalNameDeclaration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableLocalNameDeclaration__Type() {
        return getAssignableLocalNameDeclaration().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableLocalNameDeclaration__Lower() {
        return getAssignableLocalNameDeclaration().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignableLocalNameDeclaration__Upper() {
        return getAssignableLocalNameDeclaration().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatement() {
		if (statementEClass == null) {
			statementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(76);
		}
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatement_AssignmentBefore() {
        return (EReference)getStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatement_AssignmentAfter() {
        return (EReference)getStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatement_EnclosingStatement() {
        return (EReference)getStatement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatement_IsIsolated() {
        return (EAttribute)getStatement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__EnclosingLoopStatement() {
        return getStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__StatementAnnotationsAllowed__DiagnosticChain_Map() {
        return getStatement().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__StatementUniqueAssignments__DiagnosticChain_Map() {
        return getStatement().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__StatementIsIsolatedDerivation__DiagnosticChain_Map() {
        return getStatement().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__AnnotationAllowed__Annotation() {
        return getStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__Statement_annotationAllowed__Annotation() {
        return getStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__Annotation() {
        return getStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__HasAnnotation__String() {
        return getStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__NewAssignments() {
        return getStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__Resolve__String() {
        return getStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__AssignmentsAfter() {
        return getStatement().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__Statement_assignmentsAfter() {
        return getStatement().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__AssignmentsAfterCached() {
        return getStatement().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__MergeAssignments__EList() {
        return getStatement().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStatement__Merge__String_EList() {
        return getStatement().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		if (annotationEClass == null) {
			annotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(77);
		}
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Text() {
        return (EAttribute)getAnnotation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Identifier() {
        return (EAttribute)getAnnotation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Argument() {
        return (EAttribute)getAnnotation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnnotation__Identifier() {
        return getAnnotation().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnnotation__Arguments() {
        return getAnnotation().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedNameList() {
		if (qualifiedNameListEClass == null) {
			qualifiedNameListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(78);
		}
		return qualifiedNameListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedNameList_Name() {
        return (EReference)getQualifiedNameList().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQualifiedNameList__CurrentScope() {
        return getQualifiedNameList().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonFinalClause() {
		if (nonFinalClauseEClass == null) {
			nonFinalClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(79);
		}
		return nonFinalClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonFinalClause_Condition() {
        return (EReference)getNonFinalClause().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonFinalClause_Body() {
        return (EReference)getNonFinalClause().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNonFinalClause__AssignmentsBefore__SyntaxElement() {
        return getNonFinalClause().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNonFinalClause__NonFinalClauseAssignmentsBeforeBody__DiagnosticChain_Map() {
        return getNonFinalClause().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNonFinalClause__NonFinalClauseConditionLocalNames__DiagnosticChain_Map() {
        return getNonFinalClause().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNonFinalClause__NonFinalClauseConditionType__DiagnosticChain_Map() {
        return getNonFinalClause().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNonFinalClause__AssignmentsBefore() {
        return getNonFinalClause().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNonFinalClause__AssignmentsAfter() {
        return getNonFinalClause().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlock() {
		if (blockEClass == null) {
			blockEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(80);
		}
		return blockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_Statement() {
        return (EReference)getBlock().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_AssignmentAfter() {
        return (EReference)getBlock().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_AssignmentBefore() {
        return (EReference)getBlock().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlock__AssignmentsBefore__SyntaxElement() {
        return getBlock().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlock__NewAssignments() {
        return getBlock().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlock__BlockAssignmentsBeforeStatements__DiagnosticChain_Map() {
        return getBlock().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlock__BlockAssignmentsBefore__DiagnosticChain_Map() {
        return getBlock().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlock__BlockAssignmentAfterDerivation__DiagnosticChain_Map() {
        return getBlock().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockStatement() {
		if (blockStatementEClass == null) {
			blockStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(81);
		}
		return blockStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockStatement_Block() {
        return (EReference)getBlockStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockStatement_IsParallel() {
        return (EAttribute)getBlockStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlockStatement__AssignmentsAfter() {
        return getBlockStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlockStatement__BlockStatementParallelAssignments__DiagnosticChain_Map() {
        return getBlockStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlockStatement__BlockStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getBlockStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlockStatement__BlockStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getBlockStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlockStatement__BlockStatementEnclosedStatements__DiagnosticChain_Map() {
        return getBlockStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlockStatement__BlockStatementIsParallelDerivation__DiagnosticChain_Map() {
        return getBlockStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlockStatement__AnnotationAllowed__Annotation() {
        return getBlockStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoStatement() {
		if (doStatementEClass == null) {
			doStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(82);
		}
		return doStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDoStatement_Condition() {
        return (EReference)getDoStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDoStatement_Body() {
        return (EReference)getDoStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDoStatement__EnclosingLoopStatement() {
        return getDoStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDoStatement__AssignmentsBefore__SyntaxElement() {
        return getDoStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDoStatement__AssignmentsAfter() {
        return getDoStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDoStatement__DoStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getDoStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDoStatement__DoStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getDoStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDoStatement__DoStatementCondition__DiagnosticChain_Map() {
        return getDoStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDoStatement__DoStatementEnclosedStatements__DiagnosticChain_Map() {
        return getDoStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcurrentClauses() {
		if (concurrentClausesEClass == null) {
			concurrentClausesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(83);
		}
		return concurrentClausesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcurrentClauses_Clause() {
        return (EReference)getConcurrentClauses().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConcurrentClauses__ConcurrentClausesAssignmentsBefore__DiagnosticChain_Map() {
        return getConcurrentClauses().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConcurrentClauses__ConcurrentClausesConditionAssignments__DiagnosticChain_Map() {
        return getConcurrentClauses().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakStatement() {
		if (breakStatementEClass == null) {
			breakStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(84);
		}
		return breakStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBreakStatement_Target() {
        return (EReference)getBreakStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBreakStatement__BreakStatementTargetDerivation__DiagnosticChain_Map() {
        return getBreakStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBreakStatement__BreakStatementNonparallelTarget__DiagnosticChain_Map() {
        return getBreakStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBreakStatement__AnnotationAllowed__Annotation() {
        return getBreakStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionStatement() {
		if (expressionStatementEClass == null) {
			expressionStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(85);
		}
		return expressionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionStatement_Expression() {
        return (EReference)getExpressionStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionStatement__AssignmentsAfter() {
        return getExpressionStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionStatement__ExpressionStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getExpressionStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExpressionStatement__ExpressionStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getExpressionStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifyStatement() {
		if (classifyStatementEClass == null) {
			classifyStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(86);
		}
		return classifyStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifyStatement_Expression() {
        return (EReference)getClassifyStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifyStatement_FromList() {
        return (EReference)getClassifyStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifyStatement_ToList() {
        return (EReference)getClassifyStatement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifyStatement_FromClass() {
        return (EReference)getClassifyStatement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifyStatement_ToClass() {
        return (EReference)getClassifyStatement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifyStatement_IsReclassifyAll() {
        return (EAttribute)getClassifyStatement().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifyStatement__AssignmentAfter() {
        return getClassifyStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifyStatement__ClassifyStatementExpression__DiagnosticChain_Map() {
        return getClassifyStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifyStatement__ClassifyStatementClassNames__DiagnosticChain_Map() {
        return getClassifyStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifyStatement__ClassifyStatementClasses__DiagnosticChain_Map() {
        return getClassifyStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifyStatement__ClassifyStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getClassifyStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifyStatement__ClassifyStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getClassifyStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifyStatement__ClassifyStatementFromClassDerivation__DiagnosticChain_Map() {
        return getClassifyStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifyStatement__ClassifyStatementToClassDerivation__DiagnosticChain_Map() {
        return getClassifyStatement().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForStatement() {
		if (forStatementEClass == null) {
			forStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(87);
		}
		return forStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Body() {
        return (EReference)getForStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_VariableDefinition() {
        return (EReference)getForStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForStatement_IsParallel() {
        return (EAttribute)getForStatement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__EnclosingLoopStatement() {
        return getForStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__AssignmentsBefore__SyntaxElement() {
        return getForStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__AssignmentsAfterVariables() {
        return getForStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__AssignmentsAfter() {
        return getForStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ParallelNames() {
        return getForStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ForStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getForStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ForStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getForStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ForStatementParallelAnnotationNames__DiagnosticChain_Map() {
        return getForStatement().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ForStatementParallelAssignmentsAfter__DiagnosticChain_Map() {
        return getForStatement().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ForStatementVariableDefinitions__DiagnosticChain_Map() {
        return getForStatement().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ForStatementLoopVariables__DiagnosticChain_Map() {
        return getForStatement().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ForStatementIsParallelDerivation__DiagnosticChain_Map() {
        return getForStatement().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__ForStatementEnclosedStatements__DiagnosticChain_Map() {
        return getForStatement().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForStatement__AnnotationAllowed__Annotation() {
        return getForStatement().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopVariableDefinition() {
		if (loopVariableDefinitionEClass == null) {
			loopVariableDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(88);
		}
		return loopVariableDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopVariableDefinition_Variable() {
        return (EAttribute)getLoopVariableDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopVariableDefinition_Expression1() {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopVariableDefinition_Expression2() {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopVariableDefinition_TypeName() {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopVariableDefinition_TypeIsInferred() {
        return (EAttribute)getLoopVariableDefinition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopVariableDefinition_IsCollectionConversion() {
        return (EAttribute)getLoopVariableDefinition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopVariableDefinition_Type() {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopVariableDefinition_IsFirst() {
        return (EAttribute)getLoopVariableDefinition().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopVariableDefinition_AssignmentBefore() {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopVariableDefinition_AssignmentAfter() {
        return (EReference)getLoopVariableDefinition().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopVariableDefinition_IsAny() {
        return (EAttribute)getLoopVariableDefinition().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__ActualName() {
        return getLoopVariableDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__NewAssignments() {
        return getLoopVariableDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__LoopVariableDefinitionAssignmentAfterDerivation__DiagnosticChain_Map() {
        return getLoopVariableDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__LoopVariableDefinitionAssignmentsBefore__DiagnosticChain_Map() {
        return getLoopVariableDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__LoopVariableDefinitionRangeExpressions__DiagnosticChain_Map() {
        return getLoopVariableDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__LoopVariableDefinitionTypeName__DiagnosticChain_Map() {
        return getLoopVariableDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__LoopVariableDefinitionTypeDerivation__DiagnosticChain_Map() {
        return getLoopVariableDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__LoopVariableDefinitionDeclaredType__DiagnosticChain_Map() {
        return getLoopVariableDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__LoopVariableDefinitionIsCollectionConversionDerivation__DiagnosticChain_Map() {
        return getLoopVariableDefinition().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoopVariableDefinition__LoopVariableDefinitionVariable__DiagnosticChain_Map() {
        return getLoopVariableDefinition().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfStatement() {
		if (ifStatementEClass == null) {
			ifStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(89);
		}
		return ifStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_NonFinalClauses() {
        return (EReference)getIfStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_FinalClause() {
        return (EReference)getIfStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfStatement_IsAssured() {
        return (EAttribute)getIfStatement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfStatement_IsDeterminate() {
        return (EAttribute)getIfStatement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIfStatement__AssignmentsAfter() {
        return getIfStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIfStatement__IfStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getIfStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIfStatement__IfStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getIfStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIfStatement__IfStatementEnclosedStatements__DiagnosticChain_Map() {
        return getIfStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIfStatement__IfStatementIsAssuredDerivation__DiagnosticChain_Map() {
        return getIfStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIfStatement__IfStatementIsDeterminateDerivation__DiagnosticChain_Map() {
        return getIfStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIfStatement__AnnotationAllowed__Annotation() {
        return getIfStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchStatement() {
		if (switchStatementEClass == null) {
			switchStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(90);
		}
		return switchStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_NonDefaultClause() {
        return (EReference)getSwitchStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_Expression() {
        return (EReference)getSwitchStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_DefaultClause() {
        return (EReference)getSwitchStatement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchStatement_IsAssured() {
        return (EAttribute)getSwitchStatement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchStatement_IsDeterminate() {
        return (EAttribute)getSwitchStatement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__AssignmentsBefore__SyntaxElement() {
        return getSwitchStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__AssignmentsAfter() {
        return getSwitchStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__SwitchStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getSwitchStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__SwitchStatementCaseAssignments__DiagnosticChain_Map() {
        return getSwitchStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__SwitchStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getSwitchStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__SwitchStatementAssignments__DiagnosticChain_Map() {
        return getSwitchStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__SwitchStatementExpression__DiagnosticChain_Map() {
        return getSwitchStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__SwitchStatementEnclosedStatements__DiagnosticChain_Map() {
        return getSwitchStatement().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__SwitchStatementIsDeterminateDerivation__DiagnosticChain_Map() {
        return getSwitchStatement().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__SwitchStatementIsAssuredDerivation__DiagnosticChain_Map() {
        return getSwitchStatement().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchStatement__AnnotationAllowed__Annotation() {
        return getSwitchStatement().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchClause() {
		if (switchClauseEClass == null) {
			switchClauseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(91);
		}
		return switchClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchClause_Case() {
        return (EReference)getSwitchClause().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchClause_Block() {
        return (EReference)getSwitchClause().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchClause__AssignmentsBefore__SyntaxElement() {
        return getSwitchClause().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchClause__SwitchClauseAssignmentsBefore__DiagnosticChain_Map() {
        return getSwitchClause().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchClause__SwitchClauseCaseLocalNames__DiagnosticChain_Map() {
        return getSwitchClause().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchClause__SwitchClauseCases__DiagnosticChain_Map() {
        return getSwitchClause().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchClause__AssignmentsBefore() {
        return getSwitchClause().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchClause__AssignmentsAfter() {
        return getSwitchClause().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileStatement() {
		if (whileStatementEClass == null) {
			whileStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(92);
		}
		return whileStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileStatement_Body() {
        return (EReference)getWhileStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileStatement_Condition() {
        return (EReference)getWhileStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileStatement__EnclosingLoopStatement() {
        return getWhileStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileStatement__AssignmentsBefore__SyntaxElement() {
        return getWhileStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileStatement__AssignmentsAfter() {
        return getWhileStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileStatement__WhileStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getWhileStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileStatement__WhileStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getWhileStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileStatement__WhileStatementCondition__DiagnosticChain_Map() {
        return getWhileStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileStatement__WhileStatementEnclosedStatements__DiagnosticChain_Map() {
        return getWhileStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnStatement() {
		if (returnStatementEClass == null) {
			returnStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(93);
		}
		return returnStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturnStatement_Expression() {
        return (EReference)getReturnStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturnStatement_Behavior() {
        return (EReference)getReturnStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReturnStatement__AssignmentsAfter() {
        return getReturnStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReturnStatement__ReturnStatementContext__DiagnosticChain_Map() {
        return getReturnStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReturnStatement__ReturnStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getReturnStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReturnStatement__ReturnStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getReturnStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInLineStatement() {
		if (inLineStatementEClass == null) {
			inLineStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(94);
		}
		return inLineStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInLineStatement_Language() {
        return (EAttribute)getInLineStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInLineStatement_Code() {
        return (EAttribute)getInLineStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInLineStatement__InLineStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getInLineStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAcceptStatement() {
		if (acceptStatementEClass == null) {
			acceptStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(95);
		}
		return acceptStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAcceptStatement_AcceptBlock() {
        return (EReference)getAcceptStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAcceptStatement_Behavior() {
        return (EReference)getAcceptStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAcceptStatement_IsSimple() {
        return (EAttribute)getAcceptStatement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AssignmentsAfter() {
        return getAcceptStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__EffectiveBehavior() {
        return getAcceptStatement().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__EffectiveBehavior_() {
        return getAcceptStatement().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementContext__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementSignals__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__ReceivedSignals__ElementReference() {
        return getAcceptStatement().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__ReceivedSignals___ElementReference() {
        return getAcceptStatement().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementNames__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementSimpleAcceptLocalName__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementCompoundAcceptLocalName__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementAssignmentsBefore__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementNewAssignments__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementIsSimpleDerivation__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptStatement__AcceptStatementEnclosedStatements__DiagnosticChain_Map() {
        return getAcceptStatement().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAcceptBlock() {
		if (acceptBlockEClass == null) {
			acceptBlockEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(96);
		}
		return acceptBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAcceptBlock_Name() {
        return (EAttribute)getAcceptBlock().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAcceptBlock_Block() {
        return (EReference)getAcceptBlock().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAcceptBlock_SignalNames() {
        return (EReference)getAcceptBlock().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAcceptBlock_Signal() {
        return (EReference)getAcceptBlock().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptBlock__ActualName() {
        return getAcceptBlock().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptBlock__AssignmentsBefore__SyntaxElement() {
        return getAcceptBlock().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptBlock__AcceptBlockSignalDerivation__DiagnosticChain_Map() {
        return getAcceptBlock().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAcceptBlock__AcceptBlockSignalNames__DiagnosticChain_Map() {
        return getAcceptBlock().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyStatement() {
		if (emptyStatementEClass == null) {
			emptyStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(97);
		}
		return emptyStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEmptyStatement__EmptyStatementAssignmentsAfter__DiagnosticChain_Map() {
        return getEmptyStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelNamespace() {
		if (modelNamespaceEClass == null) {
			modelNamespaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(98);
		}
		return modelNamespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__Context() {
        return getModelNamespace().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__OuterScope() {
        return getModelNamespace().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__ResolveInRoot__String() {
        return getModelNamespace().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__ResolvePathName__String() {
        return getModelNamespace().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__ResolveAssociationEnd__ElementReference_String() {
        return getModelNamespace().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__AppliedProfiles() {
        return getModelNamespace().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__StubFor__UnitDefinition() {
        return getModelNamespace().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__ModelNamespace_appliedProfiles() {
        return getModelNamespace().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__ModelScope() {
        return getModelNamespace().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__QualifiedName() {
        return getModelNamespace().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelNamespace__ResolveInScope__String() {
        return getModelNamespace().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespaceDefinition() {
		if (namespaceDefinitionEClass == null) {
			namespaceDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(99);
		}
		return namespaceDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespaceDefinition_OwnedMember() {
        return (EReference)getNamespaceDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespaceDefinition_Unit() {
        return (EReference)getNamespaceDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespaceDefinition_Member() {
        return (EReference)getNamespaceDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__CurrentScope() {
        return getNamespaceDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__OuterScope() {
        return getNamespaceDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__NamespaceDefinition_outerScope() {
        return getNamespaceDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__ModelNamespace() {
        return getNamespaceDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__ModelScope() {
        return getNamespaceDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__ResolveInScope__String() {
        return getNamespaceDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__AppliedProfiles() {
        return getNamespaceDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__NamespaceDefinition_appliedProfiles() {
        return getNamespaceDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__Parameters() {
        return getNamespaceDefinition().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__ReturnParameter() {
        return getNamespaceDefinition().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__NamespaceDefinition_returnParameter() {
        return getNamespaceDefinition().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__SubunitOwnedMembers() {
        return getNamespaceDefinition().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getNamespaceDefinition().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__NamespaceDefinition_annotationAllowed__StereotypeAnnotation() {
        return getNamespaceDefinition().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__TemplateParameters() {
        return getNamespaceDefinition().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__MembersCached() {
        return getNamespaceDefinition().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__Members() {
        return getNamespaceDefinition().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__NamespaceDefinition_members() {
        return getNamespaceDefinition().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__ImportedMembers() {
        return getNamespaceDefinition().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__ImportMembers__EList() {
        return getNamespaceDefinition().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__ExcludeCollisions__EList() {
        return getNamespaceDefinition().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__RemoveDuplicates__EList() {
        return getNamespaceDefinition().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__IncludeDistinguishableCaching__EList() {
        return getNamespaceDefinition().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__IncludeDistinguishable__EList() {
        return getNamespaceDefinition().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__Stub() {
        return getNamespaceDefinition().getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__StubFor__UnitDefinition() {
        return getNamespaceDefinition().getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__NamespaceDefinitionMemberDerivation__DiagnosticChain_Map() {
        return getNamespaceDefinition().getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamespaceDefinition__NamespaceDefinitionMemberDistinguishability__DiagnosticChain_Map() {
        return getNamespaceDefinition().getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemberDefinition() {
		if (memberDefinitionEClass == null) {
			memberDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(100);
		}
		return memberDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberDefinition_Name() {
        return (EAttribute)getMemberDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberDefinition_IsStub() {
        return (EAttribute)getMemberDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberDefinition_IsFeature() {
        return (EAttribute)getMemberDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberDefinition_IsPrimitive() {
        return (EAttribute)getMemberDefinition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberDefinition_IsExternal() {
        return (EAttribute)getMemberDefinition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemberDefinition_Subunit() {
        return (EReference)getMemberDefinition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__Annotation() {
        return getMemberDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__ActualName() {
        return getMemberDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__OuterScope() {
        return getMemberDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberDefinition_outerScope() {
        return getMemberDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__QualifiedName() {
        return getMemberDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__NamespaceReference() {
        return getMemberDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__AddToModel() {
        return getMemberDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberAnnotations__DiagnosticChain_Map() {
        return getMemberDefinition().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberIsPrimitiveDerivation__DiagnosticChain_Map() {
        return getMemberDefinition().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberIsExternalDerivation__DiagnosticChain_Map() {
        return getMemberDefinition().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberExternal__DiagnosticChain_Map() {
        return getMemberDefinition().getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberStub__DiagnosticChain_Map() {
        return getMemberDefinition().getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberSubunitDerivation__DiagnosticChain_Map() {
        return getMemberDefinition().getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberStubStereotypes__DiagnosticChain_Map() {
        return getMemberDefinition().getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberPrimitive__DiagnosticChain_Map() {
        return getMemberDefinition().getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__ContainingMember() {
        return getMemberDefinition().getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getMemberDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MatchForStub__UnitDefinition() {
        return getMemberDefinition().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__IsDistinguishableFrom__MemberDefinition() {
        return getMemberDefinition().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__MemberDefinition_isDistinguishableFrom__MemberDefinition() {
        return getMemberDefinition().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__IsSameKindAs__ElementReference() {
        return getMemberDefinition().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__TemplateParameters() {
        return getMemberDefinition().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__IsTemplate() {
        return getMemberDefinition().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMemberDefinition__IsFeature() {
        return getMemberDefinition().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeAnnotation() {
		if (stereotypeAnnotationEClass == null) {
			stereotypeAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(101);
		}
		return stereotypeAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeAnnotation_TaggedValues() {
        return (EReference)getStereotypeAnnotation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeAnnotation_Names() {
        return (EReference)getStereotypeAnnotation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeAnnotation_StereotypeName() {
        return (EReference)getStereotypeAnnotation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeAnnotation_Stereotype() {
        return (EReference)getStereotypeAnnotation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStereotypeAnnotation__StereotypeAnnotationStereotypeDerivation__DiagnosticChain_Map() {
        return getStereotypeAnnotation().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStereotypeAnnotation__StereotypeAnnotationStereotypeName__DiagnosticChain_Map() {
        return getStereotypeAnnotation().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStereotypeAnnotation__StereotypeAnnotationApply__DiagnosticChain_Map() {
        return getStereotypeAnnotation().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStereotypeAnnotation__StereotypeAnnotationPrimitive__DiagnosticChain_Map() {
        return getStereotypeAnnotation().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStereotypeAnnotation__StereotypeAnnotationExternal__DiagnosticChain_Map() {
        return getStereotypeAnnotation().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStereotypeAnnotation__StereotypeAnnotationTaggedValues__DiagnosticChain_Map() {
        return getStereotypeAnnotation().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStereotypeAnnotation__StereotypeAnnotationNames__DiagnosticChain_Map() {
        return getStereotypeAnnotation().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStereotypeAnnotation__AppliedProfiles() {
        return getStereotypeAnnotation().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaggedValueList() {
		if (taggedValueListEClass == null) {
			taggedValueListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(102);
		}
		return taggedValueListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaggedValueList_TaggedValue() {
        return (EReference)getTaggedValueList().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaggedValue() {
		if (taggedValueEClass == null) {
			taggedValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(103);
		}
		return taggedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaggedValue_Name() {
        return (EAttribute)getTaggedValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaggedValue_Value() {
        return (EAttribute)getTaggedValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaggedValue_Operator() {
        return (EAttribute)getTaggedValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitDefinition() {
		if (unitDefinitionEClass == null) {
			unitDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(104);
		}
		return unitDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitDefinition_NamespaceName() {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitDefinition_Definition() {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitDefinition_Import() {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitDefinition_Namespace() {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitDefinition_IsModelLibrary() {
        return (EAttribute)getUnitDefinition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitDefinition_AppliedProfile() {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitDefinition_Annotation() {
        return (EReference)getUnitDefinition().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnitDefinition__Imports() {
        return getUnitDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnitDefinition__ImplicitImports() {
        return getUnitDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnitDefinition__ImplicitImportFor__String() {
        return getUnitDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnitDefinition__UnitDefinitionNamespaceDerivation__DiagnosticChain_Map() {
        return getUnitDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnitDefinition__UnitDefinitionNamespace__DiagnosticChain_Map() {
        return getUnitDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnitDefinition__UnitDefinitionIsModelLibraryDerivation__DiagnosticChain_Map() {
        return getUnitDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnitDefinition__UnitDefinitionImplicitImports__DiagnosticChain_Map() {
        return getUnitDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnitDefinition__UnitDefinitionAppliedProfileDerivation__DiagnosticChain_Map() {
        return getUnitDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportReference() {
		if (importReferenceEClass == null) {
			importReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(105);
		}
		return importReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportReference_Visibility() {
        return (EAttribute)getImportReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportReference_ReferentName() {
        return (EReference)getImportReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportReference_Referent() {
        return (EReference)getImportReference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportReference_Unit() {
        return (EReference)getImportReference().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportReference__ImportedMembers() {
        return getImportReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportReference__ImportReferenceReferentDerivation__DiagnosticChain_Map() {
        return getImportReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportReference__ImportReferenceReferent__DiagnosticChain_Map() {
        return getImportReference().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportedMember() {
		if (importedMemberEClass == null) {
			importedMemberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(106);
		}
		return importedMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportedMember_Referent() {
        return (EReference)getImportedMember().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportedMember__ActualName() {
        return getImportedMember().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportedMember__ToReference() {
        return getImportedMember().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportedMember__AnnotationAllowed__StereotypeAnnotation() {
        return getImportedMember().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportedMember__IsSameKindAs__ElementReference() {
        return getImportedMember().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportedMember__IsFeature() {
        return getImportedMember().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportedMember__ImportedMemberNotStub__DiagnosticChain_Map() {
        return getImportedMember().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImportedMember__ImportedMemberIsFeatureDerivation__DiagnosticChain_Map() {
        return getImportedMember().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationLiteralName() {
		if (enumerationLiteralNameEClass == null) {
			enumerationLiteralNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(107);
		}
		return enumerationLiteralNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEnumerationLiteralName__AnnotationAllowed__StereotypeAnnotation() {
        return getEnumerationLiteralName().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationDefinition() {
		if (operationDefinitionEClass == null) {
			operationDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(108);
		}
		return operationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationDefinition_Redefinition() {
        return (EReference)getOperationDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationDefinition_IsAbstract() {
        return (EAttribute)getOperationDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationDefinition_Body() {
        return (EReference)getOperationDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationDefinition_RedefinedOperation() {
        return (EReference)getOperationDefinition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationDefinition_IsConstructor() {
        return (EAttribute)getOperationDefinition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationDefinition_IsDestructor() {
        return (EAttribute)getOperationDefinition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__AssignmentsBefore__SyntaxElement() {
        return getOperationDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getOperationDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__MatchForStub__UnitDefinition() {
        return getOperationDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__IsSameKindAs__ElementReference() {
        return getOperationDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__ParametersMatch__ElementReference() {
        return getOperationDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__ParametersMatchNameType__ElementReference() {
        return getOperationDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__ReturnParameter() {
        return getOperationDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__SpecializationReferents() {
        return getOperationDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionNamespace__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionRedefinedOperationDerivation__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionRedefinition__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionRedefinedOperations__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionIsFeatureDerivation__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionIsConstructorDerivation__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionIsDestructorDerivation__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionConstructorDestructor__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionConstructor__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDefinition__OperationDefinitionDestructor__DiagnosticChain_Map() {
        return getOperationDefinition().getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationDefinition() {
		if (associationDefinitionEClass == null) {
			associationDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(109);
		}
		return associationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssociationDefinition__MatchForStub__UnitDefinition() {
        return getAssociationDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssociationDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getAssociationDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssociationDefinition__IsSameKindAs__ElementReference() {
        return getAssociationDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssociationDefinition__AssociationDefinitionSpecializationReferent__DiagnosticChain_Map() {
        return getAssociationDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierDefinition() {
		if (classifierDefinitionEClass == null) {
			classifierDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(110);
		}
		return classifierDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierDefinition_IsAbstract() {
        return (EAttribute)getClassifierDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefinition_Specialization() {
        return (EReference)getClassifierDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefinition_SpecializationReferent() {
        return (EReference)getClassifierDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__ClassifierDefinition_annotationAllowed__StereotypeAnnotation() {
        return getClassifierDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__MatchForStub__UnitDefinition() {
        return getClassifierDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__ClassifierDefinition_matchForStub__UnitDefinition() {
        return getClassifierDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__Members() {
        return getClassifierDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__InheritedMembers() {
        return getClassifierDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__Inherit__EList() {
        return getClassifierDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__ClassifierDefinitionSpecialization__DiagnosticChain_Map() {
        return getClassifierDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__ClassifierDefinitionSpecializationReferentDerivation__DiagnosticChain_Map() {
        return getClassifierDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierDefinition__ClassifierDefinitionInheritedMembers__DiagnosticChain_Map() {
        return getClassifierDefinition().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassDefinition() {
		if (classDefinitionEClass == null) {
			classDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(111);
		}
		return classDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getClassDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__MatchForStub__UnitDefinition() {
        return getClassDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__IsSameKindAs__ElementReference() {
        return getClassDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__NeedsDefaultConstructor() {
        return getClassDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__NeedsDefaultDestructor() {
        return getClassDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__Inherit__EList() {
        return getClassDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__InheritCached__EList() {
        return getClassDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__ClassDefinition_inherit__EList() {
        return getClassDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__ClassDefinitionSpecializationReferent__DiagnosticChain_Map() {
        return getClassDefinition().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassDefinition__ClassDefinitionAbstractMember__DiagnosticChain_Map() {
        return getClassDefinition().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElementDefinition() {
		if (typedElementDefinitionEClass == null) {
			typedElementDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(112);
		}
		return typedElementDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementDefinition_LowerBound() {
        return (EAttribute)getTypedElementDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementDefinition_UpperBound() {
        return (EAttribute)getTypedElementDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementDefinition_IsOrdered() {
        return (EAttribute)getTypedElementDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementDefinition_IsNonunique() {
        return (EAttribute)getTypedElementDefinition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElementDefinition_TypeName() {
        return (EReference)getTypedElementDefinition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElementDefinition_ActualType() {
        return (EReference)getTypedElementDefinition().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementDefinition_IsAny() {
        return (EAttribute)getTypedElementDefinition().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementDefinition_IsSequence() {
        return (EAttribute)getTypedElementDefinition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementDefinition_IsMultiplicity() {
        return (EAttribute)getTypedElementDefinition().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__IsOrdered() {
        return getTypedElementDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__IsNonunique() {
        return getTypedElementDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__TypedElementDefinitionLowerDerivation__DiagnosticChain_Map() {
        return getTypedElementDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__TypedElementDefinitionUpperDerivation__DiagnosticChain_Map() {
        return getTypedElementDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__TypedElementDefinitionTypeDerivation__DiagnosticChain_Map() {
        return getTypedElementDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__TypedElementDefinitionTypeName__DiagnosticChain_Map() {
        return getTypedElementDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__Type() {
        return getTypedElementDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__Lower() {
        return getTypedElementDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedElementDefinition__Upper() {
        return getTypedElementDefinition().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeDefinition() {
		if (dataTypeDefinitionEClass == null) {
			dataTypeDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(113);
		}
		return dataTypeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataTypeDefinition__MatchForStub__UnitDefinition() {
        return getDataTypeDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataTypeDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getDataTypeDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataTypeDefinition__IsSameKindAs__ElementReference() {
        return getDataTypeDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataTypeDefinition__DataTypeDefinitionPrimitive__DiagnosticChain_Map() {
        return getDataTypeDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataTypeDefinition__DataTypeDefinitionSpecializationReferent__DiagnosticChain_Map() {
        return getDataTypeDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageDefinition() {
		if (packageDefinitionEClass == null) {
			packageDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(114);
		}
		return packageDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageDefinition_AppliedProfile() {
        return (EReference)getPackageDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPackageDefinition__AllowPackageOnly() {
        return getPackageDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPackageDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getPackageDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPackageDefinition__MatchForStub__UnitDefinition() {
        return getPackageDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPackageDefinition__IsSameKindAs__ElementReference() {
        return getPackageDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPackageDefinition__PackageDefinitionAppliedProfileDerivation__DiagnosticChain_Map() {
        return getPackageDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPackageDefinition__AppliedProfiles() {
        return getPackageDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyDefinition() {
		if (propertyDefinitionEClass == null) {
			propertyDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(115);
		}
		return propertyDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_IsComposite() {
        return (EAttribute)getPropertyDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyDefinition_Initializer() {
        return (EReference)getPropertyDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_IsCollectionConversion() {
        return (EAttribute)getPropertyDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyDefinition_IsBitStringConversion() {
        return (EAttribute)getPropertyDefinition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyDefinition_TypePart() {
        return (EReference)getPropertyDefinition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyDefinition__AssignmentsBefore__SyntaxElement() {
        return getPropertyDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getPropertyDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyDefinition__IsSameKindAs__ElementReference() {
        return getPropertyDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyDefinition__IsFeature() {
        return getPropertyDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyDefinition__PropertyDefinitionInitializer__DiagnosticChain_Map() {
        return getPropertyDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyDefinition__PropertyDefinitionIsCollectionConversionDerivation__DiagnosticChain_Map() {
        return getPropertyDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyDefinition__PropertyDefinitionIsBitStringConversionDerivation__DiagnosticChain_Map() {
        return getPropertyDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyDefinition__PropertyDefinitionIsFeatureDerivation__DiagnosticChain_Map() {
        return getPropertyDefinition().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignalDefinition() {
		if (signalDefinitionEClass == null) {
			signalDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(116);
		}
		return signalDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSignalDefinition__MatchForStub__UnitDefinition() {
        return getSignalDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSignalDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getSignalDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSignalDefinition__IsSameKindAs__ElementReference() {
        return getSignalDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSignalDefinition__SignalDefinitionSpecializationReferent__DiagnosticChain_Map() {
        return getSignalDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActiveClassDefinition() {
		if (activeClassDefinitionEClass == null) {
			activeClassDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(117);
		}
		return activeClassDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActiveClassDefinition_ClassifierBehavior() {
        return (EReference)getActiveClassDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActiveClassDefinition__MatchForStub__UnitDefinition() {
        return getActiveClassDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActiveClassDefinition__ActiveClassDefinitionClassifierBehavior__DiagnosticChain_Map() {
        return getActiveClassDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityDefinition() {
		if (activityDefinitionEClass == null) {
			activityDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(118);
		}
		return activityDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityDefinition_Body() {
        return (EReference)getActivityDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActivityDefinition__AssignmentsBefore__SyntaxElement() {
        return getActivityDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActivityDefinition__OuterScope() {
        return getActivityDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActivityDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getActivityDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActivityDefinition__MatchForStub__UnitDefinition() {
        return getActivityDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActivityDefinition__IsSameKindAs__ElementReference() {
        return getActivityDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActivityDefinition__ActivityDefinitionSpecialization__DiagnosticChain_Map() {
        return getActivityDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActivityDefinition__ActivityDefinitionPrimitive__DiagnosticChain_Map() {
        return getActivityDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementImportReference() {
		if (elementImportReferenceEClass == null) {
			elementImportReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(119);
		}
		return elementImportReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementImportReference_Alias() {
        return (EAttribute)getElementImportReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementImportReference__ImportedMembers() {
        return getElementImportReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElementImportReference__ElementImportReferenceReferent__DiagnosticChain_Map() {
        return getElementImportReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignalReceptionDefinition() {
		if (signalReceptionDefinitionEClass == null) {
			signalReceptionDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(120);
		}
		return signalReceptionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSignalReceptionDefinition__IsFeature() {
        return getSignalReceptionDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSignalReceptionDefinition__SignalReceptionDefinitionIsFeatureDerivation__DiagnosticChain_Map() {
        return getSignalReceptionDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationDefinition() {
		if (enumerationDefinitionEClass == null) {
			enumerationDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(121);
		}
		return enumerationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEnumerationDefinition__MatchForStub__UnitDefinition() {
        return getEnumerationDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEnumerationDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getEnumerationDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEnumerationDefinition__IsSameKindAs__ElementReference() {
        return getEnumerationDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEnumerationDefinition__EnumerationDefinitionSpecializationReferent__DiagnosticChain_Map() {
        return getEnumerationDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageImportReference() {
		if (packageImportReferenceEClass == null) {
			packageImportReferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(122);
		}
		return packageImportReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPackageImportReference__ImportedMembers() {
        return getPackageImportReference().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPackageImportReference__PackageImportReferenceReferent__DiagnosticChain_Map() {
        return getPackageImportReference().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierTemplateParameter() {
		if (classifierTemplateParameterEClass == null) {
			classifierTemplateParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(123);
		}
		return classifierTemplateParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierTemplateParameter__AnnotationAllowed__StereotypeAnnotation() {
        return getClassifierTemplateParameter().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierTemplateParameter__MatchForStub__UnitDefinition() {
        return getClassifierTemplateParameter().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierTemplateParameter__IsSameKindAs__ElementReference() {
        return getClassifierTemplateParameter().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifierTemplateParameter__Matches__ClassifierTemplateParameter() {
        return getClassifierTemplateParameter().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormalParameter() {
		if (formalParameterEClass == null) {
			formalParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(124);
		}
		return formalParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormalParameter_Direction() {
        return (EAttribute)getFormalParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormalParameter_TypePart() {
        return (EReference)getFormalParameter().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormalParameter__CurrentScope() {
        return getFormalParameter().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormalParameter__AnnotationAllowed__StereotypeAnnotation() {
        return getFormalParameter().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormalParameter__IsSameKindAs__ElementReference() {
        return getFormalParameter().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormalParameter__Matches__FormalParameter() {
        return getFormalParameter().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormalParameter__MatchesElement__ElementReference() {
        return getFormalParameter().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormalParameter__MatchesNameType__ElementReference() {
        return getFormalParameter().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormalParameter__MatchesType__ElementReference() {
        return getFormalParameter().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceptionDefinition() {
		if (receptionDefinitionEClass == null) {
			receptionDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(125);
		}
		return receptionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceptionDefinition_SignalName() {
        return (EReference)getReceptionDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceptionDefinition_Signal() {
        return (EReference)getReceptionDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReceptionDefinition__ActualName() {
        return getReceptionDefinition().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReceptionDefinition__AnnotationAllowed__StereotypeAnnotation() {
        return getReceptionDefinition().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReceptionDefinition__IsSameKindAs__ElementReference() {
        return getReceptionDefinition().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReceptionDefinition__IsFeature() {
        return getReceptionDefinition().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReceptionDefinition__ReceptionDefinitionSignalName__DiagnosticChain_Map() {
        return getReceptionDefinition().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReceptionDefinition__ReceptionDefinitionSignalDerivation__DiagnosticChain_Map() {
        return getReceptionDefinition().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReceptionDefinition__ReceptionDefinitionIsFeatureDerivation__DiagnosticChain_Map() {
        return getReceptionDefinition().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMember() {
		if (memberEClass == null) {
			memberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(126);
		}
		return memberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMember_Definition() {
        return (EReference)getMember().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMember_Visibility() {
        return (EAttribute)getMember().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMember_Namespace() {
        return (EReference)getMember().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMember_Annotation() {
        return (EReference)getMember().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMember__ToReference() {
        return getMember().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMember__Visibility() {
        return getMember().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotatedStatement() {
		if (annotatedStatementEClass == null) {
			annotatedStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(127);
		}
		return annotatedStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotatedStatement_Annotation() {
        return (EAttribute)getAnnotatedStatement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotatedStatement_Statement() {
        return (EReference)getAnnotatedStatement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnnotatedStatement__Annotations() {
        return getAnnotatedStatement().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundClassifier() {
		if (boundClassifierEClass == null) {
			boundClassifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(128);
		}
		return boundClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundClassifier_Template() {
        return (EReference)getBoundClassifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundClassifier_Actual() {
        return (EReference)getBoundClassifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBoundClassifier__ToReference() {
        return getBoundClassifier().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnParameter() {
		if (returnParameterEClass == null) {
			returnParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(129);
		}
		return returnParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonReturnParameter() {
		if (nonReturnParameterEClass == null) {
			nonReturnParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(130);
		}
		return nonReturnParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnyType() {
		if (anyTypeEClass == null) {
			anyTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI).getEClassifiers().get(131);
		}
		return anyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnyType__ActualName() {
        return getAnyType().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlfFactory getAlfFactory() {
		return (AlfFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.eclipse.papyrus.uml.alf." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} // AlfPackageImpl
