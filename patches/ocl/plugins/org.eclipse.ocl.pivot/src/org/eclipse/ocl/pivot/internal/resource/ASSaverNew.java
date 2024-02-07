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
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * ASSaverNew ensures that all references to synthesized types are terminated by local copies of the synthesized types.
 * This rewrite of ASSaver uses an EcoreUtil.Copier and EcoreUtil.CrossReferencer guaranteeing correct operation for all
 * references without requiring ASSaverLOcateVisitor or ASSaverResolveVisitor derivations with accurate overloading for
 * all references. ASSaver may well be faster but it is fragile and the improved performance is not justified.
 *
 * @since 1.18
 */
public class ASSaverNew extends AbstractASSaver
{
/*	protected static class ClassByMonikerComparator implements Comparator<org.eclipse.ocl.pivot.@NonNull Class>
	{
		@Override
		public int compare(org.eclipse.ocl.pivot.@NonNull Class o1, org.eclipse.ocl.pivot.@NonNull Class o2) {
			String s1 = AS2Moniker.toString(o1);
			String s2 = AS2Moniker.toString(o2);
			return s1.compareTo(s2);
		}
	} */

	@SuppressWarnings("serial")
	protected static class ASSaverCopier extends EcoreUtil.Copier
	{
		protected ASSaverCopier(@NonNull ASResource resource, boolean resolveProxies) {
			super(resolveProxies);
		}

		@Override
		public EObject copy(EObject eObject) {
			assert !(eObject instanceof TemplateParameter);		// Generalized class never needs localizing.
			return super.copy(eObject);
		}

		@Override
		protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
			if (eReference.isMany() && (eReference.getEOpposite() == null)) {
				@SuppressWarnings("unchecked")
				List<EObject> copyValues = (List<EObject>)copyEObject.eGet(eReference);
				copyValues.clear();						// Avoid dupicate superclasses when reloading
			}
			super.copyReference(eReference, eObject, copyEObject);
		}
	}

	public static class ASSaverWithInverse extends ASSaverNew
	{
		private final @NonNull Map<@NonNull EObject, @NonNull EObject> target2source = new HashMap<>();

		public ASSaverWithInverse(@NonNull ASResource resource) {
			super(resource);
		}

		public @Nullable EObject basicGetSource(@NonNull EObject target) {
			return target2source.get(target);
		}

		@SuppressWarnings("serial")
		@Override
		protected @NonNull ASSaverCopier createCopier(@NonNull ASResource resource) {
			return new ASSaverCopier(resource, true)
			{
				@Override
				public EObject put(EObject key, EObject value) {
					assert (key != null) && (value != null);
					EObject old = target2source.put(value, key);
					assert old == null;
					return super.put(key, value);
				}

			};
		}

		public @NonNull EObject getSource(@NonNull EObject target) {
			return ClassUtil.nonNullState(target2source.get(target));
		}
	}

	protected static class ClassByTypeIdAndEntryClassComparator implements Comparator<org.eclipse.ocl.pivot.@NonNull Class>
	{
		@Override
		public int compare(org.eclipse.ocl.pivot.@NonNull Class o1, org.eclipse.ocl.pivot.@NonNull Class o2) {
			TypeId t1 = o1.getTypeId();
			TypeId t2 = o2.getTypeId();
			String s1 = t1.toString();
			String s2 = t2.toString();
			int compareTo = s1.compareTo(s2);
			if (compareTo != 0) {
				return compareTo;
			}
			if ((o1 instanceof MapType) && (o2 instanceof MapType)) {
				org.eclipse.ocl.pivot.Class ec1 = ((MapType)o1).getEntryClass();
				org.eclipse.ocl.pivot.Class ec2 = ((MapType)o2).getEntryClass();
				if (ec1 == null) {
					if (ec2 != null) {
						return -1;
					}
				}
				else {
					if (ec2 == null) {
						return 1;
					}
					else {
						t1 = ec1.getTypeId();
						t2 = ec2.getTypeId();
						s1 = t1.toString();
						s2 = t2.toString();
						compareTo = s1.compareTo(s2);
					}
				}
			}
			return compareTo;
		}
	}

	/**
	 * The mapping from shared orphanage elements to their local counterpart.
	 */
	private final EcoreUtil.@NonNull Copier copier;

	public ASSaverNew(@NonNull ASResource resource) {
		super(resource);
		copier = createCopier(resource);
	}

	public @Nullable EObject basicGetTarget(@NonNull EObject source) {
		return copier.get(source);
	}

	protected @NonNull ASSaverCopier createCopier(@NonNull ASResource resource) {
		return new ASSaverCopier(resource, true);
	}

	public @NonNull EObject getTarget(@NonNull EObject source) {
		return ClassUtil.nonNullState(copier.get(source));
	}

	protected void loadOrphanage(org.eclipse.ocl.pivot.@NonNull Package localOrphanage, @NonNull Orphanage sharedOrphanage) {
		//
		//	Determine the global contents.
		//
		Map<@NonNull TypeId, org.eclipse.ocl.pivot.@NonNull Class> typeId2globalType = new HashMap<>();
		Map<@NonNull OperationId, @NonNull Operation> operationId2globalOperation = new HashMap<>();
		for (org.eclipse.ocl.pivot.@NonNull Class asClass : PivotUtil.getOwnedClasses(sharedOrphanage)) {
			if (!PivotConstants.ORPHANAGE_NAME.equals(asClass.getName())) {
				TypeId typeId = asClass.getTypeId();
				org.eclipse.ocl.pivot.Class old = typeId2globalType.put(typeId, asClass);
				assert old == null;
			}
			else {
				for (@NonNull Operation asOperation : PivotUtil.getOwnedOperations(asClass)) {
					Operation old = operationId2globalOperation.put(asOperation.getOperationId(), asOperation);
					assert old == null;
				}
			}
		}
		//
		//	Map the local contents to the global.
		//
		for (org.eclipse.ocl.pivot.@NonNull Class asLocalClass : PivotUtil.getOwnedClasses(localOrphanage)) {
			if (!PivotConstants.ORPHANAGE_NAME.equals(asLocalClass.getName())) {
				org.eclipse.ocl.pivot.Class asGlobalClass = typeId2globalType.get(asLocalClass.getTypeId());
				if (asGlobalClass != null) {
					copier.put(asGlobalClass, asLocalClass);
				}
			}
			else {
				for (@NonNull Operation asLocalOperation : PivotUtil.getOwnedOperations(asLocalClass)) {
					Operation asGlobalOperation = operationId2globalOperation.get(asLocalOperation.getOperationId());
					if (asGlobalOperation != null) {
						copier.put(asGlobalOperation, asLocalOperation);
					}
				}
			}
		}
	}

	/**
	 * Prepare a pivot resource for save by redirecting all type references to shared orphans to local copies of the orphans.
	 */
	public void localizeOrphans() {
		Model asModel = PivotUtil.getModel(resource);
		org.eclipse.ocl.pivot.Package localOrphanPackage = Orphanage.basicGetLocalOrphanPackage(asModel);
		Orphanage sharedOrphanage = Orphanage.getOrphanage(resource.getResourceSet());
		if (localOrphanPackage != null) {
			loadOrphanage(localOrphanPackage, sharedOrphanage);
		}
		Collection<@NonNull EObject> moreObjects = resource.getContents();
		while (moreObjects != null) {
			Map<EObject, Collection<Setting>> references = EcoreUtil.CrossReferencer.find(moreObjects);
			moreObjects = null;
			for (EObject eObject : references.keySet()) {
				assert eObject != null;
				for (EObject eContainer = eObject; eContainer != null; eContainer = eContainer.eContainer()) {
					if (eContainer == sharedOrphanage) {
						if (localOrphanPackage == null) {
							localOrphanPackage = Orphanage.createLocalOrphanPackage(asModel);
						}
						EObject eSource = eObject;
						if (eSource instanceof Property) {				// If Tuple Property referenced (before Tuple)
							eSource = eSource.eContainer();				//  copy the whole Tuple.
						}
						if (!copier.containsKey(eSource)) {
							assert eSource != null;
							EObject localEObject = copier.copy(eSource);
							if (moreObjects == null) {
								moreObjects = new ArrayList<>();
							}
							moreObjects.add(eSource);
							if (localEObject instanceof org.eclipse.ocl.pivot.Class) {
								localOrphanPackage.getOwnedClasses().add((org.eclipse.ocl.pivot.Class)localEObject);
							}
							else if (eSource instanceof Operation) {
								throw new UnsupportedOperationException();		// ?? copy whole container just like for Property??
					//			resolveOperation((Operation)eObject);
								}
						}
						break;
					}
					else if (eContainer == localOrphanPackage) {
						break;
					}
				}
			}
		}
		copier.copyReferences();
		if (localOrphanPackage != null) {
			ECollections.sort((EList<org.eclipse.ocl.pivot.@NonNull Class>)localOrphanPackage.getOwnedClasses(), new ClassByTypeIdAndEntryClassComparator());
		}
	}

	/**
	 * Return the localized variant of eObject. If eObject is an orphan, localizeSpecializations should have created
	 * a local copy that is returned here. Else returns eObject.
	 */
	public @Nullable EObject resolveOrphan(@NonNull EObject eObject) {
		EObject localEObject = copier.get(eObject);
		EObject eObject2 = localEObject != null ? localEObject : eObject;
	//	Model containingModel = PivotUtil.getContainingModel(eObject2);
	//	assert (containingModel == null) || !Orphanage.isOrphanage(containingModel);		// ElementLiteralExp references may be anywhere.
		return eObject2;
	}
}