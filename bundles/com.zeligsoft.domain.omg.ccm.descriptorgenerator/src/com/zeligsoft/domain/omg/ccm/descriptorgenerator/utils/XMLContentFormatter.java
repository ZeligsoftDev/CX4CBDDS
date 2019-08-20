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
package com.zeligsoft.domain.omg.ccm.descriptorgenerator.utils;

import org.eclipse.xtend.typesystem.xsd.XMLMixedContentFormatter;

public class XMLContentFormatter extends XMLMixedContentFormatter {

	/*
	 * Need to override XMLMixedContentFormater#trimRight to deal with  
	 * comments as extra newlines are put in, which are never trimmed out,
	 * leaving chunks of unwanted whitespace
	 */
	@Override
	protected String trimRight(Object val) {
		if (val instanceof String) {
			String s = val.toString();
			int i = s.length() - 1;
			while (i >= 0 && (s.charAt(i) == ' ' || s.charAt(i) == '\n' || s.charAt(i) == '\r'))
				i--;
			String r = s.substring(0, i + 1);
			return r;
		}
		return "";
	}
}
