package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept

class ZDLGenExtensions {
	def dispatch GenDomainModel domainModel(GenDomainConcept concept) {
        concept.block.domainModel
    }
    
    def dispatch GenDomainModel domainModel(GenDomainBlock block) {
        block.eContainer.domainModel
    }
    
    def dispatch GenDomainModel domainModel(GenDomainPackage pkg) {
        pkg.eContainer.domainModel
    }
    
    def dispatch GenDomainModel domainModel(GenDomainModel model) {
        model
    }
    
    def dispatch GenDomainModel domainModel(Object eobj) {
        null
    }
}