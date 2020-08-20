package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier
import com.google.inject.Inject
import org.eclipse.uml2.common.util.UML2Util

class JavaEnumerationGenerator {
    @Inject extension JavaNamingExtensions
	def dispatch compileEnumeration(GenDomainEnum element, String pkg)'''
	package «element.block.interfaceJavaPackage»;
	
	«element.generateEnumerationImports»
	
	/**
	 * An enumeration for «element.domainElement.qualifiedName»
	 *
	 * @author ZDL API Generator
	 *
	 */
	public enum «UML2Util::getValidJavaIdentifier(element.name)» {
	    «FOR literal : element.literals SEPARATOR ",\n"»
	    /**
	     * 
	     «FOR comment : literal.domainElement.ownedComments»
	     * «comment.body»
	     «ENDFOR»
	     *
	     */
	    «literal.name.toUpperCase» {
	    	public EObject eObject(EObject context) {
	    		return ZDLUtil.getZDLEnumLiteral(context,
					"«element.domainElement.qualifiedName»", "«literal.name»");
	    	}
	    	
	    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
	    		return eObject(context.eObject());
	    	}
	    }
	    «ENDFOR»«IF !element.literals.empty»,«ENDIF»
	    /**
	     * Literal for cases when the value is UNKNOWN
	     */
	    UNKNOWN {
	    	public EObject eObject(EObject context) {
	    		return null;
	    	}
	    	
	    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
	    		return null;
	    	}
	    };
	    
	    «element.generateCreateMethod»
	    
	    public abstract EObject eObject(EObject context);
	    public abstract EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context);
	}
	'''
	
	def dispatch compileEnumeration(GenDomainClassifier element, String pkg)'''
    '''
    
    def private generateEnumerationImports(GenDomainEnum element)'''
    import org.eclipse.emf.ecore.EObject;
    
    import com.zeligsoft.base.zdl.util.ZDLUtil;
    '''
    
    def private generateCreateMethod(GenDomainEnum element)'''
    /**
     * @param literal
     *    the raw object to create the instance from
     * @return
     *    an instance of this enumeration based on the literal passed in and
     *    UNKNOWN if the literal is unrecognized
     */
    public static «UML2Util::getValidJavaIdentifier(element.name)» create(EObject literal) {
        «FOR literal : element.literals BEFORE "if " SEPARATOR " else if "»(literal == ZDLUtil.getZDLEnumLiteral(literal, "«element.domainElement.qualifiedName»", "«literal.name»")) { //$NON-NLS-1$//$NON-NLS-2$
            return «literal.name.toUpperCase»;
        }
        «ENDFOR»«IF element.literals.empty»return UNKNOWN;«ELSE» else {
            return UNKNOWN;
        }«ENDIF»
    }
    '''
}