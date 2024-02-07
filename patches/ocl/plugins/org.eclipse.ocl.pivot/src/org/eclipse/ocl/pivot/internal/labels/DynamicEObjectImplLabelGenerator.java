/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.labels;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

public final class DynamicEObjectImplLabelGenerator extends AbstractLabelGenerator<DynamicEObjectImpl>
{
	private static final AdapterFactory reflectiveAdapterFactory =
			new ReflectiveItemProviderAdapterFactory();

	private static final AdapterFactory defaultAdapterFactory =
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	public static void initialize(Registry registry) {
		registry.install(DynamicEObjectImpl.class, new DynamicEObjectImplLabelGenerator());		
	}
	
	public DynamicEObjectImplLabelGenerator() {
		super(DynamicEObjectImpl.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull DynamicEObjectImpl object) {
		EClass eClass = object.eClass();
		Resource eResource = object.eResource();
		if ((eResource != null) && (object.eContainer() == null)) {
			String className = eResource.getClass().getName();
			if (className.contains("UML")) {
				for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
					if ((eFeature instanceof EReference) && !eFeature.isMany() && eFeature.getName().startsWith("base_")) {
						labelBuilder.appendString("«");
						labelBuilder.appendString(eClass.getName());
						labelBuilder.appendString("»");
						labelBuilder.buildLabelFor(object.eGet(eFeature));
						return;
					}
				}
			}
		}
		IItemLabelProvider labeler = (IItemLabelProvider) defaultAdapterFactory.adapt(object, IItemLabelProvider.class);		
		if (labeler == null) {
			labeler = (IItemLabelProvider) reflectiveAdapterFactory.adapt(object, IItemLabelProvider.class);
		}		
		if (labeler != null) {
			labelBuilder.appendString(labeler.getText(object));
		}
		else {
			labelBuilder.appendString(String.valueOf(object));
		}
	}
}