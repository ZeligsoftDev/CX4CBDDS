/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.xtext.base.ui.model.BaseDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class BaseEditor extends XtextEditor
{
	public BaseEditor() {
		super();
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (EnvironmentFactory.class.isAssignableFrom(adapter)) {
			return adapter.cast(getEnvironmentFactory());
		}
		return super.getAdapter(adapter);
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		BaseDocumentProvider documentProvider = (BaseDocumentProvider) getDocumentProvider();
		return documentProvider.getEnvironmentFactory();
	}

	public @NonNull String getMarkerId() {
		return BaseUiModule.MARKER_ID;
	}

	/**
	 * @deprecated no longer used - retained for API compatibility
	 */
	@Deprecated
	@SuppressWarnings("null")
	public @NonNull TextViewer getTextViewer() {
		return (TextViewer) getSourceViewer();
	}

	/**
	 * @deprecated no longer used - does nothing - retained for API compatibility
	 */
	@Deprecated
	protected void scheduleDeferredSetTextJob() {}

	@Override
	protected void setDocumentProvider(IDocumentProvider provider) {
		super.setDocumentProvider(provider);
		((BaseDocumentProvider)provider).initOCL(this);
	}
}
