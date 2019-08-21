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
package com.zeligsoft.domain.ngc.ccm.generator.writers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.NoChangesVetoStrategy;
import org.eclipse.xpand2.output.Outlet;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.Activator;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.idl3plus.generator.writers.IDL3PlusWriter;
import com.zeligsoft.domain.ngc.ccm.generator.AnnotationUtil;
import com.zeligsoft.domain.omg.corba.codegen.l10n.Messages;
import com.zeligsoft.domain.omg.corba.dsl.idl.Definition;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.Member;
import com.zeligsoft.domain.omg.corba.dsl.idl.Module;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Idl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Interface;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Receptacle;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Lem;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_DDS4CCM_Impl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ndds;
import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructType;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateDefinition;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType;

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


	@SuppressWarnings("deprecation")
	private static final IEclipsePreferences store = new InstanceScope()
			.getNode(Activator.PLUGIN_ID);
	
	private String pathnameSlot;
	private static Model dds4ccmModel;
	
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
						
						IdlWriterSwitch idlSwitchModelLibrary = new NGCWriterSwitch(
								modelLibraryfilename, true);
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
		return new NGCWriterSwitch(getTargetFile());
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

	
	
	protected static class NGCWriterSwitch extends IDL3PlusWriterSwitch {
		
		private boolean isModelLibrary = false;
		
		/**
		 * @param fileName
		 */
		public NGCWriterSwitch(String fileName) {
			super(fileName);
		}
		
		public NGCWriterSwitch(String fileName, boolean isModelLibrary) {
			super(fileName);
			this.isModelLibrary = isModelLibrary;
		}
		
		@Override
		public Object casePreproc_Pragma_Conn_Type(Preproc_Pragma_Conn_Type object) {

			// No matter how many quotes are in the pragma value (0...*), write exactly one.
			buf.append(String.format(
					"#pragma conntype %s %s%n", object.getValuePort().replaceAll("\"", ""), 
					object.getValueConnType().replaceAll("\"", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return buf.toString();
		}
		
		@Override
		public Object casePreproc_Pragma_Ciao_Lem(Preproc_Pragma_Ciao_Lem object) {

			// No matter how many quotes are in the pragma value (0...*), write exactly one.
			buf.append(String.format(
					"#pragma ciao lem \"%s.idl\"%n", object.getValue().replaceAll("\"", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return buf.toString();
		}
		
		@Override
		public Object casePreproc_Pragma_Ndds(Preproc_Pragma_Ndds object) {
			// No matter how many quotes are in the pragma value (0...*), write exactly one.
			buf.append(String.format(
					"#pragma ndds typesupport \"%sSupport.h\"%n", object.getValue().replaceAll("\"", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return buf.toString();
		}
		
		@Override
		public Object casePreproc_Pragma_Ciao_Ami4ccm_Receptacle(Preproc_Pragma_Ciao_Ami4ccm_Receptacle object) {
			// No matter how many quotes are in the pragma value (0...*), write exactly one.
			buf.append(String.format(
					"#pragma ami4ccm receptacle \"%s\"%n", object.getValue().replaceAll("\"", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return buf.toString();
		}
		
		@Override
		public Object casePreproc_Pragma_Ciao_Ami4ccm_Interface(Preproc_Pragma_Ciao_Ami4ccm_Interface object) {
			// No matter how many quotes are in the pragma value (0...*), write exactly one.
			buf.append(String.format(
					"#pragma ami4ccm interface \"%s\"%n", object.getValue().replaceAll("\"", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return buf.toString();
		}
		
		@Override
		public Object casePreproc_Pragma_Ciao_Ami4ccm_Idl(Preproc_Pragma_Ciao_Ami4ccm_Idl object) {
			// No matter how many quotes are in the pragma value (0...*), write exactly one.
			buf.append(String.format(
					"#pragma ami4ccm idl \"%s.idl\"%n", object.getValue().replaceAll("\"", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return buf.toString();
		}
		
		@Override
		public Object casePreproc_Pragma_Component(Preproc_Pragma_Component object) {
			buf.append(String.format( 
					"#pragma componentInterface \"%s\" %n", object.getValue()));
			return buf.toString();
		}
		
		@Override
		public Object casePreproc_Pragma_Home(Preproc_Pragma_Home object) {
			buf.append(String.format( 
					"#pragma componentHome \"%s\" %n", object.getValue()));
			return buf.toString();
		}
		
		@Override
		public Object casePreproc_Pragma_DDS4CCM_Impl(
				Preproc_Pragma_DDS4CCM_Impl object) {
			if (fileName != null
					&& !fileName.endsWith("ccm_dds.idl")) {
				buf.append(String.format("#pragma dds4ccm impl \"%s\" %n",
						object.getValue()));
			}
			return buf.toString();
		}
		
		@Override
		public Object caseSpecification(Specification object) {
			if (!isCommentEnabled()) {
				return super.caseSpecification(object);
			}

			Map<String, String> entityInfo = getEntityInfo(object);
			boolean enableFileComment = entityInfo.get(AnnotationUtil.ENTITYNAME_KEY) != null
					&& entityInfo.get(AnnotationUtil.ENTITYNAME_KEY) != null;
			if (enableFileComment) {
				String fixedHeaderPerModel = (String) ZDLUtil.getValue(
						dds4ccmModel, DDS4CCMNames.DDS4_CCMMODEL,
						DDS4CCMNames.DDS4_CCMMODEL__FIXED_HEADER);
				String fixedHeader = store.get(
						DDS4CCMPreferenceConstants.IDL_FIXED_HEADER,
						DDS4CCMPreferenceConstants.DEFAULT_IDL_FIXED_HEADER);
				if (!(UML2Util.isEmpty(fixedHeaderPerModel))) {
					buf.append(String.format("%s%n", fixedHeaderPerModel));
				} else if (fixedHeader.length() > 0) {
					buf.append(String.format("%s%n", fixedHeader));
				}
				File file = new File(fileName);
				String scopedEntityName = file.getName().replaceAll("\\..*$", "");
				buf.append(String.format("/// @defgroup %s %s%n",
						scopedEntityName, entityInfo.get(AnnotationUtil.ENTITYNAME_KEY)));
				buf.append(String.format("/// @{%n"));
				buf.append(String.format("/// %n"));
				buf.append(String.format("/// @file %s%n", file.getName()));
				buf.append(String.format("/// @brief %s %s definition IDL file%n",
						entityInfo.get(AnnotationUtil.ENTITYNAME_KEY),
						entityInfo.get(AnnotationUtil.ENTITYTYPE_KEY)));
				List<Definition> comments = new ArrayList<Definition>();
				for (Definition d : object.getDefinitions()) {
					if (d instanceof IDLComment) {
						comments.add(d);
						doSwitch(d);
					}
				}
				for (Definition d : comments) {
					object.getDefinitions().remove(d);
				}
				buf.append(String
						.format("%n//=========================================================%n%n"));
			}
			super.caseSpecification(object);
			if (enableFileComment) {
				buf.append(String.format("%n/// @}%n"));
				String fixedFooterPerModel = (String) ZDLUtil.getValue(
						dds4ccmModel, DDS4CCMNames.DDS4_CCMMODEL,
						DDS4CCMNames.DDS4_CCMMODEL__FIXED_FOOTER);
				String fixedFooter = store.get(
						DDS4CCMPreferenceConstants.IDL_FIXED_FOOTER,
						DDS4CCMPreferenceConstants.DEFAULT_IDL_FIXED_FOOTER);
				if (!(UML2Util.isEmpty(fixedFooterPerModel))) {
					buf.append(String.format("%s%n", fixedFooterPerModel));
				} else {
					buf.append(String.format("%s%n", fixedFooter));
				}
			}

			return buf.toString();
		}
		
		/**
		 * Queries the entity info from the specification
		 * 
		 * @param model
		 * @return
		 */
		private Map<String, String> getEntityInfo(Object model) {
			Map<String, String> map = new HashMap<String, String>();
			if (model instanceof Specification) {
				EModelElement theSpecification = (Specification) model;
				EAnnotation zcxAnnotation = theSpecification
						.getEAnnotation(AnnotationUtil.ZCX_ANNOTATION);
				if (zcxAnnotation != null) {
					String entityName = zcxAnnotation.getDetails().get(
							AnnotationUtil.ENTITYNAME_KEY);
					if (entityName != null && !entityName.isEmpty()) {
						map.put(AnnotationUtil.ENTITYNAME_KEY, entityName);
					}
					String entityType = zcxAnnotation.getDetails().get(
							AnnotationUtil.ENTITYTYPE_KEY);
					if (entityType != null && !entityType.isEmpty()) {
						map.put(AnnotationUtil.ENTITYTYPE_KEY, entityType);
					}
				}
			}
			return map;
		}
		
		@SuppressWarnings("nls")
		@Override
		public Object caseStructType(StructType object) {
			
			String commentString = "//@top-level false";
			
			EAnnotation annotation = object.getEAnnotation(AnnotationUtil.ZCX_ANNOTATION);
			if( annotation != null ) {
				String topLevel = annotation.getDetails().get("toplevel");
				if( topLevel != null && topLevel.matches("true")) {
					commentString = "//@top-level true";
				}
			}
			
			buf.append(String.format("%n"));
			
			if (isCommentEnabled()) {
				buf.append(String.format("%s/// @struct %s%n", indentString,
						object.getName()));
				if (!object.getComments().isEmpty()) {
					buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
				}
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}			
			
			buf.append(String.format("%sstruct %s {%n", 
					indentString,
					object.getName()));
			pushScope(DEFINITION_SCOPE);
			for(Member m : object.getMembers()) {
				doSwitch(m);					
			}
			popScope();
			buf.append(String.format("%s}; %s%n",
					indentString, commentString));
			conditionalNewLine();
			return buf.toString();
		}
		
		@Override
		public Object caseMember(Member object) {
			
			if (isCommentEnabled()) {
				if (object.eContainer() instanceof ExceptDecl) {
					buf.append(String.format("%n%s/// @publicsection %s%n",
							indentString, object.getDecl().getId()));
					if (!object.getComment().isEmpty()) {
						buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
					}
				}else{
					conditionalNewLineForComment(object.getComment());
				}
				for (IDLComment comment : object.getComment()) {
					doSwitch(comment);
				}
			}
			
			String commentString = "";
			EAnnotation annotation = object.getEAnnotation(AnnotationUtil.ZCX_ANNOTATION);
			if( annotation != null ) {
				String comment = annotation.getDetails().get("comment");
				if( comment != null ) {
					commentString = comment;
				}
			}
			buf.append(String.format("%s%s %s;%s%n", 
					indentString,
					doSwitch(object.getType()),
					doSwitch(object.getDecl()),
					commentString));
			
			
			return buf;
		}
		
		@Override
		public Object caseModule(Module mod) {
			if (isModelLibrary) {
				String moduleName = mod.getName();

				if (isCommentEnabled()) {
					buf.append(String
							.format("/// @brief %s %n", moduleName)); //$NON-NLS-1$
					if (!mod.getComments().isEmpty()) {
						buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
					}
					for (IDLComment comment : mod.getComments()) {
						doSwitch(comment);
					}
				}
				buf.append(String.format(
						"%smodule %s {%n", indentString, moduleName)); //$NON-NLS-1$
				pushScope(MODULE_SCOPE);
				for (Definition d : mod.getDefinitions()) {
					if (d instanceof TemplateModule
							|| d instanceof TypeDeclarator
							|| d instanceof TemplateModuleRef) {
						doSwitch(d);
					}
				}
				popScope();
				buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
				return buf.toString();
			} else {
				return super.caseModule(mod);
			}
		}
		
		@Override
		public Object caseTypeDeclarator(TypeDeclarator object) {
			if ((isModelLibrary && ("DataReader".equals(object.getDeclarators()
					.get(0).getId()) || "DataWriter".equals(object
					.getDeclarators().get(0).getId())))
					|| (!isModelLibrary && !("DataReader".equals(object
							.getDeclarators().get(0).getId()) || "DataWriter"
							.equals(object.getDeclarators().get(0).getId())))) {
				return super.caseTypeDeclarator(object);
			}
			return buf.toString();
		}
		
		@Override
		public Object caseTemplateModuleRef(TemplateModuleRef object) {
			if ((isModelLibrary
					&& (("CCM_DDS::Typed".equals(object.getType().getName()
							.get(0)) && "DDS_Typed".equals(object.getName())) || ("CCM_PSAT::Typed".equals(((TemplateModuleRef) object)
									.getType().getName().get(0))
									&& "PSAT_Base".equals(((TemplateModuleRef) object)
											.getName()))))
					|| (!isModelLibrary
							&& ((!"CCM_DDS::Typed".equals(object.getType()
									.getName().get(0)) && !"DDS_Typed"
								.equals(object.getName())) && (!"CCM_PSAT::Typed".equals(((TemplateModuleRef) object)
										.getType().getName().get(0))
										&& !"PSAT_Base".equals(((TemplateModuleRef) object)
												.getName()))))) {
				return super.caseTemplateModuleRef(object);
			}
			return buf.toString();
		}
		
		@Override 
		public Object caseTemplateModule(TemplateModule object) {
			
			buf.append(String.format("%smodule %s", //$NON-NLS-1$
					indentString,
					object.getName()));  
			buf.append(" <");
			short sIdx = 0;
			String typename = "";
			for(FormalParameter e : object.getParameters()) {
				if (e.getType() instanceof TypenameParamType) {
					typename = e.getName();
				}
			}
			for(FormalParameter e : object.getParameters()) {
				if (e.getType() instanceof TypenameParamType) {
					doSwitch(e);
				} else {
					writeFormalParameter(e, typename);
				}
				sIdx++;
				buf.append(String.format("%s", 
						object.getParameters().size()!= sIdx ? ", " : ""));
			}
			buf.append(String.format("> {%n"));
			pushScope(MODULE_SCOPE);
			for(TemplateDefinition d : object.getDefinitions()) {
				if (d instanceof TemplateModuleRef) {
					doSwitch(d);
				}
			}
			if (!isModelLibrary) {
				for (TemplateDefinition d : object.getDefinitions()) {
					if (!(d instanceof TemplateModuleRef)) {
						doSwitch(d);
					}
				}
			} else {
				for (TemplateDefinition d : object.getDefinitions()) {
					if (!(d instanceof TemplateModuleRef)
							&& (d instanceof TypeDeclarator || d instanceof Module)) {
						doSwitch(d);
					}
				}
			}
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}
		
	}
}
