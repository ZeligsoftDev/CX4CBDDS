/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.customization;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.compare.adapterfactory.context.IContextTester;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;

/**
 * The generic descriptor for content merge viewer customizations.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @param <T>
 *            the type of object produced by the descriptor.
 */
public class ContentMergeViewerCustomizationDescriptor<T> {

	/**
	 * Underlying {@link IConfigurationElement} describing this customization.
	 */
	private final IConfigurationElement configurationElement;

	/**
	 * Ranking of this handler.
	 */
	private final int ranking;

	/**
	 * Qualified class name of the provider from this {@link #configurationElement}. Will be used as
	 * identifier.
	 */
	private final String providerClassName;

	private final String providerAttributeName;

	/**
	 * Qualified class name of the context class
	 */
	private final String contextClassName;

	private final String contextAttributeName;

	/**
	 * Don't log the same error multiple times.
	 */
	private boolean logOnce;

	/**
	 * Don't log the same error multiple times.
	 */
	private boolean logOnceContext;

	/**
	 * The provider provided by this descriptor.
	 */
	private T provider;

	/**
	 * The context tester provided by this descriptor.
	 */
	private IContextTester contextTester;

	/**
	 * Default constructor.
	 * 
	 * @param configurationElement
	 *            Configuration element that served to populate this descriptor.
	 * @param contentProviderClass
	 *            The contentProvider which
	 * @param mergeViewerItemProviderClass
	 * @param contextClass
	 * @param ranking
	 *            Ranking of this handler. High-priority handlers take precedence over low-priority ones.
	 */
	ContentMergeViewerCustomizationDescriptor(IConfigurationElement configurationElement,
			String providerClass, String providerAttributeName, String contextClass,
			String contextAttributeName, int ranking) {
		this.configurationElement = checkNotNull(configurationElement);
		this.providerClassName = checkNotNull(providerClass);
		this.contextClassName = contextClass;
		this.ranking = ranking;
		this.providerAttributeName = providerAttributeName;
		this.contextAttributeName = contextAttributeName;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.logical.view.ILogicalModelViewHandler#getRanking()
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * Get the qualified class name of the described provider.
	 * 
	 * @return the qualified class name of the described provider.
	 */
	public String getProviderClassName() {
		return providerClassName;
	}

	/**
	 * Create an instance of this provider.
	 * 
	 * @return a new instance of this provider
	 */
	@SuppressWarnings("unchecked")
	T getProvider() {
		if (provider == null) {
			try {
				provider = (T)configurationElement.createExecutableExtension(providerAttributeName);
			} catch (CoreException e) {
				// Shouldn't happen since the registry listener should have checked that.
				// log anyway.
				if (!logOnce) {
					logOnce = true;
					final String message = EMFCompareRCPUIMessages
							.getString("ContentCustomizationRegistry.invalidProvider", providerClassName); //$NON-NLS-1$
					final IStatus status = new Status(IStatus.ERROR,
							configurationElement.getDeclaringExtension().getContributor().getName(), message,
							e);
					EMFCompareRCPUIPlugin.getDefault().getLog().log(status);
				}
			}
		}
		return provider;
	}

	/**
	 * Create an instance of this tester.
	 * 
	 * @return a new instance of this tester.
	 */
	IContextTester getContextTester() {
		if (contextClassName != null && contextTester == null) {
			try {
				contextTester = (IContextTester)configurationElement
						.createExecutableExtension(contextAttributeName);
			} catch (CoreException e) {
				// Shouldn't happen since the registry listener should have checked that.
				// log anyway.
				if (!logOnceContext) {
					logOnceContext = true;
					final String message = EMFCompareRCPUIMessages
							.getString("ContentCustomizationRegistry.invalidContextTester", contextClassName); //$NON-NLS-1$
					final IStatus status = new Status(IStatus.ERROR,
							configurationElement.getDeclaringExtension().getContributor().getName(), message,
							e);
					EMFCompareRCPUIPlugin.getDefault().getLog().log(status);
				}
			}
		}
		return contextTester;
	}
}
