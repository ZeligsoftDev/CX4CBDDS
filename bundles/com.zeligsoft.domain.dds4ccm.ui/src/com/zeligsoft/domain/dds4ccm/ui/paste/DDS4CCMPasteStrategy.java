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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.infra.core.clipboard.IClipboardAdditionalData;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.AbstractPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.DefaultPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ui.Activator;

/**
 * Offer a strategy for copying DDS4CCM concepts.
 * 
 * @author Young-Soo
 *
 */
public class DDS4CCMPasteStrategy extends AbstractPasteStrategy implements IPasteStrategy {

	/** The instance. */
	private static IPasteStrategy instance = new DDS4CCMPasteStrategy();

	/**
	 * Gets the single instance of DDS4CCMPasteStrategy.
	 *
	 * @return single instance of DDS4CCMPasteStrategy
	 */
	public static IPasteStrategy getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getLabel()
	 */
	@Override
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
	@Override
	public String getID() {
		return Activator.PLUGIN_ID + ".CXPasteStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getDescription()
	 */
	@Override
	public String getDescription() {
		return "CX Paste Strategy"; //$NON-NLS-1$
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

	@Override
	public int getPriority() {
		// Making sure that DDS4CCM paste strategy runs after the
		// <code>StereotypePasteStrategy</code>
		return 100;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getSemanticCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.emf.ecore.EObject,
	 * org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public org.eclipse.emf.common.command.Command getSemanticCommand(EditingDomain domain, EObject targetOwner,
			PapyrusClipboard<Object> papyrusClipboard) {
		if (targetOwner instanceof Element) {
			Map<Object, ?> additionalDataMap = papyrusClipboard.getAdditionalDataForStrategy(getID());
			if (additionalDataMap == null || additionalDataMap.isEmpty()) {
				// nothing to do
				return null;
			}
			CompoundCommand compoundCommand = new CompoundCommand("Copy ZDL concepts");
			for (Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				// get target Element
				EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
				Object additionalData = additionalDataMap.get(object);
				if (!(target instanceof Element) || !(additionalData instanceof ZDLConceptClipboard)) {
					continue;
				}
				ZDLConceptClipboard data = (ZDLConceptClipboard) additionalData;
				Map<Property, Object> valueMap = new HashMap<Property, Object>();
				for (Entry<Property, Object> entry : data.getFeatureValueMap().entrySet()) {
					Property feature = entry.getKey();
					Object value = entry.getValue();
					if (feature.isMultivalued()) {
						List<Object> copyList = new ArrayList<Object>();
						for (Object referencedObject : ((List<?>) value)) {
							Object copyReferencedObject = papyrusClipboard
									.getTragetCopyFromInternalClipboardCopy(referencedObject);
							if (copyReferencedObject != null) {
								copyList.add(copyReferencedObject);
							} else {
								copyList.add(referencedObject);
							}
						}
						value = copyList;
					} else {
						Object copyReferencedObject = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(value);
						if (copyReferencedObject != null) {
							value = copyReferencedObject;
						}
					}
					valueMap.put(feature, value);
				}
				DuplicateZDLConceptCommand command = new DuplicateZDLConceptCommand((TransactionalEditingDomain) domain,
						(Element) target, data.getConcept(), valueMap);
				compoundCommand.append(command);
			}

			if (compoundCommand.getCommandList().isEmpty()) {
				// empty command is not executable
				return null;
			}
			return compoundCommand;
		}
		return null;

	}

	@Override
	public org.eclipse.gef.commands.Command getGraphicalCommand(EditingDomain domain, GraphicalEditPart targetEditPart,
			PapyrusClipboard<Object> papyrusClipboard) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * prepare(org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public void prepare(PapyrusClipboard<Object> papyrusClipboard, Collection<EObject> selection) {

		Map<Object, IClipboardAdditionalData> mapCopyToConcept = new HashMap<>();

		for (Iterator<EObject> iterator = papyrusClipboard.iterateOnSource(); iterator.hasNext();) {
			EObject eObject = iterator.next();
			EObject copyEObject = (EObject) papyrusClipboard.getCopyFromSource(eObject);
			Class concept = ZDLUtil.getZDLConcept(eObject);
			if (concept == null) {
				continue;
			}

			ZDLConceptClipboard zdlClipboard = new ZDLConceptClipboard(copyEObject, concept);
			for (Property feature : concept.getAllAttributes()) {
				if (!feature.isReadOnly() && !feature.isDerived()) {
					Object eObjectValue = ZDLUtil.getValue(eObject, concept, feature.getName());
					if (feature.isComposite()) {
						// handle containment reference value as this is not handled properly by
						// <code>StereotypePasteStrategy</code>
						EStructuralFeature eFeature = ZDLUtil.getPropertyMapping(feature, eObject);
						if (!(eFeature instanceof EReference) || !((EReference) eFeature).isContainment()) {
							continue;
						}
					}
					if (feature.isMultivalued() && !((List<?>) eObjectValue).isEmpty()) {
						List<Object> copyList = new ArrayList<Object>();
						List<?> listValue = (List<?>) eObjectValue;
						if (listValue.stream().allMatch(v -> v instanceof EObject)) {
							for (Object referencedObject : listValue) {
								if (feature.isComposite()) {
									// make a copy of containment value
									copyList.add(EcoreUtil.copy((EObject) referencedObject));
								} else {
									Object copyReferencedEObject = papyrusClipboard
											.getCopyFromSource((EObject) referencedObject);
									if (copyReferencedEObject == null) {
										copyList.add(referencedObject);
									} else {
										copyList.add(copyReferencedEObject);
									}
								}
							}
							zdlClipboard.addFeatureValue(feature, copyList);
						}
					} else {
						if (eObjectValue instanceof EObject) {
							if (feature.isComposite()) {
								// make a copy of containment feature
								zdlClipboard.addFeatureValue(feature, EcoreUtil.copy((EObject) eObjectValue));
							} else {
								Object copyReferencedEObject = papyrusClipboard
										.getCopyFromSource((EObject) eObjectValue);
								if (copyReferencedEObject != null) {
									zdlClipboard.addFeatureValue(feature, copyReferencedEObject);
								} else {
									zdlClipboard.addFeatureValue(feature, eObjectValue);
								}
							}
						}
					}
				}
			}
			if (!zdlClipboard.getFeatureValueMap().isEmpty()) {
				mapCopyToConcept.put(copyEObject, zdlClipboard);
			}
		}
		papyrusClipboard.pushAdditionalData(getID(), mapCopyToConcept);
	}

	/**
	 * Clipboard data for ZDL Concept
	 * 
	 * @author Young-Soo
	 *
	 */
	protected class ZDLConceptClipboard implements IClipboardAdditionalData {

		/** The stereotype applications. */
		protected Class concept;
		protected EObject element;
		protected Map<Property, Object> featureValueMap = new HashMap<Property, Object>();

		public ZDLConceptClipboard(EObject element, Class concept) {
			this.concept = concept;
			this.element = element;
		}

		public void addFeatureValue(Property feature, Object value) {
			featureValueMap.put(feature, value);
		}

		public Class getConcept() {
			return concept;
		}

		public EObject getElement() {
			return element;
		}

		public Map<Property, Object> getFeatureValueMap() {
			return featureValueMap;
		}

	}
}
