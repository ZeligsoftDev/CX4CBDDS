/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *	E.D.Willink (CEA LIST) - Bug 399252
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;

public interface MetamodelManager
{
	org.eclipse.ocl.pivot.@Nullable Class getASClass(@NonNull String className);

	@Deprecated /* @deprecated use PivotHelper.getASOf() */
	@Nullable <T extends Element> T getASOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject) throws ParserException;

	@Nullable <T extends Element> T getASOfEcore(@NonNull Class<T> pivotClass, @Nullable EObject eObject);

	@NonNull ResourceSet getASResourceSet();

	@NonNull CompleteModel getCompleteModel();

	@Nullable <T extends EObject> T getEcoreOfPivot(@NonNull Class<T> ecoreClass, @NonNull Element element);

	@NonNull EnvironmentFactory getEnvironmentFactory();

	org.eclipse.ocl.pivot.@NonNull Class getPrimaryClass(org.eclipse.ocl.pivot.@NonNull Class pivotClass);

	@NonNull Operation getPrimaryOperation(@NonNull Operation pivotOperation);

	org.eclipse.ocl.pivot.@NonNull Package getPrimaryPackage(org.eclipse.ocl.pivot.@NonNull Package eObject);

	@NonNull Property getPrimaryProperty(@NonNull Property pivotProperty);

	@NonNull StandardLibrary getStandardLibrary();

	/**
	 * Convert the specification of an OCL expression from textual CS form to parsed executable AS form. The textual form typically
	 * results from simple construction from source text or a UML OpaqueExpression.
	 * <p>
	 * The returned object may be the same object as the specification, but with the more derived type to signify successful conversion
	 * from textual to executable form. Redundant re-invocation of parseSpecification is harmless.
	 * <p>
	 * The specification's container, typically a Constraint or Operation is used as the contextElement to determine self within the expression.
	 *
	 * @throws ParserException if text parsing fails
	 *
	 * @deprecated use EnvironmentFactoryInternalExtension.parseSpecification()
	 */
	@Deprecated /* @deprecated use EnvironmentFactoryInternalExtension.parseSpecification() */
	@NonNull ExpressionInOCL parseSpecification(@NonNull LanguageExpression specification) throws ParserException;

}
