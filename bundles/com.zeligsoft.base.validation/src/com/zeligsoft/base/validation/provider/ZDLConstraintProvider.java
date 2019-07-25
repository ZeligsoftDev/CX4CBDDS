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
package com.zeligsoft.base.validation.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IModelConstraintProvider;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A constraint provider that extracts constraints from ZDL models and
 * contributes them to Zeligsoft component model elements that are instances of
 * the concepts in those models.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLConstraintProvider
		implements IModelConstraintProvider {

	/**
	 * Initializes me.
	 */
	public ZDLConstraintProvider() {
		super();

		ZDLConstraintManager.getInstance().inializePreloadedConstraints();
	}

	@Override
	public Collection<IModelConstraint> getBatchConstraints(EObject object,
			Collection<IModelConstraint> constraints) {
		if (!(object instanceof Element)) {
			throw new IllegalArgumentException("object is not a UML Element"); //$NON-NLS-1$
		}

		Collection<IModelConstraint> result = notNull(constraints);

		// provide all constraints, batch or live mode, because the
		// IBatchValidator gives clients the option of whether to include live
		// constraints or not. If we don't serve up the live constraints, then
		// the client won't have this flexibility
		ZDLConstraintManager mgr = ZDLConstraintManager.getInstance();
		for (Class concept : ZDLUtil.getZDLConcepts(object)) {
			result.addAll(mgr.getConstraints(concept));
			
			// add all of the constraints which are defined in the domain
			// but which are not directly owned by the concept
			for(Profile p : ZDLUtil.getZDLProfiles((Element) object)) {
				result.addAll(mgr.getExternalConstraints(p, concept));
			}
		}

		return result;
	}

	@Override
	public Collection<IModelConstraint> getLiveConstraints(
			Notification notification, Collection<IModelConstraint> constraints) {

		Object notifier = notification.getNotifier();
		if (!(notifier instanceof Element)) {
			throw new IllegalArgumentException("notifier is not a UML Element"); //$NON-NLS-1$
		}

		Collection<IModelConstraint> result = notNull(constraints);

		ZDLConstraintManager mgr = ZDLConstraintManager.getInstance();
		for (Class concept : ZDLUtil.getZDLConcepts((Element) notifier)) {
			for (IModelConstraint next : mgr.getConstraints(concept)) {
				if (next.getDescriptor().getEvaluationMode() == EvaluationMode.LIVE) {
					result.add(next);
				}
			}
			// add all of the live constraints which are defined in the domain
			// but which are not directly owned by the concept
			for (Profile p : ZDLUtil.getZDLProfiles((Element) notifier)) {
				for (IModelConstraint next : mgr.getExternalConstraints(
						p, concept)) {
					if (next.getDescriptor().getEvaluationMode() == EvaluationMode.LIVE) {
						result.add(next);
					}
				}
			}
		}

		return result;
	}

	private static Collection<IModelConstraint> notNull(
			Collection<IModelConstraint> constraints) {
		return (constraints == null)
			? new java.util.ArrayList<IModelConstraint>()
			: constraints;
	}
}
