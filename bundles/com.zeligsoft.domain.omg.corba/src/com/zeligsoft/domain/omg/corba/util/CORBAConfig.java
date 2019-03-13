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
package com.zeligsoft.domain.omg.corba.util;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class CORBAConfig {

	/**
	 * 
	 */
	protected CORBAConfig() {
		super();
	}
	
	public static void configureConstant(org.eclipse.uml2.uml.Property prop) {
		prop.setVisibility(VisibilityKind.PUBLIC_LITERAL);
	}

	public static void configureCORBAAttribute(org.eclipse.uml2.uml.Property prop) {
		prop.setVisibility(VisibilityKind.PUBLIC_LITERAL);
	}
	
	public static void configureArray(org.eclipse.uml2.uml.DataType array) {
		if (array.getOwnedAttribute("members", null) == null) {
			Property attr = array.createOwnedAttribute("members", null);
			attr.setUpper(-1);
			attr.setLower(0);
		}
	}

	public static void configureSequence(org.eclipse.uml2.uml.DataType seq) {
		if (seq.getOwnedAttribute("members", null) == null) {
			Property attr = seq.createOwnedAttribute("members", null);
			attr.setUpper(-1);
			attr.setLower(0);
		}
	}
	
	public static void configureUnion(org.eclipse.uml2.uml.DataType union) {
		if (union.getOwnedAttribute("switchType", null) == null) {
			Property attr = union.createOwnedAttribute("switchType", null);
			attr.setUpper(1);
			attr.setLower(0);
		}
	}
}
