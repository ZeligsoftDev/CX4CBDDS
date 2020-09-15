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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;

/**
 * CORBA migration util
 * 
 * @author ysroh
 * 
 */
public class CORBAMigrationUtil {

	public static int migrateReturnParameter(Model model) {

		List<Parameter> elementsToMigrate = new ArrayList<Parameter>();
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, CXDomainNames.CXOPERATION)) {
				Parameter param = ((Operation)next).getReturnResult();
				if(param != null) {
					elementsToMigrate.add(param);
				}
				itor.prune();
			} 
			if (!(next instanceof Package) && !ZDLUtil.isZDLConcept(next, CXDomainNames.CXINTERFACE)) {
				itor.prune();
			}
		}
		for (Parameter next : elementsToMigrate) {
			if (!ZDLUtil.isZDLConcept(next, CXDomainNames.CXPARAMETER)) {
				ZDLUtil.addZDLConcept(next, CXDomainNames.CXPARAMETER);
			}
		}

		return elementsToMigrate.size();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int migrateArrayBound(Model model) {

		List<EObject> elementsToMigrate = new ArrayList<EObject>();
		Map<String, EObject> constantMap = new HashMap<String, EObject>();
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, CXDomainNames.CXARRAY)
					|| ZDLUtil.isZDLConcept(next, CXDomainNames.CXFIELD)) {
				elementsToMigrate.add(next);
			} else if (ZDLUtil.isZDLConcept(next,
					CXDomainNames.CXCONSTANT)) {
				String constantQName = ((NamedElement) next).getQualifiedName();
				constantMap
						.put(constantQName.replace(
								EMFCoreUtil.getName(next.eContainer()) + "::", UML2Util.EMPTY_STRING), //$NON-NLS-1$
						next);
			}
			if (!(next instanceof Package)
					&& !ZDLUtil.isZDLConcept(next,
							CXDomainNames.CXCONSTANTS)
					&& !ZDLUtil
							.isZDLConcept(next, CXDomainNames.CXSTRUCT)
					&& !ZDLUtil.isZDLConcept(next,
							CXDomainNames.CXEXCEPTION) 
					&& !ZDLUtil.isZDLConcept(next,
						CXDomainNames.CXMODULE) 
					&& !ZDLUtil.isZDLConcept(next,
							CXDomainNames.CXINTERFACE)) {
				itor.prune();
			}
		}
		for (EObject next : elementsToMigrate) {
			String value;
			List list;
			if (ZDLUtil.isZDLConcept(next, CXDomainNames.CXARRAY)) {
				value = (String) ZDLUtil.getValue(next,
						CXDomainNames.CXARRAY,
						CXDomainNames.CXARRAY__INDEX);
				list = (List) ZDLUtil.getValue(next,
						CXDomainNames.CXARRAY,
						CXDomainNames.CXARRAY__BOUNDS);
			} else {
				value = (String) ZDLUtil.getValue(next,
						CXDomainNames.CXFIELD,
						CXDomainNames.CXFIELD__BOUND);
				list = (List) ZDLUtil.getValue(next,
						CXDomainNames.CXFIELD,
						CXDomainNames.CXFIELD__BOUNDS);
			}
			if (UML2Util.isEmpty(value)) {
				continue;
			}
			value = value.replaceAll(" ", ""); //$NON-NLS-1$ //$NON-NLS-2$
			String[] bounds = value.split(","); //$NON-NLS-1$

			for (String bound : bounds) {
				if (UML2Util.isEmpty(bound)) {
					continue;
				}

				String qName = bound;
				if (!qName.contains("::")) { //$NON-NLS-1$
					qName = EMFCoreUtil.getQualifiedName(
							getContainingPackage(next), false) + "::" //$NON-NLS-1$
							+ qName;
				}
				EObject newBound = ZDLUtil.createZDLConcept(next,
						CXDomainNames.CXBOUND);
				if (constantMap.containsKey(qName)) {
					ZDLUtil.setValue(newBound, CXDomainNames.CXBOUND,
							CXDomainNames.CXBOUND__CONSTANT,
							constantMap.get(qName));
				} else {
					ZDLUtil.setValue(newBound, CXDomainNames.CXBOUND,
							CXDomainNames.CXBOUND__VALUE, bound);
				}
				list.add(newBound);
			}
			if (ZDLUtil.isZDLConcept(next, CXDomainNames.CXARRAY)) {
				ZDLUtil.setValue(next, CXDomainNames.CXARRAY,
						CXDomainNames.CXARRAY__INDEX, null);
			} else {
				ZDLUtil.setValue(next, CXDomainNames.CXFIELD,
						CXDomainNames.CXFIELD__BOUND, null);
			}
		}

		return elementsToMigrate.size();
	}

	/**
	 * Helper function to get the nearest parent package
	 * 
	 * @param element
	 * @return
	 */
	private static Package getContainingPackage(EObject element) {
		if (element instanceof Package) {
			return (Package) element;
		}
		if (element.eContainer() != null) {
			return getContainingPackage(element.eContainer());
		}
		return null;
	}

	public static int migrateTypedefType(Model model) {

		List<EObject> elementsToMigrate = new ArrayList<EObject>();
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, CXDomainNames.CXTYPE_DEF)) {
				elementsToMigrate.add(next);
			}
			if (!(next instanceof Package)
					&& !ZDLUtil.isZDLConcept(next,
						CXDomainNames.CXMODULE) 
					&& !ZDLUtil.isZDLConcept(next,
							CXDomainNames.CXINTERFACE)) {
				itor.prune();
			}
		}
		for (EObject next : elementsToMigrate) {
			
			Type type = getTypeDefType((Type) next);
			
			ZDLUtil.setValue(next, CXDomainNames.CXTYPE_DEF,
					CXDomainNames.CXTYPE_DEF__TYPE, type);
			
			DataType d = (DataType) next;
			if(d.getGeneralizations() != null && d.getGeneralizations().size() > 0) {
				d.getGeneralizations().get(0).destroy();
			}

		}

		return elementsToMigrate.size();
	}

	private static Type getTypeDefType(Type type)
	{
		if (type instanceof DataType)
		{
			DataType dataType = (DataType) type;
			for (Classifier classifier : dataType.getGenerals())
			{			
					return classifier;												
			}		
		}
		
		return null;		
	}

	/**
	 * Migrate sequence and string bound to new bound
	 * 
	 * @param model
	 * @return
	 */
	public static int migrateBounds(Model model) {
		List<EObject> elementsToMigrate = new ArrayList<EObject>();
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, CXDomainNames.CXSEQUENCE)
					|| ZDLUtil.isZDLConcept(next, CXDomainNames.CXSTRING)
					|| ZDLUtil
							.isZDLConcept(next, CXDomainNames.CXWSTRING)) {
				elementsToMigrate.add(next);
			}
			if (!(next instanceof Package) || next instanceof PackageImport) {
				itor.prune();
			}
		}
		for (EObject next : elementsToMigrate) {
			String value = null;
			if (ZDLUtil.isZDLConcept(next, CXDomainNames.CXSEQUENCE)) {
				value = (String) ZDLUtil.getValue(next,
						CXDomainNames.CXSEQUENCE,
						CXDomainNames.CXSEQUENCE__BOUND);
			} else {
				value = (String) ZDLUtil.getValue(next,
						CXDomainNames.CXBOUNDED,
						CXDomainNames.CXBOUNDED__BOUND);
			}
			if (UML2Util.isEmpty(value)) {
				continue;
			}

			EObject newBound = ZDLUtil.createZDLConcept(next,
					CXDomainNames.CXBOUND);
			ZDLUtil.setValue(newBound, CXDomainNames.CXBOUND,
					CXDomainNames.CXBOUND__VALUE, value);
			if (ZDLUtil.isZDLConcept(next, CXDomainNames.CXSEQUENCE)) {
				ZDLUtil.setValue(next, CXDomainNames.CXSEQUENCE,
						CXDomainNames.CXSEQUENCE__BOUNDS, newBound);
			} else {
				ZDLUtil.setValue(next, CXDomainNames.CXBOUNDED,
						CXDomainNames.CXBOUNDED__BOUNDS, newBound);
			}
		}

		return elementsToMigrate.size();
	}
}
