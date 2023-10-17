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
package org.eclipse.ocl.pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.utilities.IndexableIterable;
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * An Inheritance provides access to the transitive inheritance relationships of a class
 * with respect to a particular type regime, noting that the complexities of CompleteOCL allow
 * for different inheritance for different applications.
 *
 * The allSuperInheritances relationship is computed lazily and invalidated whenever a superclass changes.
 * KnownSubInheritances are also notified of invalidation avoiding the need for an adapting Inheritance
 * to adapt more than its own target class.
 */
public interface CompleteInheritance extends Nameable
{
	public static @NonNull CompleteInheritance @NonNull [] EMPTY_ARRAY = new @NonNull CompleteInheritance[0];

	/**
	 * Return a depth ordered, OclAny-first, OclSelf-last, Iterable of all the super-adapters excluding this one.
	 */
	@NonNull Iterable<@NonNull InheritanceFragment> getAllProperSuperFragments();

	/**
	 * Return a depth ordered, OclAny-first, OclSelf-last, Iterable of all the super-adapters including this one.
	 */
	@NonNull Iterable<@NonNull InheritanceFragment> getAllSuperFragments();

	@NonNull CompleteInheritance getCommonInheritance(@NonNull CompleteInheritance inheritance);

	/**
	 * Return the inheritance depth of the target type: OclAny is at depth 0.
	 */
	int getDepth();

	/**
	 * Return the InheritanceFragment of this inheritance whose baseInheritance is thatInheritance. Return null if no InheritanceFragment corresponds.
	 */
	@Nullable InheritanceFragment getFragment(@NonNull CompleteInheritance thatInheritance);
	@NonNull Iterable<@NonNull InheritanceFragment> getFragments();
	/*@Nullable*/ InheritanceFragment getFragment(int fragmentNumber);
	int getIndex(int fragmentNumber);
	int getIndexes();
	@Nullable Operation getMemberOperation(@NonNull OperationId id);
	@Nullable Property getMemberProperty(@NonNull String name);

	org.eclipse.ocl.pivot.@NonNull Class getPivotClass();

	@NonNull InheritanceFragment getSelfFragment();

	/**
	 * Return an Iterable of all the super-inheritances at a specified depth, between 0 and getDepth() inclusive.
	 */
	@NonNull IndexableIterable<@NonNull InheritanceFragment> getSuperFragments(int depth);

	@Deprecated // Use getPivotClass
	org.eclipse.ocl.pivot.@NonNull Class getType();

	boolean isOclAny();
	boolean isSubInheritanceOf(@NonNull CompleteInheritance inheritance);
	boolean isSuperInheritanceOf(@NonNull CompleteInheritance inheritance);
	boolean isUndefined();

	@NonNull Operation lookupActualOperation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation);
	/**
	 * Return the dynamic (overloaded) implementation of the staticOperation applicable to the types managed
	 * by the given Standard Library.
	 */
	@NonNull LibraryFeature lookupImplementation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation);
	@Nullable Operation lookupLocalOperation(@NonNull StandardLibrary standardLibrary, @NonNull String operationName, CompleteInheritance... argumentTypes);
}
