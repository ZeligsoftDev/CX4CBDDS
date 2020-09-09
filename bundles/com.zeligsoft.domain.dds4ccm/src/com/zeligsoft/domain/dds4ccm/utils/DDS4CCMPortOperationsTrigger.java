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

package com.zeligsoft.domain.dds4ccm.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.zml.util.WorkerFunctionRepair;
import com.zeligsoft.domain.zml.util.WorkerFunctionRepairTrigger;
import com.zeligsoft.domain.zml.util.WorkerFunctionUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * ResourceSetListener which synchronizes the worker functions on structural
 * realizations when changes are made on CCMHome.
 * 
 * @author smcfee
 * 
 */
public class DDS4CCMPortOperationsTrigger extends WorkerFunctionRepairTrigger {

	/**
	 * The types of objects that this trigger is interested in
	 */
	private static final java.lang.Class<?>[] RELEVANT_TYPES = { Class.class,
			Operation.class, Property.class };

	/**
	 * Create me.
	 */
	public DDS4CCMPortOperationsTrigger() {
		super();
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {

		componentsToRepair.clear();

		CompoundCommand cc = new CompoundCommand("WorkerFunctionRepair"); //$NON-NLS-1$

		// Check if relevant elements are renamed
		final Map<EObject, String> renamedObjectMap = getRenamedObjectMap(
				event, RELEVANT_TYPES);
		final Set<Component> componentsToRename = getComponentsToRename(renamedObjectMap);

		if (!componentsToRename.isEmpty()) {
			cc.append(new RecordingCommand(event.getEditingDomain()) {

				@Override
				protected void doExecute() {
					doRename(renamedObjectMap, componentsToRename);
				}
			});
		}

		componentsToRepair.addAll(getSRsImpactedByResourceSetChange(event));

		if (!componentsToRepair.isEmpty()) {
			final Set<Component> pleaseRepair = componentsToRepair;
			cc.append(new RecordingCommand(event.getEditingDomain()) {

				@Override
				protected void doExecute() {
					WorkerFunctionRepair wfr = new WorkerFunctionRepair();
					wfr.repair(pleaseRepair);
				}

			});
		}

		if (cc.canExecute()) {
			return cc.unwrap();
		}
		return null;

	}

	/**
	 * Rename worker functions
	 * 
	 * @param renamedObjectMap
	 * @param pleaseRename
	 */
	@SuppressWarnings({ "unchecked", "nls" })
	private void doRename(final Map<EObject, String> renamedObjectMap,
			final Set<Component> componnetsToRename) {
		for (Component renameComponent : componnetsToRename) {
			for (EObject workerFunction : (List<EObject>) ZDLUtil.getValue(
					renameComponent, ZMLMMNames.STRUCTURAL_REALIZATION,
					ZMLMMNames.STRUCTURAL_REALIZATION__WORKER)) {
				EObject receivingPort = ZDLUtil.getEValue(workerFunction,
						ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
				EObject portOperation = ZDLUtil.getEValue(workerFunction,
						ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
				String currentName = ZDLUtil.getValue(workerFunction,
						ZMLMMNames.NAMED_ELEMENT,
						ZMLMMNames.NAMED_ELEMENT__NAME).toString();
				List<EObject> list = WorkerFunctionUtil
						.getWorkerFunctionImpls(workerFunction);
				if (list.size() == 0) {
					continue;
				}
				EObject workerFunctionImpl = list.get(0);

				for (EObject renamedObj : renamedObjectMap.keySet()) {
					String currentRenamedObjName = EMFCoreUtil
							.getName(renamedObj);
					String oldRenamedObjName = renamedObjectMap.get(renamedObj);

					// Home is renamed
					if (ZDLUtil.isZDLConcept(renamedObj, CCMNames.HOME)) {
						if (currentName.startsWith("_home_" + oldRenamedObjName
								+ "_")) {
							ZDLUtil.setValue(
									workerFunction,
									ZMLMMNames.NAMED_ELEMENT,
									ZMLMMNames.NAMED_ELEMENT__NAME,
									currentName.replace("_home_"
											+ oldRenamedObjName + "_", "_home_"
											+ currentRenamedObjName + "_"));
						} else if (currentName.startsWith("_hattr_"
								+ oldRenamedObjName + "_")) {
							ZDLUtil.setValue(workerFunction,
									ZMLMMNames.NAMED_ELEMENT,
									ZMLMMNames.NAMED_ELEMENT__NAME,
									currentName.replace("_hattr_"
											+ oldRenamedObjName + "___",
											"_hattr_" + currentRenamedObjName
													+ "___"));
						}
					} else if (ZDLUtil.isZDLConcept(renamedObj,
							CCMNames.INTERFACE_PORT)) {
						// Port is renamed
						if ((receivingPort == renamedObj || currentName
								.contains("_EPI_"))
								&& currentName.startsWith(oldRenamedObjName
										+ "_")) {
							ZDLUtil.setValue(workerFunction,
									ZMLMMNames.NAMED_ELEMENT,
									ZMLMMNames.NAMED_ELEMENT__NAME,
									currentName.replace(
											oldRenamedObjName + "_",
											currentRenamedObjName + "_"));
						} else if (currentName.startsWith("_pattr_"
								+ oldRenamedObjName + "_")) {
							ZDLUtil.setValue(workerFunction,
									ZMLMMNames.NAMED_ELEMENT,
									ZMLMMNames.NAMED_ELEMENT__NAME,
									currentName.replace("_pattr_"
											+ oldRenamedObjName + "_",
											"_pattr_" + currentRenamedObjName
													+ "_"));
						} else if (currentName.startsWith(oldRenamedObjName
								+ "_CSL_")) {
							ZDLUtil.setValue(
									workerFunction,
									ZMLMMNames.NAMED_ELEMENT,
									ZMLMMNames.NAMED_ELEMENT__NAME,
									currentName.replace(oldRenamedObjName
											+ "_CSL_", currentRenamedObjName
											+ "_CSL_"));
						}
					} else if (ZDLUtil.isZDLConcept(renamedObj,
							CXDomainNames.CXOPERATION)) {
						// Operation is renamed
						if (renamedObj == portOperation
								&& currentName
										.endsWith("_" + oldRenamedObjName)) {
							ZDLUtil.setValue(workerFunction,
									ZMLMMNames.NAMED_ELEMENT,
									ZMLMMNames.NAMED_ELEMENT__NAME,
									currentName.replace(
											"_" + oldRenamedObjName, "_"
													+ currentRenamedObjName));
						} else if (currentName.endsWith("_excep")) {
							Set<EObject> intfToCheck = new HashSet<EObject>();
							getAllGeneralizationReferences(
									renamedObj.eContainer(),
									CXDomainNames.CXINTERFACE,
									intfToCheck);
							intfToCheck.add(renamedObj.eContainer());
							for (Property p : renameComponent
									.getAllAttributes()) {
								if (ZDLUtil.isZDLConcept(p,
										CCMNames.INTERFACE_PORT)
										&& intfToCheck.contains(p.getType())
										&& currentName.equals(p.getName() + "_"
												+ oldRenamedObjName + "_excep")) {
									ZDLUtil.setValue(
											workerFunction,
											ZMLMMNames.NAMED_ELEMENT,
											ZMLMMNames.NAMED_ELEMENT__NAME,
											currentName.replace("_"
													+ oldRenamedObjName, "_"
													+ currentRenamedObjName));
								}
							}
						}
					} else if (ZDLUtil.isZDLConcept(renamedObj,
							CXDomainNames.CXATTRIBUTE)) {
						if (renamedObj.eContainer() != null
								&& ZDLUtil.isZDLConcept(
										renamedObj.eContainer(), CCMNames.HOME)) {
							if (currentName.startsWith("_hattr_")
									&& currentName.contains("_"
											+ oldRenamedObjName + "_")) {
								ZDLUtil.setValue(
										workerFunction,
										ZMLMMNames.NAMED_ELEMENT,
										ZMLMMNames.NAMED_ELEMENT__NAME,
										currentName.replace("_"
												+ oldRenamedObjName + "_", "_"
												+ currentRenamedObjName + "_"));
							}
						} else if (renamedObj.eContainer() != null
								&& ZDLUtil.isZDLConcept(
										renamedObj.eContainer(),
										CCMNames.CCMCOMPONENT)) {
							if (currentName.startsWith("_attr_"
									+ oldRenamedObjName)) {
								ZDLUtil.setValue(
										workerFunction,
										ZMLMMNames.NAMED_ELEMENT,
										ZMLMMNames.NAMED_ELEMENT__NAME,
										currentName.replace("_attr_"
												+ oldRenamedObjName, "_attr_"
												+ currentRenamedObjName));
							}
						} else if (renamedObj.eContainer() != null
								&& ZDLUtil.isZDLConcept(
										renamedObj.eContainer(),
										CXDomainNames.CXINTERFACE)) {
							Map<String, String> renameMap = new HashMap<String, String>();
							Set<EObject> intfToCheck = new HashSet<EObject>();
							intfToCheck.add(renamedObj.eContainer());
							getAllGeneralizationReferences(
									renamedObj.eContainer(),
									CXDomainNames.CXINTERFACE,
									intfToCheck);
							for (Property p : renameComponent
									.getAllAttributes()) {
								if (ZDLUtil.isZDLConcept(p,
										CCMNames.INTERFACE_PORT)
										&& intfToCheck.contains(p.getType())) {
									renameMap.put("_pattr_" + p.getName()
											+ "___" + oldRenamedObjName,
											"_pattr_" + p.getName() + "___"
													+ currentRenamedObjName);
								}
							}
							for (String key : renameMap.keySet()) {
								if (currentName.startsWith(key)) {
									ZDLUtil.setValue(
											workerFunction,
											ZMLMMNames.NAMED_ELEMENT,
											ZMLMMNames.NAMED_ELEMENT__NAME,
											currentName.replace(key,
													renameMap.get(key)));
									break;
								}
							}
						}
					}
				}
				String workerFunctionImplName = ZDLUtil.getValue(
						workerFunctionImpl, ZMLMMNames.NAMED_ELEMENT,
						ZMLMMNames.NAMED_ELEMENT__NAME).toString();
				String workerFunctionName = ZDLUtil.getValue(workerFunction,
						ZMLMMNames.NAMED_ELEMENT,
						ZMLMMNames.NAMED_ELEMENT__NAME).toString();
				if (!workerFunctionImplName.equals(workerFunctionName + "Impl")) {
					ZDLUtil.setValue(workerFunctionImpl,
							ZMLMMNames.NAMED_ELEMENT,
							ZMLMMNames.NAMED_ELEMENT__NAME, workerFunctionName
									+ "Impl");
				}
			}
		}
	}

	/**
	 * Get components to rename
	 * 
	 * @param renamedObjectMap
	 * @return
	 */
	private Set<Component> getComponentsToRename(
			final Map<EObject, String> renamedObjectMap) {
		Set<EObject> CIs = new HashSet<EObject>();
		for (EObject thisEObject : renamedObjectMap.keySet()) {
			EObject container = thisEObject.eContainer();
			if (container == null) {
				continue;
			}
			if (ZDLUtil.isZDLConcept(thisEObject, CCMNames.HOME)
					|| ZDLUtil.isZDLConcept(container, CCMNames.HOME)) {
				EObject home = thisEObject;
				if (!ZDLUtil.isZDLConcept(thisEObject, CCMNames.HOME)) {
					home = container;
				}
				Set<EObject> homesToCheck = new HashSet<EObject>();
				homesToCheck.add(home);
				getAllGeneralizationReferences(home, CCMNames.HOME,
						homesToCheck);
				for (EObject aHome : homesToCheck) {
					EObject manages = (EObject) ZDLUtil.getValue(aHome,
							CCMNames.HOME, CCMNames.HOME__MANAGES);
					if (manages != null) {
						EObject CI = (EObject) ZDLUtil.getValue(manages,
								CCMNames.MANAGES, CCMNames.MANAGES__COMPONENT);
						if (CI != null) {
							CIs.add(CI);
						}
					}
				}
			} else if (ZDLUtil.isZDLConcept(container,
					CXDomainNames.CXINTERFACE)) {
				Set<EObject> intfToCheck = new HashSet<EObject>();
				intfToCheck.add(container);
				getAllGeneralizationReferences(container,
						CXDomainNames.CXINTERFACE, intfToCheck);
				for (EObject intf : intfToCheck) {
					for (Setting s : UML2Util.getInverseReferences(intf)) {
						if (s.getEObject() != null
								&& ZDLUtil.isZDLConcept(s.getEObject(),
										CCMNames.INTERFACE_PORT)
								&& ZDLUtil.isZDLConcept(s.getEObject()
										.eContainer(), CCMNames.CCMCOMPONENT)) {
							CIs.add(s.getEObject().eContainer());
							getAllGeneralizationReferences(s.getEObject()
									.eContainer(), CCMNames.CCMCOMPONENT, CIs);
						}
					}
				}
			} else if (ZDLUtil.isZDLConcept(container, CCMNames.CCMCOMPONENT)) {
				CIs.add(container);
				getAllGeneralizationReferences(container,
						CCMNames.CCMCOMPONENT, CIs);
			}
		}

		return getComponentSRs(CIs);
	}

	/**
	 * Returns Map containing renamed object as key and the old name as value.
	 * 
	 * @param event
	 * @param types
	 * @return
	 */
	private static Map<EObject, String> getRenamedObjectMap(
			ResourceSetChangeEvent event, java.lang.Class<?>[] types) {
		Map<EObject, String> renamedObjects = new HashMap<EObject, String>();

		for (Notification thisNotification : event.getNotifications()) {
			int eventType = thisNotification.getEventType();
			if (eventType == Notification.SET) {
				final Object notifier = thisNotification.getNotifier();
				final Object newValue = thisNotification.getNewValue();
				final Object oldValue = thisNotification.getOldValue();

				for (java.lang.Class<?> type : types) {
					if (type.isInstance(notifier)) {
						if (newValue instanceof String && oldValue != null) {
							renamedObjects.put((EObject) notifier,
									(String) oldValue);
							break;
						}
					}
				}
			}
		}
		return renamedObjects;
	}

	/**
	 * Queries SRs of given components
	 * 
	 * @param components
	 * @return
	 */
	private Set<Component> getComponentSRs(Set<EObject> components) {
		Set<Component> result = new HashSet<Component>();

		for (EObject ci : components) {
			for (Setting s : UML2Util.getInverseReferences(ci)) {
				if (s.getEObject() != null
						&& s.getEObject() instanceof Generalization) {
					if (s.getEObject().eContainer() != null
							&& ZDLUtil.isZDLConcept(
									s.getEObject().eContainer(),
									ZMLMMNames.STRUCTURAL_REALIZATION)) {
						result.add((Component) s.getEObject().eContainer());
					}
				}
			}
		}
		return result;
	}

	/**
	 * Queries SRs impacted by Dependency change
	 * 
	 * @param notification
	 * @return
	 */
	private Set<Component> getSRsImpactedByDependencyChange(
			Notification notification) {

		Set<EObject> CIs = new HashSet<EObject>();

		Object feature = notification.getFeature();
		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		EObject notifier = (EObject) notification.getNotifier();
		int eventType = notification.getEventType();
		if (feature instanceof EReference
				&& (eventType == Notification.REMOVE || eventType == Notification.ADD)) {
			if (oldValue != null && safeIsComponentInterface(oldValue)) {
				CIs.add((Component) oldValue);
			}
			if (newValue != null && safeIsComponentInterface(newValue)) {
				CIs.add((Component) newValue);
			}
		}

		if (ZDLUtil.isZDLConcept(notifier, CCMNames.MANAGES)) {
			if (UMLPackage.Literals.DEPENDENCY__SUPPLIER == feature) {
				if (oldValue != null && safeIsComponentInterface(oldValue)) {
					CIs.add((Component) oldValue);
				}
				if (newValue != null && safeIsComponentInterface(newValue)) {
					CIs.add((Component) newValue);
				}
			}
		}

		return getComponentSRs(CIs);
	}

	/**
	 * Queries SRs impacted by Generalization change
	 * 
	 * @param notification
	 * @return
	 */
	private Set<Component> getSRsImpactedByGeneralizationChange(
			Notification notification) {

		Set<EObject> CIs = new HashSet<EObject>();

		Object feature = notification.getFeature();
		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		EObject notifier = (EObject) notification.getNotifier();
		int eventType = notification.getEventType();

		if (!(notifier instanceof Generalization)) {
			return getComponentSRs(CIs);
		}
		if (feature instanceof EReference
				&& (eventType == Notification.REMOVE
						|| eventType == Notification.ADD || eventType == Notification.SET)) {
			List<EObject> values = new ArrayList<EObject>();
			if (oldValue != null) {
				values.add((EObject) oldValue);
			}
			if (newValue != null) {
				values.add((EObject) newValue);
			}
			for (EObject value : values) {
				if (safeIsComponentInterface(value)) {
					CIs.add(value);
					getAllGeneralizationReferences(value,
							CCMNames.CCMCOMPONENT, CIs);
				} else if (ZDLUtil.isZDLConcept(value, CCMNames.HOME)) {
					Set<EObject> homesToCheck = new HashSet<EObject>();
					homesToCheck.add(value);
					getAllGeneralizationReferences(value, CCMNames.HOME,
							homesToCheck);

					for (EObject home : homesToCheck) {
						EObject manages = ZDLUtil.getEValue(home,
								CCMNames.HOME, CCMNames.HOME__MANAGES);
						if (manages != null) {
							EObject comp = ZDLUtil.getEValue(manages,
									CCMNames.MANAGES,
									CCMNames.MANAGES__COMPONENT);
							if (comp != null) {
								CIs.add(comp);
							}
						}
					}
				} else if (ZDLUtil.isZDLConcept(value,
						CXDomainNames.CXINTERFACE)) {
					Set<EObject> intfToCheck = new HashSet<EObject>();
					intfToCheck.add(value);
					getAllGeneralizationReferences(value,
							CXDomainNames.CXINTERFACE, intfToCheck);
					for (EObject intf : intfToCheck) {
						for (Setting s : UML2Util.getInverseReferences(intf)) {
							if (s.getEObject() != null
									&& ZDLUtil.isZDLConcept(s.getEObject(),
											CCMNames.INTERFACE_PORT)) {
								if (s.getEObject().eContainer() != null
										&& ZDLUtil.isZDLConcept(s.getEObject()
												.eContainer(),
												CCMNames.CCMCOMPONENT)) {
									CIs.add(s.getEObject().eContainer());
									getAllGeneralizationReferences(s
											.getEObject().eContainer(),
											CCMNames.CCMCOMPONENT, CIs);
								}
							}
						}
					}
				}
			}
		}

		return getComponentSRs(CIs);
	}

	/**
	 * Queries SRs impacted by home change
	 * 
	 * @param notification
	 * @return
	 */
	private Set<Component> getSRImpactedByHomeChange(Notification notification) {
		Set<EObject> CIs = new HashSet<EObject>();

		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		EObject notifier = (EObject) notification.getNotifier();
		if (ZDLUtil.isZDLConcept(notifier, CCMNames.HOME)
				&& (oldValue instanceof Operation
						|| newValue instanceof Operation
						|| oldValue instanceof Property || newValue instanceof Property)) {

			Set<EObject> homesToCheck = new HashSet<EObject>();
			homesToCheck.add(notifier);
			getAllGeneralizationReferences(notifier, CCMNames.HOME,
					homesToCheck);

			for (EObject home : homesToCheck) {
				EObject manages = ZDLUtil.getEValue(home, CCMNames.HOME,
						CCMNames.HOME__MANAGES);
				if (manages != null) {
					EObject comp = ZDLUtil.getEValue(manages, CCMNames.MANAGES,
							CCMNames.MANAGES__COMPONENT);
					if (comp != null) {
						CIs.add(comp);
					}
				}
			}
		}
		return getComponentSRs(CIs);

	}

	/**
	 * Queries the SRs impacted by interface port change
	 * 
	 * @param notification
	 * @return
	 */
	private Set<Component> getSRImpactedByPortChange(Notification notification) {
		Set<EObject> CIs = new HashSet<EObject>();

		int eventType = notification.getEventType();
		Object feature = notification.getFeature();
		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		EObject notifier = (EObject) notification.getNotifier();
		if (ZDLUtil.isZDLConcept(notifier, CCMNames.INTERFACE_PORT)) {
			EObject base = UMLUtil.getBaseElement(notifier);
			if (base == null) {
				base = notifier;
			}

			if (base.eContainer() != null
					&& ZDLUtil.isZDLConcept(base.eContainer(),
							CCMNames.CCMCOMPONENT)) {
				if (eventType == Notification.SET
						&& (oldValue instanceof Interface || newValue instanceof Interface)) {
					CIs.add(base.eContainer());
					getAllGeneralizationReferences(base.eContainer(),
							CCMNames.CCMCOMPONENT, CIs);
				}
				if (feature instanceof EAttribute
						&& (((EAttribute) feature).getName().equals(
								CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS)
								|| ((EAttribute) feature)
										.getName()
										.equals(ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED) || ((EAttribute) feature)
								.getName().equals(
										CCMNames.INTERFACE_PORT__HAS_CSL))) {
					CIs.add(base.eContainer());
					getAllGeneralizationReferences(base.eContainer(),
							CCMNames.CCMCOMPONENT, CIs);
				}
			}
		}

		return getComponentSRs(CIs);
	}

	/**
	 * Queries the SRs impacted by interface change
	 * 
	 * @param notification
	 * @return
	 */
	private Set<Component> getSRImpactedByInterfaceChange(
			Notification notification) {
		Set<EObject> CIs = new HashSet<EObject>();

		int eventType = notification.getEventType();
		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		EObject notifier = (EObject) notification.getNotifier();

		if (ZDLUtil.isZDLConcept(notifier, CXDomainNames.CXINTERFACE)) {
			if ((eventType == Notification.REMOVE || eventType == Notification.ADD)
					&& (oldValue instanceof Property
							|| newValue instanceof Property
							|| oldValue instanceof Operation || newValue instanceof Operation)) {

				Set<EObject> intfToCheck = new HashSet<EObject>();
				intfToCheck.add(notifier);
				getAllGeneralizationReferences(notifier,
						CXDomainNames.CXINTERFACE, intfToCheck);
				for (EObject intf : intfToCheck) {
					for (Setting s : UML2Util.getInverseReferences(intf)) {
						if (s.getEObject() != null
								&& ZDLUtil.isZDLConcept(s.getEObject(),
										CCMNames.INTERFACE_PORT)) {
							if (s.getEObject().eContainer() != null
									&& ZDLUtil.isZDLConcept(s.getEObject()
											.eContainer(),
											CCMNames.CCMCOMPONENT)) {
								CIs.add(s.getEObject().eContainer());
								getAllGeneralizationReferences(s.getEObject()
										.eContainer(), CCMNames.CCMCOMPONENT,
										CIs);
							}
						}
					}
				}
			}
		}

		return getComponentSRs(CIs);
	}

	/**
	 * Queries SRs impacted by component change
	 * 
	 * @param notification
	 * @return
	 */
	private Set<Component> getSRImpactedByComponentChange(
			Notification notification) {
		Set<EObject> CIs = new HashSet<EObject>();

		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		EObject notifier = (EObject) notification.getNotifier();

		if (ZDLUtil.isZDLConcept(notifier, CCMNames.CCMCOMPONENT)) {
			if (oldValue instanceof Property || newValue instanceof Property
					|| oldValue instanceof Generalization
					|| newValue instanceof Generalization) {
				CIs.add(notifier);
				getAllGeneralizationReferences(notifier, CCMNames.CCMCOMPONENT,
						CIs);
			}
		}

		return getComponentSRs(CIs);
	}

	/**
	 * Queries SRs impacted by component change
	 * 
	 * @param notification
	 * @return
	 */
	private Set<Component> getSRImpactedByAttributeChange(
			Notification notification) {
		Set<EObject> CIs = new HashSet<EObject>();

		Object feature = notification.getFeature();
		EObject notifier = (EObject) notification.getNotifier();

		if (ZDLUtil.isZDLConcept(notifier, CXDomainNames.CXATTRIBUTE)) {
			if (feature instanceof EAttribute
					&& (((EAttribute) feature).getName()
							.equals(CXDomainNames.CXATTRIBUTE__IS_READ_ONLY))) {
				EObject container = notifier.eContainer();
				if (container == null) {
					return getComponentSRs(CIs);
				}
				if (ZDLUtil.isZDLConcept(container, CCMNames.HOME)) {
					Set<EObject> homesToCheck = new HashSet<EObject>();
					homesToCheck.add(container);
					getAllGeneralizationReferences(container, CCMNames.HOME,
							homesToCheck);

					for (EObject home : homesToCheck) {
						EObject manages = ZDLUtil.getEValue(home,
								CCMNames.HOME, CCMNames.HOME__MANAGES);
						if (manages != null) {
							EObject comp = ZDLUtil.getEValue(manages,
									CCMNames.MANAGES,
									CCMNames.MANAGES__COMPONENT);
							if (comp != null) {
								CIs.add(comp);
							}
						}
					}
				} else if (ZDLUtil.isZDLConcept(container,
						CXDomainNames.CXINTERFACE)) {
					Set<EObject> intfToCheck = new HashSet<EObject>();
					intfToCheck.add(container);
					getAllGeneralizationReferences(container,
							CXDomainNames.CXINTERFACE, intfToCheck);
					for (EObject intf : intfToCheck) {
						for (Setting s : UML2Util.getInverseReferences(intf)) {
							if (s.getEObject() != null
									&& ZDLUtil.isZDLConcept(s.getEObject(),
											CCMNames.INTERFACE_PORT)) {
								if (s.getEObject().eContainer() != null
										&& ZDLUtil.isZDLConcept(s.getEObject()
												.eContainer(),
												CCMNames.CCMCOMPONENT)) {
									CIs.add(s.getEObject().eContainer());
									getAllGeneralizationReferences(s
											.getEObject().eContainer(),
											CCMNames.CCMCOMPONENT, CIs);
								}
							}
						}
					}
				} else if (ZDLUtil.isZDLConcept(container,
						CCMNames.CCMCOMPONENT)) {
					CIs.add(container);
					getAllGeneralizationReferences(container,
							CCMNames.CCMCOMPONENT, CIs);
				}
			}
		}

		return getComponentSRs(CIs);
	}

	/**
	 * Returns a set of structural realizations impacted by the given resource
	 * set change
	 * 
	 * @param event
	 * @return
	 */
	private Set<Component> getSRsImpactedByResourceSetChange(
			ResourceSetChangeEvent event) {
		Set<Component> result = new HashSet<Component>();

		List<Notification> notifications = event.getNotifications();
		for (Notification thisNotification : notifications) {

			if (!(thisNotification.getNotifier() instanceof EObject)) {
				continue;
			}
			EObject notifier = (EObject) thisNotification.getNotifier();

			// Check for dependency change for Home manages dependency
			if (notifier instanceof Dependency) {
				result.addAll(getSRsImpactedByDependencyChange(thisNotification));
			}

			// check for home operation and attribute changes
			else if (ZDLUtil.isZDLConcept(notifier, CCMNames.HOME)) {
				result.addAll(getSRImpactedByHomeChange(thisNotification));
			}

			// check for ports and attribute changes in components
			else if (ZDLUtil.isZDLConcept(notifier, CCMNames.CCMCOMPONENT)) {
				result.addAll(getSRImpactedByComponentChange(thisNotification));
			}

			// check for port type or conjugation change
			else if (ZDLUtil.isZDLConcept(notifier, CCMNames.INTERFACE_PORT)) {
				result.addAll(getSRImpactedByPortChange(thisNotification));
			}

			// check for interface attribute change
			else if (ZDLUtil.isZDLConcept(notifier,
					CXDomainNames.CXINTERFACE)) {
				result.addAll(getSRImpactedByInterfaceChange(thisNotification));
			}

			// check for interface attribute change
			else if (ZDLUtil.isZDLConcept(notifier,
					CXDomainNames.CXATTRIBUTE)) {
				result.addAll(getSRImpactedByAttributeChange(thisNotification));
			}

			// check for generalization change
			else if (notifier instanceof Generalization) {
				result.addAll(getSRsImpactedByGeneralizationChange(thisNotification));
			}
		}
		return result;
	}

	/**
	 * Returns all elements that generalize the given element either directly or
	 * indirectly
	 * 
	 * @param context
	 * @param concept
	 * @return
	 */
	private void getAllGeneralizationReferences(EObject context,
			String concept, Set<EObject> results) {
		for (Setting s : UML2Util.getInverseReferences(context)) {
			if (s.getEObject() != null
					&& s.getEObject() instanceof Generalization) {
				if (s.getEObject().eContainer() != null
						&& ZDLUtil.isZDLConcept(s.getEObject().eContainer(),
								concept)
						&& ((Generalization) s.getEObject()).getGeneral() == context) {
					if (!results.contains(s.getEObject().eContainer())) {
						results.add(s.getEObject().eContainer());
						getAllGeneralizationReferences(s.getEObject()
								.eContainer(), concept, results);
					}
				}
			}
		}
	}

}
