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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Element;

public final class ASTSyntheticNodeAccess {
		
	public static ASTSyntheticNode createASTNode(Element element) {
		ASTSyntheticAdapter result = new ASTSyntheticAdapter();
//		element.eAdapters().add(result);
		return result;
	}
	
/*	public static void setCST(ASTSyntheticNode astNode, CSTNode cstNode) {
		ASTSyntheticAdapter adapter = (ASTSyntheticAdapter) astNode;
		adapter.fCSTNode = cstNode;
	}
	
	public static <T extends CSTNode> T getCST(ASTSyntheticNode astNode, Class<T> type) {	
		ASTSyntheticAdapter adapter = (ASTSyntheticAdapter) astNode;
		if(type.isInstance(adapter.fCSTNode)) {
			return type.cast(adapter.fCSTNode);
		}
		return null;
	} */
	
	public static ASTSyntheticNode getASTNode(EObject element) {
		return (ASTSyntheticNode) EcoreUtil.getExistingAdapter(element, ASTSyntheticAdapter.class);
	}
	
	private static class ASTSyntheticAdapter /* extends AdapterImpl */ implements ASTSyntheticNode {
//		private CSTNode fCSTNode;
		private int fStartPos;		
//		private int fEndPos;
		
/*		@Override
		public boolean isAdapterForType(Object type) {
			return ASTSyntheticAdapter.class.equals(type);
		}
		
		public EObject getActualElement() {		
			return (EObject)getTarget();
		} */
		
		public int getStartPosition() {
			return fStartPos;
		}
	}
}
