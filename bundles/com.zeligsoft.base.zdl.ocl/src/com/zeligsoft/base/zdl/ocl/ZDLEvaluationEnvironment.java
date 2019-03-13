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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.UMLEvaluationEnvironment;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.ocl.stdlib.StandardLibraryExtender;

/**
 * A specialized evaluation environment that implements a selection of
 * additional features introduced for the mapping of OCL from ZDL to a generated
 * UML profile.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("restriction")
class ZDLEvaluationEnvironment
		extends UMLEvaluationEnvironment {

	/**
	 * Initializes me with the environment factory that created me.
	 * 
	 * @param factory my originating environment factory
	 */
	public ZDLEvaluationEnvironment(UMLEnvironmentFactory factory) {
		super(factory);
	}

	/**
	 * Initializes me with my parent evaluation environment (for nesting
	 * name scopes).
	 * 
	 * @param parent my parent evaluation environment
	 */
	public ZDLEvaluationEnvironment(
			EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
		super(parent);
	}

	/**
	 * Implements the navigation of the <tt>*baseElement</tt> additional
	 * property definition.
	 */
	@Override
	public Object navigateProperty(Property property, List<?> qualifiers,
			Object source)
			throws IllegalArgumentException {

		Object result;

		if (StandardLibraryExtender.handles(property)) {
			result = StandardLibraryExtender.get(source, property);
		} else {
			// FIXME: Restore this when Eclipse bug 247079 is fixed
			// result = super.navigateProperty(property, qualifiers, source);

			//
			// BEGIN TO-DELETE SECTION
			//
			// FIXME: Delete this when Eclipse bug 247079 is fixed
			//
	        if (source instanceof InstanceSpecification) {
	            InstanceSpecification instance = (InstanceSpecification) source;

	            Association association = property.getOwningAssociation();
	            if (association != null) {
	                // non-navigable property. Qualifiers don't apply
	                return navigateNonNavigableProperty(property, association,
	                    instance);
	            }

	            for (Slot slot : instance.getSlots()) {
	                if (slot.getDefiningFeature() == property) {
	                    if (!qualifiers.isEmpty()) {
	                        return findValueQualifiedBy(instance, property,
	                            qualifiers);
	                    }

	                    return getValue(slot);
	                }
	            }

	            // look for a slot on a property that redefines the property
	            // we are looking for
	            for (Slot slot : instance.getSlots()) {
	                if (redefines(slot.getDefiningFeature(), property)) {
	                    if (!qualifiers.isEmpty()) {
	                        return findValueQualifiedBy(instance, property,
	                            qualifiers);
	                    }

	                    return getValue(slot);
	                }
	            }

	            // an instance needs not have a slot for every feature
	            return isMultivaluedSlot(instance, property) ? CollectionUtil
	                .createNewCollection(getCollectionKind(property))
	                : null;
	        } else if (source instanceof EObject) {
	            EObject esource = (EObject) source;

	            EStructuralFeature feature = esource.eClass()
	                .getEStructuralFeature(getEcoreAttributeName(property));

	            if (feature != null) {
	                Object _result = esource.eGet(feature);

	                if (property.getType() instanceof Enumeration) {
	                    _result = convertEnumerationValue((Enumeration) property
	                        .getType(), _result);
	                }

	                return coerceValue(property, _result, true);
	            } else {
	                // must be a non-navigable property?
	                Property otherEnd = property.getOtherEnd();
	                if (otherEnd != null) {
	                    EClass eclass = (EClass) getEClassifier(otherEnd
	                        .getClass_(), source);

	                    if (eclass != null) {
	                        EStructuralFeature eEnd = eclass
	                            .getEStructuralFeature(otherEnd.getName());

	                        if (eEnd != null) {
	                            Collection<Object> _result = createCollection(property);

	                            for (EStructuralFeature.Setting setting : UML2Util
	                                .getNonNavigableInverseReferences(esource)) {
	                                if (setting.getEStructuralFeature() == eEnd) {
	                                    _result.add(setting.getEObject());
	                                }
	                            }

	                            return coerceValue(property, _result, false);
	                        }
	                    }
	                }
	            }
	        }

	        throw new IllegalArgumentException(
	            "no such property: " + property.getName()); //$NON-NLS-1$
	        
	        //
	        // END TO-DELETE SECTION
	        //
		}

		return result;
	}

	/**
	 * Declares overrides for the OCL type conformance query operations, to
	 * handle stereotype mappings.
	 */
	@Override
	public boolean overrides(Operation operation, int opcode) {
		switch (opcode) {
			case PredefinedType.OCL_IS_KIND_OF :
			case PredefinedType.OCL_IS_TYPE_OF :
			case PredefinedType.OCL_AS_TYPE:
				return true;
			default :
				if (StandardLibraryExtender.handles(operation)) {
					return true;
				}
				return super.overrides(operation, opcode);
		}
	}

	/**
	 * Implements overrides for the OCL type conformance query operations, to
	 * handle stereotype mappings.
	 */
	@Override
	public Object callOperation(Operation operation, int opcode, Object source,
			Object[] args)
			throws IllegalArgumentException {

		switch (opcode) {
			case PredefinedType.OCL_IS_KIND_OF :
				return isKindOf(source, (Classifier) args[0]);
			case PredefinedType.OCL_IS_TYPE_OF :
				return isTypeOf(source, (Classifier) args[0]);
			case PredefinedType.OCL_AS_TYPE:
				return asType(source, (Classifier) args[0]);
			default :
				if (StandardLibraryExtender.handles(operation)) {
					return StandardLibraryExtender.call(source, args, operation);
				}
				return super.callOperation(operation, opcode, source, args);
		}
	}

	/**
	 * Overrides the <tt>oclIsKindOf</tt> implementation to treat base elements
	 * as "instances of" their stereotypes, to account for ZDL concept mappings
	 * to stereotypes.
	 */
	@Override
	public boolean isKindOf(Object object, Classifier classifier) {
		if (classifier instanceof Stereotype) {
			Stereotype stereotype = (Stereotype) classifier;

			if (object instanceof Element) {
				Element element = (Element) object;
				return element.isStereotypeApplied(stereotype)
					|| !element.getAppliedSubstereotypes(stereotype).isEmpty();
			} else if (object instanceof EObject) {
				Stereotype actual = UMLUtil.getStereotype((EObject) object);
				return (actual != null) && actual.conformsTo(stereotype);
			}
		} else if ((object instanceof EObject) && !(object instanceof Element)) {
			// maybe it's a stereotype application and we're asking is it an
			// instance of a UML metaclass.  This case handles queries on the
			// UML metaclass that instantiates a concept
			EObject eobject = (EObject) object;
			Element base = UMLUtil.getBaseElement(eobject);
			
			if (base != null) {
				return isKindOf(base, classifier);
			}
		}

		return basicIsKindOf(object, classifier);
	}
	
	/**
	 * Captures the basic implementation of the <tt>oclIsKindOf</tt> operation
	 * provided by the UML environment.
	 * 
	 * @param object
	 *            an object
	 * @param classifier
	 *            a classifier
	 * @return whether, according to the UML semantics, the object is an
	 *         instance of the classifier
	 */
	protected final boolean basicIsKindOf(Object object, Classifier classifier) {
		return super.isKindOf(object, classifier);
	}

	/**
	 * Overrides the <tt>oclIsTypeOf</tt> implementation to treat base elements
	 * as "instances of" their stereotypes, to account for ZDL concept mappings
	 * to stereotypes.
	 */
	@Override
	public boolean isTypeOf(Object object, Classifier classifier) {
		if (classifier instanceof Stereotype) {
			Stereotype stereotype = (Stereotype) classifier;

			if (object instanceof Element) {
				Element element = (Element) object;
				return element.isStereotypeApplied(stereotype);
			} else if (object instanceof EObject) {
				Stereotype actual = UMLUtil.getStereotype((EObject) object);
				return actual == stereotype;
			}
		} else if ((object instanceof EObject) && !(object instanceof Element)) {
			// maybe it's a stereotype application and we're asking is it an
			// instance of a UML metaclass.  This case handles queries on the
			// UML metaclass that instantiates a concept
			EObject eobject = (EObject) object;
			Element base = UMLUtil.getBaseElement(eobject);
			
			if (base != null) {
				return isTypeOf(base, classifier);
			}
		}

		return super.isTypeOf(object, classifier);
	}
	
	/**
	 * Coerces an <tt>object</tt> to the specified <tt>classifier</tt>.
	 * 
	 * @param object
	 *            an object
	 * @param classifier
	 *            the classifier as an instance of which we want to treat the
	 *            <tt>object</tt>
	 * @return the <tt>object</tt> as an instance of the specified
	 *         <tt>classifier</tt>. Note that it may or may not be the same
	 *         Java-object
	 */
	protected Object asType(Object object, Classifier classifier) {
		Object result;

		if (basicIsKindOf(object, classifier)) {
			// if the object actually conforms (according to the UML semantics)
			// then the cast is the original object
			result = object;
		} else if ((classifier instanceof Stereotype) && (object instanceof Element)) {
			// cast an element to its stereotype application
			Stereotype stereotype = (Stereotype) classifier;
			Element element = (Element) object;

			result = element.getStereotypeApplication(stereotype);
			if (result == null) {
				List<Stereotype> subs = element
					.getAppliedSubstereotypes(stereotype);
				if (!subs.isEmpty()) {
					result = element.getStereotypeApplication(subs.get(0));
				}
			}

			// result of oclAsType() is null if the object doesn't conform
		} else if ((object instanceof EObject) && !(object instanceof Element)) {
			// cast a stereotype application to its base element. This is
			// necessary when we need to test properties of an element that are
			// not modeled in the domain, but which need to be constrained in
			// case the concept is mapped to this metaclass
			EObject eobject = (EObject) object;
			Element base = UMLUtil.getBaseElement(eobject);

			if ((base != null) && basicIsKindOf(base, classifier)) {
				result = base;
			} else {
				// if the EObject doesn't have a base element, then it isn't a
				// stereotype application, so we cannot do better than the very
				// first test for UML instance-of semantics
				result = null;
			}
		} else {
			// the UML instance-of semantics didn't apply, and we couldn't cast
			// from an element to its stereotype or vice-versa, so the cast
			// fails
			result = null;
		}
		
		return result;
	}
	
	//
	// BEGIN TO-DELETE SECTION
	//
	// FIXME: Delete this when Eclipse bug 247079 is fixed
	//

    private final Map<Feature, String> featureNameMap = new java.util.HashMap<Feature, String>();
    
    private ValueExtractor valueExtractor;
    private Stereotype getAppliedEcoreStereotype(Element element,
            String name) {
        return element.getAppliedStereotype("Ecore" //$NON-NLS-1$
            + NamedElement.SEPARATOR + name);
    }

    /**
     * Gets the name of the specified attribute, accounting for the possibility
     * that it is aliased using an Ecore stereotype.  The resulting name is
     * cached for fast repeated access.
     * 
     * @param attribute an attribute
     * @return the name of the corresponding Ecore attribute
     */
    private String getEcoreAttributeName(Property attribute) {
        String result = featureNameMap.get(attribute);
        
        if (result == null) {
            result = attribute.getName();
            
            Stereotype stereo = getAppliedEcoreStereotype(attribute,
                UMLUtil.STEREOTYPE__E_ATTRIBUTE);
            String aliasAttribute = UMLUtil.TAG_DEFINITION__ATTRIBUTE_NAME;
            if (stereo == null) {
                stereo = getAppliedEcoreStereotype(attribute,
                    UMLUtil.STEREOTYPE__E_REFERENCE);
                aliasAttribute = UMLUtil.TAG_DEFINITION__REFERENCE_NAME;
            }
            if (stereo != null) {
                // look for an <<eAttribute>> or <<eReference>> alias name
                String alias = (String) attribute.getValue(stereo,
                    aliasAttribute);
                if ((alias != null) && (alias.length() > 0)) {
                    result = alias;
                }
            }
            
            featureNameMap.put(attribute, result);
        }
        
        return result;
    }
    
    /**
     * Obtains the collection kind appropriate for representing the values of
     * the specified feature.
     * 
     * @param feature
     *            a feature
     * 
     * @return the collection kind appropriate to the multiplicity, orderedness,
     *         and uniqueness of the feature, or <code>null</code> if it is
     *         not many
     */
    private static CollectionKind getCollectionKind(Feature feature) {
        MultiplicityElement element = null;

        if (feature instanceof MultiplicityElement) {
            element = (MultiplicityElement) feature;
        } else if (feature instanceof Operation) {
            element = ((Operation) feature).getReturnResult();
        }

        if (element != null) {
            return element.isMultivalued() ? CollectionKind.getKind(element
                .isOrdered(), element.isUnique())
                : null;
        }

        return null; // void operation is implicitly scalar
    }

    /**
     * Creates a collection value for the specified feature. The collection type
     * is arbitrary if the feature is not multi-valued (but in a context where a
     * collection is needed for computation).
     * 
     * @param feature
     *            a feature (property, operation, etc.)
     * @return a collection to store its value
     */
    private Collection<Object> createCollection(Feature feature) {
        CollectionKind kind = getCollectionKind(feature);

        if (kind != null) {
            return CollectionUtil.createNewCollection(kind);
        } else {
            // doesn't matter the collection type
            return new BasicEList.FastCompare<Object>();
        }
    }

    /**
     * Coerces the value of the specified feature into the appropriate
     * representation, derived from the supplied <code>value</code> template.
     * The <code>value</code> is coerced to the appropriate collection kind
     * for this feature (or scalar if not multi-valued). The original value may
     * either be used as is where possible or, optionally, copied into the new
     * collection (if multi-valued).
     * 
     * @param feature
     *            a feature (property, operation, etc.)
     * @param value
     *            the computed value of the property
     * @param copy
     *            whether to copy the specified value into the resulting
     *            collection/scalar value
     * 
     * @return the value, in the appropriate OCL collection type or scalar form
     *         as required
     * 
     * @see #getCollectionKind(Feature)
     */
    private Object coerceValue(Feature feature, Object value, boolean copy) {
        CollectionKind kind = getCollectionKind(feature);

        if (kind != null) {
            if (value instanceof Collection) {
                return copy ? CollectionUtil.createNewCollection(kind,
                    (Collection<?>) value)
                    : value;
            } else {
                Collection<Object> result = CollectionUtil
                    .createNewCollection(kind);
                result.add(value);
                return result;
            }
        } else {
            if (value instanceof Collection) {
                Collection<?> collection = (Collection<?>) value;
                return collection.isEmpty() ? null
                    : collection.iterator().next();
            } else {
                return value;
            }
        }
    }

    /**
     * Navigates a non-navigable property in an instance specification context.
     * 
     * @param property
     *            the non-navigable property to navigate
     * @param association
     *            the association of which the property is a member
     * @param instance
     *            the instance specification from which we are navigating the
     *            property
     * 
     * @return the property value
     */
    private Object navigateNonNavigableProperty(Property property,
            Association association, InstanceSpecification instance) {
        Collection<InstanceSpecification> result = CollectionUtil
            .createNewSet();

        Property otherEnd = property.getOtherEnd();

        for (Slot slot : getSlotsReferencing(instance)) {
            if (slot.getDefiningFeature() == otherEnd) {
                InstanceSpecification referencer = slot.getOwningInstance();

                if (referencer != null) {
                    if (isInstance(association, referencer)) {
                        // get value of the other end. Multiplicity of an
                        // association end is always 1 from the association's
                        // perspective
                        Slot otherSlot = getSlot(referencer, otherEnd);
                        if (otherSlot != null) {
                            ValueSpecification value = otherSlot.getValues()
                                .isEmpty() ? null
                                : otherSlot.getValues().get(0);
                            if ((value != null)
                                && (value instanceof InstanceValue)) {
                                result.add(((InstanceValue) value)
                                    .getInstance());
                            }
                        }
                    } else {
                        // navigable opposite
                        result.add(referencer);
                    }
                }
            }
        }

        return coerceValue(property, result, true);
    }

    /**
     * Queries whether the specified property redefines (recursively) another
     * property.
     * 
     * @param feature
     *            a property
     * @param redefined
     *            a property that (we hope) it redefines
     * 
     * @return <code>true</code> if the feature redefines the redefined
     *         property (or some property that, recursively, redefines it);
     *         <code>false</code>, otherwise
     */
    private boolean redefines(StructuralFeature feature, Property redefined) {
        if (feature == redefined) {
            // base case
            return true;
        }

        if (feature instanceof Property) {
            Property property = (Property) feature;

            for (Property next : property.getRedefinedProperties()) {
                if (redefines(next, redefined)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Gets the Java value in an instance's slot.
     * 
     * @param slot
     *            a slot
     * @return the value in the slot, as a Java object (not a
     *         {@link ValueSpecification})
     */
    private Object getValue(Slot slot) {
        List<ValueSpecification> values = slot.getValues();

        if (isMultivaluedSlot(slot)) {
            StructuralFeature feature = slot.getDefiningFeature();

            // create a collection of the kind appropriate to the feature.
            // If the feature is ordered, then the order of the values in
            // the slot is preserved
            return getValueExtractor()
                .extractValues(
                    values,
                    CollectionKind.getKind(feature.isOrdered(), feature
                        .isUnique()));
        } else {
            return values.isEmpty() ? null
                : getValueExtractor().extractValue(values.get(0));
        }
    }

    /**
     * Queries whether an instance's slot is multivalued. This depends on the
     * owner, because a member-end slot of an association class link has
     * multiplicity 1 regardless of the multiplicity of the slot's defining
     * property.
     * 
     * @param slot
     *            a slot
     * @return whether the slot is multi-valued from the perspective of its
     *         owner's type
     */
    private boolean isMultivaluedSlot(Slot slot) {
        return isMultivaluedSlot(slot.getOwningInstance(), (Property) slot
            .getDefiningFeature());
    }

    private boolean isMultivaluedSlot(InstanceSpecification owner,
            Property property) {
        Classifier classifier = owner.getClassifiers().isEmpty() ? null
            : owner.getClassifiers().get(0);

        if (classifier instanceof Association) {
            return (property.getAssociation() != classifier)
                && property.isMultivalued();
        }

        return property.isMultivalued();
    }

    /**
     * Converts enumeration literal values in the Ecore definition of an
     * enumeration to the corresponding UML literal specification.
     * 
     * @param enumType
     *            the type of the expected enumeration literal(s)
     * @param value
     *            an enumeration literal or some collection of literals in the
     *            case of a multivalued attribute, as the Ecore definition of
     *            the enumeration literal(s)
     * @return the corresponding UML definition of the enumeration literal(s)
     */
    private Object convertEnumerationValue(Enumeration enumType, Object value) {
        Object result;

        if (value instanceof Enumerator) {
            result = enumType.getOwnedLiteral(((Enumerator) value).getName());
        } else if (value instanceof Collection) {
            @SuppressWarnings("unchecked")
            Collection<Enumerator> coll = (Collection<Enumerator>) value;

            // create a collection of the same kind
            Collection<EnumerationLiteral> newColl = CollectionUtil
                .createNewCollectionOfSameKind(coll);

            for (Enumerator e : coll) {
                newColl.add(enumType.getOwnedLiteral(e.getName()));
            }

            result = newColl;
        } else {
            result = value;
        }

        return result;
    }

    private ValueExtractor getValueExtractor() {
        if (valueExtractor == null) {
            valueExtractor = new ValueExtractor();
        }

        return valueExtractor;
    }

    Object findValueQualifiedBy(InstanceSpecification source,
            Property property, List<?> qualifiers) {
        // from amongst the links referencing this source instance, find the
        // one that has the specified qualifier values and get its value for
        // the property
        Association association = property.getAssociation();
        Property otherEnd = property.getOtherEnd();

        for (EStructuralFeature.Setting setting : UML2Util
            .getNonNavigableInverseReferences(source)) {

            if (setting.getEStructuralFeature() == UMLPackage.Literals.INSTANCE_VALUE__INSTANCE) {

                InstanceValue value = (InstanceValue) setting.getEObject();
                if (value.getOwner() instanceof Slot) {
                    Slot slot = (Slot) value.getOwner();

                    if (slot.getDefiningFeature() == otherEnd) {
                        InstanceSpecification link = slot.getOwningInstance();

                        for (Classifier c : link.getClassifiers()) {
                            if (c.conformsTo(association)) {
                                // found a link instance of this association.
                                // Look for the qualifier values
                                if (match(link, property.getQualifiers(),
                                    qualifiers)) {
                                    // get the property value for this link
                                    return navigateProperty(property,
                                        Collections.emptyList(), link);
                                }

                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * Queries whether the specified <code>instance</code> has slots for the
     * given <code>properties</code> that have these <code>values</code>.
     * 
     * @param instance
     *            an instance specification
     * @param properties
     *            a list of properties
     * @param values
     *            values to look for in the slots of the instance defined by the
     *            given properties
     * 
     * @return <code>true</code> if this instance has the matching property
     *         values; <code>false</code>, otherwise
     */
    private boolean match(InstanceSpecification instance,
            List<Property> properties, List<?> values) {

        int found = 0;

        for (Slot slot : instance.getSlots()) {
            int index = properties.indexOf(slot.getDefiningFeature());

            if (index >= 0) {
                Object actualValue = getValue(slot);

                if (UML2Util.safeEquals(actualValue, values.get(index))) {
                    found++;
                }
            }
        }

        return found == properties.size();
    }

    private boolean isInstance(Classifier classifier,
            InstanceSpecification instance) {
        for (Classifier c : instance.getClassifiers()) {
            if (c.conformsTo(classifier)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Finds the slot defined by the specified property in a given instance
     * specification.
     * 
     * @param instance
     *            an instance specification
     * @param property
     *            a property of (one of) the instance's classifier(s)
     * 
     * @return the instance's slot for this property, or <code>null</code> if
     *         no such slot is defined
     */
    private Slot getSlot(InstanceSpecification instance, Property property) {
        for (Slot slot : instance.getSlots()) {
            if (slot.getDefiningFeature() == property) {
                return slot;
            }
        }

        return null;
    }

    /**
     * Performs a reverse-reference lookup for slots that have
     * <code>InstanceValue</code>s referencing the specified instance
     * specification.
     * 
     * @param instance
     *            an instance specification
     * @return the slots referencing it (or an empty collection if none)
     */
    private Collection<Slot> getSlotsReferencing(InstanceSpecification instance) {
        Collection<Slot> result = CollectionUtil.createNewSet();

        for (EStructuralFeature.Setting setting : UML2Util
            .getNonNavigableInverseReferences(instance)) {
            if (setting.getEStructuralFeature() == UMLPackage.Literals.INSTANCE_VALUE__INSTANCE) {
                InstanceValue value = (InstanceValue) setting.getEObject();
                if (value.getOwner() instanceof Slot) {
                    result.add((Slot) value.getOwner());
                }
            }
        }

        return result;
    }

    /**
     * Looks up the Ecore definition of the specified UML classifier, using the
     * specified <code>element</code> as a context for finding profile
     * applications in the case that the classifier is a stereotype or some
     * other type in a {@link Profile}. Finding the Ecore definition of a
     * profile type requires finding the actual applied version of the profile.
     * 
     * @param umlClassifier
     *            a UML classifier
     * @param element
     *            an element in the context of which the OCL evaluation is being
     *            performed
     * @return the corresponding Ecore classifier, or <code>null</code> if not
     *         found
     */
    @Override
    protected EClassifier getEClassifier(Classifier umlClassifier,
            Object element) {
        EClassifier result = null;
        Package umlPackage = umlClassifier.getPackage();
        EPackage ecorePackage = null;

        if (umlPackage instanceof Profile) {
            // use the element to get the most appropriate profile definition
            Profile profile = (Profile) umlPackage;

            if (element instanceof Element) {
                Element umlElement = (Element) element;

                Package nesting = umlElement.getNearestPackage();
                while (nesting != null) {
                    ProfileApplication appl = nesting
                        .getProfileApplication(profile);
                    if (appl != null) {
                        ecorePackage = appl.getAppliedDefinition();
                        break;
                    }

                    nesting = (nesting.getOwner() == null)
						? null
						: nesting.getOwner().getNearestPackage();
                }
            }

            if (ecorePackage == null) {
                // assume the latest definition of the profile (if any)
                ecorePackage = profile.getDefinition();
            }
        } else if (umlPackage != null) {
            ecorePackage = getEPackage(umlPackage);
        }

        if (ecorePackage != null) {
            result = ecorePackage.getEClassifier(UML2Util
                .getValidJavaIdentifier(umlClassifier.getName()));
        }

        return result;
    }

    /**
     * A converter of UML value specifications to OCL (Java) values.
     * 
     * @author Christian W. Damus (cdamus)
     */
    class ValueExtractor
        extends UMLSwitch<Object> {

        @Override
        public Object caseLiteralBoolean(LiteralBoolean object) {
            return Boolean.valueOf(object.booleanValue());
        }

        @Override
        public Object caseLiteralInteger(LiteralInteger object) {
            return new Integer(object.integerValue());
        }

        @Override
        public Object caseLiteralNull(LiteralNull object) {
            return null;
        }

        @Override
        public Object caseLiteralString(LiteralString object) {
            return object.stringValue();
        }

        @Override
        public Object caseLiteralUnlimitedNatural(LiteralUnlimitedNatural object) {
            return new Integer(object.unlimitedValue());
        }

        @Override
        public Object caseInstanceValue(InstanceValue object) {
            return object.getInstance();
        }

        @Override
        public Object caseValueSpecification(ValueSpecification object) {
            // the default case is a value specification that we don't
            // understand
            return OCLStandardLibraryImpl.INVALID;
        }

        /**
         * Converts the specified collection of UML values to a collection of
         * OCL values.
         * 
         * @param values
         *            UML values
         * @return the corresponding OCL values
         */
        Collection<?> extractValues(
                Collection<? extends ValueSpecification> values,
                CollectionKind collectionKind) {
            Collection<Object> result = CollectionUtil
                .createNewCollection(collectionKind);

            for (ValueSpecification value : values) {
                result.add(extractValue(value));
            }

            return result;
        }

        /**
         * Converts the specified UML values to an OCL value.
         * 
         * @param values
         *            a UML value
         * @return the corresponding OCL value
         */
        Object extractValue(ValueSpecification value) {
            return doSwitch(value);
        }
    }
	
    //
    // END TO-DELETE SECTION
    //
}
