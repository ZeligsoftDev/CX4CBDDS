/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  IJI - Initial implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.uml.extensionpoints.library.IRegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.ModelImpl;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

@SuppressWarnings("restriction")
public class Model extends ModelImpl {

	protected final String ALF_LIBRARY = "Alf Library";

	protected final String FUML_LIBRARY = "FoundationalModelLibrary";

	protected final String STANDARD_PROFILE = UMLResource.PROFILES_PATHMAP + "Standard.profile.uml";

	protected ResourceSet modelStorage;

	protected final String ALF_ROOT_PACKAGE = "Alf";

	public Model() {
		super();
		this.setName("EmptyModel");
		this.modelStorage = new ResourceSetImpl();
		this.loadLibraries();
		this.importLibraries();
		this.applyStandardProfile();
		this.registerTmpModel();
	}

	private void loadLibraries() {
		for (IRegisteredLibrary library : RegisteredLibrary.getRegisteredLibraries()) {
			if (library.getName() != null) {
				if (library.getName().equals(ALF_LIBRARY)) {
					this.modelStorage.getResource(library.getUri(), true);
				} else if (library.getName().equals(FUML_LIBRARY)) {
					this.modelStorage.getResource(library.getUri(), true);
				}
			}
		}
	}

	private void importLibraries() {
		/*
		 * Import ALF. Please note that ALF import fUML therefore it is not required to
		 * programmatically import fUML
		 */
		Collection<NamedElement> matchedElement = UMLUtil.findNamedElements(this.modelStorage, ALF_ROOT_PACKAGE);
		if (!matchedElement.isEmpty()) {
			NamedElement element = (NamedElement) matchedElement.toArray()[0];
			ElementImport elementImport = UMLFactory.eINSTANCE.createElementImport();
			elementImport.setImportedElement((PackageableElement) element);
			elementImport.setVisibility(VisibilityKind.PUBLIC_LITERAL);
			elementImport.setAlias(ALF_ROOT_PACKAGE);
			this.getElementImports().add(elementImport);
		}
	}

	private void applyStandardProfile() {
		Resource resource = this.modelStorage.getResource(URI.createURI(STANDARD_PROFILE), true);
		if (resource.getContents().get(0) instanceof Profile) {
			this.applyProfile((Profile) resource.getContents().get(0));
		}
	}

	private void registerTmpModel() {
		Resource r = this.modelStorage.createResource(URI.createURI("EMPTY_UML_CONTEXT_MODEL.uml"));
		r.getContents().add(this);
		this.modelStorage.getResources().add(r);
	}
	
	public void clean(){
		for(Resource resource : this.modelStorage.getResources()){
			resource.unload();
		}
	}
}
