package com.zeligsoft.domain.zml.api.ZML_Component;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for ZMLMM::ZML_Component::WiringKind
 *
 * @author ZDL API Generator
 *
 */
public enum WiringKind {
	/**
	 * 
	 * <HTML><HEAD>
	 <META content="MSHTML 6.00.6000.16674" name=GENERATOR></HEAD>
	 <BODY>
	 <P>The connector wiring kind indicates that the port must "hard-wired" to other ports using connectors.</P></BODY></HTML>
	 *
	 */
	CONNECTOR {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZMLMM::ZML_Component::WiringKind", "connector");
		}

		@Override
		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	 * 
	 * <HTML><HEAD>
	<META content="MSHTML 6.00.6000.16674" name=GENERATOR></HEAD>
	<BODY>The sap wiring kind indicates that the port is a Service Access Port, which must be dynamically bound to a complementary Service Provider Port at run-time.</BODY></HTML>
	 *
	 */
	SAP {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZMLMM::ZML_Component::WiringKind", "sap");
		}

		@Override
		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	 * 
	 * <HTML><HEAD>
	<META content="MSHTML 6.00.6000.16674" name=GENERATOR></HEAD>
	<BODY>The spp wiring kind indicates that the port is a Service Provider Port, which may be dynamically bound to a complementary Service Access Port at run-time.</BODY></HTML>
	 *
	 */
	SPP {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZMLMM::ZML_Component::WiringKind", "spp");
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
	public static WiringKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZMLMM::ZML_Component::WiringKind", "connector")) { //$NON-NLS-1$//$NON-NLS-2$
			return CONNECTOR;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZMLMM::ZML_Component::WiringKind", "sap")) { //$NON-NLS-1$//$NON-NLS-2$
			return SAP;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZMLMM::ZML_Component::WiringKind", "spp")) { //$NON-NLS-1$//$NON-NLS-2$
			return SPP;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(
			com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
