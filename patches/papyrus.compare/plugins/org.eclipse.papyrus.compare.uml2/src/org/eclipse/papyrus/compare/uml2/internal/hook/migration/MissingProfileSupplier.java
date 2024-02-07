/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.hook.migration;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.compare.uml2.internal.UMLPapyrusCompareMessages;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This profile supplier returns the profile with the {@link EPackage#getNsURI()} package URI from the
 * {@link UMLPlugin.getEPackageNsURIToProfileLocationMap() ProfileLocationMap}. The URI of all registered
 * profile packages is compared to the given package URI and an appropriate one is chosen. If no acceptable
 * match is found, this supplier may also return null.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public class MissingProfileSupplier implements Function<EPackage, Profile> {

	/**
	 * The maximum distance between package URIs that is acceptable to justify an automated migration attempt.
	 */
	protected static final double DISTANCE_THRESHOLD = 0.25;

	/**
	 * Root element for which profiles are supplied.
	 */
	protected final Element root;

	/**
	 * Cache for profiles found based on EPackages. An Optional may hold a null reference if no profile has
	 * been found.
	 */
	private final Map<EPackage, Optional<Profile>> packageToProfileCache = Maps.newHashMap();

	/**
	 * Creates a missing profile supplier that find a {@link Profile} for a given {@link EPackage}. Any
	 * successful or failed supply is marked in the elements {@link Resource.Diagnostic resource diagnostic}.
	 * 
	 * @param root
	 *            The element for which missing packages need to be found.
	 */
	public MissingProfileSupplier(final Element root) {
		this.root = root;
	}

	/**
	 * Returns the profile for the missing package, if such a profile can be found. This method uses a
	 * distance measure on the URI of the missing package and returns the closest, available package, under
	 * consideration of the {@link #DISTANCE_THRESHOLD}.
	 * 
	 * @param missingPackage
	 *            package for which a profile should be found
	 * @return an Optional with a profile, if possible
	 * @see #findProfile(EPackage)
	 */
	protected Optional<Profile> findClosestProfile(final EPackage missingPackage) {
		final Map<String, Double> closestPackageUris = getClosestPackageURIs(missingPackage);

		Optional<Profile> foundProfile = Optional.absent();
		for (final Entry<String, Double> closestUri : closestPackageUris.entrySet()) {
			// check if distance is small enough to justify automated migration
			if (closestUri.getValue().doubleValue() <= DISTANCE_THRESHOLD) {
				final String packageURI = closestUri.getKey();
				foundProfile = getProfileFromRegistry(packageURI);
				if (foundProfile.isPresent()) {
					return foundProfile;
				}
			}
		}
		return foundProfile;
	}

	/**
	 * This method queries the {@link UMLPlugin#getEPackageNsURIToProfileLocationMap() profile location map}
	 * for known profile packages that have a {@link EPackage#getNsURI() URI} closest to the given package.
	 * The comparison of URIs is performed using the {@link #getDistance(String, String)} distance measure.
	 * 
	 * @param missingPackage
	 *            package for which similar packages need to be found
	 * @return a list of known profile packages with URIs closest to the given package.
	 */
	protected Map<String, Double> getClosestPackageURIs(final EPackage missingPackage) {
		final Map<String, URI> profileLocationMap = UMLPlugin.getEPackageNsURIToProfileLocationMap();
		final Map<String, Double> closestPackageUris = Maps.newHashMap();
		double minDistance = Double.MAX_VALUE;
		for (final String packageUri : profileLocationMap.keySet()) {
			final double distance = getDistance(packageUri, missingPackage.getNsURI());
			if (distance == minDistance) {
				closestPackageUris.put(packageUri, new Double(distance));
			} else if (distance < minDistance) {
				minDistance = distance;
				closestPackageUris.clear();
				closestPackageUris.put(packageUri, new Double(distance));
			}
		}
		return closestPackageUris;
	}

	/**
	 * Returns the distance between the two given strings. A lower value indicates that the strings are more
	 * similar.
	 * 
	 * @param left
	 *            left string
	 * @param right
	 *            right string
	 * @return distance measure, a lower value indicates that the strings are more similar
	 */
	protected double getDistance(final String left, final String right) {
		double avgLength = Math.min(left.length(), right.length()) + (Math.abs(left.length() - right.length())
				/ 2.0);
		return StringUtils.getLevenshteinDistance(left, right) / avgLength;
	}

	/**
	 * Returns the profile for the missing package, if such a profile can be found. The missing profile is
	 * determined through the Profile Namespace URI Pattern available in Papyrus starting with Eclipse Neon.
	 * With this pattern mechanism, profile providers can register their own namespace URI patterns to match
	 * the URI profile packages of different versions.
	 * 
	 * @param missingPackage
	 *            package for which a profile should be found
	 * @return an Optional with a profile, if possible
	 * @see #findClosestProfile(EPackage)
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=496307
	 */
	protected Optional<Profile> findMatchingProfile(final EPackage missingPackage) {
		final String missingPackageURI = missingPackage.getNsURI();
		final Map<String, URI> profileLocationMap = UMLPlugin.getEPackageNsURIToProfileLocationMap();

		Optional<Profile> foundProfile = Optional.absent();
		for (final String packageURI : profileLocationMap.keySet()) {
			if (ProfileNamespaceURIPatternAPI.isEqualVersionlessNamespaceURI(missingPackageURI, packageURI)) {
				foundProfile = getProfileFromRegistry(packageURI);
				if (foundProfile.isPresent()) {
					return foundProfile;
				}
			}
		}
		return foundProfile;
	}

	/**
	 * Returns the profile with the given package URI by retrieving the package of the
	 * {@link EPackage.Registry} and calling {@link UMLUtil#getProfile(EPackage,
	 * org.eclipse.emf.ecore.EObject))} with the root element. Any retrieved results are cached.
	 * 
	 * @param packageURI
	 *            URI of the EPackage defining the profile
	 * @return The profile optional with the given packageURI which may or may not hold a null reference
	 */
	protected Optional<Profile> getProfileFromRegistry(final String packageURI) {
		Optional<Profile> foundProfile = Optional.absent();
		final EPackage registeredPackage = EPackage.Registry.INSTANCE.getEPackage(packageURI);
		if (registeredPackage != null) {
			// check cache
			foundProfile = packageToProfileCache.get(registeredPackage);
			if (foundProfile == null) {
				// no cache hit
				Profile profile = UMLUtil.getProfile(registeredPackage, root);
				foundProfile = Optional.fromNullable(profile);
				// update cache
				packageToProfileCache.put(registeredPackage, foundProfile);
			}
		}
		return foundProfile;
	}

	/**
	 * Returns a diagnostic that can be used to provide resource messages to the user. If this returns a
	 * {@link Throwable} diagnostic, any message is automatically converted to an ERROR by
	 * {@link EcoreUtil#computeDiagnostic(Resource, boolean)} when building the comparison scope.
	 * 
	 * @param message
	 *            message to be stored in the diagnostic
	 * @return diagnostic instance that can be attached to a resource
	 */
	protected Resource.Diagnostic createResourceDiagnostic(final String message) {
		return new ProfileMigrationDiagnostic(message);
	}

	/**
	 * Adds a warning to the roots {@link EObject#eResource() resource} using the diagnostic created by
	 * {@link #createResourceDiagnostic(String)}.
	 * 
	 * @param message
	 *            warning message
	 */
	protected void addResourceWarning(final String message) {
		root.eResource().getWarnings().add(createResourceDiagnostic(message));
	}

	/**
	 * Adds a error to the roots {@link EObject#eResource() resource} using the diagnostic created by
	 * {@link #createResourceDiagnostic(String)}.
	 * 
	 * @param message
	 *            error message
	 */
	protected void addResourceError(final String message) {
		root.eResource().getErrors().add(createResourceDiagnostic(message));
	}

	/**
	 * Returns the success message that is stored in the resource.
	 * 
	 * @param missingPackage
	 *            identification of the missing package
	 * @param profile
	 *            identification of the profile that is used
	 * @return success message
	 */
	protected String getSuccessMessage(final String missingPackage, final String profile) {
		return UMLPapyrusCompareMessages.getString("profile.migration.success", missingPackage, profile); //$NON-NLS-1$
	}

	/**
	 * Returns the fail message that is stored in the resource.
	 * 
	 * @param missingPackage
	 *            identification of the missing package
	 * @return fail message
	 */
	protected String getFailMessage(final String missingPackage) {
		return UMLPapyrusCompareMessages.getString("profile.migration.fail", missingPackage); //$NON-NLS-1$
	}

	/**
	 * Returns the profile for the missing package, if such a profile can be found. The missing profile is
	 * determined through the Profile Namespace URI Pattern available in Papyrus starting with Eclipse Neon,
	 * if possible. If the necessary API is not available (previous Eclipse versions), we use a distance
	 * measure on the URI of the missing package and returns the closest, available package, under
	 * consideration of the {@link #DISTANCE_THRESHOLD}.
	 * 
	 * @param missingPackage
	 *            package for which a profile should be found
	 * @return an Optional with a profile, if possible
	 * @see #findMatchingProfile(EPackage)
	 * @see #findClosestProfile(EPackage)
	 */
	protected Optional<Profile> findProfile(final EPackage missingPackage) {
		if (ProfileNamespaceURIPatternAPI.isAvailable()) {
			return findMatchingProfile(missingPackage);
		}
		return findClosestProfile(missingPackage);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return the profile that may host the missing package or null if no appropriate profile could be found
	 */
	public Profile apply(final EPackage missingPackage) {
		// retrieve profile for missing package
		Optional<Profile> foundProfile = findProfile(missingPackage);
		if (foundProfile.isPresent()) {
			// profile found, add information via resource warning
			Profile profile = foundProfile.get();
			final String message = getSuccessMessage(missingPackage.getNsURI(), profile.getURI());
			addResourceWarning(message);
			return profile;
		} else {
			// no matching profile found, add error to resource
			final String message = getFailMessage(missingPackage.getNsURI());
			addResourceError(message);
			return null;
		}
	}
}
