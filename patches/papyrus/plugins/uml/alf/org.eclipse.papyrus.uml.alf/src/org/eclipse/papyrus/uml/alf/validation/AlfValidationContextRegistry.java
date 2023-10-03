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

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.alf.AlfFactory;
import org.eclipse.papyrus.uml.alf.Model;
import org.eclipse.papyrus.uml.alf.impl.ModelNamespaceImpl;
import org.eclipse.uml2.uml.Namespace;

/**
 * The registry relating URI (of resources containing ALF models) to ModelNamespace which are used
 * as validation contexts
 */
class AlfValidationContextRegistry{

	/**
	 * Relation between URI and ModelNamespace
	 */
	protected HashMap<URI, ModelNamespaceWithState> validationMap;
		
	protected AlfValidationContextRegistry(){
		this.validationMap = new HashMap<URI, ModelNamespaceWithState>();
	}
	
	/**
	 * Provide the currently used ModelNamespace
	 * 
	 * @return namespace
	 * 		   the currently used ModelNamespace
	 */
	public ModelNamespaceImpl getCurrentlyUsedValidationContext(){
		ModelNamespaceImpl namespace = null;
		Iterator<URI> iterator = this.validationMap.keySet().iterator();
		while(namespace == null && iterator.hasNext()){
			URI uri = iterator.next();
			if(this.validationMap.get(uri).used){
				namespace = this.validationMap.get(uri).modelNamespace;
			}
		}
		if(namespace==null){
			namespace = this.createEmptyValidationContext(null);
		}
		return namespace;
	}
	
	/**
	 * Provide the validation context corresponding to the given URI
	 * 
	 * @param uri
	 * 		  the uri of the resource currently validated
	 * 
	 * @return modelNamespace
	 * 		   the validation context
	 */
	public ModelNamespaceImpl getValidationContext(URI uri){
		if(this.validationMap.get(uri)!=null){
			return this.validationMap.get(uri).modelNamespace;
		}
		return null;
	}
	
	/**
	 * Associate the given URI with an empty validation context. Such validation context
	 * is defined by a ModelNamespace associated with an empty UML model. 
	 * 
	 * @param uri
	 * 		  the uri of the resource that will be validated
	 * 
	 * @return namespace
	 * 		   the modelNamespace associated to the uri
	 */
	protected ModelNamespaceImpl createEmptyValidationContext(URI uri){
		ModelNamespaceImpl namespace = null;
		namespace = (ModelNamespaceImpl) AlfFactory.eINSTANCE.createModelNamespace();
		namespace.setContextNamespace(new Model());
		this.add(uri, new ModelNamespaceWithState(namespace, true));
		return namespace;
	}
	
	/**
	 * Add the uri and the modelNamespace into the validation map of the registry
	 * 
	 * @param uri
	 * 		  the uri of a validated resource
	 * 
	 * @param modelNamespace
	 * 		  the modelNamespace associated to uri
	 */
	private void add(URI uri, ModelNamespaceWithState modelNamespace){
		for(URI currentURI : this.validationMap.keySet()){
			this.validationMap.get(currentURI).used = false;;
		}
		this.validationMap.put(uri, modelNamespace);
	}
	
	/**
	 * Associate the given uri to a ModelNamespace.
	 * 
	 * @param uri
	 * 		  the uri of the resource that will be validated
	 * 
	 * @param namespace
	 * 		  the namespace associated to the modelNamespace
	 * 
	 * @return modelNamespace
	 *         the modelNamespace associated to the uri
	 */
	protected ModelNamespaceImpl createValidationContext(URI uri, Namespace namespace){
		ModelNamespaceImpl modelNamespace = null;
		if(uri!=null && namespace!=null){
			modelNamespace = this.validationMap.get(uri)!=null ? this.validationMap.get(uri).modelNamespace : null;
			if(modelNamespace!=null){
				modelNamespace.setContextNamespace(namespace);
			}else{
				modelNamespace = (ModelNamespaceImpl) AlfFactory.eINSTANCE.createModelNamespace();
				modelNamespace.setContextNamespace(namespace);
				this.add(uri, new ModelNamespaceWithState(modelNamespace, true));
			}
		}
		return modelNamespace;
	}
	
	/**
	 * Release the validation context (i.e., the model namespace) corresponding to the URI
	 * 
	 * @param uri
	 *		  the uri for which we have an associated namespace resource
	 * 
	 * @return true if the corresponding model namespace was deleted false otherwise
	 */
	public boolean deleteValidationContext(URI uri){
		ModelNamespaceWithState modelNamespace = this.validationMap.get(uri);
		if(modelNamespace!=null){
			this.validationMap.remove(modelNamespace);
			if(modelNamespace.modelNamespace.getContextNamespace() instanceof Model){
				((Model)modelNamespace.modelNamespace.getContextNamespace()).clean();
			}
			return true;
		}
		return false;
	}
	
	class ModelNamespaceWithState{
		
		public ModelNamespaceImpl modelNamespace;
		
		public boolean used;
		
		protected ModelNamespaceWithState(){
			this.used = false;
		}
		
		protected ModelNamespaceWithState(ModelNamespaceImpl namespace, boolean used){
			this.used = used;
			this.modelNamespace = namespace;
		}
	}
}
