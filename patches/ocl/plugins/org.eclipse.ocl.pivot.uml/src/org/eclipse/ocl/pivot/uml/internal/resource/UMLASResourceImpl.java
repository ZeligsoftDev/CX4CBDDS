/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;

public class UMLASResourceImpl extends ASResourceImpl
{
	/**
	 * Mapping from the OMG namespace UML types to the Eclipse UML2 namespace classes.
	 */
	private /*@LazyNonNull*/ Map<org.eclipse.uml2.uml.Type, EClassifier> uml2ecore = null;

	public UMLASResourceImpl(@NonNull URI uri, @NonNull ASResourceFactory asResourceFactory) {
		super(uri, asResourceFactory);
	}

	/**
	 * Return the Eclipse UML2 namespace variant of an OMG namespace type.
	 */
	public @Nullable EClassifier getEClassifier(org.eclipse.uml2.uml.@NonNull Type umlType) {
		if (uml2ecore == null) {
			uml2ecore = new HashMap<org.eclipse.uml2.uml.Type, EClassifier>();
		}
		EClassifier eClassifier = uml2ecore.get(umlType);
		if (eClassifier != null) {
			return eClassifier;
		}
		if (uml2ecore.containsKey(umlType)) {
			return null;
		}
		org.eclipse.uml2.uml.Package umlPackage = umlType.getPackage();
		if (umlPackage != null) {
			String typeName = umlType.getName();
			if (XMI2UMLResource.UML_METAMODEL_NS_URI.equals(umlPackage.getURI())) {
				eClassifier = UMLPackage.eINSTANCE.getEClassifier(typeName);
			}
			else if (XMI2UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_NS_URI.equals(umlPackage.getURI())) {
				eClassifier = TypesPackage.eINSTANCE.getEClassifier(typeName);
			}
		}
		uml2ecore.put(umlType, eClassifier);
		return eClassifier;
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		@NonNull URI umlURI = uri.trimFileExtension();
		UML2AS.loadFromUML(this, umlURI);
		super.load(options);
	}
}