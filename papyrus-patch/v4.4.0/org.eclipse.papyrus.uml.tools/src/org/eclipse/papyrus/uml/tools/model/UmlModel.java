/*****************************************************************************
 * Copyright (c) 2011, 2016 LIFL, CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   LIFL - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.model;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.EMFLogicalModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * A UML model.
 *
 * @author cedric dumoulin
 *
 */
public class UmlModel extends EMFLogicalModel implements IModel {

	/**
	 * File extension used for DI.
	 */
	public static final String UML_FILE_EXTENSION = "uml"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.core.resource.uml.UmlModel"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#createModel(org.eclipse.core.runtime.IPath)
	 *
	 * @param fullPath
	 */
	@Override
	public void createModel(IPath fullPath) {

		// Compute model URI
		resourceURI = getPlatformURI(fullPath.addFileExtension(UML_FILE_EXTENSION));

		// Create Resource of appropriate type
		resource = getResourceSet().createResource(resourceURI, getContentType());
	}

	@Override
	public void init(ModelSet modelManager) {
		super.init(modelManager);
		// UMLUtil.init is not thread-safe since it may write in the EMF Metadata
		synchronized (UMLUtil.class) {
			UMLUtil.init(modelManager);
		}
	}

	/**
	 *
	 * @return
	 */
	protected String getContentType() {
		return UMLPackage.eCONTENT_TYPE;
	}

	/**
	 * Get the file extension used for this model.
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return UML_FILE_EXTENSION;
	}

	/**
	 * Get the identifier used to register this model.
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * Lookup the root of the model. Throw an exception if not found.
	 *
	 * @return
	 */
	public EObject lookupRoot() throws NotFoundException {
		if (resource == null || resource.getContents().isEmpty()) {
			// The root doesn't exist.
			throw new NotFoundException("No root defined in the model");
		}

		return resource.getContents().get(0);
	}

	/**
	 * Initialize the model if it is empty. Initialize it with a default uml.Model
	 */
	public void initializeEmptyModel() {

		// Skip if the model is not empty
		if (!resource.getContents().isEmpty()) {
			return;
		}

		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("model");
		resource.getContents().add(model);
	}

	@Override
	public void unload() {
		for (Resource resource : resources) {
			if (resource != null) {
				CacheAdapter.getInstance().clear(resource);
			}
		}

		super.unload();
	}

	/**
	 * Only UML {@link Element}s are semantic roots, not stereotype applications.
	 */
	@Override
	protected boolean isRootElement(EObject object) {
		return super.isRootElement(object) && (object instanceof Element);
	}

	@Override
	protected boolean isSupportedRoot(EObject object) {
		return UMLPackage.Literals.PACKAGE.isInstance(object);
	}
}
