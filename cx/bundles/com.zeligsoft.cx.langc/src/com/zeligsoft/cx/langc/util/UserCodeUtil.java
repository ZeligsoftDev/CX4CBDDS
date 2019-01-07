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
package com.zeligsoft.cx.langc.util;

@SuppressWarnings("unused")
public class UserCodeUtil {

	private static final String UserDepTag = "User Dependencies"; //$NON-NLS-1$
	private static final String UserCodeTag = "User Code"; //$NON-NLS-1$

	private static String beginRegion( String label )
	{
		return "/* BEGIN: " + label + " */"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	private static String endRegion( String label )
	{
		return "/* END: " + label + " */"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	private UserCodeUtil() { /* empty */ }

	public static String workerFunctionFile( String userDeps, String functionBody )
	{
		return "worker file"; //$NON-NLS-1$
	}
}
