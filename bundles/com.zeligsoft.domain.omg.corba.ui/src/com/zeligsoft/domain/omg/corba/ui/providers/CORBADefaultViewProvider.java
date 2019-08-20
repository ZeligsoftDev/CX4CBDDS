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

package com.zeligsoft.domain.omg.corba.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.IViewCustomizer;
import com.zeligsoft.base.ui.providers.CustomizerViewProvider;
import com.zeligsoft.base.ui.providers.WrapperAdaptable;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.ui.viewcustomizers.CORBAClassViewCustomizer;
import com.zeligsoft.domain.omg.corba.ui.viewcustomizers.CORBADataTypeViewCustomizer;
import com.zeligsoft.domain.omg.corba.ui.viewcustomizers.CORBAInterfaceViewCustomizer;
import com.zeligsoft.domain.zml.ui.viewcustomizers.ZMLComponentViewCustomizer;

/**
 * The default view provider for the CORBA domain.
 * 
 * @author ysroh
 * 
 */
public class CORBADefaultViewProvider extends CustomizerViewProvider {

	private static Map<EClass, IViewCustomizer> nodeMap = new HashMap<EClass, IViewCustomizer>();

	static {
		nodeMap.put(UMLPackage.eINSTANCE.getDataType(),
				CORBADataTypeViewCustomizer.INSTANCE);
		nodeMap.put(UMLPackage.eINSTANCE.getClass_(),
				CORBAClassViewCustomizer.INSTANCE);
		nodeMap.put(UMLPackage.eINSTANCE.getInterface(),
				CORBAInterfaceViewCustomizer.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.zeligsoft.base.rsm.tooling.providers.CustomizerViewProvider#provides
	 * (org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public boolean provides(IOperation operation) {

		// Make sure it is a view operation
		assert operation instanceof CreateViewOperation : "operation is not CreateViewOperation in AbstractViewProvider";//$NON-NLS-1$

		// call the specific provides method for node views
		if (operation instanceof CreateNodeViewOperation)
			return provides((CreateNodeViewOperation) operation);

		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.zeligsoft.base.rsm.tooling.providers.CustomizerViewProvider#provides
	 * (org
	 * .eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation)
	 */
	@Override
	protected boolean provides(CreateNodeViewOperation operation) {

		if (operation.getSemanticHint() == ZMLComponentViewCustomizer.PORT_OPERATIONS_VIEW_TYPE) {
			return false;
		}

		IAdaptable adaptable = operation.getSemanticAdapter();
		if ((adaptable == null) || (adaptable instanceof WrapperAdaptable)) {
			return false;
		}

		Element element = (Element) adaptable.getAdapter(Element.class);
		if (element == null) {
			return false;
		}

		return ZDLUtil.isZDLDomain(element, "CORBADomain"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.zeligsoft.base.rsm.tooling.providers.CustomizerViewProvider#createNode
	 * (org.eclipse.core.runtime.IAdaptable,
	 * org.eclipse.gmf.runtime.notation.View, java.lang.String, int, boolean,
	 * org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint)
	 */
	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {

		Node umlNode = ViewService.getInstance().createNode(
				new WrapperAdaptable(semanticAdapter), containerView, semanticHint,
				index, persisted, preferencesHint);

		// CORBA specific customization
		IViewCustomizer customizer = getNodeViewCustomizer(semanticAdapter,
				containerView, semanticHint);
		if (customizer != null && umlNode != null) {
			customizer.customizeView(umlNode);
		}
		// if CORBA does not have a customizer, default to zdl
		else if (customizer == null) {
			customizeNodeView(umlNode);
		}

		return umlNode;
	}

	/*
	 * (non-Javadoc)
	 * @seecom.zeligsoft.base.rsm.tooling.providers.CustomizerViewProvider#
	 * getNodeViewCustomizer(org.eclipse.core.runtime.IAdaptable,
	 * org.eclipse.gmf.runtime.notation.View, java.lang.String)
	 */
	@Override
	protected IViewCustomizer getNodeViewCustomizer(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {

		if (semanticAdapter instanceof WrapperAdaptable)
			return null;

		EClass semanticEClass = getSemanticElementEClass(semanticAdapter);
		if (semanticEClass != null) {
			return nodeMap.get(semanticEClass);
		}
		return null;
	}

}
