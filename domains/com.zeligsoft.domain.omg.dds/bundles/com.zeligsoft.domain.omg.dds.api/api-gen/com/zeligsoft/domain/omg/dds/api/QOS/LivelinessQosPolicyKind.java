package com.zeligsoft.domain.omg.dds.api.QOS;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS::QOS::LivelinessQosPolicyKind
 *
 * @author ZDL API Generator
 *
 */
public enum LivelinessQosPolicyKind {
	/**
	 * 
	 *
	 */
	AUTOMATIC,

	/**
	 * 
	 *
	 */
	MANUAL_BY_PARTICIPANT,

	/**
	 * 
	 *
	 */
	MANUAL_BY_TOPIC,
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
	public static LivelinessQosPolicyKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::LivelinessQosPolicyKind", "AUTOMATIC")) { //$NON-NLS-1$//$NON-NLS-2$
			return AUTOMATIC;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::LivelinessQosPolicyKind", "MANUAL_BY_PARTICIPANT")) { //$NON-NLS-1$//$NON-NLS-2$
			return MANUAL_BY_PARTICIPANT;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::LivelinessQosPolicyKind", "MANUAL_BY_TOPIC")) { //$NON-NLS-1$//$NON-NLS-2$
			return MANUAL_BY_TOPIC;
		} else {
			return UNKNOWN;
		}
	}
}
