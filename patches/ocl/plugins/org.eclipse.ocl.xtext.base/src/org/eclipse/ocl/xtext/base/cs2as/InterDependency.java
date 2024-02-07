/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class InterDependency<@NonNull T> extends AbstractDependency<@NonNull Object>
{
	private @Nullable Dependency dependency;
	private List<@NonNull T> dependencies = new ArrayList<>();
	private List<@NonNull T> satisfied = new ArrayList<>();

	public InterDependency(@NonNull String reason, @Nullable Dependency dependency) {
		super(reason);
		this.dependency = dependency;
	}

	public void addDependency(T dependency) {
		assert satisfied.isEmpty();
		assert !dependencies.contains(dependency);
		dependencies.add(dependency);
	}

	@Override
	public boolean canExecute() {
		if ((dependency != null) && !dependency.canExecute()) {
			return false;
		}
		return satisfied.size() >= dependencies.size();
	}

	public void setSatisfied(T dependency) {
		assert dependencies.contains(dependency);
		assert !satisfied.contains(dependency);
		satisfied.add(dependency);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		if ((dependency != null) && !dependency.canExecute()) {
			s.append(" BLOCKED");
		}
		s.append(" ");
		s.append(satisfied.size());
		s.append("/");
		s.append(dependencies.size());
		return s.toString();
	}
}