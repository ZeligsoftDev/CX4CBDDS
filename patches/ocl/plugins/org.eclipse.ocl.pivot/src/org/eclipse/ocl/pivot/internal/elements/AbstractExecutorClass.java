/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.values.SetValue;

public class AbstractExecutorClass extends AbstractExecutorType implements org.eclipse.ocl.pivot.Class
{
	public AbstractExecutorClass(@NonNull String name, int flags) {
		super(name, flags);
	}

	@Override
	public @NonNull SetValue allInstances(@NonNull Executor executor, @NonNull CollectionTypeId returnTypeId) {
		return ClassifierAllInstancesOperation.allInstances(executor, returnTypeId, this);
	}

	@Override
	@NonNull
	public EObject createInstance() {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public Object createInstance(@NonNull String value) {
		throw new UnsupportedOperationException();
	}

	public org.eclipse.ocl.pivot.Class getBehavioralClass() {
		return null;
	}

	@Override
	public @NonNull List<StereotypeExtender> getExtenders() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		return standardLibrary.getInheritance(this);
	}

	@Override
	public String getInstanceClassName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return getTypeId().getMetaTypeName();
		//		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Behavior> getOwnedBehaviors() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<TemplateBinding> getOwnedBindings() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Constraint> getOwnedConstraints() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Constraint> getOwnedInvariants() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Operation> getOwnedOperations() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Property> getOwnedProperties() {
		throw new UnsupportedOperationException();
	}

	@Override
	public TemplateSignature getOwnedSignature() {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.Package getOwningPackage() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<org.eclipse.ocl.pivot.Class> getSuperClasses() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public TemplateParameters getTypeParameters() {
		return TemplateParameters.EMPTY_LIST;
		//		throw new UnsupportedOperationException();
	}

	@Override
	public TemplateableElement getUnspecializedElement() {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Class isClass() {
		return this;
	}

	@Override
	public boolean isIsAbstract() {
		return (flags & ABSTRACT) != 0;
	}

	@Override
	public boolean isIsActive() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsInterface() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOrdered() {
		return false;
	}

	@Override
	public @Nullable TemplateParameter isTemplateParameter() {
		return null;
	}

	@Override
	public boolean isUnique() {
		return false;
	}

	//	@Override
	public boolean isIsSerializable() {
		throw new UnsupportedOperationException();
	}

	//	@Override
	public void setBehavioralClass(org.eclipse.ocl.pivot.Class value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setInstanceClassName(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsAbstract(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsActive(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsInterface(boolean value) {
		throw new UnsupportedOperationException();
	}

	//	@Override
	public void setIsSerializable(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwnedSignature(TemplateSignature value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningPackage(org.eclipse.ocl.pivot.Package value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUnspecializedElement(TemplateableElement value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.18
	 */
	public boolean validateBehavioralClassHasDistinctName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.18
	 */
	public boolean validateBehavioralClassIsPrimitiveType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.18
	 */
	public boolean validateBehavioralClassIsSuperClass(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.3
	 */
	@Override
	public boolean validateNameIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validateUniqueInvariantName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}
}