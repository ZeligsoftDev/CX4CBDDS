/**
 * 
 */
package com.zeligsoft.base.ui.menus.test.actions;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.uml2.uml.Package;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.ui.menus.test.AbstractMenuFactoryTestCase;

/**
 * @author Zeligsoft
 *
 */
public class TestActionDelegate implements IActionDelegate {

	/**
	 * 
	 */
	public TestActionDelegate() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		final TransactionalEditingDomain domain =
			UMLModeler.getEditingDomain();
		
		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
				domain, "Test Delegate Action", Collections.EMPTY_MAP, null) {

				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws org.eclipse.core.commands.ExecutionException {
					ResourceSet rset = domain.getResourceSet();
					if(rset != null) {
						Resource res = rset.getResource(
								URI.createURI(AbstractMenuFactoryTestCase.DEFAULT_TEST_MODEL_URI), true);
						
						if(!res.getContents().isEmpty() &&
								res.getContents().get(0) instanceof Package) {
							Package pkg = (Package) res.getContents().get(0);
							pkg.createOwnedClass("TestActionDelegateClass", true);
						}
					}
					

					return CommandResult.newOKCommandResult();
				}

			};

			try {
				OperationHistoryFactory.getOperationHistory().execute(buildSenario,
					null, null);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
