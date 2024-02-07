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

package org.eclipse.internal.xtend.xtend.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Bernd Kolb
 * @author Patrick Schoenbach
 * @author Achim Demelt
 * @author Darius Jockel
 * @author Sebastian Zarnekow
 * @author Karsten Thoms
 * @author Aykut Kilic (itemis) - Bug#465802
 */
public abstract class AbstractExtension extends SyntaxElement implements Extension {
	private static final List<DeclaredParameter> EMPTY_DECLARED_PARAMETERS = Collections.<DeclaredParameter> emptyList();
	private final Identifier name;

	private final List<DeclaredParameter> formalParameters;

	protected ExtensionFile file;

	protected boolean cached = false;

	private boolean isPrivate = false;

	public AbstractExtension(final Identifier name, final Identifier returnType, final List<DeclaredParameter> formalParameters,
			final boolean cached, final boolean isPrivate) {
		this.name = name;
		this.formalParameters = ((formalParameters != null) && !formalParameters.isEmpty()) ? formalParameters : EMPTY_DECLARED_PARAMETERS;
		this.returnType = returnType;
		this.cached = cached;
		this.isPrivate = isPrivate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#getFormalParameters()
	 */
	public List<DeclaredParameter> getFormalParameters() {
		return formalParameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#getName()
	 */
	public String getName() {
		return name.toString();
	}

	public Identifier getNameIdentifier() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.internal.xtend.xtend.ast.Extension#getReturnType(org.eclipse .xtend.typesystem.Type[],
	 * org.eclipse.xtend.expression.ExecutionContext, java.util.Set)
	 */
	public final Type getReturnType(final Type[] parameters, final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ExecutionContext _ctx = ctx.cloneWithResource(getExtensionFile());
		return internalGetReturnType(parameters, _ctx, issues);
	}

	protected abstract Type internalGetReturnType(Type[] parameters, ExecutionContext ctx, Set<AnalysationIssue> issues);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#analyze(org.eclipse .expression.ExecutionContext, java.util.Set)
	 */
	public final void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ExecutionContext _ctx = ctx;
		try {
			if (_ctx.getCallback() != null) {
				if (!_ctx.getCallback().pre(this, _ctx)) {
					return;
				}
			}
			final List<DeclaredParameter> params = getFormalParameters();
			final Set<String> usedNames = new HashSet<String>();
			for (DeclaredParameter p : params) {
				final String typeName = p.getType().toString();
				final Type pt = _ctx.getTypeForName(typeName);
				if (pt == null) {
					issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Type not found: " + typeName, p.getType()));
				}
				final String parameterName = p.getName().toString();
				if (!usedNames.add(parameterName)) {
					issues.add(new AnalysationIssue(AnalysationIssue.SYNTAX_ERROR, "Duplicate parameter name: " + parameterName, p.getName()));
				}
				_ctx = _ctx.cloneWithVariable(new Variable(parameterName, pt));
			}
			if (returnType != null) {
				final String returnTypeName = returnType.toString();
				final Type pt = _ctx.getTypeForName(returnTypeName);
				if (pt == null) {
					issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Type not found: " + returnTypeName, returnType));
				}
			}
			try {
				analyzeInternal(_ctx, issues);
			} catch (final RuntimeException ex) {
				_ctx.handleRuntimeException(ex, this, null);
			}
		} finally {
			if (_ctx.getCallback() != null) {
				_ctx.getCallback().post(this, _ctx, null);
			}
		}
	}

	protected void analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		// nothing to do here
	}

	private final Map<List<Object>, Object> cache = new HashMap<List<Object>, Object>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#evaluate(java.lang.Object[], org.eclipse.expression.ExecutionContext)
	 */
	public Object evaluate(final Object[] parameters, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		try {
			if (_ctx.getCallback() != null) {
				if (!_ctx.getCallback().pre(this, _ctx)) {
					return null;
				}
			}
			if (cached) {
				final List<Object> l = Arrays.asList(parameters);
				if (cache.containsKey(l)) {
					return cache.get(l);
				}
			}
			if (getExtensionFile() == null) {
				throw new IllegalStateException("No containing file!");
			}
			_ctx = _ctx.cloneWithResource(getExtensionFile());
			ctx.preTask(this);
			final Object result = evaluateInternal(parameters, _ctx);
			ctx.postTask(this);
			if (cached) {
				cache.put(Arrays.asList(parameters), result);
			}
			return result;
		} catch (final RuntimeException ex) {
			_ctx.handleRuntimeException(ex, this, null);
		} finally {
			if (_ctx.getCallback() != null) {
				_ctx.getCallback().post(this, _ctx, null);
			}
		}
		return null;
	}

	public final void setExtensionFile(final ExtensionFile f) {
		file = f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#getExtensionFile()
	 */
	public ExtensionFile getExtensionFile() {
		return file;
	}

	protected abstract Object evaluateInternal(Object[] parameters, ExecutionContext ctx);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#getParameterNames()
	 */
	public List<String> getParameterNames() {
		final List<String> names = new ArrayList<String>();
		for (DeclaredParameter declaredParameter : getFormalParameters()) {
			names.add(declaredParameter.getName().toString());
		}
		return names;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#init(org.eclipse .expression.ExecutionContext)
	 */
	public void init(final ExecutionContext ctx) {
		if (parameterTypes == null) {
			try {
				parameterTypes = new ArrayList<Type>();
				for (DeclaredParameter declaredParameter : getFormalParameters()) {
					final Type t = ctx.getTypeForName(declaredParameter.getType().toString());
					if (t != null) {
						// bug#312571
						// BNI if the EvaluationException will not be thrown,
						// the ContentAssist will work. (Bug#292770)
						parameterTypes.add(t);
					}
				}
			} catch (final RuntimeException e) {
				parameterTypes = null;
				throw e;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#getReturnType()
	 */
	public Type getReturnType() {
		throw new UnsupportedOperationException();
	}

	private List<Type> parameterTypes = null;

	protected Identifier returnType;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#getParameterTypes()
	 */
	public List<Type> getParameterTypes() {
		return parameterTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#getReturnTypeIdentifier()
	 */
	public Identifier getReturnTypeIdentifier() {
		return returnType;
	}

	private String _stringRepresentation = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#toString()
	 */
	@Override
	public String toString() {
		if (_stringRepresentation == null) {
			_stringRepresentation = (returnType != null ? returnType.toString() + " " : "") + getName() + "(" + paramsToString() + ")";
		}

		return _stringRepresentation;
	}

	private String _outlineRepresentation = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#toOutlineString()
	 */
	public String toOutlineString() {
		if (_outlineRepresentation == null) {
			_outlineRepresentation = getName() + "(" + paramsToOutlineString() + ")" + (returnType != null ? ": " + returnType.toString() : "");
		}
		return _outlineRepresentation;
	}

	private String paramsToString() {
		final StringBuffer buff = new StringBuffer();
		for (final Iterator<DeclaredParameter> iter = getFormalParameters().iterator(); iter.hasNext();) {
			final DeclaredParameter element = iter.next();
			buff.append(element.getType() + " " + element.getName());
			if (iter.hasNext()) {
				buff.append(",");
			}
		}
		return buff.toString();
	}

	private String paramsToOutlineString() {
		final StringBuffer buff = new StringBuffer();
		for (final Iterator<DeclaredParameter> iter = getFormalParameters().iterator(); iter.hasNext();) {
			final DeclaredParameter element = iter.next();
			buff.append(element.getType());
			if (iter.hasNext()) {
				buff.append(", ");
			}
		}
		return buff.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#isPrivate()
	 */
	public boolean isPrivate() {
		return isPrivate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtend.ast.Extension#isCached()
	 */
	public boolean isCached() {
		return cached;
	}

	public String getQualifiedName() {
		return getExtensionFile().getFullyQualifiedName() + "::" + getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (name == null ? 0 : name.hashCode());
		result = (prime * result) + ((parameterTypes == null) ? 0 : parameterTypes.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AbstractExtension other = (AbstractExtension) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (parameterTypes == null) {
			if (other.parameterTypes != null) {
				return false;
			}
		} else if (!parameterTypes.equals(other.parameterTypes)) {
			return false;
		}
		return true;
	}

	protected void checkForAmbiguousDefinitions(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		@SuppressWarnings("unchecked")
		final Set<? extends AbstractExtension> allExtensions = (Set<? extends AbstractExtension>) ctx.getAllExtensions();
		final String fileName = getFileName();
		for (final AbstractExtension ext : allExtensions) {
			if (name.equals(ext.name) && ((line != ext.line) || !fileName.equals(ext.getFileName()))) {
				if (parameterTypes.equals(ext.parameterTypes)) {
					issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Duplicate extension definition: " + toOutlineString(), this,
							false, start));
					issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Duplicate extension definition: " + ext.toOutlineString(), ext,
							false, ext.start));
				}
			}
		}
	}

}
