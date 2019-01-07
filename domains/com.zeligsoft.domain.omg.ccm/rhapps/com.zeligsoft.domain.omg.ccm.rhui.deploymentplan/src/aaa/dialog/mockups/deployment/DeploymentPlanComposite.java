package aaa.dialog.mockups.deployment;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

public class DeploymentPlanComposite extends Composite {

	private final IDeploymentPlanController controller;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public DeploymentPlanComposite(Composite parent, int style, IDeploymentPlanController planController) {
		super(parent, style);
		this.controller = planController;
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.VERTICAL);
		
		Composite compositeTrees = new Composite(sashForm, SWT.NONE);
		compositeTrees.setLayout(new GridLayout(2, false));
		
		Group grpConfigure = new Group(compositeTrees, SWT.NONE);
		grpConfigure.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpConfigure.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpConfigure.setText("Configure");
		grpConfigure.setBounds(0, 0, 70, 82);
		
		Tree treeConfigure = new Tree(grpConfigure, SWT.BORDER);
		
		DragSource dragSourceConfigure = new DragSource(treeConfigure, DND.DROP_COPY);
		dragSourceConfigure.addDragListener(new DragSourceAdapter() {
			@Override
			public void dragSetData(DragSourceEvent event) {
				controller.dragConfigureItem(event);
			}
		});
		
		DropTarget dropTargetConfigure = new DropTarget(treeConfigure, DND.DROP_COPY);
		dropTargetConfigure.addDropListener(new DropTargetAdapter() {
			@Override
			public void drop(DropTargetEvent event) {
				controller.dropOnConfigure(event);
			}
			@Override
			public void dropAccept(DropTargetEvent event) {
				controller.dropAcceptConfigure(event);
			}
			@Override
			public void dragEnter(DropTargetEvent event) {
				controller.dropEnterConfigure(event);
			}
		});
		
		Menu menuConfigure = new Menu(treeConfigure);
		treeConfigure.setMenu(menuConfigure);
		
		MenuItem mntmExpandAll_Configure = new MenuItem(menuConfigure, SWT.NONE);
		mntmExpandAll_Configure.setText("Expand All");
		
		MenuItem mntmShowIn_Configure = new MenuItem(menuConfigure, SWT.CASCADE);
		mntmShowIn_Configure.setText("Show In");
		
		Menu menu = new Menu(mntmShowIn_Configure);
		mntmShowIn_Configure.setMenu(menu);
		
		MenuItem mntmBrowser_Configure = new MenuItem(menu, SWT.NONE);
		mntmBrowser_Configure.setText("Browser");
		
		MenuItem mntmDeployPane = new MenuItem(menu, SWT.NONE);
		mntmDeployPane.setText("Deploy Pane");
		
		MenuItem mntmDelete = new MenuItem(menuConfigure, SWT.NONE);
		mntmDelete.setText("Delete");
		
		TreeItem treeItem = new TreeItem(treeConfigure, SWT.NONE);
		treeItem.setText("New TreeItem");
		
		Group grpDeploy = new Group(compositeTrees, SWT.NONE);
		grpDeploy.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpDeploy.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpDeploy.setText("Deploy");
		grpDeploy.setBounds(0, 0, 70, 82);
		
		Tree treeDeploy = new Tree(grpDeploy, SWT.BORDER);
		
		DropTarget dropTargetDeploy = new DropTarget(treeDeploy, DND.DROP_MOVE);
		dropTargetDeploy.addDropListener(new DropTargetAdapter() {
			@Override
			public void drop(DropTargetEvent event) {
				controller.dropOnDeploy(event);
			}
		});
		
		Menu menuDeploy = new Menu(treeDeploy);
		treeDeploy.setMenu(menuDeploy);
		
		MenuItem mntmExpandAll_Deploy = new MenuItem(menuDeploy, SWT.NONE);
		mntmExpandAll_Deploy.setText("Expand All");
		
		MenuItem mntmShowIn_Deploy = new MenuItem(menuDeploy, SWT.CASCADE);
		mntmShowIn_Deploy.setText("Show In");
		
		Menu menu_1 = new Menu(mntmShowIn_Deploy);
		mntmShowIn_Deploy.setMenu(menu_1);
		
		MenuItem mntmBrowser_Deploy = new MenuItem(menu_1, SWT.NONE);
		mntmBrowser_Deploy.setText("Browser");
		
		MenuItem mntmUndeploy = new MenuItem(menuDeploy, SWT.NONE);
		mntmUndeploy.setText("Undeploy");
		
		Composite compositeProperties = new Composite(sashForm, SWT.NONE);
		compositeProperties.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ExpandBar expandBar = new ExpandBar(compositeProperties, SWT.NONE);
		
		ExpandItem xpndtmProperties = new ExpandItem(expandBar, SWT.NONE);
		xpndtmProperties.setExpanded(true);
		xpndtmProperties.setText("Properties");
		
		Composite compositePropExpand = new Composite(expandBar, SWT.NONE);
		xpndtmProperties.setControl(compositePropExpand);
		xpndtmProperties.setHeight(130);
		compositePropExpand.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Tree treeProperties = new Tree(compositePropExpand, SWT.BORDER);
		treeProperties.setHeaderVisible(true);
		
		TreeColumn trclmnProperty = new TreeColumn(treeProperties, SWT.NONE);
		trclmnProperty.setWidth(225);
		trclmnProperty.setText("Property");
		
		TreeColumn trclmnValue = new TreeColumn(treeProperties, SWT.LEFT);
		trclmnValue.setWidth(148);
		trclmnValue.setText("Value");
		
		TreeItem trtmNewTreeitem = new TreeItem(treeProperties, SWT.NONE);
		trtmNewTreeitem.setText("New TreeItem");
		
		TreeItem trtmNewTreeitem_1 = new TreeItem(trtmNewTreeitem, SWT.NONE);
		trtmNewTreeitem_1.setText("New TreeItem");
		
		TreeItem trtmNewTreeitem_2 = new TreeItem(trtmNewTreeitem_1, SWT.NONE);
		trtmNewTreeitem_2.setText("New TreeItem");
		trtmNewTreeitem_2.setExpanded(true);
		
		TreeItem trtmNewTreeitem_3 = new TreeItem(trtmNewTreeitem_1, SWT.NONE);
		trtmNewTreeitem_3.setText("New TreeItem");
		trtmNewTreeitem_1.setExpanded(true);
		
		TreeItem trtmNewTreeitem_4 = new TreeItem(trtmNewTreeitem, SWT.NONE);
		trtmNewTreeitem_4.setText("New TreeItem");
		trtmNewTreeitem.setExpanded(true);
		sashForm.setWeights(new int[] {261, 162});

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
