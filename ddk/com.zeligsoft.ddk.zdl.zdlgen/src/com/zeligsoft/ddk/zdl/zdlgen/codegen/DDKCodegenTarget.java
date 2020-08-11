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
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class DDKCodegenTarget {
	private final String id;
	private final String name;
	private final String bundle;
	private String label;
	private String base;
	
	private final Map<String, DDKCodegenAction> actions;
	private final Set<String> suppress;
	private final Map<String, DDKCodegenAction> extend;
	
	private boolean updatedWithBase = false;
	
	/**
	 * @param id
	 * @param name
	 */
	public DDKCodegenTarget(String id, String name, String bundle) {
		super();
		this.id = id;
		this.name = name;
		this.bundle = bundle;
		
		actions = Maps.newHashMap();
		extend = Maps.newHashMap();
		suppress = Sets.newHashSet();
	}
	
	public void addAction(final DDKCodegenAction action) {
		if(action != null) {
			if(!Strings.isNullOrEmpty(action.getId())) {
				actions.put(action.getId(), action);
			} else if(!Strings.isNullOrEmpty(action.getExtend())) {
				extend.put(action.getExtend(), action);
			} else if(!Strings.isNullOrEmpty(action.getSuppress())) {
				suppress.add(action.getSuppress());
			}
		}
	}
	
	public Collection<DDKCodegenAction> getActions() {
		return Collections.unmodifiableCollection(actions.values());
	}
	
	/**
	 * @return the base
	 */
	public String getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(String base) {
		this.base = base;
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
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getBundle() {
		return bundle;
	}
	
	public void updateWithBase(final DDKCodegenTarget base) {
		if(base != null && !updatedWithBase) {
			final Collection<DDKCodegenAction> baseActions = base.getActions();
			
			for(final DDKCodegenAction nextAction : baseActions) {
				if(! suppress.contains(nextAction.getId())){
					if(extend.containsKey(nextAction.getId())) {
						DDKCodegenAction extendingAction = extend.get(nextAction.getId());
						DDKCodegenAction newAction = nextAction.merge(extendingAction);
						this.actions.put(newAction.getId(), newAction);
					} else {
						DDKCodegenAction newAction = new DDKCodegenAction(nextAction);
						this.actions.put(newAction.getId(), newAction);
					}
				}
			}
			updatedWithBase = true;
		}
	}
}