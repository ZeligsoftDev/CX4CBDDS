package com.zeligsoft.domain.dds4ccm.api.DDS4CCM;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * An enumeration for DDS4CCM::DDS4CCM::ModelTypeEnum
 *
 * @author ZDL API Generator
 *
 */
public enum ModelTypeEnum {
	/**
	 * 
	 *
	 */
	ATCD {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "DDS4CCM::DDS4CCM::ModelTypeEnum", "ATCD");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
			return eObject(context.eObject());
		}
	},

	/**
	* 
	*
	*/
	AXCIOMA {
		@Override
		public EObject eObject(EObject context) {
			return ZDLUtil.getZDLEnumLiteral(context, "DDS4CCM::DDS4CCM::ModelTypeEnum", "AXCIOMA");
		}

		@Override
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
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
		public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {
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
	public static ModelTypeEnum create(EObject literal) {
		if (literal == ZDLUtil.getZDLEnumLiteral(literal, "DDS4CCM::DDS4CCM::ModelTypeEnum", "ATCD")) { //$NON-NLS-1$//$NON-NLS-2$
			return ATCD;
		} else if (literal == ZDLUtil.getZDLEnumLiteral(literal, "DDS4CCM::DDS4CCM::ModelTypeEnum", "AXCIOMA")) { //$NON-NLS-1$//$NON-NLS-2$
			return AXCIOMA;
		} else {
			return UNKNOWN;
		}
	}

	public abstract EObject eObject(EObject context);

	public abstract EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context);
}
