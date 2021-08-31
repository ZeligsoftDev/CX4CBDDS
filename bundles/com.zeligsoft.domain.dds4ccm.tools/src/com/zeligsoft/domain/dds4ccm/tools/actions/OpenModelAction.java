/**
 * Copyright 2021 Northrop Grumman Systems Corporation.
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.ui.editor.PapyrusPageInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * Open model action
 * 
 * @author Young-Soo Roh
 *
 */
public class OpenModelAction extends BaseSelectionListenerAction {

	private IFile file;

	public OpenModelAction(URI uri) {
		super(Messages.OpenModelAction_ActionTitle);
		setEnabled(false);
		URI normalizedUri = URIConverter.INSTANCE.normalize(uri);
		String path = normalizedUri.trimFileExtension().appendFileExtension("di").toPlatformString(true); //$NON-NLS-1$
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
			if (file.exists()) {
				this.file = file;
				setEnabled(true);
			}
		}
	}

	@Override
	public void run() {

		IWorkbenchPage page = BaseUIUtil.getActivepage();
		if (page != null) {
			IFileEditorInput input = new PapyrusPageInput(file, new URI[0], false);
			try {
				page.openEditor(input, PapyrusMultiDiagramEditor.EDITOR_ID);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}
}
