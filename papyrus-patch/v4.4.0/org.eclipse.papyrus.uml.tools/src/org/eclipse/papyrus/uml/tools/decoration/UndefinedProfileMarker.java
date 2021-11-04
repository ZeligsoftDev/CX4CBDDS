/*****************************************************************************
 * Copyright (c) 2018 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.decoration;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.uml.tools.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.uml2.uml.Profile;

/**
 * 
 * Marker for undefined Profile. This marker is created when Profile is tagged with {@link PapyrusDefinitionAnnotation#UNDEFINED_ANNOTATION} .
 * 
 * @author Gabriel Pascual
 * @since 4.1
 */
public class UndefinedProfileMarker implements IPapyrusMarker {

	/** The Constant MARKER_TYPE_LABEL. */
	private static final String MARKER_TYPE_LABEL = "Undefined Profile"; //$NON-NLS-1$

	/** The Constant MARKER_TYPE. */
	private static final String MARKER_TYPE = "org.eclipse.papyrus.uml.tools.decoration.undefinedprofile"; //$NON-NLS-1$

	/** The undefined profile. */
	private final Profile undefinedProfile;


	/**
	 * Constructor.
	 *
	 */
	public UndefinedProfileMarker(final Profile profile) {
		undefinedProfile = profile;
	}


	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getResource()
	 *
	 * @return
	 */
	@Override
	public Resource getResource() {
		return undefinedProfile.eResource();
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getEObject()
	 *
	 * @return
	 */
	@Override
	public EObject getEObject() {
		return undefinedProfile;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#exists()
	 *
	 * @return
	 */
	@Override
	public boolean exists() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getType()
	 *
	 * @return
	 * @throws CoreException
	 */
	@Override
	public String getType() throws CoreException {
		return MARKER_TYPE;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getTypeLabel()
	 *
	 * @return
	 * @throws CoreException
	 */
	@Override
	public String getTypeLabel() throws CoreException {

		return MARKER_TYPE_LABEL;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#delete()
	 *
	 * @throws CoreException
	 */
	@Override
	public void delete() throws CoreException {


	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getAttribute(java.lang.String)
	 *
	 * @param name
	 * @return
	 * @throws CoreException
	 */
	@Override
	public Object getAttribute(String name) throws CoreException {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getAttribute(java.lang.String, java.lang.String)
	 *
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	@Override
	public String getAttribute(String name, String defaultValue) {
		return defaultValue;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getAttribute(java.lang.String, boolean)
	 *
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	@Override
	public boolean getAttribute(String name, boolean defaultValue) {
		return defaultValue;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getAttribute(java.lang.String, int)
	 *
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	@Override
	public int getAttribute(String name, int defaultValue) {
		return defaultValue;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#getAttributes()
	 *
	 * @return
	 * @throws CoreException
	 */
	@Override
	public Map<String, ?> getAttributes() throws CoreException {
		return Collections.emptyMap();
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#isSubtypeOf(java.lang.String)
	 *
	 * @param type
	 * @return
	 * @throws CoreException
	 */
	@Override
	public boolean isSubtypeOf(String type) throws CoreException {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#setAttribute(java.lang.String, java.lang.Object)
	 *
	 * @param name
	 * @param value
	 * @throws CoreException
	 */
	@Override
	public void setAttribute(String name, Object value) throws CoreException {

	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#setAttribute(java.lang.String, java.lang.String)
	 *
	 * @param name
	 * @param value
	 * @throws CoreException
	 */
	@Override
	public void setAttribute(String name, String value) throws CoreException {

	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#setAttribute(java.lang.String, boolean)
	 *
	 * @param name
	 * @param value
	 * @throws CoreException
	 */
	@Override
	public void setAttribute(String name, boolean value) throws CoreException {

	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#setAttribute(java.lang.String, int)
	 *
	 * @param name
	 * @param value
	 * @throws CoreException
	 */
	@Override
	public void setAttribute(String name, int value) throws CoreException {

	}

	/**
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker#setAttributes(java.util.Map)
	 *
	 * @param attributes
	 * @throws CoreException
	 */
	@Override
	public void setAttributes(Map<String, ?> attributes) throws CoreException {

	}

}
