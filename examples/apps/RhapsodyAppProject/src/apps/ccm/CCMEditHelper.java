package apps.ccm;

import apps.ITriggerRunner;
import apps.ccm.wizard.ComponentWizard;
import apps.utils.CXRhapsodyUtils;

import com.ibm.rhapsody.apps.TriggerAdapter.Trigger;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPInstance;
import com.telelogic.rhapsody.core.IRPLink;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPType;

public class CCMEditHelper implements ITriggerRunner {

	public static final CCMEditHelper INSTANCE = new CCMEditHelper();

	private CCMEditHelper() {

	}

	@Override
	public void eventTriggered(Trigger trigger, IRPApplication rhapsody,
			IRPModelElement selected, String concept) {
		String meta = selected.getMetaClass();

		// add appropriate stereotypes
		if ("Link".equals(meta)) {
			IRPLink link = (IRPLink) selected;
			IRPInstance from = link.getFrom();
			IRPInstance to = link.getTo();
			String fromConcept = CXRhapsodyUtils.getZdlConcept(from);
			String toConcept = CXRhapsodyUtils.getZdlConcept(to);
			if (CCMNames.CCMPART.equals(fromConcept)
					|| CCMNames.CCMPART.equals(toConcept)) {
				link.addStereotype("CCMConnector", "Link");
			}
		}

		// Add generalization to component
		if (CCMNames.MONOLITHIC_IMPLEMENTATION.equals(concept)
				|| CCMNames.ASSEMBLY_IMPLEMENTATION.equals(concept)) {
			IRPModelElement owner = selected.getOwner();
			String ownerConcept = CXRhapsodyUtils.getZdlConcept(owner);
			if (CCMNames.CCMCOMPONENT.equals(ownerConcept)) {
				IRPModelElement newOwner = owner.getOwner();
				selected.setOwner(newOwner);
				((IRPClass) selected).addGeneralization((IRPClass) owner);
			}
		} else if (CCMNames.HOME.equals(concept)) {
			IRPModelElement owner = selected.getOwner();
			String ownerConcept = CXRhapsodyUtils.getZdlConcept(owner);
			if (CCMNames.CCMCOMPONENT.equals(ownerConcept)) {
				IRPModelElement newOwner = owner.getOwner();
				selected.setOwner(newOwner);
				IRPDependency dep = ((IRPClass) selected)
						.addDependencyTo(owner);
				dep.addStereotype("Manages", "Dependency");
			}
		}else if(DDS4CCMNames.DDSMESSAGE.equals(concept)){
			IRPType type = (IRPType) selected;
			type.setKind("Structure");
		}

		if (CCMNames.CCMCOMPONENT.equals(concept)) {
			ComponentWizard wizard = new ComponentWizard(selected);
			wizard.open();
		}
	}

}
