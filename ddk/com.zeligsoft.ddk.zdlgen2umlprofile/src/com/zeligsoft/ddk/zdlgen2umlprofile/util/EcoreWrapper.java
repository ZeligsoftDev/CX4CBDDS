/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdlgen2umlprofile.util;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;

/**
 * A utility class that is used to work around some issues that Xtend has with
 * the e* methods from EObject. For some reason it does not recognize these
 * methods during execution so I have had to wrap them and add extensions to
 * an Xtend file to make them work.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class EcoreWrapper {
	public static EObject eContainmentFeature(Element el) {
		return el.eContainmentFeature();
	}
	
	public static EClass eClass(Element el) {
		return el.eClass();
	}
	
	public static EObject eContainer(Element el) {
		return el.eContainer();
	}

	/**
	 * @param deliver
	 * @see org.eclipse.emf.common.notify.Notifier#eSetDeliver(boolean)
	 */
	public static void eSetDeliver(Element el, boolean deliver) {
		el.eSetDeliver(deliver);
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eResource()
	 */
	public static Resource eResource(Element el) {
		return el.eResource();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eContainingFeature()
	 */
	public static EStructuralFeature eContainingFeature(Element el) {
		return el.eContainingFeature();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eContents()
	 */
	public static EList<EObject> eContents(Element el) {
		return el.eContents();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eAllContents()
	 */
	public static TreeIterator<EObject> eAllContents(Element el) {
		return el.eAllContents();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eIsProxy()
	 */
	public static boolean eIsProxy(Element el) {
		return el.eIsProxy();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eCrossReferences()
	 */
	public static EList<EObject> eCrossReferences(Element el) {
		return el.eCrossReferences();
	}

	/**
	 * @param feature
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public static Object eGet(Element el, EStructuralFeature feature) {
		return el.eGet(feature);
	}

	/**
	 * @param feature
	 * @param resolve
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature, boolean)
	 */
	public static Object eGet(Element el, EStructuralFeature feature, boolean resolve) {
		return el.eGet(feature, resolve);
	}

	/**
	 * @param feature
	 * @param newValue
	 * @see org.eclipse.emf.ecore.EObject#eSet(org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	public static void eSet(Element el, EStructuralFeature feature, Object newValue) {
		el.eSet(feature, newValue);
	}

	/**
	 * @param feature
	 * @return
	 * @see org.eclipse.emf.ecore.EObject#eIsSet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public static boolean eIsSet(Element el, EStructuralFeature feature) {
		return el.eIsSet(feature);
	}

	/**
	 * @param feature
	 * @see org.eclipse.emf.ecore.EObject#eUnset(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public static void eUnset(Element el, EStructuralFeature feature) {
		el.eUnset(feature);
	}

	/**
	 * @param operation
	 * @param arguments
	 * @return
	 * @throws InvocationTargetException
	 * @see org.eclipse.emf.ecore.EObject#eInvoke(org.eclipse.emf.ecore.EOperation, org.eclipse.emf.common.util.EList)
	 */
	public static Object eInvoke(Element el, EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		return el.eInvoke(operation, arguments);
	}
	
	public static EAnnotation getEAnnotation(Element el, String source) {
		return el.getEAnnotation(source);
	}
	
	public static EList<EAnnotation> getEAnnotations(Element el) {
		return el.getEAnnotations();
	}
}
