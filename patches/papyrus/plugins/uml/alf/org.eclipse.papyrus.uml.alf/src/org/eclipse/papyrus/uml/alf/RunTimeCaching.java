/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Ed Seidewitz
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import java.util.ArrayList;

import org.eclipse.papyrus.uml.alf.impl.SyntaxElementImpl;

public class RunTimeCaching {

	public static final RunTimeCaching INSTANCE = new RunTimeCaching();

	public static void register(SyntaxElementImpl element) {
		INSTANCE.add(element);
	}

	public static void clearAll() {
		INSTANCE.clear();
	}

	private ArrayList<SyntaxElementImpl> registry = new ArrayList<SyntaxElementImpl>();

	private RunTimeCaching() {
	}

	public void add(SyntaxElementImpl element) {
		if(element!=null){
			this.registry.add(element);
		}
	}

	public void clear() {
		for (SyntaxElementImpl element : registry) {
			// System.out.println("[clear] " + element.getId());
			element.clear();
		}
		// Reallocate registry to avoid memory leaks.
		this.registry = new ArrayList<SyntaxElementImpl>();
	}

}
