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

import java.util.Set;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.zeligsoft.ddk.zdl.zdlgen.plugin.ZDLGenPlugin;

public class DDKCodegenAction {
	private final String id;
	private final String name;
	private final String bundle;
	private final String extend;
	private final String iCodegenAction;
	private final String suppress;
	private final Set<Class<?>> appliesTo;
	/**
	 * @param id
	 * @param name
	 * @param extend
	 * @param iCodegenAction
	 * @param suppress
	 */
	public DDKCodegenAction(String id, String name, String bundle, String extend,
			String iCodegenAction, String suppress) {
		super();
		this.id = id;
		this.name = name;
		this.bundle = bundle;
		this.extend = extend;
		this.iCodegenAction = iCodegenAction;
		this.suppress = suppress;
		appliesTo = Sets.newHashSet();
	}
	
	public DDKCodegenAction(final DDKCodegenAction toCopy) {
		this(toCopy.getId(),
				toCopy.getName(),
				toCopy.getBundle(),
				toCopy.getExtend(),
				toCopy.getiCodegenAction(),
				toCopy.getSuppress());
	}
	
	/**
	 * @return the bundle
	 */
	public String getBundle() {
		return bundle;
	}

	/**
	 * Merge the extender into me. This allows for an extender which has
	 * an extend attribute equal to my id to override the name and 
	 * iCodegenAction elements.
	 * 
	 * @param extender
	 * @return
	 * 		A new DDKCodegenAction which is the result of the merge.
	 */
	public DDKCodegenAction merge(final DDKCodegenAction extender) {
		final String mergedId = this.getId();
		String mergedName;
		String mergedICodegenAction;
		Set<Class<?>> mergedAppliesTo; 
		
		mergedName = Strings.isNullOrEmpty(extender.getName()) ?
						this.name : extender.getName();
		mergedICodegenAction = Strings.isNullOrEmpty(extender.getiCodegenAction()) ?
						this.iCodegenAction : extender.getiCodegenAction();
		mergedAppliesTo = extender.appliesTo.isEmpty() ?
						this.appliesTo : extender.appliesTo;
		final DDKCodegenAction result = new DDKCodegenAction(mergedId, 
				mergedName, extender.getBundle(), null, mergedICodegenAction, null);
		result.appliesTo.addAll(mergedAppliesTo);
		return result;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the extend
	 */
	public String getExtend() {
		return extend;
	}
	/**
	 * @return the iCodegenAction
	 */
	public String getiCodegenAction() {
		return iCodegenAction;
	}
	/**
	 * @return the suppress
	 */
	public String getSuppress() {
		return suppress;
	}
	
	public void addAppliesTo(final String zdlgenClass) {
		if(!Strings.isNullOrEmpty(zdlgenClass)) {
			Class<?> classRepresenation;
			try {
				classRepresenation = Class.forName(zdlgenClass);
				appliesTo.add(classRepresenation);
			} catch (ClassNotFoundException e) {
				ZDLGenPlugin.getDefault().error(
						String.format("DDK code gen targets could not find the class %s.", zdlgenClass), e); //$NON-NLS-1$
			}
		}
	}
	
	public boolean appliesTo(Object candidate) {
		for(final Class<?> nextClass : appliesTo) {
			if(nextClass.isInstance(candidate)) {
				return true;
			}
		}
		
		return false;
	}
}