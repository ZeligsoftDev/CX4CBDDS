/***************************************************
 * Copyright (c) 2010 Atos Origin.

 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Atos Origin - Initial API and implementation
 *
 ****************************************************/
package org.eclipse.papyrus.views.modelexplorer.actions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.ui.services.editor.EditorService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewRefactorHelper;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.commands.EObjectInheritanceCopyCommand;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * The Class GenericTransformer. Permits to transform an eobject of eclass to
 * another eclass
 */
public class GenericTransformer {

	/** The factories to create eObjects */
	private static HashMap<String, AdapterFactory> factories = new HashMap<String, AdapterFactory>();

	/** extension to recover factories */
	private static final String EXT_FACTORIES = "org.eclipse.emf.edit.itemProviderAdapterFactories";

	/** title of the warning dialog */
	private static final String WARNING_TITLE = "Problems during transformation";

	/** message of the warning dialog */
	private static final String WARNING_MSG = "It seems the transformation you want to perform can't be executed";

	/** command to execute the whole transformation */
	private CompositeCommand globalCommand;

	/** element to transform */
	private EObject element;

	/** views referencing the element */
	private Set<View> referencingViews = new HashSet<View>();

	/** command to execute the model transformation */
	private EObjectInheritanceCopyCommand commandModel;

	/** whether the graphical edit parts must also be transformed */
	private boolean graphCopy = true;

	/** the command to import new graphical edit parts */
	private ImporterCommand importerCommand;

	/**
	 * Instantiates a new generic transformer.
	 *
	 * @param currentNode
	 *            the current node
	 */
	public GenericTransformer(AbstractGraphicalEditPart currentNode) {
		this(currentNode, true);
	}

	/**
	 * Instantiates a new generic transformer. and specify if we have to perform
	 * graphical copy
	 *
	 * @param currentNode
	 *            the current node
	 * @param graphCopy
	 *            the graph copy
	 */
	public GenericTransformer(AbstractGraphicalEditPart currentNode, boolean graphCopy) {
		this.graphCopy = graphCopy;
		if (currentNode != null) {
			Object model = currentNode.getModel();
			if (model instanceof View) {
				this.element = ((View) model).getElement();
			}
		}
	}

	/**
	 * Instantiates a new generic transformer.
	 *
	 * @param currentEobject
	 *            the current eobject
	 */
	public GenericTransformer(EObject currentEobject) {
		this.element = currentEobject;
	}

	/**
	 * Transform the element to the given eclass.
	 *
	 * @param eclass
	 *            the targeted eclass
	 */
	public void transform(EClass eclass) {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = page.getActiveEditor();
		CommandStack stack = editor.getAdapter(CommandStack.class);
		globalCommand = new CompositeCommand("Generic Transformation");

		if (graphCopy) {
			if (element != null) {
				EReference[] features = { NotationPackage.eINSTANCE.getView_Element() };
				Collection<?> views = EMFCoreUtil.getReferencers(element, features);
				for (Object view : views) {
					if (view instanceof View) {
						referencingViews.add((View) view);
					}
				}
			}
		}
		if (stack != null) {
			// maybe extension point for stereotypes
			EObject model = (EObject) AdapterFactoryEditingDomain.unwrap(element);
			// get mixed editing domain to do transaction
			TransactionalEditingDomain domain = (TransactionalEditingDomain) EMFHelper.resolveEditingDomain(model);
			commandModel = new EObjectInheritanceCopyCommand(model, eclass, domain);
			globalCommand.add(commandModel);
			if (graphCopy) {
				importerCommand = new ImporterCommand(domain);
				if (importerCommand.canExecute()) {
					globalCommand.add(importerCommand);
				}

			}
			if (globalCommand.canExecute()) {
				try {
					// drop caches about input element
					ECrossReferenceAdapter cross = ECrossReferenceAdapter.getCrossReferenceAdapter(element);
					if (cross != null) {
						cross.unsetTarget(element);
					}
					stack.execute(new ICommandProxy(globalCommand));
				} catch (Exception e) {
					MessageDialog.openWarning(Display.getDefault().getActiveShell(), WARNING_TITLE, WARNING_MSG);
					e.printStackTrace();
				}
			} else {
				MessageDialog.openWarning(Display.getDefault().getActiveShell(), WARNING_TITLE, WARNING_MSG);
			}
		}
	}

	/**
	 * The Class ImporterCommand. permits to add the importer in the compound
	 * command
	 */
	private class ImporterCommand extends AbstractTransactionalCommand {

		/**
		 * Constructor.
		 *
		 * @param domain
		 *            transactional editing domain
		 */
		public ImporterCommand(TransactionalEditingDomain domain) {
			super(domain, "Import graphical nodes", null);
		}

		/**
		 * Execute the command
		 *
		 * @param monitor
		 *            progress monitor
		 * @param info
		 *            the info
		 * @return the command result
		 * @throws ExecutionException
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			graphCopy(null, commandModel.getResultEobject());
			return CommandResult.newOKCommandResult();
		}

		/**
		 * Graph copy, make a drag and drop of the new object on all diagrams
		 *
		 * @param diagramDomain
		 *            the mixed domain
		 * @param target
		 *            the target
		 * @param globalCommand2
		 * @param graphElement
		 *            the graph element
		 * @param oldLocation
		 *            the old location
		 * @param editpart
		 *            the editpart
		 */
		private void graphCopy(IDiagramEditDomain domain, EObject target) {
			for (View graphElement : referencingViews) {
				View parent = ViewUtil.getContainerView(graphElement);
				if (parent == null || graphElement.getDiagram() == null) {
					// this is an orphaned view. Skip it
					continue;
				}
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				// Get the edit part of the diagram containing the view.
				DiagramEditPart diagramEditPart = null;
				IEditorPart activeEditorPart = page.getActiveEditor();
				if (activeEditorPart instanceof IDiagramWorkbenchPart) {
					if (graphElement.getDiagram().equals(((IDiagramWorkbenchPart) activeEditorPart).getDiagram())) {
						diagramEditPart = ((IDiagramWorkbenchPart) activeEditorPart).getDiagramEditPart();
					}
				}
				if (diagramEditPart == null) {
					// search in other editor parts than the active one
					List<?> editorParts = EditorService.getInstance().getRegisteredEditorParts();
					for (Object editorPart : editorParts) {
						if (editorPart instanceof IDiagramWorkbenchPart) {
							if (graphElement.getDiagram().equals(((IDiagramWorkbenchPart) editorPart).getDiagram())) {
								diagramEditPart = ((IDiagramWorkbenchPart) editorPart).getDiagramEditPart();
							}
						}
					}
				}

				if (diagramEditPart != null) {
					EditPart containerPart = (EditPart) diagramEditPart.getViewer().getEditPartRegistry().get(parent);
					// create the new transformed view
					DropObjectsRequest req = new DropObjectsRequest();
					req.setObjects(Collections.singletonList(target));
					if (graphElement instanceof Node) {
						LayoutConstraint constraint = ((Node) graphElement).getLayoutConstraint();
						if (constraint instanceof Location) {
							Location location = (Location) constraint;
							req.setLocation(new Point(location.getX(), location.getY()));
						}
					}
					if (req.getLocation() == null) {
						req.setLocation(new Point());
					}
					Command partCreationCmd = containerPart.getCommand(req);
					partCreationCmd.execute();
					View newView = null;
					if (partCreationCmd instanceof ICommandProxy) {
						CommandResult res = ((ICommandProxy) partCreationCmd).getICommand().getCommandResult();
						Object newValue = res.getReturnValue();
						if (newValue instanceof Collection<?>) {
							for (Object value : (Collection<?>) newValue) {
								if (value instanceof ViewDescriptor) {
									newView = (View) ((ViewDescriptor) value).getAdapter(View.class);
								}
							}
						} else if (newValue instanceof ViewDescriptor) {
							newView = (View) ((ViewDescriptor) newValue).getAdapter(View.class);
						}
					}
					// with ViewRefactorHelper, copy view properties on the old
					// one
					if (newView != null) {
						ViewTransformerHelper helper = new ViewTransformerHelper(diagramEditPart.getDiagramPreferencesHint());
						helper.copyMixedViewFeatures(graphElement, newView);
					}
					// delete the old view
					GroupRequest deleteReq = new GroupRequest(org.eclipse.gef.RequestConstants.REQ_DELETE);
					EditPart oldPart = (EditPart) diagramEditPart.getViewer().getEditPartRegistry().get(graphElement);
					Command partDeletionCmd = oldPart.getCommand(deleteReq);
					partDeletionCmd.execute();
				}
			}

		}

	}

	/**
	 * ViewTransformerHelper allow to refactor a view to copy properties from
	 * another view
	 */
	private static class ViewTransformerHelper extends ViewRefactorHelper {

		/**
		 * Constructor.
		 *
		 * @param preferencesHint
		 *            the diagram preferences hint
		 */
		public ViewTransformerHelper(PreferencesHint preferencesHint) {
			super(preferencesHint);
		}

		/**
		 * Copy common features from a view to another
		 *
		 * @param oldView
		 *            the old view to copy from
		 * @param newView
		 *            the new view to copy to
		 */
		public void copyMixedViewFeatures(View oldView, View newView) {
			if (oldView instanceof Diagram && newView instanceof Diagram) {
				copyDiagramFeatures((Diagram) oldView, (Diagram) newView);
			} else if (oldView instanceof Node && newView instanceof Node) {
				copyNodeFeatures((Node) oldView, (Node) newView);
			} else if (oldView instanceof Edge && newView instanceof Edge) {
				copyEdgeFeatures((Edge) oldView, (Edge) newView);
			} else {
				copyViewFeatures(oldView, newView);
			}
		}

	}

	/**
	 * Gets all the super types.
	 *
	 * @param class1
	 *            the class
	 *
	 * @return super types
	 */
	public static HashSet<EClass> getAllSuperTypes(EClass class1) {
		HashSet<EClass> results = new HashSet<EClass>();
		results.addAll(class1.getEAllSuperTypes());
		return results;
	}

	/**
	 * Gets the factory from uri.
	 *
	 * @param uri
	 *            the uri
	 *
	 * @return the factory
	 */
	public static AdapterFactory getFactory(String uri) {
		AdapterFactory factory = factories.get(uri);
		if (factory == null) {
			IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(EXT_FACTORIES);
			for (IConfigurationElement e : extensions) {
				if (uri.equals(e.getAttribute("uri"))) {
					try {
						factory = (AdapterFactory) e.createExecutableExtension("class");
						if (factory != null) {
							factories.put(uri, factory);
						}
					} catch (CoreException e1) {
						// do nothing
					}
				}
			}
		}
		return factory;
	}

	/**
	 * Checks if a transformation is possible.
	 *
	 * @param eclass
	 *            the eclass
	 *
	 * @return the multi status
	 */
	public MultiStatus isTransformationPossible(EClass eclass) {
		MultiStatus result = new MultiStatus(Activator.PLUGIN_ID, 0, "Type incompatibility", null);
		if (element != null) {
			Collection<Setting> usages = EMFHelper.getUsages(element);
			if (usages != null) {
				for (EStructuralFeature.Setting nonNavigableInverseReference : usages) {
					EStructuralFeature structuralFeature = nonNavigableInverseReference.getEStructuralFeature();
					if (!(nonNavigableInverseReference.getEObject() instanceof View)) {
						boolean compatible = EObjectInheritanceCopyCommand.isCompatible(structuralFeature.getEType(), eclass);
						if (!compatible) {
							String econtainer = structuralFeature.eContainer() instanceof EClassifier ? ((EClassifier) structuralFeature.eContainer()).getName() + " ( " + nonNavigableInverseReference.getEObject().toString() + " )" : structuralFeature
									.eContainer().toString();
							Status s = new Status(IStatus.WARNING, Activator.PLUGIN_ID, String.format("an element typed %s references your selection, we can not assign instead of your selection an object typed %s", econtainer, eclass.getName()));
							result.add(s);
						}
					}
				}
			}
		}
		return result;
	}

}
