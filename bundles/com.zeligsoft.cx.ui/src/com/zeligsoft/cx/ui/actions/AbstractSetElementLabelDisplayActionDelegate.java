/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.cx.ui.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionDelegate;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;

/**
 * Abstract action delegate to allow users to change label display options for
 * structure diagrams.
 * 
 * @author ysroh
 * 
 */
public abstract class AbstractSetElementLabelDisplayActionDelegate extends ActionDelegate
		implements IObjectActionDelegate {

	private List<Diagram> contexts = new ArrayList<Diagram>();

	protected final static String LABEL_DISPLAY_STYLE_KEY = "ShowTypeLabelStyle"; //$NON-NLS-1$

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(IAction action) {
		if (contexts.isEmpty()) {
			return;
		}

		AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
				UMLModeler.getEditingDomain(), "Set Element Label Display", //$NON-NLS-1$
				Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
					IAdaptable arg1) throws ExecutionException {

				for (Diagram context : contexts) {
					doChangeDisplayOption(context);
				}

				return CommandResult.newOKCommandResult();
			}

		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(editCommand,
					null, null);
		} catch (ExecutionException e) {
			ZeligsoftCXUIPlugin
					.getDefault()
					.error(com.zeligsoft.cx.ui.l10n.Messages.AbstractSetElementLabelDisplayActionDelegate_errorMsg,

					e);
			return;
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection != null && selection instanceof IStructuredSelection) {
			List<EObject> list = BaseUIUtil.getEObjectsFromSelection(selection);
			for (EObject eo : list) {
				if (eo instanceof Diagram) {
					contexts.add((Diagram) eo);
				}
			}
		}
	}

	/**
	 * Subclass must override this method to provide the correct display option
	 * 
	 * @param context
	 */
	protected abstract void doChangeDisplayOption(Diagram context);

	/**
	 * Change label display style of the given view and all its child view
	 * 
	 * @param view
	 * @param style
	 */
	protected void setAllLabelStyle(View view, String style) {
		for (Object childView : view.getChildren()) {
			if (childView instanceof View) {
				setAllLabelStyle((View) childView, style);
			}
		}
		for (EAnnotation anno : view.getEAnnotations()) {
			if (anno.getSource().endsWith("styles")) { //$NON-NLS-1$
				anno.getDetails().put(LABEL_DISPLAY_STYLE_KEY, style);
			}
		}
	}
}
