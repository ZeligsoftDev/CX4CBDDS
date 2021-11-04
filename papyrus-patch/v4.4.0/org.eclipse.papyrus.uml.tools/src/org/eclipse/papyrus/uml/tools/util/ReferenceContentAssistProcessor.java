/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.papyrus.infra.widgets.util.DoNothingCompletionProposal;
import org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter;

/**
 * @author Vincent Lorenzo
 *
 */
public class ReferenceContentAssistProcessor implements IContentAssistProcessor {
	/**
	 * the maximum of elements to display in the completion
	 */
	private int MAX_ELEMENTS_TO_DISPLAY = 15;

	/**
	 * add this string to the suggestions when there are more than {@link #MAX_ELEMENTS_TO_DISPLAY}
	 */
	public static final String MORE_ELEMENTS = IPapyrusConverter.MORE_ELEMENTS; //$NON-NLS-1$


	private String lastError = null;

	private IContextInformationValidator contextInfoValidator;

	private IPapyrusConverter parser;

	private boolean isMany;

	/**
	 * 
	 * Constructor.
	 *
	 * @param parser
	 */
	public ReferenceContentAssistProcessor(IPapyrusConverter parser, boolean isMany) {
		this.parser = parser;
		this.isMany = isMany;
		contextInfoValidator = new ContextInformationValidator(this);
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
		String currentStr = textViewer.getTextWidget().getText();
		Map<List<Integer>, String> parse = this.parser.getSubStringsWithTheirPositions(currentStr);

		String stringToComplete = null;
		for (Entry<List<Integer>, String> current : parse.entrySet()) {
			int start = current.getKey().get(0);
			int end = current.getKey().get(1);
			if (currOffset >= start && currOffset < end) {
				stringToComplete = current.getValue();
				break;
			}
		}
		if (stringToComplete == null) {
			stringToComplete = IPapyrusConverter.EMPTY_STRING;
		}

		try {

			String currWord = IPapyrusConverter.EMPTY_STRING;
			char currChar;
			while (currOffset > 0 && !Character.isWhitespace(currChar = document.getChar(currOffset))) {
				currWord = currChar + currWord;
				currOffset--;
			}

			currWord = textViewer.getTextWidget().getText();
			List<String> suggestions = suggest(stringToComplete);
			ICompletionProposal[] proposals = null;
			if (suggestions.size() > 0) {
				proposals = buildProposals(suggestions, stringToComplete, documentOffset - stringToComplete.length());
				// proposals = buildProposals(suggestions, currWord, 0);
				lastError = null;
			} else {
				lastError = "There is no suggestion for you."; //$NON-NLS-1$
			}
			return proposals;
		} catch (BadLocationException e) {
			org.eclipse.papyrus.infra.widgets.Activator.log.error(e);
			lastError = e.getMessage();
			return null;
		}
	}

	/**
	 * 
	 * @param word
	 *            the string typed by the user
	 * @return
	 *         the available suggestion for this string and fill {@link #map}
	 */
	public List<String> suggest(String word) {
		List<String> suggestions = new LinkedList<String>();
		if (word == null || word.length() == 0) {
			suggestions.addAll(buildSuggest(word));
		} else {
			List<String> val = this.parser.splitFullStringToSubElementString(word);
			if (val.size() == 1) {
				suggestions.addAll(buildSuggest(val.get(0)));
			} else {
				// we assume than we provide always for the last string
				String subWord = val.get(val.size() - 1);
				suggestions.addAll(buildSuggest(subWord));
			}
			// if(isMany){
			// suggestions.add(IPapyrusConverter.STRING_SEPARATOR);
			// }
		}
		return suggestions;
	}

	/**
	 * 
	 * @param word
	 *            a word
	 * @return
	 *         the list of suggestions for the string word, + <code>null</code> suggestion + {@link #MORE_ELEMENTS} if required
	 */
	protected List<String> buildSuggest(String word) {
		List<String> suggestions = new LinkedList<String>();
		boolean isEmpty = word == null || word.length() == 0;
		if (!isEmpty) {
			boolean escapedName = word.startsWith(IPapyrusConverter.STRING_DELIMITER);
			if (escapedName) {
				word = word.substring(1);
			}

			List<?> elements = parser.getMatchingElements(word);// OK
			for (int i = 0; i < elements.size() && i < MAX_ELEMENTS_TO_DISPLAY; i++) {
				Object current = elements.get(i);
				String name = parser.canonicalToDisplayValue(current, 0);
				if (escapedName && !name.contains(IPapyrusConverter.STRING_SEPARATOR)) {
					continue;
				}
				suggestions.add(name);
			}
			if (elements.size() > MAX_ELEMENTS_TO_DISPLAY) {
				suggestions.add(0, MORE_ELEMENTS);
			}
		} else {
			suggestions.add(0, MORE_ELEMENTS);
		}
		suggestions.add(0, IPapyrusConverter.UNDEFINED_VALUE);
		return suggestions;
	}

	/**
	 * 
	 * @param suggestions
	 *            the list of suggestions
	 * @param replacedWord
	 *            the word to replace
	 * @param offset
	 *            the offset
	 * @return
	 *         an array with the completion proposal
	 */
	private ICompletionProposal[] buildProposals(List<String> suggestions, String replacedWord, int offset) {
		ICompletionProposal[] proposals = new ICompletionProposal[suggestions.size()];
		int index = 0;
		for (Iterator<String> i = suggestions.iterator(); i.hasNext();) {
			String currSuggestion = (String) i.next();
			if (MORE_ELEMENTS.equals(currSuggestion)) {
				// we do nothing
				proposals[index] = new DoNothingCompletionProposal(IPapyrusConverter.EMPTY_STRING, 0, replacedWord.length() + offset, currSuggestion.length(), null, currSuggestion, null, null);
			} else if (IPapyrusConverter.UNDEFINED_VALUE.equals(currSuggestion)) {
				// we will replace the full string
				proposals[index] = new CompletionProposal(currSuggestion, 0, replacedWord.length() + offset, currSuggestion.length());
			} else if (IPapyrusConverter.STRING_SEPARATOR.equals(currSuggestion)) {
				StringBuilder builder = new StringBuilder();
				builder.append(replacedWord);
				builder.append(currSuggestion);
				proposals[index] = new CompletionProposal(builder.toString(), offset, replacedWord.length(), builder.length(), null, currSuggestion, null, null);
			}
			else {
				String replacementString = parser.displayToEditValue(currSuggestion);
				proposals[index] = new CompletionProposal(replacementString, offset, replacedWord.length(), replacementString.length(), null, currSuggestion, null, null);
			}
			index++;
		}
		return proposals;
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