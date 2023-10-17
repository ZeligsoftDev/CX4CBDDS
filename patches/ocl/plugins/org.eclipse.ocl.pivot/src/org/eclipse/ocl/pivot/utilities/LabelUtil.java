/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * E.D.Willink - initial API and implementation
 * E.D.Willink - Bug 360072
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.labels.LabelSubstitutionLabelProvider;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
//import org.eclipse.ocl.ecore.Constraint;
//import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
//import org.eclipse.ocl.ecore.delegate.SettingBehavior;
//import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.labels.LabelGeneratorRegistry;

public class LabelUtil
{
	/**
	 * The global QUALIFIED_NAME_REGISTRY is used by qualifiedNameFor to generate qualified names
	 * for objects; typically a :: separted hierarchical name.  The QUALIFIED_NAME_REGISTRY delegates unsupported
	 * label generation to the SIMPLE_NAME_REGISTRY.
	 */
	public static ILabelGenerator.@NonNull Registry QUALIFIED_NAME_REGISTRY = new LabelGeneratorRegistry(ILabelGenerator.Registry.INSTANCE);

	/**
	 * The global SIMPLE_NAME_REGISTRY is used by simpleNameFor to generate simple names
	 * for objects; typically the name property. The SIMPLE_NAME_REGISTRY delegates unsupported
	 * label generation to the global ILabelGenerator.Registry.INSTANCE.
	 */
	public static ILabelGenerator.@NonNull Registry SIMPLE_NAME_REGISTRY = new LabelGeneratorRegistry(ILabelGenerator.Registry.INSTANCE);

	/**
	 * A SubstitutionLabelProvider instance that uses LaberlUtil.getLabel() to provide labels.
	 */
	public static EValidator.@NonNull SubstitutionLabelProvider SUBSTITUTION_LABEL_PROVIDER = new LabelSubstitutionLabelProvider();

	static {
		/**
		 * Install an ENamedElement label generator that suppresses hierarchy.
		 */
		SIMPLE_NAME_REGISTRY.install(ENamedElement.class, new AbstractLabelGenerator<ENamedElement>(ENamedElement.class)
		{
			@Override
			public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull ENamedElement labelledObject) {
				String name = labelledObject.getName();
				if (name != null)
					labelBuilder.appendString(name);
				else {
					labelBuilder.appendString("<null-named-");
					labelBuilder.appendString(labelledObject.getClass().getSimpleName());
					labelBuilder.appendString(">");
				}
			}
		});

		/**
		 * Install an ENamedElement label generator that :: separates hierarchical names.
		 */
		QUALIFIED_NAME_REGISTRY.install(ENamedElement.class, new AbstractLabelGenerator<ENamedElement>(ENamedElement.class)
		{
			@Override
			public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull ENamedElement labelledObject) {
				String name = labelledObject.getName();
				if (name != null)
					labelBuilder.appendString(name);
				else {
					labelBuilder.appendString("<null-named-");
					labelBuilder.appendString(labelledObject.getClass().getSimpleName());
					labelBuilder.appendString(">");
				}
			}
		});
	}

	public static <E extends EObject> E copy(E newObject) {
		return EcoreUtil.copy(newObject);
	}

	/**
	 * Return a context map for use by EValidator.validate in which the EValidator.class key
	 * is mapped to the eValidator, and the EValidator.SubstitutionLabelProvider.class key
	 * is mapped to a SubstitutionLabelProvider that uses getLabel().
	 */
	public static @NonNull Map<Object, Object> createDefaultContext(EValidator eValidator) {
		Map<Object, Object> context = new HashMap<Object, Object>();
		context.put(EValidator.SubstitutionLabelProvider.class, LabelUtil.SUBSTITUTION_LABEL_PROVIDER);
		context.put(EValidator.class, eValidator);
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(null);
		context.put(EnvironmentFactory.class, environmentFactory);
		return context;
	}

	/**
	 * Convert the map return from EcoreUtil.UnresolvedProxyCrossReferencer.find(xx)
	 * into a textual diagnosis.
	 * <br>
	 * Returns null if there are no unresolved URIs.
	 * <br>
	 * Returns a String containing a title line containing the contextURI and
	 * subsequent lines identifying each distinct unresolved URI.
	 */
	public static @Nullable String diagnoseUnresolvedProxies(@NonNull URI contextURI, @NonNull Map<EObject, Collection<EStructuralFeature.Setting>> map) {
		if (map.isEmpty())
			return null;
		Map<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> unresolvedURIs = new HashMap<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>>(map.size());
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : map.entrySet()) {
			EObject key = entry.getKey();
			URI uri = EcoreUtil.getURI(key);
			String uriString = uri.toString();
			if (!unresolvedURIs.containsKey(uriString))
				unresolvedURIs.put(uriString, entry);
		}
		StringBuilder s = new StringBuilder();
		s.append("Unresolved URIs in '" + String.valueOf(contextURI) + "' :");
		for (Map.Entry<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> unresolvedURI : unresolvedURIs.entrySet())
			s.append("\n    '" + unresolvedURI.getKey() + "'");
		return s.toString();
	}

	public static @Nullable <T extends Adapter> T getAdapter(@Nullable Notifier notifier, Class<T> adapterClass) {
		if (notifier == null)
			return null;
		return getAdapter(notifier.eAdapters(), adapterClass);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Adapter> T getAdapter(List<Adapter> eAdapters, Class<T> adapterClass) {
		return (T) EcoreUtil.getAdapter(eAdapters, adapterClass);
	}

	/**
	 * Return the specialised value of feature.getEType() resolving any type parameters
	 * from the specialised type of the sourceObject of the feature.
	 *
	 * @param sourceObject
	 * @param feature
	 */
	public static EClassifier getEType(EObject sourceObject, @NonNull EStructuralFeature feature) {
		EGenericType targetGenericType = feature.getEGenericType();
		ETypeParameter targetTypeParameter = targetGenericType.getETypeParameter();
		if ((targetTypeParameter != null) && (sourceObject != null)) {
			EClass sourceGenericType = feature.getEContainingClass();
			EObject typeParameterContainer = targetTypeParameter.eContainer();
			EClass sourceClass = sourceObject.eClass();
			EList<EGenericType> allSourceGenericSuperTypes = sourceClass.getEAllGenericSuperTypes();
			for (EGenericType sourceGenericSuperType : allSourceGenericSuperTypes) {
				if (sourceGenericSuperType.getERawType() == typeParameterContainer) {
					EList<EGenericType> sourceTypeArguments = sourceGenericSuperType.getETypeArguments();
					int i = sourceGenericType.getETypeParameters().indexOf(targetTypeParameter);
					if ((0 <= i) && (i < sourceTypeArguments.size())) {
						EGenericType sourceTypeArgument = sourceTypeArguments.get(i);
						return sourceTypeArgument.getERawType();
					}
				}
			}
		}
		return targetGenericType.getERawType();
	}

	/**
	 * Return the Ecore EStringToStringMapEntry that realises a given Constraint.
	 *
	 * @param constraint the constraint
	 * @return the annotation detail entry, null if not found
	 *
	public static Map.Entry<String, String> getEAnnotationDetail(Constraint constraint) {
		List<EModelElement> constrainedElements = constraint.getConstrainedElements();
		if (constrainedElements.isEmpty()) {
			return null;
		}
		EModelElement constrainedElement = constrainedElements.get(0);
		String keyName;
		String stereotype = constraint.getStereotype();
		if (UMLReflection.INVARIANT.equals(stereotype)) {
			keyName = constraint.getName();
			if (constrainedElement instanceof EClass) {
				EOperation apiOperation = EcoreUtils.getEcoreInvariant((EClass) constrainedElement, keyName);
				if (apiOperation != null) {
					constrainedElement = apiOperation;
					keyName = InvocationBehavior.BODY_CONSTRAINT_KEY;
				}
			}
		}
		else if (UMLReflection.DERIVATION.equals(stereotype)){
			keyName = SettingBehavior.DERIVATION_CONSTRAINT_KEY;
		}
		else if (UMLReflection.INITIAL.equals(stereotype)){
			keyName = SettingBehavior.INITIAL_CONSTRAINT_KEY;
		}
		else if (UMLReflection.BODY.equals(stereotype)){
			keyName = InvocationBehavior.BODY_CONSTRAINT_KEY;
		}
//			else if (UMLReflection.PRECONDITION.equals(stereotype)){
//				node = InvocationBehavior.PRECONDITION_CONSTRAINT_KEY;
//			}
//			else if (UMLReflection.POSTCONDITION.equals(stereotype)){
//				node = InvocationBehavior.POSTCONDITION_CONSTRAINT_KEY;
//			}
		else {
			keyName = null;
		}
	    EAnnotation eAnnotation = OCLCommon.getDelegateAnnotation(constrainedElement);
	    if (eAnnotation == null) {
	    	return null;
	    }
	    EMap<String, String> details = eAnnotation.getDetails();
	    if (keyName != null) {
	    	int indexOfKey = details.indexOfKey(keyName);
		    if (indexOfKey >= 0) {
		    	return details.get(indexOfKey);
		    }
	    }
		return null;
	} */

	/**
	 * Return the EOperation that realises the name invariant for eClass.
	 * @param eClass with invariant
	 * @param name of invariant
	 * @return the EOperation or null
	 */
	public static @Nullable EOperation getEcoreInvariant(@NonNull EClass eClass, @NonNull String name) {
		for (EOperation eOperation : eClass.getEOperations()) {
			if (ClassUtil.safeEquals(name, eOperation.getName()) && EcoreUtil.isInvariant(eOperation)) {
				return eOperation;
			}
		}
		return null;
	}

	public static <T> int getFeatureID(@NonNull Notification notification, @Nullable T expectedNotifier, @NonNull Class<T> featureClass) {
		if (expectedNotifier == null)
			return Notification.NO_FEATURE_ID;
		Object notifier = notification.getNotifier();
		if (notifier != expectedNotifier)
			return Notification.NO_FEATURE_ID;
		@Nullable T castNotifier = ClassUtil.asClassOrNull(notifier, featureClass);
		if (castNotifier == null)
			throw new IllegalArgumentException("EcoreUtils.getFeatureID: " + featureClass.getName() + " for a " + notifier.getClass().getName());
		return notification.getFeatureID(featureClass);
	}

	/**
	 * Return a simple readable description of eObject using an IItemLabelProvider if possible.
	 */
	public static @NonNull String getLabel(@Nullable Object object) {
		if (object instanceof Labelable) {
			String text = ((Labelable)object).getText();
			if (text != null) {
				return text;
			}
		}
		return NameUtil.qualifiedNameFor(object);
	}

	/**
	 * Return a simple readable description of object. If non-null eClassifier
	 * identifies the type of object. If non-null context may provide an ESubstitutionLabelProvider.
	 */
	public static String getLabel(EClassifier eClassifier, Object object, Map<Object, Object> context) {
		if (eClassifier instanceof EDataType) {
			return EObjectValidator.getValueLabel((EDataType) eClassifier, object, context);
		}
		else if (object instanceof EObject) {
			if (context != null) {					// Use an ESubstitutionLabelProvider
				return EObjectValidator.getObjectLabel((EObject)object, context);
			}
			else {									// Use an ItemProvider rather than EcoreUtil.getIdentification
				return LabelUtil.getLabel(object);
			}
		}
		else {			// Never happens
			return String.valueOf(object);
		}
	}
}
