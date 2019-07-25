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
package com.zeligsoft.domain.omg.corba.idlimport;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.util.ModelMerger;
import com.zeligsoft.base.workflow.RSMWriter;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * @author Sean McFee
 * 
 * IDL workflow component that adds an imported package into an existing resource, performing a 
 * merge if necessary.
 */
public class IDLReaderComponent extends RSMWriter {
		
	/**
	 * The concrete model-merger class that we will use.
	 */
	private ModelMerger<EObject, ?> merger = null;

	@Override
	protected void doInvoke( WorkflowContext ctx, ProgressMonitor monitor, Issues issues )
	{
		if( issues.getErrors().length > 0 )
			return;

		addImportedPackage( issues, (Package)ctx.get( getModelSlot() ) );
		
	}

	protected void addImportedPackage( Issues issues, Package importedPackage ) 
	{

		addStereotypeApplications(importedPackage.eResource(), importedPackage);
		
		Map<Element, Element> mergeModels = getMergeModels( importedPackage );
		if( ! mergeModels.isEmpty() )
		{
			List<EObject> sources = new ArrayList<EObject>();
			List<EObject> targets = new ArrayList<EObject>();
			for( Element p : mergeModels.keySet() )
			{
				sources.add( p );
				targets.add( mergeModels.get( p ) );
			}
			merger.merge( sources, targets );
			for( Element p : mergeModels.keySet() )
				p.destroy();
			if( importedPackage.getPackagedElements().size() == 0 )
				importedPackage.destroy();
		}

	}

	/**
	 * @return does not return null
	 */
	protected Map<Element, Element> getMergeModels( Package importedPackage )
	{
		Map<Element, Element> mergeModels = new LinkedHashMap<Element, Element>();
		if( merger == null )
			return mergeModels;

		EList<EObject> contents = importedPackage.eResource().getContents();
		for( PackageableElement pe : importedPackage.getPackagedElements())
		{
			if( ! ZDLUtil.isZDLConcept( pe, CORBADomainNames.IDLFILE ) )
				continue;

			String importedIdlFileName = pe.getName();
			if( importedIdlFileName != null ) {				
				for (TreeIterator<?> iter = EcoreUtil.getAllContents(contents); iter.hasNext();) {

					Object next = iter.next();
					if( next instanceof NamedElement ) {
						if( ZDLUtil.isZDLConcept((NamedElement)next, CORBADomainNames.IDLFILE)) {
							if( importedIdlFileName.matches(((NamedElement)next).getName())) {
								if( ((PackageableElement)next).getOwner() != importedPackage ) {
									mergeModels.put((Package)pe, (Package)next);
								}								
							}
						}
					}
				}
			}
		}

		return mergeModels;
	}

	/**
	 * Obtains my model merger class name.
	 * 
	 * @return my model merger class name
	 */
	public String getMerger() {
		return merger == null ? null : merger.getClass().getName();
	}

	/**
	 * Sets my model merger class name.
	 * 
	 * @param className my model merger class name
	 */
	public void setMerger( String className ) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		if( className == null )
			merger = null;
		else
		{
			String bundleName = className;
			Bundle bundle = Platform.getBundle(bundleName);
			while( bundle == null ) {
				bundleName = bundleName.substring(0, bundleName.lastIndexOf(".")); //$NON-NLS-1$
				bundle = Platform.getBundle(bundleName);
			}
						
			@SuppressWarnings("unchecked")
			Class<ModelMerger<EObject, ?>> mergerClass = (Class<ModelMerger<EObject, ?>>) bundle.loadClass(className);
			merger = mergerClass.newInstance();
		}
	}
}
