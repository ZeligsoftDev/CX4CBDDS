package com.zeligsoft.domain.idl3plus.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.internal.editparts.ConnectorPartEditPart;

public class ConnectorEditpartProvider extends AbstractEditPartProvider {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getNodeEditPartClass(View view) {
		EObject eo = view.getElement();
		if (view.getType().equals(PropertyPartEditPartCN.VISUAL_ID) && eo instanceof Property) {
			if(ZDLUtil.isZDLConcept((Property) eo, IDL3PlusNames.DATA_SPACE)) {
				return ConnectorPartEditPart.class;
			}
		}
		return null;
	}
}
