/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.scoping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.xtext.base.attributes.ElementCSAttribution;
import org.eclipse.ocl.xtext.base.attributes.ImportCSAttribution;
import org.eclipse.ocl.xtext.base.attributes.PathElementCSAttribution;
import org.eclipse.ocl.xtext.base.attributes.PivotableElementCSAttribution;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS.AbstractUnresolvedProxyMessageProvider;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;

public class BaseScoping
{
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(BaseCSPackage.Literals.ELEMENT_CS, ElementCSAttribution.INSTANCE);
		registry.put(BaseCSPackage.Literals.IMPORT_CS, ImportCSAttribution.INSTANCE);	// return new ImportAttribution();		// WIP static instance
		registry.put(BaseCSPackage.Literals.PATH_ELEMENT_CS, PathElementCSAttribution.INSTANCE);
		registry.put(BaseCSPackage.Literals.PIVOTABLE_ELEMENT_CS, PivotableElementCSAttribution.INSTANCE);
		CS2AS.addUnresolvedProxyMessageProvider(ImportCSAttribution.INSTANCE);
		CS2AS.addUnresolvedProxyMessageProvider(new SimpleNamedElementRefCSTypeUnresolvedProxyMessageProvider());
		CS2AS.addUnresolvedProxyMessageProvider(new TypedTypeRefCSTypeUnresolvedProxyMessageProvider());
	}

	private static final class SimpleNamedElementRefCSTypeUnresolvedProxyMessageProvider extends AbstractUnresolvedProxyMessageProvider
	{
		private SimpleNamedElementRefCSTypeUnresolvedProxyMessageProvider() {
			super(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT);
		}

		@Override
		public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
			PathElementCS pathElement = (PathElementCS)context;
			EClassifier elementType = pathElement.getElementType();
			PathNameCS pathName = pathElement.getOwningPathName();
			List<PathElementCS> path = pathName.getOwnedPathElements();
			int index = path.indexOf(pathElement);
			if (index > 0) {
				Element pathScope = path.get(index-1).getReferredElement();
				if ((pathScope == null) || pathScope.eIsProxy()) {
					return null;		// Suppress message for child when parent has error
				}
			}
			String element = elementType != null ? elementType.getName() : "unknown";
			@SuppressWarnings("null") @NonNull String messageTemplate = PivotMessagesInternal.Unresolved_ERROR_;
			return CS2AS.getMessageBinder().bind(context, messageTemplate, element, linkText);
		}
	}

	private static final class TypedTypeRefCSTypeUnresolvedProxyMessageProvider extends AbstractUnresolvedProxyMessageProvider
	{
		private TypedTypeRefCSTypeUnresolvedProxyMessageProvider() {
			super(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__REFERRED_TYPE);
		}

		@Override
		public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
			@SuppressWarnings("null") @NonNull String messageTemplate = PivotMessagesInternal.UnresolvedType_ERROR_;
			return CS2AS.getMessageBinder().bind(context, messageTemplate, "", linkText);
		}
	}
}
