package apps;

import apps.ccm.CCMEditHelper;
import apps.corba.CORBAEditHelper;
import apps.idl3plus.IDL3PlusEditHelper;
import apps.utils.CXRhapsodyUtils;

import com.ibm.rhapsody.apps.App;
import com.ibm.rhapsody.apps.TriggerAdapter.Trigger;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPModelElement;

public class MainApp extends App {

	/*
	 * This method is called on invoking an app inside Rhapsody. rhapsody -
	 * Instance of an active Rhapsody application selected - Selected element in
	 * Rhapsody
	 */
	public void execute(IRPApplication rhapsody, IRPModelElement selected) {
		// Trigger fired by Rhapsody
		Trigger trigger = getTrigger();
		switch (trigger) {
		case AfterAddElementTrigger:
			String concept = CXRhapsodyUtils.getZdlConcept(selected);
			CORBAEditHelper.INSTANCE.eventTriggered(trigger, rhapsody,
					selected, concept);
			CCMEditHelper.INSTANCE.eventTriggered(trigger, rhapsody, selected,
					concept);
			IDL3PlusEditHelper.INSTANCE.eventTriggered(trigger, rhapsody,
					selected, concept);
			break;

		case AfterProjectOpenTrigger:
			// TODO: Place your code here
			break;

		case OnDoubleClickTrigger:
			// TODO: Place your code here
			break;

		case BeforeProjectSaveTrigger:
			// TODO: Place your code here
			break;

		case AfterProjectSaveTrigger:
			// TODO: Place your code here
			break;

		case BeforeCheckModelTrigger:
			// TODO: Place your code here
			break;

		case BeforeCodeGenerationTrigger:
			// TODO: Place your code here
			break;

		case AfterRoundtripTrigger:
			// TODO: Place your code here
			break;

		case AfterChangeToTrigger:
			// TODO: Place your code here
			break;

		case TestingTrigger:
			// TODO: Place your code here
			break;

		case ManualTrigger:
			// TODO: Place your code here
			break;

		default:
			break;
		}

	}

	@Override
	public void invoke(IRPModelElement selected) {
		super.invoke(selected);
	}

	/*
	 * Debug app by launching it as "Java Application" is Eclipse. Note: Select
	 * an element in Rhapsody in order to simulate launching app on a selected
	 * element in the browser.
	 */
	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.invokeFromMain();
	}
}
