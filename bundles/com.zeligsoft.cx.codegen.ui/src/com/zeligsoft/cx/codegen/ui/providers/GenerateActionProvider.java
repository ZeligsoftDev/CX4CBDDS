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

package com.zeligsoft.cx.codegen.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;

import com.zeligsoft.cx.codegen.ui.actions.TransformAction;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;
import com.zeligsoft.cx.codegen.ui.utils.ActionsCollector;

/**
 * Dynamic action group which examines the
 * com.zeligsoft.cx.codegen.ui.transformation extension point and adds
 * <code>TransformationAction</code> for each extension applicable entry.
 * 
 * @author jcorchis
 * 
 */
public class GenerateActionProvider
		extends CommonActionProvider {

	private IWorkbenchPage workbenchPage = null;

	private List<TransformAction> actionCache = null;

	@Override
	public void fillContextMenu(IMenuManager menu) {

		EObject eObj = getSelectedEObject();
		if(eObj == null){
			return;
		}
		actionCache = new ArrayList<TransformAction>();
		try {
			ActionsCollector.populateActionsFromElement(eObj, actionCache, TransformAction.class);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if( actionCache.size() == 1 )
		{
			if( menu.find( IWorkbenchActionConstants.MB_ADDITIONS ) != null )
				menu.appendToGroup( IWorkbenchActionConstants.MB_ADDITIONS, actionCache.get(0) );
			else
				menu.add( actionCache.get(0) );
		}
		else if( actionCache.size() >= 2 )
		{
			// try to create a sub-menu
			IMenuManager codegenMenu;
			if( menu.find( IWorkbenchActionConstants.MB_ADDITIONS ) == null )
				codegenMenu = menu;
			else
			{
				codegenMenu = new MenuManager( Messages.GenerateActionProvider_CodeGenMenuManagerTitle );
				menu.appendToGroup( IWorkbenchActionConstants.MB_ADDITIONS, codegenMenu );
			}

			// add the rest of the generate actions
			for( int i = 0; i < actionCache.size(); ++i )
			{
				codegenMenu.add( actionCache.get( i ) );
			}
		}

		super.fillContextMenu(menu);

	}

	@Override
	public void dispose() {
		workbenchPage = null;
		if (actionCache != null) {
			actionCache.clear();
		}
		actionCache = null;
		super.dispose();
	}

	@Override
	public ActionContext getContext() {
		ISelection selection = StructuredSelection.EMPTY;

		if (workbenchPage == null) {
			workbenchPage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		}

		IWorkbenchPart activePart = workbenchPage.getActivePart();
		if (activePart != null) {
			ISelectionProvider selectionProvider = activePart.getSite()
				.getSelectionProvider();
			if (selectionProvider != null
				&& selectionProvider.getSelection() instanceof IStructuredSelection) {
				selection = selectionProvider.getSelection();
			}
		}

		return new ActionContext(selection);
	}

	private EObject getSelectedEObject() {
		EObject eObject = null;

		ActionContext context = getContext();
		ISelection selection = context.getSelection();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			if(s.size() > 1){
				return null;
			}
			Object obj = s.getFirstElement();
			if (obj instanceof EObject) {
				eObject = (EObject) obj;
			} else if (obj instanceof IAdaptable) {
				eObject = (EObject) ((IAdaptable) obj)
					.getAdapter(EObject.class);
			}
		}
		return eObject;
	}

}
