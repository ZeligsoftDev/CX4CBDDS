/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * The standalone functionality is heavily influenced by org.eclipse.emf.mwe.utils.StandaloneSetup.
 *******************************************************************************/
package org.eclipse.ocl.pivot.resource;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Clients might use one of the following implementations
 * <ul>
 * 		<li>{@link ProjectManager#NO_PROJECTS} - Lightweight with no external projects contributions</li>
 *		<li>{@link ProjectManager#CLASS_PATH} - A shared Heavyweight including classpath analysis</li>
 *		<li>{@link BasicProjectManager#createDefaultProjectManager()} - Convenient method to create local heavyweight local managers</li>
 * </ul>
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ProjectManager extends Adapter
{
	/**
	 * The NO_PROJECTS instance of ProjectManager contributes no external projects to a user application.
	 */
	public static final @NonNull ProjectManager NO_PROJECTS = new BasicProjectManager();		// FIXME Use static method to make this lazy

	/**
	 * The CLASS_PATH ProjectManager provides a shared ProjectManager that allows many OCL instances to share
	 * a single immutable ProjectManager and consequently share the costly classpath analysis to identify
	 * available projects.
	 */
	public static final @NonNull ProjectManager CLASS_PATH = BasicProjectManager.createGlobalProjectManager();		// FIXME Use static method to make this lazy

	/**
	 * An IConflictHandler configures the handling of conflicting access between generated packages and
	 * dynamically loaded resources.
	 */
	public static interface IConflictHandler
	{
		/**
		 * Return the EPackage to be used for a namespace URI reference after the model EPackage has already been used.
		 */
		@Nullable EPackage handleConflictingGeneratedPackage(@NonNull IPackageLoadStatus packageLoadStatus, @NonNull Resource resource);

		/**
		 * Return the EPackage to be used for a model URI reference after the namespace EPackage has already been used.
		 */
		@Nullable EPackage handleConflictingDynamicResource(@NonNull IResourceLoadStatus packageLoadStatus, @NonNull EPackage ePackage);
	}

	/**
	 * An IPackageDescriptor describes the modeling capabilities of a known
	 * model package and may be installed under a variety of synonyms in an
	 * EPackage.Registry to map multiple URIs to a single EPackage.
	 */
	public static interface IPackageDescriptor
	{
		/**
		 * Configure the resourceSet-specific resource status of for this package to use
		 * a strategy and a conflictHandler.
		 */
		void configure(@NonNull ResourceSet resourceSet, @NonNull IResourceLoadStrategy strategy, @Nullable IConflictHandler conflictHandler);

		/**
		 * Return the classname defined in the generated_packaged extension point, or null if undefined.
		 */
		@Nullable String getClassName();

		/**
		 * Return the Package Namespace URI.
		 */
		@NonNull URI getNsURI();

		/**
		 * Return the IResourceDescriptor containing this package.
		 */
		@NonNull IResourceDescriptor getResourceDescriptor();
	}

	/**
	 * An IPackageLoadStatus maintains the lazy load state of a package within an EPackage.Registry
	 */
	public static interface IPackageLoadStatus
	{
		/**
		 * Configure the resourceSet EPackage.Registry for this package to resolve to the defined
		 * generated/loaded EPackage.
		 */
		void configureEPackageRegistry(@NonNull ResourceSet resourceSet);

		/**
		 * Dispose of all facilities used by the PackageLoadStatus, and remove all EPackageDescriptor entries.
		 */
		void dispose();

		/**
		 * Return the EPackage to be used for a namespace URI after a platform-resource/plugin URI has already been loaded.
		 */
		@Nullable EPackage getConflictingGeneratedPackage();

		/**
		 * Return the generated EPackage instance, or null if none loaded.
		 */
		@Nullable EPackage getEPackage();

		/**
		 * Return the generated EPackage instance without affecting the prevailing status.
		 * Returns null if an instance cannot be loaded.
		 */
		@Nullable EPackage getEPackageInstance();

		/**
		 * Return the EPackage resolved by the first loadEPackageByModelURI/loadEPackageByNsURI, or null if none loaded.
		 */
		@Nullable EPackage getFirstEPackage();

		/**
		 * Return the loaded EPackages, or null if none loaded.
		 */
		@Nullable EPackage getModel();

		/**
		 * Return the descriptor for the package.
		 */
		@NonNull IPackageDescriptor getPackageDescriptor();

		/**
		 * Get the status of the resource containing this package.
		 */
		@NonNull IResourceLoadStatus getResourceLoadStatus();

		/**
		 * Load and return the generated EPackage instance appropriate to the namespace URI.
		 */
		@Nullable EPackage loadEPackage();

		/**
		 * Define the generated EPackage for this package.
		 */
		void setEPackage(@NonNull EPackage ePackage);

		/**
		 * Define the loaded EPackage for this package.
		 */
		void setModel(@NonNull EPackage ePackage);

		/**
		 * Reset the status following notiofication that the model has been unloaded.
		 */
		void unloadedResource();
	}

	/**
	 * An IProjectDescriptor describes the capabilities of a project.
	 */
	public static interface IProjectDescriptor
	{
		/**
		 * @since 1.1
		 */
		public static interface IProjectDescriptorExtension extends IProjectDescriptor
		{
			/**
			 * Return all the package descriptors for this project.
			 */
			@Nullable Iterable<@NonNull IPackageDescriptor> getPackageDescriptors();
		}

		/**
		 * Call back to add a packageDescriptor to the project.
		 */
		void addPackageDescriptor(@NonNull IPackageDescriptor packageDescriptor);

		/**
		 * Call back to add a resourceDescriptor to the project.
		 */
		void addResourceDescriptor(@NonNull IResourceDescriptor resourceDescriptor);

		/**
		 * Configure the resourceSet-specific status of for this resource to use
		 * a strategy and a conflictHandler.
		 */
		void configure(@Nullable ResourceSet resourceSet, @NonNull IResourceLoadStrategy resourceLoadStrategy, @Nullable IConflictHandler conflictHandler);

		/**
		 * Create an IResourceDescriptor for a projectRelativeGenModelUri comprsising a map of NsURI to className.
		 */
		@NonNull IResourceDescriptor createResourceDescriptor(@NonNull String projectRelativeGenModelUri, @NonNull Map<@NonNull URI, @NonNull String> nsURI2className);

		/**
		 * Return the physical location of this project.
		 */
		@NonNull URI getLocationURI();

		/**
		 * Return the physical location of a projectRelativeFileName as a URI.
		 */
		@NonNull URI getLocationURI(@NonNull String projectRelativeFileName);

		/**
		 * Return the physical location of a projectRelativeFileName as a File.
		 */
		@NonNull File getLocationFile(@NonNull String projectRelativeFileName);

		/**
		 * Return project name.
		 */
		@NonNull String getName();

		/**
		 * Return the location of this project as a platform:/plugin URI.
		 */
		@NonNull URI getPlatformPluginURI();

		/**
		 * Return the location of a projectRelativeFileName as a
		 * platform:/resource URI.
		 */
		@NonNull URI getPlatformPluginURI(@NonNull String projectRelativeFileName);

		/**
		 * Return the location of this project as a platform:/resource URI.
		 */
		@NonNull URI getPlatformResourceURI();

		/**
		 * Return the location of a projectRelativeFileName as a
		 * platform:/resource URI.
		 */
		@NonNull URI getPlatformResourceURI(@NonNull String projectRelativeFileName);

		/**
		 * Return the package descriptor for the package with a given nsURI or
		 * null if none known in the project.
		 */
		@Nullable IPackageDescriptor getPackageDescriptor(@NonNull URI nsURI);

		/**
		 * Return the overall ProjectMap.
		 */
		@NonNull ProjectManager getProjectManager();

		/**
		 * Return all packages descriptors in the project.
		 */
		@Nullable Collection<@NonNull IResourceDescriptor> getResourceDescriptors();

		void initializeGenModelLocationMap(@NonNull Map<@NonNull URI, @NonNull IPackageDescriptor> nsURI2package);

		void initializePlatformResourceMap();

		void initializeURIMap(@NonNull Map<URI, URI> uriMap);

		void unload(@NonNull ResourceSet resourceSet);
	}

	/**
	 * An IResourceDescriptor describes the modeling capabilities of one or more known
	 * model packages in a genmodel.
	 */
	public static interface IResourceDescriptor
	{
		void addedDynamicResource(@NonNull ResourceSet resourceSet, @NonNull Resource resource);

		void addedGeneratedPackage(@NonNull ResourceSet resourceSet, @NonNull EPackage ePackage);

		void configure(@Nullable ResourceSet resourceSet, @NonNull IResourceLoadStrategy resourceLoadStrategy, @Nullable IConflictHandler conflictHandler);

		void configureResourceSetURIResourceMap(@NonNull ResourceSet resourceSet, @NonNull Resource resource);

		/**
		 * Return the project relative Gen Model URI.
		 */
		@NonNull URI getGenModelURI();

		/**
		 * Return the external filespace form of the model URI containing the package.
		 * @throws IllegalStateException if there is no Ecore model.
		 */
		@NonNull URI getLocationURI();

		/**
		 * Return the descriptors for allpackages in this resource.
		 */
		Iterable<@NonNull ? extends IPackageDescriptor> getPackageDescriptors();

		/**
		 * Return the platform:/resource form of the model URI containing the package
		 * @throws IllegalStateException if there is no Ecore model.
		 */
		@NonNull URI getPlatformResourceURI();

		/**
		 * Return the platform:/plugin form of the model URI containing the package
		 * @throws IllegalStateException if there is no Ecore model.
		 */
		@NonNull URI getPlatformPluginURI();

		/**
		 * Return the Project Descriptor containing this resource.
		 */
		@NonNull IProjectDescriptor getProjectDescriptor();

		@NonNull URI getProjectRelativeEcorePackageURI(@NonNull URI genModelRelativeEcorePackageURI);

		/**
		 * Return IResourceLoadStatus for this resource in conjunction with resourceSet.
		 */
		@NonNull IResourceLoadStatus getResourceLoadStatus(@Nullable ResourceSet resourceSet);

		/**
		 * Return true if setEcoreModel has defined the Ecore Model context.
		 */
		boolean hasEcoreModel();

		/**
		 * Set the Ecore Model context of the resource from a list of URIs of the Ecore Packages relative to the
		 * genModelURI, and a map of the package namespace URI to package descriptor.
		 */
		void setEcoreModel(@NonNull List<@NonNull String> genModelRelativeEcorePackageUris, @NonNull Map<@NonNull String, @NonNull IPackageDescriptor> nsURI2packageDescriptor);

		/**
		 * Unload the package registry to force a reload.
		 */
		void unload(@NonNull ResourceSet resourceSet);
	}

	/**
	 * An IResourceLoadStrategy determines how each of the possible forms of URI reference to an EPackage should loaded.
	 */
	public static interface IResourceLoadStrategy
	{
		/**
		 * Respond to the explicit addition of a yet to be loaded Ecore model in the user's ResourceSet.
		 */
		void addedDynamicResource(@NonNull IResourceLoadStatus resourceLoadStatus, @NonNull Resource resource);

		/**
		 * Respond to the explicit addition of a generated EPackage in the user's ResourceSet.
		 */
		void addedGeneratedPackage(@NonNull IPackageLoadStatus packageLoadStatus, @NonNull EPackage ePackage);

		/**
		 * Return the EPackage in response to an EPackage.Registry access through an EPackageDescriptor, null if not loaded.
		 */
		@Nullable EPackage basicGetEPackage(@NonNull IPackageLoadStatus packageLoadStatus);

		/**
		 * Configure the resourceLoadStatus to udse this strategy and a conflictHandler.
		 */
		void configure(@NonNull IResourceLoadStatus resourceLoadStatus, @Nullable IConflictHandler conflictHandler);

		/**
		 * Load and return the EPackage in response to an EPackage.Registry access through an EPackageDescriptor.
		 */
		@Nullable EPackage getEPackage(@NonNull IPackageLoadStatus packageLoadStatus);

		/**
		 * Respond to the platform/plugin access to a resource with a resourceLoadStatus containing a
		 * package already accessed as the Java generated ePackage,
		 */
		void handleConflictingDynamicResource(@NonNull IResourceLoadStatus resourceLoadStatus, @NonNull EPackage ePackage);

		/**
		 * Respond to the loading of a dynamic Ecore model in the user's ResourceSet.
		 */
		void loadedDynamicResource(@NonNull IResourceLoadStatus packageLoadStatus, @NonNull Resource resource);

		/**
		 * Respond to the notification that the resource has been unloaded.
		 */
		void unloadedResource(@NonNull IResourceLoadStatus resourceLoadStatus);

		/**
		 * Respond to the explicit notification of a generated resource.
		 */
		void useGeneratedResource(@NonNull IResourceLoadStatus resourceLoadStatus, @NonNull Resource resource);
	}

	/**
	 * An IResourceLoadStatus maintains the lazy load state of a resource associated with a genmodel
	 * identified by an IResourceDescriptor within a ResourceSet.
	 */
	public static interface IResourceLoadStatus
	{
		/**
		 * Configure the ResourceSet.URIResourceMap to resolve platform:/plugin and platform:/resource
		 * references to a pseudo resource that delegates to generated packages.
		 */
		void configureDelegatingResource();

		/**
		 * Configure the EPackage.Registry to resolve namesapce URI references to the specified resource.
		 */
		void configureEPackageRegistry(@NonNull Resource resource);

		/**
		 * Configure the ResourceSet.URIResourceMap to resolve platform:/plugin and platform:/resource
		 * references to the specified resource.
		 */
		void configureResourceSetURIResourceMap(@NonNull Resource resource);

		/**
		 * Dispose of all facilities used by the IResourceLoadStatus, and remove all EPackageDescriptor entries.
		 */
		void dispose();

		/**
		 * Return the EPackage to be used for a platform-resource/plugin URI after a namespace URI has already been loaded.
		 */
		@Nullable EPackage getConflictingDynamicResource(@NonNull EPackage ePackage);

		/**
		 * Return the first loaded EPackage which may be part of a model or a Java generated EPackageinstance..
		 */
		@Nullable EPackage getFirstEPackage();

		/**
		 * Return the package load status for the package identified by packageDescriptor
		 */
		@Nullable IPackageLoadStatus getPackageLoadStatus(@NonNull IPackageDescriptor packageDescriptor);

		/**
		 * Return the descriptor for the resource.
		 */
		@NonNull IResourceDescriptor getResourceDescriptor();

		/**
		 * Return the configured resource loading strategy.
		 */
		@NonNull IResourceLoadStrategy getResourceLoadStrategy();

		/**
		 * Return the package registry maintained by this resource load status
		 */
		EPackage.@NonNull Registry getPackageRegistry();

		/**
		 * Return the ResourceSet to which the resource logically belongs. (Note that generated EPackage may have
		 * a null actual ResourceSet, but a non-null logical ResourceSet.)
		 */
		@Nullable ResourceSet getResourceSet();

		/**
		 * Load and return the EPackage appropriate to the platform resource or plugin resource using nsURI to identify
		 * a conflicting nsURI access,
		 */
		@Nullable Resource loadDynamicResource(@NonNull URI nsURI);

		/**
		 * Load all the Java generated EPackage instances for the resource.
		 */
		void loadGeneratedPackages();

		/**
		 * Define a new conflict handler.
		 */
		void setConflictHandler(@Nullable IConflictHandler conflictHandler);

		/**
		 * Set true by AS2Ecore to inhibit auto-loading of newly added EPackages.
		 *
		 * @deprecated - try using a CreateStrategy instead, see Bug 465326
		 */
		@Deprecated
		void setGenerationInProgress(boolean isGenerating);

		/**
		 * Define the resource once it has been loaded.
		 */
		void setResource(@NonNull Resource resource);

		/**
		 * Define a new package load strategy.
		 */
		void setResourceLoadStrategy(@NonNull IResourceLoadStrategy resourceLoadStrategy);

		/**
		 * Reset the status following notification that the model has been unloaded.
		 */
		void unloadedResource();
	}

	void addResourceDescriptor(@NonNull IResourceDescriptor resourceDescriptor);

	void configure(@NonNull ResourceSet resourceSet, @NonNull IResourceLoadStrategy instance, @Nullable IConflictHandler instance2);

	/**
	 * Configure the use of nsURI within resourceSet to use the first loaded package. This is almost always
	 * needed for Ecore.ecore since Ecore.ecore referemces its ownm nsURI. It may also be needed for
	 * nsURIs whose genmodels are in use since they too must use non nsURI access.
	 *
	 * @since 1.8
	 */
	default void configureLoadFirst(@NonNull ResourceSet resourceSet, /*@NonNull*/ String nsURI) {}

	IPackageDescriptor getPackageDescriptor(@NonNull URI ecoreURI);

	/**
	 * @since 1.3
	 */
	@Nullable IResourceDescriptor getResourceDescriptor(@NonNull URI uri);

	void initializeResourceSet(@Nullable ResourceSet resourceSet);

	boolean isGlobal();

	/**
	 * @since 1.3
	 */
	void removeResourceDescriptor(@NonNull IResourceDescriptor resourceDescriptor);

	void unload(@NonNull ResourceSet resourceSet);

	void useGeneratedResource(@NonNull Resource resource, @NonNull ResourceSet resourceSet);
}
