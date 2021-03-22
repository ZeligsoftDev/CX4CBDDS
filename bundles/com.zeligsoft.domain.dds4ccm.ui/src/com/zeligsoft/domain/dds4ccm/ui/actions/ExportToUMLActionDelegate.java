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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.xtools.umlnotation.UMLConnector;
import com.ibm.xtools.umlnotation.UMLDiagram;
import com.ibm.xtools.umlnotation.UMLShape;
import com.ibm.xtools.umlnotation.UMLShapeCompartment;
import com.zeligsoft.base.util.ZeligsoftURIConverter;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Quick export to UML converting RSA diagram notation to GMF notation for
 * diagram migration to Papyrus
 * 
 * @author Young-Soo Roh
 *
 */
public class ExportToUMLActionDelegate extends ActionDelegate implements
		IObjectActionDelegate {

	private static final IContentType EMX_TYPE = Platform
			.getContentTypeManager().getContentType(
					"com.ibm.xtools.uml.msl.umlModelContentType");

	// add to these as the need arises
	private static final Set<String> UML_ANNOTATIONS = new java.util.HashSet<String>(
			Arrays.asList("http://www.eclipse.org/uml2/2.0.0/UML"));

	private static final Set<String> CX_ANNOTATIONS = new java.util.HashSet<String>(
			Arrays.asList("cx.migration", "zcx", "cx.diagrams"));

	private IFile selectedFile;

	private Shell shell;

	private IWorkbenchPart part;

	/**
	 * Initializes me.
	 */
	public ExportToUMLActionDelegate() {
		super();
	}

	public void run(IAction action) {
		if (selectedFile == null) {
			return;
		}

		try {
			part.getSite().getPage().getWorkbenchWindow().getWorkbench()
					.getProgressService()
					.busyCursorWhile(new IRunnableWithProgress() {

						@Override
						public void run(IProgressMonitor monitor)
								throws InvocationTargetException,
								InterruptedException {
							doRun(monitor);
						}
					});
		} catch (Exception e) {
			MessageDialog.openError(shell, "Export to UML", "Export failed: "
					+ e.getLocalizedMessage());
		}
	}

	private void doRun(IProgressMonitor monitor) {
		monitor.beginTask("Exporting ... ", 7);

		ResourceSet rset = new ResourceSetImpl();
		ZeligsoftURIConverter.install(rset);

		// load a UMLResource from the file contents
		Resource uml = rset.createResource(URI.createPlatformResourceURI(
				selectedFile.getFullPath().removeFileExtension()
						.addFileExtension("uml").toString(), true));

		monitor.subTask("Loading the model");
		loadUMLResource(uml);
		monitor.worked(1);

		// ensure the cache adapter
		Package root = (Package) EcoreUtil.getObjectByType(uml.getContents(),
				UMLPackage.Literals.PACKAGE);
		root.getAppliedStereotypes(); // uses the cache adapter
		CacheAdapter cache = CacheAdapter.getCacheAdapter(root);

		Collection<EObject> nukeEm = new java.util.ArrayList<EObject>();
		Map<EObject, Resource> crossResourceContainments = new java.util.HashMap<EObject, Resource>();

		monitor.subTask("Finding elements to delete");
		cleanUpAndExportDiagram(root, nukeEm, crossResourceContainments);
		monitor.worked(1);

		monitor.subTask("Resolving proxies");
		// resolve entire resource set because references in stereotype
		// applications in fragment resources would not be covered by resolveAll
		// on the root resource
		EcoreUtil.resolveAll(rset);
		monitor.worked(1);

		monitor.subTask("Deleting elements");
		deleteElements(cache, nukeEm);
		monitor.worked(1);

		monitor.subTask("Absorbing model fragments");
		absorbFragments(uml, crossResourceContainments);
		monitor.worked(1);

		monitor.subTask("Cleaning up stereotype applications");
		cleanUpStereotypes(uml);
		monitor.worked(1);

		// save
		monitor.subTask("Saving UML model");
		try {
			uml.save(Collections.singletonMap(
					Resource.OPTION_SAVE_ONLY_IF_CHANGED,
					Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER));
			selectedFile.getParent().refreshLocal(1, null);
		} catch (final IOException e) {
			shell.getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					ErrorDialog
							.openError(
									shell,
									"Export failed",
									"Failed to save UML model",
									new Status(
											IStatus.ERROR,
											com.zeligsoft.domain.dds4ccm.ui.Activator.PLUGIN_ID,
											"Failed to save UML model", e));
				}
			});
		} catch (final CoreException e) {
			shell.getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					ErrorDialog.openError(shell, "Export failed",
							"Failed to save UML model", e.getStatus());
				}
			});
		}

		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}
		monitor.worked(1);

		rset.getResources().clear();
		rset.eAdapters().clear();

		monitor.done();
	}

	/**
	 * @param uml
	 */
	private void cleanUpStereotypes(Resource uml) {
		// and remove any unrecognized stereotype applications (those whose
		// schema came from profiles that we didn't resolve) or whose profiles
		// are EPXes
		for (ListIterator<EObject> iter = uml.getContents().listIterator(
				uml.getContents().size()); iter.hasPrevious();) {

			EObject prev = iter.previous();

			if ((prev instanceof AnyType)
					|| "epx".equals(prev.eClass().eResource().getURI()
							.fileExtension())) {
				iter.remove();
			}
		}
	}

	/**
	 * @param uml
	 * @param crossResourceContainments
	 */
	private void absorbFragments(Resource uml,
			Map<EObject, Resource> crossResourceContainments) {
		// absorb cross-resource containments
		for (Map.Entry<EObject, Resource> pair : crossResourceContainments
				.entrySet()) {

			pair.getValue().getContents().remove(pair.getKey());

			// any other contents move to root resource (e.g., stereotype
			// applications)
			uml.getContents().addAll(pair.getValue().getContents());
		}
	}

	/**
	 * @param cache
	 * @param nukeEm
	 */
	private void deleteElements(CacheAdapter cache, Collection<EObject> nukeEm) {
		// destroy the annotations
		for (EObject nukeIt : nukeEm) {
			for (EStructuralFeature.Setting setting : cache
					.getInverseReferences(nukeIt)) {
				EcoreUtil.remove(setting, nukeIt);
			}

			EcoreUtil.remove(nukeIt);
		}
	}

	/**
	 * Map Node notations
	 * 
	 * @param source
	 * @param target
	 */
	private Node mapNode(Node source, Map<View, View> nodeMap) {
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
	private Edge mapConnector(Map<View, View> nodeMap, Edge source) {
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

	/**
	 * 
	 * Clean up UML and export diagram layout
	 * 
	 * @param root
	 * @param nukeEm
	 * @param crossResourceContainments
	 */
	private void cleanUpAndExportDiagram(EObject root,
			Collection<EObject> nukeEm,
			Map<EObject, Resource> crossResourceContainments) {
		// strip non-Eclipse annotations and absorb fragments
		for (TreeIterator<EObject> iter = root.eAllContents(); iter.hasNext();) {
			EObject next = iter.next();

			if (next instanceof EAnnotation) {
				EAnnotation annot = (EAnnotation) next;

				if (!UML_ANNOTATIONS.contains(annot.getSource())
						&& !CX_ANNOTATIONS.contains(annot.getSource())) {
					nukeEm.add(annot);
				}

				// process diagram layout
				if (annot.getSource() == "uml2.diagrams"
						&& !annot.getContents().isEmpty()) {
					migrateAnnotation(annot);
				}

				iter.prune();
			} else if (next instanceof ProfileApplication) {
				ProfileApplication app = (ProfileApplication) next;
				Profile profile = app.getAppliedProfile();

				if (profile.eIsProxy()
						|| "epx".equals(profile.eResource().getURI()
								.fileExtension())) {

					nukeEm.add(app);
				}

				iter.prune();
			} else {
				// handle cross-resource-contained element
				Resource res = ((InternalEObject) next).eDirectResource();
				if (res != null) {
					crossResourceContainments.put(next, res);
				}
			}
		}
	}

	private void migrateAnnotation(EAnnotation source) {

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
	 * @param uml
	 */
	private void loadUMLResource(Resource uml) {
		InputStream contents = null;
		try {
			contents = selectedFile.getContents();
			uml.load(contents, null);
		} catch (IOException e) {
			ErrorDialog
					.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(),
							"Export failed", "Failed to load EMX model",
							new Status(IStatus.ERROR, Activator.PLUGIN_ID,
									"Failed to load EMX model", e));
		} catch (CoreException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Export failed",
					"Failed to load EMX model", e.getStatus());
		} finally {
			if (contents != null) {
				try {
					contents.close();
				} catch (IOException e) {
					// no defense
					Log.error(Activator.getDefault(), 0,
							"Failed to close file input stream", e);
				}
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedFile = null;
		IFile file = null;

		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			IStructuredSelection ssel = (IStructuredSelection) selection;

			Object sel = ssel.getFirstElement();

			if (sel instanceof IFile) {
				file = (IFile) sel;
			} else if (sel instanceof IAdaptable) {
				file = (IFile) ((IAdaptable) sel).getAdapter(IFile.class);
			}

			if (file != null) {
				if ("emx".equals(file.getFileExtension())) {
					String fileName = file.getName();
					InputStream contents = null;

					try {
						contents = file.getContents();
						IContentType[] matches = Platform
								.getContentTypeManager().findContentTypesFor(
										contents, fileName);
						for (IContentType next : matches) {
							if (next.isKindOf(EMX_TYPE)) {
								selectedFile = file;
								break;
							}
						}
					} catch (IOException e) {
						Log.error(Activator.getDefault(), 0,
								"Failed to examine content-types of file: "
										+ file.getFullPath(), e);
					} catch (CoreException e) {
						Log.error(Activator.getDefault(), 0,
								"Failed to examine content-types of file: "
										+ file.getFullPath(), e);
					} finally {
						if (contents != null) {
							try {
								contents.close();
							} catch (IOException e) {
								// no defense
								Log.error(Activator.getDefault(), 0,
										"Failed to close file input stream", e);
							}
						}
					}
				}
			}
		}

		action.setEnabled(selectedFile != null);
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		part = targetPart;
		shell = (targetPart == null) ? null : targetPart.getSite().getShell();
	}
}
