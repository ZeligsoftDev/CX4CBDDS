/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

/**
 * The ICSI2ASMapping maintains the mapping between CS elements or rather their CSIs
 * that remain stable after recreation and the AS elements. This mapping may be used
 * repeatedly while editing (CS2AS conversions) to associate changing CS elements with
 * stable Pivot elements.
 * The mapping is also created during a AS2CS conversion to allow subsequent CS2AS
 * conversions to reuse the original AS elements.  
 */
public interface ICSI2ASMapping
{
	void dispose();
}
