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
package com.zeligsoft.cx.codegen.ui.oaw;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.cx.codegen.rsm.IEObjectLocator;

// TODO RSM dependency
public class UMLModelerEObjectLocator implements IEObjectLocator
{
	@Override
	public EObject getEObject( URI uri )
	{
		ResourceSet rs = UMLModeler.getEditingDomain().getResourceSet();
		return rs == null ? null : rs.getEObject( uri, true );
	}
}
