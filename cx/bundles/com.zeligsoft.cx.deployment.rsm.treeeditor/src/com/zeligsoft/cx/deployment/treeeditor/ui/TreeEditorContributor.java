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

package com.zeligsoft.cx.deployment.treeeditor.ui;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * This is the contributor for the tree editor.  This is where the UNDO, REDO and DELETE actions are
 * associated with the proper toolbar/menu actions.
 * 
 * @author sduchesneau
 *
 */
public class TreeEditorContributor extends EditorActionBarContributor
{
	public TreeEditorContributor()
	{
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorActionBarContributor#setActiveEditor(org.eclipse.ui.IEditorPart)
	 */
	@Override
	public void setActiveEditor(IEditorPart part)
	{
		if (part instanceof DeploymentTreeEditor)
		{
			DeploymentTreeEditor editor = (DeploymentTreeEditor) part;

			IActionBars actionBars = getActionBars();
			
			if (editor.getActivePageInstance() instanceof DeploymentFormPage)
			{
				DeploymentFormPage page = (DeploymentFormPage) editor.getActivePageInstance();
			
				actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),page.getTreeEditorAction(ActionFactory.UNDO.getId()));
				actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), page.getTreeEditorAction(ActionFactory.REDO.getId()));
				actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), page.getTreeEditorAction(ActionFactory.DELETE.getId()));			
			
				actionBars.updateActionBars();
			}
		}		
	}	
}
