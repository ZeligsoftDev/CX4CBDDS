package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.google.inject.Inject
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel
import java.util.Set

class JavaUMLPackageTypeSelectUtilGenerator {
    @Inject extension GenDomainModelExtensions
    @Inject extension JavaNamingExtensions
    @Inject extension JavaImportExtensions
    
    def generateJavaUMLPackageTypeSelectUtil(GenDomainModel model) {
    val packageableElementTypes = model.packageableElementTypes
    '''
    package «model.rootPackage».«model.name».util;
    
    import java.util.Collection;
    import java.util.List;
    
    import org.eclipse.uml2.uml.PackageableElement;
    
    import com.google.common.collect.Collections2;
    import com.google.common.collect.ImmutableList;
    
    import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;
    import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;
    
    «FOR type : packageableElementTypes»
    «type.generateImport»
    «ENDFOR»
    
    public class «model.name»TypeSelectUtil {
        «FOR type : packageableElementTypes»
        public List<«type.javaInterfaceName»> select«type.name.toFirstUpper»(org.eclipse.uml2.uml.Package pkg) {
            final Collection<PackageableElement> elements = 
                Collections2.filter(pkg.getPackagedElements(),
                    new IsZDLConcept("«type.domainElement.qualifiedName»"));
            final Collection<«type.javaInterfaceName»> result = 
                Collections2.transform(elements, CreateZDLWrapper.create(«type.javaInterfaceName».class));
            return new ImmutableList.Builder<«type.javaInterfaceName»>().addAll(result).build();
            
        }
        
        «ENDFOR»
    }
    '''}
    
	def packageableElementTypes(GenDomainModel model) {
	    model.domainBlocks.map(GenDomainBlock block | block.packageableElementTypes).flatten
	}
	
	def packageableElementTypes(GenDomainBlock block) {
	    block.classifiers.filter(GenDomainClassifier classifier | classifier.mapsToPackageableElement)
	}
	
	def private dispatch mapsToPackageableElement(GenDomainClassifier classifier) {
	    false
	}
	
	def private dispatch mapsToPackageableElement(GenDomainConcept classifier) {
        var result = false
        result = classifier.umlMetaclassMapping.exists(base | base.name.equals("PackageableElement")
            || base.allParents.exists(parent | parent.name.equals("PackageableElement")))
        result
    }
    
    def private umlMetaclassMapping(GenDomainConcept concept) {
        val Set<org.eclipse.uml2.uml.Class> metaclasses = newHashSet()
        val baseMetaclasses =
            concept.allGenerals.map(GenDomainConcept base | base.umlMetaclasses).flatten
        metaclasses.addAll(concept.umlMetaclasses)
        metaclasses.addAll(baseMetaclasses)
        metaclasses
    }
}