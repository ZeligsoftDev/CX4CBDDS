package com.zeligsoft.domain.omg.dds.api.QOS;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS::QOS::HistoryQosPolicyKind
 *
 * @author ZDL API Generator
 *
 */
public enum HistoryQosPolicyKind {
	/**
	 * 
	 *
	 */
	KEEP_LAST {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "DDS::QOS::HistoryQosPolicyKind", "KEEP_LAST");
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
	KEEP_ALL {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "DDS::QOS::HistoryQosPolicyKind", "KEEP_ALL");
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
	public static HistoryQosPolicyKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal, "DDS::QOS::HistoryQosPolicyKind", "KEEP_LAST")) { //$NON-NLS-1$//$NON-NLS-2$
			return KEEP_LAST;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "DDS::QOS::HistoryQosPolicyKind", "KEEP_ALL")) { //$NON-NLS-1$//$NON-NLS-2$
			return KEEP_ALL;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
