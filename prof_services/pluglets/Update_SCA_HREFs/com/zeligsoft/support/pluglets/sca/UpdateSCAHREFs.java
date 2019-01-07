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

package com.zeligsoft.support.pluglets.sca;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.ibm.xtools.pluglets.Pluglet;

/**
 * <p>
 * Pluglet to update HREFs in the user model, that reference SCA model library
 * elements by platform:/plugin URIs, to use pathmap://SCA_LIBRARIES URIs,
 * instead.
 * </p>
 * <p>
 * To invoke the pluglet, select one or more projects in which to process
 * models, then launch the pluglet.
 * </p>
 */
public class UpdateSCAHREFs extends Pluglet {

	private URIReplacer uriReplacer = new URIReplacer();

	private Set<String> fileExtensions = new java.util.HashSet<String>(Arrays
			.asList("emx", "efx"));

	public void plugletmain(String[] args) {
		ISelection sel = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().getSelection();

		final List<IProject> projects;
		if (sel instanceof IStructuredSelection) {
			projects = getProjectsFromSelection((IStructuredSelection) sel);
		} else {
			projects = Collections.emptyList();
		}

		if (projects.isEmpty()) {
			error("No projects selected.", getName());
		}

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(
					new WorkspaceModifyOperation() {

						@Override
						protected void execute(IProgressMonitor monitor)
								throws CoreException {
							fixHREFs(projects, monitor);
						}
					});
		} catch (InterruptedException e) {
			error("Operation was interrupted.", getName());
		} catch (InvocationTargetException e) {
			error("Exception in updating models: " + e.getLocalizedMessage(),
					getName());
			if (e.getTargetException() != null) {
				e.getTargetException().printStackTrace(out);
			}
		}
	}

	private List<IProject> getProjectsFromSelection(IStructuredSelection sel) {
		List<IProject> result = new java.util.ArrayList<IProject>(sel.size());

		for (Iterator<?> iter = sel.iterator(); iter.hasNext();) {
			Object next = iter.next();

			if (next instanceof IProject) {
				result.add((IProject) next);
			} else if (next instanceof IAdaptable) {
				IResource res = (IResource) ((IAdaptable) next)
						.getAdapter(IResource.class);

				if (res instanceof IProject) {
					result.add((IProject) res);
				}
			}
		}

		return result;
	}

	private void fixHREFs(Collection<? extends IProject> projects,
			IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Scanning projects ...", projects.size());

		for (IProject next : projects) {
			if (monitor.isCanceled()) {
				break;
			}

			visitProject(next, monitor);
		}

		monitor.done();
	}

	private void visitProject(IProject project, final IProgressMonitor monitor)
			throws CoreException {
		project.accept(new IResourceVisitor() {

			public boolean visit(IResource resource) throws CoreException {
				if (!monitor.isCanceled()
						&& (resource.getType() == IResource.FILE)) {
					
					if (fileExtensions.contains(resource.getFileExtension())) {
						try {
							monitor.subTask("Updating "
									+ resource.getFullPath());
							visitModelFile((IFile) resource);
						} catch (CoreException e) {
							throw e;
						} catch (Exception e) {
							throw new CoreException(new Status(IStatus.ERROR,
									"com.zeligsoft.support.pluglets.sca", e
											.getLocalizedMessage(), e));
						}
					}

					return false;
				}

				return !monitor.isCanceled();
			}
		});
	}

	private void visitModelFile(IFile file) throws CoreException, IOException,
			UnsupportedEncodingException {
		BufferedReader input = new BufferedReader(new InputStreamReader(file
				.getContents()));
		StringBuilder newString = new StringBuilder(4096);
		boolean changed = false;

		try {
			for (String line = input.readLine(); line != null; line = input
					.readLine()) {
				if (uriReplacer.replaceLine(line, newString)) {
					changed = true;
				}
			}

			if (changed) {
				// replace the file with the new result
				ByteArrayInputStream bais = null;

				try {
					byte[] bytes = newString.toString().getBytes(
							file.getCharset());
					bais = new ByteArrayInputStream(bytes);

					file.setContents(bais, IResource.KEEP_HISTORY, null);
				} finally {
					if (bais != null) {
						try {
							bais.close();
						} catch (IOException e) {
							// shouldn't happen, but there's no recovery
							// possible
						}
					}
				}
			}
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// shouldn't happen, but there's no recovery possible
			}
		}
	}

	/**
	 * Utility that replaces HREFs with their abstract pathmap URIs.
	 */
	private static class URIReplacer {
		private final String newline = System.getProperty("line.separator");

		private final Matcher matchers[] = new Matcher[2];
		private final String replacements[] = new String[2];

		URIReplacer() {
			matchers[0] = Pattern
					.compile(
							"platform:/plugin/com\\.zeligsoft\\.domain\\.sca/modelLibrary/")
					.matcher("");
			replacements[0] = "pathmap://SCA_LIBRARIES/";

			matchers[1] = Pattern.compile(
					"platform:/plugin/com\\.zeligsoft\\.domain\\.sca/profile/")
					.matcher("");
			replacements[1] = "pathmap://SCA_PROFILES/";
		}

		boolean replaceLine(String inputLine, StringBuilder output) {
			boolean result = false;

			for (int i = 0; i < matchers.length; i++) {
				matchers[i].reset(inputLine);

				if (matchers[i].find()) {
					result |= true;
					inputLine = matchers[i].replaceAll(replacements[i]);
				}
			}

			output.append(inputLine);
			output.append(newline);

			return result;
		}
	}
}
