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
package com.zeligsoft.domain.omg.dds.rsm.ui.viewcustomizers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.base.ui.viewcustomizers.BaseViewCustomizer;

/**
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public abstract class AbstractComponentViewCustomizer extends
		BaseViewCustomizer {

	/**
	 * Returns true if the <code>candidate</code> is a candidate to be
	 * customized.
	 * 
	 * @param candidate
	 * @return
	 */
	protected abstract boolean isCandidate(EObject candidate);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.base.ui.viewcustomizers.BaseViewCustomizer#customizeView
	 * (org.eclipse.gmf.runtime.notation.View)
	 */
	public void customizeView(View view) {

		if (view.eContainer() instanceof Diagram
				&& "Structure".equals(((Diagram) view.eContainer()).getType())) {
			return;
		}

		super.customizeView(view);

		EObject element = view.getElement();

		if (!isCandidate(element)) {
			return;
		}

		boolean isStructureRequired = true;
		boolean isAttributeRequired = false;
		boolean isOperationRequired = false;
		boolean isRequiresRequired = false;
		boolean isProvidedRequired = false;

		@SuppressWarnings("unchecked")
		EList<View> children = view.getChildren();
		for (View childView : children) {
			final String childViewType = childView.getType();

			if (STRUCTURE_COMPARTMENT_VIEW_NAME.equals(childViewType)) {
				childView.setVisible(isStructureRequired);
			} else if (ATTRIBUTE_LIST_VIEW_NAME.equals(childViewType)) {
				childView.setVisible(isAttributeRequired);
			} else if (OPERATION_LIST_VIEW_NAME.equals(childViewType)) {
				childView.setVisible(isOperationRequired);
			} else if (REQUIRES_LIST_VIEW_NAME.equals(childViewType)) {
				childView.setVisible(isRequiresRequired);
			} else if (PROVIDES_LIST_VIEW_NAME.equals(childViewType)) {
				childView.setVisible(isProvidedRequired);
			}

		}
	}

	protected AbstractComponentViewCustomizer() {
		super();
	}

}