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
package com.zeligsoft.domain.dds4ccm.tools.providers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;
import com.zeligsoft.domain.dds4ccm.tools.actions.GoToAction;
import com.zeligsoft.domain.dds4ccm.tools.actions.OpenModelAction;
import com.zeligsoft.domain.dds4ccm.tools.actions.RefactorURIAction;
import com.zeligsoft.domain.dds4ccm.tools.internal.emf.DDS4CCMDynamicURIMapHandler;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Custom property section for referenced models
 * 
 * @author Young-Soo Roh
 * 
 */
public class ReferencesCustomPropertySection implements ICXCustomPropertySection {

	private TreeViewer referencedModelTreeViewer;

	private TreeViewer referencingModelTreeViewer;

	// concepts to filter
	@SuppressWarnings("nls")
	private static List<String> propertiesToFilter = Arrays.asList("providedInterface", "requiredInterface", "type",
			"member");

	// properties to filter
	private static List<String> conceptsToFilter = Arrays.asList(ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.DEPLOYMENT,
			CCMNames.MONOLITHIC_IMPLEMENTATION);

	@Override
	public Map<String, Control> createSection(Composite parent, CXPropertyDescriptor descriptor, Property property) {

		Map<String, Control> result = new HashMap<String, Control>();
		createSectionForReferences(parent, descriptor);
		return result;
	}

	public void createSectionForReferences(final Composite parent, final CXPropertyDescriptor descriptor) {

		CXWidgetFactory.createLabel(parent, Messages.ReferencesCustomPropertySection_SectionLabel);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.verticalSpacing = 0;
		GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		data.horizontalSpan = 2;
		data.heightHint = 300;
		Composite composite = CXWidgetFactory.createCustomComposite(parent, layout, data);
		composite.setBackground(parent.getBackground());

		final TabFolder root = new TabFolder(composite, SWT.NULL);
		root.setLayout(new GridLayout(1, false));
		root.setLayoutData(new GridData(GridData.FILL_BOTH));

		TabItem referencedTab = new TabItem(root, SWT.NULL);
		referencedTab.setText(Messages.ReferencesCustomPropertySection_ReferencedModelTabLabel);
		referencedTab.setToolTipText(Messages.ReferencesCustomPropertySection_ReferencedModelToolTip);
		Composite referencedModelsComposite = new Composite(root, SWT.NONE);
		referencedModelsComposite.setLayout(new GridLayout(1, true));
		referencedTab.setControl(referencedModelsComposite);

		Button showReferencedModelButton = new Button(referencedModelsComposite, SWT.NULL);
		showReferencedModelButton.setText(
				Messages.ReferencesCustomPropertySection_ShowReferencedModelButtonLabel + referencedTab.getText());
		showReferencedModelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (referencedModelTreeViewer != null) {
					referencedModelTreeViewer.setInput(descriptor.getContext());
				}
			}
		});

		GridData treeViewerData = new GridData(GridData.FILL_BOTH);
		referencedModelTreeViewer = new TreeViewer(referencedModelsComposite, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		referencedModelTreeViewer.getTree().setLayoutData(treeViewerData);
		referencedModelTreeViewer.setContentProvider(new ReferencedModelContentProvider());
		referencedModelTreeViewer
				.setLabelProvider(new ReferenceLabelProvider(descriptor.getContext().eResource().getResourceSet()));
		referencedModelTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				Object selection = ((StructuredSelection) referencedModelTreeViewer.getSelection()).getFirstElement();
				if (selection instanceof ReferenceDescriptor) {
					BaseUIUtil.revealTarget(((ReferenceDescriptor) selection).getContext());
				}
			}
		});
		referencedModelTreeViewer.getTree().setLinesVisible(true);
		final MenuManager referencedModelContextMenu = new MenuManager();
		referencedModelContextMenu.setRemoveAllWhenShown(true);
		referencedModelContextMenu.addMenuListener(new IMenuListener() {

			@Override
			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) referencedModelTreeViewer.getSelection();
				if (selection == null) {
					return;
				}
				Object selectedObject = selection.getFirstElement();
				if (selectedObject instanceof ReferenceDescriptor) {
					// add Go To action
					GoToAction goToAction = new GoToAction(((ReferenceDescriptor) selectedObject).getContext());
					manager.add(goToAction);
				} else if (selectedObject instanceof URI) {
					// open model action
					URI selectedUri = (URI) selectedObject;
					OpenModelAction openAction = new OpenModelAction(selectedUri);
					manager.add(openAction);
					
					// add Refactor URI action
					RefactorURIAction refactorAction = new RefactorURIAction(
							descriptor.getContext().eResource().getURI(), (URI) selectedObject);
					manager.add(refactorAction);
				}
			}
		});

		final Menu referencedModelMenu = referencedModelContextMenu
				.createContextMenu(referencedModelTreeViewer.getControl());
		referencedModelTreeViewer.getControl().setMenu(referencedModelMenu);
		referencedModelTreeViewer.setInput(null);

		TabItem referencingTab = new TabItem(root, SWT.NULL);
		referencingTab.setText(Messages.ReferencesCustomPropertySection_ReferencingModelTabLabl);
		referencingTab.setToolTipText(Messages.ReferencesCustomPropertySection_ReferencingModelToolTip);

		Composite referencingModelsComposite = new Composite(root, SWT.NONE);
		referencingModelsComposite.setLayout(new GridLayout(1, true));
		referencingTab.setControl(referencingModelsComposite);

		Button showReferencingModelButton = new Button(referencingModelsComposite, SWT.NULL);
		showReferencingModelButton.setText(
				Messages.ReferencesCustomPropertySection_ShowReferencedModelButtonLabel + referencingTab.getText());
		showReferencingModelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (referencingModelTreeViewer != null) {
					referencingModelTreeViewer.setInput(descriptor.getContext().eResource().getURI());
				}
			}
		});

		referencingModelTreeViewer = new TreeViewer(referencingModelsComposite,
				SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		referencingModelTreeViewer.getTree().setLayoutData(treeViewerData);
		referencingModelTreeViewer.setContentProvider(new ReferencingModelContentProvider());
		referencingModelTreeViewer.setLabelProvider(new URILabelProvider());
		referencingModelTreeViewer.getTree().setLinesVisible(true);

		final MenuManager referencingModelContextMenu = new MenuManager();
		referencingModelContextMenu.setRemoveAllWhenShown(true);
		referencingModelContextMenu.addMenuListener(new IMenuListener() {

			@Override
			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) referencingModelTreeViewer.getSelection();
				if (selection == null) {
					return;
				}
				Object selectedObject = selection.getFirstElement();
				if (selectedObject instanceof URI) {
					URI selectedUri = (URI) selectedObject;
					OpenModelAction openAction = new OpenModelAction(selectedUri);
					manager.add(openAction);
				}
			}
		});

		final Menu referencingModelMenu = referencingModelContextMenu
				.createContextMenu(referencingModelTreeViewer.getControl());
		referencingModelTreeViewer.getControl().setMenu(referencingModelMenu);
		referencingModelTreeViewer.setInput(null);
	}

	/**
	 * Reference descriptor
	 * 
	 * @author Young-Soo Roh
	 *
	 */
	class ReferenceDescriptor {
		private EObject context;
		private String concept;
		private String property;
		private boolean isProxy;

		public ReferenceDescriptor(EObject context, String concept, String property, boolean isProxy) {
			this.context = context;
			this.concept = concept;
			this.property = property;
			this.isProxy = isProxy;
		}

		public boolean isProxyValue() {
			return isProxy;
		}

		public EObject getContext() {
			return context;
		}

		public String getConcept() {
			return concept;
		}

		public String getProperty() {
			return property;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null)
				return false;
			if (getClass() != o.getClass())
				return false;
			ReferenceDescriptor desc = (ReferenceDescriptor) o;
			return Objects.equals(context, desc.context) && Objects.equals(concept, desc.concept)
					&& Objects.equals(property, desc.property);
		}
	}

	/**
	 * Compute all external references
	 * 
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ListMultimap<URI, ReferenceDescriptor> computeReferencesMap(EObject model) {
		ListMultimap<URI, ReferenceDescriptor> referencesMap = ArrayListMultimap.create();
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (next instanceof PackageImport) {
				Package pkg = ((PackageImport) next).getImportedPackage();
				URI uri = getURI(pkg);
				if (uri != null) {
					referencesMap.put(uri, new ReferenceDescriptor(next, null, null, pkg.eIsProxy()));
				}
				itor.prune();
			} else if (!(next instanceof Element)) {
				itor.prune();
			} else {
				Element element = (Element) next;

				if (element instanceof TypedElement) {
					if ("member".equals(((TypedElement) element).getName()) //$NON-NLS-1$
							|| "members".equals(((TypedElement) element).getName())) { //$NON-NLS-1$
						Type type = ((TypedElement) element).getType();
						if (type != null && type.eResource() != element.eResource()) {
							referencesMap.put(getURI(type),
									new ReferenceDescriptor(element, null, "type", type.eIsProxy())); //$NON-NLS-1$
						}
					}
				}

				List<org.eclipse.uml2.uml.Class> concepts = ZDLUtil.getZDLConcepts(element);
				for (org.eclipse.uml2.uml.Class clazz : concepts) {
					for (Property p : clazz.getAllAttributes()) {
						if (propertiesToFilter.contains(p.getName())) {
							continue;
						}
						if (p.getType() instanceof PrimitiveType) {
							// no need to check primitive types
							continue;
						}
						Object value = ZDLUtil.getRawValue(element, clazz, p.getName());
						if (value != null) {
							if (value instanceof List) {
								for (Object o : (List<Object>) value) {
									if (o instanceof EObject) {
										EObject eo = (EObject) o;
										URI uri = getURI(eo);
										if (uri != null && eo.eResource() != element.eResource()) {
											referencesMap.put(uri, new ReferenceDescriptor(element,
													clazz.getQualifiedName(), p.getName(), eo.eIsProxy()));
										}
									}
								}
							} else {
								if (value instanceof EObject) {
									EObject eo = (EObject) value;
									URI uri = getURI(eo);
									if (uri != null && eo.eResource() != element.eResource()) {
										referencesMap.put(uri, new ReferenceDescriptor(element,
												clazz.getQualifiedName(), p.getName(), eo.eIsProxy()));
									}
								}
							}
						}
					}
				}

				for (String conceptToFilter : conceptsToFilter) {
					if (ZDLUtil.isZDLConcept(element, conceptToFilter)) {
						itor.prune();
					}
				}
			}
		}

		return referencesMap;
	}

	private URI getURI(EObject eObject) {
		if (eObject.eIsProxy()) {
			URI proxyUri = ((MinimalEObjectImpl) eObject).eProxyURI();
			return proxyUri.trimFragment();
		}
		return eObject.eResource() == null ? null : eObject.eResource().getURI();
	}

	class ReferencingModelContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			if (!(inputElement instanceof URI)) {
				return null;
			}

			List<URI> result = new ArrayList<URI>();

			IRunnableWithProgress runnable = new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

					List<URI> models = new ArrayList<URI>();

					URI targetUri = (URI) inputElement;
					URI normalizedUri = URIConverter.INSTANCE.normalize(targetUri);
					DDS4CCMDynamicURIMapHandler.visitAllModels(ResourcesPlugin.getWorkspace().getRoot(),
							modelUri -> models.add(modelUri));
					monitor.beginTask(Messages.ReferencesCustomPropertySection_FindReferencingModelTaskName,
							IProgressMonitor.UNKNOWN);

					Set<URI> dependentModels = new HashSet<URI>();
					for (int i = 0; i < models.size(); i++) {
						URI modelUri = models.get(i);
						monitor.subTask("Checking " + modelUri.toString()); //$NON-NLS-1$
						DDS4CCMDynamicURIMapHandler.containsReferenceToPathmap(targetUri, normalizedUri, modelUri, dependentModels);
					}
					monitor.done();
					for (URI uri : dependentModels) {
						result.add(CXDynamicURIConverter.getPathmapURI(uri));
					}
				}
			};

			try {
				new ProgressMonitorDialog(null).run(false, false, runnable);
			} catch (InvocationTargetException e) {
			} catch (InterruptedException e) {
			}

			return result.toArray();

		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return null;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}

	}

	/**
	 * Reference tree content provider
	 * 
	 * @author Young-Soo Roh
	 *
	 */
	class ReferencedModelContentProvider implements ITreeContentProvider {

		private ListMultimap<URI, ReferenceDescriptor> refMap = ArrayListMultimap.create();

		@Override
		public Object[] getElements(Object inputElement) {
			if (!(inputElement instanceof EObject)) {

				return null;
			}

			List<URI> result = new ArrayList<URI>();

			IRunnableWithProgress runnable = new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) {
					monitor.beginTask(Messages.ReferencesCustomPropertySection_FindingReferencedModelsTaskName,
							IProgressMonitor.UNKNOWN);

					ResourceSet rset = ((EObject) inputElement).eResource().getResourceSet();
					refMap = computeReferencesMap((EObject) inputElement);
					for (URI uri : refMap.keySet()) {
						Package root = UML2Util.load(rset, uri, UMLPackage.Literals.PACKAGE);
						if (root != null) {
							if (ZDLUtil.isZDLProfile(root, "cxDDS4CCM")) { //$NON-NLS-1$
								result.add(uri);
							}
						} else {
							result.add(uri);
						}
					}

					monitor.done();
				}
			};

			try {
				new ProgressMonitorDialog(null).run(false, false, runnable);
			} catch (InvocationTargetException e) {
			} catch (InterruptedException e) {
			}

			return result.toArray();
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof URI) {
				return refMap.get((URI) parentElement).toArray();
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof EObject) {
				for (Entry<URI, ReferenceDescriptor> entry : refMap.entries()) {
					if (entry.getValue().equals(element)) {
						return entry.getKey();
					}
				}
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return refMap.containsKey(element);
		}

	}

	/**
	 * URI label provider
	 * 
	 * @author Young-Soo Roh
	 *
	 */
	class URILabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			return element.toString();
		}

	}

	/**
	 * Reference tree label provider
	 * 
	 * @author Young-Soo Roh
	 *
	 */
	class ReferenceLabelProvider extends LabelProvider implements ITableLabelProvider {

		private boolean showQualifiedName = true;
		private ResourceSet rset;

		public ReferenceLabelProvider(ResourceSet rset) {
			this.rset = rset;
		}

		@Override
		public String getText(Object object) {
			return getColumnText(object, 0);
		}

		@Override
		public Image getImage(Object object) {
			return getColumnImage(object, 0);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang
		 * .Object, int)
		 */
		@Override
		public Image getColumnImage(Object object, int columnIndex) {
			if (object instanceof ReferenceDescriptor) {
				EObject eo = ((ReferenceDescriptor) object).getContext();
				return BaseUIUtil.getIcon(eo);
			}
			if (object instanceof URI) {
				Resource r = rset.getResource((URI) object, false);
				if (r == null || !r.getErrors().isEmpty()) {
					return CXWidgetFactory.ERROR_IMAGE;
				}
			}
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang
		 * .Object, int)
		 */
		@Override
		public String getColumnText(Object object, int columnIndex) {

			if (!(object instanceof ReferenceDescriptor)) {
				return object.toString();
			}

			ReferenceDescriptor desc = (ReferenceDescriptor) object;
			EObject context = desc.getContext();

			if (context instanceof PackageImport) {
				return "<Package Import> " + ((PackageImport) context).getImportedPackage().getName(); //$NON-NLS-1$
			}

			String label = EMFCoreUtil.getName(context);

			if (showQualifiedName) {
				String qualifiedName = EMFCoreUtil.getQualifiedName(context, true);
				// Remove any unnamed element from the qualified name
				qualifiedName = qualifiedName.replaceAll("::<.+>", //$NON-NLS-1$
						UML2Util.EMPTY_STRING);

				label += " - " + qualifiedName; //$NON-NLS-1$
			}

			if (desc.getProperty() != null) {
				label = label + Path.SEPARATOR + desc.getProperty();
			}
			return label;
		}
	}
}
