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
package com.zeligsoft.base.zdl.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.types.core.requests.SetStereotypeValueRequest;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.util.FilteringList;
import com.zeligsoft.base.util.TransformingList;
import com.zeligsoft.base.workflow.RSMWriter;
import com.zeligsoft.base.zdl.Activator;
import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.l10n.Messages;

/**
 * Utilities for introspection of Zeligsoft component models in terms of the
 * domain models that profile them. These utilities trace the domain-specific
 * stereotypes applied to UML model elements to the ZDL concepts from which they
 * are derived.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLUtil
		extends UMLUtil {

	/**
	 * The URI of the ZDL profile.
	 */
	public static final URI ZDL_PROFILE_URI = URI.createURI("pathmap://ZDL_PROFILES/ZDL.profile.uml"); //$NON-NLS-1$
    
	/**
	 * The namespace URI of the ZDL schema.
	 */
	public static final String ZDL_NAMESPACE_URI = "http://www.zeligsoft.com/zdl/2008/ZDL"; //$NON-NLS-1$

	/**
	 * Qualified name of the ZDL <tt>DomainConcept</tt> stereotype.
	 */
	private static final String ZDL_CONCEPT_STEREOTYPE = "ZDL::DomainConcept"; //$NON-NLS-1$

	/**
	 * Qualified name of the ZDL <tt>DomainEnum</tt> stereotype.
	 */
	private static final String ZDL_ENUM_STEREOTYPE = "ZDL::DomainEnum"; //$NON-NLS-1$

	/**
	 * Cache of domain concept traces for stereotypes.
	 */
	private static Map<Stereotype, List<Class>> stereotypeToConcepts = new java.util.WeakHashMap<Stereotype, List<Class>>();

	/**
	 * Cache of the list of abstract concepts mapping to UML metaclasses, per
	 * profile (because these mappings are profile-specific).
	 */
	private static Map<Profile, Map<EClass, List<Class>>> profileToAbstractConcept = new java.util.WeakHashMap<Profile, Map<EClass, List<Class>>>();

	/**
	 * Cache of domain concepts by qualified name and by resource set. The
	 * values in this weak hash map will not leak after the ZDL models have been
	 * unloaded because, once unloaded, the domain-concept classes will no
	 * longer reference the resource sets in which they were loaded.
	 */
	private static Map<ResourceSet, Map<String, Class>> qnameToConcept = new java.util.WeakHashMap<ResourceSet, Map<String, Class>>();

	/**
	 * Cache of domain enumerations by qualified name and by resource set. The
	 * values in this weak hash map will not leak after the ZDL models have been
	 * unloaded because, once unloaded, the domain-enumerations will no longer
	 * reference the resource sets in which they were loaded.
	 */
	private static Map<ResourceSet, Map<String, Enumeration>> qnameToEnumeration = new java.util.WeakHashMap<ResourceSet, Map<String, Enumeration>>();

	private static final StereotypeApplicationHelper STEREOTYPE_APPLICATION_HELPER = new StereotypeApplicationHelper();

	/**
	 * Not publicly instantiable.
	 */
	protected ZDLUtil() {
		super();
	}

	/**
	 * Obtains the first ZDL concept of which the specified element is an
	 * instance. This is generally not useful, as an element may very well be an
	 * instance of multiple domain concepts simultaneously. Indeed, it usually
	 * is as the Zeligsoft Deployment profile has a number of abstract concepts
	 * that map to the <tt>NamedElement</tt> metaclass.
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * 
	 * @return the first ZDL concept of which it is an instance, or
	 *         <code>null</code> if it is a plain-vanilla UML element
	 * 
	 * @see #getZDLConcepts(EObject)
	 */
	public static Class getZDLConcept(EObject modelElement) {
		List<Class> result = getZDLConcepts(modelElement);

		return result.isEmpty()
			? null
			: result.get(0);
	}

	/**
	 * <p>
	 * Obtains the ZDL concepts of which the specified element is an instance.
	 * An element can be classified my multiple concepts under two conditions:
	 * </p>
	 * <ul>
	 * <li>the element has applied a stereotype that is the result of a merge
	 * of multiple concepts in a model that merges domain blocks</li>
	 * <li>the element is an instance of a UML metaclass which, in the
	 * element's contextual domain profile, represents one or more abstract
	 * concepts</li>
	 * </ul>
	 * <p>
	 * <b>Note</b> that a model element can be classified both by firm and by
	 * abstract concepts.
	 * </p>
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * 
	 * @return the ZDL concepts of which it is an instance, or an empty list if
	 *         it is a plain-vanilla UML element
	 */
	public static List<Class> getZDLConcepts(EObject modelElement) {
		return ZDLConceptInfo.get(modelElement).getConcepts();
	}

	/**
	 * Helper for the {@link #getZDLConcepts(Element)} method that computes the
	 * concepts to be cached on the adapter.
	 * 
	 * @param modelElement
	 *            a model element
	 * 
	 * @return its concepts
	 * 
	 * @see #getZDLConcepts(Element)
	 */
	static List<Class> computeZDLConcepts(EObject modelElement) {
		List<Class> result = null;

		if (modelElement instanceof Element) {
			Element element = (Element) modelElement;

			for (Stereotype stereotype : element.getAppliedStereotypes()) {
				result = getConcepts(stereotype);

				if (result != null) {
					break;
				}
			}

			// now, add the abstract concepts of which it is an instance
			EClass metaclass = modelElement.eClass();
			for (Profile profile : getAppliedZDLProfiles(modelElement)) {
				List<Class> abstractConcepts = getAbstractConcepts(profile,
					metaclass);

				if (result == null) {
					result = abstractConcepts;
				} else {
					List<Class> oldResult = result;
					result = new java.util.ArrayList<Class>(oldResult.size());
					result.addAll(oldResult);
					
					for(Class aCls : abstractConcepts) {
						boolean foundSpecialization = false;
						for(DirectedRelationship r : aCls.getTargetDirectedRelationships(UMLPackage.Literals.GENERALIZATION)){
							
							for(Element spec : r.getSources()) {
								if(result.contains(spec) || abstractConcepts.contains(spec)) {
									foundSpecialization = true;
									break;
								}
							}
							
							if(foundSpecialization) {
								break;
							}
						}
						
						if(!foundSpecialization) {
							result.add(aCls);
						}
					}
				}
			}
		} else {
			// try to get the profile
			Profile profile = null;

			if (modelElement.eResource() != null) {
				EObject root = modelElement.eResource().getContents().get(0);
				Set<Profile> profiles = ZDLUtil.getAppliedZDLProfiles(root);
				if (!profiles.isEmpty()) {
					profile = profiles.iterator().next();
				}
			}
			NamedElement element = getNamedElement(modelElement.eClass());
			if(element == null && profile != null) {
				element = getNamedElement(modelElement.eClass(), profile);
			}
			if (element instanceof Class) {
				// it is a profile class
				List<NamedElement> zdls = traceToZDL(element);
				if( zdls != null ) {
					result = new java.util.ArrayList<Class>(zdls.size());
					for (NamedElement next : zdls) {
						if (next instanceof Class) {
							result.add((Class) next);
						}
					}
				}
			}
		}

		return (result == null)
			? Collections.<Class> emptyList()
			: result;
	}

	/**
	 * Gets all of the firm concepts that a stereotype traces to. It may trace
	 * to multiple stereotypes in the case that it is the result of a merge of
	 * concepts from merged domain blocks.
	 * 
	 * @param stereotype
	 *            a stereotype
	 * 
	 * @return its source concepts
	 */
	private static List<Class> getConcepts(Stereotype stereotype) {
		List<Class> result;

		if (getZDLAnnotation(stereotype) == null) {
			// this stereotype is not from a domain profile
			result = null;
		} else {
			result = stereotypeToConcepts.get(stereotype);

			if (result == null) {
				List<NamedElement> traces = traceToZDL(stereotype);
				result = new java.util.ArrayList<Class>(traces.size());

				for (NamedElement zdl : traces) {
					if (zdl instanceof Class) {
						result.add((Class) zdl);
					}
				}

				if (result.size() == 1) {
					// more efficient storage than an ArrayList with a singleton
					// array
					result = Collections.singletonList(result.get(0));
				} else {
					result = Collections.unmodifiableList(result);
				}

				// store the result
				stereotypeToConcepts.put(stereotype, result);
			}
		}

		return result;
	}

	/**
	 * <p>
	 * Obtains the set of ZDL concepts of which the specified element is an instance.
	 * 
	 * The difference between this method and getZDLConcepts(EObject) is that this method 
	 * returns not only the list of firm or abstract concepts for the model element passed
	 * in, but also any concepts that are generalized by those concepts. It therefore is
	 * somewhat related to the isZDLConcept method, which returns true for any generalized
	 * method. 
	 * 
	 * </p>
	 * 
	 * @author smcfee
	 * 
	 * @param modelElement
	 * 		a model element
	 * @return
	 * 		a set of concept classes
	 */
	public static Set<Class> getAllZDLConcepts(EObject modelElement) {
		return ZDLConceptInfo.get(modelElement).getAllConcepts();
	}

	/**
	 * Obtains the concepts that, in a particular profile mapping, are abstract
	 * concepts that map to the specified UML metaclass.
	 * 
	 * @param profile
	 *            a ZDL profile
	 * @param metaclass
	 *            the UML metaclass
	 * 
	 * @return the list of abstract concepts that map to the specified
	 *         metaclass, which may be an empty list
	 */
	private static List<Class> getAbstractConcepts(Profile profile,
			EClass metaclass) {

		Map<EClass, List<Class>> map = profileToAbstractConcept.get(profile);
		if (map == null) {
			map = new java.util.HashMap<EClass, List<Class>>();
			profileToAbstractConcept.put(profile, map);

			// this is a good time to resolve all proxies in reachable from
			// this profile, to ensure that all of its dependent ZDL models
			// are loaded
			EcoreUtil.resolveAll(profile);
		}

		List<Class> result = map.get(metaclass);
		if (result == null) {
			List<Class> concepts = new java.util.ArrayList<Class>();

			ResourceSet rset = getContextResourceSet(profile);
			EAnnotation annot = getZDLAnnotation(profile);
			for (Map.Entry<String, String> detail : annot.getDetails()) {
				EClassifier other = UMLPackage.eINSTANCE.getEClassifier(detail
					.getValue());

				if ((other instanceof EClass)
					&& ((EClass) other).isSuperTypeOf(metaclass)) {

					Class concept = getZDLConcept(rset, detail.getKey());
					if (concept != null) {
						concepts.add(concept);
					}
				}
			}

			if (concepts.size() == 1) {
				// more efficient storage than an ArrayList with a singleton
				// array
				result = Collections.singletonList(concepts.get(0));
			} else {
				// resize the list to the right size
				result = new java.util.ArrayList<Class>(concepts.size());
				result.addAll(concepts);
				result = Collections.unmodifiableList(result);
			}

			map.put(metaclass, result);
		}

		return result;
	}

	/**
	 * Classifies a model element by the specified concept, if it is not already
	 * and the concept is applicable to the element in the current profile
	 * context.
	 * 
	 * @param modelElement
	 *            a model element
	 * @param concept
	 *            a concept that should classify the model element
	 * 
	 * @throws IllegalArgumentException
	 *             if either the model element already is of the specified
	 *             concept or if the concept cannot classify the element, or,
	 *             finally
	 */
	public static void addZDLConcept(Element modelElement, Class concept) {
		CacheAdapter cache = CacheAdapter.getCacheAdapter(concept);
		if (cache == null) {
			throw new IllegalArgumentException("no CacheAdapter for concept"); //$NON-NLS-1$
		}

		boolean applied = false;

		for (EStructuralFeature.Setting setting : cache
			.getNonNavigableInverseReferences(concept)) {
			if (setting.getEStructuralFeature() == EcorePackage.Literals.EANNOTATION__REFERENCES) {
				EAnnotation annot = (EAnnotation) setting.getEObject();
				EModelElement owner = annot.getEModelElement();

				if (ZDL_NAMESPACE_URI.equals(annot.getSource())
					&& (owner instanceof Stereotype)) {
					Stereotype stereotype = (Stereotype) owner;

					if (modelElement.isStereotypeApplicable(stereotype)) {
						modelElement.applyStereotype(stereotype);
						applied = true;
						break;
					}
				}
			}
		}

		if (!applied) {
			throw new IllegalArgumentException(
				"concept cannot classify the element"); //$NON-NLS-1$
		}
	}

	/**
	 * Classifies a model element by the specified concept, if it is not already
	 * and the concept is applicable to the element in the current profile
	 * context.
	 * 
	 * @param modelElement
	 *            a model element
	 * @param concept
	 *            the qualified name of a concept that should classify the model
	 *            element
	 * 
	 * @throws IllegalArgumentException
	 *             if either the model element already is of the specified
	 *             concept or if the concept cannot classify the element, or,
	 *             finally
	 */
	public static void addZDLConcept(Element modelElement, String concept) {
		if (isZDLConcept(modelElement, concept)) {
			throw new IllegalArgumentException(
				"modelElement already is this concept"); //$NON-NLS-1$
		}

		Class conceptClass = getZDLConcept(modelElement, concept);

		if (conceptClass == null) {
			throw new IllegalArgumentException(
				"concept cannot classify the element"); //$NON-NLS-1$
		}

		addZDLConcept(modelElement, conceptClass);
	}

	/**
	 * Creates a new instance of the specified concept in an owner object of the
	 * given concept, storing it in the specified property.
	 * 
	 * @param owner
	 *            the object to own the new concept instance
	 * @param ownerConcept
	 *            the concept of the owner of the new object
	 * @param property
	 *            the name of the property to store the new element in
	 * @param concept
	 *            the concept to instantiate
	 * 
	 * @return the new instance of the concept
	 */
	public static EObject createZDLConcept(EObject owner, String ownerConcept,
			String property, String concept) {

		Class ownerConceptClass = requireZDLConcept(owner, ownerConcept);
		Class conceptClass = getZDLConcept(owner, concept);

		return createZDLConcept(owner, ownerConceptClass, property,
			conceptClass);
	}

	/**
	 * Creates a new instance of the specified concept in an owner object of the
	 * given concept, storing it in the specified property.
	 * 
	 * @param owner
	 *            the object to own the new concept instance
	 * @param ownerConcept
	 *            the concept of the owner of the new object
	 * @param property
	 *            the name of the property to store the new element in
	 * @param concept
	 *            the concept to instantiate
	 * 
	 * @return the new instance of the concept
	 */
	public static EObject createZDLConcept(EObject owner, Class ownerConcept,
			String property, Class concept) {
		ZDLPropertyMapping mapping = getPropertyMapping(owner, ownerConcept,
			property);
		Profile profile = mapping.getProfile();

		EObject result;

		String metaclassName = getAbstractConceptMapping(profile, concept);
		if (metaclassName != null) {
			result = UMLFactory.eINSTANCE.create((EClass) UMLPackage.eINSTANCE
				.getEClassifier(metaclassName));
		} else {
			Class umlClass = getProfileClass(profile, concept);

			if (umlClass instanceof Stereotype) {
				// create stereotype application and return it
				return createZDLConceptIn(owner, concept);
			} else {
				EClass eclass = (EClass) profile.getDefinition(umlClass);
				result = EcoreUtil.create(eclass);
			}
		}

		if (mapping.isMany(owner)) {
			@SuppressWarnings("unchecked")
			List<EObject> value = (List<EObject>) mapping.getValue(owner);
			value.add(result);
		} else {
			mapping.setValue(owner, result);
		}
		
		// make sure that the stereotype applications are stored in the
		// same resource as the element.
		if(result instanceof Element && result.eResource() != null) {
			result.eResource().getContents().addAll(((Element) result).getStereotypeApplications());
		}

		return result;
	}

	/**
	 * <p>
	 * Creates a new instance of the specified concept in the particular profile
	 * mapping applicable in the given <tt>context</tt> element.
	 * </p>
	 * <p>
	 * <b>Note</b> that care must be taken with this method when it creates an
	 * instance of a stereotype-mapped concept, as the new instance will not be
	 * attached to any resource, so its stereotype application will be
	 * free-floating. The {@link RSMWriter} oAW component takes care of this
	 * situation by finding all floating stereotype instances and persisting
	 * them in the resource.
	 * </p>
	 * 
	 * @param context
	 *            an element in the context of the profile mapping
	 * @param concept
	 *            the concept to instantiate
	 * 
	 * @return the new instance of the concept
	 */
	public static EObject createZDLConcept(EObject context, String concept) {

		Class conceptClass = getZDLConcept(context, concept);

		return createZDLConcept(context, conceptClass);
	}

	/**
	 * <p>
	 * Creates a new instance of the specified concept class in the particular
	 * profile mapping applicable in the given <tt>context</tt> element.
	 * </p>
	 * <p>
	 * <b>Note</b> that care must be taken with this method when it creates an
	 * instance of a stereotype-mapped concept, as the new instance will not be
	 * attached to any resource, so its stereotype application will be
	 * free-floating. User is responsible to add this free floating stereotype
	 * application to the appropriate resource.
	 * </p>
	 * 
	 * @param context an element in the context of the profile mapping, or the
	 *                profile, itself
	 * @param concept the concept to instantiate
	 * 
	 * @return the new instance of the concept as a stereotype application not as an
	 *         UML element
	 *
	 */
	public static EObject createZDLConcept(EObject context, Class concept) {
		Profile profile;

		if (context instanceof Profile) {
			profile = (Profile) context;
		} else {
			profile = getZDLProfile(context, concept);
		}

		EObject result;
		Stereotype stereotype = null;
		EObject stereotypeApplication = null;

		String metaclassName = getAbstractConceptMapping(profile, concept);
		if (metaclassName != null) {
			result = UMLFactory.eINSTANCE.create((EClass) UMLPackage.eINSTANCE
				.getEClassifier(metaclassName));
		} else {
			Class umlClass = getProfileClass(profile, concept);

			if (umlClass instanceof Stereotype) {
				// create the base element
				stereotype = (Stereotype) umlClass;
				metaclassName = getExtendedMetaclass(stereotype).getName();
				result = UMLFactory.eINSTANCE
					.create((EClass) UMLPackage.eINSTANCE
						.getEClassifier(metaclassName));

				// create and attach the stereotype
				EClass stereotypeEClass = (EClass) profile
					.getDefinition(stereotype);

				// apply the stereotype
				stereotypeApplication = applyStereotype((Element) result, stereotypeEClass, stereotype);
			} else {
				EClass eclass = (EClass) profile.getDefinition(umlClass);
				result = EcoreUtil.create(eclass);
			}
		}

		// ensure that the new object is immediately recognizable as its
		// concept despite net yet being attached to the model
		ZDLConceptInfo.initialize(result, profile, concept);

		return stereotypeApplication == null ? result : stereotypeApplication;
	}

	/**
	 * Queries whether it is possible to create a new instance of the specified
	 * concept in the specified <tt>container</tt> element.
	 * 
	 * @param container
	 *            an element in which to create a domain concept instance
	 * @param concept
	 *            the concept to instantiate
	 * 
	 * @return whether the concept can be instantiated in this container
	 */
	public static boolean canCreateZDLConceptIn(EObject container,
			String concept) {

		Class conceptClass = getZDLConcept(container, concept);

		return (conceptClass == null)
			? false
			: canCreateZDLConceptIn(container, conceptClass);
	}

	/**
	 * Queries whether it is possible to create a new instance of the specified
	 * concept in the specified <tt>container</tt> element.
	 * 
	 * @param container
	 *            an element in which to create a domain concept instance
	 * @param concept
	 *            the concept to instantiate
	 * 
	 * @return whether the concept can be instantiated in this container
	 */
	public static boolean canCreateZDLConceptIn(EObject container, Class concept) {
		Profile profile = getZDLProfile(container, concept);

		EClass resultType;

		String metaclassName = getAbstractConceptMapping(profile, concept);
		if (metaclassName != null) {
			resultType = (EClass) UMLPackage.eINSTANCE
				.getEClassifier(metaclassName);
		} else {
			Class umlClass = getProfileClass(profile, concept);

			if (umlClass instanceof Stereotype) {
				// create the base element
				Stereotype stereotype = (Stereotype) umlClass;
				metaclassName = getExtendedMetaclass(stereotype).getName();
				resultType = (EClass) UMLPackage.eINSTANCE
					.getEClassifier(metaclassName);
			} else {
				resultType = (EClass) profile.getDefinition(umlClass);
			}
		}
		// find the containment reference
		EReference containment = PackageUtil.findFeature(container.eClass(),
			resultType);

		return containment != null;
	}

	/**
	 * Queries whether a model element has the specified ZDL domain property.
	 * 
	 * @param element
	 *            a model element
	 * @param concept
	 *            the qualified name of the domain concept that defines the
	 *            property
	 * @param property
	 *            the domain property name
	 * 
	 * @return whether the specified property is available on the element
	 */
	public static boolean hasZDLProperty(EObject element, String concept,
			String property) {
		boolean result = false;

		Class conceptClass = getZDLConcept(element, concept);
		if ((conceptClass != null) && isZDLConcept(element, conceptClass)) {
			result = getAttribute(conceptClass, property, null) != null;
		}

		return result;
	}

	/**
	 * Queries whether a model element can be referenced by the specified ZDL
	 * domain property.
	 * 
	 * @param element
	 *            a model element
	 * @param concept
	 *            the qualified name of the domain concept that defines the
	 *            property
	 * @param property
	 *            the domain property name
	 * 
	 * @return whether the element conforms to the specified property's type
	 */
	public static boolean isZDLTypeOf(EObject element, String concept,
			String property) {
		boolean result = false;

		Class conceptClass = getZDLConcept(element, concept);
		if (conceptClass != null) {
			Property reference = getAttribute(conceptClass, property, null);
			if (reference != null) {
				Type type = reference.getType();
				if (type instanceof Class) {
					Class refClass = (Class) type;

					if (refClass.isMetaclass()) {
						// domain concept references a UML metaclass
						result = UMLPackage.eINSTANCE.getEClassifier(
							refClass.getName()).isInstance(element);
					} else {
						// domain concept references another domain concept
						result = isZDLConcept(element, refClass);
					}
				}
			}
		}

		return result;
	}

	/**
	 * Creates a new instance of the specified concept in the specified
	 * <tt>container</tt> element.
	 * 
	 * @param container
	 *            an element in which to create a domain concept instance
	 * @param concept
	 *            the concept to instantiate
	 * 
	 * @return the new instance of the concept
	 */
	public static EObject createZDLConceptIn(EObject container, String concept) {

		Class conceptClass = getZDLConcept(container, concept);

		return createZDLConceptIn(container, conceptClass);
	}
	
	/**
	 * Creates a new instance of the specified concept in the specified
	 * <tt>container</tt> element.
	 * 
	 * @param container
	 *            an element in which to create a domain concept instance
	 * @param concept
	 *            the concept to instantiate
	 * 
	 * @return the new instance of the concept
	 */
	public static EObject createZDLConceptIn(EObject container, Class concept) {
		Profile profile = getZDLProfile(container, concept);

		EObject result;
		Stereotype stereotype = null;

		String metaclassName = getAbstractConceptMapping(profile, concept);
		if (metaclassName != null) {
			result = UMLFactory.eINSTANCE.create((EClass) UMLPackage.eINSTANCE
				.getEClassifier(metaclassName));
		} else {
			Class umlClass = getProfileClass(profile, concept);

			if (umlClass instanceof Stereotype) {
				// create the base element
				stereotype = (Stereotype) umlClass;
				metaclassName = getExtendedMetaclass(stereotype).getName();
				result = UMLFactory.eINSTANCE
					.create((EClass) UMLPackage.eINSTANCE
						.getEClassifier(metaclassName));

				// create and attach the stereotype
				EClass stereotypeEClass = (EClass) profile
					.getDefinition(stereotype);

				// apply the stereotype
				EObject stApp = applyStereotype((Element) result, stereotypeEClass, stereotype);
				container.eResource().getContents().add(stApp);
				
			} else {
				EClass eclass = (EClass) profile.getDefinition(umlClass);
				result = EcoreUtil.create(eclass);
			}
		}

		// ensure that the new object is immediately recognizable as its
		// concept
		ZDLConceptInfo.initialize(result, profile, concept);

		// find the containment reference
		EReference containment = PackageUtil.findFeature(container.eClass(),
			result.eClass());
		if (containment == null) {
			throw new IllegalArgumentException("cannot create " //$NON-NLS-1$
				+ concept.getName() + " in " + container.eClass()); //$NON-NLS-1$
		}

		if (FeatureMapUtil.isMany(container, containment)) {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) container.eGet(containment);
			list.add(result);
		} else {
			container.eSet(containment, result);
		}
		
		if (result instanceof Element) {
			Element resultElement = (Element) result;

			Resource res = container.eResource();
			if (res != null) {
				res.getContents().addAll(
					resultElement.getStereotypeApplications());
			}
		}

		return result;
	}

	/**
	 * Queries whether an element in a Zeligsoft component model is a
	 * realization of the specified ZDL concept (directly or by inheritance).
	 * This isn't, strictly speaking, an instance-of relationship.
	 * 
	 * @param modelElement
	 *            an element in a Zeligsoft component model
	 * @param concept
	 *            a ZDL concept
	 * 
	 * @return whether the element has a stereotype derived from the specified
	 *         ZDL concept
	 */
	public static boolean isZDLConcept(EObject modelElement, Class concept) {
		return getConcreteConcept(modelElement, concept) != null;
	}

	/**
	 * Obtains the concrete concept, conforming to the specified
	 * <tt>concept</tt> that classifies the model element.
	 * 
	 * @param modelElement
	 *            an element in a Zeligsoft component model
	 * @param concept
	 *            a ZDL concept
	 * 
	 * @return the concrete concept (which may just be the same <tt>concept</tt>
	 *         of which the element is an instance
	 */
	private static Class getConcreteConcept(EObject modelElement, Class concept) {
		Class result = null;

		for (Class next : getZDLConcepts(modelElement)) {
			if (next.conformsTo(concept)) {
				result = next;
				break;
			}
		}

		return result;
	}

	/**
	 * Obtains the set of profiles applied in the scope of the specified model
	 * element that are ZDL profiles.
	 * 
	 * @param modelElement
	 *            an element
	 * 
	 * @return the ZDL profiles applied to all of the packages containing the
	 *         element
	 */
	private static Set<Profile> getAppliedZDLProfiles(EObject modelElement) {
		if (!(modelElement instanceof Element)) {
			
			Profile profile = null;

			if (modelElement.eResource() != null) {
				EObject root = modelElement.eResource().getContents().get(0);
				if (root instanceof Model) {
					Set<Profile> profiles = ZDLUtil.getAppliedZDLProfiles(root);
					if (!profiles.isEmpty()) {
						profile = profiles.iterator().next();
					}
				}
			}
			// it's an instance of a profile class. Easy case
			EClass eclass = modelElement.eClass();
			Class profileClass = (Class) getNamedElement(eclass);

			if(profile != null && profileClass == null) {
				profileClass = (Class) getNamedElement(eclass, profile);
			}
			
			if (profileClass == null) {
				// for example, something from the Notation metamodel in the
				// UML model has no correspondence to and ZDL metamodel
				return Collections.emptySet();
			}

			if (profileClass.getNearestPackage() instanceof Profile) {
				return Collections.singleton((Profile) profileClass
						.getNearestPackage());
			} else {
				return Collections.emptySet();
			}
		}

		// we will always want to search this set from nearest profile to most
		// remote (up the content tree)
		Set<Profile> result = new java.util.LinkedHashSet<Profile>();

		Element element = (Element) modelElement;
		Package pkg = element.getNearestPackage();
		while (pkg != null) {
			for (Profile next : pkg.getAppliedProfiles()) {
				// filter for ZDL profiles
				if (getZDLAnnotation(next) != null) {
					result.add(next);
				}
			}

			pkg = (pkg.getOwner() == null)
				? null
				: pkg.getOwner().getNearestPackage();
		}

		return result;
	}

	/**
	 * Queries the profile that is applied in the context of the specified
	 * element, that has some kind of mapping of the given concept.
	 * 
	 * @param modelElement
	 *            a model element
	 * @param concept
	 *            a ZDL concept
	 * @return the profile applied in the element's context that defines the
	 *         concept, or else <code>null</code>
	 */
	public static Profile getZDLProfile(EObject modelElement, Class concept) {
		ZDLConceptInfo info = ZDLConceptInfo.get(modelElement);
		Collection<Profile> profiles = (info != null)
			? info.getProfiles()
			: getAppliedZDLProfiles(modelElement);

		Profile result = null;

		for (Profile profile : profiles) {
			if (getProfileClass(profile, concept) != null) {
				result = profile;
				break;
			}

			String metaclass = getAbstractConceptMapping(profile, concept);
			if (metaclass != null) {
				result = profile;
				break;
			}
		}

		return result;
	}

	/**
	 * Queries the nearest domain profile that is applied in the context of the
	 * specified model element.
	 * 
	 * @param modelElement
	 *            a model element
	 * @return the profile applied in the element's context, or else
	 *         <code>null</code>
	 * 
	 * @deprecated It is common that multiple domains are in effect, so use the
	 *             {@link #getZDLProfiles(Element)} method, instead
	 */
	@Deprecated
	public static Profile getZDLProfile(Element modelElement) {
		Collection<Profile> result = getZDLProfiles(modelElement);

		return result.isEmpty()
			? null
			: result.iterator().next();
	}

	/**
	 * Queries the domain profiles that are applied in the context of the
	 * specified model element.
	 * 
	 * @param modelElement
	 *            a model element
	 * @return an unmodifiable collection of the profiles applied in the
	 *         element's context, which may well be empty
	 */
	public static Collection<Profile> getZDLProfiles(Element modelElement) {
		ZDLConceptInfo info = ZDLConceptInfo.get(modelElement);
		Collection<Profile> result = (info != null)
			? info.getProfiles()
			: null;

		if (result == null) {
			result = getAppliedZDLProfiles(modelElement);
		}

		return Collections.unmodifiableCollection(result);
	}

	/**
	 * Queries whether the given domain profile is applied in the context of the
	 * specified model element.
	 * 
	 * @param modelElement
	 *            a contextual model element
	 * @param profileName
	 *            the simple name of the profile in question
	 * @return whether the named profile is applied to a package in the context
	 *         of the model element
	 */
	public static boolean isZDLProfile(Element modelElement, String profileName) {
		Collection<Profile> profiles = getZDLProfiles(modelElement);
		Iterator<Profile> itor = profiles.iterator();
		while (itor.hasNext()) {
			Profile profile = itor.next();
			if (profile.getName().equals(profileName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Helper class for {@link isZDLDomain}
	 * 
	 * @author ysroh
	 * 
	 */
	private static class ZDLDomainInfo {

		private ZDLDomainInfo() {
			// TODO Auto-generated constructor stub
		}

		// nothing
		public static CacheAdapter ensureCacheAdapter(Class concept) {
			CacheAdapter cache = CacheAdapter.getCacheAdapter(concept);
			if (cache == null) {
				cache = CacheAdapter.getInstance();
				cache.adapt(concept);
			}
			return cache;
		}
	}
	
	/**
	 * Queries whether the given domain is applied in the context of the specified
	 * model element. Unlike querying the profile, which will return true only if the
	 * exact profile is found, this method will return true if the queried domain is
	 * the source domain metamodel of an applied domain profile, or if it is an imported
	 * domain of the source domain metamodel of an applied domain profile.
	 * 
	 * Note that while a domain could make use only of certain domain blocks within 
	 * a domain, this method will return true if any part of that domain is used. For
	 * this reason, it could in some cases return a false positive, and is is best
	 * suited for cases where the caller wants to know if any part of the domain is
	 * applied.
	 * 
	 * @param modelElement
	 * @param domainName
	 * @return
	 */
	public static boolean isZDLDomain(Element modelElement, String domainName) {

		Class concept = getZDLConcept(modelElement);
		if (concept == null) {
			return false;
		}
		CacheAdapter cache = ZDLDomainInfo.ensureCacheAdapter(concept);

		Resource res = concept.eResource();
		@SuppressWarnings("unchecked")
		Map<String, Boolean> result = (Map<String, Boolean>) cache.get(res,
				concept, ZDLDomainInfo.class);

		if (result != null) {
			if (result.containsKey(domainName)) {
				return result.get(domainName);
			}
		} else {
			result = new HashMap<String, Boolean>();
			cache.put(res, concept, ZDLDomainInfo.class, result);
		}

		Collection<Profile> profiles = getZDLProfiles(modelElement);
		String conceptString = getZDLConcept(modelElement).getName().toString();

		for (Profile profile : profiles) {
			for (EObject xref : profile.getEAnnotation(
					"http://www.zeligsoft.com/zdl/2008/ZDL").eCrossReferences()) { //$NON-NLS-1$
				if (ZDLUtil.isZDLConcept(xref, ZDLNames.DOMAIN_SPECIALIZATION)) {
					Class domainSpecialization = (Class) xref;
					Package domainSpecializationPackage = domainSpecialization
							.getPackage();
					// We assume that domain dependencies are not circular.
					boolean ret = isZDLDomainHelper(
							domainSpecializationPackage, domainName,
							conceptString);
					result.put(domainName, ret);
					return ret;
				}
			}
		}
		result.put(domainName, false);
		return false;
	}
	
	private static boolean isZDLDomainHelper(Package pkg, String domainName, String conceptString ) {

		// Attempt to find a class matching the concept string passed. If the class is found, see whether the 
		// containing package has the domainName being searched for. If both these conditions are true, the
		// domain is said to contribute the concept.
		for (TreeIterator<?> iter = EcoreUtil.getAllContents(Collections
				.singleton(pkg)); iter.hasNext();) {
			Object obj = iter.next();
			if( obj instanceof Class ) {
				if( ((Class)obj).getName().matches(conceptString)) {
					if( pkg.getName().equals(domainName)) {
						return true;
					}
				}
			}
		}
		for( PackageImport pi : pkg.getPackageImports()) {
			if( isZDLDomainHelper(pi.getImportedPackage(), domainName, conceptString)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Queries the ZDL domain blocks from which the specified profile was
	 * generated.  This is the transitive closure of the source domain
	 * specialization's domain-block references, and the referenced blocks'
	 * imports and merges.
	 * 
	 * @param profile a {@linkplain #isZDLProfile(Element, String) ZDL profile}
	 * @return the domain-blocks from which the profile was generated
	 * 
	 * @see #isZDLProfile(Element, String)
	 * @see #getZDLProfiles(Element)
	 */
	public static Collection<Package> getSourceDomainBlocks(Profile profile) {
		return ZDLProfileInfo.get(profile).getSourceDomainBlocks();
	}

	/**
	 * Finds the UML class to which the specified ZDL concept maps in the
	 * context of this profile. The resulting class may be a stereotype, a class
	 * owned by the profile, or a UML metaclass.
	 * 
	 * @param profile
	 *            a ZDL-generated profile
	 * @param concept
	 *            a ZDL concept in that is mapped in the context of the profile
	 * 
	 * @return the UML class to which the concept maps
	 */
	public static Class getProfileClass(Profile profile, Class concept) {
		Class result = null;

		for (Type next : profile.getOwnedTypes()) {
			if (tracesToZDL(next, concept)) {
				result = (Class) next;
				break;
			}
		}

		if (result == null) {
			// maybe it's an "abstract concept mapping"
			String metaclassName = getAbstractConceptMapping(profile, concept);
			if (metaclassName != null) {
				result = (Class) profile.getMetamodelReferences().get(0)
					.getImportedPackage().getOwnedType(metaclassName);
			}
		}

		return result;
	}

	/**
	 * Finds the UML metaclass on which the specified ZDL concept is based in
	 * the context of this profile.
	 * 
	 * @param profile
	 *            a ZDL-generated profile
	 * @param concept
	 *            a ZDL concept in that is mapped in the context of the profile
	 * 
	 * @return the UML metaclass on which the concept is based, or
	 *         <code>null</code> if it maps to a class in the profile or it
	 *         maps to a stereotype that has no metaclass extensions
	 */
	public static Class getBaseMetaclass(Profile profile, Class concept) {
		Class result = null;
		Class profileClass = getProfileClass(profile, concept);

		if (profileClass instanceof Stereotype) {
			result = getExtendedMetaclass((Stereotype) profileClass);
		} else if ((profileClass != null) && profileClass.isMetaclass()) {
			result = profileClass;
		}

		return result;
	}
	
	public static Class getBaseMetaclass(Profile profile, String concept) {
		org.eclipse.uml2.uml.Class conceptClass = 
			getZDLConcept(profile, concept);
		return getBaseMetaclass(profile, conceptClass);
	}

	/**
	 * Finds the most specific UML metaclass that the specified stereotype
	 * extends, if any. In practice, in the case of multiple metaclass
	 * extensions, this is the first concrete metaclass that is not a general of
	 * any other extended metaclass, or if there are no concrete metaclasses,
	 * the first abstract metaclass that is not a general of any other extended
	 * metaclass.
	 * 
	 * @param stereotype
	 *            a ZDL-generated stereotype
	 * 
	 * @return the most specific UML metaclass that it extends, or
	 *         <code>null</code> if the stereotype has no metaclass extensions
	 */
	protected static Class getExtendedMetaclass(Stereotype stereotype) {
		Class result = null;

		List<Class> metaclasses = stereotype.getAllExtendedMetaclasses();

		// return the most specific extended metaclass, preferring the frist
		// concrete one, if any
		if (metaclasses.size() == 1) {
			result = metaclasses.get(0);
		} else if (!metaclasses.isEmpty()) {
			metaclasses = new java.util.ArrayList<Class>(metaclasses);
			filterGenerals(metaclasses);
			result = metaclasses.get(0);
			if (result.isAbstract() && (metaclasses.size() > 0)) {
				for (Class next : metaclasses) {
					if (!next.isAbstract()) {
						result = next;
						break;
					}
				}
			}
		}

		return result;
	}

	/**
	 * Filters out of the given classifiers all of those that are generals of
	 * any other classifier in the collection.
	 * 
	 * @param classifiers
	 *            a bunch of classifiers
	 */
	private static void filterGenerals(
			Collection<? extends Classifier> classifiers) {
		boolean loop;
		do {
			loop = false;
			for (Classifier next : classifiers) {
				if (classifiers.removeAll(next.allParents())) {
					// do it again
					loop = true;
					break;
				}
			}
		} while (loop);
	}

	/**
	 * Queries the name of the metaclass to which this concept maps in the
	 * context of this profile, if the concept is mapped in this profile and is
	 * an "abstract" concept.
	 * 
	 * @param profile
	 *            a ZDL profile
	 * @param concept
	 *            a concept that may or may not be mapped in the profile
	 * 
	 * @return the name of the abstract concept's metaclass mapping, or
	 *         <code>null</code> if either this concept is mapped in this
	 *         profile or it is not an "abstract" concept mapping to a UML
	 *         metaclass
	 */
	private static String getAbstractConceptMapping(Profile profile,
			Class concept) {
		EAnnotation annot = getZDLAnnotation(profile);
		return (annot == null)
			? null
			: annot.getDetails().get(concept.getQualifiedName());
	}
	
	static boolean isAbstractConceptMapping(Class concept, EObject context) {
		// ensure that the contextual ZDL model is resolved
		getZDLConcepts(context);
		
		Profile profile = getZDLProfile(context, concept);
		
		if (profile == null) {
			// can't be an instance if the profile isn't in context
			throw new IllegalArgumentException(
				"modelElement is not an abstract mapping: " //$NON-NLS-1$
					+ concept.getName());
		}
		
		String abstractMapping = getAbstractConceptMapping(profile, concept);
		
		return abstractMapping != null;
	}

	/**
	 * Queries whether an element in a Zeligsoft component model is a
	 * realization of the specified ZDL concept (directly or by inheritance).
	 * This isn't, strictly speaking, an instance-of relationship.
	 * 
	 * @param modelElement
	 *            an element in a Zeligsoft component model
	 * @param concept
	 *            the qualified name of a ZDL concept
	 * 
	 * @return whether the element has a stereotype derived from the specified
	 *         ZDL concept
	 */
	public static boolean isZDLConcept(EObject modelElement, String concept) {
		boolean result = false;

		List<Class> actual = getZDLConcepts(modelElement);
		if (!actual.isEmpty()) {
			Class conceptClass = getZDLConcept(modelElement, concept);

			if (conceptClass != null) {
				for (Class next : actual) {
					if (next.conformsTo(conceptClass)) {
						result = true;
						break;
					}
				}
			}
		}

		return result;
	}

	/**
	 * <p>
	 * Gets the value, from a given model element, of a property defined by the
	 * ZDL concept that stereotypes it. This method accounts for the possibility
	 * that, in a particular UML profile manifestation of the concept, the
	 * attribute in question is actually mapped to an existing property in the
	 * UML metamodel.
	 * </p>
	 * <p>
	 * In the case of an association between concepts, the resulting value(s)
	 * is/are UML model elements, not the stereotype applications that are the
	 * true association ends.
	 * </p>
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * @param concept
	 *            the ZDL concept that defines the property to be accessed
	 * @param property
	 *            the name of the property to access
	 * 
	 * @return the property's value, which may be <code>null</code> in normal
	 *         circumstances
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified concept does not define this property by any
	 *             means, or if it is not available on this particular model
	 *             element
	 */
	public static Object getValue(EObject modelElement, Class concept,
			String property) {

		return getPropertyMapping(modelElement, concept, property).getValue(
			modelElement);
	}

	/**
	 * Obtains a mapping of ZDL properties to the corresponding UML properties.
	 * This mapping encapsulates read and write access to the properties,
	 * regardless of whether they are implemented on stereotypes, profile
	 * classes, or UML metaclasses.
	 * 
	 * @param modelElement
	 *            a model element
	 * @param concept
	 *            a ZDL concept of which the element is an "instance"
	 * @param property
	 *            the name of a ZDL property defined by the concept
	 * 
	 * @return the property mapping
	 */
	private static ZDLPropertyMapping getPropertyMapping(EObject modelElement,
			Class concept, String property) {

		// ensure that the contextual ZDL model is resolved
		getZDLConcepts(modelElement);

		Profile profile = getZDLProfile(modelElement, concept);
		if (profile == null) {
			// can't be an instance if the profile isn't in context
			throw new IllegalArgumentException(
				"modelElement is not an instance of domain concept: " //$NON-NLS-1$
					+ concept.getName());
		}

		return getPropertyMapping(modelElement, profile, concept, property);
	}

	/**
	 * Obtains a mapping of ZDL properties to the corresponding UML properties.
	 * This mapping encapsulates read and write access to the properties,
	 * regardless of whether they are implemented on stereotypes, profile
	 * classes, or UML metaclasses.
	 * 
	 * @param modelElement
	 *            an object in a Zeligsoft model
	 * @param profile
	 *            a ZDL profile
	 * @param concept
	 *            a ZDL concept of which the element is an "instance"
	 * @param property
	 *            the name of a ZDL property defined by the concept
	 * 
	 * @return the property mapping
	 */
	private static ZDLPropertyMapping getPropertyMapping(EObject modelElement,
			Profile profile, Class concept, String property) {

		ZDLPropertyMappingAdapter cache = ZDLPropertyMappingAdapter
			.adapt(profile);
		ZDLPropertyMapping result = cache.get(concept, property);

		if (result == null) {
			Class actualConcept = getConcreteConcept(modelElement, concept);

			if (actualConcept == null) {
				// need to handle inverse-reference queries, which access this
				// attribute on an unknown set of concrete concepts. These
				// just won't be able to support redefinition
				actualConcept = concept;
			}

			Class umlClass = (profile == null)
				? null
				: getProfileClass(profile, actualConcept);

			if (umlClass == null) {
				// can't be an instance if the mapping isn't available
				throw new IllegalArgumentException(
					"modelElement is not an instance of domain concept: " //$NON-NLS-1$
						+ concept.getName());
			}

			Property zdlProperty = getAttribute(concept, property,
				actualConcept, null);
			EStructuralFeature feature;

			ZDLPropertyOwnerMapping ownerMapping = ZDLPropertyOwnerMapping.DEFAULT;
			ZDLPropertyValueMapping valueMapping = ZDLPropertyValueMapping.DEFAULT;

			if (umlClass instanceof Stereotype) {
				// the concept is a "firm concept mapping" to a stereotype
				Stereotype stereotype = (Stereotype) umlClass;

				Property umlProperty = getAttribute(stereotype, zdlProperty);
				if (umlProperty != null) {

					// must get the value from the stereotype application
					ownerMapping = new StereotypePropertyOwnerMapping(
						stereotype);

					EClass eclass = (EClass) profile.getDefinition(stereotype);
					feature = eclass.getEStructuralFeature(umlProperty
						.getName());
					if (feature == null) {
						// it may be mangled because of feature duplication
						// (name collisions in multiple inheritance)
						feature = eclass.getEStructuralFeature(eclass.getName()
							+ '_' + umlProperty.getName());
					}

					if (umlProperty.getType() instanceof Stereotype) {

						valueMapping = new StereotypePropertyValueMapping(
							(Stereotype) umlProperty.getType());
					}
				} else {
					// maybe it's mapped to a metaclass property?
					String uml = getUMLMetaattribute(stereotype, zdlProperty
						.getName());

					if (uml == null) {
						// must be an attribute of a general concept that is an
						// abstract mapping. Specializing concepts cannot
						// re-map such attributes without redefining them
						EClass eclass = modelElement.eClass();
						feature = eclass.getEStructuralFeature(zdlProperty
							.getName());
						if(feature == null) {
							throw new IllegalArgumentException(
								"No such domain attribute: " + property); //$NON-NLS-1$
						}
					} else {
						EClass eclass;
						Class metaclass = getExtendedMetaclass(stereotype);

						if (metaclass != null) {
							eclass = (EClass) UMLPackage.eINSTANCE
								.getEClassifier(metaclass.getName());
						} else {
							eclass = modelElement.eClass();
						}

						feature = eclass.getEStructuralFeature(uml);

						if (feature == null) {
							throw new IllegalArgumentException(
								"No such domain attribute: " + property); //$NON-NLS-1$
						}

						if (zdlProperty.getType() instanceof Class) {

							// filter the value for instances of the concept
							Class conceptType = (Class) zdlProperty.getType();

							if (!conceptType.isMetaclass()) {
								valueMapping = new ZDLPropertyValueMapping(
									conceptType);
							}
						}
					}
				}
			} else if (umlClass.isMetaclass()) {
				// the concept is an "abstract concept mapping" to a UML
				// metaclass.
				EClass eclass = (EClass) UMLPackage.eINSTANCE
					.getEClassifier(umlClass.getName());
				String eFeatureName = property;

				if (zdlProperty != null) {
					EAnnotation zdlAnnot = getZDLAnnotation(profile);
					if (zdlAnnot != null) {
						// look for a nested annotation mapping the concept's
						// attrs
						EAnnotation nested = zdlAnnot
							.getEAnnotation(zdlProperty.getClass_()
								.getQualifiedName());

						if (nested != null) {
							String umlName = nested.getDetails().get(property);
							if (!isEmpty(umlName)) {
								eFeatureName = umlName;
							}
						}
					}

					if (zdlProperty.getType() instanceof Class) {
						// filter the value for instances of the concept
						Class conceptType = (Class) zdlProperty.getType();

						if (!conceptType.isMetaclass()) {
							valueMapping = new ZDLPropertyValueMapping(
								conceptType);
						}
					}
				}

				feature = eclass.getEStructuralFeature(eFeatureName);
			} else {
				// the concept is a "firm concept mapping" to a profile class.
				// There are no attribute mappings in these cases
				Property umlProperty = getAttribute(umlClass, property, null);
				EClass eclass = (EClass) profile.getDefinition(umlClass);
				feature = eclass.getEStructuralFeature(property);
				if (feature == null) {
					// it may be mangled because of feature duplication
					// (name collisions in multiple inheritance)
					feature = eclass.getEStructuralFeature(eclass.getName()
						+ '_' + property);
				}

				if ((umlProperty != null)
					&& (umlProperty.getType() instanceof Stereotype)) {

					valueMapping = new StereotypePropertyValueMapping(
						(Stereotype) umlProperty.getType());
				}
			}

			EClassifier eType = feature.getEType();
			if ((eType instanceof EEnum)) {
				EEnum eEnum = (EEnum) eType;
				Enumeration profileEnum = (Enumeration) UMLUtil.getNamedElement(eEnum, profile);
				if (profileEnum != null) {
					Enumeration zdlEnum = (Enumeration) traceToZDL(profileEnum).get(0);
					valueMapping = new EnumerationPropertyValueMapping(eEnum, zdlEnum);
				}
			}
			
			result = new ZDLPropertyMapping(profile, getAttribute(concept,
				property, null), feature, ownerMapping, valueMapping);

			cache.put(umlClass, property, result);
		}

		return result;
	}
	
	/**
	 * Gets the Ecore feature that ultimately implements the specified ZDL
	 * property.
	 * 
	 * @param zdl
	 *            a ZDL property definition
	 * @param context
	 *            some element in the context of a ZDL profile that defines the
	 *            mapping to UML
	 * @return the profile-specific mapping of the ZDL property
	 * 
	 * @since 1.0.100
	 */
	public static EStructuralFeature getPropertyMapping(Property zdl,
			EObject context) {
		EStructuralFeature result = null;

		Class ownerConcept = zdl.getClass_();

		// maybe it's a datatype property
		if (ownerConcept != null) {
			ZDLPropertyMapping mapping = getPropertyMapping(context,
				ownerConcept, zdl.getName());
			
			if (mapping != null) {
				result = mapping.getFeature();
			}
		}

		return result;
	}
	
	/**
	 * Gets the Ecore feature that ultimately implements the specified ZDL
	 * property.
	 * 
	 * @param concept
	 * 			fully qualified name of the ZDL concept that owns the property
	 * @param zdl
	 *            a ZDL property name
	 * @param context
	 *            some element in the context of a ZDL profile that defines the
	 *            mapping to UML
	 * @return the profile-specific mapping of the ZDL property
	 * 
	 * @since 1.0.100
	 */
	public static EStructuralFeature getPropertyMapping(String concept, String zdl, EObject context) {
		EStructuralFeature result = null;

		Class ownerConcept = getZDLConcept(context, concept);

		if(ownerConcept == null) {
			throw new IllegalArgumentException(String.format(
					"Can not find domain concept %s in the provided context", concept)); //$NON-NLS-1$
		}
		
		// maybe it's a datatype property
		if (ownerConcept != null) {
			ZDLPropertyMapping mapping = getPropertyMapping(context,
				ownerConcept, zdl);
			
			if (mapping != null) {
				result = mapping.getFeature();
			}
		}

		return result;
	}
	
	/**
	 * Obtains the properties of the specified domain <tt>concept</tt> that are
	 * source ends of domain references.
	 * 
	 * @param concept
	 *            a domain concept
	 * @return its properties (including inherited) that are domain-reference
	 *         source ends, or an empty list if none
	 * 
	 * @since 1.0.100
	 */
	public static List<Property> getDomainReferenceEnds(Class concept) {
		return new FilteringList<Property>(concept.getAllAttributes(),
			new FilteringList.IFilter<Property>() {

				public boolean accept(Property element) {
					Association assoc = element.getAssociation();

					return (assoc != null)
						&& isZDLConcept(assoc, ZDLNames.DOMAIN_REFERENCE);
				}
			});
	}


	
	/**
	 * Converts a value, which may be a list of stereotype instances or a single
	 * one, to a list of the base elements (or a single one).
	 * 
	 * @param value
	 *            a single or collection of stereotype instances
	 * 
	 * @return a single or collection of UML elements (the base elements of the
	 *         stereotypes)
	 */
	@SuppressWarnings({"unchecked", "serial"})
	private static <T> T asBaseElements(T value, final Stereotype stereotype) {
		T result;

		if (value instanceof Collection<?>) {
			EList<EObject> listValue;
			if (value instanceof EList<?>) {
				listValue = (EList<EObject>) value;
			} else {
				// oAW transformations use ArrayLists instead of ELists
				listValue = new BasicEList<EObject>((Collection<EObject>) value);
			}

			result = (T) new TransformingList<Element, EObject>(listValue) {

				@Override
				protected Element transform(EObject sourceElement) {
					return getBaseElement(sourceElement);
				}

				@Override
				protected EObject inverse(Element targetElement) {
					return getApplication(targetElement, stereotype);
				}
			};
		} else if (value == null) {
			// no base element of a null stereotype application
			result = null;
		} else {
			result = (T) getBaseElement((EObject) value);
		}

		return result;
	}
	
	/**
	 * Obtains the application of the specified stereotype on an element,
	 * accounting for possibility of a sub-stereotype being applied.
	 * 
	 * @param element
	 *            an element in the Zeligsoft model
	 * @param stereotype
	 *            a stereotype that is known to be applied to it
	 * 
	 * @return the stereotype application
	 */
	private static EObject getApplication(Element element, Stereotype stereotype) {
		Stereotype actual = stereotype;

		if (!element.isStereotypeApplied(actual)) {
			// look for sub-stereotype
			List<Stereotype> subs = element.getAppliedSubstereotypes(actual);
			if (!subs.isEmpty()) {
				actual = subs.get(0);
			}
		}

		return element.getStereotypeApplication(actual);
	}

	/**
	 * Gets the value, from a given model element, of a property defined by the
	 * ZDL concept that stereotypes it. This method accounts for the possibility
	 * that, in a particular UML profile manifestation of the concept, the
	 * attribute in question is actually mapped to an existing property in the
	 * UML metamodel.
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * @param concept
	 *            qualified name of the ZDL concept that defines the property to
	 *            be accessed
	 * @param property
	 *            the name of the property to access
	 * 
	 * @return the property's value, which may be <code>null</code> in normal
	 *         circumstances
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified concept does not define this property by any
	 *             means, or if it is not available on this particular model
	 *             element
	 * 
	 * @see #getValue(EObject, Class, String)
	 */
	public static Object getValue(EObject modelElement, String concept,
			String property) {

		Class conceptClass = requireZDLConcept(modelElement, concept);

		return getValue(modelElement, conceptClass, property);
	}
	
	/**
	 * Variant of getValue for cases where we know to expect back an EObject. This is handy when
	 * doing multiple getValue calls and not having to constantly cast a return value from getValue
	 * to an EObject in order to pass it to another call.
	 * 
	 * @param modelElement
	 * @param concept
	 * @param property
	 * @return
	 */
	public static EObject getEValue(EObject modelElement, String concept, String property) {
		Object potentialRetVal = getValue(modelElement, concept, property);
		
		if( potentialRetVal instanceof EObject || potentialRetVal == null) {
			return (EObject)potentialRetVal;
		} 
		
		throw new IllegalArgumentException("ZDLUtil.getEValue expects to return an EObject. Value retrieved instead: " + potentialRetVal);
	}

	/**
	 * Obtains the named concept metaclass, asserting that the specified model
	 * element is an instance of it.
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * @param concept
	 *            the qualified name of a concept that stereotypes it
	 * 
	 * @return the concept class, in the model element's resource-set context
	 * 
	 * @throws IllegalArgumentException
	 *             if the named concept cannot be found or if the model element
	 *             is not stereotyped by it
	 * 
	 * @see #isZDLConcept(Element, String)
	 */
	private static Class requireZDLConcept(EObject modelElement, String concept) {
		List<Class> actual = getZDLConcepts(modelElement);
		if ((actual == null) || actual.isEmpty()) {
			throw new IllegalArgumentException(String.format(
				"modelElement is not an instance of domain concept: %s (%s)", concept, modelElement)); //$NON-NLS-1$
		}

		Class result = getZDLConcept(modelElement, concept);
		if (result == null) {
			throw new IllegalArgumentException("undefined domain concept: " //$NON-NLS-1$
				+ concept);
		}

		for (Class next : actual) {
			if (next.conformsTo(result)) {
				return result;
			}
		}

		throw new IllegalArgumentException(
			"modelElement is not an instance of domain concept: " + concept); //$NON-NLS-1$
	}

	/**
	 * <p>
	 * Sets the value, from a given model element, of a property defined by the
	 * ZDL concept that stereotypes it. This method accounts for the possibility
	 * that, in a particular UML profile manifestation of the concept, the
	 * attribute in question is actually mapped to an existing property in the
	 * UML metamodel.
	 * </p>
	 * <p>
	 * In the case of an association between domain concepts, the value(s) to
	 * set is/are the UML elements from the application model, not the
	 * corresponding stereotype instances.
	 * </p>
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * @param concept
	 *            the ZDL concept that defines the property to be accessed
	 * @param property
	 *            the name of the property to access
	 * @param value
	 *            the new value for the property
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified concept does not define this property by any
	 *             means, or if it is not available on this particular model
	 *             element
	 */
	public static void setValue(EObject modelElement, Class concept,
			String property, Object value) {

		getPropertyMapping(modelElement, concept, property).setValue(
			modelElement, value);
	}

	/**
	 * Converts a value, which may be a list of UML elements or a single one, to
	 * a list of the applied stereotypes (or a single one).
	 * 
	 * @param value
	 *            a single or collection of UML elements
	 * @param stereotype
	 *            the expected stereotype
	 * 
	 * @return a single or collection of stereotype instances
	 */
	@SuppressWarnings({"unchecked", "serial"})
	private static <T> T asStereotypeInstances(T value,
			final Stereotype stereotype) {

		T result;

		if (value instanceof Collection<?>) {
			EList<Element> listValue;
			if (value instanceof EList<?>) {
				listValue = (EList<Element>) value;
			} else {
				// oAW transformations use ArrayLists instead of ELists
				listValue = new BasicEList<Element>((Collection<Element>) value);
			}

			result = (T) new TransformingList<EObject, Element>(listValue) {

				@Override
				protected EObject transform(Element sourceElement) {
					return getApplication(sourceElement, stereotype);
				}

				@Override
				protected Element inverse(EObject targetElement) {
					return getBaseElement(targetElement);
				}
			};
		} else if (value == null) {
			// no stereotype application on a null element
			result = null;
		} else {
			if (value instanceof Element) {
				result = (T) getApplication((Element) value, stereotype);
			} else {
				result = value;
			}
		}

		return result;
	}

	/**
	 * Sets the value, from a given model element, of a property defined by the
	 * ZDL concept that stereotypes it. This method accounts for the possibility
	 * that, in a particular UML profile manifestation of the concept, the
	 * attribute in question is actually mapped to an existing property in the
	 * UML metamodel.
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * @param concept
	 *            qualified name of the ZDL concept that defines the property to
	 *            be accessed
	 * @param property
	 *            the name of the property to access
	 * @param value
	 *            the new value for the property
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified concept does not define this property by any
	 *             means, or if it is not available on this particular model
	 *             element
	 */
	public static void setValue(EObject modelElement, String concept,
			String property, Object value) {

		Class conceptClass = requireZDLConcept(modelElement, concept);

		setValue(modelElement, conceptClass, property, value);
	}

	/**
	 * Obtains the name of the UML meta-attribute to which a stereotype
	 * attribute is mapped by the ZDLGen transformation to the profile
	 * 
	 * @param stereotype
	 *            a stereotype applied to a Zeligsoft model element
	 * @param domainAttribute
	 *            the name of an attribute in the source domain model that is
	 *            mapped to a UML meta-attribute
	 * 
	 * @return the name of the corresponding UML meta-attribute
	 */
	protected static String getUMLMetaattribute(Stereotype stereotype,
			String domainAttribute) {

		String result = getUMLMetaattributeHelper(stereotype, domainAttribute);

		for (Iterator<Classifier> iter = stereotype.allParents().iterator(); iter
			.hasNext()
			&& (result == null);) {

			Classifier next = iter.next();

			if (next instanceof Stereotype) {
				// it really should be, in a valid UML model
				result = getUMLMetaattributeHelper((Stereotype) next,
					domainAttribute);
			}
		}

		return result;
	}

	/**
	 * Helper method for obtaining the UML meta-attribute to which a domain
	 * attribute maps. Used in the scanning of a stereotype's inheritance for
	 * looking up a domain attribute.
	 * 
	 * @param stereotype
	 *            the stereotype
	 * @param domainAttribute
	 *            the domain attribute
	 * 
	 * @return the UML meta-attribute name, or <code>null</code> if this
	 *         stereotype does not have the mapping
	 */
	private static String getUMLMetaattributeHelper(Stereotype stereotype,
			String domainAttribute) {
		String result = null;

		EAnnotation annot = stereotype.getEAnnotation(ZDL_NAMESPACE_URI);
		if (annot != null) {
			result = annot.getDetails().get(domainAttribute);
		}

		return result;
	}

	/**
	 * Obtains the named domain concept from its domain model, in the resource
	 * set of the specified contextual element.
	 * 
	 * @param context
	 *            an element in the contextual resource set
	 * @param qualifiedName
	 *            the qualified name of a concept
	 * 
	 * @return the domain concept, from the contextual resource set, or
	 *         <code>null</code> if it cannot be found
	 */
	public static Class getZDLConcept(EObject context, String qualifiedName) {
		Class result = null;

		ResourceSet rset = getContextResourceSet(context);

		if (rset != null) {
			result = getZDLConcept(rset, qualifiedName);
		}

		return result;
	}

	/**
	 * Obtains the ZDL enumeration literal, in the context of the specified
	 * contextual model element.
	 * 
	 * @param context
	 *            a model element from which to find the ZDL context
	 * @param enumeration
	 *            the name of the ZDL enumeration
	 * @param literal
	 *            the name of the literal
	 * 
	 * @return the ZDL enumeration literal, or <code>null</code> if the ZDL
	 *         context cannot be determined
	 */
	public static EnumerationLiteral getZDLEnumLiteral(EObject context,
			String enumeration, String literal) {
		// force resolution of the ZDL model
		getZDLConcepts(context);

		EnumerationLiteral result = null;
		ResourceSet rset = getContextResourceSet(context);

		if (rset != null) {
			Enumeration zdlEnum = getZDLEnumeration(rset, enumeration);
			if (zdlEnum != null) {
				result = zdlEnum.getOwnedLiteral(literal);
			}
		}

		return result;
	}

	/**
	 * Obtains the resource set most appropriate for working with the specified
	 * object.
	 * 
	 * @param context
	 *            a model element
	 * 
	 * @return its context resource set. This may be <code>null</code>
	 */
	private static ResourceSet getContextResourceSet(EObject context) {
		ResourceSet result = null;

		Resource res = context.eResource();
		if (res != null) {
			result = res.getResourceSet();
		}

		if (result == null) {
			ZDLConceptInfo info = ZDLConceptInfo.getExistingInfo(context);
			if (info != null) {
				List<Profile> profiles = info.getProfiles();
				if (!profiles.isEmpty()) {
					result = getContextResourceSet(profiles.get(0));
				}
			}
		}

		return result;
	}

	/**
	 * Finds the named concept in the specified resource set.
	 * 
	 * @param context
	 *            the resource set in which to find a domain concept
	 * @param qualifiedName
	 *            the qualified name of a domain concept to find
	 * 
	 * @return the domain concept, or <code>null</code> if it cannot be found
	 */
	private static Class getZDLConcept(ResourceSet context, String qualifiedName) {
		Map<String, Class> concepts = qnameToConcept.get(context);
		if (concepts == null) {
			concepts = new java.util.HashMap<String, Class>();
			qnameToConcept.put(context, concepts);
		}

		Class result = concepts.get(qualifiedName);

		if (result == null) {
			result = getZDLClassifier(context, qualifiedName,
				ZDL_CONCEPT_STEREOTYPE);
			concepts.put(qualifiedName, result);
		}

		return result;
	}

	/**
	 * Finds the named enumeration in the specified resource set.
	 * 
	 * @param context
	 *            the resource set in which to find a domain enumeration
	 * @param qualifiedName
	 *            the qualified name of a domain enumeration to find
	 * 
	 * @return the domain enumeration, or <code>null</code> if it cannot be
	 *         found
	 */
	private static Enumeration getZDLEnumeration(ResourceSet context,
			String qualifiedName) {
		Map<String, Enumeration> enums = qnameToEnumeration.get(context);
		if (enums == null) {
			enums = new java.util.HashMap<String, Enumeration>();
			qnameToEnumeration.put(context, enums);
		}

		Enumeration result = enums.get(qualifiedName);

		if (result == null) {
			result = getZDLClassifier(context, qualifiedName,
				ZDL_ENUM_STEREOTYPE);
			enums.put(qualifiedName, result);
		}

		return result;
	}

	/**
	 * Generic helper for looking up ZDL classifiers by qualified name in a
	 * contextual resource set.
	 * 
	 * @param context
	 *            the contextual resource set
	 * @param qualifiedName
	 *            the qualified name of the ZDL classifier to find
	 * @param metaclass
	 *            the expected metaclass of the ZDL classifier
	 * 
	 * @return the matching classifier, or <code>null</code> if not found
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Classifier> T getZDLClassifier(
			ResourceSet context, String qualifiedName, String stereotype) {

		T result = null;
		Collection<NamedElement> elements = findNamedElements(context,
			qualifiedName, false);

		for (NamedElement next : elements) {
			// is it a ZDL classifier?
			Stereotype stereo = next.getAppliedStereotype(stereotype);	
			if (stereo != null) {
				result = (T) next;
				break;
			}
		}

		return result;
	}

	/**
	 * <p>
	 * Gets the objects that reference a given model element in the named
	 * reference property.
	 * </p>
	 * <p>
	 * In the case of an association between concepts, the resulting value(s)
	 * is/are UML model elements, not the stereotype applications that are the
	 * true association ends.
	 * </p>
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * @param concept
	 *            the ZDL concept that defines the property to be inverted
	 * @param property
	 *            the name of the property to invert
	 * 
	 * @return the model elements referencing the specified model element via
	 *         the ZDL reference property. This may be an empty list in normal
	 *         circumstances
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified concept does not define this property by any
	 *             means, or if it is not available on this particular model
	 *             element
	 */
	public static List<EObject> getInverseReferences(EObject modelElement,
			Class concept, String property) {

		Profile profile = getZDLProfile(modelElement, concept);
		if (profile == null) {
			// can't be an instance if the profile isn't in context
			throw new IllegalArgumentException(
				"modelElement is not in the context of the domain of the concept: " //$NON-NLS-1$
					+ concept.getName());
		}

		ZDLPropertyMapping mapping = getPropertyMapping(modelElement, profile,
			concept, property);
		EStructuralFeature feature = mapping.getFeature();

		List<EObject> result;
		CacheAdapter cache = CacheAdapter.getCacheAdapter(modelElement);

		if (cache == null) {
			result = Collections.emptyList();
		} else {
			result = new UniqueEList.FastCompare<EObject>(4);
			for (EStructuralFeature.Setting setting : cache
				.getInverseReferences(mapping.getReferent(modelElement))) {
				if (setting.getEStructuralFeature() == feature) {
					result.add(setting.getEObject());
				}
			}

			// handle conversion of referencing stereotype applications
			result = mapping.transformForInverseReferences(result);
		}

		return result;
	}

	/**
	 * <p>
	 * Gets the objects that reference a given model element in the named
	 * reference property.
	 * </p>
	 * <p>
	 * In the case of an association between concepts, the resulting value(s)
	 * is/are UML model elements, not the stereotype applications that are the
	 * true association ends.
	 * </p>
	 * 
	 * @param modelElement
	 *            an element in the Zeligsoft component model
	 * @param concept
	 *            the ZDL concept that defines the property to be inverted
	 * @param property
	 *            the name of the property to invert
	 * 
	 * @return the model elements referencing the specified model element via
	 *         the ZDL reference property. This may be an empty list in normal
	 *         circumstances
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified concept does not define this property by any
	 *             means, or if it is not available on this particular model
	 *             element
	 */
	public static List<EObject> getInverseReferences(EObject modelElement,
			String concept, String property) {

		// ensure that the concepts in the current profile context are resolved
		getZDLConcepts(modelElement);

		// now, we can find the reference target concept
		Class conceptClass = getZDLConcept(modelElement, concept);

		return getInverseReferences(modelElement, conceptClass, property);
	}

	/**
	 * Finds the domain model element that is the source of the specified
	 * profile element.
	 * 
	 * @param profileElement
	 *            an element in a domain profile
	 * 
	 * @return the ZDL domain model elements from which it was generated, or
	 *         <code>null</code> the element is not from a domain profile
	 */
	private static List<NamedElement> traceToZDL(NamedElement profileElement) {
		List<NamedElement> result;

		EAnnotation annot = getZDLAnnotation(profileElement);
		if (annot == null) {
			result = null;
		} else if (annot.getReferences().isEmpty()) {
			result = Collections.emptyList();
		} else {
			List<EObject> refs = annot.getReferences();
			result = new java.util.ArrayList<NamedElement>(refs.size());

			for (EObject next : refs) {
				if (next instanceof NamedElement) {
					result.add((NamedElement) next);
				}
			}
		}

		return result;
	}

	/**
	 * Queries whether the specified UML element traces to the given ZDL
	 * element.
	 * 
	 * @param uml
	 *            an element in a UML profile
	 * @param zdl
	 *            an element in a ZDL model
	 * 
	 * @return whether the UML element was generated from the ZDL element
	 */
	protected static boolean tracesToZDL(NamedElement uml, NamedElement zdl) {
		List<NamedElement> traces = traceToZDL(uml);

		return (traces != null) && traces.contains(zdl);
	}

	/**
	 * Obtains the ZDL traceability annotation applied to the specified profile
	 * element, if any.
	 * 
	 * @param profileElement
	 *            an element in a UML profile
	 * @return the traceability annotation, or <code>null</code> if none
	 */
	private static EAnnotation getZDLAnnotation(NamedElement profileElement) {
		return profileElement.getEAnnotation(ZDL_NAMESPACE_URI);
	}

	/**
	 * Gets the ZDL concept definition of the specified Ecore definition of a
	 * profile class, if any.
	 * 
	 * @param profileEClass
	 *            a class in an Ecore definition of a profile
	 * @return the corresponding domain concept, or <code>null</code> if the
	 *         profile is not a domain profile or if the Ecore class is not in a
	 *         profile
	 */
	public static Class getZDLDefinition(EClass profileEClass) {
		Class result = null;
		NamedElement def = getNamedElement(profileEClass);

		if (def instanceof Class) {
			List<NamedElement> zdls = traceToZDL(def);

			if (!zdls.isEmpty()) {
				NamedElement zdl = zdls.get(0);

				if (zdl instanceof Class) {
					result = (Class) zdl;
				}
			}
		}

		return result;
	}
	
	/**
	 * Returns the ZDL domain model elements that are the source of the specified
	 * profile element.
	 * 
	 * @param profileElement
	 * @return the ZDL domain model elements from which it was generated, or
	 *         <code>null</code>if the element is not from a domain profile
	 */
	public static List<NamedElement> getZDLDefinition(
			NamedElement profileElement) {

		return traceToZDL(profileElement);

	}

	/**
	 * Gets the ZDL property definition of the specified Ecore definition of a
	 * profile feature, if any.
	 * 
	 * @param profileFeature
	 *            a feature in an Ecore definition of a profile
	 * @return the corresponding domain property, or <code>null</code> if the
	 *         profile is not a domain profile or if the Ecore feature is not in
	 *         a profile
	 */
	public static Property getZDLDefinition(EStructuralFeature profileFeature) {
		Property result = null;
		NamedElement def = getNamedElement(profileFeature);

		if (def instanceof Property) {
			List<NamedElement> zdls = traceToZDL(def);

			if (!zdls.isEmpty()) {
				NamedElement zdl = zdls.get(0);

				if (zdl instanceof Property) {
					result = (Property) zdl;
				}
			}
		}

		return result;
	}

	/**
	 * Obtains the named attribute (possibly inherited) of the specified
	 * classifier.
	 * 
	 * @param classifier
	 *            a classifier
	 * @param name
	 *            an attribute name
	 * 
	 * @param type
	 *            an optional attribute type to require (in case of
	 *            redefinition), or <code>null</code> if not interesting
	 * @return the attribute, or <code>null</code> if not found
	 */
	protected static Property getAttribute(Classifier classifier, String name,
			Type type) {
		return getAttribute(classifier, name, null, type);
	}

	/**
	 * Obtains the named attribute (possibly inherited) of the specified
	 * classifier, accounting for possible redefinition in the given
	 * redefinition context.
	 * 
	 * @param classifier
	 *            a classifier
	 * @param name
	 *            an attribute name
	 * @param redefContext
	 *            an optional redefinition context in which to search for
	 *            redefinitions of the property. Pass <code>null</code> to
	 *            ignore redefinition
	 * 
	 * @param type
	 *            an optional attribute type to require (in case of
	 *            redefinition), or <code>null</code> if not interesting
	 * @return the attribute, or <code>null</code> if not found
	 */
	protected static Property getAttribute(Classifier classifier, String name,
			Classifier redefContext, Type type) {

		Property result = null;

		for (Property next : classifier.getAllAttributes()) {
			if (name.equals(next.getName())) {
				if ((redefContext != null)
					&& (redefContext != next.getClass_())
					&& hasRedefinitions(classifier, next, redefContext)) {
					result = getRedefinition(next, redefContext, type);
					break;
				} else if ((type == null) || type.equals(next.getType())) {
					result = next;
					break;
				}
			}
		}

		return result;
	}

	/**
	 * Finds the attribute in a given domain-profile classifier that is
	 * generated from the specified ZDL attribute definition.
	 * 
	 * @param classifier
	 *            a classifier in a domain profile (stereotype, metaclass, or
	 *            class)
	 * @param zdlDefinition
	 *            the definition of a property in the ZDL model
	 * 
	 * @return the coresponding domain-profile definition
	 */
	protected static Property getAttribute(Classifier classifier,
			Property zdlDefinition) {

		Property result = null;

		for (Property next : classifier.getAllAttributes()) {
			if (tracesToZDL(next, zdlDefinition)) {
				result = next;
				break;
			}
		}

		return result;
	}

	/**
	 * Queries whether the specified property has been redefined in any
	 * specializing classifier context(s).
	 * 
	 * @param property
	 *            a property
	 * 
	 * @return whether it is redefined by any other properties
	 */
	protected static boolean hasRedefinitions(Property property) {
		CacheAdapter cache = CacheAdapter.getCacheAdapter(property);
		boolean result = false;

		if (cache != null) {
			Collection<EStructuralFeature.Setting> settings = cache
				.getNonNavigableInverseReferences(property);

			for (EStructuralFeature.Setting next : settings) {
				if (next.getEStructuralFeature() == UMLPackage.Literals.PROPERTY__REDEFINED_PROPERTY) {
					result = true;
					break;
				}
			}
		}

		return result;
	}
	
	protected static boolean hasRedefinitions(Classifier classifier, Property property, Classifier context) {
		boolean result = false;
		
		for(Property next : context.getAllAttributes()){
			if(redefines(next, property)) {
				result = true;
				break;
			}
		}
		
		return result;
	}

	/**
	 * Obtains the definition of the specified property that is the effective
	 * (re)definition of the specified property in the given redefinition
	 * context.
	 * 
	 * @param property
	 *            a property that may have redefinitions
	 * @param redefContext
	 *            a classifier in which context we want to find the effective
	 *            definition of the property
	 * @param type
	 *            an optional filter to find the most specific definition of the
	 *            property that has a type conforming to this <tt>type</tt>.
	 *            May be <code>null</code> to get simply the most specific
	 *            redefinition
	 * 
	 * @return the effective definition of the property in this context
	 */
	protected static Property getRedefinition(Property property,
			Classifier redefContext, Type type) {

		Property result = null;

		// breadth-first search: we want the *most specific* definition in the
		// tree
		Queue<Classifier> queue = new java.util.LinkedList<Classifier>();
		queue.offer(redefContext);
		loop : for (Classifier next = queue.poll(); next != null; next = queue
			.poll()) {

			for (Property attr : next.getAttributes()) {
				if (redefines(attr, property)
					&& ((type == null) || type.equals(attr.getType()))) {

					result = attr;
					break loop;
				}
			}

			queue.addAll(next.getGenerals());
		}

		return result;
	}

	/**
	 * Queries whether one property redefines another.
	 * 
	 * @param property
	 *            a property
	 * @param definition
	 *            another property
	 * 
	 * @return whether the <tt>property</tt> redefines the <tt>definition</tt>
	 */
	protected static boolean redefines(Property property, Property definition) {
		boolean result = false;

		if (!property.getRedefinedProperties().isEmpty()) {
			for (Property next : property.getRedefinedProperties()) {
				if ((next == definition) || redefines(next, definition)) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	/**
	 * Obtains the URL of the ZDL icon for the specified model element, if any
	 * is defined for any of its concepts.
	 * 
	 * @param modelElement
	 *            an instance of a ZDL concept
	 * @return the icon URL of the first concept that is found to have an icon
	 *         (priority given to firm concept mappings), or <code>null</code>
	 *         if it has no icon
	 */
	public static URL getZDLIcon(EObject modelElement) {
		URL result = null;

		for (Class next : getZDLConcepts(modelElement)) {
			result = getIcon(next);

			if (result != null) {
				break;
			}
		}

		return result;
	}

	/**
	 * Obtains the URL of the icon for the specified domain <tt>concept</tt>,
	 * if any.
	 * 
	 * @param concept
	 *            the ZDL concept
	 * @return the concept's icon URL, or <code>null</code> if it has no icon
	 */
	public static URL getIcon(Class concept) {
		URL result = null;
		Class iconProvider = concept;

		String icon = null;
		
		try {
			icon = (String) getValue(iconProvider, ZDLNames.DOMAIN_CONCEPT,
				ZDLNames.DOMAIN_CONCEPT__ICON_URI);
			
			
	
			if (icon == null) {
				// breadth-first search up the inheritance hierarchy
				Queue<Class> queue = new java.util.LinkedList<Class>(iconProvider
					.getSuperClasses());
				for (iconProvider = queue.poll(); iconProvider != null; iconProvider = queue
					.poll()) {
	
					icon = (String) getValue(iconProvider, ZDLNames.DOMAIN_CONCEPT,
						ZDLNames.DOMAIN_CONCEPT__ICON_URI);
					if (!UML2Util.isEmpty(icon)) {
						break;
					}
	
					queue.addAll(iconProvider.getSuperClasses());
				}
			}
		}
		catch (IllegalArgumentException iae) {
			Activator.getDefault().warning(
					NLS.bind(Messages.ZDLUtil_conceptIcon, concept.getName()),
					iae);
		}

		if (!UML2Util.isEmpty(icon)) {
			URI uri = URI.createURI(icon, true);

			if (uri.isHierarchical() && uri.isRelative()) {
				uri = uri.resolve(iconProvider.eResource().getURI());
			}

			uri = iconProvider.eResource().getResourceSet().getURIConverter()
				.normalize(uri);

			try {
				result = new URL(uri.toString());
			} catch (MalformedURLException e) {
				Activator.getDefault().warning(
					NLS.bind(Messages.ZDLUtil_conceptIcon, concept.getName()),
					e);
			}
		}

		return result;
	}

	/**
	 * Obtains the URL of the icon for the specified domain <tt>reference</tt>,
	 * if any.
	 * 
	 * @param reference
	 *            the source end of a ZDL domain reference association
	 * @return the reference's icon URL, or <code>null</code> if it has no
	 *         icon
	 */
	public static URL getIcon(Property reference) {
		URL result = null;

		Association assoc = reference.getAssociation();
		if ((assoc != null) && isZDLConcept(assoc, ZDLNames.DOMAIN_REFERENCE)) {
			String icon = (String) getValue(assoc, ZDLNames.DOMAIN_REFERENCE,
				ZDLNames.DOMAIN_REFERENCE__ICON_URI);

			if (icon != null) {
				URI uri = URI.createURI(icon, true);

				if (uri.isHierarchical() && uri.isRelative()) {
					uri = uri.resolve(assoc.eResource().getURI());
				}

				uri = assoc.eResource().getResourceSet().getURIConverter()
					.normalize(uri);

				try {
					result = new URL(uri.toString());
				} catch (MalformedURLException e) {
					Activator.getDefault().warning(
						NLS.bind(Messages.ZDLUtil_referenceIcon, reference
							.getClass_().getName(), reference.getName()), e);
				}
			}
		}

		return result;
	}

	/**
	 * Filters the specified collection for those elements that are instances of
	 * the specified ZDL concept.
	 * 
	 * @param <T>
	 *            the expected type of the matching objects
	 * 
	 * @param objects
	 *            the objects to filter
	 * @param concept
	 *            the ZDL concept to match
	 * 
	 * @return the instances of the ZDL concept
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> Collection<T> getObjectsByConcept(
			Collection<? extends EObject> objects, String concept) {
		Collection<T> result = new java.util.ArrayList<T>();

		for (EObject next : objects) {
			if (isZDLConcept(next, concept)) {
				result.add((T) next);
			}
		}

		return result;
	}

	/**
	 * Filters the specified collection for those elements that are instances of
	 * the specified ZDL concept.
	 * 
	 * @param <T>
	 *            the expected type of the matching objects
	 * 
	 * @param objects
	 *            the objects to filter
	 * @param concept
	 *            the ZDL concept to match
	 * 
	 * @return the instances of the ZDL concept
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> Collection<T> getObjectsByConcept(
			Collection<? extends EObject> objects, Class concept) {
		Collection<T> result = new java.util.ArrayList<T>();

		for (EObject next : objects) {
			if (isZDLConcept(next, concept)) {
				result.add((T) next);
			}
		}

		return result;
	}
	
	/**
	 * Returns the list of all UML Elements in a package (directly or indirectly) that
	 * are instances of the given ZDL concept.
	 * 
	 * @param umlNamespace  - A UML {@link Namespace} such as a {@link Package} or {@link Classifier}
	 * @param concept     - A {@link String}; the name of a ZDL concept 
	 * @return A {@link List} of UML {@link Element}s.
	 */
	public static List<Element> getAllElementsByConcept(Namespace umlNamespace, String concept) {
		Collection<Element> list = getObjectsByConcept(umlNamespace.allOwnedElements(), concept);
		return (List<Element>) list;
	}

	/**
	 * Returns the list of all UML Elements in a package (directly or indirectly) that
	 * are instances of the given ZDL concept.
	 * 
	 * @param umlNamespace  - A UML {@link Namespace} such as a {@link Package} or {@link Classifier}
	 * @param concept     - A {@link Class}; the name of a ZDL concept 
	 * @return A {@link List} of UML {@link Element}s.
	 */
	public static List<Element> getAllElementsByConcept(Namespace umlNamespace, Class concept) {
		Collection<Element> list = getObjectsByConcept(umlNamespace.allOwnedElements(), concept);
		return (List<Element>) list;
	}

	/**
	 * Searches the specified collection for an element that is an instance of
	 * the specified ZDL concept.
	 * 
	 * @param <T>
	 *            the expected type of the matching object
	 * 
	 * @param objects
	 *            the objects to filter
	 * @param concept
	 *            the ZDL concept to match
	 * 
	 * @return an instance of the ZDL concept, or <code>null</code> if none is
	 *         found
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getObjectByConcept(
			Collection<? extends EObject> objects, String concept) {
		T result = null;

		for (EObject next : objects) {
			if (isZDLConcept(next, concept)) {
				result = (T) next;
				break;
			}
		}

		return result;
	}

	/**
	 * Searches the specified collection for an element that is an instance of
	 * the specified ZDL concept.
	 * 
	 * @param <T>
	 *            the expected type of the matching object
	 * 
	 * @param objects
	 *            the objects to filter
	 * @param concept
	 *            the ZDL concept to match
	 * 
	 * @return an instance of the ZDL concept, or <code>null</code> if none is
	 *         found
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getObjectByConcept(
			Collection<? extends EObject> objects, Class concept) {
		T result = null;

		for (EObject next : objects) {
			if (isZDLConcept(next, concept)) {
				result = (T) next;
				break;
			}
		}

		return result;
	}
	
	/**
	 * Override the UMLUtil behavior for applyStereotype so that we do not use
	 * the RSA version of the StereotypeApplicationHelper which requires that
	 * the element already be in an element contained in a package. (It makes
	 * a call to getNearestPackage and then expects a non null result.
	 * 
	 * @param element
	 *            The element to which to apply the stereotype.
	 * @param stereotype
	 *            The stereotype to apply.
	 * @return The stereotype application.
	 */
	protected static EObject applyStereotype(Element element, EClass definition, Stereotype stereotype) {
		return STEREOTYPE_APPLICATION_HELPER.applyStereotype(element, definition, stereotype);
	}

	//
	// Nested classes
	//

	/**
	 * <p>
	 * A cache of information about the concepts of which an element is an
	 * instance. This cache is maintained by the UML2 {@link CacheAdapter} at
	 * the resource scope, to ensure that the cache is purged when the model
	 * changes in any of the following ways:
	 * </p>
	 * <ul>
	 * <li>apply or unapply a stereotype</li>
	 * <li>unapply a profile (UML2 unapplies all stereotypes)</li>
	 * <li>detach/attach an element</li>
	 * </ul>
	 * <p>
	 * The resource scope is appropriate because the system mandates that
	 * stereotype applications always be persisted in the same resource as their
	 * base elements.
	 * </p>
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static final class ZDLConceptInfo {

		private List<Class> concepts;
		
		private Set<Class> inheritedConcepts;

		private List<Profile> profiles;

		private ZDLConceptInfo(List<Class> concepts, Set<Class> inheritedConcepts) {
			this.concepts = concepts;
			this.inheritedConcepts = inheritedConcepts;
		}

		/**
		 * Ensures that the specified element is adapted and returns its
		 * lazily-created concept-info.
		 * 
		 * @param element
		 *            a model element
		 * @return its concept-info (never <code>null</code>)
		 */
		static ZDLConceptInfo get(EObject element) {
			CacheAdapter cache = ensureCacheAdapter(element);

			Resource res = element.eResource();
			ZDLConceptInfo result = (ZDLConceptInfo) cache.get(res, element,
				ZDLConceptInfo.class);

			if (result == null) {
				List<Class> concepts = ZDLUtil.computeZDLConcepts(element);		
				Set<Class> inheritedConcepts = addInheritedConcepts(concepts);

				result = new ZDLConceptInfo(concepts, inheritedConcepts);
				result.profiles = new java.util.ArrayList<Profile>(
					getAppliedZDLProfiles(element));

				cache.put(res, element, ZDLConceptInfo.class, result);
			}

			return result;
		}

		private static CacheAdapter ensureCacheAdapter(EObject element) {
			CacheAdapter result = CacheAdapter.getCacheAdapter(element);
			if (result == null) {
				result = CacheAdapter.getInstance();
				result.adapt(element);
			}
			return result;
		}

		/**
		 * Initializes an element's concept-info to a known concept, such as
		 * when creating a new unattached concept instance.
		 * 
		 * @param element
		 *            a concept instance
		 * @param profile
		 *            the contextual profile for the domain mapping
		 * @param concept
		 *            the concept that types the element
		 * @return the concept-adapter
		 * 
		 * @see ZDLUtil#createZDLConcept(EObject, Class)
		 */
		static ZDLConceptInfo initialize(EObject element, Profile profile,
				Class concept) {

			CacheAdapter cache = ensureCacheAdapter(element);

			List<Class> concepts = new java.util.ArrayList<Class>(4);
			concepts.add(concept);

			if (element instanceof Element) {
				// add abstract concepts
				concepts.addAll(getAbstractConcepts(profile, element.eClass()));
			}

			Set<Class> inheritedConcepts = addInheritedConcepts(concepts);
			
			ZDLConceptInfo result = new ZDLConceptInfo(concepts, inheritedConcepts);
			result.profiles = Collections.singletonList(profile);

			cache.put(element.eResource(), element, ZDLConceptInfo.class,
				result);

			return result;
		}
		
		private static Set<Class> addInheritedConcepts(List<Class> concepts) {
			Set<Class> inheritedConcepts = new HashSet<Class>();
			
			for( Class c : concepts) {
				inheritedConcepts.add(c);
				for( Classifier classifier : c.allParents() ) {
					inheritedConcepts.add((Class)classifier);
				}
			}
			
			return inheritedConcepts;
		}

		static ZDLConceptInfo getExistingInfo(EObject element) {
			return (ZDLConceptInfo) ensureCacheAdapter(element).get(
				element.eResource(), element, ZDLConceptInfo.class);
		}

		/**
		 * Obtains the contextual ZDL profiles that I cache.
		 * 
		 * @return the ZDL profiles
		 */
		List<Profile> getProfiles() {
			return profiles;
		}

		/**
		 * Obtains the concepts that I cache for my target.
		 * 
		 * @return the concepts
		 */
		List<Class> getConcepts() {
			return concepts;
		}
		
		/**
		 * Obtains the set of inherited concepts that I cache for my target.
		 * 
		 * @return
		 */
		Set<Class> getAllConcepts() {
			return inheritedConcepts;
		}
	}

	/**
	 * A cache of information about a profile (ZDL-generated or otherwise).
	 * This cache is maintained as a simple adapter, because the relationship
	 * of a profile to its ZDL source is absolutely static.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static final class ZDLProfileInfo
			extends AdapterImpl {

		private Set<Package> domainBlocks;

		private ZDLProfileInfo(Set<Package> domainBlocks) {
			this.domainBlocks = Collections.unmodifiableSet(domainBlocks);
		}

		/**
		 * Ensures that the specified profile is adapted and returns its
		 * lazily-created profile-info.
		 * 
		 * @param profile
		 *            a UML profile
		 * @return its profile-info (never <code>null</code>)
		 */
		static ZDLProfileInfo get(Profile profile) {
			ZDLProfileInfo result = (ZDLProfileInfo) EcoreUtil
				.getExistingAdapter(profile, ZDLProfileInfo.class);

			if (result == null) {
				Set<Package> domainBlocks = domainBlockClosure(profile);

				result = new ZDLProfileInfo(domainBlocks);

				profile.eAdapters().add(result);
			}

			return result;
		}

		/**
		 * Obtains the source domain-blocks that I cache.
		 * 
		 * @return the domain blocks
		 */
		Set<Package> getSourceDomainBlocks() {
			return domainBlocks;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == ZDLProfileInfo.class;
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			super.unsetTarget(oldTarget);

			domainBlocks = null;
		}

		/**
		 * Computes the transitive closure of domain-blocks imported or merged
		 * by the blocks referenced by the specified profile's source domain
		 * specialization.
		 * 
		 * @param profile
		 *            a ZDL profile (or not)
		 * @return the closure of the domain blocks that contribute to the
		 *         profile. This will be empty in the case that the profile is
		 *         not a ZDL-generated domain profile
		 */
		private static Set<Package> domainBlockClosure(Profile profile) {
			Set<Package> result = new java.util.HashSet<Package>();

			Class domainSpecialization = (Class) ZDLUtil.getObjectByConcept(
				traceToZDL(profile), ZDLNames.DOMAIN_SPECIALIZATION);

			if (domainSpecialization != null) {
				Collection<Dependency> refs = ZDLUtil.getObjectsByConcept(
					domainSpecialization.getClientDependencies(),
					ZDLNames.DOMAIN_BLOCK_REFERENCE);
				
				for (Dependency ref : refs) {
					Collection<Package> blocks = ZDLUtil.getObjectsByConcept(
						ref.getSuppliers(), ZDLNames.DOMAIN_BLOCK);
					result.addAll(blocks);

					for (Package block : blocks) {
						domainBlockClosure(block, result);
					}
				}
			}

			return result;
		}

		/**
		 * Computes the transitive closure of domain-blocks imported and merged
		 * by the sperified <tt>block</tt>.
		 * 
		 * @param block
		 *            a domain block
		 * @param closure
		 *            the closure set computed thus far, which is appended by
		 *            the imports and merges of this block
		 */
		private static void domainBlockClosure(Package block,
				Set<Package> closure) {
			
			Collection<Dependency> rels = ZDLUtil.getObjectsByConcept(block
				.getClientDependencies(), ZDLNames.DOMAIN_BLOCK_RELATION);

			for (Dependency rel : rels) {
				Collection<Package> others = ZDLUtil.getObjectsByConcept(rel
					.getSuppliers(), ZDLNames.DOMAIN_BLOCK);

				for (Package other : others) {
					if (closure.add(other)) {
						domainBlockClosure(other, closure);
					}
				}
			}
		}
	}

	/**
	 * An adapter that caches a the mappings of ZDL properties on a profile. It
	 * does not extend <tt>AdapterImpl</tt> in order to be as slim as possible
	 * (the <tt>notifier</tt> field is not required).
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class ZDLPropertyMappingAdapter
			implements Adapter.Internal {

		private Map<Class, Map<String, ZDLPropertyMapping>> cache = new java.util.HashMap<Class, Map<String, ZDLPropertyMapping>>();

		private ZDLPropertyMappingAdapter() {
			super();
		}

		/**
		 * Ensures that the specified profile is adapted and returns its
		 * lazily-created adapter.
		 * 
		 * @param profile
		 *            a model ZDL profile
		 * @return its adapter (never <code>null</code>)
		 */
		static ZDLPropertyMappingAdapter adapt(Profile profile) {
			ZDLPropertyMappingAdapter result = (ZDLPropertyMappingAdapter) EcoreUtil
				.getExistingAdapter(profile, ZDLPropertyMappingAdapter.class);

			if (result == null) {
				result = new ZDLPropertyMappingAdapter();
				profile.eAdapters().add(result);
			}

			return result;
		}

		/**
		 * Obtains the cached mapping for the specified concept property.
		 * 
		 * @param concept
		 *            a ZDL concept
		 * @param property
		 *            name of a property defined by the concept
		 * @return the mapping for the specified property, or <code>null</code>
		 *         if it is not (yet) cached
		 */
		ZDLPropertyMapping get(Class concept, String property) {
			Map<String, ZDLPropertyMapping> map = cache.get(concept);

			return (map == null)
				? null
				: map.get(property);
		}

		/**
		 * Caches a mapping for the specified concept property.
		 * 
		 * @param concept
		 *            a ZDL concept
		 * @param property
		 *            name of a property defined by the concept
		 * @param mapping
		 *            the mapping for the specified property
		 */
		void put(Class concept, String property, ZDLPropertyMapping mapping) {
			Map<String, ZDLPropertyMapping> map = cache.get(concept);

			if (map == null) {
				map = new java.util.HashMap<String, ZDLPropertyMapping>();
				cache.put(concept, map);
			}

			map.put(property, mapping);
		}

		public Notifier getTarget() {
			return null;
		}

		public boolean isAdapterForType(Object type) {
			// this is safe because the class is final
			return type == ZDLPropertyMappingAdapter.class;
		}

		public void notifyChanged(Notification notification) {
			// nothing to do
		}

		public void setTarget(Notifier newTarget) {
			// nothing to do
		}

		public void unsetTarget(Notifier oldTarget) {
			// forget my cache
			cache = null;
		}
	}

	/**
	 * An encapsulation of the logic for accessing the features of a ZDL concept
	 * on a UML model element or profile class instance. This class is a
	 * realization of the <em>Strategy</em> pattern.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class ZDLPropertyMapping {

		private Profile profile;

		private EStructuralFeature feature;

		private boolean isZDLMany;

		private ZDLPropertyOwnerMapping ownerMapping;

		private ZDLPropertyValueMapping valueMapping;

		/**
		 * Initializes me with the contextual ZDL profile for which I map a ZDL
		 * property, the Ecore implementation of that ZDL property, and the
		 * mappings for access to the feature owner and the feature values.
		 * 
		 * @param profile
		 *            the contextual ZDL profile
		 * @param zdl
		 *            the ZDL propery definition
		 * @param uml
		 *            the implementation of the ZDL property
		 * @param ownerMapping
		 *            the feature owner mapping
		 * @param valueMapping
		 *            the feature value mapping
		 */
		ZDLPropertyMapping(Profile profile, Property zdl,
				EStructuralFeature uml, ZDLPropertyOwnerMapping ownerMapping,
				ZDLPropertyValueMapping valueMapping) {

			this.profile = profile;
			this.feature = uml;
			this.isZDLMany = zdl.isMultivalued();
			this.ownerMapping = ownerMapping;
			this.valueMapping = valueMapping;
		}

		/**
		 * Obtains my contextual ZDL profile.
		 * 
		 * @return the ZDL profile
		 */
		final Profile getProfile() {
			return profile;
		}

		/**
		 * Obtains the Ecore implementation of the ZDL property that I map.
		 * 
		 * @return my ZDL profile
		 */
		final EStructuralFeature getFeature() {
			return feature;
		}

		/**
		 * Queries whether my ZDL property is implemented by a multiplicity-many
		 * Ecore feature for the specified model element.
		 * 
		 * @param owner
		 *            an element that owns values of my property
		 * @return whether for this owner element the multiplicity is many
		 */
		boolean isMany(EObject owner) {
			return FeatureMapUtil.isMany(ownerMapping.getFeatureOwner(owner),
				feature);
		}

		/**
		 * Obtains the value of my ZDL property for the specified model element.
		 * 
		 * @param modelElement
		 *            the model element
		 * @return its value for my property
		 */
		Object getValue(EObject modelElement) {
			Object result = basicGetValue(ownerMapping
				.getFeatureOwner(modelElement));

			// convert the UML multiplicity to the ZDL multiplicity expected
			// by the client
			result = coerce(isZDLMany, result);

			return result;
		}
		
		/**
		 * Obtains the value of my ZDL property for the specified model element.
		 * 
		 * @param modelElement
		 *            the model element
		 * @return its value for my property
		 */
		Object getRawValue(EObject modelElement) {
			Object result = basicGetRawValue(ownerMapping
				.getFeatureOwner(modelElement));

			// convert the UML multiplicity to the ZDL multiplicity expected
			// by the client
			result = coerce(isZDLMany, result);

			return result;
		}
		
		/**
		 * It is possible that the values are proxy element.
		 * @param owner
		 * @return
		 */
		private Object basicGetRawValue(EObject owner) {
			// get the value from the UML storage
			Object result = owner.eGet(feature);

			ZDLPropertyValueMapping actualValueMapping = valueMapping;

			// convert it from stereotype applications or whatever, if needed
			if(valueMapping instanceof StereotypePropertyValueMapping) {
				actualValueMapping = new StereotypePropertyRawValueMapping((StereotypePropertyValueMapping)valueMapping);
			}
			
			// convert it from stereotype applications or whatever, if needed
			result = actualValueMapping.transformForGet(result);
			
			return result;
		}

		@SuppressWarnings("unchecked")
		private Object basicGetValue(EObject owner) {
			// get the value from the UML storage
			Object result = owner.eGet(feature);

			// convert it from stereotype applications or whatever, if needed
			result = valueMapping.transformForGet(result);

			// filter the value (if a list) for only instances of the
			// appropriate ZDL concept
			if (valueMapping.isConceptType()) {
				if (result instanceof EList) {
					result = new FilteringList<EObject>((EList<EObject>) result,
						new ConceptFilter(valueMapping.getConcept()));
				} else if ((result instanceof EObject)
					&& !isZDLConcept((EObject) result, valueMapping
						.getConcept())) {

					result = null;
				}
			}

			return result;
		}

		/**
		 * Coerces a value to the required multiplicity (as simply many or not)
		 * if necessary.
		 * 
		 * @param isMany
		 *            whether a collection value is required
		 * @param value
		 *            the input value
		 * @return the <tt>value</tt> as a collection or not, as required
		 */
		private Object coerce(boolean isMany, Object value) {
			Object result = value;

			if (isMany != (result instanceof Collection)) {
				if (isMany) {
					// coerce to collection
					if (value == null) {
						result = ECollections.EMPTY_ELIST;
					} else {
						EList<Object> list = new BasicEList<Object>(1);
						list.add(result);
						result = list;
					}
				} else {
					// coerce to scalar
					if (result instanceof List) {
						List<?> list = (List<?>) result;
						result = list.isEmpty()
							? null
							: list.get(0);
					} else {
						Collection<?> coll = (Collection<?>) result;
						result = coll.isEmpty()
							? null
							: coll.iterator().next();
					}
				}
			}

			return result;
		}

		/**
		 * Sets the value of my ZDL property for the specified model element.
		 * 
		 * @param modelElement
		 *            the model element
		 * @param value
		 *            its value for my property
		 */
		void setValue(EObject modelElement, Object value) {
			EObject owner = ownerMapping.getFeatureOwner(modelElement);

			// convert the client's value from the ZDL multiplicity to the UML
			// multiplicity before transforming it
			value = coerce(FeatureMapUtil.isMany(owner, feature), value);

			if (value instanceof Collection) {
				// a concept-filtered list may be involved. In that case, we
				// cannot simply eSet the feature, because that will remove all
				// values that are not of the declared concept
				@SuppressWarnings("unchecked")
				Collection<Object> valueList = (Collection<Object>) value;
				@SuppressWarnings("unchecked")
				Collection<Object> storage = (Collection<Object>) basicGetValue(owner);

				// the list that we get does its own transformations
				storage.clear();
				storage.addAll(valueList);
			} else {
				try {
					ICommand command = valueMapping.getSetCommand(ownerMapping, modelElement, feature, value);
					if (command != null && command.canExecute()) {
						TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(owner);
						Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
						domain.getCommandStack().execute(emfCommand);
					}
				} catch (IllegalArgumentException e) {
					// ToDo: ZDL mapping to be fixed when DDK is updated
					Activator.getDefault()
							.warning("The feature '" + feature.getName() + "' is not a valid changeable feature");
				}
			}
		}

		/**
		 * For reference inversion, obtains the actual object that would be
		 * referenced by the storage of my property, which may sometimes be
		 * different from the object that is conceptually referenced. The
		 * default implementation simply returns the model element
		 * 
		 * @param modelElement
		 *            a model element that is conceptually referenced
		 * @return the object that would actually be referenced in my property's
		 *         storage
		 */
		protected EObject getReferent(EObject modelElement) {
			return valueMapping.getReferent(modelElement);
		}

		/**
		 * For reference inversion, obtains the conceptual objects that
		 * reference the client's specified target element, which may sometimes
		 * be different from the objects that actually store the references. The
		 * default implementation simply returns the actual referencing objects.
		 * 
		 * @param value
		 *            the actual referencing objects
		 * @return the conceptual referencing objects, to return to the client
		 */
		protected <T> T transformForInverseReferences(T value) {
			return ownerMapping.transformForInverseReferences(value);
		}
	}

	/**
	 * An encapsulation of the logic for accessing the owners of the values of
	 * features of a ZDL concept on a UML model element or profile class
	 * instance. This class is a realization of the <em>Strategy</em> pattern.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class ZDLPropertyOwnerMapping {

		static ZDLPropertyOwnerMapping DEFAULT = new ZDLPropertyOwnerMapping();

		/**
		 * Initializes me.
		 */
		ZDLPropertyOwnerMapping() {
			super();
		}

		/**
		 * Obtains the element that actually owns the property values that are
		 * conceptually owned by the specified model element. For some mappings,
		 * this may be a different object than the model element. The default
		 * implementation simply returns the model element.
		 * 
		 * @param modelElement
		 *            a model element
		 * @return the element that actually owns the values of my property
		 */
		protected EObject getFeatureOwner(EObject modelElement) {
			return modelElement;
		}

		/**
		 * For reference inversion, obtains the conceptual objects that
		 * reference the client's specified target element, which may sometimes
		 * be different from the objects that actually store the references. The
		 * default implementation simply returns the actual referencing objects.
		 * 
		 * @param value
		 *            the actual referencing objects
		 * @return the conceptual referencing objects, to return to the client
		 */
		protected <T> T transformForInverseReferences(T value) {
			return value;
		}
	}

	/**
	 * An encapsulation of the logic for accessing the values of features of a
	 * ZDL concept on a UML model element or profile class instance. This class
	 * is a realization of the <em>Strategy</em> pattern.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class ZDLPropertyValueMapping {

		static ZDLPropertyValueMapping DEFAULT = new ZDLPropertyValueMapping(
			null);

		private Class concept;

		/**
		 * Initializes me.
		 * 
		 * @param concept
		 *            my concept type
		 */
		ZDLPropertyValueMapping(Class concept) {
			this.concept = concept;
		}

		/**
		 * Transforms the specified value of my property for read access. For
		 * some mappings, this computes different objects than are actually
		 * stored in the owner of the property. The default implementation
		 * simply returns the value <em>comme ça</em> unless my property is of
		 * an enumeration type, in which case I convert to the ZDL enumeration
		 * literals.
		 * 
		 * @param value
		 *            a value retrieved from my property's owner
		 * @return the appropriate representation to return to the client
		 */
		protected <T> T transformForGet(T value) {
			return value;
		}

		/**
		 * Transforms the specified value of my property for write access. For
		 * some mappings, this computes different objects to actually store in
		 * the owner of the property than are provided by the client. The
		 * default implementation simply returns the value <em>comme ça</em>
		 * unless my property is of an enumeration type, in which case I convert
		 * from the ZDL enumeration literals.
		 * 
		 * @param value
		 *            a value supplied by the client
		 * @return the appropriate representation to store in my property's
		 *         owner
		 */
		protected <T> T transformForSet(T value) {
			return value;
		}

		/**
		 * For reference inversion, obtains the actual object that would be
		 * referenced by the storage of my property, which may sometimes be
		 * different from the object that is conceptually referenced. The
		 * default implementation simply returns the model element
		 * 
		 * @param modelElement
		 *            a model element that is conceptually referenced
		 * @return the object that would actually be referenced in my property's
		 *         storage
		 */
		protected EObject getReferent(EObject modelElement) {
			return modelElement;
		}

		/**
		 * Queries the concept, if any, that is my type.
		 * 
		 * @return my concept type, or <code>null</code> if my type is not a
		 *         domain concept
		 */
		public final Class getConcept() {
			return concept;
		}

		/**
		 * Queries whether I am a property of concept type.
		 * 
		 * @return whether my type is a domain concept
		 */
		public final boolean isConceptType() {
			return concept != null;
		}
		
		/**
		 * Return set value command  
		 * 
		 * @param owner
		 * @return
		 */
		protected ICommand getSetCommand(ZDLPropertyOwnerMapping ownerMapping, EObject modelElement,
				EStructuralFeature feature, Object value) {
			EObject owner = ownerMapping.getFeatureOwner(modelElement);
			if(owner != null) {
				// transform the value to stereotype applications or whatever
				value = transformForSet(value);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(owner);
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(owner);
				if (provider != null) {
					CompositeCommand cc = new CompositeCommand("Edit value"); //$NON-NLS-1$
					
					IEditCommandRequest createSetRequest = new SetRequest(domain, owner, feature, value);
	
					if (createSetRequest != null) {
						cc.add(provider.getEditCommand(createSetRequest));
					}
					return cc;
				}
			}else {
				Activator.getDefault().warning("The owner mapping is null");
			}
			return null;
		}
	}

	/**
	 * Mapping for properties owned by stereotypes. This handles the case where
	 * property access is delegated from a model element to its applied
	 * stereotype.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class StereotypePropertyOwnerMapping
			extends ZDLPropertyOwnerMapping {

		private Stereotype stereotype;

		Stereotype getStereotype() {
			return stereotype;
		}
		
		StereotypePropertyOwnerMapping(Stereotype stereotype) {
			this.stereotype = stereotype;
		}

		@Override
		protected EObject getFeatureOwner(EObject modelElement) {
			return asStereotypeInstances(modelElement, stereotype);
		}

		@Override
		protected <T> T transformForInverseReferences(T value) {
			return asBaseElements(value, stereotype);
		}
	}

	/**
	 * Mapping for properties typed by stereotypes. This handles the conversion
	 * of UML elements for client consumption to/from stereotype applications.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class StereotypePropertyValueMapping
			extends ZDLPropertyValueMapping {

		private Stereotype stereotype;

		StereotypePropertyValueMapping(Stereotype stereotype) {
			super(null); // no filtering; the EReference is homogeneous
			this.stereotype = stereotype;
		}

		@Override
		protected <T> T transformForGet(T value) {
			return asBaseElements(value, stereotype);
		}

		@Override
		protected <T> T transformForSet(T value) {
			return asStereotypeInstances(value, stereotype);
		}

		@Override
		protected EObject getReferent(EObject modelElement) {
			return asStereotypeInstances(modelElement, stereotype);
		}
		
		@Override
		protected ICommand getSetCommand(ZDLPropertyOwnerMapping ownerMapping, EObject modelElement,
				EStructuralFeature feature, Object value) {
			// transform the value to sterotype applications or whatever
			value = transformForSet(value);
			EObject owner = ownerMapping.getFeatureOwner(modelElement);
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(owner);
			CompositeCommand cc = new CompositeCommand("Edit value"); //$NON-NLS-1$
			if (ownerMapping instanceof StereotypePropertyOwnerMapping) {
				Element baseELement = getBaseElement(owner);
				Stereotype st = ((StereotypePropertyOwnerMapping) ownerMapping).getStereotype();
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(baseELement);
				if (provider != null) {

					IEditCommandRequest createSetRequest = new SetStereotypeValueRequest(domain, st, baseELement,
							feature.getName(), transformForSet(value));

					if (createSetRequest != null) {
						cc.add(provider.getEditCommand(createSetRequest));
					}
				}
			} else {
				IEditCommandRequest createSetRequest = new SetRequest(domain, owner, feature, value);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(owner);

				if (createSetRequest != null) {
					cc.add(provider.getEditCommand(createSetRequest));
				}
			}
			return cc.isEmpty()?null:cc;
		}
	}

	/**
	 * An encapsulation of the logic for accessing the values of features of a
	 * ZDL concept on a UML model element or profile class instance. This class
	 * is a realization of the <em>Strategy</em> pattern.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class EnumerationPropertyValueMapping
			extends ZDLPropertyValueMapping {

		private EEnum eEnum;

		private Enumeration zdlEnum;

		/**
		 * Initializes me with the Ecore implementation of a ZDL enumeration and
		 * the corresponding ZDL enumeration.
		 * 
		 * @param eEnum
		 *            the Ecore enumeration
		 * @param zdlEnum
		 *            the ZDL enumeration
		 */
		EnumerationPropertyValueMapping(EEnum eEnum, Enumeration zdlEnum) {
			super(null); // no need to filter; the EAtribute is homogeneous

			this.eEnum = eEnum;
			this.zdlEnum = zdlEnum;
		}

		@Override
		@SuppressWarnings({"unchecked", "serial"})
		protected <T> T transformForGet(T value) {
			T result;

			if (value instanceof EList<?>) {
				result = (T) new TransformingList<EnumerationLiteral, Enumerator>(
					(EList<Enumerator>) value) {

					@Override
					protected EnumerationLiteral transform(
							Enumerator sourceElement) {
						return zdlEnum.getOwnedLiteral(sourceElement.getName());
					}

					@Override
					protected Enumerator inverse(
							EnumerationLiteral targetElement) {
						return eEnum.getEEnumLiteral(targetElement.getName())
							.getInstance();
					}
				};
			} else {
				result = (T) zdlEnum.getOwnedLiteral(((Enumerator) value)
					.getName());
			}

			return result;
		}

		@Override
		@SuppressWarnings({"unchecked", "serial"})
		protected <T> T transformForSet(T value) {
			T result = value;

			if (value instanceof EList<?>) {
				result = (T) new TransformingList<Enumerator, EnumerationLiteral>(
					(EList<EnumerationLiteral>) value) {

					@Override
					protected Enumerator transform(
							EnumerationLiteral sourceElement) {
						return eEnum.getEEnumLiteral(sourceElement.getName())
							.getInstance();
					}

					@Override
					protected EnumerationLiteral inverse(
							Enumerator targetElement) {
						return zdlEnum.getOwnedLiteral(targetElement.getName());
					}
				};
			} else {
				result = (T) eEnum.getEEnumLiteral(
					((EnumerationLiteral) value).getName()).getInstance();
			}

			return result;
		}
	}

	/**
	 * An EObject-list filter that accepts elements matching a specified
	 * concept.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class ConceptFilter
			implements FilteringList.IFilter<EObject> {

		private Class concept;

		ConceptFilter(Class concept) {
			this.concept = concept;
		}

		public boolean accept(EObject sourceElement) {
			return isZDLConcept(sourceElement, concept);
		}
	}
	
	/**
	 * Queries the base element of stereotype application
	 * 
	 * @param stereotypeApplication
	 * @return
	 */
	public static Element getBaseElement(EObject stereotypeApplication) {
		EClass definition = stereotypeApplication.eClass();
		for (EStructuralFeature eStructuralFeature : definition
			.getEAllStructuralFeatures()) {

			if (eStructuralFeature.getName().startsWith(
				Extension.METACLASS_ROLE_PREFIX)) {

				Object value = stereotypeApplication.eGet(eStructuralFeature);

				if (value instanceof Element) {
					return (Element) value;
				}
			}
		}

		return null;
	}
	
	/**
	 * Internal use only.
	 * This should only be used for display purpose.
	 * The value may contain proxy element(s)
	 */
	public static Object getRawValue(EObject modelElement, Class concept,
			String property) {

		return getPropertyMapping(modelElement, concept, property).getRawValue(
			modelElement);
	}
	
	@SuppressWarnings({"unchecked", "serial"})
	private static <T> T asRawBaseElements(T value, final Stereotype stereotype) {
		T result;

		if (value instanceof Collection<?>) {
			EList<EObject> listValue;
			if (value instanceof EList<?>) {
				listValue = (EList<EObject>) value;
			} else {
				// oAW transformations use ArrayLists instead of ELists
				listValue = new BasicEList<EObject>((Collection<EObject>) value);
			}

			result = (T) new TransformingList<EObject, EObject>(listValue) {

				@Override
				protected EObject transform(EObject sourceElement) {
					if(sourceElement.eIsProxy()) {
						return sourceElement;
					}
					return getBaseElement(sourceElement);
				}

				@Override
				protected EObject inverse(EObject targetElement) {
					if(targetElement.eIsProxy()) {
						return targetElement;
					}
					return getApplication((Element)targetElement, stereotype);
				}
			};
		} else if (value == null) {
			// no base element of a null stereotype application
			result = null;
		} else {
			result = (T) getBaseElement((EObject) value);
		}

		return result;
	}
	
	private static class StereotypePropertyRawValueMapping extends ZDLPropertyValueMapping {

		private StereotypePropertyValueMapping valueMapping;

		StereotypePropertyRawValueMapping(StereotypePropertyValueMapping valueMapping) {
			super(null); // no filtering; the EReference is homogeneous
			this.valueMapping = valueMapping;
		}

		@Override
		protected <T> T transformForGet(T value) {
			return asRawBaseElements(value, valueMapping.stereotype);
		}

		@Override
		protected <T> T transformForSet(T value) {
			return valueMapping.transformForSet(value);
		}

		@Override
		protected EObject getReferent(EObject modelElement) {
			return valueMapping.getReferent(modelElement);
		}
	}
}
