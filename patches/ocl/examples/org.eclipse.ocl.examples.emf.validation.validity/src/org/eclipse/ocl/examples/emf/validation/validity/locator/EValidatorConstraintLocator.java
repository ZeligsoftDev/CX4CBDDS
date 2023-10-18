/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *  Obeo - Manage the Navigation from the ValidityView -> to the Editor
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.locator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;
import org.eclipse.ocl.examples.emf.validation.validity.plugin.ValidityPlugin;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;

public class EValidatorConstraintLocator extends AbstractConstraintLocator
{
	public static @NonNull EValidatorConstraintLocator INSTANCE = new EValidatorConstraintLocator();
	
	public @Nullable Map<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>> getConstraints(@NonNull ValidityModel validityModel,
			@NonNull EPackage ePackage, @NonNull Set<@NonNull Resource> resources, @NonNull Monitor monitor) {
		Map<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>> map = null;
		Object object = EValidator.Registry.INSTANCE.get(ePackage);
		if (object instanceof EValidator) {
			map = getConstraints(map, validityModel, ePackage, (EValidator) object, monitor);
		}
		if ((map != null) && !monitor.isCanceled()) {
			//
			//	Prune unnamed constraints that have named constraints to delegate to
			//
			for (EObject eClassifier : map.keySet()) {
				if (monitor.isCanceled()) {
					return null;
				}
				List<LeafConstrainingNode> oldList = map.get(eClassifier);
				assert oldList != null;
				if (oldList.size() > 1) {
					ArrayList<LeafConstrainingNode> newList = new ArrayList<LeafConstrainingNode>(oldList);
					for (LeafConstrainingNode constraint : newList) {
						if ("".equals(constraint.getLabel())) {
							oldList.remove(constraint);
						}
					}
				}
			}
		}
//		if (map != null) {
//			String s = print(map);
//			System.out.println("EValidator '" + ePackage.getNsURI() + "'\n" + s);
//		}
		return map;
	}

	protected @Nullable Map<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>> getConstraints(@Nullable Map<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>> map,
			@NonNull ValidityModel validityModel, @NonNull EPackage ePackage, @NonNull EValidator eValidator, @NonNull Monitor monitor) {
		if (eValidator instanceof ComposedEValidator) {
			for (@SuppressWarnings("null")@NonNull EValidator child : ((ComposedEValidator) eValidator).getChildren()) {
				map = getConstraints(map, validityModel, ePackage, child, monitor);
			}
			return map;
		}
//		Map<String, EClassifier> name2eClassifier = new HashMap<String, EClassifier>();
		Map<@NonNull Class<?>, @NonNull List<@NonNull EClassifier>> javaClass2eClassifiers = new HashMap<@NonNull Class<?>, @NonNull List<@NonNull EClassifier>>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (monitor.isCanceled()) {
				return null;
			}
//			name2eClassifier.put(eClassifier.getName(), eClassifier);
			Class<?> javaClass = eClassifier.getInstanceClass();
			if (javaClass != null) {
				List<@NonNull EClassifier> eClassifiers = javaClass2eClassifiers.get(javaClass);
				if (eClassifiers == null) {
					eClassifiers = new ArrayList<@NonNull EClassifier>();
					javaClass2eClassifiers.put(javaClass, eClassifiers);
				}
				eClassifiers.add(eClassifier);
			}
		}
		for (Method method : eValidator.getClass().getDeclaredMethods()) {
			if (monitor.isCanceled()) {
				return null;
			}
			Class<?>[] parameterTypes = method.getParameterTypes();
			if (Modifier.isPublic(method.getModifiers())
			 && (parameterTypes.length == 3)
			 && (DiagnosticChain.class == parameterTypes[1])
			 && (Map.class == parameterTypes[2])) {
				String name = method.getName();
				List<@NonNull EClassifier> eClassifiers = javaClass2eClassifiers.get(parameterTypes[0]);
				if (eClassifiers != null) {
					for (@NonNull EClassifier eClassifier : eClassifiers) {
						String eClassifierName = eClassifier.getName();
						int index = name.indexOf(eClassifierName);
						if (index > 0) {
							int nameLength = name.length();
							int eClassifierNameLength = eClassifierName.length();
							int separatorIndex = index + eClassifierNameLength;
							String constraintName = null;
							if ((separatorIndex + 1 < nameLength) && ('_' == name.charAt(separatorIndex))) {
								constraintName = name.substring(separatorIndex + 1);
							}
							else if ((separatorIndex == nameLength) && !(eClassifier instanceof EClass))  {
								constraintName = "<datatype>";
							}
							if (constraintName != null) {
								map = createLeafConstrainingNode(map, validityModel, eClassifier, method, constraintName);
							}
						}
					}
				}
			}
		}
		return map;
	}

	public Object getImage() {
		return ValidityPlugin.INSTANCE.getImage("methpub_obj.gif");
	}

	@Override
	public @NonNull ConstraintLocator getInstance() {
		return INSTANCE;
	}

	public @NonNull String getName() {
		return "Java validateXXXX methods";
	}

	@Override
	public @Nullable String getSourceExpression(@NonNull LeafConstrainingNode node) {
		Object constrainingObject = node.getConstrainingObject();
		if (!(constrainingObject instanceof Method)) {
			return null;
		}
		return ((Method)constrainingObject).toString();
	}

	protected @NonNull String print(@NonNull Map<EClassifier, @NonNull List<LeafConstrainingNode>> map) {
		StringBuilder s = new StringBuilder();
		ArrayList<EClassifier> sortedList = new ArrayList<EClassifier>(map.keySet());
		Collections.sort(sortedList, new Comparator<EClassifier>()
		{
			public int compare(EClassifier o1, EClassifier o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (EClassifier eClassifier : sortedList) {
			s.append("\t" + eClassifier.getName() + ":");
			List<LeafConstrainingNode> constraints = map.get(eClassifier);
			assert constraints != null;
			for (LeafConstrainingNode constraint : constraints) {
				s.append(" \'" + constraint.getLabel() + "'");
			}
			s.append("\n");
		}
		return s.toString();
	}

	@Override
	public void validate(@NonNull Result result, @NonNull ValidityManager validityManager, @Nullable Monitor monitor) {
		Method method = (Method) result.getLeafConstrainingNode().getConstrainingObject();
		EObject eObject = result.getValidatableNode().getConstrainedObject();
		if (eObject != null) {
			BasicDiagnostic diagnostic = validityManager.createDefaultDiagnostic(eObject);
			try {
				Class<?> declaringClass = method.getDeclaringClass();
				Object eValidator;
				try {
					Field field = declaringClass.getField("INSTANCE");
					eValidator = field.get(null);
				}
				catch (Exception e) {
					eValidator = declaringClass.newInstance();
				}
				method.invoke(eValidator, eObject, diagnostic, validityManager.createDefaultContext());
				result.setDiagnostic(diagnostic);
				result.setSeverity(getSeverity(diagnostic));
			} catch (Exception e) {
				result.setException(e);
				result.setSeverity(Severity.FATAL);
			}
		}
	}
}