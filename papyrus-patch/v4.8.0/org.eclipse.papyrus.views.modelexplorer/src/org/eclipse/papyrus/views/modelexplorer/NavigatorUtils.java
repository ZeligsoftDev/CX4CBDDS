/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Jerome Benois (OBEO) - Initial API and implementation
 *  Francisco Javier Cano (PRODEVELOP)
 *  Thomas Szadel (ATOS) - Remove Backbone dependency
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Utility method for Model Navigator.
 *
 * @author Jerome Benois
 */
public class NavigatorUtils {

	/**
	 * Gets the roots of the notations resources related to the given object
	 *
	 * @param element
	 *            The object from which to retrieve the notation resources
	 * @return An iterator of notation resources' roots, or <code>null</code> if none cannot be resolved
	 * 
	 * @deprecated Use the {@link NotationUtils#getAllNotations(org.eclipse.papyrus.infra.core.resource.ModelSet)} API, instead.
	 */
	@Deprecated
	public static Iterator<EObject> getNotationRoots(EObject element) {
		Iterator<Resource> notations = getResources(element, NotationModel.NOTATION_FILE_EXTENSION);
		if (notations == null) {
			return null;
		}
		return new RootsIterator(notations);
	}

	public static Iterator<EObject> getDiRoots(EObject element) {
		Iterator<Resource> diResources = getResources(element, DiModel.DI_FILE_EXTENSION);
		if (diResources == null) {
			return null;
		}
		return new RootsIterator(diResources);
	}

	/**
	 * Represents an iterator on all the roots of a set of resources of a ResourceSet
	 *
	 * @author Laurent Wouters
	 */
	private static class RootsIterator implements Iterator<EObject> {

		private Iterator<Resource> resources;

		private Iterator<EObject> inner;

		public RootsIterator(Iterator<Resource> resources) {
			this.resources = resources;
			if (resources.hasNext()) {
				inner = resources.next().getContents().iterator();
			}
		}

		@Override
		public boolean hasNext() {
			if (inner == null) {
				return false;
			}

			if (inner.hasNext()) {
				return true;
			}

			while (resources.hasNext()) {
				inner = resources.next().getContents().iterator();
				if (inner.hasNext()) {
					return true;
				}
			}

			inner = null;
			return false;
		}

		@Override
		public EObject next() {
			if (inner == null) {
				return null;
			}

			if (inner.hasNext()) {
				return inner.next();
			}

			while (resources.hasNext()) {
				inner = resources.next().getContents().iterator();
				if (inner.hasNext()) {
					return inner.next();
				}
			}

			inner = null;
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	/**
	 * Gets the notation resources related to the given object
	 *
	 * @param element
	 *            The object from which to retrieve the notation resources
	 * @return An iterator of notation resources, or <code>null</code> if none cannot be resolved
	 */
	public static Iterator<Resource> getResources(EObject element, String fileExtension) {
		Iterator<Resource> result = tryGetResources(element, fileExtension);
		if (result != null) {
			return result;
		}

		IAdaptable input = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getInput();
		if (input != null) {
			EObject obj = EMFHelper.getEObject(input);
			return tryGetResources(obj, fileExtension);
		}
		return null;
	}



	/**
	 * Tries to get the notation resources related to the given object
	 *
	 * @param element
	 *            The object from which to retrieve the notation resources
	 * @return An iterator of notation resources, or <code>null</code> if none cannot be resolved
	 */
	private static Iterator<Resource> tryGetResources(EObject element, String fileExtension) {
		if (element == null) {
			return null;
		}
		if (element.eResource() == null) {
			return null;
		}
		if (element.eResource().getResourceSet() == null) {
			return null;
		}
		return new ResourcesIterator(element.eResource().getResourceSet(), fileExtension);
	}

	/**
	 * Represents an iterator over the notation resources of a ResourceSet
	 *
	 * @author Laurent Wouters
	 */
	private static class ResourcesIterator implements Iterator<Resource> {

		private Iterator<Resource> inner;

		private Resource next;

		private String fileExtension;

		public ResourcesIterator(ResourceSet set, String fileExtension) {
			inner = set.getResources().iterator();
			this.fileExtension = fileExtension;
			next = getNextResource();
		}

		private Resource getNextResource() {
			while (inner.hasNext()) {
				Resource resource = inner.next();

				if (fileExtension.equalsIgnoreCase(resource.getURI().fileExtension())) {
					return resource;
				}

			}
			return null;
		}

		@Override
		public boolean hasNext() {
			return (next != null);
		}

		@Override
		public Resource next() {
			Resource result = next;
			next = getNextResource();
			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	/**
	 * Find a <IViewPart> by it's id string.
	 *
	 * @param viewID
	 *            the view id
	 *
	 * @return the i view part
	 */
	public static IViewPart findViewPart(final String viewID) {
		RunnableWithResult<IViewPart> runnable;
		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<IViewPart>() {

			@Override
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				if (page == null) {
					setResult(null);
					return;
				}
				IViewReference reference = page.findViewReference(viewID);
				if (reference == null) {
					setResult(null);
					return;
				}
				IWorkbenchPart part = reference.getPart(false);
				if (part instanceof IViewPart) {
					setResult((IViewPart) part);
					return;
				} else {
					setResult(null);
					return;
				}
			}
		});

		return runnable.getResult();
	}

	/**
	 * Unwraps selection. Gets <EObject>s from <EditPart>s, from <View>s or from
	 * <EObject>s
	 *
	 * @param selection
	 *            the selection
	 *
	 * @return the i selection
	 */
	public static ISelection unwrapSelection(ISelection selection) {
		if (selection instanceof StructuredSelection && !selection.isEmpty()) {
			List<EObject> selectionList = new ArrayList<EObject>();
			StructuredSelection structuredSelection = (StructuredSelection) selection;
			for (Iterator<?> iterator = structuredSelection.iterator(); iterator.hasNext();) {
				Object next = iterator.next();
				if (next instanceof EditPart) {
					Object model = ((EditPart) next).getModel();
					EObject element = null;
					if (model instanceof View) {
						element = ((View) model).getElement();
					} else if (model instanceof EObject) {
						element = (EObject) model;
					}
					if (element != null) {
						selectionList.add(element);
					}
				} else if (next instanceof View) {
					EObject element = ((View) next).getElement();
					if (element != null) {
						selectionList.add(element);
					}
				}
				EObject eObject = EMFHelper.getEObject(next);
				if (eObject != null) {
					selectionList.add(eObject);
				}
			}
			return new StructuredSelection(selectionList);
		} else {
			return selection;
		}
	}

	/**
	 * Finds the <EditPart>s for the <EObject>s in the selection.
	 *
	 * @param selection
	 *            the selection
	 * @param viewer
	 *            the viewer
	 *
	 * @return the edits the parts from selection
	 */
	public static List<EditPart> getEditPartsFromSelection(ISelection selection, IDiagramGraphicalViewer viewer) {
		if (selection instanceof StructuredSelection && !selection.isEmpty()) {
			StructuredSelection structuredSelection = (StructuredSelection) selection;
			// look for Views of the EObjects in the selection
			List<View> views = new ArrayList<View>();
			for (Object o : structuredSelection.toList()) {
				if (o instanceof EObject) {
					List<Object> referencerViews = getEObjectViews((EObject) o);
					for (Object ro : referencerViews) {
						if (ro instanceof View) {
							views.add((View) ro);
						}
					}
				}
			}
			if (!views.isEmpty()) {
				List<EditPart> editParts = new ArrayList<EditPart>();
				for (View view : views) {
					Object ep = viewer.getEditPartRegistry().get(view);
					if (ep instanceof EditPart) {
						editParts.add((EditPart) ep);
					}
				}
				if (!editParts.isEmpty()) {
					return editParts;
				}
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Gets the given <EObject> views.
	 *
	 * @param element
	 *            the element
	 *
	 * @return the e object views
	 */
	// @unused
	public static List<Object> getEObjectViews(EObject element) {
		List<Object> views = new ArrayList<Object>();
		if (element != null) {
			EReference[] features = { NotationPackage.eINSTANCE.getView_Element() };
			Collection<?> referencers = EMFCoreUtil.getReferencers(element, features);
			views.addAll(referencers);
		}
		return views;
	}

	// // //
	// // get an object name
	// // //
	//
	// /**
	// * Gets the object name or empty string.
	// *
	// * @param object
	// * the object
	// *
	// * @return the object name or empty string
	// */
	// // @unused
	// public static String getObjectNameOrEmptyString(Object object) {
	// String name = getObjectName(object);
	// return name == null ? "" : name;
	// }
	//
	// /** The Constant getNameNames. */
	// private static final String[] getNameNames = { "getName", "getname" };
	//
	// /**
	// * Gets the object name.
	// *
	// * @param object
	// * the object
	// *
	// * @return the object name
	// */
	// // @unused
	// public static String getObjectName(Object object) {
	// if (object == null) {
	// return null;
	// }
	// Method method = null;
	// Object o = null;
	// for (String methodName : getNameNames) {
	// try {
	// method = object.getClass()
	// .getMethod(methodName, (Class[]) null);
	// } catch (NoSuchMethodException e) {
	// method = null;
	// }
	// if (method != null) {
	// break;
	// }
	// }
	// if (method != null) {
	// try {
	// o = method.invoke(object, (Object[]) null);
	// } catch (IllegalAccessException ex) {
	// return null;
	// } catch (InvocationTargetException ex) {
	// return null;
	// }
	// if (o instanceof String) {
	// return (String) o;
	// }
	// }
	// return null;
	// }


	/**
	 * Opens a view part in the workbench with the specified ID.
	 *
	 * @param viewPartID
	 */
	// @unused
	public static void openViewPart(String viewPartID) {
		if (viewPartID == null) {
			return;
		}
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(viewPartID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens the property sheets view.
	 */
	public static void openPropertySheetsView() {
		openViewPart("org.eclipse.ui.views.PropertySheet");
	}

	/**
	 * Use the IAdaptable mechanism
	 *
	 * @param o
	 * @param theClass
	 * @return
	 *
	 * @deprecated This method doesn't work with EMF Facet >= 0.2, for retrieving EObjects.
	 *             Use {@link EMFHelper#getEObject(Object)} instead
	 *             Note: If used for anything else than EObject.class, the method is still OK.
	 *             But it seems that it was its only usage
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	public static <T> T getElement(Object o, Class<T> theClass) {
		T result = null;
		if (o instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) o;
			result = adaptable.getAdapter(theClass);
		}
		if (result == null) {
			result = Platform.getAdapterManager().getAdapter(o, theClass);
		}
		if (result == null && theClass.isInstance(o)) {
			result = (T) o;
		}
		return result;
	}

	/**
	 * Tests whether at least one elements matches the given Predicate in the resource set
	 * This doesn't rely on the CrossReferencer. Instead, it will browse all the objects of the given Type
	 * in the ResourceSet.
	 *
	 * If "search all contents" is false, it will restrict the search to root elements
	 * of the same EPackage as the researched Type.
	 *
	 * For example, if we're looking for GMF Diagrams (type == Diagram), we will only look for root elements
	 * from the Notation metamodel (Excluding the underlying semantic model.
	 *
	 * @param referencedElement
	 *            The referenced element
	 * @param type
	 *            The type of the element which may contain references to the "referencedElement"
	 * @param searchAllContents
	 *            If false, the research will be restricted to the root elements of the same EPackage as "type"
	 * @param predicate
	 *            The predicate used to determine whether an object of type "type" has a reference to the "referencedElement"
	 *
	 *
	 * @return
	 * 		True if at least one object matches the predicate and targets the referencedElement
	 */
	public static boolean any(EObject referencedElement, final EClass type, final boolean searchAllContents, Predicate<EObject> predicate) {
		if (referencedElement == null || referencedElement.eResource() == null || referencedElement.eResource().getResourceSet() == null) {
			return false;
		}

		ResourceSet resourceSet = referencedElement.eResource().getResourceSet();

		Predicate<EObject> composedPredicate = Predicates.and(new Predicate<EObject>() {

			@Override
			public boolean apply(EObject arg0) {
				return type.isSuperTypeOf(arg0.eClass());
			}
		}, predicate);

		for (final Resource resource : resourceSet.getResources()) {

			Iterable<EObject> iterable = new Iterable<EObject>() {

				@Override
				public Iterator<EObject> iterator() {
					Iterator<EObject> allContentsIterator;

					if (searchAllContents) {
						allContentsIterator = resource.getAllContents();
					} else {
						Collection<EObject> contentsToBrowse = new LinkedList<EObject>();

						for (EObject rootElement : resource.getContents()) {
							if (rootElement.eClass().getEPackage() == type.getEPackage()) {
								contentsToBrowse.add(rootElement);
							}
						}

						allContentsIterator = EcoreUtil.getAllProperContents(contentsToBrowse, false);
					}

					return allContentsIterator;
				}
			};

			if (Iterables.any(iterable, composedPredicate)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Search all the elements referencing the context,
	 * filter the results by the predicate
	 *
	 * @return
	 */
	// @unused for efficiency issues
	public static boolean find(EObject toFind, Predicate<Setting> predicate) {
		if (toFind == null || toFind.eResource() == null || toFind.eResource().getResourceSet() == null) {
			return false;
		}
		ResourceSet resourceSet = toFind.eResource().getResourceSet();
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if (adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}
		Collection<Setting> settings = adapter.getInverseReferences(toFind, false);
		return Iterables.any(settings, predicate);
	}

	/**
	 * Search all the elements referencing the context,
	 * filter the results by the predicate and apply the function to return the desired types
	 *
	 * @return
	 */
	public static <T> Collection<T> findFilterAndApply(EObject toFind, Predicate<Setting> predicate, Function<Setting, T> function) {
		if (toFind == null || toFind.eResource() == null || toFind.eResource().getResourceSet() == null) {
			return Collections.emptyList();
		}
		ResourceSet resourceSet = toFind.eResource().getResourceSet();
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if (adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}
		Collection<Setting> settings = adapter.getInverseReferences(toFind, false);
		return Lists.newLinkedList(Iterables.transform(Iterables.filter(settings, predicate), function));
	}
}
