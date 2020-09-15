package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for CCM::CCM_Implementation::ComponentCategory
 *
 * @author ZDL API Generator
 *
 */
public enum ComponentCategory {
	/**
	 * 
	 *
	 */
	SESSION {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "CCM::CCM_Implementation::ComponentCategory", "SESSION");
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
	SERVICE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "CCM::CCM_Implementation::ComponentCategory", "SERVICE");
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
	public static ComponentCategory create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal, "CCM::CCM_Implementation::ComponentCategory", "SESSION")) { //$NON-NLS-1$//$NON-NLS-2$
			return SESSION;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "CCM::CCM_Implementation::ComponentCategory", //$NON-NLS-1$
				"SERVICE")) { //$NON-NLS-1$
			return SERVICE;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
