/*******************************************************************************
 * Copyright (c) 2005 - 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xtend.expression.debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.mwe.core.debug.model.NameValuePair;
import org.eclipse.emf.mwe.core.debug.model.SyntaxElement;
import org.eclipse.emf.mwe.core.debug.processing.ElementAdapter;
import org.eclipse.internal.xtend.expression.ast.ChainExpression;
import org.eclipse.internal.xtend.expression.ast.CollectionExpression;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.FeatureCall;
import org.eclipse.internal.xtend.expression.ast.ISyntaxElement;
import org.eclipse.internal.xtend.expression.ast.LetExpression;
import org.eclipse.internal.xtend.expression.ast.Literal;
import org.eclipse.internal.xtend.expression.ast.OperationCall;
import org.eclipse.internal.xtend.type.baseimpl.PolymorphicResolver;
import org.eclipse.internal.xtend.xtend.ast.AbstractExtensionDefinition;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Callable;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.Type;

/**
 * The ElementAdapter implementation for expressions.
 * 
 * @author Bernd Kolb
 * @author Clemens Kadura (zAJKa)
 * @author Karsten Thoms (itemis) - maintenance
 * @author Aykut Kilic (itemis) - Bug#465802,480646,480645,482602
 */
public class ExpressionElementAdapter implements ElementAdapter {

	public static final String TYPE = "expression";

	protected ExecutionContext context;

	protected ExpressionModelPresentation pres;

	protected Set<BaseSpecialTreatment> specials = new HashSet<BaseSpecialTreatment>();

	// -------------------------------------------------------------------------

	public ExpressionElementAdapter() {
		specials.add(new NoResourceSpecial());
		pres = new ExpressionModelPresentation(specials);
	}

	// -------------------------------------------------------------------------

	public ExecutionContext getContext() {
		return context;
	}

	public void setContext(final Object context) {
		this.context = (ExecutionContext) context;
	}

	public String getAdapterType() {
		return TYPE;
	}

	// -------------------------------------------------------------------------

	public boolean canHandle(final Object element) {
		String fileName = null;

		if (element instanceof org.eclipse.internal.xtend.expression.ast.SyntaxElement)
			fileName = ((org.eclipse.internal.xtend.expression.ast.SyntaxElement) element).getFileName();

		if (element instanceof SyntaxElement)
			fileName = ((SyntaxElement) element).resource;

		if (fileName == null)
			return false;

		return fileName.endsWith(".ext") || fileName.endsWith(".chk");
	}

	public boolean shallHandle(final Object element) {
		// shallHandle is only processed by the CommandRuntimeHandler
		return element instanceof org.eclipse.internal.xtend.expression.ast.SyntaxElement;
	}

	public boolean shallSuspend(final Object element, final int flag) {
		boolean result = true;
		for (final BaseSpecialTreatment special : specials) {
			result &= !special.shallNotSuspend(element, flag, context);
		}
		if (element instanceof FeatureCall) {
			String fileName = ((FeatureCall) element).getFileName();
			result &= (fileName != null) && !fileName.equals("nofile");
		}

		return result;
	}
	
	/**
	 * @since 2.2
	 */
	
	public boolean shallAddToCallStack(Object element) {
		if( element instanceof FeatureCall && !(element instanceof CollectionExpression)) return false;
		
		return true;
	}

	public SyntaxElement createElement(final Object element) {
		final SyntaxElement to = pres.getStartPresentation((ISyntaxElement) element, context);
		for (final BaseSpecialTreatment special : specials) {
			special.adaptSyntaxElement(to, element);
		}
		return to;
	}

	public boolean isSurroundingElement(final Object element) {
		return false;
	}

	public SyntaxElement createEndElementTO(final Object element) {
		// TODO: CK: low: decide where end location is available and set it here
		return pres.getEndPresentation((org.eclipse.internal.xtend.expression.ast.SyntaxElement) element, context);
	}

	public String getVariableDetailRep(final Object element) {
		return pres.getStringRep(element);
	}

	public String getVariableSimpleRep(final Object element) {
		return pres.getVariableSimpleRep(element, context);
	}

	public boolean checkVariableHasMembers(final Object element) {
		if (element instanceof Collection<?>)
			return !((Collection<?>) element).isEmpty();
		if (element instanceof Type) {
			final Type t = (Type) element;
			return t.getAllProperties().size() > 0;
		}
		return context.getType(element).getAllProperties().size() > 0;
	}

	@SuppressWarnings("unchecked")
	public List<NameValuePair> getVariables(final Object element) {
		if (element instanceof ChainExpression || element instanceof Literal)
			return Collections.EMPTY_LIST;
		if (element instanceof OperationCall) {
			final ArrayList<NameValuePair> result = getAllVisibleVariables();

			final Map<String, Variable> visibleVariables = context.getVisibleVariables();

			final Expression[] params = ((OperationCall) element).getParams();
			for (final Expression expression : params) {
				if (expression instanceof FeatureCall && !(expression instanceof OperationCall)) {
					final FeatureCall fc = (FeatureCall) expression;
					if (!visibleVariables.containsKey(fc.toString())) {
						result.addAll(evaluateFeatureCall(fc));
					}
				}
			}

			final Expression target = ((OperationCall) element).getTarget();
			if (target instanceof FeatureCall && !(target instanceof OperationCall)) {
				if (!visibleVariables.containsKey(target.toString())) {
					final FeatureCall fc = (FeatureCall) target;
					result.addAll(evaluateFeatureCall(fc));
				}

			}

			return result;
		}
		
		if(element instanceof AbstractExtensionDefinition 
				|| element instanceof LetExpression 
				|| element instanceof CollectionExpression) {
		  final Type type = context.getType(element);
	      List<NameValuePair> props = getAllPropertiesFor(type, element);
	      for (Entry<String, Variable> entry : context.getVisibleVariables().entrySet()) {
	        Variable var = entry.getValue();
	        props.add(new NameValuePair(entry.getKey(), var.getValue()));
	      }
	      return props;
		}
		if (element instanceof FeatureCall)
			return evaluateFeatureCall((FeatureCall) element);
		if (element instanceof Collection<?>) {
			final List<NameValuePair> result = new ArrayList<NameValuePair>();
			final Collection<?> col = (Collection<?>) element;
			int i = 0;
			for (final Object object : col) {
				result.add(new NameValuePair("[" + i + "]", object));
				i++;
			}
			return result;
		}
		final Type type = context.getType(element);
		return getAllPropertiesFor(type, element);
	}

	public Object findElement(final SyntaxElement se, final Object actual, final int flag) {
		if (actual == null)
			return null;
		if (actual instanceof FeatureCall) {
			final FeatureCall fc = (FeatureCall) actual;
			final int start = fc.getStart();
			if (se.resource.endsWith(this.pres.getStringRep(fc.getFileName())) && (se.start == start))
				return actual;
		}
		return null;
	}

	// -------------------------------------------------------------------------

	protected ArrayList<NameValuePair> getAllVisibleVariables() {
		final ArrayList<NameValuePair> result = new ArrayList<NameValuePair>();
		final Map<String, Variable> visibleVariables = context.getVisibleVariables();

		for (final Entry<String, Variable> nameValuePair : visibleVariables.entrySet()) {
			result.add(new NameValuePair(nameValuePair.getKey(), nameValuePair.getValue().getValue()));
		}
		return result;
	}

	private List<NameValuePair> evaluateFeatureCall(final FeatureCall fc) {
		return getEvalResultProperties(fc.toString(), fc.evaluate(context.cloneWithoutMonitor()));
	}

	private List<NameValuePair> getEvalResultProperties(final String prefix, final Object evaluate) {
		final ArrayList<NameValuePair> result = new ArrayList<NameValuePair>();
		if (evaluate instanceof Collection<?>) {
			result.add(new NameValuePair(prefix, evaluate));
			return result;
		}
		final Type type = context.getType(evaluate);
		return getAllPropertiesFor(type, evaluate);
	}

	// Hint: We don't use the AbstractTypeImpl collection of all properties,
	// because it collects methods with the
	// same name from superclasses twice. We take only the most specialized
	// method here (as in Java)
	// Is this a bug or intended that way in AbstractTypeImpl? (TODO: ask Sven
	// or Arno)
	private List<NameValuePair> getAllPropertiesFor(final Type type, final Object element) {
		final ArrayList<NameValuePair> result = new ArrayList<NameValuePair>();

		for (final Property p : getAllProperties(type)) {
			final String name = p.getName();
			if (!(name.equals("wait") || name.startsWith("notify"))) {
				Object value = null;
				try {
					value = p.get(element);
				}
				catch (final Exception e) {
					value = "Error: " + e.getMessage();
				}
				if (value != null) {
					result.add(new NameValuePair(name, value));
				}
			}
		}
		return result;
	}

	// -------------------------------------------------------------------------
	// see AbstractTypeImpl

	private final Map<Type, Map<String, Callable>> typeCache = new HashMap<Type, Map<String, Callable>>();

	private Set<? extends Property> getAllProperties(final Type type) {
		return PolymorphicResolver.select(getAllFeatures(type), Property.class);
	}

	public final Set<Callable> getAllFeatures(final Type type) {
		Map<String, Callable> allFeatures;
		if (typeCache.containsKey(type)) {
			allFeatures = typeCache.get(type);
		}
		else {
			allFeatures = new HashMap<String, Callable>();
			final Callable[] contribs = ((AbstractTypeImpl) type).getContributedFeatures();
			addIfNotExist(allFeatures, Arrays.asList(contribs));
			for (final Type superType : type.getSuperTypes()) {
				if (superType != null) {
					addIfNotExist(allFeatures, getAllFeatures(superType));
				}
			}
			typeCache.put(type, allFeatures);
		}
		final Set<Callable> result = new HashSet<Callable>();
		result.addAll(allFeatures.values());
		return result;
	}

	private void addIfNotExist(final Map<String, Callable> all, final Collection<Callable> more) {
		for (final Callable one : more) {
			final String name = one.getName();
			if (!all.containsKey(name)) {
				all.put(name, one);
			}
		}
	}

}
