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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Package;

/**
 * This is the CompositePackageImportSource type. Enjoy.
 */
public class CompositePackageImportSource extends AbstractPackageImportSource {

	private static final Object[] NONE = {};

	private final Map<Object, Wrapper> wrappers = new java.util.HashMap<Object, Wrapper>();

	private List<IPackageImportSource> delegates = new java.util.ArrayList<IPackageImportSource>(3);

	private Map<String, String> extensionFilters;

	public CompositePackageImportSource(Collection<? extends IPackageImportSource> sources) {

		delegates.addAll(sources);
	}

	@Override
	public boolean canImportInto(Collection<?> selection) {
		boolean result = false;

		for (IPackageImportSource next : delegates) {
			result = next.canImportInto(selection);

			if (result) {
				break;
			}
		}

		return result;
	}

	@Override
	public void initialize(Collection<?> selection) {
		for (IPackageImportSource next : delegates) {
			try {
				next.initialize(selection);
			} catch (Exception e) {
				Activator.log.error("Uncaught exception in package import source initialization.", e);
			}
		}
	}

	@Override
	protected IStaticContentProvider createModelHierarchyContentProvider(Map<String, String> extensionFilters) {
		this.extensionFilters = extensionFilters;
		return new WrapperContentProvider();
	}

	@Override
	protected ILabelProvider createModelHierarchyLabelProvider() {
		return new WrapperLabelProvider();
	}

	@Override
	public List<Package> getPackages(ResourceSet resourceSet, Object model) throws CoreException {

		return getDelegate(model).getPackages(resourceSet, unwrap(model));
	}

	IPackageImportSource getDelegate(Object element) {
		return ((Wrapper) element).getOwner();
	}

	ITreeContentProvider getTreeContentProvider(Object element) {
		Object result = getDelegate(element).getModelHierarchyContentProvider(extensionFilters);
		return (result instanceof ITreeContentProvider) ? (ITreeContentProvider) result : null;
	}

	@Override
	public void dispose() {
		wrappers.clear();

		for (IPackageImportSource next : delegates) {
			try {
				next.dispose();
			} catch (Exception e) {
				Activator.log.error("Uncaught exception in package import source disposal.", e);
			}
		}

		delegates.clear();

		super.dispose();
	}

	Object[] wrap(Collection<? extends IPackageImportSource> sources) {
		List<Object> result = new java.util.ArrayList<Object>(sources.size());

		for (IPackageImportSource next : sources) {
			result.add(new Wrapper(next, next));
		}

		return result.toArray();
	}

	Object wrap(Object element, IPackageImportSource owner) {
		Object result = element;

		if (element != null) {
			result = wrappers.get(element);
			if (result == null) {
				Wrapper wrapper = new Wrapper(element, owner);
				wrappers.put(element, wrapper);
				result = wrapper;
			}
		}

		return result;
	}

	Object[] wrap(Object[] elements, IPackageImportSource owner) {
		Object[] result;

		if (elements.length == 0) {
			result = NONE;
		} else {
			result = new Object[elements.length];
			for (int i = 0; i < elements.length; i++) {
				result[i] = wrap(elements[i], owner);
			}
		}

		return result;
	}

	static Object unwrap(Object element) {
		return (element instanceof Wrapper) ? ((Wrapper) element).getElement() : element;
	}

	//
	// Nested types
	//

	private static class Wrapper {

		private final Object element;

		private final IPackageImportSource owner;

		Wrapper(Object element, IPackageImportSource owner) {
			this.element = element;
			this.owner = owner;
		}

		Object getElement() {
			return element;
		}

		IPackageImportSource getOwner() {
			return owner;
		}
	}

	private final class WrapperLabelProvider implements ILabelProvider {

		public Image getImage(Object element) {
			return getDelegate(element).getModelHierarchyLabelProvider().getImage(unwrap(element));
		}

		public String getText(Object element) {
			return getDelegate(element).getModelHierarchyLabelProvider().getText(unwrap(element));
		}

		public boolean isLabelProperty(Object element, String property) {
			return getDelegate(element).getModelHierarchyLabelProvider().isLabelProperty(unwrap(element), property);
		}

		public void addListener(ILabelProviderListener listener) {
			for (IPackageImportSource next : delegates) {
				next.getModelHierarchyLabelProvider().addListener(listener);
			}
		}

		public void removeListener(ILabelProviderListener listener) {
			for (IPackageImportSource next : delegates) {
				next.getModelHierarchyLabelProvider().removeListener(listener);
			}
		}

		public void dispose() {
			// Disposal of the import sources takes care of the label providers
		}
	}

	private final class WrapperContentProvider extends StaticContentProvider implements ITreeContentProvider {

		private Object input;

		WrapperContentProvider() {
			super(wrap(delegates));
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			super.inputChanged(viewer, oldInput, newInput);

			this.input = newInput;

			for (IPackageImportSource next : delegates) {
				next.getModelHierarchyContentProvider(extensionFilters).inputChanged(viewer, oldInput, newInput);
			}
		}

		public Object getParent(Object element) {
			ITreeContentProvider provider = getTreeContentProvider(element);
			return (provider == null) ? null : wrap(provider.getParent(unwrap(element)), getDelegate(element));
		}

		public boolean hasChildren(Object element) {
			boolean result;

			Object realElement = unwrap(element);
			if (realElement instanceof IPackageImportSource) {
				// it's a root
				result = getChildren(element).length > 0;
			} else {
				ITreeContentProvider provider = getTreeContentProvider(element);
				return (provider == null) ? false : provider.hasChildren(realElement);
			}

			return result;
		}

		public Object[] getChildren(Object parentElement) {
			Object[] result;

			Object realParent = unwrap(parentElement);
			if (realParent instanceof IPackageImportSource) {
				IPackageImportSource source = (IPackageImportSource) realParent;
				result = wrap(source.getModelHierarchyContentProvider(extensionFilters).getElements(input), source);
			} else {
				ITreeContentProvider provider = getTreeContentProvider(parentElement);
				return (provider == null) ? NONE : wrap(provider.getChildren(realParent), getDelegate(parentElement));
			}

			return result;
		}

	}
}
