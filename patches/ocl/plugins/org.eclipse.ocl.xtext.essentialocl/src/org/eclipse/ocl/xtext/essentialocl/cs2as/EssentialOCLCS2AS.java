/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 397429
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.BaseCS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

public class EssentialOCLCS2AS extends BaseCS2AS
{
	public EssentialOCLCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull BaseCSResource csResource, @NonNull ASResource asResource) {
		super(environmentFactory, csResource, asResource);
	}

	public EssentialOCLCS2AS(@NonNull EssentialOCLCS2AS cs2as) {
		super(cs2as);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2ASConversion converter) {
		return new EssentialOCLCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2ASConversion converter) {
		return new EssentialOCLCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2ASConversion converter) {
		return new EssentialOCLCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2ASConversion converter) {
		return new EssentialOCLCSPreOrderVisitor(converter);
	}
}
