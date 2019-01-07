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
package com.zeligsoft.cx.deployment.treeeditor.providers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Collect validation results on deployment parts and notify listeners when
 * validation occurs.
 * 
 * @author ysroh
 * 
 */
public class DeploymentPartValidationObserver implements IValidationListener {

	public static Map<EObject, Integer> results = new HashMap<EObject, Integer>();

	private static Set<IValidationListener> listeners = new HashSet<IValidationListener>();

	@Override
	public void validationOccurred(ValidationEvent event) {
		if (!event.getEvaluationMode().isLive()) {
			results.clear();
		}
		for (IConstraintStatus st : event.getValidationResults()) {
			if (st.getTarget() instanceof Property
					&& ZDLUtil.isZDLConcept(st.getTarget(),
							ZMLMMNames.DEPLOYMENT_PART)) {
				EObject modelElement = ZDLUtil.getEValue(st.getTarget(),
						ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
				if (modelElement instanceof Port) {
					continue;
				}
				results.put(st.getTarget(), st.getSeverity());
				Property parent = (Property) st.getTarget();
				while ((parent = ZDeploymentUtil.getParentPart(parent)) != null) {
					if (!results.containsKey(parent)
							|| results.get(parent).equals(IStatus.WARNING)) {
						results.put(parent, st.getSeverity());
					}
				}
			}
		}
		for (IValidationListener listener : listeners) {
			listener.validationOccurred(event);
		}
	}

	/**
	 * Add listener to be notified if any validation occurs on deployment parts
	 * 
	 * @param listener
	 */
	public static void addListener(IValidationListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	/**
	 * Remove listener
	 * 
	 * @param listener
	 */
	public static void removeListener(IValidationListener listener) {
		listeners.remove(listener);
	}
}
