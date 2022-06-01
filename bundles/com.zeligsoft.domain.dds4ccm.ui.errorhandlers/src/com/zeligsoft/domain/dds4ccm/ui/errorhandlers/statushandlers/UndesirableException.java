/**
 * Copyright 2022 Zeligsoft (2009) Limited.
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
package com.zeligsoft.domain.dds4ccm.ui.errorhandlers.statushandlers;

import java.util.regex.Pattern;

/**
 * Instances of this class store information about exceptions that should be filtered by the 
 * {@link FilteringStatusHandler}.
 * 
 * @author Ernesto Posse
 */
		
public class UndesirableException {
	
	public String exceptionClassName;
	public Pattern originClassNamePattern;
	public Pattern originMethodNamePattern;
	public Integer maximumDepth;

	public UndesirableException(String exceptionClassName, String originClassNamePattern,
			String originMethodNamePattern, Integer maximumDepth) {
		init(exceptionClassName, originClassNamePattern, originMethodNamePattern, maximumDepth);
	}

	public UndesirableException(FilteringStatusHandler filteringStatusHandler, String exceptionClassName, String originClassNamePattern,
			String originMethodNamePattern) {
		init(exceptionClassName, originClassNamePattern, originMethodNamePattern, null);
	}

	public UndesirableException(String exceptionClassName,
			String originFullyQualifiedMethodNamePattern, Integer maximumDepth) {
		String originClassNamePattern = "";
		String originMethodNamePattern = "";
		if (originFullyQualifiedMethodNamePattern != null) {
			int lastDotIndex = originFullyQualifiedMethodNamePattern.lastIndexOf(Character.getNumericValue('.'));
			originClassNamePattern = originFullyQualifiedMethodNamePattern.substring(0, lastDotIndex);
			originMethodNamePattern = originFullyQualifiedMethodNamePattern.substring(lastDotIndex);
		}
		init(exceptionClassName, originClassNamePattern, originMethodNamePattern, maximumDepth);
	}

	public UndesirableException(String exceptionClassName,
			String originFullyQualifiedMethodNamePattern) {
		this(exceptionClassName, originFullyQualifiedMethodNamePattern, (Integer) null);
	}

	private void init(String exceptionClassName, String originClassNamePattern,
			String originMethodNamePattern, Integer maximumDepth) {
		this.exceptionClassName = exceptionClassName;
		if (originClassNamePattern == null || originClassNamePattern.isBlank()) {
			originClassNamePattern = ".*";
		}
		if (originMethodNamePattern == null || originMethodNamePattern.isBlank()) {
			originMethodNamePattern = ".*";
		}
		this.originClassNamePattern = Pattern.compile(originClassNamePattern);
		this.originMethodNamePattern = Pattern.compile(originMethodNamePattern);
		this.maximumDepth = maximumDepth;
	}

	public String getExceptionClassName() {
		return this.exceptionClassName;
	}

	public Pattern getOriginClassNamePattern() {
		return this.originClassNamePattern;
	}

	public Pattern getOriginMethodNamePattern() {
		return this.originMethodNamePattern;
	}

	public Integer getMaximumDepth() {
		return this.maximumDepth;
	}
	
}