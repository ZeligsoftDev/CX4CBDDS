/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
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
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationApprover2;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;

import com.google.common.base.Optional;

public class ReadOnlyOneFileApprover implements IOperationApprover2 {

	@Override
	public IStatus proceedRedoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
		return proceedExecuting(operation, history, info);
	}

	@Override
	public IStatus proceedUndoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
		return proceedExecuting(operation, history, info);
	}

	@Override
	public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
		HashSet<URI> filesToCheckForLock = new HashSet<URI>();

		Set<IFile> affectedFiles = getAffectedFiles(operation);

		if (!affectedFiles.isEmpty()) {
			for (IFile affectedFile : affectedFiles) {
				if (affectedFile == null) {
					continue;
				}

				if (affectedFile.exists()) {
					// the file is in the workspace
					IPapyrusFile papFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(affectedFile);
					for (IFile f : OneFileUtils.getAssociatedFiles(papFile)) {
						filesToCheckForLock.add(URI.createPlatformResourceURI(f.getFullPath().toString(), true));
					}
				} else {
					// the file is not in the workspace
					IPath path = affectedFile.getRawLocation();
					if (path == null) {
						// cancel if we can't find the file
						if (operation instanceof ICommand) {
							setCommandResult((ICommand) operation, Status.CANCEL_STATUS);
						}
						return Status.CANCEL_STATUS;
					}
					File file = path.toFile();
					if (file != null && file.exists() && !file.canWrite()) {
						// cancel if we find a read-only file outside the
						// workspace
						if (operation instanceof ICommand) {
							setCommandResult((ICommand) operation, Status.CANCEL_STATUS);
						}
						return Status.CANCEL_STATUS;
					}
				}
			}
		}

		EditingDomain editingDomain = getEditingDomain(operation);

		URI[] filesToCheckForLockArray = filesToCheckForLock.toArray(new URI[filesToCheckForLock.size()]);
		IReadOnlyHandler2 roHandler = ReadOnlyManager.getReadOnlyHandler(editingDomain);
		if (roHandler.anyReadOnly(ReadOnlyAxis.anyAxis(), filesToCheckForLockArray).get()) {
			Optional<Boolean> ok = roHandler.makeWritable(ReadOnlyAxis.anyAxis(), filesToCheckForLockArray);
			if (!ok.get()) {
				return Status.CANCEL_STATUS;
			}
		}

		return Status.OK_STATUS;
	}

	protected EditingDomain getEditingDomain(IUndoableOperation command) {
		EditingDomain editingDomain = null;
		if (command instanceof AbstractEMFOperation) {
			editingDomain = ((AbstractEMFOperation) command).getEditingDomain();
		}

		if (editingDomain == null && command instanceof ICompositeCommand) {
			Iterator<?> it = ((ICompositeCommand) command).iterator();
			while (editingDomain == null && it.hasNext()) {
				IUndoableOperation c = (IUndoableOperation) it.next();
				editingDomain = getEditingDomain(c);
			}
		}
		return editingDomain;
	}

	/**
	 * Sets the command result of the specified command to a CommandResult
	 * having the specified status.
	 *
	 * @param command
	 *            ICommand to set the CommandResult for
	 * @param status
	 *            IStatus of the CommandResult that will be set on the
	 *            command
	 */
	@SuppressWarnings("restriction")
	protected void setCommandResult(ICommand command, IStatus status) {
		if (command instanceof org.eclipse.gmf.runtime.common.core.internal.command.ICommandWithSettableResult) {
			((org.eclipse.gmf.runtime.common.core.internal.command.ICommandWithSettableResult) command).internalSetResult(new CommandResult(status));
		}
	}

	protected Set<IFile> getAffectedFiles(IUndoableOperation operation) {
		Set<IFile> result = getAffectedFiles(operation, null);
		return (result == null) ? Collections.<IFile> emptySet() : result;
	}

	protected Set<IFile> getAffectedFiles(IUndoableOperation operation, Set<IFile> result) {
		if (operation instanceof ICommand) {
			@SuppressWarnings("unchecked")
			Collection<IFile> files = ((ICommand) operation).getAffectedFiles();
			result = appendFiles(result, files);
		} else if (operation instanceof GMFtoEMFCommandWrapper) {
			result = getAffectedFiles(((GMFtoEMFCommandWrapper) operation).getGMFCommand(), result);
		} else if (operation instanceof EMFCommandOperation) {
			result = getAffectedFiles(((EMFCommandOperation) operation).getCommand(), result);
		}

		return result;
	}

	private Set<IFile> appendFiles(Set<IFile> result, Collection<IFile> files) {
		if ((files != null) && !files.isEmpty()) {
			if (result == null) {
				result = new HashSet<IFile>(files);
			} else {
				result.addAll(files);
			}
		}
		return result;
	}

	/**
	 * Dig into an EMF command to find wrapped GMF commands and get their affected files. As commands are generally provided by GMF edit-helpers, this
	 * should turn up useful results.
	 *
	 * @param command
	 *            a command to mine for affected files
	 * @param result
	 *            an accumulator of affected files
	 * @return the {@code result} if it already exists, a non-empty set containing affected files, or {@code null}
	 */
	protected Set<IFile> getAffectedFiles(Command command, Set<IFile> result) {
		if (command instanceof CompoundCommand) {
			for (Command next : ((CompoundCommand) command).getCommandList()) {
				// accumulate affected files
				result = getAffectedFiles(next, result);
			}
		} else if (command instanceof GMFtoEMFCommandWrapper) {
			result = getAffectedFiles(((GMFtoEMFCommandWrapper) command).getGMFCommand(), result);
		}

		return result;
	}
}
