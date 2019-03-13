package com.zeligsoft.domain.omg.dds.api.QOS;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS::QOS::OwnershipQosPolicyKind
 *
 * @author ZDL API Generator
 *
 */
public enum OwnershipQosPolicyKind {
	/**
	 * 
	 *
	 */
	SHARED,

	/**
	 * 
	 *
	 */
	EXCLUSIVE,
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
	public static OwnershipQosPolicyKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::OwnershipQosPolicyKind", "SHARED")) { //$NON-NLS-1$//$NON-NLS-2$
			return SHARED;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::OwnershipQosPolicyKind", "EXCLUSIVE")) { //$NON-NLS-1$//$NON-NLS-2$
			return EXCLUSIVE;
		} else {
			return UNKNOWN;
		}
	}
}
