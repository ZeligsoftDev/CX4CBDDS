/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.hook.AbstractResourceSetHooks;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;

/**
 * Hook in the EMF Compare {@link org.eclipse.emf.ecore.resource.ResourceSet} in order to make it able to
 * handle papyrus CSS features.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class CssInstallationHook extends AbstractResourceSetHooks {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.internal.utils.IResourceSetHook#handle(java.lang.Iterable)
	 */
	@Override
	public boolean isHookFor(Collection<? extends URI> uris) {
		// Looks for a papyrus notation file.
		for (URI uri : uris) {
			// FIXME this is a realy weak test. We can not use the
			// triple of papyrus file "x.di", "x.notation" and "x.uml" since one or more of these files might
			// not be part of the uri list. This might change soon since we might need to force loading uml if
			// the notation file is loaded see https://bugs.eclipse.org/bugs/show_bug.cgi?id=443187.
			if ("notation".equals(uri.fileExtension())) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.hook.AbstractResourceSetHooks#preLoadingHook(org.eclipse.emf.ecore.resource.ResourceSet,
	 *      java.util.Collection)
	 */
	@Override
	public void preLoadingHook(ResourceSet resourceSet, Collection<? extends URI> uris) {
		if (!CSSHelper.isCSSSupported(resourceSet)) {
			CSSHelper.installCSSSupport(resourceSet);
		}
	}

}
