/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST) - Minor revision on tracking changes
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import com.google.inject.Injector;

public class AlfMapper {

	static final public String QVT_PATH =
			"org.eclipse.papyrus.uml.alf.to.fuml/transformation/Alf2UML.qvto";

	protected TransformationExecutor executor;
	protected ExecutionContextImpl context;
	protected Injector injector;
	protected ResourceSet resourceSet;
	protected Resource resource;
	protected Profile standardProfile;
	protected Profile actionLanguageProfile;

	protected final static URI ALF_MODEL_URI = URI.createFileURI("Alf_Model.tmp");

	public AlfMapper() {
		String base = CommonPlugin.getPlugin() == null ? "../" : "platform:/plugin/";
		this.executor = new TransformationExecutor(
				URIConverter.INSTANCE.normalize(URI.createURI(base + QVT_PATH)));

		this.context = new ExecutionContextImpl();
		this.context.setConfigProperty("keepModeling", true);
		this.context.setLog(new WriterLog(new OutputStreamWriter(System.err)));

		this.injector = new AlfStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public AlfMapper(ResourceSet resourceSet) {
		this();
		this.setResourceSet(resourceSet);
	}

	public AlfMapper(Profile standardProfile, Profile actionLanguageProfile) {
		this();
		this.setStandardProfile(standardProfile);
		this.setActionLanguageProfile(actionLanguageProfile);
	}

	public AlfMapper(ResourceSet resourceSet, Profile standardProfile, Profile actionLanguageProfile) {
		this(standardProfile, actionLanguageProfile);
		this.setResourceSet(resourceSet);
	}

	public Injector getInjector() {
		return this.injector;
	}

	public void setStandardProfile(Profile profile) {
		this.standardProfile = profile;
	}

	public void setActionLanguageProfile(Profile profile) {
		this.actionLanguageProfile = profile;
	}

	public Profile getActionLanguageProfile() {
		return this.actionLanguageProfile;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public ResourceSet getResourceSet() {
		if (this.resourceSet == null) {
			this.resourceSet = new ResourceSetImpl();
			UMLResourcesUtil.init(this.resourceSet);
		}
		return this.resourceSet;
	}

	public Resource getResource() {
		if (this.resource == null) {
			ResourceSet resourceSet = this.getResourceSet();

			// NOTE: A file URI is used here so Papyrus considers this resource
			// to be writable. A non-UML extension is used so that Papyrus
			// doesn't ask the user whether to make it writable (and it must
			// have an extension to avoid a null pointer exception).
			this.resource = resourceSet.getResource(ALF_MODEL_URI, false);
			if (this.resource == null) {
				this.resource = resourceSet.createResource(ALF_MODEL_URI,
						UMLResource.UML_CONTENT_TYPE_IDENTIFIER);
			}
			// If there are listeners registered on Papyrus editing domain, they will not be notified about changes
			// which occurred in this particular resource
			this.resource.setTrackingModification(false);
			this.resource.eAdapters().clear();
		}
		return this.resource;
	}

	protected static void applyProfile(Package model, Profile profile) {
		if (profile != null) {
			model.applyProfile(profile);
		}
	}

	protected void setModel(Package model) {
		List<EObject> contents = this.getResource().getContents();
		contents.clear();
		contents.add(model);
	}

	public List<EObject> map(List<EObject> alf) throws MappingError {
		final Package model = UMLFactory.eINSTANCE.createModel();
		model.setName("Model");
		applyProfile(model, this.standardProfile);
		applyProfile(model, this.actionLanguageProfile);
		this.setModel(model);

		ModelExtent input = new BasicModelExtent(alf);
		ModelExtent output = new BasicModelExtent(Collections.singletonList(model));

		ExecutionDiagnostic diagnostic =
				this.executor.execute(this.context, input, output);

		if (diagnostic.getSeverity() == Diagnostic.OK) {
			resource.getContents().addAll(output.getContents());
			return output.getContents();
		} else {
			throw new MappingError(diagnostic);
		}
	}

	public void map(NamedElement contextElement, List<EObject> alf) throws MappingError {
		List<EObject> uml = this.map(alf);
		Package model = (Package) uml.get(0);

		Package contextModel = contextElement.getModel();
		for (Profile profile : model.getAppliedProfiles()) {
			if (!contextModel.isProfileApplied(profile)) {
				contextModel.applyProfile(profile);
			}
		}

		ModelMerge merge = new ModelMerge();
		List<PackageableElement> elements =
				new BasicEList<PackageableElement>(model.getPackagedElements());
		for (PackageableElement member : elements) {
			String name = member.getName();
			if (member instanceof Namespace && name != null && (name.length() < 3 || !name.substring(0, 2).equals("$$"))) {
				merge.update(contextElement, member);
				elements.remove(member);
				break;
			}
		}

		merge.updateAll(contextModel.getPackagedElements(), elements);
		merge.applyReplacements(contextModel);
	}

	protected void clean() {
		if (this.resource != null) {
			try {
				AlfMapper.this.resource.delete(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
