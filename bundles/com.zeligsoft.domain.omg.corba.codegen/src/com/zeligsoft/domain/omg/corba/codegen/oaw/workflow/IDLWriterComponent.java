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
package com.zeligsoft.domain.omg.corba.codegen.oaw.workflow;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IPathVariableManager;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.NoChangesVetoStrategy;
import org.eclipse.xpand2.output.Outlet;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.codegen.util.IdlDeclarationExaminer;
import com.zeligsoft.domain.omg.corba.codegen.util.IdlDeclarationInspector;
import com.zeligsoft.domain.omg.corba.codegen.util.IdlForwardDeclarationGenerator;
import com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.BooleanType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Case;
import com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel;
import com.zeligsoft.domain.omg.corba.dsl.idl.CharType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Declarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.Definition;
import com.zeligsoft.domain.omg.corba.dsl.idl.DoubleType;
import com.zeligsoft.domain.omg.corba.dsl.idl.EnumType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList;
import com.zeligsoft.domain.omg.corba.dsl.idl.Export;
import com.zeligsoft.domain.omg.corba.dsl.idl.FloatType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Forward_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Literal;
import com.zeligsoft.domain.omg.corba.dsl.idl.LongDoubleType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Member;
import com.zeligsoft.domain.omg.corba.dsl.idl.Module;
import com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.NativeType;
import com.zeligsoft.domain.omg.corba.dsl.idl.OctetType;
import com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls;
import com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Endif;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Prefix;
import com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongLongInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.SignedShortInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.SimpleDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;
import com.zeligsoft.domain.omg.corba.dsl.idl.StringType;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructType;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionType;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongLongInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedShortInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.WideCharType;
import com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType;
import com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionTypeImpl;



/**
 * An EMF component (with model slot) that writes an IDL file. The model 
 * is supplied in the <tt>modelFile</tt> property.
 * 
 * @author tobymcclean
 *
 */
public class IDLWriterComponent extends WorkflowComponentWithModelSlot {

	private String targetDir;		
	private String targetFile;

	@SuppressWarnings("deprecation")
	private static final IEclipsePreferences cxStore = new InstanceScope()
	.getNode(CXActivator.PLUGIN_ID);
	
	public static final Pattern makeVarPattern = Pattern.compile( "\\s*\\$\\((\\w+)\\)\\s*" ); //$NON-NLS-1$
	
	/**
	 * The directory as a URI that the file will be written into.
	 * @param value
	 */
	public void setTargetDir(String value) {
		this.targetDir = value;
	}
	
	protected static boolean isCommentEnabled(){
		return cxStore.getBoolean(CXPreferenceConstants.GENERATE_IDL_COMMENT,
				CXPreferenceConstants.GENERATE_IDL_COMMENT_DEFAULT);
	}
	
	/**
	 * 
	 * @param ctx
	 * @return
	 */
	public String getTargetFile() {
		return targetFile + ".idl";		 //$NON-NLS-1$
	}
	
	protected void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}
	
	/**
	 * 
	 * @return The directory that the file will be written into
	 */
	public String getTargetDir() {
		return targetDir;
	}	
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		Object model = ctx.get(getModelSlot());

		Package IDLFile = (Package)ctx.get("element"); //$NON-NLS-1$

		// Abort immediately if the file does not need to be generated.
		if( ! shouldGenerate( IDLFile, issues, model ) )
			return;
		List<Object> generatedList;
		
		if(IdlPackage.Literals.SPECIFICATION.isInstance(model)) {
			generatedList = Collections.singletonList(model);
		} else if (model instanceof List) {
			generatedList = (List<Object>) model;
		} else {
			throw new IllegalArgumentException("Unknown type of element: " +  //$NON-NLS-1$
					model.getClass().getName());
		}
		
		for(Object obj : generatedList) {
			if(IdlPackage.Literals.SPECIFICATION.isInstance(obj)) {
				Specification idlSpecification = (Specification) obj;
				if(!idlSpecification.getDefinitions().isEmpty()) {
					targetFile = getFileName(IDLFile, idlSpecification);
					IdlWriterSwitch idlSwitch = getSwitch();
					idlSwitch.setIssues(issues);
					Object result = idlSwitch.doSwitch(idlSpecification);
					
					if(result instanceof String) {
						Outlet outlet = new Outlet(getTargetDir());
						outlet.addVetoStrategy( new NoChangesVetoStrategy() );
						FileHandle fh = outlet.createFileHandle(getTargetFile());
						
						fh.setBuffer((String) result);
						fh.writeAndClose();
					}
				}
			}
		}
	}
	
	protected String getFileName(Package idlFile, Specification idlSpec) {
		return idlFile.getName();
	}

	/**
	 * The file does not need to be generated if the IDLFile location has been set
	 * to a value that exists as a Preferences linked resource entry.
	 */
	@SuppressWarnings("deprecation")
	protected boolean shouldGenerate( Package idlFile, Issues issues, Object model )
	{
		Object locationObj = ZDLUtil.getValue( idlFile, CORBADomainNames.IDLFILE, CORBADomainNames.IDLFILE__LOCATION );
		if( locationObj == null
		 || ! ( locationObj instanceof String )
		 || ( (String)locationObj ).length() <= 0 )
			return true;

		String locationVar = (String)locationObj;

		IPathVariableManager pvMan = ResourcesPlugin.getWorkspace().getPathVariableManager();
		IPath locationPath = pvMan.getValue( locationVar );
		if( locationPath == null )
		{
			Matcher m = makeVarPattern.matcher( locationVar );
			if( m.matches() ) {
				locationPath = pvMan.getValue( m.group( 1 ) );
				// can't specify a Linked Resource variable without a path, therefore if path exists, variable exists
				if( locationPath == null) {
					return true;
				}
			}
		}

		// if all checks have been passed then IDLFile location has been set to a value
	    // that exists as a Preferences linked resource entry so do not generate
		return false;
	}

	protected IdlWriterSwitch getSwitch() {
		return new IdlWriterSwitch(getTargetFile());
	}
		
	protected static class IdlWriterSwitch extends IdlSwitch<Object> {
		protected static final int GLOBAL_SCOPE = 1;
		protected static final int MODULE_SCOPE = 2;
		protected static final int INTERFACE_SCOPE = 4;
		protected static final int DEFINITION_SCOPE = 8;
		
		protected Issues issues;
		protected final String INDENT_STRING = "    "; //$NON-NLS-1$
		private final String SCOPE_OPERATOR = "::"; //$NON-NLS-1$
		private final String ATTRIBUTE_SEPERATOR = ", "; //$NON-NLS-1$
		protected int indent = 0;
		protected String indentString = ""; //$NON-NLS-1$
		protected StringBuffer buf = new StringBuffer();
		protected String fileName;

		private Deque<Integer> scopeStack = new ArrayDeque<Integer>();

		public IdlWriterSwitch(String fileName) {
			super();
			this.fileName = fileName;
		}

		public void setIssues(Issues i) {
			issues = i;
		}

		public Issues getIssues() {
			if (issues == null)
				issues = new IssuesImpl();
			return issues;
		}

		protected void incIndent() {
			indent++;
			indentString += INDENT_STRING;
		}

		protected void decIndent() {
			if (indent > 0) {
				indent--;

				indentString = (indent == 0) ? "" //$NON-NLS-1$
						: indentString.substring(INDENT_STRING.length());
			}
		}

		/**
		 * Helper function that adds a new line if we are in the "global/module"
		 * scope but not if we are in an inner scope.
		 */
		protected void conditionalNewLine() {
			if (currentScopeIs(GLOBAL_SCOPE)) {
				buf.append(String.format("%n")); //$NON-NLS-1$
			}
		}
		
		/**
		 * Add new line before non empty comments
		 * 
		 * @param comments
		 */
		protected void conditionalNewLineForComment(List<IDLComment> comments) {
			if (!comments.isEmpty()) {
				if (comments.size() == 1
						&& (UML2Util.isEmpty(comments.get(0).getBody()) || "<p></p>" //$NON-NLS-1$
								.equals(comments.get(0).getBody()))) {
					// no new line for an empty comment
					return;
				}
				buf.append(String.format("%n")); //$NON-NLS-1$
			}
		}

		protected void pushScope(int scope) {
			scopeStack.push(scope);
			incIndent();
		}

		protected int popScope() {
			decIndent();
			return scopeStack.pop();
		}

		protected boolean currentScopeIs(int scope) {
			if (scope == GLOBAL_SCOPE && scopeStack.isEmpty()) {
				return true;
			}

			return scopeStack.peek().equals(scope);
		}

		@Override
		public Object caseModule(Module mod) {
			String moduleName = mod.getName();

			// build a list of the declarations in this module, all of which
			// are currently undeclared
			Map<String, Definition> undeclareds = new HashMap<String, Definition>();
			for (Definition defn : mod.getDefinitions()) {
				String decl = IdlDeclarationInspector.getDeclaration(defn);
				if (decl != null)
					undeclareds.put(decl, defn);
			}

			conditionalNewLine();

			if (isCommentEnabled()) {
				buf.append(String.format("/// @brief %s %n", moduleName)); //$NON-NLS-1$
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
				for (String reqDecl : IdlDeclarationExaminer
						.getRequiredDecls(d)) {

					if (reqDecl.startsWith(moduleName + "::")) { //$NON-NLS-1$
						reqDecl = reqDecl.substring(moduleName.length() + 2);
					}

					// A forward declaration will be generated, so remove the
					// type
					// from the list of undeclared. This should work because the
					// implementation only looks one level deep, so the
					// declaration
					// won't be needed more than once.
					Definition reqDefn = undeclareds.remove(reqDecl);
					if (reqDefn != null) {
						IdlForwardDeclarationGenerator.generate(buf,
								indentString, reqDefn);
						if (reqDefn instanceof StructTypeImpl) {
							buf.append(String.format("%n")); //$NON-NLS-1$
							buf.append(String
									.format("%sstruct %s;%n", this.indentString, ((StructTypeImpl) reqDefn) //$NON-NLS-1$
													.getName()));
						} else if (reqDefn instanceof UnionTypeImpl) {
							buf.append(String.format("%n")); //$NON-NLS-1$
							buf.append(String
									.format("%sunion %s;%n", this.indentString, ((UnionTypeImpl) reqDefn) //$NON-NLS-1$
													.getName()));
						}
					}
				}

				// Remove the type from the undeclared map before starting to
				// generate it so that children of d will not try to forward
				// declare d.
				String decl = IdlDeclarationInspector.getDeclaration(d);
				if (decl != null)
					undeclareds.remove(decl);

				// generate the type
				doSwitch(d);
			}
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}

		@Override
		public Object caseSpecification(Specification object) {

			String define = "CX_" + fileName.toUpperCase() //$NON-NLS-1$
					.replace(File.separator, "__") //$NON-NLS-1$
					.replace('.', '_');

			buf.append(String.format("#ifndef %s%n#define %s%n", //$NON-NLS-1$
					define, define));

			for (Import_decl i : object.getImports()) {
				buf.append(String.format("#include <%s.idl>%n", //$NON-NLS-1$
						i.getImported_scope()));
			}
			buf.append(String.format("%n")); //$NON-NLS-1$

			for (Definition d : object.getDefinitions()) {
				if (d instanceof IDLComment && !isCommentEnabled()) {
					continue;
				}
				doSwitch(d);
			}

			buf.append(String.format("#endif", define)); //$NON-NLS-1$
			if (isCommentEnabled()) {
				buf.append(String.format(" // %s", define)); //$NON-NLS-1$
			}
			buf.append(String.format("%n")); //$NON-NLS-1$

			return buf.toString();
		}

		@Override
		public Object casePreproc_Pragma_Prefix(Preproc_Pragma_Prefix object) {

			// No matter how many quotes are in the pragma value (0...*), write
			// exactly one.
			buf.append(String
					.format("#pragma prefix \"%s\"%n%n", object.getValue().replaceAll("\"", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return buf.toString();
		}

		@Override
		public Object caseInterface_decl(Interface_decl object) {

			conditionalNewLine();
			if (isCommentEnabled()) {
				buf.append(String.format("%n")); //$NON-NLS-1$
				buf.append(String
						.format("%s///@interface %s %n", indentString, object.getHeader().getName())); //$NON-NLS-1$
				if (!object.getHeader().getComments().isEmpty()) {
					buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
				}
				for (IDLComment comment : object.getHeader().getComments()) {
					doSwitch(comment);
				}
			}

			buf.append(String.format(
					"%s%s%sinterface %s", //$NON-NLS-1$
					indentString,
					object.getHeader().isIsAbstract() ? "abstract " : "", //$NON-NLS-1$//$NON-NLS-2$
					object.getHeader().isIsLocal() ? "local " : "", //$NON-NLS-1$//$NON-NLS-2$
					object.getHeader().getName()));

			short sIdx = 0;
			for (ScopedName spec : object.getHeader().getSpecializes()) {
				buf.append(String.format("%s%s", //$NON-NLS-1$
						sIdx > 0 ? ", " : ": ", doSwitch(spec))); //$NON-NLS-1$//$NON-NLS-2$
				sIdx++;
			}
			buf.append(String.format(" {%n")); //$NON-NLS-1$

			pushScope(INTERFACE_SCOPE);
			for (Export e : object.getInterfaceBody().getExport()) {
				doSwitch(e);
			}
			popScope();
			buf.append(String.format("%s};%n%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}

		@Override
		public Object caseForward_decl(Forward_decl object) {
			conditionalNewLine();
			buf.append(String.format(
					"%sinterface %s%n;", indentString, object.getName())); //$NON-NLS-1$
			return buf.toString();
		}

		@Override
		public Object caseAttrSpec(AttrSpec object) {
			if (object.getType() == null) {
				getIssues()
						.addError(
								String.format(
										"The type of attribute %s, is null. The generated Idl will be incorrect.", object.getNames()), //$NON-NLS-1$
								object);
			}

			if (object.getNames() == null) {
				getIssues()
						.addError(
								"The names of an attribute cannot be null. The generated Idl will be incorrect.", //$NON-NLS-1$
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
			for (String name : object.getNames()) {
				names.append(String.format("%s%s", //$NON-NLS-1$
						idx > 0 ? ATTRIBUTE_SEPERATOR : "", //$NON-NLS-1$
						name));
			}

			buf.append(String.format("%s%s%s %s", //$NON-NLS-1$
					indentString, "attribute ", //$NON-NLS-1$
					doSwitch(object.getType()), names.toString()));

			if ((object.getGetRaises() != null)
					&& (object.getGetRaises().getExceptions() != null)
					&& !object.getGetRaises().getExceptions().getException()
							.isEmpty()) {
				incIndent();
				buf.append(String.format("%n%sgetraises (", indentString)); //$NON-NLS-1$
				doSwitch(object.getGetRaises().getExceptions());
				buf.append(")"); //$NON-NLS-1$
				decIndent();
			}

			if ((object.getSetRaises() != null)
					&& (object.getSetRaises().getExceptions() != null)
					&& !object.getSetRaises().getExceptions().getException()
							.isEmpty()) {
				incIndent();
				buf.append(String.format("%n%ssetraises (", indentString)); //$NON-NLS-1$
				doSwitch(object.getSetRaises().getExceptions());
				buf.append(")"); //$NON-NLS-1$
				decIndent();
			}

			buf.append(String.format(";%n")); //$NON-NLS-1$

			return buf.toString();
		}

		@Override
		public Object caseReadOnlyAttrSpec(ReadOnlyAttrSpec object) {
			if (object.getType() == null) {
				getIssues()
						.addError(
								String.format(
										"The type of attribute %s, is null. The generated Idl will be incorrect.", object.getNames()), //$NON-NLS-1$
								object);
			}

			if (object.getNames() == null) {
				getIssues()
						.addError(
								"The names of an attribute cannot be null. The generated Idl will be incorrect.", //$NON-NLS-1$
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
			for (String name : object.getNames()) {
				names.append(String.format("%s%s", //$NON-NLS-1$
						idx > 0 ? ATTRIBUTE_SEPERATOR : "", //$NON-NLS-1$
						name));
			}

			buf.append(String.format("%s%s%s %s", //$NON-NLS-1$
					indentString, "readonly attribute ", //$NON-NLS-1$
					doSwitch(object.getType()), names.toString()));

			if ((object.getRaises() != null)
					&& (object.getRaises().getExceptions() != null)
					&& !object.getRaises().getExceptions().getException()
							.isEmpty()) {
				incIndent();
				buf.append(String.format("%n%sraises (", indentString)); //$NON-NLS-1$
				doSwitch(object.getRaises().getExceptions());
				buf.append(")"); //$NON-NLS-1$
				decIndent();
			}

			buf.append(String.format(";%n")); //$NON-NLS-1$

			return buf.toString();
		}

		@Override
		public Object caseScopedName(ScopedName object) {
			short idx = 0;
			StringBuffer names = new StringBuffer();
			for (String name : object.getName()) {
				names.append(String.format("%s%s", //$NON-NLS-1$
						idx > 0 ? SCOPE_OPERATOR : "", //$NON-NLS-1$
						name));
			}
			return names.toString();
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseExceptionList(ExceptionList object) {
			StringBuffer exceptions = new StringBuffer();
			short exIdx = 0;
			for (ScopedName ex : object.getException()) {
				buf.append(String.format("%s%s", //$NON-NLS-1$
						exIdx++ > 0 ? ", " : "", //$NON-NLS-2$
						doSwitch(ex)));
			}
			return exceptions;
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseOpDecl(OpDecl object) {
			if (isCommentEnabled()) {
				buf.append(String.format("%n")); //$NON-NLS-1$
				// documentation for Operation
				if (object.getComments().get(0).getBody() != null
						&& object.getComments().get(0).getBody().length() != 0) {
					doSwitch(object.getComments().get(0));
					buf.append(String.format("%s///%n", indentString));
				}
				for (int i = 0; i < object.getParams().getDecls().size(); i++) {
					ParamDcl param = object.getParams().getDecls().get(i);
					IDLComment comment = object.getParams().getComments()
							.get(i);
					String direction = param.getDirection().getLiteral();
					if(direction.equals("return")) {
						continue;
					}
					if (direction.equals("inout")) {
						direction = "in,out";
					}
					buf.append(String.format("%s/// @param[%s] %s%n",
							indentString, direction, param.getName()));
					doSwitch(comment);
					buf.append(String.format("%s///%n", indentString));
				}
				
				if (!"void".equals(((ScopedName) object.getType()).getName()
						.get(0))) {
					buf.append(String.format("%s/// @return%n", indentString));
				}

				if (object.getComments().size() == 2) {
					doSwitch(object.getComments().get(1));
				}
			}

			buf.append(String.format("%s%s%s %s(", //$NON-NLS-1$
					indentString, object.isIsOneway() ? "oneway " : "", //$NON-NLS-1$//$NON-NLS-2$
					doSwitch(object.getType()), object.getName()));

			short pdIdx = 0;

			if (nonReturnParameters(object.getParams()).size() > 0) {
				incIndent();

				for (ParamDcl pd : nonReturnParameters(object.getParams())) {
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
			if (object.getRaises() != null
					&& !object.getRaises().getException().isEmpty()) {
				buf.append(String.format("%n%s%s", indentString, INDENT_STRING));
				if (object.getRaises().getException().size() > 0) {
					buf.append("raises (");
					boolean first = true;
					for (ScopedName ex : object.getRaises().getException()) {
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

		/**
		 * Separates return parameters from the rest of the parameters for an
		 * OpDecl
		 * 
		 * @param operation
		 * @return
		 */
		@SuppressWarnings("nls")
		protected List<ParamDcl> nonReturnParameters(ParameterDecls parameters) {
			List<ParamDcl> retVal = new ArrayList<ParamDcl>();
			for (ParamDcl pd : parameters.getDecls()) {
				if (pd.getDirection().getLiteral() != "NULL" && pd.getDirection().getLiteral() != "return") {
					retVal.add(pd);
				}
			}
			return retVal;
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseParamDcl(ParamDcl object) {
			StringBuffer paramBuf = new StringBuffer();

			switch (object.getDirection().getValue()) {
			case ParamDirection.IN_OUT_VALUE:
				paramBuf.append("inout ");
				break;
			case ParamDirection.IN_VALUE:
				paramBuf.append("in ");
				break;
			case ParamDirection.OUT_VALUE:
				paramBuf.append("out ");
				break;
			case ParamDirection.RETURN_VALUE:
				paramBuf.append("return ");
				break;
			default:
				paramBuf.append("in ");
			}

			paramBuf.append(doSwitch(object.getType()));
			paramBuf.append(" ");
			paramBuf.append(object.getName());

			return paramBuf;
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseExceptDecl(ExceptDecl object) {
			conditionalNewLine();

			if (isCommentEnabled()) {
				buf.append(String.format("%n%s/// @idlexcept %s%n",
						indentString, object.getName()));
				if (!object.getComments().isEmpty()) {
					buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
				}
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}

			buf.append(String.format("%sexception %s {%n", indentString,
					object.getName()));
			this.incIndent();
			for (Member m : object.getMembers()) {
				doSwitch(m);
			}
			this.decIndent();
			buf.append(String.format("%s};%n", indentString));
			conditionalNewLine();
			return buf.toString();
		}

		@SuppressWarnings("nls")
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

			buf.append(String.format("%s%s %s;%n", indentString,
					doSwitch(object.getType()), doSwitch(object.getDecl())));

			return buf;
		}

		/**
		 * A case for a List of Declarators that creates a comma delimited list
		 * of the Declarators following the IDL syntax
		 * 
		 * @param list
		 *            The list of Declarators to be converted to a String
		 * @return A comma delimited string with the Declarators in the list
		 */
		@SuppressWarnings("nls")
		public String caseDeclaratorList(List<Declarator> list) {
			short idx = 0;
			StringBuffer decBuf = new StringBuffer();

			for (Declarator d : list) {
				decBuf.append(String.format("%s%s", idx++ > 0 ? ", " : "",
						d.getId()));
			}

			return decBuf.toString();
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseConstDecl(ConstDecl object) {

			if (isCommentEnabled()) {
				conditionalNewLineForComment(object.getComments());
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}

			String value = "";

			if (object.getType() instanceof StringType) {
				value = "\"" + doSwitch(object.getValue()) + "\"";
			} else if (object.getType() instanceof CharType) {
				value = "'" + doSwitch(object.getValue()) + "'";
			} else {
				value = doSwitch(object.getValue()).toString();
			}

			buf.append(String.format("%sconst %s %s = %s;%n", indentString,
					doSwitch(object.getType()), object.getName(), value));
			conditionalNewLine();
			return buf.toString();
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseStructType(StructType object) {
			conditionalNewLine();
			if (isCommentEnabled()) {
				buf.append(String.format("%n%s/// @struct %s%n", indentString,
						object.getName()));
				if (!object.getComments().isEmpty()) {
					buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
				}
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			buf.append(String.format("%sstruct %s {%n", indentString,
					object.getName()));
			pushScope(DEFINITION_SCOPE);
			for (Member m : object.getMembers()) {
				doSwitch(m);
			}
			popScope();
			buf.append(String.format("%s};%n", indentString));
			conditionalNewLine();
			return buf.toString();
		}

		@SuppressWarnings("nls")
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
		public String casePositiveIntConst(PositiveIntConst expr) {
			return doSwitch(expr.getExp()).toString();
		}

		@Override
		public String caseOrExpr(OrExpr object) {
			// We generate all constant values as strings.
			XOrExpr xor = object.getLhs();
			return doSwitch(xor.getLhs()).toString();
		}

		@Override
		public String caseXOrExpr(XOrExpr object) {
			// We generate all constant values as strings.
			AndExpr and = object.getLhs();
			return doSwitch(and.getLhs()).toString();
		}

		@Override
		public String caseAndExpr(AndExpr object) {
			// We generate all constant values as strings.
			ShiftExpr shift = object.getLhs();
			return doSwitch(shift.getLhs()).toString();
		}

		@Override
		public String caseShiftExpr(ShiftExpr object) {
			// We generate all constant values as strings.
			AddExpr add = object.getLhs();
			return doSwitch(add.getLhs()).toString();
		}

		@Override
		public String caseAddExpr(AddExpr object) {
			// We generate all constant values as strings.
			MultExpr mult = object.getLhs();
			return doSwitch(mult.getLhs()).toString();
		}

		@Override
		public String caseMultExpr(MultExpr object) {
			// We generate all constant values as strings.
			UnaryExpr unary = object.getLhs();
			return doSwitch(unary.getExpr()).toString();
		}

		@Override
		public String caseUnaryExpr(UnaryExpr object) {
			// We generate all constant values as strings.
			ScopedName name = (ScopedName) object.getExpr();
			String retVal = ""; //$NON-NLS-1$
			if (name.getName() != null) {
				for (String s : name.getName()) {
					retVal += s;
				}
			}
			return retVal;
		}

		@SuppressWarnings("nls")
		@Override
		public String caseIDLComment(IDLComment object) {
			if (object == null) {
				return buf.toString();
			}
			String body = object.getBody();

			// Ignore empty documentation
			if (body == null || body.length() == 0 || body.equals("<p></p>")) {
				return buf.toString();
			}

			// get rid of <p> tags, we will replace with a newline
			String regex0 = "(\\n|\\r)?</p>(\\n|\\r)?";
			String regex1 = "<[^>]*>";
			// keep proper indenting
			String regex2 = "(\\r\\n|\\n\\r|\\n|\\r)";

			// Apply the replacements
			body = body.replaceAll(regex0, "\n");
			body = body.replaceAll(regex1, "");
			body = body.replaceAll(regex2, "\n");
			body = body.replaceAll("&lt;", "<");
			body = body.replaceAll("&gt;", ">");
			body = body.replaceAll("&amp;", "&");

			StringBuilder output = new StringBuilder();
			for (String s : body.split("\n")) {
				if ((indentString.length() + s.length() + 4) <= 80) {
					output.append(String.format("%s/// %s%n", indentString, s));
				} else {
					int i = 0;
					while ((indentString.length() + s.length() + 4) > 80) {
						i = s.lastIndexOf(" ", (80 - indentString.length() - 4));
						output.append(String.format("%s/// %s%n", indentString,
								s.substring(0, i)));
						s = s.substring(i + 1);
					}
					if (s.length() > 0) {
						output.append(String.format("%s/// %s%n", indentString,
								s));
					}
				}
			}

			buf.append(output);
			return buf.toString();
		}

		@Override
		public String caseLiteral(Literal object) {
			return object.getValue();
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseEnumType(EnumType object) {
			conditionalNewLine();
			if (isCommentEnabled()) {
				buf.append(String.format("%n%s/// @enum %s%n", indentString,
						object.getName()));
				if (!object.getComments().isEmpty()) {
					buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
					doSwitch(object.getComments().get(0));
				}
			}
			buf.append(String.format("%senum %s {%n", indentString,
					object.getName()));
			pushScope(DEFINITION_SCOPE);
			boolean first = true;
			int commentIdx = 1;
			for (String s : object.getLiteral()) {
				if (!first)
					buf.append(String.format(",%n"));
				if (isCommentEnabled()) {
					IDLComment comment = object.getComments().get(commentIdx++);
					if (comment.getBody() != null
							&& comment.getBody().length() != 0) {
						buf.append(String.format("%n")); //$NON-NLS-1$
						doSwitch(comment);
					}
				}
				buf.append(String.format("%s%s", indentString, s));
				first = false;
			}
			popScope();
			buf.append(String.format("%n%s};%n", indentString));
			conditionalNewLine();
			return buf.toString();
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseNativeType(NativeType object) {
			conditionalNewLine();
			buf.append(String.format("%snative %s;%n", indentString,
					object.getName()));
			conditionalNewLine();
			return buf.toString();
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseTypeDeclarator(TypeDeclarator object) {
			if (isCommentEnabled()) {
				buf.append(String.format("%n%s/// @typedef %s%n", indentString,
						object.getDeclarators().get(0).getId()));
				if (!object.getComments().isEmpty()) {
					buf.append(String.format("%s///%n", indentString)); //$NON-NLS-1$
				}
				for (IDLComment comment : object.getComments()) {
					doSwitch(comment);
				}
			}
			if (!object.getDeclarators().isEmpty()) {
				buf.append(String.format("%stypedef %s %s;%n", indentString,
						doSwitch(object.getType()), doSwitch(object
								.getDeclarators().get(0))));
				conditionalNewLine();
			}
			return buf.toString();
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseArrayDeclarator(ArrayDeclarator object) {

			String retval = object.getId();
			for (int i = 0; i < object.getSize().size(); i++) {
				retval += ("[" + doSwitch(object.getSize().get(i)).toString() + "]");
			}
			return retval;
		}

		@Override
		public Object caseSimpleDeclarator(SimpleDeclarator object) {
			return object.getId();
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseSequenceType(SequenceType object) {
			String returnType = "sequence <";

			if (object.getType() != null) {
				returnType += doSwitch(object.getType());
			}

			if (object.getSize() != null) {
				returnType += ", " + doSwitch(object.getSize());
			}

			returnType += ">";
			return returnType;
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseBooleanType(BooleanType object) {
			return "boolean";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseCharType(CharType object) {
			return "char";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseDoubleType(DoubleType object) {
			return "double";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseWideCharType(WideCharType object) {
			return "wchar";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseUnsignedLongInt(UnsignedLongInt object) {
			return "unsigned long";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseUnsignedLongLongInt(UnsignedLongLongInt object) {
			return "unsigned long long";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseUnsignedShortInt(UnsignedShortInt object) {
			return "unsigned short";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseSignedShortInt(SignedShortInt object) {
			return "short";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseOctetType(OctetType object) {
			return "octet";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseSignedLongLongInt(SignedLongLongInt object) {
			return "long long";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseLongDoubleType(LongDoubleType object) {
			return "long double";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseSignedLongInt(SignedLongInt object) {
			return "long";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseFloatType(FloatType object) {
			return "float";
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseStringType(StringType object) {
			String returnVal = "string";
			if (object.getSize() != null) {
				returnVal += "<" + doSwitch(object.getSize()) + ">";
			}
			return returnVal;
		}

		@SuppressWarnings("nls")
		@Override
		public Object caseWideStringType(WideStringType object) {
			String returnVal = "wstring";
			if (object.getSize() != null) {
				returnVal += "<" + doSwitch(object.getSize()) + ">";
			}
			return returnVal;
		}

		/******************************************************************
		 * 
		 * PRE PROCESSOR ELEMENTS
		 * 
		 *****************************************************************/
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch#casePreproc_Include
		 * (com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include)
		 */
		@Override
		public Object casePreproc_Include(Preproc_Include object) {

			String[] fileChunks;
			if (System.getProperty("os.name").compareTo("Windows") > 0) { //$NON-NLS-1$//$NON-NLS-2$
				// java.util.regex.PatternSyntaxException thrown if using
				// File.separator in Windows.
				fileChunks = this.fileName.split("\\\\"); //$NON-NLS-1$
			} else {
				fileChunks = this.fileName.split(File.separator);
			}

			if (object.getStrValue() != null
					&& fileChunks[fileChunks.length - 1].matches(object
							.getStrValue()) == false) {
				buf.append("#include "); //$NON-NLS-1$
				buf.append(String.format("\"%s\"", //$NON-NLS-1$
						object.getStrValue()));
				buf.append(String.format("%n")); //$NON-NLS-1$
			} else if (object.getValue() != null) {
				StringBuffer includedFile = new StringBuffer();
				for (String fileSegment : object.getValue().getName()) {
					if (includedFile.length() > 0) {
						includedFile.append('.');
					}
					includedFile.append(fileSegment);
				}
				
				if (fileChunks[fileChunks.length - 1].matches(includedFile
						.toString()) == false
						&& !buf.toString().contains(includedFile.toString())) {
					buf.append("#include "); //$NON-NLS-1$
					buf.append('<');
					buf.append(includedFile.toString());
					buf.append('>');
					buf.append(String.format("%n")); //$NON-NLS-1$
				}
			}
			return buf.toString();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch#casePreproc_Ifdef
		 * (com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef)
		 */
		@Override
		public Object casePreproc_Ifdef(Preproc_Ifdef object) {
			buf.append(String.format("%n%s#ifdef %s%n", //$NON-NLS-1$
					indentString, object.getValue()));
			return buf.toString();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch#casePreproc_Ifndef
		 * (com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef)
		 */
		@Override
		public Object casePreproc_Ifndef(Preproc_Ifndef object) {
			buf.append(String.format("%n%s#ifndef %s%n", //$NON-NLS-1$
					indentString, object.getValue()));
			incIndent();
			return buf.toString();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.zeligsoft.domain.omg.corba.dsl.idl.util.IdlSwitch#casePreproc_Endif
		 * (com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Endif)
		 */
		@Override
		public Object casePreproc_Endif(Preproc_Endif object) {
			decIndent();
			buf.append(String.format("%s#endif%n", indentString)); //$NON-NLS-1$
			return buf.toString();
		}
	}

}


