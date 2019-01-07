package com.zeligsoft.domain.omg.dds.api.Topics;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS::Topics::TopicKind
 *
 * @author ZDL API Generator
 *
 */
public enum TopicKind {
	/**
	 * 
	 *
	 */
	STANDARD,

	/**
	 * 
	 *
	 */
	MULTI_TOPIC,

	/**
	 * 
	 *
	 */
	CONTENT_FILTERED,
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
	public static TopicKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::Topics::TopicKind", "STANDARD")) { //$NON-NLS-1$//$NON-NLS-2$
			return STANDARD;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::Topics::TopicKind", "MULTI_TOPIC")) { //$NON-NLS-1$//$NON-NLS-2$
			return MULTI_TOPIC;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::Topics::TopicKind", "CONTENT_FILTERED")) { //$NON-NLS-1$//$NON-NLS-2$
			return CONTENT_FILTERED;
		} else {
			return UNKNOWN;
		}
	}
}
