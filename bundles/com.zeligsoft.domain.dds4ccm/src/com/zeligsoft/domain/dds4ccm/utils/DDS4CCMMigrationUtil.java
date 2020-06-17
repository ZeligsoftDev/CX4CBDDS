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
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.Activator;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.util.CORBAMigrationUtil;
import com.zeligsoft.domain.zml.util.WorkerFunctionRepair;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

@SuppressWarnings("nls")
public final class DDS4CCMMigrationUtil {

	private static final String SOURCE_NAME = "cx.migration"; //$NON-NLS-1$

	private static final String CURRENT_VERSION = "1.4.1"; //$NON-NLS-1$

	private static boolean migrateAll(Model model, boolean probe) {
		boolean result = false;
		String modelVersion = getModelVersion(model);

		if (compareVersion("1.0.7", modelVersion) > 0) {
			// things to migrate for model with version 1.0.6 or less
			if (!probe) {
				CORBAMigrationUtil.migrateArrayBound(model);
			}
			result = true;
		}

		if (compareVersion("1.1.2", modelVersion) > 0) {
			// things to migrate for model with version 1.1.1 or less
			if (!probe) {
				migrateWorkerFunction(model);
			}
			result = true;
		}

		if (compareVersion("1.2.2", modelVersion) > 0) {
			// things to migrate for model with version 1.2.1 or less
			if (!probe) {
				repairAllWorkerfunctions(model);
			}
			result = true;
		}
		
		if (compareVersion("1.2.6", modelVersion) > 0) {
			// things to migrate for model with version 1.2.5 or less
			if (!probe) {
				setAsynchronousInterface(model);
			}
			result = true;
		}

		if (compareVersion("1.2.8", modelVersion) > 0) {
			// things to migrate for model with version 1.2.7 or less
			if (!probe) {
				CORBAMigrationUtil.migrateBounds(model);
			}
			result = true;
		}
		
		if (compareVersion("1.4.1", modelVersion) > 0) {
			// things to migrate for model with version 1.4.0 or less
			if (!probe) {
				addPortsToDeployment(model);
			}
			result = true;
		}
		
		if (!probe && result) {
			try {
				addMigrationAnnotation(model, CURRENT_VERSION);
			} catch (Exception e) {
				Activator.getDefault().error(e.getMessage(), e);
			}
		}
		return result;
	}

	/**
	 * Set isAsync value to true for CORBAInterfaces if there exist a port with
	 * isAsync set to true and using this interface
	 * 
	 * @param model
	 */
	private static void setAsynchronousInterface(Model model) {
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, CCMNames.INTERFACE_PORT)) {
				boolean isAsync = (Boolean) ZDLUtil.getValue(next,
						CCMNames.INTERFACE_PORT,
						CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS);
				if (isAsync) {
					EObject type = ZDLUtil.getEValue(next,
							CCMNames.INTERFACE_PORT, ZMLMMNames.PORT__PORTTYPE);
					if (type != null) {
						if (ZDLUtil.isZDLConcept(type,
								CORBADomainNames.CORBAINTERFACE)) {
							ZDLUtil.setValue(
									type,
									CORBADomainNames.CORBAINTERFACE,
									CORBADomainNames.CORBAINTERFACE__IS_ASYNCHRONOUS,
									true);
						}
					}
				}
			}
			if (!(next instanceof Package) && !(next instanceof Component)) {
				itor.prune();
			}
		}
	}

	public static void repairAllWorkerfunctions(Package model) {
		final Set<Component> componentsToRepair = new HashSet<Component>();
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
				componentsToRepair.add((Component) next);
			}
			if (!(next instanceof Package)) {
				itor.prune();
			}
		}
		WorkerFunctionRepair wfr = new WorkerFunctionRepair();
		wfr.repair(componentsToRepair);
	}

	private static int migrateWorkerFunction(Model model) {
		int count = 0;
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, ZMLMMNames.WORKER_FUNCTION)) {
				Object uuid = ZDLUtil.getValue(next,
						ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__UUID);
				if (uuid == null || UML2Util.isEmpty(uuid.toString())) {
					ZDLUtil.setValue(next, ZMLMMNames.WORKER_FUNCTION,
							ZMLMMNames.WORKER_FUNCTION__UUID, UUID.randomUUID()
									.toString());
					count++;
				}
			}
			if (!(next instanceof Package)
					&& !ZDLUtil
							.isZDLConcept(next, CORBADomainNames.CORBAMODULE)
					&& !ZDLUtil.isZDLConcept(next,
							CCMNames.MONOLITHIC_IMPLEMENTATION)) {
				itor.prune();
			}
		}

		return count;
	}
	
	private static void addPortsToDeployment(Model model) {
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, CCMNames.DEPLOYMENT_PLAN)) {
				List<Property> ownedParts = new ArrayList<Property>();
				Collection<Property> allParts = ZDeploymentUtil.getDeploymentParts((Component) next);
				ownedParts.addAll(allParts);

				for (Property part : ownedParts) {
					if (ZDLUtil.isZDLConcept(part,
							ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
						EObject modelElement = ZDLUtil.getEValue(part,
								ZMLMMNames.COMPONENT_DEPLOYMENT_PART,
								ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
						if (modelElement != null
								&& ZDLUtil.isZDLConcept(modelElement,
										ZMLMMNames.PART)) {
							Component ccmComp = (Component) ZDLUtil.getValue(
									modelElement, ZMLMMNames.PART,
									ZMLMMNames.PART__DEFINITION);
							if (ZDLUtil.isZDLConcept(ccmComp,
									CCMNames.CCMCOMPONENT)) {
								@SuppressWarnings("unchecked")
								List<Port> ownedPorts = (List<Port>) ZDLUtil
										.getValue(
												ccmComp,
												ZMLMMNames.COMPONENT_INTERFACE,
												ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);
								for (Port port : ownedPorts) {
									String perPortName = NamingUtil
											.generateUniqueName(port.getName(),
													allParts);
									Property perportDeploymentPart = IDL3PlusUtil
											.createPerPortDeploymentPart(port,
													perPortName,
													((Component) next));
									ZDeploymentUtil.setParentPart(
											perportDeploymentPart, part);
									allParts.add(perportDeploymentPart);
								}
							}
						}
					}
				}
			} else if (!(next instanceof Package)) {
				itor.prune();
			}
		}
	}

	public static boolean migrateAll(Model model) {
		return migrateAll(model, false);
	}

	public static boolean isMigrationRequired(Model model) {

		return migrateAll(model, true);
	}

	/**
	 * Compare two versions
	 * 
	 * @param version1
	 * @param version2
	 * @return 1 if version1 is greater, 0 if they are equal, -1 if version2 is
	 *         greater
	 */
	public static int compareVersion(String version1, String version2) {
		if (UML2Util.isEmpty(version1) || UML2Util.isEmpty(version2)) {
			throw new IllegalArgumentException();
		}
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		for (int i = 0; i < (ver1.length > ver2.length ? ver1.length
				: ver2.length); i++) {
			if (ver1.length <= i) {
				return 1;
			} else if (ver2.length <= i) {
				return -1;
			}

			if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])) {
				return 1;
			} else if (Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])) {
				return -1;
			}
		}
		return 0;
	}

	private static String getModelVersion(final Model model) {
		EAnnotation anno = model.getEAnnotation(SOURCE_NAME);
		if (anno == null) {
			return "0.0.0";
		}
		return anno.getDetails().get("version"); //$NON-NLS-1$
	}

	/**
	 * Add the migration annotation to the model
	 * 
	 * @param model
	 *            Model that has been migrated
	 * @return
	 * @throws Exception
	 */
	public static void addMigrationAnnotation(final Model model,
			final String toVersion) throws Exception {
		ICommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(model), "Add version", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				// add migration info to model
				EAnnotation anno = model.getEAnnotation(SOURCE_NAME);
				if (anno == null) {
					anno = model.createEAnnotation(SOURCE_NAME);
				}
				anno.getDetails().put("version", toVersion); //$NON-NLS-1$
				Date date = new Date();
				anno.getDetails().put("date", //$NON-NLS-1$
						UML2Util.EMPTY_STRING + date.getTime());
				return CommandResult.newOKCommandResult();
			}
		};
		command.execute(null, null);
	}

}
