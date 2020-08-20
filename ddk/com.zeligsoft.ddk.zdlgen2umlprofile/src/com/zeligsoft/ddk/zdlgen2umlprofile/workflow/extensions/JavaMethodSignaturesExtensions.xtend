package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.google.inject.Inject
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature

class JavaMethodSignaturesExtensions {
	@Inject extension GenDomainStructuralFeatureExtensions
	
	def dispatch String compositeMultivaluedAddExistingSignature(GenDomainStructuralFeature feature) ''''''
	
	def dispatch String compositeMultivaluedAddExistingSignature(GenDomainAttribute feature) {
		'''void add«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)'''
	}
	
	def dispatch String compositeMultivaluedAddExistingSignature(GenDomainReference feature) {
		'''void add«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)'''
	}
	
	def dispatch String compositeMultivaluedAddParemeterizedSignature(GenDomainAttribute feature) {
		'''<T extends «feature.featureModifierType»> T add«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(Class<T> typeToCreate, String concept)'''
	}
	
	def dispatch String compositeMultivaluedAddParemeterizedSignature(GenDomainReference feature) {
		'''<T extends «feature.featureModifierType»> T add«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(Class<T> typeToCreate, String concept)'''
	}
	
	def dispatch String compositeMultivalueAddSignature(GenDomainAttribute feature) {
		'''«feature.featureModifierType» add«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»()'''
	}
	
	def dispatch String compositeMultivalueAddSignature(GenDomainReference feature) {
		'''«feature.featureModifierType» add«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»()'''
	}
	
	def dispatch String compositeAddExistingSignature(GenDomainAttribute feature) {
		'''
		void set«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
	    '''
	}
	
	def dispatch String compositeAddExistingSignature(GenDomainReference feature) {
		'''
		void set«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
	    '''
	}
	
	def dispatch String compositeAddParemeterizedSignature(GenDomainAttribute feature) {
		'''
		<T extends «feature.featureModifierType»> T create«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(Class<T> typeToCreate, String concept)
	    '''
	}
	
	def dispatch String compositeAddParemeterizedSignature(GenDomainReference feature) {
		'''
		<T extends «feature.featureModifierType»> T create«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(Class<T> typeToCreate, String concept)
	    '''
	}
	
	def dispatch String compositeAddSignature(GenDomainAttribute feature) {
		'''
		«feature.featureModifierType» create«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»()
		'''		
	}
	
	def dispatch String compositeAddSignature(GenDomainReference feature) {
		'''
		«feature.featureModifierType» create«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»()
		'''		
	}
	
	def dispatch String sharedMultivaluedAddSignature(GenDomainAttribute feature) {
		'''
		void add«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
		'''}
		
	def dispatch String sharedMultivaluedAddSignature(GenDomainReference feature) {
		'''
		void add«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
		'''}
		
	def dispatch String sharedAddSignature(GenDomainStructuralFeature feature) ''''''
	
	def dispatch String sharedAddSignature(GenDomainAttribute feature) {
		'''
		void set«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
		'''}
		
	def dispatch String sharedAddSignature(GenDomainReference feature) {
		'''
		void set«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
		'''}
		
	def dispatch String noneMultivaluedAddSignature(GenDomainStructuralFeature feature) ''''''
	
	def dispatch String noneMultivaluedAddSignature(GenDomainAttribute feature) {
		'''
		void add«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
		'''}
		
	def dispatch String noneMultivaluedAddSignature(GenDomainReference feature) {
		'''
		void add«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
		'''}
	
	def dispatch String noneAddSignature(GenDomainStructuralFeature feature) ''''''
	
	def dispatch String noneAddSignature(GenDomainAttribute feature) {
		'''
		void set«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
		'''
	}
	
	def dispatch String noneAddSignature(GenDomainReference feature) {
		'''
		void set«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»(«feature.featureModifierType» val)
		'''
	}
	
	def dispatch String accessorSignature(GenDomainStructuralFeature feature) ''''''
	
	def dispatch String accessorSignature(GenDomainAttribute feature) {
		'''«feature.featureAccessorReturnType» «feature.accessorName»()'''
	}
	
	def dispatch String accessorSignature(GenDomainReference feature) {
		'''«feature.featureAccessorReturnType» «feature.accessorName»()'''
	}
	
	def dispatch String accessorName(GenDomainStructuralFeature feature) ''''''
	
	def dispatch String accessorName(GenDomainAttribute feature) {
		'''get«feature.domainElement.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»'''
	}
	
	def dispatch String accessorName(GenDomainReference feature) {
		'''get«feature.domainAttribute.name.toFirstUpper»«IF feature.isInconsistentOverride»«feature.inconsistentOverrideString»«ENDIF»'''
	}
}