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
package com.zeligsoft.base.ui.menus.providers;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.ui.menus.l10.Messages;
import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Provides the dynamic domain specific menus to elements on a
 * diagram. It looks at the menu model associated with the
 * domain profiles applied to the model that the diagram is
 * defined in.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class DomainSpecificContributionItemProvider extends
		AbstractContributionItemProvider {

	private static final String MENU_ID = "com.zeligsoft.base.ui.menus.add"; //$NON-NLS-1$
	private static final String GROUP_ID = "addCXGroup"; //$NON-NLS-1$
	
	@Override
	protected IMenuManager createMenuManager(String menuId,
			IWorkbenchPartDescriptor partDescriptor) {
		return
		MENU_ID.equals( menuId )
			? new ActionMenuManager(
				MENU_ID,
				new Action() { { setText( Messages.DomainSpecificContributionItemProvider_action_label ); } },
				true )
			: super.createMenuManager( menuId, partDescriptor );
	}
	
	@Override
	protected ActionGroup createActionGroup(String actionGroupId,
			IWorkbenchPartDescriptor partDescriptor) {
		return
		GROUP_ID.equals( actionGroupId )
			? new MenuProvider()
			: super.createActionGroup( actionGroupId, partDescriptor );
	}
	
	///
	///
	///	Static internal helper classes
	///
	///
	
	/**
	 * The provider that fills the menu.
	 */
	private static class MenuProvider extends CommonActionProvider {
		private static final String MB_GROUP_NEW = "group.new"; //$NON-NLS-1$

		private static final String MB_GROUP_UML = "umlAddGroup"; //$NON-NLS-1$
		
		@Override
		public void fillContextMenu(IMenuManager menu) {
			
			ISelection selection = getSelection();
			if(selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() > 1){
				return;
			}
			
			EObject selectedEObject = BaseUIUtil.getEObjectFromSelection(selection);
			if (!(selectedEObject instanceof Element)) {
				return;
			}
			Element element = (Element) selectedEObject;
			
			if(element != null) {
				
				ZDLProjectExplorerMenuFactory factory =
					new ZDLProjectExplorerMenuFactory(element);
				
				Collection<IContributionItem> items =factory.createMenu();
				
				if (! items.isEmpty()) {
					IMenuManager subMenu =
						new MenuManager(Messages.DomainSpecificContributionItemProvider_add_cx_submenu_label);
					for (IContributionItem item : items) {
						subMenu.add(item);
					}
					
					if (menu.find(MB_GROUP_NEW) != null) {
						menu.appendToGroup(MB_GROUP_NEW, subMenu);
					} else {
						menu.appendToGroup(MB_GROUP_UML, subMenu);
					}
				}
			}
			
			super.fillContextMenu(menu);
		}
		
		@Override
		public ActionContext getContext() {
			return new ActionContext( getSelection() );
		}
		
		/**
		 * Retrieve the currently selected element in the diagram.
		 * 
		 * @return
		 * 		The current selection in the diagram.
		 */
		private ISelection getSelection() {
			ISelection selection = StructuredSelection.EMPTY;
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if( page == null ) {
				return selection;
			}

			IWorkbenchPart activePart = page.getActivePart();
			if( activePart == null )
				return selection;

			ISelectionProvider selectionProvider = activePart.getSite().getSelectionProvider();
			if( selectionProvider != null
			 && selectionProvider.getSelection() instanceof IStructuredSelection )
				selection = selectionProvider.getSelection();
			
			return selection;
		}
	}
}
