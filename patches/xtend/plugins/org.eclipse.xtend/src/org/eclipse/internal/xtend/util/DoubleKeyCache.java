/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xtend.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class DoubleKeyCache<K1, K2, V> {

    protected abstract V createNew(K1 key1, K2 key2);

    private final Map <Pair <K1, K2>, V> internal = new HashMap <Pair <K1, K2>, V>();

    public V get (K1 key1, K2 key2) {
        final Pair<K1, K2> key = new Pair <K1, K2> (key1, key2);
        
        if (internal.containsKey (key))
            return internal.get (key);
        final V r = createNew (key1, key2);
        internal.put(key, r);
        return r;
    }

    public Collection<V> getValues() {
        return internal.values();
    }

}
