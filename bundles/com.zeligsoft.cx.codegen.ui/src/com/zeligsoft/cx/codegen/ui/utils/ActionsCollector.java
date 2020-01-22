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
package com.zeligsoft.cx.codegen.ui.utils;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.codegen.ui.actions.AbstractTransformAction;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;
import com.zeligsoft.cx.codegen.ui.transformregistry.TransformRegistry;
import com.zeligsoft.cx.codegen.ui.transformregistry.WorkflowEntry;

public class ActionsCollector {
	public static <T extends AbstractTransformAction> void populateActionsFromElement(EObject eObj, List<T> actionCache, Class<T> aClass) throws IllegalAccessException, InstantiationException{
		String concept = getZDLConcept(eObj);

		if( concept != null )
		{
			List<WorkflowEntry> workflowEntries = TransformRegistry.INSTANCE
					.getTransformationWorkflows(concept, eObj);
			if(workflowEntries == null) {
				return;
			}
			List<URL> paths = new ArrayList<URL>();
			for (WorkflowEntry entry : workflowEntries) {
				paths.add(entry.getWorkflowURL());
			}
			// Get entries registered against element type id.
			IElementType type = ElementTypeRegistry.getInstance()
					.getElementType(eObj);
			for (WorkflowEntry entry : TransformRegistry.INSTANCE
					.getTransformationWorkflows(concept, eObj)) {
				if (!paths.contains(entry.getWorkflowURL())) {
					// do not add if entry exists with same URL
					workflowEntries.add(entry);
				}
			}
			
			int workflowEntriesSize = updateEnabledWorkflowEntries(workflowEntries, eObj);
			
			if( workflowEntriesSize == 1 ){
				initializeActionCache(actionCache, workflowEntriesSize, aClass);
				WorkflowEntry entry = workflowEntries.get( 0 );
				//If there is no visibility				
				T txAction = actionCache.get( 0 );
				txAction.setWorkflow( entry );
				txAction.setEObject( eObj );
				if (!entry
						.getDisplayLabel()
						.startsWith(
								Messages.GenerateActionProvider_CodeGenMenuManagerTitle)) {
					txAction.setText(Messages.GenerateActionProvider_CodeGenMenuManagerTitle
							+ " " + entry.getDisplayLabel()); //$NON-NLS-1$
				} else {
					txAction.setText(entry.getDisplayLabel());
				}
			}else if( workflowEntriesSize >= 2 ){	
				//add the generate all action
				workflowEntriesSize++;

				initializeActionCache(actionCache, workflowEntriesSize, aClass);				
				for( int i = 0; i < workflowEntriesSize; ++i ){				
					if(i == 0){
						T txAction = actionCache.get( 0 );
						txAction.setEObject( eObj );
						txAction.setWorkflow(workflowEntries);
						txAction.setText(NLS.bind(
								Messages.GenerateContributionItemProvider_All, null));
					}else{
						WorkflowEntry entry = workflowEntries.get( i-1 );
						T txAction = actionCache.get( i );
						
						txAction.setWorkflow( entry );
						txAction.setEObject( eObj );
						String actionLabel = entry.getDisplayLabel();
						if (actionLabel
								.startsWith(Messages.GenerateActionProvider_CodeGenMenuManagerTitle
										+ " ")) { //$NON-NLS-1$
							actionLabel = actionLabel
									.replaceFirst(
											Messages.GenerateActionProvider_CodeGenMenuManagerTitle
													+ " ", UML2Util.EMPTY_STRING); //$NON-NLS-1$
						}
						txAction.setText( actionLabel );
					}
				}
			}
		}
	}
	
	private static String getZDLConcept(EObject eObject) {
		org.eclipse.uml2.uml.Class eClass = ZDLUtil.getZDLConcept(eObject);
		return eClass == null
			? null
			: eClass.getQualifiedName();
	}
	
	private static <T extends AbstractTransformAction> void initializeActionCache(List<T> actionCache, int newSize, Class<T> clazz) throws IllegalAccessException, InstantiationException {

		if (actionCache == null && newSize >= 1) {
			actionCache = new ArrayList<T>(newSize);

			// initialize cache with actions
			for (int i = 0; i < newSize; i++) {
				actionCache.add(clazz.newInstance());
			}
		}

		// clients have asked for more actions
		if (actionCache.size() < newSize) {
			// grow the cache
			((ArrayList<T>) actionCache).ensureCapacity(newSize);
			for (int i = actionCache.size(); i < newSize; i++) {
				actionCache.add(clazz.newInstance());
			}
		}
	}
	
	/**
	 * Traverse all {@link WorkflowEntry} entries and check if a visibility test
	 * is available. If the visibility test fails for the provided eObj, the
	 * entry is removed from the list.
	 * 
	 * @param workflowEntries
	 *            {@link WorkflowEntry} entries available for the selected eObj
	 * @param eObj
	 *            Object selection to test using {@link IFilter} visibility
	 *            tests from each {@link WorkflowEntry} in the list
	 * @return The size of the updated workflowEntries list
	 */
	private static int updateEnabledWorkflowEntries(List<WorkflowEntry> workflowEntries, EObject eObj){
		int workflowEntriesSize = 0;
		Iterator<WorkflowEntry> it = workflowEntries.iterator();
		while(it.hasNext()){
			WorkflowEntry we = it.next();
			if(isActionDisabled(we, eObj))
				workflowEntriesSize++;
			else
				it.remove();
		}
		return workflowEntriesSize;
	}
	
	/**
	 * Check if a specific {@link WorkflowEntry} has a visibility test and if it
	 * does then test the provided eObj.
	 * 
	 * @param entry
	 *            {@link WorkflowEntry} to available for the eObj for which to
	 *            perform a visibility test
	 * @param eObj
	 *            Object selection to test using {@link IFilter} visibility test
	 *            from the specified entry
	 * @return <b>true</b> if no {@link IFilter} visibility test is present in
	 *         the entry or if one is available and the test passes for the
	 *         provided eObj. Returns <b>false</b> if the eObj does not pass the
	 *         entry's visibility test.
	 */
	private static boolean isActionDisabled(WorkflowEntry entry, EObject eObj) {
		if (entry.getVisibilityTest() == null
				|| (entry.getVisibilityTest() != null && entry
						.getVisibilityTest().select(eObj)))
			return true;
		return false;
	}
}
