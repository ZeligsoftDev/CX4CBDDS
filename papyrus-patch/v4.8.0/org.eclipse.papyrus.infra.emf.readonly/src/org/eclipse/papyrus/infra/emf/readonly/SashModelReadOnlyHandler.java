/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;

import com.google.common.base.Optional;

/**
 * A ReadOnlyHandler for the Sash Model (*.sash or *.di).
 *
 * If the model is located in the user preferences space, it may be considered
 * read-only by other read-only handlers, whereas it shouldn't.
 *
 * Its priority should be greater than EMFReadOnlyHandler, FSReadOnlyHandler and ...
 *
 * This handler is discretion-based.
 *
 * @author Camille Letavernier
 *
 */
public class SashModelReadOnlyHandler extends AbstractReadOnlyHandler {

	private ModelSet modelSet;

	public SashModelReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);

		if (getEditingDomain().getResourceSet() instanceof ModelSet) {
			modelSet = (ModelSet) getEditingDomain().getResourceSet();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		if ((modelSet == null) || !axes.contains(ReadOnlyAxis.DISCRETION)) {
			return Optional.absent();
		}

		// Only answer false if all of the resources in question are ones that we know must be allowed to be written
		int knownWritableCount = 0;
		for (URI uri : uris) {
			if (SashModel.SASH_MODEL_FILE_EXTENSION.equals(uri.fileExtension()) || DiModel.DI_FILE_EXTENSION.equals(uri.fileExtension())) {
				knownWritableCount++;
			}
		}

		return (knownWritableCount == uris.length) ? Optional.of(false) : Optional.<Boolean> absent();
	}

	/**
	 * {@inheritDoc}
	 */
	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		return Optional.absent(); // If the file is read-only, it can probably made writable by other read-only handlers (e.g. FSReadOnlyHandler).
	}



}
