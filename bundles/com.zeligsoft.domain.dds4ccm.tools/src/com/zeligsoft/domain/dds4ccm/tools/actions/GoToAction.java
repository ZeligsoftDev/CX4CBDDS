/**
 * Copyright 2021 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;


public class GoToAction extends BaseSelectionListenerAction {

	private EObject target;

	public GoToAction(EObject target) {
		super(Messages.GoToAction_ActionTitle);
		this.target = target;
	}

	@Override
	public void run() {
		BaseUIUtil.revealTarget(target);
	}
}
