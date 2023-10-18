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

public final class VMStackTraceElement implements IVMStackTraceElement  {
	
    private String fModuleName;
    private String fOperationName;
    private String fUnitName;
    private int    fLineNum;

    /**
     * Creates a stack trace element representing the specified execution
     * point.
     * @throws NullPointerException if <tt>fModuleName</tt> or
     *         <tt>fOperationName</tt> is null
     */
    public VMStackTraceElement(String moduleName, String operationName, String unitQName, int lineNumber) {
        if (moduleName == null) {
            throw new NullPointerException("Module name is null"); //$NON-NLS-1$
        }
        
        if (operationName == null) {
            throw new NullPointerException("operation name is null"); //$NON-NLS-1$
        }
 
		this.fModuleName = moduleName;
		this.fOperationName = operationName;
		this.fUnitName = unitQName;
		this.fLineNum = lineNumber > 0 ? lineNumber : -1;
    }

    public String getUnitName() {
        return fUnitName;
    }

    public int getLineNumber() {
        return fLineNum;
    }

    public String getModuleName() {
        return fModuleName;
    }

    public String getOperationName() {
        return fOperationName;
    }
    
    @Override
	public String toString() {
    	StringBuilder buf = new StringBuilder();
    	buf.append(getModuleName()).append("::").append(getOperationName());
    	if(fUnitName != null) {
    		buf.append('(').append(fUnitName).append(':');    		
    		if(fLineNum > 0) {
    			buf.append(fLineNum);
    		} else {
    			buf.append("<Unknown>"); //$NON-NLS-1$
    		}
    		buf.append(')');
    	} else {
    		buf.append("(Unknown Source)"); //$NON-NLS-1$
    	}
    	
        return buf.toString();
    }

    @Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof VMStackTraceElement)) {
			return false;
		}
		VMStackTraceElement e = (VMStackTraceElement) obj;
		return e.fModuleName.equals(fModuleName) && e.fLineNum == fLineNum
				&& eq(fOperationName, e.fOperationName)
				&& eq(fUnitName, e.fUnitName);
	}

    @Override
	public int hashCode() {
		int result = 31 * fModuleName.hashCode() + fOperationName.hashCode();
		result = 31 * result + (fUnitName == null ? 0 : fUnitName.hashCode());
		result = 31 * result + fLineNum;
		return result;
	}
    
	private static boolean eq(Object a, Object b) {
		return a == b || (a != null && a.equals(b));
	}
}
