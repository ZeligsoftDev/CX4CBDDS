/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.xtext.markupcs.FigureElement;
import org.eclipse.ocl.xtext.markupcs.MarkupPackage;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class MarkupScopeProvider extends AbstractDeclarativeScopeProvider {

	@Override
	public IScope getScope(final EObject context, EReference reference) {
		if (reference == MarkupPackage.Literals.FIGURE_REF_ELEMENT__REF) {
			return new AbstractScope(IScope.NULLSCOPE, false)
			{
				@Override
				protected Iterable<IEObjectDescription> getAllLocalElements() {
					List<IEObjectDescription> allFigures = new ArrayList<IEObjectDescription>();
					for (TreeIterator<Notifier> tit = context.eResource().getResourceSet().getAllContents(); tit.hasNext(); ) {
						Notifier eObject = tit.next();
						if (eObject instanceof FigureElement) {
							FigureElement figureElement = (FigureElement)eObject;
							allFigures.add(EObjectDescription.create(figureElement.getDef(), figureElement));
						}
					}
					return allFigures;
				}
			};
		}
		return super.getScope(context, reference);
	}

}
