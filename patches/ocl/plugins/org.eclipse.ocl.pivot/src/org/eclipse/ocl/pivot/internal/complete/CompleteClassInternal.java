/**
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.complete;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

public interface CompleteClassInternal extends CompleteClass
{
	void addClass(org.eclipse.ocl.pivot.@NonNull Class partialClass);
	void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass);
//	@NonNull CompleteInheritance createCompleteInheritance();
	boolean didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class partialClass);
	void dispose();
	void uninstall();
	@Override
	@NonNull CompleteInheritanceImpl getCompleteInheritance();
	@NonNull CompleteModelInternal getCompleteModel();
	@NonNull EnvironmentFactoryInternal getEnvironmentFactory();
	@NonNull PivotMetamodelManager getMetamodelManager();
	@Override
	CompletePackageInternal getOwningCompletePackage();
	@Override
	@NonNull PartialClasses getPartialClasses();
	@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> getProperSuperClasses();
} // CompleteClass
