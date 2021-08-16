
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
