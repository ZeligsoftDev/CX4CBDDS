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

package com.prismtech.domain.sca.ppls.vpm.ui.licensing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.services.IDisposable;

import com.prismtech.domain.sca.ppls.vpm.presentation.VpmEditorPlugin.Implementation;

/**
 * @author mciobanu
 */
public class LicensedUIProvider extends AbstractSourceProvider implements IDisposable {

	public final static String RIGHTS_VARIABLE = "licensedPLM"; //$NON-NLS-1$
	private final static String[] PROVIDED_SOURCE_NAMES = new String[] { RIGHTS_VARIABLE };

	private final static Map<String, List<String>> stateMap = new HashMap<String, List<String>>();

	public LicensedUIProvider() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Map<String, List<String>> getCurrentState() {
		// returns the list of rights as a list of strings.
		stateMap.put(RIGHTS_VARIABLE, Implementation.getUserRights());
		return stateMap;
	}

	@Override
	public String[] getProvidedSourceNames() {
		 return PROVIDED_SOURCE_NAMES;
	}

	/*
	 * This triggers an update of the rights variable state, and will update
	 * also all listeners to the evaluation service. So that every menu point,
	 * which is also expression controlled, gets updated too.
	 */
	public void updateRights() {
		fireSourceChanged(0, getCurrentState());
	}
}
