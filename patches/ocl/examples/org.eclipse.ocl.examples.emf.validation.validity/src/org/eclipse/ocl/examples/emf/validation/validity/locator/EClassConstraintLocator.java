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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidityFactory;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;
import org.eclipse.ocl.examples.emf.validation.validity.plugin.ValidityPlugin;

public class EClassConstraintLocator extends AbstractConstraintLocator
{
	public static @NonNull EClassConstraintLocator INSTANCE = new EClassConstraintLocator();
	
	public @Nullable Map<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>> getConstraints(@NonNull ValidityModel validityModel,
			@NonNull EPackage ePackage, @NonNull Set<@NonNull Resource> resources, @NonNull Monitor monitor) {
		Map<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>> map = null;
		for (@SuppressWarnings("null")@NonNull EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (monitor.isCanceled()) {
				return null;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				List<LeafConstrainingNode> constraints = null;
				for (@SuppressWarnings("null")@NonNull EOperation eOperation : eClass.getEOperations()) {
					if (EcoreUtil.isInvariant(eOperation)) {
						LeafConstrainingNode constraint = ValidityFactory.eINSTANCE.createLeafConstrainingNode();
						constraint.setConstraintLocator(this);
						constraint.setConstrainingObject(eOperation);
						constraint.setLabel(validityModel.getConstrainingLabel(eOperation));
						if (constraints == null) {
							constraints = new ArrayList<LeafConstrainingNode>();
						}
						constraints.add(constraint);
					}
				}
				if (constraints != null) {
					if (map == null) {
						map = new HashMap<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>>();
					}
					map.put(eClass, constraints);
				}
			}
		}
		return map;
	}

	public Object getImage() {
		return ValidityPlugin.INSTANCE.getImage("EOperation.gif");
	}

	public @NonNull ConstraintLocator getInstance() {
		return INSTANCE;
	}

	public @NonNull String getName() {
		return "EClass invariants";
	}

	@Override
	public void validate(@NonNull Result result, @NonNull ValidityManager validityManager, @Nullable Monitor monitor) {
		super.validate(result, validityManager, monitor);
		EOperation eOperation = (EOperation) result.getLeafConstrainingNode().getConstrainingObject();
		EObject eObject = result.getValidatableNode().getConstrainedObject();
		if (eObject != null) {
			BasicDiagnostic diagnostic = validityManager.createDefaultDiagnostic(eObject);
			EList<Object> arguments = new BasicEList<Object>();
			arguments.add(diagnostic);
			arguments.add(validityManager.createDefaultContext());
			try {
				eObject.eInvoke(eOperation, arguments);
				result.setDiagnostic(diagnostic);
				result.setSeverity(getSeverity(diagnostic));
			} catch (InvocationTargetException e) {
				result.setException(e);
				result.setSeverity(Severity.FATAL);
			}
		}
	}
}