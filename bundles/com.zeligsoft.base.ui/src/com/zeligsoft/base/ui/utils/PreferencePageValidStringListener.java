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
package com.zeligsoft.base.ui.utils;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;

import com.zeligsoft.base.ui.l10n.Messages;

/**
 * Valid string listener for preference page
 * 
 * @author jcorchis
 * 
 */
public class PreferencePageValidStringListener implements
		org.eclipse.swt.widgets.Listener {

	private PreferencePage page;

	private Text text;

	/**
	 * 
	 * @param page
	 * @param text
	 * @param label
	 */
	public PreferencePageValidStringListener(PreferencePage page, Text text) {
		this.page = page;
		this.text = text;
	}

	@Override
	public void handleEvent(Event e) {
		if (text.getText().matches(".*[^A-Z,a-z,0-9,\\-,_].*")) { //$NON-NLS-1$
			page.setValid(false);
			page.setErrorMessage(NLS.bind(
					Messages.PreferencePageValidStringListener_InvalidStringError, text
							.getText()));
		} else {
			page.setValid(true);
			page.setErrorMessage(null);
		}
	}
}