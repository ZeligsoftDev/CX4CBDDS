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
package com.zeligsoft.base.zdl.oaw;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.Callable;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Type;

import com.zeligsoft.base.Activator;
import com.zeligsoft.base.zdl.l10n.Messages;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * <p>
 * The implementation of an oAW expression-language metamodel for ZDL. Every ZDL
 * model (i.e., domain metamodel) has an unique instance of this class in any
 * given oAW {@link TypeSystem}.
 * </p>
 * <p>
 * The {@linkplain #getNamespaces() namespaces} published by a ZDL metamodel are
 * the <em>Domain Blocks</em> defined by it, as these are the packages that
 * contain <em>Domain Classifiers</em>. Additionally, a single ZDL metamodel
 * publishes the namespaces that it imports from other metamodels, usually at
 * least including the <em>ZML</em>, and the UML 2.x metamodel as implemented
 * by oAW.
 * </p>
 * <p>
 * <b>Note</b> that oAW workflows that use this metamodel need not, and should
 * not, use the UML2 metamodel provided by oAW. The ZDL metamodel is based on
 * UML2 and, therefore, delegates to it internally, as required. Explicitly
 * adding the UML2 metamodel to your workflow has te potential to confuse ZDL.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLMetamodel
		implements MetaModel {

	private static final String SEPARATOR = NamedElement.SEPARATOR;

	private static final int SEPARATOR_LEN = SEPARATOR.length();
	
	/** The stereotype of a ZDL DomainModel. */
	static final String DOMAIN_MODEL = "ZDL::DomainModel"; //$NON-NLS-1$
	
	/** The stereotype of a ZDL DomainPackage. */
	static final String DOMAIN_PACKAGE = "ZDL::DomainPackage"; //$NON-NLS-1$
	
	/** The stereotype of a ZDL DomainBlock. */
	static final String DOMAIN_BLOCK = "ZDL::DomainBlock"; //$NON-NLS-1$
	
	/** The stereotype of a ZDL DomainBlockReference. */
	static final String DOMAIN_BLOCK_REFERENCE = "ZDL::DomainBlockReference"; //$NON-NLS-1$
	
	/** The stereotype of a ZDL DomainConcept. */
	static final String DOMAIN_CONCEPT = "ZDL::DomainConcept"; //$NON-NLS-1$
	
	/** The stereotype of a ZDL DomainEnum. */
	static final String DOMAIN_ENUM = "ZDL::DomainEnum"; //$NON-NLS-1$
	
	/** The stereotype of a ZDL DomainAttribute. */
	static final String DOMAIN_ATTRIBUTE = "ZDL::DomainAttribute"; //$NON-NLS-1$
	
	/** The stereotype of a ZDL DomainReference. */
	static final String DOMAIN_REFERENCE = "ZDL::DomainReference"; //$NON-NLS-1$

	private TypeSystem typeSystem;

	private UMLMetamodel uml;

	private Model zdl;

	private ZDLObjectType zdlObject;

	private Map<String, Map<String, Type>> namespaceMap;

	private Map<Classifier, Type> typeMap;

	private Set<Type> allTypes;
	
	private Resource targetResource;

	// for the purpose of instantiating ZDL concepts, we require a workflow to
	// specify the domain profile
	private Profile contextProfile;

	private Operation applyDomainProfileOperation;

	/**
	 * Initializes me without a ZDL model. This constructor is only for use in
	 * oAW workflow scripts, which create the metamodel first and then assign it
	 * the ZDL model later.
	 */
	public ZDLMetamodel() {
		this(null);
	}

	/**
	 * Initializes me with my ZDL metamodel.
	 * 
	 * @param zdl
	 *            my ZDL metamodel
	 */
	public ZDLMetamodel(Model zdl) {
		this.zdl = zdl;
		uml = new UMLMetamodel(this);
	}
	
	public ZDLMetamodel(String zdl, Profile contextProfile) {
		setZdl(zdl);
		uml = new UMLMetamodel(this);
		this.contextProfile = contextProfile;
	}

	public TypeSystem getTypeSystem() {
		return typeSystem;
	}

	public void setTypeSystem(TypeSystem typeSystem) {
		this.typeSystem = typeSystem;
		uml.setTypeSystem(typeSystem);
	}

	private Profile findContextProfile(Package pkg, String profileURI) {
		Profile result = null;

		if (pkg != null) {
			URIConverter conv = new ExtensibleURIConverterImpl();
			URI normalized = conv.normalize(URI.createURI(profileURI));

			for (Profile next : pkg.getAllAppliedProfiles()) {
				URI uri = EcoreUtil.getURI(next);
				if ((uri != null)
					&& normalized.equals(conv.normalize(uri.trimFragment()))) {

					result = next;
					break;
				}
			}
		}

		return result;
	}

	public Set<? extends Type> getKnownTypes() {
		if (allTypes == null) {
			allTypes = new java.util.HashSet<Type>();

			for (Map<String, Type> next : getNamespaceMap().values()) {
				allTypes.addAll(next.values());
			}
		}

		return allTypes;
	}

	/**
	 * Obtains a mapping of domain classifiers to oAW types from the namespaces
	 * that I publish.
	 * 
	 * @return my domain-type map
	 */
	protected Map<Classifier, Type> getTypeMap() {
		if (typeMap == null) {
			// create and populate the map
			getNamespaceMap();
		}

		return typeMap;
	}

	public Set<String> getNamespaces() {
		return getNamespaceMap().keySet();
	}

	/**
	 * Obtains a mapping of namespaces that I publish to the named oAW types
	 * within them, as mapping of
	 * {@literal qualified namespace name &Rarr; simple type name &Rarr; oAW type}.
	 * 
	 * @return my namespace-to-type map
	 */
	protected Map<String, Map<String, Type>> getNamespaceMap() {
		if (namespaceMap == null) {
			namespaceMap = new java.util.HashMap<String, Map<String, Type>>();
			typeMap = new java.util.HashMap<Classifier, Type>();

			crawl(zdl, new java.util.HashSet<Model>());
			
			// populate the UML namespace
			Map<String, Type> umlMap = new java.util.HashMap<String, Type>();
			namespaceMap.put("uml", umlMap); //$NON-NLS-1$
			for (EClassifier next : UMLPackage.eINSTANCE.getEClassifiers()) {
				if (next instanceof EClass) {
					umlMap.put(next.getName(), uml.getTypeForEClassifier(next));
				}
			}
		}

		return namespaceMap;
	}

	/**
	 * Walks the contents of my ZDL model, extracting the namespaces and types
	 * that it defines. Imported namespaces' containing models are crawled
	 * recursively.
	 * 
	 * @param zdlModel
	 *            a ZDL model
	 * @param visited
	 *            the set of models visited thus far (to prevent repeated
	 *            recursion)
	 */
	private void crawl(Model zdlModel, Set<Model> visited) {
 		if (!visited.add(zdlModel)) {
			return;
		}
		
		// find all domain blocks; these are the namespaces for domain
		// concepts
		for (TreeIterator<EObject> iter = zdlModel.eAllContents(); iter
			.hasNext();) {

			EObject next = iter.next();

			if (isStereotypedAs(next, DOMAIN_BLOCK)) {
				Package domainBlock = (Package) next;

				String qname = domainBlock.getQualifiedName();
				Map<String, Type> map = new java.util.HashMap<String, Type>();
				namespaceMap.put(qname, map);

				List<org.eclipse.uml2.uml.Type> domainClassifiers = domainBlock
					.getOwnedTypes();
				for (org.eclipse.uml2.uml.Type dc : domainClassifiers) {
					if (isStereotypedAs(dc, DOMAIN_CONCEPT)) {
						ZDLConceptType zdlType = new ZDLConceptType(this,
							(Class) dc);
						
						if(getUMLContextProfile() != null) {
							org.eclipse.uml2.uml.Class metaclass =
								ZDLUtil.getBaseMetaclass(getUMLContextProfile(), ((Class) dc).getQualifiedName());
							
							if(metaclass != null) {
								zdlType.setMetaclass(metaclass.getQualifiedName());
							}
						}

						map.put(dc.getName(), zdlType);
						typeMap.put((Class) dc, zdlType);
					} else if (isStereotypedAs(dc, DOMAIN_ENUM)) {
						ZDLEnumType zdlType = new ZDLEnumType(this,
							(Enumeration) dc);
						map.put(dc.getName(), zdlType);
						typeMap.put((Enumeration) dc, zdlType);
					}
				}

				// discover imported ZDL models (recursively)
				List<Package> imports = domainBlock.getImportedPackages();
				for (Package imported : imports) {
					Model otherZDL = imported.getModel();

					if ((otherZDL != null)
						&& isStereotypedAs(otherZDL, DOMAIN_MODEL)) {

						crawl(otherZDL, visited);
					}
				}

				// domain-blocks don't nest
				iter.prune();
			} else if (isStereotypedAs(next, DOMAIN_PACKAGE)) {
				// recurse into this package to find nested domain-blocks
			} else if (isStereotypedAs(next, DOMAIN_BLOCK_REFERENCE)) {
				// discover imported ZDL models (recursively). Covers the case
				// where other domain models' blocks are referenced by the
				// DomainSpecialization but are not not otherwise explicitly
				// imported or merged
				Dependency dep = (Dependency) next;
				Package referencedPackage = (Package) EcoreUtil
					.getObjectByType(dep.getSuppliers(),
						UMLPackage.Literals.PACKAGE);
				if (referencedPackage != null) {
					Model otherZDL = referencedPackage.getModel();

					if ((otherZDL != null)
						&& isStereotypedAs(otherZDL, DOMAIN_MODEL)) {

						crawl(otherZDL, visited);
					}
				}
			} else if (next instanceof PackageImport) {
				// discover imported ZDL models (recursively). Covers the case
				// where other domain models are not otherwise imported/merged
				// or referenced by the DomainSpecialization
				Package imported = ((PackageImport) next).getImportedPackage();
				if (imported != null) {
					Model otherZDL = imported.getModel();

					if ((otherZDL != null)
						&& isStereotypedAs(otherZDL, DOMAIN_MODEL)) {

						crawl(otherZDL, visited);
					}
				}
			} else {
				// domain-blocks can only be nested in domain-packages
				iter.prune();
			}
		}
	}

	public Type getType(Object obj) {
		Type result = null;
		
		if (obj instanceof UMLBubble) {
			// get the bubble-type
			result =  ((UMLBubble) obj).getType();
		} else if (obj instanceof ZDLEnumType.Instance) {
			// get the bubble-type
			result = ((ZDLEnumType.Instance) obj).getType();
		} else if (obj instanceof EObject) {
			EObject eobject = (EObject) obj;

			if (eobject instanceof EnumerationLiteral) {
				result = getTypeForName(((EnumerationLiteral) eobject)
					.getEnumeration().getQualifiedName());
			} else {
				Class concept = ZDLUtil.getZDLConcept(eobject);
	
				if (concept != null) {
					result = getTypeForName(concept.getQualifiedName());
				} else {
					// maybe our private UML2 metamodel has the answer for a UML type
					result = uml.getType(obj);
				}
			}
		} else {

			// maybe our private UML2 metamodel has the answer for a UML type
			result = uml.getType(obj);
		}
		return result;
	}

	public Type getTypeForName(String typeName) {
		Type result = null;
		int index = typeName.lastIndexOf(SEPARATOR);

		if (index > 0) {
			String ns = typeName.substring(0, index);
			Map<String, Type> namespace = getNamespaceMap().get(ns);

			if (namespace != null) {
				result = namespace.get(typeName
					.substring(index + SEPARATOR_LEN));
			}
		}

		if ((result == null) && typeName.equals(getZDLObjectType().getName())) {
			return getZDLObjectType();
		}

		if (result == null) {
			// maybe our private UML2 metamodel has the answer for a UML type
			result = uml.getTypeForName(typeName);
		}

		return result;
	}

	/**
	 * Creates an instance of the specified ZDL concept in the current domain
	 * profile context.
	 * 
	 * @param zdlConcept
	 *            qualified name of the concept to instantiate
	 * 
	 * @return the new concept instance
	 * 
	 * @throws IllegalStateException
	 *             if the context of the particlar domain profile is not
	 *             available for instantiation of the concept.
	 */
	EObject create(String zdlConcept) {
		if (contextProfile == null) {
			throw new IllegalStateException(
				"No context available in which to instantiate the concept"); //$NON-NLS-1$
		}
		EObject stereotypeApplication = ZDLUtil.createZDLConcept(contextProfile, zdlConcept);
		Element baseElement = ZDLUtil.getBaseElement(stereotypeApplication);
		
		// save stereotype application to the target resource 
		// otherwise stereotypes are not found on the base element
		if (baseElement != null && stereotypeApplication.eResource() == null) {
			targetResource.getContents().add(stereotypeApplication);
		}

		return baseElement != null ? baseElement : stereotypeApplication;
	}

	Type getBasicEObjectType() {
		return uml.getEobjectType();
	}
	
	Type getEObjectType() {
		return uml.getUMLEObjectType();
	}
	
	/**
	 * Obtains the root type for instances of ZDL concepts, which provides
	 * certain common services such as conversion to UML types with protective
	 * bubbles of UML-ness.
	 * 
	 * @return the {@link ZDLObjectType ZDLObject} type
	 */
	Type getZDLObjectType() {
		if (zdlObject == null) {
			zdlObject = new ZDLObjectType(this);

			// also initialize some special UML additions
			initializeApplyDomainProfileOperation();
		}

		return zdlObject;
	}

	/**
	 * Creates, on the <tt>uml::Package</tt> type, an operation that applies a
	 * domain profile identified by URI and stores it for our concept
	 * instantiation context.
	 */
	@SuppressWarnings("unchecked")
	private void initializeApplyDomainProfileOperation() {
		if (applyDomainProfileOperation == null) {
			Type umlPackage = uml.getTypeForName("uml::Package"); //$NON-NLS-1$

			applyDomainProfileOperation = new OperationImpl(
				umlPackage,
				"zdlApplyDomainProfile", typeSystem.getVoidType(), typeSystem.getStringType()) { //$NON-NLS-1$

				@Override
				protected Object evaluateInternal(Object target, Object[] params) {
					Package pkg = (Package) target;
					targetResource = pkg.eResource();
					String profileURI = (String) params[0];
					Profile profile = findContextProfile(pkg, profileURI);

					if (profile == null) {
						ResourceSet rset = null;
						Resource res = pkg.eResource();
						if (res != null) {
							rset = res.getResourceSet();
						}

						if (rset == null) {
							rset = new ResourceSetImpl();
						}

						res = rset.getResource(URI.createURI(profileURI), true);

						profile = (Profile) EcoreUtil.getObjectByType(res
							.getContents(), UMLPackage.Literals.PROFILE);

						if (!profile.getAllAppliedProfiles().contains(profile)) {
							pkg.applyProfile(profile);
						}

						// resolve all so that we can later find concept classes
						// with only the profile as context
						EcoreUtil.resolveAll(rset);
					}

					contextProfile = profile;

					return null;
				}

			};

			// add this to all of the package metaclasses
			Collection<Callable> mutableFeatures = (Collection<Callable>) umlPackage
				.getAllFeatures();
			mutableFeatures.add(applyDomainProfileOperation);

			mutableFeatures = (Collection<Callable>) uml.getTypeForName(
				"uml::Model").getAllFeatures(); //$NON-NLS-1$
			if (!mutableFeatures.contains(applyDomainProfileOperation)) {
				mutableFeatures.add(applyDomainProfileOperation);
			}

			mutableFeatures = (Collection<Callable>) uml.getTypeForName(
				"uml::Profile").getAllFeatures(); //$NON-NLS-1$
			if (!mutableFeatures.contains(applyDomainProfileOperation)) {
				mutableFeatures.add(applyDomainProfileOperation);
			}
		}
	}

	/**
	 * Sets my ZDL model by URI. Should only be used by the oAW workflow
	 * initialization of a ZDL metamodel.
	 * 
	 * @param zdlURI
	 *            the string value of my ZDL model's URI
	 */
	public void setZdl(String zdlURI) {
		URI uri = URI.createURI(zdlURI, true);

		zdl = ZDLMetamodelCache.INSTANCE.getZDLModel(uri);
		
		if (zdl == null) {
			throw new ConfigurationException("No such ZDL model: " + zdlURI); //$NON-NLS-1$
		}
	}
	
	public Profile getContextProfile() {
		return contextProfile;
	}

	@Override
	public String toString() {
		return "ZDLMetamodel[" + zdl.getName() + "]"; //$NON-NLS-1$//$NON-NLS-2$
	}
	
	static boolean isStereotypedAs(Element element, String stereotype) {
		return element.getAppliedStereotype(stereotype) != null;
	}
	
	static boolean isStereotypedAs(EObject object, String stereotype) {
		return (object instanceof Element)
			&& isStereotypedAs((Element) object, stereotype);
	}
	
	/**
	 * ADDED TO SUPPORT BETTER HANDLING OF UML
	 */
	private String contextProfileURI;
	private Profile umlContextProfile;
	
	public void setContextProfileURI(String profileURI) {
		this.contextProfileURI = profileURI;
	}
	
	public boolean hasContextProfile() {
		return !UML2Util.isEmpty(contextProfileURI);
	}
	
	@SuppressWarnings("static-access")
	public Profile getUMLContextProfile() {
		if(!UML2Util.isEmpty(this.contextProfileURI) 
				&& umlContextProfile == null) {
			ResourceSet rset = this.zdl.eResource().getResourceSet();
 		
	 		try {
	 			Resource contextProfileRes = rset.getResource(URI.createURI(contextProfileURI), true);
	 			if(contextProfileRes != null) {
	 				Object rawProfile = 
	 					EcoreUtil.getObjectByType(contextProfileRes.getContents(), 
	 							UMLPackage.eINSTANCE.getProfile());
	 				if(rawProfile != null) {
	 					umlContextProfile = (Profile) rawProfile;
	 				}
	 			}
	 			EcoreUtil.resolveAll(rset);
	 		} catch(Exception ex) {
	 			Activator.error(Activator.getDefault(), 
	 					Messages.ZDLMetamodel_ERROR_RESOLVING_CONTEXT_PROFILE, ex);
	 			return null;
	 		}
		}
		
		return umlContextProfile;
	}
}
