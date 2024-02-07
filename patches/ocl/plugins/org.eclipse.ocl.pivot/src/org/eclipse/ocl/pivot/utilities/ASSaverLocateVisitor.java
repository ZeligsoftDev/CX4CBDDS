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
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;

/**
 * LocateVisitor locates references to shared specializations, so that
 * local copies can be created and then replaced by the ResolveVisitor.
 */
@Deprecated /* @deprecated Replaced by safer EcoreUtil.Copier/CrossReferencer functionality */
public class ASSaverLocateVisitor extends AbstractExtendingVisitor<Object, ASSaver>
{
	public ASSaverLocateVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public Object visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		for (org.eclipse.ocl.pivot.Class superClass : object.getSuperClasses()) {
			if (superClass.getOwnedBindings().size() > 0) {
				context.addSpecializingElement(object);
				break;
			}
		}
		return null;
	}

	@Override
	public Object visitCollectionType(@NonNull CollectionType object) {
		Type referredType = object.getElementType();
		org.eclipse.ocl.pivot.Class referredClass = referredType != null ? referredType.isClass() : null;
		if (referredClass != null) {
			context.addSpecializingElement(object, referredClass);
		}
		return super.visitCollectionType(object);
	}

	@Override
	public Object visitLambdaType(@NonNull LambdaType object) {
		boolean doneIt = false;
		Type referredType = object.getContextType();
		org.eclipse.ocl.pivot.Class referredClass = referredType != null ? referredType.isClass() : null;
		if ((referredClass != null) && context.addSpecializingElement(object, referredClass)) {
			doneIt = true;
		}
		if (!doneIt) {
			referredType = object.getResultType();
			referredClass = referredType != null ? referredType.isClass() : null;
			if ((referredClass != null) && context.addSpecializingElement(object, referredClass)) {
				doneIt = true;
			}
			if (!doneIt) {
				for (Type parameterType : object.getParameterType()) {
					referredClass = parameterType != null ? parameterType.isClass() : null;
					if ((referredClass != null) && context.addSpecializingElement(object, referredClass)) {
						break;
					}
				}
			}
		}
		return super.visitLambdaType(object);
	}

	@Override
	public Object visitLoopExp(@NonNull LoopExp object) {
		Iteration referredIteration = object.getReferredIteration();
		if (referredIteration != null) {
			context.addSpecializingElement(object, referredIteration);
		}
		return super.visitLoopExp(object);
	}

	@Override
	public Object visitMapType(@NonNull MapType object) {
		Type referredType = object.getKeyType();
		org.eclipse.ocl.pivot.Class referredClass = referredType != null ? referredType.isClass() : null;
		if (referredClass != null) {
			context.addSpecializingElement(object, referredClass);
		}
		referredType = object.getValueType();
		referredClass = referredType != null ? referredType.isClass() : null;
		if (referredClass != null) {
			context.addSpecializingElement(object, referredClass);
		}
		return super.visitMapType(object);
	}

	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp object) {
		Operation referredOperation = object.getReferredOperation();
		if (referredOperation != null) {
			context.addSpecializingElement(object, referredOperation);
		}
		return super.visitOperationCallExp(object);
	}

	@Override
	public Object visitProperty(@NonNull Property object) {
		Property opposite = object.getOpposite();
		if (opposite != null) {
			Resource eResource = opposite.eResource();
			assert eResource != null;
		}
		return super.visitProperty(object);
	}

	@Override
	public Object visitPropertyCallExp(@NonNull PropertyCallExp object) {
		OCLExpression ownedSource = object.getOwnedSource();
		if (ownedSource != null) {
			Property referredProperty = object.getReferredProperty();
			if (referredProperty != null) {
				context.addSpecializingElement(object, referredProperty);
			}
		}
		return super.visitPropertyCallExp(object);
	}

	@Override
	public Object visitTemplateParameter(@NonNull TemplateParameter object) {
		for (org.eclipse.ocl.pivot.Class constrainingType : object.getConstrainingClasses()) {
			if ((constrainingType != null) && context.addSpecializingElement(object, constrainingType)) {
				break;
			}
		}
		return null;
	}

	@Override
	public Object visitTemplateParameterSubstitution(@NonNull TemplateParameterSubstitution object) {
		Type actual = object.getActual();
		org.eclipse.ocl.pivot.Class referredClass = actual != null ? actual.isClass() : null;
		if (referredClass != null) {
			context.addSpecializingElement(object, referredClass);
		}
		return null;
	}

	@Override
	public Object visitTypeExp(@NonNull TypeExp object) {
		Type referredType = object.getReferredType();
		if (referredType instanceof org.eclipse.ocl.pivot.Class) {
			context.addSpecializingElement(object, (org.eclipse.ocl.pivot.Class)referredType);
		}
		return super.visitTypeExp(object);
	}

	@Override
	public Object visitTypedElement(@NonNull TypedElement object) {
		Type referredType = object.getType();
		org.eclipse.ocl.pivot.Class referredClass = referredType != null ? referredType.isClass() : null;
		if (referredClass != null) {
			context.addSpecializingElement(object, referredClass);
		}
		return null;
	}

	@Override
	public Object visiting(@NonNull Visitable visitable) {
		return null;
	}
}
