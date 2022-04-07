/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IResourceUndoContextPolicy;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.papyrus.infra.core.resource.ITransactionalEditingDomainProvider;
import org.eclipse.papyrus.infra.emf.gmf.command.CheckedOperationHistory;
import org.eclipse.papyrus.infra.emf.gmf.command.NestingNotifyingWorkspaceCommandStack;
import org.eclipse.papyrus.infra.emf.gmf.command.NotifyingWorkspaceCommandStack;

/**
 * Editing Domain created using this provider will use handlers registered on readOnlyHandler extension
 * to determine if a resource is read only.
 *
 * @author mvelten
 *
 */
public class PapyrusROTransactionalEditingDomainProvider implements ITransactionalEditingDomainProvider {

	public TransactionalEditingDomain createTransactionalEditingDomain(ResourceSet resourceSet) {
		NotifyingWorkspaceCommandStack stack = new NestingNotifyingWorkspaceCommandStack(CheckedOperationHistory.getInstance());
		stack.setResourceUndoContextPolicy(IResourceUndoContextPolicy.DEFAULT);

		TransactionalEditingDomain result = new PapyrusROTransactionalEditingDomain(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack, resourceSet);

		WorkspaceEditingDomainFactory.INSTANCE.mapResourceSet(result);

		return result;
	}

}
