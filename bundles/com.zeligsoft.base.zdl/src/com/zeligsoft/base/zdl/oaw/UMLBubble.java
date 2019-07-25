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
package com.zeligsoft.base.zdl.oaw;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.uml2.uml.Element;
import org.eclipse.xtend.typesystem.Type;

/**
 * A bubble of UML-ness that wraps a model element to protect it from being
 * recognized as an instance of a ZML concept. This is useful when an oAW
 * transformation needs to treat an element as a "vanilla" UML element.
 * 
 * @author Christian W. Damus (cdamus)
 */
class UMLBubble {

	private Type type;

	private Element element;

	/**
	 * Initializes me to wrap the specified UML element in a bubble of the
	 * specified UML type.
	 * 
	 * @param umlType
	 *            my protective UML bubble type
	 * @param umlElement
	 *            the UML element that I protect
	 */
	UMLBubble(Type umlType, Element umlElement) {
		if (!(umlType instanceof UMLMetaclassType)) {
			throw new IllegalArgumentException(
				"umlType is not a UMLMetaclassType"); //$NON-NLS-1$
		}

		this.type = umlType;
		this.element = umlElement;
	}

	/**
	 * Obtains my UML bubble type.
	 * 
	 * @return my type
	 */
	Type getType() {
		return type;
	}

	/**
	 * Obtains the UML element that I protect.
	 * 
	 * @return my UML element
	 */
	Element getElement() {
		return element;
	}

	/**
	 * Bursts an object's bubble, if it is in a bubble. This exposes the
	 * protected element.
	 * 
	 * @param bubble
	 *            a bubble or not, or an array or collection of bubbles or
	 *            non-bubbles
	 * @return the bubble's protected element, or the original object if it
	 *         isn't a bubble
	 */
	@SuppressWarnings("unchecked")
	static <T> T burst(T bubble) {
		if (bubble instanceof UMLBubble) {
			bubble = (T) ((UMLBubble) bubble).getElement();
		} else if (bubble instanceof Object[]) {
			Object[] array = (Object[]) bubble;

			if (array.length > 0) {
				Object[] burstBubbles = (Object[]) Array.newInstance(array
					.getClass().getComponentType(), array.length);
				for (int i = 0; i < array.length; i++) {
					burstBubbles[i] = burst(array[i]);
				}
				bubble = (T) burstBubbles;
			}
		} else if (bubble instanceof List) {
			List<?> list = (List<?>) bubble;

			if (!list.isEmpty() && (list.get(0) instanceof UMLBubble)) {
				List<Object> burstBubbles = new java.util.ArrayList<Object>(
					list.size());
				for (Object next : list) {
					burstBubbles.add(burst(next));
				}
				bubble = (T) burstBubbles;
			}
		} else if (bubble instanceof Set) {
			Set<?> set = (Set<?>) bubble;

			if (!set.isEmpty()) {
				Iterator<?> iter = set.iterator();

				Object next = iter.next();
				if ((next instanceof UMLBubble)) {
					Set<Object> burstBubbles = new java.util.HashSet<Object>();
					burstBubbles.add(burst(next));
					while (iter.hasNext()) {
						burstBubbles.add(burst(iter.next()));
					}
					bubble = (T) burstBubbles;
				}
			}
		}

		return bubble;
	}
	
	@Override
	public String toString() {
		return String.format("UMLBubble[%s,%s]", this.type, this.element);
	}
}
