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

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.cx.codegen.UserEditableRegion;
import com.zeligsoft.cx.codegen.editor.IEditorOpener;
import com.zeligsoft.cx.codegen.editor.IUserEditableElementDescriptor;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;

public class UserEditableEditorOpener implements IEditorOpener
{
	@Override
	public boolean open( String filename, Object element, IUserEditableElementDescriptor desc )
	{
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember( filename );
		IFile file = resource == null ? null : (IFile)resource.getAdapter( IFile.class );
		if( file == null )
			return false;

		// Only open files that have user editable content.
		try
		{
			if( ! UserEditableRegion.containsUserEditableRegions( file.getContents() ) )
				return true;
		}
		catch( CoreException e ) { /* empty */ }

		MultiStatus rc
			= new MultiStatus(
					CodeGenUIPlugin.PLUGIN_ID, IStatus.INFO,
					NLS.bind( Messages.EObjectEditorOpener_OpeningFile, file.getName() ),
					null );
		OawUtil.openEditors( Collections.singletonList( file ), (EObject)element, desc, rc );
		return rc.isOK();
	}
}
