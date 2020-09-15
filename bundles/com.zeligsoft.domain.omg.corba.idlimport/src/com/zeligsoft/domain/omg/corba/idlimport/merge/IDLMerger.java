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
package com.zeligsoft.domain.omg.corba.idlimport.merge;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.util.ModelMerger;
import com.zeligsoft.base.util.ModelMerger.IHierarchicalKey;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * 
 * @author Sean McFee
 * 
 * IDL Merge framework that uses repository IDs to match elements in an IDLFile hierarchy.
 *
 */
public class IDLMerger extends ModelMerger<EObject, IHierarchicalKey> {

	private static final Set<EStructuralFeature> MERGEABLE_FEATURES = new java.util.HashSet<EStructuralFeature>();
	
	// the only references outside of the profile are the imported elements and
	// packages, and applied profiles
	private static final Set<EReference> EXTERNAL_REFERENCES = new java.util.HashSet<EReference>(
		Arrays.asList(UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE,
			UMLPackage.Literals.PACKAGE_IMPORT__IMPORTED_PACKAGE,
			UMLPackage.Literals.ELEMENT_IMPORT__IMPORTED_ELEMENT));
	
	static {
		// handle Ecore quite generically, but with some exceptions
		for (TreeIterator<?> iter = EcorePackage.eINSTANCE.eAllContents(); iter
			.hasNext();) {
			Object next = iter.next();

			if (next == EcorePackage.Literals.EPACKAGE) {
				// don't merge any of the features of an EPackage, such as
				// nsURI, nsPrefix, etc.
				iter.prune();

				// except for its eClassifiers (profiles have no sub-packages)
				MERGEABLE_FEATURES
					.add(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
			} else if (next instanceof EAttribute) {
				EAttribute attr = (EAttribute) next;
				if (!attr.isDerived() && attr.isChangeable()) {
					MERGEABLE_FEATURES.add(attr);
				}
			} else if (next instanceof EReference) {
				EReference ref = (EReference) next;

				if (!ref.isDerived() && ref.isChangeable()
					&& !ref.isContainer() && !ref.isContainment()) {
					MERGEABLE_FEATURES.add(ref);
				}
			}
		}

		// these semi-derived features are handled by the owned EGenericTypes
		MERGEABLE_FEATURES.remove(EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		MERGEABLE_FEATURES.remove(EcorePackage.Literals.ECLASS__ESUPER_TYPES);

		// every EEnumLiteral must determine this for itself
		MERGEABLE_FEATURES
			.remove(EcorePackage.Literals.EENUM_LITERAL__INSTANCE);

		// handle UML generically, excluding supersets and subsets of
		// containment
		// or container references
		for (TreeIterator<?> iter = UMLPackage.eINSTANCE.eAllContents(); iter
			.hasNext();) {
			Object next = iter.next();

			if (next instanceof EAttribute) {
				EAttribute attr = (EAttribute) next;
				if (!attr.isDerived() && attr.isChangeable()) {
					MERGEABLE_FEATURES.add(attr);
				}
			} else if (next instanceof EReference) {
				EReference ref = (EReference) next;

				if (!ref.isDerived()
					&& ref.isChangeable()
					&& !ref.isContainer()
					&& !ref.isContainment()) {
					MERGEABLE_FEATURES.add(ref);
				}
			}
		}

		// specific UML properties that we merge
		MERGEABLE_FEATURES.addAll(EXTERNAL_REFERENCES);
		MERGEABLE_FEATURES.add(UMLPackage.Literals.CLASSIFIER__IS_ABSTRACT);
		MERGEABLE_FEATURES.add(UMLPackage.Literals.TYPED_ELEMENT__TYPE);
		MERGEABLE_FEATURES.add(UMLPackage.Literals.PROPERTY__AGGREGATION);		
	}
	
	@Override
	protected com.zeligsoft.base.util.ModelMerger.IKeyExtractor<EObject, IHierarchicalKey> createKeyExtractor() {

		return new IDLKeyExtractor<EObject, IHierarchicalKey>();
		
	}
	
	protected static class IDLKeyExtractor<T extends EObject, K extends IHierarchicalKey> implements IKeyExtractor<T, K> {

		@SuppressWarnings("unchecked")
		public K getKey(T element) {
			if( ZDLUtil.isZDLConcept(element, CXDomainNames.CXNAMED_ELEMENT) == true ) {
				return (K) new IDLElementKey(element);			
			} else if( ZDLUtil.isZDLConcept(element, CXDomainNames.IDLFILE)) {
				return (K) new IDLFileKey(element);
			}
			return null;
		}
		
	}
	
	/**
	 * Create a customized pruner.
	 * 
	 * @return an IDL pruner
	 */
	protected TargetPruner createTargetPruner() {
		return new IDLTargetPruner();
	}
	
	protected class IDLTargetPruner extends TargetPruner {
		
		/**
		 * A variation on the basic implementation of the target pruning algorithm.
		 * 
		 * When pruning an IDL element, also clean up its applied stereotypes.
		 * 
		 * @param object
		 *            an element in the target model
		 */
		@Override
		protected void prune(EObject object) {
			
			EObject source = findSource(object);

			if (source == null) {
				
				if( ZDLUtil.isZDLConcept(object, ZMLMMNames.NAMED_ELEMENT)) {
					
					Element ne = (Element)object;
					Object[] applications = ne.getStereotypeApplications().toArray();
					for( Object eobj : applications ) {
						ne.unapplyStereotype(UMLUtil.getStereotype((EObject)eobj));
					}
				}
				
				// remove this object which no longer is needed in the target
				EcoreUtil.remove(object);
				object.eAdapters().clear();
				targetMap.remove(getKey(object));
				targetSourceCache.remove(object); // shouldn't be there, but
				// ...

				for (Iterator<EObject> iter = object.eAllContents(); iter
					.hasNext();) {
					EObject next = iter.next();

					if( next instanceof Element ) {
						Element ne = (Element)next;
						Object[] applications = ne.getStereotypeApplications().toArray();
						for( Object eobj : applications ) {
							ne.unapplyStereotype(UMLUtil.getStereotype((EObject)eobj));
						}
					}
					
					EObject descendent = next;
					descendent.eAdapters().clear();
					targetMap.remove(getKey(descendent));
					targetSourceCache.remove(descendent);
				}

				// and don't continue down the tree
			} else {
				// prune mergeable feature values that are not in the source
				// model. Don't propagate null values from the source model
				// because we consider them as "uninitialized"
				for (EStructuralFeature feature : object.eClass()
					.getEAllStructuralFeatures()) {
					if (isMergeableFeature(object, feature)) {
						if (FeatureMapUtil.isMany(object, feature)) {
							EList<?> targetValue = (EList<?>) object
								.eGet(feature);
							EList<?> sourceValue = (EList<?>) source
								.eGet(feature);

							targetValue.retainAll(sourceValue);
						} else if (source.eIsSet(feature)
							&& (source.eGet(feature) == null)) {
							object.eSet(feature, null);
						}
					}
				}

				// continue down the tree
				pruneContents(object);
			}
		}
	}
	
	@Override
	protected List<EObject> getContentsToMerge(EObject object, Phase phase) {

		List<EObject> result = super.getContentsToMerge(object, phase);

		if (object instanceof Element && (
				ZDLUtil.isZDLConcept(object, CXDomainNames.CXNAMED_ELEMENT) ||
				ZDLUtil.isZDLConcept(object, CXDomainNames.IDLFILE)	
			)) {
			// the stereotype applications also have to be merged.
			Element element = (Element) object;

			List<EObject> stereos = element.getStereotypeApplications();
			if (!stereos.isEmpty()) {
				result = safeList(result, phase);
				result.addAll(stereos);
			}
		}

		return result;
	}
	
	@Override
	protected boolean isMergeableFeature(EObject owner,
			EStructuralFeature feature) {
		EPackage pkg = feature.getEContainingClass().getEPackage();
		if (pkg.eContainer() instanceof EAnnotation) {
			// it's a stereotype property. Do not merge the metaclass
			// extensions (base_* properties)
			return !feature.getName().startsWith(
				Extension.METACLASS_ROLE_PREFIX)
				&& super.isMergeableFeature(owner, feature);
		}

		return MERGEABLE_FEATURES.contains(feature)
			&& super.isMergeableFeature(owner, feature);
	}

	@Override
	protected ReferenceFixer createReferenceFixer() {
		return new IDLReferenceFixer();
	}
	
	/**
	 * An IDL reference fixer that extends the base reference fixer
	 * to include support for directed relationships between CX
     * elements.
	 * 
	 * @author Sean McFee
	 */
	protected class IDLReferenceFixer extends ReferenceFixer {

		/**
		 * Recursively fixes references in the specified <tt>objects</tt> and
		 * their children.
		 * 
		 * @param objects
		 *            a list of objects whose references are to be fixed
		 */
		@Override
		protected void fixReferences(List<EObject> objects) {
			for (EObject next : objects) {
				if (fixReferences(next)) {
					fixReferences(getContentsToMerge(next, Phase.FIX));
				}
			}
		}

		/**
		 * Implements the cross-reference fixing behaviour for an object in the
		 * target model.
		 * 
		 * @param object
		 *            an object whose references should be fixed
		 * @return whether to continue into the descendants of the object
		 */
		@Override
		protected boolean fixReferences(EObject object) {
			basicFixReferences(object);
			
			if( ZDLUtil.isZDLConcept(object, CXDomainNames.IDLIMPORT) && object instanceof Dependency) {
				// Edges on diagrams representing IDLImport elements that merged need to be repaired.
				Dependency idlImport = (Dependency)object;
				for (TreeIterator<?> iter = object.eResource().getAllContents(); iter.hasNext(); ) {
					Object next = iter.next();
					if( next instanceof Edge ) {
						Edge e = (Edge)next;
						if( e.getType().matches("") && //$NON-NLS-1$
							ZDLUtil.isZDLConcept(e.getSource().getElement(), CXDomainNames.IDLFILE) &&
							ZDLUtil.isZDLConcept(e.getTarget().getElement(), CXDomainNames.IDLFILE)) {
							if( idlImport.getClients().get(0).getName().matches(((NamedElement)e.getSource().getElement()).getName()) &&
								idlImport.getSuppliers().get(0).getName().matches(((NamedElement)e.getTarget().getElement()).getName())) {
								idlImport.setName(((Dependency)e.getElement()).getName());
								e.setElement(object);
							}
						}
					}
				}
			}
			else if( ZDLUtil.isZDLConcept(object, ZMLMMNames.NAMED_ELEMENT) 
					&& object instanceof NamedElement ) {
				EObject source = findSource(object);

				// Checking the entire resource is necessary because it is elements outside the mergeable set that will
				// have problems if their references are not updated.
				for (TreeIterator<?> iter = object.eResource().getAllContents(); iter.hasNext(); ) {
					Object next = iter.next();
					
					if( next instanceof DirectedRelationship ) {
						DirectedRelationship dr = (DirectedRelationship)next;
						
						// We need to support the directed relationships that can exist in IDL mergeable elements.
						if( dr.getTargets().contains(source)) {
							if( dr instanceof Generalization ) {
								((Generalization)dr).setGeneral((Classifier)object);
							} else if( dr instanceof Dependency ) {
								((Dependency)dr).getSuppliers().remove(source);
								((Dependency)dr).getSuppliers().add((NamedElement)object);
								if( dr instanceof InterfaceRealization ) {
									((InterfaceRealization)dr).setContract((Interface)object);
								}
							}
						}
					}
				}
			}
			
			return true;
		}

	}
}
