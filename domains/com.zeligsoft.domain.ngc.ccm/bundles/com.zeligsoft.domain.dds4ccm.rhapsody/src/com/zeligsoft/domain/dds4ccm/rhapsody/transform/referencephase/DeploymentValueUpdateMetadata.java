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
package com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase;

import org.eclipse.emf.ecore.EObject;

import com.telelogic.rhapsody.core.IRPModelElement;

public final class DeploymentValueUpdateMetadata {
	private final EObject element;
	private final IRPModelElement rhapsodyDeploymentPart;

	public DeploymentValueUpdateMetadata(EObject element, IRPModelElement rhapsodyPart) {
		this.element = element;
		this.rhapsodyDeploymentPart = rhapsodyPart;
	}

	public EObject getElement() {
		return element;
	}

	public IRPModelElement getRhapsodyDeploymentPart() {
		return rhapsodyDeploymentPart;
	}

}
