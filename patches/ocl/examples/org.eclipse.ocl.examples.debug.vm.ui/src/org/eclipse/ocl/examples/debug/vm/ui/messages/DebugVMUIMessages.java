/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.ui.messages;

import org.eclipse.osgi.util.NLS;

public class DebugVMUIMessages
{
	static {
		NLS.initializeMessages(DebugVMUIMessages.class.getName(), DebugVMUIMessages.class);
	}

	public static String StatusDialog_Error;
	public static String StatusDialog_Warning;
	public static String StatusDialog_Information;

	public static String BreakpointConditionEditor_EnterCondition;

	public static String BreakpointPage_CancelBreakpointCreationError;
	public static String BreakpointPage_CreateBreakpointForModule;
	public static String BreakpointPage_Enabled;
	public static String BreakpointPage_HitCount;
	public static String BreakpointPage_HitCountErrorMessage;
	public static String BreakpointPage_Module;
	public static String BreakpointPage_ModulePrepareBreakpoint;

	public static String BreakpointProperties_RulerActionLabel;

	public static String DebugModelPresentation_ExpressionInOCLLabel;
	public static String DebugModelPresentation_Running;
	public static String DebugModelPresentation_Suspended;
	public static String DebugModelPresentation_ThreadLabel;

	public static String LineBreakpointPage_ConditionTrue;
	public static String LineBreakpointPage_ConditionValueChange;
	public static String LineBreakpointPage_EnableCondition;
	public static String LineBreakpointPage_LineBreakpoint;
	public static String LineBreakpointPage_LineNumber;
	public static String LineBreakpointPage_SuspendCondition;

	public static String RunToLineAdapter_invalidLocation;

	public static String RunToLineAdapter_runFailed;

	public static String RunToLineAdapter_NoFile;
	public static String RunToLineAdapter_NoDocument;
	public static String RunToLineAdapter_NoInput;

	public static String ToggleBreakpointAdapter_VerifyBreakpointJob;
	public static String ToggleBreakpointAdapter_CannotSetBreakpoint;
}
