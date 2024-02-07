/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *	E.D.Willink (CEA LIST) - Bug 400744
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.es2as;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Profile;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Slot;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.uml2.uml.util.UMLSwitch;

//
//	Originally everything was in the Reference pass but the Stereotype resolution preceded it and got steadily more complicated
//  so all activities were moved to a new last Use pass. Simple reference resolving activities can be moved from the Use pass to the Reference pass.
//
public class UML2ASReferenceSwitch extends UMLSwitch<Object>
{
	private static final Logger logger = LogManager.getLogger(UML2ASReferenceSwitch.class);

	protected final @NonNull UML2AS converter;
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull StandardLibraryInternal standardLibrary;
	private Set<EClass> doneWarnings = null;

	public UML2ASReferenceSwitch(@NonNull UML2AS converter) {
		this.converter = converter;
		this.environmentFactory = converter.getEnvironmentFactory();
		this.standardLibrary = converter.getStandardLibrary();
	}

	@Override
	public @NonNull Object caseAssociation(org.eclipse.uml2.uml.Association umlAssociation) {
		assert umlAssociation != null;
		AssociationClass asAssociationClass = createAssociationClassProperties(umlAssociation);
		List<org.eclipse.ocl.pivot.Class> asSuperClasses = asAssociationClass.getSuperClasses();
		if (asSuperClasses.isEmpty()) {
			asSuperClasses.add(standardLibrary.getOclElementType());
		}
		return asAssociationClass;
	}

	@Override
	public @NonNull Object caseAssociationClass(org.eclipse.uml2.uml.AssociationClass umlAssociationClass) {
		assert umlAssociationClass != null;
		createAssociationClassProperties(umlAssociationClass);
		return caseClass(umlAssociationClass);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		assert umlClass != null;
		org.eclipse.ocl.pivot.Class asClass = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlClass);
		if (asClass == null) {
			return standardLibrary.getOclInvalidType();
		}
		List<org.eclipse.ocl.pivot.@NonNull Class> asSuperClasses = ClassUtil.nullFree(asClass.getSuperClasses());
		doSwitchAll(org.eclipse.ocl.pivot.Class.class, asSuperClasses, umlClass.getSuperClasses());
		if (asSuperClasses.isEmpty()) {
			asSuperClasses.add(standardLibrary.getOclElementType());
		}
		return asClass;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class caseClassifier(org.eclipse.uml2.uml.Classifier umlClassifier) {
		assert umlClassifier != null;
		org.eclipse.ocl.pivot.Class asClass = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlClassifier);
		if (asClass == null) {
			return standardLibrary.getOclInvalidType();
		}
		List<org.eclipse.ocl.pivot.Class> asSuperClasses = new ArrayList<org.eclipse.ocl.pivot.Class>();
		if (asClass instanceof Enumeration) {
			asSuperClasses.add(standardLibrary.getOclEnumerationType());
		}
		else if (asClass instanceof DataType) {
			PrimitiveType behavioralClass = converter.getBehavioralClass((org.eclipse.uml2.uml.DataType) umlClassifier);
			if (behavioralClass != null) {
				asSuperClasses.add(behavioralClass);
				((DataType)asClass).setBehavioralClass(behavioralClass);
			}
		}
		for (org.eclipse.uml2.uml.Generalization umlGeneralization : umlClassifier.getGeneralizations()) {
			org.eclipse.uml2.uml.Classifier umlGeneral = umlGeneralization.getGeneral();
			if (umlGeneral != null) {
				org.eclipse.ocl.pivot.Class asGeneral = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlGeneral);
				if ((asGeneral != null) && !asSuperClasses.contains(asGeneral)) {
					asSuperClasses.add(asGeneral);
				}
			}
		}
		if (asSuperClasses.isEmpty()) {
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			asSuperClasses.add(oclElementType);
		}
		converter.refreshList(asClass.getSuperClasses(), asSuperClasses);
		return asClass;
	}

	@Override
	public Object caseClassifierTemplateParameter(org.eclipse.uml2.uml.ClassifierTemplateParameter umlTemplateParameter) {
		assert umlTemplateParameter != null;
		TemplateParameter asTemplateParameter = converter.getCreated(TemplateParameter.class, umlTemplateParameter);
		if (asTemplateParameter != null) {
			for (org.eclipse.uml2.uml.Classifier umlClassifier : umlTemplateParameter.getConstrainingClassifiers()) {
				assert umlClassifier != null;
				org.eclipse.ocl.pivot.Class asConstrainingClass = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlClassifier);
				if (asConstrainingClass != null) {
					asTemplateParameter.getConstrainingClasses().add(asConstrainingClass);
				}
			}
		}
		return asTemplateParameter;
	}

	@Override
	public @NonNull Object caseExtension(org.eclipse.uml2.uml.Extension umlExtension) {
		assert umlExtension != null;
		List<org.eclipse.uml2.uml.Property> memberEnds = umlExtension.getMemberEnds();		// FIXME re-implement using/emulating createAssociationClassProperties
		if (memberEnds.size() == 2) {
			org.eclipse.uml2.uml.Property firstEnd = memberEnds.get(0);
			org.eclipse.uml2.uml.Property secondEnd = memberEnds.get(1);
			if ((firstEnd != null) && (secondEnd != null)) {
				Property firstProperty = converter.getCreated(Property.class, firstEnd);
				Property secondProperty = converter.getCreated(Property.class, secondEnd);
				if ((firstProperty != null) && (secondProperty != null)) {
					firstProperty.setOpposite(secondProperty);
					secondProperty.setOpposite(firstProperty);
				}
			}
		}
		StereotypeExtender asTypeExtension = converter.getCreated(StereotypeExtender.class, umlExtension);
		if (asTypeExtension == null) {
			return this;
		}
		org.eclipse.uml2.uml.Class umlMetaclass = umlExtension.getMetaclass();
		org.eclipse.uml2.uml.Stereotype umlStereotype = umlExtension.getStereotype();
		if ((umlMetaclass != null) && (umlStereotype != null)) {
			org.eclipse.ocl.pivot.Class asMetaclass = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlMetaclass);
			Stereotype asStereotype = converter.getCreated(Stereotype.class, umlStereotype);
			if ((asMetaclass != null) && (asStereotype != null)) {
				asTypeExtension.setOwningStereotype(asStereotype);
				asTypeExtension.setClass(asMetaclass);
				if (UML2AS.ADD_TYPE_EXTENSION.isActive()) {
					UML2AS.ADD_TYPE_EXTENSION.println(asTypeExtension.toString());
				}
				converter.addTypeExtension(asTypeExtension);
			}
		}
		return asTypeExtension;
	}

	@Override
	public @NonNull Object caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication umlProfileApplication) {
		assert umlProfileApplication != null;
		ProfileApplication asProfileApplication = converter.getCreated(ProfileApplication.class, umlProfileApplication);
		if (asProfileApplication == null) {
			return this;
		}
		org.eclipse.uml2.uml.Profile umlProfile = umlProfileApplication.getAppliedProfile();
		if (umlProfile != null) {
			Profile asProfile = converter.getCreated(Profile.class, umlProfile);
			asProfileApplication.setAppliedProfile(asProfile);
			converter.addProfileApplication(asProfileApplication);
		}
		return asProfileApplication;
	}

	@Override
	public @NonNull Object caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		assert umlProperty != null;
		org.eclipse.uml2.uml.Association umlAssociation = umlProperty.getAssociation();
		assert (umlAssociation == null) || (umlAssociation instanceof org.eclipse.uml2.uml.Extension);
		caseTypedElement(umlProperty);
		Property asProperty = converter.getCreated(Property.class, umlProperty);
		if (asProperty == null) {
			return this;
		}
		if (asProperty.getName() == null) {
			org.eclipse.uml2.uml.Type umlTargetType = umlProperty.getType();
			if (umlTargetType != null) {
				Type asTargetType = converter.getCreated(Type.class, umlTargetType);
				if (asTargetType != null) {
					asProperty.setName(asTargetType.getName());
				}
			}
		}
		org.eclipse.ocl.pivot.Class pivotType = null;
		if (umlAssociation != null) {
			if (umlProperty.getOwningAssociation() != null) {
				asProperty.setIsImplicit(true);
			}
			org.eclipse.uml2.uml.Property opposite = getOtherEnd(umlProperty);
			if (opposite != null) {
				org.eclipse.uml2.uml.Type oppositeType = opposite.getType();
				if (oppositeType != null) {
					pivotType = converter.getCreated(org.eclipse.ocl.pivot.Class.class, oppositeType);
				}
			}
		}
		if (pivotType == null) {
			EObject eContainer = umlProperty.eContainer();
			if (eContainer != null) {
				pivotType = converter.getCreated(org.eclipse.ocl.pivot.Class.class, eContainer);
			}
		}
		if (pivotType != null) {
			converter.addProperty(pivotType, asProperty);
		}
		else {
			//				System.err.println("Failed to find parent for " + umlProperty);
		}
		return asProperty;
	}

	@Override
	public @NonNull Object caseSlot(org.eclipse.uml2.uml.Slot umlSlot) {
		assert umlSlot != null;
		Slot asSlot = converter.getCreated(Slot.class, umlSlot);
		if (asSlot == null) {
			return this;
		}
		org.eclipse.uml2.uml.StructuralFeature umlDefiningFeature = umlSlot.getDefiningFeature();
		Property asProperty = umlDefiningFeature != null ? converter.getCreated(Property.class, umlDefiningFeature) : null;
		asSlot.setDefiningProperty(asProperty);
		return asSlot;
	}

	@Override
	public @NonNull Object caseStereotype(org.eclipse.uml2.uml.Stereotype umlStereotype) {
		assert umlStereotype != null;
		//		caseClass(umlStereotype);
		Stereotype asStereotype = converter.getCreated(Stereotype.class, umlStereotype);
		if (asStereotype == null) {
			return this;
		}
		List<org.eclipse.ocl.pivot.@NonNull Class> asSuperClasses = ClassUtil.nullFree(asStereotype.getSuperClasses());
		doSwitchAll(org.eclipse.ocl.pivot.Class.class, asSuperClasses, umlStereotype.getSuperClasses());
		org.eclipse.ocl.pivot.Class oclStereotype = standardLibrary.getOclStereotypeType();
		if (!asSuperClasses.contains(oclStereotype)) {
			asSuperClasses.add(oclStereotype);
		}
		converter.addStereotype(asStereotype);
		return asStereotype;
	}

	@Override
	public @NonNull EObject caseTypedElement(org.eclipse.uml2.uml.TypedElement umlTypedElement) {
		assert umlTypedElement != null;
		TypedElement pivotElement = converter.getCreated(TypedElement.class, umlTypedElement);
		if (pivotElement == null) {
			return standardLibrary.getOclInvalidType();
		}
		converter.resolveMultiplicity(pivotElement, umlTypedElement);
		return pivotElement;
	}

	private @NonNull AssociationClass createAssociationClassProperties(org.eclipse.uml2.uml.@NonNull Association umlAssociation) {
		AssociationClass asAssociationClass = converter.getCreated(AssociationClass.class, umlAssociation);
		assert asAssociationClass != null;
		List<org.eclipse.uml2.uml.@NonNull Property> umlMemberEnds = converter.getSafeMemberEnds(umlAssociation);
		AssociationClassProperties asAssociationClassProperties = new AssociationClassProperties(umlMemberEnds);
		String associationName = asAssociationClass.getName();
		if (associationName != null) {						// Null name suppresses navigation to Association; see BUG 413766 comments
			//
			//	Create mutually opposite pairs of Property between each UML member end's referenced type and the AssociationClass.
			//
			for (int i = 0; i < umlMemberEnds.size(); i++) {
				org.eclipse.uml2.uml.Property umlMemberProperty = umlMemberEnds.get(i);
				org.eclipse.uml2.uml.Type umlMemberType = umlMemberProperty.getType();
				if (umlMemberType != null) {
					org.eclipse.ocl.pivot.Class asMemberClass = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlMemberType);
					if (asMemberClass != null) {
						Type asAssociationClassEndType = getToAssociationEndType(asAssociationClass, umlMemberProperty, umlMemberEnds);
						Property asMember2AssociationProperty = PivotUtil.createProperty(associationName, asAssociationClassEndType);
						Property asAssociation2MemberProperty = PivotUtil.createProperty(getEndName(umlMemberProperty), asMemberClass);
						//
						asMember2AssociationProperty.setIsRequired(getToAssociationEndIsRequired(umlMemberProperty, umlMemberEnds));
						asMember2AssociationProperty.setIsImplicit(!(umlAssociation instanceof AssociationClass));
						asMember2AssociationProperty.setOpposite(asAssociation2MemberProperty);
						converter.addProperty(asAssociationClass, asAssociation2MemberProperty);
						asAssociationClassProperties.put(null, umlMemberProperty, asAssociation2MemberProperty);
						//
						asAssociation2MemberProperty.setIsRequired(true);
						asAssociation2MemberProperty.setIsImplicit(false);
						asAssociation2MemberProperty.setOpposite(asMember2AssociationProperty);
						converter.addProperty(asMemberClass, asMember2AssociationProperty);
						asAssociationClassProperties.put(umlMemberProperty, null, asMember2AssociationProperty);
					}
				}
			}
		}
		//
		//	Create mutually opposite pairs of Property between the types referenced by each pair of UML member ends.
		//
		for (int iThis2That = 0; iThis2That < umlMemberEnds.size(); iThis2That++) {
			org.eclipse.uml2.uml.Property umlThis2ThatProperty = umlMemberEnds.get(iThis2That);
			org.eclipse.uml2.uml.Type umlThatType = umlThis2ThatProperty.getType();
			if (umlThatType != null) {
				org.eclipse.ocl.pivot.Class asThatClass = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlThatType);
				if (asThatClass != null) {
					for (int iThat2This = iThis2That+1; iThat2This < umlMemberEnds.size(); iThat2This++) {
						org.eclipse.uml2.uml.Property umlThat2ThisProperty = umlMemberEnds.get(iThat2This);
						org.eclipse.uml2.uml.Type umlThisType = umlThat2ThisProperty.getType();
						if (umlThisType != null) {
							org.eclipse.ocl.pivot.Class asThisClass = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlThisType);
							if (asThisClass != null) {
								Type asThatEndType = getInterMemberEndType(asThatClass, umlThis2ThatProperty, umlMemberEnds);
								Type asThisEndType = getInterMemberEndType(asThisClass, umlThat2ThisProperty, umlMemberEnds);
								Property asThis2ThatProperty = PivotUtil.createProperty(getEndName(umlThis2ThatProperty), asThatEndType);
								Property asThat2ThisProperty = PivotUtil.createProperty(getEndName(umlThat2ThisProperty), asThisEndType);
								//
								asThis2ThatProperty.setIsRequired(getEndIsRequired(umlThis2ThatProperty));
								asThis2ThatProperty.setIsImplicit(umlThis2ThatProperty.getOwningAssociation() != null);
								asThis2ThatProperty.setOpposite(asThat2ThisProperty);
								((PivotObjectImpl)asThis2ThatProperty).setESObject(umlThis2ThatProperty);
								converter.addProperty(asThisClass, asThis2ThatProperty);
								asAssociationClassProperties.put(umlThis2ThatProperty, umlThat2ThisProperty, asThis2ThatProperty);
								//
								asThat2ThisProperty.setIsRequired(getEndIsRequired(umlThat2ThisProperty));
								asThat2ThisProperty.setIsImplicit(umlThat2ThisProperty.getOwningAssociation() != null);
								asThat2ThisProperty.setOpposite(asThis2ThatProperty);
								((PivotObjectImpl)asThat2ThisProperty).setESObject(umlThat2ThisProperty);
								converter.addProperty(asThatClass, asThat2ThisProperty);
								asAssociationClassProperties.put(umlThat2ThisProperty, umlThis2ThatProperty, asThat2ThisProperty);
							}
						}
					}
				}
			}
		}
		converter.addAssociationClassProperties(asAssociationClass, asAssociationClassProperties);
		return asAssociationClass;
	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	public <T extends Element> void doSwitchAll(@NonNull Class<T> pivotClass, /*@NonNull*/ Collection<T> pivotElements, /*@NonNull*/ List<? extends EObject> eObjects) {
		assert pivotElements != null;
		assert eObjects != null;
		for (EObject eObject : eObjects) {
			if (eObject != null) {
				@Nullable T pivotElement = converter.getCreated(pivotClass, eObject);
				if (pivotElement == null) {
					Resource eResource = eObject.eResource();
					if (eResource != null) {
						External2AS adapter = UML2AS.findAdapter(eResource, environmentFactory);
						if (adapter != null) {
							pivotElement = adapter.getCreated(pivotClass, eObject);
						}
					}
				}
				if (pivotElement == null) {
					if (!(eObject instanceof org.eclipse.uml2.uml.Constraint)) {
						System.out.println("Reference switching " + eObject);
					}
					Object doSwitchResult = doSwitch(eObject);
					if (doSwitchResult != this) {
						@SuppressWarnings("unchecked")
						T castSwitchResult = (T)doSwitchResult;
						pivotElement = castSwitchResult;
					}
				}
				if (pivotElement != null) {
					pivotElements.add(pivotElement);
				}
				else {
					if (doneWarnings == null) {
						doneWarnings = new HashSet<EClass>();
					}
					EClass eClass = eObject.eClass();
					if (doneWarnings.add(eClass)) {
						logger.warn("Failed to create a pivot representation of a UML '" + eClass.getName() + "'");
					}
				}
			}
		}
	}

	private boolean getEndIsRequired(org.eclipse.uml2.uml.@NonNull Property umlProperty) {
		return umlProperty.getLower() != 0;
	}

	private @NonNull String getEndName(org.eclipse.uml2.uml.@NonNull Property umlProperty) {
		String name = umlProperty.getName();
		if (name != null) {
			return name;
		}
		else {
			return ClassUtil.nonNullState(umlProperty.getType().getName());
		}
	}

	private @NonNull Type getInterMemberEndType(org.eclipse.ocl.pivot.@NonNull Class asClass, org.eclipse.uml2.uml.@NonNull Property umlProperty, @NonNull List<org.eclipse.uml2.uml.@NonNull Property> umlMemberEnds) {
		if (!umlProperty.isMultivalued()) {
			return asClass;
		}
		boolean isOrdered = umlProperty.isOrdered();
		boolean isUnique = umlProperty.isUnique();
		if (umlMemberEnds.size() > 2) {
			for (org.eclipse.uml2.uml.@NonNull Property umlOtherProperty : umlMemberEnds) {
				if (umlOtherProperty != umlProperty) {
					if (!umlOtherProperty.isOrdered()) {
						isOrdered = false;
					}
				}
			}
		}
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		return metamodelManager.getCollectionType(isOrdered, isUnique, asClass, true, ValueUtil.integerValueOf(umlProperty.getLower()), null);
	}

	private boolean getToAssociationEndIsRequired(org.eclipse.uml2.uml.@NonNull Property umlProperty, @NonNull List<org.eclipse.uml2.uml.@NonNull Property> umlMemberEnds) {
		return umlProperty.getLower() != 0;
		//		for (org.eclipse.uml2.uml.@NonNull Property umlOtherProperty : umlMemberEnds) {
		//			if (umlOtherProperty != umlProperty) {
		//				if (umlOtherProperty.getLower() != 0) {
		//					return true;
		//				}
		//			}
		//		}
		//		return false;
	}

	private @NonNull Type getToAssociationEndType(org.eclipse.ocl.pivot.@NonNull Class asClass, org.eclipse.uml2.uml.@NonNull Property umlProperty, @NonNull List<org.eclipse.uml2.uml.@NonNull Property> umlMemberEnds) {
		if (!umlProperty.isMultivalued()) {
			return asClass;
		}
		boolean isMultivalued = false;
		boolean isOrdered = true;
		for (org.eclipse.uml2.uml.@NonNull Property umlOtherProperty : umlMemberEnds) {
			if (umlOtherProperty != umlProperty) {
				if (umlOtherProperty.isMultivalued()) {
					isMultivalued = true;
				}
				if (!umlOtherProperty.isOrdered()) {
					isOrdered = false;
				}
			}
		}
		if (!isMultivalued) {
			return asClass;
		}
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		return metamodelManager.getCollectionType(isOrdered, true, asClass, true, ValueUtil.integerValueOf(umlProperty.getLower()), null);
	}

	protected org.eclipse.uml2.uml.Property getOtherEnd(org.eclipse.uml2.uml.@NonNull Property umlProperty) {
		org.eclipse.uml2.uml.Property otherEnd = umlProperty.getOtherEnd();
		if (otherEnd != null) {
			return otherEnd;
		}
		// Workaround BUG 491587 whereby UML has three ends two of them duplicates with distinct Class/Association ownership.
		org.eclipse.uml2.uml.Association association = umlProperty.getAssociation();
		if (association != null) {
			List<org.eclipse.uml2.uml.Property> memberEnds = new ArrayList<org.eclipse.uml2.uml.Property>(association.getMemberEnds());
			memberEnds.remove(umlProperty);
			String umlPropertyName = umlProperty.getName();
			for (org.eclipse.uml2.uml.Property aProperty : memberEnds) {
				if (!aProperty.getName().equals(umlPropertyName)) {
					return aProperty;
				}
			}
		}
		return otherEnd;
	}

	public org.eclipse.uml2.uml.@Nullable Property getOtherEnd(@NonNull List<org.eclipse.uml2.uml.Property> umlMemberEnds, org.eclipse.uml2.uml.@NonNull Property umlProperty) {
		for (org.eclipse.uml2.uml.Property umlMemberEnd : umlMemberEnds) {
			if (umlMemberEnd != umlProperty) {
				return umlMemberEnd;
			}
		}
		return null;
	}
}