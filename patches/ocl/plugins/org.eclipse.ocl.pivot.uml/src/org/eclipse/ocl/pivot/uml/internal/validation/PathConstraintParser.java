/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.IParameterizedConstraintDescriptor;
import org.eclipse.emf.validation.service.IParameterizedConstraintParser;
import org.eclipse.emf.validation.xml.ConstraintParserException;
import org.eclipse.jdt.annotation.NonNull;

public class PathConstraintParser implements IParameterizedConstraintParser
{
	public static class PathConstraint implements IModelConstraint
	{
		private @NonNull IParameterizedConstraintDescriptor descriptor;
		
		public PathConstraint(@NonNull IParameterizedConstraintDescriptor descriptor) {
			this.descriptor = descriptor;
		}

		@Override
		public IConstraintDescriptor getDescriptor() {
			return descriptor;
		}

		@Override
		public IStatus validate(IValidationContext ctx) {
			return null;
		}
	}

	public PathConstraintParser() {
	}

	@Override
	public PathConstraint parseConstraint(IParameterizedConstraintDescriptor descriptor) throws ConstraintParserException {
		return descriptor != null ? new PathConstraint(descriptor) : null;
	}
}
