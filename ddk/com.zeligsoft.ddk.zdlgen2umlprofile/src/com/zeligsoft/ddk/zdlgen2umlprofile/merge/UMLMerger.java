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
package com.zeligsoft.ddk.zdlgen2umlprofile.merge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.toolingmodel.PaletteItem;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;
import com.zeligsoft.base.toolingmodel.util.ToolingModelSwitch;
import com.zeligsoft.base.util.ModelMerger;
import com.zeligsoft.base.util.ModelMerger.IHierarchicalKey;

/**
 * A specialized model merger for merging UML profiles. The merge keys are
 * qualified names (which, sometimes, are constructed proxy names, as for
 * metaclass extensions and other relationships that are not even named
 * elements).
 * 
 * @author Christian W. Damus (cdamus)
 */
public class UMLMerger
		extends ModelMerger<EObject, IHierarchicalKey> {

	/** The annotation source that identifies the profile definition EPackages. */
	@SuppressWarnings("unused")
	private static final String PROFILE_DEFINITIONS_ANNOTATION = "http://www.eclipse.org/uml2/2.0.0/UML"; //$NON-NLS-1$

	/** The annotation source that identifies the profile diagrams. */
	private static final String PROFILE_DIAGRAMS_ANNOTATION = "uml2.profile.diagrams"; //$NON-NLS-1$

	// the only references outside of the profile are the imported elements and
	// packages, and applied profiles
	private static final Set<EReference> EXTERNAL_REFERENCES = new java.util.HashSet<EReference>(
		Arrays.asList(UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE,
			UMLPackage.Literals.PACKAGE_IMPORT__IMPORTED_PACKAGE,
			UMLPackage.Literals.ELEMENT_IMPORT__IMPORTED_ELEMENT));

	private static final Set<EStructuralFeature> MERGEABLE_FEATURES = new java.util.HashSet<EStructuralFeature>();

	private static final Set<EStructuralFeature> ECORE_ORDERED_FEATURES = new java.util.HashSet<EStructuralFeature>();
	
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
		SupersetSubsetAnalyzer analyzer = SupersetSubsetAnalyzer.getInstance();
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
					&& !ref.isContainment()
					&& !analyzer
						.isSupersetOrSubsetOfContainerOrContainment(ref)) {

					MERGEABLE_FEATURES.add(ref);
				}
			}
		}

		// specific UML properties that we merge
		MERGEABLE_FEATURES.addAll(EXTERNAL_REFERENCES);
		MERGEABLE_FEATURES.add(UMLPackage.Literals.CLASSIFIER__IS_ABSTRACT);
		MERGEABLE_FEATURES.add(UMLPackage.Literals.TYPED_ELEMENT__TYPE);
		MERGEABLE_FEATURES.add(UMLPackage.Literals.PROPERTY__AGGREGATION);

		// and palette model properties
		MERGEABLE_FEATURES.add(ToolingModelPackage.Literals.PALETTE_ITEM__NAME);
		MERGEABLE_FEATURES.add(ToolingModelPackage.Literals.PALETTE_ITEM__DESCRIPTION);
		MERGEABLE_FEATURES.add(ToolingModelPackage.Literals.CREATION_TOOL__ELEMENT_TYPE_HINT);
		MERGEABLE_FEATURES.add(ToolingModelPackage.Literals.CREATION_TOOL__CONCEPT);
		MERGEABLE_FEATURES.add(ToolingModelPackage.Literals.LINK_TOOL__REFERENCE);
		MERGEABLE_FEATURES.add(ToolingModelPackage.Literals.STACK__ACTIVE_TOOL);
		MERGEABLE_FEATURES.add(ToolingModelPackage.Literals.TOOL_CONTAINER__TARGET_DIAGRAM);
		
		
		// no ordering is significant in Ecore except for the operation
		// parameters list and generic type parameters list (both "signatures")
		// and the EClass super-types (important to code generation)
		ECORE_ORDERED_FEATURES.add(EcorePackage.Literals.EOPERATION__EPARAMETERS);
		ECORE_ORDERED_FEATURES.add(EcorePackage.Literals.EOPERATION__ETYPE_PARAMETERS);
		ECORE_ORDERED_FEATURES.add(EcorePackage.Literals.ECLASSIFIER__ETYPE_PARAMETERS);
		ECORE_ORDERED_FEATURES.add(EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		ECORE_ORDERED_FEATURES.add(EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES);
		
	}

	/**
	 * Capsules of object-contents extractors that are sensitive to the
	 * particular phase in the merge algorithm.
	 */
	private final Map<Phase, MergeContentsExtractor> mergeContentsExtractors = new java.util.HashMap<Phase, MergeContentsExtractor>();

	private ResourceSet context;

	/**
	 * Initializes me.
	 */
	public UMLMerger() {
		mergeContentsExtractors.put(Phase.PRUNE, new MergeContentsExtractor(
			Phase.PRUNE));
		mergeContentsExtractors.put(Phase.UPDATE, new MergeContentsExtractor(
			Phase.UPDATE));
		mergeContentsExtractors.put(Phase.FIX, new MergeContentsExtractor(
			Phase.FIX));
	}

	@Override
	public void merge(List<EObject> sources, List<EObject> targets) {
		// capture the resource-set context for resolution of proxies
		context = targets.get(0).eResource().getResourceSet();

		super.merge(sources, targets);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IKeyExtractor<EObject, IHierarchicalKey> createKeyExtractor() {
		return new CompositeHierarchicalKeyExtractor<IHierarchicalKey>(
			new UMLNameExtractor(), new EcoreNameExtractor(),
			new PaletteNameExtractor());
	}

	@Override
	protected Set<EReference> getExternalCrossReferences() {
		return EXTERNAL_REFERENCES;
	}

	@Override
	protected List<EObject> getContentsToMerge(EObject object, Phase phase) {
		List<EObject> result = mergeContentsExtractors.get(phase).doSwitch(
			object);

		if (object instanceof Element) {
			// cover stereotype applications of a UML element
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
	protected boolean isOrderSignificant(EStructuralFeature feature) {
		EClass eclass = feature.getEContainingClass();

		if ((eclass != null)
			&& (eclass.getEPackage() == EcorePackage.eINSTANCE)) {
			
			// no ordering is significant in Ecore except for the operation
			// parameters list and generic type parameters list (both
			// "signatures" of a sort)
			return ECORE_ORDERED_FEATURES.contains(feature);
		}

		return super.isOrderSignificant(feature);
	}

	@Override
	protected TargetPruner createTargetPruner() {
		return new UMLPruner();
	}

	@Override
	protected TargetUpdater createTargetUpdater() {
		return new UMLUpdater();
	}

	@Override
	protected ReferenceFixer createReferenceFixer() {
		return new UMLFixer();
	}

	//
	// Nested utility classes
	//

	private class UMLUpdater
			extends TargetUpdater {

		@Override
		protected void updateFrom(EObject object) {
			if (object instanceof Element) {
				// update stereotypes
				Element element = (Element) object;
				Element target = findTarget(element);

				List<EObject> sourceStereos = element
					.getStereotypeApplications();

				for (EObject next : sourceStereos) {
					if (findTarget(next) == null) {
						UMLUtil.setBaseElement(remap(next), target);
					}
				}
			}

			super.updateFrom(object);
		}
	}

	private class UMLPruner
			extends TargetPruner {

		@Override
		protected void prune(EObject object) {
			Stereotype stereotype = UMLUtil.getStereotype(object);
			if (stereotype != null) {
				EObject source = findSource(object);

				if (source == null) {
					// unapply stereotype if permitted
					Element baseElement = UMLUtil.getBaseElement(object);

					if (!baseElement.isStereotypeRequired(stereotype)) {
						baseElement.unapplyStereotype(stereotype);
					}

					return;
				}
			} else if (object instanceof EPackage) {
				if (object.eContainer() instanceof EAnnotation) {
					EAnnotation annot = (EAnnotation) object.eContainer();
					if (annot.eContainer() instanceof Profile) {
						return;
					}
				}
			} else {
				super.prune(object);
			}
		}
	}

	private class UMLFixer
			extends ReferenceFixer {

		@Override
		protected boolean fixReferences(EObject object) {
			boolean result = super.fixReferences(object);

			Stereotype stereotype = UMLUtil.getStereotype(object);
			if (stereotype != null) {
				// fix the base-element reference

				Element source = UMLUtil.getBaseElement(object);
				Element target = findTarget(source);

				if ((target != null) && (target != source)) {
					UMLUtil.setBaseElement(object, target);
				}

			}

			return result;
		}
	}

	/**
	 * A switcher that knows how to extract the contents that we want to process
	 * in a specific phase of the merge operation.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class MergeContentsExtractor
			extends UMLSwitch<List<EObject>> {

		/** A delegate switch for handling the Ecore content of a profile. */
		private final EcoreSwitch<List<EObject>> ecore = new EcoreSwitch<List<EObject>>() {

			@Override
			public List<EObject> defaultCase(EObject object) {
				return basicGetContentsToMerge(object, phase);
			}

			/**
			 * We merge only the current (latest) Ecore definition of the
			 * profile.
			 */
			@Override
			public List<EObject> caseEAnnotation(EAnnotation object) {
				List<EObject> result = basicGetContentsToMerge(object, phase);

				result = safeList(result, phase);
				return result;
			}
		};

		/** The merge phase to which I pertain. */
		private final Phase phase;

		MergeContentsExtractor(Phase phase) {
			this.phase = phase;
		}

		@Override
		public List<EObject> defaultCase(EObject object) {
			return ecore.doSwitch(object);
		}

		/**
		 * We don't merge the profile diagrams
		 */
		@Override
		public List<EObject> caseProfile(Profile object) {
			List<EObject> result = safeList(basicGetContentsToMerge(object,
				phase), phase);

			result.remove(object.getEAnnotation(PROFILE_DIAGRAMS_ANNOTATION));

			return result;
		}
	}

	/**
	 * A key extractor based on UML element names. For elements that don't have
	 * names (many of the relationship types), proxy-names are constructed for
	 * them.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class UMLNameExtractor
			extends ComposedHierarchicalKeyExtractor<IHierarchicalKey> {

		private UMLSwitch<IHierarchicalKey> sw = new UMLSwitch<IHierarchicalKey>() {

			@Override
			public IHierarchicalKey caseNamedElement(NamedElement object) {
				return new NamedElementKey(object);
			}

			/* (non-Javadoc)
			 * @see org.eclipse.uml2.uml.util.UMLSwitch#caseProfile(org.eclipse.uml2.uml.Profile)
			 */
			@Override
			public IHierarchicalKey caseProfile(Profile object) {
				return new ProfileKey(object);
			}

			/**
			 * Handles properties that are unnamed, which commonly occurs in
			 * associations.
			 */
			@Override
			public IHierarchicalKey caseProperty(Property object) {
				return new PropertyKey(object);
			}

			/**
			 * Computes a proxy name for associations. Unlike other
			 * {@linkplain #caseRelationship(Relationship) relationships}, it
			 * makes sense for multiple associations to be defined between the
			 * same classifiers. Thus, rather than identifying associations by
			 * their related elements (the classifiers) as we do for other
			 * relationships, we identify them by their member ends, which
			 * should have distinguishing role names.
			 */
			@Override
			public IHierarchicalKey caseAssociation(Association object) {
				// unlike other relationships, we combine the role names with
				// the qualified names of their types to precisely identify
				// associations
				Map<String, IHierarchicalKey> classifiers = new java.util.HashMap<String, IHierarchicalKey>();

				for (Property end : object.getMemberEnds()) {
					if (end.eIsProxy()) {
						end = (Property) EcoreUtil.resolve(end, context);
					}

					Type endType = end.getType();

					String endName = end.getName();
					if (endName == null) {
						endName = endType.getName();
						endName = "" + Character.toLowerCase(endName.charAt(0)) //$NON-NLS-1$
							+ endName.substring(1);
					}

					classifiers.put(endName, getKey(endType));
				}

				return new AssociationKey(object, classifiers);
			}

			/**
			 * Computes a proxy name for relationships. Even for those that are
			 * UML named elements (such as associations), I generate a proxy
			 * name that combines the qualified names (keys) of the related
			 * elements to ensure that we don't recognize a relationship when
			 * the related elements are changed.
			 */
			@Override
			public IHierarchicalKey caseDirectedRelationship(
					DirectedRelationship object) {
				Set<IHierarchicalKey> sources = new java.util.HashSet<IHierarchicalKey>();
				Set<IHierarchicalKey> targets = new java.util.HashSet<IHierarchicalKey>();

				for (Element next : object.getSources()) {
					if (next.eIsProxy()) {
						next = (Element) EcoreUtil.resolve(next, context);
					}

					sources.add(getKey(next));
				}

				for (Element next : object.getTargets()) {
					if (next.eIsProxy()) {
						next = (Element) EcoreUtil.resolve(next, context);
					}

					targets.add(getKey(next));
				}

				return new DirectedRelationshipKey(object, sources, targets);
			}

			/**
			 * Use the value specification's string value as its name.
			 */
			@Override
			public IHierarchicalKey caseValueSpecification(
					ValueSpecification object) {
				return new ValueSpecificationKey(object);
			}

			@Override
			public IHierarchicalKey caseComment(Comment object) {
				return new CommentKey(object);
			}
		};

		@Override
		protected IHierarchicalKey createKey(EObject element) {
			return sw.doSwitch(element);
		}
	}

	/**
	 * A key extractor based on Ecore element names. For elements that don't
	 * have names (annotations and their details), suitable names are computed.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class EcoreNameExtractor
			extends ComposedHierarchicalKeyExtractor<IHierarchicalKey> {

		private EcoreSwitch<IHierarchicalKey> sw = new EcoreSwitch<IHierarchicalKey>() {

			@Override
			public IHierarchicalKey defaultCase(EObject object) {
				Stereotype stereotype = UMLUtil.getStereotype(object);
				if (stereotype != null) {
					// ... a stereotype
					Element baseElement = UMLUtil.getBaseElement(object);
					return new StereotypeApplicationKey(baseElement,
						getKey(baseElement), stereotype);
				}

				return null;
			}

			@Override
			public IHierarchicalKey caseENamedElement(ENamedElement object) {
				return new NamedElementKey(object);
			}

			@Override
			public IHierarchicalKey caseEPackage(EPackage object) {
				// match EPackages by position (effectively, the version number)
				if (object.eContainer() instanceof EAnnotation) {
					EAnnotation annot = (EAnnotation) object.eContainer();

					if (annot.eContainer() instanceof Profile) {
						List<?> siblings = annot.getContents();
						return new ProfileDefinitionKey(object, siblings
							.indexOf(object));
					}
				}

				// it's an Ecore metamodel
				return new NamedElementKey(object);
			}

			@Override
			public IHierarchicalKey caseEGenericType(EGenericType object) {
				return new NamedElementKey(object.getERawType());
			}

			/**
			 * Use the annotation source as its name.
			 */
			@Override
			public IHierarchicalKey caseEAnnotation(EAnnotation object) {
				return new NamedElementKey(object);
			}

			/**
			 * Use the detail key as its name.
			 */
			@Override
			public IHierarchicalKey caseEStringToStringMapEntry(
					Entry<String, String> object) {
				return new NamedElementKey(object);
			}
		};

		@Override
		protected IHierarchicalKey createKey(EObject element) {
			return sw.doSwitch(element);
		}
	}

	/**
	 * A key extractor based on Palette element names.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class PaletteNameExtractor
			extends ComposedHierarchicalKeyExtractor<IHierarchicalKey> {

		private ToolingModelSwitch<IHierarchicalKey> sw = new ToolingModelSwitch<IHierarchicalKey>() {

			@Override
			public IHierarchicalKey casePaletteItem(PaletteItem object) {
				return new PaletteItemKey(object);
			}
		};

		@Override
		protected IHierarchicalKey createKey(EObject element) {
			return sw.doSwitch(element);
		}
	}
}
