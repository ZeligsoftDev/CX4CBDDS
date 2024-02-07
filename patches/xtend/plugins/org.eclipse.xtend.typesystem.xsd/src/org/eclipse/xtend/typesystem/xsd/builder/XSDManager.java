/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.builder;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface XSDManager {

	public static class UtilImpl {
		public XSDManager createManager() {
			return new OawXSDResourceSet();
		}

		public XSDManager createView(XSDManager parent) {
			return new XSDManagerView((OawXSDResourceSet) parent);
		}
	}

	public static final UtilImpl Util = new UtilImpl();

	public void clear();

	public EPackage.Registry getPackageRegistry();

	public List<EPackage> getPackages();

	public boolean hasErrors();

	public boolean isEmpty();

	public void loadAndGenerate(URI uri);

	public void markDirty(URI uri);

	public void registerPackage(EPackage pkg);

	public void reloadDirty(ProgressMonitor pm);

	public void remove(URI uri);

	public void unregisterPackage(EPackage pkg);
}