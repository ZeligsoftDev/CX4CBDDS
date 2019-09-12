package com.zeligsoft.domain.cbdds.ui.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

public class ConnectorEditpartProvider extends AbstractEditPartProvider {

	@Override
	protected Class getNodeEditPartClass(View view) {
		EObject eo = view.getElement();
		if (view.getType().equals(PropertyPartEditPartCN.VISUAL_ID) && eo instanceof Property) {
			Type type = ((Property) eo).getType();
			if (type != null) {
				Stereotype st = type.getAppliedStereotype("cxDDS4CCM::ConnectorDef");
				if (st != null) {
					return ConnectorPartEditPart.class;
				}
			}
		}
		return null;
	}
}
