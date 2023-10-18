/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.stepper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.as2cs.BaseLocationInFileProvider;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.ITextRegion;

public abstract class AbstractStepper implements IStepper
{
	@Deprecated		// use AS Elements and locationInFileProvider
	public static @NonNull UnitLocation createUnitLocation(@NonNull VMEvaluationEnvironment evalEnv, @NonNull Element element, @Nullable INode startNode, @Nullable INode endNode) {
		int startPosition = startNode != null ? startNode.getOffset() : 0;
		int endPosition = endNode != null ? ElementUtil.getEndOffset(endNode) : 0;
		return new UnitLocation(startPosition, endPosition, evalEnv, element);
	}

	public @NonNull UnitLocation createUnitLocation(@NonNull VMEvaluationEnvironment evalEnv, @NonNull Element element) {
		BaseLocationInFileProvider locationInFileProvider = evalEnv.getDebugCore().getLocationInFileProvider();
		ITextRegion significantTextRegion = locationInFileProvider.getSignificantTextRegion(element);
		int startPosition = significantTextRegion.getOffset();
		int endPosition = startPosition + significantTextRegion.getLength();
		return new UnitLocation(startPosition, endPosition, evalEnv, element);
//		INode node = null;
//		ModelElementCS csElement = getCsElement(element);
//		if (csElement != null) {
//			node = NodeModelUtils.getNode(csElement);
//		}
//		return createUnitLocation(evalEnv, element, node, node);
	}

	/**
	 * Return the CS element for asElement if it exists, or the nearest ancestor of asElement otherwise.
	 */
	protected @Nullable ModelElementCS getCsElement(@NonNull Element asElement) {
		while (true) {
			ModelElementCS csStartElement = ElementUtil.getCsElement(asElement);
			if (csStartElement != null) {
				return csStartElement;
			}
			EObject eContainer = asElement.eContainer();
			if (eContainer instanceof Element) {
				asElement = (Element)eContainer;
			}
			else {
				return null;
			}
		}
	}

	// FIXME Promote to IStepper once API change acceptable
	public @Nullable Element getFirstElement(@NonNull Element element) {
		return null;
	}

	public @Nullable Element getFirstElement(@NonNull VMEvaluationStepper vmEvaluationVisitor, @Nullable Element element) {
		if (element != null) {
			IStepperVisitor stepperVisitor = vmEvaluationVisitor.getStepperVisitor();
			if (stepperVisitor instanceof OCLStepperVisitor) {
				OCLStepperVisitor oclStepperVisitor = (OCLStepperVisitor)stepperVisitor;
				while (true) {
					assert element != null;
					IStepper nextStepper = oclStepperVisitor.getStepper(element);
					if (!(nextStepper instanceof AbstractStepper)) {
						break;
					}
					Element firstElement = ((AbstractStepper)nextStepper).getFirstElement(element);
					if (firstElement == null) {
						break;
					}
					element = firstElement;
				}
			}
		}
		return element;
	}

	@Override
	public @Nullable Element isPostStoppable(@NonNull VMEvaluationStepper rootVMEvaluationVisitor, @NonNull Element childElement, @Nullable Object result) {
		EObject parentElement = childElement.eContainer();
		return parentElement instanceof Element ? (Element)parentElement : null;
	}

	@Override
	public boolean isPreStoppable(@NonNull VMEvaluationStepper rootVMEvaluationVisitor, @NonNull Element element) {
		return false;
	}
}
