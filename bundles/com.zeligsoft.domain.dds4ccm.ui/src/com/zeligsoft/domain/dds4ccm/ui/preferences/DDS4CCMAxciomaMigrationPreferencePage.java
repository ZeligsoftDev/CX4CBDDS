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

package com.zeligsoft.domain.dds4ccm.ui.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.ButtonGroup;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.base.ui.utils.PreferencePageValidStringListener;
import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.domain.dds4ccm.Activator;
import com.zeligsoft.domain.dds4ccm.ConnectorType;
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;

/**
 * DDS4CCM Domain preference page.
 * 
 * @author Das
 */
public class DDS4CCMAxciomaMigrationPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Combo comboAsync;

	private Combo comboSync;	

	private IEclipsePreferences store;

	private IEclipsePreferences cxStore;

	@Override
	public void init(IWorkbench workbench) {
		store = new InstanceScope().getNode(Activator.PLUGIN_ID);
		cxStore = new InstanceScope().getNode(CXActivator.PLUGIN_ID);
	}

	@Override
	protected Control createContents(Composite parent) {

		Composite panel = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(2, false);
		grid.verticalSpacing = 10;
		panel.setLayout(grid);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		panel.setLayoutData(data);

		createConnectorTypeSelectionArea(panel);		

		return panel;
	}


	/**
	 * ConnectorType selection area
	 * 
	 * @param parent
	 */
	private void createConnectorTypeSelectionArea(Composite parent) {		
		Group connectorTypeSelectionGroup = new Group(parent, SWT.NULL);
		connectorTypeSelectionGroup.setLayout(new GridLayout(2, false));
		connectorTypeSelectionGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		connectorTypeSelectionGroup.setText(Messages.DDS4CCMPreferencePage_AxciomaMigrationConnectorTypeSelectionGroupLabel);

		GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);

		Label label = new Label(connectorTypeSelectionGroup, SWT.NULL);
		label.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		label.setText(Messages.DDS4CCMPreferencePage_AxciomaMigrationConnectorTypeSelectionAsyncLabel);

		comboAsync = new Combo(connectorTypeSelectionGroup, SWT.READ_ONLY);
		comboAsync.setLayoutData(data);
		comboAsync.setItems(getAsyncConnectorTypes(ConnectorType.values()));

		label = new Label(connectorTypeSelectionGroup, SWT.NULL);
		label.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		label.setText(Messages.DDS4CCMPreferencePage_AxciomaMigrationConnectorTypeSelectionSyncLabel);

		comboSync = new Combo(connectorTypeSelectionGroup, SWT.READ_ONLY);
		comboSync.setLayoutData(data);
		comboSync.setItems(getSyncConnectorTypes(ConnectorType.values()));
				
		comboAsync.select(getItemIndex(comboAsync, store.get(DDS4CCMPreferenceConstants.ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION, 
				DDS4CCMPreferenceConstants.DEFAULT_ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION)));			
		comboSync.select(getItemIndex(comboSync, store.get(DDS4CCMPreferenceConstants.SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION, 
				DDS4CCMPreferenceConstants.DEFAULT_SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION)));
		
	}
	
	/**
	 * Returns the index of the input item in the input comboBox
	 */	
	private int getItemIndex(Combo comboBox, String item){
		// this method should not return -1 as long as the default value for the combo is not empty
		int itemIndex = -1;
		String [] comboItems = comboBox.getItems();
		for(int i=0;i<comboItems.length;i++){
			if(comboItems[i].equals(item)){
				itemIndex = i;
				break;
			}
		}
		return itemIndex;
	}
	
	/**
	 * Given an array of connectorTypes, return the connectorTypes that are async capable
	 */
	private String[] getAsyncConnectorTypes(ConnectorType[] connectorTypes){
		List<String> asyncConnectorTypes = new ArrayList<String>();
		for(ConnectorType ct: Arrays.asList(connectorTypes)){
			if(ct.isAsyncCapable()){
				asyncConnectorTypes.add(ct.name());
			}			
		}
		return asyncConnectorTypes.toArray(new String[asyncConnectorTypes.size()]);
	}
	
	/**
	 * Given an array of connectorTypes, return the connectorTypes that are sync capable
	 */
	private String[] getSyncConnectorTypes(ConnectorType[] connectorTypes){
		List<String> syncConnectorTypes = new ArrayList<String>();
		for(ConnectorType ct: Arrays.asList(connectorTypes)){
			if(ct.isSyncCapable()){
				syncConnectorTypes.add(ct.name());
			}			
		}
		return syncConnectorTypes.toArray(new String[syncConnectorTypes.size()]);
	}
	@Override
	protected void performDefaults() {
		
		comboAsync.select(getItemIndex(comboAsync, 
				DDS4CCMPreferenceConstants.DEFAULT_ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION));
		
		comboSync.select(getItemIndex(comboSync, 
				DDS4CCMPreferenceConstants.DEFAULT_SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION));
	}

	@Override
	public boolean performOk() {
		
		store.put(DDS4CCMPreferenceConstants.ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION, 
				comboAsync.getItem(comboAsync.getSelectionIndex()));
		store.put(DDS4CCMPreferenceConstants.SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION, 
				comboSync.getItem(comboSync.getSelectionIndex()));
		
		try {
			store.flush();
			cxStore.flush();
		} catch (BackingStoreException e) {
			com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().error(
					"Error saving preference value", e); //$NON-NLS-1$
		}
		return true;
	}
}