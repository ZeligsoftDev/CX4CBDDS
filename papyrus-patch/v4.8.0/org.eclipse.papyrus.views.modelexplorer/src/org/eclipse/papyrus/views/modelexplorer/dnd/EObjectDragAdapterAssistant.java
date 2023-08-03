/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.dnd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.navigator.CommonDragAdapterAssistant;

/**
 * This class allows to provides Drag&Drop between the Model Explorer and the Tables (or others View/Editors)
 *
 *
 *
 */
public class EObjectDragAdapterAssistant extends CommonDragAdapterAssistant {

	/**
	 *
	 * @see org.eclipse.ui.navigator.CommonDragAdapterAssistant#getSupportedTransferTypes()
	 *
	 * @return
	 */
	@Override
	public Transfer[] getSupportedTransferTypes() {
		return new Transfer[] { LocalTransfer.getInstance() };
	}

	/**
	 *
	 * @see org.eclipse.ui.navigator.CommonDragAdapterAssistant#setDragData(org.eclipse.swt.dnd.DragSourceEvent, org.eclipse.jface.viewers.IStructuredSelection)
	 *
	 * @param anEvent
	 * @param aSelection
	 * @return
	 */
	@Override
	public boolean setDragData(DragSourceEvent anEvent, IStructuredSelection aSelection) {
		Iterator<?> iter = aSelection.iterator();
		List<Object> selectedElements = new ArrayList<Object>();

		while (iter.hasNext()) {
			Object current = iter.next();
			EObject eobject = EMFHelper.getEObject(current);
			if (eobject != null) {
				selectedElements.add(eobject);
			}
		}

		if (!selectedElements.isEmpty()) {
			anEvent.data = new StructuredSelection(selectedElements);
		}
		return anEvent.data != null;
	}
}
