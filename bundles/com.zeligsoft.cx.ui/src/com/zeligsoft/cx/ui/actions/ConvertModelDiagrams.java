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
package com.zeligsoft.cx.ui.actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.base.diagram.utils.BaseDiagramUtil;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;

/**
 * Convert coordinates in EMX file between logical and device pixel to help
 * migrate models between different platforms.
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("nls")
public class ConvertModelDiagrams implements IViewActionDelegate {

	private ISelection selection;

	private int sourceDPI;

	private double sourceScale = 1.0;

	public void run(IAction action) {
		if (selection == null) {
			return;
		}
		IResource resource = BaseUIUtil
				.getIResourceFromSelection((IStructuredSelection) selection);
		if (resource == null || !(resource instanceof IFile)) {
			return;
		}
		final IEclipsePreferences store = new InstanceScope()
				.getNode(ZeligsoftCXUIPlugin.PLUGIN_ID);
		String defaultValue = store.get(CXPreferenceConstants.SOURCE_DPI,
				UMLUtil.EMPTY_STRING);
		InputDialog dialog = new InputDialog(
				Display.getCurrent().getActiveShell(),
				"Model Diagram Conversion",
				"The DPI value of your platform is "
						+ String.valueOf(BaseDiagramUtil.getDPI())
						+ ". Please enter the DPI value of source platform where model diagrams are edited.",
				defaultValue, null);
		int dialogResult = dialog.open();
		if (dialogResult != Window.OK) {
			return;
		}
		try {
			sourceDPI = Integer.parseInt(dialog.getValue());
		} catch (NumberFormatException e) {
			ZeligsoftCXUIPlugin.getDefault().error(
					"Invalid number format for DPI value", e);
			return;
		}

		store.put(CXPreferenceConstants.SOURCE_DPI, dialog.getValue().trim());
		try {
			store.flush();
		} catch (BackingStoreException e) {
			// ignore
		}

		scaleModelDiagrams((IFile) resource);
		try {
			((IFile) resource).getParent().refreshLocal(
					IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			// do nothing
		}
	}

	private void scaleModelDiagrams(IFile file) {

		sourceScale = sourceDPI / BaseDiagramUtil.UNITS_PER_INCH;
		try {
			StringBuffer outputString = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					file.getContents()));
			String line = reader.readLine();
			while (line != null) {
				String trimmed = line.trim();
				if (trimmed.startsWith("<layoutConstraint ")) {
					Pattern p = Pattern.compile(".* x=\"(-?\\d+)\".*");
					Matcher m = p.matcher(line);
					if (m.matches()) {
						String value = m.group(1);
						try {
							int intValue = Integer.parseInt(value);
							int devPixelValue = convertValue(intValue);
							line = line.replaceFirst(" x=\"-?\\d+\"", " x=\""
									+ devPixelValue + "\"");
						} catch (NumberFormatException e) {
							// do nothing
						}
					}

					p = Pattern.compile(".* y=\"(-?\\d+)\".*");
					m = p.matcher(line);
					if (m.matches()) {
						String value = m.group(1);
						try {
							int intValue = Integer.parseInt(value);
							int devPixelValue = convertValue(intValue);
							line = line.replaceFirst(" y=\"-?\\d+\"", " y=\""
									+ devPixelValue + "\"");
						} catch (NumberFormatException e) {
							// do nothing
						}
					}

					p = Pattern.compile(".* width=\"(\\d+)\".*");
					m = p.matcher(line);
					if (m.matches()) {
						String value = m.group(1);
						try {
							int intValue = Integer.parseInt(value);
							int devPixelValue = -1;
							if (intValue != -1) {
								devPixelValue = convertValue(intValue);
							}
							line = line.replaceFirst(" width=\"\\d+\"",
									" width=\"" + devPixelValue + "\"");
						} catch (NumberFormatException e) {
							// do nothing
						}
					}

					p = Pattern.compile(".* height=\"(\\d+)\".*");
					m = p.matcher(line);
					if (m.matches()) {
						String value = m.group(1);
						try {
							int intValue = Integer.parseInt(value);
							int devPixelValue = -1;
							if (intValue != -1) {
								devPixelValue = convertValue(intValue);
							}
							line = line.replaceFirst(" height=\"\\d+\"",
									" height=\"" + devPixelValue + "\"");
						} catch (NumberFormatException e) {
							// do nothing
						}
					}
				} else if (trimmed.startsWith("<bendpoints ")) {
					Pattern p = Pattern.compile(".* points=\"([^\"]*)\".*");
					Matcher m = p.matcher(line);
					if (m.matches()) {
						String value = m.group(1);
						value = value.replace("[", "");
						value = value.replace("]", "");
						value = value.replace("$", ",");
						value = value.replaceAll(" *", "");
						String[] values = value.split(",");
						StringBuilder result = new StringBuilder();
						int i = 0;
						for (String val : values) {
							try {
								int mod = i % 4;
								if (mod == 0) {
									if (i != 0) {
										result.append("$");
									}
									result.append("[");
								}
								int intValue = Integer.parseInt(val);
								int devPixelValue = convertValue(intValue);
								result.append(Integer.toString(devPixelValue));
								if (mod == 0 || mod == 1 || mod == 2) {
									result.append(", ");
								}
								if (i % 4 == 3) {
									result.append("]");
								}
								i++;
							} catch (NumberFormatException e) {
								// do nothing
							}
						}
						int index = line.indexOf(" points=");
						line = line.substring(0, index + 9);
						line += result.toString() + "\"/>";
					}
				}
				outputString.append(line).append(
						System.getProperty("line.separator"));
				line = reader.readLine();
			}

			reader.close();
			File output = file.getLocation().toFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			writer.write(outputString.toString());
			writer.close();
		} catch (Exception e) {
			ZeligsoftCXUIPlugin.getDefault().error(
					"There was problem converting model diagrams", e);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;

	}

	private int convertValue(int val) {
		Point p = new Point(val, 0);
		p = p.scale(sourceScale);
		return BaseDiagramUtil.mapMode.DPtoLP(p.x);
	}

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub

	}
}
