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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import com.zeligsoft.domain.zml.util.ZMLUtil;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionContributor;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionInfo;

/**
 * Contributes worker functions for DDS4CCM models.
 * 
 * @author smcfee
 * 
 */
@SuppressWarnings("nls")
public class DDS4CCMWorkerFunctionContributor implements
		WorkerFunctionContributor {

	private static Map<String, String> componentFunctionList = new HashMap<String, String>();

	private static Map<String, String> classFunctionList = new HashMap<String, String>();

	private static Map<String, String> allFunctionList = new HashMap<String, String>();

	private static Map<String, String> allUuidMap = new HashMap<String, String>();

	private static final String EPI = "EPI";

	private static final String CSL = "CSL";

	private static final String EXCEP = "excep";

	private static final String GET = "get";

	private static final String SET = "set";

	static {

		// These are added one-per-implementation.
		componentFunctionList.put("configuration_complete",
				"20cc3332-cde0-4453-a203-77cc07636ca5");
		componentFunctionList.put("ccm_activate",
				"8e4b6598-f7c7-47da-baec-335787305ef1");
		componentFunctionList.put("ccm_passivate",
				"51b784de-1d1e-4889-87d9-5aeb2db9ee40");
		componentFunctionList.put("ccm_remove",
				"91e71bbe-94b8-44ad-bbe0-69428fb1b9c0");

		// These are added one-per-implementation since the executor has a
		// single header and implementation file.
		componentFunctionList.put("file_header_h",
				"0953aa3d-7acf-4f2e-b961-585b4c64e733");
		componentFunctionList.put("file_header_cpp",
				"bba2e06e-0e88-405e-90d9-cd16056fb2dd");
		componentFunctionList.put("file_footer_h",
				"81586ffd-807c-4410-9aa3-6f5c0407dded");
		componentFunctionList.put("file_footer_cpp",
				"871ea049-1571-4afd-a540-dfc290acdb8c");
		componentFunctionList.put("file_includes_h",
				"cb6fe1c0-6cdd-449f-91b4-52a74c08bc19");
		componentFunctionList.put("file_includes_cpp",
				"a7afdcff-107b-41d2-8ea9-43d345979aca");

		// These are added one-per-class. Classes exist for each facet, AMI4CCM
		// receptacle, home, and the implementation itself.
		classFunctionList.put("constructor_operation_impl",
				"2ce76422-f52d-46f4-ba42-fd54661049f8");
		classFunctionList.put("destructor_operation_impl",
				"e1c7303f-a078-41e1-a773-3b376f68d985");
		classFunctionList.put("constructor_init_list",
				"85c76ce6-8913-4016-8290-402b4e964fa1");
		classFunctionList.put("class_public_methods_section_declare",
				"8112f16f-e8dc-4850-8c3a-ebd39fc8679a");
		classFunctionList.put("class_public_methods_section_impl",
				"d419cf14-cedd-49bc-8333-f929e3a5ab7d");
		classFunctionList.put("class_private_methods_section_declare",
				"8d55e7b0-e380-4200-be80-749cf0c8f093");
		classFunctionList.put("class_private_methods_section_impl",
				"0cbbf96f-3e15-4953-8504-9bd1603ac703");
		classFunctionList.put("class_private_members_section_declare",
				"f8e9ce81-6228-47b1-b84e-7e93c584e056");

		allFunctionList.put("create", "2a3eb5ba-5cd1-4770-b5a4-6a9da27a37c5");
		allFunctionList.putAll(classFunctionList);

		allUuidMap.put(CSL, "2752c326-13d4-40d9-9f76-c24c9b8f2195");
		allUuidMap.put(EPI, "ffede1ed-9005-47f8-8d8f-9e2f8150d17c");
		allUuidMap.put(EXCEP, "f342a761-ed0a-447d-bc91-7b8b389a2905");
		allUuidMap.put(GET, "162231f8-9ae5-4b97-9f17-059a4734f64f");
		allUuidMap.put(SET, "b4a804cc-c40c-4b8b-85bd-27e81d75876a");

		allUuidMap.putAll(allFunctionList);
		allUuidMap.putAll(componentFunctionList);

	}

	@Override
	public void filterGrowList(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target,
			Map<Port, List<WorkerFunctionInfo>> toAdd) {

		Component componentInterface = ZMLUtil
				.getComponentInterface(structuralRealization);

		if (componentInterface == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		List<Operation> existingWorkerFunctions = (List<Operation>) ZDLUtil
				.getValue(structuralRealization,
						ZMLMMNames.STRUCTURAL_REALIZATION,
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);

		for (Port thisPort : target.keySet()) {
			for (WorkerFunctionInfo thisOperation : target.get(thisPort)) {
				Iterator<Operation> iter = existingWorkerFunctions.iterator();
				boolean found = false;
				while (iter.hasNext() && !found) {
					Operation thisExistingOperation = iter.next();
					Port wfPort = (Port) ZDLUtil.getValue(
							thisExistingOperation, ZMLMMNames.WORKER_FUNCTION,
							ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
					Operation wfOperation = null;
					if (thisPort == wfPort) {
						wfOperation = (Operation) ZDLUtil.getValue(
								thisExistingOperation,
								ZMLMMNames.WORKER_FUNCTION,
								ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
					}

					if (thisPort == wfPort
							&& thisOperation.getOperation() == wfOperation) {
						found = true;
					} else if (thisPort == wfPort
							&& thisExistingOperation.getName().endsWith(
									"_" + EXCEP)
							&& thisExistingOperation.getName().endsWith(
									thisOperation.getOperation().getName())) {
						found = true;
					} else if (thisPort.getName().endsWith("_CSL")) {
						if (wfOperation == null) {
							wfOperation = (Operation) ZDLUtil.getValue(
									thisExistingOperation,
									ZMLMMNames.WORKER_FUNCTION,
									ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
						}
						if (thisOperation.getOperation() == wfOperation
								&& thisExistingOperation.getName().startsWith(
										thisPort.getName())) {
							found = true;
						}
					} else if (thisPort.getName().endsWith("_EPI")) {
						if (wfOperation == null) {
							wfOperation = (Operation) ZDLUtil.getValue(
									thisExistingOperation,
									ZMLMMNames.WORKER_FUNCTION,
									ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
						}
						if (thisOperation.getOperation() == wfOperation
								&& thisExistingOperation.getName().startsWith(
										thisPort.getName())) {
							found = true;
						}
					} else if (thisPort.getName().startsWith("_pattr_")
							&& thisExistingOperation.getName().equals(
									thisPort.getName()
											+ "_"
											+ thisOperation.getOperation()
													.getName())) {
						found = true;
					}
				}
				if (found) {
					toAdd.get(thisPort).remove(thisOperation);
					if (toAdd.get(thisPort).isEmpty()) {
						toAdd.remove(thisPort);
					}
				}
			}
		}

		// let's find home
		Class home = null;
		Port homePort = null;
		for (Setting s : UML2Util.getInverseReferences(componentInterface)) {
			if (s.getEObject() != null
					&& ZDLUtil.isZDLConcept(s.getEObject(), CCMNames.MANAGES)) {
				home = (Class) ZDLUtil.getValue(s.getEObject(),
						CCMNames.MANAGES, CCMNames.MANAGES__HOME);
				break;
			}
		}
		if (home != null) {
			for (Port p : toAdd.keySet()) {
				// Get port name for home
				if (p.getName().equals("_home_" + home.getName())) {
					homePort = p;
					break;
				}
			}
		}

		for (Operation thisWorkerFunction : existingWorkerFunctions) {

			boolean magicFunction = false;
			for (String s : componentFunctionList.keySet()) {
				if (thisWorkerFunction.getName().equals("_" + s)) {
					magicFunction = true;
				}
			}
			for (String s : allFunctionList.keySet()) {
				if (thisWorkerFunction.getName().contains("_" + s)) {
					magicFunction = true;
				}
			}
			if (magicFunction) {
				Iterator<Port> itor = toAdd.keySet().iterator();
				while (itor.hasNext()) {
					Port p = itor.next();
					if (p != null) {
						WorkerFunctionInfo toRemove = null;
						for (WorkerFunctionInfo op : toAdd.get(p)) {
							if (thisWorkerFunction.getName().equals(
									p.getName() + "_"
											+ op.getOperation().getName())) {
								toRemove = op;
								break;
							}
						}
						if (toRemove != null) {
							toAdd.get(p).remove(toRemove);
							if (toAdd.get(p).size() == 0) {
								itor.remove();
							}
							break;
						}
					}
				}
			} else if (thisWorkerFunction.getName().startsWith("_attr_")) {
				// Attributes
				for (Property p : componentInterface.getAllAttributes()) {
					if (ZDLUtil
							.isZDLConcept(p, CXDomainNames.CXATTRIBUTE)) {
						String operationName = thisWorkerFunction.getName();
						if (thisWorkerFunction.getName().equals(
								"_attr_" + p.getName() + "_get")
								|| (thisWorkerFunction.getName().equals(
										"_attr_" + p.getName() + "_set") && ZDLUtil
										.getValue(
												p,
												CXDomainNames.CXATTRIBUTE,
												CXDomainNames.CXATTRIBUTE__IS_READ_ONLY) != Boolean.TRUE)) {
							List<Port> removeList = new ArrayList<Port>();
							for (Port port : toAdd.keySet()) {
								if (port.getName().equals(
										"_attr_" + p.getName())) {
									for (WorkerFunctionInfo info : toAdd
											.get(port)) {
										if (operationName.endsWith(info
												.getOperation().getName())) {
											toAdd.get(port).remove(info);
											break;
										}
									}
									if (toAdd.get(port).isEmpty()) {
										removeList.add(port);
									}
									break;
								}
							}
							for (Port port : removeList) {
								toAdd.remove(port);
							}
						}
					}
				}
			} else if (home != null) {
				// take care of home operations and attributes
				boolean found = false;
				if (homePort != null && toAdd.get(homePort) != null) {
					EObject portOp = ZDLUtil.getEValue(thisWorkerFunction,
							ZMLMMNames.WORKER_FUNCTION,
							ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
					Iterator<WorkerFunctionInfo> itor = toAdd.get(homePort)
							.iterator();
					while (itor.hasNext()) {
						WorkerFunctionInfo info = itor.next();
						if (info.getOperation() == portOp) {
							itor.remove();
							found = true;
							break;
						}
					}
					if (toAdd.get(homePort).size() == 0) {
						toAdd.remove(homePort);
					}
				}
				if (found) {
					continue;
				}
				for (Property p : home.getAllAttributes()) {
					if (ZDLUtil
							.isZDLConcept(p, CXDomainNames.CXATTRIBUTE)) {
						String operationName = thisWorkerFunction.getName();
						if (thisWorkerFunction.getName().equals(
								"_hattr_" + home.getName() + "___"
										+ p.getName() + "_get")
								|| (thisWorkerFunction.getName().equals(
										"_hattr_" + home.getName() + "___"
												+ p.getName() + "_set") && ZDLUtil
										.getValue(
												p,
												CXDomainNames.CXATTRIBUTE,
												CXDomainNames.CXATTRIBUTE__IS_READ_ONLY) != Boolean.TRUE)) {
							List<Port> removeList = new ArrayList<Port>();
							for (Port port : toAdd.keySet()) {
								if (port.getName().equals(
										"_hattr_" + home.getName() + "___"
												+ p.getName())) {
									for (WorkerFunctionInfo info : toAdd
											.get(port)) {
										if (operationName.endsWith(info
												.getOperation().getName())) {
											toAdd.get(port).remove(info);
											break;
										}
									}
									if (toAdd.get(port).isEmpty()) {
										removeList.add(port);
									}
									break;
								}
							}
							for (Port port : removeList) {
								toAdd.remove(port);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void filterPruneList(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target, List<Operation> toRemove) {

		Component componentInterface = ZMLUtil
				.getComponentInterface(structuralRealization);

		if (componentInterface == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		List<Operation> existingWorkerFunctions = (List<Operation>) ZDLUtil
				.getValue(structuralRealization,
						ZMLMMNames.STRUCTURAL_REALIZATION,
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);

		// find CLS ports
		Set<Port> cslPorts = new HashSet<Port>();
		Map<String, Port> providedPorts = new HashMap<String, Port>();
		for (Port key : target.keySet()) {
			if (key.getName().endsWith("_CSL")) {
				cslPorts.add(key);
			} else if (key.getName().endsWith("_EPI")) {
				providedPorts.put(key.getName(), key);
			}
		}

		for (Operation thisWorkerFunction : existingWorkerFunctions) {

			boolean magicFunction = false;
			for (String s : componentFunctionList.keySet()) {
				if (thisWorkerFunction.getName().equals("_" + s)) {
					magicFunction = true;
				}
			}
			for (String s : allFunctionList.keySet()) {
				if (thisWorkerFunction.getName().equals("_" + s)) {
					magicFunction = true;
				}
			}
			if (magicFunction) {
				toRemove.remove(thisWorkerFunction);
			} else if (thisWorkerFunction.getName().startsWith("_attr_")) {
				// this is worker function for attribute
				for (Property p : componentInterface.getAllAttributes()) {
					if (ZDLUtil
							.isZDLConcept(p, CXDomainNames.CXATTRIBUTE)) {
						if (thisWorkerFunction.getName().equals(
								"_attr_" + p.getName() + "_get")
								|| (thisWorkerFunction.getName().equals(
										"_attr_" + p.getName() + "_set") && ZDLUtil
										.getValue(
												p,
												CXDomainNames.CXATTRIBUTE,
												CXDomainNames.CXATTRIBUTE__IS_READ_ONLY) != Boolean.TRUE)) {
							toRemove.remove(thisWorkerFunction);
						}
					}
				}
			} else {
				Port thisPort = (Port) ZDLUtil.getValue(thisWorkerFunction,
						ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
				Operation thisOperation = null;

				if (thisPort == null
						|| ZDLUtil.isZDLConcept(thisPort,
								ZMLMMNames.MESSAGE_PORT)) {

					boolean found = false;

					// check for CSL worker functions
					if (thisWorkerFunction.getName().contains("_CSL_")) {
						for (Port port : cslPorts) {
							if (thisWorkerFunction.getName().startsWith(
									port.getName())) {
								found = true;
								break;
							}
						}
					}

					if (thisPort != null && thisPort.getType() != null) {
						for (String s : classFunctionList.keySet()) {
							if (thisWorkerFunction.getName().equals(
									thisPort.getName() + "_" + s)) {
								if (target.containsKey(thisPort)) {
									found = true;
									break;
								}
							}
						}
					} else if (thisWorkerFunction.getName().contains("_EPI_")) {
						// this is port for one of the provided interface from
						// the extended port type
						String portName = thisWorkerFunction.getName().split(
								"_EPI_")[0]
								+ "_EPI";
						for (String s : classFunctionList.keySet()) {
							if (thisWorkerFunction.getName().equals(
									portName + "_" + s)) {
								if (providedPorts.containsKey(portName)) {
									found = true;
									break;
								}
							}
						}
						if (!found) {
							// this is not magic function
							if (thisOperation == null) {
								thisOperation = (Operation) ZDLUtil
										.getValue(
												thisWorkerFunction,
												ZMLMMNames.WORKER_FUNCTION,
												ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
							}
							if (providedPorts.containsKey(portName)) {
								for (WorkerFunctionInfo info : target
										.get(providedPorts.get(portName))) {
									if (info.getOperation() == thisOperation) {
										found = true;
										break;
									}
								}
							}
						}
					}

					if (!found) {
						List<WorkerFunctionInfo> operations = target
								.get(thisPort);
						if (operations != null) {
							Iterator<WorkerFunctionInfo> iter = operations
									.iterator();

							if (thisOperation == null) {
								thisOperation = (Operation) ZDLUtil
										.getValue(
												thisWorkerFunction,
												ZMLMMNames.WORKER_FUNCTION,
												ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
							}

							while (iter.hasNext() && !found) {
								WorkerFunctionInfo op = iter.next();
								if (op.getOperation() == thisOperation) {
									found = true;
								}

								// check for special method _excep that we added
								// for conjugated and asynchronous port
								if (thisWorkerFunction.getName().endsWith(
										"_excep")
										&& thisWorkerFunction.getName()
												.endsWith(
														op.getOperation()
																.getName())) {
									found = true;
								}
							}
						}
					}

					if (!found
							&& thisWorkerFunction.getName().startsWith(
									"_pattr_")) {
						// check attributes;
						for (Port port : target.keySet()) {
							if (!port.getName().startsWith("_pattr_")) {
								continue;
							}
							for (WorkerFunctionInfo info : target.get(port)) {
								if (thisWorkerFunction
										.getName()
										.equals(port.getName() + "_"
												+ info.getOperation().getName())) {
									found = true;
									break;
								}
							}
							if (found) {
								break;
							}
						}
					}

					if (found) {
						toRemove.remove(thisWorkerFunction);
					}
				}
			}
		}

		org.eclipse.uml2.uml.Class home = null;
		for (Setting s : UML2Util.getInverseReferences(componentInterface)) {
			if (s.getEObject() != null
					&& ZDLUtil.isZDLConcept(s.getEObject(), CCMNames.MANAGES)) {
				home = (org.eclipse.uml2.uml.Class) ZDLUtil.getValue(
						s.getEObject(), CCMNames.MANAGES,
						CCMNames.MANAGES__HOME);
				break;
			}
		}

		Port homePort = null;
		if (home != null) {
			for (Port p : target.keySet()) {
				// Get port name for home
				if (p.getName().equals("_home_" + home.getName())) {
					homePort = p;
					break;
				}
			}
		}
		if (home != null) {

			for (Operation thisWorkerFunction : existingWorkerFunctions) {
				boolean found = false;
				for (String s : allFunctionList.keySet()) {
					if (thisWorkerFunction.getName().equals(
							"_home_" + home.getName() + "_" + s)) {
						toRemove.remove(thisWorkerFunction);
						found = true;
						break;
					}
				}
				if (!found && homePort != null) {
					Operation thisOperation = (Operation) ZDLUtil.getValue(
							thisWorkerFunction, ZMLMMNames.WORKER_FUNCTION,
							ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
					Iterator<WorkerFunctionInfo> iter = target.get(homePort)
							.iterator();
					while (iter.hasNext()) {
						WorkerFunctionInfo op = iter.next();
						if (op.getOperation() == thisOperation
								&& target.get(homePort).contains(op)) {
							toRemove.remove(thisWorkerFunction);
							found = true;
							break;
						}
					}
				}
				if (!found
						&& thisWorkerFunction.getName().startsWith(
								"_hattr_" + home.getName())) {
					// Attributes
					for (Property p : home.getAllAttributes()) {
						if (ZDLUtil.isZDLConcept(p,
								CXDomainNames.CXATTRIBUTE)) {
							if (thisWorkerFunction.getName().equals(
									"_hattr_" + home.getName() + "___"
											+ p.getName() + "_get")
									|| (thisWorkerFunction.getName().equals(
											"_hattr_" + home.getName() + "___"
													+ p.getName() + "_set") && ZDLUtil
											.getValue(
													p,
													CXDomainNames.CXATTRIBUTE,
													CXDomainNames.CXATTRIBUTE__IS_READ_ONLY) != Boolean.TRUE)) {
								toRemove.remove(thisWorkerFunction);
								break;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void buildTargetMap(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target) {

		Map<EObject, UuidDescriptor> uuidMap = new HashMap<EObject, UuidDescriptor>();
		String implUuid = (String) ZDLUtil.getValue(structuralRealization,
				ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
				ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
		UuidDescriptor implUuidDesc = new UuidDescriptor(implUuid);
		Component componentInterface = ZMLUtil
				.getComponentInterface(structuralRealization);
		if (componentInterface == null) {
			return;
		}

		List<Port> componentInterfacePorts = new ArrayList<Port>();
		for (Property p : componentInterface.getAllAttributes()) {
			if (ZDLUtil.isZDLConcept(p, CCMNames.INTERFACE_PORT)
					&& p.getType() != null) {
				componentInterfacePorts.add((Port) p);
				String portUuid = UML2Util.EMPTY_STRING;
				if (implUuidDesc.isValid()) {
					portUuid = (String) ZDLUtil.getValue(p,
							ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
							ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
				}
				uuidMap.put(p, implUuidDesc.getNewUuidDescriptor(portUuid));

				if ((Boolean) ZDLUtil.getValue(p, CCMNames.INTERFACE_PORT,
						CCMNames.INTERFACE_PORT__HAS_CSL)
						&& !(Boolean) ZDLUtil.getValue(p,
								ZMLMMNames.CONJUGATED_PORT,
								ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED)) {
					// add CSL port
					Port cslPort = UMLFactory.eINSTANCE.createPort();
					cslPort.setName(p.getName() + "_" + CSL);
					cslPort.setType(getCSLInterface(p));
					componentInterfacePorts.add(cslPort);
					uuidMap.put(
							cslPort,
							uuidMap.get(p).getNewUuidDescriptor(
									allUuidMap.get(CSL)));
				}
			}
		}

		// Worker functions related to facets and AMI4CCM receptacles
		for (Port thisPort : componentInterfacePorts) {
			if (thisPort.getType() == null) {
				continue;
			}

			UuidDescriptor thisPortUuidDesc = uuidMap.get(thisPort);
			List<Interface> interfaceList = new ArrayList<Interface>();
			boolean addExcepMethod = false;
			if (ZDLUtil.isZDLConcept(thisPort, CCMNames.INTERFACE_PORT)) {
				boolean isConjugated = (Boolean) ZDLUtil.getValue(thisPort,
						ZMLMMNames.CONJUGATED_PORT,
						ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED);
				boolean isAsynchronous = (Boolean) ZDLUtil.getValue(thisPort,
						CCMNames.INTERFACE_PORT,
						CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS);
				if (isConjugated && isAsynchronous) {
					addExcepMethod = true;
				}
				if (!isConjugated || isAsynchronous) {
					interfaceList = thisPort.getProvideds();
				} else {
					// if it's a normal receptacle, getRequireds would be
					// empty anyway so we are saying no wf
				}
			} else {
				// which means that this is the CSL port we added
				interfaceList = thisPort.getProvideds();
			}
			for (Interface thisInterface : interfaceList) {

				Port targetPort = thisPort;
				UuidDescriptor targetPortUuidDesc = thisPortUuidDesc;

				if (ZDLUtil.isZDLConcept(thisPort.getType(),
						IDL3PlusNames.EXTENDED_PORT_TYPE)) {
					Class portType = (Class) thisPort.getType();
					String irName = UML2Util.EMPTY_STRING;
					for (InterfaceRealization ir : portType
							.getInterfaceRealizations()) {
						if (ir.getContract() == thisInterface) {
							irName = ir.getName();
							if (UML2Util.isEmpty(irName)) {
								irName = thisInterface.getName();
							}
							break;
						}
					}
					targetPort = UMLFactory.eINSTANCE.createPort();
					targetPort.setName(thisPort.getName() + "_" + irName + "_"
							+ EPI);
					targetPortUuidDesc = thisPortUuidDesc
							.getNewUuidDescriptor(allUuidMap.get(EPI));
					uuidMap.put(targetPort, targetPortUuidDesc);
				}

				String intfUuid = UML2Util.EMPTY_STRING;
				if (targetPortUuidDesc.isValid()
						&& ZDLUtil.isZDLConcept(thisInterface,
								ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE)) {
					intfUuid = (String) ZDLUtil.getValue(thisInterface,
							ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
							ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
				}

				UuidDescriptor intfUuidDesc = targetPortUuidDesc
						.getNewUuidDescriptor(intfUuid);

				if (ZDLUtil.isZDLConcept(thisInterface, ZMLMMNames.INTERFACE)) {
					List<Operation> allOperations = thisInterface
							.getAllOperations();
					List<WorkerFunctionInfo> portOpsList = new LinkedList<WorkerFunctionInfo>();
					for (Operation thisOperation : allOperations) {
						String opUuid = UML2Util.EMPTY_STRING;
						if (intfUuidDesc.isValid()) {
							opUuid = (String) ZDLUtil
									.getValue(
											thisOperation,
											ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
											ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
						}
						UuidDescriptor opUuidDesc = intfUuidDesc
								.getNewUuidDescriptor(opUuid);
						if (ZDLUtil.isZDLConcept(thisOperation,
								ZMLMMNames.OPERATION)) {
							portOpsList.add(new WorkerFunctionInfo(
									thisOperation, opUuidDesc.toString()));
							if (addExcepMethod) {
								portOpsList.add(createWorkerFunctionInfo(
										thisOperation.getName() + "_" + EXCEP,
										opUuidDesc.getNewUuidDescriptor(
												allUuidMap.get(EXCEP))
												.toString()));
							}
						}
					}
					for (String s : classFunctionList.keySet()) {
						portOpsList.add(createWorkerFunctionInfo(
								s,
								intfUuidDesc.getNewUuidDescriptor(
										allUuidMap.get(s)).toString()));
					}

					if (!portOpsList.isEmpty()) {
						if (target.get(targetPort) == null) {
							target.put(targetPort, portOpsList);
						} else {
							target.get(targetPort).addAll(portOpsList);
						}
					}
					// port interface attributes
					
					for (Property attr : thisInterface.getAllAttributes()) {
						if (ZDLUtil.isZDLConcept(attr,
								CXDomainNames.CXATTRIBUTE)) {
							String attrUuid = UML2Util.EMPTY_STRING;
							if (intfUuidDesc.isValid()) {
								attrUuid = (String) ZDLUtil
										.getValue(
												attr,
												ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
												ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
							}
							UuidDescriptor attrUuidDesc = intfUuidDesc
									.getNewUuidDescriptor(attrUuid);
							Port attrPort = UMLFactory.eINSTANCE.createPort();
							attrPort.setName("_pattr_" + getPortAttributeClassName(thisPort, thisInterface)
									+ "___" + attr.getName());
							target.put(attrPort,
									new ArrayList<WorkerFunctionInfo>());
							target.get(attrPort).add(
									createWorkerFunctionInfo(
											GET,
											attrUuidDesc.getNewUuidDescriptor(
													allUuidMap.get(GET))
													.toString()));
							if (ZDLUtil
									.getValue(
											attr,
											CXDomainNames.CXATTRIBUTE,
											CXDomainNames.CXATTRIBUTE__IS_READ_ONLY) != Boolean.TRUE) {
								target.get(attrPort)
										.add(createWorkerFunctionInfo(
												SET,
												attrUuidDesc
														.getNewUuidDescriptor(
																allUuidMap
																		.get(SET))
														.toString()));
							}
						}
					}
				}
			}
		}

		// Hard-coded operations for the implementation.
		Set<WorkerFunctionInfo> ccmOps = new LinkedHashSet<WorkerFunctionInfo>();
		Port fakePort = UMLFactory.eINSTANCE.createPort();
		fakePort.setName(UML2Util.EMPTY_STRING);

		for (String s : componentFunctionList.keySet()) {
			ccmOps.add(createWorkerFunctionInfo(s, implUuidDesc
					.getNewUuidDescriptor(allUuidMap.get(s)).toString()));
		}
		for (String s : classFunctionList.keySet()) {
			ccmOps.add(createWorkerFunctionInfo(s, implUuidDesc
					.getNewUuidDescriptor(allUuidMap.get(s)).toString()));
		}

		target.put(fakePort, new ArrayList<WorkerFunctionInfo>(ccmOps));

		// Worker functions related to Homes
		org.eclipse.uml2.uml.Class home = null;
		for (Setting s : UML2Util.getInverseReferences(componentInterface)) {
			if (s.getEObject() != null
					&& ZDLUtil.isZDLConcept(s.getEObject(), CCMNames.MANAGES)) {
				home = (org.eclipse.uml2.uml.Class) ZDLUtil.getValue(
						s.getEObject(), CCMNames.MANAGES,
						CCMNames.MANAGES__HOME);
			}
		}
		if (home != null) {
			Port homePort = UMLFactory.eINSTANCE.createPort();
			homePort.setName("_home_" + home.getName());
			target.put(homePort, new ArrayList<WorkerFunctionInfo>());
			String homeUuid = UML2Util.EMPTY_STRING;
			if (implUuidDesc.isValid()) {
				homeUuid = (String) ZDLUtil.getValue(home,
						ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
						ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
			}
			UuidDescriptor homeUuidDesc = implUuidDesc
					.getNewUuidDescriptor(homeUuid);

			for (String s : allFunctionList.keySet()) {
				target.get(homePort).add(
						createWorkerFunctionInfo(s, homeUuidDesc
								.getNewUuidDescriptor(allUuidMap.get(s))
								.toString()));
			}
			for (Operation op : home.getAllOperations()) {
				if (ZDLUtil.isZDLConcept(op, CXDomainNames.CXOPERATION)) {
					String opUuid = UML2Util.EMPTY_STRING;
					if (homeUuidDesc.isValid()) {
						opUuid = (String) ZDLUtil.getValue(op,
								ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
								ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
					}
					UuidDescriptor opUuidDesc = homeUuidDesc
							.getNewUuidDescriptor(opUuid);
					target.get(homePort).add(
							new WorkerFunctionInfo(op, opUuidDesc.toString()));
				}
			}
			for (Property attr : home.getAllAttributes()) {
				if (ZDLUtil.isZDLConcept(attr, CXDomainNames.CXATTRIBUTE)) {
					String attrUuid = UML2Util.EMPTY_STRING;
					if (homeUuidDesc.isValid()) {
						attrUuid = (String) ZDLUtil.getValue(attr,
								ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
								ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
					}
					UuidDescriptor attrUuidDesc = homeUuidDesc
							.getNewUuidDescriptor(attrUuid);

					Port attrPort = UMLFactory.eINSTANCE.createPort();
					attrPort.setName("_hattr_" + home.getName() + "___"
							+ attr.getName());
					target.put(attrPort, new ArrayList<WorkerFunctionInfo>());
					target.get(attrPort).add(
							createWorkerFunctionInfo(GET, attrUuidDesc
									.getNewUuidDescriptor(allUuidMap.get(GET))
									.toString()));
					if (ZDLUtil.getValue(attr, CXDomainNames.CXATTRIBUTE,
							CXDomainNames.CXATTRIBUTE__IS_READ_ONLY) != Boolean.TRUE) {
						target.get(attrPort)
								.add(createWorkerFunctionInfo(
										SET,
										attrUuidDesc.getNewUuidDescriptor(
												allUuidMap.get(SET)).toString()));
					}
				}
			}
		}

		// component attributes
		for (Property p : componentInterface.getAllAttributes()) {
			if (ZDLUtil.isZDLConcept(p, CXDomainNames.CXATTRIBUTE)) {
				String attrUuid = UML2Util.EMPTY_STRING;
				if (implUuidDesc.isValid()) {
					attrUuid = (String) ZDLUtil.getValue(p,
							ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE,
							ZMLMMNames.WORKER_FUNCTION_IDENTIFIABLE__UUID);
				}
				UuidDescriptor attrUuidDesc = implUuidDesc
						.getNewUuidDescriptor(attrUuid);

				Port attrPort = UMLFactory.eINSTANCE.createPort();
				attrPort.setName("_attr_" + p.getName());
				target.put(attrPort, new ArrayList<WorkerFunctionInfo>());
				target.get(attrPort).add(
						createWorkerFunctionInfo(GET, attrUuidDesc
								.getNewUuidDescriptor(allUuidMap.get(GET))
								.toString()));
				if (ZDLUtil.getValue(p, CXDomainNames.CXATTRIBUTE,
						CXDomainNames.CXATTRIBUTE__IS_READ_ONLY) != Boolean.TRUE) {
					target.get(attrPort).add(
							createWorkerFunctionInfo(SET, attrUuidDesc
									.getNewUuidDescriptor(allUuidMap.get(SET))
									.toString()));
				}
			}
		}
	}
	
	/**
	 * Calculate attribute class name
	 * @param thisPort
	 * @param thisInterface
	 * @return
	 */
	protected String getPortAttributeClassName(Port thisPort, Interface thisInterface){
		String result = thisPort.getName();
		Type type = thisPort.getType();
		if(type != null && ZDLUtil.isZDLConcept(type, IDL3PlusNames.EXTENDED_PORT_TYPE)) {
			Class ept = (Class) type;
			for(InterfaceRealization ir : ept.getInterfaceRealizations()) {
				if(ir.getContract() == thisInterface) {
					result = result + "_" + ir.getName();
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Find CSL interface
	 * 
	 * @param context
	 * @return
	 */
	private Type getCSLInterface(EObject context) {
		Package root = (Package) EcoreUtil.getRootContainer(context);
		return getCSLInterface(root);
	}

	private Type getCSLInterface(Package root) {
		for (PackageImport pi : root.getPackageImports()) {
			if ("DDS_DCPS".equals(pi.getImportedPackage().getName())) { //$NON-NLS-1$
				return (Type) UMLUtil
						.findNamedElements(pi.getImportedPackage().eResource(),
								"DDS_DCPS::CCM_DDS::ConnectorStatusListener")
						.iterator().next();
			}
			Type retVal = getCSLInterface(pi.getImportedPackage());
			if (retVal != null) {
				return retVal;
			}
		}
		return null;

	}

	/**
	 * Creates workerfunction info with given operation name
	 * 
	 * @param name
	 * @return
	 */
	private WorkerFunctionInfo createWorkerFunctionInfo(String name, String uuid) {
		Operation op = UMLFactory.eINSTANCE.createOperation();
		op.setName(name);
		return new WorkerFunctionInfo(op, uuid);
	}

	/**
	 * UUID descriptor
	 * 
	 * @author ysroh
	 * 
	 */
	class UuidDescriptor {

		private UUID uuid = null;

		private boolean isValid = true;

		public UuidDescriptor(String uuid) {
			if (UML2Util.isEmpty(uuid)) {
				isValid = false;
				return;
			}
			try {
				this.uuid = UUID.fromString(uuid);
			} catch (IllegalArgumentException e) {
				isValid = false;
			}
		}

		public UuidDescriptor getNewUuidDescriptor(String uuid) {
			if (!isValid) {
				return this;
			}
			UuidDescriptor result = new UuidDescriptor(this.toString());
			result.add(uuid);
			return result;
		}

		public void add(String aUuid) {
			if (!isValid) {
				return;
			}
			if (UML2Util.isEmpty(aUuid)) {
				isValid = false;
				return;
			}
			try {
				UUID newUuid = UUID.fromString(aUuid);
				uuid = new UUID(uuid.getMostSignificantBits()
						+ newUuid.getMostSignificantBits(),
						uuid.getLeastSignificantBits()
								+ newUuid.getLeastSignificantBits());
			} catch (IllegalArgumentException e) {
				isValid = false;
			}
		}

		public boolean isValid() {
			return isValid;
		}

		@Override
		public String toString() {
			if (isValid && uuid != null) {
				return uuid.toString();
			}
			return UML2Util.EMPTY_STRING;
		}
	}

}
