package com.zeligsoft.domain.zml.oaw.importutils;

import java.util.HashMap;
import java.util.UUID;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.WorkerFunctionRepair;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class ZMLImportUtils {

	private static HashMap<String, Object> portTypeMap = new HashMap<String, Object>();
	
	@SuppressWarnings("nls")
	public static void debug(Object o) {
		System.out.println("******* DEBUG *********");
		System.out.println(o.toString());
		System.out.println("***********************");
	}
	
	public static void initializeMaps() {
		portTypeMap.clear();
	}
	
	/**
	 * Generate a UUID.
	 * 
	 * @param o
	 * @return
	 */
	public static String generateUUID(Object o) {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * Xtend has difficulty with enumeration literals, so we have a Java method for the sole purpose of creating them.
	 * @param enumeration
	 * @param label
	 * @param value
	 */
	public static void createLiteralInJava(Enumeration enumeration, String label, String value) {
		EnumerationLiteral literal = enumeration.createOwnedLiteral(label);		
		LiteralString propertyValue = (LiteralString) literal
		.createSpecification(null, null,
			UMLPackage.Literals.LITERAL_STRING);
		propertyValue.setValue(value);		
	}
	
	public static void repairWorkerFunctions(Component component) {
		
		if( ZDLUtil.isZDLConcept(component, ZMLMMNames.STRUCTURAL_REALIZATION) == false) {
			throw new IllegalArgumentException("This method is only to be called with a structural realization."); //$NON-NLS-1$
		}
		
		WorkerFunctionRepair.INSTANCE.repair(component);
	}
	
	/**
	 * Configures a port type created during the import process by creating its inverse port type, and setting 
	 * up the necessary realization/usage relationships.
	 * 
	 * @param portType
	 * @param name
	 * @param conjugation
	 * @param container
	 */
	@SuppressWarnings("nls")
	public static void configurePortType(org.eclipse.uml2.uml.Class portType, String name, String conjugation, org.eclipse.uml2.uml.Package container, Interface contract) {
		
		if( contract == null ) {
			throw new IllegalArgumentException("Cannot find interface for port type " + name);
		}
		if( ZDLUtil.isZDLConcept(portType, ZMLMMNames.PORT_TYPE) == false ) {
			ZDLUtil.addZDLConcept(portType, ZMLMMNames.PORT_TYPE);
		}
		// create interface realization/usage
		String inverseString = name + (conjugation.equals("uses") ? "" : "Inv");
		if( conjugation.equals("provides")) {
			portType.createInterfaceRealization(portType.getName() + "__to__" + contract.getName(), contract);
		} else {
			portType.createUsage(contract);
		}
		portType.setName(name + (conjugation.equals("provides") ? "" : "Inv"));
		registerPortType(portType.getName(), portType);
		if( getPortType(inverseString) == null) {
			org.eclipse.uml2.uml.Class inversePortType = UMLFactory.eINSTANCE.createClass();
			container.getPackagedElements().add(inversePortType);
			inversePortType.setName(name + (conjugation.equals("uses") ? "" : "Inv"));
			ZDLUtil.addZDLConcept(inversePortType, ZMLMMNames.PORT_TYPE);
			registerPortType(inversePortType.getName(), inversePortType);			
			ZDLUtil.setValue(inversePortType, ZMLMMNames.PORT_TYPE, ZMLMMNames.PORT_TYPE__INVERSE, portType);			
			ZDLUtil.setValue(portType, ZMLMMNames.PORT_TYPE, ZMLMMNames.PORT_TYPE__INVERSE, inversePortType);
			if( conjugation.equals("provides")) {
				inversePortType.createUsage(contract);
			} else {
				inversePortType.createInterfaceRealization(inversePortType.getName() + "__to__" + contract.getName(), contract);
			}
		}		
	}
	
	public static Object getPortType(String s) {
		return portTypeMap.get(s);
	}
	
	public static void registerPortType(String s, Object portType) {
		portTypeMap.put(s, portType);
	}
	
	public static NamedElement ZDLFind(String conceptName, String elementName, Element modelElement) {
		
		for (TreeIterator<?> iter = EcoreUtil.getAllContents(modelElement.eResource().getContents()); iter.hasNext();) {

			Object next = iter.next();
			
			if( next instanceof NamedElement ) {
				NamedElement ne = (NamedElement)next;
				if( ZDLUtil.isZDLConcept(ne, conceptName) && ne.getName().equals(elementName)) {
					return ne;
				}
			}
		}
		
		return null;
	}
}
