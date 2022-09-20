/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.internal.emf.readonly;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.ui.internal.emf.readonly.handlers.ReferencedModelReadOnlyHandler;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Package;

import com.google.common.base.Optional;
import com.zeligsoft.base.util.BaseUtil;

/**
 * Overriding the default reference read only handler
 * 
 * @author Young-Soo Roh
 *
 */
@SuppressWarnings("restriction")
public class DynamicPathampModelReadOnlyHandler extends ReferencedModelReadOnlyHandler {

	/**
	 * @param editingDomain
	 */
	public DynamicPathampModelReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}

	@Override
	protected boolean isNotModelSetMainModel(URI uri) {
		boolean result = false;

		ResourceSet rset = getEditingDomain().getResourceSet();
		if (rset instanceof ModelSet) {
			ModelSet modelSet = (ModelSet) rset;
			URIConverter uriConverter = modelSet.getURIConverter();
			Set<URI> rootURIs = resolveRootResourceURIs(modelSet, uri);
			Set<URI> normalizedRootURIs = new LinkedHashSet<URI>();
			for (URI rootURI : rootURIs) {
				normalizedRootURIs.add(uriConverter.normalize(rootURI));
			}

			if (!normalizedRootURIs.isEmpty()) {
				URI next = normalizedRootURIs.iterator().next();
				result = modelSet.isUserModelResource(next)
						&& !normalizedRootURIs.contains(modelSet.getURIWithoutExtension());
			}
		}

		return result;

	}

	@Override
	public boolean isInteractive() {
		return false;
	}

	/**
	 * Queries if the given URI is the read-only pathmapped resource
	 * 
	 * @param uri
	 * @return
	 */
	private boolean isReadOnly(URI uri) {
		ResourceSet rset = getEditingDomain().getResourceSet();
		if (BaseUtil.UML_MODEL_EXTENSION.equals(uri.fileExtension()) && rset instanceof ModelSet) {
			ModelSet modelSet = (ModelSet) rset;
			UmlModel openedModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
			EObject root = null;
			if (openedModel != null) {
				try {
					root = openedModel.lookupRoot();
				} catch (NotFoundException e) {
					return false;
				}
			}
			Resource resource = modelSet.getResource(uri, true);
			if (resource != root.eResource() && !resource.getContents().isEmpty()
					&& resource.getContents().get(0) instanceof Package) {
				Package pkg = (Package) resource.getContents().get(0);
				String readOnly = BaseUtil.getZCXAnnotationDetail(pkg, BaseUtil.ZCX_MODEL_LIBRARY_KEY,
						Boolean.toString(false));
				if (Boolean.valueOf(readOnly)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {

		Optional<Boolean> result = super.canMakeWritable(axes, uris);
		if (result.or(false)) {
			for (int i = 0; i < uris.length; i++) {
				URI next = uris[i].trimFragment();
				if (isReadOnly(next)) {
					result = Optional.of(false);
					break;
				}
			}
		}
		return result;
	}
}
