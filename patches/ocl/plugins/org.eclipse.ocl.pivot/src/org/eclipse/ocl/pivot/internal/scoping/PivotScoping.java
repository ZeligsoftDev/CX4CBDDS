/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.attributes.ClassAttribution;
import org.eclipse.ocl.pivot.internal.attributes.DataTypeAttribution;
import org.eclipse.ocl.pivot.internal.attributes.EnumerationAttribution;
import org.eclipse.ocl.pivot.internal.attributes.ExpressionInOCLAttribution;
import org.eclipse.ocl.pivot.internal.attributes.IterateExpAttribution;
import org.eclipse.ocl.pivot.internal.attributes.IteratorExpAttribution;
import org.eclipse.ocl.pivot.internal.attributes.LetExpAttribution;
import org.eclipse.ocl.pivot.internal.attributes.LibraryAttribution;
import org.eclipse.ocl.pivot.internal.attributes.ModelAttribution;
import org.eclipse.ocl.pivot.internal.attributes.OperationAttribution;
import org.eclipse.ocl.pivot.internal.attributes.OperationCallExpAttribution;
import org.eclipse.ocl.pivot.internal.attributes.PackageAttribution;
import org.eclipse.ocl.pivot.internal.attributes.PropertyAttribution;
import org.eclipse.ocl.pivot.internal.attributes.TemplateParameterAttribution;
import org.eclipse.ocl.pivot.internal.attributes.VariableAttribution;
import org.eclipse.ocl.pivot.internal.attributes.VoidTypeAttribution;

public class PivotScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(PivotPackage.Literals.CLASS, ClassAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.DATA_TYPE, DataTypeAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.ELEMENT, EmptyAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.ENUMERATION, EnumerationAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.EXPRESSION_IN_OCL, ExpressionInOCLAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.INVALID_TYPE, VoidTypeAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.ITERATE_EXP, IterateExpAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.ITERATOR_EXP, IteratorExpAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.LAMBDA_TYPE, EmptyAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.LET_EXP, LetExpAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.LIBRARY, LibraryAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.MODEL, ModelAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.OPERATION, OperationAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.OPERATION_CALL_EXP, OperationCallExpAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.PACKAGE, PackageAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.PROPERTY, PropertyAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.TEMPLATE_PARAMETER, TemplateParameterAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.VARIABLE, VariableAttribution.INSTANCE);
		registry.put(PivotPackage.Literals.VOID_TYPE, VoidTypeAttribution.INSTANCE);
	}
}
