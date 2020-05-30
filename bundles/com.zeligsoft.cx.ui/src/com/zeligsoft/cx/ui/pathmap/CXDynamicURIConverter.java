package com.zeligsoft.cx.ui.pathmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;

public class CXDynamicURIConverter {

	public static Map<URI, CXPathmapDescriptor> PATHMAPS = new HashMap<URI, CXPathmapDescriptor>();

	private CXDynamicURIConverter() {

	};

	public static CXPathmapDescriptor getPathmapDescriptor(URI uri) {
		return PATHMAPS.get(uri);
	}

	public static CXPathmapDescriptor addMapping(URI pathmapUri, URI targetURI, String modelName) {
		CXPathmapDescriptor desc = getPathmapDescriptor(pathmapUri);
		if (desc != null && desc.getMapping().equals(targetURI)) {
			// same mapping exist possibly from different model
			// so add the model name to the existing descriptor
			if (!desc.getRegisteredModels().contains(modelName)) {
				desc.addRegisteredModel(modelName);
				if (!desc.isEnabled()) {
					desc.setEnabled(true);
					desc.apply();
				}
			}
		} else {
			if (desc != null) {
				// The model is either moved or
				// pathmap is not unique in the workspace
				// so delete the existing one.
				desc.setEnabled(false);
				desc.apply();
				PATHMAPS.remove(pathmapUri);
			}
			desc = new CXPathmapDescriptor(pathmapUri, targetURI, modelName);
			desc.setEnabled(true);
			desc.apply();
			PATHMAPS.put(pathmapUri, desc);
		}
		return desc;
	}

	public static void removeMapping(URI modelUri) {
		URI pathmapUri = getPathmapURI(modelUri).trimSegments(1).appendSegment("");
		String modelName = modelUri.lastSegment();
		CXPathmapDescriptor desc = getPathmapDescriptor(pathmapUri);
		if (desc != null) {
			desc.removeRegisteredModel(modelName);
			if (desc.getRegisteredModels().isEmpty()) {
				// no more models registering pathmaps so remove it
				desc.setEnabled(false);
				desc.apply();
				PATHMAPS.remove(pathmapUri);
			}
		}
		return;
	}

	public static URI getPathmapURI(URI modelUri) {
		URI targetUri = modelUri.trimSegments(1).appendSegment("");
		String modelName = modelUri.lastSegment();
		for (Entry<URI, CXPathmapDescriptor> entry : PATHMAPS.entrySet()) {
			URI pathmapUri = entry.getKey();
			CXPathmapDescriptor desc = entry.getValue();
			if (targetUri.equals(desc.getMapping()) && desc.getRegisteredModels().contains(modelName)) {
				if (desc.isEnabled()) {
					return pathmapUri.appendSegment(modelName);
				}
				break;
			}
		}
		return modelUri;
	}
}
