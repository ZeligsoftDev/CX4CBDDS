/*******************************************************************************
 * Copyright (c) 2014, 2019 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.delegate.OCLDelegateDomain;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;

public abstract class PivotDiagnostician extends Diagnostician
{
	private static Boolean diagnosticianHasDoValidate = null; // Use 2.9/2.8 Diagnostician

	public static @NonNull Diagnostician createDiagnostician(@NonNull ResourceSet resourceSet,
			AdapterFactory adapterFactory, @Nullable IProgressMonitor progressMonitor) {
		return createDiagnostician(resourceSet, null, adapterFactory, progressMonitor);

	}

	/**
	 * @since 1.4
	 */
	public static @NonNull Diagnostician createDiagnostician(@NonNull ResourceSet resourceSet,
			EValidator.@Nullable Registry globalEValidatorRegistry, AdapterFactory adapterFactory, @Nullable IProgressMonitor progressMonitor) {
		EValidatorRegistryImpl localEValidatorRegistry = new EValidatorRegistryImpl();
		for (ASResourceFactory asResourceFactory : ASResourceFactoryRegistry.INSTANCE.getExternalResourceFactories()) {
			asResourceFactory.initializeEValidatorRegistry(localEValidatorRegistry);
		}
		if (globalEValidatorRegistry != null) {
			// If we are unlucky, this validation could occur in a builder more or less
			// concurrently with a launch that lazily loads new EPackages (see Bug 544245).
			Iterable<EPackage> stableKeySet = new ArrayList<>(globalEValidatorRegistry.keySet());
			for (EPackage ePackage : stableKeySet) {
				if (ePackage != null) {
					Object localEValidator = localEValidatorRegistry.get(ePackage);
					Object globalEValidator = globalEValidatorRegistry.get(ePackage);
					if (localEValidator == null) {
						if (globalEValidator != null) {
							localEValidatorRegistry.put(ePackage, globalEValidator);
						}
					}
					else {
						if (globalEValidator != null) {
							ComposedEValidator composedEValidator = null;
							if (localEValidator instanceof ComposedEValidator) {
								composedEValidator = (ComposedEValidator)localEValidator;
							}
							else if (localEValidator instanceof EValidator.Descriptor) {
								composedEValidator = new ComposedEValidator(((EValidator.Descriptor)localEValidator).getEValidator());
								localEValidatorRegistry.put(ePackage, composedEValidator);
							}
							else if (localEValidator instanceof EValidator) {
								composedEValidator = new ComposedEValidator((EValidator)localEValidator);
								localEValidatorRegistry.put(ePackage, composedEValidator);
							}
							if (composedEValidator != null) {
								if (globalEValidator instanceof EValidator.Descriptor) {
									composedEValidator.addChild(((EValidator.Descriptor)globalEValidator).getEValidator());
								}
								else if (globalEValidator instanceof EValidator) {
									composedEValidator.addChild((EValidator)globalEValidator);
								}
							}
						}
					}
				}
			}
		}
		if (diagnosticianHasDoValidate == null) {
			diagnosticianHasDoValidate = false;
			for (Method method : Diagnostician.class.getDeclaredMethods()) {
				if ("doValidate".equals(method.getName())) {
					diagnosticianHasDoValidate = true;
				}
			}
		}
		if (diagnosticianHasDoValidate) {
			return new Diagnostician_2_9(localEValidatorRegistry, resourceSet, adapterFactory,
				progressMonitor != null ? progressMonitor : new NullProgressMonitor());
		}
		else {
			return new Diagnostician_2_8(localEValidatorRegistry, resourceSet, adapterFactory);
		}
	}

	/**
	 * Return the OCL context for the validation, caching the created value in the validation context for re-use by
	 * further validations. The cached reference is weak to ensure that the OCL context is disposed once no longer in use.
	 *
	 * @deprecated pass a null eObject to getOCL(context, eObject)
	 */
	@Deprecated
	public static @NonNull OCL getOCL(@NonNull Map<Object, Object> context) {
		return getOCL(context, null);
	}

	/**
	 * Return the OCL context for the validation, caching the created value in the validation context for re-use by
	 * further validations. The cached reference is weak to ensure that the OCL context is disposed once no longer in use.
	 *
	 * If no OCL context is cached a new one is created first by creating an OCL for an EnvironmentFactory adapting
	 * a non-null eObject's Rsource or ResourceSet. Otherwise by creating a new global OCL.
	 *
	 * @since 1.4
	 */
	public static @NonNull OCL getOCL(@NonNull Map<Object, Object> context, @Nullable EObject eObject) {
		OCL ocl = null;
		Object oclRef = context.get(WeakOCLReference.class);
		if (oclRef instanceof WeakOCLReference) {
			ocl = ((WeakOCLReference)oclRef).get();
		}
		if (ocl == null) {
			if (eObject != null) {
				EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
				if (environmentFactory != null) {
					ocl = environmentFactory.createOCL();
				}
			}
			if (ocl == null) {
				ocl = OCL.newInstance();
			}
			ThreadLocalExecutor.setUsesFinalizer();
			context.put(WeakOCLReference.class, new WeakOCLReference(ocl));
		}
		return ocl;
	}

	public static void setOCL(@NonNull Map<Object, Object> context, @NonNull OCL ocl) {
		ThreadLocalExecutor.setUsesFinalizer();
		context.put(WeakOCLReference.class, new WeakOCLReference(ocl));
	}

	protected final static class Diagnostician_2_8 extends PivotDiagnostician
	{
		protected Diagnostician_2_8(EValidator.@NonNull Registry eValidatorRegistry,
				@NonNull ResourceSet resourceSet, AdapterFactory adapterFactory) {
			super(eValidatorRegistry, resourceSet, adapterFactory);
		}

		@Override
		public String getObjectLabel(EObject eObject) {
			if (adapterFactory != null && !eObject.eIsProxy()) {
				IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject, IItemLabelProvider.class);
				if (itemLabelProvider != null) {
					return itemLabelProvider.getText(eObject);
				}
			}
			return super.getObjectLabel(eObject);
		}
	}

	protected final static class Diagnostician_2_9 extends PivotDiagnostician
	{
		private final @NonNull ResourceSet resourceSet;
		private final @NonNull IProgressMonitor progressMonitor;

		protected Diagnostician_2_9(EValidator.@NonNull Registry eValidatorRegistry, @NonNull ResourceSet resourceSet,
				AdapterFactory adapterFactory, @NonNull IProgressMonitor progressMonitor) {
			super(eValidatorRegistry, resourceSet, adapterFactory);
			this.resourceSet = resourceSet;
			this.progressMonitor = progressMonitor;
		}

		@Override
		protected boolean doValidate(EValidator eValidator, EClass eClass, EObject eObject,
				DiagnosticChain diagnostics, Map<Object, Object> context) {
			progressMonitor.worked(1);
			synchronized (resourceSet) {
				return super.doValidate(eValidator, eClass, eObject, diagnostics, context);
			}
		}

		@Override
		public String getObjectLabel(EObject eObject) {
			if (adapterFactory != null && !eObject.eIsProxy()) {
				IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject, IItemLabelProvider.class);
				if (itemLabelProvider != null) {
					return itemLabelProvider.getText(eObject);
				}
			}
			return super.getObjectLabel(eObject);
		}
	}

	/**
	 * WeakOCLReference maintains the reference to the OCL context within the Diagnostician context and
	 * disposes of it once the Diagnostician is done.
	 */
	public static final class WeakOCLReference extends WeakReference<OCL>	// FIXME Migrate to ThreadLocalExecutor.Terminator
	{
		private static int counter = 0;

		protected final @NonNull OCL ocl;
		private int count;

		protected WeakOCLReference(@NonNull OCL ocl) {
			super(ocl);
			this.ocl = ocl;
			this.count = ++counter;
		//	System.out.println("[" + Thread.currentThread().getName() + "] PivotDiagnostician.WeakOCLReference-" + count + ".init()");
		}

		@Override
		public void finalize() {
			new Thread("OCL-Finalizer")		// New thread needed to avoid deadlock hazrad on ocl.dsipose()
			{
				@Override
				public void run() {
				//	System.out.println("[" + Thread.currentThread().getName() + "] PivotDiagnostician.WeakOCLReference-" + count + ".finalize()");
					ocl.dispose();
				}
			}.start();
		}
	}

	/**
	 * BasicDiagnosticWithRemove supports the migration of child diagnostics to grandchildren in the more
	 * efficient validateFeatureDetail override.
	 *
	 * The enhancement is facilitated by a remove. The actual requirement is to split off all children after a
	 * given index for additional to another BasicDiagnostic. Perhaps a truncate(index) or split(index) might
	 * be better; many low level alternatives possible. Maybe just a getRawChildren().
	 *
	 * @since 1.4
	 */
	public static class BasicDiagnosticWithRemove extends BasicDiagnostic
	{
		/**
		 * This validate is a convenience method demonstrating how the BasicDiagnosticWithRemove enhancement
		 * can be exploited.
		 */
		public static BasicDiagnostic validate(EObject eObject, Map<Object, Object> validationContext) {
			BasicDiagnostic diagnostics = new BasicDiagnosticWithRemove(EObjectValidator.DIAGNOSTIC_SOURCE, 0, EcorePlugin.INSTANCE.getString("_UI_DiagnosticRoot_diagnostic", new Object[] { Diagnostician.INSTANCE.getObjectLabel(eObject) }), new Object [] { eObject });
			Diagnostician.INSTANCE.validate(eObject, diagnostics, validationContext);
			return diagnostics;
		}

		public BasicDiagnosticWithRemove(String source, int code, String message, Object[] data) {
			super(source, code, message, data);
		}

		public Diagnostic remove(int index) {
			return children.remove(index);
		}
	}

	protected final AdapterFactory adapterFactory;
	protected final @NonNull Technology technology;

	protected PivotDiagnostician(EValidator.@NonNull Registry eValidatorRegistry, @NonNull ResourceSet resourceSet, AdapterFactory adapterFactory) {
		super(eValidatorRegistry);
		this.adapterFactory = adapterFactory;
		this.technology = ASResourceFactoryRegistry.INSTANCE.getTechnology();
		OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet);
	}

	@Override
	public Map<Object, Object> createDefaultContext() {
		Map<Object, Object> context = super.createDefaultContext();
		if (context != null) {
			OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(context);
		}
		return context;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if ((eClass != null) && !technology.isValidatable(eClass)) {
			return true;
		}
		if ((eObject instanceof EAnnotation) && DerivedConstants.UML2_UML_PACKAGE_2_0_NS_URI.equals(((EAnnotation)eObject).getSource())) {	// FIXME move stereotype discard to technology
			return true;
		}
		return super.validate(eClass, eObject, diagnostics, context);
	}
}