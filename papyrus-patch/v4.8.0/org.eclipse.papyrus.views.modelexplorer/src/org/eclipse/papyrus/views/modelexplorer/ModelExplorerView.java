/*****************************************************************************
 * Copyright (c) 2010, 2016, 2017, 2019 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - post refreshes for transaction commit asynchronously (CDO)
 *  Christian W. Damus (CEA) - bugs 429826, 434635, 437217, 441857
 *  Christian W. Damus - bugs 450235, 451683, 485220
 *  Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Bug 497289, 455241
 *  Mickaël ADAM (ALL4TEC) - mickael.adam@all4tec.net - Bug 500290: implement new filter and ignore case Check button
 *  Ansgar Radermacher (CEA LIST) - Bug 516459: Navigation mechanism with Alt+hover does not work on Linux
 *  Ansgar Radermacher (CEA LIST) - Bug 553094: Avoid potential NPE during dispose and remove reload-listener
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import static org.eclipse.papyrus.views.modelexplorer.preferences.IFilterPreferenceConstants.ST_LEFT;
import static org.eclipse.papyrus.views.modelexplorer.preferences.IFilterPreferenceConstants.ST_LEFT_BEFORE;
import static org.eclipse.papyrus.views.modelexplorer.preferences.IFilterPreferenceConstants.ST_RIGHT;
import static org.eclipse.papyrus.views.modelexplorer.preferences.IFilterPreferenceConstants.ST_RIGHT_BEFORE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyListener;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyEvent;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageLifeCycleEventsListener;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AdapterUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.commands.PapyrusDeleteCommand;
import org.eclipse.papyrus.infra.emf.gmf.command.ICommandWrapper;
import org.eclipse.papyrus.infra.emf.gmf.util.CommandUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationMenu;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationService;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.ui.editor.IReloadableEditor;
import org.eclipse.papyrus.infra.ui.editor.reload.EditorReloadAdapter;
import org.eclipse.papyrus.infra.ui.editor.reload.EditorReloadEvent;
import org.eclipse.papyrus.infra.ui.editor.reload.TreeViewerContext;
import org.eclipse.papyrus.infra.ui.emf.providers.SemanticFromModelExplorer;
import org.eclipse.papyrus.infra.ui.emf.utils.ProviderHelper;
import org.eclipse.papyrus.infra.ui.lifecycleevents.IEditorInputChangedListener;
import org.eclipse.papyrus.infra.ui.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.widgets.editors.StringWithClearEditor;
import org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.views.modelexplorer.SharedModelExplorerState.StateChangedEvent;
import org.eclipse.papyrus.views.modelexplorer.listener.DoubleClickListener;
import org.eclipse.papyrus.views.modelexplorer.matching.ModelElementItemMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.preferences.IFilterPreferenceConstants;
import org.eclipse.papyrus.views.modelexplorer.preferences.INavigatorPreferenceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.CommonViewerSorter;
import org.eclipse.ui.navigator.IExtensionActivationListener;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.navigator.INavigatorContentService;
import org.eclipse.ui.navigator.INavigatorFilterService;
import org.eclipse.ui.navigator.LinkHelperService;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.google.common.base.Supplier;
import com.google.common.collect.Lists;

/**
 * Papyrus Model Explorer associated to one {@link IMultiDiagramEditor}.
 * This ModelExplorer is linked to one single {@link IMultiDiagramEditor}. It doesn't change its
 * source when the current Editor change. To allow to explore different Model, use a {@link ModelExplorerPageBookView}.
 *
 */
public class ModelExplorerView extends CommonNavigator implements IRevealSemanticElement, IEditingDomainProvider, IPageLifeCycleEventsListener {

	/** The Id of the declared search field filter. */
	private static final String SEARCH_FILTER_ID = "org.eclipse.papyrus.views.modelexplorer.filter";//$NON-NLS-1$

	private SharedModelExplorerState sharedState;

	private SharedModelExplorerState.StateChangedListener sharedStateListener;

	/**
	 * The context of the LabelProviderService used by this view
	 *
	 * @see {@link LabelProviderService}
	 */
	public static final String LABEL_PROVIDER_SERVICE_CONTEXT = "org.eclipse.papyrus.views.modelexplorer.labelProvider.context"; //$NON-NLS-1$

	/**
	 * The {@link ServicesRegistry} associated to the Editor. This view is associated to the
	 * ServicesRegistry rather than to the EditorPart.
	 */
	private ServicesRegistry serviceRegistry;

	/** The save aservice associated to the editor. */
	private ISaveAndDirtyService saveAndDirtyService;

	/** {@link IUndoContext} used to tag command in the commandStack. */
	private IUndoContext undoContext;

	/** editing domain used to read/write the model */
	private TransactionalEditingDomain editingDomain;

	/** Flag to avoid reentrant call to refresh. */
	private AtomicBoolean isRefreshing = new AtomicBoolean(false);

	/** Navigation menu for selected tree item */
	private NavigationMenu navigationMenu;

	/** The tree viewer filter. */
	protected PatternViewerFilter viewerFilter;

	/** Adapter that gets called during reload */
	protected EditorReloadAdapter reloadAdapter;

	/** reference to reload function of editor */
	protected IReloadableEditor reloadableEditor;

	/** true if the stereotype delimiters have to be replaced. */
	private boolean stereotypeDelimitersReplaced;

	/**
	 * A listener on page (all editors) selection change. This listener is set
	 * in {@link ModelExplorerView#init(IViewSite)}. It should be dispose to remove
	 * hook to the Eclipse page.
	 */
	private ISelectionListener pageSelectionListener = new ISelectionListener() {

		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			handleSelectionChangedFromDiagramEditor(part, selection);
		}
	};

	/**
	 * Listener on {@link ISaveAndDirtyService#addInputChangedListener(IEditorInputChangedListener)}
	 */
	protected IEditorInputChangedListener editorInputChangedListener = new IEditorInputChangedListener() {

		/**
		 * This method is called when the editor input is changed from the ISaveAndDirtyService.
		 *
		 * @see org.eclipse.papyrus.infra.ui.lifecycleevents.IEditorInputChangedListener#editorInputChanged(org.eclipse.ui.part.FileEditorInput)
		 *
		 * @param fileEditorInput
		 */
		@Override
		public void editorInputChanged(FileEditorInput fileEditorInput) {
			// Change the editor input.
			setPartName(fileEditorInput.getName());
		}

		/**
		 * The isDirty flag has changed, reflect its new value
		 *
		 * @see org.eclipse.papyrus.infra.ui.lifecycleevents.IEditorInputChangedListener#isDirtyChanged()
		 *
		 */
		@Override
		public void isDirtyChanged() {
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
	};

	/**
	 * Listener on commandStack changes.
	 */
	private final CommandStackListener commandStackListener = new CommandStackListener() {

		@Override
		public void commandStackChanged(EventObject event) {
			Command mostRecentCommand = getEditingDomain().getCommandStack().getMostRecentCommand();
			if (isDeleteCommand(mostRecentCommand)) {
				TreeItem topItem = getCommonViewer().getTree().getTopItem();
				if (null != topItem) {
					if (null == Display.getCurrent()) {
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								getCommonViewer().setSelection(new StructuredSelection(topItem.getData()));
							}
						});
					} else {
						getCommonViewer().setSelection(new StructuredSelection(topItem.getData()));
					}
				}
			}
		};
	};

	/**
	 * Verify if the command is a DeleteElementCommand
	 *
	 * @param command
	 *            The parent command
	 * @return The result.
	 */
	protected boolean isDeleteCommand(final Object command) {
		boolean isDeleteCommand = false;

		if (command instanceof PapyrusDeleteCommand || command instanceof DestroyElementPapyrusCommand) {
			isDeleteCommand = true;
		} else if (CommandUtils.isCompound(command)) {
			final Iterable<Object> children = CommandUtils.getChildren(command);
			if (null != children) {
				Iterator<Object> iterator = children.iterator();
				while (iterator.hasNext() && !isDeleteCommand) {
					Object next = iterator.next();
					if (isDeleteCommand(next)) {
						isDeleteCommand = true;
					}
				}
			}
		} else if (ICommandWrapper.isWrapper(command, Object.class)) {
			Object unwrap = ICommandWrapper.unwrap(command, Object.class);
			if (isDeleteCommand(unwrap)) {
				isDeleteCommand = true;
			}
		}

		return isDeleteCommand;
	}

	/** The {@link IPropertySheetPage} this model explorer will use. */
	private final List<IPropertySheetPage> propertySheetPages = new LinkedList<>();

	/**
	 *
	 * Constructor.
	 *
	 * @param part
	 *            The part associated to this ModelExplorer
	 */
	public ModelExplorerView(IMultiDiagramEditor part) {

		if (part == null) {
			throw new IllegalArgumentException("A part should be provided.");//$NON-NLS-1$
		}

		init(part);

		reloadAdapter = new EditorReloadAdapter() {

			@Override
			public void editorAboutToReload(EditorReloadEvent event) {
				// Stash expansion and selection state of the common viewer
				event.putContext(new ModelExplorerTreeViewerContext(getCommonViewer()));

				deactivate();
			}

			@Override
			public void editorReloaded(EditorReloadEvent event) {
				init(event.getEditor());

				activate();

				initCommonViewer(getCommonViewer());

				// Restore expansion and selection state of the common viewer
				((TreeViewerContext<?>) event.getContext()).restore(getCommonViewer());
			}
		};
		reloadableEditor = IReloadableEditor.Adapter.getAdapter(part);
		reloadableEditor.addEditorReloadListener(reloadAdapter);
	}

	private void init(IMultiDiagramEditor editor) {
		// Try to get the ServicesRegistry
		serviceRegistry = editor.getServicesRegistry();
		if (serviceRegistry == null) {
			throw new IllegalArgumentException("The editor should have a ServiceRegistry.");//$NON-NLS-1$
		}

		// Get required services from ServicesRegistry
		try {
			saveAndDirtyService = serviceRegistry.getService(ISaveAndDirtyService.class);
			undoContext = serviceRegistry.getService(IUndoContext.class);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
	}

	@Override
	protected void handleDoubleClick(DoubleClickEvent anEvent) {
		if (Activator.getDefault().getPreferenceStore().getBoolean(INavigatorPreferenceConstants.PREF_EXPAND_NODE_ON_DOUBLE_CLICK)) {
			super.handleDoubleClick(anEvent);
		}
	}

	/**
	 * Handle a selection change in the editor.
	 *
	 * @param part
	 * @param selection
	 */
	private void handleSelectionChangedFromDiagramEditor(IWorkbenchPart part, ISelection selection) {
		// Handle selection from diagram editor
		if (isLinkingEnabled()) {
			if (part instanceof IEditorPart) {
				if (selection instanceof IStructuredSelection) {
					Iterator<?> selectionIterator = ((IStructuredSelection) selection).iterator();
					ArrayList<Object> semanticElementList = new ArrayList<>();
					while (selectionIterator.hasNext()) {
						Object currentSelection = selectionIterator.next();
						Object semanticElement = EMFHelper.getEObject(currentSelection);
						if (semanticElement != null) {
							semanticElementList.add(semanticElement);
						}

					}
					revealSemanticElement(semanticElementList);

				}

			}

			// Selections from the Model Explorer result in a part from the ModelExplorerPageBookView instance which is not an IEditorPart
			if (part instanceof ModelExplorerPageBookView && !selection.isEmpty()) {
				if (selection instanceof IStructuredSelection) {
					// Extracted from org.eclipse.ui.internal.navigator.actions.LinkEditorAction activateEditorJob
					// the problem was that multi-element selections were disabled as only selections of 1 could clear the condition size()==1
					IStructuredSelection sSelection = (IStructuredSelection) selection;
					LinkHelperService linkService = getLinkHelperService();
					ILinkHelper[] helpers = linkService.getLinkHelpersFor(sSelection.getFirstElement()); // LinkHelper in org.eclipse.papyrus.views.modelexplorer
					if (helpers.length > 0) {
						helpers[0].activateEditor(part.getSite().getPage(), sSelection);
					}
				}
			}
		}
	}

	/**
	 * look for the path the list of element (comes from the content provider) to go the eObject
	 *
	 * @param eobject
	 *            that we look for.
	 * @param objects
	 *            a list of elements where eobject can be wrapped.
	 * @return the list of modelElementItem ( from the root to the element that wrap the eobject)
	 */
	protected List<Object> searchPath(EObject eobject, List<Object> objects) {
		SemanticFromModelExplorer semanticGetter = new SemanticFromModelExplorer();
		List<Object> path = new ArrayList<>();
		ITreeContentProvider contentProvider = (ITreeContentProvider) getCommonViewer().getContentProvider();
		// IPageMngr iPageMngr = EditorUtils.getIPageMngr();
		IPageManager iPageMngr;
		try {
			iPageMngr = ServiceUtils.getInstance().getService(IPageManager.class, serviceRegistry);
		} catch (ServiceException e) {
			// This shouldn't happen.
			return Collections.emptyList();
		}
		Object[] result = iPageMngr.allPages().toArray();
		List<Object> editors = Arrays.asList(result);


		for (Object o : objects) {
			// Search matches in this level
			if (!editors.contains(o)) {
				if (eobject.equals(EMFHelper.getEObject(o))) {
					path.add(o);
					return path;
				}
			}

			// Find childs only for feature container
			for (int i = 0; i < contentProvider.getChildren(o).length; i++) {
				Object treeItem = contentProvider.getChildren(o)[i];

				List<Object> tmppath = new ArrayList<>();
				Object element = semanticGetter.getSemanticElement(treeItem);
				if (element != null) {
					if (element instanceof EReference) {
						if (((EReference) element).isContainment() && (!((EReference) element).isDerived())) {
							List<Object> childs = new ArrayList<>();
							childs.add(treeItem);
							tmppath = searchPath(eobject, childs);
						}
					}

					else {
						if (element instanceof EObject) {
							List<Object> childs = new ArrayList<>();
							childs.add(treeItem);
							tmppath = searchPath(eobject, childs);
						}
					}
				}

				// if tmppath contains the wrapped eobject we have find the good path
				if (tmppath.size() > 0) {
					if (eobject.equals((EMFHelper.getEObject((tmppath.get(tmppath.size() - 1)))))) {
						path.add(o);
						path.addAll(tmppath);
						return path;
					}
				}
			}
		}

		return new ArrayList<>();
	}


	/**
	 * {@inheritDoc}
	 */
	// FIXME Use of internal class (NavigatorContentService) - in the hope that the bug gets fixed soon.
	@Override
	protected CommonViewer createCommonViewerObject(Composite aParent) {
		CommonViewer viewer = new CustomCommonViewer(getViewSite().getId(), aParent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);

		initCommonViewer(viewer);

		viewer.getNavigatorContentService().getActivationService().addExtensionActivationListener(new IExtensionActivationListener() {

			@Override
			public void onExtensionActivation(String aViewerId, String[] theNavigatorExtensionIds, boolean isActive) {
				sharedState.updateNavigatorContentExtensions(theNavigatorExtensionIds, isActive);
			}
		});

		ColumnViewerToolTipSupport.enableFor(viewer, ToolTip.NO_RECREATE);

		return viewer;
	}

	private void installEMFFacetTreePainter(Tree tree) {
		// Install the EMFFacet Custom Tree Painter
		// org.eclipse.papyrus.infra.emf.Activator.getDefault().getCustomizationManager().installCustomPainter(tree);

		// The EMF Facet MeasureItem Listener is incompatible with the NavigatorDecoratingLabelProvider. Remove it.
		// Symptoms: ModelElementItems with an EMF Facet Overlay have a small selection size
		// Removal also fixes bug 400012: no scrollbar although tree is larger than visible area
		Collection<Listener> listenersToRemove = new LinkedList<>();
		for (Listener listener : tree.getListeners(SWT.MeasureItem)) {
			if (listener.getClass().getName().contains("org.eclipse.papyrus.emf.facet.infra.browser.uicore.internal.CustomTreePainter")) { //$NON-NLS-1$
				listenersToRemove.add(listener);
			}
		}

		for (Listener listener : listenersToRemove) {
			tree.removeListener(SWT.MeasureItem, listener);
		}
	}

	private void initCommonViewer(CommonViewer viewer) {
		// enable tool-tips
		// workaround for bug 311827: the Common Viewer always uses NavigatorDecoratingLabelProvider
		// as a wrapper for the LabelProvider provided by the application. The NavigatorDecoratingLabelProvider
		// does not delegate tooltip related functions but defines them as empty.

		Object input = getInitialInput();
		ILabelProvider labelProvider = null;

		if (input instanceof ServicesRegistry) {
			ServicesRegistry registry = (ServicesRegistry) input;
			try {
				labelProvider = registry.getService(LabelProviderService.class).getLabelProvider(LABEL_PROVIDER_SERVICE_CONTEXT);
			} catch (ServiceException ex) {
				Activator.log.error(ex);
			}

			labelProvider = new DecoratingLabelProviderWTooltips(labelProvider, (ServicesRegistry) input);
		}

		if (labelProvider == null) {
			labelProvider = new LabelProvider();
		}

		viewer.setLabelProvider(labelProvider); // add for decorator and tooltip support
	}

	/**
	 * Listener handling the activation of the navigation menu as well as exit if user clicks outside
	 */
	public class MenuListener extends MouseAdapter implements MouseMoveListener {

		// @Override
		@Override
		public void mouseMove(MouseEvent mouseEvent) {
			if (navigationMenu != null) {
				if (navigationMenu.willEnter(mouseEvent, null)) {
					TreeItem treeItem = getTreeItem(mouseEvent);
					if (treeItem != null) {
						navigationMenu.handleRequest(mouseEvent, treeItem.getData());
					}
				} else {
					navigationMenu.exitItem();
				}
			}
		}

		/**
		 * exit navigation menu on click (avoids that menu remains open, if user clicks outside
		 */
		@Override
		public void mouseDown(MouseEvent mouseEvent) {
			if (navigationMenu != null) {
				navigationMenu.exitItem();
			}
		}
	}

	@Override
	public void createPartControl(Composite aParent) {
		super.createPartControl(aParent);

		getCommonViewer().getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		getCommonViewer().setSorter(null);
		((CustomCommonViewer) getCommonViewer()).getDropAdapter().setFeedbackEnabled(true);
		getCommonViewer().addDoubleClickListener(new DoubleClickListener(new Supplier<ServicesRegistry>() {
			@Override
			public ServicesRegistry get() {
				return serviceRegistry;
			}
		}));

		try {
			navigationMenu = serviceRegistry.getService(NavigationService.class).createNavigationList();
			if (navigationMenu != null) {
				navigationMenu.setServicesRegistry(serviceRegistry);
				navigationMenu.setParentShell(this.getControl().getShell());
			}
		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		Tree tree = getCommonViewer().getTree();

		MenuListener menuListener = new MenuListener();
		tree.addMouseMoveListener(menuListener);
		tree.addMouseListener(menuListener);

		installEMFFacetTreePainter(tree);
		try {
			ISashWindowsContainer sashWindowsContainer = serviceRegistry.getService(ISashWindowsContainer.class);
			sashWindowsContainer.addPageLifeCycleListener(this);
		} catch (ServiceException ex) {
			// Ignore
		}

		if (sharedState != null) {
			initSharedState(sharedState);
		}

		// create the filter composite
		createFilterComposite(aParent);
	}

	/**
	 * Creates an area where a filter can be entered.
	 *
	 * @param parent
	 *            the parent composite where to create the filter text
	 * @return the created text area
	 */
	protected void createFilterComposite(final Composite parent) {
		Composite filterComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		filterComposite.setLayout(layout);
		filterComposite.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		// Set the viewerFilter
		INavigatorFilterService filterService = getCommonViewer().getNavigatorContentService().getFilterService();
		if (!filterService.isActive(SEARCH_FILTER_ID)) {
			String[] filterId = { SEARCH_FILTER_ID };
			filterService.activateFilterIdsAndUpdateViewer(filterId);
		}
		ViewerFilter[] visibleFilters = filterService.getVisibleFilters(true);
		for (int i = 0; i < visibleFilters.length; i++) {
			if (visibleFilters[i] instanceof PatternViewerFilter) {
				viewerFilter = (PatternViewerFilter) visibleFilters[i];
				break;
			}
		}
		if (null == viewerFilter) {
			viewerFilter = new PatternViewerFilter();
		}

		viewerFilter.setPattern("*");//$NON-NLS-1$

		// Create the filter composite
		final StringWithClearEditor filterText = new StringWithClearEditor(filterComposite, SWT.BORDER);
		filterText.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		filterText.setValue("");//$NON-NLS-1$
		filterText.setToolTipText(Messages.ModelExplorerView_SearchTextFieldTooltip);
		filterText.addCommitListener(event -> {
			viewerFilter.setPattern(filterText.getValue());
			getCommonViewer().refresh();
		});

		filterText.setValidateOnDelay(getValidationDelay());
		filterText.setValidateOnDelay(isFilterValidateOnDelay());

		// Key listener to focus the tree viewer when arrow-up key is pressed
		filterText.getText().addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.ARROW_UP) {
					getCommonViewer().getControl().setFocus();
				}

				// Set the filter text if the replace stereotype delimiters preference have changed
				if (isStereotypeDelimitersReplaced() != stereotypeDelimitersReplaced) {
					stereotypeDelimitersReplaced = isStereotypeDelimitersReplaced();
					if (stereotypeDelimitersReplaced) {
						filterText.addStringToReplace(ST_LEFT_BEFORE, ST_LEFT);
						filterText.addStringToReplace(ST_RIGHT_BEFORE, ST_RIGHT);
					} else {
						filterText.clearStringToReplace();
					}
				}
			}

		});

		// Create the checkbox button
		Button checkBoxCaseSensitive = new Button(filterComposite, SWT.CHECK);
		checkBoxCaseSensitive.setText(Messages.ModelExplorerView_CaseSensitiveCheckBoxLabel);
		checkBoxCaseSensitive.setToolTipText(Messages.ModelExplorerView_CaseSensitiveCheckBoxTooltip);
		checkBoxCaseSensitive.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				viewerFilter.setIgnoreCase(!((Button) event.getSource()).getSelection());
				getCommonViewer().refresh();
			}
		});

		filterText.getText().addFocusListener(new FocusAdapter() {
			/**
			 * {@inhiriteDoc}
			 *
			 * @see java.awt.event.FocusAdapter#focusGained(java.awt.event.FocusEvent)
			 */
			@Override
			public void focusGained(final FocusEvent e) {
				filterText.setValidateOnDelay(getValidationDelay());
				filterText.setValidateOnDelay(isFilterValidateOnDelay());
			}
		});

	}

	/**
	 * Gets the preferences for the validation kind of filter field.
	 */
	private boolean isFilterValidateOnDelay() {
		return Activator.getDefault().getPreferenceStore().getBoolean(IFilterPreferenceConstants.PREF_FILTER_LIVE_VALIDATION);
	}

	/**
	 * Gets the preferences for the stereotype delimiter replacement.
	 */
	private boolean isStereotypeDelimitersReplaced() {
		return Activator.getDefault().getPreferenceStore().getBoolean(IFilterPreferenceConstants.PREF_FILTER_STEREOTYPE_REPLACED);
	}

	/**
	 * Gets the preferences for the validation delay.
	 */
	private int getValidationDelay() {
		return Activator.getDefault().getPreferenceStore().getInt(IFilterPreferenceConstants.PREF_FILTER_VALIDATION_DELAY);
	}

	@Override
	protected CommonViewer createCommonViewer(Composite aParent) {
		CommonViewer viewer = super.createCommonViewer(aParent);
		ViewerColumn column = (ViewerColumn) viewer.getTree().getData(Policy.JFACE + ".columnViewer");//$NON-NLS-1$
		column.setEditingSupport(new DirectEditorEditingSupport(viewer));
		return viewer;
	}

	private TreeItem getTreeItem(MouseEvent e) {
		return ((Tree) e.widget).getItem(new Point(e.x, e.y));
	}


	/**
	 * Return the control used to render this View
	 *
	 * @see org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.IPageBookNestableViewPart#getControl()
	 *
	 * @return the main control of the navigator viewer
	 */
	public Control getControl() {
		return getCommonViewer().getControl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IViewSite site, IMemento aMemento) throws PartInitException {
		super.init(site, aMemento);

		activate();

		// Self-listen for property changes
		addPropertyListener(new IPropertyListener() {

			@Override
			public void propertyChanged(Object source, int propId) {
				switch (propId) {
				case IS_LINKING_ENABLED_PROPERTY:
					// Propagate to other instances
					sharedState.setLinkingEnabled(isLinkingEnabled());
					break;
				}
			}
		});
	}

	/**
	 * {@link ResourceSetListener} to listen and react to changes in the
	 * resource set.
	 */
	private final ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			super.resourceSetChanged(event);
			handleResourceSetChanged(event);
		}
	};

	/** cache variable with last transaction which triggered a refresh */
	private Transaction lastTrans = null;

	/**
	 * Run in a UI thread to avoid non UI thread exception.
	 *
	 * @param event
	 */
	private void handleResourceSetChanged(ResourceSetChangeEvent event) {
		// avoid refreshing N times for the same transaction (called for each object in resource)
		Transaction curTrans = event.getTransaction();
		if (lastTrans != null && lastTrans.equals(curTrans)) {
			return;
		}
		lastTrans = curTrans;

		scheduleRefresh();
	}

	private Runnable refreshRunnable;

	/**
	 * Thread-safe
	 * Schedule a runnable which will refresh the view if necessary
	 */
	protected void scheduleRefresh() {
		final Runnable schedule;

		synchronized (this) {
			if (refreshRunnable == null) {
				// No refresh is yet pending. Schedule one
				schedule = createRefreshRunnable();
				refreshRunnable = schedule;
			} else {
				schedule = null;
			}
		}

		if (schedule != null) {
			Control control = getControl();
			Display display = ((control == null) || control.isDisposed()) ? null : control.getDisplay();

			if (display != null) {
				// Don't need to schedule a refresh if we have no control or it's disposed
				display.asyncExec(schedule);
			}
		}
	}

	private Runnable createRefreshRunnable() {
		return new Runnable() {

			@Override
			public void run() {
				// Only run if I'm still pending
				synchronized (ModelExplorerView.this) {
					if (refreshRunnable != this) {
						return;
					}

					refreshRunnable = null;
				}

				refreshInUIThread();
			}
		};
	}

	/**
	 * Thread-safe method to hurry up a pending refresh of the Model Explorer view (if any), synchronously.
	 * When this method returns, then either the explorer has been refreshed or it doesn't need to be.
	 */
	protected void syncRefresh() {
		final Runnable pending;

		synchronized (this) {
			pending = refreshRunnable;
		}

		if (pending != null) {
			Control control = getControl();
			Display display = ((control == null) || control.isDisposed()) ? null : control.getDisplay();

			if (display != null) {
				// Don't need to execute a refresh if we have no control or it's disposed
				display.syncExec(pending);
			}
		}
	}

	/**
	 * refresh the view.
	 */
	protected void refreshInUIThread() {
		// Need to refresh, even if (temporarily) invisible
		// (Better alternative?: store refresh event and execute once visible again)
		if (getControl().isDisposed()) {
			return;
		}

		// avoid reentrant call
		// Refresh only of we are not already refreshing.
		if (isRefreshing.compareAndSet(false, true)) {
			if (!getCommonViewer().isBusy()) {
				getCommonViewer().refresh();
			}

			isRefreshing.set(false);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getInitialInput() {

		if (serviceRegistry != null) {
			return serviceRegistry;
		} else {
			return super.getInitialInput();
		}

	}

	/**
	 * Activate specified Part.
	 */
	private void activate() {
		try {
			this.editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);

			// Set Viewer input if it already exist
			if (getCommonViewer() != null) {
				getCommonViewer().setInput(serviceRegistry);
			}
			editingDomain.addResourceSetListener(resourceSetListener);
			IReadOnlyHandler2 readOnlyHandler = AdapterUtils.adapt(editingDomain, IReadOnlyHandler2.class, null);
			if (readOnlyHandler != null) {
				readOnlyHandler.addReadOnlyListener(createReadOnlyListener());
			}
		} catch (ServiceException e) {
			// Can't get EditingDomain, skip
		}

		// listen to change events
		getSite().getPage().addSelectionListener(pageSelectionListener);

		// Listen to isDirty flag
		saveAndDirtyService.addInputChangedListener(editorInputChangedListener);

		if (this.getCommonViewer() != null) {
			// Force a refresh
			Display display = getControl().getDisplay();
			if (display == Display.getCurrent()) {
				refreshInUIThread();
			} else {
				// Hmm. We should be on the UI thread
				Activator.log.warn("Model Explorer activated on a non-UI thread."); //$NON-NLS-1$
				scheduleRefresh();
			}
		}

		editingDomain.getCommandStack().addCommandStackListener(commandStackListener);
	}

	/**
	 * Deactivate the Model Explorer.
	 */
	private void deactivate() {
		// deactivate global handler
		if (Activator.log.isDebugEnabled()) {
			Activator.log.debug("deactivate ModelExplorerView"); //$NON-NLS-1$
		}

		try {
			ISashWindowsContainer sashWindowsContainer = serviceRegistry.getService(ISashWindowsContainer.class);
			if (sashWindowsContainer != null) {
				sashWindowsContainer.removePageLifeCycleListener(this);
			}
		} catch (ServiceException ex) {
			// Ignore
		}

		// Stop listening on change events
		getSite().getPage().removeSelectionListener(pageSelectionListener);
		// Stop Listening to isDirty flag
		saveAndDirtyService.removeInputChangedListener(editorInputChangedListener);

		if (editingDomain != null) {
			editingDomain.removeResourceSetListener(resourceSetListener);
			editingDomain.getCommandStack().removeCommandStackListener(commandStackListener);
			editingDomain = null;
		}

		saveAndDirtyService = null;
		undoContext = null;
		editingDomain = null;
		lastTrans = null;
		// a viewerFilter is not necessarily set
		if (viewerFilter != null) {
			viewerFilter.clearCache();
			viewerFilter = null;
		}

		// 574410 - remove listener in dispose (not in deactivate), otherwise it is not
		// available during 2nd and further reloads.
//		reloadableEditor.removeEditorReloadListener(reloadAdapter);
	}

	/**
	 * Invoked internally to clear the common viewer's associate listener in order to promote garbage collection.
	 */
	void aboutToDispose() {
		final CommonViewer viewer = getCommonViewer();
		if ((viewer.getTree() != null) && !viewer.getTree().isDisposed()) {
			viewer.setInput(null);

			// Kick the NavigatorContentService to clear the cache in its StructuredViewerManager that leaks all of our tree elements
			INavigatorContentService contentService = getNavigatorContentService();
			if (contentService instanceof IExtensionActivationListener) {
				((IExtensionActivationListener) getNavigatorContentService()).onExtensionActivation(contentService.getViewerId(), new String[0], false);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {

		// Stop if we are already disposed
		if (isDisposed()) {
			return;
		}

		if ((sharedStateListener != null) && (sharedState != null)) {
			sharedState.removeListener(sharedStateListener);
		}

		if (getSite() != null) {
			getSite().getPage().removeSelectionListener(pageSelectionListener);
		}

		deactivate();

		for (IPropertySheetPage propertySheetPage : this.propertySheetPages) {
			propertySheetPage.dispose();
		}

		propertySheetPages.clear();

		pageSelectionListener = null;

		// 574410 - remove listener in dispose (not in deactivate), otherwise it is not
		// available during 2nd and further reloads.
		reloadableEditor.removeEditorReloadListener(reloadAdapter);

		super.dispose();

		// Clean up properties to help GC

	}

	/**
	 * Return true if the component is already disposed.
	 *
	 * @return
	 */
	public boolean isDisposed() {
		// use editorPart as flag
		return saveAndDirtyService == null;
	}

	/**
	 * Retrieves the {@link IPropertySheetPage} that his Model Explorer uses.
	 *
	 * @return
	 */
	private IPropertySheetPage getPropertySheetPage() {
		try {
			final IMultiDiagramEditor multiDiagramEditor = ServiceUtils.getInstance().getService(IMultiDiagramEditor.class, serviceRegistry);

			if (multiDiagramEditor != null) {
				if (multiDiagramEditor instanceof ITabbedPropertySheetPageContributor) {
					ITabbedPropertySheetPageContributor contributor = (ITabbedPropertySheetPageContributor) multiDiagramEditor;
					IPropertySheetPage propertySheetPage = new TabbedPropertySheetPage(contributor);
					this.propertySheetPages.add(propertySheetPage);
					return propertySheetPage;
				}
			}
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
		return null;
	}

	/**
	 * in order to see element if the property view
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (editingDomain == null) {
			// bug 574410 - don't adapt, if model explorer is deactivated during reload
			return null;
		}
		if (IPropertySheetPage.class.equals(adapter)) {
			return getPropertySheetPage();
		}

		if (IUndoContext.class == adapter) {
			// Return the IUndoContext of associated model.
			return undoContext;
		}

		if (ISaveablePart.class.equals(adapter)) {
			try {
				serviceRegistry = ServiceUtils.getInstance().getServiceRegistry(null);
				return serviceRegistry.getService(IMultiDiagramEditor.class);
			} catch (ServiceException ex) {
				Activator.log.error(ex);
			}
			return saveAndDirtyService;
		}

		if (ServicesRegistry.class == adapter) {
			return serviceRegistry;
		}

		return super.getAdapter(adapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return the EditingDomain used by the properties view
	 */
	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void selectReveal(ISelection selection) {
		syncRefresh();
		if (getCommonViewer() != null) {
			getCommonViewer().setSelection(selection, true);
		}
	}

	@Override
	public void revealSemanticElement(List<?> elementList) {
		// Ensure that the ModelExplorer is refreshed before
		// trying to display an element. Useful if the element has just been created,
		// and the model explorer has not yet been refreshed
		syncRefresh();
		reveal(elementList, getCommonViewer());
	}

	/**
	 * Expands the given CommonViewer to reveal the given elements
	 *
	 * @param elementList
	 *            The elements to reveal
	 * @param commonViewer
	 *            The CommonViewer they are to be revealed in
	 */
	public static void reveal(Iterable<?> elementList, final CommonViewer commonViewer) {
		List<EObject> selectionList = new ArrayList<>();
		for (Object element : elementList) {
			if (element instanceof EObject) {
				selectionList.add((EObject) element);
			}
		}
		if (selectionList.isEmpty()) {
			return;
		}

		Display.getDefault().syncExec(() -> ProviderHelper.selectReveal(selectionList, commonViewer));
	}

	/**
	 * Selects the given ISelection in the given CommonViwer
	 *
	 * @param structuredSelection
	 *            The ISelection to select
	 * @param commonViewer
	 *            The ComonViewer to select it in
	 */
	public static void selectReveal(final ISelection structuredSelection, final Viewer commonViewer) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				commonViewer.setSelection(structuredSelection, true);
			}
		});
	}

	/**
	 * Selects and, if possible, reveals the given ISelection in the given CommonViwer
	 *
	 * @param selection
	 *            The ISelection to select
	 * @param viewer
	 *            The ComonViewer to select it in
	 */
	public static void reveal(final ISelection selection, final CommonViewer viewer) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structured = (IStructuredSelection) selection;
			reveal(Lists.newArrayList(structured.iterator()), viewer);
		} else {
			viewer.getControl().getDisplay().syncExec(new Runnable() {

				@Override
				public void run() {
					viewer.setSelection(selection);
				}
			});
		}
	}

	/**
	 * Edit an element contained on the common viewer.
	 *
	 * @param element
	 *            The element to edit.
	 * @param numColumn
	 *            The number of the column which contains the element to edit.
	 */
	public void editElement(final EObject element, final int numColumn) {
		ModelElementItemMatchingItem modelElementItemMatchingItem = new ModelElementItemMatchingItem(element);
		if (null != modelElementItemMatchingItem) {
			CommonViewer commonViewer = getCommonViewer();
			if (null != commonViewer) {
				commonViewer.getControl().getDisplay().syncExec(new Runnable() {
					@Override
					public void run() {
						commonViewer.editElement(modelElementItemMatchingItem, numColumn);
					}
				});
			}
		}
	}

	@Override
	public void pageOpened(IPage page) {
		refreshTree();
	}

	@Override
	public void pageClosed(IPage page) {
		refreshTree();
	}

	private void refreshTree() {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (getCommonViewer().getControl() == null || getCommonViewer().getControl().isDisposed()) {
					return;
				}
				getCommonViewer().refresh(true);
				// Force redraw to refresh facet overlay
				getCommonViewer().getTree().redraw();
			}
		});
	}

	@Override
	public void pageChanged(IPage newPage) {
		// Nothing
	}

	@Override
	public void pageActivated(IPage page) {
		// Nothing
	}

	@Override
	public void pageDeactivated(IPage page) {
		// Nothing
	}

	@Override
	public void pageAboutToBeOpened(IPage page) {
		// Nothing
	}

	@Override
	public void pageAboutToBeClosed(IPage page) {
		// Nothing
	}

	private IReadOnlyListener createReadOnlyListener() {
		return new IReadOnlyListener() {

			@Override
			public void readOnlyStateChanged(ReadOnlyEvent event) {
				switch (event.getEventType()) {
				case ReadOnlyEvent.RESOURCE_READ_ONLY_STATE_CHANGED:
					scheduleRefresh();
					break;
				case ReadOnlyEvent.OBJECT_READ_ONLY_STATE_CHANGED:
					CommonViewer viewer = getCommonViewer();
					if ((viewer != null) && (viewer.getControl() != null) && !viewer.getControl().isDisposed()) {
						viewer.refresh(event.getObject());
					}
					break;
				default:
					Activator.log.warn("Unsupported read-only event type: " + event.getEventType()); //$NON-NLS-1$
					break;
				}
			}
		};
	}

	void setSharedState(SharedModelExplorerState state) {
		if (this.sharedState != null) {
			this.sharedState.removeListener(getSharedStateListener());
		}

		this.sharedState = state;

		if (state != null) {
			state.addListener(getSharedStateListener());
			initSharedState(state);
		}
	}

	void initSharedState(SharedModelExplorerState state) {
		setLinkingEnabled(state.isLinkingEnabled());
		setAlphaSorted(state.isAlphaSorted());
	}

	void setAlphaSorted(boolean sorted) {
		CommonViewer viewer = getCommonViewer();
		if ((viewer != null) && (viewer.getControl() != null) && !viewer.getControl().isDisposed()) {
			if (sorted) {
				viewer.setSorter(new CommonViewerSorter());
				if (viewer instanceof CustomCommonViewer) {
					((CustomCommonViewer) viewer).getDropAdapter().setFeedbackEnabled(false);
				}
			} else {
				viewer.setSorter(null);
				if (viewer instanceof CustomCommonViewer) {
					((CustomCommonViewer) viewer).getDropAdapter().setFeedbackEnabled(true);
				}
			}
		}
	}

	SharedModelExplorerState.StateChangedListener getSharedStateListener() {
		if (sharedStateListener == null) {
			sharedStateListener = new SharedModelExplorerState.StateChangedListener() {

				private volatile Runnable contentUpdate;

				@Override
				public void sharedStateChanged(StateChangedEvent event) {
					switch (event.getEventType()) {
					case StateChangedEvent.LINKING_ENABLED:
						setLinkingEnabled(event.getSource().isLinkingEnabled());
						break;
					case StateChangedEvent.ALPHA_SORTED:
						setAlphaSorted(event.getSource().isAlphaSorted());
						break;
					case StateChangedEvent.CONTENT_EXTENSIONS:
						if (contentUpdate == null) {
							getCommonViewer().getControl().getDisplay().asyncExec(getContentUpdate());
						}
						break;
					}
				}

				private Runnable getContentUpdate() {
					if (contentUpdate == null) {
						contentUpdate = new Runnable() {

							@Override
							public void run() {
								CommonViewer viewer = getCommonViewer();
								if ((viewer != null) && (viewer.getControl() != null) && !viewer.getControl().isDisposed()) {
									viewer.getNavigatorContentService().getActivationService().activateExtensions(sharedState.getNavigatorContentExtensions(), true);
								}

								// I am no longer pending
								contentUpdate = null;
							}
						};
					}
					return contentUpdate;
				}
			};
		}

		return sharedStateListener;
	}
}