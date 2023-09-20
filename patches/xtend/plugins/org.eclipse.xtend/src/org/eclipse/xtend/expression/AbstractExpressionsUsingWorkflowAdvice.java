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
package org.eclipse.xtend.expression;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.ao.AbstractWorkflowAdvice;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;

/**
 * Base class for workflow advices for components which use expressions.
 * 
 * @author Karsten Thoms
 * @since 4.3.1
 */
public abstract class AbstractExpressionsUsingWorkflowAdvice extends AbstractWorkflowAdvice {
	protected final List<MetaModel> metaModels = new ArrayList<MetaModel>();

	private final List<GlobalVarDef> globalVarDefs = new ArrayList<GlobalVarDef>();

	/**
	 * Adds a metamodel.
	 * 
	 * @param metaModel
	 *            the metamodel.
	 */
	public void addMetaModel(final MetaModel metaModel) {
		assert metaModel != null;
		metaModels.add(metaModel);
	}

	/**
	 * Adds a global variable definition.
	 * 
	 * @param def
	 *            the definition
	 */
	public void addGlobalVarDef(final GlobalVarDef def) {
		globalVarDefs.add(def);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void weave(final WorkflowComponent c, final Issues issues) {
		if (!(c instanceof AbstractExpressionsUsingWorkflowComponent)) {
			issues.addError(this, "advice target is not a expression based WorkflowComponent component.");
		} else {
			AbstractExpressionsUsingWorkflowComponent wc = (AbstractExpressionsUsingWorkflowComponent) c;
			for (MetaModel metamodel : metaModels) {
				wc.addMetaModel(metamodel);
			}
			for (GlobalVarDef globalVar : globalVarDefs) {
				wc.addGlobalVarDef(globalVar);
			}
		}
	}
}
