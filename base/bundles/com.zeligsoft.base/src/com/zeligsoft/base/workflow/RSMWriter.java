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
package com.zeligsoft.base.workflow;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.l10n.Messages;

/**
 * A workflow component for saving UML Models and Profiles as RSM resources.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class RSMWriter
		extends AbstractEMFComponentWithResourceSet {

	/**
	 * The property name for my output URI.
	 */
	public static final String URI_PROPERTY = "uri"; //$NON-NLS-1$

	/**
	 * Initializes me.
	 */
	public RSMWriter() {
		super();
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);

		checkRequiredConfigProperty(URI_PROPERTY, getUri(), issues);
	}
	
	/**
	 * I do require my model slot.
	 * 
	 * @return <code>true</code>
	 */
	@Override
	protected boolean requiresModelSlot() {
		return true;
	}

	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		Object model = ctx.get(getModelSlot());
		if (!(model instanceof EObject)) {
			issues.addError(this, Messages.RSMWriter_noModel, model);
			return;
		}

		URI uri = URI.createURI(getUri(), true);

		// this will use the correct resource implementation because RSM
		// registers it
		Resource res = getResourceSet().createResource(uri);

		res.getContents().add((EObject) model);
		
		if (model instanceof Package) {
			// take care of the stereotypes applied to UML elements
			addStereotypeApplications(res, (Package) model);
		}
		
		if (model instanceof Profile) {
			// ensure that the Ecore definition exists
			BasicDiagnostic diagnostics = new BasicDiagnostic();
			((Profile) model).define(new java.util.HashMap<String, String>(),
				diagnostics, new java.util.HashMap<Object, Object>());
		}

		try {
			res.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			issues.addError(this, NLS.bind(Messages.RSMWriter_saveFailed,
				e.getLocalizedMessage()), e);
		}
	}

	/**
	 * Crawls the UML content to get applied stereotypes and add them to the
	 * resource.
	 * 
	 * @param resource the resource being written out
	 * @param element the root of UML content to iterate
	 */
	protected static void addStereotypeApplications(Resource resource, Element element) {
		EList<EObject> contents = resource.getContents();

		for (TreeIterator<?> iter = EcoreUtil.getAllContents(Collections
			.singleton(element)); iter.hasNext();) {

			Object next = iter.next();

			if (next instanceof Element) {
				contents.addAll(((Element) next).getStereotypeApplications());
			} else {
				// assume that non-elements don't contain elements
				iter.prune();
			}
		}
	}
}
