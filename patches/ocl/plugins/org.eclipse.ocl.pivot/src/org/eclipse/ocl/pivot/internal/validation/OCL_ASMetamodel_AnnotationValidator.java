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
 *  An annotation validator for http://www.eclipse.org/OCL/ASMetamodel annotations.
 *
 * @since 1.4
 */
public final class OCL_ASMetamodel_AnnotationValidator extends BasicEAnnotationValidator2
{
	public static final @NonNull OCL_ASMetamodel_AnnotationValidator INSTANCE = new OCL_ASMetamodel_AnnotationValidator();
	public static final @NonNull String ANNOTATION_NAME = "OCL_ASMetamodel";
	public static final @NonNull String ANNOTATION_SOURCE = PivotConstants.AS_METAMODEL_ANNOTATION_SOURCE;
	public static final @NonNull String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.pivot.annotation";

	public OCL_ASMetamodel_AnnotationValidator() {
		super(ANNOTATION_SOURCE, ANNOTATION_NAME, DIAGNOSTIC_SOURCE, PivotAnnotationsPackage.Literals.AS_METAMODEL_EPACKAGE);
	}
}
