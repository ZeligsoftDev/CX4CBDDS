/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl2zdlgen.ui.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.util.ZeligsoftURIConverter;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.ddk.zdl.util.PathmapUtil;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory;
import com.zeligsoft.ddk.zdl2zdlgen.ZDLGenModelRegistry;
import com.zeligsoft.ddk.zdl2zdlgen.ui.operations.GenerateOperation;
import com.zeligsoft.ddk.zdl2zdlgen.util.DomainModelWorkspaceRegistry;
import com.zeligsoft.ddk.zdl2zdlgen.util.ZDLGenModelWorkspaceRegistry;

/**
 * A controller for the ZDLGen importer wizard, which manages the loading of
 * input ZDL models and selection of referenced and local ZDLGens models.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLImporter {

	private static final String WORKFLOW_RESOURCE = "workflows/zdl2zdlgenWorkflow.oaw"; //$NON-NLS-1$

	private ListenerList listeners = new ListenerList(ListenerList.IDENTITY);

	private ResourceSet rset;
	private Profile zdlProfile;
	
	private Resource mainResource;

	private Model mainZDL;

	private GenModel genModel = ZDLGenFactory.eINSTANCE.createGenModel();

	private Set<GenDomainModel> availableGenModels = new java.util.HashSet<GenDomainModel>();
	
	/**
	 * Initialize me.
	 */
	public ZDLImporter() {
		rset = new ResourceSetImpl();
		PathmapUtil.enablePathmaps(rset);
		ZeligsoftURIConverter.install(rset);
		
		Resource zdlProfileRes = rset.getResource(ZDLUtil.ZDL_PROFILE_URI, true);
		zdlProfile = (Profile) EcoreUtil.getObjectByType(zdlProfileRes
			.getContents(), UMLPackage.Literals.PROFILE);
	}

	/**
	 * Loads the ZDL model to be imported from the specified URI.
	 * 
	 * @param mainResourceURI the ZDL model URI
	 * 
	 * @throws IOException on failure to load the ZDL resource
	 */
	public void load(URI mainResourceURI) throws IOException {
		mainResource = rset.getResource(mainResourceURI, true);

		if ((mainResource != null) && mainResource.isLoaded()) {
			mainZDL = (Model) EcoreUtil.getObjectByType(mainResource
				.getContents(), UMLPackage.Literals.MODEL);
		} else {
			mainZDL = null;
			if (!mainResource.getErrors().isEmpty()) {
				Resource.Diagnostic error = mainResource.getErrors().get(0);
				throw new IOException(error.getMessage());
			}
		}

		rebuildGenModel();
	}

	/**
	 * Queries whether I currently have a ZDL model loaded, to be imported.
	 * 
	 * @return whether I have a loaded ZDL model
	 */
	public boolean isLoaded() {
		return (mainResource != null) && mainResource.isLoaded();
	}
	
	/**
	 * Queries the skeletal GenModel that I provide to describe which referenced
	 * ZDL models will be imported and which that already have GenModels will
	 * be referenced.
	 * 
	 * @return my genmodel template
	 */
	public GenModel getGenModel() {
		return genModel;
	}

	/**
	 * Forgets my current ZDL model.
	 */
	public void reset() {
		mainResource = null;

		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}
	}

	/**
	 * Cleans me up when I am no longer needed.
	 */
	public void dispose() {
		genModel = null;
		availableGenModels.clear();
		reset();

		rset.getResources().clear();
		rset.eAdapters().clear();
	}

	/**
	 * Constructs a new genmodel template from a ZDL source model that I have
	 * loaded.  Notifies listeners of the change.
	 */
	private void rebuildGenModel() {
		genModel.getReferencedModels().clear();
		genModel.getOwnedModels().clear();
		availableGenModels.clear();
		
		if (mainZDL != null) {
			GenDomainModel main = ZDLGenFactory.eINSTANCE
				.createGenDomainModel();
			main.setDomainModel(mainZDL);
			main
				.setNsURI("http://www.example.com/schemas/" + mainZDL.getName()); //$NON-NLS-1$

			genModel.getOwnedModels().add(main);
			
			EList<Model> usedModels = genModel.findUsedDomainModels(mainZDL);
			for (Model used : usedModels) {
				GenDomainModel registered = lookupGenDomainModel(used);

				if (registered != null) {
					// by default, reference this ZDL model's generator model
					genModel.getReferencedModels().add(registered);
					availableGenModels.add(registered);
				} else if (isZDLModel(used)){
					// by default, create a generator model for this ZDL model
					GenDomainModel owned = ZDLGenFactory.eINSTANCE.createGenDomainModel();
					owned.setDomainModel(used);
					genModel.getOwnedModels().add(owned);
				}
			}
		}

		fireChangeEvent();
	}
	
	/**
	 * Queries whether a UML model is, in fact, a ZDL model.
	 * 
	 * @param model a UML model
	 * 
	 * @return whether it is a ZDL model
	 */
	private boolean isZDLModel(Model model) {
		return model.getProfileApplication(zdlProfile) != null;
	}
	
	/**
	 * Updates my {@link #getGenModel() genmodel} template to indicate that
	 * the specified GenDomainModel will be referenced or imported.
	 * 
	 * @param zdlgen a domain model decorator
	 * @param referenced whether this domain model should be referenced
	 *     (<code>true</code>) or imported (<code>false</code>)
	 */
	public void setReferenced(GenDomainModel zdlgen, boolean referenced) {
		if (referenced) {
			// restore the reference
			getGenModel().getReferencedModels().add(zdlgen);
			
			// delete the owned gen model
			for (GenDomainModel owned : getGenModel().getOwnedModels()) {
				if (owned.getDomainModel() == zdlgen.getDomainModel()) {
					EcoreUtil.remove(owned);
					break;
				}
			}
		} else {
			// remove the reference
			getGenModel().getReferencedModels().remove(zdlgen);
			
			// create the owned gen model
			GenDomainModel owned = ZDLGenFactory.eINSTANCE.createGenDomainModel();
			owned.setDomainModel(zdlgen.getDomainModel());
			getGenModel().getOwnedModels().add(owned);
		}
	}

	/**
	 * Looks up an available generator model for the specified ZDL model, on
	 * the extension point.
	 * 
	 * @param usedModel a ZDL model that is used by the "main" model that we
	 *    are importing
	 * @return the available generator model, or <code>null</code> if there
	 *    is none registered
	 */
	private GenDomainModel lookupGenDomainModel(Model usedModel) {
		GenDomainModel result = null;
		URI nsURI = DomainModelWorkspaceRegistry.INSTANCE.getNamespaceURI(usedModel);

		if (nsURI != null && !nsURI.isEmpty()) {
			GenModel genModel = ZDLGenModelWorkspaceRegistry.INSTANCE.getGenModel(nsURI, rset);
			if (genModel == null) {
				// look in the installed plugins
				genModel =
					ZDLGenModelRegistry.INSTANCE.getGenModel(nsURI, rset);
			}
			
			if(genModel != null) {
				for (GenDomainModel next : genModel.getOwnedModels()) {
					if (next.getDomainModel() == usedModel) {
						result = next;
						break;
					}
				}
			}
		}

		return result;
	}
	

	/**
	 * Converts the source ZDL model to ZDLGen using the oAW workflow.
	 * The destination file must already exist.
	 * 
	 * @param destination the destination URI to merge the generated ZDLGen into
	 * @param shell the parent shell for the progress dialog 
	 * @param monitor to receive feed-back of progress during the transformation
	 * 
	 * @return the status of the transformation
	 * 
	 * @throws InvocationTargetException on failure of the oAW workflow
	 * @throws InterruptedException on interruption of the oAW workflow
	 */
	public IStatus convert(URI destination, Shell shell, IProgressMonitor monitor)
			throws InvocationTargetException, InterruptedException {
		Map<String, String> genProperties = new java.util.HashMap<String, String>();
		Map<String, Object> genSlots = new java.util.HashMap<String, Object>();

		// compute genSlots map
		List<Model> domainModels = new java.util.ArrayList<Model>();
		for (GenDomainModel next : getGenModel().getOwnedModels()) {
			domainModels.add(next.getDomainModel());
		}
		genSlots.put(GenerateOperation.DOMAIN_MODELS, domainModels);
		genSlots.put(GenerateOperation.REFERENCED_MODELS, getGenModel().getReferencedModels());
		genSlots.put(GenerateOperation.RESOURCE_SET, rset);
		genSlots.put(GenerateOperation.TARGET_MODEL_URI, destination);
		
		// generate
		GenerateOperation op = new GenerateOperation(shell, genProperties,
			genSlots, WORKFLOW_RESOURCE);
		op.run(monitor);
		
		return op.getStatus();
	}

	/**
	 * Adds a listener to me.
	 * 
	 * @param l the listener to add
	 */
	public void addListener(ZDLImporterListener l) {
		listeners.add(l);
	}

	/**
	 * Removes a listener from me.
	 * 
	 * @param l the listener to remove
	 */
	public void removeListener(ZDLImporterListener l) {
		listeners.remove(l);
	}

	/**
	 * Fires an event to my listeners indicating that I have changed (loaded
	 * a new ZDL model).
	 */
	private void fireChangeEvent() {
		ZDLImporterEvent event = new ZDLImporterEvent(this,
			ZDLImporterEvent.MODEL_LOADED);

		for (Object next : listeners.getListeners()) {
			((ZDLImporterListener) next).inputModelLoaded(event);
		}
	}
}
