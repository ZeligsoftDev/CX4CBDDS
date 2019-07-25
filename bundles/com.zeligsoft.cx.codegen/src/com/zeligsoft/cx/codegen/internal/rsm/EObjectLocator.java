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
package com.zeligsoft.cx.codegen.internal.rsm;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.l10n.Messages;
import com.zeligsoft.cx.codegen.rsm.IEObjectLocator;

public class EObjectLocator
{
	private final Map<String, IEObjectLocator> locators = new TreeMap<String, IEObjectLocator>();

	private static final String EOBJECTLOCATOR_ELEMENT = "eobjectlocator";
	private static final String ID_ATTR = "id";
	private static final String CLASS_ATTR = "class";

	public EObject getEObject( URI uri )
	{
		for( IEObjectLocator locator : this.locators.values() )
		{
			EObject eobject = locator.getEObject( uri );
			if( eobject != null )
				return eobject;
		}

		return null;
	}

	public void dispose()
	{
		this.locators.clear();
	}

	public void load()
	{
		IExtension[] extensions
			= Platform.getExtensionRegistry()
				.getExtensionPoint( CodeGenPlugin.ID, CodeGenPlugin.EOBJECTLOCATOR_EP_ID )
				.getExtensions();

		for( IExtension extension : extensions )
			for( IConfigurationElement configElement : extension.getConfigurationElements() )
				if( EOBJECTLOCATOR_ELEMENT.equals( configElement.getName() ) )
				{
					String id = configElement.getAttribute( ID_ATTR );
					if( id == null )
					{
						CodeGenPlugin.getDefault().error(
								NLS.bind( Messages.EObjectLocator_MissingAttribute, ID_ATTR ),
								null );
						continue;
					}

					Object locatorObj = null;
					try { locatorObj = configElement.createExecutableExtension( CLASS_ATTR ); }
					catch( CoreException e )
					{
						CodeGenPlugin.getDefault().error(
								NLS.bind( Messages.EObjectLocator_BadAttribute, CLASS_ATTR ),
								e );
					}
					if( locatorObj == null )
					{
						CodeGenPlugin.getDefault().error(
							NLS.bind( Messages.EObjectLocator_MissingAttribute, CLASS_ATTR ),
							null );
						continue;
					}

					if( ! ( locatorObj instanceof IEObjectLocator ) )
					{
						CodeGenPlugin.getDefault().error(
								NLS.bind( Messages.EObjectLocator_BadAttribute, CLASS_ATTR ),
								null );
							continue;
					}

					this.locators.put( id, (IEObjectLocator)locatorObj );
				}
	}
}
