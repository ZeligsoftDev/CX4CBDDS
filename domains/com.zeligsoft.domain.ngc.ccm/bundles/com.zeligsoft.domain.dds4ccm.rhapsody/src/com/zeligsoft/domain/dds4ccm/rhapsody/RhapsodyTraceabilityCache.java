/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.rhapsody;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import org.eclipse.uml2.uml.Element;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;

/**
 * @author prismtech
 *
 */
public class RhapsodyTraceabilityCache implements Cache<String, Element> {
	final ConcurrentMap<String, Element> map;
	
	public RhapsodyTraceabilityCache() {
		map = Maps.newConcurrentMap();
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#get(java.lang.Object)
	 */
	@Override
	public Element get(String key) throws ExecutionException {
		return map.get(key);
	}
	
	public void put(String key, Element cached) {
		Preconditions.checkNotNull(key);
		Preconditions.checkNotNull(cached);
		
		map.put(key, cached);
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#getUnchecked(java.lang.Object)
	 */
	@Override
	public Element getUnchecked(String key) {
		try {
	      return get(key);
	    } catch (ExecutionException e) {
	      throw new UncheckedExecutionException(e.getCause());
	    }
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#apply(java.lang.Object)
	 */
	@Override
	public Element apply(String key) {
		return getUnchecked(key);
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#invalidate(java.lang.Object)
	 */
	@Override
	public void invalidate(Object key) {
		Preconditions.checkNotNull(key);
		map.remove(key);
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#invalidateAll()
	 */
	@Override
	public void invalidateAll() {
		map.clear();
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#size()
	 */
	@Override
	public long size() {
		return map.size();
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#stats()
	 */
	@Override
	public CacheStats stats() {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#asMap()
	 */
	@Override
	public ConcurrentMap<String, Element> asMap() {
		return map;
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#cleanUp()
	 */
	@Override
	public void cleanUp() {
		map.clear();
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#get(java.lang.Object, java.util.concurrent.Callable)
	 */
	@Override
	public Element get(String key, Callable<? extends Element> valueLoader)
			throws ExecutionException {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#getAllPresent(java.lang.Iterable)
	 */
	@Override
	public ImmutableMap<String, Element> getAllPresent(
			Iterable<? extends String> keys) {
	    Map<String, Element> result = Maps.newLinkedHashMap();
	    for (String key : keys) {
	      if (!result.containsKey(key)) {
	        result.put(key, getIfPresent(key));
	      }
	    }
	    return ImmutableMap.copyOf(result);
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#invalidateAll(java.lang.Iterable)
	 */
	@Override
	public void invalidateAll(Iterable<?> keys) {
		for (Object key : keys) {
	      invalidate(key);
	    }
	}

	/* (non-Javadoc)
	 * @see com.google.common.cache.Cache#getIfPresent(java.lang.Object)
	 */
	@Override
	public Element getIfPresent(String key) {
		try {
			return get(key);
		} catch (ExecutionException e) {
			return null;
		}
	}
}
