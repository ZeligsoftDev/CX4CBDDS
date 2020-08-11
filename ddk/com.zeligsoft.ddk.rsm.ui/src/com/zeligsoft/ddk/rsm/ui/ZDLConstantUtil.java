/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.zeligsoft.ddk.rsm.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * ZDL Constant generator helper functions.
 * 
 * @author jcorchis
 * 
 */
public class ZDLConstantUtil {

	/**
	 * Converts a camel case String into an upper-case underscored version. For
	 * example: FooBar->FOO_BAR ABC_OneTwoThree->ABC__ONE_TWO_THREE
	 * 
	 * @param str
	 * @return
	 */
	public static String camel2UpperWithUnderscore(String str) {
		Pattern p = Pattern.compile("\\p{Lu}+");//$NON-NLS-1$
		Matcher matcher = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean first = true;
		while (matcher.find()) {
			matcher.appendReplacement(sb, first
				? "" + matcher.group() : "_" + matcher.group());//$NON-NLS-1$ //$NON-NLS-2$
			first = false;
		}
		matcher.appendTail(sb);
		return sb.toString().toUpperCase();
	}

	/**
	 * Returns the collection of owned EnumerationLiterals for the given
	 * Enumeration.
	 * 
	 * @param enumeration
	 * @return
	 */
	public static List<EnumerationLiteral> getEnumerationLiterals(
			Enumeration enumeration) {
		// TODO: Remove me when Xpand supports introspection of
		// EnumerationLiterals
		List<EnumerationLiteral> literals = enumeration.getOwnedLiterals();
		List<EnumerationLiteral> result = new ArrayList<EnumerationLiteral>(
			literals);
		Collections.sort(result, new Comparator<EnumerationLiteral>() {

			@Override
			public int compare(EnumerationLiteral o1, EnumerationLiteral o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});
		return result;
	}

	/**
	 * 
	 * @param enumLiteral
	 * @return
	 */
	public static String getEnumerationLiteralName(
			EnumerationLiteral enumLiteral) {
		// TODO: Remove me when Xpand supports introspection of
		// EnumerationLiterals
		return enumLiteral.getName();
	}

	/**
	 * Returns the Enumeration that owns the provided EnumerationLiteral
	 * 
	 * @param enumLiteral
	 *            an EnumerationLiteral
	 * @return
	 */
	public static Enumeration getEnumeration(EnumerationLiteral enumLiteral) {
		// TODO: Remove me when Xpand supports introspection of
		// EnumerationLiterals
		return (Enumeration) enumLiteral.getOwner();
	}
	
	public static String getNamedElementName(NamedElement element) {
		return element.getName();
	}
	
	public static String getResourceURIString(EObject eObject) {
		return EcoreUtil.getRootContainer(eObject).eResource().getURI()
			.trimFileExtension()
			.appendFileExtension(UMLResource.FILE_EXTENSION).toString();
	}
	
	/**
	 * Returns a unique collection of DomainBlocks referenced by
	 * the given DomainSpecialization.
	 * 
	 * @param domainSpecialization
	 * @return
	 */
	public static Set<Package> getDomainBlocks(
			org.eclipse.uml2.uml.Class domainSpecialization) {
		
		Set<Package> domainBlocks = new HashSet<Package>();
		
		EList<DirectedRelationship> relationships = domainSpecialization
			.getSourceDirectedRelationships(UMLPackage.Literals.DEPENDENCY);
		for (int i = 0; i < relationships.size(); i++) {
			Dependency d = (Dependency) relationships.get(i);
			if (ZDLUtil.isZDLConcept(d, ZDLNames.DOMAIN_BLOCK_REFERENCE)
				|| ZDLUtil.isZDLConcept(d, ZDLNames.DOMAIN_BLOCK_IMPORT)) {
				Element e = d.getSuppliers().get(0);
				if (!domainBlocks.contains(e) && e instanceof Package) {
					domainBlocks.add((Package) e);
					visit(e, domainBlocks);
				}

			}
		}
		return domainBlocks;
	}

	/**
	 * Visits the specified DomainBlock by recursively visiting all
	 * other DomainBlocks (import or referenced) if not already visited.
	 * 
	 * @param domainBlock the starting DomainBlock
	 * @param visited the {@link Set} of visited DomainBlocks
	 */
	private static void visit(Element domainBlock,
			Set<Package> visited) {
		EList<DirectedRelationship> relationships = domainBlock
			.getSourceDirectedRelationships(UMLPackage.Literals.PACKAGE_IMPORT);
		for (int i = 0; i < relationships.size(); i++) {
			PackageImport pImport = (PackageImport) relationships.get(i);
			if (ZDLUtil.isZDLConcept(pImport, ZDLNames.DOMAIN_BLOCK_REFERENCE)
				|| ZDLUtil.isZDLConcept(pImport, ZDLNames.DOMAIN_BLOCK_IMPORT)) {
				Element e = pImport.getTargets().get(0);
				if (!visited.contains(e) && e instanceof Package) {
					visited.add((Package) e);
					visit(e, visited);
				}
			}
		}
	}

}
