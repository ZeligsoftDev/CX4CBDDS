/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.util.stdlib;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Java helper class for Stdlib extension <tt>org::eclipse::xtend::util::stdlib::cloning</tt>.
 */
public class CloningExtensions {

	public static Object clone(Object original) {
		EObject context = (EObject) original;
		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		EObject copy = copier.copy(context);
		copier.copyReferences();
		return copy;
	}

}
