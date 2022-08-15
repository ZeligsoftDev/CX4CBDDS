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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
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
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
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
import org.eclipse.jface.dialogs.Dialog;
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
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
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
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.validation.ui.commands.ValidateCXModelCommand;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.cx.ui.pathmap.PathmapChangeListener;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.dds4ccm.tools.PreferenceConstants;
import com.zeligsoft.domain.dds4ccm.tools.dialogs.CloseDependentModelDialog;
import com.zeligsoft.domain.dds4ccm.tools.dialogs.MessageDialogWithSuppressButton;
import com.zeligsoft.domain.dds4ccm.tools.dialogs.PathmapSelectionDialog;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMDiagnostician;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;

/**
 * Dynamic URI mapping handler.
 * 
 * @author Young-Soo Roh
 *
 */
public final class DDS4CCMDynamicURIMapHandler{

	private static ResourceSet rset = new ResourceSetImpl();
	
	private static IPartListener2 partListener;
	
	private static IResourceChangeListener rcl;
	
	private static PathmapChangeListener changeListener;
	
	private static Set<URI> conflictPathmaps = new HashSet<URI>();
	
	private static Map<URI, Set<URI>> dependentModelsToClose = new HashMap<URI, Set<URI>>();
	
	private static final Lock conflictPathmapLock = new ReentrantLock();
	
	private static final Lock dependentModelLock = new ReentrantLock();

	static {
		partListener = new IPartListener2() {

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
		};

		rcl = new IResourceChangeListener() {

			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				IResourceDelta delta = event.getDelta();
				if (delta != null) {
					processDelta(rset, delta);
				}
			}
		};

		changeListener = new PathmapChangeListener() {

			@Override
			public void handlePathmapChange(CXPathmapDescriptor newValue, CXPathmapDescriptor oldValue, int eventType) {
				
				if(eventType == PathmapChangeListener.ADD) {
					// handle conflict pathmaps.
					if (PlatformUI.isWorkbenchRunning()) {
						CXPathmapDescriptor desc = newValue;

						String prefConstant = PreferenceConstants.WARNING_SUPPRESSED_PATHMAP
								+ desc.getPathmap().toString();
						String suppressed = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID).get(prefConstant,
								PreferenceConstants.DEFAULT_WARNING_SUPPRESSED_PATHMAP);
						List<String> items = Arrays.asList(suppressed.split("\\s*,\\s*")); //$NON-NLS-1$
						if (!items.contains(desc.getMapping().toString())) {
							List<CXPathmapDescriptor> mappings = CXDynamicURIConverter
									.getPathmapDescriptors(desc.getPathmap());
							if (mappings.size() > 1) {
								// handle multiple mappings
								handleConflictPathmap(desc.getPathmap());
							}
						}
					}
				}else if (eventType == PathmapChangeListener.CHANGE) {
					// warn users about the change
					if (PlatformUI.isWorkbenchRunning()) {
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								String msg = NLS.bind(Messages.DDS4CCMDynamicURIMapHandler_WarningMsg,
										newValue.getPathmap().toString());

								Dialog dialog = new MessageDialogWithSuppressButton(
										Display.getCurrent().getActiveShell(),
										Messages.DDS4CCMDynamicURIMapHandler_WarningTitle, msg,
										Messages.DDS4CCMDynamicURIMapHandler_SuppressMessage,
										InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID),
										PreferenceConstants.SUPPRESS_PATHMAP_CHANGE_WARNING);
								dialog.open();
							}
						});
						
						// check dependent models
						checkDependentModels(oldValue);
					}
				} else if (eventType == PathmapChangeListener.FALLBACK) {
					// warn users about the change
					CXPathmapDescriptor desc = newValue;
					IEclipsePreferences store = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
					String prefConstant = PreferenceConstants.WARNING_SUPPRESSED_PATHMAP + desc.getPathmap().toString();
					store.remove(prefConstant);

					try {
						store.flush();
					} catch (BackingStoreException e) {
						// do nothing
					}

					// open conflict selection dialog
					handleConflictPathmap(desc.getPathmap());
					
					// check dependent model
					checkDependentModels(oldValue);
					
				} else if(eventType == PathmapChangeListener.REMOVE) {
					updateConflictPathmap(oldValue.getPathmap());
					// check dependent models
					checkDependentModels(oldValue);
				}
			}
		};
	}

	/**
	 * Open mapping selection dialog for multiple mappings
	 * 
	 * @param conflictPathmap
	 */
	private static void handleConflictPathmap(URI conflictPathmap) {
		if (PlatformUI.isWorkbenchRunning()) {
			addNewConflictPathmap(conflictPathmap);
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					PathmapSelectionDialog dialog = new PathmapSelectionDialog(Display.getCurrent().getActiveShell());
					dialog.open();
				}
			});
		}
	}
	
	/**
	 * Open close dependent model dialog
	 * 
	 * @param desc
	 */
	private static void checkDependentModels(CXPathmapDescriptor desc) {
		String modelName = desc.getRegisteredModels().get(0);
		URI resourceUri = URI.createURI(desc.getMapping().toString() + modelName);
		URI pathmapUri = URI.createURI(desc.getPathmap().toString() + modelName);
		// check dependent models

		if (!PlatformUI.isWorkbenchRunning()) {
			return;
		}

		Set<URI> modelUris = new HashSet<URI>();
		
		visitAllModels(ResourcesPlugin.getWorkspace().getRoot(), modelUri -> {
			if (BaseUIUtil.getEditorReference(modelUri) != null) {
				modelUris.add(modelUri);
				
			}
		});
		
		Set<URI> dependentModels = new HashSet<URI>();
		for (URI modelUri : modelUris) {
			containsReferenceToPathmap(pathmapUri, resourceUri, modelUri, dependentModels, true);
		}

		if (dependentModels.isEmpty()) {
			return;
		}
		
		addDependentModelsToClose(resourceUri, dependentModels);
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {

				if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null) {
					return;
				}

				CloseDependentModelDialog dialog = new CloseDependentModelDialog(Display.getCurrent().getActiveShell());
				if (dialog.open() == Dialog.OK) {
					List<IEditorReference> editorsToClose = new ArrayList<IEditorReference>();
					for (URI uri : dialog.getModelsToClose()) {
						IEditorReference ref = BaseUIUtil.getEditorReference(uri);
						if (ref != null) {
							editorsToClose.add(ref);
						}
					}
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.closeEditors(editorsToClose.toArray(new IEditorReference[0]), true);
				}
			}
		});
	}

	/**
	 * Initializes me.
	 */
	private DDS4CCMDynamicURIMapHandler() {
		super();
	}
	
	/**
	 * Initializing the mappings
	 */
	public static void remap() {
		new UIJob(Messages.DDS4CCMDynamicURIMapHandler_UpdateingWorkspaceUri) {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {

				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.addPartListener(partListener);

				IWorkspace workspace = ResourcesPlugin.getWorkspace();

				remapDynamicURI();
				workspace.addResourceChangeListener(rcl);
				CXDynamicURIConverter.addChangeListener(changeListener);

				return Status.OK_STATUS;
			}
		}.schedule();
	}
	
	/**
	 * Load all dynamic pathmap libraries from the workspace projects
	 */
	public static void remapDynamicURI() {
		for (Resource r : rset.getResources()) {
			// unload all models
			r.unload();
		}
		for (List<CXPathmapDescriptor> mappings : CXDynamicURIConverter.PATHMAPS.values()) {
			mappings.clear();
		}
		CXDynamicURIConverter.PATHMAPS.clear();
		visitAllModels(ResourcesPlugin.getWorkspace().getRoot(), uri -> processUML(uri, IResourceDelta.ADDED));
	}
	
	/**
	 * Return all queued new conflict pathmaps and clear the list
	 * 
	 * @return
	 */
	public static Set<URI> getAndClearNewConflictPathmaps() {
		Set<URI> results = new HashSet<URI>();
		conflictPathmapLock.lock();
		try {
			results.addAll(conflictPathmaps);
			conflictPathmaps.clear();
		}finally {
			conflictPathmapLock.unlock();
		}
		return results;
	}

	/**
	 * Queue new conflict pathmap
	 * 
	 * @param pathmap
	 */
	private static void addNewConflictPathmap(URI pathmap) {
		conflictPathmapLock.lock();
		try {
			conflictPathmaps.add(pathmap);
		}finally {
			conflictPathmapLock.unlock();
		}
	}

	private static void updateConflictPathmap(URI pathmap) {
		conflictPathmapLock.lock();
		try {
			if (conflictPathmaps.contains(pathmap) && CXDynamicURIConverter.getPathmapDescriptors(pathmap).size() < 1) {
				conflictPathmaps.remove(pathmap);
			}
		} finally {
			conflictPathmapLock.unlock();
		}
	}

	/**
	 * Return all queued new conflict pathmaps and clear the list
	 * 
	 * @return
	 */
	public static Map<URI, Set<URI>> getAndClearDependentModelsToClose() {
		Map<URI, Set<URI>> results;
		dependentModelLock.lock();
		try {
			results = dependentModelsToClose;
			dependentModelsToClose = new HashMap<URI, Set<URI>>();
		}finally {
			dependentModelLock.unlock();
		}
		return results;
	}

	/**
	 * Queue new conflict pathmap
	 * 
	 * @param pathmap
	 */
	public static void addDependentModelsToClose(URI removedUri, Set<URI> dependentModels) {
		dependentModelLock.lock();
		try {
			Set<URI> dependents = new HashSet<URI>();
			dependents.addAll(dependentModels);
			dependentModelsToClose.put(removedUri, dependents);
		}finally {
			dependentModelLock.unlock();
		}
	}


	/**
	 * Process workspace delta event
	 * 
	 * @param rset
	 * @param delta
	 */
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

	/**
	 * Process pathamp info from the given resource
	 * 
	 * @param uri
	 * @param deltaKind
	 */
	private static void processUML(URI uri, int deltaKind) {
		Package model = UML2Util.load(rset, uri, UMLPackage.Literals.PACKAGE);
		if (model == null || !ZDLUtil.isZDLProfile(model, "cxDDS4CCM")) { //$NON-NLS-1$
			return;
		}
		
		if (deltaKind == IResourceDelta.REMOVED) {
			removeMapping(uri);
		} else {
			// search dynamic pathmap
			String pathmap = CCMUtil.getZCXAnnotationDetail((Element) model, "pathmap", ""); //$NON-NLS-1$//$NON-NLS-2$
			if (!UML2Util.isEmpty(pathmap)) {
				URI pathmapUri = URI.createURI("pathmap" + "://" + pathmap + "/", true); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				addMapping(pathmapUri, uri);
			}
		}
	}
	
	/**
	 * Remove pathmap mapping
	 * 
	 * @param uri
	 */
	private static void removeMapping(URI uri) {
		// remove pathmap URI
		CXDynamicURIConverter.removeMapping(uri);
		// unload deleted resource
		Resource r = rset.getResource(uri, false);
		if (r != null) {
			r.unload();
		}
	}

	public static void containsReferenceToPathmap(URI pathampUri, URI mappingUri, URI modelUri,
			Set<URI> dependentModels) {
		containsReferenceToPathmap(pathampUri, mappingUri, modelUri, dependentModels, false);
		
	}
	
	/**
	 * Check if the given model have references to the pathmap
	 * 
	 * @param pathampUri
	 * @param modelUri
	 * @param dependentModels
	 */
	@SuppressWarnings("unchecked")
	public static void containsReferenceToPathmap(URI pathampUri, URI mappingUri, URI modelUri,
			Set<URI> dependentModels, boolean checkImportOnly) {

		if (URIConverter.INSTANCE.normalize(pathampUri).equals(modelUri)) {
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
				if (isReferenceToPathmap(next, pkg, pathampUri, mappingUri)) {
					dependentModels.add(modelUri);
					return;
				}
				itor.prune();
			} else {
				if (checkImportOnly) {
					itor.prune();
				} else {
					if (!(next instanceof Element)) {
						itor.prune();
					} else {
						Element element = (Element) next;
						if (element instanceof TypedElement) {
							Type type = ((TypedElement) element).getType();
							if (type != null && isReferenceToPathmap(next, type, pathampUri, mappingUri)) {
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
											if (o instanceof EObject && isReferenceToPathmap(next, (EObject) o,
													pathampUri, mappingUri)) {
												dependentModels.add(modelUri);
												return;
											}
										}
									} else {
										if (value instanceof EObject && isReferenceToPathmap(next, (EObject) value,
												pathampUri, mappingUri)) {
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
		}
	}

	/**
	 * Check if the given type's resource is a reference to the pathmap library
	 * 
	 * @param owner
	 * @param type
	 * @param pathampUri
	 * @param mappingUri
	 * @return
	 */
	private static boolean isReferenceToPathmap(EObject owner, EObject type, URI pathampUri, URI mappingUri) {
		if (type == null) {
			return false;
		}
		if (type.eResource() != null && type.eResource() != owner.eResource()) {
			URI typeUri = CXDynamicURIConverter.getPathmapURI(type.eResource().getURI());
			if (pathampUri.equals(typeUri) || mappingUri.equals(typeUri)) {
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
	
	/**
	 * Add pathmap mapping and handle conflict
	 * 
	 * @param pathmapUri
	 * @param modelUri
	 */
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
