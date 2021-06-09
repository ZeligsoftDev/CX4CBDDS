package com.zeligsoft.domain.idl3plus.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Port;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.ui.internal.editparts.InterfacePortEditPart;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Port edit part provider
 * 
 * @author Young-Soo Roh
 *
 */
public class InterfacePortEditPartProvider extends AbstractEditPartProvider {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getNodeEditPartClass(View view) {
		EObject eo = view.getElement();
		if (view.getType().equals(InterfacePortEditPart.VISUAL_ID) && eo instanceof Port) {
			if (ZDLUtil.isZDLConcept(eo, CCMNames.INTERFACE_PORT)) {
				return InterfacePortEditPart.class;
			}
		}
		return null;
	}
}
