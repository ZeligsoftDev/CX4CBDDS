/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;


/**
 * OclVoidTypeId provides a unique identifier for the null type; OclVoid.
 */
public interface OclVoidTypeId extends CollectionTypeId, /* FIXME Bug 561265 MapTypeId,*/ PrimitiveTypeId, TupleTypeId, TemplateParameterId
{
}