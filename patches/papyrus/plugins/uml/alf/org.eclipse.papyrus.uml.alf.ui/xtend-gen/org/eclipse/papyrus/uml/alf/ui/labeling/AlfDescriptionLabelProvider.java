/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jeremie Tatibouet - Initial Implementation
 */
package org.eclipse.papyrus.uml.alf.ui.labeling;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
@SuppressWarnings("all")
public class AlfDescriptionLabelProvider extends DefaultDescriptionLabelProvider {
  @Override
  public Image getImage(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
