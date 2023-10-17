/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.pivot/model/Pivot.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.pivot.internal.lookup.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;

import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;
import org.eclipse.ocl.pivot.internal.lookup.impl.LookupEnvironmentImpl;

public class PivotSingleResultLookupEnvironment extends LookupEnvironmentImpl   {

	private @NonNull Executor executor;
	private @NonNull String name;
	private @NonNull EClass typeFilter;
	private @Nullable PivotLookupFilter expFilter;

	public PivotSingleResultLookupEnvironment(@NonNull Executor executor, @NonNull EClass typeFilter, @NonNull String name,  @Nullable PivotLookupFilter expFilter) {
		this.executor = executor;
		this.name = name;
		this.typeFilter = typeFilter;
		this.expFilter = expFilter;
	}

	public PivotSingleResultLookupEnvironment(@NonNull Executor executor, @NonNull EClass typeFilter, @NonNull String name) {
		this(executor,typeFilter, name, null);
	}

	@Override
	@NonNull
	public Executor getExecutor() {
		return executor;
	}

	@Override
	public boolean hasFinalResult() {
		for (NamedElement element : getNamedElements()) {
			if (name.equals(element.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	@NonNull
	public LookupEnvironment addElement(@Nullable NamedElement namedElement) {
		if (namedElement != null) {
			if (name.equals(namedElement.getName())) {
				if (typeFilter.isInstance(namedElement)) {
				    PivotLookupFilter expFilter2 = expFilter;
					if (expFilter2 == null || expFilter2.matches(namedElement)) {
						List<NamedElement> elements = getNamedElements();
						if (!elements.contains(namedElement)) { 	// FIXME use a set ?
							elements.add(namedElement);
						}
					}
				}
			}
		}
		return this;
	}

	@Override
	@NonNull
	public <NE extends NamedElement > LookupEnvironment addElements(
			@Nullable Collection<NE> namedElements) {

		if (namedElements != null) {
			for (NamedElement namedElement : namedElements) {
				addElement(namedElement);
			}
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public <NE extends NamedElement> List<NE> getNamedElementsByKind(Class<NE> class_) {
		List<NE> result = new ArrayList<NE>();
		for (NamedElement namedElement : getNamedElements()) {
			if (class_.isAssignableFrom(namedElement.getClass())) {
				result.add((NE)namedElement);
			}
		}
		return result;
	}
}
