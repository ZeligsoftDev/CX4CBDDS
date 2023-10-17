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
import org.eclipse.ocl.pivot.InheritanceFragment;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorClass;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ArrayIterable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.values.OCLValue;

/**
 * An ExecutorType defines a Type using a compact representation suitable for efficient
 * execution and static construction.
 */
public abstract class ExecutorType extends AbstractExecutorClass implements ExecutorTypeArgument
{
	/**
	 * Depth ordered inheritance fragments. OclAny at depth 0, OclSelf at depth size-1.
	 */
	private @NonNull ExecutorFragment @Nullable [] fragments = null;

	/**
	 * The index in fragments at which inheritance fragments at a given depth start.
	 * depthIndexes[0] is always zero since OclAny is always at depth 0.
	 * depthIndexes[depthIndexes.length-2] is always depthIndexes.length-1 since OclSelf is always at depth depthIndexes.length-2.
	 * depthIndexes[depthIndexes.length-1] is always depthIndexes.length to provide an easy end stop.
	 */
	private int[] indexes = null;

	protected final org.eclipse.ocl.pivot.@NonNull Package evaluationPackage;
	private final @NonNull TemplateParameters typeParameters;
	private /*@LazyNonNull*/ DomainProperties allProperties;

	public ExecutorType(@NonNull String name, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter @NonNull ... typeParameters) {
		super(name, flags);
		this.evaluationPackage = evaluationPackage;
		this.typeParameters = TypeUtil.createTemplateParameters(typeParameters);
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		CompleteInheritance thatInheritance = type.getInheritance(standardLibrary);
		if (this == thatInheritance) {
			return true;
		}
		return thatInheritance.isSuperInheritanceOf(this);
	}

	@Override
	public org.eclipse.ocl.pivot.Class flattenedType() {
		return this;
	}

	@Override
	public final @NonNull FragmentIterable getAllProperSuperFragments() {
		@NonNull InheritanceFragment @NonNull [] fragments2 = ClassUtil.nonNullState(fragments);
		return new FragmentIterable(fragments2, 0, fragments2.length-1);
	}

	@Override
	public @NonNull FragmentIterable getAllSuperFragments() {
		return new FragmentIterable(ClassUtil.nonNullState(fragments));
	}

	@Override
	public @NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		if (this == type) {
			return this.getPivotClass();
		}
		CompleteInheritance firstInheritance = this;
		CompleteInheritance secondInheritance = type.getInheritance(idResolver.getStandardLibrary());
		CompleteInheritance commonInheritance = firstInheritance.getCommonInheritance(secondInheritance);
		return commonInheritance.getPivotClass();
	}

	@Override
	public int getDepth() {
		return indexes.length-2;
	}

	@Override
	public @NonNull Iterable<@NonNull InheritanceFragment> getFragments() {
		return new ArrayIterable<@NonNull InheritanceFragment>(fragments);
	}

	@Override
	public @NonNull ExecutorFragment getFragment(int fragmentNumber) {
		return ClassUtil.nonNullState(fragments)[fragmentNumber];
	}

	@Override
	public int getIndex(int fragmentNumber) {
		return indexes[fragmentNumber];
	}

	@Override
	public int getIndexes(){
		return indexes.length;
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		return this;
	}

	@Override
	public @Nullable Operation getMemberOperation(@NonNull OperationId operationId) {
		throw new UnsupportedOperationException();					// FIXME
	}

	@Override
	public @Nullable Property getMemberProperty(@NonNull String name) {
		DomainProperties allProperties2 = allProperties;
		if (allProperties2 == null) {
			allProperties = allProperties2 = new DomainProperties(this);
		}
		return allProperties2.getMemberProperty(name);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getNormalizedType(@NonNull StandardLibrary standardLibrary) {
		return this;
	}

	@Override
	public @NonNull List<Constraint> getOwnedInvariants() {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public @NonNull List<Property> getOwnedProperties() {
		return getSelfFragment().getLocalProperties();
	}

	@Override
	public @NonNull List<Operation> getOwnedOperations() {
		return getSelfFragment().getLocalOperations();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Package getOwningPackage() {
		return evaluationPackage;
	}

	@Override
	public @NonNull List<Constraint> getOwnedConstraints() {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getPivotClass() {
		return this;
	}

	@Override
	public @NonNull ExecutorFragment getSelfFragment() {
		return getFragment(ClassUtil.nonNullState(fragments).length-1);
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return OCLstdlibTables.LIBRARY;
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getSuperClasses() {
		return getSelfFragment().getSuperClasses();
	}

	@Override
	public final @NonNull FragmentIterable getSuperFragments(int depth) {
		return new FragmentIterable(ClassUtil.nonNullState(fragments), indexes[depth], indexes[depth+1]);
	}

//	public @NonNull TypeId getTypeId() {
//		throw new UnsupportedOperationException();					// FIXME
//	}

	@Override
	public @NonNull TemplateParameters getTypeParameters() {
		return typeParameters;
	}

	public void initFragments(@NonNull ExecutorFragment @NonNull [] fragments, int[] depthCounts) {
		int[] indexes = new int[depthCounts.length+1];
		indexes[0] = 0;
		for (int i = 0; i <  depthCounts.length; i++) {
			indexes[i+1] = indexes[i] + depthCounts[i];
		}
		this.fragments = fragments;
		this.indexes = indexes;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class isClass() {
		return this;
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		return this == type;
	}

	@Override
	public boolean isEqualToUnspecializedType(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		return this == type;
	}

	@Override
	public boolean isOrdered() {
		return (flags & ORDERED) != 0;
	}

	@Override
	public @Nullable TemplateParameter isTemplateParameter() {
		return null;
	}

	@Override
	public boolean isUnique() {
		return (flags & UNIQUE) != 0;
	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof Type)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((Type)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	@Override
	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	@Override
	public String toString() {
		if (evaluationPackage.getPackageId() != IdManager.METAMODEL) {
			return String.valueOf(evaluationPackage) + "::" + String.valueOf(name); //$NON-NLS-1$
		}
		else {
			return String.valueOf(name);
		}
	}
}