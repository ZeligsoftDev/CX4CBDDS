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
package com.zeligsoft.cx.codegen.ui.utils;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.service.IBatchValidator;

import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.cx.codegen.editor.IUserEditableElementDescriptor;
import com.zeligsoft.cx.codegen.editor.IValidationFactory;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.internal.OawUtil;
import com.zeligsoft.cx.codegen.ui.internal.OpenNewEditors;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;

public class EditSourceJob extends Job {

	private final EObject selectedElement;
	private final IUserEditableElementDescriptor desc;

	public EditSourceJob( EObject selectedElement, IUserEditableElementDescriptor desc )
	{
		super( Messages.EditSourceAction_Message );
		setUser( true );

		this.selectedElement = selectedElement;
		this.desc = desc;
	}

	@Override
	protected IStatus run( IProgressMonitor monitor )
	{
		final MultiStatus rc
			= new MultiStatus( CodeGenUIPlugin.PLUGIN_ID, 0, Messages.EditSourceAction_MultiStatus_Message, null );

		IValidationFactory validationFactory = desc.getValidationFactory();
		if( validationFactory != null )
		{
			IBatchValidator validator = validationFactory.createValidator();
			rc.add( validator.validate( this.selectedElement, monitor ) );

			// With the following uncommented, the 'Open Editor' operation will bail out before
			// generating source when the element is found to be invalid.  This could cause
			// exceptions during generation.  However, the user could be trying to edit the
			// source before the model has been completed.  I'm not sure what the right answer
			// is, for now I've let the process continue since its less annoying.  The result
			// has already been added to the final return value, so the errors will be reported
			// to the user after the entire operation has completed.
//			if( ! rc.isOK() )
//				return rc;
		}

		Map<String, String> genProperties = OawUtil.createGenProperties( selectedElement );
		if( ! OawUtil.applyWorkflowProperties( genProperties, desc ) )
		{
			CodeGenUIPlugin.getDefault().error( Messages.EditSourceAction_CannotGenerate, null );
			rc.add( new Status( IStatus.ERROR, CodeGenUIPlugin.PLUGIN_ID, Messages.EditSourceAction_CannotGenerate ) );
			return rc;
		}

		String lang = this.desc.getLabel();
		int mode = ProjectFactory.MODE_CREATE_BASIC;
		
		if(lang.equals("C++") || lang.equals("Edit Header Extras") || lang.equals("Edit Implementation Extras")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			mode = ProjectFactory.MODE_CREATE_CPP;
		}
		else if (lang.equals("C")) { //$NON-NLS-1$
			mode = ProjectFactory.MODE_CREATE_C;
		}
		
		IProject project = OawUtil.applyProjectProperties( genProperties, selectedElement, monitor, mode );
		if( project == null )
		{
			rc.add( new Status( IStatus.ERROR, CodeGenUIPlugin.PLUGIN_ID, Messages.EditSourceAction_CannotCreateProject ) );
			return rc;
		}

		OpenNewEditors callbacks = new OpenNewEditors( selectedElement, desc, rc );
		rc.add( OawUtil.createFilesIn( project, genProperties, monitor, callbacks ) );
		return rc;
	}
}
