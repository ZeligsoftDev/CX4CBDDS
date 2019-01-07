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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.toolingmodel.PropertySheet;
import com.zeligsoft.base.toolingmodel.PropertySource;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.properties.l10n.Messages;

/**
 * Property definition manger for domain properties tab
 * 
 * @author ysroh
 * 
 */
public final class CXPropertyDefinitionManager {

	public static CXPropertyDefinitionManager INSTANCE = new CXPropertyDefinitionManager();

	public static final String WORKER_CODE_CONTENT_HINT = "workercode"; //$NON-NLS-1$

	private Map<String, Map<String, PropertySource>> propertySourceMap =
		new HashMap<String, Map<String, PropertySource>>();
		
	/**
	 * Constructor
	 */
	private CXPropertyDefinitionManager() {
		// do nothing
	}

	/**
	 * Load the property definition tooling model
	 * 
	 * @param uri
	 */
	private void loadPropertyToolingModel(EObject context, String uri) {
		ResourceSet rset = context.eResource().getResourceSet();
		Resource resource = null;
		try {
			resource = rset.getResource(URI.createURI(uri), true);
			if (resource == null) {
				propertySourceMap.put(uri, null);
				return;
			}
		} catch (Exception e) {
			propertySourceMap.put(uri, null);
			Activator.getDefault().warning(
				Messages.CXPropertyDefinitionManager_LoadingFailedLog, e);
			return;
		}

		PropertySheet propertySheet = (PropertySheet) EcoreUtil
			.getObjectByType(resource.getContents(),
				ToolingModelPackage.eINSTANCE.getPropertySheet());
		Iterator<PropertySource> iter = propertySheet.getPropertySource()
			.iterator();
		
		Map<String, PropertySource> psMap =
			new HashMap<String, PropertySource>();
		
		while (iter.hasNext()) {
			PropertySource ps = iter.next();
			psMap.put(ps.getConceptName(), ps);
		}
		
		propertySourceMap.put(uri, psMap);
	}
	
	/**
	 * Get the property descriptor for the given property provided the 
	 * context and the concept that we are building the concept for.
	 * 
	 * @param context
	 * @param concept
	 * @param property
	 * 
	 * @return
	 * 		The property descriptor
	 */
	public CXPropertyDescriptor getPropertyDescriptor(EObject context,
			Class concept, Property property){
		PropertyDefinition pd = 
			getPropertyDefinition(context, concept, property);
		
		CXPropertyDescriptor cpd = 
			new CXPropertyDescriptor(context, concept, property, pd);
		cpd.setOrder(getPropertyIndex(context, concept, property));
		
		return cpd;
	}

	/**
	 * Queries the property definition of the given property
	 * 
	 * @param context
	 * @param concept
	 * @param property
	 * @return
	 */
	public PropertyDefinition getPropertyDefinition(EObject context,
			Class concept, Property property) {
		PropertySource result = null;
		result = getPropertySource(context, concept, property);
		
		if(result == null || result.getDefinition() == null ||
				result.getDefinition().isEmpty()){
			return null;
		}
		
		return result.getDefinition().get(0);
	}
	
	/**
	 * Queries the property source of the given property
	 * 
	 * @param context
	 * @param concept
	 * @param property
	 * @return
	 */
	private PropertySource getPropertySource(EObject context,
			Class concept, Property property) {
		PropertySource result = null;
		Map<String, PropertySource> definitions = null;
		Profile profile = ZDLUtil.getZDLProfile(context, concept);
		if (profile == null) {
			return null;
		}
		String uri = profile.eResource().getURI().toString();
		uri = uri.replaceFirst("/[^/]*$", ""); //$NON-NLS-1$//$NON-NLS-2$
		String profileName = profile.getLabel();
		uri += "/" + profileName + ".ztooling"; //$NON-NLS-1$//$NON-NLS-2$

		if (!propertySourceMap.containsKey(uri)) {
			loadPropertyToolingModel(context, uri);
		}

		definitions = propertySourceMap.get(uri);
		if (definitions == null) {
			return null;
		}
		
		// check to see if it has been overridden first
		String propertyName = concept.getQualifiedName() 
			+ "::" + property.getName(); //$NON-NLS-1$
		result = definitions.get(propertyName);
		
		// if not found specific to the concept check to see if
		// it is defined for the owning concept
		if(result == null) {
			result = definitions.get(property.getQualifiedName());
		}
		
		return result;

	}

	/**
	 * Queries the property index for the given property in context provided
	 * and for the concept provided.
	 * 
	 * @param context
	 * @param concept
	 * @param property
	 * @return
	 */
	public int getPropertyIndex(EObject context,
			Class concept, Property property) {
		PropertySource result = getPropertySource(context, concept, property);
		
		if (result == null) {
			return Integer.MAX_VALUE;
		}
		
		return result.getOrder();
	}
}
