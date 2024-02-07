/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;

/**
 * LiveInstances assists in debugging memory leaks by reporting creation/deletion/exuistence of selected class instances.
 */
public class LiveInstances<@NonNull T>
{
	protected final Class<T> liveClass;
	private Map<T,Object> instances = new WeakHashMap<T, Object>();
	
	public LiveInstances(Class<T> liveClass) {
		this.liveClass = liveClass;
	}

	public void add(T anInstance) {
		instances.put(anInstance, null);
		System.out.println(Thread.currentThread().getName() + " Add " + liveClass.getSimpleName() + "@" + Integer.toHexString(anInstance.hashCode()));		
	}

	public void remove(T anInstance) {
		instances.remove(anInstance);
		System.out.println(Thread.currentThread().getName() + " Remove " + liveClass.getSimpleName() + "@" + Integer.toHexString(anInstance.hashCode()));		
	}

	public void show() {
		if (instances.isEmpty()) {
			System.out.println("No " + liveClass.getSimpleName() + " instances live");		
		}
		else {
			StringBuilder s = new StringBuilder();
			s.append("Live instances of " + liveClass.getSimpleName());
			for (T instance : instances.keySet()) {
				s.append("\n\t");
				s.append("@" + Integer.toHexString(instance.hashCode()));
			}
			System.out.println(s.toString());		
		}
	}
}