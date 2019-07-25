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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.IViewCustomizer;
import com.zeligsoft.base.ui.viewcustomizers.BaseViewCustomizer;
import com.zeligsoft.base.ui.viewcustomizers.ClassViewCustomizer;
import com.zeligsoft.base.ui.viewcustomizers.ComponentViewCustomizer;
import com.zeligsoft.base.ui.viewcustomizers.InterfaceViewCustomizer;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Base Zeligsoft View provider that provides a hook for customizing the initial
 * view styles of model elements. ViewProviders are encouraged to extend this
 * provider in order to consistently apply view styles. Extension may then call
 * the base View customization by using the methods provided. Extensions should
 * use a High priority in their extensions since this provider has a Medium
 * priority.
 * 
 * @author jcorchis
 * 
 */
public class CustomizerViewProvider
		extends AbstractProvider
		implements IViewProvider {

	/**
	 * View customization map from EClass to IViewCustomizer instances.
	 */
	private static Map<EClass, IViewCustomizer> customizationMap = new HashMap<EClass, IViewCustomizer>();

	static {

		customizationMap.put(UMLPackage.eINSTANCE.getComponent(),
			ComponentViewCustomizer.INSTANCE);
		customizationMap.put(UMLPackage.eINSTANCE.getInterface(),
			InterfaceViewCustomizer.INSTANCE);
		customizationMap.put(UMLPackage.eINSTANCE.getClass_(),
			ClassViewCustomizer.INSTANCE);
		customizationMap.put(UMLPackage.eINSTANCE.getEnumeration(),
			BaseViewCustomizer.INSTANCE);
		customizationMap.put(UMLPackage.eINSTANCE.getDataType(),
			BaseViewCustomizer.INSTANCE);
		customizationMap.put(UMLPackage.eINSTANCE.getArtifact(),
			BaseViewCustomizer.INSTANCE);
        customizationMap.put(UMLPackage.eINSTANCE.getManifestation(),
			BaseViewCustomizer.INSTANCE);		
	}

	@Override
	public boolean provides(IOperation operation) {
		
		/* Make sure it is a view operation */
		assert operation instanceof CreateViewOperation : "operation is not CreateViewOperation in AbstractViewProvider";//$NON-NLS-1$
	
		if (operation instanceof CreateViewForKindOperation) {			
			return provides((CreateViewForKindOperation) operation);				
		}
		
		if (operation instanceof CreateNodeViewOperation) {			
			return provides((CreateNodeViewOperation) operation);					
		}

		return false;
	}
	
	/**
	 * Checks if a ZDL profile is applied to the 
	 * operation's element.
	 * 
	 * @param operation
	 * @return boolean isZDLProfileApplied
	 */
	protected boolean isZDLProfileApplied(CreateViewOperation operation){
		IAdaptable adaptable = operation.getSemanticAdapter();
		if (adaptable == null) {
			return false;
		}
		Element element = (Element) adaptable.getAdapter(Element.class);
		if (element == null) {
			return false;
		}
		
		Collection<Profile> profiles = ZDLUtil.getZDLProfiles(element);		
		return (!profiles.isEmpty());
	}

	@Override
	public Diagram createDiagram(IAdaptable semanticAdapter,
			String diagramKind, PreferencesHint preferencesHint) {
		return null;
	}

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		return null;
	}

	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node umlNode = ViewService.getInstance().createNode(
			new WrapperAdaptable(semanticAdapter), containerView, semanticHint,
			index, persisted, preferencesHint);
		IViewCustomizer customizer = getNodeViewCustomizer(semanticAdapter,
			containerView, semanticHint);
		if (customizer != null && umlNode != null) {
			customizer.customizeView(umlNode);
		}
		return umlNode;
	}

	/**
	 * Returns true if operation contains an model elements has an
	 * IViewCustomizer.
	 * 
	 * @param op
	 *            the CreateViewForKindOperation
	 * @return true if a view customizer exists for the given operation, false
	 *         otherwise.
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		if (op.getViewKind() == Node.class) {
			return null != getNodeViewCustomizer(op.getSemanticAdapter(), op
				.getContainerView(), op.getSemanticHint());
		} else if (op.getViewKind() == Edge.class) {
			return null != getNodeViewCustomizer(op.getSemanticAdapter(), op
				.getContainerView(), op.getSemanticHint());
		}
		return true;
	}

	/**
	 * Returns true if operation contains an model elements has an
	 * IViewCustomizer.
	 * 
	 * @param operation
	 *            the CreateNodeViewOperation
	 * @return true if a view customizer exists for the given operation, false
	 *         otherwise.
	 */
	protected boolean provides(CreateNodeViewOperation operation) {
		return null != getNodeViewCustomizer(operation.getSemanticAdapter(),
			operation.getContainerView(), operation.getSemanticHint());
	}

	/**
	 * Returns the IViewCustomizer based on the semanticAdapter.
	 * 
	 * @param semanticAdapter
	 *            the semantic adapter
	 * @param containerView
	 *            the container view
	 * @param semanticHint
	 *            the semantic hint
	 * @return the IViewCustomizer or null if one cannot be found
	 */
	protected IViewCustomizer getNodeViewCustomizer(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {

		// Necessary to prevent re-entrance into this provider, which
		// does not create any views.
		if (semanticAdapter instanceof WrapperAdaptable) {
			return null;
		}

		EClass semanticEClass = getSemanticElementEClass(semanticAdapter);

		if (semanticEClass != null) {
			return customizationMap.get(semanticEClass);
		}
		return null;

	}

	protected IViewCustomizer getNodeViewCustomizer(Node node) {
		if (node != null) {
			EObject eObject = node.getElement();
			if (eObject != null) {
				return customizationMap.get(eObject.eClass());
			}

		}

		return null;
	}

	protected IViewCustomizer getEdgeViewCustomizer(Edge edge) {
		if (edge != null) {
			EObject eObject = edge.getElement();
			if (eObject != null) {
				return customizationMap.get(eObject.eClass());
			}
		}
		return null;
	}

	protected EObject getSemanticElement(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (EObject) semanticAdapter.getAdapter(EObject.class);

	}

	protected EClass getSemanticElementEClass(IAdaptable semanticAdapter) {

		if (semanticAdapter == null) {
			return null;
		}

		EClass semanticEClass = null;

		// Case 1: New element creation, use the IElementType in the
		// semanticAdapter.
		IElementType elementType = (IElementType) semanticAdapter
			.getAdapter(IElementType.class);
		if (elementType != null) {
			semanticEClass = elementType.getEClass();
		}

		if (semanticEClass == null) {
			// Case 2: Existing element, e.g. DND from Project Explorer
			EObject eObject = getSemanticElement(semanticAdapter);
			if (eObject != null) {
				semanticEClass = eObject.eClass();
			}
		}
		return semanticEClass;
	}

	/**
	 * Customizes the provide Node defined by the base view customizer.
	 * 
	 * @param node
	 *            the Node to customize
	 */
	public void customizeNodeView(Node node) {
		IViewCustomizer customizer = getNodeViewCustomizer(node);
		if (customizer != null && node != null) {
			customizer.customizeView(node);
		}

	}

	/**
	 * Customizes the provide Edge defined by the base view customizer.
	 * 
	 * @param edge
	 *            the Edge to customize
	 */
	public void customizeEdgeView(Edge edge) {
		IViewCustomizer customizer = getEdgeViewCustomizer(edge);
		if (customizer != null && edge != null) {
			customizer.customizeView(edge);
		}

	}
}
