package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.google.inject.Inject
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum

class JavaImportExtensions {
    @Inject extension JavaNamingExtensions
	
	def dispatch generateImport(GenDomainClassifier concept) {
	    ''''''
	}
	
	def dispatch generateImport(GenDomainConcept concept) {
	    '''import «concept.qualifiedName»;'''
	}
	
	def dispatch generateImport(GenDomainEnum denum) {
	   '''import «denum.qualifiedName»;'''   
	}
	
	def dispatch generateImplementationImport(GenDomainClassifier concept) {
	    ''''''
	}
	
	def dispatch generateImplementationImport(GenDomainConcept concept) {
        '''import «concept.implementationQualifiedName»;'''
    }
}