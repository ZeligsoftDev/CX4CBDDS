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
package org.eclipse.ocl.pivot.internal.library.executor;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorOperation;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation;

public class ExecutorOperation extends AbstractExecutorOperation
{
	protected final @NonNull ParameterTypes parameterTypes;
	protected final int index;
	protected final @NonNull LibraryFeature implementation;
	protected final @NonNull TemplateParameters typeParameters;
	
	public ExecutorOperation(@NonNull String name, @NonNull ParameterTypes parameterTypes, @NonNull Type type, int index, @NonNull TemplateParameters typeParameters, @Nullable LibraryFeature implementation) {
		super(name, type);
		this.parameterTypes = parameterTypes;
		this.index = index;
		this.implementation = implementation != null ? implementation : OclAnyUnsupportedOperation.INSTANCE;		// FIXME
		this.typeParameters = typeParameters;
	}

	@Override
	public @NonNull LibraryFeature getImplementation() {
		return implementation;
	}

	@Override
	public LanguageExpression getBodyExpression() {
		throw new UnsupportedOperationException(); 			// FIXME
	}

	@Override
	public final int getIndex() {
		return index;
	}

	@Override
	public final @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		return (CompleteInheritance) type;
	}

	@Override
	public final String getName() {
		return name;
	}

	@Override
	public @NonNull OperationId getOperationId() {
		throw new UnsupportedOperationException();			// FIXME
	}
	
	@Override
	public @NonNull List<Constraint> getOwnedConstraints() {
		throw new UnsupportedOperationException();			// FIXME
	}

//	@Override
//	public @NonNull DomainClass getOwningClass() {
//		throw new UnsupportedOperationException();			// FIXME
//	}

	@Override
	public @NonNull List<Parameter> getOwnedParameters() {
		return getParameterTypes().getParameters();
	}

	@Override
	public @NonNull List<Constraint> getOwnedPostconditions() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); // WIP FIXME
	}

	@Override
	public @NonNull List<Constraint> getOwnedPreconditions() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); // WIP FIXME
	}

	@Override
	public @NonNull ParametersId getParametersId() {
		return parameterTypes.getParametersId();
	}
	
	@Override
	public @NonNull ParameterTypes getParameterTypes() {
		return parameterTypes;
	}

	
	

//	@Override
//	public @NonNull DomainType getType() {
////		return executorType;
//		throw new UnsupportedOperationException(); // WIP FIXME
//	}

	@Override
	public @NonNull TypeId getTypeId() {
		Type type2 = getType();
		return type2.getTypeId();
	}

	@Override
	public @NonNull TemplateParameters getTypeParameters() {
		return typeParameters;
	}

	@Override
	public boolean isIsStatic() {
		return false;								// WIP FIXME
	}

	@Override
	public String toString() {
		return type.toString() + "::" + name; //$NON-NLS-1$
	}
}
