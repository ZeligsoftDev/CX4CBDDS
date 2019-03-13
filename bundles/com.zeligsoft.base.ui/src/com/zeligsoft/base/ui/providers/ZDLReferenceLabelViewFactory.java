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
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Factory for the labels on ZDL reference views.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLReferenceLabelViewFactory
		extends AbstractLabelViewFactory {

	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {

		super.decorateView(containerView, view, semanticAdapter, semanticHint,
			index, persisted);

		String editPartHint = semanticHint.substring(0, semanticHint
			.indexOf(ZDLViewProvider.HINT_LABEL_SUFFIX));
		editPartHint = editPartHint + ZDLViewProvider.HINT_TEXT_EP_SUFFIX;
		getViewService().createNode(semanticAdapter, view, editPartHint,
			ViewUtil.APPEND, persisted, getPreferencesHint());

		LayoutConstraint layoutConstraint = ((Node) view).getLayoutConstraint();
		if (layoutConstraint instanceof Size) {
			Size size = (Size) layoutConstraint;
			size.setWidth(-1);
			size.setHeight(-1);
		}
	}

}