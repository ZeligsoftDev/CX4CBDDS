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

package com.zeligsoft.cx.configuration.ui.actions;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderPolicy;
import org.eclipse.gmf.runtime.emf.ui.services.action.AbstractModelActionFilterProvider;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * ActionFilter provider which provides tests based on DeploymentPart stereotype
 * slots.
 * 
 * @author jcorchis
 * 
 */
public class ConfigurationActionFilterProvider
		extends	AbstractModelActionFilterProvider 
		implements IProviderPolicy {
	/**
	 * The tag used to test that at least one element in the selection is a
	 * configurable element.
	 */
	final private String CAN_CONFIGURE = "canConfigure";//$NON-NLS-1$

	/**
	 * The tag used to test that at least one element in the selection is
	 * configured.
	 */
	final private String CAN_UNCONFIGURE = "canUnconfigure";//$NON-NLS-1$

	@Override
	protected boolean doProvides(IOperation operation) {
		return true;
	}

	@Override
	protected boolean doTestAttribute(Object target, String name, String value) {
		if (CAN_CONFIGURE.equals(name)) {
			if (target instanceof IAdaptable) {
				Element element = (Element) ((IAdaptable) target)
					.getAdapter(Element.class);
				if (element != null) {
					// A DeploymentPart is configurable
					return ZDLUtil.isZDLConcept(element,
						ZMLMMNames.DEPLOYMENT_PART);
				}
			}
			return true;
		} else if (CAN_UNCONFIGURE.equals(name)) {
			Element element = (Element) ((IAdaptable) target)
				.getAdapter(Element.class);
			if (element != null) {
				return ZDLUtil
					.isZDLConcept(element, ZMLMMNames.DEPLOYMENT_PART)
					&& null != ZDLUtil.getValue(element,
						ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT)
					&& null != ZDLUtil.getValue(element,
						ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__CONFIGURATION);
			}
		}

		return false;
	}

	@Override
	protected TransactionalEditingDomain getEditingDomain(Object target) {
		if (target instanceof IAdaptable) {
			EObject eObject = (EObject) ((IAdaptable) target)
					.getAdapter(EObject.class);
			if (eObject != null)
				return TransactionUtil.getEditingDomain(eObject);
		}
		return null;
	}

}
