/*******************************************************************************
 * Copyright (c) 2014, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.CompleteClassImpl;
import org.eclipse.ocl.pivot.internal.CompletePackageImpl;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.MapTypeParameters;

public class CompleteClasses extends EObjectContainmentWithInverseEList<CompleteClass>
{
	private static final Logger logger = LogManager.getLogger(CompleteClasses.class);

	public static final @NonNull TracingOption COMPLETE_CLASSES = new TracingOption(PivotPlugin.PLUGIN_ID, "completeClasses");
	//	static { COMPLETE_CLASSES.setState(true); }
	private static final long serialVersionUID = 1L;

	protected static class CollectionCompleteClassImpl extends CompleteClassImpl
	{
		/**
		 * Map from actual types to specialization.
		 * <br>
		 * The specializations are weakly referenced so that stale specializations are garbage collected.
		 */
		// FIXME tests fail if keys are weak since GC is too aggressive across tests
		// The actual types are weak keys so that parameterizations using stale types are garbage collected.
		// No. The problem is that CollectionTypeParameters is not a singleton since it passes an element type. Attempting to use
		// a SingletonScope needs to use the IdResolver to convert the TemplateParameterId to its type which seemed reluctant
		// to work, and failing to GC within the scope of this CompleteClass is not a disaster. May change once CompleteClass goes.
		//
		private @Nullable /*WeakHash*/Map<@NonNull CollectionTypeParameters<@NonNull Type>, @NonNull WeakReference<@Nullable CollectionType>> collections = null;

		protected @NonNull CollectionType createSpecialization(@NonNull CollectionTypeParameters<@NonNull Type> typeParameters) {
			org.eclipse.ocl.pivot.Class unspecializedType = getPrimaryClass();
			String typeName = unspecializedType.getName();
			TemplateSignature templateSignature = unspecializedType.getOwnedSignature();
			List<@NonNull TemplateParameter> templateParameters = ClassUtil.nullFree(templateSignature.getOwnedParameters());
			EClass eClass = unspecializedType.eClass();
			EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
			CollectionType specializedType = (CollectionType) eFactoryInstance.create(eClass);
			specializedType.setName(typeName);
			TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
			TemplateParameter formalParameter = ClassUtil.nonNull(templateParameters.get(0));
			assert formalParameter != null;
			Type elementType = typeParameters.getElementType();
			TemplateParameterSubstitution templateParameterSubstitution = CompleteInheritanceImpl.createTemplateParameterSubstitution(formalParameter, elementType);
			templateBinding.getOwnedSubstitutions().add(templateParameterSubstitution);
			specializedType.getOwnedBindings().add(templateBinding);
			getCompleteModel().resolveSuperClasses(specializedType, unspecializedType);
			CollectionType specializedCollectionType = specializedType;
			specializedCollectionType.setIsNullFree(typeParameters.isNullFree());
			try {
				specializedCollectionType.setLowerValue(typeParameters.getLower());
			} catch (InvalidValueException e) {
				logger.error("Out of range lower bound", e);
			}
			try {
				specializedCollectionType.setUpperValue(typeParameters.getUpper());
			} catch (InvalidValueException e) {
				logger.error("Out of range upper bound", e);
			}
			specializedType.setUnspecializedElement(unspecializedType);
			Orphanage orphanage = getCompleteModel().getOrphanage();
			specializedType.setOwningPackage(orphanage);
			return specializedType;
		}

		@Override
		public synchronized @Nullable CollectionType findCollectionType(@NonNull CollectionTypeParameters<@NonNull Type> typeParameters) {
			TemplateSignature templateSignature = getPrimaryClass().getOwnedSignature();
			List<@NonNull TemplateParameter> templateParameters = ClassUtil.nullFree(templateSignature.getOwnedParameters());
			if (templateParameters.size() != 1) {
				return null;
			}
			Map<@NonNull CollectionTypeParameters<@NonNull Type>, @NonNull WeakReference<@Nullable CollectionType>> specializations2 = collections;
			if (specializations2 == null) {
				return null;
			}
			WeakReference<CollectionType> weakReference = specializations2.get(typeParameters);
			if (weakReference == null) {
				return null;
			}
			CollectionType specializedType;
			synchronized (specializations2) {
				specializedType = weakReference.get();
				if (specializedType != null) {
					Type elementType = specializedType.getElementType();
					if ((elementType == null) || (elementType.eResource() == null)) {		// If GC pending
						specializedType = null;
						weakReference.clear();
					}
				}
				if (specializedType == null) {
					specializations2.remove(typeParameters);
				}
			}
			return specializedType;
		}

		@Override
		public synchronized @NonNull CollectionType getCollectionType(@NonNull CollectionTypeParameters<@NonNull Type> typeParameters) {
			Map<@NonNull CollectionTypeParameters<@NonNull Type>, @NonNull WeakReference<@Nullable CollectionType>> specializations2 = collections;
			if (specializations2 == null) {
				synchronized(this) {
					specializations2 = collections;
					if (specializations2 == null) {
						specializations2 = collections = new /*Weak*/HashMap<@NonNull CollectionTypeParameters<@NonNull Type>, @NonNull WeakReference<@Nullable CollectionType>>();
					}
				}
			}
			synchronized (specializations2) {
				CollectionType specializedType = null;
				WeakReference<@Nullable CollectionType> weakReference = specializations2.get(typeParameters);
				if (weakReference != null) {
					specializedType = weakReference.get();
					if (specializedType != null) {
						Type elementType = specializedType.getElementType();
						if ((elementType == null) || (elementType.eResource() == null)) {		// If GC pending
							specializedType = null;
							weakReference.clear();
						}
					}
				}
				if (specializedType == null) {
					specializedType = createSpecialization(typeParameters);
					specializations2.put(typeParameters, new WeakReference<@Nullable CollectionType>(specializedType));
				}
				return specializedType;
			}
		}
	}

	protected static class MapCompleteClassImpl extends CompleteClassImpl
	{
		/**
		 * Map from actual types to specialization.
		 * <br>
		 * The specializations are weakly referenced so that stale specializations are garbage collected.
		 */
		// FIXME tests fail if keys are weak since GC is too aggressive across tests
		// The actual types are weak keys so that parameterizations using stale types are garbage collected.
		// No. The problem is that MapTypeParameters is not a singleton since it passes key/value types. Attempting to use
		// a SingletonScope needs to use the IdResolver to convert the TemplateParameterId to its type which seemed reluctant
		// to work, and failing to GC within the scope of this CompleteClass is not a disaster. May change once CompleteClass goes.
		//
		private @Nullable /*WeakHash*/Map<@NonNull MapTypeParameters<@NonNull Type, @NonNull Type>, @NonNull WeakReference<@Nullable MapType>> maps = null;

		protected @NonNull MapType createSpecialization(@NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters) {
			org.eclipse.ocl.pivot.Class unspecializedType = getPrimaryClass();
			String typeName = unspecializedType.getName();
			TemplateSignature templateSignature = unspecializedType.getOwnedSignature();
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			EClass eClass = unspecializedType.eClass();
			EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
			MapType specializedMapType = (MapType) eFactoryInstance.create(eClass);
			specializedMapType.setName(typeName);
			TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
			TemplateParameter keyFormalParameter = templateParameters.get(0);
			TemplateParameter valueFormalParameter = templateParameters.get(1);
			assert keyFormalParameter != null;
			assert valueFormalParameter != null;
			Type keyType = typeParameters.getKeyType();
			Type valueType = typeParameters.getValueType();
			TemplateParameterSubstitution keyTemplateParameterSubstitution = CompleteInheritanceImpl.createTemplateParameterSubstitution(keyFormalParameter, keyType);
			TemplateParameterSubstitution valueTemplateParameterSubstitution = CompleteInheritanceImpl.createTemplateParameterSubstitution(valueFormalParameter, valueType);
			templateBinding.getOwnedSubstitutions().add(keyTemplateParameterSubstitution);
			templateBinding.getOwnedSubstitutions().add(valueTemplateParameterSubstitution);
			specializedMapType.getOwnedBindings().add(templateBinding);
			getCompleteModel().resolveSuperClasses(specializedMapType, unspecializedType);
			specializedMapType.setKeysAreNullFree(typeParameters.isKeysAreNullFree());
			specializedMapType.setValuesAreNullFree(typeParameters.isValuesAreNullFree());
			specializedMapType.setUnspecializedElement(unspecializedType);
			Orphanage orphanage = getCompleteModel().getOrphanage();
			specializedMapType.setOwningPackage(orphanage);
			specializedMapType.setEntryClass(typeParameters.getEntryClass());
			return specializedMapType;
		}

		@Override
		public synchronized @Nullable MapType findMapType(@NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters) {
			TemplateSignature templateSignature = getPrimaryClass().getOwnedSignature();
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			if (templateParameters.size() != 1) {
				return null;
			}
			Map<@NonNull MapTypeParameters<@NonNull Type, @NonNull Type>, @NonNull WeakReference<@Nullable MapType>> specializations2 = maps;
			if (specializations2 == null) {
				return null;
			}
			WeakReference<MapType> weakReference = specializations2.get(typeParameters);
			if (weakReference == null) {
				return null;
			}
			MapType specializedType;
			synchronized (specializations2) {
				specializedType = weakReference.get();
				if (specializedType != null) {
					Type keyType = specializedType.getKeyType();
					Type valueType = specializedType.getValueType();
					if ((keyType == null) || (valueType == null) || (keyType.eResource() == null) || (valueType.eResource() == null)) {		// If GC pending
						specializedType = null;
						weakReference.clear();
					}
				}
				if (specializedType == null) {
					specializations2.remove(typeParameters);
				}
			}
			return specializedType;
		}

		@Override
		public synchronized @NonNull MapType getMapType(@NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters) {
			Map<@NonNull MapTypeParameters<@NonNull Type, @NonNull Type>, @NonNull WeakReference<@Nullable MapType>> specializations2 = maps;
			if (specializations2 == null) {
				synchronized(this) {
					specializations2 = maps;
					if (specializations2 == null) {
						specializations2 = maps = new /*Weak*/HashMap<@NonNull MapTypeParameters<@NonNull Type, @NonNull Type>, @NonNull WeakReference<@Nullable MapType>>();
					}
				}
			}
			synchronized (specializations2) {
				MapType specializedType = null;
				WeakReference<@Nullable MapType> weakReference = specializations2.get(typeParameters);
				if (weakReference != null) {
					specializedType = weakReference.get();
					if (specializedType != null) {
						Type keyType = specializedType.getKeyType();
						Type valueType = specializedType.getValueType();
						if ((keyType == null) || (valueType == null) || (keyType.eResource() == null) || (valueType.eResource() == null)) {		// If GC pending
							specializedType = null;
							weakReference.clear();
						}
					}
				}
				if (weakReference != null) {
					specializedType = weakReference.get();
				}
				if (specializedType == null) {
					specializedType = createSpecialization(typeParameters);
					specializations2.put(typeParameters, new WeakReference<@Nullable MapType>(specializedType));
				}
				return specializedType;
			}
		}
	}

	protected @Nullable Map<String, CompleteClassInternal> name2completeClass = null;

	public CompleteClasses(@NonNull CompletePackageImpl owner) {
		super(CompleteClass.class, owner, PivotPackage.Literals.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES.getFeatureID(), PivotPackage.Literals.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE.getFeatureID());
		if (COMPLETE_CLASSES.isActive()) {
			COMPLETE_CLASSES.println("Create " + this);
		}
	}

	@Override
	protected void didAdd(int index, CompleteClass completeClass) {
		assert completeClass != null;
		super.didAdd(index, completeClass);
		didAdd((CompleteClassInternal) completeClass);
	}

	public void didAdd(@NonNull CompleteClassInternal completeClass) {
		Map<String, CompleteClassInternal> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			String name = completeClass.getName();
			if (name != null) {
				CompleteClass oldCompleteClass = name2completeClass2.put(name, completeClass);
				assert oldCompleteClass == null;
			}
		}
	}

	public void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		if (name2completeClass != null) {
			CompleteClassInternal completeClass = name2completeClass.get(partialClass.getName());
			if (completeClass == null) {
				doRefreshPartialClass(partialClass);
			}
			else {
				completeClass.addClass(partialClass);
			}
		}
	}

	public void didAddPackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		if (name2completeClass != null) {
			doRefreshPartialClasses(partialPackage);
		}
	}

	@Override
	protected void didRemove(int index, CompleteClass completeClass) {
		assert completeClass != null;
		didRemove(completeClass);
		super.didRemove(index, completeClass);
	}

	protected void didRemove(@NonNull CompleteClass completeClass) {
		Map<String, CompleteClassInternal> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			String name = completeClass.getName();
			if (name != null) {
				CompleteClassInternal oldCompleteClass = name2completeClass2.remove(name);
				assert oldCompleteClass == completeClass;
			}
		}
	}

	public void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		if (name2completeClass != null) {
			CompleteClassInternal completeClass = name2completeClass.get(partialClass.getName());
			if ((completeClass != null) && completeClass.didRemoveClass(partialClass)) {
				remove(completeClass);
				completeClass.dispose();
			}
		}
		if (partialClass.getUnspecializedElement() == null) {
			getCompleteModel().didRemoveClass(partialClass);
		}
	}

	public void didRemovePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		Map<String, CompleteClassInternal> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			for (org.eclipse.ocl.pivot.Class partialClass : partialPackage.getOwnedClasses()) {
				if (partialClass != null) {
					didRemoveClass(partialClass);
				}
			}
		}
	}

	protected void doRefreshPartialClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		Map<String, CompleteClassInternal> name2completeClass2 = name2completeClass;
		assert name2completeClass2 != null;
		CompleteModelInternal completeModel = getCompleteModel();
		String name = partialClass.getName();
		if (name != null) {
			CompleteClassInternal completeClass = null;
			if (partialClass instanceof PrimitiveType) {
				CompletePackageInternal primitiveCompletePackage = completeModel.getPrimitiveCompletePackage();
				completeClass = primitiveCompletePackage.getCompleteClass(partialClass);
			}
			else if ((partialClass instanceof MapType) && (partialClass.getUnspecializedElement() != null)) {
				CompletePackageInternal orphanCompletePackage = completeModel.getOrphanCompletePackage();
				completeClass = orphanCompletePackage.getCompleteClass(partialClass);
			}
			else if (PivotConstants.METAMODEL_NAME.equals(getCompletePackage().getURI())) {
				CompletePackageInternal primitiveCompletePackage = completeModel.getPrimitiveCompletePackage();
				completeClass = primitiveCompletePackage.getOwnedCompleteClass(name);
			}
			if (completeClass == null) {
				completeClass = name2completeClass2.get(name);
				if (completeClass == null) {
					if (partialClass.getOwnedSignature() == null) {
						completeClass = (CompleteClassInternal) PivotFactory.eINSTANCE.createCompleteClass();
					}
					else if (partialClass instanceof CollectionType) {
						completeClass = new CollectionCompleteClassImpl();
					}
					else if (partialClass instanceof MapType) {
						completeClass = new MapCompleteClassImpl();
					}
					else {
						completeClass = (CompleteClassInternal) PivotFactory.eINSTANCE.createCompleteClass();
					}
					completeClass.setName(name);
					add(completeClass);
				}
			}
			completeClass.addClass(partialClass);
		}
	}

	protected @NonNull Map<String, CompleteClassInternal> doRefreshPartialClasses() {
		Map<String, CompleteClassInternal> name2completeClass2 = name2completeClass;
		if (name2completeClass2 == null) {
			name2completeClass2 = name2completeClass = new HashMap<String, CompleteClassInternal>();
		}
		for (org.eclipse.ocl.pivot.Package partialPackage : getCompletePackage().getPartialPackages()) {
			if (partialPackage != null) {
				doRefreshPartialClasses(partialPackage);
			}
		}
		return name2completeClass2;
	}

	protected void doRefreshPartialClasses(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		for (org.eclipse.ocl.pivot.Class partialClass : partialPackage.getOwnedClasses()) {
			if (partialClass != null) {
				doRefreshPartialClass(partialClass);
			}
		}
	}

	public @NonNull CompleteModelInternal getCompleteModel() {
		return getCompletePackage().getCompleteModel();
	}

	@SuppressWarnings("null")
	public @NonNull CompletePackageInternal getCompletePackage() {
		return (@NonNull CompletePackageInternal) owner;
	}

	public @Nullable CompleteClassInternal getOwnedCompleteClass(String name) {
		Map<String, CompleteClassInternal> name2completeClass2 = name2completeClass;
		if (name2completeClass2 == null) {
			name2completeClass2 = doRefreshPartialClasses();
		}
		return name2completeClass2.get(name);
	}

	@Override
	public @NonNull Iterator<CompleteClass> iterator() {
		if (name2completeClass == null) {
			doRefreshPartialClasses();
		}
		return super.iterator();
	}

	@Override
	public @NonNull ListIterator<CompleteClass> listIterator() {
		if (name2completeClass == null) {
			doRefreshPartialClasses();
		}
		return super.listIterator();
	}

	@Override
	public @NonNull ListIterator<CompleteClass> listIterator(int index) {
		if (name2completeClass == null) {
			doRefreshPartialClasses();
		}
		return super.listIterator(index);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + owner.toString();
	}
}