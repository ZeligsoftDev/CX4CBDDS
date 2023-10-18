/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;


public class OCLstdlibJavaValidator extends AbstractOCLstdlibJavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.GREETING__NAME);
//		}
//	}

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(BaseCSPackage.eINSTANCE);
	    result.add(OCLstdlibCSPackage.eINSTANCE);
		return result;
	}


/*	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return super.validate(eDataType, value, diagnostics, context);
	}


	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (eObject instanceof ModelElementCS) {
			ModelElementCS csElement = (ModelElementCS) eObject;
			EObject pivotObject = csElement.getOriginalObject();
			if (pivotObject == null) {
				recreatePivot(csElement.eResource());
			}
			return super.validate(pivotObject, diagnostics, context);
		}
		else {
			return super.validate(eObject, diagnostics, context);
		}
	}


	private void recreatePivot(Resource eResource) {
		// TODO Auto-generated method stub

	} &
	*/

}
