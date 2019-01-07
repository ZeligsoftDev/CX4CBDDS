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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

/**
 * A specialization of the oAW metamodel for Ecore models that does not provide
 * EClass types for EObjects that are not instances of EClasses in its EPackage.
 * This works around the problem in oAW that, though an Ecore metamodel cannot
 * resolve the names of types outside of its EPackage, it happily provides types
 * for instances of EClasses of any package. This causes the TypeSystem to get
 * too many resulting Types from the wrong metamodels.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class EcoreMetamodel
		extends EmfMetaModel {

	/**
	 * Initializes me.
	 */
	public EcoreMetamodel() {
		super();
	}

	/**
	 * Initializes me with my EPackage.
	 * 
	 * @param metamodel
	 *            my EPackage
	 */
	public EcoreMetamodel(EPackage metamodel) {
		super(metamodel);
	}

	@Override
	public Type getTypeForEClassifier(EClassifier element) {
		if ((element != null) && (element.getEPackage() != getEPackage())) {
			return null;
		}

		return super.getTypeForEClassifier(element);
	}
	
	protected final EPackage getEPackage() {
		// the superclass always creates a singleton package array
		return allPackages()[0];
	}
}
