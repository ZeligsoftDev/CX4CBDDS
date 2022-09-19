/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMFactory;
import dds4ccm.DDS4CCMPackage;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DDS4CCMPackageImpl extends EPackageImpl implements DDS4CCMPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "dds4ccm.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralRealizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass homeImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managesImplEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managesImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass monolithicImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workerFunctionIdentifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccmPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccmConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messagePortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portTypeableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workerFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conjugatedPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccmComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managesEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxModuleContainedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass homeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dds4CCMModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idl3PlusModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccmModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxwStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxBoundedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxTypedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxClassifierContainedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxAnonymousArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxAnonymousSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxBoxedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxUnionFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxConstantsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxConstructedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxDefaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxEnumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxExceptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxPrimitiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxStructEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensibleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxSupportsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxTypeDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxUnionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxValueFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cxParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentAssemblyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorAssemblyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateModuleAliasEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfacePortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nativeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topicFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass historyQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifespanQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass durationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ownershipQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wdlQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rdlQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass udQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tdQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tpQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deadlineQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lbQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tbfQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gdQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass efQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rlQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reliabilityQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dsQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass livelinessQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass durabilityQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doQosPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qosPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ddsMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qoSProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qoSForEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qoSEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReaderQoSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReaderWriterQoSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantQoSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publisherQoSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publisherSubscriberQoSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subscriberQoSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topicQoSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataWriterQoSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interconnectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interconnectInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bridgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bridgeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementSatisfierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourcePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sharedResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass satisfierPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentPlanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentDeploymentPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetAssemblyConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedPortTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idlFileSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idlFileDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorDefaultValueBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idlIncludeDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workerFunctionImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorStatusListenerConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finderOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass homeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass factoryOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass homeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hideableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass perPortConnectorTypeDeploymentPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainDeploymentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum componentCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wiringKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum modelTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cxPrimitiveKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum extensibilityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeConstraintEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum topicKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum historyQosPolicyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ownershipQosPolicyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum presentationQosPolicyAccessScopeKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum realiabilityQosPolicyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum livelinessQosPolicyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum durabilityQosPolicyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum destinationOrderQosPolicyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum satisfierPropertyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum configurationSlotKindEEnum = null;

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
	 * @see dds4ccm.DDS4CCMPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DDS4CCMPackageImpl() {
		super(eNS_URI, DDS4CCMFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DDS4CCMPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static DDS4CCMPackage init() {
		if (isInited) return (DDS4CCMPackage)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDDS4CCMPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DDS4CCMPackageImpl theDDS4CCMPackage = registeredDDS4CCMPackage instanceof DDS4CCMPackageImpl ? (DDS4CCMPackageImpl)registeredDDS4CCMPackage : new DDS4CCMPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Load packages
		theDDS4CCMPackage.loadPackage();

		// Fix loaded packages
		theDDS4CCMPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theDDS4CCMPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DDS4CCMPackage.eNS_URI, theDDS4CCMPackage);
		return theDDS4CCMPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssemblyImplementation() {
		if (assemblyImplementationEClass == null) {
			assemblyImplementationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(0);
		}
		return assemblyImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssemblyImplementation_Base_NamedElement() {
        return (EReference)getAssemblyImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuralRealization() {
		if (structuralRealizationEClass == null) {
			structuralRealizationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(1);
		}
		return structuralRealizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuralRealization_Base_Component() {
        return (EReference)getStructuralRealization().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHomeImplementation() {
		if (homeImplementationEClass == null) {
			homeImplementationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(2);
		}
		return homeImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getManagesImplEnd() {
		if (managesImplEndEClass == null) {
			managesImplEndEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(3);
		}
		return managesImplEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getManagesImpl() {
		if (managesImplEClass == null) {
			managesImplEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(4);
		}
		return managesImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getManagesImpl_Base_Dependency() {
        return (EReference)getManagesImpl().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMonolithicImplementation() {
		if (monolithicImplementationEClass == null) {
			monolithicImplementationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(5);
		}
		return monolithicImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMonolithicImplementation_Category() {
        return (EAttribute)getMonolithicImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMonolithicImplementation_Base_NamedElement() {
        return (EReference)getMonolithicImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImplementation() {
		if (implementationEClass == null) {
			implementationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(6);
		}
		return implementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWorkerFunctionIdentifiable() {
		if (workerFunctionIdentifiableEClass == null) {
			workerFunctionIdentifiableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(7);
		}
		return workerFunctionIdentifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWorkerFunctionIdentifiable_Uuid() {
        return (EAttribute)getWorkerFunctionIdentifiable().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCCMPart() {
		if (ccmPartEClass == null) {
			ccmPartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(9);
		}
		return ccmPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCCMPart_Base_NamedElement() {
        return (EReference)getCCMPart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPart() {
		if (partEClass == null) {
			partEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(10);
		}
		return partEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPart_Base_Property() {
        return (EReference)getPart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCCMConnector() {
		if (ccmConnectorEClass == null) {
			ccmConnectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(11);
		}
		return ccmConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssemblyConnector() {
		if (assemblyConnectorEClass == null) {
			assemblyConnectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(12);
		}
		return assemblyConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssemblyConnector_PortEnd() {
        return (EReference)getAssemblyConnector().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssemblyConnector_Base_Connector() {
        return (EReference)getAssemblyConnector().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPort() {
		if (portEClass == null) {
			portEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(13);
		}
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPort_Wiring() {
        return (EAttribute)getPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPort_Base_Port() {
        return (EReference)getPort().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypedElement() {
		if (typedElementEClass == null) {
			typedElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(14);
		}
		return typedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComponentInterface() {
		if (componentInterfaceEClass == null) {
			componentInterfaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(16);
		}
		return componentInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComponentInterface_Base_Component() {
        return (EReference)getComponentInterface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFlowPort() {
		if (flowPortEClass == null) {
			flowPortEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(17);
		}
		return flowPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMessagePort() {
		if (messagePortEClass == null) {
			messagePortEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(18);
		}
		return messagePortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterface() {
		if (interfaceEClass == null) {
			interfaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(19);
		}
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_Base_Interface() {
        return (EReference)getInterface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPortTypeable() {
		if (portTypeableEClass == null) {
			portTypeableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(20);
		}
		return portTypeableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWorkerFunction() {
		if (workerFunctionEClass == null) {
			workerFunctionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(21);
		}
		return workerFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWorkerFunction_ReceivingPort() {
        return (EReference)getWorkerFunction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWorkerFunction_PortOperation() {
        return (EReference)getWorkerFunction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWorkerFunction_Body() {
        return (EAttribute)getWorkerFunction().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWorkerFunction_Uuid() {
        return (EAttribute)getWorkerFunction().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWorkerFunction_Delegate() {
        return (EAttribute)getWorkerFunction().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWorkerFunction_Base_Operation() {
        return (EReference)getWorkerFunction().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPortType() {
		if (portTypeEClass == null) {
			portTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(22);
		}
		return portTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPortType_Inverse() {
        return (EReference)getPortType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPortType_Base_Class() {
        return (EReference)getPortType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComponentImplementation() {
		if (componentImplementationEClass == null) {
			componentImplementationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(23);
		}
		return componentImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComponentImplementation_Base_Manifestation() {
        return (EReference)getComponentImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameter() {
		if (parameterEClass == null) {
			parameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(24);
		}
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_Base_Parameter() {
        return (EReference)getParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModel() {
		if (modelEClass == null) {
			modelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(25);
		}
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModel_Base_Model() {
        return (EReference)getModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEventPort() {
		if (eventPortEClass == null) {
			eventPortEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(26);
		}
		return eventPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConjugatedPort() {
		if (conjugatedPortEClass == null) {
			conjugatedPortEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(27);
		}
		return conjugatedPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConjugatedPort_IsConjugated() {
        return (EAttribute)getConjugatedPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCCMComponent() {
		if (ccmComponentEClass == null) {
			ccmComponentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(28);
		}
		return ccmComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getManagesEnd() {
		if (managesEndEClass == null) {
			managesEndEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(29);
		}
		return managesEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXModuleContained() {
		if (cxModuleContainedEClass == null) {
			cxModuleContainedEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(30);
		}
		return cxModuleContainedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXNamedElement() {
		if (cxNamedElementEClass == null) {
			cxNamedElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(31);
		}
		return cxNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXNamedElement_Base_NamedElement() {
        return (EReference)getCXNamedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXType() {
		if (cxTypeEClass == null) {
			cxTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(32);
		}
		return cxTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEvent() {
		if (eventEClass == null) {
			eventEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(33);
		}
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEvent_IsCustom() {
        return (EAttribute)getEvent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEvent_IsTruncatable() {
        return (EAttribute)getEvent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHome() {
		if (homeEClass == null) {
			homeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(34);
		}
		return homeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHome_Base_Class() {
        return (EReference)getHome().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getManages() {
		if (managesEClass == null) {
			managesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(35);
		}
		return managesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getManages_Base_Dependency() {
        return (EReference)getManages().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDDS4CCMModel() {
		if (dds4CCMModelEClass == null) {
			dds4CCMModelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(36);
		}
		return dds4CCMModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDDS4CCMModel_LocationPrefix() {
        return (EAttribute)getDDS4CCMModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDDS4CCMModel_FixedHeader() {
        return (EAttribute)getDDS4CCMModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDDS4CCMModel_FixedFooter() {
        return (EAttribute)getDDS4CCMModel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDDS4CCMModel_ModelType() {
        return (EAttribute)getDDS4CCMModel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDL3PlusModel() {
		if (idl3PlusModelEClass == null) {
			idl3PlusModelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(37);
		}
		return idl3PlusModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCCMModel() {
		if (ccmModelEClass == null) {
			ccmModelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(38);
		}
		return ccmModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCCMModel_Base_NamedElement() {
        return (EReference)getCCMModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXWString() {
		if (cxwStringEClass == null) {
			cxwStringEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(40);
		}
		return cxwStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXBounded() {
		if (cxBoundedEClass == null) {
			cxBoundedEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(41);
		}
		return cxBoundedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXBounded_Bounds() {
        return (EReference)getCXBounded().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXBounded_Bound() {
        return (EAttribute)getCXBounded().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXBounded_Base_DataType() {
        return (EReference)getCXBounded().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXBound() {
		if (cxBoundEClass == null) {
			cxBoundEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(42);
		}
		return cxBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXBound_Constant() {
        return (EReference)getCXBound().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXBound_Value() {
        return (EAttribute)getCXBound().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXConstant() {
		if (cxConstantEClass == null) {
			cxConstantEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(43);
		}
		return cxConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXConstant_Base_Property() {
        return (EReference)getCXConstant().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXTyped() {
		if (cxTypedEClass == null) {
			cxTypedEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(44);
		}
		return cxTypedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXClassifierContained() {
		if (cxClassifierContainedEClass == null) {
			cxClassifierContainedEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(45);
		}
		return cxClassifierContainedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXAnonymousArray() {
		if (cxAnonymousArrayEClass == null) {
			cxAnonymousArrayEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(46);
		}
		return cxAnonymousArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXAnonymousArray_Base_DataType() {
        return (EReference)getCXAnonymousArray().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXAnonymousSequence() {
		if (cxAnonymousSequenceEClass == null) {
			cxAnonymousSequenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(47);
		}
		return cxAnonymousSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXAnonymousSequence_Base_DataType() {
        return (EReference)getCXAnonymousSequence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXArray() {
		if (cxArrayEClass == null) {
			cxArrayEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(48);
		}
		return cxArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXArray_Bounds() {
        return (EReference)getCXArray().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXArray_Index() {
        return (EAttribute)getCXArray().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXTemplate() {
		if (cxTemplateEClass == null) {
			cxTemplateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(49);
		}
		return cxTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXTemplate_Base_DataType() {
        return (EReference)getCXTemplate().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContained() {
		if (containedEClass == null) {
			containedEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(50);
		}
		return containedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXBoxedValue() {
		if (cxBoxedValueEClass == null) {
			cxBoxedValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(51);
		}
		return cxBoxedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXWrapper() {
		if (cxWrapperEClass == null) {
			cxWrapperEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(52);
		}
		return cxWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXWrapper_Base_DataType() {
        return (EReference)getCXWrapper().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXCase() {
		if (cxCaseEClass == null) {
			cxCaseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(53);
		}
		return cxCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXCase_Label() {
        return (EAttribute)getCXCase().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXUnionField() {
		if (cxUnionFieldEClass == null) {
			cxUnionFieldEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(54);
		}
		return cxUnionFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXUnionField_Base_Property() {
        return (EReference)getCXUnionField().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXConstants() {
		if (cxConstantsEClass == null) {
			cxConstantsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(55);
		}
		return cxConstantsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXConstants_Base_Class() {
        return (EReference)getCXConstants().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXConstructed() {
		if (cxConstructedEClass == null) {
			cxConstructedEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(56);
		}
		return cxConstructedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXConstructed_Base_DataType() {
        return (EReference)getCXConstructed().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXDefault() {
		if (cxDefaultEClass == null) {
			cxDefaultEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(57);
		}
		return cxDefaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXEnum() {
		if (cxEnumEClass == null) {
			cxEnumEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(58);
		}
		return cxEnumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXEnum_Base_Enumeration() {
        return (EReference)getCXEnum().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXException() {
		if (cxExceptionEClass == null) {
			cxExceptionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(59);
		}
		return cxExceptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXInterface() {
		if (cxInterfaceEClass == null) {
			cxInterfaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(60);
		}
		return cxInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXInterface_IsLocal() {
        return (EAttribute)getCXInterface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXInterface_IsAsynchronous() {
        return (EAttribute)getCXInterface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXClassifier() {
		if (cxClassifierEClass == null) {
			cxClassifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(61);
		}
		return cxClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXPrimitive() {
		if (cxPrimitiveEClass == null) {
			cxPrimitiveEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(62);
		}
		return cxPrimitiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXPrimitive_Type() {
        return (EAttribute)getCXPrimitive().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXPrimitive_Base_DataType() {
        return (EReference)getCXPrimitive().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXSequence() {
		if (cxSequenceEClass == null) {
			cxSequenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(64);
		}
		return cxSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXSequence_Bounds() {
        return (EReference)getCXSequence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXSequence_Bound() {
        return (EAttribute)getCXSequence().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXString() {
		if (cxStringEClass == null) {
			cxStringEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(65);
		}
		return cxStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXStruct() {
		if (cxStructEClass == null) {
			cxStructEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(66);
		}
		return cxStructEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExtensible() {
		if (extensibleEClass == null) {
			extensibleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(67);
		}
		return extensibleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExtensible_Extensibility() {
        return (EAttribute)getExtensible().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXSupports() {
		if (cxSupportsEClass == null) {
			cxSupportsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(69);
		}
		return cxSupportsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXSupports_Base_Generalization() {
        return (EReference)getCXSupports().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXTypeDef() {
		if (cxTypeDefEClass == null) {
			cxTypeDefEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(70);
		}
		return cxTypeDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXTypeDef_Type() {
        return (EReference)getCXTypeDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXUnion() {
		if (cxUnionEClass == null) {
			cxUnionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(71);
		}
		return cxUnionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXValue() {
		if (cxValueEClass == null) {
			cxValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(72);
		}
		return cxValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXValue_IsCustom() {
        return (EAttribute)getCXValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXValue_IsTruncatable() {
        return (EAttribute)getCXValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXValue_Base_Interface() {
        return (EReference)getCXValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXValueFactory() {
		if (cxValueFactoryEClass == null) {
			cxValueFactoryEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(73);
		}
		return cxValueFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXValueFactory_Base_Operation() {
        return (EReference)getCXValueFactory().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXModule() {
		if (cxModuleEClass == null) {
			cxModuleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(74);
		}
		return cxModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXModule_Base_Package() {
        return (EReference)getCXModule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXAttribute() {
		if (cxAttributeEClass == null) {
			cxAttributeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(75);
		}
		return cxAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXAttribute_Setraises() {
        return (EReference)getCXAttribute().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXAttribute_Getraises() {
        return (EReference)getCXAttribute().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXAttribute_Base_Property() {
        return (EReference)getCXAttribute().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXOperation() {
		if (cxOperationEClass == null) {
			cxOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(76);
		}
		return cxOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXOperation_IdlType() {
        return (EReference)getCXOperation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXOperation_IsOneWay() {
        return (EAttribute)getCXOperation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXOperation_Base_Operation() {
        return (EReference)getCXOperation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXField() {
		if (cxFieldEClass == null) {
			cxFieldEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(77);
		}
		return cxFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXField_Bounds() {
        return (EReference)getCXField().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCXField_Bound() {
        return (EAttribute)getCXField().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXField_Base_Property() {
        return (EReference)getCXField().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCXParameter() {
		if (cxParameterEClass == null) {
			cxParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(78);
		}
		return cxParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCXParameter_Base_Parameter() {
        return (EReference)getCXParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateMember() {
		if (stateMemberEClass == null) {
			stateMemberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(79);
		}
		return stateMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateMember_Base_Property() {
        return (EReference)getStateMember().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectorDef() {
		if (connectorDefEClass == null) {
			connectorDefEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(80);
		}
		return connectorDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectorFragment() {
		if (connectorFragmentEClass == null) {
			connectorFragmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(81);
		}
		return connectorFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFragmentImplementation() {
		if (fragmentImplementationEClass == null) {
			fragmentImplementationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(82);
		}
		return fragmentImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFragmentAssembly() {
		if (fragmentAssemblyEClass == null) {
			fragmentAssemblyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(83);
		}
		return fragmentAssemblyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectorImplementation() {
		if (connectorImplementationEClass == null) {
			connectorImplementationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(84);
		}
		return connectorImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectorAssembly() {
		if (connectorAssemblyEClass == null) {
			connectorAssemblyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(85);
		}
		return connectorAssemblyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFragmentPart() {
		if (fragmentPartEClass == null) {
			fragmentPartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(86);
		}
		return fragmentPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypedConnector() {
		if (typedConnectorEClass == null) {
			typedConnectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(87);
		}
		return typedConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedConnector_ConnectorType() {
        return (EReference)getTypedConnector().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeParameter() {
		if (typeParameterEClass == null) {
			typeParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(88);
		}
		return typeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypeParameter_Constraint() {
        return (EAttribute)getTypeParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeParameter_Base_ClassifierTemplateParameter() {
        return (EReference)getTypeParameter().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateModule() {
		if (templateModuleEClass == null) {
			templateModuleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(90);
		}
		return templateModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateModule_Base_Package() {
        return (EReference)getTemplateModule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModuleInstantiation() {
		if (moduleInstantiationEClass == null) {
			moduleInstantiationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(91);
		}
		return moduleInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModuleInstantiation_Base_Package() {
        return (EReference)getModuleInstantiation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameterBinding() {
		if (parameterBindingEClass == null) {
			parameterBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(92);
		}
		return parameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameterBinding_Base_TemplateParameterSubstitution() {
        return (EReference)getParameterBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateModuleAlias() {
		if (templateModuleAliasEClass == null) {
			templateModuleAliasEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(93);
		}
		return templateModuleAliasEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModuleBinding() {
		if (moduleBindingEClass == null) {
			moduleBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(94);
		}
		return moduleBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModuleBinding_Base_TemplateBinding() {
        return (EReference)getModuleBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateSignature() {
		if (templateSignatureEClass == null) {
			templateSignatureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(95);
		}
		return templateSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateSignature_Base_TemplateSignature() {
        return (EReference)getTemplateSignature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterfacePort() {
		if (interfacePortEClass == null) {
			interfacePortEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(96);
		}
		return interfacePortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterfacePort_ConnectorType() {
        return (EReference)getInterfacePort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterfacePort_IsAsynchronous() {
        return (EAttribute)getInterfacePort().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterfacePort_HasCSL() {
        return (EAttribute)getInterfacePort().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNative() {
		if (nativeEClass == null) {
			nativeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(97);
		}
		return nativeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNative_Base_DataType() {
        return (EReference)getNative().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataSpace() {
		if (dataSpaceEClass == null) {
			dataSpaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(98);
		}
		return dataSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSpace_Base_NamedElement() {
        return (EReference)getDataSpace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTopic() {
		if (topicEClass == null) {
			topicEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(99);
		}
		return topicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTopic_Expression() {
        return (EAttribute)getTopic().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTopic_Kind() {
        return (EAttribute)getTopic().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopic_Base_Class() {
        return (EReference)getTopic().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTopicField() {
		if (topicFieldEClass == null) {
			topicFieldEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(101);
		}
		return topicFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopicField_Base_Property() {
        return (EReference)getTopicField().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getqosPolicy() {
		if (qosPolicyEClass == null) {
			qosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(102);
		}
		return qosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getqosPolicy_Base_Class() {
        return (EReference)getqosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass gethistoryQosPolicy() {
		if (historyQosPolicyEClass == null) {
			historyQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(103);
		}
		return historyQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute gethistoryQosPolicy_Depth() {
        return (EAttribute)gethistoryQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute gethistoryQosPolicy_Kind() {
        return (EAttribute)gethistoryQosPolicy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getlifespanQosPolicy() {
		if (lifespanQosPolicyEClass == null) {
			lifespanQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(105);
		}
		return lifespanQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getlifespanQosPolicy_Duration() {
        return (EReference)getlifespanQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDuration() {
		if (durationEClass == null) {
			durationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(106);
		}
		return durationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDuration_Second() {
        return (EAttribute)getDuration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDuration_Nanosecond() {
        return (EAttribute)getDuration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getownershipQosPolicy() {
		if (ownershipQosPolicyEClass == null) {
			ownershipQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(107);
		}
		return ownershipQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getownershipQosPolicy_Kind() {
        return (EAttribute)getownershipQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getosQosPolicy() {
		if (osQosPolicyEClass == null) {
			osQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(109);
		}
		return osQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getosQosPolicy_Value() {
        return (EAttribute)getosQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getwdlQosPolicy() {
		if (wdlQosPolicyEClass == null) {
			wdlQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(110);
		}
		return wdlQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getwdlQosPolicy_Autodispose_unregistered_instances() {
        return (EAttribute)getwdlQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getrdlQosPolicy() {
		if (rdlQosPolicyEClass == null) {
			rdlQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(111);
		}
		return rdlQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getrdlQosPolicy_Autopurge_nowriter_samples_delay() {
        return (EReference)getrdlQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getrdlQosPolicy_Autopurge_disposed_samples_delay() {
        return (EReference)getrdlQosPolicy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getudQosPolicy() {
		if (udQosPolicyEClass == null) {
			udQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(112);
		}
		return udQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getudQosPolicy_Value() {
        return (EAttribute)getudQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass gettdQosPolicy() {
		if (tdQosPolicyEClass == null) {
			tdQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(113);
		}
		return tdQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute gettdQosPolicy_Value() {
        return (EAttribute)gettdQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass gettpQosPolicy() {
		if (tpQosPolicyEClass == null) {
			tpQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(114);
		}
		return tpQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute gettpQosPolicy_Value() {
        return (EAttribute)gettpQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getdeadlineQosPolicy() {
		if (deadlineQosPolicyEClass == null) {
			deadlineQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(115);
		}
		return deadlineQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getdeadlineQosPolicy_Period() {
        return (EReference)getdeadlineQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getlbQosPolicy() {
		if (lbQosPolicyEClass == null) {
			lbQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(116);
		}
		return lbQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getlbQosPolicy_Duration() {
        return (EReference)getlbQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass gettbfQosPolicy() {
		if (tbfQosPolicyEClass == null) {
			tbfQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(117);
		}
		return tbfQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference gettbfQosPolicy_Minimum_separation() {
        return (EReference)gettbfQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getgdQosPolicy() {
		if (gdQosPolicyEClass == null) {
			gdQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(118);
		}
		return gdQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getgdQosPolicy_Value() {
        return (EAttribute)getgdQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getefQosPolicy() {
		if (efQosPolicyEClass == null) {
			efQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(119);
		}
		return efQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getefQosPolicy_Autoenable_created_entities() {
        return (EAttribute)getefQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getrlQosPolicy() {
		if (rlQosPolicyEClass == null) {
			rlQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(120);
		}
		return rlQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getrlQosPolicy_Max_instances() {
        return (EAttribute)getrlQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getrlQosPolicy_Max_samples() {
        return (EAttribute)getrlQosPolicy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getrlQosPolicy_Max_samples_per_instance() {
        return (EAttribute)getrlQosPolicy().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getpresentationQosPolicy() {
		if (presentationQosPolicyEClass == null) {
			presentationQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(121);
		}
		return presentationQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getpresentationQosPolicy_Access_scope() {
        return (EAttribute)getpresentationQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getpresentationQosPolicy_Coherent_access() {
        return (EAttribute)getpresentationQosPolicy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getpresentationQosPolicy_Ordered_access() {
        return (EAttribute)getpresentationQosPolicy().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getpartitionQosPolicy() {
		if (partitionQosPolicyEClass == null) {
			partitionQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(123);
		}
		return partitionQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getpartitionQosPolicy_Name() {
        return (EAttribute)getpartitionQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getreliabilityQosPolicy() {
		if (reliabilityQosPolicyEClass == null) {
			reliabilityQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(124);
		}
		return reliabilityQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getreliabilityQosPolicy_Max_blocking_time() {
        return (EReference)getreliabilityQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getreliabilityQosPolicy_Kind() {
        return (EAttribute)getreliabilityQosPolicy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getdsQosPolicy() {
		if (dsQosPolicyEClass == null) {
			dsQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(126);
		}
		return dsQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getdsQosPolicy_Service_cleanup_delay() {
        return (EReference)getdsQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getdsQosPolicy_History_kind() {
        return (EAttribute)getdsQosPolicy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getdsQosPolicy_Max_instances() {
        return (EAttribute)getdsQosPolicy().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getdsQosPolicy_Max_samples() {
        return (EAttribute)getdsQosPolicy().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getdsQosPolicy_Max_samples_per_instance() {
        return (EAttribute)getdsQosPolicy().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getdsQosPolicy_History_depth() {
        return (EAttribute)getdsQosPolicy().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getlivelinessQosPolicy() {
		if (livelinessQosPolicyEClass == null) {
			livelinessQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(127);
		}
		return livelinessQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getlivelinessQosPolicy_Lease_duration() {
        return (EReference)getlivelinessQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getlivelinessQosPolicy_Kind() {
        return (EAttribute)getlivelinessQosPolicy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getdurabilityQosPolicy() {
		if (durabilityQosPolicyEClass == null) {
			durabilityQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(129);
		}
		return durabilityQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getdurabilityQosPolicy_Kind() {
        return (EAttribute)getdurabilityQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getdoQosPolicy() {
		if (doQosPolicyEClass == null) {
			doQosPolicyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(131);
		}
		return doQosPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getdoQosPolicy_Kind() {
        return (EAttribute)getdoQosPolicy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getqosProperty() {
		if (qosPropertyEClass == null) {
			qosPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(133);
		}
		return qosPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getqosProperty_Base_Property() {
        return (EReference)getqosProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDDSMessage() {
		if (ddsMessageEClass == null) {
			ddsMessageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(134);
		}
		return ddsMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMessageField() {
		if (messageFieldEClass == null) {
			messageFieldEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(135);
		}
		return messageFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMessageField_IsKey() {
        return (EAttribute)getMessageField().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQoSProfile() {
		if (qoSProfileEClass == null) {
			qoSProfileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(136);
		}
		return qoSProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQoSProfile_Filename() {
        return (EAttribute)getQoSProfile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQoSProfile_Base_Class() {
        return (EReference)getQoSProfile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQoSForEntity() {
		if (qoSForEntityEClass == null) {
			qoSForEntityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(137);
		}
		return qoSForEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQoSForEntity_Base_Class() {
        return (EReference)getQoSForEntity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQoSEntity() {
		if (qoSEntityEClass == null) {
			qoSEntityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(138);
		}
		return qoSEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQoSEntity_Base_Property() {
        return (EReference)getQoSEntity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataReaderQoS() {
		if (dataReaderQoSEClass == null) {
			dataReaderQoSEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(139);
		}
		return dataReaderQoSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataReaderWriterQoS() {
		if (dataReaderWriterQoSEClass == null) {
			dataReaderWriterQoSEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(140);
		}
		return dataReaderWriterQoSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParticipantQoS() {
		if (participantQoSEClass == null) {
			participantQoSEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(141);
		}
		return participantQoSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPublisherQoS() {
		if (publisherQoSEClass == null) {
			publisherQoSEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(142);
		}
		return publisherQoSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPublisherSubscriberQoS() {
		if (publisherSubscriberQoSEClass == null) {
			publisherSubscriberQoSEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(143);
		}
		return publisherSubscriberQoSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSubscriberQoS() {
		if (subscriberQoSEClass == null) {
			subscriberQoSEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(144);
		}
		return subscriberQoSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTopicQoS() {
		if (topicQoSEClass == null) {
			topicQoSEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(145);
		}
		return topicQoSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataWriterQoS() {
		if (dataWriterQoSEClass == null) {
			dataWriterQoSEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(146);
		}
		return dataWriterQoSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomain() {
		if (domainEClass == null) {
			domainEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(147);
		}
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomain_Label() {
        return (EAttribute)getDomain().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomain_UUID() {
        return (EAttribute)getDomain().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomain_Base_Component() {
        return (EReference)getDomain().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNode() {
		if (nodeEClass == null) {
			nodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(148);
		}
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Base_Component() {
        return (EReference)getNode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeInstance() {
		if (nodeInstanceEClass == null) {
			nodeInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(149);
		}
		return nodeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNodeInstance_Label() {
        return (EAttribute)getNodeInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeInstance_Base_Property() {
        return (EReference)getNodeInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterconnect() {
		if (interconnectEClass == null) {
			interconnectEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(150);
		}
		return interconnectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterconnect_Base_Component() {
        return (EReference)getInterconnect().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterconnectInstance() {
		if (interconnectInstanceEClass == null) {
			interconnectInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(151);
		}
		return interconnectInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterconnectInstance_Label() {
        return (EAttribute)getInterconnectInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterconnectInstance_Base_Property() {
        return (EReference)getInterconnectInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBridge() {
		if (bridgeEClass == null) {
			bridgeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(152);
		}
		return bridgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBridge_Base_Component() {
        return (EReference)getBridge().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBridgeInstance() {
		if (bridgeInstanceEClass == null) {
			bridgeInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(153);
		}
		return bridgeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBridgeInstance_Label() {
        return (EAttribute)getBridgeInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBridgeInstance_Base_Property() {
        return (EReference)getBridgeInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResource() {
		if (resourceEClass == null) {
			resourceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(154);
		}
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequirementSatisfier() {
		if (requirementSatisfierEClass == null) {
			requirementSatisfierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(155);
		}
		return requirementSatisfierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequirementSatisfier_ResourceType() {
        return (EAttribute)getRequirementSatisfier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRequirementSatisfier_Base_Class() {
        return (EReference)getRequirementSatisfier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResourceProperty() {
		if (resourcePropertyEClass == null) {
			resourcePropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(156);
		}
		return resourcePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getResourceProperty_Base_Property() {
        return (EReference)getResourceProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSharedResource() {
		if (sharedResourceEClass == null) {
			sharedResourceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(157);
		}
		return sharedResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSatisfierProperty() {
		if (satisfierPropertyEClass == null) {
			satisfierPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(158);
		}
		return satisfierPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSatisfierProperty_Dynamic() {
        return (EAttribute)getSatisfierProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSatisfierProperty_Kind() {
        return (EAttribute)getSatisfierProperty().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSatisfierProperty_Value() {
        return (EAttribute)getSatisfierProperty().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSatisfierProperty_Base_Property() {
        return (EReference)getSatisfierProperty().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequirement() {
		if (requirementEClass == null) {
			requirementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(160);
		}
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRequirement_Property() {
        return (EReference)getRequirement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequirement_ResourceType() {
        return (EAttribute)getRequirement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRequirement_Base_Class() {
        return (EReference)getRequirement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeploymentPlan() {
		if (deploymentPlanEClass == null) {
			deploymentPlanEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(161);
		}
		return deploymentPlanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDeploymentPlan_Id() {
        return (EAttribute)getDeploymentPlan().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeployment() {
		if (deploymentEClass == null) {
			deploymentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(162);
		}
		return deploymentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeployment_Base_Component() {
        return (EReference)getDeployment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAllocation() {
		if (allocationEClass == null) {
			allocationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(163);
		}
		return allocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAllocation_Base_Dependency() {
        return (EReference)getAllocation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeploymentPart() {
		if (deploymentPartEClass == null) {
			deploymentPartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(164);
		}
		return deploymentPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeploymentPart_NestedPart() {
        return (EReference)getDeploymentPart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeploymentPart_Configuration() {
        return (EReference)getDeploymentPart().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeploymentPart_ModelElement() {
        return (EReference)getDeploymentPart().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeploymentPart_Base_Property() {
        return (EReference)getDeploymentPart().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfiguration() {
		if (configurationEClass == null) {
			configurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(165);
		}
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConfiguration_Base_Class() {
        return (EReference)getConfiguration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConfiguration_Base_InstanceSpecification() {
        return (EReference)getConfiguration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComponentDeploymentPart() {
		if (componentDeploymentPartEClass == null) {
			componentDeploymentPartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(166);
		}
		return componentDeploymentPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComponentDeploymentPart_SelectedImplementation() {
        return (EReference)getComponentDeploymentPart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComponentDeploymentPart_ImplementationConfiguration() {
        return (EReference)getComponentDeploymentPart().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBuildConfiguration() {
		if (buildConfigurationEClass == null) {
			buildConfigurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(167);
		}
		return buildConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfigurationSlot() {
		if (configurationSlotEClass == null) {
			configurationSlotEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(168);
		}
		return configurationSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfigurationSlot_SlotKind() {
        return (EAttribute)getConfigurationSlot().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConfigurationSlot_Base_Slot() {
        return (EReference)getConfigurationSlot().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTargetAssemblyConnector() {
		if (targetAssemblyConnectorEClass == null) {
			targetAssemblyConnectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(170);
		}
		return targetAssemblyConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContainerProcess() {
		if (containerProcessEClass == null) {
			containerProcessEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(171);
		}
		return containerProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContainerProcess_Base_Component() {
        return (EReference)getContainerProcess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateParameterType() {
		if (templateParameterTypeEClass == null) {
			templateParameterTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(172);
		}
		return templateParameterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateParameterType_Base_Class() {
        return (EReference)getTemplateParameterType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateParameterType_Base_DataType() {
        return (EReference)getTemplateParameterType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateParameterType_Base_Interface() {
        return (EReference)getTemplateParameterType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExtendedPortType() {
		if (extendedPortTypeEClass == null) {
			extendedPortTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(173);
		}
		return extendedPortTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDLFileSpecification() {
		if (idlFileSpecificationEClass == null) {
			idlFileSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(174);
		}
		return idlFileSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIDLFileSpecification_Base_Class() {
        return (EReference)getIDLFileSpecification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDLFileDependency() {
		if (idlFileDependencyEClass == null) {
			idlFileDependencyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(175);
		}
		return idlFileDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIDLFileDependency_Base_Dependency() {
        return (EReference)getIDLFileDependency().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProperty() {
		if (propertyEClass == null) {
			propertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(176);
		}
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProperty_Value() {
        return (EAttribute)getProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProperty_Base_Property() {
        return (EReference)getProperty().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectorDefaultValueBinding() {
		if (connectorDefaultValueBindingEClass == null) {
			connectorDefaultValueBindingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(177);
		}
		return connectorDefaultValueBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectorDefaultValueBinding_Definition() {
        return (EReference)getConnectorDefaultValueBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectorDefaultValueBinding_ConnectorInstance() {
        return (EReference)getConnectorDefaultValueBinding().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectorDefaultValueBinding_Base_Package() {
        return (EReference)getConnectorDefaultValueBinding().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDLIncludeDependency() {
		if (idlIncludeDependencyEClass == null) {
			idlIncludeDependencyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(178);
		}
		return idlIncludeDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIDLIncludeDependency_Base_Dependency() {
        return (EReference)getIDLIncludeDependency().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWorkerFunctionImpl() {
		if (workerFunctionImplEClass == null) {
			workerFunctionImplEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(179);
		}
		return workerFunctionImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWorkerFunctionImpl_Base_OpaqueBehavior() {
        return (EReference)getWorkerFunctionImpl().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectorStatusListenerConnection() {
		if (connectorStatusListenerConnectionEClass == null) {
			connectorStatusListenerConnectionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(180);
		}
		return connectorStatusListenerConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFinderOperation() {
		if (finderOperationEClass == null) {
			finderOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(181);
		}
		return finderOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHomeOperation() {
		if (homeOperationEClass == null) {
			homeOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(182);
		}
		return homeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHomeOperation_Base_Operation() {
        return (EReference)getHomeOperation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFactoryOperation() {
		if (factoryOperationEClass == null) {
			factoryOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(183);
		}
		return factoryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHomeInstance() {
		if (homeInstanceEClass == null) {
			homeInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(184);
		}
		return homeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHomeInstance_Base_NamedElement() {
        return (EReference)getHomeInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHideableElement() {
		if (hideableElementEClass == null) {
			hideableElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(185);
		}
		return hideableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHideableElement_Base_NamedElement() {
        return (EReference)getHideableElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPerPortConnectorTypeDeploymentPart() {
		if (perPortConnectorTypeDeploymentPartEClass == null) {
			perPortConnectorTypeDeploymentPartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(186);
		}
		return perPortConnectorTypeDeploymentPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainDefinition() {
		if (domainDefinitionEClass == null) {
			domainDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(187);
		}
		return domainDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainDeployment() {
		if (domainDeploymentEClass == null) {
			domainDeploymentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(188);
		}
		return domainDeploymentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getComponentCategory() {
		if (componentCategoryEEnum == null) {
			componentCategoryEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(8);
		}
		return componentCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getWiringKind() {
		if (wiringKindEEnum == null) {
			wiringKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(15);
		}
		return wiringKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getModelTypeEnum() {
		if (modelTypeEnumEEnum == null) {
			modelTypeEnumEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(39);
		}
		return modelTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCXPrimitiveKind() {
		if (cxPrimitiveKindEEnum == null) {
			cxPrimitiveKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(63);
		}
		return cxPrimitiveKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getExtensibilityKind() {
		if (extensibilityKindEEnum == null) {
			extensibilityKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(68);
		}
		return extensibilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTypeConstraint() {
		if (typeConstraintEEnum == null) {
			typeConstraintEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(89);
		}
		return typeConstraintEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTopicKind() {
		if (topicKindEEnum == null) {
			topicKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(100);
		}
		return topicKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getHistoryQosPolicyKind() {
		if (historyQosPolicyKindEEnum == null) {
			historyQosPolicyKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(104);
		}
		return historyQosPolicyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOwnershipQosPolicyKind() {
		if (ownershipQosPolicyKindEEnum == null) {
			ownershipQosPolicyKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(108);
		}
		return ownershipQosPolicyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPresentationQosPolicyAccessScopeKind() {
		if (presentationQosPolicyAccessScopeKindEEnum == null) {
			presentationQosPolicyAccessScopeKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(122);
		}
		return presentationQosPolicyAccessScopeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRealiabilityQosPolicyKind() {
		if (realiabilityQosPolicyKindEEnum == null) {
			realiabilityQosPolicyKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(125);
		}
		return realiabilityQosPolicyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getLivelinessQosPolicyKind() {
		if (livelinessQosPolicyKindEEnum == null) {
			livelinessQosPolicyKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(128);
		}
		return livelinessQosPolicyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDurabilityQosPolicyKind() {
		if (durabilityQosPolicyKindEEnum == null) {
			durabilityQosPolicyKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(130);
		}
		return durabilityQosPolicyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDestinationOrderQosPolicyKind() {
		if (destinationOrderQosPolicyKindEEnum == null) {
			destinationOrderQosPolicyKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(132);
		}
		return destinationOrderQosPolicyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSatisfierPropertyKind() {
		if (satisfierPropertyKindEEnum == null) {
			satisfierPropertyKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(159);
		}
		return satisfierPropertyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getConfigurationSlotKind() {
		if (configurationSlotKindEEnum == null) {
			configurationSlotKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DDS4CCMPackage.eNS_URI).getEClassifiers().get(169);
		}
		return configurationSlotKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DDS4CCMFactory getDDS4CCMFactory() {
		return (DDS4CCMFactory)getEFactoryInstance();
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
			eClassifier.setInstanceClassName("dds4ccm." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //DDS4CCMPackageImpl
