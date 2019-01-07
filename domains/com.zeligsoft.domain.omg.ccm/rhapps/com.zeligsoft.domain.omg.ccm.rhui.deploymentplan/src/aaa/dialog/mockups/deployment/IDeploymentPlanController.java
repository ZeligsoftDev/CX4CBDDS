package aaa.dialog.mockups.deployment;

import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTargetEvent;

public interface IDeploymentPlanController {

	void dropOnDeploy(DropTargetEvent event);

	void dragConfigureItem(DragSourceEvent event);

	void dropOnConfigure(DropTargetEvent event);

	void dropAcceptConfigure(DropTargetEvent event);

	void dropEnterConfigure(DropTargetEvent event);

}
