/*****************************************************************************
 * Copyright (c) 2013-2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Ed Seidewitz (IJI, MDS)
 *  Jeremie Tatibouet (CEA)
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Stereotype;

public class ModelMerge {
	
	private static final String TEXTUAL_REPRESENTATION_STEREOTYPE_NAME = "ActionLanguage::TextualRepresentation";

	protected List<EObject> originalElements = new BasicEList<EObject>();
	protected List<EObject> replacementElements = new BasicEList<EObject>();

	public ModelMerge() {
	}

	public void update(EObject target, EObject source) {
		// System.out.println("[update] target=" + target + " source=" + source);
		if (source instanceof Package && target instanceof Package) {
			this.addReplacement(source, target);
			Package sourcePackage = (Package) source;
			Package targetPackage = (Package) target;
			updateStereotypes(targetPackage, sourcePackage);
			setList(targetPackage.getOwnedComments(), sourcePackage.getOwnedComments());
			if (sourcePackage.isSetVisibility()) {
				targetPackage.setVisibility(sourcePackage.getVisibility());
			}
			targetPackage.setName(nameOf(sourcePackage));
			if (notStub(sourcePackage)) {
				this.updateCollection(targetPackage.getPackagedElements(), sourcePackage.getPackagedElements());
			}
		} else if (source instanceof Activity && target instanceof Activity) {
			// NOTE: Need to check for Activity before Class, since an Activity is a kind of Class.
			Activity sourceActivity = (Activity) source;
			Activity targetActivity = (Activity) target;
			this.updateClassifier(targetActivity, sourceActivity);
			this.updateCollection(targetActivity.getOwnedParameters(), sourceActivity.getOwnedParameters());
			targetActivity.setIsActive(sourceActivity.isActive());
			BehavioralFeature specification = sourceActivity.getSpecification();
			// NOTE: Removes the source activity as a method of its former specification.
			sourceActivity.setSpecification(null);
			targetActivity.setSpecification(specification);
			
			if (notStub(sourceActivity)) {
				// Replace the nodes and edges of the target activity with those from the source activity.
				// The nodes and edges contained in an activity are not preserved between two compilations.
				targetActivity.getNodes().clear();
				targetActivity.getEdges().clear();
				targetActivity.getOwnedNodes().addAll(sourceActivity.getOwnedNodes());
				targetActivity.getStructuredNodes().addAll(sourceActivity.getStructuredNodes());
				targetActivity.getEdges().addAll(sourceActivity.getEdges());
			}
		} else if (source instanceof Class && target instanceof Class) {
			Class sourceClass = (Class) source;
			Class targetClass = (Class) target;
			this.updateClassifier(targetClass, sourceClass);
		    targetClass.setIsActive(sourceClass.isActive());
		    if (notStub(sourceClass)) {
		    	// NOTE: Save this in case it is moved as an owned behavior from the source.
				Behavior sourceClassifierBehavior = sourceClass.getClassifierBehavior();
				this.updateCollection(targetClass.getOwnedAttributes(), sourceClass.getOwnedAttributes());
				this.updateCollection(targetClass.getOwnedOperations(), sourceClass.getOwnedOperations());
				this.updateCollection(targetClass.getOwnedReceptions(), sourceClass.getOwnedReceptions());
				this.updateCollection(targetClass.getOwnedBehaviors(), sourceClass.getOwnedBehaviors());
				this.updateCollection(targetClass.getNestedClassifiers(), sourceClass.getNestedClassifiers());
				if (sourceClass.isActive()) {
					// NOTE: Must use replacement, if any, or source classifier
					// behavior will be moved to the target owned behaviors.
					Behavior targetClassifierBehavior =
							(Behavior) this.getReplacement(sourceClassifierBehavior);
					if (targetClassifierBehavior == null) {
						targetClassifierBehavior = sourceClassifierBehavior;
					}
					targetClass.setClassifierBehavior(targetClassifierBehavior);
				} else {
					targetClass.setClassifierBehavior(null);
				}
		    }
		} else if (source instanceof Enumeration && target instanceof Enumeration) {
			// NOTE: Need to check for Enumeration before DataType, since an Enumeration is a kind of DataType.
			Enumeration sourceEnumeration = (Enumeration) source;
			Enumeration targetEnumeration = (Enumeration) target;
			this.updateClassifier(targetEnumeration, sourceEnumeration);
			if (notStub(sourceEnumeration)) {
				this.updateCollection(targetEnumeration.getOwnedLiterals(), sourceEnumeration.getOwnedLiterals());
			}
		} else if (source instanceof DataType && target instanceof DataType) {
			DataType sourceType = (DataType) source;
			DataType targetType = (DataType) target;
			this.updateClassifier(targetType, sourceType);
			if (notStub(sourceType)) {
				this.updateCollection(targetType.getOwnedAttributes(), sourceType.getOwnedAttributes());
			}
		} else if (source instanceof Signal && target instanceof Signal) {
			Signal sourceSignal = (Signal) source;
			Signal targetSignal = (Signal) target;
			this.updateClassifier(targetSignal, sourceSignal);
			if (notStub(sourceSignal)) {
				this.updateCollection(targetSignal.getOwnedAttributes(), sourceSignal.getOwnedAttributes());
			}
		} else if (source instanceof Association && target instanceof Association) {
			Association sourceAssociation = (Association) source;
			Association targetAssociation = (Association) target;
			this.updateClassifier(targetAssociation, sourceAssociation);
			if (notStub(sourceAssociation)) {
				this.updateCollection(targetAssociation.getOwnedEnds(), sourceAssociation.getOwnedEnds());
			}
		} else if (source instanceof Property && target instanceof Property) {
			this.addReplacement(source, target);
			Property sourceProperty = (Property) source;
			Property targetProperty = (Property) target;
			targetProperty.setVisibility(sourceProperty.getVisibility());
			targetProperty.setName(sourceProperty.getName());
			targetProperty.setType(sourceProperty.getType());
			targetProperty.setDefaultValue(sourceProperty.getDefaultValue());
			this.updateMultiplicityElement(targetProperty, sourceProperty);
		} else if (source instanceof Operation && target instanceof Operation) {
			this.addReplacement(source, target);
			Operation sourceOperation = (Operation) source;
			Operation targetOperation = (Operation) target;
			updateStereotypes(targetOperation, sourceOperation);
			targetOperation.setVisibility(sourceOperation.getVisibility());
			targetOperation.setIsAbstract(sourceOperation.isAbstract());
			targetOperation.setName(sourceOperation.getName());
			this.updateCollection(targetOperation.getOwnedParameters(), sourceOperation.getOwnedParameters());
		} else if (source instanceof Parameter && target instanceof Parameter) {
			this.addReplacement(source, target);
			Parameter sourceParameter = (Parameter) source;
			Parameter targetParameter = (Parameter) target;
			targetParameter.setVisibility(sourceParameter.getVisibility());
			targetParameter.setDirection(sourceParameter.getDirection());
			targetParameter.setName(sourceParameter.getName());
			targetParameter.setType(sourceParameter.getType());
			this.updateMultiplicityElement(targetParameter, sourceParameter);
		} else if (source instanceof Reception && target instanceof Reception) {
			this.addReplacement(source, target);
			Reception sourceReception = (Reception) source;
			Reception targetReception = (Reception) target;
			updateStereotypes(targetReception, sourceReception);
			targetReception.setVisibility(sourceReception.getVisibility());
			targetReception.setIsAbstract(sourceReception.isAbstract());
			targetReception.setName(nameOf(sourceReception)); // nameOf used in case the reception was mapped from a stub SignalReceptionDefinition.
			targetReception.setSignal(sourceReception.getSignal());
		}
	}

	public static <T extends Element> void setList(List<T> targetList, List<T> sourceList) {
		for (T element : targetList) {
			unapplyStereotypes(element);
		}
		targetList.clear();
		targetList.addAll(sourceList);
		for (T element : targetList) {
			updateAllStereotypes(element);
		}
	}

	protected static void unapplyStereotypes(Element element) {
		for (Stereotype stereotype : element.getAppliedStereotypes()) {
			element.unapplyStereotype(stereotype);
		}
	}

	protected static void updateStereotypes(Element target, Element source) {
		// System.out.println("[updateStereotypes] target=" + target);
		// NOTE: Cache tagged values, in case target and source are the same.
		Map<Stereotype, Map<String, Object>> stereotypeMap = new HashMap<Stereotype, Map<String, Object>>();
		for (Stereotype stereotype : source.getAppliedStereotypes()) {
			// System.out.println("[updateStereotypes] stereotype=" + stereotype.getName());
			Map<String, Object> valueMap = new HashMap<String, Object>();
			stereotypeMap.put(stereotype, valueMap);
			for (Property attribute : stereotype.getAllAttributes()) {
				String name = attribute.getName();
				// System.out.println("[updateStereotype] attribute=" + name);
				if (!name.startsWith(Extension.METACLASS_ROLE_PREFIX)) {
					// System.out.println("[updateStereotype] value=" + source.getValue(stereotype, name));
					valueMap.put(name, source.getValue(stereotype, name));
				}
			}
		}
		unapplyStereotypes(target);
		for (Stereotype stereotype : stereotypeMap.keySet()) {
			target.applyStereotype(stereotype);
			Map<String, Object> valueMap = stereotypeMap.get(stereotype);
			for (String name : valueMap.keySet()) {
				target.setValue(stereotype, name, valueMap.get(name));
			}
		}
	}

	protected static void updateAllStereotypes(Element element) {
		updateStereotypes(element, element);
		for (Element ownedElement : element.getOwnedElements()) {
			updateAllStereotypes(ownedElement);
		}
	}

	private void updateComments(List<Comment> targetComments, List<Comment> sourceComments){
		Comment targetSpecification = getTextualRepresentation(targetComments);
		Comment sourceSpecification = getTextualRepresentation(sourceComments);
		if(targetSpecification!=null){
			if(sourceSpecification==null){
				targetComments.remove(targetSpecification);
				setList(targetComments, sourceComments);
				targetComments.add(targetSpecification);
			}else{
				setList(targetComments, sourceComments);
			}
		}else{
			setList(targetComments, sourceComments);
		}
	}
	
	protected void updateClassifier(Classifier target, Classifier source) {
		this.addReplacement(source, target);
		updateStereotypes(target, source);
		setList(target.getGeneralizations(), source.getGeneralizations());
		setList(target.getTemplateBindings(), source.getTemplateBindings());
		target.setName(nameOf(source));
		if (source.isSetVisibility()) {
			target.setVisibility(source.getVisibility());
		}
		target.setIsAbstract(source.isAbstract());
		target.setOwnedTemplateSignature(source.getOwnedTemplateSignature());
		if (notStub(source)) {
			//setList(target.getOwnedComments(), source.getOwnedComments());
			this.updateComments(target.getOwnedComments(), source.getOwnedComments());
		} else {
			List<Comment> targetComments = target.getOwnedComments();
			List<Comment> sourceComments = source.getOwnedComments();
			
			Comment targetTextualRepresentation = getTextualRepresentation(targetComments);
			if (targetTextualRepresentation != null) {
				targetComments.remove(targetTextualRepresentation);
			}
			
			Comment sourceTextualRepresentation = getTextualRepresentation(sourceComments);
			if (sourceTextualRepresentation != null) {
				sourceComments.remove(sourceTextualRepresentation);
			}
			
			setList(targetComments, sourceComments);
			
			if (targetTextualRepresentation != null) {
				targetComments.add(targetTextualRepresentation);
			}
		}
	}
	
	protected static Comment getTextualRepresentation(List<Comment> comments) {
		for (Comment comment: comments) {
			if (comment.getAppliedStereotype(TEXTUAL_REPRESENTATION_STEREOTYPE_NAME) != null) {
				return comment;
			}
		}
		return null;
	}

	protected void updateMultiplicityElement(MultiplicityElement target, MultiplicityElement source) {
		updateStereotypes(target, source);
		target.setLower(source.getLower());
		target.setUpper(source.getUpper());
		target.setIsOrdered(source.isOrdered());
		target.setIsUnique(source.isUnique());
	}

	public <T extends NamedElement> void updateCollection(
			List<T> targetCollection, List<T> sourceCollection) {
		List<T> unmatchedElements =
				this.updateAll(targetCollection, sourceCollection);
		for (T element : unmatchedElements) {
			element.destroy();
		}
	}

	public <T extends NamedElement> List<T> updateAll(
			List<T> targetCollection, List<T> sourceCollection) {
		List<T> sourceCollectionCopy = new BasicEList<T>(sourceCollection);
		List<T> targetCollectionCopy = new BasicEList<T>(targetCollection);
		for (T sourceElement : sourceCollectionCopy) {
			T targetElement = findTargetElement(targetCollectionCopy, sourceElement);
			if (targetElement != null) {
				// System.out.println("[updateAll] targetElement=" + targetElement);
				this.update(targetElement, sourceElement);
			} else {
				sourceElement.setName(nameOf(sourceElement));
				targetCollection.add(sourceElement);
				updateAllStereotypes(sourceElement);
			}
		}
		return targetCollectionCopy;
	}

	protected static <T extends NamedElement> T findTargetElement(
			List<T> collection, T sourceElement) {
		java.lang.Class<? extends NamedElement> kind = sourceElement.getClass();
		String name = nameOf(sourceElement);
		// System.out.println("[findTargetElement] kind=" + kind.getSimpleName() + " name=" + name + " count=" + count);
		for (T targetElement : collection) {
			// System.out.println("[findTargetElement] n= " + n + " targetElement=" + targetElement);
			String targetName = targetElement.getName();
			if (kind == targetElement.getClass() &&
					(name == null && targetName == null ||
					name != null && name.equals(targetName))) {
				collection.remove(targetElement);
				return targetElement;
			}
		}
		return null;
	}
	/*
	protected static Operation findOwnedOperationWithName(String name, Class clazz){
		Operation operation = null;
		Iterator<Operation> iteratorOperation = clazz.getOwnedOperations().iterator();
		while(operation == null && iteratorOperation.hasNext()){
			operation = iteratorOperation.next();
			if(!operation.getName().equals(name)){
				operation = null;
			}
		}
		return null;
	}
	
	protected static boolean isCohesive(Operation operation, Behavior ownedBehavior){
		boolean cohesive = true;
		int parameterCount = operation.getOwnedParameters().size();
		if(parameterCount==ownedBehavior.getOwnedParameters().size()){
			int i = 0;
			while(cohesive && i < parameterCount){
				Parameter operationParameter = operation.getOwnedParameters().get(i);
				Parameter behaviorParameter = ownedBehavior.getOwnedParameters().get(i);
				if(operationParameter.getType()!=behaviorParameter.getType()){
					cohesive = false;
				}
			}
		}
		return cohesive;
	}*/

	protected static String nameOf(NamedElement element) {
		String name = element.getName();
		return isStubName(name)? name.substring(0, name.length() - 5): name;
	}
	
	protected static boolean notStub(NamedElement element) {
		return !isStubName(element.getName());
	}
	
	protected static boolean isStubName(String name) {
		return name != null && name.endsWith("$stub");
	}
	
	protected static boolean isMethodName(String name){
		return name != null && name.matches(".+\\\\$method\\\\$[0-9]+");
	}

	protected void clearReplacements() {
		this.originalElements.clear();
		this.replacementElements.clear();
	}

	protected void addReplacement(EObject originalElement, EObject replacementElement) {
		this.originalElements.add(originalElement);
		this.replacementElements.add(replacementElement);
	}

	protected EObject getReplacement(EObject originalElement) {
		int i = this.originalElements.indexOf(originalElement);
		if (i < 0) {
			return null;
		} else {
			return this.replacementElements.get(i);
		}
	}

	public void applyReplacements(EObject context) {
		replaceAll(context, this.originalElements, this.replacementElements);
	}

	public static void replaceAll(EObject context, List<EObject> elements, List<EObject> newElements) {
		final Map<EObject, Collection<EStructuralFeature.Setting>> map =
				EcoreUtil.UsageCrossReferencer.findAll(elements, context);
		for (int i = 0; i < elements.size(); i++) {
			final EObject element = elements.get(i);
			final EObject newElement = newElements.get(i);
			// System.out.println("[replaceAll] element=" + element);
			// System.out.println("[replaceAll] newElement=" + newElement);
			final Collection<EStructuralFeature.Setting> settings = map.get(element);
			if (settings != null) {
				replace(settings, element, newElement);
			}
		}

	}

	private static void replace(Collection<EStructuralFeature.Setting> settings,
			EObject element, EObject newElement) {
		for (EStructuralFeature.Setting setting : settings) {
			EStructuralFeature feature = setting.getEStructuralFeature();
			if (feature.isChangeable()) {
				EcoreUtil.replace(setting, element, newElement);
			}
		}
	}

}
