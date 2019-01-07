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
package com.zeligsoft.domain.omg.dds.rsm.ui.providers;

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
import com.zeligsoft.base.ui.utils.BaseUtil;
import com.zeligsoft.domain.omg.dds.rsm.ui.viewcustomizers.DDSComponentViewCustomizer;
import com.zeligsoft.domain.omg.dds.rsm.ui.viewcustomizers.DomainViewCustomizer;
import com.zeligsoft.domain.omg.dds.util.DDSUtil;

/**
 * The default view provider for the DDS domain.
 * 
 * Provides for nodes of type uml.component.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class DDSDefaultViewProvider extends CustomizerViewProvider {
	private static final Map<EClass, IViewCustomizer> nodeMap = new HashMap<EClass, IViewCustomizer>();

	static {
		nodeMap.put(UMLPackage.eINSTANCE.getComponent(),
				DDSComponentViewCustomizer.INSTANCE);
		nodeMap.put(UMLPackage.eINSTANCE.getComponent(), 
				DomainViewCustomizer.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.base.ui.providers.CustomizerViewProvider#provides(org.eclipse
	 * .gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public boolean provides(IOperation operation) {

		assert operation instanceof CreateViewOperation : "operation is not CreateViewOperation in AbsractViewProvider";

		if (operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation) operation);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.base.ui.providers.CustomizerViewProvider#provides(org.eclipse
	 * .gmf.runtime.diagram.core.services.view.CreateNodeViewOperation)
	 */
	@Override
	protected boolean provides(CreateNodeViewOperation operation) {

		IAdaptable adaptable = operation.getSemanticAdapter();
		if ((adaptable == null) || (adaptable instanceof WrapperAdaptable)) {
			return false;
		}

		Element element = (Element) adaptable.getAdapter(Element.class);
		if (element == null) {
			return false;
		}

		return BaseUtil.isDomainProfileApplied(element,
				DDSUtil.DDS_PROFILE_NSURI);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.base.ui.providers.CustomizerViewProvider#createNode(org
	 * .eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.notation.View,
	 * java.lang.String, int, boolean,
	 * org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint)
	 */
	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node umlNode = ViewService.getInstance().createNode(
				new WrapperAdaptable(semanticAdapter), containerView,
				semanticHint, index, persisted, preferencesHint);

		IViewCustomizer customizer = getNodeViewCustomizer(semanticAdapter,
				containerView, semanticHint);
		if (customizer != null && umlNode != null) {
			customizer.customizeView(umlNode);
		} else if (customizer == null) {
			customizeNodeView(umlNode);
		}

		return umlNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zeligsoft.base.ui.providers.CustomizerViewProvider#
	 * getNodeViewCustomizer(org.eclipse.core.runtime.IAdaptable,
	 * org.eclipse.gmf.runtime.notation.View, java.lang.String)
	 */
	@Override
	protected IViewCustomizer getNodeViewCustomizer(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {

		if (semanticAdapter instanceof WrapperAdaptable) {
			return null;
		}

		EClass semanticEClass = getSemanticElementEClass(semanticAdapter);
		if (semanticEClass != null) {
			return nodeMap.get(semanticEClass);
		}

		return null;
	}
}
