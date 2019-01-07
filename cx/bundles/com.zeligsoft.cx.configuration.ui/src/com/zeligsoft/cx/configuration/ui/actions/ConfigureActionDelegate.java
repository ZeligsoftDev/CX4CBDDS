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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateOrSelectElementCommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.ui.action.AbstractModelActionDelegate;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.configuration.ui.l10n.ConfigurationMessages;
import com.zeligsoft.cx.configuration.ui.utils.ConfigurationUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * ActionDelegate which allows user to select an existing InstanceSpecification
 * which is compatible with the model element of the deployment part.
 * 
 * @author jcorchis
 * 
 */
public class ConfigureActionDelegate
		extends AbstractModelActionDelegate
		implements IObjectActionDelegate {

	@Override
	protected TransactionalEditingDomain getEditingDomain() {
		return ConfigurationUtil.getEditingDomain(getStructuredSelection());
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {

		Shell shell = Display.getCurrent().getActiveShell();

		CreateOrSelectElementCommand command = new CreateOrSelectElementCommand(
			NLS.bind(ConfigurationMessages.Command_label_Configure, null),
			shell, getExistingConfigurations(getClassifier()),
			CreateOrSelectElementCommand.POPUP_DIALOG) {

			@Override
			protected ILabelProvider getLabelProvider() {
				return new LabelProvider() {

					public Image getImage(Object element) {
						return null;
					}

					public String getText(Object element) {
						if (element instanceof NamedElement) {
							return ((NamedElement) element).getQualifiedName();
						}
						return null;
					}

				};
			}

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor progressMonitor, IAdaptable info)
					throws ExecutionException {

				getPopupDialog().setTitle(
					NLS.bind(ConfigurationMessages.Configuration_Dialog_title,
						null));
				getPopupDialog().setMessage(
					NLS.bind(
						ConfigurationMessages.Configuration_Dialog_message,
						null));

				CommandResult cmdResult = super.doExecuteWithResult(
					progressMonitor, info);
				if (!cmdResult.getStatus().isOK()) {
					return cmdResult;
				}

				InstanceSpecification selectedConfigElement = (InstanceSpecification) cmdResult
					.getReturnValue();

				List<Element> elements = getCompatibleTargetElements();
				for (Iterator<Element> i = elements.iterator(); i.hasNext();) {
					ZDLUtil.setValue(i.next(), ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__CONFIGURATION,
						selectedConfigElement);
				}

				return CommandResult.newOKCommandResult(selectedConfigElement);
			}
		};

		execute(command, progressMonitor, null);

	}

	/**
	 * Returns the ComponentInterface of the first element in the structured
	 * selection. If the ComponentInterface is not found then return null.
	 * 
	 * @return the ComponentInterface of null if not found
	 */
	private Classifier getClassifier() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection != null && !selection.isEmpty()) {
			Object obj = selection.getFirstElement();
			if (obj instanceof IAdaptable) {
				EObject eObj = (EObject) ((IAdaptable) obj)
					.getAdapter(EObject.class);
				if (eObj instanceof Property) {
					Component component = (Component) ZDLUtil.getValue(eObj,
						ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
					if (component != null) {
						return component;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns a list of InstanceSpecifications which are based on the provided
	 * Classifier. This function will only return the InstancesSpecifications
	 * found in the same ResourceSet as the Classifier.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<InstanceSpecification> getExistingConfigurations(
			Classifier classifier) {

		Set<InstanceSpecification> existingConfigs = Collections.emptySet();

		if (classifier != null && classifier.eResource() != null) {
			CrossReferenceAdapter cxRefAdapter = CrossReferenceAdapter
				.getCrossReferenceAdapter(classifier.eResource()
					.getResourceSet());
			if (cxRefAdapter != null) {
				existingConfigs = cxRefAdapter
					.getInverseReferencersCrossResource(classifier,
						UMLPackage.eINSTANCE
							.getInstanceSpecification_Classifier(), null);
			}

		}
		return new ArrayList<InstanceSpecification>(existingConfigs);

	}

	/**
	 * Returns the subset of compatible DeploymentPart in the current selection.
	 * By compatible, we mean the <code>Types</code> of the DeploymentParts
	 * are the same.
	 * 
	 * @return
	 */
	private List<Element> getCompatibleTargetElements() {

		List<Element> compatableDeploymentParts = new ArrayList<Element>();

		IStructuredSelection selection = getStructuredSelection();

		if (selection != null && !selection.isEmpty()) {
			Property firstProperty = propertyAdapter(selection
				.getFirstElement());
			if (firstProperty != null) {
				Type type = firstProperty.getType();
				if (type != null) {
					compatableDeploymentParts.add(firstProperty);
					for (Iterator<?> i = selection.iterator(); i.hasNext();) {
						Property thisProperty = propertyAdapter(i.next());
						if (thisProperty != null
							&& !thisProperty.equals(firstProperty)
							&& type.equals(thisProperty.getType())) {
							compatableDeploymentParts.add(thisProperty);
						}
					}
				}
			}
		}
		return compatableDeploymentParts;
	}

	/**
	 * Attempts to adapt the given object to a <code>Property</code>
	 * 
	 * @param obj
	 *            the object to adapt
	 * @return null or an instance of Property
	 */
	private Property propertyAdapter(Object obj) {
		if (obj instanceof IAdaptable) {
			Property property = (Property) ((IAdaptable) obj)
				.getAdapter(Property.class);
			return property;
		}
		return null;
	}

}
