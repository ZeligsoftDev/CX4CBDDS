package apps;

import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTargetEvent;

import com.telelogic.rhapsody.core.IRPApplication;

import aaa.dialog.mockups.deployment.IDeploymentPlanController;

public class DeploymentPlanController implements IDeploymentPlanController {

	private final IRPApplication rhapsody;

	public DeploymentPlanController(IRPApplication rhapsody) {
		this.rhapsody = rhapsody;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dropOnDeploy(DropTargetEvent event) {
		// TODO Auto-generated method stub
		rhapsody.writeToOutputWindow("Log", "dropOnDeploy");
	}

	@Override
	public void dragConfigureItem(DragSourceEvent event) {
		rhapsody.writeToOutputWindow("Log", "dragConfigureItem");

	}

	@Override
	public void dropOnConfigure(DropTargetEvent event) {
		rhapsody.writeToOutputWindow("Log", "dropOnConfigure");

	}

	@Override
	public void dropAcceptConfigure(DropTargetEvent event) {
		rhapsody.writeToOutputWindow("Log", "dropAcceptConfigure");
		
	}

	@Override
	public void dropEnterConfigure(DropTargetEvent event) {
		rhapsody.writeToOutputWindow("Log", "dropEnterConfigure");
		
	}

}
