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

package com.zeligsoft.base.ui.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderPolicy;
import org.eclipse.gmf.runtime.emf.ui.services.action.AbstractModelActionFilterProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Action filter which provides action clients with access to determining if an
 * element is a particular ZDLConcept.
 * 
 * 
 * @author jcorchis
 * 
 */
public class ZDLActionFilterProvider
		extends AbstractModelActionFilterProvider
		implements IProviderPolicy {

	/**
	 * The tag used to test that the element is a ZDLConcept.
	 */
	final private String IS_ZDL_CONCEPT = "isZDLConcept";//$NON-NLS-1$

	final private String IS_ZDL_PROFILE = "isZDLProfile";//$NON-NLS-1$

	final private String IS_ZDL_DOMAIN = "isZDLDomain";//$NON-NLS-1$

	final private String HAS_ANY_ZDL_PROFILE = "hasAnyZDLProfile";//$NON-NLS-1$
	
	final private String IS_ZDL_STRUCTURE_DIAGRAM = "isZDLStructureDiagram"; //$NON-NLS-1$
	
	final private String NEED_DELETE_PORT_MENU = "needDeletePortMenu"; //$NON-NLS-1$
	
	final private String IS_MULTIPLE_SELECTION = "isMultipleSelection"; //$NON-NLS-1$

	@Override
	protected boolean doProvides(IOperation operation) {
		return true;
	}

	@Override
	protected boolean doTestAttribute(Object target, String name, String value) {
		if (IS_ZDL_CONCEPT.equals(name)) {
			if (target instanceof IAdaptable) {
				Element element = (Element) ((IAdaptable) target)
					.getAdapter(Element.class);
				if (element != null) {
					return ZDLUtil.isZDLConcept(element, value);
				}
			}
		}else if (IS_ZDL_PROFILE.equals(name)) {
			if (target instanceof IAdaptable) {
				Element element = (Element) ((IAdaptable) target)
					.getAdapter(Element.class);
				if (element != null) {
					return ZDLUtil.isZDLProfile(element, value);
				}
			}
		}else if (HAS_ANY_ZDL_PROFILE.equals(name)) {
			if (target instanceof IAdaptable) {
				Element element = (Element) ((IAdaptable) target)
					.getAdapter(Element.class);
				if (element != null) {
					if (ZDLUtil.getZDLProfiles(element).isEmpty()) {
						return !Boolean.valueOf(value);
					}
					return Boolean.valueOf(value);
				}
			}
		}else if (IS_ZDL_DOMAIN.equals(name)) {
			if (target instanceof IAdaptable) {
				Element element = (Element) ((IAdaptable) target)
						.getAdapter(Element.class);
				if (element != null) {
					return ZDLUtil.isZDLDomain(element, value);
				}
			}
		}else if (IS_ZDL_STRUCTURE_DIAGRAM.equals(name)) {
			if (target instanceof IAdaptable) {
				Diagram element = (Diagram) ((IAdaptable) target)
						.getAdapter(Diagram.class);
				if (element != null  && element.getType().equals("Structure")) { //$NON-NLS-1$
					if (!ZDLUtil.getZDLProfiles((Element) element.getElement()).isEmpty()) {
						return Boolean.valueOf(value);
					}
				}
			}
		}else if (NEED_DELETE_PORT_MENU.equals(name)) {
			if (target instanceof IAdaptable) {
				EditPart editPart = (EditPart) ((IAdaptable) target)
						.getAdapter(EditPart.class);
				Node node = (Node) ((IAdaptable) target).getAdapter(Node.class);
				EObject element = node.getElement();
				if (!(element instanceof Port)) {
					return !Boolean.valueOf(value);
				}
				if (editPart.getParent().getClass().getName()
						.contains("Structure") //$NON-NLS-1$
				) {

					return Boolean.valueOf(value);
				} else if (editPart.getParent().getClass().getName()
						.contains("PartEditPart")) { //$NON-NLS-1$

					Node parentNode = (Node) ((IAdaptable) editPart.getParent())
							.getAdapter(Node.class);
					Type type = ((Property) parentNode.getElement()).getType();
					if (type != null && type == element.eContainer()) {
						return !Boolean.valueOf(value);
					}
					return Boolean.valueOf(value);
				}
			}
		} else if(IS_MULTIPLE_SELECTION.equals(name)){			
			IStructuredSelection selection = getStructuredSelection();
			boolean isMultipleSelection = selection.size() > 1;
			
			return Boolean.valueOf(value).equals(isMultipleSelection);
		}
		return false;
	}

	@Override
	protected TransactionalEditingDomain getEditingDomain(Object target) {
		if (target instanceof IAdaptable) {
			EObject eObject = (EObject) ((IAdaptable) target)
				.getAdapter(EObject.class);
			if (eObject != null)
				return TransactionUtil.getEditingDomain(eObject);
		}
		return null;
	}
}
