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
package org.eclipse.papyrus.uml.textedit.property.xtext.ui;

import org.eclipse.papyrus.uml.xtext.integration.PapyrusDefaultAutoEditStrategyProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class UmlPropertyUiModule extends org.eclipse.papyrus.uml.textedit.property.xtext.ui.AbstractUmlPropertyUiModule {
	public UmlPropertyUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.xtext.ui.DefaultUiModule#bindAbstractEditStrategyProvider()
	 */
	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return PapyrusDefaultAutoEditStrategyProvider.class;
	}
}
