/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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

package com.zeligsoft.domain.dds4ccm.ui.export;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.xtools.uml.core.internal.convert.Model2UML2;
import com.ibm.xtools.umlnotation.UMLConnector;
import com.ibm.xtools.umlnotation.UMLDiagram;
import com.ibm.xtools.umlnotation.UMLShape;
import com.ibm.xtools.umlnotation.UMLShapeCompartment;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * CX model to UML2 converter
 * 
 * @author Young-Soo Roh
 *
 */
public class CX2UML2 extends Model2UML2 {

	private static final Set<String> UML_ANNOTATIONS = new java.util.HashSet<String>(
			Arrays.asList("http://www.eclipse.org/uml2/2.0.0/UML"));

	private static final Set<String> CX_ANNOTATIONS = new java.util.HashSet<String>(
			Arrays.asList("cx.migration", "zcx", "cx.diagrams"));

	public CX2UML2(boolean unapplyProfiles, boolean regenerateIds) {
		super(unapplyProfiles, regenerateIds);
	}

	@Override
	protected void removeAnnotations(EModelElement eModelElement) {

		List<EAnnotation> nukeEm = new ArrayList<EAnnotation>();
		List<EAnnotation> annotToMigrate = new ArrayList<EAnnotation>();
		ListIterator<EAnnotation> it = eModelElement.getEAnnotations()
				.listIterator();

		while (it.hasNext()) {
			EAnnotation annot = it.next();
			if (!UML_ANNOTATIONS.contains(annot.getSource())
					&& !CX_ANNOTATIONS.contains(annot.getSource())) {
				nukeEm.add(annot);
			}
			if (annot.getSource() == "uml2.diagrams"
					&& !annot.getContents().isEmpty()) {
				annotToMigrate.add(annot);
			}
		}

		// process diagram layout
		for (EAnnotation annot : annotToMigrate) {
			migrateElementsSilently(annot);
		}

		for (Iterator<EAnnotation> iterator = nukeEm.iterator(); iterator
				.hasNext();) {
			EAnnotation annotation = iterator.next();
			destroyElementsSilently((EObject) annotation);
		}
	}

	private static void migrateElementsSilently(final EAnnotation annotation) {
		Resource resource = annotation.eResource();
		if (resource != null) {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put("silent", Boolean.TRUE);
			options.put("no_triggers", Boolean.TRUE);
			options.put("unprotected", Boolean.TRUE);
			options.put("no_validation", Boolean.TRUE);

			AbstractEMFOperation operation = new AbstractEMFOperation(
					TransactionUtil.getEditingDomain(resource), "", options) {

				@Override
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info)
						throws org.eclipse.core.commands.ExecutionException {
					migrateAnnotation(annotation);
					return Status.OK_STATUS;
				}
			};
			try {
				operation.execute((IProgressMonitor) new NullProgressMonitor(),
						null);
			} catch (org.eclipse.core.commands.ExecutionException executionException) {
			}
		}
	}

	private static void destroyElementsSilently(final EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource != null) {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put("silent", Boolean.TRUE);
			options.put("no_triggers", Boolean.TRUE);
			options.put("unprotected", Boolean.TRUE);
			options.put("no_validation", Boolean.TRUE);

			AbstractEMFOperation operation = new AbstractEMFOperation(
					TransactionUtil.getEditingDomain(resource), "", options) {

				@Override
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info)
						throws org.eclipse.core.commands.ExecutionException {
					DestroyElementCommand.destroy(eObject);
					return Status.OK_STATUS;
				}
			};
			try {
				operation.execute((IProgressMonitor) new NullProgressMonitor(),
						null);
			} catch (org.eclipse.core.commands.ExecutionException executionException) {
			}
		}
	}

	private static void migrateAnnotation(EAnnotation source) {

		UMLDiagram rsaDiagram = (UMLDiagram) source.eContents().get(0);
		if (rsaDiagram.getType() != "Structure"
				|| rsaDiagram.getChildren().isEmpty()) {
			return;
		}
		EObject diagramContext = ((Node) rsaDiagram.getChildren().get(0))
				.getElement();
		// Save layout for assembly structure diagram
		if (diagramContext != null
				&& ZDLUtil.isZDLConcept(diagramContext,
						CCMNames.ASSEMBLY_IMPLEMENTATION)) {

			// create new annotation to store GMF notations
			EAnnotation newAnno = ((Component) diagramContext)
					.getEAnnotation("cx.diagrams");
			if (newAnno == null) {
				newAnno = ((Component) diagramContext)
						.createEAnnotation("cx.diagrams");
			}
			// create new Diagram
			Diagram newDiagram = NotationFactory.eINSTANCE.createDiagram();

			// Map from RSA diagram node to GMF diagram node
			// so we can fix references for edge connections
			Map<View, View> nodeMap = new HashMap<View, View>();

			// get RSA diagram component Shape
			Node componentNode = (Node) rsaDiagram.getChildren().get(0);

			// map all nodes
			Node newComponentNode = mapNode(componentNode, nodeMap);
			newDiagram.insertChild(newComponentNode);

			// map all connectors
			for (Object o : rsaDiagram.getEdges()) {
				Edge edge = null;
				if (o instanceof UMLConnector) {
					edge = (Edge) o;

				} else if (o instanceof Connector
						&& "line".equals(((Connector) o).getType())) {
					edge = (Edge) o;
				}
				if (edge != null) {
					Edge newConnector = mapConnector(nodeMap, edge);
					newDiagram.insertEdge(newConnector);
				}
			}

			// add diagram to new annotation
			newAnno.getContents().add(newDiagram);
		}
	}

	/**
	 * Map Node notations
	 * 
	 * @param source
	 * @param target
	 */
	private static Node mapNode(Node source, Map<View, View> nodeMap) {
		Node result = null;
		// check if this is Geometric shape
		if (source.getClass().equals(ShapeImpl.class)
				&& !UMLUtil.isEmpty(source.getType())) {
			result = EcoreUtil.copy(source);
			return result;
		}
		EObject element = source.getElement();
		if (element == null) {
			return result;
		}
		if (ZDLUtil.isZDLConcept(element, CCMNames.CCMPART)
				|| ZDLUtil.isZDLConcept(element, IDL3PlusNames.DATA_SPACE)) {
			result = NotationFactory.eINSTANCE.createShape();
			result.setType("Property_Shape");
			result.setElement(element);
			result.setLayoutConstraint(EcoreUtil.copy(source
					.getLayoutConstraint()));
			for (Object child : source.getPersistedChildren()) {
				if (child instanceof UMLShape) {
					Node newChild = mapNode((Node) child, nodeMap);
					if (newChild != null) {
						result.insertChild(newChild);
						nodeMap.put((View) child, newChild);
					}
				}
			}
		} else if (ZDLUtil.isZDLConcept(element, CCMNames.INTERFACE_PORT)) {
			result = NotationFactory.eINSTANCE.createShape();
			result.setType("Port_Shape");
			result.setElement(element);
			result.setLayoutConstraint(EcoreUtil.copy(source
					.getLayoutConstraint()));
			for (Object o : source.getChildren()) {
				if (o instanceof DecorationNode
						&& ((DecorationNode) o).getType() == "PortName") {
					DecorationNode portNameDeco = EcoreUtil
							.copy((DecorationNode) o);
					portNameDeco.setType("Port_NameLabel");
					result.insertChild(portNameDeco);
					break;
				}
			}
		} else if (ZDLUtil.isZDLConcept(element,
				CCMNames.ASSEMBLY_IMPLEMENTATION)) {
			if (source instanceof UMLShapeCompartment) {
				// map structure compartment
				result = NotationFactory.eINSTANCE.createBasicCompartment();
				result.setType("Component_StructureCompartment");
				result.setElement(element);
				result.setLayoutConstraint(EcoreUtil.copy(source
						.getLayoutConstraint()));

				for (Object o : source.getChildren()) {
					if (o instanceof Node) {
						Node newChild = mapNode((Node) o, nodeMap);
						if (newChild != null) {
							result.insertChild(newChild);
							nodeMap.put((View) o, newChild);
						}
					}
				}
			} else if (source instanceof UMLShape) {
				result = NotationFactory.eINSTANCE.createShape();
				result.setType("Component_Shape");
				result.setElement(element);
				result.setLayoutConstraint(EcoreUtil.copy(source
						.getLayoutConstraint()));
				for (Object o : source.getChildren()) {
					if (o instanceof Node) {
						Node newChild = mapNode((Node) o, nodeMap);
						if (newChild != null) {
							result.insertChild(newChild);
							nodeMap.put((View) o, newChild);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * Map connectors
	 * 
	 * @param nodeMap
	 * @param source
	 * @return
	 */
	private static Edge mapConnector(Map<View, View> nodeMap, Edge source) {
		if ("line".equals(source.getType())) {
			Edge result = EcoreUtil.copy(source);
			result.setSource(nodeMap.get(source.getSource()));
			result.setTarget(nodeMap.get(source.getTarget()));
			return result;
		}
		EObject element = source.getElement();
		Connector result = NotationFactory.eINSTANCE.createConnector();
		result.setElement(element);
		result.setSource(nodeMap.get(source.getSource()));
		result.setTarget(nodeMap.get(source.getTarget()));
		result.setBendpoints(EcoreUtil.copy(source.getBendpoints()));
		return result;
	}

}
