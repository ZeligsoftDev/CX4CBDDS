/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls.ui.actions;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

import com.prismtech.domain.sca.ppls.Activator;
import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * UI Action "Enable PLM Capability" to add the VariationPointProfile
 * to an SCA Model element
 * 
 * @author mciobanu
 * 
 */
public class EnablePLMAction implements IObjectActionDelegate {

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

		if (eo == null) {
			return;
		}

		ICommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(eo),
				Messages.EnableVariationPointProfileLabel, Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				if (eo instanceof Package) {
					final Package context = (Package) eo;
					final TransactionalEditingDomain domain = TransactionUtil
							.getEditingDomain(context);

					if (null == domain) {
						Activator.getDefault().error(
								Messages.EnableVariationPointProfileEditingDomainError,
								null);
					}

					final ResourceSet resourceSet = domain.getResourceSet();

					if (null != resourceSet) {
						final Resource profileResource = resourceSet
								.getResource(
										URI.createURI("pathmap://PPLS_PROFILES/VariationPointProfile.epx"), true); //$NON-NLS-1$ 

						if (null == profileResource) {
							Activator
									.getDefault()
									.error(Messages.EnableVariationPointProfileVPProfileNotFoundError,
											null);
						}

						final Profile profile = (Profile) profileResource
								.getContents().get(0);

						if (null == profile) {
							Activator
									.getDefault()
									.error(Messages.EnableVariationPointProfileModelElementNotFoundInProfileError,
											null);
						}

						boolean vpProfileAlreadyApplied = false;

						for (Profile p : context.getAllAppliedProfiles()) {
							if (p.getName().equals(
									PLMNames.VARIATION_POINT_PROFILE)) {
								vpProfileAlreadyApplied = true;
								continue;
							}
						}

						if (vpProfileAlreadyApplied == true) {
							Activator.getDefault().warning(
									Messages.EnableVariationPointProfileAlreadyEnabled);
						} else {
							//remove the annotation if using a generated model as a source model
							EAnnotation anno = context.getEAnnotation(PLMNames.MODEL_ANNOTATION); 
							if (anno != null){
								context.getEAnnotations().remove(anno);
							}
							context.applyProfile(profile);
						}
					}

				} else {
					Activator.getDefault().warning(
							Messages.EnableVariationPointProfileUnsupportedElementError);
				}
				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {
			Activator.getDefault().error(Messages.EnableVariationPointProfileError, e);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {

		this.selection = selection;

	}

}
