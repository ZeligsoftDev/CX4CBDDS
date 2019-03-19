package com.zeligsoft.domain.omg.dds.api.QOS;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS::QOS::PresentationQosPolicyAccessScopeKind
 *
 * @author ZDL API Generator
 *
 */
public enum PresentationQosPolicyAccessScopeKind {
	/**
	 * 
	 *
	 */
	INSTANCE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"DDS::QOS::PresentationQosPolicyAccessScopeKind",
					"INSTANCE");
		}

		@Override
		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	 * 
	 *
	 */
	TOPIC {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"DDS::QOS::PresentationQosPolicyAccessScopeKind", "TOPIC");
		}

		@Override
		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	 * 
	 *
	 */
	GROUP {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"DDS::QOS::PresentationQosPolicyAccessScopeKind", "GROUP");
		}

		@Override
		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
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
		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
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
	public static PresentationQosPolicyAccessScopeKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::PresentationQosPolicyAccessScopeKind", "INSTANCE")) { //$NON-NLS-1$//$NON-NLS-2$
			return INSTANCE;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::PresentationQosPolicyAccessScopeKind", "TOPIC")) { //$NON-NLS-1$//$NON-NLS-2$
			return TOPIC;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"DDS::QOS::PresentationQosPolicyAccessScopeKind", "GROUP")) { //$NON-NLS-1$//$NON-NLS-2$
			return GROUP;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(
			com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
