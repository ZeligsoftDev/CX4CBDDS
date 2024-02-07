/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.plugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * A plugin extension reader that populates the
 * {@link org.eclipse.ocl.pivot.labels.ILabelGenerator.Registry#INSTANCE} label generator registry. Clients are not expected to use
 * this class directly.
 */
public class LabelGeneratorRegistryReader extends RegistryReader
{
	static class LabelGeneratorDescriptor extends PluginClassDescriptor implements ILabelGenerator.Descriptor
	{
		protected @Nullable ILabelGenerator<?> labelGenerator;

		public LabelGeneratorDescriptor(@NonNull IConfigurationElement e, @NonNull String attrName) {
			super(e, attrName);
		}

		@Override
		public @NonNull ILabelGenerator<?> getLabelGenerator() {
			ILabelGenerator<?> labelGenerator2 = labelGenerator;
			if (labelGenerator2 == null) {
				labelGenerator2 = labelGenerator = (ILabelGenerator<?>) createInstance();
				assert labelGenerator2 != null;
			}
			return labelGenerator2;
		}

		public @NonNull IConfigurationElement getElement() {
			assert element != null;
			return element;
		}
	}

	static final @NonNull String TAG_GENERATOR = "generator";
	static final @NonNull String ATT_FOR = "for";
	static final @NonNull String ATT_CLASS = "class";
	
	protected final ILabelGenerator.@NonNull Registry registry;

	public LabelGeneratorRegistryReader(ILabelGenerator.@NonNull Registry registry) {
		super(Platform.getExtensionRegistry(), PivotPlugin.getPlugin().getBundle().getSymbolicName(),
				PivotPlugin.LABEL_GENERATOR_PPID);
		this.registry = registry;
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals(TAG_GENERATOR)) {
			String helpedClass = element.getAttribute(ATT_FOR);
			if (helpedClass == null) {
				logMissingAttribute(element, ATT_FOR);
			} else if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else {
				Class<?> loadedClass = null;
				try {
					Object createExecutableExtension;
					try {
						createExecutableExtension = element.createExecutableExtension(ATT_CLASS);
						loadedClass = createExecutableExtension.getClass().getClassLoader().loadClass(helpedClass);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					PivotPlugin.logError("Failed to load '" + helpedClass + "'", e);
					return false;
				}
				if (loadedClass != null) {
					if (add) {
						Object previous = registry.install(loadedClass, new LabelGeneratorDescriptor(element, ATT_CLASS));
						if (previous instanceof LabelGeneratorDescriptor) {
							LabelGeneratorDescriptor descriptor = (LabelGeneratorDescriptor) previous;
							PivotPlugin.INSTANCE.log("Both '"
									+ descriptor.getElement().getContributor().getName()
									+ "' and '" + element.getContributor().getName()
									+ "' register an invocation delegate factory for '"
									+ helpedClass + "'");
						}
						return true;
					} else {
						ILabelGenerator.Registry.INSTANCE.uninstall(loadedClass);
						return true;
					}
				}
			}
		}

		return false;
	}
}
