/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.actions;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;

/**
 * Fix model references to use the dynamic mappings for external references
 * 
 * @author Young-Soo Roh
 *
 */
@SuppressWarnings("nls")
public class FixModelReferencesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelectionService service = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();

		ISelection selection = service.getSelection();

		if (selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();

			IFile file = (IFile) Platform.getAdapterManager().getAdapter(selected, IFile.class);
			IPath containerPath = file.getParent().getFullPath();
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));
				StringBuffer outBuffer = new StringBuffer();
				while (reader.ready()) {
					String line = reader.readLine();
					String outLine = line;
					int startIndex = line.indexOf("href=\"");
					int tokenLength = "href=\"".length();
					int endIndex = line.indexOf(".uml", startIndex);
					if (startIndex > 0 && endIndex > 0) {
						String beforeString = line.substring(0, startIndex + tokenLength);
						String afterString = line.substring(endIndex + ".uml".length());
						String href = line.substring(startIndex + tokenLength, endIndex + ".uml".length());
						URI modelUri = null;
						if (href.startsWith("..")) {
							// handle relative reference
							IPath modelPath = containerPath.append(href);
							modelUri = URI.createPlatformResourceURI(modelPath.toString(), true);
						} else if (href.startsWith("platform:/resource")) {
							// handle platform resource reference
							modelUri = URI.createURI(href);
						}
						if (modelUri != null) {
							URI pathmapUri = CXDynamicURIConverter.getPathmapURI(modelUri);
							outLine = beforeString + pathmapUri.toString() + afterString;
						}
					}
					outBuffer.append(outLine).append(System.lineSeparator());
				}
				reader.close();

				// produce output
				String outContents = outBuffer.toString();
				byte[] bytes = outContents.getBytes();
				InputStream source = new ByteArrayInputStream(bytes);
				file.setContents(source, IResource.FORCE, new NullProgressMonitor());
			} catch (CoreException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return null;
	}

}
