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
package com.zeligsoft.domain.dds4ccm.ui.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Direct editor parser
 * 
 * @author Young-Soo Roh
 *
 */
public class CXDirectEditorParser implements IParser {

	private String textToEdit;

	public CXDirectEditorParser(final String textToEdit) {
		this.textToEdit = textToEdit;
	}

	@Override
	public String getEditString(final IAdaptable element, final int flags) {
		return textToEdit;
	}

	/**
	 * Simple rename of element created without invoking the validation to avoid issue
	 * described in https://github.com/ZeligsoftDev/CX4CBDDS/issues/309
	 */
	@Override
	public ICommand getParseCommand(final IAdaptable element, final String newString, final int flags) {
		CompositeCommand compositeCommand = new CompositeCommand("Rename"); //$NON-NLS-1$

		EObject eObjectElement = element.getAdapter(EObject.class);

		if (eObjectElement instanceof NamedElement) {
			if (null != newString && !newString.isEmpty()) {

				SetRequest setRequest = new SetRequest(eObjectElement, UMLPackage.eINSTANCE.getNamedElement_Name(),
						newString);

				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(eObjectElement);
				ICommand editCommand = provider.getEditCommand(setRequest);

				compositeCommand.add(editCommand);
			}
		}

		return compositeCommand;
	}

	@Override
	public String getPrintString(final IAdaptable element, final int flags) {
		return textToEdit;
	}

	@Override
	public boolean isAffectingEvent(final Object event, final int flags) {
		return false;
	}

	/**
	 * Not used by CX direct editor
	 */
	@Override
	public IContentAssistProcessor getCompletionProcessor(final IAdaptable element) {
		return null;
	}

	/**
	 * Return default IParserStatus
	 */
	@Override
	public IParserEditStatus isValidEditString(final IAdaptable element, final String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}
}
