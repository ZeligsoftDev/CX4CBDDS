/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/

package com.zeligsoft.ddk.zdl.zdlgen.adapter;

/**
 * The list of imported modules
 */
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.ILiveValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.zeligsoft.ddk.zdl.zdlgen.presentation.ZDLGenEditor;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.ZDLGenEditorPlugin;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.l10.Messages;

/**
 * 
 * @author Annie Valade
 * A content adapter that enables live validation for zdlgen models.
 */
public class ZDLGenLiveValidationContentAdapter extends EContentAdapter
{
	// The live validator
	ILiveValidator _validator = null;
	
	// The editor containing the element that initiated validation.
	ZDLGenEditor _editor = null;
	
	/**
	 * Build a content adpater from the zdlgen editor.
	 * @param editor
	 */
	public ZDLGenLiveValidationContentAdapter(ZDLGenEditor editor)
	{
		_editor = editor;
	}

	/**
	 * Notify when an element property is changed
	 */
	@Override
	public void notifyChanged(final Notification notification)
	{
		super.notifyChanged(notification);
		
		final Shell shell = this._editor.getSite().getShell();
		shell.getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				// Call the live validation
				if(_validator == null)
				{
					_validator = (ILiveValidator)ModelValidationService.getInstance().newValidator(EvaluationMode.LIVE);
				}
				IStatus status = _validator.validate(notification);
				if(!status.isOK())
				{
					if(status.getSeverity() == IStatus.ERROR)
					{
						MessageDialog.openError(shell, Messages.live_validation_title,
								status.getMessage());
					}
					else
					{
						MessageDialog.openWarning(shell, Messages.live_validation_title,
								status.getMessage());
					}
					
					// Print errors and warnings to the problems window
					Set<Object> errorSelections = new HashSet<Object>();
					if (!status.isMultiStatus()) {
						IConstraintStatus cstatus = (IConstraintStatus)status;
						errorSelections.add(cstatus.getTarget());
					} else {
						IStatus[] children = status.getChildren();
						for (int i = 0; i<children.length; i++) {
							IConstraintStatus cstatus = (IConstraintStatus)children[i];
							errorSelections.add(cstatus.getTarget());
						}
					}
					_editor.setSelectionToViewer(errorSelections);
					
					// Decorate the zdl gen model.
					try {
						MarkerUtil.createMarkers(status);
					} catch (CoreException e) {
						IStatus errorStatus = new Status(IStatus.ERROR, 
								ZDLGenEditorPlugin.getPlugin().getSymbolicName(), 
									Messages.ZDLGenLiveValidationContentAdapter_Error_DecoratingModel, e);
						ZDLGenEditorPlugin.getPlugin().getLog().log(errorStatus);
					}
				}
				else
				{
					_editor.setSelectionToViewer(new HashSet<Object>());
				}
			}
		});
	}
}
