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

import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * Decorator adapter factory for Papyrus UML elements.
 * 
 * @author <a href="mailto:mfleck@eclipsesource.com">Martin Fleck</a>
 */
public class PapyrusItemProviderAdapterFactoryDecorator extends DecoratorAdapterFactory {

	/**
	 * Creates a new instance.
	 */
	public PapyrusItemProviderAdapterFactoryDecorator() {
		super(new UMLItemProviderAdapterFactory());
	}

	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target, Object type) {
		return new PapyrusItemProviderDecorator(this);
	}
}
