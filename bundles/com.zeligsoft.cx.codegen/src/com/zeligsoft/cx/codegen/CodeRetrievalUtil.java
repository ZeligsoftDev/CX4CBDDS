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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.codegen.io.CXGenFileStore;
import com.zeligsoft.domain.zml.util.WorkerFunctionUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Utility to retrieve code from a model and add files to the cxgen file system.
 * 
 * @author smcfee
 *
 */
public class CodeRetrievalUtil {
	
	/**
	 * Add a file to the cxgen file system.
	 * 
	 * @param filename
	 * 		Filename to add, should be a URI within the workspace.
	 * @param projectName
	 * 		Name of the project containing the file.
	 */
	public static void addFileToListenerSet(String filename, String projectName) {
		
		// It is probably possible to automagically figure out the project for a
		// given URI, but we won't do it yet.
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);

		if (!project.exists()) {
			CodeGenPlugin.getDefault().error(
					"Project does not exist: " + projectName, null);
		}

		IPath projectRelPath = new Path(filename);
		IFile link = project.getFile(projectRelPath);
		IPath path = link.getLocation();

		try {
			link.createLink(CXGenFileStore.createUri(path),
					IResource.ALLOW_MISSING_LOCAL | IResource.REPLACE, null);
			link.getParent().refreshLocal(IResource.DEPTH_ONE, null);
		} catch (CoreException e) {
			CodeGenPlugin.getDefault().error("Failed to create link.", e);
		}
	}
	
	/**
	 * Remove a file from the cxgen file system.
	 * 
	 * @param filename
	 * 		Filename to remove, should be a URI within the workspace.
	 * @param projectName
	 * 		Name of the project containing the file.
	 */
	public static void removeFileFromListenerSet(String filename, String projectName) {
		
		// It is probably possible to automagically figure out the project for a
		// given URI, but we won't do it yet.
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);
		
		if (!project.exists()) {
			CodeGenPlugin.getDefault().error(
					"Project does not exist: " + projectName, null);
		}

		IPath projectRelPath = new Path(filename);
		IFile link = project.getFile(projectRelPath);
		
		try {
			link.delete(0, null); // deleting a linked resource doesn't delete the actual file.
			link.getParent().refreshLocal(IResource.DEPTH_ONE, null);
		} catch (CoreException e) {
			CodeGenPlugin.getDefault().error("Failed to remove link.", e);
		}
	}
	
	/**
	 * 
	 * 	Retrieve code from a model.
	 * 
	 * @param modelURI
	 * 		The URI of the model. Would generally be local within the workspace (e.g. "/MyProject/MyModel.emx").
	 * 		Platform and file scheme URIs should work too but the client is responsible for passing them
	 *  	in correctly.
	 * @param modelElementQName
	 * 		The qualified name of the model element (structural realization) we are getting code for.
	 * @param operationName
	 * 		The name of the operation on the model element we are getting code for.
	 * @param language
	 * 		The language of implementation.
	 * @return
	 * 		A string containing the user-begin and user-end tags with any user-code in between.
	 */
	@SuppressWarnings("unchecked")
	public static String retrieveCode(String modelURI, String modelElementQName, String operationName, String language) {
		
		StringBuilder retVal = new StringBuilder();
		
		EObject model = getModel(modelURI);
		if( model == null) {
			CodeGenPlugin.getDefault().error("Model loaded was null for " + modelURI, null);
		}
		EObject structuralRealization = findStructuralRealization(model, modelElementQName);
		if( structuralRealization == null) {
			CodeGenPlugin.getDefault().error("Could not find model element " + modelElementQName, null);
		}

		EObject operation = null;
		for( EObject op : (List<EObject>)ZDLUtil.getValue(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__WORKER)) {
			if( operationName.equals(ZDLUtil.getValue(op, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME))) {
				operation = op;
			}
		}
		if( operation == null ) {
			CodeGenPlugin.getDefault().error("Could not find operation " + operationName, null);
		}
		retVal.append(retrieveCode(operation, structuralRealization, language));
		
		return retVal.toString();
	}
	
	public static String retrieveCode(EObject operation, EObject structuralRealization, String language) {
		StringBuilder retVal = new StringBuilder();
		if( ZDLUtil.isZDLConcept(operation, ZMLMMNames.WORKER_FUNCTION)) {
			retVal.append(UserEditableRegion.userEditBegin(operation, ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.WORKER_FUNCTION__BODY, language));
			retVal.append("\n");
			retVal.append(WorkerFunctionUtil.getWorkerFunctionImplementationCode(structuralRealization, operation, language));
			retVal.append(UserEditableRegion.userEditEnd());
			
			retVal.append("\n");			
		}
		return retVal.toString();
	}

	protected static EObject findStructuralRealization(EObject model, String modelElementQName) {
		for( Iterator<EObject> iter = model.eAllContents(); iter.hasNext();  ) {

			EObject eobj = iter.next();				
			
			if( eobj instanceof NamedElement) {
				NamedElement elm = (NamedElement)eobj;
				
				if( modelElementQName.equals(elm.getQualifiedName())) {
					if( ZDLUtil.isZDLConcept(elm, ZMLMMNames.STRUCTURAL_REALIZATION)) {
						return elm;
					}
				}					
			}				
		}
		return null;
	}

	protected static EObject getModel(String modelURI) {

//		URI uri = URI.createURI(modelURI);
//		Resource res = UMLModeler.getEditingDomain().getResourceSet().getResource(uri, true);
//		EObject result = null;
//
//		if( res == null || !res.getErrors().isEmpty()) {
//			if( res == null ) { 
//				CodeGenPlugin.getDefault().error("Result of resource load is null for " + modelURI, null);
//			}
//			for( Diagnostic error : res.getErrors() ) {
//				CodeGenPlugin.getDefault().error("Error opening " + modelURI + ": " + error.getMessage(), null);
//			}
//		}
//		
//		result = res.getContents().get(0);
		
		return null;
	}
}
