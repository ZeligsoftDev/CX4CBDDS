/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * An AliasAdapter extends a Resource to provide a set of aliases for elements,
 * typically packages, contained within that Resource. Use of an alias as the moniker
 * for a package simplifies the moniker and avoids prefix variation for monikers
 * computed for alternate domains.
 */
public class AliasAdapter extends AdapterImpl
{
	public static interface Creator
	{
		Map<EObject, String> computeAliasMap(Resource resource);
		void refreshAliases(Resource resource);
		void refreshAliases(Collection<? extends Resource> resources);
		String getAlias(EObject eObject);
		EObject getAliasTarget(EObject eObject);
	}


	public static AliasAdapter findAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		return ClassUtil.getAdapter(AliasAdapter.class, resource);
	}

	public static AliasAdapter getAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(resource.eAdapters());
		AliasAdapter adapter = ClassUtil.getAdapter(AliasAdapter.class, eAdapters);
		if (adapter == null) {
			adapter = new AliasAdapter();
			eAdapters.add(adapter);
		}
		return adapter;
	}

	public static String getAlias(EObject eElement) {
		String alias = null;
		AliasAdapter adapter = AliasAdapter.findAdapter(eElement.eResource());
		if (adapter != null) {
			alias = adapter.getAliasMap().get(eElement);
		}
		return alias;
	}

	private Map<EObject, String> aliasMap = new HashMap<EObject, String>();

	public Map<EObject, String> getAliasMap() {
		return aliasMap;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == AliasAdapter.class;
	}
}