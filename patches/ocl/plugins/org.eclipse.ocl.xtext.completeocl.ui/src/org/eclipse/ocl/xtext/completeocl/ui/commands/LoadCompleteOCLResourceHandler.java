/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Obeo - Enable export and re-use CompleteOCL files for validation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.ui.commands;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ocl.pivot.internal.registry.CompleteOCLRegistry;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.xtext.base.ui.utilities.PDEUtils;
import org.eclipse.ocl.xtext.completeocl.ui.CompleteOCLUiModule;
import org.eclipse.ocl.xtext.completeocl.ui.messages.CompleteOCLUIMessages;
import org.eclipse.ocl.xtext.completeocl.utilities.CompleteOCLLoader;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ResourceTransfer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * A LoadCompleteOCLResourceHandler supports the OCL->Load Document command.
 *
 * It provides a pop-up dialog with DND capability for a Complete OCL document to be installed in the
 * ResourceSet associated with the invoking selection.
 */
public class LoadCompleteOCLResourceHandler extends AbstractHandler
{
	protected class ResourceDialog extends LoadResourceDialog
	{
		public class URIDropTargetListener extends DropTargetAdapter
		{
			@Override
			public void dragEnter(DropTargetEvent e) {
				e.detail = DND.DROP_LINK;
			}

			@Override
			public void dragOperationChanged(DropTargetEvent e) {
				e.detail = DND.DROP_LINK;
			}

			@Override
			public void drop(DropTargetEvent event) {
				Object data = event.data;
				if (data == null) {
					event.detail = DND.DROP_NONE;
					return;
				}
				if (data instanceof IResource[]) {
					StringBuilder s = new StringBuilder();
					for (IResource resource : (IResource[])data) {
						if (s.length() > 0) {
							s.append(" ");
						}
						s.append(URI.createPlatformResourceURI(resource.getFullPath().toString(), true));
					}
					uriField.setText(s.toString());
				}
				else if (data instanceof String[]) {
					StringBuilder s = new StringBuilder();
					for (String resource : (String[])data) {
						if (s.length() > 0) {
							s.append(" ");
						}
						s.append(URI.createFileURI(resource));
					}
					uriField.setText(s.toString());
				}
				else {
					uriField.setText(((String) data));
				}
			}
		}

		/**
		 * Job scheduled on a worker thread to compute the editor text.
		 */
		protected class DeferredLoadDocumentJob extends Job
		{
			private final @NonNull List<URI> uris;
			private boolean processedResourcesReturn = false;

			public DeferredLoadDocumentJob(@NonNull List<URI> uris) {
				super("Deferred Load OCL Document");
				this.uris = uris;
			}

			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				ThreadLocalExecutor.resetEnvironmentFactory();		// Reset in case last thread user (validation job) not yet finalized
				ThreadLocalExecutor.attachEnvironmentFactory(environmentFactory);
				processedResourcesReturn = processResources();
				Display.getDefault().asyncExec(new Runnable()
				{
					@Override
					public void run() {
						okPressed();
					}
				});
				ThreadLocalExecutor.detachEnvironmentFactory(environmentFactory);
				return Status.OK_STATUS;
			}

			protected boolean processResources() {
			//	OCLAdapter oclAdapter = OCLAdapter.getAdapter(resourceSet);
				CompleteOCLLoader helper = new CompleteOCLLoader(environmentFactory) {
					@Override
					protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
						Display.getDefault().asyncExec(new Runnable()
						{
							@Override
							public void run() {
								ResourceDialog.this.error(primaryMessage, detailMessage);
							}
						});
						return false;
					}
				};

				if (!helper.loadMetamodels()) {
					return false;
				}
				//
				//	Load all the documents
				//
				for (URI oclURI : uris) {
					assert oclURI != null;
					try {
						if (!helper.loadDocument(oclURI)) {
							return false;
						};
					}
					catch (Throwable e) {
						IStatus status = new Status(IStatus.ERROR, CompleteOCLUiModule.PLUGIN_ID, e.getLocalizedMessage(), e);
						Display.getDefault().asyncExec(new Runnable()
						{
							@Override
							public void run() {
								ErrorDialog.openError(parent, "OCL->Load Document Failure", "Failed to load '" + oclURI + "'", status);
							}
						});
						return false;
					}
				}
				helper.installPackages();
				return true;
			}

			public boolean getProcessedResourcesReturn() {
				return processedResourcesReturn;
			}
		}

		protected final Shell parent;
		protected final @NonNull ResourceSet resourceSet;
		private final @NonNull EnvironmentFactoryInternal environmentFactory;
		private DropTarget target;
		private Set<URI> registeredURIsForResourceSet;
		private DeferredLoadDocumentJob job = null;

		protected ResourceDialog(Shell parent, EditingDomain domain, @NonNull ResourceSet resourceSet) {
			super(parent, domain);
			this.parent = parent;
			this.resourceSet = resourceSet;
			// Ensure EnvironmentFactory created on main thread (Bug 574041)
			EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
			if (environmentFactory == null) {
				ProjectManager projectManager = ProjectMap.findAdapter(resourceSet);
				if (projectManager == null) {
					projectManager = OCL.CLASS_PATH;
				}
				environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectManager, resourceSet, null);
			}
			this.environmentFactory = environmentFactory;
			int shellStyle = getShellStyle();
			int newShellStyle = shellStyle & ~(SWT.APPLICATION_MODAL | SWT.PRIMARY_MODAL | SWT.SYSTEM_MODAL);
			setShellStyle(newShellStyle);
		}

		@Override
		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setText("Load Complete OCL Document");
		}

		@Override
		protected Control createContents(Composite parent) {
			Control control = super.createContents(parent);
			int operations = /*DND.DROP_MOVE |*/ DND.DROP_COPY | DND.DROP_LINK;
			target = new DropTarget(uriField, operations);
			target.setTransfer(new Transfer[] {ResourceTransfer.getInstance(), FileTransfer.getInstance()});
			target.addDropListener(new URIDropTargetListener());
			return control;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite createDialogArea = (Composite) super.createDialogArea(parent);

			// Button composite is the first children and we are expected to retrieve it as such...
			Composite buttonComposite = (Composite)createDialogArea.getChildren()[0];

			Button browseRegisteredOCLFiles = new Button(buttonComposite, SWT.PUSH);
			browseRegisteredOCLFiles.setText(CompleteOCLUIMessages.LoadCompleteOCLResource_BrowseRegisteredOCLFiles);
			prepareBrowseRegisteredOCLFiles(browseRegisteredOCLFiles);
//			registeredURIsForResourceSet = CompleteOCLRegistry.INSTANCE.getResourceURIs(resourceSet);
			CompleteOCLRegistry registry = PDEUtils.createCompleteOCLRegistry();
			registeredURIsForResourceSet = registry.getResourceURIs(resourceSet);
			if (registeredURIsForResourceSet.isEmpty()) {
				browseRegisteredOCLFiles.setEnabled(false);
			} else {
				browseRegisteredOCLFiles.setEnabled(true);
			}

			{
				FormData data = new FormData();
				Control [] children = buttonComposite.getChildren();
				data.right = new FormAttachment(children[0], -CONTROL_OFFSET);
				browseRegisteredOCLFiles.setLayoutData(data);
			}

			Label helpLabel = new Label(createDialogArea, SWT.CENTER);
		    helpLabel.setText("You may Drag and Drop from an Eclipse or Operating System Explorer.");
		    {
		      FormData data = new FormData();
		      data.top = new FormAttachment(uriField, 2 * CONTROL_OFFSET);	// Separator is at 1 * CONTROL_OFFSET
		      data.left = new FormAttachment(0, CONTROL_OFFSET);
		      data.right = new FormAttachment(100, -CONTROL_OFFSET);
		      helpLabel.setLayoutData(data);
		    }

			return createDialogArea;
		}

		private void prepareBrowseRegisteredOCLFiles(Button browseRegisteredOCLFiles) {
			browseRegisteredOCLFiles.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					RegisteredOCLFilesDialog registeredOCLFilesDialog = new RegisteredOCLFilesDialog(getShell());
					registeredOCLFilesDialog.open();
					Object[] result = registeredOCLFilesDialog.getResult();
					if (result != null) {
						StringBuffer uris = new StringBuffer();

						for (int i = 0, length = result.length; i < length; i++) {
							uris.append(result[i]);
							uris.append("  ");
						}
						uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
					}
				}
			});
		}

		private class RegisteredOCLFilesDialog extends ElementListSelectionDialog
		{
			public RegisteredOCLFilesDialog(Shell parent) {
				super(parent, new LabelProvider() {
					@Override
					public Image getImage(Object element) {
						return ExtendedImageRegistry.getInstance().getImage(EcoreEditPlugin.INSTANCE.getImage("full/obj16/EPackage"));
					}
				});

				setMultipleSelection(true);
				setMessage(CompleteOCLUIMessages.LoadCompleteOCLResource_SelectRegisteredOCLFileURI);
				setFilter("*");
				setTitle(CompleteOCLUIMessages.LoadCompleteOCLResource_OCLFileSelection_label);
				setSize(100, 20);
			}

			@Override
			protected Control createDialogArea(Composite parent)
			{
				Composite result = (Composite)super.createDialogArea(parent);
				URI[] uris = registeredURIsForResourceSet.toArray(new URI[registeredURIsForResourceSet.size()]);
				Arrays.sort(uris, new URIComparator());
				setListElements(uris);
				return result;
			}
		}

		/**
		 * Generate a popup to display a primaryMessage and optionally a detailMessage too.
		 */
		protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
			Shell shell = parent;
		    if (detailMessage != null) {
		    	Diagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "source", 0, detailMessage, null);
		    	DiagnosticDialog.open(shell, title, primaryMessage, diagnostic);
		    }
		    else {
		    	MessageDialog.openInformation(shell, title, primaryMessage);
		    }
			return false;
		}

		@Override
		protected void okPressed() {
			if (job == null) {
				getButton(IDialogConstants.OK_ID).setEnabled(false);
				getButton(IDialogConstants.CANCEL_ID).setEnabled(false);
				@SuppressWarnings("null")@NonNull List<URI> urIs = getURIs();
				job = new DeferredLoadDocumentJob(urIs);
				job.schedule();
			}
			else {
				getButton(IDialogConstants.OK_ID).setEnabled(true);
				getButton(IDialogConstants.CANCEL_ID).setEnabled(true);
				super.okPressed();
				job = null;
			}
		}

		@Override
		public int open() {
			try {
				return super.open();
			}
			catch (Throwable e) {
				@NonNull String primaryMessage = String.valueOf(e.getMessage());
				error(primaryMessage, null);
				return CANCEL;
			}
			finally {
				if (target != null) {
					target.dispose();
					target = null;
				}
			}
		}

		@Override
		protected boolean processResources() {
			if (job != null) {
				return job.getProcessedResourcesReturn();
			}
			else {
				return false;
			}
		}

		@Override
		protected boolean processResource(Resource resource) {
			throw new UnsupportedOperationException();		// Never happens since processResources overridden.
		}
	}

	public static class URIComparator implements Comparator<URI> {
		@Override
		public int compare(URI o1, URI o2) {
			return o1.toString().compareTo(o2.toString());
		}
	}

	@Override
	public @Nullable Object execute(ExecutionEvent event) throws ExecutionException {
		Object applicationContext = event.getApplicationContext();
		EditingDomain editingDomain = getEditingDomain(applicationContext);
		ResourceSet resourceSet = getResourceSet(applicationContext);
//		System.out.println("execute " + event);
		Object shell = HandlerUtil.getVariable(applicationContext, ISources.ACTIVE_SHELL_NAME);
		if (!(shell instanceof Shell)) {
			return null;
		}
		if (resourceSet != null) {
			ResourceDialog dialog = new ResourceDialog((Shell)shell, editingDomain, resourceSet);
			dialog.open();
		}
		return null;
	}

	public static @Nullable EditingDomain getEditingDomain(@Nullable Object evaluationContext) {
		Object o = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_EDITOR_NAME);
		if (!(o instanceof IEditorPart)) {
			return null;
		}
		IEditingDomainProvider editor = ClassUtil.getAdapter((IEditorPart)o, IEditingDomainProvider.class);
		if (editor == null) {
			return null;
		}
		EditingDomain editingDomain = editor.getEditingDomain();
		if (editingDomain == null) {
			return null;
		}
		return editingDomain;
	}

	public static @Nullable ResourceSet getResourceSet(@Nullable Object evaluationContext) {
		Object o = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_EDITOR_NAME);
		if (!(o instanceof IEditorPart)) {
			return null;
		}
		IEditingDomainProvider editingDomainProvider = ClassUtil.getAdapter((IEditorPart)o, IEditingDomainProvider.class);
		if (editingDomainProvider != null) {
			EditingDomain editingDomain = editingDomainProvider.getEditingDomain();
			if (editingDomain == null) {
				return null;
			}
			ResourceSet resourceSet = editingDomain.getResourceSet();
			return resourceSet;
		}
		XtextEditor xtextEditor = ClassUtil.getAdapter((IEditorPart)o, XtextEditor.class);
		if (xtextEditor != null) {
			IXtextDocument document = xtextEditor.getDocument();
			ResourceSet resourceSet = document.readOnly(new IUnitOfWork<ResourceSet, XtextResource>() {
				@Override
				public ResourceSet exec(@Nullable XtextResource xtextResource) {
					if (xtextResource == null) {
						return null;
					}
					EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
					if (environmentFactory != null) {
						return environmentFactory.getResourceSet();
					}
					else {
						return xtextResource.getResourceSet();
					}
				}
			});
			return resourceSet;
		}
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
//		System.out.println("setEnabled " + evaluationContext);
		setBaseEnabled(getResourceSet(evaluationContext) != null);
	}
}
