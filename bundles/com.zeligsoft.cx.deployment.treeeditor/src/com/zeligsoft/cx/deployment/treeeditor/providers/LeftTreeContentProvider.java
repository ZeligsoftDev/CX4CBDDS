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

package com.zeligsoft.cx.deployment.treeeditor.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.treeeditor.ui.Activator;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * This is the content provider for the left tree in the tree deployment editor.
 * It takes the deployment as input and displays it in form of a tree.
 * 
 * @author sduchesneau
 */
public class LeftTreeContentProvider
		implements ITreeContentProvider {

	private Viewer viewer;
	private ResourceSetListener listener;
	private Component deployment;	
	private TransactionalEditingDomain domain;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Property) {
			final Property parentPart = (Property) parentElement;

			TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(parentPart);
			RunnableWithResult<Collection<Property>> runnable = new RunnableWithResult.Impl<Collection<Property>>() {

				@Override
				public void run() {
					setResult(ZDeploymentUtil.getDeploymentChildren(parentPart));
				}
			};

			try {
				Collection<Property> children = (Collection<Property>) domain
						.runExclusive(runnable);
				List<Property> compParts = new ArrayList<Property>();
				List<Property> otherParts = new ArrayList<Property>();
				for (Property p : children) {
					if (ZDLUtil.isZDLConcept(p,
							ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
						compParts.add(p);
					} else {
						otherParts.add(p);
					}
				}
				List<Property> results = new ArrayList<Property>();
				results.addAll(BaseUIUtil.sortEObjectsByName(compParts));
				results.addAll(BaseUIUtil.sortEObjectsByName(otherParts));
				return results.toArray();
			} catch (Exception e) {
				Activator
					.getDefault()
					.error(
						DeploymentEditorMessages.LeftTreeContentProvider_ReadingFromModelErrorMsg,
						e);
			}
		}
		return new Object[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object element) {
		if (element instanceof Property) {
			final Property part = (Property) element;

			TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(part);
			RunnableWithResult<Property> runnable = new RunnableWithResult.Impl<Property>() {

				@Override
				public void run() {
					setResult(ZDeploymentUtil.getParentPart(part));
				}
			};

			try {
				if (domain != null)
					return domain.runExclusive(runnable);
			} catch (Exception e) {
				Activator
					.getDefault()
					.error(
						DeploymentEditorMessages.LeftTreeContentProvider_ReadingFromModelErrorMsg,
						e);
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		if (getChildren(element).length > 0)
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Component) {
			setDeployment((Component) inputElement);			

			if (listener == null) {
				listener = new ResourceSetListenerImpl() {

					@Override
					public boolean isPostcommitOnly() {
						return true;
					}

					@Override
					public void resourceSetChanged(ResourceSetChangeEvent event) {
						List<Notification> notificationList = event.getNotifications();

						boolean found = false;
						for (int i = 0; i < notificationList.size()
							&& found == false; i++) {
							
								Notification notification = notificationList.get(i);
								Object notifier = notification.getNotifier();
								
								if(!(notifier instanceof EObject)){
									continue;
								}

								if (notifier == deployment) {
									refreshViewer();
									break;
								}

								if (notifier instanceof NamedElement
										&& ZDeploymentUtil
												.isDeploymentPart((NamedElement) notifier)) {
									refreshViewer();
									break;
								}
							
						}
					}
				};

				domain.addResourceSetListener(listener);
			}

			RunnableWithResult<Collection<Property>> runnable = new RunnableWithResult.Impl<Collection<Property>>() {

				@Override
				public void run() {
					setResult(ZDeploymentUtil
						.getRootDeploymentParts(deployment));
				}
			};

			try {
				if (domain != null) {
					Collection<Property> col = (Collection<Property>) domain
							.runExclusive(runnable);
					return col.toArray();
				}
			} catch (Exception e) {
				Activator
					.getDefault()
					.error(
						DeploymentEditorMessages.LeftTreeContentProvider_ReadingFromModelErrorMsg,
						e);
			}
		}
		return new Object[0];
	}	

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		if (domain != null)
			domain.removeResourceSetListener(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
	}
	
	/**
	 * Set the deployment, and the deployment's domain.
	 * 
	 * @param Component deploymentComponent
	 */
	private void setDeployment(Component deploymentComponent){
		deployment = deploymentComponent;
		domain = TransactionUtil.getEditingDomain(deployment);		
	}
	
	/**
	 * Refresh the tree viewer.
	 */
	private void refreshViewer() {
		if ((viewer == null) || (viewer.getControl().isDisposed())) {
			return;
		}
		viewer.refresh();
	}
}
