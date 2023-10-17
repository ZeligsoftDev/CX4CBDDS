/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

/**
 * A CSI (Concrete Syntax Identifier) provides an identifier for a CSResource or contained element
 * based on hierarchical name and position. The CSI is therefore relatively stable  and so may be
 * used to correlate corresponding elements in the distinct CSResources before and after an
 * Xtext editor update. The CSI2ASMapping users these identifiers to synchronize evolving
 * CSResources with a stable ASREsouce.
 */
public interface CSI
{
}
