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
package com.zeligsoft.domain.omg.corba.util;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.generation.CORBAUtilFuncs;

/**
 * A set of utilities for working in the CORBA domain.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class CORBAUtil {
	protected CORBAUtil() {
		// can not create me
	}
	
	public static org.eclipse.uml2.uml.NamedElement Container_lookupName(org.eclipse.uml2.uml.Namespace container, String name){
		org.eclipse.uml2.uml.NamedElement result = null;
		
		result = container.getMember(name);
		
		return result;
	}
	
	/**
	 * Method to determine whether a given CORBA Interface supports an interface as specified
	 * by the passed qualified name. 
	 * 
	 * @param intf
	 * @param intfToSupportQName
	 * @return
	 */
	public static boolean CORBAInterfaceSupportsInterface(Interface intf, String intfToSupportQName ) {

		if( !ZDLUtil.isZDLConcept(intf, "CORBADomain::IDL::CORBAInterface")) { //$NON-NLS-1$
			throw new IllegalArgumentException("This method should only be called on a CORBAInterface."); //$NON-NLS-1$
		}
		
		if( intf.getQualifiedName().equals(intfToSupportQName) ) {
			return true;
		}
		for( Generalization g : intf.getGeneralizations()) {
			if( CORBAInterfaceSupportsInterface((Interface)g.getGeneral(), intfToSupportQName)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Method to determine whether a given CORBA Interface supports an interface. Verifies the interfaces
	 * qualified name ends with the string passed in.
	 * 
	 * @param intf
	 * @param intfToSupportName
	 * @return
	 */
	public static boolean CORBAInterfaceEndsWithSupportsInterface(Interface intf, String intfToSupportName ) {

		if( !ZDLUtil.isZDLConcept(intf, "CORBADomain::IDL::CORBAInterface")) { //$NON-NLS-1$
			throw new IllegalArgumentException("This method should only be called on a CORBAInterface."); //$NON-NLS-1$
		}
		
		if( intf.getQualifiedName().endsWith(intfToSupportName) ) {
			return true;
		}
		for( Generalization g : intf.getGeneralizations()) {
			if( CORBAInterfaceEndsWithSupportsInterface((Interface)g.getGeneral(), intfToSupportName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to determine whether a given CORBA Interface supports an interface
	 * as specified by the passed qualified name and the interface's qualified name.
	 * 
	 * @param intf
	 * @param intfToSupportQName
	 * @return
	 */
	public static boolean CORBAInterfaceIsQualifiedInterface(Interface intf, String intfToSupportQName ) {

			if (intf != null) {
				if (!ZDLUtil.isZDLConcept(intf, "CORBADomain::IDL::CORBAInterface")) { //$NON-NLS-1$
					throw new IllegalArgumentException(
							"This method should only be called on a CORBAInterface."); //$NON-NLS-1$
				}                 
				if (CORBAUtilFuncs.getQualifiedInterfaceName(intf).equals(intfToSupportQName)) {
					return true;
				}
				for (Generalization g : intf.getGeneralizations()) {
					if (CORBAInterfaceIsQualifiedInterface(
							(Interface) g.getGeneral(), intfToSupportQName)) {
						return true;
					}
				}
			}
		return false;
	}
	
	/**
	 * 
	 * 
	 * @param intf
	 * @return
	 */
	@SuppressWarnings("nls") // IDL constants do not need to be localized.
	public static String getRepositoryId( NamedElement intf ) {
		
		if( ZDLUtil.isZDLConcept(intf, CORBADomainNames.CORBANAMED_ELEMENT) == false ) {
			throw new IllegalArgumentException("Method is only to be called on a CORBA Domain element.");
		}
		
		String repositoryId = "";
		NamedElement namedElement = intf;

		while( namedElement != null ) {
			if( ZDLUtil.isZDLConcept(namedElement, CORBADomainNames.CORBANAMED_ELEMENT) ) {
				if( ZDLUtil.isZDLConcept(namedElement, CORBADomainNames.CORBACONSTANTS) == false ) {
					// A CORBANamedElement adds to the repository ID.
					if( repositoryId.matches("") == false) {
						repositoryId = "/" + repositoryId;
					}
					repositoryId = namedElement.getName() + repositoryId;
				}
				namedElement = (NamedElement)namedElement.getOwner();	
			} else if( ZDLUtil.isZDLConcept(namedElement, CORBADomainNames.IDLFILE) ) {
				// An IDLFile is the top of the stack, but may have a prefix to prepend.
				Object prefix = ZDLUtil.getValue(namedElement, CORBADomainNames.IDLFILE, CORBADomainNames.IDLFILE__PREFIX);
				if( prefix != null && !prefix.toString().isEmpty()) {
					repositoryId = prefix.toString().replaceAll("\"", "") + "/" + repositoryId;
				}
				namedElement = null;
			} else if( namedElement instanceof org.eclipse.uml2.uml.Package ) {
				// A UML package should be skipped since its container could still be a CORBA Element.
				namedElement = (NamedElement)namedElement.getOwner();
			} else {
				// Any other object means we are done calculating the repository ID.
				namedElement = null;
			}
		}
		
		repositoryId = "IDL:" + repositoryId + ":" + getCORBAVersion();
		return repositoryId;
	}
	
	/**
	 * Retrieve the CORBA Version from the preferences.
	 * 
	 * @return
	 */
	private static String getCORBAVersion() {
		IPreferencesService service = Platform.getPreferencesService();
		String identifier = service.getString(
				"com.zeligsoft.domain.sca.ui", "version_identifier", "1.0", null);//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		//FIXME use proper preference lookup once bug 14933 is fixed.
		return identifier;
	}
	
	/**
	 * Queries the CORBA primitive types from the imported package
	 * 
	 * @param context
	 * @param string
	 * @return
	 */
	public static EObject getCORBAPrimitiveType(EObject context, String string) {
		EObject root = EcoreUtil.getRootContainer(context);
		for (PackageImport pi : ((Package) root).getPackageImports()) {
			if ("IDLPrimitives".equals(pi.getImportedPackage().getName())) { //$NON-NLS-1$
				return pi.getImportedPackage().getOwnedMember(string); 
			}
		}
		return null;
	}
	
	/**
	 * Queries the type of the CORBATypeDef element
	 * 
	 * @param typedef
	 * @return
	 */
	public static EObject getTypeDefType(EObject typedef) {
		EObject val = ZDLUtil.getEValue(typedef,
				CORBADomainNames.CORBATYPE_DEF,
				CORBADomainNames.CORBATYPE_DEF__TYPE);
		if (val == null && !((DataType) typedef).getGeneralizations().isEmpty()) {
			Generalization g = ((DataType) typedef).getGeneralizations().get(0);
			val = g.getGeneral();
		}
		return val;
	}
	
	/**
	 * Queries the array bound
	 * @param boundedElement
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static int getBound(EObject boundedElement) {
		List bounds = (List) ZDLUtil.getValue(boundedElement,
				CORBADomainNames.CORBAARRAY,
				CORBADomainNames.CORBAARRAY__BOUNDS);
		if (!bounds.isEmpty()) {
			EObject bound = (EObject) bounds.get(0);
			Object value = ZDLUtil.getValue(bound, CORBADomainNames.CORBABOUND,
					CORBADomainNames.CORBABOUND__VALUE);
			if (value == null || UML2Util.isEmpty(value.toString())) {
				EObject constant = ZDLUtil.getEValue(bound,
						CORBADomainNames.CORBABOUND,
						CORBADomainNames.CORBABOUND__CONSTANT);
				if (constant != null) {
					value = ZDLUtil.getValue(constant,
							CORBADomainNames.CORBACONSTANT,
							CORBADomainNames.CORBACONSTANT__DEFAULT);
				}
			}
			if (value != null) {
				return Integer.parseInt(value.toString());
			}
		}
		return -1;
	}
	
	/**
	 * Find member attribute from DataType
	 * 
	 * @param type
	 * @return property named members
	 */
	public static Property getMembersAttribute(DataType type) {
		Property member = type.getOwnedAttribute(
				CORBADomainNames.CORBASTRUCT__MEMBERS, null);
		if (member == null) {
			member = type.getOwnedAttribute("member", null); //$NON-NLS-1$
		}
		return member;
	}
}
