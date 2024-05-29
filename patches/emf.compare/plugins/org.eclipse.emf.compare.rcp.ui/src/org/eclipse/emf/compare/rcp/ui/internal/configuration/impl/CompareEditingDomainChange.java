/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration.impl;

import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.ICompareEditingDomainChange;

public class CompareEditingDomainChange extends CompareEvent<ICompareEditingDomain> implements ICompareEditingDomainChange {

	public CompareEditingDomainChange(ICompareEditingDomain oldValue, ICompareEditingDomain newValue) {
		super(oldValue, newValue);
	}
}
