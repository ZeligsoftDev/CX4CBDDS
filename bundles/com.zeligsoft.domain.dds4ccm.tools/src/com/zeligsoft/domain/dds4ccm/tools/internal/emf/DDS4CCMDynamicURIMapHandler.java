/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.internal.emf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.validation.ui.commands.ValidateCXModelCommand;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMDiagnostician;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;

/**
 * Dynamic URI mapping handler.
 * 
 * @author Young-Soo Roh
 *
 */
public final class DDS4CCMDynamicURIMapHandler {

	private static ResourceSet rset = new ResourceSetImpl();

	/**
	 * Initializes me.
	 */
	private DDS4CCMDynamicURIMapHandler() {
		super();
	}

	public static void remap() {
		new UIJob(Messages.DDS4CCMDynamicURIMapHandler_UpdateingWorkspaceUri) {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.addPartListener(new IPartListener2() {
					
					@Override
					public void partVisible(IWorkbenchPartReference partRef) {
					}
					@Override
					public void partOpened(IWorkbenchPartReference partRef) {
						checkEditorPart(partRef);
					}
					
					@Override
					public void partInputChanged(IWorkbenchPartReference partRef) {
					}
					
					@Override
					public void partHidden(IWorkbenchPartReference partRef) {
					}
					
					@Override
					public void partDeactivated(IWorkbenchPartReference partRef) {
					}
					
					@Override
					public void partClosed(IWorkbenchPartReference partRef) {
						
					}
					
					@Override
					public void partBroughtToTop(IWorkbenchPartReference partRef) {
					}
					
					@Override
					public void partActivated(IWorkbenchPartReference partRef) {
					}
				});
				
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IResourceChangeListener rcl = new IResourceChangeListener() {

					@Override
					public void resourceChanged(IResourceChangeEvent event) {
						IResourceDelta delta = event.getDelta();
						if (delta != null) {
							processDelta(rset, delta);
						}
					}
				};
				workspace.addResourceChangeListener(rcl);
				remapDynamicURI();
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	public static void remapDynamicURI() {
		for (Resource r : rset.getResources()) {
			// unload all models
			r.unload();
		}
		for (CXPathmapDescriptor desc : CXDynamicURIConverter.PATHMAPS.values()) {
			desc.setEnabled(false);
			desc.apply();
		}
		CXDynamicURIConverter.PATHMAPS.clear();
		visitAllModels(ResourcesPlugin.getWorkspace().getRoot(), uri -> processUML(uri));
	}

	private static void processDelta(ResourceSet rset, IResourceDelta delta) {
		IResourceDelta[] children = delta.getAffectedChildren();
		if (children.length == 0) {
			// check if this is a uml file
			IPath path = delta.getFullPath();
			String ext = path.getFileExtension();
			if (!UML2Util.isEmpty(ext) && "uml".equals(ext.toLowerCase())) { //$NON-NLS-1$
				try {
					URI uri = URI.createPlatformResourceURI(path.toString(), false);
					if (delta.getKind() == IResourceDelta.CHANGED || delta.getKind() == IResourceDelta.ADDED) {
						Resource r = rset.getResource(uri, false);
						if (r != null) {
							r.unload();
						}
						rset.getResource(uri, true);
					}
					if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.REMOVED) {
	
							processUML(uri, delta.getKind());
					}
				}catch (Exception e) {
					Activator.getDefault().error(e.getMessage(), e);
				}
			}

		} else {
			for (int i = 0; i < children.length; i++) {
				processDelta(rset, children[i]);
			}
		}
	}

	public static void processUML(URI uri) {
		processUML(uri, IResourceDelta.ADDED);
	}

	private static void processUML(URI uri, int deltaKind) {
		Package model = UML2Util.load(rset, uri, UMLPackage.Literals.PACKAGE);
		if (model == null || !ZDLUtil.isZDLProfile(model, "cxDDS4CCM")) { //$NON-NLS-1$
			return;
		}
		
		if (deltaKind == IResourceDelta.REMOVED) {
			URI pathmapUri = CXDynamicURIConverter.getPathmapURI(uri);
			if("pathmap".equals(pathmapUri.scheme())){ //$NON-NLS-1$
				// remove pathmap URI
				CXDynamicURIConverter.removeMapping(uri);
				// This is dynamic pathmap library
				// check dependent models
				try {
					checkDependentModels(uri);
				} catch (Exception e) {
					Activator.getDefault().error(e.getMessage(), e);
					// ignore to continue
				}
			}

			// unload deleted resource
			Resource r = rset.getResource(uri, false);
			if (r != null) {
				r.unload();
			}
		} else {
			// search dynamic pathmap
			String pathmap = CCMUtil.getZCXAnnotationDetail((Element) model, "pathmap", ""); //$NON-NLS-1$//$NON-NLS-2$
			if (!UML2Util.isEmpty(pathmap)) {
				URI pathmapUri = URI.createURI("pathmap" + "://" + pathmap + "/", true); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				CXDynamicURIConverter.addMapping(pathmapUri, uri);
			}
		}
	}

	/**
	 * Search dependent models referencing the given pathmap
	 * 
	 * @param uri
	 * @return
	 */
	static boolean checkDependentModels(URI targetUri) {
		final Set<URI> dependentModels = new HashSet<URI>();
		visitAllModels(ResourcesPlugin.getWorkspace().getRoot(),
				modelUri -> containsReferenceToPathmap(targetUri, modelUri, dependentModels));
		if (!dependentModels.isEmpty()) {
			// found dependent models so do something.
			StringBuffer sb = new StringBuffer();

			for (URI uri : dependentModels) {
				sb.append(uri.toString()).append(System.lineSeparator());
			}

			String warning = NLS.bind(Messages.DDS4CCMDynamicURIMapHandler_RemovingDynamicModelWarning,
					targetUri.toString(), sb.toString());

			Activator.getDefault().warning(sb.toString());
			Display display = PlatformUI.getWorkbench().getDisplay();
			if (display != null) {
				PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

					@Override
					public void run() {
						
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
								Messages.DDS4CCMDynamicURIMapHandler_WarningDialogTitle, warning);
						boolean shouldClose = false;
						if (shouldClose) {
							for (IEditorReference ref : PlatformUI.getWorkbench().getActiveWorkbenchWindow()
									.getActivePage().getEditorReferences()) {
								try {

									List<IEditorReference> editorsToClose = new ArrayList<IEditorReference>();
									IEditorInput input = ref.getEditorInput();
									if (input instanceof FileEditorInput) {
										for (URI uri : dependentModels) {
											if (uri.trimFileExtension().appendFileExtension("di").toString().endsWith( //$NON-NLS-1$
													((FileEditorInput) input).getFile().getFullPath().toString())) {
												editorsToClose.add(ref);
											}
										}
									}
									PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
											.closeEditors(editorsToClose.toArray(new IEditorReference[0]), true);

								} catch (PartInitException e) {
									// nothing we can do so silence
								}
							}
						}
					}
				});
			}
		}
		return true;
	}

	/**
	 * Check if the given model have references to the pathmap
	 * 
	 * @param targetUri
	 * @param modelUri
	 * @param dependentModels
	 */
	@SuppressWarnings("unchecked")
	public static void containsReferenceToPathmap(URI targetUri, URI modelUri, Set<URI> dependentModels) {
		
		if(targetUri.equals(modelUri)) {
			return;
		}
		
		Package model = UML2Util.load(rset, modelUri, UMLPackage.Literals.PACKAGE);
		if (model == null || !ZDLUtil.isZDLProfile(model, "cxDDS4CCM")) { //$NON-NLS-1$
			return;
		}
		
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (next instanceof PackageImport) {
				Package pkg = ((PackageImport) next).getImportedPackage();
				if(isReferenceToPathmap(next, pkg, targetUri)) {
					dependentModels.add(modelUri);
					return;
				}
				itor.prune();
			} else if (!(next instanceof Element)) {
				itor.prune();
			} else {
				Element element = (Element) next;
				if(element instanceof TypedElement) {
					Type type = ((TypedElement)element).getType();
					if(type != null && isReferenceToPathmap(next, type, targetUri)) {
						dependentModels.add(modelUri);
						return;
					}
				}
				List<org.eclipse.uml2.uml.Class> concepts = ZDLUtil.getZDLConcepts(element);
				for (org.eclipse.uml2.uml.Class clazz : concepts) {
					for (Property p : clazz.getAllAttributes()) {
						if (p.getType() instanceof PrimitiveType) {
							// no need to check primitive types
							continue;
						}
						Object value = ZDLUtil.getValue(element, clazz, p.getName());
						if (value != null) {
							if (value instanceof List) {
								for (Object o : (List<Object>) value) {
									if (o instanceof EObject && isReferenceToPathmap(next, (EObject) o, targetUri)) {
										dependentModels.add(modelUri);
										return;
									}
								}
							} else {
								if (value instanceof EObject
										&& isReferenceToPathmap(next, (EObject) value, targetUri)) {
									dependentModels.add(modelUri);
									return;
								}
							}
						}
					}
				}
			}
		}
	}

	private static boolean isReferenceToPathmap(EObject owner, EObject type, URI targetUri) {
		if (type == null) {
			return false;
		}
		if (type.eResource() != null && type.eResource() != owner.eResource()) {
			URI typeUri = URIConverter.INSTANCE.normalize(type.eResource().getURI());
			if (targetUri.equals(typeUri)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Load all UML resources in a folder
	 * 
	 * @param rset
	 * @param container
	 */
	public static void visitAllModels(IContainer container, Consumer<URI> lambda) {
		try {
			IResource[] members = container.members();

			for (IResource member : members) {
				if (member instanceof IProject) {
					if (!((IProject) member).isOpen()) {
						// Ignore closed projects
						continue;
					}
				}
				if (member instanceof IContainer) {
					visitAllModels((IContainer) member, lambda);
				} else if (member instanceof IFile) {
					IFile file = (IFile) member;
					String ext = file.getFullPath().getFileExtension();
					if (!UML2Util.isEmpty(ext) && "uml".equals(ext.toLowerCase())) { //$NON-NLS-1$
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
						lambda.accept(uri);
					}
				}
			}
		} catch (CoreException e) {
			Activator.getDefault().error(e.getMessage(), e);
		}
	}
	
	public static void addMapping(URI pathmapUri, URI modelUri) {
		rset.getResource(modelUri, true);
		CXDynamicURIConverter.addMapping(pathmapUri, modelUri);
	}
	
	private static boolean isPathmapProxy(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			if (eObject.eIsProxy()) {
				URI uri = ((MinimalEObjectImpl) eObject).eProxyURI();
				if ("pathmap".equals(uri.scheme())) { //$NON-NLS-1$
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Check to see if the given model contains broken pathmap links
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean checkForBrokenLinks(EObject model) {
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (next instanceof PackageImport) {
				Package pkg = ((PackageImport) next).getImportedPackage();
				if (isPathmapProxy(pkg)) {
					return true;
				}
				itor.prune();
			} else if (!(next instanceof Element)) {
				itor.prune();
			} else {
				Element element = (Element) next;
				if(element instanceof TypedElement) {
					Type type = ((TypedElement)element).getType();
					if (isPathmapProxy(type)) {
						return true;
					}
				}
				List<org.eclipse.uml2.uml.Class> concepts = ZDLUtil.getZDLConcepts(element);
				for (org.eclipse.uml2.uml.Class clazz : concepts) {
					for (Property p : clazz.getAllAttributes()) {
						if (p.getType() instanceof PrimitiveType) {
							// no need to check primitive types
							continue;
						}
						Object value = ZDLUtil.getRawValue(element, clazz, p.getName());
						if (value != null) {
							if (value instanceof List) {
								for (Object o : (List<Object>) value) {
									if (isPathmapProxy(o)) {
										return true;
									}
								}
							} else {
								if (isPathmapProxy(value)) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;

	}

	/**
	 * Check editor part to see if it is papyrus editor and check for the broken
	 * links
	 * 
	 * @param partRef
	 */
	private static void checkEditorPart(IWorkbenchPartReference partRef) {
		if (!(partRef instanceof IEditorReference)
				|| !(partRef.getPage().getActiveEditor() instanceof PapyrusMultiDiagramEditor)) {
			return;
		}
		PapyrusMultiDiagramEditor multiEditor = (PapyrusMultiDiagramEditor) partRef.getPage().getActiveEditor();
		ServicesRegistry serviceRegistry = multiEditor.getServicesRegistry();
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);
			UmlModel openedModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
			EObject root = null;
			if (openedModel != null) {
				try {
					root = openedModel.lookupRoot();
				} catch (NotFoundException e) {
					return;
				}
			}
			if (!(root instanceof Model)) {
				return;
			}
			
			List<URI> proxyUris = new ArrayList<URI>();
			for(PackageImport pi: ((Model)root).getPackageImports()) {
				if(isPathmapProxy(pi.getImportedPackage())) {
					URI uri = ((MinimalEObjectImpl)pi.getImportedPackage()).eProxyURI();
					proxyUris.add(uri);
				}
			}
			
			if (!proxyUris.isEmpty()) {
				StringBuffer buffer = new StringBuffer();
				for (URI uri : proxyUris) {
					buffer.append(uri).append(System.lineSeparator());
				}
				String errorMsg = NLS.bind(Messages.DDS4CCMDynamicURIMapHandler_PackageImportError, buffer.toString());
				MessageDialog.openError(Display.getCurrent().getActiveShell(),
						Messages.DDS4CCMDynamicURIMapHandler_BrokenLinkWarningTitle, errorMsg);
				return;
			}
			
			if (checkForBrokenLinks(root)) {
				boolean answer = MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
						Messages.DDS4CCMDynamicURIMapHandler_BrokenLinkWarningTitle,
						Messages.DDS4CCMDynamicURIMapHandler_BrokenLinkValidateMsg);
				if (answer) {
					final ValidateCXModelCommand command = new ValidateCXModelCommand(root, new DDS4CCMDiagnostician());
					final Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
					final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(root);

					Display.getCurrent().asyncExec(new Runnable() {
						
						@Override
						public void run() {
							domain.getCommandStack().execute(emfCommand);
						}
					});
				}
			}
		} catch (ServiceException e) {
			// do nothing
		}
	}

}
