/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.util.stdlib;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.mwe.core.issues.Issues;

public class DanglingRefFinder {
	
	private Set<EObject> set = new HashSet<EObject>();

	@SuppressWarnings("unchecked")
	public void handle(EObject o, Issues issues) {
		if ( set.contains( o ) || shouldIgnore(o) ) return;
		set.add( o );
		EObject cont = o.eContainer();
		if ( cont != null ) handle(cont, issues);
		List<EReference> refs = o.eClass().getEAllReferences();
		for (EReference reference : refs) {
			if ( reference.isMany() ) {
				Collection<EObject> col = (Collection<EObject>)o.eGet(reference);
				for (EObject object : col) {
					checkNullRef( o, reference, object, issues );
					if ( object != null ) {
						checkDangling( o, reference, object, issues );
						handle( object, issues );
					}
				}
			} else {
				EObject object = (EObject)o.eGet(reference);
				if ( object != null ) {
					checkDangling( o, reference, object, issues );
					handle( object, issues );
				}
			}
		}
	}

	private boolean shouldIgnore(EObject o) {
		boolean b = o instanceof EFactory;
		return b;
	}

	private void checkNullRef(EObject ctx, EReference reference, EObject target, Issues issues) {
		if ( target == null ) {
			issues.addWarning(renderEObject(ctx)+"."+renderEReference(reference)+": contains a null object");
		}
	}

	private void checkDangling(EObject ctx, EReference reference, EObject target, Issues issues) {
		if ( shouldIgnore(target)) return;
		if ( (target.eContainer() == null) && (target.eResource() == null) ) {
				issues.addWarning(renderEObject(target)+" is not contained in an eContainer or Resource. Found in "+renderEObject(ctx)+"."+renderEReference(reference));
		} 
	}

	private String renderEObject(EObject ctx) {
		DynamicEcoreHelper h = new DynamicEcoreHelper(ctx);
		return h.getName(ctx)+"("+ctx.eClass().getName()+")";
	}
	
	private String renderEReference(EReference ctx) {
		return ctx.getName()+" ["+(ctx.isContainer() ? "container=true":"container=false")+"]";
	}
	

}
