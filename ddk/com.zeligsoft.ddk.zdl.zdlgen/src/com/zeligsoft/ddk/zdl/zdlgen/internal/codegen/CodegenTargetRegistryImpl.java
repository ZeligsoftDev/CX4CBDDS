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
package com.zeligsoft.ddk.zdl.zdlgen.internal.codegen;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.Platform;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenTargetRegistry;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.DDKCodegenAction;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.DDKCodegenTarget;


public class CodegenTargetRegistryImpl implements CodegenTargetRegistry, IRegistryEventListener {
	private static final String CODEGEN_TARGET_EXTENSION_POINT = "com.zeligsoft.ddk.zdl.zdlgen.codegentargets"; //$NON-NLS-1$
	
	private Map<String, IExtension> map = null;
	private Map<String, DDKCodegenTarget> targets;
	
	public CodegenTargetRegistryImpl() {
		Platform.getExtensionRegistry().addListener(this);
	}
	
	private synchronized Collection<IExtension> getExtensions() {
		readExtensions();
	
		return map.values();
	}

	private synchronized void readExtensions() {
		map = new HashMap<String, IExtension>();
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IExtensionPoint point = registry.getExtensionPoint(CODEGEN_TARGET_EXTENSION_POINT);
		
		if(point != null) {
			final IExtension[] extensions = point.getExtensions();
			
			for(final IExtension element : extensions) {
				map.put(element.getUniqueIdentifier(), element);
			}
		}
	}

	@Override
	public void added(IExtension[] extensions) {
		if(map == null) {
			map = new HashMap<String, IExtension>();
		}
		
		final List<String> addedTargets = Lists.newArrayList();
		for(final IExtension next : extensions) {
			if(next.getExtensionPointUniqueIdentifier().equals(CODEGEN_TARGET_EXTENSION_POINT)) {
				map.put(next.getUniqueIdentifier(), next);
				readCodeGenTarget(next);
				addedTargets.add(next.getUniqueIdentifier());
			}
		}
		
		for(String nextTarget : addedTargets) {
			processCodegenTargetExtension(targets.get(nextTarget));
		}
	}

	@Override
	public void removed(IExtension[] extensions) {
		if(map == null || targets == null) {
			return;
		}
		
		for(final IExtension next : extensions) {
			if(next.getExtensionPointUniqueIdentifier().equals(CODEGEN_TARGET_EXTENSION_POINT)) {
				map.remove(next.getUniqueIdentifier());
				targets.remove(next.getUniqueIdentifier());
			}
		}
	}

	@Override
	public void added(IExtensionPoint[] extensionPoints) {
		// nothing to do
	}

	@Override
	public void removed(IExtensionPoint[] extensionPoints) {
		// nothing to do
	}

	/**
	 * @param extensions
	 * @param targets
	 */
	@Override
	public Collection<DDKCodegenTarget> getTargets() {
		if (targets == null) {
			readCodegenTargets();
		}
		return Collections.unmodifiableCollection(targets.values());
	}
	
	/* (non-Javadoc)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenTargetRegistry#getTarget(java.lang.String)
	 */
	@Override
	public DDKCodegenTarget getTarget(String id) {
		if(targets == null) {
			readCodegenTargets();
		}
		
		return targets.get(id);
	}
	
	private void initializeTargets() {
		if(targets == null) {
			targets = Maps.newHashMap();
		}
		
		if(map == null) {
			map = Maps.newHashMap();
		}
	}

	/**
	 * 
	 */
	private void readCodegenTargets() {
		initializeTargets();
		
		final Collection<IExtension> extensions = getExtensions();
		if (extensions != null) {
			for (IExtension ext : extensions) {
				readCodeGenTarget(ext);
			}
		}
		
		for(DDKCodegenTarget nextTarget : targets.values()) {
			processCodegenTargetExtension(nextTarget);
		}
	}

	/**
	 * @param ext
	 */
	private void readCodeGenTarget(IExtension ext) {
		initializeTargets();
		
		if (ext.getUniqueIdentifier() != null
				&& !ext.getUniqueIdentifier().isEmpty()) {
			final DDKCodegenTarget newTarget = new DDKCodegenTarget(
					ext.getUniqueIdentifier(), ext.getLabel(), ext.getContributor().getName());
			targets.put(newTarget.getId(), newTarget);
			for (IConfigurationElement elem : ext
					.getConfigurationElements()) {
				if (elem.getName().equalsIgnoreCase("base")) { //$NON-NLS-1$
					readBaseCodegenTarget(newTarget, elem);

				} else if (elem.getName()
						.equalsIgnoreCase("action")) { //$NON-NLS-1$
					final DDKCodegenAction newAction = transformConfigElem2CodegenAction(elem);
					newTarget.addAction(newAction);
				} else if(elem.getName().equalsIgnoreCase("menuLabel")) { //$NON-NLS-1$
					readMenuLabel(newTarget, elem);
				}
			}
		}
	}

	private void readBaseCodegenTarget(final DDKCodegenTarget newTarget,
			IConfigurationElement elem) {
		newTarget.setBase(elem.getAttribute("ref")); //$NON-NLS-1$
	}
	
	private void readMenuLabel(final DDKCodegenTarget newTarget,
			IConfigurationElement elem) {
		newTarget.setLabel(elem.getAttribute("label")); //$NON-NLS-1$
	}

	private DDKCodegenAction transformConfigElem2CodegenAction(
			IConfigurationElement elem) {
		final DDKCodegenAction newAction = new 
				DDKCodegenAction(
						elem.getAttribute("id"),  //$NON-NLS-1$
						elem.getAttribute("name"),  //$NON-NLS-1$
						elem.getContributor().getName(),
						elem.getAttribute("extend"),  //$NON-NLS-1$
						elem.getAttribute("class"),  //$NON-NLS-1$
						elem.getAttribute("suppress")); //$NON-NLS-1$
		
		readEnabledWhen(elem, newAction);
		return newAction;
	}

	private void readEnabledWhen(final IConfigurationElement elem,
			final DDKCodegenAction newAction) {
		final IConfigurationElement[] enabledWhen = 
				elem.getChildren("enabledWhen"); //$NON-NLS-1$
		
		for(IConfigurationElement nextEnabledWhen : enabledWhen) {
			final IConfigurationElement[] instanceClasses =
					nextEnabledWhen.getChildren("instanceof"); //$NON-NLS-1$
			for(IConfigurationElement instanceClass : instanceClasses) {
				final String value = instanceClass.getAttribute("class"); //$NON-NLS-1$
				if(!Strings.isNullOrEmpty(value)) {
					newAction.addAppliesTo(value);
				}
			}
		}
	}
	
	private void processCodegenTargetExtension(final DDKCodegenTarget targetToProcess) {
		final String base = targetToProcess.getBase();
		if(!Strings.isNullOrEmpty(base)) {
			final DDKCodegenTarget baseTarget = targets.get(base);
			
			// make sure that the base target has been processed.
			processCodegenTargetExtension(baseTarget);
			targetToProcess.updateWithBase(baseTarget);
		}
	}
}
