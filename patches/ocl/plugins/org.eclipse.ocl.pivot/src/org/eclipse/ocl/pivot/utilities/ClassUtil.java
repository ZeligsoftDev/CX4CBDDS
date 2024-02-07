/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class ClassUtil
{
	private static final class EmptyIterator implements Iterator<Object>
	{
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Object next() {
			throw new NoSuchElementException();
		}
	}

	private static final @NonNull Iterator<?> EMPTY_ITERATOR = new EmptyIterator();

	/**
	 * Return object cast to requiredClass.
	 * @param object to cast.
	 * @param requiredClass to cast to.
	 * @return cast object or null
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> @Nullable T asClassOrNull(Object object, Class<T> requiredClass) {
		if (object == null)
			return null;
		if (requiredClass == null)
			return null;
		Class<?> objectClass = object.getClass();
		if (!objectClass.isAssignableFrom(objectClass))
			return null;
		return (T) object;
	}

	/**
	 * Return object cast to T without a check.
	 * <p>
	 * This enables type-checking to be suppressed on a single expression term
	 * avoiding the need for suppressing unchecked warnings throughout the rest
	 * of an invoking method.
	 * <p>
	 * Use as: asClassUnchecked(object, (ArbitrarilyComplicatedType)null)
	 *
	 * @param <T> required type
	 * @param object to cast
	 * @param requiredClassObject dummy argument: use null
	 * @return cast type
	 */
	@SuppressWarnings("unchecked")
	public static <T> T asClassUnchecked(Object object, T requiredClassObject) {
		return (T) object;
	}

	/**
	 * Return object cast to T without a check.
	 * <p>
	 * This enables type-checking to suppressed on a single expression term
	 * avoiding the need for suppressing unchecked warnings throughout the rest
	 * of an invoking method.
	 * <p>
	 * Use as: ArbitrarilyComplicatedType castObject = asClassUnchecked(object);
	 *
	 * @param <T> required type
	 * @param object to cast
	 * @return cast type
	 */
	@SuppressWarnings("unchecked")
	public static <T> T asClassUnchecked(Object object) {
		return (T) object;
	}

	/**
	 * Return the DomainConstants.AS_METAMODEL_ANNOTATION_SOURCE for ePackage or null if none.
	 */
	public static @Nullable EAnnotation basicGetMetamodelAnnotation(@NonNull EPackage ePackage) {
		EAnnotation asMetamodelAnnotation = ePackage.getEAnnotation(PivotConstants.AS_METAMODEL_ANNOTATION_SOURCE);
		return asMetamodelAnnotation;
	}

	/**
	 * Return an iterator over no content. This replaces com.google.common.collect.Iterators.emptyIterator() for which no
	 * alternative exists on an adequate range of Guava versions.
	 *
	 * @since 1.3
	 */
	@SuppressWarnings("unchecked")
	public static <T> @NonNull Iterator<T> emptyIterator() {
		return (Iterator<T>) EMPTY_ITERATOR;
	}

	/**
	 * Return the non-null adapterClass if iAdfaptable has an adapterClass adapter.
	 *
	 * This method just delegates to IAdaptable.getAdapter() but avoids the hazard from the unconstrained Class&lt;T&gt; declaration.
	 *
	 * @since 1.1
	 */
	public static <T> @Nullable T getAdapter(@Nullable IAdaptable iAdaptable, @NonNull Class<T> adapterClass) {
		return iAdaptable != null ? iAdaptable.getAdapter(adapterClass) : null;
	}

	public static <T> @Nullable T getAdapter(@NonNull Class<T> adapterClass, @NonNull Notifier notifier) {
		List<Adapter> eAdapters = nonNullEMF(notifier.eAdapters());
		return getAdapter(adapterClass, eAdapters);
	}

	public static <T> @Nullable T getAdapter(@NonNull Class<T> adapterClass, @NonNull List<Adapter> eAdapters) {
		Adapter adapter = EcoreUtil.getAdapter(eAdapters, adapterClass);
		if (adapter == null) {
			return null;
		}
		if (!adapterClass.isAssignableFrom(adapter.getClass())) {
			throw new ClassCastException(adapter.getClass().getName() + " is not assignable to " + adapterClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castAdapter = (T) adapter;
		return castAdapter;
	}

	/**
	 * Return the fully typed class of an object.
	 * @param <T> type
	 * @param object the object
	 * @return the class
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getClass(T object) {
		if (object == null)
			return null;
		return (Class<T>) object.getClass();
	}

	/**
	 * Return the sourceURI annotation of eModelElement, creating and installing it if required.
	 */
	public static @NonNull EAnnotation getEAnnotation(@NonNull EModelElement eModelElement, String sourceURI) {
		EAnnotation eAnnotation = eModelElement.getEAnnotation(sourceURI);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(sourceURI);
			eModelElement.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	/**
	 * Return the DomainConstants.AS_METAMODEL_ANNOTATION_SOURCE for ePackage, creating it if needed.
	 */
	public static @NonNull EAnnotation getMetamodelAnnotation(@NonNull EPackage ePackage) {
		EAnnotation eAnnotation = ePackage.getEAnnotation(PivotConstants.AS_METAMODEL_ANNOTATION_SOURCE);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(PivotConstants.AS_METAMODEL_ANNOTATION_SOURCE);
			ePackage.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	/**
	 * Return anObject cast to aClass if type-safe or null otherwise.
	 * @param anObject for which cast required
	 * @param aClass the type to which cast required
	 * @return the non-null cast of anObject if safe
	 */
	@SuppressWarnings("unchecked")
	public static <T> @Nullable T isInstanceOf(Object anObject, Class<T> aClass) {
		if (anObject == null)
			return null;
		Class<?> objectClass = anObject.getClass();
		if (aClass.isAssignableFrom(objectClass))
			return (T) anObject;
		else
			return null;
	}

	/**
	 * Return true if resource is a registered resource; hosting a compiled Java model.
	 */
	public static boolean isRegistered(@Nullable Resource resource) {			// See Bug 576288
		if (resource != null) {
			URI uri = resource.getURI();
			if (uri != null) {
				for (EObject eRoot : resource.getContents()) {		// ?? only ever one - multi-EPackages are flattened by GenModel Ecore2Java
					if (eRoot instanceof EPackage) {
						String nsURI = ((EPackage)eRoot).getNsURI();
						if ((nsURI != null) && nsURI.equals(uri.toString())) {
							return true;		// FIXME checking for a Java init() method is solider.
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Return aT as @Nullable to suppress the compiler's insistence that the value is non-null.
	 * This may be necessary fo methods that access final non-null fields during construction.
	 *
	 * @since 1.13
	 */
	public static <T> @Nullable T maybeNull(@NonNull T aT) {
		return aT;
	}

	/**
	 * Check for an in appropriate program state. This should not happen, but is not impossible. For instance
	 * a Resource should be contained in a ResourceSet, but that doesn't mean it always is.
	 *<p>
	 * If the inappropriate state really cannot happen, an assertion should be used instead to avoid non-debug
	 * run-time cost.
	 * <p>
	 * Return aT, throwing an IllegalStateException if null.
	 * @since 1.1
	 */
	public static @NonNull <T> T nonNull(@Nullable T aT) {
		assert aT != null;
		return aT;
	}

	/**
	 * Return aT, checking the assertion that this call would not be necessary if EMF had comprehensive @NonNull annotations.
	 */
	public static @NonNull <T> T nonNullEMF(@Nullable T aT) {// FIXME remove once EMF guarantees non-null
		assert aT != null;
		return aT;
	}

	/**
	 * Check for an in appropriate model state which should have been detected by a model validation pass. Typical problems
	 * that nonNullModel detects are null mandatory model elements.
	 *<p>
	 * Return aT, checking the assertion that this call would not be necessary if the Ecore model was guaranteed to be valid.
	 */
	public static @NonNull <T> T nonNullModel(@Nullable T aT) {
		assert aT != null;			// FIXME Change to InvalidModelException
		return aT;
	}

	/**
	 * Return aT, checking the assertion that this call would not be necessary if the Pivot model was guaranteed to be valid.
	 */
	public static @NonNull <T> T nonNullPivot(@Nullable T aT) {
		assert aT != null;			// FIXME Change to InvalidModelException
		return aT;
	}

	/**
	 * Check for an in appropriate program state. This should not happen, but is not impossible. For instance
	 * a Resource should be contained in a ResourceSet, but that doesn't mean it always is.
	 *<p>
	 * If the inappropriate state really cannot happen, an assertion should be used instead to avoid non-debug
	 * run-time cost.
	 * <p>
	 * Return aT, throwing an IllegalStateException if null.
	 */
	public static @NonNull <T> T nonNullState(@Nullable T aT) {
		if (aT == null) {
			throw new IllegalStateException();
		}
		return aT;
	}

	/**
	 * Cast a logically nullFreeList such as EMF collection to a declared null free list.
	 * @since 1.1
	 */
	@SuppressWarnings("null")
	public static <T> @NonNull List<@NonNull T> nullFree(@Nullable List<T> nullFreeList) {
		return nullFreeList != null ? nullFreeList : Collections.emptyList();
	}
	/**
	 * @since 1.1
	 */
	@SuppressWarnings({"null", "unchecked"})
	public static <T> @NonNull EList<@NonNull T> nullFree(@Nullable EList<T> nullFreeList) {
		return nullFreeList != null ? nullFreeList : (EList<T>) ECollections.EMPTY_ELIST;
	}
	/**
	 * @since 1.10
	 */
	@SuppressWarnings({"null", "unchecked"})
	public static <T> @NonNull Iterable<@NonNull T> nullFree(@Nullable Iterable<T> nullFreeList) {
		return nullFreeList != null ? nullFreeList : (Iterable<T>) ECollections.EMPTY_ELIST;
	}

	/**
	 * Safely determines the relative order of <code>object</code> and
	 * <code>otherObject</code>, i.e. without throwing an exception if
	 * <code>object</code> is <code>null</code>.
	 */
	public static <T extends Comparable<T>> int safeCompareTo(@Nullable T object, @Nullable T otherObject) {
		if (object == null) {
			return otherObject == null ? 0 : 1;
		}
		else {
			return otherObject == null ? -1 : object.compareTo(otherObject);
		}
	}

	/**
	 * Safely determines whether <code>object</code> equals
	 * <code>otherObject</code>, i.e. without throwing an exception if
	 * <code>object</code> is <code>null</code>.
	 *
	 * @param object
	 *            The first object to compare.
	 * @param otherObject
	 *            The second object to compare.
	 * @return <code>true</code> if <code>object</code> equals
	 *         <code>otherObject</code>; <code>false</code> otherwise.
	 */
	public static boolean safeEquals(@Nullable Object object, @Nullable Object otherObject) {
		return object == null
				? otherObject == null
				: object.equals(otherObject);
	}

	/**
	 * Sort aList using comparator, using an Ecollections.sort if aLIst is an EList.
	 */
	public static <T> void sort(@NonNull List<? extends T> aList, @NonNull Comparator<T> comparator) {
		if (aList.size() > 1) {
			if (aList instanceof EList<?>) {
				ECollections.sort((EList<? extends T>)aList, comparator);
			}
			else {
				Collections.sort(aList, comparator);
			}
		}
	}

	/**
	 * @since 1.1
	 * @deprecated String.valueOf()now annotated to be @NonNull
	 */
	@Deprecated
	public static @NonNull String toString(Object anObject) {
		return String.valueOf(anObject);
	}
}
