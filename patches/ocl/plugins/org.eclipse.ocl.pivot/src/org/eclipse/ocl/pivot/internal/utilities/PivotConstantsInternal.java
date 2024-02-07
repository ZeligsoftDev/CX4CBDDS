/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface PivotConstantsInternal
{
	static final @NonNull String PLUGIN_ID = PivotPlugin.PLUGIN_ID;
	static final @NonNull String PIVOT_ECORE = PLUGIN_ID + "/model/Pivot.ecore";
	static final @NonNull URI GEN_MODEL_URI = URI.createPlatformPluginURI("/" + PLUGIN_ID + "/model/Pivot.genmodel", true); //$NON-NLS-1$

	static final @NonNull String DOCUMENTATION_ANNOTATION_SOURCE = GenModelPackage.eNS_URI;
	static final @NonNull String DOCUMENTATION_ANNOTATION_KEY = "documentation";

	/**
	 * Ecore encoding of a UML redefines
	 */
	static final @NonNull String DUPLICATES_ANNOTATION_SOURCE = "duplicates"; // UMLUtil.ANNOTATION__DUPLICATES
	static final @NonNull String REDEFINES_ANNOTATION_SOURCE = "redefines"; // UMLUtil.ANNOTATION__REDEFINES
	/**
	 * @since 1.14
	 */
	static final @NonNull String SUBSETS_ANNOTATION_SOURCE = "subsets"; // UMLUtil.ANNOTATION__SUBSETS
	//	static final @NonNull String UNION_ANNOTATION_SOURCE = "union"; // UMLUtil.ANNOTATION__UNION

	/**
	 * The default values for a totally blind implicit opposite are determined by what it is safe to use for a fully deduced opposite.
	 * <br>
	 * [0..*] since we have no idea how many objects may be pointing at an object.
	 * <br>
	 * !ordered since we cannot hope to reconstruct order
	 * <br>
	 * !unique since we cannot know how many times an object can reference another once by a given relationship.
	 */
	static final @NonNull IntegerValue DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE = ValueUtil.ZERO_VALUE;
	static final boolean DEFAULT_IMPLICIT_OPPOSITE_ORDERED = false;
	static final boolean DEFAULT_IMPLICIT_OPPOSITE_UNIQUE = false;
	static final @NonNull UnlimitedNaturalValue DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE = ValueUtil.UNLIMITED_VALUE;

	/**
	 * The default values for annotated implicit opposites are determined by what is pragmatic.
	 * <br>
	 * [0..1] which is usually correct for non-collections and half correct for collections.
	 * <br>
	 * !ordered is common
	 * <br>
	 * unique is common
	 */
	static final @NonNull IntegerValue ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE = ValueUtil.ZERO_VALUE;
	static final boolean ANNOTATED_IMPLICIT_OPPOSITE_ORDERED = false;
	static final boolean ANNOTATED_IMPLICIT_OPPOSITE_UNIQUE = true;
	static final @NonNull UnlimitedNaturalValue ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE = ValueUtil.UNLIMITED_ONE_VALUE;

	/**
	 * EOperation annotation identifying that anoperation is transient (not-cached).
	 * @since 1.3
	 */
	static final @NonNull String OPERATION_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/Pivot/Operation";
	/**
	 * @since 1.3
	 */
	static final @NonNull String OPERATION_IS_TRANSIENT = "isTransient";

	@Deprecated // Tuples are now used for rich invariants
	static final @NonNull String MESSAGE_ANNOTATION_DETAIL_SUFFIX = "$message";

	static final int MONIKER_OVERFLOW_LIMIT = 1024;
	static final @NonNull String ANNOTATION_QUOTE = "'"; //$NON-NLS-1$
	static final @NonNull String BINDINGS_PREFIX = "/"; //$NON-NLS-1$ // FIXME Rename
	static final @NonNull String ITERATOR_SEPARATOR = ";"; //$NON-NLS-1$
	static final @NonNull String ACCUMULATOR_SEPARATOR = "|"; //$NON-NLS-1$
	/**
	 * @since 1.4
	 */
	static final @NonNull String COLLECTION_ELEMENT_SEPARATOR = "|"; //$NON-NLS-1$
	static final @NonNull String NULL_MARKER = "«null»"; //$NON-NLS-1$
	static final @NonNull String NULL_ROOT = "$null$"; //$NON-NLS-1$
	static final @NonNull String OVERFLOW_MARKER = "##"; //$NON-NLS-1$
	static final @NonNull String MONIKER_PART_SEPARATOR = "@"; //$NON-NLS-1$
	static final @NonNull String MONIKER_SCOPE_SEPARATOR = "!"; //"::"; //$NON-NLS-1$
	static final @NonNull String MONIKER_OPERATOR_SEPARATOR = "~"; //$NON-NLS-1$
	static final @NonNull String PARAMETER_PREFIX = "("; //$NON-NLS-1$
	static final @NonNull String PARAMETER_SEPARATOR = ","; //$NON-NLS-1$
	static final @NonNull String PARAMETER_SUFFIX = ")"; //$NON-NLS-1$
	static final @NonNull String PRECEDENCE_PREFIX = "~"; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_BINDING_PREFIX = "["; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_BINDING_SEPARATOR = ","; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_BINDING_SUFFIX = "]"; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_PARAMETER_PREFIX = "?"; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_SIGNATURE_PREFIX = "{"; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_SIGNATURE_SEPARATOR = ","; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_SIGNATURE_SUFFIX = "}"; //$NON-NLS-1$
	static final @NonNull String TUPLE_SIGNATURE_PREFIX = "{"; //$NON-NLS-1$
	static final @NonNull String TUPLE_SIGNATURE_PART_SEPARATOR = ","; //$NON-NLS-1$
	static final @NonNull String TUPLE_SIGNATURE_TYPE_SEPARATOR = ":"; //$NON-NLS-1$
	static final @NonNull String TUPLE_SIGNATURE_SUFFIX = "}"; //$NON-NLS-1$
	static final @NonNull String UNRESOLVED_PROXY_MARKER = "«unresolved-proxy»"; //$NON-NLS-1$
	static final @NonNull String WILDCARD_INDICATOR = "?"; //$NON-NLS-1$

	static final @NonNull String MONIKER_IF_EXP = "if";
	static final @NonNull String MONIKER_INVALID_LITERAL_EXP = "invalid";
	static final @NonNull String MONIKER_LET_EXP = "let";
	static final @NonNull String MONIKER_NULL_LITERAL_EXP = "null";
	static final @NonNull String MONIKER_ROOT = "ROOT";
	static final @NonNull String MONIKER_ROOT_EXP = "root";
	static final @NonNull String MONIKER_STRING_LITERAL_EXP = "string";
	static final @NonNull String MONIKER_TUPLE_LITERAL_EXP = "tuple";
	static final @NonNull String MONIKER_UNLIMITED_NATURAL_LITERAL_EXP = "*";

	static final @NonNull String MONIKER_EXP_CHILD_PREFIX = "x";

	static final @NonNull String LIBRARY_MONIKER_PREFIX = "$";
	static final @NonNull String OLD_ORPHANAGE_URI = "http://www.eclipse.org/ocl/3.1.0/orphanage";

	static final @NonNull String UNKNOWN_TYPE_TEXT = "unknown-type";

	static final @NonNull String WILDCARD_NAME = "wildcard";

	/**
	 * @since 1.4
	 */
	static final @NonNull String BODY_ROLE = "«body»";
	@Deprecated
	static final @NonNull String BODY_EXPRESSION_ROLE = BODY_ROLE;
	/**
	 * @since 1.4
	 */
	static final @NonNull String CONSTRAINT_ROLE = "«constraint»";
	@Deprecated
	static final @NonNull String OWNED_CONSTRAINT_ROLE = CONSTRAINT_ROLE;
	/**
	 * @since 1.4
	 */
	static final @NonNull String INITIALIZER_ROLE = "«initializer»";
	@Deprecated
	static final @NonNull String DEFAULT_EXPRESSION_ROLE = INITIALIZER_ROLE;
	/**
	 * @since 1.4
	 */
	static final @NonNull String INVARIANT_ROLE = "«invariant»";
	static final @NonNull String POSTCONDITION_ROLE = "«postcondition»";
	static final @NonNull String PRECONDITION_ROLE = "«precondition»";
	/**
	 * @since 1.4
	 */
	static final @NonNull String QUERY_ROLE = "«query»";
	static final @NonNull String UNKNOWN_ROLE = "«unknown»";

	static @NonNull Map<EStructuralFeature,String> roleNames = new HashMap<EStructuralFeature,String>();
}
