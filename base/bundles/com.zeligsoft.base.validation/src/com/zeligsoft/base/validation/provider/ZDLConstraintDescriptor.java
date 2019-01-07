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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.validation.util.ValidationUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Implementation of a constraint descriptor for constraints defined in ZDL
 * models.
 * 
 * @author Christian W. Damus (cdamus)
 */
class ZDLConstraintDescriptor
		extends AbstractConstraintDescriptor {

	private String targetConcept;

	private String id;

	private String name;

	private String description;

	private EvaluationMode<?> evaluationMode;

	private ConstraintSeverity severity;

	private String messagePattern;

	private int statusCode;

	private String pluginID;

	/**
	 * Initializes me to provide validation metadata for the specified UML
	 * constraint specification.
	 * 
	 * @param umlConstraint
	 *            a UML constraint specification in a ZDL model
	 */
	ZDLConstraintDescriptor(Constraint umlConstraint) {
		ConstraintMetadata metadata = ConstraintMetadata
			.getInstance(umlConstraint);
		EObject data = metadata.getMetadataHolder(umlConstraint);

		targetConcept = ValidationUtil.getConstraintContext(umlConstraint);
		id = metadata.getID(data);
		name = metadata.getDisplayName(data);
		description = ValidationUtil.localize(umlConstraint, metadata
			.getDescription(data));
		evaluationMode = metadata.getEvaluationMode(data);
		severity = metadata.getSeverity(data);
		messagePattern = ValidationUtil.localize(umlConstraint, metadata
			.getMessage(data));
		statusCode = metadata.getStatusCode(data);
		pluginID = ValidationUtil.getPluginID(umlConstraint);
	}

	@Override
	public boolean targetsTypeOf(EObject object) {
		return (object instanceof Element)
			&& ZDLUtil.isZDLConcept(object, targetConcept);
	}

	@Override
	public boolean targetsEvent(Notification notification) {
		Object notifier = notification.getNotifier();

		return (notifier instanceof Element)
			&& ZDLUtil.isZDLConcept((Element) notifier, targetConcept);
	}

	@Override
	public int getStatusCode() {
		return statusCode;
	}

	@Override
	public ConstraintSeverity getSeverity() {
		return severity;
	}

	@Override
	public String getPluginId() {
		return pluginID;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getMessagePattern() {
		return messagePattern;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public EvaluationMode<?> getEvaluationMode() {
		return evaluationMode;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getBody() {
		// Not required by the ZDL constraint provider
		return null;
	}
}
