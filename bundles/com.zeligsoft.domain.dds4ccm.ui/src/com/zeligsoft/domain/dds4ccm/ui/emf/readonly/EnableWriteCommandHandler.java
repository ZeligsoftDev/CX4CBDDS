package com.zeligsoft.domain.dds4ccm.ui.emf.readonly;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;

public class EnableWriteCommandHandler
		extends org.eclipse.papyrus.infra.ui.internal.emf.readonly.handlers.EnableWriteCommandHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject elem = getSelectedElement();
		if (elem != null && elem.eResource() != null && elem.eResource().getResourceSet() != null) {
			Resource res = elem.eResource();
			ResourceSet rs = res.getResourceSet();
			URIConverter uriConverter = rs.getURIConverter();
			URI uri = res.getURI();
			if (uri != null) {
				URI normalizedURI = uriConverter.normalize(uri);
				if (normalizedURI.isPlatformResource()) {
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(normalizedURI.toPlatformString(true)));
					IPapyrusFile papFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(file);
					IFile[] associatedFiles = OneFileUtils.getAssociatedFiles(papFile);

					URI[] associatedUris = new URI[associatedFiles.length];
					for (int i = 0; i < associatedFiles.length; i++) {
						associatedUris[i] = URI.createPlatformResourceURI(associatedFiles[i].getFullPath().toString(), true);
					}

					ReadOnlyManager.getReadOnlyHandler(WorkspaceEditingDomainFactory.INSTANCE.getEditingDomain(rs)).makeWritable(ReadOnlyAxis.anyAxis(), associatedUris);
				}
			}

		}
		return null;
	}

}
