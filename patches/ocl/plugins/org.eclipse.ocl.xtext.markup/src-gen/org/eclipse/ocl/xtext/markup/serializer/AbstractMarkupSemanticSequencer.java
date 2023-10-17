/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.markup.services.MarkupGrammarAccess;
import org.eclipse.ocl.xtext.markupcs.BulletElement;
import org.eclipse.ocl.xtext.markupcs.FigureElement;
import org.eclipse.ocl.xtext.markupcs.FigureRefElement;
import org.eclipse.ocl.xtext.markupcs.FontElement;
import org.eclipse.ocl.xtext.markupcs.FootnoteElement;
import org.eclipse.ocl.xtext.markupcs.HeadingElement;
import org.eclipse.ocl.xtext.markupcs.Markup;
import org.eclipse.ocl.xtext.markupcs.MarkupPackage;
import org.eclipse.ocl.xtext.markupcs.NewLineElement;
import org.eclipse.ocl.xtext.markupcs.NullElement;
import org.eclipse.ocl.xtext.markupcs.OCLCodeElement;
import org.eclipse.ocl.xtext.markupcs.OCLEvalElement;
import org.eclipse.ocl.xtext.markupcs.OCLTextElement;
import org.eclipse.ocl.xtext.markupcs.TextElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractMarkupSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MarkupGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MarkupPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MarkupPackage.BULLET_ELEMENT:
				sequence_BulletElement(context, (BulletElement) semanticObject);
				return;
			case MarkupPackage.FIGURE_ELEMENT:
				sequence_FigureElement(context, (FigureElement) semanticObject);
				return;
			case MarkupPackage.FIGURE_REF_ELEMENT:
				sequence_FigureRefElement(context, (FigureRefElement) semanticObject);
				return;
			case MarkupPackage.FONT_ELEMENT:
				sequence_FontElement(context, (FontElement) semanticObject);
				return;
			case MarkupPackage.FOOTNOTE_ELEMENT:
				sequence_FootnoteElement(context, (FootnoteElement) semanticObject);
				return;
			case MarkupPackage.HEADING_ELEMENT:
				sequence_HeadingElement(context, (HeadingElement) semanticObject);
				return;
			case MarkupPackage.MARKUP:
				sequence_Markup(context, (Markup) semanticObject);
				return;
			case MarkupPackage.NEW_LINE_ELEMENT:
				sequence_NewLineElement(context, (NewLineElement) semanticObject);
				return;
			case MarkupPackage.NULL_ELEMENT:
				sequence_NullElement(context, (NullElement) semanticObject);
				return;
			case MarkupPackage.OCL_CODE_ELEMENT:
				sequence_OCLCodeElement(context, (OCLCodeElement) semanticObject);
				return;
			case MarkupPackage.OCL_EVAL_ELEMENT:
				sequence_OCLEvalElement(context, (OCLEvalElement) semanticObject);
				return;
			case MarkupPackage.OCL_TEXT_ELEMENT:
				sequence_OCLTextElement(context, (OCLTextElement) semanticObject);
				return;
			case MarkupPackage.TEXT_ELEMENT:
				sequence_TextElement(context, (TextElement) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns BulletElement
	 *     BulletElement returns BulletElement
	 *
	 * Constraint:
	 *     (level=INT? elements+=MarkupElement*)
	 * </pre>
	 */
	protected void sequence_BulletElement(ISerializationContext context, BulletElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns FigureElement
	 *     FigureElement returns FigureElement
	 *
	 * Constraint:
	 *     (def=ID? src=STRING (alt=STRING (requiredWidth=INT requiredHeight=INT?)?)?)
	 * </pre>
	 */
	protected void sequence_FigureElement(ISerializationContext context, FigureElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns FigureRefElement
	 *     FigureRefElement returns FigureRefElement
	 *
	 * Constraint:
	 *     ref=[FigureElement|ID]
	 * </pre>
	 */
	protected void sequence_FigureRefElement(ISerializationContext context, FigureRefElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MarkupPackage.Literals.FIGURE_REF_ELEMENT__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MarkupPackage.Literals.FIGURE_REF_ELEMENT__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFigureRefElementAccess().getRefFigureElementIDTerminalRuleCall_2_0_1(), semanticObject.eGet(MarkupPackage.Literals.FIGURE_REF_ELEMENT__REF, false));
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns FontElement
	 *     FontElement returns FontElement
	 *
	 * Constraint:
	 *     ((font='b' | font='e') elements+=MarkupElement*)
	 * </pre>
	 */
	protected void sequence_FontElement(ISerializationContext context, FontElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns FootnoteElement
	 *     FootnoteElement returns FootnoteElement
	 *
	 * Constraint:
	 *     elements+=MarkupElement*
	 * </pre>
	 */
	protected void sequence_FootnoteElement(ISerializationContext context, FootnoteElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns HeadingElement
	 *     HeadingElement returns HeadingElement
	 *
	 * Constraint:
	 *     (level=INT? elements+=MarkupElement*)
	 * </pre>
	 */
	protected void sequence_HeadingElement(ISerializationContext context, HeadingElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     Markup returns Markup
	 *
	 * Constraint:
	 *     elements+=MarkupElement+
	 * </pre>
	 */
	protected void sequence_Markup(ISerializationContext context, Markup semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns NewLineElement
	 *     NewLineElement returns NewLineElement
	 *
	 * Constraint:
	 *     text=NL
	 * </pre>
	 */
	protected void sequence_NewLineElement(ISerializationContext context, NewLineElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MarkupPackage.Literals.NEW_LINE_ELEMENT__TEXT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MarkupPackage.Literals.NEW_LINE_ELEMENT__TEXT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNewLineElementAccess().getTextNLTerminalRuleCall_0(), semanticObject.getText());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns NullElement
	 *     NullElement returns NullElement
	 *
	 * Constraint:
	 *     elements+=MarkupElement*
	 * </pre>
	 */
	protected void sequence_NullElement(ISerializationContext context, NullElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns OCLCodeElement
	 *     OCLCodeElement returns OCLCodeElement
	 *
	 * Constraint:
	 *     elements+=MarkupElement*
	 * </pre>
	 */
	protected void sequence_OCLCodeElement(ISerializationContext context, OCLCodeElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns OCLEvalElement
	 *     OCLEvalElement returns OCLEvalElement
	 *
	 * Constraint:
	 *     elements+=MarkupElement*
	 * </pre>
	 */
	protected void sequence_OCLEvalElement(ISerializationContext context, OCLEvalElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns OCLTextElement
	 *     OCLTextElement returns OCLTextElement
	 *
	 * Constraint:
	 *     elements+=MarkupElement*
	 * </pre>
	 */
	protected void sequence_OCLTextElement(ISerializationContext context, OCLTextElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MarkupElement returns TextElement
	 *     TextElement returns TextElement
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             text+=ID |
	 *             text+=WORD |
	 *             text+=INT |
	 *             text+=WS |
	 *             text+=':' |
	 *             text+='#' |
	 *             text+=','
	 *         )+ |
	 *         text+=MarkupKeyword
	 *     )
	 * </pre>
	 */
	protected void sequence_TextElement(ISerializationContext context, TextElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
