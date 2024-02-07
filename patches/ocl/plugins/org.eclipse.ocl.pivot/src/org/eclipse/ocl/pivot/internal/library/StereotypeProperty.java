/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * An instance of StereotypeProperty supports evaluation of a property call that accesses a stereotype extension property.
 */
public class StereotypeProperty extends ConstrainedProperty
{
	public StereotypeProperty(@NonNull Property property) {
		super(property);
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		IdResolver idResolver = executor.getIdResolver();
		EObject eObject = asNavigableObject(sourceValue, property, executor);
		Object boxedValue = null;
		if (eObject instanceof ElementExtension) {
			ElementExtension elementExtension = (ElementExtension)eObject;
			String propertyName = property.getName();
			Property extensionProperty = NameUtil.getNameable(elementExtension.getOwnedProperties(), propertyName);
			if (extensionProperty == null) {
				boolean gotIt = false;
				Object defaultValue = null;
				LanguageExpression defaultExpression = null;
				if (elementExtension.isIsApplied()) {
					EObject umlStereotypeApplication = elementExtension.getESObject();
					if (umlStereotypeApplication != null) {
						EClass eClass = umlStereotypeApplication.eClass();
						EStructuralFeature eStructuralFeature = NameUtil.getENamedElement(eClass.getEAllStructuralFeatures(), propertyName);
						if (eStructuralFeature != null) {
							defaultValue = idResolver.boxedValueOf(umlStereotypeApplication.eGet(eStructuralFeature));
							gotIt = true;
						}
					}
				}
				if (!gotIt && (elementExtension.isIsApplied() || elementExtension.isIsRequired())) {
					Property theProperty = NameUtil.getNameable(elementExtension.getStereotype().getOwnedProperties(), propertyName);
					defaultValue = theProperty != null ? theProperty.getDefaultValue() : null;
					defaultExpression = theProperty != null ? theProperty.getOwnedExpression() : null;
					gotIt = true;
				}
				extensionProperty = PivotFactory.eINSTANCE.createProperty();
				extensionProperty.setName(propertyName);
				extensionProperty.setIsRequired(property.isIsRequired());
				extensionProperty.setIsStatic(property.isIsStatic());
				extensionProperty.setType(property.getType());
				extensionProperty.setDefaultValue(defaultValue);
				extensionProperty.setOwnedExpression(defaultExpression);
				elementExtension.getOwnedProperties().add(extensionProperty);
			}
			/*			Property extensionProperty = ClassUtil.getNamedElement(elementExtension.getOwnedAttribute(), propertyName);
			if (extensionProperty == null) {
				boolean gotIt = false;
				EObject umlStereotypeApplication = elementExtension.getETarget();
				if (umlStereotypeApplication != null) {
					EClass eClass = umlStereotypeApplication.eClass();
					EStructuralFeature eStructuralFeature = EcoreUtils.getNamedElement(eClass.getEAllStructuralFeatures(), propertyName);
					if (eStructuralFeature != null) {
						Object value = umlStereotypeApplication.eGet(eStructuralFeature);
						gotIt = true;
					}
				}
				if (!gotIt && )
					if (elementExtension.isApplied() && !elementExtension.isRequired()) {
						return null;
					}
			} */
			//			Property theProperty = ClassUtil.getNamedElement(elementExtension.getStereotype().getOwnedAttribute(), property.getName());
			//			if (theProperty == null) {
			//				return super.evaluate(executor, returnTypeId, sourceValue);
			//			}
			Object defaultValue = extensionProperty.getDefaultValue();
			LanguageExpression defaultExpression = extensionProperty.getOwnedExpression();
			if (!extensionProperty.isIsDerived()) {
				boxedValue = defaultValue; //idResolver.createInstance(property.getTypeId(), defaultValueLiteral);
			}
			else if (defaultExpression != null) {
				String body = defaultExpression.getBody();
				if (body != null) {
					try {
						EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension) executor.getEnvironmentFactory();
						ExpressionInOCL expr = environmentFactory.parseSpecification(defaultExpression);
						OCLExpression bodyExpression = expr.getOwnedBody();
						if (bodyExpression != null) {
							boxedValue = executor.evaluate(bodyExpression);		// FIXME errors
						}
					} catch (ParserException e) {
						throw new InvalidValueException(e, "Bad defaultExpression for '{0}'", property);
					}
				}
			}
		}
		else {
			EClass eClass = eObject.eClass();
			EStructuralFeature eFeature = NameUtil.getENamedElement(eClass.getEAllStructuralFeatures(), property.getName());
			if (eFeature != null) {
				Object value = eObject.eGet(eFeature);
				boxedValue = value != null ? idResolver.boxedValueOf(value, eFeature, returnTypeId) : null;
			}
		}
		return boxedValue;
	}
}