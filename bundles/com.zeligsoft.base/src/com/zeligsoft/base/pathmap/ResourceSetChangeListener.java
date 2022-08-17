/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.base.pathmap;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;

import com.zeligsoft.base.util.ZeligsoftURIConverter;

/**
 * Install URI converter for resource set
 * 
 * @author Young-Soo Roh
 *
 */
public class ResourceSetChangeListener extends ResourceSetListenerImpl {

	/**
	 * Initializes me.
	 */
	public ResourceSetChangeListener() {
		super();
	}

	@Override
	public boolean isPostcommitOnly() {
		return true;
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		ZeligsoftURIConverter.install(event.getEditingDomain().getResourceSet());
	}
}
