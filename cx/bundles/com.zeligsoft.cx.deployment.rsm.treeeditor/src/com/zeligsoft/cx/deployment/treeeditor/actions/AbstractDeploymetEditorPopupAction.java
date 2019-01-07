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
package com.zeligsoft.cx.deployment.treeeditor.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.Viewer;

import com.zeligsoft.cx.deployment.treeeditor.DeploymentView;

/**
 * Abstract deployment editor pop-up action.
 * 
 * @author ysroh
 * 
 */
public abstract class AbstractDeploymetEditorPopupAction extends Action implements
		ISelectionChangedListener {

	protected Viewer viewer;

	protected DeploymentView view;

	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
		this.viewer.addSelectionChangedListener(this);
	}

	public void setDeploymentView(DeploymentView view) {
		this.view = view;
	}

	protected Viewer getViewer() {
		return viewer;
	}

	protected DeploymentView getDeploymentView() {
		return view;
	}

}
