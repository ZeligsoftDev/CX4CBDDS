/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.resource.CSResource.CSResourceExtension2;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;

public class PivotDiagnosticConverter extends DiagnosticConverterImpl
{
	private boolean getLocationDataInProgress = false;

	@Override
	protected EObject getCauser(Diagnostic diagnostic) {
		EObject causer = super.getCauser(diagnostic);
		if (causer instanceof Element) {
			ModelElementCS csModelElement = ElementUtil.getCsElement((Element) causer);
			if (csModelElement != null) {
				Resource resource = csModelElement.eResource();
				if ((resource instanceof CSResourceExtension2) && (getLocationDataInProgress || !((CSResourceExtension2)resource).isDerived())) {
					return csModelElement;
				}
			}
			else {
			  	ElementUtil.getCsElement((Element) causer);					// FIXME Just debugging
			}
		}
		return causer;
	}

	@Override
	protected IssueLocation getLocationData(Diagnostic diagnostic) {
		boolean savedGetLocationDataInProgress = getLocationDataInProgress;
		getLocationDataInProgress = true;
		try {
			if (diagnostic instanceof PivotResourceValidator.ValidationDiagnostic) {
				PivotResourceValidator.ValidationDiagnostic node = (PivotResourceValidator.ValidationDiagnostic)diagnostic;
				IssueLocation result = new IssueLocation();
				result.lineNumber = node.getLine();
				result.offset = node.getOffset();
				result.length = node.getLength();
				return result;
			}
			else {
				return super.getLocationData(diagnostic);
			}
		}
		finally {
			getLocationDataInProgress = savedGetLocationDataInProgress;
		}
	}
}
