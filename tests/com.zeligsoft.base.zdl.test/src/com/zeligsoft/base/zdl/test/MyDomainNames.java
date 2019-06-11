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

package com.zeligsoft.base.zdl.test;

/**
 * Constants for the ZDL model MyDomain
 * @generated
 *
 */
public class MyDomainNames {

	private MyDomainNames() {
		super();
	}

	/**
	 * Fully qualified name for the ZDL DomainConcept: Application. 
	 * @generated
	 */
	public static String APPLICATION = "MyDomain::MyBlock::Application";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: Application::id. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String APPLICATION__ID = "id";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: Application::name. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static String APPLICATION__NAME = "name";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: Application::port. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String APPLICATION__PORT = "port";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: MyPort. 
	 * @generated
	 */
	public static String MY_PORT = "MyDomain::MyBlock::MyPort";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: MyPort::kind. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static String MY_PORT__KIND = "kind";//$NON-NLS-1$  

	/**
	 * ZDL DomainEnum: PortKind. 
	 * @generated
	 */
	public static String PORT_KIND = "MyDomain::MyBlock::PortKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: PortKind::control. 
	 * @generated
	 */
	public static String PORT_KIND__CONTROL = "control";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: PortKind::data. 
	 * @generated
	 */
	public static String PORT_KIND__DATA = "data";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: PortKind::responses. 
	 * @generated
	 */
	public static String PORT_KIND__RESPONSES = "responses";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: PortKind::text. 
	 * @generated
	 */
	public static String PORT_KIND__TEXT = "text";//$NON-NLS-1$

}
