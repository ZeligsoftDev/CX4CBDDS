/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls.ui.actions;

import java.util.Collections;
import java.util.UUID;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

import com.prismtech.domain.sca.ppls.Activator;
import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.prismtech.domain.sca.ppls.utils.PLMUtil;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.sca.utils.SCANames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * 
 * @author mciobanu
 *
 */

public class AddVariationPointWithValueToDiagramAction implements IObjectActionDelegate {
		
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
		
		ICommand command = new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(eo),
				Messages.CreateVariationPointLabel,

				Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				if( ZDLUtil.isZDLConcept(eo, SCANames.SCAPROPERTY)) {
						Constraint newConstraint = UMLFactory.eINSTANCE.createConstraint();
						for( ProfileApplication p : ((Element)eo).getModel().getAllProfileApplications()) {
							if( p.getAppliedProfile().getName().equals(PLMNames.VARIATION_POINT_PROFILE)) {
								for( Stereotype s : p.getAppliedProfile().getOwnedStereotypes()) {
									if( s.getQualifiedName().equals(PLMNames.VARIATION_POINT_WITH_VALUE)) {
										((Namespace)eo.eContainer()).getOwnedRules().add(newConstraint);
										newConstraint.applyStereotype(s);
										newConstraint.getConstrainedElements().add((Element)eo);
										newConstraint.setName(ZDLUtil.getValue(eo, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME).toString());
										
										OpaqueExpression value = UMLFactory.eINSTANCE.createOpaqueExpression();
										newConstraint.setSpecification(value);
										
										String uuid = UUID.randomUUID().toString();
										newConstraint.setValue(s, PLMNames.VARIATION_POINT__VP_ID, "VP-" + uuid); //$NON-NLS-1$
										
										if(PLMUtil.canAddElementToActiveDiagram(newConstraint)){
											PLMUtil.addElementToActiveDiagram(newConstraint);
										}
										break;
									}
								}
								break;
							}
						}
					}

				
				return CommandResult.newOKCommandResult();
			}
		};
		
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
