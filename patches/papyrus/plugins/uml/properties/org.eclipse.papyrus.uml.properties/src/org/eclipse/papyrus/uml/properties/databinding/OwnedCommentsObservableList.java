/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Observable list for property {@link org.eclipse.uml2.uml.Element#getOwnedElements <em>Owned Element</em>}.
 *
 * @author Gabriel Pascual
 */
public class OwnedCommentsObservableList extends GMFObservableList {

	/**
	 * Constructor.
	 *
	 * @param domain
	 *            the domain
	 * @param source
	 *            the source
	 */
	public OwnedCommentsObservableList(EditingDomain domain, EObject source) {
		super(getOwnedComments(source), domain, source, UMLPackage.eINSTANCE.getElement_OwnedComment());
	}

	/**
	 * Gets the owned comments.
	 *
	 * @param source
	 *            the source
	 * @return the owned comments
	 */
	private static List<Comment> getOwnedComments(EObject source) {
		List<Comment> result = new LinkedList<>();

		if (source instanceof Element) {

			EList<Comment> allOwnedComments = ((Element) source).getOwnedComments();

			// Filter owned comments list
			for (Comment comment : allOwnedComments) {
				if (!comment.getAnnotatedElements().contains(source)) {
					result.add(comment);
				}
			}


		}

		return result;
	}

	/**
	 * <p>
	 * Redefine method to add filtered list.
	 * </p>
	 *
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#refreshCacheList()
	 *
	 */
	@Override
	protected void refreshCacheList() {
		if (isDisposed()) {
			// This observable can be disposed, but the commands might still be
			// in the command stack. Undo() or Redo() will call this method, which
			// should be ignored. The command should probably not call refresh directly ;
			// we should have listeners on the concrete list... but it is not necessarily
			// observable
			return;
		}
		wrappedList.clear();
		wrappedList.addAll(getOwnedComments(source));
		fireListChange(null);
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList#getAddCommand(java.lang.Object)
	 *
	 * @param value
	 * @return
	 */
	@Override
	public Command getAddCommand(Object value) {
		assert value instanceof Comment : "Added value is not a Comment"; //$NON-NLS-1$

		SetRequest setRequest = new SetRequest((TransactionalEditingDomain) editingDomain, source, feature, value);
		return getCommandFromRequests(getProvider(), Collections.singletonList(setRequest));
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList#getRemoveCommand(java.lang.Object)
	 *
	 * @param value
	 * @return
	 */
	@Override
	public Command getRemoveCommand(Object value) {
		assert value instanceof Comment : "Deleted value is not a Comment"; //$NON-NLS-1$

		DestroyElementRequest destroyRequest = new DestroyElementRequest((TransactionalEditingDomain) editingDomain, (EObject) value, false);
		return getCommandFromRequests(getProvider(), Collections.singletonList(destroyRequest));
	}
}
