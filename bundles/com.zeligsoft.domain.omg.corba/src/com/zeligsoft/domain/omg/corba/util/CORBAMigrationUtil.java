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
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * CORBA migration util
 * 
 * @author ysroh
 * 
 */
public class CORBAMigrationUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int migrateArrayBound(Model model) {

		List<EObject> elementsToMigrate = new ArrayList<EObject>();
		Map<String, EObject> constantMap = new HashMap<String, EObject>();
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if (ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBAARRAY)
					|| ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBAFIELD)) {
				elementsToMigrate.add(next);
			} else if (ZDLUtil.isZDLConcept(next,
					CORBADomainNames.CORBACONSTANT)) {
				String constantQName = ((NamedElement) next).getQualifiedName();
				constantMap
						.put(constantQName.replace(
								EMFCoreUtil.getName(next.eContainer()) + "::", UML2Util.EMPTY_STRING), //$NON-NLS-1$
						next);
			}
			if (!(next instanceof Package)
					&& !ZDLUtil.isZDLConcept(next,
							CORBADomainNames.CORBACONSTANTS)
					&& !ZDLUtil
							.isZDLConcept(next, CORBADomainNames.CORBASTRUCT)
					&& !ZDLUtil.isZDLConcept(next,
							CORBADomainNames.CORBAEXCEPTION) 
					&& !ZDLUtil.isZDLConcept(next,
						CORBADomainNames.CORBAMODULE) 
					&& !ZDLUtil.isZDLConcept(next,
							CORBADomainNames.CORBAINTERFACE)) {
				itor.prune();
			}
		}
		for (EObject next : elementsToMigrate) {
			String value;
			List list;
			if (ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBAARRAY)) {
				value = (String) ZDLUtil.getValue(next,
						CORBADomainNames.CORBAARRAY,
						CORBADomainNames.CORBAARRAY__INDEX);
				list = (List) ZDLUtil.getValue(next,
						CORBADomainNames.CORBAARRAY,
						CORBADomainNames.CORBAARRAY__BOUNDS);
			} else {
				value = (String) ZDLUtil.getValue(next,
						CORBADomainNames.CORBAFIELD,
						CORBADomainNames.CORBAFIELD__BOUND);
				list = (List) ZDLUtil.getValue(next,
						CORBADomainNames.CORBAFIELD,
						CORBADomainNames.CORBAFIELD__BOUNDS);
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
						CORBADomainNames.CORBABOUND);
				if (constantMap.containsKey(qName)) {
					ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
							CORBADomainNames.CORBABOUND__CONSTANT,
							constantMap.get(qName));
				} else {
					ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
							CORBADomainNames.CORBABOUND__VALUE, bound);
				}
				list.add(newBound);
			}
			if (ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBAARRAY)) {
				ZDLUtil.setValue(next, CORBADomainNames.CORBAARRAY,
						CORBADomainNames.CORBAARRAY__INDEX, null);
			} else {
				ZDLUtil.setValue(next, CORBADomainNames.CORBAFIELD,
						CORBADomainNames.CORBAFIELD__BOUND, null);
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
			if (ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBATYPE_DEF)) {
				elementsToMigrate.add(next);
			}
			if (!(next instanceof Package)
					&& !ZDLUtil.isZDLConcept(next,
						CORBADomainNames.CORBAMODULE) 
					&& !ZDLUtil.isZDLConcept(next,
							CORBADomainNames.CORBAINTERFACE)) {
				itor.prune();
			}
		}
		for (EObject next : elementsToMigrate) {
			
			Type type = getTypeDefType((Type) next);
			
			ZDLUtil.setValue(next, CORBADomainNames.CORBATYPE_DEF,
					CORBADomainNames.CORBATYPE_DEF__TYPE, type);
			
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
			if (ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBASEQUENCE)
					|| ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBASTRING)
					|| ZDLUtil
							.isZDLConcept(next, CORBADomainNames.CORBAWSTRING)) {
				elementsToMigrate.add(next);
			}
			if (!(next instanceof Package) || next instanceof PackageImport) {
				itor.prune();
			}
		}
		for (EObject next : elementsToMigrate) {
			String value = null;
			if (ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBASEQUENCE)) {
				value = (String) ZDLUtil.getValue(next,
						CORBADomainNames.CORBASEQUENCE,
						CORBADomainNames.CORBASEQUENCE__BOUND);
			} else {
				value = (String) ZDLUtil.getValue(next,
						CORBADomainNames.CORBABOUNDED,
						CORBADomainNames.CORBABOUNDED__BOUND);
			}
			if (UML2Util.isEmpty(value)) {
				continue;
			}

			EObject newBound = ZDLUtil.createZDLConcept(next,
					CORBADomainNames.CORBABOUND);
			ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
					CORBADomainNames.CORBABOUND__VALUE, value);
			if (ZDLUtil.isZDLConcept(next, CORBADomainNames.CORBASEQUENCE)) {
				ZDLUtil.setValue(next, CORBADomainNames.CORBASEQUENCE,
						CORBADomainNames.CORBASEQUENCE__BOUNDS, newBound);
			} else {
				ZDLUtil.setValue(next, CORBADomainNames.CORBABOUNDED,
						CORBADomainNames.CORBABOUNDED__BOUNDS, newBound);
			}
		}

		return elementsToMigrate.size();
	}
}
