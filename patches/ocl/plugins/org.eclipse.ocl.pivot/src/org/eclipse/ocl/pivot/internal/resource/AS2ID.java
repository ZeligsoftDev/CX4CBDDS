/*******************************************************************************
 * Copyright (c) 2017, 2022 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.resource.ASResource;

import com.google.common.collect.Lists;

/**
 * AS2ID computes the predictable xmi:ids for ASResources using LUSSIDs.
 *
 * @see LUSSIDs.
 *
 * @since 1.4
 */
public class AS2ID
{
	/**
	 * The DEBUG_LUSSID_COLLISIONS debug pivot saving option diagnoses whether the nominally unique
	 * 32 bit LUSSID values are colliding. This assists in checking that LUSSID generation produces
	 * few clashes. If set, any collisions are reported in Resource.errors potentially causing a
	 * correct execution to malfunction.
	 */
	public static final @NonNull String DEBUG_LUSSID_COLLISIONS = "DEBUG_LUSSID_COLLISIONS";

	/**
	 * The DEBUG_XMIID_COLLISIONS debug pivot saving option diagnoses where the disambiguation
	 * algorithm was needed to avoid xmi:id collisions. If set, any collisions are reported in
	 * Resource.errors potentially causing a correct execution to malfunction.
	 */
	public static final @NonNull String DEBUG_XMIID_COLLISIONS = "DEBUG_XMIID_COLLISIONS";

	public static void assignIds(@NonNull ASResource resource, @Nullable Map<@NonNull Object, @Nullable Object> options) {
		AS2ID as2id = new AS2ID(options);
		as2id.assignLUSSIDs(resource);
		as2id.assignXMIIDs();
		as2id.assignErrors();
	}

	@Deprecated /* @deprecated pass List to avoid CME hazard */
	public static void assignIds(@NonNull Iterable</*@NonNull*/ Resource> resources, @Nullable Map<@NonNull Object, @Nullable Object> options) {
		AS2ID as2id = new AS2ID(options);
		for (Resource resource : Lists.newArrayList(resources)) {		// Proxy resolution may add new resources
			if (resource instanceof ASResource) {
				as2id.assignLUSSIDs((ASResource) resource);
			}
		}
		as2id.assignXMIIDs();
		as2id.assignErrors();
	}

	/**
	 * @since 1.9
	 */
	public static void assignIds(@NonNull List</*@NonNull*/ Resource> resources, @Nullable Map<@NonNull Object, @Nullable Object> options) {
		AS2ID as2id = new AS2ID(options);
		for (int i = 0; i < resources.size(); i++) {		// Proxy resolution may add new resources
			Resource resource = resources.get(i);
			if (resource instanceof ASResource) {
				as2id.assignLUSSIDs((ASResource) resource);
			}
		}
		as2id.assignXMIIDs();
		as2id.assignErrors();
	}

	private final @NonNull Map<@NonNull Object, @Nullable Object> options;

	/**
	 * LUSSIDs that were assigned in a previous assignIds call.
	 */
	//	private final @NonNull List<@NonNull LUSSIDs> oldLUSSIDs = new ArrayList<>();

	/**
	 * LUSSIDs that are assigned in the current assignIds call.
	 */
	private final @NonNull List<@NonNull LUSSIDs> newLUSSIDs = new ArrayList<>();

	private AS2ID(@Nullable Map<@NonNull Object, @Nullable Object> options) {
		this.options = options != null ? options : new HashMap<>();
	}

	protected void assignErrors() {
		for (@NonNull LUSSIDs lussids : newLUSSIDs) {
			lussids.assignErrors();
		}
	}

	public int assignLUSSID(@NonNull Element element, boolean isReferenced, boolean normalizeTemplateParameters) {
		Resource resource = element.eResource();
		if (resource instanceof ASResource) {
			ASResource asResource = (ASResource)resource;
			LUSSIDs lussids = asResource.getLUSSIDs(options);
			return lussids.assignLUSSID(this, element, isReferenced, normalizeTemplateParameters);
		}
		else {
			String fragment = EcoreUtil.getURI(element).fragment();
			return fragment != null ? fragment.hashCode() : 0;
		}
	}

	protected void assignLUSSIDs(@NonNull ASResource asResource) {
		LUSSIDs lussids = asResource.basicGetLUSSIDs();
		if ((lussids != null) && lussids.isAssignmentStarted()) {
			//	System.out.println("re-assignLUSSIDs to "  + asResource.getURI());
			lussids.assignErrors();
			//			if (!oldLUSSIDs.contains(lussids)) {
			//				oldLUSSIDs.add(lussids);
			//			}
		}
		else {
			//	System.out.println("assignLUSSIDs to "  + asResource.getURI());
			lussids = asResource.getLUSSIDs(options);
			if (newLUSSIDs.contains(lussids)) {
				return;
			}
			newLUSSIDs.add(lussids);
			lussids.assignLUSSIDs(this);
		}
	}

	private void assignXMIIDs() {
		for (int i = 0; i < newLUSSIDs.size(); i++) {
			LUSSIDs lussids = newLUSSIDs.get(i);
			lussids.assignXMIIDs(this);
		}
	}
}
