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
package com.zeligsoft.domain.sca.agilent.importer.test.util;

import java.util.Arrays;

import com.zeligsoft.base.oaw.test.XTendTestRunner;

public class AgilentImporterTestRunner extends XTendTestRunner {

	private static final Iterable<String> zdlMMUris = Arrays.asList(
		"platform:/plugin/com.zeligsoft.domain.sca/models/SCA.uml",
		"platform:/plugin/com.zeligsoft.domain.omg.corba/models/CORBADomain.uml"
	);

	public static <T> T run(String xtendTopRule, Object... args) {
		return AgilentTestRunner.run(zdlMMUris, xtendTopRule, args);
	}
}
