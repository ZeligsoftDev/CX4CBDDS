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
package com.zeligsoft.domain.omg.ccm.idlimport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.idlimport.IDLReaderComponent;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class IDL3ReaderComponent extends IDLReaderComponent {
	
	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		if( issues.getErrors().length > 0) {
			return;
		}
		
		addImportedPackage(issues, (Package)ctx.get(getModelSlot()));

	}
	
	/**
	 * @return does not return null
	 */
	@Override
	protected Map<Element, Element> getMergeModels( Package importedPackage )
	{
		Map<Element, Element> mergeModels = new LinkedHashMap<Element, Element>();
		if( getMerger() == null )
			return mergeModels;

		EList<EObject> contents = importedPackage.eResource().getContents();
		List<PackageableElement> mergeableElements = getImportedMergeableElements(importedPackage);
		for( PackageableElement pe : mergeableElements) {
			if( ZDLUtil.isZDLConcept(pe, CORBADomainNames.CORBANAMED_ELEMENT)) {

				String importedRepositoryId = CORBAUtil.getRepositoryId(pe);
				
				for (TreeIterator<?> iter = EcoreUtil.getAllContents(contents); iter.hasNext();) {

					Object next = iter.next();
					
					if( next instanceof NamedElement ) {
						if( ZDLUtil.isZDLConcept((NamedElement)next, CORBADomainNames.CORBANAMED_ELEMENT)) {
							if( !ZDLUtil.isZDLConcept((NamedElement)next, CORBADomainNames.CORBAMODULE)) {
								if( importedRepositoryId.matches(CORBAUtil.getRepositoryId((NamedElement)next))) {
									if( mergeableElements.contains(next) == false ) {
										mergeModels.put(pe, (Element)next);
										iter.prune();
									}								
								}								
							}
						}
					}
				}
			} else if( ZDLUtil.isZDLConcept(pe, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
				
				NamedElement importedComponent = (NamedElement)(ZDLUtil.getValue(pe, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE));
				String importedKey = CORBAUtil.getRepositoryId(importedComponent) + "::" + ZDLUtil.getValue(pe, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME); //$NON-NLS-1$
				
				for (TreeIterator<EObject> iter = EcoreUtil.getAllContents(contents); iter.hasNext();) {

					EObject next = iter.next();
					
					if( next instanceof Component ) {
						if( ZDLUtil.isZDLConcept((NamedElement)next, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
							NamedElement component = (NamedElement)(ZDLUtil.getValue(next, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE));
							String modelKey = CORBAUtil.getRepositoryId(component) + "::" + ZDLUtil.getValue(pe, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME); //$NON-NLS-1$
							if( modelKey.equals(importedKey)) {
								if( mergeableElements.contains(next) == false ) {
									mergeModels.put(pe, (Element)next);
									iter.prune();
								}
							}
						}
					}
				}
				
			}
		}

		return mergeModels;
	}

	
	private List<PackageableElement> getImportedMergeableElements(Package pkg) {
		ArrayList<PackageableElement> retVal = new ArrayList<PackageableElement>();
		
		for (TreeIterator<?> iter = EcoreUtil.getAllContents(pkg.getPackagedElements()); iter.hasNext();) {
			
			Object next = iter.next();
			
			if( next instanceof PackageableElement ) {
				if( ZDLUtil.isZDLConcept((PackageableElement)next, CORBADomainNames.CORBANAMED_ELEMENT)
					|| ZDLUtil.isZDLConcept((PackageableElement)next, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
					if( !ZDLUtil.isZDLConcept((PackageableElement)next, CORBADomainNames.CORBAMODULE)) {
						retVal.add((PackageableElement)next);
						iter.prune();						
					}
				}
			}
		}
		
		return retVal;
	}

}
