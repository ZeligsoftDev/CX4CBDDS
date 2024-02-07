/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations, University of York and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Adolfo Sanchez-Barbudo Herrera (University of York)
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.internal.resource.AbstractASSaver;

/**
 * @since 1.1
 * @noextend This class is not intended to be subclassed by clients. It is part of the hierarchy for auto-generated visitors.
 */
public class PivotASSaverNormalizeVisitor extends ASSaverNormalizeVisitor
{
	/**
	 * @since 1.18
	 */
	public PivotASSaverNormalizeVisitor(@NonNull AbstractASSaver context) {
		super(context);
	}

	@Deprecated /* @deprecated Replaced by safer EcoreUtil.Copier/CrossReferencer functionality */
	public PivotASSaverNormalizeVisitor(@NonNull ASSaver context) {
		this((AbstractASSaver)context);
	}
}
