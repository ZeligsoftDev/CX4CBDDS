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

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.clipboard.IClipboardAdditionalData;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.AbstractPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.DefaultPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;

import com.zeligsoft.domain.dds4ccm.ui.Activator;

/**
 * Post stereotype paste strategy to work around the Papyrus issue with
 * copy/paste. See https://bugs.eclipse.org/bugs/show_bug.cgi?id=552410
 * 
 * @author Young-Soo Roh
 *
 */
public class PostStereotypePasteStrategy extends AbstractPasteStrategy implements IPasteStrategy {

	private static IPasteStrategy instance = new PostStereotypePasteStrategy();

	public static IPasteStrategy getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getLabel()
	 */
	public String getLabel() {
		return "CXStereotypeStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getID(
	 * )
	 */
	public String getID() {
		return Activator.PLUGIN_ID + ".StereotypeStrategy"; // ".ClassifierToStructureCompDrop"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getDescription()
	 */
	public String getDescription() {
		return "Paste CX stereotype elements"; //$NON-NLS-1$
	}

	@Override
	public int getPriority() {
		// Set the priority to below the normal stereotype paste strategy
		return 100;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * dependsOn()
	 */
	@Override
	public IPasteStrategy dependsOn() {
		return DefaultPasteStrategy.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getSemanticCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.emf.ecore.EObject,
	 * org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public org.eclipse.emf.common.command.Command getSemanticCommand(EditingDomain domain, EObject targetOwner,
			PapyrusClipboard<Object> papyrusClipboard) {

		if (targetOwner instanceof Element) {
			CompoundCommand compoundCommand = new CompoundCommand("Copy references for stereotypes"); //$NON-NLS-1$

			for (Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				// get target Element
				EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
				if (target != null && target instanceof Element) {
					// Get StereotypeReferenceClipboard
					Map<Object, ?> additionalDataMap = papyrusClipboard.getAdditionalDataForStrategy(getID());
					Object additionnalData = additionalDataMap.get(object);
					if (additionnalData instanceof StereotypeReferenceClipboard) {
						StereotypeReferenceClipboard stereotypeClipboard = (StereotypeReferenceClipboard) additionnalData;
						Collection<EObject> stereotypeApplications = stereotypeClipboard.getstereotypeApplications();
						for (EObject stereotypeApplication : stereotypeApplications) {

							Map<String, Object> stRefMap = stereotypeClipboard
									.getStereotypeReferenceMap(stereotypeApplication);
							Map<String, Object> stereotypeReferenceMap = new HashMap<String, Object>();

							// for each reference we need to check if copied target exists
							for (Map.Entry<String, Object> entry : stRefMap.entrySet()) {
								String featureName = entry.getKey();
								Object value = entry.getValue();
								if (value instanceof EObject) {
									List<EStructuralFeature> baseFeatures = ((EObject) value).eClass()
											.getEAllStructuralFeatures().stream()
											.filter(f -> f.getName().startsWith(Extension.METACLASS_ROLE_PREFIX))
											.collect(Collectors.toList());

									if (!baseFeatures.isEmpty()) {
										// stereotype application
										for (EStructuralFeature baseFeature : baseFeatures) {

											Object baseElement = ((EObject) value).eGet(baseFeature);
											Object baseElementCopy = papyrusClipboard
													.getTragetCopyFromInternalClipboardCopy(baseElement);
											if (baseElementCopy != null) {
												((EObject) value).eSet(baseFeature, baseElementCopy);
											}
										}
										stereotypeReferenceMap.put(featureName, value);
									} else {
										EObject realRef = papyrusClipboard
												.getTragetCopyFromInternalClipboardCopy(value);
										if (realRef == null) {
											// We didn't find the copy of this reference target
											// so keep the original value
											realRef = (EObject) value;
										}
										stereotypeReferenceMap.put(featureName, realRef);
									}
								} else {
									EList<EObject> copyList = new BasicEList<EObject>();
									for (EObject referencedObject : ((EList<EObject>) value)) {
										List<EStructuralFeature> baseFeatures = referencedObject.eClass()
												.getEAllStructuralFeatures().stream()
												.filter(f -> f.getName().startsWith(Extension.METACLASS_ROLE_PREFIX))
												.collect(Collectors.toList());

										if (!baseFeatures.isEmpty()) {
											// stereotype application
											for (EStructuralFeature baseFeature : baseFeatures) {
												// stereotype application
												Object baseElement = referencedObject.eGet(baseFeature);
												Object baseElementCopy = papyrusClipboard
														.getTragetCopyFromInternalClipboardCopy(baseElement);
												if (baseElementCopy != null) {
													referencedObject.eSet(baseFeature, baseElementCopy);
												}
											}
											copyList.add(referencedObject);
										} else {
											EObject realRef = papyrusClipboard
													.getTragetCopyFromInternalClipboardCopy(referencedObject);
											if (realRef == null) {
												// We didn't find the copy of this reference target
												// so keep the original value
												realRef = referencedObject;
											}
											copyList.add(referencedObject);
										}
									}
									stereotypeReferenceMap.put(featureName, copyList);
								}
							}

							PostDuplicateStereotypeCommand applyStereotypeCommand = new PostDuplicateStereotypeCommand(
									(TransactionalEditingDomain) domain, (Element) target, (Element) targetOwner,
									stereotypeApplication, stereotypeReferenceMap);
							compoundCommand.append(applyStereotypeCommand);
						}
					}
				}
			}

			if (compoundCommand.getCommandList().isEmpty()) {
				return null;
			}
			return compoundCommand;
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * prepare(org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void prepare(PapyrusClipboard<Object> papyrusClipboard, Collection<EObject> selection) {
		Map<Object, IClipboardAdditionalData> mapCopyToStereotypeData = new HashMap<Object, IClipboardAdditionalData>();
		for (Iterator<EObject> iterator = papyrusClipboard.iterateOnSource(); iterator.hasNext();) {
			EObject eObjectSource = (EObject) iterator.next();
			if (eObjectSource instanceof Element) {
				Element element = (Element) eObjectSource;
				EList<EObject> stereotypeApplications = element.getStereotypeApplications();
				if (stereotypeApplications != null && !stereotypeApplications.isEmpty()) {
					StereotypeReferenceClipboard stereotypeClipboard = new StereotypeReferenceClipboard(
							stereotypeApplications);
					Object copy = papyrusClipboard.getCopyFromSource(eObjectSource);
					mapCopyToStereotypeData.put(copy, stereotypeClipboard);
					// prepare to solve reference copy issue.
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=561667
					// For each stereotype we need to build a feature to references map
					for (EObject stereotypeApplication : stereotypeApplications) {
						EObject appliedStereotype = stereotypeApplication;
						Map<String, Object> featureReferencesMap = new HashMap<String, Object>();
						EList<EStructuralFeature> eStructuralFeatures = appliedStereotype.eClass()
								.getEAllStructuralFeatures();
						for (EStructuralFeature eStructuralFeature : eStructuralFeatures) {
							String name = eStructuralFeature.getName();
							if (!name.startsWith(Extension.METACLASS_ROLE_PREFIX)
									&& eStructuralFeature.isChangeable()) {
								if (eStructuralFeature instanceof EReference
										&& !((EReference) eStructuralFeature).isContainment()) {
									// create a feature to reference map
									Object value = stereotypeApplication.eGet(eStructuralFeature);
									if (value instanceof EObject) {
										List<EStructuralFeature> baseFeatures = ((EObject) value).eClass()
												.getEAllStructuralFeatures().stream()
												.filter(f -> f.getName().startsWith(Extension.METACLASS_ROLE_PREFIX))
												.collect(Collectors.toList());
										if (!baseFeatures.isEmpty()) {
											EObject valCopy = EcoreUtil.copy((EObject) value);
											for (EStructuralFeature baseFeature : baseFeatures) {
												// this is stereotype application
												// copy it and set the base element to the copy of reference
												Object baseElement = ((EObject) valCopy).eGet(baseFeature);
												Object baseElementCopy = papyrusClipboard
														.getCopyFromSource((EObject) baseElement);
												if (baseElementCopy != null) {
													valCopy.eSet(baseFeature, baseElementCopy);
												}
											}
											featureReferencesMap.put(name, valCopy);

										} else {
											Object reference = papyrusClipboard.getCopyFromSource((EObject) value);
											if (reference == null) {
												reference = (EObject) value;
											}
											featureReferencesMap.put(name, reference);
										}
									} else if (value instanceof Collection<?>) {
										Collection<?> listValue = (Collection<?>) value;
										if (listValue.stream().allMatch(v -> v instanceof EObject)) {
											EList<EObject> list = new BasicEList<EObject>();
											for (EObject val : (List<EObject>) listValue) {
												List<EStructuralFeature> baseFeatures = val.eClass()
														.getEAllStructuralFeatures().stream()
														.filter(f -> f.getName()
																.startsWith(Extension.METACLASS_ROLE_PREFIX))
														.collect(Collectors.toList());
												if (!baseFeatures.isEmpty()) {
													// this is stereotype application
													// copy it and set the base element to the copy of reference
													EObject valCopy = EcoreUtil.copy(val);
													for (EStructuralFeature baseFeature : baseFeatures) {
														Object baseElement = valCopy.eGet(baseFeature);
														Object baseElementCopy = papyrusClipboard
																.getCopyFromSource((EObject) baseElement);
														if (baseElementCopy != null) {
															valCopy.eSet(baseFeature, baseElementCopy);
														}
													}
													list.add(valCopy);
												} else {
													Object reference = papyrusClipboard
															.getCopyFromSource((EObject) val);
													if (reference == null) {
														reference = (EObject) val;
													}
													list.add((EObject) reference);
												}
											}
											featureReferencesMap.put(name, list);
										}
									}
								}
							}
						}

						stereotypeClipboard.addStereotypeReferenceMap(appliedStereotype, featureReferencesMap);
					}
				}
			}
		}
		papyrusClipboard.pushAdditionalData(getID(), mapCopyToStereotypeData);
	}

	/**
	 * Stereotype to reference map clipboard
	 * 
	 * @author Young-Soo Roh
	 *
	 */
	protected class StereotypeReferenceClipboard implements IClipboardAdditionalData {

		protected Collection<EObject> stereotypeApplications;

		protected Map<EObject, Map<String, Object>> stereotypeReferenceMap = new HashMap<EObject, Map<String, Object>>();

		public StereotypeReferenceClipboard(Collection<EObject> stereotypeApplications) {
			this.stereotypeApplications = stereotypeApplications;
		}

		public Collection<EObject> getstereotypeApplications() {
			return stereotypeApplications;
		}

		public void addStereotypeReferenceMap(EObject stApplication, Map<String, Object> refMap) {
			stereotypeReferenceMap.put(stApplication, refMap);
		}

		public Map<String, Object> getStereotypeReferenceMap(EObject stApplication) {
			return stereotypeReferenceMap.get(stApplication);
		}

	}

}
