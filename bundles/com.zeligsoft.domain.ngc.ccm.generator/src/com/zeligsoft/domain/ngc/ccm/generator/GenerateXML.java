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
package com.zeligsoft.domain.ngc.ccm.generator;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.codegen.CodeTagGeneratorUtil;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMGenerationUtils;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.Module;
import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;

/**
 * Workflow component to generate XML for component IDL files that have changed.
 * 
 * @author smcfee
 *
 */
public class GenerateXML extends WorkflowComponentWithModelSlot {
	
	private String targetDir;
	private String pathnameSlot;
	
	/**
	 * The directory as a URI that the file will be written into.
	 * @param value
	 */
	public void setTargetDir(String value) {
		this.targetDir = value;
	}
	
	/**
	 * 
	 * @return The directory that the file will be written into
	 */
	public String getTargetDir() {
		return targetDir;
	}
	
	/**
	 * Pathnames of generated files will be written into.
	 * 
	 * @param value
	 */
	public void setPathnameSlot(String value) {
		this.pathnameSlot = value;
	}

	/**
	 * @return Pathnames of generated files will be written into.
	 */
	public String getPathnameSlot() {
		return pathnameSlot;
	}
	
	/* (non-Javadoc)
	 */
	@SuppressWarnings({"unchecked", "nls"})
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		Object generated = ctx.get(getModelSlot());
		
		// Store generated filenames to the pathnames list
		Map<String, Set<String>> pathnames = (Map<String, Set<String>>)ctx.get(getPathnameSlot());
		
		List<Object> generatedList;
		
		if(IdlPackage.Literals.SPECIFICATION.isInstance(generated)) {
			generatedList = Collections.singletonList(generated);
		} else if (generated instanceof List) {
			generatedList = (List<Object>) generated;
		} else {
			throw new IllegalArgumentException("Unknown type of element: " + 
					generated.getClass().getName());
		}
		
		for(Object obj : generatedList) {
			if (IdlPackage.Literals.SPECIFICATION.isInstance(obj)) {
				Specification model = (Specification) obj;
				if( hasGeneratedIDLFile(model) ) {
					String path = AnnotationUtil.getZCXAnnotationDetail(model, AnnotationUtil.FILENAME_KEY);
					ComponentDecl generatedComponent = getComponent(model);
					String repId = getIDLModelElementRepositoryId(generatedComponent);
					
					Object element = ctx.get("element");
					EObject originalComponent = null;
					String dirPath = UML2Util.EMPTY_STRING;
					int offset = path.lastIndexOf(File.separator);
					if (offset > 0) {
						dirPath = path.substring(0, offset + 1);
					}
					for( TreeIterator<EObject> iter = ((Element)element).eResource().getAllContents(); iter.hasNext(); ) {
						EObject next = iter.next();
						if( next instanceof Component && ZDLUtil.isZDLConcept(next, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
							if (repId
									.equals(elementKey((NamedElement) next))
									&& (UML2Util.isEmpty(dirPath) || dirPath
											.equals(DDS4CCMGenerationUtils
													.path((NamedElement) next)))) {
								originalComponent = next;
								break;
							}
						}
					}
					if (originalComponent != null) {
						String filename = UML2Util.EMPTY_STRING;
						if (!UML2Util.isEmpty(dirPath)) {
							filename = "/" + dirPath;
						}
						
						String result = CodeTagGeneratorUtil.generateXML2(
								originalComponent, filename);
						if (result != null) {
							pathnames.get("modified").add(result);
						}
					}
				}
			}
		}
		
	}
	
	@SuppressWarnings("nls")
	private String getIDLModelElementRepositoryId(ComponentDecl comp) {
		String retVal = comp.getName() + ":1.0";
		
		EObject obj = comp.eContainer();
		while( obj != null ) {
			if( obj instanceof Module) {
				retVal = ((Module)obj).getName() + "/" + retVal;
			}
			obj = obj.eContainer();
		}
		retVal = "IDL:" + retVal;
		
		return retVal;
	}

	private String elementKey( NamedElement intf ) {
		
		if( ZDLUtil.isZDLConcept(intf, CCMNames.MONOLITHIC_IMPLEMENTATION) == false ) {
			throw new IllegalArgumentException("Method is only to be called on a Monolithic Implementation.");
		}
		
		String repositoryId = "";
		NamedElement namedElement = intf;

		while( namedElement != null ) {
			if( ZDLUtil.isZDLConcept(namedElement, CORBADomainNames.CORBANAMED_ELEMENT)
					|| ZDLUtil.isZDLConcept(namedElement, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
				if( repositoryId.matches("") == false) {
					repositoryId = "/" + repositoryId;
				}
				repositoryId = namedElement.getName() + repositoryId;
				namedElement = (NamedElement)namedElement.getOwner();	
			} else if( namedElement instanceof org.eclipse.uml2.uml.Package ) {
				// A UML package should be skipped since its container could still be a CORBA Element.
				namedElement = (NamedElement)namedElement.getOwner();
			} else {
				// Any other object means we are done calculating the repository ID.
				namedElement = null;
			}
		}
		
		repositoryId = "IDL:" + repositoryId;
		return repositoryId + ":1.0";
	}
	
	private boolean hasGeneratedIDLFile(Specification model) {
		String filetype = AnnotationUtil.getZCXAnnotationDetail(model, AnnotationUtil.FILETYPE_KEY);
		
		String path = AnnotationUtil.getZCXAnnotationDetail(model,
				AnnotationUtil.FILENAME_KEY);
		
		if( AnnotationUtil.PACKAGE_FILETYPE.equals(filetype) == false && path != null && getComponent(model) != null) {
			
			File file = new File(getTargetDir(), path.concat(".idl"));
			if( file.exists()) {
				return true;
			} 
		}
		return false;
	}
	
	private ComponentDecl getComponent(Specification model) {
		ComponentDecl generatedComponent = null;
		for( TreeIterator<EObject> iter = model.eAllContents(); iter.hasNext();) {
			EObject next = iter.next();
			if( next instanceof ComponentDecl ) {
				generatedComponent = (ComponentDecl)next;
			}
		}
		return generatedComponent;
	}
}
