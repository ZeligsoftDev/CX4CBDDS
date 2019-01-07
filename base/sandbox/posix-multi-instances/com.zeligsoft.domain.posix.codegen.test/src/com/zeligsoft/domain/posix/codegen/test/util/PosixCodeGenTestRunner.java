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
package com.zeligsoft.domain.posix.codegen.test.util;

import java.util.Arrays;

import com.zeligsoft.base.langc.test.util.LangCTestRunner;
import com.zeligsoft.base.oaw.test.XTendTestRunner;

public class PosixCodeGenTestRunner extends XTendTestRunner {

	private static final Iterable<String> zdlMMUris = Arrays.asList(
		"platform:/plugin/com.zeligsoft.domain.posix/models/POSIX.uml",
		"platform:/plugin/com.zeligsoft.domain.clanguage/models/CLanguageDomain.uml"
	);

	public static <T> T run(String xtendTopRule, Object... args) {
		return LangCTestRunner.run(zdlMMUris, xtendTopRule, args);
	}
}
