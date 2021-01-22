package com.zeligsoft.domain.dds4ccm.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CXDomainNames;

public class DDS4CCMModelMigration {

	public static void migrateCSLConnector(Model model) {
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, DDS4CCMNames.CONNECTOR_STATUS_LISTENER_CONNECTION)) {
				Connector connector = (Connector) next;
				EList<Stereotype> appliedStereotypes = connector.getAppliedStereotypes();
				for (Stereotype st : appliedStereotypes) {
					connector.unapplyStereotype(st);
				}
				ZDLUtil.addZDLConcept(connector, CCMNames.CCMCONNECTOR);
			}
			if (!(next instanceof Package) && !ZDLUtil.isZDLConcept(next, CXDomainNames.CXMODULE)
					&& !ZDLUtil.isZDLConcept(next, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
				itor.prune();
			}
		}

	}
}
