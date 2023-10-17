/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;

/**
 * A PathElement represents a segment in a qualified name.
 * <br>
 * A pair of Lists of PathElement can have their common prefix skipped by @link{getCommonLength}
 * to provide a scope dependent qualified name.
 */
public class PathElement
{
	public static int getCommonLength(List<PathElement> firstPath, List<PathElement> secondPath) {
		int iMax = Math.min(firstPath.size(), secondPath.size());
		for (int i = 0; i < iMax; i++) {
			Element objectElement = firstPath.get(i).element;
			Element contextElement = secondPath.get(i).element;
			if (!objectElement.equals(contextElement)) {
				return i;
			}
		}
		return iMax;
	}
	  
    public static List<PathElement> getPath(EObject element) {
        List<PathElement> path = new ArrayList<PathElement>();
        EObject parent = element;
        for (; (parent != null) && !(parent instanceof Namespace); parent = parent.eContainer()) {
        }
        for (; parent instanceof Namespace; parent = parent.eContainer()) {
            Namespace namespace = (Namespace)parent;
			path.add(0, new PathElement(namespace.getName(), namespace));
        }
        return path;
    }
	  
    public static List<PathElement> getPath(EObject element, MetamodelManager metamodelManager) {
        List<PathElement> path = new ArrayList<PathElement>();
        EObject parent = element;
        for (; (parent != null) && !(parent instanceof Namespace); parent = parent.eContainer()) {
        }
        for (; (parent instanceof Namespace) && !(parent instanceof Model); parent = parent.eContainer()) {
            Namespace namespace = (Namespace)parent;
            if (metamodelManager != null) {
            	namespace = ((PivotMetamodelManager)metamodelManager).getPrimaryElement(namespace);
            }
			path.add(0, new PathElement(namespace.getName(), namespace));
        }
        return path;
    }

	protected final String name;
	protected final Element element;
	
	public PathElement(String name, Element element) {
		super();
		this.name = name;
		this.element = element;
	}

	public final Element getElement() {
		return element;
	}

	public final String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}