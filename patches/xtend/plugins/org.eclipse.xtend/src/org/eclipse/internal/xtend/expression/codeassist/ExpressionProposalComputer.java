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

package org.eclipse.internal.xtend.expression.codeassist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.CommonToken;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.internal.xtend.xtend.parser.XtendLexer;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExpressionFacade;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Callable;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.StaticProperty;
import org.eclipse.xtend.typesystem.Type;

public class ExpressionProposalComputer implements ProposalComputer {

	private final static Set<String> operators = new HashSet<String>();
	static {
		operators.add("&&");
		operators.add("/");
		operators.add(".");
		operators.add("==");
		operators.add(">=");
		operators.add(">");
		operators.add("<=");
		operators.add("<");
		operators.add("-");
		operators.add("%");
		operators.add("*");
		operators.add("!=");
		operators.add("!");
		operators.add("||");
		operators.add("+");
	}

	private final static Set<String> stopper = new HashSet<String>();
	static {
		stopper.add("(");
		stopper.add(":");
		stopper.add("?");
		stopper.add("|");
		stopper.add("{");
		stopper.add(",");
	}

	private final static Set<String> methodNames = new HashSet<String>();
	static {
		methodNames.add("collect");
		methodNames.add("exists");
		methodNames.add("notExists");
		methodNames.add("forAll");
		methodNames.add("reject");
		methodNames.add("select");
		methodNames.add("selectFirst");
		methodNames.add("sortBy");
		methodNames.add("typeSelect");
	}

	private final static Set<String> operands = new HashSet<String>();
	static {
		operands.add("collect");
		operands.add("exists");
		operands.add("notExists");
		operands.add("false");
		operands.add("forAll");
		operands.add("null");
		operands.add("reject");
		operands.add("select");
		operands.add("sortBy");
		operands.add("selectFirst");
		operands.add("true");
		operands.add("typeSelect");
	}

	private final static Map<String, String> blockTokens = new HashMap<String, String>();
	static {
		blockTokens.put("(", ")");
		blockTokens.put("{", "}");
	}

	private static final Pattern QUALIFIED_NAME = Pattern.compile("\\W*(.*)(?:::\\w*)$");

	public ExpressionProposalComputer() {
	}

	/**
	 * @param ctx
	 * @return
	 */
	public List<Object> computeProposals(final String txt, final ExecutionContext ctx, final ProposalFactory factory) {
		final String[] s = computePrefixAndTargetExpression(txt);
		final String prefix = s[0];
		final String expressionString = s[1];
		ExecutionContext _ctx = computeExecutionContext(txt, ctx);
		final List<Object> proposals = new ArrayList<Object>();

		if ((prefix.length() > 0) && (expressionString == null)) {
			proposals.addAll(new TypeProposalComputer().computeProposals(txt, _ctx, factory));
		}

		Type implicitVariableType = null;
		if (expressionString != null) {
			final Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
			implicitVariableType = new ExpressionFacade(_ctx).analyze(expressionString, issues);
			if (implicitVariableType == null) {
				return Collections.emptyList();
			}
		}
		if (implicitVariableType == null) {
			// variables
			final Map<String, Variable> vars = _ctx.getVisibleVariables();
			for (String varName : vars.keySet()) {
				if (varName.toLowerCase().startsWith(prefix.toLowerCase())) {
					final Object o = _ctx.getVariable(varName).getValue();
					proposals.add(factory.createVariableProposal(varName, (Type) o, prefix));
				}
			}

			// members and extensions on implicit variable (this)
			final Variable implicitVariable = _ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
			if ((implicitVariable != null) && (implicitVariable.getValue() != null)) {
				implicitVariableType = (Type) implicitVariable.getValue();
				proposals.addAll(getAllMemberProposals(implicitVariableType, prefix, _ctx, factory));
				for (StaticProperty p : implicitVariableType.getAllStaticProperties()) {
					if (p.getName().startsWith(prefix)) {
						proposals.add(factory.createStaticPropertyProposal(p, prefix, false));
					}
				}
			}

			final Set<? extends Extension> exts = _ctx.getAllExtensions();
			for (Extension extension : exts) {
				if (extension.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
					boolean skip = false;
					if (extension.getParameterTypes().size() >= 1) {
						Type firstParameterType = extension.getParameterTypes().get(0);

						if ((implicitVariable != null) && (implicitVariable.getValue() != null)) {
							implicitVariableType = (Type) implicitVariable.getValue();
							if (implicitVariableType.isAssignableFrom(firstParameterType)
									|| firstParameterType.isAssignableFrom(implicitVariableType)) {
								skip = true;
							}
						}
					}
					if (!skip) {
						proposals.add(factory.createExtensionProposal(extension, prefix));
					}
				}
			}

			// Static properties
			Matcher m = QUALIFIED_NAME.matcher(txt);
			if (m.matches()) {
				String typeName = m.group(1);
				implicitVariableType = _ctx.getTypeForName(typeName);
				if (implicitVariableType != null) {
					for (StaticProperty p : implicitVariableType.getAllStaticProperties()) {
						if (p.getName().startsWith(prefix)) {
							proposals.add(factory.createStaticPropertyProposal(p, prefix, false));
						}
					}
				}
			}
		} else {
			// members and extensions on targetType
			proposals.addAll(getAllMemberProposals(implicitVariableType, prefix, _ctx, factory));
		}
		return proposals;
	}

	private final static Pattern COL_OP = Pattern
			.compile("((select|selectFirst|forAll|collect|exists|notExists|reject|forEach|sortBy)\\s*\\(\\s*(\\w+)\\s*\\|)|(\\()|(\\))");

	private final static Pattern LET = Pattern.compile(".*let\\s*(\\w+)\\s*=\\s*([^:]+):([^:]*)");

	public final static ExecutionContext computeExecutionContext(final String txt, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		final Stack<LazyVar> vars = new Stack<LazyVar>();
		Matcher m = LET.matcher(txt);
		while (m.find()) {
			final LazyVar v = new LazyVar();
			v.name = m.group(1);
			v.forEach = false;
			v.expression = m.group(2).trim();
			vars.push(v);
		}
		m = COL_OP.matcher(txt);
		while (m.find()) {
			if (m.group(1) != null) {
				final String[] s = computePrefixAndTargetExpression(txt.substring(0, m.start()));
				final String expressionString = s[1];
				final LazyVar v = new LazyVar();
				v.name = m.group(3);
				v.forEach = true;
				v.expression = expressionString;
				vars.push(v);
			} else if (m.group(4) != null) {
				vars.push(null);
			} else if (m.group(5) != null) {
				vars.pop();
			} else {
				throw new IllegalStateException("Match:" + m.group());
			}
		}
		for (LazyVar v : vars) {
			if (v != null) {
				Type targetType = null;
				final String expressionString = v.expression;
				if (expressionString == null) {
					final Variable var = _ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
					if (var != null) {
						if (var.getValue() instanceof ParameterizedType) {
							targetType = ((ParameterizedType) var.getValue()).getInnerType();
						}
					}
				} else {
					targetType = new ExpressionFacade(_ctx).analyze(expressionString, new HashSet<AnalysationIssue>());
					if (v.forEach) {
						if (targetType instanceof ParameterizedType) {
							targetType = ((ParameterizedType) targetType).getInnerType();
						} else {
							targetType = null;
						}
					}
				}

				if (targetType != null) {
					_ctx = _ctx.cloneWithVariable(new Variable(v.name, targetType));
				}
			}
		}
		return _ctx;
	}

	/**
	 * Computes the list of proposals for a type. These proposals are:
	 * <ol>
	 * <li>Owned features of the type: {@link Property}, {@link StaticProperty} or {@link Operation}.
	 * <li>Extensions whose first parameter is of type <code>targetType</code>
	 * <li>For parametrized types all features of the parameter type
	 * </ol>
	 * 
	 * @param _targetType
	 *            Type to search for proposals
	 * @param prefix
	 *            A prefix the proposals must match
	 * @param ctx
	 *            Current execution context
	 * @param factory
	 *            Factory to use for proposal creation
	 * @return All proposals matching <code>prefix</code> for <code>targetType</code>
	 */
	private final static List<Object> getAllMemberProposals(final Type targetType, final String prefix, final ExecutionContext ctx,
			final ProposalFactory factory) {
		if (targetType == null) {
			return Collections.emptyList();
		}
		final List<Object> result = new ArrayList<Object>();
		final Set<String> nameCache = new HashSet<String>();
		Type _targetType = targetType;
		result.addAll(addFeatureProposals(_targetType, prefix, factory, nameCache));
		getAllExtensionProposals(_targetType, prefix, ctx, factory, result, nameCache);

		if (_targetType instanceof ParameterizedType) {
			result.addAll(getAllCollectionOperations(prefix, factory));
			_targetType = ((ParameterizedType) _targetType).getInnerType();
			result.addAll(addFeatureProposals(_targetType, prefix, factory, nameCache));
			getAllExtensionProposals(_targetType, prefix, ctx, factory, result, nameCache);
		}
		return result;
	}

	private static void getAllExtensionProposals(final Type targetType, final String prefix, final ExecutionContext ctx,
			final ProposalFactory factory, final List<Object> result, final Set<String> nameCache) {
		// get all extensions whose first parameter is compatible with
		// 'targetType'
		Set<? extends Extension> extensions = ctx.getAllExtensions();
		for (Extension extension : extensions) {
			if (extension.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
				if (extension.getParameterTypes().size() >= 1) {
					Type firstParameterType = extension.getParameterTypes().get(0);
					if (firstParameterType.isAssignableFrom(targetType)) {
						if (!factory.isDuplicate(nameCache, extension)) {
							result.add(factory.createExtensionOnMemberPositionProposal(extension, prefix, false));
						}
					}
				}
			}
		}
	}

	private static List<Object> addFeatureProposals(final Type targetType, final String prefix, final ProposalFactory factory,
			final Set<String> nameCache) {
		List<Object> result = new ArrayList<Object>();
		Set<? extends Callable> s = targetType.getAllFeatures();
		for (final Callable f : s) {
			Object proposal = null;
			if (f.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
				if (f instanceof Property) {
					proposal = factory.createPropertyProposal((Property) f, prefix, false);
				} else if (f instanceof Operation) {
					if (Character.isJavaIdentifierStart(f.getName().charAt(0))) {
						proposal = factory.createOperationProposal((Operation) f, prefix, false);
					}
				}
			}
			if ((proposal != null) && !factory.isDuplicate(nameCache, f)) {
				factory.addToCache(nameCache, f);
				result.add(proposal);
			}
		}
		return result;
	}

	private static List<Object> getAllCollectionOperations(final String prefix, final ProposalFactory f) {
		final List<Object> result = new ArrayList<Object>();
		final String marked = "expression-with-e";

		String s = "select(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "reject(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "selectFirst(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "collect(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "exists(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "notExists(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "forAll(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "sortBy(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "typeSelect(Type)";
		if (s.startsWith(prefix)) {
			result.add(f.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf("Type"), "Type".length()));
		}

		return result;
	}

	/**
	 * @param str
	 * @return
	 */
	public final static String[] computePrefixAndTargetExpression(final String str) {
		final ReverseScanner scanner = new ReverseScanner(str);
		String prefix = "";
		final String expr = null;

		try {
			CommonToken t = scanner.previousToken();
			if (t != null) {
				// prefix consists of identifier parts
				if (!Character.isWhitespace(str.charAt(str.length() - 1))) {
					if (Character.isJavaIdentifierStart(t.getText().charAt(0))) {
						prefix = t.getText();
						t = scanner.previousToken(); // go to operator
					}
				}

				final int exprEnd = scanner.getOffset();
				// if t is a dot there is a target expression
				if ((t != null) && ".".equals(t.getText())) {
					boolean lastWasOperator = true;
					boolean stop = false;
					while (!stop && ((t = scanner.previousToken()) != null)) {
						if (isOperand(t)) {
							if (lastWasOperator) {
								lastWasOperator = false;
							} else { // two operands in sequence -> stopper!
								scanner.nextToken();
								stop = true;
							}
						} else if (".".equals(t.getText())) {
							if (!lastWasOperator) {
								lastWasOperator = true;
							} else {
								// errorneous expression
								return new String[] { prefix, expr };
							}
						} else if (isBlockCloser(t) && lastWasOperator) {
							lastWasOperator = false;
							final Stack<CommonToken> s = new Stack<CommonToken>();
							s.push(t);
							while (!s.isEmpty()) {
								final CommonToken temp = scanner.previousToken();
								if (temp == null) {
									return new String[] { prefix, expr };
								}
								if (temp.getType() == t.getType()) {
									s.push(temp);
								} else if (isOpposite(temp, t)) {
									s.pop();
								}
							}
							if (")".equals(t.getText())) {
								// we have an unambigous syntax here
								// a.method(with.param)
								// but also
								// anIdentifier
								// (another.parenthesized.expressions)
								final CommonToken previousToken = scanner.previousToken();
								if (!isMethodName(previousToken)) {
									scanner.nextToken();
								}
							}
						} else {
							scanner.nextToken(); // go one forward
							stop = true;
						}
					}
					return new String[] { prefix, str.substring(scanner.getOffset(), exprEnd).trim() };
				}
			}
			return new String[] { prefix, expr };
		} catch (final Exception e) {
			return new String[] { prefix, expr };
		}
	}

	private final static boolean isMethodName(final CommonToken token) {
		if (token != null) {
			return (token.getType() == XtendLexer.Identifier) || methodNames.contains(token.getText());
		}
		return false;
	}

	private final static boolean isOpposite(final CommonToken left, final CommonToken right) {
		final String temp = blockTokens.get(left.getText());
		return (temp != null) && right.getText().equals(temp);
	}

	private final static boolean isBlockCloser(final CommonToken t) {
		return blockTokens.values().contains(t.getText());
	}

	private final static boolean isOperand(final CommonToken t) {
		return (t.getType() == XtendLexer.Identifier) || (t.getType() == XtendLexer.IntLiteral) || (t.getType() == XtendLexer.StringLiteral)
				|| operands.contains(t.getText());
	}

}
