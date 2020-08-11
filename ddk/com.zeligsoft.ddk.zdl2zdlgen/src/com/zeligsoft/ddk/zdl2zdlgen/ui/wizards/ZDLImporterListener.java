/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl2zdlgen.ui.wizards;

import java.util.EventListener;


/**
 * Interface for listeners to be notified of changes in the
 * {@link ZDLImporter}'s state.
 *
 * @see ZDLImporter
 * @see ZDLImporterEvent
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface ZDLImporterListener
		extends EventListener {

	/**
	 * A call-back to indicate that the source {@link ZDLImporter} has loaded
	 * a new ZDL model to import.
	 * 
	 * @param event the notification
	 */
	void inputModelLoaded(ZDLImporterEvent event);
}
