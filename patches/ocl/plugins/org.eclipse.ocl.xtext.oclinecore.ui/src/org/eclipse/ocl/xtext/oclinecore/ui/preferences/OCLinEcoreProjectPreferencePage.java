/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui.preferences;

import java.util.List;

import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.common.ui.internal.messages.CommonUIMessages;
import org.eclipse.ocl.common.ui.internal.preferences.AbstractProjectPreferencePage;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.options.OCLinEcoreOptions;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * The Project/Property preference page for the OCLinEcore options.
 */
public class OCLinEcoreProjectPreferencePage extends AbstractProjectPreferencePage
{

	public OCLinEcoreProjectPreferencePage() {
		super(PivotConstantsInternal.PLUGIN_ID, OCLinEcoreUIMessages.OCLinEcore_PageTitle);
	}

	@Override
	protected AbstractProjectPreferencePage createClonePage() {
		return new OCLinEcoreProjectPreferencePage();
	}

	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	@Override
	protected void createFieldEditors(Composite fieldEditorParent, List<IFieldEditor> fields) {
		Label horizontalLine= new Label(fieldEditorParent, SWT.SEPARATOR | SWT.HORIZONTAL);
		horizontalLine.setLayoutData(new GridData(GridData.FILL, GridData.FILL, false, false, 2, 1));
		horizontalLine.setFont(fieldEditorParent.getFont());
		fields.add(new MyComboFieldEditor(OCLinEcoreOptions.EXPORT_DELEGATION_URI,
			OCLinEcoreUIMessages.OCLinEcore_EditorDelegationMode, ElementUtil.getDelegateURIs(), fieldEditorParent,
			"OCL embedded within an Ecore model can be executed using the Unified or Classic OCL functionality.\n" +
			"This preference determines what form of execution is specified when the OCLinEcore saves to an Ecore file.\n" +
			OCLConstants.OCL_DELEGATE_URI_LPG + " specifies use of the Classic LPG-based engine.\n" +
			OCLConstants.OCL_DELEGATE_URI_PIVOT + " specifies use of the Unified Xtext-based engine.\n" +
			OCLConstants.OCL_DELEGATE_URI_DEBUG + " specifies use of the Unified Xtext-based debugger.\n" +
			"The virtual " + OCLConstants.OCL_DELEGATE_URI + " defers the decision until execution at which point\n" +
			"the \"" + CommonUIMessages.DefaultDelegationMode + "\" preferennce selects the engine."));
	}
}