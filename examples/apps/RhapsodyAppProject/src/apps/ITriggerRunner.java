package apps;

import com.ibm.rhapsody.apps.TriggerAdapter.Trigger;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPModelElement;

public interface ITriggerRunner {

	public void eventTriggered(Trigger trigger, IRPApplication rhapsody,
			IRPModelElement selected, String concept);
}
