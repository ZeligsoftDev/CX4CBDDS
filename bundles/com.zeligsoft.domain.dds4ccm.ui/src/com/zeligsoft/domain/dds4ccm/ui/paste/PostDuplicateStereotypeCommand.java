/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.paste;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Post stereotype duplicate command to set correct reference values
 * 
 * @author Young-Soo Roh
 *
 */
public class PostDuplicateStereotypeCommand extends RecordingCommand {

	protected Element element;

	protected EObject stereotypeApplication;

	protected Stereotype stereotypeInTargetContext;

	protected Map<String, Object> featureReferenceMap;

	public PostDuplicateStereotypeCommand(TransactionalEditingDomain domain, Element element, Element targetContainer,
			EObject stereotypeApplication, Map<String, Object> referenceMap) {
		super(domain);
		this.element = element;
		this.stereotypeApplication = stereotypeApplication;
		Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
		this.stereotypeInTargetContext = EMFHelper.reloadIntoContext(stereotype, targetContainer);
		this.featureReferenceMap = referenceMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doExecute() {
		EObject applyStereotype = element.getStereotypeApplication(stereotypeInTargetContext);
		if (null == applyStereotype) {
			// stereotype must be already applied
			return;
		}

		ResourceSet rset = element.eResource().getResourceSet();

		EList<EStructuralFeature> eStructuralFeatures = applyStereotype.eClass().getEAllStructuralFeatures();
		for (EStructuralFeature eStructuralFeature : eStructuralFeatures) {
			String name = eStructuralFeature.getName();
			if (!name.startsWith(Extension.METACLASS_ROLE_PREFIX) && eStructuralFeature.isChangeable()) {
				if (eStructuralFeature instanceof EReference && !((EReference) eStructuralFeature).isContainment()) {
					// Set correct value for the reference
					// applyStereotype.eSet(eStructuralFeature, featureReferenceMap.get(name));
					// This is another hack to load element in the correct resource set in case this
					// is a cross model copy
					Object value = featureReferenceMap.get(name);

					if (value instanceof EObject) {
						Optional<EStructuralFeature> baseFeature = ((EObject) value).eClass()
								.getEAllStructuralFeatures().stream()
								.filter(f -> f.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)).findAny();

						if (baseFeature.isPresent()) {
							// stereotype application
							EObject baseElement = (EObject) ((EObject) value).eGet(baseFeature.get());
							if (baseElement.eResource() != null) {
								URI sourceURI = EcoreUtil.getURI(baseElement);
								baseElement = rset.getEObject(sourceURI, true);
							}
							EObject stApp = ((Element) baseElement).getStereotypeApplications().get(0);
							applyStereotype.eSet(eStructuralFeature, stApp);

						} else {
							EObject ref = (EObject) value;
							if (ref.eResource() != null) {
								// load element in the target resource set
								URI sourceURI = EcoreUtil.getURI(ref);
								value = rset.getEObject(sourceURI, true);
							}
						}
					} else if (value instanceof List) {
						EList<EObject> listInTargetContext = new BasicEList<EObject>();
						for (EObject val : (List<EObject>) value) {
							Optional<EStructuralFeature> baseFeature = val.eClass().getEAllStructuralFeatures().stream()
									.filter(f -> f.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)).findAny();

							if (baseFeature.isPresent()) {
								// stereotype application
								EObject baseElement = (EObject) val.eGet(baseFeature.get());
								if (baseElement.eResource() != null) {
									URI sourceURI = EcoreUtil.getURI(baseElement);
									baseElement = rset.getEObject(sourceURI, true);
								}
								val = ((Element) baseElement).getStereotypeApplications().get(0);
								listInTargetContext.add(val);

							} else {
								if (val.eResource() != null) {
									// load element in the target resource set
									URI sourceURI = EcoreUtil.getURI(val);
									listInTargetContext.add(rset.getEObject(sourceURI, true));
								} else {
									listInTargetContext.add(val);
								}
							}
						}
						applyStereotype.eSet(eStructuralFeature, listInTargetContext);
					}
				}
			}
		}
	}
}
