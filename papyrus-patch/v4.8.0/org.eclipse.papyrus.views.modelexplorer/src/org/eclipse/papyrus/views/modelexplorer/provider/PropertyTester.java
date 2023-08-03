/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 408491
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.provider;

import java.util.Iterator;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForSelection;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This class provides test called by the plugin.xml in order to know if handlers should be active or not.
 *
 * Sometimes these test can be done directly in the plugin.xml in the activeWhen (with instanceof, adapt, ...),
 * but in this case, Eclipse doesn't refresh correctly the status of the command in the menu Edit or in other menu.
 *
 *
 *
 */
public class PropertyTester extends org.eclipse.core.expressions.PropertyTester {

	/** property to test if the selected elements is an eObject */
	public static final String IS_EOBJECT = "isEObject"; //$NON-NLS-1$

	/** property to test if the current activePart is the ModelExplorer */
	public static final String IS_MODEL_EXPLORER = "isModelExplorer"; //$NON-NLS-1$

	/** indicate if the element can be open in a tab */
	public static final String IS_PAGE = "isPage";//$NON-NLS-1$

	/** Queries whether the element is an instance of the specified EClass */
	public static final String ECLASS = "eClass";//$NON-NLS-1$

	private static final Pattern QNAME_SEPARATOR = Pattern.compile("\\.|::"); //$NON-NLS-1$

	/**
	 *
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 *
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (IS_EOBJECT.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isObject((IStructuredSelection) receiver);
			return Boolean.valueOf(answer).equals(expectedValue);
		} else if (IS_MODEL_EXPLORER.equals(property) && receiver instanceof IWorkbenchPart) {
			boolean answer = isModelExplorer((IWorkbenchPart) receiver);
			return Boolean.valueOf(answer).equals(expectedValue);
		} else if (IS_PAGE.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isPage((IStructuredSelection) receiver);
			return Boolean.valueOf(answer).equals(expectedValue);
		} else if (ECLASS.equals(property) && (receiver instanceof IStructuredSelection) && (expectedValue instanceof String)) {
			return hasEClass((IStructuredSelection) receiver, (String) expectedValue);
		}
		return false;
	}

	/**
	 *
	 * @param selection
	 *            the current selection
	 * @return
	 *         <code>true</code> if all selected elements are pages
	 */
	private boolean isPage(IStructuredSelection selection) {
		IPageManager pageManager = getPageManager(selection);
		if (pageManager != null) {
			if (!selection.isEmpty()) {
				Iterator<?> iter = selection.iterator();
				while (iter.hasNext()) {
					EObject current = EMFHelper.getEObject(iter.next());
					if (!isPage(current, pageManager)) {
						return false;
					}
				}

				return true;
			}
		}
		return false;
	}

	protected boolean isPage(EObject element, IPageManager pageManager) {
		if (element == null) {
			return false;
		}

		if (pageManager.allPages().contains(element)) {
			return true;
		}

		Object openable = Platform.getAdapterManager().getAdapter(element, IOpenable.class);
		return openable instanceof IOpenable;
	}

	/**
	 * Returns the page manager
	 *
	 * @return
	 * 		the page manager
	 */
	protected IPageManager getPageManager(IStructuredSelection selection) {
		IPageManager pageMngr = null;
		try {
			ServiceUtilsForSelection instance = ServiceUtilsForSelection.getInstance();
			if (instance != null) {
				pageMngr = instance.getService(IPageManager.class, selection);
			}
		} catch (NullPointerException npe) {
			// We cannot find the page manager. Just return null.
		} catch (ServiceException e) {
			// We cannot find the page manager. Just return null.
		}
		return pageMngr;
	}

	/**
	 * Tests if the current activePart is the Model Explorer
	 *
	 * @param receiver
	 * @return
	 */
	private boolean isModelExplorer(IWorkbenchPart receiver) {
		return receiver instanceof ModelExplorerPageBookView;
	}

	/**
	 * Tests if all elements in the selection are EObject
	 *
	 * @param selection
	 * @return
	 */
	private boolean isObject(IStructuredSelection selection) {
		if (!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while (iter.hasNext()) {
				EObject current = EMFHelper.getEObject(iter.next());
				return current != null;
			}
		}
		return false;
	}

	protected boolean hasEClass(IStructuredSelection selection, String eClassQName) {
		if (!selection.isEmpty()) {
			// Resolve the EClass in the context of the first element. If we can't resolve it
			// in this context, then that element necessarily isn't an instance of that EClass,
			// so not all of the selection is an instance of that class. Thus, it doesn't
			// matter that we choose the first element to resolve the EClass
			EClassifier eClassifier = resolveEClass(EMFHelper.getEObject(selection.getFirstElement()), eClassQName);

			if (eClassifier != null) {
				boolean result = true;
				for (Iterator<?> iter = selection.iterator(); result && iter.hasNext();) {
					EObject next = EMFHelper.getEObject(iter.next());
					result = (next != null) && eClassifier.isInstance(next);
				}

				return result;
			}
		}
		return false;
	}

	protected EClassifier resolveEClass(Object context, String eClassQName) {
		EClassifier result = null;

		if (context instanceof EObject) {
			EClass contextClass = ((EObject) context).eClass();
			String[] segments = QNAME_SEPARATOR.split(eClassQName);
			if (segments.length > 1) { // must have at least epackage and eclass names
				String basePackageName = segments[0];
				EPackage basePackage = resolvePackage(contextClass, basePackageName);
				if (basePackage != null) {
					EPackage ePackage = basePackage;
					int lastPackage = segments.length - 1;
					for (int i = 1; (ePackage != null) && (i < lastPackage); i++) {
						ePackage = getSubPackage(ePackage, segments[i]);
					}
					if (ePackage != null) {
						result = ePackage.getEClassifier(segments[segments.length - 1]);
					}
				}
			}
		}

		return result;
	}

	static EPackage resolvePackage(EClass contextEClass, String name) {
		EPackage result = null;

		if (name.equals(contextEClass.getEPackage().getName())) {
			// the easy case
			result = contextEClass.getEPackage();
		} else {
			// search the superclass hierarchy for a matching package
			for (EClass next : contextEClass.getEAllSuperTypes()) {
				if (name.equals(next.getEPackage().getName())) {
					result = next.getEPackage();
					break;
				}
			}
		}

		return result;
	}

	static EPackage getSubPackage(EPackage superPackage, String name) {
		EPackage result = null;

		for (EPackage next : superPackage.getESubpackages()) {
			if (name.equals(next.getName())) {
				result = next;
				break;
			}
		}

		return result;
	}

}
