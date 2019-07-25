package com.zeligsoft.base.validation.util;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.zdl.ocl.ZDLEnvironment;
import com.zeligsoft.base.zdl.ocl.ZDLEnvironmentFactory;
import com.zeligsoft.base.zdl.ocl.ZDLToProfileTransformation;

/**
 * A cache of OCL constraints transformed from the ZDL metamodel to a particular
 * UML profile, on which the cache is attached as an adaptor in order to clean
 * itself up when the profile is unloaded. The transformed AST is different for
 * every profile that manifests the same constraints defined on the same ZDL
 * concept.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("rawtypes")
public final class OCLCache
		extends AdapterImpl {

	private ZDLEnvironment env;

	private OCL ocl;

	private OCLHelper helper;

	/**
	 * Mapping of parsed (and transformed) constraints per concept (by qualified
	 * name).
	 */
	private Map<String, Map<IOCLProvider, Constraint>> constraints;

	/**
	 * Initializes me with the profile for which I cache transformed
	 * constraints.
	 * 
	 * @param profile
	 *            my profile
	 */
	private OCLCache(Profile profile) {
		ZDLEnvironmentFactory factory = new ZDLEnvironmentFactory(profile
			.eResource().getResourceSet());
		env = factory.createEnvironment();
		ocl = OCL.newInstance(env);
		helper = ocl.createOCLHelper();
		constraints = new java.util.HashMap<String, Map<IOCLProvider, Constraint>>();
	}

	/**
	 * Obtains the lazily created adapter for the specified profile.
	 * 
	 * @param profile
	 *            a profile
	 * @return its adapter (never <code>null</code>)
	 */
	public static OCLCache adapt(Profile profile) {
		OCLCache result = (OCLCache) EcoreUtil.getExistingAdapter(profile,
			OCLCache.class);

		if (result == null) {
			result = new OCLCache(profile);
			profile.eAdapters().add(result);
		}

		return result;
	}

	/**
	 * Obtains the transformed OCL constraint for the specified validation
	 * constraint definition, in the context of my profile. If the constraint is
	 * not already available, it will be parsed and transformed lazily.
	 * 
	 * @param ocl
	 *            the validation framework definition of the constraint
	 * @return the parsed and transformed OCL constraint
	 * @throws ParserException
	 *             on any problem in parsing the ZDL constraint
	 */
	public synchronized Constraint getConstraint(IOCLProvider ocl)
			throws ParserException {

		String concept = ocl.getConcept();

		Map<IOCLProvider, Constraint> map = constraints.get(concept);

		if (map == null) {
			map = new java.util.HashMap<IOCLProvider, Constraint>();
			constraints.put(concept, map);
		}

		Constraint result = map.get(ocl);
		if (result == null) {
			result = parseConstraint(ocl);
			map.put(ocl, result);
		}

		return result;
	}

	/**
	 * Parses the specified constraint and transforms its AST from the ZDL
	 * metamodel to my UML profile schema.
	 * 
	 * @param ocl
	 *            the validation framework definition of the constraint
	 * @return the OCL constraint
	 * @throws ParserException
	 *             on any problem in parsing the ZDL constraint
	 */
	private Constraint parseConstraint(IOCLProvider ocl)
			throws ParserException {

		UMLEnvironment nested = (UMLEnvironment) helper.getEnvironment();

		ocl.configure(helper, nested, getProfile());

		Constraint zdl = (Constraint) helper.createInvariant(ocl.getOCL());

		ZDLToProfileTransformation xform = new ZDLToProfileTransformation(env,
			getProfile());
		for (Variable<Classifier, Parameter> var : nested.getVariables()) {
			xform.toProfileVariable(var);
		}

		return xform.toProfileConstraint(zdl);
	}

	/**
	 * Obtains the profile for which I cache parsed constraints.
	 * 
	 * @return my profile
	 */
	Profile getProfile() {
		return (Profile) getTarget();
	}

	/**
	 * Obtains the OCL parsing and evaluation facade that I use.
	 * 
	 * @return the OCL facade that I use to parse and evaluate constraints
	 */
	public OCL getOCL() {
		return ocl;
	}

	/**
	 * Cleans me up when I am no longer needed.
	 */
	void dispose() {
		if (ocl != null) {
			for (Iterator<EObject> iter = EcoreUtil.getAllContents(ocl
				.getConstraints()); iter.hasNext();) {

				iter.next().eAdapters().clear();
			}

			ocl.dispose();

			helper = null;
			ocl = null;
			env = null;
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		// this is OK because the OCLCache class is final
		return type == OCLCache.class;
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		dispose();

		super.unsetTarget(oldTarget);
	}
}