package com.zeligsoft.base.zdl.staticapi.Validation;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for ZDL::Validation::LinkConstraintKind
 *
 * @author ZDL API Generator
 *
 */
public enum LinkConstraintKind {
	/**
	 * 
	 *
	 */
	DIAGRAM {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::LinkConstraintKind", "diagram");
		}

		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	 * 
	 *
	 */
	DEPLOYMENT {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::LinkConstraintKind", "deployment");
		}

		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	 * 
	 *
	 */
	DEPLOYMENTCONTAINER {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::LinkConstraintKind",
					"deploymentContainer");
		}

		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	 * 
	 *
	 */
	DEPLOYMENTPART {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::LinkConstraintKind", "deploymentPart");
		}

		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	 * 
	 *
	 */
	DEPLOYMENTPARTCONFIGURE {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::LinkConstraintKind",
					"deploymentPartConfigure");
		}

		public EObject eObject(
				com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},
	/**
	 * Literal for cases when the value is UNKNOWN
	 */
	UNKNOWN {
		public EObject eObject(EObject context) {
			return null;
		}

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
	public static LinkConstraintKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZDL::Validation::LinkConstraintKind", "diagram")) { //$NON-NLS-1$//$NON-NLS-2$
			return DIAGRAM;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZDL::Validation::LinkConstraintKind", "deployment")) { //$NON-NLS-1$//$NON-NLS-2$
			return DEPLOYMENT;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZDL::Validation::LinkConstraintKind", "deploymentContainer")) { //$NON-NLS-1$//$NON-NLS-2$
			return DEPLOYMENTCONTAINER;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZDL::Validation::LinkConstraintKind", "deploymentPart")) { //$NON-NLS-1$//$NON-NLS-2$
			return DEPLOYMENTPART;
		} else if (literal == ZDLUtil
				.getZDLEnumLiteral(
						literal,
						"ZDL::Validation::LinkConstraintKind", "deploymentPartConfigure")) { //$NON-NLS-1$//$NON-NLS-2$
			return DEPLOYMENTPARTCONFIGURE;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(
			com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
