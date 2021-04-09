/*******************************************************************************
 * Copyright (c) 2021 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/

package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.geoshapes.internal.draw2d.figures.GeoShapeFigure;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.menu.handlers.AbstractGraphicalCommandHandler;
import org.eclipse.papyrus.infra.gmfdiag.menu.utils.DeleteActionUtil;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Import diagram layout from RSA
 * 
 * @author Young-Soo Roh
 *
 */
@SuppressWarnings({"restriction", "nls"})
public class ImportDiagramLayout extends AbstractGraphicalCommandHandler {

	private double xfactor = (1.0 / 23.8);
	private double yfactor = (1.0 / 23.8);
	private Map<View, View> viewMap = new HashMap<View, View>();
	private static final Set<String> NOTATIONS_TO_MIGRATE = new java.util.HashSet<String>(Arrays.asList(
			"Component_Shape", "Component_StructureCompartment", "Property_Shape", "Port_Shape", "Port_NameLabel")); 
	private Diagram selectedDiagram;

	@Override
	protected Command getCommand(ExecutionEvent event) {
		selectedDiagram = ((Node) getSelectedElements().get(0).getModel()).getDiagram();
		// cleanup geoshapes first before migrating layout
		cleanGeoshapes();

		return getCommand();
	}

	@Override
	protected org.eclipse.gef.commands.Command getCommand() {

		TransactionalEditingDomain editingDomain = getEditingDomain();
		
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}

		List<IGraphicalEditPart> editParts = getSelectedElements();
		if (editParts.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		if (((Node) editParts.get(0).getModel()).getDiagram() == null) {
			return UnexecutableCommand.INSTANCE;
		}

		// get source diagram exported from RSA
		final Component assembly = (Component) ((Node) editParts.get(0).getModel()).getElement();
		EAnnotation annot = assembly.getEAnnotation("cx.diagrams");
		if (annot.eContents().isEmpty() || !(annot.eContents().get(0) instanceof Diagram)) {
			return UnexecutableCommand.INSTANCE;
		}
		final Diagram rsaDiagram = (Diagram) annot.eContents().get(0);
		viewMap.clear();

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, "Import Layout",
				Collections.EMPTY_LIST) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				if (selectedDiagram.getChildren().isEmpty()) {
					// nothing to process
					return CommandResult.newOKCommandResult();
				}

				// migrate all node shape layouts
				Node componentNode = (Node) selectedDiagram.getChildren().get(0);
				Node rsaComponentNode = (Node) rsaDiagram.getChildren().get(0);
				
				Node structure = getStructureCompartment(componentNode);
				Node rsaStructure = (Node) rsaComponentNode.getChildren().get(0);

				// migrate parts layout
				mapNode(rsaComponentNode, componentNode);
				
				// migrate geoshapes first since they don't have any semantic element
				migrateGeoshapes(rsaStructure, structure);

				// construct edge map
				Map<EObject, Edge> elementToEdgeMap = new HashMap<EObject, Edge>();
				for (Object o : rsaDiagram.getEdges()) {
					Edge e = (Edge) o;
					if (e.getElement() != null) {
						elementToEdgeMap.put(e.getElement(), e);
					}
				}

				// now migrate all edge bendpoints
				for (Object o : selectedDiagram.getEdges()) {
					Edge e = (Edge) o;
					Edge sourceEdge = elementToEdgeMap.get(e.getElement());
					if (sourceEdge != null) {
						Bendpoints bendpts = scaleBendpoints((RelativeBendpoints) sourceEdge.getBendpoints());
						e.setBendpoints(bendpts);
					}
				}
				
				// migrate geoshape links
				migrateLinks(rsaDiagram, selectedDiagram);


				return CommandResult.newOKCommandResult();
			}
		};

		return new ICommandProxy(command);

	}

	/**
	 * clean all geoshapes created by previous import
	 */
	private void cleanGeoshapes() {

		List<IGraphicalEditPart> epToDelete = new ArrayList<IGraphicalEditPart>();
		IGraphicalEditPart editPart = getSelectedElements().get(0);
		for (Object o : editPart.getChildren()) {
			IGraphicalEditPart ep = (IGraphicalEditPart) o;
			if (ep.getFigure() instanceof GeoShapeFigure) {
				epToDelete.add(ep);
			}
		}

		CompositeTransactionalCommand command = new CompositeTransactionalCommand(getEditingDomain(),
				"Delete Geoshapes");

		for (IGraphicalEditPart ep : epToDelete) {
			Command curCommand = DeleteActionUtil.getDeleteFromDiagramCommand(ep);
			if (curCommand != null) {
				command.compose(new CommandProxy(curCommand));
			}
		}

		getEditingDomain().getCommandStack().execute(GEFtoEMFCommandWrapper.wrap(new ICommandProxy(command)));
	}

	private void mapNode(Node source, Node target) {

		// migrate layout
		if (source.getLayoutConstraint() instanceof Bounds) {

			Bounds bound = scaleBounds((Bounds) source.getLayoutConstraint());
			target.setLayoutConstraint(bound);
			if ("Port_NameLabel".equals(target.getType())) {
				bound.setY(bound.getY() - 10);
			}
		}
		viewMap.put(source, target);

		Map<EObject, Node> elementToNodeMape = new HashMap<EObject, Node>();
		// build element to node map for source child
		for (Object o : source.getChildren()) {
			Node child = (Node) o;
			elementToNodeMape.put(child.getElement(), child);
		}

		for (Object o : target.getChildren()) {
			Node child = (Node) o;
			if (NOTATIONS_TO_MIGRATE.contains(child.getType())) {
				Node rsaChild = elementToNodeMape.get(child.getElement());
				if (rsaChild != null) {
					mapNode(rsaChild, child);
				}
			}
		}
	}

	private int scale(int num, double factor) {
		return (int) Math.floor(num * factor);
	}

	private Bounds scaleBounds(Bounds source) {
		Bounds bound = (Bounds) EcoreUtil.copy(source);
		bound.setX(scale(bound.getX(), xfactor));
		bound.setY(scale(bound.getY(), yfactor));
		bound.setWidth(scale(bound.getWidth(), xfactor));
		bound.setHeight(scale(bound.getHeight(), yfactor));
		return bound;
	}

	private Bendpoints scaleBendpoints(RelativeBendpoints source) {
		RelativeBendpoints bendpts = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<Object> points = new ArrayList<Object>();
		for (Object o : source.getPoints()) {
			RelativeBendpoint rbp = (RelativeBendpoint) o;
			points.add(new RelativeBendpoint(scale(rbp.getSourceX(), xfactor), scale(rbp.getSourceY(), yfactor),
					scale(rbp.getTargetX(), xfactor), scale(rbp.getTargetY(), yfactor)));
		}
		bendpts.setPoints(points);
		return bendpts;
	}

	/**
	 * Find structure compartment
	 * 
	 * @param node
	 * @return
	 */
	private Node getStructureCompartment(Node node) {
		if ("Component_StructureCompartment".equals(node.getType())) {
			return node;
		}

		Node result = null;
		for (Object child : node.getChildren()) {
			if (child instanceof Node) {
				result = getStructureCompartment((Node) child);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Migrate all geoshape to a new diagram
	 * 
	 * @param parent
	 */
	private void migrateGeoshapes(Node source, Node target) {

		for (Object o : source.getChildren()) {
			Node n = (Node) o;
			if (n.getElement() == null) {
				Node copy = (Node) EcoreUtil.copy(n);
				if (copy.getLayoutConstraint() instanceof Bounds) {
					Bounds b = (Bounds) copy.getLayoutConstraint();
					b.setX(scale(b.getX(), xfactor));
					b.setY(scale(b.getY(), yfactor));
					b.setWidth(scale(b.getWidth(), xfactor));
					b.setHeight(scale(b.getHeight(), yfactor));
				}
				target.insertChildAt(copy, 0);
				viewMap.put(n, copy);
			}
		}
	}

	/**
	 * Migrate all geoshape links
	 * 
	 * @param diagram
	 */
	private void migrateLinks(Diagram source, Diagram target) {
		for (Object o : source.getEdges()) {
			Edge edge = (Edge) o;
			// we can safely assume that it is geo shape if no semantic element is found
			if ("line".equals(edge.getType())) {
				Edge newEdge = EcoreUtil.copy(edge);
				View newSource = viewMap.get(edge.getSource());
				View newTarget = viewMap.get(edge.getTarget());
				if (newSource != null && newTarget != null) {
					newEdge.setSource(newSource);
					newEdge.setTarget(newTarget);
					Bendpoints newBendPts = scaleBendpoints((RelativeBendpoints) edge.getBendpoints());
					newEdge.setBendpoints(newBendPts);
					target.insertEdge(newEdge);
				}
			}
		}
	}

	@Override
	protected boolean computeEnabled() {
		List<IGraphicalEditPart> editParts = getSelectedElements();
		if (editParts.isEmpty()) {
			return false;
		}

		if (!(editParts.get(0).getModel() instanceof Node)) {
			return false;
		}
		Node node = (Node) editParts.get(0).getModel();
		if (node.getElement() == null) {
			return false;
		}

		if (!ZDLUtil.isZDLConcept(node.getElement(), CCMNames.ASSEMBLY_IMPLEMENTATION)) {
			return false;
		}

		Component comp = (Component) ((Node) editParts.get(0).getModel()).getElement();
		return comp.getEAnnotation("cx.diagrams") != null;
	}

}
