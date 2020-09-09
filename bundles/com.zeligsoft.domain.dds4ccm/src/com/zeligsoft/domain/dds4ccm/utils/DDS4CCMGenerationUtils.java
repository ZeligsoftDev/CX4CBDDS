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
package com.zeligsoft.domain.dds4ccm.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * DDS4CCM generation utility functions
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("nls")
public class DDS4CCMGenerationUtils {

	private static List<DDS4CCMGenerationListener> listeners = new ArrayList<DDS4CCMGenerationUtils.DDS4CCMGenerationListener>();

	public interface DDS4CCMGenerationListener {
		public void fireArtifactGeneratedEvent(ICodeGenEvent event);
		public void fireShowSourceEvent(ICodeGenEvent event);
	}

	public static void addGenerationListener(DDS4CCMGenerationListener listener){
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}
	}
	
	public static void fireArtifactGenerated(ICodeGenEvent event){
		for(DDS4CCMGenerationListener l : listeners){
			l.fireArtifactGeneratedEvent(event);
		}
	}
	
	public static void fireShowSource(ICodeGenEvent event){
		for(DDS4CCMGenerationListener l : listeners){
			l.fireShowSourceEvent(event);
		}
	}
	/**
	 * Calculate the path according to the generate directory option
	 * 
	 * @param el
	 * @return
	 */
	public static String path(org.eclipse.uml2.uml.NamedElement el) {
		String path = "";

		EObject current = el.eContainer();

		while (current != null) {
			if (current instanceof org.eclipse.uml2.uml.Package
					&& current.eContainer() != null
					&& !ZDLUtil.isZDLConcept(current,
							CXDomainNames.CXMODULE)) {
				org.eclipse.uml2.uml.Package pkg = (org.eclipse.uml2.uml.Package) current;
				if ("true".equals(getAnnotationValueForGenerateDir(pkg))) {
					path = pkg.getName() + File.separator + path;
				}
			}

			current = current.eContainer();
		}

		return path;
	}

	/**
	 * Queries the value of zcx generate directory for empty package annotation
	 * 
	 * @param obj
	 * @return
	 */
	public static String getAnnotationValueForGenerateDir(Object obj) {
		if (obj instanceof Package) {

			List<Class> concepts = ZDLUtil.getZDLConcepts((Package) obj);
			if (concepts.isEmpty()
					|| !concepts.get(0).getQualifiedName()
							.equals(ZMLMMNames.NAMED_ELEMENT)) {
				// Ignore stereotyped packages
				return Boolean.toString(false);
			}
			EAnnotation anno = ((Package) obj).getEAnnotation("zcx");
			if (anno == null) {
				return Boolean.toString(true);
			}
			String value = anno.getDetails().get("generatedir");
			if (value == null) {
				return Boolean.toString(true);
			}
			return value;
		}
		return null;
	}

}
