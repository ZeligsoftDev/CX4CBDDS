/*****************************************************************************
 * Copyright (c) 2008, 2017 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - bug 522652
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositeforview;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.TreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.ValueTreeObject;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class ProfileElementWithDisplayContentProvider.
 */
public class ProfileElementWithDisplayContentProvider extends ProfileElementContentProvider {

	/**
	 * The diagram element.
	 */
	protected EModelElement diagramElement = null;

	/**
	 * The Constructor.
	 *
	 * @param _diagramElement
	 *            the _diagram element
	 */
	public ProfileElementWithDisplayContentProvider(EModelElement _diagramElement) {
		super();
		diagramElement = _diagramElement;
	}

	/**
	 * Gets the children.
	 *
	 * @param parent
	 *            the parent
	 *
	 * @return the children
	 */
	@Override
	public TreeObject[] getChildren(Object parent) {
		TreeObject[] objects = super.getChildren(parent);
		updateIsDisplay(objects);

		return objects;
	}

	/**
	 * Update is display.
	 *
	 * @param objects
	 *            the objects
	 */
	private void updateIsDisplay(TreeObject[] objects) {

		for (int i = 0; i < objects.length; i++) {

			if (objects[i] instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject currentStTO = (AppliedStereotypeTreeObject) objects[i];
				if (isInStereotypeDisplay(currentStTO.getStereotype())) {
					currentStTO.setDisplay(true);
				} else {
					currentStTO.setDisplay(false);
				}

			} else if (objects[i] instanceof AppliedStereotypePropertyTreeObject) {
				AppliedStereotypePropertyTreeObject currentPropertyTO = (AppliedStereotypePropertyTreeObject) objects[i];
				AppliedStereotypeTreeObject currentStereotypeTO = (AppliedStereotypeTreeObject) currentPropertyTO.getParent();
				if (isInStereoPropertyDisplay(currentPropertyTO.getProperty(), currentStereotypeTO.getStereotype())) {
					currentPropertyTO.setDisplay(true);
				} else {
					currentPropertyTO.setDisplay(false);
				}

			}else if( objects[i] instanceof ValueTreeObject) {
				ValueTreeObject currentValue = (ValueTreeObject) objects[i];
				AppliedStereotypePropertyTreeObject currentPropertyTO = (AppliedStereotypePropertyTreeObject) currentValue.getParent();
				AppliedStereotypeTreeObject currentStereotypeTO = (AppliedStereotypeTreeObject) currentPropertyTO.getParent();
				if (isInStereoPropertyDisplay(currentPropertyTO.getProperty(), currentStereotypeTO.getStereotype())) {
					currentPropertyTO.setDisplay(true);
				} else {
					currentPropertyTO.setDisplay(false);
				}
			}
			// else nothing to do
		}
		//
		//
		// // handle display icons
		// TreeItem[] treeItems = getTree().getItems();
		// for(int i=0; i<treeItems.length; i++){
		// if(treeItems[i].getData() instanceof StereotypeTreeObject){
		// if(isInStereotypeDisplay(((StereotypeTreeObject)treeItems[i].getData()).getStereotype())) {
		// treeItems[i].setImage(IMG_DISPLAYED_STEREO);
		// }
		// else {
		// treeItems[i].setImage(ImageManager.IMG_STEREOTYPE);
		// }
		// }
		//
		// // properties display handling
		// TreeItem[] propItems = treeItems[i].getItems();
		// for(int j=0; j<propItems.length; j++){
		// if(propItems[j].getData() instanceof PropertyTreeObject){
		// if(isInStereoPropertyDisplay(((PropertyTreeObject)propItems[j].getData()).getProperty(), ((StereotypeTreeObject)treeItems[i].getData()).getStereotype())) {
		// propItems[j].setImage(IMG_DISPLAYED_STEREO);
		// } else {
		// propItems[j].setImage(ImageManager.IMG_PROPERTY);
		// }
		// }
		// }
	}

	/**
	 * Checks wether the stereotype property is in the display list or not.
	 *
	 * @param owner
	 *            the owner
	 * @param property
	 *            to check out
	 *
	 * @return true if the stereotype property is in the display list, false otherwise
	 */
	private Boolean isInStereoPropertyDisplay(Property property, Stereotype owner) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (diagramElement == null) {
			return false;
		}

		// EList propList = diagramElement.getProperty();
		// Iterator iter = propList.iterator();
		// while (iter.hasNext()) {
		// com.cea.papyrus.diagraminterchange2.di2.Property prop = (com.cea.papyrus.diagraminterchange2.di2.Property) iter.next();
		// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY)) {
		// if (prop.getValue().equals(owner.getQualifiedName() + "::" + property.getName())) {
		// return true;
		// }
		// }
		// }
		return false;
	}

	/**
	 * Sets the diagram element.
	 *
	 * @param diagramElement
	 *            the diagram element
	 */
	public void setDiagramElement(EModelElement diagramElement) {
		this.diagramElement = diagramElement;
	}

	/**
	 * Checks whether the stereotype is in the display list or not.
	 *
	 * @param st
	 *            to check out
	 *
	 * @return true if the stereotype is in the display list, false otherwise
	 */
	protected Boolean isInStereotypeDisplay(Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (diagramElement == null) {
			return false;
		}

		// EList propList = diagramElement.getProperty();
		// Iterator iter = propList.iterator();
		// while (iter.hasNext()) {
		// com.cea.papyrus.diagraminterchange2.di2.Property prop = (com.cea.papyrus.diagraminterchange2.di2.Property) iter.next();
		// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_DISPLAY)) {
		// if (prop.getValue().equals(st.getQualifiedName())) {
		// return true;
		// }
		// }
		// }
		return false;
	}

}
