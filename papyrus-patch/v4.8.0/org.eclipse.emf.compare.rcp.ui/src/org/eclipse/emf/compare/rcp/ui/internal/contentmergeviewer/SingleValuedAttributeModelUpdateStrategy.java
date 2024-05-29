/*******************************************************************************
 * Copyright (c) 2015 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Philip Langer - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.internal.utils.ComparisonUtil;
import org.eclipse.emf.compare.rcp.ui.internal.util.MergeViewerUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;

/**
 * A {@link IModelUpdateStrategy} for single-valued {@link EAttribute EAttributes}.
 * <p>
 * This strategy is tolerant in the sense that it will not throw exceptions if the input is not a supported
 * {@link AttributeChange}. In this case, this strategy will return <code>false</code> on
 * {@link #canUpdate(Diff, MergeViewerSide)} and return a command on
 * {@link #getModelUpdateCommand(Diff, Object, MergeViewerSide)} that specifies false on
 * {@link Command#canExecute()}. Therefore, it can be used as default strategy.
 * </p>
 * 
 * @author Philip Langer <planger@eclipsesource.com>
 */
public class SingleValuedAttributeModelUpdateStrategy implements IModelUpdateStrategy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see IModelUpdateStrategy#canUpdate(Diff, MergeViewerSide)
	 */
	public boolean canUpdate(Diff diff, MergeViewerSide side) {
		return isSingleValuedAttributeChange(diff) && haveTargetObject(diff, side);
	}

	/**
	 * Specifies whether the given {@code diff} is an {@link AttributeChange} of a single-valued attribute.
	 * 
	 * @param diff
	 *            The diff to check.
	 * @return <code>true</code> if it is a change of a single-valued attribute, <code>false</code> otherwise.
	 */
	private boolean isSingleValuedAttributeChange(Diff diff) {
		return diff instanceof AttributeChange && !((AttributeChange)diff).getAttribute().isMany();
	}

	/**
	 * Specifies whether we have a target object based on the {@link Diff#getMatch() match} of the given
	 * {@code diff} on the given {@code side}.
	 * 
	 * @param diff
	 *            The diff to check.
	 * @param side
	 *            The side to check on.
	 * @return <code>true</code> if we have a target object, <code>false</code> otherwise.
	 */
	private boolean haveTargetObject(Diff diff, MergeViewerSide side) {
		return getTargetObject(diff, side) != null;
	}

	/**
	 * Returns the target object for the {@link Diff#getMatch() match} of the given {@code diff} on the given
	 * {@code side}.
	 * 
	 * @param diff
	 *            The diff to get the target object for.
	 * @param side
	 *            The side to get the target object from.
	 * @return The target object.
	 */
	private EObject getTargetObject(Diff diff, MergeViewerSide side) {
		return MergeViewerUtil.getEObject(diff.getMatch(), side);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see IModelUpdateStrategy#getModelUpdateCommand(Diff, Object, MergeViewerSide)
	 */
	public Command getModelUpdateCommand(final Diff diff, final Object newValue, final MergeViewerSide side) {
		final EObject targetObject = getTargetObject(diff, side);
		return new ChangeCommand(targetObject) {
			@Override
			public boolean canExecute() {
				return canUpdate(diff, side) && needsUpdate(diff, newValue, side) && super.canExecute();
			}

			@Override
			protected void doExecute() {
				final EAttribute eAttribute = ((AttributeChange)diff).getAttribute();
				targetObject.eSet(eAttribute, newValue);
			}
		};
	}

	/**
	 * Specifies whether the value in the model needs to be updated with the given {@code newValue} on the
	 * given {@code side}.
	 * 
	 * @param diff
	 *            The diff acting as context of the potential model update.
	 * @param newValue
	 *            The potentially changed new value to be checked against.
	 * @param side
	 *            The side to check.
	 * @return <code>true</code> if an update is necessary, <code>false</code> otherwise.
	 */
	private boolean needsUpdate(Diff diff, Object newValue, MergeViewerSide side) {
		final IEqualityHelper equalityHelper = ComparisonUtil.getComparison(diff).getEqualityHelper();
		final EObject eObject = getTargetObject(diff, side);
		final EAttribute eAttribute = ((AttributeChange)diff).getAttribute();
		final Object oldValue = getStringValue(eObject, eAttribute);
		return !equalityHelper.matchingAttributeValues(newValue, oldValue);
	}

	/**
	 * Returns the value as String of the given {@code eAttribute} in the given {@code eObject}.
	 * 
	 * @param eObject
	 *            The EObject containing the attribute value.
	 * @param eAttribute
	 *            The EAttribute to get its value.
	 * @return The String representation of the value.
	 */
	private String getStringValue(final EObject eObject, final EAttribute eAttribute) {
		final EDataType eAttributeType = eAttribute.getEAttributeType();
		final Object value;
		if (eObject == null) {
			value = null;
		} else {
			value = ReferenceUtil.safeEGet(eObject, eAttribute);
		}
		return EcoreUtil.convertToString(eAttributeType, value);
	}

}
