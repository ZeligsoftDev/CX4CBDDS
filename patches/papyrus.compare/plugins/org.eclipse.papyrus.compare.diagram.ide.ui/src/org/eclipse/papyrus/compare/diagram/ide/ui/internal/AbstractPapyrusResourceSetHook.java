/*****************************************************************************
 * Copyright (c) 2016 EclipseSource Services GmbH and others.
 * *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Philip Langer (EclipseSource) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal;

import com.google.common.collect.ImmutableSet;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.hook.AbstractResourceSetHooks;
import org.eclipse.papyrus.compare.diagram.ide.ui.util.ModelExtensionUtil;

/**
 * Abstract resource set hook that is activated for Papyrus files.
 * 
 * @author Philip Langer <planger@eclipsesource.com>
 * @since 2.5
 */
public abstract class AbstractPapyrusResourceSetHook extends AbstractResourceSetHooks {

	/**
	 * File extensions registered in Papyrus.
	 */
	protected final Set<String> fileExtensions = ImmutableSet
			.copyOf(ModelExtensionUtil.getRegisteredFileExtensions());

	/**
	 * Hooks in when any of the file extensions registered in Papyrus are loaded. {@inheritDoc}
	 */
	@Override
	public boolean isHookFor(final Collection<? extends URI> uris) {
		for (final URI uri : uris) {
			if (fileExtensions.contains(uri.fileExtension())) {
				return true;
			}
		}
		return false;
	}
}
