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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.InheritanceFragment;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Region;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.StateMachine;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Vertex;
import org.eclipse.ocl.pivot.ids.IdResolver.IdResolverExtension;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.internal.CompleteClassImpl;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.TypeUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class PartialClasses extends EObjectResolvingEList<org.eclipse.ocl.pivot.Class> implements ClassListeners.IClassListener
{
	private static final long serialVersionUID = 1L;
	public static final @NonNull TracingOption PARTIAL_CLASSES = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses");
//	static { PARTIAL_CLASSES.setState(true); }

	public static final @NonNull TracingOption ADD_BASE_PROPERTY = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses/addBaseProperty");
	public static final @NonNull TracingOption ADD_EXTENSION_PROPERTY = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses/addExtensionProperty");
	public static final @NonNull TracingOption INIT_MEMBER_OPERATIONS = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses/initMemberOperations");
	public static final @NonNull TracingOption INIT_MEMBER_PROPERTIES = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses/initMemberProperties");

/*	protected static class QualifiedName2DomainInheritance implements Function<String, DomainInheritance>
	{
		protected final @NonNull Map<String, DomainInheritance> name2superclasses;

		protected QualifiedName2DomainInheritance(@NonNull Map<String, DomainInheritance> name2superclasses) {
			this.name2superclasses = name2superclasses;
		}

		public DomainInheritance apply(String qualifiedClassName) {
			return name2superclasses.get(qualifiedClassName);
		}
	} */

	/**
	 * Lazily created map from operation name to map of parameter types to the list of partial operations to be treated as merged.
	 */
	private @Nullable Map<@NonNull String, @NonNull PartialOperations> name2partialOperations = null;

	/**
	 * Lazily created map from property name to the list of properties to be treated as merged.
	 */
	private @Nullable Map<@NonNull String, @NonNull PartialProperties> name2partialProperties = null;

	private Set<@NonNull CompleteClassInternal> superCompleteClasses = null;

	/**
	 * Lazily created map from class name to the superclass. This is a map from unqualified name to
	 * class for the normal case when all superclass names are distinct. However if any two superclasses
	 * including this class share a name, all superclasses are mapped by qualified name, and the
	 * name2qualifiedNames provides an additional mapping of the ambiguities.
	 */
//	private @Nullable Map<String, DomainInheritance> name2superclasses = null;		// FIXME duplicates superCompleteClasses

	/**
	 * Lazily created map from class name to the list of qualified names for same-named super-classes.
	 * This list is only non-null if a class has two same-named superclasses that need disambiguation..
	 */
//	private @Nullable Map<String, List<String>> name2qualifiedNames = null;

	/**
	 * Lazily created map from state name to the known state.
	 */
	private @Nullable Map<@NonNull String, @NonNull State> name2states = null;

	protected /*@NonNull*/ CompleteInheritanceImpl completeInheritance;

	/**
	 * Map from actual types to specialization.
	 * <br>
	 * The specializations are weakly referenced so that stale specializations are garbage collected.
	 */
	// FIXME tests fail if keys are weak since GC is too aggressive across tests
	// The actual types are weak keys so that parameterizations using stale types are garbage collected.
	//
	private @Nullable /*WeakHash*/Map<TemplateParameters, WeakReference<org.eclipse.ocl.pivot.Class>> specializations = null;

	public PartialClasses(@NonNull CompleteClassImpl completeClass) {
		super(org.eclipse.ocl.pivot.Class.class, completeClass, PivotPackage.Literals.COMPLETE_CLASS__PARTIAL_CLASSES.getFeatureID());
	}

	@Override
	public void addUnique(org.eclipse.ocl.pivot.Class partialClass) {
		assert partialClass != null;
		didAdd(partialClass);
		super.addUnique(partialClass);
	}

	@Override
	public void addUnique(int index, org.eclipse.ocl.pivot.Class partialClass) {
		assert partialClass != null;
		didAdd(partialClass);
		super.addUnique(index, partialClass);
	}

	public @NonNull Set<@NonNull CompleteClassInternal> computeSuperCompleteClasses() {
		Set<@NonNull CompleteClassInternal> superCompleteClasses2 = superCompleteClasses;
		if (superCompleteClasses2 == null) {
			CompleteModelInternal completeModel = getCompleteModel();
			superCompleteClasses2 = superCompleteClasses = new HashSet<@NonNull CompleteClassInternal>();
			for (org.eclipse.ocl.pivot.Class partialClass : this) {
				for (org.eclipse.ocl.pivot.@NonNull Class partialSuperClass : ClassUtil.nullFree(partialClass.getSuperClasses())) {
					CompleteClassInternal superCompleteClass = completeModel.getCompleteClass(PivotUtil.getUnspecializedTemplateableElement(partialSuperClass));
					superCompleteClasses2.add(superCompleteClass);
					superCompleteClasses2.addAll(superCompleteClass.getPartialClasses().computeSuperCompleteClasses());
				}
			}
			if (superCompleteClasses2.isEmpty()) {
				CompleteClassInternal oclAnyCompleteClass = completeModel.getCompleteClass(completeModel.getStandardLibrary().getOclAnyType());
				if (getCompleteClass() != oclAnyCompleteClass) {
					superCompleteClasses2.add(oclAnyCompleteClass);
				}
			}
		}
		return superCompleteClasses2;
	}

	protected @NonNull Property createExtensionProperty(@NonNull ElementExtension stereotypeInstance, org.eclipse.ocl.pivot.@NonNull Class baseType) {
		Stereotype stereotype = stereotypeInstance.getStereotype();
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		assert name2partialProperties2 != null;
		String extensionPropertyName = DerivedConstants.STEREOTYPE_EXTENSION_PREFIX + stereotype.getName();
		Property extensionProperty = null;
		PartialProperties partialProperties = name2partialProperties2.get(extensionPropertyName);
		if (partialProperties == null) {
			partialProperties = new PartialProperties(getEnvironmentFactory());
			name2partialProperties2.put(extensionPropertyName, partialProperties);
		}
		for (@NonNull Property partialProperty : partialProperties) {
			extensionProperty = partialProperty;
			break;
		}
		if (extensionProperty == null) {
			extensionProperty = PivotFactory.eINSTANCE.createProperty();
			extensionProperty.setName(extensionPropertyName);
			baseType.getOwnedProperties().add(extensionProperty);
		}
		extensionProperty.setType(stereotype);
		boolean isRequired = false;
		for (StereotypeExtender typeExtension : stereotype.getOwnedExtenders()) {
			Type metatype = typeExtension.getClass_();
			if ((metatype != null) && baseType.conformsTo(getStandardLibrary(), metatype)) {
				isRequired = true;
				break;
			}
		}
		extensionProperty.setIsRequired(isRequired);
		extensionProperty.setIsStatic(false);
		return extensionProperty;
	}

	protected org.eclipse.ocl.pivot.@NonNull Class createSpecialization(@NonNull TemplateParameters templateArguments) {
		org.eclipse.ocl.pivot.Class unspecializedType = getCompleteClass().getPrimaryClass();
		String typeName = unspecializedType.getName();
		TemplateSignature templateSignature = unspecializedType.getOwnedSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		EClass eClass = unspecializedType.eClass();
		EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
		org.eclipse.ocl.pivot.Class specializedType = (org.eclipse.ocl.pivot.Class) eFactoryInstance.create(eClass);
		specializedType.setName(typeName);
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		for (int i = 0; i < templateParameters.size(); i++) {
			TemplateParameter formalParameter = templateParameters.get(i);
			if (formalParameter != null) {
				Element templateArgument = templateArguments.get(i);
				if (templateArgument instanceof Type) {
					Type actualType = (Type) templateArgument;
					TemplateParameterSubstitution templateParameterSubstitution = CompleteInheritanceImpl.createTemplateParameterSubstitution(formalParameter, actualType);
					templateBinding.getOwnedSubstitutions().add(templateParameterSubstitution);
				}
			}
		}
		specializedType.getOwnedBindings().add(templateBinding);
		getCompleteModel().resolveSuperClasses(specializedType, unspecializedType);
//		if (specializedType instanceof Metaclass) {
//			Type instanceType = (Type) templateArguments.get(0);
//			Metaclass specializedMetaclass = (Metaclass)specializedType;
//			specializedMetaclass.setInstanceType(instanceType);
//		}
		specializedType.setUnspecializedElement(unspecializedType);
		Orphanage orphanage = getCompleteModel().getOrphanage();
		specializedType.setOwningPackage(orphanage);
		return specializedType;
	}

	protected void didAdd(org.eclipse.ocl.pivot.Class partialClass) {
		if (PARTIAL_CLASSES.isActive()) {
			PARTIAL_CLASSES.println("Do-didAdd " + this + " " + partialClass);
		}
		((ClassImpl)partialClass).addClassListener(this);
		if (partialClass.getUnspecializedElement() == null) {
			getCompleteModel().didAddClass(partialClass, getCompleteClass());
		}
//		if (name2partialProperties != null) {
//			doRefreshPartialProperties(partialClass);
//		}
//		if (name2partialOperations != null) {
//			doRefreshPartialOperations(partialClass);
//		}
		dispose();			// Force lazy recomputation
	}

	@Override
	protected void didRemove(int index, org.eclipse.ocl.pivot.Class partialClass) {
		assert partialClass != null;
		if (PARTIAL_CLASSES.isActive()) {
			PARTIAL_CLASSES.println("Do-didRemove " + this + " " + partialClass);
		}
		super.didRemove(index, partialClass);
		((ClassImpl)partialClass).removeClassListener(this);
		dispose();			// Force lazy recomputation
	}

	@Override
	public void didAddOperation(@NonNull Operation pivotOperation) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 != null) {
			String operationName = pivotOperation.getName();
			if (operationName != null) {
				PartialOperations partialOperations = name2partialOperations2.get(operationName);
				if (partialOperations == null) {
					partialOperations = new PartialOperations(getCompleteClass(), operationName);
					name2partialOperations2.put(operationName, partialOperations);
				}
				partialOperations.didAddOperation(pivotOperation);
			}
		}
	}

	@Override
	public void didAddProperty(@NonNull Property pivotProperty) {
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 != null) {
			String propertyName = pivotProperty.getName();
			PartialProperties partials = name2partialProperties2.get(propertyName);
			if (partials == null) {
				partials = new PartialProperties(getEnvironmentFactory());
				name2partialProperties2.put(propertyName, partials);
			}
			partials.didAddProperty(pivotProperty);
		}
	}

	@Override
	public void didAddSuperClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		if (completeInheritance != null) {
			completeInheritance.uninstall();
		}
	}

	@Override
	public void didRemoveOperation(@NonNull Operation pivotOperation) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 != null) {
			String operationName = pivotOperation.getName();
			PartialOperations partialOperations = name2partialOperations2.get(operationName);
			if (partialOperations != null) {
				if (partialOperations.didRemoveOperation(pivotOperation)) {
					name2partialOperations2.remove(operationName);
				}
			}
		}
	}

	@Override
	public void didRemoveProperty(@NonNull Property pivotProperty) {
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 != null) {
			String propertyName = pivotProperty.getName();
			PartialProperties partials = name2partialProperties2.get(propertyName);
			if (partials != null) {
				if (partials.didRemoveProperty(pivotProperty)) {
					name2partialProperties2.remove(propertyName);
				}
			}
		}
	}

	@Override
	public void didRemoveSuperClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		if (completeInheritance != null) {
			completeInheritance.uninstall();
		}
	}

	public void dispose() {
		CompleteClassInternal completeClass = getCompleteClass();
		CompletePackageInternal owningCompletePackage = completeClass.getOwningCompletePackage();
		if (owningCompletePackage != null) {
			owningCompletePackage.getPartialPackages().uninstalled(completeClass);
		}
		completeInheritance = null;
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 != null) {
			name2partialOperations2.clear();
			name2partialOperations = null;
		}
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 != null) {
			name2partialProperties2.clear();
			name2partialProperties = null;
		}
//		name2superclasses = null;
		superCompleteClasses = null;
	}

	public synchronized @Nullable Type findSpecializedType(@NonNull TemplateParameters templateArguments) {
		TemplateSignature templateSignature = getCompleteClass().getPrimaryClass().getOwnedSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		int iMax = templateParameters.size();
		if (templateArguments.parametersSize() != iMax) {
			return null;
		}
		Map<TemplateParameters, WeakReference<org.eclipse.ocl.pivot.Class>> specializations2 = specializations;
		if (specializations2 == null) {
			return null;
		}
		WeakReference<org.eclipse.ocl.pivot.Class> weakReference = specializations2.get(templateArguments);
		if (weakReference == null) {
			return null;
		}
		org.eclipse.ocl.pivot.Class specializedType = weakReference.get();
		if (specializedType != null) {
			int templateArgumentSize = templateArguments.parametersSize();
			for (int i = 0; i < templateArgumentSize; i++) {
				Type templateArgument = templateArguments.get(i);
				if (templateArgument.eResource() == null) {		// If GC pending
					specializedType = null;
					break;
				}
			}
		}
		if (specializedType == null) {
			synchronized (specializations2) {
				specializedType = weakReference.get();
				if (specializedType == null) {
					specializations2.remove(templateArguments);
				}
			}
		}
		return specializedType;
	}

	private void gatherAllStereotypes(@NonNull Set<Stereotype> allStereotypes, @NonNull Iterable<Stereotype> moreStereotypes) {
		Set<Stereotype> newStereotypes = null;
		PivotMetamodelManager metamodelManager = getMetamodelManager();
		for (@SuppressWarnings("null")@NonNull Stereotype stereotype : moreStereotypes) {
			stereotype = metamodelManager.getPrimaryElement(stereotype);
			if (allStereotypes.add(stereotype)) {
				CompleteClass superCompleteClass = null;
				if (stereotype instanceof CompleteInheritanceImpl) {
					superCompleteClass = ((CompleteInheritanceImpl)stereotype).getCompleteClass();
				}
				else {
					superCompleteClass = getCompleteModel().getCompleteClass(stereotype);
				}
				if (newStereotypes == null) {
					newStereotypes = new HashSet<Stereotype>();
				}
				for (org.eclipse.ocl.pivot.Class partialType : superCompleteClass.getPartialClasses()) {
					if (partialType instanceof Stereotype) {
						Stereotype partialStereotype = (Stereotype) partialType;
						newStereotypes.add(partialStereotype);
						for (org.eclipse.ocl.pivot.Class superType : partialStereotype.getSuperClasses()) {
							if (superType instanceof Stereotype) {
								Stereotype superStereotype = (Stereotype)superType;
								superType = metamodelManager.getPrimaryElement(superStereotype);
								newStereotypes.add(superStereotype);
							}
						}
					}
				}
			}
		}
		if (newStereotypes != null) {
			gatherAllStereotypes(allStereotypes, newStereotypes);
		}
	}

	@SuppressWarnings("null")
	public @NonNull CompleteClassInternal getCompleteClass() {
		return (CompleteClassImpl) owner;
	}

	public final @NonNull CompleteInheritanceImpl getCompleteInheritance() {
		CompleteInheritanceImpl completeInheritance2 = completeInheritance;
		if (completeInheritance2 == null) {
			CompleteClassInternal completeClass = getCompleteClass();
			CompletePackageInternal completePackage = completeClass.getOwningCompletePackage();
			completeInheritance2 = completePackage.getCompleteInheritance(completeClass);
			completeInheritance = completeInheritance2;
		}
		return completeInheritance2;
	}

	public @NonNull CompleteModelInternal getCompleteModel() {
		return getCompleteClass().getCompleteModel();
	}

	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return getCompleteClass().getEnvironmentFactory();
	}

	public @NonNull Iterable<@NonNull ? extends CompleteInheritance> getInitialSuperInheritances() {
		final @NonNull Iterator<@NonNull CompleteClassInternal> iterator = ClassUtil.nonNull(computeSuperCompleteClasses().iterator());			// FIXME Use local cache
		return new Iterable<@NonNull CompleteInheritance>()
		{
			@Override
			public @NonNull Iterator<@NonNull CompleteInheritance> iterator() {
				return new Iterator<@NonNull CompleteInheritance>()
				{
					@Override
					public boolean hasNext() {
						return iterator.hasNext();
					}

					@Override
					public @NonNull CompleteInheritance next() {
						CompleteClassInternal next = ClassUtil.nonNull(iterator.next());
						return next.getCompleteInheritance();
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}

	public @NonNull PivotMetamodelManager getMetamodelManager() {
		return getCompleteClass().getMetamodelManager();
	}

	public @Nullable Operation getOperation(@NonNull OperationId operationId) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		String operationName = operationId.getName();
		PartialOperations partialOperations = name2partialOperations2.get(operationName);
		if (partialOperations == null) {
			return null;
		}
		return partialOperations.getOperation(operationId.getParametersId(), null);
	}

	public @Nullable Operation getOperation(@NonNull Operation pivotOperation) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		PartialOperations partialOperations = name2partialOperations2.get(operationName);
		if (partialOperations == null) {
			return null;
		}
		return partialOperations.getOperation(pivotOperation.getParametersId(), pivotOperation.isIsStatic() ? FeatureFilter.SELECT_STATIC : FeatureFilter.SELECT_NON_STATIC);
	}

	public @NonNull Iterable<String> getOperationNames() {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		return name2partialOperations2.keySet();
	}

	public @Nullable Iterable<@NonNull Operation> getOperationOverloads(@NonNull Operation pivotOperation) {
		Map<@NonNull String, @NonNull PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		PartialOperations partialOperations = name2partialOperations2.get(operationName);
		if (partialOperations == null) {
			return null;
		}
		ParametersId parametersId = pivotOperation.getParametersId();
		return partialOperations.getOperationOverloads(parametersId, pivotOperation.isIsStatic() ? FeatureFilter.SELECT_STATIC : FeatureFilter.SELECT_NON_STATIC);
	}

	public @NonNull Iterable<@NonNull Operation> getOperationOverloads(final @Nullable FeatureFilter featureFilter, @Nullable String name) {
		Map<@NonNull String, @NonNull PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		PartialOperations partialOperations = name2partialOperations2.get(name);
		if (partialOperations == null) {
			return PivotMetamodelManager.EMPTY_OPERATION_LIST;
		}
		return partialOperations.getOperationOverloads(featureFilter);
	}

	public @NonNull Iterable<@NonNull Operation> getOperations() {
		Map<@NonNull String, @NonNull PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		Iterable<Iterable<Iterable<@NonNull Operation>>> transformed = Iterables.transform(name2partialOperations2.values(), PartialOperations.partialOperations2allOperations);
		@NonNull Iterable<@NonNull Operation> concat = Iterables.concat(Iterables.concat(transformed));
		return concat;
	}

	public @NonNull Iterable<@NonNull Operation> getOperations(final @Nullable FeatureFilter featureFilter) {
		Map<@NonNull String, @NonNull PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		Iterable<@NonNull PartialOperations> itMapListOps = name2partialOperations2.values();
		@NonNull Iterable<Iterable<Iterable<@NonNull Operation>>> itItListOps = Iterables.transform(itMapListOps, PartialOperations.partialOperations2allOperations);
		@NonNull Iterable<Iterable<@NonNull Operation>> itListOps = Iterables.concat(itItListOps);
		@NonNull Iterable<@NonNull Operation> itOps = Iterables.concat(itListOps);
		if (featureFilter == null) {
			return itOps;
		}
		@NonNull Iterable<@NonNull Operation> subItOps = Iterables.filter(itOps,
			new Predicate<@NonNull Operation>()
			{
				@Override
				public boolean apply(@NonNull Operation domainOperation) {
					return featureFilter.accept(domainOperation);
				}
			});
		return subItOps;
	}

	public @NonNull Iterable<@NonNull Property> getProperties(final @Nullable FeatureFilter featureFilter) {
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		List<@NonNull Property> properties = new ArrayList<@NonNull Property>();
		for (@NonNull PartialProperties partialProperties : name2partialProperties2.values()) {
			@Nullable Property property = partialProperties.get();
			if (property != null) {
				if (featureFilter == null) {
					properties.add(property);
				}
				else if (featureFilter.accept(property)) {
					properties.add(property);
				}
			}
		}
		return properties;
	}

	public @NonNull Iterable<@NonNull Property> getProperties(final @Nullable FeatureFilter featureFilter, @Nullable String name) {
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		PartialProperties partials = name2partialProperties2.get(name);
		if ((partials == null) || partials.isEmpty()) {
			return PivotMetamodelManager.EMPTY_PROPERTY_LIST;
		}
//		@SuppressWarnings("null")
//		@NonNull List<DomainProperty> singletonList = partials; //Collections.singletonList(partials.get(0));
		if (featureFilter == null) {
			return partials;
		}
		@NonNull Iterable<@NonNull Property> subItOps = Iterables.filter(partials,
			new Predicate<@NonNull Property>()
			{
				@Override
				public boolean apply(@NonNull Property domainProperty) {
					return featureFilter.accept(domainProperty);
				}
			});
		return subItOps;
	}

	public @Nullable Iterable<@NonNull Property> getProperties(@NonNull Property pivotProperty) {
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		String propertyName = pivotProperty.getName();
		return name2partialProperties2.get(propertyName);
	}

	public @Nullable Iterable<@NonNull Property> getProperties(@Nullable String propertyName) {
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		return name2partialProperties2.get(propertyName);
	}

	public @Nullable Property getProperty(@Nullable String propertyName) {
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		PartialProperties partials = name2partialProperties2.get(propertyName);
		if (partials == null) {
			return null;
		}
		return partials.get();
	}

	public synchronized org.eclipse.ocl.pivot.@NonNull Class getSpecializedType(@NonNull List<@NonNull ? extends Type> templateArguments) {
		return getSpecializedType(TypeUtil.createTemplateParameters(templateArguments));
	}

	public synchronized org.eclipse.ocl.pivot.@NonNull Class getSpecializedType(@NonNull TemplateParameters templateArguments) {
		TemplateSignature templateSignature = getCompleteClass().getPrimaryClass().getOwnedSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		int iMax = templateParameters.size();
		if (templateArguments.parametersSize() != iMax) {
			throw new IllegalArgumentException("Incompatible template argument count");
		}
		Map<TemplateParameters, WeakReference<org.eclipse.ocl.pivot.Class>> specializations2 = specializations;
		if (specializations2 == null) {
			synchronized(this) {
				specializations2 = specializations;
				if (specializations2 == null) {
					specializations2 = specializations = new /*Weak*/HashMap<TemplateParameters, WeakReference<org.eclipse.ocl.pivot.Class>>();
				}
			}
		}
		synchronized (specializations2) {
			org.eclipse.ocl.pivot.Class specializedType = null;
			WeakReference<org.eclipse.ocl.pivot.Class> weakReference = specializations2.get(templateArguments);
			if (weakReference != null) {
				specializedType = weakReference.get();
				if (specializedType != null) {
					int templateArgumentSize = templateArguments.parametersSize();
					for (int i = 0; i < templateArgumentSize; i++) {
						Type templateArgument = templateArguments.get(i);
						if (templateArgument.eResource() == null) {		// If GC pending
							specializedType = null;
							weakReference.clear();
							break;
						}
					}
				}
			}
			if (specializedType == null) {
				specializedType = createSpecialization(templateArguments);
				specializations2.put(templateArguments, new WeakReference<org.eclipse.ocl.pivot.Class>(specializedType));
			}
			return specializedType;
		}
	}

	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return getCompleteModel().getStandardLibrary();
	}

	public @NonNull Iterable<@NonNull State> getStates() {
		Map<@NonNull String, @NonNull State> name2states2 = name2states;
		if (name2states2 == null) {
			name2states2 = initStates();
		}
		return name2states2.values();
	}

	public @NonNull Iterable<@NonNull State> getStates(@Nullable String name) {
		Map<@NonNull String, @NonNull State> name2states2 = name2states;
		if (name2states2 == null) {
			name2states2 = initStates();
		}
		State state = name2states2.get(name);
		if (state == null) {
			return PivotMetamodelManager.EMPTY_STATE_LIST;
		}
		else {
			return Collections.singletonList(state);
		}
	}

	public @NonNull Iterable<@NonNull CompleteClass> getSuperCompleteClasses() {
		CompleteInheritance inheritance = getCompleteClass().getCompleteInheritance();
		return Iterables.transform(inheritance.getAllSuperFragments(), new Function<InheritanceFragment, @NonNull CompleteClass>()
		{
			@Override
			public @NonNull CompleteClass apply(InheritanceFragment input) {
				return ((CompleteInheritanceImpl)input.getBaseInheritance()).getCompleteClass();
			}
		});
	}

	protected void initExtensionPropertiesFrom(org.eclipse.ocl.pivot.@NonNull Class baseType, @NonNull Stereotype stereotype) {
		PivotMetamodelManager metamodelManager = getMetamodelManager();
		ElementExtension elementExtension = metamodelManager.getElementExtension(baseType, stereotype);
		Map<String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		assert name2partialProperties2 != null;

		Property extensionProperty = createExtensionProperty(elementExtension, baseType);
		didAddProperty(extensionProperty);
		if (ADD_EXTENSION_PROPERTY.isActive()) {
			ADD_EXTENSION_PROPERTY.println(NameUtil.qualifiedNameFor(extensionProperty) + " => " + NameUtil.qualifiedNameFor(extensionProperty.getType()));
		}
	}

	public void initMemberFeaturesFrom(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		if (name2partialOperations != null) {
			initMemberOperationsFrom(pivotType);
		}
		if (name2partialProperties != null) {
			initMemberPropertiesFrom(pivotType);		// FIXME invalidate is safer
		}
	}

	private @NonNull Map<@NonNull String, @NonNull PartialOperations> initMemberOperations() {
		Map<@NonNull String, @NonNull PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = name2partialOperations = new HashMap<@NonNull String, @NonNull PartialOperations>();
//			Set<CompleteClass> allSuperCompleteClasses = new HashSet<CompleteClass>();
//			allSuperCompleteClasses.add(completeClass);
//			for (CompleteClass superCompleteClass : completeClass.getSuperCompleteClasses()) {
//				allSuperCompleteClasses.add(superCompleteClass);
//			}
			for (@NonNull CompleteClass superCompleteClass : getSuperCompleteClasses()) {
				for (org.eclipse.ocl.pivot.@NonNull Class superType : ClassUtil.nullFree(superCompleteClass.getPartialClasses())) {
					org.eclipse.ocl.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement(superType);
					CompleteClass unspecializedCompleteClass = getCompleteModel().getCompleteClass(unspecializedType);
					for (org.eclipse.ocl.pivot.@NonNull Class unspecializedPartialType : ClassUtil.nullFree(unspecializedCompleteClass.getPartialClasses())) {
						assert unspecializedPartialType != null;
						initMemberOperationsFrom(unspecializedPartialType);
					}
				}
			}
			for (PartialOperations partialOperations : name2partialOperations2.values()) {
				partialOperations.initMemberOperationsPostProcess();
			}
		}
		return name2partialOperations2;
	}

	private void initMemberOperationsFrom(org.eclipse.ocl.pivot.@NonNull Class type) {
		if (INIT_MEMBER_OPERATIONS.isActive()) {
			INIT_MEMBER_OPERATIONS.println(this + " from " + type);
		}
		for (@SuppressWarnings("null")@NonNull Operation pivotOperation : type.getOwnedOperations()) {
			if (pivotOperation.getName() != null) {		// name may be null for partially initialized Complete OCL document.
				didAddOperation(pivotOperation);
			}
		}
	}

	protected @NonNull Map<String, @NonNull PartialProperties> initMemberProperties() {
		Map<@NonNull String, @NonNull PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = name2partialProperties = new HashMap<@NonNull String, @NonNull PartialProperties>();
			List<@NonNull ElementExtension> allExtensions = null;
			Set<@NonNull Stereotype> extendingStereotypes = null;
			Set<@NonNull Type> extendedTypes = null;
			for (@NonNull CompleteClass superCompleteClass : getSuperCompleteClasses()) {
				for (org.eclipse.ocl.pivot.@NonNull Class superType : ClassUtil.nullFree(superCompleteClass.getPartialClasses())) {
					org.eclipse.ocl.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement(superType);
					List<StereotypeExtender> extendedBys = unspecializedType.getExtenders();
					if (extendedBys.size() > 0) {
						if (extendingStereotypes == null) {
							extendingStereotypes = new HashSet<@NonNull Stereotype>();
						}
						for (@NonNull StereotypeExtender typeExtension : ClassUtil.nullFree(extendedBys)) {
							Stereotype stereotype = typeExtension.getOwningStereotype();
							if (stereotype != null) {
								extendingStereotypes.add(stereotype);
							}
						}
					}
					if (unspecializedType instanceof Stereotype) {
						List<@NonNull StereotypeExtender> extensionOfs = ClassUtil.nullFree(((Stereotype)unspecializedType).getOwnedExtenders());
						if (extensionOfs.size() > 0) {
							if (extendedTypes == null) {
								extendedTypes = new HashSet<@NonNull Type>();
							}
							for (@NonNull StereotypeExtender typeExtension : extensionOfs) {
								Type type = typeExtension.getClass_();
								if (type != null) {
									extendedTypes.add(type);
								}
							}
						}
					}
					CompleteClass unspecializedCompleteClass = getCompleteModel().getCompleteClass(unspecializedType);
					for (org.eclipse.ocl.pivot.@NonNull Class unspecializedPartialType : ClassUtil.nullFree(unspecializedCompleteClass.getPartialClasses())) {
						initMemberPropertiesFrom(unspecializedPartialType);
						List<@NonNull ElementExtension> extensions = ClassUtil.nullFree(unspecializedPartialType.getOwnedExtensions());
						if (extensions.size() > 0) {
							if (allExtensions == null) {
								allExtensions = new ArrayList<@NonNull ElementExtension>();
							}
							allExtensions.addAll(extensions);
						}
					}
				}
			}
			Class pivotClass = getCompleteClass().getPrimaryClass();
			if (INIT_MEMBER_PROPERTIES.isActive()) {
				INIT_MEMBER_PROPERTIES.println(this + " for " + pivotClass + " " + NameUtil.debugSimpleName(pivotClass));
			}
			if (extendingStereotypes != null) {
				Set<@NonNull Stereotype> allStereotypes = new HashSet<@NonNull Stereotype>();
				gatherAllStereotypes(allStereotypes, extendingStereotypes);
				for (@NonNull Stereotype stereotype : allStereotypes) {
					org.eclipse.ocl.pivot.@NonNull Class baseType = pivotClass;
					initExtensionPropertiesFrom(baseType, stereotype);
				}
			}
			@SuppressWarnings("null")@NonNull String metatypeName = pivotClass.eClass().getName();
			CompletePackageInternal rootCompletePackage = getCompleteClass().getOwningCompletePackage().getRootCompletePackage();
			Package pivotPackage = rootCompletePackage.getPrimaryPackage();
			if (pivotPackage != null) {
				EnvironmentFactoryInternal environmentFactory = getEnvironmentFactory();
				PackageId metapackageId = environmentFactory.getTechnology().getMetapackageId(environmentFactory, pivotPackage);
				org.eclipse.ocl.pivot.Package metapackage = ((IdResolverExtension)environmentFactory.getIdResolver()).basicGetPackage(metapackageId);
				if (metapackage != null) {
					CompletePackage metaCompletePackage = getMetamodelManager().getCompletePackage(metapackage);
					Type metatype = metaCompletePackage.getType(metatypeName);
					if (metatype != null) {
						CompleteClass metaCompleteClass = getCompleteModel().getCompleteClass(metatype);
						for (@NonNull Property property : metaCompleteClass.getProperties(FeatureFilter.SELECT_EXTENSION)) {
							didAddProperty(property);	// FIXME Clone the M2 property to have the correct M1 container/type
						}
					}
				}
			}
			for (@NonNull PartialProperties properties : name2partialProperties2.values()) {
				initMemberPropertiesPostProcess(getCompleteClass().getName(), properties);
			}
		}
		return name2partialProperties2;
	}

	protected void initMemberPropertiesFrom(org.eclipse.ocl.pivot.@NonNull Class asType) {
		org.eclipse.ocl.pivot.Class asPrimaryType = PivotUtil.getUnspecializedTemplateableElement(asType);
		if (INIT_MEMBER_PROPERTIES.isActive()) {
			INIT_MEMBER_PROPERTIES.println(this + " from " + asPrimaryType + " " + NameUtil.debugSimpleName(asPrimaryType));
		}
		for (ElementExtension extension : asPrimaryType.getOwnedExtensions()) {
			assert extension != null;
//			initStereotypePropertiesFrom((Type)asPrimaryType, extension);
		}
		for (@SuppressWarnings("null")@NonNull Property pivotProperty : asPrimaryType.getOwnedProperties()) {
			didAddProperty(pivotProperty);
		}
	}

	protected void initMemberPropertiesPostProcess(String name, @NonNull PartialProperties properties) {
		// TODO Auto-generated method stub // FIXME Prune occlusions
	}

	protected @NonNull Map<@NonNull String, @NonNull State> initStates() {
		Map<@NonNull String, @NonNull State> name2states = new HashMap<@NonNull String, @NonNull State>();
		for (@NonNull CompleteClass superCompleteClass : getSuperCompleteClasses()) {
			for (org.eclipse.ocl.pivot.@NonNull Class superPartialClass : ClassUtil.nullFree(superCompleteClass.getPartialClasses())) {
				for (@NonNull Behavior behavior : ClassUtil.nullFree(superPartialClass.getOwnedBehaviors())) {
					if (behavior instanceof StateMachine) {
						@NonNull List<@NonNull Region> regions = ClassUtil.nullFree(((StateMachine)behavior).getOwnedRegions());
						initStatesForRegions(name2states, regions);
					}
				}
			}
		}
		return name2states;
	}
	protected void initStatesForRegions(@NonNull Map<String, State> name2states, @NonNull List<@NonNull Region> regions) {
		for (@NonNull Region region : regions) {
			for (@NonNull Vertex vertex : ClassUtil.nullFree(region.getOwnedSubvertexes())) {
				if (vertex instanceof State) {
					State state = (State) vertex;
					name2states.put(vertex.getName(), state);
					@NonNull List<@NonNull Region> nestedRegions = ClassUtil.nullFree(state.getOwnedRegions());
					initStatesForRegions(name2states, nestedRegions);
				}
			}
		}
	}

/*	protected @NonNull Map<String, DomainInheritance> initSuperClasses() {
//		System.out.println("initSuperClasses " + toString());
		Map<String, DomainInheritance> name2superclasses2 = name2superclasses = new HashMap<String, DomainInheritance>();
		name2qualifiedNames = null;
		for (DomainFragment fragment : ((AbstractTypeServer)getTypeServer()).getFragments()) {
			DomainInheritance baseInheritance = fragment.getBaseInheritance();
			String name = baseInheritance.getName();
			DomainInheritance oldInheritance = name2superclasses2.put(name, baseInheritance);
			if (oldInheritance != null) {
				name2superclasses2.clear();
				name2qualifiedNames = initSuperClassesWithAmbiguousNames(name2superclasses2, new HashMap<String, List<String>>());
				break;
			}
		}
		return name2superclasses2;
	} */

/*	protected Map<String, List<String>> initSuperClassesWithAmbiguousNames(Map<String, DomainInheritance> name2superclasses2, Map<String, List<String>> name2qualifiedNames2) {
		int counter = 0;
		for (DomainFragment fragment : getCompleteClass().getCompleteInheritance().getFragments()) {
			DomainInheritance baseInheritance = fragment.getBaseInheritance();
			String name = baseInheritance.getName();
			String qualifiedName = Integer.toString(counter++);
			name2superclasses2.put(qualifiedName, baseInheritance);
			List<String> names = name2qualifiedNames2.get(name);
			if (names == null) {
				names = new ArrayList<String>();
				name2qualifiedNames2.put(name, names);
			}
			names.add(name);
		}
		return name2qualifiedNames2;
	} */
}