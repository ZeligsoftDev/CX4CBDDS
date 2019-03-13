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
package com.zeligsoft.domain.idl3plus.generator.writers;

import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.domain.omg.ccm.generator.writers.IDL3Writer;
import com.zeligsoft.domain.omg.corba.dsl.idl.ActualParameter;
import com.zeligsoft.domain.omg.corba.dsl.idl.Connector;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.EnumParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.EventParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.FixedDefinition;
import com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule;
import com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter;
import com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameterType;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.PortExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateDefinition;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ValuetypeParamType;

/**
 * @author Tim McGuire (tmcguire)
 *
 */
@SuppressWarnings("nls")
public class IDL3PlusWriter extends IDL3Writer {
	
	@Override
	protected IdlWriterSwitch getSwitch() {
		return new IDL3PlusWriterSwitch(getTargetFile());
	}

	public static class IDL3PlusWriterSwitch extends IDL3WriterSwitch {
		private static final int CONNECTOR_SCOPE = 128;
		private static final int PORTTYPE_SCOPE = 256;
		
		public IDL3PlusWriterSwitch(String fileName) {
			super(fileName);
		}
		
		@Override
		public Object caseTemplateModuleInst(TemplateModuleInst object){
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				if (!object.getComments().isEmpty()
						&& (!UML2Util.isEmpty(object.getComments().get(0)
								.getBody()) && !"<p></p>".equals(object
								.getComments().get(0).getBody()))) {
					buf.append(String.format("%s/// @var %s%n", indentString,
							object.getName()));
					buf.append(String.format("%s///%n", indentString));
				}
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			buf.append(String.format("%smodule %s <", 
					indentString, 
					doSwitch(object.getType())));
			
			short sIdx = 0;
			for(ActualParameter e : object.getParameter()) {
				buf.append(String.format("%s", doSwitch(e)));
				sIdx++;
				buf.append(String.format("%s", 
						object.getParameter().size()!= sIdx ? ", " : ""));
			}
			buf.append(String.format("> %s; %n", object.getName()));
			return buf.toString();
		}
		
		@Override
		public Object caseTemplateModuleRef(TemplateModuleRef object) {
			buf.append(String.format("%salias %s <",
					indentString,
					doSwitch(object.getType())));
			
			short sIdx = 0;
			for(String s : object.getId()) {
				buf.append(String.format("%s", s));
				sIdx++;
				buf.append(String.format("%s", 
						object.getId().size()!= sIdx ? ", " : ""));
			}
			
			buf.append(String.format("> %s; %n", object.getName()));
			return buf.toString();
		}
		
				
		@Override
		public Object caseFixedModule(FixedModule object){
			String moduleName = object.getName();
			buf.append(String.format("%smodule %s {%n", indentString, moduleName)); //$NON-NLS-1$
			pushScope(MODULE_SCOPE);
			
			for(FixedDefinition d : object.getDefinitions()){
				doSwitch(d);
			}
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}
		
		@Override 
		public Object caseTemplateModule(TemplateModule object){
			
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
			for(TemplateDefinition d : object.getDefinitions()){
				if (d instanceof TemplateModuleRef) {
					doSwitch(d);
				}
			}
			for(TemplateDefinition d : object.getDefinitions()){
				if (!(d instanceof TemplateModuleRef)) {
					doSwitch(d);
				}
			}
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}
		
		public Object writeFormalParameter(FormalParameter object, String typename){
			buf.append(String.format("%s", getFormalParameterType(object.getType())));
			if(!UML2Util.isEmpty(typename)){
				buf.append("<"+typename+">");
			}
			buf.append(" ");
			buf.append(String.format("%s", object.getName()));
			return buf.toString();
		}
		
		@Override
		public Object caseFormalParameter(FormalParameter object){
			buf.append(String.format("%s", getFormalParameterType(object.getType())));
			buf.append(" ");
			buf.append(String.format("%s", object.getName()));
			return buf.toString();
		}
		
		private String getFormalParameterType(FormalParameterType o ) {
			if( o instanceof TypenameParamType ) {
				return "typename";
			} else if( o instanceof InterfaceParamType) {
				return "interface";
			} else if( o instanceof ValuetypeParamType) {
				return "valuetype";
			} else if( o instanceof EventParamType) {
				return "eventtype";
			} else if( o instanceof StructParamType) {
				return "struct";
			} else if( o instanceof UnionParamType) {
				return "union";
			} else if( o instanceof ExceptionParamType) {
				return "exception";
			} else if( o instanceof SequenceParamType) {
				return "sequence";
			} else if( o instanceof ConstParamType) {
				return "const";
			} else if( o instanceof SequenceType) {
				return "sequence";
			} else if( o instanceof EnumParamType) {
				return "enum";
			}
			return "";
		}
		
		
		@Override
		public Object caseConnector(Connector object) {
			
			doSwitch(object.getHeader());
			buf.append(String.format(" {%n")); //$NON-NLS-1$
			pushScope(CONNECTOR_SCOPE);
			
			for(ConnectorExport e : object.getExports()) {
				doSwitch(e);
			}
			
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}
		
		@Override
		public Object caseConnectorHeader(ConnectorHeader object) {
			conditionalNewLine();
			buf.append(String.format("%sconnector %s", //$NON-NLS-1$
					indentString,
					object.getName()));
			
			if(object.getBase() != null) {
				buf.append(String.format(" : %s",
						doSwitch(object.getBase())));
			}
			return buf.toString();
		}
		
			
		@Override
		/* <porttype_dcl> ::= �porttype� <identifier> "{" <port_export>+ "}" */
		public Object casePortTypeDecl(PortTypeDecl object) {
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			buf.append(String.format("%sporttype %s", 
					indentString,
					object.getName()));
			buf.append(String.format(" {%n")); //$NON-NLS-1$
			pushScope(PORTTYPE_SCOPE);
			
			for(PortExport e : object.getExports()) {
				doSwitch(e);
			}
			
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}
		
		
		@Override
		/* <port_dcl> ::= {�port� | �mirrorport� } <scoped_name> <identifier> */
		public Object casePortDecl(PortDecl object) {
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			String mirrorStr = object.isIsMirror() ?
					"mirrorport" : "port";
			
			buf.append(String.format("%s%s %s %s;%n", 
					indentString,
					mirrorStr,
					doSwitch(object.getType()),
					object.getName()));
			
			return buf.toString();
		}
	}
}
