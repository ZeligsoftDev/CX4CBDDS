/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.xtend.codeassist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.internal.xtend.expression.codeassist.LazyVar;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.ast.Around;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.internal.xtend.xtend.types.AdviceContextType;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExpressionFacade;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Type;

public class FastAnalyzer {

	private static final Pattern ENDS_WITH_SINGLE_LINE_COMMENT_PATTERN = Pattern.compile("//.*$");

	private static final Pattern CONTAINS_SINGLE_LINE_COMMENT_PATTERN = Pattern.compile("//.*$", Pattern.MULTILINE);

	private static final Pattern BEGIN_MULTI_LINE_COMMENT_PATTERN = Pattern.compile("/\\*", Pattern.MULTILINE);
	private static final Pattern BEGIN_MULTI_LINE_COMMENT_IN_STRING_PATTERN = Pattern.compile("['\"].*/\\*.*['\"]", Pattern.MULTILINE
			| Pattern.DOTALL);

	private static final Pattern COMPLETE_MULTI_LINE_COMMENT_PATTERN = Pattern.compile("/\\*.*\\*/", Pattern.MULTILINE | Pattern.DOTALL);

	private static final Pattern PARAM_PATTERN = Pattern.compile("([\\[\\]:\\w]+)\\s+([\\w]+)");

	private final static Pattern IMPORT_PATTERN = Pattern.compile("import\\s+([\\w\\:]+)\\s*;");

	private final static Pattern INCOMPLETE_IMPORT_PATTERN = Pattern.compile("import\\s+[\\w\\:]*\\z");

	private final static Pattern EXTENSION_PATTERN = Pattern.compile("extension\\s+([\\w\\:]+)\\s*(reexport)?\\s*;");

	private final static Pattern INCOMPLETE_EXTENSION_PATTERN = Pattern.compile("extension\\s+[\\w\\:]*\\z");

	private final static Pattern FUNCTION_PATTERN = Pattern
			.compile("((\\w+)\\s+)?(create\\s+([\\w:]+)(\\s+(\\w+))?\\s+)?([\\w:]+)\\s*\\(\\s*([\\[\\]:\\w\\s\\,]+)?\\s*\\)\\s*:\\s*[^;]*\\z");

	private final static Pattern AROUND_PATTERN = Pattern
			.compile("around\\s+([\\w:*]+)\\s*\\(\\s*([\\[\\]:\\w\\s\\,]+)?[\\s,*]*\\)\\s*:\\s*[^;]*\\z");

	private final static Pattern TYPEDECL_PATTERN = Pattern.compile("(;|\\A)\\s*\\w+(\\s*\\[\\w+\\]*)?\\s*\\w+\\s*\\(([\\[\\]:\\w\\s,]*)\\z");

	private final static Pattern TYPEDECL_PARAM_PATTERN = Pattern.compile("(,|\\(|\\A)\\s*[\\[\\]:\\w]*\\z");

	private final static Pattern PATTERN_REDUCE_COMMENT_SINGLELINE = Pattern.compile("//.*$", Pattern.MULTILINE);
	// see http://ostermiller.org/findcomment.html
	private final static Pattern PATTERN_REDUCE_COMMENT_MULTILINE = Pattern.compile("/\\*(?:.|[\\n\\r])*?\\*/");
	private final static Pattern PATTERN_REDUCE_STRING = Pattern.compile("(['\"])(?:.|[\\n\\r])*?(['\"])");

	private FastAnalyzer() {
	}

	public static boolean isInsideTypeDeclaration(final String s) {
		final Matcher m = TYPEDECL_PATTERN.matcher(s);
		if (m.find()) {
			return TYPEDECL_PARAM_PATTERN.matcher(m.group(3)).find();
		}
		return false;
	}

	public static boolean isInsideExtensionImport(final String s) {
		final Matcher m = INCOMPLETE_EXTENSION_PATTERN.matcher(s);
		return m.find();
	}

	public static boolean isInsideImport(final String s) {
		final Matcher m = INCOMPLETE_IMPORT_PATTERN.matcher(s);
		return m.find();
	}

	public static boolean isInsideExpression(final String s) {
		final Matcher m1 = AROUND_PATTERN.matcher(s);
		if (!m1.find()) {
			final Matcher m = FUNCTION_PATTERN.matcher(s);
			return m.find();
		}
		return true;
	}

	public static boolean isInsideComment(final String input) {
		final Matcher singleLineCommentMatcher = ENDS_WITH_SINGLE_LINE_COMMENT_PATTERN.matcher(input);
		if (singleLineCommentMatcher.find()) {
			return true;
		}
		final Matcher removeSingleLineCommentsMatcher = CONTAINS_SINGLE_LINE_COMMENT_PATTERN.matcher(input);
		String inputWithoutSingleLineComments = removeSingleLineCommentsMatcher.replaceAll("\n");
		final Matcher beginMultiLineCommentMatcher = BEGIN_MULTI_LINE_COMMENT_PATTERN.matcher(inputWithoutSingleLineComments);
		if (beginMultiLineCommentMatcher.find()) {
			int lastBeginMultiLineComment = -1;
			do {
				lastBeginMultiLineComment = beginMultiLineCommentMatcher.start();
			} while (beginMultiLineCommentMatcher.find());
			final String inputToBeginMultiLineComment = inputWithoutSingleLineComments.substring(0, lastBeginMultiLineComment);
			// the comment begin might be part of a string, like " /* "
			int lastStringBegin = inputToBeginMultiLineComment.lastIndexOf("\"");
			if (lastStringBegin < 0) {
				lastStringBegin = inputToBeginMultiLineComment.lastIndexOf("'");
			}
			if ((lastStringBegin >= 0) && BEGIN_MULTI_LINE_COMMENT_IN_STRING_PATTERN.matcher(input).find()) {
				return false;
			}
			final Matcher completeMultiLineCommentMatcher = COMPLETE_MULTI_LINE_COMMENT_PATTERN.matcher(inputWithoutSingleLineComments);
			// if completeMultiLineComment does not match at the last beginMultiLineComment position,
			// we're inside a multiline comment
			return !completeMultiLineCommentMatcher.find(lastBeginMultiLineComment);
		}
		return false;
	}

	public final static List<String> findImports(final String template) {
		final Matcher m = IMPORT_PATTERN.matcher(template);
		final List<String> result = new ArrayList<String>();
		while (m.find()) {
			result.add(m.group(1));
		}
		return result;
	}

	public final static List<String> findExtensions(final String template) {
		final Matcher m = EXTENSION_PATTERN.matcher(template);
		final List<String> result = new ArrayList<String>();
		while (m.find()) {
			result.add(m.group(1));
		}
		return result;
	}

	public final static Stack<Set<LazyVar>> computeStack(final String toAnalyze) {
		String _toAnalyze = toAnalyze;
		Matcher m = AROUND_PATTERN.matcher(_toAnalyze);
		Pattern p = AROUND_PATTERN;
		final Set<LazyVar> vars = new HashSet<LazyVar>();
		if (!m.find()) {
			m = FUNCTION_PATTERN.matcher(_toAnalyze);
			p = FUNCTION_PATTERN;
			if (m.find()) {
				final int start = m.start();
				_toAnalyze = _toAnalyze.substring(start);
				m = p.matcher(_toAnalyze);
				m.find();
				if (m.group(4) != null) {
					final LazyVar v = new LazyVar();
					v.typeName = m.group(4);
					v.name = m.group(6);
					if (v.name == null) {
						v.name = "this";
					}
					vars.add(v);
				}
				fillParams(vars, m.group(8));
			}
		} else {
			fillParams(vars, m.group(2));
			final LazyVar v = new LazyVar();
			v.typeName = AdviceContextType.TYPE_NAME;
			v.name = Around.CONTEXT_PARAM_NAME;
			vars.add(v);
		}
		final Stack<Set<LazyVar>> stack = new Stack<Set<LazyVar>>();
		stack.push(vars);

		return stack;
	}

	private static void fillParams(final Set<LazyVar> vars, final String params) {
		Matcher m;
		if ((params != null) && !"".equals(params.trim())) {
			final StringTokenizer st = new StringTokenizer(params, ",");
			while (st.hasMoreTokens()) {
				final String param = st.nextToken();
				m = PARAM_PATTERN.matcher(param);
				if (m.find()) {
					final LazyVar v = new LazyVar();
					v.typeName = m.group(1);
					v.name = m.group(2);
					vars.add(v);
				}
			}
		}
	}

	public final static Partition computePartition(final String str) {
		if (isInsideImport(str)) {
			return Partition.NAMESPACE_IMPORT;
		}

		if (isInsideExtensionImport(str)) {
			return Partition.EXTENSION_IMPORT;
		}

		if (isInsideTypeDeclaration(str)) {
			return Partition.TYPE_DECLARATION;
		}

		if (isInsideExpression(str)) {
			return Partition.EXPRESSION;
		}

		if (isInsideComment(str)) {
			return Partition.COMMENT;
		}

		return Partition.DEFAULT;
	}

	public final static ExecutionContext computeExecutionContext(final String str, final ExecutionContext ctx, final List<Extension> extensions) {
		final Partition p = computePartition(str);
		ExecutionContext _ctx = ctx;
		if ((p == Partition.EXPRESSION) || (p == Partition.TYPE_DECLARATION) || (p == Partition.DEFAULT)) {

			final List<String> imports = findImports(str);
			final List<String> extensionImports = findExtensions(str);
			final XtendFile tpl = new XtendFile() {

				private String fqn;

				public String getFullyQualifiedName() {
					return fqn;
				}

				public void setFullyQualifiedName(final String fqn) {
					this.fqn = fqn;
				}

				public String[] getImportedNamespaces() {
					return imports.toArray(new String[imports.size()]);
				}

				public String[] getImportedExtensions() {
					return extensionImports.toArray(new String[extensionImports.size()]);
				}

				public List<Extension> getExtensions() {
					return extensions;
				}

				public void analyze(final ExecutionContext execCtx, final Set<AnalysationIssue> issues) {
					// do nothing
				}

				public List<Extension> getPublicExtensions(final ResourceManager rm, final ExecutionContext execCtx) {
					return extensions;
				}

				public List<Extension> getPublicExtensions(final ResourceManager resourceManager, final ExecutionContext execCtx,
						final Set<String> flowoverCache) {
					return extensions;
				}

				public List<Around> getArounds() {
					return Collections.emptyList();
				}

			};

			_ctx = ctx.cloneWithResource(tpl);
			final Stack<Set<LazyVar>> s = computeStack(str);

			for (Set<LazyVar> vars : s) {
				for (LazyVar v : vars) {
					Type vType = null;
					if (v.typeName != null) {
						vType = _ctx.getTypeForName(v.typeName);
					} else {
						vType = new ExpressionFacade(_ctx).analyze(v.expression, new HashSet<AnalysationIssue>());
						if (v.forEach) {
							if (vType instanceof ParameterizedType) {
								vType = ((ParameterizedType) vType).getInnerType();
							} else {
								vType = null;
							}
						}
					}
					_ctx = _ctx.cloneWithVariable(new Variable(v.name, vType));
				}
			}
		}
		return _ctx;

	}

	/**
	 * Strips off comments and string contents
	 */
	public final static String reduce(final String input) {
		String result = input;
		// empty string contents
		result = PATTERN_REDUCE_STRING.matcher(result).replaceAll("$1$1");
		// strip off comments
		result = PATTERN_REDUCE_COMMENT_MULTILINE.matcher(result).replaceAll("");
		result = PATTERN_REDUCE_COMMENT_SINGLELINE.matcher(result).replaceAll("");
		return result;
	}

}
