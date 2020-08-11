package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.google.inject.Inject
import com.google.inject.name.Named
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock
import static org.eclipse.uml2.uml.util.UMLUtil.*
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum

class JavaNamingExtensions {
	@Inject @Named('Root Package')String rootPackage
    @Inject @Named('Implementation SubPackage')String implSubPackage
    @Inject @Named('Implementation Suffix')String implSuffix
    
    @Inject extension ZDLGenExtensions
    
    def interfaceJavaPackage(GenDomainBlock block) {
        val blockName = getValidJavaIdentifier(block.name)
        interfaceJavaPackage(rootPackage, blockName)
    }
    
    def private interfaceJavaPackage(String theRootPackage, String theBlockName) {
        '''«theRootPackage».«theBlockName»'''.toString
    }
    
    def qualifiedName(GenDomainConcept concept) {
        val block = concept.block
        val domain = block.domainModel
        
        if(domain == null) {
            ""
        } else {
            qualifiedName(domain.rootPackage, block.name, concept.name)
        }
    }
    
    def qualifiedName(GenDomainEnum concept) {
        val block = concept.block
        val domain = block.domainModel
        
        if(domain == null) {
            ""
        } else {
            qualifiedName(domain.rootPackage, block.name, concept.name)
        }
    }
    
    def private qualifiedName(String theRootPackage, String blockName, String conceptName){
        '''«interfaceJavaPackage(theRootPackage, blockName)».«conceptName»'''.toString
    }
    
    def implementationQualifiedName(GenDomainConcept concept) {
        val block = concept.block
        val domain = block.domainModel
        
        if(domain == null) {
            ""
        } else {
            qualifiedName(domain.rootPackage, block.name, concept.name, 
                domain.implementationSubPackage, domain.implSuffix)
        }
    }
    
    def private qualifiedName(String theRootPackage, String blockName,
        String conceptName, String theImplSubPackage, String theImplSuffix) {
        '''«implementationJavaPackage(theRootPackage, blockName, theImplSubPackage)».«conceptName»«theImplSuffix»'''
    }
    
    def implementationJavaPackage(GenDomainBlock block) {
        val blockName = getValidJavaIdentifier(block.name)
        implementationJavaPackage(rootPackage, blockName, implSubPackage)
    }
    
    def private implementationJavaPackage(String theRootPackage, 
            String theBlockName, String theImplSubPackage) {
        '''«theRootPackage».«theBlockName».«theImplSubPackage»'''.toString
    }
    
    def dispatch javaInterfaceName(GenDomainConcept concept) {
        getValidJavaIdentifier(concept.name)
    }
    
    def dispatch javaInterfaceName(GenDomainEnum genum) {
        getValidJavaIdentifier(genum.name)
    }
    
    def dispatch javaImplementationName(GenDomainEnum genum) {
        val block = genum.block
        val domain = block.domainModel
        
        if(domain == null) {
            ""
        } else {
            val implSuffix = domain.implSuffix
            '''«getValidJavaIdentifier(genum.name)»«implSuffix»'''.toString
        }
    }
    
    def dispatch javaImplementationName(GenDomainConcept concept) {
        val block = concept.block
        val domain = block.domainModel
        
        if(domain == null) {
            ""
        } else {
            val implSuffix = domain.implSuffix
            '''«getValidJavaIdentifier(concept.name)»«implSuffix»'''.toString
        }
    }
}