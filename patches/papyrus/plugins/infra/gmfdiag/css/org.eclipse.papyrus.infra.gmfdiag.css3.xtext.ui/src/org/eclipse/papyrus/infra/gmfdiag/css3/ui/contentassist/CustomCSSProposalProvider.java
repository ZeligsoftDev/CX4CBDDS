/*****************************************************************************
 * Copyright (c) 2015, 2017 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *   Christian W. Damus - bug 485220
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 515661
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.css3.ui.contentassist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.decoration.ConnectionDecorationRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.NamedStyleProperties;
import org.eclipse.papyrus.infra.gmfdiag.css.service.StylingService;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.AttributeSelector;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class CustomCSSProposalProvider extends AbstractCSSProposalProvider {


	/** The Constant colorNames. */
	static final Set<String> colorNames = new LinkedHashSet<String>();

	/** The CSS properties of supported semantic classes. */
	static final Set<String> semanticProperties;

	static {
		colorNames.add("aliceblue");//$NON-NLS-1$
		colorNames.add("aqua");//$NON-NLS-1$
		colorNames.add("aquamarine");//$NON-NLS-1$
		colorNames.add("azure");//$NON-NLS-1$
		colorNames.add("beige");//$NON-NLS-1$
		colorNames.add("bisque");//$NON-NLS-1$
		colorNames.add("black");//$NON-NLS-1$
		colorNames.add("blanchedalmond");//$NON-NLS-1$
		colorNames.add("blue");//$NON-NLS-1$
		colorNames.add("blueviolet");//$NON-NLS-1$
		colorNames.add("brown");//$NON-NLS-1$
		colorNames.add("burlywood");//$NON-NLS-1$
		colorNames.add("cadetblue");//$NON-NLS-1$
		colorNames.add("chartreuse");//$NON-NLS-1$
		colorNames.add("chocolate");//$NON-NLS-1$
		colorNames.add("coral");//$NON-NLS-1$
		colorNames.add("cornflowerblue");//$NON-NLS-1$
		colorNames.add("cornsilk");//$NON-NLS-1$
		colorNames.add("crimson");//$NON-NLS-1$
		colorNames.add("cyan");//$NON-NLS-1$
		colorNames.add("darkblue");//$NON-NLS-1$
		colorNames.add("darkcyan");//$NON-NLS-1$
		colorNames.add("darkgoldenrod");//$NON-NLS-1$
		colorNames.add("darkgray");//$NON-NLS-1$
		colorNames.add("darkgrey");//$NON-NLS-1$
		colorNames.add("darkgreen");//$NON-NLS-1$
		colorNames.add("darkkhaki");//$NON-NLS-1$
		colorNames.add("darkmagenta");//$NON-NLS-1$
		colorNames.add("darkolivegreen");//$NON-NLS-1$
		colorNames.add("darkorange");//$NON-NLS-1$
		colorNames.add("darkorchid");//$NON-NLS-1$
		colorNames.add("darkred");//$NON-NLS-1$
		colorNames.add("darksalmon");//$NON-NLS-1$
		colorNames.add("darkseagreen");//$NON-NLS-1$
		colorNames.add("darkslateblue");//$NON-NLS-1$
		colorNames.add("darkslategray");//$NON-NLS-1$
		colorNames.add("darkslategrey");//$NON-NLS-1$
		colorNames.add("darkturquoise");//$NON-NLS-1$
		colorNames.add("darkviolet");//$NON-NLS-1$
		colorNames.add("deeppink");//$NON-NLS-1$
		colorNames.add("deepskyblue");//$NON-NLS-1$
		colorNames.add("dimgray");//$NON-NLS-1$
		colorNames.add("dimgrey");//$NON-NLS-1$
		colorNames.add("dodgerblue");//$NON-NLS-1$
		colorNames.add("firebrick");//$NON-NLS-1$
		colorNames.add("floralwhite");//$NON-NLS-1$
		colorNames.add("forestgreen");//$NON-NLS-1$
		colorNames.add("fuchsia");//$NON-NLS-1$
		colorNames.add("gainsboro");//$NON-NLS-1$
		colorNames.add("ghostwhite");//$NON-NLS-1$
		colorNames.add("gold");//$NON-NLS-1$
		colorNames.add("goldenrod");//$NON-NLS-1$
		colorNames.add("gray");//$NON-NLS-1$
		colorNames.add("grey");//$NON-NLS-1$
		colorNames.add("green");//$NON-NLS-1$
		colorNames.add("greenyellow");//$NON-NLS-1$
		colorNames.add("honeydew");//$NON-NLS-1$
		colorNames.add("hotpink");//$NON-NLS-1$
		colorNames.add("indianred");//$NON-NLS-1$
		colorNames.add("indigo");//$NON-NLS-1$
		colorNames.add("ivory");//$NON-NLS-1$
		colorNames.add("khaki");//$NON-NLS-1$
		colorNames.add("lavender");//$NON-NLS-1$
		colorNames.add("lavenderblush");//$NON-NLS-1$
		colorNames.add("lawngreen");//$NON-NLS-1$
		colorNames.add("lemonchiffon");//$NON-NLS-1$
		colorNames.add("lightblue");//$NON-NLS-1$
		colorNames.add("lightcoral");//$NON-NLS-1$
		colorNames.add("lightcyan");//$NON-NLS-1$
		colorNames.add("lightgoldenrodyellow");//$NON-NLS-1$
		colorNames.add("lightgray");//$NON-NLS-1$
		colorNames.add("lightgrey");//$NON-NLS-1$
		colorNames.add("lightgreen");//$NON-NLS-1$
		colorNames.add("lightpink");//$NON-NLS-1$
		colorNames.add("lightsalmon");//$NON-NLS-1$
		colorNames.add("lightseagreen");//$NON-NLS-1$
		colorNames.add("lightskyblue");//$NON-NLS-1$
		colorNames.add("lightslategray");//$NON-NLS-1$
		colorNames.add("lightslategrey");//$NON-NLS-1$
		colorNames.add("lightsteelblue");//$NON-NLS-1$
		colorNames.add("lightyellow");//$NON-NLS-1$
		colorNames.add("lime");//$NON-NLS-1$
		colorNames.add("limegreen");//$NON-NLS-1$
		colorNames.add("linen");//$NON-NLS-1$
		colorNames.add("magenta");//$NON-NLS-1$
		colorNames.add("maroon");//$NON-NLS-1$
		colorNames.add("mediumaquamarine");//$NON-NLS-1$
		colorNames.add("mediumblue");//$NON-NLS-1$
		colorNames.add("mediumorchid");//$NON-NLS-1$
		colorNames.add("mediumpurple");//$NON-NLS-1$
		colorNames.add("mediumseagreen");//$NON-NLS-1$
		colorNames.add("mediumslateblue");//$NON-NLS-1$
		colorNames.add("mediumspringgreen");//$NON-NLS-1$
		colorNames.add("mediumturquoise");//$NON-NLS-1$
		colorNames.add("mediumvioletred");//$NON-NLS-1$
		colorNames.add("midnightblue");//$NON-NLS-1$
		colorNames.add("mintcream");//$NON-NLS-1$
		colorNames.add("mistyrose");//$NON-NLS-1$
		colorNames.add("moccasin");//$NON-NLS-1$
		colorNames.add("navajowhite");//$NON-NLS-1$
		colorNames.add("navy");//$NON-NLS-1$
		colorNames.add("oldlace");//$NON-NLS-1$
		colorNames.add("olive");//$NON-NLS-1$
		colorNames.add("olivedrab");//$NON-NLS-1$
		colorNames.add("orange");//$NON-NLS-1$
		colorNames.add("orangered");//$NON-NLS-1$
		colorNames.add("orchid");//$NON-NLS-1$
		colorNames.add("palegoldenrod");//$NON-NLS-1$
		colorNames.add("palegreen");//$NON-NLS-1$
		colorNames.add("paleturquoise");//$NON-NLS-1$
		colorNames.add("palevioletred");//$NON-NLS-1$
		colorNames.add("papayawhip");//$NON-NLS-1$
		colorNames.add("peachpuff");//$NON-NLS-1$
		colorNames.add("peru");//$NON-NLS-1$
		colorNames.add("pink");//$NON-NLS-1$
		colorNames.add("plum");//$NON-NLS-1$
		colorNames.add("powderblue");//$NON-NLS-1$
		colorNames.add("purple");//$NON-NLS-1$
		colorNames.add("red");//$NON-NLS-1$
		colorNames.add("rosybrown");//$NON-NLS-1$
		colorNames.add("royalblue");//$NON-NLS-1$
		colorNames.add("saddlebrown");//$NON-NLS-1$
		colorNames.add("salmon");//$NON-NLS-1$
		colorNames.add("sandybrown");//$NON-NLS-1$
		colorNames.add("seagreen");//$NON-NLS-1$
		colorNames.add("seashell");//$NON-NLS-1$
		colorNames.add("sienna");//$NON-NLS-1$
		colorNames.add("silver");//$NON-NLS-1$
		colorNames.add("skyblue");//$NON-NLS-1$
		colorNames.add("slateblue");//$NON-NLS-1$
		colorNames.add("slategray");//$NON-NLS-1$
		colorNames.add("slategrey");//$NON-NLS-1$
		colorNames.add("snow");//$NON-NLS-1$
		colorNames.add("springgreen");//$NON-NLS-1$
		colorNames.add("steelblue");//$NON-NLS-1$
		colorNames.add("tan");//$NON-NLS-1$
		colorNames.add("teal");//$NON-NLS-1$
		colorNames.add("thistle");//$NON-NLS-1$
		colorNames.add("tomato");//$NON-NLS-1$
		colorNames.add("turquoise");//$NON-NLS-1$
		colorNames.add("violet");//$NON-NLS-1$
		colorNames.add("wheat");//$NON-NLS-1$
		colorNames.add("white");//$NON-NLS-1$
		colorNames.add("whitesmoke");//$NON-NLS-1$
		colorNames.add("yellow");//$NON-NLS-1$
		colorNames.add("yellowgreen");//$NON-NLS-1$
	}

	static {
		semanticProperties = supportedSemanticCSSClasses()
				.flatMap(cssClass -> cssClass.getEAllStructuralFeatures().stream())
				.filter(StylingService.getInstance().getSemanticPropertySupportedPredicate())
				.map(EStructuralFeature::getName)
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private static Stream<EClass> supportedSemanticCSSClasses() {
		return StreamSupport.stream(StylingService.getInstance().getSupportedSemanticClasses().spliterator(), false);
	}

	/**
	 * Gets the custom properties.
	 *
	 * @return the custom properties
	 */
	protected Collection<String> getCustomProperties() {
		String[] properties = new String[] {
				"transparency", //$NON-NLS-1$
				"fontSize", //$NON-NLS-1$
				"displayName", //$NON-NLS-1$
				NamedStyleProperties.ELEMENT_ICON,
				NamedStyleProperties.SHADOW,
				NamedStyleProperties.QUALIFIED_NAME_DEPTH,
				"lineStyle", //$NON-NLS-1$
				"lineDashLength", //$NON-NLS-1$
				"lineDashGap", //$NON-NLS-1$
				ConnectionEditPart.TARGET_DECORATION,
				ConnectionEditPart.SOURCE_DECORATION,
				"maskLabel", //$NON-NLS-1$
				"svgFile", //$NON-NLS-1$
				"followSVGSymbol", //$NON-NLS-1$
				"svgCssFile", //$NON-NLS-1$
				"svgCssClass", //$NON-NLS-1$
				"canonical", //$NON-NLS-1$
				NamedStyleProperties.IMAGE_PATH,
				NamedStyleProperties.BORDER_STYLE,
				NamedStyleProperties.BOTTOM_MARGIN_PROPERTY,
				NamedStyleProperties.DISPLAY_BORDER,
				NamedStyleProperties.DISPLAY_FLOATING_LABEL,
				NamedStyleProperties.DISPLAY_HEADER,
				NamedStyleProperties.DISPLAY_STEREOTYPES,
				NamedStyleProperties.DISPLAY_TAGS,
				NamedStyleProperties.FLOATING_LABEL_CONSTRAINED,
				NamedStyleProperties.FLOATING_LABEL_OFFSET_HEIGHT,
				NamedStyleProperties.FLOATING_LABEL_OFFSET_WIDTH,
				NamedStyleProperties.IS_OVAL,
				NamedStyleProperties.IS_PACKAGE,
				NamedStyleProperties.LABEL_CONSTRAINED,
				NamedStyleProperties.LABEL_OFFSET_X,
				NamedStyleProperties.LABEL_OFFSET_Y,
				NamedStyleProperties.LEFT_MARGIN_PROPERTY,
				NamedStyleProperties.LINE_LENGTH,
				NamedStyleProperties.LINE_CUSTOM_VALUE,
				NamedStyleProperties.LINE_LENGTH_RATIO,
				NamedStyleProperties.LINE_POSITION,
				NamedStyleProperties.PORT_POSITION,
				NamedStyleProperties.POSITION,
				NamedStyleProperties.RADIUS_HEIGHT,
				NamedStyleProperties.RADIUS_WIDTH,
				NamedStyleProperties.RIGHT_MARGIN_PROPERTY,
				NamedStyleProperties.SHADOW_COLOR,
				NamedStyleProperties.SHADOW_WIDTH,
				NamedStyleProperties.TEXT_ALIGNMENT,
				NamedStyleProperties.TOP_MARGIN_PROPERTY,
				NamedStyleProperties.USE_ORIGINAL_COLORS,
				NamedStyleProperties.WRAP_NAME,
				NamedStyleProperties.NAME_BACKGROUND_COLOR,
				NamedStyleProperties.IS_PORT_RESIZABLE,
				/* shape provider properties */
				"shapeStereotype",
				"shapeDecorationStereotype",
				NamedStyleProperties.SHAPE_STYLE_PROPERTY,
				NamedStyleProperties.SHAPE_DECORATION_STYLE_PROPERTY,
				"shapeTypedElement",
				"shapeDecorationTypedElement"
		};

		return Arrays.asList(properties);
	}


	/**
	 * Complete css_property_ name.
	 *
	 * @param model
	 *            the model
	 * @param assignment
	 *            the assignment
	 * @param context
	 *            the context
	 * @param acceptor
	 *            the acceptor
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.ui.contentassist.AbstractCSSProposalProvider#completeCss_property_Name(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeCss_property_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		String prefix = context.getPrefix();

		Set<String> allProperties = new HashSet<String>(getStyleProperties());
		allProperties.addAll(getCustomProperties());

		Iterator<String> filterIterator = allProperties.iterator();
		while (filterIterator.hasNext()) {
			if (!filterIterator.next().contains(prefix)) {
				filterIterator.remove();
			}
		}

		for (String property : allProperties) {
			StringBuilder stringBuilder = new StringBuilder(property);
			stringBuilder.append(": ");//$NON-NLS-1$
			acceptor.accept(buildProposal(stringBuilder.toString(), context));
		}

	}

	/**
	 * Complete attribute selector_ value.
	 *
	 * @param model
	 *            the model
	 * @param assignment
	 *            the assignment
	 * @param context
	 *            the context
	 * @param acceptor
	 *            the acceptor
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.ui.contentassist.AbstractCSSProposalProvider#completeAttributeSelector_Value(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeAttributeSelector_Value(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		super.completeAttributeSelector_Value(model, assignment, context, acceptor);
		if ("kind".equals(((AttributeSelector) model).getName())) {//$NON-NLS-1$

			String[] selectorValues = new String[] {
					"Compartment", //$NON-NLS-1$
					"Label", //$NON-NLS-1$
					"FloatingLabel"//$NON-NLS-1$
			};

			for (String proposal : selectorValues) {
				acceptor.accept(createCompletionProposal(proposal, context));
			}
		}
	}

	/**
	 * Complete attribute selector_ name.
	 *
	 * @param model
	 *            the model
	 * @param assignment
	 *            the assignment
	 * @param context
	 *            the context
	 * @param acceptor
	 *            the acceptor
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.ui.contentassist.AbstractCSSProposalProvider#completeAttributeSelector_Name(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeAttributeSelector_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		super.completeAttributeSelector_Name(model, assignment, context, acceptor);

		/** The attribute selector name. */
		String[] attributeSelectorName = {
				"appliedStereotypes", //$NON-NLS-1$
		};

		for (String proposal : attributeSelectorName) {
			acceptor.accept(createCompletionProposal(proposal, context));
		}
	}


	/**
	 * Builds the proposal.
	 *
	 * @param proposal
	 *            the proposal
	 * @param context
	 *            the context
	 * @return the completion proposal
	 */
	protected CompletionProposal buildProposal(final String proposal, final ContentAssistContext context) {
		String prefix = context.getPrefix();
		return new CompletionProposal(proposal, context.getOffset() - prefix.length(), prefix.length(), proposal.length());
	}


	/**
	 * Gets the style properties.
	 *
	 * @return the style properties
	 */
	protected Collection<String> getStyleProperties() {
		Set<String> propertiesNames = new HashSet<String>();
		for (EClass styleClass : EMFHelper.getSubclassesOf(NotationPackage.eINSTANCE.getStyle(), false)) {
			if (styleClass.getEAllSuperTypes().contains(NotationPackage.eINSTANCE.getNamedStyle())) {
				continue;
			}

			for (EStructuralFeature styleFeature : styleClass.getEStructuralFeatures()) {
				propertiesNames.add(styleFeature.getName());
			}
		}

		return propertiesNames;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.ui.contentassist.AbstractCSSProposalProvider#completeStringTok_Value(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeStringTok_Value(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		super.completeStringTok_Value(model, assignment, context, acceptor);

		if (model instanceof css_declaration || model instanceof IdentifierTok) {
			String property = null;
			String prefix = null;
			boolean autocomplete = false;
			// first call as css_declaration
			if (model instanceof css_declaration) {
				css_declaration declaration = (css_declaration) model;
				property = declaration.getProperty().getName();
				prefix = context.getPrefix();
				autocomplete = true;
			} else
			// second call as IdentifierTok without prefix
			if (model instanceof IdentifierTok) {
				IdentifierTok declaration = (IdentifierTok) model;
				prefix = context.getPrefix();
				// Third call IndentifierTok with the good prefix
				if (!prefix.isEmpty()) {
					autocomplete = true;
				}
				if (declaration.eContainer() instanceof css_declaration) {
					property = ((css_declaration) declaration.eContainer()).getProperty().getName();
				}
			}

			// Add possible values for connection decoration
			if (autocomplete && null != property && (property.equals(ConnectionEditPart.SOURCE_DECORATION) || property.equals(ConnectionEditPart.TARGET_DECORATION))) {
				Map<String, Class<? extends RotatableDecoration>> availableDecoration = ConnectionDecorationRegistry.getInstance().getAvailableDecoration();
				List<String> decorations = new ArrayList<String>(availableDecoration.keySet());
				decorations.addAll(Arrays.asList(ConnectionEditPart.DECORATION_VALUES));
				for (String decoration : decorations) {
					if (decoration.contains(prefix)) {
						acceptor.accept(buildProposal(decoration, context));
					}
				}
			}
		}
	}

	/**
	 * Complete color tok_ value.
	 *
	 * @param model
	 *            the model
	 * @param assignment
	 *            the assignment
	 * @param context
	 *            the context
	 * @param acceptor
	 *            the acceptor
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.ui.contentassist.AbstractCSSProposalProvider#completeColorTok_Value(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeColorTok_Value(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		super.completeColorTok_Value(model, assignment, context, acceptor);

		if (model instanceof css_declaration || model instanceof IdentifierTok) {
			String property = null;
			String prefix = null;
			boolean autocomplete = false;
			// first call as css_declaration
			if (model instanceof css_declaration) {
				css_declaration declaration = (css_declaration) model;
				property = declaration.getProperty().getName();
				prefix = context.getPrefix();
				autocomplete = true;
			} else
			// second call as IdentifierTok without prefix
			if (model instanceof IdentifierTok) {
				IdentifierTok declaration = (IdentifierTok) model;
				prefix = context.getPrefix();
				// Third call IndentifierTok with the good prefix
				if (!prefix.isEmpty()) {
					autocomplete = true;
				}
				if (declaration.eContainer() instanceof css_declaration) {
					property = ((css_declaration) declaration.eContainer()).getProperty().getName();
				}
			}

			if (autocomplete && null != property && (property.toLowerCase().contains("color") || property.toLowerCase().contains("gradient"))) {//$NON-NLS-1$ //$NON-NLS-2$
				for (String colorName : colorNames) {
					if (colorName.contains(prefix)) {
						acceptor.accept(buildProposal(colorName, context));
					}
				}
			}
		}
	}


	/**
	 * Complete_selector.
	 *
	 * @param model
	 *            the model
	 * @param ruleCall
	 *            the rule call
	 * @param context
	 *            the context
	 * @param acceptor
	 *            the acceptor
	 * @see org.eclipse.papyrus.infra.gmfdiag.css3.ui.contentassist.AbstractCSSProposalProvider#complete_selector(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.RuleCall, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void complete_selector(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		super.complete_selector(model, ruleCall, context, acceptor);

		supportedSemanticCSSClasses()
				.filter(cssClass -> cssClass.getName().contains(context.getPrefix()))
				.forEach(cssClass -> acceptor.accept(buildProposal(cssClass.getName(), context)));

		String[] otherSemanticElements = new String[] {
				"Compartment", //$NON-NLS-1$
				"Label", //$NON-NLS-1$
				"CommentLink", //$NON-NLS-1$
				"ConstraintLink", //$NON-NLS-1$
				"ContextLink", //$NON-NLS-1$
				"StereotypePropertyReferenceLink", //$NON-NLS-1$
				"StereotypeCommentLink"//$NON-NLS-1$
		};

		for (String element : otherSemanticElements) {
			if (element.contains(context.getPrefix())) {
				acceptor.accept(buildProposal(element, context));
			}
		}
	}

	/**
	 * Complete_ identifier.
	 *
	 * @param model
	 *            the model
	 * @param ruleCall
	 *            the rule call
	 * @param context
	 *            the context
	 * @param acceptor
	 *            the acceptor
	 * @see org.eclipse.papyrus.infra.gmfdiag.ui.contentassist.AbstractCSSProposalProvider#complete_ID(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.RuleCall, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void complete_Identifier(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		if (model instanceof AttributeSelector) {
			String prefix = context.getPrefix();
			if (prefix.startsWith("[")) {//$NON-NLS-1$
				prefix = prefix.substring(1);
			}

			for (String semanticProperty : semanticProperties) {
				if (semanticProperty.contains(prefix)) {
					acceptor.accept(buildProposal(semanticProperty, context));
				}
			}
		} else {
			super.complete_Identifier(model, ruleCall, context, acceptor);
		}
	}
}
