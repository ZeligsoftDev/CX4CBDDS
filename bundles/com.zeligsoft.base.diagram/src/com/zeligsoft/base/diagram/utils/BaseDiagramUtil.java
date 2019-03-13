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
package com.zeligsoft.base.diagram.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowHideRelationshipsRequest;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Package;

import com.ibm.xtools.uml.type.UMLElementFactory;
import com.zeligsoft.base.diagram.ui.Activator;
import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Diagram util
 * 
 * @author ysroh
 * 
 */
public class BaseDiagramUtil {

	private static final String SOURCE_NAME = "cx.migration"; //$NON-NLS-1$

	public static IMapMode mapMode = MapModeUtil.getMapMode();

	public static final double UNITS_PER_INCH = 2540.0;

	private static int targetDPI;

	static {
		Display display = Display.getCurrent();
		if (display == null) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					targetDPI = Display.getCurrent().getDPI().x;
				}
			});
		} else {
			targetDPI = display.getDPI().x;
		}
	}

	public static int getDPI() {
		return targetDPI;
	}

	public static void saveDPIAnnotation(final Package model) {
		ICommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(model), "Add DPI", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				// add migration info to model
				EAnnotation anno = model.getEAnnotation(SOURCE_NAME);
				if (anno == null) {
					anno = model.createEAnnotation(SOURCE_NAME);
				}
				anno.getDetails().put("dpi", String.valueOf(targetDPI)); //$NON-NLS-1$
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			command.execute(null, null);
		} catch (ExecutionException e) {
			// do nothing
		}
	}
	
	public static String getDPIFromAnnotation(final Package model) {
		EAnnotation anno = model.getEAnnotation(SOURCE_NAME);
		if (anno == null) {
			return null;
		}
		return anno.getDetails().get("dpi"); //$NON-NLS-1$
	}

	/**
	 * Queries the view from the selected Diagram Edit Part
	 * 
	 * @return
	 */
	public static View getContextEditPartView() {
		View view = null;
		ISelection selection = BaseUIUtil.getSelection();

		if (selection instanceof IStructuredSelection) {
			if (((IStructuredSelection) selection).getFirstElement() instanceof IAdaptable) {
				view = (View) ((IAdaptable) ((IStructuredSelection) selection)
						.getFirstElement()).getAdapter(View.class);
			}
		}

		return view;
	}

	/**
	 * Find EditPart that represents given element from the active open diagram
	 * editor. Return null if the active editor is not diagram editor.
	 * 
	 * @param element
	 *            EObject
	 * @return EditPart
	 */
	public static EditPart findEditPartFromActiveDiagramEditPart(EObject element) {

		EditPart part = getContextEditPart();
		if (part instanceof TextCompartmentEditPart) {
			part = part.getParent();
		}

		if (part != null) {

			IWorkbenchPage page = BaseUIUtil.getActivepage();
			if (!(page.getActiveEditor() instanceof IDiagramWorkbenchPart)) {
				return null;
			}
			IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart) page
					.getActiveEditor();

			return diagramPart.getDiagramEditPart().findEditPart(part, element);
		}

		return null;
	}

	/**
	 * Get EditPart that represents the selected object.
	 * 
	 * @return
	 */
	public static EditPart getContextEditPart() {

		EditPart part = null;
		ISelection selection = BaseUIUtil.getSelection();
		if (selection instanceof IStructuredSelection) {
			if (((IStructuredSelection) selection).getFirstElement() instanceof IAdaptable) {
				return (EditPart) ((IAdaptable) ((IStructuredSelection) selection)
						.getFirstElement()).getAdapter(EditPart.class);
			}
		}
		return part;
	}

	/**
	 * Get diagram edit part from the current active diagram editor.
	 * 
	 * @param page
	 * @return
	 */
	public static DiagramEditPart getDiagramEditPart() {

		IWorkbenchPage page = BaseUIUtil.getActivepage();

		if (page.getActiveEditor() instanceof IDiagramWorkbenchPart) {
			IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart) page
					.getActiveEditor();
			if (diagramPart != null) {
				return diagramPart.getDiagramEditPart();
			}
		}
		return null;
	}

	/**
	 * Drop object to a diagram edit part
	 * 
	 * @param editPart
	 * @param dropLocation
	 * @param object
	 */
	public static void dropElement(DiagramEditPart editPart,
			Point dropLocation, EObject object) {

		// Drop interface
		EList<EObject> elementToDrop = new BasicEList<EObject>();
		elementToDrop.add(object);

		DropObjectsRequest dropRequest = new DropObjectsRequest();
		dropRequest.setObjects(elementToDrop);
		dropRequest.setAllowedDetail(1);
		dropRequest.setLocation(dropLocation);

		org.eclipse.gef.commands.Command command = editPart
				.getCommand(dropRequest);

		command.execute();
	}

	/**
	 * Show required relationships for the given object.
	 * 
	 * @param editPart
	 * @param object
	 * @param relationshipType
	 */
	public static void showRelationships(DiagramEditPart editPart,
			EObject object, List<IElementType> typesToShow) {
		List<Object> typeToShow = new ArrayList<Object>();
		for (IElementType type : typesToShow) {
			typeToShow.add(type);
		}

		List<Object> selectedShapes = new ArrayList<Object>();
		selectedShapes.add(editPart.findEditPart(null, object));
		ShowHideRelationshipsRequest showRelationshipRequest = new ShowHideRelationshipsRequest(
				selectedShapes, typeToShow, Collections.EMPTY_LIST);

		Command showRelationshipCommand = editPart
				.getCommand(showRelationshipRequest);
		showRelationshipCommand.execute();
	}

	/**
	 * Request in-line edit for edit part
	 * 
	 * @param eObject
	 * @return
	 */
	public static boolean startInlineEdit(EObject eObject) {
		View partView = BaseDiagramUtil.getContextEditPartView();

		if (partView != null) {
			EditPart part = BaseDiagramUtil
					.findEditPartFromActiveDiagramEditPart(eObject);
			if (part != null && !(part instanceof DiagramEditPart)) {
				part.performRequest(new Request(
						org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT));
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates a component diagram
	 * 
	 * @param container
	 * @return
	 */
	public static Diagram createComponentDiagram(EObject container) {

		ICommand command = UMLElementFactory.getCreateElementCommand(
				container,
				ElementTypeRegistry.getInstance().getType(
						"org.eclipse.gmf.runtime.notation.componentDiagram")); //$NON-NLS-1$
		try {
			command.execute(null, null);
		} catch (ExecutionException e) {
			Activator.getDefault().error(
					"Failed to create a component diagram", e); //$NON-NLS-1$
		}
		CommandResult commandResult = command.getCommandResult();

		if (commandResult != null) {
			return (Diagram) commandResult.getReturnValue();
		}
		return null;
	}

	/**
	 * Find edit part from the given editor
	 * 
	 * @param diagramPart
	 *            Diagram edit part to search
	 * @param elementToFind
	 *            Element to find
	 * @return
	 */
	public static EditPart findEditPartFromEditor(
			IDiagramWorkbenchPart diagramPart, EObject elementToFind) {
		if (diagramPart == null) {
			throw new IllegalArgumentException("null editor"); //$NON-NLS-1$
		}
		EditPart part = null;
		if (elementToFind instanceof Connector) {
			for (Object o : diagramPart.getDiagramEditPart().getConnections()) {
				if (o instanceof ConnectionEditPart
						&& ((ConnectionEditPart) o).getModel() instanceof View) {
					EObject eobj = ((View) ((ConnectionEditPart) o).getModel())
							.getElement();
					if (eobj == elementToFind) {
						part = (EditPart) o;
					}
				}
			}
		} else {
			part = diagramPart.getDiagramEditPart().findEditPart(
					diagramPart.getDiagramEditPart().getRoot(), elementToFind);
		}
		return part;
	}

	private static EObject findElementFromView(View diagram, EObject element) {
		EObject result = null;
		for (Object v : diagram.getChildren()) {
			if (v instanceof View) {
				if (((View) v).getElement() == element) {
					return (View) v;
				}
				result = findElementFromView((View) v, element);
				if (result != null) {
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * Find an element from the given diagram
	 * 
	 * @param diagram
	 * @param element
	 * @return
	 */
	public static EObject findElementFromDiagram(Diagram diagram,
			EObject element) {
		if (element instanceof Connector) {
			for (Object e : diagram.getEdges()) {
				if (e instanceof View && ((View) e).getElement() == element) {
					return (EObject) e;
				}
			}
			return null;
		}
		return findElementFromView(diagram, element);
	}
}
