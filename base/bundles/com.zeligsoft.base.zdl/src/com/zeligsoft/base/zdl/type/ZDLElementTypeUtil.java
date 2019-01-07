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
package com.zeligsoft.base.zdl.type;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Provides a set of utility methods which support working with ZDLElementTypes
 * and concrete specialization types.
 * 
 * @author jcorchis
 * 
 */
public class ZDLElementTypeUtil {
	
	/**
	 * List of supported UML relationship element type 
	 * ids supported by the ZDLPalette factory.
	 */
    private static final List<String> RELATIONSHIP_HINTS = new ArrayList<String>();
    
    static {
    	RELATIONSHIP_HINTS.add("generalization"); //$NON-NLS-1$
    	RELATIONSHIP_HINTS.add("interfaceRealization"); //$NON-NLS-1$
    	RELATIONSHIP_HINTS.add("usage"); //$NON-NLS-1$
    	RELATIONSHIP_HINTS.add("assemblyConnector"); //$NON-NLS-1$
    	RELATIONSHIP_HINTS.add("delegationConnector"); //$NON-NLS-1$
    }


	/**
	 * Returns the element type id representing the specified ZDL concept.
	 * 
	 * @param concept
	 *            the qualified name of a ZDL concept
	 * @return the element type id for the concept
	 */
	public static String getZDLElementTypeId(String concept) {
		String elementTypeId = null;
		if (concept != null) {
			elementTypeId = ZDLElementType.ZDL_ELEMENT_TYPE_ID__BASE
				+ UML2Util.getValidJavaIdentifier(concept.replaceAll(":", //$NON-NLS-1$
					"_")); //$NON-NLS-1$
		}
		return elementTypeId;
	}

	/**
	 * Returns the element type id for the specified ZDL concept's property.
	 * 
	 * @param concept
	 *            the qualified name of the ZDL concept
	 * @param property
	 *            the named property owned by the concept
	 * @return the element type id for the concept's property
	 */
	static String getZDLElementTypeId(String concept, String property) {
		String elementTypeId = null;
		if (concept != null && property != null) {
			elementTypeId = ZDLElementTypeUtil.getZDLElementTypeId(concept)
				+ '.' + property;
		}
		return elementTypeId;
	}

	/**
	 * Returns the element type id representing the specified ZDL concept.
	 * 
	 * @param concept
	 *            a ZDL concept (in any resource-set context)
	 * @return the element type id for the concept
	 */
	public static String getZDLElementTypeId(Class concept) {

		String elementTypeId = null;

		if (concept != null) {
			elementTypeId = ZDLElementTypeUtil.getZDLElementTypeId(concept
				.getQualifiedName());
		}
		return elementTypeId;
	}

	/**
	 * Returns the element type id representing the specified ZDL reference.
	 * 
	 * @param concept
	 *            a ZDL concept (in any resource-set context)
	 * @param reference
	 *            a reference property owned by the <tt>concept</tt>
	 * 
	 * @return element type id
	 */
	static String getZDLElementTypeId(Class concept, Property reference) {
		String elementTypeId = null;
		if (concept != null && reference != null) {
			elementTypeId = ZDLElementTypeUtil.getZDLElementTypeId(concept
				.getQualifiedName(), reference.getName());
		}
		return elementTypeId;
	}

	/**
	 * Returns the element type id representing the specified ZDL Specialization
	 * Element Type. This ElementType is can be used within the Element Type
	 * framework.
	 * 
	 * @param concept
	 *            the fully qualified concept class
	 * @param profile
	 *            the profile which provided a context for the qualified name
	 * @return element type id
	 */
	public static String getZDLSpecializationElementTypeId(Profile profile,
			Class concept) {
		return ZDLElementTypeUtil.getZDLSpecializationElementTypeId(profile,
			concept.getQualifiedName());
	}

	/**
	 * Returns the element type id representing the specified ZDL Specialization
	 * Element Type. This ElementType is can be used within the Element Type
	 * framework.
	 * 
	 * @param profile
	 *            the profile which provided a context for the qualified name,
	 *            this is required since the concept is a ZDL based while may
	 *            have different mappings in given profile.
	 * @param concept
	 *            the fully qualified concept name
	 * @return element type id
	 */
	public static String getZDLSpecializationElementTypeId(Profile profile,
			String concept) {
		String elementTypeId = null;
		if (concept != null) {
			elementTypeId = ZDLElementType.ZDL_ELEMENT_TYPE_ID__BASE
				+ UML2Util.getValidJavaIdentifier(profile.getName()) + '.'
				+ UML2Util.getValidJavaIdentifier(concept.replaceAll(":", //$NON-NLS-1$
					"_")); //$NON-NLS-1$
		}
		return elementTypeId;
	}
	
	/**
	 * Returns the element type id representing the specified hinted ZDL Specialization
	 * Element Type. This ElementType is can be used within the Element Type
	 * framework.
	 * @param profile
	 *            the profile which provided a context for the qualified name,
	 *            this is required since the concept is a ZDL based while may
	 *            have different mappings in given profile.
	 * @param concept
	 * 		      the fully qualified concept name
	 * @param hint
	 * 			  an element type hint
	 * @return element type id
	 */
	public static String getZDLHintedSpecializationElementTypeId(Profile profile, String concept, String hint) {
		return getZDLSpecializationElementTypeId(profile, concept) + '.' + hint;
	}

	/**
	 * Determines the element type, based on the
	 * {@linkplain #getDomainConcept() domain concept}, that will actually be
	 * used to create the complete concept instance. Usually, this will not be
	 * the ZDL element type, as such, because those are conceptually abstract.
	 * 
	 * @param owner
	 *            the element in which we are creating a child
	 * @param concept
	 *            the concept to instantiate
	 * 
	 * @return the element type to create
	 */
	public static IElementType getElementType(EObject owner,
			Class concept) {
		
		IElementType result = ZDLElementTypeManager.INSTANCE
			.getElementType(concept);

		if (result instanceof ZDLElementType) {
			IClientContext ctx = getClientContext(owner);

			Profile contextProfile = ZDLUtil.getZDLProfile(owner, concept);
			Class profileClass = ZDLUtil.getProfileClass(contextProfile,
				concept);

			if (profileClass instanceof Stereotype) {
				String id = ZDLElementTypeUtil
					.getZDLSpecializationElementTypeId(contextProfile, concept);
				result = ElementTypeRegistry.getInstance().getType(id);
			} else if (profileClass.isMetaclass()) {
				// no stereotype involved. Regular UML element-type
				EClass eClass = (EClass) UMLPackage.eINSTANCE
					.getEClassifier(profileClass.getName());

				result = ElementTypeRegistry.getInstance().getElementType(
					eClass, ctx);
			} else {
				// profile-owned class. Not supported
				throw new IllegalArgumentException(
					"Concept maps to profile class"); //$NON-NLS-1$
			}
		}

		return result;
	}

	/**
	 * Determines the element type, based on the
	 * {@linkplain #getDomainConcept() domain concept}, that will actually be
	 * used to create the complete concept instance. Usually, this will not be
	 * the ZDL element type, as such, because those are conceptually abstract.
	 * 
	 * @param owner
	 *            the element in which we are creating a child
	 * @param concept
	 *            the fully qualified concept name to instantiate
	 * 
	 * @return the element type to create
	 */
	public static IElementType getElementType(EObject owner,
			String concept) {

		Class conceptClass = ZDLUtil.getZDLConcept(owner, concept);
		return getElementType(owner, conceptClass);

	}

	/**
	 * Determines the client-context of the specified <tt>owner</tt> of the
	 * element to be created.
	 * 
	 * @param owner
	 *            the element in which to create a new concept instance
	 * 
	 * @return the best-matching client-context
	 */
	public static IClientContext getClientContext(EObject owner) {
		IClientContext result = ClientContextManager.getInstance()
			.getClientContextFor(owner);

		if (result == null) {
			result = ClientContextManager.getDefaultClientContext();
		}

		return result;
	}
	
	/**
	 * Determines if the provided element type is a relationship type.
	 * @param type the ElementType to check
	 * @return
	 */
	public static boolean isRelationshipElementType(IElementType type) {
		boolean result = false;
		EClass eclass = type.getEClass();
		if (UMLPackage.Literals.RELATIONSHIP.isSuperTypeOf(eclass)
				|| UMLPackage.Literals.CONNECTOR.isSuperTypeOf(eclass)) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Determines if the provided hint is a relationship hint.
	 * @param hint the element type hint
	 * @return
	 */
	public static boolean isRealizationshipHint(String hint) {
		return RELATIONSHIP_HINTS.contains(hint);
	}

	/**
	 * Obtains the ZDL element type on which the specified type is based, if
	 * any. This may be the original type if it is, itsely, a ZDL element type.
	 * 
	 * @param type
	 *            an element type
	 * @return its base ZDL element type, or <code>null</code> if it is not
	 *         related to a ZDL element type
	 * 
	 * @since 1.0.100
	 */
	public static ZDLElementType getZDLElementType(IElementType type) {
		ZDLElementType result = null;

		if (type instanceof ZDLElementType) {
			result = (ZDLElementType) type;
		} else {
			IElementType[] allParents = type.getAllSuperTypes();

			for (int i = allParents.length - 1; i >= 0; i--) {
				if (allParents[i] instanceof ZDLElementType) {
					result = (ZDLElementType) allParents[i];
					break;
				}
			}
		}

		return result;
	}
}