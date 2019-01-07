/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.zdl.ocl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A specialization of the {@link UMLReflection} API for the ZDL mappings of
 * type relationships. In particular, for domain concepts in a generalization
 * relationship, when the sub-concept is mapped to a stereotype but the
 * super-concept is mapped to a UML metaclass, the stereotype is considered as a
 * subtype of the metaclass.
 * 
 * @author Christian W. Damus (cdamus)
 */
class ZDLReflection
		implements
		UMLReflection<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> {

	private final UMLReflection<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> delegate;

	/**
	 * Intializes me with my delegate.
	 * 
	 * @param delegate
	 *            my delegate
	 */
	public ZDLReflection(
			UMLReflection<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> delegate) {
		this.delegate = delegate;
	}

	/**
	 * Treats stereotypes as specializations of their extended metaclasses in
	 * support of domain-concept generalizations.
	 */
	public int getRelationship(Classifier type1, Classifier type2) {
		if ((type1 instanceof Stereotype) && !(type2 instanceof Stereotype)) {
			if (type2 instanceof Class) {
				for (Class next : ((Stereotype) type1).getExtendedMetaclasses()) {
					if (next.conformsTo(type2)) {
						return STRICT_SUBTYPE;
					}
				}
			} // no point in trying if the other type isn't a class
		} else if ((type2 instanceof Stereotype)
			&& !(type1 instanceof Stereotype)) {
			if (type2 instanceof Class) {
				for (Class next : ((Stereotype) type2).getExtendedMetaclasses()) {
					if (next.conformsTo(type1)) {
						return STRICT_SUPERTYPE;
					}
				}
			} // no point in trying if the other type isn't a class
		}

		return delegate.getRelationship(type1, type2);
	}

	/**
	 * Treats stereotypes as specializations of their extended metaclasses in
	 * support of domain-concept generalizations.
	 */
	public Classifier getCommonSuperType(Classifier type1, Classifier type2) {
		if ((type1 instanceof Stereotype) && !(type2 instanceof Stereotype)) {
			if (type2 instanceof Class) {
				for (Class next : ((Stereotype) type1).getExtendedMetaclasses()) {
					if (next.conformsTo(type2)) {
						return type2;
					}
				}
			} // no point in trying if the other type isn't a class
		} else if ((type2 instanceof Stereotype)
			&& !(type1 instanceof Stereotype)) {
			if (type2 instanceof Class) {
				for (Class next : ((Stereotype) type2).getExtendedMetaclasses()) {
					if (next.conformsTo(type1)) {
						return type1;
					}
				}
			} // no point in trying if the other type isn't a class
		}

		return delegate.getCommonSuperType(type1, type2);
	}

	public Object getStereotypeApplication(Object baseElement,
			Classifier stereotype) {
		// TODO: This is a work-around. Remove when bug 243098 is fixed
		Object result = delegate.getStereotypeApplication(baseElement,
			stereotype);

		if (result == null) {
			// maybe some specializing stereotype is applied?

			if ((baseElement instanceof Element)
				&& (stereotype instanceof Stereotype)) {

				Element element = (Element) baseElement;

				List<Stereotype> applied = element
					.getAppliedSubstereotypes((Stereotype) stereotype);
				if (!applied.isEmpty()) {
					return element.getStereotypeApplication(applied.get(0));
				}
			}
		}

		return result;
	}

	//
	// Simple delegation methods
	//

	public Classifier asOCLType(Classifier modelType) {
		return delegate.asOCLType(modelType);
	}

	public CallOperationAction createCallOperationAction(Operation operation) {
		return delegate.createCallOperationAction(operation);
	}

	public Constraint createConstraint() {
		return delegate.createConstraint();
	}

	public ExpressionInOCL<Classifier, Parameter> createExpressionInOCL() {
		return delegate.createExpressionInOCL();
	}

	public Operation createOperation(String name, Classifier resultType,
			List<String> paramNames, List<Classifier> paramTypes) {
		return delegate.createOperation(name, resultType, paramNames,
			paramTypes);
	}

	public Property createProperty(String name, Classifier resultType) {
		return delegate.createProperty(name, resultType);
	}

	public SendSignalAction createSendSignalAction(Classifier signal) {
		return delegate.createSendSignalAction(signal);
	}

	public Collection<? extends Classifier> getAllSupertypes(
			Classifier classifier) {
		return delegate.getAllSupertypes(classifier);
	}

	public Classifier getAssociationClass(Property property) {
		return delegate.getAssociationClass(property);
	}

	public List<Property> getAttributes(Classifier classifier) {
		return delegate.getAttributes(classifier);
	}

	public List<Classifier> getClassifiers(Package pkg) {
		return delegate.getClassifiers(pkg);
	}

	public List<? extends EObject> getConstrainedElements(Constraint constraint) {
		return delegate.getConstrainedElements(constraint);
	}

	public Constraint getConstraint(
			ExpressionInOCL<Classifier, Parameter> specification) {
		return delegate.getConstraint(specification);
	}

	public String getConstraintName(Constraint constraint) {
		return delegate.getConstraintName(constraint);
	}

	public String getDescription(Object namedElement) {
		return delegate.getDescription(namedElement);
	}

	public Classifier getEnumeration(EnumerationLiteral enumerationLiteral) {
		return delegate.getEnumeration(enumerationLiteral);
	}

	public EnumerationLiteral getEnumerationLiteral(Classifier enumerationType,
			String literalName) {
		return delegate.getEnumerationLiteral(enumerationType, literalName);
	}

	public List<EnumerationLiteral> getEnumerationLiterals(
			Classifier enumerationType) {
		return delegate.getEnumerationLiterals(enumerationType);
	}

	public List<Property> getMemberEnds(Classifier associationClass) {
		return delegate.getMemberEnds(associationClass);
	}

	public String getName(Object namedElement) {
		return delegate.getName(namedElement);
	}

	public List<Package> getNestedPackages(Package pkg) {
		return delegate.getNestedPackages(pkg);
	}

	public Package getNestingPackage(Package pkg) {
		return delegate.getNestingPackage(pkg);
	}

	public Classifier getOCLType(Object metaElement) {
		return delegate.getOCLType(metaElement);
	}

	public Operation getOperation(CallOperationAction callOperationAction) {
		return delegate.getOperation(callOperationAction);
	}

	public List<Operation> getOperations(Classifier classifier) {
		return delegate.getOperations(classifier);
	}

	public Classifier getOwningClassifier(Object feature) {
		return delegate.getOwningClassifier(feature);
	}

	public Package getPackage(Classifier classifier) {
		return delegate.getPackage(classifier);
	}

	public List<Parameter> getParameters(Operation operation) {
		return delegate.getParameters(operation);
	}

	public String getQualifiedName(Object namedElement) {
		return delegate.getQualifiedName(namedElement);
	}

	public List<Property> getQualifiers(Property property) {
		return delegate.getQualifiers(property);
	}

	public Classifier getSignal(SendSignalAction sendSignalAction) {
		return delegate.getSignal(sendSignalAction);
	}

	public List<Classifier> getSignals(Classifier owner) {
		return delegate.getSignals(owner);
	}

	public ExpressionInOCL<Classifier, Parameter> getSpecification(
			Constraint constraint) {
		return delegate.getSpecification(constraint);
	}

	public String getStereotype(Constraint constraint) {
		return delegate.getStereotype(constraint);
	}

	public boolean isAssociationClass(Classifier type) {
		return delegate.isAssociationClass(type);
	}

	public boolean isClass(Object metaElement) {
		return delegate.isClass(metaElement);
	}

	public boolean isClassifier(Object metaElement) {
		return delegate.isClassifier(metaElement);
	}

	public boolean isComparable(Classifier type) {
		return delegate.isComparable(type);
	}

	public boolean isDataType(Object metaElement) {
		return delegate.isDataType(metaElement);
	}

	public boolean isEnumeration(Classifier type) {
		return delegate.isEnumeration(type);
	}

	public boolean isMany(Object metaElement) {
		return delegate.isMany(metaElement);
	}

	public boolean isOperation(Object metaElement) {
		return delegate.isOperation(metaElement);
	}

	public boolean isProperty(Object metaElement) {
		return delegate.isProperty(metaElement);
	}

	public boolean isQuery(Operation operation) {
		return delegate.isQuery(operation);
	}

	public boolean isStatic(Object feature) {
		return delegate.isStatic(feature);
	}

	public boolean isStereotype(Classifier type) {
		return delegate.isStereotype(type);
	}

	public void setConstraintName(Constraint constraint, String name) {
		delegate.setConstraintName(constraint, name);
	}

	public void setName(TypedElement<Classifier> element, String name) {
		delegate.setName(element, name);
	}

	public void setSpecification(Constraint constraint,
			ExpressionInOCL<Classifier, Parameter> specification) {
		delegate.setSpecification(constraint, specification);
	}

	public void setStereotype(Constraint constraint, String stereotype) {
		delegate.setStereotype(constraint, stereotype);
	}

	public void setType(TypedElement<Classifier> element, Classifier type) {
		delegate.setType(element, type);
	}

	public void addConstrainedElement(Constraint arg0, EObject arg1) {
		delegate.addConstrainedElement(arg0, arg1);
	}

	public boolean isConstraint(Object arg0) {
		return delegate.isConstraint(arg0);
	}

	public boolean isPackage(Object arg0) {
		return delegate.isPackage(arg0);
	}

	public boolean setIsStatic(Object arg0, boolean arg1) {
		return delegate.setIsStatic(arg0, arg1);
	}
}
