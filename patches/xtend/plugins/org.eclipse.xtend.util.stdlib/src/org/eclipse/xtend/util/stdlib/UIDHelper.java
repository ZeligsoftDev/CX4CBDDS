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

import org.eclipse.xtend.expression.Variable;

/**
 * Java helper class for Stdlib extension <tt>org::eclipse::xtend::util::stdlib::uid</tt>.
 *
 * @author Karsten Thoms - Bug#310361
 */
public class UIDHelper extends AbstractStatefulExtensions<String> {

	public String createNewUID( Object o ) {
		String id = ""+System.currentTimeMillis()+countUp();
		return id;
	}

	public String uid( Object o ) {
		String id = get(o);
		if ( id == null ) {
			id = createNewUID(o);
			set(o, id);
		}
		return id;
	}

	private String countUp() {
		final String key = getKey()+"_counter";
		Variable counterVar = exeCtx.getGlobalVariables().get(key);
		Integer counter;
		if (counterVar == null) {
			counter = 0;
			counterVar = new Variable(key, counter);
			exeCtx.getGlobalVariables().put(key, counterVar);
		} else {
			counter = (Integer) counterVar.getValue();
			counter++;
			if (counter == 10000) counter = 0;
			counterVar.setValue(counter);
		}
		return String.valueOf(counter);
	}

}
