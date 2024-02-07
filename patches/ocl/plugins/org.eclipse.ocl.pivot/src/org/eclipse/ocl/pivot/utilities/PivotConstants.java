/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.common.OCLConstants;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface PivotConstants
{
	/**
	 * EPackage annotation indicating that the EPackage is an Ecore serialisation of an OCL AS Metamodel.
	 * No details are defined for this EAnnotation.
	 * <p>
	 * This annotation is used by /org.eclipse.ocl.pivot/model/Pivot.ecore. It is not
	 * intended to be used by client code.
	 */
	static final @NonNull String AS_METAMODEL_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/ASMetamodel";

	/**
	 * The annotated class is an implicit entry class for Ecore serialization of an OCL Map as an EMap.
	 * @since 1.7
	 */
	static final @NonNull String ENTRY_CLASS_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/EntryClass";

	/**
	 * The Package name of the shared metamodel.
	 */
	static final @NonNull String METAMODEL_NAME = "$metamodel$";

	/**
	 * The Package name of the shared types metamodel.
	 */
	static final @NonNull String TYPES_METAMODEL_NAME = "$types$";	// FIXME Use extension point

	/**
	 * The Package name of the shared uml metamodel.
	 */
	static final @NonNull String UML_METAMODEL_NAME = "$uml$";	// FIXME Use extension point

	/**
	 * @since 1.3
	 */
	static final @NonNull String AS_EXTENSION_SUFFIX = "as";
	static final @NonNull String ESSENTIAL_OCL_FILE_EXTENSION = "essentialocl";
	static final @NonNull String OCL_FILE_EXTENSION = "ocl";
	static final @NonNull String OCLINECORE_FILE_EXTENSION = "oclinecore";
	static final @NonNull String OCLSTDLIB_FILE_EXTENSION = "oclstdlib";
	static final @NonNull String OCL_AS_FILE_EXTENSION = "oclas";
	static final @NonNull String DOT_OCL_AS_FILE_EXTENSION = "." + OCL_AS_FILE_EXTENSION;

	/**
	 * String-valued URI prefix of a package defining the primitive types. Proxy references to
	 * e.g. OCL's String rather than Ecore's EString are constructed by just appending 'String' to
	 * the prefix.
	 */
	static final @NonNull String PRIMITIVE_TYPES_URI_PREFIX = "PRIMITIVE_TYPES_URI_PREFIX";

	/**
	 * EPackage annotation identifying models that must be imported.
	 * Each detail is an alias-name, import uri pair.
	 */
	static final @NonNull String IMPORT_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/Import";
	/**
	 * @since 1.4
	 */
	static final @NonNull String META_ANNOTATION_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/MetaAnnotation";
	static final @NonNull String SYSML_ANNOTATION_SOURCE = "http://www.omg.org/spec/SysML";

	/**
	 * ETypedElement annotation identifying that a collection is non-free.
	 */
	static final @NonNull String COLLECTION_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/Collection";
	static final @NonNull String COLLECTION_IS_NULL_FREE = "nullFree";

	/**
	 * EPackage annotation indicating that the EPackage is an Ecore serialisation of an OCL AS Library.
	 * No details are defined for this EAnnotation.
	 * <p>
	 * This annotation is used by /org.eclipse.ocl.pivot/model/oclstdlib.ecore. It is not
	 * intended to be used by client code.
	 */
	static final @NonNull String AS_LIBRARY_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/ASLibrary";

	static final @NonNull String OMG_OCL_ANNOTATION_SOURCE = "http://www.omg.org/ocl";

	static final @NonNull String AGGREGATE_NAVIGATION_OPERATOR = "->";
	static final @NonNull String SAFE_AGGREGATE_NAVIGATION_OPERATOR = "?->";
	@Deprecated
	static final @NonNull String COLLECTION_NAVIGATION_OPERATOR = AGGREGATE_NAVIGATION_OPERATOR;
	static final @NonNull String OBJECT_NAVIGATION_OPERATOR = ".";
	static final @NonNull String SAFE_OBJECT_NAVIGATION_OPERATOR = "?.";
	static final @NonNull String GREATER_THAN_OPERATOR = ">";
	static final @NonNull String GREATER_THAN_OR_EQUAL_OPERATOR = ">=";
	static final @NonNull String LESS_THAN_OPERATOR = "<";
	static final @NonNull String LESS_THAN_OR_EQUAL_OPERATOR = "<=";

	static final @NonNull String ORPHANAGE_NAME = "$$";
	static final @NonNull String ORPHANAGE_PREFIX = "orphanage";
	static final @NonNull String ORPHANAGE_URI = "http://www.eclipse.org/ocl/2015/Orphanage";
	static final @NonNull String PRIMITIVES_URI = "http://www.eclipse.org/ocl/2015/Primitives";
	/**
	 * @since 1.18
	 */
	static final @NonNull String WILDCARD_NAME = "$?";

	static final @NonNull String OCL_LANGUAGE = "OCL";			// More visible UMLUtil.Language_OCL
	static final @NonNull String OCL_NAME = "ocl";

	static final @NonNull String MESSAGE_PART_NAME = "message";
	static final @NonNull String SEVERITY_PART_NAME = "severity";
	static final @NonNull String STATUS_PART_NAME = "status";

	/**
	 * Stereotype applied to operation body conditions.
	 */
	static final @NonNull String BODY_NAME = "body"; //$NON-NLS-1$

	/**
	 * Stereotype applied derived value expressions.
	 */
	static final @NonNull String DERIVATION_NAME = "derivation"; //$NON-NLS-1$

	/**
	 * Stereotype applied initial value expressions.
	 */
	static final @NonNull String INITIAL_NAME = "initial"; //$NON-NLS-1$

	/**
	 * Stereotype applied to classifier invariant constraints.
	 */
	static final @NonNull String INVARIANT_NAME = "invariant"; //$NON-NLS-1$

	/**
	 * Stereotype applied to operation postcondition constraints.
	 */
	static final @NonNull String POSTCONDITION_NAME = "postcondition"; //$NON-NLS-1$

	/**
	 * Stereotype applied to operation precondition constraints.
	 */
	static final @NonNull String PRECONDITION_NAME = "precondition"; //$NON-NLS-1$

	/**
	 * The name of the operation result variable 'result'.
	 */
	static final @NonNull String RESULT_NAME = "result"; //$NON-NLS-1$

	/**
	 * The name of the context variable 'self'.
	 */
	static final @NonNull String SELF_NAME = "self"; //$NON-NLS-1$

	/**
	 * The name of the DataType value pseudo-property.
	 * @since 1.3
	 */
	static final @NonNull String DATA_TYPE_VALUE_NAME = "value";

	/**
	 * Original xmi:id approach using AS2XMIID to generate long unique hierarchical moniker-based xmi:ids.
	 * @since 1.4
	 */
	static final int XMIIDS_USING_MONIKERS = 0;

	/**
	 * New xmi:id approach using AS2ID and LUSSIDS to generate nominally 5-letter xmi:ids based on unique-ish hierarchical hashcodes.
	 * @since 1.4
	 */
	static final int XMIIDS_USING_LUSSIDS = 1;

	/**
	 * Current xmi:id approach.
	 * @since 1.4
	 */
	static final int XMIIDS_CURRENT = XMIIDS_USING_LUSSIDS;

	/**
	 * The delegate URI for Ecore annotations using the Pivot evaluator.
	 */
	static final @NonNull String OCL_DELEGATE_URI_PIVOT = OCLConstants.OCL_DELEGATE_URI_PIVOT;

	static final @NonNull String OCL_DELEGATE_URI_DEBUG = OCLConstants.OCL_DELEGATE_URI_DEBUG;
}
