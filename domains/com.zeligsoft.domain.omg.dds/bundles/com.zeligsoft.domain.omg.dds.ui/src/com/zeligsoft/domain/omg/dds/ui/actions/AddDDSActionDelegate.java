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
package com.zeligsoft.domain.omg.dds.ui.actions;

import java.util.HashMap;
import java.util.Map;

import com.zeligsoft.base.ui.actions.AbstractAddZDLActionDelegate;
import com.zeligsoft.domain.omg.dds.DDSNames;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class AddDDSActionDelegate
	extends AbstractAddZDLActionDelegate {

	protected static Map<String, String> actionId2IElementType = 
		new HashMap<String, String>();
	
	static {
		actionId2IElementType.put("addDDS_ComponentPart_actionId", 
				DDSNames.COMPONENT_PART);
		actionId2IElementType.put("addDDS_DDSComponent_actionId", 
				DDSNames.DDSCOMPONENT);
		actionId2IElementType.put("addDDS_DataReader_actionId", 
				DDSNames.DATA_READER);
		actionId2IElementType.put("addDDS_DataWriter_actionId", 
				DDSNames.DATA_WRITER);
		actionId2IElementType.put("addDDS_Domain_actionId", 
				DDSNames.DOMAIN);
		actionId2IElementType.put("addDDS_DomainParticipant_actionId", 
				DDSNames.DOMAIN_PARTICIPANT);
		actionId2IElementType.put("addDDS_Publisher_actionId", 
				DDSNames.PUBLISHER);
		actionId2IElementType.put("addDDS_Subscriber_actionId", 
				DDSNames.SUBSCRIBER);
	}
	
	@Override
	protected String getDomainConcept() {
		return actionId2IElementType.get(getAction().getId());
	}

}
