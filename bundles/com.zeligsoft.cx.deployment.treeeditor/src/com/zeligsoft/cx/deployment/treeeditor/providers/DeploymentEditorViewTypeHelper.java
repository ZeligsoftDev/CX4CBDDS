/*******************************************************************************
 * Copyright (c) 2021 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.cx.deployment.treeeditor.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.architecture.representation.PapyrusRepresentationKind;
import org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * A ViewTypeHelper class to implement workaround for Issue #118
 * 
 * @author young-sooroh
 *
 */
public class DeploymentEditorViewTypeHelper implements IViewTypeHelper {

	public DeploymentEditorViewTypeHelper() {
	}

	@Override
	public boolean isSupported(EClass type) {
		return false;
	}

	@Override
	public boolean isSupported(EObject view) {
		if (view != null && ZDLUtil.isZDLConcept(view, ZMLMMNames.DEPLOYMENT)) {
			return true;
		}
		return false;
	}

	@Override
	public ViewPrototype getPrototypeFor(PapyrusRepresentationKind configuration) {
		return null;
	}

	@Override
	public ViewPrototype getPrototypeOf(EObject view) {
		// Return a view prototype with valid diagram type so that deployment editor can
		// pass the validation from IPageManager
		// Issue #118
		ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
		PapyrusRepresentationKind kind = null;
		if ("AXCIOMA".equals(manager.getDefaultArchitectureContext().getName())) { //$NON-NLS-1$
			kind = (PapyrusRepresentationKind) manager
					.getRepresentationKindById("com.zeligosft.domain.cbdds.axcioma.diagram.composite"); //$NON-NLS-1$
		} else {
			kind = (PapyrusRepresentationKind) manager
					.getRepresentationKindById("com.zeligosft.domain.cbdds.atcd.diagram.composite"); //$NON-NLS-1$
		}
		return new DeploymentViewPrototype(kind);
	}

}
