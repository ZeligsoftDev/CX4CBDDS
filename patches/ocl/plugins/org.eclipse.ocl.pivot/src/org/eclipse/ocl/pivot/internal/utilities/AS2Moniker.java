/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public class AS2Moniker implements PivotConstantsInternal
{
	public static @NonNull String toString(@NonNull Element pivotElement) {
		AS2Moniker moniker = new AS2Moniker(pivotElement);
		moniker.appendElement(pivotElement);
		String string = moniker.toString();
		assert !"".equals(string) : "Zero length moniker for '" + pivotElement.eClass().getName() + "'";
		assert string != null;
		return string;
	}
	
	private static final Logger logger = LogManager.getLogger(AS2Moniker.class);

	/**
	 * The CS element for which a moniker is required.
	 */
	protected final EObject target;

	/**
	 * The working buffer for the result.
	 */
	private final StringBuilder s = new StringBuilder();
	
	/**
	 * A pivot 2 moniker conversion visitor, if needed.
	 */
//	private AS2MonikerVisitor pivotVisitor = null;

	/**
	 * TemplateParameters that already appear in the result and do not need re-qualification.
	 */
	private List<TemplateParameter> emittedParameters = null;

	public AS2Moniker(@NonNull Element target) {
		this.target = target;
	}

	public void append(char c) {
		s.append(c);
	}
	
	public void append(int i) {
		s.append(i);
	}
	
	public void append(String string) {
		s.append(string != null ? string : "null"); //$NON-NLS-1$
	}
	
	public void appendElement(Element element) {
		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
			append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			append(NULL_MARKER);	
		}
		else if (element.eIsProxy()) {
			append(UNRESOLVED_PROXY_MARKER);	
		}
		else {
			AS2MonikerVisitor as2MonikerVisitor = createAS2MonikerVisitor(element);
			element.accept(as2MonikerVisitor);
		}		
	}
	
	public void appendElement(Element element, Map<TemplateParameter, Type> templateBindings) {
		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
			append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			append(NULL_MARKER);	
		}
		else if (templateBindings != null) {			// FIXME is this needed
			AS2MonikerVisitor nestedAS2MonikerVisitor = new AS2MonikerVisitor(this, templateBindings);
			element.accept(nestedAS2MonikerVisitor);
		}
		else {
			AS2MonikerVisitor as2MonikerVisitor = createAS2MonikerVisitor(element);
			element.accept(as2MonikerVisitor);
		}
	}

	public void appendIndex(EObject eObject) {
		if (eObject != null) {
			EObject parent = eObject.eContainer();
			if (parent != null) {
				Object objects = parent.eGet(eObject.eContainingFeature());
				if (objects instanceof List<?>) {
					append(((List<?>)objects).indexOf(eObject));
					return;
				}
			}
		}
		append(0);
	}

	public void appendLambdaType(Type contextType, List<? extends Type> parameterTypes,
			Type resultType, Map<TemplateParameter, Type> bindings) {
		if (contextType != null) {
			append(MONIKER_OPERATOR_SEPARATOR);
			appendElement(contextType, bindings);
			append(PARAMETER_PREFIX);
			String prefix = ""; //$NON-NLS-1$
			for (Type parameterType : parameterTypes) {
				append(prefix);
				appendElement(parameterType, bindings);
				prefix = PARAMETER_SEPARATOR;
			}
			append(PARAMETER_SUFFIX);
			if (resultType != null) {
				appendElement(resultType, bindings);
			}
		}
	}

/*	protected void appendMultiplicity(MultiplicityElement multiplicityElement) {
		int lower = multiplicityElement.getLower().intValue();
		int upper = multiplicityElement.getUpper().intValue();
		if (upper != 1) {
			append("[");
			append(lower);
//			append(multiplicityElement.isOrdered() ? "S" : "s");
//			append(multiplicityElement.isUnique() ? "U" : "u");
			append(upper);
			append("]");
		}
	} */

	public void appendName(Element monikeredElement) {
		if (monikeredElement instanceof TemplateableElement) {		// FIXME migrate to more specific location
			TemplateableElement unspecializedElement = ((TemplateableElement)monikeredElement).getUnspecializedElement();
			if (unspecializedElement != null) {
				appendName(unspecializedElement);
				return;
			}
		}
		if (monikeredElement instanceof NamedElement) {
			append(((NamedElement) monikeredElement).getName());
		}
		else if (monikeredElement == null) {
//			logger.warn("null for PivotMoniker.appendName()");
			append("/null/");
		}
		else {
			logger.warn("Unsupported PivotMoniker.appendName() for " + monikeredElement.eClass().getName());
			append("/anon/");
		}
	}
	
	public void appendParameters(Operation operation, Map<TemplateParameter, Type> templateBindings) {
		s.append(PARAMETER_PREFIX);
		String prefix = ""; //$NON-NLS-1$
		if (operation instanceof Iteration) {
			Iteration iteration = (Iteration)operation;
			for (Parameter parameter : iteration.getOwnedIterators()) {
				s.append(prefix);
				appendElement(parameter.getType(), templateBindings);
//				appendMultiplicity(parameter);
				prefix = PARAMETER_SEPARATOR;
			}
			if (iteration.getOwnedAccumulators().size() > 0) {
				prefix = ITERATOR_SEPARATOR;
				for (Parameter parameter : iteration.getOwnedAccumulators()) {
					s.append(prefix);
					appendElement(parameter.getType(), templateBindings);
//					appendMultiplicity(parameter);
					prefix = PARAMETER_SEPARATOR;
				}
			}
			prefix = ACCUMULATOR_SEPARATOR;
		}
		for (Parameter parameter : operation.getOwnedParameters()) {
			s.append(prefix);
			appendElement(parameter.getType(), templateBindings);
//			appendMultiplicity(parameter);
			prefix = PARAMETER_SEPARATOR;
		}
		s.append(PARAMETER_SUFFIX);
	}

	public void appendParent(Element element, String parentSeparator) {
		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
			append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			append(NULL_MARKER);	
		}
		else {
			EObject parent = element.eContainer();
			if (parent instanceof Element) {
				appendElement((Element) parent);
				if (parent instanceof TemplateableElement) {
					TemplateSignature ownedTemplateSignature = ((TemplateableElement)parent).getOwnedSignature();
					if (ownedTemplateSignature != null) {
						for (TemplateParameter templateParameter : ownedTemplateSignature.getOwnedParameters()) {
							emittedTemplateParameter(templateParameter);
					}
					}
				}
			}
			else if (element.eIsProxy()) {
				append("<<unresolved-proxy>>");	
			}
			else {
				assert element instanceof Model || element instanceof ExpressionInOCL : element.eClass().getName() + " has no parent";	
			}
		}
		append(parentSeparator);
	}

	public void appendRole(Element object) {
		EStructuralFeature eFeature = object.eContainmentFeature();
		if (eFeature != null) {
			String roleName = roleNames.get(eFeature);
			if (roleName == null) {
				roleName = eFeature.getName();
			}
			append(roleName);
			if (eFeature.isMany()) {
				int index = ((List<?>)object.eContainer().eGet(object.eContainingFeature())).indexOf(object);
				if (index != 0) {
					append(index);
				}
			}
		}
	}

	public void appendTemplateArguments(List<? extends Type> templateArguments, Map<TemplateParameter, Type> templateBindings) {
		if (!templateArguments.isEmpty()) {
			append(TEMPLATE_BINDING_PREFIX);
			String prefix = ""; //$NON-NLS-1$
			for (Type templateArgument : templateArguments) {
				append(prefix);
				appendElement(templateArgument, templateBindings);
				prefix = TEMPLATE_BINDING_SEPARATOR;
			}
			append(TEMPLATE_BINDING_SUFFIX);
		}
	}
	
	public void appendTemplateBindings(TemplateableElement templateableElement, Map<TemplateParameter, Type> bindings) {
		List<TemplateBinding> templateBindings = templateableElement.getOwnedBindings();
		if (!templateBindings.isEmpty()) {
			boolean isSpecialized = isSpecialized(templateBindings, bindings);
			if (!isSpecialized) {			
				s.append(TEMPLATE_SIGNATURE_PREFIX);
				String prefix = ""; //$NON-NLS-1$
				for (TemplateBinding templateBinding : templateBindings) {
					List<TemplateParameterSubstitution> parameterSubstitutions = templateBinding.getOwnedSubstitutions();
					if (parameterSubstitutions.size() > 1) {
						parameterSubstitutions = new ArrayList<TemplateParameterSubstitution>(parameterSubstitutions);
						Collections.sort(parameterSubstitutions, PivotUtil.TemplateParameterSubstitutionComparator.INSTANCE);
					}
					for (TemplateParameterSubstitution templateParameterSubstitution : parameterSubstitutions) {
						s.append(prefix);
						appendName(templateParameterSubstitution.getFormal());
						prefix = TEMPLATE_SIGNATURE_SEPARATOR;
					}
				}
				s.append(TEMPLATE_SIGNATURE_SUFFIX);
			}
			else {
				s.append(TEMPLATE_BINDING_PREFIX);
				String prefix = ""; //$NON-NLS-1$
				for (TemplateBinding templateBinding : templateBindings) {
					List<TemplateParameterSubstitution> parameterSubstitutions = templateBinding.getOwnedSubstitutions();
					if (parameterSubstitutions.size() > 1) {
						parameterSubstitutions = new ArrayList<TemplateParameterSubstitution>(parameterSubstitutions);
						Collections.sort(parameterSubstitutions, PivotUtil.TemplateParameterSubstitutionComparator.INSTANCE);
					}
					for (TemplateParameterSubstitution templateParameterSubstitution : parameterSubstitutions) {
						s.append(prefix);
						appendElement(templateParameterSubstitution.getActual(), bindings);
						prefix = TEMPLATE_BINDING_SEPARATOR;
					}
				}
				s.append(TEMPLATE_BINDING_SUFFIX);
			}
		}
	}

	public void appendTemplateParameters(TemplateableElement templateableElement) {
		TemplateSignature templateSignature = templateableElement.getOwnedSignature();
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			if (!templateParameters.isEmpty()) {
				s.append(TEMPLATE_SIGNATURE_PREFIX);
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameter templateParameter : templateParameters) {
					s.append(prefix);
					emittedTemplateParameter(templateParameter);
					appendName(templateParameter);
					prefix = TEMPLATE_SIGNATURE_SEPARATOR;
				}
				s.append(TEMPLATE_SIGNATURE_SUFFIX);
			}
		}
	}

	public void appendTupleType(Collection<? extends TypedElement> tupleParts) {
		List<TypedElement> parts = new ArrayList<TypedElement>(tupleParts);
		Collections.sort(parts, new Comparator<TypedElement>()
		{
			@Override
			public int compare(TypedElement o1, TypedElement o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		append(TUPLE_SIGNATURE_PREFIX);
		String prefix = "";
		for (TypedElement part : parts) {
			append(prefix);
			appendName(part);
			append(TUPLE_SIGNATURE_TYPE_SEPARATOR);
			Type type = part.getType();
			if (type != null) {
				appendElement(type);
			}
			prefix = TUPLE_SIGNATURE_PART_SEPARATOR;
		}
		append(TUPLE_SIGNATURE_SUFFIX);
	}

	protected @NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull Element element) {
		AS2MonikerVisitor as2MonikerVisitor;
		Resource resource = element.eResource();
		if (resource instanceof ASResource) {
			as2MonikerVisitor = ((ASResource)resource).getASResourceFactory().createAS2MonikerVisitor(this);
		}
		else {
			as2MonikerVisitor = new AS2MonikerVisitor(this);
		}
		return as2MonikerVisitor;
	}

	protected void emittedTemplateParameter(TemplateParameter templateParameter) {
		if (emittedParameters == null) {
			emittedParameters = new ArrayList<TemplateParameter>();
		}
		emittedParameters.add(templateParameter);
	}
	
	public boolean hasEmitted(TemplateParameter templateParameter) {
		return (emittedParameters != null) && emittedParameters.contains(templateParameter);
	}

	protected boolean isSpecialized(List<TemplateBinding> templateBindings, Map<TemplateParameter, Type> bindings) {
		if (bindings == null) {
			return true;
		}
		for (TemplateBinding templateBinding : templateBindings) {
			for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedSubstitutions()) {
				Type actual = templateParameterSubstitution.getActual();
				if (actual == null) {
					return true;
				}
				Type parameterableElement = bindings.get(actual);
				if ((parameterableElement == null) || (parameterableElement != templateParameterSubstitution.getFormal())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return the length of the moniker so far.
	 */
	protected int length() {
		return s.length();
	}

	@Override
	public String toString() {
		return s.toString();
	}
}