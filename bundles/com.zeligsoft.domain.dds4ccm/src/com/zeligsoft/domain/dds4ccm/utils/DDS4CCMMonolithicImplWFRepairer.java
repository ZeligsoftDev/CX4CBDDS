/*
 * Copyright 2019 ADLINK Technology Limited.
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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.MonolithicImplementation;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunction;
import com.zeligsoft.domain.zml.util.WorkerFunctionRepairTrigger;

/**
 * Maintain worker function UUIDs when MonolithicImplementations are copied
 *
 *
 */
public class DDS4CCMMonolithicImplWFRepairer extends
		WorkerFunctionRepairTrigger implements ResourceSetListener {

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		componentsToRepair.clear(); // ensure inherited repair list is cleared.

		CompoundCommand cc = new CompoundCommand("WorkerFunctionRepair"); //$NON-NLS-1$

		Set<EObject> addedObjects = getAddedObjects(event);

		final Set<MonolithicImplementation> addedImpls = new HashSet<MonolithicImplementation>();
		collectMonolithicImplementations(addedImpls, addedObjects);
		for (final MonolithicImplementation monolithicImplementation : addedImpls) {
			cc.append(new RecordingCommand(event.getEditingDomain()) {

				@Override
				protected void doExecute() {
					for (WorkerFunction workerFunction : monolithicImplementation.getWorker()) {
						workerFunction.setUuid(UUID.randomUUID().toString());
					}
				}
			});
		}

		if (cc.canExecute()) {
			return cc.unwrap();
		}
		return null;
	}

	private void collectMonolithicImplementations(
			final Set<MonolithicImplementation> addedImpls, final Collection<? extends EObject> addedObjects) {
		for (EObject eObject : addedObjects) {
			if (MonolithicImplementation.type.apply(eObject)) {
				MonolithicImplementation monoImpl = ZDLFactoryRegistry.INSTANCE.create(eObject, MonolithicImplementation.class);
				addedImpls.add(monoImpl);
			} else if (eObject instanceof org.eclipse.uml2.uml.Package) {
				final org.eclipse.uml2.uml.Package pkg = (org.eclipse.uml2.uml.Package) eObject;
				collectMonolithicImplementations(addedImpls, pkg.getPackagedElements());
			}
		}

	}
}
