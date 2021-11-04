/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
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
 *   Christian W. Damus - bug 508629
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.providers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.papyrus.emf.facet.util.emf.core.ModelUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.util.UMLSwitch;


/**
 * An item label provider that delegates to an adapter factory and rewrites the result for UML element labels.
 * If the adapter factory needs to be disposed (which is usually the case for item-provider factories), then
 * this is the responsibility of the client that creates the delegating label provider.
 */
public class DelegatingItemLabelProvider implements IItemLabelProvider, IChangeNotifier, IDisposable {

	public static final int SHOW_LABEL = 0x1;

	public static final int SHOW_METACLASS = 0x2;

	public static final int SHOW_STEREOTYPES = 0x4;

	/** left Stereotype delimiters ('Guillemets francais'). */
	private static String ST_LEFT = "\u00AB"; //$NON-NLS-1$

	/** Right Stereotype delimiters ('Guillemets francais'). */
	private static String ST_RIGHT = "\u00BB"; //$NON-NLS-1$

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
	private static final Pattern UML2_LABEL_PATTERN = Pattern.compile("(?:<<(.+?)>>)?\\s*(<[^<>]+>)?\\s*(.*)");

	private final UMLSwitch<Boolean> showMetaclassSwitch = createShowMetaclassSwitch();

	private final AdapterFactory itemAdapterFactory;

	private final int style;

	private final ChangeNotifier changeNotifier = new ChangeNotifier();
	private INotifyChangedListener changeForwarder;

	/**
	 * Initializes me with my delegate factory and a bit-mask of which label components to allow.
	 *
	 * @param itemAdapterFactory
	 *            my delegate factory
	 * @param style
	 *            mask of {@linkplain #SHOW_LABEL style bits} indicating which components of the label to allow
	 */
	public DelegatingItemLabelProvider(AdapterFactory itemAdapterFactory, int style) {
		super();

		this.itemAdapterFactory = itemAdapterFactory;
		this.style = style;

		if (itemAdapterFactory instanceof IChangeNotifier) {
			changeForwarder = this::fireNotifyChanged;
			((IChangeNotifier) itemAdapterFactory).addListener(changeForwarder);
		}
	}

	/**
	 * Initializes me with my delegate factory. I do not suppress any components of the label.
	 *
	 * @param itemAdapterFactory
	 *            my delegate factory
	 */
	public DelegatingItemLabelProvider(AdapterFactory itemAdapterFactory) {
		this(itemAdapterFactory, SHOW_LABEL | SHOW_METACLASS | SHOW_STEREOTYPES);
	}

	/**
	 * Initializes me with my plug-in's {@linkplain Activator#getItemProviderAdapterFactory() shared adapter factory} as my delegate factory and a
	 * bit-mask of which label components to allow. <em>Note</em> that the shared adapter factory does not need to be disposed.
	 *
	 * @param style
	 *            mask of {@linkplain #SHOW_LABEL style bits} indicating which components of the label to allow
	 */
	public DelegatingItemLabelProvider(int style) {
		this(Activator.getDefault().getItemProviderAdapterFactory(), style);
	}

	/**
	 * Initializes me with my plug-in's {@linkplain Activator#getItemProviderAdapterFactory() shared adapter factory} as my delegate factory. I do not
	 * suppress any components of the label. <em>Note</em> that the shared adapter factory does not need to be disposed.
	 */
	public DelegatingItemLabelProvider() {
		this(Activator.getDefault().getItemProviderAdapterFactory());
	}

	@Override
	public void dispose() {
		if (changeForwarder != null) {
			((IChangeNotifier) itemAdapterFactory).removeListener(changeForwarder);
			changeForwarder = null;
		}
	}

	@Override
	public String getText(Object object) {
		EObject element = EMFHelper.getEObject(object);
		if (element == null) {
			return null;
		}

		// Delegate to UML2 Edit providers to get localized and inferred names where applicable
		IItemLabelProvider provider = getDelegate(element);
		String result = (provider == null) ? ModelUtils.getDefaultName(element) : provider.getText(element);

		if (result != null) {
			// Rewrite the stereotype list and strip the metaclass qualifier, unless there is no label, in which
			// case we leave the metaclass qualifier
			Matcher m = UML2_LABEL_PATTERN.matcher(result);
			if (m.matches()) {
				StringBuilder buf = new StringBuilder();

				String keywords = m.group(1);
				if (isShowStereotypes() && (keywords != null)) {
					buf.append(ST_LEFT).append(keywords).append(ST_RIGHT);
				}

				final String label = m.group(3);
				if (isShowMetaclass() && (UML2Util.isEmpty(label) || shouldShowMetaclass(element))) {
					// Use the metaclass qualifier
					if (buf.length() > 0) {
						buf.append(' ');
					}
					buf.append(m.group(2));
				}

				if (isShowLabel() && !UML2Util.isEmpty(label)) {
					if (buf.length() > 0) {
						buf.append(' ');
					}
					buf.append(label);
				}

				result = buf.toString();
			}
		}

		return result;
	}

	@Override
	public Object getImage(Object object) {
		EObject element = EMFHelper.getEObject(object);
		if (element == null) {
			return null;
		}

		// Delegate to UML2 Edit providers to get localized and inferred names where applicable
		IItemLabelProvider provider = getDelegate(element);
		return (provider == null) ? null : provider.getImage(element);
	}

	public final boolean isShowLabel() {
		return (style & SHOW_LABEL) == SHOW_LABEL;
	}

	public final boolean isShowMetaclass() {
		return (style & SHOW_METACLASS) == SHOW_METACLASS;
	}

	public final boolean isShowStereotypes() {
		return (style & SHOW_STEREOTYPES) == SHOW_STEREOTYPES;
	}

	protected IItemLabelProvider getDelegate(EObject object) {
		return (IItemLabelProvider) itemAdapterFactory.adapt(object, IItemLabelProvider.class);
	}

	protected boolean shouldShowMetaclass(EObject object) {
		return showMetaclassSwitch.doSwitch(object);
	}

	protected UMLSwitch<Boolean> createShowMetaclassSwitch() {
		return new UMLSwitch<Boolean>() {

			@Override
			public Boolean defaultCase(EObject object) {
				return false;
			}

			// By default, show the metaclass for relationships
			@Override
			public Boolean caseRelationship(Relationship object) {
				return true;
			}

			// Except associations
			@Override
			public Boolean caseAssociation(Association object) {
				return false;
			}

			@Override
			public Boolean caseTemplateParameter(TemplateParameter object) {
				return true;
			}

			@Override
			public Boolean caseTemplateSignature(TemplateSignature object) {
				return true;
			}
		};
	}

	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);
	}
}
