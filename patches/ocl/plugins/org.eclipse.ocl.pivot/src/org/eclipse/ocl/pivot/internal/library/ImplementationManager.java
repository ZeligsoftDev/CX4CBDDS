/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.Technology;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.library.UnsupportedOperation;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.DerivedConstants;

/**
 * ImplementationManager encapsulates the knowledge about known feature implementations.
 */
public class ImplementationManager
{
	private static final Logger logger = LogManager.getLogger(ImplementationManager.class);

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull Technology technology;
	private final @NonNull PivotMetamodelManager metamodelManager;

	/**
	 * ClassLoaders that may be able to load a library implementation.
	 */
	private List<@NonNull ClassLoader> classLoaders = null;

	public ImplementationManager(@NonNull EnvironmentFactoryInternal environmentFactory) {
		this.environmentFactory = environmentFactory;
		this.technology = environmentFactory.getTechnology();
		this.metamodelManager = environmentFactory.getMetamodelManager();
	}

	public void addClassLoader(@NonNull ClassLoader classLoader) {
		List<ClassLoader> classLoaders = getClassLoaders();
		if (!classLoaders.contains(classLoader)) {
			classLoaders.add(classLoader);
		}
	}

	public @NonNull List<@NonNull ClassLoader> getClassLoaders() {
		List<@NonNull ClassLoader> classLoaders2 = classLoaders;
		if (classLoaders2 == null) {
			classLoaders2 = classLoaders = new ArrayList<@NonNull ClassLoader>();
			ClassLoader classLoader = metamodelManager.getClass().getClassLoader();
			assert classLoader != null;
			classLoaders2.add(classLoader);
		}
		return classLoaders2;
	}

	/*	protected @NonNull LibraryOperation getOperationImplementation(@NonNull Operation operation) {
		LibraryFeature implementation = metamodelManager.getImplementation(operation);
		String implementationClassName = operation.getImplementationClass();
		if (implementationClassName != null) {
			if (!implementation.getClass().getName().equals(implementationClassName)) {
				try {
					implementation = loadImplementation(operation);
					if (implementation instanceof LibraryOperation) {
						return (LibraryOperation)implementation;
					}
				} catch (Exception e) {
					logger.error("Failed to load implementation of '" + operation + "'", e);
				}
				return UnsupportedOperation.INSTANCE;
			}
		}
		ExpressionInOCL specification = metamodelManager.getBodyExpression(operation);
		if (specification != null) {
			return new ConstrainedOperation(specification);
		}
		return UnsupportedOperation.INSTANCE;
	} */

	// See Bug 458394 for the need for the asNavigationExp argument.
	public @NonNull LibraryProperty getPropertyImplementation(@Nullable Element asNavigationExp, @Nullable Object sourceValue, @NonNull Property property) {
		LibraryFeature implementation = property.getImplementation();
		String implementationClassName = property.getImplementationClass();
		if (implementationClassName != null) {
			if ((implementation == null) || !implementation.getClass().getName().equals(implementationClassName)) {
				try {
					implementation = loadImplementation(property);
					if (implementation instanceof LibraryProperty) {
						return (LibraryProperty) implementation;
					}
				} catch (Exception e) {
					logger.error("Failed to load implementation of '" + property + "'", e);
				}
				return UnsupportedOperation.INSTANCE;
			}
		}
		Type type = property.getType();
		if ((type instanceof Stereotype) && property.getName().startsWith(DerivedConstants.STEREOTYPE_EXTENSION_PREFIX)) {
			return technology.createExtensionPropertyImplementation(environmentFactory, property);
		}
		//		if (property.getOwningType() instanceof Stereotype) {
		//			return new BaseProperty(property);
		//		}
		ExpressionInOCL specification = metamodelManager.getDefaultExpression(property);
		if (property.isIsDerived() && (specification != null)) {
			return new ConstrainedProperty(property);
		}
		Property opposite = property.getOpposite();
		if ((opposite != null) && opposite.isIsComposite()) {
			if (property.eContainer() instanceof Stereotype) {
				return technology.createBasePropertyImplementation(environmentFactory, property);
			}
			if (type != null) {
				EObject eTarget = opposite.getESObject();
				if (eTarget instanceof EReference) {
					return new CompositionProperty((EReference) eTarget, opposite.getPropertyId());
				}
				if (eTarget != null) {
					Resource resource = opposite.eResource();
					if (resource instanceof ASResource) {
						ASResource asResource = (ASResource)resource;
						EReference eReference = asResource.getASResourceFactory().getEReference(asResource, eTarget);
						if (eReference != null) {
							return new CompositionProperty(eReference, opposite.getPropertyId());
						}
					}
				}
				/*				eTarget = type.getETarget();
				if (eTarget != null) {
					EClass eOwningClass = eTarget.eClass();
					EClass eOwnedClass = property.getOwningType().getETarget().eClass();
					EList<EStructuralFeature> ownerStructuralFeatures = eOwningClass.getEAllStructuralFeatures();
					EList<EStructuralFeature> ownedStructuralFeatures = eOwnedClass.getEAllStructuralFeatures();
					EStructuralFeature eFeature = EcoreUtils.getNamedElement(ownerStructuralFeatures, opposite.getName());
					if (eFeature instanceof EReference) {
						return new CompositionProperty((EReference) eFeature, opposite.getPropertyId());
					}
				} */
			}
		}
		if (property.isIsImplicit()) {
			return new ImplicitNonCompositionProperty(property);
		}
		if (property.getOwningClass() instanceof TupleType) {
			TupleType tupleType = (TupleType)property.getOwningClass();
			String name = property.getName();
			assert name != null;
			TuplePartId tuplePartId = tupleType.getTypeId().getPartId(name);
			assert tuplePartId != null;
			return new TuplePartProperty(tuplePartId);
		}
		if (property.isIsStatic()) {
			return new StaticProperty(property);
		}
		if ((property.getOwningClass() instanceof ElementExtension)			// direct access to extension property
				|| (property.getOwningClass() instanceof Stereotype)) {			// indirect access from a Stereotype operation
			return technology.createStereotypePropertyImplementation(environmentFactory, property);
		}
		return technology.createExplicitNavigationPropertyImplementation(environmentFactory, asNavigationExp, sourceValue, property);
	}

	public void dispose() {
		classLoaders = null;
	}

	/**
	 * Return the implementation of a feature.
	 *
	 * @param feature to be implemented.
	 * @return the implementation, or null if the feature has no implementation
	 * as is the case for a normal model feature
	 * @throws ClassNotFoundException if the implementation class realising
	 * the implementation is not loadable
	 * @throws NoSuchFieldException if the implementation class realising
	 * the implementation does not provide a static INSTANCE field
	 * @throws SecurityException if the implementation class is not accessible
	 * @throws IllegalAccessException if the implementation class is not accessible
	 * @throws IllegalArgumentException if the implementation class is not accessible
	 */
	public @Nullable LibraryFeature loadImplementation(@NonNull Feature feature) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		LibraryFeature implementation = feature.getImplementation();
		if (implementation == null) {
			String implementationClassName = feature.getImplementationClass();
			if (implementationClassName != null) {
				Class<?> theClass = null;
				ClassLoader featureClassLoader = feature.getClass().getClassLoader();
				if (featureClassLoader != null) {
					addClassLoader(featureClassLoader);
				}
				ClassNotFoundException e = null;
				for (@NonNull ClassLoader classLoader : getClassLoaders()) {
					try {
						theClass = classLoader.loadClass(implementationClassName);
						e = null;
						break;
					} catch (ClassNotFoundException e1) {
						if (e == null) {
							e = e1;
						}
					}
				}
				if (e != null) {
					throw e;
				}
				if (theClass != null) {
					Field field = theClass.getField("INSTANCE");
					implementation = (LibraryFeature) field.get(null);
				}
			}
		}
		return implementation;
	}

	/**
	 * @since 1.18
	 */
	public @Nullable Class<?> loadImplementation(@NonNull Object context, @NonNull String className) throws ClassNotFoundException {
		Class<?> theClass = null;
		ClassLoader contextClassLoader = context.getClass().getClassLoader();
		if (contextClassLoader != null) {
			addClassLoader(contextClassLoader);
		}
		ClassNotFoundException e = null;
		for (@NonNull ClassLoader classLoader : getClassLoaders()) {
			try {
				theClass = classLoader.loadClass(className);
				e = null;
				break;
			} catch (ClassNotFoundException e1) {
				if (e == null) {
					e = e1;
				}
			}
		}
		if (e != null) {
			throw e;
		}
	//	if (theClass != null) {
	//		Field field = theClass.getField("INSTANCE");
	//		implementation = (LibraryFeature) field.get(null);
	//	}
		return theClass;
	}
}