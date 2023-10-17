/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.xtext.base.attributes.PivotableElementCSAttribution;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;

public class ContextCSAttribution extends PivotableElementCSAttribution
{
	public static final ContextCSAttribution INSTANCE = new ContextCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		if (target.eContainer() == null) {
			Resource eResource = target.eResource();
			if (eResource instanceof EssentialOCLCSResource) {
				EssentialOCLCSResource csResource = (EssentialOCLCSResource)eResource;
				ParserContext parserContext = csResource.getParserContext();
				if (parserContext != null) {
					Element asContext = parserContext.getElementContext();
					for (EObject eObject = asContext; eObject != null; eObject = eObject.eContainer()) {
						if (eObject instanceof TemplateableElement) {
							environmentView.addAllTemplateParameters((TemplateableElement)eObject);
						}
					}
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
