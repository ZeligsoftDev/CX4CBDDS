/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.internal.manager.PivotIdResolver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class EcoreTechnology extends AbstractTechnology
{
	public static final @NonNull EcoreTechnology INSTANCE = new EcoreTechnology();

	protected EcoreTechnology() {}

	@Override
	public  @NonNull IdResolver createIdResolver(@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new PivotIdResolver(environmentFactory);
	}

	@Override
	public RootPackageId getMetamodelId(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EPackage ePackage) {
		// assert !"http://www.eclipse.org/uml2/5.0.0/UML".equals(ePackage.getNsURI()); -- occurs for static profile
		// assert !"http://www.eclipse.org/uml2/5.0.0/Types".equals(ePackage.getNsURI());
		RootPackageId metamodel = null;
		if (ClassUtil.basicGetMetamodelAnnotation(ePackage) != null) {
			metamodel = IdManager.METAMODEL;
		}
		else {
			String nsURI = ePackage.getNsURI();
			String sharedNsURI = environmentFactory.getCompleteModel().getCompleteURI(nsURI);
			if ((sharedNsURI != null) && !sharedNsURI.equals(nsURI)) {
				metamodel = IdManager.getRootPackageId(sharedNsURI);
			}
		}
		return metamodel;
	}

	@Override
	public @NonNull PackageId getMetapackageId(@NonNull EnvironmentFactoryInternal environmentFactory, org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		if (asPackage instanceof PivotObjectImpl) {
			EObject eTarget = ((PivotObjectImpl)asPackage).getESObject();
			if (eTarget != null) {
				EClass eClass = eTarget.eClass();
				if (eClass != null) {
					EPackage ePackage = eClass.getEPackage();
					assert !"http://www.eclipse.org/uml2/5.0.0/UML".equals(ePackage.getNsURI());
					assert !"http://www.eclipse.org/uml2/5.0.0/Types".equals(ePackage.getNsURI());
				}
			}
		}
		return IdManager.METAMODEL;
	}

	@Override
	public boolean isStereotype(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EClass eClass) {
		for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
			if (eFeature instanceof EReference) {
				String name = eFeature.getName();
				if ((name != null) && name.startsWith("base_")) {
					EClassifier eType = eFeature.getEType();
					if (eType != null) {
						assert !eType.eIsProxy() : "Unresolved proxy: '" + EcoreUtil.getURI(eType) + "'";
						EPackage ePackage = eType.getEPackage();
						if ("http://www.eclipse.org/uml2/5.0.0/UML".equals(ePackage.getNsURI())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
