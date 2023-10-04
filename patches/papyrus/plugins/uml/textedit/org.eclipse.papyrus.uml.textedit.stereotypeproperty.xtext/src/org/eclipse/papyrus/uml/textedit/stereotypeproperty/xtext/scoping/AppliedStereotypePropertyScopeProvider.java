/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.scoping;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.scoping.AlfScopeProvider;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class AppliedStereotypePropertyScopeProvider extends AlfScopeProvider {

	public IScope scope_AppliedStereotypePropertyRule_property(AppliedStereotypePropertyRule ctx, EReference ref) {
		IScope result = null;

		AppliedStereotypeProperty appliedStereotypeProperty = (AppliedStereotypeProperty) ContextElementUtil.getContextElement(ctx.eResource());
		if (appliedStereotypeProperty != null) {
			ArrayList<org.eclipse.uml2.uml.Property> properties = new ArrayList<org.eclipse.uml2.uml.Property>();
			properties.add(appliedStereotypeProperty.getStereotypeProperty());
			Iterable<IEObjectDescription> visiblePropertiesIterable = Scopes.scopedElementsFor(properties);
			result = new SimpleScope(visiblePropertiesIterable);
		}

		return result;
	}

	public IScope scope_PrimaryExpression_prefix(Expression ctx, EReference ref) {
		return null;
	}
}
