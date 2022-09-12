/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.base.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

/**
 * A URI converter that enhances normalization to optimize <tt>../</tt>
 * segments immediately following a URI mapping prefix.
 * 
 * @author Christian W. Damus (Zeligsoft)
 * @author Young-Soo Roh - issue# 416
 */
public class ZeligsoftURIConverter {

	/** The segment navigating to a parent path in the hierarchical URI. */
	private static final String PARENT = ".."; //$NON-NLS-1$

	/** The segment navigating to the same path in the hierarchical URI. */
	private static final String SELF = "."; //$NON-NLS-1$

	private static final Class<?>[] URI_CONVERTER = {URIConverter.class};
	
	private static final Method NORMALIZE;

	static {
		try {
			NORMALIZE = URIConverter.class.getDeclaredMethod(
				"normalize", new Class[]{URI.class}); //$NON-NLS-1$
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * Cannot be instantiated by clients.
	 */
	private ZeligsoftURIConverter(URIConverter delegate) {
		super();
	}

	/**
	 * <p>
	 * Ensures that the Zeligsoft URI converter is installed on the specified
	 * resource set. It will delegate to the converter that was previously
	 * installed and fix up the normalized URIs that it computes.
	 * </p>
	 * <p>
	 * This operation is idempotent: installing the converter on a resource set
	 * that already has it has no effect.
	 * </p>
	 * 
	 * @param rset
	 *            a resource set for which correct URI normalization is required
	 */
	public static void install(ResourceSet rset) {
		URIConverter delegate = rset.getURIConverter();

		if (!(Proxy.isProxyClass(delegate.getClass()) && (Proxy
			.getInvocationHandler(delegate) instanceof DelegationHandler))) {
			
			rset.setURIConverter((URIConverter) Proxy.newProxyInstance(
				ZeligsoftURIConverter.class.getClassLoader(), URI_CONVERTER,
				new DelegationHandler(delegate)));
		}
		
		PathmapURIHelper.install(rset);
	}

	/**
	 * Cleans up a URI that has been normalized by removing any occurrences of
	 * the <tt>..</tt> segment (with its predecessor) and <tt>.</tt>
	 * segments.
	 * 
	 * @param uri
	 *            a URI that has been normalized, and proven to be different
	 *            from the un-normalized form
	 * @return the cleaned-up URI, which may just be the original if it had no
	 *         special segments to replace
	 */
	private static URI removeParentSegments(URI uri) {
		String[] segments = uri.segments();
		boolean fix = false;

		for (String segment : segments) {
			if (PARENT.equals(segment) || SELF.equals(segment)) {
				fix = true;
			}
		}

		if (fix) {
			List<String> newSegments = new java.util.ArrayList<String>(
				segments.length);

			for (int oldPtr = 0, newPtr = -1; oldPtr < segments.length; oldPtr++) {
				String next = segments[oldPtr];

				if (PARENT.equals(next) && (newPtr > 0)) {
					newSegments.remove(newPtr);
					newPtr--;
				} else if (!SELF.equals(next)) {
					newSegments.add(next);
					newPtr++;
				}
			}

			return URI.createHierarchicalURI(uri.scheme(), uri.authority(), uri
				.device(), newSegments.toArray(new String[newSegments.size()]),
				uri.query(), uri.fragment());
		}

		return uri;
	}

	/**
	 * An invocation handler for the dynamic proxy class used to implement the
	 * delegation of the {@link URIConverter} API, intercepting only the
	 * {@link URIConverter#normalize(URI)} method to fix up the normalized URI.
	 *
	 * @author Christian W. Damus (Zeligsoft)
	 */
	private static class DelegationHandler
			implements InvocationHandler {

		private final URIConverter delegate;

		/**
		 * Initializes me with the URI converter to which I delegate the basic
		 * URI conversion capabilities (including those that have nothing to
		 * do with normalization).
		 * 
		 * @param delegate my delegate
		 */
		DelegationHandler(URIConverter delegate) {
			this.delegate = delegate;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {

			if (method.equals(NORMALIZE)) {
				URI uri = (URI) args[0];
				URI result = delegate.normalize(uri);

				if ((result != uri) && result.isHierarchical()) {
					// some normalization took place. Remove .. segments
					result = ZeligsoftURIConverter.removeParentSegments(result);
				}

				return result;
			}

			try {
				return method.invoke(delegate, args);
			} catch (InvocationTargetException e) {
				// mustn't throw this because it wraps the real exception that
				// is declared by the interface that we are implementing
				// dynamically.  Otherwise, the caller will get an
				// UndeclaredThrowableException
				throw e.getTargetException();
			}
		}

	}
}
