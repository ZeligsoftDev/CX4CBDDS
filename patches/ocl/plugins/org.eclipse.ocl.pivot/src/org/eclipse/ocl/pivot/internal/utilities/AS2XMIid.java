/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.TreeIterable;

@Deprecated /* @deprecated only used to generate legacy Model.xmiidVersion 0 xmiids */
public class AS2XMIid
{
	/**
	 * Aggregated Diagnostic added to ASResource.errors if xmi:id assignment has to allocate
	 * an unstable random uuid to avoid a duplicate stable id.
	 */
	public static final class UnstableXMIidDiagnostics implements Resource.Diagnostic
	{
		protected final @NonNull String message;

		public UnstableXMIidDiagnostics(@NonNull String message) {
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message.replace("\n",  "\\n");
		}

		@Override
		public String getLocation() {
			return null;
		}

		@Override
		public int getLine() {
			return 0;
		}

		@Override
		public int getColumn() {
			return 0;
		}

		@Override
		public String toString() {
			return message;
		}
	}

	/**
	 * Create an AS2ID conversion primed with the xmi:id values obtained by loading uri.
	 */
	@Deprecated /* @deprecated no longer used */
	public static @NonNull AS2XMIid load(@NonNull URI uri) {
		return new AS2XMIid();
	}

	@Deprecated /* @deprecated no longer used */
	protected final @NonNull Map<@NonNull String, @NonNull String> moniker2id = Collections.emptyMap();

	public AS2XMIid() {}

	protected AS2XMIid(@NonNull Map<@NonNull String, @NonNull String> moniker2id) {
	}

	/**
	 * Assign xmi:id values to referenceable elements in asResource re-using the xmi:id
	 * values read when this AS2ID was constructed.
	 */
	public void assignIds(@NonNull ASResource asResource, @Nullable Map<@NonNull String, @Nullable Object> options) {
		StringBuilder s = null;
		Map<@NonNull String, @NonNull EObject> allIds = new HashMap<>();
		ASResourceFactory resourceFactory = asResource.getASResourceFactory();
		Object optionInternalUUIDs = options != null ? options.get(ASResource.OPTION_INTERNAL_UUIDS) : null;
		boolean internalUUIDs = (optionInternalUUIDs != null) && Boolean.valueOf(optionInternalUUIDs.toString());
		for (EObject eObject : new TreeIterable(asResource)) {
			if (eObject instanceof Element) {
				Element element = (Element)eObject;
				AS2XMIidVisitor idVisitor = resourceFactory.createAS2XMIidVisitor(this);
				String idOld = asResource.getID(element);
				String idAuto = idVisitor.getID(element, internalUUIDs);
				String idNew = idOld != null ? idOld : idAuto;
				if (idNew != null) {
					EObject oldElement = allIds.get(idNew);
					boolean badId = (idNew.length() <= 0) || (oldElement != null);
					boolean changedId = (idAuto != null) && !idNew.equals(idAuto);
					if (badId) {
						idNew = EcoreUtil.generateUUID();
					}
					else if (changedId) {
						idNew = idAuto;
					}
					assert idNew != null;
					if (badId || changedId) {
						if (s == null) {
							s = new StringBuilder();
						}
						s.append("\n " + element.eClass().getName() + " '" + idAuto + "'");
					}
					assert element != null;
					allIds.put(idNew, element);
					if (idNew != idOld) {
						asResource.setID(element, idNew);
					}
				}
			}
		}
		if (s != null) {
			String message = StringUtil.bind(PivotMessagesInternal.UnstableXMIid_ERROR_, s.toString());
			asResource.getErrors().add(new UnstableXMIidDiagnostics(message));
		}
	}

	/**
	 * Assign xmi:id values to referenceable elements in asResourceSet re-using the xmi:id
	 * values read when this AS2ID was constructed.
	 */
	public void assignIds(@NonNull ResourceSet asResourceSet, @Nullable Map<@NonNull String, @Nullable Object> options) {
		EcoreUtil.resolveAll(asResourceSet);		// Pending a fix to BUG 451928 this may provoke  CME unless all resources already loaded
		for (@NonNull Resource resource : asResourceSet.getResources()) {
			if (resource instanceof ASResource) {
				assignIds((ASResource)resource, options);
			}
		}
		EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
		if (environmentFactory != null) {
			environmentFactory.getMetamodelManager().assignLibraryIds(this, options);
		}
	}

	public String getID(@NonNull Element element, boolean internalUUIDs) {
		String moniker = AS2Moniker.toString(element);
		String id = moniker2id.get(moniker);
		if ((id == null) && internalUUIDs) {
			id = EcoreUtil.generateUUID();
			//			System.out.println(id + " for " + element + " " + ClassUtil.debugSimpleName(element));
		}
		return id;
	}
}
