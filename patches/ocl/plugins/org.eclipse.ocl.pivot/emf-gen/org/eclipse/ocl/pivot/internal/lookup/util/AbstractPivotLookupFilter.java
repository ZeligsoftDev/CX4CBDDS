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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;

/**
 *
 */
public abstract class AbstractPivotLookupFilter<C extends NamedElement> implements PivotLookupFilter {

	@NonNull private Class<C> _class;

	public AbstractPivotLookupFilter(@NonNull Class<C> _class) {
		this._class = _class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean matches(@NonNull NamedElement namedElement) {
		return _class.isInstance(namedElement) && _matches((C)namedElement);
	}

	abstract protected Boolean _matches(@NonNull C element);
}
