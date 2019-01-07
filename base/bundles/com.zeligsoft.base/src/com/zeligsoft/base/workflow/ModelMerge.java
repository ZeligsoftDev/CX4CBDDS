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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.l10n.Messages;
import com.zeligsoft.base.util.ModelMerger;

/**
 * The component that is called by an oAW workflow to merge an intermediary
 * source model with an existing target model.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ModelMerge extends AbstractEMFComponentWithResourceSet {

	/**
	 * The concrete model-merger class that we will use.
	 */
	private ModelMerger<EObject, ?> merger;
	
	/**
	 * The string identifier for the slot that holds the intermediary models.
	 */
	private String sourceSlot;

	/**
	 * The string identifier for the slot that holds the destination URIs of
	 * the merged models.
	 */
	private String targetSlot;
	
	/**
	 * The resources in which to save the target models.
	 */
	private List<Resource> targetResources;

	/**
	 * The string identifier for the slot to place the resulting models into.
	 */
	private String mergeResultSlot;

	/**
	 * Default constructor
	 */
	public ModelMerge() {
		super();
	}

	/**
	 * The source slot and the target resource properties can not be
	 * null or an empty string.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#checkConfiguration(Issues)
	 */
	@Override
	public void checkConfiguration(Issues issues) {

		super.checkConfiguration(issues);
		
		checkRequiredConfigProperty("merger", merger, issues); //$NON-NLS-1$
		checkRequiredConfigProperty("sourceSlot", sourceSlot, issues); //$NON-NLS-1$
		checkRequiredConfigProperty("targetSlot", targetSlot, issues); //$NON-NLS-1$
		checkRequiredConfigProperty("mergeResultSlot", mergeResultSlot, issues); //$NON-NLS-1$

		return;
	}

	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		Object sourceSlotValue = ctx.get(sourceSlot);
		boolean isListValue = sourceSlotValue instanceof List<?>;
		
		List<EObject> sourceModels = asList(sourceSlotValue, EObject.class);
		List<URI> targetURIs = asList(ctx.get(targetSlot), URI.class);
		List<EObject> targetModels = getTargetEObjects(targetURIs);

		if (sourceModels.isEmpty()) {
			// this is a normal condition, for example in generating a domain
			// when there are no libraries to merge
			return;
		}
		
		Iterator<EObject> sources = sourceModels.iterator();
		ListIterator<EObject> targets = targetModels.listIterator();
		Iterator<Resource> resources = targetResources.iterator();
		
		// first, handle the trivial merges where the target model doesn't yet
		// exist.  We do this by simply putting the source model into the target
		// slot
		while (sources.hasNext() && targets.hasNext()) {
			EObject sourceModel = sources.next();
			EObject targetModel = targets.next();
			Resource targetResource = resources.next();
			
			if (targetModel == null) {
				// trivial merge:  simply save the source in the target's place
				targetModel = sourceModel;
				targets.set(targetModel);
				targetResource.getContents().add(targetModel);
			}
		}
		
		// now, merge them all together to ensure that cross-references between
		// the models are maintained
		merger.merge(sourceModels, targetModels);
		
		// save all target resources in a separate phase because all of the
		// merged models must first be put into resources before any can be
		// saved, to avoid dangling HREF exceptions on cross-references
		targets = targetModels.listIterator();
		for (Resource next : targetResources) {
			EObject targetModel = targets.next();
			
			try {
				if (targetModel instanceof Element) {
					// ensure that we persist stereotype applications, too (merge may
					// have added new stereotypes)
					RSMWriter.addStereotypeApplications(next,
						(Element) targetModel);
				}
				
				next.save(new java.util.HashMap<Object, Object>());
			} catch (IOException e) {
				issues.addError(this, NLS.bind(Messages.ModelMerge_mergeSaveFailed,
					e.getLocalizedMessage()));
			}
		}
		
		if (!isListValue) {
			// output is a scalar if the input was a scalar
			ctx.set(getMergeResultSlot(), targetModels.get(0));
		} else {
			ctx.set(getMergeResultSlot(), targetModels);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> List<T> asList(Object value, Class<T> elementType) {
		List<T> result;
		
		if (value instanceof List<?>) {
			List<?> valueList = (List<?>) value;
			
			if (!valueList.isEmpty() && elementType.isInstance(valueList.get(0))) {
				result = (List<T>) valueList;
			} else {
				result = Collections.emptyList();
			}
		} else if (elementType.isInstance(value)) {
			result = Collections.singletonList((T) value);
		} else {
			result = Collections.emptyList();
		}
		
		return result;
	}
	
	/**
	 * Obtains my model merger class name.
	 * 
	 * @return my model merger class name
	 */
	public String getMerger() {
		return (merger == null)? null : merger.getClass().getName();
	}
	
	/**
	 * Sets my model merger class name.
	 * 
	 * @param className my model merger class name
	 */
	public void setMerger(String className) {
		if (className == null) {
			merger = null;
		} else {
			try {
				@SuppressWarnings("unchecked")
				Class<ModelMerger<EObject, ?>> mergerClass = (Class<ModelMerger<EObject, ?>>) Class
					.forName(className);
				merger = mergerClass.newInstance();
			} catch (Exception e) {
				// TODO: Log the problem
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Getter for the sourceSlot property of the workflow component
	 * 
	 * @return the value of the sourceSlot property
	 */
	public String getSourceSlot() {
		return sourceSlot;
	}

	/**
	 * Setter for the sourceSlot property of the workflow component
	 * 
	 * @param sourceSlot
	 *            the new value for the sourceSlot property
	 */
	public void setSourceSlot(String sourceSlot) {
		this.sourceSlot = sourceSlot;
	}

	/**
	 * Getter for the targetSlot property of the workflow component.
	 * 
	 * @return the value of the targetSlot property
	 */
	public String getTargetSlot() {
		return targetSlot;
	}

	/**
	 * Setter for the targetSlot property of the workflow component
	 * 
	 * @param targetSlot
	 *            the new value of for the targetSlot property
	 */
	public void setTargetSlot(String targetSlot) {
		this.targetSlot = targetSlot;
	}

	/**
	 * Helper method to retrieve the root elements of the target models by
	 * loading the resources pointed to by 'target'.
	 * 
	 * @param targetURIs
	 *            the URIs of the resources into which to merge the source
	 *            models
	 * @return the root objects in the target resources. Some elements may be
	 *         <code>null</code> to indicate that the target model does not
	 *         yet exist
	 */
	protected List<EObject> getTargetEObjects(List<URI> targetURIs) {
		// create resource set and resource
		ResourceSet resourceSet = getResourceSet();

		targetResources = new java.util.ArrayList<Resource>(targetURIs.size());
		List<EObject> result = new java.util.ArrayList<EObject>(targetURIs.size());
		
		for (URI uri : targetURIs) {
			Resource res = resourceSet.getResource(uri, false);
			
			if (res == null) {
				res = resourceSet.createResource(uri);
			}
			
			if (!res.isLoaded()) {
				try {
					res.load(new HashMap<Object,Object>());
				} catch (IOException e) {
					// this is normal:  resource does not exist, so we are creating it
				}
			}
	
			targetResources.add(res);
			
			if (res.getContents().isEmpty()) {
				result.add(null);
			} else {
				result.add(res.getContents().get(0));
			}
		}
		
		return result;
	}

	/**
	 * Getter for the mergeResultSlot property of the workflow component
	 * 
	 * @return the value of the mergeResultSlot property
	 */
	public final String getMergeResultSlot() {
		return mergeResultSlot;
	}

	/**
	 * Setter for the mergeResultSlot property of the workflow component
	 * 
	 * @param mergeResultSlot
	 *            the new value of for the mergeResultSlot property
	 */
	public final void setMergeResultSlot(String mergeResultSlot) {
		this.mergeResultSlot = mergeResultSlot;
	}

}
