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
package org.eclipse.ocl.pivot.internal.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * PivotSaveImpl ensures that all references to specialized types are terminated
 * by local copies of the specialization.
 */
public final class PivotSaveImpl extends XMISaveImpl
{
	/**
	 * @since 1.18
	 */
	public static class PivotXMIHelperImpl extends XMIHelperImpl
	{
		private @NonNull ASSaverNew asSaver;

		public PivotXMIHelperImpl(@NonNull ASResource asResource) {
			super(asResource);
			this.asSaver = new ASSaverNew(asResource);
		}

		@Override
		public String getHREF(EObject unresolvedObject) {
			if (unresolvedObject == null) {
				return null;
			}
			EObject resolvedObject = asSaver.resolveOrphan(unresolvedObject);
			return super.getHREF(resolvedObject);
		}

		public @NonNull ASSaverNew getSaver() {
			return asSaver;
		}
	}

	/**
	 * The Lookup override enforces alphabetical order on saved features.
	 */
	public static class Lookup extends XMISaveImpl.Lookup
	{
		public Lookup() {
			super(null, null, null);
		}

		@Override
		protected EStructuralFeature[] listFeatures(EClass cls) {
			EStructuralFeature[] listFeatures = super.listFeatures(cls);
			Arrays.sort(listFeatures, NameUtil.ENamedElementComparator.INSTANCE);
			return listFeatures;
		}
	}

	private @NonNull ASSaverNew asSaver;

	public PivotSaveImpl(@NonNull XMLHelper helper) {
		super(helper);
		this.asSaver = ((PivotXMIHelperImpl)helper).getSaver();
	}

	//
	//	Special case. ElementLiteralExp::referredElement is an EObject-typed EAttribute to avoid all the
	//	unpleasant corrolaries of injecting an opposite into the Ecore metamodel. Serialize it using the
	//	regular EReference approach that includes entity handling and deresolving.
	//
	@Override
	protected String getDatatypeValue(Object value, EStructuralFeature f, boolean isAttribute) {
		if (f == PivotPackage.Literals.ELEMENT_LITERAL_EXP__REFERRED_ELEMENT) {
			URI uri = EcoreUtil.getURI((EObject)value);
			uri = helper.deresolve(uri);
			return convertURI(uri.toString());					// Do not escape, URI ok, entity has legitimate &
		}
		return super.getDatatypeValue(value, f, isAttribute);
	}

	/**
	 * Prepare a pivot resource for save by redirecting all type references to
	 * specializations to local copies of the specializations.
	 */
	@Override
	protected void init(XMLResource resource, Map<?, ?> options) {
		XMLResource asResource = ClassUtil.nonNullState(resource);
		EList<@NonNull EObject> contents = asResource.getContents();
		if (contents.size() > 0) {
			EObject root = contents.get(0);
			if (root instanceof Model) {
				Model model = (Model)root;
				if (model.getExternalURI() == null) {
					model.setExternalURI(asResource.getURI().toString());
				}
			}
		}
		asSaver.localizeOrphans();
		Map<@NonNull Object, @Nullable Object> saveOptions = new HashMap<>();
		if (options != null) {
			for (Object key : options.keySet()) {
				saveOptions.put(String.valueOf(key), options.get(key));
			}
		}
		Object optionNormalizeContents = saveOptions.get(ASResource.OPTION_NORMALIZE_CONTENTS);
		if ((optionNormalizeContents != null) && Boolean.valueOf(optionNormalizeContents.toString())) {
			asSaver.normalizeContents();
			int capacity = INDEX_LOOKUP+1;
			List<@Nullable Object> lookupTable = new ArrayList<>(capacity);
			for (int i = 0; i < capacity; i++) {
				if (i == INDEX_LOOKUP) {
					lookupTable.add(new Lookup());
				}
				else {
					lookupTable.add(null);
				}
			}
			saveOptions.put(ClassUtil.nonNullState(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE), lookupTable);
		}
		ResourceSet asResourceSet = asResource.getResourceSet();
		if (asResourceSet != null) {
			AS2ID.assignIds(asResourceSet.getResources(), saveOptions);
		}
		else if (asResource instanceof ASResource){
			AS2ID.assignIds((ASResource) asResource, saveOptions);
		}
		super.init(asResource, saveOptions);
	}
}