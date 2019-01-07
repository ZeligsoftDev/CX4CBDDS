/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls.modelwriter;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.ibm.xtools.uml.type.UMLElementFactory;
import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.prismtech.domain.sca.ppls.utils.PLMUtil;
import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue;
import com.prismtech.domain.sca.ppls.vpm.SettableAttribute;
import com.prismtech.domain.sca.ppls.Activator;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.domain.sca.generation.base.util.CodeGenerationUtilities;
import com.zeligsoft.domain.sca.utils.SCANames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Workflow component responsible for taking a Configuration and creating
 * a new CX model from it.
 * 
 * @author smcfee
 * @author mciobanu
 */

public class WriteCXModelComponent extends WorkflowComponentWithModelSlot {

	private final static int MODEL = 1;
	
	private final static int APPLICATION = 2;
	
	private final static int NODE = 3;
	
	private final static int PLATFORM = 4;
	
	private String targetDir;		
	
	/**
	 * The directory as a URI that the file will be written into.
	 * @param value
	 */
	public void setTargetDir(String value) {
		this.targetDir = value;
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
		if(Activator.checkLicense().isOK()){
			// Get the configuration and the CX model element it points to.
			NamedElement cxTemplate = null;
			Configuration config = (Configuration)ctx.get("element"); //$NON-NLS-1$
			com.prismtech.domain.sca.ppls.vpm.VPModel vpModel = (com.prismtech.domain.sca.ppls.vpm.VPModel)config.eContainer();
			String resourceURIString = vpModel.getSource();
			ResourceSet rset = UMLModeler.getEditingDomain().getResourceSet();
			Resource baseModelResource = rset.getResource(URI.createURI(resourceURIString, true), true);
			if( baseModelResource != null && baseModelResource.getErrors().isEmpty()) {
				cxTemplate = UMLUtil.findNamedElements(baseModelResource, vpModel.getQualifiedName()).toArray(new NamedElement[1])[0];
				System.out.println(cxTemplate.toString());
			}
			
			IProject targetProject = ProjectFactory.getProject(cxTemplate, null, ProjectFactory.MODE_NO_CREATE);
			
			// Create the target model URI
			URI targetModelURI = URI.createFileURI(getTargetDir() + config.getName() + ".emx"); //$NON-NLS-1$	
			Resource oldGenModelResource = rset.getResource(targetModelURI, false);
			File oldGenModelFile = new File(targetModelURI.toFileString());
			
			// Clean up existing resources to prevent model resource duplication
			if(oldGenModelFile.exists()){	
				// Unload and remove the old generated model resource if it already exists
				if(oldGenModelResource!=null){
					oldGenModelResource.unload();
					rset.getResources().remove(oldGenModelResource);
				}		
				// Delete the old resource file
				if(oldGenModelFile.delete()){
					//Refresh workspace
					try {
						targetProject.refreshLocal( IResource.DEPTH_INFINITE, new NullProgressMonitor());
						ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
					} catch (CoreException e) {
						Activator.getDefault().error(Messages.RefreshWorkspaceBeforeCXGenerationError, e);		
						e.printStackTrace();
					}
				}			
			}
			
			// Create the target model resource.
			Resource newGenModelResource = rset.createResource(targetModelURI);
			
			// Create the initial target model which is a copy of the template model.
			EcoreUtil.Copier copier = new EcoreUtil.Copier();
			Collection<EObject> copies = copier.copyAll(baseModelResource.getContents());
			copier.copyReferences();
			newGenModelResource.getContents().addAll(copies);
	
			// Traverse the variation points to find model elements not needed in the
			// target model and to set any values needed.
			evaluateConfigurationPoints((Package)newGenModelResource.getContents().get(0), config);
			
			// Determine whether the concept from which the VPModel was created was an model, application, node, or platform. 
			int contextMode = 0;
			if(cxTemplate instanceof Model){
				contextMode = MODEL;
			}else if(ZDLUtil.isZDLConcept(cxTemplate, SCANames.SCAAPPLICATION)){
				contextMode = APPLICATION;
			}else if(ZDLUtil.isZDLConcept(cxTemplate, SCANames.SCANODE)){
				contextMode = NODE;
			}else if(ZDLUtil.isZDLConcept(cxTemplate, SCANames.SCAPLATFORM)){
				contextMode = PLATFORM;
			}else{
				//TODO Add notification for wrong context
			}
			// Remove any elements we no longer need in the target model.
			pruneModel((Package)newGenModelResource.getContents().get(0), vpModel.getQualifiedName(), contextMode);
				
			// Rename the model to the name of the configuration point for which it is generated
			((Package)newGenModelResource.getContents().get(0)).setName(config.getName());
	
			// Set the generated project name of the copied model to that of the Configuration from which it is being generated 
			ProjectFactory.setSrcProjectName(newGenModelResource.getContents().get(0), config.getName());		
			
			// Remove the VariationPointProfile from the generated model
			Profile vpProfile = ((Package)newGenModelResource.getContents().get(0)).getAppliedProfile(PLMNames.VARIATION_POINT_PROFILE);
			if(vpProfile != null){
				((Model)newGenModelResource.getContents().get(0)).getProfileApplication(vpProfile).destroy();			
			}
	
			// Annotate the model to reflect that it is a generated model, so that it may be decorated appropriately
			try {
				PLMUtil.addPLMModelAnnotation((Model)newGenModelResource.getContents().get(0));
			} catch (Exception e) {
				MessageFormat messageFormat = new MessageFormat(Messages.AnnotateModelError);
				Object[] args = {((Model)newGenModelResource.getContents().get(0)).getName(), config.getName()};
				String error = messageFormat.format(args);											
				Activator.getDefault().error(error, e);
			}
			// Save the model
			try {
	            Map<String, String> saveOptions = new HashMap<String, String>();
	            saveOptions.put( Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER );
	            
				newGenModelResource.save(saveOptions);
			} catch (IOException e) {
				Activator.getDefault().error(Messages.GenerateModelResourceSaveError, e);
			}
				
			//Refresh workspace
			try {
				newGenModelResource.save(null);
				ResourcesPlugin.getWorkspace().save(true, null);
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				
				//Generate descriptors for the configuration if selected
				if (config.isGenerateDescriptors()==true){
					CodeGenerationUtilities.generateDescriptors((Model)((Package)newGenModelResource.getContents().get(0)));			
				}
			} catch (CoreException e) {
				Activator.getDefault().error(Messages.RefreshWorkspaceAfterCXGenerationError, e);
				e.printStackTrace();
			} catch (IOException e) {
				Activator.getDefault().error(Messages.SaveNewModelResourceAfterCXGenerationError, e);
				e.printStackTrace();
			}
		}else{
			Activator.getDefault().warning(Messages.FeatureNotLicensedWarning);
		}
	}
	
	/**
	 * Evaluate the variation points for a configuration.
	 * 
	 * @param topLevelPackage
	 * @param config
	 */
	@SuppressWarnings("unchecked")
	private void evaluateConfigurationPoints(Package topLevelPackage, Configuration config) {
		HashSet<Element> elementsToDestroy = new HashSet<Element>();

		for (TreeIterator<EObject> iter = topLevelPackage.eAllContents(); iter.hasNext();) {
			EObject next = iter.next();
			
			if( next instanceof Constraint ) {
				Constraint c = (Constraint)next;
				for( Stereotype s : ((Constraint)next).getAppliedStereotypes() ) {
					if( s.getQualifiedName().equals(PLMNames.VARIATION_POINT)) {
						for( ConfigurationPoint cp : config.getConfigurationPoints()) {
							if( cp.getVariationPoint().getId().equals(c.getValue(s, PLMNames.VARIATION_POINT__VP_ID).toString()) && cp.isGenerate() == false ) {
								elementsToDestroy.addAll(c.getConstrainedElements());
								break;
							} 
						}
						break;
					} else if(s.getQualifiedName().equals(PLMNames.VARIATION_POINT_WITH_VALUE)){
						for( ConfigurationPoint cp : config.getConfigurationPoints()) {
							if( cp.getVariationPoint().getId().equals(c.getValue(s, PLMNames.VARIATION_POINT__VP_ID).toString()) && cp.isGenerate() == false ) {
								elementsToDestroy.addAll(c.getConstrainedElements());
								break;
							} else if( cp.getVariationPoint().getId().equals(c.getValue(s, PLMNames.VARIATION_POINT__VP_ID).toString()) && cp.isGenerate() == true && cp instanceof ConfigurationPointWithValue) {
								ConfigurationPointWithValue cpv = (ConfigurationPointWithValue)cp;
								String value = UMLUtil.isEmpty(cpv.getValue()) ? "" : cpv.getValue(); //$NON-NLS-1$
								for( Element e : c.getConstrainedElements()) {
									if( ZDLUtil.isZDLConcept(e, SCANames.SCAPROPERTY)) {			
										ZDLUtil.setValue(e, SCANames.SCAPROPERTY, SCANames.SCAPROPERTY__VALUE, value);
									}
								}
								break;
							}
						}
						break;
					} else if(s.getQualifiedName().equals(PLMNames.VARIATION_POINT_WITH_SETTINGS)){
						for( ConfigurationPoint cp : config.getConfigurationPoints()) {
							if( cp.getVariationPoint().getId().equals(c.getValue(s, PLMNames.VARIATION_POINT__VP_ID).toString()) && cp.isGenerate() == false ) {
								elementsToDestroy.addAll(c.getConstrainedElements());
								break;
							} else if(cp.getVariationPoint().getId().equals(c.getValue(s, PLMNames.VARIATION_POINT__VP_ID).toString()) && cp.isGenerate() == true && cp instanceof ConfigurationPointWithSettings){
								ConfigurationPointWithSettings cps = (ConfigurationPointWithSettings)cp;
								for( Element e : c.getConstrainedElements()) {
									//Keep existing value from the attribute in the base model if no value is specified for the Settable Attribute
									for(SettableAttribute sa : cps.getSettableAttributes()){
										if(UMLUtil.isEmpty(sa.getValue())){
											continue;
										} else if(ZDLUtil.isZDLConcept(e, SCANames.SCAPLATFORM_ELEMENT_PART)){
											if(sa.getName().equals(SCANames.SCAPLATFORM_ELEMENT_PART__DEPLOYONDEVICE)){
												NamedElement containerNode = (NamedElement) ZDLUtil.getValue(e, SCANames.SCAPART, SCANames.SCAPART__CONTAINER);
												//if it's a qualified name, look for the element in the model
												boolean nameResolved = false;
												if(sa.getValue().contains("::")){ //$NON-NLS-1$
													NamedElement target = null;
													Collection<NamedElement> potentialTargets = ZDLUtil.findNamedElements(topLevelPackage.eResource(), sa.getValue());
													if(potentialTargets != null){
														for(NamedElement ne : potentialTargets){
															if(ZDLUtil.isZDLConcept(ne, SCANames.SCAEXECUTABLE_DEVICE_PART)){
																target = ne;
																//check if the part found is on the same node as the part whose deployondevice is being set 
																NamedElement targetContainerNode = (NamedElement) ZDLUtil.getValue(target, SCANames.SCAPART, SCANames.SCAPART__CONTAINER);
																if(targetContainerNode.equals(containerNode)){
																	ZDLUtil.setValue(e, SCANames.SCAPLATFORM_ELEMENT_PART, SCANames.SCAPLATFORM_ELEMENT_PART__DEPLOYONDEVICE, target);
																	nameResolved = true;
																	break;
																}
															}
														}
													}
												}else{																										
													//if it's not a qualified name, look for the name in the parts of the node
													if(ZDLUtil.isZDLConcept(containerNode, SCANames.SCANODE)){
														for(EObject partOnNode : (List<EObject>)ZDLUtil.getValue(containerNode, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__PART)){
															if(ZDLUtil.isZDLConcept(partOnNode, SCANames.SCAEXECUTABLE_DEVICE_PART)){																														
																if(((NamedElement)partOnNode).getName().equals(sa.getValue())){
																	ZDLUtil.setValue(e, SCANames.SCAPLATFORM_ELEMENT_PART, SCANames.SCAPLATFORM_ELEMENT_PART__DEPLOYONDEVICE, partOnNode);
																	nameResolved=true;
																	break;
																}															
															}
														}
													}
												}												
												if(nameResolved == true){
													continue;
												} else {
													ZDLUtil.setValue(e, SCANames.SCAPLATFORM_ELEMENT_PART, SCANames.SCAPLATFORM_ELEMENT_PART__DEPLOYONDEVICE, null);
													MessageFormat messageFormat = new MessageFormat(Messages.InvalidDeployOnDevice);
													Object[] args = {sa.getValue(), sa.getName(), cps.getName(), config.getName(), containerNode.getName()};
													String warning = messageFormat.format(args);											
													Activator.getDefault().warning(warning, null);
												}
											}
										} else if(ZDLUtil.isZDLConcept(e, SCANames.PROPERTY_PROVIDER)){
											if(sa.getName().equals(SCANames.PROPERTY_PROVIDER___PRFFILE_NAME)){
												ZDLUtil.setValue(e, SCANames.PROPERTY_PROVIDER, SCANames.PROPERTY_PROVIDER___PRFFILE_NAME, sa.getValue());
											}
											if(ZDLUtil.isZDLConcept(e, SCANames.SCAIMPLEMENTATION)){
												if(sa.getName().equals(SCANames.SCABINARY__FILE) || sa.getName().equals(SCANames.SCABINARY__PRIORITY)){
													EObject scaBinary = (EObject) ZDLUtil.getValue(e, SCANames.SCAIMPLEMENTATION, SCANames.SCAIMPLEMENTATION__CODE);
													if(scaBinary == null){
														scaBinary = (DynamicEObjectImpl) ZDLUtil.createZDLConcept(e, SCANames.SCAIMPLEMENTATION, SCANames.SCAIMPLEMENTATION__CODE, SCANames.SCABINARY);
													}
													if(sa.getName().equals(SCANames.SCABINARY__FILE)){
														ZDLUtil.setValue(scaBinary, SCANames.SCABINARY, SCANames.SCABINARY__FILE, sa.getValue());
													}else if(sa.getName().equals(SCANames.SCABINARY__PRIORITY)){
														ZDLUtil.setValue(scaBinary, SCANames.SCABINARY, SCANames.SCABINARY__PRIORITY, sa.getValue());	
													}
												}												
											}else if(ZDLUtil.isZDLConcept(e, SCANames.SCASOFTWARE_PACKAGE)){
												if(sa.getName().equals(SCANames.SCASOFTWARE_PACKAGE___SPDFILE_NAME)){
													ZDLUtil.setValue(e, SCANames.SCASOFTWARE_PACKAGE, SCANames.SCASOFTWARE_PACKAGE___SPDFILE_NAME, sa.getValue());
												}else if(sa.getName().equals(SCANames.SCANAMED_ELEMENT__NAME)){
													ZDLUtil.setValue(e, SCANames.SCANAMED_ELEMENT, SCANames.SCANAMED_ELEMENT__NAME, sa.getValue());
												}
											}else if(ZDLUtil.isZDLConcept(e, SCANames.SCACOMPONENT_INTERFACE)){
												if(sa.getName().equals(SCANames.SCACOMPONENT_INTERFACE___SCDFILE_NAME)){
													ZDLUtil.setValue(e, SCANames.SCACOMPONENT_INTERFACE, SCANames.SCACOMPONENT_INTERFACE___SCDFILE_NAME, sa.getValue());
												}
											}
										} else if(ZDLUtil.isZDLConcept(e, SCANames.SCAASSEMBLY)){
											if(ZDLUtil.isZDLConcept(e, SCANames.SCANODE)){
												if(sa.getName().equals(SCANames.SCANODE___DCDFILE_NAME)){
													ZDLUtil.setValue(e, SCANames.SCANODE, SCANames.SCANODE___DCDFILE_NAME, sa.getValue());
												}else if(sa.getName().equals(SCANames.SCANODE__NAMINGSERVICE)){
													ZDLUtil.setValue(e, SCANames.SCANODE, SCANames.SCANODE__NAMINGSERVICE, sa.getValue());
												}
											}else if(ZDLUtil.isZDLConcept(e, SCANames.SCAAPPLICATION)){
												if(sa.getName().equals(SCANames.SCAAPPLICATION___SADFILE_NAME)){
													ZDLUtil.setValue(e, SCANames.SCAAPPLICATION, SCANames.SCAAPPLICATION___SADFILE_NAME, sa.getValue());
												}
											}
										} else if(ZDLUtil.isZDLConcept(e, SCANames.SCAFREE_STANDING_PORT)){
											if(sa.getName().equals(SCANames.SCAFREE_STANDING_PORT__FINDBY_PORT_NAME)){
												ZDLUtil.setValue(e, SCANames.SCAFREE_STANDING_PORT, SCANames.SCAFREE_STANDING_PORT__FINDBY_PORT_NAME, sa.getValue());
											}
											if(ZDLUtil.isZDLConcept(e, SCANames.SCAFINDBY_FREE_STANDING_PORT)){
												ZDLUtil.setValue(e, SCANames.SCAFINDBY_FREE_STANDING_PORT, SCANames.SCAFINDBY_FREE_STANDING_PORT__FINDBY_ELEMENT_NAME, sa.getValue());
											}
										}
									}
								}
								break;
							}
						}
						break;
					}
				}
			}			
		}
		for( Element elementToDestroy : elementsToDestroy ) {
			destroy(elementToDestroy);
		}
	}
	
	/**
	 * Use a mark-and-sweep to figure out which elements in the target model are needed and get rid of the rest. 
	 * 
	 * @param topLevelPackage
	 * @param config
	 */
	private void pruneModel(Package topLevelPackage, String qName, int significantContext) {

		HashMap<EObject, Boolean> objectMap = new HashMap<EObject, Boolean>();
		NamedElement templateElement = null;
		if(significantContext==MODEL){
			if(qName.equals(((NamedElement)topLevelPackage).getQualifiedName())) {
				templateElement = (NamedElement)topLevelPackage;
			}
		}
		for (TreeIterator<EObject> iter = topLevelPackage.eAllContents(); iter.hasNext();) {
			EObject next = iter.next();
			if( isSignificantElement(next, significantContext)) {
				//mark for deletion
				objectMap.put(next, Boolean.FALSE);
			}
			boolean potentialCandidate = next instanceof NamedElement && qName.equals(((NamedElement)next).getQualifiedName());
			switch(significantContext){
				case APPLICATION:
					if( potentialCandidate && ZDLUtil.isZDLConcept(next, SCANames.SCAAPPLICATION)) {
						templateElement = (NamedElement)next;
					}
				case NODE:
					if( potentialCandidate && ZDLUtil.isZDLConcept(next, SCANames.SCANODE)) {
						templateElement = (NamedElement)next;
					}
				case PLATFORM:
					if( potentialCandidate && ZDLUtil.isZDLConcept(next, SCANames.SCAPLATFORM)) {
						templateElement = (NamedElement)next;
					}
				case MODEL:
				default:
					break;
			}
		}		
		
		ConfigurationElementVisitor visitor = new ConfigurationElementVisitor(objectMap, significantContext);
		
		visitor.markElementsForKeeping(templateElement);
 
		visitor.cleanUp(topLevelPackage);
		
		for(EObject element : objectMap.keySet()) {
			if( objectMap.get(element) == Boolean.FALSE) {
				System.out.println("Destroying element : " + element.toString()); //$NON-NLS-1$
				destroy(element);
			}
		}
	
		prunePackages(topLevelPackage);
		
	}

	/**
	 * Helper method to determine whether a given element is to be marked for potential
	 * destruction. This is a hand-coded set of ZDL concepts, which may or may not be
	 * "saved" by the mark and sweep, as well as any VariationPoint constraints, which
	 * are always destroyed.
	 * 
	 * @param e
	 * @return
	 */
	private boolean isSignificantElement(EObject e, int significantContext) {
		if(!(e instanceof Element)){
			return false;
		}else if(PLMUtil.isPLMConcept(e)){
			return true;
		}else{
			boolean significantContextReturn = (ZDLUtil.isZDLConcept(e, SCANames.SCAASSEMBLY) ||
					ZDLUtil.isZDLConcept(e, ZMLMMNames.COMPONENT_INTERFACE) ||
					ZDLUtil.isZDLConcept(e, ZMLMMNames.STRUCTURAL_REALIZATION) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAIMPLEMENTATION) ||
					ZDLUtil.isZDLConcept(e, ZMLMMNames.PORT_TYPE) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCADATA_TYPE) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAPLATFORM) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAPRIMITIVE)||
					ZDLUtil.isZDLConcept(e, SCANames.SCAPROPERTY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAPROPERTY_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAPROCESSOR) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAPROCESSOR_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAOPERATING_SYSTEM) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAOPERATING_SYSTEM_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCARUNTIME) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCARUNTIME_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAPROGRAMMING_LANGUAGE) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAPROGRAMMING_LANGUAGE_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCACOMPILER) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCACOMPILER_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAUSES_DEVICE) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAUSES_DEVICE_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.DMDSERVICE) ||
					ZDLUtil.isZDLConcept(e, SCANames.DMDSERVICE_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCADOMAIN) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCADOMAIN_DEPENDENCY) ||
					ZDLUtil.isZDLConcept(e, SCANames.SCAFREE_STANDING_PORT)
			);
					
			//TODO: other implementation-related objects. 
			switch(significantContext){
				case NODE:
					return (significantContextReturn);
				case PLATFORM:
					return (significantContextReturn);
				case APPLICATION:
					return (significantContextReturn);
				case MODEL:
					return (significantContextReturn);
				default:			
					return false;
			} 
		}
	}
	
	/**
	 * Prune any packages that are no longer needed after the mark-and-sweep. This is 
	 * defined as any empty package, and any package containing only a diagram (frequent
	 * result of component deletion).
	 * 
	 * @param topLevelPackage
	 */
	private void prunePackages(Package topLevelPackage) {
		HashSet<Package> packagesToDestroy = new HashSet<Package>();
		for (TreeIterator<EObject> iter = topLevelPackage.eAllContents(); iter.hasNext();) {
			EObject next = iter.next();			
			if( next instanceof Package ) {
				Package nextPackage = (Package)next;
				boolean toDestroy = true;
				for( PackageableElement pe : nextPackage.getPackagedElements()) {
					if( pe instanceof Diagram == false ) {
						toDestroy = false;
					}
				}
				if( toDestroy ) {
					packagesToDestroy.add(nextPackage);
				}
			}
		}
		for( Package p : packagesToDestroy) {
			destroy(p);
		}
	}
	
	/**
	 * Visitor class that marks elements as needed doing a traversal based on 
	 * SCA dependencies.
	 * 
	 * @author smcfee
	 *
	 */
	private class ConfigurationElementVisitor {
		
		private HashMap<EObject, Boolean> map;
		private final int visitContext;
		private HashMap<String, EObject> applications = new HashMap<String, EObject>();
		private HashMap<String, EObject> nodes = new HashMap<String, EObject>();
		private HashMap<String, EObject> platforms = new HashMap<String, EObject>();
		
		public ConfigurationElementVisitor(HashMap<EObject, Boolean> inputMap, int significantContext) {
			map = inputMap;
			visitContext=significantContext;
		}

		/**
		 * Clean up method to further mark up elements for deletion or retention
		 * based on the inverse relationships and the contents of the objectMap.
		 * 
		 * @param topLevelPackage
		 */
		public void cleanUp(Package topLevelPackage){
			for (TreeIterator<EObject> iter = topLevelPackage.eAllContents(); iter.hasNext();) {
				EObject next = iter.next();
				// Check for each concept, check if it has references to something specific				
				if(ZDLUtil.isZDLConcept(next, SCANames.SCAPRIMITIVE)){
					map.put(next, isConceptRetained(next, SCANames.SCAPROPERTY) || isConceptRetained(next, SCANames.SCAPROPERTY_DEPENDENCY));
				}
			}
		}

		/**
		 * Helper method to check if an element is to be kept based on the
		 * references stereotyped by a concept and their for retention status in
		 * the deletion map.
		 * 
		 * @param e - element whose retention status is to be calculated
		 * @param concept - Stereotype concept of the references to an element to verify 
		 * @return Whether an element should be retained
		 */
		public boolean isConceptRetained(EObject e, String concept){
			boolean keepElement = false;
			for(EObject reference : getReferences(e, concept)){
				Boolean keepReference = map.get(reference);
				if(keepReference ==null){
					map.put(reference, Boolean.TRUE);
					keepElement = keepElement || Boolean.TRUE;
				}else{
					keepElement = keepElement || keepReference;
				}
			}
			return keepElement;
		}
		
		/**
		 * Helper method to retrieve specific ZDL concept elements referencing an element passed 
		 * 
		 * @param element - element from which to get inverse references
		 * @param concept - ZDL concept of the object references that we are looking for
		 * @return list of objects referencing the element passed in 
		 */
		public List<EObject> getReferences(EObject element, String concept){
			List<EObject> references = new ArrayList<EObject>();
			for (Setting setting : UMLUtil.getInverseReferences(element)) {
				if (ZDLUtil.isZDLConcept(setting.getEObject(), concept)) {
					references.add(setting.getEObject());
				}
			}
			return references;
		}

		/**
		 * Helper method to check if an element has any references that are of the ZDL concept
		 * 
		 * @param element - element from which to get inverse references 
		 * @param concept - ZDL concept of the object references that we are looking for
		 * @return whether or not the element has any references of the ZDL concept
		 */
		public boolean hasReferences(EObject element, String concept){
			for (Setting setting : UMLUtil.getInverseReferences(element)) {
				if (ZDLUtil.isZDLConcept(setting.getEObject(), concept)) {
					return true;
				}
			}
			return false;
		}		
		
		/**
		 *  Helper method to mark the elements for keeping based on the visitContext
		 * 
		 * @param element
		 */
		public void markElementsForKeeping(EObject element){
			switch(visitContext){
				case PLATFORM:
				case APPLICATION:
				case NODE:
					visit(element);
					break;
				case MODEL:
					visitPackageables(element);
					for(Iterator<EObject> pfIter = platforms.values().iterator(); pfIter.hasNext();){
						visit(pfIter.next());
					}
					for(Iterator<EObject> nodeIter = nodes.values().iterator(); nodeIter.hasNext();){
						visit(nodeIter.next());
					}
					for(Iterator<EObject> appIter = applications.values().iterator(); appIter.hasNext();){
						visit(appIter.next());
					}
					break;
			}
		}

		/**
		 * Recursive helper method to visit the packageable elements to retrieve
		 * all of the SCAApplication, SCANode, and SCAPlatform elements for
		 * subsequent visit from the model level
		 * 
		 * @param eobject
		 */
		public void visitPackageables(EObject eobject){
			if(eobject instanceof Package){
				for(PackageableElement pe : ((Package)eobject).getPackagedElements()){
					visitPackageables(pe);
				}
				for(Package nestedPkg : ((Package)eobject).getNestedPackages()){
					visitPackageables(nestedPkg);
				}
			}else if(eobject instanceof PackageableElement){				
				if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAASSEMBLY)){
					String UUID = (String) ZDLUtil.getValue(eobject, SCANames.SCAIDENTIFIABLE, SCANames.SCAIDENTIFIABLE__ID);
					if(UUID != null){
						if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAAPPLICATION)){
							applications.put(UUID, eobject);
						}else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCANODE)){
							nodes.put(UUID, eobject);
						}
					}
				}else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAPLATFORM)){					
					platforms.put(((NamedElement)eobject).getName(), eobject);
				}
			}
		}

		/**
		 * Recursive method part of the "mark and sweep" pruning which visits
		 * all of the elements in a model of ZDL concept types which can be
		 * constrained by a variation point and recursively all of their
		 * referenced elements. If the element gets visited which is marked for
		 * deletion in the object map, it will get set to true.
		 * 
		 * If an element is reachable, then it should be kept, as the
		 * constrained elements from the variation points have been already
		 * deleted and their dangling references remain.
		 * 
		 * @param eobject
		 */
		@SuppressWarnings("unchecked")
		public void visit( EObject eobject ) {
			if( eobject == null ) {
				return;
			}
			
			if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAPLATFORM)){
				// For a platform, visit the components needed by its parts
				if(hasReferences(eobject, SCANames.SCANODE_PART)){
					map.put(eobject, Boolean.TRUE);
					for( EObject part : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAPLATFORM, SCANames.SCAPLATFORM__PART)){
						visit(ZDLUtil.getEValue(part, SCANames.SCANODE_PART, SCANames.SCANODE_PART__DEFINITION));
					}
				}
			} else if( ZDLUtil.isZDLConcept(eobject, SCANames.SCANODE)) {
				// For a node, visit the components needed by its parts via the their definition.
				// If visiting a node while generating from a model or a platform, verify that the Node contains at least one part. 
				// Otherwise don't traverse it. (No empty Nodes allowed)
				if(visitContext==MODEL){
					if(hasReferences(eobject, SCANames.SCAPLATFORM_ELEMENT_PART)){
						map.put(eobject, Boolean.TRUE);
						for( EObject part : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__PART)) {
							visit(ZDLUtil.getEValue(part, SCANames.SCAPART, SCANames.SCAPART__DEFINITION));
						}											
						for(EObject fsp : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__FSP)){
							visit(fsp);
						}
					}
				}else if(visitContext==PLATFORM){
					if(hasReferences(eobject, SCANames.SCAPART) && hasReferences(eobject, SCANames.SCANODE_PART)){
						map.put(eobject, Boolean.TRUE);
						for( EObject part : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__PART)) {
							visit(ZDLUtil.getEValue(part, SCANames.SCAPART, SCANames.SCAPART__DEFINITION));
						}
						for(EObject fsp : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__FSP)){
							visit(fsp);
						}
					}
				}
				// If visiting a node while generating from a node or an application, verify that there is at least one reference to
				// the Node in an application or that the Node contains at least one part. Otherwise don't traverse it. (No empty or unreferenced Nodes allowed)
				else if((visitContext==NODE && hasReferences(eobject, SCANames.SCAPLATFORM_ELEMENT_PART))
						|| (visitContext==APPLICATION && hasReferences(eobject, SCANames.SCACOMPONENT_PART))){
					map.put(eobject, Boolean.TRUE);
					for( EObject part : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__PART)) {
						visit(ZDLUtil.getEValue(part, SCANames.SCAPART, SCANames.SCAPART__DEFINITION));
					}			
					for(EObject fsp : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__FSP)){
						visit(fsp);
					}
					if(hasReferences(eobject, SCANames.SCAEXTERNAL_PORT)){
						map.put(eobject, Boolean.TRUE);
						for(EObject extp : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAAPPLICATION, SCANames.SCAAPPLICATION__EXTERNALPORT)){
							map.put(extp, Boolean.TRUE);
							visit((EObject)ZDLUtil.getValue(extp, ZMLMMNames.MESSAGE_PORT, ZMLMMNames.MESSAGE_PORT__TYPE));
						}
					}
				}
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAFREE_STANDING_PORT)){
				//If an FSP has any connectors attached to it, keep it.
				if(!((Port)eobject).getEnds().isEmpty()){
					map.put(eobject, Boolean.TRUE);
					EObject portTypeInterface = (EObject)ZDLUtil.getValue(eobject, ZMLMMNames.MESSAGE_PORT, ZMLMMNames.MESSAGE_PORT__TYPE); 
					if(portTypeInterface != null){						
						visit(portTypeInterface);	
					}					
				}
			} else if( ZDLUtil.isZDLConcept(eobject, SCANames.SCAAPPLICATION)) {
				// For an assembly (application), visit the components needed by its parts.
				// Make sure the application has at least one part before continuing
				if(hasReferences(eobject, SCANames.SCACOMPONENT_PART)){
					map.put(eobject, Boolean.TRUE);
					for( EObject part : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__PART)) {
						visit(ZDLUtil.getEValue(part, SCANames.SCAPART, SCANames.SCAPART__DEFINITION));
					}
				}
				if(hasReferences(eobject, SCANames.SCAFREE_STANDING_PORT)){
					map.put(eobject, Boolean.TRUE);
					for(EObject fsp : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAASSEMBLY, SCANames.SCAASSEMBLY__FSP)){
						visit(fsp);
					}
				}
				if(hasReferences(eobject, SCANames.SCAEXTERNAL_PORT)){
					map.put(eobject, Boolean.TRUE);
					for(EObject extp : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.SCAAPPLICATION, SCANames.SCAAPPLICATION__EXTERNALPORT)){
						map.put(extp, Boolean.TRUE);
						visit(ZDLUtil.getEValue(extp, ZMLMMNames.MESSAGE_PORT, ZMLMMNames.MESSAGE_PORT__TYPE));
					}
				}
			} else if( ZDLUtil.isZDLConcept(eobject, ZMLMMNames.STRUCTURAL_REALIZATION)) {
				// For a component/device, visit the interface, the implementations, the dependencies, and properties
				// If we visit an EObject, we need to keep it.
				map.put(eobject, Boolean.TRUE);
				visit(ZDLUtil.getEValue(eobject, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE));
				//visit the Implementations and dependencies
				for( Setting s : UML2Util.getInverseReferences(eobject)) {
					if( s.getEObject() instanceof Manifestation) {
						Manifestation m = (Manifestation)s.getEObject();	
						visit(m.getClients().get(0));
					} else if (hasReferences(eobject, SCANames.SCADEPENDENCY)){
						if(ZDLUtil.isZDLConcept(eobject, SCANames.SCACOMPONENT_REALIZATION)){
							// Get relationships for which the structural realization is the client
							for(Dependency dependency : ((Component)eobject).getClientDependencies()){
								for(NamedElement supplier : dependency.getSuppliers()){
									if(ZDLUtil.isZDLConcept(supplier, SCANames.SCAUSES_DEVICE)){
										map.put(dependency, Boolean.TRUE);
										visit(ZDLUtil.getEValue(dependency, SCANames.SCAUSES_DEVICE_DEPENDENCY, SCANames.SCAUSES_DEVICE_DEPENDENCY__DEPENDENCY));
									}  								
								}
							}
							// Get relationships for which the structural realization is the supplier
							for(Relationship relationship : ((Component)eobject).getRelationships()){
								if(relationship instanceof Dependency){
									for(NamedElement client : ((Dependency) relationship).getClients()){
										if(ZDLUtil.isZDLConcept(client, SCANames.SCADOMAIN)){
											map.put((Dependency)relationship, Boolean.TRUE);
											visit(ZDLUtil.getEValue((Dependency)relationship, SCANames.SCADOMAIN_DEPENDENCY, SCANames.SCADOMAIN_DEPENDENCY__DOMAIN));
										}
	//									else if(ZDLUtil.isZDLConcept(supplier, SCANames.SCARESOURCE_FACTORY)){
	//										visit(ZDLUtil.getEValue(dependency, SCANames.SCARESOURCE_FACTORY_DEPENDENCY, SCANames.SCARESOURCE_FACTORY_DEPENDENCY__S_CARESOURCE_FACTORY));
	//										//next SCAResourceFactory
	//									}
									}
								}
							} 						
						}
					}
				}
				for( EObject property : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.PROPERTY_PROVIDER, SCANames.PROPERTY_PROVIDER__PROPERTY)) {
					visit(property);
				}
				
			} else if( ZDLUtil.isZDLConcept(eobject, ZMLMMNames.COMPONENT_INTERFACE)) {
				// For a component interface, visit the port types and the properties.
				map.put(eobject, Boolean.TRUE);
				for( EObject port : (List<EObject>)ZDLUtil.getValue(eobject, ZMLMMNames.COMPONENT_INTERFACE, ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT)) {
					visit(ZDLUtil.getEValue(port, ZMLMMNames.MESSAGE_PORT, ZMLMMNames.MESSAGE_PORT__TYPE));
				}
				for( EObject property : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.PROPERTY_PROVIDER, SCANames.PROPERTY_PROVIDER__PROPERTY)) {
					visit(property);
				}
			} else if( ZDLUtil.isZDLConcept(eobject, SCANames.PROPERTY_PROVIDER)) {
				// For a component, component interface, or implementation, visit 
				// the property types, implementation dependencies, and properties.
				map.put(eobject, Boolean.TRUE);
				if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAIMPLEMENTATION)){
					if (hasReferences(eobject, SCANames.SCADEPENDENCY)){
						for(Dependency dependency : ((NamedElement)eobject).getClientDependencies()){
							map.put(dependency, Boolean.TRUE);
							for(NamedElement supplier : dependency.getSuppliers()){
								if(ZDLUtil.isZDLConcept(supplier, SCANames.SCAPROCESSOR)){
									visit(ZDLUtil.getEValue(dependency, SCANames.SCAPROCESSOR_DEPENDENCY, SCANames.SCAPROCESSOR_DEPENDENCY__PROCESSOR));
								} else if(ZDLUtil.isZDLConcept(supplier, SCANames.SCAOPERATING_SYSTEM)){
									visit(ZDLUtil.getEValue(dependency, SCANames.SCAOPERATING_SYSTEM_DEPENDENCY, SCANames.SCAOPERATING_SYSTEM_DEPENDENCY__OS));
								} else if(ZDLUtil.isZDLConcept(supplier, SCANames.SCARUNTIME)){
									visit(ZDLUtil.getEValue(dependency, SCANames.SCARUNTIME_DEPENDENCY, SCANames.SCARUNTIME_DEPENDENCY__RUNTIME));
								} else if(ZDLUtil.isZDLConcept(supplier, SCANames.SCAPROGRAMMING_LANGUAGE)){
									visit(ZDLUtil.getEValue(dependency, SCANames.SCAPROGRAMMING_LANGUAGE_DEPENDENCY, SCANames.SCAPROGRAMMING_LANGUAGE_DEPENDENCY__PROGRAMMINGLANGUAGE));
								} else if(ZDLUtil.isZDLConcept(supplier, SCANames.SCACOMPILER)){
									visit(ZDLUtil.getEValue(dependency, SCANames.SCACOMPILER_DEPENDENCY, SCANames.SCACOMPILER_DEPENDENCY__COMPILER));
								} 					
							}
						}
					}
				}
				for( EObject property : (List<EObject>)ZDLUtil.getValue(eobject, SCANames.PROPERTY_PROVIDER, SCANames.PROPERTY_PROVIDER__PROPERTY)) {
					visit(ZDLUtil.getEValue(property, SCANames.SCAPROPERTY, SCANames.SCAPROPERTY__TYPE));
					visit(property);
				}
			} else if(ZDLUtil.isZDLConcept(eobject, ZMLMMNames.PORT_TYPE)){
				if(hasReferences(eobject, SCANames.SCAPORT) || hasReferences(eobject, ZMLMMNames.MESSAGE_PORT) || hasReferences(eobject, SCANames.SCAFREE_STANDING_PORT)){
					map.put(eobject, Boolean.TRUE);
				}
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAPRIMITIVE)){
				map.put(eobject, Boolean.TRUE);
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCADATA_TYPE)){
				map.put(eobject, Boolean.TRUE);
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAPROPERTY)){
				map.put(eobject, Boolean.TRUE);
				visit(ZDLUtil.getEValue(eobject, SCANames.SCAPROPERTY, SCANames.SCAPROPERTY__TYPE));
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAUSES_DEVICE)){
				map.put(eobject, Boolean.TRUE);
				for(Dependency dependency : ((NamedElement)eobject).getClientDependencies()){
					for(NamedElement supplier : dependency.getSuppliers()){
						if(ZDLUtil.isZDLConcept(supplier, SCANames.SCAPRIMITIVE)){
							map.put(dependency, Boolean.TRUE);
							visit(ZDLUtil.getEValue(dependency, SCANames.SCAPROPERTY_DEPENDENCY, SCANames.SCAPROPERTY_DEPENDENCY__DEPENDENCY));
						}
					}
				}	
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCADOMAIN)){
				map.put(eobject, Boolean.TRUE);
				for(Dependency dependency : ((NamedElement)eobject).getClientDependencies()){
					for(NamedElement supplier : dependency.getSuppliers()){
						if(ZDLUtil.isZDLConcept(supplier, SCANames.DMDSERVICE)){
							map.put(dependency, Boolean.TRUE);
							visit(ZDLUtil.getEValue(dependency, SCANames.DMDSERVICE_DEPENDENCY, SCANames.DMDSERVICE_DEPENDENCY__DMD_SERVICE));
						}
					}
				}
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.DMDSERVICE)){
				map.put(eobject, Boolean.TRUE);
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAOPERATING_SYSTEM)){
				map.put(eobject, Boolean.TRUE);
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAPROGRAMMING_LANGUAGE)){
				map.put(eobject, Boolean.TRUE);
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCARUNTIME)){
				map.put(eobject, Boolean.TRUE);
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCACOMPILER)){
				map.put(eobject, Boolean.TRUE);
			} else if(ZDLUtil.isZDLConcept(eobject, SCANames.SCAPROCESSOR)){
				map.put(eobject, Boolean.TRUE);
			}
		}
	}
	
	/**
	 * Method to destroy elements in a consistent way across the class.
	 * 
	 * @param eobject
	 */
	private void destroy(EObject eobject) {
		UMLElementFactory.destroyElement(eobject, null);
	}
		
}
