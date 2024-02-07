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
package org.eclipse.ocl.examples.debug.vm.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.pivot.NamedElement;

/**
 * Helps to build VM stack trace from a given state of OCL code execution.
 */
public class VMStackTraceBuilder {
	
	private static final @NonNull String UNKNOWN_NAME = "<Unknown>"; //$NON-NLS-1$
	private static final int UNKNOWN_LINE_NUM = -1;
	
	private @NonNull VMEvaluationEnvironment fEvalEnv;

	/**
	 * Constructs stack trace builder for the given evaluation environment.
	 * 
	 * @param evalEnv
	 *            the evaluation environment representing the top stack trace
	 */
	public VMStackTraceBuilder(@NonNull VMEvaluationEnvironment evalEnv) {
		fEvalEnv = evalEnv;
	}
	
	/**
	 * Builds the stack trace corresponding to evaluation environments hierarchy
	 * associated with this builder.
	 * 
	 * @return list of VM stack elements
	 */
    public List<VMStackTraceElement> buildStackTrace() {
    	LinkedList<VMStackTraceElement> elements = new LinkedList<VMStackTraceElement>();
    	
    	for (VMEvaluationEnvironment nextEnv = fEvalEnv; nextEnv != null; nextEnv = nextEnv.getVMParentEvaluationEnvironment()) {
    		// skip all the root execution environments as they 
    		// are not bound to any module code locations
    		VMEvaluationEnvironment parent = nextEnv.getVMParentEvaluationEnvironment();
			if (parent != null) {
        		// skip all stack frames not running in a module, 
        		// IOW possible non VM transformation clients
        		if (parent.getDebuggableElement() != null) {		
        			elements.addLast(createStackElement(nextEnv));
        		}
    		}
    	}
    	
    	@SuppressWarnings("unused")VMEvaluationEnvironment rootEnv = fEvalEnv.getVMRootEvaluationEnvironment();
//    	IVMEvaluationEnvironment<?> aggregatingEnv = EvaluationUtil.getAggregatingContext(rootEnv);
//		if(aggregatingEnv != null) {
//			List<VMStackTraceElement> aggregatedStackTrace = new VMStackTraceBuilder(aggregatingEnv).buildStackTrace();			
//			List<VMStackTraceElement> result = new ArrayList<VMStackTraceElement>(elements.size() + aggregatedStackTrace.size());
//			result.addAll(elements);
//			result.addAll(aggregatedStackTrace);
//			return result;
//		}
    	return Collections.unmodifiableList(elements);
    }

    private @NonNull VMStackTraceElement createStackElement(@NonNull VMEvaluationEnvironment env) {
    	String unitName = null;
    	String moduleName = UNKNOWN_NAME;
    	String operName = UNKNOWN_NAME;
    	int lineNumber = UNKNOWN_LINE_NUM;    	
    	
//    	Type module = null;
    	NamedElement operation = env.getOperation();

//    	int resultOffset = getCurrentASTOffset(env);
		
    	NamedElement currentExpressionInOCL = env.getDebuggableElement();
//    	if (currentTransformation == null) {
//    		throw new IllegalArgumentException("Currently executed model is not set in environment"); //$NON-NLS-1$
//    	}
    	
    	moduleName = currentExpressionInOCL.getName();
    	
/*		if(operation == null) {
			// we must be executing a module instance initialization - synthetic constructor
	    	operName = moduleName;
	    	
	    	if (env.getCurrentIP() == module || resultOffset < -1) {
	    		ASTSyntheticNode astNode = ASTSyntheticNodeAccess.getASTNode(module);
		    	if(astNode != null) {
		    		resultOffset = astNode.getStartPosition();
		    	}
	    	}
		} else { */
    		operName = operation.getName();	    		
//    		EClassifier contextType = QvtOperationalParserUtil.getContextualType(operation);
//    		if(contextType != null) {
//    			operName = contextType.getName() + "::" + operName;
//    		}
//		}

/*		IModuleSourceInfo sourceInfo = module != null ? ASTBindingHelper.getModuleSourceBinding(module) : null;
		if (sourceInfo != null) {
			URI uri = sourceInfo.getSourceURI();
			unitName = uri.lastSegment();
			if(resultOffset >= 0) {
				lineNumber = sourceInfo.getLineNumberProvider().getLineNumber(resultOffset);
			}
		} */
    	
    	return new VMStackTraceElement(moduleName, operName, unitName, lineNumber);
    }

/*	private static int getCurrentASTOffset(@NonNull IVMEvaluationEnvironment<?> evalEnv) {
    	// TODO - for cases that AST does not fill all offset
    	// traverse up to the enclosing operation scope, taking the closest 
    	// offset which has been initialized    	
    	Element currentIPObject = evalEnv.getCurrentIP();
    	
    	if (currentIPObject instanceof Element) {
    		Element astNode = (Element) currentIPObject;
    		
			if (ASTBindingHelper.getStartPosition(astNode) < 0 && astNode instanceof VariableExp) {
				// Remark: special processing for implicit source variables represented as
				// synthetic variable expression in AST. These do not have any CST representation
				// but are rather synthetic nodes => point to the call AST
				EObject astContainer = astNode.eContainer();
				if (astContainer instanceof FeatureCallExp) {
					astNode = (FeatureCallExp) astContainer;
				}
			}    		
    		
    		return ASTBindingHelper.getStartPosition(astNode);
    	}
    	
		ASTSyntheticNode astNode = ASTSyntheticNodeAccess.getASTNode(currentIPObject);
		if(astNode != null) {
			return astNode.getStartPosition();
		}
    	
    	return -1;
    } */
}
