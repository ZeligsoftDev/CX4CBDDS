/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls.ui.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.prismtech.domain.sca.ppls.Activator;
import com.prismtech.domain.sca.ppls.commands.AddVariationPointCommand;
import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.zeligsoft.base.ui.utils.BaseUIUtil;



public class AddVariationPointAction implements IObjectActionDelegate {

	private ISelection selection;
	protected IWorkbenchPart myPart;

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		if(selection instanceof IStructuredSelection){
			if(((IStructuredSelection)selection).size() > 1){
				return;
			}
		}
		
		EObject eo = BaseUIUtil.getEObjectFromSelection(selection);

		if( eo == null ) {
			return;
		}

		ICommand command = new AddVariationPointCommand( eo );
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {
			Activator.getDefault().error(Messages.CreateVariationPointError, e);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {

		this.selection = selection;

	}

}
