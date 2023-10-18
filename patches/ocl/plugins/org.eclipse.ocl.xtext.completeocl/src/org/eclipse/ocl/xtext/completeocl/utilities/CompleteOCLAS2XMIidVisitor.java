/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

@SuppressWarnings("deprecation")
public class CompleteOCLAS2XMIidVisitor extends org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor
{
	public CompleteOCLAS2XMIidVisitor(org.eclipse.ocl.pivot.internal.utilities.@NonNull AS2XMIid context) {
		super(context);
	}

	private void appendDisambiguator(@NonNull NamedElement object) {
		EObject eContainer = object.eContainer();
		if (eContainer != null) {
			int index = 0;
			String objectName = object.getName();
			Object siblings = eContainer.eGet(object.eContainmentFeature());
			if (siblings instanceof List<?>) {
				for (Object sibling : (List<?>)siblings) {
					if (sibling == object) {
						break;
					}
					if (sibling instanceof NamedElement) {
						String siblingName = ((NamedElement)sibling).getName();
						if (ClassUtil.safeEquals(objectName, siblingName)) {
							index++;
						}
					}
				}
			}
			s.append("." + index);
		}
	}

	@Override
	public @Nullable Boolean visitClass(@NonNull Class object) {
		Boolean status = super.visitClass(object);
		if (status != Boolean.TRUE) {
			return status;
		}
		appendDisambiguator(object);
		return true;
	}

	@Override
	public @Nullable Boolean visitEnumeration(@NonNull Enumeration object) {
		Boolean status = super.visitEnumeration(object);
		if (status != Boolean.TRUE) {
			return status;
		}
		appendDisambiguator(object);
		return true;
	}

	@Override
	public @Nullable Boolean visitPrimitiveType(@NonNull PrimitiveType object) {
		Boolean status = super.visitPrimitiveType(object);
		if (status != Boolean.TRUE) {
			return status;
		}
		appendDisambiguator(object);
		return true;
	}

}
