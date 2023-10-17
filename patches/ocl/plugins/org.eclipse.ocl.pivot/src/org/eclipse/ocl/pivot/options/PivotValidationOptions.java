/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.options;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.messages.StatusCodes.Severity;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * Options applicable to validation using Pivot.ocl defined constraints.
 */
public class PivotValidationOptions
{
	/**
	 * @since 1.4
	 */
	public static final @NonNull EnumeratedOption<StatusCodes.Severity> EcoreValidation = new EnumeratedOption<StatusCodes.Severity>(
			PivotPlugin.PLUGIN_ID, "ecore.validation", StatusCodes.Severity.ERROR, StatusCodes.Severity.class); //$NON-NLS-1$

	public static final @NonNull EnumeratedOption<StatusCodes.Severity> MissingSafeNavigation = new EnumeratedOption<StatusCodes.Severity>(
			PivotPlugin.PLUGIN_ID, "missing.safe.navigation", StatusCodes.Severity.IGNORE, StatusCodes.Severity.class); //$NON-NLS-1$

	/**
	 * Specify the interpretation of default multiplicities; true for Ecore-like optional [?]. false for UML-like required [1].
	 *
	 * @since 1.16
	 */
	public static final @NonNull BooleanOption OptionalDefaultMultiplicity = new BooleanOption(
		PivotPlugin.PLUGIN_ID, "optional.default.multiplicity", false); //$NON-NLS-1$

	/**
	 * @since 1.16
	 */
	public static final @NonNull EnumeratedOption<StatusCodes.@NonNull Severity> PotentialInvalidResult = new EnumeratedOption<>(
			PivotPlugin.PLUGIN_ID, "potential.invalid.result", StatusCodes.Severity.WARNING, StatusCodes.Severity.class); //$NON-NLS-1$

	public static final @NonNull EnumeratedOption<StatusCodes.Severity> RedundantSafeNavigation = new EnumeratedOption<StatusCodes.Severity>(
			PivotPlugin.PLUGIN_ID, "redundant.safe.navigation", StatusCodes.Severity.IGNORE, StatusCodes.Severity.class); //$NON-NLS-1$

	/**
	 * A Map from all the safe navigation constraint names to the validation options that control them.
	 * This avoids the need for distinct options for Operation/Property/Iteration control of the same concept.
	 */
	@Deprecated /* @deprecated no longer used; use safeValidationOperation2severityOption */
	public static final @NonNull Map<String, EnumeratedOption<StatusCodes.Severity>> safeValidationName2severityOption = new HashMap<>();

	/**
	 * A Map from all the safe navigation constraint validation operation literals to the validation options that control them.
	 * This avoids the need for distinct options for Operation/Property/Iteration control of the same concept.
	 *
	 * @since 1.7
	 */
	public static final @NonNull Map</*@NonNull*/ EOperation, @NonNull EnumeratedOption<StatusCodes.Severity>> safeValidationOperation2severityOption = new HashMap<>();

	static {
		safeValidationOperation2severityOption.put(PivotPackage.Literals.CALL_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.RedundantSafeNavigation);
		// safeValidationOperation2severityOption.put(PivotTables.STR_CallExp_c_c_SafeSourceCannotBeMap, PivotValidationOptions.MissingSafeNavigation); -- a real not discretionary bug
		safeValidationOperation2severityOption.put(PivotPackage.Literals.ITERATE_EXP___VALIDATE_SAFE_ITERATOR_IS_REQUIRED__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.RedundantSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.ITERATE_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.RedundantSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.ITERATE_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.MissingSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.ITERATOR_EXP___VALIDATE_SAFE_ITERATOR_IS_REQUIRED__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.RedundantSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.ITERATOR_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.RedundantSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.ITERATOR_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.MissingSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.OPERATION_CALL_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.RedundantSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.OPERATION_CALL_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.MissingSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.RedundantSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.MissingSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.PROPERTY_CALL_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.RedundantSafeNavigation);
		safeValidationOperation2severityOption.put(PivotPackage.Literals.PROPERTY_CALL_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP, PivotValidationOptions.MissingSafeNavigation);
	}

	/**
	 * @since 1.7
	 */
	public static @NonNull HashMap<@Nullable Object, StatusCodes.@Nullable Severity> createValidationKey2severityMap() {
		HashMap<@Nullable Object, StatusCodes.@Nullable Severity> map = new HashMap<>();
/*		Set<Entry<String, EnumeratedOption<Severity>>> entrySet1 = PivotValidationOptions.safeValidationName2severityOption.entrySet();
		for (Map.Entry<String, EnumeratedOption<StatusCodes.Severity>> entry : entrySet1) {
			EnumeratedOption<StatusCodes.Severity> value = entry.getValue();
			if (value != null) {
				map.put(entry.getKey(), value.getDefaultValue());
			}
		} */
		Set<Entry<EOperation, EnumeratedOption<Severity>>> entrySet2 = PivotValidationOptions.safeValidationOperation2severityOption.entrySet();
		for (Map.Entry<EOperation, EnumeratedOption<StatusCodes.Severity>> entry : entrySet2) {
			EnumeratedOption<StatusCodes.Severity> value = entry.getValue();
			if (value != null) {
				map.put(entry.getKey(), value.getDefaultValue());
			}
		}
		return map;
	}

	private PivotValidationOptions() {
		super();
	}
}
