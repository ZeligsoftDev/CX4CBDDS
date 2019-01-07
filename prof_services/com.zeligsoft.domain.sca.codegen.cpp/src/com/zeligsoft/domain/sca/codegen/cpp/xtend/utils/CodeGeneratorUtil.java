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

package com.zeligsoft.domain.sca.codegen.cpp.xtend.utils;

import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.cpplanguage.CPPLanguageDomainNames;

public class CodeGeneratorUtil {
	
	private static String NONE = "None";
	
	public static String getParameters(Operation operation){
				
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		
		for(Parameter param : operation.getOwnedParameters()) {
			if(param.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				//do nothing
				continue;
			}
			Type type = param.getType();
			if (type != null){
				sb.append(type.getName());
				if (ZDLUtil.isZDLConcept(param, CPPLanguageDomainNames.CPPPARAMETER)){
					Object object = ZDLUtil.getValue(param, 
							CPPLanguageDomainNames.CPPTYPED_ELEMENT, 
							CPPLanguageDomainNames.CPPTYPED_ELEMENT__INDIRECTION);
					java.util.Collection<EnumerationLiteral> col = (java.util.Collection<EnumerationLiteral>) object;	
					
					for(EnumerationLiteral enumLiteral : col) {
						String name = enumLiteral.getName();  
						if (NONE.equals(name)){
							sb.append("*");
						}
					}						
				}
				sb.append(" ");					
			}
			
			sb.append(param.getName());
			sb.append(", ");
		}
		
		int lastIndex = sb.lastIndexOf(",");
		if (lastIndex != -1){
			sb.deleteCharAt(lastIndex);
		}
		sb.append(")");		
		return sb.toString();
	}
	
	public static String getAttributeType(Property property){
		String typeName = property.getType().getName();
		StringBuilder sb = new StringBuilder();
		sb.append(typeName);
		
		Object object = ZDLUtil.getValue(property, 
				CPPLanguageDomainNames.CPPTYPED_ELEMENT, 
				CPPLanguageDomainNames.CPPTYPED_ELEMENT__INDIRECTION);
		java.util.Collection<EnumerationLiteral> col = (java.util.Collection<EnumerationLiteral>) object;	
		
		for(EnumerationLiteral enumLiteral : col) {
			String name = enumLiteral.getName();  
			if (NONE.equals(name)){
				sb.append("*");
			}
		}				
		return sb.toString();
	}

}
