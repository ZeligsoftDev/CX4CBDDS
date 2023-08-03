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
package org.eclipse.papyrus.views.modelexplorer.actionprovider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.converter.util.ConverterUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.modelexplorer.actions.GenericTransformAction;
import org.eclipse.papyrus.views.modelexplorer.actions.GenericTransformer;

/**
 * GenericTransformActionProvider class provides GenericTransformAction actions
 * available for a given element.
 */
public class GenericTransformActionProvider extends
		AbstractSubmenuActionProvider {

	/** Group label */
	private static final String TRANSFORM_INTO_LABEL = "Transform into";

	/** The factories of appropriate EClass */
	private Map<String, AdapterFactory> factories = new HashMap<String, AdapterFactory>();

	/** The appropriate EClass for element's transformation */
	private Set<EClassifier> eClassifiers = new HashSet<EClassifier>();

	/**
	 * Adds all actions to transform an EObject
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		ISelection selection = getContext().getSelection();
		if (selection instanceof IStructuredSelection
				&& ((IStructuredSelection) selection).size() == 1) {
			Object selectedElement = resolveSemanticObject(((IStructuredSelection) selection)
					.getFirstElement());
			if (selectedElement != null && selectedElement instanceof EObject) {
				fillEClassifiers((EObject) selectedElement);
			}
		}

		Collection<IAction> genericTransformActions = generateTransformActions(selection);
		MenuManager submenuManager = new MenuManager(TRANSFORM_INTO_LABEL);
		populateManager(submenuManager, genericTransformActions, null);
		menu.add(submenuManager);
	}

	/**
	 * From an EObject we get the epackage corresponding to the resource
	 * extension of the file and get the imported epackage correspondant
	 *
	 * @param selectionEObject
	 */
	private void fillEClassifiers(EObject selectionEObject) {
		Resource r = selectionEObject.eResource();
		URI uri = r.getURI();
		String extension = uri.fileExtension();
		for (Object p : EPackage.Registry.INSTANCE.values()) {
			if (p instanceof EPackage) {
				EPackage pack = (EPackage) p;
				if (pack.getNsPrefix() != null
						&& extension.toLowerCase().equals(
								pack.getNsPrefix().toLowerCase())) {
					addClassifiers(pack, eClassifiers);
					factories.put(pack.getNsURI(), GenericTransformer
							.getFactory(pack.getNsURI()));
					List<EPackage> packages = ConverterUtil
							.computeRequiredPackages(pack);
					for (EPackage pTmp : packages) {
						addClassifiers(pTmp, eClassifiers);
						factories.put(pTmp.getNsURI(), GenericTransformer
								.getFactory(pTmp.getNsURI()));
					}
					break;
				}
			}
		}

	}

	/**
	 * Register all classifiers contained in the package
	 *
	 * @param pack
	 *            the package
	 * @param result
	 *            results at which classifiers must be added
	 */
	private void addClassifiers(EPackage pack, Set<EClassifier> result) {
		for (EClassifier c : pack.getEClassifiers()) {
			result.add(c);
		}
	}

	/**
	 * Generate the sorted list of transformation actions.
	 *
	 * @param descriptors
	 *            the descriptors
	 * @param selection
	 *            the selection
	 *
	 * @return the collection< i action>
	 */
	protected Collection<IAction> generateTransformActions(ISelection selection) {
		List<IAction> transformActions = (List<IAction>) generateTransformActionsCore(selection);

		Collections.<IAction> sort(transformActions, new Comparator<IAction>() {

			public int compare(IAction a1, IAction a2) {
				return a1.getText().compareTo(a2.getText());
			}
		});

		return transformActions;
	}

	/**
	 * Generate transformation actions.
	 *
	 * @param descriptors
	 *            the descriptors
	 * @param selection
	 *            the selection
	 *
	 * @return the collection< i action>
	 */
	protected Collection<IAction> generateTransformActionsCore(
			ISelection selection) {
		Collection<IAction> actions = new ArrayList<IAction>();
		if (eClassifiers != null) {
			for (EClassifier descriptor : eClassifiers) {
				Object selected = ((IStructuredSelection) selection)
						.getFirstElement();
				if (selected instanceof EObject) {
					final EObject selectedElement = (EObject) selected;
					if (descriptor instanceof EClass
							&& selectedElement.eContainingFeature() != null) {
						final EClass eclass = (EClass) descriptor;
						EStructuralFeature containingFeature = selectedElement
								.eContainingFeature();
						// to be candidate an eclass has to have a common
						// parent, to not be the selection
						// and to not be abstract
						EClass containgType = (EClass) containingFeature
								.getEType();
						if ((GenericTransformer.getAllSuperTypes(eclass)
								.contains(containgType) || EcoreUtil.equals(
								eclass, containgType))
								&& !eclass.equals(selectedElement.eClass())
								&& !eclass.isAbstract()) {
							if (selection instanceof IStructuredSelection
									&& ((IStructuredSelection) selection)
											.size() == 1) {

								AdapterFactory adapterFactory = factories
										.get(eclass.getEPackage().getNsURI());
								Action transformAction = new GenericTransformAction(
										eclass, adapterFactory, selectedElement);
								actions.add(transformAction);
								if (adapterFactory != null) {
									EObject tmpEobject = eclass.getEPackage()
											.getEFactoryInstance().create(
													eclass);
									IItemLabelProvider provider = (IItemLabelProvider) adapterFactory
											.adapt(tmpEobject,
													IItemLabelProvider.class);
									transformAction
											.setImageDescriptor(ExtendedImageRegistry.INSTANCE
													.getImageDescriptor(provider
															.getImage(tmpEobject)));
								}
							}
						}
					}
				}
			}
		}
		return actions;
	}

}
