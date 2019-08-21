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
package com.zeligsoft.cx.codegen.internal;

import org.eclipse.core.runtime.IProgressMonitor;


public class OawUtil
{
	public static void beginTask( IProgressMonitor progressMonitor, String taskName, Long totalWork )
	{
		progressMonitor.beginTask( taskName, totalWork.intValue() );
	}

	public static void subTask( IProgressMonitor progressMonitor, String taskName )
	{
		progressMonitor.subTask( taskName );
	}

	public static void worked( IProgressMonitor progressMonitor, Long work )
	{
		progressMonitor.worked( work.intValue() );
	}

	public static void done( IProgressMonitor progressMonitor )
	{
		progressMonitor.done();
	}
}
