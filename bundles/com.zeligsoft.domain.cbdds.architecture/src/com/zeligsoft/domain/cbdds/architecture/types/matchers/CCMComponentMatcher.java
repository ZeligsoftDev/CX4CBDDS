package com.zeligsoft.domain.cbdds.architecture.types.matchers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 *
 */
public class CCMComponentMatcher implements IElementMatcher {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(EObject eObject) {

		return ZDLUtil.isZDLConcept(eObject, CCMNames.CCMCOMPONENT);

	}

}
