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
package com.zeligsoft.cx.ui.utils;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;

/**
 * Widget factory for CX Property Pages
 * 
 * @author ysroh
 * 
 */
public class CXWidgetFactory {

	public static final Color whiteColor = new Color(null, 255, 255, 255);

	public static final Color redColor = new Color(null, 255, 0, 0);

	public static final Image ADD_OBJECT_IMAGE = 
			PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);

	public static final Image DELETE_OBJECT_IMAGE = 
			PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);

	public static final Image EDIT_OBJECT_IMAGE = getWorkbenchImage(
			ZeligsoftCXUIPlugin.PLUGIN_ID, 
			"icons/obj16/edit_template.png"); //$NON-NLS-1$

	public static final Image FORWARD_NAV_IMAGE = 
			PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_FORWARD);

	public static final Image EDIT_WORKERCODE_IMAGE = getWorkbenchImage(
			ZeligsoftCXUIPlugin.PLUGIN_ID, "icons/obj16/segment_edit.png"); //$NON-NLS-1$
	
	public static final Image DELETE_ID_IMAGE = getWorkbenchImage(
			ZeligsoftCXUIPlugin.PLUGIN_ID, "icons/obj16/delete_template.png"); //$NON-NLS-1$
	
	public static final Image INSERT_ID_IMAGE = getWorkbenchImage(
			ZeligsoftCXUIPlugin.PLUGIN_ID, "icons/obj16/insert_template.png"); //$NON-NLS-1$

	public static final Image UP_NAV_IMAGE = new Image(
			FORWARD_NAV_IMAGE.getDevice(), rotate(
					FORWARD_NAV_IMAGE.getImageData(), SWT.LEFT));

	public static final Image DOWN_NAV_IMAGE = new Image(
			FORWARD_NAV_IMAGE.getDevice(), rotate(
					FORWARD_NAV_IMAGE.getImageData(), SWT.RIGHT));

	/**
	 * Creates Grid Composite
	 * 
	 * @param parent
	 * @param numColumn
	 * @return
	 */
	public static Composite createGridComposite(Composite parent, int numColumn) {
		return createGridComposite(parent, numColumn, GridData.FILL_BOTH);
	}

	/**
	 * Creates Grid Composite with given grid data style
	 * 
	 * @param parent
	 * @param numColumn
	 * @param gridStyle
	 * @return
	 */
	public static Composite createGridComposite(Composite parent,
			int numColumn, int gridStyle) {

		GridLayout layout = new GridLayout();
		layout.numColumns = numColumn;

		GridData data = new GridData(gridStyle);

		return createCustomComposite(parent, layout, data);

	}

	/**
	 * creates custom composite with given layout and layout data
	 * 
	 * @param parent
	 * @param layout
	 * @param data
	 * @return
	 */
	public static Composite createCustomComposite(Composite parent,
			Layout layout, Object data) {

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(layout);
		if (data != null) {
			composite.setLayoutData(data);
		}

		return composite;

	}

	/**
	 * creates grid composite where vertical spacing is set to 0
	 * 
	 * @param composite
	 * @param numColumn
	 * @param gridStyle
	 * @return
	 */
	public static Composite createFlatGridComposite(Composite composite,
			int numColumn, int gridStyle) {

		GridLayout layout = new GridLayout();
		layout.numColumns = numColumn;
		layout.verticalSpacing = 0;

		GridData data = new GridData(gridStyle);

		return createCustomComposite(composite, layout, data);

	}

	/**
	 * creates grid composite where vertical and horizontal spacing is set to 0
	 * 
	 * @param composite
	 * @param numColumn
	 * @param gridStyle
	 * @return
	 */
	public static Composite createNoMarginGridComposite(Composite composite,
			int numColumn, int gridStyle) {

		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = numColumn;

		GridData data = new GridData(gridStyle);

		return createCustomComposite(composite, layout, data);

	}

	/**
	 * Creates label with given background color
	 * 
	 * @param parent
	 * @param text
	 * @param background
	 * @return
	 */
	public static Label createLabel(Composite parent, String text,
			Color background) {
		Label label = new Label(parent, SWT.NULL);
		label.setText(text == null ? "" //$NON-NLS-1$
				: text);
		label.setBackground(background);
		return label;
	}

	/**
	 * Creates label
	 * 
	 * @param parent
	 * @param text
	 * @return
	 */
	public static Label createLabel(Composite parent, String text) {
		return createLabel(parent, text, parent.getBackground());
	}

	/**
	 * Creates custom button
	 * 
	 * @param parent
	 * @param buttonLabel
	 * @param buttonStyle
	 * @param layoutData
	 * @param listener
	 * @return
	 */
	public static Button createCustomButton(Composite parent,
			String buttonLabel, int buttonStyle, Object layoutData,
			SelectionListener listener) {
		Button button = new Button(parent, buttonStyle);
		button.setText(buttonLabel);
		button.setLayoutData(layoutData);
		if (listener != null)
			button.addSelectionListener(listener);

		return button;
	}

	/**
	 * creates push button
	 * 
	 * @param parent
	 * @param buttonLabel
	 * @param layoutData
	 * @param listener
	 * @return
	 */
	public static Button createPushButton(Composite parent, String buttonLabel,
			Object layoutData, SelectionListener listener) {

		return createCustomButton(parent, buttonLabel, SWT.PUSH, layoutData,
				listener);
	}

	/**
	 * creats check button
	 * 
	 * @param parent
	 * @param buttonLabel
	 * @param layoutData
	 * @return
	 */
	public static Button createCheckButton(Composite parent,
			String buttonLabel, Object layoutData) {

		return createCustomButton(parent, buttonLabel, SWT.CHECK, layoutData,
				null);
	}

	/**
	 * creates radio button
	 * 
	 * @param parent
	 * @param buttonLabel
	 * @param layoutData
	 * @return
	 */
	public static Button createRadioButton(Composite parent,
			String buttonLabel, Object layoutData) {

		return createCustomButton(parent, buttonLabel, SWT.RADIO, layoutData,
				null);
	}

	/**
	 * Creates an image button
	 * 
	 * @param parent
	 * @param image
	 * @return
	 */
	public static Button createImageButton(Composite parent, Image image) {
		Button button = new Button(parent, SWT.PUSH);
		button.setImage(image);

		return button;
	}

	/**
	 * Creates a toolbar button
	 * 
	 * @param parent
	 * @param image
	 * @return
	 */
	public static ToolBar createToolbarButton(Composite parent, Image image) {

		ToolBar toolbar = new ToolBar(parent, SWT.FLAT);
		toolbar.setLayoutData(new GridData());
		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 0;
		toolbar.setLayout(layout);
		toolbar.setBackground(parent.getBackground());
		ToolItem item = new ToolItem(toolbar, SWT.NONE);
		image.setBackground(parent.getBackground());
		item.setImage(image);

		return toolbar;
	}

	/**
	 * Queries the workbench image
	 * 
	 * @param imagePath
	 * @return
	 */
	public static Image getWorkbenchImage(String bundleId, String imagePath) {
		Bundle pluginBundle = Platform.getBundle(bundleId);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor
					.createFromURL(pluginBundle.getEntry(imagePath));
			Image image = imageDescriptor.createImage();
			return image;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * creates group composite with given label
	 * 
	 * @param parent
	 * @param label
	 * @param layoutData
	 * @return
	 */
	public static Group createGroup(Composite parent, String label,
			Object layoutData) {
		Group group = new Group(parent, SWT.NULL);
		group.setLayout(new GridLayout());
		group.setLayoutData(layoutData);
		group.setText(label);
		return group;

	}

	/**
	 * Queries the current active shell
	 * 
	 * @return
	 */
	protected static Shell getShell() {

		return Display.getCurrent().getActiveShell();

	}

	/**
	 * Rotate image using ImageData and keep the transparency
	 * 
	 * @param srcData
	 * @param direction
	 * @return
	 */
	public static ImageData rotate(ImageData srcData, int direction) {
		int bytesPerPixel = srcData.bytesPerLine / srcData.width;
		int destBytesPerLine = (direction == SWT.DOWN) ? srcData.width
				* bytesPerPixel : srcData.height * bytesPerPixel;
		byte[] newData = new byte[(direction == SWT.DOWN) ? srcData.height
				* destBytesPerLine : srcData.width * destBytesPerLine];
		int width = 0, height = 0;
		for (int srcY = 0; srcY < srcData.height; srcY++) {
			for (int srcX = 0; srcX < srcData.width; srcX++) {
				int destX = 0, destY = 0, destIndex = 0, srcIndex = 0;
				switch (direction) {
				case SWT.LEFT: // left 90 degrees
					destX = srcY;
					destY = srcData.width - srcX - 1;
					width = srcData.height;
					height = srcData.width;
					break;
				case SWT.RIGHT: // right 90 degrees
					destX = srcData.height - srcY - 1;
					destY = srcX;
					width = srcData.height;
					height = srcData.width;
					break;
				case SWT.DOWN: // 180 degrees
					destX = srcData.width - srcX - 1;
					destY = srcData.height - srcY - 1;
					width = srcData.width;
					height = srcData.height;
					break;
				}
				destIndex = (destY * destBytesPerLine)
						+ (destX * bytesPerPixel);
				srcIndex = (srcY * srcData.bytesPerLine)
						+ (srcX * bytesPerPixel);
				System.arraycopy(srcData.data, srcIndex, newData, destIndex,
						bytesPerPixel);
			}
		}
		ImageData newImageData = new ImageData(width, height, srcData.depth,
				srcData.palette, srcData.scanlinePad, newData);
		newImageData.transparentPixel = srcData.transparentPixel;
		return newImageData;
	}

}
