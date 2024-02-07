/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.provider;

import java.util.ResourceBundle;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.provider.TreeContentMergeViewerItemLabelProvider;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.compare.diagram.ide.ui.internal.CompareDiagramIDEUIPapyrusPlugin;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The label provider for the {@link PyprusTreeContentMergeViewer}.
 * 
 * @author Stefan Dirix
 */
@SuppressWarnings("restriction")
public class PapyrusTreeContentMergeViewerItemLabelProvider extends TreeContentMergeViewerItemLabelProvider {
	/**
	 * The {@link MergeViewerSide}.
	 */
	private MergeViewerSide side;

	/**
	 * Constructor.
	 * 
	 * @param resourceBundle
	 *            the {@link ResourceBundle}.
	 * @param adapterFactory
	 *            the {@link AdapterFactory}.
	 * @param side
	 *            the {@link MergeViewerSide}.
	 */
	public PapyrusTreeContentMergeViewerItemLabelProvider(ResourceBundle resourceBundle,
			AdapterFactory adapterFactory, MergeViewerSide side) {
		super(resourceBundle, adapterFactory, side);
		this.side = side;
	}

	@Override
	public Image getImage(Object object) {
		if (!IMergeViewerItem.class.isInstance(object)) {
			return super.getImage(object);
		}

		final Image image;
		final IMergeViewerItem mergeViewerItem = IMergeViewerItem.class.cast(object);

		// For all special cases fall back to parent to keep consistency
		if (mergeViewerItem.isInsertionPoint()) {
			image = super.getImage(object);
		} else if (mergeViewerItem.getSideValue(side) == null
				&& mergeViewerItem.getSideValue(side.opposite()) instanceof Resource) {
			image = super.getImage(mergeViewerItem.getSideValue(side.opposite()));
		} else if (mergeViewerItem.getLeft() == null && mergeViewerItem.getRight() == null
				&& mergeViewerItem.getAncestor() instanceof Resource) {
			image = super.getImage(mergeViewerItem.getAncestor());
		} else {
			final Object value = mergeViewerItem.getSideValue(side);
			if (hasModelExplorerLabel(value)) {
				final LabelProviderService labelProviderService = CompareDiagramIDEUIPapyrusPlugin
						.getDefault().getLabelProviderService();
				if (value instanceof EObject) {
					EObjectTreeElement treeElement = TreeproxyFactory.eINSTANCE.createEObjectTreeElement();
					treeElement.setEObject(EObject.class.cast(value));
					image = labelProviderService.getLabelProvider().getImage(treeElement);
				} else {
					image = labelProviderService.getLabelProvider().getImage(value);
				}
			} else {
				image = super.getImage(object);
			}
		}
		return image;
	}

	@Override
	public String getText(Object object) {
		if (!IMergeViewerItem.class.isInstance(object)) {
			return super.getText(object);
		}

		final String text;
		final IMergeViewerItem mergeViewerItem = (IMergeViewerItem)object;
		final Object value = mergeViewerItem.getSideValue(side);

		// For all special cases fall back to parent to keep consistency
		if (value instanceof EObject && ((EObject)value).eIsProxy()) {
			text = super.getText(object);
		} else if (mergeViewerItem.isInsertionPoint()) {
			text = super.getText(object);
		} else if (value == null && mergeViewerItem.getSideValue(side.opposite()) instanceof Resource) {
			text = super.getText(object);
		} else if (value == null && mergeViewerItem.getLeft() == null && mergeViewerItem.getRight() == null
				&& mergeViewerItem.getAncestor() instanceof Resource) {
			text = super.getText(object);
		} else {
			if (hasModelExplorerLabel(value)) {
				final LabelProviderService labelProviderService = CompareDiagramIDEUIPapyrusPlugin
						.getDefault().getLabelProviderService();
				if (value instanceof EObject) {
					EObjectTreeElement treeElement = TreeproxyFactory.eINSTANCE.createEObjectTreeElement();
					treeElement.setEObject(EObject.class.cast(value));
					text = labelProviderService.getLabelProvider().getText(treeElement);
				} else {
					text = labelProviderService.getLabelProvider().getText(value);
				}
			} else {
				text = super.getText(object);
			}
		}
		return text;
	}

	/**
	 * Determines if a given object has a label within the Papyrus ModelExplorer.
	 * 
	 * @param object
	 *            the object to check
	 * @return {@code true} if the {@code object} has a Papyrus ModelExplorer label, {@code false} otherwise.
	 */
	protected boolean hasModelExplorerLabel(Object object) {
		if (EObject.class.isInstance(object)) {
			final EObject eObject = EObject.class.cast(object);
			if (UMLPackage.class.isInstance(eObject.eClass().getEPackage())) {
				return true;
			}
			if (CSSDiagram.class.isInstance(eObject)) {
				return true;
			}
		}
		return false;
	}
}
