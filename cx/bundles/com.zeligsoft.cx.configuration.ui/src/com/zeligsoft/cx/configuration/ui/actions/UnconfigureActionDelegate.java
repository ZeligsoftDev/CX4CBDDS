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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.ui.action.AbstractModelActionDelegate;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.configuration.ui.commands.SetTaggedValueCommand;
import com.zeligsoft.cx.configuration.ui.l10n.ConfigurationMessages;
import com.zeligsoft.cx.configuration.ui.utils.ConfigurationUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Action to set the configuration slot to null for a Collection of
 * DeploymentParts.
 * 
 * @author jcorchis
 * 
 */
public class UnconfigureActionDelegate
		extends AbstractModelActionDelegate
		implements IObjectActionDelegate {

	@Override
	protected TransactionalEditingDomain getEditingDomain() {
		return ConfigurationUtil.getEditingDomain(getStructuredSelection());
	}

	/**
	 * Sets all the elements in the selection which are a <code>
	 * Property</code> and have the deployment part stereotype applied.
	 * 
	 */
	@Override
	protected void doRun(IProgressMonitor progressMonitor) {

		List<Property> elements = new ArrayList<Property>();

		IStructuredSelection selection = getStructuredSelection();

		if (selection != null && !selection.isEmpty()) {
			for (Iterator<?> i = selection.iterator(); i.hasNext();) {
				Object obj = i.next();
				if (obj instanceof IAdaptable) {
					Property element = (Property) ((IAdaptable) obj)
						.getAdapter(Property.class);
					if (element != null
							&& ZDLUtil.isZDLConcept(element, ZMLMMNames.DEPLOYMENT_PART))
					{
						elements.add(element);
					}
				}

			}
		}

		SetTaggedValueCommand command = new SetTaggedValueCommand(
			getEditingDomain(), NLS.bind(
				ConfigurationMessages.Command_label_UnConfigure, null), null,
			elements, ZMLMMNames.DEPLOYMENT_PART,
			ZMLMMNames.DEPLOYMENT_PART__CONFIGURATION, null);

		execute(command, progressMonitor, null);

	}
}
