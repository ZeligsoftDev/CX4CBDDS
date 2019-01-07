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
package com.zeligsoft.base.validation.test.constraints;

import org.eclipse.emf.validation.model.IClientSelector;

/**
 * Simple toggle context for testing purposes.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TestClientContext
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
