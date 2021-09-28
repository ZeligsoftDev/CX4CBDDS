package com.zeligsoft.domain.dds4ccm.ui.internal;

import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * This class checks if a model needs migration when the model is opened.
 * 
 * @author Ernesto Posse
 */
public class MigrationChecker {

	public static final class PapyrusEditorListener implements IPartListener2 {
		@Override
		public void partVisible(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partOpened(IWorkbenchPartReference partRef) {
			checkEditorPart(partRef);
		}

		@Override
		public void partInputChanged(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partHidden(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partDeactivated(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partClosed(IWorkbenchPartReference partRef) {
			
		}

		@Override
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partActivated(IWorkbenchPartReference partRef) {
		}
	}

	private static void checkEditorPart(IWorkbenchPartReference partRef) {
		if (!(partRef instanceof IEditorReference)
				|| !(partRef.getPage().getActiveEditor() instanceof PapyrusMultiDiagramEditor)) {
			return;
		}
		BaseUIUtil.writeToConsole("Opened Papyrus multi-diagram editor");
	}
}
