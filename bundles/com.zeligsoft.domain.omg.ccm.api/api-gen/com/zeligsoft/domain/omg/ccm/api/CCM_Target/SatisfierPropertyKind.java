package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for CCM::CCM_Target::SatisfierPropertyKind
 *
 * @author ZDL API Generator
 *
 */
public enum SatisfierPropertyKind {
	/**
	 * 
	 *
	 */
	QUANTITY {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"CCM::CCM_Target::SatisfierPropertyKind", "Quantity");
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
	CAPACITY {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"CCM::CCM_Target::SatisfierPropertyKind", "Capacity");
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
	MINIMUM {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"CCM::CCM_Target::SatisfierPropertyKind", "Minimum");
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
	MAXIMUM {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"CCM::CCM_Target::SatisfierPropertyKind", "Maximum");
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
	ATTRIBUTE {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"CCM::CCM_Target::SatisfierPropertyKind", "Attribute");
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
	SELECTION {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"CCM::CCM_Target::SatisfierPropertyKind", "Selection");
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
	public static SatisfierPropertyKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"CCM::CCM_Target::SatisfierPropertyKind", "Quantity")) { //$NON-NLS-1$//$NON-NLS-2$
			return QUANTITY;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"CCM::CCM_Target::SatisfierPropertyKind", "Capacity")) { //$NON-NLS-1$//$NON-NLS-2$
			return CAPACITY;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"CCM::CCM_Target::SatisfierPropertyKind", "Minimum")) { //$NON-NLS-1$//$NON-NLS-2$
			return MINIMUM;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"CCM::CCM_Target::SatisfierPropertyKind", "Maximum")) { //$NON-NLS-1$//$NON-NLS-2$
			return MAXIMUM;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"CCM::CCM_Target::SatisfierPropertyKind", "Attribute")) { //$NON-NLS-1$//$NON-NLS-2$
			return ATTRIBUTE;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"CCM::CCM_Target::SatisfierPropertyKind", "Selection")) { //$NON-NLS-1$//$NON-NLS-2$
			return SELECTION;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(
			com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
