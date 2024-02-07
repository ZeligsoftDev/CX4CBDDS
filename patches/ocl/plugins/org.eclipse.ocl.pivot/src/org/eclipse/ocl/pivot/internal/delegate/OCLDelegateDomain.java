/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.ValidationDelegateRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.common.delegate.VirtualDelegateMapping;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.GlobalEnvironmentFactory;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;

/**
 * An implementation of a delegate domain for an OCL enhanced package. The domain
 * maintains an OCL facade to be shared by all delegates within the package.
 */
public class OCLDelegateDomain implements DelegateDomain, GlobalEnvironmentFactory.Listener
{
	public static class FactoryFactory
	{
		public static final @NonNull FactoryFactory INSTANCE = new FactoryFactory();

		public @NonNull OCLDelegateDomainFactory createDelegateDomainFactory() {
			return new OCLDelegateDomainFactory();
		}

		public @NonNull OCLInvocationDelegateFactory createInvocationDelegateFactory(@NonNull String oclDelegateURI) {
			return new OCLInvocationDelegateFactory(oclDelegateURI);
		}

		public @NonNull OCLQueryDelegateFactory createQueryDelegateFactory(@NonNull String oclDelegateURI) {
			return new OCLQueryDelegateFactory(oclDelegateURI);
		}

		public @NonNull OCLSettingDelegateFactory createSettingDelegateFactory(@NonNull String oclDelegateURI) {
			return new OCLSettingDelegateFactory(oclDelegateURI);
		}

		public @NonNull OCLValidationDelegateFactory createValidationDelegateFactory(@NonNull String oclDelegateURI) {
			return new OCLValidationDelegateFactory(oclDelegateURI);
		}
	}

	protected static class PivotOnlyRegistry extends ValidationDelegateRegistryImpl
	{
		private static final long serialVersionUID = 1L;

		public static final @NonNull PivotOnlyRegistry INSTANCE = new PivotOnlyRegistry();

		@Override
		public ValidationDelegate getValidationDelegate(String uri) {
			return OCLValidationDelegateFactory.Global.INSTANCE;
		}
	}

	protected static class PivotOnlyVirtualDelegateMapping extends VirtualDelegateMapping
	{
		public static final @NonNull PivotOnlyVirtualDelegateMapping INSTANCE = new PivotOnlyVirtualDelegateMapping();

		protected PivotOnlyVirtualDelegateMapping() {
			super("x", "y", "z");
		}

		@Override
		public @Nullable String getDefaultValue() {
			return PivotConstants.OCL_DELEGATE_URI_PIVOT;
		}

		@Override
		public @Nullable String getPreferredValue() {
			return PivotConstants.OCL_DELEGATE_URI_PIVOT;
		}
	}

	// FIXME workaround BUG 485093 giving a false non-null analysis
	@SuppressWarnings("null")
	private static @NonNull DelegateResourceSetAdapter getDelegateResourceSetAdapter(@NonNull ResourceSet resourceSet) {
		return DelegateResourceSetAdapter.getAdapter(resourceSet);
	}

	/**
	 * @since 1.1
	 */
	// FIXME workaround BUG 485093 giving a false non-null analysis
	public static <T> T getDelegateResourceSetRegistry(EModelElement modelElement, @NonNull Class<@NonNull T> registryClass, T defaultRegistry) {
		Resource resource = modelElement.eResource();
		if (resource == null) {
			return defaultRegistry;
		}
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			return defaultRegistry;
		}
		DelegateResourceSetAdapter adapter = getDelegateResourceSetAdapter(resourceSet);
		@Nullable T registry = getDelegateResourceSetAdapterRegistry(adapter, registryClass);
		return registry != null ? registry : defaultRegistry;
	}

	// FIXME workaround BUG 485093 giving a false non-null analysis
	private static <T> @Nullable T getDelegateResourceSetAdapterRegistry(@NonNull DelegateResourceSetAdapter adapter, @NonNull Class<T> registryClass) {
		return adapter.getRegistry(registryClass);
	}

	/**
	 * Initialize the resourceSet registries, if non-null, or the global registries, if null,
	 * to support usage of the Pivot OCL Delegate Evaluator for the Pivot OCL Delegate URI.
	 */
	public static void initialize(@Nullable ResourceSet resourceSet) {
		initialize(resourceSet, PivotConstants.OCL_DELEGATE_URI_PIVOT);
	}

	/**
	 * Initialize the resourceSet registries, if non-null, or the global registries, if null,
	 * to support usage of the Pivot OCL Delegate Evaluator for the oclDelegateURI.
	 */
	public static void initialize(@Nullable ResourceSet resourceSet, @NonNull String oclDelegateURI) {
		lazyInitializeGlobals(oclDelegateURI, true);
		if (resourceSet != null) {
			lazyInitializeLocals(resourceSet, oclDelegateURI, true, null);
		}
	}

	public static void initializePivotOnlyDiagnosticianContext(@NonNull Map<Object, Object> context) {
		context.put(org.eclipse.emf.ecore.EValidator.ValidationDelegate.Registry.class, PivotOnlyRegistry.INSTANCE);
		context.put(EValidator.SubstitutionLabelProvider.class, LabelUtil.SUBSTITUTION_LABEL_PROVIDER);
	}

	public static void initializePivotOnlyDiagnosticianResourceSet(@NonNull ResourceSet resourceSet) {
		DelegateResourceSetAdapter adapter = getDelegateResourceSetAdapter(resourceSet);
		putDelegateResourceSetRegistry(adapter, org.eclipse.ocl.pivot.internal.delegate.ValidationDelegate.Registry.class, PivotOnlyRegistry.INSTANCE);
		putDelegateResourceSetRegistry(adapter, VirtualDelegateMapping.class, PivotOnlyVirtualDelegateMapping.INSTANCE);
	}

	/**
	 * Initialize the local resourceSet delegate registries to support the oclDelegateURI.
	 * A non-null delegateFactoryFactory may be specified for test purposes to intercept factory creation.
	 */
	public static void lazyInitializeLocals(@NonNull ResourceSet resourceSet, @NonNull String oclDelegateURI, boolean forceInitialization,
			@Nullable FactoryFactory delegateFactoryFactory) {
		if (delegateFactoryFactory == null) {
			delegateFactoryFactory = FactoryFactory.INSTANCE;
		}
		FactoryFactory delegateFactoryFactory2 = ClassUtil.nonNullState(delegateFactoryFactory);  // Try to avoid spurious build failure
		// Install a DelegateResourceSetAdapter to supervise local registries and resource post-loading
		@SuppressWarnings("null")@NonNull DelegateResourceSetAdapter adapter = DelegateResourceSetAdapter.getAdapter(resourceSet);
		VirtualDelegateMapping delegationMode = CommonOptions.DEFAULT_DELEGATION_MODE;
		if (forceInitialization || (getDelegateResourceSetAdapterRegistry(adapter, VirtualDelegateMapping.class) == null)) {
			putDelegateResourceSetRegistry(adapter, VirtualDelegateMapping.class, new VirtualDelegateMapping(delegationMode.getPluginId(), delegationMode.getKey(), delegationMode.getPreferredValue()));
		}

		// Install a local DelegateDomain.Factory
		DelegateDomain.Factory.Registry.Impl delegateDomainFactory = new DelegateDomain.Factory.Registry.Impl();
		if (forceInitialization || !delegateDomainFactory.containsKey(oclDelegateURI)) {
			delegateDomainFactory.put(oclDelegateURI, delegateFactoryFactory2.createDelegateDomainFactory());
		}
		if (forceInitialization || (getDelegateResourceSetAdapterRegistry(adapter, DelegateDomain.Factory.Registry.class) == null)) {
			putDelegateResourceSetRegistry(adapter, DelegateDomain.Factory.Registry.class, delegateDomainFactory);
		}

		// Install a local ValidationDelegate.Factory
		ValidationDelegate.Factory.Registry validationDelegateFactoryRegistry = new ValidationDelegate.Factory.Registry.Impl();
		if (forceInitialization || !validationDelegateFactoryRegistry.containsKey(oclDelegateURI)) {
			validationDelegateFactoryRegistry.put(oclDelegateURI, delegateFactoryFactory2.createValidationDelegateFactory(oclDelegateURI));
		}
		if (forceInitialization || (getDelegateResourceSetAdapterRegistry(adapter, ValidationDelegate.Factory.Registry.class) == null)) {
			putDelegateResourceSetRegistry(adapter, ValidationDelegate.Factory.Registry.class, validationDelegateFactoryRegistry);
		}

		// Install a local SettingDelegate.Factory
		EStructuralFeature.Internal.SettingDelegate.Factory.Registry settingDelegateFactoryRegistry = new EStructuralFeature.Internal.SettingDelegate.Factory.Registry.Impl();
		if (forceInitialization || !settingDelegateFactoryRegistry.containsKey(oclDelegateURI)) {
			settingDelegateFactoryRegistry.put(oclDelegateURI, delegateFactoryFactory2.createSettingDelegateFactory(oclDelegateURI));
		}
		if (forceInitialization || (getDelegateResourceSetAdapterRegistry(adapter, EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class) == null)) {
			putDelegateResourceSetRegistry(adapter, EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class, settingDelegateFactoryRegistry);
		}

		// Install a local InvocationDelegate.Factory
		EOperation.Internal.InvocationDelegate.Factory.Registry invocationDelegateFactoryRegistry = new EOperation.Internal.InvocationDelegate.Factory.Registry.Impl();
		if (forceInitialization || !invocationDelegateFactoryRegistry.containsKey(oclDelegateURI)) {
			invocationDelegateFactoryRegistry.put(oclDelegateURI, delegateFactoryFactory2.createInvocationDelegateFactory(oclDelegateURI));
		}
		if (forceInitialization || (getDelegateResourceSetAdapterRegistry(adapter, EOperation.Internal.InvocationDelegate.Factory.Registry.class) == null)) {
			putDelegateResourceSetRegistry(adapter, EOperation.Internal.InvocationDelegate.Factory.Registry.class, invocationDelegateFactoryRegistry);
		}

		// Install a local QueryDelegate.Factory
		QueryDelegate.Factory.Registry queryDelegateFactoryRegistry = new QueryDelegate.Factory.Registry.Impl();
		if (forceInitialization || !queryDelegateFactoryRegistry.containsKey(oclDelegateURI)) {
			queryDelegateFactoryRegistry.put(oclDelegateURI, delegateFactoryFactory2.createQueryDelegateFactory(oclDelegateURI));
		}
		if (forceInitialization || (getDelegateResourceSetAdapterRegistry(adapter, QueryDelegate.Factory.Registry.class) == null)) {
			putDelegateResourceSetRegistry(adapter, QueryDelegate.Factory.Registry.class, queryDelegateFactoryRegistry);
		}
	}

	/**
	 * Initialize any currently uninitialized global delegate registries to support the oclDelegateURI.
	 */
	public static void lazyInitializeGlobals(@NonNull String oclDelegateURI, boolean forceInitialization) {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {		// Install the 'plugin' registrations
			EOperation.Internal.InvocationDelegate.Factory.Registry invocationRegistry = EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE;
			if (forceInitialization || !invocationRegistry.containsKey(oclDelegateURI)) {
				invocationRegistry.put(oclDelegateURI, new OCLInvocationDelegateFactory.Global());
			}
			EStructuralFeature.Internal.SettingDelegate.Factory.Registry settingRegistry = EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE;
			if (forceInitialization || !settingRegistry.containsKey(oclDelegateURI)) {
				settingRegistry.put(oclDelegateURI, new OCLSettingDelegateFactory.Global());
			}
			EValidator.ValidationDelegate.Registry validationRegistry = EValidator.ValidationDelegate.Registry.INSTANCE;
			if (forceInitialization || !validationRegistry.containsKey(oclDelegateURI)) {
				validationRegistry.put(oclDelegateURI, new OCLValidationDelegateFactory.Global());
			}
			QueryDelegate.Factory.Registry queryRegistry = QueryDelegate.Factory.Registry.INSTANCE;
			if (forceInitialization || !queryRegistry.containsKey(oclDelegateURI)) {
				queryRegistry.put(oclDelegateURI, new OCLQueryDelegateFactory.Global());
			}
		}
	}

	// FIXME workaround BUG 485093 giving a false non-null analysis
	private static @Nullable <T> T putDelegateResourceSetRegistry(@NonNull DelegateResourceSetAdapter adapter, @NonNull Class<T> registryClass, @NonNull T newRegistry) {
		return adapter.putRegistry(registryClass, newRegistry);
	}

	protected final @NonNull String uri;
	protected final @NonNull EPackage ePackage;
	@Deprecated /* @deprecated replaced getEnvironmentFactory() frpm loacal thread */
	protected OCL ocl = null;				// Lazily initialized and re-initialized
	// FIXME Introduce a lightweight function (? a lambda function) to avoid the need for a CompleteEnvironment for queries
	//	private Map<CompletePackage, org.eclipse.ocl.pivot.Package> queryPackages = null;
	//	private Map<CompleteType, org.eclipse.ocl.pivot.Class> queryTypes = null;

	/**
	 * Initializes me with my delegate URI and package.
	 *
	 * @param delegateURI
	 *            the delegate namespace I handle
	 * @param ePackage
	 *            the package that I handle
	 *
	 * @throws ParserException
	 *             if the operation's OCL body expression is invalid
	 */
	public OCLDelegateDomain(@NonNull String delegateURI, @NonNull EPackage ePackage) {
		this.uri = delegateURI;
		this.ePackage = ePackage;
	}

	@Override
	public void environmentFactoryDisposed(@NonNull EnvironmentFactory environmentFactory) {
		reset();
	}

	/**
	 * @since 1.14
	 */
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		EnvironmentFactory environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
		if (environmentFactory == null) {
			environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(ProjectManager.NO_PROJECTS, null, null);
		}
		return environmentFactory;
	}

	/*	private @NonNull EnvironmentFactory getEnvironmentFactory() {
		Resource res = ePackage.eResource();
		EnvironmentFactory envFactory = null;
		if (res != null) {
			MetamodelManager metamodelManager = null;
			ResourceSet resourceSet = res.getResourceSet();
			if (resourceSet != null) {
				EnvironmentFactoryResourceSetAdapter rsAdapter = EnvironmentFactoryResourceSetAdapter.findAdapter(resourceSet);
				if (rsAdapter != null) {
					metamodelManager = rsAdapter.getMetamodelManager();
				}
				// it's a dynamic package. Use the local package registry
//				EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
				if (metamodelManager != null) {
					envFactory = metamodelManager.getEnvironmentFactory();
				}
				else {
					envFactory = OCL.Internal.createEnvironmentFactory(null);
				}
				DelegateResourceAdapter.getAdapter(res);
			}
		}
		if (envFactory == null) {
			// the shared instance uses the static package registry
			envFactory = OCL.Internal.getGlobalEnvironmentFactory();
		}
		return envFactory;
	} */

	public final @NonNull MetamodelManager getMetamodelManager() {
		return getEnvironmentFactory().getMetamodelManager();
	}

	@Deprecated /* @deprecated use getEnvironmentFactory() */
	public @NonNull OCL getOCL() {
		OCL ocl2 = ocl;
		if (ocl2 == null) {
			EnvironmentFactory localEnvironmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
			if (localEnvironmentFactory != null) {
				ocl2 = ocl = localEnvironmentFactory.createOCL();
			}
			else {
				// Delegates are an application-independent extension of EMF
				//  so we must use the neutral/global context see Bug 338501
				//			EnvironmentFactory environmentFactory = getEnvironmentFactory();
				GlobalEnvironmentFactory environmentFactory = GlobalEnvironmentFactory.getInstance();
				ocl2 = ocl = environmentFactory.createOCL();
				environmentFactory.addListener(this);
			}
		}
		return ocl2;
	}

	public <T extends Element> @Nullable T getPivot(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		EnvironmentFactoryInternalExtension eEnvironmentFactory = (EnvironmentFactoryInternalExtension)getEnvironmentFactory();
		try {
			return eEnvironmentFactory.getASOf(requiredClass, eObject);
		} catch (ParserException e) {
			return null;
		}
	}

	@Override
	public final @NonNull String getURI() {
		return uri;
	}

	@Override
	public synchronized void reset() {
		OCL ocl2 = ocl;
		if (ocl2 != null) {
			ocl = null;
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				List<Adapter> eClassifierAdapters = eClassifier.eAdapters();
				for (Adapter adapter : eClassifierAdapters) {
					if (adapter instanceof DelegateEClassifierAdapter) {
						eClassifierAdapters.remove(adapter);
						break;
					}
				}
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					for (EOperation eOperation : eClass.getEOperations()) {
						((EOperation.Internal) eOperation).setInvocationDelegate(null);
					}
					for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
						((EStructuralFeature.Internal) eStructuralFeature).setSettingDelegate(null);
					}
				}
			}
			EnvironmentFactory environmentFactory = ocl2.getEnvironmentFactory();
			if (environmentFactory instanceof GlobalEnvironmentFactory) {
				((GlobalEnvironmentFactory)environmentFactory).removeListener(this);
			}
			ocl2.dispose();
		}
	}

	@Override
	public String toString() {
		return ePackage.getName() + " : " + getURI(); //$NON-NLS-1$
	}
}
