/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.architecture.merged;

import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.Stakeholder;

/**
 * An EMF-style switch over the types of the merged domain model façade API.
 *
 * @since 3.1
 */
public class MergedArchitectureSwitch<T> {

	public T caseADElement(MergedADElement object) {
		return null;
	}

	public T caseArchitectureDomain(MergedArchitectureDomain object) {
		return null;
	}

	public T caseArchitectureContext(MergedArchitectureContext object) {
		return null;
	}

	public T caseArchitectureDescriptionLanguage(MergedArchitectureDescriptionLanguage object) {
		return null;
	}

	public T caseArchitectureFramework(MergedArchitectureFramework object) {
		return null;
	}

	public T caseArchitectureViewpoint(MergedArchitectureViewpoint object) {
		return null;
	}

	public T caseStakeholder(Stakeholder object) {
		return null;
	}

	public T caseConcern(Concern object) {
		return null;
	}

	public T caseRepresentationKind(RepresentationKind object) {
		return null;
	}

	public T defaultCase(Object object) {
		return null;
	}

	public T doSwitch(Object object) {
		T result = null;

		if (result == null && object instanceof RepresentationKind) {
			result = caseRepresentationKind((RepresentationKind) object);
		}
		if (result == null && object instanceof Concern) {
			result = caseConcern((Concern) object);
		}
		if (result == null && object instanceof Stakeholder) {
			result = caseStakeholder((Stakeholder) object);
		}
		if (result == null && object instanceof MergedArchitectureViewpoint) {
			result = caseArchitectureViewpoint((MergedArchitectureViewpoint) object);
		}
		if (result == null && object instanceof MergedArchitectureFramework) {
			result = caseArchitectureFramework((MergedArchitectureFramework) object);
		}
		if (result == null && object instanceof MergedArchitectureDescriptionLanguage) {
			result = caseArchitectureDescriptionLanguage((MergedArchitectureDescriptionLanguage) object);
		}
		if (result == null && object instanceof MergedArchitectureContext) {
			result = caseArchitectureContext((MergedArchitectureContext) object);
		}
		if (result == null && object instanceof MergedArchitectureDomain) {
			result = caseArchitectureDomain((MergedArchitectureDomain) object);
		}
		if (result == null && object instanceof MergedADElement) {
			result = caseADElement((MergedADElement) object);
		}
		if (result == null && object != null) {
			result = defaultCase(object);
		}

		return result;
	}

}
