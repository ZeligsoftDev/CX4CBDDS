package com.zeligsoft.domain.dds4ccm.ui.internal;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.ui.Activator;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
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
		BaseUIUtil.writeToConsole("Opened Papyrus multi-diagram editor");
		PapyrusMultiDiagramEditor multiEditor = (PapyrusMultiDiagramEditor) partRef.getPage().getActiveEditor();
		Model model = getModel(multiEditor);
		if (model != null) {
			boolean result = DDS4CCMMigrationUtil.isMigrationRequired(model);
			if (result == true) {
				BaseUIUtil.writeToConsole("Model migration is required for model '" + model.getName() + "'");
				logWarning("Model migration is required for model '" + model.getName() + "'");
			}
		} else {
			logError("No open model found for the Papyrus editor");
		}
	}

	private static Model getModel(PapyrusMultiDiagramEditor multiEditor) {
		ServicesRegistry serviceRegistry = multiEditor.getServicesRegistry();
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);
			UmlModel openedModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
			EObject root = null;
			if (openedModel != null) {
				try {
					root = openedModel.lookupRoot();
				} catch (NotFoundException e) {
					return null;
				}
			} else {
				return null;
			}
			if (!(root instanceof Model)) {
				return null;
			}
			return (Model)root;
		} catch (ServiceException e) {
			// do nothing
		}
		return null;
	}
	
	private static void logError(String message) {
		IStatus error = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message); //$NON-NLS-1$
		ILog logger = Platform.getLog(Activator.getDefault().getBundle());
		logger.log(error);
	}
	
	private static void logWarning(String message) {
		IStatus error = new Status(IStatus.WARNING, Activator.PLUGIN_ID, message); //$NON-NLS-1$
		ILog logger = Platform.getLog(Activator.getDefault().getBundle());
		logger.log(error);
	}
}
