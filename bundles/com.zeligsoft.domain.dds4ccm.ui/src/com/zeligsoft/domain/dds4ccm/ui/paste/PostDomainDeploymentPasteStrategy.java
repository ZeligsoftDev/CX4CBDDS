/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.paste;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.AbstractPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.DefaultPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.Activator;

/**
 * Post UML paste strategy to load reference value in the right context
 * 
 * @author Young-Soo Roh
 *
 */
public class PostDomainDeploymentPasteStrategy extends AbstractPasteStrategy implements IPasteStrategy {

	/** The instance. */
	private static IPasteStrategy instance = new PostDomainDeploymentPasteStrategy();


	/**
	 * Gets the single instance of PostUMLPasteStrategy.
	 *
	 * @return single instance of PostUMLPasteStrategy
	 */
	public static IPasteStrategy getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getLabel()
	 */
	@Override
	public String getLabel() {
		return "PostDomainDeploymentPasteStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getID(
	 * )
	 */
	@Override
	public String getID() {
		return Activator.PLUGIN_ID + ".PostDomainDeploymentPasteStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getDescription()
	 */
	@Override
	public String getDescription() {
		return "Post DomainDeployment Paste Strategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * dependsOn()
	 */
	@Override
	public IPasteStrategy dependsOn() {
		return DefaultPasteStrategy.getInstance();
	}

	@Override
	public int getPriority() {
		// This strategy runs after the <code>PostStereotypePasteStrategy</code>
		return 102;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#
	 * getSemanticCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.emf.ecore.EObject,
	 * org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public org.eclipse.emf.common.command.Command getSemanticCommand(EditingDomain domain, EObject targetOwner,
			PapyrusClipboard<Object> papyrusClipboard) {
		if (targetOwner instanceof Element && ZDLUtil.isZDLConcept(targetOwner, DDS4CCMNames.DOMAIN_DEFINITION)) {
			List<Element> elements = new ArrayList<Element>();
			for (Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				if (object instanceof Element && !(object instanceof Package)) {
					// get target Element
					EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
					elements.add((Element) target);
				}
			}

			if (elements.isEmpty()) {
				return null;
			}
			
			RecordingCommand command = new RecordingCommand(TransactionUtil.getEditingDomain(targetOwner)) {

				@SuppressWarnings({ "unchecked" })
				@Override
				protected void doExecute() {
					for (Element element : elements) {
						if (ZDLUtil.isZDLConcept(element, DDS4CCMNames.DOMAIN_DEPLOYMENT)) {
							Component domainDeployment = (Component)element;
							EList<EObject> deployments = (EList<EObject>) ZDLUtil.getValue(domainDeployment.getOwner(),
									DDS4CCMNames.DOMAIN_DEFINITION, DDS4CCMNames.DOMAIN_DEFINITION__DEPLOYMENTS);
							if (!deployments.contains(domainDeployment)) {
								deployments.add(domainDeployment);
							}
						}
					}
				}
			};

			return command;
		}
		return null;

	}

	@Override
	public org.eclipse.gef.commands.Command getGraphicalCommand(EditingDomain domain, GraphicalEditPart targetEditPart,
			PapyrusClipboard<Object> papyrusClipboard) {
		return null;
	}

}