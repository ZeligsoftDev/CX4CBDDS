/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Pseudostate;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Transition;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;

/**
 * The AS2XMIidVisitor generates an xmi:id for an AS element. Using one of three policies.
 * <p>
 * null - no xmi:id generated - saves space
 * <p>
 * false - xmi:id generated/reuses UUID - UUID only used internally so no need for predicatability
 * <p>
 * true - xmi:id generated/reuses friendly name - ID may be independently generated - must be predictable
 * <p>
 * Simple elements such as Package/Type/Property get a dot-separated hierarchical name.
 * <p>
 * Operations get a dot-separated hierarchical name suffixed by dot-dot-separated argument types.
 * <p>
 * Internally referenceable elements such as TemplateSignature get a UUID, reusing any xmi:id provided
 * in the context Moniker to XMIId Map.
 *
 */
@Deprecated /* @deprecated only used to generate legacy Model.xmiidVersion 0 xmiids */
public class AS2XMIidVisitor extends AbstractExtendingVisitor<@Nullable Boolean, @NonNull AS2XMIid>
{
	public static final int OVERFLOW_LIMIT = 1024;
	public static final @NonNull String OVERFLOW_MARKER = "##"; //$NON-NLS-1$

	public static final @NonNull String NULL_MARKER = "-null-element-"; //$NON-NLS-1$

	public static final @NonNull String FRAGMENT_SEPARATOR = "#"; //$NON-NLS-1$

	public static final @NonNull String ACCUMULATOR_PREFIX = "a"; //$NON-NLS-1$
	/**
	 * @since 1.4
	 */
	public static final @NonNull String ANNOTATION_PREFIX = "a."; //$NON-NLS-1$
	public static final @NonNull String BODYCONDITION_PREFIX = "c="; //$NON-NLS-1$
	/**
	 * @since 1.1
	 */
	public static final @NonNull String ENUMERATION_LITERAL_PREFIX = "e."; //$NON-NLS-1$
	public static final @NonNull String INVARIANT_PREFIX = "ci"; //$NON-NLS-1$
	public static final @NonNull String ITERATION_PREFIX = "i."; //$NON-NLS-1$
	public static final @NonNull String ITERATOR_PREFIX = "i"; //$NON-NLS-1$
	public static final @NonNull String OPERATION_PREFIX = "o."; //$NON-NLS-1$
	/**
	 * @since 1.3
	 */
	public static final @NonNull String OPPOSITE_PROPERTY_PREFIX = "op."; //$NON-NLS-1$
	public static final @NonNull String PARAMETER_PREFIX = "p"; //$NON-NLS-1$
	public static final @NonNull String PACKAGE_PREFIX = "P."; //$NON-NLS-1$
	public static final @NonNull String POSTCONDITION_PREFIX = "c+"; //$NON-NLS-1$
	public static final @NonNull String PRECONDITION_PREFIX = "c-"; //$NON-NLS-1$
	public static final @NonNull String PRECEDENCE_PREFIX = "Z."; //$NON-NLS-1$
	/**
	 * @since 1.4
	 */
	public static final @NonNull String PROFILE_APPLICATION_PREFIX = "pa."; //$NON-NLS-1$
	public static final @NonNull String PROPERTY_PREFIX = "p."; //$NON-NLS-1$
	/**
	 * @since 1.4
	 */
	public static final @NonNull String STEREOTYPE_EXTENDER_PREFIX = "se."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_PARAMETER_PREFIX = "t."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_SIGNATURE_PREFIX = "s."; //$NON-NLS-1$
	public static final @NonNull String TYPE_PREFIX = "T."; //$NON-NLS-1$

	public static final @NonNull String OPERATION_PARAMETER_SEPARATOR = ".."; //$NON-NLS-1$
	public static final @NonNull String SCOPE_SEPARATOR = "."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_PARAMETER_SEPARATOR = ".."; //$NON-NLS-1$

	protected final @NonNull StringBuilder s = new StringBuilder();

	public AS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}

	protected void appendName(@Nullable String name) {
		if (name == null) {
			s.append(NULL_MARKER);
		}
		else {
			for (int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				if (('0' <= c) && (c <= '9')) {
					s.append(c);
				}
				else if (('A' <= c) && (c <= 'Z')) {
					s.append(c);
				}
				else if (('a' <= c) && (c <= 'z')) {
					s.append(c);
				}
				else if (c == '_') {
					s.append(c);
				}
				else if (c == '$') {
					s.append(c);
				}
				else if (c == '%') {
					s.append("%%");
				}
				else {
					s.append("%");
					s.append((int)c);
					s.append("%");
				}
			}
		}
	}

	protected void appendNameOf(@NonNull Object element) {
		if (element instanceof Nameable) {
			s.append(((Nameable)element).getName());
		}
		else {
			s.append(System.identityHashCode(element));
		}
	}

	protected void appendOperation(Operation object) {
		appendParent(object);
		appendName(object.getName());
		List<Parameter> parameters = object instanceof Iteration ? ((Iteration)object).getOwnedIterators() : object.getOwnedParameters();
		for (Parameter parameter : parameters) {
			s.append(OPERATION_PARAMETER_SEPARATOR);
			appendType(parameter.getType());
		}
	}

	protected void appendParent(@Nullable EObject element) {
		if (toString().length() >= OVERFLOW_LIMIT) {
			s.append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			s.append(NULL_MARKER);
			s.append(SCOPE_SEPARATOR);
		}
		else {
			EObject eContainer = element.eContainer();
			if (eContainer instanceof Model) {
			}
			else if (eContainer != null) {
				//				if (!(eContainer instanceof TemplateParameter)) {
				appendParent(eContainer);
				//				}
				appendNameOf(eContainer);
				s.append(SCOPE_SEPARATOR);
			}
		}
	}

	protected void appendType(@Nullable Type type) {
		if (type == null) {
			s.append(NULL_MARKER);
		}
		else {
			if (type.isClass() != null) {
				appendParent(type);
			}
			appendName(type.getName());
		}
	}

	public @Nullable String getID(@NonNull Element element, boolean internalUUIDs) {
		Boolean status = element.accept(this);
		if (status == null) {
			return null;
		}
		else if (status) {
			return s.toString();
		}
		else {
			return context.getID(element, internalUUIDs);
		}
	}

	@Override
	public String toString() {
		return s.toString();
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable Boolean visitAnnotation(@NonNull Annotation object) {
		return false;
	}

	@Override
	public Boolean visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		if (Orphanage.isTypeOrphanage(object.getOwningPackage())) {
			return false;
		}
		String name = object.getName();
		if (PivotConstantsInternal.WILDCARD_NAME.equals(name)) {
			if (Orphanage.isTypeOrphanage(PivotUtil.getContainingPackage(object))) {
				return false;
			}
		}
		s.append(TYPE_PREFIX);
		appendParent(object);
		appendName(name);
		return true;
	}

	@Override
	public @Nullable Boolean visitCollectionType(@NonNull CollectionType object) {
		if (object.getOwnedBindings().isEmpty()) {
			appendName(object.getName());
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public @Nullable Boolean visitConstraint(@NonNull Constraint object) {
		String name = object.getName();
		if ((name != null) && !"".equals(name)) {
			EReference eContainmentFeature = object.eContainmentFeature();
			if (eContainmentFeature == PivotPackage.Literals.OPERATION__OWNED_PRECONDITIONS) {
				s.append(PRECONDITION_PREFIX);
			}
			else if (eContainmentFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
				s.append(BODYCONDITION_PREFIX);
			}
			else if (eContainmentFeature == PivotPackage.Literals.OPERATION__OWNED_POSTCONDITIONS) {
				s.append(POSTCONDITION_PREFIX);
			}
			else {
				s.append(INVARIANT_PREFIX);
			}
			appendParent(object);
			appendName(name);
			return true;
		}
		return null;
	}


	@Override
	public @Nullable Boolean visitElement(@NonNull Element object) {
		return null;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public Boolean visitEnumerationLiteral(@NonNull EnumerationLiteral object) {
		String name = object.getName();
		if (name != null) {
			s.append(ENUMERATION_LITERAL_PREFIX);
			appendParent(object);
			appendName(name);
			return true;
		}
		return true;
	}

	@Override
	public @Nullable Boolean visitLambdaType(@NonNull LambdaType object) {
		return false;
	}

	@Override
	public Boolean visitIteration(@NonNull Iteration object) {
		s.append(ITERATION_PREFIX);
		appendOperation(object);
		return true;
	}

	@Override
	public @Nullable Boolean visitMapType(@NonNull MapType object) {
		if (object.getOwnedBindings().isEmpty()) {
			appendName(object.getName());
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public @Nullable Boolean visitOperation(@NonNull Operation object) {
		s.append(OPERATION_PREFIX);
		appendOperation(object);
		return true;
	}

	@Override
	public @Nullable Boolean visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		String name = object.getName();
		if (name != null) {
			s.append(PACKAGE_PREFIX);
			appendParent(object);
			appendName(name);
			return true;
		}
		else if (object.getURI() != null) {
			appendName(object.getURI());
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public @Nullable Boolean visitParameter(@NonNull Parameter object) {
		Operation operation = (Operation)object.eContainer();
		int index = operation.getOwnedParameters().indexOf(object);
		if (index >= 0) {
			s.append(PARAMETER_PREFIX);
			s.append(index);
		}
		else if (operation instanceof Iteration) {
			Iteration iteration = (Iteration)operation;
			index = iteration.getOwnedIterators().indexOf(object);
			if (index >= 0) {
				s.append(ITERATOR_PREFIX);
				s.append(index);
			}
			else {
				index = iteration.getOwnedAccumulators().indexOf(object);
				if (index >= 0) {
					s.append(ACCUMULATOR_PREFIX);
					s.append(index);
				}
			}
		}
		operation.accept(this);
		return true;
	}

	@Override
	public @Nullable Boolean visitPrecedence(@NonNull Precedence object) {
		s.append(PRECEDENCE_PREFIX);
		appendName(object.getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitPrimitiveType(@NonNull PrimitiveType object) {
		appendName(object.getName());
		return true;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable Boolean visitProfileApplication(@NonNull ProfileApplication object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitProperty(@NonNull Property object) {
		EObject eContainer = object.eContainer();
		if (eContainer instanceof TupleType) {
			return false;	// TupleParts of synthesized types use UUIDs
		}
		String name = object.getName();
		Property opposite = object.getOpposite();
		if ((opposite != null) && object.isIsImplicit() && (eContainer instanceof org.eclipse.ocl.pivot.Class)) {
			for (Property asProperty : ((org.eclipse.ocl.pivot.Class)eContainer).getOwnedProperties()) {
				if ((asProperty != object) && name.equals(asProperty.getName())) {
					s.append(OPPOSITE_PROPERTY_PREFIX);
					appendParent(opposite);
					appendName(opposite.getName());
					return true;
					//					return false;	// Ambiguous implicit opposites must use UUIDs
				}
			}
		}
		s.append(PROPERTY_PREFIX);
		appendParent(object);
		appendName(name);
		return true;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable Boolean visitPseudostate(@NonNull Pseudostate object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitSelfType(@NonNull SelfType object) {
		appendName(object.getName());
		return true;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable Boolean visitState(@NonNull State object) {
		return false;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable Boolean visitStereotypeExtender(@NonNull StereotypeExtender object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitTemplateParameter(@NonNull TemplateParameter object) {
		NamedElement template = (NamedElement) object.getOwningSignature().getOwningElement();
		if ((template instanceof org.eclipse.ocl.pivot.Class) && Orphanage.isTypeOrphanage(((org.eclipse.ocl.pivot.Class)template).getOwningPackage())) {
			return false;
		}
		s.append(TEMPLATE_PARAMETER_PREFIX);
		appendParent(template);
		s.append(SCOPE_SEPARATOR);
		appendName(template.getName());
		appendName(object.getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitTemplateSignature(@NonNull TemplateSignature object) {
		s.append(TEMPLATE_SIGNATURE_PREFIX);
		TemplateableElement template = object.getOwningElement();
		template.accept(this);
		return true;
	}

	/**
	 * @since 1.4
	 */
	@Override
	public @Nullable Boolean visitTransition(@NonNull Transition object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitTupleType(@NonNull TupleType object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitVariableDeclaration(@NonNull VariableDeclaration object) {
		return false;
	}

	@Override
	public @Nullable Boolean visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}
}
