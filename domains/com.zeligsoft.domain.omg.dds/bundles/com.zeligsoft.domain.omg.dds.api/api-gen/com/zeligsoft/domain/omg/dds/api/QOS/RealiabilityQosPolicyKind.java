package com.zeligsoft.domain.omg.dds.api.QOS;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS::QOS::RealiabilityQosPolicyKind
 *
 * @author ZDL API Generator
 *
 */
public enum RealiabilityQosPolicyKind {
	/**
	 * 
	 *
	 */
	BEST_EFFORT,

	/**
	 * 
	 *
	 */
	RELIABLE,
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
	public static RealiabilityQosPolicyKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::RealiabilityQosPolicyKind", "BEST_EFFORT")) { //$NON-NLS-1$//$NON-NLS-2$
			return BEST_EFFORT;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::RealiabilityQosPolicyKind", "RELIABLE")) { //$NON-NLS-1$//$NON-NLS-2$
			return RELIABLE;
		} else {
			return UNKNOWN;
		}
	}
}
