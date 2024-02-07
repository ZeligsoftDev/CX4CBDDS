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
 * from: org.eclipse.ocl.xtext.base/model/BaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.basecs.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;

public interface VisitableCS
{
	/**
	 * Returns the result of accepting a visit from a visitor.
	 * Implementations typically invoke a derived-class-specific
	 * variant of visitXXX() to facilitate derived-class-specific
	 * processing or just visit() when no such method is available.
	 * <p>
	 * Implementations of visit() may use the EcoreSwitch to perform
	 * derived-class-specific processing.
	 * <p>
	 * Derived implementations of accept() may use getAdapter() to obtain
	 * richer visitor interfaces.
	 * @param <R>
	 * @param visitor
	 * @return the result of the visit.
	 */
	<R> R accept(org.eclipse.ocl.xtext.basecs.util.@NonNull BaseCSVisitor<R> visitor);

	EClass eClass();
}
