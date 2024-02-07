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
 * from: org.eclipse.ocl.xtext.oclstdlib/model/OCLstdlibCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclstdlibcs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OCLstdlibCSVisitor<R> extends org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	R visitJavaClassCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull JavaClassCS object);
	R visitJavaImplementationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull JavaImplementationCS object);
	R visitLibClassCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibClassCS object);
	R visitLibCoercionCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibCoercionCS object);
	R visitLibConstraintCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibConstraintCS object);
	R visitLibIterationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibIterationCS object);
	R visitLibOperationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibOperationCS object);
	R visitLibOppositeCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibOppositeCS object);
	R visitLibPackageCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibPackageCS object);
	R visitLibPropertyCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibPropertyCS object);
	R visitLibRootPackageCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibRootPackageCS object);
	R visitMetaclassNameCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull MetaclassNameCS object);
	R visitPrecedenceCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull PrecedenceCS object);
}
