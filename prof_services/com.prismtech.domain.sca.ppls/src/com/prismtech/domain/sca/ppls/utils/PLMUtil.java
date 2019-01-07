/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */

package com.prismtech.domain.sca.ppls.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint;
import com.prismtech.domain.sca.ppls.vpm.VPModel;
import com.prismtech.domain.sca.ppls.vpm.VariationPoint;

/**
 *
 * @author mciobanu
 *
 */
public class PLMUtil {
	
	private static final String MARK_PLM_MODELS = "Mark PLM models"; //$NON-NLS-1$

	//Variation Point Profile Concepts
	private static String [] vpp_concepts = {PLMNames.VARIATION_POINT, 
			PLMNames.VARIATION_POINT_WITH_VALUE, 
			PLMNames.VARIATION_POINT_WITH_SETTINGS};

	//Variation Point Model Concepts
	private static String [] vpm_concepts = {
		VPMNames.VARIATION_POINT,
		VPMNames.VARIATION_POINT_WITH_VALUE,
		VPMNames.VARIATION_POINT_WITH_SETTINGS,
		VPMNames.CONFIGURATION,
		VPMNames.CONFIGURATION_POINT,
		VPMNames.CONFIGURATION_POINT_WITH_VALUE,
		VPMNames.CONFIGURATION_POINT_WITH_SETTINGS
	};
	
	private static final String TRANSACTION_LABEL = MARK_PLM_MODELS;
	
	/**
	 * Not publicly instantiable.
	 */
	protected PLMUtil() {
		super();
	}
	
	/**
	 * Checks whether the element can be added to the current editor
	 * 
	 * @param e
	 * @return 
	 * 		true if the active editor is a Diagram Editor
	 * 		false if the active editor is anything else, including no editor at all
	 */
	public static boolean canAddElementToActiveDiagram(Element e){
		IWorkbenchPage workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if(workbenchPage != null){
			DiagramEditPart editPart = getDiagramEditPart(workbenchPage);
			if(editPart != null){
				return true;
			}
			return false;
		}
		return false;
	}	
	
	/**
	 * Adds element to current active diagram editor. 
	 * 
	 * This also does a check to see if the current active editor is a Diagram Editor @see {@link #canAddElementToActiveDiagram(Element)}
	 * 
	 * @param e {@link Element} do add to the active diagram
	 */
	public static void addElementToActiveDiagram(Element e) {	
		if(canAddElementToActiveDiagram(e)){
			IWorkbenchPage workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			DiagramEditPart editPart = getDiagramEditPart(workbenchPage);
			dropElement(editPart, new Point(400, 150), e);			
			Request refreshRequest = new Request("refresh"); //$NON-NLS-1$
			org.eclipse.gef.commands.Command refreshCommand = editPart.getCommand(refreshRequest);
			refreshCommand.execute();			
		}
	}
	
	/**
	 * Get {@link DiagramEditPart} from the current active diagram editor.
	 * 
	 * @param page
	 * @return The {@link DiagramEditPart} if one is found. null otherwise
	 */
	protected static DiagramEditPart getDiagramEditPart(IWorkbenchPage page) {
		if (page.getActiveEditor() instanceof IDiagramWorkbenchPart) {
			IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart) page
				.getActiveEditor();
			if (diagramPart != null) {
				return diagramPart.getDiagramEditPart();
			}
		}
		return null;
	}
	
	/**
	 * Drop object to a diagram.
	 * 
	 * @param editPart
	 * @param dropLocation
	 * @param object
	 */
	protected static void dropElement(DiagramEditPart editPart, Point dropLocation,
			EObject object) {

		// Drop element
		EList<EObject> elementToDrop = new BasicEList<EObject>();
		elementToDrop.add(object);

		DropObjectsRequest dropRequest = new DropObjectsRequest();
		dropRequest.setObjects(elementToDrop);
		dropRequest.setAllowedDetail(1);
		dropRequest.setLocation(dropLocation);

		Command command = editPart.getCommand(dropRequest);

		command.execute();
	}
	
	/**
	 * 
	 * @param e
	 * @param concept
	 * @return
	 */
	public static boolean isPLMConcept(EObject e, String concept){
		if(!UMLUtil.isEmpty(concept) && e != null){
			if(e instanceof Element){
				for( Stereotype s : ((Element) e).getAppliedStereotypes() ) {				
					if(checkPLMConcept(concept)){
						if (s.getQualifiedName().equals(concept)) {
							return true;
						}
					}
				}
			} else {
				if(checkVPMConcept(concept)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	public static boolean isPLMConcept(EObject e){
		if(e != null){
			if(e instanceof Element){
				for( Stereotype s : ((Element) e).getAppliedStereotypes() ) {
					if (checkPLMConcept(s.getQualifiedName())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param concept
	 * @return
	 */
	protected static boolean checkPLMConcept(String concept){
		for(String s : vpp_concepts){
			if(s.equals(concept)){
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param concept
	 * @return
	 */
	protected static boolean checkVPMConcept(String concept){
		for(String s : vpm_concepts){
			if(s.equals(concept)){
				return true;
			}
		}		
		return false;
	}
	
	/**
	 * Helper method to check if a model or the model containing a specified element has the VariationPointProfile applied
	 * @param eo - UML model or element contained by a UML model
	 * @return 	<b>true</b> if model or the model containing the element has the profile applied.<br>
	 * 			<b>false</b> if null or does not have the profile applied
	 *   
	 */
	public static boolean isPLMCapabilityEnabled(EObject eo){
		
		EObject topContainer = null;
		EObject currentContainer = null;
		if(eo == null){
			return false;
		}
		
		if(!(eo instanceof Model)) {
			currentContainer = eo.eContainer();
			while(topContainer == null){
				currentContainer = currentContainer.eContainer();
				if(currentContainer instanceof Model){
					topContainer = currentContainer;
					break;
				}
			}
		}
		
		if( eo instanceof Model || topContainer instanceof Model){
			for(ProfileApplication pa : ((Model)eo).getProfileApplications()){
				if(pa.getAppliedProfile().getName().equals(PLMNames.VARIATION_POINT_PROFILE)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Helper method to retrieve the variation point constraining an element
	 * @param e - constrained element 
	 * @return variation point constraining the element
	 */
	@SuppressWarnings("unchecked")
	public static List<Element> getConstraints(Element e){
		List<Element> constraintsTargettingObject = new ArrayList<Element>();
		if(e != null){
			for(Setting s: UMLUtil.getInverseReferences((EObject) e)){
				if(s.getEObject() instanceof Constraint){					
					if(s instanceof List){
						List<Element> structFeatureList = (List<Element>) s.getEObject().eGet(s.getEStructuralFeature());
						if(structFeatureList != null){
							for(Element constrainedElement : structFeatureList){
								if(constrainedElement.equals(e)){
									constraintsTargettingObject.add((Element)s.getEObject());
									break;
								}
							}
						}
					}
				}
			}
		}
		
		return constraintsTargettingObject;
	}
	
	/**
	 * Add the generation annotation to the model
	 * 
	 * @param model
	 *            Model that has been annotated
	 * @return
	 * @throws Exception
	 */
	public static void addPLMModelAnnotation(final Model model) throws Exception{
		ICommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(model), TRANSACTION_LABEL,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				// add generation annotation info to model
				EAnnotation anno = model.getEAnnotation(PLMNames.MODEL_ANNOTATION);
				if (anno == null && !isPLMCapabilityEnabled(model)) {
					anno = model.createEAnnotation(PLMNames.MODEL_ANNOTATION);
					anno.getDetails().put(PLMNames.MODEL_ANNOTATION__TYPE, PLMNames.MODEL_ANNOTATION__GENERATED);
				}

				return CommandResult.newOKCommandResult();
			}
		};
		OperationHistoryFactory.getOperationHistory().execute(command,
				null, null);
	}
	
	public static EAnnotation getAnnotation(final Model model, String annotationName) {
		EAnnotation anno = model.getEAnnotation(annotationName);
		if (anno == null) {
			return null;
		}
		return anno;
	}
	
	/**
	 * Get all the ConfigurationPoints associated with the specified variation point inside a VPMModel
	 *  
	 * @param vp - Variation Point referenced by the Configuration points to be returned
	 * 
	 * @return List of ConfigurationPoints referencing the Variation Point across all Configurations in the VPModel containing both
	 */
	public static List<ConfigurationPoint> getConfigurationPoints(VariationPoint vp){
		List<ConfigurationPoint> cps = new ArrayList<ConfigurationPoint>();;
		VPModel model = (VPModel) vp.eContainer();
		if(model.getConfigurations() != null){
			for(Configuration config : model.getConfigurations()){
				for(ConfigurationPoint cp : config.getConfigurationPoints()){
					if(cp.getVariationPoint().equals(vp)){
						cps.add(cp);
					}
				}
			}
		}
		return cps;		
	}
}
