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
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.OpenDiagramCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.ibm.xtools.uml.type.UMLElementFactory;
import com.zeligsoft.base.diagram.utils.BaseDiagramUtil;
import com.zeligsoft.base.ui.commands.CreatePackageWithoutDiagramCommand;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.Activator;
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
		AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
				UMLModeler.getEditingDomain(), Messages.CCMComponentWizard_CommandLabel,
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
						UMLElementFactory.createRelationship(assembly,
								ZDLElementTypeManager.INSTANCE
										.getElementTypeFromHint("generalization"), //$NON-NLS-1$
								assembly, 
								component, 
								null);
						if (page.isCreateStructureDiagram()) {
							ICommand command = UMLElementFactory.getCreateElementCommand(assembly,
									ElementTypeRegistry.getInstance().getType(
											"org.eclipse.gmf.runtime.notation.structureDiagram")); //$NON-NLS-1$
							command.execute(null, null);
							CommandResult commandResult = command.getCommandResult();
							Diagram diagram = (Diagram) commandResult.getReturnValue();
							diagram.setName(page.getStructureDiagramName());
							OpenDiagramCommand openCommand = new OpenDiagramCommand(diagram);
							openCommand.execute(null, null);
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
						UMLElementFactory.createRelationship(monolithic,
								ZDLElementTypeManager.INSTANCE
										.getElementTypeFromHint("generalization"), //$NON-NLS-1$
										monolithic, 
										component, 
										null);
					}			
				}
				
				if (page.isCreateComponentDiagram()) {
					Diagram diagram = createDiagram(component);
					diagram.setName(page.getComponentDiagramName());
					OpenDiagramCommand openCommand = new OpenDiagramCommand(
							diagram);

					// Open diagram editor
					IStatus result = null;
					if (openCommand.canExecute()) {
						result = openCommand.execute(null, null);
					}

					if (result != null && result.getSeverity() == IStatus.OK) {

						DiagramEditPart editPart = BaseDiagramUtil
								.getDiagramEditPart();

						// Drop elements to the diagram view
						BaseDiagramUtil.dropElement(editPart, new Point(100,
								150), component);

						// Refresh the diagram
						Request refreshRequest = new Request("refresh"); //$NON-NLS-1$
						org.eclipse.gef.commands.Command refreshCommand = editPart
								.getCommand(refreshRequest);
						refreshCommand.execute();
					}
				}
				return CommandResult.newOKCommandResult();
			}

		};

		try {
			OperationHistoryFactory.getOperationHistory()
					.execute(editCommand, null, null);

		} catch (ExecutionException e) {
			Activator.getDefault().error(Messages.CCMComponentWizard_ErrorMsg, e);
		}

		return true;
	}

	/**
	 * Return the container that will contain components
	 * 
	 * @return
	 */
	private Package getPackageContainer() {
		Package pkg = (Package) context;
		if (page.isCreatePkg()) {
			ICommand command = new CreatePackageWithoutDiagramCommand(context);
			try {
				OperationHistoryFactory.getOperationHistory().execute(command,
						null, null);
			} catch (ExecutionException e) {
				ZeligsoftCXUIPlugin.getDefault().error(
						"Failed to create a package", e); //$NON-NLS-1$
				return null;
			}
			CommandResult result = command.getCommandResult();
			if (result != null && result.getReturnValue() != null) {
				if (result.getReturnValue() instanceof Package) {
					pkg = (Package) result.getReturnValue();
					pkg.setName(page.getPkgName());
				}
			}
		}
		return pkg;
	}
	
	
	private Package getMonolithicImplContainer(Package defaultContainer) {
		
		if (page.isAddIntoSubpackage()) {
			ICommand command = new CreatePackageWithoutDiagramCommand(defaultContainer);
			try {
				OperationHistoryFactory.getOperationHistory().execute(command,
						null, null);
			} catch (ExecutionException e) {
				ZeligsoftCXUIPlugin.getDefault().error(
						"Failed to create a subpackage", e); //$NON-NLS-1$
				return null;
			}
			CommandResult result = command.getCommandResult();
			if (result != null && result.getReturnValue() != null) {
				if (result.getReturnValue() instanceof Package) {
					Package newSubpackage = (Package) result.getReturnValue();
					newSubpackage.setName(page.getSubpackageName());
					return newSubpackage;
				}
			}
		}
		return defaultContainer;
	}

	private Component createComponent(Package container) throws ExecutionException {
		Component component = (Component) BaseUIUtil.createZDLModelElement(container,
				CCMNames.CCMCOMPONENT);
		component.setName(page.getComponentName());

		return component;

	}

	private Diagram createDiagram(EObject container) throws ExecutionException {
		return BaseDiagramUtil.createComponentDiagram(container);

	}

	private Component createAssembly(Package container) throws ExecutionException {
		Component assembly = (Component) BaseUIUtil.createZDLModelElement(container,
				CCMNames.ASSEMBLY_IMPLEMENTATION);
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
