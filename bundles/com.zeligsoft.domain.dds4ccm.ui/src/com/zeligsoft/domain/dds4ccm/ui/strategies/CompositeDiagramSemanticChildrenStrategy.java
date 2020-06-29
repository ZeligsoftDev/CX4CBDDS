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
package com.zeligsoft.domain.dds4ccm.ui.strategies;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.canonical.DefaultUMLSemanticChildrenStrategy;
import org.eclipse.papyrus.uml.diagram.composite.custom.canonical.StructuredClassifierSemanticChildrenStrategy;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * This class overrides the default canonical strategy <@code
 * {@link StructuredClassifierSemanticChildrenStrategy} to fix an issue with
 * inherited ports.
 * 
 * @author Young-Soo Roh
 *
 */
public class CompositeDiagramSemanticChildrenStrategy extends DefaultUMLSemanticChildrenStrategy {

	public CompositeDiagramSemanticChildrenStrategy() {
		super();
	}

	@Override
	public List<? extends EObject> getCanonicalSemanticChildren(EObject semanticFromEditPart, View viewFromEditPart) {
		List<? extends EObject> result;

		StructuredClassifier composite = (semanticFromEditPart instanceof StructuredClassifier)
				? (StructuredClassifier) semanticFromEditPart
				: null;
		if (composite == null) {
			result = super.getCanonicalSemanticChildren(semanticFromEditPart, viewFromEditPart);
		} else if (!(viewFromEditPart instanceof Diagram)) {
			result = new java.util.ArrayList<>(composite.getAllAttributes());
			if (viewFromEditPart instanceof DecorationNode) {
				result.removeIf(Port.class::isInstance);
			}
		} else {
			result = Collections.emptyList();
		}

		return result;
	}
}
