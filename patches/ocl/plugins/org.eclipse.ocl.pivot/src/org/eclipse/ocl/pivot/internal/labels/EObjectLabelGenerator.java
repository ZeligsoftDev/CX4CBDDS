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
package org.eclipse.ocl.pivot.internal.labels;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

public final class EObjectLabelGenerator extends AbstractLabelGenerator<EObject>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(EObject.class, new EObjectLabelGenerator());		
	}
	
	public EObjectLabelGenerator() {
		super(EObject.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull EObject object) {
		if (object.eIsProxy()) {
			labelBuilder.appendObject(EcoreUtil.getURI(object));
			return;
		}
		if (!labelBuilder.hasOption(Builder.SHOW_QUALIFIER))	{		// Legacy behavior
			if (object.eContainer() != null) {
				labelBuilder.appendObject(object.eContainer());
				labelBuilder.appendString("/");
			}
		}
		EClass eClass = object.eClass();
		EAttribute eidAttribute = eClass.getEIDAttribute();
		if (eidAttribute != null) {
			labelBuilder.appendString(String.valueOf(object.eGet(eidAttribute)));
			return;
		}
/*		List<EAttribute> eAttributes = eClass.getEAttributes();
		if (eAttributes.size() > 0) {
			EAttribute eAttribute = eAttributes.get(0);
			if (eAttribute != null) {
				labelBuilder.appendString(eClass.getName());
				labelBuilder.appendString(" ");
				labelBuilder.appendString(String.valueOf(object.eGet(eAttribute)));
				return;
			}
		} */
//		labelBuilder.appendString("<");
		labelBuilder.appendString(eClass.getName());
//		labelBuilder.appendString(">");
	}
}