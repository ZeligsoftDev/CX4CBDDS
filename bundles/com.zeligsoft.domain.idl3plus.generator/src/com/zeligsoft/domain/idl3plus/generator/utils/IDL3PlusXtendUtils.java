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
package com.zeligsoft.domain.idl3plus.generator.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.connectorregistry.ConnectorRegistry;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class IDL3PlusXtendUtils {
	private IDL3PlusXtendUtils() {
		// nothing to do since I am a singleton with no state
	}

	public static List<EAnnotation> getEAnnotations(com.zeligsoft.domain.omg.corba.dsl.idl.Specification spec) {
		return spec.getEAnnotations();
	}

	public static List<EAnnotation> getEAnnotations(com.zeligsoft.domain.omg.corba.dsl.idl.StructType struct) {
		return struct.getEAnnotations();
	}

	public static List<EAnnotation> getEAnnotations(com.zeligsoft.domain.omg.corba.dsl.idl.Member member ) {
		return member.getEAnnotations();
	}

	public static List<org.eclipse.uml2.uml.Class> getComponentsHomes(Component comp) {
		List<org.eclipse.uml2.uml.Class> homes = new ArrayList<org.eclipse.uml2.uml.Class>();
		
		EList<Relationship> dependencies = comp.getRelationships(UMLPackage.Literals.DEPENDENCY);
		for( Relationship rel : dependencies) {
	    	if( ZDLUtil.isZDLConcept(rel, CCMNames.MANAGES)) {
	    		// get the home 
	    		EList<NamedElement> clients = ((Dependency) rel).getClients();
	    		if( !clients.isEmpty()) {
	    			homes.add( (org.eclipse.uml2.uml.Class) clients.get(0));
	    		}
	    	}
		}
		return homes;
	}

	public static String getTypeParameterName(ClassifierTemplateParameter param){
		return ((NamedElement)param.getParameteredElement()).getName();
	}

	public static List<Dependency> getPortTypeProvides(org.eclipse.uml2.uml.Class port){
		List<Dependency> ports = new ArrayList<Dependency>();
		EList<Dependency> dependencies = port.getClientDependencies();
		for(Dependency dep : dependencies){
			if (dep instanceof org.eclipse.uml2.uml.InterfaceRealization){
				ports.add(dep);
			}
				
		}
		return ports;
	}

	public static List<Dependency> getPortTypeUses(org.eclipse.uml2.uml.Class port){
		List<Dependency> ports = new ArrayList<Dependency>();
		EList<Dependency> dependencies = port.getClientDependencies();
		for(Dependency dep : dependencies){
			if (dep instanceof org.eclipse.uml2.uml.Usage){
				ports.add(dep);
			}
				
		}
		return ports;
	}

	/**
	 * Converts a qualified name as modeled in CX to an IDL scoped name that would be accurate in the repository.
	 * This is done by skipping the package and IDLFile parts of the qualified name.
	 * 
	 * @param qualifiedName
	 * @return
	 */
	@SuppressWarnings("nls")
	public static String scopedNameFromNamedElementForIDL3(NamedElement element) {
	
		String retVal = "";
		NamedElement iterator = element;
	
		while( iterator != null )
		{
			if( ZDLUtil.isZDLConcept(iterator, CORBADomainNames.IDLFILE) ||
					(!ZDLUtil.isZDLConcept(iterator, CORBADomainNames.CORBANAMED_ELEMENT) &&
					!(ZDLUtil.isZDLConcept(iterator, CCMNames.INTERFACE_PORT)) &&
					!(ZDLUtil.isZDLConcept(iterator, CCMNames.EVENT_PORT)) &&
					(!ZDLUtil.isZDLConcept(iterator, ZMLMMNames.TYPE))))
			{
				if (iterator instanceof org.eclipse.uml2.uml.Package)
				{
					iterator = (NamedElement)iterator.getOwner();
				}
				else
				{
					break;
				}
				
			}
			else
			{
				if( retVal != "")
				{
					retVal = "::" + retVal;
				}
				retVal = iterator.getName() + retVal;
				
				if (iterator.getOwner() instanceof NamedElement)
				{
					iterator = (NamedElement)iterator.getOwner();
				}
				else
				{
					return retVal;
				}
				
			}
			
		}
		
		return retVal;
	}

	@SuppressWarnings("unchecked")
	public static boolean isContainedInModuleInstParam(NamedElement corbaSequence){
		DataType sequence = (DataType)corbaSequence;
		Property p = sequence.getOwnedAttributes().get(0);
		Package pkg = (Package)corbaSequence.getModel();
		List<Element> instantiations = IDL3PlusUtil.getConceptElements(pkg, IDL3PlusNames.MODULE_INSTANTIATION);
		for( Element instantiation : instantiations ) 
		{
			EObject moduleBinding = 
				(EObject)ZDLUtil.getValue(
						instantiation, 
						IDL3PlusNames.MODULE_INSTANTIATION, 
						IDL3PlusNames.MODULE_INSTANTIATION__MODULE_BINDING);
			for( Element parameterBinding : (List<Element>)ZDLUtil.getValue(moduleBinding, IDL3PlusNames.MODULE_BINDING, IDL3PlusNames.MODULE_BINDING__PARAMETER_BINDING))
			{
				if( ZDLUtil.getValue(parameterBinding, IDL3PlusNames.PARAMETER_BINDING, IDL3PlusNames.PARAMETER_BINDING__TYPE) == p.getType()) 
				{
					return true;
				}
			}
		}
		return false;
		
	}

	/**
	 * Return the list of included file names to be generated for a CORBA element.
	 * 
	 * @param corbaElementName
	 * @return A list of file names to include.
	 */
	public static List<String> getIncludeFileName(String corbaElementName) {
		ConnectorRegistry.ConnectorConfiguration config = ConnectorRegistry.getInstance().getConfiguration(corbaElementName);
		
		if( config == null ) {
			return new ArrayList<String>();
		}
		
		return config.getIncludeFileNames();
	}
}
