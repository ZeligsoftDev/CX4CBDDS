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

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;

/**
 * The class is extended to provide callback functions to the table editor.   
 */
public abstract class TableEditorCallback
{

	/**
	 * Handles double clicking on the main table.  The variables passed are the column object and the row object.
	 */
	abstract public void doubleClick(Object columnObject, Object rowObject);
	
	/**
	 * Handles right clicking on the main table.
	 */
	abstract public void rightClick(MouseEvent e);
	
	/**
	 * Gets the text associated with two objects on the main table.
	 */
	abstract public String getText(Object columnObject, Object rowObject);
	
	/**
	 * Get the image associated with two objects on the main table.
	 */
	abstract public Image getImage(Object columnObject, Object rowObject);

}
