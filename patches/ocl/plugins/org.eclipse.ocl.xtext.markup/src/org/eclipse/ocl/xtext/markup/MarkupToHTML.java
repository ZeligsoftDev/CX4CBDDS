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
package org.eclipse.ocl.xtext.markup;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.context.ClassContext;
import org.eclipse.ocl.pivot.internal.context.OperationContext;
import org.eclipse.ocl.pivot.internal.context.PropertyContext;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.HTMLBuffer;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.OCLHelper;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.markupcs.BulletElement;
import org.eclipse.ocl.xtext.markupcs.CompoundElement;
import org.eclipse.ocl.xtext.markupcs.FigureElement;
import org.eclipse.ocl.xtext.markupcs.FigureRefElement;
import org.eclipse.ocl.xtext.markupcs.FontElement;
import org.eclipse.ocl.xtext.markupcs.FootnoteElement;
import org.eclipse.ocl.xtext.markupcs.HeadingElement;
import org.eclipse.ocl.xtext.markupcs.MarkupElement;
import org.eclipse.ocl.xtext.markupcs.NewLineElement;
import org.eclipse.ocl.xtext.markupcs.NullElement;
import org.eclipse.ocl.xtext.markupcs.OCLCodeElement;
import org.eclipse.ocl.xtext.markupcs.OCLEvalElement;
import org.eclipse.ocl.xtext.markupcs.OCLTextElement;
import org.eclipse.ocl.xtext.markupcs.TextElement;
import org.eclipse.ocl.xtext.markupcs.util.MarkupSwitch;

/**
 * MarkupToHTML gives an HTML presentation of the markup.
 */
public class MarkupToHTML extends MarkupSwitch<@Nullable HTMLBuffer>
{
	@SuppressWarnings("serial")
	public static class InvalidMarkupException extends RuntimeException
	{
		public InvalidMarkupException(Exception e) {
			super(e);
		}
	}

	public static String toString(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Object context, @NonNull MarkupElement element) throws Exception {
		MarkupToHTML toString = new MarkupToHTML(environmentFactory, context);
		try {
			return String.valueOf(toString.doSwitch(element));
		} catch (InvalidMarkupException e) {
			throw (Exception)e.getCause();
		}
	}

	//	private @Nullable OCL ocl = null;
	private @NonNull EnvironmentFactoryInternalExtension environmentFactory;
	protected final @Nullable Object context;
	protected final @NonNull HTMLBuffer s = new HTMLBuffer();

	public MarkupToHTML(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Object context) {
		this.environmentFactory = (EnvironmentFactoryInternalExtension) environmentFactory;
		this.context = context;
	}

	@Override
	public HTMLBuffer caseBulletElement(BulletElement object) {
		Integer level = Integer.valueOf(object.getLevel());
		s.startBulletLevel(level);
		caseCompoundElement(object);
		s.endBulletLevel(level);
		return s;
	}

	@Override
	public HTMLBuffer caseCompoundElement(CompoundElement object) {
		for (MarkupElement element : object.getElements()) {
			doSwitch(element);
		}
		return s;
	}

	@Override
	public HTMLBuffer caseFigureElement(FigureElement object) {
		if (object.getDef() != null) {
			s.appendLabelDef(object.getDef());
		}
		s.appendFigure(object.getSrc(), object.getAlt(), object.getRequiredWidth(), object.getRequiredHeight());
		return s;
	}

	@Override
	public HTMLBuffer caseFigureRefElement(FigureRefElement object) {
		FigureElement ref = object.getRef();
		if (ref.eIsProxy()) {
			String message = "Unresolved proxy '" + ((InternalEObject)ref).eProxyURI() + "'";
			throw new InvalidMarkupException(new IllegalStateException(message));
		}
		s.appendLabelRef(ref.getDef());
		return s;
	}

	@Override
	public HTMLBuffer caseFontElement(FontElement object) {
		String font = object.getFont();
		String htmlFont;
		if ("b".equals(font)) {
			htmlFont = "b";
		}
		else if ("e".equals(font)) {
			htmlFont = "i";
		}
		else {
			htmlFont = "???";
		}
		s.startFontName(htmlFont);
		caseCompoundElement(object);
		s.endFontName(htmlFont);
		return s;
	}

	@Override
	public HTMLBuffer caseFootnoteElement(FootnoteElement object) {
		s.startFootnote();
		caseCompoundElement(object);
		s.endFootnote();
		return s;
	}

	@Override
	public HTMLBuffer caseHeadingElement(HeadingElement object) {
		String level = object.getLevel();
		if (level == null) {
			level = "1";
		}
		s.startHeadingLevel(level);
		caseCompoundElement(object);
		s.endHeadingLevel(level);
		return s;
	}

	@Override
	public HTMLBuffer caseNewLineElement(NewLineElement object) {
		assert object != null;
		int newLines = MarkupUtils.getNewlineCount(object);
		if (newLines <= 1) {
			s.append("\n");
		}
		else {
			s.append("\n");
			s.endParagraph();
			s.startParagraph();
			s.append("\n");
		}
		return s;
	}

	@Override
	public HTMLBuffer caseNullElement(NullElement object) {
		s.append('[');
		caseCompoundElement(object);
		s.append(']');
		return s;
	}

	@Override
	public HTMLBuffer caseOCLCodeElement(OCLCodeElement object) {
		s.startFontName("pre");
		List<MarkupElement> elements = object.getElements();
		assert elements != null;
		String oclString = MarkupToString.toString(elements);
		try {
			ExpressionInOCL query = createQuery(oclString);
			String text = PrettyPrinter.print(query);
			s.append(text);
		} catch (ParserException e) {
			throw new InvalidMarkupException(e);
		} finally {
			s.endFontName("pre");
		}
		return s;
	}

	@Override
	public HTMLBuffer caseOCLEvalElement(OCLEvalElement object) {
		List<MarkupElement> elements = object.getElements();
		assert elements != null;
		String oclString = MarkupToString.toString(elements);
		try {
			OCL ocl = environmentFactory.createOCL();
			ExpressionInOCL query = createQuery(oclString);
			Object value = ocl.evaluate(context, query);
			s.append(String.valueOf(value));
			ocl.dispose();
		} catch (ParserException e) {
			throw new InvalidMarkupException(e);
		}
		return s;
	}

	@Override
	public HTMLBuffer caseOCLTextElement(OCLTextElement object) {
		s.startFontName("tt");
		List<MarkupElement> elements = object.getElements();
		assert elements != null;
		String oclString = MarkupToString.toString(elements);
		try {
			ExpressionInOCL query = createQuery(oclString);
			PrettyPrintOptions.Global options = PrettyPrinter.createOptions(null);
			options.setLinelength(Integer.MAX_VALUE);
			String text = PrettyPrinter.print(query, options);
			s.append(text);
		} catch (ParserException e) {
			throw new InvalidMarkupException(e);
		} finally {
			s.endFontName("tt");
		}
		return s;
	}

	@Override
	public HTMLBuffer caseTextElement(TextElement object) {
		for (String text : object.getText()) {
			int iMax = text.length();
			if (iMax > 0) {
				char c = text.charAt(0);
				if ((c == ' ') || (c == '\t')) {
					s.append(' ');
				}
				else {
					for (int i = 0; i < iMax; ) {
						c  = text.charAt(i++);
						if ((c == '\\') && (i < iMax)) {
							c  = text.charAt(i++);
						}
						s.append(c);
					}
				}
			}
		}
		return s;
	}

	protected @NonNull ExpressionInOCL createQuery(@NonNull String oclString) throws ParserException {
		EObject parserContext2 = null;
		OCL ocl = environmentFactory.createOCL();
		try {
			if (context instanceof Operation) {
				Operation operationContext = (Operation)context;
				ParserContext parserContext = new OperationContext(ocl.getEnvironmentFactory(), null, operationContext, PivotConstants.RESULT_NAME);
				return parserContext.parse(operationContext.getOwningClass(), oclString);
			}
			else if (context instanceof Property) {
				Property propertyContext = (Property)context;
				ParserContext parserContext = new PropertyContext(ocl.getEnvironmentFactory(), null, propertyContext);
				return parserContext.parse(propertyContext.getOwningClass(), oclString);
			}
			else if (context instanceof org.eclipse.ocl.pivot.Class) {
				org.eclipse.ocl.pivot.Class classContext = (org.eclipse.ocl.pivot.Class)context;
				ParserContext parserContext = new ClassContext(ocl.getEnvironmentFactory(), null, classContext, null);
				return parserContext.parse(classContext, oclString);
			}
			else if (context instanceof EObject) {			// Legacy code probably obsolete
				EClass eClass = ((EObject)context).eClass();
				String name = eClass.getName();
				assert name != null;
				parserContext2 = environmentFactory.getASClass(name);
				if (parserContext2 == null) {
					Resource resource = eClass.eResource();
					if (resource != null) {
						Ecore2AS ecore2as = Ecore2AS.getAdapter(resource, environmentFactory);
						parserContext2 = ecore2as.getCreated(org.eclipse.ocl.pivot.Class.class, eClass);
					}
				}
			}
			OCLHelper helper = ocl.createOCLHelper(parserContext2);
			return helper.createQuery(oclString);
		}
		finally {
			ocl.dispose();
		}
	}

	@Override
	public HTMLBuffer defaultCase(EObject object) {
		s.append("<Unsupported ");
		s.append(object.eClass().getName());
		s.append(">");
		return s;
	}

	@Override
	public String toString() {
		return s.toString();
	}
}

