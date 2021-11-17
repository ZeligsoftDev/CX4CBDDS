/**
 * Copyright 2020-2021 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.canonical.editpolicy.PapyrusCanonicalEditPolicy;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * DDS4CCM canonical edit policy to implement workarounds
 * 
 * @author Young-Soo Roh
 *
 */
public class DDS4CCMCanonicalEditPolicy extends PapyrusCanonicalEditPolicy {

	private static final String SEMI_ACTIVE_FILTER_ID = "org.eclipse.papyrus.semiCanonical"; //$NON-NLS-1$

	@Override
	protected boolean deleteViews(Iterable<? extends View> views) {
		List<View> toDelete = new ArrayList<View>();
		for (View v : views) {
			if (v.getElement() != null) {
				toDelete.add(v);
			}
		}
		return super.deleteViews(toDelete);
	}

	@Override
	protected void doActivate() {
		super.doActivate();
		EObject semanticHost = getSemanticHost();

		// Listen to the component definition as well 
		if (semanticHost != null && ZDLUtil.isZDLConcept(semanticHost, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
			Component assembly = (Component) semanticHost;
			if (!assembly.getGenerals().isEmpty()) {
				EObject general = ((Component) semanticHost).getGenerals().get(0);
				addListenerFilter(SEMI_ACTIVE_FILTER_ID, this, general);
			}
		}
	}

}
