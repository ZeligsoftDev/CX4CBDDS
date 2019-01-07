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
package com.zeligsoft.cx.codegen.postprocessor;

import org.eclipse.emf.ecore.EObject;

/**
 * Interface for a code-editor post-processor.
 * 
 * @author smcfee
 *
 */
public interface CodeEditorPostProcessor {
	
	/**
	 * Tells the postprocessor about an EObject that was impacted by code changing in a user-editable region.
	 * 
	 * @param notifyingObject
	 * 	The EObject that was changed.
	 */
	public void notifyObject(EObject notifyingObject);
	
	/**
	 * Invokes the postprocessor.
	 */
	public void postProcess();

}
