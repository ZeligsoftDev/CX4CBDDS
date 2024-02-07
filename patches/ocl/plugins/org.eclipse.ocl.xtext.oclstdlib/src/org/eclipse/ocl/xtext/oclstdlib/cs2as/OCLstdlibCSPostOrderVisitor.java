/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.xtext.oclstdlibcs.util.AbstractOCLstdlibCSPostOrderVisitor;

public class OCLstdlibCSPostOrderVisitor extends AbstractOCLstdlibCSPostOrderVisitor
{
	public OCLstdlibCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitLibOppositeCS(@NonNull LibOppositeCS csElement) {
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitLibPropertyCS(@NonNull LibPropertyCS csElement) {	// FIXME share BaseCSPostOrderVisitor.visitReferenceCS
		Continuation<?> continuation = super.visitLibPropertyCS(csElement);
		Property pivotElement = PivotUtil.getPivot(Property.class, csElement);
		if (pivotElement != null) {
			LibOppositeCS csOpposite = csElement.getOwnedOpposite();
			if (csOpposite != null) {
				String oppositeName = csOpposite.getName();
				if (oppositeName != null) {
					boolean isOrdered = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_ORDERED;		// The Ecore idiom
					boolean isUnique = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UNIQUE;
					Integer lowerValue = null; //ValueUtil.ZERO_VALUE;
					Integer upperValue = null; //ValueUtil.UNLIMITED_ONE_VALUE;
					TypedRefCS csType = csOpposite.getOwnedType();
					if (csType != null) {
						MultiplicityCS csMultiplicity = csType.getOwnedMultiplicity();
						if (csMultiplicity != null) {
							lowerValue = csMultiplicity.getLower();
							upperValue = csMultiplicity.getUpper();
						}
					}
					IntegerValue lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) :  PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
					if (lower.isInvalid()) {
					//	logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
						lower = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
					}
					UnlimitedNaturalValue upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
					if (upper.isInvalid()) {
					//	logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
						upper = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
					}
					metamodelManager.createImplicitOppositeProperty(pivotElement, oppositeName,
						isOrdered, isUnique, lower, upper);
				}
			}
			else {
				pivotElement.setOpposite(null);
				metamodelManager.installPropertyDeclaration(pivotElement);
			}
		}
		return continuation;
	}

	@Override /* FIXME Bug 548500 workaround */
	public @Nullable Continuation<?> visitMetaclassNameCS(@NonNull MetaclassNameCS csElement) {
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csPrecedence) {
		return null;
	}
}