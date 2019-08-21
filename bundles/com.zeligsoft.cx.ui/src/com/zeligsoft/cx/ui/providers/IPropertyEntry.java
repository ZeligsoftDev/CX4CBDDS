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

package com.zeligsoft.cx.ui.providers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * IPropertyEntry is used to access property entry data model. This interface
 * should be implemented by classes that wish to act as property entry.
 * 
 * @author ysroh
 * 
 */
public interface IPropertyEntry {

	/**
	 * Queries the name of the model object.
	 * 
	 * @return
	 */
	public String getModelObjectName();

	/**
	 * Queries the column label for the property column.
	 * 
	 * @return
	 */
	public String getPropertyColumnLabel(int column);

	/**
	 * Queries the current value shown in the property wizard.
	 * 
	 * @return
	 */
	public String getValue();

	/**
	 * Queries if the current value is a default value of the model object.
	 * 
	 * @return
	 */
	public boolean isDefaultValue();

	/**
	 * Sets the current value.
	 * 
	 * @param value
	 */
	public void setValue(String value);

	/**
	 * Queries the model object.
	 * 
	 * @return
	 */
	public EObject getModelObject();

	/**
	 * Queries the default value of this model object.
	 * 
	 * @return
	 */
	public String getDefaultValue();

	/**
	 * Queries the list of child entries.
	 * 
	 * @return
	 */
	public List<IPropertyEntry> getChildren();

	/**
	 * Queries the parent entry.
	 * 
	 * @return
	 */
	public IPropertyEntry getParent();

	/**
	 * Queries if this entry is a leaf entry.
	 * 
	 * @return
	 */
	public boolean isLeaf();

	/**
	 * Queries if this entry is a sequence type
	 * 
	 * @return
	 */
	public boolean isMultiValue();

	/**
	 * Add child to this entry
	 * 
	 * @param modelElement
	 * @return
	 */
	public IPropertyEntry addChild(EObject modelElement);

	/**
	 * Queries the root entry
	 * 
	 * @param modelElement
	 * @return
	 */
	public IPropertyEntry getRootEntry();

	/**
	 * Creates new property entry with given element
	 * 
	 * @return
	 */
	public IPropertyEntry createNewEntry(EObject element);
}
