/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.xtext.base.cs2as.AmbiguitiesAdapter;
import org.eclipse.ocl.xtext.base.cs2as.ExceptionAdapter;
import org.eclipse.ocl.xtext.base.scoping.BaseScopeProvider;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;

public class BaseLinkingService extends DefaultLinkingService
{
	public static final @NonNull TracingOption DEBUG_RETRY = new TracingOption("org.eclipse.ocl.xtext.base", "debug/retry");

	private static int depth = -1;

	@Inject
	private IValueConverterService valueConverterService;

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		try {
			depth++;
			String text = getText(node);
			boolean traceLookup = BaseScopeProvider.LOOKUP.isActive();
			if (text == null) {				// Avoid IQualifiedNameConverter IAE
				if (traceLookup) {
					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup null");
				}
				return Collections.emptyList();
			}
			IScope scope = getScope(context, ref);
			if (traceLookup) {
				//				EObject target = ((ScopeView)scope).getTarget();
				//				String inString = target instanceof ElementCS ? ((ElementCS)target).getSignature() : target.toString();
				//				BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " in " + inString);
				BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text);
			}
			if (scope == null) {
				return Collections.emptyList();
			}
			QualifiedName qualifiedName = QualifiedName.create(text);
			List<@NonNull EObject> linkedObjects = lookUp(scope, qualifiedName);
			if ((linkedObjects.size() <= 0) && text.startsWith("_")) {				// Deprecated compatibility
				linkedObjects = lookUp(scope, QualifiedName.create(text.substring(1)));
			}
			if (traceLookup) {
				BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " failed");
			}
			List<Adapter> eAdapters = context.eAdapters();
			Adapter adapter = EcoreUtil.getAdapter(eAdapters, ExceptionAdapter.class);
			if (adapter != null) {
				eAdapters.remove(adapter);
			}
			if (linkedObjects.size() > 1) {
				if (DEBUG_RETRY.isActive()) {
					scope.getElements(qualifiedName);
				}
				AmbiguitiesAdapter.setAmbiguities(context, linkedObjects);
				return Collections.emptyList();
			}
			if (linkedObjects.size() <= 0) {
				if (DEBUG_RETRY.isActive()) {
					scope.getElements(qualifiedName);
				}
			}
			return linkedObjects;
		}
		catch (IllegalLibraryException e) {
			context.eAdapters().add(new ExceptionAdapter(e));
			return Collections.emptyList();
		}
		finally {
			depth--;
		}
	}

	@Override
	protected IScope getScope(EObject context, EReference reference) {
		IScopeProvider scopeProvider = getScopeProvider();
		if (scopeProvider == null)
			throw new IllegalStateException("scopeProvider must not be null.");
		//		try {
		//			registerImportedNamesAdapter(context);
		return scopeProvider.getScope(context, reference);
		//		} finally {
		//			unRegisterImportedNamesAdapter();
		//		}
	}

	public @Nullable String getText(@Nullable INode node) {
		if (node == null) {
			return null;
		}
		ILeafNode leafNode = ElementUtil.getLeafNode(node);
		if (leafNode == null) {
			return null;
		}
		EObject grammarElement = leafNode.getGrammarElement();
		if (grammarElement == null) {
			return null;
		}
		String ruleName = getLinkingHelper().getRuleNameFrom(grammarElement);
		return (String) valueConverterService.toValue(leafNode.getText(), ruleName, leafNode);
	}

	protected @NonNull List<@NonNull EObject> lookUp(@NonNull IScope scope, QualifiedName qualifiedName) {
		@NonNull List<@NonNull EObject> linkedObjects = new ArrayList<>();
		for (IEObjectDescription eObjectDescription : scope.getElements(qualifiedName)) {
			EObject eObjectOrProxy = eObjectDescription.getEObjectOrProxy();
			if (eObjectOrProxy != null) {
				linkedObjects.add(eObjectOrProxy);
			}
			if (BaseScopeProvider.LOOKUP.isActive()) {
				BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + qualifiedName + " => " + eObjectOrProxy);
			}
		}
		return linkedObjects;
	}
}
