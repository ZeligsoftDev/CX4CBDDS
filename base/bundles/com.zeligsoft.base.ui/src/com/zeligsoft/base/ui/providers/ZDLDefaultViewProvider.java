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
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A customizing default view provider for instances of ZDL concepts.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLDefaultViewProvider
		extends CustomizerViewProvider {

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge umlEdge = ViewService.getInstance().createEdge(
			new WrapperAdaptable(semanticAdapter), containerView, semanticHint,
			index, persisted, preferencesHint);
		customizeEdgeView(umlEdge);
		return umlEdge;
	}

	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node umlNode = ViewService.getInstance().createNode(
			new WrapperAdaptable(semanticAdapter), containerView, semanticHint,
			index, persisted, preferencesHint);
		customizeNodeView(umlNode);
		return umlNode;
	}

	@Override
	public boolean provides(IOperation operation) {
		/* Make sure it is a view operation */
		assert operation instanceof CreateViewOperation : "operation is not CreateViewOperation in AbstractViewProvider";//$NON-NLS-1$

		if (!isZDLProfileApplied((CreateViewOperation)operation)){
			return false;
		}
	
		/* call the specific provides method */
		if (operation instanceof CreateEdgeViewOperation)
			return provides((CreateEdgeViewOperation) operation);
		else if (operation instanceof CreateNodeViewOperation)
			return provides((CreateNodeViewOperation) operation);
		return false;
	}

	protected boolean provides(CreateEdgeViewOperation operation) {
		IAdaptable adaptable = operation.getSemanticAdapter();

		if (adaptable instanceof WrapperAdaptable) {
			return false;
		}

		String hint = operation.getSemanticHint();

		if ((hint != null) && (hint.length() > 0)
			&& hint.startsWith(ZDLViewProvider.HINT_PREFIX)) {
			return true;
		}

		if (adaptable != null) {
			EObject element = (EObject) adaptable.getAdapter(EObject.class);

			return (element != null) && ZDLUtil.getZDLConcept(element) != null;
		}

		return false;
	}

	@Override
	protected boolean provides(CreateNodeViewOperation operation) {
		IAdaptable adaptable = operation.getSemanticAdapter();

		//if ((adaptable instanceof WrapperAdaptable) 
		if (adaptable instanceof WrapperAdaptable) {				
			return false;
		}
		
		String hint = operation.getSemanticHint();

		if ((hint != null) && (hint.length() > 0)
			&& hint.startsWith(ZDLViewProvider.HINT_PREFIX)) {
			return true;
		}

		if (adaptable != null) {
			EObject element = (EObject) adaptable.getAdapter(EObject.class);

			return (element != null) && ZDLUtil.getZDLConcept(element) != null;
		}

		return false;
	}
}