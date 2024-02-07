/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.xtext.essentialocl/model/EssentialOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.essentialoclcs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface DecorableEssentialOCLCSVisitor<R> extends EssentialOCLCSVisitor<R>, org.eclipse.ocl.xtext.basecs.util.DecorableBaseCSVisitor<R>
{
	@Override
	void setUndecoratedVisitor(org.eclipse.ocl.xtext.basecs.util.@NonNull BaseCSVisitor<R> visitor);
}
