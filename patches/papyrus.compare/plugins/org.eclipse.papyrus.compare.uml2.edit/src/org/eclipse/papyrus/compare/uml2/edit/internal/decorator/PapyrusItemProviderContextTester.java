/*******************************************************************************
 * Copyright (c) 2017 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.edit.internal.decorator;

import java.util.Map;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.adapterfactory.context.AbstractContextTester;
import org.eclipse.papyrus.compare.diagram.ide.ui.internal.context.PapyrusContextUtil;

/**
 * Context Tester for a Papyrus comparison.
 * 
 * @see PapyrusContextUtil#isPapyrusContext(Comparison)
 * @author <a href="mailto:mfleck@eclipsesource.com">Martin Fleck</a>
 */
public class PapyrusItemProviderContextTester extends AbstractContextTester {

	/**
	 * {@inheritDoc}
	 */
	public boolean apply(Map<Object, Object> context) {
		Comparison comparison = getComparison(context);
		return comparison != null && PapyrusContextUtil.isPapyrusContext(comparison);
	}
}
