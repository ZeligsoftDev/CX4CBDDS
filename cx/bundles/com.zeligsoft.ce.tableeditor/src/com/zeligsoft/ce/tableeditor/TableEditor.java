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


package com.zeligsoft.ce.tableeditor;

import java.io.InputStream;
import java.util.ArrayList;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


/**
 * This is the main class for the deployment editor. It displays a vertical tree
 * on the left, the horizontal tree mainTable on top, and the deployment mainTable in
 * the middle.
 * 
 * @author sduchesneau
 * 
 */
public class TableEditor extends Composite
{
	private String[] prevColumnIds; // we have to keep a local copy of the
									// mainTable column names

	private String[] cachedColumnIds; // we cache the column ids to make it quicker
	private ArrayList<String> cachedRowIds;  // we cache the row ids to make it quicker
	private boolean updateRows;		// indicates if the rows need an update
	private boolean updateColumns;// indicates if the columns need an update
	
	// sashes for splitting the table
	private Sash horizontalSash;
	private Sash verticalSash;
	
	// the image stream to put a beautiful logo on the top left
	private InputStream imageStream;
	
	// variables used for horizontal tree table
	private Table horizontalTreeTable;
	private HorizontalTreeTableViewer horizontalTreeTableViewer;
	private HorizontalTreeTableContentProvider horizontalTreeTableContentProvider;
	private HorizontalTreeTableLabelProvider horizontalTreeTableLabelProvider;
	private DropTargetListener horizontalTreeTableDropListener;
	
	// these store the external label/content providers (those supplied by the API) 
	private ITreeContentProvider externalHorizontalTreeContentProvider;
	private ILabelProvider externalHorizontalTreeLabelProvider;	
	private ITreeContentProvider externalVerticalTreeContentProvider;
	private ILabelProvider externalVerticalTreeLabelProvider;
	
	// the inputs to the tree (provided by the API)
	private Object horizontalTreeInput;
	private Object verticalTreeInput;
	
	// variables used for the main table
	private Table mainTable;
	private TableViewer mainTableViewer;
	private MainTableListener mainTableListener;
	private TableEditorCellModifier mainTableModifier;
	//private ITableEditorProvider mainTableProvider;
	
	// mouse coordinates in terms of rows and columns
	private int mouseRow;
	private int mouseColumn;

	// variables used for the vertical tree
	private Tree verticalTree;
	private VerticalTreeViewer verticalTreeViewer;
	private DropTargetListener verticalTreeDropListener;
	
	// this variable stores the state of visibility for the columns
	private ArrayList<Boolean> horizontalHiddenList;
	
	// maps between the row/column ids and the object they represent
	// these may not be in order, so use getVisibleRows to get the correct row order
	// and use getColumnIds to get the correct column order
	private ArrayList<String> columnIds;
	private ArrayList<Object> columnObjects;	
	private ArrayList<String> rowIds;
	private ArrayList<Object> rowObjects;
	
	// these are constants
	private final int ROW_HEIGHT = 18;
	private final int DEFAULT_COLUMN_WIDTH = 50;
	
	// listener used to set the height of the tables
	Listener heightSetListener;
	
	// call back for when you double click
	TableEditorCallback tableEditorCallback;
	
	public TableEditor(Composite parent, int style)
	{		
		super(parent, style);
		imageStream = null;
		updateRows = true;
		updateColumns = true;
	}
	
	/*
	 * Create the deployment mainTable editor. This creates a vertical tree, a
	 * horizontal tree mainTable, and a deployment mainTable.
	 */
	public void createTableEditor()
	{
		final int DEFAULT_HEIGHT = 60;
		final int DEFAULT_WIDTH = 144;	
		
		mouseRow = -1;
		mouseColumn = -1;
			
		heightSetListener = new Listener()
		{
			public void handleEvent(Event event)
			{
				event.height = ROW_HEIGHT;
			}
		};
		
		columnObjects = new ArrayList<Object>();
		columnIds = new ArrayList<String>();
		
		rowObjects = new ArrayList<Object>();
		rowIds = new ArrayList<String>();
		
		this.setLayout(new FormLayout());
		
		
		// create the vertical sash
		verticalSash = new Sash(this, SWT.VERTICAL);
	    FormData formData = new FormData();
	    formData.top = new FormAttachment(0, 0);
	    formData.bottom = new FormAttachment(100, 0);
	    formData.left = new FormAttachment(0, DEFAULT_WIDTH);
	    verticalSash.setLayoutData(formData);
	    
	    SelectionAdapter verticalSelectionAdapter = new SelectionAdapter()
	    {
	    	public void widgetSelected(SelectionEvent event)
	    	{
	    		((FormData) verticalSash.getLayoutData()).left = new FormAttachment(0, event.x);
	    		verticalSash.getParent().layout();
	    	}
	    };
	    verticalSash.addSelectionListener(verticalSelectionAdapter);

	    // create the horizontal sash
		horizontalSash = new Sash(this, SWT.HORIZONTAL);
	    formData = new FormData();
	    formData.top = new FormAttachment(0, DEFAULT_HEIGHT);
	    formData.left = new FormAttachment(0, 0);
	    formData.right = new FormAttachment(100, 0);
	    horizontalSash.setLayoutData(formData);
	    
	    
	    SelectionAdapter horizontalSelectionAdapter = new SelectionAdapter()
    	{
        	public void widgetSelected(SelectionEvent event)
        	{
        		((FormData) horizontalSash.getLayoutData()).top = new FormAttachment(0, event.y);
        		horizontalSash.getParent().layout();
        	}
    	};    	
    	horizontalSash.addSelectionListener(horizontalSelectionAdapter);

	    // create the image composite
	    Composite imageComposite = new Composite(this, 0);

	    if (imageStream != null)
	    {
	    	Label imageLabel = new Label(imageComposite, SWT.NONE | SWT.BORDER | SWT.BACKGROUND);		
		
	    	formData = new FormData();
	    	formData.top = new FormAttachment(0, 0);
	    	formData.bottom = new FormAttachment(horizontalSash, 0);
	    	formData.left = new FormAttachment(0, 0);
	    	formData.right = new FormAttachment(verticalSash, 0);
	    
	    	imageComposite.setLayout(new FormLayout());
	    	imageComposite.setLayoutData(formData);

	    	
	    	Display display = imageLabel.getDisplay();	    	
		
	    	// create the image for the top left corner
	    	Image image = new Image(display, imageStream);
	    	imageLabel.setImage(image);
	    }

	    // create the horizontal tree table
		// the horizontal tree must absolutely be created before deployment mainTable, or else...
		// why? because we must know the number of columns
		createHorizontalTreeTable(this);
		formData = new FormData();
		formData.top = new FormAttachment(0, 0);
	    formData.bottom = new FormAttachment(horizontalSash, 0);
	    formData.left = new FormAttachment(verticalSash, 0);
	    formData.right = new FormAttachment(100, 0);
		horizontalTreeTable.setLayoutData(formData);
		resizeColumns(horizontalTreeTable);		
		
		// create vertical tree
		createVerticalTree(this);
		formData = new FormData();
		formData.top = new FormAttachment(horizontalSash, 0);
	    formData.bottom = new FormAttachment(100, 0);
	    formData.left = new FormAttachment(0, 0);
	    formData.right = new FormAttachment(verticalSash, 0);
		verticalTree.setLayoutData(formData);
		
		
		// create main table
		createMainTable(this);		
		formData = new FormData();
		formData.top = new FormAttachment(horizontalSash, 0);
	    formData.bottom = new FormAttachment(100, 0);
	    formData.left = new FormAttachment(verticalSash, 0);
	    formData.right = new FormAttachment(100, 0);
		mainTable.setLayoutData(formData);

		resizeColumns(mainTable);
		
	}
	
	/**
	 * Calculates the length in pixels of a cell depending on the number of
	 * letters in the label of the object. The constants in this
	 * function may have to be changed if we decide to change the font.
	 * 
	 * @param index
	 *            the index of the object
	 * @return the number of pixels required to properly display the label of
	 *         this object
	 */
	private int getCellWidth(int index)
	{
		int width = DEFAULT_COLUMN_WIDTH;
		
		if (horizontalTreeTableLabelProvider != null)
		{
			String text = horizontalTreeTableLabelProvider.getText(index);
			if (text == null) return width;
			width = text.length() * 6 + 46;
		}
	
		return width;
	}
	

	/**
	 * Check to see if a column is visible.
	 * 
	 * @param index
	 * 		the index of the column to check
	 * 
	 * @return
	 * 		true is the object is visible
	 * 		false is the object is hidden
	 */
	public boolean isColumnVisible(int index)
	{	
		boolean visible = false;
		
		visible = horizontalHiddenList.get(index).booleanValue();
		return visible;
	}
	
	
	/**
	 * Called to expand the children of a column object.  This will only expand the immediate children.
	 * 
	 * @param index
	 * 		the index of the column object to expand
	 */
	public void expandColumnObject(int index)
	{
		ArrayList<Object> objectList = horizontalTreeTableContentProvider.getFlatListOfElements();
		Object[] children = horizontalTreeTableContentProvider.getChildren(objectList.get(index));
		
		for (Object child: children)
		{
			showColumn(horizontalTreeTableContentProvider.indexOfElement(child));
		}		
	}
	
	/**
	 * Called to collapse the children of a column object.  This will collapse 
	 * ALL the children (that is, children, grandchildren etc...)
	 * 
	 * @param index
	 * 		the index of the column object to collapse
	 */
	public void collapseColumnObject(int index)
	{
		ArrayList<Object> objectList = horizontalTreeTableContentProvider.getFlatListOfElements();
		
		hideColumns(index+1, horizontalTreeTableContentProvider.getAllChildren(objectList.get(index)).size());		
	}
	
	/**
	 * Function that checks if a column object has children. 
	 * 
	 * @param index
	 * 		the index of the column object
	 * 
	 * @return
	 * 		true if the column object has children
	 * 		false if the column object has no children
	 */
	public boolean columnObjectHasChildren(int index)
	{
		ArrayList<Object> objectList = horizontalTreeTableContentProvider.getFlatListOfElements();
		Object[] children = horizontalTreeTableContentProvider.getChildren(objectList.get(index));
		
		if (children.length > 0)
			return true;
		return false;		
	}
	
	/**
	 * Unhides columns that were hidden in both the horizontal tree table and
	 * the main table.
	 * 
	 * @param index 
	 * 		the index of the column to show
	 */
	private void showColumn(int index)
	{
		
		int witdh = getCellWidth(index);

		TableColumn column = horizontalTreeTable.getColumn(index);
		column.setWidth(witdh);

		column = mainTable.getColumn(index);
		column.setWidth(witdh);

		horizontalHiddenList.remove(index);
		horizontalHiddenList.add(index, Boolean.FALSE);
		
		horizontalHiddenList.remove(index);
		horizontalHiddenList.add(index, Boolean.FALSE);
	}

	/**
	 * Hide columns in both the horizontal tree table and the main table.
	 * 
	 * @param index 
	 * 		the index of the first column to hide 
	 * @param columns
	 * 		number of columns to hide after the first column (index)
	 */
	private void hideColumns(int index, int columns)
	{
		for (int i = 0; i < columns; i++)
		{
			TableColumn column = horizontalTreeTable.getColumn(index + i);
			// column.dispose();
			column.setWidth(0);

			column = mainTable.getColumn(index + i);
			column.setWidth(0);

			horizontalHiddenList.remove(index + i);
			horizontalHiddenList.add(index + i, Boolean.TRUE);
		}
	}

	/**
	 * Set the number of rows required for the horizontal tree table.  This function 
	 * changes the layout of the table editor to provide enough room for the rows.
	 * 
	 *  @param numRows
	 *  	the number of rows
	 *  
	 */
	protected void setNumVisibleRows(int numRows)
	{
		int height=0;		
		
		if (numRows > 0)
			height = numRows * (ROW_HEIGHT + 1);
		else
			height = ROW_HEIGHT + 1; // minimum size is one row
		
		height += 16; // add space for horizontal scrollbar	
		
		if (getTableHeight() < height)
			setTableHeight(height);
			
	}

	/**
	 * Set the height of the horizontal tree table.
	 */
	private void setTableHeight(int height)
	{
		FormData formData = (FormData) horizontalSash.getLayoutData();
		
		formData.top = new FormAttachment(0, height);
		horizontalSash.setLayoutData(formData);
		
		// refresh the table editor
		layout();
	}
	
	/**
	 * get the height of the horizontal tree table.
	 */
	private int getTableHeight()
	{
		return ((FormData) horizontalSash.getLayoutData()).top.offset;
	}


	/**
	 * Create the main table and main table viewer and set up the
	 * providers for the viewer.
	 */
	private void createMainTable(Composite parent)
	{
		
		int count = horizontalTreeTableContentProvider.getNumElements();

		mainTable = createGenericTable(parent, count);

		// create the table viewer
		mainTableViewer = new TableViewer(mainTable);
		mainTableViewer.setUseHashlookup(true);
		resetTableViewer(mainTable, mainTableViewer, getColumnIds());
		
		if (mainTableModifier != null)
		{
			mainTableModifier.setEditor(this);
			mainTableViewer.setCellModifier(mainTableModifier);
		}
		
		mainTableViewer.setContentProvider(new ArrayContentProvider());
		
		mainTableListener = new MainTableListener(this);
		
		MainTableLabelProvider tableEditorLabelProvider = new MainTableLabelProvider(this);
		mainTableViewer.setLabelProvider(tableEditorLabelProvider);		
		
		mainTable.addListener(SWT.Modify, mainTableListener);
		mainTable.addMouseMoveListener(mainTableListener);
		mainTable.addMouseListener(mainTableListener);

		mainTableViewer.setInput(getVisibleRows());
	}

	/**
	 * Create the horizontal tree table.
	 */
	private void createHorizontalTreeTable(Composite parent)
	{
		horizontalTreeTableContentProvider = new HorizontalTreeTableContentProvider(externalHorizontalTreeContentProvider);
		
		// create a temporary horizontal tree to find out how many columns we need
		horizontalTreeTable = createGenericTable(parent, 0);
		
		// create the table viewer
		horizontalTreeTableViewer = new HorizontalTreeTableViewer(horizontalTreeTable, this);
		horizontalTreeTableViewer.setUseHashlookup(true);
		//resetTableViewer(horizontalTreeTable, horizontalTreeTableViewer, new String[0]);		
		
		horizontalTreeTableViewer.setContentProvider(horizontalTreeTableContentProvider);
		horizontalTreeTableViewer.setInput(horizontalTreeInput);
		
		int count = horizontalTreeTableContentProvider.getNumElements();
	
		// add the correct number of columns
		TableColumn column = null;
		for (int i = 0; i < count; i++)
		{
			column = new TableColumn(horizontalTreeTable, SWT.CENTER, i);
			column.setWidth(DEFAULT_COLUMN_WIDTH);
		}
		
		String[] columnIds = getColumnIds();
		
		resetTableViewer(horizontalTreeTable, horizontalTreeTableViewer, columnIds);

		createHorizontalHiddenList(count);
		
		horizontalTreeTableLabelProvider = new HorizontalTreeTableLabelProvider(this, horizontalTreeTableContentProvider, externalHorizontalTreeLabelProvider);
		horizontalTreeTableViewer.setLabelProvider(horizontalTreeTableLabelProvider);
		
		// remember the column ids		
		prevColumnIds = new String[columnIds.length];
		
		for (int i = 0; i < columnIds.length; i++)
		{
			prevColumnIds[i] = columnIds[i];
		}

		HorizontalTreeTableListener horizontalTreeTableListener = new HorizontalTreeTableListener(this);
		horizontalTreeTable.addMouseListener(horizontalTreeTableListener);
		horizontalTreeTable.addMouseMoveListener(horizontalTreeTableListener);
		horizontalTreeTableListener.addListener(horizontalTreeTableLabelProvider);
		horizontalTreeTableContentProvider.addListener(horizontalTreeTableLabelProvider);
		
		// setup the drop listener
		if (horizontalTreeTableDropListener != null)
		{
			int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT; 
			DropTarget target = new DropTarget(horizontalTreeTable, operations);
			
			final LocalSelectionTransfer lst = LocalSelectionTransfer.getTransfer(); 
			Transfer[] types = new Transfer[] {lst}; 
			
			target.setTransfer(types);		
			target.addDropListener(horizontalTreeTableDropListener);
		}		
		
		setNumVisibleRows(maximumHorizontalTreeTableVisibleDepth() + 1);				
	}

	/**
	 * Create the vertical tree
	 */
	private void createVerticalTree(Composite parent)
	{
		verticalTree = new Tree(parent, SWT.BORDER);

		VerticalTreeListener verticalTreeListener = new VerticalTreeListener(this);
		verticalTree.addTreeListener(verticalTreeListener);
		verticalTree.addMouseMoveListener(verticalTreeListener);
		
		// this is required to set the height of the rows
		verticalTree.addListener(SWT.MeasureItem, heightSetListener);

		verticalTree.setLinesVisible(true);
		
		// setup the drop listener
		if (verticalTreeDropListener != null)
		{
			int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT; 
			DropTarget target = new DropTarget(verticalTree, operations);
			
			final LocalSelectionTransfer lst = LocalSelectionTransfer.getTransfer(); 
			Transfer[] types = new Transfer[] {lst}; 
			
			target.setTransfer(types);		
			target.addDropListener(verticalTreeDropListener);
		}

		// create the vertical tree viewer
		verticalTreeViewer = new VerticalTreeViewer(verticalTree, this);
		verticalTreeViewer.setContentProvider(externalVerticalTreeContentProvider);
		
		VerticalTreeLabelProvider verticalTreeLabelProvider = new VerticalTreeLabelProvider(this, externalVerticalTreeLabelProvider);
		verticalTreeViewer.setLabelProvider(verticalTreeLabelProvider);

		verticalTreeViewer.setInput(verticalTreeInput);

		verticalTreeViewer.expandAll();

	}

	private int maximumHorizontalTreeTableVisibleDepth()
	{
		ArrayList<Object> objectList = horizontalTreeTableContentProvider.getFlatListOfElements();

		int maxDepth = 0;
		for (int i = 0; i < objectList.size(); i++)
		{
			if (horizontalHiddenList.get(i).equals(Boolean.FALSE))
			{
				int tmpDepth = horizontalTreeTableContentProvider.getElementDepth(objectList.get(i));
				if (maxDepth < tmpDepth)
					maxDepth = tmpDepth;
			}
		}
		return maxDepth;
	}

	/**
	 * Resize the columns in a table according to the length of the their
	 * deployment parts. This function will also hide the column if it isn't
	 * visible.
	 */
	private void resizeColumns(Table table)
	{
		int count = table.getColumnCount();

		for (int i = 0; i < count; i++)
		{
			TableColumn column = table.getColumn(i);

			if (horizontalHiddenList.get(i).booleanValue() == false)
				column.setWidth(getCellWidth(i));
			else
				column.setWidth(0);
		}
	}

	/**
	 * Create a generic table with default properties.
	 */
	private Table createGenericTable(Composite parent, int columns)
	{

		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.HIDE_SELECTION | SWT.RESIZE;
		Table table = new Table(parent, style);

		//GridData gridData = new GridData(GridData.FILL_BOTH);
		//table.setLayoutData(gridData);
		table.setLinesVisible(true);

		// this is required to set the height of the rows		
		table.addListener(SWT.MeasureItem, heightSetListener);
		

		// create the table columns
		TableColumn column = null;
		for (int i = 0; i < columns; i++)
		{
			column = new TableColumn(table, SWT.CENTER, i);
			column.setWidth(DEFAULT_COLUMN_WIDTH);
		}

		return table;
	}

	/**
	 * Reset the table viewer. Recreates the columns and the cell editors.
	 */
	private void resetTableViewer(Table table, TableViewer tableViewer, String[] columnIds)
	{
		tableViewer.setColumnProperties(columnIds);

		// destroy previous cell editors
		if (tableViewer.getCellEditors() != null)
		{
			for (CellEditor cellEditor: tableViewer.getCellEditors())
				cellEditor.dispose();
		}
		
		// Create the cell editors.
		CellEditor[] editors = new CellEditor[columnIds.length];

		TextCellEditor textEditor = null;
		// Deployment cells.
		for (int i = 0; i < columnIds.length; i++)
		{
			textEditor = new TextCellEditor(table);

			((Text) textEditor.getControl()).setTextLimit(60);
			editors[i] = textEditor;
		}

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
	}

	String[] getColumnIds()
	{
		if (updateColumns == false)
			return cachedColumnIds;
		
		
		if (horizontalTreeTableContentProvider == null)
		{
			cachedColumnIds = new String[0];
			updateColumns = false;
			return cachedColumnIds;
		}

		ArrayList<Object> objectList = horizontalTreeTableContentProvider.getFlatListOfElements();

		String[] ids = new String[objectList.size()];

		
		for (int i = 0; i < objectList.size(); i++)
		{
			// here we create or add to a map between internal IDs and objects
			
			// we check if the object is already in the list
			if (columnObjects.contains(objectList.get(i)))
			{
				// if it is, we get the internal ID relative to it
				int index = columnObjects.indexOf(objectList.get(i));
				ids[i] = columnIds.get(index);				
			}
			else
			{
				// if it isn't, then we create an ID for it, and we add it to the map
				String newId = java.util.UUID.randomUUID().toString();
				columnObjects.add(objectList.get(i));
				columnIds.add(newId);
				ids[i] = newId;
			}
		}
		cachedColumnIds = ids;
		updateColumns = false;
		return cachedColumnIds;
	}
	
	private void createHorizontalHiddenList(int count)
	{
		horizontalHiddenList = new ArrayList<Boolean>();
		for (int i = 0; i < count; i++)
		{
			horizontalHiddenList.add(Boolean.FALSE);
		}
	}
	
	/**
	 * Returns the internal IDs of all the visible rows
	 */
	protected final ArrayList<String> getVisibleRows()
	{
		if (updateRows == false)
			return cachedRowIds;
		
		cachedRowIds = getVisibleRows(verticalTree.getItems());
		updateRows = false;
		return cachedRowIds;
	}
	
	private final ArrayList<String> getVisibleRows(TreeItem[] items)
	{
		ArrayList<String> ids = new ArrayList<String>();

		for (TreeItem item : items)
		{
			int index = rowObjects.indexOf(item.getData());
			
			if (index == -1) // object is not in row list, so add it
			{
				String newId = java.util.UUID.randomUUID().toString();
				rowObjects.add(item.getData());
				rowIds.add(newId);
				ids.add(newId);				
			}
			else // object is found
			{
				ids.add(rowIds.get(index));
			}
			
			if (item.getExpanded() == true)
			{
				ids.addAll(getVisibleRows(item.getItems()));
			}
		}

		return ids;
	}
	
	public int getNumColumns()
	{
		return horizontalTreeTable.getColumnCount();		
	}
	
	public int getNumVisibleRows()
	{
		return getVisibleRows().size();		
	}
	
	/**
	 * Reset the hidden list to be in sync with the new column IDs.  
	 * Important: after this function is executed, the hidden list and the columns may NOT be in sync.
	 *       This function should never be called outside of resetColumns.
	 */	
	private void resetHiddenList(String[] newColumnIds)
	{
		ArrayList<Boolean> prevHiddenList = horizontalHiddenList;
		ArrayList<Boolean> newHiddenList = new ArrayList<Boolean>();

		boolean found;
		
		// recreate the hidden list
		for (int i=0; i<newColumnIds.length; i++)
		{
			found = false;
			for (int j=0; j<prevColumnIds.length; j++)
			{
				if (newColumnIds[i].compareTo(prevColumnIds[j]) == 0)
				{
					if (prevHiddenList.get(j).equals(Boolean.TRUE))
						newHiddenList.add(Boolean.TRUE);
					else
						newHiddenList.add(Boolean.FALSE);
					found = true;
					break;
				}
			}
			
			if (!found)
			{				
				newHiddenList.add(null);
			}
		}
		
		horizontalHiddenList = newHiddenList;		
	}
	
	/**
	 * Add columns if needed.  
	 * Important: after this function is executed, the hidden list and the columns may NOT be in sync.
	 *       This function should never be called outside of resetColumns.
	 */	
	private void addColumns(String[] newColumnIds, String[] prevIds, int[] prevWidth)
	{		
		
		// we add the columns at the end to avoid confusing the table
		// when we recreate the cell editors, they will move the text to 
		// the proper columns
		for (int i=0; i<newColumnIds.length; i++)
		{
			if (horizontalHiddenList.get(i) == null)
			{				
				Object obj = horizontalTreeTableContentProvider.getElement(i);
				Object parent = horizontalTreeTableContentProvider.getParent(obj);
				int parentIndex=-1;
			
				if (parent != null)
					parentIndex = horizontalTreeTableContentProvider.indexOfElement(parent);
				
				// find out if the column should be hidden or not
				boolean parentHidden = false;
				boolean childrenHidden = false;
				
				if (parentIndex > 0)
				{
					if (horizontalHiddenList.get(parentIndex).equals(Boolean.TRUE))
						parentHidden = true;
				
					int firstChildIndex = parentIndex + 1;
					if (firstChildIndex != i)
					{
						if (horizontalHiddenList.get(firstChildIndex).equals(Boolean.TRUE))
							childrenHidden = true;
					}
				}
			
				// calculate the width of the new column
				int newWidth = 0;
				if (parentHidden || childrenHidden)
				{
					horizontalHiddenList.remove(i);
					horizontalHiddenList.add(i, Boolean.TRUE);
				}
				else
				{
					horizontalHiddenList.remove(i);
					horizontalHiddenList.add(i, Boolean.FALSE);
					newWidth = getCellWidth(i);
				}			
				
				// add the column at the end, set default width
				TableColumn newTc = new TableColumn(horizontalTreeTable, SWT.CENTER);
				newTc.setWidth(DEFAULT_COLUMN_WIDTH);
				newTc = new TableColumn(mainTable, SWT.CENTER);
				newTc.setWidth(DEFAULT_COLUMN_WIDTH);
					
				TableColumn tc = horizontalTreeTable.getColumn(i);					
				tc.setWidth(newWidth);
				tc = mainTable.getColumn(i);
				tc.setWidth(newWidth);					
			}			
			else
			{				
				// find the old width of this column
				int width = DEFAULT_COLUMN_WIDTH;
				int j;
				for (j=0; j<prevIds.length; j++)
				{
					if (newColumnIds[i].compareTo(prevIds[j]) == 0)
					{
						width = prevWidth[j];
						break;
					}					
				}
			
				// we resize the column at the new index to the size of the old index 
				TableColumn tc = horizontalTreeTable.getColumn(i);
				tc.setWidth(width);
				
				tc = mainTable.getColumn(i);
				tc.setWidth(width);
			}			
		}
	}

	/**
	 * Remove columns if needed.  This function should never be called outside of resetColumns.
	 */	
	private void removeColumns(String[] newColumnIds)
	{
		boolean found;
		int columnsDeleted = 0;
		
		String[] tmpIds = (String[]) horizontalTreeTableViewer.getColumnProperties();
		for (int i=0; i<tmpIds.length; i++)
		{
			found = false;
			for (int j=0; j<newColumnIds.length; j++)
			{
				if (tmpIds[i].compareTo(newColumnIds[j]) == 0)
				{
					found = true;
					break;
				}				
			}
			
			if (!found)
			{
				TableColumn tc = horizontalTreeTable.getColumn(i-columnsDeleted);
				tc.dispose();
				tc = mainTable.getColumn(i-columnsDeleted);
				tc.dispose();
				
				columnsDeleted++;
			}
		}
	}
		
	/**
	 * Add/remove columns if needed.
	 */	
	protected void resetColumns()
	{
		
		String[] columnIds = getColumnIds();	
		
		// In resetHiddenList the hidden list is recreated.  It is completely up 
		// to date.  The columns may not be.
		resetHiddenList(columnIds);
		
		// backup the current column widths
		String[] prevIds = (String[]) horizontalTreeTableViewer.getColumnProperties();
		int[] prevWidth = new int[prevIds.length];
		
		for (int i=0; i<horizontalTreeTable.getColumns().length; i++)
		{
			TableColumn tc = horizontalTreeTable.getColumn(i);			
			prevWidth[i] = tc.getWidth();			
		}
		
		// This call removes all the extra columns.  After this function, the
		// hidden list and columns may not be in sync.
		removeColumns(columnIds);
		
		// In add columns, we just add the missing columns.
		// Hidden list and columns will now be in sync.
		addColumns(columnIds, prevIds, prevWidth);		
		
		resetTableViewer(horizontalTreeTable, horizontalTreeTableViewer, columnIds);
		resetTableViewer(mainTable, mainTableViewer, columnIds);
		
		// Re-create the previous column list.
		prevColumnIds = new String[columnIds.length];
		for (int i = 0; i < columnIds.length; i++)
		{
			prevColumnIds[i] = columnIds[i];
		}
	}
	

	/**
	 * Force a refresh of the table editor.
	 */
	public void refresh()
	{
		mouseRow = -1;
		mouseColumn = -1;
		
		notifyChanged();
		
		resetColumns();
	
		verticalTreeViewer.refresh();
		
		horizontalTreeTableViewer.refresh();	
	
		mainTableViewer.setInput(getVisibleRows());		
		setNumVisibleRows(maximumHorizontalTreeTableVisibleDepth() + 1);
	}	
	
	protected void refreshCrosshair(int column, int row)
	{
		if (mouseRow != row || mouseColumn != column)
		{
			mouseRow = row;
			mouseColumn = column;		
			
			mainTableViewer.refresh();
			horizontalTreeTableViewer.refresh2();
			verticalTreeViewer.refresh2();
		}
	}

	/**
	 * Get the vertical tree.
	 */
	public final Tree getVerticalTree()
	{
		return verticalTree;
	}
	
	/**
	 * Get the horizontal tree table.
	 */
	public final Table getHorizontalTreeTable()
	{
		return horizontalTreeTable;
	}

	/**
	 * Get the horizontal tree table content provider
	 */
	protected final HorizontalTreeTableContentProvider getHorizontalTreeTableContentProvider()
	{
		return horizontalTreeTableContentProvider;
	}

	/**
	 *  Get the horizontal tree table viewer
	 */
	protected TableViewer getHorizontalTreeTableViewer()
	{
		return horizontalTreeTableViewer;
	}

	/** 
	 * Find the column object with the internal ID
	 */
	protected Object getColumnObject(String id)
	{
		int index=0;
		for (int i=0; i<columnIds.size(); i++)
		{
			if (id.compareTo(columnIds.get(i)) == 0)
			{
				index = i;
				break;				
			}			
		}
		
		return columnObjects.get(index);		
	}	
	
	/** 
	 * Find the row object with the internal ID
	 */
	protected Object getRowObject(String id)
	{
		int index=0;
		for (int i=0; i<rowIds.size(); i++)
		{
			if (id.compareTo(rowIds.get(i)) == 0)
			{
				index = i;
				break;				
			}			
		}
		
		return rowObjects.get(index);		
	}
	
	/**
	 * Get the row for a specific object
	 */
	protected int getRowIndex(String id)
	{
		if (id == null)
			return -1;
		
		ArrayList<String> visibleRows = getVisibleRows();
		int rowIndex=-1;
		for (int i=0; i<visibleRows.size(); i++)
		{
			if (id.compareTo(visibleRows.get(i)) == 0)
			{
				rowIndex = i;
				break;
			}			
		}
		return rowIndex;		
	}
	
	protected int getRowIndex(Object obj)
	{
		String id = null;
		for (int i=0; i<rowObjects.size(); i++)
		{
			if (rowObjects.get(i) == obj)
			{
				id = rowIds.get(i);
				break;
			}			
		}
		return getRowIndex(id);		
	}
	/**
	 * This clears all the caches used in the table editor 
	 */ 
	public void notifyChanged()
	{
		horizontalTreeTableContentProvider.notifyDataChanged();
		
		updateRows = true;
		updateColumns = true;
	}

	/**
	 * Set the horizontal tree content provider
	 */
	public void setHorizontalTreeContentProvider(ITreeContentProvider treeContentProvider)
	{
		this.externalHorizontalTreeContentProvider = treeContentProvider;
	}

	/**
	 * set the horizontal tree label provider
	 */
	public void setHorizontalTreeLabelProvider(ILabelProvider treeLabelProvider)
	{
		this.externalHorizontalTreeLabelProvider = treeLabelProvider;
	}

	/** 
	 * set the table modifier
	 */
	public void setTableModifier(TableEditorCellModifier tableModifier)
	{
		this.mainTableModifier = tableModifier;
	}

	/**
	 * set the horizontal tree input
	 */
	public void setHorizontalTreeInput(Object editorInput)
	{
		this.horizontalTreeInput = editorInput;
		
		if (horizontalTreeTableViewer != null)
		{
			
			horizontalTreeTableViewer.setInput(editorInput);
			
			// temporary until deployment is not used for both rows and columns
			horizontalTreeTableContentProvider.notifyDataChanged();
			notifyRowsChanged();
			notifyColumnsChanged();
			
			resetColumns();
			horizontalTreeTableViewer.refresh();
			
			

		}
	}

	/**
	 * set the vertical tree content provider
	 */
	public void setVerticalTreeContentProvider(ITreeContentProvider verticalTreeContentProvider)
	{
		this.externalVerticalTreeContentProvider = verticalTreeContentProvider;
	}

	/**
	 * set the vertical tree label provider 
	 */
	public void setVerticalTreeLabelProvider(ILabelProvider verticalTreeLabelProvider)
	{
		this.externalVerticalTreeLabelProvider = verticalTreeLabelProvider;
	}

	/**
	 * set the vertical tree input
	 */
	public void setVerticalTreeInput(Object verticalTreeInput)
	{
		this.verticalTreeInput = verticalTreeInput;
		
		if (verticalTreeViewer != null)
		{
			verticalTreeViewer.setInput(verticalTreeInput);	
			verticalTreeViewer.expandAll();	
			
			// temporary until deployment is not used for both rows and columns			
			horizontalTreeTableContentProvider.notifyDataChanged();			
			notifyRowsChanged();
			notifyColumnsChanged();
		}		
	}
	
	/**
	 * Notify the table editor that rows have changed
	 */
	protected void notifyRowsChanged()
	{
		updateRows = true;		
	}
	
	/**
	 * Notify the table editor that columns have changed
	 */
	protected void notifyColumnsChanged()
	{
		updateColumns = true;		
	}

	/**
	 * get the main table listener
	 */
	protected MainTableListener getMainTableListener()
	{
		return mainTableListener;
	}

	/**
	 * get the input stream for the top left image
	 */
	public InputStream getImageStream()
	{
		return imageStream;
	}

	/**
	 * set the input stream for the top left image
	 */
	public void setImageStream(InputStream imageStream)
	{
		this.imageStream = imageStream;
	}

	protected Table getMainTable()
	{
		return mainTable;
	}

	protected int getMouseRow()
	{
		return mouseRow;
	}
	
	protected int getMouseColumn()
	{
		return mouseColumn;
	}

	protected TableViewer getMainTableViewer()
	{
		return mainTableViewer;
	}

	protected TreeViewer getVerticalTreeViewer()
	{
		return verticalTreeViewer;
	}
	
	public TableEditorCallback getCallback()
	{
		return tableEditorCallback;
	}

	public void setCallback(TableEditorCallback tableEditorCallback)
	{
		this.tableEditorCallback = tableEditorCallback;
	}
	
	
	public void setVerticalTreeDropListener(DropTargetListener verticalTreeDropListener)
	{
		this.verticalTreeDropListener = verticalTreeDropListener;		
	}

	public void setHorizontalTreeTableDropListener(DropTargetListener horizontalTreeTableDropListener)
	{
		this.horizontalTreeTableDropListener = horizontalTreeTableDropListener;
	}

}
