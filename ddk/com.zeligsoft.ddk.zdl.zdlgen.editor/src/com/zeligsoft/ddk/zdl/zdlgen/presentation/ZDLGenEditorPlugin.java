/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.presentation;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.ui.EclipseUIPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

import org.eclipse.uml2.uml.edit.UMLEditPlugin;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;

/**
 * This is the central singleton for the ZDLGen editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class ZDLGenEditorPlugin extends EMFPlugin {

	/**
	 * The ZDLGen Editor's ID, which is useful for clients that need to open the
	 * editor on a ZDLGen instance and make sure that the correct editor is used.
	 */
	public static final String EDITOR_ID = "com.zeligsoft.ddk.zdl.zdlgen.presentation.ZDLGenEditorID"; //$NON-NLS-1$

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ZDLGenEditorPlugin INSTANCE = new ZDLGenEditorPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZDLGenEditorPlugin() {
		super(new ResourceLocator[] { EcoreEditPlugin.INSTANCE, UMLEditPlugin.INSTANCE, });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipseUIPlugin {

		/**
		 * @generated NOT
		 */
		public static final String PLUGIN_ID = "com.zeligsoft.ddk.zdl.zdlgen.editor"; //$NON-NLS-1$

		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}

		/**
		 * Write error log with the given exception
		 * 
		 * @param message
		 *            human readable message for this exception cause
		 * @param e
		 *            Exception thrown
		 *            
		 * @generated NOT
		 */
		public void error(String message, Throwable e) {
			ZeligsoftAbstractPlugin.error(this, message, e);
		}

		/**
		 * Write warning log with the given exception
		 * 
		 * @param message
		 *            human readable message for this exception cause
		 * @param e
		 *            Exception thrown
		 *            
		 * @generated NOT
		 */
		public void warning(String message, Throwable e) {
			ZeligsoftAbstractPlugin.warning(this, message, e);
		}

		/**
		 * Write warning log
		 * 
		 * @param message
		 *            Warning message
		 *            
		 *            
		 * @generated NOT
		 */
		public void warning(String message) {
			warning(message, null);
		}
	}

}
