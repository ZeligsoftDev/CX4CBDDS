/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.executor.PivotReflectiveFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ReflectiveInheritance;
import org.eclipse.ocl.pivot.types.AbstractFragment;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

import com.google.common.base.Function;

/**
 * An AbstractTypeServer provides the co-ordinated operation, property and superclass lookup caches for one or more merged types.
 */
public class CompleteInheritanceImpl extends ReflectiveInheritance implements CompleteInheritance
{
	public static final @NonNull List<@NonNull CompleteInheritanceImpl> EMPTY_LIST = Collections.<@NonNull CompleteInheritanceImpl>emptyList();

	public static final class BestOperation implements Function<List<Operation>, Operation> {

		@Override
		public Operation apply(List<Operation> operations) {
			return operations.get(0);
		}
	}
	
	public static final @NonNull BestOperation bestOperation = new BestOperation();

	public static @NonNull TemplateParameterSubstitution createTemplateParameterSubstitution(@NonNull TemplateParameter formalParameter, @NonNull Type type) {
		TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
		templateParameterSubstitution.setFormal(formalParameter);
		templateParameterSubstitution.setActual(type);
		return templateParameterSubstitution;
	}

	protected final @NonNull CompleteClassInternal completeClass;

	public CompleteInheritanceImpl(@NonNull CompleteClassInternal completeClass) {
		super(ClassUtil.nonNullModel(completeClass.getName()), computeFlags(completeClass.getPrimaryClass()));
		this.completeClass = completeClass;
//		org.eclipse.ocl.pivot.Class pivotClass = completeClass.getPrimaryClass();
//		assert !(pivotClass instanceof DataType) || (((DataType)pivotClass).getBehavioralClass() == null);	// DataTypes must use the inheritance of their behavioral class
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull CompleteInheritance baseInheritance) {
		return new PivotReflectiveFragment(this, baseInheritance);
	}

	public @NonNull CompleteClassInternal getCompleteClass() {
		return completeClass;
	}

	@Override
	public @NonNull Iterable<@NonNull ? extends CompleteInheritance> getInitialSuperInheritances() {
		return isOclAny() ? EMPTY_LIST : completeClass.getPartialClasses().getInitialSuperInheritances();
	}
	
	public @NonNull List<? extends Operation> getLocalOperations() {
		return ClassUtil.nonNullEMF(completeClass.getPrimaryClass().getOwnedOperations());			// FIXME Use local cache
	}

	public @NonNull List<? extends Property> getLocalProperties() {
		return ClassUtil.nonNullEMF(completeClass.getPrimaryClass().getOwnedProperties());			// FIXME Use local cache
	}

	@Override
	public @Nullable Operation getMemberOperation(@NonNull OperationId operationId) {
		return completeClass.getOperation(operationId);
	}

	@Override
	public @Nullable Property getMemberProperty(@NonNull String propertyName) {
		return completeClass.getProperty(propertyName);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return completeClass.getPrimaryClass().getMetaTypeName();
	}

	@Override
	public @NonNull List<Property> getOwnedProperties() {
		return ClassUtil.nonNullEMF(completeClass.getPrimaryClass().getOwnedProperties());			// FIXME Use local cache
	}
	
	@Override
	public @NonNull List<Operation> getOwnedOperations() {
		return ClassUtil.nonNullEMF(completeClass.getPrimaryClass().getOwnedOperations());			// FIXME Use local cache
	}
	
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getPivotClass() {
		return getCompleteClass().getPrimaryClass();
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getSuperClasses() {
		List<org.eclipse.ocl.pivot.Class> superClasses = new ArrayList<org.eclipse.ocl.pivot.Class>();
		for (org.eclipse.ocl.pivot.Class superClass : completeClass.getProperSuperClasses()) {
			superClasses.add(superClass);
		}
		return superClasses;
	}

	@Override
	public final @NonNull TypeId getTypeId() {
		return completeClass.getPrimaryClass().getTypeId();
	}

	@Override
	public @NonNull TemplateParameters getTypeParameters() {
		return TemplateParameters.EMPTY_LIST;
	}

	@Override
	public String toString() {
		return completeClass.getPrimaryClass().toString();	
	}

	@Override
	public void uninstall() {
//		System.out.println("uninstall " + toString());
		completeClass.uninstall();
		super.uninstall();
	}
}
