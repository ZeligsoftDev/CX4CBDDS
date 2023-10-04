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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.uml.textedit.common.xtext.scoping.UmlCommonScopeProvider;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.xtext.scoping.IScope;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class UmlCollaborationUseScopeProvider extends UmlCommonScopeProvider {

	/**
	 *
	 * Constructor.
	 *
	 */
	public UmlCollaborationUseScopeProvider() {
		super();
	}

	/**
	 * Rule for computing the scope of PropertyRule
	 *
	 * @param ctx
	 *
	 * @param ref
	 * @return
	 */
	public IScope scope_TypeRule_type(org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule ctx, EReference ref) {
		return create___TypeRule_type___Scope(ctx);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.scoping.UmlCommonScopeProvider#isWantedType(org.eclipse.uml2.uml.Element)
	 *
	 * @param e
	 * @return
	 */
	@Override
	protected boolean isWantedType(Element e) {
		return e instanceof Collaboration;
	}
}
