/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.ngc.ccm.generator.writers;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.NoChangesVetoStrategy;
import org.eclipse.xpand2.output.Outlet;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.idl3plus.generator.writers.IDL3PlusWriter;
import com.zeligsoft.domain.ngc.ccm.generator.AnnotationUtil;
import com.zeligsoft.domain.omg.corba.codegen.l10n.Messages;
import com.zeligsoft.domain.omg.corba.dsl.idl.Definition;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.Module;
import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;

/**
 * An extension to the IDL3Writer that provides NGC specific logic. For example,
 * it reads the filename from an annotation attached to the element that was
 * created during the M2M phase. If none exists it will use the default 
 * filename generation strategy.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class NGCWriter extends IDL3PlusWriter {

	private String pathnameSlot;
	private static Model dds4ccmModel;
	private boolean isAxciomaModel;
	
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
	
	/**
	 * Construct me.
	 */
	public NGCWriter() {
		super();
	}
	
	/* (non-Javadoc)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		Object generated = ctx.get(getModelSlot());
		List<Object> generatedList;		
		if(IdlPackage.Literals.SPECIFICATION.isInstance(generated)) {
			generatedList = Collections.singletonList(generated);
		} else if (generated instanceof List) {
			generatedList = (List<Object>) generated;
		} else {
			throw new IllegalArgumentException("Unknown type of element: " + 
					generated.getClass().getName());
		}
		
		
		NamedElement generationContext = (NamedElement)ctx.get("element");
		
		dds4ccmModel = generationContext.getModel();
		Map<String, Set<String>> pathMap = new HashMap<String, Set<String>>();
		Set<String> modifiedPathnames = new HashSet<String>();
		Set<String> allPathnames = new HashSet<String>();
		pathMap.put("modified", modifiedPathnames);
		pathMap.put("all", allPathnames);
		
		isAxciomaModel = false;
		if (ZDLUtil.isZDLConcept(dds4ccmModel, DDS4CCMNames.DDS4_CCMMODEL)) {
			EnumerationLiteral modelKind = (EnumerationLiteral) ZDLUtil.getValue(dds4ccmModel,
					DDS4CCMNames.DDS4_CCMMODEL, DDS4CCMNames.DDS4_CCMMODEL__MODEL_TYPE);
			if ("AXCIOMA".equals(modelKind.getName())) {
				isAxciomaModel = true;
			}
		}
		for(Object obj : generatedList) {
			if (IdlPackage.Literals.SPECIFICATION.isInstance(obj)) {
				Specification model = (Specification) obj;
				String filetype = AnnotationUtil.getZCXAnnotationDetail(model, AnnotationUtil.FILETYPE_KEY);
				if (filetype != null && filetype.equals(AnnotationUtil.PACKAGE_FILETYPE)) {
					if (Boolean.toString(true).equals(
							AnnotationUtil.getZCXAnnotationDetail(model, "generatedir"))) {
						String path = AnnotationUtil.getZCXAnnotationDetail(model,
								AnnotationUtil.FILENAME_KEY);
						int index = path.lastIndexOf(File.separator);
						String filename = "";
						if (index > 0) {
							filename = path.substring(0, index + 1);
						}
						filename = filename.concat(AnnotationUtil.getZCXAnnotationDetail(
								model, AnnotationUtil.ENTITYNAME_KEY));
						File file = new File(getTargetDir(), filename);
						file.mkdirs();
					}
				}
				if( hasNonCommentDefinitions(model)) {
					
					setTargetFile(fileName(generationContext, model));
					if(!IdlPackage.Literals.SPECIFICATION.isInstance(model)) {
						issues.addError(this, Messages.IDLWriter_noModel, model);
					}
					
					if (hasModelLibraryEelements(model)) {
						int index = getTargetFile().lastIndexOf(File.separator);
						String modelLibraryfilename = null;
						if (index > 0) {
							String toReplace = getTargetFile().substring(index);
							modelLibraryfilename = getTargetFile().replace(toReplace, File.separator + "ccm_dds.idl");
						} else {
							modelLibraryfilename = "ccm_dds.idl";
						}
						
						IdlWriterSwitch idlSwitchModelLibrary;
						if (isAxciomaModel) {
							idlSwitchModelLibrary = new AxciomaWriterSwitch(modelLibraryfilename, true, dds4ccmModel,
									isCommentEnabled());
						} else {
							idlSwitchModelLibrary = new AtcdWriterSwitch(modelLibraryfilename, true, dds4ccmModel,
									isCommentEnabled());
						}
						idlSwitchModelLibrary.setIssues(issues);
						Object addtofile = idlSwitchModelLibrary.doSwitch(model);
						if (addtofile instanceof String) {
							createFile(modelLibraryfilename,
									(String) addtofile, allPathnames,
									modifiedPathnames);
						}
					} 
					IdlWriterSwitch idlSwitch = getSwitch();
					idlSwitch.setIssues(issues);
					Object result = idlSwitch.doSwitch(model);
					if (result instanceof String) {
						createFile(getTargetFile(), (String) result,
								allPathnames, modifiedPathnames);
					}
				}
			}
		}
		ctx.set(getPathnameSlot(), pathMap);
	}
	
	private void createFile(String fileName, String fileContent,
			Set<String> allPathnames, Set<String> modifiedPathnames) {
		Outlet outlet = new Outlet(getTargetDir());
		NoChangesVetoStrategy st = new NoChangesVetoStrategy();
		outlet.addVetoStrategy(st);
		FileHandle fh = outlet.createFileHandle(fileName);

		fh.setBuffer(fileContent);
		boolean changed = st.hasChanges(fh);
		fh.writeAndClose();
		getTargetFile();
		File f = new File(getTargetDir() + fileName);
		allPathnames.add(f.getAbsolutePath());
		if (changed) {
			modifiedPathnames.add(f.getAbsolutePath());
		}
	}
	
	private boolean hasModelLibraryEelements(EObject eobject) {
		for (EObject eobj : eobject.eContents()) {
			if (eobj instanceof Module) {
				return hasModelLibraryEelements(eobj);
			} else if (eobj instanceof TemplateModule) {
				return hasModelLibraryEelements(eobj);
			} else if (eobj instanceof TypeDeclarator
					&& ("DataReader".equals(((TypeDeclarator) eobj)
							.getDeclarators().get(0).getId()) || "DataWriter"
							.equals(((TypeDeclarator) eobj).getDeclarators()
									.get(0).getId()))) {
				return true;
			} else if (eobj instanceof TemplateModuleRef) {
				if (("CCM_DDS::Typed".equals(((TemplateModuleRef) eobj)
						.getType().getName().get(0))
						&& "DDS_Typed".equals(((TemplateModuleRef) eobj)
								.getName())) || ("CCM_PSAT::Typed".equals(((TemplateModuleRef) eobj)
										.getType().getName().get(0))
										&& "PSAT_Base".equals(((TemplateModuleRef) eobj)
												.getName()))) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns whether a Specification has any non-comment elements; if not, we won't generate it.
	 * 
	 * @param model
	 * @return
	 */
	private boolean hasNonCommentDefinitions(Specification model) {
		
		for( Definition d : model.getDefinitions()) {
			if( !(d instanceof IDLComment) ) {
				return true;
			}
		}
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.zeligsoft.domain.omg.ccm.generator.writers.IDL3Writer#getSwitch()
	 */
	@Override
	protected IdlWriterSwitch getSwitch() {
		if(isAxciomaModel){
			return new AxciomaWriterSwitch(getTargetFile(), dds4ccmModel, isCommentEnabled());
		}else {
			return new AtcdWriterSwitch(getTargetFile(), dds4ccmModel, isCommentEnabled());
		}
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.domain.omg.ccm.generator.writers.IDL3Writer#fileName(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected String fileName(EObject element, Object model) {
		String result = AnnotationUtil.getZCXAnnotationDetail(model, AnnotationUtil.FILENAME_KEY);
		if (result == null) {
			result = super.fileName(element, model);
		}
		return result;
	}
}
