/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui.labeling;

import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class UMLConnectionPointReferenceDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	/*
	 * //Labels and icons can be computed like this:
	 *
	 * String text(IEObjectDescription ele) {
	 * return "my "+ele.getName();
	 * }
	 *
	 * String image(IEObjectDescription ele) {
	 * return ele.getEClass().getName() + ".gif";
	 * }
	 */

}
