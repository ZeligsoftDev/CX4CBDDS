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
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.message.xtext.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;


/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class UmlMessageLabelProvider extends DefaultEObjectLabelProvider {

	/**
	 * Instantiates a new uml message label provider.
	 *
	 * @param delegate
	 *            the delegate
	 */
	@Inject
	public UmlMessageLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	/*
	 * //Labels and icons can be computed like this:
	 *
	 * String text(MyModel ele) {
	 * return "my "+ele.getName();
	 * }
	 *
	 * String image(MyModel ele) {
	 * return "MyModel.gif";
	 * }
	 */
}
