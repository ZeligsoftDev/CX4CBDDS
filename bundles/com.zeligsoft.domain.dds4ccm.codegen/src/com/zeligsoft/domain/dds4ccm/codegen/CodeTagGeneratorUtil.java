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

package com.zeligsoft.domain.dds4ccm.codegen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.NoChangesVetoStrategy;
import org.eclipse.xpand2.output.Outlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.CodeRetrievalUtil;
import com.zeligsoft.domain.dds4ccm.codegen.builder.DDS4CCMCodeTagNature;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo;
import com.zeligsoft.domain.dds4ccm.codegen.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.codegen.xtend.CodeTagModule;
import com.zeligsoft.domain.dds4ccm.codegen.xtend.MainTransform;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.MonolithicImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.impl.MonolithicImplementationImplementation;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

@SuppressWarnings("nls")
public class CodeTagGeneratorUtil extends CodeRetrievalUtil {
	
	private static final Object lock = new Object();

	/**
	 * 
	 * 
	 * @param workerFunction
	 * @return
	 */
	public static String getContents(EObject workerFunction) {
		
		EObject structuralRealization = ((Operation)workerFunction).getOwner();
		
		return retrieveCode(workerFunction, structuralRealization, "C++");
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param workerFunction
	 * @return
	 */
	public static String trimPrefix(Operation workerFunction) {
		String workerName = workerFunction.getName();
		EObject port = (EObject)ZDLUtil.getValue(workerFunction, ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
		String portName = null;
		if( port != null) {
			portName = ZDLUtil.getValue(port, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME).toString();
		}
		if( portName != null ) {
			if( workerName.startsWith(portName)) {
				workerName = workerName.substring(portName.length());
			}
		}
		if( workerName.startsWith("_")) {
			return workerName = workerName.substring(1);
		}
		return workerName;
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param modelURI
	 * @param modelElementQName
	 */
	public static void retrieveXML(String modelURI, String modelElementQName) {
	
		EObject model = getModel(modelURI);
		if( model == null) {
			CodeGenPlugin.getDefault().error("Model loaded was null for " + modelURI, null);
		}
		EObject structuralRealization = findStructuralRealization(model, modelElementQName);
		if( structuralRealization == null) {
			CodeGenPlugin.getDefault().error("Could not find model element " + modelElementQName, null);
		}
		
		generateXML(structuralRealization);
		
	}
	
	public static boolean generateXML(EObject monolithicImplementation) {
		return generateXML(monolithicImplementation, "");
	}
	
	public static boolean generateXML(EObject monolithicImplementation, String path) {
		
		synchronized (lock) {
			Map<String, String> properties = new HashMap<String, String>();
			WorkflowEngine workflow = new WorkflowEngine();
			Issues issues = new IssuesImpl();
			
			properties.put("modelURI",
					monolithicImplementation.eResource().toString());
			
			IProject project = ProjectFactory.getProject(monolithicImplementation, null,
					ProjectFactory.MODE_CREATE_BASIC);
			if (project != null) {
	
				// save the project name
				properties.put("generatedProject", project.getName());
	
				String srcGen = project.getLocation().makeAbsolute()
					.toOSString();
				srcGen = srcGen.concat(path);
				properties.put("src-gen", srcGen);
			}
				
			HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
			externalSlotContents.put("element", monolithicImplementation);//$NON-NLS-1$
	
			final boolean configOK = workflow.prepare("/workflow/generatecodetags.oaw",
					new NullProgressMonitor(), properties);
			if (configOK == false)
				return false;
	
			final boolean executeOK = workflow.executeWorkflow(
					externalSlotContents, issues);
			if (executeOK == false || issues.getErrors().length != 0)
				return false;
			
			return true;
		}
	}

	/**
	 * 
	 * @param monolithicImplementation
	 * @param path
	 * @return Generated XML pathname or null if not generated
	 */
	public static String generateXML2(EObject monolithicImplementation, String path) {

		synchronized (lock) {
			MonolithicImplementation impl = new MonolithicImplementationImplementation(monolithicImplementation);
	        Injector injector = Guice.createInjector(new CodeTagModule());
	        MainTransform generator = injector.getInstance(MainTransform.class);
	        CodeTagInfo info = generator.mainTransform(impl);
	        try {
	        	
	        	IProject project = ProjectFactory.getProject(monolithicImplementation, null,
	    				ProjectFactory.MODE_CREATE_BASIC);
	        	project.refreshLocal(IResource.DEPTH_INFINITE,
						null);
	        	IPath p = project.getFullPath();
	        	p = p.append(path);
	        	p = p.append(info.getFilename().get(0));
	        	String filename = info.getFilename().get(0);
	        	
				// generate new xml content
				IPath xmlPath = project.getFullPath();
				xmlPath = xmlPath.append(path);
				xmlPath = xmlPath.append(filename);
				IPath tempPath = xmlPath.addFileExtension("generated");

				ResourceSet rset =  new ResourceSetImpl();
				Resource res = rset.createResource(URI
						.createPlatformResourceURI(tempPath.toString(), true));
				info.getFilename().clear();
				res.getContents().add(info);
				res.save(Collections.EMPTY_MAP);
	            
	            // replace zcx xml tags
	            IFile newFile = project.getWorkspace().getRoot().getFile(tempPath);
	            InputStreamReader bin = new InputStreamReader(newFile.getContents());
	            BufferedReader br = new BufferedReader(bin);
	            StringBuffer resultContentBuilder = new StringBuffer();
	            String line;
	            while ((line = br.readLine()) != null) {
	            	line = line.replaceAll("zcxgt;", "&gt;");
	            	line = line.replaceAll("zcxapos;", "&apos;");
					resultContentBuilder.append(line).append(
							System.getProperty("line.separator"));
	            }
	            br.close();
	            bin.close();
	            
	            IPath dirPath = newFile.getLocation().removeLastSegments(1);
				Outlet outlet = new Outlet(dirPath.toOSString());
				NoChangesVetoStrategy st = new NoChangesVetoStrategy();
				outlet.addVetoStrategy(st);
				FileHandle fh = outlet.createFileHandle(filename);
				fh.setBuffer(resultContentBuilder.toString());
				boolean changed = st.hasChanges(fh);
				fh.writeAndClose();
				newFile.delete(true, null);
	            if(changed){
	            	return dirPath.append(filename).toOSString();
	            }

	        } catch (Exception e) {
	            Activator.getDefault().error(Messages.error_writeCodeTagXML, e);
	        }
			
            return null;
		}
	}
	
	/**
	 * Returns the home managing this component.
	 * 
	 * @param comp
	 * @return
	 */
	public static EObject getHome(Component comp) {
	
		for( Setting s : UML2Util.getInverseReferences(comp)) {
			if( s.getEObject() != null &&
				ZDLUtil.isZDLConcept(s.getEObject(), CCMNames.MANAGES)) {
				return (EObject)ZDLUtil.getValue(s.getEObject(), CCMNames.MANAGES, CCMNames.MANAGES__HOME);
			}
		}
		return null;
	}

	/**
	 * Toggles code tag nature on a project
	 * 
	 * @param project
	 *            to have nature added or removed
	 * @throws CoreException 
	 */
	public static void toggleCodeTagNature(IProject project) throws CoreException {
		final IProjectDescription description = project.getDescription();
		final String[] natures = description.getNatureIds();

		for (int i = 0; i < natures.length; ++i) {
			if (DDS4CCMCodeTagNature.NATURE_ID.equals(natures[i])) {
				removeCodeTagNature(project);
				return;
			}
		}

		// Add the nature
		addCodeTagNature(project);
	}
	
	/**
	 * Adds the code tag nature to a project identified by its name.
	 * 
	 * @param projectName
	 * @throws CoreException
	 */
	public static void addCodeTagNature(String projectName) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if( project.exists() == false ) {
			throw new IllegalArgumentException("Project " + projectName + " does not exist.");
		}
		addCodeTagNature(project);
	}
	
	public static void removeCodeTagNature(String projectName) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if( project.exists() == false ) {
			throw new IllegalArgumentException("Project " + projectName + " does not exist.");
		}
		removeCodeTagNature(project);		
	}
	
	private static void removeCodeTagNature(IProject project) throws CoreException {
		final IProjectDescription description = project.getDescription();
		final String[] natures = description.getNatureIds();

		for (int i = 0; i < natures.length; ++i) {
			if (DDS4CCMCodeTagNature.NATURE_ID.equals(natures[i])) {
				// Remove the nature
				String[] newNatures = new String[natures.length - 1];
				System.arraycopy(natures, 0, newNatures, 0, i);
				System.arraycopy(natures, i + 1, newNatures, i,
						natures.length - i - 1);
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
				return;
			}
		}

	}
	
	private static void addCodeTagNature(IProject project) throws CoreException {
		final IProjectDescription description = project.getDescription();
		final String[] natures = description.getNatureIds();
		
		final String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = DDS4CCMCodeTagNature.NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);		
	}

}
