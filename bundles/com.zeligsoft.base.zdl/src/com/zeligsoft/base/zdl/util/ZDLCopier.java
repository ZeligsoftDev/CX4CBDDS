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
package com.zeligsoft.base.zdl.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;

import com.zeligsoft.base.util.FilteringList;



/**
 * A mapping building traverser of a collection of ZDL model elements; the map
 * is from original to copy. use copy or copyAll to make copies of a single
 * element or collection of elements respectively. The client can call copy
 * and copyAll repeatedly.
 *
 * If an element has already been copied then it will return the existing copy.
 *
 * When all the objects have been copied, the client should call copyReferences
 * to update the appropriate cross references.
 *
 * WARNING : This assumes that the ZDL metamodel is correct and complete. That
 * is if for example a ZDL attribute is read-write and is mapped onto a readonly
 * UML metaclass attribute it will fail. Also it can't copy information that is
 * not specified in the ZDL metamodel.
 *
 * @author Toby McClean (tmcclean)
 *
 */
public class ZDLCopier {

	private HashMap<EObject, EObject> map;
	protected EcoreUtil.Copier ecoreCopier;

	/**
	 * Create me.
	 */
	public ZDLCopier() {
		map = new HashMap<EObject, EObject>();
		ecoreCopier = new EcoreUtil.Copier();
	}

	/**
	 * Returns a collection containing a copy of each ZDL model element in
	 * the given collection.
	 *
	 * @param elements
	 * 		the collection of ZDL model elements to copy.
	 * @return
	 * 		the collection of copies
	 */
	public List<EObject> copyAll(final Collection<EObject> elements) {
		List<EObject> result = new ArrayList<EObject>(elements.size());

		for (EObject next : elements) {
			result.add(copy(next));
		}

		return result;
	}

	/**
	 * Returns a copy of the given ZDL model element.
	 * @param element
	 * 		the model element to copy
	 * @param container
	 *		the model element to copy the model element into
	 * @param feature
	 * 		the feature to add the element to, can be null if you
	 * 		are absolutely sure that it is a ZDLConcept
	 * @return
	 * 		the copy
	 */
	public EObject copy(EObject element, EObject container, EStructuralFeature feature) {
		EObject copyOfElement = get(element);
		if (copyOfElement == null) {
			copyOfElement = createCopy(element, container, feature);
			put(element, copyOfElement);
			copyAttributes(element, copyOfElement);
		}

		return copyOfElement;
	}

	/**
	 * Returns a copy of the given ZDL model element.
	 *
	 * @param element
	 * 		the model element to copy
	 * @return
	 * 		the copy
	 */
	public EObject copy(EObject element) {
		EObject copyOfElement = get(element);
		if (copyOfElement == null) {
			copyOfElement = createCopy(element);
			put(element, copyOfElement);
			copyAttributes(element, copyOfElement);
		}

		return copyOfElement;
	}
	
	/**
	 * Returns a copy of the given ZDL model element.
	 *
	 * @param element
	 * 		the model element to copy
	 * @param container
	 * 		the model element to copy into
	 * @param targetProperty
	 * 		the property on the container to store the copy in
	 */
	public EObject copy(EObject element, EObject container, Property targetProperty) {
		return copy(element, container, targetProperty, true);
	}
	
	/**
	 * Returns a copy of the given ZDL model element.
	 *
	 * @param element
	 * 		the model element to copy
	 * @param container
	 * 		the model element to copy into
	 * @param targetProperty
	 * 		the property on the container to store the copy in
	 * @param shouldPut
	 * 		if copy of element should be put into map or not
	 * @return
	 * 		the copy
	 */
	public EObject copy(EObject element, EObject container, Property targetProperty, boolean shouldPut) {
		EObject copyOfElement = get(element);
		if (copyOfElement == null) {
			copyOfElement = createCopy(element, container, targetProperty);
			if(shouldPut) {
				put(element, copyOfElement);
			}
			copyAttributes(element, copyOfElement);
		}
		return copyOfElement;
	}

	/**
	 * Iterates over all of the attributes on the metaclass and copies
	 * the values from the source (element) to the target (copyOfElement).
	 *
	 * @param element
	 * 		the source model element
	 * @param copyOfElement
	 * 		the target model element to copy the values of properties to
	 */
	public void copyAttributes(EObject element, EObject copyOfElement) {
		Class concept = ZDLUtil.getZDLConcept(element);
		for (Property prop : concept.getAllAttributes()) {
			
			EStructuralFeature feature = ZDLUtil.getPropertyMapping(prop,
					element);
			if (feature != null && feature instanceof EReference
					&& !prop.isComposite()) {
				// Let copyReference() take care of references
				continue;
			}
			copyProperty(concept, prop, element, copyOfElement);
		}
	}

	/**
	 * Returns a new instance of the elements target concept.
	 * @param element
	 * 		the model element to copy
	 * @param container
	 * 		the element to create the concept in.
	 *
	 * @return
	 * 		a new instance of the target concept
	 */
	@SuppressWarnings("unchecked")
	protected EObject createCopy(EObject element, EObject container, EStructuralFeature feature) {
		EObject result = null;
		Class concept = ZDLUtil.getZDLConcept(element);
		
		if (concept != null && !concept.isAbstract()) {
			result = ZDLUtil.createZDLConceptIn(container, concept);
			ecoreCopier.put(element, result);
		} else {
			if (feature == null) {
				throw new IllegalArgumentException(
						"Can not copy a abstract ZDL concept or non ZDL element without a feature."); //$NON-NLS-1$
			}
			result = ecoreCopier.copy(element);
			if (feature.isMany()) {
				Object value = container.eGet(feature);
				if (value instanceof Collection) {
					((Collection<EObject>) value).add(result);
				} else {
					throw new IllegalArgumentException(
							"The value of the feature is not a collection and it should be."); //$NON-NLS-1$
				}
			} else {
				container.eSet(feature, result);
			}
		}

		return result;
	}

	/**
	 * Returns a new instance of the elements target concept.
	 *
	 * @param element
	 * 		the element to copy
	 * @return
	 * 		a new instance of the target concept
	 */
	protected EObject createCopy(EObject element) {
		EObject result = null;

		Class concept = ZDLUtil.getZDLConcept(element);

		if (concept != null && !concept.isAbstract()) {
			result = ZDLUtil.createZDLConcept(element, concept);
			ecoreCopier.put(element, result);
		} else {
			result = ecoreCopier.copy(element);
		}

		return result;
	}

	/**
	 * Returns a new instance of the elements target concept.
	 * @param element
	 * 		the element to copy
	 * @param container
	 * 		the element to create the concept in
	 * @param property
	 * 		the property on the element to create the concept in
	 *
	 * @return
	 * 		a new instance of the target concept
	 */
	@SuppressWarnings("unchecked")
	protected EObject createCopy(EObject element, EObject container, Property property) {
		EObject result = null;
		Class containerConcept = ZDLUtil.getZDLConcept(container);
		Class conceptToCreate = ZDLUtil.getZDLConcept(element);

		if (conceptToCreate != null && !conceptToCreate.isAbstract()) {
			result = ZDLUtil.createZDLConcept(container,
				containerConcept,
				property.getName(),
				conceptToCreate);
			ecoreCopier.put(element, result);
		} else {
			result = ecoreCopier.copy(element);

			if(property.isMultivalued()) {
				if(ZDLUtil.isAbstractConceptMapping(conceptToCreate, container)) {
					EStructuralFeature feature = ZDLUtil.getPropertyMapping(property, container);
					Object value = container.eGet(feature);
					if(value instanceof Collection) {
						((Collection<EObject>) value).add(result);
					}
				} else {
					Object value = ZDLUtil.getValue(container, containerConcept, property.getName());
					if(value instanceof Collection) {
						((Collection<EObject>) value).add(result);
					}
				}
			} else {
				ZDLUtil.setValue(container, containerConcept, property.getName(), result);
			}
			
		}
		
		return result;
	}
	
	/**
	 * Returns the target concept used to create a copy instance for 
	 * objects of the given source class.
	 * 
	 * @param concept
	 * 		the source class
	 * @return
	 * 		the target class used to create a copy instance
	 */
	protected Class getTarget(Class concept) {
		return concept;
	}
	
	/**
	 * Returns the target feature used to populate a copy instance from the 
	 * given source property.
	 * 
	 * @param feature
	 * 		the source feature
	 * @return
	 * 		the target feature used to populate a copy instance
	 */
	protected StructuralFeature getTarget(StructuralFeature feature) {
		return feature;
	}
	
	/**
	 * Called to handle copying of an attribute; it adds a list of values
	 * or sets a single value as appropriate for the multiplicity.
	 * 
	 * @param concept
	 * 		The ZDL concept that owns that defines the property
	 * @param property
	 * 		the property whose value is to be copied
	 * @param element
	 * 		the source model element that the property value is being copied
	 * 		from
	 * @param copyOfElement
	 * 		the target model element that the property value is being copied
	 * 		to
	 */
	protected void copyProperty(Class concept, Property property, EObject element, EObject copyOfElement){
		copyProperty(concept, property, element, copyOfElement, true);
	}
	
	/**
	 * Called to handle copying of an attribute; it adds a list of values
	 * or sets a single value as appropriate for the multiplicity.
	 * 
	 * @param concept
	 * 		The ZDL concept that owns that defines the property
	 * @param property
	 * 		the property whose value is to be copied
	 * @param element
	 * 		the source model element that the property value is being copied
	 * 		from
	 * @param copyOfElement
	 * 		the target model element that the property value is being copied
	 * 		to
	 * @param shouldPut
	 * 		if copy of element should be put into map or not
	 */
	@SuppressWarnings("unchecked")
	protected void copyProperty(Class concept, Property property, EObject element, EObject copyOfElement, boolean shouldPut) {
		Object eObjectValue = 
			ZDLUtil.getValue(element, concept, property.getName());
		
		if(!property.isReadOnly() && !property.isDerived()) {
			if(isSet(eObjectValue, property)) {
				if(property.isMultivalued()) {
					List<Object> copyEObjectValue = (List<Object>) 
						ZDLUtil.getValue(copyOfElement, concept, property.getName());
					List<?> sourceValue = (List<?>) eObjectValue;
					
					if(sourceValue.isEmpty()) {
						copyEObjectValue.clear();
					} else if(property.isComposite()) {
						for(Object containedElement : sourceValue) {
							copy((EObject) containedElement, copyOfElement, property, shouldPut);
						}
					} else {
						copyEObjectValue.addAll(sourceValue);
					}
				} else {			
					if(property.isComposite()) {
						copy((EObject) eObjectValue, copyOfElement, property, shouldPut);
					} else {
						ZDLUtil.setValue(copyOfElement, concept, property.getName(), eObjectValue);
					}
					
				}
			}
		}
	}
	
	/**
	 * Hooks up cross references.
	 */
	public void copyReferences() {
		
		ecoreCopier.copyReferences();

		// copy references for stereotyped references that is not set by ECore copy reference
		for(Iterator<Map.Entry<EObject, EObject>> i = map.entrySet().iterator(); i.hasNext();) {
			Map.Entry<EObject, EObject> entry= i.next();
			EObject eObject = entry.getKey();
			EObject copyEObject = entry.getValue();
			Class concept = ZDLUtil.getZDLConcept(eObject);
			
			for(Property feature : concept.getAllAttributes()) {
				if(!feature.isReadOnly() && !feature.isDerived()) {
					if(!feature.isComposite()) {
						copyReference(concept, feature, eObject, copyEObject);
					}
				}
			}
		}
	}
	
	/**
	 * Called to handle the copying of a cross reference; this adds values
	 * or sets a single value as appropriate for the multiplicity while
	 * omitting any bidirectional reference that isn't in the copy map.
	 * 
	 * @param concept
	 * 		the concept that owns the feature
	 * @param feature
	 * 		the feature to update the cross references for
	 * @param element
	 * @param copyOfElement
	 */
	@SuppressWarnings("unchecked")
	protected void copyReference(Class concept, Property feature, EObject element, EObject copyOfElement) {
		Object eObjectValue = 
			ZDLUtil.getValue(element, concept, feature.getName());
		
		if(isSet(eObjectValue, feature)) {
			if(feature.isMultivalued()) {
				List<Object> source = (List<Object>) eObjectValue;
				List<Object> target = (List<Object>) ZDLUtil.getValue(
						copyOfElement, concept, feature.getName());
				copyListReferences(source, target);
			} else {
				if(eObjectValue == null) {
					ZDLUtil.setValue(copyOfElement, concept, feature.getName(), null);
				} else {
					Object copyReferencedEObject = get(eObjectValue);
					if(copyReferencedEObject == null) {
						ZDLUtil.setValue(copyOfElement, concept, feature.getName(), eObjectValue);
					} else {
						ZDLUtil.setValue(copyOfElement, concept, feature.getName(), copyReferencedEObject);
					}
				}
			}
		}
	}
	
	/**
	 * A helper method to copy the elements from a source list to a target list.
	 * @param source
	 * 		The list of elements to copy
	 * @param target
	 * 		The list to copy the elements to
	 */
	protected void copyListReferences(List<Object> source, List<Object> target) {
		target.clear();
		int index = 0;
		for(Object referencedObject : source) {
			Object copyReferencedEObject = get(referencedObject);
			if(copyReferencedEObject == null) {
				addUniqueHelper(target, index, referencedObject);
			} else {
				addUniqueHelper(target, index, copyReferencedEObject);
			}
			++index;
		}
	}
	
	/**
	 * A utility function to copy to a unique list.
	 * 
	 * @param target
	 * 		The list to copy into
	 * @param index
	 * 		The index to store it in
	 * @param object
	 * 		The object to copy to
	 */
	protected static void addUniqueHelper(List<Object> target, int index, Object object) {
		if(target.contains(object)){
			return;
		}
		
		if(target instanceof FilteringList) {
			((FilteringList<Object>) target).addUnique(index, object);
		} else if(target instanceof InternalEList) {
			((InternalEList<Object>) target).addUnique(index, object);
		} else {
			if(!target.contains(object)) {
				target.add(index, object);
			}
		}
	}

	/**
	 * Given an association and a concept figure out the property that is the
	 * target.
	 * 
	 * @param concept
	 * 		the concept to find the concept on.
	 * @param assoc
	 * 		the association being used to find the corresponding target property
	 * @return
	 * 		the property
	 */
	@SuppressWarnings("nls")
	protected Property getTarget(Class concept, Association assoc) {
		List<Property> navigableOwnedEnds = assoc.getNavigableOwnedEnds();
		Property theProperty = null;
		
		for(Property end : navigableOwnedEnds) {
			if(end.getOwner() == concept) {
				theProperty = end;
				break;
			}
		}
		
		if(theProperty != null) {
			return theProperty;
		} else {
			throw new IllegalArgumentException(
					String.format("Can not find the target for the given concept (%s) and association (%s).", 
							concept.toString(), assoc.toString()));
		}
	}
	
	/**
	 * Check to see if the given value is set in the context of the provided
	 * property.
	 * 
	 * @param value
	 * 		The value to check
	 * @param property
	 * 		The property that specifies the value's context
	 * @return
	 * 		true if the value is set and false otherwise
	 */
	protected boolean isSet(Object value, Property property) {
		boolean result = false;
		
		if(value == null) {
			result = false;
		} else if(property.isMultivalued() && value instanceof Collection) {
			result = !((Collection<?>) value).isEmpty();
		} else {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @see java.util.HashMap#clear()
	 */
	public void clear() {
		map.clear();
		ecoreCopier.clear();
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.HashMap#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	/**
	 * @param value
	 * @return
	 * @see java.util.HashMap#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.HashMap#get(java.lang.Object)
	 */
	public EObject get(Object key) {
		return map.get(key);
	}

	/**
	 * @return
	 * @see java.util.HashMap#isEmpty()
	 */
	public boolean isEmpty() {
		return map.isEmpty();
	}

	/**
	 * @return
	 * @see java.util.HashMap#keySet()
	 */
	public Set<EObject> keySet() {
		return map.keySet();
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
	 */
	public EObject put(EObject key, EObject value) {
		return map.put(key, value);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.HashMap#remove(java.lang.Object)
	 */
	public EObject remove(Object key) {
		return map.remove(key);
	}

	/**
	 * @return
	 * @see java.util.HashMap#values()
	 */
	public Collection<EObject> values() {
		return map.values();
	}
	
	/**
	 * @return
	 * @see java.util.HashMap#entrySet()
	 */
	public Set<Entry<EObject, EObject>> entrySet() {
		return map.entrySet();
	}
}
