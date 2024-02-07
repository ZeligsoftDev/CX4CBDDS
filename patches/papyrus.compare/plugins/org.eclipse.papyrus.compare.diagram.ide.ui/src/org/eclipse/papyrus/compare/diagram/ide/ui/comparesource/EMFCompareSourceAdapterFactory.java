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
package org.eclipse.papyrus.compare.diagram.ide.ui.comparesource;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.compare.ide.ui.source.IEMFComparisonSource;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;

/**
 * The {@link IAdapterFactory} for {@link IEMFComparisonSource}s.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 2.5
 */
@SuppressWarnings({"unchecked", "rawtypes" })
public class EMFCompareSourceAdapterFactory implements IAdapterFactory {

	/**
	 * {@inheritDoc}
	 */
	public Class[] getAdapterList() {
		return new Class[] {IEMFComparisonSource.class };
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (IEMFComparisonSource.class.equals(adapterType)) {
			return new PapyrusFileEMFCompareSourceAdapter((IPapyrusFile)adaptableObject);
		}
		return null;
	}

}
