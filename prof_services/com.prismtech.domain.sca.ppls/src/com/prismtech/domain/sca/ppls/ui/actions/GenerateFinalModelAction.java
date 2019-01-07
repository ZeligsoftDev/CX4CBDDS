/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls.ui.actions;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.prismtech.domain.sca.ppls.Activator;
import com.prismtech.domain.sca.ppls.commands.GenerateFinalModelCommand;
import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Action generating a Spectra CX Model Variant of a superset model from a Configuration in a VPModel.
 * 
 * @see GenerateFinalModelCommand
 * 
 * @author smcfee
 * @author mciobanu
 *
 */
public class GenerateFinalModelAction implements IObjectActionDelegate {
		
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
		
		final EObject eo = BaseUIUtil.getEObjectFromSelection(selection);
		
		if( eo == null ) {
			return;
		}
		
		ICommand command = new GenerateFinalModelCommand(UMLModeler.getEditingDomain(),
				Messages.GenerateModelLabel,
				Collections.EMPTY_MAP, null, eo);	
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {
			Activator.getDefault().error(Messages.GenerateModelError, e);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
		this.selection = selection;
		
	}
}
