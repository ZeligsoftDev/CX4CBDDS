/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Jeremie Tatibouet
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.NamespaceDefinition;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.impl.ModelNamespaceImpl;
import org.eclipse.uml2.uml.Namespace;

/**
 * Facade to enable the validator to get the right validation context (i.e., a ModelNamespace)
 * for a given ALF model  
 */
public class ModelNamespaceFacade {

	/**
	 * The facade is a singleton
	 */
	private static ModelNamespaceFacade INSTANCE;

	/**
	 * It owns a registry managing the correspondance between resource URI and ModelNamespace
	 */
	protected AlfValidationContextRegistry registry;

	private ModelNamespaceFacade() {
		this.registry = new AlfValidationContextRegistry();
	}

	/**
	 * Provide access onto the ModelNamespaceFacade
	 * 
	 * @return INSTANCE
	 * 		   the instance of the facade
	 */
	public static ModelNamespaceFacade getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ModelNamespaceFacade();
		}
		return INSTANCE;
	}

	/**
	 * Provide the model namespace that need to be used for a given model element 
	 * 
	 * @param element
	 * 		  an ALF model element
	 * 
	 * @return namespace
	 * 		   the model namespace in which the validation occurs
	 */
	public ModelNamespaceImpl getContext(SyntaxElement element) {
		if (element.eResource() == null) {
			return this.registry.getCurrentlyUsedValidationContext();
		}
		ModelNamespaceImpl namespace = this.registry.getValidationContext(element.eResource().getURI());
		if (namespace == null) {
			namespace = this.registry.createEmptyValidationContext(element.eResource().getURI());
		}
		return namespace;
	}

	public NamespaceDefinition modelNamespaceFor(NamespaceDefinition namespace) {
		ModelNamespaceImpl modelNamespace = this.getContext(namespace);
		modelNamespace.setModelUnit(namespace);
		return modelNamespace;
	}

	public EList<ElementReference> resolveInModelScope(QualifiedName qualifiedName) {
		return this.getContext(qualifiedName).resolvePathName(qualifiedName.getPathName());
	}
	
	/**
	 * Create a relation between a specific resource and a UML namespace which is used as a validation context
	 * 
	 * @param validatedResource
	 * 		  the resource containing the ALF model to validate
	 * 
	 * @param validationContext
	 * 		  the namespace used as validation context
	 */
	public ModelNamespaceImpl createValidationContext(Resource validatedResource, Namespace validationContext){
		return this.registry.createValidationContext(validatedResource.getURI(), validationContext);
	}
	
	/**
	 * Create an empty validation context (i.e., a model namespace) for a given resource. The validation context is an
	 * empty UML model having an import on ALF and the standard UML profile applied
	 * 
	 * @param validatedResource
	 * 		  the resource containing the ALF model to validate
	 * 
	 * @return the model namespace used as validation context
	 */
	public ModelNamespaceImpl createEmptyValidationContext(Resource validatedResource){
		return this.registry.createEmptyValidationContext(validatedResource.getURI());
	}
	
	/**
	 * Delete the registered validation context used for the given resource
	 * 
	 * @param validatedResource
	 * 		  the resource for the validation context is deleted
	 * 
	 * @return true if the validation context was deleted false otherwise
	 */
	public boolean deleteValidationContext(Resource validatedResource){
		return this.registry.deleteValidationContext(validatedResource.getURI());
	}
}
