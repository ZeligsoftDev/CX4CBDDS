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
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class PivotLookupResultImpl<NE> implements PivotLookupResult<NE> {

	private @NonNull List<NE> results = new ArrayList<NE>();

	public PivotLookupResultImpl(List<NE> results){
		this.results.addAll(results);
	}

	@Override
	public @NonNull List<NE> getAllResults() {
		return Collections.unmodifiableList(results);
	}

	@Override
	public @Nullable NE getSingleResult() {
		return results.size() == 0 ? null : results.get(0);
	}

	@Override
	public int size() {
		return results.size();
	}
}
