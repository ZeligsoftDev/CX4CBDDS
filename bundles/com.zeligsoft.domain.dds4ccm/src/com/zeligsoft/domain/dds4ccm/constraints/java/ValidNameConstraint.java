/**
 * Copyright 2023 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.constraints.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.zeligsoft.base.zdl.Activator;
import com.zeligsoft.base.zdl.staticapi.util.AbstractBaseZDLFactory;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Class;

/**
 * Validates whether an entity name is valid, i.e. that it doesn't contain illegal characters.
 * 
 * @author Ernesto Posse
 */
public class ValidNameConstraint extends AbstractModelConstraint {
	
	private static final String VALID_NAME_REGEX = "[a-zA-Z_]\\w*";
	private static final Pattern VALID_NAME_PATTERN = Pattern.compile(VALID_NAME_REGEX);
	private static final Predicate<String> VALID_NAME_PREDICATE = VALID_NAME_PATTERN.asMatchPredicate();
	
	/* CHECKABLE_NAMED_ELEMENTS is a set containing the names of all concepts and only 
	 * the concepts of elements that are to be checked by validation. This list should 
	 * match the names of all elements that result in IDL identifiers.
	 * See https://github.com/ZeligsoftDev/CX4CBDDS/issues/477 */
	private static final Set<String> CHECKABLE_NAMED_ELEMENT_CONCEPTS = new HashSet<String>(Arrays.asList(
			CCMNames.CCMCOMPONENT,
			CCMNames.CCMMODEL,
			CCMNames.EVENT,
			CCMNames.EVENT_PORT,
			CCMNames.INTERFACE_PORT,
			DDS4CCMNames.DDS4_CCMMODEL,
			DDS4CCMNames.DDSMESSAGE,
			DDS4CCMNames.MESSAGE_FIELD,
			IDL3PlusNames.CONNECTOR_DEF,
			IDL3PlusNames.EXTENDED_PORT_TYPE,
//			IDL3PlusNames.MODULE_BINDING,
			IDL3PlusNames.MODULE_INSTANTIATION,
//			IDL3PlusNames.PARAMETER_BINDING,
			IDL3PlusNames.TEMPLATE_MODULE,
			IDL3PlusNames.TYPED_CONNECTOR,
			CXDomainNames.CXATTRIBUTE,
			CXDomainNames.CXARRAY,
			CXDomainNames.CXBOUND,
			CXDomainNames.CXCASE,
			CXDomainNames.CXCASE__LABEL,
			CXDomainNames.CXCLASSIFIER,
			CXDomainNames.CXCONSTANT,
			CXDomainNames.CXENUM,
			CXDomainNames.CXEXCEPTION,
			CXDomainNames.CXFIELD,
			CXDomainNames.CXINTERFACE,
			CXDomainNames.CXMODULE,
			CXDomainNames.CXOPERATION,
			CXDomainNames.CXPARAMETER,
			CXDomainNames.CXPRIMITIVE,
			CXDomainNames.CXSEQUENCE,
			CXDomainNames.CXSTRING,
			CXDomainNames.CXSTRUCT,
			CXDomainNames.CXTYPE_DEF,
			CXDomainNames.CXUNION,
			CXDomainNames.CXUNION_FIELD,
			CXDomainNames.CXWSTRING,
			CXDomainNames.NATIVE
	));

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();
		
		if (isCheckableElement(objToVerify)) {
			Object nameObj = ZDLUtil.getValue(objToVerify, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME);
			if (nameObj instanceof String) {
				String name = (String)nameObj;
				if (VALID_NAME_PREDICATE.test(name)) {
					return ctx.createSuccessStatus();
				}
			}
			String invalidName = nameObj != null ? nameObj.toString() : "<null>";
			return ctx.createFailureStatus(invalidName);
		}

		return null;
	}
	
	private boolean isCheckableElement(EObject obj) {
		if (!ZDLUtil.isZDLConcept(obj, ZMLMMNames.NAMED_ELEMENT))
			return false;
		List<Class> concepts = ZDLUtil.getZDLConcepts(obj);
//		Set<Class> allConcepts = ZDLUtil.getAllZDLConcepts(objToVerify);
		if (concepts == null)
			return false;
		for (Class umlClass: concepts) {
			String qualifiedName = umlClass.getQualifiedName();
			if (CHECKABLE_NAMED_ELEMENT_CONCEPTS.contains(qualifiedName))
				return true;
		}
		return false;
	}
}
