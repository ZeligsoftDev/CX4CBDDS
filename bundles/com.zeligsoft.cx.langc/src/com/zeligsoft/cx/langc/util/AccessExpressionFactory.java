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
package com.zeligsoft.cx.langc.util;

import com.zeligsoft.cx.langc.ElementAccess;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.LangCFactory;
import com.zeligsoft.cx.langc.VariableDeclaration;

public class AccessExpressionFactory extends LangCSwitch<ElementAccess> {

	@Override
	public ElementAccess caseElementReference(ElementReference object) {
		// TODO this should use the value of ptr, const, etc. to modify the basic, element-
		//      specific expression
		return doSwitch(object.getElement());
	}

	@Override
	public ElementAccess caseVariableDeclaration(VariableDeclaration object) {
		return LangCFactory.eINSTANCE.createElementAccess();
	}
}
