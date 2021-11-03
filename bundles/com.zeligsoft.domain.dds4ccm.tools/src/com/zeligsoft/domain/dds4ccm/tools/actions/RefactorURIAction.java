
package com.zeligsoft.domain.dds4ccm.tools.actions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.tools.dialogs.RefactorPathmapDialog;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.tools.providers.DynamicPathmapCustomPropertySection;

public class RefactorURIAction extends BaseSelectionListenerAction {

	private URI modelUri;
	private URI sourceURI;

	public RefactorURIAction(URI modelUri, URI sourceUri) {
		super(Messages.RefactorURIAction_ActionTitle);
		this.modelUri = modelUri;
		this.sourceURI = sourceUri;
	}

	@Override
	public void run() {
		RefactorPathmapDialog dialog = new RefactorPathmapDialog(Display.getCurrent().getActiveShell());
		if (dialog.open() == Window.OK) {
			URI targetURI = dialog.getSelectedUri();
			if (targetURI != null) {
				String msg = NLS.bind(Messages.RefactorURIAction_RefactoringConfirmation, sourceURI.toString(),
						targetURI.toString());
				boolean shouldPerform = MessageDialog.openConfirm(dialog.getShell(),
						Messages.RefactorURIAction_DialogTitle, msg);
				if (shouldPerform) {
					// close all editors before refactoring starts
					IWorkbenchPage page = BaseUIUtil.getActivepage();
					if (page != null) {
						IEditorPart activeEditor = page.getActiveEditor();
						page.closeEditor(activeEditor, true);
					}
					DynamicPathmapCustomPropertySection.refactorURI(sourceURI, targetURI, modelUri);
					URI notaionUri = modelUri.trimFileExtension().appendFileExtension("notation"); //$NON-NLS-1$
					DynamicPathmapCustomPropertySection.refactorURI(sourceURI, targetURI, notaionUri);
				}
			}
		}
	}

}
