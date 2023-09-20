/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.util.stdlib;


/**
 * Java helper class for Stdlib extension <tt>org::eclipse::xtend::util::stdlib::globalvar</tt>.
 *
 * @author Karsten Thoms - Bug#310361
 */
public class GlobalVarExtensions extends AbstractStatefulExtensions<Object>{

	public void storeGlobalVar(String s, Object o) {
		set(s, o);
	}

	public Object getGlobalVar(String s) {
		return get(s);
	}

	public Object removeGlobalVar(String s) {
		return set(s,null);
	}

	public void clearGlobalVars () {
		getVars().clear();
	}

}
