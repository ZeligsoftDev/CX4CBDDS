/*
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.internal.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * An instance of InstanceSlotNavigationProperty supports evaluation of
 * a property call that navigates a relationship to a UML InstanceSpecification slot.
 */
public class InstanceSlotNavigationProperty extends AbstractProperty
{
	protected final org.eclipse.uml2.uml.@NonNull Property property;
	protected final @Nullable CollectionTypeId collectionTypeId;				// Non null for a Collection value

	public InstanceSlotNavigationProperty(org.eclipse.uml2.uml.@NonNull Property property, @Nullable CollectionTypeId collectionTypeId) {
		this.property = property;
		this.collectionTypeId = collectionTypeId;
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		if (sourceValue != null) {
			InstanceSpecification instanceSpecification = (InstanceSpecification)sourceValue;
			for (Slot slot : instanceSpecification.getSlots()) {
				if (slot.getDefiningFeature() == property) {
					List<ValueSpecification> values = slot.getValues();
					CollectionTypeId collectionTypeId2 = collectionTypeId;
					int size = values.size();
					if (collectionTypeId2 != null) {
						List<Object> unboxedValues = new ArrayList<Object>(size);
						for (ValueSpecification value : values) {
							unboxedValues.add(valueOf(executor, value));
						}
						IdResolver idResolver = executor.getIdResolver();
						return idResolver.createCollectionOfAll(collectionTypeId2, unboxedValues);
					}
					else if (size >= 1) {
						ValueSpecification valueSpecification = values.get(0);
						if (valueSpecification instanceof OpaqueExpression) {
							try {
								EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension) executor.getEnvironmentFactory();
								ExpressionInOCL specification = environmentFactory.getASOf(ExpressionInOCL.class, valueSpecification);
								if (specification == null) {
									throw new InvalidValueException("Missing spec for " + specification);
								}
								ExpressionInOCL query = environmentFactory.parseSpecification(specification);
								OCLExpression bodyExpression = query.getOwnedBody();
								assert bodyExpression != null;
								Object umlValue = executor.evaluate(bodyExpression);
								return environmentFactory.getIdResolver().boxedValueOf(umlValue);
							} catch (ParserException e) {
								throw new InvalidValueException(e, "Parse fail for " + valueSpecification);
							}
						}
						else {
							return valueOf(executor, valueSpecification);
						}
					}
					else {
						throw new InvalidValueException("no ValueSpecification in Slot");
					}
				}
			}
		}
		return null;
	}

	private @Nullable Object valueOf(@NonNull Executor executor, @Nullable ValueSpecification valueSpecification) {
		if (valueSpecification == null) {
			throw new InvalidValueException("null ValueSpecification in Slot");
		}
		if (valueSpecification instanceof LiteralBoolean) {
			return ((LiteralBoolean)valueSpecification).booleanValue();
		}
		if (valueSpecification instanceof LiteralInteger) {
			return ValueUtil.integerValueOf(((LiteralInteger)valueSpecification).getValue());
		}
		if (valueSpecification instanceof LiteralNull) {
			return null;
		}
		if (valueSpecification instanceof LiteralReal) {
			return ValueUtil.realValueOf(((LiteralReal)valueSpecification).getValue());
		}
		if (valueSpecification instanceof LiteralString) {
			return ((LiteralString)valueSpecification).getValue();
		}
		if (valueSpecification instanceof LiteralUnlimitedNatural) {
			int unlimitedValue = ((LiteralUnlimitedNatural)valueSpecification).unlimitedValue();
			return unlimitedValue < 0 ? ValueUtil.UNLIMITED_VALUE : ValueUtil.integerValueOf(unlimitedValue);
		}
		if (valueSpecification instanceof InstanceValue) {
			InstanceSpecification ecoreInstance = ((InstanceValue)valueSpecification).getInstance();
			return ecoreInstance != null ? executor.getIdResolver().boxedValueOf(ecoreInstance) : null;
		}
		throw new UnsupportedOperationException(getClass().getSimpleName() + ".valueOf " + valueSpecification.eClass().getName());
	}
}