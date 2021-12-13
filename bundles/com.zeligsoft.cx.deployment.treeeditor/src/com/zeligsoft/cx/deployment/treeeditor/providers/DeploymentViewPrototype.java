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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.architecture.representation.PapyrusRepresentationKind;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * A dummy ViewPrototype to implement workaround for Issue #118
 * 
 * @author young-sooroh
 *
 */
public class DeploymentViewPrototype extends ViewPrototype {

	protected DeploymentViewPrototype(PapyrusRepresentationKind representationKind) {
		super(representationKind);
	}

	@Override
	public boolean isOwnerReassignable() {
		return false;
	}

	@Override
	public boolean instantiateOn(EObject owner) {
		return false;
	}

	@Override
	public boolean instantiateOn(EObject owner, String name) {
		return false;
	}

	@Override
	public Command getCommandChangeOwner(EObject view, EObject target) {
		return null;
	}

	@Override
	public Command getCommandChangeRoot(EObject view, EObject target) {
		return null;
	}

	@Override
	public EObject getOwnerOf(EObject view) {
		return null;
	}

	@Override
	public EObject getRootOf(EObject view) {
		return null;
	}

}
