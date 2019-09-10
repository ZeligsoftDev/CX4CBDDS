package com.zeligsoft.cx.codegen.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;

import com.zeligsoft.cx.codegen.ui.actions.TransformAction;
import com.zeligsoft.cx.codegen.ui.utils.ActionsCollector;

public class DynamicGenerateMenuProvider extends CompoundContributionItem {

	private List<TransformAction> actionCache = null;

	EObject getSelectedEObject() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IStructuredSelection selection = (IStructuredSelection) window.getActivePage().getSelection();
		EObject eObject = EMFHelper.getEObject(selection.getFirstElement());
		return eObject;
	}

	@Override
	protected IContributionItem[] getContributionItems() {
		List<IContributionItem> result = new ArrayList<IContributionItem>();
		EObject eObj = getSelectedEObject();
		if (eObj == null) {
			return result.toArray(new IContributionItem[0]);
		}
		actionCache = new ArrayList<TransformAction>();
		try {
			ActionsCollector.populateActionsFromElement(eObj, actionCache, TransformAction.class);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (actionCache.size() == 1) {
			result.add(new ActionContributionItem(actionCache.get(0)));
		} else if (actionCache.size() >= 2) {
			// add the rest of the generate actions
			for (int i = 0; i < actionCache.size(); ++i) {
				result.add(new ActionContributionItem(actionCache.get(i)));
			}
		}

		return result.toArray(new IContributionItem[result.size()]);
	}
}
