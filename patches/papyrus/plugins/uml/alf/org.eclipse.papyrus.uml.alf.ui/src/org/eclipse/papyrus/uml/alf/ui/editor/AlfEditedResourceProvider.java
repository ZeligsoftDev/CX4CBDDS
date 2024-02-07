/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.ui.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Arnaud Cuccuru - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class AlfEditedResourceProvider implements IEditedResourceProvider {

	public static final String SYNTHETIC_SCHEME = "synthetic";

	protected Provider<XtextResourceSet> resourceSetProvider;

	protected IGrammarAccess grammarAccess;

	protected Injector xtextInjector;

	/**
	 * @param xtextInjector
	 *
	 */
	public AlfEditedResourceProvider(Injector xtextInjector) {
		this.xtextInjector = xtextInjector;
	}

	public XtextResource createResource() {
		resourceSetProvider = xtextInjector.getProvider(XtextResourceSet.class);
		ResourceSet resourceSet = resourceSetProvider.get();
		grammarAccess = xtextInjector.getInstance(IGrammarAccess.class);
		Resource grammarResource = resourceSet.createResource(URI.createURI(SYNTHETIC_SCHEME + ":/" + grammarAccess.getGrammar().getName() + ".xtext"));
		grammarResource.getContents().add(EcoreUtil.copy(grammarAccess.getGrammar()));
		XtextResource result = (XtextResource) resourceSet.createResource(URI.createURI(SYNTHETIC_SCHEME + ":/" + grammarAccess.getGrammar().getName() + ".alf"));
		resourceSet.getResources().add(result);
		return result;
	}

}
