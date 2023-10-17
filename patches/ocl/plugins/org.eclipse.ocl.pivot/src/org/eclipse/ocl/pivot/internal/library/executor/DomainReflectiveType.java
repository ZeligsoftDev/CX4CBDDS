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

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.types.AbstractFragment;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class DomainReflectiveType extends AbstractReflectiveInheritanceType
{
	protected final @NonNull DomainReflectivePackage evaluationPackage;
	protected final org.eclipse.ocl.pivot.@NonNull Class domainClass;
	private /*@LazyNonNull*/ DomainProperties allProperties;

	public DomainReflectiveType(@NonNull DomainReflectivePackage evaluationPackage, org.eclipse.ocl.pivot.@NonNull Class domainClass) {
		super(ClassUtil.nonNullModel(domainClass.getName()), computeFlags(domainClass));
		this.evaluationPackage = evaluationPackage;
		this.domainClass = domainClass;
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull CompleteInheritance baseInheritance) {
		return new DomainReflectiveFragment(this, baseInheritance);
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
	public @NonNull Iterable<@NonNull ? extends CompleteInheritance> getInitialSuperInheritances() {
		Iterable<? extends org.eclipse.ocl.pivot.@NonNull Class> superClasses = ClassUtil.nullFree(domainClass.getSuperClasses());
		final Iterator<? extends org.eclipse.ocl.pivot.@NonNull Class> iterator = superClasses.iterator();
		return new Iterable<@NonNull CompleteInheritance>()
		{
			@Override
			public @NonNull Iterator<@NonNull CompleteInheritance> iterator() {
				return new Iterator<@NonNull CompleteInheritance>()
				{
					private @NonNull StandardLibrary standardLibrary = evaluationPackage.getStandardLibrary();
					private boolean gotOne = false;

					@Override
					public boolean hasNext() {
						return !gotOne || iterator.hasNext();
					}

					@Override
					public @NonNull CompleteInheritance next() {
						org.eclipse.ocl.pivot.Class next = null;
						if (!gotOne) {
							gotOne = true;
							if (!iterator.hasNext()) {
								next = standardLibrary.getOclAnyType();
							}
						}
						if (next == null) {
							next = ClassUtil.nonNull(iterator.next());
						}
						return next.getInheritance(standardLibrary);
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getSuperClasses() {
		return domainClass.getSuperClasses();
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
		return domainClass.getMetaTypeName();
	}

	@Override
	public @NonNull List<Constraint> getOwnedInvariants() {
		return domainClass.getOwnedInvariants();
	}

	@Override
	public @NonNull List<Operation> getOwnedOperations() {
		return domainClass.getOwnedOperations();
	}

	@Override
	public @NonNull List<Property> getOwnedProperties() {
		return domainClass.getOwnedProperties();
	}

	@Override
	public @NonNull List<Constraint> getOwnedConstraints() {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Package getOwningPackage() {
		return evaluationPackage;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getPivotClass() {
		return domainClass;
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return domainClass.getTypeId();
	}

	@Override
	public @NonNull TemplateParameters getTypeParameters() {
		return domainClass.getTypeParameters();
	}

	@Override
	public boolean isOrdered() {
		return domainClass.isOrdered();
	}

	@Override
	public boolean isUnique() {
		return domainClass.isUnique();
	}

	@Override
	public String toString() {
		return String.valueOf(evaluationPackage) + "::" + String.valueOf(name); //$NON-NLS-1$
	}
}