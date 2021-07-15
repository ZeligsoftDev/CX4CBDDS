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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.composite.CreateCompositeDiagramCommand;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;

/**
 * Migrate DDS4CCM model
 * 
 * @author ysroh
 * 
 */
public class MigrateModelActionHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final EObject selObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());
		if (selObject == null || !(selObject instanceof Model)) {
			return null;
		}

		if (DDS4CCMMigrationUtil.isMigrationRequired((Model) selObject)) {

			List<Component> assemblies = getAssembliesWithRSADiagramAnnotation(selObject);

			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selObject);
			final AbstractTransactionalCommand migrationCommand = new AbstractTransactionalCommand(
					TransactionUtil.getEditingDomain(selObject), Messages.MigrateModelAction_CommandLabel, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {

					DDS4CCMMigrationUtil.migrateAll((Model) selObject);
					// create structure diagrams
					for (Component assembly : assemblies) {
						CreateCompositeDiagramCommand cmd = new CreateCompositeDiagramCommand();
						cmd.createDiagram((ModelSet) selObject.eResource().getResourceSet(), assembly,
								assembly.getName() + " StructureDiagram"); //$NON-NLS-1$
					}

					return CommandResult.newOKCommandResult();
				}
			};

			UIJob job = new UIJob("Model Migration") { //$NON-NLS-1$

				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {
					monitor.beginTask(Messages.MigrateModelAction_MonitorTask, IProgressMonitor.UNKNOWN);
					Command emfCommand = GMFtoEMFCommandWrapper.wrap(migrationCommand);
					editingDomain.getCommandStack().execute(emfCommand);
					monitor.done();
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							Messages.MigrateModelAction_DialogTitle, Messages.Migrate_OK);
					return Status.OK_STATUS;
				}
			};
			job.setUser(true);
			job.schedule();

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
					Messages.MigrateModelAction_DialogTitle, Messages.Migrate_Noop);
		}
		return null;
	}
	
	
	/**
	 * Get assemblies that contains RSA diagram layout information
	 * 
	 * @param model
	 * @return
	 */
	public static List<Component> getAssembliesWithRSADiagramAnnotation(EObject model) {
		final List<Component> result = new ArrayList<Component>();
		for (TreeIterator<EObject> iter = model.eAllContents(); iter.hasNext();) {
			EObject next = iter.next();

			if (!(next instanceof org.eclipse.uml2.uml.Package) && !(next instanceof Component)) {
				iter.prune();
			} else if (CCMUtil.isAssemblyComponent(next)) {
				EObject assembly = CCMUtil.getAssemblyFromComponent(next);
				EAnnotation annot = ((Component) assembly).getEAnnotation("cx.diagrams"); //$NON-NLS-1$
				if (annot != null && !annot.eContents().isEmpty() && annot.eContents().get(0) instanceof Diagram) {
					result.add((Component) assembly);
				}
			}
		}
		return result;
	}
}
