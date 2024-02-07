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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.vm.utils.LineNumberProvider;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;

public class ValidBreakpointLocator
{
	public static final @NonNull Boolean IS_START = Boolean.TRUE;
	public static final @NonNull Boolean IS_END = Boolean.FALSE;
	private static final @NonNull List<Element> NO_ELEMENTS = Collections.emptyList();
	
	private final @NonNull AbstractExtendingVisitor<Boolean, Object> visitor;

	public ValidBreakpointLocator(@NonNull AbstractExtendingVisitor<Boolean, Object> visitor) {
		this.visitor = visitor;
	}
	
	public @NonNull List<Element> getBreakpointableElementsForLine(@NonNull CompiledUnit compiledModule, @NonNull LineNumberProvider lineNumbers, int lineNumber) {
		List<Element> elements = new ArrayList<Element>();
		for (NamedElement nextModule : compiledModule.getModules()) {
			for (TreeIterator<EObject> tit = nextModule.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Element) {
					Element element = (Element)eObject;
					boolean found = false;
					Boolean isStartNotEnd = element.accept(visitor);
					if (isStartNotEnd == IS_START) {
				        int line = lineNumbers.getLineNumber(ASTBindingHelper.getStartPosition(element));
						if(line == lineNumber) {
							elements.add(element);
							found = true;
						}
					}
					
					if (!found && (isStartNotEnd == IS_END)) {
				        int line = lineNumbers.getLineNumber(ASTBindingHelper.getEndPosition(element));
						if (line == lineNumber) {
							elements.add(element);
						}
					}	
				}
			}
		}
		if (!elements.isEmpty()) {
			// already found, can't be spread across multiple modules
			return elements;
		}
		return NO_ELEMENTS;
	}

	public boolean isBreakpointableElementEnd(@NonNull Element element) {
		return element.accept(visitor) == IS_END;
	}

	public boolean isBreakpointableElementStart(@NonNull Element element) {
		return element.accept(visitor) == IS_START;
	}
}
