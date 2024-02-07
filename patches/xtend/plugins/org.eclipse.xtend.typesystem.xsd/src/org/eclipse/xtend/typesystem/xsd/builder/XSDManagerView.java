/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XSDManagerView implements XSDManager {

	private static int counter = 0;
	private int id = counter++;
	private OawXSDResourceSet manager;
	private Set<EPackage> packages = new HashSet<EPackage>();
	private Set<URI> uris = new HashSet<URI>();

	public XSDManagerView(OawXSDResourceSet manager) {
		super();
		this.manager = manager;
	}

	public void clear() {
		for (URI uri : uris)
			manager.remove(uri);
		uris.clear();
		packages.clear();
	}

	public Registry getPackageRegistry() {
		return manager.getPackageRegistry();
	}

	public List<EPackage> getPackages() {
		ArrayList<EPackage> r = new ArrayList<EPackage>();
		r.addAll(packages);
		r.addAll(manager.getPackages(uris));
		return r;
	}

	public boolean hasErrors() {
		return manager.hasErrors();
	}

	public boolean isEmpty() {
		System.out.println("XSManager" + id + " isempty:" + packages + ", "
				+ uris);
		return packages.isEmpty() && uris.isEmpty();
	}

	public void loadAndGenerate(URI uri) {
		uris.add(uri);
		manager.loadAndGenerate(uri);
	}

	public void markDirty(URI uri) {
		uris.add(uri);
		manager.markDirty(uri);
	}

	public void registerPackage(EPackage pkg) {
		packages.add(pkg);
		manager.registerPackage(pkg);
	}

	public void reloadDirty(ProgressMonitor pm) {
		manager.reloadDirty(pm);
	}

	public void remove(URI uri) {
		uris.remove(uri);
		manager.remove(uri);
	}

	@Override
	public String toString() {
		ArrayList<String> i = new ArrayList<String>();
		for (EPackage pkg : getPackages()) {
			if (pkg != null)
				i.add(pkg.getName());
			else
				i.add("(null!)");
		}
		return getClass().getSimpleName() + id + "-" + manager.getID()
				+ i.toString();
	}

	public void unregisterPackage(EPackage pkg) {
		packages.add(pkg);
		manager.unregisterPackage(pkg);
	}
}
