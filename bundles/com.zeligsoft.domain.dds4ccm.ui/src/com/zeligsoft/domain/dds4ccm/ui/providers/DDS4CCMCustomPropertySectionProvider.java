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
package com.zeligsoft.domain.dds4ccm.ui.providers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.dialogs.PropertiesDialog;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.pages.ListTableViewerPage;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;
import com.zeligsoft.cx.ui.properties.utils.CXPropertiesWidgetFactory;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.dds4ccm.utils.ModelTypeDDS4CCM;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateModule;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateSignature;
import com.zeligsoft.domain.idl3plus.api.Generics.TypeParameter;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CXInterface;
import com.zeligsoft.domain.omg.corba.ui.providers.CORBACustomPropertySection;
import com.zeligsoft.domain.zml.api.ZML_Component.PortTypeable;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * DDS4CCM domain custom property provider
 * 
 * @author ysroh
 * 
 */
public class DDS4CCMCustomPropertySectionProvider implements
		ICXCustomPropertySection {

	private static final String GENERATE_PACKAGE_KEY = "generatedir"; //$NON-NLS-1$
	private static final String FIELD_IS_KEY_KEY = "fieldkey"; //$NON-NLS-1$

	@Override
	public Map<String, Control> createSection(Composite parent,
			CXPropertyDescriptor descriptor, Property property) {
		if ("name".equals(property.getName())
				&& ZDLUtil.isZDLConcept(descriptor.getContext(), ZMLMMNames.DEPLOYMENT_PART)) {
			Map<String, Control> widgetMap = CXPropertiesWidgetFactory.createSectionForStringType(parent, descriptor);
			NamedElement modelElement = ZDeploymentUtil.getModelElement((Property) descriptor.getContext());
			if (!ZDLUtil.isZDLConcept(modelElement, CCMNames.NODE_INSTANCE)
					&& ZDeploymentUtil.getParentPart((Property) descriptor.getContext()) != null) {
				Control text = widgetMap.get(CXPropertiesWidgetFactory.PROPERTY_VALUE);
				text.setEnabled(false);
			}
			return widgetMap;
		} else if (property.getName().equals(DDS4CCMNames.DDS4_CCMMODEL__FIXED_HEADER)
				|| property.getName().equals(
						DDS4CCMNames.DDS4_CCMMODEL__FIXED_FOOTER)) {
			return CXPropertiesWidgetFactory.createSectionForStringType(parent,
					descriptor, true);
		} else if (property.getName()
				.equals(CXDomainNames.CXFIELD__BOUND)) {
			// add key property instead of bound
			if (ZDLUtil.isZDLConcept(descriptor.getContext().eContainer(),
					CXDomainNames.CXSTRUCT)
					&& !ZDLUtil.isZDLConcept(descriptor.getContext(),
							DDS4CCMNames.MESSAGE_FIELD)) {
				return createStructFieldKeySection(parent, descriptor);
			}
			return new HashMap<String, Control>();
		} else if (property.getName().equals(
				ZMLMMNames.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION)) {
			final Component comp = (Component) ((Property) descriptor
					.getContext()).getType();
			if (comp == null
					|| ZDLUtil.isZDLConcept(comp, IDL3PlusNames.CONNECTOR_DEF)) {
				return null;
			}

			for (EStructuralFeature.Setting ref : UML2Util
					.getInverseReferences(comp)) {
				if (ref.getEObject() != null
						&& ref.getEObject() instanceof Generalization) {
					EObject general = ((Generalization) ref.getEObject())
							.getGeneral();
					if (general == comp
							&& ZDLUtil.isZDLConcept(ref.getEObject()
									.eContainer(),
									CCMNames.ASSEMBLY_IMPLEMENTATION)) {
						return null;
					}
				}
			}

			IFilter filter = new IFilter() {

				@Override
				public boolean select(Object toTest) {
					EObject eo = null;

					if (toTest instanceof EObject) {
						eo = (EObject) toTest;
					} else if (toTest instanceof IAdaptable) {
						eo = (EObject) ((IAdaptable) toTest)
								.getAdapter(EObject.class);
					} else if (toTest instanceof IStructuredSelection) {
						eo = BaseUIUtil
								.getEObjectFromSelection((IStructuredSelection) toTest);
					}
					if (eo == null
							|| !ZDLUtil.isZDLConcept(eo,
									CCMNames.MONOLITHIC_IMPLEMENTATION)) {
						return false;
					}
					for (Generalization g : ((Component) eo)
							.getGeneralizations()) {
						if (g.getGeneral() == comp) {
							return true;
						}
						for (Generalization cg : ((Component) comp)
								.getGeneralizations()) {
							if (g.getGeneral() == cg.getGeneral()) {
								return true;
							}
						}
					}

					return false;
				}

			};
			return CXPropertiesWidgetFactory.createSectionForReferenceType(
					parent, descriptor, filter);
		
		}else if (property.getName().equals(
				CCMNames.INTERFACE_PORT__CONNECTOR_TYPE)) {
			
			InterfacePort ip = ZDLFactoryRegistry.INSTANCE.create(descriptor.getContext(), InterfacePort.class);
			
			if(!isConnectorTypeRequired(ip)){
				return null;
			}
			
			IFilter filter = new IFilter() {

				@Override
				public boolean select(Object toTest) {
					EObject eo = null;

					if (toTest instanceof EObject) {
						eo = (EObject) toTest;
					} else if (toTest instanceof IAdaptable) {
						eo = (EObject) ((IAdaptable) toTest)
								.getAdapter(EObject.class);
					} else if (toTest instanceof IStructuredSelection) {
						eo = BaseUIUtil
								.getEObjectFromSelection((IStructuredSelection) toTest);
					}
					if (eo == null
							|| !ZDLUtil.isZDLConcept(eo,
									IDL3PlusNames.CONNECTOR_DEF)) {
						return false;
					}
					
					ConnectorDef connDef = ZDLFactoryRegistry.INSTANCE.create(eo, ConnectorDef.class);
					
					Object container = connDef.zContainer();
					if(!(container instanceof TemplateModule)){
						return false;
					}
					TemplateModule tModule = (TemplateModule) container;
					
					TemplateSignature ts = tModule.getSignature();
					
					for(TypeParameter typeParam: ts.getTypeParameter()){					
						if(!(typeParam.asClassifierTemplateParameter().getOwnedParameteredElement() instanceof Interface)){
							return false;
						}
					}
					return true;
				}

			};
			return CXPropertiesWidgetFactory.createSectionForReferenceType(
					parent, descriptor, filter);
	
		}else {
			Map<String, Control> widgetMap = CXPropertiesWidgetFactory
					.createSectionForStringType(parent, descriptor);

			List<Class> concepts = ZDLUtil.getZDLConcepts(descriptor
					.getContext());
			if (concepts.isEmpty()
					|| !concepts.get(0).getQualifiedName()
							.equals(ZMLMMNames.NAMED_ELEMENT)) {

				return widgetMap;
			}

			if (descriptor.getContext() != null
					&& descriptor.getContext() instanceof Package
					&& !(descriptor.getContext() instanceof Model)) {
				createSectionForIDLGeneratePackage(parent, descriptor);
			}

			CORBACustomPropertySection.createTypeSectionForMember(parent,
					descriptor, widgetMap);

			// create a packaged element section for Packages
			if (descriptor.getContext() instanceof Package) {
				widgetMap = createPackagedElementSection(parent, descriptor);
			}

			return widgetMap;
		}
	}
	
	private boolean isConnectorTypeRequired(InterfacePort ip){
		
		if(DDS4CCMUtil.getModelType(ip.asPort()).equals(ModelTypeDDS4CCM.ATCD.name())){
			return false;
		}
		PortTypeable pt = ip.getPorttype();
		
		if(!(pt instanceof CXInterface)){
			return false;
		}	
		CXInterface portType = (CXInterface) pt;
				
		if(portType.getIsLocal()){
			return false;
		}		
		return true;
	}

	private Map<String, Control> createStructFieldKeySection(Composite parent,
			final CXPropertyDescriptor descriptor) {
		Map<String, Control> widgetMap = new HashMap<String, Control>();

		widgetMap.put(CXPropertiesWidgetFactory.PROPERTY_LABEL,
				CXWidgetFactory.createLabel(parent, "Is Key :", //$NON-NLS-1$
						parent.getBackground()));

		Composite composite = CXWidgetFactory.createFlatGridComposite(parent,
				1, GridData.FILL_HORIZONTAL);
		composite.setBackground(parent.getBackground());

		final Button checkbox = CXWidgetFactory.createCheckButton(composite,
				UML2Util.EMPTY_STRING, new GridData());

		widgetMap.put(CXPropertiesWidgetFactory.PROPERTY_EDIT_BUTTON, checkbox);
		checkbox.setBackground(parent.getBackground());
		
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(descriptor
				.getContext());
		String isKey = CCMUtil.getZCXAnnotationDetail(
				(Element) descriptor.getContext(), FIELD_IS_KEY_KEY,
				Boolean.toString(false));
		checkbox.setSelection(Boolean.toString(true).equals(isKey));
		checkbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ICommand command = new AbstractTransactionalCommand(
						editingDomain,
						Messages.DDS4CCMCustomPropertySectionProvider_SetKeyValueCommandLabel,
						null) {

					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {

						CCMUtil.putZCXAnnotationDetail(
								(Element) descriptor.getContext(),
								FIELD_IS_KEY_KEY,
								Boolean.toString(checkbox.getSelection()));

						return CommandResult.newOKCommandResult();
					}

					private void doCheckBoxUpdate() {
						if (checkbox != null && !checkbox.isDisposed()) {
							checkbox.setSelection(Boolean.toString(true)
									.equals(CCMUtil.getZCXAnnotationDetail(
											(Element) descriptor.getContext(),
											FIELD_IS_KEY_KEY,
											Boolean.toString(false))));
						}
					}

					@Override
					protected IStatus doRedo(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						IStatus result = super.doRedo(monitor, info);

						if (result.isOK()) {
							doCheckBoxUpdate();
						}

						return result;
					}

					@Override
					protected IStatus doUndo(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						IStatus result = super.doUndo(monitor, info);

						if (result.isOK()) {
							doCheckBoxUpdate();
						}

						return result;
					}
				};
				Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
				
				if (emfCommand.canExecute()) {
					editingDomain.getCommandStack().execute(emfCommand);
				} else {

					Activator.getDefault().warning(Messages.DDS4CCMCustomPropertySectionProvider_SaveKeyFailedMsg);
				}
			}
		});

		return widgetMap;
	}

	/**
	 * Create custom property for packaged elements
	 * 
	 * @param parent
	 * @param descriptor
	 * @return
	 */
	private Map<String, Control> createPackagedElementSection(Composite parent,
			final CXPropertyDescriptor descriptor) {

		Map<String, Control> widgetMap = new HashMap<String, Control>();
		final PropertiesDialog dialog = new PropertiesDialog(Display
				.getCurrent().getActiveShell(), new PreferenceManager());

		CXPropertiesWidgetFactory
				.createLabel(
						parent,
						Messages.DDS4CCMCustomPropertySectionProvider_PackagedElementsPropertyLabel);

		final Composite composite = CXWidgetFactory.createFlatGridComposite(
				parent, 2, GridData.HORIZONTAL_ALIGN_BEGINNING);
		composite.setBackground(parent.getBackground());

		final Label textLabel = new Label(composite, SWT.NULL);
		textLabel.setLayoutData(new GridData());
		textLabel.setBackground(parent.getBackground());
		textLabel
				.setText(Messages.DDS4CCMCustomPropertySectionProvider_EntriesLabel
						+ ((Package) descriptor.getContext())
								.getPackagedElements().size());

		Composite buttonComposite = CXWidgetFactory
				.createNoMarginGridComposite(composite, 1,
						GridData.HORIZONTAL_ALIGN_BEGINNING);
		buttonComposite.setBackground(composite.getBackground());
		final ToolBar editToolBar = CXWidgetFactory.createToolbarButton(
				buttonComposite, CXWidgetFactory.EDIT_OBJECT_IMAGE);

		editToolBar.getItem(0).addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				dialog.getPreferenceManager()
						.addToRoot(
								new PreferenceNode(
										StringStatics.BLANK,
										new ListTableViewerPage(
												((Package) descriptor
														.getContext())
														.getPackagedElements(),
												Messages.DDS4CCMCustomPropertySectionProvider_PackagedElementsDialogTitle, 
												TransactionUtil.getEditingDomain(descriptor.getContext()))));
				dialog.open();
			}
		});
		widgetMap.put(CXPropertiesWidgetFactory.PROPERTY_EDIT_BUTTON,
				editToolBar);
		return widgetMap;
	}

	public static Map<String, Control> createSectionForIDLGeneratePackage(
			Composite parent, final CXPropertyDescriptor descriptor) {

		GridData data = new GridData();
		data.horizontalSpan = 2;
		Composite composite = CXWidgetFactory.createFlatGridComposite(parent,
				1, GridData.FILL_HORIZONTAL);
		composite.setBackground(parent.getBackground());
		composite.setLayoutData(data);

		final Button button = new Button(composite, SWT.CHECK);
		button.setBackground(parent.getBackground());
		button.setText(Messages.DDS4CCMCustomPropertySectionProvider_IDLDirectoryGenerationPropertyLabel);
		button.setSelection(Boolean.toString(true).equals(
				CCMUtil.getZCXAnnotationDetail(
						(Element) descriptor.getContext(),
						GENERATE_PACKAGE_KEY, Boolean.toString(true))));
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(descriptor
				.getContext());
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				AbstractTransactionalCommand command = new AbstractTransactionalCommand(
						editingDomain,
						Messages.DDS4CCMCustomPropertySectionProvider_IDLDirectoryGenerationCommandLabel,
						null) {

					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {

						CCMUtil.putZCXAnnotationDetail(
								(Element) descriptor.getContext(),
								GENERATE_PACKAGE_KEY, Boolean.toString(button.getSelection()));
						return CommandResult.newOKCommandResult();
					}

					private void doCheckBoxUpdate() {
						if (button != null && !button.isDisposed()) {
							button.setSelection(Boolean.toString(true).equals(
									CCMUtil.getZCXAnnotationDetail(
											(Element) descriptor.getContext(),
											GENERATE_PACKAGE_KEY,
											Boolean.toString(true))));
						}
					}

					@Override
					protected IStatus doRedo(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						IStatus result = super.doRedo(monitor, info);

						if (result.isOK()) {
							doCheckBoxUpdate();
						}

						return result;
					}

					@Override
					protected IStatus doUndo(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						IStatus result = super.doUndo(monitor, info);

						if (result.isOK()) {
							doCheckBoxUpdate();
						}

						return result;
					}
				};
				
				Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
				
				if (emfCommand.canExecute()) {
					editingDomain.getCommandStack().execute(emfCommand);
				} else {

					Activator.getDefault().warning(Messages.DDS4CCMCustomPropertySectionProvider_IDLDirectoryGenerationFailed);
				}
			}
		});

		return null;
	}
}
