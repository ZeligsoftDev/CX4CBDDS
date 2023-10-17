/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 * EObjectContext supports parsing OCL expressions in the context of the lazily determined classifier of an EObject.
 */
public class EObjectContext extends AbstractParserContext
{
	protected final @Nullable EObject eObject;
	private /*@LazyNonNull*/ Type classContext = null;

	public EObjectContext(@NonNull EnvironmentFactory environmentFactory, @Nullable URI uri, @Nullable EObject eObject) {
		super(environmentFactory, uri);
		this.eObject = eObject;
	}

	@Override
	public @NonNull Type getClassContext() {
		Type classContext2 = classContext;
		if (classContext2 == null) {
			PivotMetamodelManager metamodelManager = getMetamodelManager();
			try {
				if (eObject instanceof Type) {
					classContext2 = metamodelManager.getMetaclass((Type)eObject);
				}
				//				else if (eObject instanceof NamedElement) {
				//					classContext = eObject;
				//				}
				//				else if (eObject instanceof EClassifier) {
				//					Type type = metamodelManager.getPivotOf(Type.class, eObject);
				//					if (type != null) {
				//						classContext = metamodelManager.getMetaclass(type);
				//					}
				//				}
				else if (eObject != null) {
					classContext2 = ((EnvironmentFactoryInternalExtension)environmentFactory).getASOf(Type.class, eObject.eClass());
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (classContext2 == null) {
				classContext2 = metamodelManager.getStandardLibrary().getOclVoidType();
			}
			classContext = classContext2;
		}
		return classContext2;
	}

	@Override
	public void initialize(@NonNull Base2ASConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		Type classContext = getClassContext();
		conversion.getHelper().setContextVariable(expression, PivotConstants.SELF_NAME, classContext, null);
	}
}
