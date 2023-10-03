/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - 402525
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.services.edit.ui.databinding.AggregatedPapyrusObservableValue;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.tools.databinding.CommandBasedObservableValue;
import org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable;
import org.eclipse.papyrus.uml.properties.databinding.helpers.UMLDatabindingHelper;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.commands.SetMultiplicityCommand;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An ObservableValue for manipulating the UML Multiplicity property.
 * Multiplicity is a simple, virtual property, aggregating both lowerBound and upperBound,
 * and presenting them as an Enumeration with 4 values : 1, 0-1, 0-*, 1-*
 *
 * The values are edited with commands executed on the given editing domain.
 * These commands will probably only work in a Papyrus context.
 *
 * @author Camille Letavernier
 * @since 3.3
 */
public class MultiplicityObservableValue extends ReferenceCountedObservable.Value implements IChangeListener, CommandBasedObservableValue, AggregatedObservable, IObserving {

	private IObservableValue lowerBound, upperBound, lowerValue, upperValue, lowerValueSpecification, upperValueSpecification;

	private EStructuralFeature lowerFeature, upperFeature;

	private EObject eObject;

	private EditingDomain domain;

	/**
	 * Constructor.
	 *
	 * @param eObject
	 *            The EObject which the multiplicity is being edited
	 * @param domain
	 *            The Editing Domain on which the commands will be executed
	 */
	public MultiplicityObservableValue(EObject eObject, EditingDomain domain) {
		this.eObject = eObject;
		this.domain = domain;

		lowerFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Lower();
		upperFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Upper();

		EStructuralFeature lowerValueFeature, upperValueFeature, lowerValueSpecificationFeature, upperValueSpecificationFeature;

		lowerValueFeature = UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue();
		upperValueFeature = UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue();
		lowerValueSpecificationFeature = UMLPackage.eINSTANCE.getLiteralInteger_Value();
		upperValueSpecificationFeature = UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value();

		lowerBound = UMLDatabindingHelper.getObservableValue(eObject, lowerFeature, domain);
		upperBound = UMLDatabindingHelper.getObservableValue(eObject, upperFeature, domain);

		lowerValue = UMLDatabindingHelper.getObservableValue(eObject, lowerValueFeature, domain);
		upperValue = UMLDatabindingHelper.getObservableValue(eObject, upperValueFeature, domain);

		lowerValueSpecification = getValueSpecification(lowerValue, lowerValueSpecificationFeature, domain);
		upperValueSpecification = getValueSpecification(upperValue, upperValueSpecificationFeature, domain);

		lowerValue.addChangeListener(this);
		upperValue.addChangeListener(this);

		if (lowerValueSpecification != null) {
			lowerValueSpecification.addChangeListener(this);
		}
		if (upperValueSpecification != null) {
			upperValueSpecification.addChangeListener(this);
		}
	}

	private IObservableValue getValueSpecification(IObservableValue source, EStructuralFeature specificationFeature, EditingDomain domain) {
		if (source.getValue() == null) {
			return null;
		}
		return UMLDatabindingHelper.getObservableValue((EObject) source.getValue(), specificationFeature, domain);

	}

	/**
	 * @see org.eclipse.core.databinding.observable.IChangeListener#handleChange(org.eclipse.core.databinding.observable.ChangeEvent)
	 *
	 * @param event
	 */
	@Override
	public void handleChange(ChangeEvent event) {
		boolean fireChange = false;
		if (event.getSource() == lowerValue || event.getSource() == upperValue) {
			fireChange = true;
			lowerValueSpecification = getValueSpecification(lowerValue, UMLPackage.eINSTANCE.getLiteralInteger_Value(), domain);
			upperValueSpecification = getValueSpecification(upperValue, UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value(), domain);
		}

		if (event.getSource() == lowerValueSpecification || event.getSource() == upperValueSpecification) {
			fireChange = true;
		}

		if (fireChange) {
			final Object value = getValue();
			fireValueChange(new ValueDiff() {

				@Override
				public Object getOldValue() {
					return null; // Unknown
				}

				@Override
				public Object getNewValue() {
					return value;
				}

			});
		}
	}

	@Override
	public Object getObserved() {
		return eObject;
	}

	@Override
	public synchronized void dispose() {
		lowerValue.removeChangeListener(this);
		upperValue.removeChangeListener(this);
		if (lowerValueSpecification != null) {
			lowerValueSpecification.removeChangeListener(this);
			lowerValueSpecification.dispose();
		}
		if (upperValueSpecification != null) {
			upperValueSpecification.removeChangeListener(this);
			upperValueSpecification.dispose();
		}

		lowerValue.dispose();
		upperValue.dispose();

		lowerBound.dispose();
		upperBound.dispose();

		super.dispose();
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

	@Override
	protected String doGetValue() {
		String result = null;
		if (eObject instanceof MultiplicityElement) {
			result = MultiplicityElementUtil.formatMultiplicityNoBrackets((MultiplicityElement) eObject);
		} else {
			int upper, lower;
			upper = lower = 0;

			Object lowerValue = lowerBound.getValue();
			Object upperValue = upperBound.getValue();
			lower = (Integer) lowerValue;
			upper = (Integer) upperValue;

			result = MultiplicityParser.getMultiplicity(lower, upper);
		}
		return result;
	}

	@Override
	protected void doSetValue(Object value) {
		Command command = getCommand(value);
		domain.getCommandStack().execute(command);
	}

	@Override
	public Command getCommand(Object value) {
		String val = (String) value;

		int[] lowerUpper = MultiplicityParser.getBounds(val);
		if (lowerUpper == null || lowerUpper.length < 2) {
			return UnexecutableCommand.INSTANCE; // Invalid multiplicity
		}

		int lower = lowerUpper[0], upper = lowerUpper[1];
		if (MultiplicityParser.isValidMultiplicity(lower, upper)) {
			try {
				return new SetMultiplicityCommand((MultiplicityElement) eObject, val);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		return UnexecutableCommand.INSTANCE;
	}

	@Override
	public AggregatedObservable aggregate(IObservable observable) {
		try {
			return new AggregatedPapyrusObservableValue(domain, this, observable);
		} catch (IllegalArgumentException ex) {
			return null; // The observable cannot be aggregated
		}
	}

	@Override
	public boolean hasDifferentValues() {
		return false;
	}

}
