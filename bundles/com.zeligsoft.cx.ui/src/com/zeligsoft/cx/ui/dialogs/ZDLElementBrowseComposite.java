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
package com.zeligsoft.cx.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.ibm.xtools.common.ui.navigator.viewers.NavigatorSelectionComposite;
import com.ibm.xtools.modeler.ui.UMLModeler;
import com.ibm.xtools.uml.navigator.ClosedModelerResourceViewerElement;
import com.ibm.xtools.uml.navigator.ModelFolderViewerElement;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * ZDL Element Browse Composite
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("rawtypes")
public class ZDLElementBrowseComposite extends NavigatorSelectionComposite {

	protected Object browseTabLastSelectedElement = null;

	protected List<String> concepts;

	protected IFilter filter = null;

	protected ArrayList<EObject> selectedList = new ArrayList<EObject>();

	public ZDLElementBrowseComposite(String selectionTitle, boolean multiselectable,
			List initialSelectedElements, List<String> concpets) {
		super(selectionTitle, multiselectable, initialSelectedElements);
		this.concepts = concpets;
	}

	public void setFilter(IFilter filter) {
		this.filter = filter;
	}

	@Override
	protected Object getInput() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getContentProviders() {
		List<String> providers = new ArrayList<String>();
		providers.add("com.ibm.xtools.modeler.ui.navigator.internal.providers.content.umlModelContent"); //$NON-NLS-1$
		providers.add("org.eclipse.ui.navigator.resourceContent"); //$NON-NLS-1$
		return providers;
	}

	@Override
	public void handleSelection(boolean isValid) {
		// open closed model file
		if (browseTabLastSelectedElement != null) {
			// open closed model file
			if (browseTabLastSelectedElement instanceof ClosedModelerResourceViewerElement) {
				ClosedModelerResourceViewerElement model = (ClosedModelerResourceViewerElement) browseTabLastSelectedElement;
				UMLModeler.getEditingDomain().getResourceSet()
						.getResource(
								URI.createFileURI(model.getFile().getFullPath()
										.toString()), true);
			}
		}
	}

	@Override
	protected boolean isDisplayable(Object element) {
		if (element instanceof IProject || element instanceof ModelFolderViewerElement
				|| element instanceof ClosedModelerResourceViewerElement) {
			return true;
		}
		if (element instanceof IAdaptable) {
			EObject eObject = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
			if (eObject == null) {
				return false;
			}
			if (isSelectedElementValid(eObject)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean isDisplayableRuleRecursive(Object element) {
		return true;
	}

	/**
	 * Return structured selection
	 * 
	 * @return
	 */
	public IStructuredSelection getSelection() {
		return new StructuredSelection(selectedList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getSelectedElements() {
		return selectedList;
	}

	@Override
	protected boolean isValidSelection(List currentSelectedElements) {
		selectedList.clear();
		for (Object obj : currentSelectedElements) {
			browseTabLastSelectedElement = obj;
			if (obj instanceof IAdaptable) {
				EObject selectedElement = (EObject) ((IAdaptable) obj)
						.getAdapter(EObject.class);
				if (selectedElement != null) {
					selectedList.add(selectedElement);
					if (!isSelectedElementValid(selectedElement)) {
						selectedList.clear();
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Queries if the given element is valid element
	 * 
	 * @param element
	 * @return
	 */
	private boolean isSelectedElementValid(EObject element) {
		if (filter != null) {
			if (filter.select(element)) {
				return true;
			}
			return false;
		}
		for (String concept : concepts) {
			if (ZDLUtil.isZDLConcept(element, concept)) {
				return true;
			}
		}
		return false;
	}
}
