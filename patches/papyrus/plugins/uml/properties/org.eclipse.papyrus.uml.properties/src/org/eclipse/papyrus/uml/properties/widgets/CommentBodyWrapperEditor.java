/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Shuai Li (CEA LIST) <shuai.li@cea.fr> - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.ui.Activator;
import org.eclipse.papyrus.infra.ui.preferences.RichtextPreferencePage;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Wraps the simple comment editor and the rich text comment editor
 *
 */
public class CommentBodyWrapperEditor extends AbstractPropertyEditor {
	private CommentBodyEditor normalEditor;
	private CommentBodyRichTextEditor richTextEditor;
	
	/**
	 * Instantiates a new comment body wrapper editor.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public CommentBodyWrapperEditor(Composite parent, int style) {
		if (Platform.getPreferencesService().getBoolean(Activator.PLUGIN_ID, RichtextPreferencePage.USE_CK_EDITOR, false, null)) {
			richTextEditor = new CommentBodyRichTextEditor(parent, style);
			normalEditor = null;
		} else {
			normalEditor = new CommentBodyEditor(parent, style);
			richTextEditor = null;
		}
		
		if (richTextEditor == null && normalEditor == null) {
			normalEditor = new CommentBodyEditor(parent, style);
		}
	}

	@Override
	protected void doBinding() {
		if (normalEditor != null) {
			normalEditor.doBinding();
		} else if (richTextEditor != null) {
			richTextEditor.doBinding();
		} else {
			super.doBinding();
		}
	}

	@Override
	public void setProperty(String path) {
		if (normalEditor != null) {
			normalEditor.setProperty(path);
		} else if (richTextEditor != null) {
			richTextEditor.setProperty(path);
		} else {
			super.setProperty(path);
		}
	}

	@Override
	public void updateLabel() {
		if (normalEditor != null) {
			normalEditor.updateLabel();
		} else if (richTextEditor != null) {
			richTextEditor.updateLabel();
		} else {
			super.updateLabel();
		}
	}

	@Override
	public void updateLabel(String label) {
		if (normalEditor != null) {
			normalEditor.updateLabel(label);
		} else if (richTextEditor != null) {
			richTextEditor.updateLabel(label);
		} else {
			super.updateLabel(label);
		}
	}

	@Override
	public String getProperty() {
		if (normalEditor != null) {
			return normalEditor.getProperty();
		} else if (richTextEditor != null) {
			return richTextEditor.getProperty();
		}
		return super.getProperty();
	}

	@Override
	public void setInput(DataSource input) {
		if (normalEditor != null) {
			normalEditor.setInput(input);
		} else if (richTextEditor != null) {
			richTextEditor.setInput(input);
		} else {
			super.setInput(input);
		}
	}

	@Override
	public DataSource getInput() {
		if (normalEditor != null) {
			return normalEditor.getInput();
		} else if (richTextEditor != null) {
			return richTextEditor.getInput();
		}
		return super.getInput();
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		if (normalEditor != null) {
			normalEditor.setReadOnly(readOnly);
		} else if (richTextEditor != null) {
			richTextEditor.setReadOnly(readOnly);
		} else {
			super.setReadOnly(readOnly);
		}
	}

	@Override
	public AbstractEditor getEditor() {
		if (normalEditor != null) {
			return normalEditor.getEditor();
		} else if (richTextEditor != null) {
			return richTextEditor.getEditor();
		}
		return super.getEditor();
	}

	@Override
	public boolean getReadOnly() {
		if (normalEditor != null) {
			return normalEditor.getReadOnly();
		} else if (richTextEditor != null) {
			return richTextEditor.getReadOnly();
		}
		return super.getReadOnly();
	}

	@Override
	public void setLayoutData(Object data) {
		if (normalEditor != null) {
			normalEditor.setLayoutData(data);
		} else if (richTextEditor != null) {
			richTextEditor.setLayoutData(data);
		} else {
			super.setLayoutData(data);
		}
	}

	@Override
	public Object getLayoutData() {
		if (normalEditor != null) {
			return normalEditor.getLayoutData();
		} else if (richTextEditor != null) {
			return richTextEditor.getLayoutData();
		}
		return super.getLayoutData();
	}

	@Override
	public void setShowLabel(boolean showLabel) {
		if (normalEditor != null) {
			normalEditor.setShowLabel(showLabel);
		} else if (richTextEditor != null) {
			richTextEditor.setShowLabel(showLabel);
		} else {
			super.setShowLabel(showLabel);
		}
	}

	@Override
	public boolean getShowLabel() {
		if (normalEditor != null) {
			return normalEditor.getShowLabel();
		} else if (richTextEditor != null) {
			return richTextEditor.getShowLabel();
		}
		return super.getShowLabel();
	}

	@Override
	public void setCustomLabel(String customLabel) {
		if (normalEditor != null) {
			normalEditor.setCustomLabel(customLabel);
		} else if (richTextEditor != null) {
			richTextEditor.setCustomLabel(customLabel);
		} else {
			super.setCustomLabel(customLabel);
		}
	}

	@Override
	public String getCustomLabel() {
		if (normalEditor != null) {
			return normalEditor.getCustomLabel();
		} else if (richTextEditor != null) {
			return richTextEditor.getCustomLabel();
		}
		return super.getCustomLabel();
	}

	@Override
	public Control getControl() {
		if (normalEditor != null) {
			return normalEditor.getControl();
		} else if (richTextEditor != null) {
			return richTextEditor.getControl();
		}
		return super.getControl();
	}

	@Override
	public IValidator getValidator() {
		if (normalEditor != null) {
			return normalEditor.getValidator();
		} else if (richTextEditor != null) {
			return richTextEditor.getValidator();
		}
		return super.getValidator();
	}
}
