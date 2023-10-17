/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.internal.resource.ICSI2ASMapping;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

/**
 * The CSI2ASMapping maintains the mapping between CS elements or rather their CSIs
 * that remain stable after recreation and the AS elements. This mapping may be used
 * repeatedly while editing (CS2AS conversions) to associate changing CS elements with
 * stable Pivot elements.
 * The mapping is also created during a AS2CS conversion to allow subsequent CS2AS
 * conversions to reuse the original AS elements.
 */
public class CSI2ASMapping implements ICSI2ASMapping
{
	/**
	 * Get the CSI2ASMapping owned by the environmentFactory on behalf of CS-aware consumers, or null if none in use.
	 */
	public static @Nullable CSI2ASMapping basicGetCSI2ASMapping(@NonNull EnvironmentFactoryInternal environmentFactory) {
		return (CSI2ASMapping) environmentFactory.getCSI2ASMapping();
	}

	/**
	 * Create/reuse the CSI2ASMapping owned by the environmentFactory on behalf of CS-aware consumers.
	 */
	public static @NonNull CSI2ASMapping getCSI2ASMapping(@NonNull EnvironmentFactoryInternal environmentFactory) {
		ICSI2ASMapping csi2asMapping = environmentFactory.getCSI2ASMapping();
		if (csi2asMapping == null) {
			csi2asMapping = new CSI2ASMapping(environmentFactory);
			environmentFactory.setCSI2ASMapping(csi2asMapping);
		}
		return (CSI2ASMapping) csi2asMapping;
	}

	/**
	 * An AbstractCSI defines the private interface for a CSI and the shared support for a hashCode and toString.
	 */
	private abstract static class AbstractCSI implements CSI
	{
		protected final int hashCode;

		protected AbstractCSI(int hashCode) {
			this.hashCode = hashCode;
		}

		@Override
		public int hashCode() {
			return hashCode;
		}

		public @Nullable AbstractCSI isCSIfor(@Nullable CSI thatParent, @Nullable EReference thatChild, @Nullable String thatName, int thatIndex) {
			return null;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			toString(s);
			return s.toString();
		}

		protected abstract void toString(@NonNull StringBuilder s);
	}

	/**
	 * A RootCSI defines the CSI for the root element in a CSI hierrachy for which the parent is a Resource.
	 */
	private static class RootCSI extends AbstractCSI
	{
		private final @NonNull String name;				//. Resource.uri
		private final int index;						// index in Resource.contents

		private RootCSI(int hashCode, @NonNull String name, int index) {
			super(hashCode);
			this.name = name;
			this.index = index;
		}

		@Override
		public @Nullable RootCSI isCSIfor(@Nullable CSI thatParent, @Nullable EReference thatChild, @Nullable String thatName, int thatIndex) {
			if (thatParent != null) {
				return null;
			}
			if (thatChild != null) {
				return null;
			}
			if (this.index != thatIndex){
				return null;
			}
			return ClassUtil.safeEquals(this.name, thatName) ? this : null;
		}

		@Override
		protected void toString(@NonNull StringBuilder s) {
			s.append(name);
			s.append("@");
			s.append(index);
		}
	}

	/**
	 * A MultipleChildCSI defines the CSI for the non-root element in a CSI hierarchy. The element may not have siblings.
	 */
	private static class SingleChildCSI extends AbstractCSI
	{
		protected final @NonNull AbstractCSI parent;
		protected final @NonNull EReference child;		// null only at root

		protected SingleChildCSI(int hashCode, @NonNull AbstractCSI parent, @NonNull EReference child) {
			super(hashCode);
			this.parent = parent;
			this.child = child;
		}

		@Override
		public @Nullable SingleChildCSI isCSIfor(@Nullable CSI thatParent, @Nullable EReference thatChild, @Nullable String thatName, int thatIndex) {
			if (this.parent != thatParent){
				return null;
			}
			if (this.child != thatChild){
				return null;
			}
			return this;
		}

		@Override
		protected void toString(@NonNull StringBuilder s) {
			parent.toString(s);
			s.append("/");
			s.append(child.getName());
		}
	}

	/**
	 * A MultipleChildCSI defines the CSI for the non-root element in a CSI hierarchy. The element may have siblings which are
	 * distinguished primarily by name, and then be sequential index of same-named elements.
	 */
	private static class MultipleChildCSI extends SingleChildCSI
	{
		protected final @Nullable String name;			// null for nameless elements, URI at root
		protected final int index;						// index of same-named elements in parent container

		private MultipleChildCSI(int hashCode, @NonNull AbstractCSI parent, @NonNull EReference child, @Nullable String name, int index) {
			super(hashCode, parent, child);
			this.name = name;
			this.index = index;
		}

		@Override
		public @Nullable MultipleChildCSI isCSIfor(@Nullable CSI thatParent, @Nullable EReference thatChild, @Nullable String thatName, int thatIndex) {
			if (super.isCSIfor(thatParent, thatChild, thatName, thatIndex) == null) {
				return null;
			}
			if (this.index != thatIndex){
				return null;
			}
			return ClassUtil.safeEquals(this.name, thatName) ? this : null;
		}

		@Override
		protected void toString(@NonNull StringBuilder s) {
			super.toString(s);
			if (name != null) {
				s.append("@");
				s.append(name);
			}
			s.append("@");
			s.append(index);
		}
	}

	/**
	 * HashedCSIs maintains the known CSIs in an array of entries that may comprise null for no content, a CSI for
	 * a single content or a List<CSI> for multiple content.
	 */
	private class HashedCSIs
	{
		/**
		 * And mask for the number of bins in hash2csis.
		 */
		private int hashMask;

		/**
		 * The known CSIs binned into hashSize null/single-CSI/multiple-List<CSI> entries.
		 */
		private Object[] hash2csis;

		public HashedCSIs(int hashSize) {
			int mask = 1;
			while ((mask < hashSize) && (mask < 0xFFFF)){
				mask = mask + mask + 1;
			}
			this.hashMask = mask;
			this.hash2csis = new Object[hashMask+1];
		}

		private void add(@NonNull AbstractCSI csi) {
			WeakReference<@Nullable AbstractCSI> csiRef = new WeakReference<>(csi);
			int hashCode = csi.hashCode();
			int hashIndex = hashCode & hashMask;
			Object entry = hash2csis[hashIndex];
			if (entry == null) {
				hash2csis[hashIndex] = csiRef;
			}
			else if (entry instanceof WeakReference<?>) {
				List<@NonNull WeakReference<@Nullable AbstractCSI>> csiList = new ArrayList<>();
				hash2csis[hashIndex] = csiList;
				@SuppressWarnings("unchecked")WeakReference<@Nullable AbstractCSI> castEntry = (WeakReference<@Nullable AbstractCSI>)entry;
				csiList.add(castEntry);
				csiList.add(csiRef);
			}
			else {
				@SuppressWarnings("unchecked") List<@NonNull WeakReference<@Nullable AbstractCSI>> csiList = (List<@NonNull WeakReference<@Nullable AbstractCSI>>) entry;
				csiList.add(csiRef);
			}
			// FIXME grow() ??
		}

		private @Nullable AbstractCSI find(int hashCode, @Nullable AbstractCSI thisParent, @Nullable EReference thisChild, @Nullable String thisName, int thisIndex) {
			int hashIndex = hashCode & hashMask;
			Object entry = hash2csis[hashIndex];
			if (entry instanceof List<?>) {
				@SuppressWarnings("unchecked") List<@NonNull WeakReference<@Nullable AbstractCSI>> csiList = (List<@NonNull WeakReference<@Nullable AbstractCSI>>) entry;
				for (@NonNull WeakReference<@Nullable AbstractCSI> thatRef : csiList) {
					AbstractCSI thatCSI = thatRef.get();
					if (thatCSI != null) {
						AbstractCSI childCSI = thatCSI.isCSIfor(thisParent, thisChild, thisName, thisIndex);
						if (childCSI != null) {
							return childCSI;
						}
					}
				}
			}
			else if (entry instanceof WeakReference<?>) {
				@SuppressWarnings("unchecked") WeakReference<@Nullable AbstractCSI> thatRef = (WeakReference<@Nullable AbstractCSI>) entry;
				AbstractCSI thatCSI = thatRef.get();
				if (thatCSI != null) {
					AbstractCSI childCSI = thatCSI.isCSIfor(thisParent, thisChild, thisName, thisIndex);
					if (childCSI != null) {
						return childCSI;
					}
				}
			}
			return null;
		}

		protected @NonNull RootCSI getRootCSI(@NonNull ElementCS csElement) {
			assert csElement.getCsi() == null;
			assert csElement.eContainer() == null;
			Resource eResource = ClassUtil.nonNullState(csElement.eResource());
			String uri = eResource.getURI().toString();
			int index = eResource.getContents().indexOf(csElement);
			int hashCode = 3 * uri.hashCode() + 53 * index;
			AbstractCSI csi = find(hashCode, null, null, uri, index);
			if (csi == null) {
				csi = new RootCSI(hashCode, uri, index);
			}
			add(csi);
			return (RootCSI)csi;
		}

		protected @NonNull CSI getChildCSI(@NonNull ElementCS csElement) {
			assert csElement.getCsi() == null;
			EObject eContainer = csElement.eContainer();
			assert eContainer instanceof ElementCS;
			AbstractCSI	thisParent = getCSI((ElementCS)eContainer);
			int parentHashCode = thisParent.hashCode();
			EReference eContainmentFeature = ClassUtil.nonNullState(csElement.eContainmentFeature());
			EReference thisChild = eContainmentFeature;
			int childHashCode = eContainmentFeature.hashCode();
			String thisName = null;
			if (csElement instanceof Nameable) {
				thisName = ((Nameable)csElement).getName();
			}
			AbstractCSI csi;
			if (eContainmentFeature.isMany()) {
				int thisIndex;
				@SuppressWarnings("unchecked") List<Object> siblings = (List<Object>) eContainer.eGet(eContainmentFeature);
				if (thisName == null) {
					thisIndex = siblings.indexOf(csElement);
				}
				else {
					int count = 0;
					for (Object sibling : siblings) {
						if (sibling == csElement) {
							break;
						}
						if (sibling instanceof Nameable) {
							String thatName = ((Nameable)sibling).getName();
							if (ClassUtil.safeEquals(thisName, thatName)) {
								count++;
							}
						}
					}
					thisIndex = count;
				}
				int nameHashCode = thisName != null ? thisName.hashCode() : 0;
				int hashCode = 3 * parentHashCode + 7 * childHashCode + nameHashCode + thisIndex;
				csi = find(hashCode, thisParent, thisChild, thisName, thisIndex);
				if (csi == null) {
					csi = new MultipleChildCSI(hashCode, thisParent, thisChild, thisName, thisIndex);
				}
			}
			else {
				int hashCode = 3 * parentHashCode + 7 * childHashCode;
				csi = find(hashCode, thisParent, thisChild, null, 0);
				if (csi == null) {
					csi = new SingleChildCSI(hashCode, thisParent, thisChild);
				}
			}
			add(csi);
			return csi;
		}
	}

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;

	/**
	 * Mapping of each CS resource to its corresponding pivot Resource.
	 */
	protected final @NonNull Map<@NonNull BaseCSResource, @NonNull ASResource> cs2asResourceMap = new HashMap<>();

	protected final @NonNull Map<@NonNull BaseCSResource, @NonNull CS2AS> cs2as2as = new HashMap<>();

	/**
	 * The map from CS element (identified by URI) to pivot element at the end of the last update. This map enables
	 * the next update from a potentially different CS Resource and elements but the same URIs to re-use the pivot elements
	 * and to kill off the obsolete elements.
	 */
	private @NonNull Map<@NonNull CSI, @Nullable Element> csi2as = new HashMap<>();

	/**
	 * A lazily created inverse map that may be required for navigation from an outline.
	 */
	private @Nullable Map<@NonNull Element, @NonNull ModelElementCS> as2cs = null;

	/**
	 * The known CSIs binned into hashSize sublists.
	 */
	private @Nullable HashedCSIs hashedCSIs = null;

	/**
	 * Available CS2AS converters.
	 */
	//	private @Nullable List<CS2AS> cs2ases = null;

	private CSI2ASMapping(@NonNull EnvironmentFactoryInternal environmentFactory) {
		this.environmentFactory = environmentFactory;
	}

	public void add(@NonNull Map<@NonNull ? extends BaseCSResource, @NonNull ? extends ASResource> cs2asResourceMap) {
		as2cs = null;
		this.cs2asResourceMap.putAll(cs2asResourceMap);
	}

	public void add(@NonNull BaseCSResource csResource, @NonNull CS2AS cs2as) {
		as2cs = null;
		this.cs2asResourceMap.put(csResource, cs2as.getASResource());
		this.cs2as2as.put(csResource, cs2as);
		//		List<CS2AS> cs2ases2 = cs2ases;
		//		if (cs2ases2 == null) {
		//			cs2ases = cs2ases2 = new ArrayList<>();
		//		}
		//		cs2ases2.add(cs2as);
	}

	public @NonNull Set<@NonNull CSI> computeCSIs(@NonNull BaseCSResource csResource) {
		Set<@NonNull CSI> map = new HashSet<>();
		for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			if (eObject instanceof ModelElementCS) {
				ModelElementCS csElement = (ModelElementCS)eObject;
				CSI csURI = getCSI(csElement);
				map.add(csURI);
			}
		}
		return map;
	}

	protected @NonNull Map<@NonNull Element, @NonNull ModelElementCS> computeAS2CSMap() {
		Map<@NonNull Element, @NonNull ModelElementCS> map = new HashMap<>();
		for (Resource csResource : cs2asResourceMap.keySet()) {
			for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof ModelElementCS) {
					ModelElementCS csElement = (ModelElementCS)eObject;
					Element pivotElement = csElement.getPivot();
					if (pivotElement != null) {
						map.put(pivotElement, csElement);
					}
					//					System.out.println(ClassUtil.debugSimpleName(pivotElement) + " => " + ClassUtil.debugSimpleName(csElement));
				}
			}
		}
		return map;
	}

	@Override
	public void dispose() {
		for (@NonNull BaseCSResource csResource : new ArrayList<>(cs2as2as.keySet())) {
			csResource.dispose();
		}
		csi2as.clear();
		as2cs = null;
		//		List<CS2AS> cs2ases2 = cs2ases;
		//		if (cs2ases2 != null) {
		//			cs2ases = null;
		//			for (CS2AS cs2as : cs2ases2) {
		//				cs2as.dispose();
		//			}
		//		}
	}

	/**
	 * Return the Pivot element corresponding to a given CS element.
	 */
	public @Nullable Element get(@NonNull ModelElementCS csElement) {
		CSI csi = getCSI(csElement);
		return csi2as.get(csi);
	}

	/**
	 * Return the AS Resource corresponding to a given CS Resource.
	 */
	public @Nullable ASResource getASResource(@Nullable BaseCSResource csResource) {
		return cs2asResourceMap.get(csResource);
	}

	public @Nullable CS2AS getCS2AS(@NonNull BaseCSResource csResource) {
		return cs2as2as.get(csResource);
	}

	/**
	 * Get the Concrete Syntax Identifier for a CS element. This is a form of URI. It is significantly compacted to
	 * save on memory.
	 * @param csResource2aliasMap
	 */
	private @NonNull AbstractCSI getCSI(@NonNull ElementCS csElement) {
		CSI csi = csElement.getCsi();
		if (csi == null) {
			HashedCSIs hashedCSIs2 = hashedCSIs;
			if (hashedCSIs2 == null) {
				int size = 1024;
				Resource eResource = csElement.eResource();
				if (eResource != null) {
					int count = 0;
					for (TreeIterator<EObject> tit = eResource.getAllContents(); tit.hasNext(); tit.next()) {
						count++;
					}
					size = 4 * count;
				}
				hashedCSIs = hashedCSIs2 = new HashedCSIs(size);
			}
			EObject eContainer = csElement.eContainer();
			if (eContainer == null) {
				csi = hashedCSIs2.getRootCSI(csElement);
			}
			else { //if (eContainer instanceof ElementCS) {
				csi = hashedCSIs2.getChildCSI(csElement);
			}
			//			else {
			//				csi = hashedCSIs2.getOtherCSI(csElement);
			//			}
			csElement.setCsi(csi);
		}
		return (AbstractCSI) csi;
	}

	/**
	 * Return all mapped CS Resources.
	 */
	public @NonNull Set<@NonNull BaseCSResource> getCSResources() {
		return cs2asResourceMap.keySet();
	}

	public @Nullable ModelElementCS getCSElement(@NonNull Element pivotElement) {	// FIXME alternative outer/inner match options
		Map<@NonNull Element, @NonNull ModelElementCS> as2cs2 = as2cs;
		if (as2cs2 == null) {
			as2cs = as2cs2 = computeAS2CSMap();
		}
		ModelElementCS modelElementCS = as2cs2.get(pivotElement);
		for (EObject csContainer = modelElementCS; csContainer instanceof ModelElementCS; csContainer = csContainer.eContainer()) {
			if (((ModelElementCS)csContainer).getPivot() != pivotElement) {
				break;
			}
			modelElementCS = (ModelElementCS)csContainer;
		}
		if ((modelElementCS == null) && (pivotElement instanceof ExpressionInOCL)) {	// ExpressionInOCL may be created later
			EObject eObject = ((ExpressionInOCL)pivotElement).eContainer();
			if (eObject instanceof Element) {
				modelElementCS = as2cs2.get(eObject);
				if (modelElementCS instanceof ConstraintCS) {
					modelElementCS = ((ConstraintCS)modelElementCS).getOwnedSpecification();
				}
			}
		}
		return modelElementCS;
	}

	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}

	public @NonNull Map<@NonNull CSI, @Nullable Element> getMapping() {
		return csi2as;
	}

	/**
	 * Install the Pivot element corresponding to a given CS element.
	 */
	public void put(@NonNull ModelElementCS csElement, @Nullable Element pivotElement) {
		CSI csi = getCSI(csElement);
		csi2as.put(csi, pivotElement);
	}

	/**
	 * Remove the Resource mappings for all csResources. The CSI mappings persist until update() is called.
	 */
	public void removeCSResource(@NonNull BaseCSResource csResource) {
		as2cs = null;
		cs2asResourceMap.remove(csResource);
		cs2as2as.remove(csResource);
	}

	/**
	 * Update the mapping to cache the Pivot elements with respect to the CSIs for all CS elements in csResources.
	 */
	public void update() {
		as2cs = null;
		csi2as.clear();
		List<@NonNull BaseCSResource> iterationDomain = new ArrayList<>(cs2asResourceMap.keySet());
		int oldSize = cs2asResourceMap.size();
		while (true) {
			for (@NonNull BaseCSResource csResource : iterationDomain) {
				for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
					EObject eObject = it.next();
					if (eObject instanceof ModelElementCS) {
						ModelElementCS csElement = (ModelElementCS)eObject;
						Element pivotElement = csElement.getPivot();
						put(csElement, pivotElement);
					}
				}
			}
			int newSize = cs2asResourceMap.size();		// Bug 538551 - this iterationDomain was observed to grow
			if (newSize <= oldSize) {
				break;
			}
			oldSize = newSize;
			Set<@NonNull BaseCSResource> newIterationDomain = new HashSet<>(cs2asResourceMap.keySet());
			newIterationDomain.removeAll(iterationDomain);
			iterationDomain.clear();
			iterationDomain.addAll(newIterationDomain);
			assert iterationDomain.size() > 0;
			assert iterationDomain.size() == (newSize - oldSize);
		}
	}
}
