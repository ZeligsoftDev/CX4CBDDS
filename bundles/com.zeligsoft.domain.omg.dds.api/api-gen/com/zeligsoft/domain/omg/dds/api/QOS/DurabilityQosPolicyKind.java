package com.zeligsoft.domain.omg.dds.api.QOS;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS::QOS::DurabilityQosPolicyKind
 *
 * @author ZDL API Generator
 *
 */
public enum DurabilityQosPolicyKind {
	/**
	 * 
	 *
	 */
	TRANSIENT,

	/**
	 * 
	 *
	 */
	TRANSIENT_LOCAL,

	/**
	 * 
	 *
	 */
	VOLATILE,

	/**
	 * 
	 *
	 */
	PERSISTENT,
	/**
	 * Literal for cases when the value is UNKNOWN
	 */
	UNKNOWN;

	/**
	 * @param literal
	 *    the raw object to create the instance from
	 * @return
	 *    an instance of this enumeration based on the literal passed in and
	 *    UNKNOWN if the literal is unrecognized
	 */
	public static DurabilityQosPolicyKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::DurabilityQosPolicyKind", "TRANSIENT")) { //$NON-NLS-1$//$NON-NLS-2$
			return TRANSIENT;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::DurabilityQosPolicyKind", "TRANSIENT_LOCAL")) { //$NON-NLS-1$//$NON-NLS-2$
			return TRANSIENT_LOCAL;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::DurabilityQosPolicyKind", "VOLATILE")) { //$NON-NLS-1$//$NON-NLS-2$
			return VOLATILE;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::DurabilityQosPolicyKind", "PERSISTENT")) { //$NON-NLS-1$//$NON-NLS-2$
			return PERSISTENT;
		} else {
			return UNKNOWN;
		}
	}
}
