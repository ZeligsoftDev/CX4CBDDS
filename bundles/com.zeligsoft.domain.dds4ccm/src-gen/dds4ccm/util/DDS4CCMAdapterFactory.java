/**
 */
package dds4ccm.util;

import dds4ccm.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMPackage
 * @generated
 */
public class DDS4CCMAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DDS4CCMPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DDS4CCMAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DDS4CCMPackage.eINSTANCE;
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
	protected DDS4CCMSwitch<Adapter> modelSwitch =
		new DDS4CCMSwitch<Adapter>() {
			@Override
			public Adapter caseAssemblyImplementation(AssemblyImplementation object) {
				return createAssemblyImplementationAdapter();
			}
			@Override
			public Adapter caseStructuralRealization(StructuralRealization object) {
				return createStructuralRealizationAdapter();
			}
			@Override
			public Adapter caseHomeImplementation(HomeImplementation object) {
				return createHomeImplementationAdapter();
			}
			@Override
			public Adapter caseManagesImplEnd(ManagesImplEnd object) {
				return createManagesImplEndAdapter();
			}
			@Override
			public Adapter caseManagesImpl(ManagesImpl object) {
				return createManagesImplAdapter();
			}
			@Override
			public Adapter caseMonolithicImplementation(MonolithicImplementation object) {
				return createMonolithicImplementationAdapter();
			}
			@Override
			public Adapter caseImplementation(Implementation object) {
				return createImplementationAdapter();
			}
			@Override
			public Adapter caseWorkerFunctionIdentifiable(WorkerFunctionIdentifiable object) {
				return createWorkerFunctionIdentifiableAdapter();
			}
			@Override
			public Adapter caseCCMPart(CCMPart object) {
				return createCCMPartAdapter();
			}
			@Override
			public Adapter casePart(Part object) {
				return createPartAdapter();
			}
			@Override
			public Adapter caseCCMConnector(CCMConnector object) {
				return createCCMConnectorAdapter();
			}
			@Override
			public Adapter caseAssemblyConnector(AssemblyConnector object) {
				return createAssemblyConnectorAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseComponentInterface(ComponentInterface object) {
				return createComponentInterfaceAdapter();
			}
			@Override
			public Adapter caseFlowPort(FlowPort object) {
				return createFlowPortAdapter();
			}
			@Override
			public Adapter caseMessagePort(MessagePort object) {
				return createMessagePortAdapter();
			}
			@Override
			public Adapter caseInterface(Interface object) {
				return createInterfaceAdapter();
			}
			@Override
			public Adapter casePortTypeable(PortTypeable object) {
				return createPortTypeableAdapter();
			}
			@Override
			public Adapter caseWorkerFunction(WorkerFunction object) {
				return createWorkerFunctionAdapter();
			}
			@Override
			public Adapter casePortType(PortType object) {
				return createPortTypeAdapter();
			}
			@Override
			public Adapter caseComponentImplementation(ComponentImplementation object) {
				return createComponentImplementationAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseEventPort(EventPort object) {
				return createEventPortAdapter();
			}
			@Override
			public Adapter caseConjugatedPort(ConjugatedPort object) {
				return createConjugatedPortAdapter();
			}
			@Override
			public Adapter caseCCMComponent(CCMComponent object) {
				return createCCMComponentAdapter();
			}
			@Override
			public Adapter caseManagesEnd(ManagesEnd object) {
				return createManagesEndAdapter();
			}
			@Override
			public Adapter caseCXModuleContained(CXModuleContained object) {
				return createCXModuleContainedAdapter();
			}
			@Override
			public Adapter caseCXNamedElement(CXNamedElement object) {
				return createCXNamedElementAdapter();
			}
			@Override
			public Adapter caseCXType(CXType object) {
				return createCXTypeAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseHome(Home object) {
				return createHomeAdapter();
			}
			@Override
			public Adapter caseManages(Manages object) {
				return createManagesAdapter();
			}
			@Override
			public Adapter caseDDS4CCMModel(DDS4CCMModel object) {
				return createDDS4CCMModelAdapter();
			}
			@Override
			public Adapter caseIDL3PlusModel(IDL3PlusModel object) {
				return createIDL3PlusModelAdapter();
			}
			@Override
			public Adapter caseCCMModel(CCMModel object) {
				return createCCMModelAdapter();
			}
			@Override
			public Adapter caseCXWString(CXWString object) {
				return createCXWStringAdapter();
			}
			@Override
			public Adapter caseCXBounded(CXBounded object) {
				return createCXBoundedAdapter();
			}
			@Override
			public Adapter caseCXBound(CXBound object) {
				return createCXBoundAdapter();
			}
			@Override
			public Adapter caseCXConstant(CXConstant object) {
				return createCXConstantAdapter();
			}
			@Override
			public Adapter caseCXTyped(CXTyped object) {
				return createCXTypedAdapter();
			}
			@Override
			public Adapter caseCXClassifierContained(CXClassifierContained object) {
				return createCXClassifierContainedAdapter();
			}
			@Override
			public Adapter caseCXAnonymousArray(CXAnonymousArray object) {
				return createCXAnonymousArrayAdapter();
			}
			@Override
			public Adapter caseCXAnonymousSequence(CXAnonymousSequence object) {
				return createCXAnonymousSequenceAdapter();
			}
			@Override
			public Adapter caseCXArray(CXArray object) {
				return createCXArrayAdapter();
			}
			@Override
			public Adapter caseCXTemplate(CXTemplate object) {
				return createCXTemplateAdapter();
			}
			@Override
			public Adapter caseContained(Contained object) {
				return createContainedAdapter();
			}
			@Override
			public Adapter caseCXBoxedValue(CXBoxedValue object) {
				return createCXBoxedValueAdapter();
			}
			@Override
			public Adapter caseCXWrapper(CXWrapper object) {
				return createCXWrapperAdapter();
			}
			@Override
			public Adapter caseCXCase(CXCase object) {
				return createCXCaseAdapter();
			}
			@Override
			public Adapter caseCXUnionField(CXUnionField object) {
				return createCXUnionFieldAdapter();
			}
			@Override
			public Adapter caseCXConstants(CXConstants object) {
				return createCXConstantsAdapter();
			}
			@Override
			public Adapter caseCXConstructed(CXConstructed object) {
				return createCXConstructedAdapter();
			}
			@Override
			public Adapter caseCXDefault(CXDefault object) {
				return createCXDefaultAdapter();
			}
			@Override
			public Adapter caseCXEnum(CXEnum object) {
				return createCXEnumAdapter();
			}
			@Override
			public Adapter caseCXException(CXException object) {
				return createCXExceptionAdapter();
			}
			@Override
			public Adapter caseCXInterface(CXInterface object) {
				return createCXInterfaceAdapter();
			}
			@Override
			public Adapter caseCXClassifier(CXClassifier object) {
				return createCXClassifierAdapter();
			}
			@Override
			public Adapter caseCXPrimitive(CXPrimitive object) {
				return createCXPrimitiveAdapter();
			}
			@Override
			public Adapter caseCXSequence(CXSequence object) {
				return createCXSequenceAdapter();
			}
			@Override
			public Adapter caseCXString(CXString object) {
				return createCXStringAdapter();
			}
			@Override
			public Adapter caseCXStruct(CXStruct object) {
				return createCXStructAdapter();
			}
			@Override
			public Adapter caseExtensible(Extensible object) {
				return createExtensibleAdapter();
			}
			@Override
			public Adapter caseCXSupports(CXSupports object) {
				return createCXSupportsAdapter();
			}
			@Override
			public Adapter caseCXTypeDef(CXTypeDef object) {
				return createCXTypeDefAdapter();
			}
			@Override
			public Adapter caseCXUnion(CXUnion object) {
				return createCXUnionAdapter();
			}
			@Override
			public Adapter caseCXValue(CXValue object) {
				return createCXValueAdapter();
			}
			@Override
			public Adapter caseCXValueFactory(CXValueFactory object) {
				return createCXValueFactoryAdapter();
			}
			@Override
			public Adapter caseCXModule(CXModule object) {
				return createCXModuleAdapter();
			}
			@Override
			public Adapter caseCXAttribute(CXAttribute object) {
				return createCXAttributeAdapter();
			}
			@Override
			public Adapter caseCXOperation(CXOperation object) {
				return createCXOperationAdapter();
			}
			@Override
			public Adapter caseCXField(CXField object) {
				return createCXFieldAdapter();
			}
			@Override
			public Adapter caseCXParameter(CXParameter object) {
				return createCXParameterAdapter();
			}
			@Override
			public Adapter caseStateMember(StateMember object) {
				return createStateMemberAdapter();
			}
			@Override
			public Adapter caseConnectorDef(ConnectorDef object) {
				return createConnectorDefAdapter();
			}
			@Override
			public Adapter caseConnectorFragment(ConnectorFragment object) {
				return createConnectorFragmentAdapter();
			}
			@Override
			public Adapter caseFragmentImplementation(FragmentImplementation object) {
				return createFragmentImplementationAdapter();
			}
			@Override
			public Adapter caseFragmentAssembly(FragmentAssembly object) {
				return createFragmentAssemblyAdapter();
			}
			@Override
			public Adapter caseConnectorImplementation(ConnectorImplementation object) {
				return createConnectorImplementationAdapter();
			}
			@Override
			public Adapter caseConnectorAssembly(ConnectorAssembly object) {
				return createConnectorAssemblyAdapter();
			}
			@Override
			public Adapter caseFragmentPart(FragmentPart object) {
				return createFragmentPartAdapter();
			}
			@Override
			public Adapter caseTypedConnector(TypedConnector object) {
				return createTypedConnectorAdapter();
			}
			@Override
			public Adapter caseTypeParameter(TypeParameter object) {
				return createTypeParameterAdapter();
			}
			@Override
			public Adapter caseTemplateModule(TemplateModule object) {
				return createTemplateModuleAdapter();
			}
			@Override
			public Adapter caseModuleInstantiation(ModuleInstantiation object) {
				return createModuleInstantiationAdapter();
			}
			@Override
			public Adapter caseParameterBinding(ParameterBinding object) {
				return createParameterBindingAdapter();
			}
			@Override
			public Adapter caseTemplateModuleAlias(TemplateModuleAlias object) {
				return createTemplateModuleAliasAdapter();
			}
			@Override
			public Adapter caseModuleBinding(ModuleBinding object) {
				return createModuleBindingAdapter();
			}
			@Override
			public Adapter caseTemplateSignature(TemplateSignature object) {
				return createTemplateSignatureAdapter();
			}
			@Override
			public Adapter caseInterfacePort(InterfacePort object) {
				return createInterfacePortAdapter();
			}
			@Override
			public Adapter caseNative(Native object) {
				return createNativeAdapter();
			}
			@Override
			public Adapter caseDataSpace(DataSpace object) {
				return createDataSpaceAdapter();
			}
			@Override
			public Adapter caseTopic(Topic object) {
				return createTopicAdapter();
			}
			@Override
			public Adapter caseTopicField(TopicField object) {
				return createTopicFieldAdapter();
			}
			@Override
			public Adapter caseqosPolicy(qosPolicy object) {
				return createqosPolicyAdapter();
			}
			@Override
			public Adapter casehistoryQosPolicy(historyQosPolicy object) {
				return createhistoryQosPolicyAdapter();
			}
			@Override
			public Adapter caselifespanQosPolicy(lifespanQosPolicy object) {
				return createlifespanQosPolicyAdapter();
			}
			@Override
			public Adapter caseDuration(Duration object) {
				return createDurationAdapter();
			}
			@Override
			public Adapter caseownershipQosPolicy(ownershipQosPolicy object) {
				return createownershipQosPolicyAdapter();
			}
			@Override
			public Adapter caseosQosPolicy(osQosPolicy object) {
				return createosQosPolicyAdapter();
			}
			@Override
			public Adapter casewdlQosPolicy(wdlQosPolicy object) {
				return createwdlQosPolicyAdapter();
			}
			@Override
			public Adapter caserdlQosPolicy(rdlQosPolicy object) {
				return createrdlQosPolicyAdapter();
			}
			@Override
			public Adapter caseudQosPolicy(udQosPolicy object) {
				return createudQosPolicyAdapter();
			}
			@Override
			public Adapter casetdQosPolicy(tdQosPolicy object) {
				return createtdQosPolicyAdapter();
			}
			@Override
			public Adapter casetpQosPolicy(tpQosPolicy object) {
				return createtpQosPolicyAdapter();
			}
			@Override
			public Adapter casedeadlineQosPolicy(deadlineQosPolicy object) {
				return createdeadlineQosPolicyAdapter();
			}
			@Override
			public Adapter caselbQosPolicy(lbQosPolicy object) {
				return createlbQosPolicyAdapter();
			}
			@Override
			public Adapter casetbfQosPolicy(tbfQosPolicy object) {
				return createtbfQosPolicyAdapter();
			}
			@Override
			public Adapter casegdQosPolicy(gdQosPolicy object) {
				return creategdQosPolicyAdapter();
			}
			@Override
			public Adapter caseefQosPolicy(efQosPolicy object) {
				return createefQosPolicyAdapter();
			}
			@Override
			public Adapter caserlQosPolicy(rlQosPolicy object) {
				return createrlQosPolicyAdapter();
			}
			@Override
			public Adapter casepresentationQosPolicy(presentationQosPolicy object) {
				return createpresentationQosPolicyAdapter();
			}
			@Override
			public Adapter casepartitionQosPolicy(partitionQosPolicy object) {
				return createpartitionQosPolicyAdapter();
			}
			@Override
			public Adapter casereliabilityQosPolicy(reliabilityQosPolicy object) {
				return createreliabilityQosPolicyAdapter();
			}
			@Override
			public Adapter casedsQosPolicy(dsQosPolicy object) {
				return createdsQosPolicyAdapter();
			}
			@Override
			public Adapter caselivelinessQosPolicy(livelinessQosPolicy object) {
				return createlivelinessQosPolicyAdapter();
			}
			@Override
			public Adapter casedurabilityQosPolicy(durabilityQosPolicy object) {
				return createdurabilityQosPolicyAdapter();
			}
			@Override
			public Adapter casedoQosPolicy(doQosPolicy object) {
				return createdoQosPolicyAdapter();
			}
			@Override
			public Adapter caseqosProperty(qosProperty object) {
				return createqosPropertyAdapter();
			}
			@Override
			public Adapter caseDDSMessage(DDSMessage object) {
				return createDDSMessageAdapter();
			}
			@Override
			public Adapter caseMessageField(MessageField object) {
				return createMessageFieldAdapter();
			}
			@Override
			public Adapter caseQoSProfile(QoSProfile object) {
				return createQoSProfileAdapter();
			}
			@Override
			public Adapter caseQoSForEntity(QoSForEntity object) {
				return createQoSForEntityAdapter();
			}
			@Override
			public Adapter caseQoSEntity(QoSEntity object) {
				return createQoSEntityAdapter();
			}
			@Override
			public Adapter caseDataReaderQoS(DataReaderQoS object) {
				return createDataReaderQoSAdapter();
			}
			@Override
			public Adapter caseDataReaderWriterQoS(DataReaderWriterQoS object) {
				return createDataReaderWriterQoSAdapter();
			}
			@Override
			public Adapter caseParticipantQoS(ParticipantQoS object) {
				return createParticipantQoSAdapter();
			}
			@Override
			public Adapter casePublisherQoS(PublisherQoS object) {
				return createPublisherQoSAdapter();
			}
			@Override
			public Adapter casePublisherSubscriberQoS(PublisherSubscriberQoS object) {
				return createPublisherSubscriberQoSAdapter();
			}
			@Override
			public Adapter caseSubscriberQoS(SubscriberQoS object) {
				return createSubscriberQoSAdapter();
			}
			@Override
			public Adapter caseTopicQoS(TopicQoS object) {
				return createTopicQoSAdapter();
			}
			@Override
			public Adapter caseDataWriterQoS(DataWriterQoS object) {
				return createDataWriterQoSAdapter();
			}
			@Override
			public Adapter caseDomain(Domain object) {
				return createDomainAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseNodeInstance(NodeInstance object) {
				return createNodeInstanceAdapter();
			}
			@Override
			public Adapter caseInterconnect(Interconnect object) {
				return createInterconnectAdapter();
			}
			@Override
			public Adapter caseInterconnectInstance(InterconnectInstance object) {
				return createInterconnectInstanceAdapter();
			}
			@Override
			public Adapter caseBridge(Bridge object) {
				return createBridgeAdapter();
			}
			@Override
			public Adapter caseBridgeInstance(BridgeInstance object) {
				return createBridgeInstanceAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseRequirementSatisfier(RequirementSatisfier object) {
				return createRequirementSatisfierAdapter();
			}
			@Override
			public Adapter caseResourceProperty(ResourceProperty object) {
				return createResourcePropertyAdapter();
			}
			@Override
			public Adapter caseSharedResource(SharedResource object) {
				return createSharedResourceAdapter();
			}
			@Override
			public Adapter caseSatisfierProperty(SatisfierProperty object) {
				return createSatisfierPropertyAdapter();
			}
			@Override
			public Adapter caseRequirement(Requirement object) {
				return createRequirementAdapter();
			}
			@Override
			public Adapter caseDeploymentPlan(DeploymentPlan object) {
				return createDeploymentPlanAdapter();
			}
			@Override
			public Adapter caseDeployment(Deployment object) {
				return createDeploymentAdapter();
			}
			@Override
			public Adapter caseAllocation(Allocation object) {
				return createAllocationAdapter();
			}
			@Override
			public Adapter caseDeploymentPart(DeploymentPart object) {
				return createDeploymentPartAdapter();
			}
			@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@Override
			public Adapter caseComponentDeploymentPart(ComponentDeploymentPart object) {
				return createComponentDeploymentPartAdapter();
			}
			@Override
			public Adapter caseBuildConfiguration(BuildConfiguration object) {
				return createBuildConfigurationAdapter();
			}
			@Override
			public Adapter caseConfigurationSlot(ConfigurationSlot object) {
				return createConfigurationSlotAdapter();
			}
			@Override
			public Adapter caseTargetAssemblyConnector(TargetAssemblyConnector object) {
				return createTargetAssemblyConnectorAdapter();
			}
			@Override
			public Adapter caseContainerProcess(ContainerProcess object) {
				return createContainerProcessAdapter();
			}
			@Override
			public Adapter caseTemplateParameterType(TemplateParameterType object) {
				return createTemplateParameterTypeAdapter();
			}
			@Override
			public Adapter caseExtendedPortType(ExtendedPortType object) {
				return createExtendedPortTypeAdapter();
			}
			@Override
			public Adapter caseIDLFileSpecification(IDLFileSpecification object) {
				return createIDLFileSpecificationAdapter();
			}
			@Override
			public Adapter caseIDLFileDependency(IDLFileDependency object) {
				return createIDLFileDependencyAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseConnectorDefaultValueBinding(ConnectorDefaultValueBinding object) {
				return createConnectorDefaultValueBindingAdapter();
			}
			@Override
			public Adapter caseIDLIncludeDependency(IDLIncludeDependency object) {
				return createIDLIncludeDependencyAdapter();
			}
			@Override
			public Adapter caseWorkerFunctionImpl(WorkerFunctionImpl object) {
				return createWorkerFunctionImplAdapter();
			}
			@Override
			public Adapter caseConnectorStatusListenerConnection(ConnectorStatusListenerConnection object) {
				return createConnectorStatusListenerConnectionAdapter();
			}
			@Override
			public Adapter caseFinderOperation(FinderOperation object) {
				return createFinderOperationAdapter();
			}
			@Override
			public Adapter caseHomeOperation(HomeOperation object) {
				return createHomeOperationAdapter();
			}
			@Override
			public Adapter caseFactoryOperation(FactoryOperation object) {
				return createFactoryOperationAdapter();
			}
			@Override
			public Adapter caseHomeInstance(HomeInstance object) {
				return createHomeInstanceAdapter();
			}
			@Override
			public Adapter caseHideableElement(HideableElement object) {
				return createHideableElementAdapter();
			}
			@Override
			public Adapter casePerPortConnectorTypeDeploymentPart(PerPortConnectorTypeDeploymentPart object) {
				return createPerPortConnectorTypeDeploymentPartAdapter();
			}
			@Override
			public Adapter caseDomainDefinition(DomainDefinition object) {
				return createDomainDefinitionAdapter();
			}
			@Override
			public Adapter caseDomainDeployment(DomainDeployment object) {
				return createDomainDeploymentAdapter();
			}
			@Override
			public Adapter caseDomainDeploymentPart(DomainDeploymentPart object) {
				return createDomainDeploymentPartAdapter();
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
	 * Creates a new adapter for an object of class '{@link dds4ccm.AssemblyImplementation <em>Assembly Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.AssemblyImplementation
	 * @generated
	 */
	public Adapter createAssemblyImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.StructuralRealization <em>Structural Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.StructuralRealization
	 * @generated
	 */
	public Adapter createStructuralRealizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.HomeImplementation <em>Home Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.HomeImplementation
	 * @generated
	 */
	public Adapter createHomeImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ManagesImplEnd <em>Manages Impl End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ManagesImplEnd
	 * @generated
	 */
	public Adapter createManagesImplEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ManagesImpl <em>Manages Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ManagesImpl
	 * @generated
	 */
	public Adapter createManagesImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.MonolithicImplementation <em>Monolithic Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.MonolithicImplementation
	 * @generated
	 */
	public Adapter createMonolithicImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Implementation
	 * @generated
	 */
	public Adapter createImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.WorkerFunctionIdentifiable <em>Worker Function Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.WorkerFunctionIdentifiable
	 * @generated
	 */
	public Adapter createWorkerFunctionIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CCMPart <em>CCM Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CCMPart
	 * @generated
	 */
	public Adapter createCCMPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Part
	 * @generated
	 */
	public Adapter createPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CCMConnector <em>CCM Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CCMConnector
	 * @generated
	 */
	public Adapter createCCMConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.AssemblyConnector <em>Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.AssemblyConnector
	 * @generated
	 */
	public Adapter createAssemblyConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ComponentInterface <em>Component Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ComponentInterface
	 * @generated
	 */
	public Adapter createComponentInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.FlowPort <em>Flow Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.FlowPort
	 * @generated
	 */
	public Adapter createFlowPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.MessagePort <em>Message Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.MessagePort
	 * @generated
	 */
	public Adapter createMessagePortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Interface
	 * @generated
	 */
	public Adapter createInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.PortTypeable <em>Port Typeable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.PortTypeable
	 * @generated
	 */
	public Adapter createPortTypeableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.WorkerFunction <em>Worker Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.WorkerFunction
	 * @generated
	 */
	public Adapter createWorkerFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.PortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.PortType
	 * @generated
	 */
	public Adapter createPortTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ComponentImplementation <em>Component Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ComponentImplementation
	 * @generated
	 */
	public Adapter createComponentImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.EventPort <em>Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.EventPort
	 * @generated
	 */
	public Adapter createEventPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ConjugatedPort <em>Conjugated Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ConjugatedPort
	 * @generated
	 */
	public Adapter createConjugatedPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CCMComponent <em>CCM Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CCMComponent
	 * @generated
	 */
	public Adapter createCCMComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ManagesEnd <em>Manages End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ManagesEnd
	 * @generated
	 */
	public Adapter createManagesEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXModuleContained <em>CX Module Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXModuleContained
	 * @generated
	 */
	public Adapter createCXModuleContainedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXNamedElement <em>CX Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXNamedElement
	 * @generated
	 */
	public Adapter createCXNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXType <em>CX Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXType
	 * @generated
	 */
	public Adapter createCXTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Home <em>Home</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Home
	 * @generated
	 */
	public Adapter createHomeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Manages <em>Manages</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Manages
	 * @generated
	 */
	public Adapter createManagesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DDS4CCMModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DDS4CCMModel
	 * @generated
	 */
	public Adapter createDDS4CCMModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.IDL3PlusModel <em>IDL3 Plus Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.IDL3PlusModel
	 * @generated
	 */
	public Adapter createIDL3PlusModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CCMModel <em>CCM Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CCMModel
	 * @generated
	 */
	public Adapter createCCMModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXWString <em>CXW String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXWString
	 * @generated
	 */
	public Adapter createCXWStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXBounded <em>CX Bounded</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXBounded
	 * @generated
	 */
	public Adapter createCXBoundedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXBound <em>CX Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXBound
	 * @generated
	 */
	public Adapter createCXBoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXConstant <em>CX Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXConstant
	 * @generated
	 */
	public Adapter createCXConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXTyped <em>CX Typed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXTyped
	 * @generated
	 */
	public Adapter createCXTypedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXClassifierContained <em>CX Classifier Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXClassifierContained
	 * @generated
	 */
	public Adapter createCXClassifierContainedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXAnonymousArray <em>CX Anonymous Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXAnonymousArray
	 * @generated
	 */
	public Adapter createCXAnonymousArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXAnonymousSequence <em>CX Anonymous Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXAnonymousSequence
	 * @generated
	 */
	public Adapter createCXAnonymousSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXArray <em>CX Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXArray
	 * @generated
	 */
	public Adapter createCXArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXTemplate <em>CX Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXTemplate
	 * @generated
	 */
	public Adapter createCXTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Contained <em>Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Contained
	 * @generated
	 */
	public Adapter createContainedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXBoxedValue <em>CX Boxed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXBoxedValue
	 * @generated
	 */
	public Adapter createCXBoxedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXWrapper <em>CX Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXWrapper
	 * @generated
	 */
	public Adapter createCXWrapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXCase <em>CX Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXCase
	 * @generated
	 */
	public Adapter createCXCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXUnionField <em>CX Union Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXUnionField
	 * @generated
	 */
	public Adapter createCXUnionFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXConstants <em>CX Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXConstants
	 * @generated
	 */
	public Adapter createCXConstantsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXConstructed <em>CX Constructed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXConstructed
	 * @generated
	 */
	public Adapter createCXConstructedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXDefault <em>CX Default</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXDefault
	 * @generated
	 */
	public Adapter createCXDefaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXEnum <em>CX Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXEnum
	 * @generated
	 */
	public Adapter createCXEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXException <em>CX Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXException
	 * @generated
	 */
	public Adapter createCXExceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXInterface <em>CX Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXInterface
	 * @generated
	 */
	public Adapter createCXInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXClassifier <em>CX Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXClassifier
	 * @generated
	 */
	public Adapter createCXClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXPrimitive <em>CX Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXPrimitive
	 * @generated
	 */
	public Adapter createCXPrimitiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXSequence <em>CX Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXSequence
	 * @generated
	 */
	public Adapter createCXSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXString <em>CX String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXString
	 * @generated
	 */
	public Adapter createCXStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXStruct <em>CX Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXStruct
	 * @generated
	 */
	public Adapter createCXStructAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Extensible <em>Extensible</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Extensible
	 * @generated
	 */
	public Adapter createExtensibleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXSupports <em>CX Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXSupports
	 * @generated
	 */
	public Adapter createCXSupportsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXTypeDef <em>CX Type Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXTypeDef
	 * @generated
	 */
	public Adapter createCXTypeDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXUnion <em>CX Union</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXUnion
	 * @generated
	 */
	public Adapter createCXUnionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXValue <em>CX Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXValue
	 * @generated
	 */
	public Adapter createCXValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXValueFactory <em>CX Value Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXValueFactory
	 * @generated
	 */
	public Adapter createCXValueFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXModule <em>CX Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXModule
	 * @generated
	 */
	public Adapter createCXModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXAttribute <em>CX Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXAttribute
	 * @generated
	 */
	public Adapter createCXAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXOperation <em>CX Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXOperation
	 * @generated
	 */
	public Adapter createCXOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXField <em>CX Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXField
	 * @generated
	 */
	public Adapter createCXFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.CXParameter <em>CX Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.CXParameter
	 * @generated
	 */
	public Adapter createCXParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.StateMember <em>State Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.StateMember
	 * @generated
	 */
	public Adapter createStateMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ConnectorDef <em>Connector Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ConnectorDef
	 * @generated
	 */
	public Adapter createConnectorDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ConnectorFragment <em>Connector Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ConnectorFragment
	 * @generated
	 */
	public Adapter createConnectorFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.FragmentImplementation <em>Fragment Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.FragmentImplementation
	 * @generated
	 */
	public Adapter createFragmentImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.FragmentAssembly <em>Fragment Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.FragmentAssembly
	 * @generated
	 */
	public Adapter createFragmentAssemblyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ConnectorImplementation <em>Connector Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ConnectorImplementation
	 * @generated
	 */
	public Adapter createConnectorImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ConnectorAssembly <em>Connector Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ConnectorAssembly
	 * @generated
	 */
	public Adapter createConnectorAssemblyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.FragmentPart <em>Fragment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.FragmentPart
	 * @generated
	 */
	public Adapter createFragmentPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TypedConnector <em>Typed Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TypedConnector
	 * @generated
	 */
	public Adapter createTypedConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TypeParameter <em>Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TypeParameter
	 * @generated
	 */
	public Adapter createTypeParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TemplateModule <em>Template Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TemplateModule
	 * @generated
	 */
	public Adapter createTemplateModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ModuleInstantiation <em>Module Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ModuleInstantiation
	 * @generated
	 */
	public Adapter createModuleInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ParameterBinding <em>Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ParameterBinding
	 * @generated
	 */
	public Adapter createParameterBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TemplateModuleAlias <em>Template Module Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TemplateModuleAlias
	 * @generated
	 */
	public Adapter createTemplateModuleAliasAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ModuleBinding <em>Module Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ModuleBinding
	 * @generated
	 */
	public Adapter createModuleBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TemplateSignature <em>Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TemplateSignature
	 * @generated
	 */
	public Adapter createTemplateSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.InterfacePort <em>Interface Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.InterfacePort
	 * @generated
	 */
	public Adapter createInterfacePortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Native <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Native
	 * @generated
	 */
	public Adapter createNativeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DataSpace <em>Data Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DataSpace
	 * @generated
	 */
	public Adapter createDataSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Topic <em>Topic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Topic
	 * @generated
	 */
	public Adapter createTopicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TopicField <em>Topic Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TopicField
	 * @generated
	 */
	public Adapter createTopicFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.qosPolicy <em>qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.qosPolicy
	 * @generated
	 */
	public Adapter createqosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.historyQosPolicy <em>history Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.historyQosPolicy
	 * @generated
	 */
	public Adapter createhistoryQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.lifespanQosPolicy <em>lifespan Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.lifespanQosPolicy
	 * @generated
	 */
	public Adapter createlifespanQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Duration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Duration
	 * @generated
	 */
	public Adapter createDurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ownershipQosPolicy <em>ownership Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ownershipQosPolicy
	 * @generated
	 */
	public Adapter createownershipQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.osQosPolicy <em>os Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.osQosPolicy
	 * @generated
	 */
	public Adapter createosQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.wdlQosPolicy <em>wdl Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.wdlQosPolicy
	 * @generated
	 */
	public Adapter createwdlQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.rdlQosPolicy <em>rdl Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.rdlQosPolicy
	 * @generated
	 */
	public Adapter createrdlQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.udQosPolicy <em>ud Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.udQosPolicy
	 * @generated
	 */
	public Adapter createudQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.tdQosPolicy <em>td Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.tdQosPolicy
	 * @generated
	 */
	public Adapter createtdQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.tpQosPolicy <em>tp Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.tpQosPolicy
	 * @generated
	 */
	public Adapter createtpQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.deadlineQosPolicy <em>deadline Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.deadlineQosPolicy
	 * @generated
	 */
	public Adapter createdeadlineQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.lbQosPolicy <em>lb Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.lbQosPolicy
	 * @generated
	 */
	public Adapter createlbQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.tbfQosPolicy <em>tbf Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.tbfQosPolicy
	 * @generated
	 */
	public Adapter createtbfQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.gdQosPolicy <em>gd Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.gdQosPolicy
	 * @generated
	 */
	public Adapter creategdQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.efQosPolicy <em>ef Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.efQosPolicy
	 * @generated
	 */
	public Adapter createefQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.rlQosPolicy <em>rl Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.rlQosPolicy
	 * @generated
	 */
	public Adapter createrlQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.presentationQosPolicy <em>presentation Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.presentationQosPolicy
	 * @generated
	 */
	public Adapter createpresentationQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.partitionQosPolicy <em>partition Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.partitionQosPolicy
	 * @generated
	 */
	public Adapter createpartitionQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.reliabilityQosPolicy <em>reliability Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.reliabilityQosPolicy
	 * @generated
	 */
	public Adapter createreliabilityQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.dsQosPolicy <em>ds Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.dsQosPolicy
	 * @generated
	 */
	public Adapter createdsQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.livelinessQosPolicy <em>liveliness Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.livelinessQosPolicy
	 * @generated
	 */
	public Adapter createlivelinessQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.durabilityQosPolicy <em>durability Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.durabilityQosPolicy
	 * @generated
	 */
	public Adapter createdurabilityQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.doQosPolicy <em>do Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.doQosPolicy
	 * @generated
	 */
	public Adapter createdoQosPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.qosProperty <em>qos Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.qosProperty
	 * @generated
	 */
	public Adapter createqosPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DDSMessage <em>DDS Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DDSMessage
	 * @generated
	 */
	public Adapter createDDSMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.MessageField <em>Message Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.MessageField
	 * @generated
	 */
	public Adapter createMessageFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.QoSProfile <em>Qo SProfile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.QoSProfile
	 * @generated
	 */
	public Adapter createQoSProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.QoSForEntity <em>Qo SFor Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.QoSForEntity
	 * @generated
	 */
	public Adapter createQoSForEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.QoSEntity <em>Qo SEntity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.QoSEntity
	 * @generated
	 */
	public Adapter createQoSEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DataReaderQoS <em>Data Reader Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DataReaderQoS
	 * @generated
	 */
	public Adapter createDataReaderQoSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DataReaderWriterQoS <em>Data Reader Writer Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DataReaderWriterQoS
	 * @generated
	 */
	public Adapter createDataReaderWriterQoSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ParticipantQoS <em>Participant Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ParticipantQoS
	 * @generated
	 */
	public Adapter createParticipantQoSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.PublisherQoS <em>Publisher Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.PublisherQoS
	 * @generated
	 */
	public Adapter createPublisherQoSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.PublisherSubscriberQoS <em>Publisher Subscriber Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.PublisherSubscriberQoS
	 * @generated
	 */
	public Adapter createPublisherSubscriberQoSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.SubscriberQoS <em>Subscriber Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.SubscriberQoS
	 * @generated
	 */
	public Adapter createSubscriberQoSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TopicQoS <em>Topic Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TopicQoS
	 * @generated
	 */
	public Adapter createTopicQoSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DataWriterQoS <em>Data Writer Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DataWriterQoS
	 * @generated
	 */
	public Adapter createDataWriterQoSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Domain
	 * @generated
	 */
	public Adapter createDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.NodeInstance <em>Node Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.NodeInstance
	 * @generated
	 */
	public Adapter createNodeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Interconnect <em>Interconnect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Interconnect
	 * @generated
	 */
	public Adapter createInterconnectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.InterconnectInstance <em>Interconnect Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.InterconnectInstance
	 * @generated
	 */
	public Adapter createInterconnectInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Bridge <em>Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Bridge
	 * @generated
	 */
	public Adapter createBridgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.BridgeInstance <em>Bridge Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.BridgeInstance
	 * @generated
	 */
	public Adapter createBridgeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.RequirementSatisfier <em>Requirement Satisfier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.RequirementSatisfier
	 * @generated
	 */
	public Adapter createRequirementSatisfierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ResourceProperty <em>Resource Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ResourceProperty
	 * @generated
	 */
	public Adapter createResourcePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.SharedResource <em>Shared Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.SharedResource
	 * @generated
	 */
	public Adapter createSharedResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.SatisfierProperty <em>Satisfier Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.SatisfierProperty
	 * @generated
	 */
	public Adapter createSatisfierPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DeploymentPlan
	 * @generated
	 */
	public Adapter createDeploymentPlanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Deployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Deployment
	 * @generated
	 */
	public Adapter createDeploymentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Allocation <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Allocation
	 * @generated
	 */
	public Adapter createAllocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DeploymentPart <em>Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DeploymentPart
	 * @generated
	 */
	public Adapter createDeploymentPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ComponentDeploymentPart <em>Component Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ComponentDeploymentPart
	 * @generated
	 */
	public Adapter createComponentDeploymentPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.BuildConfiguration <em>Build Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.BuildConfiguration
	 * @generated
	 */
	public Adapter createBuildConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ConfigurationSlot <em>Configuration Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ConfigurationSlot
	 * @generated
	 */
	public Adapter createConfigurationSlotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TargetAssemblyConnector <em>Target Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TargetAssemblyConnector
	 * @generated
	 */
	public Adapter createTargetAssemblyConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ContainerProcess <em>Container Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ContainerProcess
	 * @generated
	 */
	public Adapter createContainerProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.TemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.TemplateParameterType
	 * @generated
	 */
	public Adapter createTemplateParameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ExtendedPortType <em>Extended Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ExtendedPortType
	 * @generated
	 */
	public Adapter createExtendedPortTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.IDLFileSpecification <em>IDL File Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.IDLFileSpecification
	 * @generated
	 */
	public Adapter createIDLFileSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.IDLFileDependency <em>IDL File Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.IDLFileDependency
	 * @generated
	 */
	public Adapter createIDLFileDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ConnectorDefaultValueBinding <em>Connector Default Value Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ConnectorDefaultValueBinding
	 * @generated
	 */
	public Adapter createConnectorDefaultValueBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.IDLIncludeDependency <em>IDL Include Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.IDLIncludeDependency
	 * @generated
	 */
	public Adapter createIDLIncludeDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.WorkerFunctionImpl <em>Worker Function Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.WorkerFunctionImpl
	 * @generated
	 */
	public Adapter createWorkerFunctionImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.ConnectorStatusListenerConnection <em>Connector Status Listener Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.ConnectorStatusListenerConnection
	 * @generated
	 */
	public Adapter createConnectorStatusListenerConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.FinderOperation <em>Finder Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.FinderOperation
	 * @generated
	 */
	public Adapter createFinderOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.HomeOperation <em>Home Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.HomeOperation
	 * @generated
	 */
	public Adapter createHomeOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.FactoryOperation <em>Factory Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.FactoryOperation
	 * @generated
	 */
	public Adapter createFactoryOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.HomeInstance <em>Home Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.HomeInstance
	 * @generated
	 */
	public Adapter createHomeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.HideableElement <em>Hideable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.HideableElement
	 * @generated
	 */
	public Adapter createHideableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.PerPortConnectorTypeDeploymentPart <em>Per Port Connector Type Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.PerPortConnectorTypeDeploymentPart
	 * @generated
	 */
	public Adapter createPerPortConnectorTypeDeploymentPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DomainDefinition <em>Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DomainDefinition
	 * @generated
	 */
	public Adapter createDomainDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DomainDeployment <em>Domain Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DomainDeployment
	 * @generated
	 */
	public Adapter createDomainDeploymentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dds4ccm.DomainDeploymentPart <em>Domain Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dds4ccm.DomainDeploymentPart
	 * @generated
	 */
	public Adapter createDomainDeploymentPartAdapter() {
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

} //DDS4CCMAdapterFactory
