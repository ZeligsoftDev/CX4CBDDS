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
 *   Andreas Muelder - Initial contribution and API
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Bug 497289
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.Activator;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.widgets.Composite;

/**
 * Support for direct editors
 */
public class DirectEditorEditingSupport extends EditingSupport {

	public DirectEditorEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(final Object element) {
		ICustomDirectEditorConfiguration configuration = getConfigurationAE(element);
		EObject semanticObject = EMFHelper.getEObject(element);
		Composite parent = (Composite) getViewer().getControl();
		configuration.preEditAction(semanticObject);
		return configuration.createCellEditor(parent, semanticObject);
	}

	@Override
	protected boolean canEdit(Object element) {
		return getConfigurationAE(element) != null;
	}

	@Override
	protected Object getValue(Object element) {
		ICustomDirectEditorConfiguration configuration = getConfigurationAE(element);
		Object semanticObject = EMFHelper.getEObject(element);
		return configuration.createParser((EObject) semanticObject)
				.getEditString(new EObjectAdapter((EObject) semanticObject), 0);
	}

	@Override
	protected void setValue(Object element, Object value) {
		ICustomDirectEditorConfiguration configuration = getConfigurationAE(element);
		EObject semanticObject = EMFHelper.getEObject(element);
		IParser parser = configuration.createParser(semanticObject);

		ICommand command = parser.getParseCommand(new EObjectAdapter(
				semanticObject), (String) value, 0);
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(semanticObject);
		editingDomain.getCommandStack().execute(
				new GMFtoEMFCommandWrapper(command));
	}

	/**
	 * Obtain direct editor configuration for an element that can be adapted to
	 * an EObject
	 *
	 * @param element
	 *            an adaptable element
	 * @return The direct editor configuration, if it exists.
	 */
	public static ICustomDirectEditorConfiguration getConfigurationAE(final Object element) {
		EObject semanticObject = EMFHelper.getEObject(element);
		return getConfiguration(semanticObject);
	}

	/**
	 * Obtain direct editor configuration for a semantic element
	 *
	 * @param semanticElement
	 *            a semantic element
	 * @return The direct editor configuration, if it exists.
	 */
	public static ICustomDirectEditorConfiguration getConfiguration(final EObject semanticElement) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		if (null != semanticElement) {
			EClass eClass = semanticElement.eClass();
			String semanticClassName = eClass.getInstanceClassName();
			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT + semanticClassName;
			String languagePreferred = store.getString(key);

			IDirectEditorConfiguration configuration = null;

			if (null != languagePreferred && !languagePreferred.isEmpty()) {
				configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, semanticElement, semanticElement);
			} else {
				configuration = getConfigurationSuperType(eClass, semanticElement);
			}

			if (configuration instanceof ICustomDirectEditorConfiguration) {
				return (ICustomDirectEditorConfiguration) configuration;
			}
		}

		return null;
	}

	/**
	 * Obtain an editor configuration compatible with a superType of an EClass.
	 * 
	 * @param basedEClass
	 *            The based EClass.
	 * @param semanticElement
	 *            The renamed semantic element.
	 * @return The editor configuration, if it exists.
	 */
	public static IDirectEditorConfiguration getConfigurationSuperType(final EClass basedEClass, final EObject semanticElement) {
		IDirectEditorConfiguration configuration = null;
		List<EClass> eClasses = basedEClass.getESuperTypes();

		if (null != eClasses && !eClasses.isEmpty()) {
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			int i = 0;
			while (i < eClasses.size() && null == configuration) {
				EClass eClass = eClasses.get(i);
				String semanticClassName = eClass.getInstanceClassName();
				String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT + semanticClassName;
				String languagePreferred = store.getString(key);

				// If language has found, get the corresponding configuration.
				if (languagePreferred != null && !languagePreferred.isEmpty()) {
					configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, semanticElement, semanticElement);
					if (!configuration.isSuperType()) {
						configuration = getConfigurationSuperType(eClass, semanticElement);
					}
				} else {
					configuration = getConfigurationSuperType(eClass, semanticElement);
				}

				i++;
			}
		}

		return configuration;
	}
}
