/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.internal.xtend.xtend.parser;

import java.io.File;


/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class GeneratorLauncher {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String currentRoot = new File("").getAbsolutePath();
		String pack = "org/eclipse/internal/xtend/xtend/parser";
		String outputFullPath = currentRoot + "/src/" + pack;
		String grammarFullPath = GeneratorLauncher.class.getClassLoader().getResource(pack + "/Xtend.g").getFile();
//		org.antlr.Tool antlr = new org.antlr.Tool(new String[] { "-report", "-o", outputFullPath, grammarFullPath });
//		antlr.process();
	}

}
