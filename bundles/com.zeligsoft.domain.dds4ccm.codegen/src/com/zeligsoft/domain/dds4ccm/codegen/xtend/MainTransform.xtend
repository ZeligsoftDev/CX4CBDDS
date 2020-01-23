package com.zeligsoft.domain.dds4ccm.codegen.xtend

import com.google.inject.Inject
import com.zeligsoft.base.util.BaseUtil
import com.zeligsoft.base.zdl.staticapi.util.ZListExtensions
import com.zeligsoft.base.zdl.staticapi.xtend.ZDLStandardLibrary
import com.zeligsoft.base.zdl.util.ZDLUtil
import com.zeligsoft.cx.codegen.UserEditableRegion
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileDependency
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoFactory
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.CCMComponent
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl.HomeImplementation
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.MonolithicImplementation
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface
import com.zeligsoft.domain.zml.api.ZML_Component.Port
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunction
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement
import com.zeligsoft.domain.zml.util.WorkerFunctionUtil
import com.zeligsoft.domain.zml.util.ZMLMMNames
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.common.util.UML2Util
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.Package

class MainTransform {
    @Inject extension ZListExtensions
    @Inject extension ZDLStandardLibrary
    
	def create result : CodetaginfoFactory::eINSTANCE.createCodeTagInfo mainTransform(MonolithicImplementation impl) {
	    
	    result.filename.add(impl.fileName)
	    val sortedOps = BaseUtil::sortEObjectsByName(impl.asComponent.ownedOperations)
	    for(op : sortedOps) {
	    	val worker = (op as Operation).zObject
	    	if(worker instanceof WorkerFunction){
	      		result.codetag.addAll((worker as WorkerFunction).createCodeTag(impl))
	        }
	    }
	    
	}
	
	def create result : CodetaginfoFactory::eINSTANCE.createCodeTag createCodeTag(WorkerFunction worker, MonolithicImplementation impl) {
		if( worker.name.startsWith("_attr_")) {
			result.name.add(worker.name.substring(6, worker.name.length - 4))
		} else if( worker.name.startsWith("_pattr_")) {
			result.name.add(worker.name.substring(7, worker.name.length - 4).split("___").get(1))		
        } else if( worker.name.startsWith("_hattr_")) {
			result.name.add(worker.name.substring(7, worker.name.length - 4).split("___").get(1))		
        } else if(prependName(worker)) {
            result.name.add(impl.name + worker.name)
        } else {
        	if(worker.name.contains("_EPI_")){
        		result.name.add(worker.name.replace("_EPI_", "_"))
        	}else {
            	result.name.add(worker.name)
            }
        }
        
        result.uuid.add(worker.uuid)
        result.type.add(worker.workerType)
        result.tag_begin.add(worker.userEditBegin("C++"))
        result.contents.add(worker.workerFunctionCode("C++").xmlEncode)
        result.tag_end.add(userEditEnd)
        result.contextinfo.add(worker.createContext)
    }
    
    def create result : CodetaginfoFactory::eINSTANCE.createCodeTagContext createContext(WorkerFunction worker) {
        val workerType = worker.workerType
        result.component_name.add(worker.workerOwnerName)
        if(worker.name.startsWith("_home_")) {
            result.class_name.add('''«worker.home.name»_exec_i'''.toString)
        } else if(worker.hasClassName) {
            result.class_name.add(worker.getClassName())
        }
        
        if(workerType == CodeTagType::CLASSGENERATEDOPERATIONIMPL) {
            result.operation_name.add(worker.getOperationName(result.class_name))
        }
    }
    
    def getOperationName(WorkerFunction worker, org.eclipse.emf.common.util.EList<String> class_name) {
    	var result = worker.trimPrefix
		if(worker.name.endsWith("destructor_operation_impl") || worker.name.endsWith("constructor_operation_impl")) {
			if(!class_name.empty){
				result = class_name.get(0)
			}
	        if(worker.name.endsWith("destructor_operation_impl")){
	    		result = "~" + result
	    	}
	    } 
	    result
	}
	
	def private dispatch String fileName(MonolithicImplementation self) {
	    val Object container = self.zContainer
	    container.fileName(self.asNamedElement.name) + ".taginfo.xml"
	}
	
	def private dispatch String fileName(ComponentInterface self) {
	    throw new IllegalArgumentException("Shouldn't be getting filenames for raw ComponentInterface")
	}
	
	def private dispatch String fileName(Object self, String name) {
	    name;
	}
	
	def private dispatch String fileName(CORBAModule self, String name) {
	    val List<IDLFileDependency> filedependency = self.asNamedElement.clientDependencies.typeSelect(IDLFileDependency::type)//self.asPackage.clientDependencies.filter(IDLFileDependency::typeSelect).map(CreateZDLWrapper::create(IDLFileDependency.class))
	    if(!filedependency.empty) {
	        val firstFileDependency = filedependency.head
	        self.zContainer.fileName('''«firstFileDependency.file.filename»_«name»'''.toString)
	    } else {
	        self.zContainer.fileName('''«self.name»_«name»'''.toString)
	    }
	    
	}
	
	def private dispatch String fileName(Void self, String name) {
	    name;
	}
	
	def private dispatch String fileName(NamedElement self, String name) {
	    self.zContainer.fileName(name)
	}

	def private dispatch String fileName(Package self, String name) {
	    self.zContainer.fileName(name)
	}
	
	def private prependName(WorkerFunction worker) {
	    if( worker.name.startsWith("_home_")) {
	    	 true
	    } else if(worker.workerTypeForNullPort != CodeTagType::CLASSGENERATEDOPERATIONIMPL) {
	    	if( worker.name.contains("_CSL_") || worker.name.contains("_EPI_")) {
	    		false
	    	} else {
	        	true
	        }
	    } else if(worker.name.equals("_destructor_operation_impl") || worker.name.equals("_constructor_operation_impl")){
	    	return true
	    } else {
	        switch(worker.name) {
	            case "_ccm_activate" :
	               true
               case "_ccm_passivate" :
                   true
               case "_ccm_remove" :
                   true
               case "_configuration_complete" :
                   true
               default:
                   false
	        }
	    }
	}
	
	def CodeTagType getWorkerType(WorkerFunction worker) {
	    if(worker.receivingPort != null) {
	        getWorkerTypeForNonNullPort(worker)
	    } else {
	    	if( worker.name.startsWith("_attr_") ||
	    		worker.name.startsWith("_pattr_") ||
	    		worker.name.startsWith("_hattr_")
	    	) {
	    		if( worker.name.endsWith("_get")) {
	    			CodeTagType::CLASSGENERATEDATTRIBUTEGET
	    		} else {
	    			CodeTagType::CLASSGENERATEDATTRIBUTESET
	    		}
	    	} else {
	        	getWorkerTypeForNullPort(worker)
	        }
	    }
	}
	
	def CodeTagType getWorkerTypeForNonNullPort(WorkerFunction worker) {
	    val portname = worker.receivingPort.name
	    switch(worker.name) {
	        case portname + "_constructor_init_list" :
	           CodeTagType::CONSTRUCTORINITLIST
			case portname + "_class_public_methods_section_declare" :
				CodeTagType::CLASSPUBLICMETHODSSECTIONDECLARE
			case portname + "_class_public_methods_section_impl" :
				CodeTagType::CLASSPUBLICMETHODSSECTIONIMPL
			case portname + "_class_private_methods_section_declare" :
				CodeTagType::CLASSPRIVATEMETHODSSECTIONDECLARE
			case portname + "_class_private_methods_section_impl" :
				CodeTagType::CLASSPRIVATEMETHODSSECTIONIMPL
			case portname + "_class_private_members_section_declare" :
				CodeTagType::CLASSPRIVATEMEMBERSSECTIONDECLARE
			default :
				CodeTagType::CLASSGENERATEDOPERATIONIMPL
	    }
	}
	
	def CodeTagType getWorkerTypeForNullPort(WorkerFunction worker) {
	    val Home home = worker.zContainer.getHome
	    val homePrefix = home.homePrefix

	    if( worker.name.contains("_CSL_") || worker.name.contains("_EPI_")) {
			if( worker.name.contains("_constructor_init_list")) {
				CodeTagType::CONSTRUCTORINITLIST
			} else if( worker.name.contains("_class_public_methods_section_declare")) {
				CodeTagType::CLASSPUBLICMETHODSSECTIONDECLARE
			} else if( worker.name.contains("_class_public_methods_section_impl")) {
				CodeTagType::CLASSPUBLICMETHODSSECTIONIMPL
			} else if( worker.name.contains("_class_private_methods_section_declare")) {
				CodeTagType::CLASSPRIVATEMETHODSSECTIONDECLARE
			} else if( worker.name.contains("_class_private_methods_section_impl")) {
				CodeTagType::CLASSPRIVATEMETHODSSECTIONIMPL
			} else if( worker.name.contains("_class_private_members_section_declare")) {
				CodeTagType::CLASSPRIVATEMEMBERSSECTIONDECLARE
			} else {
				CodeTagType::CLASSGENERATEDOPERATIONIMPL
			}
		} else {

		    switch(worker.name) {
	            case "_file_header_h" :
	                CodeTagType::FILEHEADERH
	            case "_file_header_cpp" :
	                CodeTagType::FILEHEADERCPP
	            case "_file_footer_h" :
	                CodeTagType::FILEFOOTERH
	            case "_file_footer_cpp" :
	                CodeTagType::FILEFOOTERCPP
	            case "_file_includes_h" :
	                CodeTagType::FILEINCLUDESH
	            case "_file_includes_cpp" :
	                CodeTagType::FILEINCLUDESCPP
	            case "_constructor_init_list" :
	                CodeTagType::CONSTRUCTORINITLIST
	            case "_class_public_methods_section_declare" :
	                CodeTagType::CLASSPUBLICMETHODSSECTIONDECLARE
	            case "_class_public_methods_section_impl" :
	                CodeTagType::CLASSPUBLICMETHODSSECTIONIMPL
	            case "_class_private_methods_section_declare" :
	                CodeTagType::CLASSPRIVATEMETHODSSECTIONDECLARE
	            case "_class_private_methods_section_impl" :
	                CodeTagType::CLASSPRIVATEMETHODSSECTIONIMPL
	            case "_class_private_members_section_declare" :
	                CodeTagType::CLASSPRIVATEMEMBERSSECTIONDECLARE
	            case homePrefix + "_constructor_init_list" :
	                CodeTagType::CONSTRUCTORINITLIST
	            case homePrefix + "_class_public_methods_section_declare" :
	                CodeTagType::CLASSPUBLICMETHODSSECTIONDECLARE
	            case homePrefix + "_class_public_methods_section_impl" :
	                CodeTagType::CLASSPUBLICMETHODSSECTIONIMPL
	            case homePrefix + "_class_private_methods_section_declare" :
	                CodeTagType::CLASSPRIVATEMETHODSSECTIONDECLARE
	            case homePrefix + "_class_private_methods_section_impl" :
	                CodeTagType::CLASSPRIVATEMETHODSSECTIONIMPL
	            case homePrefix + "_class_private_members_section_declare" :
	                CodeTagType::CLASSPRIVATEMEMBERSSECTIONDECLARE
	            default :
	                CodeTagType::CLASSGENERATEDOPERATIONIMPL
	        }
		}
	}
	
	def dispatch Home getHome(WorkerFunction worker) {
	    val owner = worker.asOperation.zContainer
	    if(owner == null) {
	        throw new IllegalArgumentException("Worker needs to have an owner")
	    }
	    
	    if(!(owner instanceof MonolithicImplementation)) {
	        throw new IllegalArgumentException("Worker needs an owner that is a MonolithicImplementation")
	    }
	    
	    (owner as MonolithicImplementation).getHome
	}
	
	def dispatch Home getHome(MonolithicImplementation impl) {
	    impl.interface.getHome
	}
	
	def dispatch Home getHome(CCMComponent component) {
	    var Home home = null;
	    for(s : UML2Util::getInverseReferences(component.asComponent)) {
	        if(s.getEObject() != null && ZDLUtil::isZDLConcept(s.getEObject(), "CCM::CCM_Component::Manages")) {
	            val EObject value = ZDLUtil::getValue(s.getEObject(), "CCM::CCM_Component::Manages", "home") as EObject;
	            home = new HomeImplementation(value)
	        }
	    }
	    
	    home
	}
	
	def dispatch Home getHome(Object component) {
	    null
	}
	
	def homePrefix(Home home) {
	    if(home != null) {
	        '''_home_«home.name»'''.toString
	    } else {
	        ""
	    }
	}
	
	def trimPrefix(WorkerFunction worker) {
	    var workerName = worker.name
	    val port = worker.receivingPort
	    var String portName = null
	    
	    if(port != null) {
	        portName = port.name
	    }
	    
	    if(portName != null) {
	        if(workerName.startsWith(portName)) {
	            workerName = workerName.substring(portName.length())
	        }
	    }

        if(workerName.startsWith("_home") && workerName.endsWith("_create")){
        	workerName = "create"
        }
        	    
	    if(workerName.startsWith("_")){
            workerName = workerName.substring(1)
        }
        
        if(worker.portOperation != null) {
        	workerName = worker.portOperation.name
        }
        
        workerName
	}
	
	def boolean hasClassName(WorkerFunction worker) {

		switch(worker.name) {
            case "_file_header_h" :
                false
            case "_file_header_cpp" :
                false
            case "_file_footer_h" :
                false
            case "_file_footer_cpp" :
                false
            case "_file_includes_h" :
                false
            case "_file_includes_cpp" :
                false            
            default :
                true
        }
		
	}
	
	def getClassName(WorkerFunction worker) {
		if(worker.name.startsWith("_pattr_")) {
			worker.name.substring(7, worker.name.length - 4).split("___").get(0) + "_exec_i"
		} else if( worker.name.startsWith("_hattr_")) {
			worker.name.substring(7, worker.name.length - 4).split("___").get(0) + "_exec_i"
		} else if(worker.receivingPort == null) {
	        val owner = worker.asOperation.owner
	        if( worker.name.contains("_CSL_")) {
	        	worker.name.split("_CSL_").get(0) + "_CSL_exec_i"
	        } 
	        else if(worker.name.contains("_EPI_")){
	        	worker.name.split("_EPI_").get(0) + "_exec_i"
	        }
	        else if(owner instanceof org.eclipse.uml2.uml.NamedElement){
	            val ownerName = (owner as org.eclipse.uml2.uml.NamedElement).name
	            '''«ownerName»_exec_i'''.toString
	        } else {
	            throw new IllegalArgumentException()
	        }
	    } else {
	        worker.getClassName(worker.receivingPort)
	    }
	}
	
	def dispatch String getClassName(WorkerFunction worker, InterfacePort port) {
	    if(port.isConjugated) {
	        '''AMI4CCM_«port.asPort.type.name»ReplyHandler_«port.name»_i'''.toString
	    } else {
	        '''«port.name»_exec_i'''.toString
	    }
	}
	
	def dispatch String getClassName(WorkerFunction worker, Port port) {
	    throw new UnsupportedOperationException()
	}
	
	def getContents(WorkerFunction worker) {
	    worker.workerCode("C++")
	}
	
	def private workerCode(WorkerFunction worker, String language) '''
	   «UserEditableRegion::userEditBegin(worker.asOperation, ZMLMMNames::WORKER_FUNCTION, ZMLMMNames::WORKER_FUNCTION__BODY,language)»
	   «WorkerFunctionUtil::getWorkerFunctionImplementationCode(worker.asOperation.owner, worker.asOperation, language)»
	   «UserEditableRegion::userEditEnd»
	   
	    '''
	
	
	def private workerOwnerName(WorkerFunction worker) {
	    val owner = worker.asOperation.owner 
        if(owner instanceof org.eclipse.uml2.uml.NamedElement){
            val ownerName = (owner as org.eclipse.uml2.uml.NamedElement).name
            '''«ownerName»'''.toString
        } else {
            ""
        }
	}
	
	def private userEditBegin(WorkerFunction worker, String language) {
	    UserEditableRegion::userEditBegin(worker.eObject, ZMLMMNames::WORKER_FUNCTION, "body", language)
	}
	
	def private userEditEnd() {
	    UserEditableRegion::userEditEnd
	}
	
	def private workerFunctionCode(WorkerFunction worker, String language) {
	    WorkerFunctionUtil::getWorkerFunctionImplementationCode(worker.asOperation.owner, worker.asOperation, language)
	}
	
	def private xmlEncode(String s) {
		s.replaceAll(">", "zcxgt;").replaceAll("'", "zcxapos;")
	}
	   
}