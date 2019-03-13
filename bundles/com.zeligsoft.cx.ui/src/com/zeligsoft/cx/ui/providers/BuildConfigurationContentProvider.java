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

package com.zeligsoft.cx.ui.providers;

import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Build configuration content provider
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public class BuildConfigurationContentProvider
		implements IStructuredContentProvider {

	private ResourceSet context;

	private String buildEnvironmentName;

	/**
	 * Constructor
	 * 
	 * @param resourceSet
	 *            Resource set
	 * 
	 * @param buildEnvironmentName
	 *            Build environment class name
	 */
	public BuildConfigurationContentProvider(ResourceSet resourceSet,
			String buildEnvironmentName) {
		super();
		this.context = resourceSet;
		this.buildEnvironmentName = buildEnvironmentName;
	}

	/**
	 * Queries the build configurations
	 * 
	 * @return
	 */
	private Object[] getContents() {

		TreeIterator<Object> itor = EcoreUtil.getAllProperContents(context,
			false);

		ArrayList<Object> list = new ArrayList<Object>();

		for (; itor.hasNext();) {

			Object o = itor.next();

			if (o instanceof Model) {
				if (ZDLUtil.isZDLConcept(((Model) o), ZDLNames.DOMAIN_MODEL)) {
					itor.prune();
				}
			} else if (o instanceof InstanceSpecification) {
				InstanceSpecification is = (InstanceSpecification) o;
				if (is.getClassifier(buildEnvironmentName) != null)
					list.add(o);
			}
		}
		return list.toArray();
	}

	@Override
	public void dispose() {
		// Nothing to do
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing to do

	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		return getContents();
	}

}
