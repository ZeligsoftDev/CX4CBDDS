/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.as2cs;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * BaseLocationInFileProvider is they key class for mapping the location of an AS/CS element to
 * either a full (!significant) text range, which is the all the characters associated with the element,
 * or a short (significant) text range, which is the characters to be highlighted when selected.
 * <p>
 * The reverse location to CS/AS element is in BaseOutlineWithEditorLinker.
 */
public class BaseLocationInFileProvider extends DefaultLocationInFileProvider
{
	@Override
	protected EStructuralFeature getIdentifierFeature(EObject obj) {
		final EClass eClass = obj.eClass();
		EStructuralFeature result = eClass.getEStructuralFeature("ownedPathName");
		if ((result != null) && result.isRequired()) {
			return result;
		}
		else {
			return super.getIdentifierFeature( obj);	// "name" (or "id") used by QVTd's QualifiedPackageCS, TransformationCS
		}
	}

	@Override
	protected @NonNull ITextRegion getTextRegion(EObject obj, boolean isSignificant) {
		if (obj instanceof Element) {
			ModelElementCS csModelElement = ElementUtil.getCsElement((Element) obj);
			if (csModelElement != null) {
				return ClassUtil.nonNullState(super.getTextRegion(csModelElement, isSignificant));
			}
		}
		else if (obj instanceof Comment) {
			EObject eContainer = obj.eContainer();
			if (eContainer instanceof Element) {
				ModelElementCS csModelElement = ElementUtil.getCsElement((Element) eContainer);
				if (csModelElement != null) {
					ICompositeNode node = NodeModelUtils.getNode(csModelElement);
					if (node != null) {
						List<ILeafNode> documentationNodes = CS2AS.getDocumentationNodes(node);
						ILeafNode first = documentationNodes.get(0);
						ILeafNode last = documentationNodes.get(documentationNodes.size()-1);
						int start = first.getOffset();
						int end = last.getOffset() + last.getLength();
						return new TextRegion(start, end-start);
					}
				}
			}
		}
		return ClassUtil.nonNullState(super.getTextRegion(obj, isSignificant));
	}
}