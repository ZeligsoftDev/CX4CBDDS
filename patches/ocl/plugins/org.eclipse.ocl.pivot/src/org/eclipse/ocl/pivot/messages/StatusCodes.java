/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.messages;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * StatusCodes summarize the result of a validation. The OK/WARNING/ERROR subset are used as
 * validation preferences with OK suppressing a validation and WARNING/ERROR selecting the severity.
 */
public final class StatusCodes
{
	public enum Severity {
		/** Validation is suppressed and so ignored */
		IGNORE(StatusCodes.OK),
		/** Validation problems give an info.
		 * @since 1.4*/
		INFO(StatusCodes.INFO),
		/** Validation problems give a warning. */
		WARNING(StatusCodes.WARNING),
		/** Validation problems give an error. */
		ERROR(StatusCodes.ERROR);

		private int statusCode;

		private Severity(int statusCode) {
			this.statusCode = statusCode;
		}

		/**
		 * The org.eclipse.emf.common.util.Diagnostic equivalent.
		 * @since 1.16
		 */
		public int getDiagnosticSeverity() {
			int diagnosticMask = 0;
			if (statusCode == 0) {
				diagnosticMask = Diagnostic.INFO;
			}
			else {
				if ((statusCode & StatusCodes.INFO) != 0) diagnosticMask |= Diagnostic.INFO;
				if ((statusCode & StatusCodes.WARNING) != 0) diagnosticMask |= Diagnostic.WARNING;
				if ((statusCode & StatusCodes.ERROR) != 0) diagnosticMask |= Diagnostic.ERROR;
			}
			return diagnosticMask;
		}

		public int getStatusCode() {
			return statusCode;
		}
	}

	/**
	 * OK indicates the an evaluation was successful. When used as a validation preference it
	 * causes the validation to be ignored altogether.
	 */
	public static final int OK = 0;

	public static final int INFO = 1;

	public static final int WARNING = 2;

	public static final int ERROR = 4;
	/**
	 * EVALUATION_HALTED indicates that a particular evaluation failed to complete, possibly because it was
	 * cancelled interactively, possibly because a fatal run-time failure occurred or because
	 * the evaluation returned an invalid OCL value.
	 */
	public static final int EVALUATION_HALTED = 8;
}
