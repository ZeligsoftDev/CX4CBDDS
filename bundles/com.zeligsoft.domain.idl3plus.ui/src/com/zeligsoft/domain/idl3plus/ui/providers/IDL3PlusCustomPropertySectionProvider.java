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
package com.zeligsoft.domain.idl3plus.ui.providers;

import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;
import com.zeligsoft.cx.ui.properties.utils.CXPropertiesWidgetFactory;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * Custom property section for IsAsynchronus property of InterfacePort
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusCustomPropertySectionProvider implements ICXCustomPropertySection {

	@Override
	public Map<String, Control> createSection(Composite parent,
			CXPropertyDescriptor descriptor, Property property) {

		if (property.getName().equals(CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS)) {
			return createCustomSectionForIsAsynchronusProperty(parent, descriptor);
		} else if(property.getName().equals(CCMNames.INTERFACE_PORT__HAS_CSL)) {
			return createCustomSectionForHasCSLProperty(parent, descriptor);
		}
		return null;

	}

	private Map<String, Control> createCustomSectionForIsAsynchronusProperty(
			Composite parent, CXPropertyDescriptor descriptor) {
		Port port = (Port) descriptor.getContext();
		if (port.getType() != null
				&& ZDLUtil.isZDLConcept(port.getType(), CORBADomainNames.CORBAINTERFACE)) {
			// only show when its type is set to CORBAInterface
			return CXPropertiesWidgetFactory.createSectionForBooleanType(parent, descriptor);
		}

		return null;
	}
	
	private Map<String, Control> createCustomSectionForHasCSLProperty(
			Composite parent, CXPropertyDescriptor descriptor) {
		Port port = (Port) descriptor.getContext();
		if( port.getType() != null 
				&& ZDLUtil.isZDLConcept(port.getType(), IDL3PlusNames.EXTENDED_PORT_TYPE)) {
			// only show when its type is set to ExtendedPortType
			return CXPropertiesWidgetFactory.createSectionForBooleanType(parent, descriptor);
		}
		
		return null;
	}
}
