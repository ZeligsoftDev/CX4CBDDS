/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.profile.definition;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

/**
 * Class that defines various information about a profile definition (author,
 * version, etc.)
 */
public class PapyrusDefinitionAnnotation {

	/** version of the definition */
	private Version version = Version.emptyVersion;

	/** Comment of the definition */
	private String comment = "";

	/** Copyright of the definition */
	private String copyright = "";

	/** date of the definition */
	private String date = "";

	/** author of the definition */
	private String author = "";

	/** undefined PapyrusDefinitionAnnotation */
	public static PapyrusDefinitionAnnotation UNDEFINED_ANNOTATION = new PapyrusDefinitionAnnotation(
			Version.emptyVersion, "<undefined>", "", "", "<undefined>");

	/**
	 * Creates a new PapyrusDefinitionAnnotation.
	 *
	 * @param version
	 *            the version of the definition
	 * @param comment
	 *            the comment associated to this definition
	 * @param copyright
	 *            the copyright of this definition
	 * @param date
	 *            the date this definition was generated
	 * @param the
	 *            author responsible of this definition
	 */
	public PapyrusDefinitionAnnotation(Version version, String comment, String copyright, String date, String author) {
		this.version = version;
		this.comment = comment;
		this.copyright = copyright;
		this.author = author;
		this.date = date;
	}

	/**
	 * Creates a Eannotation from the given configuration
	 *
	 * @return the eAnnotation corresponding to this configuration
	 */
	public EAnnotation convertToEAnnotation() {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		// set various values (default if elements are null)
		annotation.setSource(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
		annotation.getDetails().put(IPapyrusVersionConstants.PAPYRUS_VERSION_KEY, version.toString());
		annotation.getDetails().put(IPapyrusVersionConstants.PAPYRUS_COMMENT_KEY, comment);
		annotation.getDetails().put(IPapyrusVersionConstants.PAPYRUS_COPYRIGHT_KEY, copyright);
		annotation.getDetails().put(IPapyrusVersionConstants.PAPYRUS_DATE_KEY, date);
		annotation.getDetails().put(IPapyrusVersionConstants.PAPYRUS_AUTHOR_KEY, author);
		return annotation;
	}

	/**
	 * Return the PapyrusDefinitionAnnotation corresponding to the given
	 * EAnnotation
	 *
	 * @param annotation
	 *            the annotation to parse
	 * @return a image of the given annotation, with default values if needed.
	 */
	public static PapyrusDefinitionAnnotation parseEAnnotation(EAnnotation annotation) {
		final String versionValue = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_VERSION_KEY);
		Version version;
		try {
			version = Version.parseVersion(versionValue);
		} catch (IllegalArgumentException e) {
			version = Version.emptyVersion;
		}
		final String comment = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_COMMENT_KEY);
		final String copyright = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_COPYRIGHT_KEY);
		final String date = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_DATE_KEY);
		final String author = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_AUTHOR_KEY);
		return new PapyrusDefinitionAnnotation(version, (comment != null) ? comment : "",
				(copyright != null) ? copyright : "", (date != null) ? date : "", (author != null) ? author : "");
	}

	/**
	 * Returns the version of the definition of the profile
	 *
	 * @return the version of the definition of the profile
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * Returns the comment associated to the definition of the profile
	 *
	 * @return the comment associated to the definition of the profile
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Returns the copyright associated to the definition of the profile
	 *
	 * @return the copyright associated to the definition of the profile
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * Returns the date associated to the definition of the profile
	 *
	 * @return the date associated to the definition of the profile
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Returns the author responsible to the definition of the profile
	 *
	 * @return the author responsible to the definition of the profile
	 */
	public String getAuthor() {
		return author;
	}
}
