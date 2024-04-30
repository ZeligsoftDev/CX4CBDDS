/*******************************************************************************
 * Copyright (c) 2012, 2015 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - introduced model update strategy provider (bug 457117)
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.IModelUpdateStrategy;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.IModelUpdateStrategyProvider;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.SingleValuedAttributeModelUpdateStrategy;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.StringAttributeChangeAccessor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * A specific {@link org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory} for
 * string-typed {@link AttributeChange} objects.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class StringAttributeChangeAccessorFactory extends AbstractAccessorFactory implements IModelUpdateStrategyProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#isFactoryFor(java.lang.Object)
	 */
	public boolean isFactoryFor(Object target) {
		if (target instanceof AttributeChange) {
			EAttribute attribute = ((AttributeChange)target).getAttribute();
			return attribute.getEAttributeType().getInstanceClass() == String.class && !attribute.isMany();
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createLeft(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createLeft(AdapterFactory adapterFactory, Object target) {
		AttributeChange attributeChange = (AttributeChange)target;
		EObject left = attributeChange.getMatch().getLeft();
		if (left != null) {
			return new StringAttributeChangeAccessor(left, (AttributeChange)target);
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createRight(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createRight(AdapterFactory adapterFactory, Object target) {
		AttributeChange attributeChange = (AttributeChange)target;
		EObject right = attributeChange.getMatch().getRight();
		if (right != null) {
			return new StringAttributeChangeAccessor(right, (AttributeChange)target);
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createAncestor(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createAncestor(AdapterFactory adapterFactory, Object target) {
		AttributeChange attributeChange = (AttributeChange)target;
		EObject ancestor = attributeChange.getMatch().getOrigin();
		if (ancestor != null) {
			return new StringAttributeChangeAccessor(ancestor, (AttributeChange)target);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see IModelUpdateStrategyProvider#getModelUpdateStrategy()
	 */
	public IModelUpdateStrategy getModelUpdateStrategy() {
		return new SingleValuedAttributeModelUpdateStrategy();
	}
}
