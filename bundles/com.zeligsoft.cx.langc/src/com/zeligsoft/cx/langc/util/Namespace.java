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
package com.zeligsoft.cx.langc.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

import com.zeligsoft.cx.langc.BindableValue;
import com.zeligsoft.cx.langc.Name;

/**
 * Language elements exist within a namespace, which can be nested. For now the
 * namespace is not modeled.  This class manages both element containment (elements
 * are bound within a namespace) and namespace nesting (namespaces are hierarchical).
 * <li>#bind operations are used to associate elements with an
 * 		identifier within a namespace
 * <li>#lookup operations are used to retrieve elements that have been
 * 		bound to an identifier
 * <li>#get operations are used to retrieve a namespace.
 *
 * TODO Can this be replaced with new accessors into the XTend cache?
 */
@SuppressWarnings("nls")
public class Namespace {
	private final Map<String, Namespace> children = new HashMap<String, Namespace>();
	private final Map<String, BindableValue> values = new HashMap<String, BindableValue>();

	private static final Namespace rootNamespace = new Namespace();

	private static final boolean TRACE_REBINDINGS
		= Boolean.parseBoolean(
				Platform.getDebugOption( "com.zeligsoft.cx.langc/trace-namespace-rebindings" ) ); //$NON-NLS-1$
	private static final boolean TRACE_BINDINGS
		= Boolean.parseBoolean(
				Platform.getDebugOption( "com.zeligsoft.cx.langc/trace-namespace-bindings" ) ); //$NON-NLS-1$
	private static final boolean TRACE_LOOKUP
		= Boolean.parseBoolean(
				Platform.getDebugOption( "com.zeligsoft.cx.langc/trace-namespace-lookup" ) ); //$NON-NLS-1$

	private Namespace() { /* empty */ }

	public static void reset() {
		if( TRACE_BINDINGS )
			System.out.println( "Resetting bindings" );
		rootNamespace.children.clear();
		rootNamespace.values.clear();
	}

	public static BindableValue lookup(Name context, String identifier) {
		if( TRACE_LOOKUP )
			System.out.println(
					"Lookup '" + identifier + "' within '"
					+ ( context == null ? "<null>" : context.toString() )
					+ '\'' );

		for( ; context != null; context = context.getParent()) {
			Namespace ns = get(context);
			if (ns == null)
				break;

			BindableValue value = ns._lookup(identifier);
			if( value != null)
				return value;
		}

		return null;
	}

	public static BindableValue lookup(Name name) {
		return lookup(name.getParent(), name.getName());
	}

	public static void bind(Name parent, String identifier, BindableValue value) {

		// if the parent is null, then there is no namespace within which to
		// bind the identifier -- it cannot be looked up
		if( parent == null )
			return;

		if( TRACE_BINDINGS )
			System.out.println( "Binding '" + identifier + "' within '"
							+ ( parent == null ? "<null>" : parent.toString() )
							+ '\'' );
		Namespace ns = get(parent);
		ns._bind(identifier, value);
	}

	public static void rebind(Name name, Name newParent, BindableValue value) {
		if( TRACE_REBINDINGS )
			System.out.println( "Rebinding '" + name.toString() + "' within '" + newParent.toString() + '\'' );

		Name currParent = name.getParent();
		if (currParent != null
		 && currParent.equals(newParent))
			return;

		Namespace currNs = get(currParent);
		BindableValue old = currNs._remove(name.getName());
		if( TRACE_REBINDINGS
		 && old != null
		 && ! old.equals( value ) )
			System.out.println( "UNEXPECTED: Previously bound to '" + old.toString() + '\'' );

		name.setParent(newParent);
		bind(name, value);
	}

	public static void bind(Name name, BindableValue value) {
		bind(name.getParent(), name.getName(), value);
	}

	private static Namespace get(Name name) {
		return rootNamespace._get(name);
	}

	private BindableValue _lookup(String identifier) {
		return values.get(identifier);
	}

	private void _bind(String identifier, BindableValue value) {
		if( ! values.containsKey( identifier ) )
			values.put( identifier, value );
		else if( TRACE_REBINDINGS )
			System.out.println("UNEXPECTED: Attempt to replace binding for " + identifier
					+ " in " + this.toString());
	}

	private Namespace _get(Name name) {
		if (name == null)
			return this;

		Name parentName = name.getParent();
		return parentName == null
				? _get(name.getName())
				: _get(parentName)._get(name.getName());
	}

	private Namespace _get(String identifier) {
		Namespace child = children.get(identifier);
		if (child == null) {
			child = new Namespace();
			children.put(identifier, child);
		}

		return child;
	}

	/**
	 * @return the now removed value or null if the identifier was not bound
	 */
	private BindableValue _remove(String identifier) {
		children.remove(identifier);
		return values.remove(identifier);
	}
}
