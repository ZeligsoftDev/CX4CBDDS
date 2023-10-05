/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.scoping;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;


/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 *
 */
public class UmlValueSpecificationScopeProvider extends org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider {

	/**
	 * This allow to define the scope for the instance specification of the abstract rule.
	 * 
	 * @param ctx
	 *            The abstract rule context.
	 * @param ref
	 *            The reference.
	 * @return The scope representing the instance specification in the model.
	 */
	public IScope scope_AbstractRule_instanceSpecification(final AbstractRule ctx, final EReference ref) {
		EObject contextElement = ContextElementUtil.getContextElement(ctx.eResource());

		Collection<InstanceSpecification> instanceSpecification = EMFHelper.allInstances(contextElement.eResource(), InstanceSpecification.class);
		
		final Iterable<IEObjectDescription> visibleClassifiers = Scopes.scopedElementsFor(instanceSpecification);
		return new SimpleScope(visibleClassifiers);
	}
}
