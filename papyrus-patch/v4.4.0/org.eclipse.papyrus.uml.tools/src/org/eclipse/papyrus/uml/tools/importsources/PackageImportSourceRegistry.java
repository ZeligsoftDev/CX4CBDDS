/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.importsources;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.uml2.uml.Package;

/**
 * This is the PackageImportSourceRegistry type. Enjoy.
 */
public class PackageImportSourceRegistry implements Iterable<PackageImportSourceRegistry.Descriptor> {

	private static final String EXTPT_ID = Activator.PLUGIN_ID + ".importSources";

	private final List<Descriptor> descriptors = new java.util.ArrayList<Descriptor>();

	private final IEvaluationService evaluationService;

	public PackageImportSourceRegistry(IEvaluationService evaluationService) {
		this.evaluationService = evaluationService;

		for (IConfigurationElement config : sort(Platform.getExtensionRegistry().getConfigurationElementsFor(EXTPT_ID))) {

			if ("importSource".equals(config.getName())) {
				descriptors.add(new Descriptor(config));
			}
		}
	}

	public Iterator<Descriptor> iterator() {
		return descriptors.iterator();
	}

	public int size() {
		return descriptors.size();
	}

	public IPackageImportSource createImportSourceFor(Collection<?> selection) {

		List<IPackageImportSource> result = new java.util.ArrayList<IPackageImportSource>(3);

		for (Descriptor next : this) {
			if (next.canImportInto(selection)) {
				result.add(next.getInstance());
			}
		}

		return result.isEmpty() ? new NullImportSource() : (result.size() == 1) ? result.get(0) : new CompositePackageImportSource(result);
	}

	// sort configuration elements by contributing plug-in. Our own last, all
	// others as they come
	private List<IConfigurationElement> sort(IConfigurationElement[] providerElements) {

		List<IConfigurationElement> result = new java.util.ArrayList<IConfigurationElement>(Arrays.asList(providerElements));

		Collections.sort(result, new Comparator<IConfigurationElement>() {

			public int compare(IConfigurationElement o1, IConfigurationElement o2) {

				int result;

				String plugin1 = o1.getContributor().getName();
				String plugin2 = o2.getContributor().getName();

				if (plugin1.equals(plugin2)) {
					result = 0;
				} else if (Activator.PLUGIN_ID.equals(plugin1)) {
					result = +1;
				} else if (Activator.PLUGIN_ID.equals(plugin2)) {
					result = -1;
				} else {
					result = 0;
				}

				return result;
			}
		});

		return result;
	}

	//
	// Nested types
	//

	public class Descriptor implements IPackageImportSource {

		private final IConfigurationElement config;

		private String label;

		private Expression matchSelection;

		private IPackageImportSource instance;

		Descriptor(IConfigurationElement config) {
			this.config = config;

			this.label = config.getAttribute("name");

			initMatchExpression(config);
		}

		public String getLabel() {
			return label;
		}

		IPackageImportSource getInstance() {
			if (instance == null) {
				try {
					instance = (IPackageImportSource) config.createExecutableExtension("class");
				} catch (ClassCastException e) {
					Activator.log.error("Import source does not implement IPackageImportSource interface.", e);
				} catch (Exception e) {
					Activator.log.error("Could not instantiate storage provider.", e);
				}

				if (instance == null) {
					instance = new NullImportSource();
				}
			}

			return instance;
		}

		public boolean canImportInto(Collection<?> initialSelection) {
			boolean result;

			if (matchSelection != null) {
				IEvaluationContext ctx = new EvaluationContext(evaluationService.getCurrentState(), initialSelection);

				EvaluationResult evalResult = EvaluationResult.FALSE;
				try {
					evalResult = matchSelection.evaluate(ctx);
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(e.getStatus());
				}

				result = EvaluationResult.TRUE.equals(evalResult);
			} else {
				result = getInstance().canImportInto(initialSelection);
			}

			return result;
		}

		public void initialize(Collection<?> selection) {
			getInstance().initialize(selection);
		}

		public IStaticContentProvider getModelHierarchyContentProvider(Map<String, String> extensionFilters) {
			return getInstance().getModelHierarchyContentProvider(extensionFilters);
		}

		public ILabelProvider getModelHierarchyLabelProvider() {
			return getInstance().getModelHierarchyLabelProvider();
		}

		public List<Package> getPackages(ResourceSet resourceSet, Object model) throws CoreException {

			return getInstance().getPackages(resourceSet, model);
		}

		public void dispose() {
			if (instance != null) {
				instance.dispose();
				instance = null;
			}
		}

		private void initMatchExpression(IConfigurationElement parentConfig) {
			IConfigurationElement[] configs = parentConfig.getChildren("enablement");
			if (configs.length > 0) {
				try {
					matchSelection = ExpressionConverter.getDefault().perform(configs[0]);
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(e.getStatus());
				}
			}
		}
	}

	private static final class NullImportSource implements IPackageImportSource {

		public boolean canImportInto(Collection<?> selection) {
			return false;
		}

		public void initialize(Collection<?> selection) {
			// pass
		}

		public IStaticContentProvider getModelHierarchyContentProvider(Map<String, String> extensionFilters) {
			return null;
		}

		public ILabelProvider getModelHierarchyLabelProvider() {
			return null;
		}

		public List<Package> getPackages(ResourceSet resourceSet, Object model) throws CoreException {

			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Null import source should not be invoked to import packages."));
		}

		public void dispose() {
			// pass
		}

	}
}
