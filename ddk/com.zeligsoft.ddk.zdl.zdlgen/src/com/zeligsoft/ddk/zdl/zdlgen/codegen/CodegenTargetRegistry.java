/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.codegen;

import java.util.Collection;

import org.eclipse.core.runtime.IExtension;

import com.zeligsoft.ddk.zdl.zdlgen.internal.codegen.CodegenTargetRegistryImpl;


public interface CodegenTargetRegistry {
	/**
	 * The shared instance of the registry.
	 */
	CodegenTargetRegistry INSTANCE = new CodegenTargetRegistryImpl();
	
	/**
	 * Return all of the extensions of the DDK codegen target extension
	 * point that have been registered.
	 * @return
	 */
	//Collection<IExtension> getExtensions();
	
	//IExtension getExtension(String id);
	
	Collection<DDKCodegenTarget> getTargets();
	
	DDKCodegenTarget getTarget(String id);
}
