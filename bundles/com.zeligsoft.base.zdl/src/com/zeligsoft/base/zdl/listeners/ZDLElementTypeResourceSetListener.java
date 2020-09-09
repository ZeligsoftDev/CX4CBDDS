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

package com.zeligsoft.base.zdl.listeners;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.type.ZDLElementType;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.util.ZDLUtil;
//import com.zeligsoft.base.zdl.xtend.MainTransform;

/**
 * ResourceSetListener which creates ZDLElementTypes when ZDL generated profiles
 * are loaded. It also creates the specialization types for use with the
 * <code>Element Helper</code> framework.
 * 
 * @author jcorchis
 * 
 */
public class ZDLElementTypeResourceSetListener
		extends ResourceSetListenerImpl {

	/**
	 * Create a new instance of me, with the
	 * {@link NotificationFilter#RESOURCE_LOADED} as my listener filter.
	 */
	public ZDLElementTypeResourceSetListener() {
		super(NotificationFilter.RESOURCE_LOADED);
	}

	/**
	 * Processes the loading of ZDL based model, by dynamically creating the
	 * corresponding IElementTypes defined or referenced by the give profile.
	 */
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {

		Iterator<Notification> iterator = event.getNotifications().iterator();
		while (iterator.hasNext()) {
			Notification notification = iterator.next();
			Object notifier = notification.getNotifier();

			if (NotificationFilter.RESOURCE_LOADED.matches(notification)) {
				Resource res = (Resource) notifier;
				org.eclipse.uml2.uml.Package zdlModel = (org.eclipse.uml2.uml.Package) EcoreUtil
					.getObjectByType(res.getContents(),
						UMLPackage.Literals.PACKAGE);
						
				if (zdlModel == null) {
					// Not a UML resource
					continue;
				}

				Collection<Profile> zdlProfiles = ZDLUtil
					.getZDLProfiles(zdlModel);

				Iterator<Profile> i = zdlProfiles.iterator();
				while (i.hasNext()) {
					Profile profile = i.next();
//					ResourceSet rset = new ResourceSetImpl();
//					Resource umlElementType = rset.getResource(URI.createURI("platform:/plugin/org.eclipse.papyrus.uml.service.types/model/uml.elementtypesconfigurations"), true);
//					MainTransform translator = new MainTransform();
//					Resource resource = rset.getResource(URI.createURI("platform:/resource/com.zeligsoft.domain.cbdds.architecture/elementtypes/" + profile.getName() + ".elementtypesconfigurations"), true);
//					ElementTypeSetConfiguration config;
//					if(resource.getContents().isEmpty()) {
//						config = ElementTypesConfigurationsFactory.eINSTANCE.createElementTypeSetConfiguration();
//						resource.getContents().add(config);
//					}else {
//						config = (ElementTypeSetConfiguration) resource.getContents().get(0);
//					}
//					translator.mainTransform(profile, (ElementTypeSetConfiguration)umlElementType.getContents().get(0), config);
//					try {
//						resource.save(Collections.EMPTY_MAP);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}
		}
	}

	/**
	 * Traverses the ZDL generated profile and registers its concepts as
	 * ZDLElementTypes. It also registers, for use with the Element Type
	 * framework, specialization types which extend the ZDLElementTypes and UML
	 * meta-model types, based on the Stereotypes found in the profile.
	 * 
	 * @param profile
	 *            the profile which provides the IClientContext for the created
	 *            ZDLElementTypes.
	 */
	private void registerZDLElementTypes(Profile profile) {

		TreeIterator<EObject> iter = profile.eAllContents();
		IClientContext clientCtx = ClientContextManager.getInstance()
			.getClientContextFor(profile);

		while (iter.hasNext()) {
			EObject next = iter.next();

			if (next instanceof Stereotype) {
				Stereotype stereotype = (Stereotype) next;

				List<NamedElement> zdlDefs = ZDLUtil
					.getZDLDefinition(stereotype);

				for (int i = 0; i < zdlDefs.size(); i++) {

					NamedElement namedElement = zdlDefs.get(i);

					if (namedElement instanceof Class) {
						Class concept = (Class) namedElement;
						Class metaclass = ZDLUtil.getBaseMetaclass(profile,
							(Class) zdlDefs.get(i));

						if (metaclass != null) {

							EClass eclass = (EClass) UMLPackage.eINSTANCE
								.getEClassifier(metaclass.getName());

							IElementType umlType = ElementTypeRegistry
								.getInstance()
								.getElementType(eclass, clientCtx);

							// Create concept ZDLElementType
							ZDLElementType zdlType = (ZDLElementType) ZDLElementTypeManager.INSTANCE
								.getElementType(concept);

							// Create SpecializationType useful for tooling
							ZDLElementTypeManager.INSTANCE.getStereotypeType(
								zdlType, umlType, stereotype);

							// Create property reference ZDLElementTypes
							for (Property thisProperty : concept
								.getOwnedAttributes()) {
								if (isSourceForDomainReference(thisProperty)) {
									ZDLElementTypeManager.INSTANCE
										.getElementType(concept, thisProperty);
								}
							}

						}
					}
				}
			} else if (next instanceof EAnnotation) {
				// ignore palette tooling model for now
//				EAnnotation annotation = (EAnnotation) next;
//				if (ToolingModelPackage.eNS_URI.equals(annotation.getSource())) {
//
//					// Generation any specialized palette tooling types
//					TreeIterator<EObject> i = annotation.eAllContents();
//					while (i.hasNext()) {
//						EObject eObject = i.next();
//						if (eObject instanceof CreationTool) {
//							CreationTool creationTool = (CreationTool) eObject;
//							String hint = creationTool.getElementTypeHint();
//							Class conceptClass = creationTool.getConcept();
//
//							if (!UML2Util.isEmpty(hint) && conceptClass != null) {
//								ZDLElementType zdlType = (ZDLElementType) ZDLElementTypeManager.INSTANCE
//									.getElementType(creationTool.getConcept());
//								Stereotype stereotype = (Stereotype) ZDLUtil
//									.getProfileClass(profile, conceptClass);
//								if (stereotype != null) {
//									// Concept not mapped to a Stereotype?
//									ZDLElementTypeManager.INSTANCE
//										.getHintedStereotypedType(zdlType, hint,
//											stereotype);
//								}
//							}
//						}
//					}
//				}
			} else if (next instanceof org.eclipse.uml2.uml.Class) {
				// TODO: Handle profile classes, when supported.

			}
		}
	}

	/**
	 * Determines if this stereotype property traces to a source end of a
	 * DomainReference.
	 * 
	 * @param thisProperty
	 * @return
	 */
	private boolean isSourceForDomainReference(Property thisProperty) {
        boolean result = false;
        if (thisProperty.getAssociation() != null) {
            Association association = thisProperty.getAssociation();
		
            result = !(association instanceof Extension);
        }
        return result;
	}
}
