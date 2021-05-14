package com.zeligsoft.cx.ui.pathmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;

public class CXDynamicURIConverter {

	public static Map<URI, CXPathmapDescriptor> PATHMAPS = new HashMap<URI, CXPathmapDescriptor>();

	private CXDynamicURIConverter() {

	};

	public static CXPathmapDescriptor getPathmapDescriptor(URI uri) {
		return PATHMAPS.get(uri);
	}

	public static CXPathmapDescriptor addMapping(URI pathmapUri, URI modelUri) {
		String modelName = modelUri.lastSegment();
		URI targetURI = modelUri.trimSegments(1).appendSegment(""); //$NON-NLS-1$

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
				// There is already registered pathmap to a different location
				// It means the model library is either moved or a new model library
				// is trying to register to the same pathmap URI
				List<String> bindings = new ArrayList<String>();
				bindings.add(desc.getPathmap().toString());
				bindings.add(desc.getMapping().toString());
				bindings.add(targetURI.toString());
				String msg = NLS.bind(Messages.CXDynamicURIConverter_ConflictErrorMessage, bindings.toArray());
				ZeligsoftCXUIPlugin.getDefault().warning(msg);
				Display display = PlatformUI.getWorkbench().getDisplay();
				if (display != null) {
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

						@Override
						public void run() {
							MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.CXDynamicURIConverter_ConflictDialogTitle, msg);
						}
					});
				}
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
		URI pathmapUri = getPathmapURI(modelUri).trimSegments(1).appendSegment(""); //$NON-NLS-1$
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
		URI targetUri = modelUri.trimSegments(1).appendSegment(""); //$NON-NLS-1$
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
