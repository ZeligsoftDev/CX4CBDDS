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

package com.zeligsoft.ce.rsm.ui.wizard.pages;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.ibm.xtools.common.ui.wizards.pagegroups.ITemplateConfigurationPage;
import com.ibm.xtools.common.ui.wizards.pagegroups.ITemplateConfigurationPageGroup;
import com.zeligsoft.ce.domainregistration.DomainSpecialization;
import com.zeligsoft.ce.domainregistration.DomainRegistry;
import com.zeligsoft.ce.rsm.ui.wizard.providers.DomainSpecializationContentProvider;
import com.zeligsoft.ce.rsm.ui.wizard.providers.DomainSpecializationLabelProvider;

/**
 * 
 * @author jcorchis
 * 
 */
public class DomainSpecializationWizardPage extends WizardPage implements ITemplateConfigurationPage
{
	private CheckboxTableViewer checkboxTableViewer = null;
	private Composite container = null;

	public DomainSpecializationWizardPage()
	{
		super(Messages.getString("DomainSpecializationWizardPage.1"), //$NON-NLS-1$
				Messages.getString("DomainSpecializationWizardPage.0"), (ImageDescriptor) null);//$NON-NLS-1$
		
		setDescription(Messages.getString("DomainSpecializationWizardPage.2"));//$NON-NLS-1$
	}

	private ITemplateConfigurationPageGroup group = null;

	public void createControl(Composite parent)
	{
		DomainRegistry.loadInfoFromExtensionPoint();
		
		Font font = parent.getFont();

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setFont(font);

		Label referenceLabel = new Label(composite, SWT.NONE);
		referenceLabel.setText(Messages.getString("DomainSpecializationWizardPage.1"));//$NON-NLS-1$
		referenceLabel.setFont(font);

		checkboxTableViewer = CheckboxTableViewer.newCheckList(composite, SWT.BORDER);
		checkboxTableViewer.getTable().setFont(composite.getFont());
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.verticalAlignment = GridData.FILL;
		data.grabExcessVerticalSpace = true;

		data.heightHint = getDefaultFontHeight(checkboxTableViewer.getTable(), 15);
		checkboxTableViewer.getTable().setLayoutData(data);
		checkboxTableViewer.setLabelProvider(new DomainSpecializationLabelProvider());
		checkboxTableViewer.setContentProvider(new DomainSpecializationContentProvider());
		checkboxTableViewer.setComparator(new ViewerComparator());

		final Table table = checkboxTableViewer.getTable();
		table.setHeaderVisible(true);

		final TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(200);
		tableColumn.setText(Messages.getString("DomainSpecializationWizardPage.3")); //$NON-NLS-1$

		final TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(250);
		tableColumn_1.setText(Messages.getString("DomainSpecializationWizardPage.4")); //$NON-NLS-1$

		final TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText(Messages.getString("DomainSpecializationWizardPage.5")); //$NON-NLS-1$
		
		setControl(composite);

	}

	public ITemplateConfigurationPageGroup getTemplateConfigurationPageGroup() {
		return this.group;
	}

	public void setITemplateConfigurationPageGroup(
			ITemplateConfigurationPageGroup group) {
		this.group = group;
	}

	public boolean canFlipToNextPage() {
		return false;
	}

	public boolean isPageComplete() {
		return true;
	}

	public void dispose() {
		container.dispose();

	}

	public void setVisible(boolean visible)
	{
		if (visible) 
		{			
			checkboxTableViewer.setInput(DomainRegistry.getDomainArray());
		}
	}

	/**
	 * Returns the registered model libraries selected by the user.
	 * 
	 * @return the registered model libraries
	 */
	public DomainSpecialization[] getSelectedDomains()
	{
		Object[] elements = this.checkboxTableViewer.getCheckedElements();
		DomainSpecialization[] domains = new DomainSpecialization[elements.length];
		System.arraycopy(elements, 0, domains, 0, elements.length);
		return domains;
	}

	/**
	 * Get the default widget height for the supplied control.
	 * 
	 * @return int
	 * @param control -
	 *            the control being queried about fonts
	 * @param lines -
	 *            the number of lines to be shown on the table.
	 */
	private static int getDefaultFontHeight(Control control, int lines) {
		FontData[] viewerFontData = control.getFont().getFontData();
		int fontHeight = 10;

		// If we have no font data use our guess
		if (viewerFontData.length > 0) {
			fontHeight = viewerFontData[0].getHeight();
		}
		return lines * fontHeight;

	}

}
