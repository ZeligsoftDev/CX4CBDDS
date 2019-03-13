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
package com.zeligsoft.domain.dds4ccm.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

public class DDS4CCMValidationController {

	private static IBatchValidator validator = null;
	
	/**
	 * Produces a new IRunnableWithProgress to run validation with the SCA traversal strategy. A client
	 * can then run it with their own IProgressMonitor.
	 * 
	 * Stores the resulting IStatus in a static variable for later retrieval.
	 * 
	 * @param objectsToValidate
	 * @return
	 */
	public static IBatchValidator getValidator() {
		
		if( validator == null ) {
			// Create a new validator.
			validator = ModelValidationService.getInstance()
			.newValidator(EvaluationMode.BATCH);
			// Set up clientData map so that RSM will display the problem markers.
			validator.putClientData("markerType", "com.ibm.xtools.modeler.validation.validationProblem");  //$NON-NLS-1$//$NON-NLS-2$
		}
		
		return validator;
	}
	
	/**
	 * Validate the EObject passed in.
	 * 
	 * @param objectToValidate
	 * @return
	 * 		True if validation passes, false if it throws an exception or there are any problems.
	 */
	public static boolean validate(EObject objectToValidate ) {
		List<EObject> validateList = new ArrayList<EObject>();
		validateList.add(objectToValidate);
		return validate(validateList);
	}
	
	/**
	 * Validate the list of EObjects passed in.
	 * 
	 * @param objectsToValidate
	 * @return
	 * 		True if validation passes, false if it throws an exception or there are any problems.
	 */	
	public static boolean validate(List<EObject> objectsToValidate) {

		IBatchValidator validator = DDS4CCMValidationController.getValidator();
		
		IStatus status = null;
		
		try {
			status = validator.validate(objectsToValidate, new NullProgressMonitor());	
		} catch(Exception exc) {
			return false;
		}
		
		if( status.getSeverity() == IStatus.ERROR || status.getSeverity() == IStatus.WARNING ) {
			return false;
		}
		return true;
	}
}
