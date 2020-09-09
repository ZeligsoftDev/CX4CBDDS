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
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "typename");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	INTERFACE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "interface");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	VALUETYPE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "valuetype");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	EVENTTYPE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "eventtype");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	STRUCT {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "struct");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	UNION {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "union");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	SEQUENCE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "sequence");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	ARRAY {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "array");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	ENUM {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "IDL3Plus::Generics::TypeConstraint", "enum");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},
	/**
	 * Literal for cases when the value is UNKNOWN
	 */
	UNKNOWN {
		@Override
		public EObject eObject(EObject context) {
			return null;
		}

		@Override
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
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "interface")) { //$NON-NLS-1$//$NON-NLS-2$
			return INTERFACE;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "valuetype")) { //$NON-NLS-1$//$NON-NLS-2$
			return VALUETYPE;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "eventtype")) { //$NON-NLS-1$//$NON-NLS-2$
			return EVENTTYPE;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "struct")) { //$NON-NLS-1$//$NON-NLS-2$
			return STRUCT;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "union")) { //$NON-NLS-1$//$NON-NLS-2$
			return UNION;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "sequence")) { //$NON-NLS-1$//$NON-NLS-2$
			return SEQUENCE;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "array")) { //$NON-NLS-1$//$NON-NLS-2$
			return ARRAY;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "IDL3Plus::Generics::TypeConstraint", "enum")) { //$NON-NLS-1$//$NON-NLS-2$
			return ENUM;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
