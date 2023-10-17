/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.Nullable;

public interface Labelable
{
    /**
     * Returns the image for the label of the given element. The image
     * is owned by of on behalf of this object and must not be disposed directly.
     * <p>
     * Returns null if no image available.
     */
	@Nullable Object getImage();
	
	/**
     * Returns the text for a readable label for the given element.
     * <p>
     * Returns null if no text available.
	 */
	@Nullable String getText();
}
