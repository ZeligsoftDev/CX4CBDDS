/*****************************************************************************
 * Copyright (c) 2011, 2015 Atos Origin, CEA, Christian W. Damus, and others.
 *
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
 *  Christian W. Damus (CEA) - Support object-level read/write controls (CDO)
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *  Christian W. Damus (CEA) - bug 422257
 *  Christian W. Damus (CEA) - bug 415639
 *  Christian W. Damus - bug 399859
 *  Christian W. Damus - bug 461629
 *  Christian W. Damus - bug 465416
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import static org.eclipse.papyrus.infra.core.utils.TransactionHelper.isInteractive;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.TransactionChangeRecorder;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.IRollbackStatus;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.core.resource.ResourceAdapter;
import org.eclipse.papyrus.infra.core.resource.RollbackStatus;
import org.eclipse.papyrus.infra.core.utils.TransactionHelper;
import org.eclipse.papyrus.infra.emf.edit.domain.PapyrusTransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.readonly.internal.ControlledResourceTracker;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;


public class PapyrusROTransactionalEditingDomain extends PapyrusTransactionalEditingDomain {

	public PapyrusROTransactionalEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack, ResourceSet resourceSet) {
		super(adapterFactory, stack, resourceSet);

		if (stack instanceof IWorkspaceCommandStack) {
			resourceSet.eAdapters().add(createResourceUndoContextHandler());
		}
	}

	@Override
	public boolean isReadOnly(Resource resource) {
		return isReadOnly(ReadOnlyAxis.anyAxis(), resource);
	}

	public boolean isReadOnly(EObject eObject) {
		return isReadOnly(ReadOnlyAxis.anyAxis(), eObject);
	}

	@Override
	protected TransactionChangeRecorder createChangeRecorder(ResourceSet rset) {
		// Ensure that the ControlledResourceTracker gets in ahead of the change recorder so that it processes
		// notifications pertaining to sub-model unit structure, first, to ensure correct determination of
		// read-only state for cross-model-referenced objects
		ControlledResourceTracker.getInstance(this);

		return doCreateChangeRecorder(rset);
	}

	protected TransactionChangeRecorder doCreateChangeRecorder(ResourceSet rset) {
		return new TransactionChangeRecorder(this, rset) {

			@Override
			protected void appendNotification(Notification notification) {
				// Append to the transaction first
				super.appendNotification(notification);

				if (!NotificationFilter.READ.matches(notification)) {
					// Check whether we are modifying a read-only object
					assertNotReadOnly(notification.getNotifier());
				} else {
					// Maybe we resolved a cross-resource containment proxy
					handleCrossResourceContainmentProxy(notification);
				}
			}
		};
	}

	protected void handleCrossResourceContainmentProxy(Notification notification) {
		// If it's not an EReference, then it's a feature-map EAttribute from an unknown-schema AnyType
		// and it won't contain cross-resource containment references (at least, not that we could tell)
		if ((notification.getEventType() == Notification.RESOLVE) && (notification.getFeature() instanceof EReference)) {
			EReference reference = (EReference) notification.getFeature();
			if (reference.isContainment()) {
				InternalEObject newValue = (InternalEObject) notification.getNewValue();
				if (newValue.eDirectResource() != null) {
					ControlledResourceTracker.getInstance(this).handleCrossResourceContainment(newValue);
				}
			}
		}
	}

	protected void assertNotReadOnly(Object object) {
		InternalTransaction tx = getActiveTransaction();

		// If there's no transaction, then there will be nothing to roll back. And if it's unprotected, let the client do whatever.
		// And, of course, don't interfere with rollback! Finally, if we're already going to roll back, don't bother
		if ((tx != null) && !tx.isRollingBack() //
				&& !Boolean.TRUE.equals(tx.getOptions().get(Transaction.OPTION_UNPROTECTED)) //
				&& !willRollBack(tx)) {

			final Set<ReadOnlyAxis> axes = TransactionHelper.getReadOnlyAxisOption(tx);
			boolean readOnly;

			// Check for Resource first because CDO resources *are* EObjects
			if (object instanceof Resource) {
				Resource.Internal resource = (Resource.Internal) object;
				if (resource.isLoading()) {
					// We must be able to modify read-only resources in order to load them
					return;
				}
				// If it's not an interactive transaction, don't try to make the resource writable because that would prompt the user
				readOnly = isReadOnly(axes, resource) && !(isInteractive(tx) && makeWritable(axes, resource));
			} else if (object instanceof EObject) {
				EObject eObject = (EObject) object;
				// If it's not an interactive transaction, don't try to make the object writable because that would prompt the user
				readOnly = isReadOnly(axes, eObject) && !(isInteractive(tx) && makeWritable(axes, eObject));
			} else {
				// If it's not an EMF-managed object, we don't care
				readOnly = false;
			}

			if (readOnly) {
				String message = "Attempt to modify object(s) in a read-only model."; //$NON-NLS-1$
				Collection<?> offenders = Collections.singleton(object);
				tx.abort(new RollbackStatus(Activator.PLUGIN_ID, IRollbackStatus.READ_ONLY_OBJECT, message, offenders));
			}
		}
	}

	private boolean willRollBack(Transaction tx) {
		IStatus status = tx.getStatus();
		return (status != null) && (status.getSeverity() >= IStatus.ERROR);
	}

	protected boolean isReadOnly(Set<ReadOnlyAxis> axes, Resource resource) {
		if ((resource != null) && (resource.getURI() != null)) {
			return ReadOnlyManager.getReadOnlyHandler(this).anyReadOnly(axes, new URI[] { resource.getURI() }).get();
		}
		return false;
	}

	protected boolean isReadOnly(Set<ReadOnlyAxis> axes, EObject eObject) {
		return ReadOnlyManager.getReadOnlyHandler(this).isReadOnly(axes, eObject).get();
	}

	protected boolean makeWritable(Set<ReadOnlyAxis> axes, Resource resource) {
		URI[] uris = getCompositeModelURIs(resource.getURI());
		IReadOnlyHandler2 handler = ReadOnlyManager.getReadOnlyHandler(this);

		if (!handler.canMakeWritable(axes, uris).or(false)) {
			return false;
		}

		return handler.makeWritable(axes, uris).get();
	}

	protected boolean makeWritable(Set<ReadOnlyAxis> axes, EObject object) {
		boolean result;

		IReadOnlyHandler2 handler = ReadOnlyManager.getReadOnlyHandler(this);

		if (!handler.canMakeWritable(axes, object).or(false)) {
			result = false;
		} else {
			result = handler.makeWritable(axes, object).get();
		}

		return result;
	}

	/**
	 * Obtains the complete set of URIs for members of the composite model resource of which the given URI is one member.
	 *
	 * @param memberURI
	 *            a member of a composite Papyrus model
	 *
	 * @return the complete set of member resources (which could just be the original {@code memberURI})
	 */
	protected URI[] getCompositeModelURIs(URI memberURI) {
		URI[] result = null;

		if (memberURI.isPlatformResource()) {
			// We don't have object-level read-only state in the workspace (perhaps in CDO repositories)
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(memberURI.trimFragment().toPlatformString(true)));
			if ((file != null) && file.exists()) {
				IPapyrusFile composite = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(file);
				Set<URI> memberURIs = new HashSet<URI>();
				for (IFile member : OneFileUtils.getAssociatedFiles(composite)) {
					memberURIs.add(URI.createPlatformResourceURI(member.getFullPath().toString(), true));
				}
				result = memberURIs.toArray(new URI[memberURIs.size()]);
			}
		}

		if (result == null) {
			result = new URI[] { memberURI };
		}

		return result;
	}

	@Override
	public void dispose() {
		try {
			super.dispose();
		} finally {
			resourceSet = null;
			adapterFactory = null;
			ReadOnlyManager.roHandlers.remove(this);
		}
	}

	/**
	 * Overrides the inherited method to support an {@linkplain TransactionHelper#TRANSACTION_OPTION_MERGE_NESTED_READ option} to merge nested read-only transactions into parent write transactions.
	 */
	@Override
	public Object runExclusive(Runnable read) throws InterruptedException {

		Transaction active = getActiveTransaction();
		Transaction tx = null;

		if ((active == null) || !(active.isActive() && isReadOnlyCompatible(active))) {
			// only need to start a new transaction if we don't already have
			// exclusive read-only access
			tx = startTransaction(true, null);
		}

		final RunnableWithResult<?> rwr = (read instanceof RunnableWithResult) ? (RunnableWithResult<?>) read : null;

		try {
			read.run();
		} finally {
			if ((tx != null) && (tx.isActive())) {
				// commit the transaction now
				try {
					tx.commit();

					if (rwr != null) {
						rwr.setStatus(Status.OK_STATUS);
					}
				} catch (RollbackException e) {
					Activator.log.error("Read-only transaction was rolled back.", e); //$NON-NLS-1$

					if (rwr != null) {
						rwr.setStatus(e.getStatus());
					}
				}
			}
		}

		return (rwr != null) ? rwr.getResult() : null;
	}

	private boolean isReadOnlyCompatible(Transaction parentTransaction) {
		return (parentTransaction.isReadOnly() || TransactionHelper.isMergeReadOnly(parentTransaction))
				&& (parentTransaction.getOwner() == Thread.currentThread());
	}

	protected Adapter createResourceUndoContextHandler() {
		return new ResourceUndoContextHandler(getCommandStack());
	}

	//
	// Nested types
	//

	protected class ResourceUndoContextHandler extends ResourceAdapter {

		private final IOperationHistory history;

		protected ResourceUndoContextHandler(CommandStack stack) {
			super();

			history = ((IWorkspaceCommandStack) stack).getOperationHistory();
		}

		@Override
		protected void handleResourceUnloaded(Resource resource) {
			// Purge the resource undo context
			IUndoContext resourceContext = new ResourceUndoContext(PapyrusROTransactionalEditingDomain.this, resource);
			history.dispose(resourceContext, true, true, true);
		}
	}
}
