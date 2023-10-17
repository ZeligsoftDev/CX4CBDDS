/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.as2cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.as2cs.BaseLocationInFileProvider;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigationUtil;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

/**
 * EssentialOCLLocationInFileProvider ensure that the full text regions for OperatorCSes cover the full source and argument range.
 */
public class EssentialOCLLocationInFileProvider extends BaseLocationInFileProvider
{
	private static final @SuppressWarnings("null")@NonNull ITextRegion EMPTY_REGION = ITextRegion.EMPTY_REGION;

	@Override
	protected @NonNull ITextRegion getTextRegion(EObject obj, boolean isSignificant) {
		ITextRegion textRegion;
		ElementCS csModelElement = null;
		if (obj instanceof Element) {
			csModelElement = ElementUtil.getCsElement((Element) obj);
		}
		else if (obj instanceof ElementCS) {
			csModelElement = (ElementCS)obj;
		}
		if (csModelElement instanceof ExpCS) {
			textRegion = getTextRegionCS((ExpCS)csModelElement, isSignificant);
		}
		else if (csModelElement == null) {
			textRegion = getTextRegionNoCS(obj, isSignificant);
		}
		else {
			textRegion = super.getTextRegion(obj, isSignificant);
		}
/*		StringBuilder s = new StringBuilder();
		s.append(obj.eClass().getName());
		s.append(" ");
		ElementUtil.appendTextRegion(s, textRegion, isSignificant);
		if (csModelElement != null) {
			String ss = csModelElement.toString().replace("\n", "\\n");
			if (ss.length() > 100) {
				ss = ss.substring(0, 100) + "...";
			}
			s.append(ss);
		}
		System.out.println(s.toString()); */
		return textRegion;
	}

	/**
	 * For a CS-less element, the full text region is expanded to cover all children.
	 * <p>
	 * This ensures that for an infix "or" the full region covers the input terms.
	 */
	public @NonNull ITextRegion getTextRegionCS(@NonNull ExpCS csExp, boolean isSignificant) {
		if (!isSignificant) {
			ExpCS csLeftmost = csExp;
			ExpCS csRightmost = csExp;
			if (csLeftmost instanceof NameExpCS) {
				EObject csLeft = ((NameExpCS) csLeftmost).getLocalLeft();
				if (NavigationUtil.isNavigationInfixExp(csLeft)) {
					assert csLeft != null;
					csLeftmost = (InfixExpCS)csLeft;
				}
			}
			while (csLeftmost instanceof OperatorExpCS) {
				ExpCS csSource = ((OperatorExpCS)csLeftmost).getSource();
				if (csSource != null) {
					csLeftmost = csSource;
				}
				else {
					break;
				}
			}
			while (csRightmost instanceof InfixExpCS) {
				ExpCS csArgument = ((InfixExpCS)csRightmost).getArgument();
				if (csArgument != null) {
					csRightmost = csArgument;
				}
				else {
					break;
				}
			}
			ITextRegion leftRegion = super.getTextRegion(csLeftmost, isSignificant);
			ITextRegion rightRegion = super.getTextRegion(csRightmost, isSignificant);
			return ClassUtil.nonNullState(leftRegion.merge(rightRegion));
		}
		else {
			return super.getTextRegion(csExp, isSignificant);
		}
	}

	/**
	 * For a CS-less element, the text region is determined from the CS parent and child. The
	 * significant region is less between the child full region and the parent signifucant region.
	 * The full region additionally covers the child.
	 * <p>
	 * This ensures that for an implicit oclAsSet() the significant region is the navigation operator.
	 */
	protected @NonNull ITextRegion getTextRegionNoCS(EObject obj, boolean isSignificant) {
		Element asParentElement = null;
		for (EObject eObject = obj; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Element) {
				ElementCS csModelElement = ElementUtil.getCsElement((Element) eObject);
				if (csModelElement != null) {
					asParentElement = (Element)eObject;
					break;
				}
			}
		}
		if (asParentElement == null) {
			return EMPTY_REGION;
		}
		ITextRegion parentSignificantTextRegion = getTextRegion(asParentElement, true);
		ITextRegion childrenFullTextRegion = null;
		for (EObject eChild : obj.eContents()) {
			if (eChild instanceof Element) {
				ElementCS csModelElement = ElementUtil.getCsElement((Element) eChild);
				if (csModelElement != null) {
					ITextRegion childFullTextRegion = getTextRegion(csModelElement, false);
					childrenFullTextRegion = childrenFullTextRegion != null ? childrenFullTextRegion.merge(childFullTextRegion) : childFullTextRegion;
				}
			}
		}
		if (childrenFullTextRegion == null) {
			return new TextRegionWithLineInformation(parentSignificantTextRegion.getOffset(), 0, 0, 0);
		}
		int parentStart = parentSignificantTextRegion.getOffset();
		int parentEnd = parentStart + parentSignificantTextRegion.getLength();
		int childStart = childrenFullTextRegion.getOffset();
		int childEnd = childStart + childrenFullTextRegion.getLength();
		int fullStart = childStart;
		int fullEnd = childEnd;
		int significantStart;
		int significantEnd;
		if (parentEnd < fullStart) {
			significantStart = parentEnd;
			significantEnd = fullStart;
			fullStart = parentEnd;
		}
		else if (fullEnd < parentStart) {
			significantStart = fullEnd;
			significantEnd = parentStart;
			fullEnd = parentStart;
		}
		else {
			significantStart = childEnd;
			significantEnd = childEnd;
		}
		if (isSignificant) {
			return new TextRegionWithLineInformation(significantStart, significantEnd - significantStart, 0, 0);
		}
		else {
			return new TextRegionWithLineInformation(fullStart, fullEnd - fullStart, 0, 0);
		}
	}
}