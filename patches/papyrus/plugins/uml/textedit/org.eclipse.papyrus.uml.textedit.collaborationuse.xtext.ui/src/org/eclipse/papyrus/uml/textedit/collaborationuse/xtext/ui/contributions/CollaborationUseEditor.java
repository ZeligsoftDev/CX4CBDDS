/*****************************************************************************
 * Copyright (c) 2010, 2018 CEA LIST.
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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 531802
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contributions;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.internal.UmlCollaborationUseActivator;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.EcoreUtil2;

import com.google.inject.Injector;

/**
 *
 * Editor for the {@link CollaborationUse}
 *
 */
public class CollaborationUseEditor extends DefaultXtextDirectEditorConfiguration {


	/**
	 * Returns the update command
	 *
	 * @return
	 * 		the update command
	 */
	private final IUndoableOperation getUpdateCommand(final CollaborationUse collaborationUse, final org.eclipse.uml2.uml.VisibilityKind newVisibility, final Collaboration newType, final String newName) {
		CompositeCommand cc = new CompositeCommand("Set values for CollaborationUse"); //$NON-NLS-1$
		org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(collaborationUse);
		if (provider != null) {

			// Manage the name or the label set
			ICommand setNameCommand = null;
			if (InternationalizationPreferencesUtils.getInternationalizationPreference(collaborationUse) && null != UMLLabelInternationalization.getInstance().getLabelWithoutUML(collaborationUse)) {
				final ModelSet modelSet = (ModelSet) collaborationUse.eResource().getResourceSet();
				setNameCommand = new EMFtoGMFCommandWrapper(UMLLabelInternationalization.getInstance().getSetLabelCommand(modelSet.getTransactionalEditingDomain(), collaborationUse, newName, null));
			} else {
				final SetRequest setNameRequest = new SetRequest(collaborationUse, UMLPackage.eINSTANCE.getNamedElement_Name(), newName);
				setNameCommand = provider.getEditCommand(setNameRequest);
			}
			cc.add(setNameCommand);

			// set the visibility
			if (false == collaborationUse.getVisibility().equals(newVisibility)) {// to avoid to have the green + displayed whereas the visibility didn't change
				cc.add(provider.getEditCommand(new SetRequest(collaborationUse, UMLPackage.eINSTANCE.getNamedElement_Visibility(), newVisibility)));
			}

			// set type
			cc.add(provider.getEditCommand(new SetRequest(collaborationUse, UMLPackage.eINSTANCE.getCollaborationUse_Type(), newType)));
		}
		return cc;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 *
	 * @param editedObject
	 * @return
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof CollaborationUse) {
			return UMLCollaborationUseEditorUtil.getLabel((CollaborationUse) editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "not a CollaborationUse"; //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration#getInjector()
	 *
	 * @return
	 */
	@Override
	public Injector getInjector() {
		return UmlCollaborationUseActivator.getInstance().getInjector(UmlCollaborationUseActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_COLLABORATIONUSE_XTEXT_UMLCOLLABORATIONUSE);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration#getParseCommand(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 *
	 * @param umlObject
	 * @param xtextObject
	 * @return
	 */
	@Override
	protected ICommand getParseCommand(final EObject umlObject, EObject xtextObject) {
		if (!(umlObject instanceof CollaborationUse) || null == xtextObject) {
			return null;
		}

		// init the class fields, with the new values
		final CollaborationUse collaborationUse = (CollaborationUse) umlObject;
		xtextObject = EcoreUtil2.getContainerOfType(xtextObject, CollaborationUseRule.class);
		if (null == xtextObject) {
			return null;
		}
		CollaborationUseRule propertyRuleObject = (CollaborationUseRule) xtextObject;
		final String newName = propertyRuleObject.getName();
		final Collaboration newType;
		if (null != propertyRuleObject.getType()) {
			newType = (Collaboration) propertyRuleObject.getType().getType();
		} else {
			newType = null;
		}
		org.eclipse.uml2.uml.VisibilityKind newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;

		if (propertyRuleObject.getVisibility() != null) {
			switch (propertyRuleObject.getVisibility()) {
			case PUBLIC:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;
				break;
			case PACKAGE:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PACKAGE_LITERAL;
				break;
			case PRIVATE:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PRIVATE_LITERAL;
				break;
			case PROTECTED:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PROTECTED_LITERAL;
				break;
			default:
				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;
				break;
			}
		}
		// Creates the update command
		IUndoableOperation updateCommand = getUpdateCommand(collaborationUse, newVisibility, newType, newName);

		return (ICommand) updateCommand;
	}
}