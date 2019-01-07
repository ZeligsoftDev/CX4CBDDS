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
package com.zeligsoft.domain.omg.ccm.constraints.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class NoCyclicalPartsConstraint extends AbstractModelConstraint {

	private ArrayList<EObject> assemblies = null;
	
	private ResourceSet rset = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {
		
		EObject objToVerify = ctx.getTarget(); // Assembly that may contain a cycle.
		rset = objToVerify.eResource().getResourceSet();		
	
		EObject asmDef = (EObject)ZDLUtil.getValue(objToVerify, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
		if(asmDef == null){
			// we don't care if this assembly does not belong to any definition
			return null;
		}
	
		// For each part in the assembly, we will get its component and flatten all its assemblies to search for a part of the original assembly.
		// This indicates a cycle.
		// This code assumes we have not previously introduced a cycle (e.g. correct by construction). 
		for( EObject part : (List<EObject>)ZDLUtil.getValue(objToVerify, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__PART)) {
			EObject partDef = (EObject)ZDLUtil.getValue(part, ZMLMMNames.PART, ZMLMMNames.PART__DEFINITION);
			if((null != partDef) && containsComponentPart(partDef, asmDef)) {
				return ctx.createFailureStatus();
			}
		}
		
		assemblies = null;
		
		return null;
	}
	
	/**
	 * 
	 * @param componentToSearch	The component we are flattening for the purposes of the search.
	 * @param asmDef			The component that we are trying to find.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean containsComponentPart(EObject componentToSearch, EObject asmDef) {
		if( hasAssembly(componentToSearch) == false) {
			return false;
		}
		
		for( EObject assembly : getAssemblies()) {
			// Get each assembly for the component and search it.
			if( (EObject)ZDLUtil.getValue(assembly, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE) == componentToSearch) {
				for( EObject part : (List<EObject>)ZDLUtil.getValue(assembly, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__PART)) {
					// See if the part is asmDef, or if it has an assembly that contains asmDef.
					EObject partDef = (EObject)ZDLUtil.getValue(part, ZMLMMNames.PART, ZMLMMNames.PART__DEFINITION);
					if( partDef == asmDef ) {
						return true;
					} else {
						if( containsComponentPart(partDef, asmDef)) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private List<EObject> getAssemblies() {
		if( assemblies == null ) {
			assemblies = new ArrayList<EObject>();
			for (TreeIterator<?> iter = EcoreUtil.getAllContents(rset, true); iter.hasNext();) {
				Object next = iter.next();
				
				if( next instanceof Element ) {
					EObject eNext = (EObject)next;
					try {
					if( ZDLUtil.isZDLConcept(eNext, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
						assemblies.add(eNext);
					} }
					catch( Exception e ) {
						e.printStackTrace();
					}
				}
			}
		}
		return assemblies;
	}
	
	private boolean hasAssembly(EObject defn) {
		for( EObject eobj : getAssemblies() ) {
			if ((EObject)ZDLUtil.getValue(eobj, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE) == defn) {
				return true;
			}
		}
		return false;
	}

}
