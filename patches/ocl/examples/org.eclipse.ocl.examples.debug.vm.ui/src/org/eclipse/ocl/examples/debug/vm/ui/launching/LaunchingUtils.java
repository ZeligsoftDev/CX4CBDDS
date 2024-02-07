/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.ui.launching;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LaunchingUtils
{
	/**
	 * Load a DebugUI class to ensure the PerspectiveManager is ready to create a Perspective
	 */
	public static void loadPerspectiveManager() {
		DebugUITools.class.getName();
	}

	/**
	 * Called to prepare the Browse File System button, this implementation adds
	 * a selection listener that creates an appropriate {@link FileDialog}.
	 */
	public static void prepareBrowseFileSystemButton(@NonNull Button browseFileSystemButton, final @NonNull Text uriField, final boolean isSave) {
		// This method substantially copied from org.eclipse.emf.common.ui.dialogs.ResourceDialog.
		final Shell shell = browseFileSystemButton.getShell();
		browseFileSystemButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				FileDialog fileDialog = new FileDialog(shell, isSave ? SWT.SAVE : 0);
				fileDialog.open();

				String filterPath = fileDialog.getFilterPath();
				String fileName = fileDialog.getFileName();
				if (fileName != null) {
					uriField.setText(String.valueOf(URI.createFileURI(filterPath + File.separator + fileName)));
				}
			}
		});
	}

	/**
	 * Called to prepare the Browse Workspace button, this implementation adds a
	 * selection listener that creates an appropriate
	 * {@link WorkspaceResourceDialog}.
	 */
	public static void prepareBrowseWorkspaceButton(@NonNull Button browseWorkspaceButton, final @NonNull Text uriField, final boolean isSave) {
		prepareBrowseWorkspaceButton(browseWorkspaceButton, null, uriField, isSave);
	}
	public static void prepareBrowseWorkspaceButton(@NonNull Button browseWorkspaceButton, final @Nullable String name, final @NonNull Text uriField, final boolean isSave) {
		// This method substantially copied from org.eclipse.emf.common.ui.dialogs.ResourceDialog.
		final Shell shell = browseWorkspaceButton.getShell();
		browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				String title = name != null ? "'" + name + "' File Selection" : "File Selection";
				IFile file = null;
				if (isSave) {
					String message = name != null ? "Select a folder and specify a file '" + name + "' for use as the '" + name + "'" : "Select a folder and specify a file";
					String path = getContextPath();
					List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
					filters.add(new ViewerFilter(){
						@Override
						public boolean select(Viewer viewer, Object parentElement, Object element) {
							return true;
						}
					});
					file = WorkspaceResourceDialog.openNewFile(shell, title, message, path != null ? new Path(path) : null, null); //filters);
				} else {
					String message = name != null ? "Select a file '" + name + "' for use as the '" + name + "'" : "Select a file";
					IFile[] files = WorkspaceResourceDialog.openFileSelection(shell, title, message, false, getContextSelection(), null);
					if (files.length != 0) {
						file = files[0];
					}
				}
				if (file != null) {
					uriField.setText(String.valueOf(URI.createPlatformResourceURI(file.getFullPath().toString(), true)));
				}
			}

			private String getContextPath() {
				String text = uriField.getText();
				try {
					URI context = text != null ? URI.createURI(text) : null;
					//					return context != null && context.isPlatformResource() ? URI.createURI(".").resolve(context).path().substring(9) : null;
					if ((context == null) || !context.isPlatformResource()) {
						return null;
					}
					String path = context.path();
					if ((path == null) || (path.length() < 9)) {
						return null;
					}
					return path.substring(9);
				}
				catch (Exception e) {
					return null;
				}
			}

			private Object[] getContextSelection() {
				String path = getContextPath();
				while (path != null) {
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IResource resource = root.findMember(path);
					if (resource != null && resource.isAccessible()) {
						return new Object[] { resource };
					}
					int index = path.lastIndexOf("/");
					if (index >= 0) {
						path = path.substring(0, index);
					}
				}
				return null;
			}
		});
	}
}
