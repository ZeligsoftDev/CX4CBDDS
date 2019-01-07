package com.zeligsoft.domain.dds4ccm.rhapsody.transform

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClassifier
import com.telelogic.rhapsody.core.IRPGeneralization
import com.telelogic.rhapsody.core.IRPInstanceValue
import com.telelogic.rhapsody.core.IRPLiteralSpecification
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPPackage
import com.telelogic.rhapsody.core.IRPTag
import com.telelogic.rhapsody.core.IRPValueSpecification
import com.zeligsoft.base.zdl.staticapi.core.ZObject
import com.zeligsoft.base.zdl.util.ZDLUtil
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.AssemblyImplementationRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.CCMComponentRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.CCMConnectorRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.CCMPartRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.ContainerProcessRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.DDSMessageRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.DeploymentPartRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.DeploymentPlanRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.DomainRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.HomeImplementationRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.HomeInstanceRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.HomeRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.InterfacePortRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.MonolithicImplementationRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.NodeInstanceRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.NodeRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.PropertyRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.ResourcePropertyRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.ResourceRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.SatisfierPropertyRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAArrayRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAAttributeRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBACaseRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAConstantRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAEnumRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAExceptionRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAFieldRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAInterfaceRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAModuleRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAOperationRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAParameterRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBASequenceRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAStringRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAStructRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBATypeDefRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAUnionRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAWStringRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.ConnectorDefRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.ConnectorDefaultValueBindingRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.DataSpaceRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.ExtendedPortTypeRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.ModuleInstantiationRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.TemplateModuleRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.zml.util.ZMLMMNames
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Enumeration
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.UMLPackage
import com.zeligsoft.domain.dds4ccm.rhapsody.util.RhapsodyZDLUtil
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.IDLFileSpecificationRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.IDLFileDependencyRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.InterconnectRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.InterconnectInstanceRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.HomeManagesDependencyRhapsodyExt

class RhapsodyImportTraversal {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    @Inject 
    @Named(RhapsodyImportModule::RELATION_UPDATE_LIST_BINDING)
    private List<RelationUpdateMetadata> relationUpdateCache;
    
    @Inject extension RhapsodyZDLUtil
    @Inject extension CORBAModuleRhapsodyExt
    @Inject extension CCMComponentRhapsodyExt
    @Inject extension CORBAInterfaceRhapsodyExt
    @Inject extension CORBAOperationRhapsodyExt
    @Inject extension CORBAStringRhapsodyExt
    @Inject extension CORBAStructRhapsodyExt
    @Inject extension CORBASequenceRhapsodyExt
    @Inject extension CORBACaseRhapsodyExt
    @Inject extension CORBAEnumRhapsodyExt
    @Inject extension CORBAFieldRhapsodyExt
    @Inject extension CORBAParameterRhapsodyExt
    @Inject extension CORBATypeDefRhapsodyExt
    @Inject extension CORBAUnionRhapsodyExt
    @Inject extension CORBAWStringRhapsodyExt
    @Inject extension CORBAArrayRhapsodyExt
    @Inject extension CORBAAttributeRhapsodyExt    
    @Inject extension CORBAConstantRhapsodyExt  
    @Inject extension CORBAExceptionRhapsodyExt
    @Inject extension AssemblyImplementationRhapsodyExt
    @Inject extension InterfacePortRhapsodyExt
    @Inject extension HomeRhapsodyExt
    @Inject extension DDSMessageRhapsodyExt
    @Inject extension ConnectorDefRhapsodyExt
	@Inject extension ExtendedPortTypeRhapsodyExt
	@Inject extension TemplateModuleRhapsodyExt
	@Inject extension ModuleInstantiationRhapsodyExt
	@Inject extension CCMPartRhapsodyExt
	@Inject extension HomeImplementationRhapsodyExt
	@Inject extension MonolithicImplementationRhapsodyExt
	@Inject extension HomeInstanceRhapsodyExt
	@Inject extension CCMConnectorRhapsodyExt
	@Inject extension DataSpaceRhapsodyExt
	@Inject extension DomainRhapsodyExt
	@Inject extension NodeRhapsodyExt
	@Inject extension ResourceRhapsodyExt
	@Inject extension NodeInstanceRhapsodyExt
	@Inject extension ResourcePropertyRhapsodyExt
	@Inject extension SatisfierPropertyRhapsodyExt
	@Inject extension DeploymentPlanRhapsodyExt
	@Inject extension ContainerProcessRhapsodyExt
	@Inject extension DeploymentPartRhapsodyExt
    @Inject extension PropertyRhapsodyExt
    @Inject extension ConnectorDefaultValueBindingRhapsodyExt
    @Inject extension IDLFileSpecificationRhapsodyExt
    @Inject extension IDLFileDependencyRhapsodyExt
    @Inject extension InterconnectRhapsodyExt
    @Inject extension InterconnectInstanceRhapsodyExt
    @Inject extension HomeManagesDependencyRhapsodyExt

    def void map(IRPModelElement self, Object container) {
    	var ZObject result = null
        switch(self.zdlConcept) {
        	
        	// IDL3+ Domain
            case IDL3PlusNames::CONNECTOR_DEF:
                result = importConnectorDef(self, container)
            case IDL3PlusNames::EXTENDED_PORT_TYPE:
                result = importExtendedPortType(self, container)
            case IDL3PlusNames::TEMPLATE_MODULE:
                result = importTemplateModule(self, container)
            case IDL3PlusNames::MODULE_INSTANTIATION:
                result = importModuleInstantiation(self, container)
            case IDL3PlusNames::TEMPLATE_MODULE:
                result = importTemplateModule(self, container)       
            case IDL3PlusNames::DATA_SPACE:
                result = importDataSpace(self, container)
            case IDL3PlusNames::CONNECTOR_DEFAULT_VALUE_BINDING:
                result = importConnectorDefaultValueBinding(self, container)
            case IDL3PlusNames::PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART:
                result = importPerPortDeploymentPart(self, container)
                
        	// CCM Domain
            case CCMNames::CCMCOMPONENT:
                result = importCCMComponent(self, container)
            case CCMNames::INTERFACE_PORT:
                result = importInterfacePort(self, container)  
            case CCMNames::ASSEMBLY_IMPLEMENTATION:
                 result = importAssemblyImplementation(self, container)
            case CCMNames::HOME:
                 result = importHome(self, container)              
            case CCMNames::FACTORY_OPERATION:
                 result = importFactoryOperation(self, container)
            case CCMNames::FINDER_OPERATION:
                 result = importFinderOperation(self, container)
            case CCMNames::CCMPART:
                 result = importCCMPart(self, container)      
            case CCMNames::MONOLITHIC_IMPLEMENTATION:
                 result = importMonolithicImplementation(self, container)      
            case CCMNames::HOME_INSTANCE:
                 result = importHomeInstance(self, container)  
            case CCMNames::MANAGES:
                 result = importManagesDependency(self, container)
            case CCMNames::HOME_IMPLEMENTATION:
                 result = importHomeImplementation(self, container)      
            case CCMNames::CCMCONNECTOR:
                 result = importCCMConnector(self, container) 
            case CCMNames::DOMAIN:
                 result = importDomain(self, container)
            case CCMNames::NODE:
                 result = importNode(self, container)
            case CCMNames::RESOURCE:
                 result = importResource(self, container)
            case CCMNames::NODE_INSTANCE:
                 result = importNodeInstance(self, container)
            case CCMNames::RESOURCE_PROPERTY:
                 result = importResourceProperty(self, container)
            case CCMNames::SATISFIER_PROPERTY:
                 result = importSatisfierProperty(self, container)
            case CCMNames::DEPLOYMENT_PLAN:
                 result = importDeploymentPlan(self, container)
            case CCMNames::CONTAINER_PROCESS:
                 result = importContainerProcess(self, container)
            case ZMLMMNames::COMPONENT_DEPLOYMENT_PART:
                 result = importComponentDeploymentPart(self, container)                 
            case ZMLMMNames::DEPLOYMENT_PART:
                 result = importDeploymentPart(self, container)                 
            case CCMNames::PROPERTY:
                 result = importProperty(self, container)
            case CCMNames::INTERCONNECT:
                 result = importInterconnect(self, container)
            case CCMNames::INTERCONNECT_INSTANCE:
                 result = importInterconnectInstance(self, container)                 
                                          
            // DDS
            case DDS4CCMNames::DDSMESSAGE:
                 result = importDDSMessage(self, container)            
            case DDS4CCMNames::MESSAGE_FIELD:
                 result = importMessageField(self, container)
            case DDS4CCMNames::CONNECTOR_STATUS_LISTENER_CONNECTION:
                 result = importCSLConnection(self, container)                    
            case DDS4CCMNames::IDLFILE_SPECIFICATION:
                 result = importIDLFileSpecification(self, container)  
            case DDS4CCMNames::IDLFILE_DEPENDENCY:
                 result = importIDLFileDependency(self, container)  
                 
            //CORBA Domain
            case CORBADomainNames::CORBAMODULE:
                importPackageOrModule(self, container)
            case CORBADomainNames::CORBAINTERFACE:
                 result = importCorbaInterface(self, container)
            case CORBADomainNames::CORBAOPERATION:
                 result = importCorbaOperation(self, container)
            case CORBADomainNames::CORBAARRAY:
                 result = importCorbaArray(self, container)
            case CORBADomainNames::CORBASEQUENCE:
                 result = importCorbaSequence(self, container)
            case CORBADomainNames::CORBASTRUCT:
                 result = importCorbaStruct(self, container)
            case CORBADomainNames::CORBAEXCEPTION:
                 result = importCorbaException(self, container)                
            case CORBADomainNames::CORBAATTRIBUTE:
                 result = importCorbaAttribute(self, container)
            case CORBADomainNames::CORBAENUM:
                 result = importCorbaEnum(self, container)
            case CORBADomainNames::CORBAFIELD:
                 result = importCorbaField(self, container)
            case CORBADomainNames::CORBAWSTRING:
                 result = importCorbaWString(self, container)                
            case CORBADomainNames::CORBACASE:
                 result = importCorbaCase(self, container)
            case CORBADomainNames::CORBACONSTANT:
                 result = importCorbaConstant(self, container)
            case CORBADomainNames::CORBACONSTANTS:
                 result = importCorbaConstants(self, container)
            case CORBADomainNames::CORBAPARAMETER:
                 result = importCorbaParameter(self, container)
            case CORBADomainNames::CORBATYPE_DEF:
                 result = importCorbaTypeDef(self, container)
            case CORBADomainNames::CORBAUNION:
                 result = importCorbaUnion(self, container)
            case CORBADomainNames::CORBASTRING:
                 result = importCorbaString(self, container)
            default:
                if(self instanceof IRPPackage) {
                	val isRef = (self as IRPPackage).referenceUnit
                	if(isRef != 1 || (isRef == 1 && (self.name.equals("DDS_DCPS") || self.name.equals("CCM_PSAT")))){
                   		importPackageOrModule(self as IRPPackage, container)
                    }
                }
        }
        if(result != null){
        	val eObj = result.eObject
        	self.allTags.toList.forEach(IRPTag t | t.mapTag(eObj))
        }
    }
    
	def void mapGeneralization(IRPGeneralization gen, EObject container) {
		val other = gen.baseClass.fullPathName
        relationUpdateCache.add(new RelationUpdateMetadata(container, other, UMLPackage::eINSTANCE.generalization))
	}
	
    def private void mapTag(IRPTag tag, EObject element){
    	val concepts = ZDLUtil::getAllZDLConcepts(element)
    	var name = tag.name
    	val index = tag.name.indexOf("_")
    	if(index > 0){
    		name = tag.name.substring(0, index)
    	}
    	val tagName = name
		
    	concepts.forEach(c | c.attributes.filter(a | a.name == tagName).forEach(p | p.mapTag(tag, element, c.qualifiedName)))
    }
    
    def private void mapTag(Property property, IRPTag tag, EObject element, String zdlConcept){
    	val valueList = tag.valueSpecifications.toList
    	valueList.forEach(IRPValueSpecification spec | spec.mapTagHelper(tag, element, zdlConcept, property))
    }

    def private dispatch void mapTagHelper(IRPInstanceValue spec, IRPTag tag, EObject element, String zdlConcept, org.eclipse.uml2.uml.Property property){
    	if(property.composite){
    		// Attribute of element of the composite property
    		val type = property.type
    		val value = ZDLUtil::getValue(element, zdlConcept, property.name)
    		val	compositeValue = ZDLUtil::createZDLConcept(element, zdlConcept, property.name, type.qualifiedName)
    		if(property.multivalued){
    			(value as List).add(compositeValue)
    		}else{
    			ZDLUtil::setValue(element, zdlConcept, property.name, compositeValue)
    		}
    		val attribute = tag.name.split("_").get(1)
    		updateRequired.add(new ReferenceUpdateMetadata(type.qualifiedName, 
    			attribute, 
    			compositeValue, spec.value.fullPathName))
    	}else {
	    	updateRequired.add(new ReferenceUpdateMetadata(zdlConcept, 
	    		property.name, 
	    		element, spec.value.fullPathName))
    	}
    }
    def private dispatch void mapTagHelper(IRPLiteralSpecification spec, IRPTag tag, EObject element, String zdlConcept, org.eclipse.uml2.uml.Property property){
    	if(property.type instanceof Enumeration){
    		val literalValue = spec.value
    		val enumName = property.type.qualifiedName
    		val literal = ZDLUtil::getZDLEnumLiteral(element, enumName, literalValue)
    		if(literal != null){
	    		ZDLUtil::setValue(element, zdlConcept, property.name, literal)
    		}
    		return
    	}
    	if(!(property.type instanceof PrimitiveType)){
    		return
    	}
    	var value = ZDLUtil::getValue(element, zdlConcept, property.name)
    	var Object specValue = spec.value
    	val tagType = tag.type
    	val type = tagType.name
		if(type.equals("RhpBoolean")){
			specValue = Boolean::parseBoolean(specValue.toString)
		}
		if(!property.composite){
			if(property.multivalued){
				(value as List).add(specValue)
			} else {
				ZDLUtil::setValue(element, zdlConcept, property.name, specValue)
			}
		}else{
			// TO DO: bring in flattened object
		}
	}       
    def private dispatch void mapTagHelper(IRPValueSpecification spec, IRPClassifier tagType, EObject element, String zdlConcept, org.eclipse.uml2.uml.Property property){
	}    
}