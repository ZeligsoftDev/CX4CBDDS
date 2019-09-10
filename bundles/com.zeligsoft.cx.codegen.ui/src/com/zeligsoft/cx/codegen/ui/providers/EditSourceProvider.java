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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
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

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.codegen.editor.IUserEditableElementDescriptor;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.actions.EditSourceAction;
import com.zeligsoft.cx.codegen.ui.internal.UserEditableElementFactory;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;

/**
 * Dynamic action group which examines the  * com.zeligsoft.base.codegen.ui.editsource
 * extension point and adds an <code>EditSourceAction</code> for each extension applicable
 * entry.
 * Originally copied from GenerateActionProvider.
 */
public class EditSourceProvider extends CommonActionProvider
{
	@Override
	public void fillContextMenu( IMenuManager menu )
	{
		ISelection selection = getContext().getSelection();
		if(selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() > 1){
			return;
		}
		
		EObject eObj = BaseUIUtil.getEObjectFromSelection(selection);
		if(eObj == null){
			return;
		}
		List<String> concepts = getZDLConcepts( eObj );

		for( String concept: concepts ) {
			List<IUserEditableElementDescriptor> descriptors = getActionDescriptors( concept );
			if( descriptors != null )
			{
				LinkedList<IAction> actions = new LinkedList<IAction>();
				for( IUserEditableElementDescriptor desc : descriptors )
				{
					IAction action = createAction( desc.getLabel(), eObj, desc );
					if( action != null )
						actions.add( action );
				}

				if( actions.size() == 1 )
				{
					IAction action = actions.get( 0 );
					action.setText( Messages.EditSourceActionProvider_EditSourceTitle );
					menu.appendToGroup( IWorkbenchActionConstants.MB_ADDITIONS, action );
				}
				else
				{
					IMenuManager submenu = new MenuManager( Messages.EditSourceActionProvider_EditSourceTitle );
					menu.appendToGroup( IWorkbenchActionConstants.MB_ADDITIONS, submenu );

					for( IAction action : actions )
						submenu.add( action );
				}
			}
		}
		
		super.fillContextMenu( menu );
	}

	protected static Action createAction( String label, EObject object, IUserEditableElementDescriptor desc )
	{
		//If a containerConcept is defined, check that the criteria
		//is satisfied.  If not, no action is created, return null.
		if( object.eContainer() != null
		 && desc.getContainerConcept() != null )
			if( ! ZDLUtil.isZDLConcept( object.eContainer(), desc.getContainerConcept() ) )
				return null;

		return new EditSourceAction( label, object, desc );
	}

	@Override
	public ActionContext getContext() {

		ISelection selection = StructuredSelection.EMPTY;
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if( page == null )
			return new ActionContext( selection );

		IWorkbenchPart activePart = page.getActivePart();
		if( activePart == null )
			return new ActionContext( selection );

		ISelectionProvider selectionProvider = activePart.getSite().getSelectionProvider();
		if( selectionProvider != null
		 && selectionProvider.getSelection() instanceof IStructuredSelection )
			selection = selectionProvider.getSelection();

		return new ActionContext( selection );
	}

	protected List<String> getZDLConcepts(EObject eObject) {

		List<String> retVal = new ArrayList<String>();
		
		for( org.eclipse.uml2.uml.Class eClass : ZDLUtil.getAllZDLConcepts(eObject)) {
			retVal.add(eClass.getQualifiedName());
		}

		return retVal;
		
	}

	private static Map<String, List<IUserEditableElementDescriptor>> descriptors = null;
	public List<IUserEditableElementDescriptor> getActionDescriptors( String concept )
	{
		if( concept == null )
			return null;

		if( descriptors == null )
			descriptors = readDescriptors();

		return descriptors.get( concept );
	}

	private static Map<String, List<IUserEditableElementDescriptor>> readDescriptors()
	{
		Map<String, List<IUserEditableElementDescriptor>> map = new HashMap<String, List<IUserEditableElementDescriptor>>();

		IExtension[] extensions
			= Platform.getExtensionRegistry()
				.getExtensionPoint( CodeGenUIPlugin.PLUGIN_ID, CodeGenUIPlugin.EDITSOURCE_EP_ID )
				.getExtensions();

		for( IExtension extension : extensions )
			for( IConfigurationElement configElement : extension.getConfigurationElements() )
				if( UserEditableElementFactory.ELEMENT_TAG.equals( configElement.getName() ) )
				{				
					IUserEditableElementDescriptor desc = UserEditableElementFactory.create( configElement );
					List<IUserEditableElementDescriptor> descs = map.get( desc.getConcept() );
					if( descs == null )
					{
						descs = new LinkedList<IUserEditableElementDescriptor>();
						map.put( desc.getConcept(), descs );
					}
					
					descs.add( desc );
				}

		return map;
	}
}
