/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A Command to edit the Multiplicity of a MultiplicityElement. The expected value is a String
 * representing the Multiplicity.
 *
 * This command is a CompoundCommand, and relies on the Service Edit to retrieve the individual "set bounds" commands
 *
 * @author Camille Letavernier
 *
 * @see {@link MultiplicityParser}
 */
public class SetMultiplicityCommand extends CompoundCommand {

	/**
	 * Optimize lower/upper bounds, if they correspond to the default value
	 */
	private static final String OPTIMIZE_BOUNDS = "optimize bounds";

	private int[] lowerUpper;

	private MultiplicityElement element;

	static EStructuralFeature lowerFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Lower();

	static EStructuralFeature upperFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Upper();
	
	static EStructuralFeature lowerFeatureVS = UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue();

	static EStructuralFeature upperFeatureVS = UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue();

	public SetMultiplicityCommand(MultiplicityElement element, String value) {
		if (element == null) {
			return;
		}

		int[] lowerUpper = MultiplicityParser.getBounds(value);
		if (lowerUpper == null || lowerUpper.length < 2) {
			return;
		}

		int lower = lowerUpper[0];
		int upper = lowerUpper[1];

		if (!MultiplicityParser.isValidMultiplicity(lower, upper)) {
			return;
		}

		this.lowerUpper = lowerUpper;
		this.element = element;

		append(getSetCommand(lowerFeature, lower));
		append(getSetCommand(upperFeature, upper));
		append(getOptimizeCommand(lowerFeature, lowerFeatureVS));
		append(getOptimizeCommand(upperFeature, upperFeatureVS));
	}

	private Command getSetCommand(EStructuralFeature feature, int value) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
		if (provider != null) {
			SetRequest request = new SetRequest(element, feature, value);
			ICommand createGMFCommand = provider.getEditCommand(request);

			Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

			return emfCommand;
		}
		return null;
	}

	private Command getOptimizeCommand(EStructuralFeature feature, EStructuralFeature featureVS) {
		// can't use a SetRequest, since we need to evaluate the eIsSet after the first command has
		// been executed
		return new RecordingCommand(TransactionUtil.getEditingDomain(element), OPTIMIZE_BOUNDS) {

			@Override
			protected void doExecute() {
				if (!element.eIsSet(feature)) {
					// feature corresponds to default value, remove value specification
					// see bug 540815
					element.eSet(featureVS, null);
				}
			}
		};
	}

	@Override
	public boolean canExecute() {
		return element != null && lowerUpper != null && lowerUpper.length == 2 && super.canExecute();
	}

}
