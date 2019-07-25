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

import org.eclipse.internal.xtend.type.baseimpl.StaticPropertyImpl;
import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * The oAW representation of a ZDL enumeration literal.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLEnumLiteral
		extends StaticPropertyImpl {

	private ZDLEnumType owner;
	private EnumerationLiteral domainEnumLiteral;
	
	/**
	 * Initializes me with my owner and domain enumeration literal.
	 * 
	 * @param owner
	 *            my owning ZDL enumeration type
	 * @param domainEnumLiteral
	 *            the domain enumeration literal that I encapsulate
	 */
	public ZDLEnumLiteral(ZDLEnumType owner,
			EnumerationLiteral domainEnumLiteral) {
		super(owner, domainEnumLiteral.getName(), owner);
		
		this.owner = owner;
		this.domainEnumLiteral = domainEnumLiteral;
	}

	public Object get() {
		// use a token that has an unique identity, apart from the domain model
		// of the enumeration literal, because we need to hijack the toString()
		// operation in order to display nicely in text as the EEnumLiteral does
		return owner.getInstance(domainEnumLiteral);
	}

}
