/*******************************************************************************
 * Copyright (c) 2005 - 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

public class XMLMixedContentFormatter {
	protected final static EStructuralFeature XML_COMMENT = XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT;
	protected final static EStructuralFeature XML_TEXT = XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT;

	protected boolean formatComments = true;

	protected String indetationString = "  ";

	protected int indetationWidth = 0;

	protected int maxLineWidth = 80;
	
	protected String lineSeparator = "\n";
	
	protected boolean beautifyFeatuerMapTextEntries(int prefix, FeatureMap map) {
		boolean needsFinal = false;
		for (FeatureMap.Entry e : new ArrayList<FeatureMap.Entry>(map)) {
			if (e.getEStructuralFeature() == XML_TEXT
					&& e.getValue() instanceof String) {
				String b = beautifyString((String) e.getValue());
				if (b == null || b.equals(""))
					map.remove(e);
				else {
					if (needsWrap(prefix, b)) {
						needsFinal = true;
						b = wordWrap(prefix, b);
					}
					map.setValue(map.indexOf(e), b);
				}
			}
		}
		return needsFinal;
	}

	protected void beautifyFeatureMap(int prefix, FeatureMap map) {
		boolean needsFinal = beautifyFeatuerMapTextEntries(prefix, map);

		if (formatComments)
			beautifyFeatureMapComments(prefix, map);

		if (beautifyFeatureMapIndent(prefix, map))
			needsFinal = true;

		if (needsFinal) {
			int last = map.size() - 1;
			String pref = lineSeparator + getPrefix(prefix - 1);
			if (map.get(last).getEStructuralFeature() == XML_TEXT)
				map.setValue(last, trimRight(map.getValue(last)) + pref);
			else
				map.add(XML_TEXT, pref);
		}
	}

	protected void beautifyFeatureMapComments(int prefix, FeatureMap map) {
		for (FeatureMap.Entry e : new ArrayList<FeatureMap.Entry>(map)) {
			if (processFeature(e.getEStructuralFeature())
					&& e.getEStructuralFeature() == XML_COMMENT
					&& e.getValue() instanceof String) {
				String cmt = beautifyString(e.getValue().toString()).trim();
				if (needsWrap(prefix, cmt))
					cmt = wordWrap(prefix + 1, cmt) + lineSeparator + getPrefix(prefix);
				else
					cmt = " " + cmt + " ";
				map.setValue(map.indexOf(e), cmt);
			}
		}
	}

	protected boolean beautifyFeatureMapIndent(int prefix, FeatureMap map) {
		boolean needsFinal = false;
		for (FeatureMap.Entry e : new ArrayList<FeatureMap.Entry>(map)) {
			if (processFeature(e.getEStructuralFeature())
					&& e.getEStructuralFeature() != XML_TEXT) {
				if (prefix > 0)
					insertBefore(map, e, lineSeparator + getPrefix(prefix));
				needsFinal = true;
			}
		}
		return needsFinal;
	}

	public void beautifyMixedContent(int prefix, EObject obj) {
		for (EObject o : obj.eContents())
			beautifyMixedContent(prefix + 1, o);

		for (EStructuralFeature f : obj.eClass().getEAllStructuralFeatures())
			if (!f.isTransient()
					&& f.isMany()
					&& f.getEType().getInstanceClass() == FeatureMap.Entry.class)
				beautifyFeatureMap(prefix, (FeatureMap) obj.eGet(f));
	}

	protected String beautifyString(String str) {
		return str.replaceAll("[\n\r\t]", " ").replaceAll(" {2,}", " ");
	}

	public String getIndetationString() {
		return indetationString;
	}

	public int getIndetationWidth() {
		return indetationWidth;
	}

	protected int getInWidth() {
		return (indetationWidth == 0) ? indetationString.length()
				: indetationWidth;
	}

	public int getMaxLineWidth() {
		return maxLineWidth;
	}

	protected String getPrefix(int level) {
		StringBuffer r = new StringBuffer();
		for (int i = 0; i < level; i++)
			r.append(indetationString);
		return r.toString();
	}

	protected void insertBefore(FeatureMap map, Entry ent, String str) {
		int index = map.indexOf(ent);
		if (index > 0 && map.get(index - 1).getEStructuralFeature() == XML_TEXT)
			map.setValue(index - 1, trimRight(map.getValue(index - 1)) + str);
		else
			map.add(index, XML_TEXT, str);
	}

	public boolean isFormatComments() {
		return formatComments;
	}

	protected boolean needsWrap(int prefix, String str) {
		return str.length() + (prefix * getInWidth()) > maxLineWidth;
	}

	protected boolean processFeature(EStructuralFeature feat) {
		int k = ExtendedMetaData.INSTANCE.getFeatureKind(feat);
		return k == ExtendedMetaData.ELEMENT_FEATURE
				|| k == ExtendedMetaData.ELEMENT_ONLY_CONTENT
				|| k == ExtendedMetaData.ELEMENT_WILDCARD_FEATURE;
	}

	public void setFormatComments(boolean formatComments) {
		this.formatComments = formatComments;
	}

	public void setIndetationString(String indetationString) {
		this.indetationString = indetationString;
	}

	public void setIndetationWidth(int indetationWidth) {
		this.indetationWidth = indetationWidth;
	}

	public void setMaxLineWidth(int maxLineWidth) {
		this.maxLineWidth = maxLineWidth;
	}
	
	public void setLineSeparator (String lineSeparator) {
		if (lineSeparator==null || !("\n".equals(lineSeparator) || "\r\n".equals(lineSeparator) )) {
			throw new IllegalArgumentException(lineSeparator);
		}
		this.lineSeparator = lineSeparator;
	}

	protected String trimRight(Object val) {
		if (val instanceof String) {
			String s = val.toString();
			int i = s.length() - 1;
			while (i >= 0 && s.charAt(i) == ' ')
				i--;
			String r = s.substring(0, i + 1);
			return r;
		}
		return "";
	}

	protected String trimLeft(Object val) {
		if (val instanceof String) {
			String s = val.toString();
			int i = 0;
			while (i < s.length() && s.charAt(i) == ' ')
				i++;
			return s.substring(i);
		}
		return "";
	}

	protected String wordWrap(int prefix, String str) {
		str = trimLeft(str);
		int width = Math.max(maxLineWidth - (getInWidth() * prefix), 10);
		int old = 0, pos = width;
		StringBuffer buf = new StringBuffer();
		while ((pos = str.indexOf(' ', pos)) > -1) {
			buf.append(lineSeparator + getPrefix(prefix) + str.substring(old, pos));
			old = pos + 1;
			pos += width;
		}
		if (old < str.length())
			buf.append(lineSeparator + getPrefix(prefix) + str.substring(old));
		return buf.toString();
	}
	

}
