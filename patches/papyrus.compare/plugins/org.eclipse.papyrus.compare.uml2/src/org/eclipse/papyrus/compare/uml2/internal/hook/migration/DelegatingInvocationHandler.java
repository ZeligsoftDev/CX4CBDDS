/*******************************************************************************
 * Copyright (c) 2017 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.hook.migration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.compare.uml2.internal.UMLPapyrusComparePlugin;

/**
 * An invocation handler that wraps a given object and delegates all method calls to this object. The
 * underlying assumption therefore is that there is a 1:1 mapping between the methods of a proxy instance
 * created with this handler and the object. Any errors occurring during method calls will be silently logged
 * and the called proxy method will simply return null.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public class DelegatingInvocationHandler implements InvocationHandler {

	/** Object handling the method calls. */
	private Object object;

	/**
	 * Creates a new invocation handler with the given object. Any calls made to a proxy instance created with
	 * this handler will be delegated to this object. If errors occur, they will be logged and the called proxy
	 * method will simply return null.
	 * 
	 * @param object
	 *            object handling the method calls
	 */
	public DelegatingInvocationHandler(Object object) {
		this.object = object;
	}

	// CHECKSTYLE:OFF - for Throwable
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// CHECKSTYLE:ON
		if (object == null) {
			return null;
		}
		try {
			Method objectMethod = object.getClass().getDeclaredMethod(method.getName(),
					method.getParameterTypes());
			return objectMethod.invoke(object, args);
		} catch (NullPointerException | NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			UMLPapyrusComparePlugin.getDefault().getLog()
					.log(new Status(IStatus.WARNING, UMLPapyrusComparePlugin.PLUGIN_ID,
							"Unable to invoke method '" + method.getName() //$NON-NLS-1$
									+ "' on Object " + object, //$NON-NLS-1$
							e));
		}
		return null;
	}
}
