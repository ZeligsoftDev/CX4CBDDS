/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.AbstractEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;

//Reimplements DispatchingEObjectTextHover to suppress 'standard' Ecore' support
public class MarkupHover extends AbstractEObjectHover
{
	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	IEObjectHoverProvider hoverProvider;

	private IInformationControlCreatorProvider lastCreatorProvider;

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		return this.lastCreatorProvider==null?null:lastCreatorProvider.getHoverControlCreator();
	}

	@Override
	public Object getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
//		IEObjectHoverProvider hoverProvider = serviceProvider.findService(first, IEObjectHoverProvider.class);
//		if (hoverProvider==null)
//			return null;
		IInformationControlCreatorProvider creatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
		if (creatorProvider==null)
			return null;
		this.lastCreatorProvider = creatorProvider;
		return lastCreatorProvider.getInfo();
	}

	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		//
		// Overrides to return the CS node so that the MetamodelManager is accessible for documentation.
		//
		TextRegion textRegion = new TextRegion(offset, 0);
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null) {
			return null;
		}
		ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), textRegion.getOffset());
		if (leaf == null) {
			return null;
		}
		EObject o = leaf.getSemanticElement();
		if (o != null) {
			ITextRegion region = locationInFileProvider.getSignificantTextRegion(o);
			final IRegion region2 = new Region(region.getOffset(), region.getLength());
			if (TextUtilities.overlaps(region2, new Region(offset, 0)))
				return Tuples.create(o, region2);
		}
		return super.getXtextElementAt(resource, offset);
	}
}
