/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;

/**
 * A ShadowCache caches the singleton instances of distinct type instantiation
 * for re-use if the same instantiation is re-attempted.
 *
 * The cache is normally accessed as a consequence of evaluating a ShadowExp.
 *
 * @since 1.3
 */
public class ShadowCache
{
	public static final @NonNull TracingOption SHADOWS = new TracingOption(PivotPlugin.PLUGIN_ID, "shadows");

	/**
	 * An ShadowResult maintains the cached singleton instance of thisClass with corresponding theseValues for theseProperties.
	 */
	private static final class ShadowResult
	{
		private final org.eclipse.ocl.pivot.@NonNull Class thisClass;
		private final @NonNull Property @NonNull [] theseProperties;
		private final @Nullable Object @NonNull [] theseValues;
		private final @NonNull Object instance;

		public ShadowResult(org.eclipse.ocl.pivot.@NonNull Class thisClass, @NonNull Property @NonNull [] theseProperties, @Nullable Object @NonNull [] theseValues, @NonNull Object instance) {
			this.thisClass = thisClass;
			this.theseProperties = theseProperties;
			this.theseValues = theseValues;
			this.instance = instance;
			assert theseValues.length == theseProperties.length;
		}

		public @NonNull Object getInstance() {
			return instance;
		}

		public boolean isEqual(@NonNull IdResolver idResolver, org.eclipse.ocl.pivot.@NonNull Class thatClass, @NonNull Property @NonNull [] thoseProperties, @Nullable Object @NonNull [] thoseValues) {
			if (thisClass != thatClass) {
				return false;
			}
			Object [] theseValues2 = theseValues; // JDT 4.5 cannot handle @Nullable
			Object [] thoseValues2 = thoseValues;
			int iMax = thoseValues2.length;
			if (iMax != theseValues2.length) {
				return false;
			}
			assert thoseValues2.length == thoseProperties.length;
			for (int i = 0; i < iMax; i++) {
				if (theseProperties[i] != thoseProperties[i]) {
					return false;
				}
				if (!idResolver.oclEquals(theseValues2[i], thoseValues2[i])) {
					return false;
				}
			}
			return true;
		}
	}

	protected final @NonNull Executor executor;

	/**
	 * Map from class, properties, slot-values hashCode to one or more instances with that hashCode. Single map entries use the
	 * ShadowResult directly as the entry. Colliding entries use a List<@NonNull ShadowResult> for the collisions.
	 * <br>
	 * This map is used to inhibit repeated instances.
	 */
	private final @NonNull Map<@NonNull Integer, @NonNull Object> hashCode2shadows = new HashMap<>();

	protected final boolean debugShadows = SHADOWS.isActive();

	public ShadowCache(@NonNull Executor executor) {
		this.executor = executor;
	}

	public void dispose() {
		hashCode2shadows.clear();
	}

	public @Nullable Object getCachedShadowObject(org.eclipse.ocl.pivot.@NonNull Class thisClass, @NonNull Property @NonNull [] theseProperties, @Nullable Object @NonNull [] theseValues) {
		IdResolver.@NonNull IdResolverExtension idResolver = (IdResolver.IdResolverExtension) executor.getIdResolver();
		int hashCode = thisClass.hashCode();
		assert theseValues.length == theseProperties.length;
		int iMax = theseValues.length;
		for (int i = 0; i < iMax; i++) {
			hashCode = 3 * hashCode + idResolver.oclHashCode(theseValues[i]);
		}
		synchronized (hashCode2shadows) {
			Object zeroOrMoreShadows = hashCode2shadows.get(hashCode);
			ShadowResult oneShadow = null;
			if (zeroOrMoreShadows instanceof ShadowResult) {
				oneShadow = (ShadowResult)zeroOrMoreShadows;
				if (oneShadow.isEqual(idResolver, thisClass, theseProperties, theseValues)) {
					if (debugShadows) {
						SHADOWS.println("old:" + oneShadow);
					}
					return oneShadow.getInstance();
				}
			}
			else if (zeroOrMoreShadows instanceof List<?>) {
				@SuppressWarnings("unchecked")@NonNull List<@NonNull ShadowResult> zeroOrMoreShadows2 = (List<@NonNull ShadowResult>)zeroOrMoreShadows;
				for (@NonNull ShadowResult aShadow : zeroOrMoreShadows2) {
					if (aShadow.isEqual(idResolver, thisClass, theseProperties, theseValues)) {
						if (debugShadows) {
							SHADOWS.println("old:" + aShadow);
						}
						return aShadow.getInstance();
					}
				}
			}
		}
		//
		//	Must resynchronize after newInstance creation and execution in case the execution is recursive.
		//
		EObject eObject = thisClass.createInstance();
		for (int i = 0 ; i < iMax; i++) {
			Property referredProperty = theseProperties[i];
			Class<?> instanceClass = PivotUtil.getEcoreInstanceClass(referredProperty);
			Object ecoreValue = idResolver.ecoreValueOf(instanceClass, theseValues[i]);
			referredProperty.initValue(eObject, ecoreValue);
		}
		ShadowResult theShadow = new ShadowResult(thisClass, theseProperties, theseValues, eObject);
		synchronized (hashCode2shadows) {
			Object zeroOrMoreShadows = hashCode2shadows.get(hashCode);
			if (zeroOrMoreShadows == null) {
				hashCode2shadows.put(hashCode, theShadow);
			}
			else if (zeroOrMoreShadows instanceof ShadowResult) {
				ShadowResult oneShadow = (ShadowResult)zeroOrMoreShadows;
				if (oneShadow.isEqual(idResolver, thisClass, theseProperties,theseValues)) {
					if (debugShadows) {
						SHADOWS.println("old:" + oneShadow);
					}
					return oneShadow.getInstance();
				}
				List<@NonNull ShadowResult> twoOrMoreShadows = new ArrayList<>(4);
				twoOrMoreShadows.add(oneShadow);
				twoOrMoreShadows.add(theShadow);
				hashCode2shadows.put(hashCode, twoOrMoreShadows);
			}
			else if (zeroOrMoreShadows instanceof List<?>) {
				@SuppressWarnings("unchecked")@NonNull List<@NonNull ShadowResult> twoOrMoreShadows = (List<@NonNull ShadowResult>)zeroOrMoreShadows;
				for (@NonNull ShadowResult aShadow : twoOrMoreShadows) {
					if (aShadow.isEqual(idResolver, thisClass, theseProperties, theseValues)) {
						if (debugShadows) {
							SHADOWS.println("old:" + aShadow);
						}
						return aShadow.getInstance();
					}
				}
				twoOrMoreShadows.add(theShadow);
			}
			if (debugShadows) {
				SHADOWS.println("new:" + theShadow);
			}
			return theShadow.getInstance();
		}
	}
}