/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.expression.codeassist;

import java.util.Set;

import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.StaticProperty;
import org.eclipse.xtend.typesystem.Type;

public interface ProposalFactory {
	public Object createPropertyProposal(Property p, String prefix, boolean onCollection);

	/**
	 * Creates an proposal for a static property
	 * 
	 * @param p
	 *            The property for which a proposal should be created
	 * @param prefix
	 *            Current evaluation text prefix
	 * @param onCollection
	 *            <code>true</code>: Proposal is computed on a collection
	 * @return A proposal for the content assist
	 */
	public Object createStaticPropertyProposal(StaticProperty p, String prefix, boolean onCollection);

	public Object createOperationProposal(Operation p, String prefix, boolean onCollection);

	public Object createCollectionSpecificOperationProposal(String insertString, String displayString, String prefix,
			int cursor, int marked);

	public Object createDefinitionProposal(final String insertStr, final String displayStr, final String prefix);

	public Object createExtensionProposal(Extension p, String prefix);

	public Object createExtensionOnMemberPositionProposal(Extension p, String prefix, boolean onCollection);

	public Object createVariableProposal(String name, Type t, String prefix);

	public Object createTypeProposal(String insertString, Type type, String prefix);

	public Object createNamespaceProposal(final String insertStr, final String displayStr, final String prefix);

	public Object createStatementProposal(String insertString, String displayString, String prefix, int cursor,
			int marked);

	public Object createStatementProposal(String insertString, String displayString, String prefix);

	public Object createKeywordProposal(String insertString, String displayString, String prefix);

	public Object createExtensionImportProposal(final String insertStr, final String displayStr, final String prefix,
			final int cursor, final int marked);

	public boolean isDuplicate(Set<String> nameCache, Object proposal);

	public void addToCache(Set<String> nameCache, Object proposal);
}
