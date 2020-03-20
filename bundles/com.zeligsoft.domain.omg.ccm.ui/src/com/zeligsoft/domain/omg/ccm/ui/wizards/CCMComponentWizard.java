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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.component.CreateComponentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.composite.CreateCompositeDiagramCommand;
import org.eclipse.swt.dnd.DND;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
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

			@SuppressWarnings("unchecked")
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
							CreateCompositeDiagramCommand command = new CreateCompositeDiagramCommand();
							command.createDiagram((ModelSet) assembly.eResource().getResourceSet(), assembly,
									page.getStructureDiagramName());
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
					CreateComponentDiagramCommand command = new CreateComponentDiagramCommand();
					Diagram diagram = command.createDiagram((ModelSet)component.eResource().getResourceSet(), component.eContainer(), page.getComponentDiagramName());
					
					IEditorPart editor = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					if (editor instanceof PapyrusMultiDiagramEditor) {
						PapyrusMultiDiagramEditor multiEditor = (PapyrusMultiDiagramEditor) editor;
						ServicesRegistry serviceRegistry = multiEditor.getServicesRegistry();

						DropObjectsRequest request = new DropObjectsRequest();
						request.setLocation(new Point(100, 100));
						request.setObjects(Collections.singletonList(component));
						request.getExtendedData().put("EVENT_DETAIL", DND.DROP_COPY);
						
						// TODO: execute drop command
					}
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
