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

package org.eclipse.ocl.pivot.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class PivotMessages
{
	static {
		NLS.initializeMessages(PivotMessages.class.getName(), PivotMessages.class);
	}

	/**
	 * @since 1.1
	 */
	public static String AmbiguousModelType;
	public static String AmbiguousOperation;
	public static String ConvertibleValueRequired;
	public static String EObjectRequired;
	public static String EmptyCollection;
	/**
	 * @since 1.18
	 */
	public static String IllegalCoIterator;
	public static String ImplementationClassLoadFailure;
	/**
	 * @since 1.1
	 */
	public static String IncompatibleModelType;
	public static String IncompatibleOclAsTypeSourceType;
	public static String IncompleteInitialization;
	public static String IndexNotInUse;
	public static String IndexOutOfRange;
	public static String IndexesOutOfRange;
	public static String InvalidArgument;
	public static String InvalidCharacter;
	public static String InvalidInteger;
	public static String InvalidLiteral;
	public static String InvalidOperation;
	public static String InvalidReal;
	public static String InvalidSource;
	/**
	 * @since 1.6
	 */
	public static String MapValueForbidden;
	public static String MissingResult;
	public static String MissingSourceType;
	public static String MissingSourceValue;
	public static String MissingSubstring;
	public static String MissingValue;
	public static String NonBinaryOperation;
	public static String NonBooleanBody;
	public static String NonFiniteIntegerValue;
	public static String NonPositiveUnlimitedNaturalValue;
	public static String NullNavigation;
	public static String TypedResultRequired;
	public static String TypedValueRequired;
	public static String UndefinedBody;
	public static String UndefinedInitialiser;
	public static String UndefinedOperation;
	public static String UndefinedResult;
	public static String UnknownSourceType;
	/**
	 * @since 1.3
	 */
	public static String UnspecifiedSelfContext;
	public static String UnsupportedCompareTo;
	public static String Validation;

	public static String ValidationConstraintIsNotSatisfied_ERROR_;
	public static String ValidationEvaluationFailed_ERROR_;

	public static String Severity_Cancel;
	public static String Severity_Fatal_Error;
	public static String Severity_Error;
	public static String Severity_Warning;
	public static String Severity_Info;
	public static String Severity_OK;

	public static String Phase_Parser;
	public static String Phase_Unparser;
	public static String Phase_Lexer;
	public static String Phase_Analyzer;
	public static String Phase_Validator;
	public static String Phase_Utility;
}
