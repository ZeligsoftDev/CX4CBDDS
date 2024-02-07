/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.elements;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;

/**
 * @since 1.3
 */
public class AbstractExecutorOperation extends AbstractExecutorFeature implements Operation
{
	public AbstractExecutorOperation(@NonNull String name, @NonNull Type executorType) {
		super(name, executorType);
	}

	@Override
	@NonNull
	public List<Constraint> getOwnedConstraints() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<TemplateBinding> getOwnedBindings() {
		throw new UnsupportedOperationException();
	}

	@Override
	public TemplateSignature getOwnedSignature() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwnedSignature(TemplateSignature value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public TemplateableElement getUnspecializedElement() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUnspecializedElement(TemplateableElement value) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Type> getRaisedExceptions() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Parameter> getOwnedParameters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Precedence getPrecedence() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPrecedence(Precedence value) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Operation> getRedefinedOperations() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Constraint> getOwnedPreconditions() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Constraint> getOwnedPostconditions() {
		throw new UnsupportedOperationException();
	}

	@Override
	public LanguageExpression getBodyExpression() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBodyExpression(LanguageExpression value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsInvalidating() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsInvalidating(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsTypeof() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsTypeof(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsValidating() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsValidating(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningClass(Class value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validateCompatibleReturn(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validateLoadableImplementation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validateUniquePreconditionName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validateUniquePostconditionName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getIndex() {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public CompleteInheritance getInheritance(
			@NonNull StandardLibrary standardLibrary) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public OperationId getOperationId() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public ParametersId getParametersId() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public ParameterTypes getParameterTypes() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public TemplateParameters getTypeParameters() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.3
	 */
	@Override
	public boolean isIsTransient() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.3
	 */
	@Override
	public void setIsTransient(boolean value) {
		throw new UnsupportedOperationException();
	}
}