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
package org.eclipse.ocl.pivot.util;

/**
 * @since 1.1
 * @noextend This class is not intended to be subclassed by clients. It is part of the hierarchy for auto-generated visitors.
 */
public abstract class AbstractExtendingPivotVisitor<R, C>  extends AbstractExtendingVisitor<R, C>{

	protected AbstractExtendingPivotVisitor(C context) {
		super(context);
	}
}
