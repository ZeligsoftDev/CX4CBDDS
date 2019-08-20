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
package com.zeligsoft.cx.codegen.ui.internal;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.internal.core.Workflow;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.Outlet;

import com.zeligsoft.base.util.WorkflowCallbacks;
import com.zeligsoft.cx.codegen.editor.IUserEditableElementDescriptor;
import com.zeligsoft.cx.codegen.io.CXGenOutlet;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;

@SuppressWarnings("restriction")
public class OpenNewEditors extends WorkflowCallbacks
{
	private final EObject element;
	private final IUserEditableElementDescriptor desc;
	private final MultiStatus status;

	public OpenNewEditors( EObject element, IUserEditableElementDescriptor desc, MultiStatus status )
	{
		super( OawUtil.createExternalSlots( element, desc ) );

		this.element = element;
		this.desc = desc;
		this.status = status;
	}

	private static URL m2mWorkflowUrl = null;
	private static URL m2tWorkflowUrl = null;

	@Override
	public URL getWorkflowUrl()
	{
		// two urls are supported, one for a workflow that contains both M2M and M2T stages,
		// and one for a workflow that has only a single M2T stage
		if( desc.getM2MDescriptors().iterator().hasNext() )
		{
			if( m2mWorkflowUrl == null )
				m2mWorkflowUrl
					= Platform
						.getBundle( CodeGenUIPlugin.PLUGIN_ID )
						.getEntry( CodeGenUIPlugin.EDITSOURCE_M2MWORKFLOW_RELPATH );
			return m2mWorkflowUrl;
		}

		if( m2tWorkflowUrl == null )
			m2tWorkflowUrl
				= Platform
					.getBundle( CodeGenUIPlugin.PLUGIN_ID )
					.getEntry( CodeGenUIPlugin.EDITSOURCE_M2TWORKFLOW_RELPATH );
		return m2tWorkflowUrl;
	}

	@Override
	public void postInvoke( Workflow workflow, Issues issues )
	{
		for( WorkflowComponent component : workflow.getComponents() )
		{
			if( ! ( component instanceof Generator ) )
				continue;

			for( Outlet outlet : ( (Generator)component ).getOutlets() )
			{
				if( ! ( outlet instanceof CXGenOutlet ) )
					continue;

				Iterable<IFile> files = ( (CXGenOutlet)outlet ).getFiles();
				OawUtil.openEditors( files, this.element, this.desc, this.status );
			}
		}
	}
}
