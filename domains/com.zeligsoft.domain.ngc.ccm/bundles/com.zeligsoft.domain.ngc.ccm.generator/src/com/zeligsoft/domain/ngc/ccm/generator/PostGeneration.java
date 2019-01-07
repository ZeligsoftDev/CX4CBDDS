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
package com.zeligsoft.domain.ngc.ccm.generator;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMCodeGenEvent;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMGenerationUtils;

public class PostGeneration extends AbstractWorkflowComponent {

	private String pathnameSlot;

	/**
	 * Pathnames of generated files will be written into.
	 * 
	 * @param value
	 */
	public void setPathnameSlot(String value) {
		this.pathnameSlot = value;
	}

	/**
	 * @return Pathnames of generated files will be written into.
	 */
	public String getPathnameSlot() {
		return pathnameSlot;
	}

	/*
	 * (non-Javadoc)
	 */
	@SuppressWarnings("unchecked")
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		Object result = ctx.get(getPathnameSlot());
		if (result instanceof Map) {
			// Map of pathnames are passed
			Map<String, Set<String>> pathnames = (Map<String, Set<String>>) result;
			Object isShowSource = ctx.get("ShowSourceAction");
			if (isShowSource != null && (Boolean) isShowSource == true) {
				if (!pathnames.get("all").isEmpty()) {
					DDS4CCMCodeGenEvent event = new DDS4CCMCodeGenEvent(
							(EObject) ctx.get("element"), pathnames.get("all"));
					DDS4CCMGenerationUtils.fireShowSource(event);
				}
				return;
			}
			if (!pathnames.get("modified").isEmpty()) {
				DDS4CCMCodeGenEvent event = new DDS4CCMCodeGenEvent(
						(EObject) ctx.get("element"), pathnames.get("modified"));
				DDS4CCMGenerationUtils.fireArtifactGenerated(event);
			}
		} else {
			// Only set of modified pathnames were passed
			Set<String> pathnames = (Set<String>) result;
			DDS4CCMCodeGenEvent event = new DDS4CCMCodeGenEvent(
					(EObject) ctx.get("element"), pathnames);
			DDS4CCMGenerationUtils.fireArtifactGenerated(event);
		}
	}

	@Override
	public void checkConfiguration(Issues issues) {
		// TODO Auto-generated method stub
	}

}
