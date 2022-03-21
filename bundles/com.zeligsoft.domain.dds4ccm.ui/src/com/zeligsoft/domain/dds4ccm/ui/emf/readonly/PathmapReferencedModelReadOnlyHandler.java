/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.ui.emf.readonly;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.ui.internal.emf.readonly.handlers.ReferencedModelReadOnlyHandler;

/**
 * @author ernestoposse
 *
 */
public class PathmapReferencedModelReadOnlyHandler extends ReferencedModelReadOnlyHandler {

	/**
	 * @param editingDomain
	 */
	public PathmapReferencedModelReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
		// TODO Auto-generated constructor stub
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
}
