/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.editors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.uml2.uml.NamedElement;


/**
 * The standard implementation of the <code>ICompletionProposal</code> interface.
 */
public final class NamedElementCompletionProposal implements ICompletionProposal {

	/** The string to be displayed in the completion proposal popup. */
	private String displayString;
	/** The replacement string. */
	private String replacementString;
	/** The replacement offset. */
	private int replacementOffset;
	/** The replacement length. */
	private int replacementLength;
	/** The cursor position after this proposal has been applied. */
	private int cursorPosition;
	/** The image to be displayed in the completion proposal popup. */
	private Image image;
	/** The context information of this proposal. */
	private IContextInformation contextInformation;
	/** The additional info of this proposal. */
	private String additionalProposalInfo;

	private EStructuralFeature eStructuralFeature;

	private NamedElement namedElement;

	private EObject context;

	public NamedElementCompletionProposal(EStructuralFeature eStructuralFeature, NamedElement namedElement,EObject context, int replacementOffset, int replacementLength, int cursorPosition) {
		this(eStructuralFeature,namedElement,context, namedElement.getName(), replacementOffset, replacementLength, cursorPosition, null,
				namedElement.getName()+ " - "+ namedElement.getNamespace().getQualifiedName(), //$NON-NLS-1$
				null,
				"help?"); //$NON-NLS-1$
	}

	/**
	 * Creates a new completion proposal. All fields are initialized based on the provided information.
	 *
	 * @param replacementString the actual string to be inserted into the document
	 * @param replacementOffset the offset of the text to be replaced
	 * @param replacementLength the length of the text to be replaced
	 * @param cursorPosition the position of the cursor following the insert relative to replacementOffset
	 * @param image the image to display for this proposal
	 * @param displayString the string to be displayed for the proposal
	 * @param contextInformation the context information associated with this proposal
	 * @param additionalProposalInfo the additional information associated with this proposal
	 */
	public NamedElementCompletionProposal(EStructuralFeature eStructuralFeature, NamedElement namedElement,EObject context,String replacementString, int replacementOffset, int replacementLength, int cursorPosition, Image image, String displayString, IContextInformation contextInformation, String additionalProposalInfo) {
		Assert.isNotNull(replacementString);
		Assert.isTrue(replacementOffset >= 0);
		Assert.isTrue(replacementLength >= 0);
		Assert.isTrue(cursorPosition >= 0);

		this.eStructuralFeature = eStructuralFeature;
		this.namedElement = namedElement;
		this.context = context;
		this.replacementString= replacementString;
		this.replacementOffset= replacementOffset;
		this.replacementLength= replacementLength;
		this.cursorPosition= cursorPosition;
		this.image= image;
		this.displayString= displayString;
		this.contextInformation= contextInformation;
		this.additionalProposalInfo= additionalProposalInfo;
	}

	/**
	 * Set the text in the widget and update the reference with the selected value.
	 *
	 * @param document
	 */
	@Override
	public void apply(IDocument document) {
		try {
			document.replace(replacementOffset, replacementLength, replacementString);
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(context);
			RecordingCommand cc = new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					context.eSet(eStructuralFeature , namedElement);
				}
			};
			editingDomain.getCommandStack().execute(cc);
		} catch (BadLocationException x) {
			// ignore since we replace in a non-binded widget
		}
	}

	@Override
	public Point getSelection(IDocument document) {
		return new Point(replacementOffset + cursorPosition, 0);
	}

	@Override
	public IContextInformation getContextInformation() {
		return contextInformation;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public String getDisplayString() {
		if (displayString != null)
			return displayString;
		return replacementString;
	}

	@Override
	public String getAdditionalProposalInfo() {
		return additionalProposalInfo;
	}
}
