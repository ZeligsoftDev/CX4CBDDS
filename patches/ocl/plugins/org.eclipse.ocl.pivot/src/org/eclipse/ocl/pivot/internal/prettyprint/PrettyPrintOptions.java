/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.prettyprint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

/**
 * PrettyPrintOptions defines the capability to provide options to the PrettyPrinter
 */
public abstract class PrettyPrintOptions
{
	/**
	 * Global PrettyPrintOptions apply regardless of pretty printer nesting.
	 */
	public static class Global extends PrettyPrintOptions
	{
		private @NonNull String indentStep = "  ";
		private int linelength = Integer.MAX_VALUE;
		private boolean showDefaultMultiplicities = false;
		private final @NonNull Set<String> reservedNames = new HashSet<String>();
		private final @NonNull Set<String> restrictedNames = new HashSet<String>();
		private @NonNull Map<Namespace, String> namespace2alias = new HashMap<Namespace, String>();
		private @Nullable URI baseURI = null;
		private @Nullable EnvironmentFactory environmentFactory = null;

		public Global(@Nullable Namespace scope) {
			super(scope);
		}

		public void addAliases(@NonNull Namespace namespace, @NonNull String alias) {
			namespace2alias.put(namespace, alias);
		}

		@Override
		public void addReservedNames(@NonNull Iterable<String> names) {
			for (String name : names) {
				reservedNames.add(name);
				restrictedNames.add(name);
			}
		}

		@Override
		public  void addRestrictedNames(@NonNull Iterable<String> names) {
			for (String name : names) {
				restrictedNames.add(name);
			}
		}

		@Override
		public @Nullable String getAlias(@NonNull Namespace namespace) {
			return namespace2alias.get(namespace);
		}

		@Override
		public @Nullable URI getBaseURI() {
			return baseURI;
		}

		@Override
		public @Nullable EnvironmentFactory getEnvironmentFactory() {
			return environmentFactory;
		}

		@Override
		public @NonNull Global getGlobalOptions() {
			return this;
		}

		@Override
		public @NonNull String getIndentStep() {
			return indentStep;
		}

		@Override
		public int getLinelength() {
			return linelength;
		}

		public @NonNull Set<Namespace> getAliasedNamespaces() {
			return namespace2alias.keySet();
		}

		@Override
		public @Nullable Set<String> getReservedNames() {
			return reservedNames;
		}

		@Override
		public @Nullable Set<String> getRestrictedNames() {
			return restrictedNames;
		}

		@Override
		public boolean isShowDefaultMultiplicities() {
			return showDefaultMultiplicities;
		}

		public void setAliases(@NonNull Map<Namespace,String> namespace2alias) {
			this.namespace2alias = namespace2alias;
		}

		public void setBaseURI(@Nullable URI baseURI) {
			this.baseURI = baseURI;
		}

		public void setEnvironmentFactory(EnvironmentFactory environmentFactory) {
			this.environmentFactory = environmentFactory;
		}

		@Override
		public void setIndentStep(@NonNull String indentStep) {
			this.indentStep = indentStep;
		}

		@Override
		public void setLinelength(int linelength) {
			this.linelength = linelength;
		}

		@Override
		public void setShowDefaultMultiplicities(boolean showDefaultMultiplicities) {
			this.showDefaultMultiplicities = showDefaultMultiplicities;
		}
	}

	/**
	 * Local PrettyPrintOptions may be overridden in nested pretty printer contexts.
	 */
	public static class Local extends PrettyPrintOptions
	{
		private @NonNull PrettyPrintOptions options;
		private @Nullable Set<String> reservedNames = null;
		private @Nullable Set<String> restrictedNames = null;
		private boolean showDefaultMultiplicities = false;

		public Local(@NonNull PrettyPrintOptions options, @Nullable Namespace scope) {
			super(scope);
			this.options = options;
		}

		@Override
		public void addReservedNames(@NonNull Iterable<String> names) {
			Set<String> reservedNames2 = reservedNames;
			Set<String> restrictedNames2 = restrictedNames;
			if (reservedNames2 == null) {
				reservedNames2 = reservedNames = new HashSet<String>();
			}
			if (restrictedNames2 == null) {
				restrictedNames2 = restrictedNames = new HashSet<String>();
			}
			for (String name : names) {
				reservedNames2.add(name);
				restrictedNames2.add(name);
			}
		}

		@Override
		public  void addRestrictedNames(@NonNull Iterable<String> names) {
			Set<String> reservedNames2 = reservedNames;
			Set<String> restrictedNames2 = restrictedNames;
			if (reservedNames2 == null) {
				reservedNames2 = reservedNames = new HashSet<String>();
			}
			if (restrictedNames2 == null) {
				restrictedNames2 = restrictedNames = new HashSet<String>();
			}
			for (String name : names) {
				restrictedNames2.add(name);
			}
		}

		@Override
		public @NonNull Global getGlobalOptions() {
			return options.getGlobalOptions();
		}

		@Override
		public Set<String> getReservedNames() {
			return reservedNames != null ? reservedNames : options.getReservedNames();
		}

		@Override
		public Set<String> getRestrictedNames() {
			return restrictedNames != null ? restrictedNames : options.getRestrictedNames();
		}

		@Override
		public boolean isShowDefaultMultiplicities() {
			return showDefaultMultiplicities;
		}

		@Override
		public void setShowDefaultMultiplicities(boolean showDefaultMultiplicities) {
			this.showDefaultMultiplicities = showDefaultMultiplicities;
		}
	}

	protected final @Nullable Namespace scope;

	public PrettyPrintOptions(@Nullable Namespace scope) {
		this.scope = scope;
	}

	public abstract void addReservedNames(@NonNull Iterable<String> names);

	public abstract void addRestrictedNames(@NonNull Iterable<String> names);

	/**
	 * Return a name to be used when referencing element as the first element in a qualified name.
	 */
	public @Nullable String getAlias(@NonNull Namespace namespace) {
		return getGlobalOptions().getAlias(namespace);
	}

	/**
	 * Return a URI against which to deresolve the first element of qualified names that
	 * reference external resources. Null leaves URIs in global form.
	 */
	public @Nullable URI getBaseURI() {
		return getGlobalOptions().getBaseURI();
	}

	public @Nullable EnvironmentFactory getEnvironmentFactory() {
		return getGlobalOptions().getEnvironmentFactory();
	}

	public abstract @NonNull Global getGlobalOptions();

	public @NonNull String getIndentStep() {
		return getGlobalOptions().getIndentStep();
	}

	public int getLinelength() {
		return getGlobalOptions().getLinelength();
	}

	public abstract @Nullable Set<String> getReservedNames();

	/**
	 * @since 1.3
	 */
	public boolean isShowDefaultMultiplicities() {
		return getGlobalOptions().isShowDefaultMultiplicities();
	}

	public @Nullable Namespace getScope() {
		return scope;
	}

	public abstract @Nullable Set<String> getRestrictedNames();

	public void setIndentStep(@NonNull String indentStep) {
		getGlobalOptions().setIndentStep(indentStep);
	}

	public void setLinelength(int linelength) {
		getGlobalOptions().setLinelength(linelength);
	}

	/**
	 * @since 1.3
	 */
	public void setShowDefaultMultiplicities(boolean showDefaultMultiplicities) {
		getGlobalOptions().setShowDefaultMultiplicities(showDefaultMultiplicities);
	}
}