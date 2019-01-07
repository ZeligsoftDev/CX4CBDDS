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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * ZDL element label provider
 * 
 * @author ysroh
 * 
 */
public class ZDLElementLabelProvider extends LabelProvider implements ITableLabelProvider {

	@SuppressWarnings("unused")
	private StructuredViewer viewer = null;

	public ZDLElementLabelProvider(StructuredViewer viewer) {
		super();
		this.viewer = viewer;
	}

	@Override
	public String getText(Object object) {
		return getColumnText(object, 0);
	}

	@Override
	public Image getImage(Object object) {
		return getColumnImage(object, 0);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang
	 * .Object, int)
	 */
	@Override
	public Image getColumnImage(Object object, int columnIndex) {
		if (object instanceof EObject) {
			return BaseUIUtil.getIcon((EObject) object);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang
	 * .Object, int)
	 */
	@Override
	public String getColumnText(Object object, int columnIndex) {
		if (!(object instanceof EObject)) {
			return UML2Util.EMPTY_STRING;
		}

		String label = EMFCoreUtil.getName((EObject) object);
		String qualifiedName = EMFCoreUtil.getQualifiedName((EObject) object,
				true);
		// Remove any unnamed element from the qualified name
		qualifiedName = qualifiedName.replaceAll("::<.+>", //$NON-NLS-1$
				UML2Util.EMPTY_STRING);

		label += Messages.ZDLElementLabelProvider_QualifiedNameConnectionLabel
				+ qualifiedName;

		return label;
	}

}
