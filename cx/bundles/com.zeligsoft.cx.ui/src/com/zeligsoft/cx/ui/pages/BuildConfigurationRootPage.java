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
package com.zeligsoft.cx.ui.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.providers.BuildConfigurationContentProvider;

/**
 * Build configuration root page
 * 
 * @author ysroh
 * 
 */
public class BuildConfigurationRootPage
		extends AbstractBuildConfigurationPage {

	// local build configuration input fields
	protected Map<String, Map<String, Control>> inputControlMap = new HashMap<String, Map<String, Control>>();

	// base build configuration input fields
	protected Map<String, Map<String, Control>> baseInputControlMap;

	// base build configuration drop down list
	protected Combo selectionCombo;

	// default selection of the base configuration
	protected int defaultSelectedIndex = -1;

	// available shared build configurations
	protected InstanceSpecification[] buildConfigurations;

	public static String ID = "rootPage"; //$NON-NLS-1$
	
	private boolean localTabShown = false; 

	/**
	 * Constructor
	 */
	public BuildConfigurationRootPage() {
		super(ID, Messages.BuildConfigurationRootPage_RootPageTitle);
	}
	
	public BuildConfigurationRootPage(String Id, String pageTitle){
		super(Id, pageTitle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.base.ui.pages.AbstractBuildConfigurationPage#createPageContents
	 * (org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createPageContents(Composite parent) {

		createBuildConfigurationSelectionArea(parent);

		createBuildConfigurationContent(parent);

		addSelectionComboToInputControlMap();
		
		restoreDefaults();

		return parent;
	}
	
	protected void addSelectionComboToInputControlMap(){

		Map<String, Control> map = new HashMap<String, Control>();
		map.put(INPUT_CONTROL_KEY, selectionCombo);
		inputControlMap.put("buildconfiguration", map); //$NON-NLS-1$

		int index = selectionCombo.getSelectionIndex();
		if (index != -1) {
			setSelectedBaseBuildConfiguration(buildConfigurations[index]);
		}
	}
	
	protected void createBuildConfigurationContent(Composite parent){
		// Create widget
		final TabFolder root = new TabFolder(parent, SWT.NULL);
		root.setLayout(new GridLayout(1, false));
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = 600;
		root.setLayoutData(data);

		TabItem baseTab = new TabItem(root, SWT.NULL);
		baseTab.setText(Messages.BuildConfigurationRootPage_BaseTabLabel);

		Composite baseArea = new Composite(root, SWT.NULL);
		baseArea.setLayout(new GridLayout(1, false));
		baseArea.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		baseTab.setControl(baseArea);

		baseInputControlMap = buildBaseWidgetFromPropertyList(baseArea,
				getProperties());

		final TabItem localTab = new TabItem(root, SWT.NULL);
		localTab.setText(Messages.BuildConfigurationRootPage_LocalTabLabel);

		root.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.item == localTab) {
					if(!localTabShown){
						localTabShown = true;
						createLocalTabContent(root, localTab);
					}
				}
			}
		});
	}
	
	void createLocalTabContent(Composite root, TabItem tab) {
		Composite localArea = new Composite(root, SWT.NULL);
		localArea.setLayout(new GridLayout(1, false));
		localArea.setLayoutData(new GridData(GridData.FILL_BOTH));
		Map<String, Map<String, Control>> map = buildWidgetFromPropertyList(
				localArea, getProperties());
		inputControlMap.putAll(map);
		tab.setControl(localArea);
		restoreDefaults(map);
	}

	protected EList<Property> getProperties(){
		
		EList<Property> properties = new BasicEList<Property>();

		properties.add(propertyMap.get("cc_defines")); //$NON-NLS-1$
		properties.add(propertyMap.get("cc_undefines")); //$NON-NLS-1$
		properties.add(propertyMap.get("cc_include_paths")); //$NON-NLS-1$
		properties.add(propertyMap.get("cc_flags")); //$NON-NLS-1$
		properties.add(propertyMap.get("cc_ppflags")); //$NON-NLS-1$
		properties.add(propertyMap.get("ld_flags")); //$NON-NLS-1$
		properties.add(propertyMap.get("ld_libraries")); //$NON-NLS-1$
		properties.add(propertyMap.get("ld_library_paths")); //$NON-NLS-1$
		properties.add(propertyMap.get("ld_pre_process")); //$NON-NLS-1$
		properties.add(propertyMap.get("ld_post_process")); //$NON-NLS-1$
		properties.add(propertyMap.get("ld_objs")); //$NON-NLS-1$
		properties.add(propertyMap.get("ar_flags")); //$NON-NLS-1$
		
		return properties;
	}
	protected void createBuildConfigurationSelectionArea(Composite parent) {

		BuildConfigurationContentProvider cp = new BuildConfigurationContentProvider(
			buildConfigurationClassifier.eResource().getResourceSet(),
			buildConfigurationClassifier.getName());

		Object[] array = cp.getElements(new Object());
		ArrayList<InstanceSpecification> bcList = new ArrayList<InstanceSpecification>();
		for (int i = 0; i < array.length; i++) {

			Map<String, Slot> slotMap = getSlotMap((InstanceSpecification) array[i]);
			Object o = getSlotValue(slotMap.get("toolchainref")); //$NON-NLS-1$
			if (o != null) {
				bcList.add((InstanceSpecification) array[i]);
			}
		}

		buildConfigurations = new InstanceSpecification[bcList.size()];
		String[] buildConfigurationsLabel = new String[bcList.size()];

		int i = 0;
		for (InstanceSpecification instance : bcList) {
			buildConfigurations[i] = instance;
			buildConfigurationsLabel[i] = instance.getQualifiedName();
			if (baseBuildConfiguration != null) {
				if (baseBuildConfiguration == instance) {
					defaultSelectedIndex = i;
				}
			}
			i++;
		}

		Group group = new Group(parent, SWT.NULL);
		group
			.setText(Messages.BuildConfigurationRootPage_BuildConfigurationComboLabel);
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		selectionCombo = new Combo(group, SWT.NULL);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		selectionCombo.setLayoutData(data);
		selectionCombo.setItems(buildConfigurationsLabel);
		selectionCombo.select(defaultSelectedIndex);
		selectionCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(selectionCombo.getSelectionIndex() >=0)
				{
					setSelectedBaseBuildConfiguration(
							buildConfigurations[selectionCombo
									.getSelectionIndex()], true);
					setValid(true);
				}
				else
				{
					setValid(false);
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.base.ui.pages.AbstractBuildConfigurationPage#getInputControlMap
	 * ()
	 */
	@Override
	protected Map<String, Map<String, Control>> getInputControlMap() {
		return inputControlMap;
	}

	@Override
	protected Map<String, Map<String, Control>> getBaseInputControlMap() {
		return baseInputControlMap;
	}

	@Override
	protected void restoreDefaults() {
		super.restoreDefaults();
		selectionCombo.select(defaultSelectedIndex);
	}

}
