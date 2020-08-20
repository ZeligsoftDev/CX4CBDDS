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

import java.util.EventObject;


/**
 * Event notifying of changes in the state of a {@link ZDLImporter}.
 *
 * @see ZDLImporter
 * @see ZDLImporterListener
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLImporterEvent
		extends EventObject {

	private static final long serialVersionUID = -1506094489842493177L;

	/**
	 * Event type constant indicating the "ZDL domain model loaded" event.
	 */
	public static final int MODEL_LOADED = 1;
	
	private int eventType;
	
	/**
	 * Initializes me with my source import and type.
	 * 
	 * @param source my source importer object
	 * @param type the kind of event that I am
	 */
	ZDLImporterEvent(ZDLImporter source, int type) {
		super(source);
		
		this.eventType = type;
	}

	@Override
	public ZDLImporter getSource() {
		return (ZDLImporter) super.getSource();
	}
	
	/**
	 * Obtains the event type.
	 * 
	 * @return one of the {@linkplain #MODEL_LOADED enumerated values} in this
	 * class
	 */
	public int getEventType() {
		return eventType;
	}
}
