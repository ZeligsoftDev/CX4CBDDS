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
package com.zeligsoft.domain.omg.ccm.generator.writers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.NoChangesVetoStrategy;
import org.eclipse.xpand2.output.Outlet;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.codegen.l10n.Messages;
import com.zeligsoft.domain.omg.corba.codegen.oaw.workflow.IDLWriterComponent;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList;
import com.zeligsoft.domain.omg.corba.dsl.idl.Export;
import com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.HomeExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls;
import com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;
import com.zeligsoft.domain.omg.corba.dsl.idl.StateMember;
import com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class IDL3Writer extends IDLWriterComponent {
	
	@Override
	protected IdlWriterSwitch getSwitch() {
		return new IDL3WriterSwitch(getTargetFile());
	}
	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		Object model = ctx.get(getModelSlot());
		
		NamedElement generationContext = (NamedElement)ctx.get("element");
		
		setTargetFile(fileName(generationContext, model));
		if(!IdlPackage.Literals.SPECIFICATION.isInstance(model)) {
			issues.addError(this, Messages.IDLWriter_noModel, model);
		}
		
		IdlWriterSwitch idlSwitch = getSwitch();
		idlSwitch.setIssues(issues);
		Object result = idlSwitch.doSwitch((Specification) model);
		
		if(result instanceof String) {
			Outlet outlet = new Outlet(getTargetDir());
			outlet.addVetoStrategy( new NoChangesVetoStrategy() );
			FileHandle fh = outlet.createFileHandle(getTargetFile());
			
			fh.setBuffer((String) result);
			fh.writeAndClose();
		}
	}
	
	protected String fileName(EObject element, Object model) {
		if(ZDLUtil.isZDLConcept(element, CXDomainNames.CXNAMED_ELEMENT)) {
			String name = 
				(String) ZDLUtil.getValue(element, 
						CXDomainNames.CXNAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME);
			
			return name;
		} else {
			throw new IllegalArgumentException("Can not generate a filename for something that is not a named element");
		}
	}

	public static class IDL3WriterSwitch extends IdlWriterSwitch {
		private static final String ATTRIBUTE_SEPERATOR = ", "; //$NON-NLS-1$
		
		private static final int COMPONENT_SCOPE = 16;
		private static final int EVENT_SCOPE = 32;
		private static final int HOME_SCOPE = 64;
		
		public IDL3WriterSwitch(String fileName) {
			super(fileName);
		}
		
		@Override
		public Object caseComponentDecl(ComponentDecl object) {
			conditionalNewLine();
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			buf.append(String.format("%scomponent %s", //$NON-NLS-1$
					indentString,
					object.getName()));
			
			if(object.getBase() != null) {
				buf.append(String.format(" : %s",
						doSwitch(object.getBase())));
			}
			
			short sIdx = 0;
			for(ScopedName sup : object.getSupports()) {
				buf.append(String.format("%s%s", 
						sIdx > 0 ? ", " : " supports ",
								doSwitch(sup)));
				sIdx++;
			}
			buf.append(String.format(" {%n")); //$NON-NLS-1$
			pushScope(COMPONENT_SCOPE);
			
			for(ComponentExport e : object.getExport()) {
				if (! (e instanceof IDLComment)) {
					doSwitch(e);
				}
			}
			
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}
		
		@Override
		public Object caseHomeDecl(HomeDecl object) {
			conditionalNewLine();

			if (isCommentEnabled()) {
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			buf.append(String.format("%shome %s", //$NON-NLS-1$
					indentString,
					object.getName()));
			
			if(object.getBase() != null &&
					object.getBase() != null) {
				buf.append(String.format(" : %s",
						doSwitch(object.getBase())));
			}
			
			short sIdx = 0;
			for(ScopedName sup : object.getSupports()) {
				buf.append(String.format("%s%s", 
						sIdx > 0 ? ", " : " supports ",
								doSwitch(sup)));
				sIdx++;
			}
			
			if( object.getManages() != null) {
				buf.append(String.format(" manages %s", 
						doSwitch(object.getManages())));
			}
			
			buf.append(String.format(" {%n")); //$NON-NLS-1$
			pushScope(HOME_SCOPE);
			
			for (HomeExport e : object.getExport()) {
				doSwitch(e);
			}
			
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}
		
		@Override
		public Object caseFactoryDcl(FactoryDcl object) {
			return caseHomeOperation(object.getComments(), object.getParams(), "factory", object.getName(), object.getRaises());
		}
		
		@Override
		public Object caseFinderDcl(FinderDcl object) {
			return caseHomeOperation(object.getComments(), object.getParams(), "finder", object.getName(), object.getRaises());
		}
		
		@SuppressWarnings("nls")
		private Object caseHomeOperation(EList<IDLComment> commentList, ParameterDecls parameters,
				String opType, String opName, ExceptionList exceptions) {
			conditionalNewLine();
			if (isCommentEnabled()) {
				// documentation for Operation
				buf.append(String.format("%n"));
				if (commentList.get(0).getBody() != null
						&& commentList.get(0).getBody().length() != 0) {
					doSwitch(commentList.get(0));
					buf.append(String.format("%s///%n", indentString));
				}
				for (int i = 0; i < parameters.getDecls().size(); i++) {
					ParamDcl param = parameters.getDecls().get(i);
					IDLComment comment = parameters.getComments().get(i);
					String direction = param.getDirection().getLiteral();
					if (direction.equals("inout")) {
						direction = "in,out";
					}
					buf.append(String.format("%s/// @param[%s] %s%n",
							indentString, direction, param.getName()));
					doSwitch(comment);
					buf.append(String.format("%s///%n", indentString));
				}
				if (opType.equals("finder")) {
					buf.append(String
							.format("%s/// @return existing component instance%n", indentString)); //$NON-NLS-1$
				} else {
					buf.append(String
							.format("%s/// @return new component instance%n", indentString)); //$NON-NLS-1$	
				}
			}

			buf.append(String.format("%s%s %s(", //$NON-NLS-1$
					indentString, opType, opName));

			short pdIdx = 0;

			if (nonReturnParameters(parameters).size() > 0) {
				incIndent();

				for (ParamDcl pd : nonReturnParameters(parameters)) {
					pdIdx++;
					buf.append(String.format("%s%s%s%s", //$NON-NLS-1$
							pdIdx > 1 ? "," : "", //$NON-NLS-1$//$NON-NLS-2$
							"\n", indentString, doSwitch(pd)));
				}
				buf.append(String.format("%n%s)", indentString)); //$NON-NLS-1$
				decIndent();
			} else {
				buf.append(")"); //$NON-NLS-1$
			}

			// the exceptions raised by the operation
			if (exceptions != null
					&& !exceptions.getException().isEmpty()) {
				buf.append(String.format("%n%s%s", indentString, INDENT_STRING));
				if (exceptions.getException().size() > 0) {
					buf.append("raises (");
					boolean first = true;
					for (ScopedName ex : exceptions.getException()) {
						if (!first)
							buf.append(", ");
						buf.append(String.format("%s", doSwitch(ex)));
						first = false;
					}
					buf.append(')');
				}
			}

			buf.append(String.format(";%n"));
			return buf.toString();
		}
		
		@Override
		public Object caseEventDcl(EventDcl object) {
			conditionalNewLine();
			buf.append(String.format("%s%s%seventtype %s", //$NON-NLS-1$
					indentString,
					object.isIsAbstract() ? "abstract " : "",
					object.isIsCustom() ? "custom " : "",
					object.getName()));
			
			short sIdx = 0;
			for(ScopedName base : object.getBase()) {
				buf.append(String.format("%s%s", 
						sIdx > 0 ? ", " : " : ",
						doSwitch(base)));
				sIdx++;
			}
			
			buf.append(String.format(" {%n")); //$NON-NLS-1$
			pushScope(EVENT_SCOPE);
			
			for(StateMember sm : object.getMember()) {
				doSwitch(sm);
			}
			
			for(Export e : object.getExport()) {
				doSwitch(e);
			}
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			
			return buf.toString();
		}
		
		@Override
		public Object caseProvidesDcl(ProvidesDcl object) {
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			buf.append(String.format("%sprovides %s %s;%n", 
					indentString,
					doSwitch(object.getType()),
					object.getName()));
			
			return buf.toString();
		}
		
		@Override
		public Object caseUsesDcl(UsesDcl object) {
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			String multipleStr = object.isIsMultiple() ?
					" multiple" : "";
			
			buf.append(String.format("%suses%s %s %s;%n", 
					indentString,
					multipleStr,
					doSwitch(object.getType()),
					object.getName()));
			
			return buf.toString();
		}
		
		@Override
		public Object caseEmitDcl(EmitDcl object) {
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			buf.append(String.format("%semits %s %s;%n", 
					indentString,
					doSwitch(object.getType()),
					object.getName()));
			
			return buf.toString();
		}
		
		@Override
		public Object casePublishesDcl(PublishesDcl object) {
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			buf.append(String.format("%spublishes %s %s;%n", 
					indentString,
					doSwitch(object.getType()),
					object.getName()));
			
			return buf.toString();
		}
		
		@Override
		public Object caseConsumesDcl(ConsumesDcl object) {
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			buf.append(String.format("%sconsumes %s %s;%n", 
					indentString,
					doSwitch(object.getType()),
					object.getName()));
			
			return buf.toString();
		}
		
		@Override
		public Object caseAttrSpec(AttrSpec object) {
			if(object.getType() == null) {
				getIssues().addError(
							String.format("The type of attribute %s, is null. The generated Idl will be incorrect.", object.getNames()),  //$NON-NLS-1$
							object);
			}
			
			if(object.getNames() == null){
				getIssues().addError(
						"The names of an attribute cannot be null. The generated Idl will be incorrect.",  //$NON-NLS-1$
						object);
			}
			
			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			
			StringBuffer names = new StringBuffer();
			
			short idx = 0;
			for(String name : object.getNames()){
				names.append(String.format("%s%s",  //$NON-NLS-1$
						idx>0 ? ATTRIBUTE_SEPERATOR : "", //$NON-NLS-1$
						name));
			}
			
			if(object.eContainer() instanceof EventDcl) {
				buf.append(String.format("%s%s%s %s",  //$NON-NLS-1$
						indentString, 
						"public ",  //$NON-NLS-1$//$NON-NLS-2$
						doSwitch(object.getType()), 
						names.toString()));
			} else {
				buf.append(String.format("%s%s%s %s",  //$NON-NLS-1$
						indentString, 
						"attribute ",  //$NON-NLS-1$//$NON-NLS-2$
						doSwitch(object.getType()), 
						names.toString()));
				
				
				if((object.getGetRaises() != null) 
						&& (object.getGetRaises().getExceptions() != null)
						&& !object.getGetRaises().getExceptions().getException().isEmpty()) {
					incIndent();
					buf.append(String.format("%n%sgetraises (", indentString)); //$NON-NLS-1$
					doSwitch(object.getGetRaises().getExceptions());
					buf.append(")"); //$NON-NLS-1$
					decIndent();
				}
				
				if((object.getSetRaises() != null)
						&& (object.getSetRaises().getExceptions() != null)
						&&!object.getSetRaises().getExceptions().getException().isEmpty()) {
					incIndent();
					buf.append(String.format("%n%ssetraises (", indentString)); //$NON-NLS-1$
					doSwitch(object.getSetRaises().getExceptions());
					buf.append(")"); //$NON-NLS-1$
					decIndent();
				}
			}
			buf.append(String.format(";%n")); //$NON-NLS-1$
			
			return buf.toString();
		}
		
		/* (non-Javadoc)
		 * @see com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch#caseStateMember(com.zeligsoft.domain.omg.corba.dsl.idl.StateMember)
		 */
		@Override
		public Object caseStateMember(StateMember object) {
			
			StringBuffer names = new StringBuffer();
			
			short idx = 0;
			for(String name : object.getNames()){
				names.append(String.format("%s%s",  //$NON-NLS-1$
						idx>0 ? ATTRIBUTE_SEPERATOR : "", //$NON-NLS-1$
						name));
			}
			
			buf.append(String.format("%s%s %s %s",  //$NON-NLS-1$
					indentString, 
					object.isIsPublic() ? "public" : "private",  //$NON-NLS-1$//$NON-NLS-2$
					doSwitch(object.getType()), 
					names.toString()));
			
			buf.append(String.format(";%n")); //$NON-NLS-1$
			
			return buf.toString();
		}
	}
}
