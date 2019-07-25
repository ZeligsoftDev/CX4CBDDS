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
package com.zeligsoft.base.validation.constraints;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.ConstraintExistsException;
import org.eclipse.emf.validation.service.ConstraintRegistry;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.validation.l10n.Messages;
import com.zeligsoft.base.validation.provider.ZDLConstraintManager;
import com.zeligsoft.base.validation.util.ValidationUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * The descriptor for a constraint that checks the cardinality of values of a
 * particular ZDL domain attribute.
 * 
 * @author Christian W. Damus (cdamus)
 */
class ZDLMultiplicityConstraintDescriptor
		extends AbstractConstraintDescriptor {

	/** Status code of the multiplicity constraint. */
	private static final int STATUS_CODE = 10;

	private final String pluginID;

	private final String id;

	private final String ownerQName;

	private final String ownerName;

	private final String attributeName;

	/**
	 * Initializes me with my domain attribute.
	 * 
	 * @param attribute
	 *            my attribute
	 * @param pluginID
	 *            the contributing plug-in ID
	 * @param id
	 *            my constraint-ID
	 */
	private ZDLMultiplicityConstraintDescriptor(Property attribute,
			String pluginID, String id) {

		this.pluginID = pluginID;
		this.id = id;
		this.ownerName = attribute.getClass_().getName();
		this.ownerQName = attribute.getClass_().getQualifiedName();
		this.attributeName = attribute.getName();
	}

	@Override
	public String getBody() {
		return null;
	}

	@Override
	public String getDescription() {
		return NLS.bind(Messages.multiplicityConstraint_desc, ownerQName,
			attributeName);
	}

	@Override
	public EvaluationMode<EObject> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getMessagePattern() {
		return "{0}"; //$NON-NLS-1$
	}

	@Override
	public String getName() {
		return NLS.bind(Messages.multiplicityConstraint_name, ownerName,
			attributeName);
	}

	@Override
	public String getPluginId() {
		return pluginID;
	}

	@Override
	public ConstraintSeverity getSeverity() {
		return ConstraintSeverity.ERROR;
	}

	@Override
	public int getStatusCode() {
		return STATUS_CODE;
	}

	@Override
	public boolean targetsEvent(Notification notification) {
		return false;
	}

	@Override
	public boolean targetsTypeOf(EObject object) {
		return ZDLUtil.isZDLConcept(object, ownerQName);
	}

	/**
	 * Obtains the constraint descriptor for the multiplicity constraint on the
	 * specified attribute. If necessary, the descriptor will be created and
	 * registered.
	 * 
	 * @param attribute
	 *            a domain-model attribute
	 * 
	 * @return its multiplicity constraint descriptor
	 */
	public static IConstraintDescriptor getInstance(Property attribute) {
		String pluginID = ValidationUtil.getPluginID(attribute);
		String id = pluginID + ".zdl." + attribute.getQualifiedName(); //$NON-NLS-1$

		ConstraintRegistry registry = ConstraintRegistry.getInstance();

		IConstraintDescriptor result = registry.getDescriptor(id);
		if (result == null) {
			result = new ZDLMultiplicityConstraintDescriptor(attribute,
				pluginID, id);

			try {
				registry.register(result);
				result.addCategory(ZDLConstraintManager.getInstance()
					.getZDLCategory());
			} catch (ConstraintExistsException e) {
				// OK. Concurrent validation in another resource-set or
				// something has registered it. Get the registered instance
				result = registry.getDescriptor(id);
			}
		}

		return result;
	}
}
