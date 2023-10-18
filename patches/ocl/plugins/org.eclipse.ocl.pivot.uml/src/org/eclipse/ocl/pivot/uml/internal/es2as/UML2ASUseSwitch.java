/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.Region;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.Transition;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Vertex;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.Unlimited;
//import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2ASUseSwitch extends UMLSwitch<Object>
{
	private static final Logger logger = LogManager.getLogger(UML2ASUseSwitch.class);

	protected final @NonNull UML2AS converter;
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull StandardLibraryInternal standardLibrary;
	private Set<EClass> doneWarnings = null;

	public UML2ASUseSwitch(@NonNull UML2AS converter) {
		this.converter = converter;
		this.environmentFactory = converter.getEnvironmentFactory();
		this.standardLibrary = converter.getStandardLibrary();
	}

	//	@Override
	//	public Object caseEAnnotation(EAnnotation eObject) {
	//		Annotation pivotElement = converter.getCreated(Annotation.class, eObject);
	//		doSwitchAll(Element.class, pivotElement.getReference(), eObject.getReferences());
	//		return pivotElement;
	//	}

	@Override
	public Object caseAssociation(org.eclipse.uml2.uml.Association umlAssociation) {
		assert umlAssociation != null;
		AssociationClass asAssociationClass = converter.getCreated(AssociationClass.class, umlAssociation);
		if (asAssociationClass != null) {
			markRedefinitions(umlAssociation);
			List<org.eclipse.uml2.uml.Constraint> invariants = umlAssociation.getOwnedRules();
			doSwitchAll(Constraint.class, ClassUtil.<Constraint>nullFree(asAssociationClass.getOwnedInvariants()), invariants);
			copyConstraints(asAssociationClass, umlAssociation, invariants);
		}
		return asAssociationClass;
	}

	@Override
	public Object caseAssociationClass(org.eclipse.uml2.uml.AssociationClass umlAssociationClass) {
		assert umlAssociationClass != null;
		markRedefinitions(umlAssociationClass);
		return caseClass(umlAssociationClass);
	}

	@Override
	public org.eclipse.ocl.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		assert umlClass != null;
		org.eclipse.ocl.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlClass);
		if (pivotElement != null) {
			List<org.eclipse.uml2.uml.Constraint> invariants = umlClass.getOwnedRules();
			doSwitchAll(Constraint.class, ClassUtil.<Constraint>nullFree(pivotElement.getOwnedInvariants()), invariants);
			copyConstraints(pivotElement, umlClass, invariants);
		}
		return pivotElement;
	}

	/*	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		assert umlConstraint != null;
		Constraint pivotElement = converter.getCreated(Constraint.class, umlConstraint);
		if (pivotElement != null) {
			doSwitchAll(Element.class, pivotElement.getConstrainedElement(), umlConstraint.getConstrainedElements());
		}
		return pivotElement;
	} */

	@Override
	public Object caseClassifier(org.eclipse.uml2.uml.Classifier umlClassifier) {
		assert umlClassifier != null;
		org.eclipse.ocl.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlClassifier);
		if (pivotElement != null) {
			List<org.eclipse.uml2.uml.Constraint> invariants = umlClassifier.getOwnedRules();
			doSwitchAll(Constraint.class, ClassUtil.<Constraint>nullFree(pivotElement.getOwnedInvariants()), invariants);
			copyConstraints(pivotElement, umlClassifier, invariants);
		}
		return pivotElement;
	}

	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		assert umlConstraint != null;
		Constraint pivotElement = converter.refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, umlConstraint);
		org.eclipse.uml2.uml.ValueSpecification umlSpecification = umlConstraint.getSpecification();
		Object pivotSpecification = umlSpecification != null ? doSwitch(umlSpecification) : null;
		pivotElement.setOwnedSpecification((ExpressionInOCL) pivotSpecification);
		converter.copyNamedElement(pivotElement, umlConstraint);
		//		if (!umlConstraint.getConstrainedElements().isEmpty()) {
		//			converter.queueReference(umlConstraint);	// Defer
		//		}
		//		else {
		//			pivotElement.getConstrainedElement().clear();
		//		}
		doSwitchAllOptional(Element.class, ClassUtil.<Element>nullFree(pivotElement.getConstrainedElements()), umlConstraint.getConstrainedElements());
		return pivotElement;
	}

	@Override
	public Object caseInstanceValue(org.eclipse.uml2.uml.InstanceValue umlInstanceValue) {
		assert umlInstanceValue != null;
		org.eclipse.uml2.uml.InstanceSpecification umlInstance = umlInstanceValue.getInstance();
		if (umlInstance instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
			EnumerationLiteral pivotEnumerationLiteral = converter.getCreated(EnumerationLiteral.class, umlInstance);
			ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlInstanceValue);
			OCLExpression body = pivotElement.getOwnedBody();
			if (!(body instanceof EnumLiteralExp)) {
				body = PivotFactory.eINSTANCE.createEnumLiteralExp();
				pivotElement.setOwnedBody(body);
				if (pivotEnumerationLiteral != null) {
					Type type = pivotEnumerationLiteral.getOwningEnumeration();
					body.setType(type);
					pivotElement.setType(type);
				}
			}
			((EnumLiteralExp)body).setReferredLiteral(pivotEnumerationLiteral);
			converter.copyNamedElement(pivotElement, umlInstanceValue);
			return pivotElement;
		}
		else {
			converter.error("Unknown InstanceValue " + umlInstance.getClass() + " for UML2ASReferenceSwitch");
			return null;
		}
	}

	@Override
	public org.eclipse.ocl.pivot.Class caseInterface(org.eclipse.uml2.uml.Interface umlInterface) {
		assert umlInterface != null;
		org.eclipse.ocl.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlInterface);
		if (pivotElement != null) {
			List<org.eclipse.uml2.uml.Generalization> umlGeneralizations = umlInterface.getGeneralizations();
			List<org.eclipse.ocl.pivot.Class> newSuperTypes = new ArrayList<org.eclipse.ocl.pivot.Class>(Math.max(1, umlGeneralizations.size()));
			for (org.eclipse.uml2.uml.Generalization umlGeneralization : umlGeneralizations) {
				org.eclipse.uml2.uml.Classifier umlGeneral = umlGeneralization.getGeneral();
				if (umlGeneral != null) {
					org.eclipse.ocl.pivot.Class pivotGeneral = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlGeneral);
					if (!newSuperTypes.contains(pivotGeneral)) {
						newSuperTypes.add(pivotGeneral);
					}
				}
			}
			if (newSuperTypes.isEmpty()) {
				org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
				newSuperTypes.add(oclElementType);
			}
			PivotUtilInternal.refreshList(pivotElement.getSuperClasses(), newSuperTypes);
		}
		return pivotElement;
	}

	@Override
	public Object caseLiteralBoolean(org.eclipse.uml2.uml.LiteralBoolean umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getOwnedBody();
		if (!(body instanceof BooleanLiteralExp)) {
			body = PivotFactory.eINSTANCE.createBooleanLiteralExp();
			pivotElement.setOwnedBody(body);
			Type type = standardLibrary.getBooleanType();
			body.setType(type);
			pivotElement.setType(type);
		}
		((BooleanLiteralExp)body).setBooleanSymbol(umlLiteral.booleanValue());
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralInteger(org.eclipse.uml2.uml.LiteralInteger umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getOwnedBody();
		if (!(body instanceof IntegerLiteralExp)) {
			body = PivotFactory.eINSTANCE.createIntegerLiteralExp();
			pivotElement.setOwnedBody(body);
			Type type = standardLibrary.getIntegerType();
			body.setType(type);
			pivotElement.setType(type);
		}
		((IntegerLiteralExp)body).setIntegerSymbol(umlLiteral.getValue());
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralNull(org.eclipse.uml2.uml.LiteralNull umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getOwnedBody();
		if (!(body instanceof NullLiteralExp)) {
			body = PivotFactory.eINSTANCE.createNullLiteralExp();
			pivotElement.setOwnedBody(body);
			Type type = standardLibrary.getOclVoidType();
			body.setType(type);
			pivotElement.setType(type);
		}
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralReal(org.eclipse.uml2.uml.LiteralReal umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getOwnedBody();
		if (!(body instanceof RealLiteralExp)) {
			body = PivotFactory.eINSTANCE.createRealLiteralExp();
			pivotElement.setOwnedBody(body);
			Type type = standardLibrary.getRealType();
			body.setType(type);
			pivotElement.setType(type);
		}
		((RealLiteralExp)body).setRealSymbol(umlLiteral.getValue());
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralString(org.eclipse.uml2.uml.LiteralString umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getOwnedBody();
		if (!(body instanceof StringLiteralExp)) {
			body = PivotFactory.eINSTANCE.createStringLiteralExp();
			pivotElement.setOwnedBody(body);
			Type type = standardLibrary.getStringType();
			body.setType(type);
			pivotElement.setType(type);
		}
		String umlValue = umlLiteral.getValue();
		((StringLiteralExp)body).setStringSymbol(umlValue != null ? umlValue : "");
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralUnlimitedNatural(org.eclipse.uml2.uml.LiteralUnlimitedNatural umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getOwnedBody();
		if (!(body instanceof UnlimitedNaturalLiteralExp)) {
			body = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
			pivotElement.setOwnedBody(body);
			Type type = standardLibrary.getUnlimitedNaturalType();
			body.setType(type);
			pivotElement.setType(type);
		}
		long value = umlLiteral.getValue();
		((UnlimitedNaturalLiteralExp)body).setUnlimitedNaturalSymbol(value >= 0 ? value : Unlimited.INSTANCE);
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public ExpressionInOCL caseOpaqueExpression(org.eclipse.uml2.uml.OpaqueExpression umlExpression) {
		assert umlExpression != null;
		ExpressionInOCL pivotElement = converter.refreshOpaqueExpression(umlExpression);
		return pivotElement;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		assert umlOperation != null;
		Operation pivotElement = converter.getCreated(Operation.class, umlOperation);
		if (pivotElement != null) {
			doSwitchAll(Type.class, ClassUtil.<Type>nullFree(pivotElement.getRaisedExceptions()), umlOperation.getRaisedExceptions());
			doSwitchAll(Operation.class, ClassUtil.<Operation>nullFree(pivotElement.getRedefinedOperations()), umlOperation.getRedefinedOperations());
			for (org.eclipse.uml2.uml.Parameter umlParameter : umlOperation.getOwnedParameters()) {
				org.eclipse.uml2.uml.ParameterDirectionKind direction = umlParameter.getDirection();
				if (direction == org.eclipse.uml2.uml.ParameterDirectionKind.RETURN_LITERAL) {
					converter.resolveMultiplicity(pivotElement, umlParameter);
				}
			}
			List<org.eclipse.uml2.uml.Constraint> preconditions = umlOperation.getPreconditions();
			org.eclipse.uml2.uml.Constraint bodyCondition = umlOperation.getBodyCondition();
			List<org.eclipse.uml2.uml.Constraint> postconditions = umlOperation.getPostconditions();
			doSwitchAll(Constraint.class, ClassUtil.<Constraint>nullFree(pivotElement.getOwnedPreconditions()), preconditions);
			doSwitchAll(Constraint.class, ClassUtil.<Constraint>nullFree(pivotElement.getOwnedPostconditions()), postconditions);
			Constraint constraint = bodyCondition != null ? (Constraint) doSwitch(bodyCondition) : null;
			LanguageExpression specification = null;
			if (constraint != null) {
				specification = constraint.getOwnedSpecification();
				constraint.setOwnedSpecification(null);			// Avoid a child-stealing detection
			}
			pivotElement.setBodyExpression(specification);
			List<org.eclipse.uml2.uml.Constraint> exclusions;
			if ((preconditions.size() > 0) || (bodyCondition != null) || (postconditions.size() > 0)) {
				exclusions = new ArrayList<org.eclipse.uml2.uml.Constraint>();
				exclusions.addAll(preconditions);
				if (bodyCondition != null) {
					exclusions.add(bodyCondition);
				}
				exclusions.addAll(postconditions);
			}
			else {
				exclusions = Collections.emptyList();
			}
			//			copyNamespace(pivotElement, umlOperation, exclusions);
			//			copyNamedElement(pivotElement, umlOperation);
			copyConstraints(pivotElement, umlOperation, exclusions);
		}
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		assert umlPackage != null;
		org.eclipse.ocl.pivot.Package pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Package.class, umlPackage);
		if (pivotElement != null) {
			doSwitchAll(org.eclipse.ocl.pivot.Package.class, ClassUtil.<org.eclipse.ocl.pivot.Package>nullFree(pivotElement.getImportedPackages()), umlPackage.getImportedPackages());
			copyConstraints(pivotElement, umlPackage, null);
		}
		return pivotElement;
	}

	//	@Override
	//	public ProfileApplication caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication umlProfileApplication) {
	//		resolved during installStereotypes
	//	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		assert umlProperty != null;
		Property pivotElement = converter.getCreated(Property.class, umlProperty);
		if (pivotElement != null) {
			doSwitchAll(Property.class, ClassUtil.<Property>nullFree(pivotElement.getRedefinedProperties()), umlProperty.getRedefinedProperties());
			//		doSwitchAll(Property.class, pivotElement.getSubsettedProperty(), umlProperty.getSubsettedProperties());
			ExpressionInOCL asExpression = null;
			//
			//	Synthesize xxx() for idiomatic UML xxx property default.
			//
			String propertyName = pivotElement.getName();
			if (propertyName != null) {
				org.eclipse.uml2.uml.Class umlClass = umlProperty.getClass_();
				if (umlClass != null) {
					for (org.eclipse.uml2.uml.Operation umlOperation : umlClass.getOwnedOperations()) {
						if (propertyName.equals(umlOperation.getName()) && (umlOperation.getOwnedParameters().size() == 1)) {
							{
								org.eclipse.uml2.uml.Constraint bodyCondition = umlOperation.getBodyCondition();
								if (bodyCondition != null) {
									List<org.eclipse.uml2.uml.Element> constrainedElement = bodyCondition.getConstrainedElements();
									if ((constrainedElement.size() >= 2)
											&& (constrainedElement.get(0) == umlOperation)
											&& (constrainedElement.get(1) == umlProperty)) {
										asExpression = PivotFactory.eINSTANCE.createExpressionInOCL();
										asExpression.setBody(propertyName + "()");
										asExpression.setIsRequired(pivotElement.isIsRequired());
										asExpression.setType(pivotElement.getType());
									}
								}
							}
							break;
						}
					}
				}
			}
			if (asExpression == null) {
				org.eclipse.uml2.uml.ValueSpecification umlValue = umlProperty.getDefaultValue();
				if (umlValue != null) {
					asExpression = (ExpressionInOCL) doSwitch(umlValue);
					Type requiredType = PivotUtil.getType(pivotElement);
					Type defaultValueType = asExpression != null ? asExpression.getType() : null;
					if ((requiredType != null) && (defaultValueType != null) && !defaultValueType.conformsTo(standardLibrary, requiredType)) {
						converter.error("Incompatible '" + defaultValueType + "' initializer for " + pivotElement + " when '" + requiredType + "' required");
					}
				}
			}
			pivotElement.setOwnedExpression(asExpression);
		}
		return pivotElement;
	}

	@Override
	public Region caseRegion(org.eclipse.uml2.uml.Region umlRegion) {
		assert umlRegion != null;
		Region pivotElement = converter.getCreated(Region.class, umlRegion);
		if (pivotElement != null) {
			copyConstraints(pivotElement, umlRegion, null);
		}
		return pivotElement;
	}

	@Override
	public Object caseSlot(org.eclipse.uml2.uml.Slot umlSlot) {
		assert umlSlot != null;
		Element asElement = converter.getCreated(Element.class, umlSlot);
		return asElement;
	}

	@Override
	public State caseState(org.eclipse.uml2.uml.State umlState) {
		assert umlState != null;
		State pivotElement = converter.getCreated(State.class, umlState);
		if (pivotElement != null) {
			copyConstraints(pivotElement, umlState, null);
		}
		return pivotElement;
	}

	@Override
	public Transition caseTransition(org.eclipse.uml2.uml.Transition umlTransition) {
		assert umlTransition != null;
		Transition pivotElement = converter.getCreated(Transition.class, umlTransition);
		if (pivotElement != null) {
			org.eclipse.uml2.uml.Vertex umlSource = umlTransition.getSource();
			org.eclipse.uml2.uml.Vertex umlTarget = umlTransition.getTarget();
			Vertex pivotSource = umlSource != null ? converter.getCreated(Vertex.class, umlSource) : null;
			Vertex pivotTarget = umlTarget != null ? converter.getCreated(Vertex.class, umlTarget) : null;
			pivotElement.setSource(pivotSource);
			pivotElement.setTarget(pivotTarget);
			copyConstraints(pivotElement, umlTransition, null);
		}
		return pivotElement;
	}

	protected void copyConstraints(@NonNull Namespace pivotElement, org.eclipse.uml2.uml.@NonNull Namespace umlNamespace,
			@Nullable List<org.eclipse.uml2.uml.Constraint> exclusions) {
		List<org.eclipse.uml2.uml.Constraint> ownedRules = umlNamespace.getOwnedRules();
		if ((exclusions != null) && (exclusions.size() > 0)) {
			ownedRules = new ArrayList<org.eclipse.uml2.uml.Constraint>(ownedRules);
			ownedRules.removeAll(exclusions);
		}
		doSwitchAll(Constraint.class, ClassUtil.<Constraint>nullFree(pivotElement.getOwnedConstraints()), ownedRules);
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
					//					if (!(eObject instanceof org.eclipse.uml2.uml.Constraint)) {
					//						System.out.println("Use switching " + eObject);
					//					}
					@SuppressWarnings("unchecked")T doSwitchResult = (T) doSwitch(eObject);
					pivotElement = doSwitchResult;
				}
				if (pivotElement != null) {
					pivotElements.add(pivotElement);
				}
				else {
					if (doneWarnings == null) {
						doneWarnings = new HashSet<EClass>();
					}
					EClass eClass = eObject.eClass();
					String message = "No pivot representation of " + eClass.getName() + " " + LabelUtil.getLabel(eObject) + " created.";
					converter.error(message);
					if (doneWarnings.add(eClass)) {
						logger.warn(message);
					}
				}
			}
		}
	}

	private <T extends Element> void doSwitchAllOptional(@NonNull Class<T> pivotClass, /*@NonNull*/ Collection<T> pivotElements, /*@NonNull*/ List<? extends EObject> eObjects) {
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
					//					if (!(eObject instanceof org.eclipse.uml2.uml.Constraint)) {
					//						System.out.println("Use switching " + eObject);
					//					}
					@SuppressWarnings("unchecked")T doSwitchResult = (T) doSwitch(eObject);
					pivotElement = doSwitchResult;
				}
				if (pivotElement != null) {
					pivotElements.add(pivotElement);
				}
			}
		}
	}

	private void markRedefinitions(org.eclipse.uml2.uml.@NonNull Association umlAssociation) {
		AssociationClass asAssociationClass = converter.getCreated(AssociationClass.class, umlAssociation);
		if (asAssociationClass != null) {
			AssociationClassProperties asAssociationClassProperties = null;
			List<org.eclipse.uml2.uml.@NonNull Property> umlMemberEnds = converter.getSafeMemberEnds(umlAssociation);
			List<org.eclipse.uml2.uml.@NonNull Association> umlRedefinedAssociations = null;
			for (org.eclipse.uml2.uml.@NonNull Property umlMemberProperty : umlMemberEnds) {
				for (org.eclipse.uml2.uml.Property redefinedProperty : umlMemberProperty.getRedefinedProperties()) {
					org.eclipse.uml2.uml.Association umlRedefinedAssociation = redefinedProperty.getAssociation();
					if (umlRedefinedAssociation != null) {
						if (umlRedefinedAssociations == null) {
							umlRedefinedAssociations = new ArrayList<org.eclipse.uml2.uml.@NonNull Association>();
						}
						if (!umlRedefinedAssociations.contains(umlRedefinedAssociation)) {
							umlRedefinedAssociations.add(umlRedefinedAssociation);
							AssociationClass asRedefinedAssociationClass = converter.getCreated(AssociationClass.class, umlRedefinedAssociation);
							if (asRedefinedAssociationClass != null) {
								if (asAssociationClassProperties == null) {
									asAssociationClassProperties = converter.getAssociationClassProperties(asAssociationClass);
								}
								AssociationClassProperties asRedefinedAssociationClassProperties = converter.getAssociationClassProperties(asRedefinedAssociationClass);
								if ((asAssociationClassProperties != null) && (asRedefinedAssociationClassProperties != null)) {
									Map<org.eclipse.uml2.uml.@NonNull Property, org.eclipse.uml2.uml.@NonNull Property> umlProperty2redefinedProperty = asAssociationClassProperties.getPropertyToRedefinedPropertyMapping(asRedefinedAssociationClassProperties);
									for (int i = -1; i < umlMemberEnds.size(); i++) {
										org.eclipse.uml2.uml.Property umlFromProperty = i < 0 ? null : umlMemberEnds.get(i);
										for (int j = -1; j < umlMemberEnds.size(); j++) {
											if (j != i) {
												org.eclipse.uml2.uml.Property umlToProperty = j < 0 ? null : umlMemberEnds.get(j);
												Property asAssociationClassProperty = asAssociationClassProperties.get(umlFromProperty, umlToProperty);
												org.eclipse.uml2.uml.Property umlFromRedefinedProperty = umlFromProperty != null ? umlProperty2redefinedProperty.get(umlFromProperty) : null;
												org.eclipse.uml2.uml.Property umlToRedefinedProperty = umlToProperty != null ? umlProperty2redefinedProperty.get(umlToProperty) : null;
												Property asRedefinedAssociationClassProperty = asRedefinedAssociationClassProperties.get(umlFromRedefinedProperty, umlToRedefinedProperty);
												assert asAssociationClassProperty != asRedefinedAssociationClassProperty;
												asAssociationClassProperty.getRedefinedProperties().add(asRedefinedAssociationClassProperty);
											}
										}
									}
								}
							}
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * @deprecated no longer used
	 */
	@Deprecated
	public org.eclipse.uml2.uml.@Nullable Property getOtherEnd(@NonNull List<org.eclipse.uml2.uml.Property> umlMemberEnds, org.eclipse.uml2.uml.@NonNull Property umlProperty) {
		for (org.eclipse.uml2.uml.Property umlMemberEnd : umlMemberEnds) {
			if (umlMemberEnd != umlProperty) {
				return umlMemberEnd;
			}
		}
		return null;
	}
}