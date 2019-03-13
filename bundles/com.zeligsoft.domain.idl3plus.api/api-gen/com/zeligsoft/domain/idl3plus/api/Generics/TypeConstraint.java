package com.zeligsoft.domain.idl3plus.api.Generics;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for IDL3Plus::Generics::TypeConstraint
 *
 * @author ZDL API Generator
 *
 */
public enum TypeConstraint {
    /**
     * 
     *
     */
    TYPENAME {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "typename");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    },
    
        /**
     * 
     *
     */
    INTERFACE {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "interface");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    },
    
        /**
     * 
     *
     */
    VALUETYPE {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "valuetype");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    },
    
        /**
     * 
     *
     */
    EVENTTYPE {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "eventtype");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    },
    
        /**
     * 
     *
     */
    STRUCT {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "struct");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    },
    
        /**
     * 
     *
     */
    UNION {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "union");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    },
    
        /**
     * 
     *
     */
    SEQUENCE {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "sequence");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    },
    
        /**
     * 
     *
     */
    ARRAY {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "array");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    },
    
        /**
     * 
     *
     */
    ENUM {
    	public EObject eObject(EObject context) {
    		return ZDLUtil.getZDLEnumLiteral(context,
					"IDL3Plus::Generics::TypeConstraint", "enum");
    	}
    	
    	public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
    		return eObject(context.eObject());
    	}
    }
    ,
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
    
    /**
     * @param literal
     *    the raw object to create the instance from
     * @return
     *    an instance of this enumeration based on the literal passed in and
     *    UNKNOWN if the literal is unrecognized
     */
    public static TypeConstraint create(EObject literal) {
        if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "typename")) { //$NON-NLS-1$//$NON-NLS-2$
            return TYPENAME;
        } else if 
        (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "interface")) { //$NON-NLS-1$//$NON-NLS-2$
            return INTERFACE;
        } else if 
        (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "valuetype")) { //$NON-NLS-1$//$NON-NLS-2$
            return VALUETYPE;
        } else if 
        (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "eventtype")) { //$NON-NLS-1$//$NON-NLS-2$
            return EVENTTYPE;
        } else if 
        (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "struct")) { //$NON-NLS-1$//$NON-NLS-2$
            return STRUCT;
        } else if 
        (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "union")) { //$NON-NLS-1$//$NON-NLS-2$
            return UNION;
        } else if 
        (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "sequence")) { //$NON-NLS-1$//$NON-NLS-2$
            return SEQUENCE;
        } else if 
        (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "array")) { //$NON-NLS-1$//$NON-NLS-2$
            return ARRAY;
        } else if 
        (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "enum")) { //$NON-NLS-1$//$NON-NLS-2$
            return ENUM;
        }
         else {
            return UNKNOWN;
        }
    }
    
    public abstract EObject eObject(EObject context);
    public abstract EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
