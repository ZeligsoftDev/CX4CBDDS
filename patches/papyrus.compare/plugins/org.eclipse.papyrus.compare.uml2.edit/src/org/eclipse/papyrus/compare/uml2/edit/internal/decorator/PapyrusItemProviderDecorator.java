/*******************************************************************************
 * Copyright (c) 2017 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.edit.internal.decorator;

import org.eclipse.emf.compare.provider.ExtendedItemProviderDecorator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.compare.uml2.edit.Activator;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * Decorator that reuses the label provider of Papyrus.
 * 
 * @see org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService
 * @author <a href="mailto:mfleck@eclipsesource.com">Martin Fleck</a>
 */
public class PapyrusItemProviderDecorator extends ExtendedItemProviderDecorator implements IEditingDomainItemProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider {

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory
	 *            the adapter factory to be used by the label providers.
	 */
	public PapyrusItemProviderDecorator(ComposeableAdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		LabelProviderService labelProviderService = Activator.getDefault().getLabelProviderService();
		if (labelProviderService != null) {
			ILabelProvider labelProvider = labelProviderService.getLabelProvider(object);
			if (labelProvider != null) {
				return labelProvider.getText(object);
			}
		}
		return super.getText(object);
	}

	@Override
	public Object getImage(Object object) {
		LabelProviderService labelProviderService = Activator.getDefault().getLabelProviderService();
		if (labelProviderService != null) {
			ILabelProvider labelProvider = labelProviderService.getLabelProvider(object);
			if (labelProvider != null) {
				return labelProvider.getImage(object);
			}
		}
		return super.getImage(object);
	}
}
