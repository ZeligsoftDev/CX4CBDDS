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
package com.zeligsoft.ddk.zdl2zdlgen.merge;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.util.ModelMerger;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.util.ZDLGenSwitch;


/**
 * An object that merges a (newly imported) source variant of a ZDLGen model
 * into an existing target variant of the same model.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ZDLGenMerger extends ModelMerger<GenDomainObject, Element> {

	private static final Set<EReference> EXTERNAL_REFERENCES = new java.util.HashSet<EReference>();
	private static final Set<EReference> MERGEABLE_EXTERNAL_REFERENCES = new java.util.HashSet<EReference>();
	private static final Set<EStructuralFeature> MERGEABLE_FEATURES = new java.util.HashSet<EStructuralFeature>();
	
	static {
		// the only references outside of the ZDLGen model are the references to
		// UML elements (in the ZDL model) ...
		for (Iterator<EObject> iter = ZDLGenPackage.eINSTANCE.eAllContents(); iter.hasNext();) {
			EObject next = iter.next();
			if (next instanceof EReference) {
				EReference ref = (EReference) next;
				if (!ref.isDerived() && ref.isChangeable()
						&& (ref.getEType().getEPackage() == UMLPackage.eINSTANCE)) {
					EXTERNAL_REFERENCES.add(ref);
				}
			}
		}
		
		// ... and gen-domain-model references, of course
		MERGEABLE_EXTERNAL_REFERENCES.add(ZDLGenPackage.Literals.GEN_MODEL__REFERENCED_MODEL);
		EXTERNAL_REFERENCES.addAll(MERGEABLE_EXTERNAL_REFERENCES);
		
		// we werge most attributes, except the exclusions, below
		for (Iterator<EObject> iter = ZDLGenPackage.eINSTANCE.eAllContents(); iter
			.hasNext();) {
			EObject next = iter.next();
			if (next instanceof EAttribute) {
				EAttribute attr = (EAttribute) next;

				// don't merge any palette attributes
				if (!attr.isDerived()
					&& attr.isChangeable()
					&& !ZDLGenPackage.Literals.GEN_PALETTE_ITEM
						.isSuperTypeOf(attr.getEContainingClass())
					&& !ZDLGenPackage.Literals.GEN_MENU_ITEM
						.isSuperTypeOf(attr.getEContainingClass())
					&& !ZDLGenPackage.Literals.GEN_MENU
					.isSuperTypeOf(attr.getEContainingClass())) {
					MERGEABLE_FEATURES.add(attr);
				}
			}
		}
		
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__CATEGORY);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_MODEL__NS_URI);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__OVERRIDE);
		
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS);
		
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE);
		
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_MENU_TARGET__MENU);
		
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED);
		MERGEABLE_FEATURES.remove(ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW);
		
		MERGEABLE_FEATURES.addAll(MERGEABLE_EXTERNAL_REFERENCES);
		
		// mergeable references in the palette model, for reference fixing only
		MERGEABLE_FEATURES.add(ZDLGenPackage.Literals.GEN_PALETTE_CREATION_TOOL__TYPE);
		// mergeable references in the menu model, for reference fixing only
		MERGEABLE_FEATURES.add(ZDLGenPackage.Literals.GEN_MENU_CREATE_ACTION__CREATE_CONCEPT);
		MERGEABLE_FEATURES.add(ZDLGenPackage.Literals.GEN_UML_MENU__UML_METACLASS);
	}
		
	
	/**
	 * Initializes me.
	 */
	public ZDLGenMerger() {
		super();
	}
	
	@Override
	protected IKeyExtractor<GenDomainObject, Element> createKeyExtractor() {
		return UMLExtractor.INSTANCE;
	}
	
	@Override
	protected CorrespondenceChecker createCorrespondenceChecker() {
		return new ZDLGenCorrespondenceChecker();
	}
	
	@Override
	protected Set<EReference> getExternalCrossReferences() {
		return EXTERNAL_REFERENCES;
	}
	
	@Override
	protected Set<EReference> getMergeableExternalCrossReferences() {
		return MERGEABLE_EXTERNAL_REFERENCES;
	}
	
	@Override
	protected boolean isMergeableFeature(EObject owner,
			EStructuralFeature feature) {
		
		return MERGEABLE_FEATURES.contains(feature)
			&& super.isMergeableFeature(owner, feature);
	}
	
	@Override
	protected List<GenDomainObject> getContentsToMerge(GenDomainObject object,
			Phase phase) {
		
		List<GenDomainObject> result = super.getContentsToMerge(object, phase);
		
		switch (phase) {
			case PRUNE :
			case UPDATE :
				// Don't merge the palette or menu definition in the 
				// prune/update phase
				if (object instanceof GenDomainModel) {
					result = safeList(super.getContentsToMerge(object, phase),
						phase);
					result.remove(((GenDomainModel) object).getPalette());
					result.remove(((GenDomainModel) object).getMenuModel());
				}  else if(object instanceof GenDomainConcept) {
					result = safeList(super.getContentsToMerge(object, phase),
							phase);
					result.remove(((GenDomainConcept) object).getOverrides());
				}
				break;
			case FIX:
				break;
		}
		
		return result;
	}
	
	//
	// Nested utility classes
	//
	
	/**
	 * A specialized correspondence checker for the ZDLGen metamodel.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private class ZDLGenCorrespondenceChecker extends CorrespondenceChecker {

		private ZDLGenSwitch<Boolean> correspondenceSwitch = new ZDLGenSwitch<Boolean>() {

			@Override
			public Boolean caseGenDomainObject(GenDomainObject object) {
				// in the general case, these are equal if their UML elements
				// are
				// the same
				return basicCorresponds(object);
			}

			@Override
			public Boolean caseGenModel(GenModel object) {
				// special case for recursive ancestry correspondence checking.
				// The
				// root elements correspond by definition of the merge operation
				return Boolean.TRUE;
			}

			// TODO: Can these cases, below, be reasonably generalized in the
			// caseGenDomainObject?
			@Override
			public Boolean caseGenDomainAttribute(GenDomainAttribute object) {
				// additionally requires equality of the type
				return caseGenDomainObject(object)
					&& correspond(((GenDomainAttribute) objectToCompare())
						.getType(), object.getType());
			}

			@Override
			public Boolean caseGenDomainReference(GenDomainReference object) {
				// additionally requires equality of the target
				return caseGenDomainObject(object)
					&& correspond(((GenDomainReference) objectToCompare())
						.getTarget(), object.getTarget());
			}

			@Override
			public Boolean caseGenDomainBlockRelation(
					GenDomainBlockRelation object) {
				// additionally requires equality of the related block
				return caseGenDomainObject(object)
					&& correspond(((GenDomainBlockRelation) objectToCompare())
						.getTarget(), object.getTarget());
			}

			@Override
			public Boolean caseGenDomainGeneralization(
					GenDomainGeneralization object) {
				// additionally requires equality of the general
				return caseGenDomainObject(object)
					&& correspond(((GenDomainGeneralization) objectToCompare())
						.getGeneral(), object.getGeneral());
			}

			@Override
			public Boolean caseGenDomainBlockReference(
					GenDomainBlockReference object) {
				// additionally requires equality of the target
				return caseGenDomainObject(object)
					&& correspond(((GenDomainBlockReference) objectToCompare())
						.getTarget(), object.getTarget());
			}

			@Override
			public Boolean caseGenDomainModelLibraryReference(
					GenDomainModelLibraryReference object) {
				// additionally requires equality of the target
				return caseGenDomainObject(object)
					&& correspond(((GenDomainModelLibraryReference) objectToCompare())
						.getTarget(), object.getTarget());
			}};
		
		@Override
		protected boolean corresponds(GenDomainObject object) {
			return correspondenceSwitch.doSwitch(object);
		}
	}
	
	/**
	 * A switcher that extracts the UML element from a ZDLGen element, according
	 * to how it is referenced by the particular ZDLGen metaclass.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class UMLExtractor extends ZDLGenSwitch<Element>
			implements IKeyExtractor<GenDomainObject, Element> {
		
		/**
		 * No need to create multiple instances; it's stateless.
		 */
		static IKeyExtractor<GenDomainObject, Element> INSTANCE = new UMLExtractor();
		
		@Override
		public Element getKey(GenDomainObject element) {
			return doSwitch(element);
		}
		
		@Override
		public Element caseGenDomainNamedElement(GenDomainNamedElement object) {
			return object.getDomainElement();
		}
		
		@Override
		public Element caseGenDomainGeneralization(
				GenDomainGeneralization object) {
			return object.getDomainGeneralization();
		}
		
		@Override
		public Element caseGenDomainBlockRelation(GenDomainBlockRelation object) {
			return object.getDomainBlockRelation();
		}
		
		@Override
		public Element caseGenDomainBlockReference(
				GenDomainBlockReference object) {
			return object.getDomainBlockReference();
		}
		
		@Override
		public Element caseGenDomainModelLibraryReference(
				GenDomainModelLibraryReference object) {
			return object.getDomainModelLibraryReference();
		}
	}
}
