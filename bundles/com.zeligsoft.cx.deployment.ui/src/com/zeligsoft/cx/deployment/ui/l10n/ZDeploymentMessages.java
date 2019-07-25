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

package com.zeligsoft.cx.deployment.ui.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * NLS message implementation for ZelgisoftDeployment extension plug-in.
 * 
 * @author jcorchis
 *
 */
public class ZDeploymentMessages
		extends NLS {
	
	private ZDeploymentMessages() {
		// do not instantiate
	}
	
	private static final String BUNDLE_NAME = ZDeploymentMessages.class.getName();
		
	public static String Allocation_Creation_failed;	
	public static String Allocation_Deletion_failed;	
	
	public static String Add__Deployment_Part;
	public static String AddZeligsoftDeploymentActionDelegate_DeploymentDefaultName;
	public static String Delete__Deployment_Part;
	public static String Deployment_create_failure;	
	
	public static String SetPropertyNameCommand_Label;
	
	
    static {
        NLS.initializeMessages(BUNDLE_NAME, ZDeploymentMessages.class);
    }

}
