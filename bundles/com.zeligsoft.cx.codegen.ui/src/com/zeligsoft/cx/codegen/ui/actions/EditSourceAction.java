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
package com.zeligsoft.cx.codegen.ui.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.base.util.ZeligsoftURIConverter;
import com.zeligsoft.cx.codegen.editor.ICodeLocator;
import com.zeligsoft.cx.codegen.editor.IUserEditableElementDescriptor;
import com.zeligsoft.cx.codegen.editor.IValidationFactory;
import com.zeligsoft.cx.codegen.ui.utils.EditSourceJob;

/**
 * An action which executes an XPand rule as specified in cz.codegen.ui.editsource extensions.
 */
public class EditSourceAction extends Action implements IUserEditableElementDescriptor {
	private final EObject element;
	private final IUserEditableElementDescriptor desc;

	public EditSourceAction( String label, EObject element, IUserEditableElementDescriptor desc )
	{
		super( label );
		this.element = element;
		this.desc = desc;
	}

	@Override
	public void run() {
		if( ! PlatformUI.getWorkbench().saveAllEditors( true ) )
			return;

		ZeligsoftURIConverter.install( TransactionUtil.getEditingDomain( element ).getResourceSet() );

		new EditSourceJob( this.element, this ).schedule();
	}

	@Override
	public String getLabel() { return desc.getLabel(); }
	@Override
	public String getConcept() { return desc.getConcept(); }
	@Override
	public String getContainerConcept() { return desc.getContainerConcept(); }
	@Override
	public String getProperty() { return desc.getProperty(); }
	@Override
	public ICodeLocator getCodeLocator() { return desc.getCodeLocator(); }
	@Override
	public IValidationFactory getValidationFactory() { return desc.getValidationFactory(); }
	
	@Override
	public Iterable<IM2MTransformationDescriptor> getM2MDescriptors() { return desc.getM2MDescriptors(); }
	@Override
	public Iterable<IM2TTransformationDescriptor> getM2TDescriptors() { return desc.getM2TDescriptors(); }
}
