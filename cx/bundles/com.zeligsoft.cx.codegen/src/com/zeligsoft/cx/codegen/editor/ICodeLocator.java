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
package com.zeligsoft.cx.codegen.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;

public interface ICodeLocator
{
	/**
	 * Returns the line number of the argument file on which the argument object's code
	 * begins.  Return -1 if no code can be found for the argument object. 
	 */
	public int getLineNumber( IFile file, EObject object, String concept, String property );
	
	/**
	 * Returns the line number of the argument file on which the argument object's code
	 * begins. Returns -1 if no code can be found for the argument object.
	 * 
	 * @param file
	 * @param object
	 * @param concept
	 * @param property
	 * @param language Language of worker implementation, e.g. "C++" or "C"
	 * @return
	 */
	public int getLineNumber( IFile file, EObject object, String concept, String property, String language );
}
