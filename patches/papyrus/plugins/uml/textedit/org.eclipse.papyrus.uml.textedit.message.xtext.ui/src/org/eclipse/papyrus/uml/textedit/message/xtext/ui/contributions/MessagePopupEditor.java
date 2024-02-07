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
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905, 393750
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.message.xtext.ui.contributions;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.textedit.message.xtext.ui.internal.UmlMessageActivator;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;

import com.google.inject.Injector;

public class MessagePopupEditor extends DefaultXtextDirectEditorConfiguration {

	@Override
	public Injector getInjector() {
		return UmlMessageActivator.getInstance().getInjector(UmlMessageActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_MESSAGE_XTEXT_UMLMESSAGE);
	}

	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		Message message = (Message) umlObject;
		EObject modifiedObject = xtextObject;
		while (modifiedObject != null && !(modifiedObject instanceof MessageRule)) {
			modifiedObject = modifiedObject.eContainer();
		}
		if (modifiedObject == null) {
			return UnexecutableCommand.INSTANCE;
		}
		MessageRule messageRuleObject = (MessageRule) xtextObject;

		// Retrieves the information to be populated in modelObject
		String newName = "" + messageRuleObject.getName(); //$NON-NLS-1$

		int ocnumber = messageRuleObject.getSequenceTerm().get(0).getSequencialOrder();

		String ocname = ""; //$NON-NLS-1$

		String newSequenceTermList = ""; //$NON-NLS-1$
		int i = 0;
		String recurrence;
		for (i = 0; i < messageRuleObject.getSequenceTerm().size(); i++) {
			if (messageRuleObject.getSequenceTerm().get(i).getSequenceName() != null) {
				ocname = messageRuleObject.getSequenceTerm().get(i).getSequenceName().toString();
			}
			ocnumber = messageRuleObject.getSequenceTerm().get(i).getSequencialOrder();
			if (messageRuleObject.getSequenceTerm().get(i).getRecurrence() != null) {
				recurrence = messageRuleObject.getSequenceTerm().get(i).getRecurrence().trim();
			}
			if ((i == 0)) {
				newSequenceTermList = newSequenceTermList + ocnumber + ocname;
			} else {
				newSequenceTermList = newSequenceTermList + '.' + ocnumber + ocname; // $NON-NLS-1$
			}
		}

		return new UpdateUMLMessageCommand(message, newName, newSequenceTermList);
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 *
	 * @param editedObject
	 * @return the text to edit
	 */

	@SuppressWarnings("rawtypes")
	@Override
	public String getTextToEdit(Object editedObject) {

		if (editedObject instanceof Message) {
			String name = UMLLabelInternationalization.getInstance().getLabel(((Message) editedObject));
			if (null == name) {
				name = ""; //$NON-NLS-1$
			}
			String texttoedit = name.trim();

			Interaction interaction = ((Message) editedObject).getInteraction();

			int sequencenumber = 0;
			for (Iterator it = interaction.getMessages().iterator(); it.hasNext();) {
				sequencenumber++;
				Message childElement = (Message) it.next();
				if (childElement.equals(editedObject)) {
					if (!texttoedit.isEmpty() && Character.isDigit(texttoedit.charAt(0))) {
						return texttoedit;
					} else {
						return texttoedit = sequencenumber + ":" + texttoedit; //$NON-NLS-1$
					}
				}
			}
		}

		return "not a Message"; //$NON-NLS-1$
	}

	/**
	 * The Class UpdateUMLMessageCommand.
	 */
	protected static class UpdateUMLMessageCommand extends org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {

		private Message message;

		private String newName;

		private String newSequenceTermList;

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			if (InternationalizationPreferencesUtils.getInternationalizationPreference(message) && null != UMLLabelInternationalization.getInstance().getLabelWithoutUML(message)) {
				UMLLabelInternationalization.getInstance().setLabel(message, newName, null);
			} else {
				this.message.setName(newSequenceTermList + ':' + newName); // $NON-NLS-1$
			}
			return CommandResult.newOKCommandResult(message);
		}

		public UpdateUMLMessageCommand(Message message, String newName, String newSequenceTermList) {
			super(TransactionUtil.getEditingDomain(message), "Message Update", getWorkspaceFiles(message)); //$NON-NLS-1$
			this.message = message;
			this.newName = newName;
			this.newSequenceTermList = newSequenceTermList;
		}
	}
}
