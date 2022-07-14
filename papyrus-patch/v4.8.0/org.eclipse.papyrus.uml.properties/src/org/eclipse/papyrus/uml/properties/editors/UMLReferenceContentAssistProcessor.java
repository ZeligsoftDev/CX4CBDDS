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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.papyrus.infra.widgets.util.DoNothingCompletionProposal;
import org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper;
import org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionHelper;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Provide assistance for auto completion on provided reference with named elements
 */
public class UMLReferenceContentAssistProcessor implements IContentAssistProcessor {
	/**
	 * the maximum of elements to display in the completion
	 */
	private static int MAX_ELEMENTS_TO_DISPLAY = 15;

	/**
	 * add this string to the suggestions when there are more than {@link #MAX_ELEMENTS_TO_DISPLAY}
	 */
	public static final String MORE_ELEMENTS = IPapyrusConverter.MORE_ELEMENTS; //$NON-NLS-1$


	private String lastError = null;

	private IContextInformationValidator contextInfoValidator;

	private NameResolutionHelper nameResolutionHelper;

	private AutoCompleteStyledTextStringEditor autoCompleteStyledTextStringEditor;

	private	EReference eReference ;	
	
	/**
	 * Constructor.
	 *
	 * @param nameResolutionHelper
	 * @param autoCompleteStyledTextStringEditor
	 */
	public UMLReferenceContentAssistProcessor(EReference eReference, NameResolutionHelper nameResolutionHelper, AutoCompleteStyledTextStringEditor autoCompleteStyledTextStringEditor) {
		this.eReference = eReference;
		this.nameResolutionHelper = nameResolutionHelper;
		this.autoCompleteStyledTextStringEditor = autoCompleteStyledTextStringEditor;
	}

	/**
	 * @return the nameResolutionHelper
	 */
	public INameResolutionHelper getNameResolutionHelper() {
		return nameResolutionHelper;
	}

	/**
	 * @param nameResolutionHelper the nameResolutionHelper to set
	 */
	public void setNameResolutionHelper(NameResolutionHelper nameResolutionHelper) {
		this.nameResolutionHelper = nameResolutionHelper;
	}

	/**
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 *
	 * @param textViewer
	 * @param documentOffset
	 * @return
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer textViewer, int documentOffset) {
		IDocument document = textViewer.getDocument();
		int currOffset = documentOffset - 1;
		String stringToComplete = textViewer.getTextWidget().getText();

		try {
			String currWord = IPapyrusConverter.EMPTY_STRING;
			char currChar;
			while (currOffset > 0 && !Character.isWhitespace(currChar = document.getChar(currOffset))) {
				currWord = currChar + currWord;
				currOffset--;
			}

			currWord = textViewer.getTextWidget().getText();
			ICompletionProposal[] proposals = buildProposals(stringToComplete, documentOffset - stringToComplete.length());
			if (proposals.length > 0) {
				lastError = null;
			} else {
				lastError = "There is no suggestion for you."; //$NON-NLS-1$
			}
			return proposals;
		} catch (Exception e) {
			org.eclipse.papyrus.infra.widgets.Activator.log.error(e);
			lastError = e.getMessage();
			return null;
		}
	}

	
	
	/**
	 * List available completion list from user entry 
	 * 
	 * @param entry
	 *            the word to complete
	 * @param offset
	 *            the offset
	 * @return
	 *         an array with the completion proposal
	 */
	private ICompletionProposal[] buildProposals(final String entry, int offset) {
		List<ICompletionProposal> proposalList = new ArrayList<>();
		
		List<NamedElement> matchingElements = (List<NamedElement>) nameResolutionHelper.getMatchingElements(new Predicate<NamedElement>() {
			@Override
			public boolean test(NamedElement namedElement) { //check startwith without case
				return namedElement.getName().regionMatches(true, 0, entry, 0, entry.length());
			}
		});
		
		// We order the list to provide "equal" name first (best option would to have smart suggestion like in jdt)
		//This comparator should be in API
		Collections.sort(matchingElements, new Comparator<NamedElement>() {
			@Override
			public int compare(NamedElement o1, NamedElement o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		
		Object contextElement = autoCompleteStyledTextStringEditor.getContextElement();

		
		for (int i = 0; i < matchingElements.size() && i < MAX_ELEMENTS_TO_DISPLAY; i++) {
			NamedElement suggestedNamedElement = matchingElements.get(i);
			
			ICompletionProposal ccc = new NamedElementCompletionProposal(eReference,suggestedNamedElement,
					(EObject) contextElement, 
					offset, entry.length(), suggestedNamedElement.getName().length());
			proposalList.add(ccc);
		}
		
		// add undefined
		 ICompletionProposal resetProposal = new NamedElementCompletionProposal(eReference, null, (EObject) contextElement, "", 0, entry.length() + offset, IPapyrusConverter.UNDEFINED_VALUE.length(), null, IPapyrusConverter.UNDEFINED_VALUE, null, null);
		 proposalList.add(0, resetProposal);
		// add more if required
		if (matchingElements.size() > MAX_ELEMENTS_TO_DISPLAY) {
			 DoNothingCompletionProposal doNothingCompletionProposal = new DoNothingCompletionProposal(IPapyrusConverter.EMPTY_STRING, 0, entry.length() + offset, IPapyrusConverter.MORE_ELEMENTS.length(), null, IPapyrusConverter.MORE_ELEMENTS, null, null);
			 proposalList.add(doNothingCompletionProposal);
		}
		return proposalList.toArray(new ICompletionProposal[0]);
	}	
		
	
	
	
	public IContextInformation[] computeContextInformation(ITextViewer textViewer, int documentOffset) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 *
	 * @return
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		// we always wait for the user to explicitly trigger completion
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		// we have no context information
		return null;
	}

	public String getErrorMessage() {
		return lastError;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return contextInfoValidator;
	}
}