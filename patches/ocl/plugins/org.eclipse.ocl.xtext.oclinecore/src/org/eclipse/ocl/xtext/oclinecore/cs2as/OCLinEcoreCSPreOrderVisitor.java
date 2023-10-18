/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.oclinecorecs.util.AbstractOCLinEcoreCSPreOrderVisitor;

public class OCLinEcoreCSPreOrderVisitor extends AbstractOCLinEcoreCSPreOrderVisitor
{
	public OCLinEcoreCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}
}