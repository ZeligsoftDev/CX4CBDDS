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
	BY_RECEPTION_TIMESTAMP,

	/**
	 * 
	 *
	 */
	BY_SOURCE_TIMESTAMP,
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
	public static DestinationOrderQosPolicyKind create(EObject literal) {
		if (literal == ZDLUtil
				.getZDLEnumLiteral(
						literal,
						"DDS::QOS::DestinationOrderQosPolicyKind", "BY_RECEPTION_TIMESTAMP")) { //$NON-NLS-1$//$NON-NLS-2$
			return BY_RECEPTION_TIMESTAMP;
		} else if (literal == ZDLUtil
				.getZDLEnumLiteral(
						literal,
						"DDS::QOS::DestinationOrderQosPolicyKind", "BY_SOURCE_TIMESTAMP")) { //$NON-NLS-1$//$NON-NLS-2$
			return BY_SOURCE_TIMESTAMP;
		} else {
			return UNKNOWN;
		}
	}
}
