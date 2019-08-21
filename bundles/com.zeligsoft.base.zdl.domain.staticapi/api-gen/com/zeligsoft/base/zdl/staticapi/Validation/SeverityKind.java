package com.zeligsoft.base.zdl.staticapi.Validation;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for ZDL::Validation::SeverityKind
 *
 * @author ZDL API Generator
 *
 */
public enum SeverityKind {
	/**
	 * 
	 *
	 */
	INFO {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::SeverityKind", "info");
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
	WARN {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::SeverityKind", "warn");
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
	ERROR {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::SeverityKind", "error");
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
	FATAL {
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context,
					"ZDL::Validation::SeverityKind", "fatal");
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
	public static SeverityKind create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZDL::Validation::SeverityKind", "info")) { //$NON-NLS-1$//$NON-NLS-2$
			return INFO;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZDL::Validation::SeverityKind", "warn")) { //$NON-NLS-1$//$NON-NLS-2$
			return WARN;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZDL::Validation::SeverityKind", "error")) { //$NON-NLS-1$//$NON-NLS-2$
			return ERROR;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal,
				"ZDL::Validation::SeverityKind", "fatal")) { //$NON-NLS-1$//$NON-NLS-2$
			return FATAL;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(
			com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
