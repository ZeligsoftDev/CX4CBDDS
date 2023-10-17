/**
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.OrphanCompletePackage;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orphan Complete Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OrphanCompletePackageImpl extends CompletePackageImpl implements OrphanCompletePackage
{
	/**
	 * The number of structural features of the '<em>Orphan Complete Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ORPHAN_COMPLETE_PACKAGE_FEATURE_COUNT = CompletePackageImpl.COMPLETE_PACKAGE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Orphan Complete Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ORPHAN_COMPLETE_PACKAGE_OPERATION_COUNT = CompletePackageImpl.COMPLETE_PACKAGE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.ORPHAN_COMPLETE_PACKAGE;
	}

	private class OrphanCompleteClassImpl extends CompleteClassImpl
	{
		@Override
		public boolean conformsTo(final @NonNull CompleteClass thatCompleteClass) {
			final org.eclipse.ocl.pivot.@NonNull Class thisClass = getPrimaryClass();
			final org.eclipse.ocl.pivot.@NonNull Class thatClass = thatCompleteClass.getPrimaryClass();
			CompleteEnvironmentImpl completeEnvironmentImpl = new CompleteEnvironmentImpl()	{	// FIXME avoid this horrible fudge
				{
					this.ownedCompleteModel = getCompleteModel();
				}

				@Override
				public @NonNull CompleteClassInternal getCompleteClass(@NonNull Type asType) {
					if (asType == thisClass) {
						return OrphanCompleteClassImpl.this;
					}
					if (asType == thatClass) {
						return (@NonNull CompleteClassInternal) thatCompleteClass;
					}
					return super.getCompleteClass(asType);
				}
			};
			return completeEnvironmentImpl.conformsTo(thisClass, TemplateParameterSubstitutions.EMPTY, thatClass, TemplateParameterSubstitutions.EMPTY);
		}

		@Override
		public @NonNull CompletePackageInternal getOwningCompletePackage() {
			return OrphanCompletePackageImpl.this;
		}
	}

	private @NonNull Map<org.eclipse.ocl.pivot.Class, WeakReference<OrphanCompleteClassImpl>> class2orphanCompleteClass
	= new WeakHashMap<org.eclipse.ocl.pivot.Class, WeakReference<OrphanCompleteClassImpl>>();

	protected OrphanCompletePackageImpl()
	{
		super();
		init("$orphans$", "orph", PivotConstants.ORPHANAGE_URI);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOrphanCompletePackage(this);
	}

	@Override
	public void assertSamePackage(org.eclipse.ocl.pivot.@Nullable Package domainPackage) {
		assert domainPackage != null;
		org.eclipse.ocl.pivot.Package parentPackage = domainPackage.getOwningPackage();
		assert parentPackage == null;
		assert Orphanage.isTypeOrphanage(domainPackage);
	}

	public @NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		assert containerType == PivotUtil.getUnspecializedTemplateableElement(containerType);
		TemplateSignature templateSignature = containerType.getOwnedSignature();
		if (templateSignature == null) {
			throw new IllegalArgumentException("Collection type must have a template signature");
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		if (templateParameters.size() != 1) {
			throw new IllegalArgumentException("Collection type must have exactly one template parameter");
		}
		boolean isUnspecialized = elementType == templateParameters.get(0);
		if (isUnspecialized) {
			return containerType;
		}
		org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal completeClass = getCompleteModel().getCompleteClass(containerType);
		@SuppressWarnings("unchecked")
		T specializedType = (T) getCompleteModel().getCollectionType(completeClass, TypeUtil.createCollectionTypeParameters(elementType, isNullFree, lower, upper));
		return specializedType;
	}

	@Override
	public @NonNull CompleteClassInternal getCompleteClass(org.eclipse.ocl.pivot.@NonNull Class type) {
		WeakReference<OrphanCompleteClassImpl> ref = class2orphanCompleteClass.get(type);
		if (ref != null) {
			OrphanCompleteClassImpl orphanCompleteClass = ref.get();
			if (orphanCompleteClass != null) {
				return orphanCompleteClass;
			}
		}
		final org.eclipse.ocl.pivot.@NonNull Class orphanClass = type;
		OrphanCompleteClassImpl completeClass = new OrphanCompleteClassImpl();
		completeClass.setName(orphanClass.getName());
		completeClass.getPartialClasses().add(orphanClass);
		class2orphanCompleteClass.put(orphanClass, new WeakReference<OrphanCompleteClassImpl>(completeClass));
		return completeClass;
	}

	@Override
	public @NonNull CompleteInheritanceImpl getCompleteInheritance(@NonNull CompleteClassInternal completeClass) {
		return new CompleteInheritanceImpl(completeClass);
	}

	@Override
	public @Nullable CompleteClassInternal getOwnedCompleteClass(String name) {
		return null;			// No orphan CompleteClasses
	}
} //OrphanCompletePackageImpl
