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

package com.prismtech.domain.sca.ppls.vpm.ui.views;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.uml2.common.util.UML2Util;

import com.prismtech.domain.sca.ppls.editor.l10n.Messages;
import com.prismtech.domain.sca.ppls.utils.PLMUtil;
import com.prismtech.domain.sca.ppls.utils.VPMNames;
import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue;
import com.prismtech.domain.sca.ppls.vpm.SettableAttribute;
import com.prismtech.domain.sca.ppls.vpm.VariationPoint;
import com.prismtech.domain.sca.ppls.vpm.VpmPackage;
import com.prismtech.domain.sca.ppls.vpm.presentation.VpmEditorPlugin;
import com.prismtech.domain.sca.ppls.vpm.provider.VpmEditPlugin;
import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * @author mciobanu
 * 
 *         Tree view with column with editing support enabling a user 
 *         to select a single variation point in a model and see a table where
 *         there is a row for each configuration and a column for the variation
 *         point value, the value in the cell is the value of the configuration
 *         point associated with the variation point in the configuration of the
 *         current row. 
 */

public class VPToCPMappingTreeView extends ViewPart implements
		ISelectionListener {

	public static final String ID = "VPToCPMappingTreeViewID"; //$NON-NLS-1$

	private static final int ROW_NUMBER_COLUMN_INDEX = 0;
	private static final int CONFIGURATION_POINT_COLUMN_INDEX = 1;
	private static final int CONFIGURATION_POINT_CONFIGURATION_COLUMN_INDEX = 2;
	private static final int CONFIGURATION_POINT_PROPERTY_COLUMN_INDEX = 3;
	private static final int CONFIGURATION_POINT_VALUE_COLUMN_INDEX = 4;
	private static final int CONFIGURATION_POINT_GENERATE_COLUMN_INDEX = 5;

	protected TreeViewer treeViewer;
	protected FilteredTree ftree;
	protected VPToCPTableViewComparator comparator;
	protected Label label;

	private int defaultColumnSize = 150;

	private VariationPoint selectedVP = null;

	public VPToCPMappingTreeView() {
		super();
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		ISelectionService s = getSite().getWorkbenchWindow()
				.getSelectionService();
		s.addSelectionListener(this);
	}

	@Override
	public void dispose() {
		ISelectionService s = getSite().getWorkbenchWindow()
				.getSelectionService();
		s.removeSelectionListener(this);
		super.dispose();
	}

	@Override
	public void createPartControl(final Composite parent) {

		Composite mainComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		mainComposite.setLayout(layout);
		mainComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

		label = new Label(mainComposite, SWT.NULL);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createTree(mainComposite);
	}

	protected void createTree(Composite parent) {

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = false;
		Composite treeComposite = new Composite(parent, SWT.NULL);
		treeComposite.setLayout(layout);
		treeComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.FILL_VERTICAL));
		//Show the filtered search text field
		PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_FILTERED_TEXTS, true);
		ftree = new FilteredTree(treeComposite,
				SWT.FULL_SELECTION | SWT.BORDER, new PatternFilter() {

					@Override
					protected boolean isLeafMatch(Viewer viewer, Object element) {
						return super.isLeafMatch(viewer, element);
					}
				}, true);

		treeViewer = ftree.getViewer();
		treeViewer.getTree().setLinesVisible(true);
		treeViewer.getTree().setHeaderVisible(true);

		ftree.setInitialText(Messages.VPToCPMappingTreeView_search_initial_text);

		treeViewer.setLabelProvider(new VPToCPLabelProvider());
		treeViewer.setContentProvider(new VPToCPTreeContentProvider());

		comparator = new VPToCPTableViewComparator();
		treeViewer.setComparator(comparator);
		treeViewer.setAutoExpandLevel(2);

		createStyledRowCountColumn(ROW_NUMBER_COLUMN_INDEX, UML2Util.EMPTY_STRING, 40);
		createColumn(CONFIGURATION_POINT_COLUMN_INDEX,
				Messages.VPToCPMappingTreeView_configuration_point,
				defaultColumnSize, false);
		createColumn(CONFIGURATION_POINT_CONFIGURATION_COLUMN_INDEX,
				Messages.VPToCPMappingTreeView_configuration_point_configuration,
				defaultColumnSize, false);
		createColumn(CONFIGURATION_POINT_PROPERTY_COLUMN_INDEX,
				Messages.VPToCPMappingTreeView_configuration_point_property,
				defaultColumnSize, false);
		createColumn(CONFIGURATION_POINT_VALUE_COLUMN_INDEX,
				Messages.VPToCPMappingTreeView_configuration_point_value,
				defaultColumnSize, true);
		createColumn(CONFIGURATION_POINT_GENERATE_COLUMN_INDEX,
				Messages.VPToCPMappingTreeView_configuration_point_generate,
				defaultColumnSize, true);

		getSite().setSelectionProvider(treeViewer);

		createTreeActions();

	}

	/**
	 * helper method to create table columns
	 * 
	 * @param columnIndex
	 * @param columnName
	 * @param size
	 * @param allowEdit
	 */
	private void createColumn(final int columnIndex, String columnName,
			int size, boolean allowEdit) {
		TreeViewerColumn tvc = new TreeViewerColumn(treeViewer, SWT.LEFT);
		final TreeColumn treeCol = tvc.getColumn();
		treeCol.setText(columnName);
		treeCol.setWidth(size);
		treeCol.setResizable(true);
		treeCol.addSelectionListener(getSelectionAdapter(treeCol, columnIndex));

		if (allowEdit == true) {
			if (columnIndex == CONFIGURATION_POINT_VALUE_COLUMN_INDEX) {
				tvc.setEditingSupport(new ConfigurationPointValueEditingSupport(
						treeViewer, columnIndex));
			} else if (columnIndex == CONFIGURATION_POINT_GENERATE_COLUMN_INDEX) {
				tvc.setEditingSupport(new ConfigurationPointGenerateEditingSupport(
						treeViewer, columnIndex));
			}
		}
		tvc.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof ConfigurationPoint
						|| element instanceof SettableAttribute) {

					LabelProvider provider = (VPToCPLabelProvider) treeViewer
							.getLabelProvider();
					switch (columnIndex) {
					case CONFIGURATION_POINT_COLUMN_INDEX:
						return ((VPToCPLabelProvider) provider)
								.getName(element);
					case CONFIGURATION_POINT_CONFIGURATION_COLUMN_INDEX:
						return ((VPToCPLabelProvider) provider)
								.getConfigName(element);
					case CONFIGURATION_POINT_PROPERTY_COLUMN_INDEX:
						return ((VPToCPLabelProvider) provider)
								.getProperties(element);
					case CONFIGURATION_POINT_VALUE_COLUMN_INDEX:
						return ((VPToCPLabelProvider) provider)
								.getValue(element);
					case CONFIGURATION_POINT_GENERATE_COLUMN_INDEX:
						return ((VPToCPLabelProvider) provider)
								.getGenerate(element);
					}
				}
				return null;
			}

			@Override
			public Image getImage(Object element) {
				
				switch(columnIndex){
					case CONFIGURATION_POINT_CONFIGURATION_COLUMN_INDEX:
						if(element instanceof ConfigurationPoint){
							return JFaceResources.getImage(VPMNames.CONFIGURATION);
						}
						break;
					case CONFIGURATION_POINT_COLUMN_INDEX:
						if(element instanceof ConfigurationPointWithSettings) {
							return JFaceResources.getImage(VPMNames.CONFIGURATION_POINT_WITH_SETTINGS);
						} else if (element instanceof ConfigurationPointWithValue){
							return JFaceResources.getImage(VPMNames.CONFIGURATION_POINT_WITH_VALUE);
						}else if(element instanceof ConfigurationPoint){
							return JFaceResources.getImage(VPMNames.CONFIGURATION_POINT);
						}
						break;
					case CONFIGURATION_POINT_PROPERTY_COLUMN_INDEX:
						if(element instanceof ConfigurationPointWithSettings){
							return JFaceResources.getImage(VPMNames.SETTABLE_ATTTRIBUTE);
						}else if(element instanceof ConfigurationPointWithValue){
							return JFaceResources.getImage(VPMNames.CONFIGURATION_POINT_WITH_VALUE__VALUE);
						}else if(element instanceof SettableAttribute){
							return JFaceResources.getImage(VPMNames.SETTABLE_ATTTRIBUTE);
						}else if(element instanceof ConfigurationPoint){
							return JFaceResources.getImage(VPMNames.CONFIGURATION_POINT__GENERATE);
						}
						break;
					case CONFIGURATION_POINT_VALUE_COLUMN_INDEX:
						if(columnIndex == CONFIGURATION_POINT_VALUE_COLUMN_INDEX){
							return JFaceResources.getImage(VPMNames.CONFIGURATION_POINT_WITH_VALUE__VALUE);
						} else if (element instanceof SettableAttribute){
							return JFaceResources.getImage(VPMNames.SETTABLE_ATTTRIBUTE__VALUE);
						}
						break;
					case CONFIGURATION_POINT_GENERATE_COLUMN_INDEX:
						if(element instanceof ConfigurationPoint){
							return JFaceResources.getImage(VPMNames.CONFIGURATION_POINT__GENERATE);
						}
						break;
					default:
						break;
				}
				return super.getImage(element);
			}

		});

		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 1;
		data.grabExcessHorizontalSpace = true;
		treeViewer.getControl().setLayoutData(data);

	}

	/**
	 * helper method to create stylized table columns
	 * 
	 * @param columnIndex
	 * @param columnName
	 * @param size
	 */
	private void createStyledRowCountColumn(final int columnIndex,
			String columnName, int size) {
		TreeViewerColumn tvc = new TreeViewerColumn(treeViewer, SWT.BORDER);
		final TreeColumn tableCol = tvc.getColumn();
		tableCol.setText(columnName);
		tableCol.setWidth(size);
		tableCol.setResizable(true);
		tvc.setLabelProvider(new StyledCellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {

				TreeItem cellItem = (TreeItem) cell.getItem();				
				int rowCount = treeViewer.getTree().indexOf(cellItem);
				if(rowCount >=0){
					cell.setText(Integer.toString(rowCount));
				}
				
				super.update(cell);
			}
		});

		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 1;
		data.grabExcessHorizontalSpace = true;
		treeViewer.getControl().setLayoutData(data);

	}

	private SelectionAdapter getSelectionAdapter(final TreeColumn column,
			final int index) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				comparator.setColumn(index);
				treeViewer.getTree()
						.setSortDirection(comparator.getDirection());
				treeViewer.getTree().setSortColumn(column);
				treeViewer.refresh();
			}

		};
		return selectionAdapter;
	}

	protected void createTreeActions() {
		MenuManager popupMenu = new MenuManager();

		Menu menu = popupMenu.createContextMenu(treeViewer.getTree());
		treeViewer.getTree().setMenu(menu);
	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	public VariationPoint getSelectedVariationPoint() {
		return selectedVP;
	}

	public void setTableEnabled(boolean isEnabled) {
		treeViewer.getTree().setEnabled(isEnabled);
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// Disregard selections in the view to prevent focus change to the
		// editor
		if (part != VPToCPMappingTreeView.this
				&& selection instanceof IStructuredSelection) {
			selectedVP = null;
			List<EObject> eobjects = BaseUIUtil
					.getEObjectsFromSelection(selection);

			// not a valid selection, wipe out table, disable
			if (eobjects.size() != 1) {
				clear();
				return;
			}

			EObject e = eobjects.get(0);
			if (e != null && e instanceof VariationPoint) {
				// populate table with Configuration Points
				selectedVP = (VariationPoint) e;

				Collection<ConfigurationPoint> cps = PLMUtil
						.getConfigurationPoints(selectedVP);
				Object[] newInput = null;

				newInput = cps.toArray();
				treeViewer.setInput(newInput);
				setTableEnabled(true);
				treeViewer.refresh();

				String name = selectedVP.getName();
				label.setText(Messages.VPToCPMappingTreeView_label
						+ " " + name + " - " + selectedVP.getId()); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				clear();
				return;
			}
		}
	}

	public void refreshTable() {
		Collection<ConfigurationPoint> cps = PLMUtil
				.getConfigurationPoints(selectedVP);
		Object[] newInput = cps.toArray();

		treeViewer.setInput(newInput);
		setTableEnabled(true);
		treeViewer.refresh();
		treeViewer.expandToLevel(AbstractTreeViewer.ALL_LEVELS);
	}

	private void clear() {
		if (treeViewer != null) {
			treeViewer.setInput(new Object[0]);
			setTableEnabled(false);
			treeViewer.refresh();

			label.setText(UML2Util.EMPTY_STRING);
		}
	}

	public class VPToCPTableViewComparator extends ViewerComparator {

		protected static final int DESCENDING = 1;
		protected int propertyIndex;
		protected int direction = 0;

		public VPToCPTableViewComparator() {
			propertyIndex = 0;
			direction = 0;
		}

		public int getDirection() {
			return direction == 1 ? SWT.DOWN : SWT.UP;
		}

		public void setColumn(int column) {
			if (column == propertyIndex) {
				direction = 1 - direction;
			} else {
				propertyIndex = column;
				direction = DESCENDING;
			}
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			ITableLabelProvider lp = (ITableLabelProvider) treeViewer
					.getLabelProvider();
			int rc = 0;
			rc = lp.getColumnText(e1, propertyIndex).compareTo(
					lp.getColumnText(e2, propertyIndex));
			if (direction == DESCENDING) {
				rc = -rc;
			}
			return rc;
		}

	}

	protected class VPToCPLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public String getConfigName(Object e) {
			String name = UML2Util.EMPTY_STRING;
			if (e instanceof ConfigurationPoint) {
				if (((ConfigurationPoint) e).eContainer() instanceof Configuration) {
					name = ((Configuration) ((ConfigurationPoint) e)
							.eContainer()).getName();
				}
			}
			return name;
		}

		public String getName(Object e) {
			String name = UML2Util.EMPTY_STRING;
			if (e instanceof ConfigurationPoint) {
				name += ((ConfigurationPoint) e).getName();
			}
			return name;
		}

		public String getProperties(Object e) {
			String name = UML2Util.EMPTY_STRING;
			if (e instanceof EObject) {
				if (e instanceof ConfigurationPointWithSettings) {
					int length = ((ConfigurationPointWithSettings) e)
							.getSettableAttributes().size();
					int counter = 0;
					for (SettableAttribute sa : ((ConfigurationPointWithSettings) e)
							.getSettableAttributes()) {
						counter++;
						if (length > 1 && counter < length)
							name += sa.getName() + ", "; //$NON-NLS-1$
						else {
							name += sa.getName();
						}
					}
				} else if (e instanceof ConfigurationPointWithValue) {
					name = VpmEditPlugin.INSTANCE
							.getString("_UI_SettableAttribute_value_feature"); //$NON-NLS-1$
				} else if (e instanceof ConfigurationPoint) {
					name = VpmEditPlugin.INSTANCE
							.getString("_UI_ConfigurationPoint_generate_feature"); //$NON-NLS-1$
				} else if (e instanceof SettableAttribute) {
					name = ((SettableAttribute) e).getName();
				}
			}
			return name;
		}

		public String getGenerate(Object e) {
			String generate = UML2Util.EMPTY_STRING;
			if (e instanceof ConfigurationPoint) {
				generate += ((ConfigurationPoint) e).isGenerate();
			}
			return generate;
		}

		public String getValue(Object e) {
			String value = UML2Util.EMPTY_STRING;
			if (e instanceof ConfigurationPointWithSettings) {
				int length = ((ConfigurationPointWithSettings) e)
						.getSettableAttributes().size();
				int counter = 0;
				for (SettableAttribute sa : ((ConfigurationPointWithSettings) e)
						.getSettableAttributes()) {
					counter++;
					if (length > 1 && counter < length)
						value += (UML2Util.isEmpty(sa.getValue()) ? Messages.VPToCPMappingTreeView_configuration_point_value_empty
								: sa.getValue())
								+ ", "; //$NON-NLS-1$
					else {
						value += (UML2Util.isEmpty(sa.getValue()) ? Messages.VPToCPMappingTreeView_configuration_point_value_empty
								: sa.getValue());
					}
				}
			} else if (e instanceof ConfigurationPointWithValue) {
				if (!UML2Util.isEmpty(((ConfigurationPointWithValue) e)
						.getValue())) {
					value += ((ConfigurationPointWithValue) e).getValue();
				}
			} else if (e instanceof ConfigurationPoint) {
				value += ((ConfigurationPoint) e).isGenerate();
			} else if (e instanceof SettableAttribute) {
				if (!UML2Util.isEmpty(((SettableAttribute) e).getValue())) {
					value += ((SettableAttribute) e).getValue();
				}
			}

			return value;
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			String result = UML2Util.EMPTY_STRING;
			if (element instanceof ConfigurationPoint) {
				ConfigurationPoint cp = (ConfigurationPoint) element;

				switch (columnIndex) {
				case CONFIGURATION_POINT_CONFIGURATION_COLUMN_INDEX: // Configuration end
					result += ((Configuration) cp.eContainer()).getName();
					break;
				case CONFIGURATION_POINT_COLUMN_INDEX: // Configuration point
					result += cp.getName();
					break;
				case CONFIGURATION_POINT_PROPERTY_COLUMN_INDEX: // Configuration point settable property
					if (cp instanceof ConfigurationPointWithSettings) {
						for (SettableAttribute sa : ((ConfigurationPointWithSettings) cp)
								.getSettableAttributes()) {
							result += sa.getName();
						}
					} else if (cp instanceof ConfigurationPointWithValue) {
						result += VpmEditPlugin.INSTANCE
								.getString("_UI_SettableAttribute_value_feature"); //$NON-NLS-1$
					} else if (cp instanceof ConfigurationPoint) {
						result += VpmEditPlugin.INSTANCE
								.getString("_UI_ConfigurationPoint_generate_feature"); //$NON-NLS-1$
					}
					break;
				case CONFIGURATION_POINT_VALUE_COLUMN_INDEX: // Configuration point value
					if (cp instanceof ConfigurationPointWithSettings) {
						for (SettableAttribute sa : ((ConfigurationPointWithSettings) cp)
								.getSettableAttributes()) {
							if (!UML2Util.isEmpty(sa.getValue())) {
								result += sa.getValue() + " "; //$NON-NLS-1$
							}
						}
					} else if (cp instanceof ConfigurationPointWithValue) {
						result += ((ConfigurationPointWithValue) cp).getValue();
					} else if (cp instanceof ConfigurationPoint) {
						result += cp.isGenerate();
					}
					break;
				case CONFIGURATION_POINT_GENERATE_COLUMN_INDEX: // Configuration point generate flag
					result += cp.isGenerate();
					break;
				default:

				}
			} else if (element instanceof SettableAttribute) {
				SettableAttribute sa = (SettableAttribute) element;

				switch (columnIndex) {
				case CONFIGURATION_POINT_PROPERTY_COLUMN_INDEX: // Configuration point settable property
					result += sa.getName();
					break;
				case CONFIGURATION_POINT_VALUE_COLUMN_INDEX: // Configuration point value
					if (!UML2Util.isEmpty(sa.getValue())) {
						result += sa.getValue() + " "; //$NON-NLS-1$
					}
					break;
				default:

				}
			}
			return result;
		}
	}

	/**
	 * Content provider for the VPTpCPMappingTreeView's FilteredTree
	 * 
	 * @author mciobanu
	 * 
	 */
	protected class VPToCPTreeContentProvider implements ITreeContentProvider {

		private ConfigurationPointWithSettings cps = null;

		public ConfigurationPointWithSettings getConfigurationPointWithSettings() {
			return this.cps;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			Object[] children = null;
			if (parentElement instanceof ConfigurationPointWithSettings) {
				children = ((ConfigurationPointWithSettings) parentElement)
						.getSettableAttributes().toArray();
			}

			return children;
		}

		@Override
		public Object getParent(Object element) {
			Object parent = null;
			if (element instanceof EObject) {
				parent = ((EObject) element).eContainer();
			}
			return parent;
		}

		@Override
		public boolean hasChildren(Object element) {
			boolean hasChildren = false;
			if (element instanceof ConfigurationPointWithSettings) {
				hasChildren = ((ConfigurationPointWithSettings) element)
						.getSettableAttributes().size() > 0;
			}
			return hasChildren;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			Object[] elements = null;
			if (inputElement != null) {
				elements = (Object[]) inputElement;
			} else {
				return new Object[0];
			}
			return elements;
		}

		@Override
		public void dispose() {
			// Do nothing
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// Do nothing
		}

	}

	/**
	 * Editing support for Values and Settable Attributes's Values Text Boxes 
	 * 
	 * @author mciobanu
	 *
	 */
	public class ConfigurationPointValueEditingSupport extends EditingSupport {

		private CellEditor editor = null;
		private int columnIndex;

		public ConfigurationPointValueEditingSupport(ColumnViewer viewer,
				int colIndex) {
			super(viewer);
			columnIndex = colIndex;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			if (element != null
					&& element instanceof EObject
					&& (element instanceof ConfigurationPoint || element instanceof SettableAttribute)) {
				// text cell editor
				editor = new TextCellEditor(treeViewer.getTree()) {

					@Override
					protected void doSetValue(Object value) {
						// prevent "null" values from showing
						if (UML2Util.isEmpty((String) value)) {
							value = UML2Util.EMPTY_STRING;
						}
						super.doSetValue(value);
					}
				};
			}
			return editor;
		}

		@Override
		protected boolean canEdit(Object element) {
			if (element != null
					&& element instanceof EObject
					&& (element instanceof ConfigurationPointWithValue || element instanceof SettableAttribute)) {
				return true;
			}
			return false;
		}

		@Override
		protected Object getValue(Object element) {
			String value = UML2Util.EMPTY_STRING;
			if (element != null
					&& (element instanceof ConfigurationPointWithValue || element instanceof SettableAttribute)) {
				if (columnIndex == CONFIGURATION_POINT_VALUE_COLUMN_INDEX) {
					if (element instanceof ConfigurationPointWithValue) {
						if (!UML2Util
								.isEmpty(((ConfigurationPointWithValue) element)
										.getValue())) {
							value += ((ConfigurationPointWithValue) element)
									.getValue();
						}
					} else if (element instanceof SettableAttribute) {
						if (!UML2Util.isEmpty(((SettableAttribute) element)
								.getValue())) {
							value += ((SettableAttribute) element).getValue();
						}
					}
				}
			}
			return value;
		}

		@Override
		protected void setValue(final Object element, final Object value) {
			if (element != null
					&& element instanceof EObject
					&& (element instanceof ConfigurationPointWithValue || element instanceof SettableAttribute)) {

				if (columnIndex == CONFIGURATION_POINT_VALUE_COLUMN_INDEX) {
					String setValue = UML2Util.EMPTY_STRING;
					if (!UML2Util.isEmpty((String) value)) {
						setValue = value.toString();
					} 
					// Only set the value if the value in the cell has changed
					// to avoid setting the editor dirty for no reason
					if (!getValue(element).toString().equals(setValue)) {
						EditingDomain ed = AdapterFactoryEditingDomain
								.getEditingDomainFor(((EObject) element));
						if(ed != null){
							if (element instanceof ConfigurationPointWithValue) {
								Command command = SetCommand
										.create(ed,
												element,
												VpmPackage.eINSTANCE
														.getConfigurationPointWithValue_Value(),
												setValue);
								ed.getCommandStack().execute(command);
							} else if (element instanceof SettableAttribute) {
								Command command = SetCommand.create(ed, element,
										VpmPackage.eINSTANCE
												.getSettableAttribute_Value(),
										setValue);
								ed.getCommandStack().execute(command);
							}
						}else{
							VpmEditorPlugin.INSTANCE.log(VpmEditorPlugin.INSTANCE.getString("_UI_LOG_EditingDomainNotFound")); //$NON-NLS-1$
						}
					}
				}
			}
			treeViewer.update(element, null);
		}
	}

	/**
	 * Editing support for Generate boolean flag combo box
	 * 
	 * @author mciobanu
	 * 
	 */
	public class ConfigurationPointGenerateEditingSupport extends
			EditingSupport {

		private int columnIndex;

		public ConfigurationPointGenerateEditingSupport(ColumnViewer viewer,
				int colIndex) {
			super(viewer);
			columnIndex = colIndex;
		}

		@Override
		protected void saveCellEditorValue(CellEditor cellEditor,
				ViewerCell cell) {
			super.saveCellEditorValue(cellEditor, cell);
			treeViewer.getControl().setFocus();
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			if (element != null && element instanceof EObject
					&& element instanceof ConfigurationPoint) {
				// combo box cell editor
				String[] booleanOptions = new String[2];
				booleanOptions[0] = Boolean.FALSE.toString();
				booleanOptions[1] = Boolean.TRUE.toString();

				return new ComboBoxCellEditor(treeViewer.getTree(),
						booleanOptions) {

					@Override
					protected void doSetValue(Object value) {
						Integer val = new Integer(0);
						if (value.equals(Boolean.TRUE.toString())) {
							val = 1;
						} else if (value.equals(Boolean.FALSE.toString())) {
							val = 0;
						}
						super.doSetValue(val);
					}
				};
			}
			return null;
		}

		@Override
		protected boolean canEdit(Object element) {
			if (element != null && element instanceof ConfigurationPoint) {
				return true;
			}
			return false;
		}

		@Override
		protected Object getValue(Object element) {
			if (element != null && element instanceof ConfigurationPoint) {
				if (columnIndex == CONFIGURATION_POINT_GENERATE_COLUMN_INDEX) {
					if (((ConfigurationPoint) element).isGenerate()) {
						return Boolean.TRUE.toString();
					} else {
						return Boolean.FALSE.toString();
					}
				}
			}
			return null;
		}

		@Override
		protected void setValue(final Object element, final Object value) {
			if (element != null && element instanceof EObject
					&& element instanceof ConfigurationPoint) {
				boolean setValue = false;
				if (value instanceof Integer) {
					if (((Integer) value).intValue() == 1) {
						setValue = true;
					}
					// Only set the value if the value in the cell has changed
					// to avoid setting the editor dirty for no reason
					if (((ConfigurationPoint) element).isGenerate() != setValue) {
						EditingDomain ed = AdapterFactoryEditingDomain
								.getEditingDomainFor(((EObject) element));
						Command command = SetCommand.create(ed, element,
								VpmPackage.eINSTANCE
										.getConfigurationPoint_Generate(),
								setValue);
						ed.getCommandStack().execute(command);
					}
				}
			}
			treeViewer.update(element, null);
		}
	}
}
