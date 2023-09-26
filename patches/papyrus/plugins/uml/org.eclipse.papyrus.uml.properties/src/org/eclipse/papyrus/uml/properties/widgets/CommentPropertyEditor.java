/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Sebastien Poissonnet (CEA LIST) sebastien.poissonnet@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.papyrus.infra.properties.ui.widgets.MultiReferenceEditorWithPropertyView;
import org.eclipse.papyrus.infra.properties.ui.widgets.MultiReferencePropertyEditorWithPropertyView;
import org.eclipse.swt.widgets.Composite;

public class CommentPropertyEditor extends MultiReferencePropertyEditorWithPropertyView {

	public CommentPropertyEditor(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected MultiReferenceEditorWithPropertyView createMultiReferenceEditorWithPropertyView(Composite parent, int style) {
		return new CommentEditor(parent, style);
	}

}
