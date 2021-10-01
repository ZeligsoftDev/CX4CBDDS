package com.zeligsoft.domain.dds4ccm.ui.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil;

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
		BaseUIUtil.writeToConsole(NLS.bind(Messages.MigrationChecker_OpenedPapyrusEditor, null));
		PapyrusMultiDiagramEditor multiEditor = (PapyrusMultiDiagramEditor) partRef.getPage().getActiveEditor();
		Model model = getModel(multiEditor);
		if (model != null) {
			if (DDS4CCMMigrationUtil.isMigrationRequired(model)) {
				String message = NLS.bind(Messages.MigrationChecker_MigrationRequired, model.getName());
				BaseUIUtil.writeToConsole(message);
				Activator.getDefault().error(message, null);
				openPopupDialog(message, model);
			}
		} else {
			Activator.getDefault().error(NLS.bind(Messages.MigrationChecker_NoOpenFileFound, null), null);
		}
	}

	private static void openPopupDialog(String message, Model model) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				boolean migrate = MessageDialog.openQuestion(activeShell, Messages.MigrationChecker_MigrationRequired_DialogTitle, message);
				BaseUIUtil.writeToConsole(migrate ? Messages.MigrationChecker_MigrationConfirmed : Messages.MigrationChecker_MigrationDeclined);
				if (migrate) {
					boolean success = DDS4CCMMigrationUtil.migrateAll(model);
					String successMessage = success ? Messages.MigrationChecker_MigrationSuccess : Messages.MigrationChecker_MigrationFailure;
					BaseUIUtil.writeToConsole(successMessage);
					if (success) {
						MessageDialog.openInformation(activeShell, Messages.MigrationChecker_MigrationResult_DialogTitle, successMessage);
					} else {
						MessageDialog.openError(activeShell, Messages.MigrationChecker_MigrationResult_DialogTitle, successMessage);
					}
				}
			}
		});
	}

	private static Model getModel(PapyrusMultiDiagramEditor multiEditor) {
		ServicesRegistry serviceRegistry = multiEditor.getServicesRegistry();
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);
			UmlModel openedModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
			EObject root = null;
			if (openedModel != null) {
				root = openedModel.lookupRoot();
			} else {
				return null;
			}
			if (!(root instanceof Model)) {
				return null;
			}
			return (Model)root;
			
		} catch (NotFoundException e) {
			// do nothing
		} catch (ServiceException e) {
			// do nothing
		}
		return null;
	}
	
}
