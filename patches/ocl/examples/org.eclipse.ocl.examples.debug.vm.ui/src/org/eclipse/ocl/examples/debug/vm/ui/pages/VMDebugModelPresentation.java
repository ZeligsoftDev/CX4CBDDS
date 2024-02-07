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
package org.eclipse.ocl.examples.debug.vm.ui.pages;

import java.text.MessageFormat;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IDebugModelPresentationExtension;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugTarget;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.core.VMStackFrame;
import org.eclipse.ocl.examples.debug.vm.core.VMThread;
import org.eclipse.ocl.examples.debug.vm.core.VMValue;
import org.eclipse.ocl.examples.debug.vm.core.VMVariable;
import org.eclipse.ocl.examples.debug.vm.data.VMLocationData;
import org.eclipse.ocl.examples.debug.vm.ui.DebugVMUIPlugin;
import org.eclipse.ocl.examples.debug.vm.ui.actions.DebugVMImages;
import org.eclipse.ocl.examples.debug.vm.ui.messages.DebugVMUIMessages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput;


public abstract class VMDebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation, IDebugModelPresentationExtension, IColorProvider, ILabelProvider
{
	@Override
	public void setAttribute(String attribute, Object value) {
	}

	@Override
	public Image getImage(Object element) {
		//    	System.out.println("getImage: " + element.getClass().getSimpleName() + " " + element);
		if (element instanceof VMDebugTarget) {
			return DebugVMImages.getImage(DebugVMImages.EXPRESSION_IN_OCL);
		}
		else if (element instanceof VMThread) {
			return null;
		}
		else if (element instanceof VMStackFrame) {
			return null;
			/*        	VMStackFrame frame = (VMStackFrame) element;
    		VMLocationData location = frame.getLocation();
    		String elementSignature = location.getElementSignature();
            if (elementSignature != null) {
    			return OCLDebugImages.getImage(OCLDebugImages.MAPPING);
            }
            else {
    			return OCLDebugImages.getImage(OCLDebugImages.EXPRESSION_IN_OCL);
            } */
		}
		else if(element instanceof VMVariable) {
			VMVariable var = (VMVariable) element;
			if (var.isModelParameter()) {
				return DebugVMImages.getImage(DebugVMImages.MODEL_PARAMETER);
			} else if (var.isReference()) {
				return DebugVMImages.getImage(DebugVMImages.REFERENCE);
			} else if (var.isAttribute()) {
				return DebugVMImages.getImage(DebugVMImages.ATTRIBUTE);
			} else if (var.isIntermProperty()) {
				return DebugVMImages.getImage(DebugVMImages.INTERM_PROPERTY);
			} else if (var.isLocalVariable()) {
				return DebugVMImages.getImage(DebugVMImages.LOCAL_VARIABLE);
			} else if (var.isPredefinedVariable()) {
				// TODO - add special case for this
				try {
					if("this".equals(var.getName())) { //$NON-NLS-1$
						return DebugVMImages.getImage(DebugVMImages.THIS_VARIABLE);
					}
				} catch (DebugException e) {
					// do nothing use the std image
				}
				return DebugVMImages.getImage(DebugVMImages.PREDEFINED_VARIABLE);
			} else if(var.isCollectionElement()) {
				return DebugVMImages.getImage(DebugVMImages.COLLECTION_ELEMENT);
			}

		} else if (element instanceof VMLineBreakpoint) {
			VMLineBreakpoint breakpoint = (VMLineBreakpoint) element;
			try {
				if (breakpoint.isConditionEnabled()) {
					return breakpoint.isEnabled() ?
							DebugVMImages.getImage(DebugVMImages.CONDITIONAL_BPNT_ENABLED) :
								DebugVMImages.getImage(DebugVMImages.CONDITIONAL_BPNT_DISABLED);
				}
			} catch (CoreException ex) {
				DebugVMUIPlugin.log(ex);
			}
		}
		return null;
	}

	public String getText(Object element) {
		//		System.out.println("getText: " + element.getClass().getSimpleName() + " " + element);
		if (element instanceof VMDebugTarget) {
			VMDebugTarget debugTarget = (VMDebugTarget) element;
			String moduleName = debugTarget.getMainModuleName();
			String launchConfigName = debugTarget.getLaunch().getLaunchConfiguration().getName();
			return NLS.bind(DebugVMUIMessages.DebugModelPresentation_ExpressionInOCLLabel, moduleName, launchConfigName);
		}
		else if (element instanceof VMThread) {
			VMThread thread = (VMThread) element;
			String name = "main"; //$NON-NLS-1$
			String state = thread.isSuspended() ? DebugVMUIMessages.DebugModelPresentation_Suspended : DebugVMUIMessages.DebugModelPresentation_Running;
			return MessageFormat.format(DebugVMUIMessages.DebugModelPresentation_ThreadLabel, name, state);
		}
		else if (element instanceof VMStackFrame) {
			VMStackFrame frame = (VMStackFrame) element;
			VMLocationData location = frame.getLocation();
			int line = frame.getLineNumber();
			StringBuilder s = new StringBuilder();
			String elementSignature = location.getElementSignature();
			if (elementSignature != null) {
				s.append(elementSignature);
				s.append(" - ");
			}
			s.append(location.getModule());
			s.append(" line: ");
			s.append(line);
			return s.toString();
		}
		return null;
	}

	public void computeDetail(IValue value, IValueDetailListener listener) {
		if(value instanceof VMValue) {
			VMValue vmValue = (VMValue) value;
			try {
				listener.detailComputed(value, vmValue.computeDetail());
			} catch (DebugException e) {
				DebugVMUIPlugin.log(e.getStatus());
			}
		} else {
			listener.detailComputed(value, value.toString());
		}
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public IEditorInput getEditorInput(Object element) {
		if (element instanceof IFile) {
			return new FileEditorInput((IFile) element);
		}
		else if (element instanceof ILineBreakpoint) {
			return new FileEditorInput((IFile) ((ILineBreakpoint) element).getMarker().getResource());
		}
		else if (element instanceof IStorage) {
			return new XtextReadonlyEditorInput((IStorage) element);
		}
		else {
			return null;
		}
	}

	@Override
	public Color getForeground(Object element) {
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		return null;
	}

	@Override
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		return false;
	}

	@Override
	public void removeAnnotations(IEditorPart editorPart, IThread thread) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean requiresUIThread(Object element) {
		return true;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}
}
