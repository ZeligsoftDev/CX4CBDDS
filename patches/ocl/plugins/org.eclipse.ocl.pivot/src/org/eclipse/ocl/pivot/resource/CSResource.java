/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ParserContext;

/**
 * CSResource defines the Xtext-independent extended interface for a Concrete Syntax resource
 * for which a ParserContext defines how the Abstract Syntax elements should
 * be initialized.
 */
public interface CSResource extends Resource
{
	/**
	 * @since 1.1
	 */
	public interface CSResourceExtension extends CSResource
	{
		/**
		 * Dispose of this CSResource and its conversion facilities. This frees up resources after conversion to AS but loses the
		 * required source visibility for debugging.
		 */
		void dispose();
	}

	/**
	 * @since 1.3
	 */
	public interface CSResourceExtension2 extends CSResourceExtension
	{
		/**
		 * Return true if this CSResource is derived from an ASResource..
		 */
		boolean isDerived();

		/**
		 * Set whether this CSResource is derived from an ASResource..
		 */
		void setDerived(boolean isDerived);
	}

	/**
	 * Return the Abstract Syntax representation of this Concrete Syntax resource.
	 */
	@NonNull ASResource getASResource();

	@NonNull ASResourceFactory getASResourceFactory();

	/**
	 * @since 1.15
	 */
	default @NonNull EnvironmentFactory getEnvironmentFactory() {
		return getParserContext().getEnvironmentFactory();
	}

	@NonNull ParserContext getParserContext();

	/**
	 * Return the map of known projects.
	 */
	@Deprecated /* @deprecated no longer used - use getEnvironmentFactory().getProjectManager() */
	@NonNull ProjectManager getProjectManager();

	void setParserContext(@Nullable ParserContext parserContext);

	/**
	 * Set the map of known projects.
	 */
	@Deprecated /* @deprecated ProjectManager is inferred from implicit/explicit setParserContext() */
	void setProjectManager(@Nullable ProjectManager projectManager);

	void updateFrom(@NonNull ASResource asResource, @NonNull EnvironmentFactory environmentFactory);

	void update(int index, int length, String newString);
}
