/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public interface Property extends Callable, Feature {
    Object get(Object target);

    void set(Object target, Object newValue);
}
