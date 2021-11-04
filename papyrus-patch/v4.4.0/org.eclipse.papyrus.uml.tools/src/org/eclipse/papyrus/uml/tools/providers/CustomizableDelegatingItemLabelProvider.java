/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) - mickael.adam@all4tec.net - Bug 500219 - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.providers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.papyrus.emf.facet.util.emf.core.ModelUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.profile.definition.LabelTypesEnum;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.NamedElement;


/**
 * An item label provider that delegates to an adapter factory and rewrites the result for UML element labels.
 * If the adapter factory needs to be disposed (which is usually the case for item-provider factories), then
 * this is the responsibility of the client that creates the delegating label provider.
 * @since 3.0
 */
public class CustomizableDelegatingItemLabelProvider implements IItemLabelProvider {

	/** left Stereotype delimiters ('Guillemets francais'). */
	public static String ST_LEFT = "\u00AB"; //$NON-NLS-1$

	/** Right Stereotype delimiters ('Guillemets francais'). */
	public static String ST_RIGHT = "\u00BB"; //$NON-NLS-1$

	/**
	 * The pattern of UML2 Edit labels:
	 * <ol>
	 * <li>keywords (ad hoc and stereotypes), if any, followed by</li>
	 * <li>an optional metaclass specifier, followed by</li>
	 * <li>metaclass-specific decorations (such as derived mark {@code "/"} for properties)</li>
	 * <li>the element name, possibly localized or inferred if omitted by the modeler</li>
	 * <li>metaclass-specific decorations (such as type and multiplicity {@code ": String [1..*]"} for properties)</li>
	 * </ol>
	 */
	private static final Pattern UML2_LABEL_PATTERN = Pattern.compile("(?:<<(.+?)>>)?\\s*(<[^<>]+>)?\\s*(.*)");//$NON-NLS-1$

	/** The separator dash label. */
	private static final String SEPARATOR_DASH = "-";//$NON-NLS-1$

	/** The separator colon label. */
	private static final String SEPARATOR_COLON = ":";//$NON-NLS-1$

	/** The adapter factory. */
	private final AdapterFactory itemAdapterFactory;

	/** The styles list. */
	private List<Entry<String, Styler>> stylesList = new ArrayList<Entry<String, Styler>>();

	/**
	 * Initializes me with my delegate factory and a bit-mask of which label components to allow.
	 *
	 * @param itemAdapterFactory
	 *            my delegate factory
	 * @param stylesList
	 *            The list of entry of styles
	 */
	public CustomizableDelegatingItemLabelProvider(final AdapterFactory itemAdapterFactory, final List<Entry<String, Styler>> stylesList) {
		super();
		this.itemAdapterFactory = itemAdapterFactory;
		this.stylesList = stylesList;
	}

	/**
	 * Initializes me with my delegate factory. I do not suppress any components of the label.
	 *
	 * @param itemAdapterFactory
	 *            my delegate factory
	 */
	public CustomizableDelegatingItemLabelProvider(final AdapterFactory itemAdapterFactory) {
		this(itemAdapterFactory, getDefaultStyles());
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param labelTypes
	 *            The label types list.
	 * @param labelStyles
	 *            The label type list.
	 */
	public CustomizableDelegatingItemLabelProvider(final List<String> labelTypes, final List<Styler> labelStyles) {
		this(Activator.getDefault().getItemProviderAdapterFactory(), toStylesList(labelTypes, labelStyles));
	}

	/**
	 * Set the styles list.
	 * 
	 * @param stylesList
	 *            the stylesList to set
	 */
	public void setStylesList(List<Entry<String, Styler>> stylesList) {
		this.stylesList = stylesList;
	}

	/**
	 * Set the styles list with labelTypes list and labelStyles list.
	 * 
	 * @param labelTypes
	 *            the types List to set
	 * @param labelStyles
	 *            the styles List to set
	 */
	public void setStylesList(final List<String> labelTypes, final List<Styler> labelStyles) {
		this.stylesList = toStylesList(labelTypes, labelStyles);
	}


	/**
	 * @return the styles List
	 */
	public List<Entry<String, Styler>> getStylesList() {
		return stylesList;
	}

	/**
	 * get the list of {@link Entry}.
	 * 
	 * @param labelTypes
	 *            the types List to set
	 * @param labelStyles
	 *            the styles List to set
	 * @return the list of {@link Entry}.
	 */
	protected static List<Entry<String, Styler>> toStylesList(final List<String> labelTypes, final List<Styler> labelStyles) {
		List<Entry<String, Styler>> list = new ArrayList<Entry<String, Styler>>();

		Iterator<Styler> stylerIterator = labelStyles.iterator();
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = labelTypes.iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			Styler styler = null;
			if (stylerIterator.hasNext()) {
				styler = stylerIterator.next();
			}
			list.add(new StyleEntry(type, styler));
		}

		return list;
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param styleslist
	 *            the list of {@link Entry}.
	 */
	public CustomizableDelegatingItemLabelProvider(final List<Entry<String, Styler>> styleslist) {
		this(Activator.getDefault().getItemProviderAdapterFactory(), styleslist);
	}

	/**
	 * @return the default styled list.
	 */
	protected static List<Entry<String, Styler>> getDefaultStyles() {
		List<Entry<String, Styler>> styles = new ArrayList<Entry<String, Styler>>();
		styles.add(new StyleEntry(LabelTypesEnum.STEREOTYPE.getLiteral(), null));
		styles.add(new StyleEntry(LabelTypesEnum.LABEL.getLiteral(), null));
		return styles;

	}

	/**
	 * Initializes me with my plug-in's {@linkplain Activator#getItemProviderAdapterFactory() shared adapter factory} as my delegate factory. I do not
	 * suppress any components of the label. <em>Note</em> that the shared adapter factory does not need to be disposed.
	 */
	public CustomizableDelegatingItemLabelProvider() {
		this(Activator.getDefault().getItemProviderAdapterFactory());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.IItemLabelProvider#getText(java.lang.Object)
	 */
	public String getText(final Object object) {
		return getStyledText(object).toString();
	}

	/**
	 * Gets the styles text from the object.
	 */
	public StyledString getStyledText(final Object object) {
		EObject element = EMFHelper.getEObject(object);
		StyledString result = new StyledString();

		if (null != element) {

			LinkedList<Entry<String, Styler>> styles = new LinkedList<Entry<String, Styler>>(stylesList);

			while (!styles.isEmpty()) {
				Entry<String, Styler> stypeEntry = styles.pop();
				String type = stypeEntry.getKey();
				LabelTypesEnum typeEnum = LabelTypesEnum.getByLiteral(type);
				Styler style = stypeEntry.getValue();

				Boolean stringAdded = false;

				switch (typeEnum) {
				case LABEL:
					result.append(getLabel(element, LabelTypesEnum.LABEL.getLiteral()), style);
					stringAdded = true;
					break;
				case STEREOTYPE:
					String stereotypes = getLabel(element, LabelTypesEnum.STEREOTYPE.getLiteral());
					if (null != stereotypes && !stereotypes.isEmpty()) {
						result.append(ST_LEFT, style).append(stereotypes, style).append(ST_RIGHT, style);
						stringAdded = true;
					}
					break;
				case METACLASS:
					result.append(getLabel(element, LabelTypesEnum.METACLASS.getLiteral()), style);
					stringAdded = true;
					break;
				case DASH_SEPARATOR:
					if (0 < result.length() && !isStylesListEmpty(element, styles)) {
						result.append(SEPARATOR_DASH, style);
						stringAdded = true;
					}
					break;
				case COLON_SEPARATOR:
					if (0 < result.length() && !isStylesListEmpty(element, styles)) {
						result.append(SEPARATOR_COLON, style);
						stringAdded = true;
					}
					break;
				case QUALIFIED_NAME:
					if (element instanceof NamedElement && null != ((NamedElement) element).getQualifiedName()) {
						result.append(((NamedElement) element).getQualifiedName(), style);
						stringAdded = true;
					}
					break;


				default:
					break;
				}

				// Add space between each if necessary
				if (stringAdded && !isStylesListEmpty(element, styles)) {
					result.append(' ');// $NON-NLS-1$
				}
			}
		}

		// If no text to display we call UMLLabelProvider which add some text in this case.
		if (0 >= result.length()) {
			result.append(new UMLLabelProvider().getText(element));
		}

		return result;
	}

	/**
	 * @return true if if the return the value of the corresponding styles is empty.
	 */
	private boolean isStylesListEmpty(final EObject element, final LinkedList<Entry<String, Styler>> styles) {
		StringBuilder text = new StringBuilder();
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = styles.iterator(); iterator.hasNext();) {
			@SuppressWarnings("unchecked")
			Entry<String, Styler> entry = (Entry<String, Styler>) iterator.next();
			if (!(LabelTypesEnum.DASH_SEPARATOR.getLiteral()).equals(entry.getKey())
					&& !(LabelTypesEnum.COLON_SEPARATOR.getLiteral()).equals(entry.getKey())) {
				text.append(getLabel(element, entry.getKey()));
			}
		}
		return text.toString().isEmpty();
	}

	/**
	 * Get the label of the type of the element.
	 */
	protected String getLabel(final EObject element, final String type) {

		String result = null;

		// Delegate to UML2 Edit providers to get localized and inferred names where applicable
		IItemLabelProvider provider = getDelegate(element);
		String umlResult = (provider == null) ? ModelUtils.getDefaultName(element) : provider.getText(element);

		if (null != umlResult) {
			// Rewrite the stereotype list and strip the metaclass qualifier, unless there is no label, in which
			// case we leave the metaclass qualifier
			Matcher m = UML2_LABEL_PATTERN.matcher(umlResult);
			if (m.matches()) {
				LabelTypesEnum typeEnum = LabelTypesEnum.getByLiteral(type);
				switch (typeEnum) {
				case LABEL:
					if (element instanceof Comment) {
						// Comment case which can return <Empty Comment>
						result = new UMLLabelProvider().getText((Comment) element);
					} else {
						result = m.group(3);
					}
					break;
				case STEREOTYPE:
					result = m.group(1);
					break;
				case METACLASS:
					result = m.group(2);
					break;
				case DASH_SEPARATOR:
					result = SEPARATOR_DASH;
					break;
				case COLON_SEPARATOR:
					result = SEPARATOR_COLON;
					break;
				case QUALIFIED_NAME:
					if (element instanceof NamedElement && null != ((NamedElement) element).getQualifiedName()) {
						result = ((NamedElement) element).getQualifiedName();
					}
					break;

				default:
					break;
				}
			}
		}
		return null != result ? result : "";//$NON-NLS-1$

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.IItemLabelProvider#getImage(java.lang.Object)
	 */
	public Object getImage(final Object object) {
		EObject element = EMFHelper.getEObject(object);
		if (null == element) {
			return null;
		}

		// Delegate to UML2 Edit providers to get localized and inferred names where applicable
		IItemLabelProvider provider = getDelegate(element);
		return (provider == null) ? null : provider.getImage(element);
	}

	/**
	 * Gets the delegate for the object.
	 */
	protected IItemLabelProvider getDelegate(EObject object) {
		return (IItemLabelProvider) itemAdapterFactory.adapt(object, IItemLabelProvider.class);
	}


	/**
	 * The Style Entry class. An Entry of a type associated with a styler.
	 */
	public static class StyleEntry implements Entry<String, Styler> {

		/** The type. */
		private String type;

		/** The Styler */
		private Styler styler;

		/**
		 * Constructor.
		 */
		public StyleEntry() {
		}

		/**
		 * 
		 * Constructor.
		 *
		 * @param type
		 *            The type.
		 * @param styler
		 *            The Styler
		 */
		public StyleEntry(final String type, final Styler styler) {
			this.type = type;
			this.styler = styler;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.Map.Entry#getKey()
		 */
		@Override
		public String getKey() {
			return type;
		}

		/**
		 * Gets the type.
		 */
		public String getType() {
			return type;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.Map.Entry#getValue()
		 */
		@Override
		public Styler getValue() {
			return styler;
		}

		/**
		 * Gets the style.
		 */
		public Styler getStyle() {
			return getValue();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.util.Map.Entry#setValue(java.lang.Object)
		 */
		@Override
		public Styler setValue(final Styler value) {
			Styler oldValue = styler;
			styler = value;
			return oldValue;
		}

		/**
		 * Set the styler.
		 */
		public Styler setStyler(final Styler value) {
			return setValue(value);
		}

	}


}
