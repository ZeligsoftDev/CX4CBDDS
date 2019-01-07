package com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPInstance
import com.telelogic.rhapsody.core.IRPInstanceValue
import com.telelogic.rhapsody.core.IRPLiteralSpecification
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPTag
import com.zeligsoft.base.util.NamingUtil
import com.zeligsoft.base.zdl.util.ZDLUtil
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.omg.corba.util.CORBAUtil
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Classifier
import org.eclipse.uml2.uml.Component
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.InstanceValue
import org.eclipse.uml2.uml.LiteralString
import org.eclipse.uml2.uml.Package
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.Slot
import org.eclipse.uml2.uml.UMLPackage

class DeploymentValueUpdateRhapsodyExt {
    
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    
    def private List getInstanceValueTags(IRPModelElement source){
    	val tags = source.allTags.toList.filter(IRPTag t | t.name.startsWith("instanceValue")).toList
    	return tags
    }
    
    def private IRPModelElement getClassifierTagValue(IRPModelElement source){
    	val tags = source.allTags.toList
    	val tag = tags.filter(IRPTag t | t.name == "classifier").head
    	if(tag != null){
	    	val values = tag.valueSpecifications.toList
	    	if(!values.empty){
	    		val value = values.get(0)
	    		return (value as IRPInstanceValue).value
	    	}
    	}
    	null
    }
    def private String getValueTagValue(IRPModelElement source){
    	val tags = source.allTags.toList
    	val tag = tags.filter(IRPTag t | t.name == "value").head
    	if(tag != null){
	    	val values = tag.valueSpecifications.toList
	    	if(!values.empty){
	    		val value = values.get(0)
	    		return (value as IRPLiteralSpecification).value
	    	}
    	}
    	null
    }    
    def dispatch void transformDeploymentValue(Property part, IRPTag instance, IRPModelElement source){
    	val container = part.rootContainer
    	val values = instance.valueSpecifications.toList
    	if(!values.empty){
    		val instanceValue = part.createInstanceValue
    		val value = values.get(0)
    		if(value instanceof IRPInstanceValue && (value as IRPInstanceValue).value != null){
	    		val instanceSpecification = (value as IRPInstanceValue).value.transformInstance(container)
		    	if(instanceSpecification != null){
		    		instanceValue.setInstance(instanceSpecification)
		    	}    		
	    	}
    	}
    }
    def dispatch void transformDeploymentValue(Package element, IRPTag instance, IRPModelElement source){
    	if(ZDLUtil::isZDLConcept(element, IDL3PlusNames::CONNECTOR_DEFAULT_VALUE_BINDING)){
	    	val container = element.rootContainer
	    	val values = instance.valueSpecifications.toList
	    	if(!values.empty){
	    		val value = values.get(0)
	    		if(value instanceof IRPInstanceValue && (value as IRPInstanceValue).value != null){
		    		val instanceSpecification = (value as IRPInstanceValue).value.transformInstance(container)
			    	if(instanceSpecification != null){
			    		ZDLUtil::setValue(element, IDL3PlusNames::CONNECTOR_DEFAULT_VALUE_BINDING,
			    			IDL3PlusNames::CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE,
			    			instanceSpecification)
			    	}    		
		    	}
	    	}
		}
	}
	
    def dispatch void transformDeploymentValue(Component element, IRPTag instance, IRPModelElement source){
    	val container = element.rootContainer
    	val values = instance.valueSpecifications.toList
    	if(!values.empty){
    		val value = values.get(0)
    		if(value instanceof IRPInstanceValue && (value as IRPInstanceValue).value != null){
	    		val instanceSpecification = (value as IRPInstanceValue).value.transformInstance(container)
		    	if(instanceSpecification != null){
		    		val attr = element.createOwnedAttribute(CXRhapsodyConstants::DEFAULT_PROPERTY_INSTANCE_NAME, null);
		    		val instanceVal = attr.createInstanceValue
		    		instanceVal.setInstance(instanceSpecification)
		    	}    		
	    	}
    	}
	}	
	
	def dispatch void transformDeploymentValue(EObject element, IRPTag instance, IRPModelElement source){
		
	}
	
    def private Slot transformSlot(IRPAttribute slotAttribute, InstanceSpecification instance){
    	val definition = instance.classifiers.get(0)
    	val definingFeature = definition.allAttributes.toList.filter(p | p.name.equals(slotAttribute.name)).head
    	if(definingFeature != null){
    		val slot = instance.createSlot
    		slot.definingFeature = definingFeature
			val instanceValueTags = slotAttribute.instanceValueTags
			instanceValueTags.forEach(IRPTag e | e.transformInstanceValue(slot, instance.eContainer as Package))
			return slot
    	}
    	
    	null
    }
    
    def private void transformInstanceValue(IRPTag tag, Slot slot, Package container){
		val slotValue = slot.createValue(null, null, UMLPackage::eINSTANCE.instanceValue) as InstanceValue
    	val values = tag.valueSpecifications.toList
    	if(!values.empty && values.get(0) instanceof IRPInstanceValue){
    		val instanceValue = values.get(0) as IRPInstanceValue
    		if(instanceValue.value != null){
    			val instanceSpec = instanceValue.value.transformInstance(container)
				slotValue.setInstance(instanceSpec)
    		}
    	}
    }
    
    def private dispatch InstanceSpecification transformInstance(IRPInstance source, Package container){
    	val definingFeature = source.getClassifierTagValue
    	val definition = getTransformedType(definingFeature.fullPathName, container)
    	if(definition != null){
    		val name = source.name
			val instanceSpecification = container.createPackagedElement(name,
								UMLPackage::eINSTANCE.instanceSpecification) as InstanceSpecification
			instanceSpecification.classifiers.add(definition as Classifier)
			val attributes = source.otherClass.attributes.toList
			if(!attributes.empty){
				attributes.forEach(IRPModelElement a | (a as IRPAttribute).transformSlot(instanceSpecification))
			}else{
				val value = source.valueTagValue
				if(value != null){
					val literal = instanceSpecification.createSpecification(null, null,
							UMLPackage::eINSTANCE.literalString) as LiteralString
					literal.setValue(value)
				}
			}
			return instanceSpecification
		}
    	null
    }
    
    def private dispatch InstanceSpecification transformInstance(Object source, Package container){
    	
    }
    
    def private EObject getTransformedType(String rhapsodyElement, EObject context){
    	val result = typeCache.get(rhapsodyElement)
    	if(result == null){
    		var String corbaPrimitive = ""
        	if(rhapsodyElement.equals("void")){
        		corbaPrimitive = "CORBAVoid"
        	}
        	if(rhapsodyElement.startsWith("IDLPrimitives::")){
        		val split = rhapsodyElement.split("::")
        		corbaPrimitive = split.get(1)
        	}
        	if(corbaPrimitive != ""){
        		return CORBAUtil::getCORBAPrimitiveType(context, corbaPrimitive)
        	}
    	}
    	
    	result
    }
    


    
    def private create value : property.createInstanceValueHelper() 
    	createInstanceValue(org.eclipse.uml2.uml.Property property){
    		
    }
    
    def private InstanceValue createInstanceValueHelper(Property property){
    	property.createDefaultValue(null, null,	UMLPackage::eINSTANCE.instanceValue) as InstanceValue
    }
    	
    
    def private dispatch Package getRootContainer(org.eclipse.uml2.uml.Property element){

		var org.eclipse.uml2.uml.Package container = null
		if (element.defaultValue != null) {
			val partInstance = ( element
					.getDefaultValue() as InstanceValue).instance
			container = partInstance.eContainer() as org.eclipse.uml2.uml.Package
		}
		if (container == null) {
			val containerName = NamingUtil::generateUniqueName("_" //$NON-NLS-1$
					+ element.name, element.eContainer()
					.eContents());
			val partContainer = element.eContainer();
			container = partContainer.createPackage(containerName)
		}
		container	
    }
    
    def private dispatch Package getRootContainer(Component element){

		var org.eclipse.uml2.uml.Package container = null
		val attr = element.getOwnedAttribute(CXRhapsodyConstants::DEFAULT_PROPERTY_INSTANCE_NAME, null)
		if (attr != null && attr.defaultValue != null) {
			val partInstance = ( attr
					.getDefaultValue() as InstanceValue).instance
			container = partInstance.eContainer() as org.eclipse.uml2.uml.Package
		}
		if (container == null) {
			val containerName = NamingUtil::generateUniqueName("_" //$NON-NLS-1$
					+ element.name, element.eContainer()
					.eContents());
			val partContainer = element.eContainer();
			container = partContainer.createPackage(containerName)
		}
		container	
    }
    
    def private dispatch Package getRootContainer(Package element){
		return element
	}
    def private dispatch Package getRootContainer(EObject element){
    	
    }

}