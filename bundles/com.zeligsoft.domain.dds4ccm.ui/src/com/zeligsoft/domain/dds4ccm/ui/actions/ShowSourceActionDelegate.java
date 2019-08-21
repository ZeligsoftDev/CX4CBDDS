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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.domain.dds4ccm.codegen.utils.CodeGenUtil;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMCodeGenEvent;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMGenerationUtils;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Show Source action delegate
 * 
 * @author ysroh
 * 
 */
public class ShowSourceActionDelegate implements IObjectActionDelegate {

	protected ISelection selection;

	protected EObject context;

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing
	}

	public void run(IAction action) {

		if (context == null || !ZDLUtil.isZDLConcept(context, CCMNames.CCMPART)) {
			return;
		}
		Component comp = (Component) ZDLUtil.getEValue(context,
				CCMNames.CCMPART, ZMLMMNames.PART__DEFINITION);
		if (comp == null) {
			return;
		}
		String projectName = ProjectFactory.getSrcProjectName(comp);
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);

		Set<String> pathnames = new HashSet<String>();
		if (project.exists()) {
			List<Component> impls = getMonolithicImplementations(comp);
			if (impls.isEmpty()) {
				pathnames.add(getPathname(project, comp));
			} else {
				for (Component c : impls) {
					pathnames.add(getPathname(project, c));
				}
			}
		}
		DDS4CCMCodeGenEvent event = new DDS4CCMCodeGenEvent(comp, pathnames);
		CodeGenUtil.INSTANCE.fireShowSourceEvent(event);

	}

	public static List<Component> getMonolithicImplementations(Component comp) {
		List<Component> retVal = new ArrayList<Component>();

		for (Setting s : UML2Util.getInverseReferences(comp)) {
			if (s.getEObject() instanceof Generalization) {
				Generalization g = (Generalization) s.getEObject();
				if (ZDLUtil.isZDLConcept(g.getOwner(),
						CCMNames.MONOLITHIC_IMPLEMENTATION)) {
					retVal.add((Component) g.getOwner());
				}
			}
		}

		return retVal;
	}

	private String getPathname(IProject project, Component comp) {
		String path = DDS4CCMGenerationUtils.path((NamedElement) comp)
				+ createFilename((NamedElement) comp);
		return project.getLocation().append(path)
				.addFileExtension("idl").toString(); //$NON-NLS-1$
	}

	private String createFilename(NamedElement context) {
		String result = context.getName();
		EObject parent = context.eContainer();
		while (parent != null) {
			if (ZDLUtil.isZDLConcept(parent, CORBADomainNames.CORBAMODULE)) {
				result = ((NamedElement) parent).getName() + "_" + result; //$NON-NLS-1$
			}
			parent = parent.eContainer();
		}

		return result;
	}

	@Override
	public void selectionChanged(IAction action, final ISelection selection) {

		this.selection = selection;

		if (selection == null || action == null) {
			action.setEnabled(false);
			return;
		}

		context = BaseUIUtil.getEObjectFromSelection(selection);
	}

}
