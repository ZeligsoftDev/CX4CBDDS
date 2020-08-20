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
package com.zeligsoft.ddk.zdlgen2umlprofile.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;

/**
 * A set of utilities that can be used in the ZDLGen2UMLProfile mapping.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public final class ZDLGen2UMLProfileUtil {
	
	private static final String JAVA_IDENTIFIER_NAME_SEPERATOR = "__"; //$NON-NLS-1$
	private static final String JAVA_FILE_EXTENSION = ".java"; //$NON-NLS-1$

	private ZDLGen2UMLProfileUtil() {
		// do nothing because I should never be instantiated
	}
	
	/**
	 * Convert a package name to a valid path segment.
	 * 
	 * @param packageName
	 * 		The package to convert.
	 * @return
	 * 		The package as a string that can be used as a path segment.
	 */
	public static String convertPackageToPath(String packageName) {
		String path;
		
		if(packageName == null) {
			throw new IllegalArgumentException("The package name can not be null"); //$NON-NLS-1$
		}
		
		path = packageName.replace('.', File.separatorChar);
		
		return path;
	}
	
	/**
	 * Given a package name and a class name create a path segment for the 
	 * compilation unit that the class will be stored in.
	 * 
	 * @param packageName
	 * 		String representing the classes package
	 * @param className
	 * 		String representing the class name for a Java class
	 * @return
	 * 		A path segment including the file extension for the Java class
	 */
	public static String javaClassFile(String packageName, String className) {
		StringBuffer result = new StringBuffer();
		result.append(convertPackageToPath(packageName));
		result.append(File.separatorChar);
		result.append(className);
		result.append(JAVA_FILE_EXTENSION);
		
		return result.toString();
	}
	
	/**
	 * Convert a UML qualified name to a valid Java identifier.
	 * 
	 * @param qualifiedName
	 * 		The UML qualified name
	 * @param uppercase
	 * 		Make the resulting identifier all upper case
	 * @return
	 * 		The valid Java identifier
	 */
	public static String umlQualifiedNameToJavaIdentifier(
			final String qualifiedName, final Boolean uppercase){
		String javaIdentifier;
		
		javaIdentifier = qualifiedName.replaceAll(NamedElement.SEPARATOR, 
				JAVA_IDENTIFIER_NAME_SEPERATOR);
		
		javaIdentifier = UML2Util.getValidJavaIdentifier(javaIdentifier);
		
		if(uppercase) {
			javaIdentifier = javaIdentifier.toUpperCase();
		}
		
		return javaIdentifier;
		
	}
	
	/**
	 * Given a root namespace it calculates the qualified name of the element
	 * relative to the root.
	 * 
	 * @param root
	 * 		A root namespace to calculate the relative name
	 * @param element
	 * 		The element we are calculating for
	 * @return
	 * 		The relative qualified name
	 */
	@SuppressWarnings("static-access")
	public static String relativeQualifiedName(final Namespace root,
			final NamedElement element){
		StringBuffer result = new StringBuffer();
		
		if(element == null) {
			throw new 
			IllegalArgumentException("Can not compute the " + //$NON-NLS-1$
					"relative qualified - element is null"); //$NON-NLS-1$
		}
		
		if(UMLUtil.safeEquals(root, element)) {
			throw new 
			IllegalArgumentException("Can not compute the " + //$NON-NLS-1$
					"relative qualified - root == element"); //$NON-NLS-1$
		}
		
		if(! EcoreUtil.isAncestor(root, element)){
			result.append(element.getQualifiedName());
		} else {
			result.append(element.getName());
			for(Namespace ns : element.allNamespaces()){
				if(UMLUtil.safeEquals(root, ns)) {
					break;
				}
				result.insert(0, NamedElement.SEPARATOR);
				result.insert(0, ns.getName());
			}
		}
		
		return result.toString();
	}
	
	/**
	 * Given a model this will calculate the URI's of all the ZDL models
	 * that are referenced in the definition of the model, including the
	 * model itself.
	 * 
	 * @param model
	 * 		A model to calculate the URIs for
	 * @return
	 * 		The URIs as Strings for the metamodel and the metamodels
	 * 		that it references.
	 */
	public static List<String> getMetamodelURIs(final GenModel model) {
		List<String> metamodels = new ArrayList<String>();
		for(GenDomainModel gdm : model.getOwnedModels()) {
			if(gdm.getDomainModel() != null && gdm.getDomainModel().eResource() != null) {
				metamodels.add(gdm.getDomainModel().eResource().getURI().toString());
			}
			
		}
		for(GenDomainModel gdm : model.getReferencedModels()) {
			if(gdm.getDomainModel() != null && gdm.getDomainModel().eResource() != null) {
				metamodels.add(gdm.getDomainModel().eResource().getURI().toString());
			}
		}
			
		return metamodels;
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
	
	public static Object debug(Object obj) {
		System.out.println(obj);
		if(obj instanceof GenDomainAttribute) {
			System.out.println(((GenDomainAttribute) obj).getDomainElement());
		}
		return obj;
	}
	
	public static NamedElement getDomainElement(GenDomainNamedElement gen) {
		return gen.getDomainElement();
	}
}
