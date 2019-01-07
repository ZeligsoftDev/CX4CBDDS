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
package com.zeligsoft.domain.ngc.ccm.generator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;

import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;

/**
 * Utilities to access annotations on IDL language model elements.
 * 
 * @author smcfee
 *
 */
@SuppressWarnings("nls")
public class AnnotationUtil {

	/**
	 * The key for the filename in the ZCX_ANNOTATION
	 */
	public static final String FILENAME_KEY = "filename";
	
	/**
	 * The key for the file type in the ZCX_ANNOTATION
	 */
	public static final String FILETYPE_KEY = "filetype";

	/**
	 * The key for the entity name in the ZCX_ANNOTATION
	 */
	public static final String ENTITYNAME_KEY = "entityname";
	
	/**
	 * The key for the entity type in the ZCX_ANNOTATION
	 */
	public static final String ENTITYTYPE_KEY = "entitytype";
	
	/**
	 * Package file type
	 */
	public static final String PACKAGE_FILETYPE = "package";
	
	/**
	 * The source for the generation metadata
	 */
	public static final String ZCX_ANNOTATION = "zcx";
	
	/**
	 * Queries the entity name from the specification
	 * 
	 * @param model
	 * @return
	 */
	public static String getZCXAnnotationDetail(Object model, String detailKey) {
		if (model instanceof Specification) {
			EModelElement theSpecification = (Specification) model;
			EAnnotation zcxAnnotation = theSpecification
					.getEAnnotation(ZCX_ANNOTATION);
			if (zcxAnnotation != null) {
				String value = zcxAnnotation.getDetails().get(
						detailKey);
				if (value != null && !value.isEmpty()) {
					return value;
				}
			}
		}
		return null;
	}
	
}
