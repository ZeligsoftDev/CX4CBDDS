/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Certain generic utility operations on objects.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ObjectUtil {

	/**
	 * Disposes of the specified <tt>object</tt>.  If, in particular, it is
	 * an {@link EObject}, then it and all of its contents will have their
	 * adapter-lists cleared.
	 * 
	 * @param object an object to dispose
	 */
	public static void dispose(Object object) {
	    if (object instanceof EObject) {
	        EObject eObject = (EObject) object;
	        
            eObject.eAdapters().clear();
            for (Iterator<EObject> iter = EcoreUtil.getAllContents(eObject,
                false); iter.hasNext();) {
                iter.next().eAdapters().clear();
            }
	    } else if (object instanceof Collection<?>) {
	        for (Object next : ((Collection<?>) object)) {
	            dispose(next);
	        }
	    }
	}
}
