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
package com.zeligsoft.cx.ui.wizard;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Wizard which supports the default creation of CX components.  This wizard implementation
 * considers only simple component creation i.e. a ComponentInterface, Component and Implementation
 * and their relationships.
 * 
 * @author ysroh
 * 
 */
public class ComponentCreationWizard
		extends Wizard {

	/**
	 * 
	 */
	protected ComponentCreationWizardPage page;

	/** 
	 * The element context for creation.
	 */
	protected Element context;

	public ComponentCreationWizard(Element context) {
		this.context = context;
	}

	@Override
	public void addPage(IWizardPage page) {
		if (page instanceof ComponentCreationWizardPage) {
			this.page = (ComponentCreationWizardPage) page;
		}
		super.addPage(page);
	}

	@Override
	public boolean performFinish() {
		try {
			OperationHistoryFactory.getOperationHistory().execute(
				new AbstractTransactionalCommand(
						TransactionUtil.getEditingDomain(context),
						Messages.ComponentCreationWizard_CreateComponentTransactionLabel,

					Collections.EMPTY_MAP, null) {

					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {

						Package container = getOrCreatePackage();
						Component component = createComponent(container);
						Component componentInterface = null;
						Artifact implementation = null;

						Boolean autoCI = page.getCreateComponentInterface();
						Boolean autoImpl = page.getCreateImplementation();

						// Configure component interface
						if (autoCI) {
							componentInterface = createComponentInterface(container);
							component.createGeneralization(componentInterface);
						}

						// Configure implementation
						if (autoImpl) {
							implementation = createImplementation(container);
							// TODO: Create request for the creation of this element
							Manifestation manifestation = implementation
								.createManifestation(null, component);
							ZDLUtil.addZDLConcept(manifestation,
								ZMLMMNames.COMPONENT_IMPLEMENTATION);
						}

						// configure diagram
						if (page.getCreateDiagram()) {

//							Diagram diagram = createDiagram(container);
//							OpenDiagramCommand openCommand = new OpenDiagramCommand(
//								diagram);
//
//							// Open diagram editor
//							IStatus result = null;
//							if (openCommand.canExecute()) {
//								result = openCommand.execute(null, null);
//							}
//
//							if (result.getSeverity() == IStatus.OK) {
//
//								IWorkbenchPage page = PlatformUI.getWorkbench()
//									.getActiveWorkbenchWindow().getActivePage();
//
//								DiagramEditPart editPart = getDiagramEditPart(page);
//
//								// Drop elements to the diagram view
//								dropElement(editPart, new Point(100, 150),
//									component);
//
//								if (autoCI) {
//									dropElement(editPart, new Point(100, 50),
//										componentInterface);
//
//								}
//								if (autoImpl) {
//									dropElement(editPart, new Point(400, 150),
//										implementation);
//								}
//
//								// Show relationships between views
//								showRelationships(editPart, component);
//
//								// Refresh the diagram
//								Request refreshRequest = new Request("refresh"); //$NON-NLS-1$
//								org.eclipse.gef.commands.Command refreshCommand = editPart
//									.getCommand(refreshRequest);
//								refreshCommand.execute();
//
//							}
						}

						return CommandResult.newOKCommandResult();
					}

				}, null, null);
		} catch (ExecutionException e) {
			ZeligsoftCXUIPlugin.getDefault().error(
				Messages.ComponentCreationWizard_ErrorCreatingElement, e);
		}
		
		return true;
		
	}

	/**
	 * Create a package if auto create package is selected or queries the
	 * container of the selected object.
	 * 
	 * @return
	 */
	protected Package getOrCreatePackage() {

		Package elementResult = null;
		if (page.getCreatePackage()) {
			org.eclipse.emf.common.command.Command command = BaseUIUtil.getCreatePackageCommand(context);
			TransactionUtil.getEditingDomain(context).getCommandStack().execute(command);
			elementResult = (Package) command.getResult().iterator().next();
			elementResult.setName(page.getPackageName());
		} else if (context instanceof Package) {
			elementResult = (Package) context;
		}

		return elementResult;

	}

	/**
	 * Create a component
	 * 
	 * @param container
	 * @return
	 */
	protected Component createComponent(Package container) {

		CreateElementRequest request;
		CommandResult result;
		Component elementResult = null;

		try {
			// Configure component
			String concept = getComponentConcept();

			IElementType type = ZDLElementTypeUtil.getElementType(container,
				concept);
			request = new CreateElementRequest(container, type);
			result = BaseUIUtil.createModelElement(request);
			elementResult = (Component) result.getReturnValue();
			String componentName = page.getComponentName();
			elementResult.setName(componentName);

		} catch (ExecutionException e) {
			ZeligsoftCXUIPlugin.getDefault().error(
				NLS.bind(Messages.ComponentCreationWizard_ErrorCreatingElement,
					page.getComponentName()), e);
		}
		return elementResult;
	}

	/**
	 * Create a component interface
	 * 
	 * @param container
	 * @return
	 */
	protected Component createComponentInterface(Package container) {
		CreateElementRequest request;
		CommandResult result = null;
		Component elementResult = null;

		if (page.getCreateComponentInterface()) {
			IElementType type = ZDLElementTypeUtil.getElementType(container,
				getComponentInterfaceConcept());
			request = new CreateElementRequest(container, type);
			try {
				result = BaseUIUtil.createModelElement(request);
				elementResult = (Component) result.getReturnValue();
				elementResult.setName(page.getComponentInterfaceName());
			} catch (ExecutionException e) {
				ZeligsoftCXUIPlugin.getDefault().error(
					NLS.bind(
						Messages.ComponentCreationWizard_ErrorCreatingElement,
						page.getComponentInterfaceName()), e);
			}
		}
		return elementResult;
	}

	/**
	 * Create a implementation
	 * 
	 * @param container
	 * @return
	 */
	protected Artifact createImplementation(Package container) {

		CreateElementRequest request;
		CommandResult result;
		Artifact elementResult = null;

		if (page.getCreateImplementation()) {
			IElementType type = ZDLElementTypeUtil.getElementType(container,
				getImplementationConcept());

			request = new CreateElementRequest(container, type);
			try {
				result = BaseUIUtil.createModelElement(request);
				elementResult = (Artifact) result.getReturnValue();
				elementResult.setName(page.getImplementationName());

			} catch (ExecutionException e) {
				ZeligsoftCXUIPlugin.getDefault().error(
					NLS.bind(
						Messages.ComponentCreationWizard_ErrorCreatingElement,
						page.getImplementationName()), e);

			}

		}
		return elementResult;
	}

	/**
	 * Create a diagram
	 * 
	 * @param container
	 * @return
	 */
	protected Diagram createDiagram(Package container) {

		if (page.getCreateDiagram()) {
//			Diagram diagram = BaseDiagramUtil.createComponentDiagram(container);
//			if (diagram != null) {
//				diagram.setName(page.getDiagramName());
//				return diagram;
//			}
		}
		return null;
	}

	/**
	 * Get diagram edit part from the current active diagram editor.
	 * 
	 * @param page
	 * @return
	 */
//	protected DiagramEditPart getDiagramEditPart(IWorkbenchPage page) {
//		if (page.getActiveEditor() instanceof IDiagramWorkbenchPart) {
//			IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart) page
//				.getActiveEditor();
//			if (diagramPart != null) {
//				return diagramPart.getDiagramEditPart();
//			}
//		}
//		return null;
//	}

	/**
	 * Show required relationships for the given object.
	 * 
	 * @param editPart
	 * @param object
//	 */
//	protected void showRelationships(DiagramEditPart editPart, EObject object) {
//		List<Object> typeToShow = new ArrayList<Object>();
//		IElementType genElementType = ZDLElementTypeManager.INSTANCE
//			.getElementTypeFromHint("generalization");//$NON-NLS-1$
//		IElementType manElementType = ZDLElementTypeManager.INSTANCE
//			.getElementTypeFromHint("manifestation");//$NON-NLS-1$
//		IElementType depElementType = ZDLElementTypeManager.INSTANCE
//		.getElementTypeFromHint("dependency");//$NON-NLS-1$
//		typeToShow.add(genElementType);
//		typeToShow.add(manElementType);
//		typeToShow.add(depElementType);
//
//		List<Object> selectedShapes = new ArrayList<Object>();
//		selectedShapes.add(editPart.findEditPart(null, object));
//		ShowHideRelationshipsRequest showRelationshipRequest = new ShowHideRelationshipsRequest(
//			selectedShapes, typeToShow, Collections.EMPTY_LIST);
//
//		Command showRelationshipCommand = editPart
//			.getCommand(showRelationshipRequest);
//		showRelationshipCommand.execute();
//	}

	/**
	 * Drop object to a diagram.
	 * 
	 * @param editPart
	 * @param dropLocation
	 * @param object
	 */
//	protected void dropElement(DiagramEditPart editPart, Point dropLocation,
//			EObject object) {
//
//		// Drop interface
//		EList<EObject> elementToDrop = new BasicEList<EObject>();
//		elementToDrop.add(object);
//
//		DropObjectsRequest dropRequest = new DropObjectsRequest();
//		dropRequest.setObjects(elementToDrop);
//		dropRequest.setAllowedDetail(1);
//		dropRequest.setLocation(dropLocation);
//
//		org.eclipse.gef.commands.Command command = editPart
//			.getCommand(dropRequest);
//
//		command.execute();
//	}
	
	
	public String getComponentInterfaceConcept() {
		return ZMLMMNames.COMPONENT_INTERFACE;
	}

	public String getComponentConcept() {
		return ZMLMMNames.STRUCTURAL_REALIZATION;
	}

	public String getImplementationConcept() {
		return ZMLMMNames.IMPLEMENTATION;
	}

}
