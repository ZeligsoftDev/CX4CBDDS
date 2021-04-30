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
package com.zeligsoft.domain.dds4ccm.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.validation.internal.EcoreDiagnostician;
import org.eclipse.uml2.uml.PackageImport;

@SuppressWarnings("restriction")
/**
 * DDS4CCMDiagnostician to by-pass <code>UMLDiagnostician</code>.
 * 
 * @author Young-Soo
 *
 */
public class DDS4CCMDiagnostician extends EcoreDiagnostician {

	public DDS4CCMDiagnostician() {
		super();
		this.progressMonitor = new NullProgressMonitor();
	}

	@Override
	protected boolean doValidateContents(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		List<EObject> eContents = eObject.eContents();
		if (!eContents.isEmpty()) {
			Iterator<EObject> i = eContents.iterator();
			EObject child = null;

			// find first child which is not package import
			while (i.hasNext()) {
				child = i.next();
				if (!(child instanceof PackageImport) && !(child instanceof EAnnotation)) {
					break;
				}
			}

			boolean result = validate(child, diagnostics, context);
			while (i.hasNext() && (result || diagnostics != null)) {
				child = i.next();
				if (!(child instanceof PackageImport) && !(child instanceof EAnnotation)) {
					result &= validate(child, diagnostics, context);
				}
			}
			return result;
		} else {
			return true;
		}
	}
}
