/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * OppositePropertyDetails is a utility class gathering together and eventually unifying the disparate code processing
 * the opposite property-related EAnnotations.
 *
 * @since 1.10
 */
public class OppositePropertyDetails
{
	public static final @NonNull String BODY_KEY = EMOFExtendedMetaData.EMOF_COMMENT_BODY;
	public static final @NonNull String LOWER_KEY = "lower";
	public static final @NonNull String ORDERED_KEY = "ordered";
	public static final @NonNull String UNIQUE_KEY = "unique";
	public static final @NonNull String UPPER_KEY = "upper";

	private static final Logger logger = LogManager.getLogger(OppositePropertyDetails.class);

	/**
	 * The key that identifies opposite role names in an annotation
	 */
	public static final String PROPERTY_OPPOSITE_ROLE_NAME_KEY = "Property.oppositeRoleName"; //$NON-NLS-1$
	public static final Object PROPERTY_OPPOSITE_ROLE_UNIQUE_KEY = "Property.oppositeUnique"; //$NON-NLS-1$
	public static final Object PROPERTY_OPPOSITE_ROLE_ORDERED_KEY = "Property.oppositeOrdered"; //$NON-NLS-1$
	public static final Object PROPERTY_OPPOSITE_ROLE_LOWER_KEY = "Property.oppositeLower"; //$NON-NLS-1$
	public static final Object PROPERTY_OPPOSITE_ROLE_UPPER_KEY = "Property.oppositeUpper"; //$NON-NLS-1$

	public static @Nullable OppositePropertyDetails createFromEReference(@NonNull EReference eReference) {
		EReference eOpposite = eReference.getEOpposite();
		if (eOpposite != null) {
			String oppositeName = eOpposite.getName();
			IntegerValue lower = ValueUtil.integerValueOf(eOpposite.getLowerBound());
			UnlimitedNaturalValue upper = ValueUtil.unlimitedNaturalValueOf(eOpposite.getUpperBound());
			return new OppositePropertyDetails(oppositeName, eOpposite.isOrdered(), eOpposite.isUnique(), lower, upper);
		}
		else {
			EAnnotation oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
			if (oppositeRole != null) {
				EMap<String, String> details = oppositeRole.getDetails();
				String oppositeName = details.get(PROPERTY_OPPOSITE_ROLE_NAME_KEY);
				if (oppositeName != null) {
					String uniqueValue = details.get(PROPERTY_OPPOSITE_ROLE_UNIQUE_KEY);
					String orderedValue = details.get(PROPERTY_OPPOSITE_ROLE_ORDERED_KEY);
					String lowerValue = details.get(PROPERTY_OPPOSITE_ROLE_LOWER_KEY);
					String upperValue = details.get(PROPERTY_OPPOSITE_ROLE_UPPER_KEY);
					boolean isOrdered = orderedValue != null ? Boolean.valueOf(orderedValue) : false;
					boolean isUnique = uniqueValue != null ? Boolean.valueOf(uniqueValue) : true;
					IntegerValue one = ValueUtil.ONE_VALUE;
					IntegerValue lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) : one;
					if (lower.isInvalid()) {
						logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
						lower = one;
					}
					UnlimitedNaturalValue unlimitedOne = ValueUtil.UNLIMITED_ONE_VALUE;
					UnlimitedNaturalValue upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : unlimitedOne;
					if (upper.isInvalid()) {
						logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
						upper = unlimitedOne;
					}
					return new OppositePropertyDetails(oppositeName, isOrdered, isUnique, lower, upper);
				}
			}
			else {
				oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
				if (oppositeRole != null) {
					EMap<String, String> details = oppositeRole.getDetails();
					String oppositeName = details.get(BODY_KEY);
					if (oppositeName != null) {
					//	EObject eContainer = asProperty.eContainer();
					//	if (eContainer instanceof Type) {
						String uniqueValue = details.get(UNIQUE_KEY);
						String orderedValue = details.get(ORDERED_KEY);
						String lowerValue = details.get(LOWER_KEY);
						String upperValue = details.get(UPPER_KEY);
						boolean isOrdered = orderedValue != null ? Boolean.valueOf(orderedValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_ORDERED;
						boolean isUnique = uniqueValue != null ? Boolean.valueOf(uniqueValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UNIQUE;
						IntegerValue lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) :  PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
						if (lower.isInvalid()) {
							logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
							lower = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
						}
						UnlimitedNaturalValue upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
						if (upper.isInvalid()) {
							logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
							upper = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
						}
						return new OppositePropertyDetails(oppositeName, isOrdered, isUnique, lower, upper);
					}
				}
			}
			return null;
		}
	}

/*	public static @NonNull OppositePropertyDetails createOppositeEAnnotationDetails(@NonNull EReference eReference) {
		String oppositeName;
		IntegerValue lower = ValueUtil.ZERO_VALUE;
		UnlimitedNaturalValue upper = ValueUtil.unlimitedNaturalValueOf(0);
		EReference eOpposite = eReference.getEOpposite();
		if (eOpposite != null) {
			oppositeName = eOpposite.getName();
			lower = ValueUtil.integerValueOf(eOpposite.getLowerBound());
			upper = ValueUtil.unlimitedNaturalValueOf(eOpposite.getUpperBound());
		}
		else {
			oppositeName = "«inferred»";
			EAnnotation oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
			if (oppositeRole != null) {
				EMap<String, String> details = oppositeRole.getDetails();
				oppositeName = details.get(PROPERTY_OPPOSITE_ROLE_NAME_KEY);
				if (oppositeName != null) {
					String lowerValue = details.get(PROPERTY_OPPOSITE_ROLE_LOWER_KEY);
					String upperValue = details.get(PROPERTY_OPPOSITE_ROLE_UPPER_KEY);
					IntegerValue one = ValueUtil.ONE_VALUE;
					UnlimitedNaturalValue unlimitedOne = ValueUtil.UNLIMITED_ONE_VALUE;
					lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) : one;
					upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : unlimitedOne;
					if (lower.isInvalid()) {
						//						logger.error("Invalid " + PropertyDetails.PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
						lower = one;
					}
					if (upper.isInvalid()) {
						//						logger.error("Invalid " + PropertyDetails.PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
						upper = unlimitedOne;
					}
				}
			}
			else {
				oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
				if (oppositeRole != null) {
					EMap<String, String> details = oppositeRole.getDetails();
					oppositeName = details.get(EMOFExtendedMetaData.EMOF_COMMENT_BODY);
					if (oppositeName != null) {
						String lowerValue = details.get("lower");
						String upperValue = details.get("upper");
						lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) :  PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
						upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
						if (lower.isInvalid()) {
							//						logger.error("Invalid " + PropertyDetails.PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
							lower = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
						}
						if (upper.isInvalid()) {
							//						logger.error("Invalid " + PropertyDetails.PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
							upper = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
						}
					}
				}
			}
		}
		return new OppositePropertyDetails(oppositeName, null, null, lower, upper);
	} */

	public static @Nullable OppositePropertyDetails createFromProperty(@NonNull Property property) {
		IntegerValue oppositeLower = null;
		Boolean oppositeOrdered = null;
		Boolean oppositeUnique = null;
		UnlimitedNaturalValue oppositeUpper = null;
		IntegerValue lowerValue;
		UnlimitedNaturalValue upperValue;
		Type propertyType = property.getType();
		Type type;
		if (propertyType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)propertyType;
			type = collectionType.getElementType();
			lowerValue = collectionType.getLowerValue();
			upperValue = collectionType.getUpperValue();
			if (collectionType.isOrdered() != PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_ORDERED) {
				oppositeOrdered = collectionType.isOrdered();
			}
			if (collectionType.isUnique() != PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE) {
				oppositeUnique = collectionType.isUnique();
			}
		}
		else {
			type = propertyType;
			lowerValue = property.isIsRequired() ? ValueUtil.ONE_VALUE : ValueUtil.ZERO_VALUE;
			upperValue = ValueUtil.UNLIMITED_ONE_VALUE;
		}
		if (!PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE.equals(lowerValue)) {
			oppositeLower = lowerValue;
		}
		if (!(property.getOpposite().isIsComposite() ? ValueUtil.UNLIMITED_ONE_VALUE : PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE).equals(upperValue)) {
			oppositeUpper = upperValue;
		}
		String name = property.getName();
		//
		//	If there is an exact match for the no-EAnnotation DEFAULT values, then no EAnnotation is required.
		//
		if (name.equals(type.getName()) && (oppositeLower == null) && (oppositeOrdered == null) && (oppositeUnique == null) && (oppositeUpper == null)) {
			return null;
		}
		//
		//	Otherwise the with-EAnnotation ANNOTATED values are the reference.
		//
		oppositeLower = null;
		oppositeOrdered = null;
		oppositeUnique = null;
		oppositeUpper = null;
		if (propertyType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)propertyType;
			if (collectionType.isOrdered() != PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_ORDERED) {
				oppositeOrdered = collectionType.isOrdered();
			}
			if (collectionType.isUnique() != PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UNIQUE) {
				oppositeUnique = collectionType.isUnique();
			}
		}
		if (!PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE.equals(lowerValue)) {
			oppositeLower = lowerValue;
		}
		if (!PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE.equals(upperValue)) {
			oppositeUpper = upperValue;
		}
		return new OppositePropertyDetails(name, oppositeOrdered, oppositeUnique, oppositeLower, oppositeUpper);
	}

	public static @NonNull OppositePropertyDetails createImplicitFromEReference(@NonNull EReference eReference) {
		assert eReference.getEOpposite() == null;
		EClass eClass = ClassUtil.nonNullState(eReference.getEContainingClass());
		String oppositeName = ClassUtil.nonNullState(eClass.getName());
		IntegerValue oppositeLower = null;
		Boolean oppositeOrdered = null;
		Boolean oppositeUnique = null;
		UnlimitedNaturalValue oppositeUpper = null;
		if (eReference.isContainment()) {
			oppositeOrdered = Boolean.FALSE;
			oppositeUnique = Boolean.FALSE;
			oppositeLower = ValueUtil.ZERO_VALUE;
			oppositeUpper = ValueUtil.UNLIMITED_ONE_VALUE;
		}
		else {
			oppositeOrdered = PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_ORDERED;
			oppositeUnique = PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE;
			oppositeLower = PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE;
			oppositeUpper = PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE;
		}
		return new OppositePropertyDetails(oppositeName, oppositeOrdered, oppositeUnique, oppositeLower, oppositeUpper);
	}

	public static @NonNull OppositePropertyDetails createImplicitFromProperty(@NonNull Property asProperty) {
		org.eclipse.ocl.pivot.Class asClass = PivotUtil.getOwningClass(asProperty);
		String oppositeName = PivotUtil.getName(asClass);
		IntegerValue oppositeLower = null;
		Boolean oppositeOrdered = null;
		Boolean oppositeUnique = null;
		UnlimitedNaturalValue oppositeUpper = null;
		if (asProperty.isIsComposite()) {
			oppositeOrdered = Boolean.FALSE;
			oppositeUnique = Boolean.FALSE;
			oppositeLower = ValueUtil.ZERO_VALUE;
			oppositeUpper = ValueUtil.UNLIMITED_ONE_VALUE;
		}
		else {
			oppositeOrdered = PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_ORDERED;
			oppositeUnique = PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE;
			oppositeLower = PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE;
			oppositeUpper = PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE;
		}
		return new OppositePropertyDetails(oppositeName, oppositeOrdered, oppositeUnique, oppositeLower, oppositeUpper);
	}

	protected final @Nullable String name;
	protected final @Nullable Boolean ordered;
	protected final @Nullable Boolean unique;
	protected final @Nullable IntegerValue lower;
	protected final @Nullable UnlimitedNaturalValue upper;

	public OppositePropertyDetails(@Nullable String name, @Nullable Boolean ordered, @Nullable Boolean unique, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		this.name = name;
		this.ordered = ordered;
		this.unique = unique;
		this.lower = lower;
		this.upper = upper;
	}

	public void addToDetails(@NonNull EMap<String, String> eAnnotationDetails) {
		String name2 = name;
		if (name2 == null) {
			eAnnotationDetails.removeKey(BODY_KEY);
		}
		else {
			eAnnotationDetails.put(BODY_KEY, name2);
		}
		IntegerValue lower2 = lower;
		if (lower2 == null) {
			eAnnotationDetails.removeKey(LOWER_KEY);
		}
		else {
			eAnnotationDetails.put(LOWER_KEY, lower2.toString());
		}
		Boolean ordered2 = ordered;
		if (ordered2 == null) {
			eAnnotationDetails.removeKey(ORDERED_KEY);
		}
		else {
			eAnnotationDetails.put(ORDERED_KEY, ordered2.toString());
		}
		Boolean unique2 = unique;
		if (unique2 == null) {
			eAnnotationDetails.removeKey(UNIQUE_KEY);
		}
		else {
			eAnnotationDetails.put(UNIQUE_KEY, unique2.toString());
		}
		UnlimitedNaturalValue upper2 = upper;
		if (upper2 == null) {
			eAnnotationDetails.removeKey(UPPER_KEY);
		}
		else if (upper2.isUnlimited()) {
			eAnnotationDetails.put(UPPER_KEY, "-1");
		}
		else {
			eAnnotationDetails.put(UPPER_KEY, upper2.toString());
		}
	}

	public void addDetails(@NonNull Map<@NonNull String, @NonNull String> eAnnotationDetails) {
		String name2 = name;
		if (name2 == null) {
			eAnnotationDetails.remove(BODY_KEY);
		}
		else {
			eAnnotationDetails.put(BODY_KEY, name2);
		}
		IntegerValue lower2 = lower;
		if (lower2 == null) {
			eAnnotationDetails.remove(LOWER_KEY);
		}
		else {
			eAnnotationDetails.put(LOWER_KEY, lower2.toString());
		}
		Boolean ordered2 = ordered;
		if (ordered2 == null) {
			eAnnotationDetails.remove(ORDERED_KEY);
		}
		else {
			eAnnotationDetails.put(ORDERED_KEY, ordered2.toString());
		}
		Boolean unique2 = unique;
		if (unique2 == null) {
			eAnnotationDetails.remove(UNIQUE_KEY);
		}
		else {
			eAnnotationDetails.put(UNIQUE_KEY, unique2.toString());
		}
		UnlimitedNaturalValue upper2 = upper;
		if (upper2 == null) {
			eAnnotationDetails.remove(UPPER_KEY);
		}
		else if (upper2.isUnlimited()) {
			eAnnotationDetails.put(UPPER_KEY, "-1");
		}
		else {
			eAnnotationDetails.put(UPPER_KEY, upper2.toString());
		}
	}

	public @Nullable IntegerValue basicGetLower() {
		return lower;
	}

	public @Nullable String basicGetName() {
		return name;
	}

	public @Nullable UnlimitedNaturalValue basicGetUpper() {
		return upper;
	}

	public @Nullable Boolean basicIsOrdered() {
		return ordered;
	}

	public @Nullable Boolean basicIsUnique() {
		return unique;
	}

	public @NonNull IntegerValue getLower() {
		return ClassUtil.nonNullState(lower);
	}

	public @NonNull UnlimitedNaturalValue getUpper() {
		return ClassUtil.nonNullState(upper);
	}

	public @NonNull String getName() {
		return ClassUtil.nonNullState(name);
	}

	public @NonNull Boolean isOrdered() {
		return ClassUtil.nonNullState(ordered);
	}

	public @NonNull Boolean isUnique() {
		return ClassUtil.nonNullState(unique);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append("[");
		s.append(lower);
		s.append("..");
		s.append(upper);
		s.append("]{");
		s.append(ordered ? "ordered" : "!ordered");
		s.append(",");
		s.append(unique ? "unique" : "!unique");
		s.append("}");
		return s.toString();
	}
}