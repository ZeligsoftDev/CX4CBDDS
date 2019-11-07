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

package com.zeligsoft.cx.deployment.treeeditor;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.ui.commands.DeleteAllocationCommand;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

/**
 * Class that lists the parts that are visible in the right/deploy tree.
 * 
 * @author sduchesneau
 * 
 */
public class DeploymentView
		implements IChangeNotifier {

	private HashSet<Property> visibleItems;

	private Component deployment;

	private TransactionalEditingDomain editingDomain;
	
	private ListenerList listenerList;

	/**
	 * Constructor
	 * 
	 * @param deployment
	 */
	public DeploymentView(Component deployment) {
		visibleItems = new HashSet<Property>();
		this.deployment = deployment;
		this.editingDomain = TransactionUtil.getEditingDomain(deployment);
		listenerList = new ListenerList();
	}

	private void _add(Property part) {
		visibleItems.add(part);

		Collection<Property> deploymentChildren = ZDeploymentUtil
			.getDeploymentChildren(part);

		for (Property childPart : deploymentChildren) {
			_add(childPart);
		}
	}

	/**
	 * Adding a part to the deploy view
	 * 
	 * @param part
	 */
	public void add(Property part) {
		_add(part);
		fireNotifyChanged(null);
	}
	
	/**
	 * Adding a part to the deploy view
	 * 
	 * @param part
	 */
	public void add(List<Property> parts) {
		for (Property part : parts) {
			_add(part);
		}
		fireNotifyChanged(null);
	}

	private void _remove(Property part) {
		Collection<Property> partsDeployedOnThis = ZDeploymentUtil
			.getDeploymentSourceParts(part);
		for (Property deployedPart : partsDeployedOnThis) {
			_remove(deployedPart);
		}

		Collection<Property> children = ZDeploymentUtil
			.getDeploymentChildren(part);
		for (Property childPart : children) {
			_remove(childPart);
		}
		visibleItems.remove(part);

	}

	/**
	 * Removing a part from the deploy view
	 * 
	 * @param part
	 */
	public void remove(Property part) {
		_remove(part);
		fireNotifyChanged(null);
	}
	
	/**
	 * Removing list of parts from the deploy view
	 * 
	 * @param part
	 */
	public void remove(List<Property> parts) {
		for (Property part : parts) {
			_remove(part);
		}
		fireNotifyChanged(null);
	}

	/**
	 * Get all the parts that are visible in the deploy view
	 * 
	 * @return
	 */
	public HashSet<Property> getAll() {
		return visibleItems;
	}

	/**
	 * Get the deployment
	 * 
	 * @return
	 */
	public Component getDeployment() {
		return deployment;
	}

	/**
	 * Checks to see if a part is visible
	 * 
	 * @param part
	 * @return true if part is visible
	 */
	public boolean contains(Property part) {
		return visibleItems.contains(part);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#addListener(org.eclipse.emf.edit.provider.INotifyChangedListener)
	 */
	@Override
	public void addListener(INotifyChangedListener listener) {
		listenerList.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#fireNotifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		Object[] listenerArray = listenerList.getListeners();

		for (int i = 0; i < listenerArray.length; i++) {
			if (listenerArray[i] instanceof INotifyChangedListener) {
				INotifyChangedListener notifyChangedListener = (INotifyChangedListener) listenerArray[i];
				notifyChangedListener.notifyChanged(notification);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#removeListener(org.eclipse.emf.edit.provider.INotifyChangedListener)
	 */
	@Override
	public void removeListener(INotifyChangedListener listener) {
		listenerList.remove(listener);
	}

	public void init() {
		
		Collection<Dependency> allocations = ZDeploymentUtil.getAllocations(deployment);
		for (Dependency dep : allocations) {
			Property property = ZDeploymentUtil.getSourcePartForAllocation(dep);
	
			addRootSourcePartToView(ZDeploymentUtil
				.getDeploymentTargetPart(property));
			if (property != null && !contains(property))
				add(property);			
		}		

	}
	
	private void addRootSourcePartToView(Property part) {
		if (part == null)
			return;

		boolean elementAlreadyInView = false;

		Property tmpPart = part;
		while (ZDeploymentUtil.getParentPart(tmpPart) != null) {
			if (contains(tmpPart)) {
				elementAlreadyInView = true;
				break;
			}
			tmpPart = ZDeploymentUtil.getParentPart(tmpPart);
		}

		if (!elementAlreadyInView) {
			add(tmpPart);
		}
	}

	/**
	 * This function recursively undeploys all the elements under this one. If
	 * this element is not deployed it will not remove it from the view but it
	 * will still remove all the parts deployed on it or on its children.
	 * 
	 * @param element
	 */
	private void undeploy(Property element, CompositeCommand cc){			

		Collection<Property> partsDeployedOnThis = ZDeploymentUtil
			.getDeploymentSourceParts(element);
		for (Property deployedPart : partsDeployedOnThis) {
			undeploy(deployedPart, cc);
		}

		Collection<Property> children = ZDeploymentUtil
			.getDeploymentChildren(element);
		for (Property child : children) {
			undeploy(child, cc);
		}

		ICommand command = null;
		if (ZDeploymentUtil.getDeploymentTargetPart(element) != null){
			command = new DeleteAllocationCommand(element,
				DeploymentEditorMessages.DeploymentView_UndeployCmd);
			cc.compose(command);
		}
		
		else
			return;

		remove(element);		
	}
	
	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	/**
	 * Undeploy
	 * 
	 * @param Property element
	 * @throws ExecutionException
	 */
	public void undeploy(List<Property> elements)
			throws ExecutionException {

		CompositeCommand command = new CompositeCommand(
			DeploymentEditorMessages.DeploymentView_UndeployCmd);
		for (Property element : elements) {
			undeploy(element, command);
		}
		command.reduce();

		Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
		
		if(emfCommand.canExecute()) {
			editingDomain.getCommandStack().execute(emfCommand);
		}

	}
}
