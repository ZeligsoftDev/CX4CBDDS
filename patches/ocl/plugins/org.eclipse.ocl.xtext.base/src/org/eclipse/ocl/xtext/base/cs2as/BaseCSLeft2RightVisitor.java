/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.xtext.basecs.util.VisitableCS;

public class BaseCSLeft2RightVisitor extends AbstractExtendingBaseCSVisitor<Element, CS2ASConversion>
{
	/**
	 * Construction helper.
	 */
	protected final @NonNull PivotHelper helper;

	public BaseCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
		this.helper = context.getHelper();
	}

	@Override
	public Element visitAnnotationCS(@NonNull AnnotationCS object) {
		return null;
	}

	@Override
	public Element visitClassCS(@NonNull ClassCS object) {
		return null;
	}

	@Override
	public Element visitConstraintCS(@NonNull ConstraintCS object) {
		return null;
	}

	@Override
	public Element visitDetailCS(@NonNull DetailCS object) {
		return null;
	}

	@Override
	public Element visitOperationCS(@NonNull OperationCS object) {
		return null;
	}

	@Override
	public Element visitParameterCS(@NonNull ParameterCS object) {
		return null;
	}

	@Override
	public Element visitSpecificationCS(@NonNull SpecificationCS object) {
		return null;
	}

	@Override
	public Element visitStructuralFeatureCS(@NonNull StructuralFeatureCS object) {
		return null;
	}

	@Override
	public Element visitTemplateBindingCS(@NonNull TemplateBindingCS object) {
		return null;
	}

	@Override
	public Element visitTemplateParameterCS(@NonNull TemplateParameterCS object) {
		return null;
	}

	@Override
	public Element visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS object) {
		return null;
	}

	@Override
	public Element visitTemplateSignatureCS(@NonNull TemplateSignatureCS object) {
		return null;
	}

	@Override
	public Element visitTuplePartCS(@NonNull TuplePartCS object) {
		return null;
	}

	@Override
	public Element visitTupleTypeCS(@NonNull TupleTypeCS object) {
		return null;
	}

	@Override
	public Element visitTypeRefCS(@NonNull TypeRefCS object) {
		return null;
	}

	@Override
	public Element visiting(@NonNull VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS2AS Left2Right pass");
	}
}