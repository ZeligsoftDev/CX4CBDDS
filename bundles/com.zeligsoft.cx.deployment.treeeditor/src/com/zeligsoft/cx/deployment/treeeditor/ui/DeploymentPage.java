package com.zeligsoft.cx.deployment.treeeditor.ui;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ICloseablePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.zeligsoft.cx.deployment.treeeditor.ui.DeploymentFormPage.PageForm;
import com.zeligsoft.cx.ui.properties.utils.CXPropertiesWidgetFactory;

public class DeploymentPage implements ICloseablePart {

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyListener(IPropertyListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyListener(IPropertyListener listener) {
		// TODO Auto-generated method stub
		
	}
	
	public Composite createControl(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;

		GridData data = new GridData(GridData.FILL_BOTH);
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(layout);
		if (data != null) {
			composite.setLayoutData(data);
		}
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("HELLO");
				

		return composite;
		//ScrolledForm form = createScrolledForm(parent);
		//form.setBounds(0, 0, 100, 100);
		//PageForm pageForm = new PageForm(this, form);
	}

	public ScrolledForm createScrolledForm(Composite parent) {
		ScrolledForm form = new ScrolledForm(parent, Window
				.getDefaultOrientation());
		form.setExpandHorizontal(true);
		form.setExpandVertical(true);
		form.setFont(JFaceResources.getHeaderFont());
		return form;
	}
	
	protected static class PageForm extends ManagedForm {
		public PageForm(FormPage page, ScrolledForm form) {
			super(page.getEditor().getToolkit(), form);
			setContainer(page);
		}

		public FormPage getPage() {
			return (FormPage) getContainer();
		}

		@Override
		public void dirtyStateChanged() {
			getPage().getEditor().editorDirtyStateChanged();
		}

		@Override
		public void staleStateChanged() {
			if (getPage().isActive())
				refresh();
		}
	}
}
