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

package com.zeligsoft.cx.deployment.treeeditor.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.extension.diagrameditor.EditorDescriptor;
import org.eclipse.papyrus.infra.ui.extension.diagrameditor.IPluggableEditorFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.treeeditor.ui.DeploymentTreeEditor;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Papyrus Editor editor factory for the welcome page.
 */
public class DeploymentEditorFactory implements IPluggableEditorFactory {

	protected ServicesRegistry services;

	private ImageDescriptor icon;

	public DeploymentEditorFactory() {
		super();
	}

	@Override
	public void init(ServicesRegistry serviceRegistry, EditorDescriptor editorDescriptor) {
		this.services = serviceRegistry;
		this.icon = editorDescriptor.getIcon();
	}

	@Override
	public IPageModel createIPageModel(Object pageIdentifier) {
		return new DeploymentEditorPageModel((Component)pageIdentifier);
	}

	@Override
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		if(pageIdentifier instanceof EObject && ZDLUtil.isZDLConcept((EObject)pageIdentifier, ZMLMMNames.DEPLOYMENT)) {
			return true;
		}
		return false;
	}

	//
	// Nested types
	//

	private class DeploymentEditorPageModel implements IPageModel, IEditorModel {

		private Component deployment;
		private Image iconImage;

		DeploymentEditorPageModel(Component model) {
			super();
			this.deployment = model;
		}

		@Override
		public String getTabTitle() {
			return deployment.getLabel();
		}

		@Override
		public Image getTabIcon() {
			if ((iconImage == null) && (icon != null)) {
				iconImage = icon.createImage(Display.getCurrent());
			}

			return iconImage;
		}

		@Override
		public Object getRawModel() {
			return deployment;
		}

		@Override
		public void dispose() {
			if (iconImage != null) {
				iconImage.dispose();
				iconImage = null;
			}
		}

		@Override
		public IEditorPart createIEditorPart() throws PartInitException {

			// ToDo: Check if deployment editor part already exist for this deployment
			DeploymentTreeEditor editor = new DeploymentTreeEditor(deployment);
			return editor;
		}

		@Override
		public EditorActionBarContributor getActionBarContributor() {
			//return new TreeEditorContributor();
			return null;
		}

	}
}
