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

package com.zeligsoft.domain.omg.corba.generation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * CORBA Utility Functions for generation templates.
 */
public class CORBAUtilFuncs {

	public final static String QUALIFIED_CORBA_TYPE__ANY = "CORBA::Any"; 						//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__BOOLEAN = "CORBA::Boolean"; 				//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__CHAR = "CORBA::Char"; 					//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__WCHAR = "CORBA::WChar"; 					//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__DOUBLE = "CORBA::Double"; 				//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__LONG_DOUBLE = "CORBA::LongDouble"; 		//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__FLOAT = "CORBA::Float"; 					//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__SHORT = "CORBA::Short"; 					//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__LONG = "CORBA::Long"; 					//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__LONG_LONG = "CORBA::LongLong"; 			//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__OCTET = "CORBA::Octet"; 					//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__UNSIGNED_LONG = "CORBA::ULong"; 			//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__UNSIGNED_LONG_LONG = "CORBA::ULongLong"; 	//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__UNSIGNED_SHORT = "CORBA::UShort"; 		//$NON-NLS-1$
	public final static String QUALIFIED_CORBA_TYPE__OBJECT_REF = "CORBA::Object"; 			//$NON-NLS-1$
	
	private final static String MULTI_PARAM_TAG = "EXC_ENV_PARAM";	//$NON-NLS-1$
	private final static String SINGLE_PARAM_TAG = "EXC_ENV_SINGLE_PARAM";	//$NON-NLS-1$
	
	private final static String MULTI_ARG_TAG = "EXC_ENV_ARG";	//$NON-NLS-1$
	private final static String SINGLE_ARG_TAG = "EXC_ENV_SINGLE_ARG";	//$NON-NLS-1$
	
	/**
	 * Get the return type of an operation.
	 * 
	 * @param op
	 * @return
	 */
	public static String getReturnTypeForOperation(Operation op)
	{
		String returnType = ""; //$NON-NLS-1$
		
		if( op.getType() != null)
			returnType = getVariableTypeFromCorbaType(op.getType(), "return"); //$NON-NLS-1$
		else
			returnType = "void"; //$NON-NLS-1$
		
		return returnType;		
	}
	
	/**
	 * Returns the C++ variable type of the specified CORBA type.
	 * 
	 * @param corbaType
	 * @param direction
	 * @return
	 */
	private static String getVariableTypeFromCorbaType(Type corbaType, int direction)	
	{
		
		String primitiveType = ""; //$NON-NLS-1$
		
		if (ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBAPRIMITIVE)) 
		{
			
			primitiveType = getTypeOfCorbaPrimitive(corbaType);
			
			if (primitiveType != "")//$NON-NLS-1$
			{
				// I'm a primitive
				return getTypePrefixForPrimitive(primitiveType, direction) 
					+ getPrimitiveBaseType(primitiveType, direction) 
					+ getTypeSuffixForPrimitive(primitiveType, direction);
			}
			else
			{
				return "";//$NON-NLS-1$
			}
		}
		else if( ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBASEQUENCE) 
				|| ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBASTRUCT)
				|| ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBATYPE_DEF)
				|| ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBAENUM)
				|| ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBAARRAY)
				|| ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBAINTERFACE)
				|| ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBAUNION))
		{
			String baseTypeStr = "";//$NON-NLS-1$
			EObject tmpObj = null;
			
			tmpObj = corbaType;
			if (ZDLUtil.isZDLConcept(tmpObj.eContainer(), CORBADomainNames.CORBAINTERFACE))
			{
				baseTypeStr = ((Interface)tmpObj.eContainer()).getName() + "::" + baseTypeStr; //$NON-NLS-1$
				tmpObj = tmpObj.eContainer();				
			}
			
			while (ZDLUtil.isZDLConcept(tmpObj.eContainer(), CORBADomainNames.CORBAMODULE))
			{
				baseTypeStr = ((Package)tmpObj.eContainer()).getName() + "::" + baseTypeStr; //$NON-NLS-1$
				tmpObj = tmpObj.eContainer();
			}
			
			baseTypeStr += corbaType.getName();

	
			if (ZDLUtil.isZDLConcept(corbaType, CORBADomainNames.CORBATYPE_DEF))
			{
				Type absoluteType = getTypeDefType(corbaType);
				
				if (ZDLUtil.isZDLConcept(absoluteType, CORBADomainNames.CORBAPRIMITIVE))
				{
					String absolutePrimitiveType = getTypeOfCorbaPrimitive(absoluteType);
					
					if (absolutePrimitiveType != null)
					{
						
						// bug 14108, char* generated instead of typedef name
						if (absolutePrimitiveType.compareTo(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBASTRING) == 0 
								|| absolutePrimitiveType.compareTo(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAWSTRING) == 0)
						{
							return getTypePrefixForPrimitive(absolutePrimitiveType, direction)
								+ getPrimitiveBaseType(absolutePrimitiveType, direction)  
								+ getTypeSuffixForPrimitive(absolutePrimitiveType, direction);							
						}
						
						// I'm a typedef and I point to primitive
						return getTypePrefixForPrimitive(absolutePrimitiveType, direction) + baseTypeStr 
							+ getTypeSuffixForPrimitive(absolutePrimitiveType, direction);						
					}
					else
					{
						return ""; //$NON-NLS-1$
					}				
					
				}

				// I'm a typedef and I DON'T point to primitive
				return getTypePrefix(absoluteType, direction) + baseTypeStr 
					+ getTypeSuffix(absoluteType, direction);
			}
			
			// I'm not a typedef or a primitive
			return getTypePrefix(corbaType, direction) + baseTypeStr 
				+ getTypeSuffix(corbaType, direction);
	
		}	
		else
		{
			return "";//$NON-NLS-1$
		}
		
	}
	
	/**
	 * Get the prefix of a CORBA type (except CORBA primitives).   For CORBA primitives, use getTypePrefixForPrimitive.
	 * 
	 * @param type
	 * @param direction
	 * @return
	 */
	private static String getTypePrefix(Type type, int direction)
	{
		String prefix = ""; //$NON-NLS-1$
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASEQUENCE))
		{
			if (direction == ParameterDirectionKind.IN)
			{
				prefix = "const "; //$NON-NLS-1$		
			}			
		}
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASTRUCT))
		{
			if (direction == ParameterDirectionKind.IN)
			{
				prefix = "const "; //$NON-NLS-1$
			}			
		}
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAARRAY))
		{
			if (direction == ParameterDirectionKind.IN)
			{
				prefix = "const "; //$NON-NLS-1$
			}
		}
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAUNION))
		{
			if (direction == ParameterDirectionKind.IN)
			{
				prefix = "const "; //$NON-NLS-1$
			}
		}
		
		return prefix;		
	}
	
	/**
	 * Get the suffix for a CORBA type (except CORBA primitives).  For CORBA primitives, use getTypeSuffixForPrimitive.
	 * @param type
	 * @param direction
	 * @return
	 */
	private static String getTypeSuffix(Type type, int direction)
	{
		String suffix = ""; //$NON-NLS-1$
		
		if (direction == ParameterDirectionKind.OUT)
		{
			return "_out"; //$NON-NLS-1$
		}

		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASEQUENCE))
		{
			if (direction == ParameterDirectionKind.RETURN)
				suffix = "*"; //$NON-NLS-1$
			else
				suffix = "&"; //$NON-NLS-1$	
		}
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASTRUCT))
		{
			if (direction == ParameterDirectionKind.RETURN)
			{
				if (isVariableLength(type) == true)
					return "*"; //$NON-NLS-1$
			}
			else
			{
				suffix = "&"; //$NON-NLS-1$
			}
		}
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAENUM))
		{
			if (direction == ParameterDirectionKind.INOUT)
				suffix = "&"; //$NON-NLS-1$			
		}
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAUNION))
		{
			if (direction == ParameterDirectionKind.RETURN)
			{
				if (isVariableLength(type) == true)
					return "*"; //$NON-NLS-1$
			}
			else
			{
				suffix = "&"; //$NON-NLS-1$
			}
		}
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAARRAY))
		{
			if (direction == ParameterDirectionKind.RETURN)
				suffix = "_slice*"; //$NON-NLS-1$
			else
				suffix = ""; //$NON-NLS-1$	
		}
		
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAINTERFACE))
		{
			if (direction == ParameterDirectionKind.INOUT)
				suffix = "_ptr&"; //$NON-NLS-1$
			else
				suffix = "_ptr"; //$NON-NLS-1$
		}
		
		return suffix;
	}
	
	/**
	 * Check if the specified type has a variable length or fixed length.
	 * 
	 * @param type
	 * @return true if the type has a variable length; false if the type is fixed 
	 */
	public static boolean isVariableLength(Type type)
	{
		Type absoluteType = type;
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBATYPE_DEF))
			absoluteType = getTypeDefType(type);
		
		
		if (ZDLUtil.isZDLConcept(absoluteType, CORBADomainNames.CORBAARRAY)) 
		{
			if (absoluteType instanceof DataType)
			{
				DataType dataType = (DataType) absoluteType;
				for (Property att: dataType.getAllAttributes())
				{
					if (att.getName().compareTo("member") == 0 || att.getName().compareTo("members") == 0) //$NON-NLS-1$ //$NON-NLS-2$
					{
						return isVariableLength(att.getType());
					}					
				}				
			}
		}
		else if (ZDLUtil.isZDLConcept(absoluteType, CORBADomainNames.CORBAENUM))
		{
			return false;			
		}
		else if (ZDLUtil.isZDLConcept(absoluteType, CORBADomainNames.CORBAINTERFACE))
		{
			return true;
		}
		else if (ZDLUtil.isZDLConcept(absoluteType, CORBADomainNames.CORBAPRIMITIVE))
		{
			String primitiveType = getTypeOfCorbaPrimitive(absoluteType);
			if (primitiveType.compareTo(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBASTRING) == 0 
					|| primitiveType.compareTo(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAWSTRING) == 0
					|| primitiveType.compareTo(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAANY) == 0 
					|| primitiveType.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAOBJECT_REF) )
			{
				return true;
			}
			return false;
		}		
		else if (ZDLUtil.isZDLConcept(absoluteType, CORBADomainNames.CORBASEQUENCE))
		{
			return true;			
		}
		else if (ZDLUtil.isZDLConcept(absoluteType, CORBADomainNames.CORBASTRUCT))
		{
			
			if (absoluteType instanceof DataType)
			{
				DataType dataType = (DataType) absoluteType;			
			
				for (Property att : dataType.getAllAttributes())
				{
					if (isVariableLength(att.getType()))
						return true;			
				
				}
			}
		}
		
		else if (ZDLUtil.isZDLConcept(absoluteType, CORBADomainNames.CORBAUNION))
		{
			if (absoluteType instanceof DataType)
			{
				DataType dataType = (DataType) absoluteType;			
			
				for (Property att : dataType.getAllAttributes())
				{
					if (ZDLUtil.isZDLConcept(att, CORBADomainNames.CORBACASE) && isVariableLength(att.getType()))
						return true;
				}
			}
		}
		
		return false;
		
	}
	
	/**
	 * @return true if the operation has at least one out or inout parameter
	 */
	public static boolean operationHasOutInOutParameter(Operation op) {
		boolean result = false;
		for (Parameter p : op.getOwnedParameters()) {
			if (p.getDirection() == ParameterDirectionKind.OUT_LITERAL
					|| p.getDirection() == ParameterDirectionKind.INOUT_LITERAL) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Gets a string representing the type of a CORBA primitive.
	 * @param corbaType
	 * @return
	 */
	private static String getTypeOfCorbaPrimitive(Type corbaType)
	{
		String primitiveType = ""; //$NON-NLS-1$
		
		Object result = ZDLUtil.getValue(corbaType, CORBADomainNames.CORBAPRIMITIVE, CORBADomainNames.CORBAPRIMITIVE__TYPE);
		if (result instanceof EnumerationLiteral) 
			primitiveType = ((EnumerationLiteral)result).getName();
		
		return primitiveType;
	}
	
	/**
	 * Returns the basic type defined by a typedef. If the typedef is of another typedef, it makes
	 * a recursive call until it gets a basic type.
	 * 
	 * @param type
	 * @return
	 */
	public static Type getTypeDefType(Type type)
	{
		if (type instanceof DataType)
		{
			Object dataType = ZDLUtil.getValue(type, CORBADomainNames.CORBATYPE_DEF, CORBADomainNames.CORBATYPE_DEF__TYPE);
			if(dataType instanceof EObject) {
				if (ZDLUtil.isZDLConcept((EObject)dataType, CORBADomainNames.CORBATYPE_DEF))
				{
					return getTypeDefType( (Type) dataType);					
				}
				else if(dataType != null)
				{
					return (Type) dataType;					
				}								
			}
			
			// SCXB-2504 - this is needed for backwards compatibility. Typedefs have a type now. However,
			// some of our model libraries (i.e. CF_IDL) still uses Generalizations.
			
			DataType generalizationType = (DataType) type;
			for (Classifier classifier : generalizationType.getGenerals())
			{
				if (ZDLUtil.isZDLConcept(classifier, CORBADomainNames.CORBATYPE_DEF))
				{
					return getTypeDefType(classifier);					
				}
				else if(classifier != null)
				{
					return classifier;					
				}								
			}		
		}
		
		return null;		
	}
	
	/**
	 * Get the prefix of a CORBA primitive.
	 * @param corbaTypeStr
	 * @param direction
	 * @return
	 */
	private static String getTypePrefixForPrimitive(String corbaTypeStr, int direction)
	{
		
		String prefix = ""; //$NON-NLS-1$
		
		// by default, there is no prefix
		// however, here are the exceptions:
		if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBASTRING))
		{
			if (direction == ParameterDirectionKind.IN)
				prefix = "const "; //$NON-NLS-1$
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAWSTRING))
		{
			if (direction == ParameterDirectionKind.IN)
				prefix = "const ";//$NON-NLS-1$
		}
			
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAANY))
		{
			if (direction == ParameterDirectionKind.IN)
				prefix = "const ";//$NON-NLS-1$
		}
		// end of exceptions
		
		return prefix;		
	}
	
	/**
	 * Get the suffix for a CORBA primitive.
	 * @param corbaTypeStr
	 * @param direction
	 * @return
	 */
	private static String getTypeSuffixForPrimitive(String corbaTypeStr, int direction)
	{
		// by default:
		// suffix for INOUT is "&", suffix for OUT is "_out", suffix for IN is nothing
		// here are the exceptions: 
		if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAOBJECT_REF))
		{
			if (direction == ParameterDirectionKind.IN)
				return "_ptr";//$NON-NLS-1$
			else if (direction == ParameterDirectionKind.OUT)
				return "_out";//$NON-NLS-1$
			else if (direction == ParameterDirectionKind.INOUT)
				return "_ptr&";//$NON-NLS-1$
			else // return type
				return "_ptr"; //$NON-NLS-1$
		}
		
		if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAANY))
		{
			if (direction == ParameterDirectionKind.IN)
				return "&";//$NON-NLS-1$
			else if (direction == ParameterDirectionKind.RETURN)
				return "*";//$NON-NLS-1$
		}
		// end of exceptions
		
		if (direction == ParameterDirectionKind.INOUT)
		{
			return "&";//$NON-NLS-1$;
		}
		
		if (direction == ParameterDirectionKind.OUT)
		{
			return "_out";//$NON-NLS-1$;
		}
		
		return "";//$NON-NLS-1$
	}
	
	/**
	 * Get the type of a primitive without the prefix and suffix.
	 * 
	 * @param corbaTypeStr
	 * @param direction
	 * @return
	 */
	private static String getPrimitiveBaseType(String corbaTypeStr, int direction)
	{
		String type = "";//$NON-NLS-1$
		if (corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAWCHAR))
		{
			type = QUALIFIED_CORBA_TYPE__WCHAR;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAVOID))
		{
			if (direction == ParameterDirectionKind.RETURN)
				type = "void"; //$NON-NLS-1$
			else
				type = "#error Invalid direction for void type";//$NON-NLS-1$
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAUNSIGNED_SHORT))
		{
			type = QUALIFIED_CORBA_TYPE__UNSIGNED_SHORT;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAUNSIGNED_LONG_LONG))
		{
			type = QUALIFIED_CORBA_TYPE__UNSIGNED_LONG_LONG;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAUNSIGNED_LONG))
		{
			type = QUALIFIED_CORBA_TYPE__UNSIGNED_LONG;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBASHORT))
		{
			type = QUALIFIED_CORBA_TYPE__SHORT;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAOCTET))			
		{
			type = QUALIFIED_CORBA_TYPE__OCTET;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAOBJECT_REF))
		{
			type = QUALIFIED_CORBA_TYPE__OBJECT_REF;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBALONG_LONG))
		{
			type = QUALIFIED_CORBA_TYPE__LONG_LONG;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBALONG_DOUBLE))
		{
			type = QUALIFIED_CORBA_TYPE__LONG_DOUBLE;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBALONG))
		{
			type = QUALIFIED_CORBA_TYPE__LONG;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAFLOAT))
		{
			type = QUALIFIED_CORBA_TYPE__FLOAT;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBADOUBLE))
		{
			type = QUALIFIED_CORBA_TYPE__DOUBLE;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBACHAR))
		{
			type = QUALIFIED_CORBA_TYPE__CHAR;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBABOOLEAN))
		{
			type = QUALIFIED_CORBA_TYPE__BOOLEAN;
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBASTRING))
		{
			if (direction == ParameterDirectionKind.OUT)
				type = "CORBA::String";//$NON-NLS-1$
			else
				type = "char*";//$NON-NLS-1$
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAWSTRING))
		{	if (direction == ParameterDirectionKind.OUT)
				type = "CORBA::String";//$NON-NLS-1$
			else
				type = "char*";//$NON-NLS-1$
		}
		else if(corbaTypeStr.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAANY))
		{
			type = QUALIFIED_CORBA_TYPE__ANY;
		}
		else
		{
			type ="#error Unknown type" + corbaTypeStr;//$NON-NLS-1$
		}
		
		return type;
	}
	
	/**
	 * Returns the C++ variable type of the specified CORBA type.
	 * 
	 * @param corbaType
	 * @param direction
	 * @return
	 */
	public static String getVariableTypeFromCorbaType(Type corbaType, String direction)
	{
		int dir;
		
		if (direction.compareTo("in") == 0) //$NON-NLS-1$
			dir = ParameterDirectionKind.IN;
		else if ( direction.compareTo("out") == 0)//$NON-NLS-1$
			dir = ParameterDirectionKind.OUT;
		else if ( direction.compareTo("inout") == 0)//$NON-NLS-1$
			dir = ParameterDirectionKind.INOUT;
		else  // direction = "return"
			dir = ParameterDirectionKind.RETURN;
		
		return getVariableTypeFromCorbaType(corbaType, dir);		
	}
	
	/**
	 * Returns the name of the interface separated with underscores.
	 * 
	 * @param inter
	 * @return
	 */
	public static String getFullInterfaceName(Interface inter)
	{
		return getInterfaceName(inter, "_"); //$NON-NLS-1$		
	}
	
	/**
	 *Returns the qualified name of an operation separated with semi-colons.
	 * @param op
	 * @return
	 */
	public static String getQualifiedOperationName(Operation op)
	{
		return getInterfaceName(op.getInterface(), "::") + "::" + op.getName(); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * Returns the qualified name of an interface separated with semi-colons.
	 * 
	 * @param inter
	 * @return
	 */
	public static String getQualifiedInterfaceName(Interface inter)
	{
		return getInterfaceName(inter, "::"); //$NON-NLS-1$		
	}
	
	private static String getInterfaceName(Interface inter, String separator)
	{
		EObject tmpObj = inter;
		String interName = ""; //$NON-NLS-1$
		
		if (ZDLUtil.isZDLConcept(tmpObj, CORBADomainNames.CORBAINTERFACE))
		{		
			while (ZDLUtil.isZDLConcept(tmpObj.eContainer(), CORBADomainNames.CORBAMODULE))
			{
				interName = ((Package)tmpObj.eContainer()).getName() + separator + interName;
				tmpObj = tmpObj.eContainer();
			}
		
			interName += inter.getName();			
		}
		return interName;
	}	
	
	/**
	 * @param element
	 * @return the qualified name of an interface separated with semi-colons.
	 */
	public static String getCorbaQualifiedName(EObject element) {
		String name = ""; //$NON-NLS-1$

		if (element != null && element instanceof NamedElement) {
			name = ((NamedElement) element).getName();
			Element owner = ((Element) element).getOwner();

			while (owner != null && owner instanceof NamedElement
					&& !ZDLUtil.isZDLConcept(owner, CORBADomainNames.IDLFILE)) {
				name = ((NamedElement) owner).getName() + "::" + name; //$NON-NLS-1$
				owner = owner.getOwner();
			}
		}
		return name;
	}

	
	/**
	 * Get the arguments for a signature.
	 * 
	 * @param op
	 * @param startWithComma
	 * @return
	 */	
	public static String getArgumentsForOperation(Operation op, String startWithComma)
	{
		if (startWithComma.toLowerCase().compareTo("true") == 0) //$NON-NLS-1$
			return getArgumentsForOperation(op, true);
		
		return getArgumentsForOperation(op, false);		
	}		
	
	/**
	 * Get the arguments for a signature.  This function is called by getArgumentsForOperation(Operation op, String startWithComma).
	 * 
	 * @param op
	 * @param startWithComma
	 * @return
	 */	
	private static String getArgumentsForOperation(Operation op, boolean startWithComma)
	{
		StringBuilder sb = new StringBuilder();
		
		boolean parameterGenerated = startWithComma;
		for( Parameter p : op.getOwnedParameters()) {
			if( p.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
				if( isCorbaType(p.getType())) {
					if( parameterGenerated) {
						sb.append(", "); //$NON-NLS-1$
					}
					sb.append(getVariableTypeFromCorbaParameter(p));
					sb.append(" "); //$NON-NLS-1$
					sb.append(p.getName());
					parameterGenerated = true;
				}
			}
		}
		
		return sb.toString();	
	}
	
	/**
	 * Check to see if the type is a CORBA type.
	 * @param type
	 * @return true if CORBA type
	 */
	public static boolean isCorbaType(Type type)
	{
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASTRUCT) || ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAPRIMITIVE)
				|| ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASEQUENCE) || ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAARRAY)
				|| ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBATYPE_DEF) || ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAENUM)
				|| ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAUNION) || ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAINTERFACE))
		{
			return true;			
		}		
		
		return false;
	}
	
	/**
	 * Returns the C++ variable type of the specified parameter. 
	 * 
	 * @param corbaParameter
	 * @return
	 */
	public static String getVariableTypeFromCorbaParameter(Parameter corbaParameter)
	{
		return getVariableTypeFromCorbaType(corbaParameter.getType(), corbaParameter.getDirection().getValue());
	}
	
	/**
	 * Return the appropriate Exception Environment Parameter
	 * 
	 * @param type
	 * @return SCX_EXC_ENV_PARAM - if operations has arguments
	 *         SCX_EXC_ENV_SINGLE_PARAM - if no arguments
	 */
	public static String getExceptionEnvParam( Operation op ) {
		if (op.getOwnedParameters().isEmpty())
			return SINGLE_PARAM_TAG;
		return MULTI_PARAM_TAG;
		
	}
	
	/**
	 * Get the name of a worker function based on the attribute/operation and the source.  This cannot be called to
	 * get the name of a dispatcher function.
	 * 
	 * @param element, an attribute or an operation
	 * @param source, where the attribute/operation comes from, either a port or a supported interface
	 * @return
	 */
	public static String getWorkerFunctionName(NamedElement element, NamedElement source)
	{
		String functionName = ""; //$NON-NLS-1$
		if (source instanceof Port)
			functionName = source.getName();
		else if (source instanceof Interface)
			functionName = "_"+getFullInterfaceName((Interface)source); //$NON-NLS-1$
		
		functionName += "_" + element.getName(); //$NON-NLS-1$
		
		return functionName.replaceAll("/", "_"); //$NON-NLS-1$ //$NON-NLS-2$ 
	}
	
	/**
	 * Get the parameters for a function call.
	 * 
	 * @param op
	 * @param startWithComma
	 * @return
	 */	
	@Deprecated
	public static String getParametersForOperation(Operation op, String startWithComma)
	{
		if (startWithComma.toLowerCase().compareTo("true") == 0) //$NON-NLS-1$
			return getParametersForOperation(op, true);
		
		return getParametersForOperation(op, false);		
	}
	
	/**
	 * Get the parameters for a function call.
	 * 
	 * @param op
	 * @param startWithComma
	 * @return
	 */	
	public static String getParametersForOperation(Operation op, Boolean startWithComma)
	{
		StringBuilder sb = new StringBuilder();
		
		boolean parameterGenerated = startWithComma;
		for( Parameter p : op.getOwnedParameters()) {
			if( p.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
				if( isCorbaType(p.getType())) {
					if( parameterGenerated) {
						sb.append(", "); //$NON-NLS-1$
					}
					sb.append(p.getName());
					parameterGenerated = true;
				}
			}
		}
		
		return sb.toString();	
	}
	
	/**
	 * Generates the signature for a CORBAOperation on a worker element (e.g. SCA Component).
	 *  
	 * @param op
	 * @param source, where the operation comes from, either a port or a supported interface
	 * @param workerElement
	 * @return
	 */
	public static String getSignatureForCorbaOperation(Operation op, NamedElement source, NamedElement workerElement) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getReturnTypeForOperation(op));
		sb.append(" "); //$NON-NLS-1$

		sb.append(workerElement.getName());
		sb.append("Worker::"); //$NON-NLS-1$		
		sb.append(getWorkerFunctionName(op, source));
		sb.append("( ");//$NON-NLS-1$
		
		String args = getArgumentsForOperation(op, false);
		if ( args.trim().length() > 0 ) {
			sb.append(args);
		    sb.append( MULTI_ARG_TAG + " )"); //$NON-NLS-1$
		} else {
			sb.append( SINGLE_ARG_TAG + " )");	//$NON-NLS-1$
		}
		
		return sb.toString();
	}
	
	/**
	 * Get the name of the operation as seen on the component itself in the GUI.
	 * 
	 * @param operation
	 * @param source, where the operation comes from, either a port or a supported interface
	 * @return
	 */
	public static String getOperationName(Operation op, NamedElement source)
	{
		String functionName = ""; //$NON-NLS-1$
		if (source instanceof Port)
			functionName = source.getName() + "_" + op.getName(); //$NON-NLS-1$
		else if (source instanceof Interface)
			functionName = op.getName();
		
		return functionName;
	}
	
	/**
	 * If the type is a typedef, this will get the type of the typedef.  Else it returns the
	 * type.
	 * 
	 * @param type
	 * @return
	 */
	public static Type getAbsoluteType(Type type)
	{
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBATYPE_DEF))
		{
			return CORBAUtilFuncs.getTypeDefType(type);			
		}
		
		return type;	
	}
}
