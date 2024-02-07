/*******************************************************************************
 * Copyright (c) 2016, 2018 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *     Philip Langer - bug 516484
 *     Christian W. Damus - bug 529217
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.hook;

import static org.eclipse.papyrus.infra.emf.internal.resource.AbstractCrossReferenceIndex.SHARD_ANNOTATION_SOURCE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.hook.AbstractResourceSetHooks;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.compare.uml2.internal.hook.migration.StereotypeApplicationRepair;
import org.eclipse.papyrus.uml.modelrepair.internal.stereotypes.IRepairAction;
import org.eclipse.papyrus.uml.modelrepair.internal.stereotypes.ZombieStereotypesDescriptor;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class migrates missing UML stereotype applications before the comparison, if possible. For any missing
 * stereotype application, we aim to find an available profile definition (EPackage) that provides the
 * stereotype. If such a definition can be found, we migrate to the respective profile and stereotype
 * applications. If no definition can be found, the model is left unchanged. Profile definitions are searched
 * based on the URI of the missing stereotypes package URI.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
@SuppressWarnings("restriction")
public class ProfileMigrationHook extends AbstractResourceSetHooks {

	@Override
	public void postLoadingHook(ResourceSet resourceSet, Collection<? extends URI> uris) {
		final List<Resource> umlResources = getUMLResources(resourceSet);
		if (umlResources.isEmpty()) {
			return; // we are not responsible
		}

		// Two stages: ensure sub-unit linkages and then repair

		// First, ensure that the linkages between sub-units are correctly
		// established (container proxies) so that packages can find profile
		// applications in parent units and we don't create redundant new
		// profile applications in the next step that will introduce bogus diffs
		for (final Resource umlResource : umlResources) {
			ensureParentUnitLinkage(umlResource);
		}

		// Then, do whatever it takes to repair profile applications
		for (final Resource umlResource : umlResources) {
			repairProfileApplications(umlResource);
		}
	}

	@Override
	public boolean isHookFor(Collection<? extends URI> uris) {
		for (final URI uri : uris) {
			if (isUMLResource(uri)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the given URI represents a UML resource.
	 * 
	 * @param uri
	 *            URI to check
	 * @return true if the given URI represents a UML resource, false otherwise
	 */
	private boolean isUMLResource(final URI uri) {
		return uri != null && UmlModel.UML_FILE_EXTENSION.equals(uri.fileExtension());
	}

	/**
	 * Checks if the given resource is a UML resource based on its URI. If the given resource is null, false
	 * is returned.
	 * 
	 * @param resource
	 *            resource to check
	 * @return true if the given resource represents a UML resource, false otherwise.
	 * @see #isUMLResource(URI)
	 */
	private boolean isUMLResource(final Resource resource) {
		return resource != null && isUMLResource(resource.getURI());
	}

	/**
	 * Filters all UML resources from the given resource set. If no UML resources can be found, an empty list
	 * is returned.
	 * 
	 * @param resourceSet
	 *            loaded resource set
	 * @return all UML resources from the given resource set
	 * @see #isUMLResource(Resource)
	 */
	private List<Resource> getUMLResources(final ResourceSet resourceSet) {
		final List<Resource> umlResources = new ArrayList<Resource>();
		for (final Resource resource : resourceSet.getResources()) {
			if (isUMLResource(resource)) {
				umlResources.add(resource);
			}
		}
		return umlResources;
	}

	/**
	 * Repairs the profile applications of missing stereotypes, if possible, by first analyzing the resource
	 * for missing stereotypes and then delegating to the model repair mechanism provided by Papyrus.
	 * 
	 * @param resource
	 *            resource to be repaired
	 */
	protected void repairProfileApplications(final Resource resource) {
		if (resource == null) {
			return; // nothing to repair
		}

		final StereotypeApplicationRepair repair = new StereotypeApplicationRepair(resource);
		try {
			final ZombieStereotypesDescriptor stereotypesDescriptor = repair.repair();
			if (stereotypesDescriptor == null || !stereotypesDescriptor.hasZombies()) {
				return; // nothing to repair
			}

			// for each schema (missing EPackages) try to repair the respective stereotype applications
			for (final IAdaptable schema : stereotypesDescriptor.getZombieSchemas()) {
				// the stereotype descriptor already provides the most suitable repair action
				// deletion for orphans (stereotypes whose base element is missing)
				// profile migration for zombies (stereotypes whose defining package can not be found)
				final IRepairAction repairAction = stereotypesDescriptor.getSuggestedRepairAction(schema);
				if (repairAction != null) {
					// execute any suggested action
					stereotypesDescriptor.repair(schema, repairAction, new BasicDiagnostic(),
							new NullProgressMonitor());
				}
			}
		} finally {
			repair.dispose();
		}
	}

	/**
	 * Ensure that a sub-model unit correctly resolves its {@code eContainer} link to its parent unit so that
	 * profile applications may be found in that parent unit.
	 * 
	 * @param resource
	 *            a UML resource that may or may not be a sub-model unit
	 */
	protected void ensureParentUnitLinkage(Resource resource) {
		org.eclipse.uml2.uml.Package subUnit = (org.eclipse.uml2.uml.Package)EcoreUtil
				.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
		if (subUnit != null) {
			// Search for the shard annotation and resolve the parent package's
			// proxy for this nested package
			EAnnotation annotation = subUnit.getEAnnotation(SHARD_ANNOTATION_SOURCE);
			if (annotation != null) {
				org.eclipse.uml2.uml.Package parentUnit = (org.eclipse.uml2.uml.Package)EcoreUtil
						.getObjectByType(annotation.getReferences(), UMLPackage.Literals.PACKAGE);
				if (parentUnit != null) {
					final URI proxyURI = EcoreUtil.getURI(subUnit);

					// Trigger containment proxy resolution
					for (ListIterator<PackageableElement> iter = ((InternalEList<PackageableElement>)parentUnit
							.getPackagedElements()).basicListIterator(); iter.hasNext();) {

						PackageableElement next = iter.next();
						if (proxyURI.equals(((InternalEObject)next).eProxyURI())) {
							parentUnit.getPackagedElements().get(iter.previousIndex());

							// Needn't continue further
							break;
						}
					}
				}
			}
		}
	}
}
