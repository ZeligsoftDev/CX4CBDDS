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
package com.zeligsoft.base.zdl.oaw;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

/**
 * Copy of {@link EmfMetaModel}, changing the inheritance hierarchy.
 * @author Zeligsoft
 *
 */
public class ZEmfMetaModel extends ZEmfRegistryMetaModel {
	private EPackage metamodel;

	public ZEmfMetaModel() {
		// nothing to do
	}
	
	public ZEmfMetaModel(final EPackage metamodel) {
		this.metamodel = metamodel;
	}
	
	/**
	 * Sets the metamodel descriptor.
	 * 
	 * @param ePackageDescriptor
	 *            the descriptor
	 */
	public void setMetaModelDescriptor(final String ePackageDescriptor) {
		metamodel = EcoreUtil2.getEPackageByDescriptorClassName(ePackageDescriptor);
		if (metamodel == null)
			throw new ConfigurationException("Couldn't find ePackage Descriptor '" + ePackageDescriptor);
		}

	/**
	 * Sets the metamodel package.
	 * 
	 * @param ePackage
	 *            the package
	 */
	public void setMetaModelPackage(final String ePackage) {
		metamodel = EcoreUtil2.getEPackageByClassName(ePackage);
		if (metamodel == null)
			throw new ConfigurationException("Couldn't find ePackage '" + ePackage);
		}

	/**
	 * Sets the name of the metamodel file.
	 * 
	 * @param metaModelFile
	 *            the metamodel filename
	 */
	public void setMetaModelFile(final String metaModelFile) {
		metamodel = EcoreUtil2.getEPackage(metaModelFile);
		if (metamodel == null)
			throw new ConfigurationException("Couldn't load ecore file '" + metaModelFile);
		}
	
	@Override
	protected EPackage[] allPackages() {
		return new EPackage[] { metamodel };
	}
}
