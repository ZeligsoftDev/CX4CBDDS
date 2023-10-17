/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *   E.D.Willink - Bug 353171
 *   Christian W. Damus (CEA LIST) - Bug 434554
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.delegate.VirtualDelegateMapping;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * DelegateEPackageAdapter extends an EPackage to cache its DelegateDomain
 * that supervises installation of OCL annotations from an OCL document.
 */
public class DelegateEPackageAdapter extends AdapterImpl
{
	/**
	 *	Return the DelegateEPackageAdapter for ePackage, if there is one, or null if none.
	 */
	public static @Nullable DelegateEPackageAdapter findAdapter(@NonNull EPackage ePackage) {
		return (DelegateEPackageAdapter) EcoreUtil.getAdapter(ePackage.eAdapters(), DelegateEPackageAdapter.class);
	}

	/**
	 *	Return the DelegateEPackageAdapter for ePackage, creating
	 *	one if necessary.
	 */
	public static @NonNull DelegateEPackageAdapter getAdapter(@NonNull EPackage ePackage) {
		DelegateEPackageAdapter adapter;
		EList<Adapter> eAdapters = ePackage.eAdapters();
		synchronized (eAdapters) {
			adapter = (DelegateEPackageAdapter) EcoreUtil.getAdapter(eAdapters, DelegateEPackageAdapter.class);
			if (adapter == null) {
				adapter = new DelegateEPackageAdapter();
				eAdapters.add(adapter);
			}
		}
		return adapter;
	}

	/**
	 * The map from delegateURI to known DelegateDomain. Mappings are established
	 * lazily by {@link #getDelegateDomain}.
	 */
	protected /*@LazyNonNull*/ Map<String, DelegateDomain> delegateDomainMap = null;

	protected @NonNull DelegateDomain createDelegateDomain(@NonNull String delegateURI) {
		EPackage ePackage = ClassUtil.nonNullState(getTarget());
		Class<DelegateDomain.Factory.@NonNull Registry> castClass = DelegateDomain.Factory.Registry.class;
		DelegateDomain.Factory.@NonNull Registry registry = OCLDelegateDomain.getDelegateResourceSetRegistry(ePackage, castClass, DelegateDomain.Factory.Registry.INSTANCE);
		DelegateDomain.Factory factory = registry.getFactory(delegateURI);
		if (factory == null) {
			factory = OCLDelegateDomainFactory.INSTANCE;
		}
		return factory.createDelegateDomain(delegateURI, ePackage);
	}

	/**
	 * Return all registered delegate domains.
	 */
	public @NonNull Collection<DelegateDomain> getAllDelegateDomains() {
		if (delegateDomainMap == null) {
			getDelegateDomains();
		}
		return delegateDomainMap.values();
	}

	/**
	 * Return the DelegateDomain for this package and for delegateURI, returning null it does not exist. 
	 */
	public @Nullable DelegateDomain getDelegateDomain(@NonNull String delegateURI) {
		if (delegateDomainMap == null) {
			getDelegateDomains();
		}
		return delegateDomainMap.get(delegateURI);
	}

	public synchronized @NonNull Map<String, DelegateDomain> getDelegateDomains() {
		Map<String, DelegateDomain> delegateDomainMap2 = delegateDomainMap;
		if (delegateDomainMap2 == null) {
			delegateDomainMap = delegateDomainMap2 = new HashMap<String, DelegateDomain>();
			EPackage ePackage = getTarget();
			EAnnotation eAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
			if (eAnnotation != null) {
				VirtualDelegateMapping registry = VirtualDelegateMapping.getRegistry(ePackage);
				EMap<String, String> details = eAnnotation.getDetails();
				for (DelegatedBehavior<?, ?, ?> delegatedBehavior : AbstractDelegatedBehavior.getDelegatedBehaviors()) {
					String behaviorName = delegatedBehavior.getName();
					String delegateURIs = details.get(behaviorName);
					if (delegateURIs != null) {
						for (StringTokenizer stringTokenizer = new StringTokenizer(delegateURIs); stringTokenizer.hasMoreTokens();) {
							@SuppressWarnings("null")@NonNull String delegateURI = stringTokenizer.nextToken();
							@SuppressWarnings("null")@NonNull String resolvedURI = registry.resolve(delegateURI);
							loadDelegateDomain(resolvedURI);
						}
					}
				}
			}
		}
		return delegateDomainMap2;
	}

	@Override
	public EPackage getTarget() {
		return (EPackage) super.getTarget();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DelegateEPackageAdapter.class;
	}

	/**
	 * Return the DelegateDomain for this package and for delegateURI, creating one if it does not already exist. 
	 */
	public @NonNull DelegateDomain loadDelegateDomain(@NonNull String delegateURI) {
		if (delegateDomainMap == null) {
			getDelegateDomains();
		}
		DelegateDomain delegateDomain = delegateDomainMap.get(delegateURI);
		if (delegateDomain == null) {
			synchronized (delegateDomainMap) {
				delegateDomain = delegateDomainMap.get(delegateURI);
				if (delegateDomain == null) {
					delegateDomain = createDelegateDomain(delegateURI);
					delegateDomainMap.put(delegateURI, delegateDomain);
				}
			}
		}
		return delegateDomain;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		EPackage resourceSet = (EPackage) newTarget;
		super.setTarget(resourceSet);
	}

	public void unloadDelegates() {
		if (delegateDomainMap != null) {
			List<DelegateDomain> delegateDomains;
			synchronized (delegateDomainMap) {
				delegateDomains = new ArrayList<DelegateDomain>(delegateDomainMap.values());
//				delegateDomainMap.clear(); -- don't clear else tests fail since registrations do not occur
			}
			for (DelegateDomain delegateDomain : delegateDomains) {
				delegateDomain.reset();
			}
		}
	}
	
	@Override
	public void unsetTarget(Notifier oldTarget) {
		super.unsetTarget(oldTarget);
		unloadDelegates();
	}
}
