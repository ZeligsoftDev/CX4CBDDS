/*******************************************************************************
 * Copyright (c) 2016, 2017 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *     Stefan Dirix - bug 498583
 *     Laurent Delaigue - bug 498583
 *     Martin Fleck - bug 515041
 *     Philip Langer - bug 516484
 *     Christian W. Damus - bug 526932
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.hook.migration;

import com.google.common.base.Function;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.compare.uml2.internal.UMLPapyrusCompareMessages;
import org.eclipse.papyrus.compare.uml2.internal.UMLPapyrusComparePlugin;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.uml.modelrepair.internal.stereotypes.StereotypeApplicationRepairSnippet;
import org.eclipse.papyrus.uml.modelrepair.internal.stereotypes.ZombieStereotypesDescriptor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Analyzer to retrieve zombie and orphan stereotype applications. Zombies are stereotype applications for
 * which the defining {@link EPackage} could not be found. Orphans are stereotype applications for which the
 * referenced base element is missing. The implementation of this class is based on the Papyrus' model repair
 * capabilities.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
@SuppressWarnings("restriction")
public class StereotypeApplicationRepair extends StereotypeApplicationRepairSnippet {

	/** The name of the private label provider service field in the super class. */
	private static final String FIELD_LABEL_PROVIDER_SERVICE = "labelProviderService"; //$NON-NLS-1$

	/** The name of the private adapter field in the super class. */
	private static final String FIELD_ADAPTER = "adapter"; //$NON-NLS-1$

	/** The name of the private dynamic profile supplier field in the super class. */
	private static final String FIELD_DYNAMIC_PROFILE_SUPPLIER = "dynamicProfileSupplier"; //$NON-NLS-1$

	/** The label provider service used to displays a user dialog during the migration. */
	private LabelProviderService fLabelProviderService;

	/** The resource under repair. */
	private Resource fResource;

	/** The profile supplier used to find a profile if a package is missing. */
	private Object fProfileSupplier;

	/** The model set used by {@link #repair()} and {@link #dispose()}. */
	private ModelSetWrapper fModelSet;

	/**
	 * Creates a new repair analyzer for zombie and orphan stereotype applications for the given resource.
	 * 
	 * @param resource
	 *            the resource under repair
	 */
	public StereotypeApplicationRepair(Resource resource) {
		// new constructor to provide our own profile supplier
		super();
		this.fResource = resource;
		this.fLabelProviderService = setLabelProviderService(createLabelProviderService());
		this.fProfileSupplier = setProfileSupplier(createProfileSupplier());
		this.fModelSet = new ModelSetWrapper(resource.getResourceSet());
		// avoid read-only for our resource
		fModelSet.setReadOnly(resource, Boolean.FALSE);
	}

	@Override
	public void dispose(ModelSet modelsManager) {
		try {
			LabelProviderService s = (LabelProviderService)getSuperField(FIELD_LABEL_PROVIDER_SERVICE);
			if (s != null) {
				s.disposeService();
			}
		} catch (ServiceException ex) {
			UMLPapyrusComparePlugin.getDefault().getLog()
					.log(new Status(IStatus.WARNING, UMLPapyrusComparePlugin.PLUGIN_ID,
							"Unable to dispose Label Provider Service", //$NON-NLS-1$
							ex));
		}
		super.dispose(modelsManager);
	}

	/**
	 * Disposed the instance.
	 */
	public void dispose() {
		// Detach it from its wrapped resource set
		fModelSet.detach();

		dispose(this.fModelSet);
	}

	/**
	 * Reflectively sets the field with the given name in the super class to the specified fieldValue.
	 * 
	 * @param fieldName
	 *            name of the field in the super class
	 * @param fieldValue
	 *            new value of the field in the super class
	 * @param <T>
	 *            type of the field value
	 * @return the value set at the given field. If an exception occurred, null is returned.
	 */
	protected <T> T setSuperField(String fieldName, T fieldValue) {
		try {
			final Field superField = getClass().getSuperclass().getDeclaredField(fieldName);
			superField.setAccessible(true);
			superField.set(this, fieldValue);
			return fieldValue;
		} catch (final NoSuchFieldException | SecurityException | IllegalArgumentException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reflectively returns the value of field with the given name from the super class. If no such field can
	 * be found or an exception is thrown, null is returned.
	 * 
	 * @param fieldName
	 *            name of the field in the super class
	 * @return field value or null
	 */
	protected Object getSuperField(String fieldName) {
		try {
			final Field superField = getClass().getSuperclass().getDeclaredField(fieldName);
			superField.setAccessible(true);
			return superField.get(this);
		} catch (final NoSuchFieldException | SecurityException | IllegalArgumentException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reflectively sets the adapter for this repair snippet. This is needed for Eclipse Luna as it expects a
	 * ModelSet as resource set for the migrated resource.
	 * 
	 * @param resourceSet
	 *            resource set containing the resource under repair
	 */
	private void setAdapter(ModelSet resourceSet) {
		// adapter needed to provide EPackage.Registry via the adapters resourceSet
		final Object adapterObject = getSuperField(FIELD_ADAPTER);
		if (adapterObject instanceof Adapter.Internal) {
			((Adapter.Internal)adapterObject).setTarget(resourceSet);
		}
	}

	/**
	 * Reflectively sets the labelProviderService for this repair snippet. This label provider service is not
	 * used during the comparison, but necessary for Papyrus which displays a user dialog during the
	 * migration. The Papyrus label provider needs the Workbench to be initialized, therefore we should use a
	 * simpler label provider to avoid this requirement.
	 * 
	 * @param labelProviderService
	 *            label provider service
	 * @return the set label provider service or null, if the label provider service could not be set
	 */
	private LabelProviderService setLabelProviderService(LabelProviderService labelProviderService) {
		return setSuperField(FIELD_LABEL_PROVIDER_SERVICE, labelProviderService);
	}

	/**
	 * Reflectively sets the profileSupplier for this repair snippet.
	 * 
	 * @param profileSupplier
	 *            supplier of profiles for missing packages.
	 * @return the set profile supplier or null, if the profile supplier could not be set
	 */
	protected Object setProfileSupplier(Object profileSupplier) {
		return setSuperField(FIELD_DYNAMIC_PROFILE_SUPPLIER, profileSupplier);
	}

	/**
	 * Creates a new label provider service that is used during the migration. In automatic migration, this
	 * label provider service is not used.
	 * 
	 * @return newly created label provider service
	 */
	protected LabelProviderService createLabelProviderService() {
		// we use a label provider service that does not need any special UI capabilities
		UMLLabelProviderService umlLabelProviderService = new UMLLabelProviderService();
		try {
			umlLabelProviderService.startService();
		} catch (ServiceException ex) {
			UMLPapyrusComparePlugin.getDefault().getLog()
					.log(new Status(IStatus.WARNING, UMLPapyrusComparePlugin.PLUGIN_ID,
							"Unable to start UML Label Provider Service", //$NON-NLS-1$
							ex));
		}
		return umlLabelProviderService;
	}

	/***
	 * Creates a new profile supplier that is called if a package is missing and we need to find a profile
	 * that defines such a package.
	 * <p>
	 * <i>Note: The return type of this method is Object, as we may need to wrap our supplier in a
	 * {@link Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler) dynamic proxy} due to a
	 * different {@link Function} interface version being used in the super class (cf. bug 515041).</i>
	 * </p>
	 * 
	 * @see #createProfileSupplierProxy(Function, Class)
	 * @return newly created profile supplier
	 */
	protected Object createProfileSupplier() {
		final MissingProfileSupplier missingProfileSupplier = new MissingProfileSupplier(
				getRootElement(fResource));
		try {
			// check if our supplier is compatible and if not wrap it in a proxy
			final Field superProfileSupplier = getClass().getSuperclass()
					.getDeclaredField(FIELD_DYNAMIC_PROFILE_SUPPLIER);
			Class<?> superProfileSupplierType = superProfileSupplier.getType();
			if (superProfileSupplierType.isInstance(missingProfileSupplier)) {
				return missingProfileSupplier;
			}
			return createProfileSupplierProxy(missingProfileSupplier, superProfileSupplierType);
		} catch (final NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return missingProfileSupplier;
	}

	/**
	 * Creates a proxy instance for the given profile supplier to be compatible with the given type.
	 * 
	 * @param profileSupplier
	 *            profile supplier
	 * @param profileSupplierType
	 *            type of the returned proxy
	 * @return proxy wrapping the provided profile supplier
	 */
	protected Object createProfileSupplierProxy(final Function<EPackage, Profile> profileSupplier,
			Class<?> profileSupplierType) {
		return Proxy.newProxyInstance(StereotypeApplicationRepairSnippet.class.getClassLoader(),
				new Class<?>[] {profileSupplierType }, new DelegatingInvocationHandler(profileSupplier));
	}

	/**
	 * Returns the resource under analysis.
	 * 
	 * @return resource
	 */
	public Resource getResource() {
		return fResource;
	}

	/**
	 * Evaluates whether all necessary fiels have been set successfully and a repair is possible.
	 * 
	 * @return true if a repair is possible, false otherwise.
	 */
	protected boolean isFieldMissing() {
		return fResource == null || fLabelProviderService == null || fProfileSupplier == null;
	}

	/**
	 * Analyzes the stereotype applications of the given resources root element and returns a descriptor
	 * containing zombie and orphan stereotype applications. For zombies, the defining package could not be
	 * found and for orphans the base element could not be found. The descriptor also already suggests repair
	 * actions, i.e., migrating the missing package for zombies if possible and deleting the stereotype
	 * application for orphans.
	 * 
	 * @return descriptor of zombie and orphan stereotypes
	 */
	public ZombieStereotypesDescriptor repair() {
		if (isFieldMissing()) {
			// fail silently but log warning
			UMLPapyrusComparePlugin.getDefault().getLog().log(new Status(IStatus.WARNING,
					UMLPapyrusComparePlugin.PLUGIN_ID, "Unable to analyze and repair resource " + fResource //$NON-NLS-1$
							+ " due to missing field: {resource=" + fResource + ", labelProviderService=" //$NON-NLS-1$ //$NON-NLS-2$
							+ fLabelProviderService + ", profileSupplier=" + fProfileSupplier + "}")); //$NON-NLS-1$//$NON-NLS-2$
			return null;
		}
		try {
			final ResourceSet resourceSet = fResource.getResourceSet();
			setAdapter(fModelSet);
			fModelSet.getResources().add(fResource);
			final ZombieStereotypesDescriptor stereotypesDescriptor = getZombieStereotypes(fResource);
			resourceSet.getResources().add(fResource);
			return stereotypesDescriptor;
			// CHECKSTYLE:OFF
		} catch (Exception e) {
			// CHECKSTYLE:ON
			fResource.getErrors().add(new ProfileMigrationDiagnostic(
					UMLPapyrusCompareMessages.getString("profile.migration.exception", e, fResource))); //$NON-NLS-1$
			UMLPapyrusComparePlugin.getDefault().getLog()
					.log(new Status(IStatus.ERROR, UMLPapyrusComparePlugin.PLUGIN_ID,
							"Exception occurred during profile migration", //$NON-NLS-1$
							e)); // The exception stack trace will appear in the error log
		}
		return null;
	}

	/**
	 * Returns the root {@link Element element} in the given resource. If multiple elements are present the
	 * first one is returned.
	 * 
	 * @param resource
	 *            resource to check
	 * @return The first root element or null if no element is found
	 */
	protected static Element getRootElement(Resource resource) {
		return (Element)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.ELEMENT);
	}
}
