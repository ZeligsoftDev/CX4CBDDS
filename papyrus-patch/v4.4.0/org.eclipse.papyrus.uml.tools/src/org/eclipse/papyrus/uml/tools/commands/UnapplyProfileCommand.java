/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * A command to unapply a profile on a UML Package
 *
 * @author Camille Letavernier
 */
public class UnapplyProfileCommand extends RecordingCommand {

	private Package umlPackage;

	private Collection<Profile> profiles;

	/**
	 *
	 * Constructor.
	 *
	 * @param umlPackage
	 *            The UML Package from which the profiles will be unapplied
	 * @param profiles
	 *            The list of profiles to unapply
	 * @param domain
	 *            The EditingDomain
	 */
	public UnapplyProfileCommand(Package umlPackage, Collection<Profile> profiles, TransactionalEditingDomain domain) {
		super(domain);
		this.umlPackage = umlPackage;
		this.profiles = profiles;
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param umlPackage
	 *            The UML Package from which the profile will be unapplied
	 * @param profile
	 *            The profile to unapply
	 * @param domain
	 *            The EditingDomain
	 */
	public UnapplyProfileCommand(Package umlPackage, Profile profile, TransactionalEditingDomain domain) {
		super(domain);
		this.umlPackage = umlPackage;
		this.profiles = Collections.singletonList(profile);
	}

	@Override
	protected void doExecute() {
		for (Profile profile : profiles) {
			umlPackage.unapplyProfile(profile);
		}
	}
}
