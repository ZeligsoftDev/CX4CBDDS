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
package com.zeligsoft.cx.ui.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * Property section that controls neighbour section contents
 * 
 * @author ysroh
 * 
 */
public class CXPropertyTabControllerSection extends AbstractCXPropertySection {

	private void disableAllToolbar(Composite composite) {
		for (Control c : composite.getChildren()) {
			if (c instanceof Composite) {
				if (c instanceof ToolBar) {
					for (ToolItem item : ((ToolBar) c).getItems()) {
						if (item.getToolTipText() != null
								&& (item.getToolTipText().startsWith("Insert") || item //$NON-NLS-1$
										.getToolTipText().startsWith("Delete"))) { //$NON-NLS-1$
							c.setEnabled(false);
						}
					}
				} else {
					disableAllToolbar((Composite) c);
				}
			}
		}
	}

	private void disableCreateElementMenuFromTable(Composite composite) {
		for (final Control c : composite.getChildren()) {
			if (c instanceof Composite) {
				if (c instanceof Table) {
					if (((Table) c).getMenu() != null
							&& ((Table) c).getMenu().getItemCount() != 0) {
						// Disable first two pop up menu items. First one is
						// insert new
						// element menu
						final List<MenuItem> menusToDisable = new ArrayList<MenuItem>();
						for (MenuItem item : ((Table) c).getMenu().getItems()) {
							if (item.getText().contains("Insert") || item.getText().contains("Delete")) { //$NON-NLS-1$ //$NON-NLS-2$
								menusToDisable.add(item);
							}
						}
						if (((Table) c).getMenu().getListeners(SWT.Show).length == 0) {
							// make sure we don't add listener twice
							((Table) c).getMenu().addMenuListener(new MenuListener() {

								@Override
								public void menuHidden(MenuEvent e) {
									// do nothing
								}

								@Override
								public void menuShown(MenuEvent e) {
									for (MenuItem item : menusToDisable) {
										item.setEnabled(false);
									}
								}
							});
						}
					}
				} else {
					disableCreateElementMenuFromTable((Composite) c);
				}
			}
		}
	}

	private void disableButtonWithText(Composite composite, String text) {
		for (Control c : composite.getChildren()) {
			if (c instanceof Composite) {
				disableButtonWithText((Composite) c, text);
			} else if (c instanceof Button) {
				if (((Button) c).getText() != null
						&& ((Button) c).getText().contains(text)) {
					c.setEnabled(false);
				}
			}
		}
	}

	private void hideButtonWithText(Composite composite, String text) {
		for (Control c : composite.getChildren()) {
			if (c instanceof Composite) {
				hideButtonWithText((Composite) c, text);
			} else if (c instanceof Button) {
				if (((Button) c).getText() != null
						&& ((Button) c).getText().contains(text)) {
					c.setVisible(false);
				}
			}
		}
	}
	
	private void disableDefaultValueField(Composite composite) {
		for (int i = 0; i < composite.getChildren().length; i++) {
			Control c = composite.getChildren()[i];
			if (c instanceof Text) {
				if (c.getLayoutData() instanceof FormData) {
					FormData data = (FormData) c.getLayoutData();
					if (data.top.control != null) {
						c.setEnabled(false);
					}
				}
			} else if (c instanceof Composite) {
				disableDefaultValueField((Composite) c);
			}
		}
	}

	@Override
	protected Composite createContents(Composite parent) {
		disableAllToolbar(parent.getParent());
		hideButtonWithText(parent.getParent(), "..."); //$NON-NLS-1$
		disableButtonWithText(parent.getParent(), "Conjugated"); //$NON-NLS-1$
		disableDefaultValueField(parent.getParent());
		disableCreateElementMenuFromTable(parent.getParent());
		return null;
	}
}
