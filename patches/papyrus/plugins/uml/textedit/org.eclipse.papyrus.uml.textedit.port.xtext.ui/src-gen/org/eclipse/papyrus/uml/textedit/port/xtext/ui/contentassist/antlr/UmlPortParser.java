/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

public class UmlPortParser extends AbstractContentAssistParser {

	@Inject
	private UmlPortGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.antlr.internal.InternalUmlPortParser createParser() {
		org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.antlr.internal.InternalUmlPortParser result = new org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.antlr.internal.InternalUmlPortParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getPortRuleAccess().getAlternatives_3_2(), "rule__PortRule__Alternatives_3_2");
					put(grammarAccess.getBoundSpecificationAccess().getValueAlternatives_0(), "rule__BoundSpecification__ValueAlternatives_0");
					put(grammarAccess.getUnlimitedLiteralAccess().getAlternatives(), "rule__UnlimitedLiteral__Alternatives");
					put(grammarAccess.getModifierSpecificationAccess().getAlternatives(), "rule__ModifierSpecification__Alternatives");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getRealValueAccess().getAlternatives(), "rule__RealValue__Alternatives");
					put(grammarAccess.getVisibilityKindAccess().getAlternatives(), "rule__VisibilityKind__Alternatives");
					put(grammarAccess.getModifierKindAccess().getAlternatives(), "rule__ModifierKind__Alternatives");
					put(grammarAccess.getBooleanLiteralsAccess().getAlternatives(), "rule__BooleanLiterals__Alternatives");
					put(grammarAccess.getPortRuleAccess().getGroup(), "rule__PortRule__Group__0");
					put(grammarAccess.getPortRuleAccess().getGroup_3(), "rule__PortRule__Group_3__0");
					put(grammarAccess.getTypeRuleAccess().getGroup(), "rule__TypeRule__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getMultiplicityRuleAccess().getGroup(), "rule__MultiplicityRule__Group__0");
					put(grammarAccess.getMultiplicityRuleAccess().getGroup_1(), "rule__MultiplicityRule__Group_1__0");
					put(grammarAccess.getModifiersRuleAccess().getGroup(), "rule__ModifiersRule__Group__0");
					put(grammarAccess.getModifiersRuleAccess().getGroup_2(), "rule__ModifiersRule__Group_2__0");
					put(grammarAccess.getModifiersRuleAccess().getGroup_2_1(), "rule__ModifiersRule__Group_2_1__0");
					put(grammarAccess.getRedefinesRuleAccess().getGroup(), "rule__RedefinesRule__Group__0");
					put(grammarAccess.getSubsetsRuleAccess().getGroup(), "rule__SubsetsRule__Group__0");
					put(grammarAccess.getDefaultValueRuleAccess().getGroup(), "rule__DefaultValueRule__Group__0");
					put(grammarAccess.getRealValueAccess().getGroup_0(), "rule__RealValue__Group_0__0");
					put(grammarAccess.getRealValueAccess().getGroup_1(), "rule__RealValue__Group_1__0");
					put(grammarAccess.getRealValueAccess().getGroup_2(), "rule__RealValue__Group_2__0");
					put(grammarAccess.getNullValueAccess().getGroup(), "rule__NullValue__Group__0");
					put(grammarAccess.getNoValueAccess().getGroup(), "rule__NoValue__Group__0");
					put(grammarAccess.getPortRuleAccess().getVisibilityAssignment_0(), "rule__PortRule__VisibilityAssignment_0");
					put(grammarAccess.getPortRuleAccess().getDerivedAssignment_1(), "rule__PortRule__DerivedAssignment_1");
					put(grammarAccess.getPortRuleAccess().getNameAssignment_2(), "rule__PortRule__NameAssignment_2");
					put(grammarAccess.getPortRuleAccess().getConjugatedAssignment_3_1(), "rule__PortRule__ConjugatedAssignment_3_1");
					put(grammarAccess.getPortRuleAccess().getTypeAssignment_3_2_0(), "rule__PortRule__TypeAssignment_3_2_0");
					put(grammarAccess.getPortRuleAccess().getTypeUndefinedAssignment_3_2_1(), "rule__PortRule__TypeUndefinedAssignment_3_2_1");
					put(grammarAccess.getPortRuleAccess().getMultiplicityAssignment_4(), "rule__PortRule__MultiplicityAssignment_4");
					put(grammarAccess.getPortRuleAccess().getModifiersAssignment_5(), "rule__PortRule__ModifiersAssignment_5");
					put(grammarAccess.getPortRuleAccess().getDefaultAssignment_6(), "rule__PortRule__DefaultAssignment_6");
					put(grammarAccess.getVisibilityRuleAccess().getVisibilityAssignment(), "rule__VisibilityRule__VisibilityAssignment");
					put(grammarAccess.getTypeRuleAccess().getPathAssignment_0(), "rule__TypeRule__PathAssignment_0");
					put(grammarAccess.getTypeRuleAccess().getTypeAssignment_1(), "rule__TypeRule__TypeAssignment_1");
					put(grammarAccess.getQualifiedNameAccess().getPathAssignment_0(), "rule__QualifiedName__PathAssignment_0");
					put(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2(), "rule__QualifiedName__RemainingAssignment_2");
					put(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1_0(), "rule__MultiplicityRule__BoundsAssignment_1_0");
					put(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2(), "rule__MultiplicityRule__BoundsAssignment_2");
					put(grammarAccess.getBoundSpecificationAccess().getValueAssignment(), "rule__BoundSpecification__ValueAssignment");
					put(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_0(), "rule__ModifiersRule__ValuesAssignment_2_0");
					put(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1_1(), "rule__ModifiersRule__ValuesAssignment_2_1_1");
					put(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0(), "rule__ModifierSpecification__ValueAssignment_0");
					put(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1(), "rule__ModifierSpecification__RedefinesAssignment_1");
					put(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2(), "rule__ModifierSpecification__SubsetsAssignment_2");
					put(grammarAccess.getRedefinesRuleAccess().getPortAssignment_1(), "rule__RedefinesRule__PortAssignment_1");
					put(grammarAccess.getSubsetsRuleAccess().getPortAssignment_1(), "rule__SubsetsRule__PortAssignment_1");
					put(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1(), "rule__DefaultValueRule__DefaultAssignment_1");
					put(grammarAccess.getIntValueAccess().getLiteralIntegerAssignment(), "rule__IntValue__LiteralIntegerAssignment");
					put(grammarAccess.getStringValueAccess().getLiteralStringAssignment(), "rule__StringValue__LiteralStringAssignment");
					put(grammarAccess.getBooleanValueAccess().getLiteralBooleanAssignment(), "rule__BooleanValue__LiteralBooleanAssignment");
					put(grammarAccess.getRealValueAccess().getIntegerAssignment_0_0(), "rule__RealValue__IntegerAssignment_0_0");
					put(grammarAccess.getRealValueAccess().getFractionAssignment_1_1(), "rule__RealValue__FractionAssignment_1_1");
					put(grammarAccess.getRealValueAccess().getIntegerAssignment_2_0(), "rule__RealValue__IntegerAssignment_2_0");
					put(grammarAccess.getRealValueAccess().getFractionAssignment_2_2(), "rule__RealValue__FractionAssignment_2_2");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.antlr.internal.InternalUmlPortParser typedParser = (org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.antlr.internal.InternalUmlPortParser) parser;
			typedParser.entryRulePortRule();
			return typedParser.getFollowElements();
		} catch (RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public UmlPortGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(UmlPortGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}