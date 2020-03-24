/**
 * Copyright 2019 ADLINK Technology Limited.
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
 * Contributors:
 * 	Young-Soo Roh - Initial implementation
 *
 */
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil;

public class RepairWorkerFunctionsHandler extends AbstractHandler {

	private List<Package> loadedModels = new ArrayList<Package>();

	private ResourceSet tmpRset = null;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject eo = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());
		if (eo == null) {
			return null;
		}

		loadedModels.add((Package) EcoreUtil.getRootContainer(eo));
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eo);
		Command cmd = new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				for (Package m : loadedModels) {
					DDS4CCMMigrationUtil.repairAllWorkerfunctions(m);
				}
			}
		};

		domain.getCommandStack().execute(cmd);

		return null;
	}

	/**
	 * Load all UML resources in a folder
	 * 
	 * @param rset
	 * @param container
	 */
	public void loadAllResources(ResourceSet rset, IContainer container) {
		try {
			IResource[] members = container.members();

			for (IResource member : members) {
				if (member instanceof IProject) {
					if (!((IProject) member).isOpen()) {
						// Ignore closed projects
						continue;
					}
				}
				if (member instanceof IContainer) {
					loadAllResources(rset, (IContainer) member);
				} else if (member instanceof IFile) {
					IFile file = (IFile) member;
					if ("uml".equals(file.getFullPath().getFileExtension().toLowerCase())) {
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
						for (Resource r : rset.getResources()) {
							if (uri.equals(rset.getURIConverter().normalize(r.getURI()))) {
								loadedModels.add((Package) r.getContents().get(0));
								continue;
							}
						}
						Package root = UML2Util.load(getTmpResourceSet(), uri, UMLPackage.Literals.PACKAGE);
						if (root != null && ZDLUtil.isZDLProfile(root, "cxDDS4CCM")) {
							Resource r = rset.getResource(uri, true);
							loadedModels.add((Package) r.getContents().get(0));
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private ResourceSet getTmpResourceSet() {
		if (tmpRset == null) {
			tmpRset = new ResourceSetImpl();
		}
		return tmpRset;
	}

}
