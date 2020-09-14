/*****************************************************************************
 * Copyright (c) Zeligsoft(2009) Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		Young-Soo Roh - Initial API and implementation
 *
 *****************************************************************************/
package com.zeligsoft.domain.cbdds.architecture.commands;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.architecture.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.DDS4CCMModel;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ModelTypeEnum;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil;

/**
 * The Class CreateSysMLModelCommand.
 */
public class CreateATCDModelCommand implements IModelCreationCommand {

	@Override
	public void createModel(final ModelSet modelSet) {
		runAsTransaction(modelSet);
	}

	protected void runAsTransaction(final ModelSet modelSet) {
		// Get the uml element to which the newly created diagram will be
		// attached.
		// Create the diagram
		final Resource modelResource = UmlUtils.getUmlResource(modelSet);
		TransactionalEditingDomain editingDomain = modelSet.getTransactionalEditingDomain();

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, "Initialize model",
				Collections.EMPTY_LIST) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				EObject model = getRootElement(modelResource);
				attachModelToResource(model, modelResource);

				initializeModel(model);
				return CommandResult.newOKCommandResult();

			}
		};
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
	}

	protected EObject getRootElement(Resource modelResource) {
		EObject rootElement = null;
		if (modelResource != null && modelResource.getContents() != null && modelResource.getContents().size() > 0) {
			Object root = modelResource.getContents().get(0);
			if (root instanceof EObject) {
				rootElement = (EObject) root;
			}
		} else {
			rootElement = createRootElement();
		}
		return rootElement;
	}

	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	protected void attachModelToResource(EObject root, Resource resource) {
		resource.getContents().add(root);
	}

	protected void initializeModel(EObject owner) {
		((org.eclipse.uml2.uml.Package) owner).setName(getModelName());

		org.eclipse.uml2.uml.Package packageOwner = (org.eclipse.uml2.uml.Package) owner;

		Profile standardUMLProfile = (Profile) PackageUtil.loadPackage(URI.createURI(UMLResource.STANDARD_PROFILE_URI),
				owner.eResource().getResourceSet());
		if (standardUMLProfile != null) {
			PackageUtil.applyProfile(packageOwner, standardUMLProfile, true);
		}

		org.eclipse.uml2.uml.Package umlPrimitiveTypes = PackageUtil.loadPackage(
				URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), owner.eResource().getResourceSet());
		if (umlPrimitiveTypes != null) {
			PackageImport pi = UMLFactory.eINSTANCE.createPackageImport();
			pi.setImportedPackage(umlPrimitiveTypes);
			packageOwner.getPackageImports().add(pi);
		}

		org.eclipse.uml2.uml.Package idlPrimitiveTypes = PackageUtil.loadPackage(
				URI.createURI("pathmap://DDS4CCM_LIBRARIES/IDLPrimitives.uml"), owner.eResource().getResourceSet());
		if (idlPrimitiveTypes != null) {
			PackageImport pi = UMLFactory.eINSTANCE.createPackageImport();
			pi.setImportedPackage(idlPrimitiveTypes);
			packageOwner.getPackageImports().add(pi);
		}
		
		// Retrieve PO SysML profile and apply with Sub-profile
		Profile profile = (Profile) PackageUtil.loadPackage(URI.createURI("pathmap://DDS4CCM_PROFILES/dds4ccm.profile.uml"),
				owner.eResource().getResourceSet());
		if (profile != null) {
			Package model = (org.eclipse.uml2.uml.Package) owner;
			PackageUtil.applyProfile(model, profile, true);
			ZDLUtil.addZDLConcept(model, DDS4CCMNames.DDS4_CCMMODEL);
			DDS4CCMModel contextModel = ZDLFactoryRegistry.INSTANCE.create(model, DDS4CCMModel.class);
			contextModel.setModelType(ModelTypeEnum.ATCD);
			try {
				DDS4CCMMigrationUtil.addMigrationAnnotation((Model)model, DDS4CCMMigrationUtil.CURRENT_VERSION);
			} catch (Exception e) {
				// do nothing
			}
		} else {
			com.zeligsoft.domain.cbdds.architecture.Activator.log.error("Impossible to find CBDDS profile", null);
		}
	}

	/**
	 * Gets the model name.
	 *
	 * @return the model name
	 */
	protected String getModelName() {
		return "ATCDModel";
	}
}
