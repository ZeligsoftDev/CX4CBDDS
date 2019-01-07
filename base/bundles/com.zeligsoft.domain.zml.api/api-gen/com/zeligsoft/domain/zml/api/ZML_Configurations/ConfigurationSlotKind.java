package com.zeligsoft.domain.zml.api.ZML_Configurations;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for ZMLMM::ZML_Configurations::ConfigurationSlotKind
 *
 * @author ZDL API Generator
 *
 */
public enum ConfigurationSlotKind {
	/**
	 * 
	 *
	 */
	ADDITIVE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZMLMM::ZML_Configurations::ConfigurationSlotKind",
					"additive");
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
	OVERRIDE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZMLMM::ZML_Configurations::ConfigurationSlotKind",
					"override");
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
	public static ConfigurationSlotKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZMLMM::ZML_Configurations::ConfigurationSlotKind", "additive")) { //$NON-NLS-1$//$NON-NLS-2$
			return ADDITIVE;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZMLMM::ZML_Configurations::ConfigurationSlotKind", "override")) { //$NON-NLS-1$//$NON-NLS-2$
			return OVERRIDE;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(
			com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
