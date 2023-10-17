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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.utilities.UniqueList;

/**
 * The LUSSIDs class maintains the element to LUSSID and LUSSID to element mapping for the elements
 * of an ASResource. It also provides the ability to return predictable xmi:id values.
 *
 * An xmi:id is provided for every explicitly referenced, and every potentially externally referenced element,
 * so that the EMF fall-back to @x/@y.1 style id references is never required in a persisted resource. However
 * for casual use such as by Diagnostician.getObjectLabel the conventional URI is used.
 *
 * The xmi:id typically comprises a 5 Base64-like letter encoding of the bottom 30 bits of the LUSSID of the element.
 * Additional Base64 letters are occasionally needed to disambiguate duplicates. Disambiguation favours the externally
 * referenceable xmi:ids before falling back on hierachical position. Disambiguation is therefore very likely to give
 * stable results after many forms of model evolution.
 *
 * The LUSSID (Locally Unique Semantically Sentsitive ID) is the hashcode of the hierarchical path of the element.
 * The resource location, model name and external URI are ignored avoiding dependence on location and URI.
 * Elements within ordered non-unique collections use the index as part of their identity. Other collection elements
 * use a further local LUSSID that captures the name/template bindings/parameter names/collection bounds
 * so that a LUSSID has substantial tolerance to insignificant reordering of elements. Perfect uniqueness of LUSSIDs
 * is not necessary, since ambiguous LUSSIDs can be resolved by the xmi:id disambiguation.

 * @since 1.4
 */
public abstract class LUSSIDs
{
	// CONTAINER_MULTIPLIER needs to be large since child collection indexes multiply up and collide.
	protected static final int COLLECTION_IS_NULL_FREE_MULTIPLIER = 59;
	protected static final int COLLECTION_LOWER_BOUND_MULTIPLIER = 61;
	protected static final int COLLECTION_UPPER_BOUND_MULTIPLIER = 67;
	protected static final int CONTAINER_MULTIPLIER = 1021;
	protected static final int CONTAINMENT_FEATURE_NAME_MULTIPLER = 5;
	protected static final int LAMBDA_TYPE_CONTEXT_MULTIPLIER = 71;
	protected static final int LAMBDA_TYPE_PARAMETER_TYPE_MULTIPLIER = 73;
	protected static final int LAMBDA_TYPE_RETURN_TYPE_MULTIPLIER = 79;
	protected static final int MAP_KEYS_ARE_NULL_FREE_MULTIPLIER = 101;
	protected static final int MAP_VALUES_ARE_NULL_FREE_MULTIPLIER = 103;
	protected static final int OPERATION_PARAMETER_TYPE_MULTIPLIER = 83;
	protected static final int OPPOSITE_PROPERTY_NAME_MULTIPLIER = 7;
	protected static final int SIBLING_INDEX_MULTIPLIER = 1;
	protected static final int TEMPLATE_BINDING_MULTIPLIER = 89;
	protected static final int TEMPLATE_PARAMETER_INDEX_MULTIPLIER = 97;

	/**
	 * Base 64 lookup table for encoding xmi:id.
	 *
	 * NB uses ',' rather than '/' to avoid confusing EMF with spurious segments.
	 */
	static char base64digits[] = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
		'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
		'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
		'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
		'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
		'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		'w', 'x', 'y', 'z', '0', '1', '2', '3',
		'4', '5', '6', '7', '8', '9', '+', ','};

	protected class XMIIDDisambiguationComparator implements Comparator<@NonNull Element>
	{
		@Override
		public int compare(@NonNull Element o1, @NonNull Element o2) {
			if (o1 == o2) {
				return 0;
			}
			boolean e1 = isExternallyReferenceable(o1);
			boolean e2 = isExternallyReferenceable(o2);
			if (e1 != e2) {
				return e1 ? -1 : 1;
			}
			int d1 = computeDepth(o1);
			int d2 = computeDepth(o2);
			EObject child1 = null;
			EObject child2 = null;
			EObject parent1 = o1;
			EObject parent2 = o2;
			while (d1 > d2) {
				assert parent1 != null;
				child1 = parent1;
				parent1 = parent1.eContainer();
				d1--;
			}
			while (d1 < d2) {
				child2 = parent2;
				parent2 = parent2.eContainer();
				d2--;
			}
			assert d1 == d2;
			while (parent1 != parent2) {
				child1 = parent1;
				parent1 = parent1.eContainer();
				d1--;
				child2 = parent2;
				parent2 = parent2.eContainer();
				d2--;
			}
			if (child1 == null) {
				assert child2 != null;
				return -1;
			}
			else if (child2 == null) {
				return 1;
			}
			else {
				EReference f1 = child1.eContainmentFeature();
				EReference f2 = child2.eContainmentFeature();
				if (f1 == f2) {
					if (f1 == null) {
						return 0;
					}
					List<?> s = (List<?>) parent1.eGet(f1);
					int i1 = s.indexOf(child1);
					int i2 = s.indexOf(child2);
					return i1 - i2;
				}
				else {
					return f1.getName().compareTo(f2.getName());
				}
			}
		}

		private int computeDepth(@NonNull EObject eObject) {
			int d = 0;
			for (EObject eContainer = eObject; (eContainer = eObject.eContainer()) != null; eObject = eContainer) {
				d++;
			}
			return d;
		}


	}
	/**
	 * Aggregated Diagnostic added to ASResource.errors if xmi:id assignment has to allocate
	 * an unstable random uuid to avoid a duplicate stable id.
	 */
	public static final class UnstableXMIIDDiagnostics implements Resource.Diagnostic
	{
		protected final @NonNull String message;

		public UnstableXMIIDDiagnostics(@NonNull String message) {
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;//.replace("\n",  "\\n");
		}

		@Override
		public String getLocation() {
			return null;
		}

		@Override
		public int getLine() {
			return 0;
		}

		@Override
		public int getColumn() {
			return 0;
		}

		@Override
		public String toString() {
			return message;
		}
	}

	/**
	 * The Resource for which this LUSSIDs manages the assignment of LUSSID values.
	 */
	protected final @NonNull ASResource asResource;

	/**
	 * Map from each identified element to its unique-ish 32 bit hash code.
	 */
	private /*final @NonNull*/ Map<@NonNull Element, @NonNull Integer> identifiedElement2lussid = new HashMap<>();

	/**
	 * Map from each non-identified element to its unique-ish 32 bit hash code.
	 */
	private /*final @NonNull*/ Map<@NonNull Element, @NonNull Integer> internalElement2lussid = new HashMap<>();

	/**
	 * Map from each element to its unique-ish 32 bit hash code with TemplateParameters normalized to simple indexes
	 * in order to avoid cycles for Operation/Iterations whose parameter types involve their TemplateParameters.
	 */
	private /*final @NonNull*/ Map<@NonNull Element, @NonNull Integer> normalizedElement2lussid = new HashMap<>();

	/**
	 * Map from each ideal 5 letter xmi:id to the two or more elements that would like to share that xmi:id.
	 * Once the collisions have been sorted by the XMIIDDisambiguationComparator the ordering determines the
	 * extended disambiguated xmi:ids.
	 */
	private @Nullable Map<@NonNull String, @NonNull List<@NonNull Element>> xmiid2collisions = null;

	private final boolean diagnoseXMIIDcollisions;

	/**
	 * Map of LUSSID to corresponding Element. This is only used to diagnose whether LUSSID clashes are common,
	 * which is undesirable but not catastrophic since it just makes the xmi:id disambiguation work harder.
	 */
	private /*final @NonNull*/ Map<@NonNull Integer, @NonNull Element> debugLUSSID2element = new HashMap<>();

	private @Nullable Map<@NonNull Integer, @NonNull List<@NonNull Element>> debugLUSSID2collisions = null;

	private boolean assignmentStarted = false;

	protected LUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		this.asResource = asResource;
		this.debugLUSSID2element = options.get(AS2ID.DEBUG_LUSSID_COLLISIONS) == Boolean.TRUE ? new HashMap<>(): null;
		this.diagnoseXMIIDcollisions = options.get(AS2ID.DEBUG_XMIID_COLLISIONS) == Boolean.TRUE;
	}

	protected void assignErrors() {
		StringBuilder s = null;
		Map<@NonNull String, @NonNull List<@NonNull Element>> xmiid2collisions2 = xmiid2collisions;
		if ((xmiid2collisions2 != null) && diagnoseXMIIDcollisions) {
			s = new StringBuilder();
			for (@NonNull String xmiid : xmiid2collisions2.keySet()) {
				if (s != null) {
					s.append("\n\tambiguous xmi:id " + xmiid);
				}
				List<@NonNull Element> collisions = xmiid2collisions2.get(xmiid);
				assert collisions != null;
				for (@NonNull Element element : collisions) {
					if (s != null) {
						s.append("\n\t\t" + element);
					}
				}
			}
		}
		if (debugLUSSID2collisions != null) {
			if (s == null) {
				s = new StringBuilder();
			}
			Map<@NonNull Integer, @NonNull List<@NonNull Element>> debugLUSSID2collisions2 = debugLUSSID2collisions;
			if (debugLUSSID2collisions2 != null) {
				for (@NonNull Integer lussid : debugLUSSID2collisions2.keySet()) {
					s.append("\n\tcollision at " + lussid);
					List<@NonNull Element> collisions = debugLUSSID2collisions2.get(lussid);
					assert collisions != null;
					for (@NonNull Element element : collisions) {
						s.append("\n\t\t" + element);
					}
				}
			}
		}
		if (s != null) {
			String message = StringUtil.bind(PivotMessagesInternal.UnstableXMIid_ERROR_, s.toString());
			asResource.getErrors().add(new UnstableXMIIDDiagnostics(message));
		}
	}

	static int debugDepth = 0;
	/**
	 * Return the 32 bit LUSSID for element derived from the hashCode of its hierarchical path
	 * and if necessessary from the local context.
	 */
	protected int assignLUSSID(@NonNull AS2ID as2id, @NonNull Element element, boolean isReferenced, boolean normalizeTemplateParameters) {
		assert asResource == element.eResource();
		int savedDepth = debugDepth;
		assert debugDepth < 30;
		try {
			debugDepth++;
			Integer idObject = null;
			if (normalizeTemplateParameters) {
				idObject = normalizedElement2lussid.get(element);
				if (idObject != null) {
					return idObject.intValue();
				}
			}
			else {
				idObject = identifiedElement2lussid.get(element);
				if (idObject != null) {
					return idObject.intValue();
				}
				idObject = internalElement2lussid.get(element);
				if (idObject != null) {
					if (isReferenced) {
						identifiedElement2lussid.put(element, idObject);
					}
					return idObject.intValue();
				}
			}
			EObject eContainer = element.eContainer();
			int id = 0;
			if (eContainer instanceof Element) {
				id = CONTAINER_MULTIPLIER * assignLUSSID(as2id, (Element) eContainer, false, normalizeTemplateParameters);
				EReference eContainmentFeature = element.eContainmentFeature();
				id += CONTAINMENT_FEATURE_NAME_MULTIPLER * eContainmentFeature.getName().hashCode();
				if (eContainmentFeature.isMany()) {
					Integer localId = null;
					if (eContainmentFeature.isUnique() || !eContainmentFeature.isOrdered()) {
						localId = computeLocalLUSSID(as2id, element, normalizeTemplateParameters);
					}
					if (localId != null) {
						id += localId.intValue();
					}
					else {
						List<?> eSiblings = (List<?>) eContainer.eGet(eContainmentFeature);
						id += SIBLING_INDEX_MULTIPLIER * eSiblings.indexOf(element);
					}
				}
			}
			idObject = Integer.valueOf(id);
			assert idObject != null;
			if (normalizeTemplateParameters) {
				normalizedElement2lussid.put(element, idObject);
			}
			else if (isReferenced) {
				identifiedElement2lussid.put(element, idObject);
			}
			else {
				internalElement2lussid.put(element, idObject);
			}
			if (!normalizeTemplateParameters) {
				//
				//	Collisions on 32 bit hashcodes should be very unlikely, but poor hashing, null names may undermine
				//	the good principles. Fortunately they do not matter; the xmi:id disambiguation just has to work harder.
				//
				Map<@NonNull Integer, @NonNull Element> debugLUSSID2element2 = debugLUSSID2element;
				if (debugLUSSID2element2 != null) {
					Element oldElement = debugLUSSID2element2.get(idObject);
					if (oldElement != null) {
						Map<@NonNull Integer, @NonNull List<@NonNull Element>> debugLUSSID2collisions2 = debugLUSSID2collisions;
						if (debugLUSSID2collisions2 == null) {
							debugLUSSID2collisions = debugLUSSID2collisions2 = new HashMap<>();
						}
						List<@NonNull Element> collisions = debugLUSSID2collisions2.get(idObject);
						if (collisions == null) {
							collisions = new ArrayList<>();
							debugLUSSID2collisions2.put(idObject, collisions);
							collisions.add(oldElement);
						}
						collisions.add(element);
					}
					else {
						debugLUSSID2element2.put(idObject, element);
					}
				}
			}
			return id;
		}
		finally {
			debugDepth = savedDepth;
		}
	}

	protected void assignLUSSIDs(@NonNull AS2ID as2id) {
		assignmentStarted = true;
		UniqueList<@NonNull ASResource> referencedASResources = null;
		for (@NonNull EObject eObject : new TreeIterable(asResource)) {
			EClass eClass = eObject.eClass();
			assert eClass != null;
			boolean isExternallyReferenceable = isExternallyReferenceable(eObject);
			if (isExternallyReferenceable) {
				assignLUSSID(as2id, (ElementImpl) eObject, true, false);
			}
			FeatureIterator<EObject> featureIterator = (FeatureIterator<EObject>)eObject.eCrossReferences().iterator();
			while (featureIterator.hasNext()) {
				EObject eObject2 = featureIterator.next();
				EReference eReference = (EReference)featureIterator.feature();
				if (!eReference.isContainer() && !eReference.isTransient() && !eReference.isVolatile()) {
					Resource eResource = eObject2.eResource();
					if (eResource == asResource) {
						Object eTargetOrTargets = eObject.eGet(eReference);
						if (eReference.isMany()) {
							for (Object eTarget : (List<?>)eTargetOrTargets) {
								if (eTarget instanceof Element) {
									as2id.assignLUSSID((Element)eTarget, true, false);
								}
							}
						}
						else if (eTargetOrTargets instanceof Element) {
							as2id.assignLUSSID((Element)eTargetOrTargets, true, false);
						}
					}
					else if (eResource instanceof ASResource) {
						if (!((ASResource)eResource).isOrphanage()) {
							if (referencedASResources == null) {
								referencedASResources = new UniqueList<>();
							}
							referencedASResources.add((ASResource)eResource);
						}
						else {
							//	as2id.assignLUSSIDs((ASResource)eResource);
						}
					}
				}
			}
		}
		if (referencedASResources != null) {
			for (@NonNull ASResource referencedASResource : referencedASResources) {
				as2id.assignLUSSIDs(referencedASResource);
			}
		}
	}

	protected void assignXMIIDs(@NonNull AS2ID as2id) {
		Map<@NonNull String, @NonNull List<@NonNull Element>> xmiid2collisions2 = xmiid2collisions;
		for (@NonNull Element element : identifiedElement2lussid.keySet()) {
			Integer lussid = identifiedElement2lussid.get(element);
			assert lussid != null;
			String newXMIID = computeXMIID(lussid.intValue());
			String oldXMIID = asResource.getID(element);
			EObject oldElement = asResource.basicGetEObjectByID(newXMIID);
			if ((oldElement instanceof Element) && ((oldElement != element) || !oldXMIID.equals(newXMIID))) {
				if (xmiid2collisions2 == null) {
					xmiid2collisions = xmiid2collisions2 = new HashMap<>();
				}
				List<@NonNull Element> collisions = xmiid2collisions2.get(newXMIID);
				if (collisions == null) {
					collisions = new ArrayList<>();
					xmiid2collisions2.put(newXMIID, collisions);
					collisions.add((Element)oldElement);
				}
				collisions.add(element);
			}
			else {
				asResource.setID(element, newXMIID);
			}
		}
		if (xmiid2collisions2 != null) {
			for (@NonNull String xmiid : xmiid2collisions2.keySet()) {
				List<@NonNull Element> collisions = xmiid2collisions2.get(xmiid);
				assert collisions != null;
				XMIIDDisambiguationComparator comparator = new XMIIDDisambiguationComparator();
				Collections.sort(collisions, comparator);
				int suffix = 0;
				for (@NonNull Element element : collisions) {
					asResource.setID(element, computeDisambiguatedXMIID(xmiid, suffix));
					suffix++;
				}
			}
		}
	}

	/**
	 * Extend 5 base64 letter xmi:id with the disambiguating suffix.
	 */
	protected @NonNull String computeDisambiguatedXMIID(@NonNull String xmiid, int suffix) {
		StringBuilder s = new StringBuilder(xmiid);
		if (suffix == 1) {
			s.append(base64digits[0]);
		}
		else if (suffix > 1) {
			for (suffix--; suffix > 0; suffix >>= 6) {
				s.append(base64digits[suffix & 0x3F]);
			}
		}
		return s.toString();
	}

	/**
	 * Return the hash of the aspects of element that distinguish it from its siblings.
	 * Return null if there are no distinguishing aspects.
	 */
	protected abstract @Nullable Integer computeLocalLUSSID(@NonNull AS2ID as2id, @NonNull EObject element, boolean normalizeTemplateParameters);

	/**
	 * Return the 5 base64 letter xmi:id for the lussid.
	 */
	protected @NonNull String computeXMIID(int lussid) {
		StringBuilder s = new StringBuilder();
		for (int i = 0, hash = lussid; i++ < 5; hash >>= 6) {
			s.append(base64digits[hash & 0x3F]);
		}
		return s.toString();
	}

	public void dispose() {
		if (identifiedElement2lussid != null) {
			identifiedElement2lussid.clear();
		}
		if (internalElement2lussid != null) {
			internalElement2lussid.clear();
		}
		if (debugLUSSID2element != null) {
			debugLUSSID2element.clear();
		}
		if (debugLUSSID2collisions != null) {
			debugLUSSID2collisions.clear();
		}
		identifiedElement2lussid = null;
		internalElement2lussid = null;
		debugLUSSID2element = null;
		debugLUSSID2collisions = null;
		asResource.resetLUSSIDs();
	}

	/**
	 * @since 1.5
	 */
	public boolean isAssignmentStarted() {
		return assignmentStarted;
	}

	/**
	 * Return true if eObject may be referenced from another XMI file and so must have an xmi:id.
	 *
	 * FIXME misnomer. Internal references need xmi:ids too.
	 */
	protected abstract boolean isExternallyReferenceable(@NonNull EObject eObject);

	@Override
	public @NonNull String toString() {
		return String.valueOf(asResource.getURI());
	}
}