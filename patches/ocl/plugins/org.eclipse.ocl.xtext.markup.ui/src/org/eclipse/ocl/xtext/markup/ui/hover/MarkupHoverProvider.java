/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup.ui.hover;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.HTMLBuffer;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.markup.MarkupUtils;
import org.eclipse.ocl.xtext.markupcs.Markup;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;

public class MarkupHoverProvider extends DefaultEObjectHoverProvider
{
	@Override
	protected String getDocumentation(EObject o) {
		Resource resource = o.eResource();
		if (resource == null) {
			return null;
		}
		if (o instanceof Pivotable) {
			EObject o1 = ((Pivotable)o).getPivot();
			if (o1 != null) {
				o = o1;
			}
			if (o instanceof ReferringElement) {
				EObject o2 = ((ReferringElement)o).getReferredElement();
				if (o2 != null) {
					o = o2;
				}
			}
			if (o instanceof TemplateableElement) {
				EObject o3 = ((TemplateableElement)o).getUnspecializedElement();
				if (o3 != null) {
					o = o3;
				}
			}
		}
		String documentation = super.getDocumentation(o);
		if (documentation == null) {
			return null;
		}
		IParseResult parseResult = MarkupUtils.decode(documentation);
		if (parseResult == null) {
			return null;
		}
		Markup markup = (Markup) parseResult.getRootASTElement();
		if (markup == null) {
			return null;
		}
		Iterable<INode> parseErrors = parseResult.getSyntaxErrors();
		Map<Integer, @NonNull Integer> errorMap = getErrorMap(parseErrors);
		if (errorMap != null) {
			HTMLBuffer htmlBuffer = new HTMLBuffer();
			int i = 0;
			List<Integer> starts = new ArrayList<Integer>(errorMap.keySet());
			Collections.sort(starts);
			for (int start : starts) {
				Integer end = errorMap.get(start);
				assert end != null;
				while (i < start) {
					htmlBuffer.append(documentation.charAt(i++));
				}
				htmlBuffer.startFontColor("red");
				htmlBuffer.startUnderline();
				while (i < end) {
					htmlBuffer.append(documentation.charAt(i++));
				}
				htmlBuffer.endUnderline();
				htmlBuffer.endFontColor();
			}
			htmlBuffer.startFontColor("red");
			htmlBuffer.startParagraph();
			htmlBuffer.endParagraph();
			for (INode parseError :parseErrors) {
				htmlBuffer.startParagraph();
				htmlBuffer.append(parseError.getSyntaxErrorMessage().getMessage());
				htmlBuffer.endParagraph();
			}
			htmlBuffer.endFontColor();
			return htmlBuffer.toString();
		}
		if (o instanceof Pivotable) {
			o = ((Pivotable)o).getPivot();
		}
		if (o == null) {
			return null;
		}
		try {
			EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
			if (environmentFactory == null) {
				return null;
			}
			return MarkupUtils.toHTML(environmentFactory, o, markup);
		} catch (Exception e) {
			StringWriter s = new StringWriter();
			e.printStackTrace(new PrintWriter(s));
			return s.toString().replace("\n", "\n<br>");
		}
	}

	protected Map<Integer, @NonNull Integer> getErrorMap(Iterable<INode> parseErrors) {
		Map<Integer, @NonNull Integer> errorMap = null;
		for (INode parseError : parseErrors) {
			if (errorMap == null) {
				errorMap = new HashMap<Integer, @NonNull Integer>();
			}
			int start = parseError.getOffset();
			errorMap.put(start, start + parseError.getLength());
		}
		if (errorMap != null) {
			List<Integer> starts = new ArrayList<Integer>(errorMap.keySet());
			Collections.sort(starts);
			Integer currentStart = null;
			Integer currentEnd = 0;
			for (int i = 0; i < starts.size(); i++) {
				Integer start = starts.get(i);
				if (currentStart == null) {
					currentStart = start;
					currentEnd = errorMap.get(start);
				}
				else {
					currentEnd = errorMap.get(start);
					assert currentEnd != null;
					if (start > currentEnd) {
						currentStart = start;
					}
					else {
						errorMap.remove(start);
						errorMap.put(currentStart, currentEnd);
					}
				}
			}
		}
		return errorMap;
	}

	@Override
	protected String getFirstLine(EObject eObject) {
		//		System.out.println("getFirstLine " + eObject.eClass().getName());
		Element pivotElement = null;
		if (eObject instanceof Pivotable) {
			pivotElement = PivotUtil.getPivot(Element.class, (Pivotable)eObject);
		}
		else if (eObject instanceof Element) {
			pivotElement = (Element)eObject;
		}
		if (pivotElement != null) {
			Namespace namespace = getNamespace(pivotElement);
			if ((namespace != null) && (namespace.eContainer() instanceof Namespace)) {
				namespace = (Namespace) namespace.eContainer();
			}
			String description = null;
			PrettyPrintOptions.Global prettyPrintOptions = new PrettyPrintOptions.Global(namespace)
			{
				{ setShowDefaultMultiplicities(true); }

				@Override
				public @Nullable Set<String> getReservedNames() {
					return null;
				}

				@Override
				public @Nullable Set<String> getRestrictedNames() {
					return null;
				}
			};
			if (namespace != null) {
				EnvironmentFactory environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
				if (environmentFactory != null) {
					prettyPrintOptions.setEnvironmentFactory(environmentFactory);
				}
			}
			if (pivotElement instanceof CallExp) {
				description = PrettyPrinter.printType(pivotElement, prettyPrintOptions);
			}
			else if (pivotElement instanceof ReferringElement) {
				Element referredElement = ((ReferringElement)pivotElement).getReferredElement();
				if (referredElement != null) {
					description = PrettyPrinter.print(referredElement, prettyPrintOptions);
				}
			}
			else if (pivotElement instanceof OCLExpression) {
				Type type = ((OCLExpression)pivotElement).getType();
				if (type != null) {
					description = PrettyPrinter.printType(type, prettyPrintOptions);
				}
			}
			if (description == null) {
				description = PrettyPrinter.print(pivotElement, prettyPrintOptions);
			}
			//			System.out.println(" => " + description);
			return pivotElement.eClass().getName() + " <b>" + description + "</b>";
		}
		else {
			String firstLine = super.getFirstLine(eObject);
			//			System.out.println(" => " + firstLine);
			return firstLine + "\n<br>" + eObject.eClass().getName();		// FIXME do better
		}
	}

	public static Namespace getNamespace(EObject element) {
		int count = 0;
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Namespace) {
				if (count++ >= 2) {
					return (Namespace) eObject;
				}
			}
			if (eObject instanceof Type) {
				count++;
			}
		}
		return null;
	}

	@Override
	protected boolean hasHover(EObject o) {
		if (o instanceof Element) {
			return true;
		}
		if (o instanceof ElementCS) {
			return true;
		}
		return super.hasHover(o);
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		// TODO Auto-generated method stub
		return super.getHoverControlCreator();
	}

	@Override
	public IInformationControlCreatorProvider getHoverInfo(final EObject object, final ITextViewer viewer, final IRegion region) {
		return new IInformationControlCreatorProvider() {

			@Override
			public IInformationControlCreator getHoverControlCreator() {
				return MarkupHoverProvider.this.getHoverControlCreator();
			}

			@Override
			public Object getInfo() {
				//				return getHoverInfo(object, region, null);
				return getHoverInfo(object, viewer, region, null);
			}
		};
	}

	protected XtextBrowserInformationControlInput getHoverInfo(EObject element,
			ITextViewer viewer, IRegion hoverRegion, XtextBrowserInformationControlInput previous) {
		//		IXtextDocument xtextDocument = XtextDocumentUtil.get(viewer);
		return super.getHoverInfo(element, hoverRegion, previous);
	}
}
