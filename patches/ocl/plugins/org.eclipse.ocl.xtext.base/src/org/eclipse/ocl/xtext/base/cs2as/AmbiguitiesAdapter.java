/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;

public class AmbiguitiesAdapter extends ExceptionAdapter
{
	/**
	 * If ambiguities is non-null install an AmbiguitiesAdapter for them on eObject.
	 * Otherwise of null, remove any pre-existing AmbiguitiesAdapter on eObject.
	 */
	public static void setAmbiguities(@NonNull EObject eObject, @Nullable List<@NonNull ? extends EObject> ambiguities) {
		List<Adapter> eAdapters = eObject.eAdapters();
		for (Adapter eAdapter : eAdapters) {
			if (eAdapter instanceof AmbiguitiesAdapter) {
				if (ambiguities == null) {
					eAdapters.remove(eAdapter);
				}
				else {
					((AmbiguitiesAdapter)eAdapter).eObjects = ambiguities;
				}
				return;
			}
		}
		if (ambiguities != null) {
			eAdapters.add(new AmbiguitiesAdapter(ambiguities));
		}
	}

	protected @NonNull List<@NonNull ? extends EObject> eObjects;

	protected AmbiguitiesAdapter(@NonNull List<@NonNull ? extends EObject> eObjects) {
		super(null);
		this.eObjects = new ArrayList<>(eObjects);
	}

	@Override
	public String getErrorMessage() {
		return toString();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Ambiguous resolution:");
		for (EObject eObject : eObjects) {
			s.append("\n\t");
			s.append(eObject.eClass().getName());
			s.append(" : ");
			s.append(eObject);
			if (eObject instanceof Property) {
				Property asOpposite = ((Property)eObject).getOpposite();
				if (asOpposite != null) {
					s.append(" # ");
					s.append(asOpposite);
				}
			}
		}
		return s.toString();
	}
}