/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.xtext.completeocl.attributes.ClassifierContextCSAttribution;
import org.eclipse.ocl.xtext.completeocl.attributes.CompleteOCLDocumentCSAttribution;
import org.eclipse.ocl.xtext.completeocl.attributes.OperationContextCSAttribution;
import org.eclipse.ocl.xtext.completeocl.attributes.PackageDeclarationCSAttribution;
import org.eclipse.ocl.xtext.completeocl.attributes.PropertyContextCSAttribution;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;

public class CompleteOCLScoping
{
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(CompleteOCLCSPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS, ClassifierContextCSAttribution.INSTANCE);
		registry.put(CompleteOCLCSPackage.Literals.COMPLETE_OCL_DOCUMENT_CS, CompleteOCLDocumentCSAttribution.INSTANCE);
		registry.put(CompleteOCLCSPackage.Literals.OPERATION_CONTEXT_DECL_CS, OperationContextCSAttribution.INSTANCE);
		registry.put(CompleteOCLCSPackage.Literals.PACKAGE_DECLARATION_CS, PackageDeclarationCSAttribution.INSTANCE);
		registry.put(CompleteOCLCSPackage.Literals.PROPERTY_CONTEXT_DECL_CS, PropertyContextCSAttribution.INSTANCE);
	}
}
