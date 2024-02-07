/**
 * Copyright (c) 2012, 2018 Eclipse contributors and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 */
package org.eclipse.ocl.examples.emf.validation.validity.ui.ripoffs;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * A column label provider that delegates to a label provider and a label decorator.
 * <p>
 * Copied from org.eclipse.emf.edit.ui.provider.DecoratingColumLabelProvider to provide Juno support
 */
public class DecoratingColumnLabelProvider extends ColumnLabelProvider // implements IUndecoratingLabelProvider
{
  protected ILabelProvider labelProvider;
  protected IFontProvider fontProvider;
  protected IColorProvider colorProvider;
  protected ILabelDecorator labelDecorator;
  protected CellLabelProvider cellLabelProvider;

  public DecoratingColumnLabelProvider(ILabelProvider labelProvider, ILabelDecorator labelDecorator)
  {
    this.labelProvider = labelProvider;
    if (labelProvider instanceof IFontProvider)
    {
      this.fontProvider = (IFontProvider)labelProvider;
    }
    if (labelProvider instanceof IColorProvider)
    {
      this.colorProvider = (IColorProvider)labelProvider;
    }

    this.labelDecorator = labelDecorator;
    if (labelDecorator instanceof CellLabelProvider)
    {
      this.cellLabelProvider = (CellLabelProvider)labelDecorator;
    }
  }

  @Override
  public Font getFont(Object element)
  {
    return fontProvider == null ? null : fontProvider.getFont(element);
  }

  @Override
  public Color getBackground(Object element)
  {
    return colorProvider == null ? null : colorProvider.getBackground(element);
  }

  @Override
  public Color getForeground(Object element)
  {
    return colorProvider == null ? null : colorProvider.getForeground(element);
  }

  @Override
  public Image getImage(Object element)
  {
    return labelDecorator.decorateImage(labelProvider.getImage(element), element);
  }

  @Override
  public String getText(Object element)
  {
    return labelDecorator.decorateText(labelProvider.getText(element), element);
  }

  public Image getUndecoratedImage(Object element)
  {
    return labelProvider.getImage(element);
  }

  public String getUndecoratedText(Object element)
  {
    return labelProvider.getText(element);
  }

  @Override
  public Image getToolTipImage(Object object)
  {
    return cellLabelProvider == null ? null : cellLabelProvider.getToolTipImage(object);
  }

  @Override
  public String getToolTipText(Object element)
  {
    return cellLabelProvider == null ? null : cellLabelProvider.getToolTipText(element);
  }

  @Override
  public Color getToolTipBackgroundColor(Object object)
  {
    return cellLabelProvider == null ? null : cellLabelProvider.getToolTipBackgroundColor(object);
  }

  @Override
  public Color getToolTipForegroundColor(Object object)
  {
    return cellLabelProvider == null ? null : cellLabelProvider.getToolTipForegroundColor(object);
  }

  @Override
  public Font getToolTipFont(Object object)
  {
    return cellLabelProvider == null ? null : cellLabelProvider.getToolTipFont(object);
  }

  @Override
  public Point getToolTipShift(Object object)
  {
    return cellLabelProvider == null ? null : cellLabelProvider.getToolTipShift(object);
  }

  @Override
  public boolean useNativeToolTip(Object object)
  {
    return cellLabelProvider != null && cellLabelProvider.useNativeToolTip(object);
  }

  @Override
  public int getToolTipTimeDisplayed(Object object)
  {
    return cellLabelProvider == null ? 0 : cellLabelProvider.getToolTipTimeDisplayed(object);
  }

  @Override
  public int getToolTipDisplayDelayTime(Object object)
  {
    return cellLabelProvider == null ? 0 : cellLabelProvider.getToolTipDisplayDelayTime(object);
  }

  @Override
  public int getToolTipStyle(Object object)
  {
    return cellLabelProvider == null ? 0 : cellLabelProvider.getToolTipStyle(object);
  }

  @Override
  public void dispose()
  {
    super.dispose();
    labelProvider.dispose();
    labelDecorator.dispose();
  }

  @Override
  public boolean isLabelProperty(Object element, String property)
  {
    return labelProvider.isLabelProperty(element, property);
  }
}
