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
package com.zeligsoft.domain.omg.dds.rsm.ui.viewcustomizers;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.dds.DDSNames;



/**
 * @author Toby McClean
 *
 */
public final class DDSComponentViewCustomizer extends AbstractComponentViewCustomizer {
	
	/**
	 * The only instance of <code>DDSComponentViewCustomizer</code>
	 */
	public static final DDSComponentViewCustomizer INSTANCE 
		= new DDSComponentViewCustomizer();
	
	/**
	 * Initialize me
	 */
	private DDSComponentViewCustomizer() {
		// do not let others instantiate me
		super();
	}
	
	protected boolean isCandidate(EObject candidate) {
		return ZDLUtil.isZDLConcept(candidate, DDSNames.DDSCOMPONENT);
	}
}
