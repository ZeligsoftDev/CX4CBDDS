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
package com.zeligsoft.domain.ngc.ccm.idltouml.merge;

import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * A key implementation appropriate to {@link NamedElement}s and
 * {@link ENamedElement}s, generally.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
class NamedElementKey extends AbstractHierarchicalKey<NamedElementKey> {

	private String name;

	/**
	 * Initializes me with a UML named element.
	 * 
	 * @param element the named element
	 */
	public NamedElementKey(NamedElement element) {
		super(element);
		
		this.name = element.getName();
	}

	/**
	 * Initializes me with an Ecore named element.
	 * 
	 * @param element the named element
	 */
	public NamedElementKey(ENamedElement element) {
		super(element);

		this.name = (element instanceof EPackage)
			? ((EPackage) element).getNsURI()
			: element.getName();
	}

	/**
	 * Initializes me with an annotation (named by its source).
	 * 
	 * @param element the annotation
	 */
	public NamedElementKey(EAnnotation element) {
		super(element);

		this.name = element.getSource();
	}

	/**
	 * Initializes me with an annotation details entry (named by its key).
	 * 
	 * @param element the details entry
	 */
	public NamedElementKey(Map.Entry<String, String> element) {
		super((EObject) element);

		this.name = element.getKey();
	}

	@Override
	protected boolean keyEquals(NamedElementKey other) {
		return UML2Util.safeEquals(name, other.name);
	}

	@Override
	protected int keyHash() {
		return (name == null)
			? 0
			: name.hashCode();
	}

}
