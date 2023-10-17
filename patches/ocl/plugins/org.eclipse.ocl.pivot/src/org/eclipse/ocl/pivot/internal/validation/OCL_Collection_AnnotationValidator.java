/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.validation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 *  An annotation validator for http://www.eclipse.org/OCL/Collection annotations.
 *
 * @since 1.4
 */
public final class OCL_Collection_AnnotationValidator extends BasicEAnnotationValidator2
{
	public static final @NonNull OCL_Collection_AnnotationValidator INSTANCE = new OCL_Collection_AnnotationValidator();
	public static final @NonNull String ANNOTATION_NAME = "OCL_Collection";
	public static final @NonNull String ANNOTATION_SOURCE = PivotConstants.COLLECTION_ANNOTATION_SOURCE;
	public static final @NonNull String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.pivot.annotation";

	public OCL_Collection_AnnotationValidator() {
		super(ANNOTATION_SOURCE, ANNOTATION_NAME, DIAGNOSTIC_SOURCE,
			PivotAnnotationsPackage.Literals.COLLECTION_ECLASS,
			PivotAnnotationsPackage.Literals.COLLECTION_EPACKAGE,
			PivotAnnotationsPackage.Literals.COLLECTION_ETYPED_ELEMENT);
	}
}
