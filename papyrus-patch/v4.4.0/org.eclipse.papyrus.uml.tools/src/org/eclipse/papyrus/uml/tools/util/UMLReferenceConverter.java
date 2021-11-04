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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper;
import org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter;
import org.eclipse.uml2.uml.NamedElement;

/**
 * @author Vincent Lorenzo
 *
 */
public class UMLReferenceConverter implements IPapyrusConverter {

	/**
	 * the helper used to find UML NamedElement using their name
	 */
	protected INameResolutionHelper sharedResolutionHelper;

	/**
	 * boolean indicating if the edited property is many or not
	 */
	protected final boolean isMany;

	public static final String ERROR_MESSAGE_NO_ELEMENT_FOUND = "No element have been found to match your string";//$NON-NLS-1$;

	public static final String ERROR_MESSAGE_SOME_ELEMENTS_NOT_FOUND = "Some elements have not been found to match your string";//$NON-NLS-1$;

	/**
	 * Constructor.
	 *
	 * @param helper
	 *            the name resolution helper to use
	 * @param isMultiValued
	 *            <code>true</code> if the edited property is multi-valued
	 */
	public UMLReferenceConverter(INameResolutionHelper nameResolutionHelper, boolean isMultiValued) {
		this.sharedResolutionHelper = nameResolutionHelper;
		this.isMany = isMultiValued;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#getCompletionProcessor(org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param element
	 * @return
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return new ReferenceContentAssistProcessor(this, isMany);
	}


	/**
	 * This method takes a string as parameter. This string can contains the name (qualified name) of several elements, separated by {@link IPapyrusConverter#STRING_SEPARATOR}. if the name of an element contains {@link IPapyrusParser#STRING_SEPARATOR, the name will be delimited by IPapyrusParser#STRING_DELIMITER
	 * 
	 * This method return a map with the name of the subelement as keys. The values are the start and the end position of the key in the string parameter.
	 * @param listOfValueAsString
	 *            the full String write in the StyledText
	 * @return
	 *         a map with the name of the elements as key and the start and the end index of the name in the typed text
	 */
	public final Map<List<Integer>, String> getSubStringsWithTheirPositions(String listOfValueAsString) {
		final Pattern pattern = Pattern.compile(FIND_PART_NAME_REGEX);
		final Matcher matcher = pattern.matcher(listOfValueAsString);
		final TreeMap<List<Integer>, String> path = new TreeMap<>(new TwoIntegerListTupleComparator());
		while (matcher.find()) {
			String current = matcher.group();
			List<Integer> indexes = new ArrayList<>();
			int start = matcher.start();
			int end = matcher.end();
			if (current.startsWith(STRING_DELIMITER) && current.endsWith(STRING_DELIMITER)) {
				current = current.substring(1, current.length() - 1);
			} else {
				if (start - 1 >= 0) {
					// we chack than the user does not have type something starting with the delimiter, without typing a comma after it
					String substring = listOfValueAsString.substring(start - 1, start);
					if (STRING_DELIMITER.equals(substring)) {
						if (!current.contains(STRING_SEPARATOR)) {
							start = start - 1;
							current = listOfValueAsString.substring(start, end);
						}
					}
				}
			}
			indexes.add(start);
			indexes.add(end);
			path.put(indexes, current);
		}
		return path;
	}

	/**
	 * 
	 * @param multiValuedString
	 * @return
	 *         the list of named element represented by this string
	 */
	private List<NamedElement> getNamedElementFromString(String multiValuedString) {
		List<NamedElement> elements = new ArrayList<NamedElement>();
		Collection<String> names = splitFullStringToSubElementString(multiValuedString);
		for (String string2 : names) {
			List<?> values = sharedResolutionHelper.getElementsByName(string2);
			if (values.size() > 0) {
				elements.add((NamedElement) values.get(0));
			}
		}
		return elements;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#splitFullStringToSubElementString(java.lang.String)
	 *
	 * @param multiValueAsString
	 * @return
	 */
	public List<String> splitFullStringToSubElementString(String multiValueAsString) {
		TreeMap<List<Integer>, String> res = (TreeMap<List<Integer>, String>) getSubStringsWithTheirPositions(multiValueAsString);
		return new ArrayList<>(res.values());
	}


	/**
	 * 
	 * @param namedElement
	 * @return
	 *         the name of the named element, starting and ending with {@link #STRING_DELIMITER} if its name contains {@link #STRING_DELIMITER}
	 */
	protected String getElementNameWithDelimiterIfRequired(final NamedElement namedElement) {
		final StringBuilder builder = new StringBuilder();
		final List<String> names = sharedResolutionHelper.getShortestQualifiedNames(namedElement, true);
		if(!names.isEmpty()){
			String name = names.get(0);
			if (name.contains(STRING_SEPARATOR)) {
				builder.append(STRING_DELIMITER);
				builder.append(name);
				builder.append(STRING_DELIMITER);
			} else {
				builder.append(name);
			}
		}
		return builder.toString();
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#getEditStringFromPrintString(java.lang.String)
	 *
	 * @param printString
	 * @return
	 */
	public String getEditStringFromPrintString(String printString) {
		if (printString.contains(STRING_SEPARATOR)) {
			StringBuilder builder = new StringBuilder();
			builder.append(STRING_DELIMITER);
			builder.append(printString);
			builder.append(STRING_DELIMITER);
			return builder.toString();
		}
		return printString;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#getUsedNameResolutionHelper()
	 *
	 * @return
	 */
	public INameResolutionHelper getUsedNameResolutionHelper() {
		return this.sharedResolutionHelper;
	}

	/**
	 * 
	 * @param aString
	 *            a string
	 * @return
	 *         all elements whose the name starts with this string, or all found element if the string is <code>null</code> or empty
	 */
	public List<?> getMatchingElements(final String aString) {
		String lookedForString = null;
		if (aString.startsWith(STRING_DELIMITER) && aString.endsWith(STRING_DELIMITER)) {
			lookedForString = aString.substring(1, aString.length() - 2);
		} else {
			lookedForString = aString;
		}
		return this.sharedResolutionHelper.getMatchingElements(lookedForString);
	}

	/**
	 * Transfer the call to the wrapped shared helper
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper#getMatchingElements(java.util.function.Predicate)
	 *
	 * @param p
	 * @return
	 */
	@Override
	public List<?> getMatchingElements(Predicate p) {
		return this.sharedResolutionHelper.getMatchingElements(p);
	}	
	
	/**
	 * 
	 * @param aString
	 *            a string
	 * @return
	 *         all elements which have the wanted string as (qualified) name
	 */
	public List<?> getElementsByName(final String aString) {
		return this.sharedResolutionHelper.getElementsByName(aString);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper#getShortestQualifiedNames(java.lang.Object)
	 * @deprecated since 1.2.0
	 */
	@Override
	public List<String> getShortestQualifiedNames(final Object element) {
		return this.sharedResolutionHelper.getShortestQualifiedNames(element, false);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper#getShortestQualifiedNames(java.lang.Object, boolean)
	 */
	@Override
	public List<String> getShortestQualifiedNames(final Object element, final boolean manageDuplicate) {
		return this.sharedResolutionHelper.getShortestQualifiedNames(element, manageDuplicate);
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#canonicalToDisplayValue(java.lang.Object, int)
	 *
	 * @param object
	 * @return
	 */
	public String canonicalToDisplayValue(Object object, int flag) {
		if (object == null || EMPTY_STRING.equals(object)) {
			return IPapyrusConverter.UNDEFINED_VALUE;
		}

		if (object instanceof Collection<?>) {
			if (((Collection<?>) object).isEmpty()) {
				return EMPTY_STRING;
			}

			StringBuilder builder = new StringBuilder();
			Collection<?> coll = (Collection<?>) object;
			Iterator<?> iter = coll.iterator();
			while (iter.hasNext()) {
				Object tmp = iter.next();
				Assert.isTrue(tmp instanceof NamedElement);
				List<String> names = getShortestQualifiedNames(tmp, false);
				if (names.size() > 0) {
					builder.append(names.get(0));
				}
				if (iter.hasNext()) {
					builder.append(STRING_SEPARATOR);
				}
			}
			return builder.toString();
		} else if (object instanceof EObject) {
			EObject eobject = (EObject) object;
			Assert.isTrue(eobject instanceof NamedElement);
			List<String> names = getShortestQualifiedNames(eobject, false);
			if (names.size() > 0) {
				return names.get(0);
			}

		}
		return EMPTY_STRING;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#displayToCanonicalValue(java.lang.String)
	 *
	 * @param string
	 * @return
	 */
	public Object displayToCanonicalValue(String string, int flag) {
		if (EMPTY_STRING.equals(string) || UNDEFINED_VALUE.equals(string)) {
			return null;
		}
		Assert.isTrue(string instanceof String);
		List<NamedElement> elements = getNamedElementFromString((String) string);
		if (elements.size() == 0) {
			return null;
		}
		if (!isMany && elements.size() >= 1) {
			return elements.get(0);
		}
		return elements;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#canonicalToEditValue(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	public String canonicalToEditValue(Object object, int flag) {
		if (object == null || EMPTY_STRING.equals(object)) {
			return EMPTY_STRING;
		}

		if (object instanceof Collection<?>) {
			if (((Collection<?>) object).isEmpty()) {
				return EMPTY_STRING;
			}

			StringBuilder builder = new StringBuilder();
			Collection<?> coll = (Collection<?>) object;
			Iterator<?> iter = coll.iterator();
			while (iter.hasNext()) {
				Object tmp = iter.next();
				Assert.isTrue(tmp instanceof NamedElement);
				builder.append(getElementNameWithDelimiterIfRequired((NamedElement) tmp));
				if (iter.hasNext()) {
					builder.append(STRING_SEPARATOR);
				}
			}
			return builder.toString();
		} else if (object instanceof EObject) {
			EObject eobject = (EObject) object;
			Assert.isTrue(eobject instanceof NamedElement);
			return getElementNameWithDelimiterIfRequired((NamedElement) eobject);
		}
		return EMPTY_STRING;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#editToCanonicalValue(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	public Object editToCanonicalValue(String editValue, int flag) {
		if (EMPTY_STRING.equals(editValue) || UNDEFINED_VALUE.equals(editValue)) {
			return null;
		}
		Assert.isTrue(editValue instanceof String);
		List<NamedElement> elements = getNamedElementFromString((String) editValue);
		if (elements.size() == 0) {
			return null;
		}
		if (!isMany && elements.size() >= 1) {
			return elements.get(0);
		}
		return elements;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#editToDisplayValue(java.lang.String)
	 *
	 * @param singleString
	 * @return
	 */
	public String editToDisplayValue(String singleString) {
		if (singleString.startsWith(STRING_DELIMITER) && singleString.endsWith(STRING_DELIMITER)) {
			return singleString.substring(1, singleString.length() - 1);
		}
		return singleString;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#displayToEditValue(java.lang.String)
	 *
	 * @param singleString
	 * @return
	 */
	public String displayToEditValue(String singleString) {
		if (singleString.contains(STRING_SEPARATOR)) {
			StringBuilder builder = new StringBuilder();
			builder.append(STRING_DELIMITER);
			builder.append(singleString);
			builder.append(STRING_DELIMITER);
			return builder.toString();
		}
		return singleString;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter#isValidEditString(java.lang.String)
	 *
	 * @param aString
	 * @return
	 */
	public IStatus isValidEditString(String aString) {
		if (aString == null || EMPTY_STRING.equals(aString) || UNDEFINED_VALUE.equals(aString)) {
			return org.eclipse.core.runtime.Status.OK_STATUS;
		}
		Object result = editToCanonicalValue(aString, 0);
		List<String> split = splitFullStringToSubElementString(aString);
		if (result == null || (result instanceof Collection<?> && ((Collection<?>) result).isEmpty())) {
			return new org.eclipse.core.runtime.Status(IStatus.ERROR, Activator.PLUGIN_ID, ERROR_MESSAGE_NO_ELEMENT_FOUND);
		}
		if (result instanceof Collection<?> && (((Collection<?>) result).size() < split.size())) {
			return new org.eclipse.core.runtime.Status(IStatus.ERROR, Activator.PLUGIN_ID, ERROR_MESSAGE_SOME_ELEMENTS_NOT_FOUND);
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}


	/**
	 * 
	 * @author Vincent Lorenzo
	 *         This class allows to sort the map containing the start and end index of the substrings. We need it to be able to provide completion for the correct sub string
	 */
	private static final class TwoIntegerListTupleComparator implements Comparator<List<Integer>> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 *
		 * @param o1
		 * @param o2
		 * @return
		 */
		public int compare(List<Integer> o1, List<Integer> o2) {
			Assert.isTrue(o1.size() == 2);
			Assert.isTrue(o2.size() == 2);
			if (o1.equals(o2)) {
				return 0;
			}
			if (o1.get(0) > o2.get(0)) {
				Assert.isTrue(o1.get(1) > o2.get(1));
				return 1;
			}
			if (o1.get(0) < o2.get(0)) {
				Assert.isTrue(o1.get(1) < o2.get(1));
				return -1;
			}
			throw new UnsupportedOperationException("should no be possible"); //$NON-NLS-1$

		}

	}
}
