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


package com.zeligsoft.ce.tableeditor;

import java.util.ArrayList;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;

/**
 * Label provider for the tree table. It displays the name of the deployment parts at their correct depth.  This is where cell contents and look and feel can be
 * customized.
 * 
 * @author sduchesneau
 *
 */
public class HorizontalTreeTableLabelProvider implements ITableEditorProvider, INotifyChangedListener
{

	private TableEditor editor;
	private HorizontalTreeTableContentProvider contentProvider;
	private ILabelProvider labelProvider;
	
	private byte[] minusMask;
	private byte[] plusMask;
	
	// map between the objects and the cashed image
	private ArrayList<Image> cachedImageList;
	private ArrayList<Integer> indexMap;
	
	private boolean needUpdate;
	
	final int ICON_SIZE = 16;	
	
	public HorizontalTreeTableLabelProvider(TableEditor editor, HorizontalTreeTableContentProvider contentProvider, ILabelProvider labelProvider)
	{
		this.editor = editor;
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
		
		minusMask = createMinusMask();
		plusMask = createPlusMask();		
		
		cachedImageList = new ArrayList<Image>();
		indexMap = new ArrayList<Integer>();
		
		needUpdate = true;		
	}

	/**
	 * Display the name of the deployment part at its proper depth.
	 */
	public String getColumnText(Object object, int columnIndex)
	{	

		try
		{
			String[] columnIds = (String[]) editor.getColumnIds();		
			Object columnObject = editor.getColumnObject(columnIds[columnIndex]);
			
			Integer integer = (Integer) object;  // the object is an integer representing the row we are on
		
			if (integer.intValue() == contentProvider.getElementDepth(columnObject))  // if our row is the same as the depth, display me
			{
				return labelProvider.getText(columnObject);
			}
		}
		catch(Exception ex)
		{
			// when changing input, the label provider won't be in sync with the table editor
			// but we don't care since the table editor is updated immediately after the change
			// of inputs anyway		
		}

		return "";
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose()
	{
	}
	
	
	private byte[] createMinusMask()
	{
		byte[] mask = new byte[32];                         
		
		mask[0] = (byte) 0x00; mask[1] = (byte) 0x00; // row 0
		mask[2] = (byte) 0x00; mask[3] = (byte) 0x00;
		mask[4] = (byte) 0x00; mask[5] = (byte) 0x00;
		mask[6] = (byte) 0x00; mask[7] = (byte) 0x00;
		
		mask[7] = (byte) 0x00; mask[8] = (byte) 0x00;// row 4
		mask[8] = (byte) 0x00; mask[9] = (byte) 0x00; 
		mask[12] = (byte) 0x03; mask[13] = (byte) 0xfe;
		mask[14] = (byte) 0x02; mask[15] = (byte) 0x02;

		mask[16] = (byte) 0x02; mask[17] = (byte) 0x02;// row 8
		mask[18] = (byte) 0x02; mask[19] = (byte) 0x02; 
		mask[20] = (byte) 0x02; mask[21] = (byte) 0xfa;
		mask[22] = (byte) 0x02; mask[23] = (byte) 0x02;

		mask[24] = (byte) 0x02; mask[25] = (byte) 0x02;// row 12
		mask[26] = (byte) 0x02; mask[27] = (byte) 0x02; 
		mask[28] = (byte) 0x03; mask[29] = (byte) 0xfe;
		mask[30] = (byte) 0x00; mask[31] = (byte) 0x00;
		
		return mask;	
	}
	
	private byte[] createPlusMask()
	{
		byte[] plusMask = new byte[32];
		byte[] minusMask =  createMinusMask();
		for (int i=0; i<32; i++)
			plusMask[i] = minusMask[i];
		
		plusMask[16] = (byte) 0x02; plusMask[17] = (byte) 0x22;
		plusMask[18] = (byte) 0x02; plusMask[19] = (byte) 0x22;
		
		plusMask[22] = (byte) 0x02; plusMask[23] = (byte) 0x22;
		plusMask[24] = (byte) 0x02; plusMask[25] = (byte) 0x22;
		
		return plusMask;		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex)
	{
		try
		{

			if (element instanceof Integer)
			{
				Integer integer = (Integer) element;
				
				String[] columnIds = (String[]) editor.getColumnIds();
				if (columnIndex >= columnIds.length)
					return null;
				
				Object columnObject = editor.getColumnObject(columnIds[columnIndex]);
			
				if (integer.intValue() == contentProvider.getElementDepth(columnObject)) 
				{
					if (needUpdate == false)
					{
						// the cached image list is updated so just return the cached item	
						int index = indexMap.indexOf(columnIndex);
						if (index == -1)
							return null; // not updated yet
						
						return cachedImageList.get(index);
					}
					else
					{
						if (columnIndex == 0)
						{
							// the label provider should be updated and this is the first element
							// so clear the list
							cachedImageList = new ArrayList<Image>();
							indexMap = new ArrayList<Integer>();
						}
						
						if (columnIndex == editor.getColumnIds().length - 1)
						{
							// this is the last item so tell the content provider that we are up to date
							needUpdate = false;						
						}
					}
					
					Image colIcon = labelProvider.getImage(columnObject);
					ImageData colImageData = null;
					PaletteData palette = null;
					int tmpIconWidth = ICON_SIZE;
					int numIcons = 1;
					
					if (colIcon != null)
					{
						// if the column icon exists, then we will have 2 icons back to back
						colImageData = colIcon.getImageData();
						palette = colImageData.palette;
						tmpIconWidth = ICON_SIZE*2;
						numIcons = 2;
					}
					
					// if we don't have a palette (because we have no column icon) then we must create one
					if (palette == null)
				    	palette = new PaletteData(0xff000000, 0xff0000, 0xff00);
					
					// this creates the icon, this must be recreated all the time since the palette could 
					// change between column objects
					int[] greyAndBlackBoxImageData = new int[ICON_SIZE*ICON_SIZE];
					for (int i=0; i<ICON_SIZE; i++)
					{
						for (int j=0; j<ICON_SIZE; j++)
						{
							if (i == 6 || i == 14 || j == 6 || j == 14) // TODO add comment
							{
								RGB rgb = new RGB(128, 128, 128); // grey
								greyAndBlackBoxImageData[i*16+j] = palette.getPixel(rgb);
							}
							else
							{
								RGB rgb = new RGB(0, 0, 0);  // black
								greyAndBlackBoxImageData[i*16+j] = palette.getPixel(rgb);
							}				
						}			
					}
					
					
					byte[] pmMaskData = null; 
					
					if (contentProvider.getChildren(columnObject).length > 0)						
					{	// I have children so I can be expanded or collapsed
						
						if (editor.isColumnVisible(columnIndex+1))
							pmMaskData = plusMask;
						else
							pmMaskData = minusMask;
					}
					else if (numIcons == 1)
					{
						// add null image to the cached list
						cachedImageList.add(null);
						indexMap.add(new Integer(columnIndex));
						return null;
					}			    
					
					// we create ImageData that will contain information about the image we are creating
					ImageData tmpImageData = new ImageData(tmpIconWidth, ICON_SIZE, 32, palette);					
					
					int[] pixels = new int[ICON_SIZE*2];
					byte[] maskData;
					
					if (numIcons == 2)
					{
						maskData = new byte[tmpIconWidth*2]; // width * 16 (height) / 8 (8bits in one byte) = width * 2
						
						// this copies the first mask in the first half of the icon mask and 
						// copies the second mask in the second half of the icon mask
						for (int i=0; i<ICON_SIZE; i++)
						{
							for (int j=0; j<4; j++)
							{
								if (j<2)
								{
									if (pmMaskData != null)
										maskData[i*4+j] = pmMaskData[i*2+j];									
									else
										maskData[i*4+j] = (byte) 0x00;
								}
								else
								{
									maskData[i*4+j] = colImageData.maskData[i*2+j-2];
								}
							}
						}							
					}
					else
					{
						maskData = pmMaskData;						
					}
					
					// here I set the mask and transparencies
					tmpImageData.maskData = maskData;
					if (colImageData != null)
					{
						tmpImageData.maskPad = colImageData.maskPad;
						tmpImageData.transparentPixel = colImageData.transparentPixel;
					}
					else
					{
						// if we didn't have a column icon, then I must provide this info
						tmpImageData.maskPad = 2;
						tmpImageData.transparentPixel = -1;						
					}

					// here I copy the icon or icons in a temporary image to be displayed
					for (int i=0; i<ICON_SIZE; i++)
					{
						// first copy the plus minus icon
						if (pmMaskData != null) 
						{
							for (int j=0; j<ICON_SIZE; j++)
							{
								pixels[j] = greyAndBlackBoxImageData[i*ICON_SIZE+j];
							}
						}
						
						// if it exists, copy the column icon
						if (colImageData != null)
							colImageData.getPixels(0, i, ICON_SIZE, pixels, ICON_SIZE);
	
						// set the temp image
						tmpImageData.setPixels(0, i, ICON_SIZE*numIcons, pixels, 0);						
					}						
	
					Image tmpIcon = new Image(null, tmpImageData);
					cachedImageList.add(tmpIcon);
					indexMap.add(new Integer(columnIndex));
					return tmpIcon;
				}
			}
		}
		catch(Exception ex)
		{
			// read comment in getColumnText			
		}
		
		return null;
	}

	/**
	 * nothing for now
	 */
	public void addListener(ILabelProviderListener listener)
	{
		
	}

	/**
	 * nothing for now
	 */
	public boolean isLabelProperty(Object element, String property)
	{
		return false;
	}
	
	/**
	 * nothing for now
	 */
	public void removeListener(ILabelProviderListener listener)
	{
	
	}

	/**
	 * nothing for now
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{	
	}
	
	/** 
	 * Returns the text/label of the object at a given index
	 */	
	public String getText(int index)
	{
		ArrayList<Object> objectList = contentProvider.getFlatListOfElements();
		return labelProvider.getText(objectList.get(index));		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableFontProvider#getFont(java.lang.Object, int)
	 */
	public Font getFont(Object element, int columnIndex)
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableColorProvider#getBackground(java.lang.Object, int)
	 */
	public Color getBackground(Object element, int columnIndex)
	{
		if (editor.getMouseColumn() < -1)
			return ColorConstants.white;
		
		if (editor.getMouseColumn() == columnIndex)
			return BackgroundColor.UberLightGray;
		else
			return ColorConstants.white;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableColorProvider#getForeground(java.lang.Object, int)
	 */
	public Color getForeground(Object element, int columnIndex)
	{
		return null;
	}

	public void notifyChanged(Notification notification)
	{
		needUpdate = true;
		
	}
}
