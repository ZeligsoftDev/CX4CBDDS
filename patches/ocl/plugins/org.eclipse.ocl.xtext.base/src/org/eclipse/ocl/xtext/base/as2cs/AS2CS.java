/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.as2cs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.internal.utilities.AbstractConversion;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CSI2ASMapping;

/**
 * AS2AS manages the equivalence between an Abstract Syntax Resources
 * and the corresponding Concrete Syntax Resources.
 */
public class AS2CS extends AbstractConversion
{
	public static interface Factory {
		@NonNull BaseDeclarationVisitor createDeclarationVisitor(@NonNull AS2CSConversion converter);
		@NonNull BaseReferenceVisitor createExpressionVisitor(@NonNull AS2CSConversion converter, @Nullable Namespace scope);
		@NonNull BaseReferenceVisitor createReferenceVisitor(@NonNull AS2CSConversion converter, @Nullable Namespace scope);

		/**
		 * Return a list of classes for which this AS2CS overrides a base AS2CS.
		 */
		@NonNull EClass @NonNull [] getEClasses();
	}

	public static abstract class AbstractFactory implements Factory
	{
		@Override
		public @NonNull BaseDeclarationVisitor createDeclarationVisitor(@NonNull AS2CSConversion converter) {
			return new BaseDeclarationVisitor(converter);
		}

		@Override
		public @NonNull BaseReferenceVisitor createExpressionVisitor(@NonNull AS2CSConversion converter, @Nullable Namespace scope) {
			return createReferenceVisitor(converter, scope);
		}

		@Override
		public @NonNull BaseReferenceVisitor createReferenceVisitor(@NonNull AS2CSConversion converter, @Nullable Namespace scope) {
			return new BaseReferenceVisitor(converter);
		}

		@Override
		public @NonNull EClass @NonNull [] getEClasses() {
			return new @NonNull EClass[] {};
		}
	}

	private @NonNull Map<@NonNull EClass, @NonNull Factory> factoryMap = new HashMap<>();

	/**
	 * Mapping of each CS resource to its corresponding pivot Resource.
	 */
	protected final @NonNull Map<@NonNull ? extends BaseCSResource, @NonNull ? extends ASResource> cs2asResourceMap;

	public AS2CS(@NonNull Map<@NonNull ? extends BaseCSResource, @NonNull ? extends ASResource> cs2asResourceMap, @NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
		this.cs2asResourceMap = cs2asResourceMap;
	}

	public AS2CS(@NonNull AS2CS aConverter) {
		super(aConverter.getEnvironmentFactory());
		this.cs2asResourceMap = aConverter.cs2asResourceMap;
	}

	protected synchronized void addFactory(@NonNull Factory factory) {
		for (EClass eClass : factory.getEClasses()) {
			factoryMap.put(eClass, factory);
		}
	}

	public @NonNull BaseDeclarationVisitor createDefaultDeclarationVisitor(@NonNull AS2CSConversion conversion) {
		return new BaseDeclarationVisitor(conversion);
	}

	public @NonNull BaseReferenceVisitor createDefaultExpressionVisitor(@NonNull AS2CSConversion conversion) {
		return new BaseReferenceVisitor(conversion);
	}

	public @NonNull BaseReferenceVisitor createDefaultReferenceVisitor(@NonNull AS2CSConversion conversion) {
		return new BaseReferenceVisitor(conversion);
	}

	public @Nullable Resource getASResource(@NonNull Resource csResource) {
		return cs2asResourceMap.get(csResource);
	}

	public @NonNull Collection<@NonNull ? extends Resource> getASResources() {
		return cs2asResourceMap.values();
	}

	public @NonNull Collection<@NonNull ? extends BaseCSResource> getCSResources() {
		return cs2asResourceMap.keySet();
	}

	public @Nullable Factory getFactory(@NonNull EClass eClass) {
		return factoryMap.get(eClass);
	}

	public void update() {
		AS2CSConversion conversion = new AS2CSConversion(this);
		for (@NonNull BaseCSResource csResource : getCSResources()) {
			conversion.update(csResource);
		}
		CSI2ASMapping csi2asMapping = CSI2ASMapping.getCSI2ASMapping(environmentFactory);
		csi2asMapping.add(cs2asResourceMap);
		csi2asMapping.update(/*csResources*/);
	}
}