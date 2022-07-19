package com.zeligsoft.cx.ui.pathmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;
import org.eclipse.uml2.common.util.UML2Util;

/**
 * CX Dynamic Pathmap URI converter
 * 
 * @author Young-Soo Roh
 *
 */
public class CXDynamicURIConverter {

	public static Map<URI, List<CXPathmapDescriptor>> PATHMAPS = new HashMap<URI, List<CXPathmapDescriptor>>();

	private static Set<URI> conflictPathmaps = new HashSet<URI>();
	
	private static final Lock lock = new ReentrantLock();
	
	private CXDynamicURIConverter() {

	};

	/**
	 * Return all queued new conflict pathmaps
	 * 
	 * @return
	 */
	public static Set<URI> getNewConflictPathmaps() {
		Set<URI> results = new HashSet<URI>();
		lock.lock();
		try {
			results.addAll(conflictPathmaps);
		}finally {
			lock.unlock();
		}
		return results;
	}

	/**
	 * Queue new conflict pathmap
	 * 
	 * @param pathmap
	 */
	public static void addNewConflictPathmap(URI pathmap) {
		lock.lock();
		try {
			conflictPathmaps.add(pathmap);
		}finally {
			lock.unlock();
		}
	}
	
	public static void clearNewConflictPathmaps() {
		lock.lock();
		try {
			conflictPathmaps.clear();
		}finally {
			lock.unlock();
		}
	}
	
	
	/**
	 * Return active pathmap descriptor
	 * @param uri
	 * @return
	 */
	public static CXPathmapDescriptor getPathmapDescriptor(URI uri) {
		List<CXPathmapDescriptor> mappings = PATHMAPS.get(uri);
		if(mappings == null){
			return null;
		}
		List<CXPathmapDescriptor> enabledPathmap = mappings.stream().filter(p -> p.isEnabled()).collect(Collectors.toList());
		return enabledPathmap.isEmpty()? mappings.get(0): enabledPathmap.get(0);
	}
	
	/**
	 * Return all pathmap descriptors
	 * @param uri
	 * @return
	 */
	public static List<CXPathmapDescriptor> getPathmapDescriptors(URI uri){
		return PATHMAPS.get(uri);
	}
	
	/**
	 * Return all pathmaps
	 * @return
	 */
	public static List<CXPathmapDescriptor> getPathmaps() {

		List<CXPathmapDescriptor> result = new java.util.ArrayList<CXPathmapDescriptor>();
		for(URI uri: CXDynamicURIConverter.PATHMAPS.keySet()) {
			result.add(CXDynamicURIConverter.getPathmapDescriptor(uri));
		}
		return result;
	}
	
	/**
	 * Return all Pathmaps with multiple mappings
	 * @return
	 */
	public static Map<URI, List<CXPathmapDescriptor>> getConflictPathmaps() {
		Map<URI, List<CXPathmapDescriptor>> results = new HashMap<URI, List<CXPathmapDescriptor>>();
		for (java.util.Map.Entry<URI, List<CXPathmapDescriptor>> entry : PATHMAPS.entrySet()) {
			if (entry.getValue() != null && entry.getValue().size() > 1) {
				results.put(entry.getKey(), entry.getValue());
			}
		}
		return results;
	}
	
	/**
	 * Enable given pathmap mapping and disable other mappings
	 * 
	 * @param desc
	 */
	public static void enablePathmapMapping(CXPathmapDescriptor desc) {
		List<CXPathmapDescriptor> mappings = getPathmapDescriptors(desc.getPathmap());
		for (CXPathmapDescriptor mapping : mappings) {
			if (desc == mapping) {
				mapping.setEnabled(true);
				mapping.apply();
			} else {
				if (mapping.isEnabled()) {
					mapping.setEnabled(false);
					mapping.apply();
				}
			}
		}
	}
	
	public static List<CXPathmapDescriptor> getEnabledPathmaps() {
		
		List<CXPathmapDescriptor> pathmaps = getPathmaps();
		List<CXPathmapDescriptor> result = new java.util.ArrayList<CXPathmapDescriptor>(pathmaps.size());

		for (CXPathmapDescriptor next : pathmaps) {
			if (next.isEnabled()) {
				result.add(next);
			}
		}

		return result;
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

	public static synchronized CXPathmapDescriptor addMapping(URI pathmapUri, URI modelUri) {
		String modelName = modelUri.lastSegment();
		URI targetURI = modelUri.trimSegments(1).appendSegment(""); //$NON-NLS-1$

		CXPathmapDescriptor desc = getPathmapDescriptor(pathmapUri);
		
		if (desc != null && desc.getMapping().equals(targetURI)) {
			// same mapping exist possibly from different model
			// so add the model name to the existing descriptor
			if (!desc.getRegisteredModels().contains(modelName)) {
				desc.addRegisteredModel(modelName);
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
				
				String mappedPath = desc.getMapping().toString();
				IResource folder = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(mappedPath));
				// Silently override mapping over linked resource.
				if (isLinked(folder)) {
					// There is already registered pathmap to a different location
					// It means the model library is either moved or a new model library
					// is trying to register to the same pathmap URI
					// Remove existing mapping in this case.
					List<CXPathmapDescriptor> mappings = PATHMAPS.get(pathmapUri);
					mappings.remove(desc);
				}
			}
			desc = new CXPathmapDescriptor(pathmapUri, targetURI, modelName);
			if(!PATHMAPS.containsKey(pathmapUri)) {
				desc.setEnabled(true);
				desc.apply();
				PATHMAPS.put(pathmapUri, new ArrayList<CXPathmapDescriptor>());
			} else {
				// pathmap was enabled
				if(desc.isEnabled()) {
					for(CXPathmapDescriptor d: getPathmapDescriptors(desc.getPathmap())) {
						d.setEnabled(false);
						d.apply();
					}
				}
			}
			List<CXPathmapDescriptor> mappings = PATHMAPS.get(pathmapUri);
			mappings.add(desc);
		}
		return desc;
	}

	public static URI removeMapping(URI modelUri) {
		// Find possible entry from PATHMAP and remove it
		URI uri = URIConverter.INSTANCE.normalize(modelUri);
		String modelName = uri.lastSegment();
		URI targetURI = uri.trimSegments(1).appendSegment(UML2Util.EMPTY_STRING);
		URI pathmapURI = null;
		CXPathmapDescriptor desc = null;
		for (URI key : PATHMAPS.keySet()) {
			for (CXPathmapDescriptor d : getPathmapDescriptors(key)) {
				if (d.getMapping().equals(targetURI)) {
					desc = d;
					pathmapURI = key;
					break;
				}
			}
			if (desc != null) {
				break;
			}
		}
		if(desc == null) {
			return null;
		}
		if (desc.getRegisteredModels().contains(modelName)) {
			desc.getRegisteredModels().remove(modelName);
		}
		if (desc.getRegisteredModels().isEmpty()) {
			PATHMAPS.get(pathmapURI).remove(desc);
			if (desc.isEnabled()) {
				desc.setEnabled(false);
				desc.apply();
				
				// enable secondary pathmap
				if (!PATHMAPS.get(pathmapURI).isEmpty()) {
					desc = PATHMAPS.get(pathmapURI).get(0);
					desc.setEnabled(true);
					desc.apply();
				}
			}
			if (PATHMAPS.get(pathmapURI).isEmpty()) {
				PATHMAPS.remove(pathmapURI);
			}
		}
		return pathmapURI;
	}

	public static URI getPathmapURI(URI modelUri) {
		URI targetUri = modelUri.trimSegments(1).appendSegment(""); //$NON-NLS-1$
		String modelName = modelUri.lastSegment();
		String umlModelName = modelUri.trimFileExtension().appendFileExtension("uml").lastSegment(); //$NON-NLS-1$
		for (URI pathmapUri : CXDynamicURIConverter.PATHMAPS.keySet()) {
			CXPathmapDescriptor desc = CXDynamicURIConverter.getPathmapDescriptor(pathmapUri);
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
