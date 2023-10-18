/*******************************************************************************
 * Copyright (c) 2013, 2019 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *  Obeo - Use Forms and Manage Actions.
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.view;

import java.lang.reflect.Method;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.CollapseAllNodesAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.DebugValidityAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.DisableAllUnusedNodesAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.EnableDisableAllNodesAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.ExpandAllNodesAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.ExportValidationResultAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.FilterValidationResultAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.ForceValidityViewRefreshAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.LockValidatableNodesAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.RunValidityAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.actions.ShowElementInEditorAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.providers.ConstrainingNodeContentProvider;
import org.eclipse.ocl.examples.emf.validation.validity.ui.providers.NodeCheckStateProvider;
import org.eclipse.ocl.examples.emf.validation.validity.ui.providers.NodeLabelProvider;
import org.eclipse.ocl.examples.emf.validation.validity.ui.providers.ValidatableNodeContentProvider;
import org.eclipse.ocl.examples.emf.validation.validity.ui.ripoffs.DecoratingColumnLabelProvider;
import org.eclipse.ocl.examples.emf.validation.validity.ui.ripoffs.FilteredCheckboxTree;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.IVisibilityFilter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.ViewPart;

/**
 * The ValidityView provides a dual view of ValidatableNode model elements and
 * ConstrainingNode model classes to browse, filter and control model validation.
 */
public class ValidityView extends ViewPart implements ISelectionListener
{
	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final @NonNull String ID = "org.eclipse.ocl.examples.emf.validation.validity.ui.validity";//$NON-NLS-1$

	@SuppressWarnings("unused")
	private static org.eclipse.ocl.examples.ui.OCLPropertyTester ensureViewsIdIsreferenced = null;

	/**
	 * ValidityViewLabelProvider extends the standard AdapterFactoryLabelProvider to provide icons for
	 * non-standard Java objects such as Method.
	 */
	public static class ValidityViewLabelProvider extends AdapterFactoryLabelProvider
	{
		public ValidityViewLabelProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		@Override
		protected Image getDefaultImage(Object object) {
			Object image = null;
			if (object instanceof Method) {
				image = EcoreEditPlugin.INSTANCE.getImage("full/obj16/EOperation");
			}
			if (image != null) {
				return ExtendedImageRegistry.INSTANCE.getImage(image);
			} else {
				return super.getDefaultImage(object);
			}
		}
	}

	/**
	 * The ChangeSelectionJob performs the work for a setSelection() without clogging up the UI. Multiple chnages are maintained
	 * in a linked list so that the earlier jobs complete cancelation before another starts.
	 */
	protected class ChangeSelectionJob extends Job
	{
		private final @Nullable Notifier newSelection;
		private @Nullable ChangeSelectionJob replacementJob = null;

		protected ChangeSelectionJob(@Nullable Notifier newSelection) {
			super("Validity View: Change Selection");
			this.newSelection = newSelection;
		}

		public synchronized void cancelThenSchedule(@NonNull ChangeSelectionJob newJob) {
			this.replacementJob = newJob;
			cancel();
		}

		@Override
		protected IStatus run(/*@NonNull*/ IProgressMonitor monitor) {
//			long start = System.currentTimeMillis();
			assert monitor != null;
			try {
				final @SuppressWarnings("null")@NonNull Monitor emfMonitor = BasicMonitor.toMonitor(monitor);
				validityManager.setInput(newSelection, emfMonitor);
				if (!monitor.isCanceled()) {
					initializeFilters();
					ValidityModel model = validityManager.getModel();
					if (model != null) {
						model.refreshModel(null, null);
					}
					Form form = getForm();
					if (!form.isDisposed()) {
						form.getDisplay().asyncExec(new Runnable()
						{
							@Override
							public void run() {
//								long start = System.currentTimeMillis();
								RootNode rootNode = validityManager.getRootNode();
								Object validatableNodesViewerInput = getValidatableNodesViewer().getInput();
								if (validatableNodesViewerInput == null || !validatableNodesViewerInput.equals(rootNode)) {
									if (!emfMonitor.isCanceled()) {
//										System.out.format(Thread.currentThread().getName() + " %3.3f set ValidatableNodes input\n", (System.currentTimeMillis() - start) * 0.001);
										getValidatableNodesViewer().setInput(rootNode);
									}
									if (!emfMonitor.isCanceled()) {
//										System.out.format(Thread.currentThread().getName() + " %3.3f set ConstrainingNodes input\n", (System.currentTimeMillis() - start) * 0.001);
										getConstrainingNodesViewer().setInput(rootNode);
									}
									if (!emfMonitor.isCanceled()) {
//										System.out.format(Thread.currentThread().getName() + " %3.3f set validationRootChanged input\n", (System.currentTimeMillis() - start) * 0.001);
										filteredValidatableNodesTree.resetFilter();
										filteredConstrainingNodesTree.resetFilter();
										validationRootChanged(rootNode);
									}
								}
//								System.out.format(Thread.currentThread().getName() + " %3.3f done\n", (System.currentTimeMillis() - start) * 0.001);
							}
						});
					}
				}
//				System.out.format(Thread.currentThread().getName() + " %3.3f done\n", (System.currentTimeMillis() - start) * 0.001);
				return monitor.isCanceled() ? Status.CANCEL_STATUS : Status.OK_STATUS;
			}
			finally {
				monitor.done();
				synchronized (this) {
					setInputJob = null;
					ChangeSelectionJob replacementJob2 = replacementJob;
					if (replacementJob2 != null) {
						replacementJob2.schedule();
					}
				}
			}
		}
	}

	class DecoratingNodeLabelProvider extends DecoratingColumnLabelProvider
	{
		public DecoratingNodeLabelProvider(@NonNull ILabelProvider nodeLabelProvider) {
			super(nodeLabelProvider, new SeveritiesDecorator(validityManager));
			cellLabelProvider = (CellLabelProvider) nodeLabelProvider;
		}
	}

	protected FilteredCheckboxTree filteredValidatableNodesTree;
	protected FilteredCheckboxTree filteredConstrainingNodesTree;

	private final @NonNull ValidityViewRefreshJob refreshJob = new ValidityViewRefreshJob();

	protected final @NonNull IDEValidityManager validityManager;

	/** Keeps a reference to the toolkit used to create our form. */
	private FormToolkit formToolkit;

	/** Form that will contain the Validity View itself. */
	private Form validityViewForm;

	/** Allows us to display error/warning messages directly on the form. */
	private FormMessageManager messageManager;

	/** Form that will contain the Validatable column View. */
	private SashForm validateableElementsForm;

	/** Form that will contain the Constraining column View. */
	private SashForm constrainingElementsForm;

	/** We'll create this {@link SashForm} as the main body of the Validity view form. */
	private SashForm formBody;

	/**
	 * Keeps a reference to the "validateable Elements" section of the Validity view form.
	 */
	private Section validatableNodesSection;

	/** The message key. */
	private final String messageKey = "ValidityViewMessageKey";

	/** Kept as an instance member, this will allow us to set unique identifiers to the status messages. */
	private int messageCount;

	/**
	 * Keeps a reference to the "constraining Nodes" section of the Validity view form.
	 */
	private Section constrainingNodesSection;

	protected ResourceSet modelResourceSet;

	/**Context Menu.*/
	private ShowElementInEditorAction showValidatableElementInEditorAction;
	private ShowElementInEditorAction showConstrainingElementInEditorAction;

	/**Local Tool Bar.*/
	private Action expandAllNodesAction;
	private Action collapseAllNodesAction;
	private Action runValidationAction;
	private Action runValidatableAction;
	private Action runConstrainingAction;
	private Action debugValidatableResultAction;
	private Action debugConstrainingResultAction;
	private Action lockValidatableNodesAction;
	private Action forceValidityViewRefreshAction;
	private Action exportValidationResultAction;
	private IAction filterValidationResultAction;

	/**Validatable Tool Bar.*/
	private Action expandAllValidatableNodesAction;
	private Action collapseAllValidatableNodesAction;
	private Action enableAllValidatableNodesAction;
	private Action disableAllValidatableNodesAction;
	private DisableAllUnusedNodesAction disableAllUnusedValidatableNodesAction;

	/**Constraining Tool Bar.*/
	private Action expandAllConstrainingNodesAction;
	private Action collapseAllConstrainingNodesAction;
	private Action enableAllConstrainingNodesAction;
	private Action disableAllConstrainingNodesAction;
	private DisableAllUnusedNodesAction disableAllUnusedConstrainingNodesAction;

	/** Double Click action handlers.*/
	private Action constrainingNodesDoubleClickAction;
	private Action validatableNodesDoubleClickAction;

	/** Selection */
	private @Nullable IWorkbenchPart currentPart;
	private @Nullable ISelection currentSelection;
	private @Nullable Notifier selection = null;
	private @Nullable ChangeSelectionJob setInputJob = null;

	public ValidityView() {
		validityManager = new IDEValidityManager(refreshJob);
		modelResourceSet = new ResourceSetImpl();
	}

	public void addFilter(boolean isValidatableFilterAction, @NonNull IVisibilityFilter filter) {
		if (isValidatableFilterAction) {
			validityManager.addValidatableFilter(filter);
		}
		else {
			validityManager.addConstrainingFilter(filter);
		}
		redraw();
	}

	public void addFilteredSeverity(@NonNull Severity severity) {
		validityManager.addFilteredSeverity(severity);
		redraw();
	}

	private void contributeToActionBars() {
		IToolBarManager toolBarManager = getForm().getToolBarManager();
		fillLocalToolBar(toolBarManager);

		// validatable Column
		ToolBarManager validatableSectionToolBarManager = createSectionToolBar(validatableNodesSection);
		fillValidatableColumnToolBar(validatableSectionToolBarManager);

		// constraining Column
		ToolBarManager constrainingSectionToolBarManager = createSectionToolBar(constrainingNodesSection);
		fillConstrainingColumnToolBar(constrainingSectionToolBarManager);
	}

	/**
	 * Creates a tool bar for the given section.
	 *
	 * @param section
	 *            The section for which we need a tool bar.
	 * @return The created tool bar.
	 */
	protected static final ToolBarManager createSectionToolBar(Section section) {
		final ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT | SWT.HORIZONTAL);
		final ToolBar toolBar = toolBarManager.createControl(section);

		final Cursor handCursor = new Cursor(Display.getCurrent(), SWT.CURSOR_HAND);
		toolBar.setCursor(handCursor);
		// Cursor needs to be explicitly disposed
		toolBar.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (!handCursor.isDisposed()) {
					handCursor.dispose();
				}
			}
		});

		section.setTextClient(toolBar);
		toolBar.setData(toolBarManager);
		// Do not keep a reference to the manager when we dispose the tool bar
		toolBar.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				toolBar.setData(null);
			}
		});

		return toolBarManager;
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
	    Composite sash = new SashForm(parent, SWT.HORIZONTAL);
		formToolkit = new FormToolkit(sash.getDisplay());
		createValidityViewForm(formToolkit, sash);
	}

	/**
	 * This will be called in order to create the actual body of the validity view, the "Validity" form.
	 *
	 * @param toolkit
	 *            Toolkit that can be used to create the form.
	 * @param parent
	 *            Parent composite of the form.
	 */
	protected void createValidityViewForm(FormToolkit toolkit, Composite parent){

		Color blackColor = parent.getDisplay().getSystemColor(SWT.COLOR_BLACK);
		Color blueColor = parent.getDisplay().getSystemColor(SWT.COLOR_BLUE);
	    ILabelProvider labelProvider = new ValidityViewLabelProvider(validityManager.getAdapterFactory());
		ILabelProvider nodeLabelProvider = new NodeLabelProvider(labelProvider, blackColor, blueColor);
		IContentProvider validatableContentProvider = new ValidatableNodeContentProvider(validityManager);
		IContentProvider constrainingNodeContentProvider = new ConstrainingNodeContentProvider(validityManager);
		ICheckStateProvider nodeCheckStateProvider = new NodeCheckStateProvider();
	    ILabelProvider nodeDecoratingLabelProvider = new DecoratingNodeLabelProvider(nodeLabelProvider);

		validityViewForm = toolkit.createForm(parent);
		messageManager = new FormMessageManager(getForm());
		messageManager.setDecorationPosition(SWT.LEFT | SWT.TOP);
		toolkit.decorateFormHeading(getForm());

		getForm().setText(ValidityUIMessages.ValidityView_viewTitle);
		messageManager.addMessage(messageKey + messageCount++, ValidityUIMessages.ValidityView_Messages_NoSelection, IStatus.WARNING, getForm());

		Composite mainBody = getForm().getBody();
		mainBody.setLayout(new GridLayout());
		formBody = new SashForm(mainBody, SWT.HORIZONTAL | SWT.SMOOTH);
		toolkit.adapt(formBody);
		formBody.setLayoutData(new GridData(GridData.FILL_BOTH));

		validateableElementsForm = new SashForm(formBody, SWT.VERTICAL | SWT.SMOOTH);
		toolkit.adapt(validateableElementsForm);

		validatableNodesSection = toolkit.createSection(validateableElementsForm, ExpandableComposite.TITLE_BAR);
		validatableNodesSection.setText(ValidityUIMessages.ValidityView_validatableNodesSectionName);

		CheckboxTreeViewer validatableNodesViewer;
		{
			Composite validatableNodesSectionBody = toolkit.createComposite(validatableNodesSection);
			{
				GridLayout layout = new GridLayout(1, true);
				layout.marginBottom = 0;
				layout.marginLeft = 0;
				layout.marginRight = 0;
				layout.marginTop = 0;
				validatableNodesSectionBody.setLayout(layout);
				GridData gridData = new GridData(GridData.FILL_BOTH);
				gridData.grabExcessHorizontalSpace = true;
				gridData.grabExcessVerticalSpace = true;
				validatableNodesSectionBody.setLayoutData(gridData);
			}

			PatternFilter filter = new PatternFilter();
			filteredValidatableNodesTree = new FilteredCheckboxTree(validatableNodesSectionBody, SWT.CHECK | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL, filter);
			filteredValidatableNodesTree.disableTextWidget();
			filteredValidatableNodesTree.getViewer().setUseHashlookup(true);

			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.grabExcessHorizontalSpace = true;
			gridData.grabExcessVerticalSpace = true;
			filteredValidatableNodesTree.setLayoutData(gridData);

			validatableNodesViewer = getValidatableNodesViewer();
			validatableNodesViewer.getControl().setLayoutData(gridData);

			toolkit.paintBordersFor(validatableNodesSectionBody);
			validatableNodesSection.setClient(validatableNodesSectionBody);
		}

		constrainingElementsForm = new SashForm(formBody, SWT.VERTICAL | SWT.SMOOTH);
		toolkit.adapt(constrainingElementsForm);

		constrainingNodesSection = toolkit.createSection(constrainingElementsForm, ExpandableComposite.TITLE_BAR);
		constrainingNodesSection.setText(ValidityUIMessages.ValidityView_constrainingNodesSectionName);

		CheckboxTreeViewer constrainingNodesViewer;
		{
			Composite constrainingNodesSectionBody = toolkit.createComposite(constrainingNodesSection);
			{
				GridLayout layout = new GridLayout(1, true);
				layout.marginBottom = 0;
				layout.marginLeft = 0;
				layout.marginRight = 0;
				layout.marginTop = 0;
				constrainingNodesSectionBody.setLayout(layout);
				GridData gridData = new GridData(GridData.FILL_BOTH);
				gridData.grabExcessHorizontalSpace = true;
				gridData.grabExcessVerticalSpace = true;
				constrainingNodesSectionBody.setLayoutData(gridData);
			}

			PatternFilter filter = new PatternFilter();
			filteredConstrainingNodesTree = new FilteredCheckboxTree(constrainingNodesSectionBody, SWT.CHECK | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL, filter);
			filteredConstrainingNodesTree.disableTextWidget();
			filteredConstrainingNodesTree.getViewer().setUseHashlookup(true);

			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.grabExcessHorizontalSpace = true;
			gridData.grabExcessVerticalSpace = true;
			filteredConstrainingNodesTree.setLayoutData(gridData);

			constrainingNodesViewer = getConstrainingNodesViewer();
			constrainingNodesViewer.getControl().setLayoutData(gridData);

			toolkit.paintBordersFor(constrainingNodesSectionBody);
			constrainingNodesSection.setClient(constrainingNodesSectionBody);
		}
		ICheckStateListener nodeCheckStateListener = new ValidityNodeCheckStateListener(this);
		validatableNodesViewer.setContentProvider(validatableContentProvider);
		validatableNodesViewer.setLabelProvider(nodeDecoratingLabelProvider);
		validatableNodesViewer.setCheckStateProvider(nodeCheckStateProvider);
		validatableNodesViewer.addCheckStateListener(nodeCheckStateListener);
//		validatableNodesViewer.addFilter(validatableNodesFilterByKind);

		constrainingNodesViewer.setContentProvider(constrainingNodeContentProvider);
		constrainingNodesViewer.setLabelProvider(nodeDecoratingLabelProvider);
		constrainingNodesViewer.setCheckStateProvider(nodeCheckStateProvider);
		constrainingNodesViewer.addCheckStateListener(nodeCheckStateListener);
//		constrainingNodesViewer.addFilter(constrainingNodesFilterByKind);

		formBody.setWeights(new int[] {1, 1, });

		// Create the help context id for the viewer's control
		makeActions();
		hookContextMenu();
		hookConstrainingNodesDoubleClickAction();
		hookValidatableNodesDoubleClickAction();
		contributeToActionBars();

		IWorkbenchPage page = getSite().getPage();
		assert page != null;

		ISelectionService service = getSite().getService(ISelectionService.class);
		if (service != null) {
			IEditorPart activeEditor = page.getActiveEditor();
			service.addSelectionListener(this);
			ISelectionProvider selectionProvider = getSite().getSelectionProvider();
			if ((selectionProvider == null) && (activeEditor != null)) {
				selectionProvider = activeEditor.getSite().getSelectionProvider();
			}
			if (selectionProvider != null) {
				ISelection selectionFromProvider = selectionProvider.getSelection();
				selectionChanged(activeEditor, selectionFromProvider);
			}
		}
		refreshJob.initViewers(this, validatableNodesViewer, constrainingNodesViewer);
		Dialog.applyDialogFont(parent);

		ColumnViewerToolTipSupport.enableFor(validatableNodesViewer);
		ColumnViewerToolTipSupport.enableFor(constrainingNodesViewer);
	}

	/**
	 * Return the most recent selection as IResource, if it can be converted possibly by resolving the Resource of an EObject.
	 */
	public @Nullable IResource getSelectedResource() {
		Object selection = null;
		ISelection currentSelection2 = currentSelection;
		if (currentSelection2 != null) {
			selection = SelectionUtil.getNotifierSelection(currentSelection2, currentPart);
			if ((selection == null) && (currentSelection2 instanceof IStructuredSelection)) {
				selection = ((IStructuredSelection)currentSelection2).getFirstElement();
			}
		}
		if (selection != null) {
			if (selection instanceof IAdaptable) {
				IAdaptable selection2 = (IAdaptable)selection;
				Object adapted = ClassUtil.getAdapter(selection2, EObject.class);
				if (adapted == null) {
					adapted = ClassUtil.getAdapter(selection2, Resource.class);
					if (adapted == null) {
						adapted = ClassUtil.getAdapter(selection2, IResource.class);
					}
				}
				if (adapted != null) {
					selection = adapted;
				}
			}
			if (selection instanceof EObject) {
				selection = ((EObject)selection).eResource();
			}
			if (selection instanceof Resource) {
				URI resourceURI = ((Resource)selection).getURI();
				if ((resourceURI != null) && resourceURI.isPlatform()) {
					IPath resourcePath = new Path(resourceURI.toPlatformString(true));
					selection = ResourcesPlugin.getWorkspace().getRoot().getFile(resourcePath);
				}
			}
		}
		return selection instanceof IResource ? (IResource)selection : null;
	}

	/**
	 * Returns the validity view form.
	 *
	 * @return The validity view form.
	 */
	protected Form getForm() {
		return validityViewForm;
	}

	@Override
	public void dispose() {
		ISelectionService service = getSite().getService(ISelectionService.class);
		if (service != null) {
			service.removeSelectionListener(this);
		}
		filteredValidatableNodesTree.dispose();
		filteredConstrainingNodesTree.dispose();
		super.dispose();
	}

	private void fillConstrainingColumnToolBar(IContributionManager manager) {
		manager.add(expandAllConstrainingNodesAction);
		manager.add(collapseAllConstrainingNodesAction);
		manager.add(new Separator());
		manager.add(enableAllConstrainingNodesAction);
		manager.add(disableAllConstrainingNodesAction);
		manager.add(new Separator());
		manager.add(disableAllUnusedConstrainingNodesAction);

		manager.update(true);
	}

	private void fillConstrainingContextMenu(@NonNull IContributionManager manager) {
		manager.add(expandAllConstrainingNodesAction);
		manager.add(collapseAllConstrainingNodesAction);
		manager.add(new Separator());
		// Use the same actions as the column tool bar
		manager.add(enableAllConstrainingNodesAction);
		manager.add(disableAllConstrainingNodesAction);
		manager.add(new Separator());
		manager.add(disableAllUnusedConstrainingNodesAction);

		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		manager.add(new Separator());
		manager.add(runConstrainingAction);
		manager.add(debugConstrainingResultAction);
		manager.add(new Separator());
		manager.add(showConstrainingElementInEditorAction);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(expandAllNodesAction);
		manager.add(collapseAllNodesAction);
		manager.add(new Separator());
		manager.add(lockValidatableNodesAction);
		manager.add(forceValidityViewRefreshAction);
		manager.add(runValidationAction);
//		manager.add(debugValidationAction);
		manager.add(new Separator());
		manager.add(filterValidationResultAction);
		manager.add(new Separator());
		manager.add(exportValidationResultAction);

		manager.update(true);
	}

	private void fillValidatableColumnToolBar(IContributionManager manager) {
		manager.add(expandAllValidatableNodesAction);
		manager.add(collapseAllValidatableNodesAction);
		manager.add(new Separator());
		manager.add(enableAllValidatableNodesAction);
		manager.add(disableAllValidatableNodesAction);
		manager.add(new Separator());
		manager.add(disableAllUnusedValidatableNodesAction);

		manager.update(true);
	}

	private void fillValidatableContextMenu(@NonNull IContributionManager manager) {
		manager.add(expandAllValidatableNodesAction);
		manager.add(collapseAllValidatableNodesAction);
		manager.add(new Separator());
		// use the same actions as the column tool bar
		manager.add(enableAllValidatableNodesAction);
		manager.add(disableAllValidatableNodesAction);
		manager.add(new Separator());
		manager.add(disableAllUnusedValidatableNodesAction);

		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		manager.add(new Separator());
		manager.add(runValidatableAction);
		manager.add(debugValidatableResultAction);
		manager.add(new Separator());
		manager.add(showValidatableElementInEditorAction);
	}

	/**
	 * gets the Constraining Nodes Viewer
	 *
	 * @return the constrainingNodesViewer
	 */
	public @NonNull CheckboxTreeViewer getConstrainingNodesViewer(){
		CheckboxTreeViewer viewer = (CheckboxTreeViewer) filteredConstrainingNodesTree.getViewer();
		// a filtered tree never has a null viewer
		assert viewer != null;
		return viewer;
	}

	/**
	 * gets the Validity Manager
	 *
	 * @return the validityManager
	 */
	public @NonNull IDEValidityManager getValidityManager(){
		return validityManager;
	}

	/**
	 * gets the validatable Nodes Viewer
	 *
	 * @return the validatableNodesViewer
	 */
	public @NonNull CheckboxTreeViewer getValidatableNodesViewer(){
		CheckboxTreeViewer viewer = (CheckboxTreeViewer) filteredValidatableNodesTree.getViewer();
		// a filtered tree never has a null viewer
		assert viewer != null;
		return viewer;
	}

	private void hookContextMenu() {
		// Validatable context menu
		MenuManager menuMgrValidatable = new MenuManager("#PopupMenu");//$NON-NLS-1$
		menuMgrValidatable.setRemoveAllWhenShown(true);
		menuMgrValidatable.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				@SuppressWarnings("null")@NonNull IMenuManager manager2 = manager;
				ValidityView.this.fillValidatableContextMenu(manager2);
			}
		});
		Menu menuValidatable = menuMgrValidatable.createContextMenu(getValidatableNodesViewer().getControl());
		getValidatableNodesViewer().getControl().setMenu(menuValidatable);
		getSite().registerContextMenu(menuMgrValidatable, getValidatableNodesViewer());

		// Constraining context menu
		MenuManager menuMgrConstraining = new MenuManager("#PopupMenu");//$NON-NLS-1$
		menuMgrConstraining.setRemoveAllWhenShown(true);
		menuMgrConstraining.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				@SuppressWarnings("null")@NonNull IMenuManager manager2 = manager;
				ValidityView.this.fillConstrainingContextMenu(manager2);
			}
		});
		Menu menuConstraining = menuMgrConstraining.createContextMenu(getConstrainingNodesViewer().getControl());
		getConstrainingNodesViewer().getControl().setMenu(menuConstraining);
		getSite().registerContextMenu(menuMgrConstraining, getConstrainingNodesViewer());
	}

	private void hookConstrainingNodesDoubleClickAction() {
		getConstrainingNodesViewer().addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				constrainingNodesDoubleClickAction.run();
			}
		});
	}

	private void hookValidatableNodesDoubleClickAction() {
		getValidatableNodesViewer().addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				validatableNodesDoubleClickAction.run();
			}
		});
	}

	protected void initializeFilters() {
		disableAllUnusedConstrainingNodesAction.refreshChecked();
		disableAllUnusedValidatableNodesAction.refreshChecked();
	}

	private void makeActions() {
		lockValidatableNodesAction = new LockValidatableNodesAction();
		forceValidityViewRefreshAction = new ForceValidityViewRefreshAction(validityManager, this);
		showValidatableElementInEditorAction = new ShowElementInEditorAction(validityManager, getValidatableNodesViewer());
		showConstrainingElementInEditorAction = new ShowElementInEditorAction(validityManager, getConstrainingNodesViewer());

		/*Toolbar actions*/
		expandAllNodesAction = new ExpandAllNodesAction(this, true, true);
		collapseAllNodesAction = new CollapseAllNodesAction(this, true, true);
		runValidationAction = new RunValidityAction(this, null);
		runValidatableAction = new RunValidityAction(this, getValidatableNodesViewer());
		runConstrainingAction = new RunValidityAction(this, getConstrainingNodesViewer());
		debugValidatableResultAction = new DebugValidityAction(this, getValidatableNodesViewer());
		debugConstrainingResultAction = new DebugValidityAction(this, getConstrainingNodesViewer());

		exportValidationResultAction = new ExportValidationResultAction(validityManager, this);
		filterValidationResultAction = new FilterValidationResultAction(this);

		/* Validatable Tool bar actions*/
		expandAllValidatableNodesAction = new ExpandAllNodesAction(this, true, false);
		collapseAllValidatableNodesAction = new CollapseAllNodesAction(this, true, false);
		enableAllValidatableNodesAction = new EnableDisableAllNodesAction(this, true, true);
		disableAllValidatableNodesAction = new EnableDisableAllNodesAction(this, false, true);
		disableAllUnusedValidatableNodesAction = new DisableAllUnusedNodesAction(this, true);

		/* Constraining Tool bar actions*/
		expandAllConstrainingNodesAction = new ExpandAllNodesAction(this, false, true);
		collapseAllConstrainingNodesAction = new CollapseAllNodesAction(this, false, true);
		enableAllConstrainingNodesAction = new EnableDisableAllNodesAction(this, true, false);
		disableAllConstrainingNodesAction = new EnableDisableAllNodesAction(this, false, false);
		disableAllUnusedConstrainingNodesAction = new DisableAllUnusedNodesAction(this, false);

		/*Double Click actions*/
		constrainingNodesDoubleClickAction = new Action() {
			@Override
			public void run() {
				ISelection selection = getConstrainingNodesViewer().getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if (obj instanceof ResultConstrainingNode) {
					ResultValidatableNode resultValidatableNode = ((ResultConstrainingNode)obj).getResultValidatableNode();
					getValidatableNodesViewer().setSelection(new StructuredSelection(resultValidatableNode), true);
				}
/*				else if (obj instanceof ConstrainingNode) {
					Set<Object> expanded = new LinkedHashSet<Object>(Arrays.asList(getConstrainingNodesViewer().getExpandedElements()));
					if (expanded.contains(obj)) {
						getConstrainingNodesViewer().setExpandedState(obj, false);
					} else {
						getConstrainingNodesViewer().setExpandedState(obj, true);
					}
				} */
			}
		};
		validatableNodesDoubleClickAction = new Action() {
			@Override
			public void run() {
				ISelection selection = getValidatableNodesViewer().getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				if (obj instanceof ResultValidatableNode) {
					ResultConstrainingNode resultConstrainingNode = ((ResultValidatableNode) obj).getResultConstrainingNode();
					getConstrainingNodesViewer().setSelection(new StructuredSelection(resultConstrainingNode), true);
				}
/*				else if (obj instanceof ValidatableNode) {
					Set<Object> expanded = new LinkedHashSet<Object>(Arrays.asList(getValidatableNodesViewer().getExpandedElements()));
					if (expanded.contains(obj)) {
						getValidatableNodesViewer().setExpandedState(obj, false);
					} else {
						getValidatableNodesViewer().setExpandedState(obj, true);
					}
				} */
			}
		};
	}

	/**
	 * Schedule a redraw of validatable and constraining trees.
	 */
	public synchronized void redraw() {
		validityManager.redraw();
	}

	public void removeFilter(boolean isValidatableFilterAction, @NonNull IVisibilityFilter filter) {
		if (isValidatableFilterAction) {
			validityManager.removeValidatableFilter(filter);
		}
		else {
			validityManager.removeConstrainingFilter(filter);
		}
		redraw();
	}

	public void removeFilteredSeverity(@NonNull Severity severity) {
		validityManager.removeFilteredSeverity(severity);
		redraw();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		currentPart = part;
		currentSelection = selection;
		if (lockValidatableNodesAction.isChecked()) {
			return;
		}
		if (part instanceof EditorPart){
			Notifier input = SelectionUtil.getNotifierSelection(selection, part);
			if (input instanceof EObject) {
				Resource resource = ((EObject)input).eResource();
				if (resource != null) {
					input = resource;
				}
			}
			if (input instanceof Resource) {
				ResourceSet resourceSet = ((Resource)input).getResourceSet();
				if (resourceSet != null) {
					input = resourceSet;
				}
			}
			setSelection(input);
		}
	}

	protected synchronized void setSelection(final Notifier newSelection) {
		if (newSelection != selection) {
			selection = newSelection;
			ChangeSelectionJob oldJob = setInputJob;
			ChangeSelectionJob newJob = setInputJob = new ChangeSelectionJob(newSelection);
			if (oldJob != null) {
				oldJob.cancelThenSchedule(newJob);
			}
			else {
				newJob.schedule();
			}
		}
	}

	private void validationRootChanged(RootNode rootNode) {
		messageManager.removeMessages(getForm());

		String currentMessagekey = null;
		String currentMessageText = null;
		int currentStatus = 0;
		if (rootNode != null) {
			if (rootNode.getValidatableNodes().isEmpty()) {
				filteredValidatableNodesTree.disableTextWidget();

				currentMessagekey = messageKey + messageCount++;
				currentMessageText = ValidityUIMessages.ValidityView_Messages_NoModelElement;
				currentStatus = IStatus.INFO;
			} else {
				filteredValidatableNodesTree.enableTextWidget();
			}
			if (rootNode.getConstrainingNodes().isEmpty()) {
				filteredConstrainingNodesTree.disableTextWidget();

				currentMessagekey = messageKey + messageCount++;
				currentMessageText = ValidityUIMessages.ValidityView_Messages_NoConstraints;
				currentStatus = IStatus.WARNING;
			} else {
				filteredConstrainingNodesTree.enableTextWidget();
			}
		} else {
			filteredValidatableNodesTree.disableTextWidget();
			filteredConstrainingNodesTree.disableTextWidget();

			currentMessagekey = messageKey + messageCount++;
			currentMessageText = ValidityUIMessages.ValidityView_Messages_NoSelection;
			currentStatus = IStatus.WARNING;
		}

		if (currentMessagekey != null) {
			messageManager.addMessage(currentMessagekey, currentMessageText, currentStatus, getForm());
		}
	}

	/**
	 * Passing the focus request to the viewer's control. This will Refresh the
	 * viewers contents.
	 */
	@Override
	public void setFocus() {
		getValidatableNodesViewer().getControl().setFocus();

		// Refresh the view
		filteredValidatableNodesTree.resetFilter();
		filteredConstrainingNodesTree.resetFilter();
	}
}
