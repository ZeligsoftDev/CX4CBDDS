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
package com.zeligsoft.base.validation.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.CategoryManager;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.ConstraintExistsException;
import org.eclipse.emf.validation.service.ConstraintRegistry;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.validation.Activator;
import com.zeligsoft.base.validation.l10n.Messages;
import com.zeligsoft.base.validation.util.InvalidConstraintException;
import com.zeligsoft.base.validation.util.ValidationUtil;
import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Coordinator of language-specific ZDL constraint implementations. Currently,
 * the supported languages are a hard-coded list. If the requirement presents
 * itself, this can easily be factored out into an extension point like the
 * <tt>org.eclipse.emf.validation.constraintParsers</tt> point.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLConstraintManager {

	private static final String ZDL_ROOT_CATEGORY = "com.zeligsoft.base.validation.zdl"; //$NON-NLS-1$

	private static ZDLConstraintManager INSTANCE = new ZDLConstraintManager();

	/**
	 * Constraint factories registered per language.
	 */
	private Map<String, IZDLConstraintFactory> factories = new java.util.HashMap<String, IZDLConstraintFactory>();

	/**
	 * Map of ZDL concept qualified names to owned constraints.
	 */
	private Map<String, List<IModelConstraint>> conceptConstraints = new java.util.HashMap<String, List<IModelConstraint>>();
	
	
	/**
	 * Map of the ZDL domain to constraints that are not owned by a concept that are domain specific.
	 */
	private Map<String, Map<String, List<IModelConstraint>>> domainConstraints = 
		new java.util.HashMap<String, Map<String, List<IModelConstraint>>>();

	/**
	 * Map of ZDL model and domain-block qualified names to constraint
	 * categories.
	 */
	private Map<String, Category> zdlCategories = new java.util.HashMap<String, Category>();

	private boolean preloadInitialized;

	/**
	 * Not instantiable by clients.
	 */
	private ZDLConstraintManager() {
		super();
	}

	/**
	 * Obtains the singleton factory instance.
	 * 
	 * @return the factory
	 */
	public static ZDLConstraintManager getInstance() {
		return INSTANCE;
	}

	/**
	 * Obtains the constraints applicable to the specified domain concept.
	 * 
	 * @param concept
	 *            a domain concept
	 * 
	 * @return the applicable constraints
	 */
	List<IModelConstraint> getConstraints(Class concept) {
		List<IModelConstraint> result = conceptConstraints.get(concept
			.getQualifiedName());

		if (result == null) {
			Collection<Constraint> domainConstraints = ZDLUtil.getObjectsByConcept(
				concept.getOwnedRules(), ZDLNames.DOMAIN_CONSTRAINT);
				
			Set<IModelConstraint> modelConstraints = createModelConstraints(
				concept, domainConstraints);

			// inherit constraints
			for (Classifier parent : concept.getGenerals()) {
				if (parent instanceof Class) {
					modelConstraints.addAll(getConstraints((Class) parent));
				}
			}
			
			// disinherit redefined constraints
			for (Constraint next : domainConstraints) {
				for (Constraint redefined : getRedefinedConstraints(next)) {
					removeConstraint(modelConstraints, getID(redefined));
				}
			}

			result = new java.util.ArrayList<IModelConstraint>(modelConstraints);

			conceptConstraints.put(concept.getQualifiedName(), result);
		}

		return result;
	}
	/**
	 * Find all of the constraints that apply to the given concept in the 
	 * context (i.e. the domain) provided. That is, the constraints which
	 * are not owned by the concept but which are included in the domain
	 * through the a domain block reference.
	 * 
	 * @param context
	 * 			The profile which defines the domain.
	 * 
	 * @param constraintConcept
	 * 			The concept that we want the constraints for.
	 * 
	 * @return
	 * 			The list of constraints that apply to the concept. This
	 * 			does not include the constraints that are owned by the
	 * 			concept.
	 */
	List<IModelConstraint> getExternalConstraints(Profile context, 
			Class constraintConcept) {
		// get the constraints that are specific to the context of
		// the concept i.e. the domain, these constraints are specific to
		// the domain
		
		Set<IModelConstraint> domainResult = new HashSet<IModelConstraint>();
		for(Package block : ZDLUtil.getSourceDomainBlocks(context)){
			loadConstraints(block);
			Map<String, List<IModelConstraint>> blockMap = 
				domainConstraints.get(block.getQualifiedName());
			List<IModelConstraint> modelConstraints = blockMap.get(constraintConcept.getQualifiedName());
			if(modelConstraints != null) {
				domainResult.addAll(modelConstraints);
			}
			
			// get inherited constraints
			for(Classifier generalConcept : constraintConcept.allParents()) {
				if(ZDLUtil.isZDLConcept(generalConcept, ZDLNames.DOMAIN_CONCEPT)) {
					modelConstraints = blockMap.get(generalConcept.getQualifiedName());
					if(modelConstraints != null) {
						domainResult.addAll(modelConstraints);
					}
				}
			}
		}
		return new ArrayList<IModelConstraint>(domainResult);
	}
	
	/**
	 * Cache all of the constraints in the given domain block.
	 * 
	 * @param block
	 * 			The domain block to cache the constraints for
	 */
	void loadConstraints(Package block) {
		Map<String, List<IModelConstraint>> blockMap = 
			domainConstraints.get(block.getQualifiedName());
		
		if(blockMap == null) {
			blockMap = new java.util.HashMap<String, List<IModelConstraint>>();
			Collection<Constraint> domainBlockConstraints = 
				ZDLUtil.getObjectsByConcept(
					block.getOwnedRules(), ZDLNames.EXTERNAL_DOMAIN_CONSTRAINT);
			
			for (Constraint next : domainBlockConstraints) {
				try {
					for(org.eclipse.uml2.uml.Element concept : next.getConstrainedElements()) {
						if(ZDLUtil.isZDLConcept(concept, ZDLNames.DOMAIN_CONCEPT)) {
							String conceptName = ((Class) concept).getQualifiedName();
							List<IModelConstraint> conceptConstraints = 
								blockMap.get(conceptName);
							if(conceptConstraints == null) {
								conceptConstraints = new ArrayList<IModelConstraint>();
								blockMap.put(conceptName, conceptConstraints);
							}
							conceptConstraints.add(createConstraint((Class) concept, next)); 
						}
					}
				} catch (InvalidConstraintException e) {
					Activator.getDefault().error(
						NLS.bind(Messages.ZDLConstraintManager_initFailed,
							ValidationUtil.getQualifiedName(next)), e);
				}
			}
			
			domainConstraints.put(block.getQualifiedName(), blockMap);
		}
	}
	
	/**
	 * Obtains the constraint ID, used by the validation framework, of the
	 * specified domain constraint.
	 * 
	 * @param domainConstraint
	 *            a domain-concept constraint
	 * @return its ID
	 */
	private String getID(Constraint domainConstraint) {
		return (String) ZDLUtil.getValue(domainConstraint,
			ZDLNames.DOMAIN_CONSTRAINT, ZDLNames.DOMAIN_CONSTRAINT__ID);
	}
	
	/**
	 * Removes, from a bunch of validation-framework constraints, the one that
	 * is identified by a particular ID.
	 * 
	 * @param constraints
	 *            validation-framework constraints
	 * @param id
	 *            the ID of the constraint to remove
	 */
	private void removeConstraint(
			Collection<? extends IModelConstraint> constraints, String id) {
		for (Iterator<? extends IModelConstraint> iter = constraints.iterator(); iter
			.hasNext();) {
			
			if (id.equals(iter.next().getDescriptor().getId())) {
				iter.remove();
				break;
			}
		}
	}
	
	/**
	 * Queries the constraints that are redefined by the specified
	 * domain-concept constraint.
	 * 
	 * @param domainConstraint
	 *            a domain-concept constraint
	 * @return the constraints that it re-defines, or an empty collection if
	 *         none
	 */
	@SuppressWarnings("unchecked")
	private Collection<Constraint> getRedefinedConstraints(
			Constraint domainConstraint) {
		
		return (Collection<Constraint>) ZDLUtil.getValue(domainConstraint,
			ZDLNames.DOMAIN_CONSTRAINT,
			ZDLNames.DOMAIN_CONSTRAINT__REDEFINED_CONSTRAINT);
	}

	/**
	 * Creates the constraints applicable to the specified domain concepts,
	 * which owns the given domain constraints.
	 * 
	 * @param concept
	 *            a domain concept
	 * @param domainConstraints
	 *            the domain constraints that it owns
	 * 
	 * @return the validation-framework constraint implementations
	 */
	private Set<IModelConstraint> createModelConstraints(Class concept,
			Collection<? extends Constraint> domainConstraints) {

		Set<IModelConstraint> result = new java.util.HashSet<IModelConstraint>();

		for (Constraint next : domainConstraints) {
			try {
				result.add(createConstraint(concept, next));
			} catch (InvalidConstraintException e) {
				Activator.getDefault().error(
					NLS.bind(Messages.ZDLConstraintManager_initFailed,
						ValidationUtil.getQualifiedName(next)), e);
			}
		}

		return result;
	}

	/**
	 * Creates a new constraint implementation from the given UML specification
	 * of the constraint.
	 * 
	 * @param concept
	 *            the ZDL concept that owns the constraint
	 * @param umlConstraint
	 *            the UML constraint specification
	 * @return the new constraint implementation
	 * 
	 * @throws InvalidConstraintException
	 *             on failure to initialize the constraint (no such Java class,
	 *             missing OCL expression, or other problems)
	 */
	public IModelConstraint createConstraint(Class concept,
			Constraint umlConstraint)
			throws InvalidConstraintException {

		ValueSpecification spec = umlConstraint.getSpecification();

		if (!(spec instanceof OpaqueExpression)) {
			throw new InvalidConstraintException(
				"umlConstraint specification is not an OpaqueExpression"); //$NON-NLS-1$
		}

		OpaqueExpression specification = (OpaqueExpression) spec;
		int index = getSupportedLanguage(umlConstraint, specification);

		String language;
		String body;

		try {
			language = specification.getLanguages().get(index);
			body = specification.getBodies().get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new InvalidConstraintException(
				"umlConstraint specification is malformed", e); //$NON-NLS-1$
		}

		IConstraintDescriptor desc = createDescriptor(concept, umlConstraint);

		try {
			ConstraintRegistry.getInstance().register(desc);
		} catch (ConstraintExistsException e) {
			throw new InvalidConstraintException(
				Messages.ZDLConstraintManager_dupeID, e);
		}

		return createConstraint(language, umlConstraint, body, desc);
	}

	/**
	 * Registers the specified factory for ZDL constraints specified in a
	 * particular constraint language.
	 * 
	 * @param factory
	 *            the constraint factory to register
	 */
	public void addConstraintFactory(IZDLConstraintFactory factory) {
		final String lang = factory.getLanguage();

		if (factories.containsKey(lang)) {
			Activator.getDefault().warning(
				NLS.bind(Messages.ZDLConstraintManager_dupeLanguage, lang));
		}

		factories.put(lang, factory);
	}

	private IModelConstraint createConstraint(String language,
			Constraint umlConstraint, String body,
			IConstraintDescriptor descriptor)
			throws InvalidConstraintException {
		IZDLConstraintFactory factory = factories.get(language);

		return factory.createConstraint(umlConstraint, body, descriptor);
	}

	/**
	 * Finds a language in the given expression that is supported by this
	 * factory for parsing as a constraint and returns its index in the list of
	 * languages.
	 * 
	 * @param constraint
	 *            the UML constraint specification
	 * @param expr
	 *            an opaque expression
	 * 
	 * @return the index of the supported language that was found
	 * 
	 * @throws InvalidConstraintException
	 *             if no supported language is found
	 */
	private int getSupportedLanguage(Constraint umlConstraint,
			OpaqueExpression expr)
			throws InvalidConstraintException {
		int result = 0;
		List<String> languages = expr.getLanguages();
		int count = languages.size();

		for (; result < count; result++) {
			String next = languages.get(result);

			if (factories.containsKey(next)) {
				break;
			}
		}

		if (result >= count) {
			throw new InvalidConstraintException(NLS.bind(
				Messages.ZDLConstraintManager_noLanguage, ValidationUtil
					.getQualifiedName(umlConstraint)));
		}

		return result;
	}

	private IConstraintDescriptor createDescriptor(Class concept,
			Constraint umlConstraint) {

		IConstraintDescriptor result = new ZDLConstraintDescriptor(
			umlConstraint);

		Package block = concept.getNearestPackage();
		getCategory(block).addConstraint(result);

		return result;
	}

	private Category getCategory(Package zdlPackage) {
		String qualifiedName = zdlPackage.getQualifiedName();
		Category result = zdlCategories.get(qualifiedName);

		if (result == null) {
			result = createCategory(zdlPackage, qualifiedName);
			zdlCategories.put(qualifiedName, result);
		}

		return result;
	}

	private Category createCategory(Package zdlPackage, String qualifiedName) {
		Package nesting = null;
		if (zdlPackage.getNamespace() != null) {
			nesting = zdlPackage.getNamespace().getNearestPackage();
		}

		Category parent = (nesting == null)
			? getZDLCategory()
			: getCategory(nesting);

		Category result = CategoryManager.getInstance().getCategory(parent,
			zdlPackage.getName());

		result.setName(zdlPackage.getLabel());

		return result;
	}

	/**
	 * Obtains the root category under which all ZDL constraints are
	 * contributed.
	 * 
	 * @return the root ZDL category
	 */
	public Category getZDLCategory() {
		return CategoryManager.getInstance().getCategory(ZDL_ROOT_CATEGORY);
	}

	/**
	 * Ensures that the pre-loaded constraints are initialized.
	 */
	public synchronized void inializePreloadedConstraints() {
		if (!preloadInitialized) {
			preloadInitialized = true;
			PreloadRegistry.INSTANCE.readRegistry();
		}
	}
}
