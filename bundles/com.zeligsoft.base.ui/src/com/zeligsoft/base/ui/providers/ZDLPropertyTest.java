package com.zeligsoft.base.ui.providers;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ZDLPropertyTest extends PropertyTester {

	public static final String IS_ZDLCONCEPT = "isZDLConcept";//$NON-NLS-1$

	public static final String IS_ZDLPROFILE = "isZDLProfile";//$NON-NLS-1$

	public static final String IS_CXMODEL = "isCXModel";//$NON-NLS-1$

	/**
	 *
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object,
	 *      java.lang.String, java.lang.Object[], java.lang.Object)
	 *
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (IS_ZDLCONCEPT.equals(property) && (receiver instanceof IStructuredSelection)
				&& (expectedValue instanceof String)) {
			return hasZDLConcept((IStructuredSelection) receiver, (String) expectedValue);
		} else if (IS_ZDLPROFILE.equals(property) && (receiver instanceof IStructuredSelection)
				&& (expectedValue instanceof String)) {
			return hasZDLProfile((IStructuredSelection) receiver, (String) expectedValue);
		} else if (IS_CXMODEL.equals(property) && (receiver instanceof IStructuredSelection)) {
			EObject eo = getSelectedEObject((IStructuredSelection) receiver);
			if(eo instanceof Element) {
				return !ZDLUtil.getZDLProfiles((Element)eo).isEmpty();
			}
		}
		return false;
	}

	protected boolean hasZDLProfile(IStructuredSelection selection, String profile) {
		EObject eo = getSelectedEObject(selection);
		if (eo != null) {
			return ZDLUtil.isZDLProfile((Element) eo, profile);
		}
		return false;
	}

	private EObject getSelectedEObject(IStructuredSelection selection) {
		if (!selection.isEmpty()) {
			EObject eo = null;
			Iterator<?> iter = selection.iterator();
			while (iter.hasNext()) {
				eo = EMFHelper.getEObject(iter.next());
				if (eo != null) {
					return eo;
				}
			}
		}
		return null;
	}
	
	protected boolean hasZDLConcept(IStructuredSelection selection, String concept) {
		EObject eo = getSelectedEObject(selection);
		if (eo != null) {
			return ZDLUtil.isZDLConcept(eo, concept);
		}
		return false;
	}
}
