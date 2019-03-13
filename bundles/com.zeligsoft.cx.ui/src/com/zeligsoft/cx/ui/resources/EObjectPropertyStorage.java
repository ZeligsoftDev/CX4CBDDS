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

package com.zeligsoft.cx.ui.resources;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * EOjbect property storage for ZDL Concept
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public class EObjectPropertyStorage
		implements IStorage {

	// URI of the EObject
	private URI uri;

	// EObject of the domain concept
	private EObject context;

	// ZDL Concept
	private org.eclipse.uml2.uml.Class concept;

	// ZDL Concept property
	private String property;

	/**
	 * Creates a storage object for the property of ZDL Concept of the EObject
	 * 
	 * @param context
	 *            EObject of ZDL domain concept
	 * @param concept
	 *            qualified name for ZDL domain concept
	 * @param property
	 *            property of the ZDL concept
	 */
	public EObjectPropertyStorage(EObject context, String concept,
			String property) {
		this(context, ZDLUtil.getZDLConcept(context, concept), property);
	}

	/**
	 * Creates a storage object for the property of ZDL Concept of the EObject
	 * 
	 * @param context
	 *            EObject of ZDL domain concept
	 * @param concept
	 *            ZDL domain concept
	 * @param property
	 *            property of the ZDL concept
	 */
	public EObjectPropertyStorage(EObject context,
			org.eclipse.uml2.uml.Class concept, String property) {
		super();
		this.context = context;
		this.concept = concept;
		this.property = property;
		uri = EcoreUtil.getURI(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IStorage#getContents()
	 */
	@Override
	public InputStream getContents()
			throws CoreException {
		InputStream is = null;
		String tempString = null;

		try {
			tempString = (String) ZDLUtil.getValue(context, concept, property);
		} catch (IllegalArgumentException e) {
			throw new CoreException(
				new Status(IStatus.ERROR, ZeligsoftCXUIPlugin.PLUGIN_ID,
					IStatus.ERROR, e.getMessage(), e));
		}

		if (tempString == null) {
			tempString = ""; //$NON-NLS-1$
		}

		try {
			is = new ByteArrayInputStream(tempString
				.getBytes(((XMLResource) context.eResource()).getEncoding()));
		} catch (UnsupportedEncodingException e) {
			throw new CoreException(
				new Status(IStatus.ERROR, ZeligsoftCXUIPlugin.PLUGIN_ID,
					IStatus.ERROR, e.getMessage(), e));
		}

		return is;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IStorage#getFullPath()
	 */
	@Override
	public IPath getFullPath() {
		return new Path(EMFCoreUtil.getQualifiedName(context, true)
			+ NamedElement.SEPARATOR + property);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IStorage#getName()
	 */
	@Override
	public String getName() {
		return EMFCoreUtil.getName(context) + NamedElement.SEPARATOR + property;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IStorage#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return null;
	}

	/**
	 * Get URI for worker
	 * 
	 * @return URI of the worker
	 */
	public URI getUri() {
		return uri;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof EObjectPropertyStorage) {
			EObjectPropertyStorage storage = (EObjectPropertyStorage) o;
			return (storage.getUri().equals(uri)
				&& storage.getConcept() == concept && storage.getProperty()
				.equals(property));
		}
		return false;
	}

	@Override
	public int hashCode() {

		if (context != null) {
			return context.hashCode();
		}
		return 0;
	}

	/**
	 * Returns property
	 * 
	 * @return
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * Returns concept
	 * 
	 * @return
	 */
	public org.eclipse.uml2.uml.Class getConcept() {
		return concept;
	}

	/**
	 * Return context
	 * 
	 * @return
	 */
	public EObject getContext() {
		return context;
	}

	/**
	 * Set new value for this worker code
	 * 
	 * @param value
	 */
	public void setValue(final String value) {
		if (context != null && concept != null && property != null) {
			try {
				OperationHistoryFactory.getOperationHistory().execute(
					new AbstractTransactionalCommand(TransactionUtil
						.getEditingDomain(context),
						Messages.EObjectPropertyStorage_SaveCommandLabel,
						Collections.EMPTY_MAP, null) {

						@Override
						protected CommandResult doExecuteWithResult(
								IProgressMonitor monitor, IAdaptable info)
								throws ExecutionException {

							ZDLUtil.setValue(context, concept, property, value);

							return CommandResult.newOKCommandResult();
						}

					}, null, null);
			} catch (ExecutionException e) {
				ZeligsoftCXUIPlugin.getDefault().error(
					Messages.EObjectPropertyStorage_SaveFailedLog, e);
			}
		}
	}
}
