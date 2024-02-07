/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.utilities.PathElement;
import org.eclipse.ocl.xtext.base.as2cs.AliasAnalysis;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * QualifiedPath refines QualifiedName to use {name,element} pairs for each segment and support deresolution
 * with respect to another path or an object context.
 */
public class QualifiedPath extends QualifiedName
{
	// Since the underlying class is immutable, it can be safely extended with further immutable content.
	private static String[] getSegments(List<PathElement> pathElements) {
		String[] segments = new String[pathElements.size()];
		for (int i = 0; i < segments.length; i++) {
			segments[i] = pathElements.get(i).getName();
		}
		return segments;
	}

	private final List<PathElement> pathElements;
	private final boolean isAbsolute;

	public QualifiedPath(List<PathElement> pathElements) {
		this(pathElements, true);
	}

	protected QualifiedPath(List<PathElement> pathElements, boolean isAbsolute) {
		super(getSegments(pathElements));
		this.pathElements = pathElements;
		this.isAbsolute = isAbsolute;
	}

	public QualifiedPath deresolve(QualifiedPath contextPath) {
		List<PathElement> thisPath = pathElements;
		List<PathElement> thatPath = contextPath.pathElements;
		int iSize = thisPath.size();
		if (iSize <= 0) {
			return this;
		}
		int i = PathElement.getCommonLength(thisPath, thatPath);
		if (i <= 0) {
			return this;
		}
		if (i >= iSize) {
			return this;
		}
		final List<PathElement> newPath = new ArrayList<PathElement>();
		for ( ; i < iSize-1; i++) {
			newPath.add(thisPath.get(i));
		}
		newPath.add(thisPath.get(iSize-1));			// Last segment mandatory
		return new QualifiedPath(newPath, false);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof QualifiedPath) {
			QualifiedPath other = (QualifiedPath) obj;
			if (hashCode() != other.hashCode())
				return false;
			if (isAbsolute != other.isAbsolute)
				return false;
			int iMax = pathElements.size();
			if (iMax != other.pathElements.size()) {
				return false;
			}
			for (int i = 0; i < iMax; i++) {
				if (!pathElements.get(i).equals(other.pathElements.get(i))) {
					return false;
				}
			}
			return true;
		}
		return super.equals(obj);
	}

	/**
	 * Return the segments of this path, deresolving the first segment of an absolute path to use the
	 * aliases of the resource of csObject.
	 */
	public List<String> getSegments(EObject csObject) {
		List<String> segments = new ArrayList<String>();
		int segmentCount = getSegmentCount();
		if (segmentCount == 0) {
			return segments;
		}
		if (isAbsolute) {
			EObject root = EcoreUtil.getRootContainer(csObject);
			Resource csResource = root.eResource();
			Resource asResource = null;
			if (root instanceof RootPackageCS) {
				EObject root2 = ((RootPackageCS)root).getPivot();
				asResource = EcoreUtil.getRootContainer(root2).eResource();
			}
			EObject firstElement = null;
			if (csObject instanceof PathElementCS) {
				firstElement = ((PathElementCS)csObject).getReferredElement();
			}
			else {
				firstElement = pathElements.get(0).getElement();
			}
			if ((firstElement instanceof org.eclipse.ocl.pivot.Package) && !firstElement.eIsProxy()) {
				Resource elementResource = firstElement.eResource();
				if ((csResource != null) && (elementResource != csResource) && (elementResource != asResource)) {
					AliasAnalysis adapter = AliasAnalysis.getAdapter(csResource);
					if (segmentCount == 1) {
						String alias = adapter.getAlias(firstElement, null);
						if (alias != null) {
							segments.add(alias);
							segments.add(getFirstSegment());
						}
					}
					else {
						for (int i = segmentCount - 2; i >= 0; i--) {
							EObject element = pathElements.get(i).getElement();
							if (element != null) {
								String alias = adapter.getAlias(element, null);
								if (alias != null) {
									segments.add(alias);
									if (segmentCount == 1) {
										segments.add(((NamedElement)firstElement).getName());
									}
									else {
										for (i++; i < segmentCount; i++) {
											segments.add(getSegment(i));
										}
									}
									return segments;
								}
							}
						}
					}
				}
			}
		}
		if (segments.size() == 0) {
			segments.add(getFirstSegment());
		}
		for (int i = 1; i < segmentCount; i++) {
			segments.add(getSegment(i));
		}
		return segments;
	}

	@Override
	public String toString() {
		if (getSegmentCount() == 0)
			return "";
		if (getSegmentCount() == 1)
			return getFirstSegment();
		StringBuilder builder = new StringBuilder();
		boolean isFirst = true;
		for (String segment : getSegments()) {
			if (!isFirst)
				builder.append("::");
			isFirst = false;
			builder.append(segment);
		}
		return builder.toString();
	}
}