/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;

public class EnumerationAttribution extends AbstractAttribution
{
	public static final EnumerationAttribution INSTANCE = new EnumerationAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		org.eclipse.ocl.pivot.Enumeration targetEnumeration = (org.eclipse.ocl.pivot.Enumeration) target;
		environmentView.addAllEnumerationLiterals(targetEnumeration);
		environmentView.addAllOperations(targetEnumeration, null);
		environmentView.addAllProperties(targetEnumeration, null);
		environmentView.addAllTemplateParameters(targetEnumeration);
		return scopeView.getParent();
	}
}
