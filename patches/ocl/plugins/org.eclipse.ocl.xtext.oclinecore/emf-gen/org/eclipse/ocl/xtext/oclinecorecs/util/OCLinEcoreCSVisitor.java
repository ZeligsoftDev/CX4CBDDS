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
 * from: org.eclipse.ocl.xtext.oclinecore/model/OCLinEcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclinecorecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OCLinEcoreCSVisitor<R> extends org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	R visitOCLinEcoreConstraintCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull OCLinEcoreConstraintCS object);
	R visitSysMLCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull SysMLCS object);
	R visitTopLevelCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull TopLevelCS object);
}
