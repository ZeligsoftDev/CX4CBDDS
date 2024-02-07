/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.elements;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.util.Visitor;

public class AbstractExecutorElement implements Element
{
	protected AbstractExecutorElement() {
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Element> allOwnedElements() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EList<Adapter> eAdapters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull TreeIterator<@NonNull EObject> eAllContents() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EClass eClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EObject eContainer() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EReference eContainmentFeature() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EList<EObject> eContents() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eDeliver() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eIsProxy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eNotify(Notification notification) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Resource eResource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Comment> getAnnotatingComments() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EObject getESObject() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EObject getETarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<ElementExtension> getOwnedExtensions() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Element> getOwnedAnnotations() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Comment> getOwnedComments() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Element getValue(Type stereotype, String propertyName) {
		throw new UnsupportedOperationException();
	}
}