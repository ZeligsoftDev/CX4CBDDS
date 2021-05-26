package com.zeligsoft.domain.omg.ccm.ui.internal.hyperlinks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkSpecificObject;
import org.eclipse.papyrus.infra.hyperlink.service.HyperlinkContributor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.utils.CCMUIUtil;

/**
 * Assembly diagram hyperlink contributor
 * 
 * @author Young-Soo Roh
 *
 */
public class AssemblyHyperlinkContributor implements HyperlinkContributor {

	@Override
	public List<HyperLinkObject> getHyperlinks(Object fromElement) {
		List<HyperLinkObject> hyperlinks = new ArrayList<HyperLinkObject>();

		EObject fromEObject = EMFHelper.getEObject(fromElement);
		if (fromEObject instanceof Property && ZDLUtil.isZDLConcept(fromEObject, CCMNames.CCMPART)) {
			Property part = (Property) fromEObject;
			// get assembly diagram
			EObject type = part.getType();
			if (type != null && ZDLUtil.isZDLConcept(type, CCMNames.CCMCOMPONENT)) {
				Component ccmComponent = (Component) type;
				Component assemblyImplementation = null;
				List<Relationship> generalizations = ccmComponent.getRelationships(UMLPackage.Literals.GENERALIZATION);
				for (Relationship g : generalizations) {
					Classifier realization = ((Generalization) g).getSpecific();
					if (ZDLUtil.isZDLConcept(realization, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
						assemblyImplementation = (Component) realization;
						break;
					}
				}

				if (assemblyImplementation != null) {
					Diagram assemblyDiagram = CCMUIUtil.getAssemblyStructureDiagram(assemblyImplementation);

					HyperLinkObject hyperLink = new HyperLinkSpecificObject(assemblyDiagram);
					// navigable by default
					hyperLink.setIsDefault(true);
					hyperlinks.add(hyperLink);
				}
			}
		}

		return hyperlinks;
	}

}
