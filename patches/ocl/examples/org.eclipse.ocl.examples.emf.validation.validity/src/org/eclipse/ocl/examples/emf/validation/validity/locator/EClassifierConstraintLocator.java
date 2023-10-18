/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.locator;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
//import org.eclipse.ocl.common.OCLCommon;
//import org.eclipse.ocl.pivot.Constraint;
//import org.eclipse.ocl.pivot.PivotConstants;
//import org.eclipse.ocl.pivot.PivotFactory;
//import org.eclipse.ocl.pivot.UMLReflection;
//import org.eclipse.ocl.pivot.manager.MetamodelManager;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;

public class EClassifierConstraintLocator extends AbstractConstraintLocator
{
	public static @NonNull EClassifierConstraintLocator INSTANCE = new EClassifierConstraintLocator();
	
	public @Nullable Map<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>> getConstraints(@NonNull ValidityModel validityModel,
			@NonNull EPackage ePackage, @NonNull Set<@NonNull Resource> resources, @NonNull Monitor monitor) {
/*		EClassifier eClassifier = (EClassifier) eObject;
		List<Constraint> constraints = null;
		EAnnotation oclAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
		if (oclAnnotation != null) {
			EMap<String, String> oclAnnotationDetails = oclAnnotation.getDetails();
			int iMax = oclAnnotationDetails.size();
			for (int i = 0; i < iMax; i++) {
				if (monitor.isCanceled()) {
					return null;
				}
				Map.Entry<String,String> entry = oclAnnotationDetails.get(i);
				String constraintName = entry.getKey();
				if (constraintName == null) {
					constraintName = "";
				}
				if (!constraintName.endsWith(PivotConstants.MESSAGE_ANNOTATION_DETAIL_SUFFIX)) {
					Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
					constraint.setStereotype(UMLReflection.INVARIANT);
					constraint.setName(constraintName);
					String value = entry.getValue();
//						OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();	// FIXME ExpressionInOCL
//						specification.getBody().add(value);
//						specification.getLanguage().add(PivotConstants.OCL_LANGUAGE);
//						String message = oclAnnotationDetails.get(constraintName + PivotConstants.MESSAGE_ANNOTATION_DETAIL_SUFFIX);
//						specification.getMessage().add(message != null ? message : "");
//						constraint.setSpecification(specification);
					if (constraints == null) {
						constraints = new ArrayList<Constraint>();
					}
					constraints.add(constraint);
				}
			}				
		}
		return constraints; */
		return null;
	}		

	@Override
	public @NonNull ConstraintLocator getInstance() {
		return INSTANCE;
	}

	public @NonNull String getName() {
		return "EClassifier invariants";
	}
}