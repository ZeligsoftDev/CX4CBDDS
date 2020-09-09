package com.zeligsoft.domain.omg.dds.api.QOS;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS::QOS::DestinationOrderQosPolicyKind
 *
 * @author ZDL API Generator
 *
 */
public enum DestinationOrderQosPolicyKind {
	/**
	 * 
	 *
	 */
	BY_RECEPTION_TIMESTAMP {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "DDS::QOS::DestinationOrderQosPolicyKind",
					"BY_RECEPTION_TIMESTAMP");
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
	BY_SOURCE_TIMESTAMP {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "DDS::QOS::DestinationOrderQosPolicyKind", "BY_SOURCE_TIMESTAMP");
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
	public static DestinationOrderQosPolicyKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal, "DDS::QOS::DestinationOrderQosPolicyKind", //$NON-NLS-1$
				"BY_RECEPTION_TIMESTAMP")) { //$NON-NLS-1$
			return BY_RECEPTION_TIMESTAMP;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "DDS::QOS::DestinationOrderQosPolicyKind", //$NON-NLS-1$
				"BY_SOURCE_TIMESTAMP")) { //$NON-NLS-1$
			return BY_SOURCE_TIMESTAMP;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
