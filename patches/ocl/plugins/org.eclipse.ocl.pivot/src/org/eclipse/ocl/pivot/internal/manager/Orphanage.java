/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.WildcardType;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.internal.PackageImpl;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * An Orphanage provides a Package that weakly contains elements such as type specializations that
 * should require a container for the purposes of validation, but which should be eligible for
 * garbage collection whenever no longer in use.
 * <br>
 * There is no global orphanage. Any reference to one is stale.
 * <br>
 * Each OCL CompleteModel has a shared orphanage that contains the referenced unique synthesized elements.
 * The shared orphanage is never saved and so the Orphanage class can be used.
 * <br>
 * Each saved ASResource has a local orphanage that contains a selective copy of the shared orphanage so that
 * all references are terminated locally. ASSaver creates this copy via PivotSaveImpl.init(). The local orphanages
 * use a regular Package to avod the need for Orphange support in XMI.
 */
public class Orphanage extends PackageImpl
{
	/**
	 * The OrphanResource tailors the inherited ASResource functionality to support the single Resource shared by all
	 * same-OCL consumers. It is not saved and so has no xmi:ids but it does have LUSSIDs
	 * in order to contribute to the signatures of operations.
	 */
	protected static class OrphanResource extends ASResourceImpl
	{
		protected OrphanResource(@NonNull URI uri) {
			super(uri, OCLASResourceFactory.getInstance());
			setUpdating(true);
			setSaveable(false);
		}

		@Override
		protected void doUnload() {
			if (contents != null) {
				for (EObject aContent : contents) {
					if (aContent instanceof Orphanage) {
						((Orphanage)aContent).dispose();
					}
				}
				contents = null;
			}
			//			super.doUnload();
		}

		@Override
		public String getURIFragment(EObject eObject) {
			// The OrphanResource cannot be saved so has no LUSSID-based xmi:ids, but Xtext serialization needs a URI
			return superGetURIFragment(eObject);
		}

		@Override
		public boolean isOrphanage() {
			return true;
		}
	}

	/**
	 * WeakEList enables a WeakHashMap to be used as a Package.ownedType. The weakness allows stale synthesized types to vanish.
	 * The Map ensures that duplicates are avoided.
	 * <br>
	 * Only the minimal support necessary to make aType.setPackage() and subsequent usage is provided.
	 * <br>
	 * A cached sorted list copy of the map is created on demand and may be shared by multiple iterators. However it must not be modified
	 * since its staleness is detected by a simple size comparison with the map.
	 */
	private static abstract class WeakEList<T extends NamedElement> extends AbstractEList<T> implements InternalEList<T>
	{
		/**
		 * A simple immutable iterator that caches the list image on construction to avoid changes.
		 */
		protected static class ListIterator<T> implements java.util.ListIterator<T>
		{
			protected final @NonNull List<Map.@NonNull Entry<@NonNull T, @NonNull Integer>> list;
			private final int size;
			private int cursor;

			public ListIterator(@NonNull List<Map.@NonNull Entry<@NonNull T, @NonNull Integer>> list, int index) {
				this.list = list;
				this.size = list.size();
				this.cursor = index;
				if ((cursor < 0) || (size < cursor)) {
					throw new NoSuchElementException(cursor + "/" + size);
				}
			}

			@Override
			public void add(T o) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean hasNext() {
				return cursor < size;
			}

			@Override
			public boolean hasPrevious() {
				return 0 < cursor;
			}

			@Override
			public T next() {
				if ((cursor < 0) || (size <= cursor)) {
					throw new NoSuchElementException(cursor + "/" + size);
				}
				return list.get(cursor++).getKey();
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public T previous() {
				int previousCursor = cursor - 1;
				if ((previousCursor < 0) || (size <= previousCursor)) {
					throw new NoSuchElementException(previousCursor + "/" + size);
				}
				cursor = previousCursor;
				return list.get(previousCursor).getKey();
			}

			@Override
			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void set(T o) {
				throw new UnsupportedOperationException();
			}
		}

		/**
		 * Map of content-value to list-index.
		 */
		private final @NonNull WeakHashMap<@NonNull T, @NonNull Integer> weakMap = new WeakHashMap<>();

		/**
		 * Incrementing counter used to sort the list into a predictable order.
		 */
		private int counter = 0;

		/**
		 * The most recent ordered view of the weakMap.
		 */
		private @Nullable List<@NonNull Entry<@NonNull T, @NonNull Integer>> weakList = null;

		@Override
		public boolean addAllUnique(Object[] objects, int start, int end) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAllUnique(int index, Object[] objects, int start, int end) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAllUnique(Collection<? extends T> collection) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAllUnique(int index, Collection<? extends T> collection) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void addUnique(T object) {
			basicAdd(object, null);
		}

		@Override
		public void addUnique(int index, T object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public NotificationChain basicAdd(T object, NotificationChain notifications) {
			assert object != null;
			synchronized (weakMap) {
				if (!weakMap.containsKey(object)) {
					weakMap.put(object, Integer.valueOf(counter++));
					weakList = null;
				}
			}
			return notifications;
		}

		protected abstract @NonNull ElementId getElementId(T object);

		@Override
		public boolean basicContains(Object object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean basicContainsAll(Collection<?> collection) {
			throw new UnsupportedOperationException();
		}

		@Override
		public T basicGet(int index) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int basicIndexOf(Object object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterator<T> basicIterator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int basicLastIndexOf(Object object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public List<T> basicList() {
			throw new UnsupportedOperationException();
		}

		@Override
		public ListIterator<T> basicListIterator() {
			return listIterator();
		}

		@Override
		public ListIterator<T> basicListIterator(int index) {
			return listIterator(index);
		}

		@Override
		public NotificationChain basicRemove(Object object, NotificationChain notifications) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object[] basicToArray() {
			throw new UnsupportedOperationException();
		}

		@Override
		public <T2> T2[] basicToArray(T2[] array) {
			throw new UnsupportedOperationException();
		}

		public void dispose() {
			synchronized (weakMap) {
				weakMap.clear();
				weakList = null;
			}
		}

		@Override
		public T get(int index) {
			List<@NonNull Entry<@NonNull T, @NonNull Integer>> weakList2 = getList();
			return weakList2.get(index).getKey();
		}

		private @NonNull List<@NonNull Entry<@NonNull T, @NonNull Integer>> getList() {
			List<@NonNull Entry<@NonNull T, @NonNull Integer>> weakList2;
			synchronized (weakMap) {
				weakList2 = weakList;
				if (weakList2 == null) {
					weakList2 = weakList = new ArrayList<>(weakMap.entrySet());
					Collections.sort(weakList2, new Comparator<Entry<T, Integer>>()
					{
						@Override
						public int compare(Entry<T, Integer> o1, Entry<T, Integer> o2) {
							return o1.getValue().intValue() - o2.getValue().intValue();
						}
					});
				}
			}
			return weakList2;
		}

		@Override
		public boolean isEmpty() {
			return weakMap.size() == 0;
		}

		//		@Override
		//		protected boolean isUnique() {
		//			return true;		-- implementing this makes things really really slow.
		//		}

		@Override
		public @NonNull Iterator<T> iterator() {
			return listIterator();
		}

		@Override
		public @NonNull ListIterator<T> listIterator() {
			return new ListIterator<T>(getList(), 0);
		}

		@Override
		public @NonNull ListIterator<T> listIterator(int index) {
			return new ListIterator<T>(getList(), index);
		}

		@Override
		public void move(int newPosition, T object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public T move(int newPosition, int oldPosition) {
			throw new UnsupportedOperationException();
		}

		@Override
		protected T primitiveGet(int index) {
			throw new UnsupportedOperationException();
		}

		@Override
		public T remove(int index) {
			throw new UnsupportedOperationException();
		}

		@Override
		public T setUnique(int index, T object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int size() {
			return weakMap.size();
		}

		@Override
		public String toString() {
			return weakMap.toString();
		}
	}

	public static final @NonNull URI ORPHANAGE_URI = ClassUtil.nonNullEMF(URI.createURI(PivotConstants.ORPHANAGE_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION));
	@Deprecated /* @deprecated The global Orphanage is never used */
	private static Orphanage ORPHAN_PACKAGE = null;

	/**
	 * @since 1.18
	 */
	public static org.eclipse.ocl.pivot.@Nullable Package basicGetLocalOrphanPackage(@NonNull Model asModel) {
		for (org.eclipse.ocl.pivot.Package asPackage : PivotUtil.getOwnedPackages(asModel)) {
			if (isOrphanage(asPackage)) {
				return asPackage;
			}
		}
		return null;
	}

	/**
	 * @since 1.18
	 */
	@Deprecated
	public static org.eclipse.ocl.pivot.@NonNull Package createLocalOrphanage() {
		org.eclipse.ocl.pivot.Package orphanage = PivotFactory.eINSTANCE.createPackage();
		orphanage.setName(PivotConstants.ORPHANAGE_NAME);
		orphanage.setNsPrefix(PivotConstants.ORPHANAGE_PREFIX);
		orphanage.setURI(PivotConstants.ORPHANAGE_URI);
		return orphanage;
	}

	/**
	 * Create and return the local orphanage Package within resource.
	 *
	 * @since 1.18
	 */
	public static org.eclipse.ocl.pivot.@NonNull Package createLocalOrphanPackage(@NonNull Model asModel) {
		org.eclipse.ocl.pivot.Package orphanage = PivotFactory.eINSTANCE.createPackage();
		orphanage.setName(PivotConstants.ORPHANAGE_NAME);
		orphanage.setNsPrefix(PivotConstants.ORPHANAGE_PREFIX);
		orphanage.setURI(PivotConstants.ORPHANAGE_URI);
		asModel.getOwnedPackages().add(orphanage);
		return orphanage;
	}

	/**
	 * @since 1.18
	 */
	public static @NonNull Orphanage createSharedOrphanage(@NonNull ResourceSet resourceSet) {
		Orphanage orphanage = new Orphanage(PivotConstants.ORPHANAGE_NAME, PivotConstants.ORPHANAGE_URI);
		Model orphanModel = PivotFactory.eINSTANCE.createModel();
		orphanModel.setName(PivotConstants.ORPHANAGE_NAME);;
		orphanModel.setExternalURI(PivotConstants.ORPHANAGE_URI);
		orphanModel.getOwnedPackages().add(orphanage);
		Resource orphanageResource = new OrphanResource(ORPHANAGE_URI);
		orphanageResource.getContents().add(orphanModel);
		resourceSet.getResources().add(orphanageResource);
		return orphanage;
	}

	@Deprecated /* @deprecated Never used */
	public static void disposeInstance() {
		if (ORPHAN_PACKAGE != null) {
			ORPHAN_PACKAGE.dispose();
			ORPHAN_PACKAGE = null;
		}
	}

	/**
	 * @since 1.18
	 */
	public static @NonNull WildcardType getOrphanWildcardType(org.eclipse.ocl.pivot.@NonNull Package orphanPackage) {
		List<org.eclipse.ocl.pivot.@NonNull Class> orphanClasses = PivotUtilInternal.getOwnedClassesList(orphanPackage);
		org.eclipse.ocl.pivot.Class wildcardType = NameUtil.getNameable(orphanClasses, PivotConstants.WILDCARD_NAME);
		if (wildcardType == null) {
			wildcardType = PivotFactory.eINSTANCE.createWildcardType();
			wildcardType.setName(PivotConstants.WILDCARD_NAME);
			wildcardType.setOwningPackage(orphanPackage);
		}
		return (WildcardType)wildcardType;
	}


	/**
	 * Return the Orphanage for an eObject, which is the Orphanage resource in the same ResourceSet as
	 * the eObject, else the global Orphanage.
	 */
	@Deprecated /* @deprecated - not used */
	public static @Nullable Orphanage getOrphanage(@NonNull EObject eObject) {
		//		if (eObject == null) {
		//			return null;
		//		}
		Resource resource = eObject.eResource();
		if (resource == null) {
			return null;
		}
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			return null;
		}
		return getOrphanage(resourceSet);
	}

	/**
	 * Return the Orphanage for a resourceSet if non-null. Obsolete deprecated functionality returns a global Orphanage if null.
	 */
	public static @NonNull Orphanage getOrphanage(@Nullable ResourceSet resourceSet) {
		if (resourceSet == null) {
			assert false : "Use of the global Orphanage is deprecated";
			Orphanage instance2 = ORPHAN_PACKAGE;
			if (instance2 == null) {
				instance2 = ORPHAN_PACKAGE = new Orphanage(PivotConstants.ORPHANAGE_NAME, PivotConstants.ORPHANAGE_URI);
			}
			return instance2;
		}
		for (Resource aResource : resourceSet.getResources()) {
			for (EObject eContent : aResource.getContents()) {
				if (eContent instanceof Model) {
					for (org.eclipse.ocl.pivot.Package asPackage : ((Model)eContent).getOwnedPackages()) {
						if (asPackage instanceof Orphanage) {
							return (Orphanage) asPackage;
						}
					}
				}
			}
		}
		return createSharedOrphanage(resourceSet);
	}

	/**
	 * Return true if asElement is transitively contained by a local or shared orphanage.
	 *
	 * @since 1.18
	 */
	public static boolean isOrphan(@NonNull Element asElement) {
		org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(asElement);
		return (asPackage != null) && isOrphanage(asPackage);
	}

	/**
	 * Return true if asModel is a shared orphanage for synthesized model elements.
	 *
	 * @since 1.18
	 */
	public static boolean isOrphanage(@NonNull Model asModel) {
		String uri = asModel.getExternalURI();
		return PivotConstants.ORPHANAGE_URI.equals(uri) || PivotConstantsInternal.OLD_ORPHANAGE_URI.equals(uri);
	}

	/**
	 * Return true if asPackage is an orphanage for synthesized model elements.
	 *
	 * @since 1.18
	 */
	public static boolean isOrphanage(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		String uri = asPackage.getURI();
		return PivotConstants.ORPHANAGE_URI.equals(uri) || PivotConstantsInternal.OLD_ORPHANAGE_URI.equals(uri);
	}

	/**
	 * Return true if asPackage is a local or shared orphanage for synthesized model elements.
	 */
	@Deprecated /* @deprected use isOrphanage() */
	public static boolean isTypeOrphanage(org.eclipse.ocl.pivot.@Nullable Package asPackage) {
		if (asPackage == null) {
			return false;
		}
		else {
			return isOrphanage(asPackage);
		}
	}

	public Orphanage(@NonNull String name, @NonNull String nsURI) {
		//		super(uri);
		//		setLoaded(true);
		setName(name);
		setURI(nsURI);
	}

	public void dispose() {
		if (ownedClasses != null) {
			((WeakEList<?>)ownedClasses).dispose();
		}
		if (ownedPackages != null) {
			((WeakEList<?>)ownedPackages).dispose();
		}
	}

	@Override
	public @NonNull EList<org.eclipse.ocl.pivot.Class> getOwnedClasses() {
		EList<org.eclipse.ocl.pivot.Class> ownedClasses2 = ownedClasses;
		if (ownedClasses2 == null)
		{
			ownedClasses2 = ownedClasses = new WeakEList<org.eclipse.ocl.pivot.Class>(/*WeakReference.class, this, PivotPackage.PACKAGE__OWNED_TYPE, PivotPackage.TYPE__PACKAGE*/)
					{
						@Override
						protected @NonNull ElementId getElementId(org.eclipse.ocl.pivot.Class object) {
							return object.getTypeId();
						}

					};
		}
		return ownedClasses2;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull EList<org.eclipse.ocl.pivot.Package> getOwnedPackages() {
		EList<org.eclipse.ocl.pivot.Package> ownedPackages2 = ownedPackages;
		if (ownedPackages2 == null)
		{
			ownedPackages2 = ownedPackages = new WeakEList<org.eclipse.ocl.pivot.Package>(/*WeakReference.class, this, PivotPackage.PACKAGE__OWNED_PACKAGE, PivotPackage.PACKAGE__OWNING_PACKAGE*/)
			{
				@Override
				protected @NonNull ElementId getElementId(org.eclipse.ocl.pivot.Package object) {
					return object.getPackageId();
				}

			};
		}
		return ownedPackages2;
	}
}