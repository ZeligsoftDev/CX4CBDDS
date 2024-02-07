/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.ui.BaseEditor;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @deprecated no longer used - retained for API compatibility
 */
@Deprecated
public class DeferredDocumentProvider extends XtextDocumentProvider
{
	/**
	 * @deprecated no longer used - retained for API compatibility
	 */
	@Deprecated
	protected class DeferredSetTextJob extends Job
	{
		protected final @NonNull XtextDocument document;
		protected final @NonNull String sourceText;

		public DeferredSetTextJob(@NonNull XtextDocument document, @NonNull String sourceText) {
			super("Deferred Editor SetText");
			this.document = document;
			this.sourceText = sourceText;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			return Status.OK_STATUS;
		}
	}

	/**
	 * @deprecated no longer used - retained for API compatibility
	 */
	@Deprecated
	public class DeferredSetTextUnitOfWork implements IUnitOfWork<Boolean, XtextResource>
	{
		protected final @NonNull XtextDocument document;
		protected final @NonNull String sourceText;

		public DeferredSetTextUnitOfWork(@NonNull XtextDocument document, @NonNull String sourceText) {
			this.document = document;
			this.sourceText = sourceText;
		}

		@Override
		public Boolean exec(XtextResource state) throws Exception {
			return Boolean.TRUE;
		}
	}

	/**
	 * @deprecated no longer used - retained for API compatibility
	 */
	@Deprecated
	protected class DeferredSetTextRunnable implements Runnable
	{
		protected final @NonNull XtextDocument document;
		protected final @NonNull String displayText;

		public DeferredSetTextRunnable(@NonNull XtextDocument document, @NonNull String displayText) {
			this.displayText = displayText;
			this.document = document;
		}

		@Override
		public void run() {}
	}

	/**
	 * @deprecated no longer used - retained for API compatibility
	 */
	@Deprecated
	protected @NonNull String getPleaseWaitText() {
		return "/* " + BaseUIMessages.DeferredDocumentProvider_PleaseWait + " */";
	}

	/**
	 * @deprecated no longer used - does nothing - retained for API compatibility
	 */
	@Deprecated
	public void scheduleDeferredSetTextJob(@NonNull BaseEditor baseEditor) {}

	/**
	 * @deprecated no longer used - does nothing - retained for API compatibility
	 */
	@Deprecated
	public void scheduleDeferredSetTextJob(IEditorInput input) {}

	/**
	 * @deprecated no longer used - does nothing - retained for API compatibility
	 */
	@Deprecated
	protected void setDocumentText(final @NonNull XtextDocument document, final @NonNull String text) throws CoreException {}
}
