/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.datatype;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.uml.properties.Activator;


public class DataTypeProvider {

	private final Map<String, Class<? extends DataTypeObservableValue>> observableDataTypes = new HashMap<String, Class<? extends DataTypeObservableValue>>();

	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".datatype"; //$NON-NLS-1$

	private DataTypeProvider() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for (IConfigurationElement e : config) {
			String dataTypeName = e.getAttribute("dataType"); //$NON-NLS-1$
			String observableClassName = e.getAttribute("observable"); //$NON-NLS-1$

			Class<? extends DataTypeObservableValue> observableClass = ClassLoaderHelper.loadClass(observableClassName, DataTypeObservableValue.class);

			if (observableClass != null) {
				observableDataTypes.put(dataTypeName, observableClass);
			}
		}
	}

	public DataTypeObservableValue getObservableDataType(EDataType dataType) {
		for (String key : observableDataTypes.keySet()) {
			if (key.equals(dataType.getName())) {
				return ClassLoaderHelper.newInstance(observableDataTypes.get(key));
			}
		}
		return null;
	}

	public boolean canHandle(EDataType eType) {
		return this.observableDataTypes.containsKey(eType.getName());
	}

	public static final DataTypeProvider instance = new DataTypeProvider();
}
