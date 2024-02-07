/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Dirk Fauth <dirk.fauth@googlemail.com> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.nebula.widgets.nattable.formula.function;

/**
 * Implementations of this interface are intended to perform operations on other
 * values. Therefore it needs to be possible to add {@link FunctionValue}s.
 *
 * @since 1.4
 */
public interface OperatorFunctionValue {

    /**
     * Add the given {@link FunctionValue} for calculation.
     * 
     * @param value
     *            The value to add.
     */
    void addFunctionValue(FunctionValue value);
}
