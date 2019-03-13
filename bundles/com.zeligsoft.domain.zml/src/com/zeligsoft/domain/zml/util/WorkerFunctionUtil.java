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
package com.zeligsoft.domain.zml.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.l10n.Messages;

/**
 * A singleton with a set of utilities for working with worker functions
 * and worker function implementations.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public enum WorkerFunctionUtil {
	INSTANCE;
	
	/**
	 * Given an object that represents a WorkerFunction return the implementations
	 * of it.
	 * 
	 * @param workerFunction
	 * @return
	 */
	public static List<EObject> getWorkerFunctionImpls(EObject workerFunction) {
		List<EObject> result = new ArrayList<EObject>();
		
		if(workerFunction == null) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_getWorkerFunctionImpls_NullException);
		}
		
		if(!ZDLUtil.isZDLConcept(workerFunction, ZMLMMNames.WORKER_FUNCTION)) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_getWorkerFunctionImpls_NotAWorkerFunction);
		}
		
		for(Setting setting : UML2Util.getInverseReferences(workerFunction)) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getBehavior_Specification()) {
				if(ZDLUtil.isZDLConcept(setting.getEObject(), ZMLMMNames.WORKER_FUNCTION_IMPL)) {
					result.add(setting.getEObject());
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Given a WorkerFunction destroy all of the implementations of it.
	 * 
	 * @param workerFunction
	 * 		The worker function to destroy the implementations of.
	 */
	public void destroyWorkerFunctionImpls(EObject workerFunction) {
		if(workerFunction == null) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_destroyWorkerFunctionImpls_NullException);
		}
		
		if(!ZDLUtil.isZDLConcept(workerFunction, ZMLMMNames.WORKER_FUNCTION)) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_destroyWorkerFunctionImpls_NotAWorkerFunctionException);
		}
		
		List<EObject> impls = getWorkerFunctionImpls(workerFunction);
		
		for(EObject next : impls) {
			((Element) next).destroy();
		}
	}
	
	/**
	 * Given a worker function, its original name and a new name for it. Rename
	 * all of its implementations. It will only rename the worker function implementation
	 * if it has kept the default name.
	 * 
	 * @param workerFunction
	 * 		The worker function being renamed which can not be null.
	 * @param oldWorkerFunctionName
	 * 		The original name of the worker function to be renamed.
	 * @param newWorkerFunctionName
	 * 		The new name of the worker function
	 */
	public void renameWorkerFunctionImpls(EObject workerFunction, 
			String oldWorkerFunctionName, 
			String newWorkerFunctionName) {
		List<EObject> impls = getWorkerFunctionImpls(workerFunction);
		
		for(EObject next : impls) {
			String currentName = (String) ZDLUtil.getValue(next, 
					ZMLMMNames.WORKER_FUNCTION_IMPL, 
					ZMLMMNames.NAMED_ELEMENT__NAME);
			String oldDefaultName = workerFunctionImplDefaultName(oldWorkerFunctionName);
			
			if(currentName.equals(oldDefaultName)) {
				String newDefaultName = workerFunctionImplDefaultName(newWorkerFunctionName);
				ZDLUtil.setValue(next, 
						ZMLMMNames.WORKER_FUNCTION_IMPL, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						newDefaultName);
			}
			
		}
	}
	
	/**
	 *  Build a default name for a worker function implementation given a WorkerFunction.
	 *  
	 *  Preconditions : {@code workerFunction is not null} and {@code workerFunction is a WorkerFunction}
	 *  
	 * @param workerFunction
	 * 		The worker function to create the default name of implementation for.
	 * 
	 * @return
	 * 		The default name of a worker functions implementation.
	 */
	public String workerFunctionImplDefaultName(EObject workerFunction) {
		String result = ""; //$NON-NLS-1$
		
		if(workerFunction == null) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_workerFunctionImplDefaultName_NullException);
		}
		
		if(!ZDLUtil.isZDLConcept(workerFunction, ZMLMMNames.WORKER_FUNCTION)){
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_workerFunctionImplDefaultName_NotAWorkerFunctionException);
		}
		
		String workerFunctionName = (String) ZDLUtil.getValue(workerFunction, 
				ZMLMMNames.WORKER_FUNCTION, 
				ZMLMMNames.NAMED_ELEMENT__NAME);
		
		result = workerFunctionImplDefaultName(workerFunctionName);
		
		return result;
	}
	
	/**
	 * Build a default name for a worker function implementation
	 * 
	 * Preconditions : {@code workerFunctionName is not null or empty}
	 * 
	 * @param workerFunctionName
	 * 		The name to use in creating the default name
	 * @return
	 * 		The default name of a worker function implementation
	 */
	public String workerFunctionImplDefaultName(String workerFunctionName) {
		return workerFunctionName + "Impl"; //$NON-NLS-1$
	}
	
	/**
	 * Check to see whether a worker function has any implementations.
	 * 
	 * Precondition: {@code workerFunction != null} and {@code workerFunction is a WorkerFunction}
	 * 
	 * @param workerFunction
	 * 		The worker function to check.
	 * @return
	 * 		True if the worker function has at least one implementation and false if it has no
	 * 		implementations.
	 */
	public boolean hasWorkerFunctionImplementation(EObject workerFunction) {
		boolean result = false;
		
		List<EObject> impls = getWorkerFunctionImpls(workerFunction);
		
		result = !impls.isEmpty();
		
		return result;
	}

	/**
	 * A function to set the code for a specific programming language on a worker function
	 * implementation. 
	 * 
	 * 
	 * @param structuralRealization
	 * 		is not null and is a ZMLMM::ZML_Component::StructuralRealization
	 * @param workerFunction
	 * 		is not null and is a ZMLMM::ZML_Component::WorkerFunction
	 * @param language
	 * 		is a not empty string representing the programming language
	 * @param codeBlock
	 * 		the possible empty block of code to associate with the language for the
	 * 		worker function
	 * @return
	 * 		Whether any code was changed.
	 */
	public static boolean setWorkerFunctionImplementationCode(EObject structuralRealization,
			EObject workerFunction, String language, String codeBlock) {
		if(structuralRealization == null || !ZDLUtil.isZDLConcept(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION)) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_setWorkerFunctionImplementationCode_NotAStructuralRealizationException);
		}
		
		if(workerFunction == null || !ZDLUtil.isZDLConcept(workerFunction, ZMLMMNames.WORKER_FUNCTION)) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_setWorkerFunctionImplementationCode_NotAWorkerFunctionException);
		}
		
		if(UML2Util.isEmpty(language)) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_setWorkerFunctionImplementationCode_EmptyLanguageException);
		}
		
		final List<EObject> implementations = WorkerFunctionUtil.getWorkerFunctionImpls(workerFunction);
		
		for(EObject impl : implementations) {
			final Object languagesRaw = ZDLUtil.getValue(impl, ZMLMMNames.WORKER_FUNCTION_IMPL, ZMLMMNames.WORKER_FUNCTION_IMPL__LANGUAGE);
			final Object bodyRaw = ZDLUtil.getValue(impl, ZMLMMNames.WORKER_FUNCTION_IMPL, ZMLMMNames.WORKER_FUNCTION_IMPL__BODY);
			
			if(languagesRaw != null && languagesRaw instanceof List<?>
					&& bodyRaw != null && bodyRaw instanceof List<?>) {
				@SuppressWarnings("unchecked")
				final List<String> codeBlockLanguages = (List<String>) languagesRaw;
				@SuppressWarnings("unchecked")
				final List<String> bodies = (List<String>) bodyRaw;
				
				if(codeBlockLanguages.size() != bodies.size()) {
					throw new IllegalArgumentException(Messages.WorkerFunctionUtil_setWorkerFunctionImplementationCode_LanguageAndBodySizeMismatch);
				}
				
				final int languageIdx = codeBlockLanguages.indexOf(language);
				if(languageIdx >= 0) {
					if( codeBlock.equals(bodies.get(languageIdx)) == false ) {
						bodies.set(languageIdx, codeBlock);
						return true;
					} else {
						return false;
					}
				} else {
					codeBlockLanguages.add(language);
					bodies.add(codeBlock);
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * A function to get the code for a specific programming language on a worker function
	 * implementation. 
	 * 
	 * 
	 * @param structuralRealization
	 * 		is not null and is a ZMLMM::ZML_Component::StructuralRealization
	 * @param workerFunction
	 * 		is not null and is a ZMLMM::ZML_Component::WorkerFunction
	 * @param language
	 * 		is a not empty string representing the programming language
	 * @return
	 */
	public static String getWorkerFunctionImplementationCode(EObject structuralRealization,
			EObject workerFunction, String language) {
		String result = ""; //$NON-NLS-1$
		if(structuralRealization == null || !ZDLUtil.isZDLConcept(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION)) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_getWorkerFunctionImplementationCode_NotAStructuralRealizationException);
		}
		
		if(workerFunction == null || !ZDLUtil.isZDLConcept(workerFunction, ZMLMMNames.WORKER_FUNCTION)) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_getWorkerFunctionImplementationCode_NotAWorkerFunctionException);
		}
		
		if(UML2Util.isEmpty(language)) {
			throw new IllegalArgumentException(Messages.WorkerFunctionUtil_getWorkerFunctionImplementationCode_EmptyLanguageParameterException);
		}
		
		final List<EObject> implementations = WorkerFunctionUtil.getWorkerFunctionImpls(workerFunction);
		
		for(EObject impl : implementations) {
			final Object languagesRaw = ZDLUtil.getValue(impl, ZMLMMNames.WORKER_FUNCTION_IMPL, ZMLMMNames.WORKER_FUNCTION_IMPL__LANGUAGE);
			final Object bodyRaw = ZDLUtil.getValue(impl, ZMLMMNames.WORKER_FUNCTION_IMPL, ZMLMMNames.WORKER_FUNCTION_IMPL__BODY);
			
			if(languagesRaw != null && languagesRaw instanceof List<?>
					&& bodyRaw != null && bodyRaw instanceof List<?>) {
				@SuppressWarnings("unchecked")
				final List<String> codeBlockLanguages = (List<String>) languagesRaw;
				@SuppressWarnings("unchecked")
				final List<String> bodies = (List<String>) bodyRaw;
				
				if(codeBlockLanguages.size() != bodies.size()) {
					throw new IllegalArgumentException(Messages.WorkerFunctionUtil_getWorkerFunctionImplementationCode_LanguageAndBodySizeMismatch);
				}
				
				final int languageIdx = codeBlockLanguages.indexOf(language);
				
				if(languageIdx >= 0) {
					result = bodies.get(languageIdx);
				}
			}
		}
		return result;
	}
}
