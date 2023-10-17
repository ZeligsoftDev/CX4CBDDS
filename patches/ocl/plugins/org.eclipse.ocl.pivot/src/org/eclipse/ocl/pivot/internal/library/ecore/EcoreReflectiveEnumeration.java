/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.ids.EnumerationId;

public class EcoreReflectiveEnumeration extends EcoreReflectiveType implements Enumeration
{
	private /*@LazyNonNull*/ List<EnumerationLiteral> literals = null;
	private /*@LazyNonNull*/ Map<String, EnumerationLiteral> name2literal = null;

	public EcoreReflectiveEnumeration(@NonNull EcoreReflectivePackage evaluationPackage, int flags, @NonNull EEnum eEnum, @NonNull TemplateParameter @NonNull ... typeParameters) {
		super(evaluationPackage, flags, eEnum, typeParameters);
	}

	@Override
	public @Nullable EnumerationLiteral getEnumerationLiteral(@NonNull String name) {
		Map<String, EnumerationLiteral> name2literal2 = name2literal;
		if (name2literal2 == null) {
			name2literal = name2literal2 = new HashMap<String, EnumerationLiteral>();
			for (EnumerationLiteral enumerationLiteral : getOwnedLiterals()) {
				name2literal2.put(enumerationLiteral.getName(), enumerationLiteral);
			}
		}
		return name2literal2.get(name);
	}

	@Override
	public @NonNull EnumerationId getEnumerationId() {
		return (EnumerationId) getTypeId();
	}

	@Override
	public @NonNull List<EnumerationLiteral> getOwnedLiterals() {
		List<EnumerationLiteral> literals2 = literals;
		if (literals2 == null) {
			literals = literals2 = new ArrayList<EnumerationLiteral>();
			for (EEnumLiteral eEnumLiteral : ((EEnum) eClassifier).getELiterals()) {
				literals2.add(new EcoreExecutorEnumerationLiteral(eEnumLiteral, this, eEnumLiteral.getValue()));
			}
		}
		return literals2;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public String getValue() {
		throw new UnsupportedOperationException();
	}
}
