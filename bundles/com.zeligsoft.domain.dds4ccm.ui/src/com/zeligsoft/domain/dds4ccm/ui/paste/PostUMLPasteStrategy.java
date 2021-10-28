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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEList.UnmodifiableEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.AbstractPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.DefaultPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.domain.dds4ccm.ui.Activator;

/**
 * Post UML paste strategy to load reference value in the right context
 * 
 * @author Young-Soo Roh
 *
 */
public class PostUMLPasteStrategy extends AbstractPasteStrategy implements IPasteStrategy {

	/** The instance. */
	private static IPasteStrategy instance = new PostUMLPasteStrategy();

	private static List<EClass> eClassToIgnore = new ArrayList<EClass>(
			Arrays.asList(EcorePackage.Literals.EMODEL_ELEMENT, UMLPackage.Literals.PACKAGE,
					UMLPackage.Literals.ELEMENT, UMLPackage.Literals.NAMED_ELEMENT, UMLPackage.Literals.COMMENT));

	/**
	 * Gets the single instance of PostUMLPasteStrategy.
	 *
	 * @return single instance of PostUMLPasteStrategy
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
		return "PostUMLPasteStrategy"; //$NON-NLS-1$
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
		return Activator.PLUGIN_ID + ".PostUMLPasteStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getDescription()
	 */
	@Override
	public String getDescription() {
		return "Post UML Paste Strategy"; //$NON-NLS-1$
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
		// This strategy runs after the <code>StereotypePasteStrategy</code>
		// but before PostStereotypePasteStrategy
		return 99;
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
			List<Element> elements = new ArrayList<Element>();
			for (Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				if (object instanceof Element && !(object instanceof Package)) {
					// get target Element
					EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
					elements.add((Element) target);
				}
			}

			if (elements.isEmpty()) {
				return null;
			}
			
			RecordingCommand command = new RecordingCommand(TransactionUtil.getEditingDomain(targetOwner)) {

				@SuppressWarnings({ "unchecked", "rawtypes" })
				@Override
				protected void doExecute() {
					ResourceSet rset = targetOwner.eResource().getResourceSet();
					for (Element element : elements) {

						if (eClassToIgnore.contains(element.eClass())) {
							continue;
						}
						// special case to preserve the following value
						// UMLPackage.Literals.INTERFACE_REALIZATION__CONTRACT
						if (element instanceof InterfaceRealization) {
							InterfaceRealization ir = (InterfaceRealization) element;
							EObject ref = ir.getContract();
							if (ref.eResource() != null && ref.eResource().getResourceSet() != rset) {
								// load element in the target resource set
								URI sourceURI = EcoreUtil.getURI(ref);
								ref = rset.getEObject(sourceURI, true);
								ir.getSuppliers().clear();
								ir.setContract((Interface) ref);
							}
							continue;
						}

						// take care of all other references
						for (EStructuralFeature eStructuralFeature : element.eClass().getEAllStructuralFeatures()) {
							// check if this efeature is comming from one of the ignored list
							if (eClassToIgnore.contains(eStructuralFeature.eContainer())) {
								continue;
							}
							String name = eStructuralFeature.getName();
							if (!name.startsWith(Extension.METACLASS_ROLE_PREFIX) && eStructuralFeature.isChangeable()
									&& eStructuralFeature instanceof EReference
									&& !((EReference) eStructuralFeature).isContainment()) {

								Object value = element.eGet(eStructuralFeature);
								if (value instanceof EObject) {
									EObject ref = (EObject) value;
									if (ref.eResource() != null && ref.eResource().getResourceSet() != rset) {
										// load element in the target resource set
										URI sourceURI = EcoreUtil.getURI(ref);
										ref = rset.getEObject(sourceURI, true);
										element.eSet(eStructuralFeature, ref);
									}
								} else if (value instanceof List && !((List) value).isEmpty()
										&& !(value instanceof UnmodifiableEList)) {
									if (((List) value).stream().allMatch(v -> v instanceof EObject)) {
										EList<EObject> listInTargetContext = new BasicEList<EObject>();
										boolean externalResourceFound = false;
										for (EObject val : (List<EObject>) value) {
											if (val.eResource() != null && val.eResource().getResourceSet() != rset) {
												// load element in the target resource set
												URI sourceURI = EcoreUtil.getURI(val);
												listInTargetContext.add(rset.getEObject(sourceURI, true));
												externalResourceFound = true;
											} else {
												listInTargetContext.add(val);
											}
										}
										if (externalResourceFound) {
											element.eSet(eStructuralFeature, listInTargetContext);
										}
									}
								}
							}
						}
					}
				}
			};

			return command;
		}
		return null;

	}

	@Override
	public org.eclipse.gef.commands.Command getGraphicalCommand(EditingDomain domain, GraphicalEditPart targetEditPart,
			PapyrusClipboard<Object> papyrusClipboard) {
		return null;
	}

}