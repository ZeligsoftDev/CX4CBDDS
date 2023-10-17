/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.plugin;

import org.eclipse.ocl.common.internal.preferences.AnnotatedPreferenceInitializer;
import org.eclipse.ocl.pivot.options.PivotConsoleOptions;
import org.eclipse.ocl.pivot.options.PivotValidationOptions;

/**
 * Class used to initialize default preference values.
 */
public class PivotPreferenceInitializer extends AnnotatedPreferenceInitializer
{
	@Override
	public void initializeDefaultPreferences() {
		putPreference(PivotConsoleOptions.ConsoleModeltypesInformation);
		putPreference(PivotValidationOptions.EcoreValidation);
		putPreference(PivotValidationOptions.MissingSafeNavigation);
		putPreference(PivotValidationOptions.OptionalDefaultMultiplicity);
		putPreference(PivotValidationOptions.PotentialInvalidResult);
		putPreference(PivotValidationOptions.RedundantSafeNavigation);
	}
}
