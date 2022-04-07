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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.activities.WorkbenchActivityHelper;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.toolingmodel.CreateAction;
import com.zeligsoft.base.toolingmodel.DelegateAction;
import com.zeligsoft.base.toolingmodel.Menu;
import com.zeligsoft.base.toolingmodel.MenuItem;
import com.zeligsoft.base.toolingmodel.MenuModel;
import com.zeligsoft.base.toolingmodel.MenuSeparator;
import com.zeligsoft.base.toolingmodel.util.ToolingModelSwitch;
import com.zeligsoft.base.ui.menus.actions.CreateConceptAction;
import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.ui.menus.l10.Messages;
import com.zeligsoft.base.ui.menus.util.CXMenuUtil;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.ui.utils.ZDLActivityUtil;
import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.util.UMLTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A class that will create the menu for a given context concept. It 
 * consults with the menu model that is associated with the domain 
 * profile.
 * 
 * It is used by providing a context when the factory is created and
 * then calling createMenu on the factory.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class ZDLProjectExplorerMenuFactory {
	
	
	private final Element selection;
	
	/**
	 * Initialize me.
	 * 
	 * @param context
	 * 		The element that the menus are be created for.
	 */
	public ZDLProjectExplorerMenuFactory(Element context) {
		selection = context;
	}
	
	/**
	 * Will generate a list of all of the menu contributions for
	 * the context element that was provided when the factory was
	 * created.
	 * 
	 * @return
	 * 		A list of all of the top level contributions for the
	 * 		context element.
	 */
	public Collection<IContributionItem> createMenu() {
		List<IContributionItem> items = new ArrayList<IContributionItem>();
		final List<org.eclipse.uml2.uml.Class> contextConcepts
			= ZDLUtil.getZDLConcepts(selection);
		boolean atLeastOneNotAbstract = false;
		
		for(org.eclipse.uml2.uml.Class concept : contextConcepts) {
			if(!concept.isAbstract()) {
				atLeastOneNotAbstract = true;
				break;
			}
		}
		
		if(!atLeastOneNotAbstract) {
			List<IContributionItem> result = createMenu4UML();
			items.addAll(result);
		} else {
			for(org.eclipse.uml2.uml.Class concept : contextConcepts) {
				List<IContributionItem> result = createMenu(concept);
				items.addAll(result);
			}
		}

		return items;
	}
	
	/**
	 * A helper menu which creates the list of contributions for a specific
	 * ZDL concept.
	 * 
	 * @param concept
	 * 		The concept to create the list of contributions for.
	 * 
	 * @return
	 * 		The list of contributions for the provided concept.
	 */
	protected List<IContributionItem> createMenu(org.eclipse.uml2.uml.Class concept) {
		final Profile domainProfile = ZDLUtil.getZDLProfile(selection, concept);
		final ActionFactory factory = new ActionFactory(selection, domainProfile);
		ArrayList<IContributionItem> contributionItems 
			= new ArrayList<IContributionItem>();
		
		if(domainProfile != null) {
			MenuModel mModel = CXMenuUtil.getMenuModel(domainProfile);
			if(mModel != null) {
				List<MenuItem> items = mModel.getItems(concept.getQualifiedName());
				for(MenuItem next : items) {
					IContributionItem ci = factory.doSwitch(next);
					IPluginContribution pc = ZDLActivityUtil.PluginContributionFactory.INSTANCE.create(ci.getId());
					if(!WorkbenchActivityHelper.filterItem(pc)) {
						contributionItems.add(ci);
					}
				}
			}
		}
		
		return contributionItems;
	}
	
	protected List<IContributionItem> createMenu4UML() {
		final Collection<Profile> domainProfiles = ZDLUtil.getZDLProfiles(selection);
		final String umlType = UMLTypeUtil.umlType(selection);
		final ActionFactory factory = new ActionFactory(selection);
		ArrayList<IContributionItem> contributionItems 
			= new ArrayList<IContributionItem>();
		
		for(Profile domainProfile : domainProfiles) {
			factory.setDomainProfile(domainProfile);
			MenuModel mModel = CXMenuUtil.getMenuModel(domainProfile);
			if(mModel != null) {
				List<MenuItem> items = mModel.getItems(umlType);
				for(MenuItem next : items) {	
					IContributionItem ci = factory.doSwitch(next);
					IPluginContribution pc = ZDLActivityUtil.PluginContributionFactory.INSTANCE.create(ci.getId());
					if(!WorkbenchActivityHelper.filterItem(pc)) {
						contributionItems.add(ci);
					}
				}
			}
		}
		
		return contributionItems;
	} 
	
	///
	///
	///		Internal classes
	///
	///
	
	/**
	 * A class that given an element from the menu model will manufacture
	 * the correct contribution item.
	 */
	private static class ActionFactory extends ToolingModelSwitch<IContributionItem> {
		private EObject context;
		private Profile domainProfile;
		
		/**
		 * Initialize me.
		 * 
		 * @param context
		 * 		The context that I am manufacturing for.
		 */
		public ActionFactory(EObject context, Profile domainProfile) {
			this.context = context;
			this.domainProfile = domainProfile;
		}
		
		public ActionFactory(EObject context) {
			this(context, null);
		}
		
		public void setDomainProfile(Profile domainProfile) {
			this.domainProfile = domainProfile;
		}
		
		private String getIdPrefix() {
			String idPrefix = ZDLActivityUtil.ID_PREFIX;
			if(domainProfile != null) {
				idPrefix += UML2Util.getValidJavaIdentifier(domainProfile.getName());
			}
			
			return idPrefix;
		}
		
		@Override
		public IContributionItem caseCreateAction(CreateAction createAction) {
			CreateConceptAction action = null;
			
			org.eclipse.uml2.uml.Class conceptClass = null;
			
			if (createAction.getCreateConcept() != null 
					&& createAction.getCreateConcept().length() > 0) {
				conceptClass = ZDLUtil.getZDLConcept(context, createAction
						.getCreateConcept());
			}
			if(conceptClass == null && createAction.getTypeHint() == null) {
				throw new IllegalArgumentException(Messages.ZDLProjectExplorerMenuFactory_ErrorCalculatingConcept_msg + createAction.getCreateConcept());
			}
			
			String label =
				createAction.getName() != null && createAction.getName().length() > 0 ?
						createAction.getName() : null;
			
			String id = ""; //$NON-NLS-1$
			if(conceptClass != null) {
				id = String.format("%s.%s", getIdPrefix(),  //$NON-NLS-1$
						UML2Util.getValidJavaIdentifier(conceptClass.getQualifiedName().replaceAll("::", "."))); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				id = String.format("%s.%s", getIdPrefix(),  //$NON-NLS-1$
						UML2Util.getValidJavaIdentifier(createAction.getTypeHint()	));
			}
			action = new CreateConceptAction(context, conceptClass, 
					createAction.getTypeHint(), label);
			action.setDescription(createAction.getDescription());
			action.setId(id);
			
			return new ActionContributionItem(action);
		}
		
		@Override
		public IContributionItem caseMenu(Menu object) {
			String id = String.format("%s.menu.%s", getIdPrefix(),  //$NON-NLS-1$
					UML2Util.getValidJavaIdentifier(object.getName()));
			
			MenuManager submenu = new MenuManager(object.getName(), id);
			
			for(MenuItem subItem : object.getItem()){
				IContributionItem ci = doSwitch(subItem);
				IPluginContribution pc = ZDLActivityUtil.PluginContributionFactory.INSTANCE.create(ci.getId());
				if(!WorkbenchActivityHelper.filterItem(pc)) {
					submenu.add(ci);
				}
			}
			
			return submenu;
		}
		
		@Override
		public IContributionItem caseDelegateAction(DelegateAction delegateAction) {
			String className = delegateAction.getClassName();
			String host = delegateAction.getHostBundle();
			Bundle bundle = Platform.getBundle(host);
			
			ICXAction delegate = null;
			if(bundle == null) {
				// was unable to load the bundle
				throw new IllegalArgumentException(
						NLS.bind(Messages.JavaDelegate_noBundle, host));
			}
			
			try {
				@SuppressWarnings("unchecked")
				Class<ICXAction> clazz = (Class<ICXAction>) bundle.loadClass(className);
				delegate = clazz.newInstance();
				delegate.setSelection(context);
				delegate.setText(delegateAction.getName());
				delegate.setEnabled(!BaseUtil.isReadOnlyReferencedModel(context));
				String id = String.format("%s.delegate.%s", getIdPrefix(), //$NON-NLS-1$
						clazz.getName());
				delegate.setId(id);
				
			} catch (ClassNotFoundException e) {
				// results in the action being disabled
				throw new IllegalArgumentException(NLS.bind(Messages.JavaDelegate_noSuchClass, className, host), e);
			} catch (IllegalAccessException e) {
				// results in the action being disabled with a log message
				throw new RuntimeException(NLS.bind(
					Messages.JavaDelegate_classAccess, className, host), e);
			} catch (InstantiationException e) {
				// results in the action being disabled with a log message
				throw new RuntimeException(NLS.bind(
					Messages.JavaDelegate_instantiation, className, host), e);
			}
			
			return new ActionContributionItem(delegate);
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.base.toolingmodel.util.ToolingModelSwitch#caseMenuSeparator(com.zeligsoft.base.toolingmodel.MenuSeparator)
		 */
		@Override
		public IContributionItem caseMenuSeparator(MenuSeparator object) {
			Separator sep = new Separator();
			String id = String.format("%s.%s", getIdPrefix(),  //$NON-NLS-1$
					object.getName());
			sep.setId(id);
			
			return sep;
		}
	}
}
