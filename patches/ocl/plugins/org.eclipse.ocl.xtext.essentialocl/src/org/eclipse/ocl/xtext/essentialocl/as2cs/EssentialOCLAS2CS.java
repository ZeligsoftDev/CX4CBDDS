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
package org.eclipse.ocl.xtext.essentialocl.as2cs;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.BaseAS2CS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;

public class EssentialOCLAS2CS extends BaseAS2CS
{
	private static final class Factory extends AbstractFactory
	{
		private static AS2CS.@NonNull Factory INSTANCE = new Factory();

		@Override
		public @NonNull EssentialOCLDeclarationVisitor createDeclarationVisitor(@NonNull AS2CSConversion converter) {
			return new EssentialOCLDeclarationVisitor(converter);
		}

		@Override
		public @NonNull EssentialOCLExpressionVisitor createExpressionVisitor(@NonNull AS2CSConversion converter, @Nullable Namespace scope) {
			return new EssentialOCLExpressionVisitor(converter, scope);
		}

		@Override
		public @NonNull EssentialOCLReferenceVisitor createReferenceVisitor(@NonNull AS2CSConversion converter, @Nullable Namespace scope) {
			return new EssentialOCLReferenceVisitor(converter, scope);
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull EClass @NonNull [] getEClasses() {
			return new EClass @NonNull [] {
				PivotPackage.Literals.MAP_TYPE
			};
		}
	}

	public EssentialOCLAS2CS(@NonNull Map<@NonNull ? extends BaseCSResource, @NonNull ? extends ASResource> cs2asResourceMap, @NonNull EnvironmentFactoryInternal environmentFactory) {
		super(cs2asResourceMap, environmentFactory);
		addFactory(Factory.INSTANCE);
	}
}
