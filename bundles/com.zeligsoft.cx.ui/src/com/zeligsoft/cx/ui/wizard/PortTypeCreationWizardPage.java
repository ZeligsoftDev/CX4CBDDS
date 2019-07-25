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

package com.zeligsoft.cx.ui.wizard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Usage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.cx.ui.PortTypeRegistryReader;
import com.zeligsoft.cx.ui.PortTypeRegistryReader.PortTypeRegistry;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionComposite;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.providers.ZDLElementLabelProvider;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * PortType creation wizard page.
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public class PortTypeCreationWizardPage extends WizardPage {

	private Element context;

	private String postFix;

	private String domainLabel;

	private int LIST_HEIGHT = 50;

	private TableViewer providesListViewer;

	private TableViewer usesListViewer;

	private List<Interface> providesList = new ArrayList<Interface>();

	private List<Interface> usesList = new ArrayList<Interface>();

	private Text nameField;

	private Text inverseNameField;

	private Button autoInverseNameButton;

	private PortTypeRegistry registry;

	private ZDLElementSelectionComposite selectionComposite = null;

	private Button providesRemoveButton;

	private Button usesRemoveButton;

	private PortTypeRelationshipNameComposite providesNameComposite;

	private PortTypeRelationshipNameComposite usesNameComposite;
	
	private Class selectedPortType = null;

	// Inverse name field auto button selection listener
	private SelectionAdapter autoInverseNameFieldListener = new SelectionAdapter() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (autoInverseNameButton.getSelection()) {
				autoSetInverseNameField();
				if (inverseNameField != null)
					inverseNameField.setEditable(false);
			} else {
				if (inverseNameField != null)
					inverseNameField.setEditable(true);
			}
		}
	};

	/**
	 * Constructor
	 * 
	 * @param parentShell
	 * @param context
	 *            This is the selected element that the PortType will be created
	 *            under
	 */
	@SuppressWarnings("deprecation")
	public PortTypeCreationWizardPage(String pageName, Element context) {
		super(pageName);
		postFix = CXActivator.getDefault().getPluginPreferences().getString(
				CXPreferenceConstants.PREFERENCE_PORTTYPE_SUFFIX);

		this.context = context;
		this.registry = getPortTypeRegistry(context);
		Assert
				.isNotNull(
						this.registry,
						Messages.PortTypeCreationWizardPage_PortTypeExtentionPointMissingErrorMsg);
		setTitle(domainLabel);
		if(ZDLUtil.isZDLConcept(context, ZMLMMNames.PORT_TYPE)){
			selectedPortType = (Class)context;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout());
		container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite composite = new Composite(container, SWT.NULL);
		GridLayout layout = new GridLayout(3, false);
		layout.verticalSpacing = 10;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createInputArea(composite);

		Label separator = new Label(composite, SWT.SEPARATOR | SWT.LINE_SOLID
				| SWT.HORIZONTAL);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		separator.setLayoutData(data);

		if (!registry.isEnableMultiSelection() && !registry.isShowUsesList()) {
			createListAreaForSingleProvidesSelection(composite);
		} else {
			if (registry.isEnableNameSelection()) {
				createNameSelectionListArea(composite);
			} else {
				createListArea(composite);
			}
		}
		
		nameField.setFocus();

		setControl(container);

		setPageComplete(false);

	}

	/**
	 * Create PortType input fields
	 * 
	 * @param parent
	 * @return
	 */
	private Composite createInputArea(Composite inputArea) {

		Label nameLabel = new Label(inputArea, SWT.NONE);
		nameLabel.setText(Messages.PortTypeCreationWizardPage_PortTypeNameLabel);
		GridData data = new GridData();
		nameLabel.setLayoutData(data);

		nameField = new Text(inputArea, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
		data.widthHint = 250;
		nameField.setLayoutData(data);
		nameField.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event e) {
				if (inverseNameField != null) {
					autoSetInverseNameField();
				}
				validateName();
			}
		});
		if(selectedPortType != null){
			nameField.setText(selectedPortType.getName());
		}
		
		Label label = new Label(inputArea, SWT.NULL);
		label.setLayoutData(new GridData());
		label.setVisible(false);

		if (registry.isCreateInversePortType()) {
			// Second row
			Label invNameLabel = new Label(inputArea, SWT.NONE);
			invNameLabel
					.setText(Messages.PortTypeCreationWizardPage_InversePortTypeNameFieldLabel);
			data = new GridData();
			invNameLabel.setLayoutData(data);

			inverseNameField = new Text(inputArea, SWT.READ_ONLY | SWT.BORDER);
			data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
			inverseNameField.setLayoutData(data);
			inverseNameField.addListener(SWT.Modify, new Listener() {

				@Override
				public void handleEvent(Event e) {
					validateName();
				}
			});
			if (selectedPortType != null) {
				Object value = ZDLUtil.getValue(selectedPortType, ZMLMMNames.PORT_TYPE,
						ZMLMMNames.PORT_TYPE__INVERSE);
				if (value != null) {
					inverseNameField.setText(((Class) value).getName());
				}
			}
			
			autoInverseNameButton = makeButton(inputArea, SWT.CHECK,
					Messages.PortTypeCreationWizardPage_autoInversePortTypeButtonLabel,
					autoInverseNameFieldListener);
			autoInverseNameButton.setLayoutData(new GridData(
					GridData.HORIZONTAL_ALIGN_BEGINNING));
			autoInverseNameButton.setSelection(true);
		}
		return inputArea;
	}

	/**
	 * Create list area for single selection with provides list
	 * 
	 * @param parent
	 * @return
	 */
	private Composite createListAreaForSingleProvidesSelection(Composite parent) {

		Label realizeListLabel = new Label(parent, SWT.NONE);
		realizeListLabel
				.setText(Messages.PortTypeCreationWizardPage_RealizationListLabel);
		realizeListLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		Composite selectionCompositeArea = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		selectionCompositeArea.setLayout(layout);
		selectionCompositeArea.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		List<String> concepts = new ArrayList<String>();
		concepts.add(registry.getInterfaceType());
		selectionComposite = new ZDLElementSelectionComposite(context, concepts, true) {

			@Override
			@SuppressWarnings("unchecked")
			protected void handleSelection(IStructuredSelection selection) {
				if (!selection.isEmpty()) {
					providesList.clear();
					Iterator<Object> iter = selection.iterator();

					while (iter.hasNext()) {
						Object next = iter.next();
						providesList.add((Interface) next);
					}
					validateName();
				} else {
					providesList.clear();
				}

			}
		};

		selectionComposite.createComposite(selectionCompositeArea);
		if(selectedPortType != null){
			for(InterfaceRealization ir : selectedPortType.getInterfaceRealizations()){
				providesList.add(ir.getContract());
			}
		}
		selectionComposite.getTableViewer().setSelection(new StructuredSelection(providesList));

		new Label(parent, SWT.NULL);

		return parent;
	}

	/**
	 * Create interface list area
	 * 
	 * @param parent
	 * @return
	 */
	private Composite createListArea(Composite composite) {

		int listStyle = SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.MULTI;

		GridData viewerData = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		viewerData.heightHint = LIST_HEIGHT;

		{
			Label realizeListLabel = new Label(composite, SWT.NONE);
			realizeListLabel
					.setText(Messages.PortTypeCreationWizardPage_RealizationListLabel);
			realizeListLabel
					.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
			// providesListViewer = new TableViewer(composite, SWT.BORDER |
			// SWT.MULTI);
			providesListViewer = new TableViewer(composite, listStyle);
			providesListViewer.getTable().setLayoutData(viewerData);
			providesListViewer.setContentProvider(new ArrayContentProvider());
			providesListViewer.setLabelProvider(new ZDLElementLabelProvider(
					providesListViewer));

			providesListViewer
					.addSelectionChangedListener(new ISelectionChangedListener() {

						@Override
						public void selectionChanged(SelectionChangedEvent event) {

							providesListViewer.refresh();
							IStructuredSelection selection = (IStructuredSelection) providesListViewer
									.getSelection();
							if (selection != null && !selection.isEmpty()) {
								providesRemoveButton.setEnabled(true);
							} else {
								providesRemoveButton.setEnabled(false);
							}
						}
					});

			if(selectedPortType != null){
				for(InterfaceRealization ir : selectedPortType.getInterfaceRealizations()){
					providesList.add(ir.getContract());
				}
			}
			providesListViewer.setInput(providesList);
			createAddRemoveButtons(composite, providesList);
		}

		if (registry.isShowUsesList()) {

			Label requireListLabel = new Label(composite, SWT.NONE);
			requireListLabel.setText(Messages.PortTypeCreationWizardPage_UsageListLabel);
			requireListLabel
					.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

			usesListViewer = new TableViewer(composite, listStyle);
			usesListViewer.getTable().setLayoutData(viewerData);
			usesListViewer.setContentProvider(new ArrayContentProvider());
			usesListViewer.setLabelProvider(new ZDLElementLabelProvider(usesListViewer));
			usesListViewer.setInput(new Object());
			usesListViewer.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {

					usesListViewer.refresh();
					IStructuredSelection selection = (IStructuredSelection) usesListViewer
							.getSelection();
					if (selection != null && !selection.isEmpty()) {
						usesRemoveButton.setEnabled(true);
					} else {
						usesRemoveButton.setEnabled(false);
					}
				}

			});
			if(selectedPortType != null){
				for(Interface intf : selectedPortType.getUsedInterfaces()){
					usesList.add(intf);
				}
			}
			usesListViewer.setInput(usesList);
			createAddRemoveButtons(composite, usesList);
		}

		return composite;
	}
	
	private void createNameSelectionListArea(Composite composite) {

		
		Label realizeListLabel = new Label(composite, SWT.NONE);
		realizeListLabel
				.setText(Messages.PortTypeCreationWizardPage_RealizationListLabel);
		GridData data = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		data.verticalIndent = 20;
		data.widthHint = 75;
		realizeListLabel.setLayoutData(data);
		providesNameComposite = new PortTypeRelationshipNameComposite();
		providesNameComposite.createComposite(composite);
		providesNameComposite.getTableViewer().setInput(providesList);
		createAddRemoveButtons(composite, providesList);
		
		if(selectedPortType != null){
			for(InterfaceRealization ir : selectedPortType.getInterfaceRealizations()){
				PortTypeRelationshipNameDescriptor descriptor = providesNameComposite.addInterface(ir.getContract());
				descriptor.setName(ir.getName());
				providesList.add(ir.getContract());
			}
		}
		providesNameComposite.getTableViewer().addSelectionChangedListener(
				new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						Object o = providesNameComposite.getTableViewer().getSelection();
						if (o != null && o instanceof StructuredSelection) {
							if (!((StructuredSelection) o).isEmpty()) {
								providesRemoveButton.setEnabled(true);
							}else{
								providesRemoveButton.setEnabled(false);
							}
						}
					}
				});
		providesNameComposite.getTableViewer().refresh();

		if (registry.isShowUsesList()) {
			Label usesListLabel = new Label(composite, SWT.NONE);
			usesListLabel.setText(Messages.PortTypeCreationWizardPage_UsageListLabel);
			usesListLabel.setLayoutData(data);
			usesNameComposite = new PortTypeRelationshipNameComposite();
			usesNameComposite.createComposite(composite);
			createAddRemoveButtons(composite, usesList);
			if(selectedPortType != null){
				EList<Relationship> relationships = selectedPortType.getRelationships();
				for(Interface intf : selectedPortType.getUsedInterfaces()){
					PortTypeRelationshipNameDescriptor descriptor = usesNameComposite.addInterface(intf);
					for(Relationship r: relationships){
						if(r instanceof Usage){
							if(((Usage)r).getSuppliers().contains(intf)){
								descriptor.setName(((Usage)r).getName());			
							}
						}
					}
				}
				usesList.addAll(selectedPortType.getUsedInterfaces());
			}
			usesNameComposite.getTableViewer().addSelectionChangedListener(
					new ISelectionChangedListener() {

						@Override
						public void selectionChanged(SelectionChangedEvent event) {
							Object o = usesNameComposite.getTableViewer().getSelection();
							if (o != null && o instanceof StructuredSelection) {
								if (!((StructuredSelection) o).isEmpty()) {
									usesRemoveButton.setEnabled(true);
								}else{
									usesRemoveButton.setEnabled(false);
								}
							}
						}
					});
		}

		usesNameComposite.getTableViewer().refresh();
	}

	/**
	 * Create add and remove buttons
	 * 
	 * @param parent
	 * @param viewer
	 * @param list
	 */
	private void createAddRemoveButtons(Composite composite, final List<Interface> list) {

		final InterfaceElementDialog dialog = new InterfaceElementDialog(getShell());
		final TableViewer viewer;

		if(registry.isEnableNameSelection()){
			if(list == usesList){
				viewer = usesNameComposite.getTableViewer();
			}else{
				viewer = providesNameComposite.getTableViewer();
			}
		}else{
			if(list == usesList){
				viewer = usesListViewer;
			}else{
				viewer = providesListViewer;
			}
		}
		
		Composite addRemoveButtonArea = new Composite(composite, SWT.NULL);
		
		GridLayout buttonAreaLayout = new GridLayout();
		buttonAreaLayout.horizontalSpacing = 0;
		buttonAreaLayout.verticalSpacing = 5;
		buttonAreaLayout.marginWidth = 0;
		buttonAreaLayout.marginHeight = 0;
		
		addRemoveButtonArea.setLayout(buttonAreaLayout);
		addRemoveButtonArea.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING
						| GridData.HORIZONTAL_ALIGN_BEGINNING));
		
		GridData data = new GridData(GridData.VERTICAL_ALIGN_BEGINNING
				| GridData.HORIZONTAL_ALIGN_BEGINNING);
		data.widthHint = 80;
		if(registry.isEnableNameSelection()){
			new Label(addRemoveButtonArea, SWT.None);
		}
		Button addButton = new Button(addRemoveButtonArea, SWT.PUSH);
		addButton.setLayoutData(data);

		if (registry.isEnableMultiSelection()) {

			final Button removeButton = new Button(addRemoveButtonArea, SWT.PUSH);
			removeButton.setText(Messages.PortTypeCreationWizardPage_RemoveButtonLabel);
			removeButton.setLayoutData(data);
			removeButton.setEnabled(false);
			removeButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					IStructuredSelection selection = (IStructuredSelection) viewer
							.getSelection();
					if (selection.isEmpty()) {
						return;
					}
					if (registry.isEnableNameSelection()) {
						List<Interface> toRemove = new ArrayList<Interface>();
						for(Object sel : selection.toList()){
							toRemove.add(((PortTypeRelationshipNameDescriptor)sel).getInterface());
						}
						if (list == providesList) {
							providesList.removeAll(toRemove);
							providesNameComposite.setList(list);
						} else {
							usesList.removeAll(toRemove);
							usesNameComposite.setList(list);
						}
					}else{
						list.removeAll(selection.toList());
					}
					if (list.isEmpty()) {
						removeButton.setEnabled(false);
					}
					viewer.refresh();
					validateName();
				}
			});

			if (list == providesList) {
				providesRemoveButton = removeButton;
			} else {
				usesRemoveButton = removeButton;
			}

			addButton.setText(Messages.PortTypeCreationWizardPage_AddButtonLabel);
			addButton.addSelectionListener(new SelectionAdapter() {

				@Override
				@SuppressWarnings("unchecked")
				public void widgetSelected(SelectionEvent e) {
					int result = dialog.open();

					if (result == Window.CANCEL) {
						return;
					}

					IStructuredSelection selection = dialog.getSelectedElements();
					Iterator<Object> iter = selection.iterator();

					while (iter.hasNext()) {
						Object next = iter.next();
						if (!(next instanceof Interface)) {
							continue;
						}
						if (!list.contains(next)) {
							list.add((Interface) next);
						}
					}
					if (registry.isEnableNameSelection()) {
						if (list == providesList) {
							providesNameComposite.setList(list);
						} else {
							usesNameComposite.setList(list);
						}
					}
					viewer.refresh();
					validateName();
				}
			});

		} else {
			addButton.setText(Messages.PortTypeCreationWizardPage_SelectButtonLabel);
			addButton.addSelectionListener(new SelectionAdapter() {

				@Override
				@SuppressWarnings("unchecked")
				public void widgetSelected(SelectionEvent e) {
					int result = dialog.open();
					if (result == Window.OK) {
						IStructuredSelection selection = dialog.getSelectedElements();
						Iterator<Object> iter = selection.iterator();
						while (iter.hasNext()) {
							Object next = iter.next();
							list.add((Interface) next);
						}
						viewer.refresh();
						validateName();
					}
				}
			});
		}

	}

	/**
	 * Set inverse PortType name field
	 */
	private void autoSetInverseNameField() {

		if (inverseNameField != null) {
			if (autoInverseNameButton.getSelection()) {
				if (UML2Util.isEmpty(nameField.getText())) {
					inverseNameField.setText(""); //$NON-NLS-1$
					setPageComplete(false);
				} else {
					inverseNameField.setText(nameField.getText() + postFix);
				}
			}
		}
	}

	/**
	 * Create a button
	 * 
	 * @param parent
	 * @param label
	 * @param listener
	 * @return
	 */
	private Button makeButton(Composite parent, int style, String label,
			SelectionAdapter listener) {

		Button btn = new Button(parent, style);
		btn.setText(label);
		btn.addSelectionListener(listener);
		return btn;
	}

	/**
	 * Return port type registry for the domain of selection object
	 * 
	 * @return
	 */
	private PortTypeRegistry getPortTypeRegistry(Element context) {

		PortTypeRegistry reg = PortTypeRegistryReader.INSTANCE
				.getPortTypeRegistry(context);
		if (reg != null) {
			Iterator<Profile> iter = ZDLUtil.getZDLProfiles(context).iterator();
			while (iter.hasNext()) {
				Profile profile = iter.next();
				if (reg.getDomainName().equals(profile.getName())) {
					domainLabel = profile.getLabel();
				}
			}
		}

		return reg;
	}

	/**
	 * Validate the name fields
	 */
	private void validateName() {

		setPageComplete(true);

		if (UML2Util.isEmpty(nameField.getText())) {
			setErrorMessage(Messages.PortTypeCreationWizardPage_NameEmptyErrorMessage);
			setPageComplete(false);
			return;
		}

		if (inverseNameField != null) {

			if (UML2Util.isEmpty(inverseNameField.getText())) {
				setErrorMessage(Messages.PortTypeCreationWizardPage_InverseNameEmptyErrorMessage);
				setPageComplete(false);
				return;
			}

			if (nameField.getText().equals(inverseNameField.getText())) {
				setErrorMessage(Messages.PortTypeCreationWizardPage_InvalidNameErrorMessage);
				setPageComplete(false);
				return;
			}
		}

		setErrorMessage(null);

	}

	/**
	 * Queries the provides list viewer
	 * 
	 * @return
	 */
	private List<Interface> getProvidesList() {
		return providesList;
	}

	/**
	 * Queries the uses list viewer
	 * 
	 * @return
	 */
	private List<Interface> getUsesList() {
		return usesList;
	}

	/**
	 * Queries the port type name
	 * 
	 * @return
	 */
	public String getPortTypeName() {
		return nameField.getText();
	}

	/**
	 * Queries the inverse port type name
	 * 
	 * @return
	 */
	public String getInversePortTypeName() {
		if (inverseNameField != null) {
			return inverseNameField.getText();
		}
		return null;
	}

	/**
	 * Queries if the wizard contains uses list
	 * 
	 * @return
	 */
	public boolean hasUsesList() {
		if (registry != null && registry.isShowUsesList()) {
			return true;
		}
		return false;
	}

	public Class getSelectedPortType(){
		return selectedPortType;
	}
	/**
	 * Regurn port type registry
	 * 
	 * @return
	 */
	public PortTypeRegistry getRegistry() {
		return registry;
	}

	public Map<Interface, String> getUsesMap() {
		if (usesNameComposite != null) {
			return usesNameComposite.getNameMap();
		}
		Map<Interface, String> map = new HashMap<Interface, String>();
		for (Interface intf : getUsesList()) {
			map.put(intf, UML2Util.EMPTY_STRING);
		}
		return map;
	}

	public Map<Interface, String> getProvidesMap() {
		if (providesNameComposite != null) {
			return providesNameComposite.getNameMap();
		}
		Map<Interface, String> map = new HashMap<Interface, String>();
		for(Interface intf:getProvidesList()){
			map.put(intf, UML2Util.EMPTY_STRING);
		}
		return map;
	}

	/**
	 * Interface selection dialog
	 * 
	 * @author ysroh
	 * 
	 */
	private class InterfaceElementDialog extends ZDLElementSelectionDialog {

		public InterfaceElementDialog(Shell shell) {
			super(shell, Messages.PortTypeCreationWizardPage_InterfaceDialogTitle,
					context, null, true);
			List<String> concepts = new ArrayList<String>();
			concepts.add(registry.getInterfaceType());
			setZDLConcepts(concepts);
			setCompositeTitle(Messages.PortTypeCreationWizardPage_SelectionCompositeTitle);

		}
	}

	private class PortTypeRelationshipNameComposite {

		private TableViewer tableViewer = null;

		private Map<Interface, PortTypeRelationshipNameDescriptor> descriptorMap = new HashMap<Interface, PortTypeRelationshipNameDescriptor>();

		public Composite createComposite(Composite parent) {
			Composite composite = new Composite(parent, SWT.NULL);
			GridLayout compositeLayout = new GridLayout();
			compositeLayout.marginWidth = 0;
			compositeLayout.marginHeight = 0;
			compositeLayout.verticalSpacing = 0;
			compositeLayout.horizontalSpacing = 0;
			GridData compositeLData = new GridData(GridData.FILL_BOTH);
			compositeLData.grabExcessHorizontalSpace = true;
			compositeLData.grabExcessVerticalSpace = true;
			compositeLData.heightHint = 92;
			composite.setLayoutData(compositeLData);
			composite.setLayout(compositeLayout);

			createTreeArea(composite);

			return composite;
		}

		/**
		 * Create a tree area
		 * 
		 * @param parent
		 */
		private void createTreeArea(Composite parent) {

			GridData tableViewerData = new GridData(GridData.FILL_BOTH);
			tableViewer = new TableViewer(parent, SWT.FULL_SELECTION);
			Table table = tableViewer.getTable();
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			tableViewer.getControl().setLayoutData(tableViewerData);

			TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NULL,
					0);
			viewerColumn.getColumn().setText(Messages.PortTypeCreationWizardPage_NameTreeObjectColumnLabel);
			viewerColumn.getColumn().setWidth(200);
			viewerColumn = new TableViewerColumn(tableViewer, SWT.NULL, 1);
			viewerColumn.getColumn().setText(Messages.PortTypeCreationWizardPage_NameTreeNameColumnLabel);
			viewerColumn.getColumn().setWidth(200);
			viewerColumn.setEditingSupport(new NameDescriptorEditingSupport(tableViewer));

			tableViewer.setContentProvider(new ArrayContentProvider());
			tableViewer.setLabelProvider(new NameDescriptorLabelProvider());
			tableViewer.setInput(Collections.EMPTY_LIST.toArray());

		}

		public void setList(List<Interface> list) {
			Map<Interface, PortTypeRelationshipNameDescriptor> map = new HashMap<Interface, PortTypeRelationshipNameDescriptor>();
			List<PortTypeRelationshipNameDescriptor> tableList = new ArrayList<PortTypeRelationshipNameDescriptor>();
			for (Interface intf : list) {
				if (descriptorMap.containsKey(intf)) {
					map.put(intf, descriptorMap.get(intf));
				} else {
					map.put(intf, new PortTypeRelationshipNameDescriptor(intf));
				}
				tableList.add(map.get(intf));
			}
			descriptorMap.clear();
			descriptorMap.putAll(map);
			tableViewer.setInput(tableList);
		}
		
		public PortTypeRelationshipNameDescriptor addInterface(Interface intf) {
			List<PortTypeRelationshipNameDescriptor> tableList =  new ArrayList<PortTypeRelationshipNameDescriptor>();
			if (!descriptorMap.containsKey(intf)) {
				descriptorMap.put(intf, new PortTypeRelationshipNameDescriptor(intf));
			}
			tableList.addAll(descriptorMap.values());
			tableViewer.setInput(tableList);
			return descriptorMap.get(intf);
		}

		public TableViewer getTableViewer() {
			return tableViewer;
		}

		public Map<Interface, String> getNameMap() {
			Map<Interface, String> map = new HashMap<Interface, String>();
			for (Interface intf : descriptorMap.keySet()) {
				map.put(intf, descriptorMap.get(intf).getName());
			}
			return map;
		}
	}

	private class PortTypeRelationshipNameDescriptor{

		private Interface intf;

		private String name = UML2Util.EMPTY_STRING;

		public PortTypeRelationshipNameDescriptor(Interface intf) {
			this.intf = intf;
		}

		public String getInterfaceLabel() {
			return intf.getName();
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		public Interface getInterface() {
			return intf;
		}
	}

	private class NameDescriptorEditingSupport extends EditingSupport {

		private CellEditor editor;

		public NameDescriptorEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		@Override
		protected boolean canEdit(Object element) {
			if (element instanceof PortTypeRelationshipNameDescriptor) {
				return true;
			}
			return false;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			editor = new TextCellEditor((Table) getViewer().getControl());
			return editor;
		}

		@Override
		protected Object getValue(Object element) {
			return ((PortTypeRelationshipNameDescriptor) element).getName();
		}

		@Override
		protected void setValue(Object element, Object value) {
			((PortTypeRelationshipNameDescriptor) element).setName((String) value);
			getViewer().refresh();
			validateName();
		}

	}

	private class NameDescriptorLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof PortTypeRelationshipNameDescriptor && columnIndex == 0) {
				return ((PortTypeRelationshipNameDescriptor) element).getInterfaceLabel();
			} else if (columnIndex == 1) {
				return ((PortTypeRelationshipNameDescriptor) element).getName();
			}
			return UML2Util.EMPTY_STRING;
		}
	}
}
