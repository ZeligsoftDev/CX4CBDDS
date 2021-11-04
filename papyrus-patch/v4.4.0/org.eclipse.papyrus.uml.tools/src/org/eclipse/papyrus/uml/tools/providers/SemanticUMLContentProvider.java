/*****************************************************************************
 * Copyright (c) 2012, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 410346
 *  Christian W. Damus - bugs 451338, 496299
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.adapters.ResourceSetRootsAdapter;
import org.eclipse.papyrus.infra.tools.util.PlatformHelper;
import org.eclipse.papyrus.infra.ui.emf.providers.strategy.SemanticEMFContentProvider;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * A semantic Hierarchic Content Provider for UML
 *
 * @author Camille Letavernier
 */
public class SemanticUMLContentProvider extends SemanticEMFContentProvider {


	public SemanticUMLContentProvider() {
		// Empty (@see #inputChanged(Viewer, Object, Object))
	}

	public SemanticUMLContentProvider(EObject editedEObject, EStructuralFeature feature, EObject[] roots) {
		super(editedEObject, feature, roots);
	}

	public SemanticUMLContentProvider(EObject editedEObject, EStructuralFeature feature) {
		this(editedEObject, feature, findRoots(editedEObject));
	}

	public SemanticUMLContentProvider(EObject[] roots) {
		super(roots);
	}

	public SemanticUMLContentProvider(ResourceSet root) {
		this(null, null, root);
	}

	public SemanticUMLContentProvider(EObject editedEObject, EStructuralFeature feature, ResourceSet root) {
		this(editedEObject, feature, getRoots(root));
		this.root = root;
	}

	protected static EObject[] findRoots(EObject source) {
		if (source.eResource() == null || source.eResource().getResourceSet() == null) {
			return SemanticEMFContentProvider.findRoots(source);
		}

		// We have a full resourceSet : we return its contents
		return getRoots(source.eResource().getResourceSet());
	}

	protected static EObject[] getRoots(ResourceSet root) {
		if (root == null) {
			return new EObject[0];
		}

		EObject rootElement = null;

		if (root instanceof ModelSet) {
			ModelSet modelSet = (ModelSet) root;
			UmlModel umlModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
			if (umlModel != null) {
				try {
					rootElement = umlModel.lookupRoot();
				} catch (NotFoundException ex) {
					// Ignore and treat the ModelSet as a standard resource set
				}
			}
		} else { // Standard resource set, used e.g. in a Papyrus generic Tree Editor
			for (Resource resource : root.getResources()) {
				if ("uml".equals(resource.getURI().fileExtension()) && !resource.getContents().isEmpty()) {
					rootElement = resource.getContents().get(0);
					break;
				}
			}
		}

		List<EObject> rootElements = new LinkedList<EObject>();
		for (Resource resource : root.getResources()) {
			if (isUMLModel(resource, rootElement)) {
				for (EObject rootEObject : resource.getContents()) {
					if (rootEObject instanceof Element) {
						rootElements.add(rootEObject);
					}
				}
			}
		}
		return rootElements.toArray(new EObject[0]);
	}

	// protected static URI[] excludedModels = new URI[0];

	// TODO: Currently, some resources are explicitly excluded.
	// We need more use cases and user feedback to determine how we should filter them
	protected static URI[] excludedModels = new URI[] {
			// URI.createURI(UMLResource.STANDARD_L2_PROFILE_URI),
			// URI.createURI(UMLResource.STANDARD_L3_PROFILE_URI),
			URI.createURI(UMLResource.UML_METAMODEL_URI), URI.createURI(UMLResource.ECORE_METAMODEL_URI)
			// URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI)
	};

	protected static boolean isUMLModel(Resource resource, EObject rootElement) {
		if (!isUMLResource(resource)) {
			return false;
		}

		for (URI uri : excludedModels) {
			if (uri.equals(resource.getURI())) {
				return false;
			}
		}

		for (EObject rootObject : resource.getContents()) {
			if (rootObject.eIsProxy()) {
				continue;
			}

			if (rootObject.eContainer() != null) { // Controlled element
				return false;
			}

			if (rootObject instanceof Profile && !(rootElement instanceof Profile)) {
				return false;
			}
		}

		return true;
	}

	protected static boolean isUMLResource(Resource resource) {
		if (resource == null) {
			return false;
		}

		if (resource instanceof UMLResource) {
			return true;
		}

		URI uri = resource.getURI();
		return (uri != null && UMLResource.FILE_EXTENSION.equals(uri.fileExtension()));
	}

	@Override
	protected boolean isCompatibleMetaclass(Object containerElement, Object metaclass) {
		Element semanticElement = UMLUtil.resolveUMLElement(containerElement);

		if (semanticElement == null) {
			return false;
		}

		if (metaclass instanceof Stereotype) {
			Stereotype stereotype = (Stereotype) metaclass;
			boolean res = semanticElement.getAppliedStereotype(stereotype.getQualifiedName()) != null;
			if (!res) {
				EClass definition = stereotype.getDefinition();
				for (EObject e : semanticElement.getStereotypeApplications()) {
					EClass c = e.eClass();
					if (definition != null && definition.isSuperTypeOf(c)) {
						res = true;
						break;
					}
				}
			}
			return res;
		} else if (metaclass instanceof EClass) {
			EClass metaEClass = (EClass) metaclass;
			for (EObject stereotypeApplication : semanticElement.getStereotypeApplications()) {
				if (metaEClass.isSuperTypeOf(stereotypeApplication.eClass())) {
					return true;
				}
			}
		}

		// TODO : We should use super.isCompatibleMetaclass(), but the super-implementation
		// may not be compatible with our implementation of getAdaptedValue()
		if (metaclass instanceof EClassifier) {
			return ((EClassifier) metaclass).isInstance(semanticElement);
		}

		return false;
	}

	/**
	 * This method should return either the StereotypeApplication (For Sto - Sto associations),
	 * or the UML Element (For Sto - UML associations)
	 *
	 * This depends on the wanted metaclass.
	 */
	// TODO : In some cases, we may have a filter based on both a UML Metaclass and a Stereotype
	// In such a specific case, a specific implementation is probably needed
	//
	// This case may especially occur in the case of dynamic creation of stereotype associations.
	@Override
	public Object getAdaptedValue(Object containerElement) {
		Object semanticElement = super.getAdaptedValue(containerElement);

		if (semanticElement instanceof Element) {
			Element element = (Element) semanticElement;
			// Looks for a compatible Stereotype application
			for (Object metaclassWanted : getWantedMetaclasses()) {

				if (metaclassWanted instanceof Stereotype) {
					EObject stereotypeApplication = null;

					stereotypeApplication = element.getStereotypeApplication((Stereotype) metaclassWanted);
					if (stereotypeApplication == null) {
						List<Stereotype> subStereotypes = element.getAppliedSubstereotypes((Stereotype) metaclassWanted);
						for (Stereotype subSteretoype : subStereotypes) {
							stereotypeApplication = element.getStereotypeApplication(subSteretoype);
							if (stereotypeApplication != null) {
								break;
							}
						}
					}

					if (stereotypeApplication != null) {
						return stereotypeApplication;
					}
				} else if (metaclassWanted instanceof EClass) {
					// new check based on EClass (stereotype definition)
					EClass metaEClassWanted = (EClass) metaclassWanted;
					for (EObject stereotypeApplication : element.getStereotypeApplications()) {
						if (metaEClassWanted.isSuperTypeOf(stereotypeApplication.eClass())) {
							return stereotypeApplication;
						}
					}
				}
			}
		}

		// If no stereotype application is found, return the UML Element
		return semanticElement;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		ResourceSet resourceSet = root;

		if (newInput instanceof ResourceSet) {
			resourceSet = (ResourceSet) newInput;
		} else if (newInput instanceof ServicesRegistry) {
			try {
				resourceSet = ServiceUtils.getInstance().getModelSet((ServicesRegistry) newInput);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		if (newInput == null) {
			rootsAdapter.detach(root);
		} else {
			listenOnResourceSet(resourceSet);
		}

		this.viewer = viewer;

		super.inputChanged(viewer, oldInput, newInput);
	}

	protected void listenOnResourceSet(ResourceSet resourceSet) {
		if (root != null) {
			rootsAdapter.detach(root);
			root = null;
			roots = null;
		}

		if (resourceSet != null) {
			rootsAdapter.attach(resourceSet);
			this.root = resourceSet;
			this.roots = getRoots(root);
		}
	}

	@Override
	public void dispose() {
		if (root != null) {
			rootsAdapter.detach(root);
		}
		root = null;
		roots = null;
		viewer = null;
		super.dispose();
	}

	private ResourceSet root;

	private Viewer viewer;

	private class RootsAdapter {

		private final AtomicReference<Runnable> pendingRefresh = new AtomicReference<>();

		private Object listener;

		void attach(ResourceSet resourceSet) {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(resourceSet);
			if (domain != null) {
				ResourceSetListener rsl = new ResourceSetRootsAdapter.Transactional() {
					@Override
					protected void handleResourceSetChangeEvent(ResourceSetChangeEvent event) {
						triggerRefresh();
					}
				};
				domain.addResourceSetListener(rsl);
				listener = rsl;
			} else {
				ResourceSetRootsAdapter adapter = new ResourceSetRootsAdapter() {
					@Override
					protected void doNotify(Notification msg) {
						if (root == null || msg.isTouch()) {
							return;
						}

						switch (msg.getEventType()) {
						case Notification.ADD:
						case Notification.ADD_MANY:
						case Notification.REMOVE:
						case Notification.REMOVE_MANY:
							triggerRefresh();
						}
					}
				};
				adapter.setTarget(resourceSet);
				listener = adapter;
			}
		}

		void detach(ResourceSet resourceSet) {
			if (listener instanceof ResourceSetRootsAdapter.Transactional) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(resourceSet);
				if (domain != null) {
					domain.removeResourceSetListener((ResourceSetListener) listener);
					listener = null;
				}
			} else if (listener instanceof ResourceSetRootsAdapter) {
				((ResourceSetRootsAdapter) listener).unsetTarget(resourceSet);
				listener = null;
			}
		}

		private synchronized void triggerRefresh() {
			roots = getRoots(root);

			// During display, a resource has been loaded (e.g. by a Label provider).
			// Schedule an update (in the future, to avoid conflicts with a potential current update)
			
			// do not trigger a refresh if the widget is activated (in edit mode) Bug 509653
			if ((viewer != null) && (viewer.getControl() != null) && !viewer.getControl().isDisposed() && !viewer.getControl().isFocusControl()) {
				if (pendingRefresh.compareAndSet(null, new Runnable() {

					@Override
					public void run() {
						if (!pendingRefresh.compareAndSet(this, null)
								|| (viewer == null) || (viewer.getControl() == null)
								|| viewer.getControl().isDisposed()) {
							return;
						}

						// Because containment proxy resolution that sets a root's
						// eContainer is not detected by the adapter, so recompute
						// again, now
						roots = getRoots(root);

						viewer.refresh();
					};
				})) {
					viewer.getControl().getDisplay().asyncExec(pendingRefresh.get());
				}
			}
		}
	}

	private RootsAdapter rootsAdapter = new RootsAdapter();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.providers.strategy.SemanticEMFContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(final Object element) {

		// In case of use of EReference visualisation by face through EReferenceTreeElement, we verify if the object is realy a child of its parent
		// This is done to avoid infinite loop.
		Object parent = getParent(element);
		if (parent instanceof EReferenceTreeElement) {
			EObject eParent = PlatformHelper.getAdapter(parent, EObject.class);
			// The element must be contained into the parent
			if (!eParent.eContents().contains(PlatformHelper.getAdapter(element, EObject.class))) {
				return false;
			}
		}

		return super.hasChildren(element);
	}

}
