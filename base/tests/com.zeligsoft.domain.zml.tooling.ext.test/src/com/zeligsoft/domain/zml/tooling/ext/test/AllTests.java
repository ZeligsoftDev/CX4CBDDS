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
package com.zeligsoft.domain.zml.tooling.ext.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * Tests for the <tt>com.zeligsoft.domain.zml.tooling.ext</tt> plug-in.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class AllTests
		extends TestSuite {

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		TestSuite suite = new AllTests("Extended ZML Tooling Tests"); //$NON-NLS-1$
		suite.addTestSuite(ZMLUtilTests.class);
		return suite;
	}

	public AllTests(String name) {
		super(name);
	}

}
