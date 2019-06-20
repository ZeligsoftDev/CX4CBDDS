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
package com.zeligsoft.base.validation.test;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import com.zeligsoft.base.validation.test.constraints.TestClientContext;

/**
 * Abstract test framework for validation tests.
 * 
 * @param <T>
 *            The type parameter binding for the test case's
 *            {@link EvaluationMode}
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class AbstractTestCase<T> {

	protected ResourceSet rset;

	protected Model testModel;

	protected Actor bob;

	protected Actor sally;

	protected UseCase amy;

	protected UseCase joe;

	protected IStatus status;

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public AbstractTestCase() {
		// Default constructor
	}

	@Before
	public void setUp()
			throws Exception {

		rset = new ResourceSetImpl();

		testModel = (Model) loadPackage("/models/test_model.emx");

		bob = (Actor) testModel.getOwnedType("Bob");
		sally = (Actor) testModel.getOwnedType("Sally");
		amy = (UseCase) testModel.getOwnedType("Amy");
		joe = (UseCase) testModel.getOwnedType("Joe");

		TestClientContext.isEnabled = true;
	}

	protected Package loadPackage(String path) {
		Resource res = rset.getResource(URI.createPlatformPluginURI(
			"/com.zeligsoft.base.validation.test" + path, true), true);
		assertTrue("Test resource not loaded", res.isLoaded());

		Package result = (Package) EcoreUtil.getObjectByType(res.getContents(),
			UMLPackage.Literals.PACKAGE);
		assertNotNull("No test package", result);

		return result;
	}

	@After
	public void tearDown()
			throws Exception {

		TestClientContext.isEnabled = false;

		bob = null;
		sally = null;
		amy = null;
		joe = null;

		testModel = null;

		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.eAdapters().clear();
		rset = null;

	}

	protected abstract EvaluationMode<T> getEvaluationMode();

	@SuppressWarnings("unchecked")
	protected final IStatus validate() {
		return validate((T) testModel);
	}

	protected final IStatus validate(T element) {
		IValidator<T> validator = ModelValidationService.getInstance()
			.newValidator(getEvaluationMode());

		// need to report success statuses to assert that constraints were
		// evaluated in the first place
		validator.setReportSuccesses(true);
		status = validator.validate(element);

		return status;
	}

	protected void assertConstraintPassed(EObject target, String id) {
		assertConstraintStatus(target, id, IStatus.OK);
	}

	protected void assertConstraintFailed(EObject target, String id) {
		assertConstraintStatus(target, id, IStatus.INFO | IStatus.WARNING
			| IStatus.ERROR | IStatus.CANCEL);
	}

	protected void assertConstraintStatus(EObject target, String id, int mask) {
		IStatus specific = assertStatus(target, id);

		if (mask == IStatus.OK) {
			if (!specific.isOK()) {
				fail(String.format("Constraint %s failed for %s", id, target));
			}
		} else if (specific.isOK()) {
			fail(String.format("Constraint %s passed for %s", id, target));
		} else if ((specific.getSeverity() & mask) == 0) {
			fail(String.format("Constraint %s has wrong status for %s", id,
				target));
		}
	}

	protected IStatus assertStatus(EObject target, String id) {
		IStatus result = findStatus(status, target, id);

		if (result == null) {
			fail(String
				.format("Constraint %s not evaluated for %s", id, target));
		} else {
			dump(result);
		}

		return result;
	}

	protected void assertConstraintNotEvaluated(EObject target, String id) {
		if (findStatus(status, target, id) != null) {
			dump(status);
			fail(String
				.format("Constraint %s was evaluated for %s", id, target));
		}
	}

	private void dump(IStatus status) {
		if (status.isMultiStatus()) {
			for (IStatus next : status.getChildren()) {
				dump(next);
			}
		} else {
			System.out.println(status.getMessage());
		}
	}

	private IStatus findStatus(IStatus status, EObject target, String id) {
		IStatus result = null;

		if (status instanceof IConstraintStatus) {
			IConstraintStatus cstatus = (IConstraintStatus) status;

			if ((cstatus.getTarget() == target)
				&& id.equals(cstatus.getConstraint().getDescriptor().getId())) {
				result = cstatus;
			}
		}

		if ((result == null) && status.isMultiStatus()) {
			for (IStatus next : status.getChildren()) {
				result = findStatus(next, target, id);
				if (result != null) {
					break;
				}
			}
		}

		return result;
	}
}
