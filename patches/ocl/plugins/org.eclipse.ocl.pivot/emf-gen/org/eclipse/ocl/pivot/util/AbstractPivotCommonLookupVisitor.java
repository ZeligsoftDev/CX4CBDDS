/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.pivot/model/Pivot.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.pivot.util;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;

public abstract class AbstractPivotCommonLookupVisitor
extends AbstractExtendingVisitor<@Nullable LookupEnvironment, @NonNull LookupEnvironment> {

	protected AbstractPivotCommonLookupVisitor(@NonNull LookupEnvironment context) {
		super(context);
	}

	@Override
	public final LookupEnvironment visiting(@NonNull Visitable visitable) {
		return doVisiting(visitable);
	}


	abstract protected LookupEnvironment doVisiting(@NonNull Visitable visitable);

}
