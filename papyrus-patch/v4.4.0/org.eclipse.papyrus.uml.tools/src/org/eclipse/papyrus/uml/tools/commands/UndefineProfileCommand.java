/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gabriel Pascual  (ALL4TEC) gabriel.pascual@all4tec.net  - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.commands;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.tools.profile.definition.IPapyrusVersionConstants;
import org.eclipse.papyrus.uml.tools.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Removed all Profile Definitions of all Profile model.
 *
 * @author Gabriel Pascual
 * @since 4.1
 *
 */
public class UndefineProfileCommand extends RecordingCommand {

	/** The Constant COMMAND_TITLE. */
	private static final String COMMAND_TITLE = "Undefine Profile"; //$NON-NLS-1$

	/** The profile definition. */
	private final PapyrusDefinitionAnnotation profileDefinition;

	/** The profiles stack. */
	private final Deque<Profile> profilesStack;

	/** The root profile. */
	private final Profile rootProfile;

	/**
	 * Instantiates a new undefine profile command.
	 *
	 * @param editingDomain
	 *            the editing domain
	 * @param annotation
	 *            the annotation
	 * @param rootProfile
	 *            the root profile
	 */
	public UndefineProfileCommand(final TransactionalEditingDomain editingDomain, final PapyrusDefinitionAnnotation annotation, final Profile rootProfile) {
		super(editingDomain, COMMAND_TITLE, null);
		this.rootProfile = rootProfile;
		this.profileDefinition = annotation;
		profilesStack = new LinkedList<>(Collections.singleton(rootProfile));
	}

	/**
	 * Do execute.
	 *
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		EPackage umlDefinition = rootProfile.getDefinition();

		while (!profilesStack.isEmpty()) {
			handleProfile(profilesStack.pop());
		}

		handleRemovedProfileDefinition(umlDefinition);


	}

	/**
	 * Handle removed profile definition.
	 *
	 * @param umlDefinition
	 *            the uml definition
	 */
	private void handleRemovedProfileDefinition(final EPackage umlDefinition) {

		// Retrieve current Papyrus Version
		PapyrusDefinitionAnnotation currentDefinition = null;

		if (null != umlDefinition) {
			currentDefinition = PapyrusDefinitionAnnotation.parseEAnnotation(umlDefinition.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE));
		}

		if (null != currentDefinition && profileDefinition.equals(currentDefinition)) {

			// Add UNDEFINED ANNOTATION to Profile
			EAnnotation umlAnnotation = rootProfile.getEAnnotation(UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI);
			if (null != umlAnnotation && null == umlAnnotation.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE)) {
				umlAnnotation.getEAnnotations().add(PapyrusDefinitionAnnotation.UNDEFINED_ANNOTATION.convertToEAnnotation());
			}

		}


	}

	/**
	 * Handle profile.
	 *
	 * @param profile
	 *            the profile
	 */
	private void handleProfile(final Profile profile) {

		EAnnotation umlAnnotation = profile.getEAnnotation(UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI);

		EPackage profileDefinition = retrieveProfileDefinition(umlAnnotation);

		if (null != profileDefinition) {
			umlAnnotation.getContents().remove(profileDefinition);
		}

		pileUpNestedProfiles(profile);

	}

	/**
	 * Retrieve profile definition.
	 *
	 * @param umlAnnotation
	 *            the uml annotation
	 * @return the e package
	 */
	private EPackage retrieveProfileDefinition(final EAnnotation umlAnnotation) {
		Collection<EPackage> packageAnnotations = EcoreUtil.<EPackage> getObjectsByType(umlAnnotation.getContents(), EcorePackage.Literals.EPACKAGE);
		Iterator<EPackage> definitionsIterator = packageAnnotations.iterator();
		EPackage packageDefinition = null;
		boolean found = false;

		while (!found && definitionsIterator.hasNext()) {
			packageDefinition = definitionsIterator.next();

			PapyrusDefinitionAnnotation currentDefinition = getPapyrusDefinitionAnnotation(packageDefinition);
			found = profileDefinition.equals(currentDefinition);
		}

		return found ? packageDefinition : null;
	}

	/**
	 * Gets the papyrus definition annotation.
	 *
	 * @param profileDefinition
	 *            the profile definition
	 * @return the papyrus definition annotation
	 */
	private PapyrusDefinitionAnnotation getPapyrusDefinitionAnnotation(final EPackage profileDefinition) {
		PapyrusDefinitionAnnotation currentDefinition = null;

		EAnnotation profileVersion = profileDefinition.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
		if (null != profileDefinition) {
			currentDefinition = PapyrusDefinitionAnnotation.parseEAnnotation(profileVersion);
		}

		return currentDefinition;
	}



	/**
	 * Pile up nested profiles.
	 *
	 * @param profile
	 *            the profile
	 */
	private void pileUpNestedProfiles(final Profile profile) {
		Collection<Profile> owningProfiles = EcoreUtil.<Profile> getObjectsByType(profile.getNestedPackages(), UMLPackage.Literals.PROFILE);
		for (Profile owningProfile : owningProfiles) {
			profilesStack.addLast(owningProfile);
		}
	}
}
