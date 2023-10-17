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
import org.eclipse.ocl.xtext.markupcs.HeadingElement;
import org.eclipse.ocl.xtext.markupcs.MarkupElement;
import org.eclipse.ocl.xtext.markupcs.NewLineElement;
import org.eclipse.ocl.xtext.markupcs.TextElement;
import org.eclipse.ocl.xtext.markupcs.util.MarkupSwitch;

/**
 * MarkupToTree gives an indented textual tree presentation of the markup for
 * debugging purposes. Each line starts with a class name followed by attributes.
 */
public class MarkupToTree extends MarkupSwitch<@Nullable StringBuilder>
{
	public static @NonNull String toString(@NonNull MarkupElement element) {
		MarkupToTree toString = new MarkupToTree();
		String result = String.valueOf(toString.doSwitch(element));
		assert result != null;
		return result;
	}

	protected final @NonNull StringBuilder s = new StringBuilder();
	private int depth = 0;

	protected void appendClass(@NonNull EObject object) {
		for (int i = 0; i < depth; i++) {
			s.append("  ");
		}
		s.append(object.eClass().getName());
		s.append(": ");
	}

	protected void appendIndented(@NonNull MarkupElement object) {
		s.append("\n");
		depth++;
		doSwitch(object);
		depth--;
	}

	protected void appendIndented(@NonNull Iterable<MarkupElement> objects) {
		s.append("\n");
		depth++;
		for (MarkupElement element : objects) {
			doSwitch(element);
		}
		depth--;
	}

	@Override
	public StringBuilder caseBulletElement(BulletElement object) {
		assert object != null;
		appendClass(object);
		s.append(" ");
		s.append(object.getLevel());
		List<MarkupElement> elements = object.getElements();
		assert elements != null;
		appendIndented(elements);
		return s;
	}

	@Override
	public StringBuilder caseCompoundElement(CompoundElement object) {
		assert object != null;
		appendClass(object);
		List<MarkupElement> elements = object.getElements();
		assert elements != null;
		appendIndented(elements);
		return s;
	}

	@Override
	public StringBuilder caseFigureElement(FigureElement object) {
		assert object != null;
		appendClass(object);
		s.append(" ");
		s.append(object.getSrc());
		s.append(" ");
		s.append(object.getAlt());
		s.append(" ");
		s.append(object.getRequiredWidth());
		s.append(" ");
		s.append(object.getRequiredHeight());
		s.append("\n");
		return s;
	}

	@Override
	public StringBuilder caseFigureRefElement(FigureRefElement object) {
		assert object != null;
		appendClass(object);
		s.append(" ");
		s.append(object.getRef().getDef());
		s.append("\n");
		return s;
	}

	@Override
	public StringBuilder caseFontElement(FontElement object) {
		assert object != null;
		String font = object.getFont();
		appendClass(object);
		s.append(font);
		List<MarkupElement> elements = object.getElements();
		assert elements != null;
		appendIndented(elements);
		return s;
	}

	@Override
	public StringBuilder caseHeadingElement(HeadingElement object) {
		assert object != null;
		appendClass(object);
		s.append(" ");
		s.append(object.getLevel());
		List<MarkupElement> elements = object.getElements();
		assert elements != null;
		appendIndented(elements);
		return s;
	}

	@Override
	public StringBuilder caseNewLineElement(NewLineElement object) {
		assert object != null;
		appendClass(object);
		s.append(object.getText().replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t"));
		s.append("\n");
		return s;
	}

	@Override
	public StringBuilder caseTextElement(TextElement object) {
		assert object != null;
		appendClass(object);
		for (String text : object.getText()) {
			s.append(text.replace("\t", "\\t"));
		}
		s.append("\n");
		return s;
	}

	@Override
	public StringBuilder defaultCase(EObject object) {
		assert object != null;
		appendClass(object);
		s.append("\n");
		return s;
	}

	@Override
	public String toString() {
		return s.toString();
	}
}

