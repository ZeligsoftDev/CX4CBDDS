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



import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.uml2.uml.Classifier;
import org.junit.Test;

/**
 * Tests the access to custom string operations from OCL expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class StringOperationsTest
		extends AbstractTestCase {


	/**
	 * Tests the <tt>matches</tt> operation.
	 */
	@Test
	public void test_matches() {
		OCLExpression<Classifier> expr = parseQuery(getFixture(), "self.matches('\\d{3}-\\p{Alpha}+')");
		
		assertEval(Boolean.TRUE, expr, "321-Contact");
		assertEval(Boolean.FALSE, expr, "321-Liftoff!");
	}
	
	//
	// Framework methods
	//
	
	/**
	 * Obtains the OCL <tt>String</tt> class on which we defined our additional operations.
	 */
	Classifier getFixture() {
		return env.getOCLStandardLibrary().getString();
	}
}
