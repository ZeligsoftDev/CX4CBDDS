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
package org.eclipse.ocl.examples.debug.vm;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.IModuleSourceInfo;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;


public class UnitLocation {
	
	private static final int UNDEF_LINE_NUM = -2;
	
/*	private static int calcStackDepth(IDebugEvaluationEnvironment currentEvalEnv) {
		// FIXME - move to core OCL into EvaluationEnv
		int depth = 0;
		IDebugEvaluationEnvironment evalEnv = currentEvalEnv;
		while (evalEnv != null) {			
			depth += evalEnv.getDepth();
			evalEnv = null; //EvaluationUtil.getAggregatingContext(evalEnv);
		}
		return depth;
	} */
	
	private int fLineNum = UNDEF_LINE_NUM;
	private final int startPosition;
	private final int endPosition;
	private final int fDepth;	
	
    private final Element fElement;
    private final @NonNull NamedElement fModule;    
    private final NamedElement fOperation;
    private final @NonNull VMEvaluationEnvironment fEvalEnv;    
	private IModuleSourceInfo fSrcInfo;
	
	public UnitLocation(int startPosition, int endPosition, @NonNull VMEvaluationEnvironment evalEnv, @NonNull Element element) {
		fEvalEnv = evalEnv;
		fElement = element;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		fDepth = evalEnv.getDepth();
		fOperation = evalEnv.getOperation();
		
		EObject rootContainer = EcoreUtil.getRootContainer(fEvalEnv.getDebuggableElement());
		assert rootContainer instanceof NamedElement;
		fModule = (NamedElement) rootContainer;
//		if (currentInstance != null) {
//			fModule = currentInstance.getInstantiatedType();			 
//		} else if (element instanceof Type) {
//			// TODO - debugging before module instance get created & initialized into evaluation
//			// environment => for now, derive from the past AST element
//			fModule = (Type) element;
//		} else {
//			throw new IllegalArgumentException("Module-less evaluation environment"); //$NON-NLS-1$
//		}
	}

	public boolean isDeferredExecution() {
		return fEvalEnv.isDeferredExecution();
	}

    public URI getURI() {
    	return getSourceInfo().getSourceURI();
	}
    
    public @NonNull NamedElement getModule() {
    	return fModule;
    }
    
    public NamedElement getOperation() {
        return fOperation;
    }
    
	public @NonNull VMEvaluationEnvironment getEvalEnv() {
		return fEvalEnv;
	} 
	
	public int getEndPosition() {
		return endPosition;
	}
	
	public int getLineNum() {
		if(fLineNum == UNDEF_LINE_NUM) {
			int newLine = -1;
			if (startPosition >= 0) {
				newLine = getSourceInfo().getLineNumberProvider().getLineNumber(startPosition);				
			}
			
			return fLineNum = newLine;
		}

		return fLineNum;
	}
	
	public int getStartPosition() {
		return startPosition;
	}
	
	public int getStackDepth() {
		return fDepth;
	}
	
    public Element getElement() {
        return fElement;
    }
	
    public boolean isTheSameLine(@NonNull UnitLocation location) {
    	return (fEvalEnv == location.fEvalEnv) && (getLineNum() == location.getLineNum());
    }
	
    public boolean isTheSameLocation(@NonNull UnitLocation location) {
    	return (fEvalEnv == location.fEvalEnv) && (getLineNum() == location.getLineNum())
    			&& (startPosition == location.startPosition) && (endPosition == location.endPosition);
    }
    
	@Override
	public boolean equals(Object another) {
		if(another instanceof UnitLocation == false) {
			return false;
		}
		
		UnitLocation location = (UnitLocation) another;
		return this == location || 
				(startPosition == location.startPosition
				&& fDepth == location.fDepth
				&& fEvalEnv == location.fEvalEnv
				&& fElement.equals(location.fElement));
	}	
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 37 * hash + startPosition;
		hash = 37 * hash + endPosition;
		hash = 37 * hash + fDepth;		
		hash = 37 * hash + fElement.hashCode();		
		return hash;
	}
	
	@Override
	public String toString() {
		return fModule.getName() + ":" + getLineNum() + ":" + startPosition  + ":" + (endPosition-startPosition)  + ":" + fDepth; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	private IModuleSourceInfo getSourceInfo() {
    	if(fSrcInfo == null) {
    		fSrcInfo = ASTBindingHelper.getModuleSourceBinding(getModule());
    	}
    	return fSrcInfo;
	}
}
