/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.zml.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localizable strings for the Zeligsoft domain zml plug-in.
 *
 * @author schafe
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.domain.zml.l10n.messages"; //$NON-NLS-1$

	public static String ComponentEditHelperAdvice_getAfterConfigureCommandLabel;
	public static String CommandLabel_ZMLConnectorEditHelperAdvice_getAfterCreateCommand;
	public static String WorkerFunctionUtil_destroyWorkerFunctionImpls_NotAWorkerFunctionException;

	public static String WorkerFunctionUtil_destroyWorkerFunctionImpls_NullException;

	public static String WorkerFunctionUtil_getWorkerFunctionImplementationCode_EmptyLanguageParameterException;

	public static String WorkerFunctionUtil_getWorkerFunctionImplementationCode_LanguageAndBodySizeMismatch;

	public static String WorkerFunctionUtil_getWorkerFunctionImplementationCode_NotAStructuralRealizationException;

	public static String WorkerFunctionUtil_getWorkerFunctionImplementationCode_NotAWorkerFunctionException;

	public static String WorkerFunctionUtil_getWorkerFunctionImpls_NotAWorkerFunction;

	public static String WorkerFunctionUtil_getWorkerFunctionImpls_NullException;

	public static String WorkerFunctionUtil_setWorkerFunctionImplementationCode_EmptyLanguageException;

	public static String WorkerFunctionUtil_setWorkerFunctionImplementationCode_LanguageAndBodySizeMismatch;

	public static String WorkerFunctionUtil_setWorkerFunctionImplementationCode_NotAStructuralRealizationException;

	public static String WorkerFunctionUtil_setWorkerFunctionImplementationCode_NotAWorkerFunctionException;

	public static String WorkerFunctionUtil_workerFunctionImplDefaultName_NotAWorkerFunctionException;

	public static String WorkerFunctionUtil_workerFunctionImplDefaultName_NullException;

	public static String ZDeploymentUtil_CreateDeploymentPartErrorMsg;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
