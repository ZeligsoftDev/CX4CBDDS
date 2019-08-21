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

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.io.CodeStream;
import com.zeligsoft.cx.codegen.l10n.Messages;

public class CodeStreamObserverRegistry
{
	private static Map<String, CodeStream.IObserver> observers = new LinkedHashMap<String, CodeStream.IObserver>();

	private static final String OBSERVER_ELEMENT = "observer";
	private static final String ID_ATTR = "id";
	private static final String CLASS_ATTR = "class";

	static
	{
		IExtension[] extensions
			= Platform.getExtensionRegistry()
				.getExtensionPoint( CodeGenPlugin.ID, CodeGenPlugin.CODESTREAMOBSERVER_EP_ID )
				.getExtensions();
	
		for( IExtension extension : extensions )
			for( IConfigurationElement configElement : extension.getConfigurationElements() )
				if( OBSERVER_ELEMENT.equals( configElement.getName() ) )
				{
					String id = configElement.getAttribute( ID_ATTR );
					if( id == null )
					{
						CodeGenPlugin.getDefault().error(
								NLS.bind( Messages.EObjectLocator_MissingAttribute, ID_ATTR ),
								null );
						continue;
					}
	
					Object observerObj = null;
					try { observerObj = configElement.createExecutableExtension( CLASS_ATTR ); }
					catch( CoreException e )
					{
						CodeGenPlugin.getDefault().error(
								NLS.bind( Messages.EObjectLocator_BadAttribute, CLASS_ATTR ),
								e );
					}
					if( observerObj == null )
					{
						CodeGenPlugin.getDefault().error(
							NLS.bind( Messages.EObjectLocator_MissingAttribute, CLASS_ATTR ),
							null );
						continue;
					}
	
					if( ! ( observerObj instanceof CodeStream.IObserver ) )
					{
						CodeGenPlugin.getDefault().error(
								NLS.bind( Messages.EObjectLocator_BadAttribute, CLASS_ATTR ),
								null );
							continue;
					}
	
					observers.put( id, (CodeStream.IObserver)observerObj );
				}
	}

	public static void preModifyFile( String pathname )
	{
		for( CodeStream.IObserver o : observers.values() )
			o.preModifyFile( pathname );
	}

	public static void modifiedFileClosed( String pathname )
	{
		for( CodeStream.IObserver o : observers.values() )
			o.modifiedFileClosed( pathname );
	}

	public static void newFileCreated( String pathname )
	{
		for( CodeStream.IObserver o : observers.values() )
			o.newFileCreated( pathname );
	}
}
