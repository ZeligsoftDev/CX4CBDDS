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
package com.zeligsoft.base.ui.menus.actions;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.menus.l10.Messages;

/**
 * This class is an action specifically for delegating to a class that
 * supports the IActionDelegate interface. It is intended to be instantiated
 * from a delegate action element in the menu model.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class JavaDelegateAction extends Action implements ISelectionListener, ISelectionChangedListener {
	private String host;
	
	private String className;
	
	private IActionDelegate delegate;
	
	private String label;
	
	/**
	 * Initializes me with the name of the Java class that I load and
	 * the bundle from which I load it.
	 * @param className
	 * 		My Java class name
	 * @param bundle
	 * 		My host bundle symbolic name
	 */
	public JavaDelegateAction(String className, String bundle, String label, 
			String tooltip) {
		this.className = className;
		this.host = bundle;
		this.label = label;
		if(tooltip != null) {
			setToolTipText(tooltip);
		}
	}
	
	@Override
	public void run() {
		getDelegate().run(this);
	}
	
	@Override
	public String getText() {
		return label;
	}
	
	/**
	 * A helper method retrieves the class referenced by the action from
	 * the platform.
	 * 
	 * @return
	 * 		An instance of the class referenced by the action.
	 */
	private IActionDelegate getDelegate() {
		if(delegate == null) {
			Bundle bundle = Platform.getBundle(host);
			
			if(bundle == null) {
				// was unable to load the bundle
				throw new IllegalArgumentException(
						NLS.bind(Messages.JavaDelegate_noBundle, host));
			}
			
			try {
				@SuppressWarnings("unchecked")
				Class<IActionDelegate> clazz = (Class<IActionDelegate>) bundle.loadClass(className);
				delegate = clazz.newInstance();
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
		}
		
		return delegate;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		selectionChanged(event.getSelection());
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		selectionChanged(selection);
	}
	
	protected void selectionChanged(ISelection selection) {
		getDelegate().selectionChanged(this, selection);
	}
	
}
