/**
 * Copyright 2021 Zeligsoft.
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

package com.zeligsoft.cx.codegen.ui.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.osgi.util.NLS;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.filecollector.FileCollector.GeneratedFile;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;
import com.zeligsoft.cx.codegen.ui.preferences.CXCodegenUIPreferencesConstants;

/**
 * A class to collect and report transformation workflow results to the console.
 * 
 * @apiNote Marking model elements as updated should be implemented in a separate class
 * implementing the {@link WorkflowResultReporter} interface.
 * 
 * @author Ernesto Posse
 */
class WorkflowResultConsoleReporter implements WorkflowResultReporter {
	
	private List<WorkflowResult> results = new ArrayList<>();
	
	private static final IEclipsePreferences WORKSPACE_PREFERENCES = InstanceScope.INSTANCE
			.getNode(CodeGenUIPlugin.PLUGIN_ID);


	public WorkflowResultConsoleReporter() {
	}

	@Override
	public void addResult(WorkflowResult result) {
		results.add(result);
	}
	
	@Override
	public void reset() {
		results = new ArrayList<>();
	}
	
	/**
	 * Produces a report of files added, changed, removed, unchanged, before and after, in 
	 * accordance with the workspace preferences for all results.
	 */
	@Override
	public void reportAll() {
		for (WorkflowResult result : results) {
			report(result);
		}
	}
	/**
	 * Produces a report of files added, changed, removed, unchanged, before and after, in 
	 * accordance with the workspace preferences for a specific result.
	 */
	@Override
	public void report(WorkflowResult result) {
		StringBuffer buffer = new StringBuffer();
		writeResultHeaderToConsole(buffer, result);
		writeResultFileUpdatesToConsole(buffer, result);
		BaseUIUtil.writeToConsole(buffer.toString());
	}

	private void writeResultHeaderToConsole(StringBuffer buffer, WorkflowResult result) {
		buffer.append(NLS.bind(Messages.WorkflowResult_Name, result.getEntry().getDisplayLabel()));
		buffer.append(System.lineSeparator());
		buffer.append(NLS.bind(Messages.WorkflowResult_ModelURI, result.getElement().eResource().getURI().toString()));
		buffer.append(System.lineSeparator());
		buffer.append(System.lineSeparator());
		if (result.getStatus().isOK()) {
			buffer.append(Messages.WorkflowResult_Success);
		} else {
			buffer.append(Messages.WorkflowResult_Failure);
		}
		buffer.append(System.lineSeparator());
	}

	private void writeResultFileUpdatesToConsole(StringBuffer buffer, WorkflowResult result) {
		if (WORKSPACE_PREFERENCES.getBoolean(CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_ADDED,
				CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_ADDED_DEFAULT)) {
			writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesAddedTitleMessage, result.getEntry().getDisplayLabel(), result.getProject().getName()),
					result.getFileCollection().getFilesAdded());
		}
		if (WORKSPACE_PREFERENCES.getBoolean(CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_CHANGED,
				CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_CHANGED_DEFAULT)) {
			writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesChangedTitleMessage, result.getEntry().getDisplayLabel(), result.getProject().getName()),
					result.getFileCollection().getFilesChanged());
		}
		if (WORKSPACE_PREFERENCES.getBoolean(CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_REMOVED,
				CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_REMOVED_DEFAULT)) {
			writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesRemovedTitleMessage, result.getEntry().getDisplayLabel(), result.getProject().getName()),
					result.getFileCollection().getFilesRemoved());
		}
		if (WORKSPACE_PREFERENCES.getBoolean(CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_UNCHANGED,
				CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_UNCHANGED_DEFAULT)) {
			writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesUnchangedTitleMessage, result.getEntry().getDisplayLabel(), result.getProject().getName()),
					result.getFileCollection().getFilesUnchanged());
		}
		if (WORKSPACE_PREFERENCES.getBoolean(CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_BEFORE,
				CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_BEFORE_DEFAULT)) {
			writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesBeforeTitleMessage, result.getEntry().getDisplayLabel(), result.getProject().getName()),
					result.getFileCollection().getFilesBefore());
		}
		if (WORKSPACE_PREFERENCES.getBoolean(CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_AFTER,
				CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_AFTER_DEFAULT)) {
			writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesAfterTitleMessage, result.getEntry().getDisplayLabel(), result.getProject().getName()),
					result.getFileCollection().getFilesAfter());
		}
	}

	private void writeFileList(StringBuffer buffer, String title, Set<GeneratedFile> files) {
		buffer.append(title);
		buffer.append(System.lineSeparator());
		for (GeneratedFile file : files) {
			buffer.append(file.getFullPath().toOSString());
			buffer.append(System.lineSeparator());
		}
		buffer.append(System.lineSeparator());
	}

}