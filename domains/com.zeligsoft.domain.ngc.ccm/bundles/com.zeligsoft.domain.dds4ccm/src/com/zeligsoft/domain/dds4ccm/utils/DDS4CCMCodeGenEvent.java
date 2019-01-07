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
package com.zeligsoft.domain.dds4ccm.utils;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * Instances of this class provide a description generation activity within
 * DDS4CCM domain.
 * 
 * @author ysroh
 * 
 */
public class DDS4CCMCodeGenEvent implements ICodeGenEvent {

	private EObject element;
	private Set<String> pathnames = new HashSet<String>();

	public DDS4CCMCodeGenEvent(EObject element, Set<String> pathnames) {
		this.element = element;
		this.pathnames.addAll(pathnames);
	}

	/**
	 * Queries the model element of current generation activity
	 * 
	 * @return Model element
	 */
	@Override
	public EObject getElement() {
		return element;
	}

	/**
	 * Queries the set of pathnames to the IDL / xml files
	 * 
	 * @return List of pathnames
	 */
	@Override
	public Set<String> getPathnames() {
		return pathnames;
	}

}
