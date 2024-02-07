/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An OperationId provides a unique hierarchical identifier for an operation name, operation parameter-types and template parameters.
 * <p>
 * An OperationId has a single ordered list of template parameters flattening all inherited package and type template parameters
 * as part of the single list. The least derived parameters appear first in the list, the operation parameters last.
 */
public interface OperationId extends TemplateableId
{
	/**
	 * @since 1.3
	 */
	public static final @NonNull OperationId BOOLEAN_AND = TypeId.BOOLEAN.getOperationId(0, "and", ParametersId.BOOLEAN);

	/**
	 * @since 1.3
	 */
	public static final @NonNull OperationId BOOLEAN_IMPLIES = TypeId.BOOLEAN.getOperationId(0, "implies", ParametersId.BOOLEAN);

	/**
	 * @since 1.3
	 */
	public static final @NonNull OperationId BOOLEAN_NOT = TypeId.BOOLEAN.getOperationId(0, "not", ParametersId.EMPTY);

	/**
	 * @since 1.3
	 */
	public static final @NonNull OperationId BOOLEAN_OR = TypeId.BOOLEAN.getOperationId(0, "or", ParametersId.BOOLEAN);

	/**
	 * @since 1.3
	 */
	public static final @NonNull OperationId BOOLEAN_XOR = TypeId.BOOLEAN.getOperationId(0, "xor", ParametersId.BOOLEAN);

	/**
	 * @since 1.3
	 */
	public static final @NonNull OperationId OCLANY_EQUALS = TypeId.OCL_ANY.getOperationId(0, "=", ParametersId.OCL_SELF);

	/**
	 * @since 1.3
	 */
	public static final @NonNull OperationId OCLANY_NOT_EQUALS = TypeId.OCL_ANY.getOperationId(0, "<>", ParametersId.OCL_SELF);

	@Override
	@NonNull OperationId getGeneralizedId();
	@Override
	@NonNull String getName();
	@NonNull ParametersId getParametersId();
	@NonNull TypeId getParent();
}