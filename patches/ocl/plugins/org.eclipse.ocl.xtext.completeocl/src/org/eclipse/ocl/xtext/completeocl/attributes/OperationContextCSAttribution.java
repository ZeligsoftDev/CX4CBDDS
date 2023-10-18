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
package org.eclipse.ocl.xtext.completeocl.attributes;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;

public class OperationContextCSAttribution extends AbstractAttribution
{
	public static final @NonNull OperationContextCSAttribution INSTANCE = new OperationContextCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		OperationContextDeclCS targetElement = (OperationContextDeclCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
/*		if (containmentFeature == CompleteOCLCSPackage.Literals.OPERATION_CONTEXT_DECL_CS__OPERATION) {
			Filter filter = new OperationContextFilter(targetElement);
			try {
				environmentView.addFilter(filter);
				ScopeView namespaceScope = getNamespaceScope(environmentView, scopeView, targetElement.getNamespace());
				if ("conformsTo".equals(environmentView.getName())) {		// FIXME debugging
					environmentView.computeLookups(namespaceScope);
				}
				else {
					environmentView.computeLookups(namespaceScope);
				}
				return null;
			}
			finally {
				environmentView.removeFilter(filter);
			}
		}
		else if (containmentFeature == CompleteOCLCSPackage.Literals.CONTEXT_DECL_CS__NAMESPACE) {
			return getNextNamespaceScope(environmentView, scopeView, targetElement.getNamespace());
		}
		else*/ if ((containmentFeature == CompleteOCLCSPackage.Literals.OPERATION_CONTEXT_DECL_CS__OWNED_POSTCONDITIONS)
				|| (containmentFeature == CompleteOCLCSPackage.Literals.OPERATION_CONTEXT_DECL_CS__OWNED_PRECONDITIONS)
				|| (containmentFeature == CompleteOCLCSPackage.Literals.OPERATION_CONTEXT_DECL_CS__OWNED_BODIES)) {
//			return getNextNamespaceScope(environmentView, scopeView, target.getNamespace());
//			Operation operation = targetElement.getOperation();
			PathNameCS pathName = targetElement.getOwnedPathName();
			if (pathName != null) {
				List<PathElementCS> path = pathName.getOwnedPathElements();
				if (path.size() > 1) {
					Element element = path.get(path.size()-2).getReferredElement();
					if ((element instanceof org.eclipse.ocl.pivot.Class) && !element.eIsProxy()) {
						org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class) element;
//						MetamodelManager metamodelManager = environmentView.getMetamodelManager();
						environmentView.addAllOperations(type, FeatureFilter.SELECT_NON_STATIC);
						environmentView.addAllProperties(type, FeatureFilter.SELECT_NON_STATIC);
//						if (!environmentView.hasFinalResult()) {
//							Set<Type> alreadyVisitedTypes = new HashSet<Type>();
		//					org.eclipse.ocl.pivot.Class unspecializedTarget = PivotUtil.getUnspecializedTemplateableElement(target);	// FIXME
//							for (Type superClass : metamodelManager.getSuperClasses(type)) {
//								environmentView.addAllContents(type, scopeView, superClass, Boolean.FALSE, alreadyVisitedTypes);
//							}
//						}
					}
				}
			}
		}
		return scopeView.getParent();

	}
}
