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
package com.zeligsoft.base.toolingmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Palette</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.Palette#getDrawer <em>Drawer</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPalette()
 * @model
 * @generated
 */
public interface Palette extends PaletteItem {

	/**
	 * Returns the value of the '<em><b>Drawer</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.toolingmodel.Drawer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drawer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drawer</em>' containment reference list.
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPalette_Drawer()
	 * @model containment="true"
	 * @generated
	 */
	EList<Drawer> getDrawer();

} // Palette
