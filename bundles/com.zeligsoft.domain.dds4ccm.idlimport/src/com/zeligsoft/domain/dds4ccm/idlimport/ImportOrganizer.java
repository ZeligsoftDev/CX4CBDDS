/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */
package com.zeligsoft.domain.dds4ccm.idlimport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;

//import com.ibm.xtools.uml.type.UMLElementFactory;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * This class contains helper methods to organize IDL into the package structure that will 
 * forward-generate the same hierarchy.
 * 
 * @author Sean McFee
 *
 */
@SuppressWarnings("nls")
public class ImportOrganizer {
	
	private static Map<String, String> fileMap = new HashMap<String, String>();
	
	private static String currentFile;
	
	private static String prefix;
	
	private static org.eclipse.uml2.uml.Package topPackage;
	
	private static String fileSeparator = System.getProperty("file.separator");
		
	/**
	 * Method that creates a map where the key is the name of an IDL file and the
	 * value is the full path on the file system to the same IDL file. Also calculates
	 * the longest common prefix in the import set.
	 * 
	 * @param fileList
	 */
	public static void processFileList(List<String> fileList) {
		for( String fullFileName : fileList ) {
			int idx = fullFileName.lastIndexOf(fileSeparator) + 1;
			String key = fullFileName.substring(idx);
			fileMap.put(key, fullFileName);
		}
		
		String[] strings = (String[])fileList.toArray(new String[fileList.size()]);
		prefix = StringUtils.getCommonPrefix(strings);
		prefix = prefix.substring(0, prefix.lastIndexOf(fileSeparator) + 1);
	}
	
	public static void clearFileList() {
		fileMap = new HashMap<String, String>();
		currentFile = "";
	}
	
	/**
	 * When encountering a #file marker in a preprocessed IDL file, change the value of the
	 * currentFile variable. This fully-pathed value will be used to create packages as necessary.
	 * 
	 * @param file
	 */
	public static void setCurrentFile(File_Marker file) {		
		currentFile = file.getFile()
			.substring(
				file.getFile().indexOf(":") + 1,
				file.getFile().lastIndexOf(":"));
	}
	
	/**
	 * Set the top-level package for the IDL import for future searching.
	 * 
	 * @param importedIdlPackage
	 */
	public static void setImportedIdlPackage(org.eclipse.uml2.uml.Package importedIdlPackage) {
		topPackage = importedIdlPackage;
	}
	
	private static boolean ignoreNextHome = false;
	
	public static void ignoreNextHome()	{
		ignoreNextHome = true;
	}
	
	public static boolean ignoreThisHome() {
		boolean retVal = ignoreNextHome;
		ignoreNextHome = false;
		return retVal;
	}
	
	/**
	 * Create packages below the element's owner (generally a CORBAModule) and itself based
	 * on the file name where the element is imported from.
	 * 
	 * @param elementName
	 */
	public static void addElementToPackage(String elementName) {
		PackageableElement element = findElement(elementName);
	
		String currentFullFile = fileMap.get(currentFile);
		
		//The file is not in the fileMap 
		if (currentFullFile == null && !currentFile.isEmpty())
			currentFullFile = currentFile;
		
		String truncatedFile = currentFullFile.replace(prefix, "");
		String[] packages = truncatedFile.split(StringEscapeUtils.escapeJava(fileSeparator));
		Package currentPackage = (Package)element.getOwner();
		for( int i = 0; i < packages.length - 1; i++ ) {
			String s = packages[i];
			if (currentPackage.getNestedPackage(s) == null) {
				createNestedPackage(currentPackage, s);
			}
			currentPackage = currentPackage.getNestedPackage(s);
		}
		// Contents of a module go into a common package with different naming rules.
		if( ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBACLASSIFIER_CONTAINED)
			&& !ZDLUtil.isZDLConcept(element, DDS4CCMNames.DDSMESSAGE)) {
			
			if( ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBASEQUENCE) &&
				ZDLUtil.isZDLConcept(((Property)((DataType)element).getOwnedMember("members")).getType(), DDS4CCMNames.DDSMESSAGE)) {
				// The sequence for a DDSMessage. Goes into the same package as the DDSMessage by 
				// default, which is the correct behavior, so don't do anything special here.
			} else {	
				String packageName = packages[packages.length - 1].replace(".idl", "");
				Element e = element.getOwner();
				while( e != null) {
					if( ZDLUtil.isZDLConcept(e, CORBADomainNames.CORBAMODULE)) {
						packageName = packageName.replace(ZDLUtil.getValue(e, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME) + "_", "");
					}
					e = e.getOwner();
				}
				if (currentPackage.getNestedPackage(packageName) == null) {
					createNestedPackage(currentPackage, packageName);
				}
				currentPackage = currentPackage.getNestedPackage(packageName);
			}
			
		}
		if( ZDLUtil.isZDLConcept( element, CORBADomainNames.CORBACONSTANTS)) {
			if( currentPackage.getPackagedElement(element.getName()) == null ) {
				EObject constants = ZDLUtil.createZDLConceptIn(currentPackage, CORBADomainNames.CORBACONSTANTS);
				ZDLUtil.setValue(constants, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME, element.getName());
			}
			Class constants = (Class)currentPackage.getPackagedElement(element.getName());
			Property constant = (Property)((Class)element).getOwnedMember(elementName);
			constants.getOwnedAttributes().add(constant);
			if( element.getOwnedElements().size() == 0) {
				
				// ToDo: UMLElementFactory.destroyElement(element, null);
			}
		} else {
			currentPackage.getPackagedElements().add(element);
		}
		if( ZDLUtil.isZDLConcept(element, CCMNames.HOME)) {
			// Co-locate the Home and its Manages relationship.
			EObject manages = ZDLUtil.getEValue(element, CCMNames.HOME, CCMNames.HOME__MANAGES);
			currentPackage.getPackagedElements().add((PackageableElement)manages);			
		}
		if( ZDLUtil.isZDLConcept(element, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
			// Co-locate the Monolithic Implementation and its interface.
			Component ci = (Component) ZDLUtil.getValue(element, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
			PackageableElement currentPackageComponent = currentPackage.getPackagedElement(ci.getName());
			if( currentPackageComponent != null 
					&& ZDLUtil.isZDLConcept(currentPackageComponent, CCMNames.CCMCOMPONENT)
					&& currentPackageComponent != ci ) {
				ZDLUtil.setValue(element, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE, currentPackageComponent);
				
				boolean destroy = false;
				for( Setting s : UML2Util.getInverseReferences(currentPackageComponent)) {
					if( s.getEObject() != null &&
							ZDLUtil.isZDLConcept(s.getEObject(), CCMNames.MANAGES)) {
						destroy = true;
					}
				}
				for( Setting s : UML2Util.getInverseReferences(ci)) {
					if( s.getEObject() != null &&
							ZDLUtil.isZDLConcept(s.getEObject(), CCMNames.MANAGES)) {
						Element home = (Element) ZDLUtil.getValue(s.getEObject(), CCMNames.MANAGES, CCMNames.MANAGES__HOME);
						if( destroy ) {
							// ToDo:UMLElementFactory.destroyElement(home, null);
							// ToDo:UMLElementFactory.destroyElement(s.getEObject(), null);
							break;
						} else {
							ZDLUtil.setValue(s.getEObject(), CCMNames.MANAGES, CCMNames.MANAGES__COMPONENT, currentPackageComponent);
						}
					}
				}
				// ToDo:UMLElementFactory.destroyElement(ci, null);
			} else {
				currentPackage.getPackagedElements().add(ci);
			}
		}
	}
	
	/**
	 * Create a nested package and disable
	 * "generate directory during file generation" option if this is defn
	 * package
	 * 
	 * @param parent package
	 */
	private static Package createNestedPackage(Package parent, String name) {
		Package pkg = parent.createNestedPackage(name);
		if (pkg != null && name.endsWith("defn")) {
			EAnnotation anno = pkg.getEAnnotation("zcx");
			if (anno == null) {
				anno = pkg.createEAnnotation("zcx");
				anno.getDetails().put("generatedir", Boolean.toString(false));
			}
		}
		return pkg;
	}
	
	private static PackageableElement findElement(String elementName) {
		
		for (TreeIterator<?> iter = topPackage.eAllContents(); iter.hasNext();) {

			Object next = iter.next();
			
			if( next instanceof PackageableElement ) {
				PackageableElement elm = (PackageableElement)next;
				if( ZDLUtil.isZDLConcept(elm, IDL3PlusNames.MODULE_INSTANTIATION)
					|| ZDLUtil.isZDLConcept(elm, CCMNames.CCMCOMPONENT)
					|| ZDLUtil.isZDLConcept(elm, CORBADomainNames.CORBAINTERFACE)
					|| ZDLUtil.isZDLConcept(elm, CORBADomainNames.CORBAMODULE_CONTAINED)
					|| ZDLUtil.isZDLConcept(elm, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
					if( elm.getName().equals(elementName)) {
						return elm;
					} else if( ZDLUtil.isZDLConcept(elm, CORBADomainNames.CORBACONSTANTS)) {
						for( Property p : ((Class)elm).getOwnedAttributes()) {
							if( p.getName().equals(elementName)) {
								return elm;
							}
						}
					}
				}
			}
			
			
		}
		
		System.out.println("Could not find element " + elementName);
		return null;
	}
	
	/**
	 * Retrieve the last chunk of the common prefix, which can be used to change the name of
	 * the import package from "IDL_Import_Results" to something more meaningful.
	 * 
	 * @return
	 */
	public static String getTopLevelPackageName() {
		String[] prefixParts = prefix.split(StringEscapeUtils.escapeJava(fileSeparator));
		return prefixParts[prefixParts.length - 1];
	}
}
