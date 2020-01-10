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
package com.zeligsoft.domain.omg.ccm.ui.wizards;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;

/**
 * CCM Component Wizard
 * 
 * @author ysroh
 * 
 */
public class CCMComponentWizard extends Wizard {

	protected EObject context;

	protected CCMComponentWizardPage page;

	protected Component component = null;

	public CCMComponentWizard(EObject context) {
		super();
		this.context = context;
		setWindowTitle(Messages.CCMComponentWizard_Title);
		page = new CCMComponentWizardPage(context);
		addPage(page);

	}

	@Override
	public boolean performFinish() {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(context);
		AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
				editingDomain, Messages.CCMComponentWizard_CommandLabel,
				Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
					IAdaptable arg1) throws ExecutionException {

				Package container = getPackageContainer();
				if(container == null){
					return CommandResult.newCancelledCommandResult();
				}
				
				component = createComponent(container);
				if (page.isCreateImplementation()) {
					
					if (page.isAssemblyType()){  
						//assembly implementation type
						Component assembly = null;
						assembly = createAssembly(container);
						// the "BaseUIUtil.createRelationship" method is created for replacing the RSA specific "UMLElementFactory.createRelationship" method  
						BaseUIUtil.createRelationship(assembly, ZDLElementTypeManager.INSTANCE
								.getElementTypeFromHint("generalization"), assembly, component);
			
						if (page.isCreateStructureDiagram()) {
//							ICommand command = UMLElementFactory.getCreateElementCommand(assembly,
//									ElementTypeRegistry.getInstance().getType(
//											"org.eclipse.gmf.runtime.notation.structureDiagram")); //$NON-NLS-1$
//							command.execute(null, null);
//							CommandResult commandResult = command.getCommandResult();
//							Diagram diagram = (Diagram) commandResult.getReturnValue();
//							diagram.setName(page.getStructureDiagramName());
//							OpenDiagramCommand openCommand = new OpenDiagramCommand(diagram);
//							openCommand.execute(null, null);
						}		
					}
					else { 
						//monolithic implementation type
						Package monoContainer = getMonolithicImplContainer(container);
						if(monoContainer == null){
							return CommandResult.newCancelledCommandResult();
						}
						
						Component monolithic = null;
						monolithic = createMonolithic(monoContainer);
						monolithic.createGeneralization(component);
					}			
				}
				
				if (page.isCreateComponentDiagram()) {
//					Diagram diagram = createDiagram(component);
//					diagram.setName(page.getComponentDiagramName());
//					OpenDiagramCommand openCommand = new OpenDiagramCommand(
//							diagram);
//
//					// Open diagram editor
//					IStatus result = null;
//					if (openCommand.canExecute()) {
//						result = openCommand.execute(null, null);
//					}
//
//					if (result != null && result.getSeverity() == IStatus.OK) {
//
//						DiagramEditPart editPart = BaseDiagramUtil
//								.getDiagramEditPart();
//
//						// Drop elements to the diagram view
//						BaseDiagramUtil.dropElement(editPart, new Point(100,
//								150), component);
//
//						// Refresh the diagram
//						Request refreshRequest = new Request("refresh"); //$NON-NLS-1$
//						org.eclipse.gef.commands.Command refreshCommand = editPart
//								.getCommand(refreshRequest);
//						refreshCommand.execute();
//					}
				}
				return CommandResult.newOKCommandResult();
			}

		};

		Command emfCommand = GMFtoEMFCommandWrapper.wrap(editCommand);
		if (emfCommand.canExecute()) {
			editingDomain.getCommandStack().execute(emfCommand);
			return true;
		}
		return false;
	}

	/**
	 * Return the container that will contain components
	 * 
	 * @return
	 */
	private Package getPackageContainer() {
		Package pkg = (Package) context;
		if (page.isCreatePkg()) {
			Command command = BaseUIUtil.getCreatePackageCommand(context);
			TransactionUtil.getEditingDomain(context).getCommandStack().execute(command);
			Object result = command.getResult().iterator().next();
			if (result instanceof Package) {
				((Package) result).setName(page.getPkgName());
				return (Package) result;
			}
		}
		return pkg;
	}

	private Package getMonolithicImplContainer(Package defaultContainer) {

		if (page.isAddIntoSubpackage()) {
			Command command = BaseUIUtil.getCreatePackageCommand(defaultContainer);
			TransactionUtil.getEditingDomain(context).getCommandStack().execute(command);
			Object result = command.getResult().iterator().next();
			if (result instanceof Package) {
				((Package) result).setName(page.getSubpackageName());
				return (Package) result;
			}
		}
		return defaultContainer;
	}

	private Component createComponent(Package container) throws ExecutionException {
		Component component = (Component) BaseUIUtil.createZDLModelElement(container, CCMNames.CCMCOMPONENT);
		component.setName(page.getComponentName());

		return component;

	}

//	private Diagram createDiagram(EObject container) throws ExecutionException {
//		return BaseDiagramUtil.createComponentDiagram(container);
//
//	}

	private Component createAssembly(Package container) throws ExecutionException {
		Component assembly = (Component) BaseUIUtil.createZDLModelElement(container, CCMNames.ASSEMBLY_IMPLEMENTATION);
		assembly.setName(page.getImplementationName());
		return assembly;
	}

	private Component createMonolithic(Package container) throws ExecutionException {
		Component monolithic = (Component) BaseUIUtil.createZDLModelElement(container,
				CCMNames.MONOLITHIC_IMPLEMENTATION);
		monolithic.setName(page.getImplementationName());
		return monolithic;
	}
}
