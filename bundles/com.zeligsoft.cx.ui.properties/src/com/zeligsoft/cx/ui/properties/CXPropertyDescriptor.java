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
package com.zeligsoft.cx.ui.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.properties.l10n.Messages;

/**
 * CX Property Descriptor for property sheet page
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CXPropertyDescriptor {

	private EObject context;

	private List<EObject> eObjectsToSynchronize = new ArrayList<EObject>();

	private Class concept;

	private Property property;

	private PropertyDefinition propertyDefinition;

	private int index = -1;

	/**
	 * Constructor
	 * 
	 * @param object
	 *            concept owner
	 * @param concept
	 *            ZDL concept
	 * @param property
	 *            property
	 * @param pd
	 *            property definition
	 */
	public CXPropertyDescriptor(EObject object, Class concept,
			Property property, PropertyDefinition pd) {
		this.concept = concept;
		this.property = property;
		this.context = object;
		this.propertyDefinition = pd;
	}

	/**
	 * Add additional EObjects that will be synchronized when property value is
	 * set. In other words, if you change the value of this property then the
	 * value will be save to the same property of all EObjects in this list.
	 * 
	 * @param list
	 */
	public void addEObjectListToSynchronize(List<EObject> list) {
		this.eObjectsToSynchronize.addAll(list);
	}

	/**
	 * Return list of object that need to be synchronized
	 * 
	 * @return
	 */
	public List<EObject> getEObjectListToSynchronize() {
		return eObjectsToSynchronize;
	}

	/**
	 * Queries the eObject
	 * 
	 * @return
	 */
	public EObject getContext() {
		return context;
	}

	/**
	 * Queries the concept
	 * 
	 * @return
	 */
	public Class getConcept() {
		return concept;
	}

	/**
	 * Set concept
	 * 
	 * @param concept
	 */
	public void setConcept(Class concept) {
		this.concept = concept;
	}

	/**
	 * Queries the property
	 * 
	 * @return
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * Set property
	 * 
	 * @param property
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

	/**
	 * Queries the property value of the concept.
	 * 
	 * @return
	 */
	public Object getValue() {
		if (context != null && concept != null && property != null) {
			return ZDLUtil.getValue(context, concept, property.getName());
		}
		return null;
	}

	/**
	 * Access the ordering index of the property
	 * 
	 * @return The ordering index of the property
	 */
	public int getOrder() {
		return index;
	}

	/**
	 * Set the ordering index of the property
	 * 
	 * @param order
	 *            The new order index
	 */
	public void setOrder(int order) {
		this.index = order;
	}

	/**
	 * Creates value of the given concept.
	 * 
	 * @param propertyConcept
	 * @return
	 */
	public Object createConcept(final Class propertyConcept) {

		final ArrayList<Object> list = new ArrayList<Object>();

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(context),
				NLS.bind(
						Messages.CXPropertyDescriptor_CreateConceptTransactionLabel,
						propertyConcept.getName()), Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject object = BaseUIUtil.createZDLModelElement(context,
						propertyConcept.getQualifiedName());
				if (object == null) {
					object = ZDLUtil.createZDLConcept(context, concept,
							property.getName(), propertyConcept);
				}
				list.add(object);

				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {

			Activator
					.getDefault()
					.error(NLS.bind(
							Messages.CXPropertyDescriptor_ElementCreationFailedLog,
							propertyConcept.getName()), e);
		}

		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;

	}

	public void setValue(final Object value) {
		setValue(value, null);
	}

	/**
	 * Set value for the property or add value to the property if multi-valued
	 * 
	 * @param value
	 *            value to set
	 */
	public void setValue(final Object value, final ICommand additionalCommand) {

		if (property.isMultivalued()) {
			return;
		}
		ICommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(context),
				NLS.bind(
						Messages.CXPropertyDescriptor_ChangePropertyValueTransactionLabel,
						property.getName()), Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				try {

					Object oldValue = getValue();
					if (value == null && oldValue != null
							&& oldValue instanceof EObject
							&& property.isComposite()) {
						DestroyElementRequest request = new DestroyElementRequest(
								(EObject) oldValue, false);
						DestroyElementCommand command = new DestroyElementCommand(
								request);
						command.execute(null, null);
					}

					ZDLUtil.setValue(context, concept, property.getName(),
							value);

					Iterator<EObject> iter = eObjectsToSynchronize.iterator();
					while (iter.hasNext()) {
						EObject next = iter.next();
						Class rightConcept = null;
						for (Class concept : ZDLUtil.getZDLConcepts(next)) {
							if (concept.getAllAttributes().contains(property)) {
								rightConcept = concept;
								break;
							}
						}
						if (rightConcept != null) {
							ZDLUtil.setValue(next, rightConcept,
									property.getName(), value);
						}
					}

				} catch (Exception e) {
					Activator.getDefault().warning(e.getMessage(), e);
				}

				if (additionalCommand != null && additionalCommand.canExecute()) {
					additionalCommand.execute(null, null);
				}

				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {

			Activator
					.getDefault()
					.error(Messages.CXPropertyDescriptor_ChangingPropertyValueFailedLog,
							e);
		}
	}

	public void addValue(final Object value) {
		if (!property.isMultivalued()) {
			return;
		}
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(context),
				NLS.bind(
						Messages.CXPropertyDescriptor_ChangePropertyValueTransactionLabel,
						property.getName()), Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				try {
					List values = (List) getValue();
					values.add(value);

					if (!property.isComposite()) {
						Iterator<EObject> iter = eObjectsToSynchronize
								.iterator();
						while (iter.hasNext()) {
							EObject eo = iter.next();
							List eoValues = (List) ZDLUtil.getValue(eo,
									concept, property.getName());
							eoValues.clear();
							eoValues.addAll(values);
						}
					}

				} catch (Exception e) {
					Activator.getDefault().warning(e.getMessage(), e);
				}

				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {

			Activator
					.getDefault()
					.error(Messages.CXPropertyDescriptor_ChangingPropertyValueFailedLog,
							e);
		}
	}

	/**
	 * Removes the value from the property
	 * 
	 * @param value
	 */
	public void removeValue(final Object value) {

		if (!property.isMultivalued()) {
			return;
		}

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(context),
				NLS.bind(
						Messages.CXPropertyDescriptor_RemovePropertyValueTransactionLabel,
						property.getName()), Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				if (property.isComposite()) {
					if (value != null && value instanceof EObject) {
						DestroyElementRequest request = new DestroyElementRequest(
								(EObject) value, false);
						DestroyElementCommand command = new DestroyElementCommand(
								request);
						command.execute(null, null);
					}
				}

				List values = (List) getValue();
				values.remove(value);

				if (!property.isComposite()) {
					Iterator<EObject> iter = eObjectsToSynchronize.iterator();
					while (iter.hasNext()) {
						EObject eo = iter.next();
						List eoValues = (List) ZDLUtil.getValue(eo, concept,
								property.getName());
						eoValues.clear();
						eoValues.addAll(values);
					}
				}

				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {

			Activator.getDefault().error(
					Messages.CXPropertyDescriptor_RemovePropertyValueFailedLog,
					e);
		}
	}

	/**
	 * Replace value with new value from the value list.
	 * 
	 * @param oldValue
	 *            value to remove
	 * @param newValue
	 *            value to replace
	 */
	public void replaceValue(final Object oldValue, final Object newValue) {

		if (!property.isMultivalued() && property.isComposite()) {
			return;
		}

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(context),
				NLS.bind(
						Messages.CXPropertyDescriptor_ChangePropertyValueTransactionLabel,
						property.getName()), Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				try {

					int valueIndex = getValueIndex(oldValue);
					removeValue(oldValue);
					List values = (List) getValue();
					if (valueIndex < values.size() && valueIndex >= 0) {
						values.add(valueIndex, newValue);
					} else {
						values.add(newValue);
					}

					Iterator<EObject> iter = eObjectsToSynchronize.iterator();
					while (iter.hasNext()) {
						EObject eo = iter.next();
						List eoValues = (List) ZDLUtil.getValue(eo, concept,
								property.getName());
						eoValues.clear();
						eoValues.addAll(values);
					}

				} catch (Exception e) {
					Activator.getDefault().warning(e.getMessage(), e);
				}

				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {

			Activator
					.getDefault()
					.error(Messages.CXPropertyDescriptor_ChangingPropertyValueFailedLog,
							e);
		}
	}

	/**
	 * 
	 * @return
	 */
	public boolean isReadOnly() {
		return propertyDefinition == null ? false : propertyDefinition
				.isReadOnly();
	}

	/**
	 * 
	 * @return
	 */
	public String getContentHint() {
		return propertyDefinition == null ? null : propertyDefinition
				.getContentHint();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isWorkerCode() {
		return CXPropertyDefinitionManager.WORKER_CODE_CONTENT_HINT
				.equals(getContentHint());
	}

	/**
	 * 
	 * @return
	 */
	public PropertyDefinition getPropertyDefinition() {
		return propertyDefinition;
	}

	/**
	 * Queries the index of the given value from the value list
	 * 
	 * @param value
	 * @return
	 */
	private int getValueIndex(Object value) {
		if (property.isMultivalued()) {
			List values = (List) getValue();
			return values.indexOf(value);
		}

		return -1;
	}

	/**
	 * Compare two CXPropertyDescriptors, by looking at their index and if this
	 * is equal comparing the name of the property.
	 * 
	 * @author Toby McClean
	 * 
	 */
	public static class CXPropertyDescriptorComparator implements
			Comparator<CXPropertyDescriptor> {

		@Override
		public int compare(CXPropertyDescriptor o1, CXPropertyDescriptor o2) {
			if (o1.index == o2.index) {
				return o1.property.getName().compareTo(o2.property.getName());
			}

			return new Integer(o1.index).compareTo(new Integer(o2.index));
		}

	}

}
