/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.cx.ui.edithelpers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.toolingmodel.CreateAction;
import com.zeligsoft.base.toolingmodel.Expression;
import com.zeligsoft.base.toolingmodel.MenuItem;
import com.zeligsoft.base.toolingmodel.MenuModel;
import com.zeligsoft.base.toolingmodel.OawExpression;
import com.zeligsoft.base.toolingmodel.OawXtend;
import com.zeligsoft.base.ui.l10n.Messages;
import com.zeligsoft.base.ui.menus.util.CXMenuUtil;
import com.zeligsoft.base.ui.providers.ZDLPaletteFactory;
import com.zeligsoft.base.zdl.util.OawEvaluationUtil;
import com.zeligsoft.base.zdl.util.OawEvaluationUtil.OawDescriptor;
import com.zeligsoft.base.zdl.util.OawEvaluationUtil.OawExpressionDescriptor;
import com.zeligsoft.base.zdl.util.OawEvaluationUtil.OawXtendDescriptor;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Generic edit helper to execute OAW expression associated with the concept of
 * the newly created element. OAW expression from the menu model is used not
 * from the palette entry. See bug# 15776
 * 
 * @author ysroh
 * 
 */
public class DomainConfigurationEditHelperAdvice extends
		AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(final CreateElementRequest request) {
		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"Configure Domain Element", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newElement = request.getNewElement();
				if (newElement == null
						|| ZDLUtil.getZDLConcepts(newElement).isEmpty()) {
					return CommandResult.newOKCommandResult();
				}
				String concept = ZDLUtil.getZDLConcepts(newElement).get(0)
						.getQualifiedName();

				Collection<Profile> profiles = ZDLUtil
						.getZDLProfiles((Element) newElement);
				if (profiles.isEmpty()) {
					return CommandResult.newOKCommandResult();
				}

				// Run configuration from palette entry
				@SuppressWarnings("unchecked")
				List<OawDescriptor> paletteExpressions = (List<OawDescriptor>) request
						.getParameter(ZDLPaletteFactory.CONFIGURE_EXPRESSIONS);
				Set<String> rawPaletteExpressions = new HashSet<String>();

				if (paletteExpressions != null && !paletteExpressions.isEmpty()) {
					for (OawDescriptor oed : paletteExpressions) {
						oed.setObj(newElement);
						OawEvaluationUtil.INSTANCE.evaluate(oed);
						if (oed instanceof OawXtendDescriptor) {
							rawPaletteExpressions.add(oed.getExpression()
									.get(0)
									+ "::" //$NON-NLS-1$
									+ ((OawXtendDescriptor) oed).getExtFile());
						} else if (oed instanceof OawExpressionDescriptor) {
							rawPaletteExpressions.add(oed.getExpression()
									.get(0)
									+ "::" //$NON-NLS-1$
									+ ((OawExpressionDescriptor) oed)
											.getVariableName());
						}
					}
				}

				// Run configuration from menu model
				MenuModel menuModel = CXMenuUtil.getMenuModel(profiles
						.iterator().next());
				if (menuModel == null) {
					return CommandResult.newOKCommandResult();
				}
				for (MenuItem item : menuModel.getItem()) {
					// only create menu actions have OAW expressions
					if (item instanceof CreateAction) {
						CreateAction action = (CreateAction) item;
						// find menu action that creates this element
						if (action.getCreateConcept() != null
								&& action.getCreateConcept().equals(concept)) {
							if (action.getExpression() == null) {
								break;
							}
							for (Expression rawexpr : action.getExpression()) {
								OawDescriptor descriptor = null;
								if (rawexpr instanceof OawXtend) {
									OawXtend expr = (OawXtend) rawexpr;
									// Check if this expression has been already
									// run by palette entry
									if (rawPaletteExpressions.contains(expr
											.getExpression()
											+ "::" //$NON-NLS-1$
											+ expr.getExtensionFile())) {
										continue;
									}
									descriptor = new OawXtendDescriptor(
											newElement,
											Collections.singletonList(expr
													.getExpression()),
											expr.getMetamodel(),
											expr.getExtensionFile());

								} else if (rawexpr instanceof OawExpression) {
									OawExpression expr = (OawExpression) rawexpr;
									// Check if this expression has been already
									// run by palette entry
									if (rawPaletteExpressions.contains(expr
											.getExpression()
											+ "::" //$NON-NLS-1$
											+ expr.getVariableName())) {
										continue;
									}
									descriptor = new OawExpressionDescriptor(
											newElement,
											Collections.singletonList(expr
													.getExpression()),
											expr.getMetamodel(),
											expr.getVariableName());
								}
								if (descriptor != null) {
									OawEvaluationUtil.INSTANCE
											.evaluate(descriptor);
								}
							}
							break;
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ICommand getAfterCreateRelationshipCommand(
			final CreateRelationshipRequest request) {
		final List<OawDescriptor> expressions = (List<OawDescriptor>) request
				.getParameter(ZDLPaletteFactory.CONFIGURE_EXPRESSIONS);

		if (expressions != null && !expressions.isEmpty()) {
			return new AbstractTransactionalCommand(
					request.getEditingDomain(),
					Messages.CommandLabel_PaletteEditHelperAdvice_getAfterCreateCommand,
					null) {
				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor progressMonitor, IAdaptable info)
						throws ExecutionException {
					Element element2Configure = (Element) request
							.getNewElement();

					// Evaluate expressions of palette's connection tool entry
					for (OawDescriptor oed : expressions) {
						oed.setObj(element2Configure);
						OawEvaluationUtil.INSTANCE.evaluate(oed);
					}

					return CommandResult.newOKCommandResult(element2Configure);
				}
			};
		} else {
			return super.getAfterCreateRelationshipCommand(request);
		}
	}
}
