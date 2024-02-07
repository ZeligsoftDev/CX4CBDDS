/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtend.typesystem.emf;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.ConfigurationException;

public class EmfMetaModel extends EmfRegistryMetaModel {
	private EPackage metamodel;

	public EmfMetaModel() {
	}
	
	public EmfMetaModel(final EPackage metamodel) {
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