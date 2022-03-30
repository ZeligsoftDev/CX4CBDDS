package com.zeligsoft.cx.ui.pathmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * CX Dynamic Pathmap URI converter
 * 
 * @author Young-Soo Roh
 *
 */
public class CXDynamicURIConverter {

	public static Map<URI, CXPathmapDescriptor> PATHMAPS = new HashMap<URI, CXPathmapDescriptor>();

	private CXDynamicURIConverter() {

	};

	public static CXPathmapDescriptor getPathmapDescriptor(URI uri) {
		return PATHMAPS.get(uri);
	}
	
	private static boolean isLinked(IResource resource) {
		IResource r = resource;
		
		while(r != null && !(r instanceof IProject)) {
			if(r.isLinked()) {
				return true;
			}
			r = r.getParent();
		}
		return false;
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
			return desc;
		} else {
			if (desc != null) {
				
				// See if this is a link
				URI normalizedUri = URIConverter.INSTANCE.normalize(modelUri);
				String path = normalizedUri.toPlatformString(true);
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
				if(isLinked(file)) {
					// If this is a link and there is alreay a mapping, then ignore it
					return desc;
				}
				
				String mappedPath = desc.getMapping().toPlatformString(true);
				IResource folder = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(mappedPath));
				// Silently override mapping over linked resource.
				if (!isLinked(folder)) {
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
								MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
										Messages.CXDynamicURIConverter_ConflictDialogTitle, msg);
							}
						});
					}
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
	}

	public static URI getPathmapURI(URI modelUri) {
		URI targetUri = modelUri.trimSegments(1).appendSegment(""); //$NON-NLS-1$
		String modelName = modelUri.lastSegment();
		String umlModelName = modelUri.trimFileExtension().appendFileExtension("uml").lastSegment(); //$NON-NLS-1$
		for (Entry<URI, CXPathmapDescriptor> entry : CXDynamicURIConverter.PATHMAPS.entrySet()) {
			URI pathmapUri = entry.getKey();
			CXPathmapDescriptor desc = entry.getValue();
			if (targetUri.equals(desc.getMapping()) && desc.getRegisteredModels().contains(umlModelName)) {
				if (desc.isEnabled()) {
					URI result = URI.createURI(pathmapUri.toString() + modelName);
					return result;
				}
				break;
			}
		}
		return modelUri;
	}
	
	public static List<URI> getAssociatedUris(Resource resource) {
		List<URI> result = new ArrayList<URI>();
		if (resource != null && resource.getResourceSet() != null) {
			URIConverter uriConverter = resource.getResourceSet().getURIConverter();
			URI uri = resource.getURI();
			if (uri != null) {
				URI normalizedURI = uriConverter.normalize(uri);
				if (normalizedURI.isPlatformResource()) {
					IFile file = ResourcesPlugin.getWorkspace().getRoot()
							.getFile(new Path(normalizedURI.toPlatformString(true)));
					IPapyrusFile papFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(file);
					IFile[] associatedFiles = OneFileUtils.getAssociatedFiles(papFile);

					for (int i = 0; i < associatedFiles.length; i++) {
						URI tempUri = URI.createPlatformResourceURI(associatedFiles[i].getFullPath().toString(), true);
						result.add(getPathmapURI(tempUri));
					}
				}
			}
		}
		return result;
	}
}
