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
package org.eclipse.ocl.examples.debug.vm.ui.actions;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ocl.examples.debug.vm.ui.DebugVMUIPlugin;
import org.eclipse.swt.graphics.Image;

public class DebugVMImages
{
	private static final Logger logger = LogManager.getLogger(DebugVMImages.class);

	public static final String CONDITIONAL_BPNT_ENABLED = "conditionalBreakpointEnabled"; //$NON-NLS-1$

	public static final String CONDITIONAL_BPNT_DISABLED = "conditionalBreakpointDisabled"; //$NON-NLS-1$

	public static final String MODEL_PARAMETER = "modelParameter"; //$NON-NLS-1$

	public static final String REFERENCE = "reference"; //$NON-NLS-1$

	public static final String ATTRIBUTE = "attribute"; //$NON-NLS-1$

	public static final String INTERM_PROPERTY = "intermediateProperty"; //$NON-NLS-1$

	public static final String THIS_VARIABLE = "thisVariable"; //$NON-NLS-1$
	
	public static final String PREDEFINED_VARIABLE = "predefinedVariable"; //$NON-NLS-1$

	public static final String LOCAL_VARIABLE = "localVariable"; //$NON-NLS-1$
	
	public static final String COLLECTION_ELEMENT = "collectionElement"; //$NON-NLS-1$
	public static final String EXPRESSION_IN_OCL = "ExpressionInOCL"; //$NON-NLS-1$
	
	private static ImageRegistry fgImageRegistry = DebugVMUIPlugin.getDefault().getImageRegistry();

	protected DebugVMImages() {
		super();
	}

	public static Image getImage(String key) {
		Image image = fgImageRegistry.get(key);
		if (image == null) {
			logger.error("No image for '" + key + "'");
		}
		return image;
	}

}
