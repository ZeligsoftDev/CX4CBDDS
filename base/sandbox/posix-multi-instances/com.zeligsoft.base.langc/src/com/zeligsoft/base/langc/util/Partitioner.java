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
package com.zeligsoft.base.langc.util;

import com.zeligsoft.base.langc.FolderName;
import com.zeligsoft.base.langc.Name;

public class Partitioner {

	private static final String HEADER_EXT = ".h"; //$NON-NLS-1$
	private static final String CIMPL_EXT = ".c"; //$NON-NLS-1$

	public static boolean isDebugEnabled() {
		return true;
	}

	public static void inspect( Long condition, Object obj) {
		System.out.println( "[" + condition + "] inspecting " + obj );  //$NON-NLS-1$//$NON-NLS-2$
	}

	public static Object debug(Object ret, String msg) {
		System.out.println(msg);
		return ret;
	}

	public static String includePath( Name name )
	{
		return includePathname( name ) + HEADER_EXT;
	}

	private static String includePathname( Name name )
	{
		Name parent = name.getParent();
		if( parent == null )
			return name.getName();

		if( parent instanceof FolderName
		 && ( (FolderName)parent ).isApi() )
			return name.getName();

		return includePathname( parent ) + '/' + name.getName();
	}

	private static String fullPathname( Name name )
	{
		Name parent = name.getParent();
		return
			parent == null
				? name.getName()
				: fullPathname( parent ) + '/' + name.getName();
	}

	public static String headerPathname( Name name )
	{
		return fullPathname( name ) + HEADER_EXT;
	}

	public static String implPathname( Name name )
	{
		return fullPathname( name ) + CIMPL_EXT;
	}
}
