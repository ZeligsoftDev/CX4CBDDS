/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.xtext.base.attributes.RootCSAttribution;

public abstract class AbstractRootCSAttribution extends AbstractAttribution implements RootCSAttribution
{
	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		PivotMetamodelManager metamodelManager = environmentView.getEnvironmentFactory().getMetamodelManager();
		if (environmentView.accepts(PivotPackage.Literals.TYPE)) {
			for (Type type : metamodelManager.getGlobalTypes()) {
				if (type != null) {
					environmentView.addNamedElement(type);
				}
			}
		}
		if (environmentView.accepts(PivotPackage.Literals.NAMESPACE)) {
			for (Map.Entry<String, Namespace> entry : metamodelManager.getGlobalNamespaces()) {
				String key = entry.getKey();
				Namespace value = entry.getValue();
				if ((key != null) && (value != null)) {
					environmentView.addElement(key, value);
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
