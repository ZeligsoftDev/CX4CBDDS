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
package com.zeligsoft.cx.ui.properties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;

public class CXCustomPropertySectionRegistryReader extends RegistryReader {

	private static final String A_CONCEPT = "concept"; //$NON-NLS-1$

	private static final String A_PROPERTY = "property"; //$NON-NLS-1$

	private static final String A_CLASS = "class"; //$NON-NLS-1$

	private static final String A_DOMAIN = "domain"; //$NON-NLS-1$

	private static final String A_APPEND = "append"; //$NON-NLS-1$

	public static CXCustomPropertySectionRegistryReader INSTANCE = new CXCustomPropertySectionRegistryReader();

	protected Map<String, List<CustomPropertySection>> sectionMap = new HashMap<String, List<CustomPropertySection>>();

	private CXCustomPropertySectionRegistryReader() {
		super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID,
				Activator.CUSTOM_PROPERTY_SECTION_EXTPT);
		readRegistry();
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (add) {

			if (element.getAttribute(A_CONCEPT) == null
					|| element.getAttribute(A_PROPERTY) == null) {
				return false;
			}

			String concept = element.getAttribute(A_CONCEPT);
			String property = element.getAttribute(A_PROPERTY);
			String domain = element.getAttribute(A_DOMAIN);
			String appendString = element.getAttribute(A_APPEND);
			boolean append = false;
			if(!UML2Util.isEmpty(appendString)){
				append = Boolean.parseBoolean(appendString);
			}

			if (element.getAttribute(A_CLASS) != null) {
				Object obj = null;
				try {
					obj = element.createExecutableExtension(A_CLASS);
				} catch (CoreException e) {
					Activator.getDefault().error("Invalid class", e); //$NON-NLS-1$
					return false;
				}
				if (obj != null && obj instanceof ICXCustomPropertySection) {

					if (domain == null) {
						domain = UML2Util.EMPTY_STRING;
					}
					CustomPropertySection section = new CustomPropertySection(
							domain, concept, property, append,
							(ICXCustomPropertySection) obj);
					if (sectionMap.get(concept) != null) {
						sectionMap.get(concept).add(section);
					} else {
						List<CustomPropertySection> list = new ArrayList<CustomPropertySection>();
						list.add(section);
						sectionMap.put(concept, list);
					}
				}
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private List<CustomPropertySection> getCustomPropertySection(String domain,
			String concept, String property) {

		List<CustomPropertySection> results = new ArrayList<CustomPropertySection>();
		
		Object obj = sectionMap.get(concept);
		if (obj == null) {
			return results;
		}
		for (CustomPropertySection section : (List<CustomPropertySection>) obj) {
			if (domain.length() != 0 && !section.domain.equals(domain)) {
				continue;
			} else if (domain.length() == 0 && section.domain.length() != 0) {
				continue;
			}
			if (section.getProperty().equals(property)) {
				results.add(section);
			}
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<CustomPropertySection> getCustomPropertySections(
			EObject context, String concept, String property) {
		EObject container = context;
		if (context.eContainer() != null) {
			container = context.eContainer();
		}
		if (!(container instanceof Element)) {
			container = UMLUtil.getBaseElement(container);
			if (!(container instanceof Element)) {
				return Collections.EMPTY_LIST;
			}
		}
		Collection<Profile> profiles = ZDLUtil
				.getZDLProfiles((Element)container );
		String domain = UML2Util.EMPTY_STRING;
		if (!profiles.isEmpty()) {
			domain = profiles.iterator().next().getName();
		}
		List<CustomPropertySection> results = getCustomPropertySection(
				domain, concept, property);
		if (!results.isEmpty()) {
			return results;
		}

		// if we don't find the property section for the given concept, then try
		// to find the property section associated with inherited concept of
		// the given element

		for (String aConcept : sectionMap.keySet()) {
			if (ZDLUtil.isZDLConcept(context, aConcept)) {
				results.addAll(getCustomPropertySection(domain, aConcept,
						property));
				if (domain.length() != 0) {
					results.addAll(getCustomPropertySection(
							UML2Util.EMPTY_STRING, aConcept, property));
				}
			}
		}
		return results;
	}

	public class CustomPropertySection {
		private String concept;
		private String property;
		private String domain;
		private boolean append;
		private ICXCustomPropertySection section;

		public CustomPropertySection(String domain, String concept,
				String property, boolean append, ICXCustomPropertySection section) {
			this.concept = concept;
			this.domain = domain;
			this.property = property;
			this.section = section;
			this.append = append;
		}

		public String getConcept() {
			return concept;
		}

		public String getProperty() {
			return property;
		}

		public String getDomain() {
			return domain;
		}

		public ICXCustomPropertySection getSection() {
			return section;
		}
		
		public boolean shouldAppend(){
			return append;
		}
	}
}
