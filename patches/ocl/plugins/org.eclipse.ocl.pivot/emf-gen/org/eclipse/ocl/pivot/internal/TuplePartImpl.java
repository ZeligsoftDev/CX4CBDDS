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
package org.eclipse.ocl.pivot.internal;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * @deprecated use PropertyImpl
 * -- if we want a TuplePart it must be modelled to be loadable from XMI
 */
@Deprecated
public class TuplePartImpl
extends PropertyImpl {

	protected TuplePartImpl() {
		super();
	}

	private TuplePartId partId;

	public TuplePartImpl(@NonNull TuplePartId partId, @NonNull Type partType) {
		this.partId = partId;
		setName(NameUtil.getSafeName(partId));
		setType(partType);
	}

	public @NonNull TuplePartId getTuplePartId() {
		TuplePartId partId2 = partId;
		if (partId2 == null) {
			partId = partId2 = IdManager.getTuplePartId(this);
		}
		return partId2;
	}
} //TupleImpl
