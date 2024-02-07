/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An extended interface allowing validators to generate custom diagnostics.
 */
//FIXME this class will be obsoleted by Bug 337792 resolution 
public interface ValidationDelegateExtension extends EValidator.ValidationDelegate //, EValidator.ValidationDelegate.Extension
{
    /**
     * Evaluates the given constraint expression against the object in the given context.
     * @return the result of the expression evaluation.
     */
    boolean validate(@NonNull EClass eClass, @NonNull EObject eObject, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context, @NonNull String constraint, String expression, int severity, String source, int code);

    /**
     * Evaluates the given invariant expression against the object in the given context.
     * @return the result of the expression evaluation.
     */
    boolean validate(@NonNull EClass eClass, @NonNull EObject eObject, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context, @NonNull EOperation invariant, String expression, int severity, String source, int code);

    /**
     * Evaluates the given constraint expression against the value in the given context.
     * @return the result of the expression evaluation.
     */
    boolean validate(@NonNull EDataType eDataType, @NonNull Object value, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context, @NonNull String constraint, String expression, int severity, String source, int code);
}