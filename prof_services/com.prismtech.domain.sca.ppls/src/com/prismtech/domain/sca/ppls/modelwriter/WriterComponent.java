/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls.modelwriter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.prismtech.domain.sca.ppls.vpm.Attribute;
import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.ConstrainedElement;
import com.prismtech.domain.sca.ppls.vpm.SettableAttribute;
import com.prismtech.domain.sca.ppls.vpm.VPModel;
import com.prismtech.domain.sca.ppls.vpm.VariationPoint;
import com.prismtech.domain.sca.ppls.vpm.VariationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.VariationPointWithValue;
import com.prismtech.domain.sca.ppls.vpm.VpmFactory;
import com.prismtech.domain.sca.ppls.Activator;

/**
 * Workflow component responsible for taking a CX model element and creating or updating
 * a .vpm model file from it.
 * 
 * @author smcfee
 *
 */
public class WriterComponent extends WorkflowComponentWithModelSlot {

	private String targetDir;		
	private String targetFile;
	private Map<String, VariationPoint> oldVpMap = new HashMap<String, VariationPoint>();
	private Map<String, VariationPoint> newVpMap = new HashMap<String, VariationPoint>();
	private ListMultimap<VariationPoint, ConfigurationPoint> vpToCpMap = ArrayListMultimap.create();
	
	
	/**
	 * The directory as a URI that the file will be written into.
	 * @param value
	 */
	public void setTargetDir(String value) {
		this.targetDir = value;
	}
		
	/**
	 * 
	 * @param ctx
	 * @return
	 */
	public String getTargetFile() {
		return targetFile + ".vpm";		 //$NON-NLS-1$
	}
	
	protected void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}
	
	/**
	 * 
	 * @return The directory that the file will be written into
	 */
	public String getTargetDir() {
		return targetDir;
	}	
	
	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		if(Activator.checkLicense().isOK()) {			
			VPModel oldModel = null;
			VPModel newModel = (VPModel)ctx.get(getModelSlot());
			setTargetFile(newModel.getName());
	
			ResourceSet rset = new ResourceSetImpl();
			Resource res = null;
		
			// If the .vpm resource already exists, merge into it. Otherwise, create it.
			try {
				res = rset.getResource(URI.createFileURI(getTargetDir() + getTargetFile()), true);	
				if( res != null && res.getContents().size() > 0 ) {
					oldModel = (VPModel)res.getContents().get(0);
					
					// Overwrite simple properties of the variation point model with the ones coming in.
					oldModel.setName(newModel.getName());
					oldModel.setSource(newModel.getSource());
					oldModel.setQualifiedName(newModel.getQualifiedName());
					
					mapVariationPoints(oldModel, oldVpMap);
					mapVariationPoints(newModel, newVpMap);
					
					mapVariationPointsToConfigurationPoints(oldModel);
					
					// Perform merger of variation points between models
					mergeVariationPoints(oldModel, newModel);
					
				}
			} catch( Exception e ) {
				res = rset.createResource(URI.createFileURI(getTargetDir() + getTargetFile()));
				res.getContents().add(newModel);
			}
			
			try {
				res.save(null);
			} catch (IOException ioe) {
				Activator.getDefault().error(Messages.SaveVariationPointModelError, ioe);
			
			}
			
			res.unload();
			rset.getResources().remove(res);
		}else{
			Activator.getDefault().warning(Messages.FeatureNotLicensedWarning);
		}
	}
	
	/**
	 * Helper function to index all of the variation points in the model for efficient processing
	 * 
	 * @param model - VPModel containing all of the VariationPoint elements
	 * @param map - map in which to index all of the VariationPoints found in the model
	 */
	private void mapVariationPoints(VPModel model, Map<String, VariationPoint> map){
		for(VariationPoint vp : model.getVariationPoints()){
			map.put(vp.getId(), vp);
		}
	}
	
	/**
	 * Helper function to pair each VariationPoint element to all ConfigurationPoint elements referencing it 
	 * 
	 * @param model - VPModel element containing both VariationPoint and Configuration elements
	 */
	private void mapVariationPointsToConfigurationPoints(VPModel model) {
		
		for(Configuration config : model.getConfigurations()){
			for(ConfigurationPoint cp : config.getConfigurationPoints()){
				vpToCpMap.put(cp.getVariationPoint(), cp);
			}
		}		
	}
	
	private void updateVariationPointKeyInMap(VariationPoint oldVp, VariationPoint newVp){
		List<ConfigurationPoint> cpList = vpToCpMap.get(oldVp);
		vpToCpMap.putAll(newVp, cpList);
		vpToCpMap.removeAll(oldVp);
		updateConfigurationPointValuesInMap(newVp);
	}
	
	private void updateConfigurationPointValuesInMap(VariationPoint vp){
		for(Iterator<ConfigurationPoint> cpi = vpToCpMap.get(vp).iterator(); cpi.hasNext();){
			ConfigurationPoint cp = cpi.next();
			cp.setName(vp.getName());
			cp.setVariationPoint(vp);
			
			if(vp instanceof VariationPointWithSettings){
				// TODO
			}else if(vp instanceof VariationPointWithValue){
				// TODO
			}
			
			
		}
	}

	/**
	 * Helper method to merge the contents of two VPModel elements in the case when an
	 * existing .vpm file cannot be found. 
	 * 
	 * @param oldModel - VPModel element to merge into from newModel
	 * @param newModel - VPModel element from which to merge the changes into oldModel
	 */
	private void mergeVariationPoints(VPModel oldModel, VPModel newModel) {
		// Add any missing variation points to the new model. Update 
		// configurations accordingly.
		for(Iterator<String> vpIds = newVpMap.keySet().iterator(); vpIds.hasNext();){
			String newId = vpIds.next();
			VariationPoint oldVp, newVp;
			newVp = newVpMap.get(newId);	
			if(oldVpMap.containsKey(newId)){
				oldVp = oldVpMap.get(newId);
				if(!oldVp.getName().equals(newVp.getName())){
					oldVp.setName(newVp.getName());
					updateVariationPointKeyInMap(oldVp, newVp);
				}
				mergeConstrainedElements(oldVpMap.get(newId), newVpMap.get(newId));
				if(oldVp instanceof VariationPointWithSettings){
					mergeSettableAttributes((VariationPointWithSettings) oldVp);
				}
			}else{
				// create
				VariationPoint createVp = null;
				if( newVp instanceof VariationPointWithValue ) {
					createVp = VpmFactory.eINSTANCE.createVariationPointWithValue();
				} else if (newVp instanceof VariationPointWithSettings){
					createVp = VpmFactory.eINSTANCE.createVariationPointWithSettings();					
				} else {
					createVp = VpmFactory.eINSTANCE.createVariationPoint();
				}
				createConstrainedElements(createVp, newVp);
				createVp.setName(newVp.getName());
				createVp.setId(newVp.getId());
				oldModel.getVariationPoints().add(createVp);
				oldVpMap.put(newVp.getId(), createVp);
				//add the corresponding configuration point to all the configurations
				//for( Configuration configuration : oldModel.getConfigurations()) {
				for( Configuration configuration : oldModel.getConfigurations()) {
					ConfigurationPoint createCp = null;
					if( newVp instanceof VariationPointWithValue ) {
						createCp = VpmFactory.eINSTANCE.createConfigurationPointWithValue();
					} else if(newVp instanceof VariationPointWithSettings) {
						createCp = VpmFactory.eINSTANCE.createConfigurationPointWithSettings();
						createSettableAttributes((ConfigurationPointWithSettings)createCp, (VariationPointWithSettings) newVp);
					} else {
						createCp = VpmFactory.eINSTANCE.createConfigurationPoint();
					}
					createCp.setName(newVp.getName());
					createCp.setVariationPoint(newVp);
					configuration.getConfigurationPoints().add(createCp);
					vpToCpMap.put(newVp, createCp);
				}
			}
		}
		
		// Remove deleted variation points from the variation point model. Update 
		// configurations accordingly.
		Set<VariationPoint> destroySet = new HashSet<VariationPoint>();
		for( VariationPoint oldVp : oldModel.getVariationPoints()) {
			boolean found = false;
			for( VariationPoint newVp : newModel.getVariationPoints()) {
				if( newVp.getId().equals(oldVp.getId())) {
					found = true;
					break;
				}
			}
			if( !found ) {
				// remove
				destroySet.add(oldVp);
			}
		}
		for( VariationPoint destroyVp : destroySet ) {
			EcoreUtil.delete(destroyVp);			
			for(Iterator<ConfigurationPoint> destroyCpIter = vpToCpMap.get(destroyVp).iterator(); destroyCpIter.hasNext();){
				destroyCpIter.next();
				destroyCpIter.remove();
			}
		}
	}
	/**
	 *  Helper method to merge the ConstrainedElement elements of two VariationPoint elements of a VPModel element. 
	 *  
	 * @param oldVp - VariationPoint element to merge into from newVp
	 * @param newVp - VariationPoint element from which to merge the changes into oldVp
	 */
	private void mergeConstrainedElements(VariationPoint oldVp, VariationPoint newVp){
		//Bring in the new
		List<ConstrainedElement> constrainedElementsToAdd = new ArrayList<ConstrainedElement>();
		for(ConstrainedElement newCe : newVp.getConstrainedElements()){
			boolean found = false;
			for(ConstrainedElement oldCe : oldVp.getConstrainedElements()){
		        //See if the old constrained element contains the new attribute
				if(oldCe.getName().equals(newCe.getName()) &&oldCe.getQualifiedName().equals(newCe.getQualifiedName())){
		        	//No? Add it in
					found = true;
					if(oldVp instanceof VariationPointWithSettings && newVp instanceof VariationPointWithSettings){
						mergeAttributes(oldCe, newCe);
						break;
					}
				}
				//Yes? leave it alone		
			}
			if(found==false){
				constrainedElementsToAdd.add(newCe);
			}
		}
		
	    //Take out the old
		for(Iterator<ConstrainedElement> oldConstrainedElements = oldVp.getConstrainedElements().iterator(); oldConstrainedElements.hasNext();){
			boolean found = false;
			ConstrainedElement oldConstrainedElement = oldConstrainedElements.next();
			for(Iterator<ConstrainedElement> newConstrainedElements = newVp.getConstrainedElements().iterator(); newConstrainedElements.hasNext();){
				ConstrainedElement newConstrainedElement = newConstrainedElements.next(); 
				//See if the new constrained element contains the old attribute
				//No? Remove it
				if(oldConstrainedElement.getName().equals(newConstrainedElement.getName())){
					found=true;
					break;
				}
				//Yes? leave it alone
			}
			if(found==false){
				oldConstrainedElements.remove();
			}
		}
		
		if(constrainedElementsToAdd.size()>0){
			for(ConstrainedElement constrainedElementToAdd : constrainedElementsToAdd){
				oldVp.getConstrainedElements().add(constrainedElementToAdd);
			}
		}
	}
	
	/**
	 *  Helper method to merge the Attribute elements of two ConstrainedElement elements of a VariationPoint element. 
	 *  
	 * @param oldCe - ConstrainedElement element to merge into from newCe
	 * @param newCe - ConstrainedElement element from which to merge the changes into oldCe
	 */
	private void mergeAttributes(ConstrainedElement oldCe, ConstrainedElement newCe){
		//Bring in the new
		List<Attribute> attributesToAdd = new ArrayList<Attribute>();
		for(Attribute newAttribute : newCe.getAttributes()){
			boolean found = false;
			for(Attribute oldAttribute : oldCe.getAttributes()){
		        //See if the old constrained element contains the new attribute
				if(oldAttribute.getName().equals(newAttribute.getName())){
		        	//No? Add it in
					found = true;
					break;
				}
				//Yes? leave it alone
			}
			if(found==false){
				attributesToAdd.add(newAttribute);
			}
		}
	    //Take out the old
		for(Iterator<Attribute> oldAttributes = oldCe.getAttributes().iterator(); oldAttributes.hasNext();){
			boolean found = false;
			Attribute oldAttribute = oldAttributes.next();
			for(Iterator<Attribute> newAttributes = newCe.getAttributes().iterator(); newAttributes.hasNext();){
				Attribute newAttribute = newAttributes.next(); 
				//See if the new constrained element contains the old attribute
				//No? Remove it
				if(oldAttribute.getName().equals(newAttribute.getName())){
					found=true;
					break;
				}
				//Yes? leave it alone
			}
			if(found==false){
				oldAttributes.remove();
			}
		}
		
		if(attributesToAdd.size()>0){
			for(Attribute attributeToAdd : attributesToAdd){
				oldCe.getAttributes().add(attributeToAdd);
			}
		}
	}
	
	/**
	 *  Helper method to propagate the changes to the Attribute elements of a VariationPointWithSettings element to all the Configuration Points referencing it. 
	 *  
	 * @param updatedVPS - VariationPointWithSettings element from which to propagate the changes
	 */
	public void mergeSettableAttributes(VariationPointWithSettings updatedVPS){	
		//Build a list of unique Attributes in the updated Variation Point
		Map<String, Attribute> vpAttributes = new HashMap<String, Attribute>();
		for(ConstrainedElement ce: updatedVPS.getConstrainedElements()){
			for(Attribute attribute : ce.getAttributes()){
				vpAttributes.put(attribute.getName(), attribute);
			}
		}

		for(Iterator<ConfigurationPoint> cpIter = vpToCpMap.get(updatedVPS).iterator(); cpIter.hasNext();){
			ConfigurationPointWithSettings cps = (ConfigurationPointWithSettings) cpIter.next();
			//take out the old settable attributes
			for(Iterator<SettableAttribute> saIter = cps.getSettableAttributes().iterator(); saIter.hasNext();){
				SettableAttribute sa = saIter.next();
				if(!vpAttributes.containsKey(sa.getName())){
					//remove the settable attribute
					saIter.remove();
				}
			}
			//bring in the new settable attributes based on the up-to-date variation point's attributes
			for(String attribute : vpAttributes.keySet()){
				boolean attributeFound = false;
				for(Iterator<SettableAttribute> saIter = cps.getSettableAttributes().iterator(); saIter.hasNext();){
					SettableAttribute sa = saIter.next();
					if(sa.getName().equals(attribute)){
						//do nothing
						attributeFound = true;
						break;
					}
				}
				if(attributeFound==false){
					//add it in					
					SettableAttribute createSa = VpmFactory.eINSTANCE.createSettableAttribute();
					createSa.setName(attribute);
					cps.getSettableAttributes().add(createSa);
				}
			}
		}
	}
	
	/**
	 * Helper method to create ConstrainedElements elements in a VariationPoint element based on ConstrainedElement elements in another VariationPoint element 
	 * 
	 * @param destinationVp - VariationPoint element whose Attribute elements are created based on the Attribute elements in sourceVPS
	 * @param sourceVp - VariationPoint element whose ConstrainedElement elements dictate the ConstrainedElement elements to be created in the destinationVP
	 */
	public void createConstrainedElements(VariationPoint destinationVp, VariationPoint sourceVp){
		for(ConstrainedElement newConstrainedElement : sourceVp.getConstrainedElements()){
			ConstrainedElement createCE = VpmFactory.eINSTANCE.createConstrainedElement();
			createCE.setName(newConstrainedElement.getName());
			createCE.setQualifiedName(newConstrainedElement.getQualifiedName());
			if(destinationVp instanceof VariationPointWithSettings && sourceVp instanceof VariationPointWithSettings){
				for(Attribute newAttribute : newConstrainedElement.getAttributes()){
					Attribute createAttribute = VpmFactory.eINSTANCE.createAttribute();
					createAttribute.setName(newAttribute.getName());
					createCE.getAttributes().add(createAttribute);
				}
			}
			destinationVp.getConstrainedElements().add(createCE);
		}
	}
	
	/**
	 * Helper method to create SettableAttribute elements for a ConfigurationPointWithSettings element from a VariationPointWithSettings element's Attributes
	 * 
	 * @param destinationCPS - ConfigurationPointWithSettings element whose SettableAttribute elements are created based on the Attribute elements in sourceVPS
	 * @param sourceVPS - VariationPointWithSettings element whose Attribute elements dictate the SettableAttribute elements to be created in the destinationCP
	 */
	public void createSettableAttributes(ConfigurationPointWithSettings destinationCPS, VariationPointWithSettings sourceVPS){
		for(ConstrainedElement newCe: sourceVPS.getConstrainedElements()){
			for(Attribute newAttribute : newCe.getAttributes()){
				boolean settableAttributeFound=false;
				for(SettableAttribute sa : destinationCPS.getSettableAttributes()){
					//If it's there, leave it alone
					if(sa.getName().equals(newAttribute.getName())){
						settableAttributeFound=true;
						break;
					}					
				}
				//If it's not, add it in
				if(settableAttributeFound==false){
					SettableAttribute createSa = VpmFactory.eINSTANCE.createSettableAttribute();
					createSa.setName(newAttribute.getName());	
					destinationCPS.getSettableAttributes().add(createSa);
				}
			}
		}
	}
}
