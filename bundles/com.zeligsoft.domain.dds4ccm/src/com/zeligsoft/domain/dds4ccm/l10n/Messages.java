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
package com.zeligsoft.domain.dds4ccm.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.zeligsoft.domain.dds4ccm.l10n.Messages"; //$NON-NLS-1$
	public static String DDS4CCMUtil_DeleteProcessNameCommandLabel;
	public static String DDS4CCMUtil_DeleteProcessNameFailedMessage;
	public static String DDS4CCMUtil_Exception_ContaineeParameter;
	public static String DDS4CCMUtil_Exception_ContainerNotInResource;
	public static String DDS4CCMUtil_Exception_ContainerParameter;
	public static String DDS4CCMUtil_RemoveRegisterNamingCommandLabel;
	public static String DDS4CCMUtil_RemoveRegisterNamingFailedMessage;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
