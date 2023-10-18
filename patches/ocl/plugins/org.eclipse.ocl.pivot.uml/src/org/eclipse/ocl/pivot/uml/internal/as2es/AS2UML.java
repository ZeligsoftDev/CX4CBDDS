/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.as2es;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.utilities.AbstractConversion;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class AS2UML extends AbstractConversion
{
	public static @NonNull List<@NonNull EObject> createResource(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Resource asResource) {
		List<@NonNull EObject> pivotModels = ClassUtil.nullFree(asResource.getContents());
		AS2UML converter = new AS2UML(environmentFactory);
		return converter.convertAll(pivotModels);
	}

	/**
	 * Mapping of pivot elements to the resulting E elements.
	 */
	private Map<Element, EModelElement> createMap = new HashMap<Element, EModelElement>();

	/**
	 * Mapping of all E elements created during pass 1 that require further work
	 * with respect to the corresponding CS element in pass 2.
	 */
	Set<Element> deferMap = new HashSet<Element>();
	
	private List<Resource.Diagnostic> errors = null;
	
	protected final AS2UMLDeclarationVisitor pass1 = new AS2UMLDeclarationVisitor(this);	
	protected final AS2UMLReferenceVisitor pass2 = new AS2UMLReferenceVisitor(this);
	
//	protected final ResourceSet resourceSet;
//	protected final Resource csResource;
//	protected final XMLResource eResource;

	public AS2UML(@NonNull EnvironmentFactoryInternal environmentFactory/*ResourceSet resourceSet, Resource csResource, URI ecoreURI*/) {
		super(environmentFactory);
//		this.resourceSet = resourceSet;
//		this.csResource = csResource;
//		this.eResource = (XMLResource) new EcoreResourceFactoryImpl().createResource(ecoreURI);
	}
	
	protected @Nullable EObject convert(@NonNull Element pivotObject) {
		EObject eObject = pass1.safeVisit(pivotObject);
		for (Element eKey : deferMap) {
			pass2.safeVisit(eKey);
		}
		return eObject;
	}

	protected @NonNull List<@NonNull EObject> convertAll(@NonNull List<? extends EObject> pivotObjects) {
		List<@NonNull EObject> eObjects = new ArrayList<@NonNull EObject>();
		for (EObject pivotObject : pivotObjects) {
			if (pivotObject instanceof Element) {
				EModelElement convertedEObject = pass1.safeVisit((Visitable) pivotObject);
				if (convertedEObject != null) {
					eObjects.add(convertedEObject);
				}
			}
		}
		for (Element eKey : deferMap) {
			pass2.safeVisit(eKey);
		}
		return eObjects;
	}

	protected void error(@NonNull String message) {
		if (errors == null) {
			errors = new ArrayList<Resource.Diagnostic>();
		}
		errors.add(new XMIException(message));
	}

/*	public XMLResource exportToEcore() {
		OCLinEcoreDocumentCS document = (OCLinEcoreDocumentCS) csResource.getContents().get(0);
		Collection<? extends EObject> ecoreContents = convertAll(document.getPackages());
		eResource.getContents().addAll(ecoreContents);
		if (errors != null) {
			eResource.getErrors().addAll(errors);
		}
		return eResource;
	} */

	public void defer(@NonNull Element pivotElement) {
		deferMap.add(pivotElement);
	}

	public <T extends EObject> @Nullable T getCreated(@NonNull Class<T> requiredClass, @NonNull Element pivotElement) {
		EModelElement eModelElement = createMap.get(pivotElement);
		if (eModelElement == null) {
			return null;
		}
		if (!requiredClass.isAssignableFrom(eModelElement.getClass())) {
			throw new ClassCastException(eModelElement.getClass().getName() + " is not assignable to " + requiredClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) eModelElement;
		return castElement;
	}

	public void putCreated(@NonNull Element pivotElement, @NonNull EModelElement eModelElement) {
		EModelElement old = createMap.put(pivotElement, eModelElement);
		assert old == null;
	}
}