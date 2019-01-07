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
package com.zeligsoft.base.zdl.ocl.test;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.junit.After;
import org.junit.Before;

import com.zeligsoft.base.zdl.ocl.ZDLEnvironment;
import com.zeligsoft.base.zdl.ocl.ZDLEnvironmentFactory;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Common framework for the ZDL OCL tests.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class AbstractTestCase
	 {

	protected ResourceSet rset;

	protected OCL ocl;

	protected OCL.Helper helper;

	protected ZDLEnvironment env;

	//
	// Framework methods
	//

	@Before
	public void setUp()
			throws Exception {


		rset = new ResourceSetImpl();

		ocl = OCL.newInstance(new ZDLEnvironmentFactory(rset));
		helper = ocl.createOCLHelper();
		env = (ZDLEnvironment) ocl.getEnvironment();
	}

	@After
	public void tearDown()
			throws Exception {

		disposeOCL();

		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();

		rset = null;

	}

	private void disposeOCL() {
		// TODO(OCL 1.2): dispose the OCL facade
		env = null;
		helper = null;
		ocl = null;
	}

	protected Constraint parse(Class concept, String constraintName) {
		Constraint definition = concept.getOwnedRule(constraintName);
		String body = ((OpaqueExpression) definition.getSpecification())
			.getBodies().get(0);

		helper.setContext(concept);

		Constraint result = null;

		try {
			result = helper.createInvariant(body);
			result.setName(constraintName);
		} catch (ParserException e) {
			fail(String.format("Failed to parse constraint %s: %s",
				constraintName, e.getLocalizedMessage()));
			return null; // won't reach this
		}

		return result;
	}

	protected OCLExpression<Classifier> parseQuery(Classifier context,
			String text) {

		helper.setContext(context);

		OCLExpression<Classifier> result = null;

		try {
			result = helper.createQuery(text);
		} catch (ParserException e) {
			fail(String.format("Failed to parse query: %s", e
				.getLocalizedMessage()));
			return null; // won't reach this
		}

		return result;
	}

	protected void assertTrue(EObject context, Constraint constraint) {
		org.junit.Assert.assertTrue("Constraint was not met: " + constraint.getName(), evaluate(
			context, constraint));
	}

	private boolean evaluate(EObject context, Constraint constraint) {
		Object result = null;

		try {
			result = ocl.evaluate(context, ((ExpressionInOCL) constraint
				.getSpecification()).getBodyExpression());
		} catch (Exception e) {
			fail(String.format("Failed to evaluate constraint %s: %s",
				constraint.getName(), e.getLocalizedMessage()));
		}

		if (result == env.getOCLStandardLibrary().getOclInvalid()) {
			fail("Constraint evaluation resulted in OclInvalid");
		}

		return (Boolean) result;
	}

	protected void assertFalse(EObject context, Constraint constraint) {
		org.junit.Assert.assertFalse("Constraint was met: " + constraint.getName(), evaluate(
			context, constraint));
	}
	
	protected void assertEval(Object expectedValue, OCLExpression<Classifier> expr, Object context) {
		Object actualValue = ocl.evaluate(context, expr);
		assertEquals(expectedValue, actualValue);
	}

	@SuppressWarnings("unchecked")
	protected <T extends Classifier> T getConcept(T profileClass) {
		return (T) profileClass.getEAnnotation(ZDLUtil.ZDL_NAMESPACE_URI)
			.getReferences().get(0);
	}
}
