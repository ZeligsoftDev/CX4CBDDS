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
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public abstract class AbstractExecutorProperty extends AbstractExecutorFeature implements Property
{
	protected final int propertyIndex;
	protected Property opposite;

	public AbstractExecutorProperty(@NonNull String name, @NonNull Type executorType, int propertyIndex) {
		super(name, executorType);
		this.propertyIndex = propertyIndex;
		this.opposite = null;
	}

	@Override
	public AssociationClass getAssociationClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getDefaultValue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getDefaultValueString() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		return type.getInheritance(standardLibrary);
	}

	@Override
	public @NonNull List<Property> getKeys() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Property getOpposite() {
		return ClassUtil.nonNullState(opposite);
	}

	@Override
	public LanguageExpression getOwnedExpression() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public PropertyId getPropertyId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull List<Property> getRedefinedProperties() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Property getReferredProperty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Property> getSubsettedProperty() {
		throw new UnsupportedOperationException();
	}

	void initOpposite(@NonNull Property opposite) {
		this.opposite = opposite;
	}

	@Override
	public void initValue(@NonNull Object objectValue, @Nullable Object propertyValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isAttribute(Property p) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsComposite() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsDerived() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsID() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsImplicit() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsReadOnly() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsResolveProxies() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsTransient() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsUnsettable() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsVolatile() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAssociationClass(AssociationClass value) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void setDefaultValue(Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDefaultValueString(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsComposite(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsDerived(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsID(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsImplicit(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsReadOnly(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsResolveProxies(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsUnsettable(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsTransient(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsVolatile(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOpposite(Property value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwnedExpression(LanguageExpression value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningClass(Class value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setReferredProperty(Property value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return String.valueOf(type) + "::" + String.valueOf(name); //$NON-NLS-1$
	}

	@Override
	public boolean validateCompatibleDefaultExpression(DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}
}