/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
 * MarkupToTree gives a printable one line string presentation of the markup for
 * debugging purposes. New lines are replaced by printables.
 */
public class MarkupToString extends MarkupSwitch<@Nullable StringBuilder>
{
	public static @NonNull String toString(@NonNull MarkupElement element) {
		MarkupToString toString = new MarkupToString();
		StringBuilder switchResult = toString.doSwitch(element);
		assert switchResult != null;
		String result = switchResult.toString();
		assert result != null;
		return result;
	}

	public static @NonNull String toString(@NonNull List<MarkupElement> elements) {
		MarkupToString toString = new MarkupToString();
		for (MarkupElement element : elements) {
			toString.doSwitch(element);
		}
		String string = toString.toString();
		assert string != null;
		return string;
	}

	protected final StringBuilder s = new StringBuilder();

	@Override
	public StringBuilder caseBulletElement(BulletElement object) {
		s.append("bullet");
		String level = object.getLevel();
		if (level != null) {
			s.append(":");
			s.append(level);
		}
		s.append("[");
		caseCompoundElement(object);
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseCompoundElement(CompoundElement object) {
		for (MarkupElement element : object.getElements()) {
			doSwitch(element);
		}
		return s;
	}

	@Override
	public StringBuilder caseFigureElement(FigureElement object) {
		s.append("figure");
		String def = object.getDef();
		if (def != null) {
			s.append("#");
			s.append(def);
		}
		s.append("[");
		s.append("\"");
		s.append(object.getSrc());
		s.append("\"");
		String alt = object.getAlt();
		if (alt != null) {
			s.append(",");
			s.append(alt);
			String width = object.getRequiredWidth();
			if (width != null) {
				s.append(",");
				s.append(width);
				String height = object.getRequiredHeight();
				if (height != null) {
					s.append(",");
					s.append(height);
				}
			}
		}
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseFigureRefElement(FigureRefElement object) {
		s.append("figure");
		s.append("[");
		s.append(object.getRef().getDef());
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseFontElement(FontElement object) {
		s.append(object.getFont());
		s.append("[");
		caseCompoundElement(object);
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseFootnoteElement(FootnoteElement object) {
		s.append("footnote[");
		caseCompoundElement(object);
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseHeadingElement(HeadingElement object) {
		s.append("heading");
		String level = object.getLevel();
		if (level != null) {
			s.append(":");
			s.append(level);
		}
		s.append("[");
		caseCompoundElement(object);
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseNewLineElement(NewLineElement object) {
		s.append(object.getText());
		return s;
	}

	@Override
	public StringBuilder caseNullElement(NullElement object) {
		s.append("[");
		caseCompoundElement(object);
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseOCLCodeElement(OCLCodeElement object) {
		s.append("oclCode[");
		caseCompoundElement(object);
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseOCLEvalElement(OCLEvalElement object) {
		s.append("oclEval[");
		caseCompoundElement(object);
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseOCLTextElement(OCLTextElement object) {
		s.append("oclText[");
		caseCompoundElement(object);
		s.append("]");
		return s;
	}

	@Override
	public StringBuilder caseTextElement(TextElement object) {
		for (String text : object.getText()) {
			s.append(text);
		}
		return s;
	}

	@Override
	public StringBuilder defaultCase(EObject object) {
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

