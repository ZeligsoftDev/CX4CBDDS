/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.oclinecore.ui.internal.OCLinEcoreActivator;
import org.eclipse.ocl.xtext.oclinecore.ui.model.OCLinEcoreDocument;
import org.eclipse.ocl.xtext.oclinecore.ui.model.OCLinEcoreDocumentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OCLinEcoreUiModule extends org.eclipse.ocl.xtext.oclinecore.ui.AbstractOCLinEcoreUiModule
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.ocl.xtext.oclinecore.ui";
	public static final @NonNull String EDITOR_ID = OCLinEcoreActivator.ORG_ECLIPSE_OCL_XTEXT_OCLINECORE_OCLINECORE;
	public static final @NonNull String MARKER_ID = "org.eclipse.ocl.xtext.oclinecore.ui.Marker";

	private static EMFPlugin.InternalHelper helper = new EMFPlugin.InternalHelper(OCLinEcoreActivator.getInstance());

	/**
	 * Return the optionally translated value of a plugin.properties key.
	 */
	public static String getString(String key, boolean translate) {
		return helper.getString(key, translate);
	}

	/**
	 * Return the optionally translated value of a plugin.properties key with substitutions.
	 */
	public static String getString(String key, Object [] substitutions, boolean translate) {
		return helper.getString(key, substitutions, translate);
	}

	public OCLinEcoreUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

//	@Override
	@Override
	public Class<? extends XtextDocument> bindXtextDocument() {
		return OCLinEcoreDocument.class;
	}

	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return OCLinEcoreDocumentProvider.class;
	}

	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return OCLinEcoreResourceForEditorInputFactory.class;
	}

	@Override
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return OCLinEcoreEditorCallback.class;
	}
}
