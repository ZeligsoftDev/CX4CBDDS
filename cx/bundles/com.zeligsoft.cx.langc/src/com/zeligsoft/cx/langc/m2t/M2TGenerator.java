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
package com.zeligsoft.cx.langc.m2t;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.editor.IEditorOpener;
import com.zeligsoft.cx.codegen.editor.IUserEditableElementDescriptor;
import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.BooleanOperator;
import com.zeligsoft.cx.langc.Element;
import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.FunctionPointer;
import com.zeligsoft.cx.langc.Name;
import com.zeligsoft.cx.langc.NamedReference;
import com.zeligsoft.cx.langc.Operator;
import com.zeligsoft.cx.langc.VariableDeclaration;
import com.zeligsoft.cx.langc.internal.LangCPlugin;
import com.zeligsoft.cx.langc.l10n.Messages;
import com.zeligsoft.cx.langc.util.LangCSwitch;
import com.zeligsoft.cx.langc.util.Partitioner;

public class M2TGenerator extends LangCSwitch<Boolean>{

	private M2TGenerator() { /* empty */ }

	/**
	 * Called from XPand.
	 */
	public static boolean generate( ElementList elementList, String destProjectName ) {
		IResource dest = ResourcesPlugin.getWorkspace().getRoot().findMember(destProjectName);
		if( dest == null )
			return false;

		IProject destProject = (IProject)dest.getAdapter(IProject.class);
		if( destProject == null )
			return false;

		CWriter writer = CWriter.createProvisional(destProject, elementList.getName());
		if( writer == null )
			return false;

		try
		{
			elementList.write(writer);
		}
		catch( NullPointerException e )
		{
			e.printStackTrace();
			writer.release();
			return false;
		}

		// If the definition's writer is still in provisional mode, then no content was
		// generated into the .c file.  Update the flag in the FileName so that the
		// sources.mk will contain an accurate list of buildable content.
		elementList.getName().setHasObjectCode( ! writer.defn().isProvisional() );

		writer.release();
		return true;
	}

	private static final String EDITOROPENER_HANDLER_TAG = "handler"; //$NON-NLS-1$
	private static final String EDITOROPENER_ID_ATTR = "id"; //$NON-NLS-1$
	private static final String EDITOROPENER_CLASS_ATTR = "class"; //$NON-NLS-1$

	private static final List<IEditorOpener> editorOpeners = new LinkedList<IEditorOpener>();
	static
	{
		IExtension[] extensions
			= Platform.getExtensionRegistry()
				.getExtensionPoint( CodeGenPlugin.ID, CodeGenPlugin.EDITOROPENER_EP_ID )
				.getExtensions();

		for( IExtension extension : extensions )
			for( IConfigurationElement configElement : extension.getConfigurationElements() )
				if( EDITOROPENER_HANDLER_TAG.equals( configElement.getName() ) )
				{
					String id = configElement.getAttribute( EDITOROPENER_ID_ATTR );
					if( id == null
					 || id.isEmpty() )
					{
						LangCPlugin.getDefault().error( Messages.M2TGenerator_EditorOpener_MissingIdAttr, null );
						id = "MissingId"; //$NON-NLS-1$
					}

					Object handlerObj = null;
					try { handlerObj = configElement.createExecutableExtension( EDITOROPENER_CLASS_ATTR ); }
					catch( CoreException e )
					{
						LangCPlugin.getDefault().error(
							NLS.bind( Messages.M2TGenerator_EditorOpener_BadClassAttr, id ),
							e );
						continue;
					}

					if( handlerObj == null
					 || ( ! ( handlerObj instanceof IEditorOpener ) ) )
					{
						LangCPlugin.getDefault().error(
								NLS.bind( Messages.M2TGenerator_EditorOpener_BadClassAttr, id ),
								null );
						continue;
					}

					editorOpeners.add( (IEditorOpener)handlerObj );
				}
	}

	public static boolean openEditors( ElementList elementList, String destProjectName, Object element, Object descObj )
	{
		if( ! ( descObj instanceof IUserEditableElementDescriptor ) )
			return false;

		Name name = elementList.getName();
		String header = destProjectName + '/' + Partitioner.headerPathname( name );
		String impl = destProjectName + '/' + Partitioner.implPathname( name );
		IUserEditableElementDescriptor desc = (IUserEditableElementDescriptor)descObj;

		boolean rc = true;
		for( IEditorOpener editorOpener : editorOpeners )
		{
			if( ! editorOpener.open( header, element, desc ) )
				rc = false;
			if( ! editorOpener.open( impl, element, desc ) )
				rc = false;
		}
		return rc;
	}

	public static boolean write( CodeWriter code, Operator op ) {
		switch(op) {
		case ADD: return code.write('+');
		case ASSIGN: return code.write('=');
		case BITWISE_AND: return code.write('&');
		case BITWISE_OR: return code.write('|');
		case SUBTRACT: return code.write('-');
		case ASSIGN_ADD: return code.write("+="); //$NON-NLS-1$
		default: return false;
		}
	}

	public static boolean write( CodeWriter code, BooleanOperator op ) {
		switch(op) {
		case LESS_THAN: return code.write('<');
		case GREATER_THAN: return code.write('>');
		case LESS_THAN_EQUAL: return code.write("<="); //$NON-NLS-1$
		case GREATER_THAN_EQUAL: return code.write(">="); //$NON-NLS-1$
		case EQUIVALENT: return code.write("=="); //$NON-NLS-1$
		case NOT_EQUIVALENT: return code.write("!="); //$NON-NLS-1$
		default: return false;
		}
	}

	public static boolean needsParens( Expression expr, int neighbouringPrecendence ) {
		return expr.getPrecendence() < neighbouringPrecendence;
	}

	public static boolean isIndirect( ElementReference ref ) {
		if( ref == null )
			return false;

		return ref.getPointerSpec().size() > 0
			|| isIndirect( ref.getElement() );
	}

	public static boolean isIndirect( Element element ) {

		if( element instanceof FunctionPointer )
			return true;
		else if( element instanceof VariableDeclaration )
			return isIndirect( ( (VariableDeclaration)element ).getElement() );
		else
			return false;
	}

	public static boolean isIndirect( NamedReference ref ) {
		return isIndirect(ref.getType());
	}

	public static boolean isIndirect( Expression expr ) {
		return isIndirect(expr.getType());
	}
}
