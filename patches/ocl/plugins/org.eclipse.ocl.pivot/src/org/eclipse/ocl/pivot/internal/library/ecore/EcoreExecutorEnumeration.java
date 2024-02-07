/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.library.enumeration.EnumerationAllInstancesOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.osgi.util.NLS;

import com.google.common.collect.Lists;

public class EcoreExecutorEnumeration extends EcoreExecutorType implements Enumeration
{
	private List<EnumerationLiteral> literals = null;

	/**
	 * Construct an executable type descriptor for a known EClassifier.
	 */
	public EcoreExecutorEnumeration(/*@NonNull*/ EEnum eEnum, @NonNull EcoreExecutorPackage evaluationPackage, int flags) {
		super(eEnum, evaluationPackage, flags);
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull SetValue allInstances(@NonNull Executor executor, @NonNull CollectionTypeId returnTypeId) {
		return EnumerationAllInstancesOperation.allInstances(returnTypeId, getOwnedLiterals());
	}

	@Override
	public @NonNull EObject createInstance() {
		throw new UnsupportedOperationException();
	}

	public final @NonNull EEnum getEEnum() {
		EClassifier eClassifier2 = eClassifier;
		if (eClassifier2 == null) {
			throw new IllegalStateException(NLS.bind(PivotMessages.IncompleteInitialization, this));
		}
		return (EEnum) eClassifier2;
	}

	@Override
	public @Nullable EnumerationLiteral getEnumerationLiteral(@NonNull String name) {
		for (EnumerationLiteral enumerationLiteral : literals) {
			if (name.equals(enumerationLiteral.getName())) {
				return enumerationLiteral;
			}
		}
		return null;
	}

	@Override
	public @NonNull EnumerationId getEnumerationId() {
		return (EnumerationId) getTypeId();
	}

	@Override
	public @NonNull List<EnumerationLiteral> getOwnedLiterals() {
		assert literals != null;
		return literals;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public String getValue() {
		throw new UnsupportedOperationException();
	}

	public EcoreExecutorEnumeration initLiterals(EcoreExecutorEnumerationLiteral[] literals) {
		assert this.literals == null;
		this.literals = Lists.<EnumerationLiteral>newArrayList(literals);
		return this;
	}
}
