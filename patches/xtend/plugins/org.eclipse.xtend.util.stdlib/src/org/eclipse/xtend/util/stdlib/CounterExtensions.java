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
 * A Counter (integer) associated to any object.
 */
public class CounterExtensions extends AbstractStatefulExtensions<Integer> {

	/**
	 * resets the counter to '0'.
	 * 
	 * @param o The context object for this counter.  
	 * @return 0 
	 */
	public int counterReset(Object o) {
		return counterSet(o,0);
	}

	/**
	 * Increments the counter.
	 * 
	 * @param o The context object for this counter.  
	 * @return the incremented counter. 
	 */
	public int counterInc(Object o) {
		return counterSet(o,counterGet(o)+1);
	}

	/**
	 * Decrements the counter
	 * 
	 * @param o - context object  
	 * @return the decremented counter. 
	 */
	public int counterDec(Object o) {
		return counterSet(o,counterGet(o)-1);
	}
	
	/**
	 * Sets the counter
	 * 
	 * @param o - context object 
	 * @param value - the counter value to be set
	 */
	public int counterSet(Object o, int value) {
		set(o, value);
		return value;
	}

	/**
	 * Returns the counter. 
	 * 
	 * @param o - context object 
	 */
	public int counterGet(Object o) {
		return get(o);
	}
	
	@Override
	protected Integer getDefault(Object o) {
		return 0;
	}


}
