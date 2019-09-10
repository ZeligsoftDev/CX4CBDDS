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

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.ModelConstraint;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.validation.l10n.Messages;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A constraint that checks the cardinalities of the domain features of an
 * element against their declared multiplicities in the ZDL model of the domain.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLMultiplicityConstraint
		extends ModelConstraint {

	private static AdapterFactory adapterFactory = new ComposedAdapterFactory(
		ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	private Property attribute;

	/**
	 * Initializes me with my domain attribute.
	 * 
	 * @param attribute
	 *            my domain attribute
	 */
	public ZDLMultiplicityConstraint(Property attribute) {
		super(ZDLMultiplicityConstraintDescriptor.getInstance(attribute));

		this.attribute = attribute;
	}

	/**
	 * Queries the domain attribute for which I check the cardinality.
	 * 
	 * @return my domain attribute
	 */
	public final Property getDomainAttribute() {
		return attribute;
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();

		int cardinality;

		Object value = ZDLUtil.getValue(target, attribute.getClass_(),
			attribute.getName());

		if (attribute.isMultivalued()) {
			cardinality = ((Collection<?>) value).size();
		} else {
			// RSM sets a user-cleared field to "" instead of null.
			// FIXME: It would be better to implement a listener that detects that a proprety is being
			// set to "", and instead sets it to null.
			cardinality = (value == null || value.equals(""))  //$NON-NLS-1$
				? 0
				: 1;
		}

		if (attribute.isMultivalued()) {
			int lower = attribute.getLower();
			int upper = attribute.getUpper();

			String message;
			if ((cardinality == 0) && (lower > 0)) {
				// the required case
				message = Messages.ZDLMultiplicityConstraint_required;
			} else if (lower == 0) {
				// the less-than case
				message = Messages.ZDLMultiplicityConstraint_less;
			} else if (upper == LiteralUnlimitedNatural.UNLIMITED) {
				// the more-than case
				message = Messages.ZDLMultiplicityConstraint_more;
			} else if (upper == lower) {
				// the exact case
				message = Messages.ZDLMultiplicityConstraint_exact;
			} else {
				// the between case
				message = Messages.ZDLMultiplicityConstraint_between;
			}

			message = NLS.bind(message, new Object[]{getLabel(target),
				attribute.getName(), cardinality, lower, upper});
			return new ConstraintStatus(this, target, message, ctx
				.getResultLocus());
		}

		return ctx.createSuccessStatus();
	}

	private String getLabel(EObject eObject) {
		IItemLabelProvider provider = (IItemLabelProvider) EcoreUtil
			.getExistingAdapter(eObject, IItemLabelProvider.class);

		if (provider == null) {
			provider = (IItemLabelProvider) adapterFactory.adapt(eObject,
				IItemLabelProvider.class);
		}

		return (provider == null)
			? eObject.toString()
			: provider.getText(eObject);
	}
}
