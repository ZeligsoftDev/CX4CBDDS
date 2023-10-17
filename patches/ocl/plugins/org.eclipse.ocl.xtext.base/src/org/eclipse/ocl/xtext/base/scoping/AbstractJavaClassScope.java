/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.scoping;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * An AbstractJavaClassScope provides the abstract support for ClassName lookup in the base plugin. The real
 * lookup is only appropriate for OCLstdlib where the derived JavaClassScope resides.
 */
public abstract class AbstractJavaClassScope extends AbstractScope implements Adapter
{
	public static @Nullable AbstractJavaClassScope findAdapter(@NonNull BaseCSResource csResource) {
		return ClassUtil.getAdapter(AbstractJavaClassScope.class, csResource);
	}

	private Notifier target;

	protected AbstractJavaClassScope() {
		super(IScope.NULLSCOPE, false);
	}

	public abstract void addClassLoaders(@NonNull Iterable<@NonNull ClassLoader> classLoaders);

	public abstract void getAdapter(@NonNull BaseCSResource importedResource);

	@Override
	public Notifier getTarget() {
		return target;
	}

	public abstract void installContents(@NonNull BaseCSResource csResource);

	@Override
	public boolean isAdapterForType(Object type) {
		return type == AbstractJavaClassScope.class;
	}

	@Override
	public void notifyChanged(Notification notification) {}

	@Override
	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
