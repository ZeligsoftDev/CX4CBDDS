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

package org.eclipse.internal.xtend.expression.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.type.baseimpl.BuiltinMetaModel;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 * @author Karsten Thoms (itemis) - maintenance
 * @author Ed Merks - Bug#418156,418240
 * @author Aykut Kilic (itemis) - Bug#480758
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CollectionExpression extends FeatureCall {

	private final Expression closure;

	private final Identifier eleName;

	public CollectionExpression(final Identifier name, final Identifier eleName, final Expression closure) {
		super(name, null);
		this.eleName = eleName;
		this.closure = closure;
	}

	@Override
	protected String toStringInternal() {
		return super.toStringInternal() + "(" + (eleName != null ? eleName.toString() + "|" : "") + closure + ")";
	}

	public Expression getClosure() {
		return closure;
	}

	@Override
	public Object evaluateInternal(final ExecutionContext ctx) {
		Object targetObj = null;
		if (getTarget() == null) {
			final Variable v = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
			if (v != null) {
				targetObj = v.getValue();
			}
		} else {
			targetObj = getTarget().evaluate(ctx);
		}
		if (targetObj == null) {
			return ctx.handleNullEvaluation(this);
		}
		if (!(targetObj instanceof Collection)) {
			throw new EvaluationException("Couldn't call '" + toString() + "' on an object of java type " + targetObj.getClass().getName(), this, ctx);
		}

		String nameValue = getName().toString();
		if (nameValue.equals(SyntaxConstants.COLLECT)) {
			return executeCollect((Collection) targetObj, ctx);
		} else if (nameValue.equals(SyntaxConstants.SELECT)) {
			return executeSelect((Collection) targetObj, ctx);
		} else if (nameValue.equals(SyntaxConstants.SELECTFIRST)) {
			return executeSelectFirst((Collection) targetObj, ctx);
		} else if (nameValue.equals(SyntaxConstants.REJECT)) {
			return executeReject((Collection) targetObj, ctx);
		} else if (nameValue.equals(SyntaxConstants.EXISTS)) {
			return executeExists((Collection) targetObj, ctx);
		} else if (nameValue.equals(SyntaxConstants.NOT_EXISTS)) {
			return executeNotExists((Collection) targetObj, ctx);
		} else if (nameValue.equals(SyntaxConstants.FOR_ALL)) {
			return executeForAll((Collection) targetObj, ctx);
		} else if (nameValue.equals(SyntaxConstants.SORT_BY)) {
			return executeSortBy((Collection) targetObj, ctx);
		} else {
			throw new EvaluationException("Unknown collection operation : " + nameValue, this, ctx);
		}

	}

	private Object executeSortBy(final Collection collection, final ExecutionContext ctx) {
		// Efficiency improvement, see Bug#418240
		class Pair implements Comparable {
			public Object o1;
			public Object o2;
			public Comparable c2;
			public String s2;

			Pair(final Object o1, final Object o2) {
				this.o1 = o1;
				this.o2 = o2;
				if (o2 instanceof Comparable) {
					c2 = (Comparable) o2;
				}
				if (o2 != null) {
					s2 = o2.toString();
				}
			}

			public int compareTo(final Object o) {
				if (this == o) {
					return 0;
				}

				if (o2 == null) {
					return -1;
				}

				// We only use this local to this method and will only compare to other pairs.
				//
				Pair pair = (Pair) o;
				if (pair.o2 == null) {
					return 1;
				}

				try {
					if (c2 != null) {
						return c2.compareTo(pair.o2);
					}
				} catch (Throwable t) {
					// Ignore
				}

				return s2.compareTo(pair.s2);
			}
		}
		List<Pair> pairs = new ArrayList<Pair>();
		final String elementName = getElementName();
		ExecutionContext _ctx; 
		for (Object o : collection) {
		    _ctx = ctx.cloneWithVariable(new Variable(elementName, o));
		    _ctx.preTask(this);
			pairs.add(new Pair(o, closure.evaluate(_ctx)));
			_ctx.postTask(this);
		}
		Collections.sort(pairs);
		List<Object> result = new ArrayList(pairs.size());
		for (Pair pair : pairs) {
			result.add(pair.o1);
		}

		return result;
	}

	private Object executeForAll(final Collection collection, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		String elementName = getElementName();
		for (final Iterator iter = collection.iterator(); iter.hasNext();) {
			_ctx = _ctx.cloneWithVariable(new Variable(elementName, iter.next()));
			_ctx.preTask(this);
			final Object result = closure.evaluate(_ctx);
			_ctx.postTask(this);
			if (!Boolean.TRUE.equals(result)) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	private Object executeExists(final Collection collection, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		String elementName = getElementName();
		for (final Iterator iter = collection.iterator(); iter.hasNext();) {
			_ctx = _ctx.cloneWithVariable(new Variable(elementName, iter.next()));
			_ctx.preTask(this);
			final Object result = closure.evaluate(_ctx);
			_ctx.postTask(this);
			if (Boolean.TRUE.equals(result)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	private Object executeNotExists(final Collection collection, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		String elementName = getElementName();
		for (final Iterator iter = collection.iterator(); iter.hasNext();) {
			_ctx = _ctx.cloneWithVariable(new Variable(elementName, iter.next()));
			_ctx.preTask(this);
			final Object result = closure.evaluate(_ctx);
			_ctx.postTask(this);
			if (Boolean.TRUE.equals(result)) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	private Object executeReject(final Collection collection, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		final Collection resultCol = new ArrayList(collection);
		String elementName = getElementName();
		for (final Iterator iter = collection.iterator(); iter.hasNext();) {
			final Object ele = iter.next();
			_ctx = _ctx.cloneWithVariable(new Variable(elementName, ele));
			_ctx.preTask(this);
			final Object result = closure.evaluate(_ctx);
			_ctx.postTask(this);
			if (Boolean.TRUE.equals(result)) {
				resultCol.remove(ele);
			}
		}
		return resultCol;
	}

	private Object executeSelect(final Collection collection, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		final Collection<Object> resultCol = new ArrayList<Object>();
		String elementName = getElementName();
		for (final Iterator iter = collection.iterator(); iter.hasNext();) {
			final Object ele = iter.next();
			_ctx = _ctx.cloneWithVariable(new Variable(elementName, ele));
			_ctx.preTask(this);
			final Object result = closure.evaluate(_ctx);
			_ctx.postTask(this);
			if (Boolean.TRUE.equals(result)) {
				resultCol.add(ele);
			}
		}
		return resultCol;
	}

	private Object executeSelectFirst(final Collection collection, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		final Collection<Object> resultCol = new ArrayList<Object>();
		String elementName = getElementName();
		for (final Iterator iter = collection.iterator(); iter.hasNext();) {
			final Object ele = iter.next();
			_ctx = _ctx.cloneWithVariable(new Variable(elementName, ele));
			_ctx.preTask(this);
			final Object result = closure.evaluate(_ctx);
			_ctx.postTask(this);
			if (Boolean.TRUE.equals(result)) {
				resultCol.add(ele);
			}
		}
		if (resultCol.size() == 0) {
			return null;
		}
		return resultCol.iterator().next();
	}

	private Object executeCollect(final Collection collection, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		final Collection<Object> resultCol = new ArrayList<Object>();
		String elementName = getElementName();
		for (final Iterator iter = Collections.unmodifiableCollection(collection).iterator(); iter.hasNext();) {
			final Object ele = iter.next();
			_ctx = _ctx.cloneWithVariable(new Variable(elementName, ele));
			_ctx.preTask(this);
			resultCol.add(closure.evaluate(_ctx));
			_ctx.postTask(this);
		}
		return resultCol;
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ExecutionContext _ctx = ctx;
		Type targetType = null;
		if (getTarget() == null) {
			final Variable v = _ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
			if (v != null) {
				targetType = (Type) v.getValue();
			}
		} else {
			targetType = getTarget().analyze(_ctx, issues);
		}
		if (targetType == null) {
			return null;
		}

		if (!(targetType instanceof ParameterizedType)) {
			issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "Collection type expected! was : " + targetType, getTarget()));
			return null;
		}

		final Type innerType = ((ParameterizedType) targetType).getInnerType();
		Type result = null;
		_ctx = _ctx.cloneWithVariable(new Variable(getElementName(), innerType));
		final Type closureType = closure.analyze(_ctx, issues);
		final String nameValue = getName().toString();
		if (nameValue.equals(SyntaxConstants.COLLECT)) {
			final String targetTypeName = targetType.getName();
			if (targetTypeName.startsWith(BuiltinMetaModel.SET)) {
				return _ctx.getSetType(closureType);
			} else if (targetTypeName.startsWith(BuiltinMetaModel.LIST)) {
				return _ctx.getListType(closureType);
			} else {
				return _ctx.getCollectionType(closureType);
			}
		} else if (nameValue.equals(SyntaxConstants.SELECT) || nameValue.equals(SyntaxConstants.REJECT)) {
			return targetType;
		} else if (nameValue.equals(SyntaxConstants.SELECTFIRST)) {
			return innerType;
		} else if (nameValue.equals(SyntaxConstants.SORT_BY)) {
			return _ctx.getListType(innerType);
		} else if (nameValue.equals(SyntaxConstants.TYPE_SELECT)) {
			if (closureType == null) {
				return null;
			}
			return _ctx.getListType(closureType);
		} else if (nameValue.equals(SyntaxConstants.EXISTS) || nameValue.equals(SyntaxConstants.NOT_EXISTS)
				|| nameValue.equals(SyntaxConstants.FOR_ALL)) {
			if (!_ctx.getBooleanType().isAssignableFrom(closureType)) {
				issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "Boolean type expected! was : " + closureType, closure));
			}
			result = _ctx.getBooleanType();
		} else {
			issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Unknown operation : " + nameValue, this));
		}
		return result;
	}

	public String getElementName() {
		return eleName != null ? eleName.toString() : SyntaxConstants.DEFAULT_ELE_NAME;
	}

}
