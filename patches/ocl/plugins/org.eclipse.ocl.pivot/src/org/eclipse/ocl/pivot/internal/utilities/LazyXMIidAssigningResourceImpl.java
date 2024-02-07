/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.XMIUtil;

/**
 * LazyXMIidAssigningResourceImpl provides an enhanced XMIResourceImpl for Ecore metamodels.
 * It assigns the determinstic xmi:ids lazily.
 *
 * @since 1.4
 */
public class LazyXMIidAssigningResourceImpl extends XMIResourceImpl
{
	public static @NonNull XMIResource createResource(/*@NonNull*/ String uri, @NonNull EPackage ePackage) {
		LazyXMIidAssigningResourceImpl resource = new LazyXMIidAssigningResourceImpl(URI.createURI(uri));
		resource.getContents().add(ePackage);
		return resource;
	}

	protected LazyXMIidAssigningResourceImpl(@NonNull URI uri) {
		super(uri);
	}

	protected void assignIds(@NonNull String debugCalledFrom) {
		//
		//	Check that XXXPackageImpl.init() has completed and that consequently any tests
		//	during loading by the attchedHelper are done.
		//
		List<EObject> contents2 = getContents();
		if (contents2.size() > 0) {
			EObject eContent = contents2.get(0);
			if (eContent instanceof EPackage) {
				EPackage ePackage = (EPackage)eContent;
				if (EPackage.Registry.INSTANCE.get(ePackage.getNsURI()) == ePackage) {
//					System.out.println("Assign ids in " + debugCalledFrom + ": " + getURI());
					super.getEObjectToIDMap();
					super.getIDToEObjectMap();
					XMIUtil.assignIds(this, new XMIUtil.StructuralENamedElementIdCreator(), null);
				}
			}
		}
	}

	@Override
	public Map<EObject, String> getEObjectToIDMap() {
		if (eObjectToIDMap == null) {
			assignIds("getEObjectToIDMap");
		}
		return super.getEObjectToIDMap();
	}

	@Override
	protected EObject getEObjectByID(String id) {
		if (eObjectToIDMap == null) {
			assignIds("getEObjectByID");		// This is perhaps the only real assignment path
		}
		return super.getEObjectByID(id);
	}

	@Override
	public String getID(EObject eObject) {
		if (eObjectToIDMap == null) {
			assignIds("getID");
		}
		return super.getID(eObject);
	}

	@Override
	public Map<String, EObject> getIDToEObjectMap() {
		if (eObjectToIDMap == null) {
			assignIds("getIDToEObjectMap");
		}
		return super.getIDToEObjectMap();
	}

	@Override
	protected boolean useIDAttributes() {
		return false;
	}

	@Override
	protected boolean useIDs() {
		return true;
	}
}