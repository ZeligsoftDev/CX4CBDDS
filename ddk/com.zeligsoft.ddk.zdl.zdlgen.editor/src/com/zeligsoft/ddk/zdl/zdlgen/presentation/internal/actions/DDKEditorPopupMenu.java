/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.presentation.internal.actions;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;


public class DDKEditorPopupMenu 
	extends CompoundContributionItem {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		final GenDomainObject selectedElement = getSelectedElement();
		
		if(selectedElement != null) {
			final Collection<IContributionItem> items = 
					calculateContributionItems(selectedElement);
			if(items != null && items.size() > 0) {
				return items.toArray(new IContributionItem[items.size()]);
			}
		}
		
		return new IContributionItem[] {};
	}
	
	private Collection<IContributionItem> calculateContributionItems(
			final GenDomainObject eObj) {
		if(eObj != null) {
			DDKMenuFactory factory = new DDKMenuFactory(getActivePart(), eObj);
			return factory.createMenu();
		}
		
		return Collections.emptyList();
	}
	
	private IWorkbenchPart getActivePart() {
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		
		if( page == null ) {
			return null;
		}

		return page.getActivePart();
	}

	private GenDomainObject getSelectedElement() {
		ISelection selection = StructuredSelection.EMPTY;
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		
		if( page == null ) {
			return null;
		}

		IWorkbenchPart activePart = page.getActivePart();
		if( activePart == null )
			return null;

		ISelectionProvider selectionProvider = activePart.getSite().getSelectionProvider();
		if( selectionProvider != null
		 && selectionProvider.getSelection() instanceof IStructuredSelection ) {
			selection = selectionProvider.getSelection();
		
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			
			if(structuredSelection.size() > 1 || structuredSelection.isEmpty()) {
				return null;
			}
			
			Object firstElement = structuredSelection.getFirstElement();
			
			if(firstElement instanceof GenDomainObject) {
				return (GenDomainObject) firstElement;
			}
		}
		
		return null;
	}
}
