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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.osgi.framework.Bundle;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenException;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenTargetRegistry;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.DDKCodegenAction;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.DDKCodegenTarget;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.ZDLGenEditorPlugin;
import com.zeligsoft.ddk.zdl.zdlgen.util.ZDLGenUtil;

/**
 * @author prismtech
 *
 */
public class DDKMenuFactory {
	

	private final GenDomainObject selection;
	private final IWorkbenchPart myPart;
	
	/**
	 * Initialize me.
	 * @param iWorkbenchPart 
	 * 
	 * @param context
	 * 		The element that the menus are created for.
	 */
	public DDKMenuFactory(IWorkbenchPart iWorkbenchPart, final GenDomainObject context) {
		this.selection = context;
		myPart = iWorkbenchPart;
	}
	
	public Collection<IContributionItem> createMenu() {
		List<IContributionItem> items = Lists.newArrayList();
		final Collection<DDKCodegenTarget> targets = CodegenTargetRegistry.INSTANCE.getTargets();
		final Set<String> targetsUsedInModel = ZDLGenUtil.targetsUsedInModel(selection);
		
		for(final DDKCodegenTarget target : targets) {
			if (targetsUsedInModel.contains(target.getId())) {
				final MenuManager submenu = new MenuManager(target.getLabel(), target.getId());
				for (final DDKCodegenAction action : target.getActions()) {
					final Action ddkAction = new DDKMenuAction(myPart, action, selection);
					submenu.add(new ActionContributionItem(ddkAction));
				}
				items.add(submenu);
			}
		}
		
		return items;
	}
	
	/**
	 * @author prismtech
	 *
	 */
	private static final class DDKMenuAction extends Action {
		/**
		 * 
		 */
		private final DDKCodegenAction action;
		
		private final GenDomainObject selection;
		
		private final IWorkbenchPart myPart;

		/**
		 * @param action
		 */
		private DDKMenuAction(final IWorkbenchPart iWorkbenchPart, final DDKCodegenAction action, 
				final GenDomainObject selection) {
			this.action = action;
			this.selection = selection;
			myPart = iWorkbenchPart;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.action.Action#getText()
		 */
		@Override
		public String getText() {
			if (action.getName() != null
					&& !action.getName().isEmpty()) {
				return action.getName();
			} else {
				return action.getId();
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.action.Action#isEnabled()
		 */
		@Override
		public boolean isEnabled() {
			return action.appliesTo(selection);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.action.Action#runWithEvent(org.eclipse.swt.widgets.Event)
		 */
		@Override
		public void runWithEvent(Event event) {
			ICodegenAction codegenAction = null;
			try {
				if(!Strings.isNullOrEmpty(action.getiCodegenAction())) {
					Bundle bundle = Platform.getBundle(action.getBundle());
					
					if(bundle != null) {
						@SuppressWarnings("unchecked")
						Class<ICodegenAction> clazz = (Class<ICodegenAction>) bundle.loadClass(action.getiCodegenAction());
						if(clazz != null) {
							Object obj = clazz.newInstance();
							if(obj != null && obj instanceof ICodegenAction) {
								codegenAction = (ICodegenAction) obj;
							}
						}
					}
				}
			} catch(ClassNotFoundException e) {
				ZDLGenEditorPlugin.getPlugin().error(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				ZDLGenEditorPlugin.getPlugin().error(e.getMessage(), e);
			} catch (InstantiationException e) {
				ZDLGenEditorPlugin.getPlugin().error(e.getMessage(), e);
			}
			
			if(codegenAction != null) {
				
				final Map<Object, Object> context = Maps.newHashMap();
				context.put(ICodegenAction.SHELL, 
						event.display.getActiveShell());
				context.put(ICodegenAction.ACTIVE_PART, 
						myPart);
				context.put(ICodegenAction.WORKSPACE_URI, 
						getWorkspaceRoot());
				context.put(ICodegenAction.MODEL_URI, 
						getModelUri());
				doAction(codegenAction, action.getName(), selection, context);
			}
		}
		
		private String getWorkspaceRoot() {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			String location = root.getLocation().toOSString();
			
			return location;
		}
		
		private String getModelUri() {
			if(selection.eResource() == null) {
				return ""; //$NON-NLS-1$
			} else {
				return selection.eResource().getURI().toString();
			}
			
		}
	
		private static void doAction(final ICodegenAction action,
				final String name,
				final GenDomainObject selection, 
				final Map<Object, Object> context) {
			//final WorkspaceJob job = new WorkspaceJob(name) {
				
			//	@Override
			//	public IStatus runInWorkspace(IProgressMonitor monitor)
			//			throws CoreException {
					//final MultiStatus resultStatus =
					//		new MultiStatus(ZDLGenEditorPlugin.Implementation.PLUGIN_ID,
					//				0, name, null);
					try {
						IStatus status = action.execute(selection, context);
						if(!status.matches(IStatus.OK) && status.matches(IStatus.CANCEL)) {
							ZDLGenEditorPlugin.getPlugin().error(status.toString(), null);
							ErrorDialog.openError((Shell) context.get("shell"),  //$NON-NLS-1$
									"DDK Error", status.getMessage(), status); //$NON-NLS-1$
						}
					} catch (CodegenException e) {
						ZDLGenEditorPlugin.getPlugin().error(
								String.format("There was an error executing the action %s.", name), e); //$NON-NLS-1$
					}
					
					//return resultStatus;
				//}
			//};
			//job.setUser(true);
			//job.schedule();
		}
	}
}
