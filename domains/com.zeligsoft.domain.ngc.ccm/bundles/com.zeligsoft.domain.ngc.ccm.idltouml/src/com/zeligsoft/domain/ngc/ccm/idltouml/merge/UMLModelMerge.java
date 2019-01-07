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
package com.zeligsoft.domain.ngc.ccm.idltouml.merge;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Package;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.util.ModelMerger;
import com.zeligsoft.base.workflow.RSMWriter;
import com.zeligsoft.domain.ngc.ccm.idltouml.l10n.Messages;

/**
 * @author eclipse
 * 
 */
@SuppressWarnings("nls")
public class UMLModelMerge extends RSMWriter {

	private String bundleId;

	private String mergerClassName;

	public UMLModelMerge() {
		super();
	}

	/**
	 * 
	 * 
	 */
	@Override
	public void checkConfiguration(Issues issues) {

		super.checkConfiguration(issues);

		checkRequiredConfigProperty("merger", mergerClassName, issues); //$NON-NLS-1$
		checkRequiredConfigProperty("bundle", bundleId, issues); //$NON-NLS-1$
		checkRequiredConfigProperty("uri", uri, issues); //$NON-NLS-1$

		return;
	}

	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		if (issues.getErrors().length > 0) {
			return;
		}

		try {
			mergeModels(ctx, monitor, issues);
		} catch (IOException e) {
			issues.addError(this, Messages.UMLModelMerge_Error_Merging, e);
		}
	}

	protected void mergeModels(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) throws IOException {
		final org.eclipse.uml2.uml.Package sourceModel = getSourceModel(ctx);
		
		// this will use the correct resource implementation because RSM
		// registers it
		final Resource res = targetModelResource(sourceModel);

		if (res.getContents().isEmpty()) {
			res.getContents().add(sourceModel);
			
			// take care of the stereotypes applied to UML elements
			addStereotypeApplications(res, sourceModel);
			res.save(Collections.EMPTY_MAP);
		} else {
			final org.eclipse.uml2.uml.Package targetModel = (org.eclipse.uml2.uml.Package) res
					.getContents().get(0);

			if (targetModel == null) {
				issues
						.addError(String
								.format(
										Messages.UMLModelMerge_Error_ResourceHasNoPackage,
										getUri()));
				return;
			}
			
			ModelMerger<EObject, ?> merger = getMergerHelper();
					 
			merger.merge(sourceModel, targetModel);
			 
			// take care of the stereotypes applied to UML elements
			addStereotypeApplications(res, targetModel);
			res.save(Collections.EMPTY_MAP);
			sourceModel.destroy();
		}
	}

	private org.eclipse.uml2.uml.Package getSourceModel(WorkflowContext ctx) {
		org.eclipse.uml2.uml.Package newModel = (org.eclipse.uml2.uml.Package) ctx
				.get(getModelSlot());
		return newModel;
	}

	private Resource targetModelResource(org.eclipse.uml2.uml.Package newModel) {
		URI targetModelURI = getURI(newModel);
		Resource res;
		if (URIConverter.INSTANCE
				.exists(targetModelURI, Collections.emptyMap())) {
			res = getResourceSet().getResource(targetModelURI, true);
		} else {
			res = getResourceSet().createResource(targetModelURI);
		}
		return res;
	}

	public ModelMerger<EObject, ?> getMergerHelper() {
		Bundle bundle = Platform.getBundle(bundleId);

		if (bundle == null) {
			// was unable to load the bundle
			throw new IllegalArgumentException(String.format(
					Messages.UMLModelMerge_Error_CantFindBundle, bundleId));
		}

		try {
			@SuppressWarnings("unchecked")
			Class<ModelMerger<EObject, ?>> mergerClass = (Class<ModelMerger<EObject, ?>>) bundle
					.loadClass(mergerClassName);

			return mergerClass.newInstance();

		} catch (ClassNotFoundException e) {
			// results in the action being disabled
			throw new IllegalArgumentException(
					String.format(Messages.UMLModelMerge_Error_CantFindClass,
							mergerClassName, bundleId), e);
		} catch (IllegalAccessException e) {
			// results in the action being disabled with a log message
			throw new RuntimeException(String.format(
					Messages.UMLModelMerge_Error_CantAccessClass, mergerClassName,
					bundleId), e);
		} catch (InstantiationException e) {
			// results in the action being disabled with a log message
			throw new RuntimeException(String.format(
					Messages.UMLModelMerge_Error_CantInstantiateClass, mergerClassName,
					bundleId), e);
		}
	}

	public void setBundle(String bundleId) {
		this.bundleId = bundleId;
	}

	public String getBundle() {
		return bundleId;
	}

	public String getMerger() {
		return mergerClassName;
	}

	public void setMerger(String mergerClass) {
		this.mergerClassName = mergerClass;
	}

	private URI getURI(Package pkg) {
		return URI.createFileURI(getUri() + resourceName(pkg));
	}

	private String resourceName(Package pkg) {
		return pkg.getName() + ".emx";
	}
}
