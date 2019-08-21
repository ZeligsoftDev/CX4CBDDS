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

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionGroup;

import com.zeligsoft.cx.codegen.ui.l10n.Messages;

/**
 * Diagram action group for the Open Editor action contributions.
 */
public class EditSourceContributionItemProvider extends AbstractContributionItemProvider
{
	private static final String MENU_ID = "Edit_Source"; //$NON-NLS-1$
	private static final String GROUP_ID = "editSourceGroup"; //$NON-NLS-1$

	@Override
	protected IMenuManager createMenuManager( String menuId, IWorkbenchPartDescriptor partDescriptor )
	{
		return
			MENU_ID.equals( menuId )
				? new ActionMenuManager(
					MENU_ID,
					new Action() { { setText( Messages.EditSourceActionProvider_EditSourceTitle ); } },
					true )
				: super.createMenuManager( menuId, partDescriptor );
	}

	@Override
	protected ActionGroup createActionGroup( String actionGroupId, IWorkbenchPartDescriptor partDescriptor )
	{
		return
			GROUP_ID.equals( actionGroupId )
				? new EditSourceProvider()
				: super.createActionGroup( actionGroupId, partDescriptor );
	}
}
