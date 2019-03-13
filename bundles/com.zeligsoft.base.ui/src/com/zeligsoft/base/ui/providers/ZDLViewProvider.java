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
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.base.zdl.type.ZDLElementType;

/**
 * View provider for stereotype association edges their labels.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("rawtypes") // GMF is not J2SE 5.0
public class ZDLViewProvider
		extends AbstractViewProvider {

	static final String HINT_PREFIX = "com.zeligsoft.zdl."; //$NON-NLS-1$

	static final String HINT_LABEL_SUFFIX = "#LABEL"; //$NON-NLS-1$

	static final String HINT_TEXT_SUFFIX = "#TEXT"; //$NON-NLS-1$

	static final String HINT_EP_SUFFIX = "#EP"; //$NON-NLS-1$

	static final String HINT_LABEL_EP_SUFFIX = "#LABEL_EP"; //$NON-NLS-1$

	static final String HINT_TEXT_EP_SUFFIX = "#TEXT_EP"; //$NON-NLS-1$

	@Override
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if ((semanticHint != null) && (semanticHint.length() > 0)
			&& semanticHint.startsWith(HINT_PREFIX)
			&& (semanticHint.endsWith(HINT_LABEL_SUFFIX) || semanticHint.endsWith(HINT_LABEL_EP_SUFFIX))) {
			return ZDLReferenceLabelViewFactory.class;
		} else if ((semanticHint != null) && (semanticHint.length() > 0)
			&& semanticHint.startsWith(HINT_PREFIX)
			&& (semanticHint.endsWith(HINT_TEXT_SUFFIX) || semanticHint.endsWith(HINT_TEXT_EP_SUFFIX))) {
			return ZDLReferenceTextViewFactory.class;
		}
		return null;
	}

	@Override
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if ((semanticHint != null) && (semanticHint.length() > 0)
			&& semanticHint.startsWith(HINT_PREFIX)) {
			return ZDLReferenceViewFactory.class;
		}
		if (semanticAdapter != null) {
			IElementType elementType = (IElementType) semanticAdapter
					.getAdapter(IElementType.class);
			if ((elementType instanceof ZDLElementType)
					&& (((ZDLElementType) elementType).getDomainReference() != null)) {
				return ZDLReferenceViewFactory.class;
			}
		}
		return null;
	}

}