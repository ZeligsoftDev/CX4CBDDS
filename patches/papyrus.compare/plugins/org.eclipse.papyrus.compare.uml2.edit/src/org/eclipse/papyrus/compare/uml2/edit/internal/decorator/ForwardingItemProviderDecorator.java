/*******************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Christian W. Damus - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.edit.internal.decorator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.compare.provider.ExtendedItemProviderDecorator;
import org.eclipse.emf.compare.provider.IItemDescriptionProvider;
import org.eclipse.emf.compare.provider.IItemStyledLabelProvider;
import org.eclipse.emf.compare.provider.ISemanticObjectLabelProvider;
import org.eclipse.emf.compare.provider.utils.ComposedStyledString;
import org.eclipse.emf.compare.provider.utils.IStyledString.IComposedStyledString;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.papyrus.compare.uml2.edit.Activator;

/**
 * A simple forwarding item-provider decorator that implements all of the optional provider interfaces.
 */
public class ForwardingItemProviderDecorator extends ExtendedItemProviderDecorator implements IEditingDomainItemProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider, IItemStyledLabelProvider, IItemDescriptionProvider, ISemanticObjectLabelProvider {

	/**
	 * Initializes me with my adapter factory.
	 * 
	 * @param adapterFactory
	 *            my adapter factory
	 */
	public ForwardingItemProviderDecorator(ComposeableAdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getSemanticObjectLabel(Object object) {
		if (decoratedItemProvider instanceof ISemanticObjectLabelProvider) {
			return ((ISemanticObjectLabelProvider)decoratedItemProvider).getSemanticObjectLabel(object);
		}

		return null;
	}

	public String getDescription(Object object) {
		if (decoratedItemProvider instanceof IItemDescriptionProvider) {
			return ((IItemDescriptionProvider)decoratedItemProvider).getDescription(object);
		}

		return getText(object);
	}

	public IComposedStyledString getStyledText(Object object) {
		if (decoratedItemProvider instanceof IItemStyledLabelProvider) {
			return ((IItemStyledLabelProvider)decoratedItemProvider).getStyledText(object);
		}

		String text = getText(object);
		if (text != null) {
			return new ComposedStyledString(text);
		}

		return null;
	}

	protected String getString(String key) {
		return Activator.getDefault().getResourceLocator().getString(key);
	}

	protected String getString(String key, boolean translate) {
		return Activator.getDefault().getResourceLocator().getString(key, translate);
	}

	protected String getString(String key, Object[] substitutions) {
		return Activator.getDefault().getResourceLocator().getString(key, substitutions);
	}

	protected String getString(String key, Object[] substitutions, boolean translate) {
		return Activator.getDefault().getResourceLocator().getString(key, substitutions, translate);
	}

	protected Object overlayImage(Object object, Object image) {
		Object result = image;

		if (AdapterFactoryEditingDomain.isControlled(object)) {
			List<Object> images = new ArrayList<Object>(2);
			images.add(image);
			images.add(EMFEditPlugin.INSTANCE.getImage("full/ovr16/ControlledObject")); //$NON-NLS-1$
			result = new ComposedImage(images);
		}

		return result;
	}

}
