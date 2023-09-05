/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositeforview;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Profile;

//TODO: Auto-generated Javadoc
/**
 * The Class ProfileComposite to apply or unapply profile only on model element withou view.
 */
public class AppliedProfileCompositeWithView extends org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppliedProfileCompositeOnModel implements IViewComposite {

	/**
	 * The Constructor.
	 *
	 * @param parent
	 *            the parent
	 * @param factory
	 *            the factory
	 */
	public AppliedProfileCompositeWithView(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super(parent, factory);
		this.setBackground(JFaceColors.getBannerBackground(parent.getDisplay()));
	}

	/**
	 * Adds the reg button pressed.
	 */
	@Override
	protected void registeredProfileButtonPressed() {
		super.registeredProfileButtonPressed();
	}

	/**
	 * Rem button pressed.
	 */
	@Override
	protected void unapplyProfileButtonPressed() {
		// refreshGraphicalStereotypesdisplay((Profile) getProfiles().getData(getProfiles().getItem(getProfiles().getSelectionIndex())));
		removeProfileDisplaying();
		super.unapplyProfileButtonPressed();
		synchroniseGraphicalStereotypesdisplay();
	}

	/**
	 * Adds the button pressed.
	 */
	@Override
	protected void applyProfileButtonPressed() {
		super.applyProfileButtonPressed();
		// refreshGraphicalStereotypesdisplay(super.profiletoApply);
		synchroniseGraphicalStereotypesdisplay();
	}

	/**
	 * Refresh graphical stereotypesdisplay.
	 */
	protected void synchroniseGraphicalStereotypesdisplay() {

		// /* profile to unapply */
		// // Profile profileToUnapply = (Profile) getProfiles().getData(getProfiles().getItem(getProfiles().getSelectionIndex()));
		// /** update stereotype display list ************************************/
		// // set of uml elements of the package
		// Set<Element> umlElements = PackageUtil.getAllNestedElements((org.eclipse.uml2.uml.Package) getSelected());
		// // add the package to this set
		// umlElements.add(getSelected());
		//
		// // set of diagrams
		// Iterator<Diagram> diagramIter = modelManager.getDiagrams().iterator();
		//
		// // set of graphElements associated to uml elements that are nested
		// // in the package we unapply the profile from
		// ArrayList<GraphElement> filteredGraphElements = new ArrayList<GraphElement>();
		//
		// while (diagramIter.hasNext()) {
		// Diagram diag = diagramIter.next();
		//
		// // list of graphElements of a diagram
		// ArrayList<GraphElement> diagramGraphElements = new ArrayList<GraphElement>();
		// diagramGraphElements = LookForElement.getAllGraphElements(diag, diagramGraphElements);
		//
		// // filter diagramsGraphElements in order to hold graphElements associated to uml elements
		// // of the package which we unapply profile from
		// Iterator<GraphElement> geIter = diagramGraphElements.iterator();
		// while (geIter.hasNext()) {
		// GraphElement ge = geIter.next();
		//
		// // if the diagram element property list is empty, it has not have any stereotype
		// if (ge.getProperty().size() != 0) {
		// if (umlElements.contains(((Uml1SemanticModelBridge) ge.getSemanticModel()).getElement())) {
		// filteredGraphElements.add(ge);
		// }
		// }
		// }
		// }
		//
		// // look for each stereotyped graphElement
		// Iterator<GraphElement> stereotypedGE = filteredGraphElements.iterator();
		// while (stereotypedGE.hasNext()) {
		// GraphElement stGE = stereotypedGE.next();
		// // tempProp contains list of property element of a stereotyped GraphElement
		// ArrayList tempProp = new ArrayList();
		// EList tpList = stGE.getProperty();
		// for (int i = 0; i < tpList.size(); i++) {
		// tempProp.add(tpList.get(i));
		// }
		//
		// Iterator propIter = tempProp.iterator();
		// while (propIter.hasNext()) {
		// com.cea.papyrus.diagraminterchange2.di2.Property prop = (com.cea.papyrus.diagraminterchange2.di2.Property) propIter.next();
		// // This is a Property to display a stereotype?
		// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_DISPLAY)) {
		// String stName = prop.getValue();
		// // test if the stereotype is not applied
		// if (((Uml1SemanticModelBridge) stGE.getSemanticModel()).getElement().getAppliedStereotype(stName) == null) {
		// stGE.getProperty().remove(prop);
		// }
		// }
		// // remove properties
		// if (prop.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY)) {
		// String propName = prop.getValue();
		// // stereotype name
		// String stereoName = propName.substring(0, propName.lastIndexOf("::"));
		// // test if the stereotype is applied
		// if (((Uml1SemanticModelBridge) stGE.getSemanticModel()).getElement().getAppliedStereotype(stereoName) == null) {
		// stGE.getProperty().remove(prop);
		// } else {
		// Stereotype stereo = ((Uml1SemanticModelBridge) stGE.getSemanticModel()).getElement().getAppliedStereotype(stereoName);
		// String simplePropName = propName.replaceAll(stereoName + "::", "");
		// Iterator iterPro = stereo.getAllAttributes().iterator();
		// boolean found = false;
		// while (iterPro.hasNext()) {
		// org.eclipse.uml2.uml.Property tmpProperty = (org.eclipse.uml2.uml.Property) iterPro.next();
		// if (tmpProperty.getName().equals(simplePropName)) {
		// found = true;
		// }
		// }
		//
		// if (found == false) {
		// stGE.getProperty().remove(prop);
		// }
		// }
		// /***** Remove properties display if there is no more properties to display after unapplying this profile *****/
		// // count the number of stereotype properties to display
		// Iterator<com.cea.papyrus.diagraminterchange2.di2.Property> iterProp = stGE.getProperty().iterator();
		// int count = 0;
		// while (iterProp.hasNext()) {
		// com.cea.papyrus.diagraminterchange2.di2.Property diProp = iterProp.next();
		// if (diProp.getKey().equals(ModelerHelper.PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY)) {
		// count++;
		// }
		// }
		//
		// // is there some properties to display?
		// if (count == 0) {
		// org.eclipse.gef.commands.Command command = DiagramElementDeleteCommandFactory.eINSTANCE.createCommand((GraphNode) LookForElement
		// .getSemanticChildWithoutUmlSemanticAndNoContent(stGE));
		//
		// // getCommandStack
		// CommandStack stack = CommandStackUtils.getCommandStack();
		//
		// Assert.isNotNull(stack, "Impossible to adapt current editor into a CommandStackUtils");
		// stack.execute(command);
		//
		// /*************************************************************************************************************/
		//
		// }
		// }
		// }
		// }
	}

	public void removeProfileDisplaying() {
		// Retrieve indices of selected profiles to unapply
		int[] selectionIndices = getProfiles().getSelectionIndices();
		if ((selectionIndices == null) || (selectionIndices.length == 0)) {
			return;
		}

		// Parse selection
		for (int i = 0; i < selectionIndices.length; i++) {
			int currentIndex = selectionIndices[i];
			// Remove TAG_PROFILE_CHANGED when it exists
			String itemName = getProfiles().getItem(currentIndex).replace(TAG_PROFILE_CHANGED, "");
			Profile profileToUnapply = (Profile) getProfiles().getData(itemName);
			// set of diagrams
			// Iterator<Diagram> diagramIter = modelManager.getDiagrams().iterator();
			// while (diagramIter.hasNext()) {
			// ArrayList found = LookForElement.lookForGraphElement(profileToUnapply, diagramIter.next(), new ArrayList());
			// Iterator founditer = found.iterator();
			// while (founditer.hasNext()) {
			// Command cmd = DiagramElementDeleteCommandFactory.eINSTANCE.createCommand((GraphElement) founditer.next());
			// CommandStackUtils.getCommandStack().execute(cmd);
			// }
			// }
		}

	}

	public void setDiagramElement(EModelElement diagramElement) {
		

	}
}
