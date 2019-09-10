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
package com.zeligsoft.cx.codegen.editor;

public interface IUserEditableElementDescriptor
{
	public static interface IM2MTransformationDescriptor
	{
		public int getOrder();
		public String getOutput();
		public String getRule();
		public Iterable<IEditSourceExtraParamFactory> getExtraParamFactories();

		public Iterable<String> getMetaModelClasses();
		public Iterable<String> getUmlProfiles();
		public Iterable<String> getEMFMetaModelPackages();
		public Iterable<String> getZDLMetaModels();
	}

	public static interface IM2TTransformationDescriptor
	{
		public int getOrder();
		public String getRule();

		public Iterable<String> getMetaModelClasses();
		public Iterable<String> getUmlProfiles();
		public Iterable<String> getEMFMetaModelPackages();
		public Iterable<String> getZDLMetaModels();
	}

	public String getLabel();
	public String getConcept();
	public String getContainerConcept();
	public String getProperty();
	public ICodeLocator getCodeLocator();
	public IValidationFactory getValidationFactory();

	public Iterable<IM2MTransformationDescriptor> getM2MDescriptors();
	public Iterable<IM2TTransformationDescriptor> getM2TDescriptors();
}
