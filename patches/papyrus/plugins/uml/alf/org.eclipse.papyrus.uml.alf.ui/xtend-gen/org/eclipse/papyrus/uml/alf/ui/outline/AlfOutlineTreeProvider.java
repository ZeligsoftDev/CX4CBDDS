/**
 * Copyright (c) 2013, 2014 CEA LIST.
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
 * IJI - Initial implementation
 */
package org.eclipse.papyrus.uml.alf.ui.outline;

import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

/**
 * Customization of the default outline structure.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
@SuppressWarnings("all")
public class AlfOutlineTreeProvider extends DefaultOutlineTreeProvider {
  private static final String SUFFIX = "Impl";

  @Override
  protected Object _text(final Object modelElement) {
    String text = modelElement.getClass().getSimpleName();
    final int l = text.length();
    if (((l > AlfOutlineTreeProvider.SUFFIX.length()) && text.endsWith(AlfOutlineTreeProvider.SUFFIX))) {
      int _length = AlfOutlineTreeProvider.SUFFIX.length();
      int _minus = (l - _length);
      text = text.substring(0, _minus);
    }
    if ((modelElement instanceof Member)) {
      String _name = ((Member) modelElement).getDefinition().getName();
      String _plus = ((text + " ") + _name);
      text = _plus;
    } else {
      if ((modelElement instanceof QualifiedName)) {
        String _pathName = ((QualifiedName) modelElement).getPathName();
        String _plus_1 = ((text + " ") + _pathName);
        text = _plus_1;
      }
    }
    return text;
  }
}
