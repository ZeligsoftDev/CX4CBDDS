package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPPackage
import com.telelogic.rhapsody.core.IRPProfile
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.dds4ccm.rhapsody.util.RhapsodyZDLUtil
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule
import org.eclipse.uml2.uml.Package
import com.zeligsoft.domain.omg.ccm.util.CCMUtil

class CORBAModuleRhapsodyExt {
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyZDLUtil
    @Inject extension RhapsodyImportTraversal

    def dispatch void importPackageOrModule(IRPPackage source, Package context) {
        val name = source.name
        if("_DeploymentValues".equals(name)){
        	return
        }
        
        val packagedElements = source.nestedElements.toList
        if(source.isZDLConcept(CORBADomainNames::CORBAMODULE)) {
            val module = createCorbaModule(context, name)
            packagedElements.forEach(IRPModelElement pkgE | pkgE.map(module))
        } else {
            val newPkg = context.createNestedPackage(source.name)
            val tag = source.getTag("idlGenCreateDirectory")
           
            if(tag != null && Boolean::toString(false).equals(tag.value)){
            	// set annotation for create directory during generation 
            	CCMUtil::putZCXAnnotationDetail(newPkg, "generatedir", Boolean::toString(false));
            }
            packagedElements.forEach(IRPModelElement pkgE | pkgE.map(newPkg))
        }
    }
    
    def dispatch void importPackageOrModule(IRPPackage source, CORBAModule context) {
        importPackageOrModule(source, context.asPackage)
    }
    
    def dispatch void importPackageOrModule(IRPModelElement source, Object context) {
    	
    }
    
    def dispatch void importPackageOrModule(IRPProfile source, Object context) {
    	
    }
    
}