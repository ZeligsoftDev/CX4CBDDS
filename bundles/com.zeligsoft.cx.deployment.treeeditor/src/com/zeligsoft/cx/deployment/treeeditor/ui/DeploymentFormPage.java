/**
 * Copyright 2018 ADLINK Technology Limited.
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

package com.zeligsoft.cx.deployment.treeeditor.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.codegen.ui.providers.GenerateActionProvider;
import com.zeligsoft.cx.deployment.treeeditor.DeploymentEditorPopupMenuRegistryReader;
import com.zeligsoft.cx.deployment.treeeditor.DeploymentEditorPopupMenuRegistryReader.DeploymentEditorPopupMenuRegistry;
import com.zeligsoft.cx.deployment.treeeditor.DeploymentView;
import com.zeligsoft.cx.deployment.treeeditor.actions.AbstractDeploymetEditorPopupAction;
import com.zeligsoft.cx.deployment.treeeditor.actions.DeleteDeploymentPartAction;
import com.zeligsoft.cx.deployment.treeeditor.actions.ExpandAllAction;
import com.zeligsoft.cx.deployment.treeeditor.actions.ShowInDeployPaneAction;
import com.zeligsoft.cx.deployment.treeeditor.actions.ShowInProjectExplorerAction;
import com.zeligsoft.cx.deployment.treeeditor.actions.UndeployAction;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.treeeditor.listeners.LeftTreeListener;
import com.zeligsoft.cx.deployment.treeeditor.listeners.RightTreeListener;
import com.zeligsoft.cx.deployment.treeeditor.providers.DeploymentPartValidationObserver;
import com.zeligsoft.cx.deployment.treeeditor.providers.LeftTreeContentProvider;
import com.zeligsoft.cx.deployment.treeeditor.providers.LeftTreeLabelProvider;
import com.zeligsoft.cx.deployment.treeeditor.providers.RightTreeContentProvider;
import com.zeligsoft.cx.deployment.treeeditor.providers.RightTreeLabelProvider;

/**
 * This is the deployment editor page. This is where the two trees are created.
 * The actions such as delete, undo and redo are also created here.
 * 
 * @author sduchesneau
 * 
 */
public class DeploymentFormPage extends FormPage implements
		ISelectionChangedListener, IValidationListener {

	private static final String NAVIGATE_GROUP_ID = "navigateGroupID"; //$NON-NLS-1$
	private static final String EDIT_GROUP_ID = "editGroupID"; //$NON-NLS-1$

	protected static final String TREE_ITEM = "TREE_ITEM";//$NON-NLS-1$

	private PageForm pageForm;

	private Component deployment;

	private TransactionalEditingDomain domain;

	private DeploymentView view;

	// shared context for undo/redo
	private IUndoContext undoContext;

	// global actions
	private UndoActionHandler undoAction;
	private RedoActionHandler redoAction;

	// left tree actions
	private ExpandAllAction leftExpandAllAction;
	private ShowInProjectExplorerAction leftShowInProjectExplorerAction;
	private ShowInDeployPaneAction showInDeployPaneAction;
	private DeleteDeploymentPartAction deleteAction;

	// right tree actions
	private ExpandAllAction rightExpandAllAction;
	private UndeployAction rightUndeployAction;
	private ShowInProjectExplorerAction rightShowInProjectExplorerAction;

	// the inputs to the trees
	private Object leftTreeInput;
	private Object rightTreeInput;

	// left label
	Section leftSection;
	Section rightSection;

	// left tree
	private Tree leftTree;
	private TreeViewer leftTreeViewer;
	private LeftTreeListener leftTreeListener;
	private ITreeContentProvider leftTreeContentProvider;
	private ILabelProvider leftTreeLabelProvider;
	private List<TreeViewer> viewers = new ArrayList<TreeViewer>();

	// right tree
	private Tree rightTree;
	private TreeViewer rightTreeViewer;
	private RightTreeListener rightTreeListener;
	private RightTreeContentProvider rightTreeContentProvider;
	private ILabelProvider rightTreeLabelProvider;
	
	private static int INITIAL_EXPAND_LEVEL = 3;
	
	// this variable shouldn't exist but it does, it is used to transfer the
	// drag data between the two trees
	public Object dragData;

	// the sash used to separate the two trees
	private Sash verticalSash;

	private GenerateActionProvider actionGroup;

	private MenuManager generateMenuMgr = new MenuManager(
			DeploymentEditorMessages.DeploymentFormPage_ZeligsoftGenDlg);


	private Display display = Display.getCurrent();


	
	/**
	 * The constructor
	 * 
	 * @param editor
	 *            this is the editor that uses this page
	 * @param id
	 *            the id of this page
	 * @param title
	 *            the title of this page
	 * @param deployment
	 *            the deployment that is used by this page
	 */
	public DeploymentFormPage(FormEditor editor, String id, String title,
			Component deployment) {

		super(editor, id, title);
		this.deployment = deployment;
		this.domain = TransactionUtil.getEditingDomain(deployment);
		DeploymentPartValidationObserver.addListener(this);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.editor.FormPage#createFormContent(org.eclipse.ui
	 * .forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();

		//
		leftTreeContentProvider = new LeftTreeContentProvider();
		leftTreeLabelProvider = new LeftTreeLabelProvider();

		rightTreeContentProvider = new RightTreeContentProvider();
		rightTreeLabelProvider = new RightTreeLabelProvider(JFaceResources
				.getDefaultFont());

		view = new DeploymentView(deployment);
		view.init();
		view.addListener(rightTreeContentProvider);

		leftTreeInput = deployment;
		rightTreeInput = view;

		createTreeEditor(form.getBody(), toolkit);
		viewers.add(leftTreeViewer);
		viewers.add(rightTreeViewer);

		createActions();

		fillGenerateContextMenu(generateMenuMgr);
		createLeftContextMenu();
		createRightContextMenu();

	}

	/**
	 * Get the tree editor action with given id
	 * 
	 * @param workbenchActionId
	 * @return
	 */
	public IAction getTreeEditorAction(String workbenchActionId) {
		if (ActionFactory.UNDO.getId().equals(workbenchActionId))
			return undoAction;
		if (ActionFactory.REDO.getId().equals(workbenchActionId))
			return redoAction;
	    if (ActionFactory.DELETE.getId().equals(workbenchActionId))
		 return deleteAction;
		return null;
	}

	/**
	 * Creates the undo and redo actions
	 */
	private void createActions() {
		undoContext = new EditingDomainUndoContext(domain);

		// create global actions
		undoAction = new UndoActionHandler(getSite(), undoContext);
		redoAction = new RedoActionHandler(getSite(), undoContext);

		// create left menu actions
		leftExpandAllAction = new ExpandAllAction(leftTreeViewer);
		leftShowInProjectExplorerAction = new ShowInProjectExplorerAction(
				getSite().getWorkbenchWindow(), leftTreeViewer);
		showInDeployPaneAction = new ShowInDeployPaneAction(
				leftTreeViewer, rightTreeViewer);
		leftTreeViewer.addSelectionChangedListener(showInDeployPaneAction);
		deleteAction = new DeleteDeploymentPartAction(viewers, 
				view);

		// create right menu actions
		rightExpandAllAction = new ExpandAllAction(rightTreeViewer);
		rightUndeployAction = new UndeployAction(rightTreeViewer, view);
		rightShowInProjectExplorerAction = new ShowInProjectExplorerAction(
				getSite().getWorkbenchWindow(), rightTreeViewer);

	}

	private void createLeftContextMenu() {
		IMenuListener menuListener = new IMenuListener() {

			@Override
			public void menuAboutToShow(IMenuManager manager) {
				fillLeftContextMenu(manager);
			}
		};

		MenuManager menuMgr = new MenuManager("#LeftPopupMenu"); //$NON-NLS-1$

		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(menuListener);

		Menu menu = menuMgr.createContextMenu(leftTree);
		leftTree.setMenu(menu);
		getSite().registerContextMenu(menuMgr, leftTreeViewer);

	}

	private List<String> getZDLProfiles() {

		List<String> profiles = new ArrayList<String>();
		for (Profile profile : ZDLUtil.getZDLProfiles(deployment)) {
			profiles.add(profile.getName());
		}
		return profiles;
	}
	
	private void fillLeftContextMenu(IMenuManager menuMgr) {

		menuMgr.add(new Separator(NAVIGATE_GROUP_ID));
		menuMgr.add(new Separator(EDIT_GROUP_ID));

		menuMgr.appendToGroup(NAVIGATE_GROUP_ID, leftExpandAllAction);

		for (DeploymentEditorPopupMenuRegistry registry : DeploymentEditorPopupMenuRegistryReader.INSTANCE
				.getMenuContributions()) {
			if (getZDLProfiles().contains(registry.getDomain())) {
				if (registry.isShowOnConfiguration()) {
					AbstractDeploymetEditorPopupAction action = registry.getAction();
					action.setText(registry.getName());
					action.setViewer(leftTreeViewer);
					action.setDeploymentView(view);
					menuMgr.appendToGroup(EDIT_GROUP_ID, action);
				}
			}
		}
		
		MenuManager showInMenuMgr = new MenuManager(
				DeploymentEditorMessages.DeploymentFormPage_ShowInMenu_text);
		showInMenuMgr.add(leftShowInProjectExplorerAction);
		menuMgr.appendToGroup(NAVIGATE_GROUP_ID, showInMenuMgr);
		showInMenuMgr.add(showInDeployPaneAction);
		menuMgr.appendToGroup(NAVIGATE_GROUP_ID, showInMenuMgr);

		menuMgr.appendToGroup(EDIT_GROUP_ID, deleteAction);

	}

	private void createRightContextMenu() {
		IMenuListener menuListener = new IMenuListener() {

			@Override
			public void menuAboutToShow(IMenuManager manager) {
				fillRightContextMenu(manager);
			}
		};
		
		MenuManager menuMgr = new MenuManager("#RightPopupMenu"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(menuListener);

		Tree tree = rightTree;
		Menu menu = menuMgr.createContextMenu(tree);
		tree.setMenu(menu);
		getSite().registerContextMenu(menuMgr, rightTreeViewer);

	}

	private void fillRightContextMenu(IMenuManager menuMgr) {

		menuMgr.add(new Separator(NAVIGATE_GROUP_ID));
		menuMgr.add(new Separator(EDIT_GROUP_ID));

		menuMgr.appendToGroup(NAVIGATE_GROUP_ID, rightExpandAllAction);
		
		for (DeploymentEditorPopupMenuRegistry registry : DeploymentEditorPopupMenuRegistryReader.INSTANCE
				.getMenuContributions()) {
			if (getZDLProfiles().contains(registry.getDomain())) {
				if (registry.isShowOnDeployment()) {
					AbstractDeploymetEditorPopupAction action = registry.getAction();
					action.setText(registry.getName());
					action.setViewer(rightTreeViewer);
					action.setDeploymentView(view);
					menuMgr.appendToGroup(EDIT_GROUP_ID, action);
				}
			}
		}
		
		MenuManager showInMenuMgr = new MenuManager(
				DeploymentEditorMessages.DeploymentFormPage_ShowInMenu_text);
		showInMenuMgr.add(rightShowInProjectExplorerAction);
		menuMgr.appendToGroup(NAVIGATE_GROUP_ID, showInMenuMgr);

		menuMgr.appendToGroup(EDIT_GROUP_ID, rightUndeployAction);

		// TODO commented out for now, we need to know criteria for showing
		// generation options
		// See if the currently selected item is a root item
		// Property property = getSelectedPropertyFromTree(rightTreeViewer);
		// if (property != null) {
		// Property parent = ZDeploymentUtil.getParentPart(property);
		// if (parent == null
		// && ZDeploymentUtil.getDeploymentTargetPart(property) == null) {
		// // Add generate menu only if the selection is the root item
		// menuMgr.add(generateMenuMgr);
		// }
		// }
	}

	/**
	 * Return selected property from the tree viewer
	 * 
	 * @param viewer
	 *            Tree viewer
	 * @return
	 */
	@SuppressWarnings("unused")
	private Property getSelectedPropertyFromTree(TreeViewer viewer) {

		if (viewer.getSelection() instanceof IStructuredSelection) {
			Object selObject = ((IStructuredSelection) viewer.getSelection())
					.getFirstElement();

			if (selObject instanceof Property) {
				return (Property) selObject;
			}
		}
		return null;
	}

	/**
	 * Fill in the context menu for Zeligsoft Generate
	 * 
	 * @param menuMgr
	 *            Menu manager for Zeligsoft Generate menu
	 */
	private void fillGenerateContextMenu(IMenuManager menuMgr) {

		actionGroup = new GenerateActionProvider();

		actionGroup.fillContextMenu(menuMgr);

	}

	/**
	 * Create the tree editor page. Creates both sections, the trees and the
	 * sash.
	 * 
	 * @param body
	 *            the body of the page
	 * @param toolkit
	 *            the toolkit used to create the components in this page
	 */
	public void createTreeEditor(Composite body, FormToolkit toolkit) {
		body.setLayout(new FormLayout());

		FormData formData;

		// create the vertical sash
		verticalSash = new Sash(body, SWT.VERTICAL);
		formData = new FormData();
		formData.top = new FormAttachment(0, 0);
		formData.bottom = new FormAttachment(100, 0);
		formData.left = new FormAttachment(50, 0);
		verticalSash.setLayoutData(formData);

		SelectionAdapter verticalSelectionAdapter = new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				((FormData) verticalSash.getLayoutData()).left = new FormAttachment(
						0, event.x);
				verticalSash.getParent().layout();
			}
		};
		verticalSash.addSelectionListener(verticalSelectionAdapter);
		verticalSash.setBackground(ColorConstants.white);

		// create left section (for config side)
		leftSection = toolkit
				.createSection(body, ExpandableComposite.TITLE_BAR);
		leftSection
				.setText(DeploymentEditorMessages.DeploymentFormPage_LeftTitle);
		leftSection.setFont(JFaceResources.getHeaderFont());
		leftSection.setForeground(toolkit.getColors().getColor(
				IFormColors.H_PREFIX));

		toolkit.createCompositeSeparator(leftSection);

		formData = new FormData();
		formData.top = new FormAttachment(0, 0);
		formData.bottom = new FormAttachment(100, 0);
		formData.left = new FormAttachment(0, 0);
		formData.right = new FormAttachment(verticalSash, 0);
		leftSection.setLayoutData(formData);

		// create left tree
		createLeftTree(leftSection, toolkit);

		// create right section (for deploy side)
		rightSection = toolkit.createSection(body,
				ExpandableComposite.TITLE_BAR);
		rightSection
				.setText(DeploymentEditorMessages.DeploymentFormPage_RightTitle);
		rightSection.setFont(JFaceResources.getHeaderFont());
		rightSection.setForeground(toolkit.getColors().getColor(
				IFormColors.H_PREFIX));

		toolkit.createCompositeSeparator(rightSection);

		formData = new FormData();
		formData.top = new FormAttachment(0, 0);
		formData.bottom = new FormAttachment(100, 0);
		formData.left = new FormAttachment(verticalSash, 0);
		formData.right = new FormAttachment(100, 0);
		rightSection.setLayoutData(formData);

		// create right tree
		createRightTree(rightSection, toolkit);

	}

	/**
	 * Create the left tree
	 */
	private void createLeftTree(Section section, FormToolkit toolkit) {
		Composite client = toolkit.createComposite(section, SWT.WRAP);

		leftTree = toolkit.createTree(client, SWT.MULTI);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		client.setLayout(layout);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 1;
		gridData.widthHint = 1;
		leftTree.setLayoutData(gridData);

		toolkit.paintBordersFor(client);
		section.setClient(client);

		// create the vertical tree viewer
		leftTreeViewer = new TreeViewer(leftTree);
		leftTreeViewer.addSelectionChangedListener(this);
		leftTreeViewer.setContentProvider(leftTreeContentProvider);
		leftTreeViewer.setLabelProvider(leftTreeLabelProvider);
		leftTreeViewer.setInput(leftTreeInput);
		leftTreeViewer.expandToLevel(INITIAL_EXPAND_LEVEL);

		// setup the drop listener
		final LocalSelectionTransfer lst = LocalSelectionTransfer.getTransfer();
		Transfer[] types = new Transfer[] { lst };
		leftTreeListener = new LeftTreeListener(this, view, leftTreeViewer);
		int operations = DND.DROP_MOVE | DND.DROP_COPY;// | DND.DROP_DEFAULT;
		DropTarget target = new DropTarget(leftTree, operations);
		target.setTransfer(types);
		target.addDropListener(leftTreeListener);
		int style = DND.DROP_COPY | DND.DROP_MOVE;
		DragSource source = new DragSource(leftTree, style);
		source.setTransfer(types);
		source.addDragListener(leftTreeListener);
	}

	/**
	 * Create the right tree
	 */
	private void createRightTree(Section section, FormToolkit toolkit) {
		Composite client = toolkit.createComposite(section, SWT.WRAP);

		rightTree = toolkit.createTree(client, SWT.MULTI);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		client.setLayout(layout);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 1;
		gridData.widthHint = 1;
		rightTree.setLayoutData(gridData);

		toolkit.paintBordersFor(client);
		section.setClient(client);

		// create the vertical tree viewer
		rightTreeViewer = new TreeViewer(rightTree);
		rightTreeViewer.addSelectionChangedListener(this);
		rightTreeViewer.setContentProvider(rightTreeContentProvider);
		rightTreeViewer.setLabelProvider(rightTreeLabelProvider);
		rightTreeViewer.setInput(rightTreeInput);
		rightTreeViewer.expandToLevel(INITIAL_EXPAND_LEVEL);

		// setup the drop listener
		int operations = DND.DROP_MOVE | DND.DROP_COPY;// | DND.DROP_DEFAULT;
		DropTarget target = new DropTarget(rightTree, operations);
		rightTreeListener = new RightTreeListener(this, view, rightTreeViewer);
		final LocalSelectionTransfer lst = LocalSelectionTransfer.getTransfer();
		Transfer[] types = new Transfer[] { lst };
		target.setTransfer(types);
		target.addDropListener(rightTreeListener);
		// setup the drag listener
		int style = DND.DROP_COPY | DND.DROP_MOVE;
		DragSource source = new DragSource(rightTree, style);
		source.setTransfer(types);
		source.addDragListener(rightTreeListener);
	}

	/**
	 * Force a refresh of the page. This function refreshes both the left tree
	 * and the right tree.
	 */
	public void refresh() {
		if (leftTreeViewer != null) {
			leftTreeViewer.refresh();
		}
		if (rightTreeViewer != null) {
			rightTreeViewer.refresh();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormPage#dispose()
	 */
	@Override
	public void dispose() {
		
		DeploymentPartValidationObserver.removeListener(this);
		
		leftSection.dispose();		
		leftTree.dispose();

		rightSection.dispose();		
		rightTree.dispose();

		leftTreeViewer.removeSelectionChangedListener(this);
		leftTreeViewer.removeSelectionChangedListener(showInDeployPaneAction);
		leftTreeViewer = null;
		rightTreeViewer.removeSelectionChangedListener(this);
		rightTreeViewer = null;

		actionGroup.dispose();
		actionGroup = null;

		if (pageForm != null)
			pageForm.dispose();

		super.dispose();
	}

	/**
	 * Get the left tree on this page
	 * 
	 * @return Tree tree
	 */
	public Tree getLeftTree() {
		return leftTree;
	}

	/**
	 * Get the right tree on this page
	 * 
	 * @return Tree tree
	 */
	public Tree getRightTree() {
		return rightTree;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(
	 * org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		Object source = event.getSource();
		if (source == this.rightTreeViewer || source == this.leftTreeViewer) {
			DeploymentTreeEditor editor = (DeploymentTreeEditor) getEditor();
			if (editor.getCurrentViewer() != source) {
				editor.setCurrentViewer((Viewer) source);
			}
		}
	}
	
	/**
	 * Remove the tree's listeners added for tooltip 
	 * support.
	 * 
	 * @param Tree tree
	 * @param Listener listener
	 */
	public void removeTreeListener(Tree tree, Listener listener){	
		if (tree.isDisposed()){
			return;
		}
		tree.removeListener(SWT.Dispose, listener);
		tree.removeListener(SWT.KeyDown, listener);
		tree.removeListener(SWT.MouseMove, listener);
		tree.removeListener(SWT.MouseHover, listener);		
	}

	// //////////////////////////////////////////////////////////////////////////////////////////
	// Have to override FormPage methods in order to have access to mForm
	// mForm access needed to override createPartControl method.
	// The createPartControl method now creates a ScrolledForm with no vertical
	// or horizontal scrolling.
	// //////////////////////////////////////////////////////////////////////////////////////////

	protected static class PageForm extends ManagedForm {
		public PageForm(FormPage page, ScrolledForm form) {
			super(page.getEditor().getToolkit(), form);
			setContainer(page);
		}

		public FormPage getPage() {
			return (FormPage) getContainer();
		}

		@Override
		public void dirtyStateChanged() {
			getPage().getEditor().editorDirtyStateChanged();
		}

		@Override
		public void staleStateChanged() {
			if (getPage().isActive())
				refresh();
		}
	}

	@Override
	public IManagedForm getManagedForm() {
		return pageForm;
	}

	@Override
	public void setActive(boolean active) {
		if (active) {
			// We are switching to this page - refresh it
			// if needed.
			pageForm.refresh();
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		ScrolledForm form = createScrolledForm(parent);
		form.setBounds(0, 0, 100, 100);
		pageForm = new PageForm(this, form);
		BusyIndicator.showWhile(parent.getDisplay(), new Runnable() {
			@Override
			public void run() {
				createFormContent(pageForm);
			}
		});
	}

	@Override
	public Control getPartControl() {
		return pageForm != null ? pageForm.getForm() : null;
	}

	@Override
	public void setFocus() {
		if (pageForm != null)
			pageForm.setFocus();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		if (pageForm != null)
			pageForm.commit(true);
	}

	@Override
	public boolean isDirty() {
		return pageForm != null ? pageForm.isDirty() : false;
	}

	@Override
	public boolean selectReveal(Object object) {
		if (pageForm != null)
			return pageForm.setInput(object);
		return false;
	}

	public ScrolledForm createScrolledForm(Composite parent) {
		ScrolledForm form = new ScrolledForm(parent, Window
				.getDefaultOrientation());
		form.setExpandHorizontal(true);
		form.setExpandVertical(true);
		form
				.setBackground(getEditor().getToolkit().getColors()
						.getBackground());
		form.setForeground(getEditor().getToolkit().getColors().getColor(
				IFormColors.TITLE));
		form.setFont(JFaceResources.getHeaderFont());
		return form;
	}

	@Override
	public void validationOccurred(ValidationEvent event) {
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				refresh();
			}
		});
	}

}
