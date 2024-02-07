/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicEAnnotationValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage;
import org.eclipse.ocl.pivot.internal.utilities.PivotDiagnostician;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.osgi.util.NLS;


/**
 *  An abstact annotation validator exploits a genmodelled EAnnotation metamodel to build an EAnnotationValidator
 *  that exploits caches tp avoid repeated feature traversals.
 *
 * @since 1.4
 */
public abstract class BasicEAnnotationValidator2 extends BasicEAnnotationValidator
{
	/**
	 * Derived BasicEAnnotationValidator2 classes may implement createAssistant to create a derived MapAssistant that
	 * provides a dynamic EClass with an EStructuralFeature per EAnnotation detail.
	 */
	protected static abstract class MapAssistant extends Assistant
	{
		private final /*@NonNull*/ EClass dynamicAnnotationClass;

		private final /*@NonNull*/ List</*@NonNull*/ EStructuralFeature> dynamicAnnotationFeatures;
		{
		}

		protected MapAssistant(@NonNull BasicEAnnotationValidator eAnnotationValidator, /*@NonNull*/ String className) {
			super(eAnnotationValidator);
			//
			//	Construct a pseudo Resource-EPackage-EClass to host the dynamically created EStructuralFeatures
			//	for the prevailing details.
			//
			Resource dynamicAnnotationResource = new XMIResourceImpl(URI.createURI(PivotAnnotationsPackage.eINSTANCE.getNsURI()));
			EPackage dynamicAnnotationPackage = EcoreFactory.eINSTANCE.createEPackage();
			dynamicAnnotationPackage.setName(PivotAnnotationsPackage.eINSTANCE.getName());
			dynamicAnnotationPackage.setNsPrefix(PivotAnnotationsPackage.eINSTANCE.getNsPrefix());
			dynamicAnnotationPackage.setNsURI(PivotAnnotationsPackage.eINSTANCE.getNsURI());
			dynamicAnnotationResource.getContents().add(dynamicAnnotationPackage);
			dynamicAnnotationClass = EcoreFactory.eINSTANCE.createEClass();
			dynamicAnnotationClass.setName(className);
			dynamicAnnotationPackage.getEClassifiers().add(dynamicAnnotationClass);
			dynamicAnnotationFeatures = dynamicAnnotationClass.getEStructuralFeatures();
		}

		protected abstract @NonNull EStructuralFeature createEStructuralFeature(/*@NonNull*/ String key);

		@Override
		public EObject createInstance(EClass eClass, EAnnotation eAnnotation) {
			refreshDynamicEClass(eAnnotation);
			EObject eInstance = EcoreUtil.create(dynamicAnnotationClass);
			for (EStructuralFeature eStructuralFeature : dynamicAnnotationFeatures) {
				String value = eAnnotation.getDetails().get(eStructuralFeature.getName());
				eInstance.eSet(eStructuralFeature, value);
			}
			return eInstance;
		}

		@Override
		public Map<String, EStructuralFeature> getProperties(EModelElement eModelElement) {
			Map<String, EStructuralFeature> properties = new HashMap<>();
			EAnnotation eAnnotation = eModelElement.getEAnnotation(eAnnotationValidator.getAnnotationSource());
			if (eAnnotation != null) {		// Should never be null.
				refreshDynamicEClass(eAnnotation);
				for (String key : eAnnotation.getDetails().keySet()) {
					properties.put(key, dynamicAnnotationClass.getEStructuralFeature(key));
				}
			}
			return properties;
		}

		private void refreshDynamicEClass(EAnnotation eAnnotation) {
			Map<String, EStructuralFeature> properties = new HashMap<>();
			//				EAnnotation eAnnotation = eModelElement.getEAnnotation(annotationSource);
			if (eAnnotation != null) {		// Should never be null.
				EMap<String, String> details = eAnnotation.getDetails();
				for (int i = dynamicAnnotationFeatures.size(); --i >= 0; ) {
					EStructuralFeature eStructuralFeature = dynamicAnnotationFeatures.get(i);
					String key = eStructuralFeature.getName();
					if (details.containsKey(key)) {
						properties.put(key, eStructuralFeature);
					}
					else {
						dynamicAnnotationFeatures.remove(i);
					}
				}
				for (Map.Entry<String, String> detail : details) {
					String key = detail.getKey();
					EStructuralFeature eStructuralFeature = properties.get(key);
					if (eStructuralFeature == null) {
						eStructuralFeature = createEStructuralFeature(key);
						dynamicAnnotationFeatures.add(eStructuralFeature);
						properties.put(key, eStructuralFeature);
					}
				}
			}
		}
	}

	/**
	 * The valid locations; the list of actual annotatable EClass in the annotated model for which annotation classes
	 * are declared. This list is eagerly populated by creation of the annotation model during construction.
	 */
	private final List<EClass> annotatableClasses = new ArrayList<EClass>();

	/**
	 * Map from an actual annotated EClass to the annotation EClass that defines permitted annotation properties.
	 * This map is eagerly populated during construction for the annotable classes and lazily populated thereafter
	 * as each request for a corresponding annotation class is made for a possibly derived but much more commonly
	 * for an unsupported class. Failed accesses are cached with a null annotation class value.
	 */
	private Map<EClass, EClass> annotatedClass2annotationClass = new HashMap<EClass, EClass>();

	/**
	 * Map from the declared annotation EClass to the key-value pairs of its declared annotations.
	 * This map is lazily populated as the properties of each class are first requested.
	 */
	private final Map<EClass, Map<String, EStructuralFeature>> annotationClass2name2annotationProperty = new HashMap<EClass, Map<String, EStructuralFeature>>();

	protected BasicEAnnotationValidator2(String annotationSource, String annotationName, String diagnosticSource, EClass... eAnnotationMetaClasses)
	{
		super(annotationSource, annotationName, diagnosticSource);
		if (eAnnotationMetaClasses != null) {
			for (EClass eAnnotationMetaClass : eAnnotationMetaClasses) {
				EAnnotation eAnnotation = eAnnotationMetaClass.getEAnnotation(PivotConstants.META_ANNOTATION_ANNOTATION_SOURCE);
				if (eAnnotation != null) {
					for (EObject reference : eAnnotation.getReferences()) {
						if (reference instanceof EClass) {
							EClass annotatableClass = (EClass)reference;
							annotatableClasses.add(annotatableClass);
							annotatedClass2annotationClass.put(annotatableClass, eAnnotationMetaClass);
						}
					}
				}
			}
		}
	}

	/**
	 * Return the EClass of the valid annotation that may be defined for annotatedClass or its superTypes.
	 * Returns null for no valid annotation.
	 */
	protected EClass getAnnotationClass(EClass annotatedClass) {
		EClass annotationClass = annotatedClass2annotationClass.get(annotatedClass);
		if ((annotationClass == null) && !annotatedClass2annotationClass.containsKey(annotatedClass)) {
			for (EClass eSuperClass : annotatedClass.getESuperTypes()) {
				annotationClass = getAnnotationClass(eSuperClass);
				if (annotationClass != null) {
					break;
				}
			}
			annotatedClass2annotationClass.put(annotatedClass, annotationClass);
		}
		return annotationClass;
	}

	/**
	 * The annotation classes are returned as a list of the getAnnotationClass return.
	 * The list never has multiple elements since multiple inheritance of annotations is not supported.
	 */
	@Override
	protected List<EClass> getPropertyClasses(EModelElement eModelElement)
	{
		EClass annotationClass = getAnnotationClass(eModelElement.eClass());
		return annotationClass != null ? Collections.singletonList(annotationClass) : Collections.<EClass>emptyList();
	}

	/**
	 * Return a map from the prevailing annotation detail keys to null properties.
	 * This helper method may be invoked by derived getProperties(EModelElement) methods of
	 * annotations for which the details are a map from arbitreaty keys to a usefule value.
	 * The map to null provides the keys that an AnnotationItemProvider requires.
	 */
	protected Map<String, EStructuralFeature> getNoFeatureProperties(EModelElement eModelElement) {
		Map<String, EStructuralFeature> properties = new HashMap<String, EStructuralFeature>();
		EAnnotation eAnnotation = eModelElement.getEAnnotation(annotationSource);
		if (eAnnotation != null) {		// Should never be null.
			for (String key : eAnnotation.getDetails().keySet()) {
				properties.put(key,  null);
			}
		}
		return properties;
	}

	/**
	 * The inherited API is re-implemented to exploit a lazily populated cache of the name to property
	 * mappings for each annotated class avoiding a re-computation for every model element.
	 *
	 * This override uses getEAllStructuralFeatures and so supports inheritance of annotation classes.
	 *
	 * The override does not respect the always-true isIncluded polling by the overriden implementation. Where derived
	 * classes implement a non-trivial isIncluded, they should override this method to append a filter that implements or
	 * invokes isIncluded.
	 */
	@Override
	protected Map<String, EStructuralFeature> getProperties(EModelElement eModelElement) {
		EClass annotationClass = getAnnotationClass(eModelElement.eClass());
		if (annotationClass != null) {
			Map<String, EStructuralFeature> name2annotationProperty = annotationClass2name2annotationProperty.get(annotationClass);
			if (name2annotationProperty == null) {
				name2annotationProperty = new HashMap<String, EStructuralFeature>();
				annotationClass2name2annotationProperty.put(annotationClass, name2annotationProperty);
				for (EStructuralFeature eStructuralFeature : annotationClass.getEAllStructuralFeatures()) {
					name2annotationProperty.put(eStructuralFeature.getName(), eStructuralFeature);
				}
			}
			return name2annotationProperty;
		}
		return null;
	}

	/**
	 * The resource locator delegates to the Pivot resourcelocator.
	 */
	@Override
	protected ResourceLocator getResourceLocator() {
		return PivotPlugin.INSTANCE;
	}

	/**
	 * The location description is overridden to enumerate all possible annotated classes rather than fail
	 * to provide a meaningless name.
	 */
	@Override
	protected String getValidLocationDescription()
	{
		StringBuilder s = new StringBuilder();
		for (EClassifier eClassifier : annotatableClasses) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append(eClassifier.getName());
		}
		String _UI_ValidAnnotationLocationDescription = "a {0}";
		String _UI_ValidAnnotationLocationDescriptions = "one of {0}";
		return NLS.bind(annotatableClasses.size() > 1 ? _UI_ValidAnnotationLocationDescriptions : _UI_ValidAnnotationLocationDescription, s.toString());
	}

	/**
	 * The override just tests whether any annotation classes are available. It therefore avoids the inherited costs
	 * of accessing properties and acccommodates annotations without properties.
	 */
	@Override
	protected boolean isValidLocation(EAnnotation eAnnotation, EModelElement eModelElement)
	{
		return getAnnotationClass(eModelElement.eClass()) != null;
	}

	/**
	 * This override defers creating of 'sub-title' BasicDiagnostics until a problem is identified that requires
	 * a sub-title. This is substantially more effecient than the inherited functionality that eagerly creates a
	 * 'sub-title' BasicDiagnostic for every annotation feature validation attempt.
	 *
	 * The saving occurs by creating the feature detail diagnostics in the calling title diagnostic and injecting
	 * a 'sub-title' BasicDiagnostic only if any feature detail diagnostics are actually produced.
	 *
	 * This is unfortunately not possible with the standard BasicDiagnostics 'title' diagnostic that totally hides
	 * its children inhibiting their removal to a 'sub-title'. To exploit the improvement the 'title' BasicDiagnostic
	 * should be a BasicDiagnosticRemove which may be conveniently achieved using the local validate static method.
	 */
	@Override
	protected boolean validateFeatureDetail(EAnnotation eAnnotation,
			EModelElement eModelElement, Entry<String, String> entry,
			EStructuralFeature feature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		int oldChildren;
		BasicDiagnostic childDiagnostic;
		if (diagnostics instanceof PivotDiagnostician.BasicDiagnosticWithRemove) {
			childDiagnostic = (BasicDiagnostic)diagnostics;
			oldChildren = childDiagnostic.getChildren().size();
		}
		else if (diagnostics == null) {
			childDiagnostic = null;
			oldChildren = -1;
		}
		else {
			childDiagnostic = createValueDiagnostic(eAnnotation, eModelElement, entry, feature);
			oldChildren = -1;
		}
		List<Object> values = new ArrayList<Object>();
		boolean result = feature instanceof EAttribute
				? validateAttributeDetailLiteralValue(eAnnotation, eModelElement, entry, (EAttribute)feature, values, childDiagnostic, context)
					: validateReferenceDetailLiteralValue(eAnnotation, eModelElement, entry, (EReference)feature, values, childDiagnostic, context);
				if (result)
				{
					result &= validateFeatureDetailValue(eAnnotation, eModelElement, entry, feature, values, childDiagnostic, context);
				}
				if (!result && (diagnostics != null))
				{
					if ((childDiagnostic instanceof PivotDiagnostician.BasicDiagnosticWithRemove) && (oldChildren >= 0))
					{
						BasicDiagnostic badValueDiagnostic = createValueDiagnostic(eAnnotation, eModelElement, entry, feature);
						List<Diagnostic> children = childDiagnostic.getChildren();
						for (int i = oldChildren; i < children.size(); i++) {
							badValueDiagnostic.add(((PivotDiagnostician.BasicDiagnosticWithRemove)childDiagnostic).remove(i));
						}
						diagnostics.add(badValueDiagnostic);
					}
					else {
						diagnostics.add(childDiagnostic);
					}
				}
				return result;
	}
}
