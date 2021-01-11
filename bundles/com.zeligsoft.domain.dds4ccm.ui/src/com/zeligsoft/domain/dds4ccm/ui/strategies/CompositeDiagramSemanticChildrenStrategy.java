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

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.not;
import static org.eclipse.papyrus.uml.tools.utils.UMLUtil.isAssociationEnd;
import static org.eclipse.papyrus.uml.tools.utils.UMLUtil.isRelationship;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.canonical.DefaultUMLSemanticChildrenStrategy;
import org.eclipse.papyrus.uml.diagram.composite.custom.canonical.StructuredClassifierSemanticChildrenStrategy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

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
		List<Element> result = new ArrayList<Element>();

		// result from Superclass
		if (semanticFromEditPart instanceof Element) {
			Element element = (Element) semanticFromEditPart;
			Iterable<Element> owned = element.getOwnedElements();

			// Never include relationships that are owned, because they would be found
			// when relationships are requested
			owned = Iterables.filter(owned, not(isRelationship()));

			// And also don't include association ends because we visualize the association,
			// unless we actually won't visualize the association because the other type
			// is not present in the diagram, in which case the attribute style is the only
			// way we can show the end
			owned = Iterables.filter(owned, not(and(isAssociationEnd(), isPropertyTypeVisualized(viewFromEditPart))));

			result = Lists.newArrayList(owned);
		}
		
		// Customize result for CX composite structure diagram
		StructuredClassifier composite = (semanticFromEditPart instanceof StructuredClassifier)
				? (StructuredClassifier) semanticFromEditPart
				: null;
		if (composite != null && !(viewFromEditPart instanceof Diagram)) {
			// We should visualize inherited parts
			for(Property p : composite.getAllAttributes()) {
				if(!result.contains(p)) {
					result.add(p);
				}
			}
			
			// Remove port decoration
			if (viewFromEditPart instanceof DecorationNode) {
				result.removeIf(Port.class::isInstance);
			}
		}

		return result;
	}
}
