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
package com.zeligsoft.domain.ngc.ccm.idltouml.utils;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.workflow.AbstractEMFComponentWithResourceSet;
import com.zeligsoft.domain.ngc.ccm.idltouml.l10n.Messages;

/**
 * @author Toby McClean (tmcclean)
 *
 */
@SuppressWarnings("nls")
public class CCM2UMLResolveAll extends AbstractEMFComponentWithResourceSet {

	private String targetModelURI;
	
	/**
	 * 
	 */
	public CCM2UMLResolveAll() {
		super();
	}

	/* (non-Javadoc)
	 */
	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		loadResources(ctx, issues);
	}
	
	
	
	/**
	 * Ensures that the resources specified in the <tt>modelSlot</tt> are loaded.
	 * 
	 * @param ctx the current workflow context
	 */
	private void loadResources(WorkflowContext ctx, Issues issues) {
		Object value = ctx.get(getModelSlot());
		if(value instanceof NamedElement) {
			NamedElement element = (NamedElement) value;
			loadResource(URI.createURI(targetModelURI + String.format("%s_impl.emx", element.getName())));
			loadResource(element.eResource().getURI());
			
			NamedElement remapedElement = findNamedElementInResourceSet(element);
			
			if(remapedElement == null) {
				issues.addError(Messages.CCM2UMLResolveAll_Error_CantRemapElement + value);
			} else {
				ctx.set(getModelSlot(), remapedElement);
			}
		}
	}
	
	private NamedElement findNamedElementInResourceSet(NamedElement element) {
		Resource res = getResourceSet().getResource(element.eResource().getURI(), true);
		Collection<NamedElement> foundElements = UMLUtil.findNamedElements(res, element.getQualifiedName());
		NamedElement result;
		if(foundElements.isEmpty()) {
			result = null;
		} else {
			result = (NamedElement) foundElements.toArray()[0];
		}
		
		return result;
	}
	
	/**
	 * Given a URI or a Resource, ensures that the resource is loaded in the
	 * resource set.
	 * 
	 * @param uriOrResource a {@link URI} or a {@link Resource}
	 */
	private void loadResource(Object uriOrResource) {
		Resource res = null;
		boolean createdResource = false;
		
		if (uriOrResource instanceof URI) {
			URI uri = (URI) uriOrResource;
			res = getResourceSet().getResource(uri, false);
			if (res == null) {
				createdResource = true;
				res = getResourceSet().createResource(uri);
			}
		} else if (uriOrResource instanceof Resource) {
			res = (Resource) uriOrResource;
		}
	
		if ((res != null) && !res.isLoaded()) {
			try {
				res.load(Collections.EMPTY_MAP);
			} catch (Exception e) {
				// resource doesn't exist.  That is OK
				res.unload();
				if (createdResource) {
					getResourceSet().getResources().remove(res);
				}
			}
		}
	}

	public String getTargetModelURI() {
		return targetModelURI;
	}

	public void setTargetModelURI(String targetModelURI) {
		this.targetModelURI = targetModelURI;
	}	

}
