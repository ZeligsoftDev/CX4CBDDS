/*******************************************************************************
 * Copyright (c) 2008,2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.emf.mwe2.language.mwe2.impl;

import org.eclipse.xtext.common.types.JvmType;
import static org.eclipse.emf.mwe2.language.mwe2.impl.JvmTypeUriFactory.*;

public class IntegerLiteralImplCustom extends IntegerLiteralImpl {

	@Override
	public JvmType getActualType() {
		return findJvmType(getURIForPrimitive("int"), this);
	}
}
