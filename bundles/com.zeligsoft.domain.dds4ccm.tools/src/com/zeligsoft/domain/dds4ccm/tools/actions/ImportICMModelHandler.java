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

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.domain.dds4ccm.tools.dialogs.ICMBrowseDialog;

/**
 * ICM model import handler.
 * 
 * @author Young-Soo Roh
 *
 */
public class ImportICMModelHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final EObject selObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());
		if (selObject == null) {
			return null;
		}

		ICMBrowseDialog dialog = new ICMBrowseDialog(Display.getCurrent().getActiveShell());

		if (Window.OK == dialog.open()) {
			URI uri = dialog.getSelectedResourceUri();
			if (uri != null) {
				createPackageImport((Model) selObject, uri);
			}
		}
		return null;
	}

	private void createPackageImport(Model model, URI importResourceUri) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
		ResourceSet rset = domain.getResourceSet();
		org.eclipse.uml2.uml.Package targetModel = UML2Util.load(rset, importResourceUri,
				UMLPackage.Literals.PACKAGE);
		Command cmd = new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				model.createPackageImport(targetModel);
			}
		};
		domain.getCommandStack().execute(cmd);
		
		// Make the reference model editable
		Resource r = targetModel.eResource();
		IReadOnlyHandler2 readOnlyHandler = ReadOnlyManager.getReadOnlyHandler(domain);
		List<URI> uris = CXDynamicURIConverter.getAssociatedUris(r);
		if (readOnlyHandler.canMakeWritable(ReadOnlyAxis.anyAxis(), uris.toArray(new URI[0])).or(false)) {
			if (!uris.isEmpty()) {
				readOnlyHandler.makeWritable(ReadOnlyAxis.anyAxis(), uris.toArray(new URI[0]));
			}
		}
	}
}
