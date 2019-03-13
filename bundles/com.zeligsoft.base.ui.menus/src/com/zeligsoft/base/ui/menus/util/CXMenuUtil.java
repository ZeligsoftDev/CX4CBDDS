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
package com.zeligsoft.base.ui.menus.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.toolingmodel.MenuModel;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;
import com.zeligsoft.base.zdl.type.ZDLElementType;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;


/**
 * A set of utilities for creating the menus.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class CXMenuUtil {
	private static final String MENU_MODEL_ANNOTATION = "CXMenuModel"; //$NON-NLS-1$
	private static final String MENU_MODEL_URI_KEY = "uri"; //$NON-NLS-1$

	/**
	 * Given a domain profile retrieve the MenuModel for it.
	 * 
	 * @param domainProfile
	 * 		The domainProfile to retrieve the MenuModel for.
	 * @return
	 * 		The MenuModel for the provided domain profile, or null if none is
	 * 		specified.
	 */
	public static MenuModel getMenuModel(Profile domainProfile) {
		EAnnotation annot = domainProfile.getEAnnotation(MENU_MODEL_ANNOTATION);
		if(annot != null) {
			String uriString = annot.getDetails().get(MENU_MODEL_URI_KEY);
			if(uriString == null || uriString.length() == 0) {
				// there musn't have been a menu model specified for the domain
				// specialization
				return null;
			} else {
				if(domainProfile.eResource() != null 
						&& domainProfile.eResource().getResourceSet() != null){
					ResourceSet rset = domainProfile.eResource().getResourceSet();
					Resource menuModelResource = rset.getResource(URI.createURI(uriString), true);
					
					if(menuModelResource == null) {
						throw new IllegalArgumentException("Domain profile contains a menu model resource URI that can't be loaded.");//$NON-NLS-1$
					} else {
						MenuModel mModel = 
							(MenuModel) EcoreUtil.getObjectByType(
									menuModelResource.getContents(), 
									ToolingModelPackage.Literals.MENU_MODEL);
						return mModel;
					}
				} else {
					throw new IllegalArgumentException("Expecting domainProfile to be in a resource set"); //$NON-NLS-1$
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Given a context element this will calculate the typeId of a concept to 
	 * be created.
	 * 
	 * @param context
	 * 		An element that represents the context in which to calculate the
	 * 		type id.
	 * @param concept
	 * 		The concept that we are calculating the type id for can be null
	 * 		provided typeHint is not
	 * @param typeHint
	 * 		A type hint in guiding figuring out the type can not be null or
	 * 		empty if concept is null
	 * @return
	 * 		The IElementType
	 */
	public static IElementType getTypeId(EObject context, org.eclipse.uml2.uml.Class concept, String typeHint) {
		// pre-condition check
		if(concept == null && (typeHint == null || typeHint.length() == 0)) {
			throw new IllegalArgumentException("Concept and hint can not both be null"); //$NON-NLS-1$
		}
		
		IElementType id = null;
		ElementTypeRegistry reg = ElementTypeRegistry.getInstance();
		
		if(concept != null) {
			Profile profile = ZDLUtil.getZDLProfile(context, concept);
			org.eclipse.uml2.uml.Class base;
			try {
				base = ZDLUtil.getBaseMetaclass(profile, concept);
			} catch (Exception e) {
				return null;
			}
			if(base == null || base.isAbstract()) {
				// It is possible that a concept is not mapped or mapped to a 
				// abstract meta-class, in this case it does not make sense to create
				// a tool.
				return null;
			}
			
			EClass eclass = (EClass) UMLPackage.eINSTANCE.getEClassifier(base
					.getName());
			String specId = null;
			String hint = typeHint;
			if (UML2Util.isEmpty(hint)) {
				specId = ZDLElementTypeUtil.getZDLSpecializationElementTypeId(
					profile, concept);
			} else {
				specId = ZDLElementTypeUtil
					.getZDLHintedSpecializationElementTypeId(profile, concept.getQualifiedName(), typeHint);
			}

			id = reg.getType(specId);
			
			// ElementType not yet registered
			if (id == null) {
				IElementType zdl = ZDLElementTypeManager.INSTANCE
					.getElementType(concept);
				Stereotype stereotype = (Stereotype) ZDLUtil.getProfileClass(
					profile, concept);
				if (UML2Util.isEmpty(typeHint)) {
					IElementType umlBase = ElementTypeRegistry.getInstance()
						.getElementType(eclass);
					id = ZDLElementTypeManager.INSTANCE.getStereotypeType(
						(ZDLElementType) zdl, umlBase, stereotype);
				} else {
					id = ZDLElementTypeManager.INSTANCE
						.getHintedStereotypedType((ZDLElementType) zdl, typeHint, stereotype);
				}
			}
		} else {
			id = reg.getType(typeHint);
		}
		
		return id;
	}
}
