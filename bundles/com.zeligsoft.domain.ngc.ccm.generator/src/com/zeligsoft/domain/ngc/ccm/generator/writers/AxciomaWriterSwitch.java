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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.idl3plus.generator.writers.IDL3PlusWriter.IDL3PlusWriterSwitch;
import com.zeligsoft.domain.ngc.ccm.Activator;
import com.zeligsoft.domain.ngc.ccm.generator.AnnotationUtil;
import com.zeligsoft.domain.omg.corba.dsl.idl.Case;
import com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel;
import com.zeligsoft.domain.omg.corba.dsl.idl.Definition;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
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
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructType;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateDefinition;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionType;

public class AxciomaWriterSwitch extends IDL3PlusWriterSwitch {
		
		private boolean isModelLibrary = false;
		private Model dds4ccmModel;
		private boolean isCommentEnabled;
		
		@SuppressWarnings("deprecation")
		private static final IEclipsePreferences store = new InstanceScope()
				.getNode(Activator.PLUGIN_ID);
		
		/**
		 * @param fileName
		 */
		public AxciomaWriterSwitch(String fileName, Model model, boolean commentEnabled) {
			super(fileName);
			this.dds4ccmModel = model;
			this.isCommentEnabled = commentEnabled;
		}
		
		public AxciomaWriterSwitch(String fileName, boolean isModelLibrary, Model model, boolean commentEnabled) {
			super(fileName);
			this.isModelLibrary = isModelLibrary;
			this.dds4ccmModel = model;
			this.isCommentEnabled = commentEnabled;
		}
		
		private boolean isCommentEnabled() {
			return isCommentEnabled;
		}
		
		@Override
		public Object caseSequenceType(SequenceType object) {
			String returnType = "sequence <";

			if (object.getType() != null) {
				returnType += doSwitch(object.getType());
			}

			if (object.getSize() != null) {
				if ("CCM_DDS::UNLIMITED".equals(String.valueOf(doSwitch(object.getSize())))) {
					IEclipsePreferences store = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
					// use default value in preference page
					String value = store.get(DDS4CCMPreferenceConstants.IDL_SEQUENCE_BOUND,
							DDS4CCMPreferenceConstants.DEFAULT_IDL_SEQUENCE_BOUND);
					if (!UML2Util.isEmpty(value) && !"-1".equals(value)) {
						returnType += ", " + value;
					}
				} else {
					returnType += ", " + doSwitch(object.getSize());
				}
			}
			returnType += ">";
			return returnType;
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
		
		@Override
		public Object caseUnionType(UnionType object) {
			conditionalNewLine();

			if (isCommentEnabled()) {
				buf.append(String.format("%n%s/// @union %s%n", indentString,
						object.getName()));
				if (!object.getComments().isEmpty()) {
					buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
				}
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			// if AXCIOMA
			String extensibility = "@final";
			if(object.isIsAppendable()) {
				extensibility = "@appendable";
			}
			buf.append(String.format("%s%s%n", indentString, extensibility));
			
			buf.append(String.format("%sunion %s switch(%s) {%n", indentString,
					object.getName(), doSwitch(object.getSwitch())));

			pushScope(DEFINITION_SCOPE);
			for (Case c : object.getBody().getCase()) {
				for (IDLComment comment : c.getComments()) {
					doSwitch(comment);
				}
				for (CaseLabel cl : c.getLabel()) {
					if (cl.isIsDefault()) {
						buf.append(String.format("%sdefault: %n", indentString));
					} else {
						buf.append(String.format("%scase %s: %n", indentString,
								doSwitch(cl.getConstExp())));
					}
				}
				incIndent();
				buf.append(String.format("%s%s %s;%n", indentString, doSwitch(c
						.getSpec().getType()), doSwitch(c.getSpec()
						.getDeclarator())));
				decIndent();
			}
			popScope();

			buf.append(String.format("%s};%n", indentString));
			conditionalNewLine();
			return buf.toString();
		}
		
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
			
			// if AXCIOMA
			String extensibility = "@final";
			if(object.isIsAppendable()) {
				extensibility = "@appendable";
			}
			buf.append(String.format("%s%s%n", indentString, extensibility));
			
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