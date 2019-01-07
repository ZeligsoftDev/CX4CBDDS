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

package com.zeligsoft.ce.tableeditor.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.zeligsoft.ce.tableeditor.TableEditor;

public class TableEditorTest extends TestCase
{
	TableEditor editor;
	
	ArrayList<TestItem> input;
	Shell shell;
	boolean initialized;

	public TableEditorTest(String name)
	{
		super(name);
		initialized = false;
	}
	
	public static void main(String[] args)
	{
		TestRunner.run(TableEditorTest.class);
	}
	
	private void init()
	{
		if (initialized)
			return;
	
		shell = new Shell();
		
		editor = new TableEditor(shell, 0); // style = 0
		
		TreeContentProvider treeContentProvider = new TreeContentProvider();
		TreeLabelProvider treeLabelProvider = new TreeLabelProvider();
		
		editor.setHorizontalTreeContentProvider(treeContentProvider);
		editor.setHorizontalTreeLabelProvider(treeLabelProvider);
		
		editor.setVerticalTreeContentProvider(treeContentProvider);
		editor.setVerticalTreeLabelProvider(treeLabelProvider);
		
		//editor.setTableLabelProvider(new TableLabelProvider());
		//editor.setTableModifier(new TableModifier());
		
		resetInput();
		
		editor.setHorizontalTreeInput(input);
		editor.setVerticalTreeInput(input);
		
		editor.createTableEditor();
	}
		
		
	
	private void resetInput()
	{
		input = new ArrayList<TestItem>();
		
		TestItem rootItem = new TestItem();
		rootItem.setName("root1");
		
		TestItem childItem = new TestItem();
		childItem.setName("child1");
		rootItem.addChild(childItem);
		
		childItem = new TestItem();
		childItem.setName("child2");
		rootItem.addChild(childItem);
		
		childItem = new TestItem();
		childItem.setName("child3");
		rootItem.addChild(childItem);
		
		input.add(rootItem);
		
		rootItem = new TestItem();
		rootItem.setName("root2");
		
		childItem = new TestItem();
		childItem.setName("child1");
		rootItem.addChild(childItem);

		input.add(rootItem);
		
		rootItem = new TestItem();
		rootItem.setName("root3");		
		
		input.add(rootItem);		
	}
	
	public void test_getNumColumns()
	{
		init();
		
		assertEquals(7, editor.getNumColumns());		
	}
	
	public void test_addColumn_root()
	{
		init();
		
		assertEquals(7, editor.getNumColumns());
		
		TestItem rootItem = new TestItem();
		rootItem.setName("root4");		
		
		input.add(rootItem);
		editor.setHorizontalTreeInput(input);		
		
		assertEquals(8, editor.getNumColumns());
		
		resetInput();
	}
	
	public void test_addColumn_child()
	{
		init();
		
		assertEquals(7, editor.getNumColumns());
		
		TestItem rootItem = input.get(2);
		
		TestItem childItem = new TestItem();
		childItem.setName("child2");		
		
		rootItem.addChild(childItem);
		
		editor.setHorizontalTreeInput(input);		
		
		assertEquals(8, editor.getNumColumns());
		
		resetInput();		
	}
	
	public void test_addColumn_grandchild()
	{
		init();
		
		assertEquals(7, editor.getNumColumns());
		
		TestItem rootItem = input.get(1);
		TestItem childItem = rootItem.getChildren().get(0);
		
		TestItem grandchildItem = new TestItem();
		grandchildItem.setName("grandchild");
		
		childItem.addChild(grandchildItem);
		
		editor.setHorizontalTreeInput(input);		
		
		assertEquals(8, editor.getNumColumns());
		
		resetInput();
		
		
	}
	
	public void test_getVisibleRows()
	{
		init();
		
		assertEquals(7, editor.getNumVisibleRows());		
	}
	
	
	public void test_addRow()
	{
		init();
		
		assertEquals(7, editor.getNumVisibleRows());
		
		TestItem rootItem = new TestItem();
		rootItem.setName("root4");	
		
		input.add(rootItem);
		editor.setVerticalTreeInput(input);
		
		assertEquals(8, editor.getNumVisibleRows());
		
		resetInput();
		
	}	
	
	private void collapseObject(int index)
	{
		editor.collapseColumnObject(index);
		
		ArrayList<TestItem> items = getFlatListOfTestItems(input);		
		TestItem ti = items.get(index);
		ti.collapse();		
	}
	
	private void expandObject(int index)
	{
		editor.expandColumnObject(index);
		
		ArrayList<TestItem> items = getFlatListOfTestItems(input);
		TestItem ti = items.get(index);
		ti.expand();
		
	}
	
	private void checkColumnVisibility()
	{
		ArrayList<TestItem> items = getFlatListOfTestItems(input);
		Table table = editor.getHorizontalTreeTable();
		
		for (int i=0; i<items.size(); i++)
		{
			TestItem ti = items.get(i);			
			TableColumn tc = table.getColumn(i);
			
			if (ti.isVisible())
			{
				assertTrue(tc.getWidth() != 0);				
			}
			else
			{
				assertTrue(tc.getWidth() == 0);				
			}		
		}	
	}
	
	public void test_checkColumnVisibility()
	{
		init();
		
		checkColumnVisibility();		
		
	}
	
	public void test_collapseColumns()
	{
		init();
		
		collapseObject(0);
		checkColumnVisibility();
		
		resetInput();
		
	}
	
	public void test_expandColumns()
	{
		init();
		
		checkColumnVisibility();
		collapseObject(0);
		
		checkColumnVisibility();
		expandObject(0);
		
		checkColumnVisibility();		
		
	}
	
	
	public void test_allColumnsExpanded()
	{
		init();
		
		checkColumnVisibility();
	}
	
	public void test_allRowsExpanded()
	{
		init();
		
		assertEquals(7, editor.getNumVisibleRows());		
	}
	
	public void test_collapseParent()
	{
		init();
		
		Tree tree = editor.getVerticalTree();
		TreeItem ti = tree.getItem(0);
		
		ti.setExpanded(false);
		
		assertEquals(4, editor.getNumVisibleRows());	
	}
		
	public ArrayList<TestItem> getFlatListOfTestItems(ArrayList<TestItem> items)
	{
		ArrayList<TestItem> flatListOfItems = new ArrayList<TestItem>();
		
		for (int i=0; i<items.size(); i++)
		{
			flatListOfItems.add(items.get(i));
			flatListOfItems.addAll(getFlatListOfTestItems(items.get(i).getChildren()));			
		}
		
		return flatListOfItems;		
	}

	
	public int getMaximumDepth()
	{	
		ArrayList<TestItem> items = getFlatListOfTestItems(input);
		
		int maxDepth = -1;
		
		for (int i=0; i<items.size(); i++)
		{
			int depth = items.get(i).getDepth();
			
			if (depth > maxDepth)
				maxDepth = depth;
		}
		
		return maxDepth;
	}
	
	public void checkTableContent()
	{		
		int maxDepth = getMaximumDepth();
		ArrayList<TestItem> items = getFlatListOfTestItems(input);
		
		Table table = editor.getHorizontalTreeTable();
		
		TableItem[] tableItem = table.getItems();
		
		for (int i=0; i<items.size(); i++)
		{
			TestItem testItem = items.get(i);
			String name = testItem.getName();
			int depth = testItem.getDepth();
			
			if (testItem.hasChildren())
			{
				//if (testItem.childrenVisible())
//					name = "- " + name;
	//			else
		//			name = "+ " + name;
			}
			
			for (int j=0; j<maxDepth; j++)
			{
				if (j == depth)
					assertEquals(name, tableItem[j].getText(i));
				else
					assertEquals("", tableItem[j].getText(i));
			}
		}		
	}
	
	public void test_checkTableContent()	
	{
		init();
		
		checkTableContent();		
	}
	
	public void test_addColumn2_root()	
	{
		init();
		
		TestItem rootItem = new TestItem();
		rootItem.setName("root4");	
		input.add(rootItem);
		
		editor.setHorizontalTreeInput(input);
		checkTableContent();
		
		resetInput();
		
	}
	
	public void test_addColumn2_grandchild()	
	{
		init();
		
		TestItem rootItem = input.get(1);
		TestItem childItem = rootItem.getChildren().get(0);
		
		TestItem grandchildItem = new TestItem();
		grandchildItem.setName("grandchild");
		
		childItem.addChild(grandchildItem);
		
		editor.setHorizontalTreeInput(input);
		checkTableContent();
		
		resetInput();
		
	}
	
	public void test_addColumn2_child()	
	{
		init();
		
		TestItem rootItem = input.get(2);
		
		TestItem childItem = new TestItem();
		childItem.setName("child");
		
		rootItem.addChild(childItem);
		
		editor.setHorizontalTreeInput(input);
		checkTableContent();
		
		resetInput();		
	}
	
	private void removeObject(int index)
	{
		ArrayList<TestItem> items = getFlatListOfTestItems(input);
		
		TestItem ti = items.get(index);
		
		// if this is a root object, remove it from the input
		if (input.contains(ti))
		{
			input.remove(ti);			
		}
		
		ti.destroy();
	}
	
	
	private void bulkAdd()
	{		
		TestItem rootItem = new TestItem();
		rootItem.setName("root4");
		
		TestItem childItem = new TestItem();
		childItem.setName("child1");
		rootItem.addChild(childItem);
		
		childItem = new TestItem();
		childItem.setName("child2");
		rootItem.addChild(childItem);
		
		childItem = new TestItem();
		childItem.setName("child3");
		rootItem.addChild(childItem);
		
		input.add(rootItem);
		
		rootItem = new TestItem();
		rootItem.setName("root5");
		
		childItem = new TestItem();
		childItem.setName("child1");
		rootItem.addChild(childItem);

		input.add(rootItem);
		
		rootItem = new TestItem();
		rootItem.setName("root6");		
		
		input.add(rootItem);		
	}
	
	public void bulkRemove()
	{
		removeObject(13); // remove root6
		removeObject(10); // remove child3 of root4
		removeObject(0); // remove root1
	}
	
	public void test_bulkAdd()
	{
		init();
		
		collapseObject(0); // collapse root1
		collapseObject(4); // collapse root2
		
		bulkAdd();
		
		editor.setHorizontalTreeInput(input);
		
		checkColumnVisibility();
		checkTableContent();
		
		
		resetInput();
		
	}
	
	public void test_bulkRemove()
	{
		init();
		
		collapseObject(0); // collapse root1
		
		bulkAdd();		
		editor.setHorizontalTreeInput(input);
		collapseObject(12); // collapse root5
		
		bulkRemove();		
		editor.setHorizontalTreeInput(input);
		
		checkColumnVisibility();
		checkTableContent();		
		
		resetInput();		
	}
	
	public void test_collapseLeaf()
	{
		init();
		
		collapseObject(1);
		checkColumnVisibility();
		
		resetInput();		
	}
	
	public void test_bulkAddAndRemove()
	{
		init();
		
		collapseObject(0); // collapse root1
		
		bulkAdd();		
		bulkRemove();		
		
		editor.setHorizontalTreeInput(input);
		
		checkColumnVisibility();
		checkTableContent();		
		
		resetInput();		
	}
}

	