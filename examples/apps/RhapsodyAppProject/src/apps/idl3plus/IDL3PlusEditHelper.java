package apps.idl3plus;

import apps.ITriggerRunner;
import apps.idl3plus.wizard.TemplateInstantiationWizard;
import apps.utils.CXRhapsodyUtils;

import com.ibm.rhapsody.apps.TriggerAdapter.Trigger;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPModelElement;

public class IDL3PlusEditHelper implements ITriggerRunner {

	public static final IDL3PlusEditHelper INSTANCE = new IDL3PlusEditHelper();

	private IDL3PlusEditHelper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eventTriggered(Trigger trigger, IRPApplication rhapsody,
			IRPModelElement selected, String concept) {
		String meta = selected.getMetaClass();
		if ("Dependency".equals(meta)) {
			IRPDependency dep = (IRPDependency) selected;
			IRPModelElement owner = dep.getOwner();
			String ownerConcept = CXRhapsodyUtils.getZdlConcept(owner);
			if (IDL3PlusNames.EXTENDED_PORT_TYPE.equals(ownerConcept)) {
				dep.addStereotype("Usage", "Dependency");
			}
		} else if ("Generalization".equals(meta)) {
			IRPGeneralization dep = (IRPGeneralization) selected;
			IRPModelElement owner = dep.getOwner();
			String ownerConcept = CXRhapsodyUtils.getZdlConcept(owner);
			if (IDL3PlusNames.EXTENDED_PORT_TYPE.equals(ownerConcept)) {
				dep.addStereotype("Realization", "Generalization");
			}
		}

		if (IDL3PlusNames.MODULE_INSTANTIATION.equals(concept)) {
			TemplateInstantiationWizard wizard = new TemplateInstantiationWizard(
					selected);
			wizard.open();
		}

	}
}
