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
package com.zeligsoft.cx.ui.properties.sections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Abstract class for CXPropertySection
 * 
 * @author ysroh
 * 
 */
public abstract class AbstractCXPropertySection extends AbstractPropertySection
		implements ICXPropertySection {

	private EObject selectedEObject = null;

	private List<EObject> selectedEObjects = new ArrayList<EObject>();

	private Composite mainComposite = null;

	private Composite sectionComposite = null;

	private ISelection selection = null;

	private boolean isHistoryAction = false;

	private boolean isDirectModifyAction = false;

	private TransactionalEditingDomain domain = null;

	private static final String DEFAULT_VALUE_PROPERTY_NAME = "_defaultInstance"; //$NON-NLS-1$
	
	/** listens for undo and redo operation history */
	final IOperationHistoryListener operationHistoryListener = new IOperationHistoryListener() {

		@Override
		public void historyNotification(OperationHistoryEvent event) {

			int type = event.getEventType();
			if (event.getOperation() == null
					|| event.getOperation().getClass() == null) {
				return;
			}
			String className = event.getOperation().getClass().getName();
			if (event.getOperation() instanceof EMFCommandOperation) {
				if (((EMFCommandOperation) event.getOperation()).getCommand() instanceof GMFtoEMFCommandWrapper) {
					className = ((GMFtoEMFCommandWrapper) ((EMFCommandOperation) event.getOperation()).getCommand())
							.getGMFCommand().getClass().getName();
				}
			}
			if (!className.startsWith("com.zeligsoft")) { //$NON-NLS-1$
				return;
			}
			if (type == OperationHistoryEvent.ABOUT_TO_UNDO
					|| type == OperationHistoryEvent.ABOUT_TO_REDO) {
				// undo or re-do action
				if (className.contains("CXPropertyDescriptor") //$NON-NLS-1$
						|| className.contains("PropertyEntry")) { //$NON-NLS-1$
					isHistoryAction = true;
				}
			} else if (type == OperationHistoryEvent.DONE) {
				// modify action from the CX property sheet
				if (className.contains("CXPropertyDescriptor") //$NON-NLS-1$
						|| className.contains("PropertyEntry")) { //$NON-NLS-1$
					isDirectModifyAction = true;
				}
			}
			return;

		}
	};

	/** listens for property value chance to refresh the page */
	final ResourceSetListenerImpl resourceSetListener = new ResourceSetListenerImpl() {

		@SuppressWarnings("rawtypes")
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {

			for (Iterator iter = event.getNotifications().iterator(); iter
					.hasNext();) {
				Notification notification = (Notification) iter.next();
				if (notification.getNotifier() instanceof EObject) {

					EObject notifier = (EObject) notification.getNotifier();
					boolean refreshRequired = false;

					/*
					 * No need to refresh properties for packageable elements
					 */
					if (notification.getFeature() instanceof EReference) {
						if (((EReference) notification.getFeature())
								.getEReferenceType()
								.equals(UMLPackage.Literals.PACKAGEABLE_ELEMENT)) {
							continue;
						}
					}

					// do not update if this is default value instance property
					if (notification.getOldValue() instanceof Property
							&& DEFAULT_VALUE_PROPERTY_NAME
									.equals(((Property) notification
											.getOldValue()).getName())) {
						continue;
					}
					if (notification.getNewValue() instanceof Property
							&& DEFAULT_VALUE_PROPERTY_NAME
									.equals(((Property) notification
											.getNewValue()).getName())) {
						continue;
					}
					if (notification.getOldValue() instanceof InstanceSpecification
							|| notification.getNewValue() instanceof InstanceSpecification) {
						continue;
					}

					// check base element of stereotype
					if (notifier instanceof DynamicEObjectImpl) {
						Element baseElement = UMLUtil
								.getBaseElement((EObject) notification
										.getNotifier());
						if (selectedEObject != baseElement) {
							continue;
						}
						
						refreshRequired = true;
					} else {
						if (notifier == selectedEObject) {
							refreshRequired = true;
						}
					}

					// refresh only if it is history action or indirect
					// modification
					if (refreshRequired) {
						if (isHistoryAction) {
							internalRefresh();
						} else if (!isDirectModifyAction) {
							internalRefresh();
						} else if (!(notification.getNewValue() instanceof InstanceValue)
								&& !(notification.getOldValue() instanceof InstanceValue)
								&& (!(notification.getFeature() instanceof EAttribute) || !String.class
										.equals(((EAttribute) notification
												.getFeature()).getEType()
												.getInstanceClass()))) {
							internalRefresh();
						}
					}
				}
			}
			isHistoryAction = isDirectModifyAction = false;
		}
	};

	/**
	 * Refresh page
	 */
	protected void internalRefresh() {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

			@Override
			public void run() {
				if (sectionComposite != null) {
					sectionComposite.dispose();
				}
				sectionComposite = createContents(mainComposite);
				if (sectionComposite != null) {
					Control sc = mainComposite;
					while (!(sc instanceof ScrolledComposite)) {
						sc = sc.getParent();
					}
					if (sc instanceof ScrolledComposite) {
						ScrolledComposite scrolledComposite = (ScrolledComposite) sc;
						scrolledComposite.layout(true, true);
						scrolledComposite.setMinSize(sectionComposite
								.computeSize(SWT.DEFAULT, SWT.DEFAULT));
					}
				}
			}
		});
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		createControl(parent);
	}

	/**
	 * Creates control wrapper for section composite.
	 */
	@Override
	public Composite createControl(Composite parent) {

		OperationHistoryFactory.getOperationHistory()
				.addOperationHistoryListener(operationHistoryListener);

		if (parent.isDisposed()) {
			return null;
		}
		mainComposite = parent;
		if (parent.getLayout() instanceof GridLayout) {
			GridLayout layout = (GridLayout) parent.getLayout();
			layout.marginBottom = 5;
			layout.marginHeight = 5;
			layout.verticalSpacing = 0;
		}
		if (selectedEObject == null) {
			return null;
		}

		sectionComposite = createContents(parent);
		return sectionComposite;

	}

	/**
	 * Subclass must implement this method to create and return the section
	 * composite
	 * 
	 * @param parent
	 * @return
	 */
	protected abstract Composite createContents(Composite parent);

//  // We need this if we want to use our own view
//	public void setInput(EObject input) {
//		selectedEObject = input;
//		selectedEObjects.clear();
//		selectedEObjects.add(selectedEObject);
//		if (domain == null) {
//			domain = TransactionUtil.getEditingDomain(selectedEObject);
//			domain.addResourceSetListener(resourceSetListener);
//		}
//
//		internalRefresh();
//	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (this.selection == selection) {
			return;
		}
		this.selection = selection;
		selectedEObjects = BaseUIUtil.getEObjectsFromSelection(selection);
		if (!selectedEObjects.isEmpty()) {
			selectedEObject = selectedEObjects.get(0);
		}
		if (domain == null) {
			domain = TransactionUtil.getEditingDomain(selectedEObject);
			domain.addResourceSetListener(resourceSetListener);
		}
		internalRefresh();

	}

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	@Override
	public Composite getSectionComposite() {
		return sectionComposite;
	}

	@Override
	public void dispose() {
		if (domain != null) {
			domain.removeResourceSetListener(resourceSetListener);
		}
		OperationHistoryFactory.getOperationHistory()
				.removeOperationHistoryListener(operationHistoryListener);
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.cx.ui.properties.sections.ICXPropertySection#getEObject()
	 */
	@Override
	public EObject getEObject() {
		return selectedEObject;
	}

	@Override
	public ISelection getSelection() {
		return selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.zeligsoft.cx.ui.properties.sections.ICXPropertySection#
	 * getSelectedEObjects()
	 */
	@Override
	public List<EObject> getSelectedEObjects() {
		return selectedEObjects;
	}

}
