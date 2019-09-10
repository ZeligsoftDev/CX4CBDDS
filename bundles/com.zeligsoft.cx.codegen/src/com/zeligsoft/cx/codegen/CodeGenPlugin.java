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
package com.zeligsoft.cx.codegen;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;
import com.zeligsoft.cx.codegen.internal.rsm.EObjectLocator;


public class CodeGenPlugin extends ZeligsoftAbstractPlugin
{
	public static final String ID = "com.zeligsoft.cx.codegen";//$NON-NLS-1$
	public static final String CODESTREAMOBSERVER_EP_ID = "codestreamobserver"; //$NON-NLS-1$
	public static final String EOBJECTLOCATOR_EP_ID = "eobjectlocator"; //$NON-NLS-1$
	public static final String EDITOROPENER_EP_ID = "editoropener"; //$NON-NLS-1$

	// The shared instance.
	private static CodeGenPlugin plugin;

	private final EObjectLocator eobjectLocator = new EObjectLocator();

	/**
	 * The constructor.
	 */
	public CodeGenPlugin()
	{
		plugin = this;
	}

	/**
	 * Returns the shared instance.
	 */
	public static CodeGenPlugin getDefault()
	{
		return plugin;
	}

	/**
	 * Return an instance of the EObject corresponding to the argument URI.  Returns null
	 * if the EObject cannot be found.
	 */
	public EObject getEObject( URI uri )
	{
		return this.eobjectLocator.getEObject( uri );
	}

	@Override
	public void start( BundleContext context ) throws Exception
	{
		super.start(context);
		//this.eobjectLocator.load();
	}

	@Override
	public void stop( BundleContext context ) throws Exception
	{
		//this.eobjectLocator.dispose();
		super.stop(context);
	}
}
