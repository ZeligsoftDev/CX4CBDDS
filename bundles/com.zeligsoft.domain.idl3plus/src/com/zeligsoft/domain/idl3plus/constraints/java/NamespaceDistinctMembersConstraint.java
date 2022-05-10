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
package com.zeligsoft.domain.idl3plus.constraints.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Usage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Constraint to verify that the members of a namespace are distinguishable
 * within it.
 * 
 * @author ysroh
 * 
 */
public class NamespaceDistinctMembersConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject target = ctx.getTarget();

		Map<String, EObject> results = new HashMap<String, EObject>();
		boolean result = true;

		if (target instanceof Namespace) {
			for (NamedElement ne : ((Namespace) target).getOwnedMembers()) {
				if (ne instanceof Connector) {
					continue;
				}
				result = isMemberDistinguishable(ne, results);
				if (!result) {
					Object[] messages = new Object[3];
					messages[0] = target;
					messages[1] = results.get("namespace"); //$NON-NLS-1$
					messages[2] = ne;
					ctx.addResult(ne);
					ctx.addResult(results.get("source")); //$NON-NLS-1$

					return ctx.createFailureStatus(messages);
				}
			}
		} else if (target instanceof NamedElement
				&& !(target instanceof Connector)) {
			result = isMemberDistinguishable((NamedElement) target, results);
			if (!result) {

				Object[] messages = new Object[3];
				messages[0] = target;
				messages[1] = results.get("namespace"); //$NON-NLS-1$
				messages[2] = target;
				ctx.addResult(target);
				ctx.addResult(results.get("source")); //$NON-NLS-1$

				return ctx.createFailureStatus(messages);
			}
		}

		return ctx.createSuccessStatus();
	}

	private boolean isMemberDistinguishable(NamedElement target,
			Map<String, EObject> results) {
		boolean result = true;
		Namespace namespace = ((NamedElement) target).getNamespace();
		if (namespace == null || UML2Util.isEmpty(target.getName())) {
			return result;
		}
		if(ZDLUtil.isZDLConcept(namespace, ZMLMMNames.DEPLOYMENT)) {
			// don't check deployment parts
			return result;
		}
		for (NamedElement m : namespace.getOwnedMembers()) {
			if (m == target || UML2Util.isEmpty(m.getName())) {
				continue;
			}
			if (m.eClass() == target.eClass()
					&& m.getName().equals(target.getName())) {
				if (m instanceof Usage
						&& ((Usage) m).getSources().size() == ((Usage) target)
								.getSources().size()) {
					boolean found = false;
					if (((Usage) target).getSources().containsAll(
							((Usage) m).getSources())) {
						if (((Usage) target).getSuppliers().size() == ((Usage) m)
								.getSuppliers().size()
								&& ((Usage) target).getSuppliers().containsAll(
										((Usage) m).getSuppliers())) {
							found = true;
						}
					}

					if (found) {
						result = false;
						results.put("namespace", namespace); //$NON-NLS-1$
						results.put("source", m); //$NON-NLS-1$
						break;
					}
				} else if (target instanceof Component) {
					Component impl = null;
					EObject def = null;
					if (ZDLUtil.isZDLConcept(target,
							CCMNames.ASSEMBLY_IMPLEMENTATION)
							|| ZDLUtil.isZDLConcept(target,
									CCMNames.MONOLITHIC_IMPLEMENTATION)) {
						impl = (Component) target;
						def = m;
					} else if (ZDLUtil.isZDLConcept(m,
							CCMNames.ASSEMBLY_IMPLEMENTATION)
							|| ZDLUtil.isZDLConcept(target,
									CCMNames.MONOLITHIC_IMPLEMENTATION)) {
						impl = (Component) m;
						def = target;
					}
					if (impl != null) {
						for (Generalization g : impl.getGeneralizations()) {
							if (g.getGeneral() == def) {
								result = true;
								break;
							}
						}
					}
				} else {

					result = false;
					if (((m instanceof BehavioralFeature))
							&& ((target instanceof BehavioralFeature))) {
						result = isParametersDistinguishable(
								(BehavioralFeature) m,
								(BehavioralFeature) target);
					}
					if (m instanceof Message || target instanceof Message) {
						result = true;
					}

					if (!result) {
						results.put("namespace", namespace); //$NON-NLS-1$
						results.put("source", m); //$NON-NLS-1$
						break;
					}
				}
			}
		}

		return result;

	}

	/**
	 * Compare source and target parameters see if they are distinguishable
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean isParametersDistinguishable(BehavioralFeature source,
			BehavioralFeature target) {
		EList<Parameter> sourceParms = source.getOwnedParameters();
		EList<Parameter> targetParms = target.getOwnedParameters();

		if (sourceParms.size() != targetParms.size()) {
			return true;
		}

		Iterator<Parameter> itor1 = sourceParms.iterator();
		Iterator<Parameter> itor2 = targetParms.iterator();

		while (itor1.hasNext()) {
			if (!itor2.hasNext()) {
				return true;
			}
			if (itor1.next().getType() != itor2.next().getType()) {
				return true;
			}
		}
		return false;
	}
}
