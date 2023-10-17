/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class BaseValueConverterService extends AbstractDeclarativeValueConverterService
{
	//
	//	The seemingly redundant Identifier as well as ID converters are needed. During serialization
	//	the exact rule-specific converter is used.
	//
	protected static abstract class AbstractIDConverter extends AbstractNullSafeConverter<String>
	{
		@Override
		protected String internalToValue(String string, INode node) {
			int length = string.length();
			if (string.startsWith("_'") && (length >= 3) && string.endsWith("'")) {
				return StringUtil.convertFromOCLString(string.substring(2, length-1));
			}
			else if (string.startsWith("'") && (length >= 2) && string.endsWith("'")) {
				return string.substring(1, length-1);
			}
			else if (string.startsWith("\"") && (length >= 2) && string.endsWith("\"")) {
				return string.substring(1, length-1);
			}
			else {
				return string;
			}
		}
	}

	protected static class BinaryOperatorNameConverter implements IValueConverter<String>
	{
		private final Set<String> navigationOperatorNameKeywords;

		protected static Set<String> computeKeywords(Grammar grammar) {
			Set<String> keywords = getAllKeywords(grammar, "NavigationOperatorName", false);
			return keywords;
		}

		public BinaryOperatorNameConverter(Grammar grammar) {
			navigationOperatorNameKeywords = computeKeywords(grammar);
			//			printKeywords("NavigationOperatorName", navigationOperatorNameKeywords);
		}

		@Override
		public String toValue(String string, INode node) {
			return string.trim();
		}

		@Override
		public String toString(String value) {
			if (navigationOperatorNameKeywords.contains(value)) {
				return value.toString();
			}
			else {
				return " " + value.toString() + " ";
			}
		}
	}

	protected static class DoubleQuotedStringConverter extends AbstractNullSafeConverter<String>
	{
		@Override
		protected String internalToValue(String string, INode node) {
			try {
				String result = string.substring(1, string.length() - 1);
				assert result != null;
				return StringUtil.convertFromOCLString(result);
			} catch(IllegalArgumentException e) {
				throw new ValueConverterException(e.getMessage(), node, e);
			}
		}

		@Override
		protected String internalToString(String value) {
			return '"' + StringUtil.convertToOCLString(value) + '"';
		}
	}

	protected static class EscapedIDConverter extends AbstractIDConverter
	{
		@Override
		protected String internalToString(String value) {	// Never called
			return value;
		}
	}

	protected static class IDConverter extends AbstractIDConverter
	{
		private final Set<String> allKeywords;

		public IDConverter(Grammar grammar) {
			allKeywords = GrammarUtil.getAllKeywords(grammar);
		}

		@Override
		protected String internalToString(String value) {
			if (allKeywords.contains(value)) {
				return escapeIdentifier(value);
			}
			else if (!PivotUtilInternal.isValidIdentifier(value)) {
				return escapeIdentifier(value);
			}
			else {
				return value;
			}
		}
	}

	protected static class MultiLineSingleQuotedStringConverter extends AbstractNullSafeConverter<String>
	{
		@Override
		protected String internalToValue(String string, INode node) {
			try {
				String result = string.substring(2, string.length() - 2);
				assert result != null;
				return StringUtil.convertFromOCLString(result);
			} catch(IllegalArgumentException e) {
				throw new ValueConverterException(e.getMessage(), node, e);
			}
		}

		@Override
		protected String internalToString(String value) {
			return "'" + StringUtil.convertToOCLString(value) + "'";
		}
	}

	protected static class NameConverter extends AbstractIDConverter
	{
		private final Set<String> nameKeywords;

		protected static Set<String> computeKeywords(Grammar grammar) {
			Set<String> keywords = new HashSet<String>(GrammarUtil.getAllKeywords(grammar));
			keywords.removeAll(getAllKeywords(grammar, "UnrestrictedName", true));
			keywords.removeAll(getAllKeywords(grammar, "EssentialOCLReservedKeyword", true));
			keywords.removeAll(getAllKeywords(grammar, "RestrictedKeywords", true));
			keywords.removeAll(getAllKeywords(grammar, "CollectionTypeIdentifier", true));
			keywords.removeAll(getAllKeywords(grammar, "PrimitiveTypeIdentifier", true));
			return keywords;
		}

		public NameConverter(Grammar grammar) {
			nameKeywords = computeKeywords(grammar);
			//			printKeywords("Name", nameKeywords);
		}

		@Override
		protected String internalToString(String value) {
			if (nameKeywords.contains(value)) {
				return escapeIdentifier(value);
			}
			else if (!PivotUtilInternal.isValidIdentifier(value)) {
				return escapeIdentifier(value);
			}
			else {
				return value;
			}
		}
	}

	protected static class NumberConverter implements IValueConverter<Number>
	{
		@Override
		public Number toValue(String string, INode node) {
			if (Strings.isEmpty(string))
				throw new ValueConverterException("Couldn't convert empty string to number", node, null);
			try {
				if (string.contains(".") || string.contains("e") || string.contains("e")) {
					return new BigDecimal(string);
				}
				else {
					return new BigInteger(string);
				}
			} catch (NumberFormatException e) {
				throw new ValueConverterException("Couldn't convert '"+string+"' to number", node, e);
			}
		}

		@Override
		public String toString(Number value) {
			return value.toString();
		}
	}

	protected static class SimpleIDConverter extends AbstractNullSafeConverter<String>
	{
		@Override
		protected String internalToValue(String string, INode node) {
			return string;
		}

		@Override
		protected String internalToString(String value) {		// Never called
			return value;
		}
	}

	protected static class SingleQuotedStringConverter extends AbstractNullSafeConverter<String>
	{
		@Override
		protected String internalToValue(String string, INode node) {
			try {
				String result = string.substring(1, string.length() - 1);
				assert result != null;
				return StringUtil.convertFromOCLString(result);
			} catch(IllegalArgumentException e) {
				throw new ValueConverterException(e.getMessage(), node, e);
			}
		}

		@Override
		protected String internalToString(String value) {
			return "'" + StringUtil.convertToOCLString(value) + "'";
		}
	}

	protected static class UnquotedStringConverter extends AbstractNullSafeConverter<String>
	{
		@Override
		protected String internalToValue(String string, INode node) {
			try {
				String result = string.substring(1, string.length() - 1);
				assert result != null;
				return StringUtil.convertFromOCLString(result);
			} catch(IllegalArgumentException e) {
				throw new ValueConverterException(e.getMessage(), node, e);
			}
		}

		@Override
		protected String internalToString(String value) {
			value = value.replace("\r", "");
			int lastComment = value.lastIndexOf("--");
			if (lastComment >= 0) {
				int lastNewLine = value.lastIndexOf("\n");
				if (lastNewLine < lastComment) {
					value = value + "\n";				// Avoid the trailing ';' getting added within the comment
				}
			}
			//			if ((value.length() > 0) && (value.charAt(0) == '\n')) {
			//				value = " " + value;
			//			}
			return value;
		}
	}

	protected static class UnreservedNameConverter extends AbstractIDConverter
	{
		private final Set<String> reservedKeywords;

		protected static Set<String> computeReservedKeywords(Grammar grammar) {
			Set<String> keywords = new HashSet<String>(GrammarUtil.getAllKeywords(grammar));
			//			printKeywords("All", keywords);
			Set<String> unreservedNames = getAllKeywords(grammar, "UnreservedName", true);
			//			printKeywords("Unreserved", unreservedNames);
			keywords.removeAll(unreservedNames);
			return keywords;
		}

		public UnreservedNameConverter(Grammar grammar) {
			reservedKeywords = computeReservedKeywords(grammar);
			//			printKeywords("Reserved", reservedKeywords);
		}

		@Override
		protected String internalToString(String value) {
			if (reservedKeywords.contains(value)) {
				return escapeIdentifier(value);
			}
			else if (!PivotUtilInternal.isValidIdentifier(value)) {
				return escapeIdentifier(value);
			}
			else {
				return value;
			}
		}
	}

	protected static class UnrestrictedNameConverter extends AbstractIDConverter
	{
		private final Set<String> restrictedKeywords;

		protected static Set<String> computeRestrictedKeywords(Grammar grammar) {
			Set<String> keywords = new HashSet<String>(GrammarUtil.getAllKeywords(grammar));
			Set<String> unrestrictedNames = getAllKeywords(grammar, "UnrestrictedName", true);
			//			printKeywords("Unrestricted", unrestrictedNames);
			keywords.removeAll(unrestrictedNames);
			return keywords;
		}

		public UnrestrictedNameConverter(Grammar grammar) {
			restrictedKeywords = computeRestrictedKeywords(grammar);
			//			printKeywords("Restricted", restrictedKeywords);
		}

		@Override
		protected String internalToString(String value) {
			if (restrictedKeywords.contains(value)) {
				return escapeIdentifier(value);
			}
			else if (!PivotUtilInternal.isValidIdentifier(value)) {
				return escapeIdentifier(value);
			}
			else {
				return value;
			}
		}
	}

	protected static class UpperConverter extends AbstractNullSafeConverter<Integer>
	{
		@Override
		public Integer internalToValue(String string, INode node) {
			if (Strings.isEmpty(string))
				throw new ValueConverterException("Couldn't convert empty string to integer", node, null);
			try {
				if ("*".equals(string)) {
					return Integer.valueOf(-1);
				}
				return Integer.valueOf(string);
			} catch (NumberFormatException e) {
				throw new ValueConverterException("Couldn't convert '"+string+"' to integer", node, e);
			}
		}

		@Override
		public String internalToString(Integer value) {
			return value >= 0 ? value.toString() : "*";
		}
	}

	public static String escapeIdentifier(String value) {
		return "_'" + StringUtil.convertToOCLString(value) + "'";
	}

	public static Set<String> getAllKeywords(Grammar g, String name, boolean validIdentifiersOnly) {
		Set<String> kws = new HashSet<String>();
		List<ParserRule> rules = GrammarUtil.allParserRules(g);
		for (ParserRule parserRule : rules) {
			if (parserRule.getName().equals(name)) {
				getAllKeywords(kws, parserRule, validIdentifiersOnly);
			}
		}
		return kws;
	}

	private static void getAllKeywords(Set<String> kws, AbstractRule parserRule, boolean validIdentifiersOnly) {
		for (TreeIterator<EObject> tit = parserRule.eAllContents(); tit.hasNext(); ) {
			Object ele = tit.next();
			if (ele instanceof Keyword) {
				String value = ((Keyword)ele).getValue();
				if (!validIdentifiersOnly || PivotUtilInternal.isValidIdentifier(value)) {
					kws.add(value);
				}
			}
			else if (ele instanceof RuleCall) {
				getAllKeywords(kws, ((RuleCall)ele).getRule(), validIdentifiersOnly);
			}
		}
	}

	//	private static void printKeywords(String prefix, Collection<String> keywords) {
	//		List<String> list = new ArrayList<String>(keywords);
	//		Collections.sort(list);
	//		System.out.println(prefix + ": " + StringUtils.splice(list, ", "));
	//	}

	private BinaryOperatorNameConverter binaryOperatorNameConverter = null;			// not static - grammar-dependent
	private static DoubleQuotedStringConverter doubleQuotedStringConverter = null;
	private static EscapedIDConverter escapedIDConverter = null;
	private IDConverter idConverter = null; 										// not static - grammar-dependent
	private static MultiLineSingleQuotedStringConverter multiLineSingleQuotedStringConverter = null;
	private NameConverter nameConverter = null; 									// not static - grammar-dependent
	private static NumberConverter numberConverter = null;
	private static SimpleIDConverter simpleIDConverter = null;
	private static SingleQuotedStringConverter singleQuotedStringConverter = null;
	private static UnquotedStringConverter unquotedStringConverter = null;
	private UnreservedNameConverter unreservedNameConverter = null; 				// not static - grammar-dependent
	private UnrestrictedNameConverter unrestrictedNameConverter = null; 			// not static - grammar-dependent
	private static UpperConverter upperConverter = null;
	private static SingleQuotedStringConverter uriConverter = null;

	@ValueConverter(rule = "BinaryOperatorName")
	public IValueConverter<String> BinaryOperatorName() {
		if (binaryOperatorNameConverter == null) {
			binaryOperatorNameConverter = new BinaryOperatorNameConverter(getGrammar());
		}
		return binaryOperatorNameConverter;
	}

	@ValueConverter(rule = "DOUBLE_QUOTED_STRING")
	public IValueConverter<String> DOUBLE_QUOTED_STRING() {
		if (doubleQuotedStringConverter == null) {
			doubleQuotedStringConverter = new DoubleQuotedStringConverter();
		}
		return doubleQuotedStringConverter;
	}

	@ValueConverter(rule = "ESCAPED_ID")
	public IValueConverter<String> ESCAPED_ID() {
		if (escapedIDConverter == null) {
			escapedIDConverter = new EscapedIDConverter();
		}
		return escapedIDConverter;
	}

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		if (idConverter == null) {
			idConverter = new IDConverter(getGrammar());
		}
		return idConverter;
	}

	@ValueConverter(rule = "Identifier")
	public IValueConverter<String> Identifier() {
		return ID();
	}

	@ValueConverter(rule = "ML_SINGLE_QUOTED_STRING")
	public IValueConverter<String> ML_SINGLE_QUOTED_STRING() {
		if (multiLineSingleQuotedStringConverter == null) {
			multiLineSingleQuotedStringConverter = new MultiLineSingleQuotedStringConverter();
		}
		return multiLineSingleQuotedStringConverter;
	}

	@ValueConverter(rule = "Name")
	public IValueConverter<String> Name() {
		//		return ID();
		if (nameConverter == null) {
			nameConverter = new NameConverter(getGrammar());
		}
		return nameConverter;
	}

	@ValueConverter(rule = "NUMBER_LITERAL")
	public IValueConverter<Number> NUMBER_LITERAL() {
		if (numberConverter == null) {
			numberConverter = new NumberConverter();
		}
		return numberConverter;
	}

	@ValueConverter(rule = "SIMPLE_ID")
	public IValueConverter<String> SIMPLE_ID() {
		if (simpleIDConverter == null) {
			simpleIDConverter = new SimpleIDConverter();
		}
		return simpleIDConverter;
	}

	@ValueConverter(rule = "SINGLE_QUOTED_STRING")
	public IValueConverter<String> SINGLE_QUOTED_STRING() {
		if (singleQuotedStringConverter == null) {
			singleQuotedStringConverter = new SingleQuotedStringConverter();
		}
		return singleQuotedStringConverter;
	}

	@ValueConverter(rule = "StringLiteral")
	public IValueConverter<String> StringLiteral() {
		return SINGLE_QUOTED_STRING();
	}

	@ValueConverter(rule = "UNQUOTED_STRING")
	public IValueConverter<String> UNQUOTED_STRING() {
		if (unquotedStringConverter == null) {
			unquotedStringConverter = new UnquotedStringConverter();
		}
		return unquotedStringConverter;
	}

	@ValueConverter(rule = "URI")
	public IValueConverter<String> URI() {
		if (uriConverter == null) {
			uriConverter = new SingleQuotedStringConverter();
		}
		return uriConverter;
	}

	@ValueConverter(rule = "UnreservedName")
	public IValueConverter<String> UnreservedName() {
		if (unreservedNameConverter == null) {
			unreservedNameConverter = new UnreservedNameConverter(getGrammar());
		}
		return unreservedNameConverter;
	}

	@ValueConverter(rule = "UnrestrictedName")
	public IValueConverter<String> UnrestrictedName() {
		if (unrestrictedNameConverter == null) {
			unrestrictedNameConverter = new UnrestrictedNameConverter(getGrammar());
		}
		return unrestrictedNameConverter;
	}

	@ValueConverter(rule = "UPPER")
	public IValueConverter<Integer> UPPER() {
		if (upperConverter == null) {
			upperConverter = new UpperConverter();
		}
		return upperConverter;
	}
}
