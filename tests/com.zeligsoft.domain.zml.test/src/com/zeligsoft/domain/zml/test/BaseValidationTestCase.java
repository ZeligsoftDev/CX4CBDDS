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

package com.zeligsoft.domain.zml.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.After;
import org.junit.Before;

/**
 * @author Annie Valade
 *
 */
@SuppressWarnings("nls")
public abstract class BaseValidationTestCase {

	protected static String PLUGIN_ID = "";
	
	protected ResourceSet rset;
	
	protected IStatus status;
	
	/**
	 * Initialize a validation test with its name.
	 * 
	 * @param name
	 */
	public BaseValidationTestCase() {
		// Default constructor
	}
	
	@Before
	public void setUp()
			throws Exception {

		rset = new ResourceSetImpl();

		TestClientContext.isEnabled = true;
	}
	
	@After
	public void tearDown()
			throws Exception {

		TestClientContext.isEnabled = false;

		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.eAdapters().clear();
		rset = null;
	}
	
	protected Package loadPackage(String path) {
		Resource res = rset.getResource(URI.createPlatformPluginURI(
			PLUGIN_ID + path, true), true);
		assertTrue("Test resource not loaded", res.isLoaded());

		Package result = (Package) EcoreUtil.getObjectByType(res.getContents(),
			UMLPackage.Literals.PACKAGE);
		assertNotNull("No test package", result);

		return result;
	}
	
	
	protected EvaluationMode<EObject> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}
	
	abstract protected void setTraversalStrategy(IBatchValidator validator);
	
	protected IStatus validate(EObject element) {
		IBatchValidator validator = ModelValidationService.getInstance()
		.newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);
	
		setTraversalStrategy(validator);
		
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
	
	protected void assertConstraintNotFound(EObject target, String id) {
		IStatus result = findStatus(status, target, id);
		
		if(result != null) {
			fail(String.format("Constraint %s was evaluated for %s when it shouldn't have been.", id, target));
		}
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
		}

		return result;
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
	
	/**
	 * Simple toggle context for testing purposes.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	public static class TestClientContext
			implements IClientSelector {

		/** Set enabled during validation tests to ensure constraint evaluation. */
		public static boolean isEnabled = false;

		/**
		 * Initializes me.
		 */
		public TestClientContext() {
			super();
		}

		@Override
		public boolean selects(Object object) {
			return isEnabled;
		}

	}
	

	public enum TestResult {PASS, FAIL}
	
	protected class ExpectedResult {	
		public TestResult result;		
		public String constraintId;		
		public String elementName;
		
		public boolean shouldFindIt = true;
		
		public ExpectedResult( TestResult result, String constraintId, String elementName ) {
			this(result, constraintId, elementName, true);
		}
		
		public ExpectedResult(TestResult result, String constraintId, String elementName, boolean shouldFindIt) {
			assertNotNull("No result specified.", result);
			assertNotNull("No constraint specified.", constraintId);
			assertNotNull("No element specified.", elementName);
			this.result = result;
			this.constraintId = constraintId;
			this.elementName = elementName;
			this.shouldFindIt = shouldFindIt;
		}
	}
	
	protected void validateModel(String packageName, String elementName, 
			Collection<ExpectedResult> expectedResults) {
	
		Package packageToValidate = loadPackage(packageName);
		NamedElement elementToValidate = null;

		Collection<NamedElement> elements = 
			UMLUtil.findNamedElements(packageToValidate.eResource(), elementName);
		assertFalse(String.format("Test model does not contain an element to validate, name %s.", elementName), elements.isEmpty());
		
		elementToValidate = elements.iterator().next();
		
		assertNotNull("Test model does not contain element to validate, name = " + elementName + ".", elementToValidate);
		validate(elementToValidate);
				
		
		for( ExpectedResult e : expectedResults) {
			
			Element target = null;
			for( Iterator<EObject> iter = packageToValidate.eAllContents(); iter.hasNext();  ) {

				EObject eobj = iter.next();				
				
				if( eobj instanceof NamedElement) {
					NamedElement elm = (NamedElement)eobj;
					
					if( e.elementName.equals(elm.getQualifiedName())) {
						target = elm;
					}					
				}				
			}
			assertNotNull("Could not find element to evaluate validation results for, name = " + e.elementName + ".", target);
			
			if(e.shouldFindIt) {
				if( e.result == TestResult.PASS ) {
					assertConstraintPassed(target, e.constraintId);
				} else {
					assertConstraintFailed(target, e.constraintId);
				}
			} else {
				assertConstraintNotFound(target, e.constraintId);
			}
			
			// Used for debugging.
			//System.out.println("Test passed: " + e.constraintId + " on " + e.elementName + ", expected to " + (e.result == TestResult.PASS ? "pass ." : "fail ."));
		}
	}
}
