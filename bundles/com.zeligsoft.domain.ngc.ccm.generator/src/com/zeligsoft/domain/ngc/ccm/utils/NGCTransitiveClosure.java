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
package com.zeligsoft.domain.ngc.ccm.utils;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.uml2.uml.Element;

/**
 * Given a model element this will calculate the transitive closure of the
 * elements that need to be generated into files for Northrop Grunman.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class NGCTransitiveClosure {
	
	/**
	 * The only instance of me.
	 */
	public final NGCTransitiveClosure INSTANCE = new NGCTransitiveClosure();
	
	/**
	 * Create me, but don't let anyone do it since I have no state
	 */
	protected NGCTransitiveClosure() {
		// Nothing to do
	}
	
	/**
	 * Calculate the transitive closure of the elements that need to be
	 * generated into files given the <code>theSourceElement</code>.
	 * 
	 * @param theSourceElement
	 * 		the Element to use as the source of the transitive closure
	 * 		calculation
	 * @return
	 * 		the list of Elements to generate into files.
	 */
	public Set<Element> calculate(Element theSourceElement) {
		Set<Element> results = new HashSet<Element>();
		
		return results;
	}
	
	protected Set<Element> caseInterface(Element theSourceElement) {
		
		return new HashSet<Element>();
	}
	
	
}
