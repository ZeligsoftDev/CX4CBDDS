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
package com.zeligsoft.base.zdl.type;

import java.net.URL;

import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.NullElementType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;

/**
 * The definition of a ZDL element type, applicable both to ZDL concepts and to
 * ZDL references.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLElementType
		extends SpecializationType {
	
	/**
	 * The pre-fix for all ZDLElementTypes ids.
	 */
	static String ZDL_ELEMENT_TYPE_ID__BASE = "com.zeligsoft.zdl."; //$NON-NLS-1$

	private String concept;

	private String reference;

	/**
	 * Initializes me with all of the details of a ZDL concept element type.
	 * 
	 * @param concept
	 *            the qualified name of the ZDL concept
	 * @param id
	 * @param iconURL
	 * @param displayName
	 * @param elementTypes
	 * @param matcher
	 * @param descriptor
	 * @param editHelperAdvice
	 */
	public ZDLElementType(String concept, String id, URL iconURL,
			String displayName, IElementType[] elementTypes,
			IElementMatcher matcher, IContainerDescriptor descriptor,
			IEditHelperAdvice editHelperAdvice) {
		super(id, iconURL, displayName, elementTypes, matcher, descriptor,
			editHelperAdvice);

		this.concept = concept;
	}

	/**
	 * Initializes me with all of the details of a ZDL reference element type.
	 * 
	 * @param concept
	 *            the qualified name of the ZDL concept
	 * @param reference
	 *            the name of the concept's reference
	 * @param id
	 * @param iconURL
	 * @param displayName
	 * @param elementTypes
	 * @param matcher
	 * @param descriptor
	 * @param editHelperAdvice
	 */
	public ZDLElementType(String concept, String reference, String id,
			URL iconURL, String displayName, IElementType[] elementTypes,
			IElementMatcher matcher, IContainerDescriptor descriptor,
			IEditHelperAdvice editHelperAdvice) {
		super(id, iconURL, displayName, elementTypes, matcher, descriptor,
			editHelperAdvice);

		this.concept = concept;
		this.reference = reference;
	}

	/**
	 * Obtains the qualified name of the concept that I represent or, in the
	 * case of a ZDL reference type, that defines the reference attribute that I
	 * represent.
	 * 
	 * @return my domain concept
	 */
	public String getDomainConcept() {
		return concept;
	}

	/**
	 * Obtains the name of the domain reference that I represent, if I do
	 * represent a domain reference.
	 * 
	 * @return my domain reference name, or <code>null</code> if I am a
	 *         concept element type
	 */
	public String getDomainReference() {
		return reference;
	}

	@Override
	public IEditHelper getEditHelper() {
		return NullElementType.getInstance().getEditHelper();
	}
}
